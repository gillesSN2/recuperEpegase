package com.epegase.forms.achats;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.CotationLigneAchats;
import com.epegase.systeme.classe.DemandeEnteteAchats;
import com.epegase.systeme.classe.DemandeLigneAchats;
import com.epegase.systeme.classe.DocumentTraceAchats;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesAchats;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.CotationEnteteAchatsDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DemandeEnteteAchatsDao;
import com.epegase.systeme.dao.DemandeLigneAchatsDao;
import com.epegase.systeme.dao.DocumentTraceAchatsDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FormulesAchatsDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UniteDao;
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
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionAchats;
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

public class FormDemandeAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action;
   private String pageIndex;
   private int nature;
   private String urlphotoProd;
   private List mesOnglets;
   private OptionAchats optionAchats;
   private int var_option_parc;
   private ExercicesAchats exercicesAchats;
   private ExercicesAchats lastExoAchats;
   private ExercicesComptable lastExoCompta;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_timbre;
   private int var_nb_max = 100;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean visibleOnglet = false;
   private boolean var_sansstock = false;
   private int var_modestock = 0;
   private boolean var_aff_detail_prod = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private boolean existParapheur = false;
   private Users responsable;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private List mesUsersItem;
   private boolean var_verrou_service = false;
   private long var_nom_responsable;
   private DemandeEnteteAchats demandeEnteteAchats;
   private DemandeEnteteAchatsDao demandeEnteteAchatsDao;
   private List lesEntetesList;
   private boolean verrouNum = false;
   private transient DataModel datamodelEntete;
   private UIDataTable extDTable;
   private SimpleSelection simpleSelectionEntete;
   private boolean visibiliteBton = false;
   private boolean visibiliteBtonlig = true;
   private boolean visibleOngleEntete;
   private boolean var_aff_action = false;
   private boolean var_valide_doc = false;
   private double montantTtc = 0.0D;
   private double montantTtcElmt = 0.0D;
   private double totalHt = 0.0D;
   private double totalTtc = 0.0D;
   private double totalTaxe = 0.0D;
   private int var_nb_ligne = 0;
   private int var_num_ligne = 0;
   private boolean visibilitefactor = false;
   private boolean visibiliteterme = false;
   private boolean visibilitenbrjr = false;
   private ObjetIncoterm incoterms;
   private UtilDate utilDate = new UtilDate();
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private int var_imput_choix;
   private String var_imput_num;
   private transient DataModel datamodelDocumentTrace;
   private DemandeLigneAchats demandeLigneAchats;
   private DemandeLigneAchatsDao demandeLigneAchatsDao;
   private transient DataModel datamodelLigne;
   private List lesLignesList;
   private String var_depotProd;
   private double prixUnitAvRemis = 0.0D;
   private double prixUnitApRemis = 0.0D;
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private boolean griserchamps = false;
   private int numLigne;
   private ServiceDao serviceDao;
   private Produits produits;
   private ProduitsAchsDao produitsDao;
   private ProduitsTarifDao produitsTarifdao;
   private ProduitsDepotDao produitsDepotDao;
   private List mesProduitsDepotsItems;
   private TaxesAchatsDao taxesAchatsDao;
   private FamillesProduitsAchatsDao famillesProduitsAchatsDao;
   private FamillesProduitsAchats famillesProduitsAchats;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsMclesDao produitsMclesDao;
   private String codeProduitsMcles;
   private String codeProduits;
   private String codeDepotAch;
   private String libelleProduits;
   private String libelleProduitsMcles;
   private String uniteProduits;
   private String taxeProduits;
   private double prixUnitaires;
   private double prixUnitaireMP;
   private List mesTaxesAchatsItems;
   private List mesTaxesAchatsProduits;
   private List lisTaxesAchats;
   private boolean verrou_libelle = false;
   private List mesConditionnementsItems;
   private List mesConditionnementsProduits;
   private List mesUnitesItems;
   private List mesUnitesProduits;
   private boolean var_aff_condit = false;
   private boolean var_aff_unite = false;
   private int var_code_unite;
   private String inpSerie = "100";
   private String inpCat = "100";
   private String inpService = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpFournisseur = "";
   private String inpBudget = "100";
   private String inpResponsable = "";
   private String inpActivite = "100";
   private String inpParc = "100";
   private String inpDossier = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private String montant_lettre;
   private UtilNombre utilNombre = new UtilNombre();
   private boolean verrouRemise = false;
   private boolean verrouRabais = false;
   private boolean verrouPrvente = false;
   private boolean affichagePump = false;
   private boolean verrouPump = false;
   private String verrouDepotUser;
   private boolean accesProduits;
   private boolean var_acc_document = false;
   private boolean var_acc_imputation = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_reglement = false;
   private boolean var_acc_special = false;
   private boolean var_acc_habilitation = false;
   private boolean var_acc_etat = false;
   private boolean var_acc_tracabilite = false;
   private boolean var_acc_prp = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean var_verrou_comm = false;
   private int choixSitDepSer;
   private Habilitation habilitation;
   private DocumentTraceAchatsDao documentTraceAchatsDao;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private DocumentTraceAchats documentTraceAchats;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private List mesBudgetsItems;
   private boolean showModalPanelAnnuler = false;
   private boolean showModalPanelTrf = false;
   private transient DataModel datamodelTransfert;
   private List documentDetailTrf;
   private Date var_date_trf = null;
   private int var_type_trf;
   private String var_serie_trf;
   private String var_modele_trf;
   private boolean var_aff_trf = false;
   private List mesSeriesTrfItems;
   private List modeleTrfItems;
   private List documentTrfItems;
   private boolean showModalPanelPaye = false;
   private Tiers tiers;
   private TiersDao tiersDao;
   private List lesTiers;
   private transient DataModel dataModelTiers;
   private boolean showModalPanelTiers = false;
   private int recopieTiers = 0;
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

   public FormDemandeAchats() throws IOException, SAXException, JDOMException {
      this.demandeEnteteAchats = new DemandeEnteteAchats(this.structureLog);
      this.usersChrono = new UsersChrono();
      this.datamodelEntete = new ListDataModel();
      this.simpleSelectionEntete = new SimpleSelection();
      this.extDTable = new HtmlExtendedDataTable();
      this.lesEntetesList = new ArrayList();
      this.demandeLigneAchats = new DemandeLigneAchats();
      this.datamodelLigne = new ListDataModel();
      this.lesLignesList = new ArrayList();
      this.datamodelDocumentTrace = new ListDataModel();
      this.mesUsersItem = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.mesTaxesAchatsProduits = new ArrayList();
      this.datamodelTransfert = new ListDataModel();
      this.mesSeriesTrfItems = new ArrayList();
      this.modeleTrfItems = new ArrayList();
      this.documentDetailTrf = new ArrayList();
      this.documentTrfItems = new ArrayList();
      this.lesTiers = new ArrayList();
      this.dataModelTiers = new ListDataModel();
      this.lesDecoupagesActivites = new ArrayList();
      this.dataModelDecoupageActivtes = new ListDataModel();
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.demandeEnteteAchatsDao = new DemandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.demandeLigneAchatsDao = new DemandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.taxesAchatsDao = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifdao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.documentTraceAchatsDao = new DocumentTraceAchatsDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
   }

   public void configAchats() {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if (!this.structureLog.getStrtypeentreprise().contentEquals("1") && !this.structureLog.getStrtypeentreprise().contentEquals("3")) {
         this.var_sansstock = true;
         this.var_modestock = 0;
      } else {
         this.var_sansstock = false;
         this.var_modestock = 0;
      }

      if (!this.optionAchats.getLib1().isEmpty() && !this.optionAchats.getLib2().isEmpty() && !this.optionAchats.getLib3().isEmpty() && !this.optionAchats.getLib4().isEmpty() && !this.optionAchats.getLib5().isEmpty() && !this.optionAchats.getLib6().isEmpty() && !this.optionAchats.getLib7().isEmpty() && !this.optionAchats.getLib8().isEmpty() && !this.optionAchats.getLib9().isEmpty() && !this.optionAchats.getLib10().isEmpty()) {
         this.visibleOngleEntete = false;
      } else {
         this.visibleOngleEntete = true;
      }

      if (this.optionAchats.getNbLigneMax() != null && !this.optionAchats.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionAchats.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionAchats.getAxeActivite().equals("true")) {
         this.var_anal_activite = true;
      } else {
         this.var_anal_activite = false;
      }

      if (this.optionAchats.getAxeDossier().equals("1")) {
         this.var_anal_dossier = true;
      } else {
         this.var_anal_dossier = false;
      }

      if (this.optionAchats.getAxeParc().equals("true")) {
         this.var_anal_parc = true;
      } else {
         this.var_anal_parc = false;
      }

      this.periode = this.optionAchats.getAffichInGlobViewAVOIR();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.initPage();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrVerRemiseAch() == 0) {
         this.verrouRemise = true;
      } else {
         this.verrouRemise = false;
      }

      if (this.usersLog.getUsrVerRabaisAch() == 0) {
         this.verrouRabais = true;
      } else {
         this.verrouRabais = false;
      }

      if (this.usersLog.getUsrVerPaAch() == 0) {
         this.verrouPrvente = false;
      } else {
         this.verrouPrvente = true;
      }

      if (this.usersLog.getUsrAchPump() == 0) {
         this.affichagePump = false;
         this.verrouPump = false;
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
      } else {
         this.var_verrou_comm = true;
      }

   }

   public void accesResteintGroupe() {
      this.var_acc_document = false;
      this.var_acc_imputation = false;
      this.var_acc_complement = false;
      this.var_acc_reglement = false;
      this.var_acc_special = false;
      this.var_acc_habilitation = false;
      this.var_acc_etat = false;
      this.var_acc_tracabilite = false;
      this.var_acc_prp = false;
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
               this.var_acc_special = true;
            } else if (var1.getCode().equals("56")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("57")) {
               this.var_acc_etat = true;
            } else if (var1.getCode().equals("58")) {
               this.var_acc_tracabilite = true;
            } else if (var1.getCode().equals("60")) {
               this.var_acc_prp = true;
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

   public void autorisationSpecial() {
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

   public void autorisationPrp() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("60")) {
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
      this.var_action = 0;
      this.montantTtc = 0.0D;
      this.montantTtcElmt = 0.0D;
      this.inpSerie = "100";
      this.inpCat = "100";
      this.inpService = "100";
      this.inpBudget = "100";
      this.inpEtat = 0;
      this.lesEntetesList.clear();
      this.lesLignesList.clear();
      this.lesDecoupagesActivites.clear();
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void recupererBudgetItem() throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      PlansBudgetairesDao var1 = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      String var2 = "" + this.lastExoCompta.getExecpt_id();
      if (this.demandeEnteteAchats.getDemActivite() != null && !this.demandeEnteteAchats.getDemActivite().isEmpty() && this.demandeEnteteAchats.getDemActivite().contains(":")) {
         String[] var3 = this.demandeEnteteAchats.getDemActivite().split(":");
         this.mesBudgetsItems = var1.chargerLesPlansBudgetaires(0, "2", var2, var3[0], (Session)null);
      } else {
         this.mesBudgetsItems = var1.chargerLesPlansBudgetaires(0, "2", var2, "", (Session)null);
      }

   }

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      Object var2 = new ArrayList();
      if (this.usersLog.getUsrCommAchats() == 0) {
         var2 = this.usersDao.chargerLesUsers(var1);
      } else {
         ((List)var2).add(this.usersLog);
      }

      if (((List)var2).size() == 0) {
         ((List)var2).add(this.usersLog);
      }

      this.mesUsersItem.clear();
      if (this.demandeEnteteAchats.getDemNomResponsable() != null && !this.demandeEnteteAchats.getDemNomResponsable().isEmpty()) {
         this.mesUsersItem.add(new SelectItem(this.demandeEnteteAchats.getDemNomResponsable()));
      } else if (this.usersLog.getUsrCommAchats() != 0 && this.usersLog.getUsrCommAchats() != 1) {
         this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrPatronyme()));
      } else {
         this.mesUsersItem.add(new SelectItem(0, "Sélectionnez un agent"));

         for(int var3 = 0; var3 < ((List)var2).size(); ++var3) {
            Users var4 = (Users)((List)var2).get(var3);
            if (var4.getUsrPatronyme() != null && !var4.getUsrPatronyme().isEmpty()) {
               this.mesUsersItem.add(new SelectItem(var4.getUsrPatronyme()));
            }
         }

         if (this.mesUsersItem.size() == 0) {
            this.mesUsersItem.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         }
      }

   }

   public void calculeServiceResponsable() throws HibernateException, NamingException {
      this.var_verrou_service = false;
      this.demandeEnteteAchats.setDemSite("");
      this.demandeEnteteAchats.setDemDepartement("");
      this.demandeEnteteAchats.setDemService("");
      if (this.demandeEnteteAchats.getDemNomResponsable() != null && !this.demandeEnteteAchats.getDemNomResponsable().isEmpty()) {
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var1 = this.usersDao.selectUserD(this.var_nom_responsable, (Session)null);
         if (var1 != null) {
            this.demandeEnteteAchats.setDemSite(var1.getUsrSite());
            this.demandeEnteteAchats.setDemDepartement(var1.getUsrDepartement());
            this.demandeEnteteAchats.setDemService(var1.getUsrService());
            this.var_verrou_service = true;
         }
      }

      this.calculeService();
   }

   public void calculeService() {
      if (this.demandeEnteteAchats.getDemNomResponsable() != null && !this.demandeEnteteAchats.getDemNomResponsable().isEmpty() && this.demandeEnteteAchats.getDemService() != null && !this.demandeEnteteAchats.getDemService().isEmpty() && this.demandeEnteteAchats.getDemService().contains(":")) {
         this.var_valide_doc = true;
      } else {
         this.var_valide_doc = false;
      }

   }

   public void calculeDepartement() {
      if (this.demandeEnteteAchats.getDemDepartement() != null && !this.demandeEnteteAchats.getDemDepartement().isEmpty() && this.demandeEnteteAchats.getDemDepartement().contains(":")) {
         this.var_valide_doc = true;
      } else {
         this.var_valide_doc = false;
      }

   }

   public void rechercheDOCUMENT(long var1) throws HibernateException, NamingException {
      this.lesLignesList = new ArrayList();
      this.demandeEnteteAchats = this.demandeEnteteAchatsDao.pourParapheur(var1, (Session)null);
      if (this.demandeEnteteAchats != null) {
         this.lesLignesList = this.demandeLigneAchatsDao.chargerLesLignes(this.demandeEnteteAchats, (Session)null);
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
         this.inpBudget = "100";
         this.inpActivite = "100";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesEntetesList.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      this.var_nb_ligne = 0;
      String var8 = "";
      String var9 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var8 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var9 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var8 = null;
         var9 = null;
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      if (this.inpEtat != 50) {
         this.lesEntetesList = this.demandeEnteteAchatsDao.recherche(var1, this.exercicesAchats.getExeachId(), this.getInpNum(), this.getInpEtat(), this.getInpSerie(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), this.getInpBudget(), this.getInpResponsable(), this.getInpActivite(), var8, var9);
      }

      if (this.lesEntetesList.size() > 0) {
         new ArrayList();
         new DemandeEnteteAchats(this.structureLog);

         for(int var12 = 0; var12 < this.lesEntetesList.size(); ++var12) {
            DemandeEnteteAchats var11 = (DemandeEnteteAchats)this.lesEntetesList.get(var12);
            this.demandeEnteteAchats.setDateCmd((Date)null);
            this.demandeEnteteAchats.setDateRec((Date)null);
            this.demandeEnteteAchats.setDateFac((Date)null);
            this.demandeEnteteAchats.setNumCmd((String)null);
            this.demandeEnteteAchats.setNumRec((String)null);
            this.demandeEnteteAchats.setNumFac((String)null);
            var2 += var11.getDemTotTtc();
            var4 += var11.getDemTotHt();
            var6 += var11.getDemTotTva();
         }

         this.var_nb_ligne = this.lesEntetesList.size();
      }

      this.datamodelEntete.setWrappedData(this.lesEntetesList);
      this.totauxHt = var4;
      this.totauxTaxe = var6;
      this.montantTtc = var2;
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
            this.demandeEnteteAchats = (DemandeEnteteAchats)var1.get(0);
            this.var_num_ligne = this.clauleNumlLigne();
            this.var_date = this.demandeEnteteAchats.getDemDate();
            if (this.demandeEnteteAchats.getDemDate().getHours() <= 9) {
               this.var_heure = "0" + this.demandeEnteteAchats.getDemDate().getHours();
            } else {
               this.var_heure = "" + this.demandeEnteteAchats.getDemDate().getHours();
            }

            if (this.demandeEnteteAchats.getDemDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.demandeEnteteAchats.getDemDate().getMinutes();
            } else {
               this.var_minute = "" + this.demandeEnteteAchats.getDemDate().getMinutes();
            }

            if (this.demandeEnteteAchats.getDemDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.demandeEnteteAchats.getDemDate().getSeconds();
            } else {
               this.var_seconde = "" + this.demandeEnteteAchats.getDemDate().getSeconds();
            }

            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
            this.chargerDocumentLigne(var4);
            this.chargerDocumentTrace(var4);
            this.chargerUserChrono(var4);
            this.chargerParapheur(var4);
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            if (this.mesUsersItem == null || this.mesUsersItem.size() == 0) {
               this.mesUsersItem.add(new SelectItem(0, ""));
            }

            this.utilInitHibernate.closeSession();
            this.setMontantTtcElmt(this.demandeEnteteAchats.getDemTotTtc());
            this.cumulPrix();
            this.numLigne = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
            this.var_num_ligne = 0;
         }
      } else {
         this.visibiliteBton = false;
         this.var_num_ligne = 0;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.demandeEnteteAchats != null) {
         if (this.demandeEnteteAchats.getDemEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.demandeEnteteAchats.getDemId() > 0L) {
         this.lesLignesList = this.demandeLigneAchatsDao.chargerLesLignes(this.demandeEnteteAchats, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
      this.datamodelDocumentTrace = new ListDataModel();
      new ArrayList();
      ArrayList var3 = new ArrayList();
      new ArrayList();
      ArrayList var5 = new ArrayList();
      new ArrayList();
      ArrayList var7 = new ArrayList();
      new ArrayList();
      ArrayList var9 = new ArrayList();
      new ArrayList();
      ArrayList var11 = new ArrayList();
      new ArrayList();
      ArrayList var13 = new ArrayList();
      ArrayList var14 = new ArrayList();
      new ArrayList();
      ArrayList var16 = new ArrayList();
      if (this.demandeEnteteAchats.getDemId() > 0L) {
         List var2 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(this.demandeEnteteAchats.getDemId(), this.nature, var1);
         if (var2.size() == 0) {
            var2 = this.documentTraceAchatsDao.chargerLesDocumentsTraceOrigine(this.demandeEnteteAchats.getDemId(), this.nature, var1);
         }

         int var17;
         int var18;
         for(var17 = 0; var17 < var2.size(); ++var17) {
            List var4 = this.documentTraceAchatsDao.chargerLesDocumentsTraceOrigine(((DocumentTraceAchats)var2.get(var17)).getDoctrfDstId(), ((DocumentTraceAchats)var2.get(var17)).getDoctrfDstType(), var1);
            if (var4.size() != 0) {
               for(var18 = 0; var18 < var4.size(); ++var18) {
                  var3.add(var4.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var3.size(); ++var17) {
            List var6 = this.documentTraceAchatsDao.chargerLesDocumentsTraceOrigine(((DocumentTraceAchats)var3.get(var17)).getDoctrfDstId(), ((DocumentTraceAchats)var3.get(var17)).getDoctrfDstType(), var1);
            if (var6.size() != 0) {
               for(var18 = 0; var18 < var6.size(); ++var18) {
                  var5.add(var6.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var5.size(); ++var17) {
            List var8 = this.documentTraceAchatsDao.chargerLesDocumentsTraceOrigine(((DocumentTraceAchats)var5.get(var17)).getDoctrfDstId(), ((DocumentTraceAchats)var5.get(var17)).getDoctrfDstType(), var1);
            if (var8.size() != 0) {
               for(var18 = 0; var18 < var8.size(); ++var18) {
                  var7.add(var8.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var7.size(); ++var17) {
            List var12 = this.documentTraceAchatsDao.chargerLesDocumentsTraceOrigine(((DocumentTraceAchats)var7.get(var17)).getDoctrfDstId(), ((DocumentTraceAchats)var7.get(var17)).getDoctrfDstType(), var1);
            if (var12.size() != 0) {
               for(var18 = 0; var18 < var12.size(); ++var18) {
                  var11.add(var12.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var11.size(); ++var17) {
            List var15 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)var11.get(var17)).getDoctrfOrgId(), 26, var1);
            if (var15.size() != 0) {
               for(var18 = 0; var18 < var15.size(); ++var18) {
                  var14.add(var15.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var7.size(); ++var17) {
            List var10 = this.documentTraceAchatsDao.chargerLesDocumentsTraceDestination(((DocumentTraceAchats)var7.get(var17)).getDoctrfOrgId(), 24, var1);
            if (var10.size() != 0) {
               for(var18 = 0; var18 < var10.size(); ++var18) {
                  var9.add(var10.get(var18));
               }
            }
         }

         for(var17 = 0; var17 < var2.size(); ++var17) {
            var16.add(var2.get(var17));
         }

         for(var17 = 0; var17 < var3.size(); ++var17) {
            var16.add(var3.get(var17));
         }

         for(var17 = 0; var17 < var5.size(); ++var17) {
            var16.add(var5.get(var17));
         }

         for(var17 = 0; var17 < var7.size(); ++var17) {
            var16.add(var7.get(var17));
         }

         for(var17 = 0; var17 < var9.size(); ++var17) {
            var16.add(var9.get(var17));
         }

         for(var17 = 0; var17 < var11.size(); ++var17) {
            var16.add(var11.get(var17));
         }

         for(var17 = 0; var17 < var13.size(); ++var17) {
            var16.add(var13.get(var17));
         }

         for(var17 = 0; var17 < var14.size(); ++var17) {
            var16.add(var14.get(var17));
         }
      }

      this.datamodelDocumentTrace.setWrappedData(var16);
      this.documentTraceAchats = null;
      this.utilInitHibernate.closeSession();
   }

   public void chargerDocumentTrace(Session var1) throws HibernateException, NamingException {
      this.datamodelDocumentTrace = new ListDataModel();
      ArrayList var2 = new ArrayList();
      this.datamodelDocumentTrace.setWrappedData(var2);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.demandeEnteteAchats != null && this.demandeEnteteAchats.getDemSerie() != null && !this.demandeEnteteAchats.getDemSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.demandeEnteteAchats.getDemSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.demandeEnteteAchats.getDemId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.demandeEnteteAchats.getDemActivite() != null && !this.demandeEnteteAchats.getDemActivite().isEmpty() && this.demandeEnteteAchats.getDemActivite().contains(":")) {
         String[] var1 = null;
         if (!this.demandeEnteteAchats.getDemActivite().contains("#")) {
            var1 = this.demandeEnteteAchats.getDemActivite().split(":");
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
            String[] var2 = this.demandeEnteteAchats.getDemActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.demandeEnteteAchats.getDemTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.demandeEnteteAchats.getDemTotHt() - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         if (var1 != 0.0F) {
            this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(100.0F - var1);
         }

         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void ajoutDocument() throws IOException, JDOMException {
      this.demandeEnteteAchats = new DemandeEnteteAchats(this.structureLog);
      this.demandeLigneAchats = new DemandeLigneAchats();
      this.demandeEnteteAchats.setUsers(this.usersLog);
      this.demandeEnteteAchats.setDemIdCreateur(this.usersLog.getUsrid());
      this.demandeEnteteAchats.setDemNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.demandeEnteteAchats.setDemIdResponsable(this.usersLog.getUsrid());
      this.demandeEnteteAchats.setDemNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         this.demandeEnteteAchats.setDemSite(this.usersLog.getUsrSite());
         this.demandeEnteteAchats.setDemDepartement(this.usersLog.getUsrDepartement());
         this.demandeEnteteAchats.setDemService(this.usersLog.getUsrService());
      } else {
         this.demandeEnteteAchats.setDemSite("");
         this.demandeEnteteAchats.setDemDepartement("");
         this.demandeEnteteAchats.setDemService("");
      }

      this.demandeEnteteAchats.setDemDate(new Date());
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

      this.calculDateValidite();
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.var_action = 1;
      this.numLigne = 0;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.calculeService();
      this.var_aff_detail_tiers = false;
      this.verrouNum = false;
      this.var_typeTiers = true;
      this.visibleOnglet = false;
      this.visibiliteBtonlig = true;
      this.visibilitefactor = false;
      this.visibiliteterme = false;
      this.visibilitenbrjr = false;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.autorisationDocument();
      this.addLigne();
   }

   public void calculDateValidite() {
      boolean var1 = false;
      int var3;
      if (this.optionAchats.getNbrJrRelanceDA() != null && !this.optionAchats.getNbrJrRelanceDA().isEmpty()) {
         var3 = Integer.parseInt(this.optionAchats.getNbrJrRelanceDA());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionAchats.getNbrJrValidAVOIR() != null && !this.optionAchats.getNbrJrValidAVOIR().isEmpty()) {
         var4 = Integer.parseInt(this.optionAchats.getNbrJrValidAVOIR());
      } else {
         var4 = 0;
      }

      this.demandeEnteteAchats.setDemDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.demandeEnteteAchats.setDemDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
      this.chargerDocumentLigne(var1);
      this.chargerDocumentTrace(var1);
      this.utilInitHibernate.closeSession();
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.visibleOnglet = true;
      this.var_valide_doc = true;
      this.var_aff_detail_tiers = true;
      if (this.usersLog.getUsrSignatureAchats() == 1) {
         this.chargerLesUsers((Session)null);
      } else if (this.var_nom_responsable != 0L) {
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.demandeEnteteAchats.getDemIdResponsable(), this.demandeEnteteAchats.getDemNomResponsable()));
      }

      this.autorisationDocument();
      this.addLigne();
   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
      this.chargerDocumentLigne(var1);
      this.chargerDocumentTrace(var1);
      this.utilInitHibernate.closeSession();
      this.var_action = 2;
      this.var_memo_action = this.var_action;
      this.var_aff_action = true;
      this.visibleOnglet = true;
      this.var_valide_doc = true;
      this.var_aff_detail_tiers = true;
      this.mesUsersItem.clear();
      this.mesUsersItem.add(new SelectItem(this.demandeEnteteAchats.getDemIdResponsable(), this.demandeEnteteAchats.getDemNomResponsable()));
      this.autorisationDocument();
   }

   public void valideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.demandeEnteteAchats.getDemEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
            this.demandeEnteteAchats.setDemEtat(1);
            this.demandeEnteteAchats.setDemDateValide(new Date());
            this.demandeEnteteAchats = this.demandeEnteteAchatsDao.modif(this.demandeEnteteAchats, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Validation manuelle D.A. (F.) N° " + this.demandeEnteteAchats.getDemNum() + " du " + this.utilDate.dateToStringSQLLight(this.demandeEnteteAchats.getDemDate()));
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

   public void deValideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.demandeEnteteAchats.getDemEtat() == 1) {
            this.demandeEnteteAchats.setDemEtat(0);
            this.demandeEnteteAchats.setDemDateValide((Date)null);
            this.demandeEnteteAchats = this.demandeEnteteAchatsDao.modif(this.demandeEnteteAchats, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Dévalidation manuelle D.A. (F.) N° " + this.demandeEnteteAchats.getDemNum() + " du " + this.utilDate.dateToStringSQLLight(this.demandeEnteteAchats.getDemDate()));
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

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.demandeEnteteAchats != null) {
         this.demandeEnteteAchats.setDemEtat(0);
         this.demandeEnteteAchats.setDemDateAnnule((Date)null);
         this.demandeEnteteAchats.setDemMotifAnnule("");
         this.demandeEnteteAchats = this.demandeEnteteAchatsDao.modif(this.demandeEnteteAchats);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesEntetesList.remove(this.demandeEnteteAchats);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         String var3 = this.demandeEnteteAchats.getDemNum();
         Date var4 = this.demandeEnteteAchats.getDemDate();
         this.demandeLigneAchatsDao.deleteAllLigne(this.demandeEnteteAchats, var1);
         this.utilParapheur.supprimerParapheur(this.demandeEnteteAchats.getDemId(), this.nature, var1);
         this.demandeEnteteAchatsDao.delete(this.demandeEnteteAchats.getDemId(), var1);
         Espion var5 = new Espion();
         var5.setUsers(this.usersLog);
         var5.setEsptype(0);
         var5.setEspdtecreat(new Date());
         var5.setEspaction("Suppression demande achat N° " + var3 + " du " + var4);
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

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.demandeEnteteAchats.getDemId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.demandeEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.demandeEnteteAchats.setUsers(this.usersLog);
            this.demandeEnteteAchats.setDemIdCreateur(this.usersLog.getUsrid());
            this.demandeEnteteAchats.setDemNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.demandeEnteteAchats.setDemDate(new Date());
            this.demandeEnteteAchats.setDemDateCreat(new Date());
            this.demandeEnteteAchats.setDemDateModif((Date)null);
            this.demandeEnteteAchats.setDemIdModif(0L);
            this.demandeEnteteAchats.setDemNomModif("");
            this.demandeEnteteAchats.setDemNum("");
            this.demandeEnteteAchats.setDemIdResponsable(this.usersLog.getUsrid());
            this.demandeEnteteAchats.setDemNomResponsable(this.usersLog.getUsrPatronyme());
            this.calculDateValidite();
            if (!this.demandeEnteteAchats.getDemSerie().equalsIgnoreCase("X") && !this.demandeEnteteAchats.getDemSerie().isEmpty()) {
               this.demandeEnteteAchats.setDemNum(this.calculChrono.numCompose(this.demandeEnteteAchats.getDemDate(), this.nature, this.demandeEnteteAchats.getDemSerie(), var1));
            } else {
               long var3 = this.demandeEnteteAchatsDao.selectLastNum(var1);
               this.demandeEnteteAchats.setDemNum("" + var3);
            }

            this.verifieExistenceHabilitation(var1);
            this.demandeEnteteAchats.setDemDateAnnule((Date)null);
            this.demandeEnteteAchats.setDemMotifAnnule("");
            this.demandeEnteteAchats.setDemDateImp((Date)null);
            this.demandeEnteteAchats.setDemDateTransforme((Date)null);
            this.demandeEnteteAchats.setDemEtat(0);
            this.demandeEnteteAchats = this.demandeEnteteAchatsDao.duppliquer(this.demandeEnteteAchats, var1);
            if (this.habilitation != null) {
               this.utilParapheur.majParapheur(this.nature, this.habilitation, this.demandeEnteteAchats.getDemId(), this.demandeEnteteAchats.getDemNum(), this.demandeEnteteAchats.getDemNomResponsable(), this.demandeEnteteAchats.getDemDate(), this.structureLog.getStrdevise(), this.demandeEnteteAchats.getDemTotTtc() + this.demandeEnteteAchats.getDemTotTc(), this.demandeEnteteAchats.getDemModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.demandeEnteteAchats.getVar_format_devise(), 0, var1);
            }

            if (this.lesLignesList.size() != 0) {
               this.demandeLigneAchatsDao.duppliquerLigne(this.lesLignesList, this.demandeEnteteAchats, var1);
            }

            this.chargeListeDetail(var1);
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

   public void transformerDocument() throws HibernateException, NamingException {
      this.recopieTiers = 0;
      this.documentDetailTrf.clear();
      this.lesLignesList.clear();
      this.var_date_trf = null;
      this.var_type_trf = 0;
      this.var_aff_trf = false;
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

      if (this.lesEntetesList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         if (this.demandeEnteteAchats.getDemTypeTransforme() != 0) {
            var3 = this.usersChronoDao.existByUserNat(this.usersLog, this.demandeEnteteAchats.getDemTypeTransforme(), var1);
            if (var3) {
               String var4 = "";
               if (this.demandeEnteteAchats.getDemTypeTransforme() == 11) {
                  var4 = "Cotation";
               } else if (this.demandeEnteteAchats.getDemTypeTransforme() == 12) {
                  var4 = "Commande";
               }

               this.documentTrfItems.add(new SelectItem(this.demandeEnteteAchats.getDemTypeTransforme(), var4));
            }
         } else {
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, 11, var1);
            if (var2) {
               this.documentTrfItems.add(new SelectItem(11, "Cotation"));
            }

            var2 = this.usersChronoDao.existByUserNat(this.usersLog, 12, var1);
            if (var2) {
               this.documentTrfItems.add(new SelectItem(12, "Commande"));
            }
         }

         for(int var8 = 0; var8 < this.lesEntetesList.size(); ++var8) {
            new DemandeEnteteAchats();
            DemandeEnteteAchats var5 = (DemandeEnteteAchats)this.lesEntetesList.get(var8);
            if (var5.getDemId() > 0L && var5.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.demandeLigneAchatsDao.chargerLesLignes(var5, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                     new DemandeLigneAchats();
                     DemandeLigneAchats var7 = (DemandeLigneAchats)this.lesLignesList.get(var6);
                     this.documentDetailTrf.add(var7);
                  }
               }
            }
         }

         this.lesLignesList.clear();
         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
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

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.majAnalytique();
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.demandeEnteteAchats.setDemDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.demandeEnteteAchats.getUsers() == null) {
            this.demandeEnteteAchats.setUsers(this.usersLog);
         }

         new Users();
         Users var3 = this.usersDao.selectLeUserPatronyme(this.demandeEnteteAchats.getDemNomResponsable(), var1);
         if (var3 != null) {
            this.demandeEnteteAchats.setDemIdResponsable(var3.getUsrid());
            this.demandeEnteteAchats.setDemNomResponsable(var3.getUsrPatronyme());
         } else {
            this.demandeEnteteAchats.setDemIdResponsable(0L);
            this.demandeEnteteAchats.setDemNomResponsable("");
         }

         if (this.demandeEnteteAchats.getDemService() != null && !this.demandeEnteteAchats.getDemService().isEmpty()) {
            String var4 = "";
            if (this.demandeEnteteAchats.getDemService().contains(":")) {
               String[] var5 = this.demandeEnteteAchats.getDemService().split(":");
               var4 = var5[0];
            } else {
               var4 = this.demandeEnteteAchats.getDemService();
            }

            new Service();
            Service var15 = this.serviceDao.chargerLeServiceCode(var4, var1);
            if (var15 != null) {
               this.demandeEnteteAchats.setDemSite(var15.getSite().getSitCode() + ":" + var15.getSite().getSitNomFr());
               this.demandeEnteteAchats.setDemDepartement(var15.getDepartement().getDepCode() + ":" + var15.getDepartement().getDepNomFr());
               this.demandeEnteteAchats.setDemService(var15.getSerCode() + ":" + var15.getSerNomFr());
            } else {
               this.demandeEnteteAchats.setDemSite("");
               this.demandeEnteteAchats.setDemDepartement("");
               this.demandeEnteteAchats.setDemService("");
            }
         } else {
            this.demandeEnteteAchats.setDemSite("");
            this.demandeEnteteAchats.setDemDepartement("");
            this.demandeEnteteAchats.setDemService("");
         }

         if (this.demandeEnteteAchats.getDemId() == 0L) {
            this.demandeEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.demandeEnteteAchats.setDemDateCreat(new Date());
            this.demandeEnteteAchats.setDemIdCreateur(this.usersLog.getUsrid());
            this.demandeEnteteAchats.setDemNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.demandeEnteteAchats.getDemSerie() != null && !this.demandeEnteteAchats.getDemSerie().equalsIgnoreCase("X") && !this.demandeEnteteAchats.getDemSerie().isEmpty()) {
               this.demandeEnteteAchats.setDemNum(this.calculChrono.numCompose(this.demandeEnteteAchats.getDemDate(), this.nature, this.demandeEnteteAchats.getDemSerie(), var1));
               boolean var17 = false;

               label191:
               while(true) {
                  while(true) {
                     if (var17) {
                        break label191;
                     }

                     new DemandeEnteteAchats();
                     DemandeEnteteAchats var18 = this.demandeEnteteAchatsDao.pourParapheur(this.demandeEnteteAchats.getDemNum(), this.demandeEnteteAchats.getDemSerie(), var1);
                     if (var18 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.demandeEnteteAchats.setDemNum(this.calculChrono.numCompose(this.demandeEnteteAchats.getDemDate(), this.nature, this.demandeEnteteAchats.getDemSerie(), var1));
                        var17 = false;
                     } else {
                        var17 = true;
                     }
                  }
               }
            } else {
               long var16 = this.demandeEnteteAchatsDao.selectLastNum(var1);
               this.demandeEnteteAchats.setDemNum("" + var16);
            }

            this.demandeEnteteAchats.setDemEtat(0);
            this.demandeEnteteAchats.setDemEtatVal(0);
            this.demandeEnteteAchats.setDemDateValide((Date)null);
            this.demandeEnteteAchats = this.demandeEnteteAchatsDao.insert(this.demandeEnteteAchats, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.demandeEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
            this.var_num_ligne = this.lesEntetesList.size() - 1;
         } else {
            if (this.demandeEnteteAchats.getDemEtat() == 6) {
               if (this.demandeEnteteAchats.getDemEtatVal() == 1) {
                  this.demandeEnteteAchats.setDemEtat(0);
               } else {
                  this.demandeEnteteAchats.setDemEtat(0);
               }
            }

            this.demandeEnteteAchats.setDemDateModif(new Date());
            this.demandeEnteteAchats.setDemIdModif(this.usersLog.getUsrid());
            this.demandeEnteteAchats.setDemNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.demandeEnteteAchats = this.demandeEnteteAchatsDao.modif(this.demandeEnteteAchats, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.demandeEnteteAchats.getDemId(), this.demandeEnteteAchats.getDemNum(), this.demandeEnteteAchats.getDemNomResponsable(), this.demandeEnteteAchats.getDemDate(), this.structureLog.getStrdevise(), this.demandeEnteteAchats.getDemTotTtc() + this.demandeEnteteAchats.getDemTotTc(), this.demandeEnteteAchats.getDemModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.demandeEnteteAchats.getVar_format_devise(), 0, var1);
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

   public void majAnalytique() throws HibernateException, NamingException {
      this.demandeEnteteAchats.setDemRegion("");
      this.demandeEnteteAchats.setDemSecteur("");
      this.demandeEnteteAchats.setDemPdv("");
      if (!this.var_anal_activite) {
         this.demandeEnteteAchats.setDemActivite("");
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

            this.demandeEnteteAchats.setDemActivite(var1);
         }
      } else {
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeLigne");
         String var14 = "";
         boolean var15 = true;
         new DemandeLigneAchats();
         new Produits();
         if ((this.decoupageActivite || !this.decoupageActivite) && this.lesLignesList.size() != 0) {
            ArrayList var6 = new ArrayList();
            ObjetTarif var7 = new ObjetTarif();
            int var8 = 0;

            label116:
            while(true) {
               if (var8 >= this.lesLignesList.size()) {
                  var8 = 0;

                  while(true) {
                     if (var8 >= var6.size()) {
                        break label116;
                     }

                     var7 = (ObjetTarif)var6.get(var8);
                     if (var15) {
                        var14 = var7.getNomLibelle() + ":" + var7.getPrix();
                        var15 = false;
                     } else {
                        var14 = var14 + "#" + var7.getNomLibelle() + ":" + var7.getPrix();
                     }

                     ++var8;
                  }
               }

               DemandeLigneAchats var4 = (DemandeLigneAchats)this.lesLignesList.get(var8);
               if (var4.getDemligCode() != null && !var4.getDemligCode().isEmpty()) {
                  Produits var5 = this.produitsDao.chargeProduit(var4.getDemligCode(), var13);
                  if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                     if (var6.size() == 0) {
                        var7 = new ObjetTarif();
                        var7.setNomLibelle(var5.getProActivite());
                        var7.setPrix(var4.getDemligPt());
                        var6.add(var7);
                     } else {
                        boolean var9 = false;
                        double var10 = 0.0D;

                        for(int var12 = 0; var12 < var6.size(); ++var12) {
                           var7 = (ObjetTarif)var6.get(var12);
                           if (var7.getNomLibelle().equals(var5.getProActivite())) {
                              var10 = var7.getPrix();
                              var9 = true;
                              break;
                           }
                        }

                        if (!var9) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var4.getDemligPt());
                           var6.add(var7);
                        } else if (var9 && var7 != null) {
                           var7.setPrix(var10 + var4.getDemligPt());
                           var6.remove(var7);
                           var6.add(var7);
                        }
                     }
                  }
               }

               ++var8;
            }
         }

         this.demandeEnteteAchats.setDemActivite(var14);
         this.utilInitHibernate.closeSession();
      }

      if (this.demandeEnteteAchats.getDemAnal4() != null && this.demandeEnteteAchats.getDemAnal4().length() <= 2) {
         this.demandeEnteteAchats.setDemAnal4("");
      }

      if (!this.var_anal_parc) {
         this.demandeEnteteAchats.setDemAnal2("");
      } else if (this.demandeEnteteAchats.getDemAnal2() != null && this.demandeEnteteAchats.getDemAnal2().length() <= 2) {
         this.demandeEnteteAchats.setDemAnal2("");
      }

      if (this.demandeEnteteAchats.getDemBudget() != null && !this.demandeEnteteAchats.getDemBudget().isEmpty()) {
         if (!this.demandeEnteteAchats.getDemBudget().contains(":")) {
            this.demandeEnteteAchats.setDemBudget("");
         }
      } else {
         this.demandeEnteteAchats.setDemBudget("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.demandeEnteteAchats.setDemEtatVal(1);
         this.demandeEnteteAchats.setDemEtat(0);
         this.demandeEnteteAchats.setDemDateValide((Date)null);
         return true;
      } else {
         this.demandeEnteteAchats.setDemEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.demandeEnteteAchats.setDemEtat(1);
               this.demandeEnteteAchats.setDemDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.demandeEnteteAchats.setDemEtat(0);
               this.demandeEnteteAchats.setDemDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.demandeEnteteAchats != null) {
         this.demandeEnteteAchats.setDemDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.demandeEnteteAchats != null) {
         if (this.demandeEnteteAchats.getDemDateAnnule() == null) {
            this.demandeEnteteAchats.setDemDateAnnule(new Date());
         }

         this.demandeEnteteAchats.setDemEtat(3);
         this.demandeEnteteAchats = this.demandeEnteteAchatsDao.modif(this.demandeEnteteAchats);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation demande achat N° " + this.demandeEnteteAchats.getDemNum() + " le " + this.demandeEnteteAchats.getDemDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.demandeEnteteAchats);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void calculDisponibilite() throws HibernateException, NamingException {
      this.demandeEnteteAchats.setDemBudgetDispo(0.0D);
      this.demandeEnteteAchats.setDemBudgetDispoMois(0.0D);
      this.demandeEnteteAchats.setDemBudgetTreso(0.0D);
      this.demandeEnteteAchats.setDemBudgetTresoMois(0.0D);
      if (this.demandeEnteteAchats.getDemBudget() != null && this.demandeEnteteAchats.getDemBudget().contains(":")) {
         String var1 = "" + this.lastExoCompta.getExecpt_id();
         String[] var2 = this.demandeEnteteAchats.getDemBudget().split(":");
         String var3 = null;
         if (this.demandeEnteteAchats.getDemActivite() != null && !this.demandeEnteteAchats.getDemActivite().isEmpty()) {
            String[] var4 = this.demandeEnteteAchats.getDemActivite().split(":");
            var3 = var4[0];
         }

         int var27 = this.demandeEnteteAchats.getDemDate().getMonth() + 1;
         double var5 = 0.0D;
         double var7 = 0.0D;
         BudgetDao var9 = new BudgetDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var10 = var9.chargerLesBudgets("2", var1, var3, var2[0], (Session)null);
         if (var10.size() != 0) {
            for(int var11 = 0; var11 < var10.size(); ++var11) {
               new Budget();
               Budget var12 = (Budget)var10.get(var11);
               if (var12.getBudUtil() <= 1) {
                  if (var27 == 1) {
                     var7 += var12.getBud01R1Val();
                     var5 += var12.getBud01R1Val();
                  } else if (var27 == 2) {
                     var7 += var12.getBud02R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val();
                  } else if (var27 == 3) {
                     var7 += var12.getBud03R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val();
                  } else if (var27 == 4) {
                     var7 += var12.getBud04R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val();
                  } else if (var27 == 5) {
                     var7 += var12.getBud05R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val();
                  } else if (var27 == 6) {
                     var7 += var12.getBud06R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val();
                  } else if (var27 == 7) {
                     var7 += var12.getBud07R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val();
                  } else if (var27 == 8) {
                     var7 += var12.getBud08R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val() + var12.getBud08R1Val();
                  } else if (var27 == 9) {
                     var7 += var12.getBud09R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val() + var12.getBud08R1Val() + var12.getBud09R1Val();
                  } else if (var27 == 10) {
                     var7 += var12.getBud10R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val() + var12.getBud08R1Val() + var12.getBud09R1Val() + var12.getBud10R1Val();
                  } else if (var27 == 11) {
                     var7 += var12.getBud11R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val() + var12.getBud08R1Val() + var12.getBud09R1Val() + var12.getBud10R1Val() + var12.getBud11R1Val();
                  } else if (var27 == 12) {
                     var7 += var12.getBud12R1Val();
                     var5 = var5 + var12.getBud01R1Val() + var12.getBud02R1Val() + var12.getBud03R1Val() + var12.getBud04R1Val() + var12.getBud05R1Val() + var12.getBud06R1Val() + var12.getBud07R1Val() + var12.getBud08R1Val() + var12.getBud09R1Val() + var12.getBud10R1Val() + var12.getBud11R1Val() + var12.getBud12R1Val();
                  }
               } else if (var12.getBudUtil() == 2) {
                  if (var27 == 1) {
                     var7 += var12.getBud01R2Val();
                     var5 += var12.getBud01R2Val();
                  } else if (var27 == 2) {
                     var7 += var12.getBud02R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val();
                  } else if (var27 == 3) {
                     var7 += var12.getBud03R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val();
                  } else if (var27 == 4) {
                     var7 += var12.getBud04R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val();
                  } else if (var27 == 5) {
                     var7 += var12.getBud05R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val();
                  } else if (var27 == 6) {
                     var7 += var12.getBud06R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val();
                  } else if (var27 == 7) {
                     var7 += var12.getBud07R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val();
                  } else if (var27 == 8) {
                     var7 += var12.getBud08R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val() + var12.getBud08R2Val();
                  } else if (var27 == 9) {
                     var7 += var12.getBud09R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val() + var12.getBud08R2Val() + var12.getBud09R2Val();
                  } else if (var27 == 10) {
                     var7 += var12.getBud10R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val() + var12.getBud08R2Val() + var12.getBud09R2Val() + var12.getBud10R2Val();
                  } else if (var27 == 11) {
                     var7 += var12.getBud11R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val() + var12.getBud08R2Val() + var12.getBud09R2Val() + var12.getBud10R2Val() + var12.getBud11R2Val();
                  } else if (var27 == 12) {
                     var7 += var12.getBud12R2Val();
                     var5 = var5 + var12.getBud01R2Val() + var12.getBud02R2Val() + var12.getBud03R2Val() + var12.getBud04R2Val() + var12.getBud05R2Val() + var12.getBud06R2Val() + var12.getBud07R2Val() + var12.getBud08R2Val() + var12.getBud09R2Val() + var12.getBud10R2Val() + var12.getBud11R2Val() + var12.getBud12R2Val();
                  }
               } else if (var12.getBudUtil() == 2) {
                  if (var27 == 1) {
                     var7 += var12.getBud01R3Val();
                     var5 += var12.getBud01R3Val();
                  } else if (var27 == 2) {
                     var7 += var12.getBud02R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val();
                  } else if (var27 == 3) {
                     var7 += var12.getBud03R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val();
                  } else if (var27 == 4) {
                     var7 += var12.getBud04R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val();
                  } else if (var27 == 5) {
                     var7 += var12.getBud05R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val();
                  } else if (var27 == 6) {
                     var7 += var12.getBud06R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val();
                  } else if (var27 == 7) {
                     var7 += var12.getBud07R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val();
                  } else if (var27 == 8) {
                     var7 += var12.getBud08R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val() + var12.getBud08R3Val();
                  } else if (var27 == 9) {
                     var7 += var12.getBud09R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val() + var12.getBud08R3Val() + var12.getBud09R3Val();
                  } else if (var27 == 10) {
                     var7 += var12.getBud10R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val() + var12.getBud08R3Val() + var12.getBud09R3Val() + var12.getBud10R3Val();
                  } else if (var27 == 11) {
                     var7 += var12.getBud11R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val() + var12.getBud08R3Val() + var12.getBud09R3Val() + var12.getBud10R3Val() + var12.getBud11R3Val();
                  } else if (var27 == 12) {
                     var7 += var12.getBud12R3Val();
                     var5 = var5 + var12.getBud01R3Val() + var12.getBud02R3Val() + var12.getBud03R3Val() + var12.getBud04R3Val() + var12.getBud05R3Val() + var12.getBud06R3Val() + var12.getBud07R3Val() + var12.getBud08R3Val() + var12.getBud09R3Val() + var12.getBud10R3Val() + var12.getBud11R3Val() + var12.getBud12R3Val();
                  }
               } else if (var12.getBudUtil() == 2) {
                  if (var27 == 1) {
                     var7 += var12.getBud01R4Val();
                     var5 += var12.getBud01R4Val();
                  } else if (var27 == 2) {
                     var7 += var12.getBud02R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val();
                  } else if (var27 == 3) {
                     var7 += var12.getBud03R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val();
                  } else if (var27 == 4) {
                     var7 += var12.getBud04R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val();
                  } else if (var27 == 5) {
                     var7 += var12.getBud05R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val();
                  } else if (var27 == 6) {
                     var7 += var12.getBud06R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val();
                  } else if (var27 == 7) {
                     var7 += var12.getBud07R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val();
                  } else if (var27 == 8) {
                     var7 += var12.getBud08R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val() + var12.getBud08R4Val();
                  } else if (var27 == 9) {
                     var7 += var12.getBud09R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val() + var12.getBud08R4Val() + var12.getBud09R4Val();
                  } else if (var27 == 10) {
                     var7 += var12.getBud10R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val() + var12.getBud08R4Val() + var12.getBud09R4Val() + var12.getBud10R4Val();
                  } else if (var27 == 11) {
                     var7 += var12.getBud11R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val() + var12.getBud08R4Val() + var12.getBud09R4Val() + var12.getBud10R4Val() + var12.getBud11R4Val();
                  } else if (var27 == 12) {
                     var7 += var12.getBud12R4Val();
                     var5 = var5 + var12.getBud01R4Val() + var12.getBud02R4Val() + var12.getBud03R4Val() + var12.getBud04R4Val() + var12.getBud05R4Val() + var12.getBud06R4Val() + var12.getBud07R4Val() + var12.getBud08R4Val() + var12.getBud09R4Val() + var12.getBud10R4Val() + var12.getBud11R4Val() + var12.getBud12R4Val();
                  }
               }
            }
         }

         double var28 = 0.0D;
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         double var19 = 0.0D;
         double var21 = 0.0D;
         EcrituresDao var23 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var24 = var23.selectLesDisponibilites(this.lastExoCompta.getExecpt_id(), this.demandeEnteteAchats.getDemDate(), (Session)null);
         if (var24.size() != 0) {
            for(int var25 = 0; var25 < var24.size(); ++var25) {
               new Ecritures();
               Ecritures var26 = (Ecritures)var24.get(var25);
               if (var26.getEcrDateSaisie().getMonth() + 1 == var27) {
                  var17 += var26.getEcrDebitPays();
                  var21 += var26.getEcrCreditPays();
               }

               var15 += var26.getEcrDebitPays();
               var19 += var26.getEcrCreditPays();
            }
         }

         this.demandeEnteteAchats.setDemBudgetDispo(var5 - var28);
         this.demandeEnteteAchats.setDemBudgetDispoMois(var7 - var13);
         this.demandeEnteteAchats.setDemBudgetTreso(var15 - var19);
         this.demandeEnteteAchats.setDemBudgetTresoMois(var17 - var21);
      }

   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      float var4 = 0.0F;
      String var5 = "";
      boolean var6 = false;
      TaxesAchats var7;
      int var11;
      if (var1 != null && !var1.isEmpty()) {
         new TaxesAchats();
         var7 = this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), var1, var3);
         if (var7 != null) {
            var4 = var7.getTaxachTaux();
            var5 = var7.getTaxachCode();
            var11 = var7.getTaxachType();
         } else if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
            new TaxesAchats();
            TaxesAchats var8 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.optionAchats.getTvaDefaut(), var3);
            if (var8 != null) {
               var4 = var8.getTaxachTaux();
               var5 = var8.getTaxachCode();
               var11 = var8.getTaxachType();
            } else {
               var4 = var2;
               var5 = var1;
               var11 = 0;
            }
         } else {
            var4 = var2;
            var5 = var1;
            var11 = 0;
         }
      } else if (this.optionAchats.getTvaDefaut() != null && !this.optionAchats.getTvaDefaut().isEmpty()) {
         new TaxesAchats();
         var7 = this.taxesAchatsDao.selectTva(this.exercicesAchats.getExeachId(), this.optionAchats.getTvaDefaut(), var3);
         if (var7 != null) {
            var4 = var7.getTaxachTaux();
            var5 = var7.getTaxachCode();
            var11 = var7.getTaxachType();
         } else {
            var4 = var2;
            var5 = var1;
            var11 = 0;
         }
      } else {
         var4 = var2;
         var5 = var1;
         var11 = 0;
      }

      if (this.produits != null && this.produits.isProExoTva() || this.tiers != null && this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
         var4 = 0.0F;
         var5 = "";
         var11 = 0;
      }

      this.demandeLigneAchats.setDemligTaxe(var5);
      this.demandeLigneAchats.setDemligTauxTaxe(var4);
      this.prixUnitAvRemis = this.demandeLigneAchats.getDemligPu();
      double var12 = this.demandeLigneAchats.getDemligPu() * (double)this.demandeLigneAchats.getDemligQte();
      this.totalHt = this.utilNombre.myRoundFormat(var12, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var9 = this.totalHt * (double)this.demandeLigneAchats.getDemligTauxTaxe() / 100.0D;
      if (var11 == 2) {
         var9 *= -1.0D;
      }

      this.totalTaxe = this.utilNombre.myRoundFormat(var9, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      this.totalTtc = this.totalHt + this.totalTaxe;
      this.demandeLigneAchats.setDemligPt(this.totalHt);
      this.demandeLigneAchats.setDemligTva(this.totalTaxe);
      this.demandeLigneAchats.setDemligTtc(this.totalTtc);
   }

   public void calculPrix() throws HibernateException, NamingException {
      if (this.demandeLigneAchats.getDemligCondition() != null && !this.demandeLigneAchats.getDemligCondition().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      }

      this.calculPrix(this.demandeLigneAchats.getDemligTaxe(), this.demandeLigneAchats.getDemligTauxTaxe(), (Session)null);
   }

   public void calculPrix(String var1, float var2, Session var3) throws HibernateException, NamingException {
      this.calculHt(var1, var2, var3);
   }

   public void cumulPrix() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      new DemandeLigneAchats();

      for(int var10 = 0; var10 < this.lesLignesList.size(); ++var10) {
         DemandeLigneAchats var9 = (DemandeLigneAchats)this.lesLignesList.get(var10);
         var1 += var9.getDemligPt();
         var5 += var9.getDemligTtc();
         var3 += var9.getDemligTva();
         var7 += var9.getDemligPu() * (double)var9.getDemligQte() - var9.getDemligPt();
      }

      this.demandeEnteteAchats.setDemTotHt(var1);
      this.demandeEnteteAchats.setDemTotTtc(var5);
      this.demandeEnteteAchats.setDemTotTva(var3);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesAchatsProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      if (this.datamodelLigne.isRowAvailable()) {
         this.demandeLigneAchats = (DemandeLigneAchats)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeLigne");
         if (this.demandeLigneAchats.getDemligCode() != null && this.demandeLigneAchats.getDemligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.demandeLigneAchats.getDemligCode(), var1);
            if (this.produits != null) {
               this.var_aff_detail_prod = true;
               if (this.produits.getProImpDesciption() == 1) {
                  if (this.usersLog.getUsrAchLibelle() == 1) {
                     this.verrou_libelle = true;
                  } else {
                     this.verrou_libelle = false;
                  }
               } else {
                  this.verrou_libelle = false;
               }

               this.griserchamps = true;
               if (this.mesUnitesItems.isEmpty()) {
                  UniteDao var5 = new UniteDao(this.baseLog, this.utilInitHibernate);
                  this.mesUnitesItems = var5.chargerLesUnitesItems((Session)null);
               }

               this.mesUnitesProduits = this.mesUnitesItems;
               if (this.mesConditionnementsItems.isEmpty()) {
                  ConditionnementDao var6 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
                  this.mesConditionnementsItems = var6.chargerLesConditionnements((Session)null);
               }

               this.mesConditionnementsProduits = this.mesConditionnementsItems;
            } else {
               this.griserchamps = false;
               this.verrou_libelle = true;
            }

            if (this.demandeLigneAchats.getDemligTaxe() != null && !this.demandeLigneAchats.getDemligTaxe().isEmpty()) {
               this.mesTaxesAchatsProduits.add(new SelectItem(this.demandeLigneAchats.getDemligTaxe(), this.demandeLigneAchats.getDemligTaxe() + ":" + this.demandeLigneAchats.getDemligTauxTaxe()));
            }

            this.mesTaxesAchatsProduits.add(new SelectItem(0, ""));
            if (this.produits != null && this.var_sansstock && this.produits.getProStock() != 0) {
               new ArrayList();
               List var7 = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, (Session)null);
               if (var7.size() != 0) {
                  for(int var3 = 0; var3 < var7.size(); ++var3) {
                     ProduitsDepot var4 = (ProduitsDepot)var7.get(var3);
                     if (var4.getProdepCasier() != null && !var4.getProdepCasier().isEmpty()) {
                        this.mesProduitsDepotsItems.add(new SelectItem(var4.getDepot().getDpoCode() + ":" + var4.getProdepCasier() + "=" + var4.getProdepQteStk()));
                     } else {
                        this.mesProduitsDepotsItems.add(new SelectItem(var4.getDepot().getDpoCode() + "=" + var4.getProdepQteStk()));
                     }
                  }
               }
            }
         } else {
            this.produits = null;
            this.var_aff_detail_prod = false;
            this.verrou_libelle = false;
            this.griserchamps = false;
            this.var_aff_unite = false;
            this.mesTaxesAchatsProduits.clear();
            if (this.mesTaxesAchatsItems.size() != 0) {
               for(int var2 = 0; var2 < this.mesTaxesAchatsItems.size(); ++var2) {
                  this.mesTaxesAchatsProduits.add(this.mesTaxesAchatsItems.get(var2));
               }
            }
         }

         if (this.mesConditionnementsProduits.size() != 0) {
            this.var_aff_condit = true;
         } else {
            this.var_aff_condit = false;
         }

         if (this.mesUnitesItems.size() != 0) {
            this.var_aff_unite = true;
         } else {
            this.var_aff_unite = false;
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.var_aff_detail_prod = false;
         this.verrou_libelle = false;
         this.var_aff_condit = false;
         this.var_aff_unite = false;
         this.griserchamps = false;
      }

   }

   public void selectionLigneDetailLight() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.demandeLigneAchats = (DemandeLigneAchats)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
      } else {
         this.var_aff_detail_prod = false;
         this.verrou_libelle = false;
         this.var_aff_condit = false;
         this.var_aff_unite = false;
         this.griserchamps = false;
      }

   }

   public void addLigne() {
      this.produits = new Produits();
      this.demandeLigneAchats = new DemandeLigneAchats();
      this.mesTaxesAchatsProduits = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_code_unite = 0;
   }

   public void ordonnnerDescendant() throws HibernateException, NamingException {
      this.selectionLigneDetailLight();
      if (this.demandeLigneAchats != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.demandeLigneAchats);
            this.lesLignesList.add(this.numLigne, this.demandeLigneAchats);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.demandeLigneAchats = (DemandeLigneAchats)this.lesLignesList.get(var3);
               this.demandeLigneAchats.setDemligOrdre(var3);
               this.demandeLigneAchats = this.demandeLigneAchatsDao.modifLigne(this.demandeLigneAchats, var1);
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
      if (this.demandeLigneAchats != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.demandeLigneAchats);
            this.lesLignesList.add(this.numLigne, this.demandeLigneAchats);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.demandeLigneAchats = (DemandeLigneAchats)this.lesLignesList.get(var3);
               this.demandeLigneAchats.setDemligOrdre(var3);
               this.demandeLigneAchats = this.demandeLigneAchatsDao.modifLigne(this.demandeLigneAchats, var1);
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
            if (this.demandeLigneAchats.getDemligId() == ((DemandeLigneAchats)this.lesLignesList.get(var2)).getDemligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.demandeEnteteAchats.getDemId() == 0L) {
         this.save();
      }

      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeLigne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.demandeLigneAchats.getDemligQteUtil() == 0.0F) {
            this.demandeLigneAchats.setDemligQteUtil(this.demandeLigneAchats.getDemligQte());
         }

         this.calculPrix(this.demandeLigneAchats.getDemligTaxe(), this.demandeLigneAchats.getDemligTauxTaxe(), var1);
         if (this.demandeLigneAchats.getDemligCondition() != null && !this.demandeLigneAchats.getDemligCondition().isEmpty() && this.demandeLigneAchats.getDemligCondition().contains(":")) {
            ConditionnementDao var3 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
            String[] var4 = this.demandeLigneAchats.getDemligCondition().split(":");
            String var5 = var3.rechercheConditionnement(var4[0], var1).getCdtDescription();
            if (var5 != null && !var5.isEmpty()) {
               this.demandeLigneAchats.setDemligDescription(var5);
            } else {
               this.demandeLigneAchats.setDemligDescription("");
            }
         } else {
            this.demandeLigneAchats.setDemligDescription("");
         }

         if (this.demandeLigneAchats.getDemligId() == 0L) {
            this.demandeLigneAchats.setDemandeEnteteAchats(this.demandeEnteteAchats);
            this.demandeLigneAchats = this.demandeLigneAchatsDao.insertLigne(this.demandeLigneAchats, var1);
            if (this.numLigne == 0) {
               if (this.lesLignesList.size() != 0) {
                  this.numLigne = this.lesLignesList.size();
               } else {
                  this.numLigne = 0;
               }
            }

            this.lesLignesList.add(this.demandeLigneAchats);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
            this.numLigne = this.clauleNumlLigne() + 1;
         } else {
            this.demandeLigneAchats = this.demandeLigneAchatsDao.modifLigne(this.demandeLigneAchats, var1);
         }

         this.cumulPrix();
         this.demandeEnteteAchats = this.demandeEnteteAchatsDao.modif(this.demandeEnteteAchats, var1);
         var2.commit();
      } catch (HibernateException var9) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.addLigne();
   }

   public void deleteLigneSelect() throws HibernateException, NamingException {
      if (this.demandeLigneAchats.getDemligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.demandeLigneAchats.getDemligCode();
            this.demandeLigneAchatsDao.deleteOneLigne(this.demandeLigneAchats, var1);
            new ArrayList();
            List var4 = (List)this.datamodelLigne.getWrappedData();
            var4.remove(this.demandeLigneAchats);
            this.datamodelLigne.setWrappedData(var4);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Suppression ligne produit " + var3 + " de l'demande achat N° " + this.demandeEnteteAchats.getDemNum() + " du " + this.demandeEnteteAchats.getDemDate());
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

         if (this.lesLignesList.size() != 0) {
            this.numLigne = this.lesLignesList.size();
         } else {
            this.numLigne = 0;
         }
      }

   }

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.rechercheProduitAchat(this.demandeLigneAchats.getDemligCode(), this.nature);
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

   public void recuperationProduit() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.calculeProduit();
      this.calculeProduits();
   }

   public void calculeProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeLigne");
         this.demandeLigneAchats.setDemligCode(this.produits.getProCode());
         if (this.optionAchats.getModLibelleProd().equals("1")) {
            this.demandeLigneAchats.setDemligLibelle(this.produits.getProLibTech());
         } else {
            this.demandeLigneAchats.setDemligLibelle(this.produits.getProLibClient());
         }

         this.demandeLigneAchats.setDemligFamille(this.produits.getProAchCode());
         this.demandeLigneAchats.setDemligLong(this.produits.getProLongueur());
         this.demandeLigneAchats.setDemligLarg(this.produits.getProLargeur());
         this.demandeLigneAchats.setDemligHaut(this.produits.getProEpaisseur());
         this.demandeLigneAchats.setDemligDiam(this.produits.getProDiamExt());
         this.demandeLigneAchats.setDemligPoidsBrut(this.produits.getProPoidsBrut());
         this.demandeLigneAchats.setDemligPoidsNet(this.produits.getProPoidsNet());
         this.demandeLigneAchats.setDemligVolume(this.produits.getProVolume());
         this.demandeLigneAchats.setDemligNb(this.produits.getProNbUnite());
         this.demandeLigneAchats.setDemligReference("");
         if (this.produits.getProImpDesciption() == 1) {
            if (this.usersLog.getUsrAchLibelle() == 1) {
               this.verrou_libelle = true;
            } else {
               this.verrou_libelle = false;
            }
         } else {
            this.verrou_libelle = false;
         }

         this.mesConditionnementsProduits.clear();
         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.demandeLigneAchats.setDemligCondition(this.produits.getProCondition1());
         if (this.mesConditionnementsProduits.size() != 0) {
            this.var_aff_condit = true;
         } else {
            this.var_aff_condit = false;
         }

         this.mesTaxesAchatsProduits.clear();
         if (this.produits.getProAchTva() != null && !this.produits.getProAchTva().isEmpty() && !this.produits.getProAchTva().equals("0")) {
            float var5 = 0.0F;
            new TaxesAchats();
            TaxesAchats var7 = this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), this.produits.getProAchTva(), var1);
            if (var7 != null) {
               var5 = var7.getTaxachTaux();
            }

            this.mesTaxesAchatsProduits.add(new SelectItem(this.produits.getProAchTva(), this.produits.getProAchTva() + ":" + var5));
            this.demandeLigneAchats.setDemligTaxe(this.produits.getProAchTva());
         } else {
            new FamillesProduitsAchats();
            FamillesProduitsAchats var2 = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.lastExoAchats.getExeachId(), this.produits, var1);
            if (var2 != null && var2.getFamachTaxe() != null && !var2.getFamachTaxe().isEmpty() && !var2.getFamachTaxe().equals("0")) {
               float var3 = 0.0F;
               new TaxesAchats();
               TaxesAchats var4 = this.taxesAchatsDao.selectTva(this.lastExoAchats.getExeachId(), var2.getFamachTaxe(), var1);
               if (var4 != null) {
                  var3 = var4.getTaxachTaux();
               }

               this.mesTaxesAchatsProduits.add(new SelectItem(var2.getFamachTaxe(), var2.getFamachTaxe() + ":" + var3));
               this.demandeLigneAchats.setDemligTaxe(var2.getFamachTaxe());
            } else {
               this.demandeLigneAchats.setDemligTaxe("");
            }
         }

         this.mesTaxesAchatsProduits.add(new SelectItem(0, ""));
         this.mesProduitsDepotsItems.clear();
         if (this.var_sansstock && this.produits.getProStock() != 0) {
            new ArrayList();
            List var6 = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
            if (var6.size() != 0) {
               for(int var8 = 0; var8 < var6.size(); ++var8) {
                  ProduitsDepot var9 = (ProduitsDepot)var6.get(var8);
                  if (var9.getProdepCasier() != null && !var9.getProdepCasier().isEmpty()) {
                     this.mesProduitsDepotsItems.add(new SelectItem(var9.getDepot().getDpoCode() + ":" + var9.getProdepCasier() + "=" + var9.getProdepQteStk()));
                  } else {
                     this.mesProduitsDepotsItems.add(new SelectItem(var9.getDepot().getDpoCode() + "=" + var9.getProdepQteStk()));
                  }
               }
            }
         }

         this.prixUnitaireCorrespond(var1);
         this.prixUnitaireMoyenPondere(this.demandeLigneAchats.getDemligCode(), this.codeDepotAch, var1);
         this.demandeLigneAchats.setDemligPump(this.prixUnitaireMP);
         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.demandeLigneAchats.getDemligTaxe(), this.demandeLigneAchats.getDemligTauxTaxe(), var1);
         this.utilInitHibernate.closeSession();
      } else {
         this.annuleProduits();
      }

      this.var_action = this.var_memo_action;
   }

   public void detailProduit() {
      if (this.produits.getProPhoto() != null) {
         this.formRecherche.setProduits(this.produits);
         this.formRecherche.setNature(this.nature);
         this.formRecherche.setUrlphotoProd(this.urlphotoProd);
         this.var_action = 13;
      } else {
         this.urlphotoProd = "";
      }

   }

   public void annuleDetailProduit() {
      this.var_action = this.var_memo_action;
   }

   public void calculTva() {
      if (this.demandeLigneAchats.getDemligCode() == null || this.demandeLigneAchats.getDemligCode().isEmpty() || this.demandeLigneAchats.getDemligCode().length() < 2) {
         if (this.mesTaxesAchatsProduits.isEmpty()) {
            this.mesTaxesAchatsProduits.clear();
            if (this.mesTaxesAchatsItems.size() != 0) {
               for(int var1 = 0; var1 < this.mesTaxesAchatsItems.size(); ++var1) {
                  this.mesTaxesAchatsProduits.add(this.mesTaxesAchatsItems.get(var1));
               }
            }
         }

         this.mesUnitesProduits = this.mesUnitesItems;
         this.mesConditionnementsProduits = this.mesConditionnementsItems;
         if (this.mesConditionnementsProduits.size() != 0) {
            this.var_aff_condit = true;
         } else {
            this.var_aff_condit = false;
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.demandeLigneAchats.setDemligCode("");
      this.demandeLigneAchats.setDemligLibelle("");
      this.mesTaxesAchatsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.verrou_libelle = false;
      this.var_aff_condit = false;
      this.var_code_unite = 0;
      this.var_action = this.var_memo_action;
   }

   public void prixUnitaireCorrespond(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         ProduitsFournisseur var2 = new ProduitsFournisseur();
         new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
         if (var2 != null) {
            this.demandeLigneAchats.setDemligPu(var2.getProfouPa());
         }
      }

   }

   public void prixUnitaireMoyenPondere(String var1, String var2, Session var3) throws HibernateException, NamingException {
      if (this.produits != null) {
         if (this.var_sansstock && this.var_modestock >= 1) {
            new ArrayList();
            List var4 = this.produitsDepotDao.selectProdDepByprod(var1, var2, var3);
            if (var4.size() != 0) {
               this.prixUnitaireMP = ((ProduitsDepot)var4.get(0)).getProdepPump();
            } else {
               this.prixUnitaireMP = 0.0D;
            }
         } else {
            this.prixUnitaireMP = 0.0D;
         }
      } else {
         this.prixUnitaireMP = 0.0D;
      }

   }

   public List chargerConditionnementProduit(Session var1) throws HibernateException, NamingException {
      this.mesConditionnementsProduits.clear();
      if (this.produits != null) {
         if (this.produits.getProCondition1() != null && !this.produits.getProCondition1().isEmpty() || this.produits.getProCondition2() != null && !this.produits.getProCondition2().isEmpty() || this.produits.getProCondition3() != null && !this.produits.getProCondition3().isEmpty() || this.produits.getProCondition4() != null && !this.produits.getProCondition4().isEmpty() || this.produits.getProCondition5() != null && !this.produits.getProCondition5().isEmpty()) {
            this.mesConditionnementsProduits.add(new SelectItem(""));
         }

         if (this.produits.getProCondition1() != null && !this.produits.getProCondition1().isEmpty()) {
            this.mesConditionnementsProduits.add(new SelectItem(this.produits.getProCondition1()));
         }

         if (this.produits.getProCondition2() != null && !this.produits.getProCondition2().isEmpty()) {
            this.mesConditionnementsProduits.add(new SelectItem(this.produits.getProCondition2()));
         }

         if (this.produits.getProCondition3() != null && !this.produits.getProCondition3().isEmpty()) {
            this.mesConditionnementsProduits.add(new SelectItem(this.produits.getProCondition3()));
         }

         if (this.produits.getProCondition4() != null && !this.produits.getProCondition4().isEmpty()) {
            this.mesConditionnementsProduits.add(new SelectItem(this.produits.getProCondition4()));
         }

         if (this.produits.getProCondition5() != null && !this.produits.getProCondition5().isEmpty()) {
            this.mesConditionnementsProduits.add(new SelectItem(this.produits.getProCondition5()));
         }
      } else {
         if (this.mesConditionnementsItems.isEmpty()) {
            ConditionnementDao var2 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
            this.mesConditionnementsItems = var2.chargerLesConditionnements((Session)null);
         }

         this.mesConditionnementsProduits = this.mesConditionnementsItems;
      }

      return this.mesConditionnementsProduits;
   }

   public void serieSelectTrf() throws HibernateException, NamingException, ParseException {
      this.mesSeriesTrfItems.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      new ArrayList();
      if (this.var_type_trf != 100) {
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

            this.qteTrfQteOrg(var1);
            this.var_aff_trf = true;
         } else {
            this.var_aff_trf = false;
         }
      } else {
         this.var_aff_trf = false;
      }

      if (this.optionAchats.getDateTransformation().equals("0")) {
         this.var_date_trf = null;
      } else {
         this.var_date_trf = new Date();
      }

      this.var_serie_trf = this.demandeEnteteAchats.getDemSerie();
      this.modeleSelectTrf();
      this.lesTiers.clear();
      this.lesTiers = this.tiersDao.chargerLesTiers("0", var1);
      this.dataModelTiers.setWrappedData(this.lesTiers);
      this.utilInitHibernate.closeSession();
   }

   public void modeleSelectTrf() throws ParseException {
      this.modeleTrfItems.clear();
      String var1 = "";
      if (this.var_type_trf == 10) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "da" + File.separator;
      } else if (this.var_type_trf == 11) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "cotation" + File.separator;
      } else if (this.var_type_trf == 12) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (this.var_type_trf == 13) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "reception" + File.separator;
      } else if (this.var_type_trf == 14) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (this.var_type_trf == 15) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (this.var_type_trf == 16) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (this.var_type_trf == 17) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (this.var_type_trf == 18) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "frais" + File.separator;
      } else if (this.var_type_trf == 19) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "bon_decaissement" + File.separator;
      } else if (this.var_type_trf == 35) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      }

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
      this.var_imput_serie = this.demandeEnteteAchats.getDemSerie();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new DemandeEnteteAchats();
         DemandeEnteteAchats var1 = this.demandeEnteteAchatsDao.pourParapheur(this.var_imput_num, this.demandeEnteteAchats.getDemSerie(), (Session)null);
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
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.demandeEnteteAchats.getDemNum();
               this.demandeEnteteAchats.setDemNum(this.var_imput_num);
               this.demandeEnteteAchatsDao.modif(this.demandeEnteteAchats, var1);
               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.demandeEnteteAchats.getDemId(), this.nature, var1);
               if (var4 != null) {
                  for(var5 = 0; var5 < var4.size(); ++var5) {
                     new Parapheur();
                     var6 = (Parapheur)var4.get(var5);
                     var6.setPhrNum(this.demandeEnteteAchats.getDemNum());
                     this.parapheurDao.modif(var6, var1);
                  }
               }

               var21 = new Espion();
               var21.setUsers(this.usersLog);
               var21.setEsptype(0);
               var21.setEspdtecreat(new Date());
               var21.setEspaction("Imputation Demande achat N° " + var3 + " en Demande achat N° " + this.demandeEnteteAchats.getDemNum());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.demandeEnteteAchats.getDemNum();
            this.demandeEnteteAchats.setDemSerie(this.var_imput_serie);
            this.demandeEnteteAchats.setDemNum(this.calculChrono.numCompose(this.demandeEnteteAchats.getDemDate(), this.nature, this.demandeEnteteAchats.getDemSerie(), var1));
            this.demandeEnteteAchatsDao.modif(this.demandeEnteteAchats, var1);
            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.demandeEnteteAchats.getDemId(), this.nature, var1);
            if (var4 != null) {
               for(var5 = 0; var5 < var4.size(); ++var5) {
                  new Parapheur();
                  var6 = (Parapheur)var4.get(var5);
                  var6.setPhrNum(this.demandeEnteteAchats.getDemNum());
                  this.parapheurDao.modif(var6, var1);
               }
            }

            var21 = new Espion();
            var21.setUsers(this.usersLog);
            var21.setEsptype(0);
            var21.setEspdtecreat(new Date());
            var21.setEspaction("Imputation D.A X N° " + var3 + " en D.A. " + this.demandeEnteteAchats.getDemSerie() + " N° " + this.demandeEnteteAchats.getDemNum());
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

   public void qteTrfQteOrg() throws HibernateException, NamingException {
      this.qteTrfQteOrg((Session)null);
   }

   public void qteTrfQteOrg(Session var1) throws HibernateException, NamingException {
      if (this.documentDetailTrf.size() != 0) {
         for(int var2 = 0; var2 < this.documentDetailTrf.size(); ++var2) {
            new DemandeLigneAchats();
            DemandeLigneAchats var3 = (DemandeLigneAchats)this.documentDetailTrf.get(var2);
            float var4 = 0.0F;
            if (this.var_type_trf == 11) {
               new ArrayList();
               List var5 = this.produitsDepotDao.selectProdDepByprod(var3.getDemligCode(), var1);
               if (var5.size() != 0) {
                  for(int var6 = 0; var6 < var5.size(); ++var6) {
                     new ProduitsDepot();
                     ProduitsDepot var7 = (ProduitsDepot)var5.get(var6);
                  }
               }

               CotationLigneAchatsDao var9 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var4 = var9.chargerLesReliquatsDemandeAchs(var3.getDemligId(), var1);
            }

            float var8 = var3.getDemligQte() - var4;
            if (var8 < 0.0F) {
               var8 = 0.0F;
            }

            var3.setVar_qteDejaTrf(var4);
            var3.setVar_qteReliquat(var8);
            var3 = (DemandeLigneAchats)this.documentDetailTrf.set(var2, var3);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         for(int var1 = 0; var1 < this.documentDetailTrf.size(); ++var1) {
            new DemandeLigneAchats();
            DemandeLigneAchats var2 = (DemandeLigneAchats)this.documentDetailTrf.get(var1);
            var2.setVar_qteReliquat(0.0F);
            var2 = (DemandeLigneAchats)this.documentDetailTrf.set(var1, var2);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void selectionFournisseur() {
      if (this.datamodelTransfert.isRowAvailable()) {
         this.recopieTiers = 0;
         this.demandeLigneAchats = (DemandeLigneAchats)this.datamodelTransfert.getRowData();
         if (this.demandeLigneAchats.getLesTiers().size() == 0) {
            if (this.lesTiers.size() != 0) {
               ArrayList var6 = new ArrayList();

               for(int var7 = 0; var7 < this.lesTiers.size(); ++var7) {
                  this.tiers = (Tiers)this.lesTiers.get(var7);
                  this.tiers.setSelectionTiers(false);
                  var6.add(this.tiers);
               }

               this.demandeLigneAchats.setLesTiers(var6);
            }
         } else {
            for(int var1 = 0; var1 < this.demandeLigneAchats.getLesTiers().size(); ++var1) {
               this.tiers = (Tiers)this.lesTiers.get(var1);
               this.tiers.setSelectionTiers(false);
               long var2 = 0L;
               if (!this.demandeLigneAchats.getListeIdFournisseur().contains(":")) {
                  var2 = Long.parseLong(this.demandeLigneAchats.getListeIdFournisseur());
                  if (this.tiers.getTieid() == var2) {
                     this.tiers.setSelectionTiers(true);
                  }
               } else {
                  String[] var4 = this.demandeLigneAchats.getListeIdFournisseur().split(":");

                  for(int var5 = 0; var5 < var4.length; ++var5) {
                     var2 = Long.parseLong(var4[var5]);
                     if (this.tiers.getTieid() == var2) {
                        this.tiers.setSelectionTiers(true);
                        break;
                     }
                  }
               }
            }
         }

         this.dataModelTiers.setWrappedData(this.demandeLigneAchats.getLesTiers());
         this.showModalPanelTiers = true;
      }

   }

   public void annuleTiers() {
      this.showModalPanelTiers = false;
   }

   public void valideTiers() {
      if (this.demandeLigneAchats != null) {
         boolean var1 = true;
         String var2 = "";
         String var3 = "";
         this.demandeLigneAchats.setListFournisseur("");
         if (this.demandeLigneAchats.getLesTiers().size() != 0) {
            for(int var4 = 0; var4 < this.demandeLigneAchats.getLesTiers().size(); ++var4) {
               this.tiers = (Tiers)this.demandeLigneAchats.getLesTiers().get(var4);
               if (this.tiers.isSelectionTiers()) {
                  var2 = var2 + this.tiers.getTieraisonsocialenom() + ",";
                  if (var1) {
                     var1 = false;
                     var3 = "" + this.tiers.getTieid();
                  } else {
                     var3 = var3 + ":" + this.tiers.getTieid();
                  }
               }
            }
         }

         this.demandeLigneAchats.setListeIdFournisseur(var3);
         this.demandeLigneAchats.setListFournisseur(var2);
         int var5;
         DemandeLigneAchats var6;
         if (this.recopieTiers == 1) {
            new DemandeLigneAchats();

            for(var5 = 0; var5 < this.documentDetailTrf.size(); ++var5) {
               var6 = (DemandeLigneAchats)this.documentDetailTrf.get(var5);
               if (var6.isSelectionLigne() && (var6.getListeIdFournisseur() == null || var6.getListeIdFournisseur().isEmpty())) {
                  var6.setListeIdFournisseur(var3);
                  var6.setListFournisseur(var2);
                  var6.setSelectionLigne(false);
               }
            }

            this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
         } else if (this.recopieTiers == 2) {
            new DemandeLigneAchats();

            for(var5 = 0; var5 < this.documentDetailTrf.size(); ++var5) {
               var6 = (DemandeLigneAchats)this.documentDetailTrf.get(var5);
               if (var6.getListeIdFournisseur() == null || var6.getListeIdFournisseur().isEmpty()) {
                  var6.setListeIdFournisseur(var3);
                  var6.setListFournisseur(var2);
                  var6.setSelectionLigne(false);
               }
            }

            this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
         }
      }

      this.showModalPanelTiers = false;
   }

   public void transformerMaj() throws HibernateException, NamingException, Exception {
      if (this.documentDetailTrf.size() != 0) {
         ArrayList var1 = new ArrayList();
         Tiers var2 = new Tiers();

         int var3;
         long var5;
         for(var3 = 0; var3 < this.documentDetailTrf.size(); ++var3) {
            this.demandeLigneAchats = (DemandeLigneAchats)this.documentDetailTrf.get(var3);
            if (this.lesTiers.size() != 0) {
               boolean var4 = false;
               var5 = 0L;

               for(int var7 = 0; var7 < this.lesTiers.size(); ++var7) {
                  this.tiers = (Tiers)this.lesTiers.get(var7);
                  var4 = false;
                  int var9;
                  if (this.demandeLigneAchats.getListeIdFournisseur() != null && !this.demandeLigneAchats.getListeIdFournisseur().isEmpty()) {
                     if (!this.demandeLigneAchats.getListeIdFournisseur().contains(":")) {
                        var5 = Long.parseLong(this.demandeLigneAchats.getListeIdFournisseur());
                        if (this.tiers.getTieid() == var5) {
                           var2 = this.tiers;
                           var4 = true;
                        }
                     } else {
                        String[] var8 = this.demandeLigneAchats.getListeIdFournisseur().split(":");

                        for(var9 = 0; var9 < var8.length; ++var9) {
                           var5 = Long.parseLong(var8[var9]);
                           if (this.tiers.getTieid() == var5) {
                              var2 = this.tiers;
                              var4 = true;
                           }
                        }
                     }
                  }

                  if (var4 && var2 != null) {
                     if (var1.size() == 0) {
                        var1.add(var2);
                     } else {
                        boolean var12 = true;

                        for(var9 = 0; var9 < var1.size(); ++var9) {
                           if (((Tiers)var1.get(var9)).getTieid() == var2.getTieid()) {
                              var12 = false;
                              break;
                           }
                        }

                        if (var12) {
                           var1.add(var2);
                        }
                     }
                  }
               }
            }
         }

         if (var1.size() != 0) {
            for(var3 = 0; var3 < var1.size(); ++var3) {
               this.tiers = (Tiers)var1.get(var3);
               this.lesLignesList.clear();

               for(int var10 = 0; var10 < this.documentDetailTrf.size(); ++var10) {
                  this.demandeLigneAchats = (DemandeLigneAchats)this.documentDetailTrf.get(var10);
                  var5 = 0L;
                  if (this.demandeLigneAchats.getListeIdFournisseur() != null && !this.demandeLigneAchats.getListeIdFournisseur().isEmpty()) {
                     if (!this.demandeLigneAchats.getListeIdFournisseur().contains(":")) {
                        var5 = Long.parseLong(this.demandeLigneAchats.getListeIdFournisseur());
                        if (this.tiers.getTieid() == var5) {
                           this.lesLignesList.add(this.demandeLigneAchats);
                        }
                     } else {
                        String[] var11 = this.demandeLigneAchats.getListeIdFournisseur().split(":");

                        for(int var13 = 0; var13 < var11.length; ++var13) {
                           var5 = Long.parseLong(var11[var13]);
                           if (this.tiers.getTieid() == var5) {
                              this.lesLignesList.add(this.demandeLigneAchats);
                           }
                        }
                     }
                  }
               }

               if (this.var_type_trf == 11) {
                  this.trfCot();
               } else if (this.var_type_trf == 12) {
                  this.trfCmd();
               }
            }
         }
      }

      this.showModalPanelTrf = false;
   }

   public void trfCot() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceAchats = new DocumentTraceAchats();
         CotationEnteteAchats var3 = new CotationEnteteAchats();
         CotationEnteteAchatsDao var4 = new CotationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         CotationLigneAchatsDao var5 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         var3.setUsers(this.usersLog);
         var3.setCotIdCreateur(this.usersLog.getUsrid());
         var3.setCotNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            if (this.demandeEnteteAchats.getDemDateValide() == null) {
               this.demandeEnteteAchats.setDemDateValide(this.demandeEnteteAchats.getDemDate());
            }

            var3.setCotDate(this.utilDate.dateToSQLLight(this.demandeEnteteAchats.getDemDateValide()));
         } else {
            var3.setCotDate(this.var_date_trf);
         }

         var3.setCotDate(this.utilDate.dateToSQL(var3.getCotDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setCotDateCreat(new Date());
         var3.setCotDateModif((Date)null);
         var3.setCotIdModif(0L);
         var3.setCotNomModif("");
         var3.setCotNum("");
         boolean var7 = false;
         int var33;
         if (this.optionAchats.getNbrJrRelanceCOT() != null && !this.optionAchats.getNbrJrRelanceCOT().isEmpty()) {
            var33 = Integer.parseInt(this.optionAchats.getNbrJrRelanceCOT());
         } else {
            var33 = 0;
         }

         boolean var8 = false;
         int var34;
         if (this.optionAchats.getNbrJrValidCOT() != null && !this.optionAchats.getNbrJrValidCOT().isEmpty()) {
            var34 = Integer.parseInt(this.optionAchats.getNbrJrValidCOT());
         } else {
            var34 = 0;
         }

         var3.setCotDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var33));
         var3.setCotDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var34));
         var3.setCotService(this.demandeEnteteAchats.getDemService());
         if (!this.var_serie_trf.equalsIgnoreCase("X") && !this.var_serie_trf.isEmpty()) {
            var3.setCotNum(this.calculChrono.numCompose(var3.getCotDate(), this.var_type_trf, this.var_serie_trf, var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setCotNum("" + var9);
         }

         this.verifieExistenceHabilitationCot(var3, var1);
         var3.setCotNomResponsable(this.demandeEnteteAchats.getDemNomResponsable());
         var3.setCotIdResponsable(this.demandeEnteteAchats.getDemIdResponsable());
         var3.setCotNomTiers(this.tiers.getTieraisonsocialenom());
         var3.setCotCivilTiers(this.tiers.getTiecivilite());
         if (var3.getCotCivilTiers() != null && !var3.getCotCivilTiers().isEmpty() && var3.getCotCivilTiers().equals("Autre")) {
            var3.setCotNomTiers("");
         }

         var3.setCotIdContact(0L);
         var3.setCotNomContact("");
         var3.setCotCivilContact("");
         var3.setCotDiversAdresse("");
         var3.setCotDiversMail("");
         var3.setCotDiversNom("");
         var3.setCotDiversTel("");
         var3.setCotDiversTiers(0);
         var3.setCotDiversVille("");
         var3.setCotSerie(this.var_serie_trf);
         var3.setCotSource(this.demandeEnteteAchats.getDemSource());
         var3.setCotExoTva(this.tiers.getTieexotva());
         var3.setCotExoDouane(this.tiers.getTieexodouane());
         var3.setCotCat(this.tiers.getTienomfamille());
         if (var3.getCotCat() == null || var3.getCotCat().isEmpty()) {
            var3.setCotCat("Local");
         }

         var3.setCotDevise(this.tiers.getTiedevise());
         var3.setCotObject(this.demandeEnteteAchats.getDemObject());
         var3.setCotObservation(this.demandeEnteteAchats.getDemObservation());
         var3.setCotTotHt(0.0D);
         var3.setCotTotRemise(0.0D);
         var3.setCotTotRabais(0.0D);
         var3.setCotTotTva(0.0D);
         var3.setCotTotTc(0.0D);
         var3.setCotTotTtc(0.0D);
         var3.setCotBanque("");
         var3.setCotTypeReg(0);
         var3.setCotModeReg("");
         var3.setCotNbJourReg(0);
         var3.setCotArrondiReg(0);
         var3.setCotConditionReg("");
         var3.setCotDateEcheReg((Date)null);
         var3.setCotActivite(this.demandeEnteteAchats.getDemActivite());
         var3.setCotSite(this.demandeEnteteAchats.getDemSite());
         var3.setCotDepartement(this.demandeEnteteAchats.getDemDepartement());
         var3.setCotRegion(this.demandeEnteteAchats.getDemRegion());
         var3.setCotSecteur(this.demandeEnteteAchats.getDemSecteur());
         var3.setCotPdv(this.demandeEnteteAchats.getDemPdv());
         var3.setCotAnal2(this.demandeEnteteAchats.getDemAnal2());
         var3.setCotAnal4(this.demandeEnteteAchats.getDemAnal4());
         var3.setCotAffaire("");
         var3.setCotInfo1(this.demandeEnteteAchats.getDemInfo1());
         var3.setCotInfo2(this.demandeEnteteAchats.getDemInfo2());
         var3.setCotInfo3(this.demandeEnteteAchats.getDemInfo3());
         var3.setCotInfo4(this.demandeEnteteAchats.getDemInfo4());
         var3.setCotInfo5(this.demandeEnteteAchats.getDemInfo5());
         var3.setCotInfo6(this.demandeEnteteAchats.getDemInfo6());
         var3.setCotInfo7(this.demandeEnteteAchats.getDemInfo7());
         var3.setCotInfo8(this.demandeEnteteAchats.getDemInfo8());
         var3.setCotInfo9(this.demandeEnteteAchats.getDemInfo9());
         var3.setCotInfo10(this.demandeEnteteAchats.getDemInfo10());
         var3.setCotFormule1(this.demandeEnteteAchats.getDemFormule1());
         var3.setCotFormule2(this.demandeEnteteAchats.getDemFormule2());
         var3.setCotAnnexe1(this.demandeEnteteAchats.getDemAnnexe1());
         var3.setCotAnnexe2(this.demandeEnteteAchats.getDemAnnexe2());
         var3.setCotContrat("");
         var3.setCotIncoterm("");
         var3.setCotLieuLivraison("");
         var3.setCotDateLivraison((Date)null);
         var3.setCotInfoLivraison("");
         var3.setCotDateImp((Date)null);
         var3.setCotModeleImp(this.var_modele_trf);
         var3.setCotGele(0);
         var3.setCotEtat(0);
         var3.setCotDateTransforme((Date)null);
         var3.setCotTypeTransforme(0);
         var3.setCotDateAnnule((Date)null);
         var3.setCotMotifAnnule("");
         var3.setExercicesAchats(this.exercicesAchats);
         var3.setTiers(this.tiers);
         var3.setUsers(this.usersLog);
         var3 = var4.insert(var3, var1);
         float var35 = 0.0F;
         float var10 = 0.0F;
         float var11 = 0.0F;
         double var12 = 0.0D;
         double var14 = 0.0D;
         double var16 = 0.0D;
         double var18 = 0.0D;
         double var20 = 0.0D;
         double var22 = 0.0D;
         String var24 = "";
         int var25 = 0;
         if (this.lesLignesList.size() != 0) {
            int var26 = 0;

            while(true) {
               if (var26 >= this.lesLignesList.size()) {
                  var3.setCotTotHt(var12);
                  var3.setCotTotRemise(var14);
                  var3.setCotTotRabais(var16);
                  var3.setCotTotTva(var18);
                  var3.setCotTotTc(var22);
                  var3.setCotTotTtc(var20);
                  var3 = var4.modif(var3, var1);
                  if (var6.size() != 0) {
                     var5.saveLigne(var6, var3, var1);
                  }
                  break;
               }

               this.demandeLigneAchats = (DemandeLigneAchats)this.lesLignesList.get(var26);
               CotationLigneAchats var27;
               if (this.optionAchats.getTransformation().equals("1") && (var24 == null || var24.isEmpty() || !var24.equals(this.demandeLigneAchats.getDemandeEnteteAchats().getDemNum()))) {
                  var24 = this.demandeLigneAchats.getDemandeEnteteAchats().getDemNum();
                  ++var25;
                  var27 = new CotationLigneAchats();
                  var27.setCotligCode("-");
                  var27.setCotligLibelle("---> Suivant D.A. N° " + var24);
                  var27.setCotationEnteteAchats(var3);
                  var6.add(var27);
               }

               if (this.demandeLigneAchats.getDemligLibelle() != null && !this.demandeLigneAchats.getDemligLibelle().isEmpty() && this.demandeLigneAchats.getVar_qteReliquat() != 0.0F) {
                  ++var25;
                  var27 = new CotationLigneAchats();
                  var35 += this.demandeLigneAchats.getDemligQte();
                  var10 += this.demandeLigneAchats.getVar_qteDejaTrf();
                  if (((DemandeLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                     var27.setCotligCode(this.demandeLigneAchats.getDemligCode());
                     var27.setCotligDevise(this.demandeLigneAchats.getDemligDevise());
                     var27.setCotligFamille(this.demandeLigneAchats.getDemligFamille());
                     var27.setCotligIdDa(this.demandeLigneAchats.getDemligId());
                     var27.setCotligLibelle(this.demandeLigneAchats.getDemligLibelle());
                     var27.setCotligComplement(this.demandeLigneAchats.getDemligComplement());
                     var27.setCotligEchelle(0);
                     var27.setCotligUnite(this.demandeLigneAchats.getDemligUnite());
                     var27.setCotligCondition(this.demandeLigneAchats.getDemligCondition());
                     var27.setCotligStock(0);
                     var27.setCotligReference(this.demandeLigneAchats.getDemligReference());
                     var27.setCotligPump(this.demandeLigneAchats.getDemligPump());
                     var27.setCotligPu(this.demandeLigneAchats.getDemligPu());
                     var27.setCotligTauxRemise(0.0F);
                     var27.setCotligPuRem(0.0D);
                     this.demandeLigneAchats.setDemligQte(((DemandeLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     this.calculPrix(this.demandeLigneAchats.getDemligTaxe(), this.demandeLigneAchats.getDemligTauxTaxe(), var1);
                     var27.setCotligQte(((DemandeLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     var27.setCotligLong(this.demandeLigneAchats.getDemligLong());
                     var27.setCotligLarg(this.demandeLigneAchats.getDemligLarg());
                     var27.setCotligHaut(this.demandeLigneAchats.getDemligHaut());
                     var27.setCotligDiam(this.demandeLigneAchats.getDemligDiam());
                     var27.setCotligPoidsBrut(this.demandeLigneAchats.getDemligPoidsBrut());
                     var27.setCotligPoidsNet(this.demandeLigneAchats.getDemligPoidsNet());
                     var27.setCotligVolume(this.demandeLigneAchats.getDemligVolume());
                     var27.setCotligNb(this.demandeLigneAchats.getDemligNb());
                     var27.setCotligQteUtil(var27.getCotligQte());
                     var27.setCotligRabais(0.0D);
                     var27.setCotligTauxTaxe(this.demandeLigneAchats.getDemligTauxTaxe());
                     var27.setCotligTaxe(this.demandeLigneAchats.getDemligTaxe());
                     var27.setCotligPt(this.demandeLigneAchats.getDemligPt());
                     var27.setCotligTva(this.demandeLigneAchats.getDemligTva());
                     var27.setCotligTtc(this.demandeLigneAchats.getDemligTtc());
                     var27.setCotligTc(0.0D);
                     var27.setCotationEnteteAchats(var3);
                     var11 += ((DemandeLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat();
                     var6.add(var27);
                     var12 += var27.getCotligPt();
                     var14 += (var27.getCotligPu() - var27.getCotligPuRem()) * (double)var27.getCotligQte();
                     var16 += var27.getCotligRabais();
                     var18 += var27.getCotligTva();
                     var20 += var27.getCotligTtc();
                     var22 += var27.getCotligTc();
                  }
               }

               ++var26;
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationCot(var3, var1), var3.getCotId(), var3.getCotNum(), var3.getCotNomTiers(), var3.getCotDate(), var3.getCotDevise(), var3.getCotTotTtc() + var3.getCotTotTc(), var3.getCotModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 11), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFCOT(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceAchats.setDoctrfDateCreat(new Date());
         this.documentTraceAchats.setDoctrfUserId(this.usersLog.getUsrid());
         this.documentTraceAchats.setDoctrfUserNom(this.usersLog.getUsrNom());
         this.documentTraceAchats.setExercicesAchats(this.exercicesAchats);
         this.documentTraceAchats.setDoctrfOrgType(this.nature);
         this.documentTraceAchats.setDoctrfOrgSerie(this.demandeEnteteAchats.getDemSerie());
         this.documentTraceAchats.setDoctrfOrgId(this.demandeEnteteAchats.getDemId());
         this.documentTraceAchats.setDoctrfOrgNum(this.demandeEnteteAchats.getDemNum());
         this.documentTraceAchats.setDoctrfOrgDate(this.demandeEnteteAchats.getDemDate());
         this.documentTraceAchats.setDoctrfDstType(this.var_type_trf);
         this.documentTraceAchats.setDoctrfDstSerie(this.var_serie_trf);
         this.documentTraceAchats.setDoctrfDstId(var3.getCotId());
         this.documentTraceAchats.setDoctrfDstNum(var3.getCotNum());
         this.documentTraceAchats.setDoctrfDstDate(var3.getCotDate());
         this.documentTraceAchatsDao.insert(this.documentTraceAchats, var1);
         this.demandeEnteteAchats.setDemEtat(2);
         this.demandeEnteteAchats.setDemDateTransforme(new Date());
         this.demandeEnteteAchats.setDemTypeTransforme(this.var_type_trf);
         this.demandeEnteteAchats = this.demandeEnteteAchatsDao.modif(this.demandeEnteteAchats, var1);
         var2.commit();
      } catch (HibernateException var31) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var31;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public JRBeanCollectionDataSource calculeImpressionTRFCOT(List var1, CotationEnteteAchats var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new CotationLigneAchats();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            CotationLigneAchats var4 = (CotationLigneAchats)var1.get(var11);
            if (var4.getCotligCode() != null && !var4.getCotligCode().isEmpty() && var4.getCotligCode().equals("-")) {
               var5 = true;
               var6 = var4.getCotligLibelle();
            }

            if (var5) {
               var7 += var4.getCotligPt();
               var9 = var4.getCotligTtc();
            }

            if (var4.getCotligCode() != null && !var4.getCotligCode().isEmpty() && var4.getCotligCode().equals("=") && var5) {
               var4 = new CotationLigneAchats();
               var4.setCotationEnteteAchats(var2);
               var4.setCotligCode("=");
               var4.setCotligLibelle(var6);
               var4.setCotligPt(var7);
               var4.setCotligTtc(var9);
               var3.add(var4);
               var7 = 0.0D;
               var9 = 0.0D;
               var5 = false;
            } else {
               var3.add(var4);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2.getCotTotTtc() + var2.getCotTotTc(), var2.getCotDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationCot(CotationEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setCotEtatVal(1);
         var1.setCotEtat(0);
         var1.setCotDateValide((Date)null);
      } else {
         var1.setCotEtatVal(0);
         if (var1.getCotDateImp() != null) {
            if (var1.getCotEtat() == 0) {
               var1.setCotEtat(1);
               var1.setCotDateValide(new Date());
            }
         } else {
            var1.setCotEtat(0);
            var1.setCotDateValide((Date)null);
         }
      }

      return var4;
   }

   public void trfCmd() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.documentTraceAchats = new DocumentTraceAchats();
         CommandeEnteteAchats var3 = new CommandeEnteteAchats();
         CommandeEnteteAchatsDao var4 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         CommandeLigneAchatsDao var5 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         ArrayList var6 = new ArrayList();
         var3.setUsers(this.usersLog);
         var3.setCmdIdCreateur(this.usersLog.getUsrid());
         var3.setCmdNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            if (this.demandeEnteteAchats.getDemDateValide() == null) {
               this.demandeEnteteAchats.setDemDateValide(this.demandeEnteteAchats.getDemDate());
            }

            var3.setCmdDate(this.utilDate.dateToSQLLight(this.demandeEnteteAchats.getDemDateValide()));
         } else {
            var3.setCmdDate(this.var_date_trf);
         }

         var3.setCmdDate(this.utilDate.dateToSQL(var3.getCmdDate(), this.var_heure, this.var_minute, this.var_seconde));
         var3.setCmdDateCreat(new Date());
         var3.setCmdDateModif((Date)null);
         var3.setCmdIdModif(0L);
         var3.setCmdNomModif("");
         var3.setCmdNum("");
         boolean var7 = false;
         int var33;
         if (this.optionAchats.getNbrJrRelanceCOM() != null && !this.optionAchats.getNbrJrRelanceCOM().isEmpty()) {
            var33 = Integer.parseInt(this.optionAchats.getNbrJrRelanceCOM());
         } else {
            var33 = 0;
         }

         boolean var8 = false;
         int var34;
         if (this.optionAchats.getNbrJrValidCOM() != null && !this.optionAchats.getNbrJrValidCOM().isEmpty()) {
            var34 = Integer.parseInt(this.optionAchats.getNbrJrValidCOM());
         } else {
            var34 = 0;
         }

         var3.setCmdDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var33));
         var3.setCmdDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var34));
         var3.setCmdService(this.demandeEnteteAchats.getDemService());
         if (!this.var_serie_trf.equalsIgnoreCase("X") && !this.var_serie_trf.isEmpty()) {
            var3.setCmdNum(this.calculChrono.numCompose(var3.getCmdDate(), this.var_type_trf, this.var_serie_trf, var1));
         } else {
            long var9 = var4.selectLastNum(var1);
            var3.setCmdNum("" + var9);
         }

         this.verifieExistenceHabilitationCmd(var3, var1);
         var3.setCmdNomResponsable(this.demandeEnteteAchats.getDemNomResponsable());
         var3.setCmdIdResponsable(this.demandeEnteteAchats.getDemIdResponsable());
         var3.setCmdNomTiers(this.tiers.getTieraisonsocialenom());
         var3.setCmdCivilTiers(this.tiers.getTiecivilite());
         if (var3.getCmdCivilTiers() != null && !var3.getCmdCivilTiers().isEmpty() && var3.getCmdCivilTiers().equals("Autre")) {
            var3.setCmdNomTiers("");
         }

         var3.setCmdIdContact(0L);
         var3.setCmdNomContact("");
         var3.setCmdCivilContact("");
         var3.setCmdDiversAdresse("");
         var3.setCmdDiversMail("");
         var3.setCmdDiversNom("");
         var3.setCmdDiversTel("");
         var3.setCmdDiversTiers(0);
         var3.setCmdDiversVille("");
         var3.setCmdSerie(this.var_serie_trf);
         var3.setCmdSource(this.demandeEnteteAchats.getDemSource());
         var3.setCmdExoTva(this.tiers.getTieexotva());
         var3.setCmdExoDouane(this.tiers.getTieexodouane());
         var3.setCmdCat(this.tiers.getTienomfamille());
         if (var3.getCmdCat() == null || var3.getCmdCat().isEmpty()) {
            var3.setCmdCat("Local");
         }

         var3.setCmdDevise(this.tiers.getTiedevise());
         var3.setCmdObject(this.demandeEnteteAchats.getDemObject());
         var3.setCmdObservation(this.demandeEnteteAchats.getDemObservation());
         var3.setCmdTotHt(0.0D);
         var3.setCmdTotRemise(0.0D);
         var3.setCmdTotRabais(0.0D);
         var3.setCmdTotTva(0.0D);
         var3.setCmdTotTc(0.0D);
         var3.setCmdTotTtc(0.0D);
         var3.setCmdBanque("");
         var3.setCmdTypeReg(0);
         var3.setCmdModeReg("");
         var3.setCmdNbJourReg(0);
         var3.setCmdArrondiReg(0);
         var3.setCmdConditionReg("");
         var3.setCmdDateEcheReg((Date)null);
         var3.setCmdActivite(this.demandeEnteteAchats.getDemActivite());
         var3.setCmdSite(this.demandeEnteteAchats.getDemSite());
         var3.setCmdDepartement(this.demandeEnteteAchats.getDemDepartement());
         var3.setCmdRegion(this.demandeEnteteAchats.getDemRegion());
         var3.setCmdSecteur(this.demandeEnteteAchats.getDemSecteur());
         var3.setCmdPdv(this.demandeEnteteAchats.getDemPdv());
         var3.setCmdAnal2(this.demandeEnteteAchats.getDemAnal2());
         var3.setCmdAnal4(this.demandeEnteteAchats.getDemAnal4());
         var3.setCmdInfo1(this.demandeEnteteAchats.getDemInfo1());
         var3.setCmdInfo2(this.demandeEnteteAchats.getDemInfo2());
         var3.setCmdInfo3(this.demandeEnteteAchats.getDemInfo3());
         var3.setCmdInfo4(this.demandeEnteteAchats.getDemInfo4());
         var3.setCmdInfo5(this.demandeEnteteAchats.getDemInfo5());
         var3.setCmdInfo6(this.demandeEnteteAchats.getDemInfo6());
         var3.setCmdInfo7(this.demandeEnteteAchats.getDemInfo7());
         var3.setCmdInfo8(this.demandeEnteteAchats.getDemInfo8());
         var3.setCmdInfo9(this.demandeEnteteAchats.getDemInfo9());
         var3.setCmdInfo10(this.demandeEnteteAchats.getDemInfo10());
         var3.setCmdFormule1(this.demandeEnteteAchats.getDemFormule1());
         var3.setCmdFormule2(this.demandeEnteteAchats.getDemFormule2());
         var3.setCmdAnnexe1(this.demandeEnteteAchats.getDemAnnexe1());
         var3.setCmdAnnexe2(this.demandeEnteteAchats.getDemAnnexe2());
         var3.setCmdContrat("");
         var3.setCmdIncoterm("");
         var3.setCmdLieuLivraison("");
         var3.setCmdDateLivraison((Date)null);
         var3.setCmdInfoLivraison("");
         var3.setCmdDateImp((Date)null);
         var3.setCmdModeleImp(this.var_modele_trf);
         var3.setCmdGele(0);
         var3.setCmdEtat(0);
         var3.setCmdDateTransforme((Date)null);
         var3.setCmdTypeTransforme(0);
         var3.setCmdDateAnnule((Date)null);
         var3.setCmdMotifAnnule("");
         var3.setExercicesAchats(this.exercicesAchats);
         var3.setTiers(this.tiers);
         var3.setUsers(this.usersLog);
         var3 = var4.insert(var3, var1);
         float var35 = 0.0F;
         float var10 = 0.0F;
         float var11 = 0.0F;
         double var12 = 0.0D;
         double var14 = 0.0D;
         double var16 = 0.0D;
         double var18 = 0.0D;
         double var20 = 0.0D;
         double var22 = 0.0D;
         String var24 = "";
         int var25 = 0;
         if (this.lesLignesList.size() != 0) {
            int var26 = 0;

            while(true) {
               if (var26 >= this.lesLignesList.size()) {
                  var3.setCmdTotHt(var12);
                  var3.setCmdTotRemise(var14);
                  var3.setCmdTotRabais(var16);
                  var3.setCmdTotTva(var18);
                  var3.setCmdTotTc(var22);
                  var3.setCmdTotTtc(var20);
                  var3 = var4.modif(var3, var1);
                  if (var6.size() != 0) {
                     var5.saveLigne(var6, var3, var1);
                  }
                  break;
               }

               this.demandeLigneAchats = (DemandeLigneAchats)this.lesLignesList.get(var26);
               CommandeLigneAchats var27;
               if (this.optionAchats.getTransformation().equals("1") && (var24 == null || var24.isEmpty() || !var24.equals(this.demandeLigneAchats.getDemandeEnteteAchats().getDemNum()))) {
                  var24 = this.demandeLigneAchats.getDemandeEnteteAchats().getDemNum();
                  ++var25;
                  var27 = new CommandeLigneAchats();
                  var27.setCmdligCode("-");
                  var27.setCmdligLibelle("---> Suivant D.A. N° " + var24);
                  var27.setCommandeEnteteAchats(var3);
                  var6.add(var27);
               }

               if (this.demandeLigneAchats.getDemligLibelle() != null && !this.demandeLigneAchats.getDemligLibelle().isEmpty() && this.demandeLigneAchats.getVar_qteReliquat() != 0.0F) {
                  ++var25;
                  var27 = new CommandeLigneAchats();
                  var35 += this.demandeLigneAchats.getDemligQte();
                  var10 += this.demandeLigneAchats.getVar_qteDejaTrf();
                  if (((DemandeLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat() != 0.0F) {
                     var27.setCmdligCode(this.demandeLigneAchats.getDemligCode());
                     var27.setCmdligDevise(this.demandeLigneAchats.getDemligDevise());
                     var27.setCmdligFamille(this.demandeLigneAchats.getDemligFamille());
                     var27.setCmdligIdDa(this.demandeLigneAchats.getDemligId());
                     var27.setCmdligLibelle(this.demandeLigneAchats.getDemligLibelle());
                     var27.setCmdligComplement(this.demandeLigneAchats.getDemligComplement());
                     var27.setCmdligEchelle(0);
                     var27.setCmdligUnite(this.demandeLigneAchats.getDemligUnite());
                     var27.setCmdligCondition(this.demandeLigneAchats.getDemligCondition());
                     var27.setCmdligStock(0);
                     var27.setCmdligReference(this.demandeLigneAchats.getDemligReference());
                     var27.setCmdligPump(this.demandeLigneAchats.getDemligPump());
                     var27.setCmdligPu(this.demandeLigneAchats.getDemligPu());
                     var27.setCmdligTauxRemise(0.0F);
                     var27.setCmdligPuRem(0.0D);
                     this.demandeLigneAchats.setDemligQte(((DemandeLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     this.calculPrix(this.demandeLigneAchats.getDemligTaxe(), this.demandeLigneAchats.getDemligTauxTaxe(), var1);
                     var27.setCmdligQte(((DemandeLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat());
                     var27.setCmdligLong(this.demandeLigneAchats.getDemligLong());
                     var27.setCmdligLarg(this.demandeLigneAchats.getDemligLarg());
                     var27.setCmdligHaut(this.demandeLigneAchats.getDemligHaut());
                     var27.setCmdligDiam(this.demandeLigneAchats.getDemligDiam());
                     var27.setCmdligPoidsBrut(this.demandeLigneAchats.getDemligPoidsBrut());
                     var27.setCmdligPoidsNet(this.demandeLigneAchats.getDemligPoidsNet());
                     var27.setCmdligVolume(this.demandeLigneAchats.getDemligVolume());
                     var27.setCmdligNb(this.demandeLigneAchats.getDemligNb());
                     var27.setCmdligQteUtil(var27.getCmdligQte());
                     var27.setCmdligRabais(0.0D);
                     var27.setCmdligTauxTaxe(this.demandeLigneAchats.getDemligTauxTaxe());
                     var27.setCmdligTaxe(this.demandeLigneAchats.getDemligTaxe());
                     var27.setCmdligPt(this.demandeLigneAchats.getDemligPt());
                     var27.setCmdligTva(this.demandeLigneAchats.getDemligTva());
                     var27.setCmdligTtc(this.demandeLigneAchats.getDemligTtc());
                     var27.setCmdligTc(0.0D);
                     var27.setCommandeEnteteAchats(var3);
                     var11 += ((DemandeLigneAchats)this.lesLignesList.get(var26)).getVar_qteReliquat();
                     var6.add(var27);
                     var12 += var27.getCmdligPt();
                     var14 += (var27.getCmdligPu() - var27.getCmdligPuRem()) * (double)var27.getCmdligQte();
                     var16 += var27.getCmdligRabais();
                     var18 += var27.getCmdligTva();
                     var20 += var27.getCmdligTtc();
                     var22 += var27.getCmdligTc();
                  }
               }

               ++var26;
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationCmd(var3, var1), var3.getCmdId(), var3.getCmdNum(), var3.getCmdNomTiers(), var3.getCmdDate(), var3.getCmdDevise(), var3.getCmdTotTtc() + var3.getCmdTotTc(), var3.getCmdModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 11), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFCMD(var6, var3), this.calculeParc(var1), var3.getVar_format_devise(), 0, var1);
         this.documentTraceAchats.setDoctrfDateCreat(new Date());
         this.documentTraceAchats.setDoctrfUserId(this.usersLog.getUsrid());
         this.documentTraceAchats.setDoctrfUserNom(this.usersLog.getUsrNom());
         this.documentTraceAchats.setExercicesAchats(this.exercicesAchats);
         this.documentTraceAchats.setDoctrfOrgType(this.nature);
         this.documentTraceAchats.setDoctrfOrgSerie(this.demandeEnteteAchats.getDemSerie());
         this.documentTraceAchats.setDoctrfOrgId(this.demandeEnteteAchats.getDemId());
         this.documentTraceAchats.setDoctrfOrgNum(this.demandeEnteteAchats.getDemNum());
         this.documentTraceAchats.setDoctrfOrgDate(this.demandeEnteteAchats.getDemDate());
         this.documentTraceAchats.setDoctrfDstType(this.var_type_trf);
         this.documentTraceAchats.setDoctrfDstSerie(this.var_serie_trf);
         this.documentTraceAchats.setDoctrfDstId(var3.getCmdId());
         this.documentTraceAchats.setDoctrfDstNum(var3.getCmdNum());
         this.documentTraceAchats.setDoctrfDstDate(var3.getCmdDate());
         this.documentTraceAchatsDao.insert(this.documentTraceAchats, var1);
         this.demandeEnteteAchats.setDemEtat(2);
         this.demandeEnteteAchats.setDemDateTransforme(new Date());
         this.demandeEnteteAchats.setDemTypeTransforme(this.var_type_trf);
         this.demandeEnteteAchats = this.demandeEnteteAchatsDao.modif(this.demandeEnteteAchats, var1);
         var2.commit();
      } catch (HibernateException var31) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var31;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public JRBeanCollectionDataSource calculeImpressionTRFCMD(List var1, CommandeEnteteAchats var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new CommandeLigneAchats();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            CommandeLigneAchats var4 = (CommandeLigneAchats)var1.get(var11);
            if (var4.getCmdligCode() != null && !var4.getCmdligCode().isEmpty() && var4.getCmdligCode().equals("-")) {
               var5 = true;
               var6 = var4.getCmdligLibelle();
            }

            if (var5) {
               var7 += var4.getCmdligPt();
               var9 = var4.getCmdligTtc();
            }

            if (var4.getCmdligCode() != null && !var4.getCmdligCode().isEmpty() && var4.getCmdligCode().equals("=") && var5) {
               var4 = new CommandeLigneAchats();
               var4.setCommandeEnteteAchats(var2);
               var4.setCmdligCode("=");
               var4.setCmdligLibelle(var6);
               var4.setCmdligPt(var7);
               var4.setCmdligTtc(var9);
               var3.add(var4);
               var7 = 0.0D;
               var9 = 0.0D;
               var5 = false;
            } else {
               var3.add(var4);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2.getCmdTotTtc() + var2.getCmdTotTc(), var2.getCmdDevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationCmd(CommandeEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setCmdEtatVal(1);
         var1.setCmdEtat(0);
         var1.setCmdDateValide((Date)null);
      } else {
         var1.setCmdEtatVal(0);
         if (var1.getCmdDateImp() != null) {
            if (var1.getCmdEtat() == 0) {
               var1.setCmdEtat(1);
               var1.setCmdDateValide(new Date());
            }
         } else {
            var1.setCmdEtat(0);
            var1.setCmdDateValide((Date)null);
         }
      }

      return var4;
   }

   public String formule1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.demandeEnteteAchats.getDemFormule1() != null && !this.demandeEnteteAchats.getDemFormule1().isEmpty()) {
         FormulesAchatsDao var2 = new FormulesAchatsDao(this.baseLog, this.utilInitHibernate);
         var1 = var2.selectFormulesAchats(this.demandeEnteteAchats.getDemFormule1(), (Session)null);
      }

      return var1;
   }

   public String conversionAnnexe1() throws HibernateException, NamingException {
      String var1 = null;
      if (this.demandeEnteteAchats.getDemAnnexe1() != null && !this.demandeEnteteAchats.getDemAnnexe1().isEmpty() && this.demandeEnteteAchats.getDemAnnexe1().contains(":")) {
         String[] var2 = this.demandeEnteteAchats.getDemAnnexe1().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.demandeEnteteAchats.getUsers(), this.structureLog, (Tiers)null);
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + this.baseLog + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String conversionAnnexe2() throws HibernateException, NamingException {
      String var1 = null;
      if (this.demandeEnteteAchats.getDemAnnexe2() != null && !this.demandeEnteteAchats.getDemAnnexe2().isEmpty() && this.demandeEnteteAchats.getDemAnnexe2().contains(":")) {
         String[] var2 = this.demandeEnteteAchats.getDemAnnexe2().split(":");
         new ModelesCourriers();
         ModelesCourriersDao var4 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
         ModelesCourriers var3 = var4.rechercheModeles(var2[0], (Session)null);
         if (var3 != null) {
            if (var3.getModTexte().contains("[")) {
               var1 = this.utilTdt.analyseTexteCommercial(var3.getModTexte(), this.demandeEnteteAchats.getUsers(), this.structureLog, (Tiers)null);
            } else {
               var1 = var3.getModTexte();
            }

            if (this.usersLog.getUsrSignature() != null && !this.usersLog.getUsrSignature().isEmpty()) {
               String var5 = "http://" + this.getUrlIpProd() + "/epegase/imageServlet/" + this.baseLog + "/photos/Users/" + this.usersLog.getUsrSignature();
               var1 = var1 + "<p>&nbsp;</p><p>&nbsp;</p><p><img style=" + "display: block; margin-left: auto; margin-right: auto;" + " title=" + "signature" + " src=" + var5 + " alt=" + "signature /></p>";
            }
         }
      }

      return var1;
   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = "";
      if (var2 == 10) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "da" + File.separator;
      } else if (var2 == 11) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "cotation" + File.separator;
      } else if (var2 == 12) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (var2 == 13) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "reception" + File.separator;
      } else if (var2 == 14) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (var2 == 15) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (var2 == 16) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (var2 == 17) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (var2 == 18) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "frais" + File.separator;
      } else if (var2 == 19) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "bon_decaissement" + File.separator;
      } else if (var2 == 35) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      } else if (var2 == 30) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "inventaire" + File.separator;
      } else if (var2 == 31) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_entree" + File.separator;
      } else if (var2 == 32) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_sortie" + File.separator;
      } else if (var2 == 33) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "cession" + File.separator;
      } else if (var2 == 34) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "production" + File.separator;
      } else if (var2 == 35) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      } else if (var2 == 36) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "sommier" + File.separator;
      }

      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatDa.jpg");
            if (var4.exists()) {
               var3 = "formatDa.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatDa.jpg");
         if (var4.exists()) {
            var3 = "formatDa.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            var1.add(this.lesLignesList.get(var2));
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.demandeEnteteAchats.getDemTotTtc() + this.demandeEnteteAchats.getDemTotTc(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
      return var3;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.demandeEnteteAchats.getDemAnal2() != null && !this.demandeEnteteAchats.getDemAnal2().isEmpty()) {
         String var4 = "";
         if (this.demandeEnteteAchats.getDemAnal2().contains(":")) {
            String[] var5 = this.demandeEnteteAchats.getDemAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.demandeEnteteAchats.getDemAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.demandeEnteteAchats.getDemDateImp() != null) {
            var2 = true;
         }

         this.demandeEnteteAchats.setDemDateImp(new Date());
         if (this.demandeEnteteAchats.getDemEtat() == 0 && this.demandeEnteteAchats.getDemEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.demandeEnteteAchats.setDemEtat(1);
            this.demandeEnteteAchats.setDemDateValide(new Date());
         }

         this.demandeEnteteAchats.setDemModeleImp(var1);
         this.demandeEnteteAchats = this.demandeEnteteAchatsDao.modif(this.demandeEnteteAchats, var3);
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
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var3);
            var1.setEntete("Impression demande");
            var1.setMontant_lettre(this.montant_lettre);
            if (this.demandeEnteteAchats.getDemFormule1() != null && !this.demandeEnteteAchats.getDemFormule1().isEmpty()) {
               var1.setAdresseLivraison(this.formule1());
            } else {
               var1.setAdresseLivraison((String)null);
            }

            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport(this.baseLog, this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport(this.baseLog));
            var1.setImageFondPage(this.calculeImageFond(this.baseLog, this.demandeEnteteAchats.getDemEtat()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionAchats.getNbDecQte());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.demandeEnteteAchats.getDemIdResponsable());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.demandeEnteteAchats.getDemId());
            if (this.demandeEnteteAchats.getDemAnal2() != null && !this.demandeEnteteAchats.getDemAnal2().isEmpty()) {
               String var12 = "";
               if (this.demandeEnteteAchats.getDemAnal2().contains(":")) {
                  String[] var13 = this.demandeEnteteAchats.getDemAnal2().split(":");
                  var12 = var13[0];
               } else {
                  var12 = this.demandeEnteteAchats.getDemAnal2();
               }

               new Parc();
               ParcDao var14 = new ParcDao(this.baseLog, this.utilInitHibernate);
               Parc var16 = var14.rechercheParc(var12, (Session)null);
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
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des demandes");
         var1.setTotauxHt("" + this.totauxHt);
         var1.setTotauxTaxe("" + this.totauxTaxe);
         var1.setTotauxTtc("" + this.totauxTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "da" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
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
         JRBeanCollectionDataSource var15 = new JRBeanCollectionDataSource(this.lesEntetesList);
         var1.setjRBeanCollectionDataSource(var15);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void selectionTracabilite() {
      if (this.datamodelDocumentTrace.isRowAvailable()) {
         this.documentTraceAchats = (DocumentTraceAchats)this.datamodelDocumentTrace.getRowData();
      }

   }

   public void voirOrigine() throws IOException, SAXException, JDOMException, HibernateException, NamingException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.documentTraceAchats == null) {
         this.selectionTracabilite();
      }

      if (this.documentTraceAchats != null) {
         this.voirCommun(this.documentTraceAchats.getDoctrfOrgType(), this.documentTraceAchats.getDoctrfOrgId(), this.documentTraceAchats.getDoctrfOrgNum(), this.documentTraceAchats.getDoctrfOrgSerie());
      }

   }

   public void voirDestination() throws IOException, SAXException, JDOMException, HibernateException, NamingException, SQLException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.documentTraceAchats == null) {
         this.selectionTracabilite();
      }

      if (this.documentTraceAchats != null) {
         this.voirCommun(this.documentTraceAchats.getDoctrfDstType(), this.documentTraceAchats.getDoctrfDstId(), this.documentTraceAchats.getDoctrfDstNum(), this.documentTraceAchats.getDoctrfDstSerie());
      }

   }

   public void voirCommun(int var1, long var2, String var4, String var5) throws IOException, SAXException, JDOMException, HibernateException, NamingException, SQLException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.documentTraceAchats == null) {
         this.selectionTracabilite();
      }

      if (this.documentTraceAchats != null) {
         UtilPrint var6 = new UtilPrint(this.utilInitHibernate);
         String var8;
         if (var1 == 10) {
            FormDemandeAchats var7 = new FormDemandeAchats();
            var7.setBaseLog(this.baseLog);
            var7.setStructureLog(this.structureLog);
            var7.setUsersLog(this.usersLog);
            var7.setutilInitHibernate(this.utilInitHibernate);
            var7.InstancesDaoUtilses();
            var7.rechercheDOCUMENT(var2);
            if (var7.getDemandeEnteteAchats() != null) {
               var7.setExercicesAchats(var7.getDemandeEnteteAchats().getExercicesAchats());
               var8 = var7.getDemandeEnteteAchats().getDemModeleImp();
               var7.setOptionAchats(this.optionAchats);
               var7.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var7.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la DA n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la DA n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 11) {
            FormCotationAchats var9 = new FormCotationAchats();
            var9.setBaseLog(this.baseLog);
            var9.setStructureLog(this.structureLog);
            var9.setUsersLog(this.usersLog);
            var9.setutilInitHibernate(this.utilInitHibernate);
            var9.InstancesDaoUtilses();
            var9.rechercheDOCUMENT(var2);
            if (var9.getCotationEnteteAchats() != null) {
               var9.setExercicesAchats(var9.getCotationEnteteAchats().getExercicesAchats());
               var8 = var9.getCotationEnteteAchats().getCotModeleImp();
               var9.setOptionAchats(this.optionAchats);
               var9.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var9.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la Cotation n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la Cotation n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 12) {
            FormCommandeAchats var10 = new FormCommandeAchats();
            var10.setBaseLog(this.baseLog);
            var10.setStructureLog(this.structureLog);
            var10.setUsersLog(this.usersLog);
            var10.setutilInitHibernate(this.utilInitHibernate);
            var10.InstancesDaoUtilses();
            var10.rechercheDOCUMENT(var2);
            if (var10.getCommandeEnteteAchats() != null) {
               var10.setExercicesAchats(var10.getCommandeEnteteAchats().getExercicesAchats());
               var8 = var10.getCommandeEnteteAchats().getCmdModeleImp();
               var10.setOptionAchats(this.optionAchats);
               var10.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var10.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la CMD n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la CMD n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 13) {
            FormReceptionAchats var11 = new FormReceptionAchats();
            var11.setBaseLog(this.baseLog);
            var11.setStructureLog(this.structureLog);
            var11.setUsersLog(this.usersLog);
            var11.setutilInitHibernate(this.utilInitHibernate);
            var11.InstancesDaoUtilses();
            var11.rechercheDOCUMENT(var2);
            if (var11.getReceptionEnteteAchats() != null) {
               var11.setExercicesAchats(var11.getReceptionEnteteAchats().getExercicesAchats());
               var8 = var11.getReceptionEnteteAchats().getRecModeleImp();
               var11.setOptionAchats(this.optionAchats);
               var11.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var11.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la Réception n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la Réception n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 14) {
            FormRetourAchats var12 = new FormRetourAchats();
            var12.setBaseLog(this.baseLog);
            var12.setStructureLog(this.structureLog);
            var12.setUsersLog(this.usersLog);
            var12.setutilInitHibernate(this.utilInitHibernate);
            var12.InstancesDaoUtilses();
            var12.rechercheDOCUMENT(var2);
            if (var12.getRetourEnteteAchats() != null) {
               var12.setExercicesAchats(var12.getRetourEnteteAchats().getExercicesAchats());
               var8 = var12.getRetourEnteteAchats().getBrfModeleImp();
               var12.setOptionAchats(this.optionAchats);
               var12.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var12.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("le Retour n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("le Retour n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 15) {
            FormFactureAchats var13 = new FormFactureAchats();
            var13.setBaseLog(this.baseLog);
            var13.setStructureLog(this.structureLog);
            var13.setUsersLog(this.usersLog);
            var13.setutilInitHibernate(this.utilInitHibernate);
            var13.InstancesDaoUtilses();
            var13.rechercheDOCUMENT(var2);
            if (var13.getFactureEnteteAchats() != null) {
               var13.setExercicesAchats(var13.getFactureEnteteAchats().getExercicesAchats());
               var8 = var13.getFactureEnteteAchats().getFcfModeleImp();
               var13.setOptionAchats(this.optionAchats);
               var13.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var13.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la Facture n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la Facture n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 16) {
            FormAvoirAchats var14 = new FormAvoirAchats();
            var14.setBaseLog(this.baseLog);
            var14.setStructureLog(this.structureLog);
            var14.setUsersLog(this.usersLog);
            var14.setutilInitHibernate(this.utilInitHibernate);
            var14.InstancesDaoUtilses();
            var14.rechercheDOCUMENT(var2);
            if (var14.getAvoirEnteteAchats() != null) {
               var14.setExercicesAchats(var14.getAvoirEnteteAchats().getExercicesAchats());
               var8 = var14.getAvoirEnteteAchats().getAvfModeleImp();
               var14.setOptionAchats(this.optionAchats);
               var14.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var14.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("l`Avoir n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("l`Avoir n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (var1 == 17) {
            FormNoteDebitAchats var15 = new FormNoteDebitAchats();
            var15.setBaseLog(this.baseLog);
            var15.setStructureLog(this.structureLog);
            var15.setUsersLog(this.usersLog);
            var15.setutilInitHibernate(this.utilInitHibernate);
            var15.InstancesDaoUtilses();
            var15.rechercheDOCUMENT(var2);
            if (var15.getNoteDebitEnteteAchats() != null) {
               var15.setExercicesAchats(var15.getNoteDebitEnteteAchats().getExercicesAchats());
               var8 = var15.getNoteDebitEnteteAchats().getNdfModeleImp();
               var15.setOptionAchats(this.optionAchats);
               var15.setNature(var1);
               if (var8 != null && !var8.isEmpty()) {
                  var15.impression(var6, 0, var8, "", "PDF", "", "", "", "", "");
               } else {
                  this.formRecherche.setMessageTexte("la Note de débit n° " + var4 + ":" + var5 + " n`a pas de modèle d`impression...");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.formRecherche.setMessageTexte("la Note Débit n° " + var4 + ":" + var5 + " est introuvable...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         }
      }

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

   public DataModel getDatamodelDocumentTrace() {
      return this.datamodelDocumentTrace;
   }

   public void setDatamodelDocumentTrace(DataModel var1) {
      this.datamodelDocumentTrace = var1;
   }

   public DemandeEnteteAchats getDemandeEnteteAchats() {
      return this.demandeEnteteAchats;
   }

   public void setDemandeEnteteAchats(DemandeEnteteAchats var1) {
      this.demandeEnteteAchats = var1;
   }

   public DemandeLigneAchats getDemandeLigneAchats() {
      return this.demandeLigneAchats;
   }

   public void setDemandeLigneAchats(DemandeLigneAchats var1) {
      this.demandeLigneAchats = var1;
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

   public String getInpBudget() {
      return this.inpBudget;
   }

   public void setInpBudget(String var1) {
      this.inpBudget = var1;
   }

   public String getInpFournisseur() {
      return this.inpFournisseur;
   }

   public void setInpFournisseur(String var1) {
      this.inpFournisseur = var1;
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

   public List getMesConditionnementsProduits() {
      return this.mesConditionnementsProduits;
   }

   public void setMesConditionnementsProduits(List var1) {
      this.mesConditionnementsProduits = var1;
   }

   public List getMesProduitsDepotsItems() {
      return this.mesProduitsDepotsItems;
   }

   public void setMesProduitsDepotsItems(List var1) {
      this.mesProduitsDepotsItems = var1;
   }

   public List getMesTaxesAchatsItems() {
      return this.mesTaxesAchatsItems;
   }

   public void setMesTaxesAchatsItems(List var1) {
      this.mesTaxesAchatsItems = var1;
   }

   public List getMesUnitesProduits() {
      return this.mesUnitesProduits;
   }

   public void setMesUnitesProduits(List var1) {
      this.mesUnitesProduits = var1;
   }

   public List getMesUsersItem() {
      return this.mesUsersItem;
   }

   public void setMesUsersItem(List var1) {
      this.mesUsersItem = var1;
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

   public boolean isVar_acc_prp() {
      return this.var_acc_prp;
   }

   public void setVar_acc_prp(boolean var1) {
      this.var_acc_prp = var1;
   }

   public boolean isVar_acc_special() {
      return this.var_acc_special;
   }

   public void setVar_acc_special(boolean var1) {
      this.var_acc_special = var1;
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

   public int getVar_code_unite() {
      return this.var_code_unite;
   }

   public void setVar_code_unite(int var1) {
      this.var_code_unite = var1;
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

   public int getVar_modestock() {
      return this.var_modestock;
   }

   public void setVar_modestock(int var1) {
      this.var_modestock = var1;
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

   public int getVar_num_ligne() {
      return this.var_num_ligne;
   }

   public void setVar_num_ligne(int var1) {
      this.var_num_ligne = var1;
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

   public String getVerrouDepotUser() {
      return this.verrouDepotUser;
   }

   public void setVerrouDepotUser(String var1) {
      this.verrouDepotUser = var1;
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

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
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

   public List getMesTaxesAchatsProduits() {
      return this.mesTaxesAchatsProduits;
   }

   public void setMesTaxesAchatsProduits(List var1) {
      this.mesTaxesAchatsProduits = var1;
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

   public List getMesConditionnementsItems() {
      return this.mesConditionnementsItems;
   }

   public void setMesConditionnementsItems(List var1) {
      this.mesConditionnementsItems = var1;
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

   public boolean isVar_anal_dossier() {
      return this.var_anal_dossier;
   }

   public void setVar_anal_dossier(boolean var1) {
      this.var_anal_dossier = var1;
   }

   public ExercicesComptable getLastExoCompta() {
      return this.lastExoCompta;
   }

   public void setLastExoCompta(ExercicesComptable var1) {
      this.lastExoCompta = var1;
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

   public int getVar_option_parc() {
      return this.var_option_parc;
   }

   public void setVar_option_parc(int var1) {
      this.var_option_parc = var1;
   }

   public boolean isVerrou_libelle() {
      return this.verrou_libelle;
   }

   public void setVerrou_libelle(boolean var1) {
      this.verrou_libelle = var1;
   }

   public boolean isVerrouPump() {
      return this.verrouPump;
   }

   public void setVerrouPump(boolean var1) {
      this.verrouPump = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public int getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(int var1) {
      this.var_timbre = var1;
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

   public boolean isVar_verrou_service() {
      return this.var_verrou_service;
   }

   public void setVar_verrou_service(boolean var1) {
      this.var_verrou_service = var1;
   }

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
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

   public int getChoixSitDepSer() {
      return this.choixSitDepSer;
   }

   public void setChoixSitDepSer(int var1) {
      this.choixSitDepSer = var1;
   }

   public DataModel getDatamodelTransfert() {
      return this.datamodelTransfert;
   }

   public void setDatamodelTransfert(DataModel var1) {
      this.datamodelTransfert = var1;
   }

   public List getDocumentTrfItems() {
      return this.documentTrfItems;
   }

   public void setDocumentTrfItems(List var1) {
      this.documentTrfItems = var1;
   }

   public List getMesBudgetsItems() {
      return this.mesBudgetsItems;
   }

   public void setMesBudgetsItems(List var1) {
      this.mesBudgetsItems = var1;
   }

   public List getMesSeriesTrfItems() {
      return this.mesSeriesTrfItems;
   }

   public void setMesSeriesTrfItems(List var1) {
      this.mesSeriesTrfItems = var1;
   }

   public List getModeleTrfItems() {
      return this.modeleTrfItems;
   }

   public void setModeleTrfItems(List var1) {
      this.modeleTrfItems = var1;
   }

   public boolean isShowModalPanelPaye() {
      return this.showModalPanelPaye;
   }

   public void setShowModalPanelPaye(boolean var1) {
      this.showModalPanelPaye = var1;
   }

   public boolean isShowModalPanelTrf() {
      return this.showModalPanelTrf;
   }

   public void setShowModalPanelTrf(boolean var1) {
      this.showModalPanelTrf = var1;
   }

   public boolean isVar_aff_trf() {
      return this.var_aff_trf;
   }

   public void setVar_aff_trf(boolean var1) {
      this.var_aff_trf = var1;
   }

   public Date getVar_date_trf() {
      return this.var_date_trf;
   }

   public void setVar_date_trf(Date var1) {
      this.var_date_trf = var1;
   }

   public String getVar_modele_trf() {
      return this.var_modele_trf;
   }

   public void setVar_modele_trf(String var1) {
      this.var_modele_trf = var1;
   }

   public String getVar_serie_trf() {
      return this.var_serie_trf;
   }

   public void setVar_serie_trf(String var1) {
      this.var_serie_trf = var1;
   }

   public int getVar_type_trf() {
      return this.var_type_trf;
   }

   public void setVar_type_trf(int var1) {
      this.var_type_trf = var1;
   }

   public DataModel getDataModelTiers() {
      return this.dataModelTiers;
   }

   public void setDataModelTiers(DataModel var1) {
      this.dataModelTiers = var1;
   }

   public boolean isShowModalPanelTiers() {
      return this.showModalPanelTiers;
   }

   public void setShowModalPanelTiers(boolean var1) {
      this.showModalPanelTiers = var1;
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

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public Parapheur getParapheur() {
      return this.parapheur;
   }

   public void setParapheur(Parapheur var1) {
      this.parapheur = var1;
   }

   public int getRecopieTiers() {
      return this.recopieTiers;
   }

   public void setRecopieTiers(int var1) {
      this.recopieTiers = var1;
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

   public boolean isVar_aff_unite() {
      return this.var_aff_unite;
   }

   public void setVar_aff_unite(boolean var1) {
      this.var_aff_unite = var1;
   }

   public List getLisTaxesAchats() {
      return this.lisTaxesAchats;
   }

   public void setLisTaxesAchats(List var1) {
      this.lisTaxesAchats = var1;
   }

   public int getNumLigne() {
      return this.numLigne;
   }

   public void setNumLigne(int var1) {
      this.numLigne = var1;
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
