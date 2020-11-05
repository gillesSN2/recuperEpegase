package com.epegase.forms.achats;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.AvoirLigneAchats;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.BesoinLigneVentes;
import com.epegase.systeme.classe.BonEntreeEntete;
import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.classe.BonSortieEntete;
import com.epegase.systeme.classe.BonSortieLigne;
import com.epegase.systeme.classe.Cadeaux;
import com.epegase.systeme.classe.CessionEntete;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.classe.ChargementLigne;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.ContratLigneVentes;
import com.epegase.systeme.classe.CotationLigneAchats;
import com.epegase.systeme.classe.DemandeLigneAchats;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.FraisLigneAchats;
import com.epegase.systeme.classe.InventaireEntete;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.LivraisonLivreeVentes;
import com.epegase.systeme.classe.NoteDebitLigneAchats;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.ParcConsommation;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.ProcessEnteteAchats;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ProduitsGrp;
import com.epegase.systeme.classe.ProduitsHistoRef;
import com.epegase.systeme.classe.ProduitsMcles;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.PumpAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.TicketLigneVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.CalculPrp;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.BesoinLigneVentesDao;
import com.epegase.systeme.dao.BonEntreeEnteteDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieEnteteDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.CadeauxDao;
import com.epegase.systeme.dao.CessionEnteteDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.ChargementLigneDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.ContratLigneVentesDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DemandeLigneAchatsDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.InventaireEnteteDao;
import com.epegase.systeme.dao.InventaireLigneDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.LivraisonLivreeVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ParcConsommationDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.ProcessEnteteAchatsDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsGrpDao;
import com.epegase.systeme.dao.ProduitsHistoRefDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.PumpAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TicketLigneVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.utilitaires.Utilitaires_RecalculPUMP;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LireLesoptionsGroupe;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionGroupe;
import com.epegase.systeme.xml.OptionVentes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
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
import javax.servlet.http.HttpServletResponse;
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

