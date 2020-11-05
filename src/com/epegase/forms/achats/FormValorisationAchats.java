package com.epegase.forms.achats;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.classe.BonSortieLigne;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.DouanesPosition;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.FabricationLigneAchats;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.FraisLigneAchats;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.NoteDebitLigneAchats;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.PumpAchats;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.SommierEnteteAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.DouanesPositionDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.InventaireLigneDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.PumpAchatsDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.SommierEnteteAchatsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionAchats;
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

public class FormValorisationAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private OptionAchats optionAchats;
   private ExercicesAchats exercicesAchats;
   private ExercicesAchats lastExoAchats;
   private ExercicesComptable lastExoCompta;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_nb_max = 100;
   private Date var_date;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private ValorisationEnteteAchats valorisationEnteteAchats = new ValorisationEnteteAchats();
   private ValorisationEnteteAchatsDao valorisationEnteteAchatsDao;
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
   private int var_num_ligne = 0;
   private UtilDate utilDate = new UtilDate();
   private ProduitsDepot produitsDepot;
   private ProduitsDepotDao produitsDepotDao;
   private String inpSerie = "100";
   private String inpService = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpDossier = "";
   private String inpActivite = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private boolean verrouDate = false;
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
   private Habilitation habilitation;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private List listeDocument = new ArrayList();
   private transient DataModel datamodelElementNonValo = new ListDataModel();
   private boolean showModalPanelNonValo = false;
   private DocumentEntete documentEntete = new DocumentEntete();
   private int var_choix_document;
   private CommandeEnteteAchats commandeEnteteAchats = new CommandeEnteteAchats();
   private CommandeLigneAchats commandeLigneAchats = new CommandeLigneAchats();
   private List commandeListe = new ArrayList();
   private CommandeEnteteAchatsDao commandeEnteteAchatsDao;
   private CommandeLigneAchatsDao commandeLigneAchatsDao;
   private transient DataModel datamodelCommande = new ListDataModel();
   private ReceptionEnteteAchats receptionEnteteAchats = new ReceptionEnteteAchats();
   private ReceptionLigneAchats receptionLigneAchats = new ReceptionLigneAchats();
   private List receptionListe = new ArrayList();
   private ReceptionEnteteAchatsDao receptionEnteteAchatsDao;
   private ReceptionLigneAchatsDao receptionLigneAchatsDao;
   private transient DataModel datamodelReception = new ListDataModel();
   private NoteDebitEnteteAchats noteDebitEnteteAchats = new NoteDebitEnteteAchats();
   private List noteDebitListe = new ArrayList();
   private NoteDebitEnteteAchatsDao noteDebitEnteteAchatsDao;
   private NoteDebitLigneAchatsDao noteDebitLigneAchatsDao;
   private transient DataModel datamodelNdb = new ListDataModel();
   private transient DataModel datamodelReacheminement = new ListDataModel();
   private FraisEnteteAchats fraisEnteteAchats = new FraisEnteteAchats();
   private List fraisList = new ArrayList();
   private FraisEnteteAchatsDao fraisEnteteAchatsDao;
   private transient DataModel datamodelFrais = new ListDataModel();
   private boolean showModalPanelFais = false;
   private transient DataModel datamodelDetailFrais = new ListDataModel();
   private List listCommandeProduit = new ArrayList();
   private List listReceptionProduit = new ArrayList();
   private transient DataModel dataModelDetailValo = new ListDataModel();
   private Tiers tiers = new Tiers();
   private TiersDao tiersDao;
   private int typeTiers;
   private boolean var_depot_famille;
   private boolean showModalPanelDouane = false;
   private DouanesPosition douanesPosition = new DouanesPosition();
   private DouanesPositionDao douanesPositionDao;
   private transient DataModel datamodelDouane = new ListDataModel();
   private String var_num_palette;
   private String var_num_carton;
   private boolean choixType;
   private transient DataModel dataModelEcriture = new ListDataModel();
   private FactureEnteteVentes factureEnteteVentes;
   private List listFactureVentes = new ArrayList();
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private transient DataModel datamodelFactureVentes = new ListDataModel();
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private int var_imput_choix;
   private String var_imput_num;

   public FormValorisationAchats() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.valorisationEnteteAchatsDao = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteAchatsDao = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.commandeLigneAchatsDao = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionEnteteAchatsDao = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionLigneAchatsDao = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteAchatsDao = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitLigneAchatsDao = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.fraisEnteteAchatsDao = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.douanesPositionDao = new DouanesPositionDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void configAchats() {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
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

      this.periode = "100";
      this.verrouDate = false;
      this.initPage();
   }

   public void accesResteintUser() {
      this.visibiliteBton = false;
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
            } else if (var1.getCode().equals("56")) {
               this.var_acc_verification = true;
            } else if (var1.getCode().equals("57")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("58")) {
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

   public void autorisationFrais() throws HibernateException, NamingException {
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

      this.chargerDocumentFrais((Session)null);
   }

   public void autorisationCalcul() {
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

   public void autorisationHabilitation() {
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

   public void autorisationEtat() {
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
            }
         }
      }

   }

   public void initPage() {
      this.var_action = 0;
      this.montantPump = 0.0D;
      this.inpSerie = "100";
      this.inpService = "100";
      this.inpEtat = 0;
      this.lesEntetesList.clear();
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
         this.inpDossier = "";
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
      this.var_nb_ligne = 0;
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

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      if (this.inpEtat != 50) {
         this.lesEntetesList = this.valorisationEnteteAchatsDao.recherche(var1, this.exercicesAchats.getExeachId(), this.inpNum, this.inpEtat, this.periode, this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), this.inpDossier, var2, var3);
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete = new ListDataModel();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new ValorisationEnteteAchats();

         for(int var5 = 0; var5 < this.lesEntetesList.size(); ++var5) {
            ValorisationEnteteAchats var4 = (ValorisationEnteteAchats)this.lesEntetesList.get(var5);
         }

         this.var_nb_ligne = this.lesEntetesList.size();
      }

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
            this.valorisationEnteteAchats = (ValorisationEnteteAchats)var1.get(0);
            this.var_num_ligne = this.clauleNumlLigne();
            this.var_date = this.valorisationEnteteAchats.getValDate();
            this.selectionLigneSuite();
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

   public void selectionLigneSuite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
      this.chargerCommandeAchats(var1);
      this.chargerReceptionAchats(var1);
      this.chargerNoteDebitAchats(var1);
      this.chargerReexpeditionAchats(var1);
      this.chargerDocumentFrais(var1);
      this.chargerDocumentVentes(var1);
      this.chargerDetailAchats(var1);
      this.chargerUserChrono(var1);
      this.chargerParapheur(var1);
      this.utilInitHibernate.closeSession();
   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.valorisationEnteteAchats != null) {
         if (this.valorisationEnteteAchats.getValEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public int clauleNumlLigne() {
      int var1 = 0;
      if (this.lesEntetesList.size() != 0) {
         for(int var2 = 0; var2 < this.lesEntetesList.size(); ++var2) {
            if (this.valorisationEnteteAchats.getValId() == ((ValorisationEnteteAchats)this.lesEntetesList.get(var2)).getValId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void chargerCommandeAchats(Session var1) throws HibernateException, NamingException {
      this.commandeListe.clear();
      if (this.valorisationEnteteAchats.getValId() > 0L && this.valorisationEnteteAchats.getValNum() != null && !this.valorisationEnteteAchats.getValNum().isEmpty()) {
         if (this.optionAchats.getAxeDossier().equals("2")) {
            this.commandeListe = this.commandeEnteteAchatsDao.rechercheByAffaire(this.valorisationEnteteAchats.getValDossierTransit(), this.valorisationEnteteAchats.getValAnalytique(), var1);
         } else {
            this.commandeListe = this.commandeEnteteAchatsDao.rechercheByDossier(this.valorisationEnteteAchats.getValDossierTransit(), var1);
         }
      }

      this.datamodelCommande.setWrappedData(this.commandeListe);
   }

   public void chargerReceptionAchats(Session var1) throws HibernateException, NamingException {
      this.receptionListe.clear();
      if (this.valorisationEnteteAchats.getValId() > 0L && this.valorisationEnteteAchats.getValNum() != null && !this.valorisationEnteteAchats.getValNum().isEmpty()) {
         if (this.optionAchats.getAxeDossier().equals("2")) {
            this.receptionListe = this.receptionEnteteAchatsDao.rechercheByAffaire(this.valorisationEnteteAchats.getValDossierTransit(), this.valorisationEnteteAchats.getValAnalytique(), var1);
         } else {
            this.receptionListe = this.receptionEnteteAchatsDao.rechercheByDossier(this.valorisationEnteteAchats.getValDossierTransit(), var1);
         }
      }

      this.datamodelReception.setWrappedData(this.receptionListe);
   }

   public void chargerNoteDebitAchats(Session var1) throws HibernateException, NamingException {
      this.noteDebitListe.clear();
      if (this.valorisationEnteteAchats.getValId() > 0L && this.valorisationEnteteAchats.getValNum() != null && !this.valorisationEnteteAchats.getValNum().isEmpty()) {
         if (this.optionAchats.getAxeDossier().equals("2")) {
            this.noteDebitListe = this.noteDebitEnteteAchatsDao.rechercheByAffaire(this.valorisationEnteteAchats.getValDossierTransit(), this.valorisationEnteteAchats.getValAnalytique(), var1);
         } else {
            this.noteDebitListe = this.noteDebitEnteteAchatsDao.rechercheByDossier(this.valorisationEnteteAchats.getValDossierTransit(), var1);
         }
      }

      this.datamodelNdb.setWrappedData(this.noteDebitListe);
   }

   public void chargerDetailAchats(Session var1) throws HibernateException, NamingException {
      this.listCommandeProduit.clear();
      this.listReceptionProduit.clear();
      if (this.valorisationEnteteAchats.getValId() > 0L && this.valorisationEnteteAchats.getValNum() != null && !this.valorisationEnteteAchats.getValNum().isEmpty()) {
         int var2;
         List var3;
         int var4;
         if (this.valorisationEnteteAchats.getValNature1() == 12) {
            if (this.commandeListe.size() != 0) {
               for(var2 = 0; var2 < this.commandeListe.size(); ++var2) {
                  new ArrayList();
                  var3 = this.commandeLigneAchatsDao.chargerLesLignes((CommandeEnteteAchats)this.commandeListe.get(var2), var1);
                  if (var3.size() != 0) {
                     for(var4 = 0; var4 < var3.size(); ++var4) {
                        if (((CommandeLigneAchats)var3.get(var4)).getCmdligQte() != 0.0F) {
                           this.listCommandeProduit.add(var3.get(var4));
                        }
                     }
                  }
               }
            }

            this.dataModelDetailValo.setWrappedData(this.listCommandeProduit);
         } else if (this.valorisationEnteteAchats.getValNature1() == 13) {
            if (this.receptionListe.size() != 0) {
               for(var2 = 0; var2 < this.receptionListe.size(); ++var2) {
                  if (!((ReceptionEnteteAchats)this.receptionListe.get(var2)).isRecExcluValo()) {
                     new ArrayList();
                     var3 = this.receptionLigneAchatsDao.chargerLesLignes((ReceptionEnteteAchats)this.receptionListe.get(var2), var1);
                     if (var3.size() != 0) {
                        for(var4 = 0; var4 < var3.size(); ++var4) {
                           if (((ReceptionLigneAchats)var3.get(var4)).getRecligQte() != 0.0F) {
                              this.listReceptionProduit.add(var3.get(var4));
                           }
                        }
                     }
                  }
               }
            }

            this.dataModelDetailValo.setWrappedData(this.listReceptionProduit);
         }
      }

   }

   public void chargerReexpeditionAchats(Session var1) {
      this.datamodelReacheminement.setWrappedData((Object)null);
   }

   public void chargerDocumentFrais(Session var1) throws HibernateException, NamingException {
      this.fraisList.clear();
      if (this.valorisationEnteteAchats.getValId() > 0L && this.valorisationEnteteAchats.getValNum() != null && !this.valorisationEnteteAchats.getValNum().isEmpty()) {
         if (this.optionAchats.getAxeDossier().equals("2")) {
            this.fraisList = this.fraisEnteteAchatsDao.rechercheByAffaire(this.valorisationEnteteAchats.getValDossierTransit(), this.valorisationEnteteAchats.getValAnalytique(), var1);
         } else {
            this.fraisList = this.fraisEnteteAchatsDao.rechercheByDossier(this.valorisationEnteteAchats.getValDossierTransit(), var1);
         }
      }

      this.datamodelFrais.setWrappedData(this.fraisList);
   }

   public void chargerDocumentVentes(Session var1) throws HibernateException, NamingException {
      this.listFactureVentes.clear();
      if (this.optionAchats.getAxeDossier().equals("2") && this.valorisationEnteteAchats.getValId() > 0L && this.valorisationEnteteAchats.getValDossierTransit() != null && !this.valorisationEnteteAchats.getValDossierTransit().isEmpty() && this.valorisationEnteteAchats.getValAnalytique() != null && !this.valorisationEnteteAchats.getValAnalytique().isEmpty()) {
         this.listFactureVentes = this.factureEnteteVentesDao.rechercheByAffaire(this.valorisationEnteteAchats.getValDossierTransit(), this.valorisationEnteteAchats.getValAnalytique(), var1);
      }

      this.datamodelFactureVentes.setWrappedData(this.listFactureVentes);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.valorisationEnteteAchats != null && this.valorisationEnteteAchats.getValSerie() != null && !this.valorisationEnteteAchats.getValSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.valorisationEnteteAchats.getValSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.valorisationEnteteAchats.getValId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.valorisationEnteteAchats != null) {
         new ArrayList();
         EcrituresDao var2 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         String var3 = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.valorisationEnteteAchats.getValId();
         List var1 = var2.ChargerLesEcrituresRecherche(var3, (Session)null);
         this.dataModelEcriture.setWrappedData(var1);
      }

   }

   public void ajoutDocument() throws IOException, JDOMException {
      this.valorisationEnteteAchats = new ValorisationEnteteAchats();
      this.parapheur = new Parapheur();
      this.valorisationEnteteAchats.setUsers(this.usersLog);
      this.valorisationEnteteAchats.setValIdCreateur(this.usersLog.getUsrid());
      this.valorisationEnteteAchats.setValNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.valorisationEnteteAchats.setValIdResponsable(this.usersLog.getUsrid());
      this.valorisationEnteteAchats.setValNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.valorisationEnteteAchats.setValDate(new Date());
      this.var_date = new Date();
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.var_valide_doc = true;
      this.var_affiche_filtre = false;
      this.verrouNum = false;
      this.visibiliteBtonlig = true;
      this.autorisationDocument();
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.var_valide_doc = true;
      this.autorisationDocument();
   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      this.var_action = 2;
      this.var_memo_action = this.var_action;
      this.var_aff_action = true;
      this.var_valide_doc = true;
      this.autorisationDocument();
   }

   public void valideDocument() throws HibernateException, NamingException, ParseException {
      if (this.valorisationEnteteAchats != null) {
         boolean var1 = true;
         if (this.receptionListe.size() != 0) {
            this.receptionEnteteAchats = new ReceptionEnteteAchats();

            for(int var2 = 0; var2 < this.receptionListe.size(); ++var2) {
               this.receptionEnteteAchats = (ReceptionEnteteAchats)this.receptionListe.get(var2);
               if (this.receptionEnteteAchats.getRecCoefValo() == 0.0F && this.receptionEnteteAchats.getRecValorisation() == 0) {
                  var1 = false;
                  break;
               }
            }
         }

         if (!var1) {
            this.formRecherche.setMessageTexte("La valorisation n'a pas été correctement faite. Veuillez la modifier, puis cliquez sur le bouton d`enregistrmeent.");
            this.formRecherche.setShowModalPanelMessage(true);
         } else if (this.valorisationEnteteAchats.getValCoef1() != 0.0F) {
            Session var49 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
            Transaction var3 = null;

            try {
               var3 = var49.beginTransaction();
               new OptionVentes();
               LireLesoptionsVentes var5 = new LireLesoptionsVentes();
               var5.setStrId(this.structureLog.getStrid());
               var5.lancer();
               OptionVentes var4 = var5.getOptionsVentes();
               new PlansAnalytiques();
               PlansAnalytiquesDao var7 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
               this.produitsDepot = new ProduitsDepot();
               FamillesProduitsVentesDao var8 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
               FamillesProduitsAchatsDao var9 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
               PumpAchatsDao var10 = new PumpAchatsDao(this.baseLog, this.utilInitHibernate);
               Object var11 = new ArrayList();
               Object var12 = new ArrayList();
               DepotAchatsDao var13 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
               ProduitsAchsDao var14 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
               new DepotAchats();
               new Produits();
               new FamillesProduitsAchats();
               new FamillesProduitsVentes();
               ProduitsTarifDao var19 = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
               CalculStock var20 = new CalculStock();
               new ReceptionLigneAchats();
               new InventaireLigne();
               InventaireLigneDao var23 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
               Object var24 = new ArrayList();
               UtilTrie var25 = new UtilTrie();
               if (this.valorisationEnteteAchats.getValEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
                  this.valorisationEnteteAchats.setValEtat(1);
                  this.valorisationEnteteAchats.setValDateValide(new Date());
                  this.valorisationEnteteAchats = this.valorisationEnteteAchatsDao.modif(this.valorisationEnteteAchats, var49);
                  if (this.valorisationEnteteAchats.getValDossierTransit() != null && !this.valorisationEnteteAchats.getValDossierTransit().isEmpty()) {
                     PlansAnalytiques var6 = var7.rechercheAnal("6", this.valorisationEnteteAchats.getValDossierTransit(), var49);
                     if (var6 != null) {
                        var6.setAnaInactif(3);
                        var7.modif(var6, var49);
                     }
                  }

                  if (this.receptionListe.size() != 0) {
                     this.receptionEnteteAchats = new ReceptionEnteteAchats();

                     for(int var26 = 0; var26 < this.receptionListe.size(); ++var26) {
                        this.receptionEnteteAchats = (ReceptionEnteteAchats)this.receptionListe.get(var26);
                        this.receptionEnteteAchats = this.receptionEnteteAchatsDao.pourParapheur(this.receptionEnteteAchats.getRecId(), var49);
                        if (this.receptionEnteteAchats != null && !this.receptionEnteteAchats.isRecExcluValo()) {
                           float var27 = this.valorisationEnteteAchats.getValCoef1() + this.valorisationEnteteAchats.getValCoef2();
                           this.receptionEnteteAchats.setRecCoefValo(var27);
                           this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var49);
                           ((List)var11).clear();
                           var11 = var10.chargePumpByIdDocList(this.receptionEnteteAchats.getRecId(), 13, var49);
                           if (((List)var11).size() != 0) {
                              var10.deleteListe((List)var11, var49);
                           }

                           ((List)var12).clear();
                           var12 = this.receptionLigneAchatsDao.chargerLesLignes(this.receptionEnteteAchats, var49);
                           Produits var16;
                           int var28;
                           double var33;
                           float var53;
                           if (((List)var12).size() != 0) {
                              for(var28 = 0; var28 < ((List)var12).size(); ++var28) {
                                 this.receptionLigneAchats = (ReceptionLigneAchats)((List)var12).get(var28);
                                 if (this.receptionEnteteAchats.getRecCoefDevise() == 0.0F) {
                                    this.receptionEnteteAchats.setRecCoefDevise(1.0F);
                                 }

                                 FamillesProduitsAchats var17;
                                 int var29;
                                 double var31;
                                 double var35;
                                 float var54;
                                 if (this.receptionEnteteAchats.getRecValorisation() == 0) {
                                    var29 = Integer.parseInt(this.optionAchats.getNbDecPu());
                                    double var30 = this.receptionLigneAchats.getRecligPtDev() * (double)this.receptionEnteteAchats.getRecCoefValo();
                                    this.receptionLigneAchats.setRecligPr(var30);
                                    double var32 = 0.0D;
                                    if (this.receptionLigneAchats.getRecligQteUtil() != 0.0F) {
                                       var32 = this.utilNombre.myRound(var30 / (double)this.receptionLigneAchats.getRecligQteUtil(), 2);
                                    } else if (this.receptionLigneAchats.getRecligQte() != 0.0F) {
                                       var32 = this.utilNombre.myRound(var30 / (double)this.receptionLigneAchats.getRecligQte(), 2);
                                    }

                                    this.receptionLigneAchats.setRecligPrU(var32);
                                    if (this.receptionLigneAchats.getRecligPoidsNet() != 0.0F) {
                                       double var34 = this.utilNombre.myRound(var30 / (double)this.receptionLigneAchats.getRecligPoidsNet(), 2);
                                       this.receptionLigneAchats.setRecligPrKg(var34);
                                    } else {
                                       this.receptionLigneAchats.setRecligPrKg(0.0D);
                                    }

                                    this.receptionLigneAchats.setRecligCoefPr(this.receptionEnteteAchats.getRecCoefValo());
                                 } else if (this.receptionEnteteAchats.getRecValorisation() == 1) {
                                    this.receptionLigneAchats.setRecligCoefPr(this.receptionEnteteAchats.getRecCoefValo());
                                 } else if (this.receptionEnteteAchats.getRecValorisation() == 2) {
                                    var29 = Integer.parseInt(this.optionAchats.getNbDecPu());
                                    var16 = var14.chargeProduit(this.receptionLigneAchats.getRecligCode(), var49);
                                    if (var16 != null) {
                                       var17 = var9.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), var16, var49);
                                       if (var17 != null) {
                                          var54 = var17.getFamachCoefValDefaut();
                                          var31 = this.receptionLigneAchats.getRecligPtDev() * (double)var54;
                                          this.receptionLigneAchats.setRecligPr(var31);
                                          var33 = 0.0D;
                                          if (this.receptionLigneAchats.getRecligQteUtil() != 0.0F) {
                                             var33 = this.utilNombre.myRound(var31 / (double)this.receptionLigneAchats.getRecligQteUtil(), 2);
                                          } else if (this.receptionLigneAchats.getRecligQte() != 0.0F) {
                                             var33 = this.utilNombre.myRound(var31 / (double)this.receptionLigneAchats.getRecligQte(), 2);
                                          }

                                          this.receptionLigneAchats.setRecligPrU(var33);
                                          if (this.receptionLigneAchats.getRecligPoidsNet() != 0.0F) {
                                             var35 = this.utilNombre.myRound(var31 / (double)this.receptionLigneAchats.getRecligPoidsNet(), 2);
                                             this.receptionLigneAchats.setRecligPrKg(var35);
                                          } else {
                                             this.receptionLigneAchats.setRecligPrKg(0.0D);
                                          }

                                          this.receptionLigneAchats.setRecligCoefPr(var54);
                                       }
                                    }
                                 }

                                 if (this.receptionLigneAchats.getRecligDepot() != null && !this.receptionLigneAchats.getRecligDepot().isEmpty() && this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
                                    this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var49);
                                    if (this.produitsDepot == null) {
                                       DepotAchats var15 = var13.trouveDepot(this.receptionLigneAchats.getRecligDepot(), var49);
                                       if (var15 != null) {
                                          var16 = var14.chargeProduit(this.receptionLigneAchats.getRecligCode(), var49);
                                          if (var16 != null) {
                                             var17 = var9.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), var16, var49);
                                             if (var17 == null) {
                                                var17 = new FamillesProduitsAchats();
                                             }

                                             this.produitsDepot = new ProduitsDepot();
                                             this.produitsDepot.setProduits(var16);
                                             this.produitsDepot.setDepot(var15);
                                             this.produitsDepot.setProdepUnite(var17.getFamachUnite());
                                             this.produitsDepot.setProdepEchelle(var17.getFamachEchelle());
                                             String var52 = this.receptionLigneAchats.getRecligDepot() + ":" + this.receptionLigneAchats.getRecligCode();
                                             this.produitsDepot.setProdepCle(var52);
                                             String var55 = this.produitsDepot.getProdepGroupe() + ":" + this.receptionLigneAchats.getRecligCode();
                                             this.produitsDepot.setProdepCle2(var55);
                                             this.produitsDepot = this.produitsDepotDao.insert(this.produitsDepot, var49);
                                          }
                                       }
                                    }

                                    if (this.produitsDepot != null) {
                                       var53 = 0.0F;
                                       var54 = 0.0F;
                                       var31 = 0.0D;
                                       byte var59 = 0;
                                       Date var60 = null;
                                       InventaireLigne var22 = var23.rechercheBefore(this.receptionEnteteAchats.getRecDate(), this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var49);
                                       ReceptionLigneAchats var21 = this.receptionLigneAchatsDao.rechercheBefore(this.receptionEnteteAchats.getRecDate(), this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var49);
                                       if (var21 != null) {
                                          var59 = 1;
                                       } else if (var22 != null) {
                                          var59 = 2;
                                       }

                                       if (this.optionAchats.getModCalcPump().equals("1")) {
                                          var59 = 3;
                                       } else {
                                          if (var22 != null) {
                                             var60 = var22.getInventaireEntete().getInvDate();
                                             var53 = var22.getInvligQteUtil();
                                          } else {
                                             var60 = this.exercicesAchats.getExeachDateDebut();
                                          }

                                          String var61 = "";
                                          if (this.produitsDepot.getProduits().getProVteNat() != null && !this.produitsDepot.getProduits().getProVteNat().isEmpty()) {
                                             var61 = this.produitsDepot.getProduits().getProVteNat();
                                          } else {
                                             var61 = this.produitsDepot.getProduits().getProAchNat();
                                          }

                                          var20.razLesMvt();
                                          ((List)var24).clear();
                                          var24 = var20.chargerMouvements(1, "", var61, this.receptionLigneAchats.getRecligCode(), "", this.receptionLigneAchats.getRecligDepot(), 0L, "", "", var60, this.receptionEnteteAchats.getRecDate(), false, false, true, true, false, false, false, true, true, true, true, false, false, true, true, true, false, false, true, false, true, var4.getGestionStockBc(), this.baseLog, this.structureLog, var49);
                                          if (((List)var24).size() != 0) {
                                             List var50 = var25.triListeDate((List)var24);
                                             var50 = var25.triListeDate(var50);
                                             var50 = var25.triListeDate(var50);
                                             var24 = var25.triListeDate(var50);

                                             for(int var36 = 0; var36 < ((List)var24).size(); ++var36) {
                                                if (((Stock)((List)var24).get(var36)).getStk_code_produit() != null && !((Stock)((List)var24).get(var36)).getStk_code_produit().isEmpty() && ((Stock)((List)var24).get(var36)).getStk_code_produit().equals(this.receptionLigneAchats.getRecligCode()) && ((Stock)((List)var24).get(var36)).getStk_type() != 10 && ((Stock)((List)var24).get(var36)).getStk_type() != 11 && ((Stock)((List)var24).get(var36)).getStk_type() != 12) {
                                                   var53 += ((Stock)((List)var24).get(var36)).getStk_qte_in() - ((Stock)((List)var24).get(var36)).getStk_qte_out();
                                                }
                                             }
                                          }

                                          if (var53 <= 0.0F) {
                                             var59 = 0;
                                          }
                                       }

                                       var54 = var53 - this.receptionLigneAchats.getRecligQteUtil();
                                       if (var54 <= 0.0F) {
                                          var54 = 0.0F;
                                          if (var59 != 3) {
                                             var59 = 0;
                                          }
                                       }

                                       double var37;
                                       double var39;
                                       double var41;
                                       if (var59 == 1) {
                                          var35 = 0.0D;
                                          if (var21.getRecligQteUtil() != 0.0F) {
                                             if (this.optionAchats.getModCalcPr().equals("1")) {
                                                if (var21.getRecligPrUTtc() == 0.0D) {
                                                   var21.setRecligPrUTtc(var21.getRecligPr() / (double)var21.getRecligQteUtil());
                                                }

                                                var35 = var21.getRecligPrUTtc() * (double)var54;
                                             } else {
                                                if (var21.getRecligPrU() == 0.0D) {
                                                   var21.setRecligPrU(var21.getRecligPr() / (double)var21.getRecligQteUtil());
                                                }

                                                var35 = var21.getRecligPrU() * (double)var54;
                                             }
                                          }

                                          var37 = 0.0D;
                                          if (this.optionAchats.getModCalcPr().equals("1")) {
                                             var37 = this.receptionLigneAchats.getRecligPrUTtc() * (double)this.receptionLigneAchats.getRecligQteUtil();
                                          } else {
                                             var37 = this.receptionLigneAchats.getRecligPrU() * (double)this.receptionLigneAchats.getRecligQteUtil();
                                          }

                                          var39 = (var35 + var37) / (double)(var53 + this.receptionLigneAchats.getRecligQteUtil());
                                          var31 = var21.getRecligPump();
                                          var41 = 0.0D;
                                          if (this.optionAchats.getModCalcPr().equals("1")) {
                                             var41 = this.receptionLigneAchats.getRecligPrUTtc();
                                          } else {
                                             var41 = this.receptionLigneAchats.getRecligPrU();
                                          }

                                          this.miseAJourDepot(var41, this.receptionLigneAchats.getRecligPrKg(), var39, this.receptionEnteteAchats.getRecCoefValo(), var49);
                                       } else if (var59 == 2) {
                                          var35 = var22.getInvligPump() * (double)var54;
                                          var37 = 0.0D;
                                          if (this.optionAchats.getModCalcPr().equals("1")) {
                                             var37 = this.receptionLigneAchats.getRecligPrUTtc() * (double)this.receptionLigneAchats.getRecligQteUtil();
                                          } else {
                                             var37 = this.receptionLigneAchats.getRecligPrU() * (double)this.receptionLigneAchats.getRecligQteUtil();
                                          }

                                          var39 = (var35 + var37) / (double)(var53 + this.receptionLigneAchats.getRecligQteUtil());
                                          var31 = var22.getInvligPump();
                                          var41 = 0.0D;
                                          if (this.optionAchats.getModCalcPr().equals("1")) {
                                             var41 = this.receptionLigneAchats.getRecligPrUTtc();
                                          } else {
                                             var41 = this.receptionLigneAchats.getRecligPrU();
                                          }

                                          this.miseAJourDepot(var41, this.receptionLigneAchats.getRecligPrKg(), var39, this.receptionEnteteAchats.getRecCoefValo(), var49);
                                       } else if (var59 == 3) {
                                          var35 = 0.0D;
                                          float var62 = 0.0F;
                                          if (var21 != null) {
                                             if (this.optionAchats.getModCalcPr().equals("1")) {
                                                if (var21.getRecligPrUTtc() == 0.0D) {
                                                   var21.setRecligPrUTtc(var21.getRecligPr() / (double)var21.getRecligQteUtil());
                                                }

                                                var35 = var21.getRecligPrUTtc() * (double)var21.getRecligQteUtil();
                                             } else {
                                                if (var21.getRecligPrU() == 0.0D) {
                                                   var21.setRecligPrU(var21.getRecligPr() / (double)var21.getRecligQteUtil());
                                                }

                                                var35 = var21.getRecligPrU() * (double)var21.getRecligQteUtil();
                                             }

                                             var62 = var21.getRecligQteUtil();
                                             var31 = var21.getRecligPump();
                                          }

                                          double var38 = 0.0D;
                                          if (this.optionAchats.getModCalcPr().equals("1")) {
                                             var38 = this.receptionLigneAchats.getRecligPrUTtc() * (double)this.receptionLigneAchats.getRecligQteUtil();
                                          } else {
                                             var38 = this.receptionLigneAchats.getRecligPrU() * (double)this.receptionLigneAchats.getRecligQteUtil();
                                          }

                                          double var40 = (var35 + var38) / (double)(var62 + this.receptionLigneAchats.getRecligQteUtil());
                                          double var42 = 0.0D;
                                          if (this.optionAchats.getModCalcPr().equals("1")) {
                                             if (this.receptionLigneAchats.getRecligPrUTtc() == 0.0D) {
                                                this.receptionLigneAchats.setRecligPrUTtc(this.receptionLigneAchats.getRecligPr() / (double)this.receptionLigneAchats.getRecligQteUtil());
                                             }

                                             var42 = this.receptionLigneAchats.getRecligPrUTtc();
                                          } else {
                                             if (this.receptionLigneAchats.getRecligPrU() == 0.0D) {
                                                this.receptionLigneAchats.setRecligPrU(this.receptionLigneAchats.getRecligPr() / (double)this.receptionLigneAchats.getRecligQteUtil());
                                             }

                                             var42 = this.receptionLigneAchats.getRecligPrU();
                                          }

                                          this.miseAJourDepot(var42, this.receptionLigneAchats.getRecligPrKg(), var40, this.receptionEnteteAchats.getRecCoefValo(), var49);
                                       } else {
                                          var35 = 0.0D;
                                          if (this.optionAchats.getModCalcPr().equals("1")) {
                                             if (this.receptionLigneAchats.getRecligPrUTtc() == 0.0D) {
                                                this.receptionLigneAchats.setRecligPrUTtc(this.receptionLigneAchats.getRecligPr() / (double)this.receptionLigneAchats.getRecligQteUtil());
                                             }

                                             var35 = this.receptionLigneAchats.getRecligPrUTtc();
                                          } else {
                                             if (this.receptionLigneAchats.getRecligPrU() == 0.0D) {
                                                this.receptionLigneAchats.setRecligPrU(this.receptionLigneAchats.getRecligPr() / (double)this.receptionLigneAchats.getRecligQteUtil());
                                             }

                                             var35 = this.receptionLigneAchats.getRecligPrU();
                                          }

                                          this.miseAJourDepot(var35, this.receptionLigneAchats.getRecligPrKg(), var35, this.receptionEnteteAchats.getRecCoefValo(), var49);
                                       }

                                       PumpAchats var63 = new PumpAchats();
                                       var63.setExercicesAchats(this.exercicesAchats);
                                       var63.setPumDateCreat(new Date());
                                       var63.setPumIdCreateur(this.usersLog.getUsrid());
                                       var63.setPumNatureOrigine(13);
                                       var63.setPumDate(this.receptionLigneAchats.getReceptionEnteteAchats().getRecDate());
                                       var63.setPumIdDocOrigine(this.receptionEnteteAchats.getRecId());
                                       var63.setPumNumDocOrigine(this.receptionEnteteAchats.getRecNum());
                                       var63.setPumDossier(this.receptionEnteteAchats.getRecAnal4());
                                       var63.setPumIdLigneOrigine(this.receptionLigneAchats.getRecligId());
                                       var63.setPumDepot(this.receptionLigneAchats.getRecligDepot());
                                       var63.setPumProduit(this.receptionLigneAchats.getRecligCode());
                                       var63.setPumPa(this.receptionLigneAchats.getRecligPuRem());
                                       var63.setPumPr(this.produitsDepot.getProdepPr());
                                       var63.setPumPrKg(this.produitsDepot.getProdepPrKg());
                                       var63.setPumPump(this.produitsDepot.getProdepPump());
                                       var63.setPumQteOperation(this.receptionLigneAchats.getRecligQteUtil());
                                       var63.setPumQteStock(var53);
                                       var10.insert(var63, var49);
                                       this.receptionLigneAchats.setRecligQteStock(var54);
                                       this.receptionLigneAchats.setRecligPump(this.produitsDepot.getProdepPump());
                                       this.receptionLigneAchats.setRecligPumpOld(var31);
                                       this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var49);
                                       var49.flush();
                                       this.majSortie(var49);
                                    } else {
                                       this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var49);
                                    }
                                 } else {
                                    this.receptionLigneAchats.setRecligPump(this.receptionLigneAchats.getRecligPrU());
                                    this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var49);
                                 }
                              }
                           }

                           if (this.listReceptionProduit.size() != 0 && (this.optionAchats.getModValoPvProd().equals("1") || this.optionAchats.getModValoPvProd().equals("2"))) {
                              for(var28 = 0; var28 < ((List)var12).size(); ++var28) {
                                 this.receptionLigneAchats = (ReceptionLigneAchats)((List)var12).get(var28);
                                 if (this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty() && this.receptionLigneAchats.getRecligCode().length() >= 2 && this.receptionLigneAchats.getRecligPump() != 0.0D) {
                                    var16 = var14.chargeProduit(this.receptionLigneAchats.getRecligCode(), var49);
                                    var53 = 0.0F;
                                    if (var16 != null) {
                                       if (var16.getProCoefVte() != 0.0F) {
                                          var53 = var16.getProCoefVte();
                                       } else {
                                          FamillesProduitsVentes var18 = var8.rechercheFamilleByProd(0L, var16, var49);
                                          if (var18 != null && var18.getFamvteCoefPv() != 0.0F) {
                                             var53 = var18.getFamvteCoefPv();
                                          }
                                       }

                                       if (var53 != 0.0F) {
                                          new ArrayList();
                                          List var57 = var19.selectProdTarifByprod(var16, var49);
                                          if (var57.size() != 0) {
                                             new ProduitsTarif();

                                             for(int var58 = 0; var58 < var57.size(); ++var58) {
                                                ProduitsTarif var56 = (ProduitsTarif)var57.get(var58);
                                                var56.setProtarCoef(var53);
                                                var33 = 0.0D;
                                                if (this.listReceptionProduit.size() != 0 && this.optionAchats.getModValoPvProd().equals("1")) {
                                                   var33 = this.receptionLigneAchats.getRecligPump() * (double)var53;
                                                } else if (this.listReceptionProduit.size() != 0 && this.optionAchats.getModValoPvProd().equals("2")) {
                                                   var33 = this.receptionLigneAchats.getRecligPrU() * (double)var53;
                                                }

                                                var56.setProtarPv(var33);
                                                var19.modif(var56, var49);
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  Espion var51 = new Espion();
                  var51.setUsers(this.usersLog);
                  var51.setEsptype(0);
                  var51.setEspdtecreat(new Date());
                  var51.setEspaction("Validation manuelle valorisation (F.) N° " + this.valorisationEnteteAchats.getValNum() + " du " + this.utilDate.dateToStringSQLLight(this.valorisationEnteteAchats.getValDate()));
                  this.espionDao.mAJEspion(var51, var49);
               }

               var3.commit();
            } catch (HibernateException var47) {
               if (var3 != null) {
                  var3.rollback();
               }

               throw var47;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else {
            this.formRecherche.setMessageTexte("La valorisation n'a pas été correctement faite. Veuillez la modifier, puis cliquez sur le bouton d`enregistrmeent.");
            this.formRecherche.setShowModalPanelMessage(true);
         }

         this.selectionLigneSuite();
      }

   }

   public void miseAJourDepot(double var1, double var3, double var5, float var7, Session var8) throws HibernateException, NamingException {
      if (this.optionAchats.getModDepPump().equals("1")) {
         new ArrayList();
         List var9 = this.produitsDepotDao.selectProdDepByprod(this.receptionLigneAchats.getRecligCode(), var8);
         if (var9.size() != 0) {
            new ProduitsDepot();

            for(int var11 = 0; var11 < var9.size(); ++var11) {
               ProduitsDepot var10 = (ProduitsDepot)var9.get(var11);
               var10.setProdepPr(var1);
               var10.setProdepPrKg(var3);
               var10.setProdepPump(var5);
               var10.setProdepCoefPr(var7);
               this.produitsDepotDao.modif(var10, var8);
            }
         }
      } else {
         this.produitsDepot.setProdepPr(var1);
         this.produitsDepot.setProdepPrKg(var3);
         this.produitsDepot.setProdepPump(var5);
         this.produitsDepot.setProdepCoefPr(var7);
         this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var8);
      }

   }

   public void majSortie(Session var1) throws HibernateException, NamingException {
      Date var2 = null;
      new ReceptionLigneAchats();
      ReceptionLigneAchats var3 = this.receptionLigneAchatsDao.rechercheNext(this.receptionEnteteAchats.getRecDate(), this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
      if (var3 != null) {
         var2 = var3.getReceptionEnteteAchats().getRecDate();
      }

      new ArrayList();
      LivraisonLigneVentesDao var5 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var4.size() != 0) {
         new LivraisonLigneVentes();

         for(int var7 = 0; var7 < var4.size(); ++var7) {
            LivraisonLigneVentes var6 = (LivraisonLigneVentes)var4.get(var7);
            var6.setBlvligPump(this.receptionLigneAchats.getRecligPump());
            var5.modif(var6, var1);
         }
      }

      new ArrayList();
      RetourLigneVentesDao var27 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var26 = var27.chargerLesLinesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var26.size() != 0) {
         new RetourLigneVentes();

         for(int var9 = 0; var9 < var26.size(); ++var9) {
            RetourLigneVentes var8 = (RetourLigneVentes)var26.get(var9);
            var8.setBrtligPump(this.receptionLigneAchats.getRecligPump());
            var27.modifLigne(var8, var1);
         }
      }

      new ArrayList();
      FactureLigneVentesDao var29 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var28 = var29.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var28.size() != 0) {
         new FactureLigneVentes();

         for(int var11 = 0; var11 < var28.size(); ++var11) {
            FactureLigneVentes var10 = (FactureLigneVentes)var28.get(var11);
            var10.setFacligPump(this.receptionLigneAchats.getRecligPump());
            var29.modifLigne(var10, var1);
         }
      }

      new ArrayList();
      NoteDebitLigneVentesDao var31 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var30 = var31.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var30.size() != 0) {
         new NoteDebitLigneVentes();

         for(int var13 = 0; var13 < var30.size(); ++var13) {
            NoteDebitLigneVentes var12 = (NoteDebitLigneVentes)var30.get(var13);
            var12.setNdbligPump(this.receptionLigneAchats.getRecligPump());
            var31.modifLigne(var12, var1);
         }
      }

      new ArrayList();
      AvoirLigneVentesDao var33 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var32 = var33.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var32.size() != 0) {
         new AvoirLigneVentes();

         for(int var15 = 0; var15 < var32.size(); ++var15) {
            AvoirLigneVentes var14 = (AvoirLigneVentes)var32.get(var15);
            var14.setAvrligPump(this.receptionLigneAchats.getRecligPump());
            var33.modifLigne(var14, var1);
         }
      }

      new ArrayList();
      InventaireLigneDao var35 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
      List var34 = var35.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var34.size() != 0) {
         new InventaireLigne();

         for(int var17 = 0; var17 < var34.size(); ++var17) {
            InventaireLigne var16 = (InventaireLigne)var34.get(var17);
            var16.setInvligPump(this.receptionLigneAchats.getRecligPump());
            var35.modifLigne(var16, var1);
         }
      }

      new ArrayList();
      BonEntreeLigneDao var37 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
      List var36 = var37.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var36.size() != 0) {
         new BonEntreeLigne();

         for(int var19 = 0; var19 < var36.size(); ++var19) {
            BonEntreeLigne var18 = (BonEntreeLigne)var36.get(var19);
            var18.setBinligPump(this.receptionLigneAchats.getRecligPump());
            var37.modifLigne(var18, var1);
         }
      }

      new ArrayList();
      BonSortieLigneDao var39 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
      List var38 = var39.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var38.size() != 0) {
         new BonSortieLigne();

         for(int var21 = 0; var21 < var38.size(); ++var21) {
            BonSortieLigne var20 = (BonSortieLigne)var38.get(var21);
            var20.setBouligPump(this.receptionLigneAchats.getRecligPump());
            var39.modifLigne(var20, var1);
         }
      }

      new ArrayList();
      CessionLigneDao var41 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
      List var40 = var41.chargerLesLignesDestinationValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var40.size() != 0) {
         new CessionLigne();

         for(int var23 = 0; var23 < var40.size(); ++var23) {
            CessionLigne var22 = (CessionLigne)var40.get(var23);
            var22.setCesligPump(this.receptionLigneAchats.getRecligPump());
            var41.modifLigne(var22, var1);
         }
      }

      new ArrayList();
      FabricationLigneAchatsDao var43 = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var42 = var43.chargerLesLignesFabricationValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var42.size() != 0) {
         new FabricationLigneAchats();

         for(int var25 = 0; var25 < var42.size(); ++var25) {
            FabricationLigneAchats var24 = (FabricationLigneAchats)var42.get(var25);
            var24.setFabligPump(this.receptionLigneAchats.getRecligPump());
            var43.modifLigne(var24, var1);
         }
      }

   }

   public void deValideDocument() throws HibernateException, NamingException {
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new PlansAnalytiques();
         PlansAnalytiquesDao var5 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.produitsDepot = new ProduitsDepot();
         PumpAchatsDao var6 = new PumpAchatsDao(this.baseLog, this.utilInitHibernate);
         Object var7 = new ArrayList();
         Object var8 = new ArrayList();
         if (this.valorisationEnteteAchats.getValEtat() == 1) {
            this.valorisationEnteteAchats.setValEtat(0);
            this.valorisationEnteteAchats.setValDateValide((Date)null);
            if (this.valorisationEnteteAchats.getValFictif() == 2) {
               this.valorisationEnteteAchats.setValDateTransfert((Date)null);
            }

            this.valorisationEnteteAchats = this.valorisationEnteteAchatsDao.modif(this.valorisationEnteteAchats, var2);
            if (this.valorisationEnteteAchats.getValDossierTransit() != null && !this.valorisationEnteteAchats.getValDossierTransit().isEmpty()) {
               PlansAnalytiques var4 = var5.devalideAnal("6", this.valorisationEnteteAchats.getValDossierTransit(), var2);
               if (var4 != null) {
                  var4.setAnaInactif(0);
                  var5.modif(var4, var2);
               }
            }

            if (this.receptionListe.size() != 0) {
               for(int var9 = 0; var9 < this.receptionListe.size(); ++var9) {
                  this.receptionEnteteAchats = new ReceptionEnteteAchats();
                  this.receptionEnteteAchats = (ReceptionEnteteAchats)this.receptionListe.get(var9);
                  if (!this.receptionEnteteAchats.isRecExcluValo()) {
                     this.receptionEnteteAchats.setRecCoefValo(0.0F);
                     this.receptionEnteteAchats.setRecValorisation(0);
                     this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var2);
                     ((List)var7).clear();
                     var7 = var6.chargePumpByIdDocList(this.receptionEnteteAchats.getRecId(), 13, var2);
                     if (((List)var7).size() != 0) {
                        var6.deleteListe((List)var7, var2);
                     }

                     ((List)var8).clear();
                     var8 = this.receptionLigneAchatsDao.chargerLesLignes(this.receptionEnteteAchats, var2);
                     if (((List)var8).size() != 0) {
                        for(int var10 = 0; var10 < ((List)var8).size(); ++var10) {
                           this.receptionLigneAchats = (ReceptionLigneAchats)((List)var8).get(var10);
                           if (this.receptionLigneAchats.getRecligDepot() != null && !this.receptionLigneAchats.getRecligDepot().isEmpty() && this.receptionLigneAchats.getRecligCode() != null && !this.receptionLigneAchats.getRecligCode().isEmpty()) {
                              this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var2);
                              if (this.produitsDepot != null) {
                                 this.receptionLigneAchats.setRecligPr(0.0D);
                                 this.receptionLigneAchats.setRecligPrU(0.0D);
                                 this.receptionLigneAchats.setRecligPrKg(0.0D);
                                 this.receptionLigneAchats.setRecligPrUTtc(0.0D);
                                 this.receptionLigneAchats.setRecligPump(this.produitsDepot.getProdepPump());
                                 this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var2);
                                 this.razSortie(var2);
                              } else {
                                 this.receptionLigneAchats.setRecligPr(0.0D);
                                 this.receptionLigneAchats.setRecligPrU(0.0D);
                                 this.receptionLigneAchats.setRecligPrKg(0.0D);
                                 this.receptionLigneAchats.setRecligPrUTtc(0.0D);
                                 this.receptionLigneAchats.setRecligPump(0.0D);
                                 this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var2);
                              }
                           } else {
                              this.receptionLigneAchats.setRecligPr(0.0D);
                              this.receptionLigneAchats.setRecligPrU(0.0D);
                              this.receptionLigneAchats.setRecligPrKg(0.0D);
                              this.receptionLigneAchats.setRecligPrUTtc(0.0D);
                              this.receptionLigneAchats.setRecligPump(0.0D);
                              this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var2);
                           }
                        }
                     }
                  }
               }
            }

            Espion var16 = new Espion();
            var16.setUsers(this.usersLog);
            var16.setEsptype(0);
            var16.setEspdtecreat(new Date());
            var16.setEspaction("Dévalidation manuelle valorisation (F.) N° " + this.valorisationEnteteAchats.getValNum() + " du " + this.utilDate.dateToStringSQLLight(this.valorisationEnteteAchats.getValDate()));
            this.espionDao.mAJEspion(var16, var2);
         }

         var3.commit();
         var1 = true;
      } catch (HibernateException var14) {
         var1 = false;
         if (var3 != null) {
            var3.rollback();
         }

         throw var14;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (this.valorisationEnteteAchats.getValFictif() == 2 && var1) {
         this.razTrfCompta();
      }

   }

   public void razSortie(Session var1) throws HibernateException, NamingException {
      Date var2 = null;
      new ReceptionLigneAchats();
      ReceptionLigneAchats var3 = this.receptionLigneAchatsDao.rechercheNext(this.receptionEnteteAchats.getRecDate(), this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), var1);
      if (var3 != null) {
         var2 = var3.getReceptionEnteteAchats().getRecDate();
      }

      new ArrayList();
      LivraisonLigneVentesDao var5 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var4.size() != 0) {
         new LivraisonLigneVentes();

         for(int var7 = 0; var7 < var4.size(); ++var7) {
            LivraisonLigneVentes var6 = (LivraisonLigneVentes)var4.get(var7);
            var6.setBlvligPump(0.0D);
            var5.modif(var6, var1);
         }
      }

      new ArrayList();
      RetourLigneVentesDao var27 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var26 = var27.chargerLesLinesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var26.size() != 0) {
         new RetourLigneVentes();

         for(int var9 = 0; var9 < var26.size(); ++var9) {
            RetourLigneVentes var8 = (RetourLigneVentes)var26.get(var9);
            var8.setBrtligPump(0.0D);
            var27.modifLigne(var8, var1);
         }
      }

      new ArrayList();
      FactureLigneVentesDao var29 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var28 = var29.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var28.size() != 0) {
         new FactureLigneVentes();

         for(int var11 = 0; var11 < var28.size(); ++var11) {
            FactureLigneVentes var10 = (FactureLigneVentes)var28.get(var11);
            var10.setFacligPump(0.0D);
            var29.modifLigne(var10, var1);
         }
      }

      new ArrayList();
      NoteDebitLigneVentesDao var31 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var30 = var31.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var30.size() != 0) {
         new NoteDebitLigneVentes();

         for(int var13 = 0; var13 < var30.size(); ++var13) {
            NoteDebitLigneVentes var12 = (NoteDebitLigneVentes)var30.get(var13);
            var12.setNdbligPump(0.0D);
            var31.modifLigne(var12, var1);
         }
      }

      new ArrayList();
      AvoirLigneVentesDao var33 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var32 = var33.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var32.size() != 0) {
         new AvoirLigneVentes();

         for(int var15 = 0; var15 < var32.size(); ++var15) {
            AvoirLigneVentes var14 = (AvoirLigneVentes)var32.get(var15);
            var14.setAvrligPump(0.0D);
            var33.modifLigne(var14, var1);
         }
      }

      new ArrayList();
      InventaireLigneDao var35 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
      List var34 = var35.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var34.size() != 0) {
         new InventaireLigne();

         for(int var17 = 0; var17 < var34.size(); ++var17) {
            InventaireLigne var16 = (InventaireLigne)var34.get(var17);
            var16.setInvligPump(0.0D);
            var35.modifLigne(var16, var1);
         }
      }

      new ArrayList();
      BonEntreeLigneDao var37 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
      List var36 = var37.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var36.size() != 0) {
         new BonEntreeLigne();

         for(int var19 = 0; var19 < var36.size(); ++var19) {
            BonEntreeLigne var18 = (BonEntreeLigne)var36.get(var19);
            var18.setBinligPump(0.0D);
            var37.modifLigne(var18, var1);
         }
      }

      new ArrayList();
      BonSortieLigneDao var39 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
      List var38 = var39.chargerLesLignesValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var38.size() != 0) {
         new BonSortieLigne();

         for(int var21 = 0; var21 < var38.size(); ++var21) {
            BonSortieLigne var20 = (BonSortieLigne)var38.get(var21);
            var20.setBouligPump(0.0D);
            var39.modifLigne(var20, var1);
         }
      }

      new ArrayList();
      CessionLigneDao var41 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
      List var40 = var41.chargerLesLignesDestinationValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var40.size() != 0) {
         new CessionLigne();

         for(int var23 = 0; var23 < var40.size(); ++var23) {
            CessionLigne var22 = (CessionLigne)var40.get(var23);
            var22.setCesligPump(0.0D);
            var41.modifLigne(var22, var1);
         }
      }

      new ArrayList();
      FabricationLigneAchatsDao var43 = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var42 = var43.chargerLesLignesFabricationValorisation(this.receptionLigneAchats.getRecligCode(), this.receptionLigneAchats.getRecligDepot(), this.receptionEnteteAchats.getRecDate(), var2, var1);
      if (var42.size() != 0) {
         new FabricationLigneAchats();

         for(int var25 = 0; var25 < var42.size(); ++var25) {
            FabricationLigneAchats var24 = (FabricationLigneAchats)var42.get(var25);
            var24.setFabligPump(0.0D);
            var43.modifLigne(var24, var1);
         }
      }

   }

   public void razTrfCompta() throws HibernateException, NamingException {
      String var1 = "ecrTypeOrigine='35' and ecrIdOrigine=" + this.valorisationEnteteAchats.getValId();
      new ArrayList();
      new ArrayList();
      new Ecritures();
      EcrituresDao var5 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      EcrituresAnalytiquesDao var6 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var5.ChargerLesEcrituresRecherche(var1, (Session)null);
      if (var2.size() != 0) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();

            for(int var9 = 0; var9 < var2.size(); ++var9) {
               Ecritures var4 = (Ecritures)var2.get(var9);
               if (var4 != null) {
                  long var10 = var4.getEcr_id();
                  List var3 = var6.chargerLesEcrituresAnalytiques(var4, var7);
                  if (var3.size() != 0) {
                     var6.nettoyageAnalytiqueByEcriture(var3, var7);
                     var7.flush();
                  }

                  var4 = var5.recupererSelectedECById(var10, var7);
                  if (var4 != null) {
                     var5.removeSelectedEC0(var4, 0, var7);
                  }
               }
            }

            var8.commit();
         } catch (HibernateException var15) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var15;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesEntetesList.remove(this.valorisationEnteteAchats);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         String var3 = this.valorisationEnteteAchats.getValNum();
         Date var4 = this.valorisationEnteteAchats.getValDate();
         this.parapheurDao.delete(this.valorisationEnteteAchats.getValId(), this.nature, var1);
         this.valorisationEnteteAchatsDao.delete(this.valorisationEnteteAchats.getValId(), var1);
         Espion var5 = new Espion();
         var5.setUsers(this.usersLog);
         var5.setEsptype(0);
         var5.setEspdtecreat(new Date());
         var5.setEspaction("Suppression valorisation N° " + var3 + " du " + var4);
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

   public void supprimerParapheur() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parapheur");
      if (this.parapheurDao == null) {
         this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      }

      this.parapheur = this.parapheurDao.existenceParapheur(this.valorisationEnteteAchats.getValId(), this.nature, var1);
      if (this.parapheur != null) {
         this.parapheurDao.delete(this.parapheur, var1);
         this.utilInitHibernate.closeSession();
      }

   }

   public void annule() throws IOException, JDOMException {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void Envoieparapheur(Session var1) {
      this.parapheur = new Parapheur();
      this.parapheur.setPhrNature(this.nature);
      this.parapheur.setPhrMode(this.habilitation.getHabMode());
      this.parapheur.setPhrUser1Cat(this.habilitation.getHabUser1Cat());
      this.parapheur.setPhrUser1Id(this.habilitation.getHabUser1Id());
      this.parapheur.setPhrUser1Nom(this.habilitation.getHabUser1Nom());
      this.parapheur.setPhrUser2Cat(this.habilitation.getHabUser2Cat());
      this.parapheur.setPhrUser2Id(this.habilitation.getHabUser2Id());
      this.parapheur.setPhrUser2Nom(this.habilitation.getHabUser2Nom());
      this.parapheur.setPhrUser3Cat(this.habilitation.getHabUser3Cat());
      this.parapheur.setPhrUser3Id(this.habilitation.getHabUser3Id());
      this.parapheur.setPhrUser3Nom(this.habilitation.getHabUser3Nom());
      this.parapheur.setPhrUser4Cat(this.habilitation.getHabUser4Cat());
      this.parapheur.setPhrUser4Id(this.habilitation.getHabUser4Id());
      this.parapheur.setPhrUser4Nom(this.habilitation.getHabUser4Nom());
      this.parapheur.setPhrUser5Cat(this.habilitation.getHabUser5Cat());
      this.parapheur.setPhrUser5Id(this.habilitation.getHabUser5Id());
      this.parapheur.setPhrUser5Nom(this.habilitation.getHabUser5Nom());
      this.parapheur.setPhrUser6Cat(this.habilitation.getHabUser6Cat());
      this.parapheur.setPhrUser6Id(this.habilitation.getHabUser6Id());
      this.parapheur.setPhrUser6Nom(this.habilitation.getHabUser6Nom());
      this.parapheur.setPhrDocId(this.valorisationEnteteAchats.getValId());
      this.parapheur.setPhrNum(this.valorisationEnteteAchats.getValNum());
      this.parapheur.setPhrDate(this.valorisationEnteteAchats.getValDate());
      if (this.parapheurDao == null) {
         this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      }

      if (this.parapheur.getPhrId() == 0L) {
         this.parapheur = this.parapheurDao.insert(this.parapheur, var1);
      } else {
         this.parapheur = this.parapheurDao.modif(this.parapheur, var1);
      }

   }

   public void EnvoieParapheurApresTransfert(long var1, String var3, Date var4, Session var5) {
      this.parapheur = new Parapheur();
      this.parapheur.setPhrNature(this.habilitation.getHabNature());
      this.parapheur.setPhrMode(this.habilitation.getHabMode());
      this.parapheur.setPhrUser1Cat(this.habilitation.getHabUser1Cat());
      this.parapheur.setPhrUser1Id(this.habilitation.getHabUser1Id());
      this.parapheur.setPhrUser1Nom(this.habilitation.getHabUser1Nom());
      this.parapheur.setPhrUser2Cat(this.habilitation.getHabUser2Cat());
      this.parapheur.setPhrUser2Id(this.habilitation.getHabUser2Id());
      this.parapheur.setPhrUser2Nom(this.habilitation.getHabUser2Nom());
      this.parapheur.setPhrUser3Cat(this.habilitation.getHabUser3Cat());
      this.parapheur.setPhrUser3Id(this.habilitation.getHabUser3Id());
      this.parapheur.setPhrUser3Nom(this.habilitation.getHabUser3Nom());
      this.parapheur.setPhrUser4Cat(this.habilitation.getHabUser4Cat());
      this.parapheur.setPhrUser4Id(this.habilitation.getHabUser4Id());
      this.parapheur.setPhrUser4Nom(this.habilitation.getHabUser4Nom());
      this.parapheur.setPhrUser5Cat(this.habilitation.getHabUser5Cat());
      this.parapheur.setPhrUser5Id(this.habilitation.getHabUser5Id());
      this.parapheur.setPhrUser5Nom(this.habilitation.getHabUser5Nom());
      this.parapheur.setPhrUser6Cat(this.habilitation.getHabUser6Cat());
      this.parapheur.setPhrUser6Id(this.habilitation.getHabUser6Id());
      this.parapheur.setPhrUser6Nom(this.habilitation.getHabUser6Nom());
      this.parapheur.setPhrDocId(var1);
      this.parapheur.setPhrNum(var3);
      this.parapheur.setPhrDate(var4);
      if (this.parapheurDao == null) {
         this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      }

      if (this.parapheur.getPhrId() == 0L) {
         this.parapheur = this.parapheurDao.insert(this.parapheur, var5);
      } else {
         this.parapheur = this.parapheurDao.modif(this.parapheur, var5);
      }

   }

   public void save() throws IOException, HibernateException, NamingException {
      this.calculValo1();
      this.majAnalytique();
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
      Transaction var2 = null;
      ArrayList var3 = new ArrayList();
      SommierEnteteAchatsDao var4 = new SommierEnteteAchatsDao(this.baseLog, this.utilInitHibernate);

      PlansAnalytiques var27;
      try {
         var2 = var1.beginTransaction();
         this.valorisationEnteteAchats.setValDate(this.var_date);
         if (this.valorisationEnteteAchats.getUsers() == null) {
            this.valorisationEnteteAchats.setUsers(this.usersLog);
         }

         if (this.valorisationEnteteAchats.getValId() != 0L) {
            this.valorisationEnteteAchats.setValDateModif(new Date());
            this.valorisationEnteteAchats.setValIdModif(this.usersLog.getUsrid());
            this.valorisationEnteteAchats.setValNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.verifieExistenceHabilitation(var1);
            this.valorisationEnteteAchats = this.valorisationEnteteAchatsDao.modif(this.valorisationEnteteAchats, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
         } else {
            this.valorisationEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.valorisationEnteteAchats.setValDateCreat(new Date());
            this.valorisationEnteteAchats.setValIdCreateur(this.usersLog.getUsrid());
            this.valorisationEnteteAchats.setValNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (this.valorisationEnteteAchats.getValSerie() != null && !this.valorisationEnteteAchats.getValSerie().equalsIgnoreCase("X") && !this.valorisationEnteteAchats.getValSerie().isEmpty()) {
               this.valorisationEnteteAchats.setValNum(this.calculChrono.numCompose(this.valorisationEnteteAchats.getValDate(), this.nature, this.valorisationEnteteAchats.getValSerie(), var1));
               boolean var25 = false;

               label566:
               while(true) {
                  while(true) {
                     if (var25) {
                        break label566;
                     }

                     new ValorisationEnteteAchats();
                     ValorisationEnteteAchats var6 = this.valorisationEnteteAchatsDao.pourParapheur(this.valorisationEnteteAchats.getValNum(), this.valorisationEnteteAchats.getValSerie(), var1);
                     if (var6 != null) {
                        long var7 = 100000000L * this.usersLog.getUsrid();

                        for(long var9 = 0L; var9 < var7; ++var9) {
                        }

                        this.valorisationEnteteAchats.setValNum(this.calculChrono.numCompose(this.valorisationEnteteAchats.getValDate(), this.nature, this.valorisationEnteteAchats.getValSerie(), var1));
                        var25 = false;
                     } else {
                        var25 = true;
                     }
                  }
               }
            } else {
               long var5 = this.valorisationEnteteAchatsDao.selectLastNum(var1);
               this.valorisationEnteteAchats.setValNum("" + var5);
            }

            this.valorisationEnteteAchats.setValEtat(0);
            this.valorisationEnteteAchats.setValEtatVal(0);
            this.valorisationEnteteAchats.setValDateValide((Date)null);
            this.valorisationEnteteAchats = this.valorisationEnteteAchatsDao.insert(this.valorisationEnteteAchats, var1);
            new PlansAnalytiques();
            PlansAnalytiquesDao var26 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
            var27 = var26.rechercheAnal("6", this.valorisationEnteteAchats.getValDossierTransit(), var1);
            if (var27 == null) {
               var27 = new PlansAnalytiques();
               var27.setAnaNature("6");
               var27.setAnaDateCreat(new Date());
               var27.setAnaUserCreat(this.usersLog.getUsrid());
               var27.setAnaCode(this.valorisationEnteteAchats.getValDossierTransit());
               var27.setAnaNomFr(this.valorisationEnteteAchats.getValObjet());
               var27.setAnaTypeDossier("" + this.valorisationEnteteAchats.getValMode());
               var27.setAnaTypeExoTva(this.valorisationEnteteAchats.isValExoTva());
               var27.setAnaTypeExoDouane(this.valorisationEnteteAchats.isValExoDouane());
               var27.setAnaTypeDevise(this.valorisationEnteteAchats.getValDevise());
               var27.setAnaTypeTauxDevise(this.valorisationEnteteAchats.getValCoefDeviseDouane());
               var27.setAnaAnnee("" + (this.valorisationEnteteAchats.getValDate().getYear() + 1900));
               var27.setAnaAch(true);
               var27.setAnaFrg(false);
               var27.setAnaInv(false);
               var27.setAnaPrd(false);
               var27.setAnaSal(false);
               var27.setAnaTax(false);
               var27.setAnaTva(false);
               var27.setAnaVte(false);
               var26.insert(var27, var1);
            }

            if (this.verifieExistenceHabilitation(var1)) {
               this.Envoieparapheur(var1);
            }

            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.valorisationEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
            this.var_num_ligne = this.lesEntetesList.size() - 1;
         }

         int var29;
         if (this.valorisationEnteteAchats.getValCoef1() != 0.0F) {
            if (this.commandeListe.size() != 0 && this.valorisationEnteteAchats.getValNature1() == 12 && this.listCommandeProduit.size() != 0) {
               for(var29 = 0; var29 < this.listCommandeProduit.size(); ++var29) {
                  this.commandeLigneAchats = (CommandeLigneAchats)this.listCommandeProduit.get(var29);
                  this.commandeLigneAchatsDao.modifLigne(this.commandeLigneAchats, var1);
               }
            }

            if (this.receptionListe.size() != 0 && this.valorisationEnteteAchats.getValNature1() == 13) {
               for(var29 = 0; var29 < this.receptionListe.size(); ++var29) {
                  this.receptionEnteteAchats = (ReceptionEnteteAchats)this.receptionListe.get(var29);
                  this.receptionEnteteAchats.setRecValorisation(1);
                  this.receptionEnteteAchats.setRecCoefValo(this.valorisationEnteteAchats.getValCoef1());
                  this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats, var1);
               }

               if (this.listReceptionProduit.size() != 0) {
                  for(var29 = 0; var29 < this.listReceptionProduit.size(); ++var29) {
                     this.receptionLigneAchats = (ReceptionLigneAchats)this.listReceptionProduit.get(var29);
                     this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
                  }
               }
            }
         }

         if (this.valorisationEnteteAchats.getValCoef2() != 0.0F) {
         }

         if (this.listReceptionProduit.size() != 0) {
            var29 = 0;

            label629:
            while(true) {
               ReceptionLigneAchats var28;
               if (var29 >= this.listReceptionProduit.size()) {
                  var29 = 0;

                  while(true) {
                     if (var29 >= var3.size()) {
                        break label629;
                     }

                     new ReceptionLigneAchats();
                     var28 = (ReceptionLigneAchats)var3.get(var29);
                     if (var28.getRecligSommier() != null && !var28.getRecligSommier().isEmpty()) {
                        new SommierEnteteAchats();
                        SommierEnteteAchats var32 = var4.rechercheBySommierReception(var28.getRecligSommier(), var28.getReceptionEnteteAchats().getRecNum(), var1);
                        if (var32 != null) {
                           var4.delete(var32, var1);
                        }
                     }

                     ++var29;
                  }
               }

               new ReceptionLigneAchats();
               var28 = (ReceptionLigneAchats)this.listReceptionProduit.get(var29);
               if (var28.getRecligSommier() != null && !var28.getRecligSommier().isEmpty()) {
                  String var31 = var28.getRecligSommier();
                  String var8 = var28.getReceptionEnteteAchats().getRecNum();
                  boolean var35 = false;
                  if (var3.size() == 0) {
                     var3.add(var28);
                  } else {
                     for(int var10 = 0; var10 < var3.size(); ++var10) {
                        if (((ReceptionLigneAchats)var3.get(var10)).getRecligSommier().equals(var31) && ((ReceptionLigneAchats)var3.get(var10)).getReceptionEnteteAchats().getRecNum().equals(var8)) {
                           var35 = true;
                        }
                     }

                     if (!var35) {
                        var3.add(var28);
                     }
                  }
               }

               ++var29;
            }
         }

         var2.commit();
      } catch (HibernateException var23) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var23;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var3.size() != 0) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
         var27 = null;

         try {
            Transaction var37 = var1.beginTransaction();

            for(int var30 = 0; var30 < var3.size(); ++var30) {
               new ReceptionLigneAchats();
               new SommierEnteteAchats();
               ReceptionLigneAchats var33 = (ReceptionLigneAchats)var3.get(var30);
               SommierEnteteAchats var34 = new SommierEnteteAchats();
               var34.setExercicesAchats(this.exercicesAchats);
               var34.setSomDateCreat(new Date());
               var34.setSomDate(var33.getReceptionEnteteAchats().getRecDate());
               Date var36 = this.utilDate.datedevaleurTheo(var34.getSomDate(), 365);
               var34.setSomDateExpiration(var36);
               var34.setSomDossierTransit(var33.getReceptionEnteteAchats().getRecAnal4());
               var34.setSomIdCreateur(this.usersLog.getUsrid());
               var34.setSomIdResponsable(this.valorisationEnteteAchats.getValIdResponsable());
               var34.setSomNomResponsable(this.valorisationEnteteAchats.getValNomResponsable());
               var34.setSomNum(var33.getRecligSommier());
               var34.setSomReception(var33.getReceptionEnteteAchats().getRecNum());
               var34.setSomType(0);
               var34.setSomNomTiers(var33.getReceptionEnteteAchats().getRecNomTiers());
               var34.setSomRegime(var33.getReceptionEnteteAchats().getRecCat());
               var4.insert(var34, var1);
            }

            var37.commit();
         } catch (HibernateException var21) {
            if (var27 != null) {
               var27.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void majAnalytique() {
      this.valorisationEnteteAchats.setValSite(this.usersLog.getUsrSite());
      this.valorisationEnteteAchats.setValDepartement(this.usersLog.getUsrDepartement());
      this.valorisationEnteteAchats.setValService(this.usersLog.getUsrService());
      this.valorisationEnteteAchats.setValRegion("");
      this.valorisationEnteteAchats.setValSecteur("");
      this.valorisationEnteteAchats.setValPdv("");
   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.valorisationEnteteAchats.setValEtatVal(1);
         this.valorisationEnteteAchats.setValEtat(0);
         this.valorisationEnteteAchats.setValDateValide((Date)null);
         return true;
      } else {
         this.valorisationEnteteAchats.setValEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.valorisationEnteteAchats.setValEtat(1);
               this.valorisationEnteteAchats.setValDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.valorisationEnteteAchats.setValEtat(0);
               this.valorisationEnteteAchats.setValDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void selectionLigneDetailValo() {
      if (this.valorisationEnteteAchats.getValNature1() == 12) {
         this.choixType = false;
         if (this.dataModelDetailValo.isRowAvailable()) {
            this.commandeLigneAchats = (CommandeLigneAchats)this.dataModelDetailValo.getRowData();
         }
      } else if (this.valorisationEnteteAchats.getValNature1() == 13) {
         this.choixType = true;
         if (this.dataModelDetailValo.isRowAvailable()) {
            this.receptionLigneAchats = (ReceptionLigneAchats)this.dataModelDetailValo.getRowData();
         }
      }

   }

   public void rechercheDouaneCmd() throws JDOMException, IOException, HibernateException, NamingException {
      this.choixType = false;
      if (this.commandeLigneAchats.getCmdligDouane() != null && !this.commandeLigneAchats.getCmdligDouane().isEmpty()) {
         new ArrayList();
         List var1 = this.douanesPositionDao.recherchePosition(this.structureLog.getStrzonecommerciale(), this.commandeLigneAchats.getCmdligDouane(), (Session)null);
         if (var1.size() == 1) {
            this.douanesPosition = (DouanesPosition)var1.get(0);
            this.calculeDouane();
         } else if (var1.size() > 1) {
            this.datamodelDouane.setWrappedData(var1);
            this.showModalPanelDouane = true;
         } else {
            this.annuleDouane();
         }
      }

   }

   public void rechercheDouaneRec() throws JDOMException, IOException, HibernateException, NamingException {
      this.choixType = true;
      if (this.receptionLigneAchats.getRecligDouane() != null && !this.receptionLigneAchats.getRecligDouane().isEmpty()) {
         new ArrayList();
         List var1 = this.douanesPositionDao.recherchePosition(this.structureLog.getStrzonecommerciale(), this.receptionLigneAchats.getRecligDouane(), (Session)null);
         if (var1.size() == 1) {
            this.douanesPosition = (DouanesPosition)var1.get(0);
            this.calculeDouane();
         } else if (var1.size() > 1) {
            this.datamodelDouane.setWrappedData(var1);
            this.showModalPanelDouane = true;
         } else {
            this.annuleDouane();
         }
      }

   }

   public void selectionDouane() throws JDOMException, IOException {
      if (this.datamodelDouane.isRowAvailable()) {
         this.douanesPosition = (DouanesPosition)this.datamodelDouane.getRowData();
      }

   }

   public void calculeDouane() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.douanesPosition == null) {
         this.selectionDouane();
      }

      if (!this.choixType) {
         if (this.douanesPosition != null) {
            this.commandeLigneAchats.setCmdligDouane(this.douanesPosition.getDouposCode());
         } else {
            this.commandeLigneAchats.setCmdligDouane("");
         }

         this.commandeLigneAchats = this.commandeLigneAchatsDao.modifLigne(this.commandeLigneAchats);
      } else {
         if (this.douanesPosition != null) {
            this.receptionLigneAchats.setRecligDouane(this.douanesPosition.getDouposCode());
         } else {
            this.receptionLigneAchats.setRecligDouane("");
         }

         this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats);
      }

      this.showModalPanelDouane = false;
   }

   public void annuleDouane() {
      if (!this.choixType) {
         this.commandeLigneAchats.setCmdligDouane("");
      } else {
         this.receptionLigneAchats.setRecligDouane("");
      }

      this.showModalPanelDouane = false;
   }

   public void rechercheAssureur() throws JDOMException, IOException, HibernateException, NamingException {
      this.typeTiers = 1;
      this.tiers = this.formRecherche.rechercheTiers(0, this.valorisationEnteteAchats.getValNomAssureur(), this.nature, "Assureur");
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

   public void rechercheTransitaire() throws JDOMException, IOException, HibernateException, NamingException {
      this.typeTiers = 2;
      this.tiers = this.formRecherche.rechercheTiers(0, this.valorisationEnteteAchats.getValNomTransitaire(), this.nature, "Transitaire");
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

   public void rechercheTransporteur() throws JDOMException, IOException, HibernateException, NamingException {
      this.typeTiers = 3;
      this.tiers = this.formRecherche.rechercheTiers(0, this.valorisationEnteteAchats.getValNomTransporteur(), this.nature, "Transporteur");
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

   public void rechercheBanque() throws JDOMException, IOException, HibernateException, NamingException {
      this.typeTiers = 4;
      this.tiers = this.formRecherche.rechercheTiers(0, this.valorisationEnteteAchats.getValBanque(), this.nature, "Banque");
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

   public void recuperationTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.tiers = this.formRecherche.calculeTiers();
      this.calculeTiers();
   }

   public void calculeTiers() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.tiers != null) {
         if (this.typeTiers == 1) {
            this.valorisationEnteteAchats.setValIdAssureur(this.tiers.getTieid());
            this.valorisationEnteteAchats.setValNomAssureur(this.tiers.getTieraisonsocialenom());
         } else if (this.typeTiers == 2) {
            this.valorisationEnteteAchats.setValIdTransitaire(this.tiers.getTieid());
            this.valorisationEnteteAchats.setValNomTransitaire(this.tiers.getTieraisonsocialenom());
         } else if (this.typeTiers == 3) {
            this.valorisationEnteteAchats.setValIdTransporteur(this.tiers.getTieid());
            this.valorisationEnteteAchats.setValNomTransporteur(this.tiers.getTieraisonsocialenom());
         } else if (this.typeTiers == 4) {
            this.valorisationEnteteAchats.setValIdBanque(this.tiers.getTieid());
            this.valorisationEnteteAchats.setValBanque(this.tiers.getTieraisonsocialenom());
         }
      } else {
         this.annuleTiers();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() {
      this.tiers = null;
      if (this.typeTiers == 1) {
         this.valorisationEnteteAchats.setValIdAssureur(0L);
         this.valorisationEnteteAchats.setValNomAssureur("");
      } else if (this.typeTiers == 2) {
         this.valorisationEnteteAchats.setValIdTransitaire(0L);
         this.valorisationEnteteAchats.setValNomTransitaire("");
      } else if (this.typeTiers == 3) {
         this.valorisationEnteteAchats.setValIdTransporteur(0L);
         this.valorisationEnteteAchats.setValNomTransporteur("");
      } else if (this.typeTiers == 4) {
         this.valorisationEnteteAchats.setValIdBanque(0L);
         this.valorisationEnteteAchats.setValBanque("");
      }

      this.var_action = this.var_memo_action;
   }

   public void selectionNonValo() {
      if (this.datamodelElementNonValo.isRowAvailable()) {
         this.documentEntete = (DocumentEntete)this.datamodelElementNonValo.getRowData();
      }

   }

   public void valideNonValo() throws HibernateException, NamingException {
      if (this.documentEntete == null) {
         this.selectionNonValo();
      }

      if (this.var_choix_document == 12) {
         this.commandeEnteteAchats = this.commandeEnteteAchatsDao.pourParapheur(this.documentEntete.getDocIdCreateur(), (Session)null);
         if (this.commandeEnteteAchats != null) {
            this.commandeEnteteAchats.setCmdValo(this.valorisationEnteteAchats.getValNum());
            this.commandeEnteteAchats = this.commandeEnteteAchatsDao.modif(this.commandeEnteteAchats);
            this.chargerCommandeAchats((Session)null);
         }
      } else if (this.var_choix_document == 13) {
         this.receptionEnteteAchats = this.receptionEnteteAchatsDao.pourParapheur(this.documentEntete.getDocIdCreateur(), (Session)null);
         if (this.receptionEnteteAchats != null) {
            this.receptionEnteteAchats.setRecValo(this.valorisationEnteteAchats.getValNum());
            this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats);
            this.chargerReceptionAchats((Session)null);
         }
      } else if (this.var_choix_document == 17) {
         this.noteDebitEnteteAchats = this.noteDebitEnteteAchatsDao.pourParapheur(this.documentEntete.getDocIdCreateur(), (Session)null);
         if (this.noteDebitEnteteAchats != null) {
            this.noteDebitEnteteAchats.setNdfValo(this.valorisationEnteteAchats.getValNum());
            this.noteDebitEnteteAchats = this.noteDebitEnteteAchatsDao.modif(this.noteDebitEnteteAchats);
            this.chargerNoteDebitAchats((Session)null);
         }
      } else if (this.var_choix_document == 47) {
      }

      this.showModalPanelNonValo = false;
   }

   public void annuleNonValo() {
      this.showModalPanelNonValo = false;
   }

   public void addCmd() throws HibernateException, NamingException {
      this.var_choix_document = 12;
      this.commandeListe = new ArrayList();
      this.commandeListe = this.commandeEnteteAchatsDao.rechercheNonValoriser(this.valorisationEnteteAchats.getValDossierTransit(), (Session)null);
      if (this.commandeListe.size() != 0) {
         this.listeDocument.clear();

         for(int var1 = 0; var1 < this.commandeListe.size(); ++var1) {
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setDocIdCreateur(((CommandeEnteteAchats)this.commandeListe.get(var1)).getCmdId());
            this.documentEntete.setDocDate(((CommandeEnteteAchats)this.commandeListe.get(var1)).getCmdDate());
            this.documentEntete.setDocNum(((CommandeEnteteAchats)this.commandeListe.get(var1)).getCmdNum());
            this.documentEntete.setDocNomTiers(((CommandeEnteteAchats)this.commandeListe.get(var1)).getCmdNomTiers());
            this.documentEntete.setDocSerie(((CommandeEnteteAchats)this.commandeListe.get(var1)).getCmdSerie());
            this.documentEntete.setDocActivite(((CommandeEnteteAchats)this.commandeListe.get(var1)).getCmdActivite());
            this.documentEntete.setDocAnal4(((CommandeEnteteAchats)this.commandeListe.get(var1)).getCmdAnal4());
            this.documentEntete.setDocTotHt(((CommandeEnteteAchats)this.commandeListe.get(var1)).getCmdTotHt());
            this.listeDocument.add(this.documentEntete);
         }

         this.datamodelElementNonValo.setWrappedData(this.listeDocument);
         this.showModalPanelNonValo = true;
      }

   }

   public void selectionCmd() {
      if (this.datamodelCommande.isRowAvailable()) {
         this.commandeEnteteAchats = (CommandeEnteteAchats)this.datamodelCommande.getRowData();
      }

   }

   public void deleteCmd() throws HibernateException, NamingException {
      if (this.commandeEnteteAchats == null) {
         this.selectionCmd();
      }

      if (this.commandeEnteteAchats != null) {
         this.commandeEnteteAchats.setCmdValo("");
         this.commandeEnteteAchats = this.commandeEnteteAchatsDao.modif(this.commandeEnteteAchats);
         this.chargerCommandeAchats((Session)null);
      }

   }

   public void addRec() throws HibernateException, NamingException {
      this.var_choix_document = 13;
      this.receptionListe = new ArrayList();
      this.receptionListe = this.receptionEnteteAchatsDao.rechercheNonValoriser(this.valorisationEnteteAchats.getValDossierTransit(), (Session)null);
      if (this.receptionListe.size() != 0) {
         this.listeDocument.clear();

         for(int var1 = 0; var1 < this.receptionListe.size(); ++var1) {
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setDocIdCreateur(((ReceptionEnteteAchats)this.receptionListe.get(var1)).getRecId());
            this.documentEntete.setDocDate(((ReceptionEnteteAchats)this.receptionListe.get(var1)).getRecDate());
            this.documentEntete.setDocNum(((ReceptionEnteteAchats)this.receptionListe.get(var1)).getRecNum());
            this.documentEntete.setDocNomTiers(((ReceptionEnteteAchats)this.receptionListe.get(var1)).getRecNomTiers());
            this.documentEntete.setDocSerie(((ReceptionEnteteAchats)this.receptionListe.get(var1)).getRecSerie());
            this.documentEntete.setDocActivite(((ReceptionEnteteAchats)this.receptionListe.get(var1)).getRecActivite());
            this.documentEntete.setDocAnal4(((ReceptionEnteteAchats)this.receptionListe.get(var1)).getRecAnal4());
            this.documentEntete.setDocTotHt(((ReceptionEnteteAchats)this.receptionListe.get(var1)).getRecTotHt());
            this.listeDocument.add(this.documentEntete);
         }

         this.datamodelElementNonValo.setWrappedData(this.listeDocument);
         this.showModalPanelNonValo = true;
      }

   }

   public void selectionRec() {
      if (this.datamodelReception.isRowAvailable()) {
         this.receptionEnteteAchats = (ReceptionEnteteAchats)this.datamodelReception.getRowData();
      }

   }

   public void deleteRec() throws HibernateException, NamingException {
      if (this.receptionEnteteAchats == null) {
         this.selectionRec();
      }

      if (this.receptionEnteteAchats != null) {
         this.receptionEnteteAchats.setRecValo((String)null);
         this.receptionEnteteAchats.setRecCoefValo(0.0F);
         this.receptionEnteteAchats = this.receptionEnteteAchatsDao.modif(this.receptionEnteteAchats);
         this.chargerReceptionAchats((Session)null);
      }

   }

   public void addNdb() throws HibernateException, NamingException {
      this.var_choix_document = 17;
      this.noteDebitListe = new ArrayList();
      this.noteDebitListe = this.noteDebitEnteteAchatsDao.rechercheNonValoriser(this.valorisationEnteteAchats.getValDossierTransit(), (Session)null);
      if (this.noteDebitListe.size() != 0) {
         this.listeDocument.clear();

         for(int var1 = 0; var1 < this.noteDebitListe.size(); ++var1) {
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setDocIdCreateur(((NoteDebitEnteteAchats)this.noteDebitListe.get(var1)).getNdfId());
            this.documentEntete.setDocDate(((NoteDebitEnteteAchats)this.noteDebitListe.get(var1)).getNdfDate());
            this.documentEntete.setDocNum(((NoteDebitEnteteAchats)this.noteDebitListe.get(var1)).getNdfNum());
            this.documentEntete.setDocNomTiers(((NoteDebitEnteteAchats)this.noteDebitListe.get(var1)).getNdfNomTiers());
            this.documentEntete.setDocSerie(((NoteDebitEnteteAchats)this.noteDebitListe.get(var1)).getNdfSerie());
            this.documentEntete.setDocActivite(((NoteDebitEnteteAchats)this.noteDebitListe.get(var1)).getNdfActivite());
            this.documentEntete.setDocAnal4(((NoteDebitEnteteAchats)this.noteDebitListe.get(var1)).getNdfAnal4());
            this.documentEntete.setDocTotHt(((NoteDebitEnteteAchats)this.noteDebitListe.get(var1)).getNdfTotHt());
            this.listeDocument.add(this.documentEntete);
         }

         this.datamodelElementNonValo.setWrappedData(this.listeDocument);
         this.showModalPanelNonValo = true;
      }

   }

   public void selectionNdb() {
      if (this.datamodelNdb.isRowAvailable()) {
         this.noteDebitEnteteAchats = (NoteDebitEnteteAchats)this.datamodelNdb.getRowData();
      }

   }

   public void deleteNdb() throws HibernateException, NamingException {
      if (this.noteDebitEnteteAchats == null) {
         this.selectionNdb();
      }

      if (this.noteDebitEnteteAchats != null) {
         this.noteDebitEnteteAchats.setNdfValo((String)null);
         this.noteDebitEnteteAchats = this.noteDebitEnteteAchatsDao.modif(this.noteDebitEnteteAchats);
         this.chargerNoteDebitAchats((Session)null);
      }

   }

   public void addRex() {
      this.var_choix_document = 47;
   }

   public void deleteRex() {
   }

   public void addFra() throws HibernateException, NamingException {
      String var1 = "";
      int var2;
      if (this.commandeListe.size() != 0) {
         for(var2 = 0; var2 < this.commandeListe.size(); ++var2) {
            this.commandeEnteteAchats = new CommandeEnteteAchats();
            this.commandeEnteteAchats = (CommandeEnteteAchats)this.commandeListe.get(var2);
            if (this.commandeEnteteAchats.getCmdAnal4() != null && !this.commandeEnteteAchats.getCmdAnal4().isEmpty()) {
               if (var1.isEmpty()) {
                  var1 = "'" + this.commandeEnteteAchats.getCmdAnal4() + "'";
               } else {
                  var1 = var1 + "," + "'" + this.commandeEnteteAchats.getCmdAnal4() + "'";
               }
            }
         }
      }

      if (this.receptionListe.size() != 0) {
         for(var2 = 0; var2 < this.receptionListe.size(); ++var2) {
            this.receptionEnteteAchats = new ReceptionEnteteAchats();
            this.receptionEnteteAchats = (ReceptionEnteteAchats)this.receptionListe.get(var2);
            if (this.receptionEnteteAchats.getRecAnal4() != null && !this.receptionEnteteAchats.getRecAnal4().isEmpty()) {
               if (var1.isEmpty()) {
                  var1 = "'" + this.receptionEnteteAchats.getRecAnal4() + "'";
               } else if (!var1.contains(this.receptionEnteteAchats.getRecAnal4())) {
                  var1 = var1 + "," + "'" + this.receptionEnteteAchats.getRecAnal4() + "'";
               }
            }
         }
      }

      this.fraisList.clear();
      if (!var1.isEmpty()) {
         Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEntete");
         Transaction var3 = null;

         try {
            var3 = var10.beginTransaction();
            var1 = "(" + var1 + ")";
            this.fraisList = this.fraisEnteteAchatsDao.rechercheByDossier(var1, var10);
            if (this.fraisList.size() != 0) {
               for(int var4 = 0; var4 < this.fraisList.size(); ++var4) {
                  this.fraisEnteteAchats = new FraisEnteteAchats();
                  this.fraisEnteteAchats = (FraisEnteteAchats)this.fraisList.get(var4);
                  this.fraisEnteteAchats.setFsfValo(this.valorisationEnteteAchats.getValNum());
                  if (this.valorisationEnteteAchats.getValCoef1() == 0.0F) {
                     this.fraisEnteteAchats.setFsfTypeValo(1);
                  } else {
                     this.fraisEnteteAchats.setFsfTypeValo(2);
                  }

                  this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var10);
               }
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

      this.datamodelFrais.setWrappedData(this.fraisList);
   }

   public void selectionFra() {
      if (this.datamodelFrais.isRowAvailable()) {
         this.fraisEnteteAchats = (FraisEnteteAchats)this.datamodelFrais.getRowData();
      }

   }

   public void deleteFra() throws HibernateException, NamingException {
      if (this.fraisEnteteAchats == null) {
         this.selectionFra();
      }

      if (this.fraisEnteteAchats != null) {
         this.fraisEnteteAchats.setFsfValo("");
         this.fraisEnteteAchats.setFsfTypeValo(0);
         this.fraisEnteteAchats = this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats);
         this.chargerDocumentFrais((Session)null);
      }

   }

   public void consultFra() throws HibernateException, NamingException {
      if (this.fraisEnteteAchats != null) {
         new ArrayList();
         FraisLigneAchatsDao var2 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         List var1 = var2.chargerLesLignes(this.fraisEnteteAchats, (Session)null);
         this.datamodelDetailFrais.setWrappedData(var1);
         this.showModalPanelFais = true;
      }

   }

   public void annuleFra() {
      this.showModalPanelFais = false;
   }

   public void calculDevise() throws HibernateException, NamingException {
      this.valorisationEnteteAchats.setValCoefDeviseDouane(0.0F);
      this.calculDevise((Session)null);
   }

   public void calculDevise(Session var1) throws HibernateException, NamingException {
      if (this.valorisationEnteteAchats.getValDevise() != null && this.valorisationEnteteAchats.getValCoefDeviseDouane() == 0.0F) {
         if (this.valorisationEnteteAchats.getValDevise().equals(this.structureLog.getStrdevise())) {
            this.valorisationEnteteAchats.setValCoefDeviseDouane(1.0F);
         } else {
            new ObjetDevises();
            LectureDevises var3 = new LectureDevises();
            new Devise();
            DeviseDao var5 = new DeviseDao(this.baseLog, this.utilInitHibernate);
            Devise var4 = var5.chargerLesDevises(this.valorisationEnteteAchats.getValDevise(), var1);
            ObjetDevises var2;
            float var6;
            float var7;
            float var8;
            float var9;
            if (var4 != null) {
               var6 = var4.getDevTaux1();
               var7 = var4.getDevTaux2();
               var2 = var3.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
               var8 = Float.parseFloat(var2.getTaux1());
               var9 = Float.parseFloat(var2.getTaux2());
               this.valorisationEnteteAchats.setValCoefDeviseDouane(var6 * var9);
            }

            if (this.valorisationEnteteAchats.getValCoefDeviseDouane() == 0.0F) {
               var2 = var3.devisesRecherchee(this.valorisationEnteteAchats.getValDevise(), this.structureLog.getStrdevise());
               var6 = Float.parseFloat(var2.getTaux1());
               var7 = Float.parseFloat(var2.getTaux2());
               var2 = var3.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
               var8 = Float.parseFloat(var2.getTaux1());
               var9 = Float.parseFloat(var2.getTaux2());
               this.valorisationEnteteAchats.setValCoefDeviseDouane(var6 * var9);
            }
         }
      }

   }

   public double calculAssuranceTheorique(double var1, double var3, Session var5) throws HibernateException, NamingException {
      double var6 = 0.0D;
      if (this.valorisationEnteteAchats.getValIdAssureur() != 0L) {
         this.tiers = this.tiersDao.selectTierD(this.valorisationEnteteAchats.getValIdAssureur(), var5);
         if (this.tiers != null && this.valorisationEnteteAchats.getValNature1() != 0) {
            double var8 = this.utilNombre.myRoundDevise((var1 + var3) * (double)this.tiers.getTieassurt1() / 100.0D, this.structureLog.getStrdevise());
            double var10 = var8 + this.tiers.getTieassurt2();
            double var12 = this.utilNombre.myRoundDevise(var10 * (double)this.tiers.getTieassurt3() / 100.0D, this.structureLog.getStrdevise());
            var6 = var10 + var12;
         }
      }

      return var6;
   }

   public double calculFinancierTheorique(double var1, double var3, Session var5) throws HibernateException, NamingException {
      double var6 = 0.0D;
      if (this.valorisationEnteteAchats.getValIdBanque() != 0L) {
         this.tiers = this.tiersDao.selectTierD(this.valorisationEnteteAchats.getValIdBanque(), var5);
         if (this.tiers != null && this.valorisationEnteteAchats.getValNature1() != 0) {
            if (this.valorisationEnteteAchats.getValNbVirement() == 0) {
               this.valorisationEnteteAchats.setValNbVirement(1);
            }

            double var8 = 0.0D;
            if (this.valorisationEnteteAchats.getValNature1() == 13) {
               var8 = this.valorisationEnteteAchats.getValTotalReception();
            } else {
               var8 = this.valorisationEnteteAchats.getValTotalCommande();
            }

            double var10 = var8 * (double)this.tiers.getTiebnq2() / 100.0D;
            double var12 = var10 * (double)this.tiers.getTiebnq6() / 100.0D;
            double var14 = var8 * (double)this.tiers.getTiebnq4() / 100.0D;
            double var16 = this.tiers.getTiebnq3();
            double var18 = var8 * (double)this.tiers.getTiebnq7() / 100.0D;
            double var20 = var18 * (double)this.tiers.getTiebnq6() / 100.0D;
            double var22 = this.tiers.getTiebnq1() * (double)this.valorisationEnteteAchats.getValNbVirement();
            double var24 = this.tiers.getTiebnq5();
            var6 = this.utilNombre.myRoundDevise(var10 + var12 + var14 + var16 + var18 + var20 + var22 + var24, this.structureLog.getStrdevise());
         }
      }

      return var6;
   }

   public void calculValo1() throws HibernateException, NamingException {
      if (this.valorisationEnteteAchats.getValCalculPr() == 0) {
         if (this.valorisationEnteteAchats.getValNature1() == 12) {
            this.majLigneValoCommande();
            this.calculValo1CmdPoids();
         } else if (this.valorisationEnteteAchats.getValNature1() == 13) {
            this.majLigneValoReception();
            this.calculValo1RecPoids();
         }
      } else if (this.valorisationEnteteAchats.getValNature1() == 12) {
         this.majLigneValoCommande();
         this.calculValo1CmdValeur();
      } else if (this.valorisationEnteteAchats.getValNature1() == 13) {
         this.majLigneValoReception();
         this.calculValo1RecValeur();
      }

   }

   public void majLigneValoCommande() throws HibernateException, NamingException {
      if (this.listCommandeProduit.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.listCommandeProduit.size(); ++var3) {
               this.commandeLigneAchats = (CommandeLigneAchats)this.listCommandeProduit.get(var3);
               this.commandeLigneAchats = this.commandeLigneAchatsDao.modifLigne(this.commandeLigneAchats, var1);
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

   public void majLigneValoReception() throws HibernateException, NamingException {
      if (this.listReceptionProduit.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.listReceptionProduit.size(); ++var3) {
               this.receptionLigneAchats = (ReceptionLigneAchats)this.listReceptionProduit.get(var3);
               this.receptionLigneAchats = this.receptionLigneAchatsDao.modifLigne(this.receptionLigneAchats, var1);
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

   public void calculValo1CmdPoids() throws HibernateException, NamingException {
      float var1 = 0.0F;
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      boolean var18 = false;
      boolean var19 = false;
      boolean var20 = false;
      double var21 = 0.0D;
      double var23 = 0.0D;
      double var25 = 0.0D;
      Session var27 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
      this.listCommandeProduit = new ArrayList();
      ArrayList var28 = new ArrayList();
      ArrayList var29 = new ArrayList();
      FraisLigneAchatsDao var30 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      int var33;
      if (this.commandeListe.size() != 0 && this.valorisationEnteteAchats.getValNature1() == 12) {
         for(int var31 = 0; var31 < this.commandeListe.size(); ++var31) {
            var10 = var10 + ((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdTotHtLocal() + this.commandeEnteteAchats.getCmdTotCertificat() * (double)this.commandeEnteteAchats.getCmdCoefDevise() + this.commandeEnteteAchats.getCmdTotCertificatConformite() * (double)this.commandeEnteteAchats.getCmdCoefDevise() + this.commandeEnteteAchats.getCmdTotFraisAdm() * (double)this.commandeEnteteAchats.getCmdCoefDevise();
            var2 += ((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdTotFretLocal();
            if (((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdIncoterm() != null && !((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdIncoterm().isEmpty() && (((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdIncoterm().equals("CFR") || ((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdIncoterm().equals("CIF") || ((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdIncoterm().equals("CPT"))) {
               if (this.optionAchats.getModeCifCfrREC().equals("1")) {
                  var4 += ((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdTotFretLocal();
                  var6 += ((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdTotFret2Local();
                  var8 += ((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdTotAssuranceLocal();
               }

               var21 += ((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdTotFretLocal();
               var23 += ((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdTotFret2Local();
               var25 += ((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdTotAssuranceLocal();
               if (((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdIncoterm().equals("CFR")) {
                  var18 = true;
               } else if (((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdIncoterm().equals("CTP")) {
                  var19 = true;
               }
            } else if (this.receptionEnteteAchats.getRecIncoterm() != null && !this.receptionEnteteAchats.getRecIncoterm().isEmpty() && this.receptionEnteteAchats.getRecIncoterm().equals("EXW")) {
               var10 += ((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdTotFret2Local();
               var20 = true;
            }

            new ArrayList();
            List var32 = this.commandeLigneAchatsDao.chargerLesLignes((CommandeEnteteAchats)this.commandeListe.get(var31), var27);
            if (var32.size() != 0) {
               for(var33 = 0; var33 < var32.size(); ++var33) {
                  if (((CommandeLigneAchats)var32.get(var33)).getCmdligQte() != 0.0F) {
                     var1 += ((CommandeLigneAchats)var32.get(var33)).getCmdligPoidsNet();
                     var16 += ((CommandeLigneAchats)var32.get(var33)).getCmdligPtDev();
                     this.listCommandeProduit.add(var32.get(var33));
                  }
               }
            }

            new ArrayList();
            List var157 = this.noteDebitLigneAchatsDao.chargerLesLignesByDossier(((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdAnal4(), var27);
            if (var157.size() != 0) {
               for(int var34 = 0; var34 < var157.size(); ++var34) {
                  if (((NoteDebitLigneAchats)var157.get(var34)).getNdfligQte() != 0.0F) {
                     var16 += ((NoteDebitLigneAchats)var157.get(var34)).getNdfligTtc();
                     var29.add(var157.get(var34));
                  }
               }
            }

            new ArrayList();
            List var159 = var30.chargerLesLignesByDossier(((CommandeEnteteAchats)this.commandeListe.get(var31)).getCmdAnal4(), var27);
            if (var159.size() != 0) {
               for(int var35 = 0; var35 < var159.size(); ++var35) {
                  if (((FraisLigneAchats)var159.get(var35)).getFraisEnteteAchats().getFsfNumDoc() != null && !((FraisLigneAchats)var159.get(var35)).getFraisEnteteAchats().getFsfNumDoc().isEmpty() && ((FraisLigneAchats)var159.get(var35)).getFraisEnteteAchats().getFsfNumDoc().contains(":")) {
                     String[] var36 = ((FraisLigneAchats)var159.get(var35)).getFraisEnteteAchats().getFsfNumDoc().split(":");
                     if (this.commandeEnteteAchats.getCmdNum().equals(var36[1])) {
                        var28.add(var159.get(var35));
                     }
                  }
               }
            }
         }

         new ArrayList();
         List var154 = var30.chargerLesLignesByDossier(this.commandeEnteteAchats.getCmdAnal4(), var27);
         if (var154.size() != 0) {
            for(int var156 = 0; var156 < var154.size(); ++var156) {
               if (((FraisLigneAchats)var154.get(var156)).getFraisEnteteAchats().getFsfNumDoc() == null || ((FraisLigneAchats)var154.get(var156)).getFraisEnteteAchats().getFsfNumDoc().isEmpty() || ((FraisLigneAchats)var154.get(var156)).getFraisEnteteAchats().getFsfNumDoc().equals("CMD") || ((FraisLigneAchats)var154.get(var156)).getFraisEnteteAchats().getFsfNumDoc().equals("")) {
                  var28.add(var154.get(var156));
               }
            }
         }
      }

      double var155;
      if (this.fraisList.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         var155 = 0.0D;

         for(var33 = 0; var33 < this.fraisList.size(); ++var33) {
            if (((FraisEnteteAchats)this.fraisList.get(var33)).getFsfTypeValo() == 1) {
               var155 += ((FraisEnteteAchats)this.fraisList.get(var33)).getFsfTotHt();
            }

            var16 += ((FraisEnteteAchats)this.fraisList.get(var33)).getFsfTotTtc();
         }
      }

      if (this.valorisationEnteteAchats.getValCoefDeviseDouane() == 0.0F) {
         this.valorisationEnteteAchats.setValCoefDeviseDouane(1.0F);
      }

      var155 = 0.0D;
      double var158 = var2;
      double var160 = 0.0D;
      double var37 = 0.0D;
      double var39 = 0.0D;
      double var41 = 0.0D;
      double var43 = 0.0D;
      int var45;
      if (var28.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         for(var45 = 0; var45 < var28.size(); ++var45) {
            if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 0) {
               var155 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 1) {
               if (var18) {
                  var21 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               } else if (var19) {
                  var23 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               } else {
                  var158 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               }
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 2) {
               var25 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 3) {
               var160 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 4) {
               var37 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 5) {
               var39 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 6) {
               var43 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() != 7) {
               if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 8) {
                  var41 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 9) {
                  var10 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
                  var12 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               } else {
                  var155 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               }
            }
         }

         var12 = var12 + this.commandeEnteteAchats.getCmdTotCertificat() * (double)this.commandeEnteteAchats.getCmdCoefDevise() + this.commandeEnteteAchats.getCmdTotCertificatConformite() * (double)this.commandeEnteteAchats.getCmdCoefDevise() + this.commandeEnteteAchats.getCmdTotFraisAdm() * (double)this.commandeEnteteAchats.getCmdCoefDevise();
      }

      if (var29.size() != 0) {
         for(var45 = 0; var45 < var29.size(); ++var45) {
            var43 -= ((NoteDebitLigneAchats)var29.get(var45)).getNdfligPt();
         }
      }

      this.valorisationEnteteAchats.setValTotalCommande(var10);
      this.valorisationEnteteAchats.setValTotalFob(var10);
      this.valorisationEnteteAchats.setValTotalFret(var158);
      double var161;
      if (this.optionAchats.getModValoFret().equals("0") && (this.valorisationEnteteAchats.getValMode() == 1 || this.valorisationEnteteAchats.getValMode() == 2)) {
         var161 = this.utilNombre.myRoundDevise(this.valorisationEnteteAchats.getValTotalFret() / 2.0D, this.structureLog.getStrdevise());
         this.valorisationEnteteAchats.setValTotalFret(var161);
      }

      this.valorisationEnteteAchats.setValTotalAssuranceReelle(var25);
      this.valorisationEnteteAchats.setValTotalDouaneReelle(var160);
      var14 = (double)this.utilNombre.myRoundDevise(this.valorisationEnteteAchats.getValCoefForfaitTransport() * var1, this.structureLog.getStrdevise());
      this.valorisationEnteteAchats.setValForfaitTransport(var14);
      this.valorisationEnteteAchats.setValTotalTvaDouaneReelle(var37);
      if (this.valorisationEnteteAchats.getValFictif() == 0) {
         this.valorisationEnteteAchats.setValTotalTransit(var39);
         this.valorisationEnteteAchats.setValTotalDebours(var43 + var155);
      } else if (this.valorisationEnteteAchats.getValFictif() == 1) {
         this.valorisationEnteteAchats.setValTotalTransit(var39);
         this.valorisationEnteteAchats.setValTotalDebours(var43 + var155);
      } else if (this.valorisationEnteteAchats.getValFictif() == 2) {
         var39 = this.valorisationEnteteAchats.getValTotalTransit();
         var43 = this.valorisationEnteteAchats.getValTotalDebours();
      }

      this.valorisationEnteteAchats.setValPr1Ttc(var16);
      var161 = 0.0D;
      if (var19) {
         var161 = this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFret() + this.valorisationEnteteAchats.getValForfaitTransport();
      } else {
         var161 = this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFret();
      }

      double var47 = this.valorisationEnteteAchats.getValTotalAssuranceReelle();
      double var49 = this.valorisationEnteteAchats.getValTotalDouaneReelle();
      double var51 = this.valorisationEnteteAchats.getValTotalTvaDouaneReelle();
      double var53 = this.valorisationEnteteAchats.getValTotalFinancierReelle();
      double var55 = this.valorisationEnteteAchats.getValTotalTransit();
      double var57 = this.valorisationEnteteAchats.getValTotalDebours() + this.valorisationEnteteAchats.getValTotalFraisProv();
      double var59 = this.valorisationEnteteAchats.getValForfaitTransport();
      double var61 = var161 + var47;
      double var63 = this.calculAssuranceTheorique(this.valorisationEnteteAchats.getValTotalFob(), this.valorisationEnteteAchats.getValTotalFret(), var27);
      double var65 = 0.0D;
      double var67 = 0.0D;
      double var69 = this.calculFinancierTheorique(this.valorisationEnteteAchats.getValTotalFob(), this.valorisationEnteteAchats.getValTotalFret(), var27);
      double var71 = 0.0D;
      double var73 = 0.0D;
      double var75 = 0.0D;
      double var77 = var161 + var63;
      double var79 = this.valorisationEnteteAchats.getValTotalAssuranceProv();
      double var81 = this.valorisationEnteteAchats.getValTotalDouaneProv();
      double var83 = this.valorisationEnteteAchats.getValTotalTvaDouaneProv();
      double var85 = this.valorisationEnteteAchats.getValTotalFinancierProv();
      double var87 = 0.0D;
      double var89 = 0.0D;
      double var91 = 0.0D;
      double var10000 = var161 + var79;
      double var97;
      double var99;
      double var101;
      double var103;
      double var105;
      double var107;
      double var109;
      double var111;
      if (this.listCommandeProduit.size() != 0) {
         new CommandeLigneAchats();

         for(int var96 = 0; var96 < this.listReceptionProduit.size(); ++var96) {
            CommandeLigneAchats var95 = (CommandeLigneAchats)this.listCommandeProduit.get(var96);
            var97 = this.utilNombre.myRoundDevise(var61 * (double)var95.getCmdligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            this.douanesPosition = this.douanesPositionDao.trouverPosition(this.structureLog.getStrzonecommerciale(), var95.getCmdligDouane(), var27);
            if (this.douanesPosition != null && !this.valorisationEnteteAchats.isValExoDouane()) {
               var99 = this.utilNombre.myRoundDevise(var97 * (double)this.douanesPosition.getDouposDd() / 100.0D, this.structureLog.getStrdevise());
               var101 = this.utilNombre.myRoundDevise(var97 * (double)this.douanesPosition.getDouposRs() / 100.0D, this.structureLog.getStrdevise());
               var103 = this.utilNombre.myRoundDevise(var97 * (double)this.douanesPosition.getDouposPcs() / 100.0D, this.structureLog.getStrdevise());
               var105 = this.utilNombre.myRoundDevise(var97 * (double)this.douanesPosition.getDouposAd() / 100.0D, this.structureLog.getStrdevise());
               var107 = this.utilNombre.myRoundDevise(var97 * (double)this.douanesPosition.getDouposDa() / 100.0D, this.structureLog.getStrdevise());
               var109 = this.utilNombre.myRoundDevise((var97 + var99 + var101) * (double)this.douanesPosition.getDoupos46() / 100.0D, this.structureLog.getStrdevise());
               var111 = this.utilNombre.myRoundDevise((var97 + var99 + var101) * (double)this.douanesPosition.getDoupos53() / 100.0D, this.structureLog.getStrdevise());
               double var113 = 0.0D;
               if (!this.valorisationEnteteAchats.isValExoTva()) {
                  var113 = this.utilNombre.myRoundDevise((var97 + var99 + var101) * (double)this.douanesPosition.getDouposTva() / 100.0D, this.structureLog.getStrdevise());
               }

               var65 = var65 + var99 + var101 + var103 + var105 + var107 + var109 + var111;
               var67 += var113;
            }
         }
      }

      double var162 = 0.0D;
      var97 = 0.0D;
      var99 = 0.0D;
      var101 = 0.0D;
      var103 = 0.0D;
      var105 = 0.0D;
      var107 = 0.0D;
      var109 = 0.0D;
      var111 = 0.0D;
      if (this.listCommandeProduit.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         new CommandeLigneAchats();
         if (this.valorisationEnteteAchats.getValFictif() == 0) {
            var162 = var47;
            if (var47 == 0.0D) {
               var162 = var79;
            }

            var97 = var61;
            var99 = var49;
            if (var49 == 0.0D) {
               var99 = var81;
            }

            var101 = var51;
            if (var51 == 0.0D) {
               var101 = var83;
            }

            var103 = var53;
            if (var53 == 0.0D) {
               var103 = var85;
            }

            var105 = var55;
            var107 = var57;
            if (var57 == 0.0D) {
               var107 = var89;
            }

            var109 = var59;
         } else if (this.valorisationEnteteAchats.getValFictif() == 1) {
            var162 = var63;
            var97 = var77;
            var99 = var65;
            var101 = var67;
            var103 = var69;
            var105 = var71;
            var107 = var73;
            var109 = var75;
         } else if (this.valorisationEnteteAchats.getValFictif() == 2) {
            if (var79 != 0.0D) {
               var111 += var79;
               var162 = var79;
            } else if (var47 != 0.0D) {
               var111 += var47;
               var162 = var47;
            } else {
               var111 += var63;
               var162 = var63;
            }

            if (var81 != 0.0D) {
               var111 += var81;
               var99 = var81;
            } else if (var49 != 0.0D) {
               var111 += var49;
               var99 = var49;
            } else {
               var111 += var65;
               var99 = var65;
            }

            if (var83 != 0.0D) {
               var101 = var83;
            } else if (var51 != 0.0D) {
               var101 = var51;
            } else {
               var101 = var67;
            }

            if (var85 != 0.0D) {
               var111 += var85;
               var103 = var85;
            } else if (var53 != 0.0D) {
               var111 += var53;
               var103 = var53;
            } else {
               var111 += var69;
               var103 = var69;
            }

            if (var55 != 0.0D) {
               var111 += var55;
               var105 = var55;
            } else {
               var111 += var71;
               var105 = var71;
            }

            if (var57 != 0.0D) {
               var111 += var57;
               var107 = var57;
            } else {
               var111 += var73;
               var107 = var73;
            }

            if (var59 != 0.0D) {
               var111 += var59;
               var109 = var59;
            } else {
               var111 += var75;
               var109 = var75;
            }

            var10000 = var111 + this.valorisationEnteteAchats.getValTotalFret();
         }

         for(int var114 = 0; var114 < this.listCommandeProduit.size(); ++var114) {
            CommandeLigneAchats var163 = (CommandeLigneAchats)this.listCommandeProduit.get(var114);
            float var115 = var163.getCmdligPoidsNet() / var1 * 100.0F;
            double var116 = 0.0D;
            if (var19) {
               var116 = this.utilNombre.myRoundDevise(var23 * (double)var163.getCmdligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            }

            double var118 = this.utilNombre.myRoundDevise((var158 + var21 + var116) * (double)var163.getCmdligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var120 = this.utilNombre.myRoundDevise(var16 * (double)var115 / 100.0D / (double)var163.getCmdligQte(), this.structureLog.getStrdevise());
            double var122 = this.utilNombre.myRoundDevise(var109 * (double)var163.getCmdligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var124 = this.utilNombre.myRoundDevise(var8 * (double)var163.getCmdligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var126 = 0.0D;
            if (var12 != 0.0D) {
               var126 = var163.getCmdligPtDev() + var12 * (var163.getCmdligPtDev() / (double)var1);
            } else {
               var126 = var163.getCmdligPtDev();
            }

            if (var20) {
               var126 += this.utilNombre.myRoundDevise(this.commandeEnteteAchats.getCmdTotFret2Local() * (double)var115 / 100.0D, this.structureLog.getStrdevise());
            }

            float var128 = (float)(var126 / var10 * 100.0D);
            double var129 = this.utilNombre.myRoundDevise(var162 * (double)var128 / 100.0D, this.structureLog.getStrdevise());
            double var131 = this.utilNombre.myRoundDevise(var103 * (double)var163.getCmdligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var133 = this.utilNombre.myRoundDevise((var105 + var107) * (double)var163.getCmdligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var135 = this.utilNombre.myRoundDevise(var97 * (double)var163.getCmdligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var137 = this.utilNombre.myRoundDevise(var101 * (double)var163.getCmdligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            this.douanesPosition = this.douanesPositionDao.trouverPosition(this.structureLog.getStrzonecommerciale(), var163.getCmdligDouane(), var27);
            if (this.douanesPosition != null && !this.valorisationEnteteAchats.isValExoDouane()) {
               float var139 = this.douanesPosition.getDouposDd() + this.douanesPosition.getDouposRs() + this.douanesPosition.getDouposPcs() + this.douanesPosition.getDouposAd() + this.douanesPosition.getDouposDa() + this.douanesPosition.getDoupos46() + this.douanesPosition.getDoupos53();
               double var140 = this.utilNombre.myRoundDevise(var135 * (double)(this.douanesPosition.getDouposDd() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setCmdligT1(var140);
               double var142 = this.utilNombre.myRoundDevise(var135 * (double)(this.douanesPosition.getDouposRs() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setCmdligT3(var142);
               double var144 = this.utilNombre.myRoundDevise(var135 * (double)(this.douanesPosition.getDouposPcs() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setCmdligT10(var144);
               double var146 = this.utilNombre.myRoundDevise(var135 * (double)(this.douanesPosition.getDouposAd() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setCmdligT30(var146);
               double var148 = this.utilNombre.myRoundDevise(var135 * (double)(this.douanesPosition.getDouposDa() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setCmdligT31(var148);
               double var150 = this.utilNombre.myRoundDevise((var135 + var140 + var142) * (double)(this.douanesPosition.getDoupos46() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setCmdligT46(var150);
               double var152 = this.utilNombre.myRoundDevise((var135 + var140 + var142) * (double)(this.douanesPosition.getDoupos53() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setCmdligT53(var152);
            } else if (this.douanesPosition == null && !this.valorisationEnteteAchats.isValExoDouane()) {
               var163.setCmdligT1(var135);
               var163.setCmdligT3(0.0D);
               var163.setCmdligT10(0.0D);
               var163.setCmdligT30(0.0D);
               var163.setCmdligT31(0.0D);
               var163.setCmdligT46(0.0D);
               var163.setCmdligT53(0.0D);
            } else {
               var163.setCmdligT1(0.0D);
               var163.setCmdligT3(0.0D);
               var163.setCmdligT10(0.0D);
               var163.setCmdligT30(0.0D);
               var163.setCmdligT31(0.0D);
               var163.setCmdligT46(0.0D);
               var163.setCmdligT53(0.0D);
            }

            double var165 = 0.0D;
            if (!this.valorisationEnteteAchats.isValExoTva()) {
               var165 = this.utilNombre.myRoundDevise(var137, this.structureLog.getStrdevise());
               var163.setCmdligT5(var165);
            } else {
               var163.setCmdligT5(0.0D);
            }

            var163.setCmdligFob(var126);
            var163.setCmdligFret(var118);
            var163.setCmdligAssurance(var129);
            var163.setCmdligFrais(var133);
            var163.setCmdligFinancier(var131);
            var163.setCmdligPrUTtc(var120);
            var163.setCmdligPr(var126 + var118 + var129 + var133 + var131 + var163.getCmdligT1() + var163.getCmdligT3() + var163.getCmdligT10() + var163.getCmdligT30() + var163.getCmdligT31() + var163.getCmdligT46() + var163.getCmdligT53());
            double var141;
            if (var163.getCmdligQteUtil() != 0.0F) {
               var141 = this.utilNombre.myRound(var163.getCmdligPr() / (double)var163.getCmdligQteUtil(), 2);
               var163.setCmdligPrU(var141);
               var163.setCmdligPump(0.0D);
            }

            if (var163.getCmdligPoidsNet() != 0.0F) {
               var141 = this.utilNombre.myRound(var163.getCmdligPr() / (double)var163.getCmdligPoidsNet(), 2);
               var163.setCmdligPrKg(var141);
            }
         }

         this.dataModelDetailValo.setWrappedData(this.listReceptionProduit);
         this.valorisationEnteteAchats.setValValeurDouane(var97);
         this.valorisationEnteteAchats.setValTotalFrais1(var162 + var99 + var103 + var105 + var107 + var109 + this.valorisationEnteteAchats.getValTotalFret());
         this.valorisationEnteteAchats.setValTotalDouaneTheo(var65);
         this.valorisationEnteteAchats.setValTotalTvaDouaneTheo(var67);
         this.valorisationEnteteAchats.setValTotalAssuranceTheo(var63);
         this.valorisationEnteteAchats.setValTotalFinancierTheo(var69);
         this.valorisationEnteteAchats.setValPr1(this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFrais1());
         if (this.valorisationEnteteAchats.getValPr1() != 0.0D && this.valorisationEnteteAchats.getValTotalFrais1() != 0.0D) {
            float var164 = 0.0F;
            if (this.optionAchats.getModCoefPr().equals("1")) {
               var164 = (float)(this.valorisationEnteteAchats.getValPr1() / this.valorisationEnteteAchats.getValTotalFob());
            } else {
               var164 = (float)(1.0D + this.valorisationEnteteAchats.getValTotalFrais1() / this.valorisationEnteteAchats.getValPr1());
            }

            this.valorisationEnteteAchats.setValCoef1(var164);
         } else {
            this.valorisationEnteteAchats.setValCoef1(0.0F);
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void calculValo1CmdValeur() throws HibernateException, NamingException {
      float var1 = 0.0F;
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      double var18 = 0.0D;
      boolean var20 = false;
      boolean var21 = false;
      boolean var22 = false;
      double var23 = 0.0D;
      double var25 = 0.0D;
      double var27 = 0.0D;
      Session var29 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
      this.listCommandeProduit = new ArrayList();
      ArrayList var30 = new ArrayList();
      ArrayList var31 = new ArrayList();
      FraisLigneAchatsDao var32 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      int var35;
      if (this.commandeListe.size() != 0 && this.valorisationEnteteAchats.getValNature1() == 12) {
         for(int var33 = 0; var33 < this.commandeListe.size(); ++var33) {
            var12 = var12 + ((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdTotHtLocal() + this.commandeEnteteAchats.getCmdTotCertificat() * (double)this.commandeEnteteAchats.getCmdCoefDevise() + this.commandeEnteteAchats.getCmdTotCertificatConformite() * (double)this.commandeEnteteAchats.getCmdCoefDevise() + this.commandeEnteteAchats.getCmdTotFraisAdm() * (double)this.commandeEnteteAchats.getCmdCoefDevise();
            var4 += ((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdTotFretLocal();
            if (((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdIncoterm() != null && !((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdIncoterm().isEmpty() && (((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdIncoterm().equals("CFR") || ((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdIncoterm().equals("CIF") || ((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdIncoterm().equals("CPT"))) {
               if (this.optionAchats.getModeCifCfrREC().equals("1")) {
                  var6 += ((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdTotFretLocal();
                  var8 += ((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdTotFret2Local();
                  var10 += ((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdTotAssuranceLocal();
               }

               var23 += ((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdTotFretLocal();
               var25 += ((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdTotFret2Local();
               var27 += ((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdTotAssuranceLocal();
               if (((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdIncoterm().equals("CFR")) {
                  var20 = true;
               } else if (((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdIncoterm().equals("CPT")) {
                  var21 = true;
               }
            } else if (this.receptionEnteteAchats.getRecIncoterm() != null && !this.receptionEnteteAchats.getRecIncoterm().isEmpty() && this.receptionEnteteAchats.getRecIncoterm().equals("EXW")) {
               var12 += ((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdTotFret2Local();
               var22 = true;
            }

            new ArrayList();
            List var34 = this.commandeLigneAchatsDao.chargerLesLignes((CommandeEnteteAchats)this.commandeListe.get(var33), var29);
            if (var34.size() != 0) {
               for(var35 = 0; var35 < var34.size(); ++var35) {
                  if (((CommandeLigneAchats)var34.get(var35)).getCmdligQte() != 0.0F) {
                     var1 += ((CommandeLigneAchats)var34.get(var35)).getCmdligPoidsNet();
                     var2 += ((CommandeLigneAchats)var34.get(var35)).getCmdligPtDev();
                     var18 = var18 + ((CommandeLigneAchats)var34.get(var35)).getCmdligPtDev() + ((CommandeLigneAchats)var34.get(var35)).getCmdligTva();
                     this.listCommandeProduit.add(var34.get(var35));
                  }
               }
            }

            new ArrayList();
            List var159 = this.noteDebitLigneAchatsDao.chargerLesLignesByDossier(((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdAnal4(), var29);
            if (var159.size() != 0) {
               for(int var36 = 0; var36 < var159.size(); ++var36) {
                  if (((NoteDebitLigneAchats)var159.get(var36)).getNdfligQte() != 0.0F) {
                     var2 += ((NoteDebitLigneAchats)var159.get(var36)).getNdfligPt();
                     var18 += ((NoteDebitLigneAchats)var159.get(var36)).getNdfligTtc();
                     var31.add(var159.get(var36));
                  }
               }
            }

            new ArrayList();
            List var161 = var32.chargerLesLignesByDossier(((CommandeEnteteAchats)this.commandeListe.get(var33)).getCmdAnal4(), var29);
            if (var161.size() != 0) {
               for(int var37 = 0; var37 < var161.size(); ++var37) {
                  if (((FraisLigneAchats)var161.get(var37)).getFraisEnteteAchats().getFsfNumDoc() != null && !((FraisLigneAchats)var161.get(var37)).getFraisEnteteAchats().getFsfNumDoc().isEmpty() && ((FraisLigneAchats)var161.get(var37)).getFraisEnteteAchats().getFsfNumDoc().contains(":")) {
                     String[] var38 = ((FraisLigneAchats)var161.get(var37)).getFraisEnteteAchats().getFsfNumDoc().split(":");
                     if (this.commandeEnteteAchats.getCmdNum().equals(var38[1])) {
                        var30.add(var161.get(var37));
                     }
                  }
               }
            }
         }

         new ArrayList();
         List var156 = var32.chargerLesLignesByDossier(this.commandeEnteteAchats.getCmdAnal4(), var29);
         if (var156.size() != 0) {
            for(int var158 = 0; var158 < var156.size(); ++var158) {
               if (((FraisLigneAchats)var156.get(var158)).getFraisEnteteAchats().getFsfNumDoc() == null || ((FraisLigneAchats)var156.get(var158)).getFraisEnteteAchats().getFsfNumDoc().isEmpty() || ((FraisLigneAchats)var156.get(var158)).getFraisEnteteAchats().getFsfNumDoc().equals("CMD") || ((FraisLigneAchats)var156.get(var158)).getFraisEnteteAchats().getFsfNumDoc().equals("")) {
                  var30.add(var156.get(var158));
               }
            }
         }
      }

      double var157;
      if (this.fraisList.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         var157 = 0.0D;

         for(var35 = 0; var35 < this.fraisList.size(); ++var35) {
            if (((FraisEnteteAchats)this.fraisList.get(var35)).getFsfTypeValo() == 1) {
               var157 += ((FraisEnteteAchats)this.fraisList.get(var35)).getFsfTotHt();
            }

            var18 += ((FraisEnteteAchats)this.fraisList.get(var35)).getFsfTotTtc();
         }
      }

      if (this.valorisationEnteteAchats.getValCoefDeviseDouane() == 0.0F) {
         this.valorisationEnteteAchats.setValCoefDeviseDouane(1.0F);
      }

      var157 = 0.0D;
      double var160 = var4;
      double var162 = 0.0D;
      double var39 = 0.0D;
      double var41 = 0.0D;
      double var43 = 0.0D;
      double var45 = 0.0D;
      int var47;
      if (var30.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         for(var47 = 0; var47 < var30.size(); ++var47) {
            if (((FraisLigneAchats)var30.get(var47)).getFsfligMode() == 0) {
               var157 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var30.get(var47)).getFsfligMode() == 1) {
               if (var20) {
                  var23 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
               } else if (var21) {
                  var25 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
               } else {
                  var160 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
               }
            } else if (((FraisLigneAchats)var30.get(var47)).getFsfligMode() == 2) {
               var27 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var30.get(var47)).getFsfligMode() == 3) {
               var162 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var30.get(var47)).getFsfligMode() == 4) {
               var39 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var30.get(var47)).getFsfligMode() == 5) {
               var41 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var30.get(var47)).getFsfligMode() == 6) {
               var45 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var30.get(var47)).getFsfligMode() != 7) {
               if (((FraisLigneAchats)var30.get(var47)).getFsfligMode() == 8) {
                  var43 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
               } else if (((FraisLigneAchats)var30.get(var47)).getFsfligMode() == 9) {
                  var12 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
                  var14 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
               } else {
                  var157 += ((FraisLigneAchats)var30.get(var47)).getFsfligPtLocal();
               }
            }
         }

         var14 = var14 + this.commandeEnteteAchats.getCmdTotCertificat() * (double)this.commandeEnteteAchats.getCmdCoefDevise() + this.commandeEnteteAchats.getCmdTotCertificatConformite() * (double)this.commandeEnteteAchats.getCmdCoefDevise() + this.commandeEnteteAchats.getCmdTotFraisAdm() * (double)this.commandeEnteteAchats.getCmdCoefDevise();
      }

      if (var31.size() != 0) {
         for(var47 = 0; var47 < var31.size(); ++var47) {
            var45 -= ((NoteDebitLigneAchats)var31.get(var47)).getNdfligPt();
         }
      }

      this.valorisationEnteteAchats.setValTotalCommande(var12);
      this.valorisationEnteteAchats.setValTotalFob(var12);
      this.valorisationEnteteAchats.setValTotalFret(var160);
      double var163;
      if (this.optionAchats.getModValoFret().equals("0") && (this.valorisationEnteteAchats.getValMode() == 1 || this.valorisationEnteteAchats.getValMode() == 2)) {
         var163 = this.utilNombre.myRoundDevise(this.valorisationEnteteAchats.getValTotalFret() / 2.0D, this.structureLog.getStrdevise());
         this.valorisationEnteteAchats.setValTotalFret(var163);
      }

      this.valorisationEnteteAchats.setValTotalAssuranceReelle(var27);
      this.valorisationEnteteAchats.setValTotalDouaneReelle(var162);
      var16 = (double)this.utilNombre.myRoundDevise(this.valorisationEnteteAchats.getValCoefForfaitTransport() * var1, this.structureLog.getStrdevise());
      this.valorisationEnteteAchats.setValForfaitTransport(var16);
      this.valorisationEnteteAchats.setValTotalTvaDouaneReelle(var39);
      if (this.valorisationEnteteAchats.getValFictif() == 0) {
         this.valorisationEnteteAchats.setValTotalTransit(var41);
         this.valorisationEnteteAchats.setValTotalDebours(var45 + var157);
      } else if (this.valorisationEnteteAchats.getValFictif() == 1) {
         this.valorisationEnteteAchats.setValTotalTransit(var41);
         this.valorisationEnteteAchats.setValTotalDebours(var45 + var157);
      } else if (this.valorisationEnteteAchats.getValFictif() == 2) {
         var41 = this.valorisationEnteteAchats.getValTotalTransit();
         var45 = this.valorisationEnteteAchats.getValTotalDebours();
      }

      this.valorisationEnteteAchats.setValPr1Ttc(var18);
      var163 = 0.0D;
      if (var21) {
         var163 = this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFret() + this.valorisationEnteteAchats.getValForfaitTransport();
      } else {
         var163 = this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFret();
      }

      double var49 = this.valorisationEnteteAchats.getValTotalAssuranceReelle();
      double var51 = this.valorisationEnteteAchats.getValTotalDouaneReelle();
      double var53 = this.valorisationEnteteAchats.getValTotalTvaDouaneReelle();
      double var55 = this.valorisationEnteteAchats.getValTotalFinancierReelle();
      double var57 = this.valorisationEnteteAchats.getValTotalTransit();
      double var59 = this.valorisationEnteteAchats.getValTotalDebours() + this.valorisationEnteteAchats.getValTotalFraisProv();
      double var61 = this.valorisationEnteteAchats.getValForfaitTransport();
      double var63 = var163 + var49;
      double var65 = this.calculAssuranceTheorique(this.valorisationEnteteAchats.getValTotalFob(), this.valorisationEnteteAchats.getValTotalFret(), var29);
      double var67 = 0.0D;
      double var69 = 0.0D;
      double var71 = this.calculFinancierTheorique(this.valorisationEnteteAchats.getValTotalFob(), this.valorisationEnteteAchats.getValTotalFret(), var29);
      double var73 = 0.0D;
      double var75 = 0.0D;
      double var77 = 0.0D;
      double var79 = var163 + var65;
      double var81 = this.valorisationEnteteAchats.getValTotalAssuranceProv();
      double var83 = this.valorisationEnteteAchats.getValTotalDouaneProv();
      double var85 = this.valorisationEnteteAchats.getValTotalTvaDouaneProv();
      double var87 = this.valorisationEnteteAchats.getValTotalFinancierProv();
      double var89 = 0.0D;
      double var91 = 0.0D;
      double var93 = 0.0D;
      double var10000 = var163 + var81;
      double var99;
      double var101;
      double var103;
      double var105;
      double var107;
      double var109;
      double var111;
      double var113;
      if (this.listCommandeProduit.size() != 0) {
         new CommandeLigneAchats();

         for(int var98 = 0; var98 < this.listReceptionProduit.size(); ++var98) {
            CommandeLigneAchats var97 = (CommandeLigneAchats)this.listCommandeProduit.get(var98);
            var99 = this.utilNombre.myRoundDevise(var63 * var97.getCmdligPtDev() / var2, this.structureLog.getStrdevise());
            this.douanesPosition = this.douanesPositionDao.trouverPosition(this.structureLog.getStrzonecommerciale(), var97.getCmdligDouane(), var29);
            if (this.douanesPosition != null && !this.valorisationEnteteAchats.isValExoDouane()) {
               var101 = this.utilNombre.myRoundDevise(var99 * (double)this.douanesPosition.getDouposDd() / 100.0D, this.structureLog.getStrdevise());
               var103 = this.utilNombre.myRoundDevise(var99 * (double)this.douanesPosition.getDouposRs() / 100.0D, this.structureLog.getStrdevise());
               var105 = this.utilNombre.myRoundDevise(var99 * (double)this.douanesPosition.getDouposPcs() / 100.0D, this.structureLog.getStrdevise());
               var107 = this.utilNombre.myRoundDevise(var99 * (double)this.douanesPosition.getDouposAd() / 100.0D, this.structureLog.getStrdevise());
               var109 = this.utilNombre.myRoundDevise(var99 * (double)this.douanesPosition.getDouposDa() / 100.0D, this.structureLog.getStrdevise());
               var111 = this.utilNombre.myRoundDevise((var99 + var101 + var103) * (double)this.douanesPosition.getDoupos46() / 100.0D, this.structureLog.getStrdevise());
               var113 = this.utilNombre.myRoundDevise((var99 + var101 + var103) * (double)this.douanesPosition.getDoupos53() / 100.0D, this.structureLog.getStrdevise());
               double var115 = 0.0D;
               if (!this.valorisationEnteteAchats.isValExoTva()) {
                  var115 = this.utilNombre.myRoundDevise((var99 + var101 + var103 + var113) * (double)this.douanesPosition.getDouposTva() / 100.0D, this.structureLog.getStrdevise());
               }

               var67 = var67 + var101 + var103 + var105 + var107 + var109 + var111 + var113;
               var69 += var115;
            }
         }
      }

      double var164 = 0.0D;
      var99 = 0.0D;
      var101 = 0.0D;
      var103 = 0.0D;
      var105 = 0.0D;
      var107 = 0.0D;
      var109 = 0.0D;
      var111 = 0.0D;
      var113 = 0.0D;
      if (this.listCommandeProduit.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         new CommandeLigneAchats();
         if (this.valorisationEnteteAchats.getValFictif() == 0) {
            var164 = var49;
            if (var49 == 0.0D) {
               var164 = var81;
            }

            var99 = var63;
            var101 = var51;
            if (var51 == 0.0D) {
               var101 = var83;
            }

            var103 = var53;
            if (var53 == 0.0D) {
               var103 = var85;
            }

            var105 = var55;
            if (var55 == 0.0D) {
               var105 = var87;
            }

            var107 = var57;
            var109 = var59;
            if (var59 == 0.0D) {
               var109 = var91;
            }

            var111 = var61;
         } else if (this.valorisationEnteteAchats.getValFictif() == 1) {
            var164 = var65;
            var99 = var79;
            var101 = var67;
            var103 = var69;
            var105 = var71;
            var107 = var73;
            var109 = var75;
            var111 = var77;
         } else if (this.valorisationEnteteAchats.getValFictif() == 2) {
            if (var81 != 0.0D) {
               var113 += var81;
               var164 = var81;
            } else if (var49 != 0.0D) {
               var113 += var49;
               var164 = var49;
            } else {
               var113 += var65;
               var164 = var65;
            }

            if (var83 != 0.0D) {
               var113 += var83;
               var101 = var83;
            } else if (var51 != 0.0D) {
               var113 += var51;
               var101 = var51;
            } else {
               var113 += var67;
               var101 = var67;
            }

            if (var85 != 0.0D) {
               var103 = var85;
            } else if (var53 != 0.0D) {
               var103 = var53;
            } else {
               var103 = var69;
            }

            if (var87 != 0.0D) {
               var113 += var87;
               var105 = var87;
            } else if (var55 != 0.0D) {
               var113 += var55;
               var105 = var55;
            } else {
               var113 += var71;
               var105 = var71;
            }

            if (var57 != 0.0D) {
               var113 += var57;
               var107 = var57;
            } else {
               var113 += var73;
               var107 = var73;
            }

            if (var59 != 0.0D) {
               var113 += var59;
               var109 = var59;
            } else {
               var113 += var75;
               var109 = var75;
            }

            if (var61 != 0.0D) {
               var113 += var61;
               var111 = var61;
            } else {
               var113 += var77;
               var111 = var77;
            }

            var10000 = var113 + this.valorisationEnteteAchats.getValTotalFret();
         }

         for(int var116 = 0; var116 < this.listCommandeProduit.size(); ++var116) {
            CommandeLigneAchats var165 = (CommandeLigneAchats)this.listCommandeProduit.get(var116);
            float var117 = (float)(var165.getCmdligPtDev() / var2 * 100.0D);
            double var118 = 0.0D;
            if (var21) {
               var118 = this.utilNombre.myRoundDevise(var25 * var165.getCmdligPtDev() / var2, this.structureLog.getStrdevise());
            }

            double var120 = this.utilNombre.myRoundDevise((var160 + var23 + var118) * var165.getCmdligPtDev() / var2, this.structureLog.getStrdevise());
            double var122 = this.utilNombre.myRoundDevise(var18 * (double)var117 / 100.0D / (double)var165.getCmdligQte(), this.structureLog.getStrdevise());
            double var124 = this.utilNombre.myRoundDevise(var111 * var165.getCmdligPtDev() / var2, this.structureLog.getStrdevise());
            double var126 = this.utilNombre.myRoundDevise(var10 * var165.getCmdligPtDev() / var2, this.structureLog.getStrdevise());
            double var128 = 0.0D;
            if (var14 != 0.0D) {
               var128 = var165.getCmdligPtDev() + var14 * (var165.getCmdligPtDev() / var2);
            } else {
               var128 = var165.getCmdligPtDev();
            }

            if (var22) {
               var128 += this.utilNombre.myRoundDevise(this.commandeEnteteAchats.getCmdTotFret2Local() * (double)var117 / 100.0D, this.structureLog.getStrdevise());
            }

            float var130 = (float)(var128 / var12 * 100.0D);
            double var131 = this.utilNombre.myRoundDevise(var164 * (double)var130 / 100.0D, this.structureLog.getStrdevise());
            double var133 = this.utilNombre.myRoundDevise(var105 * var165.getCmdligPtDev() / var2, this.structureLog.getStrdevise());
            double var135 = this.utilNombre.myRoundDevise((var107 + var109) * var165.getCmdligPtDev() / var2, this.structureLog.getStrdevise());
            double var137 = this.utilNombre.myRoundDevise(var101 * var165.getCmdligPtDev() / var2, this.structureLog.getStrdevise());
            double var139 = this.utilNombre.myRoundDevise(var103 * var165.getCmdligPtDev() / var2, this.structureLog.getStrdevise());
            this.douanesPosition = this.douanesPositionDao.trouverPosition(this.structureLog.getStrzonecommerciale(), var165.getCmdligDouane(), var29);
            if (this.douanesPosition != null && !this.valorisationEnteteAchats.isValExoDouane()) {
               float var141 = this.douanesPosition.getDouposDd() + this.douanesPosition.getDouposRs() + this.douanesPosition.getDouposPcs() + this.douanesPosition.getDouposAd() + this.douanesPosition.getDouposDa() + this.douanesPosition.getDoupos46() + this.douanesPosition.getDoupos53();
               double var142 = this.utilNombre.myRoundDevise(var137 * (double)(this.douanesPosition.getDouposDd() / var141 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var165.setCmdligT1(var142);
               double var144 = this.utilNombre.myRoundDevise(var137 * (double)(this.douanesPosition.getDouposRs() / var141 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var165.setCmdligT3(var144);
               double var146 = this.utilNombre.myRoundDevise(var137 * (double)(this.douanesPosition.getDouposPcs() / var141 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var165.setCmdligT10(var146);
               double var148 = this.utilNombre.myRoundDevise(var137 * (double)(this.douanesPosition.getDouposAd() / var141 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var165.setCmdligT30(var148);
               double var150 = this.utilNombre.myRoundDevise(var137 * (double)(this.douanesPosition.getDouposDa() / var141 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var165.setCmdligT31(var150);
               double var152 = this.utilNombre.myRoundDevise((var137 + var142 + var144) * (double)(this.douanesPosition.getDoupos46() / var141 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var165.setCmdligT46(var152);
               double var154 = this.utilNombre.myRoundDevise((var137 + var142 + var144) * (double)(this.douanesPosition.getDoupos53() / var141 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var165.setCmdligT53(var154);
            } else if (this.douanesPosition == null && !this.valorisationEnteteAchats.isValExoDouane()) {
               var165.setCmdligT1(var137);
               var165.setCmdligT3(0.0D);
               var165.setCmdligT10(0.0D);
               var165.setCmdligT30(0.0D);
               var165.setCmdligT31(0.0D);
               var165.setCmdligT46(0.0D);
               var165.setCmdligT53(0.0D);
            } else {
               var165.setCmdligT1(0.0D);
               var165.setCmdligT3(0.0D);
               var165.setCmdligT10(0.0D);
               var165.setCmdligT30(0.0D);
               var165.setCmdligT31(0.0D);
               var165.setCmdligT46(0.0D);
               var165.setCmdligT53(0.0D);
            }

            double var167 = 0.0D;
            if (!this.valorisationEnteteAchats.isValExoTva()) {
               var167 = this.utilNombre.myRoundDevise(var139, this.structureLog.getStrdevise());
               var165.setCmdligT5(var167);
            } else {
               var165.setCmdligT5(0.0D);
            }

            var165.setCmdligFob(var128);
            var165.setCmdligFret(var120);
            var165.setCmdligAssurance(var131);
            var165.setCmdligFrais(var135);
            var165.setCmdligFinancier(var133);
            var165.setCmdligPrUTtc(var122);
            var165.setCmdligPr(var128 + var120 + var131 + var135 + var133 + var165.getCmdligT1() + var165.getCmdligT3() + var165.getCmdligT10() + var165.getCmdligT30() + var165.getCmdligT31() + var165.getCmdligT46() + var165.getCmdligT53());
            double var143;
            if (var165.getCmdligQteUtil() != 0.0F) {
               var143 = this.utilNombre.myRound(var165.getCmdligPr() / (double)var165.getCmdligQteUtil(), 2);
               var165.setCmdligPrU(var143);
               var165.setCmdligPump(0.0D);
            }

            if (var165.getCmdligPoidsNet() != 0.0F) {
               var143 = this.utilNombre.myRound(var165.getCmdligPr() / (double)var165.getCmdligPoidsNet(), 2);
               var165.setCmdligPrKg(var143);
            }
         }

         this.dataModelDetailValo.setWrappedData(this.listReceptionProduit);
         this.valorisationEnteteAchats.setValValeurDouane(var99);
         this.valorisationEnteteAchats.setValTotalFrais1(var164 + var101 + var105 + var107 + var109 + var111 + this.valorisationEnteteAchats.getValTotalFret());
         this.valorisationEnteteAchats.setValTotalDouaneTheo(var67);
         this.valorisationEnteteAchats.setValTotalTvaDouaneTheo(var69);
         this.valorisationEnteteAchats.setValTotalAssuranceTheo(var65);
         this.valorisationEnteteAchats.setValTotalFinancierTheo(var71);
         this.valorisationEnteteAchats.setValPr1(this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFrais1());
         if (this.valorisationEnteteAchats.getValPr1() != 0.0D && this.valorisationEnteteAchats.getValTotalFrais1() != 0.0D) {
            float var166 = 0.0F;
            if (this.optionAchats.getModCoefPr().equals("1")) {
               var166 = (float)(this.valorisationEnteteAchats.getValPr1() / this.valorisationEnteteAchats.getValTotalFob());
            } else {
               var166 = (float)(1.0D + this.valorisationEnteteAchats.getValTotalFrais1() / this.valorisationEnteteAchats.getValPr1());
            }

            this.valorisationEnteteAchats.setValCoef1(var166);
         } else {
            this.valorisationEnteteAchats.setValCoef1(0.0F);
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void calculValo1RecPoids() throws HibernateException, NamingException {
      float var1 = 0.0F;
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      boolean var16 = false;
      boolean var17 = false;
      boolean var18 = false;
      double var19 = 0.0D;
      double var21 = 0.0D;
      double var23 = 0.0D;
      Session var25 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
      this.listReceptionProduit = new ArrayList();
      ArrayList var26 = new ArrayList();
      ArrayList var27 = new ArrayList();
      FraisLigneAchatsDao var28 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      int var31;
      if (this.receptionListe.size() != 0 && this.valorisationEnteteAchats.getValNature1() == 13) {
         this.receptionEnteteAchats = new ReceptionEnteteAchats();

         for(int var29 = 0; var29 < this.receptionListe.size(); ++var29) {
            this.receptionEnteteAchats = (ReceptionEnteteAchats)this.receptionListe.get(var29);
            if (!this.receptionEnteteAchats.isRecExcluValo()) {
               var8 = var8 + this.receptionEnteteAchats.getRecTotHtLocal() + this.receptionEnteteAchats.getRecTotCertificatLocal() + this.receptionEnteteAchats.getRecTotCertificatConformiteLocal() + this.receptionEnteteAchats.getRecTotFraisAdmLocal();
               if (this.receptionEnteteAchats.getRecIncoterm() == null || this.receptionEnteteAchats.getRecIncoterm().isEmpty() || !this.receptionEnteteAchats.getRecIncoterm().equals("CFR") && !this.receptionEnteteAchats.getRecIncoterm().equals("CIF") && !this.receptionEnteteAchats.getRecIncoterm().equals("CPT")) {
                  if (this.receptionEnteteAchats.getRecIncoterm() != null && !this.receptionEnteteAchats.getRecIncoterm().isEmpty() && this.receptionEnteteAchats.getRecIncoterm().equals("EXW")) {
                     var8 += this.receptionEnteteAchats.getRecTotFret2Local();
                     var18 = true;
                  }
               } else {
                  if (this.optionAchats.getModeCifCfrREC().equals("1")) {
                     var2 += this.receptionEnteteAchats.getRecTotFretLocal();
                     var4 += this.receptionEnteteAchats.getRecTotFret2Local();
                     var6 += this.receptionEnteteAchats.getRecTotAssuranceLocal();
                  }

                  var19 += this.receptionEnteteAchats.getRecTotFretLocal();
                  var21 += this.receptionEnteteAchats.getRecTotFret2Local();
                  var23 += this.receptionEnteteAchats.getRecTotAssuranceLocal();
                  if (this.receptionEnteteAchats.getRecIncoterm().equals("CFR")) {
                     var16 = true;
                  } else if (this.receptionEnteteAchats.getRecIncoterm().equals("CPT")) {
                     var17 = true;
                  }
               }

               new ArrayList();
               List var30 = this.receptionLigneAchatsDao.chargerLesLignes(this.receptionEnteteAchats, var25);
               if (var30.size() != 0) {
                  for(var31 = 0; var31 < var30.size(); ++var31) {
                     if (((ReceptionLigneAchats)var30.get(var31)).getRecligQte() != 0.0F) {
                        var1 += ((ReceptionLigneAchats)var30.get(var31)).getRecligPoidsNet();
                        var14 += ((ReceptionLigneAchats)var30.get(var31)).getRecligTva();
                        this.listReceptionProduit.add(var30.get(var31));
                     }
                  }
               }

               new ArrayList();
               List var155 = this.noteDebitLigneAchatsDao.chargerLesLignesByDossier(((ReceptionEnteteAchats)this.receptionListe.get(var29)).getRecAnal4(), var25);
               if (var155.size() != 0) {
                  for(int var32 = 0; var32 < var155.size(); ++var32) {
                     if (((NoteDebitLigneAchats)var155.get(var32)).getNdfligQte() != 0.0F) {
                        var14 += ((NoteDebitLigneAchats)var155.get(var32)).getNdfligTva();
                        var27.add(var155.get(var32));
                     }
                  }
               }

               new ArrayList();
               List var157 = var28.chargerLesLignesByDossier(this.receptionEnteteAchats.getRecAnal4(), var25);
               if (var157.size() != 0) {
                  for(int var33 = 0; var33 < var157.size(); ++var33) {
                     if (((FraisLigneAchats)var157.get(var33)).getFraisEnteteAchats().getFsfNumDoc() != null && !((FraisLigneAchats)var157.get(var33)).getFraisEnteteAchats().getFsfNumDoc().isEmpty() && ((FraisLigneAchats)var157.get(var33)).getFraisEnteteAchats().getFsfNumDoc().contains(":")) {
                        String[] var34 = ((FraisLigneAchats)var157.get(var33)).getFraisEnteteAchats().getFsfNumDoc().split(":");
                        if (this.receptionEnteteAchats.getRecNum().equals(var34[1])) {
                           var26.add(var157.get(var33));
                        }
                     }
                  }
               }
            }
         }

         new ArrayList();
         List var152 = var28.chargerLesLignesByDossier(this.receptionEnteteAchats.getRecAnal4(), var25);
         if (var152.size() != 0) {
            for(int var154 = 0; var154 < var152.size(); ++var154) {
               if (((FraisLigneAchats)var152.get(var154)).getFraisEnteteAchats().getFsfNumDoc() == null || ((FraisLigneAchats)var152.get(var154)).getFraisEnteteAchats().getFsfNumDoc().isEmpty() || ((FraisLigneAchats)var152.get(var154)).getFraisEnteteAchats().getFsfNumDoc().equals("REC") || ((FraisLigneAchats)var152.get(var154)).getFraisEnteteAchats().getFsfNumDoc().equals("")) {
                  var26.add(var152.get(var154));
               }
            }
         }
      }

      double var153;
      if (this.fraisList.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         var153 = 0.0D;

         for(var31 = 0; var31 < this.fraisList.size(); ++var31) {
            if (((FraisEnteteAchats)this.fraisList.get(var31)).getFsfTypeValo() == 1) {
               var153 += ((FraisEnteteAchats)this.fraisList.get(var31)).getFsfTotHt();
            }

            var14 += ((FraisEnteteAchats)this.fraisList.get(var31)).getFsfTotTva();
         }
      }

      if (this.valorisationEnteteAchats.getValCoefDeviseDouane() == 0.0F) {
         this.valorisationEnteteAchats.setValCoefDeviseDouane(1.0F);
      }

      var153 = 0.0D;
      double var156 = 0.0D;
      double var158 = 0.0D;
      double var35 = 0.0D;
      double var37 = 0.0D;
      double var39 = 0.0D;
      double var41 = 0.0D;
      int var43;
      if (var26.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         for(var43 = 0; var43 < var26.size(); ++var43) {
            var14 += ((FraisLigneAchats)var26.get(var43)).getFsfligTva();
            if (((FraisLigneAchats)var26.get(var43)).getFsfligMode() == 0) {
               var153 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var26.get(var43)).getFsfligMode() == 1) {
               if (var16) {
                  var19 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
               } else if (var17) {
                  var21 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
               } else {
                  var156 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
               }
            } else if (((FraisLigneAchats)var26.get(var43)).getFsfligMode() == 2) {
               var23 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var26.get(var43)).getFsfligMode() == 3) {
               var158 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var26.get(var43)).getFsfligMode() == 4) {
               var35 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var26.get(var43)).getFsfligMode() == 5) {
               var39 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var26.get(var43)).getFsfligMode() == 6) {
               var41 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var26.get(var43)).getFsfligMode() != 7) {
               if (((FraisLigneAchats)var26.get(var43)).getFsfligMode() == 8) {
                  var37 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
               } else if (((FraisLigneAchats)var26.get(var43)).getFsfligMode() == 9) {
                  var8 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
                  var10 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
               } else {
                  var153 += ((FraisLigneAchats)var26.get(var43)).getFsfligPtLocal();
               }
            }
         }

         var10 = var10 + this.receptionEnteteAchats.getRecTotCertificatLocal() + this.receptionEnteteAchats.getRecTotCertificatConformiteLocal() + this.receptionEnteteAchats.getRecTotFraisAdmLocal();
      }

      if (var27.size() != 0) {
         for(var43 = 0; var43 < var27.size(); ++var43) {
            var41 -= ((NoteDebitLigneAchats)var27.get(var43)).getNdfligPt();
         }
      }

      this.valorisationEnteteAchats.setValTotalReception(var8);
      if (this.receptionEnteteAchats.getRecIncoterm() == null || this.receptionEnteteAchats.getRecIncoterm().isEmpty() || !this.receptionEnteteAchats.getRecIncoterm().equals("CFR") && !this.receptionEnteteAchats.getRecIncoterm().equals("CIF") && !this.receptionEnteteAchats.getRecIncoterm().equals("CPT")) {
         this.valorisationEnteteAchats.setValTotalFob(var8);
      } else {
         this.valorisationEnteteAchats.setValTotalFob(var8 - var2 - var6);
      }

      this.valorisationEnteteAchats.setValTotalFret(var156 + var19);
      double var159;
      if (this.optionAchats.getModValoFret().equals("0") && (this.valorisationEnteteAchats.getValMode() == 1 || this.valorisationEnteteAchats.getValMode() == 2)) {
         var159 = this.utilNombre.myRoundDevise(this.valorisationEnteteAchats.getValTotalFret() / 2.0D, this.structureLog.getStrdevise());
         this.valorisationEnteteAchats.setValTotalFret(var159);
      }

      this.valorisationEnteteAchats.setValTotalAssuranceReelle(var23);
      this.valorisationEnteteAchats.setValTotalFinancierReelle(var37);
      this.valorisationEnteteAchats.setValTotalDouaneReelle(var158);
      var12 = (double)this.utilNombre.myRoundDevise(this.valorisationEnteteAchats.getValCoefForfaitTransport() * var1, this.structureLog.getStrdevise());
      this.valorisationEnteteAchats.setValForfaitTransport(var12);
      this.valorisationEnteteAchats.setValTotalTvaDouaneReelle(var35);
      if (this.valorisationEnteteAchats.getValFictif() == 0) {
         this.valorisationEnteteAchats.setValTotalTransit(var39);
         this.valorisationEnteteAchats.setValTotalDebours(var41 + var153);
      } else if (this.valorisationEnteteAchats.getValFictif() == 1) {
         this.valorisationEnteteAchats.setValTotalTransit(var39);
         this.valorisationEnteteAchats.setValTotalDebours(var41 + var153);
      } else if (this.valorisationEnteteAchats.getValFictif() == 2) {
         var39 = this.valorisationEnteteAchats.getValTotalTransit();
         var41 = this.valorisationEnteteAchats.getValTotalDebours();
      }

      this.valorisationEnteteAchats.setValPr1Ttc(this.valorisationEnteteAchats.getValPr1() + var14);
      var159 = 0.0D;
      if (var17) {
         var159 = this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFret() + this.valorisationEnteteAchats.getValForfaitTransport();
      } else {
         var159 = this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFret();
      }

      double var45 = this.valorisationEnteteAchats.getValTotalAssuranceReelle();
      double var47 = this.valorisationEnteteAchats.getValTotalDouaneReelle();
      double var49 = this.valorisationEnteteAchats.getValTotalTvaDouaneReelle();
      double var51 = this.valorisationEnteteAchats.getValTotalFinancierReelle();
      double var53 = this.valorisationEnteteAchats.getValTotalTransit();
      double var55 = this.valorisationEnteteAchats.getValTotalDebours() + this.valorisationEnteteAchats.getValTotalFraisProv();
      double var57 = this.valorisationEnteteAchats.getValForfaitTransport();
      double var59 = var159 + var45;
      double var61 = this.calculAssuranceTheorique(this.valorisationEnteteAchats.getValTotalFob(), this.valorisationEnteteAchats.getValTotalFret(), var25);
      double var63 = 0.0D;
      double var65 = 0.0D;
      double var67 = this.calculFinancierTheorique(this.valorisationEnteteAchats.getValTotalFob(), this.valorisationEnteteAchats.getValTotalFret(), var25);
      double var69 = 0.0D;
      double var71 = 0.0D;
      double var73 = 0.0D;
      double var75 = var159 + var61;
      double var77 = this.valorisationEnteteAchats.getValTotalAssuranceProv();
      double var79 = this.valorisationEnteteAchats.getValTotalDouaneProv();
      double var81 = this.valorisationEnteteAchats.getValTotalTvaDouaneProv();
      double var83 = this.valorisationEnteteAchats.getValTotalFinancierProv();
      double var85 = 0.0D;
      double var87 = 0.0D;
      double var89 = 0.0D;
      double var10000 = var159 + var77;
      double var95;
      double var97;
      double var99;
      double var101;
      double var103;
      double var105;
      double var107;
      double var109;
      if (this.listReceptionProduit.size() != 0) {
         new ReceptionLigneAchats();

         for(int var94 = 0; var94 < this.listReceptionProduit.size(); ++var94) {
            ReceptionLigneAchats var93 = (ReceptionLigneAchats)this.listReceptionProduit.get(var94);
            var95 = this.utilNombre.myRoundDevise(var59 * (double)var93.getRecligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            this.douanesPosition = this.douanesPositionDao.trouverPosition(this.structureLog.getStrzonecommerciale(), var93.getRecligDouane(), var25);
            if (this.douanesPosition != null && !this.valorisationEnteteAchats.isValExoDouane()) {
               var97 = this.utilNombre.myRoundDevise(var95 * (double)this.douanesPosition.getDouposDd() / 100.0D, this.structureLog.getStrdevise());
               var99 = this.utilNombre.myRoundDevise(var95 * (double)this.douanesPosition.getDouposRs() / 100.0D, this.structureLog.getStrdevise());
               var101 = this.utilNombre.myRoundDevise(var95 * (double)this.douanesPosition.getDouposPcs() / 100.0D, this.structureLog.getStrdevise());
               var103 = this.utilNombre.myRoundDevise(var95 * (double)this.douanesPosition.getDouposAd() / 100.0D, this.structureLog.getStrdevise());
               var105 = this.utilNombre.myRoundDevise(var95 * (double)this.douanesPosition.getDouposDa() / 100.0D, this.structureLog.getStrdevise());
               var107 = this.utilNombre.myRoundDevise((var95 + var97 + var99) * (double)this.douanesPosition.getDoupos46() / 100.0D, this.structureLog.getStrdevise());
               var109 = this.utilNombre.myRoundDevise((var95 + var97 + var99) * (double)this.douanesPosition.getDoupos53() / 100.0D, this.structureLog.getStrdevise());
               double var111 = 0.0D;
               if (!this.valorisationEnteteAchats.isValExoTva()) {
                  var111 = this.utilNombre.myRoundDevise((var95 + var97 + var99 + var109) * (double)this.douanesPosition.getDouposTva() / 100.0D, this.structureLog.getStrdevise());
               }

               var63 = var63 + var97 + var99 + var101 + var103 + var105 + var107 + var109;
               var65 += var111;
            }
         }
      }

      double var160 = 0.0D;
      var95 = 0.0D;
      var97 = 0.0D;
      var99 = 0.0D;
      var101 = 0.0D;
      var103 = 0.0D;
      var105 = 0.0D;
      var107 = 0.0D;
      var109 = 0.0D;
      if (this.listReceptionProduit.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         new ReceptionLigneAchats();
         if (this.valorisationEnteteAchats.getValFictif() == 0) {
            var160 = var45;
            if (var45 == 0.0D) {
               var160 = var77;
            }

            var95 = var59;
            var97 = var47;
            if (var47 == 0.0D) {
               var97 = var79;
            }

            var99 = var49;
            if (var49 == 0.0D) {
               var99 = var81;
            }

            var101 = var51;
            if (var51 == 0.0D) {
               var101 = var83;
            }

            var103 = var53;
            var105 = var55;
            if (var55 == 0.0D) {
               var105 = var87;
            }

            var107 = var57;
         } else if (this.valorisationEnteteAchats.getValFictif() == 1) {
            var160 = var61;
            var95 = var75;
            var97 = var63;
            var99 = var65;
            var101 = var67;
            var103 = var69;
            var105 = var71;
            var107 = var73;
         } else if (this.valorisationEnteteAchats.getValFictif() == 2) {
            if (var77 != 0.0D) {
               var109 += var77;
               var160 = var77;
            } else if (var45 != 0.0D) {
               var109 += var45;
               var160 = var45;
            } else {
               var109 += var61;
               var160 = var61;
            }

            if (var79 != 0.0D) {
               var109 += var79;
               var97 = var79;
            } else if (var47 != 0.0D) {
               var109 += var47;
               var97 = var47;
            } else {
               var109 += var63;
               var97 = var63;
            }

            if (var81 != 0.0D) {
               var99 = var81;
            } else if (var49 != 0.0D) {
               var99 = var49;
            } else {
               var99 = var65;
            }

            if (var83 != 0.0D) {
               var109 += var83;
               var101 = var83;
            } else if (var51 != 0.0D) {
               var109 += var51;
               var101 = var51;
            } else {
               var109 += var67;
               var101 = var67;
            }

            if (var53 != 0.0D) {
               var109 += var53;
               var103 = var53;
            } else {
               var109 += var69;
               var103 = var69;
            }

            if (var55 != 0.0D) {
               var109 += var55;
               var105 = var55;
            } else {
               var109 += var71;
               var105 = var71;
            }

            if (var57 != 0.0D) {
               var109 += var57;
               var107 = var57;
            } else {
               var109 += var73;
               var107 = var73;
            }

            var10000 = var109 + this.valorisationEnteteAchats.getValTotalFret();
         }

         for(int var112 = 0; var112 < this.listReceptionProduit.size(); ++var112) {
            ReceptionLigneAchats var161 = (ReceptionLigneAchats)this.listReceptionProduit.get(var112);
            float var113 = var161.getRecligPoidsNet() / var1 * 100.0F;
            double var114 = 0.0D;
            if (var17) {
               var114 = this.utilNombre.myRoundDevise(var21 * (double)var161.getRecligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            }

            double var116 = this.utilNombre.myRoundDevise((var156 + var19 + var114) * (double)var161.getRecligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var118 = this.utilNombre.myRoundDevise(var14 * (double)var113 / 100.0D / (double)var161.getRecligQte(), this.structureLog.getStrdevise());
            double var120 = this.utilNombre.myRoundDevise(var107 * (double)var161.getRecligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var122 = this.utilNombre.myRoundDevise(var6 * (double)var161.getRecligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var124 = 0.0D;
            if (var10 != 0.0D) {
               var124 = var161.getRecligPtDev() + var10 * (var161.getRecligPtDev() / (double)var1);
            } else {
               var124 = var161.getRecligPtDev();
            }

            if (var18) {
               var124 += this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotFret2Local() * (double)var113 / 100.0D, this.structureLog.getStrdevise());
            }

            float var126 = (float)(var124 / var8 * 100.0D);
            double var127 = this.utilNombre.myRoundDevise(var160 * (double)var126 / 100.0D, this.structureLog.getStrdevise());
            double var129 = this.utilNombre.myRoundDevise(var101 * (double)var161.getRecligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var131 = this.utilNombre.myRoundDevise((var103 + var105) * (double)var161.getRecligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var133 = this.utilNombre.myRoundDevise(var97 * (double)var161.getRecligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            double var135 = this.utilNombre.myRoundDevise(var99 * (double)var161.getRecligPoidsNet() / (double)var1, this.structureLog.getStrdevise());
            this.douanesPosition = this.douanesPositionDao.trouverPosition(this.structureLog.getStrzonecommerciale(), var161.getRecligDouane(), var25);
            if (this.douanesPosition != null && !this.valorisationEnteteAchats.isValExoDouane()) {
               float var137 = this.douanesPosition.getDouposDd() + this.douanesPosition.getDouposRs() + this.douanesPosition.getDouposPcs() + this.douanesPosition.getDouposAd() + this.douanesPosition.getDouposDa() + this.douanesPosition.getDoupos46() + this.douanesPosition.getDoupos53();
               double var138 = this.utilNombre.myRoundDevise(var133 * (double)(this.douanesPosition.getDouposDd() / var137 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var161.setRecligT1(var138);
               double var140 = this.utilNombre.myRoundDevise(var133 * (double)(this.douanesPosition.getDouposRs() / var137 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var161.setRecligT3(var140);
               double var142 = this.utilNombre.myRoundDevise(var133 * (double)(this.douanesPosition.getDouposPcs() / var137 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var161.setRecligT10(var142);
               double var144 = this.utilNombre.myRoundDevise(var133 * (double)(this.douanesPosition.getDouposAd() / var137 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var161.setRecligT30(var144);
               double var146 = this.utilNombre.myRoundDevise(var133 * (double)(this.douanesPosition.getDouposDa() / var137 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var161.setRecligT31(var146);
               double var148 = this.utilNombre.myRoundDevise((var133 + var138 + var140) * (double)(this.douanesPosition.getDoupos46() / var137 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var161.setRecligT46(var148);
               double var150 = this.utilNombre.myRoundDevise((var133 + var138 + var140) * (double)(this.douanesPosition.getDoupos53() / var137 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var161.setRecligT53(var150);
            } else if (this.douanesPosition == null && !this.valorisationEnteteAchats.isValExoDouane()) {
               var161.setRecligT1(var133);
               var161.setRecligT3(0.0D);
               var161.setRecligT10(0.0D);
               var161.setRecligT30(0.0D);
               var161.setRecligT31(0.0D);
               var161.setRecligT46(0.0D);
               var161.setRecligT53(0.0D);
            } else {
               var161.setRecligT1(0.0D);
               var161.setRecligT3(0.0D);
               var161.setRecligT10(0.0D);
               var161.setRecligT30(0.0D);
               var161.setRecligT31(0.0D);
               var161.setRecligT46(0.0D);
               var161.setRecligT53(0.0D);
            }

            double var163;
            if (!this.valorisationEnteteAchats.isValExoTva()) {
               var163 = 0.0D;
               var163 = this.utilNombre.myRoundDevise(var135, this.structureLog.getStrdevise());
               var161.setRecligT5(var163);
            } else {
               var161.setRecligT5(0.0D);
            }

            var161.setRecligFob(var124);
            var161.setRecligFret(var116);
            var161.setRecligAssurance(var127);
            var161.setRecligFrais(var131);
            var161.setRecligFinancier(var129);
            var161.setRecligPr(var124 + var116 + var127 + var131 + var129 + var161.getRecligT1() + var161.getRecligT3() + var161.getRecligT10() + var161.getRecligT30() + var161.getRecligT31() + var161.getRecligT46() + var161.getRecligT53());
            if (var161.getRecligQteUtil() != 0.0F) {
               var163 = this.utilNombre.myRound(var161.getRecligPr() / (double)var161.getRecligQteUtil(), 2);
               var161.setRecligPrU(var163);
               var161.setRecligPump(0.0D);
            }

            if (var161.getRecligPoidsNet() != 0.0F) {
               var163 = this.utilNombre.myRound(var161.getRecligPr() / (double)var161.getRecligPoidsNet(), 2);
               var161.setRecligPrKg(var163);
            }

            var161.setRecligPrUTtc(var161.getRecligPrU() + var118);
         }

         this.dataModelDetailValo.setWrappedData(this.listReceptionProduit);
         this.valorisationEnteteAchats.setValValeurDouane(var95);
         this.valorisationEnteteAchats.setValTotalFrais1(var160 + var97 + var101 + var103 + var105 + var107 + this.valorisationEnteteAchats.getValTotalFret());
         this.valorisationEnteteAchats.setValTotalDouaneTheo(var63);
         this.valorisationEnteteAchats.setValTotalTvaDouaneTheo(var65);
         this.valorisationEnteteAchats.setValTotalAssuranceTheo(var61);
         this.valorisationEnteteAchats.setValTotalFinancierTheo(var67);
         this.valorisationEnteteAchats.setValPr1(this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFrais1());
         if (this.valorisationEnteteAchats.getValPr1() != 0.0D && this.valorisationEnteteAchats.getValTotalFrais1() != 0.0D) {
            float var162 = 0.0F;
            if (this.optionAchats.getModCoefPr().equals("1")) {
               var162 = (float)(this.valorisationEnteteAchats.getValPr1() / this.valorisationEnteteAchats.getValTotalFob());
            } else {
               var162 = (float)(1.0D + this.valorisationEnteteAchats.getValTotalFrais1() / this.valorisationEnteteAchats.getValPr1());
            }

            this.valorisationEnteteAchats.setValCoef1(var162);
         } else {
            this.valorisationEnteteAchats.setValCoef1(0.0F);
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void calculValo1RecValeur() throws HibernateException, NamingException {
      float var1 = 0.0F;
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      boolean var18 = false;
      boolean var19 = false;
      boolean var20 = false;
      double var21 = 0.0D;
      double var23 = 0.0D;
      double var25 = 0.0D;
      Session var27 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
      this.listReceptionProduit = new ArrayList();
      ArrayList var28 = new ArrayList();
      ArrayList var29 = new ArrayList();
      FraisLigneAchatsDao var30 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      int var33;
      if (this.receptionListe.size() != 0 && this.valorisationEnteteAchats.getValNature1() == 13) {
         this.receptionEnteteAchats = new ReceptionEnteteAchats();

         for(int var31 = 0; var31 < this.receptionListe.size(); ++var31) {
            this.receptionEnteteAchats = (ReceptionEnteteAchats)this.receptionListe.get(var31);
            if (!this.receptionEnteteAchats.isRecExcluValo()) {
               var10 = var10 + this.receptionEnteteAchats.getRecTotHtLocal() + this.receptionEnteteAchats.getRecTotCertificatLocal() + this.receptionEnteteAchats.getRecTotCertificatConformiteLocal() + this.receptionEnteteAchats.getRecTotFraisAdmLocal();
               if (this.receptionEnteteAchats.getRecIncoterm() == null || this.receptionEnteteAchats.getRecIncoterm().isEmpty() || !this.receptionEnteteAchats.getRecIncoterm().equals("CFR") && !this.receptionEnteteAchats.getRecIncoterm().equals("CIF") && !this.receptionEnteteAchats.getRecIncoterm().equals("CPT")) {
                  if (this.receptionEnteteAchats.getRecIncoterm() != null && !this.receptionEnteteAchats.getRecIncoterm().isEmpty() && this.receptionEnteteAchats.getRecIncoterm().equals("EXW")) {
                     var10 += this.receptionEnteteAchats.getRecTotFret2Local();
                     var20 = true;
                  }
               } else {
                  if (this.optionAchats.getModeCifCfrREC().equals("1")) {
                     var6 += this.receptionEnteteAchats.getRecTotFretLocal();
                     var8 += this.receptionEnteteAchats.getRecTotFret2Local();
                     var4 += this.receptionEnteteAchats.getRecTotAssuranceLocal();
                  }

                  var21 += this.receptionEnteteAchats.getRecTotFretLocal();
                  var23 += this.receptionEnteteAchats.getRecTotFret2Local();
                  var25 += this.receptionEnteteAchats.getRecTotAssuranceLocal();
                  if (this.receptionEnteteAchats.getRecIncoterm().equals("CFR")) {
                     var18 = true;
                  } else if (this.receptionEnteteAchats.getRecIncoterm().equals("CPT")) {
                     var19 = true;
                  }
               }

               new ArrayList();
               List var32 = this.receptionLigneAchatsDao.chargerLesLignes(this.receptionEnteteAchats, var27);
               if (var32.size() != 0) {
                  for(var33 = 0; var33 < var32.size(); ++var33) {
                     if (((ReceptionLigneAchats)var32.get(var33)).getRecligQte() != 0.0F) {
                        var1 += ((ReceptionLigneAchats)var32.get(var33)).getRecligPoidsNet();
                        var2 += ((ReceptionLigneAchats)var32.get(var33)).getRecligPtDev();
                        var16 += ((ReceptionLigneAchats)var32.get(var33)).getRecligTva();
                        this.listReceptionProduit.add(var32.get(var33));
                     }
                  }
               }

               new ArrayList();
               List var157 = this.noteDebitLigneAchatsDao.chargerLesLignesByDossier(this.receptionEnteteAchats.getRecAnal4(), var27);
               if (var157.size() != 0) {
                  for(int var34 = 0; var34 < var157.size(); ++var34) {
                     if (((NoteDebitLigneAchats)var157.get(var34)).getNdfligQte() != 0.0F) {
                        var2 += ((NoteDebitLigneAchats)var157.get(var34)).getNdfligPt();
                        var16 += ((NoteDebitLigneAchats)var157.get(var34)).getNdfligTva();
                        var29.add(var157.get(var34));
                     }
                  }
               }

               new ArrayList();
               List var159 = var30.chargerLesLignesByDossier(this.receptionEnteteAchats.getRecAnal4(), var27);
               if (var159.size() != 0) {
                  for(int var35 = 0; var35 < var159.size(); ++var35) {
                     if (((FraisLigneAchats)var159.get(var35)).getFraisEnteteAchats().getFsfNumDoc() != null && !((FraisLigneAchats)var159.get(var35)).getFraisEnteteAchats().getFsfNumDoc().isEmpty() && ((FraisLigneAchats)var159.get(var35)).getFraisEnteteAchats().getFsfNumDoc().contains(":")) {
                        String[] var36 = ((FraisLigneAchats)var159.get(var35)).getFraisEnteteAchats().getFsfNumDoc().split(":");
                        if (this.receptionEnteteAchats.getRecNum().equals(var36[1])) {
                           var28.add(var159.get(var35));
                        }
                     }
                  }
               }
            }
         }

         new ArrayList();
         List var154 = var30.chargerLesLignesByDossier(this.receptionEnteteAchats.getRecAnal4(), var27);
         if (var154.size() != 0) {
            for(int var156 = 0; var156 < var154.size(); ++var156) {
               if (((FraisLigneAchats)var154.get(var156)).getFraisEnteteAchats().getFsfNumDoc() == null || ((FraisLigneAchats)var154.get(var156)).getFraisEnteteAchats().getFsfNumDoc().isEmpty() || ((FraisLigneAchats)var154.get(var156)).getFraisEnteteAchats().getFsfNumDoc().equals("REC") || ((FraisLigneAchats)var154.get(var156)).getFraisEnteteAchats().getFsfNumDoc().equals("")) {
                  var28.add(var154.get(var156));
               }
            }
         }
      }

      double var155;
      if (this.fraisList.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         var155 = 0.0D;

         for(var33 = 0; var33 < this.fraisList.size(); ++var33) {
            if (((FraisEnteteAchats)this.fraisList.get(var33)).getFsfTypeValo() == 1) {
               var155 += ((FraisEnteteAchats)this.fraisList.get(var33)).getFsfTotHt();
            }

            var16 += ((FraisEnteteAchats)this.fraisList.get(var33)).getFsfTotTva();
         }
      }

      if (this.valorisationEnteteAchats.getValCoefDeviseDouane() == 0.0F) {
         this.valorisationEnteteAchats.setValCoefDeviseDouane(1.0F);
      }

      var155 = 0.0D;
      double var158 = 0.0D;
      double var160 = 0.0D;
      double var37 = 0.0D;
      double var39 = 0.0D;
      double var41 = 0.0D;
      double var43 = 0.0D;
      int var45;
      if (var28.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         for(var45 = 0; var45 < var28.size(); ++var45) {
            var16 += ((FraisLigneAchats)var28.get(var45)).getFsfligTva();
            if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 0) {
               var155 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 1) {
               if (var18) {
                  var21 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               } else if (var19) {
                  var23 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               } else {
                  var158 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               }
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 2) {
               var25 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 3) {
               var37 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 4) {
               var39 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 5) {
               var41 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 6) {
               var43 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
            } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() != 7) {
               if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 8) {
                  var160 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               } else if (((FraisLigneAchats)var28.get(var45)).getFsfligMode() == 9) {
                  var10 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
                  var12 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               } else {
                  var155 += ((FraisLigneAchats)var28.get(var45)).getFsfligPtLocal();
               }
            }
         }

         var12 = var12 + this.receptionEnteteAchats.getRecTotCertificatLocal() + this.receptionEnteteAchats.getRecTotCertificatConformiteLocal() + this.receptionEnteteAchats.getRecTotFraisAdmLocal();
      }

      if (var29.size() != 0) {
         for(var45 = 0; var45 < var29.size(); ++var45) {
            var43 -= ((NoteDebitLigneAchats)var29.get(var45)).getNdfligPt();
         }
      }

      this.valorisationEnteteAchats.setValTotalReception(var10);
      if (this.receptionEnteteAchats.getRecIncoterm() == null || this.receptionEnteteAchats.getRecIncoterm().isEmpty() || !this.receptionEnteteAchats.getRecIncoterm().equals("CFR") && !this.receptionEnteteAchats.getRecIncoterm().equals("CIF") && !this.receptionEnteteAchats.getRecIncoterm().equals("CPT")) {
         this.valorisationEnteteAchats.setValTotalFob(var10);
      } else {
         this.valorisationEnteteAchats.setValTotalFob(var10 - var6 - var4);
      }

      this.valorisationEnteteAchats.setValTotalFret(var158 + var21);
      double var161;
      if (this.optionAchats.getModValoFret().equals("0") && (this.valorisationEnteteAchats.getValMode() == 1 || this.valorisationEnteteAchats.getValMode() == 2)) {
         var161 = this.utilNombre.myRoundDevise(this.valorisationEnteteAchats.getValTotalFret() / 2.0D, this.structureLog.getStrdevise());
         this.valorisationEnteteAchats.setValTotalFret(var161);
      }

      this.valorisationEnteteAchats.setValTotalAssuranceReelle(var25);
      this.valorisationEnteteAchats.setValTotalFinancierReelle(var160);
      this.valorisationEnteteAchats.setValTotalDouaneReelle(var37);
      var14 = (double)this.utilNombre.myRoundDevise(this.valorisationEnteteAchats.getValCoefForfaitTransport() * var1, this.structureLog.getStrdevise());
      this.valorisationEnteteAchats.setValForfaitTransport(var14);
      this.valorisationEnteteAchats.setValTotalTvaDouaneReelle(var39);
      if (this.valorisationEnteteAchats.getValFictif() == 0) {
         this.valorisationEnteteAchats.setValTotalTransit(var41);
         this.valorisationEnteteAchats.setValTotalDebours(var43 + var155);
      } else if (this.valorisationEnteteAchats.getValFictif() == 1) {
         this.valorisationEnteteAchats.setValTotalTransit(var41);
         this.valorisationEnteteAchats.setValTotalDebours(var43 + var155);
      } else if (this.valorisationEnteteAchats.getValFictif() == 2) {
         var41 = this.valorisationEnteteAchats.getValTotalTransit();
         var43 = this.valorisationEnteteAchats.getValTotalDebours();
      }

      this.valorisationEnteteAchats.setValPr1Ttc(this.valorisationEnteteAchats.getValPr1() + var16);
      var161 = 0.0D;
      if (var19) {
         var161 = this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFret() + this.valorisationEnteteAchats.getValForfaitTransport();
      } else {
         var161 = this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFret();
      }

      double var47 = this.valorisationEnteteAchats.getValTotalAssuranceReelle();
      double var49 = this.valorisationEnteteAchats.getValTotalDouaneReelle();
      double var51 = this.valorisationEnteteAchats.getValTotalTvaDouaneReelle();
      double var53 = this.valorisationEnteteAchats.getValTotalFinancierReelle();
      double var55 = this.valorisationEnteteAchats.getValTotalTransit();
      double var57 = this.valorisationEnteteAchats.getValTotalDebours() + this.valorisationEnteteAchats.getValTotalFraisProv();
      double var59 = this.valorisationEnteteAchats.getValForfaitTransport();
      double var61 = var161 + var47;
      double var63 = this.calculAssuranceTheorique(this.valorisationEnteteAchats.getValTotalFob(), this.valorisationEnteteAchats.getValTotalFret(), var27);
      double var65 = 0.0D;
      double var67 = 0.0D;
      double var69 = this.calculFinancierTheorique(this.valorisationEnteteAchats.getValTotalFob(), this.valorisationEnteteAchats.getValTotalFret(), var27);
      double var71 = 0.0D;
      double var73 = 0.0D;
      double var75 = 0.0D;
      double var77 = var161 + var63;
      double var79 = this.valorisationEnteteAchats.getValTotalAssuranceProv();
      double var81 = this.valorisationEnteteAchats.getValTotalDouaneProv();
      double var83 = this.valorisationEnteteAchats.getValTotalTvaDouaneProv();
      double var85 = this.valorisationEnteteAchats.getValTotalFinancierProv();
      double var87 = 0.0D;
      double var89 = 0.0D;
      double var91 = 0.0D;
      double var10000 = var161 + var79;
      double var97;
      double var99;
      double var101;
      double var103;
      double var105;
      double var107;
      double var109;
      double var111;
      if (this.listReceptionProduit.size() != 0) {
         new ReceptionLigneAchats();

         for(int var96 = 0; var96 < this.listReceptionProduit.size(); ++var96) {
            ReceptionLigneAchats var95 = (ReceptionLigneAchats)this.listReceptionProduit.get(var96);
            var97 = this.utilNombre.myRoundDevise(var61 * var95.getRecligPtDev() / var2, this.structureLog.getStrdevise());
            this.douanesPosition = this.douanesPositionDao.trouverPosition(this.structureLog.getStrzonecommerciale(), var95.getRecligDouane(), var27);
            if (this.douanesPosition != null && !this.valorisationEnteteAchats.isValExoDouane()) {
               var99 = this.utilNombre.myRoundDevise(var97 * (double)this.douanesPosition.getDouposDd() / 100.0D, this.structureLog.getStrdevise());
               var101 = this.utilNombre.myRoundDevise(var97 * (double)this.douanesPosition.getDouposRs() / 100.0D, this.structureLog.getStrdevise());
               var103 = this.utilNombre.myRoundDevise(var97 * (double)this.douanesPosition.getDouposPcs() / 100.0D, this.structureLog.getStrdevise());
               var105 = this.utilNombre.myRoundDevise(var97 * (double)this.douanesPosition.getDouposAd() / 100.0D, this.structureLog.getStrdevise());
               var107 = this.utilNombre.myRoundDevise(var97 * (double)this.douanesPosition.getDouposDa() / 100.0D, this.structureLog.getStrdevise());
               var109 = this.utilNombre.myRoundDevise((var97 + var99 + var101) * (double)this.douanesPosition.getDoupos46() / 100.0D, this.structureLog.getStrdevise());
               var111 = this.utilNombre.myRoundDevise((var97 + var99 + var101) * (double)this.douanesPosition.getDoupos53() / 100.0D, this.structureLog.getStrdevise());
               double var113 = 0.0D;
               if (!this.valorisationEnteteAchats.isValExoTva()) {
                  var113 = this.utilNombre.myRoundDevise((var97 + var99 + var101 + var111) * (double)this.douanesPosition.getDouposTva() / 100.0D, this.structureLog.getStrdevise());
               }

               var65 = var65 + var99 + var101 + var103 + var105 + var107 + var109 + var111;
               var67 += var113;
            }
         }
      }

      double var162 = 0.0D;
      var97 = 0.0D;
      var99 = 0.0D;
      var101 = 0.0D;
      var103 = 0.0D;
      var105 = 0.0D;
      var107 = 0.0D;
      var109 = 0.0D;
      var111 = 0.0D;
      if (this.listReceptionProduit.size() != 0 && this.valorisationEnteteAchats.getValNature1() != 0) {
         new ReceptionLigneAchats();
         if (this.valorisationEnteteAchats.getValFictif() == 0) {
            var162 = var47;
            if (var47 == 0.0D) {
               var162 = var79;
            }

            var97 = var61;
            var99 = var49;
            if (var49 == 0.0D) {
               var99 = var81;
            }

            var101 = var51;
            if (var51 == 0.0D) {
               var101 = var83;
            }

            var103 = var53;
            if (var53 == 0.0D) {
               var103 = var85;
            }

            var105 = var55;
            var107 = var57;
            if (var57 == 0.0D) {
               var107 = var89;
            }

            var109 = var59;
         } else if (this.valorisationEnteteAchats.getValFictif() == 1) {
            var162 = var63;
            var97 = var77;
            var99 = var65;
            var101 = var67;
            var103 = var69;
            var105 = var71;
            var107 = var73;
            var109 = var75;
         } else if (this.valorisationEnteteAchats.getValFictif() == 2) {
            if (var79 != 0.0D) {
               var111 += var79;
               var162 = var79;
            } else if (var47 != 0.0D) {
               var111 += var47;
               var162 = var47;
            } else {
               var111 += var63;
               var162 = var63;
            }

            if (var81 != 0.0D) {
               var111 += var81;
               var99 = var81;
            } else if (var49 != 0.0D) {
               var111 += var49;
               var99 = var49;
            } else {
               var111 += var65;
               var99 = var65;
            }

            if (var83 != 0.0D) {
               var101 = var83;
            } else if (var51 != 0.0D) {
               var101 = var51;
            } else {
               var101 = var67;
            }

            if (var85 != 0.0D) {
               var111 += var85;
               var103 = var85;
            } else if (var53 != 0.0D) {
               var111 += var53;
               var103 = var53;
            } else {
               var111 += var69;
               var103 = var69;
            }

            if (var55 != 0.0D) {
               var111 += var55;
               var105 = var55;
            } else {
               var111 += var71;
               var105 = var71;
            }

            if (var57 != 0.0D) {
               var111 += var57;
               var107 = var57;
            } else {
               var111 += var73;
               var107 = var73;
            }

            if (var59 != 0.0D) {
               var111 += var59;
               var109 = var59;
            } else {
               var111 += var75;
               var109 = var75;
            }

            var10000 = var111 + this.valorisationEnteteAchats.getValTotalFret();
         }

         for(int var114 = 0; var114 < this.listReceptionProduit.size(); ++var114) {
            ReceptionLigneAchats var163 = (ReceptionLigneAchats)this.listReceptionProduit.get(var114);
            float var115 = (float)(var163.getRecligPtDev() / var2 * 100.0D);
            double var116 = 0.0D;
            if (var19) {
               var116 = this.utilNombre.myRoundDevise(var23 * var163.getRecligPtDev() / var2, this.structureLog.getStrdevise());
            }

            double var118 = this.utilNombre.myRoundDevise((var158 + var21 + var116) * var163.getRecligPtDev() / var2, this.structureLog.getStrdevise());
            double var120 = this.utilNombre.myRoundDevise(var16 * (double)var115 / 100.0D / (double)var163.getRecligQte(), this.structureLog.getStrdevise());
            double var122 = this.utilNombre.myRoundDevise(var109 * var163.getRecligPtDev() / var2, this.structureLog.getStrdevise());
            double var124 = this.utilNombre.myRoundDevise(var4 * var163.getRecligPtDev() / var2, this.structureLog.getStrdevise());
            double var126 = 0.0D;
            if (var12 != 0.0D) {
               var126 = var163.getRecligPtDev() + var12 * (var163.getRecligPtDev() / var2);
            } else {
               var126 = var163.getRecligPtDev();
            }

            if (var20) {
               var126 += this.utilNombre.myRoundDevise(this.receptionEnteteAchats.getRecTotFret2Local() * (double)var115 / 100.0D, this.structureLog.getStrdevise());
            }

            float var128 = (float)(var126 / var10 * 100.0D);
            double var129 = this.utilNombre.myRoundDevise(var162 * (double)var128 / 100.0D, this.structureLog.getStrdevise());
            double var131 = this.utilNombre.myRoundDevise(var103 * var163.getRecligPtDev() / var2, this.structureLog.getStrdevise());
            double var133 = this.utilNombre.myRoundDevise((var105 + var107) * var163.getRecligPtDev() / var2, this.structureLog.getStrdevise());
            double var135 = this.utilNombre.myRoundDevise(var99 * var163.getRecligPtDev() / var2, this.structureLog.getStrdevise());
            double var137 = this.utilNombre.myRoundDevise(var101 * var163.getRecligPtDev() / var2, this.structureLog.getStrdevise());
            this.douanesPosition = this.douanesPositionDao.trouverPosition(this.structureLog.getStrzonecommerciale(), var163.getRecligDouane(), var27);
            if (this.douanesPosition != null && !this.valorisationEnteteAchats.isValExoDouane()) {
               float var139 = this.douanesPosition.getDouposDd() + this.douanesPosition.getDouposRs() + this.douanesPosition.getDouposPcs() + this.douanesPosition.getDouposAd() + this.douanesPosition.getDouposDa() + this.douanesPosition.getDoupos46() + this.douanesPosition.getDoupos53();
               double var140 = this.utilNombre.myRoundDevise(var135 * (double)(this.douanesPosition.getDouposDd() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setRecligT1(var140);
               double var142 = this.utilNombre.myRoundDevise(var135 * (double)(this.douanesPosition.getDouposRs() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setRecligT3(var142);
               double var144 = this.utilNombre.myRoundDevise(var135 * (double)(this.douanesPosition.getDouposPcs() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setRecligT10(var144);
               double var146 = this.utilNombre.myRoundDevise(var135 * (double)(this.douanesPosition.getDouposAd() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setRecligT30(var146);
               double var148 = this.utilNombre.myRoundDevise(var135 * (double)(this.douanesPosition.getDouposDa() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setRecligT31(var148);
               double var150 = this.utilNombre.myRoundDevise((var135 + var140 + var142) * (double)(this.douanesPosition.getDoupos46() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setRecligT46(var150);
               double var152 = this.utilNombre.myRoundDevise((var135 + var140 + var142) * (double)(this.douanesPosition.getDoupos53() / var139 * 100.0F) / 100.0D, this.structureLog.getStrdevise());
               var163.setRecligT53(var152);
            } else if (this.douanesPosition == null && !this.valorisationEnteteAchats.isValExoDouane()) {
               var163.setRecligT1(var135);
               var163.setRecligT3(0.0D);
               var163.setRecligT10(0.0D);
               var163.setRecligT30(0.0D);
               var163.setRecligT31(0.0D);
               var163.setRecligT46(0.0D);
               var163.setRecligT53(0.0D);
            } else {
               var163.setRecligT1(0.0D);
               var163.setRecligT3(0.0D);
               var163.setRecligT10(0.0D);
               var163.setRecligT30(0.0D);
               var163.setRecligT31(0.0D);
               var163.setRecligT46(0.0D);
               var163.setRecligT53(0.0D);
            }

            double var165 = 0.0D;
            if (!this.valorisationEnteteAchats.isValExoTva()) {
               var165 = this.utilNombre.myRoundDevise(var137, this.structureLog.getStrdevise());
               var163.setRecligT5(var165);
            } else {
               var163.setRecligT5(0.0D);
            }

            var163.setRecligFob(var126);
            var163.setRecligFret(var118);
            var163.setRecligAssurance(var129);
            var163.setRecligFrais(var133);
            var163.setRecligFinancier(var131);
            var163.setRecligPr(var126 + var118 + var129 + var133 + var131 + var163.getRecligT1() + var163.getRecligT3() + var163.getRecligT10() + var163.getRecligT30() + var163.getRecligT31() + var163.getRecligT46() + var163.getRecligT53());
            double var141;
            if (var163.getRecligQteUtil() != 0.0F) {
               var141 = this.utilNombre.myRound(var163.getRecligPr() / (double)var163.getRecligQteUtil(), 2);
               var163.setRecligPrU(var141);
               var163.setRecligPump(0.0D);
            }

            if (var163.getRecligPoidsNet() != 0.0F) {
               var141 = this.utilNombre.myRound(var163.getRecligPr() / (double)var163.getRecligPoidsNet(), 2);
               var163.setRecligPrKg(var141);
            }

            var163.setRecligPrUTtc(var163.getRecligPrU() + var120);
         }

         this.dataModelDetailValo.setWrappedData(this.listReceptionProduit);
         this.valorisationEnteteAchats.setValValeurDouane(var97);
         this.valorisationEnteteAchats.setValTotalFrais1(var162 + var99 + var103 + var105 + var107 + var109 + this.valorisationEnteteAchats.getValTotalFret());
         this.valorisationEnteteAchats.setValTotalDouaneTheo(var65);
         this.valorisationEnteteAchats.setValTotalTvaDouaneTheo(var67);
         this.valorisationEnteteAchats.setValTotalAssuranceTheo(var63);
         this.valorisationEnteteAchats.setValTotalFinancierTheo(var69);
         this.valorisationEnteteAchats.setValPr1(this.valorisationEnteteAchats.getValTotalFob() + this.valorisationEnteteAchats.getValTotalFrais1());
         if (this.valorisationEnteteAchats.getValPr1() != 0.0D && this.valorisationEnteteAchats.getValTotalFrais1() != 0.0D) {
            float var164 = 0.0F;
            if (this.optionAchats.getModCoefPr().equals("1")) {
               var164 = (float)(this.valorisationEnteteAchats.getValPr1() / this.valorisationEnteteAchats.getValTotalFob());
            } else {
               var164 = (float)(1.0D + this.valorisationEnteteAchats.getValTotalFrais1() / this.valorisationEnteteAchats.getValPr1());
            }

            this.valorisationEnteteAchats.setValCoef1(var164);
         } else {
            this.valorisationEnteteAchats.setValCoef1(0.0F);
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void calculValo2() {
      double var1;
      if (this.fraisList.size() != 0) {
         var1 = 0.0D;

         for(int var3 = 0; var3 < this.fraisList.size(); ++var3) {
            if (((FraisEnteteAchats)this.fraisList.get(var3)).getFsfTypeValo() == 2) {
               var1 += ((FraisEnteteAchats)this.fraisList.get(var3)).getFsfTotHt();
            }
         }

         this.valorisationEnteteAchats.setValTotalFrais2(var1);
      } else {
         this.valorisationEnteteAchats.setValTotalFrais2(0.0D);
      }

      if (this.valorisationEnteteAchats.getValNature2() == 47) {
         var1 = this.valorisationEnteteAchats.getValPr1() + this.valorisationEnteteAchats.getValTotalReexpedition() + this.valorisationEnteteAchats.getValTotalFrais2();
         this.valorisationEnteteAchats.setValPr2(var1);
      } else {
         this.valorisationEnteteAchats.setValTotalReexpedition(0.0D);
         this.valorisationEnteteAchats.setValTotalFrais2(0.0D);
         this.valorisationEnteteAchats.setValPr2(0.0D);
      }

      if (this.valorisationEnteteAchats.getValPr2() != 0.0D && this.valorisationEnteteAchats.getValTotalFrais2() != 0.0D) {
         float var4 = 0.0F;
         if (this.optionAchats.getModCoefPr().equals("1")) {
            var4 = (float)(this.valorisationEnteteAchats.getValPr2() / this.valorisationEnteteAchats.getValTotalFob());
         } else {
            var4 = (float)(1.0D + this.valorisationEnteteAchats.getValTotalFrais2() / this.valorisationEnteteAchats.getValPr2());
         }

         this.valorisationEnteteAchats.setValCoef2(var4);
      } else {
         this.valorisationEnteteAchats.setValCoef2(0.0F);
      }

   }

   public void accesImputSerie() {
      this.var_imput_choix = 0;
      this.var_imput_num = "";
      this.var_imput_serie = this.valorisationEnteteAchats.getValSerie();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         ValorisationEnteteAchats var1 = new ValorisationEnteteAchats();
         var1 = this.valorisationEnteteAchatsDao.pourParapheur(this.var_imput_num, var1.getValSerie(), (Session)null);
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
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.valorisationEnteteAchats.getValNum();
               this.valorisationEnteteAchats.setValNum(this.var_imput_num);
               this.valorisationEnteteAchatsDao.modif(this.valorisationEnteteAchats, var1);
               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.valorisationEnteteAchats.getValId(), this.nature, var1);
               if (var4 != null) {
                  for(var5 = 0; var5 < var4.size(); ++var5) {
                     new Parapheur();
                     var6 = (Parapheur)var4.get(var5);
                     var6.setPhrNum(this.valorisationEnteteAchats.getValNum());
                     this.parapheurDao.modif(var6, var1);
                  }
               }

               var21 = new Espion();
               var21.setUsers(this.usersLog);
               var21.setEsptype(0);
               var21.setEspdtecreat(new Date());
               var21.setEspaction("Imputation Valorisation N° " + var3 + " en Valorisation N° " + this.valorisationEnteteAchats.getValNum());
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
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.valorisationEnteteAchats.getValNum();
            this.valorisationEnteteAchats.setValSerie(this.var_imput_serie);
            this.valorisationEnteteAchats.setValNum(this.calculChrono.numCompose(this.valorisationEnteteAchats.getValDate(), this.nature, this.valorisationEnteteAchats.getValSerie(), var1));
            this.valorisationEnteteAchatsDao.modif(this.valorisationEnteteAchats, var1);
            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.valorisationEnteteAchats.getValId(), this.nature, var1);
            if (var4 != null) {
               for(var5 = 0; var5 < var4.size(); ++var5) {
                  new Parapheur();
                  var6 = (Parapheur)var4.get(var5);
                  var6.setPhrNum(this.valorisationEnteteAchats.getValNum());
                  this.parapheurDao.modif(var6, var1);
               }
            }

            var21 = new Espion();
            var21.setUsers(this.usersLog);
            var21.setEsptype(0);
            var21.setEspdtecreat(new Date());
            var21.setEspaction("Imputation Valorisation X N° " + var3 + " en Valorisation " + this.valorisationEnteteAchats.getValSerie() + " N° " + this.valorisationEnteteAchats.getValNum());
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

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      return var2;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatValorisation.jpg");
            if (var4.exists()) {
               var3 = "formatValorisation.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatValorisation.jpg");
         if (var4.exists()) {
            var3 = "formatValorisation.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun(String var1) throws IOException, HibernateException, NamingException {
      JRBeanCollectionDataSource var2 = null;
      ArrayList var3 = new ArrayList();
      if (this.optionAchats.getAxeDossier().equals("2") && this.valorisationEnteteAchats.getValDossierTransit() != null && !this.valorisationEnteteAchats.getValDossierTransit().isEmpty()) {
         if (this.valorisationEnteteAchats.getValDossierTransit() != null && !this.valorisationEnteteAchats.getValDossierTransit().isEmpty()) {
            new ArrayList();
            FraisLigneAchatsDao var13 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            List var11 = var13.chargerLesLignesByDossier(this.valorisationEnteteAchats.getValDossierTransit(), this.valorisationEnteteAchats.getValAnalytique(), (Session)null);
            ReceptionLigneAchats var15;
            int var16;
            if (var11.size() != 0) {
               new ReceptionLigneAchats();

               for(var16 = 0; var16 < var11.size(); ++var16) {
                  var15 = new ReceptionLigneAchats();
                  var15.setTypeLigne(0);
                  var15.setReceptionEnteteAchats(this.receptionEnteteAchats);
                  var15.setValorisationEnteteAchats(this.valorisationEnteteAchats);
                  var15.setRecligCode(((FraisLigneAchats)var11.get(var16)).getFsfligCode());
                  var15.setRecligDouane(((FraisLigneAchats)var11.get(var16)).getLibelle_nature());
                  var15.setRecligLibelle(((FraisLigneAchats)var11.get(var16)).getFsfligLibelle());
                  var15.setRecligQteUtil(1.0F);
                  var15.setRecligPt(((FraisLigneAchats)var11.get(var16)).getFsfligPt());
                  var15.setRecligPrU(((FraisLigneAchats)var11.get(var16)).getFsfligPtLocal());
                  var15.setRecligPr(((FraisLigneAchats)var11.get(var16)).getFsfligPtLocal());
                  var3.add(var15);
               }
            }

            if (this.receptionListe.size() != 0) {
               new ReceptionLigneAchats();

               for(var16 = 0; var16 < this.receptionListe.size(); ++var16) {
                  if (((ReceptionEnteteAchats)this.receptionListe.get(var16)).getRecIncoterm() != null && !((ReceptionEnteteAchats)this.receptionListe.get(var16)).getRecIncoterm().isEmpty() && ((ReceptionEnteteAchats)this.receptionListe.get(var16)).getRecIncoterm().equals("EXW")) {
                     var15 = new ReceptionLigneAchats();
                     var15.setTypeLigne(0);
                     var15.setReceptionEnteteAchats((ReceptionEnteteAchats)this.receptionListe.get(var16));
                     var15.setValorisationEnteteAchats(this.valorisationEnteteAchats);
                     var15.setRecligCode("");
                     var15.setRecligDouane("Fret");
                     var15.setRecligLibelle("Livraison");
                     var15.setRecligQteUtil(1.0F);
                     var15.setRecligPt(0.0D);
                     var15.setRecligPrU(((ReceptionEnteteAchats)this.receptionListe.get(var16)).getRecTotFretLocal());
                     var15.setRecligPr(((ReceptionEnteteAchats)this.receptionListe.get(var16)).getRecTotFretLocal());
                     var3.add(var15);
                  }
               }
            }
         }

         ReceptionLigneAchats var12;
         int var14;
         if (this.listReceptionProduit.size() != 0) {
            new ReceptionLigneAchats();

            for(var14 = 0; var14 < this.listReceptionProduit.size(); ++var14) {
               var12 = (ReceptionLigneAchats)this.listReceptionProduit.get(var14);
               var12.setTypeLigne(1);
               var12.setRecligDevise(((ReceptionLigneAchats)this.listReceptionProduit.get(var14)).getReceptionEnteteAchats().getRecDevise());
               var12.setValorisationEnteteAchats(this.valorisationEnteteAchats);
               var3.add(var12);
            }
         }

         if (this.valorisationEnteteAchats.getValDossierTransit() != null && !this.valorisationEnteteAchats.getValDossierTransit().isEmpty() && this.listFactureVentes.size() != 0) {
            new ReceptionLigneAchats();

            for(var14 = 0; var14 < this.listFactureVentes.size(); ++var14) {
               var12 = new ReceptionLigneAchats();
               var12.setTypeLigne(2);
               var12.setReceptionEnteteAchats(this.receptionEnteteAchats);
               var12.setValorisationEnteteAchats(this.valorisationEnteteAchats);
               var12.setRecligCode(((FactureEnteteVentes)this.listFactureVentes.get(var14)).getFacNum());
               var12.setRecligDouane(this.utilDate.dateToStringFrLg(((FactureEnteteVentes)this.listFactureVentes.get(var14)).getFacDate()));
               var12.setRecligLibelle(((FactureEnteteVentes)this.listFactureVentes.get(var14)).getFacNomTiers());
               var12.setRecligQteUtil(1.0F);
               var12.setRecligPt(0.0D);
               var12.setRecligPrU(((FactureEnteteVentes)this.listFactureVentes.get(var14)).getFacTotHt());
               var12.setRecligPr(((FactureEnteteVentes)this.listFactureVentes.get(var14)).getFacTotHt());
               var3.add(var12);
            }
         }
      } else if (this.listReceptionProduit.size() != 0) {
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationLigne");
         new Produits();
         ProduitsAchsDao var6 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         ProduitsTarifDao var7 = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         new ReceptionLigneAchats();

         for(int var10 = 0; var10 < this.listReceptionProduit.size(); ++var10) {
            ReceptionLigneAchats var9 = (ReceptionLigneAchats)this.listReceptionProduit.get(var10);
            if (var9.getRecligCode() != null && !var9.getRecligCode().isEmpty()) {
               Produits var5 = var6.chargeProduit(var9.getRecligCode(), var4);
               if (var5 != null) {
                  List var8 = var7.selectProdTarifByprod(var5, var4);
                  if (var8.size() != 0) {
                     var9.setPv_ht(((ProduitsTarif)var8.get(0)).getProtarPv());
                  }
               }
            }

            var9.setValorisationEnteteAchats(this.valorisationEnteteAchats);
            var3.add(var9);
         }

         this.utilInitHibernate.closeSession();
      }

      var2 = new JRBeanCollectionDataSource(var3);
      return var2;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationLigne");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         boolean var5 = false;
         if (this.valorisationEnteteAchats.getValDateImp() != null) {
            var2 = true;
         }

         this.valorisationEnteteAchats.setValDateImp(new Date());
         if (this.valorisationEnteteAchats.getValEtat() == 0 && this.valorisationEnteteAchats.getValEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.valorisationEnteteAchats.setValEtat(1);
            var5 = true;
         }

         this.valorisationEnteteAchats.setValModeleImp(var1);
         this.valorisationEnteteAchats = this.valorisationEnteteAchatsDao.modif(this.valorisationEnteteAchats, var3);
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
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun(var3));
            var1.setRapport(var3);
            var1.setEntete("Impression valoriation");
            var1.setCheminRapport(this.calculeCheminRapport(this.baseLog));
            var1.setCheminSousrapport(this.calculeCheminSousRapport(this.baseLog));
            var1.setImageFondPage(this.calculeImageFond(this.baseLog, this.valorisationEnteteAchats.getValEtat()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionAchats.getNbDecQte());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.valorisationEnteteAchats.getValIdResponsable());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.valorisationEnteteAchats.getValId());
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des valorisations");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "valorisation" + File.separator);
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
         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.lesEntetesList);
         var1.setjRBeanCollectionDataSource(var12);
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

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public ValorisationEnteteAchats getValorisationEnteteAchats() {
      return this.valorisationEnteteAchats;
   }

   public void setValorisationEnteteAchats(ValorisationEnteteAchats var1) {
      this.valorisationEnteteAchats = var1;
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

   public String getInpDossier() {
      return this.inpDossier;
   }

   public void setInpDossier(String var1) {
      this.inpDossier = var1;
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

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }

   public Parapheur getParapheur() {
      return this.parapheur;
   }

   public void setParapheur(Parapheur var1) {
      this.parapheur = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
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

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
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

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
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

   public boolean isVerrouDate() {
      return this.verrouDate;
   }

   public void setVerrouDate(boolean var1) {
      this.verrouDate = var1;
   }

   public Date getVar_date() {
      return this.var_date;
   }

   public void setVar_date(Date var1) {
      this.var_date = var1;
   }

   public DataModel getDatamodelCommande() {
      return this.datamodelCommande;
   }

   public void setDatamodelCommande(DataModel var1) {
      this.datamodelCommande = var1;
   }

   public DataModel getDatamodelFrais() {
      return this.datamodelFrais;
   }

   public void setDatamodelFrais(DataModel var1) {
      this.datamodelFrais = var1;
   }

   public DataModel getDatamodelReacheminement() {
      return this.datamodelReacheminement;
   }

   public void setDatamodelReacheminement(DataModel var1) {
      this.datamodelReacheminement = var1;
   }

   public DataModel getDatamodelReception() {
      return this.datamodelReception;
   }

   public void setDatamodelReception(DataModel var1) {
      this.datamodelReception = var1;
   }

   public DataModel getDatamodelElementNonValo() {
      return this.datamodelElementNonValo;
   }

   public void setDatamodelElementNonValo(DataModel var1) {
      this.datamodelElementNonValo = var1;
   }

   public boolean isShowModalPanelNonValo() {
      return this.showModalPanelNonValo;
   }

   public void setShowModalPanelNonValo(boolean var1) {
      this.showModalPanelNonValo = var1;
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

   public boolean isShowModalPanelFais() {
      return this.showModalPanelFais;
   }

   public void setShowModalPanelFais(boolean var1) {
      this.showModalPanelFais = var1;
   }

   public FraisEnteteAchats getFraisEnteteAchats() {
      return this.fraisEnteteAchats;
   }

   public void setFraisEnteteAchats(FraisEnteteAchats var1) {
      this.fraisEnteteAchats = var1;
   }

   public DataModel getDatamodelDetailFrais() {
      return this.datamodelDetailFrais;
   }

   public void setDatamodelDetailFrais(DataModel var1) {
      this.datamodelDetailFrais = var1;
   }

   public DataModel getDataModelDetailValo() {
      return this.dataModelDetailValo;
   }

   public void setDataModelDetailValo(DataModel var1) {
      this.dataModelDetailValo = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public DataModel getDatamodelNdb() {
      return this.datamodelNdb;
   }

   public void setDatamodelNdb(DataModel var1) {
      this.datamodelNdb = var1;
   }

   public DataModel getDatamodelDouane() {
      return this.datamodelDouane;
   }

   public void setDatamodelDouane(DataModel var1) {
      this.datamodelDouane = var1;
   }

   public boolean isShowModalPanelDouane() {
      return this.showModalPanelDouane;
   }

   public void setShowModalPanelDouane(boolean var1) {
      this.showModalPanelDouane = var1;
   }

   public DataModel getDataModelEcriture() {
      return this.dataModelEcriture;
   }

   public void setDataModelEcriture(DataModel var1) {
      this.dataModelEcriture = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
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

   public DataModel getDatamodelFactureVentes() {
      return this.datamodelFactureVentes;
   }

   public void setDatamodelFactureVentes(DataModel var1) {
      this.datamodelFactureVentes = var1;
   }

   public boolean isShowModalPanelImput() {
      return this.showModalPanelImput;
   }

   public void setShowModalPanelImput(boolean var1) {
      this.showModalPanelImput = var1;
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

   public String getVar_imput_serie() {
      return this.var_imput_serie;
   }

   public void setVar_imput_serie(String var1) {
      this.var_imput_serie = var1;
   }
}
