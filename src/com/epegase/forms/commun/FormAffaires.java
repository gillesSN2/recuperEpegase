package com.epegase.forms.commun;

import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneAchats;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.BonEntreeEntete;
import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.classe.BonSortieEntete;
import com.epegase.systeme.classe.BonSortieLigne;
import com.epegase.systeme.classe.CessionEntete;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.CotationLigneAchats;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FabricationEnteteAchats;
import com.epegase.systeme.classe.FabricationLigneAchats;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.NoteDebitLigneAchats;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.RetourEnteteAchats;
import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.LigneDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BonEntreeEnteteDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieEnteteDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.CessionEnteteDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.CotationEnteteAchatsDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FabricationEnteteAchatsDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.RetourEnteteAchatsDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesVentesDao;
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
import com.epegase.systeme.xml.LectureNatureAffaires;
import com.epegase.systeme.xml.LireLesoptionsAchats;
import com.epegase.systeme.xml.LireLesoptionsTiers;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionTiers;
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

public class FormAffaires implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionTiers optionTiers;
   private int nature;
   private FormRecherche formRecherche;
   private int typeModule;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private ObjetLigneMenu ligneMenu;
   private Users users;
   private ExercicesVentes exercicesVentes;
   private ExercicesAchats exercicesAchats;
   private LireLesoptionsTiers lireLesOptionsTiers;
   private boolean afficheButtOption = false;
   private int var_nb_max = 100;
   private CalculChrono calculChrono;
   private OptionVentes optionVentes;
   private OptionAchats optionAchats;
   private List mesNaturesAffaires;
   private String dossierSelectionne;
   private EspionDao espionDao;
   private UtilDate utilDate;
   private boolean modeAvion;
   private boolean modeBateau;
   private boolean modeExpress;
   private boolean modeRoute;
   private boolean modeTrain;
   private boolean modeReachemin1;
   private boolean modeReachemin2;
   private boolean modeReachemin3;
   private boolean showModalPanelAnnuler = false;
   private boolean showModalPanelGele = false;
   private UtilNombre utilNombre;
   private int var_timbre;
   private int var_tc_type;
   private String var_tc_libelle;
   private float var_tc_taux;
   private boolean frsPrp1 = false;
   private boolean frsPrp2 = false;
   private boolean frsPrp3 = false;
   private Tiers tiers;
   private TiersDao tiersDao;
   private String nomTier;
   private List lesFamilleClientsListe;
   private String informationsTiers;
   private Users responsable;
   private long var_nom_commercial;
   private List mesCommercialItem;
   private long var_nom_equipe;
   private Equipes equipes;
   private EquipesDao equipesDao;
   private List mesEquipeItem;
   private List lesEquipes;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private List mesUsersItem;
   private ContactDao contactDao;
   private Contacts contacts;
   private List mesContactItem;
   private long var_nom_responsable;
   private long var_nom_contact;
   private String anneeRec = "" + ((new Date()).getYear() + 1900);
   private String serviceRec;
   private String tiersRec = "";
   private int modeRec = 99;
   private String dossierRec = "";
   private int etatRec = 0;
   private long userRec = 0L;
   private long comRec = 0L;
   private String periode;
   private Date inpDu = null;
   private Date inpAu = null;
   private String affaireRec = "";
   private List anneeItems = new ArrayList();
   private List serviceItems = new ArrayList();
   private boolean var_more_search = false;
   private PlansAnalytiques plansAnalytiques;
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private List lesAffaires = new ArrayList();
   private transient DataModel dataModelAffaires = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean var_valide_doc;
   private boolean var_aff_action;
   private double margeTheo;
   private double margeReel;
   private List lesDevis;
   private List lesCommandes;
   private List lesLivraisons;
   private List lesRetours;
   private List lesFactures;
   private List lesNotesDebit;
   private List lesAvoirs;
   private List lesReglements;
   private List lesCotations;
   private List lesCommandesAch;
   private List lesReceptions;
   private List lesRetoursAch;
   private List lesFacturesAch;
   private List lesNotesDebitAch;
   private List lesAvoirsAch;
   private List lesBonEntrees;
   private List lesBonSorties;
   private List lesCessions;
   private List lesProductions;
   private transient DataModel dataModelDevis;
   private transient DataModel dataModelCommandes;
   private transient DataModel dataModelLivraisons;
   private transient DataModel dataModelRetours;
   private transient DataModel dataModelFactures;
   private transient DataModel dataModelNotesDebit;
   private transient DataModel dataModelAvoirs;
   private transient DataModel dataModelReglements;
   private transient DataModel dataModelCotations;
   private transient DataModel dataModelCommandesAch;
   private transient DataModel dataModelReceptons;
   private transient DataModel dataModelRetoursAch;
   private transient DataModel dataModelFacturesAch;
   private transient DataModel dataModelNotesDebitAch;
   private transient DataModel dataModelAvoirsAch;
   private transient DataModel dataModelBonEntrees;
   private transient DataModel dataModelBonSorties;
   private transient DataModel dataModelCessions;
   private transient DataModel dataModelProductions;
   private DevisEnteteVentesDao devisEnteteVentesDao;
   private CommandeEnteteVentesDao commandeEnteteVentesDao;
   private LivraisonEnteteVentesDao livraisonEnteteVentesDao;
   private RetourEnteteVentesDao retourEnteteVentesDao;
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private NoteDebitEnteteVentesDao noteDebitEnteteVentesDao;
   private AvoirEnteteVentesDao avoirEnteteVentesDao;
   private ReglementsDao reglementsDao;
   private CotationEnteteAchatsDao cotationEnteteAchatsDao;
   private CommandeEnteteAchatsDao commandeEnteteAchatsDao;
   private ReceptionEnteteAchatsDao receptionEnteteAchatsDao;
   private RetourEnteteAchatsDao retourEnteteAchatsDao;
   private NoteDebitEnteteAchatsDao noteDebitEnteteAchatsDao;
   private FactureEnteteAchatsDao factureEnteteAchatsDao;
   private AvoirEnteteAchatsDao avoirEnteteAchatsDao;
   private BonEntreeEnteteDao bonEntreeEnteteDao;
   private BonSortieEnteteDao bonSortieEnteteDao;
   private CessionEnteteDao cessionEnteteDao;
   private FabricationEnteteAchatsDao fabricationEnteteAchatsDao;
   private CotationEnteteAchats cotationEnteteAchats;
   private DevisEnteteVentes devisEnteteVentes;
   private CommandeEnteteAchats commandeEnteteAchats;
   private CommandeEnteteVentes commandeEnteteVentes;
   private ReceptionEnteteAchats receptionEnteteAchats;
   private LivraisonEnteteVentes livraisonEnteteVentes;
   private TaxesVentesDao taxesVentesDao;
   private List lesDetails;
   private transient DataModel dataModelDetail;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private boolean var_verrou_comm = false;
   private Habilitation habilitation;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private boolean existParapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private String devisePrint;
   private float tauxPrint;
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
   private transient DataModel dataModelDocumnts;
   private List lesDocuments;
   private String nomRepertoire;
   private boolean showModalPanelPj = false;
   private boolean showModalPanelAjoutFile = false;
   private String nomDocument;

   public FormAffaires() throws ParseException {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.mesContactItem = new ArrayList();
      this.mesUsersItem = new ArrayList();
      this.plansAnalytiques = new PlansAnalytiques();
      this.mesCommercialItem = new ArrayList();
      this.mesEquipeItem = new ArrayList();
      this.lesEquipes = new ArrayList();
      this.lesDevis = new ArrayList();
      this.lesCommandes = new ArrayList();
      this.lesLivraisons = new ArrayList();
      this.lesRetours = new ArrayList();
      this.lesFactures = new ArrayList();
      this.lesNotesDebit = new ArrayList();
      this.lesAvoirs = new ArrayList();
      this.lesReglements = new ArrayList();
      this.dataModelDevis = new ListDataModel();
      this.dataModelCommandes = new ListDataModel();
      this.dataModelLivraisons = new ListDataModel();
      this.dataModelRetours = new ListDataModel();
      this.dataModelFactures = new ListDataModel();
      this.dataModelNotesDebit = new ListDataModel();
      this.dataModelAvoirs = new ListDataModel();
      this.dataModelReglements = new ListDataModel();
      this.lesCotations = new ArrayList();
      this.lesCommandesAch = new ArrayList();
      this.lesReceptions = new ArrayList();
      this.lesRetoursAch = new ArrayList();
      this.lesFacturesAch = new ArrayList();
      this.lesNotesDebitAch = new ArrayList();
      this.lesAvoirsAch = new ArrayList();
      this.dataModelCotations = new ListDataModel();
      this.dataModelCommandesAch = new ListDataModel();
      this.dataModelReceptons = new ListDataModel();
      this.dataModelRetoursAch = new ListDataModel();
      this.dataModelFacturesAch = new ListDataModel();
      this.dataModelNotesDebitAch = new ListDataModel();
      this.dataModelAvoirsAch = new ListDataModel();
      this.lesBonEntrees = new ArrayList();
      this.lesBonSorties = new ArrayList();
      this.lesCessions = new ArrayList();
      this.lesProductions = new ArrayList();
      this.dataModelBonEntrees = new ListDataModel();
      this.dataModelBonSorties = new ListDataModel();
      this.dataModelCessions = new ListDataModel();
      this.dataModelProductions = new ListDataModel();
      this.lesDetails = new ArrayList();
      this.dataModelDetail = new ListDataModel();
      this.mesNaturesAffaires = new ArrayList();
      this.dataModelDocumnts = new ListDataModel();
      this.lesDocuments = new ArrayList();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.users);
      this.parapheur = new Parapheur();
      this.utilDate = new UtilDate();
      this.utilNombre = new UtilNombre();
   }

   public void InstancesDaoUtilses() {
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.devisEnteteVentesDao = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonEnteteVentesDao = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.retourEnteteVentesDao = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteVentesDao = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.cotationEnteteAchatsDao = new CotationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteAchatsDao = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionEnteteAchatsDao = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.retourEnteteAchatsDao = new RetourEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteAchatsDao = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteAchatsDao = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteAchatsDao = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.bonEntreeEnteteDao = new BonEntreeEnteteDao(this.baseLog, this.utilInitHibernate);
      this.bonSortieEnteteDao = new BonSortieEnteteDao(this.baseLog, this.utilInitHibernate);
      this.cessionEnteteDao = new CessionEnteteDao(this.baseLog, this.utilInitHibernate);
      this.fabricationEnteteAchatsDao = new FabricationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererOptionsTiersVentes(Session var1) throws NamingException, JDOMException, IOException {
      this.typeModule = 1;
      this.lireLesOptionsTiers = new LireLesoptionsTiers();
      this.lireLesOptionsTiers.setStrId(this.structureLog.getStrid());
      this.lireLesOptionsTiers.lancer();
      this.optionTiers = this.lireLesOptionsTiers.getOptionTiers();
      if (this.optionTiers.getNbLigneMaxTi() != null && !this.optionTiers.getNbLigneMaxTi().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionTiers.getNbLigneMaxTi());
      } else {
         this.var_nb_max = 100;
      }

      LectureNatureAffaires var2 = new LectureNatureAffaires();
      var2.setStrId(this.structureLog.getStrid());
      var2.setStructureLog(this.structureLog);
      var2.chargerMesNaturesAffaires();
      this.mesNaturesAffaires = var2.getMesNaturesItems();
      this.exercicesAchats = new ExercicesAchats();
      ExercicesAchatsDao var3 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.exercicesAchats = var3.recupererLastExo(var1);
      this.exercicesVentes = new ExercicesVentes();
      ExercicesVentesDao var4 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentes = var4.recupererLastExo(var1);
      this.optionAchats = new OptionAchats();
      LireLesoptionsAchats var5 = new LireLesoptionsAchats();
      var5.setStrId(this.structureLog.getStrid());
      var5.lancer();
      this.optionAchats = var5.getOptionAchats();
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var6 = new LireLesoptionsVentes();
      var6.setStrId(this.structureLog.getStrid());
      var6.lancer();
      this.optionVentes = var6.getOptionsVentes();
      if (this.usersLog.getUsrCommVentes() == 2) {
         this.var_verrou_comm = false;
      } else {
         this.var_verrou_comm = true;
      }

      this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "affaires" + File.separator;
      this.periode = this.optionVentes.getAffichInGlobViewAffaire();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      if (this.optionAchats.getFraisPrp1() != null && !this.optionAchats.getFraisPrp1().isEmpty()) {
         this.frsPrp1 = true;
      } else {
         this.frsPrp1 = false;
      }

      if (this.optionAchats.getFraisPrp2() != null && !this.optionAchats.getFraisPrp2().isEmpty()) {
         this.frsPrp2 = true;
      } else {
         this.frsPrp2 = false;
      }

      if (this.optionAchats.getFraisPrp3() != null && !this.optionAchats.getFraisPrp3().isEmpty()) {
         this.frsPrp3 = true;
      } else {
         this.frsPrp3 = false;
      }

      this.var_timbre = 0;
   }

   public void recupererOptionsTiersAchats(Session var1) throws NamingException, JDOMException, IOException {
      this.typeModule = 2;
      this.lireLesOptionsTiers = new LireLesoptionsTiers();
      this.lireLesOptionsTiers.setStrId(this.structureLog.getStrid());
      this.lireLesOptionsTiers.lancer();
      this.optionTiers = this.lireLesOptionsTiers.getOptionTiers();
      if (this.optionTiers.getNbLigneMaxTi() != null && !this.optionTiers.getNbLigneMaxTi().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionTiers.getNbLigneMaxTi());
      } else {
         this.var_nb_max = 100;
      }

      LectureNatureAffaires var2 = new LectureNatureAffaires();
      var2.setStrId(this.structureLog.getStrid());
      var2.setStructureLog(this.structureLog);
      var2.chargerMesNaturesAffaires();
      this.mesNaturesAffaires = var2.getMesNaturesItems();
      this.exercicesAchats = new ExercicesAchats();
      ExercicesAchatsDao var3 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.exercicesAchats = var3.recupererLastExo(var1);
      this.exercicesVentes = new ExercicesVentes();
      ExercicesVentesDao var4 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentes = var4.recupererLastExo(var1);
      this.optionAchats = new OptionAchats();
      LireLesoptionsAchats var5 = new LireLesoptionsAchats();
      var5.setStrId(this.structureLog.getStrid());
      var5.lancer();
      this.optionAchats = var5.getOptionAchats();
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var6 = new LireLesoptionsVentes();
      var6.setStrId(this.structureLog.getStrid());
      var6.lancer();
      this.optionVentes = var6.getOptionsVentes();
      if (this.usersLog.getUsrCommAchats() == 2) {
         this.var_verrou_comm = false;
      } else {
         this.var_verrou_comm = true;
      }

      this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "affaires" + File.separator;
      this.periode = this.optionAchats.getAffichInGlobViewAffaire();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      if (this.optionAchats.getFraisPrp1() != null && !this.optionAchats.getFraisPrp1().isEmpty()) {
         this.frsPrp1 = true;
      } else {
         this.frsPrp1 = false;
      }

      if (this.optionAchats.getFraisPrp2() != null && !this.optionAchats.getFraisPrp2().isEmpty()) {
         this.frsPrp2 = true;
      } else {
         this.frsPrp2 = false;
      }

      if (this.optionAchats.getFraisPrp3() != null && !this.optionAchats.getFraisPrp3().isEmpty()) {
         this.frsPrp3 = true;
      } else {
         this.frsPrp3 = false;
      }

   }

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.optionVentes.getResponsable().equals("0")) {
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
         for(int var2 = 0; var2 < this.lesEquipes.size(); ++var2) {
            this.mesEquipeItem.add(new SelectItem(((Equipes)this.lesEquipes.get(var2)).getEquCode() + ":" + ((Equipes)this.lesEquipes.get(var2)).getEquNomFr()));
         }
      }

      if (this.optionVentes.getResponsable().equals("1") || this.optionVentes.getResponsable().equals("2")) {
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

   }

   public void calculeResponsableLie() throws HibernateException, HibernateException, NamingException {
      this.calculeResponsableLie((Session)null);
   }

   public void calculeResponsableLie(Session var1) throws HibernateException, HibernateException, NamingException {
      if (this.optionVentes.getResponsable().equals("1")) {
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

   public void chargerAnnees(Session var1) throws IOException, HibernateException, NamingException {
      this.anneeItems.clear();
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectExercicesVentes(var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            this.anneeItems.add(new SelectItem(((ExercicesVentes)var3.get(var4)).getExevteId()));
         }

         this.anneeRec = "" + this.exercicesVentes.getExevteId();
      }

   }

   public void chargerServices(Session var1) throws HibernateException, NamingException {
      this.serviceItems.clear();
      ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.serviceItems = var2.chargerLesServicesItems(0, false, var1);
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
      }

   }

   public void chargerLesAffaires() throws HibernateException, NamingException, ParseException {
      this.chargerLesAffaires((Session)null);
   }

   public void chargerLesAffaires(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesAffaires.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansAnalytiques");
         var2 = true;
      }

      String var3 = "";
      if (this.dossierRec != null && !this.dossierRec.isEmpty()) {
         String[] var4 = this.dossierRec.split(":");
         var3 = var4[0];
      }

      String var6 = "";
      String var5 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var6 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var5 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var6 = null;
         var5 = null;
      }

      this.lesAffaires = this.plansAnalytiquesDao.chargerLesAffaires(this.periode, this.affaireRec, var6, var5, this.serviceRec, this.etatRec, this.modeRec, var3, this.userRec, this.comRec, this.tiersRec, var1);
      this.dataModelAffaires.setWrappedData(this.lesAffaires);
      this.afficheButtOption = false;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionAffaires() throws HibernateException, NamingException, IOException {
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
            this.plansAnalytiques = (PlansAnalytiques)var1.get(0);
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "AffaireEntete");
            this.tiers = this.tiersDao.selectTierD(this.plansAnalytiques.getAnaAffaireIdClient(), var6);
            if (this.tiers != null) {
               this.mesContactItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var6);
            } else {
               this.tiers = new Tiers();
            }

            if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
               this.mesContactItem = new ArrayList();
               this.mesContactItem.add(new SelectItem(0, ""));
            }

            if (this.plansAnalytiques.getAnaAffaireAvion() == 1) {
               this.modeAvion = true;
            } else {
               this.modeAvion = false;
            }

            if (this.plansAnalytiques.getAnaAffaireBateau() == 1) {
               this.modeBateau = true;
            } else {
               this.modeBateau = false;
            }

            if (this.plansAnalytiques.getAnaAffaireExpress() == 1) {
               this.modeExpress = true;
            } else {
               this.modeExpress = false;
            }

            if (this.plansAnalytiques.getAnaAffaireRoute() == 1) {
               this.modeRoute = true;
            } else {
               this.modeRoute = false;
            }

            if (this.plansAnalytiques.getAnaAffaireTrain() == 1) {
               this.modeTrain = true;
            } else {
               this.modeTrain = false;
            }

            if (this.plansAnalytiques.getAnaAffaireReachem1() == 1) {
               this.modeReachemin1 = true;
            } else {
               this.modeReachemin1 = false;
            }

            if (this.plansAnalytiques.getAnaAffaireReachem2() == 1) {
               this.modeReachemin2 = true;
            } else {
               this.modeReachemin2 = false;
            }

            if (this.plansAnalytiques.getAnaAffaireReachem3() == 1) {
               this.modeReachemin3 = true;
            } else {
               this.modeReachemin3 = false;
            }

            this.var_nom_responsable = this.plansAnalytiques.getAnaAffaireIdResponsable();
            this.var_nom_commercial = this.plansAnalytiques.getAnaAffaireIdCommercial();
            if (this.plansAnalytiques.getAnaTypeDossier() != null && !this.plansAnalytiques.getAnaTypeDossier().isEmpty() && this.mesNaturesAffaires.size() != 0) {
               this.dossierSelectionne = "";

               for(int var4 = 0; var4 < this.mesNaturesAffaires.size(); ++var4) {
                  String[] var5 = ((SelectItem)this.mesNaturesAffaires.get(var4)).getValue().toString().split(":");
                  if (var5[0].equals(this.plansAnalytiques.getAnaTypeDossier())) {
                     this.dossierSelectionne = ((SelectItem)this.mesNaturesAffaires.get(var4)).getValue().toString();
                  }
               }
            } else {
               this.dossierSelectionne = "";
            }

            this.chargerDocumentAchats(var6);
            this.chargerDocumentVentes(var6);
            this.chargerDocumentStocks(var6);
            this.chargerDocumentScan();
            this.chargerUserChrono(var6);
            this.effaceDetail();
            this.utilInitHibernate.closeSession();
            this.afficheButtOption = true;
         } else {
            this.afficheButtOption = false;
         }
      } else {
         this.afficheButtOption = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.plansAnalytiques != null) {
         this.modifierAffaires();
      }

   }

   public void chargerDocumentAchats(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      this.lesDevis.clear();
      var2 = "cotAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesCotations = this.cotationEnteteAchatsDao.rechercheCotationRequete(var2, var1);
      this.dataModelCotations.setWrappedData(this.lesCotations);
      this.lesCommandes.clear();
      var2 = "cmdAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesCommandesAch = this.commandeEnteteAchatsDao.rechercheCommandeRequete(var2, var1);
      this.dataModelCommandesAch.setWrappedData(this.lesCommandesAch);
      this.lesReceptions.clear();
      var2 = "recAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesReceptions = this.receptionEnteteAchatsDao.rechercheReceptionRequete(var2, var1);
      this.dataModelReceptons.setWrappedData(this.lesReceptions);
      this.lesRetoursAch.clear();
      var2 = "brfAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesRetoursAch = this.retourEnteteAchatsDao.rechercheRetourRequete(var2, var1);
      this.dataModelRetoursAch.setWrappedData(this.lesRetoursAch);
      this.lesFacturesAch.clear();
      var2 = "fcfAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesFacturesAch = this.factureEnteteAchatsDao.rechercheFactureRequete(var2, var1);
      this.dataModelFacturesAch.setWrappedData(this.lesFacturesAch);
      this.lesNotesDebitAch.clear();
      var2 = "ndfAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesNotesDebitAch = this.noteDebitEnteteAchatsDao.rechercheNoteDebitRequete(var2, var1);
      this.dataModelNotesDebitAch.setWrappedData(this.lesNotesDebitAch);
      this.lesAvoirsAch.clear();
      var2 = "avfAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesAvoirsAch = this.avoirEnteteAchatsDao.rechercheAvoirRequete(var2, var1);
      this.dataModelAvoirsAch.setWrappedData(this.lesAvoirsAch);
   }

   public void chargerDocumentVentes(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      this.lesDevis.clear();
      var2 = "dvsAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesDevis = this.devisEnteteVentesDao.rechercheDevisRequete(var2, var1);
      this.dataModelDevis.setWrappedData(this.lesDevis);
      this.lesCommandes.clear();
      var2 = "bcmAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesCommandes = this.commandeEnteteVentesDao.rechercheCommandeRequete(var2, var1);
      this.dataModelCommandes.setWrappedData(this.lesCommandes);
      this.lesLivraisons.clear();
      var2 = "blvAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesLivraisons = this.livraisonEnteteVentesDao.rechercheLivraisonRequete(var2, var1);
      this.dataModelLivraisons.setWrappedData(this.lesLivraisons);
      this.lesRetours.clear();
      var2 = "brtAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesRetours = this.retourEnteteVentesDao.rechercheRetourRequete(var2, var1);
      this.dataModelRetours.setWrappedData(this.lesRetours);
      this.lesFactures.clear();
      var2 = "facAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesFactures = this.factureEnteteVentesDao.rechercheFactureRequete(var2, var1);
      this.dataModelFactures.setWrappedData(this.lesFactures);
      this.lesNotesDebit.clear();
      var2 = "ndbAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesNotesDebit = this.noteDebitEnteteVentesDao.rechercheNoteDebitRequete(var2, var1);
      this.dataModelNotesDebit.setWrappedData(this.lesNotesDebit);
      this.lesAvoirs.clear();
      var2 = "avrAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesAvoirs = this.avoirEnteteVentesDao.rechercheAvoirRequete(var2, var1);
      this.dataModelAvoirs.setWrappedData(this.lesAvoirs);
      this.lesReglements.clear();
      var2 = "rglDossier = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesReglements = this.reglementsDao.rechercheReglementsRequete(var2, var1);
      this.dataModelReglements.setWrappedData(this.lesReglements);
   }

   public void chargerDocumentStocks(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      this.lesBonEntrees.clear();
      var2 = "binAnal4 = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesBonEntrees = this.bonEntreeEnteteDao.rechercheBonEntreeRequete(var2, var1);
      this.dataModelBonEntrees.setWrappedData(this.lesBonEntrees);
      this.lesBonSorties.clear();
      var2 = "bouAnal4 = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesBonSorties = this.bonSortieEnteteDao.rechercheBsRequete(var2, var1);
      this.dataModelBonSorties.setWrappedData(this.lesBonSorties);
      this.lesCessions.clear();
      var2 = "cesAnal4 = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesCessions = this.cessionEnteteDao.rechercheCessionRequete(var2, var1);
      this.dataModelCessions.setWrappedData(this.lesCessions);
      this.lesProductions.clear();
      var2 = "fabAnal4 = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
      this.lesProductions = this.fabricationEnteteAchatsDao.rechercheFabricationRequete(var2, var1);
      this.dataModelProductions.setWrappedData(this.lesProductions);
   }

   public void chargerDocumentScan() throws IOException {
      this.lesDocuments.clear();
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         File var1 = new File(this.nomRepertoire);
         if (!var1.exists()) {
            var1.mkdir();
         }

         String var2 = this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode().replace("/", "_");
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

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.plansAnalytiques != null) {
         this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
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

   public void ajouterAffaires() {
      this.tiers = new Tiers();
      this.plansAnalytiques = new PlansAnalytiques();
      this.plansAnalytiques.setAnaNature("10");
      this.plansAnalytiques.setAnaDateCreat(new Date());
      this.plansAnalytiques.setAnaUserCreat(this.usersLog.getUsrid());
      this.mesContactItem = new ArrayList();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.plansAnalytiques.setAnaAffaireDateDemande(new Date());
      this.var_nom_commercial = 0L;
      this.var_nom_contact = 0L;
      this.var_nom_equipe = 0L;
      this.var_nom_responsable = 0L;
      this.dossierSelectionne = "";
      this.modeAvion = false;
      this.modeBateau = false;
      this.modeExpress = false;
      this.modeReachemin1 = false;
      this.modeReachemin2 = false;
      this.modeReachemin3 = false;
      this.modeRoute = false;
      this.modeTrain = false;
      this.var_aff_action = false;
      this.var_aff_detail_tiers = false;
      this.var_valide_doc = false;
      this.var_action = 1;
      this.var_memo_action = this.var_action;
   }

   public void modifierAffaires() {
      this.var_aff_action = false;
      this.var_valide_doc = true;
      this.var_action = 2;
      this.var_memo_action = this.var_action;
   }

   public void consulterAffaires() {
      this.var_aff_action = true;
      this.var_valide_doc = false;
      this.var_action = 3;
      this.var_memo_action = this.var_action;
   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.plansAnalytiques != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansAnalytiques");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.plansAnalytiques.getAnaCode();
            Date var4 = this.plansAnalytiques.getAnaAffaireDateDemande();
            this.lesAffaires.remove(this.plansAnalytiques);
            this.dataModelAffaires.setWrappedData(this.lesAffaires);
            this.utilParapheur.supprimerParapheur(this.plansAnalytiques.getAnaId(), this.nature, var1);
            this.plansAnalytiquesDao.delete(this.plansAnalytiques, var1);
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Suppression Affaire N° " + var3 + " du " + var4);
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

      this.afficheButtOption = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annule() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void save() throws HibernateException, NamingException, IOException, Exception {
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansAnalytiques");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.plansAnalytiques != null) {
            if (this.modeAvion) {
               this.plansAnalytiques.setAnaAffaireAvion(1);
            } else {
               this.plansAnalytiques.setAnaAffaireAvion(0);
            }

            if (this.modeBateau) {
               this.plansAnalytiques.setAnaAffaireBateau(1);
            } else {
               this.plansAnalytiques.setAnaAffaireBateau(0);
            }

            if (this.modeExpress) {
               this.plansAnalytiques.setAnaAffaireExpress(1);
            } else {
               this.plansAnalytiques.setAnaAffaireExpress(0);
            }

            if (this.modeRoute) {
               this.plansAnalytiques.setAnaAffaireRoute(1);
            } else {
               this.plansAnalytiques.setAnaAffaireRoute(0);
            }

            if (this.modeTrain) {
               this.plansAnalytiques.setAnaAffaireTrain(1);
            } else {
               this.plansAnalytiques.setAnaAffaireTrain(0);
            }

            if (this.modeReachemin1) {
               this.plansAnalytiques.setAnaAffaireReachem1(1);
            } else {
               this.plansAnalytiques.setAnaAffaireReachem1(0);
            }

            if (this.modeReachemin2) {
               this.plansAnalytiques.setAnaAffaireReachem2(1);
            } else {
               this.plansAnalytiques.setAnaAffaireReachem2(0);
            }

            if (this.modeReachemin3) {
               this.plansAnalytiques.setAnaAffaireReachem3(1);
            } else {
               this.plansAnalytiques.setAnaAffaireReachem3(0);
            }

            if (this.tiers != null) {
               this.plansAnalytiques.setAnaAffaireIdResponsable(this.tiers.getTieid());
               this.plansAnalytiques.setAnaAffaireNomResponsable(this.tiers.getTieraisonsocialenom());
               this.plansAnalytiques.setAnaAffaireCiviliteResponsable(this.tiers.getTiecivilite());
               this.plansAnalytiques.setAnaAffaireCatClient(this.tiers.getTiecategorie());
            } else {
               this.plansAnalytiques.setAnaAffaireIdResponsable(0L);
               this.plansAnalytiques.setAnaAffaireNomResponsable("");
               this.plansAnalytiques.setAnaAffaireCiviliteResponsable("");
               this.plansAnalytiques.setAnaAffaireCatClient("");
            }

            if (this.var_nom_contact != 0L) {
               this.contacts = this.contactDao.chargerLesContactsById(this.var_nom_contact, var1);
               if (this.contacts != null) {
                  this.plansAnalytiques.setAnaAffaireIdContact(this.contacts.getConid());
                  this.plansAnalytiques.setAnaAffaireNomContact(this.contacts.getConpatronyme());
                  this.plansAnalytiques.setAnaAffaireCiviliteContact(this.contacts.getConcivilite());
               } else {
                  this.plansAnalytiques.setAnaAffaireIdContact(0L);
                  this.plansAnalytiques.setAnaAffaireNomContact("");
                  this.plansAnalytiques.setAnaAffaireCiviliteContact("");
               }
            } else {
               this.plansAnalytiques.setAnaAffaireIdContact(0L);
               this.plansAnalytiques.setAnaAffaireNomContact("");
               this.plansAnalytiques.setAnaAffaireCiviliteContact("");
            }

            Users var3;
            if (this.var_nom_responsable != 0L) {
               new Users();
               var3 = this.usersDao.selectLeUserId(this.var_nom_responsable, var1);
               if (var3 != null) {
                  this.plansAnalytiques.setAnaAffaireIdResponsable(var3.getUsrid());
                  this.plansAnalytiques.setAnaAffaireNomResponsable(var3.getUsrPatronyme());
                  this.plansAnalytiques.setAnaAffaireCiviliteResponsable(var3.getUsrCivilite());
               } else {
                  this.plansAnalytiques.setAnaAffaireIdResponsable(0L);
                  this.plansAnalytiques.setAnaAffaireNomResponsable("");
                  this.plansAnalytiques.setAnaAffaireCiviliteResponsable("");
               }
            } else {
               this.plansAnalytiques.setAnaAffaireIdResponsable(0L);
               this.plansAnalytiques.setAnaAffaireNomResponsable("");
               this.plansAnalytiques.setAnaAffaireCiviliteResponsable("");
            }

            if (this.var_nom_commercial != 0L) {
               new Users();
               var3 = this.usersDao.selectLeUserId(this.var_nom_commercial, var1);
               if (var3 != null) {
                  this.plansAnalytiques.setAnaAffaireIdCommercial(var3.getUsrid());
                  this.plansAnalytiques.setAnaAffaireNomCommercial(var3.getUsrPatronyme());
                  this.plansAnalytiques.setAnaAffaireCiviliteCommercial(var3.getUsrCivilite());
               } else {
                  this.plansAnalytiques.setAnaAffaireIdCommercial(0L);
                  this.plansAnalytiques.setAnaAffaireNomCommercial("");
                  this.plansAnalytiques.setAnaAffaireCiviliteCommercial("");
               }
            } else {
               this.plansAnalytiques.setAnaAffaireIdCommercial(0L);
               this.plansAnalytiques.setAnaAffaireNomCommercial("");
               this.plansAnalytiques.setAnaAffaireCiviliteCommercial("");
            }

            if (this.dossierSelectionne != null && !this.dossierSelectionne.isEmpty() && this.dossierSelectionne.contains(":")) {
               String[] var10 = this.dossierSelectionne.split(":");
               this.plansAnalytiques.setAnaTypeDossier(var10[0]);
            } else {
               this.plansAnalytiques.setAnaTypeDossier("");
            }

            if (this.plansAnalytiques.getAnaAffaireDateDemande() == null) {
               this.plansAnalytiques.setAnaAffaireDateDemande(new Date());
            }

            this.plansAnalytiques.setAnaAnnee("" + (this.plansAnalytiques.getAnaAffaireDateDemande().getYear() + 1900));
            this.plansAnalytiques.setAnaCodeComplet(this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode());
            if (this.plansAnalytiques.getAnaId() == 0L) {
               if (this.plansAnalytiques.getAnaCode() == null || this.plansAnalytiques.getAnaCode().isEmpty()) {
                  var3 = null;
                  Date var11;
                  if (this.plansAnalytiques.getAnaAffaireDateDemande() == null) {
                     var11 = new Date();
                  } else {
                     var11 = this.plansAnalytiques.getAnaAffaireDateDemande();
                  }

                  String var4 = this.calculChrono.numCompose(var11, 127, "", var1);
                  if (var4 == null || var4.isEmpty()) {
                     var4 = "" + (var11.getYear() + 1900) + (var11.getMonth() + 1) + var11.getDay() + var11.getHours() + var11.getMinutes();
                  }

                  this.plansAnalytiques.setAnaCode(var4);
               }

               this.plansAnalytiques.setAnaAffaireEtat(0);
               this.plansAnalytiques.setAnaAffaireEtatVal(0);
               this.plansAnalytiques.setAnaAffaireDateValide((Date)null);
               this.plansAnalytiques = this.plansAnalytiquesDao.insert(this.plansAnalytiques, var1);
               this.var_action = 2;
               this.var_memo_action = this.var_action;
               this.lesAffaires.add(this.plansAnalytiques);
               this.dataModelAffaires.setWrappedData(this.lesAffaires);
               this.simpleSelectionEntete.clear();
               this.extDTable = new HtmlExtendedDataTable();
            } else {
               this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var1);
               this.var_action = 0;
               this.var_memo_action = this.var_action;
               this.afficheButtOption = false;
            }

            if (this.habilitation != null && this.var_action == 0) {
               this.utilParapheur.majParapheur(this.nature, this.habilitation, this.plansAnalytiques.getAnaId(), this.plansAnalytiques.getAnaCode(), this.plansAnalytiques.getAnaAffaireNomClient(), this.plansAnalytiques.getAnaAffaireDateDemande(), "", 0.0D, this.plansAnalytiques.getAnaAffaireMdeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), (String)null, 2, 0, var1);
            }
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

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.plansAnalytiques.setAnaAffaireEtatVal(1);
         this.plansAnalytiques.setAnaAffaireEtat(0);
         this.plansAnalytiques.setAnaAffaireDateValide((Date)null);
         return true;
      } else {
         this.plansAnalytiques.setAnaAffaireEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.plansAnalytiques.setAnaAffaireEtat(1);
               this.plansAnalytiques.setAnaAffaireDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.plansAnalytiques.setAnaAffaireEtat(0);
               this.plansAnalytiques.setAnaAffaireDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void calculerAffaires() throws HibernateException, NamingException {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      float var13 = 0.0F;
      String var14 = "";
      Session var15 = this.utilInitHibernate.getOpenSession(this.baseLog, "AffaireEntete");
      Transaction var16 = null;

      try {
         var16 = var15.beginTransaction();

         for(int var17 = 0; var17 < this.lesAffaires.size(); ++var17) {
            this.plansAnalytiques = (PlansAnalytiques)this.lesAffaires.get(var17);
            this.chargerDocumentAchats(var15);
            this.chargerDocumentVentes(var15);
            this.chargerDocumentStocks(var15);
            var14 = "";
            byte var18;
            if (this.lesCotations.size() != 0) {
               var18 = 0;
               if (var18 < this.lesCotations.size()) {
                  var14 = ((CotationEnteteAchats)this.lesCotations.get(var18)).getCotNomTiers();
               }
            }

            if (this.lesCommandesAch.size() != 0) {
               var18 = 0;
               if (var18 < this.lesCommandesAch.size()) {
                  var14 = ((CommandeEnteteAchats)this.lesCommandesAch.get(var18)).getCmdNomTiers();
               }
            }

            if (this.lesDevis.size() != 0) {
            }

            int var24;
            if (this.lesCommandes.size() != 0) {
               for(var24 = 0; var24 < this.lesCommandes.size(); ++var24) {
                  this.commandeEnteteVentes = (CommandeEnteteVentes)this.lesCommandes.get(var24);
                  this.commandeEnteteVentes.setBcmObservation(var14);
                  this.commandeEnteteVentes = this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var15);
               }
            }

            if (this.lesRetours.size() != 0) {
            }

            if (this.lesFactures.size() != 0) {
            }

            if (this.lesNotesDebit.size() != 0) {
            }

            if (this.lesAvoirs.size() != 0) {
               for(var24 = 0; var24 < this.lesAvoirs.size(); ++var24) {
                  if (((AvoirEnteteVentes)this.lesAvoirs.get(var24)).getAvrEtat() == 1 || ((AvoirEnteteVentes)this.lesAvoirs.get(var24)).getAvrEtat() == 4 || ((AvoirEnteteVentes)this.lesAvoirs.get(var24)).getAvrEtat() == 5) {
                     var9 -= ((AvoirEnteteVentes)this.lesAvoirs.get(var24)).getAvrTotHt();
                  }
               }
            }

            if (this.lesReglements.size() != 0) {
               for(var24 = 0; var24 < this.lesReglements.size(); ++var24) {
                  if (((Reglements)this.lesReglements.get(var24)).getRglOperation().equals("20") || ((Reglements)this.lesReglements.get(var24)).getRglOperation().equals("24") || ((Reglements)this.lesReglements.get(var24)).getRglOperation().equals("25")) {
                     var7 += ((Reglements)this.lesReglements.get(var24)).getRglDepense();
                  }
               }
            }

            var5 = var3 - var1;
            var11 = var9 - var7;
            var13 = (float)this.utilNombre.myRound((var9 - var7) / var9 * 100.0D, 2);
            this.plansAnalytiques.setAnaAffaireCoutTheo(var1);
            this.plansAnalytiques.setAnaAffaireTheo(var3);
            this.plansAnalytiques.setAnaAffaireMargeTheo(var5);
            this.plansAnalytiques.setAnaAffaireCoutReel(var7);
            this.plansAnalytiques.setAnaAffaireReel(var9);
            this.plansAnalytiques.setAnaAffaireMargeReel(var11);
            this.plansAnalytiques.setAnaTypeTauxDevise(var13);
            this.plansAnalytiques.setAnaMissionProprietaire(var14);
            this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var15);
         }

         var16.commit();
      } catch (HibernateException var22) {
         if (var16 != null) {
            var16.rollback();
         }

         throw var22;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void valideDocument() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.plansAnalytiques != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansAnalytiques");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.plansAnalytiques.getAnaAffaireEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.plansAnalytiques.setAnaAffaireEtat(1);
               this.plansAnalytiques.setAnaAffaireDateValide(new Date());
               this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle affaire (C.) N° " + this.plansAnalytiques.getAnaCode() + " du " + this.utilDate.dateToStringSQLLight(this.plansAnalytiques.getAnaAffaireDateDemande()));
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
      if (this.plansAnalytiques != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansAnalytiques");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.plansAnalytiques.getAnaAffaireEtat() == 1) {
               this.plansAnalytiques.setAnaAffaireEtat(0);
               this.plansAnalytiques.setAnaAffaireDateValide((Date)null);
               this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle affaire (C.) N° " + this.plansAnalytiques.getAnaCode() + " du " + this.utilDate.dateToStringSQLLight(this.plansAnalytiques.getAnaAffaireDateDemande()));
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

   public void razDocument() {
      this.cotationEnteteAchats = null;
      this.commandeEnteteAchats = null;
      this.receptionEnteteAchats = null;
      this.devisEnteteVentes = null;
      this.commandeEnteteVentes = null;
      this.livraisonEnteteVentes = null;
      this.effaceDetail();
   }

   public void effaceDetail() {
      this.lesDetails.clear();
      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailCotation() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelCotations.isRowAvailable()) {
         this.cotationEnteteAchats = new CotationEnteteAchats();
         this.cotationEnteteAchats = (CotationEnteteAchats)this.dataModelCotations.getRowData();
         CotationLigneAchatsDao var1 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var2 = var1.chargerLesLignes(this.cotationEnteteAchats, (Session)null);
         if (var2.size() != 0) {
            new LigneDocument();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               LigneDocument var3 = new LigneDocument();
               var3.setLigCode(((CotationLigneAchats)var2.get(var4)).getCotligCode());
               var3.setLigFamille(((CotationLigneAchats)var2.get(var4)).getCotligFamille());
               var3.setLigLibelle(((CotationLigneAchats)var2.get(var4)).getCotligLibelle());
               var3.setLigReference(((CotationLigneAchats)var2.get(var4)).getCotligReference());
               var3.setLigQte(((CotationLigneAchats)var2.get(var4)).getCotligQte());
               var3.setLigQteUtil(((CotationLigneAchats)var2.get(var4)).getCotligQteUtil());
               var3.setLigPu(((CotationLigneAchats)var2.get(var4)).getCotligPu());
               var3.setLigPt(((CotationLigneAchats)var2.get(var4)).getCotligPt());
               var3.setLigPump(((CotationLigneAchats)var2.get(var4)).getCotligPump());
               this.lesDetails.add(var3);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailCommandeAch() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelCommandesAch.isRowAvailable()) {
         this.commandeEnteteAchats = new CommandeEnteteAchats();
         this.commandeEnteteAchats = (CommandeEnteteAchats)this.dataModelCommandesAch.getRowData();
         CommandeLigneAchatsDao var1 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var2 = var1.chargerLesLignes(this.commandeEnteteAchats, (Session)null);
         if (var2.size() != 0) {
            new LigneDocument();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               LigneDocument var3 = new LigneDocument();
               var3.setLigCode(((CommandeLigneAchats)var2.get(var4)).getCmdligCode());
               var3.setLigFamille(((CommandeLigneAchats)var2.get(var4)).getCmdligFamille());
               var3.setLigLibelle(((CommandeLigneAchats)var2.get(var4)).getCmdligLibelle());
               var3.setLigReference(((CommandeLigneAchats)var2.get(var4)).getCmdligReference());
               var3.setLigQte(((CommandeLigneAchats)var2.get(var4)).getCmdligQte());
               var3.setLigQteUtil(((CommandeLigneAchats)var2.get(var4)).getCmdligQteUtil());
               var3.setLigPu(((CommandeLigneAchats)var2.get(var4)).getCmdligPu());
               var3.setLigPt(((CommandeLigneAchats)var2.get(var4)).getCmdligPt());
               var3.setLigPump(((CommandeLigneAchats)var2.get(var4)).getCmdligPump());
               this.lesDetails.add(var3);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailReception() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelReceptons.isRowAvailable()) {
         this.receptionEnteteAchats = new ReceptionEnteteAchats();
         this.receptionEnteteAchats = (ReceptionEnteteAchats)this.dataModelReceptons.getRowData();
         ReceptionLigneAchatsDao var1 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var2 = var1.chargerLesLignes((ReceptionEnteteAchats)this.receptionEnteteAchats, (Session)null);
         if (var2.size() != 0) {
            new LigneDocument();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               LigneDocument var3 = new LigneDocument();
               var3.setLigCode(((ReceptionLigneAchats)var2.get(var4)).getRecligCode());
               var3.setLigFamille(((ReceptionLigneAchats)var2.get(var4)).getRecligFamille());
               var3.setLigLibelle(((ReceptionLigneAchats)var2.get(var4)).getRecligLibelle());
               var3.setLigReference(((ReceptionLigneAchats)var2.get(var4)).getRecligReference());
               var3.setLigQte(((ReceptionLigneAchats)var2.get(var4)).getRecligQte());
               var3.setLigQteUtil(((ReceptionLigneAchats)var2.get(var4)).getRecligQteUtil());
               var3.setLigPu(((ReceptionLigneAchats)var2.get(var4)).getRecligPu());
               var3.setLigPt(((ReceptionLigneAchats)var2.get(var4)).getRecligPt());
               var3.setLigPump(((ReceptionLigneAchats)var2.get(var4)).getRecligPump());
               this.lesDetails.add(var3);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailRetourAch() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelRetoursAch.isRowAvailable()) {
         new RetourEnteteAchats();
         RetourEnteteAchats var1 = (RetourEnteteAchats)this.dataModelRetoursAch.getRowData();
         RetourLigneAchatsDao var2 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes(var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((RetourLigneAchats)var3.get(var5)).getBrfligCode());
               var4.setLigFamille(((RetourLigneAchats)var3.get(var5)).getBrfligFamille());
               var4.setLigLibelle(((RetourLigneAchats)var3.get(var5)).getBrfligLibelle());
               var4.setLigReference(((RetourLigneAchats)var3.get(var5)).getBrfligReference());
               var4.setLigQte(((RetourLigneAchats)var3.get(var5)).getBrfligQte());
               var4.setLigQteUtil(((RetourLigneAchats)var3.get(var5)).getBrfligQteUtil());
               var4.setLigPu(((RetourLigneAchats)var3.get(var5)).getBrfligPu());
               var4.setLigPt(((RetourLigneAchats)var3.get(var5)).getBrfligPt());
               var4.setLigPump(((RetourLigneAchats)var3.get(var5)).getBrfligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailFactureAch() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelFacturesAch.isRowAvailable()) {
         new FactureEnteteAchats();
         FactureEnteteAchats var1 = (FactureEnteteAchats)this.dataModelFacturesAch.getRowData();
         FactureLigneAchatsDao var2 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes(var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((FactureLigneAchats)var3.get(var5)).getFcfligCode());
               var4.setLigFamille(((FactureLigneAchats)var3.get(var5)).getFcfligFamille());
               var4.setLigLibelle(((FactureLigneAchats)var3.get(var5)).getFcfligLibelle());
               var4.setLigReference(((FactureLigneAchats)var3.get(var5)).getFcfligReference());
               var4.setLigQte(((FactureLigneAchats)var3.get(var5)).getFcfligQte());
               var4.setLigQteUtil(((FactureLigneAchats)var3.get(var5)).getFcfligQteUtil());
               var4.setLigPu(((FactureLigneAchats)var3.get(var5)).getFcfligPu());
               var4.setLigPt(((FactureLigneAchats)var3.get(var5)).getFcfligPt());
               var4.setLigPump(((FactureLigneAchats)var3.get(var5)).getFcfligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailNoteDebitAch() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelNotesDebitAch.isRowAvailable()) {
         new NoteDebitEnteteAchats();
         NoteDebitEnteteAchats var1 = (NoteDebitEnteteAchats)this.dataModelNotesDebitAch.getRowData();
         NoteDebitLigneAchatsDao var2 = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes(var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((NoteDebitLigneAchats)var3.get(var5)).getNdfligCode());
               var4.setLigFamille(((NoteDebitLigneAchats)var3.get(var5)).getNdfligFamille());
               var4.setLigLibelle(((NoteDebitLigneAchats)var3.get(var5)).getNdfligLibelle());
               var4.setLigReference(((NoteDebitLigneAchats)var3.get(var5)).getNdfligReference());
               var4.setLigQte(((NoteDebitLigneAchats)var3.get(var5)).getNdfligQte());
               var4.setLigQteUtil(((NoteDebitLigneAchats)var3.get(var5)).getNdfligQteUtil());
               var4.setLigPu(((NoteDebitLigneAchats)var3.get(var5)).getNdfligPu());
               var4.setLigPt(((NoteDebitLigneAchats)var3.get(var5)).getNdfligPt());
               var4.setLigPump(((NoteDebitLigneAchats)var3.get(var5)).getNdfligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailAvoirAch() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelAvoirsAch.isRowAvailable()) {
         new AvoirEnteteAchats();
         AvoirEnteteAchats var1 = (AvoirEnteteAchats)this.dataModelAvoirsAch.getRowData();
         AvoirLigneAchatsDao var2 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes(var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((AvoirLigneAchats)var3.get(var5)).getAvfligCode());
               var4.setLigFamille(((AvoirLigneAchats)var3.get(var5)).getAvfligFamille());
               var4.setLigLibelle(((AvoirLigneAchats)var3.get(var5)).getAvfligLibelle());
               var4.setLigReference(((AvoirLigneAchats)var3.get(var5)).getAvfligReference());
               var4.setLigQte(((AvoirLigneAchats)var3.get(var5)).getAvfligQte());
               var4.setLigQteUtil(((AvoirLigneAchats)var3.get(var5)).getAvfligQteUtil());
               var4.setLigPu(((AvoirLigneAchats)var3.get(var5)).getAvfligPu());
               var4.setLigPt(((AvoirLigneAchats)var3.get(var5)).getAvfligPt());
               var4.setLigPump(((AvoirLigneAchats)var3.get(var5)).getAvfligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailDevis() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelDevis.isRowAvailable()) {
         this.devisEnteteVentes = new DevisEnteteVentes();
         this.devisEnteteVentes = (DevisEnteteVentes)this.dataModelDevis.getRowData();
         DevisLigneVentesDao var1 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var2 = var1.chargerLesLignes(this.devisEnteteVentes, (Session)null);
         if (var2.size() != 0) {
            new LigneDocument();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               LigneDocument var3 = new LigneDocument();
               var3.setLigCode(((DevisLigneVentes)var2.get(var4)).getDvsligCode());
               var3.setLigFamille(((DevisLigneVentes)var2.get(var4)).getDvsligFamille());
               var3.setLigLibelle(((DevisLigneVentes)var2.get(var4)).getDvsligLibelle());
               var3.setLigReference(((DevisLigneVentes)var2.get(var4)).getDvsligReference());
               var3.setLigQte(((DevisLigneVentes)var2.get(var4)).getDvsligQte());
               var3.setLigQteUtil(((DevisLigneVentes)var2.get(var4)).getDvsligQteUtil());
               var3.setLigPu(((DevisLigneVentes)var2.get(var4)).getDvsligPu());
               var3.setLigPt(((DevisLigneVentes)var2.get(var4)).getDvsligPt());
               var3.setLigPump(((DevisLigneVentes)var2.get(var4)).getDvsligPump());
               this.lesDetails.add(var3);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailCommandeVte() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelCommandes.isRowAvailable()) {
         this.commandeEnteteVentes = new CommandeEnteteVentes();
         this.commandeEnteteVentes = (CommandeEnteteVentes)this.dataModelCommandes.getRowData();
         CommandeLigneVentesDao var1 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var2 = var1.chargerLesLignes(this.commandeEnteteVentes, (Session)null);
         if (var2.size() != 0) {
            new LigneDocument();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               LigneDocument var3 = new LigneDocument();
               var3.setLigCode(((CommandeLigneVentes)var2.get(var4)).getBcmligCode());
               var3.setLigFamille(((CommandeLigneVentes)var2.get(var4)).getBcmligFamille());
               var3.setLigLibelle(((CommandeLigneVentes)var2.get(var4)).getBcmligLibelle());
               var3.setLigReference(((CommandeLigneVentes)var2.get(var4)).getBcmligReference());
               var3.setLigQte(((CommandeLigneVentes)var2.get(var4)).getBcmligQte());
               var3.setLigQteUtil(((CommandeLigneVentes)var2.get(var4)).getBcmligQteUtil());
               var3.setLigPu(((CommandeLigneVentes)var2.get(var4)).getBcmligPu());
               var3.setLigPt(((CommandeLigneVentes)var2.get(var4)).getBcmligPt());
               var3.setLigPump(((CommandeLigneVentes)var2.get(var4)).getBcmligPump());
               this.lesDetails.add(var3);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailLivraison() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelLivraisons.isRowAvailable()) {
         this.livraisonEnteteVentes = new LivraisonEnteteVentes();
         this.livraisonEnteteVentes = (LivraisonEnteteVentes)this.dataModelLivraisons.getRowData();
         LivraisonLigneVentesDao var1 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var2 = var1.chargerLesLignes(this.livraisonEnteteVentes, (Session)null);
         if (var2.size() != 0) {
            new LigneDocument();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               LigneDocument var3 = new LigneDocument();
               var3.setLigCode(((LivraisonLigneVentes)var2.get(var4)).getBlvligCode());
               var3.setLigFamille(((LivraisonLigneVentes)var2.get(var4)).getBlvligFamille());
               var3.setLigLibelle(((LivraisonLigneVentes)var2.get(var4)).getBlvligLibelle());
               var3.setLigReference(((LivraisonLigneVentes)var2.get(var4)).getBlvligReference());
               var3.setLigQte(((LivraisonLigneVentes)var2.get(var4)).getBlvligQte());
               var3.setLigQteUtil(((LivraisonLigneVentes)var2.get(var4)).getBlvligQteUtil());
               var3.setLigPu(((LivraisonLigneVentes)var2.get(var4)).getBlvligPu());
               var3.setLigPt(((LivraisonLigneVentes)var2.get(var4)).getBlvligPt());
               var3.setLigPump(((LivraisonLigneVentes)var2.get(var4)).getBlvligPump());
               this.lesDetails.add(var3);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailRetourVte() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelRetours.isRowAvailable()) {
         new RetourEnteteVentes();
         RetourEnteteVentes var1 = (RetourEnteteVentes)this.dataModelRetours.getRowData();
         RetourLigneVentesDao var2 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes(var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((RetourLigneVentes)var3.get(var5)).getBrtligCode());
               var4.setLigFamille(((RetourLigneVentes)var3.get(var5)).getBrtligFamille());
               var4.setLigLibelle(((RetourLigneVentes)var3.get(var5)).getBrtligLibelle());
               var4.setLigReference(((RetourLigneVentes)var3.get(var5)).getBrtligReference());
               var4.setLigQte(((RetourLigneVentes)var3.get(var5)).getBrtligQte());
               var4.setLigQteUtil(((RetourLigneVentes)var3.get(var5)).getBrtligQteUtil());
               var4.setLigPu(((RetourLigneVentes)var3.get(var5)).getBrtligPu());
               var4.setLigPt(((RetourLigneVentes)var3.get(var5)).getBrtligPt());
               var4.setLigPump(((RetourLigneVentes)var3.get(var5)).getBrtligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailFactureVte() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelFactures.isRowAvailable()) {
         new FactureEnteteVentes();
         FactureEnteteVentes var1 = (FactureEnteteVentes)this.dataModelFactures.getRowData();
         FactureLigneVentesDao var2 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes(var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((FactureLigneVentes)var3.get(var5)).getFacligCode());
               var4.setLigFamille(((FactureLigneVentes)var3.get(var5)).getFacligFamille());
               var4.setLigLibelle(((FactureLigneVentes)var3.get(var5)).getFacligLibelle());
               var4.setLigReference(((FactureLigneVentes)var3.get(var5)).getFacligReference());
               var4.setLigQte(((FactureLigneVentes)var3.get(var5)).getFacligQte());
               var4.setLigQteUtil(((FactureLigneVentes)var3.get(var5)).getFacligQteUtil());
               var4.setLigPu(((FactureLigneVentes)var3.get(var5)).getFacligPu());
               var4.setLigPt(((FactureLigneVentes)var3.get(var5)).getFacligPt());
               var4.setLigPump(((FactureLigneVentes)var3.get(var5)).getFacligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailNoteDebitVte() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelNotesDebit.isRowAvailable()) {
         new NoteDebitEnteteVentes();
         NoteDebitEnteteVentes var1 = (NoteDebitEnteteVentes)this.dataModelNotesDebit.getRowData();
         NoteDebitLigneVentesDao var2 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes(var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((NoteDebitLigneVentes)var3.get(var5)).getNdbligCode());
               var4.setLigFamille(((NoteDebitLigneVentes)var3.get(var5)).getNdbligFamille());
               var4.setLigLibelle(((NoteDebitLigneVentes)var3.get(var5)).getNdbligLibelle());
               var4.setLigReference(((NoteDebitLigneVentes)var3.get(var5)).getNdbligReference());
               var4.setLigQte(((NoteDebitLigneVentes)var3.get(var5)).getNdbligQte());
               var4.setLigQteUtil(((NoteDebitLigneVentes)var3.get(var5)).getNdbligQteUtil());
               var4.setLigPu(((NoteDebitLigneVentes)var3.get(var5)).getNdbligPu());
               var4.setLigPt(((NoteDebitLigneVentes)var3.get(var5)).getNdbligPt());
               var4.setLigPump(((NoteDebitLigneVentes)var3.get(var5)).getNdbligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailAvoirVte() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelAvoirs.isRowAvailable()) {
         new AvoirEnteteVentes();
         AvoirEnteteVentes var1 = (AvoirEnteteVentes)this.dataModelAvoirs.getRowData();
         AvoirLigneVentesDao var2 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes(var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((AvoirLigneVentes)var3.get(var5)).getAvrligCode());
               var4.setLigFamille(((AvoirLigneVentes)var3.get(var5)).getAvrligFamille());
               var4.setLigLibelle(((AvoirLigneVentes)var3.get(var5)).getAvrligLibelle());
               var4.setLigReference(((AvoirLigneVentes)var3.get(var5)).getAvrligReference());
               var4.setLigQte(((AvoirLigneVentes)var3.get(var5)).getAvrligQte());
               var4.setLigQteUtil(((AvoirLigneVentes)var3.get(var5)).getAvrligQteUtil());
               var4.setLigPu(((AvoirLigneVentes)var3.get(var5)).getAvrligPu());
               var4.setLigPt(((AvoirLigneVentes)var3.get(var5)).getAvrligPt());
               var4.setLigPump(((AvoirLigneVentes)var3.get(var5)).getAvrligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailBonEntree() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelBonEntrees.isRowAvailable()) {
         new BonEntreeEntete();
         BonEntreeEntete var1 = (BonEntreeEntete)this.dataModelBonEntrees.getRowData();
         BonEntreeLigneDao var2 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes(var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((BonEntreeLigne)var3.get(var5)).getBinligCode());
               var4.setLigFamille(((BonEntreeLigne)var3.get(var5)).getBinligFamille());
               var4.setLigLibelle(((BonEntreeLigne)var3.get(var5)).getBinligLibelle());
               var4.setLigReference(((BonEntreeLigne)var3.get(var5)).getBinligReference());
               var4.setLigQte(((BonEntreeLigne)var3.get(var5)).getBinligQte());
               var4.setLigQteUtil(((BonEntreeLigne)var3.get(var5)).getBinligQteUtil());
               var4.setLigPu(0.0D);
               var4.setLigPt(0.0D);
               var4.setLigPump(((BonEntreeLigne)var3.get(var5)).getBinligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailBonSortie() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelBonSorties.isRowAvailable()) {
         new BonSortieEntete();
         BonSortieEntete var1 = (BonSortieEntete)this.dataModelBonSorties.getRowData();
         BonSortieLigneDao var2 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes(var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((BonSortieLigne)var3.get(var5)).getBouligCode());
               var4.setLigFamille(((BonSortieLigne)var3.get(var5)).getBouligFamille());
               var4.setLigLibelle(((BonSortieLigne)var3.get(var5)).getBouligLibelle());
               var4.setLigReference(((BonSortieLigne)var3.get(var5)).getBouligReference());
               var4.setLigQte(((BonSortieLigne)var3.get(var5)).getBouligQte());
               var4.setLigQteUtil(((BonSortieLigne)var3.get(var5)).getBouligQteUtil());
               var4.setLigPu(0.0D);
               var4.setLigPt(0.0D);
               var4.setLigPump(((BonSortieLigne)var3.get(var5)).getBouligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailCession() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelCessions.isRowAvailable()) {
         new CessionEntete();
         CessionEntete var1 = (CessionEntete)this.dataModelCessions.getRowData();
         CessionLigneDao var2 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes((CessionEntete)var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((CessionLigne)var3.get(var5)).getCesligCode());
               var4.setLigFamille(((CessionLigne)var3.get(var5)).getCesligFamille());
               var4.setLigLibelle(((CessionLigne)var3.get(var5)).getCesligLibelle());
               var4.setLigReference(((CessionLigne)var3.get(var5)).getCesligReference());
               var4.setLigQte(((CessionLigne)var3.get(var5)).getCesligQte());
               var4.setLigQteUtil(((CessionLigne)var3.get(var5)).getCesligQteUtil());
               var4.setLigPu(0.0D);
               var4.setLigPt(0.0D);
               var4.setLigPump(((CessionLigne)var3.get(var5)).getCesligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void detailProduction() throws HibernateException, NamingException {
      this.lesDetails.clear();
      if (this.dataModelProductions.isRowAvailable()) {
         new FabricationEnteteAchats();
         FabricationEnteteAchats var1 = (FabricationEnteteAchats)this.dataModelProductions.getRowData();
         FabricationLigneAchatsDao var2 = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLignes(var1, (Session)null);
         if (var3.size() != 0) {
            new LigneDocument();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               LigneDocument var4 = new LigneDocument();
               var4.setLigCode(((FabricationLigneAchats)var3.get(var5)).getFabligCode());
               var4.setLigFamille(((FabricationLigneAchats)var3.get(var5)).getFabligFamille());
               var4.setLigLibelle(((FabricationLigneAchats)var3.get(var5)).getFabligLibelle());
               var4.setLigReference(((FabricationLigneAchats)var3.get(var5)).getFabligReference());
               var4.setLigQte(((FabricationLigneAchats)var3.get(var5)).getFabligQte());
               var4.setLigQteUtil(((FabricationLigneAchats)var3.get(var5)).getFabligQteUtil());
               var4.setLigPu(0.0D);
               var4.setLigPt(0.0D);
               var4.setLigPump(((FabricationLigneAchats)var3.get(var5)).getFabligPump());
               this.lesDetails.add(var4);
            }
         }
      }

      this.dataModelDetail.setWrappedData(this.lesDetails);
   }

   public void transformerCotationDevis() throws HibernateException, NamingException {
      if (this.plansAnalytiques != null) {
         float var1 = 0.0F;
         if (this.structureLog.getStrcodepays().equals("0077")) {
            var1 = 1.0F;
         }

         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisCotation");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            this.tiers = this.tiersDao.selectTierD(this.plansAnalytiques.getAnaAffaireIdClient(), var2);
            if (this.tiers != null) {
               if (this.tiers.getTietype().equals("1")) {
                  this.tiers.setTietype("2");
                  if (this.tiers.getTiegenre().equals("010")) {
                     this.tiers.setTiegenre("020");
                  } else if (this.tiers.getTiegenre().equals("011")) {
                     this.tiers.setTiegenre("021");
                  }

                  this.tiers = this.tiersDao.modif(this.tiers, var2);
               }

               double var4 = 0.0D;
               double var6 = 0.0D;
               double var8 = 0.0D;
               double var10 = 0.0D;
               ArrayList var12 = new ArrayList();
               new DevisLigneVentes();
               DevisLigneVentesDao var14 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
               new ArrayList();
               new CotationLigneAchats();
               CotationLigneAchatsDao var17 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               this.cotationEnteteAchats = new CotationEnteteAchats();
               int var18 = 0;
               int var19 = 0;

               while(true) {
                  DevisLigneVentes var13;
                  int var20;
                  int var21;
                  if (var19 >= this.lesCotations.size()) {
                     boolean var54 = false;
                     if (this.optionVentes.getNbrJrRelanceDEVIS() != null && !this.optionVentes.getNbrJrRelanceDEVIS().isEmpty()) {
                        var19 = Integer.parseInt(this.optionVentes.getNbrJrRelanceDEVIS());
                     } else {
                        var19 = 0;
                     }

                     boolean var55 = false;
                     if (this.optionVentes.getNbrJrValidDEVIS() != null && !this.optionVentes.getNbrJrValidDEVIS().isEmpty()) {
                        var20 = Integer.parseInt(this.optionVentes.getNbrJrValidDEVIS());
                     } else {
                        var20 = 0;
                     }

                     this.devisEnteteVentes = new DevisEnteteVentes();
                     this.devisEnteteVentes.setDevisVip("");
                     this.devisEnteteVentes.setDvsAccord("");
                     this.devisEnteteVentes.setDvsActivite(this.cotationEnteteAchats.getCotActivite());
                     this.devisEnteteVentes.setDvsAnal2(this.cotationEnteteAchats.getCotAnal2());
                     this.devisEnteteVentes.setDvsAnal4(this.cotationEnteteAchats.getCotAnal4());
                     this.devisEnteteVentes.setDvsAffaire(this.cotationEnteteAchats.getCotAffaire());
                     this.devisEnteteVentes.setDvsAnnexe1(this.cotationEnteteAchats.getCotAnnexe1());
                     this.devisEnteteVentes.setDvsAnnexe2(this.cotationEnteteAchats.getCotAnnexe2());
                     this.devisEnteteVentes.setDvsArrondiReg(this.cotationEnteteAchats.getCotArrondiReg());
                     this.devisEnteteVentes.setDvsBanque(this.structureLog.getStrBanqueDefaut());
                     this.devisEnteteVentes.setDvsBeneficiaire("");
                     this.devisEnteteVentes.setDvsBureau("");
                     this.devisEnteteVentes.setDvsCat(this.tiers.getTiecategorie());
                     this.devisEnteteVentes.setDvsCivilContact(this.plansAnalytiques.getAnaAffaireCiviliteContact());
                     this.devisEnteteVentes.setDvsCivilTiers(this.plansAnalytiques.getAnaAffaireCatClient());
                     this.devisEnteteVentes.setDvsConclusion("");
                     this.devisEnteteVentes.setDvsConclusion1("");
                     this.devisEnteteVentes.setDvsConclusion2("");
                     this.devisEnteteVentes.setDvsConclusion3("");
                     this.devisEnteteVentes.setDvsTypeReg(this.tiers.getTietypereg());
                     if (this.devisEnteteVentes.getDvsTypeReg() == 0) {
                        this.devisEnteteVentes.setDvsConditionReg("Paiement comptant");
                     } else if (this.devisEnteteVentes.getDvsTypeReg() == 1) {
                        this.devisEnteteVentes.setDvsConditionReg("Paiement terme sur date de facture");
                     } else if (this.devisEnteteVentes.getDvsTypeReg() == 2) {
                        this.devisEnteteVentes.setDvsConditionReg("Paiement terme sur fin de mois");
                     } else if (this.devisEnteteVentes.getDvsTypeReg() == 3) {
                        this.devisEnteteVentes.setDvsConditionReg("Paiement arrivée/payé");
                     } else if (this.devisEnteteVentes.getDvsTypeReg() == 4) {
                        this.devisEnteteVentes.setDvsConditionReg("Paiement bon encaissement");
                     } else if (this.devisEnteteVentes.getDvsTypeReg() == 5) {
                        this.devisEnteteVentes.setDvsConditionReg("Paiement comptant, 50% à la commande, le solde à la livraison");
                     }

                     this.devisEnteteVentes.setDvsContener("");
                     this.devisEnteteVentes.setDvsContrat(this.cotationEnteteAchats.getCotContrat());
                     this.devisEnteteVentes.setDvsDate(new Date());
                     this.devisEnteteVentes.setDvsDateARelance1((Date)null);
                     this.devisEnteteVentes.setDvsDateARelance2((Date)null);
                     this.devisEnteteVentes.setDvsDateARelance3((Date)null);
                     this.devisEnteteVentes.setDvsDateAnnule((Date)null);
                     this.devisEnteteVentes.setDvsDateCreat(new Date());
                     this.devisEnteteVentes.setDvsDateEcheReg((Date)null);
                     this.devisEnteteVentes.setDvsDateImp((Date)null);
                     this.devisEnteteVentes.setDvsDateLivraison(this.cotationEnteteAchats.getCotDateLivraison());
                     this.devisEnteteVentes.setDvsDateModif((Date)null);
                     this.devisEnteteVentes.setDvsDateRelance(this.utilDate.datedevaleurTheo(this.devisEnteteVentes.getDvsDate(), var19));
                     this.devisEnteteVentes.setDvsDateRelance2((Date)null);
                     this.devisEnteteVentes.setDvsDateRelance3((Date)null);
                     this.devisEnteteVentes.setDvsDateTransforme((Date)null);
                     this.devisEnteteVentes.setDvsDateValide((Date)null);
                     this.devisEnteteVentes.setDvsDateValidite(this.utilDate.datedevaleurTheo(this.devisEnteteVentes.getDvsDate(), var20));
                     this.devisEnteteVentes.setDvsDevise(this.structureLog.getStrdevise());
                     this.devisEnteteVentes.setDvsEcheanceReliquat((Date)null);
                     this.devisEnteteVentes.setDvsEtat(0);
                     this.devisEnteteVentes.setDvsEtatVal(0);
                     this.devisEnteteVentes.setDvsExoDouane(this.plansAnalytiques.getAnaAffaireExoDouane());
                     this.devisEnteteVentes.setDvsExoTva(this.plansAnalytiques.getAnaAffaireExoTva());
                     this.devisEnteteVentes.setDvsFactorEtat(0);
                     this.devisEnteteVentes.setDvsFactorId(0L);
                     this.devisEnteteVentes.setDvsFactorNom("");
                     this.devisEnteteVentes.setDvsFormule1(this.cotationEnteteAchats.getCotFormule1());
                     this.devisEnteteVentes.setDvsFormule2(this.cotationEnteteAchats.getCotFormule2());
                     if (this.var_timbre != 0) {
                        var21 = this.devisEnteteVentes.getDvsDate().getYear() + 1900;
                        double var58 = this.utilNombre.calculTimbre(this.structureLog, this.devisEnteteVentes.getDvsTotTtc() + this.devisEnteteVentes.getDvsTotTc(), var21, this.devisEnteteVentes.getDvsDevise(), this.devisEnteteVentes.getDvsDate());
                        double var61 = this.utilNombre.myRoundDevise(var58, this.devisEnteteVentes.getDvsDevise());
                        if (var61 != 0.0D) {
                           String var26 = this.utilNombre.beginSimple(var61, this.devisEnteteVentes.getDvsDevise());
                           this.devisEnteteVentes.setDvsFormule2(this.utilNombre.texteTimbre(this.structureLog, var26, var21, this.devisEnteteVentes.getDvsDevise(), this.devisEnteteVentes.getDvsDate()));
                        }
                     }

                     this.devisEnteteVentes.setDvsFournisseur("");
                     this.devisEnteteVentes.setDvsGarde("");
                     this.devisEnteteVentes.setDvsGele(0);
                     this.devisEnteteVentes.setDvsIdCommercial(this.plansAnalytiques.getAnaAffaireIdCommercial());
                     this.devisEnteteVentes.setDvsIdContact(this.plansAnalytiques.getAnaAffaireIdContact());
                     this.devisEnteteVentes.setDvsIdCreateur(this.usersLog.getUsrid());
                     this.devisEnteteVentes.setDvsIdEquipe(0L);
                     this.devisEnteteVentes.setDvsIdModif(0L);
                     this.devisEnteteVentes.setDvsIdResponsable(this.plansAnalytiques.getAnaAffaireIdResponsable());
                     this.devisEnteteVentes.setDvsIncoterm(this.cotationEnteteAchats.getCotIncoterm());
                     this.devisEnteteVentes.setDvsInfo1(this.cotationEnteteAchats.getCotInfo1());
                     this.devisEnteteVentes.setDvsInfo2(this.cotationEnteteAchats.getCotInfo2());
                     this.devisEnteteVentes.setDvsInfo3(this.cotationEnteteAchats.getCotInfo3());
                     this.devisEnteteVentes.setDvsInfo4(this.cotationEnteteAchats.getCotInfo4());
                     this.devisEnteteVentes.setDvsInfo5(this.cotationEnteteAchats.getCotInfo5());
                     this.devisEnteteVentes.setDvsInfo6(this.cotationEnteteAchats.getCotInfo6());
                     this.devisEnteteVentes.setDvsInfo7(this.cotationEnteteAchats.getCotInfo7());
                     this.devisEnteteVentes.setDvsInfo8(this.cotationEnteteAchats.getCotInfo8());
                     this.devisEnteteVentes.setDvsInfo9(this.cotationEnteteAchats.getCotInfo9());
                     this.devisEnteteVentes.setDvsInfo10(this.cotationEnteteAchats.getCotInfo10());
                     this.devisEnteteVentes.setDvsInfoLivraison(this.cotationEnteteAchats.getCotInfoLivraison());
                     this.devisEnteteVentes.setDvsJournalReg("");
                     this.devisEnteteVentes.setDvsLieuLivraison("");
                     this.devisEnteteVentes.setDvsModeConclusion(0);
                     this.devisEnteteVentes.setDvsModeReg("");
                     this.devisEnteteVentes.setDvsModeleImp("");
                     this.devisEnteteVentes.setDvsMotifAnnule("");
                     this.devisEnteteVentes.setDvsMotifRejetCredit("");
                     this.devisEnteteVentes.setDvsNbJourReg(this.tiers.getTienbecheance());
                     this.devisEnteteVentes.setDvsNomCommercial(this.plansAnalytiques.getAnaAffaireNomCommercial());
                     this.devisEnteteVentes.setDvsNomContact(this.plansAnalytiques.getAnaAffaireNomContact());
                     this.devisEnteteVentes.setDvsNomCreateur(this.usersLog.getUsrPatronyme());
                     this.devisEnteteVentes.setDvsNomEquipe("");
                     this.devisEnteteVentes.setDvsNomModif("");
                     this.devisEnteteVentes.setDvsNomResponsable(this.plansAnalytiques.getAnaAffaireNomResponsable());
                     this.devisEnteteVentes.setDvsNomTiers(this.tiers.getTieraisonsocialenom());
                     this.devisEnteteVentes.setDvsSerie(this.tiers.getTieserie());
                     if (this.devisEnteteVentes.getDvsSerie() == null || this.devisEnteteVentes.getDvsSerie().isEmpty()) {
                        this.devisEnteteVentes.setDvsSerie(this.cotationEnteteAchats.getCotSerie());
                     }

                     if (!this.devisEnteteVentes.getDvsSerie().equalsIgnoreCase("X") && !this.devisEnteteVentes.getDvsSerie().isEmpty()) {
                        this.devisEnteteVentes.setDvsNum(this.calculChrono.numCompose(this.devisEnteteVentes.getDvsDate(), this.nature, this.devisEnteteVentes.getDvsSerie(), var2));
                        boolean var57 = false;

                        label520:
                        while(true) {
                           while(true) {
                              if (var57) {
                                 break label520;
                              }

                              new DevisEnteteVentes();
                              DevisEnteteVentes var59 = this.devisEnteteVentesDao.pourParapheurByNum(this.devisEnteteVentes.getDvsNum(), this.devisEnteteVentes.getDvsSerie(), var2);
                              if (var59 != null) {
                                 long var60 = 100000000L * this.usersLog.getUsrid();

                                 for(long var63 = 0L; var63 < var60; ++var63) {
                                 }

                                 this.devisEnteteVentes.setDvsNum(this.calculChrono.numCompose(this.devisEnteteVentes.getDvsDate(), this.nature, this.devisEnteteVentes.getDvsSerie(), var2));
                                 var57 = false;
                              } else {
                                 var57 = true;
                              }
                           }
                        }
                     } else {
                        long var56 = this.devisEnteteVentesDao.selectLastNum(var2);
                        this.devisEnteteVentes.setDvsNum("" + var56);
                     }

                     this.devisEnteteVentes.setDvsObject(this.cotationEnteteAchats.getCotObject());
                     this.devisEnteteVentes.setDvsObservation(this.cotationEnteteAchats.getCotNomTiers());
                     this.devisEnteteVentes.setDvsPays(this.tiers.getTienompays());
                     this.devisEnteteVentes.setDvsPdv(this.tiers.getTiepdv());
                     this.devisEnteteVentes.setDvsPosSignature(0);
                     this.devisEnteteVentes.setDvsRegime("");
                     this.devisEnteteVentes.setDvsRegion(this.tiers.getTieregion());
                     this.devisEnteteVentes.setDvsSecteur(this.tiers.getTiesecteur());
                     this.devisEnteteVentes.setDvsService(this.plansAnalytiques.getAnaAffaireService());
                     this.devisEnteteVentes.setDvsSite(this.usersLog.getUsrSite());
                     this.devisEnteteVentes.setDvsSolde(0);
                     this.devisEnteteVentes.setDvsSource(this.plansAnalytiques.getAnaTierssource());
                     this.devisEnteteVentes.setDvsSuivi(0);
                     this.devisEnteteVentes.setDvsTauxRemise(0.0F);
                     this.devisEnteteVentes.setDvsTauxTc(var1);
                     this.devisEnteteVentes.setDvsTiersRegroupe("");
                     this.devisEnteteVentes.setDvsTotHt(var4);
                     this.devisEnteteVentes.setDvsTotRabais(0.0D);
                     this.devisEnteteVentes.setDvsTotReglement(0.0D);
                     this.devisEnteteVentes.setDvsTotRemise(0.0D);
                     this.devisEnteteVentes.setDvsTotTc(var6);
                     this.devisEnteteVentes.setDvsTotTtc(var8);
                     this.devisEnteteVentes.setDvsTotTva(var10);
                     this.devisEnteteVentes.setDvsTypeTransforme(0);
                     this.devisEnteteVentes.setDvsUserRelance1(0L);
                     this.devisEnteteVentes.setDvsUserRelance2(0L);
                     this.devisEnteteVentes.setDvsUserRelance3(0L);
                     this.devisEnteteVentes.setDvsUtilisation("");
                     this.devisEnteteVentes.setExerciceventes(this.exercicesVentes);
                     this.devisEnteteVentes.setTiers(this.tiers);
                     this.devisEnteteVentes.setUsers(this.usersLog);
                     this.devisEnteteVentes = this.devisEnteteVentesDao.insert(this.devisEnteteVentes, var2);

                     for(var21 = 0; var21 < var12.size(); ++var21) {
                        var13 = (DevisLigneVentes)var12.get(var21);
                        var13.setDevisEnteteVentes(this.devisEnteteVentes);
                        var13.setUnite((Unite)null);
                        var14.insertLigne(var13, var2);
                     }

                     if (this.plansAnalytiques != null) {
                        this.plansAnalytiques.setAnaAffaireDateDevis(this.devisEnteteVentes.getDvsDate());
                        this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var2);
                     }
                     break;
                  }

                  if (((CotationEnteteAchats)this.lesCotations.get(var19)).isVar_select_ligne()) {
                     this.cotationEnteteAchats = (CotationEnteteAchats)this.lesCotations.get(var19);
                     var13 = new DevisLigneVentes();
                     var13.setDevisEnteteVentes((DevisEnteteVentes)null);
                     var13.setDvsligCode("INCOTERM");
                     if (this.cotationEnteteAchats.getCotType() == 1) {
                        if (this.cotationEnteteAchats.getCotLibellePrestation() != null && !this.cotationEnteteAchats.getCotLibellePrestation().isEmpty()) {
                           var13.setDvsligLibelle(this.cotationEnteteAchats.getCotLibellePrestation());
                        } else {
                           var13.setDvsligLibelle("Montant des Prestations techniques");
                        }
                     } else if (this.cotationEnteteAchats.getCotType() == 2) {
                        var13.setDvsligLibelle("ACHATS LOCAUX");
                     } else {
                        if (this.cotationEnteteAchats.getCotModeTransport() == 0) {
                           var13.setDvsligLibelle("Fret Aérien ");
                        } else if (this.cotationEnteteAchats.getCotModeTransport() == 1) {
                           var13.setDvsligLibelle("Fret Maritime");
                        } else if (this.cotationEnteteAchats.getCotModeTransport() == 2) {
                           var13.setDvsligLibelle("Fret Express");
                        } else if (this.cotationEnteteAchats.getCotModeTransport() == 3) {
                           var13.setDvsligLibelle("Fret Routier");
                        } else if (this.cotationEnteteAchats.getCotModeTransport() == 4) {
                           var13.setDvsligLibelle("Fret Ferrovier");
                        } else {
                           var13.setDvsligLibelle("");
                        }

                        if (this.cotationEnteteAchats.getCotDateLivraison() != null) {
                           var20 = (int)((this.cotationEnteteAchats.getCotDateLivraison().getTime() - this.cotationEnteteAchats.getCotDate().getTime()) / 86400000L / 7L);
                           var13.setDvsligLibelle(var13.getDvsligLibelle() + " Délais livraison: " + var20 + " semaine(s)");
                        }

                        if (this.cotationEnteteAchats.getCotInfoLivraison() != null && !this.cotationEnteteAchats.getCotInfoLivraison().isEmpty()) {
                           var13.setDvsligLibelle(var13.getDvsligLibelle() + " Info Livraison:" + this.cotationEnteteAchats.getCotInfoLivraison());
                        }
                     }

                     var12.add(0, var13);
                     List var15 = var17.chargerLesLignes(this.cotationEnteteAchats, var2);
                     if (var15.size() != 0) {
                        for(var20 = 0; var20 < var15.size(); ++var20) {
                           ++var18;
                           CotationLigneAchats var16 = (CotationLigneAchats)var15.get(var20);
                           var13 = new DevisLigneVentes();
                           var13.setDevisEnteteVentes((DevisEnteteVentes)null);
                           var13.setDvsligCode(var16.getCotligCode());
                           var13.setDvsligComplement(var16.getCotligComplement());
                           var13.setDvsligCondition(var16.getCotligCondition());
                           var13.setDvsligDepot(var16.getCotligDepot());
                           var13.setDvsligDescription(var16.getCotligDescription());
                           var13.setDvsligDevise(this.plansAnalytiques.getAnaTiersdevise());
                           var13.setDvsligDiam(var16.getCotligDiam());
                           var13.setDvsligEchelle(var16.getCotligEchelle());
                           var13.setDvsligFamille(var16.getCotligFamille());
                           var13.setDvsligGroupe("");
                           var13.setDvsligHaut(var16.getCotligHaut());
                           var13.setDvsligLarg(var16.getCotligLarg());
                           var13.setDvsligLibelle(var16.getCotligLibelle());
                           var13.setDvsligLong(var16.getCotligLong());
                           var13.setDvsligModeGroupe(0);
                           var13.setDvsligNb(var16.getCotligNb());
                           var13.setDvsligOrdre(var18);
                           var13.setDvsligPoidsBrut(var16.getCotligPoidsBrut());
                           var13.setDvsligPoidsNet(var16.getCotligPoidsNet());
                           var13.setDvsligPrixKg(0.0D);
                           var13.setDvsligProcess(0);
                           var13.setDvsligOrdre(var20);
                           var13.setDvsligQte(var16.getCotligQte());
                           var13.setDvsligQteUtil(var16.getCotligQteUtil());
                           var13.setDvsligPump(var16.getCotligPump());
                           var13.setDvsligReference(var16.getCotligReference());
                           var13.setDvsligStock(var16.getCotligStock());
                           var13.setDvsligUnite(var16.getCotligUnite());
                           var13.setDvsligRabais(0.0D);
                           var13.setDvsligTauxRemise(0.0F);
                           if (var16.getCotligQte() != 0.0F) {
                              var13.setDvsligPu(var16.getCotligPvPropose() / (double)var16.getCotligQte());
                           } else {
                              var13.setDvsligPu(0.0D);
                           }

                           var21 = this.structureLog.getStrformatdevise();
                           float var22 = 0.0F;
                           String var23 = "";
                           int var24 = 0;
                           if (this.cotationEnteteAchats.getCotExoTva() == 0) {
                              if (this.optionVentes.getTvaDefaut() != null && !this.optionVentes.getTvaDefaut().isEmpty()) {
                                 new TaxesVentes();
                                 TaxesVentes var25 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionVentes.getTvaDefaut(), var2);
                                 if (var25 != null) {
                                    var22 = var25.getTaxvteTaux();
                                    var23 = var25.getTaxvteCode();
                                    var24 = var25.getTaxvteType();
                                 }
                              }
                           } else {
                              var22 = 0.0F;
                              var23 = "";
                              var24 = 0;
                           }

                           var13.setDvsligTaxe(var23);
                           var13.setDvsligTauxTaxe(var22);
                           double var62 = var13.getDvsligPu();
                           float var27 = var13.getDvsligQte();
                           if (var13.getDvsligQte() != 0.0F) {
                              if (this.optionVentes.getModeCalculDevis().equals("1")) {
                                 var13.setDvsligQteUtil(var13.getDvsligQte() * var13.getDvsligLong());
                                 var27 = var13.getDvsligQte() * var13.getDvsligLong();
                              } else {
                                 var13.setDvsligQteUtil(var13.getDvsligQte());
                              }
                           } else {
                              var13.setDvsligQteUtil(0.0F);
                           }

                           double var28 = 0.0D;
                           if (var13.getDvsligCondition() != null && !var13.getDvsligCondition().isEmpty() && var13.getDvsligCondition().contains(":")) {
                              var28 = var62 * (double)var27;
                           } else {
                              var28 = var62 * (double)var27;
                           }

                           double var30 = 0.0D;
                           double var32 = 0.0D;
                           if (this.optionVentes.getDecrmtRabais().equals("1")) {
                              var32 = var13.getDvsligRabais();
                           } else if (this.optionVentes.getDecrmtRabais().equals("2")) {
                              var32 = var13.getDvsligRabais() * (double)var13.getDvsligQte();
                           }

                           if (var13.getDvsligTauxRemise() != 0.0F) {
                              var30 = var28 - var28 * (double)var13.getDvsligTauxRemise() / 100.0D - var32;
                           } else {
                              var30 = var28 - var32;
                           }

                           double var34 = this.utilNombre.myRoundFormat(var30, var21);
                           double var36 = var34 * (double)var13.getDvsligTauxTaxe() / 100.0D;
                           if (var24 == 2) {
                              var36 *= -1.0D;
                           }

                           double var38 = this.utilNombre.myRoundFormat(var36, var21);
                           double var40 = var34 + var38;
                           double var42 = 0.0D;
                           if (var13.getDvsligCondition() != null && !var13.getDvsligCondition().isEmpty() && var13.getDvsligCondition().contains(":")) {
                              if (this.optionVentes.getModeCalculDevis().equals("1")) {
                                 var42 = this.utilNombre.myRound(var34 / (double)var13.getDvsligQteUtil(), 2);
                              } else {
                                 var42 = this.utilNombre.myRound(var34 / (double)var13.getDvsligQte(), 2);
                              }
                           } else if (this.optionVentes.getModeCalculDevis().equals("1")) {
                              var42 = this.utilNombre.myRound(var34 / (double)var13.getDvsligQteUtil(), 2);
                           } else {
                              var42 = this.utilNombre.myRound(var34 / (double)var13.getDvsligQte(), 2);
                           }

                           var13.setDvsligPuRem(var42);
                           var13.setDvsligPt(var34);
                           var13.setDvsligTva(var38);
                           if (var1 != 0.0F) {
                              var13.setDvsligTc(this.utilNombre.myRoundDevise(var34 * (double)var1 / 100.0D, this.structureLog.getStrdevise()));
                           } else {
                              var13.setDvsligTc(0.0D);
                           }

                           var13.setDvsligTtc(var40);
                           double var44 = 0.0D;
                           if (var13.getDvsligCondition() != null && !var13.getDvsligCondition().isEmpty() && var13.getDvsligCondition().contains(":")) {
                              if (this.optionVentes.getModeCalculDevis().equals("1")) {
                                 var44 = this.utilNombre.myRound(var40 / (double)var13.getDvsligQteUtil(), 2);
                              } else {
                                 var44 = this.utilNombre.myRound(var40 / (double)var13.getDvsligQte(), 2);
                              }
                           } else if (this.optionVentes.getModeCalculDevis().equals("1")) {
                              var44 = this.utilNombre.myRound(var40 / (double)var13.getDvsligQteUtil(), 2);
                           } else {
                              var44 = this.utilNombre.myRound(var40 / (double)var13.getDvsligQte(), 2);
                           }

                           var13.setDvsligPuRemTtc(var44);
                           double var46 = var62 + var62 * (double)var13.getDvsligTauxTaxe() / 100.0D;
                           var13.setDvsligPuTtc(var46);
                           var12.add(var13);
                           var4 += var13.getDvsligPt();
                           var6 += var13.getDvsligTc();
                           var8 += var13.getDvsligTtc();
                           var10 += var13.getDvsligTva();
                        }
                     }
                  }

                  ++var19;
               }
            }

            var3.commit();
         } catch (HibernateException var51) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var51;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      Session var53 = this.utilInitHibernate.getOpenSession(this.baseLog, "AffaireEntete");
      this.chargerDocumentAchats(var53);
      this.chargerDocumentVentes(var53);
      this.utilInitHibernate.closeSession();
   }

   public void transformerDevisCommande() {
      if (this.devisEnteteVentes != null) {
      }

   }

   public void transformerCotationCommande() {
      if (this.cotationEnteteAchats != null) {
      }

   }

   public void transformerCommandeReception() {
      if (this.commandeEnteteAchats != null) {
      }

   }

   public void transformerCommandeLivraison() {
      if (this.commandeEnteteVentes != null) {
      }

   }

   public void transformerReceptionFacture() {
      if (this.receptionEnteteAchats != null) {
      }

   }

   public void transfrmerLivraisonFacture() {
      if (this.livraisonEnteteVentes != null) {
      }

   }

   public void annulerDocument() {
      if (this.plansAnalytiques != null) {
         this.plansAnalytiques.setAnaAffaireDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.plansAnalytiques != null) {
         if (this.plansAnalytiques.getAnaAffaireDateAnnule() == null) {
            this.plansAnalytiques.setAnaAffaireDateAnnule(new Date());
         }

         this.plansAnalytiques.setAnaAffaireEtat(2);
         this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation Affaire vente N° " + this.plansAnalytiques.getAnaCode() + " le " + this.plansAnalytiques.getAnaAffaireDateDemande());
         this.espionDao.mAJEspion(var1);
         this.lesAffaires.remove(this.plansAnalytiques);
         this.dataModelAffaires.setWrappedData(this.lesAffaires);
      }

      this.showModalPanelAnnuler = false;
      this.afficheButtOption = false;
   }

   public void gelerDocument() {
      if (this.plansAnalytiques != null) {
         this.plansAnalytiques.setAnaAffaireDateAnnule(new Date());
         this.showModalPanelGele = true;
      }

   }

   public void annuleGeler() {
      this.showModalPanelGele = false;
   }

   public void miseajourGeler() throws HibernateException, NamingException {
      if (this.plansAnalytiques != null) {
         if (this.plansAnalytiques.getAnaAffaireDateAnnule() == null) {
            this.plansAnalytiques.setAnaAffaireDateAnnule(new Date());
         }

         this.plansAnalytiques.setAnaAffaireEtat(3);
         this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Geler Affaire vente N° " + this.plansAnalytiques.getAnaCode() + " le " + this.plansAnalytiques.getAnaAffaireDateDemande());
         this.espionDao.mAJEspion(var1);
         this.lesAffaires.remove(this.plansAnalytiques);
         this.dataModelAffaires.setWrappedData(this.lesAffaires);
      }

      this.showModalPanelGele = false;
      this.afficheButtOption = false;
   }

   public void miseajourDeGeler() throws HibernateException, NamingException {
      if (this.plansAnalytiques != null) {
         this.plansAnalytiques.setAnaAffaireEtat(1);
         this.plansAnalytiques.setAnaAffaireDateAnnule((Date)null);
         this.plansAnalytiques.setAnaTiersAdresse("");
         this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Dégeler Affaire vente N° " + this.plansAnalytiques.getAnaCode() + " le " + this.plansAnalytiques.getAnaAffaireDateDemande());
         this.espionDao.mAJEspion(var1);
      }

      this.showModalPanelGele = false;
      this.afficheButtOption = false;
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
      if (this.plansAnalytiques != null && this.uploadedPDFFile != null) {
         File var1 = new File(this.nomRepertoire + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode());
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
               var3 = this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode().replace("/", "_") + "_" + this.filtreCaracteres(this.nomDocument) + "." + var4;
            } else {
               var3 = this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode().replace("/", "_") + "." + var4;
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

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.rechercheTiers(3, this.plansAnalytiques.getAnaAffaireNomClient(), this.nature);
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
         this.plansAnalytiques.setAnaAffaireIdClient(this.tiers.getTieid());
         if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
            this.nomTier = this.tiers.getTieraisonsocialenom();
            this.plansAnalytiques.setAnaAffaireCiviliteClient("");
         } else {
            if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
               this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
            } else {
               this.nomTier = this.tiers.getTieraisonsocialenom();
            }

            this.plansAnalytiques.setAnaAffaireCiviliteClient(this.tiers.getTiecivilite());
         }

         this.plansAnalytiques.setAnaAffaireNomClient(this.nomTier);
         this.calculMessageLitige();
         this.plansAnalytiques.setAnaAffaireCatClient(this.tiers.getTienomfamille());
         this.plansAnalytiques.setAnaAffaireExoDouane(this.tiers.getTieexodouane());
         this.plansAnalytiques.setAnaAffaireExoTva(this.tiers.getTieexotva());
         if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
            this.plansAnalytiques.setAnaAffaireExoTva(1);
         }

         if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
            this.plansAnalytiques.setAnaTiersdevise(this.tiers.getTiedevise());
         } else {
            this.plansAnalytiques.setAnaTiersdevise(this.structureLog.getStrdevise());
         }

         this.chargerLesContactsItem(var1);
         this.chargerLesUsers(var1);
         this.var_aff_detail_tiers = true;
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
      this.plansAnalytiques.setAnaAffaireIdClient(0L);
      this.plansAnalytiques.setAnaAffaireCiviliteClient("");
      this.plansAnalytiques.setAnaAffaireNomClient("");
      this.plansAnalytiques.setAnaAffaireCatClient("");
      this.plansAnalytiques.setAnaAffaireExoDouane(0);
      this.plansAnalytiques.setAnaAffaireExoTva(0);
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.var_aff_detail_tiers = false;
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void chargerLesContactsItem(Session var1) throws HibernateException, NamingException {
      this.mesContactItem = new ArrayList();
      this.mesContactItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var1);
   }

   public void controleSaisie() throws ParseException {
      if (this.dossierSelectionne != null && !this.dossierSelectionne.isEmpty()) {
         if (this.plansAnalytiques.getAnaAffaireNomClient() != null && !this.plansAnalytiques.getAnaAffaireNomClient().isEmpty() && this.tiers.getTieid() != 0L) {
            this.var_valide_doc = true;
            this.var_aff_detail_tiers = true;
         } else {
            this.var_valide_doc = false;
            this.var_aff_detail_tiers = false;
         }
      } else {
         this.var_valide_doc = false;
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

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "affaire" + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatAffaire.jpg");
            if (var4.exists()) {
               var3 = "formatAffaire.jpg";
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
            var3 = "formatAffaire.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansAnalytiques");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.plansAnalytiques.getAnaAffaireEtat() == 0 && this.plansAnalytiques.getAnaAffaireEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.plansAnalytiques.setAnaAffaireEtat(1);
         }

         this.plansAnalytiques.setAnaAffaireMdeleImp(var1);
         if (this.devisEnteteVentesDao == null) {
            this.devisEnteteVentesDao = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         }

         this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var3);
         this.contacts = new Contacts();
         if (this.plansAnalytiques.getAnaAffaireIdContact() != 0L) {
            if (this.contactDao == null) {
               this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
            }

            this.contacts = this.contactDao.chargerLesContactsById(this.plansAnalytiques.getAnaAffaireIdContact(), var3);
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

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpression(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setEntete("Impression affaire");
            var1.setRapport(var3);
            var1.setRapportEncapsule((String)null);
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.plansAnalytiques.getAnaAffaireEtat()));
            var1.setDuplicata("" + var11);
            this.plansAnalytiques.setAnaTiersdevise(this.devisePrint);
            if (!this.plansAnalytiques.getAnaTiersdevise().equals("XOF") && !this.plansAnalytiques.getAnaTiersdevise().equals("XAF")) {
               if (this.plansAnalytiques.getAnaTiersdevise().equals("EUR")) {
                  var1.setNbCar(1);
               } else {
                  var1.setNbCar(0);
               }
            } else {
               var1.setNbCar(2);
            }

            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.plansAnalytiques.getAnaAffaireIdResponsable());
            var1.setIdCommercial(this.plansAnalytiques.getAnaAffaireIdCommercial());
            var1.setTiersSelectionne(this.tiers);
            if (this.contacts == null) {
               this.contacts = new Contacts();
            }

            var1.setContact(this.contacts);
            var1.setNumDoc(this.plansAnalytiques.getAnaCode());
            var1.setNature(this.nature);
            var1.setId_doc(this.plansAnalytiques.getAnaId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 1 && var4 != null && !var4.isEmpty()) {
         if (this.lesAffaires.size() != 0) {
            Session var22 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
            Transaction var12 = null;

            try {
               var12 = var22.beginTransaction();
               int var13 = 0;

               while(true) {
                  if (var13 >= this.lesAffaires.size()) {
                     var12.commit();
                     break;
                  }

                  this.plansAnalytiques = (PlansAnalytiques)this.lesAffaires.get(var13);
                  if (this.plansAnalytiques.getAnaAffaireDateDevisEnvoie() == null && this.plansAnalytiques.getAnaAffaireDateDevis() != null) {
                     Date var14 = null;
                     this.lesDevis.clear();
                     String var15 = "dvsAffaire = '" + this.plansAnalytiques.getAnaTypeDossier() + this.plansAnalytiques.getAnaCode() + "'";
                     this.lesDevis = this.devisEnteteVentesDao.rechercheDevisRequete(var15, var22);
                     if (this.lesDevis.size() != 0) {
                        int var16;
                        for(var16 = 0; var16 < this.lesDevis.size(); ++var16) {
                           if (((DevisEnteteVentes)this.lesDevis.get(var16)).getDvsDateEnvoie() != null) {
                              var14 = ((DevisEnteteVentes)this.lesDevis.get(var16)).getDvsDateEnvoie();
                           }
                        }

                        if (var14 == null) {
                           for(var16 = 0; var16 < this.lesDevis.size(); ++var16) {
                              if (((DevisEnteteVentes)this.lesDevis.get(var16)).getDvsDateImp() != null) {
                                 var14 = ((DevisEnteteVentes)this.lesDevis.get(var16)).getDvsDateImp();
                              }
                           }
                        }
                     }

                     this.plansAnalytiques.setAnaAffaireDateDevisEnvoie(var14);
                     this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var22);
                  }

                  ++var13;
               }
            } catch (HibernateException var20) {
               if (var12 != null) {
                  var12.rollback();
               }

               throw var20;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }

         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des affaires");
         var1.setTotauxHt("");
         var1.setTotauxTaxe("");
         var1.setTotauxTtc("");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "affaire" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.nature);
         String var23 = "";
         if (this.etatRec == 100) {
            var23 = "Tous les états";
         } else if (this.etatRec == 1) {
            var23 = "Etat: Validé interne";
         } else if (this.etatRec == 2) {
            var23 = "Etat: Annulé";
         } else if (this.etatRec == 3) {
            var23 = "Etat: Gelé";
         } else if (this.etatRec == 4) {
            var23 = "Etat: Validé client";
         } else if (this.etatRec == 5) {
            var23 = "Etat: Terminé";
         }

         if (this.modeRec == 99) {
            var23 = var23 + " - " + "Tous les modes";
         } else if (this.modeRec == 0) {
            var23 = var23 + " - " + "Mode: Normal";
         } else if (this.modeRec == 1) {
            var23 = var23 + " - " + "Mode: Urgent";
         } else if (this.modeRec == 2) {
            var23 = var23 + " - " + "Mode: Très Urgent";
         } else if (this.modeRec == 3) {
            var23 = var23 + " - " + "Mode: Appel d`offre";
         }

         if (this.dossierRec != null && !this.dossierRec.isEmpty()) {
            var23 = var23 + " - " + "Type: " + this.dossierRec;
         }

         var1.setFiltre(var23);
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var24 = new JRBeanCollectionDataSource(this.lesAffaires);
         var1.setjRBeanCollectionDataSource(var24);
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
      if (this.lesAffaires.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "AFFAIRES : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "AFFAIRES : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "AFFAIRES : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
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
         if (this.etatRec == 100) {
            this.sousTitreGraph = this.sousTitreGraph + " Tous les Etats";
         } else {
            this.sousTitreGraph = this.sousTitreGraph + " Etats: " + var2.calculeLibelleEtat(this.nature, this.etatRec, 0);
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
         } else if (this.modeGraph == 7) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par source (" + this.uniteGraph + ")";
         }

         new PlansAnalytiques();
         if (this.lesAffaires.size() != 0) {
            var4 = "";
            long var5 = 0L;
            boolean var7 = false;

            for(int var8 = 0; var8 < this.lesAffaires.size(); ++var8) {
               PlansAnalytiques var10 = (PlansAnalytiques)this.lesAffaires.get(var8);
               var4 = "";
               var5 = 0L;
               int var11 = 0;
               if (this.modeGraph == 0) {
                  int var9 = var10.getAnaAffaireDateDemande().getYear() + 1900;
                  var4 = "" + var9;
               } else if (this.modeGraph == 1) {
                  if (var10.getAnaAffaireNomResponsable() != null && !var10.getAnaAffaireNomResponsable().isEmpty()) {
                     var4 = var10.getAnaAffaireNomResponsable();
                  } else {
                     var4 = "Sans Responsable";
                  }
               } else if (this.modeGraph == 2) {
                  if (var10.getAnaAffaireNomCommercial() != null && !var10.getAnaAffaireNomCommercial().isEmpty()) {
                     var4 = var10.getAnaAffaireNomCommercial();
                  } else {
                     var4 = "Sans Commercial";
                  }
               } else if (this.modeGraph == 4) {
                  if (var10.getAnaAffaireNomClient() != null && !var10.getAnaAffaireNomClient().isEmpty()) {
                     var4 = var10.getAnaAffaireNomClient();
                  } else {
                     var4 = "Sans Tiers";
                  }
               } else if (this.modeGraph == 7) {
                  if (var10.getAnaTierssource() != null && !var10.getAnaTierssource().isEmpty()) {
                     var4 = var10.getAnaTierssource();
                  } else {
                     var4 = "Sans Source";
                  }
               } else if (this.modeGraph == 8) {
                  if (var10.getAnaTypeDossier() != null && !var10.getAnaTypeDossier().isEmpty()) {
                     var4 = var10.getAnaTypeDossier();
                  } else {
                     var4 = "Sans Type";
                  }
               } else if (this.modeGraph == 9) {
                  if (var10.getAnaAffaireMode() == 0) {
                     var4 = "Normal";
                  } else if (var10.getAnaAffaireMode() == 1) {
                     var4 = "Urgent";
                  } else if (var10.getAnaAffaireMode() == 2) {
                     var4 = "Tres Urgent";
                  } else if (var10.getAnaAffaireMode() == 3) {
                     var4 = "Appel offre";
                  } else {
                     var4 = "Sans Mode";
                  }
               }

               ++var5;
               if (this.timeDecoupage == 0) {
                  var11 = var10.getAnaAffaireDateDemande().getDate();
               } else if (this.timeDecoupage == 1) {
                  var11 = var10.getAnaAffaireDateDemande().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var10.getAnaAffaireDateDemande().getMonth() + 1 >= 1 && var10.getAnaAffaireDateDemande().getMonth() + 1 <= 3) {
                     var11 = 1;
                  } else if (var10.getAnaAffaireDateDemande().getMonth() + 1 >= 4 && var10.getAnaAffaireDateDemande().getMonth() + 1 <= 6) {
                     var11 = 2;
                  } else if (var10.getAnaAffaireDateDemande().getMonth() + 1 >= 7 && var10.getAnaAffaireDateDemande().getMonth() + 1 <= 9) {
                     var11 = 3;
                  } else if (var10.getAnaAffaireDateDemande().getMonth() + 1 >= 10 && var10.getAnaAffaireDateDemande().getMonth() + 1 <= 12) {
                     var11 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var10.getAnaAffaireDateDemande().getMonth() + 1 >= 1 && var10.getAnaAffaireDateDemande().getMonth() + 1 <= 6) {
                     var11 = 1;
                  } else if (var10.getAnaAffaireDateDemande().getMonth() + 1 >= 7 && var10.getAnaAffaireDateDemande().getMonth() + 1 <= 12) {
                     var11 = 2;
                  }
               } else if (this.timeDecoupage == 4) {
                  var11 = 1;
               } else if (this.timeDecoupage == 5) {
                  var11 = var10.getAnaAffaireDateDemande().getHours();
               }

               var1 = this.calculeListe((List)var1, var4, var11, var5);
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

   public boolean isAfficheButtOption() {
      return this.afficheButtOption;
   }

   public void setAfficheButtOption(boolean var1) {
      this.afficheButtOption = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public ObjetLigneMenu getLigneMenu() {
      return this.ligneMenu;
   }

   public void setLigneMenu(ObjetLigneMenu var1) {
      this.ligneMenu = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
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

   public String getServiceRec() {
      return this.serviceRec;
   }

   public void setServiceRec(String var1) {
      this.serviceRec = var1;
   }

   public List getServiceItems() {
      return this.serviceItems;
   }

   public void setServiceItems(List var1) {
      this.serviceItems = var1;
   }

   public List getAnneeItems() {
      return this.anneeItems;
   }

   public void setAnneeItems(List var1) {
      this.anneeItems = var1;
   }

   public String getAnneeRec() {
      return this.anneeRec;
   }

   public void setAnneeRec(String var1) {
      this.anneeRec = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getEtatRec() {
      return this.etatRec;
   }

   public void setEtatRec(int var1) {
      this.etatRec = var1;
   }

   public DataModel getDataModelAffaires() {
      return this.dataModelAffaires;
   }

   public void setDataModelAffaires(DataModel var1) {
      this.dataModelAffaires = var1;
   }

   public PlansAnalytiques getPlansAnalytiques() {
      return this.plansAnalytiques;
   }

   public void setPlansAnalytiques(PlansAnalytiques var1) {
      this.plansAnalytiques = var1;
   }

   public long getUserRec() {
      return this.userRec;
   }

   public void setUserRec(long var1) {
      this.userRec = var1;
   }

   public String getTiersRec() {
      return this.tiersRec;
   }

   public void setTiersRec(String var1) {
      this.tiersRec = var1;
   }

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public double getMargeReel() {
      return this.margeReel;
   }

   public void setMargeReel(double var1) {
      this.margeReel = var1;
   }

   public double getMargeTheo() {
      return this.margeTheo;
   }

   public void setMargeTheo(double var1) {
      this.margeTheo = var1;
   }

   public DataModel getDataModelAvoirs() {
      return this.dataModelAvoirs;
   }

   public void setDataModelAvoirs(DataModel var1) {
      this.dataModelAvoirs = var1;
   }

   public DataModel getDataModelCommandes() {
      return this.dataModelCommandes;
   }

   public void setDataModelCommandes(DataModel var1) {
      this.dataModelCommandes = var1;
   }

   public DataModel getDataModelDevis() {
      return this.dataModelDevis;
   }

   public void setDataModelDevis(DataModel var1) {
      this.dataModelDevis = var1;
   }

   public DataModel getDataModelFactures() {
      return this.dataModelFactures;
   }

   public void setDataModelFactures(DataModel var1) {
      this.dataModelFactures = var1;
   }

   public DataModel getDataModelLivraisons() {
      return this.dataModelLivraisons;
   }

   public void setDataModelLivraisons(DataModel var1) {
      this.dataModelLivraisons = var1;
   }

   public DataModel getDataModelNotesDebit() {
      return this.dataModelNotesDebit;
   }

   public void setDataModelNotesDebit(DataModel var1) {
      this.dataModelNotesDebit = var1;
   }

   public DataModel getDataModelRetours() {
      return this.dataModelRetours;
   }

   public void setDataModelRetours(DataModel var1) {
      this.dataModelRetours = var1;
   }

   public DataModel getDataModelReglements() {
      return this.dataModelReglements;
   }

   public void setDataModelReglements(DataModel var1) {
      this.dataModelReglements = var1;
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

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public String getInformationsTiers() {
      return this.informationsTiers;
   }

   public void setInformationsTiers(String var1) {
      this.informationsTiers = var1;
   }

   public List getLesFamilleClientsListe() {
      return this.lesFamilleClientsListe;
   }

   public void setLesFamilleClientsListe(List var1) {
      this.lesFamilleClientsListe = var1;
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

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public List getMesCommercialItem() {
      return this.mesCommercialItem;
   }

   public void setMesCommercialItem(List var1) {
      this.mesCommercialItem = var1;
   }

   public List getMesEquipeItem() {
      return this.mesEquipeItem;
   }

   public void setMesEquipeItem(List var1) {
      this.mesEquipeItem = var1;
   }

   public boolean isVar_aff_detail_tiers() {
      return this.var_aff_detail_tiers;
   }

   public void setVar_aff_detail_tiers(boolean var1) {
      this.var_aff_detail_tiers = var1;
   }

   public long getVar_nom_commercial() {
      return this.var_nom_commercial;
   }

   public void setVar_nom_commercial(long var1) {
      this.var_nom_commercial = var1;
   }

   public long getVar_nom_contact() {
      return this.var_nom_contact;
   }

   public void setVar_nom_contact(long var1) {
      this.var_nom_contact = var1;
   }

   public long getVar_nom_equipe() {
      return this.var_nom_equipe;
   }

   public void setVar_nom_equipe(long var1) {
      this.var_nom_equipe = var1;
   }

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
   }

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
   }

   public boolean isVar_verrou_comm() {
      return this.var_verrou_comm;
   }

   public void setVar_verrou_comm(boolean var1) {
      this.var_verrou_comm = var1;
   }

   public String getDossierRec() {
      return this.dossierRec;
   }

   public void setDossierRec(String var1) {
      this.dossierRec = var1;
   }

   public int getModeRec() {
      return this.modeRec;
   }

   public void setModeRec(int var1) {
      this.modeRec = var1;
   }

   public List getMesNaturesAffaires() {
      return this.mesNaturesAffaires;
   }

   public void setMesNaturesAffaires(List var1) {
      this.mesNaturesAffaires = var1;
   }

   public String getDossierSelectionne() {
      return this.dossierSelectionne;
   }

   public void setDossierSelectionne(String var1) {
      this.dossierSelectionne = var1;
   }

   public boolean isModeAvion() {
      return this.modeAvion;
   }

   public void setModeAvion(boolean var1) {
      this.modeAvion = var1;
   }

   public boolean isModeBateau() {
      return this.modeBateau;
   }

   public void setModeBateau(boolean var1) {
      this.modeBateau = var1;
   }

   public boolean isModeExpress() {
      return this.modeExpress;
   }

   public void setModeExpress(boolean var1) {
      this.modeExpress = var1;
   }

   public boolean isModeReachemin1() {
      return this.modeReachemin1;
   }

   public void setModeReachemin1(boolean var1) {
      this.modeReachemin1 = var1;
   }

   public boolean isModeReachemin2() {
      return this.modeReachemin2;
   }

   public void setModeReachemin2(boolean var1) {
      this.modeReachemin2 = var1;
   }

   public boolean isModeReachemin3() {
      return this.modeReachemin3;
   }

   public void setModeReachemin3(boolean var1) {
      this.modeReachemin3 = var1;
   }

   public boolean isModeRoute() {
      return this.modeRoute;
   }

   public void setModeRoute(boolean var1) {
      this.modeRoute = var1;
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

   public DataModel getDataModelDocumnts() {
      return this.dataModelDocumnts;
   }

   public void setDataModelDocumnts(DataModel var1) {
      this.dataModelDocumnts = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public Parapheur getParapheur() {
      return this.parapheur;
   }

   public void setParapheur(Parapheur var1) {
      this.parapheur = var1;
   }

   public long getComRec() {
      return this.comRec;
   }

   public void setComRec(long var1) {
      this.comRec = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public boolean isShowModalPanelGele() {
      return this.showModalPanelGele;
   }

   public void setShowModalPanelGele(boolean var1) {
      this.showModalPanelGele = var1;
   }

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
   }

   public String getDevisePrint() {
      return this.devisePrint;
   }

   public void setDevisePrint(String var1) {
      this.devisePrint = var1;
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

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
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

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public boolean isShowModele() {
      return this.showModele;
   }

   public void setShowModele(boolean var1) {
      this.showModele = var1;
   }

   public boolean isExistParapheur() {
      return this.existParapheur;
   }

   public void setExistParapheur(boolean var1) {
      this.existParapheur = var1;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }

   public DataModel getDataModelAvoirsAch() {
      return this.dataModelAvoirsAch;
   }

   public void setDataModelAvoirsAch(DataModel var1) {
      this.dataModelAvoirsAch = var1;
   }

   public DataModel getDataModelCommandesAch() {
      return this.dataModelCommandesAch;
   }

   public void setDataModelCommandesAch(DataModel var1) {
      this.dataModelCommandesAch = var1;
   }

   public DataModel getDataModelCotations() {
      return this.dataModelCotations;
   }

   public void setDataModelCotations(DataModel var1) {
      this.dataModelCotations = var1;
   }

   public DataModel getDataModelFacturesAch() {
      return this.dataModelFacturesAch;
   }

   public void setDataModelFacturesAch(DataModel var1) {
      this.dataModelFacturesAch = var1;
   }

   public DataModel getDataModelNotesDebitAch() {
      return this.dataModelNotesDebitAch;
   }

   public void setDataModelNotesDebitAch(DataModel var1) {
      this.dataModelNotesDebitAch = var1;
   }

   public DataModel getDataModelReceptons() {
      return this.dataModelReceptons;
   }

   public void setDataModelReceptons(DataModel var1) {
      this.dataModelReceptons = var1;
   }

   public DataModel getDataModelRetoursAch() {
      return this.dataModelRetoursAch;
   }

   public void setDataModelRetoursAch(DataModel var1) {
      this.dataModelRetoursAch = var1;
   }

   public DataModel getDataModelBonEntrees() {
      return this.dataModelBonEntrees;
   }

   public void setDataModelBonEntrees(DataModel var1) {
      this.dataModelBonEntrees = var1;
   }

   public DataModel getDataModelBonSorties() {
      return this.dataModelBonSorties;
   }

   public void setDataModelBonSorties(DataModel var1) {
      this.dataModelBonSorties = var1;
   }

   public DataModel getDataModelCessions() {
      return this.dataModelCessions;
   }

   public void setDataModelCessions(DataModel var1) {
      this.dataModelCessions = var1;
   }

   public DataModel getDataModelProductions() {
      return this.dataModelProductions;
   }

   public void setDataModelProductions(DataModel var1) {
      this.dataModelProductions = var1;
   }

   public String getAffaireRec() {
      return this.affaireRec;
   }

   public void setAffaireRec(String var1) {
      this.affaireRec = var1;
   }

   public DataModel getDataModelDetail() {
      return this.dataModelDetail;
   }

   public void setDataModelDetail(DataModel var1) {
      this.dataModelDetail = var1;
   }

   public boolean isModeTrain() {
      return this.modeTrain;
   }

   public void setModeTrain(boolean var1) {
      this.modeTrain = var1;
   }

   public int getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(int var1) {
      this.var_timbre = var1;
   }

   public boolean isFrsPrp1() {
      return this.frsPrp1;
   }

   public void setFrsPrp1(boolean var1) {
      this.frsPrp1 = var1;
   }

   public boolean isFrsPrp2() {
      return this.frsPrp2;
   }

   public void setFrsPrp2(boolean var1) {
      this.frsPrp2 = var1;
   }

   public boolean isFrsPrp3() {
      return this.frsPrp3;
   }

   public void setFrsPrp3(boolean var1) {
      this.frsPrp3 = var1;
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
}
