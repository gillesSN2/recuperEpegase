package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesPrevision;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.TicketEnteteVentes;
import com.epegase.systeme.classe.TicketLigneVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CaissesPrevisionDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TicketEnteteVentesDao;
import com.epegase.systeme.dao.TicketLigneVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
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

public class FormTicketVentes implements Serializable {
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
   private OptionVentes optionsVentes;
   private OptionCaisses optionCaisses;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private ExercicesCaisse exercicesCaisse;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_timbre;
   private int var_tc_type;
   private String var_tc_libelle;
   private float var_tc_taux;
   private boolean var_tc_calcul;
   private int var_nb_max = 100;
   private boolean var_affiche_ajout = false;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean visibleOnglet = false;
   private boolean var_sansstock = false;
   private boolean var_typeTiers = true;
   private Tiers tiers;
   private List lesFamilleClientsListe;
   private ObjetFamilleTiers objetFamilleTiers;
   private transient DataModel dataModelFamilleClient = new ListDataModel();
   private List lesModeReglementClientsListe;
   private long var_nom_commercial;
   private String var_commercial;
   private long var_nom_responsable;
   private String var_responsable;
   private String var_caisse;
   private UserDao userDao;
   private long var_nom_equipe;
   private String var_equipe;
   private Equipes equipes;
   private EquipesDao equipesDao;
   private List lesLivreurs = new ArrayList();
   private transient DataModel dataModelLivreurs = new ListDataModel();
   private PlansAnalytiques plansAnalytiques = new PlansAnalytiques();
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private transient DataModel dataModelTicket = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private TicketEnteteVentes ticketEnteteVentes;
   private TicketEnteteVentesDao ticketEnteteVentesDao;
   private List lesEnteteList = new ArrayList();
   private boolean var_valide_doc = false;
   private double montantHt = 0.0D;
   private double montantTaxe = 0.0D;
   private double montantTc = 0.0D;
   private double montantTtc = 0.0D;
   private double montantSolde = 0.0D;
   private double montantReglement = 0.0D;
   private double montant_timbre = 0.0D;
   private int var_nb_ligne = 0;
   private UtilDate utilDate = new UtilDate();
   private transient DataModel datamodelLigne = new ListDataModel();
   private TicketLigneVentes ticketLigneVentes = new TicketLigneVentes();
   private TicketLigneVentesDao ticketLigneVentesDao;
   private List lesLignesList = new ArrayList();
   private String var_depotProd;
   private String var_depotOrigine;
   private boolean griserValider = false;
   private Date inpDu;
   private Date inpAu;
   private Produits produits;
   private ProduitsVtesDao produitsDao;
   private ProduitsTarif produitsTarif;
   private ProduitsTarifDao produitsTarifDao;
   private ProduitsDepot produitsDepot = new ProduitsDepot();
   private ProduitsDepotDao produitsDepotDao;
   private TaxesVentesDao taxesVentesDao;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private FamillesProduitsVentes famillesProduitsVentes;
   private double prixUnitaires;
   private CalculStock calculStock = new CalculStock();
   private List listProduits = new ArrayList();
   private String var_tarif1;
   private String var_tarif2;
   private String var_tarif3;
   private String var_tarif4;
   private String var_tarif5;
   private boolean var_aff_tarif1;
   private boolean var_aff_tarif2;
   private boolean var_aff_tarif3;
   private boolean var_aff_tarif4;
   private boolean var_aff_tarif5;
   private BaremesDao baremesDao;
   private boolean verifBareme;
   private String montant_lettre;
   private UtilNombre utilNombre = new UtilNombre();
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
   private boolean verrouRemise = false;
   private UtilPrint utilPrint;
   private List lesmodelesImpressions = new ArrayList();
   private boolean affMail = false;
   private String nomModeleListe;
   private String format = "PDF";
   private String requete;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean visibleOptionMail = false;
   private int var_choix_modele;
   private boolean affListeDoc = false;
   private boolean showModalPanelPrint = false;
   private long idTicket;
   private boolean var_anal_activite;
   private int var_anal_SitDepSer;
   private CaissesCommerciales caissesCommerciales;
   private CaissesCommercialesDao caissesCommercialesDao;
   private boolean showModalPanelReglement = false;
   private Reglements reglements;
   private boolean var_affiche_banque = false;
   private String var_type_reg;
   private int varTypeReg;
   private String var_banque_tireur;
   private String var_num_cheque;
   private double val_timbre;
   private double var_ecart_reglement;
   private ReglementsDao reglementsDao;
   private boolean valide_reglement = false;
   private double var_tot_bon_encaissement;
   private List lesReglements = new ArrayList();
   private transient DataModel dataModelReglement = new ListDataModel();
   private double montantEncaisse;
   private double montantRendu;
   private List lesMvt;
   private boolean showModalPanelPrintStock = false;
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
   private int typeBouton = 0;
   private List lesFamilles = new ArrayList();
   private transient DataModel dataModelFamilleProduit = new ListDataModel();
   private List lesProduits = new ArrayList();
   private transient DataModel dataModelProduits = new ListDataModel();
   private boolean showModalPaveNumerique = false;
   private boolean pointDecimal;
   private String lettreSaisie;
   private int typePaveNumerique;
   private String libellePaveNumerique;
   private boolean showModalPaveLettre = false;
   private List lesTiers = new ArrayList();
   private transient DataModel dataModelTiers = new ListDataModel();
   private boolean showModalPanelFondsCaisse = false;
   private boolean showModalPanelFinSession = false;
   private int nbP1;
   private int nbP2;
   private int nbP3;
   private int nbP4;
   private int nbP5;
   private int nbP6;
   private int nbP7;
   private int nbP8;
   private int nbP9;
   private int nbP10;
   private int nbB1;
   private int nbB2;
   private int nbB3;
   private int nbB4;
   private int nbB5;
   private int nbB6;
   private int nbB7;
   private int nbB8;
   private int nbB9;
   private int nbB10;
   private double totP1;
   private double totP2;
   private double totP3;
   private double totP4;
   private double totP5;
   private double totP6;
   private double totP7;
   private double totP8;
   private double totP9;
   private double totP10;
   private double totB1;
   private double totB2;
   private double totB3;
   private double totB4;
   private double totB5;
   private double totB6;
   private double totB7;
   private double totB8;
   private double totB9;
   private double totB10;
   private int val_p1;
   private int val_p2;
   private int val_p3;
   private int val_p4;
   private int val_p5;
   private int val_p6;
   private int val_p7;
   private int val_p8;
   private int val_p9;
   private int val_p10;
   private int val_b1;
   private int val_b2;
   private int val_b3;
   private int val_b4;
   private int val_b5;
   private int val_b6;
   private int val_b7;
   private int val_b8;
   private int val_b9;
   private int val_b10;
   private double totalPiece;
   private double totalBillet;
   private double totalCaisse;
   private double totalCheques;
   private double totalDevises;
   private int choixClick;
   private CaissesPrevisionDao caissesPrevisionDao;
   private CaissesPrevision caissesPrevision = new CaissesPrevision();

   public FormTicketVentes() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.ticketEnteteVentesDao = new TicketEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.ticketLigneVentesDao = new TicketLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.caissesPrevisionDao = new CaissesPrevisionDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
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

      this.var_date = new Date();
      this.var_nom_commercial = this.usersLog.getUsrid();
      this.var_commercial = this.usersLog.getUsrPatronyme();
      this.var_nom_equipe = this.usersLog.getUsrIdEquipe();
      this.var_equipe = this.usersLog.getUsrNomEquipe();
      this.equipes = this.equipesDao.rechercheEquipesByEquipe(this.var_nom_equipe, var1);
      if (this.equipes != null) {
         this.var_nom_responsable = this.equipes.getEquIdResponsable();
         this.var_responsable = this.equipes.getEquNomResponsable();
         this.var_caisse = this.equipes.getEquCaisse();
         this.var_depotOrigine = this.equipes.getEquDepotOrigine();
         this.var_depotProd = this.equipes.getEquDepot();
         String var2 = "";
         if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
            String[] var3 = this.var_caisse.split(":");
            var2 = var3[0];
         } else {
            var2 = this.var_caisse;
         }

