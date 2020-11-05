package com.epegase.forms.fondation;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FondationDemande;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FondationDemandeDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
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
import com.epegase.systeme.xml.ObjetReglement;
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
import org.xml.sax.SAXException;

public class FormDemandeFondation implements Serializable {
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
   private OptionVentes optionsVentes;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_timbre;
   private int var_nb_max = 100;
   private List mesSerieUserItem;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean visibleOnglet = false;
   private String var_libcondest;
   private boolean contDest = false;
   private boolean var_sansstock = false;
   private boolean var_pr_pv = false;
   private boolean var_aff_detail_prod = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private boolean existParapheur = false;
   private Tiers tiers;
   private TiersDao tiersDao;
   private String nomTier;
   private List lesFamilleClientsListe;
   private List lesModeReglementClientsListe;
   private String informationsTiers;
   private ServiceDao serviceDao;
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
   private ContactDao contactDao;
   private Contacts contacts;
   private List mesContactItem = new ArrayList();
   private FondationDemande fondationDemande = new FondationDemande();
   private FondationDemandeDao fondationDemandeDao;
   private List lesEntetesList = new ArrayList();
   private transient DataModel datamodelEntete = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean verrouNum = false;
   private boolean visibiliteBton = false;
   private boolean visibiliteBtonlig = true;
   private boolean visibleOngleEntete;
   private boolean var_aff_action = false;
   private boolean var_valide_doc = false;
   private double montantTtc = 0.0D;
   private double montantSolde = 0.0D;
   private double montantReglement = 0.0D;
   private double montantTtcElmt = 0.0D;
   private double montantSoldeElmt = 0.0D;
   private double montantReglementElmt = 0.0D;
   private int var_nb_ligne = 0;
   private boolean visibilitefactor = false;
   private boolean visibiliteterme = false;
   private boolean visibilitenbrjr = false;
   private boolean visibiliteencaissemt = false;
   private UtilDate utilDate = new UtilDate();
   private String conditRegtier;
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private transient DataModel datamodelDocumentTrace = new ListDataModel();
   private boolean showModalPanelValidationDocument = false;
   private long var_nom_responsable;
   private long var_nom_contact;
   private double var_total_marge;
   private List mesAffairesItems = new ArrayList();
   private String numeroPfManuel;
   private boolean showModalPanelAnnuler = false;
   private boolean showModalPanelGele = false;
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private int numLigne;
   private List mesTaxesVentesItems;
   private String inpNomTiersEnCours = "";
   private long inpIdTiersEnCours = 0L;
   private String inpNomDestinataire = "";
   private String inpSerie = "100";
   private String inpCat = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpClient = "";
   private String inpDestinataire = "";
   private String inpResponsable = "";
   private String inpCommercial = "";
   private String inpActivite = "100";
   private String inpDossier = "100";
   private String inpRegion = "";
   private String inpSecteur = "";
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
   private String montant_lettre;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_format_devise;
   private float var_coef_devise;
   private boolean verrouRemise = false;
   private boolean verrouPrvente = false;
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
   private DocumentTraceVentesDao documentTraceVentesDao;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private String devisePrint;
   private float tauxPrint;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean accesAffaires = false;
   private List mesCaissesItems = new ArrayList();
   private BonEncaissementVente bonEncaissementVente;
   private BonEncaissementVenteDao bonEncaissementVenteDao;
   private double var_tot_bon_encaissement;
   private boolean var_affiche_dollar = false;
   private boolean var_affiche_valide = false;
   private double montantElmTotBonEnc;
   private ReglementsDao reglementsDao;
   private boolean afficheRecu;
   private transient DataModel datamodelRecu = new ListDataModel();
   private boolean var_verouxModReg;
   private boolean var_affichMontant;
   private String var_inputCaisse;
   private double var_netAPayer;
   private boolean showModalPanelPaye = false;
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
   private UtilDownload utilDownload;
   private String fileName;
   private String urlphotoAgent;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private UploadedFile uploadedPDFFile;
   private String pdfFileName;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private transient DataModel dataModelDocumntsDemandeur = new ListDataModel();
   private transient DataModel dataModelDocumntsComite = new ListDataModel();
   private List lesDocumentsDemandeur = new ArrayList();
   private List lesDocumentsComite = new ArrayList();
   private String nomRepertoireDemandeur;
   private String nomRepertoireComite;
   private boolean showModalPanelPjDemandeur = false;
   private boolean showModalPanelPjComite = false;
   private boolean showModalPanelAjoutFileDemandeur = false;
   private boolean showModalPanelAjoutFileComite = false;
   private String nomDocument;

   public FormDemandeFondation() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.fondationDemandeDao = new FondationDemandeDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.documentTraceVentesDao = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes() {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if (this.optionsVentes.getDecrmtPrsChrStock() == null || this.optionsVentes.getDecrmtPrsChrStock().isEmpty()) {
         this.optionsVentes.setDecrmtPrsChrStock("0");
      }

      if (!this.structureLog.getStrtypeentreprise().contentEquals("1") && !this.structureLog.getStrtypeentreprise().contentEquals("3")) {
         this.var_sansstock = true;
      } else {
         this.var_sansstock = false;
      }

      if (this.optionsVentes.getDecrmtPrsChrStock().equalsIgnoreCase("1")) {
         this.contDest = false;
         this.var_libcondest = "Contact";
      } else if (this.optionsVentes.getDecrmtPrsChrStock().equalsIgnoreCase("2")) {
         this.contDest = true;
         this.var_libcondest = "Destinataire";
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

      if (this.optionsVentes.getAxeActivite().equals("1")) {
         this.var_anal_activite = true;
      } else {
         this.var_anal_activite = false;
      }

      if (this.optionsVentes.getAxeDossier().equals("1")) {
         this.var_anal_dossier = true;
         this.accesAffaires = false;
      } else if (this.optionsVentes.getAxeDossier().equals("2")) {
         this.accesAffaires = true;
         this.var_anal_dossier = false;
      } else {
         this.accesAffaires = false;
         this.var_anal_dossier = false;
      }

      if (this.optionsVentes.getAxeParc().equals("true")) {
         this.var_anal_parc = true;
      } else {
         this.var_anal_parc = false;
      }

      this.periode = this.optionsVentes.getAffichInGlobViewDEVIS();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.initPage();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      this.nomRepertoireDemandeur = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "fondation" + File.separator + "demandeur" + File.separator;
      this.nomRepertoireComite = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "fondation" + File.separator + "comite" + File.separator;
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrVerRemise() == 0) {
         this.verrouRemise = false;
      } else {
         this.verrouRemise = true;
      }

      if (this.usersLog.getUsrVerPv() == 0) {
         this.verrouPrvente = false;
      } else {
         this.verrouPrvente = true;
      }

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

   public void autorisationSuivi() {
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
      this.montantTtc = 0.0D;
      this.montantSolde = 0.0D;
      this.montantReglement = 0.0D;
      this.montantTtcElmt = 0.0D;
      this.montantSoldeElmt = 0.0D;
      this.montantReglementElmt = 0.0D;
      this.inpSerie = "100";
      this.inpCat = "100";
      this.inpService = "100";
      this.inpEtat = 0;
      this.lesEntetesList.clear();
      this.lesDecoupagesActivites.clear();
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.optionsVentes.getResponsable().equals("0")) {
         Object var2 = new ArrayList();
         if (this.usersLog.getUsrCommVentes() == 0) {
            var2 = this.usersDao.chargerLesUsers(var1);
         } else if (this.usersLog.getUsrCommVentes() == 1) {
            ResponsableDao var3 = new ResponsableDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var4 = var3.chargerLesResponsablesDocument(this.tiers, var1);
            if (var4.size() != 0) {
               new Responsable();

               for(int var6 = 0; var6 < var4.size(); ++var6) {
                  Responsable var5 = (Responsable)var4.get(var6);
                  new Users();
                  Users var7 = this.usersDao.selectByIdUsers(var5.getRpbuserid(), var1);
                  if (var7 != null) {
                     ((List)var2).add(var7);
                  }
               }
            } else {
               var2 = this.usersDao.chargerLesSignataires("Ventes", var1);
            }
         } else {
            ((List)var2).add(this.usersLog);
         }

         if (((List)var2).size() == 0) {
            ((List)var2).add(this.usersLog);
         }

         this.mesUsersItem.clear();
         if (this.usersLog.getUsrCommVentes() != 0 && this.usersLog.getUsrCommVentes() != 1) {
            this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         } else {
            for(int var8 = 0; var8 < ((List)var2).size(); ++var8) {
               Users var9 = (Users)((List)var2).get(var8);
               if (var9.getUsrVendeur() == 1 && var9.getUsrPatronyme() != null && !var9.getUsrPatronyme().isEmpty()) {
                  this.mesUsersItem.add(new SelectItem(var9.getUsrid(), var9.getUsrPatronyme()));
               }
            }

            if (this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
            }
         }
      }

   }