public class FormProduitsAchs implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private List mesOnglets;
   private OptionAchats optionAchats;
   private OptionVentes optionsVentes = new OptionVentes();
   private ExercicesAchats exercicesAchats;
   private ExercicesVentes exercicesVentes;
   private ExercicesComptable exercicesComptable;
   private Produits produits;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private int var_nb_max = 100;
   private String pageIndex;
   private int typeVente;
   private List mesMarquesItems;
   private List mesFamillesItems;
   private List lesProduits = new ArrayList();
   private transient DataModel datamodelProduit = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private String var_NatureFinf;
   private String var_MarqueFind;
   private String var_FamilleFind;
   private String var_SousFamilleFind;
   private String var_ServiceFind;
   private String var_ActiviteFind;
   private String var_TypeFind;
   private String var_DepotFind;
   private String var_CodFind;
   private String var_RefFind;
   private String var_LibFind;
   private String inpDepot;
   private String inpNatureVnt = "";
   private String inpNatureAch = "";
   private String codeNatureAchat = "";
   private String inpFamilleVnt = "";
   private String inpFamilleAch = "";
   private boolean afficheButtSup = false;
   private boolean afficheButtOption = false;
   private boolean afficheButtPanier = false;
   private int var_action = 0;
   private boolean afficheProgress = false;
   private int var_inactif = 0;
   private boolean var_more_search = false;
   private boolean verouxCod;
   private boolean existCod = false;
   private int lgNumProd;
   private ServiceDao serviceDao;
   private ActivitesDao activitesDao;
   private int inpTypTar;
   private boolean inpInactifProdTarif;
   private int desactiveModifprodTar;
   private boolean afficheButtModifProdTar = false;
   private boolean afficheButtSuppProdTar = false;
   private boolean afficheButtSuppProdServ = false;
   private ProduitsTarifDao produitsTarifDao;
   private ProduitsTarif produitsTarif;
   private List lesProduitsTarif = new ArrayList();
   private transient DataModel datamodelTarif = new ListDataModel();
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private FamillesProduitsVentes famillesProduitsVentes;
   private FamillesProduitsAchats famillesProduitsAchats;
   private FamillesProduitsAchatsDao famillesProduitsAchatsDao;
   private TaxesAchatsDao taxesAchatsDao;
   private TaxesVentesDao taxesVentesDao;
   private String disable;
   private String messageBut = "";
   private String description;
   private List lesFamillesclients;
   private PlanComptableDao planComptableDao;
   private List lesProduitsServices = new ArrayList();
   private String tarifOrdClt;
   private boolean testDoubleProduitsTarif = false;
   private String htTtc;
   private boolean familleAch = false;
   private boolean familleVte = false;
   private boolean changeFamilleAch = false;
   private boolean changeFamilleVte = false;
   private boolean libelle_libre = false;
   private List mesSousFamillesItems = new ArrayList();
   private boolean afficheSousFamille = false;
   private boolean afficheQteNbUnite;
   private String memoAnalytique;
   private UtilDownload utilDownload = new UtilDownload();
   private boolean var_affFicPdf;
   private String urlphotoProd;
   private boolean existPdfFile;
   private String fileName;
   private String pdfFileName;
   private UploadedFile uploadedFile;
   private UploadedFile uploadedPDFFile;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private Unite unite = new Unite();
   private UniteDao uniteDao;
   private ProduitsAchsDao produitsAchsDao;
   private DepotAchats depotAchats;
   private transient DataModel datamodelDepot = new ListDataModel();
   private boolean afficheButtModifDepProd = false;
   private boolean afficheButtSuppDepProd = false;
   private List lesProduitsDepos = new ArrayList();
   private ProduitsDepotDao produitsDepotDao;
   private ProduitsDepot produitsDepot;
   private boolean existCodDepot = false;
   private String titeleValidDep;
   private boolean inpInactifProdDep = false;
   private boolean showModalProduitDepot = false;
   private boolean showModalMotCles = false;
   private List lesProduitsMcles = new ArrayList();
   private ProduitsMclesDao produitsMclesDao;
   private ProduitsMcles produitsMcles;
   private boolean inpInactifProdMotCle;
   private int desactiveModifprodMotCle;
   private boolean afficheButtModifProdMotCle = false;
   private transient DataModel datamodelMotCle = new ListDataModel();
   private Date var_date_debut;
   private Date var_date_fin;
   private String var_depot;
   private String var_activites;
   private String var_services;
   private transient DataModel datamodelMvt = new ListDataModel();
   private List lesMvt = new ArrayList();
   private Stock stock = new Stock();
   private boolean var_mvt_as_inventaire = false;
   private boolean var_mvt_as_bin = false;
   private boolean var_mvt_as_bout = false;
   private boolean var_mvt_as_cession = false;
   private boolean var_mvt_as_fabrication = false;
   private boolean var_mvt_as_production = false;
   private boolean var_mvt_ss_fcotation = false;
   private boolean var_mvt_ss_fcommande = false;
   private boolean var_mvt_as_freception = false;
   private boolean var_mvt_as_fsav = false;
   private boolean var_mvt_ss_ffacture = false;
   private boolean var_mvt_ss_favoir = false;
   private boolean var_mvt_ss_cdevis = false;
   private boolean var_mvt_ss_ccmd = false;
   private boolean var_mvt_as_cbl = false;
   private boolean var_mvt_as_cchg = false;
   private boolean var_mvt_as_ticket = false;
   private boolean var_mvt_as_cretour = false;
   private boolean var_mvt_ss_cfacture = false;
   private boolean var_mvt_ss_cavoir = false;
   private boolean var_mvt_ss_cnoteDebit = false;
   private boolean var_mvt_ss_pump = false;
   private String var_lib_etat = "Etat";
   private String var_lib_qteIn = "Qte In";
   private String var_lib_qteOut = "Qte Out";
   private String var_lib_pv = "P.V.";
   private DepotAchatsDao depotAchatsDao;
   private DevisLigneVentesDao devisLigneVentesDao;
   private List recDevisVte;
   private CommandeLigneVentesDao commandeLigneVentesDao;
   private List recCommandeVte;
   private LivraisonLigneVentesDao livraisonLigneVentesDao;
   private List recLivraisonVte;
   private RetourLigneVentesDao retourLigneVentesDao;
   private List recRetourVte;
   private FactureLigneVentesDao factureLigneVentesDao;
   private List recFacturesVte;
   private AvoirLigneVentesDao avoirLigneVentesDao;
   private List recAvoirVte;
   private float tot_qte_in;
   private float tot_qte_out;
   private double tot_montant;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String requete;
   private String filtre;
   private String format = "PDF";
   private int var_choix_modele = 0;
   private String nomModeleListe;
   private String nomModeleDocument;
   private String nomModeleMvts;
   private String impEmetteur;
   private String impDestinataire;
   private boolean affListeDoc = false;
   private Stock stockPrint;
   private boolean showModalPanelPrint = false;
   private boolean var_acc_descriptif;
   private boolean var_acc_photo;
   private boolean var_acc_caracteristique;
   private boolean var_acc_stock;
   private boolean var_acc_tarification;
   private boolean var_acc_option_ach;
   private boolean var_acc_option_vte;
   private boolean var_acc_motcle;
   private boolean var_acc_service;
   private boolean var_acc_groupe;
   private boolean var_acc_fournisseur;
   private boolean var_acc_ref_historique;
   private boolean var_acc_prp;
   private boolean var_ajt;
   private boolean var_mod;
   private boolean var_sup;
   private boolean var_imp;
   private int var_aff_carac;
   private FormRecherche formRecherche;
   private boolean errorConnection;
   private List lesProduitsLiesRecherche = new ArrayList();
   private transient DataModel datamodelProduitsLieRecherche = new ListDataModel();
   private Produits produitsLies;
   private boolean showModalProduitRecherche = false;
   private int typeProduitRecherche;
   private ProduitsFournisseurDao produitsFournisseurDao;
   private int formatdeviseFournisseur;
   private transient DataModel datamodelProduitFournisseur = new ListDataModel();
   private List lesProduitsFournisseurs = new ArrayList();
   private boolean afficheButtModifProdFour = false;
   private boolean afficheButtSuppProdFour = false;
   private String inpTiers;
   private boolean existCodTiers = false;
   private ProduitsFournisseur produitsFournisseur;
   private double var_prix_euro;
   private Tiers tiers;
   private boolean inpInactifProdFour = false;
   private List lesTiers;
   private transient DataModel datamodelTiers = new ListDataModel();
   private TiersDao tiersDao;
   private boolean showModalProduitFournisseur = false;
   private boolean showModalTiers = false;
   private LectureDevises lectureDevises = new LectureDevises();
   private boolean showModalService = false;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsServices produitsServices;
   private String prodCodeLibService;
   private boolean testCodLibService = false;
   private transient DataModel datamodelProService = new ListDataModel();
   private boolean showModalHistorique = false;
   private ProduitsHistoRef produitsHistoRef;
   private ProduitsHistoRefDao produitsHistoRefDao;
   private transient DataModel datamodelRefHisto = new ListDataModel();
   private List lesProduitsHistoRef = new ArrayList();
   private boolean afficheButtModifProdHistoRef = false;
   private boolean afficheButtSuppProdHistoRef = false;
   private transient DataModel datamodelCode = new ListDataModel();
   private List lesProduitsCode = new ArrayList();
   private boolean afficheFormule = false;
   private boolean existGrp = false;
   private boolean existGrpCode = false;
   private ProduitsGrp produitsGrp;
   private ProduitsGrpDao produitsGrpDao;
   private transient DataModel datamodelGrp = new ListDataModel();
   private List lesProduitsGrp = new ArrayList();
   private boolean afficheButtProduitGroupe = false;
   private int modeProduit1;
   private int modeProduit2;
   private int modeProduit3;
   private int modeProduit4;
   private int modeProduit5;
   private boolean showModalProduitGroupe = false;
   private List mesDepotProduitGroupeItems = new ArrayList();
   private double var_grp_pump;
   private double var_grp_pv;
   private boolean showModalTarifSt = false;
   private boolean typeTarif = false;
   private CalculStock calculStock = new CalculStock();
   private List mesConditionnementsProduits = new ArrayList();
   private List mesConditionnementsItems;
   private List lesTarifsDegressifs = new ArrayList();
   private transient DataModel dataModelTarifDegressif = new ListDataModel();
   private transient DataModel dataModelTarifClients = new ListDataModel();
   private boolean showModalPanelTarifDegressif = false;
   private ObjetTarif objetTarif;
   private boolean visibiliteBtonTarif = false;
   private int etatTarif;
   private CalculPrp calculPrp;
   private boolean var_simluationPr;
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
   private String var_tarif1;
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
   private boolean testAffOutilsCorr = false;
   private int outilChoisi;
   private String toolsCompteOld;
   private String toolsDepotOld;
   private List mesProduitsDepotsItems;
   private String ancienCode;
   private String nouveauCode;
   private boolean valideChange;
   private String ancienneFamilleAchat;
   private String nouvelleFamilleAchat;
   private String ancienneFamilleVente;
   private String nouvelleFamilleVente;
   private int fusionAjout;
   private int choixRacine;
   private String selecFiscalite;
   private String libelleRabRis;
   private boolean ristourne;
   private BaremesDao baremesDao;
   private OptionGroupe optionGroupe = new OptionGroupe();
   private boolean gestionProduits = false;
   private long var_memo_id_master;
   private List lesPegStr = new ArrayList();

   public void instanceDaoUtilises() {
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.produitsGrpDao = new ProduitsGrpDao(this.baseLog, this.utilInitHibernate);
      this.produitsFournisseurDao = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.depotAchatsDao = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.produitsHistoRefDao = new ProduitsHistoRefDao(this.baseLog, this.utilInitHibernate);
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.taxesAchatsDao = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererOptions() throws ParseException, HibernateException, NamingException {
      if (this.optionsVentes.getDecrmtPriVteStock().equalsIgnoreCase("1")) {
         this.setHtTtc(" (HT)");
      } else if (this.optionsVentes.getDecrmtPriVteStock().equalsIgnoreCase("2")) {
         this.setHtTtc(" (TTC)");
      }

      if (this.structureLog.getStrECommerceVal() == 1) {
         this.afficheButtPanier = true;
      } else {
         this.afficheButtPanier = false;
      }

      this.lgNumProd = Integer.parseInt(this.optionAchats.getNbrCtrsProProd());
      if (this.optionAchats.getNbLigneMax() != null && !this.optionAchats.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionAchats.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.produits = null;
      this.lesProduits.clear();
      if (this.formRecherche != null && this.formRecherche.getProduits() != null) {
         this.lesProduits.add(this.formRecherche.getProduits());
      }

      this.datamodelProduit.setWrappedData(this.lesProduits);
      if (this.rechercheModule(81500)) {
         this.typeVente = 1;
      } else {
         this.typeVente = 0;
      }

      if (this.optionsVentes != null && this.optionsVentes.getDecrmtRabais().equals("3")) {
         this.libelleRabRis = "Ristourne";
         this.ristourne = true;
      } else {
         this.libelleRabRis = "Rabais";
         this.ristourne = false;
      }

      long var1 = 0L;
      var1 = this.structureLog.getStrid();
      File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "groupe" + File.separator + "configuration" + File.separator + "optionsGroupe_" + var1 + ".xml");
      if (var3.exists()) {
         this.chercherAutorisationProduits(var1);
      } else {
         this.gestionProduits = true;
         if (this.structureLog.getStrmaitrecabinet() == 12 || this.structureLog.getStrmaitrecabinet() == 13 || this.structureLog.getStrmaitrecabinet() == 14) {
            new StructurePeg();
            StructureDao var5 = new StructureDao(this.utilInitHibernate);
            StructurePeg var4 = var5.logStructurePeg(this.structureLog.getStrid());
            if (var4 != null) {
               long var6 = var4.getCabinetPeg().getCabId();
               this.lesPegStr.clear();
               String var8 = " where cabinetPeg.cabId=" + var6 + " and (str_maitre_cabinet=2 or str_maitre_cabinet=3 or str_maitre_cabinet=4)";
               this.lesPegStr = var5.selectStructureCabinet(var8);
               if (this.lesPegStr.size() != 0) {
                  var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "groupe" + File.separator + "configuration" + File.separator + "optionsGroupe_" + ((StructurePeg)this.lesPegStr.get(0)).getStrId() + ".xml");
                  if (var3.exists()) {
                     this.chercherAutorisationProduits(((StructurePeg)this.lesPegStr.get(0)).getStrId());
                  }
               }
            }
         }
      }

   }

   public void chercherAutorisationProduits(long var1) {
      LireLesoptionsGroupe var3 = new LireLesoptionsGroupe();
      var3.setStrId(var1);
      this.optionGroupe = var3.lancerExploitation();
      if (this.optionGroupe.getSynchroTiers().equals("1")) {
         if (this.structureLog.getStrid() == var1) {
            this.gestionProduits = true;
         } else {
            this.gestionProduits = false;
         }
      } else {
         this.gestionProduits = true;
      }

   }

   public void accesResteintGroupe() {
      this.var_acc_descriptif = false;
      this.var_acc_photo = false;
      this.var_acc_caracteristique = false;
      this.var_acc_fournisseur = false;
      this.var_acc_stock = false;
      this.var_acc_tarification = false;
      this.var_acc_option_ach = false;
      this.var_acc_option_vte = false;
      this.var_acc_motcle = false;
      this.var_acc_ref_historique = false;
      this.var_acc_service = false;
      this.var_acc_groupe = false;
      this.var_acc_prp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_acc_descriptif = true;
            } else if (var1.getCode().equals("2")) {
               this.var_acc_photo = true;
            } else if (var1.getCode().equals("3")) {
               this.var_acc_caracteristique = true;
            } else if (var1.getCode().equals("4")) {
               this.var_acc_fournisseur = true;
            } else if (var1.getCode().equals("5")) {
               this.var_acc_stock = true;
            } else if (var1.getCode().equals("6")) {
               this.var_acc_tarification = true;
            } else if (var1.getCode().equals("7")) {
               this.var_acc_option_ach = true;
            } else if (var1.getCode().equals("8")) {
               this.var_acc_option_vte = true;
            } else if (var1.getCode().equals("9")) {
               this.var_acc_motcle = true;
            } else if (var1.getCode().equals("10")) {
               this.var_acc_ref_historique = true;
            } else if (var1.getCode().equals("11")) {
               this.var_acc_service = true;
            } else if (var1.getCode().equals("12")) {
               this.var_acc_groupe = true;
            } else if (var1.getCode().equals("13")) {
               this.var_acc_prp = true;
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
               break;
            }
         }
      }

   }

   public void autorisationPhoto() throws IOException, SQLException, JDOMException {
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
               break;
            }
         }
      }

   }

   public void autorisationCaracteristique() throws JDOMException, IOException, HibernateException, NamingException {
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
               break;
            }
         }
      }

      this.chargerCaracteristiques((Session)null);
   }

   public void autorisationFournisseur() throws JDOMException, IOException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("4")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationStock() throws JDOMException, IOException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("5")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationTarification() throws JDOMException, IOException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("6")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

      if (this.lesProduitsDepos.size() != 0) {
         this.produitsDepot = null;
         byte var3 = 0;
         if (var3 < this.lesProduitsDepos.size() && ((ProduitsDepot)this.lesProduitsDepos.get(var3)).getProdepEchelle() != 0) {
            this.produitsDepot = (ProduitsDepot)this.lesProduitsDepos.get(var3);
         }
      } else {
         this.produitsDepot = null;
      }

      this.chargerConditionnementProduit((Session)null);
      this.afficheButtModifProdTar = false;
   }

   public void autorisationOptionAch() throws JDOMException, IOException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("7")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationOptionVte() throws JDOMException, IOException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("8")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationMotCle() throws JDOMException, IOException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("9")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationRefHistorique() throws JDOMException, IOException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("10")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationService() throws JDOMException, IOException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("11")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationGroupe() throws JDOMException, IOException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("12")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationPrp() throws JDOMException, IOException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("13")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public boolean rechercheModule(int var1) {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var3.add(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var3.add(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var3.add(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var3.add(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var3.add(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var3.add(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var3.add(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var3.add(this.structureLog.getStrmod10());
      }

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public void moreSearch() {
      if (!this.var_more_search) {
         this.var_more_search = true;
      } else {
         this.var_more_search = false;
         this.var_inactif = 0;
         this.var_ActiviteFind = "100";
      }

   }

   public void chargeFamilleMarque() throws HibernateException, NamingException {
      this.mesFamillesItems.clear();
      List var1;
      int var3;
      if (this.var_MarqueFind != null && !this.var_MarqueFind.isEmpty()) {
         new ArrayList();
         ProduitsVtesDao var6 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         var1 = var6.chargerLesProduitsVentesByMarque(this.var_MarqueFind, (Session)null);
         if (var1.size() != 0) {
            for(var3 = 0; var3 < var1.size(); ++var3) {
               this.produits = new Produits();
               this.produits = (Produits)var1.get(var3);
               this.mesFamillesItems.add(new SelectItem(this.produits.getProVteCode(), this.produits.getProVteCode() + ":" + this.produits.getProVteLib()));
            }
         }
      } else {
         new ArrayList();
         this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
         var1 = this.famillesProduitsAchatsDao.chargerFamilleProduitAchatsItems(this.exercicesAchats.getExeachId(), (Session)null);
         new ArrayList();
         this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         List var2 = this.famillesProduitsVentesDao.chargerFamilleProduitVentesItems(this.exercicesVentes.getExevteId(), (Session)null);
         this.mesFamillesItems = new ArrayList();
         String var4;
         String[] var5;
         if (var1.size() != 0) {
            this.mesFamillesItems.add(new SelectItem("", "********* ACHATS *********"));

            for(var3 = 0; var3 < var1.size(); ++var3) {
               var4 = (String)((SelectItem)var1.get(var3)).getValue();
               var5 = var4.split(":");
               this.mesFamillesItems.add(new SelectItem(var5[0], var5[0] + ":" + var5[1]));
            }
         }

         if (var2.size() != 0) {
            this.mesFamillesItems.add(new SelectItem("", "********* VENTES *********"));

            for(var3 = 0; var3 < var2.size(); ++var3) {
               var4 = (String)((SelectItem)var2.get(var3)).getValue();
               var5 = var4.split(":");
               this.mesFamillesItems.add(new SelectItem(var5[0], var5[0] + ":" + var5[1]));
            }
         }
      }

   }

   public void calculeSousFamille() throws HibernateException, NamingException {
      this.mesSousFamillesItems.clear();
      this.var_SousFamilleFind = "";
      this.afficheSousFamille = false;
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviStock");
      this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), this.var_FamilleFind, var1);
      if (this.famillesProduitsAchats != null && this.famillesProduitsAchats.getFamachCat() == 99) {
         this.mesSousFamillesItems = this.famillesProduitsAchatsDao.chargerFamilleProduitAchatsSousFamItems(this.exercicesAchats.getExeachId(), this.var_FamilleFind, var1);
         if (this.mesSousFamillesItems.size() == 0) {
            this.mesSousFamillesItems = this.famillesProduitsVentesDao.chargerFamilleProduitVentesSousFamItems(this.exercicesVentes.getExevteId(), this.var_FamilleFind, var1);
            if (this.mesSousFamillesItems.size() != 0) {
               this.afficheSousFamille = true;
            }
         } else {
            this.afficheSousFamille = true;
         }
      } else {
         this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), this.var_FamilleFind, var1);
         if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCat() == 99) {
            this.mesSousFamillesItems = this.famillesProduitsAchatsDao.chargerFamilleProduitAchatsSousFamItems(this.exercicesAchats.getExeachId(), this.var_FamilleFind, var1);
            if (this.mesSousFamillesItems.size() == 0) {
               this.mesSousFamillesItems = this.famillesProduitsVentesDao.chargerFamilleProduitVentesSousFamItems(this.exercicesVentes.getExevteId(), this.var_FamilleFind, var1);
               if (this.mesSousFamillesItems.size() != 0) {
                  this.afficheSousFamille = true;
               }
            } else {
               this.afficheSousFamille = true;
            }
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void rechercherProduit() throws JDOMException, IOException, HibernateException, NamingException {
      this.afficheButtOption = false;
      this.afficheButtSup = false;
      this.lesProduits.clear();
      String var1 = this.getVar_CodFind();
      String var2 = this.getVar_LibFind();
      String var3 = "";
      if (this.var_NatureFinf != null && !this.var_NatureFinf.isEmpty() && this.var_NatureFinf.contains(":")) {
         String[] var4 = this.getVar_NatureFinf().split(":");
         var3 = var4[0];
      }

      String var8 = "";
      if (this.var_ActiviteFind != null && !this.var_ActiviteFind.isEmpty() && this.var_ActiviteFind.contains(":")) {
         String[] var5 = this.getVar_ActiviteFind().split(":");
         var8 = var5[0];
      }

      String var9 = "";
      if (this.var_ServiceFind != null && !this.var_ServiceFind.isEmpty() && this.var_ServiceFind.contains(":")) {
         String[] var6 = this.getVar_ServiceFind().split(":");
         var9 = var6[0];
      } else if (this.var_ServiceFind != null && !this.var_ServiceFind.isEmpty() && this.var_ServiceFind.equals("-100")) {
         var9 = "-100";
      }

      String var10 = "";
      if (this.var_DepotFind != null && !this.var_DepotFind.isEmpty() && this.var_DepotFind.contains(":")) {
         String[] var7 = this.getVar_DepotFind().split(":");
         var10 = var7[0];
      }

      this.listerProduit(var1, var2, var3, var8, var9, var10);
      this.datamodelProduit.setWrappedData(this.lesProduits);
   }

   public void rechercher20Derniers() throws HibernateException, NamingException, JDOMException, IOException {
      this.afficheButtOption = false;
      this.afficheButtSup = false;
      this.lesProduits.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
      this.lesProduits = this.produitsAchsDao.chargerLesProduits20Derniers(var1);
      if (this.lesProduits.size() != 0) {
         UtilTrie var2 = new UtilTrie();
         this.lesProduits = var2.triListeProduit(this.lesProduits);
         this.mefproduit((String)null, var1);
      }

      this.utilInitHibernate.closeSession();
      this.datamodelProduit.setWrappedData(this.lesProduits);
   }

   public void listerProduit(String var1, String var2, String var3, String var4, String var5, String var6) throws JDOMException, IOException, HibernateException, NamingException {
      this.lesProduits.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
      String var8 = "";
      if (this.var_SousFamilleFind != null && !this.var_SousFamilleFind.isEmpty()) {
         var8 = this.var_SousFamilleFind;
      } else {
         var8 = this.var_FamilleFind;
      }

      if (var8 != null && !var8.isEmpty() && var8.contains(":")) {
         String[] var9 = var8.split(":");
         var8 = var9[0];
      }

      List var10;
      int var11;
      DepotAchats var17;
      if (var5 != null && (!var5.isEmpty() || var5.equals("-100")) || var6 == null || var6.isEmpty() || this.var_RefFind != null && !this.var_RefFind.isEmpty()) {
         if ((var5 == null || var5.isEmpty() && var5.equals("-100")) && var6 != null && !var6.isEmpty() && (this.var_RefFind == null || this.var_RefFind.isEmpty())) {
            new DepotAchats();
            var17 = this.depotAchatsDao.trouveDepot(var6, var7);
            if (var17 != null) {
               new ArrayList();
               var10 = this.produitsDepotDao.selectProdDepByDepSansService(var17, var1, var2, var3, this.var_MarqueFind, var8, var4, this.var_inactif, this.var_TypeFind, var7);
               if (var10.size() > 0) {
                  this.produitsDepot = new ProduitsDepot();

                  for(var11 = 0; var11 < var10.size(); ++var11) {
                     this.produitsDepot = (ProduitsDepot)var10.get(var11);
                     this.produits = this.produitsDepot.getProduits();
                     this.lesProduits.add(this.produits);
                  }
               }
            }
         } else if (var5 == null || var5.isEmpty() || var5.equals("-100") || var6 != null && !var6.isEmpty() || this.var_RefFind != null && !this.var_RefFind.isEmpty()) {
            boolean var12;
            int var13;
            List var19;
            if (var5 == null || var5.isEmpty() || !var5.equals("-100") || var6 != null && !var6.isEmpty() || this.var_RefFind != null && !this.var_RefFind.isEmpty()) {
               int var14;
               List var23;
               int var24;
               if (var5 != null && !var5.isEmpty() && !var5.equals("-100") && var6 != null && !var6.isEmpty() && (this.var_RefFind == null || this.var_RefFind.isEmpty())) {
                  ArrayList var20 = new ArrayList();
                  new DepotAchats();
                  DepotAchats var22 = this.depotAchatsDao.trouveDepot(var6, var7);
                  if (var22 != null) {
                     new ArrayList();
                     var23 = this.produitsDepotDao.selectProdDepByDep(var22, var1, var2, var3, this.var_MarqueFind, var8, var4, this.var_inactif, this.var_TypeFind, var7);
                     if (var23.size() > 0) {
                        this.produitsDepot = new ProduitsDepot();

                        for(var24 = 0; var24 < var23.size(); ++var24) {
                           this.produitsDepot = (ProduitsDepot)var23.get(var24);
                           var20.add(this.produitsDepot.getProduits());
                        }

                        if (var20.size() > 0) {
                           new Service();
                           this.produitsServices = new ProduitsServices();
                           Service var26 = this.serviceDao.chargerLeServiceCode(var5, var7);
                           if (var26 != null) {
                              this.produitsServices.setServices(var26);
                              new ArrayList();
                              List var27 = this.produitsServicesDao.selectProdServiceByservAchs(this.produitsServices.getServices(), this.var_TypeFind, var1, var7);
                              this.produitsServices = new ProduitsServices();

                              for(var14 = 0; var14 < var27.size(); ++var14) {
                                 this.produitsServices = (ProduitsServices)var27.get(var14);
                                 boolean var15 = false;

                                 for(int var16 = 0; var16 < var20.size(); ++var16) {
                                    if (((Produits)var20.get(var16)).getProId() == this.produitsServices.getProduits().getProId()) {
                                       this.produits = this.produitsServices.getProduits();
                                       var15 = true;
                                       break;
                                    }
                                 }

                                 if (var15) {
                                    this.lesProduits.add(this.produits);
                                 }
                              }
                           }
                        }
                     }
                  }
               } else if (this.var_RefFind != null && !this.var_RefFind.isEmpty()) {
                  new ArrayList();
                  var19 = this.produitsFournisseurDao.selectAllProduitsFour(this.var_RefFind, var7);
                  if (var19.size() > 0) {
                     this.produitsFournisseur = new ProduitsFournisseur();

                     for(int var21 = 0; var21 < var19.size(); ++var21) {
                        this.produitsFournisseur = (ProduitsFournisseur)var19.get(var21);
                        this.produits = this.produitsFournisseur.getProduits();
                        this.lesProduits.add(this.produits);
                     }
                  }

                  new ArrayList();
                  var10 = this.produitsHistoRefDao.selectProdHistoRefByprod(this.var_RefFind, var7);
                  if (var10.size() > 0) {
                     this.produitsHistoRef = new ProduitsHistoRef();

                     for(var11 = 0; var11 < var10.size(); ++var11) {
                        this.produitsHistoRef = (ProduitsHistoRef)var10.get(var11);
                        this.produits = this.produitsHistoRef.getProduits();
                        var12 = false;

                        for(var13 = 0; var13 < this.lesProduits.size(); ++var13) {
                           if (((Produits)this.lesProduits.get(var13)).getProId() == this.produits.getProId()) {
                              var12 = true;
                              break;
                           }
                        }

                        if (!var12) {
                           this.lesProduits.add(this.produits);
                        }
                     }
                  }

                  new ArrayList();
                  var23 = this.produitsMclesDao.chargerLesProduitsMcles(this.var_RefFind, var7);
                  if (var23.size() > 0) {
                     this.produitsMcles = new ProduitsMcles();

                     for(var24 = 0; var24 < var23.size(); ++var24) {
                        this.produitsMcles = (ProduitsMcles)var23.get(var24);
                        this.produits = this.produitsMcles.getProduits();
                        boolean var25 = false;

                        for(var14 = 0; var14 < this.lesProduits.size(); ++var14) {
                           if (((Produits)this.lesProduits.get(var14)).getProId() == this.produits.getProId()) {
                              var25 = true;
                              break;
                           }
                        }

                        if (!var25) {
                           this.lesProduits.add(this.produits);
                        }
                     }
                  }
               } else {
                  this.lesProduits = this.produitsAchsDao.selectFindProduit(var1, var2, var3, this.var_MarqueFind, var8, var4, this.var_inactif, this.var_TypeFind, var7);
               }
            } else {
               new ArrayList();
               var19 = this.produitsServicesDao.selectProdServiceByservAchs(var7);
               new ArrayList();
               var10 = this.produitsAchsDao.selectFindProduit(var1, var2, var3, this.var_MarqueFind, var8, var4, this.var_inactif, this.var_TypeFind, var7);
               if (var10.size() != 0) {
                  for(var11 = 0; var11 < var10.size(); ++var11) {
                     this.produits = (Produits)var10.get(var11);
                     var12 = false;

                     for(var13 = 0; var13 < var19.size(); ++var13) {
                        if (((ProduitsServices)var19.get(var13)).getProserCode() != null && !((ProduitsServices)var19.get(var13)).getProserCode().isEmpty() && ((ProduitsServices)var19.get(var13)).getProduits().getProCode().equals(this.produits.getProCode())) {
                           var12 = true;
                           break;
                        }
                     }

                     if (!var12) {
                        this.lesProduits.add(this.produits);
                     }
                  }
               }
            }
         } else {
            new Service();
            this.produitsServices = new ProduitsServices();
            Service var18 = this.serviceDao.chargerLeServiceCode(var5, var7);
            if (var18 != null) {
               this.produitsServices.setServices(var18);
               new ArrayList();
               var10 = this.produitsServicesDao.selectProdServiceByservAchs(this.produitsServices.getServices(), var1, var2, var3, this.var_MarqueFind, var8, var4, this.var_inactif, this.var_TypeFind, var7);
               if (var10.size() > 0) {
                  this.produitsServices = new ProduitsServices();

                  for(var11 = 0; var11 < var10.size(); ++var11) {
                     this.produitsServices = (ProduitsServices)var10.get(var11);
                     this.produits = this.produitsServices.getProduits();
                     this.lesProduits.add(this.produits);
                  }
               }
            }
         }
      } else {
         new DepotAchats();
         var17 = this.depotAchatsDao.trouveDepot(var6, var7);
         if (var17 != null) {
            new ArrayList();
            var10 = this.produitsDepotDao.selectProdDepByDep(var17, var1, var2, var3, this.var_MarqueFind, var8, var4, this.var_inactif, this.var_TypeFind, var7);
            if (var10.size() > 0) {
               this.produitsDepot = new ProduitsDepot();

               for(var11 = 0; var11 < var10.size(); ++var11) {
                  this.produitsDepot = (ProduitsDepot)var10.get(var11);
                  this.produits = this.produitsDepot.getProduits();
                  this.lesProduits.add(this.produits);
               }
            }
         }
      }

      this.mefproduit(var6, var7);
      this.utilInitHibernate.closeSession();
   }

   public void mefproduit(String var1, Session var2) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.lesProduits.size() != 0) {
         Object var3 = new ArrayList();

         for(int var4 = 0; var4 < this.lesProduits.size(); ++var4) {
            this.produits = (Produits)this.lesProduits.get(var4);
            float var5 = 0.0F;
            double var6 = 0.0D;
            double var8 = 0.0D;
            ((List)var3).clear();
            if (var1 != null && !var1.isEmpty()) {
               var3 = this.produitsDepotDao.selectProdDepByprod(this.produits.getProCode(), var1, var2);
            } else {
               var3 = this.produitsDepotDao.selectProdDepByprod(this.produits, var2);
            }

            if (var3 != null && ((List)var3).size() != 0) {
               for(int var10 = 0; var10 < ((List)var3).size(); ++var10) {
                  boolean var11 = false;

                  for(int var12 = 0; var12 < this.mesProduitsDepotsItems.size(); ++var12) {
                     String[] var13 = ((SelectItem)this.mesProduitsDepotsItems.get(var12)).getLabel().toString().split(":");
                     if (var13[0].equals(((ProduitsDepot)((List)var3).get(var10)).getDepot().getDpoCode())) {
                        var11 = true;
                        break;
                     }
                  }

                  if (var11 && ((ProduitsDepot)((List)var3).get(var10)).getDepot().getDpoType() != 3) {
                     if (((ProduitsDepot)((List)var3).get(var10)).getProdepPa() != 0.0D) {
                        var8 = ((ProduitsDepot)((List)var3).get(var10)).getProdepPa();
                     }

                     if (((ProduitsDepot)((List)var3).get(var10)).getProdepPump() != 0.0D) {
                        var6 = ((ProduitsDepot)((List)var3).get(var10)).getProdepPump();
                     }

                     var5 += ((ProduitsDepot)((List)var3).get(var10)).getProdepQteStk();
                  }
               }
            }

            this.produits.setProQteStock(var5);
            this.produits.setPa(var8);
            this.produits.setPump(var6);
            if (this.var_tarif1 != null && !this.var_tarif1.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif1, var2);
               if (this.produitsTarif != null) {
                  double var14 = 0.0D;
                  double var15 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var14 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv1(var14);
                     var15 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPvMarche() + this.produitsTarif.getProtarPvMarche() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv1Marche(var15);
                  } else {
                     var14 = this.produitsTarif.getProtarPv();
                     this.produits.setPv1(var14);
                     var15 = this.produitsTarif.getProtarPvMarche();
                     this.produits.setPv1Marche(var15);
                  }
               }
            }
         }
      }

   }

   public void ajouterProduit() {
      this.produits = new Produits();
      this.produits.setInactif(false);
      this.lesProduitsDepos.clear();
      this.lesProduitsFournisseurs.clear();
      this.lesProduitsGrp.clear();
      this.lesProduitsHistoRef.clear();
      this.lesProduitsMcles.clear();
      this.lesProduitsServices.clear();
      this.lesProduitsTarif.clear();
      this.lesMvt.clear();
      this.inpFamilleAch = "0";
      this.inpFamilleVnt = "0";
      this.inpNatureAch = "";
      this.inpNatureVnt = "";
      this.familleAch = false;
      this.familleVte = false;
      this.changeFamilleAch = false;
      this.changeFamilleVte = false;
      this.existCod = false;
      this.afficheQteNbUnite = false;
      this.var_action = 1;
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void duppliquerProduit() throws HibernateException, HibernateException, NamingException {
      if (this.produits != null) {
         this.var_action = 1;
         this.produits.setProId(0L);
         this.produits.setProCode("");
         this.produits.setProPhoto("");
         this.lesProduitsTarif.clear();
         this.lesProduitsDepos.clear();
         this.lesProduitsServices.clear();
         this.lesProduitsMcles.clear();
         this.produits.setInactif(false);
         this.existCod = false;
         if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
            this.calculeCodeVte();
         } else {
            this.calculeCodeAch();
         }
      }

   }

   public void modifierProduit() {
      if (this.produits != null) {
         this.memoAnalytique = this.produits.getProActivite();
         this.var_action = 2;
         this.existCod = true;
      }

   }

   public void consulterProduit() {
      if (this.produits != null) {
         this.var_action = 3;
         this.existCod = false;
      }

   }

   public void supprimerProduit() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         this.produits.setProInactif(2);
         this.majProduit((Session)null);
         this.afficheButtSup = false;
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

   }

   public void reactiverProduit() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         this.produits.setProInactif(0);
         this.produits.setInactif(false);
         this.majProduit((Session)null);
         this.afficheButtSup = false;
      }

   }

   public void selectionProduit() throws IOException, SQLException, HibernateException, NamingException {
      this.produits = new Produits();
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

         if (var1.size() == 0) {
            this.afficheButtOption = false;
         } else {
            this.produits = (Produits)var1.get(0);
            long var7 = this.produits.getProId();
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
            this.produits = this.produitsAchsDao.chargeProduit(var7, var5);
            if (this.produits != null) {
               if (this.produits.getProImpDesciption() == 1) {
                  this.libelle_libre = true;
               } else {
                  this.libelle_libre = false;
               }

               this.modeProduit1 = 0;
               this.modeProduit2 = 0;
               this.modeProduit3 = 0;
               this.modeProduit4 = 0;
               this.modeProduit5 = 0;
               if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty()) {
                  if (this.produits.getProAchNat().equals("0104")) {
                     this.modeProduit1 = this.produits.getProMode();
                  } else if (this.produits.getProAchNat().equals("0105")) {
                     this.modeProduit2 = this.produits.getProMode();
                  } else if (this.produits.getProAchNat().equals("0112")) {
                     this.modeProduit3 = this.produits.getProMode();
                  } else if (this.produits.getProAchNat().equals("0108")) {
                     this.modeProduit5 = this.produits.getProMode();
                  } else {
                     this.modeProduit4 = this.produits.getProMode();
                  }
               } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
                  this.modeProduit4 = this.produits.getProMode();
               }

               this.inpNatureAch = "";
               this.codeNatureAchat = "";
               this.inpFamilleAch = "";
               this.familleAch = false;
               this.changeFamilleAch = false;
               String[] var6;
               if (this.produits.getProAchCode() != null && !this.produits.getProAchCode().isEmpty()) {
                  this.famillesProduitsAchats = new FamillesProduitsAchats();
                  this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), this.produits.getProAchCode(), var5);
                  if (this.famillesProduitsAchats != null) {
                     this.inpNatureAch = this.famillesProduitsAchats.getFamachNature() + ":" + this.famillesProduitsAchats.getFamachLibNature();
                     this.codeNatureAchat = this.famillesProduitsAchats.getFamachNature();
                     if (this.produits.getProAchCode() != null && !this.produits.getProAchCode().isEmpty() && this.produits.getProAchLib() != null && !this.produits.getProAchLib().isEmpty()) {
                        this.inpFamilleAch = this.produits.getProAchCode() + ":" + this.produits.getProAchLib();
                     }

                     this.familleAch = true;
                  }

                  if (this.produits.getProAchCpteCh() != null && !this.produits.getProAchCpteCh().isEmpty() && this.produits.getProAchCpteCh().contains(":")) {
                     var6 = this.produits.getProAchCpteCh().split(":");
                     this.produits.setProAchCpteCh(var6[0]);
                  }

                  if (this.produits.getProAchCpteEc() != null && !this.produits.getProAchCpteEc().isEmpty() && this.produits.getProAchCpteEc().contains(":")) {
                     var6 = this.produits.getProAchCpteEc().split(":");
                     this.produits.setProAchCpteEc(var6[0]);
                  }

                  if (this.produits.getProAchCpteHz() != null && !this.produits.getProAchCpteHz().isEmpty() && this.produits.getProAchCpteHz().contains(":")) {
                     var6 = this.produits.getProAchCpteHz().split(":");
                     this.produits.setProAchCpteHz(var6[0]);
                  }

                  if (this.produits.getProAchCpteLoc() != null && !this.produits.getProAchCpteLoc().isEmpty() && this.produits.getProAchCpteLoc().contains(":")) {
                     var6 = this.produits.getProAchCpteLoc().split(":");
                     this.produits.setProAchCpteLoc(var6[0]);
                  }

                  if (this.produits.getProAchCpteSt() != null && !this.produits.getProAchCpteSt().isEmpty() && this.produits.getProAchCpteSt().contains(":")) {
                     var6 = this.produits.getProAchCpteSt().split(":");
                     this.produits.setProAchCpteSt(var6[0]);
                  }

                  if (this.produits.getProAchCpteZ() != null && !this.produits.getProAchCpteZ().isEmpty() && this.produits.getProAchCpteZ().contains(":")) {
                     var6 = this.produits.getProAchCpteZ().split(":");
                     this.produits.setProAchCpteZ(var6[0]);
                  }
               }

               this.typeTarif = false;
               this.inpNatureVnt = "";
               this.inpFamilleVnt = "";
               this.familleVte = false;
               this.changeFamilleVte = false;
               if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
                  this.famillesProduitsVentes = new FamillesProduitsVentes();
                  this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), this.produits.getProVteCode(), var5);
                  if (this.famillesProduitsVentes != null) {
                     this.inpNatureVnt = this.famillesProduitsVentes.getFamvteNature() + ":" + this.famillesProduitsVentes.getFamvteLibNature();
                     if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty() && this.produits.getProVteLib() != null && !this.produits.getProVteLib().isEmpty()) {
                        this.inpFamilleVnt = this.produits.getProVteCode() + ":" + this.produits.getProVteLib();
                     }

                     this.familleVte = true;
                     if (this.typeVente == 1 && this.produits.getProVteNat().equalsIgnoreCase("1104")) {
                        this.typeTarif = true;
                     }
                  }
               }

               if (this.produits.getProVteCpteHz() != null && !this.produits.getProVteCpteHz().isEmpty() && this.produits.getProVteCpteHz().contains(":")) {
                  var6 = this.produits.getProVteCpteHz().split(":");
                  this.produits.setProVteCpteHz(var6[0]);
               }

               if (this.produits.getProVteCpteLoc() != null && !this.produits.getProVteCpteLoc().isEmpty() && this.produits.getProVteCpteLoc().contains(":")) {
                  var6 = this.produits.getProVteCpteLoc().split(":");
                  this.produits.setProVteCpteLoc(var6[0]);
               }

               if (this.produits.getProVteCpteNTx() != null && !this.produits.getProVteCpteNTx().isEmpty() && this.produits.getProVteCpteNTx().contains(":")) {
                  var6 = this.produits.getProVteCpteNTx().split(":");
                  this.produits.setProVteCpteNTx(var6[0]);
               }

               if (this.produits.getProVteCptePr() != null && !this.produits.getProVteCptePr().isEmpty() && this.produits.getProVteCptePr().contains(":")) {
                  var6 = this.produits.getProVteCptePr().split(":");
                  this.produits.setProVteCptePr(var6[0]);
               }

               if (this.produits.getProVteCpteSt() != null && !this.produits.getProVteCpteSt().isEmpty() && this.produits.getProVteCpteSt().contains(":")) {
                  var6 = this.produits.getProVteCpteSt().split(":");
                  this.produits.setProVteCpteSt(var6[0]);
               }

               if (this.produits.getProVteCpteZ() != null && !this.produits.getProVteCpteZ().isEmpty() && this.produits.getProVteCpteZ().contains(":")) {
                  var6 = this.produits.getProVteCpteZ().split(":");
                  this.produits.setProVteCpteZ(var6[0]);
               }

               if (this.produits.getProInactif() != 2) {
                  this.afficheButtSup = true;
               } else {
                  this.afficheButtSup = false;
               }

               this.afficheButtModifProdTar = false;
               this.afficheButtSuppProdTar = false;
               this.affichePhotoProduit();
               this.chargerCaracteristiques(var5);
               this.chargerProduitDepot(var5);
               this.chargerProduitFournisseur(var5);
               this.chargerProduitTarif(var5);
               this.chargerInfoTablesAch(var5);
               this.chargerInfoTablesVte(var5);
               this.chargerProduitMoCle(var5);
               this.chargerProduitHistoRef(var5);
               this.chargerProduitService(var5);
               if (this.decoupageActivite) {
                  this.chargerDetailanalytique();
                  this.controleEcartAnalytique();
               }

               this.afficheButtOption = true;
            } else {
               this.afficheButtOption = false;
            }

            this.utilInitHibernate.closeSession();
         }

         this.majService();
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.produits != null) {
         this.consulterProduit();
      }

   }

   public void majService() throws HibernateException, NamingException {
      if (this.afficheButtOption) {
         if (this.lesProduitsServices.size() == 0) {
            if (this.produits.isProAvecService()) {
               this.produits.setProAvecService(false);
               this.produits = this.produitsAchsDao.modif(this.produits);
            }
         } else if (!this.produits.isProAvecService()) {
            this.produits.setProAvecService(true);
            this.produits = this.produitsAchsDao.modif(this.produits);
         }
      }

   }

   public void chargerProduitMoCle(Session var1) throws HibernateException, NamingException {
      this.lesProduitsMcles = new ArrayList();
      this.lesProduitsMcles = this.produitsMclesDao.selectProdMotClefByprod(this.produits, var1);
      this.datamodelMotCle = new ListDataModel();
      this.datamodelMotCle.setWrappedData(this.lesProduitsMcles);
   }

   public void chargerProduitHistoRef(Session var1) {
      this.lesProduitsHistoRef = new ArrayList();
      this.lesProduitsHistoRef = this.produitsHistoRefDao.selectProdHistoRefByprod(this.produits, var1);
      this.datamodelRefHisto = new ListDataModel();
      this.datamodelRefHisto.setWrappedData(this.lesProduitsHistoRef);
   }

   public void chargerProduitService(Session var1) throws HibernateException, NamingException {
      this.lesProduitsServices = new ArrayList();
      this.lesProduitsServices = this.produitsServicesDao.selectProdServiceByprod(this.produits, var1);
      this.datamodelProService.setWrappedData(this.lesProduitsServices);
   }

   public void chargerProduitGroupe(Session var1) throws HibernateException, NamingException {
      this.lesProduitsGrp.clear();
      this.lesProduitsGrp = this.produitsGrpDao.selectProdGrpByprod(this.produits, var1);
      this.datamodelGrp.setWrappedData(this.lesProduitsGrp);
   }

   public void chargerProduitFournisseur(Session var1) throws HibernateException, NamingException {
      this.lesProduitsFournisseurs = new ArrayList();
      this.lectureDevises = new LectureDevises();
      this.lesProduitsFournisseurs = this.produitsFournisseurDao.selectProdFourByprod(this.produits, var1);
      this.datamodelProduitFournisseur.setWrappedData(this.lesProduitsFournisseurs);
      this.afficheButtModifProdFour = false;
      this.afficheButtSuppProdFour = false;
   }

   public void chargerCaracteristiques(Session var1) throws HibernateException, NamingException {
      if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty()) {
         if (this.produits.getProAchNat().equals("0104")) {
            this.produits.setProMode(this.modeProduit1);
         } else if (this.produits.getProAchNat().equals("0105")) {
            this.produits.setProMode(this.modeProduit2);
         } else if (this.produits.getProAchNat().equals("0112")) {
            this.produits.setProMode(this.modeProduit3);
         } else if (this.produits.getProAchNat().equals("0108")) {
            this.produits.setProMode(this.modeProduit5);
         } else {
            this.produits.setProMode(this.modeProduit4);
         }
      } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
         this.produits.setProMode(this.modeProduit4);
      } else {
         this.produits.setProMode(0);
      }

      this.afficheQteNbUnite = false;
      if (this.produits.getProCondition5() != null && !this.produits.getProCondition5().isEmpty() && this.produits.getProCondition5().contains("/0.0:")) {
         this.afficheQteNbUnite = true;
      }

      this.afficheFormule = false;
      this.existGrp = false;
      this.existGrpCode = false;
      this.lesProduitsCode.clear();
      this.lesProduitsGrp.clear();
      this.afficheButtProduitGroupe = false;
      if (this.produits.getProMode() == 0) {
         this.chargerProduitGrpByCode(var1);
         if (this.lesProduitsCode.size() > 0) {
            this.existGrpCode = true;
         }
      } else if (this.produits.getProMode() != 1 && this.produits.getProMode() != 2) {
         if (this.produits.getProMode() != 3) {
            if (this.produits.getProMode() == 4) {
               this.afficheFormule = true;
            } else if (this.produits.getProMode() == 5) {

            }
         }
      } else {
         this.chargerProduitGroupe(var1);
         this.existGrp = true;
      }

      this.datamodelCode.setWrappedData(this.lesProduitsCode);
      this.datamodelGrp.setWrappedData(this.lesProduitsGrp);
      this.calculTotalGroupe();
   }

   public void chargerProduitDepot(Session var1) throws HibernateException, NamingException {
      this.lesProduitsDepos.clear();
      this.lesProduitsDepos = this.produitsDepotDao.selectProdDepByprod(this.produits, var1);
      this.datamodelDepot.setWrappedData(this.lesProduitsDepos);
      this.afficheButtModifDepProd = false;
      this.afficheButtSuppDepProd = false;
   }

   public void chargerProduitTarif(Session var1) throws HibernateException, NamingException {
      this.lesProduitsTarif = new ArrayList();
      this.lesProduitsTarif = this.produitsTarifDao.selectProdTarifByprod(this.produits, var1);
      this.datamodelTarif.setWrappedData(this.lesProduitsTarif);
      new ArrayList();
      List var2 = this.baremesDao.listBaremesByProduits(this.produits.getProCode(), var1);
      this.dataModelTarifClients.setWrappedData(var2);
   }

   public void chargerInfoTablesAch(Session var1) throws HibernateException, NamingException {
      if (!this.decoupageActivite) {
         if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
            new Activites();
            Activites var2 = this.activitesDao.rechercheActivite(this.produits.getProActivite(), var1);
            if (var2 != null) {
               this.produits.setProActivite(var2.getActCode() + ":" + var2.getActNomFr());
            } else {
               this.produits.setProActivite("");
            }
         } else {
            this.produits.setProActivite("");
         }
      }

   }

   public void chargerInfoTablesVte(Session var1) throws HibernateException, NamingException {
   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
         String[] var1 = null;
         if (!this.produits.getProActivite().contains("#")) {
            var1 = this.produits.getProActivite().split(":");
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
            String[] var2 = this.produits.getProActivite().split("#");

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

   public void calculeCodeAch() throws HibernateException, NamingException {
      if (this.inpFamilleAch.contains(":")) {
         String[] var1 = this.inpFamilleAch.split(":");
         this.famillesProduitsAchats = new FamillesProduitsAchats();
         this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), var1[0], (Session)null);
         if (this.famillesProduitsAchats != null) {
            this.inpNatureAch = this.famillesProduitsAchats.getFamachNature() + ":" + this.famillesProduitsAchats.getFamachLibNature();
            this.familleAch = true;
         } else {
            this.inpNatureAch = "";
            this.familleAch = false;
         }

         this.produits.setProAchCode(this.famillesProduitsAchats.getFamachCode());
         this.produits.setProAchLib(this.famillesProduitsAchats.getFamachLibelleFr());
         this.produits.setProAchNat(this.famillesProduitsAchats.getFamachNature());
         this.valeurDefautFamilleAch();
      } else {
         this.inpNatureAch = "";
         this.familleAch = false;
      }

      if (this.produits.getProCode() == null || this.produits.getProCode().isEmpty()) {
         long var6 = 0L;
         if (this.optionAchats.getModCalcProd().equalsIgnoreCase("0")) {
            this.verouxCod = false;
         } else if (this.optionAchats.getModCalcProd().equalsIgnoreCase("1")) {
            this.verouxCod = false;
         } else {
            CalculChrono var3;
            String var4;
            if (this.optionAchats.getModCalcProd().equalsIgnoreCase("2")) {
               this.verouxCod = true;
               var6 = this.produitsAchsDao.lastProduit((Session)null, 2);
               var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var4 = var3.numero(this.lgNumProd, var6);
               this.produits.setProCode(var4);
               this.verifCode();
            } else if (this.optionAchats.getModCalcProd().equalsIgnoreCase("3")) {
               this.verouxCod = true;
               var6 = this.produitsAchsDao.lastProduit((Session)null, 3);
               var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var4 = var3.numero(this.lgNumProd, var6);
               this.produits.setProCode(var4);
               this.verifCode();
            } else if (this.optionAchats.getModCalcProd().equalsIgnoreCase("4")) {
               this.verouxCod = true;
               var6 = this.produitsAchsDao.lastProduit((Session)null, 4);
               var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var4 = var3.numero(this.lgNumProd, var6);
               this.produits.setProCode(var4);
               this.verifCode();
            } else {
               String var5;
               String[] var7;
               CalculChrono var8;
               if (this.optionAchats.getModCalcProd().equalsIgnoreCase("5")) {
                  this.verouxCod = true;
                  if (this.inpFamilleAch.contains(":")) {
                     var7 = this.inpFamilleAch.split(":");
                     var6 = this.produitsAchsDao.lastProduitByIdAch(var7[0], (Session)null);
                     var8 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var5 = var8.numero(this.lgNumProd, var6);
                     this.produits.setProCode(var7[0] + "-" + var5);
                     this.verifCode();
                  }
               } else if (this.optionAchats.getModCalcProd().equalsIgnoreCase("6")) {
                  this.verouxCod = true;
                  if (this.inpFamilleAch.contains(":")) {
                     var7 = this.inpFamilleAch.split(":");
                     var6 = this.produitsAchsDao.nbProduitByFamilleAch(var7[0], (Session)null);
                     var8 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var5 = var8.numero(this.lgNumProd, var6);
                     this.produits.setProCode(var7[0] + "-" + var5);
                     this.verifCode();
                  }
               } else if (this.optionAchats.getModCalcProd().equalsIgnoreCase("7")) {
                  this.verouxCod = true;
                  if (this.inpFamilleAch.contains(":")) {
                     var7 = this.inpFamilleAch.split(":");
                     var6 = this.produitsAchsDao.lastProduitByFamilleAch(var7[0], (Session)null);
                     var8 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var5 = var8.numero(this.lgNumProd, var6);
                     this.produits.setProCode(var7[0] + "-" + var5);
                     this.verifCode();
                  }
               }
            }
         }
      }

   }

   public void calculeCodeVte() throws HibernateException, NamingException {
      if (this.inpFamilleVnt.contains(":")) {
         String[] var1 = this.inpFamilleVnt.split(":");
         this.famillesProduitsVentes = new FamillesProduitsVentes();
         this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), var1[0], (Session)null);
         if (this.famillesProduitsVentes != null) {
            this.inpNatureVnt = this.famillesProduitsVentes.getFamvteNature() + ":" + this.famillesProduitsVentes.getFamvteLibNature();
            this.produits.setProMarque(this.famillesProduitsVentes.getFamvteMarque());
         } else {
            this.inpNatureVnt = "";
            this.produits.setProMarque("");
         }

         this.produits.setProVteCode(this.famillesProduitsVentes.getFamvteCode());
         this.produits.setProVteLib(this.famillesProduitsVentes.getFamvteLibelleFr());
         this.produits.setProVteNat(this.famillesProduitsVentes.getFamvteNature());
         this.valeurDefautFamilleVte();
      } else {
         this.inpNatureVnt = "";
         this.familleVte = false;
      }

      if (this.produits.getProCode() == null || this.produits.getProCode().isEmpty()) {
         long var6 = 0L;
         if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("0")) {
            this.verouxCod = false;
         } else if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("1")) {
            this.verouxCod = false;
         } else {
            CalculChrono var3;
            String var4;
            if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("2")) {
               this.verouxCod = true;
               var6 = this.produitsAchsDao.lastProduit((Session)null, 2);
               var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var4 = var3.numero(this.lgNumProd, var6);
               this.produits.setProCode(var4);
               this.verifCode();
            } else if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("3")) {
               this.verouxCod = true;
               var6 = this.produitsAchsDao.lastProduit((Session)null, 3);
               var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var4 = var3.numero(this.lgNumProd, var6);
               this.produits.setProCode(var4);
               this.verifCode();
            } else if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("4")) {
               this.verouxCod = true;
               var6 = this.produitsAchsDao.lastProduit((Session)null, 4);
               var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var4 = var3.numero(this.lgNumProd, var6);
               this.produits.setProCode(var4);
               this.verifCode();
            } else {
               String var5;
               String[] var7;
               CalculChrono var8;
               if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("5")) {
                  this.verouxCod = true;
                  if (this.inpFamilleVnt.contains(":")) {
                     var7 = this.inpFamilleVnt.split(":");
                     var6 = this.produitsAchsDao.lastProduitByIdAch(var7[0], (Session)null);
                     var8 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var5 = var8.numero(this.lgNumProd, var6);
                     this.produits.setProCode(var7[0] + "-" + var5);
                     this.verifCode();
                  }
               } else if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("6")) {
                  this.verouxCod = true;
                  if (this.inpFamilleVnt.contains(":")) {
                     var7 = this.inpFamilleVnt.split(":");
                     var6 = this.produitsAchsDao.nbProduitByFamilleVte(var7[0], (Session)null);
                     var8 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var5 = var8.numero(this.lgNumProd, var6);
                     this.produits.setProCode(var7[0] + "-" + var5);
                     this.verifCode();
                  }
               } else if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("7")) {
                  this.verouxCod = true;
                  if (this.inpFamilleVnt.contains(":")) {
                     var7 = this.inpFamilleVnt.split(":");
                     var6 = this.produitsAchsDao.lastProduitByFamilleAch(var7[0], (Session)null);
                     var8 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var5 = var8.numero(this.lgNumProd, var6);
                     this.produits.setProCode(var7[0] + "-" + var5);
                     this.verifCode();
                  }
               }
            }
         }
      }

   }

   public void verifCode() throws HibernateException, NamingException {
      if (this.produits.getProCode() != null && !this.produits.getProCode().isEmpty()) {
         if (!this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("0")) {
            if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("1")) {
               CalculChrono var1 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               String var2 = var1.numero(this.lgNumProd, this.produits.getProCode());
               this.produits.setProCode(var2);
            } else if (!this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("2") && !this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("3") && !this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("4") && !this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("5") && !this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("6") && this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("7")) {
            }
         }

         boolean var3 = false;
         var3 = this.produitsAchsDao.existCode(this.produits.getProCode(), (Session)null);
         if (!var3) {
            this.existCod = true;
         } else {
            this.existCod = false;
         }
      } else {
         this.existCod = false;
      }

   }

   public void valeurDefautFamilleAch() throws HibernateException, NamingException {
      if (this.produits.getProAchCode() != null && !this.produits.getProAchCode().isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         this.famillesProduitsAchats = new FamillesProduitsAchats();
         this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), this.produits.getProAchCode(), var1);
         if (this.famillesProduitsAchats == null) {
            this.inpNatureAch = "";
         } else {
            this.inpNatureAch = this.famillesProduitsAchats.getFamachNature() + ":" + this.famillesProduitsAchats.getFamachLibNature();
            this.produits.setProAchCpteLoc(this.famillesProduitsAchats.getFamachCompteLocal());
            this.produits.setProAchCpteZ(this.famillesProduitsAchats.getFamachCompteZone());
            this.produits.setProAchCpteHz(this.famillesProduitsAchats.getFamachCompteExterieur());
            this.produits.setProAchCpteCh(this.famillesProduitsAchats.getFamachCompteCharge());
            this.produits.setProAchCpteSt(this.famillesProduitsAchats.getFamachCompteStock());
            this.produits.setProAchCpteEc(this.famillesProduitsAchats.getFamachCompteEncours());
            this.produits.setProAchDouane(this.famillesProduitsAchats.getFamachDouane());
            this.produits.setProAchTva(this.famillesProduitsAchats.getFamachTaxe());
            this.produits.setProCle1(this.famillesProduitsAchats.getFamachCle1());
            this.produits.setProCle2(this.famillesProduitsAchats.getFamachCle2());
            this.produits.setProActivite(this.famillesProduitsAchats.getFamachActivite());
            this.produits.setProMarque(this.famillesProduitsAchats.getFamachMarque());
            this.produits.setProStock(this.famillesProduitsAchats.getFamachStock());
            String[] var2;
            if (this.famillesProduitsAchats.getFamachDepotAch() != null && !this.famillesProduitsAchats.getFamachDepotAch().isEmpty() && this.famillesProduitsAchats.getFamachDepotAch().contains(":")) {
               var2 = this.famillesProduitsAchats.getFamachDepotAch().split(":");
               this.produits.setProDepotAch(var2[0]);
            } else {
               this.produits.setProDepotAch((String)null);
            }

            if (this.famillesProduitsAchats.getFamachDepotPrd() != null && !this.famillesProduitsAchats.getFamachDepotPrd().isEmpty() && this.famillesProduitsAchats.getFamachDepotPrd().contains(":")) {
               var2 = this.famillesProduitsAchats.getFamachDepotPrd().split(":");
               this.produits.setProDepotPrd(var2[0]);
            } else {
               this.produits.setProDepotPrd((String)null);
            }

            this.chargerInfoTablesAch(var1);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void valeurDefautFamilleVte() throws HibernateException, NamingException {
      if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         this.famillesProduitsVentes = new FamillesProduitsVentes();
         this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), this.produits.getProVteCode(), var1);
         if (this.famillesProduitsVentes == null) {
            this.inpNatureVnt = "";
         } else {
            this.inpNatureVnt = this.famillesProduitsVentes.getFamvteNature() + ":" + this.famillesProduitsVentes.getFamvteLibNature();
            this.produits.setProVteCpteLoc(this.famillesProduitsVentes.getFamvteCompteLocal());
            this.produits.setProVteCpteNTx(this.famillesProduitsVentes.getFamvteCompteNonTaxable());
            this.produits.setProVteCpteZ(this.famillesProduitsVentes.getFamvteCompteZone());
            this.produits.setProVteCpteHz(this.famillesProduitsVentes.getFamvteCompteExterieur());
            this.produits.setProVteCptePr(this.famillesProduitsVentes.getFamvteCompteProduit());
            this.produits.setProVteCpteSt(this.famillesProduitsVentes.getFamvteCompteStock());
            this.produits.setProVteDouane(this.famillesProduitsVentes.getFamvteDouane());
            this.produits.setProVteTva(this.famillesProduitsVentes.getFamvteTaxe());
            this.produits.setProCle1(this.famillesProduitsVentes.getFamvteCle1());
            this.produits.setProCle2(this.famillesProduitsVentes.getFamvteCle2());
            this.produits.setProActivite(this.famillesProduitsVentes.getFamvteActivite());
            this.produits.setProMarque(this.famillesProduitsVentes.getFamvteMarque());
            if (this.famillesProduitsVentes.getFamvteDepotVte() != null && !this.famillesProduitsVentes.getFamvteDepotVte().isEmpty() && this.famillesProduitsVentes.getFamvteDepotVte().contains(":")) {
               String[] var2 = this.famillesProduitsVentes.getFamvteDepotVte().split(":");
               this.produits.setProDepotVte(var2[0]);
            } else {
               this.produits.setProDepotVte((String)null);
            }

            this.chargerInfoTablesVte(var1);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void annuleSaisie() {
      this.var_action = 0;
      this.afficheButtOption = false;
      this.showModalProduitDepot = false;
      this.showModalProduitFournisseur = false;
      this.showModalTiers = false;
      this.showModalPanelPrint = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void majProduit(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.libelle_libre) {
            this.produits.setProImpDesciption(1);
         } else {
            this.produits.setProImpDesciption(0);
         }

         String[] var3;
         if (this.inpNatureAch != null && !this.inpNatureAch.isEmpty() && this.inpNatureAch.contains(":")) {
            var3 = this.inpNatureAch.split(":");
            this.produits.setProAchNat(var3[0]);
         } else {
            this.produits.setProAchNat("");
         }

         if (this.inpNatureVnt != null && !this.inpNatureVnt.isEmpty() && this.inpNatureVnt.contains(":")) {
            var3 = this.inpNatureVnt.split(":");
            this.produits.setProVteNat(var3[0]);
         } else {
            this.produits.setProVteNat("");
         }

         if (this.inpFamilleAch != null && !this.inpFamilleAch.isEmpty() && this.inpFamilleAch.contains(":")) {
            var3 = this.inpFamilleAch.split(":");
            this.produits.setProAchCode(var3[0]);
            this.produits.setProAchLib(var3[1]);
            this.familleAch = true;
         } else {
            this.produits.setProAchCode("");
            this.produits.setProAchLib("");
            this.familleAch = false;
         }

         if (this.inpFamilleVnt != null && !this.inpFamilleVnt.isEmpty() && this.inpFamilleVnt.contains(":")) {
            var3 = this.inpFamilleVnt.split(":");
            this.produits.setProVteCode(var3[0]);
            this.produits.setProVteLib(var3[1]);
            this.familleVte = true;
         } else {
            this.produits.setProVteCode("");
            this.produits.setProVteLib("");
            this.familleVte = false;
         }

         boolean var4;
         int var5;
         String var11;
         if (!this.decoupageActivite) {
            if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
               var3 = this.produits.getProActivite().split(":");
               this.produits.setProActivite(var3[0]);
            } else {
               this.produits.setProActivite("");
            }
         } else {
            var11 = "";
            var4 = true;
            if (this.lesDecoupagesActivites.size() != 0) {
               for(var5 = 0; var5 < this.lesDecoupagesActivites.size(); ++var5) {
                  this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var5);
                  if (this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
                     if (var4) {
                        var11 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                        var4 = false;
                     } else {
                        var11 = var11 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                     }
                  }
               }
            }

            this.produits.setProActivite(var11);
         }

         if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty() && !this.produits.getProAchNat().isEmpty()) {
            if (this.produits.getProAchNat().equals("0104")) {
               this.produits.setProMode(this.modeProduit1);
            } else if (this.produits.getProAchNat().equals("0105")) {
               this.produits.setProMode(this.modeProduit2);
            } else if (this.produits.getProAchNat().equals("0112")) {
               this.produits.setProMode(this.modeProduit3);
            } else if (this.produits.getProAchNat().equals("0108")) {
               this.produits.setProMode(this.modeProduit5);
            } else {
               this.produits.setProMode(this.modeProduit4);
            }
         } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
            this.produits.setProMode(this.modeProduit4);
         } else {
            this.produits.setProMode(0);
         }

         if (this.produits.getProMode() == 5) {
            this.produits.setProStock(0);
         }

         if (this.lesProduitsServices.size() == 0) {
            this.produits.setProAvecService(false);
         } else {
            this.produits.setProAvecService(true);
         }

         if (this.getProduits().getProId() == 0L) {
            this.produits.setProDateCreat(new Date());
            this.produits.setProUserCreat(this.usersLog.getUsrid());
            this.produits = this.produitsAchsDao.insert(this.produits, var1);
            this.lesProduits.add(this.produits);
            this.datamodelProduit.setWrappedData(this.lesProduits);
            this.var_action = 2;
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.produits.setProDateModif(new Date());
            this.produits.setProUserModif(this.usersLog.getUsrid());
            this.produits = this.produitsAchsDao.modif(this.produits, var1);
            this.afficheButtOption = false;
            Espion var14 = new Espion();
            EspionDao var12 = new EspionDao(this.baseLog, this.utilInitHibernate);
            var14.setUsers(this.usersLog);
            var14.setEsptype(0);
            var14.setEspdtecreat(new Date());
            String var15 = "";
            if (this.memoAnalytique != null && !this.memoAnalytique.isEmpty() && this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && !this.memoAnalytique.equals(this.produits.getProActivite())) {
               var15 = "Chagement analytique";
            } else if ((this.memoAnalytique == null || this.memoAnalytique.isEmpty()) && this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
               var15 = "Ajout analytique";
            } else if (this.memoAnalytique == null || this.memoAnalytique.isEmpty() || this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
               var15 = "";
            } else {
               var15 = "Annulation analytique";
            }

            var14.setEspaction("Modification produit (ach) N° " + this.produits.getProCode() + " " + var15);
            var12.mAJEspion(var14, var1);
         }

         if (this.produits.getProMode() != 5 && this.produits.getProStock() != 0) {
            boolean var17 = false;
            int var13;
            if (this.produits.getProDepotAch() != null && !this.produits.getProDepotAch().isEmpty()) {
               for(var13 = 0; var13 < this.lesProduitsDepos.size(); ++var13) {
                  if (((ProduitsDepot)this.lesProduitsDepos.get(var13)).getDepot().getDpoCode().equals(this.produits.getProDepotAch())) {
                     var17 = true;
                  }
               }

               if (!var17) {
                  this.creationProduitDepot(this.produits.getProDepotAch(), var1);
               }
            }

            if (this.produits.getProDepotPrd() != null && !this.produits.getProDepotPrd().isEmpty()) {
               for(var13 = 0; var13 < this.lesProduitsDepos.size(); ++var13) {
                  if (((ProduitsDepot)this.lesProduitsDepos.get(var13)).getDepot().getDpoCode().equals(this.produits.getProDepotPrd())) {
                     var17 = true;
                  }
               }

               if (!var17) {
                  this.creationProduitDepot(this.produits.getProDepotPrd(), var1);
               }
            }

            if (this.produits.getProDepotVte() != null && !this.produits.getProDepotVte().isEmpty()) {
               for(var13 = 0; var13 < this.lesProduitsDepos.size(); ++var13) {
                  if (((ProduitsDepot)this.lesProduitsDepos.get(var13)).getDepot().getDpoCode().equals(this.produits.getProDepotVte())) {
                     var17 = true;
                  }
               }

               if (!var17) {
                  this.creationProduitDepot(this.produits.getProDepotVte(), var1);
               }
            }
         } else if (this.lesProduitsDepos.size() != 0) {
            for(int var16 = 0; var16 < this.lesProduitsDepos.size(); ++var16) {
               this.produitsDepot = (ProduitsDepot)this.lesProduitsDepos.get(var16);
               this.produitsDepotDao.delete(this.produitsDepot, var1);
            }

            this.lesProduitsDepos.clear();
            this.datamodelDepot.setWrappedData(this.lesProduitsDepos);
         }

         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
            var11 = "";
            if (this.usersLog.getUsrService().contains(":")) {
               String[] var18 = this.usersLog.getUsrService().split(":");
               var11 = var18[0];
            } else {
               var11 = this.usersLog.getUsrService();
            }

            var4 = false;

            for(var5 = 0; var5 < this.lesProduitsServices.size(); ++var5) {
               if (((ProduitsServices)this.lesProduitsServices.get(var5)).getServices().getSerCode().equals(var11)) {
                  var4 = true;
               }
            }

            if (!var4) {
               this.creationProduitService(var11, var1);
            }
         }

         if (this.structureLog.getStrtypeentreprise().equals("2")) {
            ProcessEnteteAchatsDao var20 = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
            new ProcessEnteteAchats();
            ProcessEnteteAchats var19 = var20.rechercheProcess(this.produits.getProCode(), var1);
            if (var19 != null) {
               var19.setProcesLibClient(this.produits.getProLibClient());
               var19.setProcesStock(this.produits.getProStock());
               var19.setProcesCondition(this.produits.getProCondition5());
               var20.modif(var19, var1);
            }
         }

         var2.commit();
      } catch (HibernateException var9) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.majService();
      if (this.var_action == 0) {
         this.majProduitStructures();
      }

   }

   public void majProduitStructures() throws HibernateException, NamingException {
      if (this.gestionProduits && (this.structureLog.getStrmaitrecabinet() == 2 || this.structureLog.getStrmaitrecabinet() == 3 || this.structureLog.getStrmaitrecabinet() == 4)) {
         new StructurePeg();
         StructureDao var2 = new StructureDao(this.utilInitHibernate);
         StructurePeg var1 = var2.logStructurePeg(this.structureLog.getStrid());
         if (var1 != null) {
            long var3 = var1.getCabinetPeg().getCabId();
            if (this.lesPegStr.size() == 0) {
               this.lesPegStr.clear();
               String var5 = " where cabinetPeg.cabId=" + var3 + " and str_maitre_cabinet<>2 and str_maitre_cabinet<>3 and str_maitre_cabinet<>4";
               this.lesPegStr = var2.selectStructureCabinet(var5);
            }

            if (this.lesPegStr.size() != 0) {
               new Produits();

               for(int var6 = 0; var6 < this.lesPegStr.size(); ++var6) {
                  var1 = (StructurePeg)this.lesPegStr.get(var6);
                  String var7 = "structure" + var1.getStrId();
                  Session var8 = this.utilInitHibernate.getOpenSession(var7, "ProduitsAchs");
                  Transaction var9 = null;

                  try {
                     var9 = var8.beginTransaction();
                     this.produitsAchsDao = new ProduitsAchsDao(var7, this.utilInitHibernate);
                     Produits var16 = this.produitsAchsDao.chargeToutProduit(this.produits.getProCode(), var8);
                     if (var16 == null) {
                        var16 = new Produits();
                     }

                     var16 = this.trfCommumProduitsStr(var16);
                     if (var16.getProId() == 0L) {
                        var16.setProUserCreat(this.usersLog.getUsrid());
                        var16.setProDateCreat(new Date());
                        this.produitsAchsDao.insert(var16, var8);
                     } else {
                        var16.setProUserModif(this.usersLog.getUsrid());
                        var16.setProDateModif(new Date());
                        this.produitsAchsDao.modif(var16, var8);
                     }

                     var9.commit();
                  } catch (HibernateException var14) {
                     if (var9 != null) {
                        var9.rollback();
                     }

                     throw var14;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }
               }
            }
         }
      }

   }

   public Produits trfCommumProduitsStr(Produits var1) {
      var1.setProAchCode(this.produits.getProAchCode());
      var1.setProAchCpteCh(this.produits.getProAchCpteCh());
      var1.setProAchCpteEc(this.produits.getProAchCpteEc());
      var1.setProAchCpteHz(this.produits.getProAchCpteHz());
      var1.setProAchCpteLoc(this.produits.getProAchCpteLoc());
      var1.setProAchCpteSt(this.produits.getProAchCpteSt());
      var1.setProAchCpteZ(this.produits.getProAchCpteZ());
      var1.setProAchDouane(this.produits.getProAchDouane());
      var1.setProAchLib(this.produits.getProAchLib());
      var1.setProAchNat(this.produits.getProAchNat());
      var1.setProAchTva(this.produits.getProAchTva());
      var1.setProActivite(this.produits.getProActivite());
      var1.setProAssurance(this.produits.getProAssurance());
      var1.setProAvecService(this.produits.isProAvecService());
      var1.setProBarre(this.produits.getProBarre());
      var1.setProBoiteVitesse(this.produits.getProBoiteVitesse());
      var1.setProCaf(this.produits.getProCaf());
      var1.setProCarrosserie(this.produits.getProCarrosserie());
      var1.setProCle1(this.produits.getProCle1());
      var1.setProCle2(this.produits.getProCle2());
      var1.setProCode(this.produits.getProCode());
      var1.setProCodeLie(this.produits.getProCodeLie());
      var1.setProCodeOption(this.produits.getProCodeOption());
      var1.setProCoefDevise(this.produits.getProCoefDevise());
      var1.setProComPourcentage(this.produits.getProComPourcentage());
      var1.setProComUnite(this.produits.getProComUnite());
      var1.setProCondition1(this.produits.getProCondition1());
      var1.setProCondition2(this.produits.getProCondition2());
      var1.setProCondition3(this.produits.getProCondition3());
      var1.setProCondition4(this.produits.getProCondition4());
      var1.setProCondition5(this.produits.getProCondition5());
      var1.setProConstructeur(this.produits.getProConstructeur());
      var1.setProCouleur(this.produits.getProCouleur());
      var1.setProCylindree(this.produits.getProCylindree());
      var1.setProDatePublic(this.produits.getProDatePublic());
      var1.setProDefDtePump(this.produits.getProDefDtePump());
      var1.setProDefPump(this.produits.getProDefPump());
      var1.setProDensite(this.produits.getProDensite());
      var1.setProDepotAch(this.produits.getProDepotAch());
      var1.setProDepotPrd(this.produits.getProDepotPrd());
      var1.setProDescrip(this.produits.getProDescrip());
      var1.setProDevise(this.produits.getProDevise());
      var1.setProDiamExt(this.produits.getProDiamExt());
      var1.setProDiamInt(this.produits.getProDiamExt());
      var1.setProDiamInt(this.produits.getProDiamInt());
      var1.setProEnergie(this.produits.getProEnergie());
      var1.setProEpaisseur(this.produits.getProEpaisseur());
      var1.setProEtat(this.produits.getProEtat());
      var1.setProExoTva(this.produits.isProExoTva());
      var1.setProFormule(this.produits.getProFormule());
      var1.setProFret(this.produits.getProFret());
      var1.setProGenre(this.produits.getProGenre());
      var1.setProGrpInv(this.produits.getProGrpInv());
      var1.setProImpDesciption(this.produits.getProImpDesciption());
      var1.setProInactif(this.produits.getProInactif());
      var1.setProLargeur(this.produits.getProLargeur());
      var1.setProLettre(this.produits.getProLettre());
      var1.setProLibClient(this.produits.getProLibClient());
      var1.setProLibTech(this.produits.getProLibTech());
      var1.setProLongueur(this.produits.getProLongueur());
      var1.setProMajoration(this.produits.getProMajoration());
      var1.setProManchon(this.produits.getProManchon());
      var1.setProMarque(this.produits.getProMarque());
      var1.setProMode(this.produits.getProMode());
      var1.setProModelePr(this.produits.getProModelePr());
      var1.setProNbPlace(this.produits.getProNbPlace());
      var1.setProNbPorte(this.produits.getProNbPorte());
      var1.setProNbUnite(this.produits.getProNbUnite());
      var1.setProNbUniteCnamgs(this.produits.getProNbUniteCnamgs());
      var1.setProPA(this.produits.getProPA());
      var1.setProPdf(this.produits.getProPdf());
      var1.setProPecBilan(this.produits.getProPecBilan());
      var1.setProPhoto(this.produits.getProPhoto());
      var1.setProPhotoTaille(this.produits.getProPhotoTaille());
      var1.setProPoidsBrut(this.produits.getProPoidsBrut());
      var1.setProPoidsNet(this.produits.getProPoidsNet());
      var1.setProPoidsTare(this.produits.getProPoidsTare());
      var1.setProPrcExoP(this.produits.getProPrcExoP());
      var1.setProPrcExoT(this.produits.getProPrcExoT());
      var1.setProPrcHt(this.produits.getProPrcHt());
      var1.setProPression(this.produits.getProPression());
      var1.setProPrgExoP(this.produits.getProPrgExoP());
      var1.setProPrgExoT(this.produits.getProPrgExoT());
      var1.setProPrgHt(this.produits.getProPrgHt());
      var1.setProProcess(this.produits.getProProcess());
      var1.setProPromo(this.produits.getProPromo());
      var1.setProPublic(this.produits.getProPublic());
      var1.setProPuissance(this.produits.getProPuissance());
      var1.setProPuissanceDin(this.produits.getProPuissanceDin());
      var1.setProQteCmdClient(this.produits.getProQteCmdClient());
      var1.setProQteCmdFournisseur(this.produits.getProQteCmdFournisseur());
      var1.setProQteLie(this.produits.getProQteLie());
      var1.setProQteStock(this.produits.getProQteStock());
      var1.setProRemise(this.produits.getProRemise());
      var1.setProStock(this.produits.getProStock());
      var1.setProUsage(this.produits.getProUsage());
      var1.setProVolume(this.produits.getProVolume());
      var1.setProVteCode(this.produits.getProVteCode());
      var1.setProVteCpteCa(this.produits.getProVteCpteCa());
      var1.setProVteCpteHz(this.produits.getProVteCpteHz());
      var1.setProVteCpteLoc(this.produits.getProVteCpteLoc());
      var1.setProVteCpteNTx(this.produits.getProVteCpteNTx());
      var1.setProVteCptePr(this.produits.getProVteCptePr());
      var1.setProVteCpteSt(this.produits.getProVteCpteSt());
      var1.setProVteCpteZ(this.produits.getProVteCpteZ());
      var1.setProVteDouane(this.produits.getProVteDouane());
      var1.setProVteLib(this.produits.getProVteLib());
      var1.setProVteNat(this.produits.getProVteNat());
      var1.setProVteTva(this.produits.getProVteTva());
      return var1;
   }

   public void creationProduitDepot(String var1, Session var2) throws HibernateException, NamingException {
      new DepotAchats();
      DepotAchats var3 = this.depotAchatsDao.trouveDepot(var1, var2);
      if (var3 != null) {
         this.produitsDepot = new ProduitsDepot();
         this.produitsDepot.setDepot(var3);
         this.produitsDepot.setProduits(this.produits);
         this.produitsDepot.setProdepInactif(0);
         this.produitsDepot.setUnite((Unite)null);
         this.produitsDepot.setProdepEchelle(0);
         this.produitsDepot.setProdepCle(this.produitsDepot.getDepot().getDpoCode() + ":" + this.produitsDepot.getProduits().getProCode());
         if (this.produitsDepot.getProdepGroupe() != null && !this.produitsDepot.getProdepGroupe().isEmpty()) {
            this.produitsDepot.setProdepCle2(this.produitsDepot.getProdepGroupe() + ":" + this.produitsDepot.getProduits().getProCode());
         } else {
            this.produitsDepot.setProdepCle2("");
         }

         this.produitsDepot = this.produitsDepotDao.insert(this.produitsDepot, var2);
         this.lesProduitsDepos.add(this.produitsDepot);
         this.datamodelDepot.setWrappedData(this.lesProduitsDepos);
      }

   }

   public void creationProduitService(String var1, Session var2) throws HibernateException, NamingException {
      new Service();
      Service var3 = this.serviceDao.chargerLeServiceCode(var1, var2);
      if (var3 != null) {
         this.produitsServices = new ProduitsServices();
         this.produitsServices.setProduits(this.produits);
         this.produitsServices.setProserCode(var3.getSerCode());
         this.produitsServices.setProserNomFr(var3.getSerNomFr());
         this.produitsServices.setProserQte(0.0F);
         this.produitsServices.setServices(var3);
         this.produitsServicesDao.insert(this.produitsServices, var2);
         this.lesProduitsServices.add(this.produitsServices);
         this.datamodelProService.setWrappedData(this.lesProduitsServices);
      }

   }

   public void majProduitRetour() throws JDOMException, IOException, HibernateException, NamingException {
      this.var_action = 0;
      this.majProduit((Session)null);
      this.afficheButtOption = false;
   }

   public void changeFamilleAch() {
      this.changeFamilleAch = true;
   }

   public void changeFamilleVte() {
      this.changeFamilleVte = true;
   }

   public void affichePhotoProduit() throws IOException, SQLException {
      if (this.produits.getProPhoto() != null) {
         this.urlphotoProd = this.baseLog + "/photos/produits/photo/" + this.produits.getProPhoto();
      } else {
         this.urlphotoProd = "";
      }

   }

   public void verifierPdf() {
      this.existPdfFile = this.isExistPdfFile();
   }

   public boolean isExistPdfFile() {
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "pdf") + File.separator + this.produits.getProCode() + ".pdf";
      File var2 = new File(var1);
      if (var2.exists()) {
         this.existPdfFile = true;
      } else {
         this.existPdfFile = false;
      }

      return this.existPdfFile;
   }

   public void setExistPdfFile(boolean var1) {
      this.existPdfFile = var1;
   }

   public void readPdfFile() throws IOException {
      BufferedInputStream var1 = null;
      BufferedOutputStream var2 = null;
      FacesContext var3 = FacesContext.getCurrentInstance();
      HttpServletResponse var4 = (HttpServletResponse)var3.getExternalContext().getResponse();
      String var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "pdf") + File.separator + this.produits.getProCode() + ".pdf";
      File var6 = new File(var5);
      if (var6.exists()) {
         try {
            var1 = new BufferedInputStream(new FileInputStream(var6), 10240);
            var4.reset();
            var4.setContentType("application/pdf");
            var4.addHeader("Content-disposition", "attachment; filename=" + var6.getName());
            var4.setContentLength((int)var6.length());
            var2 = new BufferedOutputStream(var4.getOutputStream(), 10240);
            byte[] var7 = new byte[10240];

            while(true) {
               int var8;
               if ((var8 = var1.read(var7)) <= 0) {
                  var2.flush();
                  break;
               }

               var2.write(var7, 0, var8);
            }
         } finally {
            close(var2);
            close(var1);
         }

         var3.responseComplete();
      }

   }

   private static void close(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

   }

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException {
      FacesContext var1 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "photo") + File.separator + this.produits.getProCode();
            File var3 = new File(var2);
            if (var3.exists()) {
               var3.delete();
            }

            String var4 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = this.produits.getProCode() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
            this.fileName = var4;
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.produits.setProPhoto(var4);
            this.produitsAchsDao.modif(this.produits);
            this.urlphotoProd = this.baseLog + "/photos/produits/photo/" + this.produits.getProPhoto();
         }
      } catch (IOException var7) {
         this.produits.setProPhoto(this.fileName);
         var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var7.printStackTrace();
      }

   }

   public void submitPDF() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.uploadedPDFFile != null) {
         String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "pdf") + File.separator + this.produits.getProCode() + ".pdf";
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         FacesContext var3 = FacesContext.getCurrentInstance();

         try {
            String var4 = this.utilDownload.trimFilePath(this.uploadedPDFFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = this.produits.getProCode() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "pdf" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var4;
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.produits.setProPdf(var4);
            this.produitsAchsDao.modif(this.produits);
         } catch (IOException var7) {
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var7.printStackTrace();
         }
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException {
      String var1 = "";
      int var2 = this.produits.getProPhoto().lastIndexOf(46);
      if (0 < var2 && var2 <= this.produits.getProPhoto().length() - 2) {
         var1 = "." + this.produits.getProPhoto().substring(var2 + 1);
      }

      String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "photo") + File.separator + this.produits.getProCode() + var1;
      File var4 = new File(var3);
      if (var4.exists()) {
         var4.delete();
      }

      this.produits.setProPhoto((String)null);
      this.produitsAchsDao.modif(this.produits);
   }

   public void reInitPDF() throws HibernateException, NamingException {
      this.produits.setProPdf((String)null);
      this.produitsAchsDao.modif(this.produits);
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "pdf") + File.separator + this.produits.getProCode() + ".pdf";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

   }

   public void recupererCalc() throws HibernateException, NamingException {
      this.chargerCaracteristiques((Session)null);
   }

   public void calculPoidsNet() {
      float var1 = 0.0F;
      if (this.produits.getProPoidsTare() == 0.0F) {
         this.produits.setProPoidsTare(1.0F);
      }

      var1 = this.produits.getProPoidsBrut() - this.produits.getProPoidsTare();
      this.produits.setProPoidsNet(var1);
   }

   public void chargerProduitGrpByCode(Session var1) throws HibernateException, NamingException {
      this.lesProduitsGrp.clear();
      this.lesProduitsCode.clear();
      this.lesProduitsGrp = this.produitsGrpDao.selectProdGrpByCode(this.produits.getProCode(), var1);
      if (this.lesProduitsGrp.size() > 0) {
         String var2 = "0000";

         for(int var3 = 0; var3 < this.lesProduitsGrp.size(); ++var3) {
            ProduitsGrp var4 = (ProduitsGrp)this.lesProduitsGrp.get(var3);
            var2 = var2 + "," + var4.getProduits().getProId();
         }

         var2 = "(" + var2 + ")";
         this.lesProduitsCode = this.produitsAchsDao.selectEgalProduits(var2, var1);
      }

      this.datamodelCode.setWrappedData(this.lesProduitsCode);
      this.calculTotalGroupe();
   }

   public void calculTotalGroupe() {
      this.var_grp_pump = 0.0D;
      this.var_grp_pv = 0.0D;

      for(int var1 = 0; var1 < this.lesProduitsGrp.size(); ++var1) {
         this.var_grp_pump += ((ProduitsGrp)this.lesProduitsGrp.get(var1)).getProgrpPump() * (double)((ProduitsGrp)this.lesProduitsGrp.get(var1)).getProgrpQte();
         this.var_grp_pv += ((ProduitsGrp)this.lesProduitsGrp.get(var1)).getProgrpPv() * (double)((ProduitsGrp)this.lesProduitsGrp.get(var1)).getProgrpQte();
      }

   }

   public void rechargeTotalGrp() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new ProduitsGrp();
         new Produits();
         Object var5 = new ArrayList();
         Object var6 = new ArrayList();

         int var7;
         for(var7 = 0; var7 < this.lesProduitsGrp.size(); ++var7) {
            ProduitsGrp var3 = (ProduitsGrp)this.lesProduitsGrp.get(var7);
            Produits var4 = this.produitsAchsDao.chargeProduit(var3.getProgrpCode(), var1);
            if (var4 != null) {
               double var8 = 0.0D;
               ((List)var5).clear();
               var5 = this.produitsDepotDao.selectProdDepByprod(var4, var1);
               if (((List)var5).size() != 0) {
                  for(int var10 = 0; var10 < ((List)var5).size(); ++var10) {
                     if (((ProduitsDepot)((List)var5).get(var10)).getDepot() != null && ((ProduitsDepot)((List)var5).get(var10)).getProdepPump() != 0.0D) {
                        var8 = ((ProduitsDepot)((List)var5).get(var10)).getProdepPump();
                     }
                  }
               }

               var3.setProgrpPump(var8);
               double var19 = 0.0D;
               ((List)var6).clear();
               var6 = this.produitsTarifDao.selectProdTarifByprod(var4, var1);
               if (((List)var6).size() != 0) {
                  for(int var12 = 0; var12 < ((List)var6).size(); ++var12) {
                     if (((ProduitsTarif)((List)var6).get(var12)).getProtarClient() != null && !((ProduitsTarif)((List)var6).get(var12)).getProtarClient().isEmpty() && ((ProduitsTarif)((List)var6).get(var12)).getProtarClient().equals("Normal")) {
                        var19 = ((ProduitsTarif)((List)var6).get(var12)).getProtarPv();
                     }
                  }
               }

               var3.setProgrpPv(var19);
               var3 = this.produitsGrpDao.modif(var3, var1);
               this.lesProduitsGrp.remove(var3);
               this.lesProduitsGrp.add(var7, var3);
            }
         }

         this.datamodelGrp.setWrappedData(this.lesProduitsGrp);
         List var18 = this.produitsTarifDao.selectProdTarifByprod(this.produits, var1);
         if (var18.size() != 0) {
            for(var7 = 0; var7 < var18.size(); ++var7) {
               this.produitsTarif = (ProduitsTarif)var18.get(var7);
               this.produitsTarif.setProtarPv(this.var_grp_pv);
               this.produitsTarif = this.produitsTarifDao.modif(this.produitsTarif, var1);
            }
         }

         this.datamodelTarif.setWrappedData(var18);
         var2.commit();
      } catch (HibernateException var16) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.calculTotalGroupe();
   }

   public void selectProduitTarif() throws JDOMException, IOException {
      if (this.datamodelTarif.isRowAvailable()) {
         this.produitsTarif = (ProduitsTarif)this.datamodelTarif.getRowData();
         this.tarifOrdClt = this.produitsTarif.getProtarClient();
         this.inpInactifProdTarif = this.recupererInactifModifProdTar();
         int var1 = this.produitsTarif.getProtarInactif();
         if (var1 != 2) {
            this.afficheButtModifProdTar = true;
            this.afficheButtSuppProdTar = true;
         } else {
            this.afficheButtModifProdTar = false;
            this.afficheButtSuppProdTar = false;
         }

         this.visibiliteBtonTarif = false;
         this.lesTarifsDegressifs.clear();
         if (this.produitsTarif.getProtarTarifQte() != null && !this.produitsTarif.getProtarTarifQte().isEmpty()) {
            String[] var2;
            if (!this.produitsTarif.getProtarTarifQte().contains("#")) {
               var2 = this.produitsTarif.getProtarTarifQte().split(":");
               this.objetTarif = new ObjetTarif();
               this.objetTarif.setQteDebut(Float.parseFloat(var2[0]));
               this.objetTarif.setQteFin(Float.parseFloat(var2[1]));
               this.objetTarif.setPrix(Double.parseDouble(var2[2]));
               this.lesTarifsDegressifs.add(this.objetTarif);
            } else {
               var2 = this.produitsTarif.getProtarTarifQte().split("#");
               int var3 = var2.length;

               for(int var4 = 0; var4 < var3; ++var4) {
                  String[] var5 = var2[var4].split(":");
                  this.objetTarif = new ObjetTarif();
                  this.objetTarif.setQteDebut(Float.parseFloat(var5[0]));
                  this.objetTarif.setQteFin(Float.parseFloat(var5[1]));
                  this.objetTarif.setPrix(Double.parseDouble(var5[2]));
                  this.lesTarifsDegressifs.add(this.objetTarif);
               }
            }
         }

         this.dataModelTarifDegressif.setWrappedData(this.lesTarifsDegressifs);
      }

   }

   public void ajouterTarif() throws JDOMException, IOException {
      this.produitsTarif = new ProduitsTarif();
      this.tarifOrdClt = "100";
      this.testDoubleProduitsTarif = false;
      this.lesTarifsDegressifs.clear();
      this.dataModelTarifDegressif.setWrappedData(this.lesTarifsDegressifs);
      this.showModalTarifSt = true;
   }

   public void modifierTarif() {
      if (this.produitsTarif != null) {
         this.testDoubleProduitsTarif = true;
         this.showModalTarifSt = true;
      }

   }

   public void saveProduitsTarif() throws HibernateException, NamingException {
      this.produitsTarif.setProduits(this.produits);
      if (this.produitsTarif.getProtarCoef() == 0.0F) {
         this.produitsTarif.setProtarCoef(1.3F);
      }

      if (this.lesTarifsDegressifs.size() != 0) {
         String var1 = "";
         this.objetTarif = new ObjetTarif();

         for(int var2 = 0; var2 < this.lesTarifsDegressifs.size(); ++var2) {
            this.objetTarif = (ObjetTarif)this.lesTarifsDegressifs.get(var2);
            if (var1 != null && !var1.isEmpty()) {
               var1 = var1 + "#" + this.objetTarif.getQteDebut() + ":" + this.objetTarif.getQteFin() + ":" + this.objetTarif.getPrix();
            } else {
               var1 = this.objetTarif.getQteDebut() + ":" + this.objetTarif.getQteFin() + ":" + this.objetTarif.getPrix();
            }
         }

         this.produitsTarif.setProtarTarifQte(var1);
      } else {
         this.produitsTarif.setProtarTarifQte("");
      }

      if (this.produitsTarif.getProtarId() == 0L) {
         this.produitsTarif = this.produitsTarifDao.insert(this.produitsTarif);
         this.lesProduitsTarif.add(this.produitsTarif);
         this.datamodelTarif.setWrappedData(this.lesProduitsTarif);
      } else {
         this.produitsTarif.setProtarInactif(this.getDesactiveModifprodTar());
         this.produitsTarif = this.produitsTarifDao.modif(this.produitsTarif);
      }

      this.showModalTarifSt = false;
   }

   public void deleteProduitTarif() throws HibernateException, NamingException {
      if (this.produitsTarif != null) {
         this.produitsTarifDao.delete(this.produitsTarif);
         this.lesProduitsTarif.remove(this.produitsTarif);
         this.datamodelTarif.setWrappedData(this.lesProduitsTarif);
         this.afficheButtModifProdTar = false;
         this.afficheButtSuppProdTar = false;
      }

   }

   public void reactiverProdTarif() throws HibernateException, NamingException {
      if (this.produitsTarif != null) {
         this.produitsTarif.setProtarInactif(0);
         this.produitsTarifDao.modif(this.produitsTarif);
         this.afficheButtModifProdTar = true;
         this.afficheButtSuppProdTar = true;
      }

   }

   public void decouperMesTarifItems() throws HibernateException, NamingException {
      if ("100".equalsIgnoreCase(this.getTarifOrdClt())) {
         this.testDoubleProduitsTarif = false;
      } else if (this.lesFamillesclients.size() != 0) {
         for(int var1 = 0; var1 < this.lesFamillesclients.size(); ++var1) {
            if (((ObjetFamilleTiers)this.lesFamillesclients.get(var1)).getLibelle().equalsIgnoreCase(this.tarifOrdClt)) {
               this.produitsTarif.setProtarOrdre(((ObjetFamilleTiers)this.lesFamillesclients.get(var1)).getIndice());
               this.produitsTarif.setProtarClient(((ObjetFamilleTiers)this.lesFamillesclients.get(var1)).getLibelle());
               this.doublon(this.produitsTarif.getProtarOrdre(), this.produitsTarif.getProtarCondit());
               break;
            }
         }
      } else {
         this.produitsTarif.setProtarOrdre(0);
         this.produitsTarif.setProtarClient("");
         this.testDoubleProduitsTarif = false;
      }

   }

   public void doublon(int var1, String var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (this.lesProduitsTarif.size() != 0) {
         for(int var4 = 0; var4 < this.lesProduitsTarif.size(); ++var4) {
            if (((ProduitsTarif)this.lesProduitsTarif.get(var4)).getProtarCondit() != null && !((ProduitsTarif)this.lesProduitsTarif.get(var4)).getProtarCondit().isEmpty()) {
               if (((ProduitsTarif)this.lesProduitsTarif.get(var4)).getProtarOrdre() == var1 && ((ProduitsTarif)this.lesProduitsTarif.get(var4)).getProtarCondit().equals(var2)) {
                  var3 = true;
                  break;
               }
            } else if (((ProduitsTarif)this.lesProduitsTarif.get(var4)).getProtarOrdre() == var1) {
               var3 = true;
               break;
            }
         }

         if (var3) {
            this.testDoubleProduitsTarif = false;
         } else {
            this.testDoubleProduitsTarif = true;
         }
      } else {
         this.testDoubleProduitsTarif = true;
      }

   }

   public boolean recupererInactifModifProdTar() {
      return this.produitsTarif.getProtarInactif() != 0;
   }

   public int getDesactiveModifprodTar() {
      if (!this.inpInactifProdTarif) {
         this.desactiveModifprodTar = 0;
      } else {
         this.desactiveModifprodTar = 1;
      }

      return this.desactiveModifprodTar;
   }

   public void setDesactiveModifprodTar(int var1) {
      this.desactiveModifprodTar = var1;
   }

   public List chargerConditionnementProduit(Session var1) {
      this.mesConditionnementsProduits.clear();
      this.mesConditionnementsProduits = this.calculStock.calculConditionnementStock(this.mesConditionnementsItems, this.produits, this.produitsDepot, var1);
      return this.mesConditionnementsProduits;
   }

   public void annuleTarif() {
      this.showModalTarifSt = false;
   }

   public void selectionTarifDegressif() {
      if (this.dataModelTarifDegressif.isRowAvailable()) {
         this.objetTarif = (ObjetTarif)this.dataModelTarifDegressif.getRowData();
         int var1 = this.produitsTarif.getProtarInactif();
         if (var1 != 2) {
            this.afficheButtModifProdTar = true;
            this.afficheButtSuppProdTar = true;
         } else {
            this.afficheButtModifProdTar = false;
            this.afficheButtSuppProdTar = false;
         }

         this.visibiliteBtonTarif = true;
      }

   }

   public void ajouterTarifDegressif() {
      this.objetTarif = new ObjetTarif();
      this.visibiliteBtonTarif = false;
      this.etatTarif = 0;
      this.showModalPanelTarifDegressif = true;
   }

   public void modifierTarifDegressif() {
      if (this.objetTarif != null) {
         this.etatTarif = 1;
         this.visibiliteBtonTarif = false;
         this.showModalPanelTarifDegressif = true;
      }

   }

   public void supprimerTarifDegressif() {
      if (this.objetTarif != null) {
         this.lesTarifsDegressifs.remove(this.objetTarif);
         this.dataModelTarifDegressif.setWrappedData(this.lesTarifsDegressifs);
         this.visibiliteBtonTarif = false;
      }

   }

   public void validerTarifDegressif() {
      if (this.objetTarif != null && this.etatTarif == 0) {
         this.lesTarifsDegressifs.add(this.objetTarif);
         this.dataModelTarifDegressif.setWrappedData(this.lesTarifsDegressifs);
      }

      this.showModalPanelTarifDegressif = false;
   }

   public void fermerTarifDegressif() {
      this.visibiliteBtonTarif = false;
      this.showModalPanelTarifDegressif = false;
   }

   public void verifConditionnement1() {
      if (this.produits.getProCondition1() != null && !this.produits.getProCondition1().isEmpty()) {
         if (this.produits.getProCondition2() != null && !this.produits.getProCondition2().isEmpty() && this.produits.getProCondition1().contentEquals(this.produits.getProCondition2())) {
            this.produits.setProCondition1("");
         }

         if (this.produits.getProCondition3() != null && !this.produits.getProCondition3().isEmpty() && this.produits.getProCondition1().contentEquals(this.produits.getProCondition3())) {
            this.produits.setProCondition1("");
         }

         if (this.produits.getProCondition4() != null && !this.produits.getProCondition4().isEmpty() && this.produits.getProCondition1().contentEquals(this.produits.getProCondition4())) {
            this.produits.setProCondition1("");
         }

         if (this.produits.getProCondition5() != null && !this.produits.getProCondition5().isEmpty() && this.produits.getProCondition1().contentEquals(this.produits.getProCondition5())) {
            this.produits.setProCondition1("");
         }
      }

   }

   public void verifConditionnement2() {
      if (this.produits.getProCondition2() != null && !this.produits.getProCondition2().isEmpty()) {
         if (this.produits.getProCondition1() != null && !this.produits.getProCondition1().isEmpty() && this.produits.getProCondition2().contentEquals(this.produits.getProCondition1())) {
            this.produits.setProCondition2("");
         }

         if (this.produits.getProCondition3() != null && !this.produits.getProCondition3().isEmpty() && this.produits.getProCondition2().contentEquals(this.produits.getProCondition3())) {
            this.produits.setProCondition2("");
         }

         if (this.produits.getProCondition4() != null && !this.produits.getProCondition4().isEmpty() && this.produits.getProCondition2().contentEquals(this.produits.getProCondition4())) {
            this.produits.setProCondition2("");
         }

         if (this.produits.getProCondition5() != null && !this.produits.getProCondition5().isEmpty() && this.produits.getProCondition2().contentEquals(this.produits.getProCondition5())) {
            this.produits.setProCondition2("");
         }
      }

   }

   public void verifConditionnement3() {
      if (this.produits.getProCondition3() != null && !this.produits.getProCondition3().isEmpty()) {
         if (this.produits.getProCondition1() != null && !this.produits.getProCondition1().isEmpty() && this.produits.getProCondition3().contentEquals(this.produits.getProCondition1())) {
            this.produits.setProCondition3("");
         }

         if (this.produits.getProCondition2() != null && !this.produits.getProCondition2().isEmpty() && this.produits.getProCondition3().contentEquals(this.produits.getProCondition2())) {
            this.produits.setProCondition3("");
         }

         if (this.produits.getProCondition4() != null && !this.produits.getProCondition4().isEmpty() && this.produits.getProCondition3().contentEquals(this.produits.getProCondition4())) {
            this.produits.setProCondition3("");
         }

         if (this.produits.getProCondition5() != null && !this.produits.getProCondition5().isEmpty() && this.produits.getProCondition3().contentEquals(this.produits.getProCondition5())) {
            this.produits.setProCondition3("");
         }
      }

   }

   public void verifConditionnement4() {
      if (this.produits.getProCondition4() != null && !this.produits.getProCondition4().isEmpty()) {
         if (this.produits.getProCondition1() != null && !this.produits.getProCondition1().isEmpty() && this.produits.getProCondition4().contentEquals(this.produits.getProCondition1())) {
            this.produits.setProCondition4("");
         }

         if (this.produits.getProCondition2() != null && !this.produits.getProCondition2().isEmpty() && this.produits.getProCondition4().contentEquals(this.produits.getProCondition2())) {
            this.produits.setProCondition4("");
         }

         if (this.produits.getProCondition3() != null && !this.produits.getProCondition3().isEmpty() && this.produits.getProCondition4().contentEquals(this.produits.getProCondition3())) {
            this.produits.setProCondition4("");
         }

         if (this.produits.getProCondition5() != null && !this.produits.getProCondition5().isEmpty() && this.produits.getProCondition4().contentEquals(this.produits.getProCondition5())) {
            this.produits.setProCondition4("");
         }
      }

   }

   public void verifConditionnement5() {
      this.afficheQteNbUnite = false;
      if (this.produits.getProCondition5() != null && !this.produits.getProCondition5().isEmpty()) {
         if (this.produits.getProCondition1() != null && !this.produits.getProCondition1().isEmpty() && this.produits.getProCondition5().contentEquals(this.produits.getProCondition1())) {
            this.produits.setProCondition5("");
         }

         if (this.produits.getProCondition2() != null && !this.produits.getProCondition2().isEmpty() && this.produits.getProCondition5().contentEquals(this.produits.getProCondition2())) {
            this.produits.setProCondition5("");
         }

         if (this.produits.getProCondition3() != null && !this.produits.getProCondition3().isEmpty() && this.produits.getProCondition5().contentEquals(this.produits.getProCondition3())) {
            this.produits.setProCondition5("");
         }

         if (this.produits.getProCondition4() != null && !this.produits.getProCondition4().isEmpty() && this.produits.getProCondition4().contentEquals(this.produits.getProCondition5())) {
            this.produits.setProCondition5("");
         }
      }

      if (this.produits.getProCondition5() != null && !this.produits.getProCondition5().isEmpty() && this.produits.getProCondition5().contains("/0.0:")) {
         this.afficheQteNbUnite = true;
      }

   }

   public void selectMotCle() {
      if (this.datamodelMotCle.isRowAvailable()) {
         this.produitsMcles = (ProduitsMcles)this.datamodelMotCle.getRowData();
         this.afficheButtModifProdMotCle = true;
      }

   }

   public void ajoutMotCle() {
      this.produitsMcles = new ProduitsMcles();
      this.showModalMotCles = true;
   }

   public void modifMotCle() {
      if (this.produitsMcles != null) {
         this.showModalMotCles = true;
      }

   }

   public void majProduitsMotCle() throws HibernateException, NamingException {
      this.produitsMcles.setProduits(this.produits);
      if (this.produitsMcles.getPromclId() == 0L) {
         this.produitsMcles = this.produitsMclesDao.insert(this.produitsMcles);
         this.lesProduitsMcles.add(this.produitsMcles);
         this.datamodelMotCle.setWrappedData(this.lesProduitsMcles);
      } else {
         this.produitsMcles = this.produitsMclesDao.modif(this.produitsMcles);
      }

      this.afficheButtModifProdMotCle = false;
      this.showModalMotCles = false;
   }

   public void deleteProduitMotCle() throws HibernateException, NamingException {
      if (this.produitsMcles != null) {
         this.produitsMclesDao.delete(this.produitsMcles);
         this.lesProduitsMcles.remove(this.produitsMcles);
         this.datamodelMotCle.setWrappedData(this.lesProduitsMcles);
         this.afficheButtModifProdMotCle = false;
      }

   }

   public void annuleMotCles() {
      this.showModalMotCles = false;
   }

   public void selectHistoRef() {
      if (this.datamodelRefHisto.isRowAvailable()) {
         this.produitsHistoRef = (ProduitsHistoRef)this.datamodelRefHisto.getRowData();
         this.afficheButtModifProdHistoRef = true;
         this.afficheButtSuppProdHistoRef = true;
      }

   }

   public void ajoutHistoRef() {
      this.produitsHistoRef = new ProduitsHistoRef();
      this.showModalHistorique = true;
   }

   public void modifHistoRef() {
      if (this.produitsHistoRef != null) {
         this.showModalHistorique = true;
      }

   }

   public void majProduitsHistoRef() throws HibernateException, NamingException {
      this.produitsHistoRef.setProduits(this.produits);
      if (this.produitsHistoRef.getProhrfId() == 0L) {
         this.produitsHistoRef = this.produitsHistoRefDao.insert(this.produitsHistoRef);
         this.lesProduitsHistoRef.add(this.produitsHistoRef);
         this.datamodelRefHisto.setWrappedData(this.lesProduitsHistoRef);
      } else {
         this.produitsHistoRef = this.produitsHistoRefDao.modif(this.produitsHistoRef);
      }

      this.afficheButtModifProdHistoRef = false;
      this.afficheButtSuppProdHistoRef = false;
      this.showModalHistorique = false;
   }

   public void deleteProduitHistoRef() throws HibernateException, NamingException {
      if (this.produitsHistoRef != null) {
         this.produitsHistoRefDao.delete(this.produitsHistoRef);
         this.lesProduitsHistoRef.remove(this.produitsHistoRef);
         this.datamodelRefHisto.setWrappedData(this.lesProduitsHistoRef);
         this.afficheButtModifProdHistoRef = false;
         this.afficheButtSuppProdHistoRef = false;
      }

   }

   public void annuleHistoRef() {
      this.showModalHistorique = false;
   }

   public void selectProduitsService() {
      this.produitsServices = new ProduitsServices();
      if (this.datamodelProService.isRowAvailable()) {
         this.produitsServices = (ProduitsServices)this.datamodelProService.getRowData();
         this.afficheButtSuppProdServ = true;
      } else {
         this.afficheButtSuppProdServ = false;
      }

   }

   public void ajoutProService() {
      this.produitsServices = new ProduitsServices();
      this.prodCodeLibService = "0";
      this.testCodLibService = false;
      this.showModalService = true;
   }

   public void modifProService() {
      if (this.produitsServices != null) {
         this.showModalService = true;
      }

   }

   public void saveProduitsServices() throws HibernateException, NamingException {
      this.produitsServices.setProduits(this.produits);
      this.produitsServices.setServices(this.produitsServices.getServices());
      this.produitsServices.setProserCode(this.produitsServices.getProserCode());
      this.produitsServices.setProserNomFr(this.produitsServices.getProserNomFr());
      this.produitsServices = this.produitsServicesDao.insert(this.produitsServices);
      this.lesProduitsServices.add(this.produitsServices);
      this.datamodelProService.setWrappedData(this.lesProduitsServices);
      this.afficheButtSuppProdServ = false;
      this.showModalService = false;
      this.majService();
   }

   public void deleteProduitsServices() throws HibernateException, NamingException {
      if (this.produitsServices != null) {
         this.produitsServicesDao.deletProdService(this.produitsServices.getProserId());
         this.chargerProduitService((Session)null);
         this.afficheButtSuppProdServ = false;
         this.majService();
      }

   }

   public void decoupageCodLibService() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.prodCodeLibService != null && !this.prodCodeLibService.isEmpty()) {
         if (this.prodCodeLibService.contains(":")) {
            new Service();
            String[] var2 = this.prodCodeLibService.split(":");
            String var3 = var2[0];
            ProduitsServices var4 = this.produitsServicesDao.selectCode(this.produits, var3, (Session)null);
            if (var4 != null) {
               this.testCodLibService = false;
            } else {
               Service var1 = this.serviceDao.chargerLeServiceCode(var3, (Session)null);
               this.produitsServices.setServices(var1);
               this.produitsServices.setProserCode(var1.getSerCode());
               this.produitsServices.setProserNomFr(var1.getSerNomFr());
               this.testCodLibService = true;
            }
         } else {
            this.testCodLibService = false;
         }
      } else {
         this.testCodLibService = false;
      }

   }

   public void annuleService() {
      this.showModalService = false;
   }

   public void selectProduitGroupe() {
      if (this.datamodelGrp.isRowAvailable()) {
         this.produitsGrp = (ProduitsGrp)this.datamodelGrp.getRowData();
         this.produitsLies = this.produitsGrp.getProduits();
         this.mesDepotProduitGroupeItems.add(new SelectItem(this.produitsGrp.getProgrpDepot()));
         this.afficheButtProduitGroupe = true;
      }

   }

   public void ajouterProduitGroupe() {
      this.produitsGrp = new ProduitsGrp();
      this.produitsLies = new Produits();
      this.mesDepotProduitGroupeItems.add(new SelectItem(""));
      this.showModalProduitGroupe = true;
   }

   public void modifierProduitGroupe() {
      if (this.produitsGrp != null) {
         this.showModalProduitGroupe = true;
      }

   }

   public void supprimerProduitGroupe() throws HibernateException, NamingException {
      if (this.produitsGrp != null) {
         this.produitsGrpDao.delete(this.produitsGrp);
         this.lesProduitsGrp.remove(this.produitsGrp);
         this.datamodelGrp.setWrappedData(this.lesProduitsGrp);
         this.afficheButtProduitGroupe = false;
      }

      this.calculTotalGroupe();
   }

   public void fermerProduitGroupe() {
      this.showModalProduitGroupe = false;
      this.afficheButtProduitGroupe = false;
   }

   public void validerProduitGroupe() throws HibernateException, NamingException {
      if (this.produitsLies != null) {
         this.produitsGrp.setProduits(this.produits);
         if (this.produitsGrp.getProgrpId() == 0L) {
            this.produitsGrp = this.produitsGrpDao.insert(this.produitsGrp);
            this.lesProduitsGrp.add(this.produitsGrp);
            this.datamodelGrp.setWrappedData(this.lesProduitsGrp);
         } else {
            this.produitsGrp = this.produitsGrpDao.modif(this.produitsGrp);
         }

         this.afficheButtProduitGroupe = true;
      }

      this.showModalProduitGroupe = false;
      this.afficheButtProduitGroupe = false;
      this.calculTotalGroupe();
   }

   public void calculeDepotGroupe() throws HibernateException, NamingException {
      if (this.produitsGrp != null && this.produitsGrp.getProgrpCode() != null && !this.produitsGrp.getProgrpCode().isEmpty() && this.produitsGrp.getProgrpDepot() != null && !this.produitsGrp.getProgrpDepot().isEmpty()) {
         new ProduitsDepot();
         ProduitsDepot var1 = this.produitsDepotDao.produitDepByprod(this.produitsGrp.getProgrpCode(), this.produitsGrp.getProgrpDepot(), (Session)null);
         if (var1 != null) {
            this.produitsGrp.setProgrpPump(var1.getProdepPump());
            this.produitsGrp.setProgrpUnite(var1.getProdepUnite());
         } else {
            this.produitsGrp.setProgrpPump(0.0D);
            this.produitsGrp.setProgrpUnite("");
         }
      }

   }

   public void selectProduitFournisseur() {
      if (this.datamodelProduitFournisseur.isRowAvailable()) {
         this.produitsFournisseur = (ProduitsFournisseur)this.datamodelProduitFournisseur.getRowData();
         this.tiers = this.produitsFournisseur.getTiers();
         this.inpTiers = this.produitsFournisseur.getTiers().getTieraisonsocialenom();
         this.var_prix_euro = this.produitsFournisseur.getProfouPaEuro();
         if (this.produitsFournisseur.getProfouInactif() == 0) {
            this.inpInactifProdFour = false;
         } else {
            this.inpInactifProdFour = true;
         }

         int var1 = this.produitsFournisseur.getProfouInactif();
         if (var1 != 2) {
            this.afficheButtModifProdFour = true;
            this.afficheButtSuppProdFour = true;
         } else {
            this.afficheButtModifProdFour = false;
            this.afficheButtSuppProdFour = false;
         }
      }

   }

   public void chargerModalAddFour() throws IOException {
      this.inpTiers = "";
      this.inpInactifProdFour = false;
      this.tiers = new Tiers();
      this.produitsFournisseur = new ProduitsFournisseur();
      this.var_prix_euro = 0.0D;
      this.existCodTiers = false;
      this.showModalProduitFournisseur = true;
      this.showModalTiers = false;
   }

   public void chargerModalModFour() throws IOException {
      if (this.produitsFournisseur != null) {
         this.existCodTiers = true;
         this.showModalProduitFournisseur = true;
         this.showModalTiers = false;
      }

   }

   public void suppressionProFour() throws IOException, HibernateException, NamingException {
      if (this.produitsFournisseur != null) {
         this.produitsFournisseurDao.delete(this.produitsFournisseur);
      }

   }

   public void reactiverProdFour() throws IOException, HibernateException, NamingException {
      this.produitsFournisseur.setProfouInactif(0);
      this.inpInactifProdFour = false;
      this.produitsFournisseurDao.modif(this.produitsFournisseur);
      this.chargerProduitFournisseur((Session)null);
   }

   public void rechercheTiers() throws HibernateException, NamingException {
      this.lesTiers = new ArrayList();
      this.datamodelTiers = new ListDataModel();
      if (!this.inpTiers.isEmpty()) {
         String var1 = "(0)";
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         this.lesTiers = this.tiersDao.verifTiers(this.usersLog, var1, this.inpTiers, (Session)null);
      }

      this.datamodelTiers.setWrappedData(this.lesTiers);
      if (this.lesTiers.size() != 0) {
         this.showModalTiers = true;
      } else {
         this.showModalTiers = false;
      }

   }

   public void selectionTiers() {
      if (this.datamodelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
      }

   }

   public void calculeTiers() throws JDOMException, IOException {
      if (this.lesTiers.size() != 0) {
         if (this.tiers != null) {
            this.produitsFournisseur.setTiers(this.tiers);
            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.produitsFournisseur.setProfouDevise(this.tiers.getTiedevise());
               this.produitsFournisseur.setProfouFormat(this.tiers.getTieFormatDevise());
            } else {
               this.produitsFournisseur.setProfouDevise(this.structureLog.getStrdevise());
               this.produitsFournisseur.setProfouFormat(this.structureLog.getStrformatdevise());
            }

            this.inpTiers = this.tiers.getTieraisonsocialenom();
            this.existCodTiers = true;
            if (this.lesProduitsFournisseurs.size() != 0) {
               for(int var1 = 0; var1 < this.lesProduitsFournisseurs.size(); ++var1) {
                  if (((ProduitsFournisseur)this.lesProduitsFournisseurs.get(var1)).getTiers().getTieraisonsocialenom().equalsIgnoreCase(this.inpTiers)) {
                     this.existCodTiers = false;
                     break;
                  }
               }
            }
         } else {
            this.tiers = null;
            this.produitsFournisseur.setProfouDevise("");
            this.produitsFournisseur.setProfouFormat(0);
            this.inpTiers = "";
            this.existCodTiers = false;
         }
      } else {
         this.tiers = null;
         this.produitsFournisseur.setProfouDevise("");
         this.produitsFournisseur.setProfouFormat(0);
         this.inpTiers = "";
         this.existCodTiers = false;
      }

      this.showModalTiers = false;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.produitsFournisseur.setProfouDevise("");
      this.produitsFournisseur.setProfouFormat(0);
      this.inpTiers = "";
      this.showModalTiers = false;
   }

   public void calculEuro() {
      if (this.produitsFournisseur != null) {
         if (this.produitsFournisseur.getProfouDevise() == null || this.produitsFournisseur.getProfouDevise().isEmpty()) {
            this.produitsFournisseur.setProfouDevise(this.structureLog.getStrdevise());
         }

         new ObjetDevises();
         ObjetDevises var1 = this.lectureDevises.devisesRecherchee(this.produitsFournisseur.getProfouDevise(), this.structureLog.getStrdevise());
         float var2 = 1.0F;
         if (var1.getTaux1() != null && !var1.getTaux1().isEmpty()) {
            var2 = Float.parseFloat(var1.getTaux1());
         }

         double var3 = this.produitsFournisseur.getProfouPa() * (double)var2;
         double var5 = this.utilNombre.myRoundFormat(var3, 1);
         this.var_prix_euro = var5;
      } else {
         this.var_prix_euro = 0.0D;
      }

   }

   public void saveProduitsFournisseur() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.produitsFournisseur.setTiers(this.tiers);
         this.produitsFournisseur.setProduits(this.produits);
         this.produitsFournisseur.setProfouFormat(this.formatDeviseProdFour());
         if (this.produitsFournisseur.getProfouDevise() == null || this.produitsFournisseur.getProfouDevise().isEmpty()) {
            this.produitsFournisseur.setProfouDevise(this.structureLog.getStrdevise());
            this.produitsFournisseur.setProfouFormat(this.structureLog.getStrformatdevise());
         }

         new ObjetDevises();
         ObjetDevises var3 = this.lectureDevises.devisesRecherchee(this.produitsFournisseur.getProfouDevise(), this.structureLog.getStrdevise());
         float var4 = 1.0F;
         if (var3.getTaux1() != null && !var3.getTaux1().isEmpty()) {
            var4 = Float.parseFloat(var3.getTaux1());
         }

         float var5 = 1.0F;
         if (var3.getTaux2() != null && !var3.getTaux2().isEmpty()) {
            var5 = Float.parseFloat(var3.getTaux2());
         }

         this.produitsFournisseur.setProfouCoefEuro(var4);
         if (this.produitsFournisseur.getProfouDevise().equalsIgnoreCase(this.structureLog.getStrdevise())) {
            this.produitsFournisseur.setProfouCoefLocal(1.0F);
            this.produitsFournisseur.setProfouPaLocal(this.produitsFournisseur.getProfouPa());
         } else {
            this.produitsFournisseur.setProfouCoefLocal(var5);
            double var6 = this.produitsFournisseur.getProfouPa() * (double)var4 * (double)var5;
            double var8 = this.utilNombre.myRoundFormat(var6, this.formatdeviseFournisseur);
            this.produitsFournisseur.setProfouPaLocal(var8);
         }

         if (this.inpInactifProdFour) {
            this.produitsFournisseur.setProfouInactif(1);
         } else {
            this.produitsFournisseur.setProfouInactif(0);
         }

         if (this.produitsFournisseur.getProfouId() == 0L) {
            this.produitsFournisseur = this.produitsFournisseurDao.insert(this.produitsFournisseur, var1);
            this.lesProduitsFournisseurs.add(this.produitsFournisseur);
            this.datamodelProduitFournisseur.setWrappedData(this.lesProduitsFournisseurs);
         } else {
            this.produitsFournisseur = this.produitsFournisseurDao.modif(this.produitsFournisseur, var1);
         }

         if (this.produitsFournisseur.getProfouRef() != null && !this.produitsFournisseur.getProfouRef().isEmpty()) {
            this.produitsHistoRef = this.produitsHistoRefDao.selectProdHistoRefByprod(this.produits, this.produitsFournisseur.getProfouRef(), var1);
            if (this.produitsHistoRef == null) {
               this.produitsHistoRef = new ProduitsHistoRef();
               this.produitsHistoRef.setProduits(this.produits);
               this.produitsHistoRef.setProhrfDateDebut(new Date());
               this.produitsHistoRef.setProhrfReference(this.produitsFournisseur.getProfouRef());
               this.produitsHistoRef = this.produitsHistoRefDao.insert(this.produitsHistoRef, var1);
            }

            this.chargerProduitHistoRef(var1);
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

      this.showModalProduitFournisseur = false;
      this.afficheButtModifProdFour = false;
      this.afficheButtSuppProdFour = false;
   }

   public int formatDeviseProdFour() {
      if (!this.produitsFournisseur.getProfouDevise().equalsIgnoreCase("XOF") && !this.produitsFournisseur.getProfouDevise().equalsIgnoreCase("XAF")) {
         if (!this.produitsFournisseur.getProfouDevise().equalsIgnoreCase("EUR") && !this.produitsFournisseur.getProfouDevise().equalsIgnoreCase("CHF")) {
            this.setFormatdeviseFournisseur(0);
         } else {
            this.setFormatdeviseFournisseur(1);
         }
      } else {
         this.setFormatdeviseFournisseur(2);
      }

      return this.formatdeviseFournisseur;
   }

   public void verifFouConditionnement1() {
      if (this.produitsFournisseur.getProfouCondition1() != null && !this.produitsFournisseur.getProfouCondition1().isEmpty()) {
         if (this.produitsFournisseur.getProfouCondition2() != null && !this.produitsFournisseur.getProfouCondition2().isEmpty() && this.produitsFournisseur.getProfouCondition1().contentEquals(this.produitsFournisseur.getProfouCondition2())) {
            this.produitsFournisseur.setProfouCondition1("");
         }

         if (this.produitsFournisseur.getProfouCondition3() != null && !this.produitsFournisseur.getProfouCondition3().isEmpty() && this.produitsFournisseur.getProfouCondition1().contentEquals(this.produitsFournisseur.getProfouCondition3())) {
            this.produitsFournisseur.setProfouCondition1("");
         }

         if (this.produitsFournisseur.getProfouCondition4() != null && !this.produitsFournisseur.getProfouCondition4().isEmpty() && this.produitsFournisseur.getProfouCondition1().contentEquals(this.produitsFournisseur.getProfouCondition4())) {
            this.produitsFournisseur.setProfouCondition1("");
         }

         if (this.produitsFournisseur.getProfouCondition5() != null && !this.produitsFournisseur.getProfouCondition5().isEmpty() && this.produitsFournisseur.getProfouCondition1().contentEquals(this.produitsFournisseur.getProfouCondition5())) {
            this.produitsFournisseur.setProfouCondition1("");
         }
      }

   }

   public void verifFouConditionnement2() {
      if (this.produitsFournisseur.getProfouCondition2() != null && !this.produitsFournisseur.getProfouCondition2().isEmpty()) {
         if (this.produitsFournisseur.getProfouCondition1() != null && !this.produitsFournisseur.getProfouCondition1().isEmpty() && this.produitsFournisseur.getProfouCondition2().contentEquals(this.produitsFournisseur.getProfouCondition1())) {
            this.produitsFournisseur.setProfouCondition2("");
         }

         if (this.produitsFournisseur.getProfouCondition3() != null && !this.produitsFournisseur.getProfouCondition3().isEmpty() && this.produitsFournisseur.getProfouCondition2().contentEquals(this.produitsFournisseur.getProfouCondition3())) {
            this.produitsFournisseur.setProfouCondition2("");
         }

         if (this.produitsFournisseur.getProfouCondition4() != null && !this.produitsFournisseur.getProfouCondition4().isEmpty() && this.produitsFournisseur.getProfouCondition2().contentEquals(this.produitsFournisseur.getProfouCondition4())) {
            this.produitsFournisseur.setProfouCondition2("");
         }

         if (this.produitsFournisseur.getProfouCondition5() != null && !this.produitsFournisseur.getProfouCondition5().isEmpty() && this.produitsFournisseur.getProfouCondition2().contentEquals(this.produitsFournisseur.getProfouCondition5())) {
            this.produitsFournisseur.setProfouCondition2("");
         }
      }

   }

   public void verifFouConditionnement3() {
      if (this.produitsFournisseur.getProfouCondition3() != null && !this.produitsFournisseur.getProfouCondition3().isEmpty()) {
         if (this.produitsFournisseur.getProfouCondition1() != null && !this.produitsFournisseur.getProfouCondition1().isEmpty() && this.produitsFournisseur.getProfouCondition3().contentEquals(this.produitsFournisseur.getProfouCondition1())) {
            this.produitsFournisseur.setProfouCondition3("");
         }

         if (this.produitsFournisseur.getProfouCondition2() != null && !this.produitsFournisseur.getProfouCondition2().isEmpty() && this.produitsFournisseur.getProfouCondition3().contentEquals(this.produitsFournisseur.getProfouCondition2())) {
            this.produitsFournisseur.setProfouCondition3("");
         }

         if (this.produitsFournisseur.getProfouCondition4() != null && !this.produitsFournisseur.getProfouCondition4().isEmpty() && this.produitsFournisseur.getProfouCondition3().contentEquals(this.produitsFournisseur.getProfouCondition4())) {
            this.produitsFournisseur.setProfouCondition3("");
         }

         if (this.produitsFournisseur.getProfouCondition5() != null && !this.produitsFournisseur.getProfouCondition5().isEmpty() && this.produitsFournisseur.getProfouCondition3().contentEquals(this.produitsFournisseur.getProfouCondition5())) {
            this.produitsFournisseur.setProfouCondition3("");
         }
      }

   }

   public void verifFouConditionnement4() {
      if (this.produitsFournisseur.getProfouCondition4() != null && !this.produitsFournisseur.getProfouCondition4().isEmpty()) {
         if (this.produitsFournisseur.getProfouCondition1() != null && !this.produitsFournisseur.getProfouCondition1().isEmpty() && this.produitsFournisseur.getProfouCondition4().contentEquals(this.produitsFournisseur.getProfouCondition1())) {
            this.produitsFournisseur.setProfouCondition4("");
         }

         if (this.produitsFournisseur.getProfouCondition2() != null && !this.produitsFournisseur.getProfouCondition2().isEmpty() && this.produitsFournisseur.getProfouCondition4().contentEquals(this.produitsFournisseur.getProfouCondition2())) {
            this.produitsFournisseur.setProfouCondition4("");
         }

         if (this.produitsFournisseur.getProfouCondition3() != null && !this.produitsFournisseur.getProfouCondition3().isEmpty() && this.produitsFournisseur.getProfouCondition4().contentEquals(this.produitsFournisseur.getProfouCondition3())) {
            this.produitsFournisseur.setProfouCondition4("");
         }

         if (this.produitsFournisseur.getProfouCondition5() != null && !this.produitsFournisseur.getProfouCondition5().isEmpty() && this.produitsFournisseur.getProfouCondition4().contentEquals(this.produitsFournisseur.getProfouCondition5())) {
            this.produitsFournisseur.setProfouCondition4("");
         }
      }

   }

   public void verifFouConditionnement5() {
      if (this.produitsFournisseur.getProfouCondition5() != null && !this.produitsFournisseur.getProfouCondition5().isEmpty()) {
         if (this.produitsFournisseur.getProfouCondition1() != null && !this.produitsFournisseur.getProfouCondition1().isEmpty() && this.produitsFournisseur.getProfouCondition5().contentEquals(this.produitsFournisseur.getProfouCondition1())) {
            this.produitsFournisseur.setProfouCondition5("");
         }

         if (this.produitsFournisseur.getProfouCondition2() != null && !this.produitsFournisseur.getProfouCondition2().isEmpty() && this.produitsFournisseur.getProfouCondition5().contentEquals(this.produitsFournisseur.getProfouCondition2())) {
            this.produitsFournisseur.setProfouCondition5("");
         }

         if (this.produitsFournisseur.getProfouCondition3() != null && !this.produitsFournisseur.getProfouCondition3().isEmpty() && this.produitsFournisseur.getProfouCondition5().contentEquals(this.produitsFournisseur.getProfouCondition3())) {
            this.produitsFournisseur.setProfouCondition5("");
         }

         if (this.produitsFournisseur.getProfouCondition4() != null && !this.produitsFournisseur.getProfouCondition4().isEmpty() && this.produitsFournisseur.getProfouCondition4().contentEquals(this.produitsFournisseur.getProfouCondition5())) {
            this.produitsFournisseur.setProfouCondition5("");
         }
      }

   }

   public void annuleFournisseur() {
      this.showModalProduitFournisseur = false;
   }

   public void chargerModalAddDepot() throws IOException {
      this.inpDepot = "";
      this.inpInactifProdDep = false;
      this.depotAchats = new DepotAchats();
      this.produitsDepot = new ProduitsDepot();
      this.existCodDepot = false;
      this.showModalProduitDepot = true;
   }

   public void chargerModalModDepot() throws IOException {
      this.existCodDepot = true;
      this.showModalProduitDepot = true;
   }

   public void suppressionProDepot() throws IOException, HibernateException, NamingException {
      this.produitsDepotDao.delete(this.produitsDepot);
      this.chargerProduitDepot((Session)null);
   }

   public void reactiverProdDepot() throws IOException, HibernateException, NamingException {
      this.produitsDepot.setProdepInactif(0);
      this.inpInactifProdDep = false;
      this.produitsDepotDao.modif(this.produitsDepot);
      this.chargerProduitDepot((Session)null);
   }

   public void selectProduitDepot() {
      if (this.datamodelDepot.isRowAvailable()) {
         this.produitsDepot = (ProduitsDepot)this.datamodelDepot.getRowData();
         this.depotAchats = this.produitsDepot.getDepot();
         this.inpDepot = this.produitsDepot.getDepot().getDpoCode() + ":" + this.produitsDepot.getDepot().getDpoLibelle();
         if (this.produitsDepot.getProdepInactif() == 0) {
            this.inpInactifProdDep = false;
         } else {
            this.inpInactifProdDep = true;
         }

         int var1 = this.produitsDepot.getProdepInactif();
         if (var1 != 2) {
            this.afficheButtModifDepProd = true;
            if (this.produitsDepot.getProdepQteStk() == 0.0F && this.produitsDepot.getProdepCoefPr() == 0.0F) {
               this.afficheButtSuppDepProd = true;
            } else {
               this.afficheButtSuppDepProd = false;
            }
         } else {
            this.afficheButtModifDepProd = false;
            this.afficheButtSuppDepProd = false;
         }
      }

   }

   public void verifDepot() throws HibernateException, NamingException {
      this.existCodDepot = false;
      if (this.inpDepot.contains(":")) {
         String[] var1 = this.inpDepot.split(":");
         String var2 = var1[0];
         this.depotAchats = this.depotAchatsDao.trouveDepot(var2, (Session)null);
         if (this.depotAchats != null) {
            if (this.lesProduitsDepos != null && this.lesProduitsDepos.size() != 0) {
               this.existCodDepot = true;

               for(int var3 = 0; var3 < this.lesProduitsDepos.size(); ++var3) {
                  if (((ProduitsDepot)this.lesProduitsDepos.get(var3)).getDepot().getDpoCode().equalsIgnoreCase(var2)) {
                     this.existCodDepot = false;
                     break;
                  }
               }
            } else {
               this.existCodDepot = true;
            }
         }
      }

   }

   public void saveProduitsDepot() throws HibernateException, NamingException {
      this.produitsDepot.setDepot(this.depotAchats);
      this.produitsDepot.setProduits(this.produits);
      if (this.inpInactifProdDep) {
         this.produitsDepot.setProdepInactif(1);
      } else {
         this.produitsDepot.setProdepInactif(0);
      }

      if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty() && this.produitsDepot.getProdepUnite().contains(":")) {
         String[] var1 = this.produitsDepot.getProdepUnite().split(":");
         this.unite = this.uniteDao.selectUnite(var1[0], (Session)null);
         if (this.unite != null) {
            this.produitsDepot.setUnite(this.unite);
            this.produitsDepot.setProdepEchelle(this.unite.getUniEchelle());
         } else {
            this.produitsDepot.setUnite((Unite)null);
            this.produitsDepot.setProdepEchelle(0);
         }
      } else {
         this.produitsDepot.setUnite((Unite)null);
         this.produitsDepot.setProdepEchelle(0);
      }

      this.produitsDepot.setProdepCle(this.produitsDepot.getDepot().getDpoCode() + ":" + this.produitsDepot.getProduits().getProCode());
      if (this.produitsDepot.getProdepGroupe() != null && !this.produitsDepot.getProdepGroupe().isEmpty()) {
         this.produitsDepot.setProdepCle2(this.produitsDepot.getProdepGroupe() + ":" + this.produitsDepot.getProduits().getProCode());
      } else {
         this.produitsDepot.setProdepCle2("");
      }

      if (this.produitsDepot.getProdepId() == 0L) {
         this.produitsDepot = this.produitsDepotDao.insert(this.produitsDepot);
         this.lesProduitsDepos.add(this.produitsDepot);
         this.datamodelDepot.setWrappedData(this.lesProduitsDepos);
      } else {
         this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot);
      }

      this.showModalProduitDepot = false;
      this.afficheButtModifDepProd = false;
      this.afficheButtSuppDepProd = false;
   }

   public void annuleProduitsDepot() {
      this.showModalProduitDepot = false;
   }

   public void recalculStockInitProduit() {
   }

   public void recalculStock() throws HibernateException, NamingException, ParseException {
      if (this.produits != null && this.lesProduitsDepos.size() != 0) {
         this.produits = this.recalculStockSuite(this.produits);
         this.initChargerStock();
      }

   }

   public Produits recalculStockSuite(Produits var1) throws HibernateException, NamingException, ParseException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         if (this.lesProduitsDepos.size() != 0) {
            for(int var4 = 0; var4 < this.lesProduitsDepos.size(); ++var4) {
               this.produitsDepot = new ProduitsDepot();
               this.produitsDepot = (ProduitsDepot)this.lesProduitsDepos.get(var4);
               new InventaireLigne();
               InventaireLigne var5 = this.calculStock.chercheDernierInventaire(var1.getProCode(), this.produitsDepot.getDepot().getDpoCode(), 0L, this.baseLog, var2);
               String var6 = "";
               if (var1.getProAchNat() != null && !var1.getProAchNat().isEmpty() && (var1.getProAchNat().equals("1105") || var1.getProAchNat().equals("0104") || var1.getProAchNat().equals("0105") || var1.getProAchNat().equals("1604") || var1.getProAchNat().equals("1605"))) {
                  var6 = var1.getProAchNat();
               } else if (var1.getProVteNat() != null && !var1.getProVteNat().isEmpty() && (var1.getProVteNat().equals("1105") || var1.getProVteNat().equals("0104") || var1.getProVteNat().equals("0105") || var1.getProVteNat().equals("1604") || var1.getProVteNat().equals("1605"))) {
                  var6 = var1.getProVteNat();
               }

               this.produitsDepot = this.calculStock.recalculStock(var6, this.produitsDepot, var5, var1.getProCode(), var1.getProLibTech(), this.produitsDepot.getDepot().getDpoCode(), 0L, this.optionsVentes.getGestionStockBc(), this.baseLog, this.structureLog, var2);
               if (this.produitsDepot != null) {
                  this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var2);
               }
            }
         }

         var3.commit();
      } catch (HibernateException var10) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public void recalculPumpInitProduit() throws HibernateException, NamingException, ParseException, groovyjarjarcommonscli.ParseException {
      if (this.produits != null) {
         this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
         this.devisLigneVentesDao = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
         this.commandeLigneVentesDao = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
         this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         this.factureLigneVentesDao = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
         this.retourLigneVentesDao = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
         this.avoirLigneVentesDao = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
         InventaireLigneDao var1 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
         BonEntreeLigneDao var2 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
         BonSortieLigneDao var3 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
         CessionLigneDao var4 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
         FabricationLigneAchatsDao var5 = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         ChargementLigneDao var6 = new ChargementLigneDao(this.baseLog, this.utilInitHibernate);
         PumpAchatsDao var7 = new PumpAchatsDao(this.baseLog, this.utilInitHibernate);
         NoteDebitLigneVentesDao var8 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
         CotationLigneAchatsDao var9 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         CommandeLigneAchatsDao var10 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         RetourLigneAchatsDao var11 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         FactureLigneAchatsDao var12 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         AvoirLigneAchatsDao var13 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         Utilitaires_RecalculPUMP var14 = new Utilitaires_RecalculPUMP(this.utilInitHibernate, this.baseLog, this.structureLog, this.usersLog);
         Date var15 = null;
         Date var16 = new Date();
         Session var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         this.calculStock = new CalculStock();
         Transaction var18 = null;

         try {
            var18 = var17.beginTransaction();
            int var19 = 0;

            while(true) {
               if (var19 >= this.lesProduitsDepos.size()) {
                  var18.commit();
                  break;
               }

               this.produitsDepot = (ProduitsDepot)this.lesProduitsDepos.get(var19);
               String var20 = this.produitsDepot.getDepot().getDpoCode() + ":" + this.produitsDepot.getProduits().getProCode();
               this.produitsDepot.setProdepCle(var20);
               String var21 = this.produitsDepot.getProdepGroupe() + ":" + this.produitsDepot.getProduits().getProCode();
               this.produitsDepot.setProdepCle2(var21);
               new InventaireLigne();
               InventaireLigne var22 = this.calculStock.chercheDernierInventaire(this.produits.getProCode(), this.produitsDepot.getDepot().getDpoCode(), 0L, this.baseLog, var17);
               if (var22 == null) {
                  new ReceptionLigneAchats();
                  ReceptionLigneAchats var23 = this.calculStock.chercheDernierReception(this.produits.getProCode(), this.produitsDepot.getDepot().getDpoCode(), 0L, this.baseLog, var17);
                  if (var23 != null) {
                     InventaireEntete var24 = new InventaireEntete();
                     var22 = new InventaireLigne();
                     var24.setInvDate(var23.getReceptionEnteteAchats().getRecDate());
                     var24.setInvEtat(var23.getReceptionEnteteAchats().getRecEtat());
                     var24.setInvNum(var23.getReceptionEnteteAchats().getRecNum());
                     var24.setInvActivite(var23.getReceptionEnteteAchats().getRecActivite());
                     var22.setInventaireEntete(var24);
                     var22.setInvligCode(var23.getRecligCode());
                     var22.setInvligLibelle(var23.getRecligLibelle());
                     var22.setInvligReference(var23.getRecligReference());
                     var22.setInvligFamille(var23.getRecligFamille());
                     var22.setInvligDepot(var23.getRecligDepot());
                     var22.setInvligQte(var23.getRecligQte());
                     var22.setInvligQteUtil(var23.getRecligQteUtil());
                     var22.setInvligPump(var23.getRecligPrU());
                     var22.setInvligPoidsBrut(var23.getRecligPoidsBrut());
                     var22.setInvligPoidsNet(var23.getRecligPoidsNet());
                     var22.setInvligUnite(var23.getRecligUnite());
                     var15 = var22.getInventaireEntete().getInvDate();
                  } else {
                     var15 = this.utilDate.stringToDateSQL("2013-01-01 00:00:00");
                  }
               } else {
                  var15 = var22.getInventaireEntete().getInvDate();
               }

               String var30 = "";
               if (this.produits.getProAchNat() == null || this.produits.getProAchNat().isEmpty() || !this.produits.getProAchNat().equals("1105") && !this.produits.getProAchNat().equals("0104") && !this.produits.getProAchNat().equals("0105") && !this.produits.getProAchNat().equals("1604") && !this.produits.getProAchNat().equals("1605")) {
                  if (this.produits.getProVteNat() == null || this.produits.getProVteNat().isEmpty() || !this.produits.getProVteNat().equals("1105") && !this.produits.getProVteNat().equals("0104") && !this.produits.getProVteNat().equals("0105") && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1605")) {
                     if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty()) {
                        var30 = this.produits.getProAchNat();
                     } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
                        var30 = this.produits.getProVteNat();
                     }
                  } else {
                     var30 = this.produits.getProVteNat();
                  }
               } else {
                  var30 = this.produits.getProAchNat();
               }

               this.produitsDepot = this.calculStock.recalculPump(this.optionAchats.getModCalcPump(), var30, this.produitsDepot, var22, this.produits.getProCode(), this.produits.getProLibTech(), this.produitsDepot.getDepot().getDpoCode(), 0L, this.optionsVentes.getGestionStockBc(), this.baseLog, this.structureLog, var17);
               if (this.produitsDepot.getProdepPr() == 0.0D) {
                  this.produitsDepot.setProdepPr(this.produitsDepot.getProdepPump());
               }

               this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var17);
               var14.recalculPUMP(this.utilDate, this.produits, this.produitsDepot.getDepot().getDpoCode(), this.calculStock, this.baseLog, this.structureLog, var15, var16, var17, this.exercicesAchats, this.produitsFournisseurDao, this.famillesProduitsAchatsDao, this.produitsAchsDao, this.produitsDepotDao, var1, var2, var3, var4, var5, var9, var10, var11, var12, var13, this.devisLigneVentesDao, this.commandeLigneVentesDao, this.livraisonLigneVentesDao, this.factureLigneVentesDao, this.retourLigneVentesDao, this.avoirLigneVentesDao, var6, var7, var8);
               ++var19;
            }
         } catch (HibernateException var28) {
            if (var18 != null) {
               var18.rollback();
            }

            throw var28;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.initChargerStock();
      }

   }

   public void recalculPv() throws HibernateException, NamingException {
      if (this.lesProduitsTarif.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            double var3 = 0.0D;
            new ArrayList();
            List var5 = this.produitsDepotDao.selectProdDepByprod(this.produits, var1);
            if (var5.size() != 0) {
               byte var6 = 0;
               if (var6 < var5.size()) {
                  if (((ProduitsDepot)var5.get(var6)).getProdepPump() != 0.0D && this.optionAchats.getModValoPvProd().equals("1")) {
                     var3 = ((ProduitsDepot)var5.get(var6)).getProdepPump();
                  } else if (((ProduitsDepot)var5.get(var6)).getProdepPr() != 0.0D && this.optionAchats.getModValoPvProd().equals("2")) {
                     var3 = ((ProduitsDepot)var5.get(var6)).getProdepPr();
                  }
               }
            }

            if (var3 != 0.0D && this.produits.getProCoefVte() != 0.0F) {
               for(int var14 = 0; var14 < this.lesProduitsTarif.size(); ++var14) {
                  this.produitsTarif = (ProduitsTarif)this.lesProduitsTarif.get(var14);
                  double var7 = this.utilNombre.myRoundDevise(var3 * (double)this.produits.getProCoefVte(), this.structureLog.getStrdevise());
                  this.produitsTarif.setProtarPv(var7);
                  this.produitsTarif = this.produitsTarifDao.modif(this.produitsTarif, var1);
               }
            }

            var2.commit();
         } catch (HibernateException var12) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void rechercheProduitsLies() throws HibernateException, NamingException {
      this.typeProduitRecherche = 1;
      if (this.produits.getProCodeLie() != null && !this.produits.getProCodeLie().isEmpty()) {
         this.lesProduitsLiesRecherche = new ArrayList();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         if (this.usersLog.getUsrProdServiceAch() == 1 && !this.usersLog.getUsrService().isEmpty()) {
            Service var6 = this.serviceDao.chargerLeServiceCode(this.usersLog.getUsrService(), var1);
            new ArrayList();
            List var7 = this.produitsServicesDao.selectProdServiceByservAchs(var6, this.produits.getProCodeLie(), this.var_TypeFind, var1);
            if (var7.size() != 0) {
               for(int var8 = 0; var8 < var7.size(); ++var8) {
                  new Produits();
                  Produits var5 = ((ProduitsServices)var7.get(var8)).getProduits();
                  this.lesProduitsLiesRecherche.add(var5);
               }
            }
         } else if (this.produits.getProCodeLie().contains("%")) {
            new ArrayList();
            List var2 = this.produitsMclesDao.verifProduits(this.produits.getProCodeLie(), this.var_TypeFind, var1);
            if (var2.size() != 0) {
               for(int var3 = 0; var3 < var2.size(); ++var3) {
                  new Produits();
                  Produits var4 = ((ProduitsMcles)var2.get(var3)).getProduits();
                  this.lesProduitsLiesRecherche.add(var4);
               }
            }
         } else {
            this.lesProduitsLiesRecherche = this.produitsAchsDao.verifProduits(this.produits.getProCodeLie(), var1);
         }

         this.datamodelProduitsLieRecherche.setWrappedData(this.lesProduitsLiesRecherche);
         this.utilInitHibernate.closeSession();
         this.showModalProduitRecherche = true;
      }

   }

   public void rechercheProduitsGroupe() throws HibernateException, NamingException {
      this.typeProduitRecherche = 2;
      if (this.produitsGrp.getProgrpCode() != null && !this.produitsGrp.getProgrpCode().isEmpty()) {
         this.lesProduitsLiesRecherche = new ArrayList();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         if (this.usersLog.getUsrProdServiceAch() == 1 && !this.usersLog.getUsrService().isEmpty()) {
            Service var6 = this.serviceDao.chargerLeServiceCode(this.usersLog.getUsrService(), var1);
            new ArrayList();
            List var7 = this.produitsServicesDao.selectProdServiceByservAchs(var6, this.produitsGrp.getProgrpCode(), this.var_TypeFind, var1);
            if (var7.size() != 0) {
               for(int var8 = 0; var8 < var7.size(); ++var8) {
                  new Produits();
                  Produits var5 = ((ProduitsServices)var7.get(var8)).getProduits();
                  this.lesProduitsLiesRecherche.add(var5);
               }
            }
         } else if (this.produitsGrp.getProgrpCode().contains("%")) {
            new ArrayList();
            List var2 = this.produitsMclesDao.verifProduits(this.produitsGrp.getProgrpCode(), this.var_TypeFind, var1);
            if (var2.size() != 0) {
               for(int var3 = 0; var3 < var2.size(); ++var3) {
                  new Produits();
                  Produits var4 = ((ProduitsMcles)var2.get(var3)).getProduits();
                  this.lesProduitsLiesRecherche.add(var4);
               }
            }
         } else {
            this.lesProduitsLiesRecherche = this.produitsAchsDao.verifProduits(this.produitsGrp.getProgrpCode(), var1);
         }

         this.datamodelProduitsLieRecherche.setWrappedData(this.lesProduitsLiesRecherche);
         this.utilInitHibernate.closeSession();
         this.showModalProduitRecherche = true;
      }

   }

   public void selectionProduits() {
      if (this.datamodelProduitsLieRecherche.isRowAvailable()) {
         this.produitsLies = (Produits)this.datamodelProduitsLieRecherche.getRowData();
      }

   }

   public void calculeProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.typeProduitRecherche == 1) {
         if (this.lesProduitsLiesRecherche.size() != 0) {
            if (this.produitsLies.getProId() != 0L) {
               this.produits.setProCodeLie(this.produitsLies.getProCode());
            } else {
               this.produitsLies = null;
               this.produits.setProCodeLie("");
               this.produits.setProQteLie(0.0F);
            }
         } else {
            this.produitsLies = null;
            this.produits.setProCodeLie("");
            this.produits.setProQteLie(0.0F);
         }
      } else if (this.typeProduitRecherche == 2) {
         this.mesDepotProduitGroupeItems.clear();
         if (this.lesProduitsLiesRecherche.size() != 0) {
            if (this.produitsLies.getProId() != 0L) {
               this.produitsGrp.setProgrpCode(this.produitsLies.getProCode());
               this.produitsGrp.setProgrpLibelle(this.produitsLies.getProLibClient());
               new ArrayList();
               List var1 = this.produitsDepotDao.selectProdDepByprod((String)this.produitsLies.getProCode(), (Session)null);
               if (var1.size() != 0) {
                  for(int var2 = 0; var2 < var1.size(); ++var2) {
                     this.mesDepotProduitGroupeItems.add(new SelectItem(((ProduitsDepot)var1.get(var2)).getDepot().getDpoCode()));
                  }
               } else {
                  this.mesDepotProduitGroupeItems.add(new SelectItem(""));
               }
            } else {
               this.annuleProduits();
            }
         } else {
            this.annuleProduits();
         }
      }

      this.showModalProduitRecherche = false;
   }

   public void annuleProduits() {
      if (this.typeProduitRecherche == 1) {
         this.produitsLies = null;
         this.produits.setProCodeLie("");
         this.produits.setProQteLie(0.0F);
      } else if (this.typeProduitRecherche == 2) {
         this.produitsLies = null;
         this.produitsGrp = new ProduitsGrp();
      }

      this.mesDepotProduitGroupeItems.add(new SelectItem(""));
      this.lesProduitsLiesRecherche.clear();
      this.datamodelProduitsLieRecherche.setWrappedData(this.lesProduitsLiesRecherche);
      this.showModalProduitRecherche = false;
   }

   public void initChargerMouvements() throws NamingException, ParseException {
      this.var_date_debut = this.utilDate.datePremierJourAnnee(new Date());
      this.var_date_fin = new Date();
      this.selRien();
      this.lesMvt = new ArrayList();
      this.datamodelMvt = new ListDataModel();
      this.datamodelMvt.setWrappedData(this.lesMvt);
      this.var_action = 4;
   }

   public void selStock() {
      this.var_mvt_as_inventaire = true;
      this.var_mvt_as_bin = true;
      this.var_mvt_as_bout = true;
      this.var_mvt_as_cession = true;
      this.var_mvt_as_fabrication = true;
      this.var_mvt_as_production = true;
      this.var_mvt_ss_pump = false;
      this.var_mvt_ss_fcotation = false;
      this.var_mvt_ss_fcommande = false;
      this.var_mvt_as_freception = true;
      this.var_mvt_as_fsav = true;
      this.var_mvt_ss_ffacture = false;
      this.var_mvt_ss_favoir = false;
      this.var_mvt_ss_cdevis = false;
      this.var_mvt_ss_ccmd = false;
      this.var_mvt_as_cbl = true;
      this.var_mvt_as_cchg = true;
      this.var_mvt_as_ticket = true;
      this.var_mvt_as_cretour = true;
      this.var_mvt_ss_cfacture = false;
      this.var_mvt_ss_cavoir = false;
      this.var_mvt_ss_cnoteDebit = false;
      this.lesMvt.clear();
      this.var_lib_etat = "Etat";
      this.var_lib_qteIn = "Qte In";
      this.var_lib_qteOut = "Qte Out";
      this.var_lib_pv = "P.V.";
   }

   public void selTout() {
      this.var_mvt_as_inventaire = true;
      this.var_mvt_as_bin = true;
      this.var_mvt_as_bout = true;
      this.var_mvt_as_cession = true;
      this.var_mvt_as_fabrication = true;
      this.var_mvt_as_production = true;
      this.var_mvt_ss_pump = false;
      this.var_mvt_ss_fcotation = true;
      this.var_mvt_ss_fcommande = true;
      this.var_mvt_as_freception = true;
      this.var_mvt_as_fsav = true;
      this.var_mvt_ss_ffacture = true;
      this.var_mvt_ss_favoir = true;
      this.var_mvt_ss_cdevis = true;
      this.var_mvt_ss_ccmd = true;
      this.var_mvt_as_cbl = true;
      this.var_mvt_as_cchg = true;
      this.var_mvt_as_ticket = true;
      this.var_mvt_as_cretour = true;
      this.var_mvt_ss_cfacture = true;
      this.var_mvt_ss_cavoir = true;
      this.var_mvt_ss_cnoteDebit = true;
      this.var_lib_etat = "Etat";
      this.var_lib_qteIn = "Qte In";
      this.var_lib_qteOut = "Qte Out";
      this.var_lib_pv = "P.V.";
   }

   public void selRien() {
      this.var_mvt_as_inventaire = false;
      this.var_mvt_as_bin = false;
      this.var_mvt_as_bout = false;
      this.var_mvt_as_cession = false;
      this.var_mvt_as_fabrication = false;
      this.var_mvt_as_production = false;
      this.var_mvt_ss_pump = false;
      this.var_mvt_ss_fcotation = false;
      this.var_mvt_ss_fcommande = false;
      this.var_mvt_as_freception = false;
      this.var_mvt_as_fsav = false;
      this.var_mvt_ss_ffacture = false;
      this.var_mvt_ss_favoir = false;
      this.var_mvt_ss_cdevis = false;
      this.var_mvt_ss_ccmd = false;
      this.var_mvt_as_cbl = false;
      this.var_mvt_as_cchg = false;
      this.var_mvt_as_ticket = false;
      this.var_mvt_as_cretour = false;
      this.var_mvt_ss_cfacture = false;
      this.var_mvt_ss_cavoir = false;
      this.var_mvt_ss_cnoteDebit = false;
      this.var_lib_etat = "Etat";
      this.var_lib_qteIn = "Qte In";
      this.var_lib_qteOut = "Qte Out";
      this.var_lib_pv = "P.V.";
   }

   public void selPump() {
      this.var_mvt_as_inventaire = false;
      this.var_mvt_as_bin = false;
      this.var_mvt_as_bout = false;
      this.var_mvt_as_cession = false;
      this.var_mvt_as_fabrication = false;
      this.var_mvt_as_production = false;
      this.var_mvt_ss_pump = true;
      this.var_mvt_ss_fcotation = false;
      this.var_mvt_ss_fcommande = false;
      this.var_mvt_as_freception = false;
      this.var_mvt_as_fsav = false;
      this.var_mvt_ss_ffacture = false;
      this.var_mvt_ss_favoir = false;
      this.var_mvt_ss_cdevis = false;
      this.var_mvt_ss_ccmd = false;
      this.var_mvt_as_cbl = false;
      this.var_mvt_as_cchg = false;
      this.var_mvt_as_ticket = false;
      this.var_mvt_as_cretour = false;
      this.var_mvt_ss_cfacture = false;
      this.var_mvt_ss_cavoir = false;
      this.var_lib_etat = "Origine";
      this.var_lib_qteIn = "Qte Mvt";
      this.var_lib_qteOut = "Qte Stk";
      this.var_lib_pv = "P.R.";
   }

   public void deSelPump() {
      this.var_mvt_ss_pump = false;
      this.var_lib_etat = "Etat";
      this.var_lib_qteIn = "Qte In";
      this.var_lib_qteOut = "Qte Out";
      this.var_lib_pv = "P.V.";
   }

   public void chargerMouvements() throws NamingException, ParseException {
      this.calculStock = new CalculStock();
      this.calculStock.setutilInitHibernate(this.utilInitHibernate);
      this.calculStock.setBaseLog(this.baseLog);
      this.calculStock.setStructureLog(this.structureLog);
      this.lesMvt.clear();
      String var1 = "";
      if (this.var_depot != null && this.var_depot.contains(":")) {
         String[] var2 = this.var_depot.split(":");
         var1 = var2[0];
         this.afficheProgress = true;
      } else {
         var1 = "";
         this.afficheProgress = false;
      }

      String var7 = "";
      if (this.var_activites != null && this.var_activites.contains(":")) {
         String[] var3 = this.var_activites.split(":");
         var7 = var3[0];
      } else {
         var7 = "";
      }

      String var8 = "";
      if (this.var_services != null && this.var_services.contains(":")) {
         var8 = this.var_services;
      } else {
         var8 = "";
      }

      String var4 = "";
      if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
         var4 = this.produits.getProVteNat();
      } else {
         var4 = this.produits.getProAchNat();
      }

      this.lesMvt = this.calculStock.chargerMouvements(0, "", var4, this.produits.getProCode(), this.produits.getProLibTech(), var1, 0L, var7, var8, this.var_date_debut, this.var_date_fin, this.var_mvt_ss_fcotation, this.var_mvt_ss_fcommande, this.var_mvt_as_freception, this.var_mvt_as_fsav, this.var_mvt_ss_ffacture, this.var_mvt_ss_favoir, this.var_mvt_as_inventaire, this.var_mvt_as_bin, this.var_mvt_as_bout, this.var_mvt_as_cession, this.var_mvt_as_fabrication, this.var_mvt_ss_cdevis, this.var_mvt_ss_ccmd, this.var_mvt_as_cbl, this.var_mvt_as_cretour, this.var_mvt_ss_cfacture, this.var_mvt_ss_cavoir, this.var_mvt_ss_pump, this.var_mvt_as_cchg, this.var_mvt_ss_cnoteDebit, this.var_mvt_as_ticket, this.optionsVentes.getGestionStockBc(), this.baseLog, this.structureLog, (Session)null);
      this.lesMvt = this.calculStock.sort(this.lesMvt);
      this.lesMvt = this.calculStock.sort(this.lesMvt);
      this.lesMvt = this.calculStock.sort(this.lesMvt);
      if (this.var_depot != null && !this.var_depot.isEmpty() && !this.var_depot.equals("0") && this.lesMvt.size() != 0) {
         float var5 = 0.0F;

         for(int var6 = 0; var6 < this.lesMvt.size(); ++var6) {
            this.stock = (Stock)this.lesMvt.get(var6);
            if (this.stock.getStk_code_depot() != null && !this.stock.getStk_code_depot().isEmpty() && (this.stock.getStk_etat().equals("Validé") || this.stock.getStk_etat().equals("Trf partiel") || this.stock.getStk_etat().equals("Trf total"))) {
               if (this.stock.getStk_type() == 30) {
                  this.stock.setStk_qte_progress(this.stock.getStk_qte_in());
                  var5 = this.stock.getStk_qte_progress();
               } else if (this.stock.getStk_type() != 31 && this.stock.getStk_type() != 33 && this.stock.getStk_type() != 34 && this.stock.getStk_type() != 13 && this.stock.getStk_type() != 24) {
                  this.stock.setStk_qte_progress(var5 + this.stock.getStk_qte_in() - this.stock.getStk_qte_out());
                  var5 = this.stock.getStk_qte_progress();
               } else {
                  this.stock.setStk_qte_progress(var5 + this.stock.getStk_qte_in() - this.stock.getStk_qte_out());
                  var5 = this.stock.getStk_qte_progress();
               }
            }
         }
      }

      this.datamodelMvt.setWrappedData(this.lesMvt);
      this.tot_qte_out = 0.0F;
      this.tot_qte_in = 0.0F;
      this.tot_montant = 0.0D;
      if (this.lesMvt.size() != 0) {
         for(int var9 = 0; var9 < this.lesMvt.size(); ++var9) {
            this.tot_qte_out += ((Stock)this.lesMvt.get(var9)).getStk_qte_out();
            this.tot_qte_in += ((Stock)this.lesMvt.get(var9)).getStk_qte_in();
            this.tot_montant += ((Stock)this.lesMvt.get(var9)).getStk_pv() * (double)((Stock)this.lesMvt.get(var9)).getStk_qte_out();
         }
      }

   }

   public void initChargerStock() throws HibernateException, NamingException {
      new ArrayList();
      this.lesProduitsDepos.clear();
      List var1;
      if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
         var1 = this.produitsDepotDao.selectProdDepByprod((Produits)this.produits, this.usersLog.getUsrService(), (Session)null);
      } else {
         var1 = this.produitsDepotDao.selectProdDepByprod((Produits)this.produits, (Session)null);
      }

      if (this.mesProduitsDepotsItems.size() != 0 && var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.produitsDepot = (ProduitsDepot)var1.get(var2);

            for(int var3 = 0; var3 < this.mesProduitsDepotsItems.size(); ++var3) {
               String[] var4 = ((SelectItem)this.mesProduitsDepotsItems.get(var3)).getLabel().toString().split(":");
               if (var4[0].equals(this.produitsDepot.getDepot().getDpoCode())) {
                  this.lesProduitsDepos.add(this.produitsDepot);
                  break;
               }
            }
         }
      } else {
         this.lesProduitsDepos = var1;
      }

      this.datamodelDepot.setWrappedData(this.lesProduitsDepos);
      this.var_action = 6;
   }

   public void initChargerSimulation() throws HibernateException, NamingException {
      if (this.produits != null) {
         this.calculPrp = new CalculPrp();
         this.calculPrp.setUtilInitHibernate(this.utilInitHibernate);
         this.calculPrp.setBaseLog(this.baseLog);
         this.calculPrp.setStructureLog(this.structureLog);
         this.calculPrp.setUsersLog(this.usersLog);
         this.calculPrp.InstancesDaoUtilses();
         this.calculPrp.setNature(500);
         this.calculPrp.setProduits(this.produits);
         this.calculPrp.initChargerSimulation();
         this.var_action = 7;
      }

   }

   public void annule() throws IOException, JDOMException {
      this.var_action = 0;
      this.afficheButtOption = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void initPublicSelect() throws IOException, SQLException {
      this.var_action = 5;
   }

   public void publierProduit() {
   }

   public void changerVersion() {
      Produits var1 = (Produits)this.datamodelProduit.getRowData();
      if (var1.isPublicBool()) {
         var1.setProPublic(1);
      } else {
         var1.setProPublic(0);
      }

   }

   public void changeCodeProduit() {
      if (this.produits != null) {
         this.fusionAjout = 0;
         this.ancienCode = this.produits.getProCode();
         this.nouveauCode = "";
         this.ancienneFamilleAchat = this.produits.getProAchCode() + ":" + this.produits.getProAchLib();
         this.nouvelleFamilleAchat = "";
         this.ancienneFamilleVente = this.produits.getProVteCode() + ":" + this.produits.getProVteLib();
         this.nouvelleFamilleVente = "";
         this.valideChange = false;
         this.var_action = 8;
      }

   }

   public void annuleChangeCodeProduit() {
      this.afficheButtSup = false;
      this.afficheButtOption = false;
      this.var_action = 0;
   }

   public void verifUnicite() throws HibernateException, NamingException {
      if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
         new Produits();
         Produits var1 = this.produitsAchsDao.chargeProduit(this.nouveauCode, (Session)null);
         if (var1 != null) {
            this.valideChange = false;
            this.nouveauCode = "";
         } else {
            this.valideChange = true;
         }
      }

   }

   public void verifUnicite2() throws HibernateException, NamingException {
      if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
         new Produits();
         Produits var1 = this.produitsAchsDao.chargeProduit(this.nouveauCode, (Session)null);
         if (var1 == null) {
            this.valideChange = false;
            this.nouveauCode = "";
         } else {
            this.valideChange = true;
         }
      }

   }

   public void valideChangeCodeProduit() throws HibernateException, NamingException, IOException, JDOMException, ParseException {
      boolean var1 = false;
      new Produits();
      new Produits();
      boolean var4 = false;
      Produits var3 = this.produits;
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var6 = null;

      try {
         var6 = var5.beginTransaction();
         this.utilDate = new UtilDate();
         ExercicesAchatsDao var7 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
         this.exercicesAchats = var7.recupererLastExo(var5);
         if (this.exercicesAchats != null) {
            String var8 = "";
            String var9 = "";
            String[] var10;
            if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && this.nouvelleFamilleAchat.contains(":")) {
               var10 = this.nouvelleFamilleAchat.split(":");
               var8 = var10[0];
            }

            if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && this.nouvelleFamilleVente.contains(":")) {
               var10 = this.nouvelleFamilleVente.split(":");
               var9 = var10[0];
            }

            var4 = false;
            new ArrayList();
            new DemandeLigneAchats();
            DemandeLigneAchatsDao var12 = new DemandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            List var98 = var12.chargerLesMvts(this.ancienCode, var5);
            if (var98.size() != 0) {
               for(int var13 = 0; var13 < var98.size(); ++var13) {
                  DemandeLigneAchats var11 = (DemandeLigneAchats)var98.get(var13);
                  if (var11 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var11.setDemligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var11.setDemligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var12.modifLigne(var11, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new CotationLigneAchats();
            CotationLigneAchatsDao var15 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            List var99 = var15.chargerLesMvts(this.ancienCode, var5);
            if (var99.size() != 0) {
               for(int var16 = 0; var16 < var99.size(); ++var16) {
                  CotationLigneAchats var14 = (CotationLigneAchats)var99.get(var16);
                  if (var14 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var14.setCotligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var14.setCotligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var15.modifLigne(var14, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new CommandeLigneAchats();
            CommandeLigneAchatsDao var18 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            List var100 = var18.chargerLesMvts(this.ancienCode, var5);
            if (var100.size() != 0) {
               for(int var19 = 0; var19 < var100.size(); ++var19) {
                  CommandeLigneAchats var17 = (CommandeLigneAchats)var100.get(var19);
                  if (var17 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var17.setCmdligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var17.setCmdligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var18.modifLigne(var17, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            ReceptionLigneAchats var20 = new ReceptionLigneAchats();
            ReceptionLigneAchatsDao var21 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            List var101 = var21.chargerLesMvts(this.ancienCode, var5);
            if (var101.size() != 0) {
               for(int var22 = 0; var22 < var101.size(); ++var22) {
                  var20 = (ReceptionLigneAchats)var101.get(var22);
                  if (var20 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var20.setRecligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var20.setRecligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var21.modifLigne(var20, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new RetourLigneAchats();
            RetourLigneAchatsDao var24 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            List var102 = var24.chargerLesMvts(this.ancienCode, var5);
            if (var102.size() != 0) {
               for(int var25 = 0; var25 < var102.size(); ++var25) {
                  RetourLigneAchats var23 = (RetourLigneAchats)var102.get(var25);
                  if (var20 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var23.setBrfligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var23.setBrfligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var24.modifLigne(var23, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new FactureLigneAchats();
            FactureLigneAchatsDao var27 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            List var103 = var27.chargerLesMvts(this.ancienCode, var5);
            if (var103.size() != 0) {
               for(int var28 = 0; var28 < var103.size(); ++var28) {
                  FactureLigneAchats var26 = (FactureLigneAchats)var103.get(var28);
                  if (var26 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var26.setFcfligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var26.setFcfligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var27.modifLigne(var26, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new AvoirLigneAchats();
            AvoirLigneAchatsDao var30 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            List var104 = var30.chargerLesMvts(this.ancienCode, var5);
            if (var104.size() != 0) {
               for(int var31 = 0; var31 < var104.size(); ++var31) {
                  AvoirLigneAchats var29 = (AvoirLigneAchats)var104.get(var31);
                  if (var29 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var29.setAvfligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var29.setAvfligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var30.modifLigne(var29, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new NoteDebitLigneAchats();
            NoteDebitLigneAchatsDao var33 = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            List var105 = var33.chargerLesMvts(this.ancienCode, var5);
            if (var105.size() != 0) {
               for(int var34 = 0; var34 < var105.size(); ++var34) {
                  NoteDebitLigneAchats var32 = (NoteDebitLigneAchats)var105.get(var34);
                  if (var32 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var32.setNdfligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var32.setNdfligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var33.modifLigne(var32, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new FraisLigneAchats();
            FraisLigneAchatsDao var36 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            List var106 = var36.chargerLesMvts(this.ancienCode, var5);
            if (var106.size() != 0) {
               for(int var37 = 0; var37 < var106.size(); ++var37) {
                  FraisLigneAchats var35 = (FraisLigneAchats)var106.get(var37);
                  if (var35 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var35.setFsfligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var35.setFsfligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var36.modifLigne(var35, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new BesoinLigneVentes();
            BesoinLigneVentesDao var39 = new BesoinLigneVentesDao(this.baseLog, this.utilInitHibernate);
            List var107 = var39.chargerLesMvts(this.ancienCode, var5);
            if (var107.size() != 0) {
               for(int var40 = 0; var40 < var107.size(); ++var40) {
                  BesoinLigneVentes var38 = (BesoinLigneVentes)var107.get(var40);
                  if (var38 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var38.setBesligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var38.setBesligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        var39.modifLigne(var38, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new DevisLigneVentes();
            this.devisLigneVentesDao = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
            List var108 = this.devisLigneVentesDao.chargerLesMvts(this.ancienCode, var5);
            if (var108.size() != 0) {
               for(int var42 = 0; var42 < var108.size(); ++var42) {
                  DevisLigneVentes var41 = (DevisLigneVentes)var108.get(var42);
                  if (var41 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var41.setDvsligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var41.setDvsligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        this.devisLigneVentesDao.modifLigne(var41, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new CommandeLigneVentes();
            this.commandeLigneVentesDao = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
            List var109 = this.commandeLigneVentesDao.chargerLesMvts(this.ancienCode, var5);
            if (var100.size() != 0) {
               for(int var44 = 0; var44 < var109.size(); ++var44) {
                  CommandeLigneVentes var43 = (CommandeLigneVentes)var109.get(var44);
                  if (var43 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var43.setBcmligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var43.setBcmligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        this.commandeLigneVentesDao.modifLigne(var43, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new LivraisonLigneVentes();
            this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
            List var110 = this.livraisonLigneVentesDao.chargerLesMvts(this.ancienCode, var5);
            if (var110.size() != 0) {
               for(int var46 = 0; var46 < var110.size(); ++var46) {
                  LivraisonLigneVentes var45 = (LivraisonLigneVentes)var110.get(var46);
                  if (var45 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var45.setBlvligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var45.setBlvligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        this.livraisonLigneVentesDao.modif(var45, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new LivraisonLivreeVentes();
            LivraisonLivreeVentesDao var48 = new LivraisonLivreeVentesDao(this.baseLog, this.utilInitHibernate);
            List var111 = var48.chargerLesMvts(this.ancienCode, var5);
            if (var111.size() != 0) {
               for(int var49 = 0; var49 < var111.size(); ++var49) {
                  LivraisonLivreeVentes var47 = (LivraisonLivreeVentes)var111.get(var49);
                  if (var47 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var47.setBlvlivCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (var4) {
                        var48.modifLigne(var47, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new PharmacieLigne();
            PharmacieLigneDao var51 = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
            List var112 = var51.chargerLesMvts(this.ancienCode, var5);
            if (var112.size() != 0) {
               for(int var52 = 0; var52 < var112.size(); ++var52) {
                  PharmacieLigne var50 = (PharmacieLigne)var112.get(var52);
                  if (var50 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var50.setPhaligProduit(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var50.setPhaligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        var51.modif(var50, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new RetourLigneVentes();
            this.retourLigneVentesDao = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
            List var113 = this.retourLigneVentesDao.chargerLesMvts(this.ancienCode, var5);
            if (var113.size() != 0) {
               for(int var54 = 0; var54 < var113.size(); ++var54) {
                  RetourLigneVentes var53 = (RetourLigneVentes)var113.get(var54);
                  if (var53 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var53.setBrtligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var53.setBrtligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        this.retourLigneVentesDao.modifLigne(var53, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new FactureLigneVentes();
            this.factureLigneVentesDao = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
            List var114 = this.factureLigneVentesDao.chargerLesMvts(this.ancienCode, var5);
            if (var114.size() != 0) {
               for(int var56 = 0; var56 < var114.size(); ++var56) {
                  FactureLigneVentes var55 = (FactureLigneVentes)var114.get(var56);
                  if (var55 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var55.setFacligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var55.setFacligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        this.factureLigneVentesDao.modifLigne(var55, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new AvoirLigneVentes();
            this.avoirLigneVentesDao = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
            List var115 = this.avoirLigneVentesDao.chargerLesMvts(this.ancienCode, var5);
            if (var115.size() != 0) {
               for(int var58 = 0; var58 < var115.size(); ++var58) {
                  AvoirLigneVentes var57 = (AvoirLigneVentes)var115.get(var58);
                  if (var57 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var57.setAvrligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var57.setAvrligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        this.avoirLigneVentesDao.modifLigne(var57, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new NoteDebitLigneVentes();
            NoteDebitLigneVentesDao var60 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
            List var116 = var60.chargerLesMvts(this.ancienCode, var5);
            if (var116.size() != 0) {
               for(int var61 = 0; var61 < var116.size(); ++var61) {
                  NoteDebitLigneVentes var59 = (NoteDebitLigneVentes)var116.get(var61);
                  if (var59 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var59.setNdbligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var59.setNdbligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        var60.modifLigne(var59, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new ChargementLigne();
            ChargementLigneDao var63 = new ChargementLigneDao(this.baseLog, this.utilInitHibernate);
            List var117 = var63.chargerLesMvts(this.ancienCode, var5);
            if (var117.size() != 0) {
               for(int var64 = 0; var64 < var117.size(); ++var64) {
                  ChargementLigne var62 = (ChargementLigne)var117.get(var64);
                  if (var62 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var62.setChaligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var62.setChaligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        var63.modif(var62, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new TicketLigneVentes();
            TicketLigneVentesDao var66 = new TicketLigneVentesDao(this.baseLog, this.utilInitHibernate);
            List var118 = var66.chargerLesMvts(this.ancienCode, var5);
            if (var118.size() != 0) {
               for(int var67 = 0; var67 < var118.size(); ++var67) {
                  TicketLigneVentes var65 = (TicketLigneVentes)var118.get(var67);
                  if (var65 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var65.setTicligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var65.setTicligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        var66.modif(var65, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new ContratLigneVentes();
            ContratLigneVentesDao var69 = new ContratLigneVentesDao(this.baseLog, this.utilInitHibernate);
            List var119 = var69.chargerLesMvts(this.ancienCode, var5);
            if (var119.size() != 0) {
               for(int var70 = 0; var70 < var119.size(); ++var70) {
                  ContratLigneVentes var68 = (ContratLigneVentes)var119.get(var70);
                  if (var68 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var68.setCrtligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var68.setCrtligFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        var69.modifLigne(var68, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new Cadeaux();
            CadeauxDao var72 = new CadeauxDao(this.baseLog, this.utilInitHibernate);
            List var120 = var72.chargerLesMvts(this.ancienCode, var5);
            if (var120.size() != 0) {
               for(int var73 = 0; var73 < var120.size(); ++var73) {
                  Cadeaux var71 = (Cadeaux)var120.get(var73);
                  if (var71 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var71.setCadCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0")) {
                        var71.setCadFamille(var9);
                        var4 = true;
                     }

                     if (var4) {
                        var72.modif(var71, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new InventaireLigne();
            InventaireLigneDao var75 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
            List var121 = var75.chargerLesMvts(this.ancienCode, var5);
            if (var121.size() != 0) {
               for(int var76 = 0; var76 < var121.size(); ++var76) {
                  InventaireLigne var74 = (InventaireLigne)var121.get(var76);
                  if (var74 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var74.setInvligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var74.setInvligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var75.modifLigne(var74, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new BonEntreeLigne();
            BonEntreeLigneDao var78 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
            List var122 = var78.chargerLesMvts(this.ancienCode, var5);
            if (var122.size() != 0) {
               for(int var79 = 0; var79 < var122.size(); ++var79) {
                  BonEntreeLigne var77 = (BonEntreeLigne)var122.get(var79);
                  if (var77 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var77.setBinligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var77.setBinligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var78.modifLigne(var77, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new BonSortieLigne();
            BonSortieLigneDao var81 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
            List var123 = var81.chargerLesMvts(this.ancienCode, var5);
            if (var123.size() != 0) {
               for(int var82 = 0; var82 < var123.size(); ++var82) {
                  BonSortieLigne var80 = (BonSortieLigne)var123.get(var82);
                  if (var80 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var80.setBouligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var80.setBouligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var81.modifLigne(var80, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new ParcConsommation();
            ParcConsommationDao var84 = new ParcConsommationDao(this.baseLog, this.utilInitHibernate);
            List var124 = var84.chargerLesMvts(this.ancienCode, var5);
            if (var124.size() != 0) {
               for(int var85 = 0; var85 < var124.size(); ++var85) {
                  ParcConsommation var83 = (ParcConsommation)var124.get(var85);
                  if (var83 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var83.setPrcconCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (var4) {
                        var84.modif(var83, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            var4 = false;
            new ArrayList();
            new CessionLigne();
            CessionLigneDao var87 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
            List var125 = var87.chargerLesMvts(this.ancienCode, var5);
            int var88;
            if (var125.size() != 0) {
               for(var88 = 0; var88 < var125.size(); ++var88) {
                  CessionLigne var86 = (CessionLigne)var125.get(var88);
                  if (var86 != null) {
                     if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                        var86.setCesligCode(this.nouveauCode);
                        var4 = true;
                     }

                     if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0")) {
                        var86.setCesligFamille(var8);
                        var4 = true;
                     }

                     if (var4) {
                        var87.modifLigne(var86, var5);
                     }
                  }
               }

               if (var4) {
                  var5.flush();
               }
            }

            this.lesProduitsDepos.clear();
            this.lesProduitsDepos = this.produitsDepotDao.selectProdDepByprod(this.produits, var5);
            if (this.lesProduitsDepos.size() != 0) {
               for(var88 = 0; var88 < this.lesProduitsDepos.size(); ++var88) {
                  this.produitsDepot = (ProduitsDepot)this.lesProduitsDepos.get(var88);
                  if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                     this.produitsDepot.setProdepCle(this.produitsDepot.getDepot().getDpoCode() + ":" + this.nouveauCode);
                  }

                  this.produitsDepotDao.modif(this.produitsDepot, var5);
               }
            }

            new ArrayList();
            new PumpAchats();
            PumpAchatsDao var90 = new PumpAchatsDao(this.baseLog, this.utilInitHibernate);
            List var126 = var90.chargerLesMvts(this.ancienCode, var5);
            if (var126.size() != 0) {
               for(int var91 = 0; var91 < var126.size(); ++var91) {
                  PumpAchats var89 = (PumpAchats)var126.get(var91);
                  if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                     var89.setPumProduit(this.nouveauCode);
                  }

                  var90.modif(var89, var5);
               }
            }

            Produits var2;
            String var92;
            FamillesProduitsAchats var127;
            FamillesProduitsVentes var128;
            Espion var129;
            EspionDao var130;
            if (this.fusionAjout == 0 && this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
               var2 = this.produitsAchsDao.chargeToutProduit(this.nouveauCode, var5);
               if (var2 != null) {
                  if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0") && !this.nouvelleFamilleAchat.equals("0_0_0_0")) {
                     var2.setProAchCode(var8);
                     new FamillesProduitsAchats();
                     var127 = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), var2, var5);
                     if (var127 != null) {
                        var92 = var127.getFamachLibelleFr();
                        var2.setProAchLib(var92);
                     } else {
                        var2.setProAchCode((String)null);
                        var2.setProAchLib((String)null);
                     }
                  } else if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && this.nouvelleFamilleAchat.equals("0_0_0_0")) {
                     var2.setProAchCode((String)null);
                     var2.setProAchLib((String)null);
                  }

                  if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0") && !this.nouvelleFamilleVente.equals("0_0_0_0")) {
                     var2.setProVteCode(var9);
                     new FamillesProduitsVentes();
                     var128 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var2, var5);
                     if (var128 != null) {
                        var92 = var128.getFamvteLibelleFr();
                        var2.setProVteLib(var92);
                     } else {
                        var2.setProVteCode((String)null);
                        var2.setProVteLib((String)null);
                     }
                  } else if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && this.nouvelleFamilleVente.equals("0_0_0_0")) {
                     var2.setProVteCode((String)null);
                     var2.setProVteLib((String)null);
                  }

                  this.produitsAchsDao.modif(var2, var5);
                  var129 = new Espion();
                  var130 = new EspionDao(this.baseLog, this.utilInitHibernate);
                  var129.setEspdtecreat(new Date());
                  var129.setUsers(this.usersLog);
                  var129.setEspaction("Procédure de Fusion du code " + this.ancienCode);
                  var129.setEsptype(this.inpTypTar);
                  var130.mAJEspion(var129, var5);
                  var129 = new Espion();
                  var129.setEspdtecreat(new Date());
                  var129.setUsers(this.usersLog);
                  if (this.ancienCode != null && !this.ancienCode.isEmpty() && this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                     var129.setEspaction("Fusion code " + this.ancienCode + " avec le code " + this.nouveauCode);
                  } else if (this.ancienneFamilleAchat != null && !this.ancienneFamilleAchat.isEmpty() && this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty()) {
                     var129.setEspaction("Fusion famille achat " + this.ancienneFamilleAchat + " avec la famille achat " + this.nouvelleFamilleAchat);
                  } else if (this.ancienneFamilleVente != null && !this.ancienneFamilleVente.isEmpty() && this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty()) {
                     var129.setEspaction("Fusion famille vente " + this.ancienneFamilleVente + " avec la famille vente " + this.nouvelleFamilleVente);
                  }

                  var129.setEsptype(this.inpTypTar);
                  var130.mAJEspion(var129, var5);
               }
            } else {
               var2 = this.produitsAchsDao.chargeToutProduit(this.ancienCode, var5);
               if (var2 != null) {
                  if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                     var2.setProCode(this.nouveauCode);
                  }

                  if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0") && !this.nouvelleFamilleAchat.equals("0_0_0_0")) {
                     var2.setProAchCode(var8);
                     new FamillesProduitsAchats();
                     var127 = this.famillesProduitsAchatsDao.rechercheFamilleByProd(this.exercicesAchats.getExeachId(), var2, var5);
                     if (var127 != null) {
                        var92 = var127.getFamachLibelleFr();
                        var2.setProAchLib(var92);
                     } else {
                        var2.setProAchCode((String)null);
                        var2.setProAchLib((String)null);
                     }
                  } else if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && this.nouvelleFamilleAchat.equals("0_0_0_0")) {
                     var2.setProAchCode((String)null);
                     var2.setProAchLib((String)null);
                  }

                  if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0") && !this.nouvelleFamilleVente.equals("0_0_0_0")) {
                     var2.setProVteCode(var9);
                     new FamillesProduitsVentes();
                     var128 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var2, var5);
                     if (var128 != null) {
                        var92 = var128.getFamvteLibelleFr();
                        var2.setProVteLib(var92);
                     } else {
                        var2.setProVteCode((String)null);
                        var2.setProVteLib((String)null);
                     }
                  } else if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && this.nouvelleFamilleVente.equals("0_0_0_0")) {
                     var2.setProVteCode((String)null);
                     var2.setProVteLib((String)null);
                  }

                  this.produitsAchsDao.modif(var2, var5);
                  var129 = new Espion();
                  var130 = new EspionDao(this.baseLog, this.utilInitHibernate);
                  var129.setEspdtecreat(new Date());
                  var129.setUsers(this.usersLog);
                  var129.setEspaction("Procédure de changement du code " + this.ancienCode);
                  var129.setEsptype(this.inpTypTar);
                  var130.mAJEspion(var129, var5);
                  var129 = new Espion();
                  var129.setEspdtecreat(new Date());
                  var129.setUsers(this.usersLog);
                  if (this.ancienCode != null && !this.ancienCode.isEmpty() && this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                     var129.setEspaction("Change code " + this.ancienCode + " par le code " + this.nouveauCode);
                  } else if (this.ancienneFamilleAchat != null && !this.ancienneFamilleAchat.isEmpty() && this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty()) {
                     var129.setEspaction("Change famille achat " + this.ancienneFamilleAchat + " par la famille achat " + this.nouvelleFamilleAchat);
                  } else if (this.ancienneFamilleVente != null && !this.ancienneFamilleVente.isEmpty() && this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty()) {
                     var129.setEspaction("Change famille vente " + this.ancienneFamilleVente + " par la famille vente " + this.nouvelleFamilleVente);
                  }

                  var129.setEsptype(this.inpTypTar);
                  var130.mAJEspion(var129, var5);
               }
            }

            var6.commit();
            var1 = true;
         }
      } catch (HibernateException var96) {
         var1 = false;
         if (var6 != null) {
            var6.rollback();
         }

         throw var96;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var1 && this.fusionAjout == 0 && this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
         this.supprimerProduit();
      }

      this.rechercherProduit();
      this.afficheButtSup = false;
      this.afficheButtOption = false;
      this.var_action = 0;
   }

   public long calculeLigneStock(Object[] var1) throws ParseException {
      long var2 = 0L;
      if (var1[4] != null) {
         var2 = Long.parseLong(var1[4].toString());
      }

      return var2;
   }

   public long calculeLigneAchat(Object[] var1) throws ParseException {
      long var2 = 0L;
      if (var1[6] != null) {
         var2 = Long.parseLong(var1[6].toString());
      }

      return var2;
   }

   public long calculeLigneVente(Object[] var1) throws ParseException {
      long var2 = 0L;
      if (var1[7] != null) {
         var2 = Long.parseLong(var1[7].toString());
      }

      return var2;
   }

   public long calculeLigneMedical(Object[] var1) throws ParseException {
      long var2 = 0L;
      if (var1[4] != null) {
         var2 = Long.parseLong(var1[4].toString());
      }

      return var2;
   }

   public long calculeLigneChargement(Object[] var1) throws ParseException {
      long var2 = 0L;
      if (var1[4] != null) {
         var2 = Long.parseLong(var1[4].toString());
      }

      return var2;
   }

   public void initInterchange() {
      this.outilChoisi = 99;
      this.toolsCompteOld = "";
      this.toolsDepotOld = "";
      this.var_action = 9;
   }

   public void annuleInterchange() {
      this.afficheButtSup = false;
      this.afficheButtOption = false;
      this.var_action = 0;
   }

   public void selectionAll() {
      if (this.lesMvt.size() != 0) {
         for(int var1 = 0; var1 < this.lesMvt.size(); ++var1) {
            this.stock = new Stock();
            this.stock = (Stock)this.lesMvt.get(var1);
            this.stock.setSelect(true);
         }

         this.datamodelMvt.setWrappedData(this.lesMvt);
      }

   }

   public void deselectionAll() {
      if (this.lesMvt.size() != 0) {
         for(int var1 = 0; var1 < this.lesMvt.size(); ++var1) {
            this.stock = new Stock();
            this.stock = (Stock)this.lesMvt.get(var1);
            this.stock.setSelect(false);
         }

         this.datamodelMvt.setWrappedData(this.lesMvt);
      }

   }

   public void validerInterchange() throws HibernateException, NamingException, ParseException {
      if (this.outilChoisi != 99) {
         Produits var1 = null;
         if (this.lesMvt.size() != 0) {
            Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
            Transaction var3 = null;

            try {
               var3 = var2.beginTransaction();
               new InventaireLigne();
               InventaireLigneDao var5 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
               new BonEntreeLigne();
               BonEntreeLigneDao var7 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
               new BonSortieLigne();
               BonSortieLigneDao var9 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
               new CessionLigne();
               CessionLigneDao var11 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
               new CotationLigneAchats();
               CotationLigneAchatsDao var13 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               new CommandeLigneAchats();
               CommandeLigneAchatsDao var15 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               new ReceptionLigneAchats();
               ReceptionLigneAchatsDao var17 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               new RetourLigneAchats();
               RetourLigneAchatsDao var19 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               new FactureLigneAchats();
               FactureLigneAchatsDao var21 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               new AvoirLigneAchats();
               AvoirLigneAchatsDao var23 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               new NoteDebitLigneAchats();
               NoteDebitLigneAchatsDao var25 = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               new DevisLigneVentes();
               this.devisLigneVentesDao = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
               new CommandeLigneVentes();
               this.commandeLigneVentesDao = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
               new LivraisonLigneVentes();
               this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
               new RetourLigneVentes();
               this.retourLigneVentesDao = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
               new AvoirLigneVentes();
               this.avoirLigneVentesDao = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
               new FactureLigneVentes();
               this.factureLigneVentesDao = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
               new NoteDebitLigneVentes();
               NoteDebitLigneVentesDao var33 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
               InventaireLigne var4;
               BonEntreeLigne var6;
               BonSortieLigne var8;
               CessionLigne var10;
               CotationLigneAchats var12;
               CommandeLigneAchats var14;
               ReceptionLigneAchats var16;
               RetourLigneAchats var18;
               FactureLigneAchats var20;
               DevisLigneVentes var26;
               CommandeLigneVentes var27;
               LivraisonLigneVentes var28;
               RetourLigneVentes var29;
               AvoirLigneVentes var30;
               FactureLigneVentes var31;
               NoteDebitLigneVentes var32;
               if (this.outilChoisi == 5 && this.toolsCompteOld != null && !this.toolsCompteOld.isEmpty()) {
                  new Produits();
                  String[] var50 = this.toolsCompteOld.split(":");
                  var1 = this.produitsAchsDao.chargeProduit(var50[0], (Session)null);
                  if (var1 != null) {
                     for(int var51 = 0; var51 < this.lesMvt.size(); ++var51) {
                        this.stock = (Stock)this.lesMvt.get(var51);
                        if (this.stock.isSelect()) {
                           if (this.stock.getStk_type() == 30) {
                              var4 = var5.rechercheInventaire(this.stock.getStk_id(), var2);
                              if (var4 != null) {
                                 var4.setInvligCode(var1.getProCode());
                                 var4.setInvligFamille(var1.getProVteCode());
                                 var4.setInvligLibelle(var1.getProLibClient());
                                 var5.modifLigne(var4, var2);
                              }
                           } else if (this.stock.getStk_type() == 31) {
                              var6 = var7.rechercheBonentree(this.stock.getStk_id(), var2);
                              if (var6 != null) {
                                 var6.setBinligCode(var1.getProCode());
                                 var6.setBinligFamille(var1.getProVteCode());
                                 var6.setBinligLibelle(var1.getProLibClient());
                                 var7.modifLigne(var6, var2);
                              }
                           } else if (this.stock.getStk_type() == 32) {
                              var8 = var9.rechercheBonsortie(this.stock.getStk_id(), var2);
                              if (var8 != null) {
                                 var8.setBouligCode(var1.getProCode());
                                 var8.setBouligFamille(var1.getProVteCode());
                                 var8.setBouligLibelle(var1.getProLibClient());
                                 var9.modifLigne(var8, var2);
                              }
                           } else if (this.stock.getStk_type() == 33) {
                              var10 = var11.rechercheCession(this.stock.getStk_id(), var2);
                              if (var10 != null) {
                                 var10.setCesligCode(var1.getProCode());
                                 var10.setCesligFamille(var1.getProVteCode());
                                 var10.setCesligLibelle(var1.getProLibClient());
                                 var11.modifLigne(var10, var2);
                              }
                           } else if (this.stock.getStk_type() == 11) {
                              var12 = var13.rechercheCotation(this.stock.getStk_id(), var2);
                              if (var12 != null) {
                                 var12.setCotligCode(var1.getProCode());
                                 var12.setCotligFamille(var1.getProVteCode());
                                 var12.setCotligLibelle(var1.getProLibClient());
                                 var13.modifLigne(var12, var2);
                              }
                           } else if (this.stock.getStk_type() == 12) {
                              var14 = var15.rechercheCommande(this.stock.getStk_id(), var2);
                              if (var14 != null) {
                                 var14.setCmdligCode(var1.getProCode());
                                 var14.setCmdligFamille(var1.getProVteCode());
                                 var14.setCmdligLibelle(var1.getProLibClient());
                                 var15.modifLigne(var14, var2);
                              }
                           } else if (this.stock.getStk_type() == 13) {
                              var16 = var17.rechercheReception(this.stock.getStk_id(), var2);
                              if (var16 != null) {
                                 var16.setRecligCode(var1.getProCode());
                                 var16.setRecligFamille(var1.getProVteCode());
                                 var16.setRecligLibelle(var1.getProLibClient());
                                 var17.modifLigne(var16, var2);
                              }
                           } else if (this.stock.getStk_type() == 14) {
                              var18 = var19.rechercheRetour(this.stock.getStk_id(), var2);
                              if (var18 != null) {
                                 var18.setBrfligCode(var1.getProCode());
                                 var18.setBrfligFamille(var1.getProVteCode());
                                 var18.setBrfligLibelle(var1.getProLibClient());
                                 var19.modifLigne(var18, var2);
                              }
                           } else if (this.stock.getStk_type() == 15) {
                              var20 = var21.rechercheFacture(this.stock.getStk_id(), var2);
                              if (var20 != null) {
                                 var20.setFcfligCode(var1.getProCode());
                                 var20.setFcfligFamille(var1.getProVteCode());
                                 var20.setFcfligLibelle(var1.getProLibClient());
                                 var21.modifLigne(var20, var2);
                              }
                           } else if (this.stock.getStk_type() == 16) {
                              AvoirLigneAchats var22 = var23.rechercheAvoir(this.stock.getStk_id(), var2);
                              if (var22 != null) {
                                 var22.setAvfligCode(var1.getProCode());
                                 var22.setAvfligFamille(var1.getProVteCode());
                                 var22.setAvfligLibelle(var1.getProLibClient());
                                 var23.modifLigne(var22, var2);
                              }
                           } else if (this.stock.getStk_type() == 17) {
                              NoteDebitLigneAchats var24 = var25.rechercheNoteDebit(this.stock.getStk_id(), var2);
                              if (var24 != null) {
                                 var24.setNdfligCode(var1.getProCode());
                                 var24.setNdfligFamille(var1.getProVteCode());
                                 var24.setNdfligLibelle(var1.getProLibClient());
                                 var25.modifLigne(var24, var2);
                              }
                           } else if (this.stock.getStk_type() == 21) {
                              var26 = this.devisLigneVentesDao.rechercheDevis(this.stock.getStk_id(), var2);
                              if (var26 != null) {
                                 var26.setDvsligCode(var1.getProCode());
                                 var26.setDvsligFamille(var1.getProVteCode());
                                 var26.setDvsligLibelle(var1.getProLibClient());
                                 this.devisLigneVentesDao.modifLigne(var26, var2);
                              }
                           } else if (this.stock.getStk_type() == 22) {
                              var27 = this.commandeLigneVentesDao.rechercheCommande(this.stock.getStk_id(), var2);
                              if (var27 != null) {
                                 var27.setBcmligCode(var1.getProCode());
                                 var27.setBcmligFamille(var1.getProVteCode());
                                 var27.setBcmligLibelle(var1.getProLibClient());
                                 this.commandeLigneVentesDao.modifLigne(var27, var2);
                              }
                           } else if (this.stock.getStk_type() == 23) {
                              var28 = this.livraisonLigneVentesDao.rechercheLivraison(this.stock.getStk_id(), var2);
                              if (var28 != null) {
                                 var28.setBlvligCode(var1.getProCode());
                                 var28.setBlvligFamille(var1.getProVteCode());
                                 var28.setBlvligLibelle(var1.getProLibClient());
                                 this.livraisonLigneVentesDao.modif(var28, var2);
                              }
                           } else if (this.stock.getStk_type() == 24) {
                              var29 = this.retourLigneVentesDao.rechercheRetour(this.stock.getStk_id(), var2);
                              if (var29 != null) {
                                 var29.setBrtligCode(var1.getProCode());
                                 var29.setBrtligFamille(var1.getProVteCode());
                                 var29.setBrtligLibelle(var1.getProLibClient());
                                 this.retourLigneVentesDao.modifLigne(var29, var2);
                              }
                           } else if (this.stock.getStk_type() == 25) {
                              var31 = this.factureLigneVentesDao.rechercheFacture(this.stock.getStk_id(), var2);
                              if (var31 != null) {
                                 var31.setFacligCode(var1.getProCode());
                                 var31.setFacligFamille(var1.getProVteCode());
                                 var31.setFacligLibelle(var1.getProLibClient());
                                 this.factureLigneVentesDao.modifLigne(var31, var2);
                              }
                           } else if (this.stock.getStk_type() == 26) {
                              var30 = this.avoirLigneVentesDao.rechercheAvoir(this.stock.getStk_id(), var2);
                              if (var30 != null) {
                                 var30.setAvrligCode(var1.getProCode());
                                 var30.setAvrligFamille(var1.getProVteCode());
                                 var30.setAvrligLibelle(var1.getProLibClient());
                                 this.avoirLigneVentesDao.modifLigne(var30, var2);
                              }
                           } else if (this.stock.getStk_type() == 27) {
                              var32 = var33.rechercheNoteDebit(this.stock.getStk_id(), var2);
                              if (var32 != null) {
                                 var32.setNdbligCode(var1.getProCode());
                                 var32.setNdbligFamille(var1.getProVteCode());
                                 var32.setNdbligLibelle(var1.getProLibClient());
                                 var33.modifLigne(var32, var2);
                              }
                           }
                        }
                     }
                  }
               } else if (this.outilChoisi == 6 && this.toolsDepotOld != null && !this.toolsDepotOld.isEmpty()) {
                  new InventaireEntete();
                  InventaireEnteteDao var35 = new InventaireEnteteDao(this.baseLog, this.utilInitHibernate);
                  new BonEntreeEntete();
                  BonEntreeEnteteDao var37 = new BonEntreeEnteteDao(this.baseLog, this.utilInitHibernate);
                  new BonSortieEntete();
                  BonSortieEnteteDao var39 = new BonSortieEnteteDao(this.baseLog, this.utilInitHibernate);
                  new CessionEntete();
                  CessionEnteteDao var41 = new CessionEnteteDao(this.baseLog, this.utilInitHibernate);
                  String var42 = "";
                  String var43 = "";
                  if (this.toolsDepotOld != null && !this.toolsDepotOld.isEmpty()) {
                     String[] var44;
                     if (this.toolsDepotOld.contains(":")) {
                        var44 = this.toolsDepotOld.split(":");
                        var42 = var44[0];
                     } else if (this.toolsDepotOld.contains("=")) {
                        var44 = this.toolsDepotOld.split("=");
                        var42 = var44[0];
                     }

                     this.depotAchats = new DepotAchats();
                     this.depotAchatsDao = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
                     this.depotAchats = this.depotAchatsDao.trouveDepot(var42, var2);
                     if (this.depotAchats != null) {
                        var43 = var42 + ":" + this.depotAchats.getDpoLibelle();
                     }
                  }

                  for(int var52 = 0; var52 < this.lesMvt.size(); ++var52) {
                     this.stock = (Stock)this.lesMvt.get(var52);
                     if (this.stock.isSelect()) {
                        if (this.stock.getStk_type() == 30) {
                           var4 = var5.rechercheInventaire(this.stock.getStk_id(), var2);
                           if (var4 != null) {
                              var4.setInvligDepot(var42);
                              var5.modifLigne(var4, var2);
                              InventaireEntete var34 = var35.pourParapheur(var4.getInventaireEntete().getInvId(), var2);
                              if (var34 != null && var34.getInvDepot().equals(var43)) {
                                 var34.setInvDepot(var43);
                                 var35.modif(var34, var2);
                              }
                           }
                        } else if (this.stock.getStk_type() == 31) {
                           var6 = var7.rechercheBonentree(this.stock.getStk_id(), var2);
                           if (var6 != null) {
                              var6.setBinligDepot(var42);
                              var7.modifLigne(var6, var2);
                              BonEntreeEntete var36 = var37.pourParapheur(var6.getBonEntreeEntete().getBinId(), var2);
                              if (var36 != null && var36.getBinDepot().equals(var42)) {
                                 var36.setBinDepot(var42);
                                 var37.modif(var36, var2);
                              }
                           }
                        } else if (this.stock.getStk_type() == 32) {
                           var8 = var9.rechercheBonsortie(this.stock.getStk_id(), var2);
                           if (var8 != null) {
                              var8.setBouligDepot(var42);
                              var9.modifLigne(var8, var2);
                              BonSortieEntete var38 = var39.pourParapheur(var8.getBonSortieEntete().getBouId(), var2);
                              if (var38 != null && var38.getBouDepot().equals(var42)) {
                                 var38.setBouDepot(var42);
                                 var39.modif(var38, var2);
                              }
                           }
                        } else if (this.stock.getStk_type() == 33) {
                           var10 = var11.rechercheCession(this.stock.getStk_id(), var2);
                           if (var10 != null) {
                              var10.setCesligDepotOrigine(var42);
                              var11.modifLigne(var10, var2);
                              CessionEntete var40 = var41.pourParapheur(var10.getCessionEntete().getCesId(), var2);
                              if (var40 != null && var40.getCesDepotOrigine().equals(var43)) {
                                 var40.setCesDepotOrigine(var43);
                                 var41.modif(var40, var2);
                              }
                           }
                        } else if (this.stock.getStk_type() == 11) {
                           var12 = var13.rechercheCotation(this.stock.getStk_id(), var2);
                           if (var12 != null) {
                              var12.setCotligDepot(var42);
                              var13.modifLigne(var12, var2);
                           }
                        } else if (this.stock.getStk_type() == 12) {
                           var14 = var15.rechercheCommande(this.stock.getStk_id(), var2);
                           if (var14 != null) {
                              var14.setCmdligDepot(var42);
                              var15.modifLigne(var14, var2);
                           }
                        } else if (this.stock.getStk_type() == 13) {
                           var16 = var17.rechercheReception(this.stock.getStk_id(), var2);
                           if (var16 != null) {
                              var16.setRecligDepot(var42);
                              var17.modifLigne(var16, var2);
                           }
                        } else if (this.stock.getStk_type() == 14) {
                           var18 = var19.rechercheRetour(this.stock.getStk_id(), var2);
                           if (var18 != null) {
                              var18.setBrfligDepot(var42);
                              var19.modifLigne(var18, var2);
                           }
                        } else if (this.stock.getStk_type() == 15) {
                           var20 = var21.rechercheFacture(this.stock.getStk_id(), var2);
                           if (var20 != null) {
                              var20.setFcfligDepot(var42);
                              var21.modifLigne(var20, var2);
                           }
                        } else if (this.stock.getStk_type() != 16 && this.stock.getStk_type() != 17) {
                           if (this.stock.getStk_type() == 21) {
                              var26 = this.devisLigneVentesDao.rechercheDevis(this.stock.getStk_id(), var2);
                              if (var26 != null) {
                                 var26.setDvsligDepot(var42);
                                 this.devisLigneVentesDao.modifLigne(var26, var2);
                              }
                           } else if (this.stock.getStk_type() == 22) {
                              var27 = this.commandeLigneVentesDao.rechercheCommande(this.stock.getStk_id(), var2);
                              if (var27 != null) {
                                 var27.setBcmligDepot(var42);
                                 this.commandeLigneVentesDao.modifLigne(var27, var2);
                              }
                           } else if (this.stock.getStk_type() == 23) {
                              var28 = this.livraisonLigneVentesDao.rechercheLivraison(this.stock.getStk_id(), var2);
                              if (var28 != null) {
                                 var28.setBlvligDepot(var42);
                                 this.livraisonLigneVentesDao.modif(var28, var2);
                              }
                           } else if (this.stock.getStk_type() == 24) {
                              var29 = this.retourLigneVentesDao.rechercheRetour(this.stock.getStk_id(), var2);
                              if (var29 != null) {
                                 var29.setBrtligDepot(var42);
                                 this.retourLigneVentesDao.modifLigne(var29, var2);
                              }
                           } else if (this.stock.getStk_type() == 25) {
                              var31 = this.factureLigneVentesDao.rechercheFacture(this.stock.getStk_id(), var2);
                              if (var31 != null) {
                                 var31.setFacligDepot(var42);
                                 this.factureLigneVentesDao.modifLigne(var31, var2);
                              }
                           } else if (this.stock.getStk_type() == 26) {
                              var30 = this.avoirLigneVentesDao.rechercheAvoir(this.stock.getStk_id(), var2);
                              if (var30 != null) {
                                 var30.setAvrligDepot(var42);
                                 this.avoirLigneVentesDao.modifLigne(var30, var2);
                              }
                           } else if (this.stock.getStk_type() == 27) {
                              var32 = var33.rechercheNoteDebit(this.stock.getStk_id(), var2);
                              if (var32 != null) {
                                 var32.setNdbligDepot(var42);
                                 var33.modifLigne(var32, var2);
                              }
                           }
                        }
                     }
                  }
               }

               var3.commit();
            } catch (HibernateException var48) {
               if (var3 != null) {
                  var3.rollback();
               }

               throw var48;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.lesProduitsDepos.clear();
            this.lesProduitsDepos = this.produitsDepotDao.selectProdDepByprod((Produits)this.produits, (Session)null);
            this.recalculStockSuite(this.produits);
            if (var1 != null) {
               this.recalculStockSuite(var1);
            }
         }

         this.annuleInterchange();
      }

   }

   public void rechercheProduitsutils() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.rechercheProduitAchat(this.toolsCompteOld, 100);
      if (this.produits != null) {
         if (this.produits.getProId() != 0L) {
            this.calculeProduitsOutils();
         } else {
            this.var_action = 10;
         }
      } else if (this.produits == null) {
         this.calculeProduits();
      }

   }

   public void recuperationProduitOutils() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.calculeProduit();
      this.calculeProduitsOutils();
   }

   public void calculeProduitsOutils() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         this.toolsCompteOld = this.produits.getProCode() + ":" + this.produits.getProLibClient();
      } else {
         this.annuleProduitsOutils();
      }

      this.var_action = 9;
   }

   public void annuleProduitsOutils() {
      this.toolsCompteOld = "";
      this.var_action = 9;
   }

   public void initImpression() throws IOException {
      this.var_choix_modele = 0;
      this.listeDocImp();
      this.showModalPanelPrint = true;
   }

   public void initImpressionMvts() throws IOException {
      this.var_choix_modele = 2;
      this.showModalPanelPrint = true;
   }

   public void listeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else {
         this.affListeDoc = true;
      }

   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
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
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && this.impDestinataire != null && !this.impDestinataire.isEmpty()) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (!this.format.equals("MAIL")) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            this.requete = " pro_id='" + this.produits.getProId() + "'";
            this.utilPrint.setSource("");
            this.utilPrint.setRecordPath("");
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setEntete("Impression Produit");
            this.utilPrint.setRequete(this.requete);
            this.utilPrint.setFiltre("");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "produit" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            ArrayList var1 = new ArrayList();
            JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.var_choix_modele == 1) {
         if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
            this.utilPrint.setSource("");
            this.utilPrint.setRecordPath("");
            this.utilPrint.setRapport(this.nomModeleListe);
            this.utilPrint.setEntete("Impression de la liste des produits");
            this.utilPrint.setRequete("");
            this.utilPrint.setFiltre("");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "produit" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            if (this.lesProduits.size() != 0) {
               Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");

               for(int var9 = 0; var9 < this.lesProduits.size(); ++var9) {
                  this.produits = new Produits();
                  this.produits = (Produits)this.lesProduits.get(var9);
                  String var3 = "";
                  if (this.produits.getProPhoto() != null && !this.produits.getProPhoto().isEmpty()) {
                     var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator + this.produits.getProPhoto();
                  }

                  this.produits.setPhoto(var3);
                  new ArrayList();
                  List var4 = this.produitsTarifDao.selectProdTarifByprod(this.produits, var6);
                  if (var4.size() != 0) {
                     for(int var5 = 0; var5 < var4.size(); ++var5) {
                        if (((ProduitsTarif)var4.get(var5)).getProtarOrdre() == 0) {
                           this.produits.setPv1(((ProduitsTarif)var4.get(var5)).getProtarPv());
                        } else if (((ProduitsTarif)var4.get(var5)).getProtarOrdre() == 1) {
                           this.produits.setPv2(((ProduitsTarif)var4.get(var5)).getProtarPv());
                        } else if (((ProduitsTarif)var4.get(var5)).getProtarOrdre() == 2) {
                           this.produits.setPv3(((ProduitsTarif)var4.get(var5)).getProtarPv());
                        } else if (((ProduitsTarif)var4.get(var5)).getProtarOrdre() == 3) {
                           this.produits.setPv4(((ProduitsTarif)var4.get(var5)).getProtarPv());
                        } else if (((ProduitsTarif)var4.get(var5)).getProtarOrdre() == 4) {
                           this.produits.setPv5(((ProduitsTarif)var4.get(var5)).getProtarPv());
                        }
                     }
                  }
               }

               this.utilInitHibernate.closeSession();
            }

            JRBeanCollectionDataSource var7 = new JRBeanCollectionDataSource(this.lesProduits);
            this.utilPrint.setjRBeanCollectionDataSource(var7);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.var_choix_modele == 2 && this.nomModeleMvts != null && !this.nomModeleMvts.isEmpty()) {
         this.chargerMouvements();
         if (this.lesMvt.size() != 0) {
            this.utilPrint.setRapport(this.nomModeleMvts);
            String var8 = this.utilDate.dateToStringFr(this.var_date_debut);
            String var10 = this.utilDate.dateToStringFr(this.var_date_fin);
            this.utilPrint.setEntete("Mouvements produit du " + var8 + " au " + var10);
            this.utilPrint.setRequete("");
            this.utilPrint.setFiltre(this.produits.getProCode() + " " + this.produits.getProLibClient());
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "mouvement" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            JRBeanCollectionDataSource var11 = new JRBeanCollectionDataSource(this.lesMvt);
            this.utilPrint.setjRBeanCollectionDataSource(var11);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

   }

   public void imprimerPRTpubProd() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.imprimerPubProd();
   }

   public void imprimerJRVpubProd() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimerPubProd();
   }

   public void imprimerPDFpubProd() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimerPubProd();
   }

   public void imprimerODTpubProd() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimerPubProd();
   }

   public void imprimerXLSpubProd() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimerPubProd();
   }

   public void imprimerDOCpubProd() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimerPubProd();
   }

   public void imprimerHTMLpubProd() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimerPubProd();
   }

   public void imprimerXMLpubProd() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimerPubProd();
   }

   public void imprimerPubProd() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (!this.format.equals("MAIL")) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.utilPrint.setSource("");
      this.utilPrint.setRecordPath("");
      this.utilPrint.setRapport("PublicationsProduits");
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "ecommerce" + File.separator);
      this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
      this.utilPrint.setEntete("Liste des publications des produits");
      this.utilPrint.setFiltre("");
      this.utilPrint.setRequete("");
      this.utilPrint.setFormat(this.format);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      this.utilPrint.imprimeRapport();
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
      if (this.lesMvt.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "PRODUITS : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "PRODUITS : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = Integer.parseInt(this.optionAchats.getNbDecQte());
         }

         this.titreGraph = "Analyse des mouvements : " + this.produits.getProCode() + ":" + this.produits.getProLibClient();
         String var2 = this.utilDate.dateToStringFr(this.var_date_debut);
         String var3 = this.utilDate.dateToStringFr(this.var_date_fin);
         this.titreGraph = this.titreGraph + " Du " + var2 + " au " + var3;
         this.sousTitreGraph = "";
         if (this.modeGraph == 0) {
            this.sousTitreGraph = this.sousTitreGraph + " - En Global (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 4) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par société (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 7) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par dossier (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 8) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par depot (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 9) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par type de mouvement (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 10) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par PV/PUMP (" + this.uniteGraph + ")";
         }

         if (this.lesMvt.size() != 0) {
            String var4 = "";
            long var5 = 0L;
            boolean var7 = false;

            for(int var8 = 0; var8 < this.lesMvt.size(); ++var8) {
               this.stock = (Stock)this.lesMvt.get(var8);
               var4 = "";
               var5 = 0L;
               byte var11 = 0;
               if (this.modeGraph == 0) {
                  int var9 = this.stock.getStk_date_mvt().getYear() + 1900;
                  var4 = "" + var9;
                  var1 = this.calculligne((List)var1, var4, var11, var5);
               } else if (this.modeGraph == 4) {
                  if (this.stock.getStk_tiers() != null && !this.stock.getStk_tiers().isEmpty()) {
                     var4 = this.stock.getStk_tiers();
                  } else {
                     var4 = "Sans Tiers";
                  }

                  var1 = this.calculligne((List)var1, var4, var11, var5);
               } else if (this.modeGraph == 7) {
                  if (this.stock.getStk_dossier() != null && !this.stock.getStk_dossier().isEmpty()) {
                     var4 = this.stock.getStk_dossier();
                  } else {
                     var4 = "Sans Dossier";
                  }

                  var1 = this.calculligne((List)var1, var4, var11, var5);
               } else if (this.modeGraph == 8) {
                  if (this.stock.getStk_code_depot() != null && !this.stock.getStk_code_depot().isEmpty()) {
                     var4 = this.stock.getStk_code_depot();
                  } else {
                     var4 = "Sans Depot";
                  }

                  var1 = this.calculligne((List)var1, var4, var11, var5);
               } else if (this.modeGraph != 9) {
                  if (this.modeGraph == 10) {
                     var4 = "P.V.";
                     this.valQteGraph = 0;
                     List var10 = this.calculligne((List)var1, var4, var11, var5);
                     var4 = "PUMP";
                     this.valQteGraph = 1;
                     var1 = this.calculligne(var10, var4, var11, var5);
                  }
               } else {
                  if (this.stock.getStk_lib_type() != null && !this.stock.getStk_lib_type().isEmpty()) {
                     var4 = this.stock.getStk_lib_type();
                  } else {
                     var4 = "Sans Type";
                  }

                  var1 = this.calculligne((List)var1, var4, var11, var5);
               }
            }

            var1 = this.calculePourcentage((List)var1);
         }
      }

      this.showModele = true;
      return (List)var1;
   }

   public List calculligne(List var1, String var2, int var3, long var4) {
      if (this.valQteGraph == 0) {
         var4 = (long)(this.stock.getStk_pv() * (double)(this.stock.getStk_qte_in() + this.stock.getStk_qte_out()));
      } else if (this.valQteGraph == 1) {
         var4 = (long)(this.stock.getStk_pump() * (double)(this.stock.getStk_qte_in() + this.stock.getStk_qte_out()));
      } else if (this.valQteGraph == 2) {
         var4 = (long)(this.stock.getStk_qte_in() + this.stock.getStk_qte_out());
      } else if (this.valQteGraph == 3) {
         var4 = (long)this.stock.getStk_coefPr();
      }

      if (this.timeDecoupage == 0) {
         var3 = this.stock.getStk_date_mvt().getDate();
      } else if (this.timeDecoupage == 1) {
         var3 = this.stock.getStk_date_mvt().getMonth() + 1;
      } else if (this.timeDecoupage == 2) {
         if (this.stock.getStk_date_mvt().getMonth() + 1 >= 1 && this.stock.getStk_date_mvt().getMonth() + 1 <= 3) {
            var3 = 1;
         } else if (this.stock.getStk_date_mvt().getMonth() + 1 >= 4 && this.stock.getStk_date_mvt().getMonth() + 1 <= 6) {
            var3 = 2;
         } else if (this.stock.getStk_date_mvt().getMonth() + 1 >= 7 && this.stock.getStk_date_mvt().getMonth() + 1 <= 9) {
            var3 = 3;
         } else if (this.stock.getStk_date_mvt().getMonth() + 1 >= 10 && this.stock.getStk_date_mvt().getMonth() + 1 <= 12) {
            var3 = 4;
         }
      } else if (this.timeDecoupage == 3) {
         if (this.stock.getStk_date_mvt().getMonth() + 1 >= 1 && this.stock.getStk_date_mvt().getMonth() + 1 <= 6) {
            var3 = 1;
         } else if (this.stock.getStk_date_mvt().getMonth() + 1 >= 7 && this.stock.getStk_date_mvt().getMonth() + 1 <= 12) {
            var3 = 2;
         }
      } else if (this.timeDecoupage == 4) {
         var3 = 1;
      }

      var1 = this.calculeListe(var1, var2, var3, var4);
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

   public String getTarifOrdClt() {
      return this.tarifOrdClt;
   }

   public void setTarifOrdClt(String var1) {
      this.tarifOrdClt = var1;
   }

   public boolean isTestDoubleProduitsTarif() {
      return this.testDoubleProduitsTarif;
   }

   public void setTestDoubleProduitsTarif(boolean var1) {
      this.testDoubleProduitsTarif = var1;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
   }

   public String getHtTtc() {
      return this.htTtc;
   }

   public void setHtTtc(String var1) {
      this.htTtc = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isErrorConnection() {
      return this.errorConnection;
   }

   public void setErrorConnection(boolean var1) {
      this.errorConnection = var1;
   }

   public List getLesProduits() {
      return this.lesProduits;
   }

   public void setLesProduits(List var1) {
      this.lesProduits = var1;
   }

   public DataModel getDatamodelProduit() {
      return this.datamodelProduit;
   }

   public void setDatamodelProduit(DataModel var1) {
      this.datamodelProduit = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public String getPdfFileName() {
      return this.pdfFileName;
   }

   public void setPdfFileName(String var1) {
      this.pdfFileName = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public boolean isAfficheButtOption() {
      return this.afficheButtOption;
   }

   public void setAfficheButtOption(boolean var1) {
      this.afficheButtOption = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String var1) {
      this.description = var1;
   }

   public boolean isExistCod() {
      return this.existCod;
   }

   public void setExistCod(boolean var1) {
      this.existCod = var1;
   }

   public String getMessageBut() {
      return this.messageBut;
   }

   public void setMessageBut(String var1) {
      this.messageBut = var1;
   }

   public String getDisable() {
      return this.disable;
   }

   public void setDisable(String var1) {
      this.disable = var1;
   }

   public boolean isAfficheButtSup() {
      return this.afficheButtSup;
   }

   public void setAfficheButtSup(boolean var1) {
      this.afficheButtSup = var1;
   }

   public String getInpNatureVnt() {
      return this.inpNatureVnt;
   }

   public void setInpNatureVnt(String var1) {
      this.inpNatureVnt = var1;
   }

   public DataModel getDatamodelDepot() {
      return this.datamodelDepot;
   }

   public void setDatamodelDepot(DataModel var1) {
      this.datamodelDepot = var1;
   }

   public DataModel getDatamodelTarif() {
      return this.datamodelTarif;
   }

   public void setDatamodelTarif(DataModel var1) {
      this.datamodelTarif = var1;
   }

   public DataModel getDatamodelCode() {
      return this.datamodelCode;
   }

   public void setDatamodelCode(DataModel var1) {
      this.datamodelCode = var1;
   }

   public DataModel getDatamodelProService() {
      return this.datamodelProService;
   }

   public void setDatamodelProService(DataModel var1) {
      this.datamodelProService = var1;
   }

   public List getLesProduitsServices() {
      return this.lesProduitsServices;
   }

   public void setLesProduitsServices(List var1) {
      this.lesProduitsServices = var1;
   }

   public List getLesProduitsTarif() {
      return this.lesProduitsTarif;
   }

   public void setLesProduitsTarif(List var1) {
      this.lesProduitsTarif = var1;
   }

   public List getLesProduitsDepos() {
      return this.lesProduitsDepos;
   }

   public void setLesProduitsDepos(List var1) {
      this.lesProduitsDepos = var1;
   }

   public ProduitsTarif getProduitsTarif() {
      return this.produitsTarif;
   }

   public void setProduitsTarif(ProduitsTarif var1) {
      this.produitsTarif = var1;
   }

   public boolean isAfficheButtModifProdTar() {
      return this.afficheButtModifProdTar;
   }

   public void setAfficheButtModifProdTar(boolean var1) {
      this.afficheButtModifProdTar = var1;
   }

   public boolean isAfficheButtSuppProdTar() {
      return this.afficheButtSuppProdTar;
   }

   public void setAfficheButtSuppProdTar(boolean var1) {
      this.afficheButtSuppProdTar = var1;
   }

   public boolean isInpInactifProdTarif() {
      return this.inpInactifProdTarif;
   }

   public void setInpInactifProdTarif(boolean var1) {
      this.inpInactifProdTarif = var1;
   }

   public int getInpTypTar() {
      return this.inpTypTar;
   }

   public void setInpTypTar(int var1) {
      this.inpTypTar = var1;
   }

   public DataModel getDatamodelMotCle() {
      return this.datamodelMotCle;
   }

   public void setDatamodelMotCle(DataModel var1) {
      this.datamodelMotCle = var1;
   }

   public List getLesProduitsMcles() {
      return this.lesProduitsMcles;
   }

   public void setLesProduitsMcles(List var1) {
      this.lesProduitsMcles = var1;
   }

   public ProduitsMcles getProduitsMcles() {
      return this.produitsMcles;
   }

   public void setProduitsMcles(ProduitsMcles var1) {
      this.produitsMcles = var1;
   }

   public boolean isAfficheButtModifProdMotCle() {
      return this.afficheButtModifProdMotCle;
   }

   public void setAfficheButtModifProdMotCle(boolean var1) {
      this.afficheButtModifProdMotCle = var1;
   }

   public boolean isInpInactifProdMotCle() {
      return this.inpInactifProdMotCle;
   }

   public void setInpInactifProdMotCle(boolean var1) {
      this.inpInactifProdMotCle = var1;
   }

   public boolean isAfficheFormule() {
      return this.afficheFormule;
   }

   public void setAfficheFormule(boolean var1) {
      this.afficheFormule = var1;
   }

   public DataModel getDatamodelGrp() {
      return this.datamodelGrp;
   }

   public void setDatamodelGrp(DataModel var1) {
      this.datamodelGrp = var1;
   }

   public boolean isExistGrp() {
      return this.existGrp;
   }

   public void setExistGrp(boolean var1) {
      this.existGrp = var1;
   }

   public List getLesProduitsCode() {
      return this.lesProduitsCode;
   }

   public void setLesProduitsCode(List var1) {
      this.lesProduitsCode = var1;
   }

   public boolean isExistGrpCode() {
      return this.existGrpCode;
   }

   public void setExistGrpCode(boolean var1) {
      this.existGrpCode = var1;
   }

   public ProduitsServices getProduitsServices() {
      return this.produitsServices;
   }

   public void setProduitsServices(ProduitsServices var1) {
      this.produitsServices = var1;
   }

   public String getProdCodeLibService() {
      return this.prodCodeLibService;
   }

   public void setProdCodeLibService(String var1) {
      this.prodCodeLibService = var1;
   }

   public boolean isTestCodLibService() {
      return this.testCodLibService;
   }

   public void setTestCodLibService(boolean var1) {
      this.testCodLibService = var1;
   }

   public boolean isAfficheButtSuppProdServ() {
      return this.afficheButtSuppProdServ;
   }

   public void setAfficheButtSuppProdServ(boolean var1) {
      this.afficheButtSuppProdServ = var1;
   }

   public String getVar_ActiviteFind() {
      return this.var_ActiviteFind;
   }

   public void setVar_ActiviteFind(String var1) {
      this.var_ActiviteFind = var1;
   }

   public String getVar_CodFind() {
      return this.var_CodFind;
   }

   public void setVar_CodFind(String var1) {
      this.var_CodFind = var1;
   }

   public String getVar_FamilleFind() {
      return this.var_FamilleFind;
   }

   public void setVar_FamilleFind(String var1) {
      this.var_FamilleFind = var1;
   }

   public String getVar_LibFind() {
      return this.var_LibFind;
   }

   public void setVar_LibFind(String var1) {
      this.var_LibFind = var1;
   }

   public String getVar_NatureFinf() {
      return this.var_NatureFinf;
   }

   public void setVar_NatureFinf(String var1) {
      this.var_NatureFinf = var1;
   }

   public String getVar_ServiceFind() {
      return this.var_ServiceFind;
   }

   public void setVar_ServiceFind(String var1) {
      this.var_ServiceFind = var1;
   }

   public String getInpFamilleVnt() {
      return this.inpFamilleVnt;
   }

   public void setInpFamilleVnt(String var1) {
      this.inpFamilleVnt = var1;
   }

   public boolean isVar_affFicPdf() {
      if (this.produits.getProPdf() != null && !this.produits.getProPdf().isEmpty()) {
         this.var_affFicPdf = true;
      } else {
         this.var_affFicPdf = false;
      }

      return this.var_affFicPdf;
   }

   public void setVar_affFicPdf(boolean var1) {
      this.var_affFicPdf = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public boolean isVar_acc_caracteristique() {
      return this.var_acc_caracteristique;
   }

   public void setVar_acc_caracteristique(boolean var1) {
      this.var_acc_caracteristique = var1;
   }

   public boolean isVar_acc_descriptif() {
      return this.var_acc_descriptif;
   }

   public void setVar_acc_descriptif(boolean var1) {
      this.var_acc_descriptif = var1;
   }

   public boolean isVar_acc_motcle() {
      return this.var_acc_motcle;
   }

   public void setVar_acc_motcle(boolean var1) {
      this.var_acc_motcle = var1;
   }

   public boolean isVar_acc_option_vte() {
      return this.var_acc_option_vte;
   }

   public void setVar_acc_option_vte(boolean var1) {
      this.var_acc_option_vte = var1;
   }

   public boolean isVar_acc_photo() {
      return this.var_acc_photo;
   }

   public void setVar_acc_photo(boolean var1) {
      this.var_acc_photo = var1;
   }

   public boolean isVar_acc_service() {
      return this.var_acc_service;
   }

   public void setVar_acc_service(boolean var1) {
      this.var_acc_service = var1;
   }

   public boolean isVar_acc_stock() {
      return this.var_acc_stock;
   }

   public void setVar_acc_stock(boolean var1) {
      this.var_acc_stock = var1;
   }

   public boolean isVar_acc_tarification() {
      return this.var_acc_tarification;
   }

   public void setVar_acc_tarification(boolean var1) {
      this.var_acc_tarification = var1;
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

   public DataModel getDatamodelMvt() {
      return this.datamodelMvt;
   }

   public void setDatamodelMvt(DataModel var1) {
      this.datamodelMvt = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public List getLesMvt() {
      return this.lesMvt;
   }

   public void setLesMvt(List var1) {
      this.lesMvt = var1;
   }

   public String getVar_activites() {
      return this.var_activites;
   }

   public void setVar_activites(String var1) {
      this.var_activites = var1;
   }

   public Date getVar_date_debut() {
      return this.var_date_debut;
   }

   public void setVar_date_debut(Date var1) {
      this.var_date_debut = var1;
   }

   public Date getVar_date_fin() {
      return this.var_date_fin;
   }

   public void setVar_date_fin(Date var1) {
      this.var_date_fin = var1;
   }

   public String getVar_depot() {
      return this.var_depot;
   }

   public void setVar_depot(String var1) {
      this.var_depot = var1;
   }

   public boolean isVar_mvt_as_cbl() {
      return this.var_mvt_as_cbl;
   }

   public void setVar_mvt_as_cbl(boolean var1) {
      this.var_mvt_as_cbl = var1;
   }

   public boolean isVar_mvt_as_cretour() {
      return this.var_mvt_as_cretour;
   }

   public void setVar_mvt_as_cretour(boolean var1) {
      this.var_mvt_as_cretour = var1;
   }

   public boolean isVar_mvt_ss_cavoir() {
      return this.var_mvt_ss_cavoir;
   }

   public void setVar_mvt_ss_cavoir(boolean var1) {
      this.var_mvt_ss_cavoir = var1;
   }

   public boolean isVar_mvt_ss_ccmd() {
      return this.var_mvt_ss_ccmd;
   }

   public void setVar_mvt_ss_ccmd(boolean var1) {
      this.var_mvt_ss_ccmd = var1;
   }

   public boolean isVar_mvt_ss_cdevis() {
      return this.var_mvt_ss_cdevis;
   }

   public void setVar_mvt_ss_cdevis(boolean var1) {
      this.var_mvt_ss_cdevis = var1;
   }

   public boolean isVar_mvt_ss_cfacture() {
      return this.var_mvt_ss_cfacture;
   }

   public void setVar_mvt_ss_cfacture(boolean var1) {
      this.var_mvt_ss_cfacture = var1;
   }

   public String getVar_services() {
      return this.var_services;
   }

   public void setVar_services(String var1) {
      this.var_services = var1;
   }

   public List getRecAvoirVte() {
      return this.recAvoirVte;
   }

   public void setRecAvoirVte(List var1) {
      this.recAvoirVte = var1;
   }

   public List getRecCommandeVte() {
      return this.recCommandeVte;
   }

   public void setRecCommandeVte(List var1) {
      this.recCommandeVte = var1;
   }

   public List getRecDevisVte() {
      return this.recDevisVte;
   }

   public void setRecDevisVte(List var1) {
      this.recDevisVte = var1;
   }

   public List getRecFacturesVte() {
      return this.recFacturesVte;
   }

   public void setRecFacturesVte(List var1) {
      this.recFacturesVte = var1;
   }

   public List getRecLivraisonVte() {
      return this.recLivraisonVte;
   }

   public void setRecLivraisonVte(List var1) {
      this.recLivraisonVte = var1;
   }

   public List getRecRetourVte() {
      return this.recRetourVte;
   }

   public void setRecRetourVte(List var1) {
      this.recRetourVte = var1;
   }

   public int getVar_aff_carac() {
      return this.var_aff_carac;
   }

   public void setVar_aff_carac(int var1) {
      this.var_aff_carac = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVerouxCod() {
      return this.verouxCod;
   }

   public void setVerouxCod(boolean var1) {
      this.verouxCod = var1;
   }

   public int getLgNumProd() {
      return this.lgNumProd;
   }

   public void setLgNumProd(int var1) {
      this.lgNumProd = var1;
   }

   public boolean isAfficheButtPanier() {
      return this.afficheButtPanier;
   }

   public void setAfficheButtPanier(boolean var1) {
      this.afficheButtPanier = var1;
   }

   public DataModel getDatamodelProduitsLieRecherche() {
      return this.datamodelProduitsLieRecherche;
   }

   public void setDatamodelProduitsLieRecherche(DataModel var1) {
      this.datamodelProduitsLieRecherche = var1;
   }

   public int getDesactiveModifprodMotCle() {
      return this.desactiveModifprodMotCle;
   }

   public void setDesactiveModifprodMotCle(int var1) {
      this.desactiveModifprodMotCle = var1;
   }

   public List getLesProduitsLiesRecherche() {
      return this.lesProduitsLiesRecherche;
   }

   public void setLesProduitsLiesRecherche(List var1) {
      this.lesProduitsLiesRecherche = var1;
   }

   public Produits getProduitsLies() {
      return this.produitsLies;
   }

   public void setProduitsLies(Produits var1) {
      this.produitsLies = var1;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public FamillesProduitsVentes getFamillesProduitsVentes() {
      return this.famillesProduitsVentes;
   }

   public void setFamillesProduitsVentes(FamillesProduitsVentes var1) {
      this.famillesProduitsVentes = var1;
   }

   public List getLesFamillesclients() {
      return this.lesFamillesclients;
   }

   public void setLesFamillesclients(List var1) {
      this.lesFamillesclients = var1;
   }

   public String getInpFamilleAch() {
      return this.inpFamilleAch;
   }

   public void setInpFamilleAch(String var1) {
      this.inpFamilleAch = var1;
   }

   public String getInpNatureAch() {
      return this.inpNatureAch;
   }

   public void setInpNatureAch(String var1) {
      this.inpNatureAch = var1;
   }

   public String getCodeNatureAchat() {
      return this.codeNatureAchat;
   }

   public void setCodeNatureAchat(String var1) {
      this.codeNatureAchat = var1;
   }

   public int getFormatdeviseFournisseur() {
      return this.formatdeviseFournisseur;
   }

   public void setFormatdeviseFournisseur(int var1) {
      this.formatdeviseFournisseur = var1;
   }

   public DataModel getDatamodelTiers() {
      return this.datamodelTiers;
   }

   public void setDatamodelTiers(DataModel var1) {
      this.datamodelTiers = var1;
   }

   public DataModel getDatamodelRefHisto() {
      return this.datamodelRefHisto;
   }

   public void setDatamodelRefHisto(DataModel var1) {
      this.datamodelRefHisto = var1;
   }

   public boolean isVar_acc_fournisseur() {
      return this.var_acc_fournisseur;
   }

   public void setVar_acc_fournisseur(boolean var1) {
      this.var_acc_fournisseur = var1;
   }

   public boolean isVar_acc_ref_historique() {
      return this.var_acc_ref_historique;
   }

   public void setVar_acc_ref_historique(boolean var1) {
      this.var_acc_ref_historique = var1;
   }

   public ProduitsGrp getProduitsGrp() {
      return this.produitsGrp;
   }

   public void setProduitsGrp(ProduitsGrp var1) {
      this.produitsGrp = var1;
   }

   public boolean isAfficheButtModifDepProd() {
      return this.afficheButtModifDepProd;
   }

   public void setAfficheButtModifDepProd(boolean var1) {
      this.afficheButtModifDepProd = var1;
   }

   public boolean isAfficheButtSuppDepProd() {
      return this.afficheButtSuppDepProd;
   }

   public void setAfficheButtSuppDepProd(boolean var1) {
      this.afficheButtSuppDepProd = var1;
   }

   public String getInpDepot() {
      return this.inpDepot;
   }

   public void setInpDepot(String var1) {
      this.inpDepot = var1;
   }

   public ProduitsDepot getProduitsDepot() {
      return this.produitsDepot;
   }

   public void setProduitsDepot(ProduitsDepot var1) {
      this.produitsDepot = var1;
   }

   public boolean isExistCodDepot() {
      return this.existCodDepot;
   }

   public void setExistCodDepot(boolean var1) {
      this.existCodDepot = var1;
   }

   public String getTiteleValidDep() {
      return this.titeleValidDep;
   }

   public void setTiteleValidDep(String var1) {
      this.titeleValidDep = var1;
   }

   public boolean isInpInactifProdDep() {
      return this.inpInactifProdDep;
   }

   public void setInpInactifProdDep(boolean var1) {
      this.inpInactifProdDep = var1;
   }

   public boolean isVar_acc_option_ach() {
      return this.var_acc_option_ach;
   }

   public void setVar_acc_option_ach(boolean var1) {
      this.var_acc_option_ach = var1;
   }

   public String getVar_DepotFind() {
      return this.var_DepotFind;
   }

   public void setVar_DepotFind(String var1) {
      this.var_DepotFind = var1;
   }

   public boolean isAfficheButtModifProdFour() {
      return this.afficheButtModifProdFour;
   }

   public void setAfficheButtModifProdFour(boolean var1) {
      this.afficheButtModifProdFour = var1;
   }

   public boolean isAfficheButtSuppProdFour() {
      return this.afficheButtSuppProdFour;
   }

   public void setAfficheButtSuppProdFour(boolean var1) {
      this.afficheButtSuppProdFour = var1;
   }

   public boolean isExistCodTiers() {
      return this.existCodTiers;
   }

   public void setExistCodTiers(boolean var1) {
      this.existCodTiers = var1;
   }

   public String getInpTiers() {
      return this.inpTiers;
   }

   public void setInpTiers(String var1) {
      this.inpTiers = var1;
   }

   public ProduitsFournisseur getProduitsFournisseur() {
      return this.produitsFournisseur;
   }

   public void setProduitsFournisseur(ProduitsFournisseur var1) {
      this.produitsFournisseur = var1;
   }

   public double getVar_prix_euro() {
      return this.var_prix_euro;
   }

   public void setVar_prix_euro(double var1) {
      this.var_prix_euro = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public boolean isInpInactifProdFour() {
      return this.inpInactifProdFour;
   }

   public void setInpInactifProdFour(boolean var1) {
      this.inpInactifProdFour = var1;
   }

   public boolean isAfficheButtModifProdHistoRef() {
      return this.afficheButtModifProdHistoRef;
   }

   public void setAfficheButtModifProdHistoRef(boolean var1) {
      this.afficheButtModifProdHistoRef = var1;
   }

   public boolean isAfficheButtSuppProdHistoRef() {
      return this.afficheButtSuppProdHistoRef;
   }

   public void setAfficheButtSuppProdHistoRef(boolean var1) {
      this.afficheButtSuppProdHistoRef = var1;
   }

   public UtilNombre getUtilNombre() {
      return this.utilNombre;
   }

   public void setUtilNombre(UtilNombre var1) {
      this.utilNombre = var1;
   }

   public LectureDevises getLectureDevises() {
      return this.lectureDevises;
   }

   public void setLectureDevises(LectureDevises var1) {
      this.lectureDevises = var1;
   }

   public boolean isShowModalProduitFournisseur() {
      return this.showModalProduitFournisseur;
   }

   public void setShowModalProduitFournisseur(boolean var1) {
      this.showModalProduitFournisseur = var1;
   }

   public boolean isShowModalTiers() {
      return this.showModalTiers;
   }

   public void setShowModalTiers(boolean var1) {
      this.showModalTiers = var1;
   }

   public DataModel getDatamodelProduitFournisseur() {
      return this.datamodelProduitFournisseur;
   }

   public void setDatamodelProduitFournisseur(DataModel var1) {
      this.datamodelProduitFournisseur = var1;
   }

   public boolean isShowModalProduitDepot() {
      return this.showModalProduitDepot;
   }

   public void setShowModalProduitDepot(boolean var1) {
      this.showModalProduitDepot = var1;
   }

   public DepotAchats getDepotAchats() {
      return this.depotAchats;
   }

   public void setDepotAchats(DepotAchats var1) {
      this.depotAchats = var1;
   }

   public boolean isFamilleAch() {
      return this.familleAch;
   }

   public void setFamilleAch(boolean var1) {
      this.familleAch = var1;
   }

   public boolean isFamilleVte() {
      return this.familleVte;
   }

   public void setFamilleVte(boolean var1) {
      this.familleVte = var1;
   }

   public ProduitsHistoRef getProduitsHistoRef() {
      return this.produitsHistoRef;
   }

   public void setProduitsHistoRef(ProduitsHistoRef var1) {
      this.produitsHistoRef = var1;
   }

   public boolean isAfficheButtProduitGroupe() {
      return this.afficheButtProduitGroupe;
   }

   public void setAfficheButtProduitGroupe(boolean var1) {
      this.afficheButtProduitGroupe = var1;
   }

   public FamillesProduitsAchats getFamillesProduitsAchats() {
      return this.famillesProduitsAchats;
   }

   public void setFamillesProduitsAchats(FamillesProduitsAchats var1) {
      this.famillesProduitsAchats = var1;
   }

   public boolean isVar_acc_groupe() {
      return this.var_acc_groupe;
   }

   public void setVar_acc_groupe(boolean var1) {
      this.var_acc_groupe = var1;
   }

   public boolean isTypeTarif() {
      return this.typeTarif;
   }

   public void setTypeTarif(boolean var1) {
      this.typeTarif = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
   }

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public String getNomModeleListe() {
      return this.nomModeleListe;
   }

   public void setNomModeleListe(String var1) {
      this.nomModeleListe = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public String getNomModeleMvts() {
      return this.nomModeleMvts;
   }

   public void setNomModeleMvts(String var1) {
      this.nomModeleMvts = var1;
   }

   public Stock getStockPrint() {
      return this.stockPrint;
   }

   public void setStockPrint(Stock var1) {
      this.stockPrint = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public boolean isVar_mvt_as_bin() {
      return this.var_mvt_as_bin;
   }

   public void setVar_mvt_as_bin(boolean var1) {
      this.var_mvt_as_bin = var1;
   }

   public boolean isVar_mvt_as_bout() {
      return this.var_mvt_as_bout;
   }

   public void setVar_mvt_as_bout(boolean var1) {
      this.var_mvt_as_bout = var1;
   }

   public boolean isVar_mvt_as_cession() {
      return this.var_mvt_as_cession;
   }

   public void setVar_mvt_as_cession(boolean var1) {
      this.var_mvt_as_cession = var1;
   }

   public boolean isVar_mvt_as_freception() {
      return this.var_mvt_as_freception;
   }

   public void setVar_mvt_as_freception(boolean var1) {
      this.var_mvt_as_freception = var1;
   }

   public boolean isVar_mvt_as_fsav() {
      return this.var_mvt_as_fsav;
   }

   public void setVar_mvt_as_fsav(boolean var1) {
      this.var_mvt_as_fsav = var1;
   }

   public boolean isVar_mvt_as_inventaire() {
      return this.var_mvt_as_inventaire;
   }

   public void setVar_mvt_as_inventaire(boolean var1) {
      this.var_mvt_as_inventaire = var1;
   }

   public boolean isVar_mvt_as_production() {
      return this.var_mvt_as_production;
   }

   public void setVar_mvt_as_production(boolean var1) {
      this.var_mvt_as_production = var1;
   }

   public boolean isVar_mvt_ss_favoir() {
      return this.var_mvt_ss_favoir;
   }

   public void setVar_mvt_ss_favoir(boolean var1) {
      this.var_mvt_ss_favoir = var1;
   }

   public boolean isVar_mvt_ss_fcommande() {
      return this.var_mvt_ss_fcommande;
   }

   public void setVar_mvt_ss_fcommande(boolean var1) {
      this.var_mvt_ss_fcommande = var1;
   }

   public boolean isVar_mvt_ss_fcotation() {
      return this.var_mvt_ss_fcotation;
   }

   public void setVar_mvt_ss_fcotation(boolean var1) {
      this.var_mvt_ss_fcotation = var1;
   }

   public boolean isVar_mvt_ss_ffacture() {
      return this.var_mvt_ss_ffacture;
   }

   public void setVar_mvt_ss_ffacture(boolean var1) {
      this.var_mvt_ss_ffacture = var1;
   }

   public boolean isChangeFamilleAch() {
      return this.changeFamilleAch;
   }

   public void setChangeFamilleAch(boolean var1) {
      this.changeFamilleAch = var1;
   }

   public boolean isChangeFamilleVte() {
      return this.changeFamilleVte;
   }

   public void setChangeFamilleVte(boolean var1) {
      this.changeFamilleVte = var1;
   }

   public boolean isVar_mvt_ss_pump() {
      return this.var_mvt_ss_pump;
   }

   public void setVar_mvt_ss_pump(boolean var1) {
      this.var_mvt_ss_pump = var1;
   }

   public String getVar_lib_etat() {
      return this.var_lib_etat;
   }

   public void setVar_lib_etat(String var1) {
      this.var_lib_etat = var1;
   }

   public String getVar_lib_pv() {
      return this.var_lib_pv;
   }

   public void setVar_lib_pv(String var1) {
      this.var_lib_pv = var1;
   }

   public String getVar_lib_qteIn() {
      return this.var_lib_qteIn;
   }

   public void setVar_lib_qteIn(String var1) {
      this.var_lib_qteIn = var1;
   }

   public String getVar_lib_qteOut() {
      return this.var_lib_qteOut;
   }

   public void setVar_lib_qteOut(String var1) {
      this.var_lib_qteOut = var1;
   }

   public List getMesConditionnementsItems() {
      return this.mesConditionnementsItems;
   }

   public void setMesConditionnementsItems(List var1) {
      this.mesConditionnementsItems = var1;
   }

   public List getMesConditionnementsProduits() {
      return this.mesConditionnementsProduits;
   }

   public void setMesConditionnementsProduits(List var1) {
      this.mesConditionnementsProduits = var1;
   }

   public boolean isLibelle_libre() {
      return this.libelle_libre;
   }

   public void setLibelle_libre(boolean var1) {
      this.libelle_libre = var1;
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

   public boolean isAfficheProgress() {
      return this.afficheProgress;
   }

   public void setAfficheProgress(boolean var1) {
      this.afficheProgress = var1;
   }

   public String getVar_MarqueFind() {
      return this.var_MarqueFind;
   }

   public void setVar_MarqueFind(String var1) {
      this.var_MarqueFind = var1;
   }

   public List getMesFamillesItems() {
      return this.mesFamillesItems;
   }

   public void setMesFamillesItems(List var1) {
      this.mesFamillesItems = var1;
   }

   public List getMesMarquesItems() {
      return this.mesMarquesItems;
   }

   public void setMesMarquesItems(List var1) {
      this.mesMarquesItems = var1;
   }

   public boolean isVar_acc_prp() {
      return this.var_acc_prp;
   }

   public void setVar_acc_prp(boolean var1) {
      this.var_acc_prp = var1;
   }

   public boolean isShowModalHistorique() {
      return this.showModalHistorique;
   }

   public void setShowModalHistorique(boolean var1) {
      this.showModalHistorique = var1;
   }

   public boolean isShowModalMotCles() {
      return this.showModalMotCles;
   }

   public void setShowModalMotCles(boolean var1) {
      this.showModalMotCles = var1;
   }

   public boolean isShowModalService() {
      return this.showModalService;
   }

   public void setShowModalService(boolean var1) {
      this.showModalService = var1;
   }

   public boolean isShowModalTarifSt() {
      return this.showModalTarifSt;
   }

   public void setShowModalTarifSt(boolean var1) {
      this.showModalTarifSt = var1;
   }

   public int getVar_inactif() {
      return this.var_inactif;
   }

   public void setVar_inactif(int var1) {
      this.var_inactif = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public boolean isVar_mvt_as_cchg() {
      return this.var_mvt_as_cchg;
   }

   public void setVar_mvt_as_cchg(boolean var1) {
      this.var_mvt_as_cchg = var1;
   }

   public boolean isVar_mvt_ss_cnoteDebit() {
      return this.var_mvt_ss_cnoteDebit;
   }

   public void setVar_mvt_ss_cnoteDebit(boolean var1) {
      this.var_mvt_ss_cnoteDebit = var1;
   }

   public boolean isVar_mvt_as_ticket() {
      return this.var_mvt_as_ticket;
   }

   public void setVar_mvt_as_ticket(boolean var1) {
      this.var_mvt_as_ticket = var1;
   }

   public String getAncienCode() {
      return this.ancienCode;
   }

   public void setAncienCode(String var1) {
      this.ancienCode = var1;
   }

   public String getNouveauCode() {
      return this.nouveauCode;
   }

   public void setNouveauCode(String var1) {
      this.nouveauCode = var1;
   }

   public boolean isValideChange() {
      return this.valideChange;
   }

   public void setValideChange(boolean var1) {
      this.valideChange = var1;
   }

   public double getTot_montant() {
      return this.tot_montant;
   }

   public void setTot_montant(double var1) {
      this.tot_montant = var1;
   }

   public float getTot_qte_in() {
      return this.tot_qte_in;
   }

   public void setTot_qte_in(float var1) {
      this.tot_qte_in = var1;
   }

   public float getTot_qte_out() {
      return this.tot_qte_out;
   }

   public void setTot_qte_out(float var1) {
      this.tot_qte_out = var1;
   }

   public String getAncienneFamilleAchat() {
      return this.ancienneFamilleAchat;
   }

   public void setAncienneFamilleAchat(String var1) {
      this.ancienneFamilleAchat = var1;
   }

   public String getAncienneFamilleVente() {
      return this.ancienneFamilleVente;
   }

   public void setAncienneFamilleVente(String var1) {
      this.ancienneFamilleVente = var1;
   }

   public String getNouvelleFamilleAchat() {
      return this.nouvelleFamilleAchat;
   }

   public void setNouvelleFamilleAchat(String var1) {
      this.nouvelleFamilleAchat = var1;
   }

   public String getNouvelleFamilleVente() {
      return this.nouvelleFamilleVente;
   }

   public void setNouvelleFamilleVente(String var1) {
      this.nouvelleFamilleVente = var1;
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

   public DataModel getDataModelDecoupageActivtes() {
      return this.dataModelDecoupageActivtes;
   }

   public void setDataModelDecoupageActivtes(DataModel var1) {
      this.dataModelDecoupageActivtes = var1;
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

   public DataModel getDataModelTarifDegressif() {
      return this.dataModelTarifDegressif;
   }

   public void setDataModelTarifDegressif(DataModel var1) {
      this.dataModelTarifDegressif = var1;
   }

   public boolean isShowModalPanelTarifDegressif() {
      return this.showModalPanelTarifDegressif;
   }

   public void setShowModalPanelTarifDegressif(boolean var1) {
      this.showModalPanelTarifDegressif = var1;
   }

   public ObjetTarif getObjetTarif() {
      return this.objetTarif;
   }

   public void setObjetTarif(ObjetTarif var1) {
      this.objetTarif = var1;
   }

   public boolean isVisibiliteBtonTarif() {
      return this.visibiliteBtonTarif;
   }

   public void setVisibiliteBtonTarif(boolean var1) {
      this.visibiliteBtonTarif = var1;
   }

   public String getVar_tarif1() {
      return this.var_tarif1;
   }

   public void setVar_tarif1(String var1) {
      this.var_tarif1 = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public List getMesSousFamillesItems() {
      return this.mesSousFamillesItems;
   }

   public void setMesSousFamillesItems(List var1) {
      this.mesSousFamillesItems = var1;
   }

   public String getVar_SousFamilleFind() {
      return this.var_SousFamilleFind;
   }

   public void setVar_SousFamilleFind(String var1) {
      this.var_SousFamilleFind = var1;
   }

   public boolean isAfficheSousFamille() {
      return this.afficheSousFamille;
   }

   public void setAfficheSousFamille(boolean var1) {
      this.afficheSousFamille = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getFusionAjout() {
      return this.fusionAjout;
   }

   public void setFusionAjout(int var1) {
      this.fusionAjout = var1;
   }

   public int getModeProduit1() {
      return this.modeProduit1;
   }

   public void setModeProduit1(int var1) {
      this.modeProduit1 = var1;
   }

   public int getModeProduit2() {
      return this.modeProduit2;
   }

   public void setModeProduit2(int var1) {
      this.modeProduit2 = var1;
   }

   public int getModeProduit3() {
      return this.modeProduit3;
   }

   public void setModeProduit3(int var1) {
      this.modeProduit3 = var1;
   }

   public int getModeProduit4() {
      return this.modeProduit4;
   }

   public void setModeProduit4(int var1) {
      this.modeProduit4 = var1;
   }

   public boolean isShowModalProduitGroupe() {
      return this.showModalProduitGroupe;
   }

   public void setShowModalProduitGroupe(boolean var1) {
      this.showModalProduitGroupe = var1;
   }

   public boolean isShowModalProduitRecherche() {
      return this.showModalProduitRecherche;
   }

   public void setShowModalProduitRecherche(boolean var1) {
      this.showModalProduitRecherche = var1;
   }

   public List getMesDepotProduitGroupeItems() {
      return this.mesDepotProduitGroupeItems;
   }

   public void setMesDepotProduitGroupeItems(List var1) {
      this.mesDepotProduitGroupeItems = var1;
   }

   public int getOutilChoisi() {
      return this.outilChoisi;
   }

   public void setOutilChoisi(int var1) {
      this.outilChoisi = var1;
   }

   public boolean isTestAffOutilsCorr() {
      return this.testAffOutilsCorr;
   }

   public void setTestAffOutilsCorr(boolean var1) {
      this.testAffOutilsCorr = var1;
   }

   public String getToolsCompteOld() {
      return this.toolsCompteOld;
   }

   public void setToolsCompteOld(String var1) {
      this.toolsCompteOld = var1;
   }

   public boolean isVar_mvt_as_fabrication() {
      return this.var_mvt_as_fabrication;
   }

   public void setVar_mvt_as_fabrication(boolean var1) {
      this.var_mvt_as_fabrication = var1;
   }

   public boolean isVar_simluationPr() {
      return this.var_simluationPr;
   }

   public void setVar_simluationPr(boolean var1) {
      this.var_simluationPr = var1;
   }

   public String getToolsDepotOld() {
      return this.toolsDepotOld;
   }

   public void setToolsDepotOld(String var1) {
      this.toolsDepotOld = var1;
   }

   public List getMesProduitsDepotsItems() {
      return this.mesProduitsDepotsItems;
   }

   public void setMesProduitsDepotsItems(List var1) {
      this.mesProduitsDepotsItems = var1;
   }

   public CalculPrp getCalculPrp() {
      return this.calculPrp;
   }

   public void setCalculPrp(CalculPrp var1) {
      this.calculPrp = var1;
   }

   public boolean isAfficheQteNbUnite() {
      return this.afficheQteNbUnite;
   }

   public void setAfficheQteNbUnite(boolean var1) {
      this.afficheQteNbUnite = var1;
   }

   public int getModeProduit5() {
      return this.modeProduit5;
   }

   public void setModeProduit5(int var1) {
      this.modeProduit5 = var1;
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

   public DataModel getDataModelTarifClients() {
      return this.dataModelTarifClients;
   }

   public void setDataModelTarifClients(DataModel var1) {
      this.dataModelTarifClients = var1;
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

   public String getVar_TypeFind() {
      return this.var_TypeFind;
   }

   public void setVar_TypeFind(String var1) {
      this.var_TypeFind = var1;
   }

   public boolean isGestionProduits() {
      return this.gestionProduits;
   }

   public void setGestionProduits(boolean var1) {
      this.gestionProduits = var1;
   }

   public long getVar_memo_id_master() {
      return this.var_memo_id_master;
   }

   public void setVar_memo_id_master(long var1) {
      this.var_memo_id_master = var1;
   }

   public String getVar_RefFind() {
      return this.var_RefFind;
   }

   public void setVar_RefFind(String var1) {
      this.var_RefFind = var1;
   }

   public double getVar_grp_pump() {
      return this.var_grp_pump;
   }

   public void setVar_grp_pump(double var1) {
      this.var_grp_pump = var1;
   }

   public double getVar_grp_pv() {
      return this.var_grp_pv;
   }

   public void setVar_grp_pv(double var1) {
      this.var_grp_pv = var1;
   }
}
