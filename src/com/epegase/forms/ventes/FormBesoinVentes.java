package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.BesoinEnteteVentes;
import com.epegase.systeme.classe.BesoinLigneVentes;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.ChargementEntete;
import com.epegase.systeme.classe.ChargementLigne;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsGrp;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.BesoinEnteteVentesDao;
import com.epegase.systeme.dao.BesoinLigneVentesDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.ChargementEnteteDao;
import com.epegase.systeme.dao.ChargementLigneDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsGrpDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
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

public class FormBesoinVentes implements Serializable {
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
   private int var_option_parc;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_timbre;
   private int var_tc_type;
   private String var_tc_libelle;
   private float var_tc_taux;
   private boolean var_tc_calcul;
   private int var_nb_max = 100;
   private List mesSerieUserItem;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean visibleOnglet = false;
   private boolean var_sansstock = false;
   private boolean var_pr_pv = false;
   private boolean var_aff_detail_prod = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private boolean existParapheur = false;
   private List lesFamilleClientsListe;
   private PlansAnalytiques plansAnalytiques = new PlansAnalytiques();
   private Users responsable;
   private long var_nom_commercial;
   private List mesCommercialItem = new ArrayList();
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private List mesUsersItem = new ArrayList();
   private long var_nom_equipe;
   private Equipes equipes;
   private EquipesDao equipesDao;
   private List mesEquipeItem = new ArrayList();
   private List lesEquipes = new ArrayList();
   private BesoinEnteteVentes besoinEnteteVentes = new BesoinEnteteVentes();
   private BesoinEnteteVentesDao besoinEnteteVentesDao;
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
   private ObjetIncoterm incoterms;
   private UtilDate utilDate = new UtilDate();
   private String conditRegtier;
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private transient DataModel datamodelDocumentTrace = new ListDataModel();
   private boolean showModalPanelValidationDocument = false;
   private List mesParcsItems;
   private long var_nom_responsable;
   private long var_nom_contact;
   private double var_total_marge;
   private boolean showModalPanelAnnuler = false;
   private int numLigne;
   private BesoinLigneVentes besoinLigneVentes = new BesoinLigneVentes();
   private BesoinLigneVentesDao besoinLigneVentesDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private String var_depotProd;
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private boolean griserchamps = false;
   private double prixPlancher;
   private boolean griserValider = false;
   private ServiceDao serviceDao;
   private Produits produits;
   private Produits memoProduits;
   private ProduitsVtesDao produitsDao;
   private ProduitsDepot produitsDepot = new ProduitsDepot();
   private ProduitsFournisseurDao produitsFournisseurDao;
   private ProduitsTarifDao produitsTarifdao;
   private ProduitsDepotDao produitsDepotDao;
   private List mesProduitsDepotsItems = new ArrayList();
   private List listeProduitDepot = new ArrayList();
   private TaxesVentesDao taxesVentesDao;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private FamillesProduitsVentes famillesProduitsVentes;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsMclesDao produitsMclesDao;
   private double prixUnitaires;
   private List mesTaxesVentesItems;
   private List mesTaxesVentesProduits = new ArrayList();
   private CalculStock calculStock = new CalculStock();
   private boolean verrou_libelle = false;
   private BaremesDao baremesDao;
   private boolean verifBareme;
   private List mesConditionnementsItems;
   private List mesConditionnementsProduits = new ArrayList();
   private List mesUnitesItems;
   private List mesUnitesProduits = new ArrayList();
   private boolean var_aff_condit = false;
   private boolean var_aff_unite = false;
   private int var_code_unite;
   private Unite unite = new Unite();
   private UniteDao uniteDao;
   private String inpSerie = "100";
   private String inpCat = "100";
   private String inpService = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpClient = "";
   private String inpDestinataire = "";
   private String inpResponsable = "";
   private String inpCommercial = "";
   private String inpActivite = "100";
   private String inpParc = "100";
   private String inpDossier = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean selectDestinataire = false;
   private boolean var_more_search = false;
   private String montant_lettre;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_format_besoine;
   private float var_coef_besoine;
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
   private Habilitation habilitation;
   private DocumentTraceVentesDao documentTraceVentesDao;
   private UtilParapheur utilParapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean accesAffaires = false;
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
   private List documentTrfItems = new ArrayList();
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

   public FormBesoinVentes() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.besoinEnteteVentesDao = new BesoinEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.besoinLigneVentesDao = new BesoinLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifdao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.produitsFournisseurDao = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
      this.documentTraceVentesDao = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes() {
      if (!this.structureLog.getStrtypeentreprise().contentEquals("1") && !this.structureLog.getStrtypeentreprise().contentEquals("3")) {
         this.var_sansstock = true;
      } else {
         this.var_sansstock = false;
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
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrVerRemise() == 0) {
         this.verrouRemise = false;
      } else {
         this.verrouRemise = true;
      }

      if (this.usersLog.getUsrVerRabais() == 0) {
         this.verrouRabais = false;
      } else {
         this.verrouRabais = true;
      }

      if (this.usersLog.getUsrVerPv() == 0) {
         this.verrouPrvente = false;
      } else {
         this.verrouPrvente = true;
      }

      if (this.usersLog.getUsrAffPump() == 0) {
         this.affichagePump = false;
      } else {
         this.affichagePump = true;
      }

      if (this.usersLog.getUsrAffPlancher() == 0) {
         this.affichagePlancher = false;
      } else {
         this.affichagePlancher = true;
      }

      if (this.usersLog.getUsrProdService() == 0) {
         this.accesProduits = false;
      } else {
         this.accesProduits = true;
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
      this.lesLignesList.clear();
      this.lesDecoupagesActivites.clear();
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
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
         this.mesUsersItem.add(new SelectItem(0, ""));

         for(int var3 = 0; var3 < var6.size(); ++var3) {
            Users var4 = (Users)var6.get(var3);
            if (var4.getUsrPatronyme() != null && !var4.getUsrPatronyme().isEmpty()) {
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
            if (var5.getUsrPatronyme() != null && !var5.getUsrPatronyme().isEmpty()) {
               this.mesCommercialItem.add(new SelectItem(var5.getUsrid(), var5.getUsrPatronyme()));
            }
         }
      }

   }

   public void chargerCampagne(Session var1) {
   }

   public void calculeResponsableLie() throws HibernateException, HibernateException, NamingException {
      this.calculeResponsableLie((Session)null);
   }

   public void calculeResponsableLie(Session var1) throws HibernateException, HibernateException, NamingException {
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

                  for(int var5 = 0; var5 < var4.length; ++var5) {
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
         }
      }

   }

   public void moreSearch() throws ParseException {
      this.selectDestinataire = false;
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

      if (this.inpEtat != 50) {
         this.lesEntetesList = this.besoinEnteteVentesDao.recherche(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpClient(), this.getInpEtat(), this.getInpSerie(), this.getInpCat(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpDestinataire(), this.getInpResponsable(), this.getInpCommercial(), this.getInpActivite(), var10, var11);
      }

      if (this.lesEntetesList.size() > 0) {
         new BesoinEnteteVentes();

         for(int var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            BesoinEnteteVentes var12 = (BesoinEnteteVentes)this.lesEntetesList.get(var13);
            var2 += var12.getBesTotTtc();
            var4 += var12.getBesTotReglement();
            var6 += var12.getBesTotHt();
            var8 += var12.getBesTotTva();
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
            this.besoinEnteteVentes = (BesoinEnteteVentes)var1.get(0);
            this.var_date = this.besoinEnteteVentes.getBesDate();
            if (this.besoinEnteteVentes.getBesDate().getHours() <= 9) {
               this.var_heure = "0" + this.besoinEnteteVentes.getBesDate().getHours();
            } else {
               this.var_heure = "" + this.besoinEnteteVentes.getBesDate().getHours();
            }

            if (this.besoinEnteteVentes.getBesDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.besoinEnteteVentes.getBesDate().getMinutes();
            } else {
               this.var_minute = "" + this.besoinEnteteVentes.getBesDate().getMinutes();
            }

            if (this.besoinEnteteVentes.getBesDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.besoinEnteteVentes.getBesDate().getSeconds();
            } else {
               this.var_seconde = "" + this.besoinEnteteVentes.getBesDate().getSeconds();
            }

            if (this.besoinEnteteVentes.getTiers() != null) {
               if (!this.besoinEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.besoinEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.besoinEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.besoinEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
                  this.var_typeTiers = true;
               } else {
                  this.var_typeTiers = false;
               }
            } else {
               this.var_typeTiers = false;
            }

            this.var_nom_contact = this.besoinEnteteVentes.getBesIdContact();
            this.var_nom_responsable = this.besoinEnteteVentes.getBesIdResponsable();
            this.var_nom_commercial = this.besoinEnteteVentes.getBesIdCommercial();
            this.calculDevise();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
            this.chargerDocumentLigne(var4);
            this.chargerBonEncaissement(var4);
            this.chargerDocumentTrace(var4);
            this.chargerUserChrono(var4);
            this.chargerReglement(var4);
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            this.setMontantTtcElmt(this.besoinEnteteVentes.getBesTotTtc());
            this.setMontantReglementElmt(this.besoinEnteteVentes.getBesTotReglement());
            this.setMontantElmTotBonEnc(this.besoinEnteteVentes.getBesTotTtc() - this.var_tot_bon_encaissement);
            this.setMontantSoldeElmt(this.besoinEnteteVentes.getBesTotTtc() - this.besoinEnteteVentes.getBesTotReglement());
            this.cumulPrix();
            this.numLigne = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
            if (this.besoinEnteteVentes.getBesTotTc() != 0.0D) {
               this.var_tc_calcul = true;
            } else {
               this.var_tc_calcul = false;
            }

            this.utilInitHibernate.closeSession();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.besoinEnteteVentes != null) {
         if (this.besoinEnteteVentes.getBesEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void calculDevise() {
      if (this.besoinEnteteVentes.getBesDevise() != null) {
         this.var_format_besoine = this.utilNombre.formatDevise(this.besoinEnteteVentes.getBesDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.besoinEnteteVentes.getBesId() > 0L) {
         this.lesLignesList = this.besoinLigneVentesDao.chargerLesLignes(this.besoinEnteteVentes, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.besoinEnteteVentes.getBesId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement += ((BonEncaissementVente)var2.get(var3)).getBonAPayer();
            }
         }
      }

      this.afficheRecu = false;
      new ArrayList();
      List var5 = this.reglementsDao.reglementDocument(this.besoinEnteteVentes.getBesId(), this.nature, var1);
      if (var5.size() != 0) {
         this.afficheRecu = false;

         for(int var4 = 0; var4 < var5.size(); ++var4) {
            this.var_tot_bon_encaissement += ((Reglements)var5.get(var4)).getRglRecette();
         }
      }

      this.datamodelRecu.setWrappedData(var5);
      if (this.var_tot_bon_encaissement < this.besoinEnteteVentes.getBesTotTtc()) {
         this.var_affiche_dollar = true;
      } else {
         this.var_affiche_dollar = false;
      }

   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
      this.datamodelDocumentTrace = new ListDataModel();
      Object var2 = new ArrayList();
      if (this.besoinEnteteVentes.getBesId() > 0L) {
         var2 = this.documentTraceVentesDao.chargerLesDocumentsTrace(this.besoinEnteteVentes.getBesId(), this.nature, var1);
      }

      this.datamodelDocumentTrace.setWrappedData(var2);
      this.utilInitHibernate.closeSession();
   }

   public void chargerDocumentTrace(Session var1) throws HibernateException, NamingException {
      this.datamodelDocumentTrace = new ListDataModel();
      ArrayList var2 = new ArrayList();
      this.datamodelDocumentTrace.setWrappedData(var2);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.besoinEnteteVentes != null && this.besoinEnteteVentes.getBesSerie() != null && !this.besoinEnteteVentes.getBesSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.besoinEnteteVentes.getBesSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.besoinEnteteVentes.getBesActivite() != null && !this.besoinEnteteVentes.getBesActivite().isEmpty() && this.besoinEnteteVentes.getBesActivite().contains(":")) {
         String[] var1 = null;
         if (!this.besoinEnteteVentes.getBesActivite().contains("#")) {
            var1 = this.besoinEnteteVentes.getBesActivite().split(":");
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
            String[] var2 = this.besoinEnteteVentes.getBesActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.besoinEnteteVentes.getBesTotHt() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.besoinEnteteVentes.getBesTotHt() - this.totalImputation;
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
      this.besoinEnteteVentes = new BesoinEnteteVentes();
      this.besoinEnteteVentes.setUsers(this.usersLog);
      this.besoinEnteteVentes.setBesIdCreateur(this.usersLog.getUsrid());
      this.besoinEnteteVentes.setBesNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.besoinEnteteVentes.setBesIdResponsable(this.usersLog.getUsrid());
      this.besoinEnteteVentes.setBesNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.besoinEnteteVentes.setBesDate(new Date());
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
      this.besoinEnteteVentes.setBesBanque(this.structureLog.getStrBanqueDefaut());
      this.var_nom_responsable = 0L;
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.var_valide_doc = true;
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
      if (this.var_tc_type == 7) {
         this.var_tc_calcul = true;
      } else {
         this.var_tc_calcul = false;
      }

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
      if (this.optionsVentes.getNbrJrRelanceBESOIN() != null && !this.optionsVentes.getNbrJrRelanceBESOIN().isEmpty()) {
         var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceBESOIN());
      } else {
         var3 = 0;
      }

      boolean var2 = false;
      int var4;
      if (this.optionsVentes.getNbrJrValidBESOIN() != null && !this.optionsVentes.getNbrJrValidBESOIN().isEmpty()) {
         var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidBESOIN());
      } else {
         var4 = 0;
      }

      this.besoinEnteteVentes.setBesDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var3));
      this.besoinEnteteVentes.setBesDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var4));
   }

