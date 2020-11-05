package com.epegase.forms.medical;

import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.ConventionMedical;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.LettreMedical;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsActe;
import com.epegase.systeme.classe.ProduitsDci;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsDetail;
import com.epegase.systeme.classe.ProduitsFourchette;
import com.epegase.systeme.classe.ProduitsGrp;
import com.epegase.systeme.classe.ProduitsLaboratoire;
import com.epegase.systeme.classe.ProduitsMcles;
import com.epegase.systeme.classe.ProduitsPharmacie;
import com.epegase.systeme.classe.ProduitsReponse;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConventionMedicalDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.LettreMedicalDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.ProduitsActeDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsDetailDao;
import com.epegase.systeme.dao.ProduitsFourchetteDao;
import com.epegase.systeme.dao.ProduitsGrpDao;
import com.epegase.systeme.dao.ProduitsLaboratoireDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsMedicammentDao;
import com.epegase.systeme.dao.ProduitsPharmacieDao;
import com.epegase.systeme.dao.ProduitsReponseDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesVentesDao;
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
import com.epegase.systeme.xml.LectureCategorieExamen;
import com.epegase.systeme.xml.ObjetCategories;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionMedical;
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

public class FormProduitsMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private List mesOnglets;
   private String urlphotoProd;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastexoMed;
   private ExercicesComptable lastexoCompta;
   private OptionMedical optionsMedical = new OptionMedical();
   private Produits produits;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private int var_nb_max = 100;
   private String pageIndex;
   private String var_FamilleFind;
   private String var_SousFamilleFind;
   private String var_ServiceFind;
   private String var_ActiviteFind;
   private String var_NatureFind;
   private String var_MarqueFind;
   private String var_CodFind;
   private String var_LibFind;
   private String var_TypeFind;
   private String inpNatureVnt = "";
   private String inpFamilleVnt = "";
   private String inpDepot = "";
   private String inpActivite;
   private List lesProduits = new ArrayList();
   private transient DataModel datamodelProduit = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean afficheButtSup = false;
   private boolean afficheButtOption = false;
   private boolean afficheButtPanier = false;
   private int var_action = 0;
   private UtilDate utilDate = new UtilDate();
   private boolean verouxCod;
   private boolean existCod = false;
   private int lgNumProd;
   private ServiceDao serviceDao;
   private ActivitesDao activitesDao;
   private boolean afficheFormule = false;
   private boolean existGrp = false;
   private boolean existGrpCode = false;
   private int inpTypTar;
   private boolean inpInactifProdTarif;
   private int desactiveModifprodTar;
   private boolean afficheButtModifProdTar = false;
   private boolean afficheButtSuppProdServ = false;
   private ProduitsTarifDao produitsTarifDao;
   private ProduitsTarif produitsTarif;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsServices produitsServices;
   private String prodCodeLibService;
   private boolean testCodLibService = false;
   private ProduitsMcles produitsMcles;
   private List lesProduitsTarif = new ArrayList();
   private List lesProduitsMcles = new ArrayList();
   private ProduitsMclesDao produitsMclesDao;
   private transient DataModel datamodelTarif = new ListDataModel();
   private transient DataModel datamodelCode = new ListDataModel();
   private transient DataModel datamodelGrp = new ListDataModel();
   private List lesProduitsGrps = new ArrayList();
   private List lesProduitsCode = new ArrayList();
   private ProduitsGrpDao produitsGrpDao;
   private boolean existPdfFile;
   private FamillesProduitsVentesDao famillesProduitsMedicalDao;
   private FamillesProduitsVentes famillesProduitsMedical = new FamillesProduitsVentes();
   private String disable;
   private String messageBut = "";
   private String description;
   private ProduitsVtesDao produitsMedicDao;
   private String fileName;
   private String pdfFileName;
   private UploadedFile uploadedFile;
   private UploadedFile uploadedPDFFile;
   private List mesPecClientsItems;
   private List lesPecclients;
   private List mesFamillesMedicalItems;
   private TaxesVentesDao taxesMedicalDao;
   private PlanComptableDao planComptableDao;
   private List lesProduitsServicesFind;
   private boolean libelle_libre = false;
   private List lesProduitsServices = new ArrayList();
   private boolean afficheProgress = false;
   private int var_inactif = 0;
   private List mesSousFamillesItems = new ArrayList();
   private List mesCategoriesExamensItems = new ArrayList();
   private boolean afficheSousFamille = false;
   private Unite unite;
   private UniteDao uniteDao;
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
   private int formatdevise;
   private String tarifOrdClt;
   private boolean testDoubleProduitsTarif = false;
   private String htTtc;
   private boolean lettreUtil = false;
   private List mesLettresItems;
   private String choixLettre;
   private double valeurLettre;
   private double valeurLettreCnamgs;
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
   private transient DataModel datamodelTarifConvention = new ListDataModel();
   private List lesConventions = new ArrayList();
   private ConventionMedicalDao conventionMedicalDao;
   private ConventionMedical conventionMedical;
   private boolean afficheButtModifProdTarConvention = false;
   private boolean showModalPanelTarifconvention = false;
   private List mesTiersClientsItems = new ArrayList();
   private long idTierConvention;
   private TiersDao tiersDao;
   private Tiers tiers;
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
   private List mesDepotItems;
   private boolean var_mvt_as_inventaire = false;
   private boolean var_mvt_as_bin = false;
   private boolean var_mvt_as_bout = false;
   private boolean var_mvt_as_cession = false;
   private boolean var_mvt_as_fabrication = false;
   private boolean var_mvt_ss_fcotation = false;
   private boolean var_mvt_ss_fcommande = false;
   private boolean var_mvt_as_freception = false;
   private boolean var_mvt_as_fsav = false;
   private boolean var_mvt_ss_ffacture = false;
   private boolean var_mvt_ss_favoir = false;
   private boolean var_mvt_ss_cdevis = false;
   private boolean var_mvt_ss_ccmd = false;
   private boolean var_mvt_as_cbl = false;
   private boolean var_mvt_as_ticket = false;
   private boolean var_mvt_as_cretour = false;
   private boolean var_mvt_ss_cfacture = false;
   private boolean var_mvt_ss_cavoir = false;
   private boolean var_mvt_ss_pump = false;
   private boolean var_mvt_as_production = false;
   private String var_lib_etat = "Etat";
   private String var_lib_qteIn = "Qte In";
   private String var_lib_qteOut = "Qte Out";
   private String var_lib_pv = "P.V.";
   private DepotAchatsDao depotAchatsDao;
   private ConsultationActesDao consultationActesDao;
   private List recConsultationMed;
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
   private boolean var_affFicPdf;
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
   private transient DataModel datamodelProService = new ListDataModel();
   private String service1Facture;
   private String service2Facture;
   private String service3Facture;
   private String service4Facture;
   private String service5Facture;
   private List lesProduitsLiesRecherche;
   private transient DataModel datamodelProduitsLieRecherche = new ListDataModel();
   private Produits produitsLies;
   private boolean showModalProduitRecherche = false;
   private ProduitsPharmacie produitsPharmacie;
   private ProduitsPharmacieDao produitsPharmacieDao;
   private ProduitsActe produitsActe;
   private ProduitsActeDao produitsActeDao;
   private ProduitsLaboratoire produitsLaboratoire;
   private ProduitsLaboratoireDao produitsLaboratoireDao;
   private ProduitsFourchette produitsFourchette;
   private ProduitsFourchetteDao produitsFourchetteDao;
   private transient DataModel datamodelFourchette = new ListDataModel();
   private List lesProduitsFourchettes = new ArrayList();
   private boolean afficheButtFourchette = false;
   private ProduitsReponse produitsReponse;
   private ProduitsReponseDao produitsReponseDao;
   private transient DataModel datamodelReponse = new ListDataModel();
   private List lesProduitsreponse = new ArrayList();
   private boolean afficheButtReponse = false;
   private ProduitsDetail produitsDetail;
   private ProduitsDetailDao produitsDetailDao;
   private transient DataModel datamodelDetail = new ListDataModel();
   private List lesProduitsDetail = new ArrayList();
   private boolean afficheButtDetail = false;
   private boolean showModalPanelDetail = false;
   private transient DataModel datamodelFourchetteDetail = new ListDataModel();
   private List lesProduitsFourchettesDetail = new ArrayList();
   private boolean afficheButtFourchetteDetail = false;
   private boolean showModalPanelFourchetteDetail = false;
   private transient DataModel datamodelReponseDetail = new ListDataModel();
   private List lesProduitsreponseDetail = new ArrayList();
   private boolean afficheButtReponseDetail = false;
   private boolean showModalPanelReponseDetail = false;
   private boolean showModalPanelReponseExamenChaine = false;
   private UtilDownload utilDownload = new UtilDownload();
   private UtilNombre utilNombre = new UtilNombre();
   private boolean showModalPanelTarif = false;
   private boolean showModalPanelMotcles = false;
   private boolean showModalPanelService = false;
   private boolean showModalPanelListeProduit = false;
   private boolean showModalPanelFourchette = false;
   private LettreMedical lettreMedical = new LettreMedical();
   private LettreMedicalDao lettreMedicalDao;
   private String ancienCode;
   private String nouveauCode;
   private boolean valideChange;
   private String ancienneFamilleAchat;
   private String nouvelleFamilleAchat;
   private String ancienneFamilleVente;
   private String nouvelleFamilleVente;
   private int fusionAjout;
   private List mesExamnensChainesItems = new ArrayList();
   private String urlphotoInterpretation1;
   private String urlphotoInterpretation2;
   private int choixRacine;
   private String selecFiscalite;
   private boolean gestionProduits = true;
   private long var_memo_id_master;

   public void instanceDaoUtilises() {
      this.produitsMedicDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.conventionMedicalDao = new ConventionMedicalDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.produitsGrpDao = new ProduitsGrpDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.depotAchatsDao = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsMedicalDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.lettreMedicalDao = new LettreMedicalDao(this.baseLog, this.utilInitHibernate);
      this.produitsReponseDao = new ProduitsReponseDao(this.baseLog, this.utilInitHibernate);
      this.produitsFourchetteDao = new ProduitsFourchetteDao(this.baseLog, this.utilInitHibernate);
      this.produitsLaboratoireDao = new ProduitsLaboratoireDao(this.baseLog, this.utilInitHibernate);
      this.produitsDetailDao = new ProduitsDetailDao(this.baseLog, this.utilInitHibernate);
      this.produitsActeDao = new ProduitsActeDao(this.baseLog, this.utilInitHibernate);
      this.produitsPharmacieDao = new ProduitsPharmacieDao(this.baseLog, this.utilInitHibernate);
      this.taxesMedicalDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererOptions(Session var1) throws NamingException {
      this.setHtTtc(" (HT)");
      this.lgNumProd = Integer.parseInt(this.optionsMedical.getNbrCtrsProOP());
      this.produits = null;
      if (this.optionsMedical.getNbLigneMax() != null && !this.optionsMedical.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionsMedical.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.recupererFamilleProduitVentesItem(var1);
      this.recupererDepotItem(var1);
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
            } else if (var1.getCode().equals("4")) {
               this.var_acc_stock = true;
            } else if (var1.getCode().equals("5")) {
               this.var_acc_tarification = true;
            } else if (var1.getCode().equals("6")) {
               this.var_acc_option_vte = true;
            } else if (var1.getCode().equals("7")) {
               this.var_acc_motcle = true;
            } else if (var1.getCode().equals("8")) {
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
            }
         }
      }

   }

   public void autorisationCaracteristique() {
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

   public void autorisationStock() {
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
            if (var1.getCode().equals("5")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
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
            if (var1.getCode().equals("6")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
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
            if (var1.getCode().equals("7")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
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
            if (var1.getCode().equals("8")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void calculeSousFamille() throws HibernateException, NamingException {
      this.mesSousFamillesItems = new ArrayList();
      this.var_SousFamilleFind = "";
      this.afficheSousFamille = false;
      String var1 = "";
      if (this.var_FamilleFind != null && !this.var_FamilleFind.isEmpty()) {
         if (this.var_FamilleFind.contains(":")) {
            String[] var2 = this.var_FamilleFind.split(":");
            var1 = var2[0];
         } else {
            var1 = this.var_FamilleFind;
         }
      }

      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsMedical");
      this.famillesProduitsMedical = this.famillesProduitsMedicalDao.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), var1, var3);
      if (this.famillesProduitsMedical != null && this.famillesProduitsMedical.getFamvteCat() == 99) {
         this.mesSousFamillesItems = this.famillesProduitsMedicalDao.chargerFamilleProduitVentesSousFamItems(this.exercicesVentes.getExevteId(), var1, var3);
         if (this.mesSousFamillesItems.size() != 0) {
            this.afficheSousFamille = true;
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void rechercherProduit() throws JDOMException, IOException, HibernateException, NamingException {
      this.afficheButtOption = false;
      this.afficheButtSup = false;
      this.lesProduits = new ArrayList();
      String var1 = this.var_CodFind;
      String var2 = this.var_LibFind;
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

      this.listerProduit(var1, var2, var3, var7, var8);
      this.datamodelProduit.setWrappedData(this.lesProduits);
   }

   public void listerProduit(String var1, String var2, String var3, String var4, String var5) throws JDOMException, IOException, HibernateException, NamingException {
      this.lesProduits = new ArrayList();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      String var7 = "";
      if (this.var_FamilleFind != null && !this.var_FamilleFind.isEmpty()) {
         if (this.var_FamilleFind.contains(":")) {
            String[] var8 = this.var_FamilleFind.split(":");
            var7 = var8[0];
         } else {
            var7 = this.var_FamilleFind;
         }
      }

      String var13 = "";
      if (this.var_SousFamilleFind != null && !this.var_SousFamilleFind.isEmpty()) {
         if (this.var_SousFamilleFind.contains(":")) {
            String[] var9 = this.var_SousFamilleFind.split(":");
            var13 = var9[0];
         } else {
            var13 = this.var_SousFamilleFind;
         }
      } else {
         var13 = var7;
      }

      if (var5 != null && !var5.isEmpty()) {
         new Service();
         this.produitsServices = new ProduitsServices();
         Service var14 = this.serviceDao.chargerLeServiceCode(var5, var6);
         this.produitsServices.setServices(var14);
         this.lesProduitsServicesFind = new ArrayList();
         this.lesProduitsServicesFind = this.produitsServicesDao.selectProdServiceByservMedical(this.produitsServices.getServices(), var1, var6);
         if (this.lesProduitsServicesFind.size() > 0) {
            String var10 = "0000";

            for(int var11 = 0; var11 < this.lesProduitsServicesFind.size(); ++var11) {
               ProduitsServices var12 = (ProduitsServices)this.lesProduitsServicesFind.get(var11);
               var10 = var10 + "," + var12.getProduits().getProId();
            }

            var10 = "(" + var10 + ")";
            this.lesProduits = this.produitsMedicDao.selectFindProduitSerMedical(var1, var2, var3, this.filtre, this.inpActivite, var10, this.var_inactif, var6);
         }
      } else {
         this.lesProduits = this.produitsMedicDao.selectFindProduitMedical(var1, var2, var3, "", var13, var4, this.var_inactif, var6);
      }

      this.mefProduit(var6);
      this.utilInitHibernate.closeSession();
   }

   public void mefProduit(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      if (this.lesProduits.size() != 0) {
         new ArrayList();
         String var3 = "";

         for(int var4 = 0; var4 < this.lesProduits.size(); ++var4) {
            this.produits = (Produits)this.lesProduits.get(var4);
            double var6;
            double var8;
            if (!this.produits.getProVteNat().equals("1105")) {
               this.produits.setProQteCmdClient(0.0F);
               this.produits.setProQteCmdFournisseur(0.0F);
               this.produits.setProQteStock(0.0F);
            } else {
               float var5 = 0.0F;
               var6 = 0.0D;
               var8 = 0.0D;
               List var2;
               if (var3 != null && !var3.isEmpty()) {
                  var2 = this.produitsDepotDao.selectProdDepByprod(this.produits.getProCode(), var3, var1);
               } else {
                  var2 = this.produitsDepotDao.selectProdDepByprod(this.produits, var1);
               }

               if (var2.size() != 0) {
                  for(int var10 = 0; var10 < var2.size(); ++var10) {
                     if (((ProduitsDepot)var2.get(var10)).getProdepPa() != 0.0D) {
                        var8 = ((ProduitsDepot)var2.get(var10)).getProdepPa();
                     }

                     if (((ProduitsDepot)var2.get(var10)).getProdepPump() != 0.0D) {
                        var6 = ((ProduitsDepot)var2.get(var10)).getProdepPump();
                     }

                     var5 += ((ProduitsDepot)var2.get(var10)).getProdepQteStk();
                  }
               }

               this.produits.setProQteStock(var5);
               this.produits.setPa(var8);
               this.produits.setPump(var6);
            }

            String var11 = "";
            if (this.produits.getProVteNat().equals("1101") || this.produits.getProVteNat().equals("1104") || this.produits.getProVteNat().equals("1105") || this.produits.getProVteNat().equals("1106")) {
               new ArrayList();
               List var12 = this.produitsTarifDao.selectProdTarifByprod(this.produits, var1);
               if (var12.size() != 0) {
                  for(int var7 = 0; var7 < var12.size(); ++var7) {
                     if (var11 != null && !var11.isEmpty()) {
                        if (((ProduitsTarif)var12.get(var7)).getProtarOrdre() == -2) {
                           var11 = var11 + "," + "S";
                        } else if (((ProduitsTarif)var12.get(var7)).getProtarOrdre() == 1) {
                           var11 = var11 + "," + "A";
                        } else if (((ProduitsTarif)var12.get(var7)).getProtarOrdre() == -3) {
                           var11 = var11 + "," + "U";
                        } else if (((ProduitsTarif)var12.get(var7)).getProtarOrdre() == -4) {
                           var11 = var11 + "," + "C";
                        } else {
                           var11 = var11 + "," + "N";
                        }
                     } else if (((ProduitsTarif)var12.get(var7)).getProtarOrdre() == -2) {
                        var11 = "S";
                     } else if (((ProduitsTarif)var12.get(var7)).getProtarOrdre() == 1) {
                        var11 = "A";
                     } else if (((ProduitsTarif)var12.get(var7)).getProtarOrdre() == -3) {
                        var11 = "U";
                     } else if (((ProduitsTarif)var12.get(var7)).getProtarOrdre() == -4) {
                        var11 = "C";
                     } else {
                        var11 = "N";
                     }
                  }
               }
            }

            this.produits.setNomTarif(var11);
            this.produitsTarif = new ProduitsTarif();
            this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif1, var1);
            if (this.produitsTarif != null) {
               var6 = 0.0D;
               var8 = 0.0D;
               if (!this.produitsTarif.isProtarExoTva()) {
                  var6 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                  this.produits.setPv1(var6);
                  var8 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPvCnamgs() + this.produitsTarif.getProtarPvCnamgs() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                  this.produits.setPvCnamgs(var8);
               } else {
                  var6 = this.produitsTarif.getProtarPv();
                  this.produits.setPv1(var6);
                  var8 = this.produitsTarif.getProtarPvCnamgs();
                  this.produits.setPvCnamgs(var8);
               }
            } else {
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif2, var1);
               if (this.produitsTarif != null) {
                  var6 = 0.0D;
                  var8 = 0.0D;
                  if (!this.produitsTarif.isProtarExoTva()) {
                     var6 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPv1(var6);
                     var8 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPvCnamgs() + this.produitsTarif.getProtarPvCnamgs() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                     this.produits.setPvCnamgs(var8);
                  } else {
                     var6 = this.produitsTarif.getProtarPv();
                     this.produits.setPv1(var6);
                     var8 = this.produitsTarif.getProtarPvCnamgs();
                     this.produits.setPvCnamgs(var8);
                  }
               } else {
                  this.produitsTarif = new ProduitsTarif();
                  this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, this.var_tarif3, var1);
                  if (this.produitsTarif != null) {
                     var6 = 0.0D;
                     var8 = 0.0D;
                     if (!this.produitsTarif.isProtarExoTva()) {
                        var6 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPv() + this.produitsTarif.getProtarPv() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                        this.produits.setPv1(var6);
                        var8 = this.utilNombre.myRoundDevise(this.produitsTarif.getProtarPvCnamgs() + this.produitsTarif.getProtarPvCnamgs() * (double)this.produitsTarif.getProtarTauxTva() / 100.0D, this.structureLog.getStrdevise());
                        this.produits.setPvCnamgs(var8);
                     } else {
                        var6 = this.produitsTarif.getProtarPv();
                        this.produits.setPv1(var6);
                        var8 = this.produitsTarif.getProtarPvCnamgs();
                        this.produits.setPvCnamgs(var8);
                     }
                  }
               }
            }
         }
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
            long var6 = this.produits.getProId();
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsMedic");
            this.produits = this.produitsMedicDao.chargeProduit(var6, var5);
            if (this.produits != null) {
               if (this.produits.getProImpDesciption() == 1) {
                  this.libelle_libre = true;
               } else {
                  this.libelle_libre = false;
               }

               if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
                  this.famillesProduitsMedical = new FamillesProduitsVentes();
                  this.famillesProduitsMedical = this.famillesProduitsMedicalDao.rechercheFamilleByCode(this.lastexoMed.getExevteId(), this.produits.getProVteCode(), var5);
                  if (this.famillesProduitsMedical != null) {
                     this.inpNatureVnt = this.famillesProduitsMedical.getFamvteNature() + ":" + this.famillesProduitsMedical.getFamvteLibNature();
                  } else {
                     this.inpNatureVnt = "";
                  }
               } else {
                  this.inpNatureVnt = "";
               }

               if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
                  this.inpFamilleVnt = this.produits.getProVteCode() + ":" + this.produits.getProVteLib();
               } else {
                  this.inpFamilleVnt = "";
               }

               if (this.produits.getProInactif() != 2) {
                  this.afficheButtSup = true;
               } else {
                  this.afficheButtSup = false;
               }

               this.choixLettre = "";
               this.lettreUtil = false;
               this.valeurLettre = 0.0D;
               this.valeurLettreCnamgs = 0.0D;
               if (!this.produits.getProVteNat().equalsIgnoreCase("1102") && !this.produits.getProVteNat().equalsIgnoreCase("1103") && !this.produits.getProVteNat().equalsIgnoreCase("1104") && !this.produits.getProVteNat().equalsIgnoreCase("1106")) {
                  this.lettreUtil = false;
                  this.valeurLettre = 0.0D;
                  this.valeurLettreCnamgs = 0.0D;
               } else {
                  if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
                     this.lettreMedical = this.lettreMedicalDao.selectLettre(this.exercicesVentes.getExevteId(), this.produits.getProLettre(), var5);
                     if (this.lettreMedical != null) {
                        this.valeurLettre = this.lettreMedical.getLetValeur();
                        this.valeurLettreCnamgs = this.lettreMedical.getLetValeurCnamgs();
                     }
                  }

                  this.choixLettre = this.produits.getProLettre();
                  if (this.choixLettre != null && !this.choixLettre.isEmpty()) {
                     this.lettreUtil = true;
                  } else {
                     this.lettreUtil = false;
                  }
               }

               this.affichePhotoProduit();
               this.chargerProduitDepot(var5);
               this.chargerCaracteristiques(var5);
               this.chargerProduitDepotByProd(var5);
               this.chargerProduitTarifByProd(var5);
               this.chargerProduitMoClefByProd(var5);
               this.chargerProService(var5);
               this.chargerInfoTables(var5);
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
      if (this.lesProduitsServices.size() == 0) {
         if (this.produits.isProAvecService()) {
            this.produits.setProAvecService(false);
            this.produits = this.produitsMedicDao.modifProduit(this.produits);
         }
      } else if (!this.produits.isProAvecService()) {
         this.produits.setProAvecService(true);
         this.produits = this.produitsMedicDao.modifProduit(this.produits);
      }

   }

   public void ajouterProduit() {
      this.produits = new Produits();
      this.produitsActe = new ProduitsActe();
      this.produitsPharmacie = new ProduitsPharmacie();
      this.produitsLaboratoire = new ProduitsLaboratoire();
      this.produits.setInactif(false);
      this.lesProduitsDepos.clear();
      this.lesProduitsMcles.clear();
      this.lesProduitsServices.clear();
      this.lesProduitsTarif.clear();
      this.lesMvt.clear();
      this.inpFamilleVnt = "0";
      this.inpNatureVnt = "";
      this.existCod = false;
      this.choixLettre = "";
      this.lettreUtil = false;
      this.valeurLettre = 0.0D;
      this.valeurLettreCnamgs = 0.0D;
      this.var_action = 1;
   }

   public void modifierProduit() {
      if (this.produits != null) {
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
         this.majProduit();
         this.choixLettre = "";
         this.lettreUtil = false;
         this.valeurLettre = 0.0D;
         this.valeurLettreCnamgs = 0.0D;
         this.afficheButtSup = false;
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

   }

   public void reactiverProduit() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         this.produits.setProInactif(0);
         this.produits.setInactif(false);
         this.majProduit();
         this.afficheButtSup = false;
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
      this.service1Facture = null;
      this.service2Facture = null;
      this.service3Facture = null;
      this.service4Facture = null;
      this.service5Facture = null;
      if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
         if (!this.produits.getProActivite().contains("#")) {
            this.service1Facture = this.produits.getProActivite();
         } else {
            String[] var2 = this.produits.getProActivite().split("#");
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
               if (var4 == 0) {
                  this.service1Facture = var2[var4];
               } else if (var4 == 1) {
                  this.service2Facture = var2[var4];
               } else if (var4 == 2) {
                  this.service3Facture = var2[var4];
               } else if (var4 == 3) {
                  this.service4Facture = var2[var4];
               } else if (var4 == 4) {
                  this.service5Facture = var2[var4];
               }
            }
         }
      }

   }

   public void chargerProduitDepot(Session var1) throws HibernateException, NamingException {
      this.lesProduitsDepos = new ArrayList();
      this.lesProduitsDepos = this.produitsDepotDao.selectProdDepByprod(this.produits, var1);
      this.datamodelDepot.setWrappedData(this.lesProduitsDepos);
      this.afficheButtModifDepProd = false;
      this.afficheButtSuppDepProd = false;
   }

   public void chargerCaracteristiques(Session var1) throws HibernateException, NamingException {
      this.afficheFormule = false;
      this.existGrp = false;
      this.existGrpCode = false;
      this.lesProduitsCode.clear();
      this.datamodelCode.setWrappedData(this.lesProduitsCode);
      this.lesProduitsGrps.clear();
      this.datamodelGrp.setWrappedData(this.lesProduitsGrps);
      this.lesProduitsFourchettes.clear();
      this.datamodelFourchette.setWrappedData(this.lesProduitsFourchettes);
      this.lesProduitsreponse.clear();
      this.datamodelReponse.setWrappedData(this.lesProduitsreponse);
      this.lesProduitsDetail.clear();
      this.datamodelDetail.setWrappedData(this.lesProduitsDetail);
      this.produitsActe = new ProduitsActe();
      this.produitsPharmacie = new ProduitsPharmacie();
      this.produitsLaboratoire = new ProduitsLaboratoire();
      if (this.produits.getProVteNat().equalsIgnoreCase("1104")) {
         this.produitsActe = this.produitsActeDao.chargeProdActeByProd(this.produits.getProId(), var1);
         if (this.produitsActe == null) {
            this.produitsActe = new ProduitsActe();
         }
      } else if (this.produits.getProVteNat().equalsIgnoreCase("1105")) {
         this.produitsPharmacie = this.produitsPharmacieDao.chargeProdPharmacieByProd(this.produits.getProId(), var1);
         if (this.produitsPharmacie == null) {
            this.produitsPharmacie = new ProduitsPharmacie();
         }

         new ProduitsDci();
         ProduitsMedicammentDao var3 = new ProduitsMedicammentDao(this.baseLog, this.utilInitHibernate);
         ProduitsDci var2 = var3.rechercheDci(this.produits.getProLibTech(), var1);
         if (var2 != null) {
            if (this.produitsPharmacie.getProphaGalenique() == null || this.produitsPharmacie.getProphaGalenique().isEmpty()) {
               this.produitsPharmacie.setProphaGalenique(var2.getProdciForme());
            }

            if (this.produitsPharmacie.getProphaFormuleDci() == null || this.produitsPharmacie.getProphaFormuleDci().isEmpty()) {
               this.produitsPharmacie.setProphaFormuleDci(var2.getProdciCode());
            }

            if (this.produitsPharmacie.getProphaPosologie() == null || this.produitsPharmacie.getProphaPosologie().isEmpty()) {
               this.produitsPharmacie.setProphaPosologie(var2.getProdciPosologie());
            }

            if (this.produitsPharmacie.getProphaObservations() == null || this.produitsPharmacie.getProphaObservations().isEmpty()) {
               this.produitsPharmacie.setProphaObservations(var2.getProdciIndication());
            }
         }
      } else if (this.produits.getProVteNat().equalsIgnoreCase("1106")) {
         this.produitsLaboratoire = this.produitsLaboratoireDao.chargeProdLaboratoireByProd(this.produits.getProId(), var1);
         if (this.produitsLaboratoire == null) {
            this.produitsLaboratoire = new ProduitsLaboratoire();
         } else if (this.produitsLaboratoire.getProlabType() == 1) {
            this.lesProduitsFourchettes = this.produitsFourchetteDao.chargeProdFourchetteByLab(this.produitsLaboratoire.getProlabId(), var1);
            this.datamodelFourchette.setWrappedData(this.lesProduitsFourchettes);
         } else if (this.produitsLaboratoire.getProlabType() != 5 && this.produitsLaboratoire.getProlabType() != 6 && this.produitsLaboratoire.getProlabType() != 7) {
            if (this.produitsLaboratoire.getProlabType() == 8) {
               this.lesProduitsDetail = this.produitsDetailDao.chargeProdDetailByLab(this.produitsLaboratoire.getProlabId(), var1);
               this.datamodelDetail.setWrappedData(this.lesProduitsDetail);
            }
         } else {
            this.lesProduitsreponse = this.produitsReponseDao.chargeProdReponseByLab(this.produitsLaboratoire.getProlabId(), 0, var1);
            this.datamodelReponse.setWrappedData(this.lesProduitsreponse);
         }
      } else if (this.produits.getProMode() == 0) {
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
      this.afficheButtModifProdTar = false;
      this.lesProduitsTarif = this.produitsTarifDao.selectProdTarifByprod(this.produits, var1);
      this.datamodelTarif.setWrappedData(this.lesProduitsTarif);
      this.afficheButtModifProdTarConvention = false;
      this.lesConventions = this.conventionMedicalDao.chargeConvention(this.produits.getProCode(), var1);
      this.datamodelTarifConvention.setWrappedData(this.lesConventions);
   }

   public void chargerInfoTables(Session var1) throws HibernateException, NamingException {
      PlanComptable var2;
      if (this.produits.getProVteCpteLoc() != null && !this.produits.getProVteCpteLoc().isEmpty()) {
         new PlanComptable();
         var2 = this.planComptableDao.trouveCompte(this.selecFiscalite, this.lastexoMed.getExevteId(), this.produits.getProVteCpteLoc(), var1);
         if (var2 != null) {
            this.produits.setProVteCpteLoc(var2.getPlcCompte() + ":" + var2.getPlcLibelleCpteFR());
         } else {
            this.produits.setProVteCpteLoc("");
         }
      }

      if (this.produits.getProVteCpteZ() != null && !this.produits.getProVteCpteZ().isEmpty()) {
         new PlanComptable();
         var2 = this.planComptableDao.trouveCompte(this.selecFiscalite, this.lastexoMed.getExevteId(), this.produits.getProVteCpteZ(), var1);
         if (var2 != null) {
            this.produits.setProVteCpteZ(var2.getPlcCompte() + ":" + var2.getPlcLibelleCpteFR());
         } else {
            this.produits.setProVteCpteZ("");
         }
      }

      if (this.produits.getProVteCpteHz() != null && !this.produits.getProVteCpteHz().isEmpty()) {
         new PlanComptable();
         var2 = this.planComptableDao.trouveCompte(this.selecFiscalite, this.lastexoMed.getExevteId(), this.produits.getProVteCpteHz(), var1);
         if (var2 != null) {
            this.produits.setProVteCpteHz(var2.getPlcCompte() + ":" + var2.getPlcLibelleCpteFR());
         } else {
            this.produits.setProVteCpteHz("");
         }
      }

      if (this.produits.getProVteCptePr() != null && !this.produits.getProVteCptePr().isEmpty()) {
         new PlanComptable();
         var2 = this.planComptableDao.trouveCompte(this.selecFiscalite, this.lastexoMed.getExevteId(), this.produits.getProVteCptePr(), var1);
         if (var2 != null) {
            this.produits.setProVteCptePr(var2.getPlcCompte() + ":" + var2.getPlcLibelleCpteFR());
         } else {
            this.produits.setProVteCptePr("");
         }
      }

      if (this.produits.getProVteCpteSt() != null && !this.produits.getProVteCpteSt().isEmpty()) {
         new PlanComptable();
         var2 = this.planComptableDao.trouveCompte(this.selecFiscalite, this.lastexoMed.getExevteId(), this.produits.getProVteCpteSt(), var1);
         if (var2 != null) {
            this.produits.setProVteCpteSt(var2.getPlcCompte() + ":" + var2.getPlcLibelleCpteFR());
         } else {
            this.produits.setProVteCpteSt("");
         }
      }

      if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty()) {
         new TaxesVentes();
         TaxesVentes var3 = this.taxesMedicalDao.selectTva(this.lastexoMed.getExevteId(), this.produits.getProVteTva(), var1);
         if (var3 != null) {
            this.produits.setProVteTva(var3.getTaxvteCode() + ":" + var3.getTaxvteLibelleFr());
         } else {
            this.produits.setProVteTva("");
         }
      }

      if (this.produits.getProDepotVte() != null && !this.produits.getProDepotVte().isEmpty()) {
         this.depotAchats = new DepotAchats();
         this.depotAchats = this.depotAchatsDao.trouveDepot(this.produits.getProDepotVte(), var1);
         if (this.depotAchats != null) {
            this.produits.setProDepotVte(this.depotAchats.getDpoCode() + ":" + this.depotAchats.getDpoLibelle());
         } else {
            this.produits.setProDepotVte("");
         }
      }

      if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
         new Activites();
         Activites var4 = this.activitesDao.rechercheActivite(this.produits.getProActivite(), var1);
         if (var4 != null) {
            this.produits.setProActivite(var4.getActCode() + ":" + var4.getActNomFr());
         } else {
            this.produits.setProActivite("");
         }
      }

   }

   public void calculeCode() throws HibernateException, NamingException {
      if (this.inpFamilleVnt.contains(":")) {
         String[] var1 = this.inpFamilleVnt.split(":");
         this.famillesProduitsMedical = new FamillesProduitsVentes();
         this.famillesProduitsMedical = this.famillesProduitsMedicalDao.rechercheFamilleByCode(this.lastexoMed.getExevteId(), var1[0], (Session)null);
         if (this.famillesProduitsMedical != null) {
            this.inpNatureVnt = this.famillesProduitsMedical.getFamvteNature() + ":" + this.famillesProduitsMedical.getFamvteLibNature();
         } else {
            this.inpNatureVnt = "";
         }

         this.valeurDefautFamille();
      } else {
         this.inpNatureVnt = "";
      }

      if (this.produits.getProCode() == null || this.produits.getProCode().isEmpty()) {
         long var6 = 0L;
         if (!this.optionsMedical.getModCalcOP().equalsIgnoreCase("0") && !this.optionsMedical.getModCalcOP().equalsIgnoreCase("1")) {
            CalculChrono var3;
            String var4;
            if (this.optionsMedical.getModCalcOP().equalsIgnoreCase("2")) {
               var6 = this.produitsMedicDao.lastProduit((Session)null, 2);
               var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var4 = var3.numero(this.lgNumProd, var6);
               this.produits.setProCode(var4);
               this.verifCode();
            } else if (this.optionsMedical.getModCalcOP().equalsIgnoreCase("3")) {
               var6 = this.produitsMedicDao.lastProduit((Session)null, 3);
               var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var4 = var3.numero(this.lgNumProd, var6);
               this.produits.setProCode(var4);
               this.verifCode();
            } else if (this.optionsMedical.getModCalcOP().equalsIgnoreCase("4")) {
               var6 = this.produitsMedicDao.lastProduit((Session)null, 4);
               var3 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               var4 = var3.numero(this.lgNumProd, var6);
               this.produits.setProCode(var4);
               this.verifCode();
            } else {
               String var5;
               String[] var7;
               CalculChrono var8;
               if (this.optionsMedical.getModCalcOP().equalsIgnoreCase("5")) {
                  if (this.inpFamilleVnt.contains(":")) {
                     var7 = this.inpFamilleVnt.split(":");
                     var6 = this.produitsMedicDao.lastProduitById(var7[0], (Session)null);
                     var8 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var5 = var8.numero(this.lgNumProd, var6);
                     this.produits.setProCode(var7[0] + "-" + var5);
                     this.verifCode();
                  }
               } else if (this.optionsMedical.getModCalcOP().equalsIgnoreCase("6")) {
                  if (this.inpFamilleVnt.contains(":")) {
                     var7 = this.inpFamilleVnt.split(":");
                     var6 = this.produitsMedicDao.nbProduitByFamilleVte(var7[0], (Session)null);
                     var8 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                     var5 = var8.numero(this.lgNumProd, var6);
                     this.produits.setProCode(var7[0] + "-" + var5);
                     this.verifCode();
                  }
               } else if (this.optionsMedical.getModCalcOP().equalsIgnoreCase("7") && this.inpFamilleVnt.contains(":")) {
                  var7 = this.inpFamilleVnt.split(":");
                  var6 = this.produitsMedicDao.lastProduitByFamille(var7[0], (Session)null);
                  var8 = new CalculChrono(this.baseLog, this.utilInitHibernate);
                  var5 = var8.numero(this.lgNumProd, var6);
                  this.produits.setProCode(var7[0] + "-" + var5);
                  this.verifCode();
               }
            }
         }
      }

   }

   public void verifCode() throws HibernateException, NamingException {
      if (this.produits.getProCode() != null && !this.produits.getProCode().isEmpty()) {
         if (!this.optionsMedical.getModCalcOP().equalsIgnoreCase("0")) {
            if (this.optionsMedical.getModCalcOP().equalsIgnoreCase("1")) {
               CalculChrono var1 = new CalculChrono(this.baseLog, this.utilInitHibernate);
               String var2 = var1.numero(this.lgNumProd, this.produits.getProCode());
               this.produits.setProCode(var2);
            } else if (!this.optionsMedical.getModCalcOP().equalsIgnoreCase("2") && !this.optionsMedical.getModCalcOP().equalsIgnoreCase("3") && !this.optionsMedical.getModCalcOP().equalsIgnoreCase("4") && !this.optionsMedical.getModCalcOP().equalsIgnoreCase("5") && !this.optionsMedical.getModCalcOP().equalsIgnoreCase("6") && this.optionsMedical.getModCalcOP().equalsIgnoreCase("7")) {
            }
         }

         boolean var3 = false;
         var3 = this.produitsMedicDao.existCode(this.produits.getProCode());
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
      if (this.famillesProduitsMedical == null) {
         this.famillesProduitsMedical = new FamillesProduitsVentes();
         this.famillesProduitsMedical = this.famillesProduitsMedicalDao.rechercheFamilleByCode(this.lastexoMed.getExevteId(), this.produits.getProVteCode(), (Session)null);
         if (this.famillesProduitsMedical != null) {
            this.inpNatureVnt = this.famillesProduitsMedical.getFamvteNature() + ":" + this.famillesProduitsMedical.getFamvteLibNature();
         } else {
            this.inpNatureVnt = "";
         }
      }

      if (this.famillesProduitsMedical != null) {
         this.produits.setProVteCpteLoc(this.famillesProduitsMedical.getFamvteCompteLocal());
         this.produits.setProVteCpteZ(this.famillesProduitsMedical.getFamvteCompteZone());
         this.produits.setProVteCpteHz(this.famillesProduitsMedical.getFamvteCompteExterieur());
         this.produits.setProVteCptePr(this.famillesProduitsMedical.getFamvteCompteProduit());
         this.produits.setProVteCpteSt(this.famillesProduitsMedical.getFamvteCompteStock());
         this.produits.setProVteDouane(this.famillesProduitsMedical.getFamvteDouane());
         this.produits.setProVteTva(this.famillesProduitsMedical.getFamvteTaxe());
         this.produits.setProActivite(this.famillesProduitsMedical.getFamvteActivite());
      }

   }

   public void annuleSaisie() {
      this.var_action = 0;
      this.afficheButtOption = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void majProduit() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.libelle_libre) {
         this.produits.setProImpDesciption(1);
      } else {
         this.produits.setProImpDesciption(0);
      }

      String[] var1;
      if (this.inpNatureVnt.contains(":")) {
         var1 = this.inpNatureVnt.split(":");
         this.produits.setProVteNat(var1[0]);
      } else {
         this.produits.setProVteNat("");
      }

      if (this.inpFamilleVnt.contains(":")) {
         var1 = this.inpFamilleVnt.split(":");
         this.produits.setProVteCode(var1[0]);
         this.produits.setProVteLib(var1[1]);
      } else {
         this.produits.setProVteCode("");
         this.produits.setProVteLib("");
      }

      if (this.produits.getProVteCpteLoc() != null && this.produits.getProVteCpteLoc().contains(":")) {
         var1 = this.produits.getProVteCpteLoc().split(":");
         this.produits.setProVteCpteLoc(var1[0]);
      } else {
         this.produits.setProVteCpteLoc("");
      }

      if (this.produits.getProVteCpteZ() != null && this.produits.getProVteCpteZ().contains(":")) {
         var1 = this.produits.getProVteCpteZ().split(":");
         this.produits.setProVteCpteZ(var1[0]);
      } else {
         this.produits.setProVteCpteZ("");
      }

      if (this.produits.getProVteCpteHz() != null && this.produits.getProVteCpteHz().contains(":")) {
         var1 = this.produits.getProVteCpteHz().split(":");
         this.produits.setProVteCpteHz(var1[0]);
      } else {
         this.produits.setProVteCpteHz("");
      }

      if (this.produits.getProVteCptePr() != null && this.produits.getProVteCptePr().contains(":")) {
         var1 = this.produits.getProVteCptePr().split(":");
         this.produits.setProVteCptePr(var1[0]);
      } else {
         this.produits.setProVteCptePr("");
      }

      if (this.produits.getProVteCpteSt() != null && this.produits.getProVteCpteSt().contains(":")) {
         var1 = this.produits.getProVteCpteSt().split(":");
         this.produits.setProVteCpteSt(var1[0]);
      } else {
         this.produits.setProVteCpteSt("");
      }

      if (this.produits.getProVteTva() != null && this.produits.getProVteTva().contains(":")) {
         var1 = this.produits.getProVteTva().split(":");
         this.produits.setProVteTva(var1[0]);
      } else {
         this.produits.setProVteTva("");
      }

      if (this.produits.getProDepotVte() != null && this.produits.getProDepotVte().contains(":")) {
         var1 = this.produits.getProDepotVte().split(":");
         this.produits.setProDepotVte(var1[0]);
      } else {
         this.produits.setProDepotVte("");
      }

      if (this.service1Facture != null && !this.service1Facture.isEmpty()) {
         this.produits.setProActivite(this.service1Facture);
         if (this.service2Facture != null && !this.service2Facture.isEmpty()) {
            this.produits.setProActivite(this.produits.getProActivite() + "#" + this.service2Facture);
            if (this.service3Facture != null && !this.service3Facture.isEmpty()) {
               this.produits.setProActivite(this.produits.getProActivite() + "#" + this.service3Facture);
               if (this.service4Facture != null && !this.service4Facture.isEmpty()) {
                  this.produits.setProActivite(this.produits.getProActivite() + "#" + this.service4Facture);
                  if (this.service5Facture != null && !this.service5Facture.isEmpty()) {
                     this.produits.setProActivite(this.produits.getProActivite() + "#" + this.service5Facture);
                  }
               }
            }
         }
      }

      if (this.choixLettre != null && !this.choixLettre.isEmpty()) {
         this.produits.setProLettre(this.choixLettre);
      } else {
         this.produits.setProLettre("");
      }

      if (this.getProduits().getProId() == 0L) {
         this.produits = this.produitsMedicDao.insert(this.produits);
         this.lesProduits.add(this.produits);
         this.datamodelProduit.setWrappedData(this.lesProduits);
         this.var_action = 2;
         this.simpleSelectionEntete.clear();
         this.extDTable = new HtmlExtendedDataTable();
      } else {
         this.produits = this.produitsMedicDao.modifProduit(this.produits);
         if (this.produits.getProVteNat().equalsIgnoreCase("1104")) {
            if (this.produitsActe != null) {
               this.produitsActe.setProduits(this.produits);
               if (this.produitsActe.getProactId() == 0L) {
                  this.produitsActe = this.produitsActeDao.insert(this.produitsActe);
               } else {
                  this.produitsActe = this.produitsActeDao.modif(this.produitsActe);
               }
            }
         } else if (this.produits.getProVteNat().equalsIgnoreCase("1105")) {
            if (this.produitsPharmacie != null) {
               this.produitsPharmacie.setProduits(this.produits);
               if (this.produitsPharmacie.getProphaId() == 0L) {
                  this.produitsPharmacie = this.produitsPharmacieDao.insert(this.produitsPharmacie);
               } else {
                  this.produitsPharmacie = this.produitsPharmacieDao.modif(this.produitsPharmacie);
               }
            }
         } else if (this.produits.getProVteNat().equalsIgnoreCase("1106") && this.produitsLaboratoire != null) {
            this.produitsLaboratoire.setProduits(this.produits);
            if (this.produitsLaboratoire.getProlabId() == 0L) {
               this.produitsLaboratoire = this.produitsLaboratoireDao.insert(this.produitsLaboratoire);
            } else {
               this.produitsLaboratoire = this.produitsLaboratoireDao.modif(this.produitsLaboratoire);
            }
         }

         this.rechercherProduit();
         this.var_action = 0;
         this.afficheButtOption = false;
      }

      if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdService() == 1) {
         String var5 = "";
         if (this.usersLog.getUsrService().contains(":")) {
            String[] var2 = this.usersLog.getUsrService().split(":");
            var5 = var2[0];
         } else {
            var5 = this.usersLog.getUsrService();
         }

         boolean var4 = false;

         for(int var3 = 0; var3 < this.lesProduitsServices.size(); ++var3) {
            if (((ProduitsServices)this.lesProduitsServices.get(var3)).getServices().getSerCode().equals(var5)) {
               var4 = true;
            }
         }

         if (!var4) {
            this.creationProduitService(var5);
         }

         this.majService();
      }

   }

   public void creationProduitService(String var1) throws HibernateException, NamingException {
      new Service();
      Service var2 = this.serviceDao.chargerLeServiceCode(var1, (Session)null);
      if (var2 != null) {
         this.produitsServices = new ProduitsServices();
         this.produitsServices.setProduits(this.produits);
         this.produitsServices.setProserCode(var2.getSerCode());
         this.produitsServices.setProserNomFr(var2.getSerNomFr());
         this.produitsServices.setProserQte(0.0F);
         this.produitsServices.setServices(var2);
         this.produitsServicesDao.insert(this.produitsServices);
         this.lesProduitsServices.add(this.produitsServices);
         this.datamodelProService.setWrappedData(this.lesProduitsServices);
      }

   }

   public void affichePhotoProduit() throws IOException, SQLException {
      if (this.produits != null && this.produits.getProPhoto() != null) {
         this.urlphotoProd = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator + this.produits.getProPhoto();
      } else {
         this.urlphotoProd = "";
      }

      if (this.produits != null && this.produitsLaboratoire != null && this.produitsLaboratoire.getProlabInterpretation() != null && !this.produitsLaboratoire.getProlabInterpretation().isEmpty()) {
         this.urlphotoInterpretation1 = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "interpretation" + File.separator + this.produitsLaboratoire.getProlabInterpretation();
      } else {
         this.urlphotoInterpretation1 = "";
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
            this.produitsMedicDao.modifProduit(this.produits);
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator + this.produits.getProPhoto();
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
            this.produitsMedicDao.modifProduit(this.produits);
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
      this.produitsMedicDao.modifProduit(this.produits);
   }

   public void reInitPDF() throws HibernateException, NamingException {
      this.produits.setProPdf((String)null);
      this.produitsMedicDao.modifProduit(this.produits);
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "produits" + File.separator + "pdf") + File.separator + this.produits.getProCode() + ".pdf";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

   }

   public void ajoutInterpretation1() throws IOException, JDOMException, HibernateException, NamingException {
      String var1 = this.produits.getProCode();
      FacesContext var2 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "interpretation" + File.separator + var1;
            File var4 = new File(var3);
            if (var4.exists()) {
               var4.delete();
            }

            String var5 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var6 = var5.substring(var5.indexOf(".") + 1);
            var5 = var1 + "." + var6;
            File var7 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "interpretation" + File.separator), var5);
            this.utilDownload.write(var7, this.uploadedFile.getInputStream());
            this.fileName = var5;
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.produitsLaboratoire.setProlabInterpretation(var5);
            this.urlphotoInterpretation1 = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "interpretation" + File.separator + var5;
         }
      } catch (IOException var8) {
         this.produits.setProPhoto(this.fileName);
         var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var8.printStackTrace();
      }

   }

   public void reInitInterpretation1() throws HibernateException, NamingException {
      if (this.produitsLaboratoire != null && this.produitsLaboratoire.getProlabInterpretation() != null && !this.produitsLaboratoire.getProlabInterpretation().isEmpty()) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "interpretation" + File.separator + this.produitsLaboratoire.getProlabInterpretation();
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         this.produitsLaboratoire.setProlabInterpretation((String)null);
         this.urlphotoInterpretation1 = "";
      }

   }

   public void ajoutInterpretation2() throws IOException, JDOMException, HibernateException, NamingException {
      long var1 = 0L;
      if (this.produitsDetail.getProdetId() == 0L) {
         var1 = this.produitsDetailDao.chargeDernier((Session)null);
      } else {
         var1 = this.produitsDetail.getProdetId();
      }

      String var3 = this.produits.getProCode() + ":" + var1;
      FacesContext var4 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "interpretation" + File.separator + var3;
            File var6 = new File(var5);
            if (var6.exists()) {
               var6.delete();
            }

            String var7 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var8 = var7.substring(var7.indexOf(".") + 1);
            var7 = var3 + "." + var8;
            File var9 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "interpretation" + File.separator), var7);
            this.utilDownload.write(var9, this.uploadedFile.getInputStream());
            this.fileName = var7;
            var4.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.produitsDetail.setProdetInterpretation(var7);
            this.urlphotoInterpretation2 = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "photo" + File.separator + "interpretation" + File.separator + var7;
         }
      } catch (IOException var10) {
         this.produits.setProPhoto(this.fileName);
         var4.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var10.printStackTrace();
      }

   }

   public void reInitInterpretation2() throws HibernateException, NamingException {
      if (this.produitsDetail != null && this.produitsDetail.getProdetInterpretation() != null && !this.produitsDetail.getProdetInterpretation().isEmpty()) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "interpretation" + File.separator + this.produitsDetail.getProdetInterpretation() + ":" + this.produitsDetail.getProdetId();
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         this.produitsDetail.setProdetInterpretation((String)null);
         this.urlphotoInterpretation2 = "";
      }

   }

   public void rechercheProduitsLies() throws HibernateException, NamingException {
      if (this.produits.getProCodeLie() != null && !this.produits.getProCodeLie().isEmpty()) {
         this.lesProduitsLiesRecherche = new ArrayList();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         int var3;
         Produits var4;
         if (this.usersLog.getUsrProdService() == 1 && !this.usersLog.getUsrService().isEmpty()) {
            Service var5 = this.serviceDao.chargerLeServiceCode(this.usersLog.getUsrService(), var1);
            this.lesProduitsServicesFind = new ArrayList();
            this.lesProduitsServicesFind = this.produitsServicesDao.selectProdServiceByservAchs(var5, this.produits.getProCodeLie(), this.var_TypeFind, var1);
            if (this.lesProduitsServicesFind.size() != 0) {
               for(var3 = 0; var3 < this.lesProduitsServicesFind.size(); ++var3) {
                  new Produits();
                  var4 = ((ProduitsServices)this.lesProduitsServicesFind.get(var3)).getProduits();
                  this.lesProduitsLiesRecherche.add(var4);
               }
            }
         } else if (this.produits.getProCodeLie().contains("%")) {
            new ArrayList();
            List var2 = this.produitsMclesDao.verifProduits(this.produits.getProCodeLie(), this.var_TypeFind, var1);
            if (var2.size() != 0) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  new Produits();
                  var4 = ((ProduitsMcles)var2.get(var3)).getProduits();
                  this.lesProduitsLiesRecherche.add(var4);
               }
            }
         } else {
            this.lesProduitsLiesRecherche = this.produitsMedicDao.verifProduits(this.produits.getProCodeLie(), var1);
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

      this.showModalProduitRecherche = false;
   }

   public void annuleProduits() {
      this.produitsLies = null;
      this.produits.setProCodeLie("");
      this.produits.setProQteLie(0.0F);
      this.lesProduitsLiesRecherche.clear();
      this.datamodelProduitsLieRecherche.setWrappedData(this.lesProduitsLiesRecherche);
      this.showModalProduitRecherche = false;
   }

   public void recupererCalc() throws HibernateException, NamingException {
      this.chargerCaracteristiques((Session)null);
   }

   public void chargerProduitGrpByProd(Session var1) throws HibernateException, NamingException {
      this.lesProduitsGrps = new ArrayList();
      this.datamodelGrp = new ListDataModel();
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
         this.lesProduitsCode = this.produitsMedicDao.selectEgalProduits(var2, var1);
      }

      this.datamodelCode = new ListDataModel();
      this.datamodelCode.setWrappedData(this.lesProduitsCode);
   }

   public void ajouterFourchette() {
      this.produitsFourchette = new ProduitsFourchette();
      this.showModalPanelFourchette = true;
   }

   public void modifierFourchette() {
      if (this.produitsFourchette != null) {
         this.showModalPanelFourchette = true;
      }

   }

   public void fermerFourchette() {
      this.showModalPanelFourchette = false;
   }

   public void supprimerFourchette() throws HibernateException, NamingException {
      if (this.produitsFourchette != null) {
         this.produitsFourchetteDao.delete(this.produitsFourchette);
         this.lesProduitsFourchettes = this.produitsFourchetteDao.chargeProdFourchetteByLab(this.produitsLaboratoire.getProlabId(), (Session)null);
         this.datamodelFourchette.setWrappedData(this.lesProduitsFourchettes);
         this.afficheButtFourchette = false;
      }

   }

   public void calculeFourchette() {
      if (this.produitsFourchette.getProfchAge() == 0) {
         this.produitsFourchette.setProfchAgeDebut(0.0F);
         this.produitsFourchette.setProfchAgeFin(0.0F);
      } else if (this.produitsFourchette.getProfchAge() == 1) {
         this.produitsFourchette.setProfchAgeDebut(0.0F);
         this.produitsFourchette.setProfchAgeFin((float)Integer.parseInt(this.optionsMedical.getAnneeFinBebe()));
      } else if (this.produitsFourchette.getProfchAge() == 2) {
         this.produitsFourchette.setProfchAgeDebut((float)Integer.parseInt(this.optionsMedical.getAnneeDebutEnfant()));
         this.produitsFourchette.setProfchAgeFin((float)Integer.parseInt(this.optionsMedical.getAnneeFinEnfant()));
      } else if (this.produitsFourchette.getProfchAge() == 3) {
         this.produitsFourchette.setProfchAgeDebut((float)Integer.parseInt(this.optionsMedical.getAnneeDebutAdo()));
         this.produitsFourchette.setProfchAgeFin((float)Integer.parseInt(this.optionsMedical.getAnneeFinAdo()));
      } else if (this.produitsFourchette.getProfchAge() == 4) {
         this.produitsFourchette.setProfchAgeDebut((float)Integer.parseInt(this.optionsMedical.getAnneeDebutAdulte()));
         this.produitsFourchette.setProfchAgeFin((float)Integer.parseInt(this.optionsMedical.getAnneeFinAdulte()));
      } else if (this.produitsFourchette.getProfchAge() == 5) {
         this.produitsFourchette.setProfchAgeDebut((float)Integer.parseInt(this.optionsMedical.getAnneeDebutSenior()));
         this.produitsFourchette.setProfchAgeFin(120.0F);
      } else if (this.produitsFourchette.getProfchAge() != 10 && this.produitsFourchette.getProfchAge() != 11 && this.produitsFourchette.getProfchAge() == 12) {
      }

   }

   public void selectionFourchette() {
      if (this.datamodelFourchette.isRowAvailable()) {
         this.produitsFourchette = (ProduitsFourchette)this.datamodelFourchette.getRowData();
         this.afficheButtFourchette = true;
      }

   }

   public void saveProduitsFourchette() throws HibernateException, NamingException {
      if (this.produitsLaboratoire.getProlabId() == 0L) {
         this.produitsLaboratoire.setProduits(this.produits);
         this.produitsLaboratoire = this.produitsLaboratoireDao.insert(this.produitsLaboratoire);
      }

      this.produitsFourchette.setProfchCode(this.produits.getProCode());
      this.produitsFourchette.setProduitsLaboratoire(this.produitsLaboratoire);
      this.produitsFourchette.setProduitsDetail((ProduitsDetail)null);
      if (this.produitsFourchette.getProfchId() == 0L) {
         this.produitsFourchette = this.produitsFourchetteDao.insert(this.produitsFourchette);
         this.lesProduitsFourchettes.add(this.produitsFourchette);
         this.datamodelFourchette.setWrappedData(this.lesProduitsFourchettes);
      } else {
         this.produitsFourchette = this.produitsFourchetteDao.modif(this.produitsFourchette);
      }

      this.afficheButtFourchette = false;
      this.showModalPanelFourchette = false;
   }

   public void ajouterReponse() {
      this.produitsReponse = new ProduitsReponse();
   }

   public void modifierReponse() {
   }

   public void supprimerReponse() throws HibernateException, NamingException {
      this.produitsReponseDao.delete(this.produitsReponse);
      this.lesProduitsreponse = this.produitsReponseDao.chargeProdReponseByLab(this.produitsLaboratoire.getProlabId(), 0, (Session)null);
      this.datamodelReponse.setWrappedData(this.lesProduitsreponse);
      this.afficheButtReponse = false;
   }

   public void selectionReponse() {
      if (this.datamodelReponse.isRowAvailable()) {
         this.produitsReponse = (ProduitsReponse)this.datamodelReponse.getRowData();
         this.afficheButtReponse = true;
      }

   }

   public void monterReponse() throws HibernateException, NamingException {
      this.produitsReponse = new ProduitsReponse();
      if (this.datamodelReponse.isRowAvailable()) {
         this.produitsReponse = (ProduitsReponse)this.datamodelReponse.getRowData();
         int var1 = this.produitsReponse.getProrepOrdre();
         long var2 = this.produitsReponse.getProrepId();
         new ProduitsReponse();
         int var5 = this.clauleNumlLigneReponse() - 1;
         this.datamodelReponse.setRowIndex(var5);
         ProduitsReponse var4 = (ProduitsReponse)this.datamodelReponse.getRowData();
         long var6 = var4.getProrepId();
         int var8 = var4.getProrepOrdre();
         this.produitsReponseDao.ordonnnerAscendant(var1, var8, var2, var6);
         this.lesProduitsreponse = this.produitsReponseDao.chargeProdReponseByLab(this.produitsLaboratoire.getProlabId(), 0, (Session)null);
         this.datamodelReponse.setWrappedData(this.lesProduitsreponse);
      }

   }

   public void descendreReponse() throws HibernateException, NamingException {
      this.produitsReponse = new ProduitsReponse();
      if (this.datamodelReponse.isRowAvailable()) {
         this.produitsReponse = (ProduitsReponse)this.datamodelReponse.getRowData();
         int var1 = this.produitsReponse.getProrepOrdre();
         long var2 = this.produitsReponse.getProrepId();
         new ProduitsReponse();
         int var5 = this.clauleNumlLigneReponse() + 1;
         this.datamodelReponse.setRowIndex(var5);
         ProduitsReponse var4 = (ProduitsReponse)this.datamodelReponse.getRowData();
         long var6 = var4.getProrepId();
         int var8 = var4.getProrepOrdre();
         this.produitsReponseDao.ordonnnerDescendant(var1, var8, var2, var6);
         this.lesProduitsreponse = this.produitsReponseDao.chargeProdReponseByLab(this.produitsLaboratoire.getProlabId(), 0, (Session)null);
         this.datamodelReponse.setWrappedData(this.lesProduitsreponse);
      }

   }

   public int clauleNumlLigneReponse() {
      int var1 = 0;
      if (this.lesProduitsreponse.size() != 0) {
         for(int var2 = 0; var2 < this.lesProduitsreponse.size(); ++var2) {
            if (this.produitsReponse.getProrepId() == ((ProduitsReponse)this.lesProduitsreponse.get(var2)).getProrepId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveProduitsReponse() throws HibernateException, NamingException {
      if (this.produitsLaboratoire.getProlabId() == 0L) {
         this.produitsLaboratoire.setProduits(this.produits);
         this.produitsLaboratoire = this.produitsLaboratoireDao.insert(this.produitsLaboratoire);
      }

      this.produitsReponse.setProrepCode(this.produits.getProCode());
      this.produitsReponse.setProduitsLaboratoire(this.produitsLaboratoire);
      this.produitsReponse.setProduitsDetail((ProduitsDetail)null);
      if (this.produitsReponse.getProrepId() == 0L) {
         this.produitsReponse.setProrepOrdre(this.lesProduitsreponse.size() + 1);
         this.produitsReponse = this.produitsReponseDao.insert(this.produitsReponse);
         this.lesProduitsreponse.add(this.produitsReponse);
         this.datamodelReponse.setWrappedData(this.lesProduitsreponse);
      } else {
         this.produitsReponse = this.produitsReponseDao.modif(this.produitsReponse);
      }

      this.afficheButtReponse = false;
   }

   public void ajouterExamenChaine() throws HibernateException, NamingException {
      this.produitsReponse = new ProduitsReponse();
      this.mesExamnensChainesItems.clear();
      new ArrayList();
      List var1 = this.produitsLaboratoireDao.getProduitsLaboratoireExamen();
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            if (((ProduitsLaboratoire)var1.get(var2)).getProduits().getProCode() != null && !((ProduitsLaboratoire)var1.get(var2)).getProduits().getProCode().isEmpty()) {
               this.mesExamnensChainesItems.add(new SelectItem(((ProduitsLaboratoire)var1.get(var2)).getProduits().getProCode(), ((ProduitsLaboratoire)var1.get(var2)).getProduits().getProCode() + ":" + ((ProduitsLaboratoire)var1.get(var2)).getProduits().getProLibClient()));
            }
         }
      }

   }

   public void supprimerExamenChaine() throws HibernateException, NamingException {
      this.produitsReponseDao.delete(this.produitsReponse);
      this.lesProduitsreponse = this.produitsReponseDao.chargeProdReponseByLab(this.produitsLaboratoire.getProlabId(), 0, (Session)null);
      this.datamodelReponse.setWrappedData(this.lesProduitsreponse);
      this.afficheButtReponse = false;
   }

   public void selectionEamenChaine() {
      if (this.datamodelReponse.isRowAvailable()) {
         this.produitsReponse = (ProduitsReponse)this.datamodelReponse.getRowData();
         this.afficheButtReponse = true;
      }

   }

   public void saveProduitsExamenChaine() throws HibernateException, NamingException {
      if (this.produitsLaboratoire.getProlabId() == 0L) {
         this.produitsLaboratoire.setProduits(this.produits);
         this.produitsLaboratoire = this.produitsLaboratoireDao.insert(this.produitsLaboratoire);
      }

      this.produitsReponse.setProrepCode(this.produits.getProCode());
      this.produitsReponse.setProduitsLaboratoire(this.produitsLaboratoire);
      new Produits();
      Produits var1 = this.produitsMedicDao.chargeProduit(this.produitsReponse.getProrepCodeExamen(), (Session)null);
      if (var1 != null) {
         this.produitsReponse.setProrepLibelleExamen(var1.getProLibClient());
         this.produitsReponse.setProduitsDetail((ProduitsDetail)null);
         if (this.produitsReponse.getProrepId() == 0L) {
            this.produitsReponse.setProrepOrdre(this.lesProduitsreponse.size() + 1);
            this.produitsReponse = this.produitsReponseDao.insert(this.produitsReponse);
            this.lesProduitsreponse.add(this.produitsReponse);
            this.datamodelReponse.setWrappedData(this.lesProduitsreponse);
         } else {
            this.produitsReponse = this.produitsReponseDao.modif(this.produitsReponse);
         }
      }

      this.afficheButtReponse = false;
   }

   public void calculeTypeDetail() {
   }

   public void ajouterDetail() {
      this.produitsDetail = new ProduitsDetail();
      this.produitsDetail.setProdetCategorie(this.produitsLaboratoire.getProlabCategorie());
      this.lesProduitsFourchettesDetail.clear();
      this.datamodelFourchetteDetail.setWrappedData(this.lesProduitsFourchettesDetail);
      this.lesProduitsreponseDetail.clear();
      this.datamodelReponseDetail.setWrappedData(this.lesProduitsreponseDetail);
      this.urlphotoInterpretation2 = "";
      this.showModalPanelDetail = true;
   }

   public void modifierDetail() {
      if (this.produitsDetail != null) {
         if (this.produitsDetail.getProdetInterpretation() != null && !this.produitsDetail.getProdetInterpretation().isEmpty()) {
            this.urlphotoInterpretation2 = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "interpretation" + File.separator + this.produitsDetail.getProdetInterpretation();
         } else {
            this.urlphotoInterpretation2 = "";
         }

         this.showModalPanelDetail = true;
      }

   }

   public void supprimerDetail() throws HibernateException, NamingException {
      if (this.produitsDetail != null) {
         this.produitsDetailDao.delete(this.produitsDetail);
         this.lesProduitsDetail = this.produitsDetailDao.chargeProdDetailByLab(this.produitsLaboratoire.getProlabId(), (Session)null);
         this.datamodelDetail.setWrappedData(this.lesProduitsDetail);
         this.afficheButtDetail = false;
      }

   }

   public void selectionDetail() throws HibernateException, NamingException {
      if (this.datamodelDetail.isRowAvailable()) {
         this.produitsDetail = (ProduitsDetail)this.datamodelDetail.getRowData();
         this.afficheButtDetail = true;
         if (this.produitsDetail.getProdetType() == 1) {
            this.produitsFourchetteDao = new ProduitsFourchetteDao(this.baseLog, this.utilInitHibernate);
            this.lesProduitsFourchettesDetail = new ArrayList();
            this.lesProduitsFourchettesDetail = this.produitsFourchetteDao.chargeProdFourchetteByDet(this.produitsDetail.getProdetId(), (Session)null);
            this.datamodelFourchetteDetail.setWrappedData(this.lesProduitsFourchettesDetail);
         } else if (this.produitsDetail.getProdetType() == 5 || this.produitsDetail.getProdetType() == 6 || this.produitsDetail.getProdetType() == 7) {
            this.produitsReponseDao = new ProduitsReponseDao(this.baseLog, this.utilInitHibernate);
            this.lesProduitsreponseDetail = new ArrayList();
            this.lesProduitsreponseDetail = this.produitsReponseDao.chargeProdReponseByDet(this.produitsDetail.getProdetId(), 0, (Session)null);
            this.datamodelReponseDetail.setWrappedData(this.lesProduitsreponseDetail);
         }
      }

   }

   public void monterDetail() throws HibernateException, NamingException {
      this.produitsDetail = new ProduitsDetail();
      if (this.datamodelDetail.isRowAvailable()) {
         this.produitsDetail = (ProduitsDetail)this.datamodelDetail.getRowData();
         int var1 = this.produitsDetail.getProdetOrdre();
         long var2 = this.produitsDetail.getProdetId();
         new ProduitsDetail();
         int var5 = this.clauleNumlLigneDetail() - 1;
         this.datamodelDetail.setRowIndex(var5);
         ProduitsDetail var4 = (ProduitsDetail)this.datamodelDetail.getRowData();
         long var6 = var4.getProdetId();
         int var8 = var4.getProdetOrdre();
         this.produitsDetailDao.ordonnnerAscendant(var1, var8, var2, var6);
         this.lesProduitsDetail = this.produitsDetailDao.chargeProdDetailByLab(this.produitsLaboratoire.getProlabId(), (Session)null);
         this.datamodelDetail.setWrappedData(this.lesProduitsDetail);
      }

   }

   public void descendreDetail() throws HibernateException, NamingException {
      this.produitsDetail = new ProduitsDetail();
      if (this.datamodelDetail.isRowAvailable()) {
         this.produitsDetail = (ProduitsDetail)this.datamodelDetail.getRowData();
         int var1 = this.produitsDetail.getProdetOrdre();
         long var2 = this.produitsDetail.getProdetId();
         new ProduitsDetail();
         int var5 = this.clauleNumlLigneDetail() + 1;
         this.datamodelDetail.setRowIndex(var5);
         ProduitsDetail var4 = (ProduitsDetail)this.datamodelDetail.getRowData();
         long var6 = var4.getProdetId();
         int var8 = var4.getProdetOrdre();
         this.produitsDetailDao.ordonnnerDescendant(var1, var8, var2, var6);
         this.lesProduitsDetail = this.produitsDetailDao.chargeProdDetailByLab(this.produitsLaboratoire.getProlabId(), (Session)null);
         this.datamodelDetail.setWrappedData(this.lesProduitsDetail);
      }

   }

   public int clauleNumlLigneDetail() {
      int var1 = 0;
      if (this.lesProduitsDetail.size() != 0) {
         for(int var2 = 0; var2 < this.lesProduitsDetail.size(); ++var2) {
            if (this.produitsDetail.getProdetId() == ((ProduitsDetail)this.lesProduitsDetail.get(var2)).getProdetId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveProduitsDetail() throws HibernateException, NamingException {
      if (this.produitsLaboratoire.getProlabId() == 0L) {
         this.produitsLaboratoire.setProduits(this.produits);
         this.produitsLaboratoire = this.produitsLaboratoireDao.insert(this.produitsLaboratoire);
      }

      this.produitsDetail.setProdetCode(this.produits.getProCode());
      this.produitsDetail.setProduitsLaboratoire(this.produitsLaboratoire);
      if (this.produitsDetail.getProdetId() == 0L) {
         this.produitsDetail.setProdetOrdre(this.lesProduitsDetail.size() + 1);
         this.produitsDetail = this.produitsDetailDao.insert(this.produitsDetail);
         this.lesProduitsDetail.add(this.produitsDetail);
         this.datamodelDetail.setWrappedData(this.lesProduitsDetail);
      } else {
         this.produitsDetail = this.produitsDetailDao.modif(this.produitsDetail);
      }

      this.afficheButtDetail = false;
      this.showModalPanelDetail = false;
   }

   public void fermerDetail() {
      this.afficheButtDetail = false;
      this.showModalPanelDetail = false;
   }

   public void ajouterFourchetteDetail() {
      this.produitsFourchette = new ProduitsFourchette();
      this.showModalPanelFourchetteDetail = true;
   }

   public void modifierFourchetteDetail() {
      if (this.produitsFourchette != null) {
         this.showModalPanelFourchetteDetail = true;
      }

   }

   public void supprimerFourchetteDetail() throws HibernateException, NamingException {
      if (this.produitsFourchette != null) {
         this.produitsFourchetteDao.delete(this.produitsFourchette);
         this.lesProduitsFourchettesDetail = this.produitsFourchetteDao.chargeProdFourchetteByDet(this.produitsDetail.getProdetId(), (Session)null);
         this.datamodelFourchetteDetail.setWrappedData(this.lesProduitsFourchettesDetail);
      }

      this.afficheButtFourchetteDetail = false;
   }

   public void calculeFourchetteDetail() {
   }

   public void selectionFourchetteDetail() {
      if (this.datamodelFourchetteDetail.isRowAvailable()) {
         this.produitsFourchette = (ProduitsFourchette)this.datamodelFourchetteDetail.getRowData();
         this.afficheButtFourchetteDetail = true;
      }

   }

   public void saveProduitsFourchetteDetail() throws HibernateException, NamingException {
      if (this.produitsDetail.getProdetId() == 0L) {
         this.produitsDetail.setProdetCode(this.produits.getProCode());
         this.produitsDetail.setProduitsLaboratoire(this.produitsLaboratoire);
         this.produitsDetail.setProdetOrdre(this.lesProduitsreponse.size() + 1);
         this.produitsDetail = this.produitsDetailDao.insert(this.produitsDetail);
         this.lesProduitsDetail.add(this.produitsDetail);
         this.datamodelDetail.setWrappedData(this.lesProduitsDetail);
      }

      this.produitsFourchette.setProfchCode(this.produits.getProCode());
      this.produitsFourchette.setProduitsLaboratoire((ProduitsLaboratoire)null);
      this.produitsFourchette.setProduitsDetail(this.produitsDetail);
      if (this.produitsFourchette.getProfchId() == 0L) {
         this.produitsFourchette = this.produitsFourchetteDao.insert(this.produitsFourchette);
         this.lesProduitsFourchettesDetail.add(this.produitsFourchette);
         this.datamodelFourchetteDetail.setWrappedData(this.lesProduitsFourchettesDetail);
      } else {
         this.produitsFourchette = this.produitsFourchetteDao.modif(this.produitsFourchette);
      }

      this.afficheButtFourchetteDetail = false;
      this.showModalPanelFourchetteDetail = false;
   }

   public void ajouterReponseDetail() {
      this.produitsReponse = new ProduitsReponse();
      this.showModalPanelReponseDetail = true;
   }

   public void modifierReponseDetail() {
      this.showModalPanelReponseDetail = true;
   }

   public void supprimerReponseDetail() throws HibernateException, NamingException {
      this.produitsReponseDao.delete(this.produitsReponse);
      this.lesProduitsreponseDetail = this.produitsReponseDao.chargeProdReponseByLab(this.produitsLaboratoire.getProlabId(), 0, (Session)null);
      this.datamodelReponseDetail.setWrappedData(this.lesProduitsreponseDetail);
      this.afficheButtReponseDetail = false;
   }

   public void selectionReponseDetail() {
      if (this.datamodelReponseDetail.isRowAvailable()) {
         this.produitsReponse = (ProduitsReponse)this.datamodelReponseDetail.getRowData();
         this.afficheButtReponseDetail = true;
      }

   }

   public void monterReponseDetail() throws HibernateException, NamingException {
      this.produitsReponse = new ProduitsReponse();
      if (this.datamodelReponseDetail.isRowAvailable()) {
         this.produitsReponse = (ProduitsReponse)this.datamodelReponseDetail.getRowData();
         int var1 = this.produitsReponse.getProrepOrdre();
         long var2 = this.produitsReponse.getProrepId();
         new ProduitsReponse();
         int var5 = this.clauleNumlLigneReponseDetail() - 1;
         this.datamodelReponseDetail.setRowIndex(var5);
         ProduitsReponse var4 = (ProduitsReponse)this.datamodelReponseDetail.getRowData();
         long var6 = var4.getProrepId();
         int var8 = var4.getProrepOrdre();
         this.produitsReponseDao.ordonnnerAscendant(var1, var8, var2, var6);
         this.lesProduitsreponseDetail = this.produitsReponseDao.chargeProdReponseByDet(this.produitsDetail.getProdetId(), 0, (Session)null);
         this.datamodelReponseDetail.setWrappedData(this.lesProduitsreponseDetail);
      }

   }

   public void descendreReponseDetail() throws HibernateException, NamingException {
      this.produitsReponse = new ProduitsReponse();
      if (this.datamodelReponseDetail.isRowAvailable()) {
         this.produitsReponse = (ProduitsReponse)this.datamodelReponseDetail.getRowData();
         int var1 = this.produitsReponse.getProrepOrdre();
         long var2 = this.produitsReponse.getProrepId();
         new ProduitsReponse();
         int var5 = this.clauleNumlLigneReponseDetail() + 1;
         this.datamodelReponse.setRowIndex(var5);
         ProduitsReponse var4 = (ProduitsReponse)this.datamodelReponseDetail.getRowData();
         long var6 = var4.getProrepId();
         int var8 = var4.getProrepOrdre();
         this.produitsReponseDao.ordonnnerDescendant(var1, var8, var2, var6);
         this.lesProduitsreponseDetail = this.produitsReponseDao.chargeProdReponseByDet(this.produitsDetail.getProdetId(), 0, (Session)null);
         this.datamodelReponseDetail.setWrappedData(this.lesProduitsreponseDetail);
      }

   }

   public int clauleNumlLigneReponseDetail() {
      int var1 = 0;
      if (this.lesProduitsreponseDetail.size() != 0) {
         for(int var2 = 0; var2 < this.lesProduitsreponseDetail.size(); ++var2) {
            if (this.produitsReponse.getProrepId() == ((ProduitsReponse)this.lesProduitsreponseDetail.get(var2)).getProrepId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveProduitsReponseDetail() throws HibernateException, NamingException {
      if (this.produitsLaboratoire.getProlabId() == 0L) {
         this.produitsLaboratoire.setProduits(this.produits);
         this.produitsLaboratoire = this.produitsLaboratoireDao.insert(this.produitsLaboratoire);
      }

      if (this.produitsDetail.getProdetId() == 0L) {
         this.produitsDetail.setProdetCode(this.produits.getProCode());
         this.produitsDetail.setProduitsLaboratoire(this.produitsLaboratoire);
         this.produitsDetail.setProdetOrdre(this.lesProduitsDetail.size() + 1);
         this.produitsDetail = this.produitsDetailDao.insert(this.produitsDetail);
         this.lesProduitsDetail.add(this.produitsDetail);
         this.datamodelDetail.setWrappedData(this.lesProduitsDetail);
      }

      this.produitsReponse.setProrepCode(this.produits.getProCode());
      this.produitsReponse.setProduitsLaboratoire((ProduitsLaboratoire)null);
      this.produitsReponse.setProduitsDetail(this.produitsDetail);
      if (this.produitsReponse.getProrepId() == 0L) {
         this.produitsReponse.setProrepOrdre(this.lesProduitsreponseDetail.size() + 1);
         this.produitsReponse = this.produitsReponseDao.insert(this.produitsReponse);
         this.lesProduitsreponseDetail.add(this.produitsReponse);
         this.datamodelReponseDetail.setWrappedData(this.lesProduitsreponseDetail);
      } else {
         this.produitsReponse = this.produitsReponseDao.modif(this.produitsReponse);
      }

      this.afficheButtReponseDetail = false;
      this.showModalPanelReponseDetail = false;
   }

   public void ajouterReponseExamenChaine() throws HibernateException, NamingException {
      this.produitsReponse = new ProduitsReponse();
      this.mesExamnensChainesItems.clear();
      new ArrayList();
      List var1 = this.produitsLaboratoireDao.getProduitsLaboratoireExamen();
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            if (((ProduitsLaboratoire)var1.get(var2)).getProduits().getProCode() != null && !((ProduitsLaboratoire)var1.get(var2)).getProduits().getProCode().isEmpty()) {
               this.mesExamnensChainesItems.add(new SelectItem(((ProduitsLaboratoire)var1.get(var2)).getProduits().getProCode(), ((ProduitsLaboratoire)var1.get(var2)).getProduits().getProCode() + ":" + ((ProduitsLaboratoire)var1.get(var2)).getProduits().getProLibClient()));
            }
         }
      }

      this.showModalPanelReponseExamenChaine = true;
   }

   public void supprimerReponseExamenChaine() throws HibernateException, NamingException {
      this.produitsReponseDao.delete(this.produitsReponse);
      this.lesProduitsreponseDetail = this.produitsReponseDao.chargeProdReponseByLab(this.produitsLaboratoire.getProlabId(), 0, (Session)null);
      this.datamodelReponseDetail.setWrappedData(this.lesProduitsreponseDetail);
      this.afficheButtReponseDetail = false;
   }

   public void selectionReponseExamenChaine() {
      if (this.datamodelReponseDetail.isRowAvailable()) {
         this.produitsReponse = (ProduitsReponse)this.datamodelReponseDetail.getRowData();
         this.afficheButtReponseDetail = true;
      }

   }

   public void saveProduitsReponseExamneChaine() throws HibernateException, NamingException {
      if (this.produitsLaboratoire.getProlabId() == 0L) {
         this.produitsLaboratoire.setProduits(this.produits);
         this.produitsLaboratoire = this.produitsLaboratoireDao.insert(this.produitsLaboratoire);
      }

      if (this.produitsDetail.getProdetId() == 0L) {
         this.produitsDetail.setProdetCode(this.produits.getProCode());
         this.produitsDetail.setProduitsLaboratoire(this.produitsLaboratoire);
         this.produitsDetail.setProdetOrdre(this.lesProduitsDetail.size() + 1);
         this.produitsDetail = this.produitsDetailDao.insert(this.produitsDetail);
         this.lesProduitsDetail.add(this.produitsDetail);
         this.datamodelDetail.setWrappedData(this.lesProduitsDetail);
      }

      this.produitsReponse.setProrepCode(this.produits.getProCode());
      this.produitsReponse.setProduitsLaboratoire((ProduitsLaboratoire)null);
      this.produitsReponse.setProduitsDetail(this.produitsDetail);
      if (this.produitsReponse.getProrepId() == 0L) {
         this.produitsReponse.setProrepOrdre(this.lesProduitsreponseDetail.size() + 1);
         this.produitsReponse = this.produitsReponseDao.insert(this.produitsReponse);
         this.lesProduitsreponseDetail.add(this.produitsReponse);
         this.datamodelReponseDetail.setWrappedData(this.lesProduitsreponseDetail);
      } else {
         this.produitsReponse = this.produitsReponseDao.modif(this.produitsReponse);
      }

      this.afficheButtReponseDetail = false;
      this.showModalPanelReponseExamenChaine = false;
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

   public void selectionTarif() throws JDOMException, IOException {
      if (this.datamodelTarif.isRowAvailable()) {
         this.produitsTarif = (ProduitsTarif)this.datamodelTarif.getRowData();
         this.tarifOrdClt = "" + this.produitsTarif.getProtarOrdre();
         this.inpInactifProdTarif = this.recupererInactifModifProdTar();
         int var1 = this.produitsTarif.getProtarInactif();
         if (var1 != 2) {
            this.afficheButtModifProdTar = true;
         } else {
            this.afficheButtModifProdTar = false;
         }
      }

   }

   public void ajouterTarif() throws JDOMException, IOException, HibernateException, NamingException {
      this.produitsTarif = new ProduitsTarif();
      this.produitsTarif.setProtarCoef(1.0F);
      this.produitsTarif.setProtarLettre(this.produits.getProLettre());
      if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
         this.lettreMedical = this.lettreMedicalDao.selectLettre(this.exercicesVentes.getExevteId(), this.produits.getProLettre(), (Session)null);
         if (this.lettreMedical != null) {
            this.produitsTarif.setProtarValeur(this.lettreMedical.getLetValeur());
            this.valeurLettre = this.lettreMedical.getLetValeur();
            this.produitsTarif.setProtarValeurCnamgs(this.lettreMedical.getLetValeurCnamgs());
            this.valeurLettreCnamgs = this.lettreMedical.getLetValeurCnamgs();
         }
      }

      this.tarifOrdClt = "";
      this.testDoubleProduitsTarif = false;
      this.showModalPanelTarif = true;
   }

   public void modifierTarif() throws HibernateException, NamingException {
      if (this.produitsTarif != null) {
         this.produitsTarif.setProtarLettre(this.produits.getProLettre());
         if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
            this.lettreMedical = this.lettreMedicalDao.selectLettre(this.exercicesVentes.getExevteId(), this.produits.getProLettre(), (Session)null);
            if (this.lettreMedical != null) {
               this.produitsTarif.setProtarValeur(this.lettreMedical.getLetValeur());
               this.valeurLettre = this.lettreMedical.getLetValeur();
               this.produitsTarif.setProtarValeurCnamgs(this.lettreMedical.getLetValeurCnamgs());
               this.valeurLettreCnamgs = this.lettreMedical.getLetValeurCnamgs();
            }
         }

         this.testDoubleProduitsTarif = true;
         this.showModalPanelTarif = true;
      }

   }

   public void saveProduitsTarif() throws HibernateException, NamingException {
      if (this.tarifOrdClt != null && !this.tarifOrdClt.isEmpty()) {
         this.produitsTarif.setProduits(this.produits);
         this.produitsTarif.setProtarLettre(this.produits.getProLettre());
         this.produitsTarif.setProtarValeur(this.valeurLettre);
         this.produitsTarif.setProtarValeurCnamgs(this.valeurLettreCnamgs);
         String var1 = "";
         int var2 = 0;
         float var3 = 0.0F;
         int var4;
         if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
            if (this.tarifOrdClt.equals("-3")) {
               var1 = "UNIQUE";
               var3 = 1.0F;
               var2 = -3;
            } else if (this.lesPecclients.size() != 0) {
               for(var4 = 0; var4 < this.lesPecclients.size(); ++var4) {
                  if (((ObjetCategories)this.lesPecclients.get(var4)).getCode().equals(this.tarifOrdClt)) {
                     var3 = ((ObjetCategories)this.lesPecclients.get(var4)).getCoef();
                     var2 = Integer.parseInt(this.tarifOrdClt);
                     var1 = ((ObjetCategories)this.lesPecclients.get(var4)).getLibelle_FR();
                     break;
                  }
               }
            }
         } else if (this.tarifOrdClt.equals("-3")) {
            var1 = "UNIQUE";
            var3 = 1.0F;
            var2 = -3;
         } else if (this.lesPecclients.size() != 0) {
            for(var4 = 0; var4 < this.lesPecclients.size(); ++var4) {
               if (((ObjetCategories)this.lesPecclients.get(var4)).getCode().equals(this.tarifOrdClt)) {
                  var3 = 1.0F;
                  var2 = Integer.parseInt(this.tarifOrdClt);
                  var1 = ((ObjetCategories)this.lesPecclients.get(var4)).getLibelle_FR();
                  break;
               }
            }
         }

         this.produitsTarif.setProtarClient(var1);
         this.produitsTarif.setProtarOrdre(var2);
         this.produitsTarif.setProtarCoef(var3);
         if (this.produitsTarif.getProtarId() == 0L) {
            this.produitsTarif = this.produitsTarifDao.insert(this.produitsTarif);
            this.lesProduitsTarif.add(this.produitsTarif);
            this.datamodelTarif.setWrappedData(this.lesProduitsTarif);
         } else {
            this.produitsTarif = this.produitsTarifDao.modif(this.produitsTarif);
         }

         this.produits.setProLettre(this.produitsTarif.getProtarLettre());
         this.produits.setProNbUnite(this.produitsTarif.getProtarNb());
         this.produits.setProNbUniteCnamgs(this.produitsTarif.getProtarNbCnamgs());
         this.produits = this.produitsMedicDao.modifProduit(this.produits);
      }

      this.afficheButtModifProdTar = false;
      this.showModalPanelTarif = false;
   }

   public void deleteProduitTarif() throws HibernateException, NamingException {
      if (this.produitsTarif != null) {
         this.produitsTarifDao.delete(this.produitsTarif);
         this.chargerProduitTarifByProd((Session)null);
         this.afficheButtModifProdTar = false;
      }

   }

   public void fermerTarif() {
      this.showModalPanelTarif = false;
   }

   public void reactiverProdTarif() throws HibernateException, NamingException {
      this.produitsTarif.setProtarInactif(0);
      this.produitsTarifDao.modif(this.produitsTarif);
      this.afficheButtModifProdTar = true;
   }

   public void decouperMesTarifItems() throws HibernateException, NamingException {
      if (this.tarifOrdClt != null && !this.tarifOrdClt.isEmpty()) {
         if (this.lesPecclients.size() != 0) {
            String var1 = "";

            for(int var2 = 0; var2 < this.lesPecclients.size(); ++var2) {
               if (((ObjetCategories)this.lesPecclients.get(var2)).getCode().equalsIgnoreCase(this.tarifOrdClt)) {
                  var1 = ((ObjetCategories)this.lesPecclients.get(var2)).getLibelle_FR();
                  break;
               }
            }

            boolean var4 = false;
            if (this.lesProduitsTarif.size() != 0) {
               for(int var3 = 0; var3 < this.lesProduitsTarif.size(); ++var3) {
                  if (((ProduitsTarif)this.lesProduitsTarif.get(var3)).getProtarClient().equalsIgnoreCase(var1)) {
                     var4 = true;
                     break;
                  }
               }
            }

            if (!var4) {
               this.testDoubleProduitsTarif = true;
            } else {
               this.testDoubleProduitsTarif = false;
            }

            this.calculPrixLettre();
            this.calculPrixLettreCnamgs();
         } else {
            this.produitsTarif.setProtarOrdre(0);
            this.produitsTarif.setProtarClient("");
            this.produitsTarif.setProtarPv(0.0D);
            this.produitsTarif.setProtarPvCnamgs(0.0D);
            this.testDoubleProduitsTarif = false;
         }
      } else {
         this.testDoubleProduitsTarif = false;
         this.produitsTarif.setProtarPv(0.0D);
         this.produitsTarif.setProtarPvCnamgs(0.0D);
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

   public void saveLettre() throws HibernateException, NamingException {
      ProduitsTarif var1;
      int var2;
      if (this.choixLettre != null && !this.choixLettre.isEmpty()) {
         this.lettreUtil = true;
         if (this.choixLettre.contains(":")) {
            String[] var7 = this.choixLettre.split(":");
            this.produits.setProLettre(var7[0]);
         } else {
            this.produits.setProLettre(this.choixLettre);
         }

         this.produits = this.produitsMedicDao.modifProduit(this.produits);
         this.lettreMedical = this.lettreMedicalDao.selectLettre(this.exercicesVentes.getExevteId(), this.produits.getProLettre(), (Session)null);
         if (this.lettreMedical != null) {
            this.valeurLettre = this.lettreMedical.getLetValeur();
            this.valeurLettreCnamgs = this.lettreMedical.getLetValeurCnamgs();
         } else {
            this.valeurLettre = 0.0D;
            this.valeurLettreCnamgs = 0.0D;
         }

         if (this.lesProduitsTarif.size() != 0) {
            new ProduitsTarif();

            for(var2 = 0; var2 < this.lesProduitsTarif.size(); ++var2) {
               var1 = (ProduitsTarif)this.lesProduitsTarif.get(var2);
               var1.setProtarCoef(1.0F);
               if (this.lesPecclients.size() != 0) {
                  for(int var3 = 0; var3 < this.lesPecclients.size(); ++var3) {
                     if (((ObjetCategories)this.lesPecclients.get(var3)).getLibelle_FR().equals(var1.getProtarClient())) {
                        var1.setProtarCoef(1.0F);
                        var1.setProtarOrdre(Integer.parseInt(((ObjetCategories)this.lesPecclients.get(var3)).getCode()));
                        break;
                     }
                  }
               }

               var1.setProtarLettre(this.produits.getProLettre());
               var1.setProtarValeur(this.valeurLettre);
               double var8 = var1.getProtarValeur() * (double)var1.getProtarNb() * (double)var1.getProtarCoef();
               var1.setProtarPv(var8);
               var1.setProtarValeurCnamgs(this.valeurLettreCnamgs);
               double var5 = var1.getProtarValeurCnamgs() * (double)var1.getProtarNbCnamgs() * (double)var1.getProtarCoef();
               var1.setProtarPvCnamgs(var5);
               this.produitsTarifDao.modif(var1);
            }
         }
      } else {
         this.lettreUtil = false;
         this.produits.setProLettre("");
         this.produits = this.produitsMedicDao.modifProduit(this.produits);
         if (this.lesProduitsTarif.size() != 0) {
            new ProduitsTarif();

            for(var2 = 0; var2 < this.lesProduitsTarif.size(); ++var2) {
               var1 = (ProduitsTarif)this.lesProduitsTarif.get(var2);
               var1.setProtarLettre("");
               var1.setProtarCoef(1.0F);
               var1.setProtarNb(0.0F);
               var1.setProtarValeur(0.0D);
               var1.setProtarNbCnamgs(0.0F);
               var1.setProtarValeurCnamgs(0.0D);
               this.produitsTarifDao.modif(var1);
            }
         }
      }

   }

   public void calculeLettres() throws HibernateException, NamingException {
      this.calculPrixLettre();
      this.calculPrixLettreCnamgs();
   }

   public void calculPrixLettre() throws HibernateException, NamingException {
      if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
         double var1 = this.utilNombre.myRoundDevise(this.valeurLettre * (double)this.produitsTarif.getProtarNb() * (double)this.produitsTarif.getProtarCoef(), this.structureLog.getStrdevise());
         this.produitsTarif.setProtarPv(var1);
      }

   }

   public void calculPrixLettreCnamgs() throws HibernateException, NamingException {
      if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
         double var1 = this.utilNombre.myRoundDevise(this.valeurLettreCnamgs * (double)this.produitsTarif.getProtarNbCnamgs() * (double)this.produitsTarif.getProtarCoef(), this.structureLog.getStrdevise());
         this.produitsTarif.setProtarPvCnamgs(var1);
      }

   }

   public void selectionTarifConvention() {
      if (this.datamodelTarifConvention.isRowAvailable()) {
         this.conventionMedical = (ConventionMedical)this.datamodelTarifConvention.getRowData();
         this.idTierConvention = this.conventionMedical.getTiers().getTieid();
         this.afficheButtModifProdTarConvention = true;
      }

   }

   public void ajouterTarifConvention() throws HibernateException, NamingException {
      this.conventionMedical = new ConventionMedical();
      this.idTierConvention = 0L;
      if (this.mesTiersClientsItems == null || this.mesTiersClientsItems.size() == 0) {
         this.mesTiersClientsItems = this.tiersDao.chargerLesClientsByIdItems(0, (Session)null);
      }

      this.showModalPanelTarifconvention = true;
   }

   public void modifierTarifConvention() throws HibernateException, NamingException {
      if (this.conventionMedical != null) {
         if (this.mesTiersClientsItems == null || this.mesTiersClientsItems.size() == 0) {
            this.mesTiersClientsItems = this.tiersDao.chargerLesClientsByIdItems(0, (Session)null);
         }

         this.showModalPanelTarifconvention = true;
      }

   }

   public void deleteProduitTarifConvention() throws HibernateException, NamingException {
      if (this.conventionMedical != null) {
         this.conventionMedicalDao.delete(this.conventionMedical);
         this.lesConventions.remove(this.conventionMedical);
         this.datamodelTarifConvention.setWrappedData(this.lesConventions);
      }

   }

   public void fermerTarifConvention() {
      this.showModalPanelTarifconvention = false;
   }

   public void saveTarifConvention() throws HibernateException, NamingException {
      if (this.idTierConvention != 0L) {
         this.conventionMedical.setCvnProduit(this.produits.getProCode());
         this.conventionMedical.setCvnLibelle(this.produits.getProLibClient());
         this.tiers = this.tiersDao.selectTierD(this.idTierConvention);
         if (this.tiers != null) {
            if (this.conventionMedical.getCvnId() == 0L) {
               this.conventionMedical.setCvnDateCreat(new Date());
               this.conventionMedical.setCvnUserCreat(this.usersLog.getUsrid());
               this.conventionMedical.setTiers(this.tiers);
               this.conventionMedical = this.conventionMedicalDao.insert(this.conventionMedical);
               this.lesConventions.add(this.conventionMedical);
               this.datamodelTarifConvention.setWrappedData(this.lesConventions);
            } else {
               this.conventionMedical.setCvnDateModif(new Date());
               this.conventionMedical.setCvnUserModif(this.usersLog.getUsrid());
               this.conventionMedical = this.conventionMedicalDao.modif(this.conventionMedical);
            }
         }
      }

      this.showModalPanelTarifconvention = false;
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

   public void initProduitMotClSelected() {
      if (this.datamodelMotCle.isRowAvailable()) {
         this.produitsMcles = (ProduitsMcles)this.datamodelMotCle.getRowData();
         this.afficheButtModifProdMotCle = true;
      }

   }

   public void ajoutMotCle() {
      this.produitsMcles = new ProduitsMcles();
      this.showModalPanelMotcles = true;
   }

   public void modifMotCle() {
      if (this.produitsMcles != null) {
         this.showModalPanelMotcles = true;
      }

   }

   public void fermerMotcle() {
      this.showModalPanelMotcles = false;
   }

   public void saveProduitsMotCle() throws HibernateException, NamingException {
      if (this.produitsMcles.getPromclId() == 0L) {
         this.produitsMcles.setProduits(this.produits);
         this.produitsMcles = this.produitsMclesDao.insert(this.produitsMcles);
         this.lesProduitsMcles.add(this.produitsMcles);
         this.datamodelMotCle.setWrappedData(this.lesProduitsMcles);
      } else {
         this.produitsMcles.setProduits(this.produits);
         this.produitsMcles = this.produitsMclesDao.modif(this.produitsMcles);
      }

      this.afficheButtModifProdMotCle = false;
      this.showModalPanelMotcles = false;
   }

   public void deleteProduitMotCle() throws HibernateException, NamingException {
      if (this.produitsMcles != null) {
         this.produitsMclesDao.delete(this.produitsMcles);
         this.lesProduitsMcles.remove(this.produitsMcles);
         this.datamodelMotCle.setWrappedData(this.lesProduitsMcles);
         this.afficheButtModifProdMotCle = false;
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
      this.showModalPanelService = true;
   }

   public void fermerService() {
      this.showModalPanelService = false;
   }

   public void saveProduitsServices() throws HibernateException, NamingException {
      this.produitsServices.setProduits(this.produits);
      this.produitsServices.setServices(this.produitsServices.getServices());
      this.produitsServices.setProserCode(this.produitsServices.getProserCode());
      this.produitsServices.setProserNomFr(this.produitsServices.getProserNomFr());
      this.produitsServicesDao.insert(this.produitsServices);
      this.chargerProService();
      this.showModalPanelService = false;
      this.majService();
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

   public void decoupageCodLibService() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.prodCodeLibService != null && !this.prodCodeLibService.isEmpty() && !this.prodCodeLibService.equalsIgnoreCase("0")) {
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

   public void initChargerMouvements() throws NamingException {
      if (this.exercicesVentes != null) {
         this.var_date_debut = this.exercicesVentes.getExevteDateDebut();
         this.var_date_fin = this.exercicesVentes.getExevteDateFin();
      } else {
         this.var_date_debut = new Date();
         this.var_date_fin = new Date();
      }

      this.selRien();
      this.lesMvt = new ArrayList();
      this.datamodelMvt = new ListDataModel();
      this.datamodelMvt.setWrappedData(this.lesMvt);
      this.var_choix_modele = 2;
      this.var_action = 4;
   }

   public void selStock() {
      this.var_mvt_as_inventaire = true;
      this.var_mvt_as_bin = true;
      this.var_mvt_as_bout = true;
      this.var_mvt_as_cession = true;
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
      this.var_mvt_as_ticket = true;
      this.var_mvt_as_cretour = true;
      this.var_mvt_ss_cfacture = false;
      this.var_mvt_ss_cavoir = false;
      this.var_mvt_as_production = true;
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
      this.var_mvt_as_ticket = true;
      this.var_mvt_as_cretour = true;
      this.var_mvt_ss_cfacture = true;
      this.var_mvt_ss_cavoir = true;
      this.var_mvt_as_production = true;
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
      this.var_mvt_as_ticket = false;
      this.var_mvt_as_cretour = false;
      this.var_mvt_ss_cfacture = false;
      this.var_mvt_ss_cavoir = false;
      this.var_mvt_as_production = false;
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
      this.var_mvt_as_ticket = false;
      this.var_mvt_as_cretour = false;
      this.var_mvt_ss_cfacture = false;
      this.var_mvt_ss_cavoir = false;
      this.var_mvt_as_production = false;
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

      String var6 = "";
      if (this.var_activites != null && this.var_activites.contains(":")) {
         String[] var4 = this.var_activites.split(":");
         var6 = var4[0];
      } else {
         var6 = "";
      }

      String var7 = "";
      if (this.var_services != null && this.var_services.contains(":")) {
         var7 = this.var_services;
      } else {
         var7 = "";
      }

      String var5 = "";
      if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
         var5 = this.produits.getProVteNat();
      } else {
         var5 = this.produits.getProAchNat();
      }

      this.lesMvt = var1.chargerMouvements(0, "", var5, this.produits.getProCode(), this.produits.getProLibTech(), var2, 0L, var6, var7, this.var_date_debut, this.var_date_fin, this.var_mvt_ss_fcotation, this.var_mvt_ss_fcommande, this.var_mvt_as_freception, this.var_mvt_as_fsav, this.var_mvt_ss_ffacture, this.var_mvt_ss_favoir, this.var_mvt_as_inventaire, this.var_mvt_as_bin, this.var_mvt_as_bout, this.var_mvt_as_cession, this.var_mvt_as_fabrication, this.var_mvt_ss_cdevis, this.var_mvt_ss_ccmd, this.var_mvt_as_cbl, this.var_mvt_as_cretour, this.var_mvt_ss_cfacture, this.var_mvt_ss_cavoir, this.var_mvt_ss_pump, false, false, this.var_mvt_as_ticket, "0", this.baseLog, this.structureLog, (Session)null);
      this.lesMvt = var1.sort(this.lesMvt);
      this.datamodelMvt.setWrappedData(this.lesMvt);
   }

   public void initChargerStock() throws HibernateException, NamingException {
      this.lesProduitsDepos = new ArrayList();
      this.lesProduitsDepos = this.produitsDepotDao.selectProdDepByprod((Produits)this.produits, (Session)null);
      this.datamodelDepot = new ListDataModel();
      this.datamodelDepot.setWrappedData(this.lesProduitsDepos);
      this.var_action = 6;
   }

   public void recupererFamilleProduitVentesItem(Session var1) throws HibernateException, NamingException {
      this.mesFamillesMedicalItems = new ArrayList();
      this.mesFamillesMedicalItems = this.famillesProduitsMedicalDao.chargerFamilleProduitVentesFamItems(this.lastexoMed.getExevteId(), var1);
      if (this.mesFamillesMedicalItems.size() == 0) {
         this.mesFamillesMedicalItems = this.famillesProduitsMedicalDao.chargerFamilleProduitVentesItems(this.lastexoMed.getExevteId(), var1);
      }

      this.mesCategoriesExamensItems = new ArrayList();
      LectureCategorieExamen var2 = new LectureCategorieExamen();
      this.mesCategoriesExamensItems = var2.getMesCategoriesItems();
   }

   public void recupererDepotItem(Session var1) throws NamingException {
      this.mesDepotItems = new ArrayList();
      ExercicesAchatsDao var2 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      new ExercicesAchats();
      ExercicesAchats var3 = var2.recupererLastExo(var1);
      if (var3 != null) {
         this.mesDepotItems = this.depotAchatsDao.selectActifDepotItems(0, var1);
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
         Produits var1 = this.produitsMedicDao.chargeProduit(this.nouveauCode, (Session)null);
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
         Produits var1 = this.produitsMedicDao.chargeProduit(this.nouveauCode, (Session)null);
         if (var1 == null) {
            this.valideChange = false;
            this.nouveauCode = "";
         } else {
            this.valideChange = true;
         }
      }

   }

   public void valideChangeCodeProduit() throws HibernateException, NamingException, IOException, JDOMException, groovyjarjarcommonscli.ParseException {
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
         new ExercicesAchats();
         ExercicesAchatsDao var8 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
         ExercicesAchats var7 = var8.recupererLastExo(var5);
         ExercicesVentesDao var9 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
         this.exercicesVentes = var9.recupererLastExo(var5);
         if (this.exercicesVentes != null) {
            String var10 = "";
            String var11 = "";
            String[] var12;
            if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && this.nouvelleFamilleAchat.contains(":")) {
               var12 = this.nouvelleFamilleAchat.split(":");
               var10 = var12[0];
            }

            if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && this.nouvelleFamilleVente.contains(":")) {
               var12 = this.nouvelleFamilleVente.split(":");
               var11 = var12[0];
            }

            this.lesProduitsDepos = new ArrayList();
            this.lesProduitsDepos = this.produitsDepotDao.selectProdDepByprod(this.produits, var5);
            if (this.lesProduitsDepos.size() != 0) {
               for(int var20 = 0; var20 < this.lesProduitsDepos.size(); ++var20) {
                  this.produitsDepot = (ProduitsDepot)this.lesProduitsDepos.get(var20);
                  if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                     this.produitsDepot.setProdepCle(this.produitsDepot.getDepot().getDpoCode() + ":" + this.nouveauCode);
                  }

                  this.produitsDepotDao.modif(this.produitsDepot, var5);
               }
            }

            Produits var2;
            FamillesProduitsAchatsDao var13;
            String var14;
            FamillesProduitsAchats var21;
            FamillesProduitsVentesDao var22;
            FamillesProduitsVentes var23;
            EspionDao var24;
            Espion var25;
            if (this.fusionAjout == 0 && this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
               var2 = this.produitsMedicDao.chargeToutProduit(this.nouveauCode, var5);
               if (var2 != null) {
                  if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0") && !this.nouvelleFamilleAchat.equals("0_0_0_0")) {
                     var2.setProAchCode(var10);
                     new FamillesProduitsAchats();
                     var13 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
                     var21 = var13.rechercheFamilleByProd(var7.getExeachId(), var2, var5);
                     if (var21 != null) {
                        var14 = var21.getFamachLibelleFr();
                        var2.setProAchLib(var14);
                     } else {
                        var2.setProAchCode((String)null);
                        var2.setProAchLib((String)null);
                     }
                  } else if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && this.nouvelleFamilleAchat.equals("0_0_0_0")) {
                     var2.setProAchCode((String)null);
                     var2.setProAchLib((String)null);
                  }

                  if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0") && !this.nouvelleFamilleVente.equals("0_0_0_0")) {
                     var2.setProVteCode(var11);
                     new FamillesProduitsVentes();
                     var22 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
                     var23 = var22.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var2, var5);
                     if (var23 != null) {
                        var14 = var23.getFamvteLibelleFr();
                        var2.setProVteLib(var14);
                     } else {
                        var2.setProVteCode((String)null);
                        var2.setProVteLib((String)null);
                     }
                  } else if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && this.nouvelleFamilleVente.equals("0_0_0_0")) {
                     var2.setProVteCode((String)null);
                     var2.setProVteLib((String)null);
                  }

                  this.produitsMedicDao.modifProduit(var2, var5);
                  var25 = new Espion();
                  var24 = new EspionDao(this.baseLog, this.utilInitHibernate);
                  var25.setEspdtecreat(new Date());
                  var25.setUsers(this.usersLog);
                  var25.setEspaction("Procédure de Fusion du code " + this.ancienCode);
                  var25.setEsptype(this.inpTypTar);
                  var24.mAJEspion(var25, var5);
                  var25 = new Espion();
                  var25.setEspdtecreat(new Date());
                  var25.setUsers(this.usersLog);
                  if (this.ancienCode != null && !this.ancienCode.isEmpty() && this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                     var25.setEspaction("Fusion code " + this.ancienCode + " avec le code " + this.nouveauCode);
                  } else if (this.ancienneFamilleAchat != null && !this.ancienneFamilleAchat.isEmpty() && this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty()) {
                     var25.setEspaction("Fusion famille achat " + this.ancienneFamilleAchat + " avec la famille achat " + this.nouvelleFamilleAchat);
                  } else if (this.ancienneFamilleVente != null && !this.ancienneFamilleVente.isEmpty() && this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty()) {
                     var25.setEspaction("Fusion famille vente " + this.ancienneFamilleVente + " avec la famille vente " + this.nouvelleFamilleVente);
                  }

                  var25.setEsptype(this.inpTypTar);
                  var24.mAJEspion(var25, var5);
               }
            } else {
               var2 = this.produitsMedicDao.chargeToutProduit(this.ancienCode, var5);
               if (var2 != null) {
                  if (this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                     var2.setProCode(this.nouveauCode);
                  }

                  if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && !this.nouvelleFamilleAchat.equals("0") && !this.nouvelleFamilleAchat.equals("0_0_0_0")) {
                     var2.setProAchCode(var10);
                     new FamillesProduitsAchats();
                     var13 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
                     var21 = var13.rechercheFamilleByProd(var7.getExeachId(), var2, var5);
                     if (var21 != null) {
                        var14 = var21.getFamachLibelleFr();
                        var2.setProAchLib(var14);
                     } else {
                        var2.setProAchCode((String)null);
                        var2.setProAchLib((String)null);
                     }
                  } else if (this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty() && this.nouvelleFamilleAchat.equals("0_0_0_0")) {
                     var2.setProAchCode((String)null);
                     var2.setProAchLib((String)null);
                  }

                  if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && !this.nouvelleFamilleVente.equals("0") && !this.nouvelleFamilleVente.equals("0_0_0_0")) {
                     var2.setProVteCode(var11);
                     new FamillesProduitsVentes();
                     var22 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
                     var23 = var22.rechercheFamilleByProd(this.exercicesVentes.getExevteId(), var2, var5);
                     if (var23 != null) {
                        var14 = var23.getFamvteLibelleFr();
                        var2.setProVteLib(var14);
                     } else {
                        var2.setProVteCode((String)null);
                        var2.setProVteLib((String)null);
                     }
                  } else if (this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty() && this.nouvelleFamilleVente.equals("0_0_0_0")) {
                     var2.setProVteCode((String)null);
                     var2.setProVteLib((String)null);
                  }

                  this.produitsMedicDao.modifProduit(var2, var5);
                  var25 = new Espion();
                  var24 = new EspionDao(this.baseLog, this.utilInitHibernate);
                  var25.setEspdtecreat(new Date());
                  var25.setUsers(this.usersLog);
                  var25.setEspaction("Procédure de changement du code " + this.ancienCode);
                  var25.setEsptype(this.inpTypTar);
                  var24.mAJEspion(var25, var5);
                  var25 = new Espion();
                  var25.setEspdtecreat(new Date());
                  var25.setUsers(this.usersLog);
                  if (this.ancienCode != null && !this.ancienCode.isEmpty() && this.nouveauCode != null && !this.nouveauCode.isEmpty()) {
                     var25.setEspaction("Change code " + this.ancienCode + " par le code " + this.nouveauCode);
                  } else if (this.ancienneFamilleAchat != null && !this.ancienneFamilleAchat.isEmpty() && this.nouvelleFamilleAchat != null && !this.nouvelleFamilleAchat.isEmpty()) {
                     var25.setEspaction("Change famille achat " + this.ancienneFamilleAchat + " par la famille achat " + this.nouvelleFamilleAchat);
                  } else if (this.ancienneFamilleVente != null && !this.ancienneFamilleVente.isEmpty() && this.nouvelleFamilleVente != null && !this.nouvelleFamilleVente.isEmpty()) {
                     var25.setEspaction("Change famille vente " + this.ancienneFamilleVente + " par la famille vente " + this.nouvelleFamilleVente);
                  }

                  var25.setEsptype(this.inpTypTar);
                  var24.mAJEspion(var25, var5);
               }
            }

            var6.commit();
            var1 = true;
         }
      } catch (HibernateException var18) {
         var1 = false;
         if (var6 != null) {
            var6.rollback();
         }

         throw var18;
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

   public void initPrint() throws IOException {
      this.var_choix_modele = 0;
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
      } else if (this.var_choix_modele == 1) {
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
            JRBeanCollectionDataSource var4 = new JRBeanCollectionDataSource(this.lesProduits);
            this.utilPrint.setjRBeanCollectionDataSource(var4);
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
            String var5 = this.utilDate.dateToStringFr(this.var_date_debut);
            String var6 = this.utilDate.dateToStringFr(this.var_date_fin);
            this.utilPrint.setEntete("Mouvements produit du " + var5 + " au " + var6);
            this.utilPrint.setRequete("");
            this.utilPrint.setFiltre(this.produits.getProCode() + " " + this.produits.getProLibClient());
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "mouvement" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.lesMvt);
            this.utilPrint.setjRBeanCollectionDataSource(var3);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

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

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
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

   public int getFormatdevise() {
      return this.formatdevise;
   }

   public void setFormatdevise(int var1) {
      this.formatdevise = var1;
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

   public String getVar_ServiceFind() {
      return this.var_ServiceFind;
   }

   public void setVar_ServiceFind(String var1) {
      this.var_ServiceFind = var1;
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
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

   public List getLesPecclients() {
      return this.lesPecclients;
   }

   public void setLesPecclients(List var1) {
      this.lesPecclients = var1;
   }

   public List getMesPecClientsItems() {
      return this.mesPecClientsItems;
   }

   public void setMesPecClientsItems(List var1) {
      this.mesPecClientsItems = var1;
   }

   public boolean isAfficheButtPanier() {
      return this.afficheButtPanier;
   }

   public void setAfficheButtPanier(boolean var1) {
      this.afficheButtPanier = var1;
   }

   public int getDesactiveModifprodMotCle() {
      return this.desactiveModifprodMotCle;
   }

   public void setDesactiveModifprodMotCle(int var1) {
      this.desactiveModifprodMotCle = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public FamillesProduitsVentes getFamillesProduitsMedical() {
      return this.famillesProduitsMedical;
   }

   public void setFamillesProduitsMedical(FamillesProduitsVentes var1) {
      this.famillesProduitsMedical = var1;
   }

   public ExercicesComptable getLastexoCompta() {
      return this.lastexoCompta;
   }

   public void setLastexoCompta(ExercicesComptable var1) {
      this.lastexoCompta = var1;
   }

   public ExercicesVentes getLastexoMed() {
      return this.lastexoMed;
   }

   public void setLastexoMed(ExercicesVentes var1) {
      this.lastexoMed = var1;
   }

   public List getMesFamillesMedicalItems() {
      return this.mesFamillesMedicalItems;
   }

   public void setMesFamillesMedicalItems(List var1) {
      this.mesFamillesMedicalItems = var1;
   }

   public OptionMedical getOptionsMedical() {
      return this.optionsMedical;
   }

   public void setOptionsMedical(OptionMedical var1) {
      this.optionsMedical = var1;
   }

   public DataModel getDatamodelProduitsLieRecherche() {
      return this.datamodelProduitsLieRecherche;
   }

   public void setDatamodelProduitsLieRecherche(DataModel var1) {
      this.datamodelProduitsLieRecherche = var1;
   }

   public Produits getProduitsLies() {
      return this.produitsLies;
   }

   public void setProduitsLies(Produits var1) {
      this.produitsLies = var1;
   }

   public boolean isLettreUtil() {
      return this.lettreUtil;
   }

   public void setLettreUtil(boolean var1) {
      this.lettreUtil = var1;
   }

   public List getMesLettresItems() {
      return this.mesLettresItems;
   }

   public void setMesLettresItems(List var1) {
      this.mesLettresItems = var1;
   }

   public String getChoixLettre() {
      return this.choixLettre;
   }

   public void setChoixLettre(String var1) {
      this.choixLettre = var1;
   }

   public double getValeurLettre() {
      return this.valeurLettre;
   }

   public void setValeurLettre(double var1) {
      this.valeurLettre = var1;
   }

   public ProduitsPharmacie getProduitsPharmacie() {
      return this.produitsPharmacie;
   }

   public void setProduitsPharmacie(ProduitsPharmacie var1) {
      this.produitsPharmacie = var1;
   }

   public ProduitsActe getProduitsActe() {
      return this.produitsActe;
   }

   public void setProduitsActe(ProduitsActe var1) {
      this.produitsActe = var1;
   }

   public ProduitsLaboratoire getProduitsLaboratoire() {
      return this.produitsLaboratoire;
   }

   public void setProduitsLaboratoire(ProduitsLaboratoire var1) {
      this.produitsLaboratoire = var1;
   }

   public DataModel getDatamodelFourchette() {
      return this.datamodelFourchette;
   }

   public void setDatamodelFourchette(DataModel var1) {
      this.datamodelFourchette = var1;
   }

   public ProduitsFourchette getProduitsFourchette() {
      return this.produitsFourchette;
   }

   public void setProduitsFourchette(ProduitsFourchette var1) {
      this.produitsFourchette = var1;
   }

   public boolean isAfficheButtFourchette() {
      return this.afficheButtFourchette;
   }

   public void setAfficheButtFourchette(boolean var1) {
      this.afficheButtFourchette = var1;
   }

   public boolean isAfficheButtReponse() {
      return this.afficheButtReponse;
   }

   public void setAfficheButtReponse(boolean var1) {
      this.afficheButtReponse = var1;
   }

   public DataModel getDatamodelReponse() {
      return this.datamodelReponse;
   }

   public void setDatamodelReponse(DataModel var1) {
      this.datamodelReponse = var1;
   }

   public ProduitsReponse getProduitsReponse() {
      return this.produitsReponse;
   }

   public void setProduitsReponse(ProduitsReponse var1) {
      this.produitsReponse = var1;
   }

   public boolean isAfficheButtDetail() {
      return this.afficheButtDetail;
   }

   public void setAfficheButtDetail(boolean var1) {
      this.afficheButtDetail = var1;
   }

   public DataModel getDatamodelDetail() {
      return this.datamodelDetail;
   }

   public void setDatamodelDetail(DataModel var1) {
      this.datamodelDetail = var1;
   }

   public ProduitsDetail getProduitsDetail() {
      return this.produitsDetail;
   }

   public void setProduitsDetail(ProduitsDetail var1) {
      this.produitsDetail = var1;
   }

   public boolean isAfficheButtFourchetteDetail() {
      return this.afficheButtFourchetteDetail;
   }

   public void setAfficheButtFourchetteDetail(boolean var1) {
      this.afficheButtFourchetteDetail = var1;
   }

   public boolean isAfficheButtReponseDetail() {
      return this.afficheButtReponseDetail;
   }

   public void setAfficheButtReponseDetail(boolean var1) {
      this.afficheButtReponseDetail = var1;
   }

   public DataModel getDatamodelFourchetteDetail() {
      return this.datamodelFourchetteDetail;
   }

   public void setDatamodelFourchetteDetail(DataModel var1) {
      this.datamodelFourchetteDetail = var1;
   }

   public DataModel getDatamodelReponseDetail() {
      return this.datamodelReponseDetail;
   }

   public void setDatamodelReponseDetail(DataModel var1) {
      this.datamodelReponseDetail = var1;
   }

   public boolean isShowModalPanelFourchetteDetail() {
      return this.showModalPanelFourchetteDetail;
   }

   public void setShowModalPanelFourchetteDetail(boolean var1) {
      this.showModalPanelFourchetteDetail = var1;
   }

   public boolean isShowModalPanelReponseDetail() {
      return this.showModalPanelReponseDetail;
   }

   public void setShowModalPanelReponseDetail(boolean var1) {
      this.showModalPanelReponseDetail = var1;
   }

   public boolean isShowModalPanelDetail() {
      return this.showModalPanelDetail;
   }

   public void setShowModalPanelDetail(boolean var1) {
      this.showModalPanelDetail = var1;
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

   public boolean isLibelle_libre() {
      return this.libelle_libre;
   }

   public void setLibelle_libre(boolean var1) {
      this.libelle_libre = var1;
   }

   public String getVar_MarqueFind() {
      return this.var_MarqueFind;
   }

   public void setVar_MarqueFind(String var1) {
      this.var_MarqueFind = var1;
   }

   public String getVar_NatureFind() {
      return this.var_NatureFind;
   }

   public void setVar_NatureFind(String var1) {
      this.var_NatureFind = var1;
   }

   public String getVar_LibFind() {
      return this.var_LibFind;
   }

   public void setVar_LibFind(String var1) {
      this.var_LibFind = var1;
   }

   public String getInpActivite() {
      return this.inpActivite;
   }

   public void setInpActivite(String var1) {
      this.inpActivite = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
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

   public String getNomModeleMvts() {
      return this.nomModeleMvts;
   }

   public void setNomModeleMvts(String var1) {
      this.nomModeleMvts = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public boolean isAfficheProgress() {
      return this.afficheProgress;
   }

   public void setAfficheProgress(boolean var1) {
      this.afficheProgress = var1;
   }

   public List getMesDepotItems() {
      return this.mesDepotItems;
   }

   public void setMesDepotItems(List var1) {
      this.mesDepotItems = var1;
   }

   public String getInpFamilleVnt() {
      return this.inpFamilleVnt;
   }

   public void setInpFamilleVnt(String var1) {
      this.inpFamilleVnt = var1;
   }

   public boolean isShowModalPanelTarif() {
      return this.showModalPanelTarif;
   }

   public void setShowModalPanelTarif(boolean var1) {
      this.showModalPanelTarif = var1;
   }

   public boolean isShowModalPanelMotcles() {
      return this.showModalPanelMotcles;
   }

   public void setShowModalPanelMotcles(boolean var1) {
      this.showModalPanelMotcles = var1;
   }

   public boolean isShowModalPanelService() {
      return this.showModalPanelService;
   }

   public void setShowModalPanelService(boolean var1) {
      this.showModalPanelService = var1;
   }

   public boolean isShowModalPanelListeProduit() {
      return this.showModalPanelListeProduit;
   }

   public void setShowModalPanelListeProduit(boolean var1) {
      this.showModalPanelListeProduit = var1;
   }

   public boolean isShowModalPanelFourchette() {
      return this.showModalPanelFourchette;
   }

   public void setShowModalPanelFourchette(boolean var1) {
      this.showModalPanelFourchette = var1;
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

   public boolean isExistCodDepot() {
      return this.existCodDepot;
   }

   public void setExistCodDepot(boolean var1) {
      this.existCodDepot = var1;
   }

   public ProduitsDepot getProduitsDepot() {
      return this.produitsDepot;
   }

   public void setProduitsDepot(ProduitsDepot var1) {
      this.produitsDepot = var1;
   }

   public String getInpDepot() {
      return this.inpDepot;
   }

   public void setInpDepot(String var1) {
      this.inpDepot = var1;
   }

   public boolean isShowModalProduitDepot() {
      return this.showModalProduitDepot;
   }

   public void setShowModalProduitDepot(boolean var1) {
      this.showModalProduitDepot = var1;
   }

   public int getVar_inactif() {
      return this.var_inactif;
   }

   public void setVar_inactif(int var1) {
      this.var_inactif = var1;
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

   public boolean isVar_mvt_as_ticket() {
      return this.var_mvt_as_ticket;
   }

   public void setVar_mvt_as_ticket(boolean var1) {
      this.var_mvt_as_ticket = var1;
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

   public boolean isVar_mvt_ss_pump() {
      return this.var_mvt_ss_pump;
   }

   public void setVar_mvt_ss_pump(boolean var1) {
      this.var_mvt_ss_pump = var1;
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

   public double getValeurLettreCnamgs() {
      return this.valeurLettreCnamgs;
   }

   public void setValeurLettreCnamgs(double var1) {
      this.valeurLettreCnamgs = var1;
   }

   public String getVar_tarif1() {
      return this.var_tarif1;
   }

   public void setVar_tarif1(String var1) {
      this.var_tarif1 = var1;
   }

   public String getVar_tarif10() {
      return this.var_tarif10;
   }

   public void setVar_tarif10(String var1) {
      this.var_tarif10 = var1;
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

   public boolean isVar_mvt_as_fabrication() {
      return this.var_mvt_as_fabrication;
   }

   public void setVar_mvt_as_fabrication(boolean var1) {
      this.var_mvt_as_fabrication = var1;
   }

   public boolean isVar_mvt_as_production() {
      return this.var_mvt_as_production;
   }

   public void setVar_mvt_as_production(boolean var1) {
      this.var_mvt_as_production = var1;
   }

   public boolean isShowModalProduitRecherche() {
      return this.showModalProduitRecherche;
   }

   public void setShowModalProduitRecherche(boolean var1) {
      this.showModalProduitRecherche = var1;
   }

   public String getAncienCode() {
      return this.ancienCode;
   }

   public void setAncienCode(String var1) {
      this.ancienCode = var1;
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

   public int getFusionAjout() {
      return this.fusionAjout;
   }

   public void setFusionAjout(int var1) {
      this.fusionAjout = var1;
   }

   public String getNouveauCode() {
      return this.nouveauCode;
   }

   public void setNouveauCode(String var1) {
      this.nouveauCode = var1;
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

   public boolean isValideChange() {
      return this.valideChange;
   }

   public void setValideChange(boolean var1) {
      this.valideChange = var1;
   }

   public List getMesCategoriesExamensItems() {
      return this.mesCategoriesExamensItems;
   }

   public void setMesCategoriesExamensItems(List var1) {
      this.mesCategoriesExamensItems = var1;
   }

   public String getUrlphotoInterpretation1() {
      return this.urlphotoInterpretation1;
   }

   public void setUrlphotoInterpretation1(String var1) {
      this.urlphotoInterpretation1 = var1;
   }

   public String getUrlphotoInterpretation2() {
      return this.urlphotoInterpretation2;
   }

   public void setUrlphotoInterpretation2(String var1) {
      this.urlphotoInterpretation2 = var1;
   }

   public DataModel getDatamodelTarifConvention() {
      return this.datamodelTarifConvention;
   }

   public void setDatamodelTarifConvention(DataModel var1) {
      this.datamodelTarifConvention = var1;
   }

   public ConventionMedical getConventionMedical() {
      return this.conventionMedical;
   }

   public void setConventionMedical(ConventionMedical var1) {
      this.conventionMedical = var1;
   }

   public boolean isAfficheButtModifProdTarConvention() {
      return this.afficheButtModifProdTarConvention;
   }

   public void setAfficheButtModifProdTarConvention(boolean var1) {
      this.afficheButtModifProdTarConvention = var1;
   }

   public boolean isShowModalPanelTarifconvention() {
      return this.showModalPanelTarifconvention;
   }

   public void setShowModalPanelTarifconvention(boolean var1) {
      this.showModalPanelTarifconvention = var1;
   }

   public List getMesTiersClientsItems() {
      return this.mesTiersClientsItems;
   }

   public void setMesTiersClientsItems(List var1) {
      this.mesTiersClientsItems = var1;
   }

   public long getIdTierConvention() {
      return this.idTierConvention;
   }

   public void setIdTierConvention(long var1) {
      this.idTierConvention = var1;
   }

   public String getService1Facture() {
      return this.service1Facture;
   }

   public void setService1Facture(String var1) {
      this.service1Facture = var1;
   }

   public String getService2Facture() {
      return this.service2Facture;
   }

   public void setService2Facture(String var1) {
      this.service2Facture = var1;
   }

   public String getService3Facture() {
      return this.service3Facture;
   }

   public void setService3Facture(String var1) {
      this.service3Facture = var1;
   }

   public String getService4Facture() {
      return this.service4Facture;
   }

   public void setService4Facture(String var1) {
      this.service4Facture = var1;
   }

   public String getService5Facture() {
      return this.service5Facture;
   }

   public void setService5Facture(String var1) {
      this.service5Facture = var1;
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

   public List getMesExamnensChainesItems() {
      return this.mesExamnensChainesItems;
   }

   public void setMesExamnensChainesItems(List var1) {
      this.mesExamnensChainesItems = var1;
   }

   public boolean isShowModalPanelReponseExamenChaine() {
      return this.showModalPanelReponseExamenChaine;
   }

   public void setShowModalPanelReponseExamenChaine(boolean var1) {
      this.showModalPanelReponseExamenChaine = var1;
   }
}
