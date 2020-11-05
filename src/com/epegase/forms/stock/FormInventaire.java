package com.epegase.forms.stock;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.InventaireEntete;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.TransfertPaye;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.InventaireEnteteDao;
import com.epegase.systeme.dao.InventaireLigneDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
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
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionStocks;
import com.epegase.systeme.xml.OptionVentes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.richfaces.model.selection.SimpleSelection;
import org.xml.sax.SAXException;

public class FormInventaire implements Serializable {
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
   private ExercicesComptable lastExoCompta;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_nb_max = 100;
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
   private InventaireEntete inventaireEntete = new InventaireEntete();
   private InventaireEnteteDao inventaireEnteteDao;
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
   private int var_nb_produit = 0;
   private UtilDate utilDate = new UtilDate();
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private DepotAchats depotAchats = new DepotAchats();
   private InventaireLigne inventaireLigne = new InventaireLigne();
   private InventaireLigneDao inventaireLigneDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private double totauxPump = 0.0D;
   private boolean griserchamps = false;
   private ServiceDao serviceDao;
   private Produits produits;
   private ProduitsAchsDao produitsDao;
   private ProduitsDepot produitsDepot = new ProduitsDepot();
   private ProduitsDepotDao produitsDepotDao;
   private TaxesAchatsDao taxesAchatsDao;
   private FamillesProduitsAchatsDao famillesProduitsAchatsDao;
   private FamillesProduitsAchats famillesProduitsAchats;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsMclesDao produitsMclesDao;
   private String var_depot;
   private long var_nom_responsable;
   private CalculStock calculStock = new CalculStock();
   private ProduitsFournisseurDao produitsFournisseurDao;
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
   private String inpService = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpResponsable = "";
   private String inpActivite = "100";
   private String inpParc = "100";
   private String inpDossier = "100";
   private String inpDepot = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
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
   private boolean var_anal_activite = false;
   private int var_anal_dossier;
   private boolean var_anal_parc = false;
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
   private FileCtrl fileCtrl;
   private ArrayList listFiles = new ArrayList();
   private UploadItem item;
   private int uploadsAvailable = 1;
   private String numRecup;
   private List lesTransfertPaye = new ArrayList();
   private TransfertPaye transfertPaye;
   private String verrouDepotUser;