   public void modifDocument() throws JDOMException, IOException {
      if (this.besoinEnteteVentes != null) {
         this.var_action = 1;
         this.var_memo_action = this.var_action;
         this.var_aff_action = false;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         if (this.usersLog.getUsrSignatureVentes() != 1 && this.var_nom_responsable != 0L) {
            this.mesUsersItem.clear();
            this.mesUsersItem.add(new SelectItem(this.besoinEnteteVentes.getBesIdResponsable(), this.besoinEnteteVentes.getBesNomResponsable()));
         }

         this.autorisationDocument();
         this.addLigne();
      }

   }

   public void consultDocument() throws JDOMException, IOException {
      if (this.besoinEnteteVentes != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
         this.selectDestinataire = true;
         this.mesUsersItem.clear();
         this.mesUsersItem.add(new SelectItem(this.besoinEnteteVentes.getBesIdResponsable(), this.besoinEnteteVentes.getBesNomResponsable()));
         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.besoinEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.besoinEnteteVentes.getBesEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.besoinEnteteVentes.setBesEtat(1);
               this.besoinEnteteVentes.setBesDateValide(new Date());
               this.besoinEnteteVentes = this.besoinEnteteVentesDao.modif(this.besoinEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle besoin (C.) N° " + this.besoinEnteteVentes.getBesNum() + " du " + this.utilDate.dateToStringSQLLight(this.besoinEnteteVentes.getBesDate()));
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
      if (this.besoinEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.besoinEnteteVentes.getBesEtat() == 1) {
               this.besoinEnteteVentes.setBesEtat(0);
               this.besoinEnteteVentes.setBesDateValide((Date)null);
               this.besoinEnteteVentes = this.besoinEnteteVentesDao.modif(this.besoinEnteteVentes, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle besoin (C.) N° " + this.besoinEnteteVentes.getBesNum() + " du " + this.utilDate.dateToStringSQLLight(this.besoinEnteteVentes.getBesDate()));
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
      if (this.besoinEnteteVentes != null) {
         this.besoinEnteteVentes.setBesEtat(0);
         this.besoinEnteteVentes.setBesDateAnnule((Date)null);
         this.besoinEnteteVentes.setBesMotifAnnule("");
         this.besoinEnteteVentes = this.besoinEnteteVentesDao.modif(this.besoinEnteteVentes);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.besoinEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.besoinEnteteVentes.getBesNum();
            Date var4 = this.besoinEnteteVentes.getBesDate();
            new DocumentTraceVentes();
            DocumentTraceVentes var5 = this.documentTraceVentesDao.chercherDestinationTrace(this.besoinEnteteVentes.getBesId(), this.nature, var1);
            if (var5 != null) {
               long var6 = var5.getDoctraOrgId();
               this.documentTraceVentesDao.delete(var5, var1);
            }

            this.lesEntetesList.remove(this.besoinEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.besoinLigneVentesDao.deleteAllLigne(this.besoinEnteteVentes, var1);
            this.utilParapheur.supprimerParapheur(this.besoinEnteteVentes.getBesId(), this.nature, var1);
            this.besoinEnteteVentesDao.delete(this.besoinEnteteVentes.getBesId(), var1);
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression Besoin N° " + var3 + " du " + var4);
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

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void duppliquerDocument() throws HibernateException, NamingException, Exception {
      if (this.besoinEnteteVentes.getBesId() >= 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
         this.chargerDocumentLigne(var1);
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            ArrayList var3 = new ArrayList();
            this.besoinEnteteVentes.setUsers(this.usersLog);
            this.besoinEnteteVentes.setBesIdCreateur(this.usersLog.getUsrid());
            this.besoinEnteteVentes.setBesNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.besoinEnteteVentes.setBesDate(new Date());
            this.besoinEnteteVentes.setBesDateCreat(new Date());
            this.besoinEnteteVentes.setBesDateModif((Date)null);
            this.besoinEnteteVentes.setBesIdModif(0L);
            this.besoinEnteteVentes.setBesNomModif("");
            this.besoinEnteteVentes.setBesNum("");
            this.besoinEnteteVentes.setBesIdResponsable(this.usersLog.getUsrid());
            this.besoinEnteteVentes.setBesNomResponsable(this.usersLog.getUsrPatronyme());
            boolean var4 = false;
            int var13;
            if (this.optionsVentes.getNbrJrRelanceDEVIS() != null && !this.optionsVentes.getNbrJrRelanceDEVIS().isEmpty()) {
               var13 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceDEVIS());
            } else {
               var13 = 0;
            }

            boolean var5 = false;
            int var14;
            if (this.optionsVentes.getNbrJrValidDEVIS() != null && !this.optionsVentes.getNbrJrValidDEVIS().isEmpty()) {
               var14 = Integer.parseInt(this.optionsVentes.getNbrJrValidDEVIS());
            } else {
               var14 = 0;
            }

            this.besoinEnteteVentes.setBesDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var13));
            this.besoinEnteteVentes.setBesDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var14));
            if (!this.besoinEnteteVentes.getBesSerie().equalsIgnoreCase("X") && !this.besoinEnteteVentes.getBesSerie().isEmpty()) {
               this.besoinEnteteVentes.setBesNum(this.calculChrono.numCompose(this.besoinEnteteVentes.getBesDate(), this.nature, this.besoinEnteteVentes.getBesSerie(), var1));
            } else {
               long var6 = this.besoinEnteteVentesDao.selectLastNum(var1);
               this.besoinEnteteVentes.setBesNum("" + var6);
            }

            this.verifieExistenceHabilitation(var1);
            this.besoinEnteteVentes.setBesDateAnnule((Date)null);
            this.besoinEnteteVentes.setBesMotifAnnule("");
            this.besoinEnteteVentes.setBesDateImp((Date)null);
            this.besoinEnteteVentes.setBesDateTransforme((Date)null);
            this.besoinEnteteVentes.setBesEtat(0);
            var3.add(this.besoinEnteteVentes);
            this.besoinEnteteVentes = this.besoinEnteteVentesDao.insert((BesoinEnteteVentes)var3.get(0), var1);
            if (this.lesLignesList.size() != 0) {
               this.besoinLigneVentesDao.duppliquerLigne(this.lesLignesList, this.besoinEnteteVentes, var1);
            }

            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (this.habilitation != null) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.besoinEnteteVentes.getBesId(), this.besoinEnteteVentes.getBesNum(), this.besoinEnteteVentes.getBesNomTiers(), this.besoinEnteteVentes.getBesDate(), this.besoinEnteteVentes.getBesDevise(), this.besoinEnteteVentes.getBesTotTtc() + this.besoinEnteteVentes.getBesTotTc(), this.besoinEnteteVentes.getBesModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.besoinEnteteVentes.getVar_format_devise(), 0, (Session)null);
         }

         this.chargeListeDetail((Session)null);
      }

   }

