package com.epegase.forms.tiers;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ElevesContact;
import com.epegase.systeme.classe.ElevesFacture;
import com.epegase.systeme.classe.ElevesInscription;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FilieresEducation;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.ElevesContactDao;
import com.epegase.systeme.dao.ElevesDao;
import com.epegase.systeme.dao.ElevesFactureDao;
import com.epegase.systeme.dao.ElevesInscriptionDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FilieresEducationDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RacinesDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilSms;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionTiers;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
import org.richfaces.taglib.GmapTag;

public class FormEleves implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private String pageIndex;
   private ObjetLigneMenu ligneMenu;
   private Eleves eleves;
   private ElevesDao elevesDao;
   private ExercicesVentes exercicesVentes;
   private OptionVentes optionVentes;
   private OptionTiers optionTiers;
   private String libelleSousMenu;
   private URI uri;
   private boolean showModalGoogleMap = false;
   private int var_nb_max = 100;
   private EspionDao espionDao;
   private int nature;
   private FormRecherche formRecherche;
   private boolean reglementAutorise = true;
   private UserDao userDao;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private String requete;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private int var_choix_modele;
   private String nomModeleDocument;
   private String nomModeleListe;
   private long nomModeleRecu;
   private boolean visibleOptionMail = false;
   private boolean affListeDoc = false;
   private boolean showModalPanelPrint = false;
   private String nom;
   private String prenom;
   private String categorie;
   private String dossier;
   private String telephone;
   private String carteIdentite;
   private long filiere;
   private List mesdevisesItem;
   private List mesCivilitesItems;
   private List lesEleves = new ArrayList();
   private transient DataModel dataModelEleves = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean afficheButtOption = false;
   private int tiersPayant;
   private List mesFamilleClientsItems;
   private List lesFamilleClientsListe;
   private boolean modalGoogleMap = false;
   private GmapTag gmapTag;
   private String place;
   private Chrono chrono;
   private ChronoDao chronoDao;
   private CalculChrono calculChrono;
   private boolean valideEleves;
   private List mesFiliairesItems = new ArrayList();
   private FilieresEducation filieresEducation;
   private FilieresEducationDao filieresEducationDao;
   private ElevesContact elevesContact;
   private ElevesContactDao elevesContactDao;
   private transient DataModel datamodelContact = new ListDataModel();
   private List lesContacts = new ArrayList();
   private boolean afficheButtContact = false;
   private int var_actionContact;
   private boolean showModalPanelCnt = false;
   private List mesTypeReglementsCaisse = new ArrayList();
   private List listCaisses;
   private List mesCaissesSeriesItems = new ArrayList();
   private BonEncaissementVente bonEncaissementVente;
   private BonEncaissementVenteDao bonEncaissementVenteDao;
   private double var_tot_bon_encaissement;
   private boolean var_affiche_be = false;
   private boolean var_affiche_dollar = false;
   private boolean var_affiche_valide = false;
   private double montantElmTotBonEnc;
   private double totalPayerTimbre;
   private ReglementsDao reglementsDao;
   private boolean afficheRecu;
   private boolean var_verouxModReg;
   private boolean var_affichMontant;
   private String var_inputCaisse;
   private double var_netAPayer;
   private boolean showModalPanelPaye = false;
   private String var_nom_client;
   private String var_num_facture;
   private String var_montant;
   private String var_modele_trf;
   private Date var_date_trf;
   private transient DataModel datamodelTransfert = new ListDataModel();
   private List lstReg;
   private boolean showModalPanelReglement = false;
   private List listFactureSelectionne = new ArrayList();
   private Reglements reglements;
   private Reglements memoReglements;
   private boolean var_affiche_banque = false;
   private String var_type_reg;
   private int varTypeReg;
   private String var_objet;
   private String var_banque_tireur;
   private String var_num_cheque;
   private List mesModesleRecus = new ArrayList();
   private String nomRepMod;
   private double val_timbre;
   private double var_ecart_reglement;
   private String var_banque_destination;
   private boolean var_affiche_banque_destination = false;
   private List mesBanquesItems = new ArrayList();
   private CaissesCommerciales caissesCommerciales;
   private CaissesCommercialesDao caissesCommercialesDao;
   private boolean repartitionManuelle;
   private double totManuel;
   private double ecartManuel;
   private boolean showModalPanelPrintRecu = false;
   private boolean showModalPanelHistoReglement = false;
   private transient DataModel datamodelReglement = new ListDataModel();
   private List lesReglements = new ArrayList();
   private boolean testModeCalcul = false;
   private List lesReglementsClient;
   private List mesReglementClientItems;
   private UtilDownload utilDownload = new UtilDownload();
   private String urlphoto;
   private String fileName;
   private String pdfFileName;
   private UploadedFile uploadedFile;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private boolean showModalPanelSms = false;
   private String numeroMobile;
   private String messageSms;
   private String urlphotoAgent;
   private UploadedFile uploadedPDFFile;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private transient DataModel dataModelDocumnts = new ListDataModel();
   private List lesDocuments = new ArrayList();
   private String nomRepertoire;
   private boolean showModalPanelPj = false;
   private boolean showModalPanelAjoutFile = false;
   private String nomDocument;
   private boolean afficheButtInscription;
   private transient DataModel datamodelInscription = new ListDataModel();
   private List lesInscriptions = new ArrayList();
   private ElevesInscription elevesInscription;
   private ElevesInscriptionDao elevesInscriptionDao;
   private int var_actionInscription;
   private boolean showModalPanelInscription = false;
   private long var_filiere;
   private String site;
   private String departement;
   private String service;
   private String region;
   private String secteur;
   private String pdv;
   private String caisse;
   private long responsable;
   private long commercial;
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private Habilitation habilitation;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private int var_actionFacture;
   private ElevesFacture elevesFacture;
   private ElevesFactureDao elevesFactureDao;
   private UtilDate utilDate = new UtilDate();
   private boolean autorisationInscription;
   private transient DataModel datamodelFacturation = new ListDataModel();
   private List lesFactures = new ArrayList();
   private UtilNombre utilNombre = new UtilNombre();
   private boolean afficheButtFacture = false;
   private boolean showModalPanelFacture = false;
   private boolean showModalPanelPrintSituation = false;
   private List documentImpressionItems = new ArrayList();
   private List listeImpressionItems = new ArrayList();
   private double totalFacture;
   private double totalReglement;
   private double sode;
   private List listeRecuItems = new ArrayList();
   private List mesCompteItem = new ArrayList();
   private int choixCompte;
   private String compte;
   private boolean showModalPanelImmatriculation = false;
   private int compteModif;
   private List mesNatureCompteItem = new ArrayList();
   private String maNature;
   private List mesRacineCompteItem;
   private String maRacine;
   private String racinecle;
   private String partieCompte;
   private boolean existeCopteDeja = true;
   private long exoCpte;
   private int nombrCaracter;
   private ExercicesComptable exerciceSelectionne;
   private PlanComptable planComptable;
   private PlanComptableDao planComptableDao;
   private int choixRacine;
   private String selecFiscalite;

   public FormEleves() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.elevesDao = new ElevesDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.elevesContactDao = new ElevesContactDao(this.baseLog, this.utilInitHibernate);
      this.filieresEducationDao = new FilieresEducationDao(this.baseLog, this.utilInitHibernate);
      this.elevesInscriptionDao = new ElevesInscriptionDao(this.baseLog, this.utilInitHibernate);
      this.elevesFactureDao = new ElevesFactureDao(this.baseLog, this.utilInitHibernate);
      this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.caisse, this.utilInitHibernate);
   }

   public void recupererOptionsEducation(Session var1) throws ParseException, HibernateException, NamingException {
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      var2.lancer();
      this.optionVentes = var2.getOptionsVentes();
      if (this.optionVentes.getNbLigneMax() != null && !this.optionVentes.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionVentes.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.mesFiliairesItems.clear();
      this.mesFiliairesItems = this.filieresEducationDao.mesFilieresItems(var1);
      this.chargerMesracines();
   }

   public void chargerMesracines() {
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && (this.choixRacine == 2 || this.choixRacine == 0)) {
         this.choixRacine = 1;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      } else if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.choixRacine == 1) {
         this.choixRacine = 2;
         this.selecFiscalite = this.structureLog.getStrzonefiscale2();
      } else {
         this.choixRacine = 0;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      }

   }

   public void permutterRacines() throws HibernateException, NamingException {
      this.chargerMesracines();
      this.compte = "0";
      this.maNature = "0";
      this.maRacine = "0";
      this.racinecle = "";
      this.partieCompte = "";
      this.planComptable.setPlcCompte("");
      this.existeCopteDeja = true;
      String var1;
      if (this.choixCompte == 0) {
         var1 = "(7)";
         this.mesCompteItem = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.exerciceSelectionne.getExecpt_id(), var1, 0, (Session)null);
      } else if (this.choixCompte == 1) {
         this.chargeRacineCompte();
      } else if (this.choixCompte == 2) {
         var1 = "(90)";
         this.mesCompteItem = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.exerciceSelectionne.getExecpt_id(), var1, 0, (Session)null);
      }

   }

   public void recupererExerciceEducation(Session var1) throws HibernateException, NamingException {
      this.exercicesVentes = new ExercicesVentes();
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentes = var2.recupererLastExo(var1);
   }

   public void calculeFiliereRecherche() throws HibernateException, NamingException {
      if (this.filiere != 0L) {
         this.filieresEducation = this.filieresEducationDao.pourParapheur(this.filiere, (Session)null);
      } else {
         this.filieresEducation = null;
      }

   }

   public void chargerDepartement() throws HibernateException, NamingException {
      this.mesDepartementsItems.clear();
      this.mesServicesItems.clear();
      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         new ArrayList();
         String[] var2 = this.site.split(":");
         new Site();
         SiteDao var4 = new SiteDao(this.baseLog, this.utilInitHibernate);
         Site var3 = var4.rechercheSite(var2[0], (Session)null);
         if (var3 != null) {
            DepartementDao var5 = new DepartementDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listDepartementBySit((Site)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesDepartementsItems.add(new SelectItem(((Departement)var1.get(var6)).getDepCode() + ":" + ((Departement)var1.get(var6)).getDepNomFr()));
               }
            }
         }
      }

   }

   public void chargerService() throws HibernateException, NamingException {
      this.mesServicesItems.clear();
      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         new ArrayList();
         String[] var2 = this.departement.split(":");
         new Departement();
         DepartementDao var4 = new DepartementDao(this.baseLog, this.utilInitHibernate);
         Departement var3 = var4.rechercheDepartement(var2[0], (Session)null);
         if (var3 != null) {
            ServiceDao var5 = new ServiceDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listServiceByDep((Departement)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesServicesItems.add(new SelectItem(((Service)var1.get(var6)).getSerCode() + ":" + ((Service)var1.get(var6)).getSerNomFr()));
               }
            }
         }
      }

   }

   public void chargerSecteur() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         new ArrayList();
         String[] var2 = this.region.split(":");
         new Region();
         RegionDao var4 = new RegionDao(this.baseLog, this.utilInitHibernate);
         Region var3 = var4.rechercheRegion(var2[0], (Session)null);
         if (var3 != null) {
            SecteurDao var5 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listSecteurByRegion((Region)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesSecteursItems.add(new SelectItem(((Secteur)var1.get(var6)).getSecCode() + ":" + ((Secteur)var1.get(var6)).getSecNomFr()));
               }
            }
         }
      }

   }

   public void chargerPdv() throws HibernateException, NamingException {
      this.mesPdvItems.clear();
      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         new ArrayList();
         String[] var2 = this.secteur.split(":");
         new Secteur();
         SecteurDao var4 = new SecteurDao(this.baseLog, this.utilInitHibernate);
         Secteur var3 = var4.rechercheSecteur(var2[0], (Session)null);
         if (var3 != null) {
            PointDeVenteDao var5 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listPdvBySecteur((Secteur)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesPdvItems.add(new SelectItem(((PointDeVente)var1.get(var6)).getPdvCode() + ":" + ((PointDeVente)var1.get(var6)).getPdvNomFr()));
               }
            }
         }
      }

   }

   public void chargerLesEleves() throws HibernateException, NamingException {
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.dataModelEleves = new ListDataModel();
      this.lesEleves = new ArrayList();
      this.lesEleves = this.elevesDao.chargerListEleves(this.rechercherEleves(), this.filiere, (Session)null);
      this.dataModelEleves.setWrappedData(this.lesEleves);
   }

   public String rechercherEleves() {
      String var1 = "";
      if (this.filiere != 0L) {
         var1 = "from ElevesInscription where eleves.eleId>0 and filieresEducation.filId=" + this.filiere;
         if (this.nom != null && !this.nom.isEmpty()) {
            var1 = var1 + " and eleves.eleNom LIKE '" + this.nom + "%'";
         }

         if (this.prenom != null && !this.prenom.isEmpty()) {
            var1 = var1 + " and eleves.elePrenom LIKE '" + this.prenom + "%'";
         }

         if (this.dossier != null && !this.dossier.isEmpty()) {
            var1 = var1 + " and eleves.eleDossier LIKE '" + this.dossier + "%'";
         }

         if (this.telephone != null && !this.telephone.isEmpty()) {
            var1 = var1 + " and (eleves.eleCel1 LIKE '" + this.telephone + "%' or eleves.eleCel2 LIKE '" + this.telephone + "%' or eleves.eleCel3 LIKE '" + this.telephone + "%' or eleves.eleTelDom LIKE '" + this.telephone + "%' or eleves.eleTelVoiture LIKE '" + this.telephone + "%')";
         }

         if (this.carteIdentite != null && !this.carteIdentite.isEmpty()) {
            var1 = var1 + " and (eleves.eleCi= '" + this.carteIdentite + "%' or eleves.eleSecu='" + this.carteIdentite + "')";
         }
      } else {
         var1 = "from Eleves where eleId>0 ";
         if (this.nom != null && !this.nom.isEmpty()) {
            var1 = var1 + " and eleNom LIKE '" + this.nom + "%'";
         }

         if (this.prenom != null && !this.prenom.isEmpty()) {
            var1 = var1 + " and elePrenom LIKE '" + this.prenom + "%'";
         }

         if (this.dossier != null && !this.dossier.isEmpty()) {
            var1 = var1 + " and eleDossier LIKE '" + this.dossier + "%'";
         }

         if (this.telephone != null && !this.telephone.isEmpty()) {
            var1 = var1 + " and (eleCel1 LIKE '" + this.telephone + "%' or eleCel2 LIKE '" + this.telephone + "%' or eleCel3 LIKE '" + this.telephone + "%' or eleTelDom LIKE '" + this.telephone + "%' or eleTelVoiture LIKE '" + this.telephone + "%')";
         }

         if (this.carteIdentite != null && !this.carteIdentite.isEmpty()) {
            var1 = var1 + " and (eleCi= '" + this.carteIdentite + "%' or eleSecu='" + this.carteIdentite + "')";
         }
      }

      return var1;
   }

   public void selectionEleve() throws JDOMException, IOException, NamingException, SQLException {
      this.eleves = new Eleves();
      this.afficheButtContact = false;
      this.afficheButtInscription = false;
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
            this.eleves = (Eleves)var1.get(0);
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
            this.chargerContact(var4);
            this.chargerInscription(var4);
            this.chargerFactures(var4);
            this.chargerUserChrono(var4);
            this.chargerDocumentScan();
            this.affichePhoto();
            this.utilInitHibernate.closeSession();
            this.afficheButtOption = true;
         } else {
            this.afficheButtOption = false;
         }
      } else {
         this.afficheButtOption = false;
      }

   }

   public void visualisationEleve() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.eleves != null) {
         this.consulterTiers();
      }

   }

   public void chargerContact(Session var1) throws HibernateException, NamingException {
      this.lesContacts.clear();
      this.lesContacts = this.elevesContactDao.chargerLesElevesContact(this.eleves, var1);
      this.datamodelContact.setWrappedData(this.lesContacts);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.eleves != null && this.eleves.getEleSerie() != null && !this.eleves.getEleSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.eleves.getEleSerie(), 102, this.usersLog, var1);
         if (this.usersChrono != null) {
            this.autorisationInscription = true;
         } else {
            this.autorisationInscription = false;
         }
      }

   }

   public void chargerInscription(Session var1) throws HibernateException, NamingException {
      this.lesInscriptions.clear();
      if (this.eleves != null) {
         this.lesInscriptions = this.elevesInscriptionDao.chargerLesElevesInscription(this.eleves, var1);
      }

      this.datamodelInscription.setWrappedData(this.lesInscriptions);
   }

   public void chargerFactures(Session var1) throws HibernateException, NamingException {
      this.totalFacture = 0.0D;
      this.totalReglement = 0.0D;
      this.sode = 0.0D;
      this.lesFactures.clear();
      if (this.eleves != null) {
         this.lesFactures = this.elevesFactureDao.chargerLesElevesFacture(this.eleves, var1);
         if (this.lesFactures.size() != 0) {
            for(int var2 = 0; var2 < this.lesFactures.size(); ++var2) {
               this.totalFacture += ((ElevesFacture)this.lesFactures.get(var2)).getTotalTtc();
               this.totalReglement += ((ElevesFacture)this.lesFactures.get(var2)).getElefacReglement();
            }
         }

         this.sode = this.totalFacture - this.totalReglement;
      }

      this.datamodelFacturation.setWrappedData(this.lesFactures);
      this.afficheButtFacture = false;
   }

   public void chargerReglement(Session var1) throws HibernateException, NamingException {
      this.lesReglements = new ArrayList();
      this.listeRecuItems.clear();
      if (this.eleves != null && this.elevesFacture != null) {
         this.lesReglements = this.reglementsDao.rechercheByTiersEleve(this.eleves, this.elevesFacture.getElefacId(), var1);
         if (this.lesReglements.size() != 0) {
            for(int var2 = 0; var2 < this.lesReglements.size(); ++var2) {
               this.listeRecuItems.add(new SelectItem(((Reglements)this.lesReglements.get(var2)).getRglId(), ((Reglements)this.lesReglements.get(var2)).getRglNum()));
            }
         }

         this.var_tot_bon_encaissement = 0.0D;
         new ArrayList();
         List var4 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.elevesFacture.getElefacId(), 102, var1);
         if (var4.size() != 0) {
            for(int var3 = 0; var3 < var4.size(); ++var3) {
               if (((BonEncaissementVente)var4.get(var3)).getBonEtat() == 0) {
                  this.var_tot_bon_encaissement += ((BonEncaissementVente)var4.get(var3)).getBonAPayer();
               }
            }
         }
      }

      this.datamodelReglement.setWrappedData(this.lesReglements);
   }

   public void chargerDocumentScan() throws IOException {
      this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Eleves" + File.separator;
      this.lesDocuments.clear();
      if (this.eleves != null && this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         File var1 = new File(this.nomRepertoire);
         if (!var1.exists()) {
            var1.mkdir();
         }

         String var2 = this.eleves.getEleDossier();
         String[] var3 = var1.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if ((var3[var4].endsWith(".pdf") || var3[var4].endsWith(".PDF")) && var3[var4].startsWith(var2)) {
                  this.lesDocuments.add(var3[var4]);
               }
            }
         }
      }

      this.dataModelDocumnts.setWrappedData(this.lesDocuments);
   }

   public void ajouterTiers() {
      this.eleves = new Eleves();
      this.eleves.setEleDateNaissance((Date)null);
      this.eleves.setEleTypereg(0);
      this.eleves.setElePaysNaissance(this.structureLog.getStrnompays());
      this.eleves.setElePays(this.structureLog.getStrnompays());
      this.urlphoto = "";
      if (this.optionVentes.getChronoMatricule().equals("1")) {
         this.valideEleves = false;
      } else {
         this.valideEleves = true;
      }

      this.lesContacts.clear();
      this.datamodelContact.setWrappedData(this.lesContacts);
      this.lesInscriptions.clear();
      this.datamodelInscription.setWrappedData(this.lesInscriptions);
      this.lesFactures.clear();
      this.datamodelFacturation.setWrappedData(this.lesFactures);
      this.lesReglements.clear();
      this.datamodelReglement.setWrappedData(this.lesReglements);
      this.lesDocuments.clear();
      this.dataModelDocumnts.setWrappedData(this.lesDocuments);
      this.var_action = 1;
   }

   public void modifierTiers() {
      this.valideEleves = true;
      this.var_action = 2;
   }

   public void consulterTiers() {
      this.valideEleves = true;
      this.var_action = 3;
   }

   public void annuleSaisie() {
      this.var_action = 0;
      this.afficheButtOption = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void calculeUnicite() throws HibernateException, NamingException {
      if (this.eleves.getEleDossier() != null && !this.eleves.getEleDossier().isEmpty()) {
         if (this.eleves.getEleSerie() == null || this.eleves.getEleSerie().isEmpty()) {
            this.eleves.setEleSerie("A");
         }

         String var1 = this.calculChrono.dossierFormattage(this.eleves.getEleDossier(), new Date(), 100, this.eleves.getEleSerie(), (Session)null);
         this.eleves.setEleDossier(var1);
         boolean var2 = this.elevesDao.verifUnicite(var1, (Session)null);
         if (!var2) {
            this.valideEleves = true;
         } else {
            this.valideEleves = false;
            this.eleves.setEleDossier("");
         }
      }

   }

   public void majEleve() throws HibernateException, NamingException {
      if (this.eleves.getEleNom() != null && !this.eleves.getEleNom().isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.eleves.getEleId() != 0L) {
               this.eleves.setEleDateModif(new Date());
               this.eleves.setEleUserModif(this.usersLog.getUsrid());
               this.eleves = this.elevesDao.modif(this.eleves, var1);
               this.var_action = 0;
            } else {
               if (this.lesFamilleClientsListe.size() != 0) {
                  for(int var3 = 0; var3 < this.lesFamilleClientsListe.size(); ++var3) {
                     new ObjetFamilleTiers();
                     ObjetFamilleTiers var4 = (ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3);
                     if (this.eleves.getEleNomFamille().equalsIgnoreCase(var4.getLibelle())) {
                        break;
                     }
                  }
               }

               if (this.eleves.getEleSerie() == null || this.eleves.getEleSerie().isEmpty()) {
                  this.eleves.setEleSerie("A");
               }

               if (this.optionVentes.getChronoMatricule().equals("0")) {
                  this.eleves.setEleDossier(this.numComposeDossier(var1));
               }

               if (this.eleves.getEleDossier() != null && !this.eleves.getEleDossier().isEmpty()) {
                  this.eleves.setEleDateCreat(new Date());
                  this.eleves.setEleUserCreat(this.usersLog.getUsrid());
                  this.eleves = this.elevesDao.insert(this.eleves, var1);
                  this.lesEleves.add(this.eleves);
                  this.dataModelEleves.setWrappedData(this.lesEleves);
                  this.var_action = 2;
                  this.simpleSelectionEntete.clear();
                  this.extDTable = new HtmlExtendedDataTable();
               } else {
                  this.var_action = 0;
               }
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
      } else {
         this.var_action = 0;
      }

   }

   public String numComposeDossier(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      if (this.eleves.getEleSerie() == null || this.eleves.getEleSerie().isEmpty()) {
         this.eleves.setEleSerie("A");
      }

      String var3 = this.eleves.getEleSerie();
      byte var4 = 100;
      long var5 = 0L;
      this.chrono = new Chrono();
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.chrono = this.chronoDao.chronoBySerieNat(var3, var4, var1);
      Eleves var7;
      if (this.chrono != null && this.chrono.getChrMode() == 0) {
         var7 = this.elevesDao.eleveBySerieAnneeDate(var3, this.eleves.getEleDateCreat(), var1);
         if (var7 != null) {
            var5 = 0L;
         } else {
            var5 = this.chrono.getChrNum();
         }
      } else if (this.chrono != null && this.chrono.getChrMode() == 1) {
         var7 = this.elevesDao.eleveBySerieMoisDate(var3, this.eleves.getEleDateCreat(), var1);
         if (var7 != null) {
            var5 = 0L;
         } else {
            var5 = this.chrono.getChrNum();
         }
      } else if (this.chrono != null && this.chrono.getChrMode() == 2) {
         var5 = this.chrono.getChrNum();
      }

      if (this.chrono != null) {
         ++var5;
         this.chrono.setChrNum(var5);
         this.chronoDao.modifierChrono(this.chrono, var1);
         var2 = this.calculChrono.formattageChrono(this.chrono, "", var3, new Date());
      }

      return var2;
   }

   public void googleMap() throws IOException, URISyntaxException {
      UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
      this.uri = var1.calculMap(this.eleves.getEleRue(), this.eleves.getEleAdresse(), this.eleves.getEleVille(), this.eleves.getElePays());
      this.showModalGoogleMap = true;
   }

   public void annuleGoogleMap() {
      this.showModalGoogleMap = false;
   }

   public void calculeGenre() {
      if (!this.eleves.getEleCivilite().equals("Madame") && !this.eleves.getEleCivilite().equals("Mademoiselle")) {
         this.eleves.setEleSexe(1);
      } else {
         this.eleves.setEleSexe(0);
      }

   }

   public void modifierCompte0() throws HibernateException, NamingException, IOException {
      this.compteModif = 0;
      this.modifierCompte(this.eleves.getEleCompte0());
   }

   public void modifierCompte1() throws HibernateException, NamingException, IOException {
      this.compteModif = 1;
      this.modifierCompte(this.eleves.getEleCompte1());
   }

   public void modifierCompte2() throws HibernateException, NamingException, IOException {
      this.compteModif = 2;
      this.modifierCompte(this.eleves.getEleCompte2());
   }

   public void modifierCompte3() throws HibernateException, NamingException, IOException {
      this.compteModif = 3;
      this.modifierCompte(this.eleves.getEleCompte3());
   }

   public void modifierCompte4() throws HibernateException, NamingException, IOException {
      this.compteModif = 4;
      this.modifierCompte(this.eleves.getEleCompte4());
   }

   public void modifierCompte(String var1) throws HibernateException, NamingException, IOException {
      this.choixCompte = 0;
      this.mesCompteItem = new ArrayList();
      this.mesNatureCompteItem = new ArrayList();
      this.mesRacineCompteItem = new ArrayList();
      LireLesoptionsCompta var2 = new LireLesoptionsCompta(this.structureLog);
      var2.setStrId(this.structureLog.getStrid());
      var2.lancer();
      this.nombrCaracter = Integer.parseInt(var2.getOptionComptabilite().getNbcr());
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
      ExercicesComptableDao var4 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      new ExercicesComptable();
      ExercicesComptable var5 = var4.recupererLastExo(var3);
      this.exerciceSelectionne = var5;
      this.exoCpte = var5.getExecpt_id();
      String var6 = "(7)";
      this.mesCompteItem = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, var5.getExecpt_id(), var6, 0, var3);
      this.choixCompte = 0;
      this.compte = "";
      this.racinecle = "";
      this.partieCompte = "";
      this.showModalPanelImmatriculation = true;
      this.existeCopteDeja = true;
      if (this.mesCompteItem == null || this.mesCompteItem.size() == 0) {
         this.compte = var1;
         this.choixCompte = 3;
         this.existeCopteDeja = false;
      }

      this.utilInitHibernate.closeSession();
   }

   public void supprimerCompte0() {
      this.eleves.setEleDateModif(new Date());
      this.eleves.setEleUserModif(this.usersLog.getUsrid());
      this.eleves.setEleCompte0("");
   }

   public void supprimerCompte1() {
      this.eleves.setEleDateModif(new Date());
      this.eleves.setEleUserModif(this.usersLog.getUsrid());
      this.eleves.setEleCompte1("");
   }

   public void supprimerCompte2() {
      this.eleves.setEleDateModif(new Date());
      this.eleves.setEleUserModif(this.usersLog.getUsrid());
      this.eleves.setEleCompte2("");
   }

   public void supprimerCompte3() {
      this.eleves.setEleDateModif(new Date());
      this.eleves.setEleUserModif(this.usersLog.getUsrid());
      this.eleves.setEleCompte3("");
   }

   public void supprimerCompte4() {
      this.eleves.setEleDateModif(new Date());
      this.eleves.setEleUserModif(this.usersLog.getUsrid());
      this.eleves.setEleCompte4("");
   }

   public void saveCompte() throws HibernateException, NamingException {
      String[] var1;
      if (this.choixCompte == 0) {
         if (this.compte != null && !this.compte.isEmpty()) {
            if (this.compte.contains(":")) {
               var1 = this.compte.split(":");
               String var2 = var1[0];
               if (this.compteModif == 0) {
                  this.eleves.setEleCompte0(var2);
               } else if (this.compteModif == 1) {
                  this.eleves.setEleCompte1(var2);
               } else if (this.compteModif == 2) {
                  this.eleves.setEleCompte2(var2);
               } else if (this.compteModif == 3) {
                  this.eleves.setEleCompte3(var2);
               } else if (this.compteModif == 4) {
                  this.eleves.setEleCompte4(var2);
               }
            } else if (!this.compte.equals("0")) {
               if (this.compteModif == 0) {
                  this.eleves.setEleCompte0(this.compte);
               } else if (this.compteModif == 1) {
                  this.eleves.setEleCompte1(this.compte);
               } else if (this.compteModif == 2) {
                  this.eleves.setEleCompte2(this.compte);
               } else if (this.compteModif == 3) {
                  this.eleves.setEleCompte3(this.compte);
               } else if (this.compteModif == 4) {
                  this.eleves.setEleCompte4(this.compte);
               }
            }
         }
      } else if (this.choixCompte == 3) {
         if (this.compteModif == 0) {
            this.eleves.setEleCompte0(this.compte);
         } else if (this.compteModif == 1) {
            this.eleves.setEleCompte1(this.compte);
         } else if (this.compteModif == 2) {
            this.eleves.setEleCompte2(this.compte);
         } else if (this.compteModif == 3) {
            this.eleves.setEleCompte3(this.compte);
         } else if (this.compteModif == 4) {
            this.eleves.setEleCompte4(this.compte);
         }
      } else {
         this.planComptable.setExercicesComptable(this.exerciceSelectionne);
         this.planComptable.setPlcDateCreat(new Date());
         this.planComptable.setPlcUserCreat(this.usersLog.getUsrid());
         this.planComptable.setPlcRanDetaille(true);
         this.planComptable.setPlcLibelleCpteFR(this.eleves.getPatronyme());
         this.planComptable.setPlcLibelleCpteUK("");
         this.planComptable.setPlcLibelleCpteSP("");
         var1 = this.maNature.split(":");
         this.planComptable.setPlcNature(Integer.parseInt(var1[0]));
         this.planComptable.setPlcLibelleNatureFR(var1[1]);
         this.planComptable.setPlcLibelleNatureUK("");
         this.planComptable.setPlcLibelleNatureSP("");
         String[] var3 = this.maRacine.split(":");
         this.planComptable.setPlcCodeRacine(var3[0]);
         this.planComptable.setPlcLibelleRacineFR(var3[1]);
         this.planComptable.setPlcLibelleRacineUK("");
         this.planComptable.setPlcLibelleRacineSP("");
         this.planComptable.setPlcLibre(this.compte);
         this.planComptableDao.insert(this.planComptable);
         if (this.compteModif == 0) {
            this.eleves.setEleCompte0(this.planComptable.getPlcCompte());
         } else if (this.compteModif == 1) {
            this.eleves.setEleCompte1(this.planComptable.getPlcCompte());
         } else if (this.compteModif == 2) {
            this.eleves.setEleCompte2(this.planComptable.getPlcCompte());
         } else if (this.compteModif == 3) {
            this.eleves.setEleCompte3(this.planComptable.getPlcCompte());
         } else if (this.compteModif == 4) {
            this.eleves.setEleCompte4(this.planComptable.getPlcCompte());
         }
      }

      this.showModalPanelImmatriculation = false;
   }

   public void annuleCompte() {
      this.showModalPanelImmatriculation = false;
   }

   public void selectCompte() {
      if (this.compte != null && !this.compte.isEmpty()) {
         if (!this.compte.equals("0")) {
            this.existeCopteDeja = false;
         } else {
            this.existeCopteDeja = true;
         }
      } else {
         this.existeCopteDeja = true;
      }

   }

   public void redessineChoixCompte() {
      this.maNature = "0";
      this.maRacine = "0";
      this.racinecle = "";
      this.partieCompte = "";
      this.mesNatureCompteItem.clear();
      this.mesRacineCompteItem.clear();
      if (this.planComptable == null) {
         this.planComptable = new PlanComptable();
      }

      this.planComptable.setPlcCompte("");
      if (this.choixCompte == 2) {
         this.mesNatureCompteItem.add(new SelectItem("90:Attente"));
      } else {
         this.mesNatureCompteItem.add(new SelectItem("7:Clients"));
      }

      this.existeCopteDeja = true;
   }

   public void chargeRacineCompte() throws HibernateException, NamingException {
      this.mesRacineCompteItem = new ArrayList();
      if (this.maNature.contains(":")) {
         String[] var1 = this.maNature.split(":");
         new ArrayList();
         RacinesDao var3 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
         List var2 = var3.rechercherListeRacine(this.selecFiscalite, var1[0], (Session)null);
         if (var2.size() != 0) {
            for(int var4 = 0; var4 < var2.size(); ++var4) {
               new Racines();
               Racines var5 = (Racines)var2.get(var4);
               String var6 = var5.getRacCode() + ":" + var5.getRacLibelleFr();
               this.mesRacineCompteItem.add(new SelectItem(var6));
            }
         }
      }

   }

   public void calculeCompte() throws HibernateException, NamingException, IOException {
      if (this.maRacine.contains(":")) {
         String[] var1 = this.maNature.split(":");
         if (var1.length == 2) {
            String[] var2 = this.maRacine.split(":");
            this.racinecle = var2[0];
            RacinesDao var3 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
            new Racines();
            Racines var4 = var3.rechercherCodeRacine(this.selecFiscalite, this.racinecle, (Session)null);
            if (var4 != null) {
               this.planComptable = new PlanComptable();
               this.planComptable.setPlcNature(Integer.parseInt(var1[0]));
               this.planComptable.setPlcLibelleNatureSP(var1[1]);
               this.planComptable.setPlcCodeRacine(this.racinecle);
               this.planComptable.setPlcLibelleRacineFR(var4.getRacLibelleFr());
               this.planComptable.setPlcLibelleRacineSP(var4.getRacLibelleSp());
               this.planComptable.setPlcLibelleRacineUK(var4.getRacLibelleSp());
               this.planComptable.setPlcSens(0);
               if (var4.getRacUtil().equalsIgnoreCase("1")) {
                  this.existeCopteDeja = true;
                  this.planComptable.setPlcTauxTaxe(var4.getRactaux());
                  this.planComptable.setPlcLibelleCpteFR(var4.getRacLibelleFr());
                  this.planComptable.setPlcLibelleCpteSP(var4.getRacLibelleSp());
                  this.planComptable.setPlcLibelleCpteUK(var4.getRacLibelleUk());
                  this.partieCompte = "" + this.calculeProchainNum(var4.getRacCode());
                  this.partieCompte = this.getComplementutil(this.partieCompte, var4.getRacCode());
                  this.planComptable.setPlcCompte(var4.getRacCode().concat(this.partieCompte));
                  this.valideCompte();
               } else {
                  this.existeCopteDeja = true;
               }
            }
         }
      }

   }

   public int calculeProchainNum(String var1) throws HibernateException, NamingException, IOException {
      new OptionComptabilite();
      LireLesoptionsCompta var3 = new LireLesoptionsCompta(this.structureLog);
      var3.setStrId(this.structureLog.getStrid());
      var3.lancer();
      OptionComptabilite var2 = var3.getOptionComptabilite();
      int var4 = 0;
      if (var2.getCalculCompte().equals("0")) {
         var4 = this.planComptableDao.calculeNbCompte(this.selecFiscalite, var1, this.exoCpte, (Session)null) + 1;
      } else if (var2.getCalculCompte().equals("1")) {
         new ArrayList();
         List var5 = this.planComptableDao.chargeNumCpte(this.selecFiscalite, var1, 0L, 0, (String)null, (Session)null);
         if (var5.size() != 0) {
            int var6 = var5.size() - 1;
            String var7 = ((PlanComptable)var5.get(var6)).getPlcCompte();
            String var8 = var7.substring(var1.length(), 10);
            if (this.estUnEntier(var8)) {
               var4 = Integer.parseInt(var8) + 1;
            } else {
               var4 = this.planComptableDao.calculeNbCompte(this.selecFiscalite, var1, this.exoCpte, (Session)null) + 1;
            }
         }
      }

      return var4;
   }

   public boolean estUnEntier(String var1) {
      try {
         Integer.parseInt(var1);
         return true;
      } catch (NumberFormatException var3) {
         return false;
      }
   }

   public String getComplementutil(String var1, String var2) {
      String var3 = var2.concat(var1);
      int var4 = this.nombrCaracter - var3.length();
      String var5 = "";
      if (var4 > 0) {
         String[] var6 = new String[var4];

         for(int var7 = 0; var7 < var4; ++var7) {
            var6[var7] = "0";
            var5 = var5 + var6[var7];
         }

         var5 = var5 + var1;
      } else {
         var5 = var1;
      }

      return var5;
   }

   public void valideCompte() throws HibernateException, NamingException {
      this.planComptable.setPlcCompte(this.racinecle + this.partieCompte);
      this.existeCopteDeja = true;
      if (this.planComptable.getPlcCompte() != null && !this.planComptable.getPlcCompte().isEmpty()) {
         this.existeCopteDeja = this.planComptableDao.existeCompte(this.selecFiscalite, this.planComptable.getPlcCompte(), this.exoCpte, (Session)null);
      }

   }

   public void calculReglementTiers() {
      this.eleves.setEleNbecheance(0);
      this.eleves.setEleNbarrondi(0);
      this.eleves.setEleConditionreg("");
      if (this.lesReglementsClient.size() != 0) {
         for(int var1 = 0; var1 < this.lesReglementsClient.size(); ++var1) {
            new ObjetReglement();
            ObjetReglement var2 = (ObjetReglement)this.lesReglementsClient.get(var1);
            if (this.eleves.getEleModereg().equalsIgnoreCase(var2.getLibelles())) {
               if (var2.getNbjours().isEmpty()) {
                  this.eleves.setEleNbecheance(0);
               } else {
                  this.eleves.setEleNbecheance(Integer.parseInt(var2.getNbjours()));
               }

               if (var2.getArrondis().isEmpty()) {
                  this.eleves.setEleNbarrondi(0);
               } else {
                  this.eleves.setEleNbarrondi(Integer.parseInt(var2.getArrondis()));
               }

               this.eleves.setEleConditionreg(var2.getConditions());
               break;
            }
         }
      }

   }

   public void griserModeCalcul() {
      if (this.eleves.getEleTypereg() != 1 && this.eleves.getEleTypereg() != 2) {
         this.testModeCalcul = false;
      } else {
         this.testModeCalcul = true;
      }

   }

   public void selectionContact() {
      if (this.datamodelContact.isRowAvailable()) {
         this.elevesContact = (ElevesContact)this.datamodelContact.getRowData();
         this.afficheButtContact = true;
      }

   }

   public void ajouterContact() {
      this.elevesContact = new ElevesContact();
      this.var_actionContact = 1;
      this.showModalPanelCnt = true;
   }

   public void modifierContact() {
      if (this.elevesContact != null) {
         this.var_actionContact = 2;
         this.showModalPanelCnt = true;
      }

   }

   public void consulterContact() {
      if (this.elevesContact != null) {
         this.var_actionContact = 3;
         this.showModalPanelCnt = true;
      }

   }

   public void supprimerContact() throws HibernateException, NamingException {
      if (this.elevesContact != null) {
         this.elevesContactDao.delete(this.elevesContact);
         this.lesContacts.remove(this.elevesContact);
         this.datamodelContact.setWrappedData(this.lesContacts);
         this.afficheButtContact = false;
      }

   }

   public void annuleContact() {
      this.showModalPanelCnt = false;
   }

   public void saveContact() throws HibernateException, NamingException {
      if (this.elevesContact.getEleconNom() != null && !this.elevesContact.getEleconNom().isEmpty()) {
         if (this.elevesContact.getEleconId() == 0L) {
            this.elevesContact.setEleves(this.eleves);
            this.elevesContact = this.elevesContactDao.insert(this.elevesContact);
            this.lesContacts.add(this.elevesContact);
            this.datamodelContact.setWrappedData(this.lesContacts);
         } else {
            this.elevesContact = this.elevesContactDao.modif(this.elevesContact);
         }
      }

      this.showModalPanelCnt = false;
   }

   public void affichePhoto() throws IOException, SQLException {
      if (this.eleves.getElePhoto() != null) {
         this.urlphoto = "structure" + this.structureLog.getStrid() + "/photos/Eleves/" + this.eleves.getElePhoto();
      } else {
         this.urlphoto = "";
      }

   }

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException {
      FacesContext var1 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Eleves") + File.separator + "E" + this.eleves.getEleId();
            File var3 = new File(var2);
            if (var3.exists()) {
               var3.delete();
            }

            String var4 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = "E" + this.eleves.getEleId() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Eleves" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
            this.fileName = var4;
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.eleves.setElePhoto(var4);
            this.eleves = this.elevesDao.modif(this.eleves);
            this.urlphoto = "structure" + this.structureLog.getStrid() + "/photos/Eleves/" + this.eleves.getElePhoto();
         }
      } catch (IOException var7) {
         this.eleves.setElePhoto(this.fileName);
         var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var7.printStackTrace();
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException {
      String var1 = "";
      int var2 = this.eleves.getElePhoto().lastIndexOf(46);
      if (0 < var2 && var2 <= this.eleves.getElePhoto().length() - 2) {
         var1 = "." + this.eleves.getElePhoto().substring(var2 + 1);
      }

      String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Eleves") + File.separator + "E" + this.eleves.getEleId() + var1;
      File var4 = new File(var3);
      if (var4.exists()) {
         var4.delete();
      }

      this.eleves.setElePhoto((String)null);
      this.eleves = this.elevesDao.modif(this.eleves);
   }

   public void ajouterDocumentScan() {
      this.uploadedPDFFile = null;
      this.nomDocument = "";
      this.showModalPanelAjoutFile = true;
   }

   public void annulerDocumentScan() {
      this.showModalPanelAjoutFile = false;
   }

   public void validerDocumentScan() {
      if (this.eleves != null && this.uploadedPDFFile != null) {
         File var1 = new File(this.nomRepertoire + this.eleves.getEleDossier());
         if (var1.exists()) {
            var1.delete();
         }

         FacesContext var2 = FacesContext.getCurrentInstance();

         try {
            String var3 = this.utilDownload.trimFilePath(this.uploadedPDFFile.getName().trim());
            String var4 = var3.substring(var3.indexOf(".") + 1);
            if (this.nomDocument != null && !this.nomDocument.isEmpty()) {
               var3 = this.eleves.getEleDossier().replace("/", "_") + "_" + this.filtreCaracteres(this.nomDocument) + "." + var4;
            } else {
               var3 = this.eleves.getEleDossier().replace("/", "_") + "." + var4;
            }

            File var5 = this.utilDownload.uniqueFile(new File(this.nomRepertoire), var3);
            this.utilDownload.write(var5, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var3;
            this.lesDocuments.add(this.pdfFileName);
            this.dataModelDocumnts.setWrappedData(this.lesDocuments);
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
         } catch (IOException var6) {
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var6.printStackTrace();
         }
      }

      this.showModalPanelAjoutFile = false;
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz:=,1234567890".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         } else if (var3.equals(" ")) {
            var2 = var2 + "_";
         }
      }

      return var2;
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

   public void lectureDoc() throws MalformedURLException, IOException {
      if (this.dataModelDocumnts.isRowAvailable()) {
         String var1 = (String)this.dataModelDocumnts.getRowData();
         if (var1.contains(".pdf")) {
            this.nomDocument = var1;
            String var2 = this.nomRepertoire + var1;
            if (var2 != null && !var2.isEmpty()) {
               this.consulterDocumentScan(var2);
            }
         }
      }

   }

   public void consulterDocumentScan(String var1) throws MalformedURLException, IOException {
      if (var1 != null && !var1.isEmpty()) {
         this.utilDownload = new UtilDownload();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(var1);
         this.showModalPanelPj = true;
      }

   }

   public void fermerVisuDocumentScan() {
      this.showModalPanelPj = false;
   }

   public void supprimerDocumentScan() {
      if (this.nomDocument != null && !this.nomDocument.isEmpty() && this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         String var1 = this.nomRepertoire + this.nomDocument;
         File var2 = new File(var1);
         var2.delete();
         this.lesDocuments.remove(this.nomDocument);
         this.dataModelDocumnts.setWrappedData(this.lesDocuments);
         this.showModalPanelPj = false;
      }

   }

   public void envoiSmsZ1() {
      if (this.eleves.getEleCel1() != null && !this.eleves.getEleCel1().isEmpty()) {
         this.numeroMobile = this.eleves.getEleCel1();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ2() {
      if (this.eleves.getEleCel2() != null && !this.eleves.getEleCel2().isEmpty()) {
         this.numeroMobile = this.eleves.getEleCel2();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ3() {
      if (this.eleves.getEleCel3() != null && !this.eleves.getEleCel3().isEmpty()) {
         this.numeroMobile = this.eleves.getEleCel3();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void fermerSms() {
      this.showModalPanelSms = false;
   }

   public void valideEnvoiSms() throws IOException, HibernateException, NamingException, SQLException {
      UtilSms var1 = new UtilSms(this.utilInitHibernate, this.structureLog, this.usersLog, this.baseLog);
      var1.sendSmsOne(this.messageSms, this.numeroMobile, this.eleves.getEleNom(), this.eleves.getEleCivilite(), this.eleves.getEleId(), (String)null, 0L, 5);
      this.showModalPanelSms = false;
   }

   public void selectionInscription() {
      if (this.datamodelInscription.isRowAvailable()) {
         this.elevesInscription = (ElevesInscription)this.datamodelInscription.getRowData();
         this.filieresEducation = this.elevesInscription.getFilieresEducation();
         if (this.filieresEducation != null) {
            this.var_filiere = this.filieresEducation.getFilId();
         } else {
            this.var_filiere = 0L;
         }

         this.afficheButtInscription = true;
         this.site = this.elevesInscription.getEleinsSite();
         this.departement = this.elevesInscription.getEleinsDepartement();
         this.service = this.elevesInscription.getEleinsService();
         this.region = this.elevesInscription.getEleinsRegion();
         this.secteur = this.elevesInscription.getEleinsSecteur();
         this.pdv = this.elevesInscription.getEleinsPdv();
         this.caisse = this.elevesInscription.getEleinsCaisse();
         this.responsable = this.elevesInscription.getEleinsIdResponsable();
         this.commercial = this.elevesInscription.getEleinsIdCommercial();
      }

   }

   public void ajouterInscription() throws HibernateException, NamingException {
      this.recupererExerciceEducation((Session)null);
      this.elevesInscription = new ElevesInscription();
      this.elevesInscription.setEleinsAnnee(this.exercicesVentes.getExevteDateDebut().getYear() + 1900 + "-" + (this.exercicesVentes.getExevteDateFin().getYear() + 1900));
      this.filieresEducation = new FilieresEducation();
      this.elevesInscription.setEleinsDate(new Date());
      this.elevesInscription.setEleinsDateFacturation(new Date());
      this.var_actionInscription = 1;
      this.var_filiere = 0L;
      this.showModalPanelInscription = true;
   }

   public void modifierInscription() {
      if (this.elevesInscription != null) {
         this.var_actionInscription = 2;
         if (this.elevesInscription.getEleinsAnnee() == null || this.elevesInscription.getEleinsAnnee().isEmpty()) {
            this.elevesInscription.setEleinsAnnee(this.exercicesVentes.getExevteDateDebut().getYear() + 1900 + "-" + (this.exercicesVentes.getExevteDateFin().getYear() + 1900));
         }

         this.showModalPanelInscription = true;
      }

   }

   public void consulterInscription() {
      if (this.elevesInscription != null) {
         this.var_actionInscription = 3;
         this.showModalPanelInscription = true;
      }

   }

   public void supprimerInscription() throws HibernateException, NamingException {
      if (this.elevesInscription != null) {
         this.elevesInscriptionDao.delete(this.elevesInscription);
         this.lesInscriptions.remove(this.elevesInscription);
         this.datamodelInscription.setWrappedData(this.lesInscriptions);
         this.afficheButtInscription = false;
      }

   }

   public void annuleInscription() {
      this.showModalPanelInscription = false;
   }

   public void saveInscription() throws HibernateException, NamingException {
      if (this.filieresEducation != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.elevesInscription.setFilieresEducation(this.filieresEducation);
            this.elevesInscription.setEleinsDateDebut(this.exercicesVentes.getExevteDateDebut());
            this.elevesInscription.setEleinsDateFin(this.exercicesVentes.getExevteDateFin());
            this.elevesInscription.setEleinsEtat(0);
            this.elevesInscription.setEleinsEtatVal(0);
            this.elevesInscription.setEleinsDateValide((Date)null);
            this.elevesInscription.setEleinsNomCommercial("");
            this.elevesInscription.setEleinsIdCommercial(0L);
            Users var3;
            if (this.commercial != 0L) {
               new Users();
               var3 = this.userDao.selectLeUserId(this.commercial, var1);
               if (var3 != null) {
                  this.elevesInscription.setEleinsNomCommercial(var3.getUsrPatronyme());
                  this.elevesInscription.setEleinsIdCommercial(this.commercial);
               }
            }

            this.elevesInscription.setEleinsNomResponsable("");
            this.elevesInscription.setEleinsIdResponsable(0L);
            if (this.responsable != 0L) {
               new Users();
               var3 = this.userDao.selectLeUserId(this.responsable, var1);
               if (var3 != null) {
                  this.elevesInscription.setEleinsNomResponsable(var3.getUsrPatronyme());
                  this.elevesInscription.setEleinsIdResponsable(this.responsable);
               }
            }

            this.elevesInscription.setEleinsSite(this.site);
            this.elevesInscription.setEleinsDepartement(this.departement);
            this.elevesInscription.setEleinsService(this.service);
            this.elevesInscription.setEleinsRegion(this.region);
            this.elevesInscription.setEleinsSecteur(this.secteur);
            this.elevesInscription.setEleinsPdv(this.pdv);
            this.elevesInscription.setEleinsCaisse(this.caisse);
            if (this.elevesInscription.getEleinsId() == 0L) {
               this.elevesInscription.setEleves(this.eleves);
               this.elevesInscription.setEleinsDateCreat(new Date());
               this.elevesInscription.setEleinsIdCreateur(this.usersLog.getUsrid());
               this.elevesInscription = this.elevesInscriptionDao.insert(this.elevesInscription, var1);
               this.lesInscriptions.add(this.elevesInscription);
               this.datamodelInscription.setWrappedData(this.lesInscriptions);
            } else {
               this.elevesInscription.setEleinsDateModif(new Date());
               this.elevesInscription.setEleinsIdModif(this.usersLog.getUsrid());
               this.elevesInscription = this.elevesInscriptionDao.modif(this.elevesInscription, var1);
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

      this.showModalPanelInscription = false;
   }

   public void validerInscription() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.elevesInscription.getEleinsEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
            this.elevesInscription.setEleinsEtat(1);
            if (this.elevesInscription.getEleinsDate() == null) {
               this.elevesInscription.setEleinsDate(new Date());
            }

            this.elevesInscription = this.elevesInscriptionDao.modif(this.elevesInscription, var1);
            String var3;
            if (this.elevesInscription.getEleinsTarifDossier() + this.elevesInscription.getEleinsTarifInscription() + this.elevesInscription.getEleinsTarifReinscription() + this.elevesInscription.getEleinsTarifAssociation() + this.elevesInscription.getEleinsTarifTenue() != 0.0D) {
               this.elevesFacture = this.elevesFactureDao.getElevesFactureMedByType(1, this.elevesInscription.getEleinsAnnee(), this.eleves, var1);
               if (this.elevesFacture == null) {
                  var3 = this.calculChrono.numCompose(this.elevesInscription.getEleinsDate(), 102, "", var1);
                  this.elevesFacture = new ElevesFacture();
                  this.elevesFacture.setElefacNum(var3);
               }

               this.elevesFacture.setElefacType(1);
               this.elevesFacture.setElefacEtat(1);
               this.elevesFacture.setElefacAnnee(this.elevesInscription.getEleinsAnnee());
               this.elevesFacture.setElefacSerie(this.elevesInscription.getEleinsSerie());
               this.elevesFacture.setElefacDateCreat(new Date());
               this.elevesFacture.setElefacIdCreateur(this.usersLog.getUsrid());
               this.elevesFacture.setElefacDate(this.elevesInscription.getEleinsDate());
               this.elevesFacture.setElefacDateEche01(this.elevesFacture.getElefacDate());
               this.elevesFacture.setElefacModeScolarite(3);
               this.elevesFacture.setElefacTarifAssociation(this.elevesInscription.getEleinsTarifAssociation());
               this.elevesFacture.setElefacTarifDivers(this.elevesInscription.getEleinsTarifDivers());
               this.elevesFacture.setElefacTarifDossier(this.elevesInscription.getEleinsTarifDossier());
               this.elevesFacture.setElefacTarifExamens(this.elevesInscription.getEleinsTarifExamens());
               this.elevesFacture.setElefacTarifInscription(this.elevesInscription.getEleinsTarifInscription());
               this.elevesFacture.setElefacTarifTenue(this.elevesInscription.getEleinsTarifTenue());
               this.elevesFacture.setElefacSite(this.elevesInscription.getEleinsSite());
               this.elevesFacture.setElefacDepartement(this.elevesInscription.getEleinsDepartement());
               this.elevesFacture.setElefacService(this.elevesInscription.getEleinsService());
               this.elevesFacture.setElefacRegion(this.elevesInscription.getEleinsRegion());
               this.elevesFacture.setElefacSecteur(this.elevesInscription.getEleinsSecteur());
               this.elevesFacture.setElefacPdv(this.elevesInscription.getEleinsPdv());
               this.elevesFacture.setElefacCaisse(this.elevesInscription.getEleinsCaisse());
               this.elevesFacture.setElefacNomCommercial(this.elevesInscription.getEleinsNomCommercial());
               this.elevesFacture.setElefacIdCommercial(this.elevesInscription.getEleinsIdCommercial());
               this.elevesFacture.setElefacNomResponsable(this.elevesInscription.getEleinsNomResponsable());
               this.elevesFacture.setElefacIdResponsable(this.elevesInscription.getEleinsIdResponsable());
               this.elevesFacture.setElefacTotal(this.elevesInscription.getEleinsTarifDossier() + this.elevesInscription.getEleinsTarifInscription() + this.elevesInscription.getEleinsTarifReinscription() + this.elevesInscription.getEleinsTarifAssociation() + this.elevesInscription.getEleinsTarifTenue());
               this.elevesFacture.setElefacCodeTaxe("");
               this.elevesFacture.setElefacTauxTaxe(0.0F);
               this.elevesFacture.setElefacTotalTaxe(0.0D);
               this.elevesFacture.setElefacTauxTc(0.0F);
               this.elevesFacture.setElefacTotalTc(0.0D);
               this.elevesFacture.setElefacTotalTimbre(0.0D);
               this.elevesFacture.setEleves(this.eleves);
               this.elevesFacture.setElevesInscription(this.elevesInscription);
               this.elevesFacture.setExercicesVentes(this.exercicesVentes);
               this.elevesFacture = this.elevesFactureDao.insert(this.elevesFacture, var1);
               var1.flush();
            }

            if (this.elevesInscription.getEleinsTarifScolarite() + this.elevesInscription.getEleinsTarifCantine() + this.elevesInscription.getEleinsTarifTransport() != 0.0D) {
               this.elevesFacture = this.elevesFactureDao.getElevesFactureMedByType(2, this.elevesInscription.getEleinsAnnee(), this.eleves, var1);
               if (this.elevesFacture == null) {
                  var3 = this.calculChrono.numCompose(this.elevesInscription.getEleinsDate(), 102, "", var1);
                  this.elevesFacture = new ElevesFacture();
                  this.elevesFacture.setElefacNum(var3);
               }

               this.elevesFacture.setElefacType(2);
               this.elevesFacture.setElefacEtat(1);
               this.elevesFacture.setElefacAnnee(this.elevesInscription.getEleinsAnnee());
               this.elevesFacture.setElefacDateCreat(new Date());
               this.elevesFacture.setElefacIdCreateur(this.usersLog.getUsrid());
               this.elevesFacture.setElefacDate(this.elevesInscription.getEleinsDate());
               this.elevesFacture.setElefacModeScolarite(this.elevesInscription.getEleinsModeScolarite());
               this.elevesFacture.setElefacTarifScolarite(this.elevesInscription.getEleinsTarifScolarite());
               this.elevesFacture.setElefacTarifCantine(this.elevesInscription.getEleinsTarifCantine());
               this.elevesFacture.setElefacTarifTransport(this.elevesInscription.getEleinsTarifTransport());
               this.elevesFacture.setElefacDateEche01(this.elevesInscription.getEleinsDateEche01());
               this.elevesFacture.setElefacDateEche02(this.elevesInscription.getEleinsDateEche02());
               this.elevesFacture.setElefacDateEche03(this.elevesInscription.getEleinsDateEche03());
               this.elevesFacture.setElefacDateEche04(this.elevesInscription.getEleinsDateEche04());
               this.elevesFacture.setElefacDateEche05(this.elevesInscription.getEleinsDateEche05());
               this.elevesFacture.setElefacDateEche06(this.elevesInscription.getEleinsDateEche06());
               this.elevesFacture.setElefacDateEche07(this.elevesInscription.getEleinsDateEche07());
               this.elevesFacture.setElefacDateEche08(this.elevesInscription.getEleinsDateEche08());
               this.elevesFacture.setElefacDateEche09(this.elevesInscription.getEleinsDateEche09());
               this.elevesFacture.setElefacDateEche10(this.elevesInscription.getEleinsDateEche10());
               this.elevesFacture.setElefacDateEche11(this.elevesInscription.getEleinsDateEche11());
               this.elevesFacture.setElefacDateEche12(this.elevesInscription.getEleinsDateEche12());
               this.elevesFacture.setElefacScolarite01(this.elevesInscription.getEleinsScolarite01());
               this.elevesFacture.setElefacScolarite02(this.elevesInscription.getEleinsScolarite02());
               this.elevesFacture.setElefacScolarite03(this.elevesInscription.getEleinsScolarite03());
               this.elevesFacture.setElefacScolarite04(this.elevesInscription.getEleinsScolarite04());
               this.elevesFacture.setElefacScolarite05(this.elevesInscription.getEleinsScolarite05());
               this.elevesFacture.setElefacScolarite06(this.elevesInscription.getEleinsScolarite06());
               this.elevesFacture.setElefacScolarite07(this.elevesInscription.getEleinsScolarite07());
               this.elevesFacture.setElefacScolarite08(this.elevesInscription.getEleinsScolarite08());
               this.elevesFacture.setElefacScolarite09(this.elevesInscription.getEleinsScolarite09());
               this.elevesFacture.setElefacScolarite10(this.elevesInscription.getEleinsScolarite10());
               this.elevesFacture.setElefacScolarite11(this.elevesInscription.getEleinsScolarite11());
               this.elevesFacture.setElefacScolarite12(this.elevesInscription.getEleinsScolarite12());
               this.elevesFacture.setElefacTransport01(this.elevesInscription.getEleinsTransport01());
               this.elevesFacture.setElefacTransport02(this.elevesInscription.getEleinsTransport02());
               this.elevesFacture.setElefacTransport03(this.elevesInscription.getEleinsTransport03());
               this.elevesFacture.setElefacTransport04(this.elevesInscription.getEleinsTransport04());
               this.elevesFacture.setElefacTransport05(this.elevesInscription.getEleinsTransport05());
               this.elevesFacture.setElefacTransport06(this.elevesInscription.getEleinsTransport06());
               this.elevesFacture.setElefacTransport07(this.elevesInscription.getEleinsTransport07());
               this.elevesFacture.setElefacTransport08(this.elevesInscription.getEleinsTransport08());
               this.elevesFacture.setElefacTransport09(this.elevesInscription.getEleinsTransport09());
               this.elevesFacture.setElefacTransport10(this.elevesInscription.getEleinsTransport10());
               this.elevesFacture.setElefacTransport11(this.elevesInscription.getEleinsTransport11());
               this.elevesFacture.setElefacTransport12(this.elevesInscription.getEleinsTransport12());
               this.elevesFacture.setElefacCantine01(this.elevesInscription.getEleinsCantine01());
               this.elevesFacture.setElefacCantine02(this.elevesInscription.getEleinsCantine02());
               this.elevesFacture.setElefacCantine03(this.elevesInscription.getEleinsCantine03());
               this.elevesFacture.setElefacCantine04(this.elevesInscription.getEleinsCantine04());
               this.elevesFacture.setElefacCantine05(this.elevesInscription.getEleinsCantine05());
               this.elevesFacture.setElefacCantine06(this.elevesInscription.getEleinsCantine06());
               this.elevesFacture.setElefacCantine07(this.elevesInscription.getEleinsCantine07());
               this.elevesFacture.setElefacCantine08(this.elevesInscription.getEleinsCantine08());
               this.elevesFacture.setElefacCantine09(this.elevesInscription.getEleinsCantine09());
               this.elevesFacture.setElefacCantine10(this.elevesInscription.getEleinsCantine10());
               this.elevesFacture.setElefacCantine11(this.elevesInscription.getEleinsCantine11());
               this.elevesFacture.setElefacCantine12(this.elevesInscription.getEleinsCantine12());
               this.elevesFacture.setElefacTotal(this.elevesInscription.getEleinsTarifScolarite() + this.elevesInscription.getEleinsTarifCantine() + this.elevesInscription.getEleinsTarifTransport());
               this.elevesFacture.setElefacCodeTaxe("");
               this.elevesFacture.setElefacTauxTaxe(0.0F);
               this.elevesFacture.setElefacTotalTaxe(0.0D);
               this.elevesFacture.setElefacTauxTc(0.0F);
               this.elevesFacture.setElefacTotalTc(0.0D);
               this.elevesFacture.setElefacTotalTimbre(0.0D);
               this.elevesFacture.setEleves(this.eleves);
               this.elevesFacture.setElevesInscription(this.elevesInscription);
               this.elevesFacture.setExercicesVentes(this.exercicesVentes);
               this.elevesFacture = this.elevesFactureDao.insert(this.elevesFacture, var1);
               var1.flush();
            }

            if (this.elevesInscription.getEleinsTarifExamens() != 0.0D) {
               this.elevesFacture = this.elevesFactureDao.getElevesFactureMedByType(3, this.elevesInscription.getEleinsAnnee(), this.eleves, var1);
               if (this.elevesFacture == null) {
                  var3 = this.calculChrono.numCompose(this.elevesInscription.getEleinsDate(), 102, "", var1);
                  this.elevesFacture = new ElevesFacture();
                  this.elevesFacture.setElefacNum(var3);
               }

               this.elevesFacture.setElefacType(3);
               this.elevesFacture.setElefacEtat(1);
               this.elevesFacture.setElefacAnnee(this.elevesInscription.getEleinsAnnee());
               this.elevesFacture.setElefacDateCreat(new Date());
               this.elevesFacture.setElefacIdCreateur(this.usersLog.getUsrid());
               this.elevesFacture.setElefacDate(new Date());
               this.elevesFacture.setElefacTarifExamens(this.elevesInscription.getEleinsTarifExamens());
               this.elevesFacture.setElefacTotal(this.elevesInscription.getEleinsTarifExamens());
               this.elevesFacture.setElefacCodeTaxe("");
               this.elevesFacture.setElefacTauxTaxe(0.0F);
               this.elevesFacture.setElefacTotalTaxe(0.0D);
               this.elevesFacture.setElefacTauxTc(0.0F);
               this.elevesFacture.setElefacTotalTc(0.0D);
               this.elevesFacture.setElefacTotalTimbre(0.0D);
               this.elevesFacture.setEleves(this.eleves);
               this.elevesFacture.setElevesInscription(this.elevesInscription);
               this.elevesFacture.setExercicesVentes(this.exercicesVentes);
               this.elevesFacture = this.elevesFactureDao.insert(this.elevesFacture, var1);
               var1.flush();
            }

            if (this.elevesInscription.getEleinsTarifDivers() != 0.0D) {
               this.elevesFacture = this.elevesFactureDao.getElevesFactureMedByType(4, this.elevesInscription.getEleinsAnnee(), this.eleves, var1);
               if (this.elevesFacture == null) {
                  var3 = this.calculChrono.numCompose(this.elevesInscription.getEleinsDate(), 102, "", var1);
                  this.elevesFacture = new ElevesFacture();
                  this.elevesFacture.setElefacNum(var3);
               }

               this.elevesFacture.setElefacType(4);
               this.elevesFacture.setElefacEtat(1);
               this.elevesFacture.setElefacAnnee(this.elevesInscription.getEleinsAnnee());
               this.elevesFacture.setElefacDateCreat(new Date());
               this.elevesFacture.setElefacIdCreateur(this.usersLog.getUsrid());
               this.elevesFacture.setElefacDate(new Date());
               this.elevesFacture.setElefacTarifDivers(this.elevesInscription.getEleinsTarifDivers());
               this.elevesFacture.setElefacTotal(this.elevesInscription.getEleinsTarifDivers());
               this.elevesFacture.setElefacCodeTaxe("");
               this.elevesFacture.setElefacTauxTaxe(0.0F);
               this.elevesFacture.setElefacTotalTaxe(0.0D);
               this.elevesFacture.setElefacTauxTc(0.0F);
               this.elevesFacture.setElefacTotalTc(0.0D);
               this.elevesFacture.setElefacTotalTimbre(0.0D);
               this.elevesFacture.setEleves(this.eleves);
               this.elevesFacture.setElevesInscription(this.elevesInscription);
               this.elevesFacture.setExercicesVentes(this.exercicesVentes);
               this.elevesFacture = this.elevesFactureDao.insert(this.elevesFacture, var1);
               var1.flush();
            }

            if (this.elevesInscription.getEleinsTarifAssurance() != 0.0D) {
               this.elevesFacture = this.elevesFactureDao.getElevesFactureMedByType(5, this.elevesInscription.getEleinsAnnee(), this.eleves, var1);
               if (this.elevesFacture == null) {
                  var3 = this.calculChrono.numCompose(this.elevesInscription.getEleinsDate(), 102, "", var1);
                  this.elevesFacture = new ElevesFacture();
                  this.elevesFacture.setElefacNum(var3);
               }

               this.elevesFacture.setElefacType(5);
               this.elevesFacture.setElefacEtat(1);
               this.elevesFacture.setElefacAnnee(this.elevesInscription.getEleinsAnnee());
               this.elevesFacture.setElefacDateCreat(new Date());
               this.elevesFacture.setElefacIdCreateur(this.usersLog.getUsrid());
               this.elevesFacture.setElefacDate(new Date());
               this.elevesFacture.setElefacTarifAssurance(this.elevesInscription.getEleinsTarifAssurance());
               this.elevesFacture.setElefacTotal(this.elevesInscription.getEleinsTarifAssurance());
               this.elevesFacture.setElefacCodeTaxe("");
               this.elevesFacture.setElefacTauxTaxe(0.0F);
               this.elevesFacture.setElefacTotalTaxe(0.0D);
               this.elevesFacture.setElefacTauxTc(0.0F);
               this.elevesFacture.setElefacTotalTc(0.0D);
               this.elevesFacture.setElefacTotalTimbre(0.0D);
               this.elevesFacture.setEleves(this.eleves);
               this.elevesFacture.setElevesInscription(this.elevesInscription);
               this.elevesFacture.setExercicesVentes(this.exercicesVentes);
               this.elevesFacture = this.elevesFactureDao.insert(this.elevesFacture, var1);
               var1.flush();
            }

            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Validation manuelle inscription ID N° " + this.elevesInscription.getEleinsId() + " période du " + this.elevesInscription.getEleinsAnnee());
            this.espionDao.mAJEspion(var9, var1);
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

      this.chargerFactures((Session)null);
   }

   public void devaliderInscription() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.elevesInscription.getEleinsEtat() == 1 && this.habilitation == null) {
            this.elevesInscription.setEleinsEtat(0);
            this.elevesInscription = this.elevesInscriptionDao.modif(this.elevesInscription, var1);
            if (this.lesFactures.size() != 0) {
               for(int var3 = 0; var3 < this.lesFactures.size(); ++var3) {
                  this.elevesFacture = (ElevesFacture)this.lesFactures.get(var3);
                  if (this.elevesFacture.getElefacReglement() == 0.0D && this.elevesFacture.getElevesInscription().getEleinsId() == this.elevesInscription.getEleinsId()) {
                     this.elevesFactureDao.delete(this.elevesFacture, var1);
                  }
               }
            }

            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Dé-validation manuelle inscription ID N° " + this.elevesInscription.getEleinsId() + " période du " + this.elevesInscription.getEleinsAnnee());
            this.espionDao.mAJEspion(var9, var1);
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

      this.chargerFactures((Session)null);
   }

   public void calculeFiliere() throws HibernateException, NamingException, ParseException {
      if (this.var_filiere != 0L) {
         this.filieresEducation = this.filieresEducationDao.pourParapheur(this.var_filiere, (Session)null);
         if (this.filieresEducation != null) {
            this.elevesInscription.setEleinsTarifAssociation(this.filieresEducation.getFilTarifAssociation());
            this.elevesInscription.setEleinsTarifCantine(this.filieresEducation.getFilTarifCantine());
            this.elevesInscription.setEleinsTarifDivers(this.filieresEducation.getFilTarifDivers());
            this.elevesInscription.setEleinsTarifDossier(this.filieresEducation.getFilTarifDossier());
            this.elevesInscription.setEleinsTarifExamens(this.filieresEducation.getFilTarifExamens());
            this.elevesInscription.setEleinsTarifInscription(this.filieresEducation.getFilTarifInscription());
            this.elevesInscription.setEleinsTarifReinscription(this.filieresEducation.getFilTarifReinscription());
            this.elevesInscription.setEleinsTarifScolarite(this.filieresEducation.getFilTarifScolarite());
            this.elevesInscription.setEleinsTarifTenue(this.filieresEducation.getFilTarifTenue());
            this.elevesInscription.setEleinsTarifTransport(this.filieresEducation.getFilTarifTransport());
            this.elevesInscription.setEleinsnbMois(this.filieresEducation.getFilnbMois());
            this.elevesInscription.setEleinsnbTrimestre(this.filieresEducation.getFilnbTrimestre());
            this.elevesInscription.setEleinsnbSemestre(this.filieresEducation.getFilnbSemestre());
            this.calculDecoupage();
         }
      }

   }

   public void calculDecoupage() throws ParseException {
      if (this.elevesInscription.getEleinsDate() == null) {
         this.elevesInscription.setEleinsDateFacturation(new Date());
      }

      if (this.elevesInscription.getEleinsDateFacturation() == null) {
         this.elevesInscription.setEleinsDateFacturation(this.elevesInscription.getEleinsDate());
      }

      this.elevesInscription.setEleinsDateEche01((Date)null);
      this.elevesInscription.setEleinsScolarite01(0.0D);
      this.elevesInscription.setEleinsTransport01(0.0D);
      this.elevesInscription.setEleinsCantine01(0.0D);
      this.elevesInscription.setEleinsDateEche02((Date)null);
      this.elevesInscription.setEleinsScolarite02(0.0D);
      this.elevesInscription.setEleinsTransport02(0.0D);
      this.elevesInscription.setEleinsCantine02(0.0D);
      this.elevesInscription.setEleinsDateEche03((Date)null);
      this.elevesInscription.setEleinsScolarite03(0.0D);
      this.elevesInscription.setEleinsTransport03(0.0D);
      this.elevesInscription.setEleinsCantine03(0.0D);
      this.elevesInscription.setEleinsDateEche04((Date)null);
      this.elevesInscription.setEleinsScolarite04(0.0D);
      this.elevesInscription.setEleinsTransport04(0.0D);
      this.elevesInscription.setEleinsCantine04(0.0D);
      this.elevesInscription.setEleinsDateEche05((Date)null);
      this.elevesInscription.setEleinsScolarite05(0.0D);
      this.elevesInscription.setEleinsTransport05(0.0D);
      this.elevesInscription.setEleinsCantine05(0.0D);
      this.elevesInscription.setEleinsDateEche06((Date)null);
      this.elevesInscription.setEleinsScolarite06(0.0D);
      this.elevesInscription.setEleinsTransport06(0.0D);
      this.elevesInscription.setEleinsCantine06(0.0D);
      this.elevesInscription.setEleinsDateEche07((Date)null);
      this.elevesInscription.setEleinsScolarite07(0.0D);
      this.elevesInscription.setEleinsTransport07(0.0D);
      this.elevesInscription.setEleinsCantine07(0.0D);
      this.elevesInscription.setEleinsDateEche08((Date)null);
      this.elevesInscription.setEleinsScolarite08(0.0D);
      this.elevesInscription.setEleinsTransport08(0.0D);
      this.elevesInscription.setEleinsCantine08(0.0D);
      this.elevesInscription.setEleinsDateEche09((Date)null);
      this.elevesInscription.setEleinsScolarite09(0.0D);
      this.elevesInscription.setEleinsTransport09(0.0D);
      this.elevesInscription.setEleinsCantine09(0.0D);
      this.elevesInscription.setEleinsDateEche10((Date)null);
      this.elevesInscription.setEleinsScolarite10(0.0D);
      this.elevesInscription.setEleinsTransport10(0.0D);
      this.elevesInscription.setEleinsCantine10(0.0D);
      this.elevesInscription.setEleinsDateEche11((Date)null);
      this.elevesInscription.setEleinsScolarite11(0.0D);
      this.elevesInscription.setEleinsTransport11(0.0D);
      this.elevesInscription.setEleinsCantine11(0.0D);
      this.elevesInscription.setEleinsDateEche12((Date)null);
      this.elevesInscription.setEleinsScolarite12(0.0D);
      this.elevesInscription.setEleinsTransport12(0.0D);
      this.elevesInscription.setEleinsCantine12(0.0D);
      byte var1 = 0;
      if (this.elevesInscription.getEleinsDateFacturation() != null) {
         int var10;
         if (this.elevesInscription.getEleinsModeScolarite() == 0) {
            var10 = var1 + 1;
            this.elevesInscription.setEleinsDateEche01(this.utilDate.datePremierJourMois(this.elevesInscription.getEleinsDateFacturation()));
            this.elevesInscription.setEleinsScolarite01(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsTransport01(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsCantine01(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
            ++var10;
            this.elevesInscription.setEleinsDateEche02(this.utilDate.datePremierJourMois(this.utilDate.dateMoisSuivant(this.elevesInscription.getEleinsDateEche01())));
            this.elevesInscription.setEleinsScolarite02(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsTransport02(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsCantine02(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
            if (var10 > this.elevesInscription.getEleinsnbMois()) {
               this.elevesInscription.setEleinsDateEche02((Date)null);
               this.elevesInscription.setEleinsScolarite02(0.0D);
               this.elevesInscription.setEleinsTransport02(0.0D);
               this.elevesInscription.setEleinsCantine02(0.0D);
            } else {
               ++var10;
               this.elevesInscription.setEleinsDateEche03(this.utilDate.datePremierJourMois(this.utilDate.dateMoisSuivant(this.elevesInscription.getEleinsDateEche02())));
               this.elevesInscription.setEleinsScolarite03(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
               this.elevesInscription.setEleinsTransport03(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
               this.elevesInscription.setEleinsCantine03(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
               if (var10 > this.elevesInscription.getEleinsnbMois() && this.elevesInscription.getEleinsDateEche03().compareTo(this.exercicesVentes.getExevteDateFin()) > 0) {
                  this.elevesInscription.setEleinsDateEche03((Date)null);
                  this.elevesInscription.setEleinsScolarite03(0.0D);
                  this.elevesInscription.setEleinsTransport03(0.0D);
                  this.elevesInscription.setEleinsCantine03(0.0D);
               } else {
                  ++var10;
                  this.elevesInscription.setEleinsDateEche04(this.utilDate.datePremierJourMois(this.utilDate.dateMoisSuivant(this.elevesInscription.getEleinsDateEche03())));
                  this.elevesInscription.setEleinsScolarite04(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                  this.elevesInscription.setEleinsTransport04(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                  this.elevesInscription.setEleinsCantine04(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                  if (var10 > this.elevesInscription.getEleinsnbMois()) {
                     this.elevesInscription.setEleinsDateEche04((Date)null);
                     this.elevesInscription.setEleinsScolarite04(0.0D);
                     this.elevesInscription.setEleinsTransport04(0.0D);
                     this.elevesInscription.setEleinsCantine04(0.0D);
                  } else {
                     ++var10;
                     this.elevesInscription.setEleinsDateEche05(this.utilDate.datePremierJourMois(this.utilDate.dateMoisSuivant(this.elevesInscription.getEleinsDateEche04())));
                     this.elevesInscription.setEleinsScolarite05(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                     this.elevesInscription.setEleinsTransport05(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                     this.elevesInscription.setEleinsCantine05(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                     if (var10 > this.elevesInscription.getEleinsnbMois()) {
                        this.elevesInscription.setEleinsDateEche05((Date)null);
                        this.elevesInscription.setEleinsScolarite05(0.0D);
                        this.elevesInscription.setEleinsTransport05(0.0D);
                        this.elevesInscription.setEleinsCantine05(0.0D);
                     } else {
                        ++var10;
                        this.elevesInscription.setEleinsDateEche06(this.utilDate.datePremierJourMois(this.utilDate.dateMoisSuivant(this.elevesInscription.getEleinsDateEche05())));
                        this.elevesInscription.setEleinsScolarite06(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                        this.elevesInscription.setEleinsTransport06(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                        this.elevesInscription.setEleinsCantine06(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                        if (var10 > this.elevesInscription.getEleinsnbMois()) {
                           this.elevesInscription.setEleinsDateEche06((Date)null);
                           this.elevesInscription.setEleinsScolarite06(0.0D);
                           this.elevesInscription.setEleinsTransport06(0.0D);
                           this.elevesInscription.setEleinsCantine06(0.0D);
                        } else {
                           ++var10;
                           this.elevesInscription.setEleinsDateEche07(this.utilDate.datePremierJourMois(this.utilDate.dateMoisSuivant(this.elevesInscription.getEleinsDateEche06())));
                           this.elevesInscription.setEleinsScolarite07(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                           this.elevesInscription.setEleinsTransport07(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                           this.elevesInscription.setEleinsCantine07(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                           if (var10 > this.elevesInscription.getEleinsnbMois()) {
                              this.elevesInscription.setEleinsDateEche07((Date)null);
                              this.elevesInscription.setEleinsScolarite07(0.0D);
                              this.elevesInscription.setEleinsTransport07(0.0D);
                              this.elevesInscription.setEleinsCantine07(0.0D);
                           } else {
                              ++var10;
                              this.elevesInscription.setEleinsDateEche08(this.utilDate.datePremierJourMois(this.utilDate.dateMoisSuivant(this.elevesInscription.getEleinsDateEche07())));
                              this.elevesInscription.setEleinsScolarite08(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                              this.elevesInscription.setEleinsTransport08(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                              this.elevesInscription.setEleinsCantine08(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                              if (var10 > this.elevesInscription.getEleinsnbMois()) {
                                 this.elevesInscription.setEleinsDateEche08((Date)null);
                                 this.elevesInscription.setEleinsScolarite08(0.0D);
                                 this.elevesInscription.setEleinsTransport08(0.0D);
                                 this.elevesInscription.setEleinsCantine08(0.0D);
                              } else {
                                 ++var10;
                                 this.elevesInscription.setEleinsDateEche09(this.utilDate.datePremierJourMois(this.utilDate.dateMoisSuivant(this.elevesInscription.getEleinsDateEche08())));
                                 this.elevesInscription.setEleinsScolarite09(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                 this.elevesInscription.setEleinsTransport09(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                 this.elevesInscription.setEleinsCantine09(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                 if (var10 > this.elevesInscription.getEleinsnbMois()) {
                                    this.elevesInscription.setEleinsDateEche09((Date)null);
                                    this.elevesInscription.setEleinsScolarite09(0.0D);
                                    this.elevesInscription.setEleinsTransport09(0.0D);
                                    this.elevesInscription.setEleinsCantine09(0.0D);
                                 } else {
                                    ++var10;
                                    this.elevesInscription.setEleinsDateEche10(this.utilDate.datePremierJourMois(this.utilDate.dateMoisSuivant(this.elevesInscription.getEleinsDateEche09())));
                                    this.elevesInscription.setEleinsScolarite10(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                    this.elevesInscription.setEleinsTransport10(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                    this.elevesInscription.setEleinsCantine10(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                    if (var10 > this.elevesInscription.getEleinsnbMois()) {
                                       this.elevesInscription.setEleinsDateEche10((Date)null);
                                       this.elevesInscription.setEleinsScolarite10(0.0D);
                                       this.elevesInscription.setEleinsTransport10(0.0D);
                                       this.elevesInscription.setEleinsCantine10(0.0D);
                                    } else {
                                       ++var10;
                                       this.elevesInscription.setEleinsDateEche11(this.utilDate.datePremierJourMois(this.utilDate.dateMoisSuivant(this.elevesInscription.getEleinsDateEche10())));
                                       this.elevesInscription.setEleinsScolarite11(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                       this.elevesInscription.setEleinsTransport11(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                       this.elevesInscription.setEleinsCantine11(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                       if (var10 > this.elevesInscription.getEleinsnbMois()) {
                                          this.elevesInscription.setEleinsDateEche11((Date)null);
                                          this.elevesInscription.setEleinsScolarite11(0.0D);
                                          this.elevesInscription.setEleinsTransport11(0.0D);
                                          this.elevesInscription.setEleinsCantine11(0.0D);
                                       } else {
                                          ++var10;
                                          this.elevesInscription.setEleinsDateEche12(this.utilDate.datePremierJourMois(this.utilDate.dateMoisSuivant(this.elevesInscription.getEleinsDateEche11())));
                                          this.elevesInscription.setEleinsScolarite12(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                          this.elevesInscription.setEleinsTransport12(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                          this.elevesInscription.setEleinsCantine12(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbMois(), this.structureLog.getStrdevise()));
                                          if (var10 > this.elevesInscription.getEleinsnbMois()) {
                                             this.elevesInscription.setEleinsDateEche12((Date)null);
                                             this.elevesInscription.setEleinsScolarite12(0.0D);
                                             this.elevesInscription.setEleinsTransport12(0.0D);
                                             this.elevesInscription.setEleinsCantine12(0.0D);
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
            }
         } else if (this.elevesInscription.getEleinsModeScolarite() == 1) {
            var10 = var1 + 1;
            this.elevesInscription.setEleinsDateEche01(this.utilDate.datePremierJourMois(this.elevesInscription.getEleinsDateFacturation()));
            this.elevesInscription.setEleinsScolarite01(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsTransport01(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsCantine01(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
            ++var10;
            this.elevesInscription.setEleinsDateEche02(this.utilDate.datePremierJourMois(this.utilDate.datedevaleurMois(this.elevesInscription.getEleinsDateEche01(), 3)));
            this.elevesInscription.setEleinsScolarite02(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsTransport02(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsCantine02(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
            if (var10 > this.elevesInscription.getEleinsnbTrimestre()) {
               this.elevesInscription.setEleinsDateEche02((Date)null);
               this.elevesInscription.setEleinsScolarite02(0.0D);
               this.elevesInscription.setEleinsTransport02(0.0D);
               this.elevesInscription.setEleinsCantine02(0.0D);
            } else {
               ++var10;
               this.elevesInscription.setEleinsDateEche03(this.utilDate.datePremierJourMois(this.utilDate.datedevaleurMois(this.elevesInscription.getEleinsDateEche02(), 3)));
               this.elevesInscription.setEleinsScolarite03(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
               this.elevesInscription.setEleinsTransport03(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
               this.elevesInscription.setEleinsCantine03(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
               if (var10 > this.elevesInscription.getEleinsnbTrimestre()) {
                  this.elevesInscription.setEleinsDateEche03((Date)null);
                  this.elevesInscription.setEleinsScolarite03(0.0D);
                  this.elevesInscription.setEleinsTransport03(0.0D);
                  this.elevesInscription.setEleinsCantine03(0.0D);
               } else {
                  ++var10;
                  this.elevesInscription.setEleinsDateEche04(this.utilDate.datePremierJourMois(this.utilDate.datedevaleurMois(this.elevesInscription.getEleinsDateEche03(), 3)));
                  this.elevesInscription.setEleinsScolarite04(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
                  this.elevesInscription.setEleinsTransport04(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
                  this.elevesInscription.setEleinsCantine04(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbTrimestre(), this.structureLog.getStrdevise()));
                  if (var10 > this.elevesInscription.getEleinsnbTrimestre()) {
                     this.elevesInscription.setEleinsDateEche04((Date)null);
                     this.elevesInscription.setEleinsScolarite04(0.0D);
                     this.elevesInscription.setEleinsTransport04(0.0D);
                     this.elevesInscription.setEleinsCantine04(0.0D);
                  }
               }
            }
         } else if (this.elevesInscription.getEleinsModeScolarite() == 2) {
            var10 = var1 + 1;
            this.elevesInscription.setEleinsDateEche01(this.utilDate.datePremierJourMois(this.elevesInscription.getEleinsDateFacturation()));
            this.elevesInscription.setEleinsScolarite01(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbSemestre(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsTransport01(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbSemestre(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsCantine01(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbSemestre(), this.structureLog.getStrdevise()));
            ++var10;
            this.elevesInscription.setEleinsDateEche02(this.utilDate.datePremierJourMois(this.utilDate.datedevaleurMois(this.elevesInscription.getEleinsDateEche01(), 6)));
            this.elevesInscription.setEleinsScolarite02(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifScolarite() / (double)this.elevesInscription.getEleinsnbSemestre(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsTransport02(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifTransport() / (double)this.elevesInscription.getEleinsnbSemestre(), this.structureLog.getStrdevise()));
            this.elevesInscription.setEleinsCantine02(this.utilNombre.myRoundDevise(this.elevesInscription.getEleinsTarifCantine() / (double)this.elevesInscription.getEleinsnbSemestre(), this.structureLog.getStrdevise()));
            if (var10 > this.elevesInscription.getEleinsnbSemestre()) {
               this.elevesInscription.setEleinsDateEche02((Date)null);
               this.elevesInscription.setEleinsScolarite02(0.0D);
               this.elevesInscription.setEleinsTransport02(0.0D);
               this.elevesInscription.setEleinsCantine02(0.0D);
            }
         } else if (this.elevesInscription.getEleinsModeScolarite() == 3) {
            this.elevesInscription.setEleinsDateEche01(this.utilDate.datePremierJourMois(this.elevesInscription.getEleinsDateFacturation()));
            this.elevesInscription.setEleinsScolarite01(this.elevesInscription.getEleinsTarifScolarite());
            this.elevesInscription.setEleinsTransport01(this.elevesInscription.getEleinsTarifTransport());
            this.elevesInscription.setEleinsCantine01(this.elevesInscription.getEleinsTarifCantine());
         }

         double var2 = this.elevesInscription.getEleinsScolarite01() + this.elevesInscription.getEleinsScolarite02() + this.elevesInscription.getEleinsScolarite03() + this.elevesInscription.getEleinsScolarite04() + this.elevesInscription.getEleinsScolarite05() + this.elevesInscription.getEleinsScolarite06() + this.elevesInscription.getEleinsScolarite07() + this.elevesInscription.getEleinsScolarite08() + this.elevesInscription.getEleinsScolarite09() + this.elevesInscription.getEleinsScolarite10() + this.elevesInscription.getEleinsScolarite11() + this.elevesInscription.getEleinsScolarite12();
         double var4;
         if (var2 != this.elevesInscription.getEleinsTarifScolarite()) {
            var4 = this.elevesInscription.getEleinsTarifScolarite() - var2;
            this.elevesInscription.setEleinsScolarite01(this.elevesInscription.getEleinsScolarite01() + var4);
         }

         var4 = this.elevesInscription.getEleinsTransport01() + this.elevesInscription.getEleinsTransport02() + this.elevesInscription.getEleinsTransport03() + this.elevesInscription.getEleinsTransport04() + this.elevesInscription.getEleinsTransport05() + this.elevesInscription.getEleinsTransport06() + this.elevesInscription.getEleinsTransport07() + this.elevesInscription.getEleinsTransport08() + this.elevesInscription.getEleinsTransport09() + this.elevesInscription.getEleinsTransport10() + this.elevesInscription.getEleinsTransport11() + this.elevesInscription.getEleinsTransport12();
         double var6;
         if (var4 != this.elevesInscription.getEleinsTarifTransport()) {
            var6 = this.elevesInscription.getEleinsTarifTransport() - var4;
            this.elevesInscription.setEleinsTransport01(this.elevesInscription.getEleinsTransport01() + var6);
         }

         var6 = this.elevesInscription.getEleinsCantine01() + this.elevesInscription.getEleinsCantine02() + this.elevesInscription.getEleinsCantine03() + this.elevesInscription.getEleinsCantine04() + this.elevesInscription.getEleinsCantine05() + this.elevesInscription.getEleinsCantine06() + this.elevesInscription.getEleinsCantine07() + this.elevesInscription.getEleinsCantine08() + this.elevesInscription.getEleinsCantine09() + this.elevesInscription.getEleinsCantine10() + this.elevesInscription.getEleinsCantine11() + this.elevesInscription.getEleinsCantine12();
         if (var6 != this.elevesInscription.getEleinsTarifCantine()) {
            double var8 = this.elevesInscription.getEleinsTarifCantine() - var6;
            this.elevesInscription.setEleinsCantine01(this.elevesInscription.getEleinsCantine01() + var8);
         }
      }

   }

   public void calculTotalScolarite() {
      this.elevesInscription.setEleinsTarifScolarite(this.elevesInscription.getEleinsScolarite01() + this.elevesInscription.getEleinsScolarite02() + this.elevesInscription.getEleinsScolarite03() + this.elevesInscription.getEleinsScolarite04() + this.elevesInscription.getEleinsScolarite05() + this.elevesInscription.getEleinsScolarite06() + this.elevesInscription.getEleinsScolarite07() + this.elevesInscription.getEleinsScolarite08() + this.elevesInscription.getEleinsScolarite09() + this.elevesInscription.getEleinsScolarite10() + this.elevesInscription.getEleinsScolarite11() + this.elevesInscription.getEleinsScolarite12());
      this.elevesInscription.setEleinsTarifTransport(this.elevesInscription.getEleinsTransport01() + this.elevesInscription.getEleinsTransport02() + this.elevesInscription.getEleinsTransport03() + this.elevesInscription.getEleinsTransport04() + this.elevesInscription.getEleinsTransport05() + this.elevesInscription.getEleinsTransport06() + this.elevesInscription.getEleinsTransport07() + this.elevesInscription.getEleinsTransport08() + this.elevesInscription.getEleinsTransport09() + this.elevesInscription.getEleinsTransport10() + this.elevesInscription.getEleinsTransport11() + this.elevesInscription.getEleinsTransport12());
      this.elevesInscription.setEleinsTarifCantine(this.elevesInscription.getEleinsCantine01() + this.elevesInscription.getEleinsCantine02() + this.elevesInscription.getEleinsCantine03() + this.elevesInscription.getEleinsCantine04() + this.elevesInscription.getEleinsCantine05() + this.elevesInscription.getEleinsCantine06() + this.elevesInscription.getEleinsCantine07() + this.elevesInscription.getEleinsCantine08() + this.elevesInscription.getEleinsCantine09() + this.elevesInscription.getEleinsCantine10() + this.elevesInscription.getEleinsCantine11() + this.elevesInscription.getEleinsCantine12());
   }

   public void accesSituation() {
      if (this.eleves != null) {
         this.var_action = 4;
      }

   }

   public void retourDocuments() {
      this.var_action = 0;
   }

   public void selectionFacture() throws HibernateException, NamingException {
      if (this.datamodelFacturation.isRowAvailable()) {
         this.elevesFacture = (ElevesFacture)this.datamodelFacturation.getRowData();
         this.afficheButtFacture = true;
         this.site = this.elevesFacture.getElefacSite();
         this.departement = this.elevesFacture.getElefacDepartement();
         this.service = this.elevesFacture.getElefacService();
         this.region = this.elevesFacture.getElefacRegion();
         this.secteur = this.elevesFacture.getElefacSecteur();
         this.pdv = this.elevesFacture.getElefacPdv();
         this.caisse = this.elevesFacture.getElefacCaisse();
         this.responsable = this.elevesFacture.getElefacIdResponsable();
         this.commercial = this.elevesFacture.getElefacIdCommercial();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
         this.chargerReglement(var1);
         this.utilInitHibernate.closeSession();
         if (this.elevesFacture.getElefacTotal() + this.elevesFacture.getElefacTotalTaxe() + this.elevesFacture.getElefacTotalTc() > this.elevesFacture.getElefacReglement()) {
            if (this.usersLog.getUsrFactureCaisse() == 0) {
               this.var_affiche_be = false;
               this.var_affiche_dollar = false;
            } else if (this.usersLog.getUsrFactureCaisse() == 1) {
               this.var_affiche_be = true;
               this.var_affiche_dollar = false;
            } else if (this.usersLog.getUsrFactureCaisse() == 2) {
               this.var_affiche_be = false;
               this.var_affiche_dollar = true;
            } else if (this.usersLog.getUsrFactureCaisse() == 3) {
               this.var_affiche_be = true;
               this.var_affiche_dollar = true;
            }
         } else {
            this.var_affiche_be = false;
            this.var_affiche_dollar = false;
         }
      }

   }

   public void consulterFacture() {
      if (this.elevesFacture != null) {
         this.var_actionFacture = 3;
         this.showModalPanelFacture = true;
      }

   }

   public void fermerFacture() {
      this.showModalPanelFacture = false;
   }

   public void initImprimerFacture() {
      this.var_choix_modele = 0;
      this.affListeDoc = false;
      this.nomModeleDocument = "";
      this.nomModeleListe = "";
      this.documentImpressionItems.clear();
      String var1 = "";
      var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "situation" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      int var4;
      String var5;
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.documentImpressionItems.add(new SelectItem(var5));
            }
         }
      }

      var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "situation" + File.separator;
      var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.listeImpressionItems.add(new SelectItem(var5));
            }
         }
      }

      this.showModalPanelPrintSituation = true;
   }

   public void closeImpressionSituation() {
      this.showModalPanelPrintSituation = false;
   }

   public void imprimerPRTSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimerSituation();
   }

   public void imprimerJRVSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerSituation();
   }

   public void imprimerPDFSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerSituation();
   }

   public void imprimerODTSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimerSituation();
   }

   public void imprimerXLSSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimerSituation();
   }

   public void imprimerDOCSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimerSituation();
   }

   public void imprimerHTMLSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimerSituation();
   }

   public void imprimerXMLSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimerSituation();
   }

   public void imprimerMAILSituation() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimerSituation();
      }

   }

   public void envoieMAILSituation() throws SQLException, JRException, IOException, HibernateException, NamingException {
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

   public void imprimerSituation() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            this.utilPrint.setSource("");
            this.utilPrint.setRecordPath("");
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setRequete("");
            this.utilPrint.setFiltre("");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "situation" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Impression facture");
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            ArrayList var1 = new ArrayList();
            var1.add(this.elevesFacture);
            JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
            this.utilPrint.setNumDoc(this.elevesFacture.getElefacNum());
            this.utilPrint.setNature(102);
            this.utilPrint.setId_doc(this.elevesFacture.getElefacId());
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
            this.utilPrint.setEntete("Impression de la situation de l`eleve");
            this.utilPrint.setRequete("");
            this.utilPrint.setFiltre("");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "situation" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.lesFactures);
            this.utilPrint.setjRBeanCollectionDataSource(var3);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.var_choix_modele == 2) {
         this.reglements = this.reglementsDao.pourParapheur(this.nomModeleRecu, (Session)null);
         if (this.reglements != null && this.reglements.getRglModele() != null && !this.reglements.getRglModele().isEmpty()) {
            this.impressionRecu(this.format);
         }
      }

   }

   public void payeDocumentBonEncaissement() throws HibernateException, NamingException {
      if (this.elevesFacture != null) {
         this.caissesCommerciales = new CaissesCommerciales();
         if (this.caissesCommercialesDao == null) {
            this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
         }

         this.bonEncaissementVente = new BonEncaissementVente();
         this.bonEncaissementVente.setBonCodeCaisse((String)null);
         this.bonEncaissementVente.setBonLibCaisse((String)null);
         this.bonEncaissementVente.setBonDate(new Date());
         this.mesTypeReglementsCaisse.clear();
         this.var_nom_client = "";
         this.var_num_facture = "";
         this.var_montant = "";
         this.var_inputCaisse = "0";
         this.var_ecart_reglement = 0.0D;
         this.var_type_reg = "0";
         this.var_objet = "";
         this.var_banque_tireur = "";
         this.var_num_cheque = "";
         this.var_banque_destination = "";
         this.var_affiche_banque = false;
         this.var_affiche_banque_destination = false;
         this.var_date_trf = new Date();
         this.calculeCaisseDisponibleBencaissement();
         if (this.var_tot_bon_encaissement > this.elevesFacture.getSolde()) {
            this.elevesFacture.setElefacTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.var_netAPayer = this.elevesFacture.getSolde() - this.var_tot_bon_encaissement;
            this.verifBonEncaissement();
         } else {
            if (this.elevesFacture.getElefacTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.elevesFacture.getElefacEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.var_netAPayer = this.elevesFacture.getSolde() - this.var_tot_bon_encaissement;
               this.var_affiche_valide = true;
            } else {
               this.elevesFacture.setElefacTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.elevesFacture.getSolde() - this.var_tot_bon_encaissement;
               this.verifBonEncaissement();
            }

            this.var_affichMontant = true;
         }

         this.montantElmTotBonEnc = this.var_netAPayer;
         this.showModalPanelPaye = true;
      }

   }

   public void verifBonEncaissement() {
      if (Math.abs(this.montantElmTotBonEnc) <= Math.abs(this.elevesFacture.getTotalTtc() - this.elevesFacture.getElefacReglement() - this.var_tot_bon_encaissement)) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

      if (this.varTypeReg == 90 && this.montantElmTotBonEnc > this.eleves.getEleDepotAvance()) {
         this.montantElmTotBonEnc = this.eleves.getEleDepotAvance();
      }

   }

   public void calculeCaisseDisponibleBencaissement() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && (this.elevesFacture.getElefacSerie() == null || this.elevesFacture.getElefacSerie().isEmpty() || this.elevesFacture.getElefacSerie() != null && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.elevesFacture.getElefacSerie()))) {
               String var2 = ((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var1)).getUsrchrLib();
               this.mesCaissesSeriesItems.add(new SelectItem(var2));
            }
         }
      }

   }

   public void choixCaisseXReglementBencaissement() throws HibernateException, NamingException {
      this.var_type_reg = "";
      this.var_affiche_banque = false;
      this.var_affiche_banque_destination = false;
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty()) {
         this.calculeTypeReglementCaisse();
         this.selectionBanqueDestinationBencaissement();
         this.choixTypeReglementBencaissement();
      }

   }

   public void choixTypeReglementBencaissement() throws HibernateException, NamingException {
      if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
         String[] var1 = this.var_type_reg.split(":");
         this.varTypeReg = Integer.parseInt(var1[0]);
      } else {
         this.varTypeReg = 0;
      }

      if (this.varTypeReg != 1 && this.varTypeReg != 2 && this.varTypeReg != 3 && this.varTypeReg != 4 && this.varTypeReg != 6 && this.varTypeReg != 7 && this.varTypeReg != 13 && this.varTypeReg != 14) {
         this.var_affiche_banque = false;
      } else {
         this.var_affiche_banque = true;
      }

      if (this.varTypeReg == 90 && this.montantElmTotBonEnc > this.eleves.getEleDepotAvance()) {
         this.montantElmTotBonEnc = this.eleves.getEleDepotAvance();
      }

   }

   public void selectionBanqueDestinationBencaissement() throws HibernateException, NamingException {
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         String[] var1 = this.var_inputCaisse.split(":");
         this.bonEncaissementVente.setBonCodeCaisse(var1[0]);
         this.bonEncaissementVente.setBonLibCaisse(var1[1]);
      } else {
         this.bonEncaissementVente.setBonCodeCaisse((String)null);
         this.bonEncaissementVente.setBonLibCaisse((String)null);
      }

   }

   public void annulePaye() {
      this.showModalPanelPaye = false;
   }

   public void miseajourPaye() throws HibernateException, NamingException {
      if (Math.abs(this.var_tot_bon_encaissement) <= Math.abs(this.elevesFacture.getTotalTtc())) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.elevesFacture.getElefacTypeReg() == 5) {
               this.elevesFacture = this.elevesFactureDao.modif(this.elevesFacture, var1);
               new Habilitation();
               HabilitationDao var12 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
               Habilitation var11 = var12.existenceHabilitation(this.nature, var1);
               if (var11 != null) {
               }
            } else {
               String var3 = this.calculChrono.numCompose(new Date(), 109, this.elevesFacture.getElefacSerie(), var1);
               if (var3 != null && !var3.isEmpty()) {
                  this.bonEncaissementVente = new BonEncaissementVente();
                  String[] var4;
                  if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                     var4 = this.var_inputCaisse.split(":");
                     this.bonEncaissementVente.setBonCodeCaisse(var4[0]);
                     this.bonEncaissementVente.setBonLibCaisse(var4[1]);
                     if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
                        String[] var5 = this.var_type_reg.split(":");
                        this.bonEncaissementVente.setBonTypeReg(Integer.parseInt(var5[0]));
                     } else {
                        this.bonEncaissementVente.setBonTypeReg(0);
                     }
                  } else {
                     this.bonEncaissementVente.setBonCodeCaisse((String)null);
                     this.bonEncaissementVente.setBonLibCaisse((String)null);
                     this.bonEncaissementVente.setBonTypeReg(0);
                  }

                  if (this.var_banque_destination != null && !this.var_banque_destination.isEmpty() && this.var_banque_destination.contains(":")) {
                     var4 = this.var_banque_destination.split(":");
                     this.bonEncaissementVente.setBonCodeBanq(var4[0]);
                     this.bonEncaissementVente.setBonLibBanq(var4[1]);
                  } else {
                     this.bonEncaissementVente.setBonCodeBanq((String)null);
                     this.bonEncaissementVente.setBonLibBanq((String)null);
                  }

                  this.bonEncaissementVente.setBonBanqueTireur(this.var_banque_tireur);
                  this.bonEncaissementVente.setBonNumChqBdx(this.var_num_cheque);
                  this.bonEncaissementVente.setBonDateCreat(new Date());
                  this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
                  this.bonEncaissementVente.setBonActivite("");
                  this.bonEncaissementVente.setBonSite(this.elevesFacture.getElefacSite());
                  this.bonEncaissementVente.setBonDepartement(this.elevesFacture.getElefacDepartement());
                  this.bonEncaissementVente.setBonService(this.elevesFacture.getElefacService());
                  this.bonEncaissementVente.setBonRegion(this.elevesFacture.getElefacRegion());
                  this.bonEncaissementVente.setBonSecteur(this.elevesFacture.getElefacSecteur());
                  this.bonEncaissementVente.setBonPdv(this.elevesFacture.getElefacPdv());
                  this.bonEncaissementVente.setBonDateEcheReg((Date)null);
                  this.bonEncaissementVente.setBonEtat(0);
                  this.bonEncaissementVente.setBonNatRef(102);
                  this.bonEncaissementVente.setBonNomTiers(this.elevesFacture.getEleves().getPatronyme());
                  this.bonEncaissementVente.setBonIdTiers(this.elevesFacture.getEleves().getEleId());
                  this.bonEncaissementVente.setBonNomContact("");
                  this.bonEncaissementVente.setBonIdContact(0L);
                  this.bonEncaissementVente.setBonTypeTiers(5);
                  this.bonEncaissementVente.setBonLibelle("Règlement Facture N° " + this.elevesFacture.getElefacNum());
                  this.bonEncaissementVente.setBonRef(this.elevesFacture.getElefacNum());
                  this.bonEncaissementVente.setBonIdRef(this.elevesFacture.getElefacId());
                  this.bonEncaissementVente.setBonObject(this.elevesFacture.getLibelleType());
                  this.bonEncaissementVente.setBonObservation("");
                  this.bonEncaissementVente.setBonSerie(this.elevesFacture.getElefacSerie());
                  this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
                  this.bonEncaissementVente.setBonTotTtc(this.elevesFacture.getTotalTtc());
                  this.bonEncaissementVente.setBonAPayer(this.montantElmTotBonEnc);
                  this.bonEncaissementVente.setBonActif(0);
                  this.bonEncaissementVente.setBonNum(var3);
                  this.bonEncaissementVente.setBonDate(this.var_date_trf);
                  this.bonEncaissementVente.setBonIdResponsable(this.elevesFacture.getElefacIdResponsable());
                  this.bonEncaissementVente.setBonNomResponsable(this.elevesFacture.getElefacNomResponsable());
                  this.bonEncaissementVente.setBonIdCommercial(this.elevesFacture.getElefacIdCommercial());
                  this.bonEncaissementVente.setBonNomCommercial(this.elevesFacture.getElefacNomCommercial());
                  this.bonEncaissementVente.setBonIdEquipe(0L);
                  this.bonEncaissementVente.setBonNomEquipe("");
                  this.bonEncaissementVente.setBonGrp(this.usersLog.getUsrCollaboration());
                  this.bonEncaissementVente.setBonClient("");
                  this.bonEncaissementVente.setBonFacture("");
                  this.bonEncaissementVente.setBonMontant("");
                  this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
               } else {
                  this.formRecherche.setMessageTexte("Le chrono du bon d`encaissement n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
                  this.formRecherche.setShowModalPanelMessage(true);
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
      }

      this.chargerFactures((Session)null);
      this.showModalPanelPaye = false;
   }

   public void payeXDocumentRecu() throws HibernateException, NamingException {
      this.reglements = new Reglements();
      this.caissesCommerciales = new CaissesCommerciales();
      if (this.caissesCommercialesDao == null) {
         this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      }

      this.mesTypeReglementsCaisse.clear();
      this.var_inputCaisse = "0";
      this.var_ecart_reglement = 0.0D;
      this.var_type_reg = "0";
      this.var_objet = "";
      this.var_banque_tireur = "";
      this.var_num_cheque = "";
      this.var_banque_destination = "";
      this.var_affiche_banque = false;
      this.var_affiche_banque_destination = false;
      this.repartitionManuelle = false;
      this.var_affichMontant = false;
      this.totManuel = 0.0D;
      this.ecartManuel = 0.0D;
      this.val_timbre = 0.0D;
      this.totalPayerTimbre = 0.0D;
      this.var_date_trf = new Date();
      this.calculeCaisseDisponibleBrecu();
      if (this.lesFactures.size() != 0) {
         this.listFactureSelectionne = new ArrayList();
         double var1 = 0.0D;
         double var3 = 0.0D;
         double var5 = 0.0D;

         for(int var7 = 0; var7 < this.lesFactures.size(); ++var7) {
            new ElevesFacture();
            ElevesFacture var8 = (ElevesFacture)this.lesFactures.get(var7);
            if (var8.getElefacTotal() + var8.getElefacTotalTaxe() + var8.getElefacTotalTc() > var8.getElefacReglement()) {
               var1 += var8.getElefacTotal();
               var3 += var8.getElefacReglement();
               var5 += var8.getVar_reliquat();
               this.listFactureSelectionne.add(var8);
            }
         }

         if (this.listFactureSelectionne.size() != 0) {
            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
            this.reglements = new Reglements();
            this.var_date_trf = new Date();
            this.var_netAPayer = var5;
            this.montantElmTotBonEnc = var5;
            this.var_affichMontant = true;
            this.varTypeReg = 0;
            this.choixTypeReglement();
            this.choixCaisseXReglement();
            this.verifValide();
            this.showModalPanelReglement = true;
         }
      }

   }

   public void calculeCaisseDisponibleBrecu() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && (this.elevesFacture.getElefacSerie() == null || this.elevesFacture.getElefacSerie().isEmpty() || this.elevesFacture.getElefacSerie() != null && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.elevesFacture.getElefacSerie()))) {
               String var2 = ((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var1)).getUsrchrLib();
               this.mesCaissesSeriesItems.add(new SelectItem(var2));
            }
         }

         if (this.mesCaissesSeriesItems.size() != 0) {
            this.var_inputCaisse = ((SelectItem)this.mesCaissesSeriesItems.get(0)).getValue().toString();
         } else {
            this.var_inputCaisse = "";
         }

         this.choixCaisseXReglement();
      }

   }

   public void choixCaisseXReglement() throws HibernateException, NamingException {
      this.var_type_reg = "";
      this.var_affiche_banque = false;
      this.var_affiche_banque_destination = false;
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty()) {
         this.calculeTypeReglementCaisse();
         this.selectionBanqueDestination();
         this.choixTypeReglement();
         this.verifValide();
      }

   }

   public void selectionBanqueDestination() throws HibernateException, NamingException {
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         String[] var1 = this.var_inputCaisse.split(":");
         this.reglements.setRglCodeCaiss(var1[0]);
         this.reglements.setRglLibCaiss(var1[1]);
      } else {
         this.reglements.setRglCodeCaiss((String)null);
         this.reglements.setRglLibCaiss((String)null);
      }

   }

   public void verifValide() {
      this.var_affiche_valide = false;
      if (this.montantElmTotBonEnc != 0.0D) {
         this.var_affiche_valide = true;
      }

      this.calculValeurTimbre();
      this.controleEcartRepartitionManuelle();
   }

   public void calulNetPayer() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      this.var_netAPayer = 0.0D;

      for(int var5 = 0; var5 < this.listFactureSelectionne.size(); ++var5) {
         new ElevesFacture();
         ElevesFacture var6 = (ElevesFacture)this.listFactureSelectionne.get(var5);
         if (var6.isVar_select_ligne()) {
            var1 += var6.getElefacTotal();
            var3 += var6.getElefacReglement();
         }
      }

      this.var_netAPayer = var1 - var3;
   }

   public void choixTypeReglement() throws HibernateException, NamingException {
      if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
         String[] var1 = this.var_type_reg.split(":");
         this.varTypeReg = Integer.parseInt(var1[0]);
      } else {
         this.varTypeReg = 0;
      }

      if (this.varTypeReg != 1 && this.varTypeReg != 2 && this.varTypeReg != 3 && this.varTypeReg != 4 && this.varTypeReg != 6 && this.varTypeReg != 7 && this.varTypeReg != 13 && this.varTypeReg != 14) {
         this.var_affiche_banque = false;
      } else {
         this.var_affiche_banque = true;
         if (this.varTypeReg == 1) {
         }
      }

      if (this.varTypeReg == 90 && this.montantElmTotBonEnc > this.eleves.getEleDepotAvance()) {
         this.montantElmTotBonEnc = this.eleves.getEleDepotAvance();
      }

      this.calculeNomRep();
      this.calculValeurTimbre();
   }

   public void calculValeurTimbre() {
      this.var_netAPayer = 0.0D;
      this.val_timbre = 0.0D;
      this.totalPayerTimbre = 0.0D;
      int var1;
      if (this.varTypeReg == 0) {
         var1 = this.elevesFacture.getElefacDate().getYear() + 1900;
         this.val_timbre = this.utilNombre.calculTimbre(this.structureLog, this.montantElmTotBonEnc, var1, this.structureLog.getStrdevise(), this.elevesFacture.getElefacDate());
         this.totalPayerTimbre = this.montantElmTotBonEnc + this.val_timbre;
         double var2 = 0.0D;
         double var4 = this.montantElmTotBonEnc;
         if (this.listFactureSelectionne.size() != 0) {
            for(int var6 = 0; var6 < this.listFactureSelectionne.size(); ++var6) {
               new ElevesFacture();
               ElevesFacture var7 = (ElevesFacture)this.listFactureSelectionne.get(var6);
               if (this.montantElmTotBonEnc != 0.0D && var4 < var7.getElefacTotal() + var7.getElefacTotalTaxe() + var7.getElefacTotalTc() - var7.getElefacReglement()) {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getElefacTotal() + var7.getElefacTotalTaxe() + var7.getElefacTotalTc() - var7.getElefacReglement(), var1, this.structureLog.getStrdevise(), this.elevesFacture.getElefacDate());
               } else {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getElefacTotal() + var7.getElefacTotalTaxe() + var7.getElefacTotalTc() - var7.getElefacReglement(), var1, this.structureLog.getStrdevise(), this.elevesFacture.getElefacDate());
                  var4 = var4 - var7.getElefacTotal() + var7.getElefacTotalTaxe() + var7.getElefacTotalTc() - var7.getElefacReglement();
               }

               var7.setVar_fac_timbre(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
               this.var_netAPayer += var7.getVar_reliquat();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }
      } else if (this.varTypeReg != 0 && this.listFactureSelectionne.size() != 0) {
         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new ElevesFacture();
            ElevesFacture var8 = (ElevesFacture)this.listFactureSelectionne.get(var1);
            var8.setVar_fac_timbre(0.0D);
            this.var_netAPayer += var8.getVar_reliquat();
         }

         this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
      }

      this.var_ecart_reglement = this.var_netAPayer - this.montantElmTotBonEnc - this.val_timbre;
   }

   public void fermerXReglement() {
      this.showModalPanelReglement = false;
   }

   public void validerXreglement() throws HibernateException, NamingException, ParseException {
      if (this.montantElmTotBonEnc != 0.0D) {
         new OptionCaisses();
         LireLesoptionsCaisses var2 = new LireLesoptionsCaisses();
         var2.setStrId(this.structureLog.getStrid());
         OptionCaisses var1 = var2.lancer();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementEducation");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new ExercicesCaisse();
            ExercicesCaisseDao var6 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            ExercicesCaisse var5 = var6.recupererLastExo(var3);
            if (var5 != null) {
               String var7 = this.elevesFacture.getElefacSerie();
               String var8 = "";
               String var9 = "" + this.varTypeReg;
               if (var1.getChronoReglement() != null && !var1.getChronoReglement().isEmpty() && var1.getChronoReglement().equals("1")) {
                  String var10 = "";
                  if (this.var_inputCaisse.contains(";")) {
                     String[] var11 = this.var_inputCaisse.split(";");
                     var10 = var11[0];
                  }

                  if (var10 != null && !var10.isEmpty()) {
                     var8 = this.calculChrono.numComposeCaisse(this.var_date_trf, 61, var9, var7, var10, var3);
                  } else {
                     var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var9, var7, var3);
                  }
               } else if (var1.getChronoReglement() != null && !var1.getChronoReglement().isEmpty() && var1.getChronoReglement().equals("2")) {
                  var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var7, var3);
               } else {
                  var8 = this.calculChrono.numCompose(this.var_date_trf, 61, var7, var3);
               }

               if (var8 != null && !var8.isEmpty()) {
                  double var31 = this.montantElmTotBonEnc;
                  double var12 = 0.0D;
                  double var14 = 0.0D;
                  double var16 = 0.0D;
                  double var18 = 0.0D;
                  new ElevesFacture();

                  for(int var21 = 0; var21 < this.listFactureSelectionne.size(); ++var21) {
                     ElevesFacture var20 = (ElevesFacture)this.listFactureSelectionne.get(var21);
                     var16 = var20.getVar_fac_timbre();
                     var18 = var20.getMontantReglementManuel();
                     var12 = 0.0D;
                     long var22 = var20.getElefacId();
                     var20 = this.elevesFactureDao.pourParapheur(var22, var3);
                     if (var20 != null) {
                        if (this.repartitionManuelle) {
                           if (var18 != 0.0D) {
                              this.generationReglement(var8, var18, var16, var20, var5, var3);
                              var31 = Math.abs(var31) - Math.abs(var18);
                              if (var31 < 0.0D) {
                                 var31 = 0.0D;
                                 break;
                              }
                           }
                        } else {
                           var12 = var20.getElefacTotal() + var20.getElefacTotalTaxe() + var20.getElefacTotalTc() + var16 - var20.getElefacReglement();
                           if (var31 == 0.0D) {
                              break;
                           }

                           if (Math.abs(var12) <= Math.abs(var31)) {
                              var14 = var12;
                           } else {
                              var14 = var31;
                           }

                           this.generationReglement(var8, var14, var16, var20, var5, var3);
                           var31 = Math.abs(var31) - Math.abs(var14);
                           if (var31 < 0.0D) {
                              var31 = 0.0D;
                              break;
                           }
                        }
                     }
                  }

                  boolean var32 = false;
                  if (var31 != 0.0D) {
                     this.reglements = new Reglements();
                     this.reglements.setRglDateReg(this.memoReglements.getRglDateReg());
                     this.reglements.setRglOperation("13");
                     this.reglements.setRglActivite(this.memoReglements.getRglActivite());
                     this.reglements.setRglBanqueTireur(this.memoReglements.getRglBanqueTireur());
                     this.reglements.setRglBudget(this.memoReglements.getRglBudget());
                     this.reglements.setRglBon(this.memoReglements.getRglBon());
                     this.reglements.setRglCategorie(this.memoReglements.getRglCategorie());
                     this.reglements.setRglCodeCaiss(this.memoReglements.getRglCodeCaiss());
                     this.reglements.setRglLibCaiss(this.memoReglements.getRglLibCaiss());
                     this.reglements.setRglCodeEmetrice(this.memoReglements.getRglCodeEmetrice());
                     this.reglements.setRglCodeReceptrice(this.memoReglements.getRglCodeReceptrice());
                     this.reglements.setRglDateCreation(this.memoReglements.getRglDateCreation());
                     this.reglements.setRglDateImp(this.memoReglements.getRglDateImp());
                     this.reglements.setRglDateTransfert(this.memoReglements.getRglDateTransfert());
                     this.reglements.setRglDateValeur(this.memoReglements.getRglDateValeur());
                     this.reglements.setRglDepartement(this.memoReglements.getRglDepartement());
                     this.reglements.setRglDepense(0.0D);
                     this.reglements.setRglDevise(this.memoReglements.getRglDevise());
                     this.reglements.setRglDossier(this.memoReglements.getRglDossier());
                     this.reglements.setRglFormatDevise(this.memoReglements.getRglFormatDevise());
                     this.reglements.setRglDocument("");
                     this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                     this.reglements.setRglIdBon(this.memoReglements.getRglIdBon());
                     this.reglements.setRglIdDocument(0L);
                     this.reglements.setRglIdTiers(this.memoReglements.getRglIdTiers());
                     this.reglements.setRglDepotTiers(1);
                     this.reglements.setRglLibEmetrice(this.memoReglements.getRglLibEmetrice());
                     this.reglements.setRglLibReceptrice(this.memoReglements.getRglLibReceptrice());
                     this.reglements.setRglLibelle("(déposit) " + this.memoReglements.getRglLibelle());
                     this.reglements.setRglMode(this.memoReglements.getRglMode());
                     this.reglements.setRglModele(this.memoReglements.getRglModele());
                     this.reglements.setRglNumChqBdx(this.memoReglements.getRglNumChqBdx());
                     this.reglements.setRglNatureDoc(this.memoReglements.getRglNatureDoc());
                     this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                     this.reglements.setRglNomTiers(this.memoReglements.getRglNomTiers());
                     this.reglements.setRglNum(this.memoReglements.getRglNum());
                     this.reglements.setRglObjet("(déposit) " + this.memoReglements.getRglObjet());
                     this.reglements.setRglParc(this.memoReglements.getRglParc());
                     this.reglements.setRglPdv(this.memoReglements.getRglPdv());
                     this.reglements.setRglRecette(var31);
                     this.reglements.setRglTimbre(0.0D);
                     this.reglements.setRglRegion(this.memoReglements.getRglRegion());
                     this.reglements.setRglSecteur(this.memoReglements.getRglSecteur());
                     this.reglements.setRglSerie(this.memoReglements.getRglSerie());
                     this.reglements.setRglService(this.memoReglements.getRglService());
                     this.reglements.setRglSite(this.memoReglements.getRglSite());
                     this.reglements.setRglTrf(this.memoReglements.getRglTrf());
                     this.reglements.setRglTypeReg(this.memoReglements.getRglTypeReg());
                     this.reglements.setRglTypeTiers(this.memoReglements.getRglTypeTiers());
                     this.reglements.setRglUserCreat(this.memoReglements.getRglUserCreat());
                     this.reglements.setRglGrp(this.memoReglements.getRglGrp());
                     this.reglements.setRglUserModif(this.memoReglements.getRglUserModif());
                     this.reglements.setRglIdResponsable(this.memoReglements.getRglIdResponsable());
                     this.reglements.setRglNomResponsable(this.memoReglements.getRglNomResponsable());
                     this.reglements.setRglIdCommercial(this.memoReglements.getRglIdCommercial());
                     this.reglements.setRglNomCommercial(this.memoReglements.getRglNomCommercial());
                     this.reglements.setRglIdEquipe(this.memoReglements.getRglIdEquipe());
                     this.reglements.setRglNomEquipe(this.memoReglements.getRglNomEquipe());
                     this.reglements.setRglPeriode(this.memoReglements.getRglPeriode());
                     this.reglements.setRglCle1(this.memoReglements.getRglCle1());
                     this.reglements.setRglCle2(this.memoReglements.getRglCle2());
                     this.reglements.setExercicesCaisse(this.memoReglements.getExercicesCaisse());
                     this.reglementsDao.insert(this.reglements, var3);
                     var32 = true;
                  }

                  if (this.varTypeReg == 90) {
                     var32 = true;
                  }

                  if (var32) {
                     new ArrayList();
                     List var33 = this.reglementsDao.rechercheHistoDepot(this.eleves.getEleId(), var3);
                     double var23 = 0.0D;
                     if (var33.size() != 0) {
                        for(int var25 = 0; var25 < var33.size(); ++var25) {
                           if (((Reglements)var33.get(var25)).getRglTypeReg() == 90) {
                              if (((Reglements)var33.get(var25)).getRglCategorie() == 10) {
                                 var23 = var23 - ((Reglements)var33.get(var25)).getRglRecette() + ((Reglements)var33.get(var25)).getRglDepense();
                              } else {
                                 var23 = var23 - ((Reglements)var33.get(var25)).getRglRecette() - ((Reglements)var33.get(var25)).getRglDepense();
                              }
                           } else {
                              var23 = var23 + ((Reglements)var33.get(var25)).getRglRecette() - ((Reglements)var33.get(var25)).getRglDepense();
                           }
                        }
                     }

                     this.eleves = this.elevesDao.selectElevesD(this.eleves.getEleId(), var3);
                     if (this.eleves != null) {
                        this.eleves.setEleDepotAvance(var23);
                        this.eleves = this.elevesDao.modif(this.eleves, var3);
                     }
                  }
               } else {
                  this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
                  this.formRecherche.setShowModalPanelMessage(true);
               }

               var4.commit();
            }
         } catch (HibernateException var29) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var29;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.chargerFactures((Session)null);
      this.showModalPanelReglement = false;
      this.ouvrirImpressionRecu();
   }

   public void controleEcartRepartitionManuelle() {
      if (this.montantElmTotBonEnc != 0.0D) {
         this.var_affiche_valide = false;
         if (this.listFactureSelectionne.size() != 0) {
            this.totManuel = 0.0D;

            for(int var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
               this.totManuel += ((ElevesFacture)this.listFactureSelectionne.get(var1)).getMontantReglementManuel();
            }

            this.ecartManuel = Math.abs(this.montantElmTotBonEnc) - Math.abs(this.totManuel);
            if (this.ecartManuel >= 0.0D) {
               this.var_affiche_valide = true;
            } else {
               this.var_affiche_valide = false;
            }
         }

         if (this.varTypeReg == 90 && this.montantElmTotBonEnc > this.eleves.getEleDepotAvance()) {
            this.montantElmTotBonEnc = this.eleves.getEleDepotAvance();
         }
      }

   }

   public void generationReglement(String var1, double var2, double var4, ElevesFacture var6, ExercicesCaisse var7, Session var8) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (Math.abs(var2) >= Math.abs(var6.getElefacTotal() + var6.getElefacTotalTaxe() + var6.getElefacTotalTc() + var4)) {
         this.reglements.setRglOperation("01");
      } else {
         this.reglements.setRglOperation("02");
      }

      this.reglements.setRglActivite("");
      this.reglements.setRglBudget("");
      this.reglements.setRglBanqueTireur(this.var_banque_tireur);
      this.reglements.setRglBon("");
      this.reglements.setRglCategorie(40);
      String[] var9;
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         var9 = this.var_inputCaisse.split(":");
         this.reglements.setRglCodeCaiss(var9[0]);
         this.reglements.setRglLibCaiss(var9[1]);
      } else {
         this.reglements.setRglCodeCaiss((String)null);
         this.reglements.setRglLibCaiss((String)null);
      }

      this.reglements.setRglCodeEmetrice((String)null);
      this.reglements.setRglLibEmetrice((String)null);
      if (this.varTypeReg != 0 && this.varTypeReg != 11 && this.var_affiche_banque_destination && this.var_banque_destination != null && !this.var_banque_destination.isEmpty() && this.var_banque_destination.contains(":")) {
         var9 = this.var_banque_destination.split(":");
         this.reglements.setRglCodeEmetrice(var9[0]);
         this.reglements.setRglLibEmetrice(var9[1]);
      }

      this.reglements.setRglCodeReceptrice((String)null);
      this.reglements.setRglLibReceptrice((String)null);
      this.reglements.setRglDateCreation(new Date());
      this.reglements.setRglDateImp((Date)null);
      this.reglements.setRglDateTransfert((Date)null);
      this.reglements.setRglDateValeur((Date)null);
      this.reglements.setRglDateReg(this.var_date_trf);
      this.reglements.setRglDepartement(var6.getElefacDepartement());
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDevise(this.structureLog.getStrdevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(var6.getElefacNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(var6.getElefacId());
      this.reglements.setRglIdTiers(var6.getEleves().getEleId());
      if (this.varTypeReg == 90) {
         this.reglements.setRglDepotTiers(3);
      } else {
         this.reglements.setRglDepotTiers(0);
      }

      this.reglements.setRglLibelle("Règlement facture");
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(102);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(var6.getEleves().getPatronyme());
      this.reglements.setRglIdContact(0L);
      this.reglements.setRglNomContact("");
      this.reglements.setRglNum(var1);
      this.reglements.setRglNumChqBdx(this.var_num_cheque);
      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv(var6.getElefacPdv());
      this.reglements.setRglRecette(var2);
      double var14 = 0.0D;
      if (var4 != 0.0D) {
         int var11 = var6.getElefacDate().getYear() + 1900;
         var14 = this.utilNombre.calculTimbre(this.structureLog, var2, var11, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var14);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion(var6.getElefacRegion());
      this.reglements.setRglSecteur(var6.getElefacSecteur());
      this.reglements.setRglSerie(var6.getElefacSerie());
      this.reglements.setRglService(var6.getElefacService());
      this.reglements.setRglSite(var6.getElefacSite());
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(5);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(var6.getElefacIdResponsable());
      this.reglements.setRglNomResponsable(var6.getElefacNomResponsable());
      this.reglements.setRglIdCommercial(var6.getElefacIdCommercial());
      this.reglements.setRglNomCommercial(var6.getElefacNomCommercial());
      this.reglements.setRglIdEquipe(0L);
      this.reglements.setRglNomEquipe("");
      String var15 = "";
      if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
         var15 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
      } else {
         var15 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
      }

      String var12 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
      this.reglements.setRglPeriode(var15 + ":" + var12);
      this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
      String var13 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
      this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var13);
      this.reglements.setExercicesCaisse(var7);
      this.reglements = this.reglementsDao.insert(this.reglements, var8);
      this.memoReglements = this.reglements;
      if (var6 != null) {
         var6.setElefacReglement(var6.getElefacReglement() + var2);
         var6.setElefacTotalTimbre(var6.getElefacTotalTimbre() + var14);
         if (Math.abs(var6.getElefacReglement()) >= Math.abs(var6.getElefacTotal() + var6.getElefacTotalTaxe() + var6.getElefacTotalTc())) {
            var6.setElefacSolde(1);
         } else {
            var6.setElefacSolde(0);
         }

         var6.setElefacDateLastReg(this.reglements.getRglDateReg());
         this.elevesFactureDao.modif(var6, var8);
      }

   }

   public int calculformatDevise(String var1) {
      byte var2 = 0;
      if (!var1.equals("XAF") && !var1.equals("XOF")) {
         if (var1.equals("EUR") || var1.equals("CHF")) {
            var2 = 1;
         }
      } else {
         var2 = 2;
      }

      return var2;
   }

   public void chargerModeleDocument() {
      this.mesModesleRecus.clear();
      if (this.nomRepMod != null && !this.nomRepMod.isEmpty()) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + this.nomRepMod;
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
                  this.mesModesleRecus.add(new SelectItem(var5));
               }
            }
         }
      }

   }

   public void supprimerReglement() throws HibernateException, NamingException {
      if (this.datamodelReglement.isRowAvailable()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelReglement.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.elevesFacture.getElefacId(), 102, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglRecette();
               }
            }

            this.elevesFacture.setElefacReglement(var4);
            if (Math.abs(this.elevesFacture.getElefacReglement()) >= Math.abs(this.elevesFacture.getElefacTotal() + this.elevesFacture.getElefacTotalTaxe() + this.elevesFacture.getElefacTotalTc())) {
               this.elevesFacture.setElefacSolde(1);
            } else {
               this.elevesFacture.setElefacSolde(0);
            }

            this.elevesFacture = this.elevesFactureDao.modif(this.elevesFacture, var1);
            this.datamodelReglement.setWrappedData(var3);
            var2.commit();
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void chargerModReg() {
      if (this.elevesFacture.getElefacTypeReg() != 4 && this.elevesFacture.getElefacTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void calculeTypeReglementCaisse() throws HibernateException, NamingException {
      this.var_affiche_banque_destination = true;
      this.mesTypeReglementsCaisse.clear();
      if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
         String[] var1 = this.var_inputCaisse.split(":");
         this.caissesCommerciales = this.caissesCommercialesDao.selectCaisse(0L, var1[0], (Session)null);
         if (this.caissesCommerciales != null) {
            if (this.caissesCommerciales.getCaiJrEspece() != null && !this.caissesCommerciales.getCaiJrEspece().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("0:Espèces"));
            }

            if (this.caissesCommerciales.getCaiJrCheque() != null && !this.caissesCommerciales.getCaiJrCheque().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("1:Chèque"));
            }

            if (this.caissesCommerciales.getCaiJrVirement() != null && !this.caissesCommerciales.getCaiJrVirement().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("2:Virement"));
            }

            if (this.caissesCommerciales.getCaiJrTraite() != null && !this.caissesCommerciales.getCaiJrTraite().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("3:Traites"));
            }

            if (this.caissesCommerciales.getCaiJrTpe() != null && !this.caissesCommerciales.getCaiJrTpe().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("4:Carte bancaire"));
            }

            if (this.caissesCommerciales.getCaiJrTransfert() != null && !this.caissesCommerciales.getCaiJrTransfert().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("5:Transfert d`argent"));
            }

            if (this.caissesCommerciales.getCaiJrePaiement() != null && !this.caissesCommerciales.getCaiJrePaiement().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("6:e-paiement"));
            }

            if (this.caissesCommerciales.getCaiJrCredoc() != null && !this.caissesCommerciales.getCaiJrCredoc().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("7:Credoc"));
            }

            if (this.caissesCommerciales.getCaiJrFactor() != null && !this.caissesCommerciales.getCaiJrFactor().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("8:Factor"));
            }

            if (this.caissesCommerciales.getCaiJrCompense() != null && !this.caissesCommerciales.getCaiJrCompense().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("9:Compense"));
            }

            if (this.caissesCommerciales.getCaiJrTerme() != null && !this.caissesCommerciales.getCaiJrTerme().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("10:Terme"));
            }

            if (this.caissesCommerciales.getCaiJrEspeceST() != null && !this.caissesCommerciales.getCaiJrEspeceST().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("11:Espèces sans timbre"));
            }

            if (this.caissesCommerciales.getCaiJrLettreGarantie() != null && !this.caissesCommerciales.getCaiJrLettreGarantie().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("12:Lettre de garantie"));
            }

            if (this.caissesCommerciales.getCaiJrPrelevement() != null && !this.caissesCommerciales.getCaiJrPrelevement().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("13:Prélèvement"));
            }

            if (this.caissesCommerciales.getCaiJrAlcoin() != null && !this.caissesCommerciales.getCaiJrAlcoin().isEmpty()) {
               this.mesTypeReglementsCaisse.add(new SelectItem("14:ALCoin"));
            }

            if (this.eleves.getEleDepotAvance() != 0.0D) {
               this.mesTypeReglementsCaisse.add(new SelectItem("90:Déposit-Avance/Ristournes"));
            }

            if (this.mesTypeReglementsCaisse.size() != 0) {
               this.var_type_reg = ((SelectItem)this.mesTypeReglementsCaisse.get(0)).getValue().toString();
            } else {
               this.var_type_reg = "";
            }

            if (this.caissesCommerciales.getCaiMvtCheBnq() == 1) {
               this.calculeListeBanqueDestination();
               this.var_affiche_banque = true;
               this.var_affiche_banque_destination = true;
            }
         }
      }

   }

   public void calculeListeBanqueDestination() throws NamingException {
      if (this.mesBanquesItems == null || this.mesBanquesItems.size() == 0) {
         this.mesBanquesItems.clear();
         new ExercicesComptable();
         ExercicesComptableDao var2 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
         ExercicesComptable var1 = var2.recupererLastExo((Session)null);
         if (var1 != null) {
            JournauxComptablesDao var3 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
            this.mesBanquesItems = var3.chargerLesJournaux(var1, 1, this.usersLog.getUsrJrxReserve(), (Session)null);
         }
      }

   }

   public void calculeNomRep() {
      if (this.varTypeReg != 0 && this.varTypeReg != 11 && this.varTypeReg != 90) {
         if (this.varTypeReg != 1 && this.varTypeReg != 10) {
            if (this.varTypeReg == 2) {
               this.nomRepMod = "virements";
            } else if (this.varTypeReg == 3) {
               this.nomRepMod = "traites";
            } else if (this.varTypeReg == 4) {
               this.nomRepMod = "cartes";
            } else if (this.varTypeReg == 5) {
               this.nomRepMod = "transferts";
            } else if (this.varTypeReg == 6) {
               this.nomRepMod = "epaiements";
            } else if (this.varTypeReg == 7) {
               this.nomRepMod = "credocs";
            } else if (this.varTypeReg == 8) {
               this.nomRepMod = "factors";
            } else if (this.varTypeReg == 9) {
               this.nomRepMod = "compenses";
            } else if (this.varTypeReg == 12) {
               this.nomRepMod = "lettres_garantie";
            } else if (this.varTypeReg == 13) {
               this.nomRepMod = "prelevements";
            } else if (this.varTypeReg == 14) {
               this.nomRepMod = "alcoins";
            } else {
               this.nomRepMod = "";
            }
         } else {
            this.nomRepMod = "cheques";
         }
      } else {
         this.nomRepMod = "especes";
      }

      this.chargerModeleDocument();
   }

   public void histoReglement() {
      if (this.elevesFacture != null) {
         this.showModalPanelHistoReglement = true;
      }

   }

   public void fermerHistoReglement() {
      this.showModalPanelHistoReglement = false;
   }

   public void ouvrirImpressionRecu() {
      this.showModalPanelPrintRecu = true;
   }

   public void fermerImpressionRecu() {
      this.showModalPanelPrintRecu = false;
   }

   public void imprimerRecuPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("PRT");
   }

   public void imprimerRecuJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("JRV");
   }

   public void imprimerRecuPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("PDF");
   }

   public void imprimerRecuODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("ODT");
   }

   public void imprimerRecuXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("XLS");
   }

   public void imprimerRecuDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("DOC");
   }

   public void imprimerRecuHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("HTML");
   }

   public void imprimerRecuXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionRecu("XML");
   }

   public void impressionRecu(String var1) throws IOException, HibernateException, NamingException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.reglements != null && this.reglements.getRglModele() != null && !this.reglements.getRglModele().isEmpty()) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         double var2 = 0.0D;
         String var4 = "";
         String var5 = "";
         new ArrayList();
         List var6 = this.reglementsDao.chargeRecuByNum(this.reglements.getRglNum(), this.reglements.getRglCodeCaiss(), this.reglements.getRglNatureDoc(), this.reglements.getRglDateReg(), (Session)null);
         if (var6.size() != 0) {
            for(int var7 = 0; var7 < var6.size(); ++var7) {
               if (var4 == null && var4.isEmpty()) {
                  var4 = ((Reglements)var6.get(var7)).getRglDocument();
                  var5 = "" + this.utilNombre.beginText(((Reglements)var6.get(var7)).getRglRecette() + ((Reglements)var6.get(var7)).getRglTimbre(), this.structureLog.getStrformatdevise());
               } else {
                  var4 = var4 + "\n" + ((Reglements)var6.get(var7)).getRglDocument();
                  var5 = var5 + "\n" + this.utilNombre.beginText(((Reglements)var6.get(var7)).getRglRecette() + ((Reglements)var6.get(var7)).getRglTimbre(), this.structureLog.getStrformatdevise());
               }

               var2 = var2 + ((Reglements)var6.get(var7)).getRglRecette() + ((Reglements)var6.get(var7)).getRglTimbre();
            }

            if (var6.size() == 1) {
               var4 = null;
               var5 = null;
            }

            String var11 = this.utilNombre.begin(var2, this.reglements.getRglDevise());
            var6.clear();
            var6.add(this.reglements);
            JRBeanCollectionDataSource var8 = new JRBeanCollectionDataSource(var6);
            this.utilPrint.setjRBeanCollectionDataSource(var8);
            this.utilPrint.setRapport(this.reglements.getRglModele());
            this.utilPrint.setEntete("Impression reçu");
            this.varTypeReg = this.reglements.getRglTypeReg();
            this.calculeNomRep();
            String var9 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + this.nomRepMod + File.separator;
            this.utilPrint.setCheminRapport(var9);
            String var10 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport";
            this.utilPrint.setCheminSousrapport(var10);
            this.utilPrint.setImageFondPage((String)null);
            this.utilPrint.setTaux(1.0F);
            this.utilPrint.setAnnexe1(var4);
            this.utilPrint.setAnnexe2(var5);
            this.utilPrint.setPlafond(var2);
            this.utilPrint.setMontant_lettre(var11);
            this.utilPrint.setFormat(var1);
            this.utilPrint.setIdResponsable(this.reglements.getRglIdResponsable());
            this.utilPrint.setIdCommercial(this.reglements.getRglIdCommercial());
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setContact((Contacts)null);
            this.utilPrint.setNumDoc(this.reglements.getRglNum());
            this.utilPrint.setNature(this.nature);
            this.utilPrint.setId_doc(this.reglements.getRglId());
            this.utilPrint.setParc((Parc)null);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.var_choix_modele = 0;
      this.visibleOptionMail = false;
      this.affMail = false;
      this.listeDocImp();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void listeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else {
         this.affListeDoc = true;
      }

   }

   public void OptionMail() {
      if (this.format.equalsIgnoreCase("MAIL")) {
         this.visibleOptionMail = true;
      } else {
         this.visibleOptionMail = false;
      }

   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
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

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            this.requete = " med_eleves.`ele_id`='" + this.eleves.getEleId() + "'";
            this.utilPrint.setSource("");
            this.utilPrint.setRecordPath("");
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setRequete(this.requete);
            this.utilPrint.setFiltre("");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Impression eleve");
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            ArrayList var1 = new ArrayList();
            JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setSource("");
         this.utilPrint.setRecordPath("");
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des eleves");
         this.utilPrint.setRequete("");
         this.utilPrint.setFiltre("");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.lesEleves);
         this.utilPrint.setjRBeanCollectionDataSource(var3);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public ObjetLigneMenu getLigneMenu() {
      return this.ligneMenu;
   }

   public void setLigneMenu(ObjetLigneMenu var1) {
      this.ligneMenu = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
   }

   public Eleves getEleves() {
      return this.eleves;
   }

   public void setEleves(Eleves var1) {
      this.eleves = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public boolean isAfficheButtOption() {
      return this.afficheButtOption;
   }

   public void setAfficheButtOption(boolean var1) {
      this.afficheButtOption = var1;
   }

   public String getCategorie() {
      return this.categorie;
   }

   public void setCategorie(String var1) {
      this.categorie = var1;
   }

   public DataModel getDataModelEleves() {
      return this.dataModelEleves;
   }

   public void setDataModelEleves(DataModel var1) {
      this.dataModelEleves = var1;
   }

   public String getLibelleSousMenu() {
      return this.libelleSousMenu;
   }

   public void setLibelleSousMenu(String var1) {
      this.libelleSousMenu = var1;
   }

   public List getMesdevisesItem() {
      return this.mesdevisesItem;
   }

   public void setMesdevisesItem(List var1) {
      this.mesdevisesItem = var1;
   }

   public String getNom() {
      return this.nom;
   }

   public void setNom(String var1) {
      this.nom = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public String getCarteIdentite() {
      return this.carteIdentite;
   }

   public void setCarteIdentite(String var1) {
      this.carteIdentite = var1;
   }

   public String getDossier() {
      return this.dossier;
   }

   public void setDossier(String var1) {
      this.dossier = var1;
   }

   public String getPrenom() {
      return this.prenom;
   }

   public void setPrenom(String var1) {
      this.prenom = var1;
   }

   public String getTelephone() {
      return this.telephone;
   }

   public void setTelephone(String var1) {
      this.telephone = var1;
   }

   public int getTiersPayant() {
      return this.tiersPayant;
   }

   public void setTiersPayant(int var1) {
      this.tiersPayant = var1;
   }

   public GmapTag getGmapTag() {
      return this.gmapTag;
   }

   public void setGmapTag(GmapTag var1) {
      this.gmapTag = var1;
   }

   public boolean isModalGoogleMap() {
      return this.modalGoogleMap;
   }

   public void setModalGoogleMap(boolean var1) {
      this.modalGoogleMap = var1;
   }

   public String getPlace() {
      return this.place;
   }

   public void setPlace(String var1) {
      this.place = var1;
   }

   public CalculChrono getCalculChrono() {
      return this.calculChrono;
   }

   public void setCalculChrono(CalculChrono var1) {
      this.calculChrono = var1;
   }

   public Chrono getChrono() {
      return this.chrono;
   }

   public void setChrono(Chrono var1) {
      this.chrono = var1;
   }

   public List getMesFamilleClientsItems() {
      return this.mesFamilleClientsItems;
   }

   public void setMesFamilleClientsItems(List var1) {
      this.mesFamilleClientsItems = var1;
   }

   public List getLesFamilleClientsListe() {
      return this.lesFamilleClientsListe;
   }

   public void setLesFamilleClientsListe(List var1) {
      this.lesFamilleClientsListe = var1;
   }

   public List getLesReglementsClient() {
      return this.lesReglementsClient;
   }

   public void setLesReglementsClient(List var1) {
      this.lesReglementsClient = var1;
   }

   public List getMesReglementClientItems() {
      return this.mesReglementClientItems;
   }

   public void setMesReglementClientItems(List var1) {
      this.mesReglementClientItems = var1;
   }

   public boolean isTestModeCalcul() {
      return this.testModeCalcul;
   }

   public void setTestModeCalcul(boolean var1) {
      this.testModeCalcul = var1;
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

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
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

   public boolean isShowModalGoogleMap() {
      return this.showModalGoogleMap;
   }

   public void setShowModalGoogleMap(boolean var1) {
      this.showModalGoogleMap = var1;
   }

   public URI getUri() {
      return this.uri;
   }

   public void setUri(URI var1) {
      this.uri = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
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

   public List getMesCivilitesItems() {
      return this.mesCivilitesItems;
   }

   public void setMesCivilitesItems(List var1) {
      this.mesCivilitesItems = var1;
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

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public String getUrlphoto() {
      return this.urlphoto;
   }

   public void setUrlphoto(String var1) {
      this.urlphoto = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getMessageSms() {
      return this.messageSms;
   }

   public void setMessageSms(String var1) {
      this.messageSms = var1;
   }

   public String getNumeroMobile() {
      return this.numeroMobile;
   }

   public void setNumeroMobile(String var1) {
      this.numeroMobile = var1;
   }

   public boolean isShowModalPanelSms() {
      return this.showModalPanelSms;
   }

   public void setShowModalPanelSms(boolean var1) {
      this.showModalPanelSms = var1;
   }

   public DataModel getDataModelDocumnts() {
      return this.dataModelDocumnts;
   }

   public void setDataModelDocumnts(DataModel var1) {
      this.dataModelDocumnts = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public String getNomDocument() {
      return this.nomDocument;
   }

   public void setNomDocument(String var1) {
      this.nomDocument = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public String getPdfFileName() {
      return this.pdfFileName;
   }

   public void setPdfFileName(String var1) {
      this.pdfFileName = var1;
   }

   public boolean isShowModalPanelAjoutFile() {
      return this.showModalPanelAjoutFile;
   }

   public void setShowModalPanelAjoutFile(boolean var1) {
      this.showModalPanelAjoutFile = var1;
   }

   public boolean isShowModalPanelPj() {
      return this.showModalPanelPj;
   }

   public void setShowModalPanelPj(boolean var1) {
      this.showModalPanelPj = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public List getMesFiliairesItems() {
      return this.mesFiliairesItems;
   }

   public void setMesFiliairesItems(List var1) {
      this.mesFiliairesItems = var1;
   }

   public boolean isAfficheButtContact() {
      return this.afficheButtContact;
   }

   public void setAfficheButtContact(boolean var1) {
      this.afficheButtContact = var1;
   }

   public DataModel getDatamodelContact() {
      return this.datamodelContact;
   }

   public void setDatamodelContact(DataModel var1) {
      this.datamodelContact = var1;
   }

   public ElevesContact getElevesContact() {
      return this.elevesContact;
   }

   public void setElevesContact(ElevesContact var1) {
      this.elevesContact = var1;
   }

   public boolean isShowModalPanelCnt() {
      return this.showModalPanelCnt;
   }

   public void setShowModalPanelCnt(boolean var1) {
      this.showModalPanelCnt = var1;
   }

   public int getVar_actionContact() {
      return this.var_actionContact;
   }

   public void setVar_actionContact(int var1) {
      this.var_actionContact = var1;
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

   public boolean isAfficheButtInscription() {
      return this.afficheButtInscription;
   }

   public void setAfficheButtInscription(boolean var1) {
      this.afficheButtInscription = var1;
   }

   public DataModel getDatamodelInscription() {
      return this.datamodelInscription;
   }

   public void setDatamodelInscription(DataModel var1) {
      this.datamodelInscription = var1;
   }

   public ElevesInscription getElevesInscription() {
      return this.elevesInscription;
   }

   public void setElevesInscription(ElevesInscription var1) {
      this.elevesInscription = var1;
   }

   public boolean isShowModalPanelInscription() {
      return this.showModalPanelInscription;
   }

   public void setShowModalPanelInscription(boolean var1) {
      this.showModalPanelInscription = var1;
   }

   public int getVar_actionInscription() {
      return this.var_actionInscription;
   }

   public void setVar_actionInscription(int var1) {
      this.var_actionInscription = var1;
   }

   public long getVar_filiere() {
      return this.var_filiere;
   }

   public void setVar_filiere(long var1) {
      this.var_filiere = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public boolean isAutorisationInscription() {
      return this.autorisationInscription;
   }

   public void setAutorisationInscription(boolean var1) {
      this.autorisationInscription = var1;
   }

   public DataModel getDatamodelFacturation() {
      return this.datamodelFacturation;
   }

   public void setDatamodelFacturation(DataModel var1) {
      this.datamodelFacturation = var1;
   }

   public boolean isAfficheButtFacture() {
      return this.afficheButtFacture;
   }

   public void setAfficheButtFacture(boolean var1) {
      this.afficheButtFacture = var1;
   }

   public boolean isShowModalPanelFacture() {
      return this.showModalPanelFacture;
   }

   public void setShowModalPanelFacture(boolean var1) {
      this.showModalPanelFacture = var1;
   }

   public ElevesFacture getElevesFacture() {
      return this.elevesFacture;
   }

   public void setElevesFacture(ElevesFacture var1) {
      this.elevesFacture = var1;
   }

   public int getVar_actionFacture() {
      return this.var_actionFacture;
   }

   public void setVar_actionFacture(int var1) {
      this.var_actionFacture = var1;
   }

   public boolean isShowModalPanelPrintSituation() {
      return this.showModalPanelPrintSituation;
   }

   public void setShowModalPanelPrintSituation(boolean var1) {
      this.showModalPanelPrintSituation = var1;
   }

   public List getDocumentImpressionItems() {
      return this.documentImpressionItems;
   }

   public void setDocumentImpressionItems(List var1) {
      this.documentImpressionItems = var1;
   }

   public List getListeImpressionItems() {
      return this.listeImpressionItems;
   }

   public void setListeImpressionItems(List var1) {
      this.listeImpressionItems = var1;
   }

   public long getFiliere() {
      return this.filiere;
   }

   public void setFiliere(long var1) {
      this.filiere = var1;
   }

   public String getDepartement() {
      return this.departement;
   }

   public void setDepartement(String var1) {
      this.departement = var1;
   }

   public String getPdv() {
      return this.pdv;
   }

   public void setPdv(String var1) {
      this.pdv = var1;
   }

   public String getRegion() {
      return this.region;
   }

   public void setRegion(String var1) {
      this.region = var1;
   }

   public String getSecteur() {
      return this.secteur;
   }

   public void setSecteur(String var1) {
      this.secteur = var1;
   }

   public String getService() {
      return this.service;
   }

   public void setService(String var1) {
      this.service = var1;
   }

   public String getSite() {
      return this.site;
   }

   public void setSite(String var1) {
      this.site = var1;
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

   public String getCaisse() {
      return this.caisse;
   }

   public void setCaisse(String var1) {
      this.caisse = var1;
   }

   public long getCommercial() {
      return this.commercial;
   }

   public void setCommercial(long var1) {
      this.commercial = var1;
   }

   public long getResponsable() {
      return this.responsable;
   }

   public void setResponsable(long var1) {
      this.responsable = var1;
   }

   public int getChoixRacine() {
      return this.choixRacine;
   }

   public void setChoixRacine(int var1) {
      this.choixRacine = var1;
   }

   public String getSelecFiscalite() {
      return this.selecFiscalite;
   }

   public void setSelecFiscalite(String var1) {
      this.selecFiscalite = var1;
   }

   public int getChoixCompte() {
      return this.choixCompte;
   }

   public void setChoixCompte(int var1) {
      this.choixCompte = var1;
   }

   public String getCompte() {
      return this.compte;
   }

   public void setCompte(String var1) {
      this.compte = var1;
   }

   public int getCompteModif() {
      return this.compteModif;
   }

   public void setCompteModif(int var1) {
      this.compteModif = var1;
   }

   public String getMaNature() {
      return this.maNature;
   }

   public void setMaNature(String var1) {
      this.maNature = var1;
   }

   public String getMaRacine() {
      return this.maRacine;
   }

   public void setMaRacine(String var1) {
      this.maRacine = var1;
   }

   public boolean isShowModalPanelImmatriculation() {
      return this.showModalPanelImmatriculation;
   }

   public void setShowModalPanelImmatriculation(boolean var1) {
      this.showModalPanelImmatriculation = var1;
   }

   public boolean isExisteCopteDeja() {
      return this.existeCopteDeja;
   }

   public void setExisteCopteDeja(boolean var1) {
      this.existeCopteDeja = var1;
   }

   public boolean isValideEleves() {
      return this.valideEleves;
   }

   public void setValideEleves(boolean var1) {
      this.valideEleves = var1;
   }

   public boolean isAfficheRecu() {
      return this.afficheRecu;
   }

   public void setAfficheRecu(boolean var1) {
      this.afficheRecu = var1;
   }

   public double getEcartManuel() {
      return this.ecartManuel;
   }

   public void setEcartManuel(double var1) {
      this.ecartManuel = var1;
   }

   public List getLesFactures() {
      return this.lesFactures;
   }

   public void setLesFactures(List var1) {
      this.lesFactures = var1;
   }

   public List getListFactureSelectionne() {
      return this.listFactureSelectionne;
   }

   public void setListFactureSelectionne(List var1) {
      this.listFactureSelectionne = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public List getMesCaissesSeriesItems() {
      return this.mesCaissesSeriesItems;
   }

   public void setMesCaissesSeriesItems(List var1) {
      this.mesCaissesSeriesItems = var1;
   }

   public List getMesCompteItem() {
      return this.mesCompteItem;
   }

   public void setMesCompteItem(List var1) {
      this.mesCompteItem = var1;
   }

   public List getMesModesleRecus() {
      return this.mesModesleRecus;
   }

   public void setMesModesleRecus(List var1) {
      this.mesModesleRecus = var1;
   }

   public List getMesTypeReglementsCaisse() {
      return this.mesTypeReglementsCaisse;
   }

   public void setMesTypeReglementsCaisse(List var1) {
      this.mesTypeReglementsCaisse = var1;
   }

   public boolean isShowModalPanelPaye() {
      return this.showModalPanelPaye;
   }

   public void setShowModalPanelPaye(boolean var1) {
      this.showModalPanelPaye = var1;
   }

   public boolean isShowModalPanelPrintRecu() {
      return this.showModalPanelPrintRecu;
   }

   public void setShowModalPanelPrintRecu(boolean var1) {
      this.showModalPanelPrintRecu = var1;
   }

   public boolean isShowModalPanelReglement() {
      return this.showModalPanelReglement;
   }

   public void setShowModalPanelReglement(boolean var1) {
      this.showModalPanelReglement = var1;
   }

   public double getTotManuel() {
      return this.totManuel;
   }

   public void setTotManuel(double var1) {
      this.totManuel = var1;
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

   public boolean isVar_affichMontant() {
      return this.var_affichMontant;
   }

   public void setVar_affichMontant(boolean var1) {
      this.var_affichMontant = var1;
   }

   public boolean isVar_affiche_banque() {
      return this.var_affiche_banque;
   }

   public void setVar_affiche_banque(boolean var1) {
      this.var_affiche_banque = var1;
   }

   public boolean isVar_affiche_banque_destination() {
      return this.var_affiche_banque_destination;
   }

   public void setVar_affiche_banque_destination(boolean var1) {
      this.var_affiche_banque_destination = var1;
   }

   public boolean isVar_affiche_be() {
      return this.var_affiche_be;
   }

   public void setVar_affiche_be(boolean var1) {
      this.var_affiche_be = var1;
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

   public String getVar_banque_destination() {
      return this.var_banque_destination;
   }

   public void setVar_banque_destination(String var1) {
      this.var_banque_destination = var1;
   }

   public String getVar_banque_tireur() {
      return this.var_banque_tireur;
   }

   public void setVar_banque_tireur(String var1) {
      this.var_banque_tireur = var1;
   }

   public double getVar_ecart_reglement() {
      return this.var_ecart_reglement;
   }

   public void setVar_ecart_reglement(double var1) {
      this.var_ecart_reglement = var1;
   }

   public String getVar_inputCaisse() {
      return this.var_inputCaisse;
   }

   public void setVar_inputCaisse(String var1) {
      this.var_inputCaisse = var1;
   }

   public String getVar_montant() {
      return this.var_montant;
   }

   public void setVar_montant(String var1) {
      this.var_montant = var1;
   }

   public double getVar_netAPayer() {
      return this.var_netAPayer;
   }

   public void setVar_netAPayer(double var1) {
      this.var_netAPayer = var1;
   }

   public String getVar_nom_client() {
      return this.var_nom_client;
   }

   public void setVar_nom_client(String var1) {
      this.var_nom_client = var1;
   }

   public String getVar_num_cheque() {
      return this.var_num_cheque;
   }

   public void setVar_num_cheque(String var1) {
      this.var_num_cheque = var1;
   }

   public String getVar_num_facture() {
      return this.var_num_facture;
   }

   public void setVar_num_facture(String var1) {
      this.var_num_facture = var1;
   }

   public String getVar_objet() {
      return this.var_objet;
   }

   public void setVar_objet(String var1) {
      this.var_objet = var1;
   }

   public double getVar_tot_bon_encaissement() {
      return this.var_tot_bon_encaissement;
   }

   public void setVar_tot_bon_encaissement(double var1) {
      this.var_tot_bon_encaissement = var1;
   }

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
   }

   public boolean isVar_verouxModReg() {
      return this.var_verouxModReg;
   }

   public void setVar_verouxModReg(boolean var1) {
      this.var_verouxModReg = var1;
   }

   public Date getVar_date_trf() {
      return this.var_date_trf;
   }

   public void setVar_date_trf(Date var1) {
      this.var_date_trf = var1;
   }

   public DataModel getDatamodelTransfert() {
      return this.datamodelTransfert;
   }

   public void setDatamodelTransfert(DataModel var1) {
      this.datamodelTransfert = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public String getVar_modele_trf() {
      return this.var_modele_trf;
   }

   public void setVar_modele_trf(String var1) {
      this.var_modele_trf = var1;
   }

   public boolean isReglementAutorise() {
      return this.reglementAutorise;
   }

   public void setReglementAutorise(boolean var1) {
      this.reglementAutorise = var1;
   }

   public double getSode() {
      return this.sode;
   }

   public void setSode(double var1) {
      this.sode = var1;
   }

   public double getTotalFacture() {
      return this.totalFacture;
   }

   public void setTotalFacture(double var1) {
      this.totalFacture = var1;
   }

   public double getTotalReglement() {
      return this.totalReglement;
   }

   public void setTotalReglement(double var1) {
      this.totalReglement = var1;
   }

   public boolean isShowModalPanelHistoReglement() {
      return this.showModalPanelHistoReglement;
   }

   public void setShowModalPanelHistoReglement(boolean var1) {
      this.showModalPanelHistoReglement = var1;
   }

   public DataModel getDatamodelReglement() {
      return this.datamodelReglement;
   }

   public void setDatamodelReglement(DataModel var1) {
      this.datamodelReglement = var1;
   }

   public List getListCaisses() {
      return this.listCaisses;
   }

   public void setListCaisses(List var1) {
      this.listCaisses = var1;
   }

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
   }

   public double getMontantElmTotBonEnc() {
      return this.montantElmTotBonEnc;
   }

   public void setMontantElmTotBonEnc(double var1) {
      this.montantElmTotBonEnc = var1;
   }

   public boolean isRepartitionManuelle() {
      return this.repartitionManuelle;
   }

   public void setRepartitionManuelle(boolean var1) {
      this.repartitionManuelle = var1;
   }

   public double getTotalPayerTimbre() {
      return this.totalPayerTimbre;
   }

   public void setTotalPayerTimbre(double var1) {
      this.totalPayerTimbre = var1;
   }

   public List getListeRecuItems() {
      return this.listeRecuItems;
   }

   public void setListeRecuItems(List var1) {
      this.listeRecuItems = var1;
   }

   public long getNomModeleRecu() {
      return this.nomModeleRecu;
   }

   public void setNomModeleRecu(long var1) {
      this.nomModeleRecu = var1;
   }
}
