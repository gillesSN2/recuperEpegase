package com.epegase.forms.stock;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.BonEntreeEntete;
import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.Habilitation;
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
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.BonEntreeEnteteDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ServiceDao;
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

public class FormBonEntree implements Serializable {
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
   private BonEntreeEntete bonEntreeEntete = new BonEntreeEntete();
   private BonEntreeEnteteDao bonEntreeEnteteDao;
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
   private DepotAchats depotAchats = new DepotAchats();
   private BonEntreeLigne bonEntreeLigne = new BonEntreeLigne();
   private BonEntreeLigneDao bonEntreeLigneDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private double totauxPump = 0.0D;
   private boolean griserchamps = false;
   private ServiceDao serviceDao;
   private Produits produits;
   private ProduitsAchsDao produitsDao;
   private ProduitsDepot produitsDepot = new ProduitsDepot();
   private ProduitsDepotDao produitsDepotDao;
   private FamillesProduitsAchatsDao famillesProduitsAchatsDao;
   private FamillesProduitsAchats famillesProduitsAchats;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsMclesDao produitsMclesDao;
   private String var_depot;
   private long var_nom_responsable;
   private long var_nom_rapporteur;
   private List lesRapporteurItems;
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
   private String verrouDepotUser;

   public FormBonEntree() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.bonEntreeEnteteDao = new BonEntreeEnteteDao(this.baseLog, this.utilInitHibernate);
      this.bonEntreeLigneDao = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
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

      if (this.optionAchats.getAxeChantier().equals("true")) {
         this.var_anal_chantier = true;
      } else {
         this.var_anal_chantier = false;
      }

