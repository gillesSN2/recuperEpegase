package com.epegase.forms.parc;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.ParcOrEntete;
import com.epegase.systeme.classe.ParcOrPiece;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.MotifEntreeParcDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.ParcOrEnteteDao;
import com.epegase.systeme.dao.ParcOrPieceDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
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
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionParcs;
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

public class FormParcOr implements Serializable {
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
   private boolean var_acc_etat = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean affichagePump = false;
   private String verrouDepotUser;
   private boolean verrouPrvente = false;
   private boolean verrouRemise = false;
   private boolean verrouRabais = false;
   private String libelleRabRis;
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
   private ParcOrEntete parcOrEntete;
   private ParcOrEnteteDao parcOrEnteteDao;
   private List lesOrEntete = new ArrayList();
   private transient DataModel dataModelOrEntete = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean var_affiche_bouton = false;
   private Tiers tiers;
   private TiersDao tiersDao;
   private ParcOrPiece parcOrPiece;
   private ParcOrPieceDao parcOrPieceDao;
   private List lesOrPieces;
   private transient DataModel dataModelOrPiece;
   private List lesOrPiecesReel;
   private transient DataModel dataModelOrPieceReel;
   private List lesOrMo;
   private transient DataModel dataModelOrMo;
   private List lesOrMoReel;
   private transient DataModel dataModelOrMoReel;
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
   private Produits produits;
   private List lesProdtuisItems = new ArrayList();
   private List lesDepotsItems = new ArrayList();
   private List lesProduits = new ArrayList();
   private ProduitsDepotDao produitsDepotDao;
   private CalculStock calculStock;
   private boolean visibiliteBtonlig = false;
   private boolean griserchamps = false;
   private List mesUnitesProduits;
   private int var_code_unite;
   private boolean var_aff_condit = false;
   private ProduitsFournisseurDao produitsFournisseurDao;
   private List mesTaxesVentesProduits;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private TaxesVentesDao taxesVentesDao;
   private ProduitsDepot produitsDepot;
   private double prixPlancher;
   private List mesConditionnementsProduits;
   private List mesTaxesVentesItems;
   private double prixUnitaires;
   private boolean verifBareme = false;
   private BaremesDao baremesDao;
   private List mesProduitsDepotsItems;
   private ProduitsTarifDao produitsTarifDao;
   private String var_depotProd;
   private Unite unite;
   private UniteDao uniteDao;
   private boolean var_aff_unite = false;
   private List listeProduitDepot;
   private List mesConditionnementsItems;
   private boolean griserValider = false;
   private int validationLigne;
   private String messageStockNegatif;
   private List mesReceptionnairesItems = new ArrayList();
   private List mesMotifsEntreeItems;
   private MotifEntreeParcDao motifEntreeParcDao;
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

   public FormParcOr() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.calculStock = new CalculStock();
      this.lesDecoupagesActivites = new ArrayList();
      this.dataModelDecoupageActivtes = new ListDataModel();
      this.usersChrono = new UsersChrono();
      this.mesMotifsEntreeItems = new ArrayList();
      this.lesOrPieces = new ArrayList();
      this.dataModelOrPiece = new ListDataModel();
      this.lesOrPiecesReel = new ArrayList();
      this.dataModelOrPieceReel = new ListDataModel();
      this.lesOrMo = new ArrayList();
      this.dataModelOrMo = new ListDataModel();
      this.lesOrMoReel = new ArrayList();
      this.dataModelOrMoReel = new ListDataModel();
      this.mesUnitesProduits = new ArrayList();
      this.mesTaxesVentesProduits = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.listeProduitDepot = new ArrayList();
      this.mesConditionnementsItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.parcOrEnteteDao = new ParcOrEnteteDao(this.baseLog, this.utilInitHibernate);
      this.parcOrPieceDao = new ParcOrPieceDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.motifEntreeParcDao = new MotifEntreeParcDao(this.baseLog, this.utilInitHibernate);
      this.produitsFournisseurDao = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisation(Session var1) throws HibernateException, NamingException {
      if (this.optionParcs.getNbLigneMax() != null && !this.optionParcs.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionParcs.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.var_action = 0;
      this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      this.onglet01();
   }

   public void rechercherOr() throws HibernateException, NamingException, ParseException {
      this.rechercherOr((Session)null);
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

   public void rechercherOr(Session var1) throws HibernateException, NamingException, ParseException {
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

      this.lesOrEntete = this.parcOrEnteteDao.rechercheParcOrEntete(this.selectedExo.getExeprcId(), this.inpTiers, this.inpClient, 0, this.usersLog.getUsrid(), this.inpNum, this.inpSerie, this.inpEtat, this.periode, this.inpActivite, this.inpReceptionnaire, this.inpChauffeur, this.inpParc, var2, var3, this.inpService, var1);
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
      this.var_onglet = "description";
   }

   public void onglet03() {
      this.var_onglet = "inventaireIn";
   }

   public void onglet04() {
      this.var_onglet = "imputations";
   }

   public void onglet05() {
      this.var_onglet = "pieces";
   }

   public void onglet06() {
      this.var_onglet = "mainpoeuvre";
   }

   public void onglet07() {
      this.var_onglet = "sortie";
   }

   public void onglet08() {
      this.var_onglet = "inventaireOut";
   }

   public void selectionOr() throws HibernateException, NamingException {
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
            this.parcOrEntete = (ParcOrEntete)var1.get(0);
            this.var_date = this.parcOrEntete.getPrcoreDate();
            if (this.parcOrEntete.getPrcoreDate().getHours() <= 9) {
               this.var_heure = "0" + this.parcOrEntete.getPrcoreDate().getHours();
            } else {
               this.var_heure = "" + this.parcOrEntete.getPrcoreDate().getHours();
            }

            if (this.parcOrEntete.getPrcoreDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.parcOrEntete.getPrcoreDate().getMinutes();
            } else {
               this.var_minute = "" + this.parcOrEntete.getPrcoreDate().getMinutes();
            }

            if (this.parcOrEntete.getPrcoreDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.parcOrEntete.getPrcoreDate().getSeconds();
            } else {
               this.var_seconde = "" + this.parcOrEntete.getPrcoreDate().getSeconds();
            }

            this.parc = this.parcOrEntete.getParc();
            this.immatriculation = this.parc.getPrcImmatriculation();
            this.typeCompteur = this.parc.getLibCompteur();
            this.tiers = this.parcOrEntete.getTiers();
            this.lesProdtuisItems.clear();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_or");
            this.chargerMotifEntree(var4);
            this.chargerLignes(var4);
            this.lesProduits.clear();
            if (this.parcOrEntete.getPrcoreService() != null && !this.parcOrEntete.getPrcoreService().isEmpty()) {
               this.calculReceptionnaire(var4);
            }

            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            this.utilInitHibernate.closeSession();
            this.var_affiche_bouton = true;
            this.visibiliteBtonlig = true;
         } else {
            this.var_affiche_bouton = false;
            this.visibiliteBtonlig = false;
         }
      } else {
         this.var_affiche_bouton = false;
         this.visibiliteBtonlig = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.parcOrEntete != null) {
         if (this.parcOrEntete.getPrcoreEtat() == 0) {
            this.modifierOr();
         } else {
            this.consulterOr();
         }
      }

   }

