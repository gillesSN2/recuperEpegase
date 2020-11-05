package com.epegase.forms.ventes;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ProduitsGrp;
import com.epegase.systeme.classe.ProduitsHistoRef;
import com.epegase.systeme.classe.ProduitsMcles;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsGrpDao;
import com.epegase.systeme.dao.ProduitsHistoRefDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.xml.LireLesoptionsGroupe;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetLigneOnglet;
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

public class FormProduitsVtes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action = 0;
   private String pageIndex;
   private List mesOnglets;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private ExercicesComptable lastExoCompta;
   private ExercicesAchats lastExoAchats;
   private OptionVentes optionsVentes;
   private Produits produits;
   private ProduitsVtesDao produitsVtesDao;
   private ProduitsAchsDao produitsAchsDao;
   private List lesProduits = new ArrayList();
   private transient DataModel datamodelProduit = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private int var_nb_max = 100;
   private List mesMarquesItems;
   private List mesFamillesItems;
   private String var_NatureFind;
   private String var_MarqueFind;
   private String var_FamilleFind;
   private int var_PromoFind = 0;
   private String var_SousFamilleFind;
   private String var_ServiceFind;
   private String var_ActiviteFind;
   private String var_CodFind;
   private String var_RefFind;
   private String var_LibFind;
   private String var_TypeFind;
   private String var_DepotFin;
   private boolean afficheButtSup = false;
   private boolean afficheButtOption = false;
   private boolean afficheButtPanier = false;
   private boolean afficheProgress = false;
   private int var_inactif = 0;
   private boolean var_more_search = false;
   private List mesSousFamillesItems = new ArrayList();
   private boolean afficheSousFamille = false;
   private String inpNatureVnt = "";
   private String inpFamilleVnt = "";
   private boolean verouxCod;
   private boolean existCod = false;
   private int lgNumProd;
   private ActivitesDao activitesDao;
   private boolean afficheFormule = false;
   private boolean existGrp = false;
   private boolean existGrpCode = false;
   private transient DataModel datamodelCode = new ListDataModel();
   private transient DataModel datamodelGrp = new ListDataModel();
   private List lesProduitsDepos = new ArrayList();
   private ProduitsDepotDao produitsDepotDao;
   private List lesProduitsGrps;
   private List lesProduitsCode;
   private ProduitsGrpDao produitsGrpDao;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private FamillesProduitsVentes famillesProduitsVentes = new FamillesProduitsVentes();
   private String disable;
   private String description;
   private transient DataModel datamodelDepot = new ListDataModel();
   private List lesFamillesclients;
   private TaxesVentesDao taxesVentesDao;
   private PlanComptableDao planComptableDao;
   private String tarifOrdClt;
   private UtilDate utilDate = new UtilDate();
   private boolean libelle_libre = false;
   private String memoAnalytique;
   private ProduitsFournisseurDao produitsFournisseurDao;
   private ProduitsHistoRefDao produitsHistoRefDao;
   private boolean showModalService = false;
   private List lesProduitsServices = new ArrayList();
   private List lesProduitsServicesFind;
   private boolean afficheButtSuppProdServ = false;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsServices produitsServices;
   private String prodCodeLibService;
   private boolean testCodLibService = false;
   private ServiceDao serviceDao;
   private transient DataModel datamodelProService = new ListDataModel();
   private boolean showModalTarifSt = false;
   private String htTtc;
   private transient DataModel datamodelTarif = new ListDataModel();
   private List lesProduitsTarif = new ArrayList();
   private ProduitsTarifDao produitsTarifDao;
   private ProduitsTarif produitsTarif;
   private int inpTypTar;
   private boolean inpInactifProdTarif;
   private int desactiveModifprodTar;
   private boolean afficheButtModifProdTar = false;
   private boolean afficheButtSuppProdTar = false;
   private boolean testDoubleProduitsTarif = false;
   private String var_tarif1;
   private String var_tarif2;
   private String var_tarif3;
   private String var_tarif4;
   private String var_tarif5;
   private String var_tarif6;
   private String var_tarif7;
   private String var_tarif8;
   private String var_tarif9;
   private String var_tarif10;
   private String var_tarif1Marche;
   private String var_tarif2Marche;
   private String var_tarif3Marche;
   private String var_tarif4Marche;
   private String var_tarif5Marche;
   private String var_tarif6Marche;
   private String var_tarif7Marche;
   private String var_tarif8Marche;
   private String var_tarif9Marche;
   private String var_tarif10Marche;
   private boolean var_aff_tarif1;
   private boolean var_aff_tarif2;
   private boolean var_aff_tarif3;
   private boolean var_aff_tarif4;
   private boolean var_aff_tarif5;
   private boolean var_aff_tarif6;
   private boolean var_aff_tarif7;
   private boolean var_aff_tarif8;
   private boolean var_aff_tarif9;
   private boolean var_aff_tarif10;
   private List lesTarifsDegressifs = new ArrayList();
   private transient DataModel dataModelTarifDegressif = new ListDataModel();
   private transient DataModel dataModelTarifClients = new ListDataModel();
   private boolean showModalPanelTarifDegressif = false;
   private ObjetTarif objetTarif;
   private boolean visibiliteBtonTarif = false;
   private int etatTarif;
   private Baremes baremes;
   private List lesTarifsPromotion = new ArrayList();
   private transient DataModel dataModelTarifPromotion = new ListDataModel();
   private boolean visibiliteBtonTarifPromotion = false;
   private boolean showModalPanelTarifPromotion = false;
   private boolean showModalMotCles = false;
   private boolean inpInactifProdMotCle;
   private int desactiveModifprodMotCle;
   private boolean afficheButtModifProdMotCle = false;
   private transient DataModel datamodelMotCle = new ListDataModel();
   private ProduitsMcles produitsMcles;
   private List lesProduitsMcles = new ArrayList();
   private ProduitsMclesDao produitsMclesDao;
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
   private boolean var_mvt_as_reexpedition = false;
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
   private List mesProduitsDepotsItems = new ArrayList();
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String requete;
   private String filtre;
   private String format = "PDF";
   private int var_choix_modele = 0;
   private String nomModeleDocument;
   private String nomModeleListe;
   private String nomModeleMvts;
   private String impDestinataire;
   private String impEmetteur;
   private Stock stockPrint;
   private boolean showModalPanelPrint = false;
   private boolean affichagePump;
   private boolean var_acc_descriptif = false;
   private boolean var_acc_photo = false;
   private boolean var_acc_caracteristique = false;
   private boolean var_acc_stock = false;
   private boolean var_acc_tarification = false;
   private boolean var_acc_option_vte = false;
   private boolean var_acc_motcle = false;
   private boolean var_acc_service = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private int var_aff_carac;
   private FormRecherche formRecherche;
   private boolean errorConnection;
   private List lesProduitsLiesRecherche = new ArrayList();
   private transient DataModel datamodelProduitsLieRecherche = new ListDataModel();
   private Produits produitsLies;
   private UtilDownload utilDownload = new UtilDownload();
   private String urlphotoProd;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private String fileName;
   private String pdfFileName;
   private UploadedFile uploadedFile;
   private UploadedFile uploadedPDFFile;
   private String messageBut = "";
   private boolean existPdfFile;
   private boolean typeTarif = false;
   private boolean var_affFicPdf;
   private double var_p1CC1;
   private double var_p1CC2;
   private double var_p1CC3;
   private double var_p2CC1;
   private double var_p2CC2;
   private double var_p2CC3;
   private double var_p3CC1;
   private double var_p3CC2;
   private double var_p3CC3;
   private double var_p4CC1;
   private double var_p4CC2;
   private double var_p4CC3;
   private double var_p5CC1;
   private double var_p5CC2;
   private double var_p5CC3;
   private double var_p6CC1;
   private double var_p6CC2;
   private double var_p6CC3;
   private double var_p7CC1;
   private double var_p7CC2;
   private double var_p7CC3;
   private double var_p8CC1;
   private double var_p8CC2;
   private double var_p8CC3;
   private double var_p9CC1;
   private double var_p9CC2;
   private double var_p9CC3;
   private double var_p10CC1;
   private double var_p10CC2;
   private double var_p10CC3;
   private String var_n1CC1;
   private String var_n1CC2;
   private String var_n1CC3;
   private String var_n2CC1;
   private String var_n2CC2;
   private String var_n2CC3;
   private String var_n3CC1;
   private String var_n3CC2;
   private String var_n3CC3;
   private String var_n4CC1;
   private String var_n4CC2;
   private String var_n4CC3;
   private String var_n5CC1;
   private String var_n5CC2;
   private String var_n5CC3;
   private String var_n6CC1;
   private String var_n6CC2;
   private String var_n6CC3;
   private String var_n7CC1;
   private String var_n7CC2;
   private String var_n7CC3;
   private String var_n8CC1;
   private String var_n8CC2;
   private String var_n8CC3;
   private String var_n9CC1;
   private String var_n9CC2;
   private String var_n9CC3;
   private String var_n10CC1;
   private String var_n10CC2;
   private String var_n10CC3;
   private Date var_d1CC1;
   private Date var_d1CC2;
   private Date var_d1CC3;
   private Date var_d2CC1;
   private Date var_d2CC2;
   private Date var_d2CC3;
   private Date var_d3CC1;
   private Date var_d3CC2;
   private Date var_d3CC3;
   private Date var_d4CC1;
   private Date var_d4CC2;
   private Date var_d4CC3;
   private Date var_d5CC1;
   private Date var_d5CC2;
   private Date var_d5CC3;
   private Date var_d6CC1;
   private Date var_d6CC2;
   private Date var_d6CC3;
   private Date var_d7CC1;
   private Date var_d7CC2;
   private Date var_d7CC3;
   private Date var_d8CC1;
   private Date var_d8CC2;
   private Date var_d8CC3;
   private Date var_d9CC1;
   private Date var_d9CC2;
   private Date var_d9CC3;
   private Date var_d10CC1;
   private Date var_d10CC2;
   private Date var_d10CC3;
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
   private transient DataModel dataModelFamille;
   private List lesFamillesVentesProduits;
   private boolean showModalpanelCarte = false;
   private boolean showModalpanelArticle = false;
   private boolean afficheButtCarte = false;
   private boolean afficheButtArticle = false;
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
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.produitsGrpDao = new ProduitsGrpDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.depotAchatsDao = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
      this.produitsHistoRefDao = new ProduitsHistoRefDao(this.baseLog, this.utilInitHibernate);
      this.produitsFournisseurDao = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererOptions() throws ParseException, HibernateException, NamingException {
      if (this.optionsVentes.getDecrmtPriVteStock().equalsIgnoreCase("1")) {
         this.setHtTtc(" (HT)");
      }

      if (this.optionsVentes.getDecrmtPriVteStock().equalsIgnoreCase("2")) {
         this.setHtTtc(" (TTC)");
      }

      if (this.optionsVentes.getNbLigneMax() != null && !this.optionsVentes.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionsVentes.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.lgNumProd = Integer.parseInt(this.optionsVentes.getNbrCaracteresProPRO());
      if (this.structureLog.getStrECommerceVal() == 1) {
         this.afficheButtPanier = true;
      } else {
         this.afficheButtPanier = false;
      }

      if (this.usersLog.getUsrAffPump() == 0) {
         this.affichagePump = false;
      } else {
         this.affichagePump = true;
      }

      if (this.optionsVentes != null && this.optionsVentes.getDecrmtRabais().equals("3")) {
         this.libelleRabRis = "Ristourne";
         this.ristourne = true;
      } else {
         this.libelleRabRis = "Rabais";
         this.ristourne = false;
      }

      this.lesProduits.clear();
      if (this.formRecherche != null && this.formRecherche.getProduits() != null && this.formRecherche.getProduits().getProVteCode() != null && !this.formRecherche.getProduits().getProVteCode().isEmpty()) {
         this.lesProduits.add(this.formRecherche.getProduits());
      }

      this.datamodelProduit.setWrappedData(this.lesProduits);
      this.produits = null;
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
      this.var_acc_stock = false;
      this.var_acc_tarification = false;
      this.var_acc_option_vte = false;
      this.var_acc_motcle = false;
      this.var_acc_service = false;
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
            } else if (var1.getCode().equals("5")) {
               this.var_acc_stock = true;
            } else if (var1.getCode().equals("6")) {
               this.var_acc_tarification = true;
            } else if (var1.getCode().equals("8")) {
               this.var_acc_option_vte = true;
            } else if (var1.getCode().equals("9")) {
               this.var_acc_motcle = true;
            } else if (var1.getCode().equals("11")) {
               this.var_acc_service = true;
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

   public void autorisationPhoto() {
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

   public void autorisationCaracteristique() throws HibernateException, NamingException {
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

   public void autorisationStock() {
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

   public void autorisationTarification() {
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

   }

   public void autorisationOptionVte() {
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

   public void autorisationMotCle() {
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

   public void autorisationService() {
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

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
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
      int var2;
      if (this.var_MarqueFind != null && !this.var_MarqueFind.isEmpty()) {
         new ArrayList();
         var1 = this.produitsVtesDao.chargerLesProduitsVentesByMarque(this.var_MarqueFind, (Session)null);
         if (var1.size() != 0) {
            for(var2 = 0; var2 < var1.size(); ++var2) {
               this.produits = new Produits();
               this.produits = (Produits)var1.get(var2);
               this.mesFamillesItems.add(new SelectItem(this.produits.getProVteCode(), this.produits.getProVteLib()));
            }
         }
      } else {
         new ArrayList();
         this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = this.famillesProduitsVentesDao.chargerFamilleProduitVentesItems(this.exercicesVentes.getExevteId(), (Session)null);
         this.mesFamillesItems = new ArrayList();
         if (var1.size() != 0) {
            for(var2 = 0; var2 < var1.size(); ++var2) {
               String var3 = (String)((SelectItem)var1.get(var2)).getValue();
               String[] var4 = var3.split(":");
               this.mesFamillesItems.add(new SelectItem(var4[0], var4[1]));
            }
         }
      }

   }

   public void calculeSousFamille() throws HibernateException, NamingException {
      this.mesSousFamillesItems.clear();
      this.var_SousFamilleFind = "";
      this.afficheSousFamille = false;
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviStock");
      this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), this.var_FamilleFind, var1);
      if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCat() == 99) {
         this.mesSousFamillesItems = this.famillesProduitsVentesDao.chargerFamilleProduitVentesSousFamItems(this.exercicesVentes.getExevteId(), this.var_FamilleFind, var1);
         if (this.mesSousFamillesItems.size() != 0) {
            this.afficheSousFamille = true;
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
      if (this.var_NatureFind != null && !this.var_NatureFind.isEmpty() && this.var_NatureFind.contains(":")) {
         String[] var4 = this.getVar_NatureFind().split(":");
         var3 = var4[0];
      }

      String var7 = "";
      if (this.var_ActiviteFind != null && !this.var_ActiviteFind.isEmpty() && this.var_ActiviteFind.contains(":")) {
         String[] var5 = this.getVar_ActiviteFind().split(":");
         var7 = var5[0];
      }

      String var8 = "";
      if (this.var_ServiceFind != null && !this.var_ServiceFind.isEmpty() && this.var_ServiceFind.contains(":")) {
         String[] var6 = this.getVar_ServiceFind().split(":");
         var8 = var6[0];
      }

      if (this.var_PromoFind == 1) {
         this.listePromotion();
      } else if (this.var_PromoFind == 2) {
         this.listeTarifSpecial();
      } else {
         this.listerProduit(var1, var2, var3, var7, var8);
      }

      this.datamodelProduit.setWrappedData(this.lesProduits);
   }

   public void rechercher20Derniers() throws HibernateException, NamingException, JDOMException, IOException {
      this.afficheButtOption = false;
      this.afficheButtSup = false;
      this.lesProduits.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      this.lesProduits = this.produitsVtesDao.chargerLesProduits20Derniers(var1);
      if (this.lesProduits.size() != 0) {
         UtilTrie var2 = new UtilTrie();
         this.lesProduits = var2.triListeProduit(this.lesProduits);
         this.mefProduit(var1);
      }

      this.utilInitHibernate.closeSession();
      this.datamodelProduit.setWrappedData(this.lesProduits);
   }

   public void listerProduit(String var1, String var2, String var3, String var4, String var5) throws JDOMException, IOException, HibernateException, NamingException {
      this.lesProduits.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      String var7 = "";
      if (this.var_SousFamilleFind != null && !this.var_SousFamilleFind.isEmpty()) {
         var7 = this.var_SousFamilleFind;
      } else {
         var7 = this.var_FamilleFind;
      }

      if (var7 != null && !var7.isEmpty() && var7.contains(":")) {
         String[] var8 = var7.split(":");
         var7 = var8[0];
      }

      if (var5 == null || var5.isEmpty() && (this.var_RefFind == null || this.var_RefFind.isEmpty())) {
         if (this.optionsVentes.getProduitAchat().equals("1")) {
            this.lesProduits = this.produitsAchsDao.selectFindProduit(var1, var2, var3, this.var_MarqueFind, var7, var4, this.var_inactif, this.var_TypeFind, var6);
         } else {
            this.lesProduits = this.produitsVtesDao.selectFindProduit(var1, var2, var3, this.var_MarqueFind, var7, var4, this.var_inactif, this.var_TypeFind, var6);
         }
      } else if (var5 == null || var5.isEmpty() && this.var_RefFind != null && !this.var_RefFind.isEmpty()) {
         new ArrayList();
         List var15 = this.produitsFournisseurDao.selectAllProduitsFour(this.var_RefFind, var6);
         if (var15.size() > 0) {
            new ProduitsFournisseur();

            for(int var10 = 0; var10 < var15.size(); ++var10) {
               ProduitsFournisseur var16 = (ProduitsFournisseur)var15.get(var10);
               this.produits = var16.getProduits();
               this.lesProduits.add(this.produits);
            }
         }

         new ArrayList();
         List var17 = this.produitsHistoRefDao.selectProdHistoRefByprod(this.var_RefFind, var6);
         int var11;
         boolean var12;
         int var13;
         if (var17.size() > 0) {
            new ProduitsHistoRef();

            for(var11 = 0; var11 < var17.size(); ++var11) {
               ProduitsHistoRef var18 = (ProduitsHistoRef)var17.get(var11);
               this.produits = var18.getProduits();
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
         List var19 = this.produitsMclesDao.chargerLesProduitsMcles(this.var_RefFind, var6);
         if (var19.size() > 0) {
            this.produitsMcles = new ProduitsMcles();

            for(var11 = 0; var11 < var19.size(); ++var11) {
               this.produitsMcles = (ProduitsMcles)var19.get(var11);
               this.produits = this.produitsMcles.getProduits();
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
      } else {
         new Service();
         this.produitsServices = new ProduitsServices();
         Service var14 = this.serviceDao.chargerLeServiceCode(var5, var6);
         if (var14 != null) {
            this.produitsServices.setServices(var14);
            this.lesProduitsServicesFind = new ArrayList();
            this.lesProduitsServicesFind = this.produitsServicesDao.selectProdServiceByservAchs(this.produitsServices.getServices(), var1, this.var_TypeFind, var6);
            if (this.lesProduitsServicesFind.size() > 0) {
               this.produitsServices = new ProduitsServices();

               for(int var9 = 0; var9 < this.lesProduitsServicesFind.size(); ++var9) {
                  this.produitsServices = (ProduitsServices)this.lesProduitsServicesFind.get(var9);
                  this.produits = this.produitsServices.getProduits();
                  if (var1 != null && !var1.isEmpty() || var2 != null && !var2.isEmpty()) {
                     if (var1 != null && !var1.isEmpty() && !var1.startsWith("*") && this.produits.getProCode().toLowerCase().startsWith(var1)) {
                        if (this.optionsVentes.getProduitAchat().equals("1")) {
                           this.lesProduits.add(this.produits);
                        } else if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
                           this.lesProduits.add(this.produits);
                        }
                     } else if (var1 != null && !var1.isEmpty() && var1.startsWith("*") && this.produits.getProCode().toLowerCase().contains(var1.substring(1))) {
                        if (this.optionsVentes.getProduitAchat().equals("1")) {
                           this.lesProduits.add(this.produits);
                        } else if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
                           this.lesProduits.add(this.produits);
                        }
                     } else if (var2 != null && !var2.isEmpty() && !var2.startsWith("*") && (this.produits.getProLibClient().toLowerCase().startsWith(var2) || this.produits.getProLibTech().toLowerCase().startsWith(var2))) {
                        if (this.optionsVentes.getProduitAchat().equals("1")) {
                           this.lesProduits.add(this.produits);
                        } else if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
                           this.lesProduits.add(this.produits);
                        }
                     } else if (var2 != null && !var2.isEmpty() && var2.startsWith("*") && (this.produits.getProLibClient().toLowerCase().contains(var2.substring(1)) || this.produits.getProLibTech().toLowerCase().contains(var2.substring(1)))) {
                        if (this.optionsVentes.getProduitAchat().equals("1")) {
                           this.lesProduits.add(this.produits);
                        } else if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
                           this.lesProduits.add(this.produits);
                        }
                     }
                  } else if (this.optionsVentes.getProduitAchat().equals("1")) {
                     this.lesProduits.add(this.produits);
                  } else if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
                     this.lesProduits.add(this.produits);
                  }
               }
            }
         }
      }

      this.mefProduit(var6);
      this.utilInitHibernate.closeSession();
   }

   public void listePromotion() throws HibernateException, NamingException, JDOMException, IOException {
      this.lesProduits.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      new ArrayList();
      List var2 = this.baremesDao.listBaremesByProduitsPromo((String)null, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.baremes = (Baremes)var2.get(var3);
            if (this.baremes.getBarCodeProduit() != null && !this.baremes.getBarCodeProduit().isEmpty()) {
               this.produits = this.produitsVtesDao.chargeProduit(this.baremes.getBarCodeProduit(), var1);
               if (this.produits != null && this.produits.getProCode() != null && !this.produits.getProCode().isEmpty()) {
                  this.lesProduits.add(this.produits);
               }
            }
         }
      }

      this.mefProduit(var1);
      this.utilInitHibernate.closeSession();
   }

   public void listeTarifSpecial() throws HibernateException, NamingException, JDOMException, IOException {
      this.lesProduits.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      new ArrayList();
      List var2 = this.baremesDao.listBaremesByProduitsTiers((String)null, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.baremes = (Baremes)var2.get(var3);
            if (this.baremes.getBarCodeProduit() != null && !this.baremes.getBarCodeProduit().isEmpty()) {
               this.produits = this.produitsVtesDao.chargeProduit(this.baremes.getBarCodeProduit(), var1);
               if (this.produits != null && this.produits.getProCode() != null && !this.produits.getProCode().isEmpty()) {
                  this.lesProduits.add(this.produits);
               }
            }
         }
      }

      this.mefProduit(var1);
      this.utilInitHibernate.closeSession();
   }

   public void mefProduit(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.lesProduits.size() != 0) {
         new ArrayList();
         UtilNombre var3 = new UtilNombre();

         for(int var4 = 0; var4 < this.lesProduits.size(); ++var4) {
            this.produits = (Produits)this.lesProduits.get(var4);
            float var5 = 0.0F;
            float var6 = 0.0F;
            float var7 = 0.0F;
            List var2 = this.produitsDepotDao.selectProdDepByprod(this.produits, var1);
            if (var2.size() != 0) {
               for(int var8 = 0; var8 < var2.size(); ++var8) {
                  boolean var9 = false;

                  for(int var10 = 0; var10 < this.mesProduitsDepotsItems.size(); ++var10) {
                     String[] var11 = ((SelectItem)this.mesProduitsDepotsItems.get(var10)).getLabel().toString().split(":");
                     if (var11[0].equals(((ProduitsDepot)var2.get(var8)).getDepot().getDpoCode())) {
                        var9 = true;
                        break;
                     }
                  }

                  if (var9 && ((ProduitsDepot)var2.get(var8)).getDepot().getDpoType() != 3) {
                     var5 += ((ProduitsDepot)var2.get(var8)).getProdepQteCmdVte();
                     var6 += ((ProduitsDepot)var2.get(var8)).getProdepQteCmdAch();
                     var7 += ((ProduitsDepot)var2.get(var8)).getProdepQteStk();
                  }
               }
            }

            this.produits.setProQteCmdClient(var5);
            this.produits.setProQteCmdFournisseur(var6);
            this.produits.setProQteStock(var7);
            double var12;
            double var13;
            if (this.var_aff_tarif1 && this.var_tarif1 != null && !this.var_tarif1.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif1, var1);
               if (this.produitsTarif != null) {
                  var12 = 0.0D;
                  var13 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var12 = var3.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv1(var12);
                     var13 = var3.myRoundDevise(this.produitsTarif.getProtarPvMarche() + this.produitsTarif.getProtarPvMarche() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv1Marche(var13);
                  } else {
                     var12 = this.produitsTarif.getProtarPv();
                     this.produits.setPv1(var12);
                     var13 = this.produitsTarif.getProtarPvMarche();
                     this.produits.setPv1Marche(var13);
                  }
               }
            }

            if (this.var_aff_tarif2 && this.var_tarif2 != null && !this.var_tarif2.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif2, var1);
               if (this.produitsTarif != null) {
                  var12 = 0.0D;
                  var13 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var12 = var3.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv2(var12);
                     var13 = var3.myRoundDevise(this.produitsTarif.getProtarPvMarche() + this.produitsTarif.getProtarPvMarche() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv2Marche(var13);
                  } else {
                     var12 = this.produitsTarif.getProtarPv();
                     this.produits.setPv2(var12);
                     var13 = this.produitsTarif.getProtarPvMarche();
                     this.produits.setPv2Marche(var13);
                  }
               }
            }

            if (this.var_aff_tarif3 && this.var_tarif3 != null && !this.var_tarif3.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif3, var1);
               if (this.produitsTarif != null) {
                  var12 = 0.0D;
                  var13 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var12 = var3.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv3(var12);
                     var13 = var3.myRoundDevise(this.produitsTarif.getProtarPvMarche() + this.produitsTarif.getProtarPvMarche() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv3Marche(var13);
                  } else {
                     var12 = this.produitsTarif.getProtarPv();
                     this.produits.setPv3(var12);
                     var13 = this.produitsTarif.getProtarPvMarche();
                     this.produits.setPv3Marche(var13);
                  }
               }
            }

            if (this.var_aff_tarif4 && this.var_tarif4 != null && !this.var_tarif4.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif4, var1);
               if (this.produitsTarif != null) {
                  var12 = 0.0D;
                  var13 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var12 = var3.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv4(var12);
                     var13 = var3.myRoundDevise(this.produitsTarif.getProtarPvMarche() + this.produitsTarif.getProtarPvMarche() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv4Marche(var13);
                  } else {
                     var12 = this.produitsTarif.getProtarPv();
                     this.produits.setPv4(var12);
                     var13 = this.produitsTarif.getProtarPvMarche();
                     this.produits.setPv4Marche(var13);
                  }
               }
            }

            if (this.var_aff_tarif5 && this.var_tarif5 != null && !this.var_tarif5.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif5, var1);
               if (this.produitsTarif != null) {
                  var12 = 0.0D;
                  var13 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var12 = var3.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv5(var12);
                     var13 = var3.myRoundDevise(this.produitsTarif.getProtarPvMarche() + this.produitsTarif.getProtarPvMarche() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv5Marche(var13);
                  } else {
                     var12 = this.produitsTarif.getProtarPv();
                     this.produits.setPv5(var12);
                     var13 = this.produitsTarif.getProtarPvMarche();
                     this.produits.setPv5Marche(var13);
                  }
               }
            }

            if (this.var_aff_tarif6 && this.var_tarif6 != null && !this.var_tarif6.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif6, var1);
               if (this.produitsTarif != null) {
                  var12 = 0.0D;
                  var13 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var12 = var3.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv6(var12);
                     var13 = var3.myRoundDevise(this.produitsTarif.getProtarPvMarche() + this.produitsTarif.getProtarPvMarche() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv6Marche(var13);
                  } else {
                     var12 = this.produitsTarif.getProtarPv();
                     this.produits.setPv6(var12);
                     var13 = this.produitsTarif.getProtarPvMarche();
                     this.produits.setPv6Marche(var13);
                  }
               }
            }

            if (this.var_aff_tarif7 && this.var_tarif7 != null && !this.var_tarif7.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif7, var1);
               if (this.produitsTarif != null) {
                  var12 = 0.0D;
                  var13 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var12 = var3.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv7(var12);
                     var13 = var3.myRoundDevise(this.produitsTarif.getProtarPvMarche() + this.produitsTarif.getProtarPvMarche() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv7Marche(var13);
                  } else {
                     var12 = this.produitsTarif.getProtarPv();
                     this.produits.setPv7(var12);
                     var13 = this.produitsTarif.getProtarPvMarche();
                     this.produits.setPv7Marche(var13);
                  }
               }
            }

            if (this.var_aff_tarif8 && this.var_tarif8 != null && !this.var_tarif8.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif8, var1);
               if (this.produitsTarif != null) {
                  var12 = 0.0D;
                  var13 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var12 = var3.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv8(var12);
                     var13 = var3.myRoundDevise(this.produitsTarif.getProtarPvMarche() + this.produitsTarif.getProtarPvMarche() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv8Marche(var13);
                  } else {
                     var12 = this.produitsTarif.getProtarPv();
                     this.produits.setPv8(var12);
                     var13 = this.produitsTarif.getProtarPvMarche();
                     this.produits.setPv8Marche(var13);
                  }
               }
            }

            if (this.var_aff_tarif9 && this.var_tarif9 != null && !this.var_tarif9.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif9, var1);
               if (this.produitsTarif != null) {
                  var12 = 0.0D;
                  var13 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var12 = var3.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv9(var12);
                     var13 = var3.myRoundDevise(this.produitsTarif.getProtarPvMarche() + this.produitsTarif.getProtarPvMarche() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv9Marche(var13);
                  } else {
                     var12 = this.produitsTarif.getProtarPv();
                     this.produits.setPv9(var12);
                     var13 = this.produitsTarif.getProtarPvMarche();
                     this.produits.setPv9Marche(var13);
                  }
               }
            }

            if (this.var_aff_tarif10 && this.var_tarif10 != null && !this.var_tarif10.isEmpty()) {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif10, var1);
               if (this.produitsTarif != null) {
                  var12 = 0.0D;
                  var13 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var12 = var3.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv10(var12);
                     var13 = var3.myRoundDevise(this.produitsTarif.getProtarPvMarche() + this.produitsTarif.getProtarPvMarche() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv10Marche(var13);
                  } else {
                     var12 = this.produitsTarif.getProtarPv();
                     this.produits.setPv10(var12);
                     var13 = this.produitsTarif.getProtarPvMarche();
                     this.produits.setPv10Marche(var13);
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
      this.lesProduitsMcles.clear();
      this.lesProduitsServices.clear();
      this.lesProduitsTarif.clear();
      this.lesMvt.clear();
      this.inpFamilleVnt = "0";
      this.inpNatureVnt = "";
      this.existCod = false;
      this.afficheButtModifProdTar = false;
      this.var_action = 1;
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void duppliquerProduit() throws HibernateException, NamingException {
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
         this.calculeCode();
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

         if (var1.size() != 0) {
            this.produits = (Produits)var1.get(0);
            long var7 = this.produits.getProId();
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
            this.produits = this.produitsVtesDao.chargeToutProduit(var7, var5);
            if (this.produits != null) {
               if (this.produits.getProImpDesciption() == 1) {
                  this.libelle_libre = true;
               } else {
                  this.libelle_libre = false;
               }

               this.typeTarif = false;
               this.inpNatureVnt = "";
               this.inpFamilleVnt = "";
               if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
                  this.famillesProduitsVentes = new FamillesProduitsVentes();
                  this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), this.produits.getProVteCode(), var5);
                  if (this.famillesProduitsVentes != null) {
                     this.inpNatureVnt = this.famillesProduitsVentes.getFamvteNature() + ":" + this.famillesProduitsVentes.getFamvteLibNature();
                     if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty() && this.produits.getProVteLib() != null && !this.produits.getProVteLib().isEmpty()) {
                        this.inpFamilleVnt = this.produits.getProVteCode() + ":" + this.produits.getProVteLib();
                     }

                     if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && this.produits.getProVteNat().equalsIgnoreCase("1104")) {
                        this.typeTarif = true;
                     }
                  }

                  String[] var6;
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

               if (this.produits.getProInactif() != 2) {
                  this.afficheButtSup = true;
               } else {
                  this.afficheButtSup = false;
               }

               this.afficheButtModifProdTar = false;
               this.afficheButtSuppProdTar = false;
               this.affichePhotoProduit();
               this.chargerCaracteristiques(var5);
               this.chargerProduitDepotByProd(var5);
               this.chargerProduitTarifByProd(var5);
               this.chargerProduitMoClefByProd(var5);
               this.chargerProService(var5);
               this.chargerInfoTables(var5);
               if (this.decoupageActivite) {
                  this.chargerDetailanalytique();
                  this.controleEcartAnalytique();
               }

               this.afficheButtOption = true;
            } else {
               this.afficheButtOption = false;
            }

            this.utilInitHibernate.closeSession();
         } else {
            this.afficheButtOption = false;
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
      if (this.lesProduitsServices.size() == 0) {
         if (this.produits.isProAvecService()) {
            this.produits.setProAvecService(false);
            this.produits = this.produitsVtesDao.modifProduit(this.produits);
         }
      } else if (!this.produits.isProAvecService()) {
         this.produits.setProAvecService(true);
         this.produits = this.produitsVtesDao.modifProduit(this.produits);
      }

   }

   public void chargerProduitMoClefByProd(Session var1) throws HibernateException, NamingException {
      this.lesProduitsMcles = this.produitsMclesDao.selectProdMotClefByprod(this.produits, var1);
      this.datamodelMotCle = new ListDataModel();
      this.datamodelMotCle.setWrappedData(this.lesProduitsMcles);
   }

   public void chargerProService(Session var1) throws HibernateException, NamingException {
      this.lesProduitsServices = this.produitsServicesDao.selectProdServiceByprod(this.produits, var1);
      this.datamodelProService.setWrappedData(this.lesProduitsServices);
   }

   public void chargerCaracteristiques(Session var1) throws HibernateException, NamingException {
      this.afficheFormule = false;
      this.existGrp = false;
      this.existGrpCode = false;
      this.datamodelGrp = null;
      this.datamodelCode = null;
      if (this.produits.getProMode() == 0) {
         this.chargerProduitGrpByCode(var1);
         this.existGrp = false;
         if (this.lesProduitsCode.size() > 0) {
            this.existGrpCode = true;
         }
      } else if (this.produits.getProMode() != 1 && this.produits.getProMode() != 2) {
         if (this.produits.getProMode() != 3 && this.produits.getProMode() == 4) {
            this.afficheFormule = true;
         }
      } else {
         this.chargerProduitGrpByProd(var1);
         this.existGrpCode = false;
         if (this.lesProduitsGrps.size() > 0) {
            this.existGrp = true;
         }
      }

   }

   public void chargerProduitDepotByProd(Session var1) throws HibernateException, NamingException {
      this.lesProduitsDepos = this.produitsDepotDao.selectProdDepByprod(this.produits, var1);
      this.datamodelDepot.setWrappedData(this.lesProduitsDepos);
   }

   public void chargerProduitTarifByProd(Session var1) throws HibernateException, NamingException {
      this.lesProduitsTarif = this.produitsTarifDao.selectProdTarifByprod(this.produits, var1);
      this.datamodelTarif.setWrappedData(this.lesProduitsTarif);
      this.lesTarifsPromotion = this.baremesDao.listBaremesByProduitsPromo(this.produits.getProCode(), var1);
      this.dataModelTarifPromotion.setWrappedData(this.lesTarifsPromotion);
      new ArrayList();
      List var2 = this.baremesDao.listBaremesByProduitsTiers(this.produits.getProCode(), var1);
      this.dataModelTarifClients.setWrappedData(var2);
   }

   public void chargerInfoTables(Session var1) throws HibernateException, NamingException {
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

   public void calculeCode() throws HibernateException, NamingException {
      if (this.inpFamilleVnt.contains(":")) {
         String[] var1 = this.inpFamilleVnt.split(":");
         this.famillesProduitsVentes = new FamillesProduitsVentes();
         this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.lastExoVentes.getExevteId(), var1[0], (Session)null);
         if (this.famillesProduitsVentes != null) {
            this.inpNatureVnt = this.famillesProduitsVentes.getFamvteNature() + ":" + this.famillesProduitsVentes.getFamvteLibNature();
         } else {
            this.inpNatureVnt = "";
         }

         this.produits.setProVteCode(this.famillesProduitsVentes.getFamvteCode());
         this.produits.setProVteLib(this.famillesProduitsVentes.getFamvteLibelleFr());
         this.produits.setProVteNat(this.famillesProduitsVentes.getFamvteNature());
         this.valeurDefautFamille();
      } else {
         this.inpNatureVnt = "";
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
               var6 = this.produitsVtesDao.lastProduit((Session)null, 2);
               var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var4 = var3.numero(this.lgNumProd, var6);
               this.produits.setProCode(var4);
               this.verifCode();
            } else if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("3")) {
               this.verouxCod = true;
               var6 = this.produitsVtesDao.lastProduit((Session)null, 3);
               var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var4 = var3.numero(this.lgNumProd, var6);
               this.produits.setProCode(var4);
               this.verifCode();
            } else if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("4")) {
               this.verouxCod = true;
               var6 = this.produitsVtesDao.lastProduit((Session)null, 4);
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
                     var6 = this.produitsVtesDao.lastProduitById(var7[0], (Session)null);
                     var8 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var5 = var8.numero(this.lgNumProd, var6);
                     this.produits.setProCode(var7[0] + "-" + var5);
                     this.verifCode();
                  }
               } else if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("6")) {
                  this.verouxCod = true;
                  if (this.inpFamilleVnt.contains(":")) {
                     var7 = this.inpFamilleVnt.split(":");
                     var6 = this.produitsVtesDao.nbProduitByFamilleVte(var7[0], (Session)null);
                     var8 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var5 = var8.numero(this.lgNumProd, var6);
                     this.produits.setProCode(var7[0] + "-" + var5);
                     this.verifCode();
                  }
               } else if (this.optionsVentes.getModCalcProPRO().equalsIgnoreCase("7")) {
                  this.verouxCod = true;
                  if (this.inpFamilleVnt.contains(":")) {
                     var7 = this.inpFamilleVnt.split(":");
                     var6 = this.produitsVtesDao.lastProduitByFamille(var7[0], (Session)null);
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
         var3 = this.produitsVtesDao.existCode(this.produits.getProCode());
         if (!var3) {
            this.existCod = true;
         } else {
            this.existCod = false;
         }
      } else {
         this.existCod = false;
      }

   }

   public void valeurDefautFamille() throws HibernateException, NamingException {
      if (this.famillesProduitsVentes == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         this.famillesProduitsVentes = new FamillesProduitsVentes();
         this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.lastExoVentes.getExevteId(), this.produits.getProVteCode(), (Session)null);
         if (this.famillesProduitsVentes != null) {
            this.inpNatureVnt = this.famillesProduitsVentes.getFamvteNature() + ":" + this.famillesProduitsVentes.getFamvteLibNature();
         } else {
            this.inpNatureVnt = "";
         }

         this.produits.setProVteCpteLoc(this.famillesProduitsVentes.getFamvteCompteLocal());
         this.produits.setProVteCpteNTx(this.famillesProduitsVentes.getFamvteCompteNonTaxable());
         this.produits.setProVteCpteZ(this.famillesProduitsVentes.getFamvteCompteZone());
         this.produits.setProVteCpteHz(this.famillesProduitsVentes.getFamvteCompteExterieur());
         this.produits.setProVteCptePr(this.famillesProduitsVentes.getFamvteCompteProduit());
         this.produits.setProVteCpteSt(this.famillesProduitsVentes.getFamvteCompteStock());
         this.produits.setProVteCpteCa(this.famillesProduitsVentes.getFamvteCompteCaisse());
         this.produits.setProVteDouane(this.famillesProduitsVentes.getFamvteDouane());
         this.produits.setProVteTva(this.famillesProduitsVentes.getFamvteTaxe());
         this.produits.setProCle1(this.famillesProduitsVentes.getFamvteCle1());
         this.produits.setProCle2(this.famillesProduitsVentes.getFamvteCle2());
         this.produits.setProActivite(this.famillesProduitsVentes.getFamvteActivite());
         this.produits.setProMarque(this.famillesProduitsVentes.getFamvteMarque());
         this.produits.setProStock(this.famillesProduitsVentes.getFamvteStock());
         if (this.famillesProduitsVentes.getFamvteDepotVte() != null && !this.famillesProduitsVentes.getFamvteDepotVte().isEmpty() && this.famillesProduitsVentes.getFamvteDepotVte().contains(":")) {
            String[] var2 = this.famillesProduitsVentes.getFamvteDepotVte().split(":");
            this.produits.setProDepotVte(var2[0]);
         } else {
            this.produits.setProDepotVte((String)null);
         }

         this.chargerInfoTables(var1);
         this.utilInitHibernate.closeSession();
      }

   }

   public void annuleSaisie() {
      this.var_action = 0;
      this.afficheButtOption = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void majProduitRetour() throws JDOMException, IOException, HibernateException, NamingException {
      this.var_action = 0;
      this.majProduit((Session)null);
      this.afficheButtOption = false;
   }

   public void majProduit(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.produits.getProMode() == 5) {
            this.produits.setProStock(0);
         }

         if (this.libelle_libre) {
            this.produits.setProImpDesciption(1);
         } else {
            this.produits.setProImpDesciption(0);
         }

         String[] var3;
         if (this.inpNatureVnt != null && !this.inpNatureVnt.isEmpty() && this.inpNatureVnt.contains(":")) {
            var3 = this.inpNatureVnt.split(":");
            this.produits.setProVteNat(var3[0]);
         } else {
            this.produits.setProVteNat("");
         }

         if (this.inpFamilleVnt != null && !this.inpFamilleVnt.isEmpty() && this.inpFamilleVnt.contains(":")) {
            var3 = this.inpFamilleVnt.split(":");
            this.produits.setProVteCode(var3[0]);
            this.produits.setProVteLib(var3[1]);
         } else {
            this.produits.setProVteCode("");
            this.produits.setProVteLib("");
         }

         boolean var4;
         int var5;
         String var11;
         if (!this.decoupageActivite) {
            if (this.produits.getProActivite() != null && this.produits.getProActivite().contains(":")) {
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

         if (this.getProduits().getProId() == 0L) {
            this.produits.setProDateCreat(new Date());
            this.produits.setProUserCreat(this.usersLog.getUsrid());
            this.produits = this.produitsVtesDao.insert(this.produits, var1);
            this.lesProduits.add(this.produits);
            this.datamodelProduit.setWrappedData(this.lesProduits);
            this.var_action = 2;
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.produits.setProDateModif(new Date());
            this.produits.setProUserModif(this.usersLog.getUsrid());
            this.produits = this.produitsVtesDao.modifProduit(this.produits, var1);
            this.var_action = 0;
            this.afficheButtOption = false;
            Espion var13 = new Espion();
            EspionDao var12 = new EspionDao(this.baseLog, this.utilInitHibernate);
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            String var16 = "";
            if (this.memoAnalytique != null && !this.memoAnalytique.isEmpty() && this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && !this.memoAnalytique.equals(this.produits.getProActivite())) {
               var16 = "Chagement analytique";
            } else if ((this.memoAnalytique == null || this.memoAnalytique.isEmpty()) && this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
               var16 = "Ajout analytique";
            } else if (this.memoAnalytique == null || this.memoAnalytique.isEmpty() || this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
               var16 = "";
            } else {
               var16 = "Annulation analytique";
            }

            var13.setEspaction("Modification produit (vte) N° " + this.produits.getProCode() + " " + var16);
            var12.mAJEspion(var13, var1);
         }

         if (this.produits.getProMode() != 5 && this.produits.getProStock() != 0) {
            boolean var15 = false;
            if (this.produits.getProDepotVte() != null && !this.produits.getProDepotVte().isEmpty()) {
               for(int var14 = 0; var14 < this.lesProduitsDepos.size(); ++var14) {
                  if (((ProduitsDepot)this.lesProduitsDepos.get(var14)).getDepot().getDpoCode().equals(this.produits.getProDepotVte())) {
                     var15 = true;
                  }
               }

               if (!var15) {
                  this.creationProduitDepot(this.produits.getProDepotAch(), var1);
               }
            }
         }

         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdService() == 1) {
            var11 = "";
            if (this.usersLog.getUsrService().contains(":")) {
               String[] var17 = this.usersLog.getUsrService().split(":");
               var11 = var17[0];
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
                  Session var8 = this.utilInitHibernate.getOpenSession(var7, "");
                  Transaction var9 = null;

                  try {
                     var9 = var8.beginTransaction();
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
         ProduitsDepot var4 = new ProduitsDepot();
         var4.setDepot(var3);
         var4.setProduits(this.produits);
         var4.setProdepInactif(0);
         var4.setUnite((Unite)null);
         var4.setProdepEchelle(0);
         var4.setProdepCle(var4.getDepot().getDpoCode() + ":" + var4.getProduits().getProCode());
         if (var4.getProdepGroupe() != null && !var4.getProdepGroupe().isEmpty()) {
            var4.setProdepCle2(var4.getProdepGroupe() + ":" + var4.getProduits().getProCode());
         } else {
            var4.setProdepCle2("");
         }

         var4 = this.produitsDepotDao.insert(var4, var2);
         this.lesProduitsDepos.add(var4);
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

   public void affichePhotoProduit() throws IOException, SQLException {
      if (this.produits.getProPhoto() != null) {
         this.urlphotoProd = "structure" + this.structureLog.getStrid() + "/photos/produits/photo/" + this.produits.getProPhoto();
      } else {
         this.urlphotoProd = "";
      }

   }

   public void verifierPdf() {
      this.existPdfFile = this.isExistPdfFile();
   }

   public boolean isExistPdfFile() {
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "pdf") + File.separator + this.produits.getProCode() + ".pdf";
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
      String var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "pdf") + File.separator + this.produits.getProCode() + ".pdf";
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
            String var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "photo") + File.separator + this.produits.getProCode();
            File var3 = new File(var2);
            if (var3.exists()) {
               var3.delete();
            }

            String var4 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = this.produits.getProCode() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
            this.fileName = var4;
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.produits.setProPhoto(var4);
            this.produitsVtesDao.modifProduit(this.produits);
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + "/photos/produits/photo/" + this.produits.getProPhoto();
         }
      } catch (IOException var7) {
         this.produits.setProPhoto(this.fileName);
         var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var7.printStackTrace();
      }

   }

   public void submitPDF() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.uploadedPDFFile != null) {
         FacesContext var1 = FacesContext.getCurrentInstance();
         String var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "pdf") + File.separator + this.produits.getProCode() + ".pdf";
         File var3 = new File(var2);
         if (var3.exists()) {
            var3.delete();
         }

         try {
            String var4 = this.utilDownload.trimFilePath(this.uploadedPDFFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = this.produits.getProCode() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "pdf" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var4;
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.produits.setProPdf(var4);
            this.produitsVtesDao.modifProduit(this.produits);
         } catch (IOException var7) {
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
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

      String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "photo") + File.separator + this.produits.getProCode() + var1;
      File var4 = new File(var3);
      if (var4.exists()) {
         var4.delete();
      }

      this.produits.setProPhoto((String)null);
      this.produitsVtesDao.modifProduit(this.produits);
   }

   public void reInitPDF() throws HibernateException, NamingException {
      this.produits.setProPdf((String)null);
      this.produitsVtesDao.modifProduit(this.produits);
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "pdf") + File.separator + this.produits.getProCode() + ".pdf";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

   }

   public void recupererCalc() throws HibernateException, NamingException {
      this.chargerCaracteristiques((Session)null);
   }

   public void chargerProduitGrpByProd(Session var1) throws HibernateException, NamingException {
      this.lesProduitsGrps = new ArrayList();
      this.lesProduitsGrps = this.produitsGrpDao.selectProdGrpByprod(this.produits, var1);
      this.datamodelGrp = new ListDataModel();
      this.datamodelGrp.setWrappedData(this.lesProduitsGrps);
   }

   public void chargerProduitGrpByCode(Session var1) throws HibernateException, NamingException {
      this.lesProduitsGrps = new ArrayList();
      this.lesProduitsCode = new ArrayList();
      this.lesProduitsGrps = this.produitsGrpDao.selectProdGrpByCode(this.produits.getProCode(), var1);
      if (this.lesProduitsGrps.size() > 0) {
         String var2 = "0000";

         for(int var3 = 0; var3 < this.lesProduitsGrps.size(); ++var3) {
            ProduitsGrp var4 = (ProduitsGrp)this.lesProduitsGrps.get(var3);
            var2 = var2 + "," + var4.getProduits().getProId();
         }

         var2 = "(" + var2 + ")";
         this.lesProduitsCode = this.produitsVtesDao.selectEgalProduits(var2, var1);
      }

      this.datamodelCode = new ListDataModel();
      this.datamodelCode.setWrappedData(this.lesProduitsCode);
   }

   public void selectionTarif() throws JDOMException, IOException {
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

   public void supprimerTarif() throws HibernateException, NamingException {
      if (this.produitsTarif != null) {
         this.produitsTarifDao.delete(this.produitsTarif);
         this.lesProduitsTarif.remove(this.produitsTarif);
         this.datamodelTarif.setWrappedData(this.lesProduitsTarif);
         this.afficheButtModifProdTar = false;
         this.afficheButtSuppProdTar = false;
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
      } else {
         this.produitsTarif.setProtarInactif(this.getDesactiveModifprodTar());
         this.produitsTarif = this.produitsTarifDao.modif(this.produitsTarif);
      }

      this.showModalTarifSt = false;
      this.chargerProduitTarifByProd((Session)null);
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
      if ("100".equalsIgnoreCase(this.tarifOrdClt)) {
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

   public void annuleTarif() {
      this.showModalTarifSt = false;
   }

   public void selectionTarifDegressif() {
      if (this.dataModelTarifDegressif.isRowAvailable()) {
         this.objetTarif = (ObjetTarif)this.dataModelTarifDegressif.getRowData();
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

   public void selectionTarifPromotion() {
      if (this.dataModelTarifPromotion.isRowAvailable()) {
         this.baremes = (Baremes)this.dataModelTarifPromotion.getRowData();
         this.visibiliteBtonTarifPromotion = true;
      }

   }

   public void ajouterTarifPromotion() {
      this.baremes = new Baremes();
      this.visibiliteBtonTarifPromotion = false;
      this.showModalPanelTarifPromotion = true;
   }

   public void modifierTarifPromotion() {
      if (this.baremes != null) {
         this.visibiliteBtonTarifPromotion = false;
         this.showModalPanelTarifPromotion = true;
      }

   }

   public void supprimerTarifPromotion() throws HibernateException, NamingException {
      if (this.baremes != null) {
         this.baremesDao.delete(this.baremes);
         this.lesTarifsPromotion.remove(this.baremes);
         this.dataModelTarifPromotion.setWrappedData(this.lesTarifsPromotion);
         this.visibiliteBtonTarifPromotion = false;
      }

   }

   public void validerTarifPromotion() throws HibernateException, NamingException {
      if (this.baremes != null) {
         if (this.baremes.getBarDateDebut() != null && this.baremes.getBarDateFin() != null && this.baremes.getBarDateDebut().compareTo(this.baremes.getBarDateFin()) > 0) {
            Date var1 = this.baremes.getBarDateFin();
            this.baremes.setBarDateFin(this.baremes.getBarDateDebut());
            this.baremes.setBarDateDebut(var1);
         }

         if (this.baremes.getBarId() == 0L) {
            this.baremes.setBarCodeProduit(this.produits.getProCode());
            this.baremes.setBarLibelleProduit(this.produits.getProLibClient());
            this.baremes.setBarDateCreat(new Date());
            this.baremes.setBarType(2);
            this.baremes.setBarUserCreat(this.usersLog.getUsrid());
            this.baremes = this.baremesDao.insert(this.baremes);
            this.lesTarifsPromotion.add(this.baremes);
            this.dataModelTarifPromotion.setWrappedData(this.lesTarifsPromotion);
         } else {
            this.baremes.setBarDateModif(new Date());
            this.baremes.setBarUserModif(this.usersLog.getUsrid());
            this.baremes = this.baremesDao.modif(this.baremes);
         }
      }

      this.showModalPanelTarifPromotion = false;
   }

   public void fermerTarifPromotion() {
      this.visibiliteBtonTarifPromotion = false;
      this.showModalPanelTarifPromotion = false;
   }

   public void selectionProduitTarif() throws IOException, SQLException, HibernateException, NamingException {
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

         if (var1.size() != 0) {
            this.produits = (Produits)var1.get(0);
            long var7 = this.produits.getProId();
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsTarif");
            this.produits = this.produitsVtesDao.chargeProduit(var7, var5);
            if (this.produits != null) {
               this.typeTarif = false;
               this.afficheButtOption = true;
               if (this.produits.getProInactif() != 2) {
                  this.afficheButtSup = true;
               } else {
                  this.afficheButtSup = false;
               }

               this.chargerProduitTarifByProd(var5);
               this.produits.setPv1(0.0D);
               this.produits.setPv1Marche(0.0D);
               this.var_p1CC1 = 0.0D;
               this.var_p1CC2 = 0.0D;
               this.var_p1CC3 = 0.0D;
               this.produits.setPv2(0.0D);
               this.produits.setPv2Marche(0.0D);
               this.var_p2CC1 = 0.0D;
               this.var_p2CC2 = 0.0D;
               this.var_p2CC3 = 0.0D;
               this.produits.setPv3(0.0D);
               this.produits.setPv3Marche(0.0D);
               this.var_p3CC1 = 0.0D;
               this.var_p3CC2 = 0.0D;
               this.var_p3CC3 = 0.0D;
               this.produits.setPv4(0.0D);
               this.produits.setPv4Marche(0.0D);
               this.var_p4CC1 = 0.0D;
               this.var_p4CC2 = 0.0D;
               this.var_p4CC3 = 0.0D;
               this.produits.setPv5(0.0D);
               this.produits.setPv5Marche(0.0D);
               this.var_p5CC1 = 0.0D;
               this.var_p5CC2 = 0.0D;
               this.var_p5CC3 = 0.0D;
               this.produits.setPv6(0.0D);
               this.produits.setPv6Marche(0.0D);
               this.var_p6CC1 = 0.0D;
               this.var_p6CC2 = 0.0D;
               this.var_p6CC3 = 0.0D;
               this.produits.setPv7(0.0D);
               this.produits.setPv7Marche(0.0D);
               this.var_p7CC1 = 0.0D;
               this.var_p7CC2 = 0.0D;
               this.var_p7CC3 = 0.0D;
               this.produits.setPv8(0.0D);
               this.produits.setPv8Marche(0.0D);
               this.var_p8CC1 = 0.0D;
               this.var_p8CC2 = 0.0D;
               this.var_p8CC3 = 0.0D;
               this.produits.setPv9(0.0D);
               this.produits.setPv9Marche(0.0D);
               this.var_p9CC1 = 0.0D;
               this.var_p9CC2 = 0.0D;
               this.var_p9CC3 = 0.0D;
               this.produits.setPv10(0.0D);
               this.produits.setPv10Marche(0.0D);
               this.var_p10CC1 = 0.0D;
               this.var_p10CC2 = 0.0D;
               this.var_p10CC3 = 0.0D;
               if (this.lesProduitsTarif.size() != 0) {
                  for(int var6 = 0; var6 < this.lesProduitsTarif.size(); ++var6) {
                     this.produitsTarif = (ProduitsTarif)this.lesProduitsTarif.get(var6);
                     if (var6 == 0) {
                        this.produits.setPv1(this.produitsTarif.getProtarPv());
                        this.produits.setPv1Marche(this.produitsTarif.getProtarPvMarche());
                        this.var_p1CC1 = this.produitsTarif.getProtarPvCc1();
                        this.var_p1CC2 = this.produitsTarif.getProtarPvCc2();
                        this.var_p1CC3 = this.produitsTarif.getProtarPvCc3();
                        this.var_n1CC1 = this.produitsTarif.getProtarNomCc1();
                        this.var_n1CC2 = this.produitsTarif.getProtarNomCc2();
                        this.var_n1CC3 = this.produitsTarif.getProtarNomCc3();
                        this.var_d1CC1 = this.produitsTarif.getProtarDateCc1();
                        this.var_d1CC2 = this.produitsTarif.getProtarDateCc2();
                        this.var_d1CC3 = this.produitsTarif.getProtarDateCc3();
                     } else if (var6 == 1) {
                        this.produits.setPv2(this.produitsTarif.getProtarPv());
                        this.produits.setPv2Marche(this.produitsTarif.getProtarPvMarche());
                        this.var_p2CC1 = this.produitsTarif.getProtarPvCc1();
                        this.var_p2CC2 = this.produitsTarif.getProtarPvCc2();
                        this.var_p2CC3 = this.produitsTarif.getProtarPvCc3();
                        this.var_n2CC1 = this.produitsTarif.getProtarNomCc1();
                        this.var_n2CC2 = this.produitsTarif.getProtarNomCc2();
                        this.var_n2CC3 = this.produitsTarif.getProtarNomCc3();
                        this.var_d2CC1 = this.produitsTarif.getProtarDateCc1();
                        this.var_d2CC2 = this.produitsTarif.getProtarDateCc2();
                        this.var_d2CC3 = this.produitsTarif.getProtarDateCc3();
                     } else if (var6 == 2) {
                        this.produits.setPv3(this.produitsTarif.getProtarPv());
                        this.produits.setPv3Marche(this.produitsTarif.getProtarPvMarche());
                        this.var_p3CC1 = this.produitsTarif.getProtarPvCc1();
                        this.var_p3CC2 = this.produitsTarif.getProtarPvCc2();
                        this.var_p3CC3 = this.produitsTarif.getProtarPvCc3();
                        this.var_n3CC1 = this.produitsTarif.getProtarNomCc1();
                        this.var_n3CC2 = this.produitsTarif.getProtarNomCc2();
                        this.var_n3CC3 = this.produitsTarif.getProtarNomCc3();
                        this.var_d3CC1 = this.produitsTarif.getProtarDateCc1();
                        this.var_d3CC2 = this.produitsTarif.getProtarDateCc2();
                        this.var_d3CC3 = this.produitsTarif.getProtarDateCc3();
                     } else if (var6 == 3) {
                        this.produits.setPv4(this.produitsTarif.getProtarPv());
                        this.produits.setPv4Marche(this.produitsTarif.getProtarPvMarche());
                        this.var_p4CC1 = this.produitsTarif.getProtarPvCc1();
                        this.var_p4CC2 = this.produitsTarif.getProtarPvCc2();
                        this.var_p4CC3 = this.produitsTarif.getProtarPvCc3();
                        this.var_n4CC1 = this.produitsTarif.getProtarNomCc1();
                        this.var_n4CC2 = this.produitsTarif.getProtarNomCc2();
                        this.var_n4CC3 = this.produitsTarif.getProtarNomCc3();
                        this.var_d4CC1 = this.produitsTarif.getProtarDateCc1();
                        this.var_d4CC2 = this.produitsTarif.getProtarDateCc2();
                        this.var_d4CC3 = this.produitsTarif.getProtarDateCc3();
                     } else if (var6 == 4) {
                        this.produits.setPv5(this.produitsTarif.getProtarPv());
                        this.produits.setPv5Marche(this.produitsTarif.getProtarPvMarche());
                        this.var_p5CC1 = this.produitsTarif.getProtarPvCc1();
                        this.var_p5CC2 = this.produitsTarif.getProtarPvCc2();
                        this.var_p5CC3 = this.produitsTarif.getProtarPvCc3();
                        this.var_n5CC1 = this.produitsTarif.getProtarNomCc1();
                        this.var_n5CC2 = this.produitsTarif.getProtarNomCc2();
                        this.var_n5CC3 = this.produitsTarif.getProtarNomCc3();
                        this.var_d5CC1 = this.produitsTarif.getProtarDateCc1();
                        this.var_d5CC2 = this.produitsTarif.getProtarDateCc2();
                        this.var_d5CC3 = this.produitsTarif.getProtarDateCc3();
                     } else if (var6 == 5) {
                        this.produits.setPv6(this.produitsTarif.getProtarPv());
                        this.produits.setPv6Marche(this.produitsTarif.getProtarPvMarche());
                        this.var_p6CC1 = this.produitsTarif.getProtarPvCc1();
                        this.var_p6CC2 = this.produitsTarif.getProtarPvCc2();
                        this.var_p6CC3 = this.produitsTarif.getProtarPvCc3();
                        this.var_n6CC1 = this.produitsTarif.getProtarNomCc1();
                        this.var_n6CC2 = this.produitsTarif.getProtarNomCc2();
                        this.var_n6CC3 = this.produitsTarif.getProtarNomCc3();
                        this.var_d6CC1 = this.produitsTarif.getProtarDateCc1();
                        this.var_d6CC2 = this.produitsTarif.getProtarDateCc2();
                        this.var_d6CC3 = this.produitsTarif.getProtarDateCc3();
                     } else if (var6 == 6) {
                        this.produits.setPv7(this.produitsTarif.getProtarPv());
                        this.produits.setPv7Marche(this.produitsTarif.getProtarPvMarche());
                        this.var_p7CC1 = this.produitsTarif.getProtarPvCc1();
                        this.var_p7CC2 = this.produitsTarif.getProtarPvCc2();
                        this.var_p7CC3 = this.produitsTarif.getProtarPvCc3();
                        this.var_n7CC1 = this.produitsTarif.getProtarNomCc1();
                        this.var_n7CC2 = this.produitsTarif.getProtarNomCc2();
                        this.var_n7CC3 = this.produitsTarif.getProtarNomCc3();
                        this.var_d7CC1 = this.produitsTarif.getProtarDateCc1();
                        this.var_d7CC2 = this.produitsTarif.getProtarDateCc2();
                        this.var_d7CC3 = this.produitsTarif.getProtarDateCc3();
                     } else if (var6 == 7) {
                        this.produits.setPv8(this.produitsTarif.getProtarPv());
                        this.produits.setPv8Marche(this.produitsTarif.getProtarPvMarche());
                        this.var_p8CC1 = this.produitsTarif.getProtarPvCc1();
                        this.var_p8CC2 = this.produitsTarif.getProtarPvCc2();
                        this.var_p8CC3 = this.produitsTarif.getProtarPvCc3();
                        this.var_n8CC1 = this.produitsTarif.getProtarNomCc1();
                        this.var_n8CC2 = this.produitsTarif.getProtarNomCc2();
                        this.var_n8CC3 = this.produitsTarif.getProtarNomCc3();
                        this.var_d8CC1 = this.produitsTarif.getProtarDateCc1();
                        this.var_d8CC2 = this.produitsTarif.getProtarDateCc2();
                        this.var_d8CC3 = this.produitsTarif.getProtarDateCc3();
                     } else if (var6 == 8) {
                        this.produits.setPv9(this.produitsTarif.getProtarPv());
                        this.produits.setPv9Marche(this.produitsTarif.getProtarPvMarche());
                        this.var_p9CC1 = this.produitsTarif.getProtarPvCc1();
                        this.var_p9CC2 = this.produitsTarif.getProtarPvCc2();
                        this.var_p9CC3 = this.produitsTarif.getProtarPvCc3();
                        this.var_n9CC1 = this.produitsTarif.getProtarNomCc1();
                        this.var_n9CC2 = this.produitsTarif.getProtarNomCc2();
                        this.var_n9CC3 = this.produitsTarif.getProtarNomCc3();
                        this.var_d9CC1 = this.produitsTarif.getProtarDateCc1();
                        this.var_d9CC2 = this.produitsTarif.getProtarDateCc2();
                        this.var_d9CC3 = this.produitsTarif.getProtarDateCc3();
                     } else if (var6 == 9) {
                        this.produits.setPv10(this.produitsTarif.getProtarPv());
                        this.produits.setPv10Marche(this.produitsTarif.getProtarPvMarche());
                        this.var_p10CC1 = this.produitsTarif.getProtarPvCc1();
                        this.var_p10CC2 = this.produitsTarif.getProtarPvCc2();
                        this.var_p10CC3 = this.produitsTarif.getProtarPvCc3();
                        this.var_n10CC1 = this.produitsTarif.getProtarNomCc1();
                        this.var_n10CC2 = this.produitsTarif.getProtarNomCc2();
                        this.var_n10CC3 = this.produitsTarif.getProtarNomCc3();
                        this.var_d10CC1 = this.produitsTarif.getProtarDateCc1();
                        this.var_d10CC2 = this.produitsTarif.getProtarDateCc2();
                        this.var_d10CC3 = this.produitsTarif.getProtarDateCc3();
                     }
                  }
               }

               this.utilInitHibernate.closeSession();
            }
         }
      }

   }

   public void visualisationLigneTarif() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.produits != null) {
         this.tarifProduit();
      }

   }

   public void tarifProduit() {
      this.var_action = 2;
   }

   public void annulerTarifProduit() {
      this.var_action = 0;
   }

   public void validerTarifProduit() throws HibernateException, NamingException {
      if (this.lesProduitsTarif.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsTarif");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesProduitsTarif.size(); ++var3) {
               this.produitsTarif = (ProduitsTarif)this.lesProduitsTarif.get(var3);
               if (var3 == 0) {
                  this.produitsTarif.setProtarPv(this.produits.getPv1());
                  this.produitsTarif.setProtarPvMarche(this.produits.getPv1Marche());
                  this.produitsTarif.setProtarPvCc1(this.var_p1CC1);
                  this.produitsTarif.setProtarPvCc2(this.var_p1CC2);
                  this.produitsTarif.setProtarPvCc3(this.var_p1CC3);
                  this.produitsTarif.setProtarNomCc1(this.var_n1CC1);
                  this.produitsTarif.setProtarNomCc2(this.var_n1CC2);
                  this.produitsTarif.setProtarNomCc3(this.var_n1CC3);
                  this.produitsTarif.setProtarDateCc1(this.var_d1CC1);
                  this.produitsTarif.setProtarDateCc2(this.var_d1CC2);
                  this.produitsTarif.setProtarDateCc3(this.var_d1CC3);
               } else if (var3 == 1) {
                  this.produitsTarif.setProtarPv(this.produits.getPv2());
                  this.produitsTarif.setProtarPvMarche(this.produits.getPv2Marche());
                  this.produitsTarif.setProtarPvCc1(this.var_p2CC1);
                  this.produitsTarif.setProtarPvCc2(this.var_p2CC2);
                  this.produitsTarif.setProtarPvCc3(this.var_p2CC3);
                  this.produitsTarif.setProtarNomCc1(this.var_n2CC1);
                  this.produitsTarif.setProtarNomCc2(this.var_n2CC2);
                  this.produitsTarif.setProtarNomCc3(this.var_n2CC3);
                  this.produitsTarif.setProtarDateCc1(this.var_d2CC1);
                  this.produitsTarif.setProtarDateCc2(this.var_d2CC2);
                  this.produitsTarif.setProtarDateCc3(this.var_d2CC3);
               } else if (var3 == 2) {
                  this.produitsTarif.setProtarPv(this.produits.getPv3());
                  this.produitsTarif.setProtarPvMarche(this.produits.getPv3Marche());
                  this.produitsTarif.setProtarPvCc1(this.var_p3CC1);
                  this.produitsTarif.setProtarPvCc2(this.var_p3CC2);
                  this.produitsTarif.setProtarPvCc3(this.var_p3CC3);
                  this.produitsTarif.setProtarNomCc1(this.var_n3CC1);
                  this.produitsTarif.setProtarNomCc2(this.var_n3CC2);
                  this.produitsTarif.setProtarNomCc3(this.var_n3CC3);
                  this.produitsTarif.setProtarDateCc1(this.var_d3CC1);
                  this.produitsTarif.setProtarDateCc2(this.var_d3CC2);
                  this.produitsTarif.setProtarDateCc3(this.var_d3CC3);
               } else if (var3 == 3) {
                  this.produitsTarif.setProtarPv(this.produits.getPv4());
                  this.produitsTarif.setProtarPvMarche(this.produits.getPv4Marche());
                  this.produitsTarif.setProtarPvCc1(this.var_p4CC1);
                  this.produitsTarif.setProtarPvCc2(this.var_p4CC2);
                  this.produitsTarif.setProtarPvCc3(this.var_p4CC3);
                  this.produitsTarif.setProtarNomCc1(this.var_n4CC1);
                  this.produitsTarif.setProtarNomCc2(this.var_n4CC2);
                  this.produitsTarif.setProtarNomCc3(this.var_n4CC3);
                  this.produitsTarif.setProtarDateCc1(this.var_d4CC1);
                  this.produitsTarif.setProtarDateCc2(this.var_d4CC2);
                  this.produitsTarif.setProtarDateCc3(this.var_d4CC3);
               } else if (var3 == 4) {
                  this.produitsTarif.setProtarPv(this.produits.getPv5());
                  this.produitsTarif.setProtarPvMarche(this.produits.getPv5Marche());
                  this.produitsTarif.setProtarPvCc1(this.var_p5CC1);
                  this.produitsTarif.setProtarPvCc2(this.var_p5CC2);
                  this.produitsTarif.setProtarPvCc3(this.var_p5CC3);
                  this.produitsTarif.setProtarNomCc1(this.var_n5CC1);
                  this.produitsTarif.setProtarNomCc2(this.var_n5CC2);
                  this.produitsTarif.setProtarNomCc3(this.var_n5CC3);
                  this.produitsTarif.setProtarDateCc1(this.var_d5CC1);
                  this.produitsTarif.setProtarDateCc2(this.var_d5CC2);
                  this.produitsTarif.setProtarDateCc3(this.var_d5CC3);
               } else if (var3 == 5) {
                  this.produitsTarif.setProtarPv(this.produits.getPv6());
                  this.produitsTarif.setProtarPvMarche(this.produits.getPv6Marche());
                  this.produitsTarif.setProtarPvCc1(this.var_p6CC1);
                  this.produitsTarif.setProtarPvCc2(this.var_p6CC2);
                  this.produitsTarif.setProtarPvCc3(this.var_p6CC3);
                  this.produitsTarif.setProtarNomCc1(this.var_n6CC1);
                  this.produitsTarif.setProtarNomCc2(this.var_n6CC2);
                  this.produitsTarif.setProtarNomCc3(this.var_n6CC3);
                  this.produitsTarif.setProtarDateCc1(this.var_d6CC1);
                  this.produitsTarif.setProtarDateCc2(this.var_d6CC2);
                  this.produitsTarif.setProtarDateCc3(this.var_d6CC3);
               } else if (var3 == 6) {
                  this.produitsTarif.setProtarPv(this.produits.getPv7());
                  this.produitsTarif.setProtarPvMarche(this.produits.getPv7Marche());
                  this.produitsTarif.setProtarPvCc1(this.var_p7CC1);
                  this.produitsTarif.setProtarPvCc2(this.var_p7CC2);
                  this.produitsTarif.setProtarPvCc3(this.var_p7CC3);
                  this.produitsTarif.setProtarNomCc1(this.var_n7CC1);
                  this.produitsTarif.setProtarNomCc2(this.var_n7CC2);
                  this.produitsTarif.setProtarNomCc3(this.var_n7CC3);
                  this.produitsTarif.setProtarDateCc1(this.var_d7CC1);
                  this.produitsTarif.setProtarDateCc2(this.var_d7CC2);
                  this.produitsTarif.setProtarDateCc3(this.var_d7CC3);
               } else if (var3 == 7) {
                  this.produitsTarif.setProtarPv(this.produits.getPv8());
                  this.produitsTarif.setProtarPvMarche(this.produits.getPv8Marche());
                  this.produitsTarif.setProtarPvCc1(this.var_p8CC1);
                  this.produitsTarif.setProtarPvCc2(this.var_p8CC2);
                  this.produitsTarif.setProtarPvCc3(this.var_p8CC3);
                  this.produitsTarif.setProtarNomCc1(this.var_n8CC1);
                  this.produitsTarif.setProtarNomCc2(this.var_n8CC2);
                  this.produitsTarif.setProtarNomCc3(this.var_n8CC3);
                  this.produitsTarif.setProtarDateCc1(this.var_d8CC1);
                  this.produitsTarif.setProtarDateCc2(this.var_d8CC2);
                  this.produitsTarif.setProtarDateCc3(this.var_d8CC3);
               } else if (var3 == 8) {
                  this.produitsTarif.setProtarPv(this.produits.getPv9());
                  this.produitsTarif.setProtarPvMarche(this.produits.getPv9Marche());
                  this.produitsTarif.setProtarPvCc1(this.var_p9CC1);
                  this.produitsTarif.setProtarPvCc2(this.var_p9CC2);
                  this.produitsTarif.setProtarPvCc3(this.var_p9CC3);
                  this.produitsTarif.setProtarNomCc1(this.var_n9CC1);
                  this.produitsTarif.setProtarNomCc2(this.var_n9CC2);
                  this.produitsTarif.setProtarNomCc3(this.var_n9CC3);
                  this.produitsTarif.setProtarDateCc1(this.var_d9CC1);
                  this.produitsTarif.setProtarDateCc2(this.var_d9CC2);
                  this.produitsTarif.setProtarDateCc3(this.var_d9CC3);
               } else if (var3 == 9) {
                  this.produitsTarif.setProtarPv(this.produits.getPv10());
                  this.produitsTarif.setProtarPvMarche(this.produits.getPv10Marche());
                  this.produitsTarif.setProtarPvCc1(this.var_p10CC1);
                  this.produitsTarif.setProtarPvCc2(this.var_p10CC2);
                  this.produitsTarif.setProtarPvCc3(this.var_p10CC3);
                  this.produitsTarif.setProtarNomCc1(this.var_n10CC1);
                  this.produitsTarif.setProtarNomCc2(this.var_n10CC2);
                  this.produitsTarif.setProtarNomCc3(this.var_n10CC3);
                  this.produitsTarif.setProtarDateCc1(this.var_d10CC1);
                  this.produitsTarif.setProtarDateCc2(this.var_d10CC2);
                  this.produitsTarif.setProtarDateCc3(this.var_d10CC3);
               }
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

      this.var_action = 0;
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

   public void saveProduitsServices() throws HibernateException, NamingException {
      this.produitsServices.setProduits(this.produits);
      this.produitsServices.setServices(this.produitsServices.getServices());
      this.produitsServices.setProserCode(this.produitsServices.getProserCode());
      this.produitsServices.setProserNomFr(this.produitsServices.getProserNomFr());
      this.produitsServicesDao.insert(this.produitsServices);
      this.chargerProService();
      this.majService();
      this.showModalService = false;
   }

   public void chargerProService() throws HibernateException, NamingException {
      this.lesProduitsServices = this.produitsServicesDao.selectProdServiceByprod(this.produits, (Session)null);
      this.datamodelProService.setWrappedData(this.lesProduitsServices);
   }

   public void deleteProduitsServices() throws HibernateException, NamingException {
      if (this.produitsServices != null) {
         this.produitsServicesDao.deletProdService(this.produitsServices.getProserId());
         this.chargerProService();
         this.afficheButtSuppProdServ = false;
         this.majService();
      }

   }

   public void initProduitsServiceSelected() {
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
      this.testCodLibService = false;
      this.showModalService = true;
   }

   public void annuleService() {
      this.showModalService = false;
   }

   public void decoupageCodLibService() throws JDOMException, IOException, HibernateException, NamingException {
      if (!this.prodCodeLibService.equalsIgnoreCase("0") && !this.prodCodeLibService.equalsIgnoreCase("")) {
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

   }

   public void rechercheProduitsLies() throws HibernateException, NamingException {
      if (this.produits.getProCodeLie() != null && !this.produits.getProCodeLie().isEmpty()) {
         this.lesProduitsLiesRecherche = new ArrayList();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         if (this.usersLog.getUsrProdService() == 1 && !this.usersLog.getUsrService().isEmpty()) {
            Service var6 = this.serviceDao.chargerLeServiceCode(this.usersLog.getUsrService(), var1);
            new ArrayList();
            List var8 = this.produitsServicesDao.selectProdServiceByservVtes(var6, this.produits.getProCodeLie(), var1);
            if (var8.size() != 0) {
               for(int var10 = 0; var10 < var8.size(); ++var10) {
                  new Produits();
                  Produits var5 = ((ProduitsServices)var8.get(var10)).getProduits();
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
            this.lesProduitsLiesRecherche = this.produitsVtesDao.verifProduits(this.produits.getProCodeLie(), var1);
         }

         if (this.lesProduitsLiesRecherche.size() != 0) {
            for(int var7 = 0; var7 < this.lesProduitsLiesRecherche.size(); ++var7) {
               new Produits();
               Produits var9 = (Produits)this.lesProduitsLiesRecherche.get(var7);
               if (var9.getProCode().equalsIgnoreCase(this.produits.getProCode())) {
                  this.lesProduitsLiesRecherche.remove(var7);
                  break;
               }
            }
         }

         this.datamodelProduitsLieRecherche.setWrappedData(this.lesProduitsLiesRecherche);
         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionProduitsLies() {
      if (this.datamodelProduitsLieRecherche.isRowAvailable()) {
         this.produitsLies = (Produits)this.datamodelProduitsLieRecherche.getRowData();
      }

   }

   public void calculeProduits() throws JDOMException, IOException {
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

   }

   public void annuleProduits() {
      this.produitsLies = null;
      this.produits.setProCodeLie("");
      this.produits.setProQteLie(0.0F);
      this.lesProduitsLiesRecherche.clear();
   }

   public void initChargerMouvements() throws NamingException, ParseException {
      this.var_date_debut = this.utilDate.datePremierJourAnnee(new Date());
      this.var_date_fin = new Date();
      this.selRien();
      this.lesMvt = new ArrayList();
      this.datamodelMvt = new ListDataModel();
      this.datamodelMvt.setWrappedData(this.lesMvt);
      this.var_choix_modele = 2;
      this.var_action = 4;
   }

   public void selStock() {
      this.var_mvt_as_inventaire = false;
      this.var_mvt_as_bin = false;
      this.var_mvt_as_bout = false;
      this.var_mvt_as_cession = false;
      this.var_mvt_as_reexpedition = false;
      this.var_mvt_as_production = false;
      this.var_mvt_ss_fcotation = false;
      this.var_mvt_ss_fcommande = false;
      this.var_mvt_as_freception = false;
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
   }

   public void selTout() {
      this.var_mvt_as_inventaire = false;
      this.var_mvt_as_bin = false;
      this.var_mvt_as_bout = false;
      this.var_mvt_as_cession = false;
      this.var_mvt_as_reexpedition = false;
      this.var_mvt_as_production = false;
      this.var_mvt_ss_fcotation = false;
      this.var_mvt_ss_fcommande = false;
      this.var_mvt_as_freception = false;
      this.var_mvt_as_fsav = false;
      this.var_mvt_ss_ffacture = false;
      this.var_mvt_ss_favoir = false;
      this.var_mvt_ss_cdevis = true;
      this.var_mvt_ss_ccmd = true;
      this.var_mvt_as_cbl = true;
      this.var_mvt_as_cchg = true;
      this.var_mvt_as_ticket = true;
      this.var_mvt_as_cretour = true;
      this.var_mvt_ss_cfacture = true;
      this.var_mvt_ss_cavoir = true;
   }

   public void selRien() {
      this.var_mvt_as_inventaire = false;
      this.var_mvt_as_bin = false;
      this.var_mvt_as_bout = false;
      this.var_mvt_as_cession = false;
      this.var_mvt_as_reexpedition = false;
      this.var_mvt_as_production = false;
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
   }

   public void chargerMouvements() throws NamingException, ParseException {
      CalculStock var1 = new CalculStock();
      var1.setutilInitHibernate(this.utilInitHibernate);
      var1.setBaseLog(this.baseLog);
      var1.setStructureLog(this.structureLog);
      this.lesMvt.clear();
      String var2 = "";
      if (this.var_depot != null && this.var_depot.contains(":")) {
         String[] var3 = this.var_depot.split(":");
         var2 = var3[0];
         this.afficheProgress = true;
      } else {
         var2 = "";
         this.afficheProgress = false;
      }

      String var7 = "";
      if (this.var_activites != null && this.var_activites.contains(":")) {
         String[] var4 = this.var_activites.split(":");
         var7 = var4[0];
      } else {
         var7 = "";
      }

      String var8 = "";
      if (this.var_services != null && this.var_services.contains(":")) {
         var8 = this.var_services;
      } else {
         var8 = "";
      }

      String var5 = "";
      if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
         var5 = this.produits.getProVteNat();
      } else {
         var5 = this.produits.getProAchNat();
      }

      this.lesMvt = var1.chargerMouvements(0, "", var5, this.produits.getProCode(), this.produits.getProLibTech(), var2, 0L, var7, var8, this.var_date_debut, this.var_date_fin, this.var_mvt_ss_fcotation, this.var_mvt_ss_fcommande, this.var_mvt_as_freception, this.var_mvt_as_fsav, this.var_mvt_ss_ffacture, this.var_mvt_ss_favoir, this.var_mvt_as_inventaire, this.var_mvt_as_bin, this.var_mvt_as_bout, this.var_mvt_as_cession, this.var_mvt_as_fabrication, this.var_mvt_ss_cdevis, this.var_mvt_ss_ccmd, this.var_mvt_as_cbl, this.var_mvt_as_cretour, this.var_mvt_ss_cfacture, this.var_mvt_ss_cavoir, false, this.var_mvt_as_cchg, this.var_mvt_ss_cnoteDebit, this.var_mvt_as_ticket, this.optionsVentes.getGestionStockBc(), this.baseLog, this.structureLog, (Session)null);
      this.lesMvt = var1.sort(this.lesMvt);
      this.datamodelMvt.setWrappedData(this.lesMvt);
      this.tot_qte_out = 0.0F;
      this.tot_qte_in = 0.0F;
      this.tot_montant = 0.0D;
      if (this.lesMvt.size() != 0) {
         for(int var6 = 0; var6 < this.lesMvt.size(); ++var6) {
            this.tot_qte_out += ((Stock)this.lesMvt.get(var6)).getStk_qte_out();
            this.tot_qte_in += ((Stock)this.lesMvt.get(var6)).getStk_qte_in();
            this.tot_montant += ((Stock)this.lesMvt.get(var6)).getStk_pv() * (double)((Stock)this.lesMvt.get(var6)).getStk_qte_out();
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
         new ProduitsDepot();

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            ProduitsDepot var2 = (ProduitsDepot)var1.get(var3);

            for(int var4 = 0; var4 < this.mesProduitsDepotsItems.size(); ++var4) {
               String[] var5 = ((SelectItem)this.mesProduitsDepotsItems.get(var4)).getLabel().toString().split(":");
               if (var5[0].equals(var2.getDepot().getDpoCode())) {
                  this.lesProduitsDepos.add(var2);
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

   public void initCarte(Session var1) throws HibernateException, NamingException {
      this.dataModelFamille = new ListDataModel();
      this.lesFamillesVentesProduits = new ArrayList();
      this.lesFamillesVentesProduits = this.famillesProduitsVentesDao.selectAllFamillUtilCartes(this.exercicesVentes.getExevteId(), var1);
      this.dataModelFamille.setWrappedData(this.lesFamillesVentesProduits);
      this.afficheButtCarte = false;
      this.afficheButtArticle = false;
   }

   public void selectionCarte() throws HibernateException, NamingException, JDOMException, IOException {
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
            this.famillesProduitsVentes = (FamillesProduitsVentes)var1.get(0);
            this.lesProduits.clear();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
            this.lesProduits = this.produitsVtesDao.chargerLesProduitsVentesByFamille(this.famillesProduitsVentes.getFamvteCode(), var4);
            this.mefProduit(var4);
            this.utilInitHibernate.closeSession();
            this.datamodelProduit.setWrappedData(this.lesProduits);
            this.afficheButtCarte = true;
            this.afficheButtArticle = false;
         } else {
            this.afficheButtCarte = false;
            this.afficheButtArticle = false;
         }
      } else {
         this.afficheButtCarte = false;
         this.afficheButtArticle = false;
      }

   }

   public void ajouterCarte() {
      this.famillesProduitsVentes = new FamillesProduitsVentes();
      this.showModalpanelCarte = true;
   }

   public void modifierCarte() {
      if (this.famillesProduitsVentes != null) {
         this.showModalpanelCarte = true;
      }

   }

   public void supprimerCarte() {
      if (this.famillesProduitsVentes != null) {
      }

   }

   public void annulerCarte() {
      this.showModalpanelCarte = false;
   }

   public void validerCarte() throws HibernateException, NamingException {
      this.famillesProduitsVentes.setExerciceventes(this.exercicesVentes);
      this.famillesProduitsVentes.setFamvteNature("1615");
      this.famillesProduitsVentes.setFamvteLibNature("Carte restaurant");
      this.famillesProduitsVentes.setFamvteCat(0);
      if (this.famillesProduitsVentes.getFamvteId() == 0L) {
         this.famillesProduitsVentes.setFamvteDateCreation(new Date());
         this.famillesProduitsVentes.setFamvteUserCreation(this.usersLog.getUsrid());
         this.famillesProduitsVentes = this.famillesProduitsVentesDao.insert(this.famillesProduitsVentes);
         this.lesFamillesVentesProduits.add(this.famillesProduitsVentes);
         this.dataModelFamille.setWrappedData(this.lesFamillesVentesProduits);
      } else {
         this.famillesProduitsVentes.setFamvteDateModif(new Date());
         this.famillesProduitsVentes.setFamvteUserModif(this.usersLog.getUsrid());
         this.famillesProduitsVentes = this.famillesProduitsVentesDao.modif(this.famillesProduitsVentes);
      }

      this.showModalpanelCarte = false;
   }

   public void selectionArticle() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.datamodelProduit.isRowAvailable()) {
         this.produits = (Produits)this.datamodelProduit.getRowData();
         this.afficheButtArticle = true;
         this.showModalpanelArticle = true;
      }

   }

   public void ajouterArticle() {
      if (this.famillesProduitsVentes != null) {
         this.produits = new Produits();
         this.produits.setProVteCode(this.famillesProduitsVentes.getFamvteCode());
         this.showModalpanelArticle = true;
      }

   }

   public void modifierArticle() {
      if (this.produits != null) {
         this.showModalpanelArticle = true;
      }

   }

   public void supprimerArticle() {
      if (this.produits != null) {
      }

   }

   public void annulerArticle() {
      this.afficheButtArticle = false;
      this.showModalpanelArticle = false;
   }

   public void validerArticle() {
      this.showModalpanelArticle = false;
   }

   public void initPrint() throws IOException {
      this.var_choix_modele = 0;
      this.listeDocImp();
      this.showModalPanelPrint = true;
   }

   public void initPrintCarte() throws IOException {
      this.var_choix_modele = 1;
      this.listeDocImp();
      this.showModalPanelPrint = true;
   }

   public void initPrintMvts() throws IOException {
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
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "produit" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
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
      } else {
         String var7;
         if (this.var_choix_modele == 1) {
            if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
               this.utilPrint.setSource("");
               this.utilPrint.setRecordPath("");
               this.utilPrint.setRapport(this.nomModeleListe);
               this.utilPrint.setEntete("Impression de la liste des produits");
               this.utilPrint.setRequete("");
               this.utilPrint.setFiltre("");
               this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "produit" + File.separator);
               this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setDestinataire(this.impDestinataire);
               this.utilPrint.setEmetteur(this.impEmetteur);
               this.utilPrint.setTiersSelectionne((Tiers)null);
               if (this.lesProduits.size() != 0) {
                  for(int var4 = 0; var4 < this.lesProduits.size(); ++var4) {
                     this.produits = (Produits)this.lesProduits.get(var4);
                     if (this.produits.getProPhoto() != null && !this.produits.getProPhoto().isEmpty()) {
                        var7 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator + this.produits.getProPhoto();
                        File var3 = new File(var7);
                        if (var3.exists()) {
                           this.produits.setPhoto(var7);
                        } else {
                           this.produits.setPhoto((String)null);
                        }
                     } else {
                        this.produits.setPhoto((String)null);
                     }
                  }
               }

               JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(this.lesProduits);
               this.utilPrint.setjRBeanCollectionDataSource(var5);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         } else if (this.var_choix_modele == 2 && this.nomModeleMvts != null && !this.nomModeleMvts.isEmpty()) {
            this.chargerMouvements();
            if (this.lesMvt.size() != 0) {
               this.utilPrint.setSource("");
               this.utilPrint.setRecordPath("");
               this.utilPrint.setRapport(this.nomModeleMvts);
               String var6 = this.utilDate.dateToStringFr(this.var_date_debut);
               var7 = this.utilDate.dateToStringFr(this.var_date_fin);
               this.utilPrint.setEntete("Mouvements produit du " + var6 + " au " + var7);
               this.utilPrint.setRequete("");
               this.utilPrint.setFiltre(this.produits.getProCode() + " " + this.produits.getProLibClient());
               this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "mouvement" + File.separator);
               this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setDestinataire(this.impDestinataire);
               this.utilPrint.setEmetteur(this.impEmetteur);
               this.utilPrint.setTiersSelectionne((Tiers)null);
               JRBeanCollectionDataSource var8 = new JRBeanCollectionDataSource(this.lesMvt);
               this.utilPrint.setjRBeanCollectionDataSource(var8);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
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
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setSource("");
      this.utilPrint.setRecordPath("");
      this.utilPrint.setRapport("PublicationsProduits");
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "ecommerce" + File.separator);
      this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
      this.utilPrint.setEntete("Liste des publications des produits");
      this.utilPrint.setFiltre("");
      this.utilPrint.setRequete("");
      this.utilPrint.setFormat(this.format);
      this.utilPrint.setTiersSelectionne((Tiers)null);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      this.utilPrint.imprimeRapport();
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
            this.nbDecGraph = Integer.parseInt(this.optionsVentes.getNbDecQte());
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
                     var4 = "Sans Dépot";
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
      } else {
         var4 = (long)(this.stock.getStk_qte_in() + this.stock.getStk_qte_out());
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

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public DataModel getDatamodelProduit() {
      return this.datamodelProduit;
   }

   public void setDatamodelProduit(DataModel var1) {
      this.datamodelProduit = var1;
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

   public boolean isExistCod() {
      return this.existCod;
   }

   public void setExistCod(boolean var1) {
      this.existCod = var1;
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

   public DataModel getDatamodelMotCle() {
      return this.datamodelMotCle;
   }

   public void setDatamodelMotCle(DataModel var1) {
      this.datamodelMotCle = var1;
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

   public String getVar_NatureFind() {
      return this.var_NatureFind;
   }

   public void setVar_NatureFind(String var1) {
      this.var_NatureFind = var1;
   }

   public String getVar_ServiceFind() {
      return this.var_ServiceFind;
   }

   public void setVar_ServiceFind(String var1) {
      this.var_ServiceFind = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
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

   public FamillesProduitsVentes getFamillesProduitsVentes() {
      return this.famillesProduitsVentes;
   }

   public void setFamillesProduitsVentes(FamillesProduitsVentes var1) {
      this.famillesProduitsVentes = var1;
   }

   public Produits getProduitsLies() {
      return this.produitsLies;
   }

   public void setProduitsLies(Produits var1) {
      this.produitsLies = var1;
   }

   public ExercicesVentes getLastExoVentes() {
      return this.lastExoVentes;
   }

   public void setLastExoVentes(ExercicesVentes var1) {
      this.lastExoVentes = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public boolean isAfficheFormule() {
      return this.afficheFormule;
   }

   public void setAfficheFormule(boolean var1) {
      this.afficheFormule = var1;
   }

   public List getLesFamillesclients() {
      return this.lesFamillesclients;
   }

   public void setLesFamillesclients(List var1) {
      this.lesFamillesclients = var1;
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

   public ExercicesComptable getLastExoCompta() {
      return this.lastExoCompta;
   }

   public void setLastExoCompta(ExercicesComptable var1) {
      this.lastExoCompta = var1;
   }

   public ExercicesAchats getLastExoAchats() {
      return this.lastExoAchats;
   }

   public void setLastExoAchats(ExercicesAchats var1) {
      this.lastExoAchats = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public boolean isAffichagePump() {
      return this.affichagePump;
   }

   public void setAffichagePump(boolean var1) {
      this.affichagePump = var1;
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

   public boolean isLibelle_libre() {
      return this.libelle_libre;
   }

   public void setLibelle_libre(boolean var1) {
      this.libelle_libre = var1;
   }

   public boolean isShowModalTarifSt() {
      return this.showModalTarifSt;
   }

   public void setShowModalTarifSt(boolean var1) {
      this.showModalTarifSt = var1;
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

   public String getVar_tarif1() {
      return this.var_tarif1;
   }

   public void setVar_tarif1(String var1) {
      this.var_tarif1 = var1;
   }

   public String getVar_tarif2() {
      return this.var_tarif2;
   }

   public void setVar_tarif2(String var1) {
      this.var_tarif2 = var1;
   }

   public String getVar_tarif3() {
      return this.var_tarif3;
   }

   public void setVar_tarif3(String var1) {
      this.var_tarif3 = var1;
   }

   public String getVar_tarif4() {
      return this.var_tarif4;
   }

   public void setVar_tarif4(String var1) {
      this.var_tarif4 = var1;
   }

   public String getVar_tarif5() {
      return this.var_tarif5;
   }

   public void setVar_tarif5(String var1) {
      this.var_tarif5 = var1;
   }

   public boolean isVar_aff_tarif1() {
      return this.var_aff_tarif1;
   }

   public void setVar_aff_tarif1(boolean var1) {
      this.var_aff_tarif1 = var1;
   }

   public boolean isVar_aff_tarif2() {
      return this.var_aff_tarif2;
   }

   public void setVar_aff_tarif2(boolean var1) {
      this.var_aff_tarif2 = var1;
   }

   public boolean isVar_aff_tarif3() {
      return this.var_aff_tarif3;
   }

   public void setVar_aff_tarif3(boolean var1) {
      this.var_aff_tarif3 = var1;
   }

   public boolean isVar_aff_tarif4() {
      return this.var_aff_tarif4;
   }

   public void setVar_aff_tarif4(boolean var1) {
      this.var_aff_tarif4 = var1;
   }

   public boolean isVar_aff_tarif5() {
      return this.var_aff_tarif5;
   }

   public void setVar_aff_tarif5(boolean var1) {
      this.var_aff_tarif5 = var1;
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

   public boolean isVar_aff_tarif10() {
      return this.var_aff_tarif10;
   }

   public void setVar_aff_tarif10(boolean var1) {
      this.var_aff_tarif10 = var1;
   }

   public boolean isVar_aff_tarif6() {
      return this.var_aff_tarif6;
   }

   public void setVar_aff_tarif6(boolean var1) {
      this.var_aff_tarif6 = var1;
   }

   public boolean isVar_aff_tarif7() {
      return this.var_aff_tarif7;
   }

   public void setVar_aff_tarif7(boolean var1) {
      this.var_aff_tarif7 = var1;
   }

   public boolean isVar_aff_tarif8() {
      return this.var_aff_tarif8;
   }

   public void setVar_aff_tarif8(boolean var1) {
      this.var_aff_tarif8 = var1;
   }

   public boolean isVar_aff_tarif9() {
      return this.var_aff_tarif9;
   }

   public void setVar_aff_tarif9(boolean var1) {
      this.var_aff_tarif9 = var1;
   }

   public String getVar_tarif10() {
      return this.var_tarif10;
   }

   public void setVar_tarif10(String var1) {
      this.var_tarif10 = var1;
   }

   public String getVar_tarif6() {
      return this.var_tarif6;
   }

   public void setVar_tarif6(String var1) {
      this.var_tarif6 = var1;
   }

   public String getVar_tarif7() {
      return this.var_tarif7;
   }

   public void setVar_tarif7(String var1) {
      this.var_tarif7 = var1;
   }

   public String getVar_tarif8() {
      return this.var_tarif8;
   }

   public void setVar_tarif8(String var1) {
      this.var_tarif8 = var1;
   }

   public String getVar_tarif9() {
      return this.var_tarif9;
   }

   public void setVar_tarif9(String var1) {
      this.var_tarif9 = var1;
   }

   public String getVar_tarif10Marche() {
      return this.var_tarif10Marche;
   }

   public void setVar_tarif10Marche(String var1) {
      this.var_tarif10Marche = var1;
   }

   public String getVar_tarif1Marche() {
      return this.var_tarif1Marche;
   }

   public void setVar_tarif1Marche(String var1) {
      this.var_tarif1Marche = var1;
   }

   public String getVar_tarif2Marche() {
      return this.var_tarif2Marche;
   }

   public void setVar_tarif2Marche(String var1) {
      this.var_tarif2Marche = var1;
   }

   public String getVar_tarif3Marche() {
      return this.var_tarif3Marche;
   }

   public void setVar_tarif3Marche(String var1) {
      this.var_tarif3Marche = var1;
   }

   public String getVar_tarif4Marche() {
      return this.var_tarif4Marche;
   }

   public void setVar_tarif4Marche(String var1) {
      this.var_tarif4Marche = var1;
   }

   public String getVar_tarif5Marche() {
      return this.var_tarif5Marche;
   }

   public void setVar_tarif5Marche(String var1) {
      this.var_tarif5Marche = var1;
   }

   public String getVar_tarif6Marche() {
      return this.var_tarif6Marche;
   }

   public void setVar_tarif6Marche(String var1) {
      this.var_tarif6Marche = var1;
   }

   public String getVar_tarif7Marche() {
      return this.var_tarif7Marche;
   }

   public void setVar_tarif7Marche(String var1) {
      this.var_tarif7Marche = var1;
   }

   public String getVar_tarif8Marche() {
      return this.var_tarif8Marche;
   }

   public void setVar_tarif8Marche(String var1) {
      this.var_tarif8Marche = var1;
   }

   public String getVar_tarif9Marche() {
      return this.var_tarif9Marche;
   }

   public void setVar_tarif9Marche(String var1) {
      this.var_tarif9Marche = var1;
   }

   public double getVar_p10CC1() {
      return this.var_p10CC1;
   }

   public void setVar_p10CC1(double var1) {
      this.var_p10CC1 = var1;
   }

   public double getVar_p10CC2() {
      return this.var_p10CC2;
   }

   public void setVar_p10CC2(double var1) {
      this.var_p10CC2 = var1;
   }

   public double getVar_p10CC3() {
      return this.var_p10CC3;
   }

   public void setVar_p10CC3(double var1) {
      this.var_p10CC3 = var1;
   }

   public double getVar_p1CC1() {
      return this.var_p1CC1;
   }

   public void setVar_p1CC1(double var1) {
      this.var_p1CC1 = var1;
   }

   public double getVar_p1CC2() {
      return this.var_p1CC2;
   }

   public void setVar_p1CC2(double var1) {
      this.var_p1CC2 = var1;
   }

   public double getVar_p1CC3() {
      return this.var_p1CC3;
   }

   public void setVar_p1CC3(double var1) {
      this.var_p1CC3 = var1;
   }

   public double getVar_p2CC1() {
      return this.var_p2CC1;
   }

   public void setVar_p2CC1(double var1) {
      this.var_p2CC1 = var1;
   }

   public double getVar_p2CC2() {
      return this.var_p2CC2;
   }

   public void setVar_p2CC2(double var1) {
      this.var_p2CC2 = var1;
   }

   public double getVar_p2CC3() {
      return this.var_p2CC3;
   }

   public void setVar_p2CC3(double var1) {
      this.var_p2CC3 = var1;
   }

   public double getVar_p3CC1() {
      return this.var_p3CC1;
   }

   public void setVar_p3CC1(double var1) {
      this.var_p3CC1 = var1;
   }

   public double getVar_p3CC2() {
      return this.var_p3CC2;
   }

   public void setVar_p3CC2(double var1) {
      this.var_p3CC2 = var1;
   }

   public double getVar_p3CC3() {
      return this.var_p3CC3;
   }

   public void setVar_p3CC3(double var1) {
      this.var_p3CC3 = var1;
   }

   public double getVar_p4CC1() {
      return this.var_p4CC1;
   }

   public void setVar_p4CC1(double var1) {
      this.var_p4CC1 = var1;
   }

   public double getVar_p4CC2() {
      return this.var_p4CC2;
   }

   public void setVar_p4CC2(double var1) {
      this.var_p4CC2 = var1;
   }

   public double getVar_p4CC3() {
      return this.var_p4CC3;
   }

   public void setVar_p4CC3(double var1) {
      this.var_p4CC3 = var1;
   }

   public double getVar_p5CC1() {
      return this.var_p5CC1;
   }

   public void setVar_p5CC1(double var1) {
      this.var_p5CC1 = var1;
   }

   public double getVar_p5CC2() {
      return this.var_p5CC2;
   }

   public void setVar_p5CC2(double var1) {
      this.var_p5CC2 = var1;
   }

   public double getVar_p5CC3() {
      return this.var_p5CC3;
   }

   public void setVar_p5CC3(double var1) {
      this.var_p5CC3 = var1;
   }

   public double getVar_p6CC1() {
      return this.var_p6CC1;
   }

   public void setVar_p6CC1(double var1) {
      this.var_p6CC1 = var1;
   }

   public double getVar_p6CC2() {
      return this.var_p6CC2;
   }

   public void setVar_p6CC2(double var1) {
      this.var_p6CC2 = var1;
   }

   public double getVar_p6CC3() {
      return this.var_p6CC3;
   }

   public void setVar_p6CC3(double var1) {
      this.var_p6CC3 = var1;
   }

   public double getVar_p7CC1() {
      return this.var_p7CC1;
   }

   public void setVar_p7CC1(double var1) {
      this.var_p7CC1 = var1;
   }

   public double getVar_p7CC2() {
      return this.var_p7CC2;
   }

   public void setVar_p7CC2(double var1) {
      this.var_p7CC2 = var1;
   }

   public double getVar_p7CC3() {
      return this.var_p7CC3;
   }

   public void setVar_p7CC3(double var1) {
      this.var_p7CC3 = var1;
   }

   public double getVar_p8CC1() {
      return this.var_p8CC1;
   }

   public void setVar_p8CC1(double var1) {
      this.var_p8CC1 = var1;
   }

   public double getVar_p8CC2() {
      return this.var_p8CC2;
   }

   public void setVar_p8CC2(double var1) {
      this.var_p8CC2 = var1;
   }

   public double getVar_p8CC3() {
      return this.var_p8CC3;
   }

   public void setVar_p8CC3(double var1) {
      this.var_p8CC3 = var1;
   }

   public double getVar_p9CC1() {
      return this.var_p9CC1;
   }

   public void setVar_p9CC1(double var1) {
      this.var_p9CC1 = var1;
   }

   public double getVar_p9CC2() {
      return this.var_p9CC2;
   }

   public void setVar_p9CC2(double var1) {
      this.var_p9CC2 = var1;
   }

   public double getVar_p9CC3() {
      return this.var_p9CC3;
   }

   public void setVar_p9CC3(double var1) {
      this.var_p9CC3 = var1;
   }

   public boolean isVar_mvt_as_ticket() {
      return this.var_mvt_as_ticket;
   }

   public void setVar_mvt_as_ticket(boolean var1) {
      this.var_mvt_as_ticket = var1;
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

   public DataModel getDataModelTarifDegressif() {
      return this.dataModelTarifDegressif;
   }

   public void setDataModelTarifDegressif(DataModel var1) {
      this.dataModelTarifDegressif = var1;
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

   public boolean isShowModalPanelTarifDegressif() {
      return this.showModalPanelTarifDegressif;
   }

   public void setShowModalPanelTarifDegressif(boolean var1) {
      this.showModalPanelTarifDegressif = var1;
   }

   public String getVar_n10CC1() {
      return this.var_n10CC1;
   }

   public void setVar_n10CC1(String var1) {
      this.var_n10CC1 = var1;
   }

   public String getVar_n10CC2() {
      return this.var_n10CC2;
   }

   public void setVar_n10CC2(String var1) {
      this.var_n10CC2 = var1;
   }

   public String getVar_n10CC3() {
      return this.var_n10CC3;
   }

   public void setVar_n10CC3(String var1) {
      this.var_n10CC3 = var1;
   }

   public String getVar_n1CC1() {
      return this.var_n1CC1;
   }

   public void setVar_n1CC1(String var1) {
      this.var_n1CC1 = var1;
   }

   public String getVar_n1CC2() {
      return this.var_n1CC2;
   }

   public void setVar_n1CC2(String var1) {
      this.var_n1CC2 = var1;
   }

   public String getVar_n1CC3() {
      return this.var_n1CC3;
   }

   public void setVar_n1CC3(String var1) {
      this.var_n1CC3 = var1;
   }

   public String getVar_n2CC1() {
      return this.var_n2CC1;
   }

   public void setVar_n2CC1(String var1) {
      this.var_n2CC1 = var1;
   }

   public String getVar_n2CC2() {
      return this.var_n2CC2;
   }

   public void setVar_n2CC2(String var1) {
      this.var_n2CC2 = var1;
   }

   public String getVar_n2CC3() {
      return this.var_n2CC3;
   }

   public void setVar_n2CC3(String var1) {
      this.var_n2CC3 = var1;
   }

   public String getVar_n3CC1() {
      return this.var_n3CC1;
   }

   public void setVar_n3CC1(String var1) {
      this.var_n3CC1 = var1;
   }

   public String getVar_n3CC2() {
      return this.var_n3CC2;
   }

   public void setVar_n3CC2(String var1) {
      this.var_n3CC2 = var1;
   }

   public String getVar_n3CC3() {
      return this.var_n3CC3;
   }

   public void setVar_n3CC3(String var1) {
      this.var_n3CC3 = var1;
   }

   public String getVar_n4CC1() {
      return this.var_n4CC1;
   }

   public void setVar_n4CC1(String var1) {
      this.var_n4CC1 = var1;
   }

   public String getVar_n4CC2() {
      return this.var_n4CC2;
   }

   public void setVar_n4CC2(String var1) {
      this.var_n4CC2 = var1;
   }

   public String getVar_n4CC3() {
      return this.var_n4CC3;
   }

   public void setVar_n4CC3(String var1) {
      this.var_n4CC3 = var1;
   }

   public String getVar_n5CC1() {
      return this.var_n5CC1;
   }

   public void setVar_n5CC1(String var1) {
      this.var_n5CC1 = var1;
   }

   public String getVar_n5CC2() {
      return this.var_n5CC2;
   }

   public void setVar_n5CC2(String var1) {
      this.var_n5CC2 = var1;
   }

   public String getVar_n5CC3() {
      return this.var_n5CC3;
   }

   public void setVar_n5CC3(String var1) {
      this.var_n5CC3 = var1;
   }

   public String getVar_n6CC1() {
      return this.var_n6CC1;
   }

   public void setVar_n6CC1(String var1) {
      this.var_n6CC1 = var1;
   }

   public String getVar_n6CC2() {
      return this.var_n6CC2;
   }

   public void setVar_n6CC2(String var1) {
      this.var_n6CC2 = var1;
   }

   public String getVar_n6CC3() {
      return this.var_n6CC3;
   }

   public void setVar_n6CC3(String var1) {
      this.var_n6CC3 = var1;
   }

   public String getVar_n7CC1() {
      return this.var_n7CC1;
   }

   public void setVar_n7CC1(String var1) {
      this.var_n7CC1 = var1;
   }

   public String getVar_n7CC2() {
      return this.var_n7CC2;
   }

   public void setVar_n7CC2(String var1) {
      this.var_n7CC2 = var1;
   }

   public String getVar_n7CC3() {
      return this.var_n7CC3;
   }

   public void setVar_n7CC3(String var1) {
      this.var_n7CC3 = var1;
   }

   public String getVar_n8CC1() {
      return this.var_n8CC1;
   }

   public void setVar_n8CC1(String var1) {
      this.var_n8CC1 = var1;
   }

   public String getVar_n8CC2() {
      return this.var_n8CC2;
   }

   public void setVar_n8CC2(String var1) {
      this.var_n8CC2 = var1;
   }

   public String getVar_n8CC3() {
      return this.var_n8CC3;
   }

   public void setVar_n8CC3(String var1) {
      this.var_n8CC3 = var1;
   }

   public String getVar_n9CC1() {
      return this.var_n9CC1;
   }

   public void setVar_n9CC1(String var1) {
      this.var_n9CC1 = var1;
   }

   public String getVar_n9CC2() {
      return this.var_n9CC2;
   }

   public void setVar_n9CC2(String var1) {
      this.var_n9CC2 = var1;
   }

   public String getVar_n9CC3() {
      return this.var_n9CC3;
   }

   public void setVar_n9CC3(String var1) {
      this.var_n9CC3 = var1;
   }

   public Date getVar_d10CC1() {
      return this.var_d10CC1;
   }

   public void setVar_d10CC1(Date var1) {
      this.var_d10CC1 = var1;
   }

   public Date getVar_d10CC2() {
      return this.var_d10CC2;
   }

   public void setVar_d10CC2(Date var1) {
      this.var_d10CC2 = var1;
   }

   public Date getVar_d10CC3() {
      return this.var_d10CC3;
   }

   public void setVar_d10CC3(Date var1) {
      this.var_d10CC3 = var1;
   }

   public Date getVar_d1CC1() {
      return this.var_d1CC1;
   }

   public void setVar_d1CC1(Date var1) {
      this.var_d1CC1 = var1;
   }

   public Date getVar_d1CC2() {
      return this.var_d1CC2;
   }

   public void setVar_d1CC2(Date var1) {
      this.var_d1CC2 = var1;
   }

   public Date getVar_d1CC3() {
      return this.var_d1CC3;
   }

   public void setVar_d1CC3(Date var1) {
      this.var_d1CC3 = var1;
   }

   public Date getVar_d2CC2() {
      return this.var_d2CC2;
   }

   public void setVar_d2CC2(Date var1) {
      this.var_d2CC2 = var1;
   }

   public Date getVar_d2CC3() {
      return this.var_d2CC3;
   }

   public void setVar_d2CC3(Date var1) {
      this.var_d2CC3 = var1;
   }

   public Date getVar_d3CC1() {
      return this.var_d3CC1;
   }

   public void setVar_d3CC1(Date var1) {
      this.var_d3CC1 = var1;
   }

   public Date getVar_d3CC2() {
      return this.var_d3CC2;
   }

   public void setVar_d3CC2(Date var1) {
      this.var_d3CC2 = var1;
   }

   public Date getVar_d4CC1() {
      return this.var_d4CC1;
   }

   public void setVar_d4CC1(Date var1) {
      this.var_d4CC1 = var1;
   }

   public Date getVar_d4CC2() {
      return this.var_d4CC2;
   }

   public void setVar_d4CC2(Date var1) {
      this.var_d4CC2 = var1;
   }

   public Date getVar_d4CC3() {
      return this.var_d4CC3;
   }

   public void setVar_d4CC3(Date var1) {
      this.var_d4CC3 = var1;
   }

   public Date getVar_d5CC1() {
      return this.var_d5CC1;
   }

   public void setVar_d5CC1(Date var1) {
      this.var_d5CC1 = var1;
   }

   public Date getVar_d5CC2() {
      return this.var_d5CC2;
   }

   public void setVar_d5CC2(Date var1) {
      this.var_d5CC2 = var1;
   }

   public Date getVar_d5CC3() {
      return this.var_d5CC3;
   }

   public void setVar_d5CC3(Date var1) {
      this.var_d5CC3 = var1;
   }

   public Date getVar_d6CC2() {
      return this.var_d6CC2;
   }

   public void setVar_d6CC2(Date var1) {
      this.var_d6CC2 = var1;
   }

   public Date getVar_d6CC3() {
      return this.var_d6CC3;
   }

   public void setVar_d6CC3(Date var1) {
      this.var_d6CC3 = var1;
   }

   public Date getVar_d7CC1() {
      return this.var_d7CC1;
   }

   public void setVar_d7CC1(Date var1) {
      this.var_d7CC1 = var1;
   }

   public Date getVar_d7CC2() {
      return this.var_d7CC2;
   }

   public void setVar_d7CC2(Date var1) {
      this.var_d7CC2 = var1;
   }

   public Date getVar_d7CC3() {
      return this.var_d7CC3;
   }

   public void setVar_d7CC3(Date var1) {
      this.var_d7CC3 = var1;
   }

   public Date getVar_d8CC1() {
      return this.var_d8CC1;
   }

   public void setVar_d8CC1(Date var1) {
      this.var_d8CC1 = var1;
   }

   public Date getVar_d8CC2() {
      return this.var_d8CC2;
   }

   public void setVar_d8CC2(Date var1) {
      this.var_d8CC2 = var1;
   }

   public Date getVar_d8CC3() {
      return this.var_d8CC3;
   }

   public void setVar_d8CC3(Date var1) {
      this.var_d8CC3 = var1;
   }

   public Date getVar_d9CC1() {
      return this.var_d9CC1;
   }

   public void setVar_d9CC1(Date var1) {
      this.var_d9CC1 = var1;
   }

   public Date getVar_d9CC2() {
      return this.var_d9CC2;
   }

   public void setVar_d9CC2(Date var1) {
      this.var_d9CC2 = var1;
   }

   public Date getVar_d9CC3() {
      return this.var_d9CC3;
   }

   public void setVar_d9CC3(Date var1) {
      this.var_d9CC3 = var1;
   }

   public Date getVar_d2CC1() {
      return this.var_d2CC1;
   }

   public void setVar_d2CC1(Date var1) {
      this.var_d2CC1 = var1;
   }

   public Date getVar_d3CC3() {
      return this.var_d3CC3;
   }

   public void setVar_d3CC3(Date var1) {
      this.var_d3CC3 = var1;
   }

   public Date getVar_d6CC1() {
      return this.var_d6CC1;
   }

   public void setVar_d6CC1(Date var1) {
      this.var_d6CC1 = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public boolean isAfficheSousFamille() {
      return this.afficheSousFamille;
   }

   public void setAfficheSousFamille(boolean var1) {
      this.afficheSousFamille = var1;
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

   public List getMesProduitsDepotsItems() {
      return this.mesProduitsDepotsItems;
   }

   public void setMesProduitsDepotsItems(List var1) {
      this.mesProduitsDepotsItems = var1;
   }

   public String getVar_DepotFin() {
      return this.var_DepotFin;
   }

   public void setVar_DepotFin(String var1) {
      this.var_DepotFin = var1;
   }

   public DataModel getDataModelFamille() {
      return this.dataModelFamille;
   }

   public void setDataModelFamille(DataModel var1) {
      this.dataModelFamille = var1;
   }

   public boolean isShowModalpanelArticle() {
      return this.showModalpanelArticle;
   }

   public void setShowModalpanelArticle(boolean var1) {
      this.showModalpanelArticle = var1;
   }

   public boolean isShowModalpanelCarte() {
      return this.showModalpanelCarte;
   }

   public void setShowModalpanelCarte(boolean var1) {
      this.showModalpanelCarte = var1;
   }

   public boolean isAfficheButtArticle() {
      return this.afficheButtArticle;
   }

   public void setAfficheButtArticle(boolean var1) {
      this.afficheButtArticle = var1;
   }

   public boolean isAfficheButtCarte() {
      return this.afficheButtCarte;
   }

   public void setAfficheButtCarte(boolean var1) {
      this.afficheButtCarte = var1;
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

   public DataModel getDataModelTarifPromotion() {
      return this.dataModelTarifPromotion;
   }

   public void setDataModelTarifPromotion(DataModel var1) {
      this.dataModelTarifPromotion = var1;
   }

   public boolean isShowModalPanelTarifPromotion() {
      return this.showModalPanelTarifPromotion;
   }

   public void setShowModalPanelTarifPromotion(boolean var1) {
      this.showModalPanelTarifPromotion = var1;
   }

   public boolean isVisibiliteBtonTarifPromotion() {
      return this.visibiliteBtonTarifPromotion;
   }

   public void setVisibiliteBtonTarifPromotion(boolean var1) {
      this.visibiliteBtonTarifPromotion = var1;
   }

   public Baremes getBaremes() {
      return this.baremes;
   }

   public void setBaremes(Baremes var1) {
      this.baremes = var1;
   }

   public int getVar_PromoFind() {
      return this.var_PromoFind;
   }

   public void setVar_PromoFind(int var1) {
      this.var_PromoFind = var1;
   }

   public String getVar_RefFind() {
      return this.var_RefFind;
   }

   public void setVar_RefFind(String var1) {
      this.var_RefFind = var1;
   }
}