   public void transformerDocument() throws HibernateException, NamingException {
      this.documentDetailTrf.clear();
      this.lesLignesList.clear();
      this.var_date_trf = null;
      this.var_type_trf = 0;
      this.var_mode_trf = "";
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEntete");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         if (this.besoinEnteteVentes.getBesTypeTransforme() != 0) {
            var3 = this.usersChronoDao.existByUserNat(this.usersLog, this.besoinEnteteVentes.getBesTypeTransforme(), var1);
            if (var3) {
               String var4 = "";
               if (this.besoinEnteteVentes.getBesTypeTransforme() == 28) {
                  var4 = "Chargement";
               }

               this.documentTrfItems.add(new SelectItem(this.besoinEnteteVentes.getBesTypeTransforme(), var4));
            }
         } else {
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, 28, var1);
            if (var2) {
               this.documentTrfItems.add(new SelectItem(28, "Chargement"));
            }
         }

         for(int var8 = 0; var8 < this.lesEntetesList.size(); ++var8) {
            new BesoinEnteteVentes();
            BesoinEnteteVentes var5 = (BesoinEnteteVentes)this.lesEntetesList.get(var8);
            if (var5.getBesId() > 0L && var5.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.besoinLigneVentesDao.chargerLesLignes(var5, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                     new BesoinLigneVentes();
                     BesoinLigneVentes var7 = (BesoinLigneVentes)this.lesLignesList.get(var6);
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

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      if (this.besoinEnteteVentes.getBesTypeReg() == 0 || this.besoinEnteteVentes.getBesTypeReg() == 3) {
         this.besoinEnteteVentes.setBesNbJourReg(0);
         this.besoinEnteteVentes.setBesArrondiReg(0);
      }

      if (this.besoinEnteteVentes.getBesTypeReg() != 1 && this.besoinEnteteVentes.getBesTypeReg() != 2) {
         this.visibiliteterme = false;
      } else {
         this.visibiliteterme = true;
         this.visibilitenbrjr = true;
         this.visibiliteencaissemt = false;
      }

      if (this.besoinEnteteVentes.getBesTypeReg() == 4) {
         this.visibiliteencaissemt = true;
         this.visibilitenbrjr = true;
      } else {
         this.visibiliteencaissemt = false;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.besoinEnteteVentes.getBesDate(), this.besoinEnteteVentes.getBesTypeReg(), this.besoinEnteteVentes.getBesNbJourReg(), this.besoinEnteteVentes.getBesArrondiReg());
      this.besoinEnteteVentes.setBesDateEcheReg(var1);
   }

   public void chargerReglement(Session var1) {
      if ("Factor".equalsIgnoreCase(this.besoinEnteteVentes.getBesModeReg())) {
         this.visibilitefactor = true;
      } else {
         this.visibilitefactor = false;
      }

   }

   public void chargerReglement() {
      if ("Factor".equalsIgnoreCase(this.besoinEnteteVentes.getBesModeReg())) {
         this.visibilitefactor = true;
      } else {
         this.visibilitefactor = false;
      }

   }

   public void preSave() throws IOException, HibernateException, NamingException, Exception {
      if (this.besoinEnteteVentes.getBesId() != 0L) {
         this.showModalPanelValidationDocument = true;
      } else {
         this.save();
      }

   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.besoinEnteteVentes.setBesDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.calculDateValidite();
         if (this.besoinEnteteVentes.getUsers() == null) {
            this.besoinEnteteVentes.setUsers(this.usersLog);
         }

         this.besoinEnteteVentes.setTiers((Tiers)null);
         if (this.besoinEnteteVentes.getTiers() == null) {
            this.besoinEnteteVentes.setBesNomTiers("");
            this.besoinEnteteVentes.setBesCivilTiers("");
         } else {
            if ((this.besoinEnteteVentes.getBesCat() == null || this.besoinEnteteVentes.getBesCat().isEmpty()) && this.besoinEnteteVentes.getTiers().getTienomfamille() != null && !this.besoinEnteteVentes.getTiers().getTienomfamille().isEmpty()) {
               this.besoinEnteteVentes.setBesCat(this.besoinEnteteVentes.getTiers().getTienomfamille());
            }

            if (!this.besoinEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.besoinEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.besoinEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.besoinEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.besoinEnteteVentes.setBesCivilTiers("");
            } else {
               this.besoinEnteteVentes.setBesCivilTiers(this.besoinEnteteVentes.getTiers().getTiecivilite());
            }
         }

         this.besoinEnteteVentes.setBesIdContact(0L);
         this.besoinEnteteVentes.setBesNomContact("");
         this.besoinEnteteVentes.setBesCivilContact("");
         this.besoinEnteteVentes.setBesIdResponsable(0L);
         this.besoinEnteteVentes.setBesNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var3 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var3 != null) {
            this.besoinEnteteVentes.setBesIdResponsable(var3.getUsrid());
            this.besoinEnteteVentes.setBesNomResponsable(var3.getUsrPatronyme());
         }

         this.besoinEnteteVentes.setBesIdCommercial(0L);
         this.besoinEnteteVentes.setBesNomCommercial("");
         if (this.optionsVentes.getResponsable().equals("1") || this.optionsVentes.getResponsable().equals("2")) {
            new Users();
            if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
               this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
            }

            Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
            if (var4 != null) {
               this.besoinEnteteVentes.setBesIdCommercial(var4.getUsrid());
               this.besoinEnteteVentes.setBesNomCommercial(var4.getUsrPatronyme());
            }
         }

         this.besoinEnteteVentes.setBesIdEquipe(0L);
         this.besoinEnteteVentes.setBesNomEquipe("");
         if (this.optionsVentes.getResponsable().equals("1")) {
            this.equipes = this.equipesDao.rechercheEquipes(this.besoinEnteteVentes.getBesIdResponsable(), var1);
            if (this.equipes != null) {
               this.besoinEnteteVentes.setBesIdEquipe(this.equipes.getEquId());
               this.besoinEnteteVentes.setBesNomEquipe(this.equipes.getEquNomFr());
            }
         }

         if (this.besoinEnteteVentes.getBesId() != 0L) {
            this.besoinEnteteVentes.setBesDateModif(new Date());
            this.besoinEnteteVentes.setBesIdModif(this.usersLog.getUsrid());
            this.besoinEnteteVentes.setBesNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.besoinEnteteVentes = this.besoinEnteteVentesDao.modif(this.besoinEnteteVentes, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.showModalPanelValidationDocument = false;
         } else {
            this.besoinEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.besoinEnteteVentes.setBesDateCreat(new Date());
            this.besoinEnteteVentes.setBesIdCreateur(this.usersLog.getUsrid());
            this.besoinEnteteVentes.setBesNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (!this.besoinEnteteVentes.getBesSerie().equalsIgnoreCase("X") && !this.besoinEnteteVentes.getBesSerie().isEmpty()) {
               this.besoinEnteteVentes.setBesNum(this.calculChrono.numCompose(this.besoinEnteteVentes.getBesDate(), this.nature, this.besoinEnteteVentes.getBesSerie(), var1));
               boolean var16 = false;

               label261:
               while(true) {
                  while(true) {
                     if (var16) {
                        break label261;
                     }

                     new BesoinEnteteVentes();
                     BesoinEnteteVentes var5 = this.besoinEnteteVentesDao.pourParapheurByNum(this.besoinEnteteVentes.getBesNum(), this.besoinEnteteVentes.getBesSerie(), var1);
                     if (var5 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.besoinEnteteVentes.setBesNum(this.calculChrono.numCompose(this.besoinEnteteVentes.getBesDate(), this.nature, this.besoinEnteteVentes.getBesSerie(), var1));
                        var16 = false;
                     } else {
                        var16 = true;
                     }
                  }
               }
            } else {
               long var15 = this.besoinEnteteVentesDao.selectLastNum(var1);
               this.besoinEnteteVentes.setBesNum("" + var15);
            }

            this.besoinEnteteVentes.setBesEtat(0);
            this.besoinEnteteVentes.setBesEtatVal(0);
            this.besoinEnteteVentes.setBesDateValide((Date)null);
            this.besoinEnteteVentes = this.besoinEnteteVentesDao.insert(this.besoinEnteteVentes, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.besoinEnteteVentes);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.besoinEnteteVentes.getBesId(), this.besoinEnteteVentes.getBesNum(), this.besoinEnteteVentes.getBesNomTiers(), this.besoinEnteteVentes.getBesDate(), this.besoinEnteteVentes.getBesDevise(), this.besoinEnteteVentes.getBesTotTtc() + this.besoinEnteteVentes.getBesTotTc(), this.besoinEnteteVentes.getBesModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.besoinEnteteVentes.getVar_format_devise(), 0, var1);
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
      this.besoinEnteteVentes.setBesSite(this.usersLog.getUsrSite());
      this.besoinEnteteVentes.setBesDepartement(this.usersLog.getUsrDepartement());
      this.besoinEnteteVentes.setBesService(this.usersLog.getUsrService());
      this.besoinEnteteVentes.setBesRegion("");
      this.besoinEnteteVentes.setBesSecteur("");
      this.besoinEnteteVentes.setBesPdv("");
      if (!this.var_anal_activite) {
         this.besoinEnteteVentes.setBesActivite("");
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

               this.besoinEnteteVentes.setBesActivite(var2);
            }
         } else {
            var2 = "";
            var3 = true;
            new BesoinLigneVentes();
            new Produits();
            if ((this.decoupageActivite || !this.decoupageActivite) && this.lesLignesList.size() != 0) {
               ArrayList var6 = new ArrayList();
               ObjetTarif var7 = new ObjetTarif();
               int var8 = 0;

               label118:
               while(true) {
                  if (var8 >= this.lesLignesList.size()) {
                     var8 = 0;

                     while(true) {
                        if (var8 >= var6.size()) {
                           break label118;
                        }

                        var7 = (ObjetTarif)var6.get(var8);
                        if (var3) {
                           var2 = var7.getNomLibelle() + ":" + var7.getPrix();
                           var3 = false;
                        } else {
                           var2 = var2 + "#" + var7.getNomLibelle() + ":" + var7.getPrix();
                        }

                        ++var8;
                     }
                  }

                  BesoinLigneVentes var13 = (BesoinLigneVentes)this.lesLignesList.get(var8);
                  if (var13.getBesligCode() != null && !var13.getBesligCode().isEmpty()) {
                     Produits var5 = this.produitsDao.chargeProduit(var13.getBesligCode(), var1);
                     if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                        if (var6.size() == 0) {
                           var7 = new ObjetTarif();
                           var7.setNomLibelle(var5.getProActivite());
                           var7.setPrix(var13.getBesligPt());
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
                              var7.setPrix(var13.getBesligPt());
                              var6.add(var7);
                           } else if (var9 && var7 != null) {
                              var7.setPrix(var10 + var13.getBesligPt());
                              var6.remove(var7);
                              var6.add(var7);
                           }
                        }
                     }
                  }

                  ++var8;
               }
            }

            this.besoinEnteteVentes.setBesActivite(var2);
         }
      }

      if (!this.var_anal_dossier && !this.accesAffaires) {
         this.besoinEnteteVentes.setBesAnal4("");
      } else if ((this.var_anal_dossier || this.accesAffaires) && this.besoinEnteteVentes.getBesAnal4() != null && this.besoinEnteteVentes.getBesAnal4().length() <= 2) {
         this.besoinEnteteVentes.setBesAnal4("");
      }

      if (!this.var_anal_parc) {
         this.besoinEnteteVentes.setBesAnal2("");
      } else if (this.besoinEnteteVentes.getBesAnal2() != null && this.besoinEnteteVentes.getBesAnal2().length() <= 2) {
         this.besoinEnteteVentes.setBesAnal2("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.besoinEnteteVentes.setBesEtatVal(1);
         this.besoinEnteteVentes.setBesEtat(0);
         this.besoinEnteteVentes.setBesDateValide((Date)null);
         return true;
      } else {
         this.besoinEnteteVentes.setBesEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.besoinEnteteVentes.setBesEtat(1);
               this.besoinEnteteVentes.setBesDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.besoinEnteteVentes.setBesEtat(0);
               this.besoinEnteteVentes.setBesDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.besoinEnteteVentes != null) {
         this.besoinEnteteVentes.setBesDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.besoinEnteteVentes != null) {
         if (this.besoinEnteteVentes.getBesDateAnnule() == null) {
            this.besoinEnteteVentes.setBesDateAnnule(new Date());
         }

         this.besoinEnteteVentes.setBesEtat(3);
         this.besoinEnteteVentes = this.besoinEnteteVentesDao.modif(this.besoinEnteteVentes);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation besoin vente N° " + this.besoinEnteteVentes.getBesNum() + " le " + this.besoinEnteteVentes.getBesDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.besoinEnteteVentes);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.besoinEnteteVentes.getBesExoTva() == 0) {
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

         if (this.produits != null && this.produits.isProExoTva()) {
            var5 = 0.0F;
            var6 = "";
            var7 = 0;
         }
      }

      this.besoinLigneVentes.setBesligTaxe(var6);
      this.besoinLigneVentes.setBesligTauxTaxe(var5);
      double var35 = this.besoinLigneVentes.getBesligPu();
      float var10;
      if (var7 == 3) {
         var10 = 100.0F - var5;
         var35 = this.utilNombre.myRoundDevise(var35 / (double)var10 * 100.0D, this.besoinEnteteVentes.getBesDevise());
      }

      var10 = this.besoinLigneVentes.getBesligQte();
      if (this.besoinLigneVentes.getBesligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.besoinLigneVentes.setBesligQteUtil(this.besoinLigneVentes.getBesligQte() * this.besoinLigneVentes.getBesligLong());
            var10 = this.besoinLigneVentes.getBesligQte() * this.besoinLigneVentes.getBesligLong();
         } else {
            this.besoinLigneVentes.setBesligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.besoinLigneVentes.getBesligCondition(), this.besoinLigneVentes.getBesligQte(), this.besoinLigneVentes.getBesligLong(), this.besoinLigneVentes.getBesligLarg(), this.besoinLigneVentes.getBesligHaut(), this.besoinLigneVentes.getBesligDiam(), this.besoinLigneVentes.getBesligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.besoinLigneVentes.setBesligQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.besoinLigneVentes.getBesligCondition() != null && !this.besoinLigneVentes.getBesligCondition().isEmpty() && this.besoinLigneVentes.getBesligCondition().contains(":")) {
         var11 = var35 * (double)this.besoinLigneVentes.getBesligQte();
      } else {
         var11 = var35 * (double)this.besoinLigneVentes.getBesligQte();
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = this.besoinLigneVentes.getBesligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = this.besoinLigneVentes.getBesligRabais() * (double)this.besoinLigneVentes.getBesligQte();
      }

      if (this.besoinLigneVentes.getBesligTauxRemise() != 0.0F) {
         var13 = var11 - var11 * (double)this.besoinLigneVentes.getBesligTauxRemise() / 100.0D - var15;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_besoine);
      double var19 = var17 * (double)this.besoinLigneVentes.getBesligTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var19 *= -1.0D;
      } else if (var7 == 3) {
         var19 = var17 * (double)(this.besoinLigneVentes.getBesligTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_besoine);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      if (this.besoinLigneVentes.getBesligCondition() != null && !this.besoinLigneVentes.getBesligCondition().isEmpty() && this.besoinLigneVentes.getBesligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var25 = this.utilNombre.myRound(var17 / (double)this.besoinLigneVentes.getBesligQteUtil(), 2);
         } else {
            var25 = this.utilNombre.myRound(var17 / (double)this.besoinLigneVentes.getBesligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var25 = this.utilNombre.myRound(var17 / (double)this.besoinLigneVentes.getBesligQteUtil(), 2);
      } else {
         var25 = this.utilNombre.myRound(var17 / (double)this.besoinLigneVentes.getBesligQte(), 2);
      }

      this.besoinLigneVentes.setBesligPuRem(var25);
      this.besoinLigneVentes.setBesligPt(var17);
      this.besoinLigneVentes.setBesligTva(var21);
      this.besoinLigneVentes.setBesligTc(0.0D);
      this.besoinLigneVentes.setBesligTtc(var23);
      double var27 = 0.0D;
      if (this.besoinLigneVentes.getBesligCondition() != null && !this.besoinLigneVentes.getBesligCondition().isEmpty() && this.besoinLigneVentes.getBesligCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var27 = this.utilNombre.myRound(var23 / (double)this.besoinLigneVentes.getBesligQteUtil(), 2);
         } else {
            var27 = this.utilNombre.myRound(var23 / (double)this.besoinLigneVentes.getBesligQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.besoinLigneVentes.getBesligQteUtil(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.besoinLigneVentes.getBesligQte(), 2);
      }

      this.besoinLigneVentes.setBesligPuRemTtc(var27);
      double var29 = var35 + var35 * (double)this.besoinLigneVentes.getBesligTauxTaxe() / 100.0D;
      this.besoinLigneVentes.setBesligPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.besoinEnteteVentes.setBesTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.besoinEnteteVentes.getBesTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundDevise(var31, this.structureLog.getStrdevise());
            this.besoinLigneVentes.setBesligTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = var17 * (double)this.besoinEnteteVentes.getBesTauxTc() / 100.0D;
               if (this.besoinLigneVentes.getBesligTauxTaxe() != 0.0F) {
                  var31 = var17 * (double)this.besoinEnteteVentes.getBesTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundDevise(var31, this.structureLog.getStrdevise());
                  double var10000 = var31 + var31 * (double)this.besoinLigneVentes.getBesligTauxTaxe() / 100.0D;
                  this.besoinLigneVentes.setBesligTc(var33);
                  this.besoinLigneVentes.setBesligTtc(this.besoinLigneVentes.getBesligPt() + this.besoinLigneVentes.getBesligTva() + this.besoinLigneVentes.getBesligTc());
               }
            }
         } else {
            var31 = var17 * (double)this.besoinEnteteVentes.getBesTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundDevise(var31, this.structureLog.getStrdevise());
            this.besoinLigneVentes.setBesligTc(var33);
            this.besoinLigneVentes.setBesligTtc(this.besoinLigneVentes.getBesligPt() + this.besoinLigneVentes.getBesligTva() + this.besoinLigneVentes.getBesligTc());
         }
      } else {
         this.besoinLigneVentes.setBesligTc(0.0D);
         this.besoinEnteteVentes.setBesTauxTc(0.0F);
      }

      this.besoinLigneVentes.setBesligPt(this.utilNombre.myRoundDevise(this.besoinLigneVentes.getBesligPt(), this.besoinEnteteVentes.getBesDevise()));
      this.besoinLigneVentes.setBesligTva(this.utilNombre.myRoundDevise(this.besoinLigneVentes.getBesligTva(), this.besoinEnteteVentes.getBesDevise()));
      this.besoinLigneVentes.setBesligTtc(this.utilNombre.myRoundDevise(this.besoinLigneVentes.getBesligTtc(), this.besoinEnteteVentes.getBesDevise()));
      this.besoinLigneVentes.setBesligTc(this.utilNombre.myRoundDevise(this.besoinLigneVentes.getBesligTc(), this.besoinEnteteVentes.getBesDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.besoinEnteteVentes.getBesExoTva() == 0) {
         TaxesVentes var8;
         int var38;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var38 = var8.getTaxvteType();
            } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               TaxesVentes var9 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
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
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
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

         if (this.produits != null && this.produits.isProExoTva()) {
            var5 = 0.0F;
            var6 = "";
            var7 = false;
         }
      }

      this.besoinLigneVentes.setBesligTaxe(var6);
      this.besoinLigneVentes.setBesligTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.besoinEnteteVentes.getBesTauxTc() != 0.0F) {
         var10 = this.besoinLigneVentes.getBesligPuTtc() * (double)this.besoinLigneVentes.getBesligQte();
         var12 = var10 * (double)this.besoinEnteteVentes.getBesTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.besoinLigneVentes.getBesligQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.besoinLigneVentes.getBesligPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.besoinLigneVentes.setBesligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = this.besoinLigneVentes.getBesligRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = this.besoinLigneVentes.getBesligRabais() * (double)this.besoinLigneVentes.getBesligQte();
      }

      double var14 = 0.0D;
      if (this.besoinLigneVentes.getBesligTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.besoinLigneVentes.getBesligTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.besoinLigneVentes.getBesligTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.besoinLigneVentes.getBesligTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.besoinLigneVentes.getBesligQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.besoinLigneVentes.setBesligQteUtil(this.besoinLigneVentes.getBesligQte() * this.besoinLigneVentes.getBesligLong());
         } else {
            this.besoinLigneVentes.setBesligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.besoinLigneVentes.getBesligCondition(), this.besoinLigneVentes.getBesligQte(), this.besoinLigneVentes.getBesligLong(), this.besoinLigneVentes.getBesligLarg(), this.besoinLigneVentes.getBesligHaut(), this.besoinLigneVentes.getBesligDiam(), this.besoinLigneVentes.getBesligNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.besoinLigneVentes.setBesligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.besoinLigneVentes.getBesligQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.besoinEnteteVentes.getBesDevise()));
      double var26 = var20 * (double)this.besoinLigneVentes.getBesligQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.besoinEnteteVentes.getBesDevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.besoinEnteteVentes.getBesDevise()));
      this.besoinLigneVentes.setBesligPuRem(var18);
      this.besoinLigneVentes.setBesligPuRemTtc(var20);
      this.besoinLigneVentes.setBesligPt(var24);
      this.besoinLigneVentes.setBesligTva(var32);
      this.besoinLigneVentes.setBesligTtc(var28);
      if (this.besoinEnteteVentes.getBesTauxTc() != 0.0F) {
         double var34 = var28 * (double)this.besoinEnteteVentes.getBesTauxTc() / 100.0D;
         double var36 = this.utilNombre.myRoundFormat(var34, this.var_format_besoine);
         this.besoinLigneVentes.setBesligTc(var36);
      } else {
         this.besoinLigneVentes.setBesligTc(0.0D);
      }

      this.besoinLigneVentes.setBesligPt(this.utilNombre.myRoundDevise(this.besoinLigneVentes.getBesligPt(), this.besoinEnteteVentes.getBesDevise()));
      this.besoinLigneVentes.setBesligTva(this.utilNombre.myRoundDevise(this.besoinLigneVentes.getBesligTva(), this.besoinEnteteVentes.getBesDevise()));
      this.besoinLigneVentes.setBesligTtc(this.utilNombre.myRoundDevise(this.besoinLigneVentes.getBesligTtc(), this.besoinEnteteVentes.getBesDevise()));
      this.besoinLigneVentes.setBesligTc(this.utilNombre.myRoundDevise(this.besoinLigneVentes.getBesligTc(), this.besoinEnteteVentes.getBesDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      if (this.besoinLigneVentes != null && this.besoinLigneVentes.getBesligCode() != null && !this.besoinLigneVentes.getBesligCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.besoinLigneVentes.getBesligTaxe(), this.besoinLigneVentes.getBesligTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            if (this.besoinLigneVentes.getBesligPuRemTtc() != 0.0D) {
               if (this.besoinLigneVentes.getBesligPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.besoinLigneVentes.getBesligPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.besoinLigneVentes.getBesligPuRem() != 0.0D) {
            if (this.besoinLigneVentes.getBesligPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.besoinLigneVentes.getBesligPu() < this.prixPlancher) {
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
      new BesoinLigneVentes();

      for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
         BesoinLigneVentes var13 = (BesoinLigneVentes)this.lesLignesList.get(var14);
         if (var13.getBesligGroupe() == null || var13.getBesligGroupe().isEmpty()) {
            var3 += var13.getBesligPt();
            var5 += var13.getBesligTva();
            var7 += var13.getBesligTtc();
            var9 += var13.getBesligTc();
            if (var13.getBesligRabais() != 0.0D || var13.getBesligTauxRemise() != 0.0F) {
               var11 += var13.getBesligPu() * (double)var13.getBesligQte() - var13.getBesligPt();
            }

            var1 = var1 + var13.getBesligPt() - var13.getBesligPump() * (double)var13.getBesligQte();
         }
      }

      this.var_total_marge = var1;
      this.besoinEnteteVentes.setBesTotHt(var3);
      this.besoinEnteteVentes.setBesTotTva(var5);
      this.besoinEnteteVentes.setBesTotTtc(var7);
      this.besoinEnteteVentes.setBesTotRemise(var11);
      this.besoinEnteteVentes.setBesTotTc(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesVentesProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.memoProduits = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.besoinLigneVentes = (BesoinLigneVentes)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinLigne");
         if (this.besoinLigneVentes.getBesligCode() != null && this.besoinLigneVentes.getBesligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeProduit(this.besoinLigneVentes.getBesligCode(), var1);
            if (this.produits != null) {
               this.memoProduits = this.produits;
               this.besoinLigneVentes.setBesligCode(this.produits.getProCode());
               this.besoinLigneVentes.setBesligFamille(this.produits.getProAchCode());
               this.besoinLigneVentes.setBesligStock(this.produits.getProStock());
               this.besoinLigneVentes.setBesligLong(this.produits.getProLongueur());
               this.besoinLigneVentes.setBesligLarg(this.produits.getProLargeur());
               this.besoinLigneVentes.setBesligHaut(this.produits.getProEpaisseur());
               this.besoinLigneVentes.setBesligDiam(this.produits.getProDiamExt());
               this.besoinLigneVentes.setBesligPoidsBrut(this.produits.getProPoidsBrut());
               this.besoinLigneVentes.setBesligPoidsNet(this.produits.getProPoidsNet());
               this.besoinLigneVentes.setBesligVolume(this.produits.getProVolume());
               this.besoinLigneVentes.setBesligNb(this.produits.getProNbUnite());
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

               this.griserchamps = true;
               if (this.besoinLigneVentes.getBesligTaxe() != null && !this.besoinLigneVentes.getBesligTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.besoinLigneVentes.getBesligTaxe(), this.besoinLigneVentes.getBesligTaxe() + ":" + this.besoinLigneVentes.getBesligTauxTaxe()));
               } else {
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }

               this.mefConditionnementDepot(var1);
               this.selectionDepot(var1);
               new FamillesProduitsVentes();
               FamillesProduitsVentes var4 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExoVentes.getExevteId(), this.produits, var1);
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

   public int clauleNumlLigne() {
      int var1 = 0;
      if (this.lesLignesList.size() != 0) {
         for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            if (this.besoinLigneVentes.getBesligId() == ((BesoinLigneVentes)this.lesLignesList.get(var2)).getBesligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void addLigne() {
      this.produits = new Produits();
      this.memoProduits = new Produits();
      this.besoinLigneVentes = new BesoinLigneVentes();
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

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.besoinLigneVentes.getBesligCode() != null && !this.besoinLigneVentes.getBesligCode().isEmpty() || this.besoinLigneVentes.getBesligLibelle() != null && !this.besoinLigneVentes.getBesligLibelle().isEmpty()) {
         if (this.besoinEnteteVentes.getBesId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.besoinLigneVentes.getBesligQteUtil() == 0.0F) {
               this.besoinLigneVentes.setBesligQteUtil(this.besoinLigneVentes.getBesligQte());
            }

            this.calculPrix(this.besoinLigneVentes.getBesligTaxe(), this.besoinLigneVentes.getBesligTauxTaxe(), var1);
            if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
               String[] var3;
               if (this.var_depotProd.contains(":")) {
                  var3 = this.var_depotProd.split(":");
                  this.besoinLigneVentes.setBesligDepot(var3[0]);
               } else {
                  var3 = this.var_depotProd.split("=");
                  this.besoinLigneVentes.setBesligDepot(var3[0]);
               }
            } else {
               this.besoinLigneVentes.setBesligDepot("");
            }

            if (this.besoinLigneVentes.getBesligCondition() != null && !this.besoinLigneVentes.getBesligCondition().isEmpty() && this.besoinLigneVentes.getBesligCondition().contains(":")) {
               ConditionnementDao var15 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
               String[] var4 = this.besoinLigneVentes.getBesligCondition().split(":");
               String var5 = var15.rechercheConditionnement(var4[0], var1).getCdtDescription();
               if (var5 != null && !var5.isEmpty()) {
                  this.besoinLigneVentes.setBesligDescription(var5);
               } else {
                  this.besoinLigneVentes.setBesligDescription("");
               }
            } else {
               this.besoinLigneVentes.setBesligDescription("");
            }

            if (this.besoinLigneVentes.getBesligId() == 0L) {
               this.besoinLigneVentes.setBesoinEnteteVentes(this.besoinEnteteVentes);
               this.besoinLigneVentes.setBesligDevise(this.besoinEnteteVentes.getBesDevise());
               this.besoinLigneVentes = this.besoinLigneVentesDao.insertLigne(this.besoinLigneVentes, var1);
               if (this.numLigne == 0) {
                  if (this.lesLignesList.size() != 0) {
                     this.numLigne = this.lesLignesList.size();
                  } else {
                     this.numLigne = 0;
                  }
               }

               this.lesLignesList.add(this.numLigne, this.besoinLigneVentes);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
               this.numLigne = this.datamodelLigne.getRowCount() + 1;
            } else {
               this.besoinLigneVentes = this.besoinLigneVentesDao.modifLigne(this.besoinLigneVentes, var1);
            }

            if (this.memoProduits != null && this.memoProduits != this.produits && this.memoProduits.getProVteNat() != null && !this.memoProduits.getProVteNat().isEmpty() && !this.memoProduits.getProVteNat().equals("1604") && !this.memoProduits.getProVteNat().equals("1612") && this.besoinLigneVentes.getBesligCode() != null && !this.besoinLigneVentes.getBesligCode().isEmpty() && (this.memoProduits.getProMode() == 1 || this.memoProduits.getProMode() == 2)) {
               new BesoinLigneVentes();

               for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
                  BesoinLigneVentes var16 = (BesoinLigneVentes)this.lesLignesList.get(var17);
                  if (var16.getBesligGroupe() != null && !var16.getBesligGroupe().isEmpty() && var16.getBesligGroupe().equals(this.memoProduits.getProCode())) {
                     this.besoinLigneVentesDao.deleteOneLigne(var16, var1);
                     this.lesLignesList.remove(var16);
                     --var17;
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            if (this.produits != null && this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1612") && this.besoinLigneVentes.getBesligCode() != null && !this.besoinLigneVentes.getBesligCode().isEmpty() && (this.produits.getProMode() == 1 || this.produits.getProMode() == 2)) {
               String var18 = this.produits.getProCode();
               float var20 = this.besoinLigneVentes.getBesligQte();
               new BesoinLigneVentes();

               BesoinLigneVentes var19;
               for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                  var19 = (BesoinLigneVentes)this.lesLignesList.get(var6);
                  if (var19.getBesligGroupe() != null && !var19.getBesligGroupe().isEmpty() && var19.getBesligGroupe().equals(var18)) {
                     this.besoinLigneVentesDao.deleteOneLigne(var19, var1);
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
                     var19 = new BesoinLigneVentes();
                     var19.setBesligCode(((ProduitsGrp)var21.get(var8)).getProgrpCode());
                     var19.setBesligCondition("");
                     var19.setBesligDepot(((ProduitsGrp)var21.get(var8)).getProgrpDepot());
                     var19.setBesligDescription("");
                     var19.setBesligDevise(this.besoinEnteteVentes.getBesDevise());
                     var19.setBesligDiam(((ProduitsGrp)var21.get(var8)).getProduits().getProDiamInt());
                     var19.setBesligEchelle(0);
                     var19.setBesligFamille(((ProduitsGrp)var21.get(var8)).getProduits().getProVteCode());
                     var19.setBesligGroupe(var18);
                     var19.setBesligHaut(((ProduitsGrp)var21.get(var8)).getProduits().getProEpaisseur());
                     var19.setBesligLarg(((ProduitsGrp)var21.get(var8)).getProduits().getProLargeur());
                     var19.setBesligLibelle(((ProduitsGrp)var21.get(var8)).getProgrpLibelle());
                     var19.setBesligLong(((ProduitsGrp)var21.get(var8)).getProduits().getProLongueur());
                     var19.setBesligModeGroupe(((ProduitsGrp)var21.get(var8)).getProduits().getProMode());
                     var19.setBesligNb(((ProduitsGrp)var21.get(var8)).getProduits().getProNbUnite());
                     var19.setBesligPoidsBrut(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsBrut());
                     var19.setBesligPoidsNet(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsNet());
                     var19.setBesligPt(0.0D);
                     var19.setBesligPu(0.0D);
                     var19.setBesligPuRem(0.0D);
                     var19.setBesligPuRemTtc(0.0D);
                     var19.setBesligPuTtc(0.0D);
                     var19.setBesligPump(0.0D);
                     float var9 = var20 * ((ProduitsGrp)var21.get(var8)).getProgrpQte();
                     var19.setBesligQte(var9);
                     var19.setBesligQteUtil(var19.getBesligQte());
                     var19.setBesligRabais(0.0D);
                     var19.setBesligReference(var18);
                     var19.setBesligStock(((ProduitsGrp)var21.get(var8)).getProduits().getProStock());
                     var19.setBesligTauxRemise(0.0F);
                     var19.setBesligTauxTaxe(0.0F);
                     var19.setBesligTaxe("");
                     var19.setBesligTc(0.0D);
                     var19.setBesligTtc(0.0D);
                     var19.setBesligTva(0.0D);
                     var19.setBesligUnite(((ProduitsGrp)var21.get(var8)).getProgrpUnite());
                     var19.setBesligVolume(0.0F);
                     var19.setBesoinEnteteVentes(this.besoinEnteteVentes);
                     var19 = this.besoinLigneVentesDao.insertLigne(var19, var1);
                     if (this.numLigne > this.lesLignesList.size()) {
                        this.numLigne = this.lesLignesList.size();
                     }

                     this.lesLignesList.add(this.numLigne + var8, var19);
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            this.cumulPrix();
            this.besoinEnteteVentes = this.besoinEnteteVentesDao.modif(this.besoinEnteteVentes, var1);
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
      if (this.besoinLigneVentes.getBesligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.besoinLigneVentes.getBesligCode();
            this.besoinLigneVentesDao.deleteOneLigne(this.besoinLigneVentes, var1);
            new ArrayList();
            List var4 = (List)this.datamodelLigne.getWrappedData();
            var4.remove(this.besoinLigneVentes);
            this.datamodelLigne.setWrappedData(var4);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Suppression ligne produit " + var3 + " du Besoin N° " + this.besoinEnteteVentes.getBesNum() + " du " + this.besoinEnteteVentes.getBesDate());
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

   public void controleSaisie() {
   }

   public void recupererEltCat() throws HibernateException, NamingException {
      if (this.lesFamilleClientsListe.size() != 0) {
         for(int var1 = 0; var1 < this.lesFamilleClientsListe.size() && !this.besoinEnteteVentes.getBesCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var1)).getLibelle()); ++var1) {
         }
      }

      if (this.lesLignesList.size() != 0) {
         Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var11.beginTransaction();
            int var3 = 0;

            while(true) {
               if (var3 >= this.lesLignesList.size()) {
                  this.besoinEnteteVentes = this.besoinEnteteVentesDao.modif(this.besoinEnteteVentes, var11);
                  var2.commit();
                  break;
               }

               this.besoinLigneVentes = new BesoinLigneVentes();
               this.besoinLigneVentes = (BesoinLigneVentes)this.lesLignesList.get(var3);
               if (this.besoinLigneVentes.getBesligCode() != null && !this.besoinLigneVentes.getBesligCode().isEmpty()) {
                  new Produits();
                  Produits var4 = this.produitsDao.chargeProduit(this.besoinLigneVentes.getBesligCode(), var11);
                  TaxesVentes var5;
                  if (var4 != null) {
                     if (var4.isProExoTva()) {
                        this.besoinLigneVentes.setBesligTaxe("");
                        this.besoinLigneVentes.setBesligTauxTaxe(0.0F);
                     } else {
                        this.besoinLigneVentes.setBesligTaxe(var4.getProVteTva());
                        new TaxesVentes();
                        var5 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.besoinLigneVentes.getBesligTaxe(), var11);
                        if (var5 != null) {
                           this.besoinLigneVentes.setBesligTauxTaxe(var5.getTaxvteTaux());
                        } else {
                           this.besoinLigneVentes.setBesligTauxTaxe(0.0F);
                        }
                     }
                  } else {
                     this.besoinLigneVentes.setBesligTaxe("");
                     this.besoinLigneVentes.setBesligTauxTaxe(0.0F);
                  }

                  if ((this.besoinLigneVentes.getBesligTaxe() == null || this.besoinLigneVentes.getBesligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                     new TaxesVentes();
                     var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var11);
                     if (var5 != null) {
                        this.mesTaxesVentesProduits.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
                        this.besoinLigneVentes.setBesligTaxe(var5.getTaxvteCode());
                        this.besoinLigneVentes.setBesligTauxTaxe(var5.getTaxvteTaux());
                     }
                  }
               }

               if (this.var_tc_calcul) {
                  this.besoinEnteteVentes.setBesTauxTc(this.var_tc_taux);
               } else {
                  this.besoinEnteteVentes.setBesTauxTc(0.0F);
               }

               this.calculPrix(this.besoinLigneVentes.getBesligTaxe(), this.besoinLigneVentes.getBesligTauxTaxe(), var11);
               this.besoinLigneVentes = this.besoinLigneVentesDao.modifLigne(this.besoinLigneVentes, var11);
               ++var3;
            }
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerDocumentLigne((Session)null);
         this.cumulPrix();
      }

   }

   public void rechercheDestinataire() throws JDOMException, IOException, HibernateException, NamingException {
      if (!this.selectDestinataire) {
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.inpDestinataire, this.nature);
      } else {
         this.plansAnalytiques = this.formRecherche.rechercheDestinataire(this.besoinEnteteVentes.getBesNomContact(), this.nature);
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
         this.besoinEnteteVentes.setBesNomContact(this.plansAnalytiques.getAnaNomFr());
         this.besoinEnteteVentes.setBesCivilContact(this.plansAnalytiques.getAnaTiersCivilite());
         this.besoinEnteteVentes.setBesAnal4(this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr());
      } else {
         this.annuleDestinataire();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDestinataire() {
      this.plansAnalytiques = null;
      this.inpDestinataire = "";
      this.besoinEnteteVentes.setBesNomContact("");
      this.besoinEnteteVentes.setBesCivilContact("");
      this.besoinEnteteVentes.setBesAnal4("");
      this.var_action = this.var_memo_action;
   }

   public void rechercheResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.rechercheResponsable(this.inpResponsable, this.nature);
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

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.besoinLigneVentes.getBesligCode() != null && !this.besoinLigneVentes.getBesligCode().isEmpty() && !this.besoinLigneVentes.getBesligCode().equals("-") && !this.besoinLigneVentes.getBesligCode().equals("=")) {
         this.produits = this.formRecherche.rechercheProduitVente(this.besoinLigneVentes.getBesligCode(), this.nature, this.optionsVentes);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinLigne");
         this.besoinLigneVentes.setBesligCode(this.produits.getProCode());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.besoinLigneVentes.setBesligLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.besoinLigneVentes.setBesligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.besoinLigneVentes.setBesligLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.besoinLigneVentes.setBesligLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.besoinLigneVentes.setBesligLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.besoinLigneVentes.setBesligLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.besoinLigneVentes.setBesligFamille(this.produits.getProVteCode());
         this.besoinLigneVentes.setBesligStock(this.produits.getProStock());
         this.besoinLigneVentes.setBesligLong(this.produits.getProLongueur());
         this.besoinLigneVentes.setBesligLarg(this.produits.getProLargeur());
         this.besoinLigneVentes.setBesligHaut(this.produits.getProEpaisseur());
         this.besoinLigneVentes.setBesligDiam(this.produits.getProDiamExt());
         this.besoinLigneVentes.setBesligPoidsBrut(this.produits.getProPoidsBrut());
         this.besoinLigneVentes.setBesligPoidsNet(this.produits.getProPoidsNet());
         this.besoinLigneVentes.setBesligVolume(this.produits.getProVolume());
         this.besoinLigneVentes.setBesligNb(this.produits.getProNbUnite());
         this.besoinLigneVentes.setBesligReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.besoinLigneVentes.setBesligModeGroupe(this.produits.getProMode());
         if (this.produits.getProImpDesciption() == 1) {
            if (this.usersLog.getUsrVteLibelle() == 1) {
               this.verrou_libelle = true;
            } else {
               this.verrou_libelle = false;
            }
         } else {
            this.verrou_libelle = false;
         }

         this.mesTaxesVentesProduits.clear();
         new FamillesProduitsVentes();
         FamillesProduitsVentes var8 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExoVentes.getExevteId(), this.produits, var1);
         if (this.produits.isProExoTva()) {
            this.besoinLigneVentes.setBesligTaxe("");
            this.besoinLigneVentes.setBesligTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         } else {
            TaxesVentes var9;
            if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty() && !this.produits.getProVteTva().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.produits.getProVteTva(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.produits.getProVteTva(), this.produits.getProVteTva() + ":" + var9.getTaxvteTaux()));
                  this.besoinLigneVentes.setBesligTaxe(this.produits.getProVteTva());
                  this.besoinLigneVentes.setBesligTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.besoinLigneVentes.setBesligTaxe("");
                  this.besoinLigneVentes.setBesligTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.besoinLigneVentes.setBesligTaxe(var8.getFamvteTaxe());
                  this.besoinLigneVentes.setBesligTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.besoinLigneVentes.setBesligTaxe("");
               this.besoinLigneVentes.setBesligTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.besoinEnteteVentes.getBesExoTva() == 0 && (this.besoinLigneVentes.getBesligTaxe() == null || this.besoinLigneVentes.getBesligTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.besoinLigneVentes.setBesligTaxe(var9.getTaxvteCode());
                  this.besoinLigneVentes.setBesligTauxTaxe(var9.getTaxvteTaux());
               }
            }
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.besoinLigneVentes.getBesligTauxTaxe() / 100.0D;
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
               this.besoinLigneVentes.setBesligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.besoinLigneVentes.setBesligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.besoinLigneVentes.setBesligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.besoinLigneVentes.setBesligCondition("");
         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.besoinLigneVentes.getBesligPump() != 0.0D) {
            this.besoinLigneVentes.setBesligPu(this.besoinLigneVentes.getBesligPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.besoinLigneVentes.getBesligTaxe(), this.besoinLigneVentes.getBesligTauxTaxe(), var1);
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
      if (this.besoinLigneVentes.getBesligCode() == null || this.besoinLigneVentes.getBesligCode().isEmpty() || this.besoinLigneVentes.getBesligCode().length() < 2) {
         if (this.besoinEnteteVentes.getBesExoTva() == 0) {
            if (this.mesTaxesVentesProduits.isEmpty()) {
               this.mesTaxesVentesProduits.clear();
               if (this.mesTaxesVentesItems.size() != 0) {
                  for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
                     this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
                  }
               }

               if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                  this.besoinLigneVentes.setBesligTaxe(this.optionsVentes.getTvaDefaut());
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
      this.besoinLigneVentes.setBesligCode("");
      this.besoinLigneVentes.setBesligLibelle("");
      this.mesTaxesVentesProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.verrou_libelle = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.prixPlancher = 0.0D;
      this.griserValider = false;
      this.var_action = this.var_memo_action;
   }

   public void prixUnitaireCorrespond(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         double var2 = 0.0D;
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            var2 = this.besoinLigneVentes.getBesligPuTtc();
         } else {
            var2 = this.besoinLigneVentes.getBesligPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(var1);
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.besoinLigneVentes.setBesligPuTtc(this.prixUnitaires);
         } else {
            this.besoinLigneVentes.setBesligPu(this.prixUnitaires);
         }

         if (this.verifBareme) {
            boolean var4 = false;
            new Baremes();
            Baremes var5 = this.baremesDao.rechercheBaremeProduit(0L, this.produits.getProCode(), var1);
            if (var5 != null && (var5.getBarDateDebut() == null && var5.getBarDateFin() == null || var5.getBarDateDebut() != null && this.var_date.compareTo(var5.getBarDateDebut()) >= 0 && var5.getBarDateFin() != null && this.var_date.compareTo(var5.getBarDateFin()) <= 0)) {
               var4 = true;
            }

            if (!var4) {
               var5 = this.baremesDao.rechercheBaremeFamille(0L, this.produits.getProVteCode(), var1);
               if (var5 != null && (var5.getBarDateDebut() == null && var5.getBarDateFin() == null || var5.getBarDateDebut() != null && this.var_date.compareTo(var5.getBarDateDebut()) >= 0 && var5.getBarDateFin() != null && this.var_date.compareTo(var5.getBarDateFin()) <= 0)) {
                  var4 = true;
               }
            }

            if (var4 && var5 != null) {
               double var6;
               if (var5.getBarRemise() != 0.0F) {
                  this.besoinLigneVentes.setBesligTauxRemise(var5.getBarRemise());
                  var6 = 0.0D;
                  var6 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var5.getBarRemise() / 100.0D, this.besoinEnteteVentes.getBesDevise());
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.besoinLigneVentes.setBesligPuTtc(this.prixUnitaires);
                     this.besoinLigneVentes.setBesligPuRemTtc(var6);
                  } else {
                     this.besoinLigneVentes.setBesligPu(this.prixUnitaires);
                     this.besoinLigneVentes.setBesligPuRem(var6);
                  }
               } else if (var5.getBarRabais() != 0.0D) {
                  this.besoinLigneVentes.setBesligRabais(var5.getBarRabais());
                  var6 = 0.0D;
                  if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                     var6 = this.prixUnitaires - var5.getBarRabais() * (double)this.besoinLigneVentes.getBesligQte();
                  } else {
                     var6 = this.prixUnitaires - var5.getBarRabais();
                  }

                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.besoinLigneVentes.setBesligPuTtc(this.prixUnitaires);
                     this.besoinLigneVentes.setBesligPuRemTtc(var6);
                  } else {
                     this.besoinLigneVentes.setBesligPu(this.prixUnitaires);
                     this.besoinLigneVentes.setBesligPuRem(var6);
                  }
               } else if (var5.getBarPrix() != 0.0D) {
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.besoinLigneVentes.setBesligPuTtc(var5.getBarPrix());
                  } else {
                     this.besoinLigneVentes.setBesligPu(var5.getBarPrix());
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

            for(int var9 = 0; var9 < this.lesLignesList.size() && (((BesoinLigneVentes)this.lesLignesList.get(var9)).getBesligCode() == null || ((BesoinLigneVentes)this.lesLignesList.get(var9)).getBesligCode().isEmpty() || !((BesoinLigneVentes)this.lesLignesList.get(var9)).getBesligCode().equals(this.produits.getProCode())); ++var9) {
               var5 += ((BesoinLigneVentes)this.lesLignesList.get(var9)).getBesligPt();
            }

            this.prixUnitaires = this.utilNombre.myRoundDevise(var5 * var10 / 100.0D, this.structureLog.getStrdevise());
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            String var7 = var3[1];

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               if (((BesoinLigneVentes)this.lesLignesList.get(var8)).getBesligFamille() != null && !((BesoinLigneVentes)this.lesLignesList.get(var8)).getBesligFamille().isEmpty() && ((BesoinLigneVentes)this.lesLignesList.get(var8)).getBesligFamille().equals(var7)) {
                  var5 += ((BesoinLigneVentes)this.lesLignesList.get(var8)).getBesligPt();
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

   public void prixUnitaireDegressif(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         double var2 = this.besoinLigneVentes.getBesligPu();
         double var4 = this.besoinLigneVentes.getBesligPuTtc();
         if (this.besoinLigneVentes.getBesligPu() >= 0.0D && this.besoinLigneVentes.getBesligPuTtc() >= 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.besoinEnteteVentes.getBesCat(), (String)null, var1);
            if (var6 != null) {
               new ObjetTarif();
               if (var6.getProtarTarifQte() != null && !var6.getProtarTarifQte().isEmpty()) {
                  double var8 = 0.0D;
                  ObjetTarif var7;
                  String[] var10;
                  if (!var6.getProtarTarifQte().contains("#")) {
                     var10 = var6.getProtarTarifQte().split(":");
                     var7 = new ObjetTarif();
                     var7.setQteDebut(Float.parseFloat(var10[0]));
                     var7.setQteFin(Float.parseFloat(var10[1]));
                     var7.setPrix(Double.parseDouble(var10[2]));
                     if (this.besoinLigneVentes.getBesligQte() >= var7.getQteDebut() && this.besoinLigneVentes.getBesligQte() <= var7.getQteFin()) {
                        var8 = var7.getPrix();
                     }
                  } else {
                     var10 = var6.getProtarTarifQte().split("#");
                     int var11 = var10.length;

                     for(int var12 = 0; var12 < var11; ++var12) {
                        String[] var13 = var10[var12].split(":");
                        var7 = new ObjetTarif();
                        var7.setQteDebut(Float.parseFloat(var13[0]));
                        var7.setQteFin(Float.parseFloat(var13[1]));
                        var7.setPrix(Double.parseDouble(var13[2]));
                        if (this.besoinLigneVentes.getBesligQte() >= var7.getQteDebut() && this.besoinLigneVentes.getBesligQte() <= var7.getQteFin()) {
                           var8 = var7.getPrix();
                           break;
                        }
                     }
                  }

                  if (var8 != 0.0D) {
                     this.prixUnitaires = var8;
                  } else {
                     this.prixUnitaires = var6.getProtarPv();
                  }
               } else {
                  this.prixUnitaires = var6.getProtarPv();
               }
            } else if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               this.prixUnitaires = var4;
            } else {
               this.prixUnitaires = var2;
            }
         } else {
            var2 = Math.abs(this.besoinLigneVentes.getBesligPu());
            var4 = Math.abs(this.besoinLigneVentes.getBesligPuTtc());
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               this.prixUnitaires = var4;
            } else {
               this.prixUnitaires = var2;
            }
         }
      }

   }

   public void selectionDepot() throws HibernateException, NamingException {
      this.selectionDepot((Session)null);
      this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
      this.besoinLigneVentes.setBesligUnite(this.produitsDepot.getProdepUnite());
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
         if (this.besoinLigneVentes.getBesligCondition() != null && !this.besoinLigneVentes.getBesligCondition().isEmpty() && this.besoinLigneVentes.getBesligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.besoinLigneVentes.getBesligEchelle());
            float var5 = 1.0F;
            if (this.besoinLigneVentes.getBesligCondition().contains("/")) {
               String[] var6 = this.besoinLigneVentes.getBesligCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.besoinLigneVentes.getBesligCondition() != null && !this.besoinLigneVentes.getBesligCondition().isEmpty() && !this.besoinLigneVentes.getBesligCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.besoinLigneVentes.getBesligEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.besoinLigneVentes.setBesligPump(var9);
      } else {
         this.besoinLigneVentes.setBesligPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinLigne");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.besoinLigneVentes.getBesligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.besoinLigneVentes.setBesligEchelle(this.unite.getUniEchelle());
               } else {
                  this.besoinLigneVentes.setBesligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.besoinLigneVentes.setBesligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.besoinLigneVentes.setBesligEchelle(Integer.parseInt(var2));
         } else {
            this.besoinLigneVentes.setBesligEchelle(0);
         }

         this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
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
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.besoinLigneVentes.getBesligLong(), this.besoinLigneVentes.getBesligLarg(), this.besoinLigneVentes.getBesligHaut(), this.besoinLigneVentes.getBesligDiam(), this.besoinLigneVentes.getBesligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.besoinLigneVentes.getBesligLong(), this.besoinLigneVentes.getBesligLarg(), this.besoinLigneVentes.getBesligHaut(), this.besoinLigneVentes.getBesligDiam(), this.besoinLigneVentes.getBesligNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else {
                  var6 = "" + var12;
               }

               if (this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
                  if (!this.verrouDepotUser.contains(",")) {
                     if (var11.getDepot().getDpoCode().equals(this.verrouDepotUser)) {
                        if (var11.getProdepCasier() != null && !var11.getProdepCasier().isEmpty()) {
                           this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + ":" + var11.getProdepCasier() + "=" + var6));
                        } else {
                           this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + "=" + var6));
                        }
                     }
                  } else {
                     String[] var13 = this.verrouDepotUser.split(",");
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

   public void verifBonEncaissement() {
      if (this.montantElmTotBonEnc <= this.besoinEnteteVentes.getBesTotTtc() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void serieSelectTrf() throws HibernateException, NamingException, ParseException {
      this.mesSeriesTrfItems.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
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

      this.var_serie_trf = this.besoinEnteteVentes.getBesSerie();
      this.modeleSelectTrf();
      this.utilInitHibernate.closeSession();
   }

   public void modeleSelectTrf() throws ParseException {
      this.modeleTrfItems.clear();
      String var1 = "";
      if (this.var_type_trf == 20) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "besoin" + File.separator;
      } else if (this.var_type_trf == 21) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "devis" + File.separator;
      } else if (this.var_type_trf == 22) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (this.var_type_trf == 23) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "livraison" + File.separator;
      } else if (this.var_type_trf == 24) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (this.var_type_trf == 25) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (this.var_type_trf == 26) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (this.var_type_trf == 27) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (this.var_type_trf == 28) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "chargement" + File.separator;
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
      this.var_imput_serie = this.besoinEnteteVentes.getBesSerie();
      this.var_imput_cat = this.besoinEnteteVentes.getBesCat();
      this.showModalPanelImput = true;
   }

   public void miseajourImput() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (!this.var_imput_serie.equalsIgnoreCase("X")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.besoinEnteteVentes.getBesNum();
            this.besoinEnteteVentes.setBesSerie(this.var_imput_serie);
            this.besoinEnteteVentes.setBesCat(this.var_imput_cat);
            this.besoinEnteteVentes.setBesNum(this.calculChrono.numCompose(this.besoinEnteteVentes.getBesDate(), this.nature, this.besoinEnteteVentes.getBesSerie(), var1));
            this.besoinEnteteVentesDao.modif(this.besoinEnteteVentes, var1);
            ArrayList var4;
            int var6;
            if (this.besoinEnteteVentes.getBesTotReglement() != 0.0D) {
               new ArrayList();
               ReglementsDao var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.besoinEnteteVentes.getBesId(), this.nature, var1);
               if (var4 != null) {
                  for(var6 = 0; var6 < var4.size(); ++var6) {
                     new Reglements();
                     Reglements var7 = (Reglements)var4.get(var6);
                     var7.setRglDocument(this.besoinEnteteVentes.getBesNum());
                     var5.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            ParapheurDao var13 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            var4 = (ArrayList)var13.parapheurDocument(this.besoinEnteteVentes.getBesId(), this.nature, var1);
            if (var4 != null) {
               for(var6 = 0; var6 < var4.size(); ++var6) {
                  new Parapheur();
                  Parapheur var15 = (Parapheur)var4.get(var6);
                  var15.setPhrNum(this.besoinEnteteVentes.getBesNum());
                  var13.modif(var15, var1);
               }
            }

            Espion var14 = new Espion();
            var14.setUsers(this.usersLog);
            var14.setEsptype(0);
            var14.setEspdtecreat(new Date());
            var14.setEspaction("Imputation Besoin X N° " + var3 + " en Besoin " + this.besoinEnteteVentes.getBesSerie() + " N° " + this.besoinEnteteVentes.getBesNum());
            this.espionDao.mAJEspion(var14, var1);
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

   public void annuleTrf() {
      this.setShowModalPanelTrf(false);
   }

   public void qteTrfQteOrg() throws HibernateException, NamingException {
      this.qteTrfQteOrg((Session)null);
   }

   public void qteTrfQteOrg(Session var1) throws HibernateException, NamingException {
      if (this.documentDetailTrf.size() != 0) {
         for(int var2 = 0; var2 < this.documentDetailTrf.size(); ++var2) {
            new BesoinLigneVentes();
            BesoinLigneVentes var3 = (BesoinLigneVentes)this.documentDetailTrf.get(var2);
            float var4 = 0.0F;
            ArrayList var5 = new ArrayList();
            if (this.var_type_trf == 28) {
               new ArrayList();
               List var6 = this.produitsDepotDao.selectProdDepByprod(var3.getBesligCode(), var1);
               if (var6.size() != 0) {
                  for(int var7 = 0; var7 < var6.size(); ++var7) {
                     new ProduitsDepot();
                     ProduitsDepot var8 = (ProduitsDepot)var6.get(var7);
                     if (var8.getDepot().getDpoLivraison() == 1) {
                        var5.add(new SelectItem(var8.getDepot().getDpoCode() + "=" + var8.getProdepQteStk()));
                     }
                  }
               }

               ChargementLigneDao var10 = new ChargementLigneDao(this.baseLog, this.utilInitHibernate);
               var4 = var10.chargerLesReliquatsBesoinVtes(var3.getBesligId(), var1);
            }

            float var9 = var3.getBesligQte() - var4;
            if (var9 < 0.0F) {
               var9 = 0.0F;
            }

            var3.setVar_qteDejaTrf(var4);
            var3.setVar_qteReliquat(var9);
            var3.setVar_listDepotItem(var5);
            var3 = (BesoinLigneVentes)this.documentDetailTrf.set(var2, var3);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         for(int var1 = 0; var1 < this.documentDetailTrf.size(); ++var1) {
            new BesoinLigneVentes();
            BesoinLigneVentes var2 = (BesoinLigneVentes)this.documentDetailTrf.get(var1);
            var2.setVar_qteReliquat(0.0F);
            var2 = (BesoinLigneVentes)this.documentDetailTrf.set(var1, var2);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void transformerMaj() throws HibernateException, NamingException, Exception {
      if (this.documentDetailTrf.size() != 0 && this.lesEntetesList.size() != 0) {
         ArrayList var1 = new ArrayList();
         int var2;
         BesoinEnteteVentes var3;
         boolean var4;
         int var5;
         if (this.var_mode_trf.equals("0")) {
            for(var2 = 0; var2 < this.lesEntetesList.size(); ++var2) {
               new BesoinEnteteVentes();
               var3 = (BesoinEnteteVentes)this.lesEntetesList.get(var2);
               if (var3.isVar_select_ligne()) {
                  var4 = false;

                  for(var5 = 0; var5 < var1.size(); ++var5) {
                     if (var3.getBesNum().equalsIgnoreCase(((BesoinEnteteVentes)var1.get(var5)).getBesNum())) {
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     var1.add(var3);
                  }
               }
            }
         } else {
            for(var2 = 0; var2 < this.documentDetailTrf.size(); ++var2) {
               new BesoinEnteteVentes();
               var3 = (BesoinEnteteVentes)this.lesEntetesList.get(var2);
               if (var3.isVar_select_ligne()) {
                  var4 = false;

                  for(var5 = 0; var5 < var1.size(); ++var5) {
                     if (var3.getTiers().getTieid() == ((BesoinEnteteVentes)var1.get(var5)).getTiers().getTieid()) {
                        if (var3.getBesSerie().equalsIgnoreCase(((BesoinEnteteVentes)var1.get(var5)).getBesSerie())) {
                           var4 = true;
                        }
                        break;
                     }
                  }

                  if (!var4) {
                     var1.add(var3);
                  }
               }
            }
         }

         if (var1.size() != 0) {
            for(var2 = 0; var2 < var1.size(); ++var2) {
               this.besoinEnteteVentes = (BesoinEnteteVentes)var1.get(var2);
               this.lesLignesList.clear();
               int var6;
               if (this.var_mode_trf.equals("0")) {
                  for(var6 = 0; var6 < this.documentDetailTrf.size(); ++var6) {
                     if (((BesoinEnteteVentes)var1.get(var2)).getBesNum().equalsIgnoreCase(((BesoinLigneVentes)this.documentDetailTrf.get(var6)).getBesoinEnteteVentes().getBesNum())) {
                        this.lesLignesList.add(this.documentDetailTrf.get(var6));
                     }
                  }
               } else {
                  for(var6 = 0; var6 < this.documentDetailTrf.size(); ++var6) {
                     if (((BesoinEnteteVentes)var1.get(var2)).getTiers().getTieid() == ((BesoinLigneVentes)this.documentDetailTrf.get(var6)).getBesoinEnteteVentes().getTiers().getTieid()) {
                        this.lesLignesList.add(this.documentDetailTrf.get(var6));
                     }
                  }
               }

               if (this.lesLignesList.size() != 0) {
                  this.utilParapheur.supprimerParapheur(this.besoinEnteteVentes.getBesId(), this.nature, (Session)null);
                  if (this.var_type_trf == 28) {
                     this.trfChg();
                  }
               }
            }
         }

         this.documentDetailTrf.clear();
         this.lesEntetesList.remove(this.besoinEnteteVentes);
      }

      this.showModalPanelTrf = false;
   }

   public void trfChg() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         DocumentTraceVentes var3 = new DocumentTraceVentes();
         ChargementEntete var4 = new ChargementEntete();
         ChargementEnteteDao var5 = new ChargementEnteteDao(this.baseLog, this.utilInitHibernate);
         ChargementLigneDao var6 = new ChargementLigneDao(this.baseLog, this.utilInitHibernate);
         ArrayList var7 = new ArrayList();
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var4.setChamobSerie(this.var_serie_trf);
         } else {
            var4.setChamobSerie(this.besoinEnteteVentes.getBesSerie());
         }

         var4.setUsers(this.usersLog);
         var4.setChamobUserCreat(this.usersLog.getUsrid());
         var4.setChamobNomUserCreat(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var4.setChamobDate(this.utilDate.dateToSQLLight(this.besoinEnteteVentes.getBesDate()));
         } else {
            var4.setChamobDate(this.var_date_trf);
         }

         var4.setChamobDate(this.utilDate.dateToSQL(var4.getChamobDate(), this.var_heure, this.var_minute, this.var_seconde));
         var4.setChamobDateCreat(new Date());
         var4.setChamobDateModif((Date)null);
         var4.setChamobUserModif(0L);
         var4.setChamobNomUserModif("");
         var4.setChamobNum("");
         var4.setChamobService(this.besoinEnteteVentes.getBesService());
         if (!var4.getChamobSerie().equalsIgnoreCase("X") && !var4.getChamobSerie().isEmpty()) {
            var4.setChamobNum(this.calculChrono.numCompose(var4.getChamobDate(), this.var_type_trf, var4.getChamobSerie(), var1));
         } else {
            long var8 = var5.selectLastNum(var1);
            var4.setChamobNum("" + var8);
         }

         this.verifieExistenceHabilitationChg(var4, var1);
         var4.setChamobNomResponsable(this.besoinEnteteVentes.getBesNomResponsable());
         var4.setChamobIdResponsable(this.besoinEnteteVentes.getBesIdResponsable());
         var4.setChamobNomCommercial(this.besoinEnteteVentes.getBesNomCommercial());
         var4.setChamobIdCommercial(this.besoinEnteteVentes.getBesIdCommercial());
         var4.setChamobCat(this.besoinEnteteVentes.getBesCat());
         var4.setChamobObservation(this.besoinEnteteVentes.getBesObservation());
         var4.setChamobTotHt(0.0D);
         var4.setChamobTotRemise(0.0D);
         var4.setChamobTotRabais(0.0D);
         var4.setChamobTotTva(0.0D);
         var4.setChamobTotTc(0.0D);
         var4.setChamobTotTtc(0.0D);
         var4.setChamobTotReglement(this.besoinEnteteVentes.getBesTotReglement());
         var4.setChamobSolde(this.besoinEnteteVentes.getBesSolde());
         var4.setChamobActivite(this.besoinEnteteVentes.getBesActivite());
         var4.setChamobSite(this.besoinEnteteVentes.getBesSite());
         var4.setChamobDepartement(this.besoinEnteteVentes.getBesDepartement());
         var4.setChamobAnal2(this.besoinEnteteVentes.getBesAnal2());
         var4.setChamobAnal4(this.besoinEnteteVentes.getBesAnal4());
         var4.setChamobDateImp((Date)null);
         var4.setChamobModeleImp(this.var_modele_trf);
         var4.setChamobEtat(0);
         var4.setChamobDateTransforme((Date)null);
         var4.setChamobDateAnnule((Date)null);
         var4.setChamobMotifAnnule("");
         var4.setExercicesVentes(this.besoinEnteteVentes.getExerciceventes());
         var4.setUsers(this.usersLog);
         var4 = var5.insert(var4, var1);
         float var31 = 0.0F;
         float var9 = 0.0F;
         float var10 = 0.0F;
         double var11 = 0.0D;
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         double var19 = 0.0D;
         double var21 = 0.0D;
         if (this.lesLignesList.size() != 0) {
            int var23 = 0;

            label208:
            while(true) {
               ChargementLigne var24;
               if (var23 >= this.lesLignesList.size()) {
                  var4.setChamobTotHt(var11);
                  var4.setChamobTotRemise(var13);
                  var4.setChamobTotRabais(var15);
                  var4.setChamobTotTva(var17);
                  var4.setChamobTotTc(var21);
                  var4.setChamobTotTtc(var19);
                  var4 = var5.modif(var4, var1);
                  if (var7.size() == 0) {
                     break;
                  }

                  var6.saveLigne(var7, var4, var1);
                  var23 = 0;

                  while(true) {
                     if (var23 >= var7.size()) {
                        break label208;
                     }

                     new ChargementLigne();
                     var24 = (ChargementLigne)var7.get(var23);
                     this.produits = this.produitsDao.chargeProduit(var24.getChaligCode(), var1);
                     if (this.produits != null && this.produits.getProStock() >= 1) {
                        this.calculStock.majChargementVentesVAL(var24, 0.0F, this.produits, 1, this.baseLog, var1);
                     }

                     ++var23;
                  }
               }

               this.besoinLigneVentes = (BesoinLigneVentes)this.lesLignesList.get(var23);
               if (this.besoinLigneVentes.getVar_qteReliquat() != 0.0F) {
                  var24 = new ChargementLigne();
                  var31 += this.besoinLigneVentes.getBesligQte();
                  var9 += this.besoinLigneVentes.getVar_qteDejaTrf();
                  if (((BesoinLigneVentes)this.lesLignesList.get(var23)).getVar_qteReliquat() != 0.0F) {
                     var24.setChaligCode(this.besoinLigneVentes.getBesligCode());
                     var24.setChaligFamille(this.besoinLigneVentes.getBesligFamille());
                     var24.setChaligIdBes(this.besoinLigneVentes.getBesligId());
                     var24.setChaligLibelle(this.besoinLigneVentes.getBesligLibelle());
                     if (this.besoinLigneVentes.getVar_depotLigne() != null && !((BesoinLigneVentes)this.lesLignesList.get(var23)).getVar_depotLigne().isEmpty() && ((BesoinLigneVentes)this.lesLignesList.get(var23)).getVar_depotLigne().contains("=")) {
                        String[] var25 = ((BesoinLigneVentes)this.lesLignesList.get(var23)).getVar_depotLigne().split("=");
                        var24.setChaligDepotCharg(var25[0]);
                     } else {
                        var24.setChaligDepotCharg("");
                     }

                     var24.setChaligEchelle(this.besoinLigneVentes.getBesligEchelle());
                     var24.setChaligUnite(this.besoinLigneVentes.getBesligUnite());
                     var24.setChaligCondition(this.besoinLigneVentes.getBesligCondition());
                     var24.setChaligStock(this.besoinLigneVentes.getBesligStock());
                     var24.setChaligReference(this.besoinLigneVentes.getBesligReference());
                     var24.setChaligPump(this.besoinLigneVentes.getBesligPump());
                     var24.setChaligPu(this.besoinLigneVentes.getBesligPu());
                     var24.setChaligPuTtc(this.besoinLigneVentes.getBesligPuTtc());
                     var24.setChaligTauxRemise(this.besoinLigneVentes.getBesligTauxRemise());
                     var24.setChaligPuRem(this.besoinLigneVentes.getBesligPuRem());
                     var24.setChaligPuRemTtc(this.besoinLigneVentes.getBesligPuRemTtc());
                     this.besoinLigneVentes.setBesligQte(((BesoinLigneVentes)this.lesLignesList.get(var23)).getVar_qteReliquat());
                     this.calculPrix(this.besoinLigneVentes.getBesligTaxe(), this.besoinLigneVentes.getBesligTauxTaxe(), var1);
                     var24.setChaligQteCharg(((BesoinLigneVentes)this.lesLignesList.get(var23)).getVar_qteReliquat());
                     var24.setChaligLong(this.besoinLigneVentes.getBesligLong());
                     var24.setChaligLarg(this.besoinLigneVentes.getBesligLarg());
                     var24.setChaligHaut(this.besoinLigneVentes.getBesligHaut());
                     var24.setChaligDiam(this.besoinLigneVentes.getBesligDiam());
                     var24.setChaligNb(this.besoinLigneVentes.getBesligNb());
                     var24.setChaligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.besoinLigneVentes.getBesligCondition(), this.besoinLigneVentes.getBesligQte(), this.besoinLigneVentes.getBesligLong(), this.besoinLigneVentes.getBesligLarg(), this.besoinLigneVentes.getBesligHaut(), this.besoinLigneVentes.getBesligDiam(), this.besoinLigneVentes.getBesligNb(), this.baseLog, this.utilInitHibernate, var1));
                     var24.setChaligRabais(this.besoinLigneVentes.getBesligRabais());
                     var24.setChaligTauxTaxe(this.besoinLigneVentes.getBesligTauxTaxe());
                     var24.setChaligTaxe(this.besoinLigneVentes.getBesligTaxe());
                     var24.setChaligPt(this.besoinLigneVentes.getBesligPt());
                     var24.setChaligTva(this.besoinLigneVentes.getBesligTva());
                     var24.setChaligTtc(this.besoinLigneVentes.getBesligTtc());
                     var24.setChaligTc(this.besoinLigneVentes.getBesligTc());
                     var24.setChargementEntete(var4);
                     var10 += ((BesoinLigneVentes)this.lesLignesList.get(var23)).getVar_qteReliquat();
                     var7.add(var24);
                     var11 += var24.getChaligPt();
                     var13 += (var24.getChaligPu() - var24.getChaligPuRem()) * (double)var24.getChaligQteCharg();
                     var15 += var24.getChaligRabais();
                     var17 += var24.getChaligTva();
                     var19 += var24.getChaligTtc();
                     var21 += var24.getChaligTc();
                  }
               }

               ++var23;
            }
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationChg(var4, var1), var4.getChamobId(), var4.getChamobNum(), var4.getChamobNomResponsable(), var4.getChamobDate(), this.structureLog.getStrdevise(), var4.getChamobTotTtc() + var4.getChamobTotTc(), var4.getChamobModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog, 28), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFCHG(var7, var4), this.calculeParc(var1), this.structureLog.getStrformatdevise(), 0, var1);
         var3.setDoctraDateCreat(new Date());
         var3.setDoctraUserId(this.usersLog.getUsrid());
         var3.setDoctraUserNom(this.usersLog.getUsrNom());
         var3.setExerciceventes(this.besoinEnteteVentes.getExerciceventes());
         var3.setDoctraOrgType(this.nature);
         var3.setDoctraOrgSerie(this.besoinEnteteVentes.getBesSerie());
         var3.setDoctraOrgId(this.besoinEnteteVentes.getBesId());
         var3.setDoctraOrgNum(this.besoinEnteteVentes.getBesNum());
         var3.setDoctraOrgDate(this.besoinEnteteVentes.getBesDate());
         var3.setDoctraDstType(this.var_type_trf);
         var3.setDoctraDstSerie(var4.getChamobSerie());
         var3.setDoctraDstId(var4.getChamobId());
         var3.setDoctraDstNum(var4.getChamobNum());
         var3.setDoctraDstDate(var4.getChamobDate());
         this.documentTraceVentesDao.insert(var3, var1);
         if (var31 <= var9 + var10 && var31 != 0.0F && var9 + var10 != 0.0F) {
            this.besoinEnteteVentes.setBesEtat(5);
         } else {
            this.besoinEnteteVentes.setBesEtat(4);
         }

         this.besoinEnteteVentes.setBesDateTransforme(new Date());
         this.besoinEnteteVentes.setBesTypeTransforme(this.var_type_trf);
         this.besoinEnteteVentesDao.modif(this.besoinEnteteVentes, var1);
         var2.commit();
      } catch (HibernateException var29) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var29;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public JRBeanCollectionDataSource calculeImpressionTRFCHG(List var1, ChargementEntete var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new ChargementLigne();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            ChargementLigne var4 = (ChargementLigne)var1.get(var11);
            if (var4.getChaligCode() != null && !var4.getChaligCode().isEmpty() && var4.getChaligCode().equals("-")) {
               var5 = true;
               var6 = var4.getChaligLibelle();
            }

            if (var5) {
               var7 += var4.getChaligPt();
               var9 = var4.getChaligTtc();
            }

            if (var4.getChaligCode() != null && !var4.getChaligCode().isEmpty() && var4.getChaligCode().equals("=") && var5) {
               var4 = new ChargementLigne();
               var4.setChargementEntete(var2);
               var4.setChaligCode("=");
               var4.setChaligLibelle(var6);
               var4.setChaligPt(var7);
               var4.setChaligTtc(var9);
               var3.add(var4);
               var7 = 0.0D;
               var9 = 0.0D;
               var5 = false;
            } else {
               var3.add(var4);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2.getChamobTotTtc() + var2.getChamobTotTc(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var3);
      return var12;
   }

   public Habilitation verifieExistenceHabilitationChg(ChargementEntete var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setChamobEtatVal(1);
         var1.setChamobEtat(0);
      } else {
         var1.setChamobEtatVal(0);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               var1.setChamobEtat(1);
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               var1.setChamobEtat(0);
            }
         }
      }

      return var4;
   }

   public void payeDocument() {
      this.bonEncaissementVente = new BonEncaissementVente();
      this.bonEncaissementVente.setBonCodeCaisse("");
      this.bonEncaissementVente.setBonLibCaisse("");
      this.bonEncaissementVente.setBonDate(new Date());
      if (this.var_tot_bon_encaissement > this.besoinEnteteVentes.getBesTotTtc()) {
         this.besoinEnteteVentes.setBesTypeReg(4);
         this.var_verouxModReg = true;
         this.var_affichMontant = false;
         this.var_netAPayer = this.besoinEnteteVentes.getBesTotTtc() - this.var_tot_bon_encaissement;
         this.verifBonEncaissement();
      } else {
         if (this.besoinEnteteVentes.getBesTypeReg() == 5) {
            this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
            if (this.besoinEnteteVentes.getBesEtat() == 1) {
               this.var_verouxModReg = true;
            } else {
               this.var_verouxModReg = false;
            }

            this.var_netAPayer = this.besoinEnteteVentes.getBesTotTtc() - this.var_tot_bon_encaissement;
            this.var_affiche_valide = true;
         } else {
            this.besoinEnteteVentes.setBesTypeReg(0);
            this.var_verouxModReg = false;
            this.var_netAPayer = this.besoinEnteteVentes.getBesTotTtc() - this.var_tot_bon_encaissement;
            this.verifBonEncaissement();
         }

         this.var_affichMontant = true;
      }

      this.setShowModalPanelPaye(true);
   }

   public void annulePaye() {
      this.setShowModalPanelPaye(false);
   }

   public void chargerModReg() {
      if (this.besoinEnteteVentes.getBesTypeReg() != 4 && this.besoinEnteteVentes.getBesTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      if (this.var_tot_bon_encaissement <= this.besoinEnteteVentes.getBesTotTtc()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.besoinEnteteVentes.getBesTypeReg() == 5) {
               this.besoinEnteteVentes = this.besoinEnteteVentesDao.modif(this.besoinEnteteVentes, var1);
               new Habilitation();
               HabilitationDao var11 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var10 = var11.existenceHabilitation(29, var1);
               if (var10 != null) {
               }
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 29, this.besoinEnteteVentes.getBesSerie(), var1);
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
               this.bonEncaissementVente.setBonActivite(this.besoinEnteteVentes.getBesActivite());
               this.bonEncaissementVente.setBonSite(this.besoinEnteteVentes.getBesSite());
               this.bonEncaissementVente.setBonDepartement(this.besoinEnteteVentes.getBesDepartement());
               this.bonEncaissementVente.setBonService(this.besoinEnteteVentes.getBesService());
               this.bonEncaissementVente.setBonRegion(this.besoinEnteteVentes.getBesRegion());
               this.bonEncaissementVente.setBonSecteur(this.besoinEnteteVentes.getBesSecteur());
               this.bonEncaissementVente.setBonPdv(this.besoinEnteteVentes.getBesPdv());
               if (this.besoinEnteteVentes.getBesTypeReg() == 0) {
                  this.besoinEnteteVentes.setBesEcheanceReliquat((Date)null);
                  this.bonEncaissementVente.setBonDateEcheReg(this.besoinEnteteVentes.getBesDateEcheReg());
               } else {
                  if (this.besoinEnteteVentes.getBesEcheanceReliquat() == null) {
                     this.besoinEnteteVentes.setBesEcheanceReliquat(this.besoinEnteteVentes.getBesDateEcheReg());
                  }

                  this.bonEncaissementVente.setBonDateEcheReg(this.besoinEnteteVentes.getBesEcheanceReliquat());
               }

               this.bonEncaissementVente.setBonEtat(0);
               this.bonEncaissementVente.setBonNatRef(this.nature);
               this.bonEncaissementVente.setBonNomResponsable(this.usersLog.getUsrPrenom() + " " + this.usersLog.getUsrNom());
               this.bonEncaissementVente.setBonNomTiers(this.besoinEnteteVentes.getBesNomTiers());
               this.bonEncaissementVente.setBonIdTiers(this.besoinEnteteVentes.getTiers().getTieid());
               this.bonEncaissementVente.setBonNomContact(this.besoinEnteteVentes.getBesNomContact());
               this.bonEncaissementVente.setBonIdContact(this.besoinEnteteVentes.getBesIdContact());
               this.bonEncaissementVente.setBonTypeTiers(0);
               this.bonEncaissementVente.setBonLibelle("Règlement Besoin N° " + this.besoinEnteteVentes.getBesNum());
               this.bonEncaissementVente.setBonRef(this.besoinEnteteVentes.getBesNum());
               this.bonEncaissementVente.setBonIdRef(this.besoinEnteteVentes.getBesId());
               this.bonEncaissementVente.setBonObject(this.besoinEnteteVentes.getBesObject());
               this.bonEncaissementVente.setBonObservation(this.besoinEnteteVentes.getBesObservation());
               this.bonEncaissementVente.setBonSerie(this.besoinEnteteVentes.getBesSerie());
               this.bonEncaissementVente.setBonDevise(this.besoinEnteteVentes.getBesDevise());
               this.bonEncaissementVente.setBonTotTtc(this.besoinEnteteVentes.getBesTotTtc());
               this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
               this.bonEncaissementVente.setBonTypeReg(this.besoinEnteteVentes.getBesTypeReg());
               this.bonEncaissementVente.setBonActif(0);
               this.bonEncaissementVente.setBonNum(var3);
               this.bonEncaissementVente.setBonDate(new Date());
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatBesoin.jpg");
            if (var4.exists()) {
               var3 = "formatBesoin.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatBesoin.jpg");
         if (var4.exists()) {
            var3 = "formatBesoin.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         boolean var2 = false;
         String var3 = "";
         double var4 = 0.0D;
         double var6 = 0.0D;

         for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
            this.besoinLigneVentes = (BesoinLigneVentes)this.lesLignesList.get(var8);
            if (this.besoinLigneVentes.getBesligModeGroupe() != 2 || this.besoinLigneVentes.getBesligGroupe() == null || this.besoinLigneVentes.getBesligGroupe().isEmpty()) {
               if (this.besoinLigneVentes.getBesligCode() != null && !this.besoinLigneVentes.getBesligCode().isEmpty() && this.besoinLigneVentes.getBesligCode().equals("-")) {
                  var2 = true;
                  var3 = this.besoinLigneVentes.getBesligLibelle();
               }

               if (var2) {
                  var4 += this.besoinLigneVentes.getBesligPt();
                  var6 = this.besoinLigneVentes.getBesligTtc();
               }

               if (this.besoinLigneVentes.getBesligCode() != null && !this.besoinLigneVentes.getBesligCode().isEmpty() && this.besoinLigneVentes.getBesligCode().equals("=") && var2) {
                  this.besoinLigneVentes = new BesoinLigneVentes();
                  this.besoinLigneVentes.setBesoinEnteteVentes(this.besoinEnteteVentes);
                  this.besoinLigneVentes.setBesligCode("=");
                  this.besoinLigneVentes.setBesligLibelle(var3);
                  this.besoinLigneVentes.setBesligPt(var4);
                  this.besoinLigneVentes.setBesligTtc(var6);
                  var1.add(this.besoinLigneVentes);
                  var4 = 0.0D;
                  var6 = 0.0D;
                  var2 = false;
               } else {
                  this.besoinLigneVentes.setBesoinEnteteVentes(this.besoinEnteteVentes);
                  var1.add(this.besoinLigneVentes);
               }
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.besoinEnteteVentes.getBesTotTtc() + this.besoinEnteteVentes.getBesTotTc(), this.besoinEnteteVentes.getBesDevise());
      JRBeanCollectionDataSource var9 = new JRBeanCollectionDataSource(var1);
      return var9;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.besoinEnteteVentes.getBesAnal2() != null && !this.besoinEnteteVentes.getBesAnal2().isEmpty()) {
         String var4 = "";
         if (this.besoinEnteteVentes.getBesAnal2().contains(":")) {
            String[] var5 = this.besoinEnteteVentes.getBesAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.besoinEnteteVentes.getBesAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.besoinEnteteVentes.getBesDateImp() != null && this.besoinEnteteVentes.getBesEtat() != 0) {
            var2 = true;
         }

         this.besoinEnteteVentes.setBesDateImp(new Date());
         if (this.besoinEnteteVentes.getBesEtat() == 0 && this.besoinEnteteVentes.getBesEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.besoinEnteteVentes.setBesEtat(1);
         }

         this.besoinEnteteVentes.setBesModeleImp(var1);
         this.besoinEnteteVentes = this.besoinEnteteVentesDao.modif(this.besoinEnteteVentes, var3);
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

   public void impression(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
            boolean var12 = this.majDateImpression(var4);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var4);
            var1.setEntete("Impression besoin");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.besoinEnteteVentes.getBesEtat()));
            var1.setDuplicata("" + var12);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(this.besoinEnteteVentes.getBesIdResponsable());
            var1.setIdCommercial(this.besoinEnteteVentes.getBesIdCommercial());
            var1.setTiersSelectionne(this.besoinEnteteVentes.getTiers());
            var1.setNumDoc(this.besoinEnteteVentes.getBesNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.besoinEnteteVentes.getBesId());
            if (this.besoinEnteteVentes.getBesAnal2() != null && !this.besoinEnteteVentes.getBesAnal2().isEmpty()) {
               String var13 = "";
               if (this.besoinEnteteVentes.getBesAnal2().contains(":")) {
                  String[] var14 = this.besoinEnteteVentes.getBesAnal2().split(":");
                  var13 = var14[0];
               } else {
                  var13 = this.besoinEnteteVentes.getBesAnal2();
               }

               new Parc();
               ParcDao var15 = new ParcDao(this.baseLog, this.utilInitHibernate);
               Parc var17 = var15.rechercheParc(var13, (Session)null);
               if (var17 != null) {
                  var1.setParc(var17);
               } else {
                  var1.setParc((Parc)null);
               }
            } else {
               var1.setParc((Parc)null);
            }

            var1.setPoidsImp(var3);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
            this.chargerDocumentLigne((Session)null);
         }
      } else if (var5 != null && !var5.isEmpty()) {
         var1.setRapport(var5);
         var1.setEntete("Impression de la liste des besoin");
         var1.setTotauxHt("" + this.totauxHt);
         var1.setTotauxTaxe("" + this.totauxTaxe);
         var1.setTotauxTtc("" + this.totauxTtc);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "besoin" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var6);
         var1.setEmetteur(var7);
         var1.setDestinataire(var8);
         var1.setDestinataireCC(var9);
         var1.setDestinataireCCI(var10);
         var1.setCorpsMail(var11);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.nature);
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var16 = new JRBeanCollectionDataSource(this.lesEntetesList);
         var1.setjRBeanCollectionDataSource(var16);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public void initGrapheur() {
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
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

   public DataModel getDatamodelDocumentTrace() {
      return this.datamodelDocumentTrace;
   }

   public void setDatamodelDocumentTrace(DataModel var1) {
      this.datamodelDocumentTrace = var1;
   }

   public DataModel getDatamodelTransfert() {
      return this.datamodelTransfert;
   }

   public void setDatamodelTransfert(DataModel var1) {
      this.datamodelTransfert = var1;
   }

   public BesoinEnteteVentes getBesoinEnteteVentes() {
      return this.besoinEnteteVentes;
   }

   public void setBesoinEnteteVentes(BesoinEnteteVentes var1) {
      this.besoinEnteteVentes = var1;
   }

   public BesoinLigneVentes getBesoinLigneVentes() {
      return this.besoinLigneVentes;
   }

   public void setBesoinLigneVentes(BesoinLigneVentes var1) {
      this.besoinLigneVentes = var1;
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

   public List getMesSeriesTrfItems() {
      return this.mesSeriesTrfItems;
   }

   public void setMesSeriesTrfItems(List var1) {
      this.mesSeriesTrfItems = var1;
   }

   public List getMesTaxesVentesItems() {
      return this.mesTaxesVentesItems;
   }

   public void setMesTaxesVentesItems(List var1) {
      this.mesTaxesVentesItems = var1;
   }

   public List getMesUnitesProduits() {
      return this.mesUnitesProduits;
   }

   public void setMesUnitesProduits(List var1) {
      this.mesUnitesProduits = var1;
   }

   public List getModeleTrfItems() {
      return this.modeleTrfItems;
   }

   public void setModeleTrfItems(List var1) {
      this.modeleTrfItems = var1;
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

   public int getVar_code_unite() {
      return this.var_code_unite;
   }

   public void setVar_code_unite(int var1) {
      this.var_code_unite = var1;
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

   public boolean isVar_typeTiers() {
      return this.var_typeTiers;
   }

   public void setVar_typeTiers(boolean var1) {
      this.var_typeTiers = var1;
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

   public List getMesTaxesVentesProduits() {
      return this.mesTaxesVentesProduits;
   }

   public void setMesTaxesVentesProduits(List var1) {
      this.mesTaxesVentesProduits = var1;
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

   public List getDocumentTrfItems() {
      return this.documentTrfItems;
   }

   public void setDocumentTrfItems(List var1) {
      this.documentTrfItems = var1;
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

   public boolean isAccesAffaires() {
      return this.accesAffaires;
   }

   public void setAccesAffaires(boolean var1) {
      this.accesAffaires = var1;
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

   public boolean isVar_aff_unite() {
      return this.var_aff_unite;
   }

   public void setVar_aff_unite(boolean var1) {
      this.var_aff_unite = var1;
   }

   public boolean isShowModalPanelValidationDocument() {
      return this.showModalPanelValidationDocument;
   }

   public void setShowModalPanelValidationDocument(boolean var1) {
      this.showModalPanelValidationDocument = var1;
   }

   public int getVar_option_parc() {
      return this.var_option_parc;
   }

   public void setVar_option_parc(int var1) {
      this.var_option_parc = var1;
   }

   public List getMesParcsItems() {
      return this.mesParcsItems;
   }

   public void setMesParcsItems(List var1) {
      this.mesParcsItems = var1;
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

   public boolean isVerrou_libelle() {
      return this.verrou_libelle;
   }

   public void setVerrou_libelle(boolean var1) {
      this.verrou_libelle = var1;
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

   public boolean isAffichagePlancher() {
      return this.affichagePlancher;
   }

   public void setAffichagePlancher(boolean var1) {
      this.affichagePlancher = var1;
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

   public List getLesFamilleClientsListe() {
      return this.lesFamilleClientsListe;
   }

   public void setLesFamilleClientsListe(List var1) {
      this.lesFamilleClientsListe = var1;
   }

   public List getMesUsersItem() {
      return this.mesUsersItem;
   }

   public void setMesUsersItem(List var1) {
      this.mesUsersItem = var1;
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

   public boolean isVerifBareme() {
      return this.verifBareme;
   }

   public void setVerifBareme(boolean var1) {
      this.verifBareme = var1;
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

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
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

   public boolean isVar_tc_calcul() {
      return this.var_tc_calcul;
   }

   public void setVar_tc_calcul(boolean var1) {
      this.var_tc_calcul = var1;
   }
}