      this.periode = this.optionStocks.getAffichInGlobViewBIN();
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
      if (this.inpDepot != null && !this.inpDepot.isEmpty()) {
         String[] var7;
         if (this.inpDepot.equals("100") && this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
            var7 = this.verrouDepotUser.split(",");
            int var8 = var7.length;

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
         this.lesEntetesList = this.bonEntreeEnteteDao.recherche(var1, this.exercicesAchats.getExeachId(), this.getInpNum(), var6, this.getInpEtat(), this.getInpSerie(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), "", this.getInpActivite(), var4, var5);
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);

         for(int var10 = 0; var10 < this.lesEntetesList.size(); ++var10) {
            new BonEntreeEntete();
            BonEntreeEntete var11 = (BonEntreeEntete)this.lesEntetesList.get(var10);
            var2 += var11.getBinTotPump();
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
            this.bonEntreeEntete = (BonEntreeEntete)var1.get(0);
            this.var_date = this.bonEntreeEntete.getBinDate();
            if (this.bonEntreeEntete.getBinDate().getHours() <= 9) {
               this.var_heure = "0" + this.bonEntreeEntete.getBinDate().getHours();
            } else {
               this.var_heure = "" + this.bonEntreeEntete.getBinDate().getHours();
            }

            if (this.bonEntreeEntete.getBinDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.bonEntreeEntete.getBinDate().getMinutes();
            } else {
               this.var_minute = "" + this.bonEntreeEntete.getBinDate().getMinutes();
            }

            if (this.bonEntreeEntete.getBinDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.bonEntreeEntete.getBinDate().getSeconds();
            } else {
               this.var_seconde = "" + this.bonEntreeEntete.getBinDate().getSeconds();
            }

            this.var_nom_responsable = this.bonEntreeEntete.getBinIdResponsable();
            if (this.var_nom_responsable == 0L) {
               this.var_nom_responsable = this.usersLog.getUsrid();
            }

            this.var_nom_rapporteur = this.bonEntreeEntete.getBinIdRapporteur();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEnteteLight");
            this.chargerDocumentLigne(var4);
            this.chargerUserChrono(var4);
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            this.utilInitHibernate.closeSession();
            this.montantPump = this.bonEntreeEntete.getBinTotPump();
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
      if (this.bonEntreeEntete != null) {
         if (this.bonEntreeEntete.getBinEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.bonEntreeEntete.getBinId() > 0L) {
         this.lesLignesList = this.bonEntreeLigneDao.chargerLesLignes(this.bonEntreeEntete, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.bonEntreeEntete != null && this.bonEntreeEntete.getBinSerie() != null && !this.bonEntreeEntete.getBinSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.bonEntreeEntete.getBinSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.bonEntreeEntete.getBinActivite() != null && !this.bonEntreeEntete.getBinActivite().isEmpty() && this.bonEntreeEntete.getBinActivite().contains(":")) {
         String[] var1 = null;
         if (!this.bonEntreeEntete.getBinActivite().contains("#")) {
            var1 = this.bonEntreeEntete.getBinActivite().split(":");
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
            String[] var2 = this.bonEntreeEntete.getBinActivite().split("#");

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
         double var1 = this.utilNombre.myRoundDevise(this.bonEntreeEntete.getBinTotPump() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
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

      this.soldeImputation = this.bonEntreeEntete.getBinTotPump() - this.totalImputation;
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

   public void ajoutDocument() throws IOException, JDOMException {
      this.bonEntreeEntete = new BonEntreeEntete();
      this.bonEntreeLigne = new BonEntreeLigne();
      this.depotAchats = new DepotAchats();
      this.bonEntreeEntete.setUsers(this.usersLog);
      this.bonEntreeEntete.setBinIdCreateur(this.usersLog.getUsrid());
      this.bonEntreeEntete.setBinNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.bonEntreeEntete.setBinIdResponsable(this.usersLog.getUsrid());
      this.bonEntreeEntete.setBinNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.bonEntreeEntete.setBinDate(new Date());
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
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_depot = "";
      this.var_nom_responsable = 0L;
      this.var_nom_rapporteur = 0L;
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEnteteLight");
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.visibleOnglet = true;
      this.var_valide_doc = true;
      if (this.bonEntreeEntete.getBinDepot() != null && !this.bonEntreeEntete.getBinDepot().isEmpty()) {
         if (!this.bonEntreeEntete.getBinDepot().contains(":")) {
            this.depotAchats = new DepotAchats();
            DepotAchatsDao var2 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
            this.depotAchats = var2.trouveDepot(this.bonEntreeEntete.getBinDepot(), var1);
            if (this.depotAchats != null) {
               this.var_depot = this.depotAchats.getDpoCode() + ":" + this.depotAchats.getDpoLibelle();
            } else {
               this.var_depot = "";
            }
         } else {
            this.var_depot = this.bonEntreeEntete.getBinDepot();
         }
      } else {
         this.var_depot = "";
      }

      this.utilInitHibernate.closeSession();
      this.autorisationDocument();
      this.addLigne();
   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEnteteLight");
      this.var_action = 2;
      this.var_memo_action = this.var_action;
      this.var_aff_action = true;
      this.visibleOnglet = true;
      this.var_valide_doc = true;
      if (!this.bonEntreeEntete.getBinDepot().contains(":")) {
         this.depotAchats = new DepotAchats();
         DepotAchatsDao var2 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         this.depotAchats = var2.trouveDepot(this.bonEntreeEntete.getBinDepot(), var1);
         if (this.depotAchats != null) {
            this.var_depot = this.depotAchats.getDpoCode() + ":" + this.depotAchats.getDpoLibelle();
         } else {
            this.var_depot = "";
         }
      } else {
         this.var_depot = this.bonEntreeEntete.getBinDepot();
      }

      this.utilInitHibernate.closeSession();
      this.autorisationDocument();
   }

   public void valideDocument() throws HibernateException, NamingException, ParseException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEnteteLight");
      Transaction var3 = null;

      Espion var4;
      try {
         var3 = var2.beginTransaction();
         if (this.bonEntreeEntete.getBinEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
            this.bonEntreeEntete.setBinEtat(1);
            this.bonEntreeEntete = this.bonEntreeEnteteDao.modif(this.bonEntreeEntete, var2);
            var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Validation manuelle bon entrée (S.) N° " + this.bonEntreeEntete.getBinNum() + " du " + this.utilDate.dateToStringSQLLight(this.bonEntreeEntete.getBinDate()));
            this.espionDao.mAJEspion(var4, var2);
            this.calculStock.majBonEntree((List)this.lesLignesList, 1, this.baseLog, var2);
         }

         var3.commit();
      } catch (HibernateException var21) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var21;
      } finally {
         var1 = true;
         this.utilInitHibernate.closeSession();
      }

      if (var1 && this.lesLignesList.size() != 0) {
         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         var4 = null;

         try {
            Transaction var23 = var2.beginTransaction();
            new OptionVentes();
            LireLesoptionsVentes var6 = new LireLesoptionsVentes();
            var6.setStrId(this.structureLog.getStrid());
            var6.lancer();
            OptionVentes var5 = var6.getOptionsVentes();
            new InventaireLigne();

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               this.bonEntreeLigne = (BonEntreeLigne)this.lesLignesList.get(var8);
               if (this.bonEntreeLigne.getBinligCode() != null && !this.bonEntreeLigne.getBinligCode().isEmpty() && this.bonEntreeLigne.getBinligDepot() != null && !this.bonEntreeLigne.getBinligDepot().isEmpty()) {
                  this.produits = this.produitsDao.chargeProduit(this.bonEntreeLigne.getBinligCode(), var2);
                  if (this.produits != null) {
                     this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.produits.getProCode(), this.bonEntreeLigne.getBinligDepot(), var2);
                     if (this.produitsDepot != null) {
                        InventaireLigne var7 = this.calculStock.chercheDernierInventaire(this.produits.getProCode(), this.bonEntreeLigne.getBinligDepot(), this.baseLog, var2);
                        String var9 = "";
                        if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty() && (this.produits.getProAchNat().equals("1105") || this.produits.getProAchNat().equals("0104") || this.produits.getProAchNat().equals("0105") || this.produits.getProAchNat().equals("1604") || this.produits.getProAchNat().equals("1605"))) {
                           var9 = this.produits.getProAchNat();
                        } else if (this.produits.getProVteNat() == null || this.produits.getProVteNat().isEmpty() || !this.produits.getProVteNat().equals("1105") && !this.produits.getProVteNat().equals("0104") && !this.produits.getProVteNat().equals("0105") && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1605")) {
                           if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty()) {
                              var9 = this.produits.getProAchNat();
                           } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
                              var9 = this.produits.getProVteNat();
                           }
                        } else {
                           var9 = this.produits.getProVteNat();
                        }

                        this.produitsDepot = this.calculStock.recalculStock(var9, this.produitsDepot, var7, this.produits.getProCode(), (String)null, this.bonEntreeLigne.getBinligDepot(), 0L, var5.getGestionStockBc(), this.baseLog, this.structureLog, var2);
                        this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var2);
                     }
                  }
               }
            }

            var23.commit();
         } catch (HibernateException var19) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void deValideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.bonEntreeEntete.getBinEtat() == 1 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
            this.bonEntreeEntete.setBinEtat(0);
            this.bonEntreeEntete = this.bonEntreeEnteteDao.modif(this.bonEntreeEntete, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Dévalidation manuelle bon entrée (S.) N° " + this.bonEntreeEntete.getBinNum() + " du " + this.utilDate.dateToStringSQLLight(this.bonEntreeEntete.getBinDate()));
            this.espionDao.mAJEspion(var3, var1);
            this.calculStock.majBonEntree((List)this.lesLignesList, 0, this.baseLog, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesEntetesList.remove(this.bonEntreeEntete);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         String var3 = this.bonEntreeEntete.getBinNum();
         Date var4 = this.bonEntreeEntete.getBinDate();
         this.bonEntreeLigneDao.deleteAllLigne(this.bonEntreeEntete, var1);
         this.utilParapheur.supprimerParapheur(this.bonEntreeEntete.getBinId(), this.nature, var1);
         this.bonEntreeEnteteDao.delete(this.bonEntreeEntete.getBinId(), var1);
         Espion var5 = new Espion();
         var5.setUsers(this.usersLog);
         var5.setEsptype(0);
         var5.setEspdtecreat(new Date());
         var5.setEspaction("Suppression bon entrée N° " + var3 + " du " + var4);
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

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.majAnalytique();
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEnteteLight");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.bonEntreeEntete.setBinDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         if (this.bonEntreeEntete.getUsers() == null) {
            this.bonEntreeEntete.setUsers(this.usersLog);
         }

         this.bonEntreeEntete.setBinIdEquipe(0L);
         this.bonEntreeEntete.setBinNomEquipe("");
         new Users();
         if (this.var_nom_responsable == 0L) {
            this.var_nom_responsable = this.usersLog.getUsrid();
         }

         Users var3 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var3 != null) {
            this.bonEntreeEntete.setBinIdResponsable(var3.getUsrid());
            this.bonEntreeEntete.setBinNomResponsable(var3.getUsrPatronyme());
            this.equipes = this.equipesDao.rechercheEquipes(this.bonEntreeEntete.getBinIdResponsable(), var1);
            if (this.equipes != null) {
               this.bonEntreeEntete.setBinIdEquipe(this.equipes.getEquId());
               this.bonEntreeEntete.setBinNomEquipe(this.equipes.getEquNomFr());
            }
         } else {
            this.bonEntreeEntete.setBinIdResponsable(0L);
            this.bonEntreeEntete.setBinNomResponsable("");
         }

         Users var15;
         if (this.optionStocks.getDemandeurRapporteur().equals("0")) {
            new Users();
            var15 = this.usersDao.selectUserD(this.var_nom_rapporteur, var1);
            if (var15 != null) {
               this.bonEntreeEntete.setBinIdRapporteur(var15.getUsrid());
               this.bonEntreeEntete.setBinNomRapporteur(var15.getUsrPatronyme());
            } else {
               this.bonEntreeEntete.setBinIdRapporteur(0L);
               this.bonEntreeEntete.setBinNomRapporteur("");
            }
         } else if (this.optionStocks.getDemandeurRapporteur().equals("1")) {
            new Users();
            var15 = this.usersDao.selectUserD(this.var_nom_rapporteur, var1);
            if (var15 != null) {
               this.bonEntreeEntete.setBinIdRapporteur(var15.getUsrid());
               this.bonEntreeEntete.setBinNomRapporteur(var15.getUsrPatronyme());
            } else {
               this.bonEntreeEntete.setBinIdRapporteur(0L);
               this.bonEntreeEntete.setBinNomRapporteur("");
            }
         } else if (this.optionStocks.getDemandeurRapporteur().equals("2")) {
            new Users();
            var15 = this.usersDao.selectUserD(this.var_nom_rapporteur, var1);
            if (var15 != null) {
               this.bonEntreeEntete.setBinIdRapporteur(var15.getUsrid());
               this.bonEntreeEntete.setBinNomRapporteur(var15.getUsrPatronyme());
            } else {
               this.bonEntreeEntete.setBinIdRapporteur(0L);
               this.bonEntreeEntete.setBinNomRapporteur("");
            }
         } else if (!this.optionStocks.getDemandeurRapporteur().equals("3")) {
            if (this.optionStocks.getDemandeurRapporteur().equals("4")) {
            }
         } else {
            String var4 = "";
            long var5 = 0L;

            for(int var7 = 0; var7 < this.lesRapporteurItems.size(); ++var7) {
               var5 = Long.parseLong(((SelectItem)this.lesRapporteurItems.get(var7)).getValue().toString());
               if (var5 == this.var_nom_rapporteur) {
                  var4 = ((SelectItem)this.lesRapporteurItems.get(var7)).getLabel().toString();
                  break;
               }
            }

            this.bonEntreeEntete.setBinIdRapporteur(this.var_nom_rapporteur);
            this.bonEntreeEntete.setBinNomRapporteur(var4);
         }

         if (this.bonEntreeEntete.getBinId() != 0L) {
            if (this.bonEntreeEntete.getBinEtat() == 6) {
               if (this.bonEntreeEntete.getBinEtatVal() == 1) {
                  this.bonEntreeEntete.setBinEtat(0);
               } else {
                  this.bonEntreeEntete.setBinEtat(0);
               }
            }

            this.bonEntreeEntete.setBinDateModif(new Date());
            this.bonEntreeEntete.setBinIdModif(this.usersLog.getUsrid());
            this.bonEntreeEntete.setBinNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.verifieExistenceHabilitation(var1);
            this.bonEntreeEntete = this.bonEntreeEnteteDao.modif(this.bonEntreeEntete, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         } else {
            this.bonEntreeEntete.setExercicesAchats(this.exercicesAchats);
            this.bonEntreeEntete.setBinDateCreat(new Date());
            this.bonEntreeEntete.setBinIdCreateur(this.usersLog.getUsrid());
            this.bonEntreeEntete.setBinNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.bonEntreeEntete.setBinDepot(this.depotAchats.getDpoCode());
            if (!this.bonEntreeEntete.getBinSerie().equalsIgnoreCase("X") && !this.bonEntreeEntete.getBinSerie().isEmpty()) {
               this.bonEntreeEntete.setBinNum(this.calculChrono.numCompose(this.bonEntreeEntete.getBinDate(), this.nature, this.bonEntreeEntete.getBinSerie(), var1));
               boolean var18 = false;

               label262:
               while(true) {
                  while(true) {
                     if (var18) {
                        break label262;
                     }

                     new BonEntreeEntete();
                     BonEntreeEntete var16 = this.bonEntreeEnteteDao.pourParapheur(this.bonEntreeEntete.getBinNum(), this.bonEntreeEntete.getBinSerie(), var1);
                     if (var16 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.bonEntreeEntete.setBinNum(this.calculChrono.numCompose(this.bonEntreeEntete.getBinDate(), this.nature, this.bonEntreeEntete.getBinSerie(), var1));
                        var18 = false;
                     } else {
                        var18 = true;
                     }
                  }
               }
            } else {
               long var17 = this.bonEntreeEnteteDao.selectLastNum(var1);
               this.bonEntreeEntete.setBinNum("" + var17);
            }

            this.bonEntreeEntete.setBinEtat(0);
            this.bonEntreeEntete.setBinEtatVal(0);
            this.bonEntreeEntete.setBinDateValide((Date)null);
            this.bonEntreeEntete = this.bonEntreeEnteteDao.insert(this.bonEntreeEntete, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.bonEntreeEntete);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.bonEntreeEntete.getBinId(), this.bonEntreeEntete.getBinNum(), this.bonEntreeEntete.getBinNomResponsable(), this.bonEntreeEntete.getBinDate(), this.structureLog.getStrdevise(), this.bonEntreeEntete.getBinTotPump(), this.bonEntreeEntete.getBinModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.structureLog.getStrformatdevise(), 0, var1);
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
      this.bonEntreeEntete.setBinSite(this.usersLog.getUsrSite());
      this.bonEntreeEntete.setBinDepartement(this.usersLog.getUsrDepartement());
      this.bonEntreeEntete.setBinService(this.usersLog.getUsrService());
      this.bonEntreeEntete.setBinRegion("");
      this.bonEntreeEntete.setBinSecteur("");
      this.bonEntreeEntete.setBinPdv("");
      if (!this.var_anal_activite) {
         this.bonEntreeEntete.setBinActivite("");
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

            this.bonEntreeEntete.setBinActivite(var1);
         }
      } else {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeLigne");
         String var8 = "";
         boolean var9 = true;
         new BonEntreeLigne();
         new Produits();
         BonEntreeLigne var4;
         Produits var5;
         int var6;
         if (this.decoupageActivite) {
            if (this.lesLignesList.size() != 0) {
               for(var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                  var4 = (BonEntreeLigne)this.lesLignesList.get(var6);
                  if (var4.getBinligCode() != null && !var4.getBinligCode().isEmpty()) {
                     var5 = this.produitsDao.chargeProduit(var4.getBinligCode(), var7);
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
               var4 = (BonEntreeLigne)this.lesLignesList.get(var6);
               if (var4.getBinligCode() != null && !var4.getBinligCode().isEmpty()) {
                  var5 = this.produitsDao.chargeProduit(var4.getBinligCode(), var7);
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

         this.bonEntreeEntete.setBinActivite(var8);
         this.utilInitHibernate.closeSession();
      }

      if (this.bonEntreeEntete.getBinAnal1() != null && this.bonEntreeEntete.getBinAnal1().length() <= 2) {
         this.bonEntreeEntete.setBinAnal1("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.bonEntreeEntete.setBinEtatVal(1);
         this.bonEntreeEntete.setBinEtat(0);
         this.bonEntreeEntete.setBinDateValide((Date)null);
         return true;
      } else {
         this.bonEntreeEntete.setBinEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.bonEntreeEntete.setBinEtat(1);
               this.bonEntreeEntete.setBinDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.bonEntreeEntete.setBinEtat(0);
               this.bonEntreeEntete.setBinDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void calculHt(Session var1) throws HibernateException, NamingException {
      if (this.bonEntreeLigne.getBinligQte() != 0.0F) {
         boolean var2 = false;
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEnteteLight");
            var2 = true;
         }

         this.bonEntreeLigne.setBinligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.bonEntreeLigne.getBinligCondition(), this.bonEntreeLigne.getBinligQte(), this.bonEntreeLigne.getBinligLong(), this.bonEntreeLigne.getBinligLarg(), this.bonEntreeLigne.getBinligHaut(), this.bonEntreeLigne.getBinligDiam(), this.bonEntreeLigne.getBinligNb(), this.baseLog, this.utilInitHibernate, var1));
         if (var2) {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.bonEntreeLigne.setBinligQteUtil(0.0F);
      }

      double var7 = 0.0D;
      if (this.bonEntreeLigne.getBinligCondition() != null && !this.bonEntreeLigne.getBinligCondition().isEmpty() && this.bonEntreeLigne.getBinligCondition().contains("/")) {
         String[] var4 = this.bonEntreeLigne.getBinligCondition().split("/");
         String[] var5 = var4[1].split(":");
         float var6 = Float.parseFloat(var5[0]);
         if (var6 == 0.0F) {
            var6 = 1.0F;
         }

         var7 = this.bonEntreeLigne.getBinligPump() / (double)var6 * (double)this.bonEntreeLigne.getBinligQteUtil();
      } else {
         var7 = this.bonEntreeLigne.getBinligPump() * (double)this.bonEntreeLigne.getBinligQteUtil();
      }

      this.totauxPump = this.utilNombre.myRoundFormat(var7, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      this.bonEntreeLigne.setBinligTotal(this.totauxPump);
   }

   public void calculPrix() throws HibernateException, NamingException {
      this.calculPrix((Session)null);
   }

   public void calculPrix(Session var1) throws HibernateException, NamingException {
      this.calculHt(var1);
   }

   public void cumulPrix() {
      double var1 = 0.0D;
      new BonEntreeLigne();

      for(int var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
         BonEntreeLigne var3 = (BonEntreeLigne)this.lesLignesList.get(var4);
         var1 += var3.getBinligTotal();
      }

      this.bonEntreeEntete.setBinTotPump(var1);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      if (this.datamodelLigne.isRowAvailable()) {
         this.bonEntreeLigne = (BonEntreeLigne)this.datamodelLigne.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeLigne");
         if (this.bonEntreeLigne.getBinligCode() != null && this.bonEntreeLigne.getBinligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeToutProduit(this.bonEntreeLigne.getBinligCode(), var1);
            if (this.produits != null) {
               this.bonEntreeLigne.setBinligCode(this.produits.getProCode());
               this.bonEntreeLigne.setBinligLibelle(this.produits.getProLibClient());
               this.bonEntreeLigne.setBinligFamille(this.produits.getProAchCode());
               this.bonEntreeLigne.setBinligStock(this.produits.getProStock());
               this.bonEntreeLigne.setBinligPoidsBrut(this.produits.getProPoidsBrut());
               this.bonEntreeLigne.setBinligPoidsNet(this.produits.getProPoidsNet());
               this.var_aff_detail_prod = true;
               this.griserchamps = true;
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.bonEntreeLigne.getBinligCode(), this.bonEntreeEntete.getBinDepot(), var1);
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
      this.bonEntreeLigne = new BonEntreeLigne();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.bonEntreeLigne.getBinligQte() != 0.0F || this.bonEntreeLigne.getBinligCode() != null && !this.bonEntreeLigne.getBinligCode().isEmpty() && (this.bonEntreeLigne.getBinligCode().equals("-") || this.bonEntreeLigne.getBinligCode().equals("+") || this.bonEntreeLigne.getBinligCode().equals("="))) {
         if (this.bonEntreeEntete.getBinId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.calculPrix(var1);
            if (this.produits != null) {
               String[] var3 = this.bonEntreeEntete.getBinDepot().split(":");
               this.bonEntreeLigne.setBinligDepot(var3[0]);
               if (this.bonEntreeLigne.getBinligId() == 0L) {
                  this.bonEntreeLigne.setBonEntreeEntete(this.bonEntreeEntete);
                  this.bonEntreeLigne = this.bonEntreeLigneDao.insertLigne(this.bonEntreeLigne, var1);
                  this.lesLignesList.add(this.bonEntreeLigne);
                  this.datamodelLigne.setWrappedData(this.lesLignesList);
               } else {
                  this.bonEntreeLigne = this.bonEntreeLigneDao.modifLigne(this.bonEntreeLigne, var1);
               }

               this.cumulPrix();
               this.bonEntreeEntete = this.bonEntreeEnteteDao.modif(this.bonEntreeEntete, var1);
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
      if (this.bonEntreeLigne.getBinligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.bonEntreeLigne.getBinligCode();
            this.bonEntreeLigneDao.deleteOneLigne(this.bonEntreeLigne, var1);
            this.lesLignesList.remove(this.bonEntreeLigne);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Suppression ligne produit " + var3 + " du bon d'entrée N° " + this.bonEntreeEntete.getBinNum() + " du " + this.bonEntreeEntete.getBinDate());
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
      if (this.bonEntreeLigne.getBinligUnite() != null && !this.bonEntreeLigne.getBinligUnite().isEmpty() && this.bonEntreeLigne.getBinligUnite().contains(":")) {
         String[] var2 = this.bonEntreeLigne.getBinligUnite().split(":");
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

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.rechercheProduitAchat(this.var_depot, this.bonEntreeLigne.getBinligCode(), "", this.nature);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeLigne");
         this.bonEntreeLigne.setBinligCode(this.produits.getProCode());
         this.bonEntreeLigne.setBinligLibelle(this.produits.getProLibClient());
         if (this.produits.getProAchCode() != null && !this.produits.getProAchCode().isEmpty()) {
            this.bonEntreeLigne.setBinligFamille(this.produits.getProAchCode());
         } else {
            this.bonEntreeLigne.setBinligFamille(this.produits.getProVteCode());
         }

         this.bonEntreeLigne.setBinligStock(this.produits.getProStock());
         this.bonEntreeLigne.setBinligLong(this.produits.getProLongueur());
         this.bonEntreeLigne.setBinligLarg(this.produits.getProLargeur());
         this.bonEntreeLigne.setBinligHaut(this.produits.getProEpaisseur());
         this.bonEntreeLigne.setBinligDiam(this.produits.getProDiamExt());
         this.bonEntreeLigne.setBinligPoidsBrut(this.produits.getProPoidsBrut());
         this.bonEntreeLigne.setBinligPoidsNet(this.produits.getProPoidsNet());
         this.bonEntreeLigne.setBinligVolume(this.produits.getProVolume());
         this.bonEntreeLigne.setBinligNb(this.produits.getProNbUnite());
         this.bonEntreeLigne.setBinligReference("");
         new ArrayList();
         List var2 = this.produitsFournisseurDao.selectProdFourByprod(this.produits, var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               if (((ProduitsFournisseur)var2.get(var3)).getProfouRef() != null && !((ProduitsFournisseur)var2.get(var3)).getProfouRef().isEmpty()) {
                  this.bonEntreeLigne.setBinligReference(((ProduitsFournisseur)var2.get(var3)).getProfouRef());
                  break;
               }
            }
         }

         if (this.var_depot != null && this.var_depot.contains(":")) {
            String[] var4 = this.var_depot.split(":");
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.bonEntreeLigne.getBinligCode(), var4[0], var1);
            if (this.produitsDepot != null) {
               this.bonEntreeLigne.setBinligCasier(this.produitsDepot.getProdepCasier());
               this.bonEntreeLigne.setBinligPump(this.produitsDepot.getProdepPump());
               if (this.optionStocks.getChoixStock().equals("1")) {
                  this.bonEntreeLigne.setBinligQteStock(this.produitsDepot.getProdepQteStk() + this.produitsDepot.getProdepQteAttAch());
               } else {
                  this.bonEntreeLigne.setBinligQteStock(this.produitsDepot.getProdepQteStk());
               }
            } else {
               this.bonEntreeLigne.setBinligCasier("");
               this.bonEntreeLigne.setBinligPump(0.0D);
               this.bonEntreeLigne.setBinligQteStock(0.0F);
            }
         } else {
            this.bonEntreeLigne.setBinligCasier("");
            this.bonEntreeLigne.setBinligPump(0.0D);
            this.bonEntreeLigne.setBinligQteStock(0.0F);
         }

         if (this.produitsDepot != null) {
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.bonEntreeLigne.setBinligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.bonEntreeLigne.setBinligUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.bonEntreeLigne.setBinligUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.bonEntreeLigne.setBinligCondition("");
         this.griserchamps = true;
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
      this.bonEntreeLigne.setBinligCode("");
      this.bonEntreeLigne.setBinligLibelle("");
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
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

   public void ouvertureLot() {
   }

   public void ouvertureSerie() {
   }

   public void accesImputSerie() {
      this.var_imput_serie = this.bonEntreeEntete.getBinSerie();
      this.showModalPanelImput = true;
   }

   public void miseajourImput() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (!this.var_imput_serie.equalsIgnoreCase("X")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.bonEntreeEntete.getBinNum();
            this.bonEntreeEntete.setBinSerie(this.var_imput_serie);
            this.bonEntreeEntete.setBinNum(this.calculChrono.numCompose(this.bonEntreeEntete.getBinDate(), this.nature, this.bonEntreeEntete.getBinSerie(), var1));
            this.bonEntreeEnteteDao.modif(this.bonEntreeEntete, var1);
            new ArrayList();
            ParapheurDao var5 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            ArrayList var4 = (ArrayList)var5.parapheurDocument(this.bonEntreeEntete.getBinId(), this.nature, var1);
            if (var4 != null) {
               for(int var6 = 0; var6 < var4.size(); ++var6) {
                  new Parapheur();
                  Parapheur var7 = (Parapheur)var4.get(var6);
                  var7.setPhrNum(this.bonEntreeEntete.getBinNum());
                  var5.modif(var7, var1);
               }
            }

            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Imputation Bon entrée X N° " + var3 + " en Bon entrée " + this.bonEntreeEntete.getBinSerie() + " N° " + this.bonEntreeEntete.getBinNum());
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
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_entree" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      if (this.bonEntreeEntete.getBinEtat() == 0) {
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

      this.montant_lettre = this.utilNombre.begin(this.bonEntreeEntete.getBinTotPump(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
      return var3;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.bonEntreeEntete.getBinAnal2() != null && !this.bonEntreeEntete.getBinAnal2().isEmpty()) {
         String var4 = "";
         if (this.bonEntreeEntete.getBinAnal2().contains(":")) {
            String[] var5 = this.bonEntreeEntete.getBinAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.bonEntreeEntete.getBinAnal2();
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeLigne");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.bonEntreeEntete.getBinDateImp() != null) {
            var2 = true;
         }

         boolean var5 = false;
         this.bonEntreeEntete.setBinDateImp(new Date());
         if (this.bonEntreeEntete.getBinEtat() == 0 && this.bonEntreeEntete.getBinEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.bonEntreeEntete.setBinEtat(1);
            var5 = true;
         }

         this.bonEntreeEntete.setBinModeleImp(var1);
         this.bonEntreeEntete = this.bonEntreeEnteteDao.modif(this.bonEntreeEntete, var3);
         if (var5) {
            this.calculStock = new CalculStock();
            this.calculStock.majBonEntree((List)this.lesLignesList, 1, this.baseLog, var3);
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
            var1.setEntete("Impression bon entrée");
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
            var1.setIdResponsable(this.bonEntreeEntete.getBinIdResponsable());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.bonEntreeEntete.getBinId());
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des bons d'entrée");
         var1.setTotauxTtc("" + this.totauxPump);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "liste" + File.separator + "bon_entree" + File.separator);
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
            this.uniteGraph = "BONS ENTREE : Total PUMP en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "BONS ENTREE : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = Integer.parseInt(this.optionAchats.getNbDecQte());
         }

         this.titreGraph = "Analyse des mouvements entrées : ";
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

         new BonEntreeEntete();
         new BonEntreeLigne();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeLigne");
         String var6 = "";

         BonEntreeEntete var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (BonEntreeEntete)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getBinNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getBinNum() + "'";
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

                  var14 = (BonEntreeEntete)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getBinDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getBinNomResponsable() != null && !var14.getBinNomResponsable().isEmpty()) {
                        var17 = var14.getBinNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var14.getBinNomEquipe() != null && !var14.getBinNomEquipe().isEmpty()) {
                        var17 = var14.getBinNomEquipe();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  }

                  var20 = (long)var14.getBinTotPump();
                  if (this.timeDecoupage == 0) {
                     var18 = var14.getBinDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getBinDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getBinDate().getMonth() + 1 >= 1 && var14.getBinDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getBinDate().getMonth() + 1 >= 4 && var14.getBinDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getBinDate().getMonth() + 1 >= 7 && var14.getBinDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getBinDate().getMonth() + 1 >= 10 && var14.getBinDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getBinDate().getMonth() + 1 >= 1 && var14.getBinDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getBinDate().getMonth() + 1 >= 7 && var14.getBinDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getBinDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.bonEntreeLigneDao.chargerLesLignesBin(var6, var5);
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

                  BonEntreeLigne var15 = (BonEntreeLigne)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getBonEntreeEntete().getBinDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getBonEntreeEntete().getBinNomResponsable() != null && !var15.getBonEntreeEntete().getBinNomResponsable().isEmpty()) {
                        var8 = var15.getBonEntreeEntete().getBinNomResponsable();
                     } else {
                        var8 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getBonEntreeEntete().getBinNomEquipe() != null && !var15.getBonEntreeEntete().getBinNomEquipe().isEmpty()) {
                        var8 = var15.getBonEntreeEntete().getBinNomEquipe();
                     } else {
                        var8 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getBinligFamille() != null && !var15.getBinligFamille().isEmpty()) {
                        var8 = var15.getBinligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getBinligLibelle() != null && !var15.getBinligLibelle().isEmpty()) {
                        var8 = var15.getBinligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getBinligTotal();
                  } else {
                     var9 = (long)this.utilNombre.myRound(var15.getBinligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getBonEntreeEntete().getBinDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getBonEntreeEntete().getBinDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getBonEntreeEntete().getBinDate().getMonth() + 1 >= 1 && var15.getBonEntreeEntete().getBinDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getBonEntreeEntete().getBinDate().getMonth() + 1 >= 4 && var15.getBonEntreeEntete().getBinDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getBonEntreeEntete().getBinDate().getMonth() + 1 >= 7 && var15.getBonEntreeEntete().getBinDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getBonEntreeEntete().getBinDate().getMonth() + 1 >= 10 && var15.getBonEntreeEntete().getBinDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getBonEntreeEntete().getBinDate().getMonth() + 1 >= 1 && var15.getBonEntreeEntete().getBinDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getBonEntreeEntete().getBinDate().getMonth() + 1 >= 7 && var15.getBonEntreeEntete().getBinDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getBonEntreeEntete().getBinDate().getHours();
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

   public BonEntreeEntete getBonEntreeEntete() {
      return this.bonEntreeEntete;
   }

   public void setBonEntreeEntete(BonEntreeEntete var1) {
      this.bonEntreeEntete = var1;
   }

   public BonEntreeLigne getBonEntreeLigne() {
      return this.bonEntreeLigne;
   }

   public void setBonEntreeLigne(BonEntreeLigne var1) {
      this.bonEntreeLigne = var1;
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

   public long getVar_nom_rapporteur() {
      return this.var_nom_rapporteur;
   }

   public void setVar_nom_rapporteur(long var1) {
      this.var_nom_rapporteur = var1;
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

   public List getLesRapporteurItems() {
      return this.lesRapporteurItems;
   }

   public void setLesRapporteurItems(List var1) {
      this.lesRapporteurItems = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
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

   public boolean isVar_anal_chantier() {
      return this.var_anal_chantier;
   }

   public void setVar_anal_chantier(boolean var1) {
      this.var_anal_chantier = var1;
   }
}