   public FormInventaire() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.inventaireEnteteDao = new InventaireEnteteDao(this.baseLog, this.utilInitHibernate);
      this.inventaireLigneDao = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.taxesAchatsDao = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
      this.produitsFournisseurDao = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
   }

   public void configAchats() {
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

      this.periode = this.optionStocks.getAffichInGlobViewINV();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.initPage();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
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
      this.inpService = "100";
      this.inpDepot = "100";
      this.inpEtat = 0;
      this.lesEntetesList.clear();
      this.lesLignesList.clear();
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
         this.lesEntetesList = this.inventaireEnteteDao.recherche(var1, this.exercicesAchats.getExeachId(), this.getInpNum(), var6, this.getInpEtat(), this.getInpSerie(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), "", this.getInpActivite(), var4, var5);
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new InventaireEntete();

         for(var8 = 0; var8 < this.lesEntetesList.size(); ++var8) {
            InventaireEntete var10 = (InventaireEntete)this.lesEntetesList.get(var8);
            var2 += var10.getInvTotPump();
         }

         this.var_nb_ligne = this.lesEntetesList.size();
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
            this.inventaireEntete = (InventaireEntete)var1.get(0);
            this.var_date = this.inventaireEntete.getInvDate();
            if (this.inventaireEntete.getInvDate().getHours() <= 9) {
               this.var_heure = "0" + this.inventaireEntete.getInvDate().getHours();
            } else {
               this.var_heure = "" + this.inventaireEntete.getInvDate().getHours();
            }

            if (this.inventaireEntete.getInvDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.inventaireEntete.getInvDate().getMinutes();
            } else {
               this.var_minute = "" + this.inventaireEntete.getInvDate().getMinutes();
            }

            if (this.inventaireEntete.getInvDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.inventaireEntete.getInvDate().getSeconds();
            } else {
               this.var_seconde = "" + this.inventaireEntete.getInvDate().getSeconds();
            }

            this.var_nom_responsable = this.inventaireEntete.getInvIdResponsable();
            if (this.var_nom_responsable == 0L) {
               this.var_nom_responsable = this.usersLog.getUsrid();
            }

            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
            this.chargerDocumentLigne(var4);
            this.chargerUserChrono(var4);
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            this.utilInitHibernate.closeSession();
            this.montantPump = this.inventaireEntete.getInvTotPump();
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
      if (this.inventaireEntete != null) {
         if (this.inventaireEntete.getInvEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerDocumentLigne(Session var1) {
      this.lesLignesList.clear();
      this.var_nb_produit = 0;
      if (this.inventaireEntete.getInvId() > 0L) {
         this.lesLignesList = this.inventaireLigneDao.chargerLesLignes(this.inventaireEntete, var1);
         this.var_nb_produit = this.lesLignesList.size();
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.inventaireEntete != null && this.inventaireEntete.getInvSerie() != null && !this.inventaireEntete.getInvSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.inventaireEntete.getInvSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.inventaireEntete.getInvActivite() != null && !this.inventaireEntete.getInvActivite().isEmpty() && this.inventaireEntete.getInvActivite().contains(":")) {
         String[] var1 = null;
         if (!this.inventaireEntete.getInvActivite().contains("#")) {
            var1 = this.inventaireEntete.getInvActivite().split(":");
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
            String[] var2 = this.inventaireEntete.getInvActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.inventaireEntete.getInvTotPump() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.inventaireEntete.getInvTotPump() - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         if (var1 != 0.0F) {
            this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(100.0F - var1);
         }

         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void afficheValide() throws HibernateException, NamingException {
      if (this.var_depot != null && !this.var_depot.isEmpty() && !this.var_depot.equals("0")) {
         DepotAchatsDao var1 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         String var2 = "";
         if (this.var_depot.contains(":")) {
            String[] var3 = this.var_depot.split(":");
            var2 = var3[0];
         } else {
            var2 = this.var_depot;
         }

         this.depotAchats = var1.trouveDepot(var2, (Session)null);
         if (this.depotAchats != null) {
            this.var_valide_doc = true;
            this.var_aff_action = false;
         } else {
            this.var_valide_doc = false;
            this.var_aff_action = false;
            this.depotAchats = null;
         }
      } else {
         this.var_valide_doc = false;
         this.var_aff_action = false;
         this.depotAchats = null;
      }

   }

   public void afficheFiltre() throws HibernateException, NamingException {
      if (this.inventaireEntete.getInvMode() != 2 && this.inventaireEntete.getInvMode() != 3 && this.inventaireEntete.getInvMode() != 5) {
         this.var_affiche_filtre = false;
         this.inventaireEntete.setInvModeSpecif("");
      } else {
         this.var_affiche_filtre = true;
      }

      if (this.inventaireEntete.getInvMode() == 1) {
         this.modeAjout();
      } else {
         this.lesLignesList.clear();
         this.datamodelLigne.setWrappedData(this.lesLignesList);
         this.addLigne();
      }

   }

   public void modeAjout() throws HibernateException, NamingException {
      this.lesLignesList.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
      List var2;
      DepotAchatsDao var3;
      String[] var4;
      int var5;
      if (this.inventaireEntete.getInvMode() == 1) {
         new ArrayList();
         this.depotAchats = new DepotAchats();
         var3 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         var4 = this.var_depot.split(":");
         this.depotAchats = var3.trouveDepot(var4[0], var1);
         if (this.depotAchats != null) {
            var2 = this.produitsDepotDao.selectProdDepByDep(this.depotAchats, var1);
            if (var2.size() != 0) {
               for(var5 = 0; var5 < var2.size(); ++var5) {
                  this.inventaireLigne = new InventaireLigne();
                  this.produitsDepot = new ProduitsDepot();
                  this.produitsDepot = (ProduitsDepot)var2.get(var5);
                  if (this.produitsDepot.getProduits().getProMode() != 5) {
                     this.inventaireLigne.setInvligCode(this.produitsDepot.getProduits().getProCode());
                     if (this.produitsDepot.getProduits().getProVteCode() != null && !this.produitsDepot.getProduits().getProVteCode().isEmpty()) {
                        this.inventaireLigne.setInvligFamille(this.produitsDepot.getProduits().getProVteCode());
                     } else {
                        this.inventaireLigne.setInvligFamille(this.produitsDepot.getProduits().getProAchCode());
                     }

                     this.inventaireLigne.setInvligLibelle(this.produitsDepot.getProduits().getProLibClient());
                     this.inventaireLigne.setInvligCondition("");
                     this.inventaireLigne.setInvligObs("");
                     this.inventaireLigne.setInvligReference("");
                     this.inventaireLigne.setInvligDescription("");
                     this.inventaireLigne.setInvligDiam(this.produitsDepot.getProduits().getProDiamInt());
                     this.inventaireLigne.setInvligHaut(this.produitsDepot.getProduits().getProEpaisseur());
                     this.inventaireLigne.setInvligLarg(this.produitsDepot.getProduits().getProLargeur());
                     this.inventaireLigne.setInvligLong(this.produitsDepot.getProduits().getProLongueur());
                     this.inventaireLigne.setInvligPoidsBrut(this.produitsDepot.getProduits().getProPoidsBrut());
                     this.inventaireLigne.setInvligPoidsNet(this.produitsDepot.getProduits().getProPoidsNet());
                     this.inventaireLigne.setInvligVolume(this.produitsDepot.getProduits().getProVolume());
                     this.inventaireLigne.setInvligNb(this.produitsDepot.getProduits().getProNbUnite());
                     this.inventaireLigne.setInvligUnite(this.produitsDepot.getProdepUnite());
                     this.inventaireLigne.setInvligPump(this.produitsDepot.getProdepPump());
                     this.inventaireLigne.setInvligQteStock(this.produitsDepot.getProdepQteStk());
                     this.inventaireLigne.setInvligCasier(this.produitsDepot.getProdepCasier());
                     this.lesLignesList.add(this.inventaireLigne);
                  }
               }
            }
         }
      } else if (this.inventaireEntete.getInvMode() == 2 && this.inventaireEntete.getInvModeSpecif() != null && !this.inventaireEntete.getInvModeSpecif().isEmpty()) {
         new ArrayList();
         this.depotAchats = new DepotAchats();
         var3 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         var4 = this.var_depot.split(":");
         this.depotAchats = var3.trouveDepot(var4[0], var1);
         if (this.depotAchats != null) {
            var2 = this.produitsDepotDao.selectProdDepByDep(this.depotAchats, var1);
            if (var2.size() != 0) {
               for(var5 = 0; var5 < var2.size(); ++var5) {
                  this.inventaireLigne = new InventaireLigne();
                  this.produitsDepot = new ProduitsDepot();
                  this.produitsDepot = (ProduitsDepot)var2.get(var5);
                  if (this.produitsDepot.getProduits().getProMode() != 5 && this.produitsDepot.getProdepCasier() != null && !this.produitsDepot.getProdepCasier().isEmpty() && this.produitsDepot.getProdepCasier().equalsIgnoreCase(this.inventaireEntete.getInvModeSpecif())) {
                     this.inventaireLigne.setInvligCode(this.produitsDepot.getProduits().getProCode());
                     if (this.produitsDepot.getProduits().getProVteCode() != null && !this.produitsDepot.getProduits().getProVteCode().isEmpty()) {
                        this.inventaireLigne.setInvligFamille(this.produitsDepot.getProduits().getProVteCode());
                     } else {
                        this.inventaireLigne.setInvligFamille(this.produitsDepot.getProduits().getProAchCode());
                     }

                     this.inventaireLigne.setInvligLibelle(this.produitsDepot.getProduits().getProLibClient());
                     this.inventaireLigne.setInvligCondition("");
                     this.inventaireLigne.setInvligObs("");
                     this.inventaireLigne.setInvligReference("");
                     this.inventaireLigne.setInvligDescription("");
                     this.inventaireLigne.setInvligDiam(this.produitsDepot.getProduits().getProDiamInt());
                     this.inventaireLigne.setInvligHaut(this.produitsDepot.getProduits().getProEpaisseur());
                     this.inventaireLigne.setInvligLarg(this.produitsDepot.getProduits().getProLargeur());
                     this.inventaireLigne.setInvligLong(this.produitsDepot.getProduits().getProLongueur());
                     this.inventaireLigne.setInvligPoidsBrut(this.produitsDepot.getProduits().getProPoidsBrut());
                     this.inventaireLigne.setInvligPoidsNet(this.produitsDepot.getProduits().getProPoidsNet());
                     this.inventaireLigne.setInvligVolume(this.produitsDepot.getProduits().getProVolume());
                     this.inventaireLigne.setInvligNb(this.produitsDepot.getProduits().getProNbUnite());
                     this.inventaireLigne.setInvligUnite(this.produitsDepot.getProdepUnite());
                     this.inventaireLigne.setInvligPump(this.produitsDepot.getProdepPump());
                     this.inventaireLigne.setInvligQteStock(this.produitsDepot.getProdepQteStk());
                     this.inventaireLigne.setInvligCasier(this.produitsDepot.getProdepCasier());
                     this.lesLignesList.add(this.inventaireLigne);
                  }
               }
            }
         }
      } else if (this.inventaireEntete.getInvMode() == 3 && this.inventaireEntete.getInvModeSpecif() != null && !this.inventaireEntete.getInvModeSpecif().isEmpty()) {
         new ArrayList();
         this.depotAchats = new DepotAchats();
         var3 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         var4 = this.var_depot.split(":");
         this.depotAchats = var3.trouveDepot(var4[0], var1);
         if (this.depotAchats != null) {
            var2 = this.produitsDepotDao.selectProdDepByDep(this.depotAchats, var1);
            if (var2.size() != 0) {
               for(var5 = 0; var5 < var2.size(); ++var5) {
                  this.inventaireLigne = new InventaireLigne();
                  this.produitsDepot = new ProduitsDepot();
                  this.produitsDepot = (ProduitsDepot)var2.get(var5);
                  if (this.produitsDepot.getProduits().getProMode() != 5 && (this.produitsDepot.getProduits().getProAchCode() != null && !this.produitsDepot.getProduits().getProAchCode().isEmpty() && this.produitsDepot.getProduits().getProAchCode().equalsIgnoreCase(this.inventaireEntete.getInvModeSpecif()) || this.produitsDepot.getProduits().getProVteCode() != null && !this.produitsDepot.getProduits().getProVteCode().isEmpty() && this.produitsDepot.getProduits().getProVteCode().equalsIgnoreCase(this.inventaireEntete.getInvModeSpecif()))) {
                     this.inventaireLigne.setInvligCode(this.produitsDepot.getProduits().getProCode());
                     if (this.produitsDepot.getProduits().getProVteCode() != null && !this.produitsDepot.getProduits().getProVteCode().isEmpty()) {
                        this.inventaireLigne.setInvligFamille(this.produitsDepot.getProduits().getProVteCode());
                     } else {
                        this.inventaireLigne.setInvligFamille(this.produitsDepot.getProduits().getProAchCode());
                     }

                     this.inventaireLigne.setInvligLibelle(this.produitsDepot.getProduits().getProLibClient());
                     this.inventaireLigne.setInvligCondition("");
                     this.inventaireLigne.setInvligObs("");
                     this.inventaireLigne.setInvligReference("");
                     this.inventaireLigne.setInvligDescription("");
                     this.inventaireLigne.setInvligDiam(this.produitsDepot.getProduits().getProDiamInt());
                     this.inventaireLigne.setInvligHaut(this.produitsDepot.getProduits().getProEpaisseur());
                     this.inventaireLigne.setInvligLarg(this.produitsDepot.getProduits().getProLargeur());
                     this.inventaireLigne.setInvligLong(this.produitsDepot.getProduits().getProLongueur());
                     this.inventaireLigne.setInvligPoidsBrut(this.produitsDepot.getProduits().getProPoidsBrut());
                     this.inventaireLigne.setInvligPoidsNet(this.produitsDepot.getProduits().getProPoidsNet());
                     this.inventaireLigne.setInvligVolume(this.produitsDepot.getProduits().getProVolume());
                     this.inventaireLigne.setInvligNb(this.produitsDepot.getProduits().getProNbUnite());
                     this.inventaireLigne.setInvligUnite(this.produitsDepot.getProdepUnite());
                     this.inventaireLigne.setInvligPump(this.produitsDepot.getProdepPump());
                     this.inventaireLigne.setInvligQteStock(this.produitsDepot.getProdepQteStk());
                     this.inventaireLigne.setInvligCasier(this.produitsDepot.getProdepCasier());
                     this.lesLignesList.add(this.inventaireLigne);
                  }
               }
            }
         }
      } else if (this.inventaireEntete.getInvMode() == 4) {
         new ArrayList();
         this.depotAchats = new DepotAchats();
         var3 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         var4 = this.var_depot.split(":");
         this.depotAchats = var3.trouveDepot(var4[0], var1);
         if (this.depotAchats != null) {
            var2 = this.produitsDepotDao.selectProdDepByDep(this.depotAchats, var1);
            if (var2.size() != 0) {
               for(var5 = 0; var5 < var2.size(); ++var5) {
                  this.inventaireLigne = new InventaireLigne();
                  this.produitsDepot = new ProduitsDepot();
                  this.produitsDepot = (ProduitsDepot)var2.get(var5);
                  if (this.produitsDepot.getProduits().getProMode() != 5 && this.produitsDepot.getProdepQteStk() < 0.0F) {
                     this.inventaireLigne.setInvligCode(this.produitsDepot.getProduits().getProCode());
                     if (this.produitsDepot.getProduits().getProVteCode() != null && !this.produitsDepot.getProduits().getProVteCode().isEmpty()) {
                        this.inventaireLigne.setInvligFamille(this.produitsDepot.getProduits().getProVteCode());
                     } else {
                        this.inventaireLigne.setInvligFamille(this.produitsDepot.getProduits().getProAchCode());
                     }

                     this.inventaireLigne.setInvligLibelle(this.produitsDepot.getProduits().getProLibClient());
                     this.inventaireLigne.setInvligCondition("");
                     this.inventaireLigne.setInvligObs("");
                     this.inventaireLigne.setInvligReference("");
                     this.inventaireLigne.setInvligDescription("");
                     this.inventaireLigne.setInvligDiam(this.produitsDepot.getProduits().getProDiamInt());
                     this.inventaireLigne.setInvligHaut(this.produitsDepot.getProduits().getProEpaisseur());
                     this.inventaireLigne.setInvligLarg(this.produitsDepot.getProduits().getProLargeur());
                     this.inventaireLigne.setInvligLong(this.produitsDepot.getProduits().getProLongueur());
                     this.inventaireLigne.setInvligPoidsBrut(this.produitsDepot.getProduits().getProPoidsBrut());
                     this.inventaireLigne.setInvligPoidsNet(this.produitsDepot.getProduits().getProPoidsNet());
                     this.inventaireLigne.setInvligVolume(this.produitsDepot.getProduits().getProVolume());
                     this.inventaireLigne.setInvligNb(this.produitsDepot.getProduits().getProNbUnite());
                     this.inventaireLigne.setInvligUnite(this.produitsDepot.getProdepUnite());
                     this.inventaireLigne.setInvligPump(this.produitsDepot.getProdepPump());
                     this.inventaireLigne.setInvligQteStock(this.produitsDepot.getProdepQteStk());
                     this.inventaireLigne.setInvligCasier(this.produitsDepot.getProdepCasier());
                     this.lesLignesList.add(this.inventaireLigne);
                  }
               }
            }
         }
      } else if (this.inventaireEntete.getInvMode() == 6) {
         this.rechercheInventaire(var1);
      }

      this.utilInitHibernate.closeSession();
      this.datamodelLigne.setWrappedData(this.lesLignesList);
      this.addLigne();
   }

   public void ajoutDocument() throws IOException, JDOMException {
      this.inventaireEntete = new InventaireEntete();
      this.inventaireLigne = new InventaireLigne();
      this.depotAchats = new DepotAchats();
      this.inventaireEntete.setUsers(this.usersLog);
      this.inventaireEntete.setInvIdCreateur(this.usersLog.getUsrid());
      this.inventaireEntete.setInvNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.inventaireEntete.setInvIdResponsable(this.usersLog.getUsrid());
      this.inventaireEntete.setInvNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.inventaireEntete.setInvDate(new Date());
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

      this.lesLignesList.clear();
      this.var_nb_produit = 0;
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_depot = "";
      this.var_nom_responsable = 0L;
      this.var_aff_action = false;
      this.var_valide_doc = false;
      this.var_affiche_filtre = false;
      this.verrouNum = false;
      this.visibleOnglet = false;
      this.visibiliteBtonlig = true;
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
      this.chargerDocumentLigne(var1);
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.visibleOnglet = true;
      this.var_valide_doc = true;
      if (this.inventaireEntete.getInvDepot() != null && !this.inventaireEntete.getInvDepot().isEmpty()) {
         this.depotAchats = new DepotAchats();
         DepotAchatsDao var2 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         this.depotAchats = var2.trouveDepot(this.inventaireEntete.getInvDepot(), var1);
         if (this.depotAchats != null) {
            this.var_depot = this.depotAchats.getDpoCode() + ":" + this.depotAchats.getDpoLibelle();
         } else {
            this.var_depot = "";
         }
      } else {
         this.var_depot = "";
      }

      if (this.inventaireEntete.getInvIdResponsable() != 0L) {
         new Users();
         Users var3 = this.usersDao.selectByIdUsers(this.inventaireEntete.getInvIdResponsable(), var1);
         if (var3 != null) {
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

      this.utilInitHibernate.closeSession();
      this.autorisationDocument();
      this.addLigne();
   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
      this.chargerDocumentLigne(var1);
      this.var_action = 2;
      this.var_memo_action = this.var_action;
      this.var_aff_action = true;
      this.visibleOnglet = true;
      this.var_valide_doc = true;
      if (this.inventaireEntete.getInvDepot() != null && !this.inventaireEntete.getInvDepot().isEmpty()) {
         this.depotAchats = new DepotAchats();
         DepotAchatsDao var2 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         this.depotAchats = var2.trouveDepot(this.inventaireEntete.getInvDepot(), var1);
         if (this.depotAchats != null) {
            this.var_depot = this.depotAchats.getDpoCode() + ":" + this.depotAchats.getDpoLibelle();
         } else {
            this.var_depot = "";
         }
      } else {
         this.var_depot = "";
      }

      this.utilInitHibernate.closeSession();
      this.autorisationDocument();
   }

   public void valideDocument() throws HibernateException, NamingException, ParseException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
      Transaction var3 = null;

      Espion var4;
      try {
         var3 = var2.beginTransaction();
         if (this.inventaireEntete.getInvEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
            this.inventaireEntete.setInvEtat(1);
            this.inventaireEntete = this.inventaireEnteteDao.modif(this.inventaireEntete, var2);
            var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Validation manuelle inventaire (S.) N° " + this.inventaireEntete.getInvNum() + " du " + this.utilDate.dateToStringSQLLight(this.inventaireEntete.getInvDate()));
            this.espionDao.mAJEspion(var4, var2);
            this.calculStock.majInventaire(this.lesLignesList, 1, this.baseLog, var2);
         }

         var3.commit();
      } catch (HibernateException var20) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var20;
      } finally {
         var1 = true;
         this.utilInitHibernate.closeSession();
      }

      if (var1 && this.lesLignesList.size() != 0) {
         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         var4 = null;

         try {
            Transaction var22 = var2.beginTransaction();
            new OptionVentes();
            LireLesoptionsVentes var6 = new LireLesoptionsVentes();
            var6.setStrId(this.structureLog.getStrid());
            var6.lancer();
            OptionVentes var5 = var6.getOptionsVentes();

            for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
               this.inventaireLigne = (InventaireLigne)this.lesLignesList.get(var7);
               if (this.inventaireLigne.getInvligCode() != null && !this.inventaireLigne.getInvligCode().isEmpty() && this.inventaireLigne.getInvligDepot() != null && !this.inventaireLigne.getInvligDepot().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.inventaireLigne.getInvligCode(), var2);
                  if (this.produits != null) {
                     this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.produits.getProCode(), this.inventaireLigne.getInvligDepot(), var2);
                     if (this.produitsDepot != null) {
                        this.inventaireLigne = this.calculStock.chercheDernierInventaire(this.produits.getProCode(), this.inventaireLigne.getInvligDepot(), this.baseLog, var2);
                        String var8 = "";
                        if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty() && (this.produits.getProAchNat().equals("1105") || this.produits.getProAchNat().equals("0104") || this.produits.getProAchNat().equals("0105") || this.produits.getProAchNat().equals("1604") || this.produits.getProAchNat().equals("1605"))) {
                           var8 = this.produits.getProAchNat();
                        } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && (this.produits.getProVteNat().equals("1105") || this.produits.getProVteNat().equals("0104") || this.produits.getProVteNat().equals("0105") || this.produits.getProVteNat().equals("1604") || this.produits.getProVteNat().equals("1605"))) {
                           var8 = this.produits.getProVteNat();
                        } else if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty()) {
                           var8 = this.produits.getProAchNat();
                        } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
                           var8 = this.produits.getProVteNat();
                        }

                        this.produitsDepot = this.calculStock.recalculStock(var8, this.produitsDepot, this.inventaireLigne, this.produits.getProCode(), (String)null, this.inventaireLigne.getInvligDepot(), 0L, var5.getGestionStockBc(), this.baseLog, this.structureLog, var2);
                        this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var2);
                     }
                  }
               }
            }

            var22.commit();
         } catch (HibernateException var18) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var18;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void deValideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.inventaireEntete.getInvEtat() == 1 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
            this.inventaireEntete.setInvEtat(0);
            this.inventaireEntete = this.inventaireEnteteDao.modif(this.inventaireEntete, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Dévalidation manuelle inventaire (S.) N° " + this.inventaireEntete.getInvNum() + " du " + this.utilDate.dateToStringSQLLight(this.inventaireEntete.getInvDate()));
            this.espionDao.mAJEspion(var3, var1);
            this.calculStock.majInventaire(this.lesLignesList, 0, this.baseLog, var1);
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

   public void supprimerDocument() throws HibernateException, NamingException, IOException, JDOMException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesEntetesList.remove(this.inventaireEntete);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         String var3 = this.inventaireEntete.getInvNum();
         Date var4 = this.inventaireEntete.getInvDate();
         this.inventaireLigneDao.deleteAllLigne(this.inventaireEntete, var1);
         this.utilParapheur.supprimerParapheur(this.inventaireEntete.getInvId(), this.nature, var1);
         this.inventaireEnteteDao.delete(this.inventaireEntete.getInvId(), var1);
         Espion var5 = new Espion();
         var5.setUsers(this.usersLog);
         var5.setEsptype(0);
         var5.setEspdtecreat(new Date());
         var5.setEspaction("Suppression inventaire N° " + var3 + " du " + var4);
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

   public void annule() throws IOException, JDOMException {
      this.var_action = 0;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.lesLignesList.clear();
      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void  save() throws IOException, HibernateException, NamingException, Exception {
      this.calculTotaux();
      this.majAnalytique();
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.depotAchats == null) {
            DepotAchatsDao var3 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
            this.depotAchats = var3.trouveDepot(this.inventaireEntete.getInvDepot(), var1);
         }

         this.inventaireEntete.setInvDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         if (this.inventaireEntete.getUsers() == null) {
            this.inventaireEntete.setUsers(this.usersLog);
         }

         this.inventaireEntete.setInvIdEquipe(0L);
         this.inventaireEntete.setInvNomEquipe("");
         new Users();
         if (this.var_nom_responsable == 0L) {
            this.var_nom_responsable = this.usersLog.getUsrid();
         }

         Users var15 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var15 != null) {
            this.inventaireEntete.setInvIdResponsable(var15.getUsrid());
            this.inventaireEntete.setInvNomResponsable(var15.getUsrPatronyme());
            this.equipes = this.equipesDao.rechercheEquipes(this.inventaireEntete.getInvIdResponsable(), var1);
            if (this.equipes != null) {
               this.inventaireEntete.setInvIdEquipe(this.equipes.getEquId());
               this.inventaireEntete.setInvNomEquipe(this.equipes.getEquNomFr());
            }
         } else {
            this.inventaireEntete.setInvIdResponsable(0L);
            this.inventaireEntete.setInvNomResponsable("");
         }

         if (this.inventaireEntete.getInvId() != 0L) {
            if (this.inventaireEntete.getInvEtat() == 6) {
               if (this.inventaireEntete.getInvEtatVal() == 1) {
                  this.inventaireEntete.setInvEtat(0);
               } else {
                  this.inventaireEntete.setInvEtat(0);
               }
            }

            this.inventaireEntete.setInvDateModif(new Date());
            this.inventaireEntete.setInvIdModif(this.usersLog.getUsrid());
            this.inventaireEntete.setInvNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.verifieExistenceHabilitation(var1);
            this.inventaireEntete = this.inventaireEnteteDao.modif(this.inventaireEntete, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         } else {
            this.inventaireEntete.setExercicesAchats(this.exercicesAchats);
            this.inventaireEntete.setInvDateCreat(new Date());
            this.inventaireEntete.setInvIdCreateur(this.usersLog.getUsrid());
            this.inventaireEntete.setInvNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.inventaireEntete.setInvDepot(this.depotAchats.getDpoCode());
            if (!this.inventaireEntete.getInvSerie().equalsIgnoreCase("X") && !this.inventaireEntete.getInvSerie().isEmpty()) {
               this.inventaireEntete.setInvNum(this.calculChrono.numCompose(this.inventaireEntete.getInvDate(), this.nature, this.inventaireEntete.getInvSerie(), var1));
               boolean var16 = false;

               label252:
               while(true) {
                  while(true) {
                     if (var16) {
                        break label252;
                     }

                     new InventaireEntete();
                     InventaireEntete var5 = this.inventaireEnteteDao.pourParapheur(this.inventaireEntete.getInvNum(), this.inventaireEntete.getInvSerie(), var1);
                     if (var5 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.inventaireEntete.setInvNum(this.calculChrono.numCompose(this.inventaireEntete.getInvDate(), this.nature, this.inventaireEntete.getInvSerie(), var1));
                        var16 = false;
                     } else {
                        var16 = true;
                     }
                  }
               }
            } else {
               long var4 = this.inventaireEnteteDao.selectLastNum(var1);
               this.inventaireEntete.setInvNum("" + var4);
            }

            this.inventaireEntete.setInvEtat(0);
            this.inventaireEntete.setInvEtatVal(0);
            this.inventaireEntete.setInvDateValide((Date)null);
            this.inventaireEntete = this.inventaireEnteteDao.insert(this.inventaireEntete, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.inventaireEntete);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.lesLignesList.size() != 0) {
            for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
               this.inventaireLigne = (InventaireLigne)this.lesLignesList.get(var17);
               if (this.inventaireEntete.getInvDepot() != null && !this.inventaireEntete.getInvDepot().isEmpty()) {
                  if (this.inventaireEntete.getInvDepot().contains(":")) {
                     String[] var18 = this.inventaireEntete.getInvDepot().split(":");
                     this.inventaireLigne.setInvligDepot(var18[0]);
                  } else {
                     this.inventaireLigne.setInvligDepot(this.inventaireEntete.getInvDepot());
                  }
               }

               if (this.inventaireLigne.getInvligId() == 0L) {
                  this.inventaireLigne.setInventaireEntete(this.inventaireEntete);
                  this.inventaireLigne = this.inventaireLigneDao.insertLigne(this.inventaireLigne, var1);
               } else {
                  this.inventaireLigne = this.inventaireLigneDao.modifLigne(this.inventaireLigne, var1);
               }

               this.produits = this.produitsDao.chargeProduit(this.inventaireLigne.getInvligCode(), var1);
               if (this.produits == null) {
                  this.produits = new Produits();
                  this.produits.setProCode(this.inventaireLigne.getInvligCode());
                  this.produits.setProLibClient(this.inventaireLigne.getInvligLibelle());
                  this.produits.setProAchCode(this.inventaireLigne.getInvligFamille());
                  this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), this.produits, var1);
                  if (this.famillesProduitsAchats != null) {
                     this.produits.setProAchLib(this.famillesProduitsAchats.getFamachLibelleFr());
                     this.produits.setProAchNat(this.famillesProduitsAchats.getFamachNature());
                  } else {
                     this.produits.setProAchLib("");
                     this.produits.setProAchNat("");
                  }

                  this.produits.setProStock(1);
                  this.produits = this.produitsDao.insert(this.produits, var1);
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.inventaireLigne.getInvligCode(), this.inventaireLigne.getInvligDepot(), var1);
                  if (this.produitsDepot == null) {
                     this.produitsDepot = new ProduitsDepot();
                     this.produitsDepot.setDepot(this.depotAchats);
                     this.produitsDepot.setProduits(this.produits);
                     this.produitsDepot.setUnite((Unite)null);
                     this.produitsDepot.setProdepQteStk(this.inventaireLigne.getInvligQte());
                     this.produitsDepot.setProdepPump(this.inventaireLigne.getInvligPump());
                     this.produitsDepot = this.produitsDepotDao.insert(this.produitsDepot, var1);
                  }
               }
            }
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.inventaireEntete.getInvId(), this.inventaireEntete.getInvNum(), this.inventaireEntete.getInvNomResponsable(), this.inventaireEntete.getInvDate(), this.structureLog.getStrdevise(), this.inventaireEntete.getInvTotPump(), this.inventaireEntete.getInvModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.structureLog.getStrformatdevise(), 0, var1);
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

   public void calculTotaux() {
      double var1 = 0.0D;
      if (this.lesLignesList.size() != 0) {
         for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
            this.inventaireLigne = (InventaireLigne)this.lesLignesList.get(var3);
            var1 += (double)this.inventaireLigne.getInvligQte() * this.inventaireLigne.getInvligPump();
            this.inventaireLigne.setInvligTotal((double)this.inventaireLigne.getInvligQte() * this.inventaireLigne.getInvligPump());
         }
      }

      this.inventaireEntete.setInvTotPump(var1);
   }

   public void majAnalytique() throws HibernateException, NamingException {
      this.inventaireEntete.setInvSite(this.usersLog.getUsrSite());
      this.inventaireEntete.setInvDepartement(this.usersLog.getUsrDepartement());
      this.inventaireEntete.setInvService(this.usersLog.getUsrService());
      this.inventaireEntete.setInvRegion("");
      this.inventaireEntete.setInvSecteur("");
      this.inventaireEntete.setInvPdv("");
      if (!this.var_anal_activite) {
         this.inventaireEntete.setInvActivite("");
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

            this.inventaireEntete.setInvActivite(var1);
         }
      } else {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireLigne");
         String var8 = "";
         boolean var9 = true;
         new InventaireLigne();
         new Produits();
         InventaireLigne var4;
         Produits var5;
         int var6;
         if (this.decoupageActivite) {
            if (this.lesLignesList.size() != 0) {
               for(var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                  var4 = (InventaireLigne)this.lesLignesList.get(var6);
                  if (var4.getInvligCode() != null && !var4.getInvligCode().isEmpty()) {
                     var5 = this.produitsDao.chargeProduit(var4.getInvligCode(), var7);
                     if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                        if (var9) {
                           var8 = var5.getProActivite();
                           var9 = false;
                        } else {
                           var8 = var8 + "#" + var5.getProActivite();
                        }
                     }
                  }
               }
            }
         } else if (this.lesLignesList.size() != 0) {
            for(var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
               var4 = (InventaireLigne)this.lesLignesList.get(var6);
               if (var4.getInvligCode() != null && !var4.getInvligCode().isEmpty()) {
                  var5 = this.produitsDao.chargeProduit(var4.getInvligCode(), var7);
                  if (var5 != null && var5.getProActivite() != null && !var5.getProActivite().isEmpty()) {
                     if (var9) {
                        var8 = var5.getProActivite();
                        var9 = false;
                     } else {
                        var8 = var8 + "#" + var5.getProActivite();
                     }
                  }
               }
            }
         }

         this.inventaireEntete.setInvActivite(var8);
         this.utilInitHibernate.closeSession();
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.inventaireEntete.setInvEtatVal(1);
         this.inventaireEntete.setInvEtat(0);
         this.inventaireEntete.setInvDateValide((Date)null);
         return true;
      } else {
         this.inventaireEntete.setInvEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.inventaireEntete.setInvEtat(1);
               this.inventaireEntete.setInvDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.inventaireEntete.setInvEtat(0);
               this.inventaireEntete.setInvDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void verifProduitDepot() throws HibernateException, NamingException, ParseException {
      if (this.depotAchats != null && this.inventaireEntete != null && this.inventaireEntete.getInvId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            List var3 = this.produitsDepotDao.selectProdDepByDep(this.depotAchats, var1);
            if (var3.size() != 0) {
               int var4 = 0;

               while(true) {
                  if (var4 >= var3.size()) {
                     this.var_nb_produit = this.lesLignesList.size();
                     this.datamodelLigne.setWrappedData(this.lesLignesList);
                     break;
                  }

                  this.produitsDepot = (ProduitsDepot)var3.get(var4);
                  String var5 = this.produitsDepot.getProduits().getProCode();
                  boolean var6 = false;

                  for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                     if (((InventaireLigne)this.lesLignesList.get(var7)).getInvligCode().equals(var5)) {
                        var6 = true;
                        break;
                     }
                  }

                  if (!var6) {
                     this.inventaireLigne = new InventaireLigne();
                     this.inventaireLigne.setInventaireEntete(this.inventaireEntete);
                     this.inventaireLigne.setInvligCasier(this.produitsDepot.getProdepCasier());
                     this.inventaireLigne.setInvligCode(this.produitsDepot.getProduits().getProCode());
                     this.inventaireLigne.setInvligCondition("");
                     this.inventaireLigne.setInvligObs("");
                     this.inventaireLigne.setInvligReference("");
                     this.inventaireLigne.setInvligDescription("");
                     this.inventaireLigne.setInvligDepot(this.produitsDepot.getDepot().getDpoCode());
                     if (this.produitsDepot.getProduits().getProVteCode() != null && !this.produitsDepot.getProduits().getProVteCode().isEmpty()) {
                        this.inventaireLigne.setInvligFamille(this.produitsDepot.getProduits().getProVteCode());
                     } else {
                        this.inventaireLigne.setInvligFamille(this.produitsDepot.getProduits().getProAchCode());
                     }

                     this.inventaireLigne.setInvligLibelle(this.produitsDepot.getProduits().getProLibClient());
                     this.inventaireLigne.setInvligDiam(this.produitsDepot.getProduits().getProDiamInt());
                     this.inventaireLigne.setInvligHaut(this.produitsDepot.getProduits().getProEpaisseur());
                     this.inventaireLigne.setInvligLarg(this.produitsDepot.getProduits().getProLargeur());
                     this.inventaireLigne.setInvligLong(this.produitsDepot.getProduits().getProLongueur());
                     this.inventaireLigne.setInvligPoidsBrut(this.produitsDepot.getProduits().getProPoidsBrut());
                     this.inventaireLigne.setInvligPoidsNet(this.produitsDepot.getProduits().getProPoidsNet());
                     this.inventaireLigne.setInvligVolume(this.produitsDepot.getProduits().getProVolume());
                     this.inventaireLigne.setInvligNb(this.produitsDepot.getProduits().getProNbUnite());
                     this.inventaireLigne.setInvligUnite(this.produitsDepot.getProdepUnite());
                     this.inventaireLigne.setInvligPump(this.produitsDepot.getProdepPump());
                     this.inventaireLigne.setInvligQteStock(this.produitsDepot.getProdepQteStk());
                     this.inventaireLigne.setInvligCasier(this.produitsDepot.getProdepCasier());
                     this.inventaireLigne.setInvligQte(0.0F);
                     this.inventaireLigne.setInvligQteStock(0.0F);
                     this.inventaireLigne.setInvligQteUtil(0.0F);
                     this.inventaireLigne.setInvligTotal(0.0D);
                     this.inventaireLigne = this.inventaireLigneDao.insertLigne(this.inventaireLigne, var1);
                     this.lesLignesList.add(this.inventaireLigne);
                  }

                  ++var4;
               }
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

         this.addLigne();
      }

   }

   public void calculHt(Session var1) throws HibernateException, NamingException {
      if (this.inventaireLigne.getInvligQte() != 0.0F) {
         boolean var2 = false;
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
            var2 = true;
         }

         this.inventaireLigne.setInvligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.inventaireLigne.getInvligCondition(), this.inventaireLigne.getInvligQte(), this.inventaireLigne.getInvligLong(), this.inventaireLigne.getInvligLarg(), this.inventaireLigne.getInvligHaut(), this.inventaireLigne.getInvligDiam(), this.inventaireLigne.getInvligNb(), this.baseLog, this.utilInitHibernate, var1));
         if (var2) {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.inventaireLigne.setInvligQteUtil(0.0F);
      }

      double var7 = 0.0D;
      if (this.inventaireLigne.getInvligCondition() != null && !this.inventaireLigne.getInvligCondition().isEmpty() && this.inventaireLigne.getInvligCondition().contains("/")) {
         String[] var4 = this.inventaireLigne.getInvligCondition().split("/");
         String[] var5 = var4[1].split(":");
         float var6 = Float.parseFloat(var5[0]);
         if (var6 == 0.0F) {
            var6 = 1.0F;
         }

         var7 = this.inventaireLigne.getInvligPump() / (double)var6 * (double)this.inventaireLigne.getInvligQteUtil();
      } else {
         var7 = this.inventaireLigne.getInvligPump() * (double)this.inventaireLigne.getInvligQteUtil();
      }

      this.totauxPump = this.utilNombre.myRoundFormat(var7, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      this.inventaireLigne.setInvligTotal(this.totauxPump);
   }

   public void calculPrix() throws HibernateException, NamingException {
      this.calculPrix((Session)null);
   }

   public void calculPrix(Session var1) throws HibernateException, NamingException {
      this.calculHt(var1);
   }

   public void cumulPrix() {
      this.var_nb_produit = 0;
      double var1 = 0.0D;
      new InventaireLigne();

      for(int var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
         InventaireLigne var3 = (InventaireLigne)this.lesLignesList.get(var4);
         var1 += var3.getInvligTotal();
      }

      this.inventaireEntete.setInvTotPump(var1);
      this.var_nb_produit = this.lesLignesList.size();
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      if (this.datamodelLigne.isRowAvailable()) {
         this.inventaireLigne = (InventaireLigne)this.datamodelLigne.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireLigne");
         if (this.inventaireLigne.getInvligCode() != null && this.inventaireLigne.getInvligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeToutProduit(this.inventaireLigne.getInvligCode(), var1);
            if (this.produits != null) {
               this.inventaireLigne.setInvligCode(this.produits.getProCode());
               this.inventaireLigne.setInvligLibelle(this.produits.getProLibClient());
               this.inventaireLigne.setInvligFamille(this.produits.getProAchCode());
               this.inventaireLigne.setInvligStock(this.produits.getProStock());
               this.inventaireLigne.setInvligPoidsBrut(this.produits.getProPoidsBrut());
               this.inventaireLigne.setInvligPoidsNet(this.produits.getProPoidsNet());
               this.var_aff_detail_prod = true;
               this.griserchamps = false;
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.inventaireLigne.getInvligCode(), this.inventaireEntete.getInvDepot(), var1);
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

   public void addLigne() {
      this.produits = new Produits();
      this.produitsDepot = new ProduitsDepot();
      this.inventaireLigne = new InventaireLigne();
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.inventaireLigne.getInvligQte() != 0.0F || this.inventaireLigne.getInvligCode() != null && !this.inventaireLigne.getInvligCode().isEmpty() &&
              (this.inventaireLigne.getInvligCode().equals("-") || this.inventaireLigne.getInvligCode().equals("+") || this.inventaireLigne.getInvligCode().equals("="))) {
         if (this.inventaireEntete.getInvId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.calculPrix(var1);
            if (this.produits != null) {
               if (this.inventaireEntete.getInvDepot() != null && !this.inventaireEntete.getInvDepot().isEmpty()) {
                  if (this.inventaireEntete.getInvDepot().contains(":")) {
                     String[] var3 = this.inventaireEntete.getInvDepot().split(":");
                     this.inventaireLigne.setInvligDepot(var3[0]);
                  } else {
                     this.inventaireLigne.setInvligDepot(this.inventaireEntete.getInvDepot());
                  }
               }

               if (this.inventaireLigne.getInvligId() == 0L) {
                  this.inventaireLigne.setInventaireEntete(this.inventaireEntete);
                  this.inventaireLigne = this.inventaireLigneDao.insertLigne(this.inventaireLigne, var1);
                  if (this.inventaireEntete.getInvMode() == 0) {
                     this.lesLignesList.add(this.inventaireLigne);
                     this.datamodelLigne.setWrappedData(this.lesLignesList);
                  }
               } else {
                  this.inventaireLigne = this.inventaireLigneDao.modifLigne(this.inventaireLigne, var1);
               }

               this.cumulPrix();
               this.inventaireEntete = this.inventaireEnteteDao.modif(this.inventaireEntete, var1);
               this.var_nb_produit = this.lesLignesList.size();
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

   public void deleteLigneSelect() throws HibernateException, NamingException {
      if (this.inventaireLigne.getInvligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.inventaireLigne.getInvligCode();
            this.inventaireLigneDao.deleteOneLigne(this.inventaireLigne, var1);
            this.lesLignesList.remove(this.inventaireLigne);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Suppression ligne produit " + var3 + " de l'inventaire N° " + this.inventaireEntete.getInvNum() + " du " + this.inventaireEntete.getInvDate());
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

   public void extractCodeUnite() throws HibernateException, NamingException {
      this.extractCodeUnite((Session)null);
   }

   public void extractCodeUnite(Session var1) throws HibernateException, NamingException {
      if (this.inventaireLigne.getInvligUnite() != null && !this.inventaireLigne.getInvligUnite().isEmpty() && this.inventaireLigne.getInvligUnite().contains(":")) {
         String[] var2 = this.inventaireLigne.getInvligUnite().split(":");
         String var3 = var2[0];
         UniteDao var4 = new UniteDao(this.baseLog, this.utilInitHibernate);
         this.var_code_unite = var4.selectUnite(var3, var1).getUniEchelle();
      } else {
         this.var_code_unite = 0;
      }

      if (this.var_code_unite >= 500 && this.var_code_unite <= 799) {
         this.var_aff_condit = true;
      } else {
         this.var_aff_condit = false;
      }

   }

   public void listener(UploadEvent var1) throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.item = var1.getUploadItem();
      this.fileCtrl = new FileCtrl();
      this.fileCtrl.setLength(this.item.getFileSize());
      this.fileCtrl.setName(this.item.getFileName());
      this.fileCtrl.setChemin(this.item.getFile().getPath().toString());
      this.fileCtrl.setData(this.item.getData());
      this.listFiles.add(this.fileCtrl);
      --this.uploadsAvailable;
      this.importationFichier();
   }

   public void importationFichier() throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      try {
         ArrayList var1 = new ArrayList();
         if (this.listFiles.size() != 0) {
            for(int var2 = 0; var2 < this.listFiles.size(); ++var2) {
               this.fileCtrl = (FileCtrl)this.listFiles.get(var2);
               String var3 = ((FileCtrl)this.listFiles.get(var2)).getName();
               File var4 = new File(this.fileCtrl.getChemin());
               if (var4.exists()) {
                  FileReader var5 = new FileReader(var4);
                  BufferedReader var6 = new BufferedReader(var5);

                  for(String var7 = var6.readLine(); var7 != null; var7 = var6.readLine()) {
                     if (var7.contains("\"")) {
                        char[] var8 = var7.toCharArray();
                        String var9 = "";

                        for(int var10 = 0; var10 < var8.length; ++var10) {
                           if (var8[var10] != '"') {
                              var9 = var9 + var8[var10];
                           }
                        }

                        var7 = var9;
                     }

                     if (var7.contains("'")) {
                        var7.replace("'", "`");
                     }

                     var1.add(var7);
                  }

                  var6.close();
                  var5.close();
               }
            }
         }

         if (var1.size() != 0) {
            this.preparationTransfertImport(var1);
         }
      } catch (IOException var11) {
         var11.printStackTrace();
      }

   }

   public void preparationTransfertImport(List var1) throws ParseException, HibernateException, NamingException {
      this.lesTransfertPaye.clear();
      this.lesTransfertPaye = new ArrayList();
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            String var3 = (String)var1.get(var2);
            boolean var4 = false;
            String[] var5 = null;
            var5 = var3.split(",");
            int var8 = var5.length;
            if (var8 == 7) {
               this.transfertPaye = new TransfertPaye();
               this.importInventaire(var5);
            }
         }
      }

      if (this.lesTransfertPaye.size() != 0) {
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireLigne");

         for(int var7 = 0; var7 < this.lesTransfertPaye.size(); ++var7) {
            this.transfertPaye = (TransfertPaye)this.lesTransfertPaye.get(var7);
            this.inventaireLigne = new InventaireLigne();
            this.inventaireLigne.setInvligCode(this.transfertPaye.getTrfColT03());
            this.produits = this.produitsDao.chargeProduit(this.transfertPaye.getTrfColT03(), var6);
            if (this.produits == null) {
               this.produits = new Produits();
               this.produits.setProAchCode(this.transfertPaye.getTrfColT01());
               if (this.produits.getProAchCode() != null && !this.produits.getProAchCode().isEmpty()) {
                  this.produits.setProAchNat("0101");
               } else {
                  this.produits.setProAchNat("");
               }

               this.produits.setProVteCode(this.transfertPaye.getTrfColT02());
               if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
                  this.produits.setProVteNat("1601");
               } else {
                  this.produits.setProVteNat("");
               }

               this.produits.setProCode(this.transfertPaye.getTrfColT03());
               this.produits.setProLibClient(this.transfertPaye.getTrfColT04());
            }

            this.inventaireLigne.setInvligCode(this.produits.getProCode());
            this.inventaireLigne.setInvligLibelle(this.produits.getProLibClient());
            this.inventaireLigne.setInvligFamille(this.produits.getProAchCode());
            this.inventaireLigne.setInvligUnite(this.transfertPaye.getTrfColT05());
            this.inventaireLigne.setInvligQte(Float.parseFloat(this.transfertPaye.getTrfColT06()));
            this.inventaireLigne.setInvligPump(Double.parseDouble(this.transfertPaye.getTrfColT07()));
            this.inventaireLigne.setInvligTotal(this.inventaireLigne.getInvligPump() * (double)this.inventaireLigne.getInvligQte());
            this.lesLignesList.add(this.inventaireLigne);
         }

         this.utilInitHibernate.closeSession();
      }

      this.inventaireEntete.setInvMode(0);
      this.calculTotaux();
   }

   public void importInventaire(String[] var1) throws ParseException {
      if (var1[0] != null && !var1[0].isEmpty()) {
         this.transfertPaye.setTrfColT01(var1[0]);
      }

      if (var1[1] != null && !var1[1].isEmpty()) {
         this.transfertPaye.setTrfColT02(var1[1]);
      }

      if (var1[2] != null && !var1[2].isEmpty()) {
         this.transfertPaye.setTrfColT03(var1[2]);
      }

      if (var1[3] != null && !var1[3].isEmpty()) {
         this.transfertPaye.setTrfColT04(var1[3]);
      }

      if (var1[4] != null && !var1[4].isEmpty()) {
         this.transfertPaye.setTrfColT05(var1[4]);
      }

      if (var1[5] != null && !var1[5].isEmpty()) {
         this.transfertPaye.setTrfColT06(var1[5]);
      }

      if (var1[6] != null && !var1[6].isEmpty()) {
         this.transfertPaye.setTrfColT07(var1[6]);
      }

      if (this.transfertPaye.getTrfColT03() != null && !this.transfertPaye.getTrfColT03().isEmpty()) {
         this.lesTransfertPaye.add(this.transfertPaye);
      }

   }

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.rechercheProduitAchat(this.var_depot, this.inventaireLigne.getInvligCode(), "", this.nature);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireLigne");
         this.inventaireLigne.setInvligCode(this.produits.getProCode());
         this.inventaireLigne.setInvligLibelle(this.produits.getProLibClient());
         if (this.produits.getProAchCode() != null && !this.produits.getProAchCode().isEmpty()) {
            this.inventaireLigne.setInvligFamille(this.produits.getProAchCode());
         } else {
            this.inventaireLigne.setInvligFamille(this.produits.getProVteCode());
         }

         this.inventaireLigne.setInvligStock(this.produits.getProStock());
         this.inventaireLigne.setInvligLong(this.produits.getProLongueur());
         this.inventaireLigne.setInvligLarg(this.produits.getProLargeur());
         this.inventaireLigne.setInvligHaut(this.produits.getProEpaisseur());
         this.inventaireLigne.setInvligDiam(this.produits.getProDiamExt());
         this.inventaireLigne.setInvligPoidsBrut(this.produits.getProPoidsBrut());
         this.inventaireLigne.setInvligPoidsNet(this.produits.getProPoidsNet());
         this.inventaireLigne.setInvligVolume(this.produits.getProVolume());
         this.inventaireLigne.setInvligNb(this.produits.getProNbUnite());
         this.inventaireLigne.setInvligReference("");
         new ArrayList();
         List var2 = this.produitsFournisseurDao.selectProdFourByprod(this.produits, var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               if (((ProduitsFournisseur)var2.get(var3)).getProfouRef() != null && !((ProduitsFournisseur)var2.get(var3)).getProfouRef().isEmpty()) {
                  this.inventaireLigne.setInvligReference(((ProduitsFournisseur)var2.get(var3)).getProfouRef());
                  break;
               }
            }
         }

         if (this.var_depot != null && this.var_depot.contains(":")) {
            String[] var4 = this.var_depot.split(":");
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.inventaireLigne.getInvligCode(), var4[0], var1);
            if (this.produitsDepot != null) {
               this.inventaireLigne.setInvligCasier(this.produitsDepot.getProdepCasier());
               this.inventaireLigne.setInvligPump(this.produitsDepot.getProdepPump());
               this.inventaireLigne.setInvligQteStock(this.produitsDepot.getProdepQteStk());
            } else {
               this.inventaireLigne.setInvligCasier("");
               this.inventaireLigne.setInvligPump(0.0D);
               this.inventaireLigne.setInvligQteStock(0.0F);
            }
         } else {
            this.inventaireLigne.setInvligCasier("");
            this.inventaireLigne.setInvligPump(0.0D);
            this.inventaireLigne.setInvligQteStock(0.0F);
         }

         if (this.produitsDepot != null) {
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.inventaireLigne.setInvligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.inventaireLigne.setInvligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.inventaireLigne.setInvligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.inventaireLigne.setInvligCondition("");
         this.griserchamps = false;
         this.var_aff_detail_prod = true;
         this.calculPrix(var1);
         this.utilInitHibernate.closeSession();
      } else {
         this.annuleProduits();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleProduits() {
      this.produits = null;
      this.inventaireLigne.setInvligCode("");
      this.inventaireLigne.setInvligLibelle("");
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = true;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
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
      this.mesConditionnementsProduits = this.calculStock.calculConditionnementStock(this.mesConditionnementsItems, this.produits, this.produitsDepot, var1);
      if (this.mesConditionnementsProduits.size() != 0) {
         this.var_aff_condit = true;
      } else {
         this.var_aff_condit = false;
      }

      return this.mesConditionnementsProduits;
   }

   public void accesImputSerie() {
      this.var_imput_serie = this.inventaireEntete.getInvSerie();
      this.showModalPanelImput = true;
   }

   public void miseajourImput() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (!this.var_imput_serie.equalsIgnoreCase("X")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.inventaireEntete.getInvNum();
            this.inventaireEntete.setInvSerie(this.var_imput_serie);
            this.inventaireEntete.setInvNum(this.calculChrono.numCompose(this.inventaireEntete.getInvDate(), this.nature, this.inventaireEntete.getInvSerie(), var1));
            this.inventaireEnteteDao.modif(this.inventaireEntete, var1);
            new ArrayList();
            ParapheurDao var5 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            ArrayList var4 = (ArrayList)var5.parapheurDocument(this.inventaireEntete.getInvId(), this.nature, var1);
            if (var4 != null) {
               for(int var6 = 0; var6 < var4.size(); ++var6) {
                  new Parapheur();
                  Parapheur var7 = (Parapheur)var4.get(var6);
                  var7.setPhrNum(this.inventaireEntete.getInvNum());
                  var5.modif(var7, var1);
               }
            }

            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Imputation Inventaire X N° " + var3 + " en Inventaire " + this.inventaireEntete.getInvSerie() + " N° " + this.inventaireEntete.getInvNum());
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

   public void rechercheInventaire(Session var1) throws HibernateException, NamingException {
      if (this.inventaireEntete.getInvModeSpecif() != null && !this.inventaireEntete.getInvModeSpecif().isEmpty()) {
         new InventaireEntete();
         InventaireEntete var2 = this.inventaireEnteteDao.pourParapheur(this.inventaireEntete.getInvModeSpecif(), (String)null, var1);
         if (var2 == null) {
            this.inventaireEntete.setInvModeSpecif("");
         } else {
            this.inventaireEntete.setInvModeSpecif(var2.getInvNum());
            DepotAchatsDao var3 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
            this.depotAchats = var3.trouveDepot(var2.getInvDepot(), var1);
            if (this.depotAchats != null) {
               this.var_depot = this.depotAchats.getDpoCode() + ":" + this.depotAchats.getDpoLibelle();
               this.inventaireEntete.setExercicesAchats(var2.getExercicesAchats());
               this.inventaireEntete.setInvActivite(var2.getInvActivite());
               this.inventaireEntete.setInvAnal2(var2.getInvAnal2());
               this.inventaireEntete.setInvAnal4(var2.getInvAnal4());
               this.inventaireEntete.setInvDate(var2.getInvDate());
               this.var_date = var2.getInvDate();
               if (this.inventaireEntete.getInvDate().getHours() <= 9) {
                  this.var_heure = "0" + this.inventaireEntete.getInvDate().getHours();
               } else {
                  this.var_heure = "" + this.inventaireEntete.getInvDate().getHours();
               }

               if (this.inventaireEntete.getInvDate().getMinutes() <= 9) {
                  this.var_minute = "0" + this.inventaireEntete.getInvDate().getMinutes();
               } else {
                  this.var_minute = "" + this.inventaireEntete.getInvDate().getMinutes();
               }

               if (this.inventaireEntete.getInvDate().getSeconds() <= 9) {
                  this.var_seconde = "0" + this.inventaireEntete.getInvDate().getSeconds();
               } else {
                  this.var_seconde = "" + this.inventaireEntete.getInvDate().getSeconds();
               }

               this.inventaireEntete.setInvDateAnnule((Date)null);
               this.inventaireEntete.setInvDateCreat(new Date());
               this.inventaireEntete.setInvDateImp((Date)null);
               this.inventaireEntete.setInvDateModif((Date)null);
               this.inventaireEntete.setInvDateValide(var2.getInvDateValide());
               this.inventaireEntete.setInvDepartement(var2.getInvDepartement());
               this.inventaireEntete.setInvDepot(var2.getInvDepot());
               this.inventaireEntete.setInvEtat(0);
               this.inventaireEntete.setInvEtatVal(var2.getInvEtatVal());
               this.inventaireEntete.setInvGele(0);
               this.inventaireEntete.setInvIdCreateur(this.usersLog.getUsrid());
               this.inventaireEntete.setInvIdEquipe(var2.getInvIdEquipe());
               this.inventaireEntete.setInvIdModif(0L);
               this.inventaireEntete.setInvIdResponsable(var2.getInvIdResponsable());
               this.var_nom_responsable = var2.getInvIdResponsable();
               this.inventaireEntete.setInvInfo1(var2.getInvInfo1());
               this.inventaireEntete.setInvInfo2(var2.getInvInfo2());
               this.inventaireEntete.setInvInfo3(var2.getInvInfo3());
               this.inventaireEntete.setInvInfo4(var2.getInvInfo4());
               this.inventaireEntete.setInvInfo5(var2.getInvInfo5());
               this.inventaireEntete.setInvInfo6(var2.getInvInfo6());
               this.inventaireEntete.setInvInfo7(var2.getInvInfo7());
               this.inventaireEntete.setInvInfo8(var2.getInvInfo8());
               this.inventaireEntete.setInvInfo9(var2.getInvInfo9());
               this.inventaireEntete.setInvInfo10(var2.getInvInfo10());
               this.inventaireEntete.setInvMode(6);
               this.inventaireEntete.setInvModeleImp(var2.getInvModeleImp());
               this.inventaireEntete.setInvMotifAnnule((String)null);
               this.inventaireEntete.setInvNomCreateur(var2.getInvNomCreateur());
               this.inventaireEntete.setInvNomEquipe(var2.getInvNomEquipe());
               this.inventaireEntete.setInvNomModif((String)null);
               this.inventaireEntete.setInvNomResponsable(var2.getInvNomResponsable());
               this.inventaireEntete.setInvNum("");
               this.inventaireEntete.setInvObject(var2.getInvObject());
               this.inventaireEntete.setInvPdv(var2.getInvPdv());
               this.inventaireEntete.setInvPosSignature(0);
               this.inventaireEntete.setInvRegion(var2.getInvRegion());
               this.inventaireEntete.setInvSecteur(var2.getInvSecteur());
               this.inventaireEntete.setInvSerie(var2.getInvSerie());
               this.inventaireEntete.setInvService(var2.getInvService());
               this.inventaireEntete.setInvSite(var2.getInvSite());
               this.inventaireEntete.setInvTotPump(0.0D);
               this.inventaireEntete.setInvType(var2.getInvType());
               new ArrayList();
               List var4 = this.produitsDepotDao.selectProdDepByDep(this.depotAchats, var1);
               new ArrayList();
               List var5 = this.inventaireLigneDao.chargerLesLignes(var2, var1);
               this.lesLignesList.clear();
               int var6;
               if (var5.size() != 0) {
                  if (var4.size() != 0) {
                     for(var6 = 0; var6 < var4.size(); ++var6) {
                        String var7 = ((ProduitsDepot)var4.get(var6)).getProduits().getProCode();
                        boolean var8 = false;

                        for(int var9 = 0; var9 < var5.size(); ++var9) {
                           if (var7.equals(((InventaireLigne)var5.get(var9)).getInvligCode())) {
                              var8 = true;
                              break;
                           }
                        }

                        if (!var8) {
                           this.inventaireLigne = new InventaireLigne();
                           this.inventaireLigne.setInventaireEntete((InventaireEntete)null);
                           this.inventaireLigne.setInvligCasier(((ProduitsDepot)var4.get(var6)).getProdepCasier());
                           this.inventaireLigne.setInvligCode(((ProduitsDepot)var4.get(var6)).getProduits().getProCode());
                           this.inventaireLigne.setInvligCondition("");
                           this.inventaireLigne.setInvligDepot(var2.getInvDepot());
                           this.inventaireLigne.setInvligDescription("");
                           this.inventaireLigne.setInvligDiam(((ProduitsDepot)var4.get(var6)).getProduits().getProDiamInt());
                           if (((ProduitsDepot)var4.get(var6)).getProduits().getProVteCode() != null && !((ProduitsDepot)var4.get(var6)).getProduits().getProVteCode().isEmpty()) {
                              this.inventaireLigne.setInvligFamille(((ProduitsDepot)var4.get(var6)).getProduits().getProVteCode());
                           } else {
                              this.inventaireLigne.setInvligFamille(((ProduitsDepot)var4.get(var6)).getProduits().getProAchCode());
                           }

                           this.inventaireLigne.setInvligHaut(((ProduitsDepot)var4.get(var6)).getProduits().getProEpaisseur());
                           this.inventaireLigne.setInvligLarg(((ProduitsDepot)var4.get(var6)).getProduits().getProLargeur());
                           this.inventaireLigne.setInvligLibelle(((ProduitsDepot)var4.get(var6)).getProduits().getProLibClient());
                           this.inventaireLigne.setInvligLong(((ProduitsDepot)var4.get(var6)).getProduits().getProLongueur());
                           this.inventaireLigne.setInvligLot("");
                           this.inventaireLigne.setInvligNb(((ProduitsDepot)var4.get(var6)).getProduits().getProNbUnite());
                           this.inventaireLigne.setInvligNumSerie("");
                           this.inventaireLigne.setInvligObs("");
                           this.inventaireLigne.setInvligPoidsBrut(((ProduitsDepot)var4.get(var6)).getProduits().getProPoidsBrut());
                           this.inventaireLigne.setInvligPoidsNet(((ProduitsDepot)var4.get(var6)).getProduits().getProPoidsNet());
                           this.inventaireLigne.setInvligPump(((ProduitsDepot)var4.get(var6)).getProdepPump());
                           this.inventaireLigne.setInvligQte(0.0F);
                           this.inventaireLigne.setInvligQteStock(0.0F);
                           this.inventaireLigne.setInvligQteUtil(0.0F);
                           this.inventaireLigne.setInvligReference("");
                           this.inventaireLigne.setInvligStock(((ProduitsDepot)var4.get(var6)).getProduits().getProStock());
                           this.inventaireLigne.setInvligTotal(0.0D);
                           this.inventaireLigne.setInvligUnite(this.produitsDepot.getProdepUnite());
                           this.inventaireLigne.setInvligValide(false);
                           this.inventaireLigne.setInvligVolume(((ProduitsDepot)var4.get(var6)).getProduits().getProVolume());
                           this.lesLignesList.add(this.inventaireLigne);
                        }
                     }
                  }
               } else if (var4.size() != 0) {
                  for(var6 = 0; var6 < var4.size(); ++var6) {
                     this.inventaireLigne = new InventaireLigne();
                     this.inventaireLigne.setInventaireEntete((InventaireEntete)null);
                     this.inventaireLigne.setInvligCasier(((ProduitsDepot)var4.get(var6)).getProdepCasier());
                     this.inventaireLigne.setInvligCode(((ProduitsDepot)var4.get(var6)).getProduits().getProCode());
                     this.inventaireLigne.setInvligCondition("");
                     this.inventaireLigne.setInvligDepot(var2.getInvDepot());
                     this.inventaireLigne.setInvligDescription("");
                     this.inventaireLigne.setInvligDiam(((ProduitsDepot)var4.get(var6)).getProduits().getProDiamInt());
                     if (((ProduitsDepot)var4.get(var6)).getProduits().getProVteCode() != null && !((ProduitsDepot)var4.get(var6)).getProduits().getProVteCode().isEmpty()) {
                        this.inventaireLigne.setInvligFamille(((ProduitsDepot)var4.get(var6)).getProduits().getProVteCode());
                     } else {
                        this.inventaireLigne.setInvligFamille(((ProduitsDepot)var4.get(var6)).getProduits().getProAchCode());
                     }

                     this.inventaireLigne.setInvligHaut(((ProduitsDepot)var4.get(var6)).getProduits().getProEpaisseur());
                     this.inventaireLigne.setInvligLarg(((ProduitsDepot)var4.get(var6)).getProduits().getProLargeur());
                     this.inventaireLigne.setInvligLibelle(((ProduitsDepot)var4.get(var6)).getProduits().getProLibClient());
                     this.inventaireLigne.setInvligLong(((ProduitsDepot)var4.get(var6)).getProduits().getProLongueur());
                     this.inventaireLigne.setInvligLot("");
                     this.inventaireLigne.setInvligNb(((ProduitsDepot)var4.get(var6)).getProduits().getProNbUnite());
                     this.inventaireLigne.setInvligNumSerie("");
                     this.inventaireLigne.setInvligObs("");
                     this.inventaireLigne.setInvligPoidsBrut(((ProduitsDepot)var4.get(var6)).getProduits().getProPoidsBrut());
                     this.inventaireLigne.setInvligPoidsNet(((ProduitsDepot)var4.get(var6)).getProduits().getProPoidsNet());
                     this.inventaireLigne.setInvligPump(((ProduitsDepot)var4.get(var6)).getProdepPump());
                     this.inventaireLigne.setInvligQte(0.0F);
                     this.inventaireLigne.setInvligQteStock(0.0F);
                     this.inventaireLigne.setInvligQteUtil(0.0F);
                     this.inventaireLigne.setInvligReference("");
                     this.inventaireLigne.setInvligStock(((ProduitsDepot)var4.get(var6)).getProduits().getProStock());
                     this.inventaireLigne.setInvligTotal(0.0D);
                     this.inventaireLigne.setInvligUnite(this.produitsDepot.getProdepUnite());
                     this.inventaireLigne.setInvligValide(false);
                     this.inventaireLigne.setInvligVolume(((ProduitsDepot)var4.get(var6)).getProduits().getProVolume());
                     this.lesLignesList.add(this.inventaireLigne);
                  }
               }
            }
         }

         if (this.lesLignesList.size() != 0) {
            this.var_nb_produit = this.lesLignesList.size();
         } else {
            this.var_nb_produit = 0;
         }

         this.var_valide_doc = true;
         this.var_aff_action = false;
      } else {
         this.var_valide_doc = false;
         this.var_aff_action = true;
      }

   }

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "inventaire" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      if (this.inventaireEntete.getInvEtat() == 0) {
         File var3 = new File(this.calculeCheminSousRapport(var1) + "formatEncours.jpg");
         if (var3.exists()) {
            var2 = "formatEncours.jpg";
         }
      }

      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            var1.add(this.lesLignesList.get(var2));
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.inventaireEntete.getInvTotPump(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
      return var3;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.inventaireEntete.getInvAnal2() != null && !this.inventaireEntete.getInvAnal2().isEmpty()) {
         String var4 = "";
         if (this.inventaireEntete.getInvAnal2().contains(":")) {
            String[] var5 = this.inventaireEntete.getInvAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.inventaireEntete.getInvAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireLigne");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.inventaireEntete.getInvDateImp() != null) {
            var2 = true;
         }

         boolean var5 = false;
         this.inventaireEntete.setInvDateImp(new Date());
         if (this.inventaireEntete.getInvEtat() == 0 && this.inventaireEntete.getInvEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.inventaireEntete.setInvEtat(1);
            var5 = true;
         }

         this.inventaireEntete.setInvModeleImp(var1);
         this.inventaireEntete = this.inventaireEnteteDao.modif(this.inventaireEntete, var3);
         if (var5) {
            this.calculStock = new CalculStock();
            this.calculStock.majInventaire(this.lesLignesList, 1, this.baseLog, var3);
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
            var1.setEntete("Impression inventaire");
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionAchats.getNbDecQte());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.inventaireEntete.getInvIdResponsable());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.inventaireEntete.getInvId());
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des inventaires");
         var1.setTotauxTtc("" + this.totauxPump);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "liste" + File.separator + "inventaire" + File.separator);
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
            this.uniteGraph = "INVENTAIRES : Total PUMP en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "INVENTAIRES : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = Integer.parseInt(this.optionAchats.getNbDecQte());
         }

         this.titreGraph = "Analyse des mouvements inventaires : ";
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

         if (this.timeDecoupage == 5) {
            this.titreGraph = this.titreGraph + " Par tranches horaires";
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

         new InventaireEntete();
         new InventaireLigne();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireLigne");
         String var6 = "";

         InventaireEntete var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (InventaireEntete)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getInvNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getInvNum() + "'";
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

                  var14 = (InventaireEntete)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getInvDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getInvNomResponsable() != null && !var14.getInvNomResponsable().isEmpty()) {
                        var17 = var14.getInvNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var14.getInvNomEquipe() != null && !var14.getInvNomEquipe().isEmpty()) {
                        var17 = var14.getInvNomEquipe();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  }

                  var20 = (long)var14.getInvTotPump();
                  if (this.timeDecoupage == 0) {
                     var18 = var14.getInvDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getInvDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getInvDate().getMonth() + 1 >= 1 && var14.getInvDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getInvDate().getMonth() + 1 >= 4 && var14.getInvDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getInvDate().getMonth() + 1 >= 7 && var14.getInvDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getInvDate().getMonth() + 1 >= 10 && var14.getInvDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getInvDate().getMonth() + 1 >= 1 && var14.getInvDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getInvDate().getMonth() + 1 >= 7 && var14.getInvDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getInvDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.inventaireLigneDao.chargerLesLignesInv(var6, var5);
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

                  InventaireLigne var15 = (InventaireLigne)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getInventaireEntete().getInvDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getInventaireEntete().getInvNomResponsable() != null && !var15.getInventaireEntete().getInvNomResponsable().isEmpty()) {
                        var8 = var15.getInventaireEntete().getInvNomResponsable();
                     } else {
                        var8 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getInventaireEntete().getInvNomEquipe() != null && !var15.getInventaireEntete().getInvNomEquipe().isEmpty()) {
                        var8 = var15.getInventaireEntete().getInvNomEquipe();
                     } else {
                        var8 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getInvligFamille() != null && !var15.getInvligFamille().isEmpty()) {
                        var8 = var15.getInvligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getInvligLibelle() != null && !var15.getInvligLibelle().isEmpty()) {
                        var8 = var15.getInvligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getInvligTotal();
                  } else {
                     var9 = (long)this.utilNombre.myRound(var15.getInvligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getInventaireEntete().getInvDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getInventaireEntete().getInvDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getInventaireEntete().getInvDate().getMonth() + 1 >= 1 && var15.getInventaireEntete().getInvDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getInventaireEntete().getInvDate().getMonth() + 1 >= 4 && var15.getInventaireEntete().getInvDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getInventaireEntete().getInvDate().getMonth() + 1 >= 7 && var15.getInventaireEntete().getInvDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getInventaireEntete().getInvDate().getMonth() + 1 >= 10 && var15.getInventaireEntete().getInvDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getInventaireEntete().getInvDate().getMonth() + 1 >= 1 && var15.getInventaireEntete().getInvDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getInventaireEntete().getInvDate().getMonth() + 1 >= 7 && var15.getInventaireEntete().getInvDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getInventaireEntete().getInvDate().getHours();
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

   public InventaireEntete getInventaireEntete() {
      return this.inventaireEntete;
   }

   public void setInventaireEntete(InventaireEntete var1) {
      this.inventaireEntete = var1;
   }

   public InventaireLigne getInventaireLigne() {
      return this.inventaireLigne;
   }

   public void setInventaireLigne(InventaireLigne var1) {
      this.inventaireLigne = var1;
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

   public int getVar_anal_dossier() {
      return this.var_anal_dossier;
   }

   public void setVar_anal_dossier(int var1) {
      this.var_anal_dossier = var1;
   }

   public ExercicesComptable getLastExoCompta() {
      return this.lastExoCompta;
   }

   public void setLastExoCompta(ExercicesComptable var1) {
      this.lastExoCompta = var1;
   }

   public double getMontantPump() {
      return this.montantPump;
   }

   public void setMontantPump(double var1) {
      this.montantPump = var1;
   }

   public String getVar_depot() {
      return this.var_depot;
   }

   public void setVar_depot(String var1) {
      this.var_depot = var1;
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

   public int getVar_nb_produit() {
      return this.var_nb_produit;
   }

   public void setVar_nb_produit(int var1) {
      this.var_nb_produit = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getUploadsAvailable() {
      return this.uploadsAvailable;
   }

   public void setUploadsAvailable(int var1) {
      this.uploadsAvailable = var1;
   }

   public double getSoldeImputation() {
      return this.soldeImputation;
   }

   public void setSoldeImputation(double var1) {
      this.soldeImputation = var1;
   }

   public SimpleSelection getSimpleSelectionEntete() {
      return this.simpleSelectionEntete;
   }

   public void setSimpleSelectionEntete(SimpleSelection var1) {
      this.simpleSelectionEntete = var1;
   }

   public UIDataTable getExtDTable() {
      return this.extDTable;
   }

   public void setExtDTable(UIDataTable var1) {
      this.extDTable = var1;
   }
}