         this.caissesCommerciales = this.caissesCommercialesDao.selectCaisse(this.exercicesCaisse.getExecaiId(), var2, var1);
      } else {
         this.var_nom_equipe = 0L;
         this.var_equipe = "????";
         this.var_nom_responsable = 0L;
         this.var_responsable = "????";
         this.var_caisse = "????";
         this.var_depotOrigine = "????";
         this.var_depotProd = "????";
         this.caissesCommerciales = null;
      }

      LireLesoptionsCaisses var4 = new LireLesoptionsCaisses();
      var4.setStrId(this.structureLog.getStrid());
      this.optionCaisses = var4.lancer();
      if (this.optionCaisses.getB1() != null && !this.optionCaisses.getB1().isEmpty()) {
         this.val_b1 = Integer.parseInt(this.optionCaisses.getB1());
      }

      if (this.optionCaisses.getB2() != null && !this.optionCaisses.getB2().isEmpty()) {
         this.val_b2 = Integer.parseInt(this.optionCaisses.getB2());
      }

      if (this.optionCaisses.getB3() != null && !this.optionCaisses.getB3().isEmpty()) {
         this.val_b3 = Integer.parseInt(this.optionCaisses.getB3());
      }

      if (this.optionCaisses.getB4() != null && !this.optionCaisses.getB4().isEmpty()) {
         this.val_b4 = Integer.parseInt(this.optionCaisses.getB4());
      }

      if (this.optionCaisses.getB5() != null && !this.optionCaisses.getB5().isEmpty()) {
         this.val_b5 = Integer.parseInt(this.optionCaisses.getB5());
      }

      if (this.optionCaisses.getB6() != null && !this.optionCaisses.getB6().isEmpty()) {
         this.val_b6 = Integer.parseInt(this.optionCaisses.getB6());
      }

      if (this.optionCaisses.getB7() != null && !this.optionCaisses.getB7().isEmpty()) {
         this.val_b7 = Integer.parseInt(this.optionCaisses.getB7());
      }

      if (this.optionCaisses.getB8() != null && !this.optionCaisses.getB8().isEmpty()) {
         this.val_b8 = Integer.parseInt(this.optionCaisses.getB8());
      }

      if (this.optionCaisses.getB9() != null && !this.optionCaisses.getB9().isEmpty()) {
         this.val_b9 = Integer.parseInt(this.optionCaisses.getB9());
      }

      if (this.optionCaisses.getB10() != null && !this.optionCaisses.getB10().isEmpty()) {
         this.val_b10 = Integer.parseInt(this.optionCaisses.getB10());
      }

      if (this.optionCaisses.getP1() != null && !this.optionCaisses.getP1().isEmpty()) {
         this.val_p1 = Integer.parseInt(this.optionCaisses.getP1());
      }

      if (this.optionCaisses.getP2() != null && !this.optionCaisses.getP2().isEmpty()) {
         this.val_p2 = Integer.parseInt(this.optionCaisses.getP2());
      }

      if (this.optionCaisses.getP3() != null && !this.optionCaisses.getP3().isEmpty()) {
         this.val_p3 = Integer.parseInt(this.optionCaisses.getP3());
      }

      if (this.optionCaisses.getP4() != null && !this.optionCaisses.getP4().isEmpty()) {
         this.val_p4 = Integer.parseInt(this.optionCaisses.getP4());
      }

      if (this.optionCaisses.getP5() != null && !this.optionCaisses.getP5().isEmpty()) {
         this.val_p5 = Integer.parseInt(this.optionCaisses.getP5());
      }

      if (this.optionCaisses.getP6() != null && !this.optionCaisses.getP6().isEmpty()) {
         this.val_p6 = Integer.parseInt(this.optionCaisses.getP6());
      }

      if (this.optionCaisses.getP7() != null && !this.optionCaisses.getP7().isEmpty()) {
         this.val_p7 = Integer.parseInt(this.optionCaisses.getP7());
      }

      if (this.optionCaisses.getP8() != null && !this.optionCaisses.getP8().isEmpty()) {
         this.val_p8 = Integer.parseInt(this.optionCaisses.getP8());
      }

      if (this.optionCaisses.getP9() != null && !this.optionCaisses.getP9().isEmpty()) {
         this.val_p9 = Integer.parseInt(this.optionCaisses.getP9());
      }

      if (this.optionCaisses.getP10() != null && !this.optionCaisses.getP10().isEmpty()) {
         this.val_p10 = Integer.parseInt(this.optionCaisses.getP10());
      }

      this.recupererFamillesClientItem();
      this.initPage();
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrVerRemise() == 0) {
         this.verrouRemise = false;
      } else {
         this.verrouRemise = true;
      }

      if (this.usersLog.getUsrProdService() == 0) {
         this.accesProduits = false;
      } else {
         this.accesProduits = true;
      }

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
      this.montantHt = 0.0D;
      this.montantTaxe = 0.0D;
      this.montantTc = 0.0D;
      this.montantTtc = 0.0D;
      this.montantSolde = 0.0D;
      this.montantReglement = 0.0D;
      this.montant_timbre = 0.0D;
      this.lesLignesList.clear();
   }

   public void chargerCaisse(Session var1) throws HibernateException, NamingException {
      if (this.var_caisse != null && !this.var_caisse.isEmpty()) {
         String[] var2 = this.var_caisse.split(":");
         this.caissesCommerciales = this.caissesCommercialesDao.selectCaisseByCode(var2[0], this.exercicesCaisse, var1);
      }

   }

   public void calculePv(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.listProduits.size() != 0) {
         this.recupererFamillesClientItem();
         this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);

         for(int var2 = 0; var2 < this.listProduits.size(); ++var2) {
            this.produits = new Produits();
            this.produits = (Produits)this.listProduits.get(var2);
            double var3;
            if (this.var_aff_tarif1 && this.var_tarif1 != null && !this.var_tarif1.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif1, var1);
               if (this.produitsTarif != null) {
                  var3 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var3 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv1(var3);
                  } else {
                     var3 = this.produitsTarif.getProtarPv();
                     this.produits.setPv1(var3);
                  }
               }
            }

            if (this.var_aff_tarif2 && this.var_tarif2 != null && !this.var_tarif2.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif2, var1);
               if (this.produitsTarif != null) {
                  var3 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var3 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv2(var3);
                  } else {
                     var3 = this.produitsTarif.getProtarPv();
                     this.produits.setPv2(var3);
                  }
               }
            }

            if (this.var_aff_tarif3 && this.var_tarif3 != null && !this.var_tarif3.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif3, var1);
               if (this.produitsTarif != null) {
                  var3 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var3 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv3(var3);
                  } else {
                     var3 = this.produitsTarif.getProtarPv();
                     this.produits.setPv3(var3);
                  }
               }
            }

            if (this.var_aff_tarif4 && this.var_tarif4 != null && !this.var_tarif4.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif4, var1);
               if (this.produitsTarif != null) {
                  var3 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var3 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv4(var3);
                  } else {
                     var3 = this.produitsTarif.getProtarPv();
                     this.produits.setPv4(var3);
                  }
               }
            }

            if (this.var_aff_tarif5 && this.var_tarif5 != null && !this.var_tarif5.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif5, var1);
               if (this.produitsTarif != null) {
                  var3 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var3 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv5(var3);
                  } else {
                     var3 = this.produitsTarif.getProtarPv();
                     this.produits.setPv4(var3);
                  }
               }
            }
         }
      }

   }

   public void recupererFamillesClientItem() throws JDOMException, IOException {
      LectureFamillesClients var1 = new LectureFamillesClients();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesClientItems();
      this.lesFamilleClientsListe = var1.getMesFamillesClients();
      this.dataModelFamilleClient.setWrappedData(this.lesFamilleClientsListe);
      this.var_tarif1 = "";
      this.var_tarif2 = "";
      this.var_tarif3 = "";
      this.var_tarif4 = "";
      this.var_tarif5 = "";
      this.var_aff_tarif1 = false;
      this.var_aff_tarif2 = false;
      this.var_aff_tarif3 = false;
      this.var_aff_tarif4 = false;
      this.var_aff_tarif5 = false;

      for(int var2 = 0; var2 < this.lesFamilleClientsListe.size(); ++var2) {
         if (var2 == 0) {
            this.var_tarif1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(0)).getLibelle();
            this.var_aff_tarif1 = true;
         } else if (var2 == 1) {
            this.var_tarif2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(1)).getLibelle();
            this.var_aff_tarif2 = true;
         } else if (var2 == 2) {
            this.var_tarif3 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(2)).getLibelle();
            this.var_aff_tarif3 = true;
         } else if (var2 == 3) {
            this.var_tarif4 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(3)).getLibelle();
            this.var_aff_tarif4 = true;
         } else if (var2 == 4) {
            this.var_tarif5 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(4)).getLibelle();
            this.var_aff_tarif5 = true;
         }
      }

   }

   public int calculformatDevise(String var1) {
      int var2 = 0;
      if (var1 != null && !var1.isEmpty()) {
         if (!var1.equals("XAF") && !var1.equals("XOF")) {
            if (var1.equals("EUR") || var1.equals("CHF")) {
               var2 = 1;
            }
         } else {
            var2 = 2;
         }
      } else {
         var2 = this.structureLog.getStrformatdevise();
      }

      return var2;
   }

   public void listeDocument() throws NamingException {
   }

   public void rechercheTickets() throws HibernateException, NamingException {
   }

   public void selectionTicket() throws JDOMException, IOException, HibernateException, NamingException {
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

         this.ticketEnteteVentes = (TicketEnteteVentes)var1.get(0);
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BticketLigne");
         this.ticketEnteteVentes = this.ticketEnteteVentesDao.pourParapheur(this.ticketEnteteVentes.getTicId(), var4);
         if (this.ticketEnteteVentes != null) {
            this.var_date = this.ticketEnteteVentes.getTicDate();
            if (this.ticketEnteteVentes.getTicDate().getHours() <= 9) {
               this.var_heure = "0" + this.ticketEnteteVentes.getTicDate().getHours();
            } else {
               this.var_heure = "" + this.ticketEnteteVentes.getTicDate().getHours();
            }

            if (this.ticketEnteteVentes.getTicDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.ticketEnteteVentes.getTicDate().getMinutes();
            } else {
               this.var_minute = "" + this.ticketEnteteVentes.getTicDate().getMinutes();
            }

            if (this.ticketEnteteVentes.getTicDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.ticketEnteteVentes.getTicDate().getSeconds();
            } else {
               this.var_seconde = "" + this.ticketEnteteVentes.getTicDate().getSeconds();
            }

            this.tiers = this.ticketEnteteVentes.getTiers();
            if (!this.ticketEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.ticketEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.ticketEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.ticketEnteteVentes.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            this.idTicket = this.ticketEnteteVentes.getTicId();
            this.var_nom_equipe = this.ticketEnteteVentes.getTicIdEquipe();
            this.var_nom_responsable = this.ticketEnteteVentes.getTicIdResponsable();
            this.var_nom_commercial = this.ticketEnteteVentes.getTicIdCommercial();
            this.chargerDocumentLigne(var4);
            this.chargerBonEncaissement(var4);
            this.cumulPrix();
            if (this.ticketEnteteVentes.getTicTotalTc() != 0.0D) {
               this.var_tc_calcul = true;
            } else {
               this.var_tc_calcul = false;
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.ticketEnteteVentes != null && this.ticketEnteteVentes.getTicEtat() == 0) {
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.ticketEnteteVentes.getTicId() > 0L) {
         this.lesLignesList = this.ticketLigneVentesDao.chargerLesLignes(this.ticketEnteteVentes, var1);
         if (this.lesLignesList.size() != 0) {
            for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
               this.ticketLigneVentes = (TicketLigneVentes)this.lesLignesList.get(var2);
               this.produits = this.produitsDao.chargeProduit(this.ticketLigneVentes.getTicligCode(), var1);
               if (this.produits != null) {
                  this.ticketLigneVentes.setPhoto(this.produits.getPhoto());
               }
            }
         }
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.reglementsDao.reglementDocument(this.ticketEnteteVentes.getTicId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.var_tot_bon_encaissement += ((Reglements)var2.get(var3)).getRglRecette();
         }
      }

      this.dataModelReglement.setWrappedData(var2);
   }

   public void gestionTicket() {
      this.reglements = new Reglements();
      this.ticketEnteteVentes = new TicketEnteteVentes();
      this.ticketLigneVentes = new TicketLigneVentes();
      this.var_date = new Date();
      this.lesLignesList.clear();
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_valide_doc = false;
      this.var_typeTiers = true;
      this.visibleOnglet = false;
   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException {
      this.reglements = new Reglements();
      this.ticketEnteteVentes = new TicketEnteteVentes();
      this.ticketLigneVentes = new TicketLigneVentes();
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
      this.ticketEnteteVentes.setTicIdCommercial(this.var_nom_commercial);
      this.ticketEnteteVentes.setTicNomCommercial(this.var_commercial);
      this.ticketEnteteVentes.setTicIdResponsable(this.var_nom_responsable);
      this.ticketEnteteVentes.setTicNomResponsable(this.var_responsable);
      this.ticketEnteteVentes.setTicIdEquipe(this.var_nom_equipe);
      this.ticketEnteteVentes.setTicNomEquipe(this.var_equipe);
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         String[] var1 = this.var_caisse.split(":");
         this.ticketEnteteVentes.setTicCaisse(var1[0]);
      } else {
         this.ticketEnteteVentes.setTicCaisse(this.var_caisse);
      }

      this.ticketEnteteVentes.setTicTauxTc(0.0F);
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_valide_doc = false;
      this.var_typeTiers = true;
      this.visibleOnglet = false;
      if (this.var_tc_type == 7) {
         this.var_tc_calcul = true;
      } else {
         this.var_tc_calcul = false;
      }

      this.idTicket = 0L;
      this.autorisationDocument();
      this.initPage();
      this.formRecherche.rechercheTiers(3, "*", this.nature, "Client divers");
      this.recuperationTiers();
   }

   public void saveFacture(int var1) throws IOException, HibernateException, NamingException, Exception {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BticketLigne");
      this.cumulPrix();
      Transaction var4 = null;

      String[] var6;
      try {
         var4 = var3.beginTransaction();
         this.ticketEnteteVentes.setTicEtat(var1);
         this.ticketEnteteVentes.setTicDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         this.ticketEnteteVentes.setUsers(this.usersLog);
         if (this.ticketEnteteVentes.getTicIdCommercial() == 0L) {
            this.ticketEnteteVentes.setTicIdCommercial(this.usersLog.getUsrid());
            this.ticketEnteteVentes.setTicNomCommercial(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         }

         String var5 = "";
         if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
            var6 = this.var_caisse.split(":");
            var5 = var6[0];
         } else {
            var5 = this.var_caisse;
         }

         this.ticketEnteteVentes.setTicCaisse(var5);
         if (this.var_anal_SitDepSer != 0) {
            this.ticketEnteteVentes.setTicSite(this.usersLog.getUsrSite());
            this.ticketEnteteVentes.setTicDepartement(this.usersLog.getUsrDepartement());
            this.ticketEnteteVentes.setTicService(this.usersLog.getUsrService());
         } else {
            this.ticketEnteteVentes.setTicSite("");
            this.ticketEnteteVentes.setTicDepartement("");
            this.ticketEnteteVentes.setTicService("");
         }

         this.ticketEnteteVentes.setTicTotalHt(this.montantHt);
         this.ticketEnteteVentes.setTicTotalTva(this.montantTaxe);
         this.ticketEnteteVentes.setTicTotalTtc(this.montantTtc);
         this.ticketEnteteVentes.setTicTotalTc(this.montantTc);
         if (this.ticketEnteteVentes.getTicId() == 0L) {
            this.ticketEnteteVentes.setExerciceventes(this.exercicesVentes);
            this.ticketEnteteVentes.setTicNum(this.calculChrono.numCompose(this.var_date, this.nature, "", var3));
            this.ticketEnteteVentes = this.ticketEnteteVentesDao.insert(this.ticketEnteteVentes, var3);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.ticketEnteteVentes = this.ticketEnteteVentesDao.modif(this.ticketEnteteVentes, var3);
         }

         var4.commit();
      } catch (HibernateException var20) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var20;
      } finally {
         var2 = true;
         this.utilInitHibernate.closeSession();
      }

      boolean var22 = false;
      if (var2) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BticketLigne");
         var6 = null;

         try {
            Transaction var23 = var3.beginTransaction();

            for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
               this.ticketLigneVentes = (TicketLigneVentes)this.lesLignesList.get(var7);
               if (this.var_depotProd != null) {
                  if (this.var_depotProd.contains(":")) {
                     String[] var8 = this.var_depotProd.split(":");
                     this.ticketLigneVentes.setTicligDepot(var8[0]);
                  } else {
                     this.ticketLigneVentes.setTicligDepot(this.var_depotProd);
                  }
               } else {
                  this.ticketLigneVentes.setTicligDepot("");
               }

               this.calculPrix(this.ticketLigneVentes.getTicligTaxe(), this.ticketLigneVentes.getTicligTauxTaxe(), var3);
               if (this.var_sansstock) {
                  this.ticketLigneVentes.setTicligStock(1);
               } else {
                  this.ticketLigneVentes.setTicligStock(0);
               }

               if (this.ticketLigneVentes.getTicligId() == 0L) {
                  this.ticketLigneVentes.setTicketEnteteVentes(this.ticketEnteteVentes);
                  this.ticketLigneVentes = this.ticketLigneVentesDao.insert(this.ticketLigneVentes, var3);
               } else {
                  this.ticketLigneVentes = this.ticketLigneVentesDao.modif(this.ticketLigneVentes, var3);
               }
            }

            if (this.optionsVentes.getCaisseStock().equals("1")) {
               this.calculStock.majTicketVentesVAL(this.lesLignesList, 1, this.baseLog, var3);
            }

            var23.commit();
         } catch (HibernateException var18) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var18;
         } finally {
            var22 = true;
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BticketLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      TaxesVentes var8;
      int var34;
      if (var1 != null && !var1.isEmpty()) {
         new TaxesVentes();
         var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
         if (var8 != null) {
            var5 = var8.getTaxvteTaux();
            var6 = var8.getTaxvteCode();
            var34 = var8.getTaxvteType();
         } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
            new TaxesVentes();
            TaxesVentes var9 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
            if (var9 != null) {
               var5 = var9.getTaxvteTaux();
               var6 = var9.getTaxvteCode();
               var34 = var9.getTaxvteType();
            } else {
               var5 = var2;
               var6 = var1;
               var34 = 0;
            }
         } else {
            var5 = var2;
            var6 = var1;
            var34 = 0;
         }
      } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
         new TaxesVentes();
         var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
         if (var8 != null) {
            var5 = var8.getTaxvteTaux();
            var6 = var8.getTaxvteCode();
            var34 = var8.getTaxvteType();
         } else {
            var5 = var2;
            var6 = var1;
            var34 = 0;
         }
      } else {
         var5 = var2;
         var6 = var1;
         var34 = 0;
      }

      if (this.produits != null && this.produits.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
         var5 = 0.0F;
         var6 = "";
         var34 = 0;
      }

      this.ticketLigneVentes.setTicligTaxe(var6);
      this.ticketLigneVentes.setTicligTauxTaxe(var5);
      double var35 = this.ticketLigneVentes.getTicligPu();
      if (this.ticketLigneVentes.getTicligQte() != 0.0F) {
         this.ticketLigneVentes.setTicligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, "", this.ticketLigneVentes.getTicligQte(), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, this.baseLog, this.utilInitHibernate, var3));
      } else {
         this.ticketLigneVentes.setTicligQteUtil(0.0F);
      }

      double var10 = 0.0D;
      var10 = var35 * (double)this.ticketLigneVentes.getTicligQte();
      double var12 = 0.0D;
      double var14 = 0.0D;
      if (this.ticketLigneVentes.getTicligTauxRemise() != 0.0F) {
         var12 = var10 - var10 * (double)this.ticketLigneVentes.getTicligTauxRemise() / 100.0D - var14;
      } else {
         var12 = var10 - var14;
      }

      double var16 = this.utilNombre.myRoundFormat(var12, this.structureLog.getStrformatdevise());
      double var18 = var16 * (double)this.ticketLigneVentes.getTicligTauxTaxe() / 100.0D;
      if (var34 == 2) {
         var18 *= -1.0D;
      }

      double var20 = this.utilNombre.myRoundFormat(var18, this.structureLog.getStrformatdevise());
      double var22 = var16 + var20;
      double var24 = 0.0D;
      var24 = this.utilNombre.myRound(var16 / (double)this.ticketLigneVentes.getTicligQte(), 2);
      this.ticketLigneVentes.setTicligPuRem(var24);
      this.ticketLigneVentes.setTicligPt(var16);
      this.ticketLigneVentes.setTicligTva(var20);
      this.ticketLigneVentes.setTicligTc(0.0D);
      this.ticketLigneVentes.setTicligTtc(var22);
      double var26 = 0.0D;
      var26 = this.utilNombre.myRound(var22 / (double)this.ticketLigneVentes.getTicligQteUtil(), 2);
      this.ticketLigneVentes.setTicligPuRemTtc(var26);
      double var28 = var35 + var35 * (double)this.ticketLigneVentes.getTicligTauxTaxe() / 100.0D;
      this.ticketLigneVentes.setTicligPuTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.ticketEnteteVentes.setTicTauxTc(this.var_tc_taux);
         double var30 = 0.0D;
         double var32 = 0.0D;
         if (this.var_tc_type == 6) {
            var30 = var22 * (double)this.ticketEnteteVentes.getTicTauxTc() / 100.0D;
            var32 = this.utilNombre.myRoundDevise(var30, this.structureLog.getStrdevise());
            this.ticketLigneVentes.setTicligTc(var32);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var30 = var16 * (double)this.ticketEnteteVentes.getTicTauxTc() / 100.0D;
               if (this.ticketLigneVentes.getTicligTauxTaxe() != 0.0F) {
                  var30 = var16 * (double)this.ticketEnteteVentes.getTicTauxTc() / 100.0D;
                  var32 = this.utilNombre.myRoundDevise(var30, this.structureLog.getStrdevise());
                  double var10000 = var30 + var30 * (double)this.ticketLigneVentes.getTicligTauxTaxe() / 100.0D;
                  this.ticketLigneVentes.setTicligTc(var32);
                  this.ticketLigneVentes.setTicligTtc(this.ticketLigneVentes.getTicligPt() + this.ticketLigneVentes.getTicligTva() + this.ticketLigneVentes.getTicligTc());
               }
            }
         } else {
            if (this.ticketLigneVentes.getTicligTva() != 0.0D) {
               var30 = var16 * (double)this.ticketEnteteVentes.getTicTauxTc() / 100.0D;
            } else {
               var30 = 0.0D;
            }

            var32 = this.utilNombre.myRoundDevise(var30, this.structureLog.getStrdevise());
            this.ticketLigneVentes.setTicligTc(var32);
            this.ticketLigneVentes.setTicligTtc(this.ticketLigneVentes.getTicligPt() + this.ticketLigneVentes.getTicligTva() + this.ticketLigneVentes.getTicligTc());
         }
      } else {
         this.ticketLigneVentes.setTicligTc(0.0D);
         this.ticketEnteteVentes.setTicTauxTc(0.0F);
      }

      this.ticketLigneVentes.setTicligPt(this.utilNombre.myRoundDevise(this.ticketLigneVentes.getTicligPt(), this.ticketEnteteVentes.getTicDevise()));
      this.ticketLigneVentes.setTicligTva(this.utilNombre.myRoundDevise(this.ticketLigneVentes.getTicligTva(), this.ticketEnteteVentes.getTicDevise()));
      this.ticketLigneVentes.setTicligTtc(this.utilNombre.myRoundDevise(this.ticketLigneVentes.getTicligTtc(), this.ticketEnteteVentes.getTicDevise()));
      this.ticketLigneVentes.setTicligTc(this.utilNombre.myRoundDevise(this.ticketLigneVentes.getTicligTc(), this.ticketEnteteVentes.getTicDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BticketLigne");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
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

      if (this.produits != null && this.produits.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
         var5 = 0.0F;
         var6 = "";
         var7 = false;
      }

      this.ticketLigneVentes.setTicligTaxe(var6);
      this.ticketLigneVentes.setTicligTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.ticketEnteteVentes.getTicTauxTc() != 0.0F && this.ticketLigneVentes.getTicligTva() != 0.0D) {
         var10 = this.ticketLigneVentes.getTicligTtc();
         var12 = var10 * (double)this.ticketEnteteVentes.getTicTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.ticketLigneVentes.getTicligQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.ticketLigneVentes.getTicligPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.ticketLigneVentes.setTicligPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      double var14 = 0.0D;
      if (this.ticketLigneVentes.getTicligTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.ticketLigneVentes.getTicligTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.ticketLigneVentes.getTicligTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.ticketLigneVentes.getTicligTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.ticketLigneVentes.getTicligQte() != 0.0F) {
         this.ticketLigneVentes.setTicligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, "", this.ticketLigneVentes.getTicligQte(), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, this.baseLog, this.utilInitHibernate, var3));
      } else {
         this.ticketLigneVentes.setTicligQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.ticketLigneVentes.getTicligQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var26 = var20 * (double)this.ticketLigneVentes.getTicligQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      this.ticketLigneVentes.setTicligPuRem(var18);
      this.ticketLigneVentes.setTicligPuRemTtc(var20);
      this.ticketLigneVentes.setTicligPt(var24);
      this.ticketLigneVentes.setTicligTva(var32);
      this.ticketLigneVentes.setTicligTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.ticketEnteteVentes.setTicTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.ticketEnteteVentes.getTicTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundDevise(var34, this.structureLog.getStrdevise());
            this.ticketLigneVentes.setTicligTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.ticketEnteteVentes.getTicTauxTc() / 100.0D;
               if (this.ticketLigneVentes.getTicligTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.ticketEnteteVentes.getTicTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundDevise(var34, this.structureLog.getStrdevise());
                  double var10000 = var34 + var34 * (double)this.ticketLigneVentes.getTicligTauxTaxe() / 100.0D;
                  this.ticketLigneVentes.setTicligTc(var36);
                  this.ticketLigneVentes.setTicligTtc(this.ticketLigneVentes.getTicligPt() + this.ticketLigneVentes.getTicligTva() + this.ticketLigneVentes.getTicligTc());
               }
            }
         } else {
            if (this.ticketLigneVentes.getTicligTva() != 0.0D) {
               var34 = var24 * (double)this.ticketEnteteVentes.getTicTauxTc() / 100.0D;
            } else {
               var34 = 0.0D;
            }

            var36 = this.utilNombre.myRoundDevise(var34, this.structureLog.getStrdevise());
            this.ticketLigneVentes.setTicligTc(var36);
            this.ticketLigneVentes.setTicligTtc(this.ticketLigneVentes.getTicligPt() + this.ticketLigneVentes.getTicligTva() + this.ticketLigneVentes.getTicligTc());
         }
      } else {
         this.ticketLigneVentes.setTicligTc(0.0D);
         this.ticketEnteteVentes.setTicTauxTc(0.0F);
      }

      this.ticketLigneVentes.setTicligPt(this.utilNombre.myRoundDevise(this.ticketLigneVentes.getTicligPt(), this.ticketEnteteVentes.getTicDevise()));
      this.ticketLigneVentes.setTicligTva(this.utilNombre.myRoundDevise(this.ticketLigneVentes.getTicligTva(), this.ticketEnteteVentes.getTicDevise()));
      this.ticketLigneVentes.setTicligTtc(this.utilNombre.myRoundDevise(this.ticketLigneVentes.getTicligTtc(), this.ticketEnteteVentes.getTicDevise()));
      this.ticketLigneVentes.setTicligTc(this.utilNombre.myRoundDevise(this.ticketLigneVentes.getTicligTc(), this.ticketEnteteVentes.getTicDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
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
      this.montantHt = 0.0D;
      this.montantTaxe = 0.0D;
      this.montantTtc = 0.0D;
      this.montantTc = 0.0D;
      this.montant_timbre = 0.0D;
      double var1 = 0.0D;
      new TicketLigneVentes();

      for(int var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
         TicketLigneVentes var3 = (TicketLigneVentes)this.lesLignesList.get(var4);
         this.montantHt += var3.getTicligPt();
         this.montantTaxe += var3.getTicligTva();
         this.montantTtc += var3.getTicligTtc();
         this.montantTc += var3.getTicligTc();
         if (var3.getTicligTauxRemise() != 0.0F) {
            var1 += var3.getTicligPu() * (double)var3.getTicligQte() - var3.getTicligPt();
         }
      }

   }

   public void recuperationTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.tiers = this.formRecherche.calculeTiers();
      this.calculeTiers();
   }

   public void calculeTiers() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.tiers != null) {
         this.ticketEnteteVentes.setTiers(this.tiers);
         String var1 = "";
         if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
            var1 = this.tiers.getTieraisonsocialenom();
            this.ticketEnteteVentes.setTicCivilTiers("");
            this.var_typeTiers = true;
         } else {
            if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
               var1 = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
            } else {
               var1 = this.tiers.getTieraisonsocialenom();
            }

            this.ticketEnteteVentes.setTicCivilTiers(this.ticketEnteteVentes.getTiers().getTiecivilite());
            this.var_typeTiers = false;
         }

         this.ticketEnteteVentes.setTicNomTiers(var1);
         if (this.tiers.getTienomfamille() != null && !this.tiers.getTienomfamille().isEmpty()) {
            this.ticketEnteteVentes.setTicCat(this.tiers.getTienomfamille());
         } else if (this.lesFamilleClientsListe.size() != 0) {
            this.ticketEnteteVentes.setTicCat(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(0)).getLibelle());
         }

         this.ticketEnteteVentes.setTicTelephne(this.tiers.getTiecel1());
         this.ticketEnteteVentes.setTicMail(this.tiers.getTiemail1());
         this.ticketEnteteVentes.setTicTypeReg(this.tiers.getTietypereg());
         this.ticketEnteteVentes.setTicModeReg(this.tiers.getTiemodereg());
         String var2 = "";
         if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
            String[] var3 = this.tiers.getTiemodereg().split(":");
            var2 = var3[0];
         } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
            var2 = this.tiers.getTiemodereg();
         }

         if (!var2.equals("") && !var2.equals("100")) {
            this.ticketEnteteVentes.setTicNbJourReg(this.tiers.getTienbecheance());
            this.ticketEnteteVentes.setTicArrondiReg(this.tiers.getTienbarrondi());
         } else {
            for(int var7 = 0; var7 < this.lesModeReglementClientsListe.size(); ++var7) {
               new ObjetReglement();
               ObjetReglement var4 = (ObjetReglement)this.lesModeReglementClientsListe.get(var7);
               if (var4.getDefaut().equals("true")) {
                  if (var4.getEcheances() == null || var4.getEcheances().isEmpty()) {
                     var4.setEcheances("0");
                  }

                  this.ticketEnteteVentes.setTicTypeReg(Integer.parseInt(var4.getEcheances()));
                  this.ticketEnteteVentes.setTicModeReg(var4.getCategories() + ":" + var4.getLibelles());
                  int var5 = 0;
                  if (var4.getNbjours() != null && !var4.getNbjours().isEmpty()) {
                     var5 = Integer.parseInt(var4.getNbjours());
                  }

                  this.ticketEnteteVentes.setTicNbJourReg(var5);
                  int var6 = 0;
                  if (var4.getArrondis() != null && !var4.getArrondis().isEmpty()) {
                     var6 = Integer.parseInt(var4.getArrondis());
                  }

                  this.ticketEnteteVentes.setTicArrondiReg(var6);
                  break;
               }
            }
         }
      } else {
         this.annuleTiers();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.ticketEnteteVentes.setTiers(this.tiers);
      this.ticketEnteteVentes.setTicNomTiers("");
      this.ticketEnteteVentes.setTicCivilTiers("");
      this.var_action = this.var_memo_action;
   }

   public void calculeProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         if (this.var_memo_action == 1) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BticketLigne");
            this.ticketLigneVentes.setTicligCode(this.produits.getProCode());
            String var2;
            String var3;
            if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
               if (this.optionsVentes.getLibelleProduit().equals("0")) {
                  this.ticketLigneVentes.setTicligLibelle(this.produits.getProLibTech().toUpperCase());
               } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
                  var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
                  var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
                  this.ticketLigneVentes.setTicligLibelle(var2 + var3);
               } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
                  this.ticketLigneVentes.setTicligLibelle(this.produits.getProLibTech().toLowerCase());
               }
            } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.ticketLigneVentes.setTicligLibelle(this.produits.getProLibClient().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
               this.ticketLigneVentes.setTicligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.ticketLigneVentes.setTicligLibelle(this.produits.getProLibClient().toLowerCase());
            }

            this.ticketLigneVentes.setTicligFamille(this.produits.getProVteCode());
            this.ticketLigneVentes.setTicligStock(this.produits.getProStock());
            if (this.var_anal_activite) {
               this.ticketLigneVentes.setTicligActivite(this.produits.getProActivite());
            } else {
               this.ticketLigneVentes.setTicligActivite("");
            }

            new FamillesProduitsVentes();
            FamillesProduitsVentes var8 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExoVentes.getExevteId(), this.produits, var1);
            if (!this.produits.isProExoTva() && (this.tiers.getTiepProdExoTva() == null || this.tiers.getTiepProdExoTva().isEmpty() || !this.tiers.getTiepProdExoTva().contains(this.produits.getProCode()))) {
               TaxesVentes var9;
               if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty() && !this.produits.getProVteTva().equals("0")) {
                  new TaxesVentes();
                  var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.produits.getProVteTva(), var1);
                  if (var9 != null) {
                     this.ticketLigneVentes.setTicligTaxe(this.produits.getProVteTva());
                     this.ticketLigneVentes.setTicligTauxTaxe(var9.getTaxvteTaux());
                  } else {
                     this.ticketLigneVentes.setTicligTaxe("");
                     this.ticketLigneVentes.setTicligTauxTaxe(0.0F);
                  }
               } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
                  new TaxesVentes();
                  var9 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var8.getFamvteTaxe(), var1);
                  if (var9 != null) {
                     this.ticketLigneVentes.setTicligTaxe(var8.getFamvteTaxe());
                     this.ticketLigneVentes.setTicligTauxTaxe(var9.getTaxvteTaux());
                  }
               } else {
                  this.ticketLigneVentes.setTicligTaxe("");
                  this.ticketLigneVentes.setTicligTauxTaxe(0.0F);
               }
            } else {
               this.ticketLigneVentes.setTicligTaxe("");
               this.ticketLigneVentes.setTicligTauxTaxe(0.0F);
            }

            this.selectionDepot(var1);
            if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
               float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
               if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                  double var4 = this.produitsDepot.getProdepPr() / (double)var10;
                  double var10000 = var4 + var4 * (double)this.ticketLigneVentes.getTicligTauxTaxe() / 100.0D;
               }
            }

            this.prixUnitaireCorrespond(var1);
            this.calculPrix(this.ticketLigneVentes.getTicligTaxe(), this.ticketLigneVentes.getTicligTauxTaxe(), var1);
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.annuleProduits();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDetailProduit() {
      this.var_action = this.var_memo_action;
   }

   public void calculTva() {
      if (this.ticketLigneVentes.getTicligCode() != null && !this.ticketLigneVentes.getTicligCode().isEmpty() && this.ticketLigneVentes.getTicligCode().length() >= 2) {
      }

   }

   public void annuleProduits() {
      this.produits = null;
      if (this.var_memo_action == 1) {
         this.ticketLigneVentes.setTicligCode("");
         this.ticketLigneVentes.setTicligLibelle("");
      }

      this.griserValider = false;
      this.var_action = this.var_memo_action;
   }

   public void prixUnitaireCorrespond(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         this.prixUnitaires = 0.0D;
         new ArrayList();
         List var2 = this.produitsTarifDao.selectProdTarifByprod(this.produits, var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               if (((ProduitsTarif)var2.get(var3)).getProtarClient().equals(this.tiers.getTiecategorie())) {
                  this.prixUnitaires = ((ProduitsTarif)var2.get(var3)).getProtarPv();
                  break;
               }
            }

            if (this.prixUnitaires == 0.0D) {
               this.prixUnitaires = ((ProduitsTarif)var2.get(0)).getProtarPv();
            }
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.ticketLigneVentes.setTicligPuTtc(this.prixUnitaires);
         } else {
            this.ticketLigneVentes.setTicligPu(this.prixUnitaires);
         }

         if (this.verifBareme) {
            new Baremes();
            new ArrayList();
            List var4 = this.baremesDao.rechercheToutBaremeProduit(this.tiers.getTieid(), this.produits.getProCode(), this.produits.getProVteCode(), this.tiers.getTienomfamille(), var1);
            if (var4.size() != 0) {
               int var5;
               Baremes var8;
               for(var5 = 0; var5 < var4.size(); ++var5) {
                  var8 = (Baremes)var4.get(var5);
                  if ((var8.getBarDateDebut() == null && var8.getBarDateFin() == null || var8.getBarDateDebut() != null && this.var_date.compareTo(var8.getBarDateDebut()) >= 0 && var8.getBarDateFin() != null && this.var_date.compareTo(var8.getBarDateFin()) <= 0) && var8.getBarPrix() != 0.0D) {
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.ticketLigneVentes.setTicligPuTtc(var8.getBarPrix());
                     } else {
                        this.ticketLigneVentes.setTicligPu(var8.getBarPrix());
                     }

                     this.prixUnitaires = var8.getBarPrix();
                  }
               }

               for(var5 = 0; var5 < var4.size(); ++var5) {
                  var8 = (Baremes)var4.get(var5);
                  if ((var8.getBarDateDebut() == null && var8.getBarDateFin() == null || var8.getBarDateDebut() != null && this.var_date.compareTo(var8.getBarDateDebut()) >= 0 && var8.getBarDateFin() != null && this.var_date.compareTo(var8.getBarDateFin()) <= 0) && var8.getBarRemise() != 0.0F) {
                     this.ticketLigneVentes.setTicligTauxRemise(var8.getBarRemise());
                     double var6 = 0.0D;
                     var6 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var8.getBarRemise() / 100.0D, this.ticketEnteteVentes.getTicDevise());
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.ticketLigneVentes.setTicligPuTtc(this.prixUnitaires);
                        this.ticketLigneVentes.setTicligPuRemTtc(var6);
                     } else {
                        this.ticketLigneVentes.setTicligPu(this.prixUnitaires);
                        this.ticketLigneVentes.setTicligPuRem(var6);
                     }
                  }
               }
            }
         }
      }

   }

   public void selectionDepot() throws HibernateException, NamingException {
      this.selectionDepot((Session)null);
   }

   public void selectionDepot(Session var1) throws HibernateException, NamingException {
      if (this.produits != null && this.var_depotProd != null && !this.var_depotProd.isEmpty() && this.var_depotProd.contains(":")) {
         String[] var2 = this.var_depotProd.split(":");
         this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.produits.getProCode(), var2[0], var1);
         if (this.produitsDepot == null) {
            this.produitsDepot = null;
            this.var_depotProd = "";
         }
      } else {
         this.produitsDepot = null;
         this.var_depotProd = "";
      }

      if (this.produitsDepot != null) {
         this.ticketLigneVentes.setTicligPump(this.produitsDepot.getProdepPump());
      } else {
         this.ticketLigneVentes.setTicligPump(0.0D);
      }

   }

   public void ajouterTicket() throws IOException, JDOMException, HibernateException, NamingException {
      this.ajoutDocument();
      this.typeBouton = 1;
   }

   public void selectionClient() throws HibernateException, NamingException {
      this.clientPaveLettre();
      this.typeBouton = 2;
   }

   public void selectionLivreur() throws HibernateException, NamingException {
      this.lesLivreurs.clear();
      this.lesLivreurs = this.userDao.chargerLesLivreur((Session)null);
      this.dataModelLivreurs.setWrappedData(this.lesLivreurs);
      this.typeBouton = 5;
   }

   public void choixLivreur() {
      if (this.dataModelLivreurs.isRowAvailable()) {
         new Users();
         Users var1 = (Users)this.dataModelLivreurs.getRowData();
         this.ticketEnteteVentes.setTicIdLivreur(var1.getUsrid());
         this.ticketEnteteVentes.setTicNomLivreur(var1.getUsrPatronyme());
      }

      this.typeBouton = 1;
   }

   public void annuleLivreur() {
      this.typeBouton = 1;
   }

   public void selectionTable() {
      this.typeBouton = 6;
   }

   public void selectionChambre() {
      this.typeBouton = 7;
   }

   public void selectionProduit() throws HibernateException, NamingException {
      this.lesFamilles.clear();
      this.lesFamilles = this.famillesProduitsVentesDao.selectAllFamillUtil(this.exercicesVentes.getExevteId(), (Session)null);
      this.dataModelFamilleProduit.setWrappedData(this.lesFamilles);
      this.lesProduits.clear();
      this.dataModelProduits.setWrappedData(this.lesProduits);
      this.typeBouton = 3;
   }

   public void listeProduits() throws HibernateException, NamingException {
      if (this.dataModelFamilleProduit.isRowAvailable()) {
         this.famillesProduitsVentes = (FamillesProduitsVentes)this.dataModelFamilleProduit.getRowData();
         this.lesProduits = this.produitsDao.chargerLesProduitsVentesByFamille(this.famillesProduitsVentes.getFamvteCode(), (Session)null);
         this.dataModelProduits.setWrappedData(this.lesProduits);
      }

   }

   public void choixProduit() throws HibernateException, NamingException {
      if (this.dataModelProduits.isRowAvailable()) {
         this.produits = (Produits)this.dataModelProduits.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         this.ticketLigneVentes = new TicketLigneVentes();
         this.ticketLigneVentes.setTicligCode(this.produits.getProCode());
         this.ticketLigneVentes.setPhoto(this.produits.getPhoto());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.ticketLigneVentes.setTicligLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.ticketLigneVentes.setTicligLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.ticketLigneVentes.setTicligLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.ticketLigneVentes.setTicligLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.ticketLigneVentes.setTicligLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.ticketLigneVentes.setTicligLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.ticketLigneVentes.setTicligFamille(this.produits.getProVteCode());
         this.ticketLigneVentes.setTicligStock(this.produits.getProStock());
         this.ticketLigneVentes.setTicligPoidsBrut(this.produits.getProPoidsBrut());
         this.ticketLigneVentes.setTicligPoidsNet(this.produits.getProPoidsNet());
         if (this.var_anal_activite) {
            this.ticketLigneVentes.setTicligActivite(this.produits.getProActivite());
         } else {
            this.ticketLigneVentes.setTicligActivite("");
         }

         this.ticketLigneVentes.setTicligQte(1.0F);
         new FamillesProduitsVentes();
         FamillesProduitsVentes var4 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExoVentes.getExevteId(), this.produits, var1);
         TaxesVentes var5;
         if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty() && !this.produits.getProVteTva().equals("0")) {
            new TaxesVentes();
            var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.produits.getProVteTva(), var1);
            if (var5 != null) {
               this.ticketLigneVentes.setTicligTaxe(this.produits.getProVteTva());
               this.ticketLigneVentes.setTicligTauxTaxe(var5.getTaxvteTaux());
            } else {
               this.ticketLigneVentes.setTicligTaxe("");
               this.ticketLigneVentes.setTicligTauxTaxe(0.0F);
            }
         } else if (var4 != null && var4.getFamvteTaxe() != null && !var4.getFamvteTaxe().isEmpty() && !var4.getFamvteTaxe().equals("0")) {
            new TaxesVentes();
            var5 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var4.getFamvteTaxe(), var1);
            if (var5 != null) {
               this.ticketLigneVentes.setTicligTaxe(var4.getFamvteTaxe());
               this.ticketLigneVentes.setTicligTauxTaxe(var5.getTaxvteTaux());
            }
         } else {
            this.ticketLigneVentes.setTicligTaxe("");
            this.ticketLigneVentes.setTicligTauxTaxe(0.0F);
         }

         if (this.optionsVentes.getCaisseStock().equals("1")) {
            this.selectionDepot(var1);
         } else {
            this.ticketLigneVentes.setTicligPump(0.0D);
            this.ticketLigneVentes.setTicligDepot("");
         }

         this.prixUnitaireCorrespond(var1);
         this.calculPrix(this.ticketLigneVentes.getTicligTaxe(), this.ticketLigneVentes.getTicligTauxTaxe(), var1);
         this.utilInitHibernate.closeSession();
         this.lesLignesList.add(this.ticketLigneVentes);
         this.datamodelLigne.setWrappedData(this.lesLignesList);
         this.calculeTotalTicket();
         this.typeBouton = 1;
      }

   }

   public void selectionLigneDetail() {
      if (this.datamodelLigne.isRowAvailable()) {
         this.ticketLigneVentes = (TicketLigneVentes)this.datamodelLigne.getRowData();
      }

   }

   public void selectionMiseAttente() throws IOException, HibernateException, NamingException, Exception {
      if (this.ticketEnteteVentes != null && this.ticketEnteteVentes.getTicTotalTtc() != 0.0D) {
         this.saveFacture(1);
         this.annulationTicket();
      }

   }

   public void selectionRepriseAttente() throws HibernateException, NamingException {
      this.lesEnteteList.clear();
      String var1 = "";
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         String[] var2 = this.var_caisse.split(":");
         var1 = var2[0];
      } else {
         var1 = this.var_caisse;
      }

      String var4 = "";
      String var3 = "";
      var4 = this.utilDate.dateToStringSQLLight(new Date()) + " 00:00:00";
      var3 = this.utilDate.dateToStringSQLLight(new Date()) + " 23:59:59";
      this.lesEnteteList = this.ticketEnteteVentesDao.chargerLesTicketsEnAttente(var4, var3, var1, (Session)null);
      this.dataModelTicket.setWrappedData(this.lesEnteteList);
      this.typeBouton = 9;
   }

   public void selectionRepriseLivre() throws HibernateException, NamingException {
      this.lesEnteteList.clear();
      String var1 = "";
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         String[] var2 = this.var_caisse.split(":");
         var1 = var2[0];
      } else {
         var1 = this.var_caisse;
      }

      String var4 = "";
      String var3 = "";
      var4 = this.utilDate.dateToStringSQLLight(new Date()) + " 00:00:00";
      var3 = this.utilDate.dateToStringSQLLight(new Date()) + " 23:59:59";
      this.lesEnteteList = this.ticketEnteteVentesDao.chargerLesTicketsLivre(var4, var3, var1, (Session)null);
      this.dataModelTicket.setWrappedData(this.lesEnteteList);
      this.typeBouton = 9;
   }

   public void annuleReprise() {
      if (this.lesEnteteList.size() == 0) {
         this.annulationTicket();
      } else {
         this.typeBouton = 1;
      }

   }

   public void choixTicket() throws JDOMException, IOException, HibernateException, NamingException {
      this.selectionTicket();
      this.typeBouton = 1;
   }

   public void selectionTicketLivre() throws IOException, HibernateException, NamingException, Exception {
      if (this.ticketEnteteVentes != null && this.ticketEnteteVentes.getTicTotalTtc() != 0.0D) {
         this.saveFacture(2);
         this.annulationTicket();
      }

   }

   public void selectionRemise() {
      this.typeBouton = 11;
   }

   public void annulationTicket() {
      this.reglements = new Reglements();
      this.ticketEnteteVentes = new TicketEnteteVentes();
      this.ticketLigneVentes = new TicketLigneVentes();
      this.var_date = new Date();
      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.var_valide_doc = false;
      this.var_typeTiers = true;
      this.visibleOnglet = false;
      this.typeBouton = 0;
   }

   public void selectionEncaissement() throws IOException, HibernateException, NamingException, Exception {
      if (this.ticketEnteteVentes != null && this.ticketEnteteVentes.getTicTotalTtc() != 0.0D) {
         this.saveFacture(0);
         this.montantEncaisse = 0.0D;
         this.montantRendu = 0.0D;
         this.lesReglements.clear();
         if (this.lesModeReglementClientsListe.size() != 0) {
            for(int var1 = 0; var1 < this.lesModeReglementClientsListe.size(); ++var1) {
               this.reglements = new Reglements();
               this.reglements.setRglActivite(this.ticketLigneVentes.getTicligActivite());
               String var2 = "";
               String var3 = "";
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                  String[] var4 = this.var_caisse.split(":");
                  var2 = var4[0];
                  var3 = var4[1];
               } else {
                  var2 = this.var_caisse;
               }

               this.reglements.setRglCodeCaiss(var2);
               this.reglements.setRglLibCaiss(var3);
               this.reglements.setRglCategorie(20);
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateEncaissement(new Date());
               this.reglements.setRglDepartement(this.ticketEnteteVentes.getTicDepartement());
               this.reglements.setRglDevise(this.ticketEnteteVentes.getTicDevise());
               this.reglements.setRglDepense(0.0D);
               this.reglements.setRglDocument(this.ticketEnteteVentes.getTicNum());
               this.reglements.setRglFormatDevise(this.calculformatDevise(this.ticketEnteteVentes.getTicDevise()));
               this.reglements.setRglIdCommercial(this.ticketEnteteVentes.getTicIdCommercial());
               this.reglements.setRglIdCaissier(this.ticketEnteteVentes.getTicIdCommercial());
               this.reglements.setRglIdEquipe(this.ticketEnteteVentes.getTicIdEquipe());
               this.reglements.setRglIdResponsable(this.ticketEnteteVentes.getTicIdResponsable());
               this.reglements.setRglIdDocument(this.ticketEnteteVentes.getTicId());
               this.reglements.setRglIdTiers(this.ticketEnteteVentes.getTiers().getTieid());
               this.reglements.setRglLibelle("Vente comptoir");
               this.reglements.setRglLibTypReg(((ObjetReglement)this.lesModeReglementClientsListe.get(var1)).getLibelles());
               this.reglements.setRglMode(((ObjetReglement)this.lesModeReglementClientsListe.get(var1)).getCategories());
               this.reglements.setRglNatureDoc(6);
               this.reglements.setRglNomCaissier(this.ticketEnteteVentes.getTicNomCommercial());
               this.reglements.setRglNomCommercial(this.ticketEnteteVentes.getTicNomCommercial());
               this.reglements.setRglNomEquipe(this.ticketEnteteVentes.getTicNomEquipe());
               this.reglements.setRglNomResponsable(this.ticketEnteteVentes.getTicNomResponsable());
               this.reglements.setRglNomTiers(this.ticketEnteteVentes.getTicNomTiers());
               this.reglements.setRglObjet("Vente comptoir");
               this.reglements.setRglOperation("07");
               this.reglements.setRglRecette(0.0D);
               this.reglements.setRglService(this.ticketEnteteVentes.getTicService());
               this.reglements.setRglSite(this.ticketEnteteVentes.getTicSite());
               this.reglements.setRglSerie("");
               this.reglements.setRglTypeReg(Integer.parseInt(((ObjetReglement)this.lesModeReglementClientsListe.get(var1)).getCategories()));
               this.reglements.setRglTypeTiers(0);
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setExercicesCaisse(this.exercicesCaisse);
               this.lesReglements.add(this.reglements);
            }
         }

         this.dataModelReglement.setWrappedData(this.lesReglements);
         this.griserValider = true;
         this.typeBouton = 13;
      }

   }

   public void annuleEncaissement() throws IOException, HibernateException, NamingException, Exception {
      if (this.ticketEnteteVentes != null) {
         this.saveFacture(1);
      }

      this.idTicket = 0L;
      this.typeBouton = 1;
   }

   public void valideEncaissement() throws IOException, HibernateException, NamingException, Exception {
      if (this.ticketEnteteVentes != null) {
         boolean var1 = false;
         double var2 = 0.0D;
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BticketLigne");
         Transaction var5 = null;

         try {
            var5 = var4.beginTransaction();
            if (this.lesReglements.size() != 0) {
               String var6 = "";
               String var7 = "";
               String var8 = "" + this.varTypeReg;
               if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
                  String var9 = "";
                  if (this.var_caisse.contains(";")) {
                     String[] var10 = this.var_caisse.split(";");
                     var9 = var10[0];
                  }

                  if (var9 != null && !var9.isEmpty()) {
                     var7 = this.calculChrono.numComposeCaisse(new Date(), 61, var8, var6, var9, var4);
                  } else {
                     var7 = this.calculChrono.numCompose(new Date(), 61, var8, var6, var4);
                  }
               } else {
                  var7 = this.calculChrono.numCompose(new Date(), 61, var6, var4);
               }

               for(int var18 = 0; var18 < this.lesReglements.size(); ++var18) {
                  this.reglements = (Reglements)this.lesReglements.get(var18);
                  if (this.reglements.getRglRecette() != 0.0D) {
                     this.reglements.setRglDateReg(this.var_date);
                     String var19 = "";
                     if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                        var19 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                     } else {
                        var19 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                     }

                     String var11 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                     this.reglements.setRglPeriode(var19 + ":" + var11);
                     this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                     String var12 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                     this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var12);
                     this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                     this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var12);
                     var2 += this.reglements.getRglRecette();
                     if (this.reglements.getRglId() == 0L) {
                        this.reglements.setRglNum(var7);
                        this.reglements = this.reglementsDao.insert(this.reglements, var4);
                     } else {
                        this.reglements = this.reglementsDao.modifierReg(this.reglements, var4);
                     }
                  }
               }
            }

            this.ticketEnteteVentes.setTicEtat(3);
            this.ticketEnteteVentes.setTicTotalReglement(var2);
            this.ticketEnteteVentes = this.ticketEnteteVentesDao.modif(this.ticketEnteteVentes, var4);
            this.idTicket = this.ticketEnteteVentes.getTicId();
            var5.commit();
         } catch (HibernateException var16) {
            if (var5 != null) {
               var5.rollback();
            }

            throw var16;
         } finally {
            var1 = true;
            this.utilInitHibernate.closeSession();
         }

         if (var1) {
            this.typeBouton = 1;
            this.initReImpression();
         }
      }

      this.annulationTicket();
      this.typeBouton = 0;
   }

   public void annuleProduit() {
      this.typeBouton = 1;
   }

   public void annulationligne() {
      if (this.lesLignesList.size() != 0 && this.ticketLigneVentes != null) {
         this.lesLignesList.remove(this.ticketLigneVentes);
         this.datamodelLigne.setWrappedData(this.lesLignesList);
         this.calculeTotalTicket();
      }

   }

   public void qtePaveNumerique() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.ticketLigneVentes = (TicketLigneVentes)this.datamodelLigne.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         this.produits = this.produitsDao.chargeProduit(this.ticketLigneVentes.getTicligCode(), var1);
         this.utilInitHibernate.closeSession();
         this.lettreSaisie = "" + this.ticketLigneVentes.getTicligQte();
         this.typePaveNumerique = 0;
         this.libellePaveNumerique = "Saisir Quantité";
         this.pointDecimal = false;
         this.showModalPaveNumerique = true;
      }

   }

   public void remisePaveNumerique() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.ticketLigneVentes = (TicketLigneVentes)this.datamodelLigne.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         this.produits = this.produitsDao.chargeProduit(this.ticketLigneVentes.getTicligCode(), var1);
         this.utilInitHibernate.closeSession();
         this.lettreSaisie = "" + this.ticketLigneVentes.getTicligTauxRemise();
         this.typePaveNumerique = 1;
         this.libellePaveNumerique = "Saisir Taux Remise";
         this.pointDecimal = false;
         this.showModalPaveNumerique = true;
      }

   }

   public void prixUnitairePaveNumerique() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.ticketLigneVentes = (TicketLigneVentes)this.datamodelLigne.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         this.produits = this.produitsDao.chargeProduit(this.ticketLigneVentes.getTicligCode(), var1);
         this.utilInitHibernate.closeSession();
         this.lettreSaisie = "" + this.ticketLigneVentes.getTicligPuTtc();
         this.typePaveNumerique = 7;
         this.libellePaveNumerique = "Saisir Prix Unitaire";
         this.pointDecimal = false;
         this.showModalPaveNumerique = true;
      }

   }

   public void reglementPaveNumerique() throws HibernateException, NamingException {
      if (this.dataModelReglement.isRowAvailable()) {
         this.reglements = (Reglements)this.dataModelReglement.getRowData();
         this.typePaveNumerique = 5;
         this.libellePaveNumerique = "Saisir Montant à payer";
         if (this.reglements.getRglRecette() != 0.0D) {
            this.lettreSaisie = "" + this.reglements.getRglRecette();
         } else {
            double var1 = 0.0D;

            for(int var3 = 0; var3 < this.lesReglements.size(); ++var3) {
               var1 += ((Reglements)this.lesReglements.get(var3)).getRglRecette();
            }

            this.lettreSaisie = "" + (this.ticketEnteteVentes.getTicTotalTtc() - var1);
         }

         this.pointDecimal = false;
         this.showModalPaveNumerique = true;
      }

   }

   public void fidelitePaveNumerique() throws HibernateException, NamingException {
      if (this.dataModelReglement.isRowAvailable()) {
         this.reglements = (Reglements)this.dataModelReglement.getRowData();
         this.typePaveNumerique = 6;
         this.libellePaveNumerique = "Saisir Carte Fidélité ";
         this.lettreSaisie = this.ticketEnteteVentes.getTicFidele();
         this.pointDecimal = false;
         this.showModalPaveNumerique = true;
      }

   }

   public void fermerPaveNumerique() {
      this.showModalPaveNumerique = false;
   }

   public void validePaveNumerique() throws HibernateException, NamingException {
      float var1;
      Session var2;
      if (this.typePaveNumerique == 0) {
         var1 = Float.parseFloat(this.lettreSaisie);
         this.ticketLigneVentes.setTicligQte(var1);
         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         this.calculPrix(this.ticketLigneVentes.getTicligTaxe(), this.ticketLigneVentes.getTicligTauxTaxe(), var2);
         this.utilInitHibernate.closeSession();
         this.calculeTotalTicket();
      } else if (this.typePaveNumerique == 1) {
         var1 = Float.parseFloat(this.lettreSaisie);
         this.ticketLigneVentes.setTicligTauxRemise(var1);
         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         this.calculPrix(this.ticketLigneVentes.getTicligTaxe(), this.ticketLigneVentes.getTicligTauxTaxe(), var2);
         this.utilInitHibernate.closeSession();
         this.calculeTotalTicket();
      } else {
         double var6;
         if (this.typePaveNumerique == 5) {
            var6 = Double.parseDouble(this.lettreSaisie);
            this.reglements.setRglRecette(var6);
            double var3 = 0.0D;

            for(int var5 = 0; var5 < this.lesReglements.size(); ++var5) {
               var3 += ((Reglements)this.lesReglements.get(var5)).getRglRecette();
            }

            if (var3 != this.ticketEnteteVentes.getTicTotalTtc()) {
               this.griserValider = true;
            } else {
               this.griserValider = false;
            }
         } else if (this.typePaveNumerique == 6) {
            this.ticketEnteteVentes.setTicFidele(this.lettreSaisie);
         } else if (this.typePaveNumerique == 7) {
            var6 = Double.parseDouble(this.lettreSaisie);
            this.ticketLigneVentes.setTicligPuTtc(var6);
            Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
            this.calculPrix(this.ticketLigneVentes.getTicligTaxe(), this.ticketLigneVentes.getTicligTauxTaxe(), var8);
            this.utilInitHibernate.closeSession();
            this.calculeTotalTicket();
         } else if (this.typePaveNumerique != 8 && this.typePaveNumerique != 9) {
            if (this.typePaveNumerique == 10) {
               this.montantEncaisse = Double.parseDouble(this.lettreSaisie);
               var6 = 0.0D;

               for(int var9 = 0; var9 < this.lesReglements.size(); ++var9) {
                  if (((Reglements)this.lesReglements.get(var9)).getRglTypeReg() == 0) {
                     var6 += ((Reglements)this.lesReglements.get(var9)).getRglRecette();
                  }
               }

               this.montantRendu = this.montantEncaisse - var6;
            }
         } else {
            int var7 = Integer.parseInt(this.lettreSaisie);
            if (this.choixClick == 1) {
               this.nbP1 = var7;
            } else if (this.choixClick == 2) {
               this.nbP2 = var7;
            } else if (this.choixClick == 3) {
               this.nbP3 = var7;
            } else if (this.choixClick == 4) {
               this.nbP4 = var7;
            } else if (this.choixClick == 5) {
               this.nbP5 = var7;
            } else if (this.choixClick == 6) {
               this.nbP6 = var7;
            } else if (this.choixClick == 7) {
               this.nbP7 = var7;
            } else if (this.choixClick == 8) {
               this.nbP8 = var7;
            } else if (this.choixClick == 9) {
               this.nbP9 = var7;
            } else if (this.choixClick == 10) {
               this.nbP10 = var7;
            } else if (this.choixClick == 21) {
               this.nbB1 = var7;
            } else if (this.choixClick == 22) {
               this.nbB2 = var7;
            } else if (this.choixClick == 23) {
               this.nbB3 = var7;
            } else if (this.choixClick == 24) {
               this.nbB4 = var7;
            } else if (this.choixClick == 25) {
               this.nbB5 = var7;
            } else if (this.choixClick == 26) {
               this.nbB6 = var7;
            } else if (this.choixClick == 27) {
               this.nbB7 = var7;
            } else if (this.choixClick == 28) {
               this.nbB8 = var7;
            } else if (this.choixClick == 29) {
               this.nbB9 = var7;
            } else if (this.choixClick == 30) {
               this.nbB10 = var7;
            } else if (this.choixClick == 40) {
               this.totalCheques = (double)var7;
            } else if (this.choixClick == 41) {
               this.totalDevises = (double)var7;
            }

            this.calculeFondsCaisse();
         }
      }

      this.showModalPaveNumerique = false;
   }

   public void zero() {
      this.lettreSaisie = this.lettreSaisie + "0";
   }

   public void un() {
      if (!this.lettreSaisie.equals("0") && !this.lettreSaisie.equals("0.0")) {
         this.lettreSaisie = this.lettreSaisie + "1";
      } else {
         this.lettreSaisie = "1";
      }

   }

   public void deux() {
      if (!this.lettreSaisie.equals("0") && !this.lettreSaisie.equals("0.0")) {
         this.lettreSaisie = this.lettreSaisie + "2";
      } else {
         this.lettreSaisie = "2";
      }

   }

   public void trois() {
      if (!this.lettreSaisie.equals("0") && !this.lettreSaisie.equals("0.0")) {
         this.lettreSaisie = this.lettreSaisie + "3";
      } else {
         this.lettreSaisie = "3";
      }

   }

   public void quatre() {
      if (!this.lettreSaisie.equals("0") && !this.lettreSaisie.equals("0.0")) {
         this.lettreSaisie = this.lettreSaisie + "4";
      } else {
         this.lettreSaisie = "4";
      }

   }

   public void cinq() {
      if (!this.lettreSaisie.equals("0") && !this.lettreSaisie.equals("0.0")) {
         this.lettreSaisie = this.lettreSaisie + "5";
      } else {
         this.lettreSaisie = "5";
      }

   }

   public void six() {
      if (!this.lettreSaisie.equals("0") && !this.lettreSaisie.equals("0.0")) {
         this.lettreSaisie = this.lettreSaisie + "6";
      } else {
         this.lettreSaisie = "6";
      }

   }

   public void sept() {
      if (!this.lettreSaisie.equals("0") && !this.lettreSaisie.equals("0.0")) {
         this.lettreSaisie = this.lettreSaisie + "7";
      } else {
         this.lettreSaisie = "7";
      }

   }

   public void huit() {
      if (!this.lettreSaisie.equals("0") && !this.lettreSaisie.equals("0.0")) {
         this.lettreSaisie = this.lettreSaisie + "8";
      } else {
         this.lettreSaisie = "8";
      }

   }

   public void neuf() {
      if (!this.lettreSaisie.equals("0") && !this.lettreSaisie.equals("0.0")) {
         this.lettreSaisie = this.lettreSaisie + "9";
      } else {
         this.lettreSaisie = "9";
      }

   }

   public void point() {
      if (this.typePaveNumerique != 2 && this.typePaveNumerique != 3 && this.typePaveNumerique != 4) {
         this.pointDecimal = true;
      } else {
         this.lettreSaisie = this.lettreSaisie + ".";
      }

   }

   public void effaceChiffre() {
      this.lettreSaisie = "0";
      this.pointDecimal = false;
   }

   public void calculeTotalTicket() {
      this.montantHt = 0.0D;
      this.montantTaxe = 0.0D;
      this.montantTtc = 0.0D;
      this.montantTc = 0.0D;
      this.montant_timbre = 0.0D;
      double var1 = 0.0D;
      new TicketLigneVentes();

      for(int var4 = 0; var4 < this.lesLignesList.size(); ++var4) {
         TicketLigneVentes var3 = (TicketLigneVentes)this.lesLignesList.get(var4);
         this.montantHt += var3.getTicligPt();
         this.montantTaxe += var3.getTicligTva();
         this.montantTtc += var3.getTicligTtc();
         this.montantTc += var3.getTicligTc();
         if (var3.getTicligTauxRemise() != 0.0F) {
            var1 += var3.getTicligPu() * (double)var3.getTicligQte() - var3.getTicligPt();
         }
      }

      this.ticketEnteteVentes.setTicTotalHt(this.montantHt);
      this.ticketEnteteVentes.setTicTotalTva(this.montantTaxe);
      this.ticketEnteteVentes.setTicTotalTtc(this.montantTtc);
      this.ticketEnteteVentes.setTicTotalTc(this.montantTc);
   }

   public void clientPaveLettre() throws HibernateException, NamingException {
      if (this.ticketEnteteVentes != null) {
         this.lettreSaisie = this.ticketEnteteVentes.getTicNomTiers();
         this.typePaveNumerique = 2;
         this.libellePaveNumerique = "Saisir Nom Client";
         this.showModalPaveLettre = true;
      }

   }

   public void saisieTelephone() throws HibernateException, NamingException {
      if (this.ticketEnteteVentes != null) {
         this.lettreSaisie = this.ticketEnteteVentes.getTicMail();
         this.typePaveNumerique = 3;
         this.libellePaveNumerique = "Saisir N° Téléphone";
         this.showModalPaveLettre = true;
      }

   }

   public void saisieMail() throws HibernateException, NamingException {
      if (this.ticketEnteteVentes != null) {
         this.lettreSaisie = this.ticketEnteteVentes.getTicMail();
         this.typePaveNumerique = 4;
         this.libellePaveNumerique = "Saisir Mail Client";
         this.showModalPaveLettre = true;
      }

   }

   public void a() {
      this.lettreSaisie = this.lettreSaisie + "A";
   }

   public void b() {
      this.lettreSaisie = this.lettreSaisie + "B";
   }

   public void c() {
      this.lettreSaisie = this.lettreSaisie + "C";
   }

   public void d() {
      this.lettreSaisie = this.lettreSaisie + "D";
   }

   public void e() {
      this.lettreSaisie = this.lettreSaisie + "E";
   }

   public void f() {
      this.lettreSaisie = this.lettreSaisie + "F";
   }

   public void g() {
      this.lettreSaisie = this.lettreSaisie + "G";
   }

   public void h() {
      this.lettreSaisie = this.lettreSaisie + "H";
   }

   public void i() {
      this.lettreSaisie = this.lettreSaisie + "I";
   }

   public void j() {
      this.lettreSaisie = this.lettreSaisie + "J";
   }

   public void k() {
      this.lettreSaisie = this.lettreSaisie + "K";
   }

   public void l() {
      this.lettreSaisie = this.lettreSaisie + "L";
   }

   public void m() {
      this.lettreSaisie = this.lettreSaisie + "M";
   }

   public void n() {
      this.lettreSaisie = this.lettreSaisie + "N";
   }

   public void o() {
      this.lettreSaisie = this.lettreSaisie + "O";
   }

   public void p() {
      this.lettreSaisie = this.lettreSaisie + "P";
   }

   public void q() {
      this.lettreSaisie = this.lettreSaisie + "Q";
   }

   public void r() {
      this.lettreSaisie = this.lettreSaisie + "R";
   }

   public void s() {
      this.lettreSaisie = this.lettreSaisie + "S";
   }

   public void t() {
      this.lettreSaisie = this.lettreSaisie + "T";
   }

   public void u() {
      this.lettreSaisie = this.lettreSaisie + "U";
   }

   public void v() {
      this.lettreSaisie = this.lettreSaisie + "V";
   }

   public void w() {
      this.lettreSaisie = this.lettreSaisie + "W";
   }

   public void x() {
      this.lettreSaisie = this.lettreSaisie + "X";
   }

   public void y() {
      this.lettreSaisie = this.lettreSaisie + "Y";
   }

   public void z() {
      this.lettreSaisie = this.lettreSaisie + "Z";
   }

   public void dollar() {
      this.lettreSaisie = this.lettreSaisie + "$";
   }

   public void moins() {
      this.lettreSaisie = this.lettreSaisie + "-";
   }

   public void underscore() {
      this.lettreSaisie = this.lettreSaisie + "_";
   }

   public void etoile() {
      this.lettreSaisie = this.lettreSaisie + "*";
   }

   public void arobase() {
      this.lettreSaisie = this.lettreSaisie + "@";
   }

   public void espace() {
      this.lettreSaisie = this.lettreSaisie + "";
   }

   public void effaceLettre() {
      this.lettreSaisie = "";
   }

   public void fermerPaveLettre() {
      this.showModalPaveLettre = false;
   }

   public void validePaveLettre() throws HibernateException, NamingException {
      if (this.typePaveNumerique == 2) {
         this.lesTiers.clear();
         TiersDao var1 = new TiersDao(this.baseLog, this.utilInitHibernate);
         String var2 = "";
         if (this.lettreSaisie == null || this.lettreSaisie.isEmpty()) {
            this.lettreSaisie = "*";
         }

         if (this.lettreSaisie.equals("*")) {
            var2 = "from Tiers where tietype = 3";
         } else {
            var2 = "from Tiers where tietype = 3 and tieraisonsocialenom like '" + this.lettreSaisie + "%'";
         }

         this.lesTiers = var1.listeTiers(var2, (Session)null);
         this.dataModelTiers.setWrappedData(this.lesTiers);
      } else if (this.typePaveNumerique == 3) {
         this.ticketEnteteVentes.setTicTelephne(this.lettreSaisie);
      } else if (this.typePaveNumerique == 4) {
         this.ticketEnteteVentes.setTicMail(this.lettreSaisie.toLowerCase());
      }

      this.showModalPaveLettre = false;
   }

   public void choixTiers() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.dataModelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.dataModelTiers.getRowData();
         this.calculeTiers();
         this.typeBouton = 1;
      }

   }

   public void choixTarif() {
      if (this.dataModelFamilleClient.isRowAvailable()) {
         this.objetFamilleTiers = (ObjetFamilleTiers)this.dataModelFamilleClient.getRowData();
         this.ticketEnteteVentes.setTicCat(this.objetFamilleTiers.getLibelle());
      }

      this.typeBouton = 1;
   }

   public void annuleTarif() {
      this.typeBouton = 1;
   }

   public void reglementEncaisse() {
      double var1 = 0.0D;

      for(int var3 = 0; var3 < this.lesReglements.size(); ++var3) {
         if (((Reglements)this.lesReglements.get(var3)).getRglTypeReg() == 0) {
            var1 += ((Reglements)this.lesReglements.get(var3)).getRglRecette();
         }
      }

      if (this.ticketEnteteVentes != null && var1 != 0.0D) {
         this.typePaveNumerique = 10;
         this.libellePaveNumerique = "Montant Encaissé";
         this.lettreSaisie = "" + this.montantEncaisse;
         this.pointDecimal = false;
         this.showModalPaveNumerique = true;
      }

   }

   public void selectionDebut() throws HibernateException, NamingException {
      this.caissesPrevision = this.caissesPrevisionDao.caisseControle(1, this.var_nom_equipe, this.var_depotProd, this.var_caisse, this.var_date, (Session)null);
      if (this.caissesPrevision == null) {
         this.caissesPrevision = new CaissesPrevision();
      }

      this.nbP1 = this.caissesPrevision.getCaipreNbP1();
      this.nbP2 = this.caissesPrevision.getCaipreNbP2();
      this.nbP3 = this.caissesPrevision.getCaipreNbP3();
      this.nbP4 = this.caissesPrevision.getCaipreNbP4();
      this.nbP5 = this.caissesPrevision.getCaipreNbP5();
      this.nbP6 = this.caissesPrevision.getCaipreNbP6();
      this.nbP7 = this.caissesPrevision.getCaipreNbP7();
      this.nbP8 = this.caissesPrevision.getCaipreNbP8();
      this.nbP9 = this.caissesPrevision.getCaipreNbP9();
      this.nbP10 = this.caissesPrevision.getCaipreNbP10();
      this.nbB1 = this.caissesPrevision.getCaipreNbB1();
      this.nbB2 = this.caissesPrevision.getCaipreNbB2();
      this.nbB3 = this.caissesPrevision.getCaipreNbB3();
      this.nbB4 = this.caissesPrevision.getCaipreNbB4();
      this.nbB5 = this.caissesPrevision.getCaipreNbB5();
      this.nbB6 = this.caissesPrevision.getCaipreNbB6();
      this.nbB7 = this.caissesPrevision.getCaipreNbB7();
      this.nbB8 = this.caissesPrevision.getCaipreNbB8();
      this.nbB9 = this.caissesPrevision.getCaipreNbB9();
      this.nbB10 = this.caissesPrevision.getCaipreNbB10();
      this.totalCheques = 0.0D;
      this.totalDevises = 0.0D;
      this.totalPiece = 0.0D;
      this.totalBillet = 0.0D;
      this.totalCaisse = 0.0D;
      this.calculeFondsCaisse();
      this.typePaveNumerique = 8;
      this.lettreSaisie = "0";
      this.libellePaveNumerique = "OUVERTURE DE CAISSE";
      this.showModalPanelFondsCaisse = true;
   }

   public void selectionFin() throws HibernateException, NamingException {
      this.caissesPrevision = this.caissesPrevisionDao.caisseControle(2, this.var_nom_equipe, this.var_depotProd, this.var_caisse, this.var_date, (Session)null);
      if (this.caissesPrevision == null) {
         this.caissesPrevision = new CaissesPrevision();
      }

      this.nbP1 = this.caissesPrevision.getCaipreNbP1();
      this.nbP2 = this.caissesPrevision.getCaipreNbP2();
      this.nbP3 = this.caissesPrevision.getCaipreNbP3();
      this.nbP4 = this.caissesPrevision.getCaipreNbP4();
      this.nbP5 = this.caissesPrevision.getCaipreNbP5();
      this.nbP6 = this.caissesPrevision.getCaipreNbP6();
      this.nbP7 = this.caissesPrevision.getCaipreNbP7();
      this.nbP8 = this.caissesPrevision.getCaipreNbP8();
      this.nbP9 = this.caissesPrevision.getCaipreNbP9();
      this.nbP10 = this.caissesPrevision.getCaipreNbP10();
      this.nbB1 = this.caissesPrevision.getCaipreNbB1();
      this.nbB2 = this.caissesPrevision.getCaipreNbB2();
      this.nbB3 = this.caissesPrevision.getCaipreNbB3();
      this.nbB4 = this.caissesPrevision.getCaipreNbB4();
      this.nbB5 = this.caissesPrevision.getCaipreNbB5();
      this.nbB6 = this.caissesPrevision.getCaipreNbB6();
      this.nbB7 = this.caissesPrevision.getCaipreNbB7();
      this.nbB8 = this.caissesPrevision.getCaipreNbB8();
      this.nbB9 = this.caissesPrevision.getCaipreNbB9();
      this.nbB10 = this.caissesPrevision.getCaipreNbB10();
      this.totalCheques = this.caissesPrevision.getCaipreTotalCheques();
      this.totalDevises = this.caissesPrevision.getCaipreTotalDevises();
      this.totalPiece = 0.0D;
      this.totalBillet = 0.0D;
      this.totalCaisse = 0.0D;
      this.calculeFondsCaisse();
      this.typePaveNumerique = 9;
      this.lettreSaisie = "0";
      this.libellePaveNumerique = "FERMETURE DE CAISSE";
      this.showModalPanelFondsCaisse = true;
   }

   public void validerSession() throws HibernateException, NamingException {
      boolean var1 = false;
      byte var5;
      if (this.typePaveNumerique == 8) {
         var5 = 1;
      } else {
         var5 = 2;
      }

      this.caissesPrevision = this.caissesPrevisionDao.caisseControle(var5, this.var_nom_equipe, this.var_depotProd, this.var_caisse, this.var_date, (Session)null);
      if (this.caissesPrevision == null) {
         this.caissesPrevision = new CaissesPrevision();
         this.caissesPrevision.setCaipreDateCreation(new Date());
         this.caissesPrevision.setCaipreUserIdCreation(this.usersLog.getUsrid());
      } else {
         this.caissesPrevision.setCaipreDateModif(new Date());
         this.caissesPrevision.setCaipreUserIdModif(this.usersLog.getUsrid());
      }

      String var2 = "";
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         String[] var3 = this.var_caisse.split(":");
         var2 = var3[0];
      } else {
         var2 = this.var_caisse;
      }

      String var6 = "";
      if (this.var_depotProd != null && !this.var_depotProd.isEmpty() && this.var_depotProd.contains(":")) {
         String[] var4 = this.var_depotProd.split(":");
         var6 = var4[0];
      } else {
         var6 = this.var_depotProd;
      }

      this.caissesPrevision.setCaipreCaisse(var2);
      this.caissesPrevision.setCaipreDepot(var6);
      this.caissesPrevision.setCaipreDateDebut(this.var_date);
      this.caissesPrevision.setCaipreIdCaissier(this.var_nom_commercial);
      this.caissesPrevision.setCaipreIdEquipe(this.var_nom_equipe);
      this.caissesPrevision.setCaipreIdResponsable(this.var_nom_responsable);
      this.caissesPrevision.setCaipreType(var5);
      this.caissesPrevision.setExercicesCaisse(this.exercicesCaisse);
      this.caissesPrevision.setCaipreNbP1(this.nbP1);
      this.caissesPrevision.setCaipreNbP2(this.nbP2);
      this.caissesPrevision.setCaipreNbP3(this.nbP3);
      this.caissesPrevision.setCaipreNbP4(this.nbP4);
      this.caissesPrevision.setCaipreNbP5(this.nbP5);
      this.caissesPrevision.setCaipreNbP6(this.nbP6);
      this.caissesPrevision.setCaipreNbP7(this.nbP7);
      this.caissesPrevision.setCaipreNbP8(this.nbP8);
      this.caissesPrevision.setCaipreNbP9(this.nbP9);
      this.caissesPrevision.setCaipreNbP10(this.nbP10);
      this.caissesPrevision.setCaipreNbB1(this.nbB1);
      this.caissesPrevision.setCaipreNbB2(this.nbB2);
      this.caissesPrevision.setCaipreNbB3(this.nbB3);
      this.caissesPrevision.setCaipreNbB4(this.nbB4);
      this.caissesPrevision.setCaipreNbB5(this.nbB5);
      this.caissesPrevision.setCaipreNbB6(this.nbB6);
      this.caissesPrevision.setCaipreNbB7(this.nbB7);
      this.caissesPrevision.setCaipreNbB8(this.nbB8);
      this.caissesPrevision.setCaipreNbB9(this.nbB9);
      this.caissesPrevision.setCaipreNbB10(this.nbB10);
      this.caissesPrevision.setCaipreTotalCheques(this.totalCheques);
      this.caissesPrevision.setCaipreTotalDevises(this.totalDevises);
      if (this.caissesPrevision.getCaipreId() == 0L) {
         this.caissesPrevision = this.caissesPrevisionDao.insert(this.caissesPrevision);
      } else {
         this.caissesPrevision = this.caissesPrevisionDao.modif(this.caissesPrevision);
      }

      this.showModalPanelFondsCaisse = false;
   }

   public void calculeFondsCaisse() {
      this.totP1 = (double)(this.val_p1 * this.nbP1);
      this.totP2 = (double)(this.val_p2 * this.nbP2);
      this.totP3 = (double)(this.val_p3 * this.nbP3);
      this.totP4 = (double)(this.val_p4 * this.nbP4);
      this.totP5 = (double)(this.val_p5 * this.nbP5);
      this.totP6 = (double)(this.val_p6 * this.nbP6);
      this.totP7 = (double)(this.val_p7 * this.nbP7);
      this.totP8 = (double)(this.val_p8 * this.nbP8);
      this.totP9 = (double)(this.val_p9 * this.nbP9);
      this.totP10 = (double)(this.val_p10 * this.nbP10);
      this.totalPiece = this.totP1 + this.totP2 + this.totP3 + this.totP4 + this.totP5 + this.totP6 + this.totP7 + this.totP8 + this.totP9 + this.totP10;
      this.totB1 = (double)(this.val_b1 * this.nbB1);
      this.totB2 = (double)(this.val_b2 * this.nbB2);
      this.totB3 = (double)(this.val_b3 * this.nbB3);
      this.totB4 = (double)(this.val_b4 * this.nbB4);
      this.totB5 = (double)(this.val_b5 * this.nbB5);
      this.totB6 = (double)(this.val_b6 * this.nbB6);
      this.totB7 = (double)(this.val_b7 * this.nbB7);
      this.totB8 = (double)(this.val_b8 * this.nbB8);
      this.totB9 = (double)(this.val_b9 * this.nbB9);
      this.totB10 = (double)(this.val_b10 * this.nbB10);
      this.totalBillet = this.totB1 + this.totB2 + this.totB3 + this.totB4 + this.totB5 + this.totB6 + this.totB7 + this.totB8 + this.totB9 + this.totB10;
      this.totalCaisse = this.totalPiece + this.totalBillet + this.totalCheques + this.totalDevises;
   }

   public void selectionListeTicket() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      this.typeBouton = 14;
      this.lesEnteteList.clear();
      String var1 = "";
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         String[] var2 = this.var_caisse.split(":");
         var1 = var2[0];
      } else {
         var1 = this.var_caisse;
      }

      String var4 = "";
      String var3 = "";
      var4 = this.utilDate.dateToStringSQLLight(new Date()) + " 00:00:00";
      var3 = this.utilDate.dateToStringSQLLight(new Date()) + " 23:59:59";
      this.lesEnteteList = this.ticketEnteteVentesDao.chargerTousTickets(var4, var3, var1, (Session)null);
      if (this.lesEnteteList.size() != 0) {
         this.initReImpression();
      }

   }

   public void selectionCaProduit() {
      this.typeBouton = 16;
      this.initReImpression();
   }

   public void selectionEtatStock() throws HibernateException, NamingException {
      this.typeBouton = 15;
      this.initReImpression();
   }

   public void pp1() {
      this.choixClick = 1;
      this.lettreSaisie = "" + this.nbP1;
      this.showModalPaveNumerique = true;
   }

   public void pp2() {
      this.choixClick = 2;
      this.lettreSaisie = "" + this.nbP2;
      this.showModalPaveNumerique = true;
   }

   public void pp3() {
      this.choixClick = 3;
      this.lettreSaisie = "" + this.nbP3;
      this.showModalPaveNumerique = true;
   }

   public void pp4() {
      this.choixClick = 4;
      this.lettreSaisie = "" + this.nbP4;
      this.showModalPaveNumerique = true;
   }

   public void pp5() {
      this.choixClick = 5;
      this.lettreSaisie = "" + this.nbP5;
      this.showModalPaveNumerique = true;
   }

   public void pp6() {
      this.choixClick = 6;
      this.lettreSaisie = "" + this.nbP6;
      this.showModalPaveNumerique = true;
   }

   public void pp7() {
      this.choixClick = 7;
      this.lettreSaisie = "" + this.nbP7;
      this.showModalPaveNumerique = true;
   }

   public void pp8() {
      this.choixClick = 8;
      this.lettreSaisie = "" + this.nbP8;
      this.showModalPaveNumerique = true;
   }

   public void pp9() {
      this.choixClick = 9;
      this.lettreSaisie = "" + this.nbP9;
      this.showModalPaveNumerique = true;
   }

   public void pp10() {
      this.choixClick = 10;
      this.lettreSaisie = "" + this.nbP10;
      this.showModalPaveNumerique = true;
   }

   public void pb1() {
      this.choixClick = 21;
      this.lettreSaisie = "" + this.nbB1;
      this.showModalPaveNumerique = true;
   }

   public void pb2() {
      this.choixClick = 22;
      this.lettreSaisie = "" + this.nbB2;
      this.showModalPaveNumerique = true;
   }

   public void pb3() {
      this.choixClick = 23;
      this.lettreSaisie = "" + this.nbB3;
      this.showModalPaveNumerique = true;
   }

   public void pb4() {
      this.choixClick = 24;
      this.lettreSaisie = "" + this.nbB4;
      this.showModalPaveNumerique = true;
   }

   public void pb5() {
      this.choixClick = 25;
      this.lettreSaisie = "" + this.nbB5;
      this.showModalPaveNumerique = true;
   }

   public void pb6() {
      this.choixClick = 26;
      this.lettreSaisie = "" + this.nbB6;
      this.showModalPaveNumerique = true;
   }

   public void pb7() {
      this.choixClick = 27;
      this.lettreSaisie = "" + this.nbB7;
      this.showModalPaveNumerique = true;
   }

   public void pb8() {
      this.choixClick = 28;
      this.lettreSaisie = "" + this.nbB8;
      this.showModalPaveNumerique = true;
   }

   public void pb9() {
      this.choixClick = 29;
      this.lettreSaisie = "" + this.nbB9;
      this.showModalPaveNumerique = true;
   }

   public void pb10() {
      this.choixClick = 30;
      this.lettreSaisie = "" + this.nbB10;
      this.showModalPaveNumerique = true;
   }

   public void cheques() {
      this.choixClick = 40;
      this.lettreSaisie = "" + this.totalCheques;
      this.showModalPaveNumerique = true;
   }

   public void devises() {
      this.choixClick = 41;
      this.lettreSaisie = "" + this.totalDevises;
      this.showModalPaveNumerique = true;
   }

   public void initReImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.var_choix_modele = 0;
      this.visibleOptionMail = false;
      this.affMail = false;
      this.choixEtat();
      this.showModalPanelPrint = true;
   }

   public void choixEtat() {
      String var1 = "";
      this.lesmodelesImpressions.clear();
      if (this.typeBouton != 0 && this.typeBouton != 1) {
         if (this.typeBouton == 14) {
            var1 = "ListeTickets";
            this.lesmodelesImpressions.add(new SelectItem(var1));
         } else if (this.typeBouton == 15) {
            var1 = "EtatStocks";
            this.lesmodelesImpressions.add(new SelectItem(var1));
         } else if (this.typeBouton == 16) {
            var1 = "ProduitTicket(produitCumule)";
            this.lesmodelesImpressions.add(new SelectItem(var1));
         }
      } else {
         String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "ticket" + File.separator;
         File var3 = new File(var2);
         if (!var3.exists()) {
            var3.mkdir();
         }

         this.lesmodelesImpressions = new ArrayList();
         String[] var4 = var3.list();
         if (var4 != null) {
            var4 = this.triAlphabetique(var4, var4.length);

            for(int var5 = 0; var5 < var4.length; ++var5) {
               if (var4[var5].endsWith("jasper")) {
                  String var10000 = var4[var5];
                  String var7 = var4[var5].substring(0, var4[var5].indexOf("."));
                  this.lesmodelesImpressions.add(new SelectItem(var7));
               }
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

   public void closeImpression() {
      this.showModalPanelPrint = false;
      this.showModalPanelPrintStock = false;
      this.typeBouton = 0;
   }

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "ticket" + File.separator;
      return var2;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatFacture.jpg");
            if (var4.exists()) {
               var3 = "formatFacture.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatFacture.jpg");
         if (var4.exists()) {
            var3 = "formatFacture.jpg";
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

      this.montant_lettre = this.utilNombre.begin(this.montantTtc + this.montantTc, this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
      return var3;
   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimer();
   }

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public void imprimer() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         if (this.typeBouton != 0 && this.typeBouton != 1) {
            if (this.typeBouton == 14) {
               JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesEnteteList);
               this.utilPrint.setjRBeanCollectionDataSource(var1);
               this.utilPrint.setRapport(this.nomModeleListe);
               this.utilPrint.setFiltre("Caissier: " + this.var_commercial + " - Equipe: " + this.var_equipe + " - Responsable: " + this.var_responsable + " - Caisse: " + this.var_caisse);
               String var2 = this.utilDate.dateToStringFrLg(new Date());
               this.utilPrint.setEntete("Liste des tickets du " + var2);
               String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "ticket" + File.separator;
               this.utilPrint.setCheminRapport(var3);
               this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport(this.baseLog));
               this.ticketEnteteVentes = new TicketEnteteVentes();
               this.utilPrint.setImageFondPage(this.calculeImageFond(this.baseLog, this.ticketEnteteVentes.getTicEtat()));
               this.utilPrint.setNbDecQte(this.optionsVentes.getNbDecQte());
               this.utilPrint.setNbDecPu(this.optionsVentes.getNbDecPu());
               this.utilPrint.setFormat("JRV");
               this.utilPrint.setIdCommercial(this.var_nom_commercial);
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(this.nature);
               this.utilPrint.setId_doc(0L);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            } else if (this.typeBouton == 15) {
               this.imprimerStk();
            } else if (this.typeBouton == 16) {
               this.imprimerStk();
            }
         } else {
            this.ticketEnteteVentes = this.ticketEnteteVentesDao.pourParapheur(this.idTicket, (Session)null);
            if (this.ticketEnteteVentes != null) {
               this.lesLignesList = this.ticketLigneVentesDao.chargerLesLignes(this.ticketEnteteVentes, (Session)null);
               this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
               this.utilPrint.setRapport(this.nomModeleListe);
               this.utilPrint.setEntete("Impression ticket");
               this.utilPrint.setMontant_lettre(this.montant_lettre);
               this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.ticketEnteteVentes.getTicEtat()));
               this.utilPrint.setNbDecQte(this.optionsVentes.getNbDecQte());
               this.utilPrint.setNbDecPu(this.optionsVentes.getNbDecPu());
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setIdCommercial(this.ticketEnteteVentes.getTicIdCommercial());
               this.utilPrint.setTiersSelectionne(this.ticketEnteteVentes.getTiers());
               this.utilPrint.setNature(this.nature);
               this.utilPrint.setId_doc(this.ticketEnteteVentes.getTicId());
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

      this.annulationTicket();
      this.typeBouton = 0;
   }

   public void imprimerStk() throws NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         String var3;
         String var18;
         if (!this.nomModeleListe.equalsIgnoreCase("etatstocks")) {
            ArrayList var11 = new ArrayList();
            JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(var11);
            this.utilPrint.setjRBeanCollectionDataSource(var13);
            var3 = this.utilDate.dateToStringSQLLight(new Date()) + " 00:00:00";
            String var15 = this.utilDate.dateToStringSQLLight(new Date()) + " 23:59:59";
            var18 = "tic_date>='" + var3 + "' and tic_date<='" + var15 + "'";
            this.utilPrint.setRequete(var18);
         } else {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
            this.listProduits = this.produitsDao.selectAllProduits(var1);
            this.calculStock = new CalculStock();
            this.calculStock.setutilInitHibernate(this.utilInitHibernate);
            this.calculStock.setBaseLog(this.baseLog);
            this.calculStock.setStructureLog(this.structureLog);
            this.lesMvt = new ArrayList();
            long var2 = 0L;
            if (this.equipes != null) {
               if (this.equipes.getEquStock() == 1) {
                  var2 = 0L;
               } else {
                  var2 = this.equipes.getEquId();
               }
            }

            Object var4 = new ArrayList();

            int var5;
            for(var5 = 0; var5 < this.listProduits.size(); ++var5) {
               this.produits = (Produits)this.listProduits.get(var5);
               Date var6 = null;
               String[] var7 = this.var_depotProd.split(":");
               new InventaireLigne();
               InventaireLigne var8 = this.calculStock.chercheDernierInventaire(this.produits.getProCode(), var7[0], this.baseLog, var1);
               if (var8 == null) {
                  var6 = this.utilDate.stringToDateSQL("2000-01-01 00:00:00");
               } else {
                  var6 = var8.getInventaireEntete().getInvDate();
                  Stock var9 = new Stock();
                  var9.setStk_code_produit(var8.getInvligCode());
                  var9.setStkLibelle(var8.getInvligLibelle());
                  var9.setStkFamille(var8.getInvligFamille());
                  var9.setStk_date_mvt(var8.getInventaireEntete().getInvDate());
                  var9.setStk_qte_in(var8.getInvligQteUtil());
                  var9.setStk_lib_type("Inventaire");
                  var9.setStk_type(30);
                  this.lesMvt.add(var9);
               }

               ((List)var4).clear();
               String var20 = "";
               if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
                  var20 = this.produits.getProVteNat();
               } else {
                  var20 = this.produits.getProAchNat();
               }

               var4 = this.calculStock.chargerMouvements(1, "", var20, this.produits.getProCode(), this.produits.getProLibTech(), var7[0], var2, "", "", var6, new Date(), false, false, true, true, false, false, false, true, true, true, true, false, false, true, true, false, false, false, true, false, true, this.optionsVentes.getGestionStockBc(), this.baseLog, this.structureLog, var1);
               if (((List)var4).size() != 0) {
                  for(int var10 = 0; var10 < ((List)var4).size(); ++var10) {
                     this.lesMvt.add(((List)var4).get(var10));
                  }
               }
            }

            for(var5 = 0; var5 < this.listProduits.size(); ++var5) {
               this.produits = (Produits)this.listProduits.get(var5);
               Stock var19 = new Stock();
               var19.setStk_code_produit(this.produits.getProCode());
               var19.setStkLibelle(this.produits.getProLibClient());
               var19.setStkFamille(this.produits.getProVteCode());
               var19.setStk_type(0);
               var19.setStk_lib_type("");
               var19.setStk_date_mvt(new Date());
               this.lesMvt.add(var19);
            }

            this.utilInitHibernate.closeSession();
            JRBeanCollectionDataSource var17 = new JRBeanCollectionDataSource(this.lesMvt);
            this.utilPrint.setjRBeanCollectionDataSource(var17);
         }

         String var12 = "";
         String var14 = this.utilDate.dateToStringFr(new Date());
         var3 = var14.substring(6, 10) + "-" + var14.substring(3, 5) + "-" + var14.substring(0, 2);
         Date var16 = this.utilDate.dateJourPrecedent(new Date());
         var18 = this.utilDate.dateToStringSQLLight(var16) + " 23:59:59";
         var12 = "Tickets du : " + var3;
         if (this.equipes != null && this.equipes.getEquNomFr() != null && !this.equipes.getEquNomFr().isEmpty()) {
            var12 = var12 + " - Equipe : " + this.equipes.getEquNomFr();
         } else {
            var12 = var12 + " - Sans Equipe";
         }

         var12 = var12 + " - Dépôt : " + this.var_depotProd;
         this.utilPrint.setEntete(var12);
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits" + File.separator + "ligne_ticket" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setDateDeb(this.utilDate.stringToDateSQL(var18));
         if (this.equipes != null) {
            this.utilPrint.setIdEquipe(this.equipes.getEquId());
         } else {
            this.utilPrint.setIdEquipe(0L);
         }

         this.utilPrint.setNature(this.nature);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
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

   public List grapher() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.lesEnteteList.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "TICKETS : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "TICKETS : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = Integer.parseInt(this.optionsVentes.getNbDecQte());
         }

         this.titreGraph = "Analyse des ventes : ";
         String var2 = this.utilDate.dateToStringFr(this.inpDu);
         String var3 = this.utilDate.dateToStringFr(this.inpAu);
         this.titreGraph = this.titreGraph + " Du " + var2 + " au " + var3;
         this.sousTitreGraph = "";
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
         }

         if (this.timeDecoupage == 5) {
            this.titreGraph = this.titreGraph + " Par tranches horaires";
         }

         new TicketEnteteVentes();
         new TicketLigneVentes();
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "BticketLigne");
         String var7 = "";

         TicketEnteteVentes var4;
         for(int var8 = 0; var8 < this.lesEnteteList.size(); ++var8) {
            var4 = (TicketEnteteVentes)this.lesEnteteList.get(var8);
            if (var7.isEmpty()) {
               var7 = "'" + var4.getTicNum() + "'";
            } else {
               var7 = var7 + ",'" + var4.getTicNum() + "'";
            }
         }

         int var13;
         int var18;
         if (this.valQteGraph != 1 && this.modeGraph != 5 && this.modeGraph != 6) {
            if (this.lesEnteteList.size() != 0) {
               String var16 = "";
               long var19 = 0L;
               boolean var11 = false;
               var18 = 0;

               while(true) {
                  if (var18 >= this.lesEnteteList.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  var4 = (TicketEnteteVentes)this.lesEnteteList.get(var18);
                  var16 = "";
                  var19 = 0L;
                  int var17 = 0;
                  if (this.modeGraph == 0) {
                     var13 = var4.getTicDate().getYear() + 1900;
                     var16 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var4.getTicNomResponsable() != null && !var4.getTicNomResponsable().isEmpty()) {
                        var16 = var4.getTicNomResponsable();
                     } else {
                        var16 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var4.getTicNomCommercial() != null && !var4.getTicNomCommercial().isEmpty()) {
                        var16 = var4.getTicNomCommercial();
                     } else {
                        var16 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var4.getTicNomEquipe() != null && !var4.getTicNomEquipe().isEmpty()) {
                        var16 = var4.getTicNomEquipe();
                     } else {
                        var16 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var4.getTicNomTiers() != null && !var4.getTicNomTiers().isEmpty()) {
                        var16 = var4.getTicNomTiers();
                     } else {
                        var16 = "Sans Tiers";
                     }
                  }

                  var19 = (long)var4.getTicTotalHt();
                  if (this.timeDecoupage == 0) {
                     var17 = var4.getTicDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var17 = var4.getTicDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var4.getTicDate().getMonth() + 1 >= 1 && var4.getTicDate().getMonth() + 1 <= 3) {
                        var17 = 1;
                     } else if (var4.getTicDate().getMonth() + 1 >= 4 && var4.getTicDate().getMonth() + 1 <= 6) {
                        var17 = 2;
                     } else if (var4.getTicDate().getMonth() + 1 >= 7 && var4.getTicDate().getMonth() + 1 <= 9) {
                        var17 = 3;
                     } else if (var4.getTicDate().getMonth() + 1 >= 10 && var4.getTicDate().getMonth() + 1 <= 12) {
                        var17 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var4.getTicDate().getMonth() + 1 >= 1 && var4.getTicDate().getMonth() + 1 <= 6) {
                        var17 = 1;
                     } else if (var4.getTicDate().getMonth() + 1 >= 7 && var4.getTicDate().getMonth() + 1 <= 12) {
                        var17 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var17 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var17 = var4.getTicDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var16, var17, var19);
                  ++var18;
               }
            }
         } else {
            new ArrayList();
            List var15 = this.ticketLigneVentesDao.chargerLesLignesTickets(var7, var6);
            if (var15.size() != 0) {
               String var9 = "";
               long var10 = 0L;
               boolean var12 = false;

               for(var13 = 0; var13 < var15.size(); ++var13) {
                  TicketLigneVentes var5 = (TicketLigneVentes)var15.get(var13);
                  var9 = "";
                  var10 = 0L;
                  var18 = 0;
                  if (this.modeGraph == 0) {
                     int var14 = var5.getTicketEnteteVentes().getTicDate().getYear() + 1900;
                     var9 = "" + var14;
                  } else if (this.modeGraph == 1) {
                     if (var5.getTicketEnteteVentes().getTicNomResponsable() != null && !var5.getTicketEnteteVentes().getTicNomResponsable().isEmpty()) {
                        var9 = var5.getTicketEnteteVentes().getTicNomResponsable();
                     } else {
                        var9 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 2) {
                     if (var5.getTicketEnteteVentes().getTicNomCommercial() != null && !var5.getTicketEnteteVentes().getTicNomCommercial().isEmpty()) {
                        var9 = var5.getTicketEnteteVentes().getTicNomCommercial();
                     } else {
                        var9 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var5.getTicketEnteteVentes().getTicNomEquipe() != null && !var5.getTicketEnteteVentes().getTicNomEquipe().isEmpty()) {
                        var9 = var5.getTicketEnteteVentes().getTicNomEquipe();
                     } else {
                        var9 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var5.getTicketEnteteVentes().getTicNomTiers() != null && !var5.getTicketEnteteVentes().getTicNomTiers().isEmpty()) {
                        var9 = var5.getTicketEnteteVentes().getTicNomTiers();
                     } else {
                        var9 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var5.getTicligFamille() != null && !var5.getTicligFamille().isEmpty()) {
                        var9 = var5.getTicligFamille();
                     } else {
                        var9 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var5.getTicligLibelle() != null && !var5.getTicligLibelle().isEmpty()) {
                        var9 = var5.getTicligLibelle();
                     } else {
                        var9 = "Sans Libelle Produit";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var10 = (long)var5.getTicligPt();
                  } else {
                     var10 = (long)this.utilNombre.myRound(var5.getTicligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var5.getTicketEnteteVentes().getTicDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var5.getTicketEnteteVentes().getTicDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 >= 1 && var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 >= 4 && var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 >= 7 && var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 >= 10 && var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 >= 1 && var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 >= 7 && var5.getTicketEnteteVentes().getTicDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var5.getTicketEnteteVentes().getTicDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var9, var18, var10);
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

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public double getMontantReglement() {
      return this.montantReglement;
   }

   public void setMontantReglement(double var1) {
      this.montantReglement = var1;
   }

   public double getMontantSolde() {
      return this.montantSolde;
   }

   public void setMontantSolde(double var1) {
      this.montantSolde = var1;
   }

   public double getMontantTtc() {
      return this.montantTtc;
   }

   public void setMontantTtc(double var1) {
      this.montantTtc = var1;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
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

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
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

   public boolean isVar_mod() {
      return this.var_mod;
   }

   public void setVar_mod(boolean var1) {
      this.var_mod = var1;
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

   public boolean isVar_typeTiers() {
      return this.var_typeTiers;
   }

   public void setVar_typeTiers(boolean var1) {
      this.var_typeTiers = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
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

   public boolean isGriserValider() {
      return this.griserValider;
   }

   public void setGriserValider(boolean var1) {
      this.griserValider = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public List getLesModeReglementClientsListe() {
      return this.lesModeReglementClientsListe;
   }

   public void setLesModeReglementClientsListe(List var1) {
      this.lesModeReglementClientsListe = var1;
   }

   public Reglements getReglements() {
      return this.reglements;
   }

   public void setReglements(Reglements var1) {
      this.reglements = var1;
   }

   public boolean isShowModalPanelReglement() {
      return this.showModalPanelReglement;
   }

   public void setShowModalPanelReglement(boolean var1) {
      this.showModalPanelReglement = var1;
   }

   public boolean isVar_affiche_banque() {
      return this.var_affiche_banque;
   }

   public void setVar_affiche_banque(boolean var1) {
      this.var_affiche_banque = var1;
   }

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
   }

   public String getVar_banque_tireur() {
      return this.var_banque_tireur;
   }

   public void setVar_banque_tireur(String var1) {
      this.var_banque_tireur = var1;
   }

   public String getVar_num_cheque() {
      return this.var_num_cheque;
   }

   public void setVar_num_cheque(String var1) {
      this.var_num_cheque = var1;
   }

   public double getVal_timbre() {
      return this.val_timbre;
   }

   public void setVal_timbre(double var1) {
      this.val_timbre = var1;
   }

   public int getVarTypeReg() {
      return this.varTypeReg;
   }

   public void setVarTypeReg(int var1) {
      this.varTypeReg = var1;
   }

   public double getVar_ecart_reglement() {
      return this.var_ecart_reglement;
   }

   public void setVar_ecart_reglement(double var1) {
      this.var_ecart_reglement = var1;
   }

   public TicketLigneVentes getTicketLigneVentes() {
      return this.ticketLigneVentes;
   }

   public void setTicketLigneVentes(TicketLigneVentes var1) {
      this.ticketLigneVentes = var1;
   }

   public double getMontantHt() {
      return this.montantHt;
   }

   public void setMontantHt(double var1) {
      this.montantHt = var1;
   }

   public double getMontantTaxe() {
      return this.montantTaxe;
   }

   public void setMontantTaxe(double var1) {
      this.montantTaxe = var1;
   }

   public double getMontantTc() {
      return this.montantTc;
   }

   public void setMontantTc(double var1) {
      this.montantTc = var1;
   }

   public List getListProduits() {
      return this.listProduits;
   }

   public void setListProduits(List var1) {
      this.listProduits = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public DataModel getDataModelTicket() {
      return this.dataModelTicket;
   }

   public void setDataModelTicket(DataModel var1) {
      this.dataModelTicket = var1;
   }

   public boolean isValide_reglement() {
      return this.valide_reglement;
   }

   public void setValide_reglement(boolean var1) {
      this.valide_reglement = var1;
   }

   public CaissesCommerciales getCaissesCommerciales() {
      return this.caissesCommerciales;
   }

   public void setCaissesCommerciales(CaissesCommerciales var1) {
      this.caissesCommerciales = var1;
   }

   public boolean isVar_affiche_ajout() {
      return this.var_affiche_ajout;
   }

   public void setVar_affiche_ajout(boolean var1) {
      this.var_affiche_ajout = var1;
   }

   public TicketEnteteVentes getTicketEnteteVentes() {
      return this.ticketEnteteVentes;
   }

   public void setTicketEnteteVentes(TicketEnteteVentes var1) {
      this.ticketEnteteVentes = var1;
   }

   public int getVar_anal_SitDepSer() {
      return this.var_anal_SitDepSer;
   }

   public void setVar_anal_SitDepSer(int var1) {
      this.var_anal_SitDepSer = var1;
   }

   public long getVar_nom_commercial() {
      return this.var_nom_commercial;
   }

   public void setVar_nom_commercial(long var1) {
      this.var_nom_commercial = var1;
   }

   public boolean isVar_verrou_comm() {
      return this.var_verrou_comm;
   }

   public void setVar_verrou_comm(boolean var1) {
      this.var_verrou_comm = var1;
   }

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
   }

   public long getVar_nom_equipe() {
      return this.var_nom_equipe;
   }

   public void setVar_nom_equipe(long var1) {
      this.var_nom_equipe = var1;
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

   public String getVar_caisse() {
      return this.var_caisse;
   }

   public void setVar_caisse(String var1) {
      this.var_caisse = var1;
   }

   public String getVar_depotOrigine() {
      return this.var_depotOrigine;
   }

   public void setVar_depotOrigine(String var1) {
      this.var_depotOrigine = var1;
   }

   public boolean isShowModalPanelPrintStock() {
      return this.showModalPanelPrintStock;
   }

   public void setShowModalPanelPrintStock(boolean var1) {
      this.showModalPanelPrintStock = var1;
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

   public int getTypeBouton() {
      return this.typeBouton;
   }

   public void setTypeBouton(int var1) {
      this.typeBouton = var1;
   }

   public DataModel getDataModelFamilleProduit() {
      return this.dataModelFamilleProduit;
   }

   public void setDataModelFamilleProduit(DataModel var1) {
      this.dataModelFamilleProduit = var1;
   }

   public DataModel getDataModelProduits() {
      return this.dataModelProduits;
   }

   public void setDataModelProduits(DataModel var1) {
      this.dataModelProduits = var1;
   }

   public boolean isShowModalPaveNumerique() {
      return this.showModalPaveNumerique;
   }

   public void setShowModalPaveNumerique(boolean var1) {
      this.showModalPaveNumerique = var1;
   }

   public String getLibellePaveNumerique() {
      return this.libellePaveNumerique;
   }

   public void setLibellePaveNumerique(String var1) {
      this.libellePaveNumerique = var1;
   }

   public String getLettreSaisie() {
      return this.lettreSaisie;
   }

   public void setLettreSaisie(String var1) {
      this.lettreSaisie = var1;
   }

   public boolean isShowModalPaveLettre() {
      return this.showModalPaveLettre;
   }

   public void setShowModalPaveLettre(boolean var1) {
      this.showModalPaveLettre = var1;
   }

   public DataModel getDataModelTiers() {
      return this.dataModelTiers;
   }

   public void setDataModelTiers(DataModel var1) {
      this.dataModelTiers = var1;
   }

   public DataModel getDataModelFamilleClient() {
      return this.dataModelFamilleClient;
   }

   public void setDataModelFamilleClient(DataModel var1) {
      this.dataModelFamilleClient = var1;
   }

   public DataModel getDataModelLivreurs() {
      return this.dataModelLivreurs;
   }

   public void setDataModelLivreurs(DataModel var1) {
      this.dataModelLivreurs = var1;
   }

   public DataModel getDataModelReglement() {
      return this.dataModelReglement;
   }

   public void setDataModelReglement(DataModel var1) {
      this.dataModelReglement = var1;
   }

   public int getTypePaveNumerique() {
      return this.typePaveNumerique;
   }

   public void setTypePaveNumerique(int var1) {
      this.typePaveNumerique = var1;
   }

   public boolean isVerrouRemise() {
      return this.verrouRemise;
   }

   public void setVerrouRemise(boolean var1) {
      this.verrouRemise = var1;
   }

   public String getVar_equipe() {
      return this.var_equipe;
   }

   public void setVar_equipe(String var1) {
      this.var_equipe = var1;
   }

   public String getVar_responsable() {
      return this.var_responsable;
   }

   public void setVar_responsable(String var1) {
      this.var_responsable = var1;
   }

   public String getVar_commercial() {
      return this.var_commercial;
   }

   public void setVar_commercial(String var1) {
      this.var_commercial = var1;
   }

   public List getLesmodelesImpressions() {
      return this.lesmodelesImpressions;
   }

   public void setLesmodelesImpressions(List var1) {
      this.lesmodelesImpressions = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
   }

   public String getImpDestinataireCC() {
      return this.impDestinataireCC;
   }

   public void setImpDestinataireCC(String var1) {
      this.impDestinataireCC = var1;
   }

   public String getImpDestinataireCCI() {
      return this.impDestinataireCCI;
   }

   public void setImpDestinataireCCI(String var1) {
      this.impDestinataireCCI = var1;
   }

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public String getNomModeleListe() {
      return this.nomModeleListe;
   }

   public void setNomModeleListe(String var1) {
      this.nomModeleListe = var1;
   }

   public String getUniteGraph() {
      return this.uniteGraph;
   }

   public void setUniteGraph(String var1) {
      this.uniteGraph = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
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

   public boolean isShowModalPanelFondsCaisse() {
      return this.showModalPanelFondsCaisse;
   }

   public void setShowModalPanelFondsCaisse(boolean var1) {
      this.showModalPanelFondsCaisse = var1;
   }

   public boolean isShowModalPanelFinSession() {
      return this.showModalPanelFinSession;
   }

   public void setShowModalPanelFinSession(boolean var1) {
      this.showModalPanelFinSession = var1;
   }

   public OptionCaisses getOptionCaisses() {
      return this.optionCaisses;
   }

   public void setOptionCaisses(OptionCaisses var1) {
      this.optionCaisses = var1;
   }

   public int getNbB1() {
      return this.nbB1;
   }

   public void setNbB1(int var1) {
      this.nbB1 = var1;
   }

   public int getNbB2() {
      return this.nbB2;
   }

   public void setNbB2(int var1) {
      this.nbB2 = var1;
   }

   public int getNbB3() {
      return this.nbB3;
   }

   public void setNbB3(int var1) {
      this.nbB3 = var1;
   }

   public int getNbB4() {
      return this.nbB4;
   }

   public void setNbB4(int var1) {
      this.nbB4 = var1;
   }

   public int getNbB5() {
      return this.nbB5;
   }

   public void setNbB5(int var1) {
      this.nbB5 = var1;
   }

   public int getNbB6() {
      return this.nbB6;
   }

   public void setNbB6(int var1) {
      this.nbB6 = var1;
   }

   public int getNbB7() {
      return this.nbB7;
   }

   public void setNbB7(int var1) {
      this.nbB7 = var1;
   }

   public int getNbB8() {
      return this.nbB8;
   }

   public void setNbB8(int var1) {
      this.nbB8 = var1;
   }

   public int getNbB9() {
      return this.nbB9;
   }

   public void setNbB9(int var1) {
      this.nbB9 = var1;
   }

   public int getNbP1() {
      return this.nbP1;
   }

   public void setNbP1(int var1) {
      this.nbP1 = var1;
   }

   public int getNbP2() {
      return this.nbP2;
   }

   public void setNbP2(int var1) {
      this.nbP2 = var1;
   }

   public int getNbP3() {
      return this.nbP3;
   }

   public void setNbP3(int var1) {
      this.nbP3 = var1;
   }

   public int getNbP4() {
      return this.nbP4;
   }

   public void setNbP4(int var1) {
      this.nbP4 = var1;
   }

   public int getNbP5() {
      return this.nbP5;
   }

   public void setNbP5(int var1) {
      this.nbP5 = var1;
   }

   public int getNbP6() {
      return this.nbP6;
   }

   public void setNbP6(int var1) {
      this.nbP6 = var1;
   }

   public int getNbP7() {
      return this.nbP7;
   }

   public void setNbP7(int var1) {
      this.nbP7 = var1;
   }

   public int getNbP8() {
      return this.nbP8;
   }

   public void setNbP8(int var1) {
      this.nbP8 = var1;
   }

   public int getNbP9() {
      return this.nbP9;
   }

   public void setNbP9(int var1) {
      this.nbP9 = var1;
   }

   public double getTotB1() {
      return this.totB1;
   }

   public void setTotB1(double var1) {
      this.totB1 = var1;
   }

   public double getTotB2() {
      return this.totB2;
   }

   public void setTotB2(double var1) {
      this.totB2 = var1;
   }

   public double getTotB3() {
      return this.totB3;
   }

   public void setTotB3(double var1) {
      this.totB3 = var1;
   }

   public double getTotB4() {
      return this.totB4;
   }

   public void setTotB4(double var1) {
      this.totB4 = var1;
   }

   public double getTotB5() {
      return this.totB5;
   }

   public void setTotB5(double var1) {
      this.totB5 = var1;
   }

   public double getTotB6() {
      return this.totB6;
   }

   public void setTotB6(double var1) {
      this.totB6 = var1;
   }

   public double getTotB7() {
      return this.totB7;
   }

   public void setTotB7(double var1) {
      this.totB7 = var1;
   }

   public double getTotB8() {
      return this.totB8;
   }

   public void setTotB8(double var1) {
      this.totB8 = var1;
   }

   public double getTotB9() {
      return this.totB9;
   }

   public void setTotB9(double var1) {
      this.totB9 = var1;
   }

   public double getTotP1() {
      return this.totP1;
   }

   public void setTotP1(double var1) {
      this.totP1 = var1;
   }

   public double getTotP2() {
      return this.totP2;
   }

   public void setTotP2(double var1) {
      this.totP2 = var1;
   }

   public double getTotP3() {
      return this.totP3;
   }

   public void setTotP3(double var1) {
      this.totP3 = var1;
   }

   public double getTotP4() {
      return this.totP4;
   }

   public void setTotP4(double var1) {
      this.totP4 = var1;
   }

   public double getTotP5() {
      return this.totP5;
   }

   public void setTotP5(double var1) {
      this.totP5 = var1;
   }

   public double getTotP6() {
      return this.totP6;
   }

   public void setTotP6(double var1) {
      this.totP6 = var1;
   }

   public double getTotP7() {
      return this.totP7;
   }

   public void setTotP7(double var1) {
      this.totP7 = var1;
   }

   public double getTotP8() {
      return this.totP8;
   }

   public void setTotP8(double var1) {
      this.totP8 = var1;
   }

   public double getTotP9() {
      return this.totP9;
   }

   public void setTotP9(double var1) {
      this.totP9 = var1;
   }

   public double getTotalBillet() {
      return this.totalBillet;
   }

   public void setTotalBillet(double var1) {
      this.totalBillet = var1;
   }

   public double getTotalCaisse() {
      return this.totalCaisse;
   }

   public void setTotalCaisse(double var1) {
      this.totalCaisse = var1;
   }

   public double getTotalPiece() {
      return this.totalPiece;
   }

   public void setTotalPiece(double var1) {
      this.totalPiece = var1;
   }

   public int getNbB10() {
      return this.nbB10;
   }

   public void setNbB10(int var1) {
      this.nbB10 = var1;
   }

   public int getNbP10() {
      return this.nbP10;
   }

   public void setNbP10(int var1) {
      this.nbP10 = var1;
   }

   public double getTotB10() {
      return this.totB10;
   }

   public void setTotB10(double var1) {
      this.totB10 = var1;
   }

   public double getTotP10() {
      return this.totP10;
   }

   public void setTotP10(double var1) {
      this.totP10 = var1;
   }

   public int getVal_b1() {
      return this.val_b1;
   }

   public void setVal_b1(int var1) {
      this.val_b1 = var1;
   }

   public int getVal_b10() {
      return this.val_b10;
   }

   public void setVal_b10(int var1) {
      this.val_b10 = var1;
   }

   public int getVal_b2() {
      return this.val_b2;
   }

   public void setVal_b2(int var1) {
      this.val_b2 = var1;
   }

   public int getVal_b3() {
      return this.val_b3;
   }

   public void setVal_b3(int var1) {
      this.val_b3 = var1;
   }

   public int getVal_b4() {
      return this.val_b4;
   }

   public void setVal_b4(int var1) {
      this.val_b4 = var1;
   }

   public int getVal_b5() {
      return this.val_b5;
   }

   public void setVal_b5(int var1) {
      this.val_b5 = var1;
   }

   public int getVal_b6() {
      return this.val_b6;
   }

   public void setVal_b6(int var1) {
      this.val_b6 = var1;
   }

   public int getVal_b7() {
      return this.val_b7;
   }

   public void setVal_b7(int var1) {
      this.val_b7 = var1;
   }

   public int getVal_b8() {
      return this.val_b8;
   }

   public void setVal_b8(int var1) {
      this.val_b8 = var1;
   }

   public int getVal_b9() {
      return this.val_b9;
   }

   public void setVal_b9(int var1) {
      this.val_b9 = var1;
   }

   public int getVal_p1() {
      return this.val_p1;
   }

   public void setVal_p1(int var1) {
      this.val_p1 = var1;
   }

   public int getVal_p10() {
      return this.val_p10;
   }

   public void setVal_p10(int var1) {
      this.val_p10 = var1;
   }

   public int getVal_p2() {
      return this.val_p2;
   }

   public void setVal_p2(int var1) {
      this.val_p2 = var1;
   }

   public int getVal_p3() {
      return this.val_p3;
   }

   public void setVal_p3(int var1) {
      this.val_p3 = var1;
   }

   public int getVal_p4() {
      return this.val_p4;
   }

   public void setVal_p4(int var1) {
      this.val_p4 = var1;
   }

   public int getVal_p5() {
      return this.val_p5;
   }

   public void setVal_p5(int var1) {
      this.val_p5 = var1;
   }

   public int getVal_p6() {
      return this.val_p6;
   }

   public void setVal_p6(int var1) {
      this.val_p6 = var1;
   }

   public int getVal_p7() {
      return this.val_p7;
   }

   public void setVal_p7(int var1) {
      this.val_p7 = var1;
   }

   public int getVal_p8() {
      return this.val_p8;
   }

   public void setVal_p8(int var1) {
      this.val_p8 = var1;
   }

   public int getVal_p9() {
      return this.val_p9;
   }

   public void setVal_p9(int var1) {
      this.val_p9 = var1;
   }

   public double getTotalCheques() {
      return this.totalCheques;
   }

   public void setTotalCheques(double var1) {
      this.totalCheques = var1;
   }

   public double getTotalDevises() {
      return this.totalDevises;
   }

   public void setTotalDevises(double var1) {
      this.totalDevises = var1;
   }

   public double getMontantEncaisse() {
      return this.montantEncaisse;
   }

   public void setMontantEncaisse(double var1) {
      this.montantEncaisse = var1;
   }

   public double getMontantRendu() {
      return this.montantRendu;
   }

   public void setMontantRendu(double var1) {
      this.montantRendu = var1;
   }
}