   public void ajouterOr() throws HibernateException, NamingException {
      this.tiers = new Tiers();
      this.parc = new Parc();
      this.parcOrEntete = new ParcOrEntete();
      this.parcOrPiece = new ParcOrPiece();
      this.produits = new Produits();
      this.lesProdtuisItems.clear();
      this.lesProduits.clear();
      this.lesDepotsItems.clear();
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

      this.mesMotifsEntreeItems.clear();
      this.var_saisie_pu = false;
      this.var_action = 1;
      this.var_valide_parc = false;
      this.var_aff_action = false;
      this.visibiliteBtonlig = false;
      this.var_memo_action = this.var_action;
      this.onglet01();
      this.addLigne();
   }

   public void modifierOr() {
      if (this.parcOrEntete != null) {
         this.var_valide_parc = true;
         this.var_aff_action = false;
         this.visibiliteBtonlig = true;
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.onglet01();
         this.addLigne();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.parcOrEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_or");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.parcOrEntete.getPrcoreEtat() == 0 && this.usersChrono.getUsrchrValidation() == 2) {
               this.parcOrEntete.setPrcoreEtat(1);
               this.parcOrEntete = this.parcOrEnteteDao.modif(this.parcOrEntete, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle OR (P.) N° " + this.parcOrEntete.getPrcoreNum() + " du " + this.utilDate.dateToStringSQLLight(this.parcOrEntete.getPrcoreDate()));
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
      if (this.parcOrEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_or");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.parcOrEntete.getPrcoreEtat() == 1) {
               this.parcOrEntete.setPrcoreEtat(0);
               this.parcOrEntete = this.parcOrEnteteDao.modif(this.parcOrEntete, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle OR (P.) N° " + this.parcOrEntete.getPrcoreNum() + " du " + this.utilDate.dateToStringSQLLight(this.parcOrEntete.getPrcoreDate()));
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

   public void consulterOr() {
      if (this.parcOrEntete != null) {
         this.var_valide_parc = false;
         this.var_aff_action = true;
         this.visibiliteBtonlig = false;
         this.var_action = 3;
         this.var_memo_action = this.var_action;
         this.onglet01();
      }

   }

   public void supprimerOr() throws HibernateException, NamingException {
      if (this.parcOrEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_or");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.parcOrEnteteDao.delete(this.parcOrEntete);
            this.lesOrEntete.remove(this.parcOrEntete);
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

   public void annulerOr() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.var_affiche_bouton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveOr() throws HibernateException, NamingException, ParseException {
      this.parcOrEntete.setPrcoreTypeCompteur(this.parc.getPrcCompteur());
      this.parcOrEntete.setPrcoreNumChassis(this.parc.getPrcChassis());
      this.parcOrEntete.setPrcoreNumMoteur(this.parc.getPrcMoteur());
      this.parcOrEntete.setPrcoreNumSrie(this.parc.getPrcNumSerie());
      this.parcOrEntete.setPrcoreIdReceptionnaire(this.usersLog.getUsrid());
      this.parcOrEntete.setPrcoreNomReceptionnaire(this.usersLog.getUsrPatronyme());
      this.parcOrEntete.setPrcoreNomChauffeur("");
      if (this.parcOrEntete.getPrcoreIdChauffeur() != 0L) {
         for(int var1 = 0; var1 < this.mesReceptionnairesItems.size(); ++var1) {
            long var2 = Long.parseLong(((SelectItem)this.mesReceptionnairesItems.get(var1)).getValue().toString());
            if (this.parcOrEntete.getPrcoreIdChauffeur() == var2) {
               this.parcOrEntete.setPrcoreNomChauffeur(((SelectItem)this.mesReceptionnairesItems.get(var1)).getLabel().toString());
               break;
            }
         }
      }

      if (this.decoupageActivite) {
         this.parcOrEntete.setPrcoreActivite("");
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

         this.parcOrEntete.setPrcoreActivite(var15);
      }

      Session var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_or");
      Transaction var18 = null;

      try {
         var18 = var17.beginTransaction();
         if (this.parcOrEntete.getPrcoreId() != 0L) {
            this.parcOrEntete.setPrcoreDateModif(new Date());
            this.parcOrEntete.setPrcoreIdModif(this.usersLog.getUsrid());
            this.parcOrEntete = this.parcOrEnteteDao.modif(this.parcOrEntete, var17);
         } else {
            if (this.var_date == null) {
               this.var_date = new Date();
            }

            this.parcOrEntete.setPrcoreDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
            String var19 = this.calculChrono.numCompose(this.parcOrEntete.getPrcoreDate(), this.nature, this.parcOrEntete.getPrcoreSerie(), var17);
            boolean var4 = false;

            while(true) {
               while(!var4) {
                  new ParcOrEntete();
                  ParcOrEntete var5 = this.parcOrEnteteDao.rechercheConsommation(var19, var17);
                  if (var5 != null) {
                     long var6 = 100000000L * this.usersLog.getUsrid();

                     for(long var8 = 0L; var8 < var6; ++var8) {
                     }

                     var19 = this.calculChrono.numCompose(this.parcOrEntete.getPrcoreDate(), this.nature, this.parcOrEntete.getPrcoreSerie(), var17);
                     var4 = false;
                  } else {
                     var4 = true;
                  }
               }

               this.parcOrEntete.setExercicesParc(this.lastExo);
               this.parcOrEntete.setParc(this.parc);
               this.parcOrEntete.setPrcoreEtat(1);
               this.parcOrEntete.setPrcoreEtatVal(0);
               this.parcOrEntete.setPrcoreDateValide((Date)null);
               this.parcOrEntete.setPrcoreNum(var19);
               this.parcOrEntete.setPrcoreDateCreat(new Date());
               this.parcOrEntete.setPrcoreIdCreateur(this.usersLog.getUsrid());
               this.parcOrEntete = this.parcOrEnteteDao.insert(this.parcOrEntete, var17);
               this.lesOrEntete.add(this.parcOrEntete);
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

   public void calculPrix() throws HibernateException, NamingException {
      this.messageStockNegatif = "";
      if (this.structureLog.getStrstockNegatif() == 2) {
         if (this.produitsDepot != null && this.produitsDepot.getProdepQteStk() < this.parcOrPiece.getPrcorpQte() && this.parcOrPiece.getPrcorpQte() != 0.0F) {
            this.validationLigne = 2;
            this.messageStockNegatif = "Quantité demandée : " + this.parcOrPiece.getPrcorpQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
            this.formRecherche.setMessageTexte(this.messageStockNegatif);
            this.formRecherche.setShowModalPanelMessage(true);
         } else {
            this.validationLigne = 0;
         }
      } else if (this.structureLog.getStrstockNegatif() == 1) {
         if (this.produitsDepot != null && this.produitsDepot.getProdepQteStk() < this.parcOrPiece.getPrcorpQte() && this.parcOrPiece.getPrcorpQte() != 0.0F) {
            this.validationLigne = 1;
            this.messageStockNegatif = "Quantité demandée : " + this.parcOrPiece.getPrcorpQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
         } else {
            this.validationLigne = 0;
         }
      } else {
         this.validationLigne = 0;
      }

      if (this.produitsDepot != null && this.produitsDepot.getProdepQteMini() != 0.0F && this.parcOrPiece.getPrcorpQte() != 0.0F && this.produitsDepot.getProdepQteMini() >= this.produitsDepot.getProdepQteStk() - this.parcOrPiece.getPrcorpQte()) {
         this.messageStockNegatif = "Quantité en stock : " + (this.produitsDepot.getProdepQteStk() - this.parcOrPiece.getPrcorpQte()) + " Quantité minimale : " + this.produitsDepot.getProdepQteMini() + " ==> LA QUANTITE MINIMALE A ETE ATTEINTE";
         this.formRecherche.setMessageTexte(this.messageStockNegatif);
         this.formRecherche.setShowModalPanelMessage(true);
      }

      if (this.parcOrPiece != null && this.parcOrPiece.getPrcorpCode() != null && !this.parcOrPiece.getPrcorpCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.parcOrPiece.getPrcorpTaxe(), this.parcOrPiece.getPrcorpTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionParcs.getDecrmtPriVteStock().equals("2")) {
            if (this.parcOrPiece.getPrcorpPuRemTtc() != 0.0D) {
               if (this.parcOrPiece.getPrcorpPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.parcOrPiece.getPrcorpPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.parcOrPiece.getPrcorpPuRem() != 0.0D) {
            if (this.parcOrPiece.getPrcorpPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.parcOrPiece.getPrcorpPu() < this.prixPlancher) {
            this.griserValider = true;
            this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      }

   }

   public void calculPrix(String var1, float var2, Session var3) throws HibernateException, NamingException {
      if (this.optionParcs.getDecrmtPriVteStock().equals("2")) {
         this.calculTtc(var1, var2, var3);
      } else {
         this.calculHt(var1, var2, var3);
      }

   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_or");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.parcOrEntete.getPrcoreExoTva() == 0) {
         TaxesVentes var8;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var7 = var8.getTaxvteType();
            } else if (this.optionParcs.getTvaDefaut() != null && !this.optionParcs.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               TaxesVentes var9 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), this.optionParcs.getTvaDefaut(), var3);
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
         } else if (this.optionParcs.getTvaDefaut() != null && !this.optionParcs.getTvaDefaut().isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), this.optionParcs.getTvaDefaut(), var3);
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

      this.parcOrPiece.setPrcorpTaxe(var6);
      this.parcOrPiece.setPrcorpTauxTaxe(var5);
      double var35 = this.parcOrPiece.getPrcorpPu();
      float var10;
      if (var7 == 3) {
         var10 = 100.0F - var5;
         var35 = this.utilNombre.myRoundDevise(var35 / (double)var10 * 100.0D, this.structureLog.getStrdevise());
      }

      var10 = this.parcOrPiece.getPrcorpQte();
      if (this.parcOrPiece.getPrcorpQte() != 0.0F) {
         this.parcOrPiece.setPrcorpQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.parcOrPiece.getPrcorpCondition(), this.parcOrPiece.getPrcorpQte(), this.parcOrPiece.getPrcorpLong(), this.parcOrPiece.getPrcorpLarg(), this.parcOrPiece.getPrcorpHaut(), this.parcOrPiece.getPrcorpDiam(), this.parcOrPiece.getPrcorpNb(), this.baseLog, this.utilInitHibernate, var3));
      } else {
         this.parcOrPiece.setPrcorpQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.parcOrPiece.getPrcorpCondition() != null && !this.parcOrPiece.getPrcorpCondition().isEmpty() && this.parcOrPiece.getPrcorpCondition().contains(":")) {
         var11 = var35 * (double)var10;
      } else {
         var11 = var35 * (double)var10;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionParcs.getDecrmtRabais().equals("1")) {
         var15 = this.parcOrPiece.getPrcorpRabais();
      } else if (this.optionParcs.getDecrmtRabais().equals("2")) {
         var15 = this.parcOrPiece.getPrcorpRabais() * (double)this.parcOrPiece.getPrcorpQte();
      }

      if (this.parcOrPiece.getPrcorpTauxRemise() != 0.0F) {
         var13 = var11 - var11 * (double)this.parcOrPiece.getPrcorpTauxRemise() / 100.0D - var15;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      double var19 = var17 * (double)this.parcOrPiece.getPrcorpTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var19 *= -1.0D;
      } else if (var7 == 3) {
         var19 = var17 * (double)(this.parcOrPiece.getPrcorpTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      if (this.parcOrPiece.getPrcorpCondition() != null && !this.parcOrPiece.getPrcorpCondition().isEmpty() && this.parcOrPiece.getPrcorpCondition().contains(":")) {
         var25 = this.utilNombre.myRound(var17 / (double)this.parcOrPiece.getPrcorpQte(), 2);
      } else {
         var25 = this.utilNombre.myRound(var17 / (double)this.parcOrPiece.getPrcorpQte(), 2);
      }

      this.parcOrPiece.setPrcorpPuRem(var25);
      this.parcOrPiece.setPrcorpPt(var17);
      this.parcOrPiece.setPrcorpTva(var21);
      this.parcOrPiece.setPrcorpTc(0.0D);
      this.parcOrPiece.setPrcorpTtc(var23);
      double var27 = 0.0D;
      if (this.parcOrPiece.getPrcorpCondition() != null && !this.parcOrPiece.getPrcorpCondition().isEmpty() && this.parcOrPiece.getPrcorpCondition().contains(":")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.parcOrPiece.getPrcorpQte(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.parcOrPiece.getPrcorpQte(), 2);
      }

      this.parcOrPiece.setPrcorpPuRemTtc(var27);
      double var29 = var35 + var35 * (double)this.parcOrPiece.getPrcorpTauxTaxe() / 100.0D;
      this.parcOrPiece.setPrcorpPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.parcOrEntete.setPrcoreTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.parcOrEntete.getPrcoreTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.parcOrPiece.setPrcorpTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = var17 * (double)this.parcOrEntete.getPrcoreTauxTc() / 100.0D;
               if (this.parcOrPiece.getPrcorpTauxTaxe() != 0.0F) {
                  var31 = var17 * (double)this.parcOrEntete.getPrcoreTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
                  double var10000 = var31 + var31 * (double)this.parcOrPiece.getPrcorpTauxTaxe() / 100.0D;
                  this.parcOrPiece.setPrcorpTc(var33);
               }
            }
         } else {
            if (this.parcOrPiece.getPrcorpTva() != 0.0D) {
               var31 = var17 * (double)this.parcOrEntete.getPrcoreTauxTc() / 100.0D;
            } else {
               var31 = 0.0D;
            }

            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.parcOrPiece.setPrcorpTc(var33);
         }
      } else {
         this.parcOrPiece.setPrcorpTc(0.0D);
         this.parcOrEntete.setPrcoreTauxTc(0.0F);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_or");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.parcOrEntete.getPrcoreExoTva() == 0) {
         TaxesVentes var8;
         int var38;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var38 = var8.getTaxvteType();
            } else if (this.optionParcs.getTvaDefaut() != null && !this.optionParcs.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               TaxesVentes var9 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), this.optionParcs.getTvaDefaut(), var3);
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
         } else if (this.optionParcs.getTvaDefaut() != null && !this.optionParcs.getTvaDefaut().isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), this.optionParcs.getTvaDefaut(), var3);
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

         if (this.produits != null && this.produits.isProExoTva() || this.tiers != null && this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            var5 = 0.0F;
            var6 = "";
            var7 = false;
         }
      }

      this.parcOrPiece.setPrcorpTaxe(var6);
      this.parcOrPiece.setPrcorpTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.parcOrEntete.getPrcoreTauxTc() != 0.0F && this.parcOrPiece.getPrcorpTva() != 0.0D) {
         var10 = this.parcOrPiece.getPrcorpTtc();
         var12 = var10 * (double)this.parcOrEntete.getPrcoreTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.parcOrPiece.getPrcorpQte(), Integer.parseInt(this.optionParcs.getNbDecPu()));
      } else {
         var39 = this.parcOrPiece.getPrcorpPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.parcOrPiece.setPrcorpPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionParcs.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionParcs.getDecrmtRabais().equals("1")) {
         var12 = this.parcOrPiece.getPrcorpRabais();
      } else if (this.optionParcs.getDecrmtRabais().equals("2")) {
         var12 = this.parcOrPiece.getPrcorpRabais() * (double)this.parcOrPiece.getPrcorpQte();
      }

      double var14 = 0.0D;
      if (this.parcOrPiece.getPrcorpTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.parcOrPiece.getPrcorpTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.parcOrPiece.getPrcorpTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.parcOrPiece.getPrcorpTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.parcOrPiece.getPrcorpQte() != 0.0F) {
         this.parcOrPiece.setPrcorpQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.parcOrPiece.getPrcorpCondition(), this.parcOrPiece.getPrcorpQte(), this.parcOrPiece.getPrcorpLong(), this.parcOrPiece.getPrcorpLarg(), this.parcOrPiece.getPrcorpHaut(), this.parcOrPiece.getPrcorpDiam(), this.parcOrPiece.getPrcorpNb(), this.baseLog, this.utilInitHibernate, var3));
      } else {
         this.parcOrPiece.setPrcorpQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionParcs.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionParcs.getNbDecPu()));
      double var22 = var18 * (double)this.parcOrPiece.getPrcorpQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var26 = var20 * (double)this.parcOrPiece.getPrcorpQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      this.parcOrPiece.setPrcorpPuRem(var18);
      this.parcOrPiece.setPrcorpPuRemTtc(var20);
      this.parcOrPiece.setPrcorpPt(var24);
      this.parcOrPiece.setPrcorpTva(var32);
      this.parcOrPiece.setPrcorpTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.parcOrEntete.setPrcoreTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.parcOrEntete.getPrcoreTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.parcOrPiece.setPrcorpTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.parcOrEntete.getPrcoreTauxTc() / 100.0D;
               if (this.parcOrPiece.getPrcorpTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.parcOrEntete.getPrcoreTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
                  double var10000 = var34 + var34 * (double)this.parcOrPiece.getPrcorpTauxTaxe() / 100.0D;
                  this.parcOrPiece.setPrcorpTc(var36);
               }
            }
         } else {
            var34 = var24 * (double)this.parcOrEntete.getPrcoreTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.parcOrPiece.setPrcorpTc(var36);
         }
      } else {
         this.parcOrPiece.setPrcorpTc(0.0D);
         this.parcOrEntete.setPrcoreTauxTc(0.0F);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void cumulPrix() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      new ParcOrPiece();

      for(int var8 = 0; var8 < this.lesOrPieces.size(); ++var8) {
         ParcOrPiece var7 = (ParcOrPiece)this.lesOrPieces.get(var8);
         var1 += var7.getPrcorpTotal();
         var3 += var7.getPrcorpPt();
      }

      this.parcOrEntete.setPrcoreCoutPiece(var3);
      this.parcOrEntete.setPrcoreCoutMo(var5);
   }

   public void addLigne() {
      this.parcOrPiece = new ParcOrPiece();
      this.produits = new Produits();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
   }

   public void supprimerLigne() throws HibernateException, NamingException {
      if (this.parcOrPiece != null) {
         this.parcOrPieceDao.deleteOnLigne(this.parcOrPiece);
         this.lesOrPieces.remove(this.parcOrPiece);
         this.dataModelOrPiece.setWrappedData(this.lesOrPieces);
         this.cumulPrix();
      }

   }

   public void selectionnerPiece() {
      if (this.dataModelOrPiece.isRowAvailable()) {
         this.parcOrPiece = (ParcOrPiece)this.dataModelOrPiece.getRowData();
      }

   }

   public void validerPiece() throws HibernateException, NamingException, ParseException {
      if (this.parcOrPiece.getPrcorpQte() != 0.0F || this.parcOrPiece.getPrcorpCode() != null && !this.parcOrPiece.getPrcorpCode().isEmpty() && (this.parcOrPiece.getPrcorpCode().equals("-") || this.parcOrPiece.getPrcorpCode().equals("+") || this.parcOrPiece.getPrcorpCode().equals("="))) {
         if (this.parcOrEntete.getPrcoreId() == 0L) {
            this.saveOr();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_or");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.calculPrix(this.parcOrPiece.getPrcorpTaxe(), this.parcOrPiece.getPrcorpTauxTaxe(), var1);
            if (this.produits != null && this.parcOrPiece.getPrcorpDepot() != null && !this.parcOrPiece.getPrcorpDepot().isEmpty()) {
               if (this.parcOrPiece.getPrcorpDepot().contains(":")) {
                  String[] var3 = this.parcOrPiece.getPrcorpDepot().split(":");
                  this.parcOrPiece.setPrcorpDepot(var3[0]);
               } else {
                  this.parcOrPiece.setPrcorpDepot(this.parcOrPiece.getPrcorpDepot());
               }
            }

            if (this.parcOrPiece.getPrcorpId() == 0L) {
               this.parcOrPiece.setParcOrEntete(this.parcOrEntete);
               this.parcOrPiece = this.parcOrPieceDao.insertLigne(this.parcOrPiece, var1);
               this.lesOrPieces.add(this.parcOrPiece);
               this.dataModelOrPiece.setWrappedData(this.lesOrPieces);
            } else {
               this.parcOrPiece = this.parcOrPieceDao.modifLigne(this.parcOrPiece, var1);
            }

            this.cumulPrix();
            this.parcOrEntete = this.parcOrEnteteDao.modif(this.parcOrEntete, var1);
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

   public void extractCodeUnite() throws HibernateException, NamingException {
      this.extractCodeUnite((Session)null);
   }

   public void extractCodeUnite(Session var1) throws HibernateException, NamingException {
      if (this.parcOrPiece.getPrcorpUnite() != null && !this.parcOrPiece.getPrcorpUnite().isEmpty() && this.parcOrPiece.getPrcorpUnite().contains(":")) {
         String[] var2 = this.parcOrPiece.getPrcorpUnite().split(":");
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
      if (this.parcOrPiece.getPrcorpCode() != null && !this.parcOrPiece.getPrcorpCode().isEmpty() && !this.parcOrPiece.getPrcorpCode().equals("-") && !this.parcOrPiece.getPrcorpCode().equals("=")) {
         if (this.tiers == null || this.tiers.getTiedepot() == null || this.tiers.getTiedepot().isEmpty() || !this.tiers.getTiedepot().contains(":")) {
            this.produits = this.formRecherche.rechercheProduitParc(this.parcOrPiece.getPrcorpCode(), this.nature, this.optionParcs);
         }

         if (this.produits != null) {
            if (this.produits.getProId() != 0L) {
               this.calculeProduits();
            } else if (this.optionParcs.getType().equals("0")) {
               this.var_action = 15;
            } else {
               this.var_action = 16;
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_or");
         this.parcOrPiece.setPrcorpCode(this.produits.getProCode());
         String var2;
         String var3;
         if (this.optionParcs.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionParcs.getLibelleProduit().equals("0")) {
               this.parcOrPiece.setPrcorpLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionParcs.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.parcOrPiece.setPrcorpLibelle(var2 + var3);
            } else if (this.optionParcs.getLibelleProduit().equals("2")) {
               this.parcOrPiece.setPrcorpLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionParcs.getLibelleProduit().equals("0")) {
            this.parcOrPiece.setPrcorpLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionParcs.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.parcOrPiece.setPrcorpLibelle(var2 + var3);
         } else if (this.optionParcs.getLibelleProduit().equals("2")) {
            this.parcOrPiece.setPrcorpLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.parcOrPiece.setPrcorpFamille(this.produits.getProVteCode());
         this.parcOrPiece.setPrcorpStock(this.produits.getProStock());
         this.parcOrPiece.setPrcorpLong(this.produits.getProLongueur());
         this.parcOrPiece.setPrcorpLarg(this.produits.getProLargeur());
         this.parcOrPiece.setPrcorpHaut(this.produits.getProEpaisseur());
         this.parcOrPiece.setPrcorpDiam(this.produits.getProDiamExt());
         this.parcOrPiece.setPrcorpPoidsBrut(this.produits.getProPoidsBrut());
         this.parcOrPiece.setPrcorpPoidsNet(this.produits.getProPoidsNet());
         this.parcOrPiece.setPrcorpVolume(this.produits.getProVolume());
         this.parcOrPiece.setPrcorpNb(this.produits.getProNbUnite());
         this.parcOrPiece.setPrcorpReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.mesTaxesVentesProduits.clear();
         new FamillesProduitsVentes();
         FamillesProduitsVentes var8 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExo.getExeprcId(), this.produits, var1);
         if (this.produits.isProExoTva() || this.tiers != null && this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            this.parcOrPiece.setPrcorpTaxe("");
            this.parcOrPiece.setPrcorpTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         } else {
            TaxesVentes var9;
            if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty() && !this.produits.getProVteTva().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExo.getExeprcId(), this.produits.getProVteTva(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.produits.getProVteTva(), this.produits.getProVteTva() + ":" + var9.getTaxvteTaux()));
                  this.parcOrPiece.setPrcorpTaxe(this.produits.getProVteTva());
                  this.parcOrPiece.setPrcorpTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.parcOrPiece.setPrcorpTaxe("");
                  this.parcOrPiece.setPrcorpTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExo.getExeprcId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.parcOrPiece.setPrcorpTaxe(var8.getFamvteTaxe());
                  this.parcOrPiece.setPrcorpTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.parcOrPiece.setPrcorpTaxe("");
               this.parcOrPiece.setPrcorpTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.parcOrEntete.getPrcoreExoTva() == 0 && (this.parcOrPiece.getPrcorpTaxe() == null || this.parcOrPiece.getPrcorpTaxe().isEmpty()) && this.optionParcs.getTvaDefaut() != null && !this.optionParcs.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExo.getExeprcId(), this.optionParcs.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.parcOrPiece.setPrcorpTaxe(var9.getTaxvteCode());
                  this.parcOrPiece.setPrcorpTauxTaxe(var9.getTaxvteTaux());
               }
            }
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionParcs.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.parcOrPiece.getPrcorpTauxTaxe() / 100.0D;
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
               this.parcOrPiece.setPrcorpUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.parcOrPiece.setPrcorpUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.parcOrPiece.setPrcorpUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.parcOrPiece.setPrcorpCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.parcOrPiece.setPrcorpCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.parcOrPiece.getPrcorpPump() != 0.0D) {
            this.parcOrPiece.setPrcorpPu(this.parcOrPiece.getPrcorpPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.parcOrPiece.getPrcorpTaxe(), this.parcOrPiece.getPrcorpTauxTaxe(), var1);
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
      if (this.parcOrPiece.getPrcorpCode() == null || this.parcOrPiece.getPrcorpCode().isEmpty() || this.parcOrPiece.getPrcorpCode().length() < 2) {
         if (this.parcOrEntete.getPrcoreExoTva() == 0 && this.tiers.getTiefacpr() <= 1 && this.tiers.getTieexotva() == 0) {
            if (this.mesTaxesVentesProduits.isEmpty()) {
               this.mesTaxesVentesProduits.clear();
               if (this.mesTaxesVentesItems.size() != 0) {
                  for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
                     this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
                  }
               }

               if (this.optionParcs.getTvaDefaut() != null && !this.optionParcs.getTvaDefaut().isEmpty()) {
                  this.parcOrPiece.setPrcorpTaxe(this.optionParcs.getTvaDefaut());
               }
            }
         } else {
            this.mesTaxesVentesProduits.clear();
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.parcOrPiece.setPrcorpCode("");
      this.parcOrPiece.setPrcorpLibelle("");
      this.mesTaxesVentesProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_code_unite = 0;
      this.prixPlancher = 0.0D;
      this.griserValider = false;
      this.var_action = this.var_memo_action;
   }

   public void prixUnitaireCorrespond(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         double var2 = 0.0D;
         if (this.optionParcs.getDecrmtPriVteStock().equals("2")) {
            var2 = this.parcOrPiece.getPrcorpPuTtc();
         } else {
            var2 = this.parcOrPiece.getPrcorpPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(var1);
         }

         if (this.optionParcs.getDecrmtPriVteStock().equals("2")) {
            this.parcOrPiece.setPrcorpPuTtc(this.prixUnitaires);
            this.parcOrPiece.setPrcorpPuRemTtc(this.prixUnitaires);
         } else {
            this.parcOrPiece.setPrcorpPu(this.prixUnitaires);
            this.parcOrPiece.setPrcorpPuRem(this.prixUnitaires);
         }

         double var4 = 0.0D;
         if (this.verifBareme) {
            Baremes var6 = new Baremes();
            Baremes var7 = new Baremes();
            new ArrayList();
            long var9 = 0L;
            String var11 = "";
            String var12 = "";
            if (this.tiers != null) {
               var9 = this.tiers.getTieid();
               var11 = this.tiers.getTienomfamille();
               var12 = this.tiers.getTiecategorie();
            }

            List var8 = this.baremesDao.rechercheToutBaremeProduit(var9, this.produits.getProCode(), this.produits.getProVteCode(), var11, var1);
            if (var8.size() != 0) {
               int var13;
               for(var13 = 0; var13 < var8.size(); ++var13) {
                  var6 = (Baremes)var8.get(var13);
                  if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarIdTiers() == var9 && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                     var4 = var6.getBarPrix();
                     var7 = var6;
                     break;
                  }
               }

               if (var4 == 0.0D) {
                  for(var13 = 0; var13 < var8.size(); ++var13) {
                     var6 = (Baremes)var8.get(var13);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarCategorieTiers() != null && !var6.getBarCategorieTiers().isEmpty() && var6.getBarCategorieTiers().equals(var12) && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 == 0.0D) {
                  for(var13 = 0; var13 < var8.size(); ++var13) {
                     var6 = (Baremes)var8.get(var13);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarIdTiers() == var9 && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 == 0.0D) {
                  for(var13 = 0; var13 < var8.size(); ++var13) {
                     var6 = (Baremes)var8.get(var13);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarCategorieTiers() != null && !var6.getBarCategorieTiers().isEmpty() && var6.getBarCategorieTiers().equals(var12) && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 == 0.0D) {
                  for(var13 = 0; var13 < var8.size(); ++var13) {
                     var6 = (Baremes)var8.get(var13);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && (var6.getBarCategorieTiers() == null || var6.getBarCategorieTiers().isEmpty()) && var6.getBarIdTiers() == 0L && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 != 0.0D) {
                  this.prixUnitaires = var4;
               }

               if (this.prixUnitaires == 0.0D) {
                  for(var13 = 0; var13 < var8.size(); ++var13) {
                     var6 = (Baremes)var8.get(var13);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && (var6.getBarCategorieTiers() == null || var6.getBarCategorieTiers().isEmpty()) && var6.getBarIdTiers() == 0L && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                        this.prixUnitaires = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var7 != null && var7.getBarId() != 0L) {
                  double var15;
                  if (var6.getBarRemise() != 0.0F) {
                     this.parcOrPiece.setPrcorpTauxRemise(var6.getBarRemise());
                     this.parcOrPiece.setPrcorpRabais(var6.getBarRabais());
                     var15 = 0.0D;
                     var15 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.structureLog.getStrdevise());
                     if (this.optionParcs.getDecrmtPriVteStock().equals("2")) {
                        this.parcOrPiece.setPrcorpPuTtc(this.prixUnitaires);
                        this.parcOrPiece.setPrcorpPuRemTtc(var15);
                     } else {
                        this.parcOrPiece.setPrcorpPu(this.prixUnitaires);
                        this.parcOrPiece.setPrcorpPuRem(var15);
                     }
                  } else if (var6.getBarRabais() != 0.0D) {
                     this.parcOrPiece.setPrcorpTauxRemise(var6.getBarRemise());
                     this.parcOrPiece.setPrcorpRabais(var6.getBarRabais());
                     var15 = 0.0D;
                     if (this.optionParcs.getDecrmtRabais().equals("2")) {
                        var15 = this.prixUnitaires - var6.getBarRabais() * (double)this.parcOrPiece.getPrcorpQte();
                     } else {
                        var15 = this.prixUnitaires - var6.getBarRabais();
                     }

                     if (this.optionParcs.getDecrmtPriVteStock().equals("2")) {
                        this.parcOrPiece.setPrcorpPuTtc(this.prixUnitaires);
                        this.parcOrPiece.setPrcorpPuRemTtc(var15);
                     } else {
                        this.parcOrPiece.setPrcorpPu(this.prixUnitaires);
                        this.parcOrPiece.setPrcorpPuRem(var15);
                     }
                  } else if (var6.getBarPrix() != 0.0D) {
                     this.parcOrPiece.setPrcorpTauxRemise(var6.getBarRemise());
                     this.parcOrPiece.setPrcorpRabais(var6.getBarRabais());
                     this.prixUnitaires = var6.getBarPrix();
                     if (this.optionParcs.getDecrmtPriVteStock().equals("2")) {
                        this.parcOrPiece.setPrcorpPuTtc(this.prixUnitaires);
                        this.parcOrPiece.setPrcorpPuRemTtc(this.prixUnitaires);
                     } else {
                        this.parcOrPiece.setPrcorpPu(this.prixUnitaires);
                        this.parcOrPiece.setPrcorpPuRem(this.prixUnitaires);
                     }
                  }
               }

               if (this.prixUnitaires == 0.0D) {
                  this.prixUnitaires = var2;
                  if (this.optionParcs.getDecrmtPriVteStock().equals("2")) {
                     this.parcOrPiece.setPrcorpPuTtc(this.prixUnitaires);
                     this.parcOrPiece.setPrcorpPuRemTtc(this.prixUnitaires);
                  } else {
                     this.parcOrPiece.setPrcorpPu(this.prixUnitaires);
                     this.parcOrPiece.setPrcorpPuRem(this.prixUnitaires);
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
            this.prixUnitaires = 0.0D;
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            this.prixUnitaires = 0.0D;
         }
      } else {
         this.prixUnitaires = 0.0D;
      }

      var1 = this.prixUnitaires;
      return var1;
   }

   public void prixUnitaireDegressif(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         double var2 = this.parcOrPiece.getPrcorpPu();
         double var4 = this.parcOrPiece.getPrcorpPuTtc();
         if (this.parcOrPiece.getPrcorpPu() >= 0.0D && this.parcOrPiece.getPrcorpPuTtc() >= 0.0D) {
            new ProduitsTarif();
            ProduitsTarif var6 = this.produitsTarifDao.prixUnitaireCorrespond(this.produits.getProId(), this.parcOrEntete.getPrcoreCat(), (String)null, var1);
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
                     if (this.parcOrPiece.getPrcorpQte() >= var7.getQteDebut() && this.parcOrPiece.getPrcorpQte() <= var7.getQteFin()) {
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
                        if (this.parcOrPiece.getPrcorpQte() >= var7.getQteDebut() && this.parcOrPiece.getPrcorpQte() <= var7.getQteFin()) {
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
            } else if (this.optionParcs.getDecrmtPriVteStock().equals("2")) {
               this.prixUnitaires = var4;
            } else {
               this.prixUnitaires = var2;
            }
         } else {
            var2 = Math.abs(this.parcOrPiece.getPrcorpPu());
            var4 = Math.abs(this.parcOrPiece.getPrcorpPuTtc());
            if (this.optionParcs.getDecrmtPriVteStock().equals("2")) {
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
      this.parcOrPiece.setPrcorpUnite(this.produitsDepot.getProdepUnite());
   }

   public void selectionDepot(Session var1) throws HibernateException, NamingException {
      this.messageStockNegatif = "";
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
               this.validationLigne = 0;
            } else {
               this.var_code_unite = this.produitsDepot.getProdepEchelle();
               if (this.structureLog.getStrstockNegatif() == 2) {
                  if (this.produitsDepot.getProdepQteStk() < this.parcOrPiece.getPrcorpQte() && this.parcOrPiece.getPrcorpQte() != 0.0F) {
                     this.validationLigne = 2;
                     this.messageStockNegatif = "Quantité demandée : " + this.parcOrPiece.getPrcorpQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
                     this.formRecherche.setMessageTexte(this.messageStockNegatif);
                     this.formRecherche.setShowModalPanelMessage(true);
                  } else {
                     this.validationLigne = 0;
                  }
               } else if (this.structureLog.getStrstockNegatif() == 1) {
                  if (this.produitsDepot.getProdepQteStk() < this.parcOrPiece.getPrcorpQte() && this.parcOrPiece.getPrcorpQte() != 0.0F) {
                     this.validationLigne = 1;
                     this.messageStockNegatif = "Quantité demandée : " + this.parcOrPiece.getPrcorpQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
                  } else {
                     this.validationLigne = 0;
                  }
               } else {
                  this.validationLigne = 0;
               }
            }
         } else {
            this.produitsDepot = null;
            this.var_depotProd = "";
            this.var_code_unite = 0;
            this.validationLigne = 0;
         }
      } else {
         this.produitsDepot = null;
         this.var_depotProd = "";
         this.var_code_unite = 0;
         this.validationLigne = 0;
      }

      if (this.produitsDepot != null) {
         double var9 = 0.0D;
         float var4;
         if (this.parcOrPiece.getPrcorpCondition() != null && !this.parcOrPiece.getPrcorpCondition().isEmpty() && this.parcOrPiece.getPrcorpCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.parcOrPiece.getPrcorpEchelle());
            float var5 = 1.0F;
            if (this.parcOrPiece.getPrcorpCondition().contains("/")) {
               String[] var6 = this.parcOrPiece.getPrcorpCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.parcOrPiece.getPrcorpCondition() != null && !this.parcOrPiece.getPrcorpCondition().isEmpty() && !this.parcOrPiece.getPrcorpCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.parcOrPiece.getPrcorpEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.parcOrPiece.setPrcorpPump(var9);
      } else {
         this.parcOrPiece.setPrcorpPump(0.0D);
      }

   }

   public void selectionConditionnement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_or");
      this.mefConditionnementDepot(var1);
      this.prixUnitaireCorrespond(var1);
      this.selectionDepot(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.parcOrPiece.getPrcorpCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.parcOrPiece.setPrcorpEchelle(this.unite.getUniEchelle());
               } else {
                  this.parcOrPiece.setPrcorpEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.parcOrPiece.setPrcorpEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.parcOrPiece.setPrcorpEchelle(Integer.parseInt(var2));
         } else {
            this.parcOrPiece.setPrcorpEchelle(0);
         }

         this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
         if (this.listeProduitDepot.size() != 0) {
            for(int var10 = 0; var10 < this.listeProduitDepot.size(); ++var10) {
               ProduitsDepot var11 = (ProduitsDepot)this.listeProduitDepot.get(var10);
               float var12 = 0.0F;
               if (this.optionParcs.getChoixStock().equals("1")) {
                  var12 = var11.getProdepQteStk() - var11.getProdepQteAttVte();
               } else {
                  var12 = var11.getProdepQteStk();
               }

               String var6 = "";
               int var7;
               if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.parcOrPiece.getPrcorpLong(), this.parcOrPiece.getPrcorpLarg(), this.parcOrPiece.getPrcorpHaut(), this.parcOrPiece.getPrcorpDiam(), this.parcOrPiece.getPrcorpNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.parcOrPiece.getPrcorpLong(), this.parcOrPiece.getPrcorpLarg(), this.parcOrPiece.getPrcorpHaut(), this.parcOrPiece.getPrcorpDiam(), this.parcOrPiece.getPrcorpNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else {
                  var6 = "" + var12;
               }

               String[] var13;
               if (this.tiers != null && this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
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

   public void calculReceptionnaire(Session var1) throws HibernateException, NamingException {
      this.mesReceptionnairesItems.clear();
      if (this.parcOrEntete.getPrcoreService() != null && !this.parcOrEntete.getPrcoreService().isEmpty()) {
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesUsersByServices(this.parcOrEntete.getPrcoreService(), var1);
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
      if (this.decoupageActivite && this.parcOrEntete.getPrcoreActivite() != null && !this.parcOrEntete.getPrcoreActivite().isEmpty() && this.parcOrEntete.getPrcoreActivite().contains(":")) {
         String[] var1 = null;
         if (!this.parcOrEntete.getPrcoreActivite().contains("#")) {
            var1 = this.parcOrEntete.getPrcoreActivite().split(":");
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
            String[] var2 = this.parcOrEntete.getPrcoreActivite().split("#");

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

   public void chargerMotifEntree(Session var1) throws HibernateException, NamingException {
      this.mesMotifsEntreeItems.clear();
      this.mesMotifsEntreeItems = this.motifEntreeParcDao.selectActifMotifEntreeItems(this.parcOrEntete.getPrcoreType(), var1);
   }

   public void chargerLignes(Session var1) throws HibernateException, NamingException {
      this.lesOrPieces.clear();
      this.lesOrPiecesReel.clear();
      this.lesOrMo.clear();
      this.lesOrMoReel.clear();
      new ArrayList();
      List var2 = this.parcOrPieceDao.chargerLesLignes(this.parcOrEntete, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((ParcOrPiece)var2.get(var3)).getPrcorpType() == 0) {
               if (((ParcOrPiece)var2.get(var3)).getPrcorpMode() == 0) {
                  this.lesOrPieces.add(var2.get(var3));
               } else {
                  this.lesOrPiecesReel.add(var2.get(var3));
               }
            } else if (((ParcOrPiece)var2.get(var3)).getPrcorpMode() == 0) {
               this.lesOrMo.add(var2.get(var3));
            } else {
               this.lesOrMoReel.add(var2.get(var3));
            }
         }
      }

      this.dataModelOrPiece.setWrappedData(this.lesOrPieces);
      this.dataModelOrPieceReel.setWrappedData(this.lesOrPiecesReel);
      this.dataModelOrMo.setWrappedData(this.lesOrMo);
      this.dataModelOrMoReel.setWrappedData(this.lesOrMoReel);
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
      this.lesProduits.clear();
      this.lesProdtuisItems.clear();
      this.lesDepotsItems.clear();
      if (this.parc != null) {
         if (this.parc.getPrcAlimentation() != 0 && this.parc.getPrcAlimentation() != 1 && this.parc.getPrcAlimentation() != 2 && this.parc.getPrcAlimentation() != 3 && this.parc.getPrcAlimentation() != 4 && this.parc.getPrcAlimentation() != 5 && this.parc.getPrcAlimentation() != 6 && this.parc.getPrcAlimentation() != 7 && this.parc.getPrcAlimentation() != 8 && this.parc.getPrcAlimentation() != 9 && this.parc.getPrcAlimentation() != 10 && this.parc.getPrcAlimentation() != 11 && this.parc.getPrcAlimentation() == 12) {
         }

         if (this.lesProdtuisItems.size() == 0) {
            this.lesProdtuisItems.add(new SelectItem("", ""));
            this.lesDepotsItems.add(new SelectItem("", ""));
         }

         this.immatriculation = this.parc.getPrcImmatriculation();
         this.typeCompteur = this.parc.getLibCompteur();
         this.tiers = this.parcOrEntete.getTiers();
         this.var_valide_parc = true;
         this.visibiliteBtonlig = true;
      } else {
         this.parc = null;
         this.tiers = null;
         this.immatriculation = "";
         this.typeCompteur = "";
         this.lesProdtuisItems.clear();
         this.lesProdtuisItems.add(new SelectItem("", ""));
         this.lesDepotsItems.clear();
         this.lesDepotsItems.add(new SelectItem("", ""));
         this.var_valide_parc = false;
         this.visibiliteBtonlig = false;
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleParc() {
      this.parc = null;
      this.tiers = null;
      this.immatriculation = "";
      this.typeCompteur = "";
      this.var_action = 0;
      this.lesProduits.clear();
      this.lesProdtuisItems.clear();
      this.lesProdtuisItems.add(new SelectItem("", ""));
      this.lesDepotsItems.clear();
      this.lesDepotsItems.add(new SelectItem("", ""));
      this.var_valide_parc = false;
      this.visibiliteBtonlig = false;
      this.var_action = this.var_memo_action;
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
      this.montant_lettre = this.utilNombre.begin(this.parcOrEntete.getPrcorePvMo() + this.parcOrEntete.getPrcorePvPiece(), this.structureLog.getStrdevise());
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
      if (this.parcOrEntete.getPrcoreAnal2() != null && !this.parcOrEntete.getPrcoreAnal2().isEmpty()) {
         String var4 = "";
         if (this.parcOrEntete.getPrcoreAnal2().contains(":")) {
            String[] var5 = this.parcOrEntete.getPrcoreAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.parcOrEntete.getPrcoreAnal2();
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

   public ParcOrEntete getParcOrEntete() {
      return this.parcOrEntete;
   }

   public void setParcOrEntete(ParcOrEntete var1) {
      this.parcOrEntete = var1;
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

   public List getLesDepotsItems() {
      return this.lesDepotsItems;
   }

   public void setLesDepotsItems(List var1) {
      this.lesDepotsItems = var1;
   }

   public List getLesProdtuisItems() {
      return this.lesProdtuisItems;
   }

   public void setLesProdtuisItems(List var1) {
      this.lesProdtuisItems = var1;
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

   public List getMesMotifsEntreeItems() {
      return this.mesMotifsEntreeItems;
   }

   public void setMesMotifsEntreeItems(List var1) {
      this.mesMotifsEntreeItems = var1;
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

   public ParcOrPiece getParcOrPiece() {
      return this.parcOrPiece;
   }

   public void setParcOrPiece(ParcOrPiece var1) {
      this.parcOrPiece = var1;
   }

   public DataModel getDataModelOrPiece() {
      return this.dataModelOrPiece;
   }

   public void setDataModelOrPiece(DataModel var1) {
      this.dataModelOrPiece = var1;
   }

   public boolean isAffichagePump() {
      return this.affichagePump;
   }

   public void setAffichagePump(boolean var1) {
      this.affichagePump = var1;
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

   public boolean isVar_aff_detail_prod() {
      return this.var_aff_detail_prod;
   }

   public void setVar_aff_detail_prod(boolean var1) {
      this.var_aff_detail_prod = var1;
   }

   public List getMesUnitesProduits() {
      return this.mesUnitesProduits;
   }

   public void setMesUnitesProduits(List var1) {
      this.mesUnitesProduits = var1;
   }

   public boolean isVar_aff_condit() {
      return this.var_aff_condit;
   }

   public void setVar_aff_condit(boolean var1) {
      this.var_aff_condit = var1;
   }

   public int getValidationLigne() {
      return this.validationLigne;
   }

   public void setValidationLigne(int var1) {
      this.validationLigne = var1;
   }

   public double getPrixPlancher() {
      return this.prixPlancher;
   }

   public void setPrixPlancher(double var1) {
      this.prixPlancher = var1;
   }

   public List getMesConditionnementsProduits() {
      return this.mesConditionnementsProduits;
   }

   public void setMesConditionnementsProduits(List var1) {
      this.mesConditionnementsProduits = var1;
   }

   public List getMesTaxesVentesProduits() {
      return this.mesTaxesVentesProduits;
   }

   public void setMesTaxesVentesProduits(List var1) {
      this.mesTaxesVentesProduits = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public int getVar_code_unite() {
      return this.var_code_unite;
   }

   public void setVar_code_unite(int var1) {
      this.var_code_unite = var1;
   }

   public List getMesTaxesVentesItems() {
      return this.mesTaxesVentesItems;
   }

   public void setMesTaxesVentesItems(List var1) {
      this.mesTaxesVentesItems = var1;
   }

   public boolean isVerifBareme() {
      return this.verifBareme;
   }

   public void setVerifBareme(boolean var1) {
      this.verifBareme = var1;
   }

   public String getMessageStockNegatif() {
      return this.messageStockNegatif;
   }

   public void setMessageStockNegatif(String var1) {
      this.messageStockNegatif = var1;
   }

   public String getVar_depotProd() {
      return this.var_depotProd;
   }

   public void setVar_depotProd(String var1) {
      this.var_depotProd = var1;
   }

   public boolean isVar_aff_detail_tiers() {
      return this.var_aff_detail_tiers;
   }

   public void setVar_aff_detail_tiers(boolean var1) {
      this.var_aff_detail_tiers = var1;
   }

   public boolean isVar_aff_unite() {
      return this.var_aff_unite;
   }

   public void setVar_aff_unite(boolean var1) {
      this.var_aff_unite = var1;
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

   public DataModel getDataModelOrPieceReel() {
      return this.dataModelOrPieceReel;
   }

   public void setDataModelOrPieceReel(DataModel var1) {
      this.dataModelOrPieceReel = var1;
   }

   public DataModel getDataModelOrMo() {
      return this.dataModelOrMo;
   }

   public void setDataModelOrMo(DataModel var1) {
      this.dataModelOrMo = var1;
   }

   public DataModel getDataModelOrMoReel() {
      return this.dataModelOrMoReel;
   }

   public void setDataModelOrMoReel(DataModel var1) {
      this.dataModelOrMoReel = var1;
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

   public boolean isVerrouRabais() {
      return this.verrouRabais;
   }

   public void setVerrouRabais(boolean var1) {
      this.verrouRabais = var1;
   }

   public String getLibelleRabRis() {
      return this.libelleRabRis;
   }

   public void setLibelleRabRis(String var1) {
      this.libelleRabRis = var1;
   }
}