   public void chargerCommerciauxResponsable(Session var1) throws HibernateException, NamingException {
      this.lesEquipes.clear();
      this.lesEquipes = this.equipesDao.selectEquipes(var1);
      this.mesEquipeItem.clear();
      if (this.lesEquipes.size() != 0) {
         this.mesEquipeItem.add(new SelectItem(0, ""));

         for(int var2 = 0; var2 < this.lesEquipes.size(); ++var2) {
            this.mesEquipeItem.add(new SelectItem(((Equipes)this.lesEquipes.get(var2)).getEquCode() + ":" + ((Equipes)this.lesEquipes.get(var2)).getEquNomFr()));
         }
      }

      if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
         new ArrayList();
         List var6 = this.usersDao.chargerLesSignataires("Ventes", var1);
         this.mesUsersItem.clear();
         if (var6.size() != 0) {
            this.mesUsersItem.add(new SelectItem(0, ""));

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
            this.mesCommercialItem.add(new SelectItem(0, ""));

            for(int var8 = 0; var8 < var7.size(); ++var8) {
               Users var5 = (Users)var7.get(var8);
               if (var5.getUsrVendeur() == 1 && var5.getUsrPatronyme() != null && !var5.getUsrPatronyme().isEmpty()) {
                  this.mesCommercialItem.add(new SelectItem(var5.getUsrid(), var5.getUsrPatronyme()));
               }
            }
         }
      }

   }

   public void calculeResponsableLie() throws HibernateException, HibernateException, NamingException {
      this.calculeResponsableLie((Session)null);
   }

   public void calculeResponsableLie(Session var1) throws HibernateException, HibernateException, NamingException {
      if (this.optionsVentes.getResponsable().equals("1")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
         this.mesEquipeItem.clear();
         this.mesEquipeItem.add(new SelectItem(0, ""));
         this.var_nom_responsable = 0L;
         this.var_nom_equipe = 0L;
         if (this.var_nom_commercial != 0L && this.lesEquipes.size() != 0) {
            boolean var2 = false;

            for(int var3 = 0; var3 < this.lesEquipes.size(); ++var3) {
               this.equipes = (Equipes)this.lesEquipes.get(var3);
               int var5;
               if (this.equipes.getEquIdAgent() != null && !this.equipes.getEquIdAgent().isEmpty()) {
                  if (!this.equipes.getEquIdAgent().contains(":")) {
                     long var8 = Long.parseLong(this.equipes.getEquIdAgent());
                     if (this.var_nom_commercial == var8) {
                        this.var_nom_responsable = this.equipes.getEquIdResponsable();
                        this.mesUsersItem.clear();
                        this.mesUsersItem.add(new SelectItem(this.equipes.getEquIdResponsable(), this.equipes.getEquNomResponsable()));
                        this.var_nom_equipe = this.equipes.getEquId();
                        this.mesEquipeItem.clear();
                        this.mesEquipeItem.add(new SelectItem(this.equipes.getEquId(), this.equipes.getEquNomFr()));
                        var2 = true;
                     }
                  } else {
                     String[] var4 = this.equipes.getEquIdAgent().split(":");

                     for(var5 = 0; var5 < var4.length; ++var5) {
                        long var6 = Long.parseLong(var4[var5]);
                        if (this.var_nom_commercial == var6) {
                           this.var_nom_responsable = this.equipes.getEquIdResponsable();
                           this.mesUsersItem.clear();
                           this.mesUsersItem.add(new SelectItem(this.equipes.getEquIdResponsable(), this.equipes.getEquNomResponsable()));
                           this.var_nom_equipe = this.equipes.getEquId();
                           this.mesEquipeItem.clear();
                           this.mesEquipeItem.add(new SelectItem(this.equipes.getEquId(), this.equipes.getEquNomFr()));
                           var2 = true;
                           break;
                        }
                     }
                  }
               }

               if (var2) {
                  break;
               }

               if (this.mesUsersItem.size() <= 1) {
                  this.mesUsersItem.clear();
                  new ArrayList();
                  List var9 = this.usersDao.chargerLesSignataires("Ventes", var1);
                  if (var9.size() != 0) {
                     for(var5 = 0; var5 < var9.size(); ++var5) {
                        this.mesUsersItem.add(new SelectItem(((Users)var9.get(var5)).getUsrid(), ((Users)var9.get(var5)).getUsrPatronyme()));
                     }
                  }

                  if (this.mesUsersItem.size() == 0) {
                     this.mesUsersItem.clear();
                     this.mesUsersItem.add(new SelectItem(0, ""));
                  }
               }
            }
         }
      }

   }

   public void chargerLesSecteurs() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.inpRegion != null && !this.inpRegion.isEmpty()) {
         new Region();
         RegionDao var2 = new RegionDao(this.baseLog, this.utilInitHibernate);
         String[] var3 = this.inpRegion.split(":");
         Region var1 = var2.rechercheRegion(var3[0], (Session)null);
         if (var1 != null) {
            SecteurDao var4 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            this.mesSecteursItems = var4.listSecteurByRegionItem(var1, (Session)null);
         }
      }

   }

   public void chargerLesPdv() throws HibernateException, NamingException {
      this.mesPdvItems.clear();
      if (this.inpSecteur != null && !this.inpSecteur.isEmpty()) {
         new Secteur();
         SecteurDao var2 = new SecteurDao(this.baseLog, this.utilInitHibernate);
         String[] var3 = this.inpSecteur.split(":");
         Secteur var1 = var2.rechercheSecteur(var3[0], (Session)null);
         if (var1 != null) {
            PointDeVenteDao var4 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
            this.mesPdvItems = var4.listPdvBySecteurItem(var1, (Session)null);
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
      this.fondationDemande = this.fondationDemandeDao.pourParapheur(var1, (Session)null);
      if (this.fondationDemande != null) {
         this.devisePrint = this.fondationDemande.getFondemDevise();
      }

   }

   public void moreSearch() throws ParseException {
      this.selectDestinataire = false;
      this.inpRegion = "";
      this.inpSecteur = "";
      this.inpPdv = "";
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
      this.inpIdTiersEnCours = 0L;
      this.inpNomTiersEnCours = "";
      this.inpNomDestinataire = "";
      this.chargeListeDetail((Session)null);
   }

   public void executerRequete(Session var1) throws IOException, HibernateException, NamingException, ParseException {
      this.inpIdTiersEnCours = 0L;
      this.inpNomTiersEnCours = "";
      this.inpNomDestinataire = "";
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

   public void executerRequeteTiers() throws IOException, HibernateException, NamingException, ParseException {
      this.inpNomDestinataire = "";
      this.chargeListeDetail((Session)null);
   }

   public void executerRequeteDestinataire() throws IOException, HibernateException, NamingException, ParseException {
      this.inpIdTiersEnCours = 0L;
      this.inpNomTiersEnCours = "";
      this.inpDestinataire = this.inpNomDestinataire;
      this.chargeListeDetail((Session)null);
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
         List var12 = this.fondationDemandeDao.recherche(var1, this.exercicesVentes.getExevteId(), this.inpNum, this.inpIdTiersEnCours, this.inpClient, this.inpEtat, this.inpSerie, this.inpCat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.inpDestinataire, this.inpResponsable, this.inpCommercial, this.inpActivite, var10, var11, this.inpRegion, this.inpSecteur, this.inpPdv, this.inpSite, this.inpDepartement, this.inpService);
         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":") || this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":") || this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            boolean var19 = false;
            boolean var14 = false;
            boolean var15 = false;
            new FondationDemande();

            for(int var17 = 0; var17 < var12.size(); ++var17) {
               FondationDemande var16 = (FondationDemande)var12.get(var17);
               if (var16.getFondemActivite() != null && !var16.getFondemActivite().isEmpty()) {
                  if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
                     if (var16.getFondemActivite().contains(this.var_colonne1)) {
                        var19 = true;
                     } else {
                        var19 = false;
                     }
                  } else {
                     var19 = true;
                  }

                  if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
                     if (var16.getFondemActivite().contains(this.var_colonne2)) {
                        var14 = true;
                     } else {
                        var14 = false;
                     }
                  } else {
                     var14 = true;
                  }

                  if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
                     if (var16.getFondemActivite().contains(this.var_colonne3)) {
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
         new FondationDemande();

         for(var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            FondationDemande var18 = (FondationDemande)this.lesEntetesList.get(var13);
            var2 += var18.getFondemTotDebloque();
            var4 += var18.getFondemTotReglement();
            var6 += var18.getFondemTotDemande();
            var8 += var18.getFondemTotAccorde();
         }

         this.var_nb_ligne = this.lesEntetesList.size();
      }

      this.datamodelEntete.setWrappedData(this.lesEntetesList);
      this.totauxHt = var2;
      this.totauxHt = var6;
      this.totauxTaxe = var8;
      this.montantTtc = var2;
      this.montantReglement = var4;
      this.montantSolde = var2 - var4;
      this.visibiliteBton = false;
      this.inpNomTiersEnCours = "";
      this.inpIdTiersEnCours = 0L;
      this.inpNomDestinataire = "";
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
            this.fondationDemande = (FondationDemande)var1.get(0);
            this.inpNomTiersEnCours = this.fondationDemande.getFondemNomTiers();
            this.inpIdTiersEnCours = this.fondationDemande.getTiers().getTieid();
            this.inpNomDestinataire = this.fondationDemande.getFondemNomContact();
            this.var_date = this.fondationDemande.getFondemDate();
            if (this.fondationDemande.getFondemDate().getHours() <= 9) {
               this.var_heure = "0" + this.fondationDemande.getFondemDate().getHours();
            } else {
               this.var_heure = "" + this.fondationDemande.getFondemDate().getHours();
            }

            if (this.fondationDemande.getFondemDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.fondationDemande.getFondemDate().getMinutes();
            } else {
               this.var_minute = "" + this.fondationDemande.getFondemDate().getMinutes();
            }

            if (this.fondationDemande.getFondemDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.fondationDemande.getFondemDate().getSeconds();
            } else {
               this.var_seconde = "" + this.fondationDemande.getFondemDate().getSeconds();
            }

            this.tiers = this.fondationDemande.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.calculMessageLitige();
            this.numeroPfManuel = this.fondationDemande.getFondemAnal4();
            this.var_nom_contact = this.fondationDemande.getFondemIdContact();
            this.var_nom_responsable = this.fondationDemande.getFondemIdResponsable();
            this.var_nom_commercial = this.fondationDemande.getFondemIdCommercial();
            this.calculDevise();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Fondation");
            this.chargerBonEncaissement(var4);
            this.chargerLesContactsItem(var4);
            this.chargerUserChrono(var4);
            this.chargerLesUsers(var4);
            this.chargerParapheur(var4);
            this.chargerDocumentScan();
            this.chargerModeEcheanceAffichage();
            this.var_nom_responsable = this.fondationDemande.getFondemIdResponsable();
            this.var_nom_commercial = this.fondationDemande.getFondemIdCommercial();
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
               this.mesContactItem.add(new SelectItem(0, ""));
               this.var_nom_contact = 0L;
            }

            if (this.mesUsersItem == null || this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(0, ""));
               this.var_nom_responsable = 0L;
            }

            this.montantTtcElmt = this.fondationDemande.getFondemTotDebloque();
            this.montantReglementElmt = this.fondationDemande.getFondemTotReglement();
            this.montantElmTotBonEnc = this.fondationDemande.getFondemTotAccorde() - this.var_tot_bon_encaissement;
            this.montantSoldeElmt = this.fondationDemande.getFondemTotAccorde() - this.fondationDemande.getFondemTotReglement();
            this.numLigne = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
            this.utilInitHibernate.closeSession();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.fondationDemande != null) {
         if (this.fondationDemande.getFondemEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.fondationDemande.getFondemDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.fondationDemande.getFondemDevise());
      }

   }

   public void chargerAffaires(Session var1) throws HibernateException, NamingException {
      this.mesAffairesItems.clear();
      if (this.fondationDemande != null && this.fondationDemande.getFondemEtat() != 0) {
         this.mesAffairesItems.add(new SelectItem(this.fondationDemande.getFondemAnal4(), this.fondationDemande.getFondemAnal4()));
      } else {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesAffairesItems = var2.chargerLesAffairesByTiers(this.tiers.getTieid(), this.nature, var1);
      }

   }

   public void chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.fondationDemande.getFondemId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      this.afficheRecu = false;
      new ArrayList();
      List var5 = this.reglementsDao.reglementDocument(this.fondationDemande.getFondemId(), this.nature, var1);
      if (var5.size() != 0) {
         this.afficheRecu = false;

         for(int var4 = 0; var4 < var5.size(); ++var4) {
            this.var_tot_bon_encaissement += ((Reglements)var5.get(var4)).getRglRecette();
         }
      }

      this.datamodelRecu.setWrappedData(var5);
      if (this.var_tot_bon_encaissement < this.fondationDemande.getFondemTotAccorde()) {
         this.var_affiche_dollar = true;
      } else {
         this.var_affiche_dollar = false;
      }

   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.fondationDemande != null && this.fondationDemande.getFondemSerie() != null && !this.fondationDemande.getFondemSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.fondationDemande.getFondemSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.fondationDemande.getFondemId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerDocumentScan() throws IOException {
      this.lesDocumentsDemandeur.clear();
      File var1;
      String var2;
      String[] var3;
      int var4;
      if (this.nomRepertoireDemandeur != null && !this.nomRepertoireDemandeur.isEmpty()) {
         var1 = new File(this.nomRepertoireDemandeur);
         if (!var1.exists()) {
            var1.mkdir();
         }

         var2 = this.fondationDemande.getFondemNum().replace("/", "_");
         var3 = var1.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if ((var3[var4].endsWith(".pdf") || var3[var4].endsWith(".PDF")) && var3[var4].startsWith(var2)) {
                  this.lesDocumentsDemandeur.add(var3[var4]);
               }
            }
         }
      }

      this.dataModelDocumntsDemandeur.setWrappedData(this.lesDocumentsDemandeur);
      this.lesDocumentsComite.clear();
      if (this.nomRepertoireComite != null && !this.nomRepertoireComite.isEmpty()) {
         var1 = new File(this.nomRepertoireComite);
         if (!var1.exists()) {
            var1.mkdir();
         }

         var2 = this.fondationDemande.getFondemNum().replace("/", "_");
         var3 = var1.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if ((var3[var4].endsWith(".pdf") || var3[var4].endsWith(".PDF")) && var3[var4].startsWith(var2)) {
                  this.lesDocumentsComite.add(var3[var4]);
               }
            }
         }
      }

      this.dataModelDocumntsComite.setWrappedData(this.lesDocumentsComite);
   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.fondationDemande.getFondemActivite() != null && !this.fondationDemande.getFondemActivite().isEmpty() && this.fondationDemande.getFondemActivite().contains(":")) {
         String[] var1 = null;
         if (!this.fondationDemande.getFondemActivite().contains("#")) {
            var1 = this.fondationDemande.getFondemActivite().split(":");
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
            String[] var2 = this.fondationDemande.getFondemActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.fondationDemande.getFondemTotDemande() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.fondationDemande.getFondemTotDemande() - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         if (var1 != 0.0F) {
            this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(100.0F - var1);
         }

         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException {
      this.fondationDemande = new FondationDemande();
      this.fondationDemande.setUsers(this.usersLog);
      this.fondationDemande.setFondemIdCreateur(this.usersLog.getUsrid());
      this.fondationDemande.setFondemNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.fondationDemande.setFondemDate(new Date());
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

      boolean var1 = false;
      int var3;
      if (this.optionsVentes.getNbrJrRelanceDEVIS() != null && !this.optionsVentes.getNbrJrRelanceDEVIS().isEmpty()) {
         var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceDEVIS());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionsVentes.getNbrJrValidDEVIS() != null && !this.optionsVentes.getNbrJrValidDEVIS().isEmpty()) {
         var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidDEVIS());
      } else {
         var4 = 0;
      }

      this.fondationDemande.setFondemDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.fondationDemande.setFondemDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
      this.fondationDemande.setFondemBanque(this.structureLog.getStrBanqueDefaut());
      this.var_nom_responsable = 0L;
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      } else if (this.usersLog.getUsrCommVentes() == 2) {
         this.mesCommercialItem.clear();
         this.fondationDemande.setFondemIdCommercial(this.usersLog.getUsrid());
         this.fondationDemande.setFondemNomCommercial(this.usersLog.getUsrPatronyme());
         this.mesCommercialItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         this.var_nom_commercial = this.usersLog.getUsrid();
         this.calculeResponsableLie();
      } else {
         this.fondationDemande.setFondemIdResponsable(this.usersLog.getUsrid());
         this.fondationDemande.setFondemNomResponsable(this.usersLog.getUsrPatronyme());
      }

      this.mesAffairesItems.clear();
      this.var_action = 1;
      this.informationsTiers = null;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.var_valide_doc = false;
      this.var_aff_detail_tiers = false;
      this.verrouNum = false;
      this.var_typeTiers = true;
      this.visibleOnglet = false;
      this.visibiliteBtonlig = true;
      this.visibilitefactor = false;
      this.visibiliteterme = false;
      this.visibilitenbrjr = false;
      this.visibiliteencaissemt = false;
      this.selectDestinataire = true;
      this.var_total_marge = 0.0D;
      this.numLigne = 0;
      this.numeroPfManuel = "";
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.autorisationDocument();
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.fondationDemande != null) {
         this.var_action = 1;
         this.var_memo_action = this.var_action;
         this.var_aff_action = false;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         if (this.usersLog.getUsrSignatureVentes() != 1 && this.var_nom_responsable != 0L) {
            this.mesUsersItem.clear();
            this.mesUsersItem.add(new SelectItem(this.fondationDemande.getFondemIdResponsable(), this.fondationDemande.getFondemNomResponsable()));
         }

         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
      }

   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.fondationDemande != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.fondationDemande.getFondemIdResponsable(), this.fondationDemande.getFondemNomResponsable()));
         if (this.accesAffaires) {
            this.chargerAffaires((Session)null);
         } else {
            this.mesAffairesItems.clear();
         }

         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.fondationDemande != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Fondation");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.fondationDemande.getFondemEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.fondationDemande.setFondemEtat(1);
               this.fondationDemande.setFondemDateValide(new Date());
               this.fondationDemande = this.fondationDemandeDao.modif(this.fondationDemande, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle devis (C.) N° " + this.fondationDemande.getFondemNum() + " du " + this.utilDate.dateToStringSQLLight(this.fondationDemande.getFondemDate()));
               this.espionDao.mAJEspion(var3, var1);
            }

            if (this.tiers.getTieDteDocument1() == null || this.fondationDemande.getFondemDate().after(this.tiers.getTieDteDocument1())) {
               this.tiers.setTieDteDocument1(this.fondationDemande.getFondemDate());
               this.tiers = this.tiersDao.modif(this.tiers, var1);
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
      if (this.fondationDemande != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Fondation");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.fondationDemande.getFondemEtat() == 1) {
               this.fondationDemande.setFondemEtat(0);
               this.fondationDemande.setFondemDateValide((Date)null);
               this.fondationDemande = this.fondationDemandeDao.modif(this.fondationDemande, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle devis (C.) N° " + this.fondationDemande.getFondemNum() + " du " + this.utilDate.dateToStringSQLLight(this.fondationDemande.getFondemDate()));
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

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.fondationDemande != null) {
         this.fondationDemande.setFondemEtat(0);
         this.fondationDemande.setFondemDateAnnule((Date)null);
         this.fondationDemande.setFondemMotifAnnule("");
         this.fondationDemande = this.fondationDemandeDao.modif(this.fondationDemande);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.fondationDemande != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.fondationDemande.getFondemNum();
            Date var4 = this.fondationDemande.getFondemDate();
            this.lesEntetesList.remove(this.fondationDemande);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.utilParapheur.supprimerParapheur(this.fondationDemande.getFondemId(), this.nature, var1);
            this.fondationDemandeDao.delete(this.fondationDemande.getFondemId(), var1);
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Suppression Devis N° " + var3 + " du " + var4);
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

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.fondationDemande != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Fondation");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.fondationDemande.setExerciceventes(this.exercicesVentes);
            this.fondationDemande.setUsers(this.usersLog);
            this.fondationDemande.setFondemIdCreateur(this.usersLog.getUsrid());
            this.fondationDemande.setFondemNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.fondationDemande.setFondemDate(new Date());
            this.fondationDemande.setFondemDateCreat(new Date());
            this.fondationDemande.setFondemDateModif((Date)null);
            this.fondationDemande.setFondemIdModif(0L);
            this.fondationDemande.setFondemNomModif("");
            this.fondationDemande.setFondemNum("");
            this.fondationDemande.setFondemIdResponsable(this.usersLog.getUsrid());
            this.fondationDemande.setFondemNomResponsable(this.usersLog.getUsrPatronyme());
            boolean var3 = false;
            int var12;
            if (this.optionsVentes.getNbrJrRelanceDEVIS() != null && !this.optionsVentes.getNbrJrRelanceDEVIS().isEmpty()) {
               var12 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceDEVIS());
            } else {
               var12 = 0;
            }

            boolean var4 = false;
            int var13;
            if (this.optionsVentes.getNbrJrValidDEVIS() != null && !this.optionsVentes.getNbrJrValidDEVIS().isEmpty()) {
               var13 = Integer.parseInt(this.optionsVentes.getNbrJrValidDEVIS());
            } else {
               var13 = 0;
            }

            this.fondationDemande.setFondemDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var12));
            this.fondationDemande.setFondemDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var13));
            if (!this.fondationDemande.getFondemSerie().equalsIgnoreCase("X") && !this.fondationDemande.getFondemSerie().isEmpty()) {
               this.fondationDemande.setFondemNum(this.calculChrono.numCompose(this.fondationDemande.getFondemDate(), this.nature, this.fondationDemande.getFondemSerie(), var1));
            } else {
               long var5 = this.fondationDemandeDao.selectLastNum(var1);
               this.fondationDemande.setFondemNum("" + var5);
            }

            this.verifieExistenceHabilitation(var1);
            this.fondationDemande.setFondemDateAnnule((Date)null);
            this.fondationDemande.setFondemMotifAnnule("");
            this.fondationDemande.setFondemDateImp((Date)null);
            this.fondationDemande.setFondemDateTransforme((Date)null);
            this.fondationDemande.setFondemEtat(0);
            this.fondationDemande = this.fondationDemandeDao.duppliquer(this.fondationDemande, var1);
            if (this.habilitation != null) {
               this.utilParapheur.majParapheur(this.nature, this.habilitation, this.fondationDemande.getFondemId(), this.fondationDemande.getFondemNum(), this.fondationDemande.getFondemNomTiers(), this.fondationDemande.getFondemDate(), this.fondationDemande.getFondemDevise(), this.fondationDemande.getFondemTotDemande() + this.fondationDemande.getFondemTotTc(), this.fondationDemande.getFondemModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.fondationDemande.getVar_format_devise(), 0, var1);
            }

            this.chargeListeDetail(var1);
            var2.commit();
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void razNumreoPortefeuille() {
      this.numeroPfManuel = "";
   }

   public void fusionnerDocument() throws NamingException, Exception {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      long var3 = 0L;

      for(int var5 = 0; var5 < this.lesEntetesList.size(); ++var5) {
         if (((FondationDemande)this.lesEntetesList.get(var5)).isVar_select_ligne()) {
            if (var3 == 0L) {
               var3 = ((FondationDemande)this.lesEntetesList.get(var5)).getTiers().getTieid();
            }

            if (((FondationDemande)this.lesEntetesList.get(var5)).getTiers().getTieid() == var3) {
               var1.add(this.lesEntetesList.get(var5));
               var2.add(((FondationDemande)this.lesEntetesList.get(var5)).getFondemNum());
            }
         }
      }

      if (var1.size() != 0) {
         Session var16 = this.utilInitHibernate.getOpenSession(this.baseLog, "Fondation");
         Transaction var6 = null;

         try {
            var6 = var16.beginTransaction();
            this.fondationDemande = (FondationDemande)var1.get(0);
            this.fondationDemande.setExerciceventes(this.exercicesVentes);
            this.fondationDemande.setUsers(this.usersLog);
            this.fondationDemande.setFondemIdCreateur(this.usersLog.getUsrid());
            this.fondationDemande.setFondemNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.fondationDemande.setFondemDate(new Date());
            this.fondationDemande.setFondemDateCreat(new Date());
            this.fondationDemande.setFondemDateModif((Date)null);
            this.fondationDemande.setFondemIdModif(0L);
            this.fondationDemande.setFondemNomModif("");
            this.fondationDemande.setFondemNum("");
            this.fondationDemande.setFondemIdResponsable(this.usersLog.getUsrid());
            this.fondationDemande.setFondemNomResponsable(this.usersLog.getUsrPatronyme());
            boolean var7 = false;
            int var17;
            if (this.optionsVentes.getNbrJrRelanceDEVIS() != null && !this.optionsVentes.getNbrJrRelanceDEVIS().isEmpty()) {
               var17 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceDEVIS());
            } else {
               var17 = 0;
            }

            boolean var8 = false;
            int var18;
            if (this.optionsVentes.getNbrJrValidDEVIS() != null && !this.optionsVentes.getNbrJrValidDEVIS().isEmpty()) {
               var18 = Integer.parseInt(this.optionsVentes.getNbrJrValidDEVIS());
            } else {
               var18 = 0;
            }

            this.fondationDemande.setFondemDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var17));
            this.fondationDemande.setFondemDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var18));
            if (!this.fondationDemande.getFondemSerie().equalsIgnoreCase("X") && !this.fondationDemande.getFondemSerie().isEmpty()) {
               this.fondationDemande.setFondemNum(this.calculChrono.numCompose(this.fondationDemande.getFondemDate(), this.nature, this.fondationDemande.getFondemSerie(), var16));
            } else {
               long var9 = this.fondationDemandeDao.selectLastNum(var16);
               this.fondationDemande.setFondemNum("" + var9);
            }

            this.verifieExistenceHabilitation(var16);
            this.fondationDemande.setFondemDateAnnule((Date)null);
            this.fondationDemande.setFondemMotifAnnule("");
            this.fondationDemande.setFondemDateImp((Date)null);
            this.fondationDemande.setFondemDateTransforme((Date)null);
            this.fondationDemande.setFondemEtat(0);
            this.fondationDemande = this.fondationDemandeDao.duppliquer(this.fondationDemande, var16);
            if (this.habilitation != null) {
               this.utilParapheur.majParapheur(this.nature, this.habilitation, this.fondationDemande.getFondemId(), this.fondationDemande.getFondemNum(), this.fondationDemande.getFondemNomTiers(), this.fondationDemande.getFondemDate(), this.fondationDemande.getFondemDevise(), this.fondationDemande.getFondemTotDemande() + this.fondationDemande.getFondemTotTc(), this.fondationDemande.getFondemModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var16), this.fondationDemande.getVar_format_devise(), 0, var16);
            }

            this.fondationDemande = this.fondationDemandeDao.modif(this.fondationDemande, var16);
            var6.commit();
         } catch (HibernateException var14) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var14;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.executerRequete();
      }

   }

   public void annule() throws HibernateException, NamingException {
      if (this.fondationDemande != null && this.fondationDemande.getFondemEtat() <= 1) {
         this.fondationDemande = this.fondationDemandeDao.modif(this.fondationDemande);
      }

      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void chargerModeEcheanceAffichage() {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      if (this.fondationDemande.getFondemTypeReg() != 0 && this.fondationDemande.getFondemTypeReg() != 3) {
         if (this.fondationDemande.getFondemTypeReg() != 1 && this.fondationDemande.getFondemTypeReg() != 2 && this.fondationDemande.getFondemTypeReg() != 10) {
            if (this.fondationDemande.getFondemTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.fondationDemande.getFondemModeReg())) {
         this.visibilitefactor = true;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      this.visibilitefactor = false;
      String var1 = "0";
      if (this.fondationDemande.getFondemModeReg() != null && !this.fondationDemande.getFondemModeReg().isEmpty() && this.fondationDemande.getFondemModeReg().contains(":")) {
         String[] var2 = this.fondationDemande.getFondemModeReg().split(":");
         var1 = var2[0];
      }

      new ObjetReglement();

      int var3;
      ObjetReglement var6;
      for(var3 = 0; var3 < this.lesModeReglementClientsListe.size(); ++var3) {
         var6 = (ObjetReglement)this.lesModeReglementClientsListe.get(var3);
         if (var6.getCategories().equals(var1)) {
            if (var6.getEcheances() == null || var6.getEcheances().isEmpty()) {
               var6.setEcheances("0");
            }

            this.fondationDemande.setFondemTypeReg(Integer.parseInt(var6.getEcheances()));
            this.fondationDemande.setFondemModeReg(var6.getCategories() + ":" + var6.getLibelles());
            this.fondationDemande.setFondemNbJourReg(0);
            this.fondationDemande.setFondemArrondiReg(0);
            break;
         }
      }

      if (this.fondationDemande.getFondemTypeReg() != 0 && this.fondationDemande.getFondemTypeReg() != 3) {
         if (this.fondationDemande.getFondemTypeReg() != 1 && this.fondationDemande.getFondemTypeReg() != 2 && this.fondationDemande.getFondemTypeReg() != 10) {
            if (this.fondationDemande.getFondemTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var3 = 0; var3 < this.lesModeReglementClientsListe.size(); ++var3) {
               var6 = (ObjetReglement)this.lesModeReglementClientsListe.get(var3);
               if (var6.getCategories().equals(var1)) {
                  this.fondationDemande.setFondemTypeReg(Integer.parseInt(var6.getEcheances()));
                  this.fondationDemande.setFondemModeReg(var6.getCategories() + ":" + var6.getLibelles());
                  int var4 = 0;
                  if (var6.getNbjours() != null && !var6.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var6.getNbjours());
                  }

                  this.fondationDemande.setFondemNbJourReg(var4);
                  int var5 = 0;
                  if (var6.getArrondis() != null && !var6.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var6.getArrondis());
                  }

                  this.fondationDemande.setFondemArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      if ("Factor".equalsIgnoreCase(this.fondationDemande.getFondemModeReg())) {
         this.visibilitefactor = true;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.fondationDemande.getFondemDate(), this.fondationDemande.getFondemTypeReg(), this.fondationDemande.getFondemNbJourReg(), this.fondationDemande.getFondemArrondiReg());
      this.fondationDemande.setFondemDateEcheReg(var1);
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
         if (this.fondationDemande.getFondemId() != 0L) {
            this.showModalPanelValidationDocument = true;
         } else {
            this.save();
         }
      }

   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Fondation");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.fondationDemande.setFondemDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         if (this.fondationDemande.getUsers() == null) {
            this.fondationDemande.setUsers(this.usersLog);
         }

         this.fondationDemande.setTiers(this.tiers);
         if ((this.fondationDemande.getFondemCat() == null || this.fondationDemande.getFondemCat().isEmpty()) && this.fondationDemande.getTiers().getTienomfamille() != null && !this.fondationDemande.getTiers().getTienomfamille().isEmpty()) {
            this.fondationDemande.setFondemCat(this.fondationDemande.getTiers().getTienomfamille());
         }

         if (!this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("022") && !this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.fondationDemande.setFondemCivilTiers("");
         } else {
            this.fondationDemande.setFondemCivilTiers(this.fondationDemande.getTiers().getTiecivilite());
         }

         if (!this.contDest) {
            if (this.fondationDemande.getFondemDiversTiers() == 99) {
               this.fondationDemande.setFondemIdContact(0L);
               this.fondationDemande.setFondemNomContact("");
               this.fondationDemande.setFondemCivilContact("");
            } else {
               new Contacts();
               Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var3 != null) {
                  this.fondationDemande.setFondemIdContact(var3.getConid());
                  this.fondationDemande.setFondemNomContact(var3.getConpatronyme());
                  this.fondationDemande.setFondemCivilContact(var3.getConcivilite());
               } else {
                  this.fondationDemande.setFondemIdContact(0L);
                  this.fondationDemande.setFondemNomContact("");
                  this.fondationDemande.setFondemCivilContact("");
               }
            }

            this.fondationDemande.setFondemTiersRegroupe(this.tiers.getTiesigle());
         }

         this.fondationDemande.setFondemIdResponsable(0L);
         this.fondationDemande.setFondemNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.fondationDemande.setFondemIdResponsable(var15.getUsrid());
            this.fondationDemande.setFondemNomResponsable(var15.getUsrPatronyme());
         }

         this.fondationDemande.setFondemIdCommercial(0L);
         this.fondationDemande.setFondemNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.fondationDemande.setFondemIdCommercial(var4.getUsrid());
               this.fondationDemande.setFondemNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.fondationDemande.setFondemIdEquipe(0L);
         this.fondationDemande.setFondemNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.fondationDemande.getFondemIdResponsable(), var1);
            if (this.equipes != null) {
               this.fondationDemande.setFondemIdEquipe(this.equipes.getEquId());
               this.fondationDemande.setFondemNomEquipe(this.equipes.getEquNomFr());
            }
         }

         if (this.var_timbre != 0) {
            int var16 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.fondationDemande.getFondemTotDemande() + this.fondationDemande.getFondemTotTc(), var16, this.fondationDemande.getFondemDevise(), this.fondationDemande.getFondemDate());
            double var7 = this.utilNombre.myRoundDevise(var5, this.fondationDemande.getFondemDevise());
            if (var7 != 0.0D) {
               String var9 = this.utilNombre.beginSimple(var7, this.fondationDemande.getFondemDevise());
               this.fondationDemande.setFondemFormule2(this.utilNombre.texteTimbre(this.structureLog, var9, var16, this.fondationDemande.getFondemDevise(), this.fondationDemande.getFondemDate()));
            }
         }

         if (this.accesAffaires) {
         }

         if (this.fondationDemande.getFondemId() != 0L) {
            if (this.fondationDemande.getFondemEtat() == 6) {
               if (this.fondationDemande.getFondemEtatVal() == 1) {
                  this.fondationDemande.setFondemEtat(0);
               } else {
                  this.fondationDemande.setFondemEtat(0);
               }
            }

            this.fondationDemande.setFondemDateModif(new Date());
            this.fondationDemande.setFondemIdModif(this.usersLog.getUsrid());
            this.fondationDemande.setFondemNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.fondationDemande = this.fondationDemandeDao.modif(this.fondationDemande, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;
         } else {
            this.fondationDemande.setExerciceventes(this.exercicesVentes);
            this.fondationDemande.setFondemDateCreat(new Date());
            this.fondationDemande.setFondemIdCreateur(this.usersLog.getUsrid());
            this.fondationDemande.setFondemNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (!this.fondationDemande.getFondemSerie().equalsIgnoreCase("X") && !this.fondationDemande.getFondemSerie().isEmpty()) {
               this.fondationDemande.setFondemNum(this.calculChrono.numCompose(this.fondationDemande.getFondemDate(), this.nature, this.fondationDemande.getFondemSerie(), var1));
               boolean var18 = false;

               label317:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label317;
                     }

                     new FondationDemande();
                     FondationDemande var19 = this.fondationDemandeDao.pourParapheurByNum(this.fondationDemande.getFondemNum(), this.fondationDemande.getFondemSerie(), var1);
                     if (var19 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.fondationDemande.setFondemNum(this.calculChrono.numCompose(this.fondationDemande.getFondemDate(), this.nature, this.fondationDemande.getFondemSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.fondationDemandeDao.selectLastNum(var1);
               this.fondationDemande.setFondemNum("" + var17);
            }

            this.fondationDemande.setFondemEtat(0);
            this.fondationDemande.setFondemEtatVal(0);
            this.fondationDemande.setFondemDateValide((Date)null);
            this.fondationDemande = this.fondationDemandeDao.insert(this.fondationDemande, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.fondationDemande);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.fondationDemande.getFondemId(), this.fondationDemande.getFondemNum(), this.fondationDemande.getFondemNomTiers(), this.fondationDemande.getFondemDate(), this.fondationDemande.getFondemDevise(), this.fondationDemande.getFondemTotDemande() + this.fondationDemande.getFondemTotTc(), this.fondationDemande.getFondemModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.fondationDemande.getVar_format_devise(), 0, var1);
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

   public void saveAttente() throws IOException, HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Fondation");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.fondationDemande.setFondemDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         if (this.fondationDemande.getUsers() == null) {
            this.fondationDemande.setUsers(this.usersLog);
         }

         this.fondationDemande.setTiers(this.tiers);
         if ((this.fondationDemande.getFondemCat() == null || this.fondationDemande.getFondemCat().isEmpty()) && this.fondationDemande.getTiers().getTienomfamille() != null && !this.fondationDemande.getTiers().getTienomfamille().isEmpty()) {
            this.fondationDemande.setFondemCat(this.fondationDemande.getTiers().getTienomfamille());
         }

         if (!this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.fondationDemande.getTiers().getTiegenre().equalsIgnoreCase("037")) {
            this.fondationDemande.setFondemCivilTiers("");
         } else {
            this.fondationDemande.setFondemCivilTiers(this.fondationDemande.getTiers().getTiecivilite());
         }

         if (!this.contDest) {
            if (this.fondationDemande.getFondemDiversTiers() == 99) {
               this.fondationDemande.setFondemIdContact(0L);
               this.fondationDemande.setFondemNomContact("");
               this.fondationDemande.setFondemCivilContact("");
            } else {
               new Contacts();
               Contacts var3 = this.contactDao.recupererContacts(this.var_nom_contact, var1);
               if (var3 != null) {
                  this.fondationDemande.setFondemIdContact(var3.getConid());
                  this.fondationDemande.setFondemNomContact(var3.getConpatronyme());
                  this.fondationDemande.setFondemCivilContact(var3.getConcivilite());
               } else {
                  this.fondationDemande.setFondemIdContact(0L);
                  this.fondationDemande.setFondemNomContact("");
                  this.fondationDemande.setFondemCivilContact("");
               }
            }

            this.fondationDemande.setFondemTiersRegroupe(this.tiers.getTiesigle());
         } else {
            this.fondationDemande.setFondemIdContact(0L);
            this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.fondationDemande.getFondemNomContact(), var1);
            if (this.plansAnalytiques != null) {
               this.fondationDemande.setFondemTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            } else {
               this.fondationDemande.setFondemTiersRegroupe("");
            }
         }

         this.fondationDemande.setFondemIdResponsable(0L);
         this.fondationDemande.setFondemNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.fondationDemande.setFondemIdResponsable(var15.getUsrid());
            this.fondationDemande.setFondemNomResponsable(var15.getUsrPatronyme());
         }

         this.fondationDemande.setFondemIdCommercial(0L);
         this.fondationDemande.setFondemNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.fondationDemande.setFondemIdCommercial(var4.getUsrid());
               this.fondationDemande.setFondemNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.fondationDemande.setFondemIdEquipe(0L);
         this.fondationDemande.setFondemNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.fondationDemande.getFondemIdResponsable(), var1);
            if (this.equipes != null) {
               this.fondationDemande.setFondemIdEquipe(this.equipes.getEquId());
               this.fondationDemande.setFondemNomEquipe(this.equipes.getEquNomFr());
            }
         }

         if (this.var_timbre != 0) {
            int var16 = this.var_date.getYear() + 1900;
            double var5 = this.utilNombre.calculTimbre(this.structureLog, this.fondationDemande.getFondemTotDemande() + this.fondationDemande.getFondemTotTc(), var16, this.fondationDemande.getFondemDevise(), this.fondationDemande.getFondemDate());
            double var7 = this.utilNombre.myRoundDevise(var5, this.fondationDemande.getFondemDevise());
            if (var7 != 0.0D) {
               String var9 = this.utilNombre.beginSimple(var7, this.fondationDemande.getFondemDevise());
               this.fondationDemande.setFondemFormule2(this.utilNombre.texteTimbre(this.structureLog, var9, var16, this.fondationDemande.getFondemDevise(), this.fondationDemande.getFondemDate()));
            }
         }

         if (this.fondationDemande.getFondemTypeReg() == 0) {
            this.fondationDemande.setFondemConditionReg("Paiement comptant");
         } else if (this.fondationDemande.getFondemTypeReg() == 1) {
            this.fondationDemande.setFondemConditionReg("Paiement terme sur date de facture");
         } else if (this.fondationDemande.getFondemTypeReg() == 2) {
            this.fondationDemande.setFondemConditionReg("Paiement terme sur fin de mois");
         } else if (this.fondationDemande.getFondemTypeReg() == 3) {
            this.fondationDemande.setFondemConditionReg("Paiement arrivée/payé");
         } else if (this.fondationDemande.getFondemTypeReg() == 4) {
            this.fondationDemande.setFondemConditionReg("Paiement bon encaissement");
         } else if (this.fondationDemande.getFondemTypeReg() == 5) {
            this.fondationDemande.setFondemConditionReg("Paiement comptant, 50% à la commande, le solde à la livraison");
         }

         if (this.accesAffaires) {
         }

         if (this.fondationDemande.getFondemId() != 0L) {
            this.fondationDemande.setFondemEtat(6);
            this.fondationDemande.setFondemEtatVal(0);
            this.fondationDemande.setFondemDateValide((Date)null);
            this.fondationDemande.setFondemDateModif(new Date());
            this.fondationDemande.setFondemIdModif(this.usersLog.getUsrid());
            this.fondationDemande.setFondemNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.fondationDemande = this.fondationDemandeDao.modif(this.fondationDemande, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;
         } else {
            this.fondationDemande.setExerciceventes(this.exercicesVentes);
            this.fondationDemande.setFondemDateCreat(new Date());
            this.fondationDemande.setFondemIdCreateur(this.usersLog.getUsrid());
            this.fondationDemande.setFondemNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (!this.fondationDemande.getFondemSerie().equalsIgnoreCase("X") && !this.fondationDemande.getFondemSerie().isEmpty()) {
               this.fondationDemande.setFondemNum(this.calculChrono.numCompose(this.fondationDemande.getFondemDate(), this.nature, this.fondationDemande.getFondemSerie(), var1));
               boolean var18 = false;

               label332:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label332;
                     }

                     new FondationDemande();
                     FondationDemande var19 = this.fondationDemandeDao.pourParapheurByNum(this.fondationDemande.getFondemNum(), this.fondationDemande.getFondemSerie(), var1);
                     if (var19 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.fondationDemande.setFondemNum(this.calculChrono.numCompose(this.fondationDemande.getFondemDate(), this.nature, this.fondationDemande.getFondemSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.fondationDemandeDao.selectLastNum(var1);
               this.fondationDemande.setFondemNum("" + var17);
            }

            this.fondationDemande.setFondemEtat(6);
            this.fondationDemande.setFondemEtatVal(0);
            this.fondationDemande.setFondemDateValide((Date)null);
            this.fondationDemande = this.fondationDemandeDao.insert(this.fondationDemande, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.fondationDemande);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
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

   public void majAnalytique(Session var1) throws HibernateException, NamingException {
      this.fondationDemande.setFondemSite(this.usersLog.getUsrSite());
      this.fondationDemande.setFondemDepartement(this.usersLog.getUsrDepartement());
      this.fondationDemande.setFondemService(this.usersLog.getUsrService());
      if (this.contDest) {
         this.fondationDemande.setFondemIdContact(0L);
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.plansAnalytiques, (PlansAnalytiquesDao)null, this.fondationDemande.getFondemNomContact(), var1);
         if (this.plansAnalytiques != null) {
            this.fondationDemande.setFondemTiersRegroupe(this.plansAnalytiques.getAnaTiersRegroupe());
            this.fondationDemande.setFondemRegion(this.plansAnalytiques.getAnaTiersRegion());
            this.fondationDemande.setFondemSecteur(this.plansAnalytiques.getAnaTiersSecteur());
            this.fondationDemande.setFondemPdv(this.plansAnalytiques.getAnaTiersPdv());
         } else {
            this.fondationDemande.setFondemTiersRegroupe(this.tiers.getTiesigle());
            this.fondationDemande.setFondemRegion(this.tiers.getTieregion());
            this.fondationDemande.setFondemSecteur(this.tiers.getTiesecteur());
            this.fondationDemande.setFondemPdv(this.tiers.getTiepdv());
         }
      } else {
         this.fondationDemande.setFondemTiersRegroupe(this.tiers.getTiesigle());
         this.fondationDemande.setFondemRegion(this.tiers.getTieregion());
         this.fondationDemande.setFondemSecteur(this.tiers.getTiesecteur());
         this.fondationDemande.setFondemPdv(this.tiers.getTiepdv());
      }

      if (!this.var_anal_activite) {
         this.fondationDemande.setFondemActivite("");
      } else {
         String var2;
         boolean var3;
         if (this.optionsVentes.getActiviteEnteteLigne().equals("0")) {
            if (this.decoupageActivite) {
               var2 = "";
               var3 = true;
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

               this.fondationDemande.setFondemActivite(var2);
            }
         } else {
            var2 = "";
            var3 = true;
            new FondationDemande();
            new Produits();
            if (!this.decoupageActivite && !this.decoupageActivite) {
            }

            this.fondationDemande.setFondemActivite(var2);
         }
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.fondationDemande.setFondemAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.fondationDemande.getFondemAnal4() != null && this.fondationDemande.getFondemAnal4().length() <= 2) {
         this.fondationDemande.setFondemAnal4("");
      }

      if (!this.var_anal_parc) {
         this.fondationDemande.setFondemAnal2("");
      } else if (this.fondationDemande.getFondemAnal2() != null && this.fondationDemande.getFondemAnal2().length() <= 2) {
         this.fondationDemande.setFondemAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.fondationDemande.setFondemEtatVal(1);
         this.fondationDemande.setFondemEtat(0);
         this.fondationDemande.setFondemDateValide((Date)null);
         return true;
      } else {
         this.fondationDemande.setFondemEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.fondationDemande.setFondemEtat(1);
               this.fondationDemande.setFondemDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.fondationDemande.setFondemEtat(0);
               this.fondationDemande.setFondemDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void ajouterDocumentScanDemandeur() {
      this.uploadedPDFFile = null;
      if (this.utilDownload == null) {
         this.utilDownload = new UtilDownload();
      }

      this.nomDocument = "";
      this.showModalPanelAjoutFileDemandeur = true;
   }

   public void annulerDocumentScanDemandeur() {
      this.showModalPanelAjoutFileDemandeur = false;
   }

   public void validerDocumentScanDemandeur() {
      if (this.fondationDemande != null && this.uploadedPDFFile != null) {
         File var1 = new File(this.nomRepertoireDemandeur + this.fondationDemande.getFondemNum());
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
               var3 = this.fondationDemande.getFondemNum().replace("/", "_") + "_" + this.filtreCaracteres(this.nomDocument) + "." + var4;
            } else {
               var3 = this.fondationDemande.getFondemNum().replace("/", "_") + "." + var4;
            }

            File var5 = this.utilDownload.uniqueFile(new File(this.nomRepertoireDemandeur), var3);
            this.utilDownload.write(var5, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var3;
            this.lesDocumentsDemandeur.add(this.pdfFileName);
            this.dataModelDocumntsDemandeur.setWrappedData(this.lesDocumentsDemandeur);
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
         } catch (IOException var6) {
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var6.printStackTrace();
         }
      }

      this.showModalPanelAjoutFileDemandeur = false;
   }

   public void lectureDocDemandeur() throws MalformedURLException, IOException {
      if (this.dataModelDocumntsDemandeur.isRowAvailable()) {
         String var1 = (String)this.dataModelDocumntsDemandeur.getRowData();
         if (var1.endsWith(".pdf") || var1.endsWith(".PDF")) {
            this.nomDocument = var1;
            String var2 = this.nomRepertoireDemandeur + var1;
            if (var2 != null && !var2.isEmpty()) {
               this.consulterDocumentScanDemandeur(var2);
            }
         }
      }

   }

   public void consulterDocumentScanDemandeur(String var1) throws MalformedURLException, IOException {
      if (var1 != null && !var1.isEmpty()) {
         this.utilDownload = new UtilDownload();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(var1);
         this.showModalPanelPjDemandeur = true;
      }

   }

   public void fermerVisuDocumentScanDemandeur() {
      this.showModalPanelPjDemandeur = false;
   }

   public void supprimerDocumentScanDemandeur() {
      if (this.nomDocument != null && !this.nomDocument.isEmpty() && this.nomRepertoireDemandeur != null && !this.nomRepertoireDemandeur.isEmpty()) {
         String var1 = this.nomRepertoireDemandeur + this.nomDocument;
         File var2 = new File(var1);
         var2.delete();
         this.lesDocumentsDemandeur.remove(this.nomDocument);
         this.dataModelDocumntsDemandeur.setWrappedData(this.lesDocumentsDemandeur);
         this.showModalPanelPjDemandeur = false;
      }

   }

   public void ajouterDocumentScanComite() {
      this.uploadedPDFFile = null;
      if (this.utilDownload == null) {
         this.utilDownload = new UtilDownload();
      }

      this.nomDocument = "";
      this.showModalPanelAjoutFileComite = true;
   }

   public void annulerDocumentScanComite() {
      this.showModalPanelAjoutFileComite = false;
   }

   public void validerDocumentScanComite() {
      if (this.fondationDemande != null && this.uploadedPDFFile != null) {
         File var1 = new File(this.nomRepertoireComite + this.fondationDemande.getFondemNum());
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
               var3 = this.fondationDemande.getFondemNum().replace("/", "_") + "_" + this.filtreCaracteres(this.nomDocument) + "." + var4;
            } else {
               var3 = this.fondationDemande.getFondemNum().replace("/", "_") + "." + var4;
            }

            File var5 = this.utilDownload.uniqueFile(new File(this.nomRepertoireComite), var3);
            this.utilDownload.write(var5, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var3;
            this.lesDocumentsComite.add(this.pdfFileName);
            this.dataModelDocumntsComite.setWrappedData(this.lesDocumentsComite);
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
         } catch (IOException var6) {
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var6.printStackTrace();
         }
      }

      this.showModalPanelAjoutFileComite = false;
   }

   public void lectureDocComite() throws MalformedURLException, IOException {
      if (this.dataModelDocumntsComite.isRowAvailable()) {
         String var1 = (String)this.dataModelDocumntsComite.getRowData();
         if (var1.endsWith(".pdf") || var1.endsWith(".PDF")) {
            this.nomDocument = var1;
            String var2 = this.nomRepertoireComite + var1;
            if (var2 != null && !var2.isEmpty()) {
               this.consulterDocumentScanComite(var2);
            }
         }
      }

   }

   public void consulterDocumentScanComite(String var1) throws MalformedURLException, IOException {
      if (var1 != null && !var1.isEmpty()) {
         this.utilDownload = new UtilDownload();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(var1);
         this.showModalPanelPjComite = true;
      }

   }

   public void fermerVisuDocumentScanComite() {
      this.showModalPanelPjComite = false;
   }

   public void supprimerDocumentScanComite() {
      if (this.nomDocument != null && !this.nomDocument.isEmpty() && this.nomRepertoireComite != null && !this.nomRepertoireComite.isEmpty()) {
         String var1 = this.nomRepertoireComite + this.nomDocument;
         File var2 = new File(var1);
         var2.delete();
         this.lesDocumentsComite.remove(this.nomDocument);
         this.dataModelDocumntsComite.setWrappedData(this.lesDocumentsComite);
         this.showModalPanelPjComite = false;
      }

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

   public void annulerDocument() {
      if (this.fondationDemande != null) {
         this.fondationDemande.setFondemDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.fondationDemande != null) {
         if (this.fondationDemande.getFondemDateAnnule() == null) {
            this.fondationDemande.setFondemDateAnnule(new Date());
         }

         this.fondationDemande.setFondemEtat(3);
         this.fondationDemande = this.fondationDemandeDao.modif(this.fondationDemande);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation devis vente N° " + this.fondationDemande.getFondemNum() + " le " + this.fondationDemande.getFondemDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.fondationDemande);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void gelerDocument() {
      if (this.fondationDemande != null) {
         this.fondationDemande.setFondemDateAnnule(new Date());
         this.showModalPanelGele = true;
      }

   }

   public void annuleGeler() {
      this.showModalPanelGele = false;
   }

   public void miseajourGeler() throws HibernateException, NamingException {
      if (this.fondationDemande != null) {
         if (this.fondationDemande.getFondemDateAnnule() == null) {
            this.fondationDemande.setFondemDateAnnule(new Date());
         }

         this.fondationDemande.setFondemEtat(2);
         this.fondationDemande = this.fondationDemandeDao.modif(this.fondationDemande);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Geler devis vente N° " + this.fondationDemande.getFondemNum() + " le " + this.fondationDemande.getFondemDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.fondationDemande);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelGele = false;
      this.visibiliteBton = false;
   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.rechercheTiers(3, this.fondationDemande.getFondemNomTiers(), this.nature);
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
                     this.fondationDemande.setFondemSerie(this.tiers.getTieserie());
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
            this.fondationDemande.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.fondationDemande.setFondemCivilTiers("");
               this.var_typeTiers = true;
            } else {
               if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                  this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               } else {
                  this.nomTier = this.tiers.getTieraisonsocialenom();
               }

               this.fondationDemande.setFondemCivilTiers(this.fondationDemande.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.fondationDemande.setFondemNomTiers(this.nomTier);
            this.fondationDemande.setFondemTypeReg(this.tiers.getTietypereg());
            this.fondationDemande.setFondemModeReg(this.tiers.getTiemodereg());
            this.calculMessageLitige();
            String var8 = "";
            if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
               String[] var4 = this.tiers.getTiemodereg().split(":");
               var8 = var4[0];
            } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
               var8 = this.tiers.getTiemodereg();
            }

            int var5;
            if (!var8.equals("") && !var8.equals("100")) {
               this.fondationDemande.setFondemNbJourReg(this.tiers.getTienbecheance());
               this.fondationDemande.setFondemArrondiReg(this.tiers.getTienbarrondi());
            } else {
               new ObjetReglement();

               for(var5 = 0; var5 < this.lesModeReglementClientsListe.size(); ++var5) {
                  ObjetReglement var9 = (ObjetReglement)this.lesModeReglementClientsListe.get(var5);
                  if (var9.getDefaut().equals("true")) {
                     if (var9.getEcheances() == null || var9.getEcheances().isEmpty()) {
                        var9.setEcheances("0");
                     }

                     this.fondationDemande.setFondemTypeReg(Integer.parseInt(var9.getEcheances()));
                     this.fondationDemande.setFondemModeReg(var9.getCategories() + ":" + var9.getLibelles());
                     int var6 = 0;
                     if (var9.getNbjours() != null && !var9.getNbjours().isEmpty()) {
                        var6 = Integer.parseInt(var9.getNbjours());
                     }

                     this.fondationDemande.setFondemNbJourReg(var6);
                     int var7 = 0;
                     if (var9.getArrondis() != null && !var9.getArrondis().isEmpty()) {
                        var7 = Integer.parseInt(var9.getArrondis());
                     }

                     this.fondationDemande.setFondemArrondiReg(var7);
                     break;
                  }
               }
            }

            this.chargerModeEcheanceAffichage();
            this.fondationDemande.setFondemJournalReg(this.tiers.getTiejournalreg());
            this.fondationDemande.setFondemCat(this.tiers.getTienomfamille());
            this.fondationDemande.setFondemExoDouane(this.tiers.getTieexodouane());
            if (this.tiers.getTieexodouane() == 1) {
               this.fondationDemande.setFondemExoDouane(1);
            }

            this.fondationDemande.setFondemExoTva(this.tiers.getTieexotva());
            float var10 = 0.0F;
            if (this.lesFamilleClientsListe.size() != 0) {
               for(var5 = 0; var5 < this.lesFamilleClientsListe.size() && (this.fondationDemande.getFondemCat() == null || this.fondationDemande.getFondemCat().isEmpty() || !this.fondationDemande.getFondemCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var5)).getLibelle())); ++var5) {
               }
            }

            this.fondationDemande.setFondemTauxTc(var10);
            if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
               this.fondationDemande.setFondemExoTva(1);
            }

            if (this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
               this.fondationDemande.setFondemDiversTiers(99);
               this.var_pr_pv = false;
            } else {
               this.fondationDemande.setFondemDiversTiers(0);
               this.fondationDemande.setFondemDiversNom("");
               this.fondationDemande.setFondemDiversAdresse("");
               this.fondationDemande.setFondemDiversVille("");
               this.fondationDemande.setFondemDiversTel("");
               this.fondationDemande.setFondemDiversMail("");
               if (this.tiers.getTiefacpr() == 0) {
                  this.var_pr_pv = false;
               } else {
                  this.var_pr_pv = true;
               }
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.fondationDemande.setFondemDevise(this.tiers.getTiedevise());
            } else {
               this.fondationDemande.setFondemDevise(this.structureLog.getStrdevise());
            }

            this.mesContactItem.clear();
            if (!this.contDest) {
               this.chargerLesContactsItem(var1);
            } else if (this.contDest) {
            }

            this.chargerLesUsers(var1);
            if (this.accesAffaires) {
               this.chargerAffaires(var1);
            } else {
               this.mesAffairesItems.clear();
            }
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
      this.fondationDemande.setTiers(this.tiers);
      this.fondationDemande.setFondemNomTiers("");
      this.fondationDemande.setFondemCivilTiers("");
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      if (this.optionsVentes.getResponsable().equals("0")) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(0, ""));
      }

      this.mesAffairesItems.clear();
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void chargerLesContactsItem(Session var1) throws HibernateException, NamingException {
      this.mesContactItem = new ArrayList();
      this.mesContactItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var1);
   }

   public void controleSaisie() throws ParseException {
      if (!this.fondationDemande.getFondemNomTiers().equals("") && this.tiers.getTieid() != 0L) {
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.CalculDateEcheance();
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_tiers = false;
      }

   }

   public void recupererEltCat() throws HibernateException, NamingException {
      String var1 = "";
      String var2 = "";
      float var3 = 0.0F;
      if (this.lesFamilleClientsListe.size() != 0) {
         for(int var4 = 0; var4 < this.lesFamilleClientsListe.size(); ++var4) {
            if (this.fondationDemande.getFondemCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var4)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var4)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var4)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2 && this.tiers.getTieexotva() != 1) {
         this.fondationDemande.setFondemExoTva(0);
      } else {
         this.fondationDemande.setFondemExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && this.tiers.getTieexodouane() != 1) {
         this.fondationDemande.setFondemExoDouane(0);
      } else {
         this.fondationDemande.setFondemExoDouane(1);
      }

      this.fondationDemande.setFondemTauxTc(var3);
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

   public void rechercheDestinataire() throws JDOMException, IOException, HibernateException, NamingException {
      if (!this.selectDestinataire) {
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.inpDestinataire, this.nature);
      } else {
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.fondationDemande.getFondemNomContact(), this.nature);
      }

      if (this.plansAnalytiques != null) {
         if (this.plansAnalytiques.getAnaId() != 0L) {
            this.calculeDestinataire();
         } else {
            this.var_action = 10;
         }
      } else if (this.plansAnalytiques == null) {
         this.annuleDestinataire();
      }

   }

   public void recuperationDestinataire() throws JDOMException, IOException, HibernateException, NamingException {
      this.plansAnalytiques = this.formRecherche.calculeDestinataire();
      this.calculeDestinataire();
   }

   public void calculeDestinataire() throws JDOMException, IOException {
      if (!this.selectDestinataire) {
         this.inpDestinataire = this.plansAnalytiques.getAnaNomFr();
      } else if (this.plansAnalytiques != null) {
         this.fondationDemande.setFondemNomContact(this.plansAnalytiques.getAnaNomFr());
         this.fondationDemande.setFondemCivilContact(this.plansAnalytiques.getAnaTiersCivilite());
         this.fondationDemande.setFondemAnal4(this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr());
      } else {
         this.annuleDestinataire();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.inpDestinataire = "";
      this.fondationDemande.setFondemNomContact("");
      this.fondationDemande.setFondemCivilContact("");
      this.fondationDemande.setFondemAnal4("");
      this.var_action = this.var_memo_action;
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

   public void verifBonEncaissement() {
      if (this.montantElmTotBonEnc <= this.fondationDemande.getFondemTotAccorde() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void payeDocument() throws HibernateException, NamingException {
      this.bonEncaissementVente = new BonEncaissementVente();
      this.bonEncaissementVente.setBonCodeCaisse("");
      this.bonEncaissementVente.setBonLibCaisse("");
      this.bonEncaissementVente.setBonDate(new Date());
      this.chargerCaisseCommerciale();
      if (this.var_tot_bon_encaissement > this.fondationDemande.getFondemTotAccorde()) {
         this.fondationDemande.setFondemTypeReg(4);
         this.var_verouxModReg = true;
         this.var_affichMontant = false;
         this.var_netAPayer = this.fondationDemande.getFondemTotAccorde() - this.var_tot_bon_encaissement;
         this.verifBonEncaissement();
      } else {
         if (this.fondationDemande.getFondemTypeReg() == 5) {
            this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
            if (this.fondationDemande.getFondemEtat() == 1) {
               this.var_verouxModReg = true;
            } else {
               this.var_verouxModReg = false;
            }

            this.var_netAPayer = this.fondationDemande.getFondemTotAccorde() - this.var_tot_bon_encaissement;
            this.var_affiche_valide = true;
         } else {
            this.fondationDemande.setFondemTypeReg(0);
            this.var_verouxModReg = false;
            this.var_netAPayer = this.fondationDemande.getFondemTotAccorde() - this.var_tot_bon_encaissement;
            this.verifBonEncaissement();
         }

         this.var_affichMontant = true;
      }

      this.setShowModalPanelPaye(true);
   }

   public void chargerCaisseCommerciale() throws HibernateException, NamingException {
      this.mesCaissesItems.clear();
      if (this.fondationDemande != null) {
         if (this.fondationDemande.getFondemSerie() != null && !this.fondationDemande.getFondemSerie().isEmpty()) {
            new Chrono();
            ChronoDao var2 = new ChronoDao(this.baseLog, this.utilInitHibernate);
            CaissesCommercialesDao var3 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
            String var4 = "" + (this.fondationDemande.getFondemDate().getYear() + 1900);
            Chrono var1 = var2.chronoBySerieNat(this.fondationDemande.getFondemSerie(), this.nature, var4, (Session)null);
            if (var1 != null) {
               this.mesCaissesItems = var3.selectActifCaisseItems(this.usersLog.getUsrJrxReserve(), (Session)null);
            } else {
               this.mesCaissesItems.add(new SelectItem(""));
            }
         } else {
            this.mesCaissesItems.add(new SelectItem(""));
         }
      } else {
         this.mesCaissesItems.add(new SelectItem(""));
      }

   }

   public void annulePaye() {
      this.setShowModalPanelPaye(false);
   }

   public void chargerModReg() {
      if (this.fondationDemande.getFondemTypeReg() != 4 && this.fondationDemande.getFondemTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      if (this.var_tot_bon_encaissement <= this.fondationDemande.getFondemTotAccorde()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Fondation");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.fondationDemande.getFondemTypeReg() == 5) {
               this.fondationDemande = this.fondationDemandeDao.modif(this.fondationDemande, var1);
               new Habilitation();
               HabilitationDao var11 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var10 = var11.existenceHabilitation(29, var1);
               if (var10 != null) {
               }
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 29, this.fondationDemande.getFondemSerie(), var1);
               this.bonEncaissementVente = new BonEncaissementVente();
               this.bonEncaissementVente.setBonDateCreat(new Date());
               if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                  String[] var4 = this.var_inputCaisse.split(":");
                  this.bonEncaissementVente.setBonCodeCaisse(var4[0]);
                  this.bonEncaissementVente.setBonLibCaisse(var4[1]);
               } else {
                  this.bonEncaissementVente.setBonCodeCaisse("");
                  this.bonEncaissementVente.setBonLibCaisse("");
               }

               this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
               this.bonEncaissementVente.setBonActivite(this.fondationDemande.getFondemActivite());
               this.bonEncaissementVente.setBonSite(this.fondationDemande.getFondemSite());
               this.bonEncaissementVente.setBonDepartement(this.fondationDemande.getFondemDepartement());
               this.bonEncaissementVente.setBonService(this.fondationDemande.getFondemService());
               this.bonEncaissementVente.setBonRegion(this.fondationDemande.getFondemRegion());
               this.bonEncaissementVente.setBonSecteur(this.fondationDemande.getFondemSecteur());
               this.bonEncaissementVente.setBonPdv(this.fondationDemande.getFondemPdv());
               if (this.fondationDemande.getFondemTypeReg() == 0) {
                  this.fondationDemande.setFondemEcheanceReliquat((Date)null);
                  this.bonEncaissementVente.setBonDateEcheReg(this.fondationDemande.getFondemDateEcheReg());
               } else {
                  if (this.fondationDemande.getFondemEcheanceReliquat() == null) {
                     this.fondationDemande.setFondemEcheanceReliquat(this.fondationDemande.getFondemDateEcheReg());
                  }

                  this.bonEncaissementVente.setBonDateEcheReg(this.fondationDemande.getFondemEcheanceReliquat());
               }

               this.bonEncaissementVente.setBonEtat(0);
               this.bonEncaissementVente.setBonNatRef(this.nature);
               this.bonEncaissementVente.setBonNomTiers(this.fondationDemande.getFondemNomTiers());
               this.bonEncaissementVente.setBonIdTiers(this.fondationDemande.getTiers().getTieid());
               this.bonEncaissementVente.setBonNomContact(this.fondationDemande.getFondemNomContact());
               this.bonEncaissementVente.setBonIdContact(this.fondationDemande.getFondemIdContact());
               this.bonEncaissementVente.setBonTypeTiers(0);
               this.bonEncaissementVente.setBonLibelle("Règlement Devis N° " + this.fondationDemande.getFondemNum());
               this.bonEncaissementVente.setBonRef(this.fondationDemande.getFondemNum());
               this.bonEncaissementVente.setBonIdRef(this.fondationDemande.getFondemId());
               this.bonEncaissementVente.setBonObject(this.fondationDemande.getFondemObject());
               this.bonEncaissementVente.setBonObservation(this.fondationDemande.getFondemObservation());
               this.bonEncaissementVente.setBonSerie(this.fondationDemande.getFondemSerie());
               this.bonEncaissementVente.setBonDevise(this.fondationDemande.getFondemDevise());
               this.bonEncaissementVente.setBonTotTtc(this.fondationDemande.getFondemTotAccorde());
               this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
               this.bonEncaissementVente.setBonTypeReg(this.fondationDemande.getFondemTypeReg());
               this.bonEncaissementVente.setBonActif(0);
               this.bonEncaissementVente.setBonNum(var3);
               this.bonEncaissementVente.setBonDate(new Date());
               this.bonEncaissementVente.setBonIdResponsable(this.fondationDemande.getFondemIdResponsable());
               this.bonEncaissementVente.setBonNomResponsable(this.fondationDemande.getFondemNomResponsable());
               this.bonEncaissementVente.setBonIdCommercial(this.fondationDemande.getFondemIdCommercial());
               this.bonEncaissementVente.setBonNomCommercial(this.fondationDemande.getFondemNomCommercial());
               this.bonEncaissementVente.setBonIdEquipe(this.fondationDemande.getFondemIdEquipe());
               this.bonEncaissementVente.setBonNomEquipe(this.fondationDemande.getFondemNomEquipe());
               this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
            }

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

      this.setShowModalPanelPaye(false);
      this.visibiliteBton = false;
   }

   public void choixCaisse() {
      if (this.var_inputCaisse.equalsIgnoreCase("0")) {
         this.bonEncaissementVente.setBonCodeCaisse("");
         this.bonEncaissementVente.setBonLibCaisse("");
      } else {
         String[] var1 = this.var_inputCaisse.split(":");
         this.bonEncaissementVente.setBonCodeCaisse(var1[0]);
         this.bonEncaissementVente.setBonLibCaisse(var1[1]);
      }

   }

   public String conversionGarde() throws HibernateException, NamingException {
      String var1 = null;
      if (this.fondationDemande.getFondemGarde() != null && !this.fondationDemande.getFondemGarde().isEmpty() && this.fondationDemande.getFondemGarde().contains(":")) {
         String[] var2 = this.fondationDemande.getFondemGarde().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.fondationDemande.getUsers(), this.structureLog, this.fondationDemande.getTiers());
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.fondationDemande.getFondemAnnexe1() != null && !this.fondationDemande.getFondemAnnexe1().isEmpty() && this.fondationDemande.getFondemAnnexe1().contains(":")) {
         String[] var2 = this.fondationDemande.getFondemAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.fondationDemande.getUsers(), this.structureLog, this.fondationDemande.getTiers());
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String conversionAnnexe2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.fondationDemande.getFondemAnnexe2() != null && !this.fondationDemande.getFondemAnnexe2().isEmpty() && this.fondationDemande.getFondemAnnexe2().contains(":")) {
         String[] var2 = this.fondationDemande.getFondemAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.fondationDemande.getUsers(), this.structureLog, this.fondationDemande.getTiers());
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + "structure" + this.structureLog.getStrid() + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatDevis.jpg");
            if (var4.exists()) {
               var3 = "formatDevis.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatDevis.jpg");
         if (var4.exists()) {
            var3 = "formatDevis.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      this.montant_lettre = this.utilNombre.begin(this.fondationDemande.getFondemTotAccorde(), this.fondationDemande.getFondemDevise());
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.fondationDemande.getFondemAnal2() != null && !this.fondationDemande.getFondemAnal2().isEmpty()) {
         String var4 = "";
         if (this.fondationDemande.getFondemAnal2().contains(":")) {
            String[] var5 = this.fondationDemande.getFondemAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.fondationDemande.getFondemAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Fondation");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.fondationDemande.getFondemDateImp() != null && this.fondationDemande.getFondemEtat() != 0) {
            var2 = true;
         }

         this.fondationDemande.setFondemDateImp(new Date());
         if (this.fondationDemande.getFondemEtat() == 0 && this.fondationDemande.getFondemEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.fondationDemande.setFondemEtat(1);
            if (this.tiers.getTieDteDocument1() == null || this.fondationDemande.getFondemDate().after(this.tiers.getTieDteDocument1())) {
               this.tiers.setTieDteDocument1(this.fondationDemande.getFondemDate());
               this.tiers = this.tiersDao.modif(this.tiers, var3);
            }
         }

         this.fondationDemande.setFondemModeleImp(var1);
         if (this.fondationDemandeDao == null) {
            this.fondationDemandeDao = new FondationDemandeDao(this.baseLog, this.utilInitHibernate);
         }

         this.fondationDemande = this.fondationDemandeDao.modif(this.fondationDemande, var3);
         this.contacts = new Contacts();
         if (this.fondationDemande.getFondemIdContact() != 0L) {
            if (this.contactDao == null) {
               this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
            }

            this.contacts = this.contactDao.chargerLesContactsById(this.fondationDemande.getFondemIdContact(), var3);
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

   public void choixDeviseImpression(String var1, float var2) {
      this.devisePrint = var1;
      this.tauxPrint = var2;
   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var10 = this.majDateImpression(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setEntete("Impression devis");
            var1.setPageGarde(this.conversionGarde());
            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            if ((var1.getPageGarde() == null || var1.getPageGarde().isEmpty()) && (var1.getAnnexe1() == null || var1.getAnnexe1().isEmpty()) && (var1.getAnnexe2() == null || var1.getAnnexe2().isEmpty())) {
               var1.setRapport(var3);
               var1.setRapportEncapsule((String)null);
            } else {
               var1.setRapport("pageGarde");
               var1.setRapportEncapsule(var3);
            }

            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.fondationDemande.getFondemEtat()));
            var1.setDuplicata("" + var10);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            this.fondationDemande.setFondemDevise(this.devisePrint);
            if (!this.fondationDemande.getFondemDevise().equals("XOF") && !this.fondationDemande.getFondemDevise().equals("XAF")) {
               if (this.fondationDemande.getFondemDevise().equals("EUR")) {
                  var1.setNbCar(1);
               } else {
                  var1.setNbCar(0);
               }
            } else {
               var1.setNbCar(2);
            }

            if (this.devisePrint.equals(this.structureLog.getStrdevise())) {
               var1.setTaux(1.0F);
            } else {
               var1.setTaux(this.tauxPrint);
               double var11 = this.utilNombre.myRound(this.fondationDemande.getFondemTotAccorde() / (double)this.tauxPrint, 2);
               this.montant_lettre = this.utilNombre.begin(var11, this.devisePrint);
            }

            var1.setMontant_lettre(this.montant_lettre);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setIdResponsable(this.fondationDemande.getFondemIdResponsable());
            var1.setIdCommercial(this.fondationDemande.getFondemIdCommercial());
            var1.setTiersSelectionne(this.fondationDemande.getTiers());
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.fondationDemande.getFondemNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.fondationDemande.getFondemId());
            if (this.fondationDemande.getFondemAnal2() != null && !this.fondationDemande.getFondemAnal2().isEmpty()) {
               String var15 = "";
               if (this.fondationDemande.getFondemAnal2().contains(":")) {
                  String[] var12 = this.fondationDemande.getFondemAnal2().split(":");
                  var15 = var12[0];
               } else {
                  var15 = this.fondationDemande.getFondemAnal2();
               }

               new Parc();
               ParcDao var13 = new ParcDao(this.baseLog, this.utilInitHibernate);
               Parc var16 = var13.rechercheParc(var15, (Session)null);
               if (var16 != null) {
                  var1.setParc(var16);
               } else {
                  var1.setParc((Parc)null);
               }
            } else {
               var1.setParc((Parc)null);
            }

            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 1 && var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des devis");
         var1.setTotauxHt("" + this.totauxHt);
         var1.setTotauxTaxe("" + this.totauxTaxe);
         var1.setTotauxTtc("" + this.totauxTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "devis" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.nature);
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var14 = new JRBeanCollectionDataSource(this.lesEntetesList);
         var1.setjRBeanCollectionDataSource(var14);
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
            this.uniteGraph = "DEVIS : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "DEVIS : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "DEVIS : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = Integer.parseInt(this.optionsVentes.getNbDecQte());
         }

         this.titreGraph = "Analyse des ventes : ";
         EtatDocument var2 = new EtatDocument();
         String var4;
         if (this.inpDu != null && this.inpAu != null) {
            String var3 = this.utilDate.dateToStringFr(this.inpDu);
            var4 = this.utilDate.dateToStringFr(this.inpAu);
            this.titreGraph = this.titreGraph + " Du " + var3 + " au " + var4;
         } else if (this.periode.equals("100")) {
            this.titreGraph = this.titreGraph + " Toutes periodes";
         } else {
            this.titreGraph = this.titreGraph + " " + var2.calculeLibellePeriode(this.periode);
         }

         if (this.timeDecoupage == 5) {
            this.titreGraph = this.titreGraph + " Par tranches horaires";
         }

         this.sousTitreGraph = "";
         if (this.inpCat.equals("100")) {
            this.sousTitreGraph = "Toutes les categories -";
         } else {
            this.sousTitreGraph = "Categorie: " + this.inpCat + " -";
         }

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
         } else if (this.modeGraph == 2) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par commercial (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 3) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par equipe (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 4) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par societe (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 5) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par famille de produit (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 6) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par produit (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 7) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par source (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 8) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par affaire (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 9) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par region (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 10) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par secteur (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 11) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par point de vente (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 12) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par site (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 13) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par departement (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 14) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par service (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 15) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par serie (" + this.uniteGraph + ")";
         }

         new FondationDemande();
         var4 = "";

         FondationDemande var11;
         for(int var5 = 0; var5 < this.lesEntetesList.size(); ++var5) {
            var11 = (FondationDemande)this.lesEntetesList.get(var5);
            if (var4.isEmpty()) {
               var4 = "'" + var11.getFondemNum() + "'";
            } else {
               var4 = var4 + ",'" + var11.getFondemNum() + "'";
            }
         }

         if (this.lesEntetesList.size() != 0) {
            String var12 = "";
            long var6 = 0L;
            boolean var8 = false;

            for(int var9 = 0; var9 < this.lesEntetesList.size(); ++var9) {
               var11 = (FondationDemande)this.lesEntetesList.get(var9);
               var12 = "";
               var6 = 0L;
               int var13 = 0;
               if (this.modeGraph == 0) {
                  int var10 = var11.getFondemDate().getYear() + 1900;
                  var12 = "" + var10;
               } else if (this.modeGraph == 1) {
                  if (var11.getFondemNomResponsable() != null && !var11.getFondemNomResponsable().isEmpty()) {
                     var12 = var11.getFondemNomResponsable();
                  } else {
                     var12 = "Sans Responsable";
                  }
               } else if (this.modeGraph == 2) {
                  if (var11.getFondemNomCommercial() != null && !var11.getFondemNomCommercial().isEmpty()) {
                     var12 = var11.getFondemNomCommercial();
                  } else {
                     var12 = "Sans Commercial";
                  }
               } else if (this.modeGraph == 3) {
                  if (var11.getFondemNomEquipe() != null && !var11.getFondemNomEquipe().isEmpty()) {
                     var12 = var11.getFondemNomEquipe();
                  } else {
                     var12 = "Sans Equipe";
                  }
               } else if (this.modeGraph == 4) {
                  if (var11.getFondemNomTiers() != null && !var11.getFondemNomTiers().isEmpty()) {
                     var12 = var11.getFondemNomTiers();
                  } else {
                     var12 = "Sans Tiers";
                  }
               } else if (this.modeGraph == 7) {
                  if (var11.getFondemSource() != null && !var11.getFondemSource().isEmpty()) {
                     var12 = var11.getFondemSource();
                  } else {
                     var12 = "Sans Source";
                  }
               } else if (this.modeGraph == 8) {
                  if (var11.getFondemAnal4() != null && !var11.getFondemAnal4().isEmpty()) {
                     var12 = var11.getFondemAnal4();
                  } else {
                     var12 = "Sans Affaire";
                  }
               } else if (this.modeGraph == 9) {
                  if (var11.getFondemRegion() != null && !var11.getFondemRegion().isEmpty()) {
                     var12 = var11.getFondemRegion();
                  } else {
                     var12 = "Sans Region";
                  }
               } else if (this.modeGraph == 10) {
                  if (var11.getFondemSecteur() != null && !var11.getFondemSecteur().isEmpty()) {
                     var12 = var11.getFondemSecteur();
                  } else {
                     var12 = "Sans Secteur";
                  }
               } else if (this.modeGraph == 11) {
                  if (var11.getFondemPdv() != null && !var11.getFondemPdv().isEmpty()) {
                     var12 = var11.getFondemPdv();
                  } else {
                     var12 = "Sans Point de vente";
                  }
               } else if (this.modeGraph == 12) {
                  if (var11.getFondemSite() != null && !var11.getFondemSite().isEmpty()) {
                     var12 = var11.getFondemSite();
                  } else {
                     var12 = "Sans Site";
                  }
               } else if (this.modeGraph == 13) {
                  if (var11.getFondemDepartement() != null && !var11.getFondemDepartement().isEmpty()) {
                     var12 = var11.getFondemDepartement();
                  } else {
                     var12 = "Sans Departement";
                  }
               } else if (this.modeGraph == 14) {
                  if (var11.getFondemService() != null && !var11.getFondemService().isEmpty()) {
                     var12 = var11.getFondemService();
                  } else {
                     var12 = "Sans Service";
                  }
               } else if (this.modeGraph == 15) {
                  if (var11.getFondemSerie() != null && !var11.getFondemSerie().isEmpty()) {
                     var12 = var11.getFondemSerie();
                  } else {
                     var12 = "Sans Serie";
                  }
               }

               if (this.valQteGraph == 0) {
                  var6 = (long)var11.getFondemTotAccorde();
               } else if (this.valQteGraph == 1) {
                  ++var6;
               }

               if (this.timeDecoupage == 0) {
                  var13 = var11.getFondemDate().getDate();
               } else if (this.timeDecoupage == 1) {
                  var13 = var11.getFondemDate().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var11.getFondemDate().getMonth() + 1 >= 1 && var11.getFondemDate().getMonth() + 1 <= 3) {
                     var13 = 1;
                  } else if (var11.getFondemDate().getMonth() + 1 >= 4 && var11.getFondemDate().getMonth() + 1 <= 6) {
                     var13 = 2;
                  } else if (var11.getFondemDate().getMonth() + 1 >= 7 && var11.getFondemDate().getMonth() + 1 <= 9) {
                     var13 = 3;
                  } else if (var11.getFondemDate().getMonth() + 1 >= 10 && var11.getFondemDate().getMonth() + 1 <= 12) {
                     var13 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var11.getFondemDate().getMonth() + 1 >= 1 && var11.getFondemDate().getMonth() + 1 <= 6) {
                     var13 = 1;
                  } else if (var11.getFondemDate().getMonth() + 1 >= 7 && var11.getFondemDate().getMonth() + 1 <= 12) {
                     var13 = 2;
                  }
               } else if (this.timeDecoupage == 4) {
                  var13 = 1;
               } else if (this.timeDecoupage == 5) {
                  var13 = var11.getFondemDate().getHours();
               }

               var1 = this.calculeListe((List)var1, var12, var13, var6);
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

   public BonEncaissementVente getBonEncaissementVente() {
      return this.bonEncaissementVente;
   }

   public void setBonEncaissementVente(BonEncaissementVente var1) {
      this.bonEncaissementVente = var1;
   }

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public boolean isContDest() {
      return this.contDest;
   }

   public void setContDest(boolean var1) {
      this.contDest = var1;
   }

   public DataModel getDatamodelDocumentTrace() {
      return this.datamodelDocumentTrace;
   }

   public void setDatamodelDocumentTrace(DataModel var1) {
      this.datamodelDocumentTrace = var1;
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

   public String getInpClient() {
      return this.inpClient;
   }

   public void setInpClient(String var1) {
      this.inpClient = var1;
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

   public List getMesContactItem() {
      return this.mesContactItem;
   }

   public void setMesContactItem(List var1) {
      this.mesContactItem = var1;
   }

   public List getMesUsersItem() {
      return this.mesUsersItem;
   }

   public void setMesUsersItem(List var1) {
      this.mesUsersItem = var1;
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

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
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

   public boolean isVar_aff_detail_prod() {
      return this.var_aff_detail_prod;
   }

   public void setVar_aff_detail_prod(boolean var1) {
      this.var_aff_detail_prod = var1;
   }

   public boolean isVar_aff_detail_tiers() {
      return this.var_aff_detail_tiers;
   }

   public void setVar_aff_detail_tiers(boolean var1) {
      this.var_aff_detail_tiers = var1;
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

   public String getVar_libcondest() {
      return this.var_libcondest;
   }

   public void setVar_libcondest(String var1) {
      this.var_libcondest = var1;
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

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
   }

   public boolean isVar_typeTiers() {
      return this.var_typeTiers;
   }

   public void setVar_typeTiers(boolean var1) {
      this.var_typeTiers = var1;
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

   public boolean isVerrouPrvente() {
      return this.verrouPrvente;
   }

   public void setVerrouPrvente(boolean var1) {
      this.verrouPrvente = var1;
   }

   public boolean isVerrouRemise() {
      return this.verrouRemise;
   }

   public void setVerrouRemise(boolean var1) {
      this.verrouRemise = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVisibiliteencaissemt() {
      return this.visibiliteencaissemt;
   }

   public void setVisibiliteencaissemt(boolean var1) {
      this.visibiliteencaissemt = var1;
   }

   public boolean isVisibilitefactor() {
      return this.visibilitefactor;
   }

   public void setVisibilitefactor(boolean var1) {
      this.visibilitefactor = var1;
   }

   public boolean isVisibilitenbrjr() {
      return this.visibilitenbrjr;
   }

   public void setVisibilitenbrjr(boolean var1) {
      this.visibilitenbrjr = var1;
   }

   public boolean isVisibiliteterme() {
      return this.visibiliteterme;
   }

   public void setVisibiliteterme(boolean var1) {
      this.visibiliteterme = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public String getVar_inputCaisse() {
      return this.var_inputCaisse;
   }

   public void setVar_inputCaisse(String var1) {
      this.var_inputCaisse = var1;
   }

   public double getVar_netAPayer() {
      return this.var_netAPayer;
   }

   public void setVar_netAPayer(double var1) {
      this.var_netAPayer = var1;
   }

   public boolean isVar_affichMontant() {
      return this.var_affichMontant;
   }

   public void setVar_affichMontant(boolean var1) {
      this.var_affichMontant = var1;
   }

   public boolean isVar_verouxModReg() {
      return this.var_verouxModReg;
   }

   public void setVar_verouxModReg(boolean var1) {
      this.var_verouxModReg = var1;
   }

   public DataModel getDatamodelRecu() {
      return this.datamodelRecu;
   }

   public void setDatamodelRecu(DataModel var1) {
      this.datamodelRecu = var1;
   }

   public boolean isAfficheRecu() {
      return this.afficheRecu;
   }

   public void setAfficheRecu(boolean var1) {
      this.afficheRecu = var1;
   }

   public double getMontantElmTotBonEnc() {
      return this.montantElmTotBonEnc;
   }

   public void setMontantElmTotBonEnc(double var1) {
      this.montantElmTotBonEnc = var1;
   }

   public double getVar_tot_bon_encaissement() {
      return this.var_tot_bon_encaissement;
   }

   public void setVar_tot_bon_encaissement(double var1) {
      this.var_tot_bon_encaissement = var1;
   }

   public boolean isVar_affiche_dollar() {
      return this.var_affiche_dollar;
   }

   public void setVar_affiche_dollar(boolean var1) {
      this.var_affiche_dollar = var1;
   }

   public boolean isVar_affiche_valide() {
      return this.var_affiche_valide;
   }

   public void setVar_affiche_valide(boolean var1) {
      this.var_affiche_valide = var1;
   }

   public String getInpDossier() {
      return this.inpDossier;
   }

   public void setInpDossier(String var1) {
      this.inpDossier = var1;
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

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public ExercicesVentes getLastExoVentes() {
      return this.lastExoVentes;
   }

   public void setLastExoVentes(ExercicesVentes var1) {
      this.lastExoVentes = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public List getLesFamilleClientsListe() {
      return this.lesFamilleClientsListe;
   }

   public void setLesFamilleClientsListe(List var1) {
      this.lesFamilleClientsListe = var1;
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

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public boolean isShowModalPanelValidationDocument() {
      return this.showModalPanelValidationDocument;
   }

   public void setShowModalPanelValidationDocument(boolean var1) {
      this.showModalPanelValidationDocument = var1;
   }

   public long getVar_nom_contact() {
      return this.var_nom_contact;
   }

   public void setVar_nom_contact(long var1) {
      this.var_nom_contact = var1;
   }

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
   }

   public int getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(int var1) {
      this.var_timbre = var1;
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

   public UtilParapheur getUtilParapheur() {
      return this.utilParapheur;
   }

   public void setUtilParapheur(UtilParapheur var1) {
      this.utilParapheur = var1;
   }

   public double getVar_total_marge() {
      return this.var_total_marge;
   }

   public void setVar_total_marge(double var1) {
      this.var_total_marge = var1;
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

   public List getLesModeReglementClientsListe() {
      return this.lesModeReglementClientsListe;
   }

   public void setLesModeReglementClientsListe(List var1) {
      this.lesModeReglementClientsListe = var1;
   }

   public List getMesCaissesItems() {
      return this.mesCaissesItems;
   }

   public void setMesCaissesItems(List var1) {
      this.mesCaissesItems = var1;
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

   public int getValQteGraph() {
      return this.valQteGraph;
   }

   public void setValQteGraph(int var1) {
      this.valQteGraph = var1;
   }

   public String getUniteGraph() {
      return this.uniteGraph;
   }

   public void setUniteGraph(String var1) {
      this.uniteGraph = var1;
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

   public boolean isAccesAffaires() {
      return this.accesAffaires;
   }

   public void setAccesAffaires(boolean var1) {
      this.accesAffaires = var1;
   }

   public List getMesAffairesItems() {
      return this.mesAffairesItems;
   }

   public void setMesAffairesItems(List var1) {
      this.mesAffairesItems = var1;
   }

   public String getNumeroPfManuel() {
      return this.numeroPfManuel;
   }

   public void setNumeroPfManuel(String var1) {
      this.numeroPfManuel = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public String getInformationsTiers() {
      return this.informationsTiers;
   }

   public void setInformationsTiers(String var1) {
      this.informationsTiers = var1;
   }

   public long getInpIdTiersEnCours() {
      return this.inpIdTiersEnCours;
   }

   public void setInpIdTiersEnCours(long var1) {
      this.inpIdTiersEnCours = var1;
   }

   public String getInpNomDestinataire() {
      return this.inpNomDestinataire;
   }

   public void setInpNomDestinataire(String var1) {
      this.inpNomDestinataire = var1;
   }

   public String getInpNomTiersEnCours() {
      return this.inpNomTiersEnCours;
   }

   public void setInpNomTiersEnCours(String var1) {
      this.inpNomTiersEnCours = var1;
   }

   public Parapheur getParapheur() {
      return this.parapheur;
   }

   public void setParapheur(Parapheur var1) {
      this.parapheur = var1;
   }

   public UtilNombre getUtilNombre() {
      return this.utilNombre;
   }

   public void setUtilNombre(UtilNombre var1) {
      this.utilNombre = var1;
   }

   public boolean isShowModalPanelGele() {
      return this.showModalPanelGele;
   }

   public void setShowModalPanelGele(boolean var1) {
      this.showModalPanelGele = var1;
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

   public boolean isShowModalPanelPaye() {
      return this.showModalPanelPaye;
   }

   public void setShowModalPanelPaye(boolean var1) {
      this.showModalPanelPaye = var1;
   }

   public List getMesTaxesVentesItems() {
      return this.mesTaxesVentesItems;
   }

   public void setMesTaxesVentesItems(List var1) {
      this.mesTaxesVentesItems = var1;
   }

   public FondationDemande getFondationDemande() {
      return this.fondationDemande;
   }

   public void setFondationDemande(FondationDemande var1) {
      this.fondationDemande = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public boolean isShowModalPanelAjoutFileComite() {
      return this.showModalPanelAjoutFileComite;
   }

   public void setShowModalPanelAjoutFileComite(boolean var1) {
      this.showModalPanelAjoutFileComite = var1;
   }

   public boolean isShowModalPanelAjoutFileDemandeur() {
      return this.showModalPanelAjoutFileDemandeur;
   }

   public void setShowModalPanelAjoutFileDemandeur(boolean var1) {
      this.showModalPanelAjoutFileDemandeur = var1;
   }

   public boolean isShowModalPanelPjComite() {
      return this.showModalPanelPjComite;
   }

   public void setShowModalPanelPjComite(boolean var1) {
      this.showModalPanelPjComite = var1;
   }

   public boolean isShowModalPanelPjDemandeur() {
      return this.showModalPanelPjDemandeur;
   }

   public void setShowModalPanelPjDemandeur(boolean var1) {
      this.showModalPanelPjDemandeur = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
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

   public DataModel getDataModelDocumntsComite() {
      return this.dataModelDocumntsComite;
   }

   public void setDataModelDocumntsComite(DataModel var1) {
      this.dataModelDocumntsComite = var1;
   }

   public DataModel getDataModelDocumntsDemandeur() {
      return this.dataModelDocumntsDemandeur;
   }

   public void setDataModelDocumntsDemandeur(DataModel var1) {
      this.dataModelDocumntsDemandeur = var1;
   }
}
