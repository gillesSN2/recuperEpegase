package com.epegase.forms.tiers;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.office.FormMessagerie;
import com.epegase.systeme.classe.AvoirLigneAchats;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienBail;
import com.epegase.systeme.classe.Cadeaux;
import com.epegase.systeme.classe.CampagneParticipantVentes;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.ContratEcheanceVentes;
import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.classe.ConventionMedical;
import com.epegase.systeme.classe.CotationLigneAchats;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FraisLigneAchats;
import com.epegase.systeme.classe.FraisTheoAchats;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.NoteDebitLigneAchats;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.PatientPec;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.TiersAdherent;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.ObjetProdExoTva;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.BienBailDao;
import com.epegase.systeme.dao.BienDao;
import com.epegase.systeme.dao.BienFactureDao;
import com.epegase.systeme.dao.BienGeranceEnteteDao;
import com.epegase.systeme.dao.CadeauxDao;
import com.epegase.systeme.dao.CampagneParticipantVentesDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.ContratEcheanceVentesDao;
import com.epegase.systeme.dao.ContratEnteteVentesDao;
import com.epegase.systeme.dao.ConventionMedicalDao;
import com.epegase.systeme.dao.CotationEnteteAchatsDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.FraisTheoAchatsDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LettreMedicalDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.PatientPecDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RacinesDao;
import com.epegase.systeme.dao.RdvDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.RetourEnteteAchatsDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.TicketEnteteVentesDao;
import com.epegase.systeme.dao.TiersAdherentDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilSms;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureBanque;
import com.epegase.systeme.xml.LectureElementRdv;
import com.epegase.systeme.xml.LectureImmatriculation;
import com.epegase.systeme.xml.LectureNatureRdv;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.LireLesoptionsGroupe;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetElementRdv;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetImmatriculation;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.ObjetPays;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionGroupe;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormTiers implements Serializable {
   private int typeVente;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private int var_memo_action;
   private String pageIndex;
   private ObjetLigneMenu ligneMenu;
   private TiersDao tiersDao;
   private Tiers newtiers = new Tiers();
   private boolean comptaExist = false;
   private boolean venteExist = false;
   private boolean abnExist = false;
   private boolean achatExist = false;
   private boolean interimExist = false;
   private boolean medicalExist = false;
   private boolean transitExist = false;
   private boolean fondationExist = false;
   private boolean mefExist = false;
   private boolean affiche_convention = false;
   private boolean affiche_adhesion = false;
   private String libelleSousMenu;
   private int typeTiers;
   private String genreTiers;
   private int var_nb_max = 100;
   private boolean var_tiersDivers;
   private String nomCreateur;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private String requete;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean visibleOptionMail = false;
   private int var_choix_modele;
   private String nomModeleDocument;
   private String nomModeleListe;
   private boolean affListeDoc = false;
   private boolean showModalPanelPrint = false;
   private boolean showModalPanelPrintRib = false;
   private String nomRec;
   private String villeRec;
   private String categorieRec;
   private long conseillersRec;
   private String familleRec = "100";
   private String pdvRec = "100";
   private String regRec = "100";
   private String appreciationRec = "100";
   private String evenementRec = "100";
   private String activitesRec = "100";
   private String observationsRec = "100";
   private String observationsDirectRec;
   private String paysRec = "100";
   private String telRec = "";
   private String mailRec = "";
   private String prenomRec = "";
   private String fonctionRec = "";
   private String obsRec = "";
   private String serviceRec = "";
   private String typeRec = "100";
   private String centreInteretRec = "100";
   private String origineRec = "100";
   private String sitMatRec = "100";
   private int inpInactif = 0;
   private int compteLitige = 0;
   private boolean var_more_search = false;
   private List lesTiers = new ArrayList();
   private transient DataModel dataModelSociete = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean afficheButtOption = false;
   private List mesActivitesSocietesItems;
   private boolean choixGenre;
   private List mesObservationsItems;
   private List mesEvenementsItems;
   private List mesPaysItems;
   private List mesBanquesItems;
   private OptionTiers optionTiers;
   private boolean showModalGoogleMap = false;
   private URI uri;
   private UploadedFile uploadedFile;
   private UtilDownload utilDownload;
   private String fileName;
   private String urlphoto;
   private boolean showModalSupTiers = false;
   private String suppressionRejet;
   private boolean valideFiche = false;
   private List mesCentresIntereItems;
   private List listeCentreInteret;
   private transient DataModel dataModelCentreInteret;
   private boolean showModalPanelCentreInteret = false;
   private boolean chronoActif = false;
   private Chrono chrono;
   private CalculChrono calculChrono;
   private ObjetImmatriculation objetImmatriculation;
   private List mesCompteItem;
   private int choixCompte;
   private String compte;
   private boolean showModalPanelImmatriculation = false;
   private int compteModif;
   private List mesNatureCompteItem;
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
   private boolean showModalPanelContact = false;
   private boolean showModalPanelBanque = false;
   private Contacts contacts;
   private List lesContactsListe;
   private ContactDao contactDao;
   private transient DataModel datamodelContact;
   private boolean testContact = false;
   private boolean contactBanque = false;
   private boolean showModalPanelPrintContact = false;
   private boolean showModalPanelResponsable = false;
   private Responsable responsable;
   private ResponsableDao responsableDao;
   private List lesResponsableListe;
   private transient DataModel datamodelResponsable;
   private boolean testDoubleResponsable = true;
   private boolean visibiliteBton = false;
   private UserDao userDao;
   private String choixUsers;
   private OptionVentes optionVentes;
   private List lesFamillesClientsListe;
   private List lesFamillesFournisseursListe;
   private DepotAchatsDao depotAchatsDao;
   private String devise;
   private List lesReglementsClient;
   private List lesReglementsFournisseur;
   private List lesEcritures;
   private EcrituresDao ecrituresDao;
   private int etatEcr = 1;
   private int cpteTiers = 0;
   private double totalDeb = 0.0D;
   private double totalCred = 0.0D;
   private double SoldeDebCred = 0.0D;
   private boolean showModalPanelRdv = false;
   private transient DataModel dataModelPlanning;
   private List lesPlanning;
   private Rdv newRdv;
   private int typeRdv;
   private String selectedUserdest;
   private boolean testRdv = false;
   private List mesTachesItem;
   private String choixTache;
   private int choixRdv;
   private List mesNaturesRdvItems;
   private FormMessagerie formMessagerie;
   private boolean showModalPanelMessagerie = false;
   private String urlExplorateur;
   private ConventionMedicalDao conventionMedicalDao;
   private ExercicesVentes exercicesVentes;
   private boolean showModalPanelConvention;
   private List mesLettresItem;
   private transient DataModel dataModelConvention;
   private List lesConventionMedicale;
   private int var_action_convention;
   private ConventionMedical conventionMedical;
   private String choixLettre;
   private boolean afficheButtConvention;
   private int type_produit;
   private TiersAdherentDao tiersAdherentDao;
   private TiersAdherent tiersAdherent;
   private transient DataModel dataModelAdherent;
   private List lesAdherents;
   private boolean showModalPanelAdherent;
   private boolean afficheButtAdherent;
   private transient DataModel dataModelDepot;
   private boolean showModalPanelDepot = false;
   private DocumentEntete documentEntete;
   private transient DataModel dataModelDocuments;
   private List lesDocumentsDetail;
   private transient DataModel dataModelDocumentsEntete;
   private List lesDocumentsEntete;
   private int choixDocument;
   private String choixFamilles;
   private String choixSeries;
   private Date dateDebut;
   private Date dateFin;
   private String choixProduit;
   private List mesFamilles;
   private List mesSeries;
   private float var_qte;
   private double var_total;
   private double var_reglement;
   private double var_solde;
   private double caHt;
   private int nbDoc;
   private double caMoyen;
   private int sansSources;
   private double caTrf;
   private int nbTrf;
   private float tauxTrf;
   private int nbJour;
   private double caJour;
   private float tauxJour;
   private int nbProduit;
   private double prixMoyen;
   private List mesJournauxComptables;
   private transient DataModel dataModelCatalogue;
   private List lesProduits;
   private transient DataModel dataModelCatalogueFichier;
   private List lesCataloguesFichiers;
   private boolean showModalPanelAjoutFile = false;
   private String cheminCatalogue;
   private String nomCatalogue;
   private boolean showModalPanelPj = false;
   private String fichierMine;
   private URL fichierUrl;
   private boolean showModalPanelPrintCatalogue = false;
   private Baremes baremes;
   private BaremesDao baremesDao;
   private List lesBaremes;
   private transient DataModel dataModelBaremes;
   private boolean showModalPanelRemise = false;
   private List mesFamilleVentestems;
   private String var_famille_produit;
   private Produits produits;
   private FormRecherche formRecherche;
   private boolean testRemise = false;
   private boolean remiseFamille = false;
   private transient DataModel dataModelParticipants;
   private transient DataModel dataModelParticipantsContact;
   private CampagneParticipantVentesDao campagneParticipantVentesDao;
   private CampagneParticipantVentes campagneParticipantVentes;
   private boolean showModalPanelParticipant = false;
   private transient DataModel dataModelCadeaux;
   private Cadeaux cadeaux;
   private CadeauxDao cadeauxDao;
   private transient DataModel dataModelBaux;
   private transient DataModel dataModelBiens;
   private transient DataModel dataModelGerances;
   private boolean immobExist = false;
   private boolean showModalPanelSms = false;
   private String numeroMobile;
   private String messageSms;
   private boolean showModalPanelIncident = false;
   private transient DataModel dataModelIncidents;
   private transient DataModel dataModelReglements;
   private double totDocument;
   private double totReglement;
   private transient DataModel dataModelServiceInterim;
   private List lesSerivicesInterim;
   private SiteDao siteDao;
   private Site serviceInterim;
   private boolean shomModalPanelServiceInterim = false;
   private boolean afficheServiceInterim;
   private transient DataModel dataModelConditionCalcul;
   private FraisTheoAchatsDao fraisTheoAchatsDao;
   private FraisTheoAchats fraisTheoAchats;
   private String urlphotoAgent;
   private UploadedFile uploadedPDFFile;
   private String pdfFileName;
   private transient DataModel dataModelDocumnts;
   private List lesDocuments;
   private String nomRepertoire;
   private String nomDocument;
   private List lesStructures;
   private String codeBanque;
   private String codeAgence;
   private String numCompte;
   private String numCleCtrl;
   private boolean modifAgence = false;
   private boolean showModalPanelProcuration = false;
   private boolean showModalPanelTestament = false;
   private Contacts contactsProcuration;
   private Contacts contactsTestament;
   private List lesProcurationsListe;
   private transient DataModel datamodelProcuration;
   private List lesTestamentsListe;
   private transient DataModel datamodelTestament;
   private String urlphotoProcuration;
   private String urlsignatureProcuration;
   private String libelleRabRis;
   private boolean ristourne;
   private boolean testRistourne;
   private boolean showModalPanelRistourne = false;
   private boolean showModalPanelTransfert = false;
   private Reglements reglements;
   private List listDepot;
   private Date dateRistourne;
   private double montantRistourne;
   private List listBeneficiaireItems;
   private double montantMax = 0.0D;
   private long idBeneficiaire = 0L;
   private int choixRacine;
   private String selecFiscalite;
   private transient DataModel dataModelProdExoTva;
   private List lesProdExo;
   private OptionGroupe optionGroupe;
   private boolean gestionTiers = false;
   private long var_memo_id_master;
   private List lesPegStr;
   private List lesContratsEcheance;
   private ContratEcheanceVentes contratEcheanceVentes;
   private ContratEcheanceVentesDao contratEcheanceVentesDao;
   private List lesContratsVentes;
   private ContratEnteteVentes contratEnteteVentes;
   private ContratEnteteVentesDao contratEnteteVentesDao;
   private boolean showModalPanelContrat = false;
   private List mesContactItem;
   private List mesModelesItems;
   private String var_code_modele;
   private UtilTdt utilTdt;
   private boolean afficheTexteContrat = false;
   private ModelesCourriersDao modelesCourriersDao;
   private List mesBiensItems;
   private boolean visibiliteContrat = false;
   private boolean visibiliteEcheance = false;
   private boolean showModalPanelEcheance = false;

   public FormTiers() throws IOException {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.objetImmatriculation = new ObjetImmatriculation();
      this.mesCompteItem = new ArrayList();
      this.mesNatureCompteItem = new ArrayList();
      this.lesResponsableListe = new ArrayList();
      this.datamodelResponsable = new ListDataModel();
      this.lesContactsListe = new ArrayList();
      this.datamodelContact = new ListDataModel();
      this.dataModelConvention = new ListDataModel();
      this.lesConventionMedicale = new ArrayList();
      this.mesLettresItem = new ArrayList();
      this.dataModelDepot = new ListDataModel();
      this.lesEcritures = new ArrayList();
      this.lesPlanning = new ArrayList();
      this.mesJournauxComptables = new ArrayList();
      this.lesDocumentsEntete = new ArrayList();
      this.dataModelDocumentsEntete = new ListDataModel();
      this.lesDocumentsDetail = new ArrayList();
      this.dataModelDocuments = new ListDataModel();
      this.lesBaremes = new ArrayList();
      this.dataModelBaremes = new ListDataModel();
      this.utilDownload = new UtilDownload();
      this.mesActivitesSocietesItems = new ArrayList();
      this.mesObservationsItems = new ArrayList();
      this.mesPaysItems = new ArrayList();
      this.mesEvenementsItems = new ArrayList();
      this.dataModelParticipants = new ListDataModel();
      this.dataModelParticipantsContact = new ListDataModel();
      this.dataModelCadeaux = new ListDataModel();
      this.dataModelBaux = new ListDataModel();
      this.dataModelBiens = new ListDataModel();
      this.dataModelGerances = new ListDataModel();
      this.dataModelDocumnts = new ListDataModel();
      this.lesDocuments = new ArrayList();
      this.lesStructures = new ArrayList();
      this.lesProcurationsListe = new ArrayList();
      this.datamodelProcuration = new ListDataModel();
      this.lesTestamentsListe = new ArrayList();
      this.datamodelTestament = new ListDataModel();
      this.listBeneficiaireItems = new ArrayList();
      this.dataModelConditionCalcul = new ListDataModel();
      this.dataModelProdExoTva = new ListDataModel();
      this.lesProdExo = new ArrayList();
      this.optionGroupe = new OptionGroupe();
      this.lesPegStr = new ArrayList();
      this.mesBanquesItems = new ArrayList();
      this.mesBiensItems = new ArrayList();
      this.lesContratsVentes = new ArrayList();
      this.lesContratsEcheance = new ArrayList();
      this.mesNaturesRdvItems = new ArrayList();
      this.mesCentresIntereItems = new ArrayList();
      this.listeCentreInteret = new ArrayList();
      this.dataModelCentreInteret = new ListDataModel();
   }

   public void InstancesDaoUtilses() {
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.responsableDao = new ResponsableDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
      this.campagneParticipantVentesDao = new CampagneParticipantVentesDao(this.baseLog, this.utilInitHibernate);
      this.cadeauxDao = new CadeauxDao(this.baseLog, this.utilInitHibernate);
      this.contratEnteteVentesDao = new ContratEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.contratEcheanceVentesDao = new ContratEcheanceVentesDao(this.baseLog, this.utilInitHibernate);
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
   }

   public void recupererOptionsTiers() throws ParseException, HibernateException, NamingException {
      if ("XXX".equals(this.ligneMenu.getGenre())) {
         this.typeTiers = 7;
      } else {
         this.typeTiers = Integer.parseInt(this.ligneMenu.getType());
      }

      if (!"001".equals(this.ligneMenu.getGenre()) && !"011".equals(this.ligneMenu.getGenre())
              && !"021".equals(this.ligneMenu.getGenre()) && !"023".equals(this.ligneMenu.getGenre())
              && !"031".equals(this.ligneMenu.getGenre()) && !"071".equals(this.ligneMenu.getGenre())
              && !"081".equals(this.ligneMenu.getGenre())) {
         this.choixGenre = true;
      } else {
         this.choixGenre = false;
      }

      if (this.rechercheModule(this.structureLog, "4")) {
         this.comptaExist = true;
      } else {
         this.comptaExist = false;
      }

      if (this.rechercheModule(this.structureLog, "6")) {
         this.achatExist = true;
      } else {
         this.achatExist = false;
      }

      this.venteExist = false;
      this.abnExist = false;
      this.immobExist = false;
      this.transitExist = false;
      this.interimExist = false;
      this.medicalExist = false;
      this.fondationExist = false;
      this.mefExist = false;
      if (this.typeVente == 801 || this.typeVente == 802
              || this.typeVente == 803 || this.typeVente == 804
              || this.typeVente == 805 || this.typeVente == 806
              || this.typeVente == 807 || this.typeVente == 810
              || this.typeVente == 815 || this.typeVente == 816) {

         this.venteExist = true;
         if (this.typeVente == 803) {
            this.fondationExist = true;
         } else if (this.typeVente == 804) {
            this.interimExist = true;
            this.dataModelServiceInterim = new ListDataModel();
            this.lesSerivicesInterim = new ArrayList();
            this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
         } else if (this.typeVente != 805) {
            if (this.typeVente == 806) {
               this.transitExist = true;
            } else if (this.typeVente == 807) {
               this.mefExist = true;
            } else if (this.typeVente == 810) {
               this.abnExist = true;
            } else if (this.typeVente == 815) {
               this.medicalExist = true;
            } else if (this.typeVente == 816) {
               this.immobExist = true;
            }
         }

         LireLesoptionsVentes var1 = new LireLesoptionsVentes();
         var1.setStrId(this.structureLog.getStrid());
         var1.lancer();
         this.optionVentes = var1.getOptionsVentes();
      }

      if (this.optionTiers.getNbLigneMaxTi() != null && !this.optionTiers.getNbLigneMaxTi().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionTiers.getNbLigneMaxTi());
      } else {
         this.var_nb_max = 100;
      }

      Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      this.chargerActivitesMetiers(var11);
      this.utilInitHibernate.closeSession();
      this.lesTiers.clear();
      if (this.formRecherche != null && this.formRecherche.getTiers() != null) {
         if (this.ligneMenu.getGenre().equals("XXX")) {
            if (this.ligneMenu.getType().equals(this.formRecherche.getTiers().getTietype())) {
               this.lesTiers.add(this.formRecherche.getTiers());
            }
         } else if (this.ligneMenu.getType().equals(this.formRecherche.getTiers().getTietype())
                 && this.ligneMenu.getGenre().equals(this.formRecherche.getTiers().getTiegenre())) {
            this.lesTiers.add(this.formRecherche.getTiers());
         }
      }

      this.dataModelSociete.setWrappedData(this.lesTiers);
      LectureBanque var2 = new LectureBanque();
      var2.setStrId(this.structureLog.getStrid());
      var2.setStructureLog(this.structureLog);
      var2.recupereBanque();
      this.mesBanquesItems = var2.getMesBanquesItems();
      if (this.optionVentes != null && this.optionVentes.getDecrmtRabais().equals("3")) {
         this.libelleRabRis = "Ristourne";
         this.ristourne = true;
      } else {
         this.libelleRabRis = "Rabais";
         this.ristourne = false;
      }

      long var3 = 0L;
      var3 = this.structureLog.getStrid();
      File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "groupe" + File.separator + "configuration" + File.separator + "optionsGroupe_" + var3 + ".xml");
      if (var5.exists()) {
         this.chercherAutorisationTiers(var3);
      } else {
         this.gestionTiers = true;
         if (this.structureLog.getStrmaitrecabinet() == 12 || this.structureLog.getStrmaitrecabinet() == 13 || this.structureLog.getStrmaitrecabinet() == 14) {
            new StructurePeg();
            StructureDao var7 = new StructureDao(this.utilInitHibernate);
            StructurePeg var6 = var7.logStructurePeg(this.structureLog.getStrid());
            if (var6 != null) {
               long var8 = var6.getCabinetPeg().getCabId();
               this.lesPegStr.clear();
               String var10 = " where cabinetPeg.cabId=" + var8 + " and (str_maitre_cabinet=2 or str_maitre_cabinet=3 or str_maitre_cabinet=4)";
               this.lesPegStr = var7.selectStructureCabinet(var10);
               if (this.lesPegStr.size() != 0) {
                  var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "groupe" + File.separator + "configuration" + File.separator + "optionsGroupe_" + ((StructurePeg)this.lesPegStr.get(0)).getStrId() + ".xml");
                  if (var5.exists()) {
                     this.chercherAutorisationTiers(((StructurePeg)this.lesPegStr.get(0)).getStrId());
                  }
               }
            }
         }
      }

      this.chargerMesracines();
   }

   public void chercherAutorisationTiers(long var1) {
      if ((this.typeTiers == 0 || this.typeTiers == 1 || this.typeTiers == 2) && !this.genreTiers.equals("080") && !this.genreTiers.equals("081")) {
         LireLesoptionsGroupe var3 = new LireLesoptionsGroupe();
         var3.setStrId(var1);
         this.optionGroupe = var3.lancerExploitation();
         if (this.optionGroupe.getSynchroTiers().equals("1")) {
            if (this.structureLog.getStrid() == var1) {
               this.gestionTiers = true;
            } else {
               this.gestionTiers = false;
            }
         } else {
            this.gestionTiers = true;
         }
      } else if (this.structureLog.getStrid() == var1) {
         this.gestionTiers = false;
      } else {
         this.gestionTiers = true;
      }

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
      this.planComptable = new PlanComptable();
      this.planComptable.setPlcCompte("");
      this.existeCopteDeja = true;
      String var1;
      if (this.choixCompte == 0) {
         var1 = "";
         if (this.newtiers.getTietype().equalsIgnoreCase("0")) {
            var1 = "(6,9)";
            this.mesCompteItem = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.exerciceSelectionne.getExecpt_id(), var1, 0, (Session)null);
         } else if (this.newtiers.getTietype().equalsIgnoreCase("3")) {
            var1 = "(7)";
            this.mesCompteItem = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.exerciceSelectionne.getExecpt_id(), var1, 0, (Session)null);
         } else {
            var1 = "(90)";
            this.mesCompteItem = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.exerciceSelectionne.getExecpt_id(), var1, 0, (Session)null);
         }
      } else if (this.choixCompte == 1) {
         this.chargeRacineCompte();
      } else if (this.choixCompte == 2) {
         var1 = "(90)";
         this.mesCompteItem = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.exerciceSelectionne.getExecpt_id(), var1, 0, (Session)null);
      }

   }

   public void chargerActivitesMetiers(Session var1) throws HibernateException, NamingException {
      this.mesActivitesSocietesItems.clear();
      this.mesActivitesSocietesItems = this.tiersDao.chargerLesActivitesUtilisees(this.typeTiers, this.choixGenre, var1);
      this.mesPaysItems.clear();
      this.mesPaysItems = this.tiersDao.chargerLesPaysUtilisees(this.typeTiers, this.choixGenre, var1);
      if (this.typeTiers != 1 && this.typeTiers != 2) {
         this.mesObservationsItems.clear();
         this.mesEvenementsItems.clear();
      } else {
         this.mesObservationsItems.clear();
         this.mesObservationsItems = this.tiersDao.chargerLesObservationsUtilisees(this.typeTiers, this.choixGenre, var1);
         this.mesEvenementsItems.clear();
         LectureNatureRdv var2 = new LectureNatureRdv(this.baseLog);
         new ArrayList();
         List var3 = var2.getMesNatureRdvUtil();

         for(int var4 = 0; var4 < var3.size(); ++var4) {
            if (((ObjetCompte)var3.get(var4)).isValide()) {
               this.mesEvenementsItems.add(new SelectItem(((ObjetCompte)var3.get(var4)).getCode(), ((ObjetCompte)var3.get(var4)).getCode() + ":" + ((ObjetCompte)var3.get(var4)).getNom_FR()));
            }
         }

         if (this.mesEvenementsItems == null || this.mesEvenementsItems.size() == 0) {
            this.mesEvenementsItems.add(new SelectItem("1", "1:Rdv (défaut)"));
         }
      }

   }

   public void recupererOptionsTiersContact() throws ParseException, HibernateException, NamingException {
      if (this.rechercheModule(this.structureLog, "4")) {
         this.comptaExist = true;
      } else {
         this.comptaExist = false;
      }

      if (this.rechercheModule(this.structureLog, "6")) {
         this.achatExist = true;
      } else {
         this.achatExist = false;
      }

      this.venteExist = false;
      this.immobExist = false;
      this.interimExist = false;
      this.fondationExist = false;
      if (this.typeVente == 801 || this.typeVente == 802 || this.typeVente == 803 || this.typeVente == 804 || this.typeVente == 816) {
         this.venteExist = true;
         if (this.typeVente == 803) {
            this.fondationExist = true;
         } else if (this.typeVente == 804) {
            this.interimExist = true;
         } else if (this.typeVente == 816) {
            this.immobExist = true;
         }

         LireLesoptionsVentes var1 = new LireLesoptionsVentes();
         var1.setStrId(this.structureLog.getStrid());
         var1.lancer();
         this.optionVentes = var1.getOptionsVentes();
      }

      if (this.optionTiers.getNbLigneMaxTi() != null && !this.optionTiers.getNbLigneMaxTi().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionTiers.getNbLigneMaxTi());
      } else {
         this.var_nb_max = 100;
      }

      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      this.chargerActivitesMetiersContact(var2);
      this.utilInitHibernate.closeSession();
   }

   public void chargerActivitesMetiersContact(Session var1) throws HibernateException, NamingException {
      this.mesActivitesSocietesItems.clear();
      this.mesActivitesSocietesItems = this.tiersDao.chargerLesActivitesUtilisees(7, this.choixGenre, var1);
      this.mesPaysItems.clear();
      this.mesPaysItems = this.tiersDao.chargerLesPaysUtilisees(99, false, var1);
   }

   public boolean rechercheModule(Structure var1, String var2) {
      boolean var3 = false;
      ArrayList var4 = new ArrayList();
      if (var1.getStrmod1() != null && !var1.getStrmod1().isEmpty()) {
         var4.add(var1.getStrmod1());
      }

      if (var1.getStrmod2() != null && !var1.getStrmod2().isEmpty()) {
         var4.add(var1.getStrmod2());
      }

      if (var1.getStrmod3() != null && !var1.getStrmod3().isEmpty()) {
         var4.add(var1.getStrmod3());
      }

      if (var1.getStrmod4() != null && !var1.getStrmod4().isEmpty()) {
         var4.add(var1.getStrmod4());
      }

      if (var1.getStrmod5() != null && !var1.getStrmod5().isEmpty()) {
         var4.add(var1.getStrmod5());
      }

      if (var1.getStrmod6() != null && !var1.getStrmod6().isEmpty()) {
         var4.add(var1.getStrmod6());
      }

      if (var1.getStrmod7() != null && !var1.getStrmod7().isEmpty()) {
         var4.add(var1.getStrmod7());
      }

      if (var1.getStrmod8() != null && !var1.getStrmod8().isEmpty()) {
         var4.add(var1.getStrmod8());
      }

      if (var1.getStrmod9() != null && !var1.getStrmod8().isEmpty()) {
         var4.add(var1.getStrmod9());
      }

      if (var1.getStrmod10() != null && !var1.getStrmod10().isEmpty()) {
         var4.add(var1.getStrmod10());
      }

      for(int var5 = 0; var5 < var4.size(); ++var5) {
         if (((String)var4.get(var5)).startsWith(var2)) {
            var3 = true;
         }
      }

      return var3;
   }

   public void moreSearch() {
      if (!this.var_more_search) {
         this.var_more_search = true;
      } else {
         this.var_more_search = false;
      }

   }

   public void chargerLesTiers() throws HibernateException, NamingException, JDOMException, IOException {
      this.lesTiers.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      List var1;
      List var2;
      int var3;
      boolean var4;
      int var5;
      int var6;
      long var9;
      if (this.mailRec != null && !this.mailRec.isEmpty()) {
         new ArrayList();
         var1 = this.contactDao.listeContacts(this.rechercherTiersMail(), (Session)null);
         if (var1.size() != 0) {
            var9 = 0L;
            var4 = false;

            for(var5 = 0; var5 < var1.size(); ++var5) {
               this.contacts = (Contacts)var1.get(var5);
               var9 = this.contacts.getTiers().getTieid();
               var4 = false;
               if (this.lesTiers.size() == 0) {
                  this.lesTiers.add(this.contacts.getTiers());
               } else {
                  for(var6 = 0; var6 < this.lesTiers.size(); ++var6) {
                     if (((Tiers)this.lesTiers.get(var6)).getTieid() == this.contacts.getTiers().getTieid()) {
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     this.lesTiers.add(this.contacts.getTiers());
                  }
               }
            }
         }

         new ArrayList();
         var2 = this.tiersDao.listeTiers(this.rechercherTiers(), (Session)null);
         if (var2.size() != 0) {
            for(var3 = 0; var3 < var2.size(); ++var3) {
               this.lesTiers.add(var2.get(var3));
            }
         }
      } else if (this.conseillersRec != 0L && this.conseillersRec != 99999999L) {
         new ArrayList();
         var1 = this.responsableDao.listeConseillers(this.rechercherTiersConseiller(), (Session)null);
         if (var1.size() != 0) {
            var9 = 0L;
            var4 = false;

            for(var5 = 0; var5 < var1.size(); ++var5) {
               this.responsable = (Responsable)var1.get(var5);
               var9 = this.responsable.getTiers().getTieid();
               var4 = false;
               if (this.lesTiers.size() == 0) {
                  this.lesTiers.add(this.responsable.getTiers());
               } else {
                  for(var6 = 0; var6 < this.lesTiers.size(); ++var6) {
                     if (((Tiers)this.lesTiers.get(var6)).getTieid() == this.responsable.getTiers().getTieid()) {
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     this.lesTiers.add(this.responsable.getTiers());
                  }
               }
            }
         }
      } else if (this.conseillersRec != 0L && this.conseillersRec == 99999999L) {
         new ArrayList();
         var1 = this.responsableDao.selectResponsable((Session)null);
         new ArrayList();
         var2 = this.tiersDao.listeTiers(this.rechercherTiers(), (Session)null);
         if (var2.size() != 0 && var1.size() != 0) {
            for(var3 = 0; var3 < var2.size(); ++var3) {
               var4 = false;

               for(var5 = 0; var5 < var1.size(); ++var5) {
                  if (((Tiers)var2.get(var3)).getTieid() == ((Responsable)var1.get(var5)).getTiers().getTieid()) {
                     var4 = true;
                     break;
                  }
               }

               if (!var4) {
                  this.lesTiers.add(var2.get(var3));
               }
            }
         }
      } else {
         this.lesTiers = this.tiersDao.listeTiers(this.rechercherTiers(), (Session)null);
      }

      int var12;
      if (this.usersLog.getUsrTiers() == 3 && this.lesTiers.size() != 0) {
         String var8 = "";

         for(var12 = 0; var12 < this.lesTiers.size(); ++var12) {
            if (var8 != null && !var8.isEmpty()) {
               var8 = var8 + "," + ((Tiers)this.lesTiers.get(var12)).getTieid();
            } else {
               var8 = "" + ((Tiers)this.lesTiers.get(var12)).getTieid();
            }
         }

         var8 = "(" + var8 + ")";
         this.lesTiers = this.responsableDao.chargerLesResponsables(this.usersLog.getUsrid(), var8, (Session)null);
      }

      if (this.evenementRec != null && !this.evenementRec.isEmpty() && !this.evenementRec.equals("100") && this.lesTiers.size() != 0) {
         boolean var10 = false;
         int var11;
         if (this.evenementRec.equals("101")) {
            var11 = 99;
         } else {
            var11 = Integer.parseInt(this.evenementRec);
         }

         new ArrayList();
         RdvDao var13 = new RdvDao(this.baseLog, this.utilInitHibernate);
         var2 = var13.chargerRdv(var11, (Session)null);
         ArrayList var17 = new ArrayList();

         for(var5 = 0; var5 < this.lesTiers.size(); ++var5) {
            var17.add(this.lesTiers.get(var5));
         }

         this.lesTiers.clear();

         for(var5 = 0; var5 < var17.size(); ++var5) {
            this.newtiers = (Tiers)var17.get(var5);
            boolean var16 = false;

            for(int var7 = 0; var7 < var2.size(); ++var7) {
               if (((Rdv)var2.get(var7)).getRdvTieIdDe() == this.newtiers.getTieid()) {
                  if (var11 == 99) {
                     var16 = true;
                     break;
                  }

                  if (((Rdv)var2.get(var7)).getRdvNature() == var11) {
                     var16 = true;
                     break;
                  }
               }
            }

            if (this.evenementRec.equals("101") && !var16) {
               this.lesTiers.add(this.newtiers);
            } else if (!this.evenementRec.equals("101") && var16) {
               this.lesTiers.add(this.newtiers);
            }
         }
      }

      if (this.typeTiers == 1 || this.typeTiers == 2) {
         new ArrayList();
         var1 = this.responsableDao.selectResponsable((Session)null);

         for(var12 = 0; var12 < this.lesTiers.size(); ++var12) {
            this.newtiers = (Tiers)this.lesTiers.get(var12);
            this.newtiers.setNomConseiller("");
            String var14 = "";

            for(int var18 = 0; var18 < var1.size(); ++var18) {
               if (((Responsable)var1.get(var18)).getTiers().getTieid() == this.newtiers.getTieid()) {
                  if (var14 != null && !var14.isEmpty()) {
                     if (((Responsable)var1.get(var18)).getRpbprenom() != null && !((Responsable)var1.get(var18)).getRpbprenom().isEmpty()) {
                        var14 = var14 + "," + ((Responsable)var1.get(var18)).getRpbnom() + " " + ((Responsable)var1.get(var18)).getRpbprenom();
                     } else {
                        var14 = var14 + "," + ((Responsable)var1.get(var18)).getRpbnom();
                     }
                  } else if (((Responsable)var1.get(var18)).getRpbprenom() != null && !((Responsable)var1.get(var18)).getRpbprenom().isEmpty()) {
                     var14 = ((Responsable)var1.get(var18)).getRpbnom() + " " + ((Responsable)var1.get(var18)).getRpbprenom();
                  } else {
                     var14 = ((Responsable)var1.get(var18)).getRpbnom();
                  }
               }
            }

            this.newtiers.setNomConseiller(var14);
         }
      }

      if (this.structureLog.getStrmaitrecabinet() == 2) {
         new Tiers();

         for(var12 = 0; var12 < this.lesTiers.size(); ++var12) {
            Tiers var15 = (Tiers)this.lesTiers.get(var12);
            if (var15.getTieidgroupe() == 0L) {
               var15.setNomGroupe("");
            } else if (this.lesStructures.size() == 0) {
               var15.setNomGroupe("" + var15.getTieidgroupe());
            } else {
               var15.setNomGroupe("");

               for(var3 = 0; var3 < this.lesStructures.size(); ++var3) {
                  if (((StructurePeg)this.lesStructures.get(var3)).getStrId() == var15.getTieidgroupe()) {
                     var15.setNomGroupe(((StructurePeg)this.lesStructures.get(var3)).getStrsigle());
                     break;
                  }
               }

               if (var15.getNomGroupe() == null || var15.getNomGroupe().isEmpty()) {
                  var15.setNomGroupe("" + var15.getTieidgroupe());
               }
            }
         }
      }

      this.dataModelSociete.setWrappedData(this.lesTiers);
      this.afficheButtOption = false;
   }

   public void chargerCentreInteret() throws JDOMException, IOException {
      if (this.typeTiers != 1 && this.typeTiers != 2) {
         this.listeCentreInteret.clear();
         this.dataModelCentreInteret.setWrappedData(this.listeCentreInteret);
      } else {
         LectureElementRdv var1 = new LectureElementRdv();
         var1.setStrId(this.structureLog.getStrid());
         var1.setStructureLog(this.structureLog);
         var1.chargerMesCentreInteret();
         this.listeCentreInteret = var1.getMesElements();
         this.dataModelCentreInteret.setWrappedData(this.listeCentreInteret);
      }

      this.mesCentresIntereItems.clear();

      for(int var2 = 0; var2 < this.listeCentreInteret.size(); ++var2) {
         this.mesCentresIntereItems.add(new SelectItem(((ObjetElementRdv)this.listeCentreInteret.get(var2)).getLibelle()));
      }

   }

   public String rechercherTiersMail() {
      String var1 = "";
      if (this.ligneMenu.getGenre().equals("XXX")) {
         var1 = "from Contacts where (tiers.tietype=1 or tiers.tietype=2 or tiers.tietype=3)";
      } else if (this.ligneMenu.getGenre().equals("YYY")) {
         var1 = "from Contacts where (tiers.tietype=0 or tiers.tietype=1 or tiers.tietype=2 or tiers.tietype=3)";
      } else {
         var1 = "from Contacts where tiers.tietype='" + this.ligneMenu.getType() + "' and tiers.tiegenre='" + this.ligneMenu.getGenre() + "'";
      }

      if (this.compteLitige == 1) {
         var1 = var1 + " and tiers.tiesurveille=1";
      } else if (this.compteLitige == 2) {
         var1 = var1 + " and tiers.tiecomptebloque=1";
      } else if (this.compteLitige == 3) {
         var1 = var1 + " and tiers.tiechequeinterdit=1";
      } else if (this.compteLitige == 4) {
         var1 = var1 + " and tiers.tieconventiongele=true";
      }

      if (this.usersLog.getUsrTiers() == 1) {
         var1 = var1 + " and ((tiers.tievisibilite=0) or (tiers.tievisibilite=1 and tiers.tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tiers.tievisibilite=2 and tiers.tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      } else if (this.usersLog.getUsrTiers() == 2) {
         var1 = var1 + " and tiers.tieusercreat=" + this.usersLog.getUsrid() + " and ((tiers.tievisibilite=0) or (tiers.tievisibilite=1 and tiers.tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tiers.tievisibilite=2 and tiers.tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      } else if (this.usersLog.getUsrTiers() == 3) {
         var1 = var1 + " and ((tiers.tievisibilite=0) or (tiers.tievisibilite=1 and tiers.tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tiers.tievisibilite=2 and tiers.tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      }

      if (this.nomRec != null && !this.nomRec.isEmpty() && !this.nomRec.contains("*")) {
         var1 = var1 + " and (tiers.tieraisonsocialenom LIKE" + "'" + this.nomRec + "%' or tiers.tiesigle like '%" + this.nomRec + "%')";
      }

      String var2;
      if (this.nomRec != null && !this.nomRec.isEmpty() && this.nomRec.startsWith("*")) {
         var2 = this.nomRec.substring(1);
         var1 = var1 + " and (tiers.tieraisonsocialenom LIKE " + "'%" + var2 + "%' or tiers.tiesigle like '" + var2 + "%')";
      }

      if (this.prenomRec != null && !this.prenomRec.isEmpty()) {
         var1 = var1 + " and tiers.tieprenom LIKE" + "'" + this.prenomRec + "%'";
      }

      if (this.villeRec != null && !this.villeRec.isEmpty()) {
         var1 = var1 + " and tiers.tieville LIKE" + "'" + this.villeRec + "%'";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && !this.mailRec.contains("*")) {
         var1 = var1 + " and (tiers.tiemail1 LIKE " + "'" + this.mailRec + "%' or tiers.tiemail2 like '" + this.mailRec + "%' or tiers.tiemail3 like '" + this.mailRec + "%' or tiers.tiemail4 like '" + this.mailRec + "%' or tiers.tiemail5 like '" + this.mailRec + "%' or tiers.tieyahoo like '" + this.mailRec + "%' or tiers.tiemsn like '" + this.mailRec + "%' or tiers.tieaol like '" + this.mailRec + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && this.mailRec.startsWith("*")) {
         var2 = this.mailRec.substring(1);
         var1 = var1 + " and (tiers.tiemail1 LIKE " + "'%" + var2 + "%' or tiers.tiemail2 like '%" + var2 + "%' or tiers.tiemail3 like '%" + var2 + "%' or tiers.tiemail4 like '%" + var2 + "%' or tiers.tiemail5 like '%" + var2 + "%' or tiers.tieyahoo like '%" + var2 + "%' or tiers.tiemsn like '%" + var2 + "%' or tiers.tieaol like '%" + var2 + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && !this.mailRec.contains("*")) {
         var1 = var1 + " or (conmail1 LIKE " + "'" + this.mailRec + "%' or conmail2 like '" + this.mailRec + "%' or conmail3 like '" + this.mailRec + "%' or conmail4 like '" + this.mailRec + "%' or conmail5 like '" + this.mailRec + "%' or conyahoo like '" + this.mailRec + "%' or conmsn like '" + this.mailRec + "%' or conaol like '" + this.mailRec + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && this.mailRec.startsWith("*")) {
         var2 = this.mailRec.substring(1);
         var1 = var1 + " or (conmail1 LIKE " + "'%" + var2 + "%' or conmail2 like '%" + var2 + "%' or conmail3 like '%" + var2 + "%' or conmail4 like '%" + var2 + "%' or conmail5 like '%" + var2 + "%' or conyahoo like '%" + var2 + "%' or conmsn like '%" + var2 + "%' or conaol like '%" + var2 + "%')";
      }

      if (this.categorieRec != null && !this.categorieRec.isEmpty() && !this.categorieRec.equals("100")) {
         var1 = var1 + " and  tiers.tiecategorie=" + "'" + this.categorieRec + "'";
      }

      if (this.familleRec != null && !this.familleRec.isEmpty() && !this.familleRec.equals("100")) {
         var1 = var1 + " and  tiers.tienomfamille=" + "'" + this.familleRec + "'";
      }

      String[] var3;
      if (this.pdvRec != null && !this.pdvRec.isEmpty() && !this.pdvRec.equals("100")) {
         if (this.pdvRec.contains(":")) {
            var3 = this.pdvRec.split(":");
            var1 = var1 + " and tiers.tiepdv=" + "'" + var3[0] + "'";
         } else {
            var1 = var1 + " and tiers.tiepdv=" + "'" + this.pdvRec + "'";
         }
      }

      if (this.regRec != null && !this.regRec.isEmpty() && !this.regRec.equals("100")) {
         if (this.regRec.contains(":")) {
            var3 = this.regRec.split(":");
            var1 = var1 + " and tiers.tieregion=" + "'" + var3[0] + "'";
         } else {
            var1 = var1 + " and tiers.tieregion=" + "'" + this.regRec + "'";
         }
      }

      if (this.appreciationRec != null && !this.appreciationRec.isEmpty() && !this.appreciationRec.equals("100")) {
         var1 = var1 + " and tiers.tienoteman=" + "'" + this.appreciationRec + "'";
      }

      if (this.activitesRec != null && !this.activitesRec.isEmpty() && !this.activitesRec.equals("100") && !this.activitesRec.equals("****")) {
         var1 = var1 + " and (tiers.tieactivite1=" + "'" + this.activitesRec + "' or tiers.tieactivite2=" + "'" + this.activitesRec + "' or tiers.tieprofession=" + "'" + this.activitesRec + "')";
      }

      if (this.activitesRec != null && !this.activitesRec.isEmpty() && this.activitesRec.equals("****")) {
         var1 = var1 + " and (tiers.tieactivite1 is null or tiers.tieactivite1='' or tiers.tieactivite2 is null or tiers.tieactivite2='' or tiers.tieprofession is null or tiers.tieprofession='')";
      }

      if (this.observationsRec != null && !this.observationsRec.isEmpty() && !this.observationsRec.equals("100")) {
         var1 = var1 + " and tiers.tieobservations=" + "'" + this.observationsRec + "'";
      }

      if (this.observationsDirectRec != null && !this.observationsDirectRec.isEmpty()) {
         var1 = var1 + " and tiers.tieobservations like " + "'%" + this.observationsDirectRec + "%'";
      }

      if (this.paysRec != null && !this.paysRec.isEmpty() && !this.paysRec.equals("100")) {
         var1 = var1 + " and tiers.tienompays=" + "'" + this.paysRec + "'";
      }

      if (this.centreInteretRec != null && !this.centreInteretRec.isEmpty() && !this.centreInteretRec.equals("100")) {
         var1 = var1 + " and tiers.tieinteret=" + "'" + this.centreInteretRec + "'";
      }

      if (this.origineRec != null && !this.origineRec.isEmpty() && !this.origineRec.equals("100")) {
         var1 = var1 + " and tiers.tieorigine=" + "'" + this.origineRec + "'";
      }

      if (this.sitMatRec != null && !this.sitMatRec.isEmpty() && !this.sitMatRec.equals("100")) {
         var1 = var1 + " and tiers.tiesitfam=" + "'" + this.sitMatRec + "'";
      }

      return var1;
   }

   public String rechercherTiersConseiller() {
      String var1 = "";
      if (this.ligneMenu.getGenre().equals("XXX")) {
         var1 = "from Responsable where (tiers.tietype=1 or tiers.tietype=2 or tiers.tietype=3)";
      } else if (this.ligneMenu.getGenre().equals("YYY")) {
         var1 = "from Responsable where (tiers.tietype=0 or tiers.tietype=1 or tiers.tietype=2 or tiers.tietype=3)";
      } else {
         var1 = "from Responsable where tiers.tietype='" + this.ligneMenu.getType() + "' and tiers.tiegenre='" + this.ligneMenu.getGenre() + "'";
      }

      var1 = var1 + " and rpbuserid=" + this.conseillersRec;
      if (this.compteLitige == 1) {
         var1 = var1 + " and tiers.tiesurveille=1";
      } else if (this.compteLitige == 2) {
         var1 = var1 + " and tiers.tiecomptebloque=1";
      } else if (this.compteLitige == 3) {
         var1 = var1 + " and tiers.tiechequeinterdit=1";
      } else if (this.compteLitige == 4) {
         var1 = var1 + " and tiers.tieconventiongele=true";
      }

      if (this.usersLog.getUsrTiers() == 1) {
         var1 = var1 + " and ((tiers.tievisibilite=0) or (tiers.tievisibilite=1 and tiers.tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tiers.tievisibilite=2 and tiers.tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      } else if (this.usersLog.getUsrTiers() == 2) {
         var1 = var1 + " and tiers.tieusercreat=" + this.usersLog.getUsrid() + " and ((tiers.tievisibilite=0) or (tiers.tievisibilite=1 and tiers.tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tiers.tievisibilite=2 and tiers.tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      } else if (this.usersLog.getUsrTiers() == 3) {
         var1 = var1 + " and ((tiers.tievisibilite=0) or (tiers.tievisibilite=1 and tiers.tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tiers.tievisibilite=2 and tiers.tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      }

      if (this.nomRec != null && !this.nomRec.isEmpty() && !this.nomRec.contains("*")) {
         var1 = var1 + " and (tiers.tieraisonsocialenom LIKE" + "'" + this.nomRec + "%' or tiers.tiesigle like '%" + this.nomRec + "%')";
      }

      String var2;
      if (this.nomRec != null && !this.nomRec.isEmpty() && this.nomRec.startsWith("*")) {
         var2 = this.nomRec.substring(1);
         var1 = var1 + " and (tiers.tieraisonsocialenom LIKE " + "'%" + var2 + "%' or tiers.tiesigle like '" + var2 + "%')";
      }

      if (this.prenomRec != null && !this.prenomRec.isEmpty()) {
         var1 = var1 + " and tiers.tieprenom LIKE" + "'" + this.prenomRec + "%'";
      }

      if (this.villeRec != null && !this.villeRec.isEmpty()) {
         var1 = var1 + " and tiers.tieville LIKE" + "'" + this.villeRec + "%'";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && !this.mailRec.contains("*")) {
         var1 = var1 + " and (tiers.tiemail1 LIKE " + "'" + this.mailRec + "%' or tiers.tiemail2 like '" + this.mailRec + "%' or tiers.tiemail3 like '" + this.mailRec + "%' or tiers.tiemail4 like '" + this.mailRec + "%' or tiers.tiemail5 like '" + this.mailRec + "%' or tiers.tieyahoo like '" + this.mailRec + "%' or tiers.tiemsn like '" + this.mailRec + "%' or tiers.tieaol like '" + this.mailRec + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && this.mailRec.startsWith("*")) {
         var2 = this.mailRec.substring(1);
         var1 = var1 + " and (tiers.tiemail1 LIKE " + "'%" + var2 + "%' or tiers.tiemail2 like '%" + var2 + "%' or tiers.tiemail3 like '%" + var2 + "%' or tiers.tiemail4 like '%" + var2 + "%' or tiers.tiemail5 like '%" + var2 + "%' or tiers.tieyahoo like '%" + var2 + "%' or tiers.tiemsn like '%" + var2 + "%' or tiers.tieaol like '%" + var2 + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && !this.mailRec.contains("*")) {
         var1 = var1 + " or (conmail1 LIKE " + "'" + this.mailRec + "%' or conmail2 like '" + this.mailRec + "%' or conmail3 like '" + this.mailRec + "%' or conmail4 like '" + this.mailRec + "%' or conmail5 like '" + this.mailRec + "%' or conyahoo like '" + this.mailRec + "%' or conmsn like '" + this.mailRec + "%' or conaol like '" + this.mailRec + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && this.mailRec.startsWith("*")) {
         var2 = this.mailRec.substring(1);
         var1 = var1 + " or (conmail1 LIKE " + "'%" + var2 + "%' or conmail2 like '%" + var2 + "%' or conmail3 like '%" + var2 + "%' or conmail4 like '%" + var2 + "%' or conmail5 like '%" + var2 + "%' or conyahoo like '%" + var2 + "%' or conmsn like '%" + var2 + "%' or conaol like '%" + var2 + "%')";
      }

      if (this.categorieRec != null && !this.categorieRec.isEmpty() && !this.categorieRec.equals("100")) {
         var1 = var1 + " and  tiers.tiecategorie=" + "'" + this.categorieRec + "'";
      }

      if (this.familleRec != null && !this.familleRec.isEmpty() && !this.familleRec.equals("100")) {
         var1 = var1 + " and  tiers.tienomfamille=" + "'" + this.familleRec + "'";
      }

      String[] var3;
      if (this.pdvRec != null && !this.pdvRec.isEmpty() && !this.pdvRec.equals("100")) {
         if (this.pdvRec.contains(":")) {
            var3 = this.pdvRec.split(":");
            var1 = var1 + " and tiers.tiepdv=" + "'" + var3[0] + "'";
         } else {
            var1 = var1 + " and tiers.tiepdv=" + "'" + this.pdvRec + "'";
         }
      }

      if (this.regRec != null && !this.regRec.isEmpty() && !this.regRec.equals("100")) {
         if (this.regRec.contains(":")) {
            var3 = this.regRec.split(":");
            var1 = var1 + " and tiers.tieregion=" + "'" + var3[0] + "'";
         } else {
            var1 = var1 + " and tiers.tieregion=" + "'" + this.regRec + "'";
         }
      }

      if (this.appreciationRec != null && !this.appreciationRec.isEmpty() && !this.appreciationRec.equals("100")) {
         var1 = var1 + " and tiers.tienoteman=" + "'" + this.appreciationRec + "'";
      }

      if (this.activitesRec != null && !this.activitesRec.isEmpty() && !this.activitesRec.equals("100") && !this.activitesRec.equals("****")) {
         var1 = var1 + " and (tiers.tieactivite1=" + "'" + this.activitesRec + "' or tiers.tieactivite2=" + "'" + this.activitesRec + "' or tiers.tieprofession=" + "'" + this.activitesRec + "')";
      }

      if (this.activitesRec != null && !this.activitesRec.isEmpty() && this.activitesRec.equals("****")) {
         var1 = var1 + " and (tiers.tieactivite1 is null or tiers.tieactivite1='' or tiers.tieactivite2 is null or tiers.tieactivite2='' or tiers.tieprofession is null or tiers.tieprofession='')";
      }

      if (this.observationsRec != null && !this.observationsRec.isEmpty() && !this.observationsRec.equals("100")) {
         var1 = var1 + " and tiers.tieobservations=" + "'" + this.observationsRec + "'";
      }

      if (this.observationsDirectRec != null && !this.observationsDirectRec.isEmpty()) {
         var1 = var1 + " and tiers.tieobservations like " + "'%" + this.observationsDirectRec + "%'";
      }

      if (this.paysRec != null && !this.paysRec.isEmpty() && !this.paysRec.equals("100")) {
         var1 = var1 + " and tiers.tienompays=" + "'" + this.paysRec + "'";
      }

      if (this.centreInteretRec != null && !this.centreInteretRec.isEmpty() && !this.centreInteretRec.equals("100")) {
         var1 = var1 + " and tiers.tieinteret=" + "'" + this.centreInteretRec + "'";
      }

      if (this.origineRec != null && !this.origineRec.isEmpty() && !this.origineRec.equals("100")) {
         var1 = var1 + " and tiers.tieorigine=" + "'" + this.origineRec + "'";
      }

      if (this.sitMatRec != null && !this.sitMatRec.isEmpty() && !this.sitMatRec.equals("100")) {
         var1 = var1 + " and tiers.tiesitfam=" + "'" + this.sitMatRec + "'";
      }

      return var1;
   }

   public String rechercherContactConseiller() {
      String var1 = "from Responsable where (tiers.tietype=1 or tiers.tietype=2 or tiers.tietype=3)";
      var1 = var1 + " and rpbuserid=" + this.conseillersRec;
      if (this.compteLitige == 1) {
         var1 = var1 + " and tiers.tiesurveille=1";
      } else if (this.compteLitige == 2) {
         var1 = var1 + " and tiers.tiecomptebloque=1";
      } else if (this.compteLitige == 3) {
         var1 = var1 + " and tiers.tiechequeinterdit=1";
      } else if (this.compteLitige == 4) {
         var1 = var1 + " and tiers.tieconventiongele=true";
      }

      if (this.usersLog.getUsrTiers() == 1) {
         var1 = var1 + " and ((tiers.tievisibilite=0) or (tiers.tievisibilite=1 and tiers.tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tiers.tievisibilite=2 and tiers.tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      } else if (this.usersLog.getUsrTiers() == 2) {
         var1 = var1 + " and tiers.tieusercreat=" + this.usersLog.getUsrid() + " and ((tiers.tievisibilite=0) or (tiers.tievisibilite=1 and tiers.tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tiers.tievisibilite=2 and tiers.tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      } else if (this.usersLog.getUsrTiers() == 3) {
         var1 = var1 + " and ((tiers.tievisibilite=0) or (tiers.tievisibilite=1 and tiers.tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tiers.tievisibilite=2 and tiers.tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      }

      if (this.nomRec != null && !this.nomRec.isEmpty() && !this.nomRec.contains("*")) {
         var1 = var1 + " and (tiers.tieraisonsocialenom LIKE" + "'" + this.nomRec + "%' or tiers.tiesigle like '%" + this.nomRec + "%')";
      }

      String var2;
      if (this.nomRec != null && !this.nomRec.isEmpty() && this.nomRec.startsWith("*")) {
         var2 = this.nomRec.substring(1);
         var1 = var1 + " and (tiers.tieraisonsocialenom LIKE " + "'%" + var2 + "%' or tiers.tiesigle like '" + var2 + "%')";
      }

      if (this.prenomRec != null && !this.prenomRec.isEmpty()) {
         var1 = var1 + " and tiers.tieprenom LIKE" + "'" + this.prenomRec + "%'";
      }

      if (this.villeRec != null && !this.villeRec.isEmpty()) {
         var1 = var1 + " and tiers.tieville LIKE" + "'" + this.villeRec + "%'";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && !this.mailRec.contains("*")) {
         var1 = var1 + " and (tiers.tiemail1 LIKE " + "'" + this.mailRec + "%' or tiers.tiemail2 like '" + this.mailRec + "%' or tiers.tiemail3 like '" + this.mailRec + "%' or tiers.tiemail4 like '" + this.mailRec + "%' or tiers.tiemail5 like '" + this.mailRec + "%' or tiers.tieyahoo like '" + this.mailRec + "%' or tiers.tiemsn like '" + this.mailRec + "%' or tiers.tieaol like '" + this.mailRec + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && this.mailRec.startsWith("*")) {
         var2 = this.mailRec.substring(1);
         var1 = var1 + " and (tiers.tiemail1 LIKE " + "'%" + var2 + "%' or tiers.tiemail2 like '%" + var2 + "%' or tiers.tiemail3 like '%" + var2 + "%' or tiers.tiemail4 like '%" + var2 + "%' or tiers.tiemail5 like '%" + var2 + "%' or tiers.tieyahoo like '%" + var2 + "%' or tiers.tiemsn like '%" + var2 + "%' or tiers.tieaol like '%" + var2 + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && !this.mailRec.contains("*")) {
         var1 = var1 + " or (conmail1 LIKE " + "'" + this.mailRec + "%' or conmail2 like '" + this.mailRec + "%' or conmail3 like '" + this.mailRec + "%' or conmail4 like '" + this.mailRec + "%' or conmail5 like '" + this.mailRec + "%' or conyahoo like '" + this.mailRec + "%' or conmsn like '" + this.mailRec + "%' or conaol like '" + this.mailRec + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && this.mailRec.startsWith("*")) {
         var2 = this.mailRec.substring(1);
         var1 = var1 + " or (conmail1 LIKE " + "'%" + var2 + "%' or conmail2 like '%" + var2 + "%' or conmail3 like '%" + var2 + "%' or conmail4 like '%" + var2 + "%' or conmail5 like '%" + var2 + "%' or conyahoo like '%" + var2 + "%' or conmsn like '%" + var2 + "%' or conaol like '%" + var2 + "%')";
      }

      if (this.categorieRec != null && !this.categorieRec.isEmpty() && !this.categorieRec.equals("100")) {
         var1 = var1 + " and  tiers.tiecategorie=" + "'" + this.categorieRec + "'";
      }

      if (this.familleRec != null && !this.familleRec.isEmpty() && !this.familleRec.equals("100")) {
         var1 = var1 + " and  tiers.tienomfamille=" + "'" + this.familleRec + "'";
      }

      String[] var3;
      if (this.pdvRec != null && !this.pdvRec.isEmpty() && !this.pdvRec.equals("100")) {
         if (this.pdvRec.contains(":")) {
            var3 = this.pdvRec.split(":");
            var1 = var1 + " and tiers.tiepdv=" + "'" + var3[0] + "'";
         } else {
            var1 = var1 + " and tiers.tiepdv=" + "'" + this.pdvRec + "'";
         }
      }

      if (this.regRec != null && !this.regRec.isEmpty() && !this.regRec.equals("100")) {
         if (this.regRec.contains(":")) {
            var3 = this.regRec.split(":");
            var1 = var1 + " and tiers.tieregion=" + "'" + var3[0] + "'";
         } else {
            var1 = var1 + " and tiers.tieregion=" + "'" + this.regRec + "'";
         }
      }

      if (this.appreciationRec != null && !this.appreciationRec.isEmpty() && !this.appreciationRec.equals("100")) {
         var1 = var1 + " and tiers.tienoteman=" + "'" + this.appreciationRec + "'";
      }

      if (this.activitesRec != null && !this.activitesRec.isEmpty() && !this.activitesRec.equals("100") && !this.activitesRec.equals("****")) {
         var1 = var1 + " and (tiers.tieactivite1=" + "'" + this.activitesRec + "' or tiers.tieactivite2=" + "'" + this.activitesRec + "' or tiers.tieprofession=" + "'" + this.activitesRec + "')";
      }

      if (this.activitesRec != null && !this.activitesRec.isEmpty() && this.activitesRec.equals("****")) {
         var1 = var1 + " and (tiers.tieactivite1 is null or tiers.tieactivite1='' or tiers.tieactivite2 is null or tiers.tieactivite2='' or tiers.tieprofession is null or tiers.tieprofession='')";
      }

      if (this.observationsRec != null && !this.observationsRec.isEmpty() && !this.observationsRec.equals("100")) {
         var1 = var1 + " and tiers.tieobservations=" + "'" + this.observationsRec + "'";
      }

      if (this.observationsDirectRec != null && !this.observationsDirectRec.isEmpty()) {
         var1 = var1 + " and tiers.tieobservations like " + "'%" + this.observationsDirectRec + "%'";
      }

      if (this.paysRec != null && !this.paysRec.isEmpty() && !this.paysRec.equals("100")) {
         var1 = var1 + " and tiers.tienompays=" + "'" + this.paysRec + "'";
      }

      if (this.centreInteretRec != null && !this.centreInteretRec.isEmpty() && !this.centreInteretRec.equals("100")) {
         var1 = var1 + " and tiers.tieinteret=" + "'" + this.centreInteretRec + "'";
      }

      if (this.origineRec != null && !this.origineRec.isEmpty() && !this.origineRec.equals("100")) {
         var1 = var1 + " and tiers.tieorigine=" + "'" + this.origineRec + "'";
      }

      if (this.sitMatRec != null && !this.sitMatRec.isEmpty() && !this.sitMatRec.equals("100")) {
         var1 = var1 + " and tiers.tiesitfam=" + "'" + this.sitMatRec + "'";
      }

      return var1;
   }

   public String rechercherTiers() {
      String var1 = "";
      if (this.ligneMenu.getGenre().equals("XXX")) {
         var1 = "from Tiers where (tietype=1 or tietype=2 or tietype=3)";
      } else if (this.ligneMenu.getGenre().equals("YYY")) {
         var1 = "from Tiers where (tietype=0 or tietype=1 or tietype=2 or tietype=3)";
      } else {
         var1 = "from Tiers where tietype='" + this.ligneMenu.getType() + "' and tiegenre='" + this.ligneMenu.getGenre() + "'";
      }

      var1 = var1 + "and tieetat=" + this.inpInactif;

      if (this.compteLitige == 1) {
         var1 = var1 + " and tiesurveille=1";
      } else if (this.compteLitige == 2) {
         var1 = var1 + " and tiecomptebloque=1";
      } else if (this.compteLitige == 3) {
         var1 = var1 + " and tiechequeinterdit=1";
      } else if (this.compteLitige == 4) {
         var1 = var1 + " and tieconventiongele=true";
      }

      if (this.usersLog.getUsrTiers() == 1) {
         var1 = var1 + " and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      } else if (this.usersLog.getUsrTiers() == 2) {
         var1 = var1 + " and tieusercreat=" + this.usersLog.getUsrid() + " and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      } else if (this.usersLog.getUsrTiers() == 3) {
         var1 = var1 + " and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + this.usersLog.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + this.usersLog.getUsrid() + "))";
      }

      String var2;
      if (this.nomRec != null && !this.nomRec.isEmpty() && !this.nomRec.endsWith("*")) {
         var2 = this.nomRec.replace("*", "");
         var1 = var1 + " and (tieraisonsocialenom LIKE" + "'" + this.nomRec + "%' or tiesigle like '%" + var2 + "%')";
      }

      if (this.nomRec != null && !this.nomRec.isEmpty() && this.nomRec.startsWith("*")) {
         var2 = this.nomRec.substring(1);
         var1 = var1 + " and (tieraisonsocialenom LIKE " + "'" + var2 + "%' or tiesigle like '" + var2 + "%')";
      }

      if (this.prenomRec != null && !this.prenomRec.isEmpty()) {
         var1 = var1 + " and tieprenom LIKE" + "'" + this.prenomRec + "%'";
      }

      if (this.villeRec != null && !this.villeRec.isEmpty()) {
         var1 = var1 + " and tieville LIKE" + "'" + this.villeRec + "%'";
      }

      if (this.categorieRec != null && !this.categorieRec.isEmpty() && !this.categorieRec.equals("100")) {
         var1 = var1 + " and  tiecategorie=" + "'" + this.categorieRec + "'";
      }

      if (this.familleRec != null && !this.familleRec.isEmpty() && !this.familleRec.equals("100")) {
         var1 = var1 + " and  tienomfamille=" + "'" + this.familleRec + "'";
      }

      String[] var3;
      if (this.pdvRec != null && !this.pdvRec.isEmpty() && !this.pdvRec.equals("100")) {
         if (this.pdvRec.contains(":")) {
            var3 = this.pdvRec.split(":");
            var1 = var1 + " and tiepdv=" + "'" + var3[0] + "'";
         } else {
            var1 = var1 + " and tiepdv=" + "'" + this.pdvRec + "'";
         }
      }

      if (this.regRec != null && !this.regRec.isEmpty() && !this.regRec.equals("100")) {
         if (this.regRec.contains(":")) {
            var3 = this.regRec.split(":");
            var1 = var1 + " and tieregion=" + "'" + var3[0] + "'";
         } else {
            var1 = var1 + " and tieregion=" + "'" + this.regRec + "'";
         }
      }

      if (this.appreciationRec != null && !this.appreciationRec.isEmpty() && !this.appreciationRec.equals("100")) {
         var1 = var1 + " and tienoteman=" + "'" + this.appreciationRec + "'";
      }

      if (this.activitesRec != null && !this.activitesRec.isEmpty() && !this.activitesRec.equals("100") && !this.activitesRec.equals("****")) {
         var1 = var1 + " and (tieactivite1=" + "'" + this.activitesRec + "' or tieactivite2=" + "'" + this.activitesRec + "' or tieprofession=" + "'" + this.activitesRec + "')";
      }

      if (this.activitesRec != null && !this.activitesRec.isEmpty() && this.activitesRec.equals("****")) {
         var1 = var1 + " and (tieactivite1 is null or tieactivite1='' or tieactivite2 is null or tieactivite2='' or tieprofession is null or tieprofession='')";
      }

      if (this.observationsRec != null && !this.observationsRec.isEmpty() && !this.observationsRec.equals("100")) {
         var1 = var1 + " and tieobservations=" + "'" + this.observationsRec + "'";
      }

      if (this.observationsDirectRec != null && !this.observationsDirectRec.isEmpty()) {
         var1 = var1 + " and tieobservations like " + "'%" + this.observationsDirectRec + "%'";
      }

      if (this.paysRec != null && !this.paysRec.isEmpty() && !this.paysRec.equals("100")) {
         var1 = var1 + " and tienompays=" + "'" + this.paysRec + "'";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty()) {
         var1 = var1 + " and (tiemail1='" + this.mailRec + "' or tiemail2='" + this.mailRec + "' or tiemail3='" + this.mailRec + "' or tiemail4='" + this.mailRec + "' or tieyahoo='" + this.mailRec + "' or tieaol='" + this.mailRec + "' or tiemsn='" + this.mailRec + "')";
      }

      if (this.telRec != null && !this.telRec.isEmpty()) {
         var1 = var1 + " and (tieteldom like" + "'" + this.telRec + "%' or tiecel1 like '" + this.telRec + "%' or tiecel2 like '" + this.telRec + "%' or tiecel3 like '" + this.telRec + "%' or tietelvoiture like '" + this.telRec + "%' or tieburtel1 like '" + this.telRec + "%' or tieburtel2 like '" + this.telRec + "%' or tieburtel3 like '" + this.telRec + "%')";
      }

      if (this.obsRec != null && !this.obsRec.isEmpty()) {
         var1 = var1 + " and tieobservations like" + "'%" + this.obsRec + "%'";
      }

      if (this.centreInteretRec != null && !this.centreInteretRec.isEmpty() && !this.centreInteretRec.equals("100")) {
         var1 = var1 + " and tieinteret=" + "'" + this.centreInteretRec + "'";
      }

      if (this.origineRec != null && !this.origineRec.isEmpty() && !this.origineRec.equals("100")) {
         var1 = var1 + " and tieorigine=" + "'" + this.origineRec + "'";
      }

      if (this.sitMatRec != null && !this.sitMatRec.isEmpty() && !this.sitMatRec.equals("100")) {
         var1 = var1 + " and tiesitfam=" + "'" + this.sitMatRec + "'";
      }

      return var1;
   }

   public void selectionTiers() throws JDOMException, IOException, NamingException, ParseException {
      this.newtiers = new Tiers();
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
            this.newtiers = (Tiers)var1.get(0);
            this.calculTiersdivers();
            this.devise = this.newtiers.getTiedevise();
            this.calculeImmatriculation();
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
            this.chargeResponsable(var6);
            this.chargerContact(var6);
            this.chargerJournaux(var6);
            this.chargerCalculFrais(var6);
            this.chargerRemises(var6);
            this.chargerCampagnes(var6);
            this.chargerCadeaux(var6);
            this.chargerDocumentScan();
            this.chargerProduitExo();
            if (this.newtiers.getTietype() != null && !this.newtiers.getTietype().isEmpty() && this.newtiers.getTietype().equals("2") && this.newtiers.getTieusercreat() != 0L) {
               new Users();
               if (this.userDao == null) {
                  this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
               }

               Users var4 = this.userDao.selectUserD(this.newtiers.getTieusercreat(), var6);
               if (var4 != null) {
                  this.nomCreateur = var4.getUsrPatronyme();
               } else {
                  this.nomCreateur = "";
               }
            } else {
               this.nomCreateur = "";
            }

            this.codeBanque = "";
            this.codeAgence = "";
            this.numCompte = "";
            this.numCleCtrl = "";
            if (this.newtiers.getTiepdv() != null && !this.newtiers.getTiepdv().isEmpty()) {
               new PointDeVente();
               PointDeVenteDao var9 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
               PointDeVente var8 = var9.recherchePdv(this.newtiers.getTiepdv(), var6);
               if (var8 != null) {
                  this.codeAgence = var8.getPdvCode() + ":" + var8.getPdvNomFr();
               }
            } else if (this.newtiers.getTieregion() != null && !this.newtiers.getTieregion().isEmpty()) {
               new Region();
               RegionDao var5 = new RegionDao(this.baseLog, this.utilInitHibernate);
               Region var7 = var5.rechercheRegion(this.newtiers.getTieregion(), var6);
               if (var7 != null) {
                  this.codeAgence = var7.getRegCode() + ":" + var7.getRegNomFr();
               }
            }

            this.affiche_convention = false;
            this.affiche_adhesion = false;
            this.modifAgence = false;
            if (this.immobExist) {
               if (this.newtiers.getTietype() != null && !this.newtiers.getTietype().isEmpty()) {
                  if (this.newtiers.getTietype().equals("0")) {
                     this.chargerBiens(var6);
                     this.chargerGerances(var6);
                     this.chargerContrats(var6);
                  } else {
                     this.chargerBaux(var6);
                  }
               }
            } else if (this.medicalExist) {
               if (this.newtiers.getTiecategorie() != null && !this.newtiers.getTiecategorie().isEmpty()) {
                  if (this.newtiers.getTiecategorie().equalsIgnoreCase("Assurance") || this.newtiers.getTiecategorie().equalsIgnoreCase("IPM") || this.newtiers.getTiecategorie().equalsIgnoreCase("Mutuelle") || this.newtiers.getTiecategorie().equalsIgnoreCase("Mutuelle/Assurance") || this.newtiers.getTiecategorie().equalsIgnoreCase("Complémentaire") || this.newtiers.getTiecategorie().equalsIgnoreCase("Programme Médical") || this.newtiers.getTiecategorie().equalsIgnoreCase("Client société") || this.newtiers.getTiecategorie().equalsIgnoreCase("Ministère") || this.newtiers.getTiecategorie().equalsIgnoreCase("Mairie") || this.newtiers.getTiecategorie().equalsIgnoreCase("Direction") || this.newtiers.getTiecategorie().equalsIgnoreCase("Hôpital")) {
                     this.affiche_convention = true;
                  }

                  if (this.newtiers.getTiecategorie().equalsIgnoreCase("Assurance") || this.newtiers.getTiecategorie().equalsIgnoreCase("IPM")) {
                     this.affiche_adhesion = true;
                  }
               }
            } else if (this.interimExist) {
               if (this.newtiers.getTietype() != null && !this.newtiers.getTietype().isEmpty() && this.newtiers.getTietype().equals("3")) {
                  this.chargerServices(var6);
               }
            } else if (this.mefExist) {
               this.codeBanque = this.structureLog.getStrnum10();
               if (this.newtiers.getTiesigle() != null && !this.newtiers.getTiesigle().isEmpty() && this.newtiers.getTiesigle().length() == 26) {
                  this.numCompte = this.newtiers.getTiesigle().substring(12, 23);
                  this.numCleCtrl = this.newtiers.getTiesigle().substring(24, 26);
                  this.modifAgence = true;
               }
            }

            this.lesEcritures.clear();
            this.lesDocumentsEntete.clear();
            this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
            this.lesDocumentsDetail.clear();
            this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
            this.etatEcr = 1;
            this.cpteTiers = 0;
            this.utilInitHibernate.closeSession();
            this.afficheButtOption = true;
            this.visibiliteContrat = false;
         } else {
            this.afficheButtOption = false;
            this.visibiliteContrat = false;
         }
      } else {
         this.afficheButtOption = false;
         this.visibiliteContrat = false;
      }

   }

   public void visualisationTiers() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.newtiers != null) {
         this.consulterTiers();
      }

   }

   public void chargeResponsable(Session var1) throws HibernateException, NamingException {
      this.lesResponsableListe.clear();
      this.lesResponsableListe = this.responsableDao.chargerLesResponsables(this.newtiers, var1);
      this.datamodelResponsable.setWrappedData(this.lesResponsableListe);
   }

   public void chargerContact(Session var1) throws HibernateException, NamingException {
      this.lesContactsListe.clear();
      this.lesProcurationsListe.clear();
      this.lesTestamentsListe.clear();
      new ArrayList();
      List var2 = this.contactDao.listContactByTiers(this.newtiers, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((Contacts)var2.get(var3)).getConType() == 1) {
               this.lesProcurationsListe.add(var2.get(var3));
            } else if (((Contacts)var2.get(var3)).getConType() == 2) {
               this.lesTestamentsListe.add(var2.get(var3));
            } else {
               this.lesContactsListe.add(var2.get(var3));
            }
         }
      }

      this.datamodelContact.setWrappedData(this.lesContactsListe);
      this.datamodelProcuration.setWrappedData(this.lesProcurationsListe);
      this.datamodelTestament.setWrappedData(this.lesTestamentsListe);
   }

   public void chargerJournaux(Session var1) throws NamingException {
      if (this.newtiers != null) {
         this.mesJournauxComptables.clear();
         if (this.newtiers.getTietype().equals("0") && this.newtiers.getTiecategorie().equalsIgnoreCase("Banque")) {
            new ExercicesComptable();
            ExercicesComptableDao var3 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
            ExercicesComptable var2 = var3.recupererLastExo(var1);
            if (var2 != null) {
               JournauxComptablesDao var4 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
               this.mesJournauxComptables = var4.chargerLesJournaux(var2, var1);
            }
         }
      }

   }

   public void chargerCalculFrais(Session var1) throws HibernateException, NamingException {
      Object var2 = new ArrayList();
      if (this.newtiers.getTietype().equals("0") && this.newtiers.getTiecategorie() != null && !this.newtiers.getTiecategorie().isEmpty() && (this.newtiers.getTiecategorie().equals("Transitaire") || this.newtiers.getTiecategorie().equals("Transporteur"))) {
         if (this.fraisTheoAchatsDao == null) {
            this.fraisTheoAchatsDao = new FraisTheoAchatsDao(this.baseLog, this.utilInitHibernate);
         }

         var2 = this.fraisTheoAchatsDao.chargerFraisLignes(this.newtiers.getTieid(), "", 99, var1);
      }

      this.dataModelConditionCalcul.setWrappedData(var2);
   }

   public void chargerRemises(Session var1) throws HibernateException, NamingException {
      this.lesBaremes.clear();
      this.lesBaremes = this.baremesDao.listBaremesByTiers(this.newtiers.getTieid(), var1);
      new ArrayList();
      List var2 = this.baremesDao.listBaremesByCategorie(this.newtiers.getTienomfamille(), var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.lesBaremes.add(var2.get(var3));
         }
      }

      this.dataModelBaremes.setWrappedData(this.lesBaremes);
   }

   public void chargerCampagnes(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.campagneParticipantVentesDao.rechercheCampagneTiers(this.newtiers.getTieid(), var1);
      this.dataModelParticipants.setWrappedData(var2);
   }

   public void chargerCadeaux(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.cadeauxDao.rechercheByTiers(this.newtiers.getTieid(), var1);
      this.dataModelCadeaux.setWrappedData(var2);
   }

   public void chargerBaux(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      BienBailDao var3 = new BienBailDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerBauxByLocataire(this.newtiers, var1);
      this.dataModelBaux.setWrappedData(var2);
   }

   public void chargerBiens(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      BienDao var3 = new BienDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargeBienByTiers(9, this.newtiers, var1);
      this.dataModelBiens.setWrappedData(var2);
   }

   public void chargerGerances(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      BienGeranceEnteteDao var3 = new BienGeranceEnteteDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerGeranceByTiers(this.newtiers, var1);
      this.dataModelGerances.setWrappedData(var2);
   }

   public void chargerContrats(Session var1) throws HibernateException, NamingException {
      this.lesContratsVentes = this.contratEnteteVentesDao.rechercheByTiers(this.newtiers, var1);
      this.dataModelConvention.setWrappedData(this.lesContratsVentes);
   }

   public void chargerServices(Session var1) throws HibernateException, NamingException {
      this.lesSerivicesInterim.clear();
      this.lesSerivicesInterim = this.siteDao.chargerLesSitesListByClient(this.newtiers.getTieid(), var1);
      this.dataModelServiceInterim.setWrappedData(this.lesSerivicesInterim);
      this.afficheServiceInterim = false;
   }

   public void chargerDocumentScan() throws IOException {
      this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanMF" + File.separator;
      this.lesDocuments.clear();
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         File var1 = new File(this.nomRepertoire);
         if (!var1.exists()) {
            var1.mkdir();
         }

         String var2 = "" + this.newtiers.getTieid();
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

   public void chargerProduitExo() {
      if (this.newtiers != null) {
         this.lesProdExo.clear();
         if (this.newtiers.getTiepProdExoTva() != null && !this.newtiers.getTiepProdExoTva().isEmpty()) {
            new ObjetProdExoTva();
            ObjetProdExoTva var1;
            String[] var2;
            if (this.newtiers.getTiepProdExoTva().contains("#")) {
               var2 = this.newtiers.getTiepProdExoTva().split("#");

               for(int var3 = 0; var3 < var2.length; ++var3) {
                  String[] var4 = var2[var3].split(":");
                  var1 = new ObjetProdExoTva();
                  var1.setCode(var4[0]);
                  var1.setLibelle(var4[1]);
                  var1.setExoTva(true);
                  this.lesProdExo.add(var1);
               }
            } else if (this.newtiers.getTiepProdExoTva().contains(":")) {
               var2 = this.newtiers.getTiepProdExoTva().split(":");
               var1 = new ObjetProdExoTva();
               var1.setCode(var2[0]);
               var1.setLibelle(var2[1]);
               var1.setExoTva(true);
               this.lesProdExo.add(var1);
            }
         }

         this.dataModelProdExoTva.setWrappedData(this.lesProdExo);
      }

   }

   public void ajouterTiers() {
      this.newtiers = new Tiers();
      this.codeBanque = this.structureLog.getStrnum10();
      this.codeAgence = "";
      this.numCompte = "";
      this.numCleCtrl = "";
      this.newtiers.setTiedatenaissance((Date)null);
      this.newtiers.setTienompays(this.structureLog.getStrnompays());
      this.newtiers.setTiecodepays(this.structureLog.getStrcodepays());
      this.newtiers.setTiedevise(this.structureLog.getStrdevise());
      this.newtiers.setTieFormatDevise(this.structureLog.getStrformatdevise());
      this.devise = this.newtiers.getTiedevise();
      this.newtiers.setTienomfamille("100");
      this.newtiers.setTiemodereg("100");
      this.lesContactsListe.clear();
      this.datamodelContact.setWrappedData(this.lesContactsListe);
      this.lesConventionMedicale.clear();
      this.dataModelConvention.setWrappedData(this.lesConventionMedicale);
      this.lesResponsableListe.clear();
      this.datamodelResponsable.setWrappedData(this.lesResponsableListe);
      this.lesBaremes.clear();
      this.dataModelBaremes.setWrappedData(this.lesBaremes);
      this.lesEcritures.clear();
      this.lesDocumentsDetail.clear();
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
      this.lesDocumentsEntete.clear();
      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelParticipantsContact = new ListDataModel();
      this.dataModelCadeaux = new ListDataModel();
      this.etatEcr = 1;
      this.cpteTiers = 0;
      this.lesPlanning.clear();
      this.var_tiersDivers = false;
      this.var_action = 1;
      if (this.ligneMenu.getType() != null && !this.ligneMenu.getType().isEmpty() && this.ligneMenu.getType().equals("2")) {
         this.valideFiche = false;
      } else {
         this.valideFiche = true;
      }

      this.var_memo_action = this.var_action;
   }

   public void modifierTiers() {
      if (this.newtiers != null) {
         this.var_action = 2;
         this.controleSaisie();
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterTiers() {
      if (this.newtiers != null) {
         this.var_action = 3;
         this.valideFiche = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void controleSaisie() {
      if (this.ligneMenu.getType() != null && !this.ligneMenu.getType().isEmpty() && this.ligneMenu.getType().equals("2")) {
         if (this.newtiers.getTieraisonsocialenom() == null || this.newtiers.getTieraisonsocialenom().isEmpty() || this.newtiers.getTiesource() == null || this.newtiers.getTiesource().isEmpty() || this.newtiers.getTieinteret() == null || this.newtiers.getTieinteret().isEmpty() || (this.newtiers.getTieburtel1() == null || this.newtiers.getTieburtel1().isEmpty()) && (this.newtiers.getTieburtel3() == null || this.newtiers.getTieburtel3().isEmpty()) && (this.newtiers.getTiemail1() == null || this.newtiers.getTiemail1().isEmpty())) {
            this.valideFiche = false;
         } else {
            this.valideFiche = true;
         }
      } else {
         this.valideFiche = true;
      }

   }

   public void annuleSaisie() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.afficheButtOption = false;
   }

   public void supprimerTiers() throws HibernateException, NamingException {
      if (this.newtiers != null) {
         String var1 = "";
         var1 = this.verificationSuppression();
         if (var1 != null && !var1.isEmpty()) {
            this.suppressionRejet = var1;
            this.showModalSupTiers = true;
         } else {
            Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
            Transaction var3 = null;

            try {
               var3 = var2.beginTransaction();
               int var4;
               if (this.lesContactsListe.size() != 0) {
                  for(var4 = 0; var4 < this.lesContactsListe.size(); ++var4) {
                     this.contacts = (Contacts)this.lesContactsListe.get(var4);
                     this.contactDao.delete(this.contacts, var2);
                  }
               }

               if (this.lesResponsableListe.size() != 0) {
                  for(var4 = 0; var4 < this.lesResponsableListe.size(); ++var4) {
                     this.responsable = (Responsable)this.lesResponsableListe.get(var4);
                     this.responsableDao.delete(this.responsable, var2);
                  }
               }

               if (this.lesBaremes.size() != 0) {
                  for(var4 = 0; var4 < this.lesBaremes.size(); ++var4) {
                     this.baremes = (Baremes)this.lesBaremes.get(var4);
                     this.baremesDao.delete(this.baremes, var2);
                  }
               }

               if (this.newtiers.getTiePhoto() != null) {
                  String var13 = "";
                  int var5 = this.newtiers.getTiePhoto().lastIndexOf(46);
                  if (0 < var5 && var5 <= this.newtiers.getTiePhoto().length() - 2) {
                     var13 = "." + this.newtiers.getTiePhoto().substring(var5 + 1);
                  }

                  String var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers") + File.separator + "T" + this.newtiers.getTieid() + var13;
                  File var7 = new File(var6);
                  if (var7.exists()) {
                     var7.delete();
                  }
               }

               this.tiersDao.delete(this.newtiers, var2);
               this.lesTiers.remove(this.newtiers);
               this.dataModelSociete.setWrappedData(this.lesTiers);
               this.lesContactsListe.clear();
               this.lesResponsableListe.clear();
               var3.commit();
            } catch (HibernateException var11) {
               if (var3 != null) {
                  var3.rollback();
               }

               throw var11;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.afficheButtOption = false;
            this.visibiliteBton = false;
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelectionEntete.clear();
         }
      }

   }

   public String verificationSuppression() throws HibernateException, NamingException {
      boolean var1 = false;
      String var2 = "";
      Session var3;
      if (this.newtiers.getTietype().equals("0")) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
         CotationEnteteAchatsDao var4 = new CotationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         var1 = var4.verifTiers(this.newtiers, var3);
         if (!var1) {
            CommandeEnteteAchatsDao var5 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
            var1 = var5.verifTiers(this.newtiers, var3);
            if (!var1) {
               ReceptionEnteteAchatsDao var6 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               var1 = var6.verifTiers(this.newtiers, var3);
               if (!var1) {
                  RetourEnteteAchatsDao var7 = new RetourEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                  var1 = var7.verifTiers(this.newtiers, var3);
                  if (!var1) {
                     FactureEnteteAchatsDao var8 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                     var1 = var8.verifTiers(this.newtiers, var3);
                     if (!var1) {
                        FraisEnteteAchatsDao var9 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                        var1 = var9.verifTiers(this.newtiers, var3);
                        if (!var1) {
                           NoteDebitEnteteAchatsDao var10 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                           var1 = var10.verifTiers(this.newtiers, var3);
                           if (!var1) {
                              AvoirEnteteAchatsDao var11 = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                              var1 = var11.verifTiers(this.newtiers, var3);
                              if (!var1) {
                                 ProduitsFournisseurDao var12 = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
                                 var1 = var12.verifTiers(this.newtiers, var3);
                                 if (!var1) {
                                    BienDao var13 = new BienDao(this.baseLog, this.utilInitHibernate);
                                    var1 = var13.verifTiers(this.newtiers, var3);
                                    if (!var1) {
                                       BienGeranceEnteteDao var14 = new BienGeranceEnteteDao(this.baseLog, this.utilInitHibernate);
                                       var1 = var14.verifTiers(this.newtiers, var3);
                                       if (var1) {
                                          var2 = "Il y a des gérances... La suppression est impossible.";
                                       }
                                    } else {
                                       var2 = "Il y a des biens... La suppression est impossible.";
                                    }
                                 } else {
                                    var2 = "Il y a des produits fournisseurs... La suppression est impossible.";
                                 }
                              } else {
                                 var2 = "Il y a des avoirs... La suppression est impossible.";
                              }
                           } else {
                              var2 = "Il y a des notes de débit... La suppression est impossible.";
                           }
                        } else {
                           var2 = "Il y a des frais... La suppression est impossible.";
                        }
                     } else {
                        var2 = "Il y a des factures... La suppression est impossible.";
                     }
                  } else {
                     var2 = "Il y a des retours... La suppression est impossible.";
                  }
               } else {
                  var2 = "Il y a des réceptions... La suppression est impossible.";
               }
            } else {
               var2 = "Il y a des commandes... La suppression est impossible.";
            }
         } else {
            var2 = "Il y a des cotations... La suppression est impossible.";
         }
      } else {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         DevisEnteteVentesDao var15 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var1 = var15.verifTiers(this.newtiers, var3);
         if (!var1) {
            CommandeEnteteVentesDao var16 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            var1 = var16.verifTiers(this.newtiers, var3);
            if (!var1) {
               LivraisonEnteteVentesDao var17 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               var1 = var17.verifTiers(this.newtiers, var3);
               if (!var1) {
                  RetourEnteteVentesDao var18 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  var1 = var18.verifTiers(this.newtiers, var3);
                  if (!var1) {
                     FactureEnteteVentesDao var19 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                     var1 = var19.verifTiers(this.newtiers, var3);
                     if (!var1) {
                        var1 = this.contratEnteteVentesDao.verifTiers(this.newtiers, var3);
                        if (!var1) {
                           NoteDebitEnteteVentesDao var20 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                           var1 = var20.verifTiers(this.newtiers, var3);
                           if (!var1) {
                              AvoirEnteteVentesDao var21 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                              var1 = var21.verifTiers(this.newtiers, var3);
                              if (!var1) {
                                 TicketEnteteVentesDao var22 = new TicketEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                                 var1 = var22.verifTiers(this.newtiers, var3);
                                 if (!var1) {
                                    BienBailDao var23 = new BienBailDao(this.baseLog, this.utilInitHibernate);
                                    var1 = var23.verifTiers(this.newtiers, var3);
                                    if (!var1) {
                                       BienFactureDao var24 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
                                       var1 = var24.verifTiers(this.newtiers, var3);
                                       if (var1) {
                                          var2 = "Il y a des factures de location... La suppression est impossible.";
                                       }
                                    } else {
                                       var2 = "Il y a des baux... La suppression est impossible.";
                                    }
                                 } else {
                                    var2 = "Il y a des tickets... La suppression est impossible.";
                                 }
                              } else {
                                 var2 = "Il y a des avoirs... La suppression est impossible.";
                              }
                           } else {
                              var2 = "Il y a des notes de débit... La suppression est impossible.";
                           }
                        } else {
                           var2 = "Il y a des contrats... La suppression est impossible.";
                        }
                     } else {
                        var2 = "Il y a des retours... La suppression est impossible.";
                     }
                  } else {
                     var2 = "Il y a des retours... La suppression est impossible.";
                  }
               } else {
                  var2 = "Il y a des livraisons... La suppression est impossible.";
               }
            } else {
               var2 = "Il y a des commandes... La suppression est impossible.";
            }
         } else {
            var2 = "Il y a des devis... La suppression est impossible.";
         }
      }

      this.utilInitHibernate.closeSession();
      return var2;
   }

   public void fermerSupTiers() {
      this.showModalSupTiers = false;
   }

   public void majTiers() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      this.newtiers.setTieraisonsocialenom(this.newtiers.getTieraisonsocialenom().toUpperCase());
      if (!this.ligneMenu.getGenre().equals("XXX")) {
         this.newtiers.setTietype(this.ligneMenu.getType());
         this.newtiers.setTiegenre(this.ligneMenu.getGenre());
      }

      if (this.newtiers.getTiecategorie() != null && !this.newtiers.getTiecategorie().isEmpty() && !this.newtiers.getTiecategorie().equals("Client Interne")) {
         this.newtiers.setTiefacpr(0);
      }

      String var1 = "";
      if (this.newtiers.getTiedatenaissance() != null) {
         DateFormat var2 = DateFormat.getDateInstance(3);
         var1 = var2.format(this.newtiers.getTiedatenaissance()).substring(0, 5);
      }

      this.newtiers.setTieanniversaire(var1);
      String var15 = "";
      if (this.newtiers.getTiedatemariage() != null) {
         DateFormat var3 = DateFormat.getDateInstance(3);
         var15 = var3.format(this.newtiers.getTiedatemariage()).substring(0, 5);
      }

      this.newtiers.setTieanniversairemariage(var15);
      String var16 = "";
      if (this.newtiers.getTiedatedeces() != null) {
         DateFormat var4 = DateFormat.getDateInstance(3);
         var16 = var4.format(this.newtiers.getTiedatedeces()).substring(0, 5);
      }

      this.newtiers.setTieanniversairedeces(var16);
      this.selectionPays();
      this.validerProduitExo();
      this.newtiers.setTiedevise("");
      this.newtiers.setTieFormatDevise(0);
      this.newtiers.setTiedevise(this.devise);
      if (this.devise == null || this.devise.isEmpty()) {
         this.devise = this.structureLog.getStrdevise();
      }

      if (!this.devise.equalsIgnoreCase("XOF") && !this.devise.equalsIgnoreCase("XAF")) {
         if (!this.devise.equalsIgnoreCase("EUR") && !this.devise.equalsIgnoreCase("CHF")) {
            this.newtiers.setTieFormatDevise(0);
         } else {
            this.newtiers.setTieFormatDevise(2);
         }
      } else {
         this.newtiers.setTieFormatDevise(1);
      }

      this.newtiers.setTiepdv("");
      this.newtiers.setTiesecteur("");
      this.newtiers.setTieregion("");
      PointDeVente var5;
      if (this.codeAgence != null && !this.codeAgence.isEmpty() && this.codeAgence.contains(":")) {
         String[] var17 = this.codeAgence.split(":");
         if (this.abnExist) {
            this.newtiers.setTieregion(var17[0]);
            this.newtiers.setTiesecteur((String)null);
            this.newtiers.setTiepdv((String)null);
         } else {
            this.newtiers.setTiepdv(var17[0]);
            new PointDeVente();
            PointDeVenteDao var6 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
            var5 = var6.recherchePdv(this.newtiers.getTiepdv(), (Session)null);
            if (var5 != null) {
               this.newtiers.setTiesecteur(var5.getSecteur().getSecCode());
               new Secteur();
               SecteurDao var8 = new SecteurDao(this.baseLog, this.utilInitHibernate);
               Secteur var7 = var8.rechercheSecteur(this.newtiers.getTiesecteur(), (Session)null);
               if (var7 != null) {
                  this.newtiers.setTieregion(var7.getRegion().getRegCode());
               }
            }
         }
      }

      if (this.newtiers.getTienomfamille() != null && !this.newtiers.getTienomfamille().isEmpty() && this.newtiers.getTienomfamille().equalsIgnoreCase("100")) {
         this.newtiers.setTienomfamille("");
         this.newtiers.setTieexotva(0);
         this.newtiers.setTieexodouane(0);
      }

      if (this.newtiers.getTiemodereg() != null && !this.newtiers.getTiemodereg().isEmpty() && this.newtiers.getTiemodereg().equalsIgnoreCase("100")) {
         this.newtiers.setTienbecheance(0);
         this.newtiers.setTienbarrondi(0);
         this.newtiers.setTiejournalreg("");
         this.newtiers.setTieconditionreg("");
      }

      if (this.newtiers.getTietype() != null && !this.newtiers.getTietype().isEmpty() && this.newtiers.getTietype().equalsIgnoreCase("9")) {
         this.newtiers.setTievisibilite(2);
      }

      if (this.newtiers.getTievisibilite() == 0) {
         this.newtiers.setTievisibiliteGrp("");
         this.newtiers.setTievisibiliteUser(0L);
      } else if (this.newtiers.getTievisibilite() == 1) {
         this.newtiers.setTievisibiliteGrp(this.usersLog.getUsrCollaboration());
         this.newtiers.setTievisibiliteUser(0L);
      } else if (this.newtiers.getTievisibilite() == 2) {
         this.newtiers.setTievisibiliteGrp("");
         this.newtiers.setTievisibiliteUser(this.usersLog.getUsrid());
      }

      Session var18 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
      var5 = null;

      try {
         Transaction var19 = var18.beginTransaction();
         if (this.chronoActif && (this.newtiers.getTieid() == 0L || this.newtiers.getTieid() != 0L && (this.newtiers.getTiesigle() == null || this.newtiers.getTiesigle().isEmpty())) && this.chrono != null) {
            String var20 = this.calculChrono.numCompose(new Date(), this.chrono.getChrNature(), this.chrono.getChrSerie(), var18);
            this.newtiers.setTiesigle(var20);
         }

         if (this.newtiers.getTieid() == 0L) {
            this.newtiers.setTiedatecreat(new Date());
            this.newtiers.setTieusercreat(this.usersLog.getUsrid());
            this.newtiers = this.tiersDao.insert(this.newtiers, var18);
            this.lesTiers.add(this.newtiers);
            this.dataModelSociete.setWrappedData(this.lesTiers);
            this.var_action = 2;
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
            this.calculeImmatriculation();
         } else {
            this.newtiers.setTiedatemodif(new Date());
            this.newtiers.setTieusermodif(this.usersLog.getUsrid());
            this.newtiers = this.tiersDao.modif(this.newtiers, var18);
            this.var_action = 0;
         }

         if (this.newtiers.getTiecompte0() != null && !this.newtiers.getTiecompte0().isEmpty() || this.newtiers.getTiecompte1() != null && !this.newtiers.getTiecompte1().isEmpty() || this.newtiers.getTiecompte2() != null && !this.newtiers.getTiecompte2().isEmpty() || this.newtiers.getTiecompte3() != null && !this.newtiers.getTiecompte3().isEmpty() || this.newtiers.getTiecompte4() != null && !this.newtiers.getTiecompte4().isEmpty()) {
            new ExercicesComptable();
            ExercicesComptableDao var23 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
            ExercicesComptable var21 = var23.recupererLastExo(var18);
            if (var21 != null) {
               if (this.newtiers.getTiecompte0() != null && !this.newtiers.getTiecompte0().isEmpty()) {
                  this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, this.newtiers.getTiecompte0(), var21.getExecpt_id(), var18);
                  if (this.planComptable != null) {
                     if (this.newtiers.getTieprenom() != null && !this.newtiers.getTieprenom().isEmpty()) {
                        this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom() + " " + this.newtiers.getTieprenom());
                     } else {
                        this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom());
                     }

                     this.planComptableDao.modif(this.planComptable, var18);
                  }
               }

               if (this.newtiers.getTiecompte1() != null && !this.newtiers.getTiecompte1().isEmpty()) {
                  this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, this.newtiers.getTiecompte1(), var21.getExecpt_id(), var18);
                  if (this.planComptable != null) {
                     if (this.newtiers.getTieprenom() != null && !this.newtiers.getTieprenom().isEmpty()) {
                        this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom() + " " + this.newtiers.getTieprenom());
                     } else {
                        this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom());
                     }

                     this.planComptableDao.modif(this.planComptable, var18);
                  }
               }

               if (this.newtiers.getTiecompte2() != null && !this.newtiers.getTiecompte2().isEmpty()) {
                  this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, this.newtiers.getTiecompte2(), var21.getExecpt_id(), var18);
                  if (this.planComptable != null) {
                     if (this.newtiers.getTieprenom() != null && !this.newtiers.getTieprenom().isEmpty()) {
                        this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom() + " " + this.newtiers.getTieprenom());
                     } else {
                        this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom());
                     }

                     this.planComptableDao.modif(this.planComptable, var18);
                  }
               }

               if (this.newtiers.getTiecompte3() != null && !this.newtiers.getTiecompte3().isEmpty()) {
                  this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, this.newtiers.getTiecompte3(), var21.getExecpt_id(), var18);
                  if (this.planComptable != null) {
                     if (this.newtiers.getTieprenom() != null && !this.newtiers.getTieprenom().isEmpty()) {
                        this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom() + " " + this.newtiers.getTieprenom());
                     } else {
                        this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom());
                     }

                     this.planComptableDao.modif(this.planComptable, var18);
                  }
               }

               if (this.newtiers.getTiecompte4() != null && !this.newtiers.getTiecompte4().isEmpty()) {
                  this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, this.newtiers.getTiecompte4(), var21.getExecpt_id(), var18);
                  if (this.planComptable != null) {
                     if (this.newtiers.getTieprenom() != null && !this.newtiers.getTieprenom().isEmpty()) {
                        this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom() + " " + this.newtiers.getTieprenom());
                     } else {
                        this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom());
                     }

                     this.planComptableDao.modif(this.planComptable, var18);
                  }
               }
            }
         }

         if (this.var_action == 0 && this.newtiers.getTieactivite1() != null && !this.newtiers.getTieactivite1().isEmpty()) {
            var18.flush();
            this.chargerActivitesMetiers(var18);
         }

         if (this.medicalExist) {
            new ArrayList();
            new PatientPec();
            PatientPecDao var25 = new PatientPecDao(this.baseLog, this.utilInitHibernate);
            List var22 = var25.chargerLesPatientsTiers(this.newtiers, var18);
            if (var22.size() != 0) {
               for(int var9 = 0; var9 < var22.size(); ++var9) {
                  PatientPec var24 = (PatientPec)var22.get(var9);
                  var24.setPatpecType(this.newtiers.getTiecategorie());
                  var25.modif(var24, var18);
               }
            }
         }

         var19.commit();
      } catch (HibernateException var13) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (this.var_action == 0) {
         this.majBaux();
         this.majTiersStructures();
      }

      this.var_memo_action = this.var_action;
   }

   public void majBaux() throws HibernateException, NamingException {
      if (this.typeVente == 816 && this.newtiers.getTietype().equals("0") && this.newtiers.getTiecategorie().startsWith("Propr.")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            new BienBail();
            BienBailDao var5 = new BienBailDao(this.baseLog, this.utilInitHibernate);
            List var3 = var5.chargerBauxByProprietaire(this.newtiers.getTieid(), var1);
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  BienBail var4 = (BienBail)var3.get(var6);
                  var4.setBiebaiNomProprietaire(this.newtiers.getPatronymeLight());
                  var4.setBiebaiIrpp((double)this.newtiers.getTieAssujettissement());
                  var5.modif(var4, var1);
               }
            }

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

   public void majTiersStructures() throws HibernateException, NamingException {
      if (this.gestionTiers && (this.structureLog.getStrmaitrecabinet() == 2 || this.structureLog.getStrmaitrecabinet() == 3 || this.structureLog.getStrmaitrecabinet() == 4) && !this.newtiers.getTietype().equals("1") && !this.newtiers.getTietype().equals("2")) {
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
               new Tiers();
               new Contacts();

               for(int var7 = 0; var7 < this.lesPegStr.size(); ++var7) {
                  var1 = (StructurePeg)this.lesPegStr.get(var7);
                  String var8 = "structure" + var1.getStrId();
                  Session var9 = this.utilInitHibernate.getOpenSession(var8, "");
                  Transaction var10 = null;

                  try {
                     var10 = var9.beginTransaction();
                     this.tiersDao = new TiersDao(var8, this.utilInitHibernate);
                     Tiers var17 = this.tiersDao.chargerLesTiers(this.newtiers.getTietype(), this.newtiers.getTieid(), var9);
                     if (var17 == null) {
                        var17 = new Tiers();
                     }

                     var17 = this.trfCommumTiersStr(var17);
                     if (var17.getTieid() == 0L) {
                        var17.setTieusercreat(this.usersLog.getUsrid());
                        var17.setTiedatecreat(new Date());
                        var17.setTieidold(this.newtiers.getTieid());
                        var17 = this.tiersDao.insert(var17, var9);
                     } else {
                        var17.setTieusermodif(this.usersLog.getUsrid());
                        var17.setTiedatemodif(new Date());
                        var17 = this.tiersDao.modif(var17, var9);
                     }

                     if (this.lesContactsListe.size() != 0) {
                        this.contactDao = new ContactDao(var8, this.utilInitHibernate);

                        for(int var11 = 0; var11 < this.lesContactsListe.size(); ++var11) {
                           this.contacts = (Contacts)this.lesContactsListe.get(var11);
                           Contacts var6 = this.contactDao.chargerLesContactsPatronyme(var17.getTieid(), this.contacts.getConpatronyme(), var9);
                           if (var6 == null) {
                              var6 = new Contacts();
                           }

                           var6 = this.trfCommumContactStr(var6);
                           if (var6.getConid() == 0L) {
                              var6.setTiers(var17);
                              this.contactDao.insert(var6, var9);
                           } else {
                              this.contactDao.modif(var6, var9);
                           }
                        }
                     }

                     var10.commit();
                  } catch (HibernateException var15) {
                     if (var10 != null) {
                        var10.rollback();
                     }

                     throw var15;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }
               }
            }
         }
      }

   }

   public Tiers trfCommumTiersStr(Tiers var1) {
      var1.setTieAssujettissement(this.newtiers.getTieAssujettissement());
      var1.setTieactivite1(this.newtiers.getTieactivite1());
      var1.setTieactivite2(this.newtiers.getTieactivite2());
      var1.setTieadresse(this.newtiers.getTieadresse());
      var1.setTieadressebanque(this.newtiers.getTieadressebanque());
      var1.setTieadresseemployeur(this.newtiers.getTieadresseemployeur());
      var1.setTieanniversaire(this.newtiers.getTieanniversaire());
      var1.setTieanniversairedeces(this.newtiers.getTieanniversairedeces());
      var1.setTieanniversairemariage(this.newtiers.getTieanniversairemariage());
      var1.setTieaol(this.newtiers.getTieaol());
      var1.setTieascensseur(this.newtiers.getTieascensseur());
      var1.setTieassurt1(this.newtiers.getTieassurt1());
      var1.setTieassurt2(this.newtiers.getTieassurt2());
      var1.setTieassurt3(this.newtiers.getTieassurt3());
      var1.setTiebatiment(this.newtiers.getTiebatiment());
      var1.setTiebnq1(this.newtiers.getTiebnq1());
      var1.setTiebnq2(this.newtiers.getTiebnq2());
      var1.setTiebnq3(this.newtiers.getTiebnq3());
      var1.setTiebnq4(this.newtiers.getTiebnq4());
      var1.setTiebnq5(this.newtiers.getTiebnq5());
      var1.setTiebnq6(this.newtiers.getTiebnq6());
      var1.setTiebnq7(this.newtiers.getTiebnq7());
      var1.setTiebp(this.newtiers.getTiebp());
      var1.setTiebpemployeur(this.newtiers.getTiebpemployeur());
      var1.setTieburfax(this.newtiers.getTieburfax());
      var1.setTieburtel1(this.newtiers.getTieburtel1());
      var1.setTieburtel2(this.newtiers.getTieburtel2());
      var1.setTieburtel3(this.newtiers.getTieburtel3());
      var1.setTiecapatente(this.newtiers.getTiecapatente());
      var1.setTiecategorie(this.newtiers.getTiecategorie());
      var1.setTiecedex(this.newtiers.getTiecedex());
      var1.setTiecel1(this.newtiers.getTiecel1());
      var1.setTiecel2(this.newtiers.getTiecel2());
      var1.setTiecel3(this.newtiers.getTiecel3());
      var1.setTiechequeinterdit(this.newtiers.getTiechequeinterdit());
      var1.setTiecidate(this.newtiers.getTiecidate());
      var1.setTiecilieu(this.newtiers.getTiecilieu());
      var1.setTiecinum(this.newtiers.getTiecinum());
      var1.setTiecivilite(this.newtiers.getTiecivilite());
      var1.setTieclebanque(this.newtiers.getTieclebanque());
      var1.setTiecodepays(this.newtiers.getTiecodepays());
      var1.setTiecoefpvmedical(this.newtiers.getTiecoefpvmedical());
      var1.setTiecommune(this.newtiers.getTiecommune());
      var1.setTiecompte0(this.newtiers.getTiecompte0());
      var1.setTiecompte1(this.newtiers.getTiecompte1());
      var1.setTiecompte2(this.newtiers.getTiecompte2());
      var1.setTiecompte3(this.newtiers.getTiecompte3());
      var1.setTiecompte4(this.newtiers.getTiecompte4());
      var1.setTiecompteEtat(this.newtiers.getTiecompteEtat());
      var1.setTiecompteSage(this.newtiers.getTiecompteSage());
      var1.setTiecomptebanque(this.newtiers.getTiecomptebanque());
      var1.setTiecomptebloque(this.newtiers.getTiecomptebloque());
      var1.setTieconventiongele(this.newtiers.isTieconventiongele());
      var1.setTieDeclarationTva(this.newtiers.getTieDeclarationTva());
      var1.setTiedateDemandeEtat(this.newtiers.getTiedateDemandeEtat());
      var1.setTiedateDemandeOuverture(this.newtiers.getTiedateDemandeOuverture());
      var1.setTiedateDemandeRefus(this.newtiers.getTiedateDemandeRefus());
      var1.setTiedateDemandeReponse(this.newtiers.getTiedateDemandeReponse());
      var1.setTiedateDemandeSignature(this.newtiers.getTiedateDemandeSignature());
      var1.setTiedateDemandeType(this.newtiers.getTiedateDemandeType());
      var1.setTiedatedeces(this.newtiers.getTiedatedeces());
      var1.setTiedatemariage(this.newtiers.getTiedatemariage());
      var1.setTiedatenaissance(this.newtiers.getTiedatenaissance());
      var1.setTiedepart(this.newtiers.getTiedepart());
      var1.setTiedepot(this.newtiers.getTiedepot());
      var1.setTiedepotavance(this.newtiers.getTiedepotavance());
      var1.setTiedevise(this.newtiers.getTiedevise());
      var1.setTieemployeur(this.newtiers.getTieemployeur());
      var1.setTieepoux(this.newtiers.getTieepoux());
      var1.setTieescompte(this.newtiers.getTieescompte());
      var1.setTieetage(this.newtiers.getTieetage());
      var1.setTieetat(this.newtiers.getTieetat());
      var1.setTieexodouane(this.newtiers.getTieexodouane());
      var1.setTieexotva(this.newtiers.getTieexotva());
      var1.setTieFormatDevise(this.newtiers.getTieFormatDevise());
      var1.setTiefacpr(this.newtiers.getTiefacpr());
      var1.setTiefiscal(this.newtiers.getTiefiscal());
      var1.setTiegenre(this.newtiers.getTiegenre());
      var1.setTieguichetbanque(this.newtiers.getTieguichetbanque());
      var1.setTiehabitation(this.newtiers.getTiehabitation());
      var1.setTieIdStructure(this.newtiers.getTieIdStructure());
      var1.setTieiban(this.newtiers.getTieiban());
      var1.setTieidgroupe(this.newtiers.getTieidgroupe());
      var1.setTieidold(this.newtiers.getTieid());
      var1.setTieilot(this.newtiers.getTieilot());
      var1.setTiejournalreg(this.newtiers.getTiejournalreg());
      var1.setTielangue(this.newtiers.getTielangue());
      var1.setTielettregarantie(this.newtiers.isTielettregarantie());
      var1.setTielieunaissance(this.newtiers.getTielieunaissance());
      var1.setTielot(this.newtiers.getTielot());
      var1.setTiemail1(this.newtiers.getTiemail1());
      var1.setTiemail2(this.newtiers.getTiemail2());
      var1.setTiemail3(this.newtiers.getTiemail3());
      var1.setTiemail4(this.newtiers.getTiemail4());
      var1.setTiemail5(this.newtiers.getTiemail5());
      var1.setTiemodecom(this.newtiers.getTiemodecom());
      var1.setTiemodereg(this.newtiers.getTiemodereg());
      var1.setTiemotifgele(this.newtiers.getTiemotifgele());
      var1.setTiemsn(this.newtiers.getTiemsn());
      var1.setTienbarrondi(this.newtiers.getTienbarrondi());
      var1.setTienbcharge(this.newtiers.getTienbcharge());
      var1.setTienbecheance(this.newtiers.getTienbecheance());
      var1.setTienbenf(this.newtiers.getTienbenf());
      var1.setTieniveauetude(this.newtiers.getTieniveauetude());
      var1.setTienombanque(this.newtiers.getTienombanque());
      var1.setTienomfamille(this.newtiers.getTienomfamille());
      var1.setTienomjf(this.newtiers.getTienomjf());
      var1.setTienommere(this.newtiers.getTienommere());
      var1.setTienompays(this.newtiers.getTienompays());
      var1.setTienompere(this.newtiers.getTienompere());
      var1.setTienoteauto(this.newtiers.getTienoteauto());
      var1.setTienoteman(this.newtiers.getTienoteman());
      var1.setTienouse1(this.newtiers.getTienouse1());
      var1.setTienouse2(this.newtiers.getTienouse2());
      var1.setTienum1(this.newtiers.getTienum1());
      var1.setTienum2(this.newtiers.getTienum2());
      var1.setTienum3(this.newtiers.getTienum3());
      var1.setTienum4(this.newtiers.getTienum4());
      var1.setTienum5(this.newtiers.getTienum5());
      var1.setTienum6(this.newtiers.getTienum6());
      var1.setTienum7(this.newtiers.getTienum7());
      var1.setTienum8(this.newtiers.getTienum8());
      var1.setTienum9(this.newtiers.getTienum9());
      var1.setTienum10(this.newtiers.getTienum10());
      var1.setTienum11(this.newtiers.getTienum11());
      var1.setTienum12(this.newtiers.getTienum12());
      var1.setTienum13(this.newtiers.getTienum13());
      var1.setTienum14(this.newtiers.getTienum14());
      var1.setTienum15(this.newtiers.getTienum15());
      var1.setTienum16(this.newtiers.getTienum16());
      var1.setTienum17(this.newtiers.getTienum17());
      var1.setTienum18(this.newtiers.getTienum18());
      var1.setTienum19(this.newtiers.getTienum19());
      var1.setTienum20(this.newtiers.getTienum20());
      var1.setTienumbanque(this.newtiers.getTienumbanque());
      var1.setTieobservations(this.newtiers.getTieobservations());
      var1.setTiePhoto(this.newtiers.getTiePhoto());
      var1.setTiepProdExoTva(this.newtiers.getTiepProdExoTva());
      var1.setTiepdv(this.newtiers.getTiepdv());
      var1.setTieplafond(this.newtiers.getTieplafond());
      var1.setTieplafpatente(this.newtiers.getTieplafpatente());
      var1.setTieporte(this.newtiers.getTieporte());
      var1.setTieprenom(this.newtiers.getTieprenom());
      var1.setTieprofession(this.newtiers.getTieprofession());
      var1.setTiequartier(this.newtiers.getTiequartier());
      var1.setTieraisonsocialenom(this.newtiers.getTieraisonsocialenom());
      var1.setTieregion(this.newtiers.getTieregion());
      var1.setTierue(this.newtiers.getTierue());
      var1.setTiesecteur(this.newtiers.getTiesecteur());
      var1.setTieserie(this.newtiers.getTieserie());
      var1.setTiesexe(this.newtiers.getTiesexe());
      var1.setTiesigle(this.newtiers.getTiesigle());
      var1.setTiesitfam(this.newtiers.getTiesitfam());
      var1.setTieskype(this.newtiers.getTieskype());
      var1.setTiesource(this.newtiers.getTiesource());
      var1.setTiesurnom(this.newtiers.getTiesurnom());
      var1.setTiesurveille(this.newtiers.getTiesurveille());
      var1.setTieswift(this.newtiers.getTieswift());
      var1.setTietauxcom(this.newtiers.getTietauxcom());
      var1.setTieteldom(this.newtiers.getTieteldom());
      var1.setTietelemployeur(this.newtiers.getTietelemployeur());
      var1.setTietelex(this.newtiers.getTietelex());
      var1.setTietelvoiture(this.newtiers.getTietelvoiture());
      var1.setTietype(this.newtiers.getTietype());
      var1.setTietypeadresse(this.newtiers.getTietypeadresse());
      var1.setTietypereg(this.newtiers.getTietypereg());
      var1.setTieville(this.newtiers.getTieville());
      var1.setTievilleemployeur(this.newtiers.getTievilleemployeur());
      var1.setTievisibilite(this.newtiers.getTievisibilite());
      var1.setTievisibiliteGrp(this.newtiers.getTievisibiliteGrp());
      var1.setTievisibiliteUser(this.newtiers.getTievisibiliteUser());
      var1.setTieweb(this.newtiers.getTieweb());
      var1.setTieX(this.newtiers.getTieX());
      var1.setTieY(this.newtiers.getTieY());
      var1.setTieyahoo(this.newtiers.getTieyahoo());
      var1.setTiezone(this.newtiers.getTiezone());
      return var1;
   }

   public Contacts trfCommumContactStr(Contacts var1) {
      var1.setConCiDateDebut(this.contacts.getConCiDateDebut());
      var1.setConCiDateFin(this.contacts.getConCiDateFin());
      var1.setConCiNum(this.contacts.getConCiNum());
      var1.setConCiPar(this.contacts.getConCiPar());
      var1.setConcivilite(this.contacts.getConcivilite());
      var1.setConadresse(this.contacts.getConadresse());
      var1.setConanniversaire(this.contacts.getConanniversaire());
      var1.setConaol(this.contacts.getConaol());
      var1.setConappreciation(this.contacts.getConappreciation());
      var1.setConascensseur(this.contacts.getConascensseur());
      var1.setConbatiment(this.contacts.getConbatiment());
      var1.setConblog(this.contacts.getConblog());
      var1.setConbp(this.contacts.getConbp());
      var1.setConcedex(this.contacts.getConcedex());
      var1.setConcel1(this.contacts.getConcel1());
      var1.setConcel2(this.contacts.getConcel2());
      var1.setConcel3(this.contacts.getConcel3());
      var1.setConcivilite(this.contacts.getConcivilite());
      var1.setConclebanque(this.contacts.getConclebanque());
      var1.setConcommune(this.contacts.getConcommune());
      var1.setConcomptebanque(this.contacts.getConcomptebanque());
      var1.setCondatenaissance(this.contacts.getCondatenaissance());
      var1.setCondeparte(this.contacts.getCondeparte());
      var1.setConescalier(this.contacts.getConescalier());
      var1.setConetat(this.contacts.getConetat());
      var1.setConfax(this.contacts.getConfax());
      var1.setConfonction(this.contacts.getConfonction());
      var1.setConguichetbanque(this.contacts.getConguichetbanque());
      var1.setConiban(this.contacts.getConiban());
      var1.setConilot(this.contacts.getConilot());
      var1.setConJournal(this.contacts.getConJournal());
      var1.setConlangue(this.contacts.getConlangue());
      var1.setConlot(this.contacts.getConlot());
      var1.setConmail1(this.contacts.getConmail1());
      var1.setConmail2(this.contacts.getConmail2());
      var1.setConmail3(this.contacts.getConmail3());
      var1.setConmail4(this.contacts.getConmail4());
      var1.setConmail5(this.contacts.getConmail5());
      var1.setConmsn(this.contacts.getConmsn());
      var1.setConnom(this.contacts.getConnom());
      var1.setConnompays(this.contacts.getConnompays());
      var1.setConnumbanque(this.contacts.getConnumbanque());
      var1.setConobservation(this.contacts.getConobservation());
      var1.setConPhoto(this.contacts.getConPhoto());
      var1.setConPwEspaceClient(this.contacts.getConPwEspaceClient());
      var1.setConpatronyme(this.contacts.getConpatronyme());
      var1.setConporte(this.contacts.getConporte());
      var1.setConprenom(this.contacts.getConprenom());
      var1.setConquartier(this.contacts.getConquartier());
      var1.setConrue(this.contacts.getConrue());
      var1.setConSignature(this.contacts.getConSignature());
      var1.setConservice(this.contacts.getConservice());
      var1.setConskype(this.contacts.getConskype());
      var1.setConswift(this.contacts.getConswift());
      var1.setConType(this.contacts.getConType());
      var1.setContelbur(this.contacts.getContelbur());
      var1.setConteldom(this.contacts.getConteldom());
      var1.setConville(this.contacts.getConville());
      var1.setConweb(this.contacts.getConweb());
      var1.setConyahoo(this.contacts.getConyahoo());
      var1.setConzone(this.contacts.getConzone());
      return var1;
   }

   public void calculTiersdivers() {
      if (this.newtiers.getTiecategorie() == null || this.newtiers.getTiecategorie().isEmpty() || !this.newtiers.getTiecategorie().equalsIgnoreCase("Client Divers") && !this.newtiers.getTiecategorie().equalsIgnoreCase("Demandeur Divers") && !this.newtiers.getTiecategorie().equalsIgnoreCase("Fournisseur Divers")) {
         this.var_tiersDivers = false;
      } else {
         this.var_tiersDivers = true;
      }

   }

   public void transfererPesMorPersPh() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.newtiers.getTietype().equals("0")) {
         if (this.newtiers.getTiecategorie().equals("Propr. Soc. Location")) {
            this.newtiers.setTiecategorie("Propr. Indiv. Location");
            this.newtiers.setTiegenre("080");
         } else if (this.newtiers.getTiecategorie().equals("Propr. Soc. Syndic")) {
            this.newtiers.setTiecategorie("Propr. Indiv. Syndic");
            this.newtiers.setTiegenre("080");
         } else if (this.newtiers.getTiecategorie().equals("Propr. Soc. Mixte")) {
            this.newtiers.setTiecategorie("Propr. Indiv. Mixte");
            this.newtiers.setTiegenre("080");
         } else {
            this.newtiers.setTiecategorie("Prestataire");
            this.newtiers.setTiegenre("000");
         }
      } else if (this.newtiers.getTietype().equals("1")) {
         this.newtiers.setTiecategorie("Suspect");
         this.newtiers.setTiegenre("010");
      } else if (this.newtiers.getTietype().equals("2")) {
         this.newtiers.setTiecategorie("Prospect");
         this.newtiers.setTiegenre("020");
      } else if (this.newtiers.getTietype().equals("3")) {
         this.newtiers.setTiecategorie("Client Individuel");
         this.newtiers.setTiegenre("030");
      }

      this.newtiers = this.tiersDao.modif(this.newtiers);
      this.chargerLesTiers();
      this.afficheButtOption = false;
   }

   public void transfererPesPhPersMor() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.newtiers.getTietype().equals("0")) {
         if (this.newtiers.getTiecategorie().contains("Propr. Indiv. Location")) {
            this.newtiers.setTiecategorie("Propr. Soc. Location");
            this.newtiers.setTiegenre("081");
         } else if (this.newtiers.getTiecategorie().contains("Propr. Indiv. Syndic")) {
            this.newtiers.setTiecategorie("Propr. Soc. Syndic");
            this.newtiers.setTiegenre("081");
         } else if (this.newtiers.getTiecategorie().contains("Propr. Indiv. Mixte")) {
            this.newtiers.setTiecategorie("Propr. Soc. Mixte");
            this.newtiers.setTiegenre("081");
         } else {
            this.newtiers.setTiecategorie("Fournisseur");
            this.newtiers.setTiegenre("001");
         }
      } else if (this.newtiers.getTietype().equals("1")) {
         this.newtiers.setTiecategorie("Suspect");
         this.newtiers.setTiegenre("011");
      } else if (this.newtiers.getTietype().equals("2")) {
         this.newtiers.setTiecategorie("Prospect");
         this.newtiers.setTiegenre("021");
      } else if (this.newtiers.getTietype().equals("3")) {
         this.newtiers.setTiecategorie("Client Société");
         this.newtiers.setTiegenre("031");
      }

      this.newtiers.setTiedatenaissance((Date)null);
      this.newtiers.setTieanniversaire("");
      this.newtiers.setTieraisonsocialenom(this.newtiers.getTieraisonsocialenom() + " " + this.newtiers.getTieprenom());
      this.newtiers.setTieprenom("");
      this.newtiers.setTiecivilite("");
      this.newtiers = this.tiersDao.modif(this.newtiers);
      this.chargerLesTiers();
      this.afficheButtOption = false;
   }

   public void selectionPays() {
      if (this.newtiers.getTienompays() != null && !this.newtiers.getTienompays().isEmpty()) {
         this.newtiers.setTiecodepays("");
         LecturePays var1 = new LecturePays();
         if (var1.getMespays().size() != 0) {
            for(int var2 = 0; var2 < var1.getMespays().size(); ++var2) {
               if (((ObjetPays)var1.getMespays().get(var2)).getNom_FR().equalsIgnoreCase(this.newtiers.getTienompays())) {
                  this.newtiers.setTiecodepays(((ObjetPays)var1.getMespays().get(var2)).getIdentification());
                  break;
               }
            }
         }
      }

   }

   public void calculeGenre() {
      if (this.newtiers.getTiecivilite() != null && !this.newtiers.getTiecivilite().isEmpty()) {
         if (this.newtiers.getTiecivilite() == null || this.newtiers.getTiecivilite().isEmpty() || !this.newtiers.getTiecivilite().equals("Madame") && !this.newtiers.getTiecivilite().equals("Mademoiselle")) {
            this.newtiers.setTiesexe(1);
         } else {
            this.newtiers.setTiesexe(0);
         }
      } else {
         this.newtiers.setTiesexe(1);
         this.newtiers.setTiecivilite("");
      }

   }

   public void menuGroupeListesociété() throws HibernateException, NamingException {
      this.lesStructures.clear();
      if (this.structureLog.getStrmaitrecabinet() == 2) {
         new ArrayList();
         if (this.structureLog.getStrmaitrecabinet() != 0) {
            Session var2 = this.utilInitHibernate.getLoginEpegase();
            Query var3 = var2.createQuery("from StructurePeg where strId=:idStr").setLong("idStr", this.structureLog.getStrid());
            List var1 = var3.list();
            if (var1.size() != 0) {
               long var4 = ((StructurePeg)var1.get(0)).getCabinetPeg().getCabId();
               if (var4 != 0L) {
                  var3 = var2.createQuery("from StructurePeg where cabinetPeg.cabId=:idCab and strmaitrecabinet=0)").setLong("idCab", var4);
                  this.lesStructures = var3.list();
               }
            }

            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void gelerTiers() throws HibernateException, NamingException {
      if (this.newtiers != null) {
         this.newtiers.setTieetat(1);
         this.newtiers = this.tiersDao.modif(this.newtiers);
      }

   }

   public void degelerTiers() throws HibernateException, NamingException {
      if (this.newtiers != null) {
         this.newtiers.setTieetat(0);
         this.newtiers = this.tiersDao.modif(this.newtiers);
      }

   }

   public void ouvrirCentreInteret() {
      if (this.newtiers != null) {
         int var1;
         for(var1 = 0; var1 < this.listeCentreInteret.size(); ++var1) {
            ((ObjetElementRdv)this.listeCentreInteret.get(var1)).setSelect(false);
         }

         if (this.newtiers.getTieinteret() != null && !this.newtiers.getTieinteret().isEmpty()) {
            if (!this.newtiers.getTieinteret().contains(":")) {
               for(var1 = 0; var1 < this.listeCentreInteret.size(); ++var1) {
                  if (this.newtiers.getTieinteret().equalsIgnoreCase(((ObjetElementRdv)this.listeCentreInteret.get(var1)).getLibelle())) {
                     ((ObjetElementRdv)this.listeCentreInteret.get(var1)).setSelect(true);
                  }
               }
            } else {
               String[] var6 = this.newtiers.getTieinteret().split(":");
               int var2 = var6.length;

               for(int var3 = 0; var3 < var2; ++var3) {
                  String var4 = var6[var3];

                  for(int var5 = 0; var5 < this.listeCentreInteret.size(); ++var5) {
                     if (var4.equalsIgnoreCase(((ObjetElementRdv)this.listeCentreInteret.get(var5)).getLibelle())) {
                        ((ObjetElementRdv)this.listeCentreInteret.get(var5)).setSelect(true);
                        break;
                     }
                  }
               }
            }
         }

         this.dataModelCentreInteret.setWrappedData(this.listeCentreInteret);
      }

      this.showModalPanelCentreInteret = true;
   }

   public void fermerCentreInteret() {
      this.showModalPanelCentreInteret = false;
   }

   public void validerCenterInteret() {
      String var1 = "";

      for(int var2 = 0; var2 < this.listeCentreInteret.size(); ++var2) {
         if (((ObjetElementRdv)this.listeCentreInteret.get(var2)).isSelect()) {
            if (var1 != null && !var1.isEmpty()) {
               var1 = var1 + ":" + ((ObjetElementRdv)this.listeCentreInteret.get(var2)).getLibelle();
            } else {
               var1 = ((ObjetElementRdv)this.listeCentreInteret.get(var2)).getLibelle();
            }
         }
      }

      this.newtiers.setTieinteret(var1);
      this.showModalPanelCentreInteret = false;
      this.controleSaisie();
   }

   public void chargerLesContacts() throws HibernateException, NamingException {
      this.lesContactsListe.clear();
      if (this.conseillersRec != 0L && this.conseillersRec != 99999999L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         String var2 = "";
         new ArrayList();
         List var3 = this.responsableDao.listeConseillersByTiers(this.rechercherContactConseiller(), var1);
         if (var3.size() != 0) {
            int var4 = 0;

            while(true) {
               if (var4 >= var3.size()) {
                  var2 = " and tiers.tieid in (" + var2 + ")";
                  break;
               }

               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + "," + ((Tiers)var3.get(var4)).getTieid();
               } else {
                  var2 = "" + ((Tiers)var3.get(var4)).getTieid();
               }

               ++var4;
            }
         }

         String var5 = this.rechercherContacts() + var2;
         this.lesContactsListe = this.contactDao.listeContacts(var5, var1);
         this.utilInitHibernate.closeSession();
      } else {
         this.lesContactsListe = this.contactDao.listeContacts(this.rechercherContacts(), (Session)null);
      }

      this.datamodelContact.setWrappedData(this.lesContactsListe);
      this.testContact = false;
   }

   public String rechercherContacts() {
      String var1 = "from Contacts where ((connom is not null and connom<>'') or (conservice is not null and conservice<>'')) and connom<>'*' and connom<>'**' and connom<>'-' and connom<>'--' and connom<>'.' and connom<>'..'";
      if (this.typeRec != null && !this.typeRec.isEmpty() && !this.typeRec.equals("100")) {
         if (this.typeRec.equals("0")) {
            var1 = var1 + " and tiers.tietype='0'";
         } else {
            var1 = var1 + " and (tiers.tietype='1' or tiers.tietype='2' or tiers.tietype='3')";
         }
      }

      var1 = var1 + "and tiers.tieetat=" + this.inpInactif;
      if (this.nomRec != null && !this.nomRec.isEmpty()) {
         var1 = var1 + " and connom LIKE" + "'%" + this.nomRec + "%'";
      }

      if (this.prenomRec != null && !this.prenomRec.isEmpty()) {
         var1 = var1 + " and conprenom LIKE" + "'%" + this.prenomRec + "%'";
      }

      if (this.activitesRec != null && !this.activitesRec.isEmpty() && !this.activitesRec.equals("100") && !this.activitesRec.equals("****")) {
         var1 = var1 + " and (tiers.tieactivite1='" + this.activitesRec + "' or tiers.tieactivite2='" + this.activitesRec + "')";
      }

      if (this.activitesRec != null && !this.activitesRec.isEmpty() && this.activitesRec.equals("****")) {
         var1 = var1 + " and (tieactivite1 is null or tieactivite1='' or tieactivite2 is null or tieactivite2='')";
      }

      if (this.villeRec != null && !this.villeRec.isEmpty()) {
         var1 = var1 + " and tiers.tieraisonsocialenom LIKE" + "'" + this.villeRec + "%'";
      }

      if (this.appreciationRec != null && !this.appreciationRec.isEmpty() && !this.appreciationRec.equals("100")) {
         var1 = var1 + " and tiers.tienoteman=" + "'" + this.appreciationRec + "'";
      }

      if (this.paysRec != null && !this.paysRec.isEmpty() && !this.paysRec.equals("100")) {
         var1 = var1 + " and tiers.tienompays=" + "'" + this.paysRec + "'";
      }

      if (this.telRec != null && !this.telRec.isEmpty()) {
         var1 = var1 + " and (contelbur LIKE" + "'%" + this.telRec + "%' or conteldom LIKE" + "'%" + this.telRec + "%' or concel1 LIKE" + "'%" + this.telRec + "%' or concel2 LIKE" + "'%" + this.telRec + "%' or concel3 LIKE" + "'%" + this.telRec + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && !this.mailRec.contains("*")) {
         var1 = var1 + " and (tiers.tiemail1 LIKE " + "'" + this.mailRec + "%' or tiers.tiemail2 like '" + this.mailRec + "%' or tiers.tiemail3 like '" + this.mailRec + "%' or tiers.tiemail4 like '" + this.mailRec + "%' or tiers.tiemail5 like '" + this.mailRec + "%' or tiers.tieyahoo like '" + this.mailRec + "%' or tiers.tiemsn like '" + this.mailRec + "%' or tiers.tieaol like '" + this.mailRec + "%')";
      }

      String var2;
      if (this.mailRec != null && !this.mailRec.isEmpty() && this.mailRec.startsWith("*")) {
         var2 = this.mailRec.substring(1);
         var1 = var1 + " and (tiers.tiemail1 LIKE " + "'%" + var2 + "%' or tiers.tiemail2 like '%" + var2 + "%' or tiers.tiemail3 like '%" + var2 + "%' or tiers.tiemail4 like '%" + var2 + "%' or tiers.tiemail5 like '%" + var2 + "%' or tiers.tieyahoo like '%" + var2 + "%' or tiers.tiemsn like '%" + var2 + "%' or tiers.tieaol like '%" + var2 + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && !this.mailRec.contains("*")) {
         var1 = var1 + " or (conmail1 LIKE " + "'" + this.mailRec + "%' or conmail2 like '" + this.mailRec + "%' or conmail3 like '" + this.mailRec + "%' or conmail4 like '" + this.mailRec + "%' or conmail5 like '" + this.mailRec + "%' or conyahoo like '" + this.mailRec + "%' or conmsn like '" + this.mailRec + "%' or conaol like '" + this.mailRec + "%')";
      }

      if (this.mailRec != null && !this.mailRec.isEmpty() && this.mailRec.startsWith("*")) {
         var2 = this.mailRec.substring(1);
         var1 = var1 + " or (conmail1 LIKE " + "'%" + var2 + "%' or conmail2 like '%" + var2 + "%' or conmail3 like '%" + var2 + "%' or conmail4 like '%" + var2 + "%' or conmail5 like '%" + var2 + "%' or conyahoo like '%" + var2 + "%' or conmsn like '%" + var2 + "%' or conaol like '%" + var2 + "%')";
      }

      if (this.obsRec != null && !this.obsRec.isEmpty()) {
         var1 = var1 + " and conobservation LIKE" + "'%" + this.obsRec + "%'";
      }

      if (this.fonctionRec != null && !this.fonctionRec.isEmpty()) {
         var1 = var1 + " and confonction LIKE" + "'%" + this.fonctionRec + "%'";
      }

      if (this.serviceRec != null && !this.serviceRec.isEmpty()) {
         var1 = var1 + " and conservice LIKE" + "'%" + this.serviceRec + "%'";
      }

      return var1;
   }

   public void selectionContact() throws HibernateException, NamingException {
      if (this.datamodelContact.isRowAvailable()) {
         this.contacts = (Contacts)this.datamodelContact.getRowData();
         this.newtiers = this.contacts.getTiers();
         this.testContact = true;
         if (this.newtiers.getTietype().equals("1") && this.newtiers.getTiegenre().equals("001") && this.newtiers.getTiecategorie().equals("Banque")) {
            this.contactBanque = true;
         } else {
            this.contactBanque = false;
         }

         new ArrayList();
         List var1 = this.campagneParticipantVentesDao.rechercheCampagneContact(this.contacts, (Session)null);
         this.dataModelParticipantsContact.setWrappedData(var1);
         new ArrayList();
         List var2 = this.cadeauxDao.rechercheByContact(this.contacts.getConid(), (Session)null);
         this.dataModelCadeaux.setWrappedData(var2);
      }

   }

   public void googleMap() throws IOException, URISyntaxException {
      UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
      this.uri = var1.calculMap(this.newtiers.getTierue(), this.newtiers.getTieadresse(), this.newtiers.getTieville(), this.newtiers.getTienompays());
      this.showModalGoogleMap = true;
   }

   public void annuleGoogleMap() {
      this.showModalGoogleMap = false;
   }

   public void calculeImmatriculation() throws JDOMException, IOException, ParseException {
      String var1 = "";
      if (this.newtiers.getTiegenre() != null && !this.newtiers.getTiegenre().isEmpty()
              && (this.newtiers.getTiegenre().equalsIgnoreCase("000")
              || this.newtiers.getTiegenre().equalsIgnoreCase("010")
              || this.newtiers.getTiegenre().equalsIgnoreCase("020")
              || this.newtiers.getTiegenre().equalsIgnoreCase("022")
              || this.newtiers.getTiegenre().equalsIgnoreCase("024")
              || this.newtiers.getTiegenre().equalsIgnoreCase("030")
              || this.newtiers.getTiegenre().equalsIgnoreCase("032")
              || this.newtiers.getTiegenre().equalsIgnoreCase("034")
              || this.newtiers.getTiegenre().equalsIgnoreCase("035")
              || this.newtiers.getTiegenre().equalsIgnoreCase("070")
              || this.newtiers.getTiegenre().equalsIgnoreCase("080")
              || this.newtiers.getTiegenre().equalsIgnoreCase("099"))) {
         var1 = "pphysique";
      } else {
         var1 = "pmoral";
      }

      if (this.newtiers.getTiecodepays() == null || this.newtiers.getTiecodepays().isEmpty()) {
         this.newtiers.setTiecodepays(this.structureLog.getStrcodepays());
      }

      LectureImmatriculation var2 = new LectureImmatriculation(this.newtiers.getTiecodepays(), var1);
      this.objetImmatriculation = var2.getImmatriculation();
   }

   public void modifierCompte0() throws HibernateException, NamingException, IOException {
      this.compteModif = 0;
      this.modifierCompte(this.newtiers.getTiecompte0());
   }

   public void modifierCompte1() throws HibernateException, NamingException, IOException {
      this.compteModif = 1;
      this.modifierCompte(this.newtiers.getTiecompte1());
   }

   public void modifierCompte2() throws HibernateException, NamingException, IOException {
      this.compteModif = 2;
      this.modifierCompte(this.newtiers.getTiecompte2());
   }

   public void modifierCompte3() throws HibernateException, NamingException, IOException {
      this.compteModif = 3;
      this.modifierCompte(this.newtiers.getTiecompte3());
   }

   public void modifierCompte4() throws HibernateException, NamingException, IOException {
      this.compteModif = 4;
      this.modifierCompte(this.newtiers.getTiecompte4());
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
      String var6 = "";
      if (this.newtiers.getTietype().equalsIgnoreCase("0")) {
         if (this.compteModif == 4) {
            var6 = "(7)";
         } else {
            var6 = "(6,9)";
         }

         this.mesCompteItem = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, var5.getExecpt_id(), var6, 0, var3);
         this.choixCompte = 0;
      } else if (this.newtiers.getTietype().equalsIgnoreCase("3")) {
         if (this.compteModif == 4) {
            var6 = "(6,9)";
         } else {
            var6 = "(7)";
         }

         this.mesCompteItem = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, var5.getExecpt_id(), var6, 0, var3);
         this.choixCompte = 0;
      } else {
         var6 = "(90)";
         this.mesCompteItem = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, var5.getExecpt_id(), var6, 0, var3);
         this.choixCompte = 2;
      }

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
      this.newtiers.setTiedatemodif(new Date());
      this.newtiers.setTieusermodif(this.usersLog.getUsrid());
      this.newtiers.setTiecompte0("");
   }

   public void supprimerCompte1() {
      this.newtiers.setTiedatemodif(new Date());
      this.newtiers.setTieusermodif(this.usersLog.getUsrid());
      this.newtiers.setTiecompte1("");
   }

   public void supprimerCompte2() {
      this.newtiers.setTiedatemodif(new Date());
      this.newtiers.setTieusermodif(this.usersLog.getUsrid());
      this.newtiers.setTiecompte2("");
   }

   public void supprimerCompte3() {
      this.newtiers.setTiedatemodif(new Date());
      this.newtiers.setTieusermodif(this.usersLog.getUsrid());
      this.newtiers.setTiecompte3("");
   }

   public void supprimerCompte4() {
      this.newtiers.setTiedatemodif(new Date());
      this.newtiers.setTieusermodif(this.usersLog.getUsrid());
      this.newtiers.setTiecompte4("");
   }

   public void saveCompte() throws HibernateException, NamingException {
      String[] var1;
      if (this.choixCompte == 0) {
         if (this.compte != null && !this.compte.isEmpty()) {
            if (this.compte.contains(":")) {
               var1 = this.compte.split(":");
               String var2 = var1[0];
               if (this.compteModif == 0) {
                  this.newtiers.setTiecompte0(var2);
               } else if (this.compteModif == 1) {
                  this.newtiers.setTiecompte1(var2);
               } else if (this.compteModif == 2) {
                  this.newtiers.setTiecompte2(var2);
               } else if (this.compteModif == 3) {
                  this.newtiers.setTiecompte3(var2);
               } else if (this.compteModif == 4) {
                  this.newtiers.setTiecompte4(var2);
               }
            } else if (!this.compte.equals("0")) {
               if (this.compteModif == 0) {
                  this.newtiers.setTiecompte0(this.compte);
               } else if (this.compteModif == 1) {
                  this.newtiers.setTiecompte1(this.compte);
               } else if (this.compteModif == 2) {
                  this.newtiers.setTiecompte2(this.compte);
               } else if (this.compteModif == 3) {
                  this.newtiers.setTiecompte3(this.compte);
               } else if (this.compteModif == 4) {
                  this.newtiers.setTiecompte4(this.compte);
               }
            }
         }
      } else if (this.choixCompte == 3) {
         if (this.compteModif == 0) {
            this.newtiers.setTiecompte0(this.compte);
         } else if (this.compteModif == 1) {
            this.newtiers.setTiecompte1(this.compte);
         } else if (this.compteModif == 2) {
            this.newtiers.setTiecompte2(this.compte);
         } else if (this.compteModif == 3) {
            this.newtiers.setTiecompte3(this.compte);
         } else if (this.compteModif == 4) {
            this.newtiers.setTiecompte4(this.compte);
         }
      } else {
         this.planComptable.setExercicesComptable(this.exerciceSelectionne);
         this.planComptable.setPlcDateCreat(new Date());
         this.planComptable.setPlcUserCreat(this.usersLog.getUsrid());
         this.planComptable.setPlcRanDetaille(true);
         if (this.newtiers.getTieprenom() != null && !this.newtiers.getTieprenom().isEmpty()) {
            this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom() + " " + this.newtiers.getTieprenom());
         } else {
            this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom());
         }

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
         if (this.selecFiscalite != null && !this.selecFiscalite.isEmpty()) {
            this.planComptable.setPlcFiscalite(this.selecFiscalite);
         } else if (this.structureLog.getStrzonefiscale2() != null) {
            this.planComptable.setPlcFiscalite(this.structureLog.getStrzonefiscale2());
         } else {
            this.planComptable.setPlcFiscalite(this.structureLog.getStrzonefiscale());
         }

         this.planComptableDao.insert(this.planComptable);
         if (this.compteModif == 0) {
            this.newtiers.setTiecompte0(this.planComptable.getPlcCompte());
         } else if (this.compteModif == 1) {
            this.newtiers.setTiecompte1(this.planComptable.getPlcCompte());
         } else if (this.compteModif == 2) {
            this.newtiers.setTiecompte2(this.planComptable.getPlcCompte());
         } else if (this.compteModif == 3) {
            this.newtiers.setTiecompte3(this.planComptable.getPlcCompte());
         } else if (this.compteModif == 4) {
            this.newtiers.setTiecompte4(this.planComptable.getPlcCompte());
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
      this.planComptable = new PlanComptable();
      this.planComptable.setPlcCompte("");
      if (this.newtiers.getTieprenom() != null && !this.newtiers.getTieprenom().isEmpty()) {
         this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom() + " " + this.newtiers.getTieprenom());
      } else {
         this.planComptable.setPlcLibelleCpteFR(this.newtiers.getTieraisonsocialenom());
      }

      if (this.choixCompte == 2) {
         this.mesNatureCompteItem.add(new SelectItem("90:Attente"));
      } else if (this.newtiers.getTietype().equalsIgnoreCase("0")) {
         this.mesNatureCompteItem.add(new SelectItem("6:Fournisseurs"));
         this.mesNatureCompteItem.add(new SelectItem("9:Autres tiers"));
      } else if (this.newtiers.getTietype().equalsIgnoreCase("3")) {
         this.mesNatureCompteItem.add(new SelectItem("7:Clients"));
      } else {
         this.mesNatureCompteItem.add(new SelectItem("90:Attente"));
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

   public void affichePhoto() throws IOException, SQLException {
      if (this.newtiers.getTiePhoto() != null) {
         this.urlphoto = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers" + File.separator + this.newtiers.getTiePhoto();
      } else {
         this.urlphoto = "";
      }

   }

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException {
      FacesContext var1 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers") + File.separator + "T" + this.newtiers.getTieid();
            File var3 = new File(var2);
            if (var3.exists()) {
               var3.delete();
            }

            String var4 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = "T" + this.newtiers.getTieid() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
            this.fileName = var4;
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.newtiers.setTiePhoto(var4);
            this.newtiers = this.tiersDao.modif(this.newtiers);
            this.urlphoto = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers" + File.separator + this.newtiers.getTiePhoto();
         }
      } catch (IOException var7) {
         this.newtiers.setTiePhoto(this.fileName);
         var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var7.printStackTrace();
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException {
      String var1 = "";
      int var2 = this.newtiers.getTiePhoto().lastIndexOf(46);
      if (0 < var2 && var2 <= this.newtiers.getTiePhoto().length() - 2) {
         var1 = "." + this.newtiers.getTiePhoto().substring(var2 + 1);
      }

      String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers") + File.separator + "T" + this.newtiers.getTieid() + var1;
      File var4 = new File(var3);
      if (var4.exists()) {
         var4.delete();
      }

      this.newtiers.setTiePhoto((String)null);
      this.newtiers = this.tiersDao.modif(this.newtiers);
   }

   public void affichePhotoProcuration() throws IOException, SQLException {
      if (this.contactsProcuration.getConPhoto() != null) {
         this.urlphotoProcuration = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers" + File.separator + this.contactsProcuration.getConPhoto();
      } else {
         this.urlphotoProcuration = "";
      }

   }

   public void ajoutPhotoProcuration() throws HibernateException, NamingException {
      if (this.contactsProcuration.getConid() == 0L) {
         this.contactsProcuration.setTiers(this.newtiers);
         this.contactsProcuration.setCondatecreat(new Date());
         this.contactsProcuration.setConusercreat(this.usersLog.getUsrid());
         this.contactsProcuration.setConType(1);
         this.contactsProcuration = this.contactDao.insert(this.contactsProcuration);
      }

      FacesContext var1 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers") + File.separator + "CPP" + this.contactsProcuration.getConPhoto();
            File var3 = new File(var2);
            if (var3.exists()) {
               var3.delete();
            }

            String var4 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = "CPP" + this.contactsProcuration.getConPhoto() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
            this.fileName = var4;
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.contactsProcuration.setConPhoto(var4);
            this.contactsProcuration = this.contactDao.modif(this.contactsProcuration);
            this.urlphoto = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers" + File.separator + this.contactsProcuration.getConPhoto();
         }
      } catch (IOException var7) {
         this.contactsProcuration.setConPhoto(this.fileName);
         var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var7.printStackTrace();
      }

   }

   public void reInitPhotoProcuration() throws HibernateException, NamingException {
      String var1 = "";
      int var2 = this.newtiers.getTiePhoto().lastIndexOf(46);
      if (0 < var2 && var2 <= this.newtiers.getTiePhoto().length() - 2) {
         var1 = "." + this.newtiers.getTiePhoto().substring(var2 + 1);
      }

      String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers") + File.separator + "CPP" + this.contactsProcuration.getConPhoto() + var1;
      File var4 = new File(var3);
      if (var4.exists()) {
         var4.delete();
      }

      this.contactsProcuration.setConPhoto((String)null);
      this.contactsProcuration = this.contactDao.modif(this.contactsProcuration);
   }

   public void afficheSignatureProcuration() throws IOException, SQLException {
      if (this.contactsProcuration.getConSignature() != null) {
         this.urlsignatureProcuration = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers" + File.separator + this.contactsProcuration.getConSignature();
      } else {
         this.urlsignatureProcuration = "";
      }

   }

   public void ajoutSignatureProcuration() throws HibernateException, NamingException {
      if (this.contactsProcuration.getConid() == 0L) {
         this.contactsProcuration.setTiers(this.newtiers);
         this.contactsProcuration.setCondatecreat(new Date());
         this.contactsProcuration.setConusercreat(this.usersLog.getUsrid());
         this.contactsProcuration.setConType(1);
         this.contactsProcuration = this.contactDao.insert(this.contactsProcuration);
      }

      FacesContext var1 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers") + File.separator + "CSP" + this.contactsProcuration.getConPhoto();
            File var3 = new File(var2);
            if (var3.exists()) {
               var3.delete();
            }

            String var4 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = "CSP" + this.contactsProcuration.getConPhoto() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
            this.fileName = var4;
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.contactsProcuration.setConSignature(var4);
            this.contactsProcuration = this.contactDao.modif(this.contactsProcuration);
            this.urlphoto = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers" + File.separator + this.contactsProcuration.getConPhoto();
         }
      } catch (IOException var7) {
         this.contactsProcuration.setConSignature(this.fileName);
         var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var7.printStackTrace();
      }

   }

   public void reInitSignatureProcuration() throws HibernateException, NamingException {
      String var1 = "";
      int var2 = this.newtiers.getTiePhoto().lastIndexOf(46);
      if (0 < var2 && var2 <= this.newtiers.getTiePhoto().length() - 2) {
         var1 = "." + this.newtiers.getTiePhoto().substring(var2 + 1);
      }

      String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers") + File.separator + "CSP" + this.contactsProcuration.getConPhoto() + var1;
      File var4 = new File(var3);
      if (var4.exists()) {
         var4.delete();
      }

      this.contactsProcuration.setConSignature((String)null);
      this.contactsProcuration = this.contactDao.modif(this.contactsProcuration);
   }

   public void ajoutContact() {
      this.contacts = new Contacts();
      this.contacts.setConnompays(this.newtiers.getTienompays());
      this.dataModelParticipantsContact = new ListDataModel();
      this.showModalPanelContact = true;
   }

   public void modifContact() {
      if (this.contacts != null) {
         this.showModalPanelContact = true;
      }

   }

   public void consulContact() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelContact.isRowAvailable()) {
         this.contacts = (Contacts)this.datamodelContact.getRowData();
         this.newtiers = this.contacts.getTiers();
         new ArrayList();
         List var1 = this.campagneParticipantVentesDao.rechercheCampagneContact(this.contacts, (Session)null);
         this.dataModelParticipantsContact.setWrappedData(var1);
         new ArrayList();
         List var2 = this.cadeauxDao.rechercheByContact(this.contacts.getConid(), (Session)null);
         this.dataModelCadeaux.setWrappedData(var2);
         this.contactBanque = false;
         this.testContact = true;
      } else {
         this.testContact = false;
      }

   }

   public void ajoutBanque() {
      this.contacts = new Contacts();
      this.contacts.setConnompays(this.newtiers.getTienompays());
      this.showModalPanelBanque = true;
   }

   public void modifBanque() {
      if (this.contacts != null) {
         this.showModalPanelBanque = true;
      }

   }

   public void consulBanque() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelContact.isRowAvailable()) {
         this.contacts = (Contacts)this.datamodelContact.getRowData();
         this.newtiers = this.contacts.getTiers();
         this.testContact = true;
         new ArrayList();
         List var1 = this.campagneParticipantVentesDao.rechercheCampagneContact(this.contacts, (Session)null);
         this.dataModelParticipantsContact.setWrappedData(var1);
         new ArrayList();
         List var2 = this.cadeauxDao.rechercheByContact(this.contacts.getConid(), (Session)null);
         this.dataModelCadeaux.setWrappedData(var2);
         this.contactBanque = true;
         this.testContact = true;
         this.showModalPanelBanque = true;
      } else {
         this.testContact = false;
      }

   }

   public void saveContact() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.contacts.getConnom() != null && !this.contacts.getConnom().isEmpty() || this.contacts.getConcomptebanque() != null && !this.contacts.getConcomptebanque().isEmpty()) {
         this.contacts.setTiers(this.newtiers);
         String var1 = "";
         if (this.contacts.getCondatenaissance() != null) {
            DateFormat var2 = DateFormat.getDateInstance(3);
            var1 = var2.format(this.contacts.getCondatenaissance()).substring(0, 5);
         }

         this.contacts.setConanniversaire(var1);
         if (this.contacts.getConprenom() != null && !this.contacts.getConprenom().isEmpty()) {
            this.contacts.setConpatronyme(this.contacts.getConnom() + " " + this.contacts.getConprenom());
         } else {
            this.contacts.setConpatronyme(this.contacts.getConnom());
         }

         this.contacts.setConType(0);
         if (this.contacts.getConid() == 0L) {
            this.contacts.setCondatecreat(new Date());
            this.contacts.setConusercreat(this.usersLog.getUsrid());
            this.contacts = this.contactDao.insert(this.contacts);
            this.lesContactsListe.add(this.contacts);
            this.datamodelContact.setWrappedData(this.lesContactsListe);
         } else {
            this.contacts.setCondatemodif(new Date());
            this.contacts.setConusermodif(this.usersLog.getUsrid());
            this.contacts = this.contactDao.modif(this.contacts);
         }

         if (this.newtiers.getTietype().equals("0") && this.newtiers.getTiecategorie().equals("Banque") && this.contacts.getConJournal() != null && !this.contacts.getConJournal().isEmpty()) {
            new ExercicesComptable();
            ExercicesComptableDao var3 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
            ExercicesComptable var6 = var3.recupererLastExo((Session)null);
            if (var6 != null) {
               new JournauxComptables();
               JournauxComptablesDao var5 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
               JournauxComptables var4 = var5.chercherCode(this.contacts.getConJournal(), var6.getExecpt_id(), (Session)null);
               if (var4 != null) {
                  var4.setPljCiviliteGestionnaire(this.contacts.getConcivilite());
                  var4.setPljNomGestionnaire(this.contacts.getConnom());
                  var4.setPljPrenomGestionnaire(this.contacts.getConprenom());
                  var4.setPljTelephoneGestionnaire(this.contacts.getContelbur());
                  var4.setPljMailGestionnaire(this.contacts.getConmail1());
                  var4.setPljCodeBanque(this.contacts.getConnumbanque());
                  var4.setPljCodeGuichet(this.contacts.getConguichetbanque());
                  var4.setPljNumeroCompte(this.contacts.getConcomptebanque());
                  var4.setPljCleRib(this.contacts.getConclebanque());
                  var4.setPljIban(this.contacts.getConiban());
                  var4.setPljSwift(this.contacts.getConswift());
                  var5.modif(var4);
               }
            }
         }
      }

      this.testContact = false;
      this.showModalPanelBanque = false;
      this.showModalPanelContact = false;
   }

   public void deleteContact() throws HibernateException, NamingException {
      if (this.contacts != null) {
         this.contactDao.deletContact(this.contacts);
         this.lesContactsListe.remove(this.contacts);
         this.datamodelContact.setWrappedData(this.lesContactsListe);
         this.testContact = false;
         this.showModalPanelBanque = false;
         this.showModalPanelContact = false;
      }

   }

   public void annuleContact() {
      this.showModalPanelBanque = false;
      this.showModalPanelContact = false;
      this.showModalPanelConvention = false;
   }

   public void ajoutProcuration() {
      this.contactsProcuration = new Contacts();
      this.contactsProcuration.setConnompays(this.newtiers.getTienompays());
      this.urlphotoProcuration = "";
      this.urlsignatureProcuration = "";
      this.showModalPanelProcuration = true;
   }

   public void modifProcuration() {
      if (this.contactsProcuration != null) {
         this.showModalPanelProcuration = true;
      }

   }

   public void consultProcuration() {
      if (this.contactsProcuration != null) {
         this.showModalPanelProcuration = true;
      }

   }

   public void selectionProcuration() throws JDOMException, IOException, HibernateException, NamingException, SQLException {
      if (this.datamodelProcuration.isRowAvailable()) {
         this.contactsProcuration = (Contacts)this.datamodelProcuration.getRowData();
         this.affichePhotoProcuration();
         this.afficheSignatureProcuration();
         this.newtiers = this.contactsProcuration.getTiers();
      }

   }

   public void saveProcuration() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.contactsProcuration.getConnom() != null && !this.contactsProcuration.getConnom().isEmpty()) {
         this.contactsProcuration.setTiers(this.newtiers);
         String var1 = "";
         if (this.contactsProcuration.getCondatenaissance() != null) {
            DateFormat var2 = DateFormat.getDateInstance(3);
            var1 = var2.format(this.contactsProcuration.getCondatenaissance()).substring(0, 5);
         }

         this.contactsProcuration.setConanniversaire(var1);
         if (this.contactsProcuration.getConprenom() != null && !this.contacts.getConprenom().isEmpty()) {
            this.contactsProcuration.setConpatronyme(this.contactsProcuration.getConnom() + " " + this.contactsProcuration.getConprenom());
         } else {
            this.contactsProcuration.setConpatronyme(this.contactsProcuration.getConnom());
         }

         this.contactsProcuration.setConType(1);
         if (this.contactsProcuration.getConid() == 0L) {
            this.contactsProcuration.setCondatecreat(new Date());
            this.contactsProcuration.setConusercreat(this.usersLog.getUsrid());
            this.contactsProcuration = this.contactDao.insert(this.contactsProcuration);
            this.lesProcurationsListe.add(this.contactsProcuration);
            this.datamodelProcuration.setWrappedData(this.lesProcurationsListe);
         } else {
            this.contactsProcuration.setCondatemodif(new Date());
            this.contactsProcuration.setConusermodif(this.usersLog.getUsrid());
            this.contactsProcuration = this.contactDao.modif(this.contactsProcuration);
         }
      }

      this.showModalPanelProcuration = false;
   }

   public void deleteProcuration() throws HibernateException, NamingException {
      if (this.contactsProcuration != null) {
         this.contactDao.deletContact(this.contactsProcuration);
         this.lesProcurationsListe.remove(this.contactsProcuration);
         this.datamodelProcuration.setWrappedData(this.lesProcurationsListe);
      }

   }

   public void annuleProcuration() {
      this.showModalPanelProcuration = false;
   }

   public void ajoutTestament() {
      this.contactsTestament = new Contacts();
      this.contactsTestament.setConnompays(this.newtiers.getTienompays());
      this.showModalPanelTestament = true;
   }

   public void modifTestament() {
      if (this.contactsTestament != null) {
         this.showModalPanelTestament = true;
      }

   }

   public void selectionTestament() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelTestament.isRowAvailable()) {
         this.contactsTestament = (Contacts)this.datamodelTestament.getRowData();
         this.newtiers = this.contactsTestament.getTiers();
      }

   }

   public void saveTestament() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.contactsTestament.getConnom() != null && !this.contactsTestament.getConnom().isEmpty()) {
         this.contactsTestament.setTiers(this.newtiers);
         String var1 = "";
         if (this.contactsTestament.getCondatenaissance() != null) {
            DateFormat var2 = DateFormat.getDateInstance(3);
            var1 = var2.format(this.contactsTestament.getCondatenaissance()).substring(0, 5);
         }

         this.contactsTestament.setConanniversaire(var1);
         if (this.contactsTestament.getConprenom() != null && !this.contactsTestament.getConprenom().isEmpty()) {
            this.contactsTestament.setConpatronyme(this.contactsTestament.getConnom() + " " + this.contactsTestament.getConprenom());
         } else {
            this.contactsTestament.setConpatronyme(this.contactsTestament.getConnom());
         }

         this.contactsTestament.setConType(2);
         if (this.contactsTestament.getConid() == 0L) {
            this.contactsTestament.setCondatecreat(new Date());
            this.contactsTestament.setConusercreat(this.usersLog.getUsrid());
            this.contactsTestament = this.contactDao.insert(this.contactsTestament);
            this.lesTestamentsListe.add(this.contactsTestament);
            this.datamodelTestament.setWrappedData(this.lesTestamentsListe);
         } else {
            this.contactsTestament.setCondatemodif(new Date());
            this.contactsTestament.setConusermodif(this.usersLog.getUsrid());
            this.contactsTestament = this.contactDao.modif(this.contactsTestament);
         }
      }

      this.showModalPanelTestament = false;
   }

   public void deleteTestament() throws HibernateException, NamingException {
      if (this.contactsTestament != null) {
         this.contactDao.deletContact(this.contactsTestament);
         this.lesTestamentsListe.remove(this.contactsTestament);
         this.datamodelTestament.setWrappedData(this.lesTestamentsListe);
      }

   }

   public void annuleTestament() {
      this.showModalPanelTestament = false;
   }

   public void ajouterResponsable() {
      this.responsable = new Responsable();
      this.testDoubleResponsable = false;
      this.showModalPanelResponsable = true;
   }

   public void modifierResponsable() {
      if (this.responsable != null) {
         this.testDoubleResponsable = true;
         this.showModalPanelResponsable = true;
      }

   }

   public void consulterResponsable() throws JDOMException, IOException {
      if (this.getDatamodelResponsable().isRowAvailable()) {
         this.responsable = (Responsable)this.getDatamodelResponsable().getRowData();
         this.visibiliteBton = true;
         this.showModalPanelResponsable = true;
      } else {
         this.visibiliteBton = false;
      }

   }

   public void selectionResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.choixUsers != null && !this.choixUsers.isEmpty() && !this.choixUsers.equals("0")) {
         this.testDoubleResponsable = true;
         long var1 = Long.parseLong(this.choixUsers);
         if (this.lesResponsableListe.size() != 0) {
            for(int var3 = 0; var3 < this.lesResponsableListe.size(); ++var3) {
               if (((Responsable)this.lesResponsableListe.get(var3)).getRpbuserid() == var1) {
                  this.testDoubleResponsable = false;
                  break;
               }
            }
         } else {
            this.testDoubleResponsable = true;
         }

         if (this.testDoubleResponsable) {
            new Users();
            this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
            Users var4 = this.userDao.selectUserD(var1, (Session)null);
            if (var4 != null) {
               this.responsable.setRpbuserid(var4.getUsrid());
               this.responsable.setRpbnom(var4.getUsrNom());
               this.responsable.setRpbprenom(var4.getUsrPrenom());
               this.responsable.setRpbcategorie(var4.getUsrFonction());
               this.responsable.setRpbdefaut(0);
            }
         }
      } else {
         this.testDoubleResponsable = false;
      }

   }

   public void saveResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable.setTiers(this.newtiers);
      if (this.responsable.getRpbid() == 0L) {
         this.responsable.setRpbdatecreat(new Date());
         this.responsable.setRpbusercreat(this.usersLog.getUsrid());
         this.responsable = this.responsableDao.insert(this.responsable);
         this.lesResponsableListe.add(this.responsable);
         this.datamodelResponsable.setWrappedData(this.lesResponsableListe);
      } else {
         this.responsable.setRpbdatemodif(new Date());
         this.responsable.setRpbusermodif(this.usersLog.getUsrid());
         this.responsable = this.responsableDao.modif(this.responsable);
      }

      this.showModalPanelResponsable = false;
   }

   public void deleteResponsable() throws HibernateException, NamingException {
      if (this.responsable != null) {
         this.responsableDao.deletResponsable(this.responsable);
         this.visibiliteBton = false;
         this.chargeResponsable((Session)null);
      }

   }

   public void responsableDefaut() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.lesResponsableListe.size() != 0) {
         long var1 = this.responsable.getRpbid();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();

            for(int var5 = 0; var5 < this.lesResponsableListe.size(); ++var5) {
               new Responsable();
               Responsable var6 = (Responsable)this.lesResponsableListe.get(var5);
               if (var6.getRpbid() == var1) {
                  var6.setRpbdefaut(1);
               } else {
                  var6.setRpbdefaut(0);
               }

               this.responsableDao.modif(var6, var3);
            }

            var4.commit();
         } catch (HibernateException var10) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void annulerResponsable() {
      this.showModalPanelResponsable = false;
   }

   public void calculFamilleTiers() {
      this.newtiers.setTieexotva(0);
      this.newtiers.setTieexodouane(0);
      int var1;
      ObjetFamilleTiers var2;
      if (this.newtiers.getTietype().equalsIgnoreCase("0")) {
         if (this.lesFamillesFournisseursListe.size() != 0) {
            for(var1 = 0; var1 < this.lesFamillesFournisseursListe.size(); ++var1) {
               new ObjetFamilleTiers();
               var2 = (ObjetFamilleTiers)this.lesFamillesFournisseursListe.get(var1);
               if (this.newtiers.getTienomfamille().equalsIgnoreCase(var2.getLibelle())) {
                  if (!var2.getExoTva().equalsIgnoreCase("true") && !var2.getExoTva().equalsIgnoreCase("1")) {
                     if (!var2.getExoTva().equalsIgnoreCase("false") && !var2.getExoTva().equalsIgnoreCase("0")) {
                        this.newtiers.setTieexotva(2);
                     } else {
                        this.newtiers.setTieexotva(0);
                     }
                  } else {
                     this.newtiers.setTieexotva(1);
                  }

                  if (!var2.getExoDouane().equalsIgnoreCase("true") && !var2.getExoDouane().equalsIgnoreCase("1")) {
                     if (!var2.getExoDouane().equalsIgnoreCase("false") && !var2.getExoDouane().equalsIgnoreCase("0")) {
                        this.newtiers.setTieexodouane(2);
                     } else {
                        this.newtiers.setTieexodouane(0);
                     }
                  } else {
                     this.newtiers.setTieexodouane(1);
                  }
                  break;
               }
            }
         }
      } else if (this.lesFamillesClientsListe.size() != 0) {
         for(var1 = 0; var1 < this.lesFamillesClientsListe.size(); ++var1) {
            new ObjetFamilleTiers();
            var2 = (ObjetFamilleTiers)this.lesFamillesClientsListe.get(var1);
            if (this.newtiers.getTienomfamille().equalsIgnoreCase(var2.getLibelle())) {
               if (var2.getExoTva().equalsIgnoreCase("true")) {
                  this.newtiers.setTieexotva(1);
               } else {
                  this.newtiers.setTieexotva(0);
               }

               if (var2.getExoDouane().equalsIgnoreCase("true")) {
                  this.newtiers.setTieexodouane(1);
               } else {
                  this.newtiers.setTieexodouane(0);
               }
               break;
            }
         }
      }

   }

   public void calculReglementTiers() {
      this.newtiers.setTienbecheance(0);
      this.newtiers.setTienbarrondi(0);
      this.newtiers.setTiejournalreg("");
      this.newtiers.setTieconditionreg("");
      int var1;
      ObjetReglement var2;
      if (this.newtiers.getTietype().equalsIgnoreCase("0")) {
         if (this.lesReglementsFournisseur.size() != 0) {
            for(var1 = 0; var1 < this.lesReglementsFournisseur.size(); ++var1) {
               new ObjetReglement();
               var2 = (ObjetReglement)this.lesReglementsFournisseur.get(var1);
               if (this.newtiers.getTiemodereg().equalsIgnoreCase(var2.getLibelles())) {
                  if (var2.getNbjours().isEmpty()) {
                     this.newtiers.setTienbecheance(0);
                  } else {
                     this.newtiers.setTienbecheance(Integer.parseInt(var2.getNbjours()));
                  }

                  if (var2.getArrondis().isEmpty()) {
                     this.newtiers.setTienbarrondi(0);
                  } else {
                     this.newtiers.setTienbarrondi(Integer.parseInt(var2.getArrondis()));
                  }

                  this.newtiers.setTiejournalreg(var2.getJournals());
                  this.newtiers.setTieconditionreg(var2.getConditions());
                  break;
               }
            }
         }
      } else if (this.lesReglementsClient.size() != 0) {
         for(var1 = 0; var1 < this.lesReglementsClient.size(); ++var1) {
            new ObjetReglement();
            var2 = (ObjetReglement)this.lesReglementsClient.get(var1);
            if (this.newtiers.getTiemodereg().equalsIgnoreCase(var2.getLibelles())) {
               if (var2.getNbjours().isEmpty()) {
                  this.newtiers.setTienbecheance(0);
               } else {
                  this.newtiers.setTienbecheance(Integer.parseInt(var2.getNbjours()));
               }

               if (var2.getArrondis().isEmpty()) {
                  this.newtiers.setTienbarrondi(0);
               } else {
                  this.newtiers.setTienbarrondi(Integer.parseInt(var2.getArrondis()));
               }

               this.newtiers.setTiejournalreg(var2.getJournals());
               this.newtiers.setTieconditionreg(var2.getConditions());
               break;
            }
         }
      }

   }

   public void accesConventions() throws NamingException {
      this.exercicesVentes = new ExercicesVentes();
      ExercicesVentesDao var1 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentes = var1.recupererLastExo((Session)null);
      this.chargerLeslettresItems(this.exercicesVentes);
      this.conventionMedicalDao = new ConventionMedicalDao(this.baseLog, this.utilInitHibernate);
      this.lesConventionMedicale = new ArrayList();
      this.dataModelConvention = new ListDataModel();
      this.lesConventionMedicale = this.conventionMedicalDao.chargeConvention((Tiers)this.newtiers, (Session)null);
      this.dataModelConvention.setWrappedData(this.lesConventionMedicale);
      this.showModalPanelConvention = false;
      this.afficheButtConvention = false;
      this.var_action = 19;
      this.var_memo_action = this.var_action;
   }

   public void retourConventions() throws HibernateException, NamingException {
      this.newtiers = this.tiersDao.modif(this.newtiers);
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void chargerLeslettresItems(ExercicesVentes var1) throws NamingException {
      LettreMedicalDao var2 = new LettreMedicalDao(this.baseLog, this.utilInitHibernate);
      this.mesLettresItem = new ArrayList();
      this.mesLettresItem = var2.selectActifLettreItem(var1.getExevteId(), (Session)null);
   }

   public void selectionConvention() {
      this.conventionMedical = new ConventionMedical();
      if (this.getDataModelConvention().isRowAvailable()) {
         this.conventionMedical = (ConventionMedical)this.getDataModelConvention().getRowData();
         this.choixLettre = this.conventionMedical.getCvnLettre() + ":" + this.conventionMedical.getCvnLibelle();
         this.afficheButtConvention = true;
      }

   }

   public void ajouterConvention() throws ParseException, HibernateException, HibernateException, NamingException {
      if (this.mesLettresItem.size() == 0) {
         ExercicesVentesDao var1 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
         this.exercicesVentes = var1.recupererLastExo((Session)null);
         if (this.exercicesVentes != null) {
            this.chargerLeslettresItems(this.exercicesVentes);
         }
      }

      this.conventionMedical = new ConventionMedical();
      this.var_action_convention = 1;
      this.type_produit = 1;
      this.showModalPanelConvention = true;
   }

   public void modifierConvention() {
      if (this.conventionMedical != null) {
         this.var_action_convention = 2;
         this.showModalPanelConvention = true;
      }

   }

   public void consulterConvention() {
      if (this.conventionMedical != null) {
         this.var_action_convention = 3;
         this.showModalPanelConvention = true;
      }

   }

   public void supprimerConvention() throws NamingException {
      if (this.conventionMedical != null) {
         this.conventionMedicalDao.delete(this.conventionMedical);
         this.lesConventionMedicale.remove(this.conventionMedical);
         this.dataModelConvention.setWrappedData(this.lesConventionMedicale);
         this.var_action_convention = 0;
         this.afficheButtConvention = false;
      }

   }

   public void saveConvention() throws NamingException {
      if (this.choixLettre != null && !this.choixLettre.isEmpty() || this.conventionMedical.getCvnProduit() != null && !this.conventionMedical.getCvnProduit().isEmpty()) {
         this.conventionMedical.setTiers(this.newtiers);
         if (this.choixLettre != null && this.choixLettre.contains(":")) {
            String[] var1 = this.choixLettre.split(":");
            this.conventionMedical.setCvnLettre(var1[0]);
            if (this.conventionMedical.getCvnLettre() != null && !this.conventionMedical.getCvnLettre().isEmpty() && this.conventionMedical.getCvnLettre().equals("null")) {
               this.conventionMedical.setCvnLettre("");
            }
         } else {
            this.conventionMedical.setCvnLettre("");
         }

         if (this.conventionMedical.getCvnId() == 0L) {
            this.conventionMedical.setCvnDateCreat(new Date());
            this.conventionMedical.setCvnUserCreat(this.usersLog.getUsrid());
            this.conventionMedical = this.conventionMedicalDao.insert(this.conventionMedical);
            this.lesConventionMedicale.add(this.conventionMedical);
            this.dataModelConvention.setWrappedData(this.lesConventionMedicale);
         } else {
            this.conventionMedical.setCvnDateModif(new Date());
            this.conventionMedical.setCvnUserModif(this.usersLog.getUsrid());
            this.conventionMedical = this.conventionMedicalDao.modif(this.conventionMedical);
         }
      }

      this.var_action_convention = 0;
      this.afficheButtConvention = false;
      this.showModalPanelConvention = false;
   }

   public void accesPatientsPec() throws NamingException {
      PatientPecDao var1 = new PatientPecDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      this.dataModelConvention = new ListDataModel();
      List var2 = var1.chargerLesPatientsTiers(this.newtiers, (Session)null);
      this.dataModelConvention.setWrappedData(var2);
      this.var_action = 18;
      this.var_memo_action = this.var_action;
   }

   public void retourPatientsPec() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void accesAdhesion() throws NamingException {
      this.tiersAdherentDao = new TiersAdherentDao(this.baseLog, this.utilInitHibernate);
      this.lesAdherents = new ArrayList();
      this.dataModelAdherent = new ListDataModel();
      this.lesAdherents = this.tiersAdherentDao.listAdherentByTiers(this.newtiers, (Session)null);
      this.dataModelAdherent.setWrappedData(this.lesAdherents);
      this.showModalPanelAdherent = false;
      this.afficheButtAdherent = false;
      this.var_action = 20;
      this.var_memo_action = this.var_action;
   }

   public void selectionAdherent() {
      this.tiersAdherent = new TiersAdherent();
      if (this.getDataModelAdherent().isRowAvailable()) {
         this.tiersAdherent = (TiersAdherent)this.getDataModelAdherent().getRowData();
         this.afficheButtAdherent = true;
      }

   }

   public void ajouterAherent() {
      if (this.newtiers != null) {
         this.tiersAdherent = new TiersAdherent();
         this.showModalPanelAdherent = true;
      }

   }

   public void supprimerAdherent() throws HibernateException, NamingException {
      if (this.tiersAdherent != null) {
         this.tiersAdherentDao.delete(this.tiersAdherent);
         this.lesAdherents.remove(this.tiersAdherent);
         this.dataModelAdherent.setWrappedData(this.lesAdherents);
      }

   }

   public void validerAdherent() throws HibernateException, NamingException {
      if (this.newtiers != null && this.tiersAdherent.getTieadhId() == 0L) {
         this.tiersAdherent.setTiers(this.newtiers);
         this.tiersAdherent.setTieadhDateCreat(new Date());
         this.tiersAdherent.setTieadhRaisonSociale(this.tiersAdherent.getTieadhRaisonSociale().toUpperCase());
         this.tiersAdherent.setTieadhUserCreat(this.usersLog.getUsrid());
         this.tiersAdherent = this.tiersAdherentDao.insert(this.tiersAdherent);
         this.lesAdherents.add(this.tiersAdherent);
         this.dataModelAdherent.setWrappedData(this.lesAdherents);
      }

      this.showModalPanelAdherent = false;
   }

   public void fermerAdherent() {
      this.showModalPanelAdherent = false;
   }

   public void retourAdhesion() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void ajouterRemise() {
      this.baremes = new Baremes();
      this.baremes.setBarType(2);
      this.var_famille_produit = "";
      this.type_produit = 2;
      this.showModalPanelRemise = true;
   }

   public void modifierRemise() {
      if (this.baremes != null) {
         if (this.remiseFamille) {
            this.formRecherche.setMessageTexte("Cette remise est une remise affectée à la famille du tiers. Elle ne peut être modifiée à ce niveau mais uniquement au niveau des familles de clients");
            this.formRecherche.setShowModalPanelMessage(true);
         } else {
            this.showModalPanelRemise = true;
         }
      }

   }

   public void selectionRemise() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.dataModelBaremes.isRowAvailable()) {
         this.baremes = (Baremes)this.dataModelBaremes.getRowData();
         if (this.baremes.getBarCodeVte() != null && !this.baremes.getBarCodeVte().isEmpty()) {
            this.var_famille_produit = this.baremes.getBarCodeVte() + ":" + this.baremes.getBarLibelleVte();
         } else {
            this.var_famille_produit = "";
         }

         if (this.baremes.getBarCategorieTiers() != null && !this.baremes.getBarCategorieTiers().isEmpty()) {
            this.remiseFamille = true;
         } else {
            this.remiseFamille = false;
         }

         this.testRemise = true;
      }

   }

   public void saveRemise() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.var_famille_produit != null && !this.var_famille_produit.isEmpty() && this.var_famille_produit.contains(":")) {
         String[] var1 = this.var_famille_produit.split(":");
         this.baremes.setBarCodeVte(var1[0]);
         this.baremes.setBarLibelleVte(var1[1]);
      }

      if (this.baremes.getBarCodeProduit() != null && !this.baremes.getBarCodeProduit().isEmpty() || this.baremes.getBarCodeVte() != null && !this.baremes.getBarCodeVte().isEmpty()) {
         this.baremes.setBarIdTiers(this.newtiers.getTieid());
         this.baremes.setBarNomTiers(this.newtiers.getTieraisonsocialenom());
         this.baremes.setBarOptions(0);
         this.baremes.setBarCategorieTiers("");
         if (this.baremes.getBarId() == 0L) {
            this.baremes.setBarDateCreat(new Date());
            this.baremes.setBarUserCreat(this.usersLog.getUsrid());
            this.baremes = this.baremesDao.insert(this.baremes);
            this.lesBaremes.add(this.baremes);
            this.dataModelBaremes.setWrappedData(this.lesBaremes);
         } else {
            this.baremes.setBarDateModif(new Date());
            this.baremes.setBarUserModif(this.usersLog.getUsrid());
            this.baremes = this.baremesDao.modif(this.baremes);
         }
      }

      this.showModalPanelRemise = false;
      this.testRemise = false;
   }

   public void deleteRemise() throws HibernateException, NamingException {
      if (this.baremes != null && this.baremes != null) {
         if (this.remiseFamille) {
            this.formRecherche.setMessageTexte("Cette remise est une remise affectée à la famille du tiers. Elle ne peut être supprimée à ce niveau mais uniquement au niveau des familles de clients");
            this.formRecherche.setShowModalPanelMessage(true);
         } else {
            this.lesBaremes.remove(this.baremes);
            this.baremesDao.delete(this.baremes);
            this.visibiliteBton = false;
            this.dataModelBaremes.setWrappedData(this.lesBaremes);
            this.testRemise = false;
         }
      }

   }

   public void annulerRemise() {
      this.showModalPanelRemise = false;
      this.testRemise = false;
   }

   public void ajouterProduitExo() throws HibernateException, NamingException {
      new ArrayList();
      ProduitsVtesDao var2 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      List var1 = var2.selectAllProduits((Session)null);
      if (var1.size() != 0) {
         this.produits = new Produits();

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            this.produits = (Produits)var1.get(var3);
            if (this.produits.getProInactif() == 0) {
               boolean var4 = false;
               if (this.produits.isProExoTva()) {
                  var4 = true;
               } else if (this.lesProdExo.size() != 0) {
                  for(int var5 = 0; var5 < this.lesProdExo.size(); ++var5) {
                     if (((ObjetProdExoTva)this.lesProdExo.get(var5)).getCode().equals(this.produits.getProCode())) {
                        var4 = true;
                        break;
                     }
                  }
               }

               this.produits.setVar_select(var4);
            }
         }

         this.lesProdExo.clear();
         new ObjetProdExoTva();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            this.produits = (Produits)var1.get(var7);
            if (this.produits.getProInactif() == 0) {
               ObjetProdExoTva var6 = new ObjetProdExoTva();
               var6.setCode(this.produits.getProCode());
               var6.setLibelle(this.produits.getProLibClient());
               var6.setExoTva(this.produits.isVar_select());
               this.lesProdExo.add(var6);
            }
         }

         this.dataModelProdExoTva.setWrappedData(this.lesProdExo);
      }

   }

   public void validerProduitExo() {
      if (this.lesProdExo.size() != 0) {
         String var1 = "";
         new ObjetProdExoTva();

         for(int var3 = 0; var3 < this.lesProdExo.size(); ++var3) {
            ObjetProdExoTva var2 = (ObjetProdExoTva)this.lesProdExo.get(var3);
            if (var2.isExoTva()) {
               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + "#" + var2.getCode() + ":" + var2.getLibelle();
               } else {
                  var1 = var2.getCode() + ":" + var2.getLibelle();
               }
            }
         }

         this.newtiers.setTiepProdExoTva(var1);
      } else {
         this.newtiers.setTiepProdExoTva("");
      }

   }

   public void accesCampagne() throws HibernateException, NamingException, ParseException {
      if (this.newtiers != null) {
         this.var_action = 16;
         this.var_memo_action = this.var_action;
         this.campagneParticipantVentes = new CampagneParticipantVentes();
         this.showModalPanelParticipant = false;
      }

   }

   public void selectionCampagneTiers() {
      if (this.dataModelParticipants.isRowAvailable()) {
         this.campagneParticipantVentes = (CampagneParticipantVentes)this.dataModelParticipants.getRowData();
      }

   }

   public void selectionCampagneContact() {
      if (this.dataModelParticipantsContact.isRowAvailable()) {
         this.campagneParticipantVentes = (CampagneParticipantVentes)this.dataModelParticipantsContact.getRowData();
         this.showModalPanelParticipant = true;
      }

   }

   public void retourCampagne() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void fermerParticipant() {
      this.showModalPanelParticipant = false;
   }

   public void accesCadeaux() {
      if (this.newtiers != null) {
         this.var_action = 17;
         this.var_memo_action = this.var_action;
         this.cadeaux = new Cadeaux();
      }

   }

   public void retourCadeaux() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.type_produit == 1) {
         if (this.conventionMedical.getCvnProduit() != null && !this.conventionMedical.getCvnProduit().isEmpty()) {
            this.produits = this.formRecherche.rechercheProduitVente(this.conventionMedical.getCvnProduit(), 1, (OptionVentes)null);
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
      } else if (this.type_produit == 2 && this.baremes.getBarCodeProduit() != null && !this.baremes.getBarCodeProduit().isEmpty()) {
         this.produits = this.formRecherche.rechercheProduitVente(this.baremes.getBarCodeProduit(), 1, (OptionVentes)null);
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
      if (this.type_produit == 1) {
         if (this.produits != null) {
            this.conventionMedical.setCvnProduit(this.produits.getProCode());
            this.conventionMedical.setCvnLibelle(this.produits.getProLibClient());
         } else {
            this.annuleProduits();
         }
      } else if (this.type_produit == 2) {
         if (this.produits != null) {
            this.baremes.setBarCodeProduit(this.produits.getProCode());
            this.baremes.setBarLibelleProduit(this.produits.getProLibClient());
         } else {
            this.annuleProduits();
         }
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleProduits() {
      this.produits = null;
      if (this.type_produit == 1) {
         this.conventionMedical.setCvnProduit("");
         this.conventionMedical.setCvnLibelle("");
      } else if (this.type_produit == 2) {
         this.baremes.setBarCodeProduit("");
         this.baremes.setBarLibelleProduit("");
      }

      this.var_action = this.var_memo_action;
   }

   public void accesExtrait() throws HibernateException, NamingException, ParseException {
      this.lesEcritures = new ArrayList();
      this.cpteTiers = 1;
      UtilDate var1 = new UtilDate();
      String var2 = (new Date()).getYear() + 1900 + "-01-01";
      this.dateDebut = var1.stringToDateSQLLight(var2);
      this.dateFin = new Date();
      this.var_action = 8;
      this.var_memo_action = this.var_action;
   }

   public void retourExtrait() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void chargerLesEcritures() throws NamingException {
      if (this.exerciceSelectionne == null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         ExercicesComptableDao var2 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
         new ExercicesComptable();
         ExercicesComptable var3 = var2.recupererLastExo(var1);
         this.exerciceSelectionne = var3;
         this.exoCpte = var3.getExecpt_id();
         this.utilInitHibernate.closeSession();
      }

      if (this.ecrituresDao == null) {
         this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      }

      this.lesEcritures = new ArrayList();
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      String var7 = "";
      if (this.cpteTiers == 1) {
         var7 = this.getNewtiers().getTiecompte0();
      }

      if (this.cpteTiers == 2) {
         var7 = this.getNewtiers().getTiecompte1();
      }

      if (this.cpteTiers == 3) {
         var7 = this.getNewtiers().getTiecompte2();
      }

      if (this.cpteTiers == 4) {
         var7 = this.getNewtiers().getTiecompte3();
      }

      if (this.cpteTiers == 5) {
         var7 = this.getNewtiers().getTiecompte4();
      }

      if (this.cpteTiers == 6) {
         if (this.getNewtiers().getTiecompte0() != null && !this.getNewtiers().getTiecompte0().isEmpty()) {
            var7 = this.getNewtiers().getTiecompte0();
         }

         if (this.getNewtiers().getTiecompte1() != null && !this.getNewtiers().getTiecompte1().isEmpty()) {
            var7 = var7 + "," + this.getNewtiers().getTiecompte1();
         }

         if (this.getNewtiers().getTiecompte2() != null && !this.getNewtiers().getTiecompte2().isEmpty()) {
            var7 = var7 + "," + this.getNewtiers().getTiecompte2();
         }

         if (this.getNewtiers().getTiecompte3() != null && !this.getNewtiers().getTiecompte3().isEmpty()) {
            var7 = var7 + "," + this.getNewtiers().getTiecompte3();
         }

         if (this.getNewtiers().getTiecompte4() != null && !this.getNewtiers().getTiecompte4().isEmpty()) {
            var7 = var7 + "," + this.getNewtiers().getTiecompte4();
         }
      }

      var7 = "('" + var7 + "')";
      UtilDate var8 = new UtilDate();
      String var9 = var8.dateToStringSQLLight(this.dateDebut);
      String var4 = var8.dateToStringSQLLight(this.dateFin);
      this.lesEcritures = this.ecrituresDao.mesextraitTiers(var7, this.etatEcr, var9, var4, this.exerciceSelectionne, this.usersLog.getUsrJrxReserve());
      this.totalDeb = 0.0D;
      this.totalCred = 0.0D;
      this.SoldeDebCred = 0.0D;
      new Ecritures();

      for(int var6 = 0; var6 < this.lesEcritures.size(); ++var6) {
         Ecritures var5 = (Ecritures)this.lesEcritures.get(var6);
         this.totalDeb += var5.getEcrDebitPays();
         this.totalCred += var5.getEcrCreditPays();
      }

      this.SoldeDebCred = this.totalDeb - this.totalCred;
   }

   public void detailDepotAvance() throws HibernateException, NamingException {
      this.listDepot = new ArrayList();
      ReglementsDao var1 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.listDepot = var1.rechercheHistoDepot(this.newtiers.getTieid(), (Session)null);
      this.dataModelDepot.setWrappedData(this.listDepot);
      this.testRistourne = false;
      this.showModalPanelDepot = true;
      this.majTiersDepot();
   }

   public void fermerDepot() {
      this.showModalPanelDepot = false;
   }

   public void ajoutRistourne() {
      this.reglements = new Reglements();
      this.dateRistourne = new Date();
      this.montantRistourne = 0.0D;
      this.showModalPanelRistourne = true;
   }

   public void selectionRistourne() {
      if (this.dataModelDepot.isRowAvailable()) {
         this.reglements = (Reglements)this.dataModelDepot.getRowData();
         this.dateRistourne = this.reglements.getRglDateReg();
         this.montantRistourne = this.reglements.getRglRecette();
         if (this.reglements.getRglIdDocument() == 0L) {
            this.testRistourne = true;
         } else {
            this.testRistourne = false;
         }
      }

   }

   public void modifRistourne() {
      if (this.reglements != null) {
         this.showModalPanelRistourne = true;
      }

   }

   public void deleteRistourne() throws HibernateException, NamingException {
      if (this.reglements != null) {
         ReglementsDao var1 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         var1.delete(this.reglements);
         this.listDepot.remove(this.reglements);
         this.dataModelDepot.setWrappedData(this.listDepot);
         this.testRistourne = false;
         this.majTiersDepot();
      }

   }

   public void saveRistourne() throws HibernateException, NamingException {
      ReglementsDao var1 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      UtilDate var2 = new UtilDate();
      new ExercicesCaisse();
      ExercicesCaisseDao var4 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
      ExercicesCaisse var3 = var4.recupererLastExo((Session)null);
      if (var3 != null) {
         String var5 = "";
         String var6 = "";
         String var7 = "";
         this.reglements.setRglDateReg(this.dateRistourne);
         if (this.reglements.getRglDateReg() == null) {
            this.reglements.setRglDateReg(new Date());
         }

         String var8 = "";
         if (this.reglements.getRglId() == 0L) {
            var8 = this.calculChrono.numCompose(this.reglements.getRglDateReg(), 61, "", (Session)null);
         } else {
            var8 = this.reglements.getRglNum();
         }

         this.reglements.setRglOperation("14");
         this.reglements.setRglActivite("");
         this.reglements.setRglBanqueTireur("");
         this.reglements.setRglBudget("");
         this.reglements.setRglBon("");
         this.reglements.setRglCategorie(20);
         this.reglements.setRglCodeCaiss((String)null);
         this.reglements.setRglLibCaiss((String)null);
         this.reglements.setRglCodeEmetrice((String)null);
         this.reglements.setRglLibEmetrice((String)null);
         this.reglements.setRglCodeReceptrice((String)null);
         this.reglements.setRglLibReceptrice((String)null);
         this.reglements.setRglDateCreation(new Date());
         this.reglements.setRglDateImp((Date)null);
         this.reglements.setRglDateTransfert((Date)null);
         this.reglements.setRglDateValeur((Date)null);
         this.reglements.setRglDateRemise((Date)null);
         this.reglements.setRglDepartement("");
         this.reglements.setRglDepense(0.0D);
         this.reglements.setRglDevise(this.structureLog.getStrdevise());
         this.reglements.setRglDossier("");
         this.reglements.setRglFormatDevise(this.structureLog.getStrformatdevise());
         this.reglements.setRglDocument("");
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(0L);
         this.reglements.setRglIdTiers(this.newtiers.getTieid());
         this.reglements.setRglDepotTiers(2);
         this.reglements.setRglLibelle("Initialisation Ristourne");
         this.reglements.setRglMode("");
         this.reglements.setRglModele("");
         this.reglements.setRglNumChqBdx("");
         this.reglements.setRglNatureDoc(0);
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglNomTiers(this.newtiers.getTieraisonsocialenom());
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
         this.reglements.setRglNum(var8);
         this.reglements.setRglObjet("Historique");
         this.reglements.setRglParc("");
         this.reglements.setRglPdv("");
         this.reglements.setRglRendu(0.0D);
         this.reglements.setRglRecette(this.montantRistourne);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglRegion("");
         this.reglements.setRglSecteur("");
         this.reglements.setRglSerie("");
         this.reglements.setRglService("");
         this.reglements.setRglSite("");
         this.reglements.setRglTrf(0);
         this.reglements.setRglTypeReg(0);
         this.reglements.setRglTypeTiers(0);
         this.reglements.setRglUserCreat(this.usersLog.getUsrid());
         this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
         this.reglements.setRglUserModif(0L);
         this.reglements.setRglIdResponsable(0L);
         this.reglements.setRglNomResponsable("");
         this.reglements.setRglIdCommercial(0L);
         this.reglements.setRglNomCommercial("");
         this.reglements.setRglIdEquipe(0L);
         this.reglements.setRglNomEquipe("");
         if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
            var5 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
         } else {
            var5 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
         }

         var6 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
         this.reglements.setRglPeriode(var5 + ":" + var6);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         var7 = var2.dateToStringSQLLight(this.reglements.getRglDateReg());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var7);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var7);
         this.reglements.setExercicesCaisse(var3);
         if (this.reglements.getRglId() == 0L) {
            this.reglements = var1.insert(this.reglements);
            this.listDepot.add(this.reglements);
            this.dataModelDepot.setWrappedData(this.listDepot);
         } else {
            this.reglements = var1.modifier(this.reglements);
         }

         this.majTiersDepot();
         this.testRistourne = false;
         this.showModalPanelRistourne = false;
      }

   }

   public void annulerRistourne() {
      this.testRistourne = false;
      this.showModalPanelRistourne = false;
      this.showModalPanelTransfert = false;
   }

   public void majTiersDepot() throws HibernateException, NamingException {
      double var1 = 0.0D;

      for(int var3 = 0; var3 < this.listDepot.size(); ++var3) {
         if (((Reglements)this.listDepot.get(var3)).getRglTypeReg() == 90) {
            if (((Reglements)this.listDepot.get(var3)).getRglCategorie() == 10) {
               var1 = var1 - ((Reglements)this.listDepot.get(var3)).getRglRecette() + ((Reglements)this.listDepot.get(var3)).getRglDepense();
            } else {
               var1 = var1 - ((Reglements)this.listDepot.get(var3)).getRglRecette() - ((Reglements)this.listDepot.get(var3)).getRglDepense();
            }
         } else {
            var1 = var1 + ((Reglements)this.listDepot.get(var3)).getRglRecette() - ((Reglements)this.listDepot.get(var3)).getRglDepense();
         }
      }

      if (var1 != this.newtiers.getTiedepotavance()) {
         this.newtiers.setTiedepotavance(var1);
         this.newtiers = this.tiersDao.modif(this.newtiers);
      }

   }

   public void transfertRistourne() throws HibernateException, NamingException {
      this.montantMax = this.newtiers.getTiedepotavance();
      if (this.montantMax != 0.0D) {
         this.montantRistourne = 0.0D;
         this.listBeneficiaireItems = new ArrayList();
         this.listBeneficiaireItems = this.tiersDao.chargerLesClientsByIdItems(0, (Session)null);
         this.idBeneficiaire = 0L;
         this.showModalPanelTransfert = true;
      }

   }

   public void valideTransfert() throws HibernateException, NamingException {
      if (this.montantRistourne != 0.0D && this.idBeneficiaire != 0L) {
         String var1 = "";

         for(int var2 = 0; var2 < this.listBeneficiaireItems.size(); ++var2) {
            long var3 = Long.parseLong(((SelectItem)this.listBeneficiaireItems.get(var2)).getValue().toString());
            if (var3 == this.idBeneficiaire) {
               var1 = ((SelectItem)this.listBeneficiaireItems.get(var2)).getLabel().toString();
               break;
            }
         }

         if (this.montantRistourne > this.montantMax) {
            this.montantRistourne = this.montantMax;
         }

         ReglementsDao var11 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         UtilDate var12 = new UtilDate();
         new ExercicesCaisse();
         ExercicesCaisseDao var5 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
         ExercicesCaisse var4 = var5.recupererLastExo((Session)null);
         if (var4 != null) {
            String var6 = "";
            String var7 = "";
            String var8 = "";
            this.reglements = new Reglements();
            this.reglements.setRglDateReg(this.dateRistourne);
            if (this.reglements.getRglDateReg() == null) {
               this.reglements.setRglDateReg(new Date());
            }

            String var9 = "";
            var9 = this.calculChrono.numCompose(this.reglements.getRglDateReg(), 61, "", (Session)null);
            this.reglements.setRglOperation("14");
            this.reglements.setRglActivite("");
            this.reglements.setRglBanqueTireur("");
            this.reglements.setRglBudget("");
            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(20);
            this.reglements.setRglCodeCaiss((String)null);
            this.reglements.setRglLibCaiss((String)null);
            this.reglements.setRglCodeEmetrice((String)null);
            this.reglements.setRglLibEmetrice((String)null);
            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDateRemise((Date)null);
            this.reglements.setRglDepartement("");
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglDevise(this.structureLog.getStrdevise());
            this.reglements.setRglDossier("");
            this.reglements.setRglFormatDevise(this.structureLog.getStrformatdevise());
            this.reglements.setRglDocument("");
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(0L);
            this.reglements.setRglIdTiers(this.newtiers.getTieid());
            this.reglements.setRglDepotTiers(2);
            this.reglements.setRglLibelle("Transfert Ristourne vers " + var1);
            this.reglements.setRglMode("");
            this.reglements.setRglModele("");
            this.reglements.setRglNumChqBdx("");
            this.reglements.setRglNatureDoc(0);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglNomTiers(this.newtiers.getTieraisonsocialenom());
            this.reglements.setRglIdContact(0L);
            this.reglements.setRglNomContact("");
            this.reglements.setRglNum(var9);
            this.reglements.setRglObjet("Transfert");
            this.reglements.setRglParc("");
            this.reglements.setRglPdv("");
            this.reglements.setRglRendu(0.0D);
            this.reglements.setRglRecette(this.montantRistourne * -1.0D);
            this.reglements.setRglTimbre(0.0D);
            this.reglements.setRglRegion("");
            this.reglements.setRglSecteur("");
            this.reglements.setRglSerie("");
            this.reglements.setRglService("");
            this.reglements.setRglSite("");
            this.reglements.setRglTrf(0);
            this.reglements.setRglTypeReg(0);
            this.reglements.setRglTypeTiers(0);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
            this.reglements.setRglUserModif(0L);
            this.reglements.setRglIdResponsable(0L);
            this.reglements.setRglNomResponsable("");
            this.reglements.setRglIdCommercial(0L);
            this.reglements.setRglNomCommercial("");
            this.reglements.setRglIdEquipe(0L);
            this.reglements.setRglNomEquipe("");
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var6 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var6 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            var7 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var6 + ":" + var7);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            var8 = var12.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var8);
            this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
            this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var8);
            this.reglements.setExercicesCaisse(var4);
            this.reglements = var11.insert(this.reglements);
            this.listDepot.add(this.reglements);
            this.dataModelDepot.setWrappedData(this.listDepot);
            this.majTiersDepot();
            this.reglements = new Reglements();
            this.reglements.setRglDateReg(this.dateRistourne);
            if (this.reglements.getRglDateReg() == null) {
               this.reglements.setRglDateReg(new Date());
            }

            this.reglements.setRglOperation("14");
            this.reglements.setRglActivite("");
            this.reglements.setRglBanqueTireur("");
            this.reglements.setRglBudget("");
            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(20);
            this.reglements.setRglCodeCaiss((String)null);
            this.reglements.setRglLibCaiss((String)null);
            this.reglements.setRglCodeEmetrice((String)null);
            this.reglements.setRglLibEmetrice((String)null);
            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDateRemise((Date)null);
            this.reglements.setRglDepartement("");
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglDevise(this.structureLog.getStrdevise());
            this.reglements.setRglDossier("");
            this.reglements.setRglFormatDevise(this.structureLog.getStrformatdevise());
            this.reglements.setRglDocument("");
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(0L);
            this.reglements.setRglIdTiers(this.idBeneficiaire);
            this.reglements.setRglDepotTiers(2);
            this.reglements.setRglLibelle("Reception Ristourne  de " + this.newtiers.getTieraisonsocialenom());
            this.reglements.setRglMode("");
            this.reglements.setRglModele("");
            this.reglements.setRglNumChqBdx("");
            this.reglements.setRglNatureDoc(0);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglNomTiers(var1);
            this.reglements.setRglIdContact(0L);
            this.reglements.setRglNomContact("");
            this.reglements.setRglNum(var9);
            this.reglements.setRglObjet("Réception");
            this.reglements.setRglParc("");
            this.reglements.setRglPdv("");
            this.reglements.setRglRendu(0.0D);
            this.reglements.setRglRecette(this.montantRistourne);
            this.reglements.setRglTimbre(0.0D);
            this.reglements.setRglRegion("");
            this.reglements.setRglSecteur("");
            this.reglements.setRglSerie("");
            this.reglements.setRglService("");
            this.reglements.setRglSite("");
            this.reglements.setRglTrf(0);
            this.reglements.setRglTypeReg(0);
            this.reglements.setRglTypeTiers(0);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
            this.reglements.setRglUserModif(0L);
            this.reglements.setRglIdResponsable(0L);
            this.reglements.setRglNomResponsable("");
            this.reglements.setRglIdCommercial(0L);
            this.reglements.setRglNomCommercial("");
            this.reglements.setRglIdEquipe(0L);
            this.reglements.setRglNomEquipe("");
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var6 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var6 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            var7 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var6 + ":" + var7);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            var8 = var12.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var8);
            this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
            this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var8);
            this.reglements.setExercicesCaisse(var4);
            this.reglements = var11.insert(this.reglements);
            new Tiers();
            Tiers var10 = this.newtiers;
            this.newtiers = this.tiersDao.selectTierD(this.idBeneficiaire);
            if (this.newtiers != null) {
               this.listDepot = var11.rechercheHistoDepot(this.newtiers.getTieid(), (Session)null);
               this.majTiersDepot();
            }

            this.newtiers = var10;
            this.listDepot = var11.rechercheHistoDepot(this.newtiers.getTieid(), (Session)null);
         }
      }

      this.showModalPanelTransfert = false;
   }

   public void accesDocuments() throws HibernateException, NamingException, ParseException {
      this.mesSeries = new ArrayList();
      this.mesFamilles = new ArrayList();
      this.lesDocumentsDetail = new ArrayList();
      this.dataModelDocuments = new ListDataModel();
      this.lesDocumentsEntete = new ArrayList();
      this.dataModelDocumentsEntete = new ListDataModel();
      this.choixFamilles = "0";
      UtilDate var1 = new UtilDate();
      UsersChronoDao var2 = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      Session var3;
      if (this.typeTiers == 0) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
         new ExercicesAchats();
         ExercicesAchatsDao var5 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
         ExercicesAchats var4 = var5.recupererLastExo(var3);
         if (var4 != null) {
            FamillesProduitsAchatsDao var6 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
            this.mesFamilles = var6.chargerFamilleProduitAchatsUtilItems(var4.getExeachId(), var3);
            this.mesSeries = var2.selectSerieByUserAchats(this.usersLog, var3);
            if (this.mesSeries.size() != 0) {
               this.choixSeries = ((SelectItem)this.mesSeries.get(0)).getValue().toString();
            } else {
               this.choixSeries = "";
            }

            this.choixDocument = 15;
            String var7 = (new Date()).getYear() + 1900 + "-01-01";
            this.dateDebut = var1.stringToDateSQLLight(var7);
            this.dateFin = new Date();
            this.var_action = 6;
            this.var_memo_action = this.var_action;
            this.rechercherLesDocuments(var3);
         }

         this.utilInitHibernate.closeSession();
      } else if (this.typeTiers == 3 || this.typeTiers == 7) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         this.exercicesVentes = new ExercicesVentes();
         ExercicesVentesDao var8 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
         this.exercicesVentes = var8.recupererLastExo(var3);
         if (this.exercicesVentes != null) {
            FamillesProduitsVentesDao var9 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
            this.mesFamilles = var9.chargerFamilleProduitVentesUtilItems(this.exercicesVentes.getExevteId(), var3);
            this.mesSeries = var2.selectSerieByUserVentes(this.usersLog, var3);
            if (this.mesSeries.size() != 0) {
               this.choixSeries = ((SelectItem)this.mesSeries.get(0)).getValue().toString();
            } else {
               this.choixSeries = "";
            }

            this.choixDocument = 251;
            String var10 = (new Date()).getYear() + 1900 + "-01-01";
            this.dateDebut = var1.stringToDateSQLLight(var10);
            this.dateFin = new Date();
            this.var_action = 7;
            this.var_memo_action = this.var_action;
            this.rechercherLesDocuments(var3);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void accesCatalogue() throws HibernateException, NamingException {
      if (this.typeTiers == 0 && this.newtiers != null) {
         this.dataModelCatalogue = new ListDataModel();
         this.lesProduits = new ArrayList();
         ProduitsFournisseurDao var1 = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         this.lesProduits = var1.selectProdCatalogue(this.newtiers, var2);
         if (this.lesProduits.size() != 0) {
            new ProduitsFournisseur();
            ProduitsDepotDao var4 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            float var6 = 0.0F;

            for(int var7 = 0; var7 < this.lesProduits.size(); ++var7) {
               ProduitsFournisseur var3 = (ProduitsFournisseur)this.lesProduits.get(var7);
               this.produits = var3.getProduits();
               var6 = 0.0F;
               List var5 = var4.selectProdDepByprod(this.produits, var2);
               if (var5.size() != 0) {
                  for(int var8 = 0; var8 < var5.size(); ++var8) {
                     var6 += ((ProduitsDepot)var5.get(var8)).getProdepQteStk();
                  }
               }

               var3.setQteTotaleStock(var6);
            }
         }

         this.utilInitHibernate.closeSession();
         this.dataModelCatalogue.setWrappedData(this.lesProduits);
         this.dataModelCatalogueFichier = new ListDataModel();
         this.lesCataloguesFichiers = new ArrayList();
         String var9 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers" + File.separator + "tier_" + this.newtiers.getTieid() + File.separator;
         File var10 = new File(var9);
         if (!var10.exists()) {
            var10.mkdir();
         }

         this.cheminCatalogue = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Tiers" + File.separator + "tier_" + this.newtiers.getTieid() + File.separator + "catalogue" + File.separator;
         var10 = new File(this.cheminCatalogue);
         if (!var10.exists()) {
            var10.mkdir();
         }

         String[] var11 = var10.list();
         if (var11 != null) {
            var11 = this.triAlphabetique(var11, var11.length);

            for(int var12 = 0; var12 < var11.length; ++var12) {
               this.lesCataloguesFichiers.add(var11[var12]);
            }
         }

         this.dataModelCatalogueFichier.setWrappedData(this.lesCataloguesFichiers);
         this.fichierUrl = null;
         this.var_action = 9;
      }

   }

   public void selectionnerCatalogue() {
      if (this.dataModelCatalogueFichier.isRowAvailable()) {
         this.nomCatalogue = (String)this.dataModelCatalogueFichier.getRowData();
      }

   }

   public void ajouterCatalogue() {
      this.uploadedFile = null;
      this.nomCatalogue = null;
      this.showModalPanelAjoutFile = true;
   }

   public void annulerCatalogue() {
      this.showModalPanelAjoutFile = false;
   }

   public void validerCatalogue() {
      try {
         if (this.uploadedFile != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            if (var1.toString().contains(".")) {
               if (var1.toString().contains(" ")) {
                  String var2 = var1.toString();
                  String var3 = "";

                  for(int var4 = 0; var4 < var2.length(); ++var4) {
                     String var5 = var2.substring(var4, var4 + 1);
                     if (var5.equals(" ")) {
                        var3 = var3 + "_";
                     } else {
                        var3 = var3 + var2.substring(var4, var4 + 1);
                     }
                  }

                  var1 = var3;
               }

               this.nomCatalogue = var1;
               File var7 = new File(this.cheminCatalogue + var1);
               var7.delete();
               File var8 = this.utilDownload.uniqueFile(new File(this.cheminCatalogue), var1);
               this.utilDownload.write(var8, this.uploadedFile.getInputStream());
               this.lesCataloguesFichiers.add(var1);
               this.dataModelCatalogueFichier.setWrappedData(this.lesCataloguesFichiers);
            }
         }
      } catch (IOException var6) {
      }

      this.showModalPanelAjoutFile = false;
   }

   public void consulterCatalogue() throws MalformedURLException, IOException {
      if (this.nomCatalogue != null && !this.nomCatalogue.isEmpty()) {
         this.fichierUrl = this.utilDownload.convertirFichierUtl(this.cheminCatalogue + this.nomCatalogue, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(this.nomCatalogue);
         this.showModalPanelPj = true;
      }

   }

   public void fermerVisuCatalogue() {
      this.showModalPanelPj = false;
   }

   public void supprimerCatalogue() {
      if (this.nomCatalogue != null && !this.nomCatalogue.isEmpty()) {
         String var1 = this.cheminCatalogue + this.nomCatalogue;
         File var2 = new File(var1);
         var2.delete();
         this.lesCataloguesFichiers.remove(this.nomCatalogue);
         this.dataModelCatalogueFichier.setWrappedData(this.lesCataloguesFichiers);
         this.nomCatalogue = "";
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

   public void recalculPrix() throws HibernateException, NamingException {
      if (this.lesProduits.size() != 0) {
         UtilNombre var1 = new UtilNombre(this.structureLog.getStrdevise());
         ProduitsFournisseurDao var2 = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
         float var3 = 0.0F;
         float var4 = 0.0F;
         new Devise();
         DeviseDao var6 = new DeviseDao(this.baseLog, this.utilInitHibernate);
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();
            int var9 = 0;

            while(true) {
               if (var9 >= this.lesProduits.size()) {
                  var8.commit();
                  break;
               }

               new ProduitsFournisseur();
               ProduitsFournisseur var10 = (ProduitsFournisseur)this.lesProduits.get(var9);
               if (var10.getProfouDevise() != null && !var10.getProfouDevise().isEmpty()) {
                  if (var10.getProfouPa() != 0.0D) {
                     Devise var5;
                     if (var10.getProfouDevise().equals(this.structureLog.getStrdevise())) {
                        var10.setProfouPaLocal(var10.getProfouPa());
                        var5 = var6.chargerLesDevises(this.structureLog.getStrdevise(), var7);
                        var3 = 0.0F;
                        if (var5 != null) {
                           var3 = var5.getDevTaux1();
                        }

                        if (var3 == 0.0F) {
                           var3 = var1.deviseTaux1(this.structureLog.getStrdevise(), new Date());
                        }

                        var10.setProfouPaEuro(var10.getProfouPa() * (double)var3);
                     } else {
                        var5 = var6.chargerLesDevises(var10.getProfouDevise(), var7);
                        var3 = 0.0F;
                        if (var5 != null) {
                           var3 = var5.getDevTaux1();
                        }

                        if (var3 == 0.0F) {
                           var3 = var1.deviseTaux1(var10.getProfouDevise(), new Date());
                        }

                        var10.setProfouPaEuro(var10.getProfouPa() * (double)var3);
                        var5 = var6.chargerLesDevises(this.structureLog.getStrdevise(), var7);
                        var4 = 0.0F;
                        if (var5 != null) {
                           var4 = var5.getDevTaux1();
                        }

                        if (var4 == 0.0F) {
                           var4 = var1.deviseTaux2(this.structureLog.getStrdevise(), new Date());
                        }

                        var10.setProfouPaLocal(var10.getProfouPaEuro() * (double)var4);
                     }
                  }

                  var2.modif(var10, var7);
               }

               ++var9;
            }
         } catch (HibernateException var14) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var14;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.accesCatalogue();
      }

   }

   public void retourDocuments() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void rechercherLesDocuments() throws HibernateException, NamingException, ParseException {
      this.rechercherLesDocuments((Session)null);
   }

   public void rechercherLesDocuments(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesDocumentsDetail.clear();
      this.lesDocumentsEntete.clear();
      this.var_qte = 0.0F;
      this.var_total = 0.0D;
      this.var_reglement = 0.0D;
      this.var_solde = 0.0D;
      UtilDate var2 = new UtilDate();
      String var3 = var2.dateToStringSQLLight(this.dateDebut) + " 00:00:00";
      String var4 = var2.dateToStringSQLLight(this.dateFin) + " 23:59:59";
      String var5 = "";
      if (this.choixFamilles.equals("0")) {
         var5 = "0";
      } else if (this.choixFamilles.contains(":")) {
         String[] var6 = this.choixFamilles.split(":");
         var5 = var6[0];
      }

      String var8 = "";
      int var7;
      if (this.mesSeries.size() != 0) {
         if (this.choixSeries.equals("*")) {
            for(var7 = 0; var7 < this.mesSeries.size(); ++var7) {
               if (((SelectItem)this.mesSeries.get(var7)).getValue().toString() != null && !((SelectItem)this.mesSeries.get(var7)).getValue().toString().isEmpty() && !((SelectItem)this.mesSeries.get(var7)).getValue().toString().equals("*")) {
                  if (var8 != null && !var8.isEmpty()) {
                     var8 = var8 + ",'" + ((SelectItem)this.mesSeries.get(var7)).getValue().toString() + "'";
                  } else {
                     var8 = "'" + ((SelectItem)this.mesSeries.get(var7)).getValue().toString() + "'";
                  }
               }
            }
         } else {
            var8 = "'" + this.choixSeries + "'";
         }
      } else {
         this.choixSeries = "";
         var8 = "";
      }

      if (this.choixDocument == 11) {
         this.cotationAchats(var3, var4, var5, var8, var1);
      } else if (this.choixDocument == 12) {
         this.commandeAchats(var3, var4, var5, var8, var1);
      } else if (this.choixDocument == 13) {
         this.receptionAchats(var3, var4, var5, var8, var1);
      } else if (this.choixDocument == 14) {
         this.retourAchats(var3, var4, var5, var8, var1);
      } else if (this.choixDocument == 15) {
         this.factureAchats(var3, var4, 0, var5, var8, var1);
         this.avoirAchats(var3, var4, var5, var8, var1);
         this.noteDebitAchats(var3, var4, 0, var5, var8, var1);
         this.fraisAchats(var3, var4, 0, var5, var8, var1);
         this.reglement(var2, var8, var1);
      } else if (this.choixDocument == 151) {
         this.factureAchats(var3, var4, 1, var5, var8, var1);
         this.avoirAchats(var3, var4, var5, var8, var1);
         this.noteDebitAchats(var3, var4, 1, var5, var8, var1);
         this.fraisAchats(var3, var4, 1, var5, var8, var1);
      } else if (this.choixDocument == 18) {
         this.fraisAchats(var3, var4, 0, var5, var8, var1);
      } else if (this.choixDocument == 21) {
         this.devisVentes(var3, var4, var5, var8, var1);
      } else if (this.choixDocument == 22) {
         this.commandeVentes(var3, var4, var5, var8, var1);
      } else if (this.choixDocument == 23) {
         this.livraisonVentes(var3, var4, 0, var5, var8, var1);
      } else if (this.choixDocument == 231) {
         this.livraisonVentes(var3, var4, 1, var5, var8, var1);
      } else if (this.choixDocument == 24) {
         this.retourVentes(var3, var4, var5, var8, var1);
      } else if (this.choixDocument == 25) {
         this.factureVentes(var3, var4, 0, var5, var8, var1);
         this.avoirVentes(var3, var4, var5, var8, var1);
         this.noteDebitVentes(var3, var4, 0, var5, var8, var1);
      } else if (this.choixDocument == 251) {
         this.factureVentes(var3, var4, 1, var5, var8, var1);
         this.avoirVentes(var3, var4, var5, var8, var1);
         this.noteDebitVentes(var3, var4, 1, var5, var8, var1);
      } else if (this.choixDocument == 60) {
         this.reglement(var2, var8, var1);
         if (this.typeTiers == 0) {
            this.avoirAchats(var3, var4, var5, var8, var1);
         } else if (this.typeTiers == 3 || this.typeTiers == 7) {
            this.avoirVentes(var3, var4, var5, var8, var1);
         }
      }

      this.var_total = 0.0D;
      this.var_reglement = 0.0D;
      this.var_solde = 0.0D;
      if (this.lesDocumentsEntete.size() != 0) {
         for(var7 = 0; var7 < this.lesDocumentsEntete.size(); ++var7) {
            this.documentEntete = (DocumentEntete)this.lesDocumentsEntete.get(var7);
            this.var_total += this.documentEntete.getDocTotTtc();
            this.var_reglement += this.documentEntete.getDocTotReglement();
            this.documentEntete.setDocAPayer(this.var_total - this.var_reglement);
         }
      }

      this.var_solde = this.var_total - this.var_reglement;
      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
      this.calculStatistique();
   }

   public void cotationAchats(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      CotationLigneAchatsDao var7 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerLesMvtsTiers(this.newtiers, var1, var2, var4, var5);
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            new CotationLigneAchats();
            CotationLigneAchats var9 = (CotationLigneAchats)var6.get(var8);
            DocumentEntete var10 = new DocumentEntete();
            Stock var11 = new Stock();
            var11.setStk_lib_type("Cotation");
            var11.setStkFamille(var9.getCotligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var11.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var9.getCotligCode().startsWith(this.choixProduit))) {
               boolean var12 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var13 = 0; var13 < this.lesDocumentsEntete.size(); ++var13) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var13)).getDocNum().equals(var9.getCotationEnteteAchats().getCotNum())) {
                        var12 = true;
                        break;
                     }
                  }
               } else {
                  var12 = false;
               }

               if (!var12) {
                  var10.setVar_lib_nat("Cotation");
                  var10.setDocEtat(var9.getCotationEnteteAchats().getCotEtat());
                  var10.setDocIdCreateur(var9.getCotationEnteteAchats().getTiers().getTieid());
                  var10.setDocDate(var9.getCotationEnteteAchats().getCotDate());
                  var10.setDocNum(var9.getCotationEnteteAchats().getCotNum());
                  var10.setDocSerie(var9.getCotationEnteteAchats().getCotSerie());
                  var10.setDocNomTiers(var9.getCotationEnteteAchats().getCotNomTiers());
                  var10.setDocObject(var9.getCotationEnteteAchats().getCotObject());
                  var10.setDocSource("");
                  var10.setDocNomContact(var9.getCotationEnteteAchats().getCotNomContact());
                  var10.setDocNomCaissier("");
                  var10.setDocNomResponsable(var9.getCotationEnteteAchats().getCotNomResponsable());
                  var10.setDocTotHt(var9.getCotationEnteteAchats().getCotTotHt());
                  var10.setDocTotTva(var9.getCotationEnteteAchats().getCotTotTva());
                  var10.setDocTotTtc(var9.getCotationEnteteAchats().getCotTotTtc());
                  var10.setDocTotReglement(0.0D);
                  var10.setDocAPayer(0.0D);
                  this.lesDocumentsEntete.add(var10);
               }

               var11.setStk_date_mvt(var9.getCotationEnteteAchats().getCotDate());
               var11.setStk_numero(var9.getCotationEnteteAchats().getCotNum());
               var11.setStk_code_produit(var9.getCotligCode());
               var11.setStkLibelle(var9.getCotligLibelle());
               var11.setStk_code_depot("");
               var11.setStkPuRem(var9.getCotligPuRem());
               var11.setStk_pump(var9.getCotligPump());
               var11.setStk_qte_progress(var9.getCotligQte());
               var11.setStkPt(var9.getCotligPt());
               this.var_qte += var11.getStk_qte_progress();
               this.lesDocumentsDetail.add(var11);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void commandeAchats(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      CommandeLigneAchatsDao var7 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerLesMvtsTiers(this.newtiers, var1, var2, var4, var5);
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            new CommandeLigneAchats();
            CommandeLigneAchats var9 = (CommandeLigneAchats)var6.get(var8);
            DocumentEntete var10 = new DocumentEntete();
            Stock var11 = new Stock();
            var11.setStk_lib_type("Commande");
            var11.setStkFamille(var9.getCmdligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var11.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var9.getCmdligCode().startsWith(this.choixProduit))) {
               boolean var12 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var13 = 0; var13 < this.lesDocumentsEntete.size(); ++var13) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var13)).getDocNum().equals(var9.getCommandeEnteteAchats().getCmdNum())) {
                        var12 = true;
                        break;
                     }
                  }
               } else {
                  var12 = false;
               }

               if (!var12) {
                  var10.setVar_lib_nat("Commande");
                  var10.setDocEtat(var9.getCommandeEnteteAchats().getCmdEtat());
                  var10.setDocIdCreateur(var9.getCommandeEnteteAchats().getTiers().getTieid());
                  var10.setDocDate(var9.getCommandeEnteteAchats().getCmdDate());
                  var10.setDocNum(var9.getCommandeEnteteAchats().getCmdNum());
                  var10.setDocSerie(var9.getCommandeEnteteAchats().getCmdSerie());
                  var10.setDocNomTiers(var9.getCommandeEnteteAchats().getCmdNomTiers());
                  var10.setDocObject(var9.getCommandeEnteteAchats().getCmdObject());
                  var10.setDocSource("");
                  var10.setDocNomContact(var9.getCommandeEnteteAchats().getCmdNomContact());
                  var10.setDocNomCaissier("");
                  var10.setDocNomResponsable(var9.getCommandeEnteteAchats().getCmdNomResponsable());
                  var10.setDocTotHt(var9.getCommandeEnteteAchats().getCmdTotHt());
                  var10.setDocTotTva(var9.getCommandeEnteteAchats().getCmdTotTva());
                  var10.setDocTotTtc(var9.getCommandeEnteteAchats().getCmdTotTtc());
                  var10.setDocTotReglement(0.0D);
                  var10.setDocAPayer(0.0D);
                  this.lesDocumentsEntete.add(var10);
               }

               var11.setStk_date_mvt(var9.getCommandeEnteteAchats().getCmdDate());
               var11.setStk_numero(var9.getCommandeEnteteAchats().getCmdNum());
               var11.setStk_code_produit(var9.getCmdligCode());
               var11.setStkLibelle(var9.getCmdligLibelle());
               var11.setStk_code_depot(var9.getCmdligDepot());
               var11.setStkPuRem(var9.getCmdligPuRem());
               var11.setStk_pump(var9.getCmdligPump());
               var11.setStk_qte_progress(var9.getCmdligQte());
               var11.setStkPt(var9.getCmdligPt());
               this.var_qte += var11.getStk_qte_progress();
               this.lesDocumentsDetail.add(var11);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void receptionAchats(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      ReceptionLigneAchatsDao var7 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerLesMvtsTiers(this.newtiers, var1, var2, var4, var5);
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            new ReceptionLigneAchats();
            ReceptionLigneAchats var9 = (ReceptionLigneAchats)var6.get(var8);
            DocumentEntete var10 = new DocumentEntete();
            Stock var11 = new Stock();
            var11.setStk_lib_type("Réception");
            var11.setStkFamille(var9.getRecligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var11.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var9.getRecligCode().startsWith(this.choixProduit))) {
               boolean var12 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var13 = 0; var13 < this.lesDocumentsEntete.size(); ++var13) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var13)).getDocNum().equals(var9.getReceptionEnteteAchats().getRecNum())) {
                        var12 = true;
                        break;
                     }
                  }
               } else {
                  var12 = false;
               }

               if (!var12) {
                  var10.setVar_lib_nat("Réception");
                  var10.setDocEtat(var9.getReceptionEnteteAchats().getRecEtat());
                  var10.setDocIdCreateur(var9.getReceptionEnteteAchats().getTiers().getTieid());
                  var10.setDocDate(var9.getReceptionEnteteAchats().getRecDate());
                  var10.setDocNum(var9.getReceptionEnteteAchats().getRecNum());
                  var10.setDocSerie(var9.getReceptionEnteteAchats().getRecSerie());
                  var10.setDocNomTiers(var9.getReceptionEnteteAchats().getRecNomTiers());
                  var10.setDocObject(var9.getReceptionEnteteAchats().getRecObject());
                  var10.setDocSource("");
                  var10.setDocNomContact(var9.getReceptionEnteteAchats().getRecNomContact());
                  var10.setDocNomCaissier("");
                  var10.setDocNomResponsable(var9.getReceptionEnteteAchats().getRecNomResponsable());
                  var10.setDocTotHt(var9.getReceptionEnteteAchats().getRecTotHt());
                  var10.setDocTotTva(var9.getReceptionEnteteAchats().getRecTotTva());
                  var10.setDocTotTtc(var9.getReceptionEnteteAchats().getRecTotTtc());
                  var10.setDocTotReglement(0.0D);
                  var10.setDocAPayer(0.0D);
                  this.lesDocumentsEntete.add(var10);
               }

               var11.setStk_date_mvt(var9.getReceptionEnteteAchats().getRecDate());
               var11.setStk_numero(var9.getReceptionEnteteAchats().getRecNum());
               var11.setStk_code_produit(var9.getRecligCode());
               var11.setStkLibelle(var9.getRecligLibelle());
               var11.setStk_code_depot(var9.getRecligDepot());
               var11.setStkPuRem(var9.getRecligPuRem());
               var11.setStk_pump(var9.getRecligPump());
               var11.setStk_qte_progress(var9.getRecligQte());
               var11.setStkPt(var9.getRecligPt());
               this.var_qte += var11.getStk_qte_progress();
               this.lesDocumentsDetail.add(var11);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void retourAchats(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      RetourLigneAchatsDao var7 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerLesMvtsTiers(this.newtiers, var1, var2, var4, var5);
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            new RetourLigneAchats();
            RetourLigneAchats var9 = (RetourLigneAchats)var6.get(var8);
            DocumentEntete var10 = new DocumentEntete();
            Stock var11 = new Stock();
            var11.setStk_lib_type("Retour");
            var11.setStkFamille(var9.getBrfligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var11.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var9.getBrfligCode().startsWith(this.choixProduit))) {
               boolean var12 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var13 = 0; var13 < this.lesDocumentsEntete.size(); ++var13) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var13)).getDocNum().equals(var9.getRetourEnteteAchats().getBrfNum())) {
                        var12 = true;
                        break;
                     }
                  }
               } else {
                  var12 = false;
               }

               if (!var12) {
                  var10.setVar_lib_nat("Retour");
                  var10.setDocEtat(var9.getRetourEnteteAchats().getBrfEtat());
                  var10.setDocIdCreateur(var9.getRetourEnteteAchats().getTiers().getTieid());
                  var10.setDocDate(var9.getRetourEnteteAchats().getBrfDate());
                  var10.setDocNum(var9.getRetourEnteteAchats().getBrfNum());
                  var10.setDocSerie(var9.getRetourEnteteAchats().getBrfSerie());
                  var10.setDocNomTiers(var9.getRetourEnteteAchats().getBrfNomTiers());
                  var10.setDocObject(var9.getRetourEnteteAchats().getBrfObject());
                  var10.setDocSource("");
                  var10.setDocNomContact(var9.getRetourEnteteAchats().getBrfNomContact());
                  var10.setDocNomCaissier("");
                  var10.setDocNomResponsable(var9.getRetourEnteteAchats().getBrfNomResponsable());
                  var10.setDocTotHt(var9.getRetourEnteteAchats().getBrfTotHt());
                  var10.setDocTotTva(var9.getRetourEnteteAchats().getBrfTotTva());
                  var10.setDocTotTtc(var9.getRetourEnteteAchats().getBrfTotTtc());
                  var10.setDocTotReglement(0.0D);
                  var10.setDocAPayer(0.0D);
                  this.lesDocumentsEntete.add(var10);
               }

               var11.setStk_date_mvt(var9.getRetourEnteteAchats().getBrfDate());
               var11.setStk_numero(var9.getRetourEnteteAchats().getBrfNum());
               var11.setStk_code_produit(var9.getBrfligCode());
               var11.setStkLibelle(var9.getBrfligLibelle());
               var11.setStk_code_depot(var9.getBrfligDepot());
               var11.setStkPuRem(var9.getBrfligPuRem());
               var11.setStk_pump(var9.getBrfligPump());
               var11.setStk_qte_progress(var9.getBrfligQte());
               var11.setStkPt(var9.getBrfligPt());
               this.var_qte += var11.getStk_qte_progress();
               this.lesDocumentsDetail.add(var11);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void noteDebitAchats(String var1, String var2, int var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      new ArrayList();
      NoteDebitLigneAchatsDao var8 = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var7 = var8.chargerLesMvtsTiers(this.newtiers, var1, var2, var5, var6);
      if (var7.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            new NoteDebitLigneAchats();
            NoteDebitLigneAchats var10 = (NoteDebitLigneAchats)var7.get(var9);
            if (var3 == 0 || var3 == 1 && var10.getNoteDebitEnteteAchats().getNdfSolde() == 0) {
               DocumentEntete var11 = new DocumentEntete();
               Stock var12 = new Stock();
               var12.setStk_lib_type("NoteDebit");
               var12.setStkFamille(var10.getNdfligFamille());
               if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var12.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var10.getNdfligCode().startsWith(this.choixProduit))) {
                  boolean var13 = false;
                  if (this.lesDocumentsEntete.size() != 0) {
                     for(int var14 = 0; var14 < this.lesDocumentsEntete.size(); ++var14) {
                        if (((DocumentEntete)this.lesDocumentsEntete.get(var14)).getDocNum().equals(var10.getNoteDebitEnteteAchats().getNdfNum())) {
                           var13 = true;
                           break;
                        }
                     }
                  } else {
                     var13 = false;
                  }

                  if (!var13) {
                     var11.setVar_lib_nat("Note débit");
                     var11.setDocEtat(var10.getNoteDebitEnteteAchats().getNdfEtat());
                     var11.setDocIdCreateur(var10.getNoteDebitEnteteAchats().getTiers().getTieid());
                     var11.setDocDate(var10.getNoteDebitEnteteAchats().getNdfDate());
                     var11.setDocNum(var10.getNoteDebitEnteteAchats().getNdfNum());
                     var11.setDocSerie(var10.getNoteDebitEnteteAchats().getNdfSerie());
                     var11.setDocNomTiers(var10.getNoteDebitEnteteAchats().getNdfNomTiers());
                     var11.setDocObject(var10.getNoteDebitEnteteAchats().getNdfObject());
                     var11.setDocSource("");
                     var11.setDocNomContact(var10.getNoteDebitEnteteAchats().getNdfNomContact());
                     var11.setDocNomCaissier("");
                     var11.setDocNomResponsable(var10.getNoteDebitEnteteAchats().getNdfNomResponsable());
                     var11.setDocTotHt(var10.getNoteDebitEnteteAchats().getNdfTotHt());
                     var11.setDocTotTva(var10.getNoteDebitEnteteAchats().getNdfTotTva());
                     var11.setDocTotTtc(var10.getNoteDebitEnteteAchats().getNdfTotTtc());
                     var11.setDocTotReglement(var10.getNoteDebitEnteteAchats().getNdfTotReglement());
                     var11.setDocAPayer(var10.getNoteDebitEnteteAchats().getNdfTotTtc() - var10.getNoteDebitEnteteAchats().getNdfTotReglement());
                     this.lesDocumentsEntete.add(var11);
                  }

                  var12.setStk_date_mvt(var10.getNoteDebitEnteteAchats().getNdfDate());
                  var12.setStk_numero(var10.getNoteDebitEnteteAchats().getNdfNum());
                  var12.setStk_code_produit(var10.getNdfligCode());
                  var12.setStkLibelle(var10.getNdfligLibelle());
                  var12.setStk_code_depot("");
                  var12.setStkPuRem(var10.getNdfligPuRem());
                  var12.setStk_pump(var10.getNdfligPump());
                  var12.setStk_qte_progress(var10.getNdfligQte());
                  var12.setStkPt(var10.getNdfligPt());
                  this.var_qte += var12.getStk_qte_progress();
                  this.lesDocumentsDetail.add(var12);
               }
            }
         }
      }

   }

   public void factureAchats(String var1, String var2, int var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      new ArrayList();
      FactureLigneAchatsDao var8 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var7 = var8.chargerLesMvtsTiers(this.newtiers, var1, var2, var5, var6);
      if (var7.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            new FactureLigneAchats();
            FactureLigneAchats var10 = (FactureLigneAchats)var7.get(var9);
            if (var3 == 0 || var3 == 1 && var10.getFactureEnteteAchats().getFcfSolde() == 0) {
               DocumentEntete var11 = new DocumentEntete();
               Stock var12 = new Stock();
               var12.setStk_lib_type("Facture");
               var12.setStkFamille(var10.getFcfligFamille());
               if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var12.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var10.getFcfligCode().startsWith(this.choixProduit))) {
                  boolean var13 = false;
                  if (this.lesDocumentsEntete.size() != 0) {
                     for(int var14 = 0; var14 < this.lesDocumentsEntete.size(); ++var14) {
                        if (((DocumentEntete)this.lesDocumentsEntete.get(var14)).getDocNum().equals(var10.getFactureEnteteAchats().getFcfNum())) {
                           var13 = true;
                           break;
                        }
                     }
                  } else {
                     var13 = false;
                  }

                  if (!var13) {
                     var11.setVar_lib_nat("Facture");
                     var11.setDocEtat(var10.getFactureEnteteAchats().getFcfEtat());
                     var11.setDocIdCreateur(var10.getFactureEnteteAchats().getTiers().getTieid());
                     var11.setDocDate(var10.getFactureEnteteAchats().getFcfDate());
                     var11.setDocNum(var10.getFactureEnteteAchats().getFcfNum());
                     var11.setDocSerie(var10.getFactureEnteteAchats().getFcfSerie());
                     var11.setDocNomTiers(var10.getFactureEnteteAchats().getFcfNomTiers());
                     var11.setDocObject(var10.getFactureEnteteAchats().getFcfObject());
                     var11.setDocSource("");
                     var11.setDocNomContact(var10.getFactureEnteteAchats().getFcfNomContact());
                     var11.setDocNomCaissier("");
                     var11.setDocNomResponsable(var10.getFactureEnteteAchats().getFcfNomResponsable());
                     var11.setDocTotHt(var10.getFactureEnteteAchats().getFcfTotHt());
                     var11.setDocTotTva(var10.getFactureEnteteAchats().getFcfTotTva());
                     var11.setDocTotTtc(var10.getFactureEnteteAchats().getFcfTotTtc());
                     var11.setDocTotReglement(var10.getFactureEnteteAchats().getFcfTotReglement());
                     var11.setDocAPayer(var10.getFactureEnteteAchats().getFcfTotTtc() - var10.getFactureEnteteAchats().getFcfTotReglement());
                     this.lesDocumentsEntete.add(var11);
                  }

                  var12.setStk_date_mvt(var10.getFactureEnteteAchats().getFcfDate());
                  var12.setStk_numero(var10.getFactureEnteteAchats().getFcfNum());
                  var12.setStk_code_produit(var10.getFcfligCode());
                  var12.setStkLibelle(var10.getFcfligLibelle());
                  var12.setStk_code_depot(var10.getFcfligDepot());
                  var12.setStkPuRem(var10.getFcfligPuRem());
                  var12.setStk_pump(var10.getFcfligPump());
                  var12.setStk_qte_progress(var10.getFcfligQte());
                  var12.setStkPt(var10.getFcfligPt());
                  this.var_qte += var12.getStk_qte_progress();
                  this.lesDocumentsDetail.add(var12);
               }
            }
         }
      }

   }

   public void avoirAchats(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      AvoirLigneAchatsDao var7 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerLesMvtsTiers(this.newtiers, var1, var2, var4, var5);
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            new AvoirLigneAchats();
            AvoirLigneAchats var9 = (AvoirLigneAchats)var6.get(var8);
            DocumentEntete var10 = new DocumentEntete();
            Stock var11 = new Stock();
            var11.setStk_lib_type("Avoir");
            var11.setStkFamille(var9.getAvfligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var11.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var9.getAvfligCode().startsWith(this.choixProduit))) {
               boolean var12 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var13 = 0; var13 < this.lesDocumentsEntete.size(); ++var13) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var13)).getDocNum().equals(var9.getAvoirEnteteAchats().getAvfNum())) {
                        var12 = true;
                        break;
                     }
                  }
               } else {
                  var12 = false;
               }

               if (!var12) {
                  var10.setVar_lib_nat("Avoir");
                  var10.setDocEtat(var9.getAvoirEnteteAchats().getAvfEtat());
                  var10.setDocIdCreateur(var9.getAvoirEnteteAchats().getTiers().getTieid());
                  var10.setDocDate(var9.getAvoirEnteteAchats().getAvfDate());
                  var10.setDocNum(var9.getAvoirEnteteAchats().getAvfNum());
                  var10.setDocSerie(var9.getAvoirEnteteAchats().getAvfSerie());
                  var10.setDocNomTiers(var9.getAvoirEnteteAchats().getAvfNomTiers());
                  var10.setDocObject(var9.getAvoirEnteteAchats().getAvfObject());
                  var10.setDocSource("");
                  var10.setDocNomContact(var9.getAvoirEnteteAchats().getAvfNomContact());
                  var10.setDocNomCaissier("");
                  var10.setDocNomResponsable(var9.getAvoirEnteteAchats().getAvfNomResponsable());
                  var10.setDocTotHt(var9.getAvoirEnteteAchats().getAvfTotHt() * -1.0D);
                  var10.setDocTotTva(var9.getAvoirEnteteAchats().getAvfTotTva() * -1.0D);
                  var10.setDocTotTtc(var9.getAvoirEnteteAchats().getAvfTotTtc() * -1.0D);
                  var10.setDocTotReglement(0.0D);
                  var10.setDocAPayer(0.0D);
                  this.lesDocumentsEntete.add(var10);
               }

               var11.setStk_date_mvt(var9.getAvoirEnteteAchats().getAvfDate());
               var11.setStk_numero(var9.getAvoirEnteteAchats().getAvfNum());
               var11.setStk_code_produit(var9.getAvfligCode());
               var11.setStkLibelle(var9.getAvfligLibelle());
               var11.setStk_code_depot("");
               var11.setStkPuRem(var9.getAvfligPuRem() * -1.0D);
               var11.setStk_pump(var9.getAvfligPump() * -1.0D);
               var11.setStk_qte_progress(var9.getAvfligQte() * -1.0F);
               var11.setStkPt(var9.getAvfligPt() * -1.0D);
               this.var_qte += var11.getStk_qte_progress();
               this.lesDocumentsDetail.add(var11);
            }
         }
      }

   }

   public void fraisAchats(String var1, String var2, int var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      new ArrayList();
      FraisLigneAchatsDao var8 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      List var7 = var8.chargerLesMvtsTiers(this.newtiers, var1, var2, var5, var6);
      if (var7.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            new FraisLigneAchats();
            FraisLigneAchats var10 = (FraisLigneAchats)var7.get(var9);
            if (var3 == 0 || var3 == 1 && var10.getFraisEnteteAchats().getFsfSolde() == 0) {
               DocumentEntete var11 = new DocumentEntete();
               Stock var12 = new Stock();
               var12.setStk_lib_type("Frais");
               var12.setStkFamille(var10.getFsfligFamille());
               if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var12.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var10.getFsfligCode().startsWith(this.choixProduit))) {
                  boolean var13 = false;
                  if (this.lesDocumentsEntete.size() != 0) {
                     for(int var14 = 0; var14 < this.lesDocumentsEntete.size(); ++var14) {
                        if (((DocumentEntete)this.lesDocumentsEntete.get(var14)).getDocNum().equals(var10.getFraisEnteteAchats().getFsfNum())) {
                           var13 = true;
                           break;
                        }
                     }
                  } else {
                     var13 = false;
                  }

                  if (!var13) {
                     var11.setVar_lib_nat("Frais");
                     var11.setDocEtat(var10.getFraisEnteteAchats().getFsfEtat());
                     var11.setDocIdCreateur(var10.getFraisEnteteAchats().getTiers().getTieid());
                     var11.setDocDate(var10.getFraisEnteteAchats().getFsfDate());
                     var11.setDocNum(var10.getFraisEnteteAchats().getFsfNum());
                     var11.setDocSerie(var10.getFraisEnteteAchats().getFsfSerie());
                     var11.setDocNomTiers(var10.getFraisEnteteAchats().getFsfNomTiers());
                     var11.setDocObject(var10.getFraisEnteteAchats().getFsfObject());
                     var11.setDocSource("");
                     var11.setDocNomContact(var10.getFraisEnteteAchats().getFsfNomContact());
                     var11.setDocNomCaissier("");
                     var11.setDocNomResponsable(var10.getFraisEnteteAchats().getFsfNomResponsable());
                     var11.setDocTotHt(var10.getFraisEnteteAchats().getFsfTotHt());
                     var11.setDocTotTva(var10.getFraisEnteteAchats().getFsfTotTva());
                     var11.setDocTotTtc(var10.getFraisEnteteAchats().getFsfTotTtc());
                     var11.setDocTotReglement(var10.getFraisEnteteAchats().getFsfTotReglement());
                     var11.setDocAPayer(var10.getFraisEnteteAchats().getFsfTotTtc() - var10.getFraisEnteteAchats().getFsfTotReglement());
                     this.lesDocumentsEntete.add(var11);
                  }

                  var12.setStk_date_mvt(var10.getFraisEnteteAchats().getFsfDate());
                  var12.setStk_numero(var10.getFraisEnteteAchats().getFsfNum());
                  var12.setStk_code_produit(var10.getFsfligCode());
                  var12.setStkLibelle(var10.getFsfligLibelle());
                  var12.setStk_code_depot("");
                  var12.setStkPuRem(var10.getFsfligPuRem());
                  var12.setStk_pump(var10.getFsfligPump());
                  var12.setStk_qte_progress(var10.getFsfligQte());
                  var12.setStkPt(var10.getFsfligPt());
                  this.var_qte += var12.getStk_qte_progress();
                  this.lesDocumentsDetail.add(var12);
               }
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void devisVentes(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      DevisLigneVentesDao var7 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerLesMvtsTiers(this.newtiers, var1, var2, var4, var5);
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            new DevisLigneVentes();
            DevisLigneVentes var9 = (DevisLigneVentes)var6.get(var8);
            DocumentEntete var10 = new DocumentEntete();
            Stock var11 = new Stock();
            var11.setStk_lib_type("Devis");
            var11.setStkFamille(var9.getDvsligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var11.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var9.getDvsligCode().startsWith(this.choixProduit))) {
               boolean var12 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var13 = 0; var13 < this.lesDocumentsEntete.size(); ++var13) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var13)).getDocNum().equals(var9.getDevisEnteteVentes().getDvsNum())) {
                        var12 = true;
                        break;
                     }
                  }
               } else {
                  var12 = false;
               }

               if (!var12) {
                  var10.setVar_lib_nat("Devis");
                  var10.setDocEtat(var9.getDevisEnteteVentes().getDvsEtat());
                  var10.setDocIdCreateur(var9.getDevisEnteteVentes().getTiers().getTieid());
                  var10.setDocDate(var9.getDevisEnteteVentes().getDvsDate());
                  var10.setDocNum(var9.getDevisEnteteVentes().getDvsNum());
                  var10.setDocSerie(var9.getDevisEnteteVentes().getDvsSerie());
                  var10.setDocNomTiers(var9.getDevisEnteteVentes().getDvsNomTiers());
                  var10.setDocObject(var9.getDevisEnteteVentes().getDvsObject());
                  var10.setDocSource(var9.getDevisEnteteVentes().getDvsSource());
                  var10.setDocNomContact(var9.getDevisEnteteVentes().getDvsNomContact());
                  var10.setDocNomCaissier(var9.getDevisEnteteVentes().getDvsNomCommercial());
                  var10.setDocNomResponsable(var9.getDevisEnteteVentes().getDvsNomResponsable());
                  var10.setDocTotHt(var9.getDevisEnteteVentes().getDvsTotHt());
                  var10.setDocTotTva(var9.getDevisEnteteVentes().getDvsTotTva());
                  var10.setDocTotTtc(var9.getDevisEnteteVentes().getDvsTotTtc());
                  var10.setDocTotReglement(0.0D);
                  var10.setDocAPayer(0.0D);
                  this.lesDocumentsEntete.add(var10);
               }

               var11.setStk_date_mvt(var9.getDevisEnteteVentes().getDvsDate());
               var11.setStk_numero(var9.getDevisEnteteVentes().getDvsNum());
               var11.setStk_code_produit(var9.getDvsligCode());
               var11.setStkLibelle(var9.getDvsligLibelle());
               var11.setStk_code_depot(var9.getDvsligDepot());
               var11.setStkPuRem(var9.getDvsligPuRem());
               var11.setStk_pump(var9.getDvsligPump());
               var11.setStk_qte_progress(var9.getDvsligQte());
               var11.setStkPt(var9.getDvsligPt());
               this.var_qte += var11.getStk_qte_progress();
               this.lesDocumentsDetail.add(var11);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void commandeVentes(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      CommandeLigneVentesDao var7 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerLesMvtsTiers(this.newtiers, var1, var2, var4, var5);
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            new CommandeLigneVentes();
            CommandeLigneVentes var9 = (CommandeLigneVentes)var6.get(var8);
            DocumentEntete var10 = new DocumentEntete();
            Stock var11 = new Stock();
            var11.setStk_lib_type("Commande");
            var11.setStkFamille(var9.getBcmligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var11.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var9.getBcmligCode().startsWith(this.choixProduit))) {
               boolean var12 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var13 = 0; var13 < this.lesDocumentsEntete.size(); ++var13) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var13)).getDocNum().equals(var9.getCommandeEnteteVentes().getBcmNum())) {
                        var12 = true;
                        break;
                     }
                  }
               } else {
                  var12 = false;
               }

               if (!var12) {
                  var10.setVar_lib_nat("Commande");
                  var10.setDocEtat(var9.getCommandeEnteteVentes().getBcmEtat());
                  var10.setDocIdCreateur(var9.getCommandeEnteteVentes().getTiers().getTieid());
                  var10.setDocDate(var9.getCommandeEnteteVentes().getBcmDate());
                  var10.setDocNum(var9.getCommandeEnteteVentes().getBcmNum());
                  var10.setDocSerie(var9.getCommandeEnteteVentes().getBcmSerie());
                  var10.setDocNomTiers(var9.getCommandeEnteteVentes().getBcmNomTiers());
                  var10.setDocObject(var9.getCommandeEnteteVentes().getBcmObject());
                  var10.setDocSource(var9.getCommandeEnteteVentes().getBcmSource());
                  var10.setDocNomContact(var9.getCommandeEnteteVentes().getBcmNomContact());
                  var10.setDocNomCaissier(var9.getCommandeEnteteVentes().getBcmNomCommercial());
                  var10.setDocNomResponsable(var9.getCommandeEnteteVentes().getBcmNomResponsable());
                  var10.setDocTotHt(var9.getCommandeEnteteVentes().getBcmTotHt());
                  var10.setDocTotTva(var9.getCommandeEnteteVentes().getBcmTotTva());
                  var10.setDocTotTtc(var9.getCommandeEnteteVentes().getBcmTotTtc());
                  var10.setDocTotReglement(0.0D);
                  var10.setDocAPayer(0.0D);
                  this.lesDocumentsEntete.add(var10);
               }

               var11.setStk_date_mvt(var9.getCommandeEnteteVentes().getBcmDate());
               var11.setStk_numero(var9.getCommandeEnteteVentes().getBcmNum());
               var11.setStk_code_produit(var9.getBcmligCode());
               var11.setStkLibelle(var9.getBcmligLibelle());
               var11.setStk_code_depot(var9.getBcmligDepot());
               var11.setStkPuRem(var9.getBcmligPuRem());
               var11.setStk_pump(var9.getBcmligPump());
               var11.setStk_qte_progress(var9.getBcmligQte());
               var11.setStkPt(var9.getBcmligPt());
               this.var_qte += var11.getStk_qte_progress();
               this.lesDocumentsDetail.add(var11);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void livraisonVentes(String var1, String var2, int var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      new ArrayList();
      LivraisonLigneVentesDao var8 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var7;
      if (var3 == 1) {
         var7 = var8.chargerLesMvtsTiersNonFacture(this.newtiers, var1, var2, var5, var6);
      } else {
         var7 = var8.chargerLesMvtsTiers(this.newtiers, var1, var2, var5, var6);
      }

      if (var7.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            new LivraisonLigneVentes();
            LivraisonLigneVentes var10 = (LivraisonLigneVentes)var7.get(var9);
            DocumentEntete var11 = new DocumentEntete();
            Stock var12 = new Stock();
            var12.setStk_lib_type("Livraison");
            var12.setStkFamille(var10.getBlvligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var12.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var10.getBlvligCode().startsWith(this.choixProduit))) {
               boolean var13 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var14 = 0; var14 < this.lesDocumentsEntete.size(); ++var14) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var14)).getDocNum().equals(var10.getLivraisonEnteteVentes().getBlvNum())) {
                        var13 = true;
                        break;
                     }
                  }
               } else {
                  var13 = false;
               }

               if (!var13) {
                  var11.setVar_lib_nat("Livraison");
                  var11.setDocEtat(var10.getLivraisonEnteteVentes().getBlvEtat());
                  var11.setDocIdCreateur(var10.getLivraisonEnteteVentes().getTiers().getTieid());
                  var11.setDocDate(var10.getLivraisonEnteteVentes().getBlvDate());
                  var11.setDocNum(var10.getLivraisonEnteteVentes().getBlvNum());
                  var11.setDocSerie(var10.getLivraisonEnteteVentes().getBlvSerie());
                  var11.setDocNomTiers(var10.getLivraisonEnteteVentes().getBlvNomTiers());
                  var11.setDocObject(var10.getLivraisonEnteteVentes().getBlvObject());
                  var11.setDocSource(var10.getLivraisonEnteteVentes().getBlvSource());
                  var11.setDocNomContact(var10.getLivraisonEnteteVentes().getBlvNomContact());
                  var11.setDocNomCaissier(var10.getLivraisonEnteteVentes().getBlvNomCommercial());
                  var11.setDocNomResponsable(var10.getLivraisonEnteteVentes().getBlvNomResponsable());
                  var11.setDocTotHt(var10.getLivraisonEnteteVentes().getBlvTotHt());
                  var11.setDocTotTva(var10.getLivraisonEnteteVentes().getBlvTotTva());
                  var11.setDocTotTtc(var10.getLivraisonEnteteVentes().getBlvTotTtc());
                  var11.setDocTotReglement(0.0D);
                  var11.setDocAPayer(0.0D);
                  this.lesDocumentsEntete.add(var11);
               }

               var12.setStk_date_mvt(var10.getLivraisonEnteteVentes().getBlvDate());
               var12.setStk_numero(var10.getLivraisonEnteteVentes().getBlvNum());
               var12.setStk_code_produit(var10.getBlvligCode());
               var12.setStkLibelle(var10.getBlvligLibelle());
               var12.setStk_code_depot(var10.getBlvligDepot());
               var12.setStkPuRem(var10.getBlvligPuRem());
               var12.setStk_pump(var10.getBlvligPump());
               var12.setStk_qte_progress(var10.getBlvligQte());
               var12.setStkPt(var10.getBlvligPt());
               this.var_qte += var12.getStk_qte_progress();
               this.lesDocumentsDetail.add(var12);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void retourVentes(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      RetourLigneVentesDao var7 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerLesMvtsTiers(this.newtiers, var1, var2, var4, var5);
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            new RetourLigneVentes();
            RetourLigneVentes var9 = (RetourLigneVentes)var6.get(var8);
            DocumentEntete var10 = new DocumentEntete();
            Stock var11 = new Stock();
            var11.setStk_lib_type("Retour");
            var11.setStkFamille(var9.getBrtligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var11.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var9.getBrtligCode().startsWith(this.choixProduit))) {
               boolean var12 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var13 = 0; var13 < this.lesDocumentsEntete.size(); ++var13) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var13)).getDocNum().equals(var9.getRetourEnteteVentes().getBrtNum())) {
                        var12 = true;
                        break;
                     }
                  }
               } else {
                  var12 = false;
               }

               if (!var12) {
                  var10.setVar_lib_nat("Retour");
                  var10.setDocEtat(var9.getRetourEnteteVentes().getBrtEtat());
                  var10.setDocIdCreateur(var9.getRetourEnteteVentes().getTiers().getTieid());
                  var10.setDocDate(var9.getRetourEnteteVentes().getBrtDate());
                  var10.setDocNum(var9.getRetourEnteteVentes().getBrtNum());
                  var10.setDocSerie(var9.getRetourEnteteVentes().getBrtSerie());
                  var10.setDocNomTiers(var9.getRetourEnteteVentes().getBrtNomTiers());
                  var10.setDocObject(var9.getRetourEnteteVentes().getBrtObject());
                  var10.setDocSource(var9.getRetourEnteteVentes().getBrtSource());
                  var10.setDocNomContact(var9.getRetourEnteteVentes().getBrtNomContact());
                  var10.setDocNomCaissier(var9.getRetourEnteteVentes().getBrtNomCommercial());
                  var10.setDocNomResponsable(var9.getRetourEnteteVentes().getBrtNomResponsable());
                  var10.setDocTotHt(var9.getRetourEnteteVentes().getBrtTotHt());
                  var10.setDocTotTva(var9.getRetourEnteteVentes().getBrtTotTva());
                  var10.setDocTotTtc(var9.getRetourEnteteVentes().getBrtTotTtc());
                  var10.setDocTotReglement(0.0D);
                  var10.setDocAPayer(0.0D);
                  this.lesDocumentsEntete.add(var10);
               }

               var11.setStk_date_mvt(var9.getRetourEnteteVentes().getBrtDate());
               var11.setStk_numero(var9.getRetourEnteteVentes().getBrtNum());
               var11.setStk_code_produit(var9.getBrtligCode());
               var11.setStkLibelle(var9.getBrtligLibelle());
               var11.setStk_code_depot(var9.getBrtligDepot());
               var11.setStkPuRem(var9.getBrtligPuRem());
               var11.setStk_pump(var9.getBrtligPump());
               var11.setStk_qte_progress(var9.getBrtligQte());
               var11.setStkPt(var9.getBrtligPt());
               this.var_qte += var11.getStk_qte_progress();
               this.lesDocumentsDetail.add(var11);
            }
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.dataModelDocuments.setWrappedData(this.lesDocumentsDetail);
   }

   public void factureVentes(String var1, String var2, int var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      new ArrayList();
      FactureLigneVentesDao var8 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var7 = var8.chargerLesMvtsTiers(this.newtiers, var1, var2, var5, var6);
      if (var7.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            new FactureLigneVentes();
            FactureLigneVentes var10 = (FactureLigneVentes)var7.get(var9);
            if (var3 == 0 || var3 == 1 && var10.getFactureEnteteVentes().getFacSolde() == 0) {
               DocumentEntete var11 = new DocumentEntete();
               Stock var12 = new Stock();
               var12.setStk_lib_type("Facture");
               var12.setStkFamille(var10.getFacligFamille());
               if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var12.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var10.getFacligCode().startsWith(this.choixProduit))) {
                  boolean var13 = false;
                  if (this.lesDocumentsEntete.size() != 0) {
                     for(int var14 = 0; var14 < this.lesDocumentsEntete.size(); ++var14) {
                        if (((DocumentEntete)this.lesDocumentsEntete.get(var14)).getDocNum().equals(var10.getFactureEnteteVentes().getFacNum())) {
                           var13 = true;
                           break;
                        }
                     }
                  } else {
                     var13 = false;
                  }

                  if (!var13) {
                     var11.setVar_lib_nat("Facture");
                     var11.setDocEtat(var10.getFactureEnteteVentes().getFacEtat());
                     var11.setDocIdCreateur(var10.getFactureEnteteVentes().getTiers().getTieid());
                     var11.setDocDate(var10.getFactureEnteteVentes().getFacDate());
                     var11.setDocNum(var10.getFactureEnteteVentes().getFacNum());
                     var11.setDocSerie(var10.getFactureEnteteVentes().getFacSerie());
                     var11.setDocNomTiers(var10.getFactureEnteteVentes().getFacNomTiers());
                     var11.setDocObject(var10.getFactureEnteteVentes().getFacObject());
                     var11.setDocSource(var10.getFactureEnteteVentes().getFacSource());
                     var11.setDocNomContact(var10.getFactureEnteteVentes().getFacNomContact());
                     var11.setDocNomCaissier(var10.getFactureEnteteVentes().getFacNomCommercial());
                     var11.setDocNomResponsable(var10.getFactureEnteteVentes().getFacNomResponsable());
                     var11.setDocTotHt(var10.getFactureEnteteVentes().getFacTotHt());
                     var11.setDocTotTva(var10.getFactureEnteteVentes().getFacTotTva());
                     var11.setDocTotTtc(var10.getFactureEnteteVentes().getFacTotTtc() + var10.getFactureEnteteVentes().getFacTotTimbre());
                     var11.setDocTotReglement(var10.getFactureEnteteVentes().getFacTotReglement());
                     var11.setDocAPayer(var10.getFactureEnteteVentes().getFacTotTtc() + var10.getFactureEnteteVentes().getFacTotTimbre() - var10.getFactureEnteteVentes().getFacTotReglement());
                     this.lesDocumentsEntete.add(var11);
                  }

                  var12.setStk_date_mvt(var10.getFactureEnteteVentes().getFacDate());
                  var12.setStk_numero(var10.getFactureEnteteVentes().getFacNum());
                  var12.setStk_code_produit(var10.getFacligCode());
                  var12.setStkLibelle(var10.getFacligLibelle());
                  var12.setStk_code_depot(var10.getFacligDepot());
                  var12.setStkPuRem(var10.getFacligPuRem());
                  var12.setStk_pump(var10.getFacligPump());
                  var12.setStk_qte_progress(var10.getFacligQte());
                  var12.setStkPt(var10.getFacligPt());
                  this.var_qte += var12.getStk_qte_progress();
                  this.lesDocumentsDetail.add(var12);
               }
            }
         }
      }

   }

   public void noteDebitVentes(String var1, String var2, int var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      new ArrayList();
      NoteDebitLigneVentesDao var8 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var7 = var8.chargerLesMvtsTiers(this.newtiers, var1, var2, var5, var6);
      if (var7.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            new NoteDebitLigneVentes();
            NoteDebitLigneVentes var10 = (NoteDebitLigneVentes)var7.get(var9);
            if (var3 == 0 || var3 == 1 && var10.getNoteDebitEnteteVentes().getNdbSolde() == 0) {
               DocumentEntete var11 = new DocumentEntete();
               Stock var12 = new Stock();
               var12.setStk_lib_type("NoteDebit");
               var12.setStkFamille(var10.getNdbligFamille());
               if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var12.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var10.getNdbligCode().startsWith(this.choixProduit))) {
                  boolean var13 = false;
                  if (this.lesDocumentsEntete.size() != 0) {
                     for(int var14 = 0; var14 < this.lesDocumentsEntete.size(); ++var14) {
                        if (((DocumentEntete)this.lesDocumentsEntete.get(var14)).getDocNum().equals(var10.getNoteDebitEnteteVentes().getNdbNum())) {
                           var13 = true;
                           break;
                        }
                     }
                  } else {
                     var13 = false;
                  }

                  if (!var13) {
                     var11.setVar_lib_nat("NoteDebit");
                     var11.setDocEtat(var10.getNoteDebitEnteteVentes().getNdbEtat());
                     var11.setDocIdCreateur(var10.getNoteDebitEnteteVentes().getTiers().getTieid());
                     var11.setDocDate(var10.getNoteDebitEnteteVentes().getNdbDate());
                     var11.setDocNum(var10.getNoteDebitEnteteVentes().getNdbNum());
                     var11.setDocSerie(var10.getNoteDebitEnteteVentes().getNdbSerie());
                     var11.setDocNomTiers(var10.getNoteDebitEnteteVentes().getNdbNomTiers());
                     var11.setDocObject(var10.getNoteDebitEnteteVentes().getNdbObject());
                     var11.setDocSource(var10.getNoteDebitEnteteVentes().getNdbSource());
                     var11.setDocNomContact(var10.getNoteDebitEnteteVentes().getNdbNomContact());
                     var11.setDocNomCaissier(var10.getNoteDebitEnteteVentes().getNdbNomCommercial());
                     var11.setDocNomResponsable(var10.getNoteDebitEnteteVentes().getNdbNomResponsable());
                     var11.setDocTotHt(var10.getNoteDebitEnteteVentes().getNdbTotHt());
                     var11.setDocTotTva(var10.getNoteDebitEnteteVentes().getNdbTotTva());
                     var11.setDocTotTtc(var10.getNoteDebitEnteteVentes().getNdbTotTtc() + var10.getNoteDebitEnteteVentes().getNdbTotTimbre());
                     var11.setDocTotReglement(var10.getNoteDebitEnteteVentes().getNdbTotReglement());
                     var11.setDocAPayer(var10.getNoteDebitEnteteVentes().getNdbTotTtc() + var10.getNoteDebitEnteteVentes().getNdbTotTimbre() - var10.getNoteDebitEnteteVentes().getNdbTotReglement());
                     this.lesDocumentsEntete.add(var11);
                  }

                  var12.setStk_date_mvt(var10.getNoteDebitEnteteVentes().getNdbDate());
                  var12.setStk_numero(var10.getNoteDebitEnteteVentes().getNdbNum());
                  var12.setStk_code_produit(var10.getNdbligCode());
                  var12.setStkLibelle(var10.getNdbligLibelle());
                  var12.setStk_code_depot(var10.getNdbligDepot());
                  var12.setStkPuRem(var10.getNdbligPuRem());
                  var12.setStk_pump(var10.getNdbligPump());
                  var12.setStk_qte_progress(var10.getNdbligQte());
                  var12.setStkPt(var10.getNdbligPt());
                  this.var_qte += var12.getStk_qte_progress();
                  this.lesDocumentsDetail.add(var12);
               }
            }
         }
      }

   }

   public void avoirVentes(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      AvoirLigneVentesDao var7 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.chargerLesMvtsTiers(this.newtiers, var1, var2, var4, var5);
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            new AvoirLigneVentes();
            AvoirLigneVentes var9 = (AvoirLigneVentes)var6.get(var8);
            DocumentEntete var10 = new DocumentEntete();
            Stock var11 = new Stock();
            var11.setStk_lib_type("Avoir");
            var11.setStkFamille(var9.getAvrligFamille());
            if ((this.choixFamilles.equals("0") || this.choixFamilles.equals(var11.getStkFamille())) && (this.choixProduit == null || this.choixProduit.isEmpty() || this.choixProduit != null && !this.choixProduit.isEmpty() && var9.getAvrligCode().startsWith(this.choixProduit))) {
               boolean var12 = false;
               if (this.lesDocumentsEntete.size() != 0) {
                  for(int var13 = 0; var13 < this.lesDocumentsEntete.size(); ++var13) {
                     if (((DocumentEntete)this.lesDocumentsEntete.get(var13)).getDocNum().equals(var9.getAvoirEnteteVentes().getAvrNum())) {
                        var12 = true;
                        break;
                     }
                  }
               } else {
                  var12 = false;
               }

               if (!var12) {
                  var10.setVar_lib_nat("Avoir");
                  var10.setDocEtat(var9.getAvoirEnteteVentes().getAvrEtat());
                  var10.setDocIdCreateur(var9.getAvoirEnteteVentes().getTiers().getTieid());
                  var10.setDocDate(var9.getAvoirEnteteVentes().getAvrDate());
                  var10.setDocNum(var9.getAvoirEnteteVentes().getAvrNum());
                  var10.setDocSerie(var9.getAvoirEnteteVentes().getAvrSerie());
                  var10.setDocNomTiers(var9.getAvoirEnteteVentes().getAvrNomTiers());
                  var10.setDocIdCreateur(var9.getAvoirEnteteVentes().getTiers().getTieid());
                  var10.setDocObject(var9.getAvoirEnteteVentes().getAvrObject());
                  var10.setDocSource(var9.getAvoirEnteteVentes().getAvrSource());
                  var10.setDocNomContact(var9.getAvoirEnteteVentes().getAvrNomContact());
                  var10.setDocNomCaissier(var9.getAvoirEnteteVentes().getAvrNomCommercial());
                  var10.setDocNomResponsable(var9.getAvoirEnteteVentes().getAvrNomResponsable());
                  var10.setDocTotHt(var9.getAvoirEnteteVentes().getAvrTotHt() * -1.0D);
                  var10.setDocTotTva(var9.getAvoirEnteteVentes().getAvrTotTva() * -1.0D);
                  var10.setDocTotTtc(var9.getAvoirEnteteVentes().getAvrTotTtc() * -1.0D);
                  var10.setDocTotReglement(0.0D);
                  var10.setDocAPayer(0.0D);
                  this.lesDocumentsEntete.add(var10);
               }

               var11.setStk_date_mvt(var9.getAvoirEnteteVentes().getAvrDate());
               var11.setStk_numero(var9.getAvoirEnteteVentes().getAvrNum());
               var11.setStk_code_produit(var9.getAvrligCode());
               var11.setStkLibelle(var9.getAvrligLibelle());
               var11.setStk_code_depot(var9.getAvrligDepot());
               var11.setStkPuRem(var9.getAvrligPuRem() * -1.0D);
               var11.setStk_pump(var9.getAvrligPump() * -1.0D);
               var11.setStk_qte_progress(var9.getAvrligQte() * -1.0F);
               var11.setStkPt(var9.getAvrligPt() * -1.0D);
               this.var_qte += var11.getStk_qte_progress();
               this.lesDocumentsDetail.add(var11);
            }
         }
      }

   }

   public void reglement(UtilDate var1, String var2, Session var3) throws HibernateException, NamingException {
      String var4 = var1.dateToStringSQLLight(this.dateDebut);
      String var5 = var1.dateToStringSQLLight(this.dateFin);
      new ArrayList();
      ReglementsDao var7 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.rechercheHistoTiers(this.newtiers.getTieid(), var4, var5, var2, var3);
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            new Reglements();
            Reglements var9 = (Reglements)var6.get(var8);
            DocumentEntete var10 = new DocumentEntete();
            var10.setVar_lib_nat("Règlement");
            var10.setDocDate(var9.getRglDateReg());
            var10.setDocNum(var9.getRglNum());
            var10.setDocSerie(var9.getRglSerie());
            var10.setDocNomTiers(var9.getRglNomTiers());
            var10.setDocObject(var9.getRglObjet());
            var10.setDocNomContact(var9.getVar_lib_nat());
            var10.setDocNomCaissier(var9.getRglDocument());
            String var11 = "";
            if (var9.getRglTypeReg() == 1) {
               (new StringBuilder()).append("Chq N° ").append(var9.getRglNumChqBdx()).append(" ").append(var9.getRglBanqueTireur()).toString();
            } else {
               var11 = var9.getRglLibTypReg();
            }

            var10.setDocNomResponsable(var9.getRglNomResponsable());
            var10.setDocTotHt(0.0D);
            var10.setDocTotTva(0.0D);
            var10.setDocTotTtc(0.0D);
            var10.setDocTotReglement(var9.getRglRecette() + var9.getRglDepense());
            var10.setDocAPayer(0.0D);
            this.lesDocumentsEntete.add(var10);
         }
      }

   }

   public void selectionDocument() {
      if (this.dataModelDocumentsEntete.isRowAvailable()) {
         this.documentEntete = (DocumentEntete)this.dataModelDocumentsEntete.getRowData();
      }

   }

   public void calculStatistique() {
      this.caHt = 0.0D;
      this.nbDoc = 0;
      this.caMoyen = 0.0D;
      this.sansSources = 0;
      this.caTrf = 0.0D;
      this.nbTrf = 0;
      this.tauxTrf = 0.0F;
      this.nbJour = (int)this.calculNbjours();
      this.caJour = 0.0D;
      this.tauxJour = 0.0F;
      this.nbProduit = 0;
      this.prixMoyen = 0.0D;
      if (this.choixDocument != 60) {
         if (this.lesDocumentsEntete.size() != 0) {
            int var1 = 0;

            while(true) {
               if (var1 >= this.lesDocumentsEntete.size()) {
                  this.caMoyen = this.caHt / (double)this.nbDoc;
                  this.tauxTrf = (float)this.nbTrf / (float)this.nbDoc * 100.0F;
                  this.caJour = this.caHt / (double)this.nbJour;
                  this.tauxJour = (float)(this.caJour / this.caHt) * 100.0F;
                  break;
               }

               this.caHt += ((DocumentEntete)this.lesDocumentsEntete.get(var1)).getDocTotHt();
               ++this.nbDoc;
               if (((DocumentEntete)this.lesDocumentsEntete.get(var1)).getDocSource() == null || ((DocumentEntete)this.lesDocumentsEntete.get(var1)).getDocSource().isEmpty()) {
                  ++this.sansSources;
               }

               if (((DocumentEntete)this.lesDocumentsEntete.get(var1)).getDocEtat() == 4 || ((DocumentEntete)this.lesDocumentsEntete.get(var1)).getDocEtat() == 5) {
                  this.caTrf += ((DocumentEntete)this.lesDocumentsEntete.get(var1)).getDocTotHt();
                  ++this.nbTrf;
               }

               ++var1;
            }
         }

         if (this.lesDocumentsDetail.size() != 0) {
            ArrayList var5 = new ArrayList();

            int var2;
            for(var2 = 0; var2 < this.lesDocumentsDetail.size(); ++var2) {
               boolean var3 = false;
               if (var5.size() != 0) {
                  for(int var4 = 0; var4 < var5.size(); ++var4) {
                     if (((Stock)this.lesDocumentsDetail.get(var2)).getStk_code_produit() != null && !((Stock)this.lesDocumentsDetail.get(var2)).getStk_code_produit().isEmpty()) {
                        if (((Stock)this.lesDocumentsDetail.get(var2)).getStk_code_produit().equals(((Stock)var5.get(var4)).getStk_code_produit())) {
                           var3 = true;
                           break;
                        }
                     } else if (((Stock)this.lesDocumentsDetail.get(var2)).getStk_code_produit() == null || ((Stock)this.lesDocumentsDetail.get(var2)).getStk_code_produit().isEmpty()) {
                        var3 = true;
                        break;
                     }
                  }
               }

               if (!var3) {
                  var5.add(this.lesDocumentsDetail.get(var2));
               }
            }

            if (var5.size() != 0) {
               for(var2 = 0; var2 < var5.size(); ++var2) {
                  ++this.nbProduit;
               }

               this.prixMoyen = (double)((float)(this.caHt / (double)this.nbProduit));
            }
         }
      }

   }

   public long calculNbjours() {
      byte var1 = 1;
      byte var2 = 12;
      boolean var3 = false;
      boolean var4 = false;
      long var5 = 0L;
      long var7 = 0L;
      Calendar var9 = Calendar.getInstance();
      Calendar var10 = Calendar.getInstance();
      Calendar var11 = Calendar.getInstance();
      var9.setTime(this.dateDebut);
      var10.setTime(this.dateFin);
      int var14 = 0;

      while(true) {
         do {
            if (!var9.before(var10)) {
               int var13 = var14 / var2;
               var14 -= var13 * var2;
               var11 = Calendar.getInstance();
               var11.setTime(this.dateDebut);
               var11.add(1, var13);
               var11.add(2, var14);
               var5 = (var10.getTimeInMillis() - var11.getTimeInMillis()) / 86400000L;
               var7 = var7 + var5 + 1L;
               int var12 = (int)(var7 / 7L);
               var7 -= (long)var12;
               return var7;
            }

            var9.add(2, var1);
         } while(!var9.before(var10) && !var9.equals(var10));

         var7 += (long)var9.getActualMaximum(5);
         ++var14;
      }
   }

   public void accesPlanning() throws HibernateException, NamingException {
      this.newRdv = new Rdv();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Office");
      this.lesPlanning = new ArrayList();
      this.dataModelPlanning = new ListDataModel();
      this.mesTachesItem = new ArrayList();
      TachesDao var2 = new TachesDao(this.baseLog, this.utilInitHibernate);
      this.mesTachesItem = var2.selectTachesActifItem(var1);
      this.choixRdv = 99;
      RdvDao var3 = new RdvDao(this.baseLog, this.utilInitHibernate);
      List var4 = var3.chargerRdvTiers(this.choixRdv, this.newtiers.getTieid(), var1);
      this.dataModelPlanning.setWrappedData(var4);
      this.mesNaturesRdvItems.clear();
      LectureNatureRdv var5 = new LectureNatureRdv(this.baseLog);
      new ArrayList();
      List var6 = var5.getMesNatureRdvUtil();

      for(int var7 = 0; var7 < var6.size(); ++var7) {
         if (((ObjetCompte)var6.get(var7)).isValide()) {
            this.mesNaturesRdvItems.add(new SelectItem(((ObjetCompte)var6.get(var7)).getCode(), ((ObjetCompte)var6.get(var7)).getCode() + ":" + ((ObjetCompte)var6.get(var7)).getNom_FR()));
         }
      }

      if (this.mesNaturesRdvItems == null || this.mesNaturesRdvItems.size() == 0) {
         this.mesNaturesRdvItems.add(new SelectItem("1", "1:Rdv (défaut)"));
      }

      this.var_action = 4;
      this.var_memo_action = this.var_action;
      this.utilInitHibernate.closeSession();
      this.showModalPanelRdv = false;
   }

   public void retourPlanning() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void rechercherLesRdv() throws HibernateException, NamingException {
      RdvDao var1 = new RdvDao(this.baseLog, this.utilInitHibernate);
      List var2 = var1.chargerRdvTiers(this.choixRdv, this.newtiers.getTieid(), (Session)null);
      this.dataModelPlanning.setWrappedData(var2);
   }

   public void selectionRDV() {
      if (this.dataModelPlanning.isRowAvailable()) {
         this.newRdv = (Rdv)this.dataModelPlanning.getRowData();
         this.testRdv = true;
      }

   }

   public void ajouterRdv() {
      this.newRdv = new Rdv();
      this.choixTache = "";
      this.choixTypeRdv();
      this.showModalPanelRdv = true;
   }

   public void modifierRdv() throws HibernateException, NamingException {
      if (this.newRdv != null) {
         this.choixTache = "";
         TachesDao var1 = new TachesDao(this.baseLog, this.utilInitHibernate);
         new Taches();
         if (this.newRdv.getRdvTache() != null && !this.newRdv.getRdvTache().isEmpty()) {
            Taches var2 = var1.rechercheTache(this.newRdv.getRdvTache(), (Session)null);
            if (var2 != null) {
               this.choixTache = var2.getTacCode() + ":" + var2.getTacNomFr();
            }
         }

         this.choixTypeRdv();
         this.showModalPanelRdv = true;
      }

   }

   public void deleteRdv() throws HibernateException, NamingException {
      RdvDao var1 = new RdvDao(this.baseLog, this.utilInitHibernate);
      var1.delRdv(this.newRdv.getRdvId());
      this.rechercherLesRdv();
      this.testRdv = false;
   }

   public void choixTypeRdv() {
      if (this.newRdv.getRdvNature() != 0 && this.newRdv.getRdvNature() != 6) {
         if (this.newRdv.getRdvNature() == 2) {
            this.typeRdv = 2;
         } else if (this.newRdv.getRdvNature() == 9) {
            this.typeRdv = 9;
         } else {
            this.typeRdv = 0;
         }
      } else {
         this.typeRdv = 1;
      }

   }

   public void saveRdv() throws HibernateException, NamingException {
      RdvDao var1 = new RdvDao(this.baseLog, this.utilInitHibernate);
      this.newRdv.setRdvTieIdDe(this.newtiers.getTieid());
      this.newRdv.setRdvNomTiers(this.newtiers.getTieraisonsocialenom());
      this.newRdv.setUsers(this.usersLog);
      this.newRdv.setRdvEtat(0);
      if (!this.selectedUserdest.equals("0")) {
         this.newRdv.setRdvUsrDe(Long.parseLong(this.selectedUserdest));
         this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
         this.newRdv.setRdvNomUsers(this.userDao.selectUserD(Long.parseLong(this.selectedUserdest), (Session)null).getUsrPatronyme());
      } else {
         this.newRdv.setRdvUsrDe(0L);
         this.newRdv.setRdvNomUsers("");
      }

      if (this.choixTache != null && this.choixTache.contains(":")) {
         String[] var2 = this.choixTache.split(":");
         this.newRdv.setRdvTache(var2[0]);
         TachesDao var3 = new TachesDao(this.baseLog, this.utilInitHibernate);
         new Taches();
         Taches var4 = var3.rechercheTache(var2[0], (Session)null);
         if (var4 != null) {
            this.newRdv.setRdvTache(var4.getTacCode());
            this.newRdv.setRdvTachePr(var4.getTacValPr());
            this.newRdv.setRdvTachePv(var4.getTacValPr());
         } else {
            this.newRdv.setRdvTache("");
            this.newRdv.setRdvTachePr(0.0F);
            this.newRdv.setRdvTachePv(0.0F);
         }
      } else {
         this.newRdv.setRdvTache("");
         this.newRdv.setRdvTachePr(0.0F);
         this.newRdv.setRdvTachePv(0.0F);
      }

      if (this.newRdv.getRdvId() == 0L) {
         this.newRdv.setRdvDateCreation(new Date());
         this.newRdv = var1.insert(this.newRdv);
         this.lesPlanning.add(this.newRdv);
         this.dataModelPlanning.setWrappedData(this.lesPlanning);
      } else {
         this.newRdv = var1.modif(this.newRdv);
      }

      this.testRdv = false;
      this.showModalPanelRdv = false;
   }

   public void annuleRdv() {
      this.testRdv = false;
      this.showModalPanelRdv = false;
   }

   public void accesMail() throws HibernateException, NamingException, ParseException {
      this.formMessagerie = new FormMessagerie();
      this.formMessagerie.setutilInitHibernate(this.utilInitHibernate);
      this.formMessagerie.setStructureLog(this.structureLog);
      this.formMessagerie.setBaseLog(this.baseLog);
      this.formMessagerie.setUsersLog(this.usersLog);
      this.formMessagerie.InstancesDaoUtilses();
      this.formMessagerie.setTiers(this.newtiers);
      this.formMessagerie.setPatients((Patients)null);
      this.formMessagerie.executerRequeteTiers();
      this.formMessagerie.setUrlExplorateur(this.urlExplorateur);
      this.formMessagerie.setFormTiers(this);
      this.var_action = 5;
      this.var_memo_action = this.var_action;
      this.showModalPanelMessagerie = false;
   }

   public void retourMessagerie() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void envoiSmsZ1() {
      if (this.newtiers.getTieburtel3() != null && !this.newtiers.getTieburtel3().isEmpty()) {
         this.numeroMobile = this.newtiers.getTieburtel3();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ2() {
      if (this.showModalPanelContact) {
         if (this.contacts.getConcel1() != null && !this.contacts.getConcel1().isEmpty()) {
            this.numeroMobile = this.contacts.getConcel1();
            this.messageSms = "";
            this.showModalPanelSms = true;
         }
      } else if (this.showModalPanelProcuration) {
         if (this.contactsProcuration.getConcel1() != null && !this.contactsProcuration.getConcel1().isEmpty()) {
            this.numeroMobile = this.contactsProcuration.getConcel1();
            this.messageSms = "";
            this.showModalPanelSms = true;
         }
      } else if (this.showModalPanelTestament && this.contactsTestament.getConcel1() != null && !this.contactsTestament.getConcel1().isEmpty()) {
         this.numeroMobile = this.contactsTestament.getConcel1();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ3() {
      if (this.showModalPanelContact) {
         if (this.contacts.getConcel2() != null && !this.contacts.getConcel2().isEmpty()) {
            this.numeroMobile = this.contacts.getConcel2();
            this.messageSms = "";
            this.showModalPanelSms = true;
         }
      } else if (this.showModalPanelProcuration) {
         if (this.contactsProcuration.getConcel2() != null && !this.contactsProcuration.getConcel2().isEmpty()) {
            this.numeroMobile = this.contactsProcuration.getConcel2();
            this.messageSms = "";
            this.showModalPanelSms = true;
         }
      } else if (this.showModalPanelTestament && this.contactsTestament.getConcel2() != null && !this.contactsTestament.getConcel2().isEmpty()) {
         this.numeroMobile = this.contactsTestament.getConcel2();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ4() {
      if (this.showModalPanelContact) {
         if (this.contacts.getConcel3() != null && !this.contacts.getConcel3().isEmpty()) {
            this.numeroMobile = this.contacts.getConcel3();
            this.messageSms = "";
            this.showModalPanelSms = true;
         }
      } else if (this.showModalPanelProcuration) {
         if (this.contactsProcuration.getConcel3() != null && !this.contactsProcuration.getConcel3().isEmpty()) {
            this.numeroMobile = this.contactsProcuration.getConcel3();
            this.messageSms = "";
            this.showModalPanelSms = true;
         }
      } else if (this.showModalPanelTestament && this.contactsTestament.getConcel3() != null && !this.contactsTestament.getConcel3().isEmpty()) {
         this.numeroMobile = this.contactsTestament.getConcel3();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void fermerSms() {
      this.showModalPanelSms = false;
   }

   public void valideEnvoiSms() throws IOException, HibernateException, NamingException, SQLException {
      UtilSms var1 = new UtilSms(this.utilInitHibernate, this.structureLog, this.usersLog, this.baseLog);
      if (this.contacts != null) {
         var1.sendSmsOne(this.messageSms, this.numeroMobile, this.contacts.getConpatronyme(), this.contacts.getConcivilite(), this.contacts.getConid(), this.newtiers.getTieraisonsocialenom(), this.newtiers.getTieid(), 0);
      } else {
         var1.sendSmsOne(this.messageSms, this.numeroMobile, (String)null, (String)null, 0L, this.newtiers.getTieraisonsocialenom(), this.newtiers.getTieid(), 0);
      }

      this.showModalPanelSms = false;
   }

   public void ouvrirIncident() throws HibernateException, NamingException {
      new ArrayList();
      new ArrayList();
      new ArrayList();
      new ArrayList();
      this.dataModelIncidents = new ListDataModel();
      this.dataModelReglements = new ListDataModel();
      this.dataModelDocuments = new ListDataModel();
      this.totReglement = 0.0D;
      this.totDocument = 0.0D;
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
      ReglementsDao var6 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      List var1 = var6.chargeChequeImpayesClient(this.newtiers.getTieid(), var5);
      this.dataModelIncidents.setWrappedData(var1);
      List var2 = var6.rechercheByTiersClient(this.newtiers, 1, var5);
      if (var2.size() != 0) {
         for(int var7 = 0; var7 < var2.size(); ++var7) {
            this.totReglement += ((Reglements)var2.get(var7)).getRglRecette();
         }
      }

      this.dataModelReglements.setWrappedData(var2);
      int var8;
      if (this.optionVentes.getPaiementAVOIR().equals("1")) {
         CommandeEnteteVentesDao var9 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         List var3 = var9.rechercheByTiers(this.newtiers, var5);
         if (var3.size() != 0) {
            for(var8 = 0; var8 < var3.size(); ++var8) {
               this.totDocument += ((CommandeEnteteVentes)var3.get(var8)).getBcmTotTtc();
            }
         }

         this.dataModelDocuments.setWrappedData(var3);
      } else {
         FactureEnteteVentesDao var10 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         List var4 = var10.rechercheByTiers(this.newtiers, var5);
         if (var4.size() != 0) {
            for(var8 = 0; var8 < var4.size(); ++var8) {
               this.totDocument += ((FactureEnteteVentes)var4.get(var8)).getFacTotTtc();
            }
         }

         this.dataModelDocuments.setWrappedData(var4);
      }

      this.utilInitHibernate.closeSession();
      this.showModalPanelIncident = true;
   }

   public void fermerIncident() {
      this.showModalPanelIncident = false;
   }

   public void changeCompteSurveille() throws HibernateException, NamingException {
      if (this.newtiers != null) {
         if (this.newtiers.getTiesurveille() == 0) {
            this.newtiers.setTiesurveille(1);
         } else {
            this.newtiers.setTiesurveille(0);
         }

         this.newtiers = this.tiersDao.modif(this.newtiers);
         EspionDao var1 = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var2 = new Espion();
         var2.setEspdtecreat(new Date());
         var2.setUsers(this.usersLog);
         if (this.newtiers.getTiesurveille() == 0) {
            var2.setEspaction("Tiers : " + this.newtiers.getTieraisonsocialenom() + " annulation surveillance");
         } else {
            var2.setEspaction("Tiers : " + this.newtiers.getTieraisonsocialenom() + "activation surveillance");
         }

         var2.setEsptype(2);
         var2.setEsptIdTiers(this.newtiers.getTieid());
         var1.mAJEspion(var2);
      }

   }

   public void changeCompteBloque() throws HibernateException, NamingException {
      if (this.newtiers != null) {
         if (this.newtiers.getTiecomptebloque() == 0) {
            this.newtiers.setTiecomptebloque(1);
         } else {
            this.newtiers.setTiecomptebloque(0);
         }

         this.newtiers = this.tiersDao.modif(this.newtiers);
         EspionDao var1 = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var2 = new Espion();
         var2.setEspdtecreat(new Date());
         var2.setUsers(this.usersLog);
         if (this.newtiers.getTiecomptebloque() == 0) {
            var2.setEspaction("Tiers : " + this.newtiers.getTieraisonsocialenom() + " annulation blocage compte");
         } else {
            var2.setEspaction("Tiers : " + this.newtiers.getTieraisonsocialenom() + "activation blocage compte");
         }

         var2.setEsptype(2);
         var2.setEsptIdTiers(this.newtiers.getTieid());
         var1.mAJEspion(var2);
      }

   }

   public void changeCompteInterdit() throws HibernateException, NamingException {
      if (this.newtiers != null) {
         if (this.newtiers.getTiechequeinterdit() == 0) {
            this.newtiers.setTiechequeinterdit(1);
         } else {
            this.newtiers.setTiechequeinterdit(0);
         }

         this.newtiers = this.tiersDao.modif(this.newtiers);
         EspionDao var1 = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var2 = new Espion();
         var2.setEspdtecreat(new Date());
         var2.setUsers(this.usersLog);
         if (this.newtiers.getTiechequeinterdit() == 0) {
            var2.setEspaction("Tiers : " + this.newtiers.getTieraisonsocialenom() + " annulation chèque interdit");
         } else {
            var2.setEspaction("Tiers : " + this.newtiers.getTieraisonsocialenom() + "activation chèque interdit");
         }

         var2.setEsptype(2);
         var2.setEsptIdTiers(this.newtiers.getTieid());
         var1.mAJEspion(var2);
      }

   }

   public void selctionSericeInterim() {
      if (this.dataModelServiceInterim.isRowAvailable()) {
         this.serviceInterim = (Site)this.dataModelServiceInterim.getRowData();
         this.afficheServiceInterim = true;
      }

   }

   public void ajouterServiceInterim() {
      if (this.newtiers != null) {
         this.serviceInterim = new Site();
         this.shomModalPanelServiceInterim = true;
      }

   }

   public void modifierServiceInterim() {
      if (this.serviceInterim != null) {
         this.shomModalPanelServiceInterim = true;
      }

   }

   public void supprimerServiceInterim() throws HibernateException, NamingException {
      if (this.serviceInterim != null) {
         this.siteDao.delete(this.serviceInterim);
         this.lesSerivicesInterim.remove(this.serviceInterim);
         this.dataModelServiceInterim.setWrappedData(this.lesSerivicesInterim);
      }

   }

   public void annulerServiceInterim() {
      this.shomModalPanelServiceInterim = false;
   }

   public void validerServiceInterim() throws HibernateException, NamingException {
      if (this.serviceInterim != null && this.serviceInterim.getSitCode() != null && !this.serviceInterim.getSitCode().isEmpty()) {
         if (this.serviceInterim.getSitId() == 0L) {
            this.serviceInterim.setSitIdClient(this.newtiers.getTieid());
            this.serviceInterim = this.siteDao.insert(this.serviceInterim);
            this.lesSerivicesInterim.add(this.serviceInterim);
            this.dataModelServiceInterim.setWrappedData(this.lesSerivicesInterim);
         } else {
            this.serviceInterim = this.siteDao.modif(this.serviceInterim);
         }
      }

      this.shomModalPanelServiceInterim = false;
   }

   public void calculeNumCompteMF() throws HibernateException, NamingException {
      this.codeBanque = this.structureLog.getStrnum10();
      if (this.codeAgence != null) {
         String var1 = "";
         if (this.codeAgence.contains(":")) {
            String[] var2 = this.codeAgence.split(":");
            var1 = var2[0];
         } else {
            var1 = this.codeAgence;
         }

         this.numCompte = this.tiersDao.lastTierAgenceMF(var1, (Session)null);
         int var6 = this.filtreCaracteresMF(this.structureLog.getStrnum10());
         int var3 = this.filtreCaracteresMF(this.codeAgence);
         int var4 = this.filtreCaracteresMF(this.numCompte);
         this.numCleCtrl = "";
         int var5 = 97 - (var6 * 89 + var3 * 15 + var4 * 3) % 97;
         if (var5 <= 9) {
            this.numCleCtrl = "0" + var5;
         } else {
            this.numCleCtrl = "" + var5;
         }

         this.newtiers.setTiesigle(this.codeBanque + ":" + var1 + ":" + this.numCompte + ":" + this.numCleCtrl);
      }

   }

   public int filtreCaracteresMF(String var1) {
      String var2 = "";
      boolean var3 = false;
      int var4 = 0;

      for(int var5 = 0; var5 < var1.length(); ++var5) {
         var2 = (String)var1.subSequence(var5, var5 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".contains(var2)) {
            int var6;
            if (!var2.equalsIgnoreCase("a") && !var2.equalsIgnoreCase("j")) {
               if (!var2.equalsIgnoreCase("b") && !var2.equalsIgnoreCase("k") && !var2.equalsIgnoreCase("s")) {
                  if (!var2.equalsIgnoreCase("c") && !var2.equalsIgnoreCase("l") && !var2.equalsIgnoreCase("t")) {
                     if (!var2.equalsIgnoreCase("d") && !var2.equalsIgnoreCase("m") && !var2.equalsIgnoreCase("u")) {
                        if (!var2.equalsIgnoreCase("e") && !var2.equalsIgnoreCase("n") && !var2.equalsIgnoreCase("v")) {
                           if (!var2.equalsIgnoreCase("f") && !var2.equalsIgnoreCase("o") && !var2.equalsIgnoreCase("w")) {
                              if (!var2.equalsIgnoreCase("g") && !var2.equalsIgnoreCase("p") && !var2.equalsIgnoreCase("x")) {
                                 if (!var2.equalsIgnoreCase("h") && !var2.equalsIgnoreCase("q") && !var2.equalsIgnoreCase("y")) {
                                    if (!var2.equalsIgnoreCase("i") && !var2.equalsIgnoreCase("r") && !var2.equalsIgnoreCase("z")) {
                                       if (!var2.equalsIgnoreCase("1") && !var2.equalsIgnoreCase("2") && !var2.equalsIgnoreCase("3") && !var2.equalsIgnoreCase("4") && !var2.equalsIgnoreCase("5") && !var2.equalsIgnoreCase("6") && !var2.equalsIgnoreCase("7") && !var2.equalsIgnoreCase("8") && !var2.equalsIgnoreCase("9") && !var2.equalsIgnoreCase("0")) {
                                          var6 = 0;
                                       } else {
                                          var6 = Integer.parseInt(var2);
                                       }
                                    } else {
                                       var6 = 9;
                                    }
                                 } else {
                                    var6 = 8;
                                 }
                              } else {
                                 var6 = 7;
                              }
                           } else {
                              var6 = 6;
                           }
                        } else {
                           var6 = 5;
                        }
                     } else {
                        var6 = 4;
                     }
                  } else {
                     var6 = 3;
                  }
               } else {
                  var6 = 2;
               }
            } else {
               var6 = 1;
            }

            var4 += var6;
         }
      }

      return var4;
   }

   public void ajouterDocumentScan() {
      this.uploadedPDFFile = null;
      if (this.utilDownload == null) {
         this.utilDownload = new UtilDownload();
      }

      this.nomDocument = "";
      this.showModalPanelAjoutFile = true;
   }

   public void annulerDocumentScan() {
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

   public void validerDocumentScan() {
      if (this.newtiers != null && this.uploadedPDFFile != null && this.nomDocument != null && !this.nomDocument.isEmpty()) {
         File var1 = new File(this.nomRepertoire + this.newtiers.getTieid());
         if (var1.exists()) {
            var1.delete();
         }

         FacesContext var2 = FacesContext.getCurrentInstance();

         try {
            if (this.utilDownload == null) {
               this.utilDownload = new UtilDownload();
            }

            String var3 = this.utilDownload.trimFilePath(this.uploadedPDFFile.getName().trim());
            String var4 = var3.substring(var3.indexOf(".") + 1);
            if (this.nomDocument != null && !this.nomDocument.isEmpty()) {
               var3 = this.newtiers.getTieid() + "_" + this.filtreCaracteres(this.nomDocument) + "." + var4;
            } else {
               var3 = this.newtiers.getTieid() + "." + var4;
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

   public void lectureDoc() throws MalformedURLException, IOException {
      if (this.dataModelDocumnts.isRowAvailable()) {
         String var1 = (String)this.dataModelDocumnts.getRowData();
         if (var1.endsWith(".pdf")) {
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

   public void calculeZone() throws HibernateException, NamingException {
      this.utilTdt = new UtilTdt();
      this.mesContactItem = new ArrayList();
      if (this.lesContactsListe.size() != 0) {
         for(int var1 = 0; var1 < this.lesContactsListe.size(); ++var1) {
            this.mesContactItem.add(new SelectItem(((Contacts)this.lesContactsListe.get(var1)).getConid(), ((Contacts)this.lesContactsListe.get(var1)).getConpatronyme()));
         }
      }

      if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
         this.mesContactItem.add(new SelectItem(0, "Sans contact"));
      }

      this.mesModelesItems = new ArrayList();
      this.modelesCourriersDao = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.mesModelesItems = this.modelesCourriersDao.chargerLesContratsVentes((Session)null);
      this.mesSeries = new ArrayList();
      UsersChronoDao var2 = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.mesSeries = var2.selectSerieByUserAchats(this.usersLog, (Session)null);
      this.lesContratsEcheance.clear();
      this.dataModelAdherent = new ListDataModel();
      if (this.contratEnteteVentes != null) {
         this.lesContratsEcheance = this.contratEcheanceVentesDao.chargerLesLignes(this.contratEnteteVentes, (Session)null);
      }

      this.dataModelAdherent.setWrappedData(this.lesContratsEcheance);
      this.visibiliteEcheance = false;
   }

   public void selectionContrat() throws HibernateException, NamingException {
      if (this.dataModelConvention.isRowAvailable()) {
         this.contratEnteteVentes = (ContratEnteteVentes)this.dataModelConvention.getRowData();
         this.visibiliteContrat = true;
         this.calculeZone();
      }

   }

   public void ajouterContrat() throws HibernateException, NamingException {
      this.contratEnteteVentes = new ContratEnteteVentes();
      this.contratEnteteVentes.setCrtDate(new Date());
      this.contratEnteteVentes.setTiers(this.newtiers);
      this.contratEnteteVentes.setCrtNomTiers(this.newtiers.getPatronyme());
      this.mesBiensItems.clear();
      new ArrayList();
      BienDao var2 = new BienDao(this.baseLog, this.utilInitHibernate);
      List var1 = var2.chargeBienPromoteur((Session)null);
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            if (((Bien)var1.get(var3)).getBieEtat() == 0 || ((Bien)var1.get(var3)).getBieEtat() == 1) {
               this.mesBiensItems.add(new SelectItem(((Bien)var1.get(var3)).getBieNum(), ((Bien)var1.get(var3)).getBieNum() + ":" + ((Bien)var1.get(var3)).getBieModele()));
            }
         }
      }

      this.var_action = 1;
      this.calculeZone();
      this.showModalPanelContrat = true;
   }

   public void modifierContrat() throws HibernateException, NamingException {
      if (this.contratEnteteVentes != null) {
         this.mesBiensItems.clear();
         new ArrayList();
         BienDao var2 = new BienDao(this.baseLog, this.utilInitHibernate);
         List var1 = var2.chargeBienNegoce((Session)null);
         if (var1.size() != 0) {
            for(int var3 = 0; var3 < var1.size(); ++var3) {
               if (this.contratEnteteVentes.getCrtAffaire() != null && !this.contratEnteteVentes.getCrtAffaire().isEmpty() && this.contratEnteteVentes.getCrtAffaire().equals(((Bien)var1.get(var3)).getBieNum()) || ((Bien)var1.get(var3)).getBieEtat() == 0 || ((Bien)var1.get(var3)).getBieEtat() == 1) {
                  this.mesBiensItems.add(new SelectItem(((Bien)var1.get(var3)).getBieNum(), ((Bien)var1.get(var3)).getBieNum() + ":" + ((Bien)var1.get(var3)).getBieModele()));
               }
            }
         }

         this.calculeZone();
         this.var_action = 2;
         this.showModalPanelContrat = true;
      }

   }

   public void consulterContrat() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.contratEnteteVentes != null) {
         this.mesBiensItems.clear();
         if (this.contratEnteteVentes.getCrtAffaire() != null && !this.contratEnteteVentes.getCrtAffaire().isEmpty()) {
            BienDao var1 = new BienDao(this.baseLog, this.utilInitHibernate);
            new Bien();
            Bien var2 = var1.logBienNum(this.contratEnteteVentes.getCrtAffaire(), (Session)null);
            if (var2 != null) {
               this.mesBiensItems.add(new SelectItem(var2.getBieNum(), var2.getBieNum() + ":" + var2.getBieModele()));
            }
         }

         this.calculeZone();
         this.var_action = 3;
         this.showModalPanelContrat = true;
      }

   }

   public void saveContrat() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.contratEnteteVentes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.contratEnteteVentes.setTiers(this.newtiers);
            this.contratEnteteVentes.setUsers(this.usersLog);
            this.contratEnteteVentes.setCrtCat(this.newtiers.getTiecategorie());
            this.contratEnteteVentes.setCrtExoDouane(this.newtiers.getTieexodouane());
            this.contratEnteteVentes.setCrtExoTva(this.newtiers.getTieexotva());
            this.contratEnteteVentes.setCrtNomTiers(this.newtiers.getPatronyme());
            this.contratEnteteVentes.setCrtDevise(this.structureLog.getStrdevise());
            this.contratEnteteVentes.setCrtEtat(0);
            if (this.contratEnteteVentes.getCrtId() == 0L) {
               this.contratEnteteVentes.setExerciceventes((ExercicesVentes)null);
               this.contratEnteteVentes.setCrtNum(this.contratEnteteVentes.getCrtAffaire());
               this.contratEnteteVentes.setCrtDateCreat(new Date());
               this.contratEnteteVentes.setCrtIdCreateur(this.usersLog.getUsrid());
               this.contratEnteteVentes = this.contratEnteteVentesDao.insert(this.contratEnteteVentes, var1);
               this.lesContratsVentes.add(this.contratEnteteVentes);
               this.dataModelConvention.setWrappedData(this.lesContratsVentes);
            } else {
               this.contratEnteteVentes.setCrtDateModif(new Date());
               this.contratEnteteVentes.setCrtIdModif(this.usersLog.getUsrid());
               this.contratEnteteVentes = this.contratEnteteVentesDao.modif(this.contratEnteteVentes, var1);
            }

            if (this.contratEnteteVentes.getCrtAffaire() != null && !this.contratEnteteVentes.getCrtAffaire().isEmpty()) {
               new Bien();
               BienDao var4 = new BienDao(this.baseLog, this.utilInitHibernate);
               Bien var3 = var4.logBienNum(this.contratEnteteVentes.getCrtAffaire(), var1);
               if (var3 != null) {
                  var3.setBieNomTiers(this.newtiers.getPatronyme());
                  var3.setBieCivilTiers(this.newtiers.getTiecivilite());
                  var3.setBieDateAchat(this.contratEnteteVentes.getCrtDate());
                  var3.setBieEtat(2);
                  var3.setTiers(this.newtiers);
                  var4.modif(var3);
               }
            }

            if (this.lesContratsEcheance.size() != 0) {
               for(int var10 = 0; var10 < this.lesContratsEcheance.size(); ++var10) {
                  this.contratEcheanceVentes = (ContratEcheanceVentes)this.lesContratsEcheance.get(var10);
                  if (this.contratEcheanceVentes.getCrtechId() == 0L) {
                     this.contratEcheanceVentes.setContratEnteteVentes(this.contratEnteteVentes);
                     this.contratEcheanceVentes = this.contratEcheanceVentesDao.insertLigne(this.contratEcheanceVentes, var1);
                  } else {
                     this.contratEcheanceVentes = this.contratEcheanceVentesDao.modifLigne(this.contratEcheanceVentes, var1);
                  }
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
      }

      this.showModalPanelContrat = false;
   }

   public void deleteContrat() throws HibernateException, NamingException {
      if (this.contratEnteteVentes != null) {
         this.showModalPanelContrat = false;
      }

   }

   public void annuleContrat() {
      this.showModalPanelContrat = false;
   }

   public void calculBien() throws HibernateException, NamingException {
      if (this.contratEnteteVentes != null && this.contratEnteteVentes.getCrtAffaire() != null && !this.contratEnteteVentes.getCrtAffaire().isEmpty()) {
         BienDao var1 = new BienDao(this.baseLog, this.utilInitHibernate);
         new Bien();
         Bien var2 = var1.logBienNum(this.contratEnteteVentes.getCrtAffaire(), (Session)null);
         if (var2 != null) {
            this.contratEnteteVentes.setCrtTotHt(var2.getBieTmpValeurPv());
         }
      }

   }

   public void calculTotalBien() {
      if (this.contratEnteteVentes != null) {
         this.contratEnteteVentes.setCrtTotTtc(this.contratEnteteVentes.getCrtTotHt() + this.contratEnteteVentes.getCrtTotTva());
         if (this.contratEnteteVentes.getCrtMode() != 0) {
            this.contratEnteteVentes.setCrtTotReste(this.contratEnteteVentes.getCrtTotTtc() - this.contratEnteteVentes.getCrtTotApport());
         } else {
            this.contratEnteteVentes.setCrtTotReste(0.0D);
         }
      }

   }

   public void calculEcheance() throws ParseException {
      if (this.contratEnteteVentes != null && this.contratEnteteVentes.getCrtNbJourReg() != 0 && this.contratEnteteVentes.getCrtDateButoire() != null && (this.lesContratsEcheance.size() == 0 || this.lesContratsEcheance.size() != this.contratEnteteVentes.getCrtNbJourReg())) {
         this.lesContratsEcheance.clear();
         UtilDate var1 = new UtilDate();
         UtilNombre var2 = new UtilNombre();
         double var3 = 0.0D;
         double var5 = this.contratEnteteVentes.getCrtTotReste();
         double var7 = var2.myRoundDevise(this.contratEnteteVentes.getCrtTotReste() / (double)this.contratEnteteVentes.getCrtNbJourReg(), this.structureLog.getStrdevise());
         Date var9 = var1.dateMoisPrecedent(this.contratEnteteVentes.getCrtDateButoire());

         for(int var10 = 0; var10 < this.contratEnteteVentes.getCrtNbJourReg(); ++var10) {
            this.contratEcheanceVentes = new ContratEcheanceVentes();
            this.contratEcheanceVentes.setContratEnteteVentes(this.contratEnteteVentes);
            var9 = var1.dateMoisSuivant(var9);
            this.contratEcheanceVentes.setCrtechDateTheo(var9);
            var5 -= var7;
            if (var10 == this.contratEnteteVentes.getCrtNbJourReg() - 1) {
               var5 = this.contratEnteteVentes.getCrtTotReste() - var3;
               this.contratEcheanceVentes.setCrtechMontantTheo(var5);
            } else {
               this.contratEcheanceVentes.setCrtechMontantTheo(var7);
            }

            var3 += var7;
            this.lesContratsEcheance.add(this.contratEcheanceVentes);
         }

         this.dataModelAdherent.setWrappedData(this.lesContratsEcheance);
      }

   }

   public void selectionEcheance() {
      if (this.dataModelAdherent.isRowAvailable()) {
         this.contratEcheanceVentes = (ContratEcheanceVentes)this.dataModelAdherent.getRowData();
         this.visibiliteEcheance = true;
      }

   }

   public void modificationEcheance() {
      if (this.contratEcheanceVentes != null) {
         this.showModalPanelEcheance = true;
      }

   }

   public void annuleEcheance() {
      this.showModalPanelEcheance = false;
   }

   public void valideEcheance() throws HibernateException, NamingException {
      if (this.contratEcheanceVentes != null) {
         this.contratEcheanceVentes = this.contratEcheanceVentesDao.modifLigne(this.contratEcheanceVentes);
      }

      this.showModalPanelEcheance = false;
   }

   public void rechercheTexteModeleContrat() throws HibernateException, NamingException {
      this.contratEnteteVentes.setCrtText("");
      this.modelesCourriersDao = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      if (this.var_code_modele != null && !this.var_code_modele.isEmpty()) {
         String var1 = "";
         if (this.var_code_modele.contains(":")) {
            String[] var2 = this.var_code_modele.split(":");
            var1 = var2[0];
         } else {
            var1 = this.var_code_modele;
         }

         new ModelesCourriers();
         ModelesCourriers var3 = this.modelesCourriersDao.rechercheModeles(var1, (Session)null);
         if (var3 != null) {
            this.contratEnteteVentes.setCrtText(var3.getModTexte());
            this.calculeTexte();
         } else {
            this.contratEnteteVentes.setCrtText("Erreur modèle");
         }
      }

   }

   public void calculeTexte() throws HibernateException, NamingException {
      if (this.contratEnteteVentes.getCrtText() != null && !this.contratEnteteVentes.getCrtText().isEmpty()) {
         this.contratEnteteVentes.setCrtText(this.utilTdt.analyseTexteCommercial(this.contratEnteteVentes.getCrtText(), this.usersLog, this.structureLog, this.newtiers));
      } else {
         this.afficheTexteContrat = true;
      }

   }

   public void imprimerQrJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimerQr();
   }

   public void imprimerQrPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimerQr();
   }

   public void imprimerQr() throws JRException, IOException, SQLException, ClassNotFoundException, Exception {
      if (this.newtiers != null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setTiersSelectionne(this.newtiers);
         this.utilPrint.setIdResponsable(this.usersLog.getUsrid());
         ArrayList var1 = new ArrayList();
         JRBeanCollectionDataSource var2 = null;
         this.utilPrint.setRapport("TiersQrCode");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Génération QR CODE");
         var1.add(this.newtiers);
         var2 = new JRBeanCollectionDataSource(var1);
         this.utilPrint.setjRBeanCollectionDataSource(var2);
         this.utilPrint.imprimeRapport();
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
      this.showModalPanelPrintContact = false;
      this.showModalPanelPrintCatalogue = false;
   }

   public void listeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else if (this.var_choix_modele == 1) {
         this.affListeDoc = true;
      } else if (this.var_choix_modele == 2) {
         this.affListeDoc = false;
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
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.newtiers, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public String calculeCheminRapport(String var1) {
      String var2 = "";
      if (this.var_choix_modele == 0) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "document" + File.separator;
      } else if (this.var_choix_modele == 1) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "liste" + File.separator;
      } else if (this.var_choix_modele == 2) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "liste" + File.separator;
      }

      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatTiers.jpg");
      if (var3.exists()) {
         var2 = "formatTiers.jpg";
      }

      return var2;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      String[] var1;
      ModelesCourriers var2;
      String var3;
      ArrayList var4;
      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            if (this.nomModeleDocument.contains(":")) {
               var1 = this.nomModeleDocument.split(":");
               new ModelesCourriers();
               this.modelesCourriersDao = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
               var2 = this.modelesCourriersDao.rechercheModeles(var1[0], (Session)null);
               if (var2 != null) {
                  var3 = "";
                  this.utilTdt = new UtilTdt();
                  var3 = this.utilTdt.analyseTexteCommercial(var2.getModTexte(), this.usersLog, this.structureLog, this.newtiers);
                  this.newtiers.setTexteCommercial(var3);
                  this.utilPrint.setRapport("tiersCommercial");
                  this.utilPrint.setCheminRapport("");
                  this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
                  this.utilPrint.setEntete("Impression société");
                  this.utilPrint.setFormat(this.format);
                  this.utilPrint.setEmetteur(this.impEmetteur);
                  this.utilPrint.setDestinataire(this.impDestinataire);
                  this.utilPrint.setDestinataireCC(this.impDestinataireCC);
                  this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
                  this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
                  this.utilPrint.setIdResponsable(0L);
                  this.utilPrint.setTiersSelectionne(this.newtiers);
                  var4 = new ArrayList();
                  var4.add(this.newtiers);
                  JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var4);
                  this.utilPrint.setjRBeanCollectionDataSource(var5);
                  this.utilPrint.setBaseLog(this.baseLog);
                  this.utilPrint.setStructureLog(this.structureLog);
                  this.utilPrint.setUsersLog(this.usersLog);
                  this.utilPrint.imprimeRapport();
               }
            } else {
               this.requete = " cmm_tiers.`tie_id`=" + this.newtiers.getTieid();
               this.utilPrint.setSource("");
               this.utilPrint.setRecordPath("");
               this.utilPrint.setRapport(this.nomModeleDocument);
               this.utilPrint.setRequete(this.requete);
               this.utilPrint.setFiltre("");
               this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setEntete("Impression société");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setEmetteur(this.impEmetteur);
               this.utilPrint.setDestinataire(this.impDestinataire);
               this.utilPrint.setDestinataireCC(this.impDestinataireCC);
               this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
               this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
               this.utilPrint.setIdResponsable(0L);
               this.utilPrint.setTiersSelectionne(this.newtiers);
               ArrayList var8 = new ArrayList();
               JRBeanCollectionDataSource var10 = new JRBeanCollectionDataSource(var8);
               this.utilPrint.setjRBeanCollectionDataSource(var10);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      } else {
         int var6;
         Tiers var19;
         if (this.var_choix_modele == 1) {
            if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
               this.utilPrint.setSource("");
               this.utilPrint.setRecordPath("");
               this.utilPrint.setRapport(this.nomModeleListe);
               this.utilPrint.setEntete("Impression de la liste des tiers");
               this.utilPrint.setRequete("");
               this.utilPrint.setFiltre("");
               this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setEmetteur(this.impEmetteur);
               this.utilPrint.setDestinataire(this.impDestinataire);
               this.utilPrint.setDestinataireCC(this.impDestinataireCC);
               this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
               this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
               this.utilPrint.setIdResponsable(0L);
               this.utilPrint.setTiersSelectionne((Tiers)null);
               var1 = null;
               JRBeanCollectionDataSource var9;
               if (!this.nomModeleListe.contains("Responsable")) {
                  var9 = new JRBeanCollectionDataSource(this.lesTiers);
               } else {
                  ArrayList var11 = new ArrayList();
                  new ArrayList();
                  if (this.lesTiers.size() != 0) {
                     Session var15 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
                     new Tiers();

                     for(var6 = 0; var6 < this.lesTiers.size(); ++var6) {
                        var19 = (Tiers)this.lesTiers.get(var6);
                        List var14 = this.responsableDao.chargerLesResponsables(var19, var15);
                        if (var14.size() != 0) {
                           for(int var7 = 0; var7 < var14.size(); ++var7) {
                              var11.add(var14.get(var7));
                           }
                        }
                     }

                     this.utilInitHibernate.closeSession();
                  }

                  var9 = new JRBeanCollectionDataSource(var11);
               }

               this.utilPrint.setjRBeanCollectionDataSource(var9);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         } else if (this.var_choix_modele == 2 && this.lesTiers.size() != 0 && this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            if (this.nomModeleDocument.contains(":")) {
               var1 = this.nomModeleDocument.split(":");
               new ModelesCourriers();
               this.modelesCourriersDao = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
               var2 = this.modelesCourriersDao.rechercheModeles(var1[0], (Session)null);
               if (var2 != null) {
                  this.utilPrint.setRapport("tiersCommercial");
                  this.utilPrint.setCheminRapport("");
                  this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
                  this.utilPrint.setEntete("Impression société");
                  this.utilPrint.setFormat(this.format);
                  this.utilPrint.setEmetteur(this.impEmetteur);
                  this.utilPrint.setDestinataire(this.impDestinataire);
                  this.utilPrint.setDestinataireCC(this.impDestinataireCC);
                  this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
                  this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
                  this.utilPrint.setIdResponsable(0L);
                  this.utilPrint.setTiersSelectionne((Tiers)null);
                  var3 = "";
                  var4 = new ArrayList();
                  this.utilTdt = new UtilTdt();
                  new Tiers();

                  for(var6 = 0; var6 < this.lesTiers.size(); ++var6) {
                     var19 = (Tiers)this.lesTiers.get(var6);
                     var3 = this.utilTdt.analyseTexteCommercial(var2.getModTexte(), this.usersLog, this.structureLog, var19);
                     var19.setTexteCommercial(var3);
                     var4.add(var19);
                  }

                  JRBeanCollectionDataSource var20 = new JRBeanCollectionDataSource(var4);
                  this.utilPrint.setjRBeanCollectionDataSource(var20);
                  this.utilPrint.setBaseLog(this.baseLog);
                  this.utilPrint.setStructureLog(this.structureLog);
                  this.utilPrint.setUsersLog(this.usersLog);
                  this.utilPrint.imprimeRapport();
               }
            } else {
               String var12 = "";
               new Tiers();

               for(int var16 = 0; var16 < this.lesTiers.size(); ++var16) {
                  Tiers var13 = (Tiers)this.lesTiers.get(var16);
                  var12 = var12 + var13.getTieid();
               }

               this.requete = " cmm_tiers.`tie_id` in (" + var12 + ")";
               this.utilPrint.setSource("");
               this.utilPrint.setRecordPath("");
               this.utilPrint.setRapport(this.nomModeleDocument);
               this.utilPrint.setRequete(this.requete);
               this.utilPrint.setFiltre("");
               this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setEntete("Impression société");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setEmetteur(this.impEmetteur);
               this.utilPrint.setDestinataire(this.impDestinataire);
               this.utilPrint.setDestinataireCC(this.impDestinataireCC);
               this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
               this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
               this.utilPrint.setIdResponsable(0L);
               this.utilPrint.setTiersSelectionne(this.newtiers);
               ArrayList var18 = new ArrayList();
               JRBeanCollectionDataSource var17 = new JRBeanCollectionDataSource(var18);
               this.utilPrint.setjRBeanCollectionDataSource(var17);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void initImpressionRib() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.visibleOptionMail = false;
      this.affMail = false;
      this.showModalPanelPrintRib = true;
   }

   public void closeImpressionRib() {
      this.showModalPanelPrintRib = false;
   }

   public void imprimerRibPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimerRib();
   }

   public void imprimerRibJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerRib();
   }

   public void imprimerRibPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerRib();
   }

   public void imprimerRibODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimerRib();
   }

   public void imprimerRibXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimerRib();
   }

   public void imprimerRibDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimerRib();
   }

   public void imprimerRibHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimerRib();
   }

   public void imprimerRibXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimerRib();
   }

   public void imprimerRibMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimerRib();
      }

   }

   public void envoieRibMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.newtiers, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public String calculeCheminRapportRib(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "rib" + File.separator;
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      return var2;
   }

   public void imprimerRib() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
         this.requete = " cmm_contacts.`con_id`=" + this.contacts.getConid();
         this.utilPrint.setSource("");
         this.utilPrint.setRecordPath("");
         this.utilPrint.setRapport(this.nomModeleDocument);
         this.utilPrint.setRequete(this.requete);
         this.utilPrint.setFiltre("");
         this.utilPrint.setCheminRapport(this.calculeCheminRapportRib("structure" + this.structureLog.getStrid()));
         this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setEntete("Impression RIB société");
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne(this.newtiers);
         ArrayList var1 = new ArrayList();
         JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
         this.utilPrint.setjRBeanCollectionDataSource(var2);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void initImpressionContact() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.visibleOptionMail = false;
      this.affMail = false;
      this.showModalPanelPrintContact = true;
   }

   public void imprimerContactPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimerContact();
   }

   public void imprimerContactJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerContact();
   }

   public void imprimerContactPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerContact();
   }

   public void imprimerContactODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimerContact();
   }

   public void imprimerContactXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimerContact();
   }

   public void imprimerContactDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimerContact();
   }

   public void imprimerContactHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimerContact();
   }

   public void imprimerContactXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimerContact();
   }

   public void imprimerContactMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimerContact();
      }

   }

   public void envoieContactMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.newtiers, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public String calculeCheminRapportContact(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "contact" + File.separator;
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      return var2;
   }

   public void imprimerContact() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setCheminRapport(this.calculeCheminRapportContact("structure" + this.structureLog.getStrid()));
         this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setEntete("Impression liste des contacts");
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesContactsListe);
         this.utilPrint.setjRBeanCollectionDataSource(var1);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public void initImpressionCatalogue() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.visibleOptionMail = false;
      this.affMail = false;
      this.showModalPanelPrintCatalogue = true;
   }

   public void imprimerCataloguePRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimerCatalogue();
   }

   public void imprimerCatalogueJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerCatalogue();
   }

   public void imprimerCataloguePDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerCatalogue();
   }

   public void imprimerCatalogueODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimerCatalogue();
   }

   public void imprimerCatalogueXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimerCatalogue();
   }

   public void imprimerCatalogueDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimerCatalogue();
   }

   public void imprimerCatalogueHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimerCatalogue();
   }

   public void imprimerCatalogueXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimerCatalogue();
   }

   public void imprimerCatalogueMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimerCatalogue();
      }

   }

   public void envoieCatalogueMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, this.newtiers, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public String calculeCheminRapportCatalogue(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "tiers" + File.separator + "catalogue" + File.separator;
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      return var2;
   }

   public void imprimerCatalogue() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setCheminRapport(this.calculeCheminRapportCatalogue("structure" + this.structureLog.getStrid()));
         this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setEntete("Impression du catalogue");
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesProduits);
         this.utilPrint.setjRBeanCollectionDataSource(var1);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public DataModel getDataModelPlanning() {
      return this.dataModelPlanning;
   }

   public void setDataModelPlanning(DataModel var1) {
      this.dataModelPlanning = var1;
   }

   public DataModel getDataModelSociete() {
      return this.dataModelSociete;
   }

   public void setDataModelSociete(DataModel var1) {
      this.dataModelSociete = var1;
   }

   public String getLibelleSousMenu() {
      return this.libelleSousMenu;
   }

   public void setLibelleSousMenu(String var1) {
      this.libelleSousMenu = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public DataModel getDatamodelResponsable() {
      return this.datamodelResponsable;
   }

   public void setDatamodelResponsable(DataModel var1) {
      this.datamodelResponsable = var1;
   }

   public Responsable getResponsable() {
      return this.responsable;
   }

   public void setResponsable(Responsable var1) {
      this.responsable = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public DataModel getDatamodelContact() {
      return this.datamodelContact;
   }

   public void setDatamodelContact(DataModel var1) {
      this.datamodelContact = var1;
   }

   public Contacts getContacts() {
      return this.contacts;
   }

   public void setContacts(Contacts var1) {
      this.contacts = var1;
   }

   public double getSoldeDebCred() {
      return this.SoldeDebCred;
   }

   public void setSoldeDebCred(double var1) {
      this.SoldeDebCred = var1;
   }

   public double getTotalCred() {
      return this.totalCred;
   }

   public void setTotalCred(double var1) {
      this.totalCred = var1;
   }

   public double getTotalDeb() {
      return this.totalDeb;
   }

   public void setTotalDeb(double var1) {
      this.totalDeb = var1;
   }

   public ExercicesComptable getExerciceSelectionne() {
      return this.exerciceSelectionne;
   }

   public void setExerciceSelectionne(ExercicesComptable var1) {
      this.exerciceSelectionne = var1;
   }

   public String getSelectedUserdest() {
      return this.selectedUserdest;
   }

   public void setSelectedUserdest(String var1) {
      this.selectedUserdest = var1;
   }

   public ObjetLigneMenu getLigneMenu() {
      return this.ligneMenu;
   }

   public void setLigneMenu(ObjetLigneMenu var1) {
      this.ligneMenu = var1;
   }

   public Tiers getNewtiers() {
      return this.newtiers;
   }

   public void setNewtiers(Tiers var1) {
      this.newtiers = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
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

   public boolean isShowModalGoogleMap() {
      return this.showModalGoogleMap;
   }

   public void setShowModalGoogleMap(boolean var1) {
      this.showModalGoogleMap = var1;
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

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isAfficheButtOption() {
      return this.afficheButtOption;
   }

   public void setAfficheButtOption(boolean var1) {
      this.afficheButtOption = var1;
   }

   public boolean isComptaExist() {
      return this.comptaExist;
   }

   public void setComptaExist(boolean var1) {
      this.comptaExist = var1;
   }

   public ObjetImmatriculation getObjetImmatriculation() {
      return this.objetImmatriculation;
   }

   public void setObjetImmatriculation(ObjetImmatriculation var1) {
      this.objetImmatriculation = var1;
   }

   public List getMesCompteItem() {
      return this.mesCompteItem;
   }

   public void setMesCompteItem(List var1) {
      this.mesCompteItem = var1;
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

   public boolean isShowModalPanelImmatriculation() {
      return this.showModalPanelImmatriculation;
   }

   public void setShowModalPanelImmatriculation(boolean var1) {
      this.showModalPanelImmatriculation = var1;
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

   public List getMesNatureCompteItem() {
      return this.mesNatureCompteItem;
   }

   public void setMesNatureCompteItem(List var1) {
      this.mesNatureCompteItem = var1;
   }

   public List getMesRacineCompteItem() {
      return this.mesRacineCompteItem;
   }

   public void setMesRacineCompteItem(List var1) {
      this.mesRacineCompteItem = var1;
   }

   public String getPartieCompte() {
      return this.partieCompte;
   }

   public void setPartieCompte(String var1) {
      this.partieCompte = var1;
   }

   public String getRacinecle() {
      return this.racinecle;
   }

   public void setRacinecle(String var1) {
      this.racinecle = var1;
   }

   public boolean isExisteCopteDeja() {
      return this.existeCopteDeja;
   }

   public void setExisteCopteDeja(boolean var1) {
      this.existeCopteDeja = var1;
   }

   public long getExoCpte() {
      return this.exoCpte;
   }

   public void setExoCpte(long var1) {
      this.exoCpte = var1;
   }

   public int getNombrCaracter() {
      return this.nombrCaracter;
   }

   public void setNombrCaracter(int var1) {
      this.nombrCaracter = var1;
   }

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
   }

   public List getLesFamillesClientsListe() {
      return this.lesFamillesClientsListe;
   }

   public void setLesFamillesClientsListe(List var1) {
      this.lesFamillesClientsListe = var1;
   }

   public List getLesFamillesFournisseursListe() {
      return this.lesFamillesFournisseursListe;
   }

   public void setLesFamillesFournisseursListe(List var1) {
      this.lesFamillesFournisseursListe = var1;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
   }

   public boolean isVenteExist() {
      return this.venteExist;
   }

   public void setVenteExist(boolean var1) {
      this.venteExist = var1;
   }

   public boolean isAchatExist() {
      return this.achatExist;
   }

   public void setAchatExist(boolean var1) {
      this.achatExist = var1;
   }

   public String getDevise() {
      return this.devise;
   }

   public void setDevise(String var1) {
      this.devise = var1;
   }

   public int getTypeTiers() {
      return this.typeTiers;
   }

   public void setTypeTiers(int var1) {
      this.typeTiers = var1;
   }

   public List getLesPlanning() {
      return this.lesPlanning;
   }

   public void setLesPlanning(List var1) {
      this.lesPlanning = var1;
   }

   public boolean isShowModalPanelRdv() {
      return this.showModalPanelRdv;
   }

   public void setShowModalPanelRdv(boolean var1) {
      this.showModalPanelRdv = var1;
   }

   public boolean isTestRdv() {
      return this.testRdv;
   }

   public void setTestRdv(boolean var1) {
      this.testRdv = var1;
   }

   public List getMesTachesItem() {
      return this.mesTachesItem;
   }

   public void setMesTachesItem(List var1) {
      this.mesTachesItem = var1;
   }

   public String getChoixTache() {
      return this.choixTache;
   }

   public void setChoixTache(String var1) {
      this.choixTache = var1;
   }

   public int getChoixRdv() {
      return this.choixRdv;
   }

   public void setChoixRdv(int var1) {
      this.choixRdv = var1;
   }

   public DataModel getDataModelConvention() {
      return this.dataModelConvention;
   }

   public void setDataModelConvention(DataModel var1) {
      this.dataModelConvention = var1;
   }

   public List getMesLettresItem() {
      return this.mesLettresItem;
   }

   public void setMesLettresItem(List var1) {
      this.mesLettresItem = var1;
   }

   public int getVar_action_convention() {
      return this.var_action_convention;
   }

   public void setVar_action_convention(int var1) {
      this.var_action_convention = var1;
   }

   public ConventionMedical getConventionMedical() {
      return this.conventionMedical;
   }

   public void setConventionMedical(ConventionMedical var1) {
      this.conventionMedical = var1;
   }

   public String getChoixLettre() {
      return this.choixLettre;
   }

   public void setChoixLettre(String var1) {
      this.choixLettre = var1;
   }

   public boolean isAfficheButtConvention() {
      return this.afficheButtConvention;
   }

   public void setAfficheButtConvention(boolean var1) {
      this.afficheButtConvention = var1;
   }

   public DataModel getDataModelDepot() {
      return this.dataModelDepot;
   }

   public void setDataModelDepot(DataModel var1) {
      this.dataModelDepot = var1;
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

   public boolean isTestDoubleResponsable() {
      return this.testDoubleResponsable;
   }

   public void setTestDoubleResponsable(boolean var1) {
      this.testDoubleResponsable = var1;
   }

   public boolean isTestContact() {
      return this.testContact;
   }

   public void setTestContact(boolean var1) {
      this.testContact = var1;
   }

   public List getLesEcritures() {
      return this.lesEcritures;
   }

   public void setLesEcritures(List var1) {
      this.lesEcritures = var1;
   }

   public String getChoixUsers() {
      return this.choixUsers;
   }

   public void setChoixUsers(String var1) {
      this.choixUsers = var1;
   }

   public int getCpteTiers() {
      return this.cpteTiers;
   }

   public void setCpteTiers(int var1) {
      this.cpteTiers = var1;
   }

   public int getEtatEcr() {
      return this.etatEcr;
   }

   public void setEtatEcr(int var1) {
      this.etatEcr = var1;
   }

   public List getLesReglementsClient() {
      return this.lesReglementsClient;
   }

   public void setLesReglementsClient(List var1) {
      this.lesReglementsClient = var1;
   }

   public List getLesReglementsFournisseur() {
      return this.lesReglementsFournisseur;
   }

   public void setLesReglementsFournisseur(List var1) {
      this.lesReglementsFournisseur = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
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

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public Rdv getNewRdv() {
      return this.newRdv;
   }

   public void setNewRdv(Rdv var1) {
      this.newRdv = var1;
   }

   public int getTypeRdv() {
      return this.typeRdv;
   }

   public void setTypeRdv(int var1) {
      this.typeRdv = var1;
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

   public boolean isShowModalPanelBanque() {
      return this.showModalPanelBanque;
   }

   public void setShowModalPanelBanque(boolean var1) {
      this.showModalPanelBanque = var1;
   }

   public boolean isShowModalPanelContact() {
      return this.showModalPanelContact;
   }

   public void setShowModalPanelContact(boolean var1) {
      this.showModalPanelContact = var1;
   }

   public boolean isShowModalPanelConvention() {
      return this.showModalPanelConvention;
   }

   public void setShowModalPanelConvention(boolean var1) {
      this.showModalPanelConvention = var1;
   }

   public boolean isShowModalPanelMessagerie() {
      return this.showModalPanelMessagerie;
   }

   public void setShowModalPanelMessagerie(boolean var1) {
      this.showModalPanelMessagerie = var1;
   }

   public boolean isShowModalPanelResponsable() {
      return this.showModalPanelResponsable;
   }

   public void setShowModalPanelResponsable(boolean var1) {
      this.showModalPanelResponsable = var1;
   }

   public FormMessagerie getFormMessagerie() {
      return this.formMessagerie;
   }

   public void setFormMessagerie(FormMessagerie var1) {
      this.formMessagerie = var1;
   }

   public boolean isVar_tiersDivers() {
      return this.var_tiersDivers;
   }

   public void setVar_tiersDivers(boolean var1) {
      this.var_tiersDivers = var1;
   }

   public int getChoixDocument() {
      return this.choixDocument;
   }

   public void setChoixDocument(int var1) {
      this.choixDocument = var1;
   }

   public DataModel getDataModelDocuments() {
      return this.dataModelDocuments;
   }

   public void setDataModelDocuments(DataModel var1) {
      this.dataModelDocuments = var1;
   }

   public Date getDateDebut() {
      return this.dateDebut;
   }

   public void setDateDebut(Date var1) {
      this.dateDebut = var1;
   }

   public Date getDateFin() {
      return this.dateFin;
   }

   public void setDateFin(Date var1) {
      this.dateFin = var1;
   }

   public String getChoixFamilles() {
      return this.choixFamilles;
   }

   public void setChoixFamilles(String var1) {
      this.choixFamilles = var1;
   }

   public List getMesFamilles() {
      return this.mesFamilles;
   }

   public void setMesFamilles(List var1) {
      this.mesFamilles = var1;
   }

   public float getVar_qte() {
      return this.var_qte;
   }

   public void setVar_qte(float var1) {
      this.var_qte = var1;
   }

   public double getVar_total() {
      return this.var_total;
   }

   public void setVar_total(double var1) {
      this.var_total = var1;
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

   public List getMesJournauxComptables() {
      return this.mesJournauxComptables;
   }

   public void setMesJournauxComptables(List var1) {
      this.mesJournauxComptables = var1;
   }

   public DataModel getDataModelCatalogue() {
      return this.dataModelCatalogue;
   }

   public void setDataModelCatalogue(DataModel var1) {
      this.dataModelCatalogue = var1;
   }

   public DataModel getDataModelDocumentsEntete() {
      return this.dataModelDocumentsEntete;
   }

   public void setDataModelDocumentsEntete(DataModel var1) {
      this.dataModelDocumentsEntete = var1;
   }

   public double getVar_reglement() {
      return this.var_reglement;
   }

   public void setVar_reglement(double var1) {
      this.var_reglement = var1;
   }

   public double getVar_solde() {
      return this.var_solde;
   }

   public void setVar_solde(double var1) {
      this.var_solde = var1;
   }

   public Baremes getBaremes() {
      return this.baremes;
   }

   public void setBaremes(Baremes var1) {
      this.baremes = var1;
   }

   public DataModel getDataModelBaremes() {
      return this.dataModelBaremes;
   }

   public void setDataModelBaremes(DataModel var1) {
      this.dataModelBaremes = var1;
   }

   public boolean isShowModalPanelRemise() {
      return this.showModalPanelRemise;
   }

   public void setShowModalPanelRemise(boolean var1) {
      this.showModalPanelRemise = var1;
   }

   public List getMesFamilleVentestems() {
      return this.mesFamilleVentestems;
   }

   public void setMesFamilleVentestems(List var1) {
      this.mesFamilleVentestems = var1;
   }

   public String getVar_famille_produit() {
      return this.var_famille_produit;
   }

   public void setVar_famille_produit(String var1) {
      this.var_famille_produit = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public boolean isTestRemise() {
      return this.testRemise;
   }

   public void setTestRemise(boolean var1) {
      this.testRemise = var1;
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

   public String getChoixProduit() {
      return this.choixProduit;
   }

   public void setChoixProduit(String var1) {
      this.choixProduit = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public boolean isShowModalPanelPrintRib() {
      return this.showModalPanelPrintRib;
   }

   public void setShowModalPanelPrintRib(boolean var1) {
      this.showModalPanelPrintRib = var1;
   }

   public List getMesActivitesSocietesItems() {
      return this.mesActivitesSocietesItems;
   }

   public void setMesActivitesSocietesItems(List var1) {
      this.mesActivitesSocietesItems = var1;
   }

   public boolean isChoixGenre() {
      return this.choixGenre;
   }

   public void setChoixGenre(boolean var1) {
      this.choixGenre = var1;
   }

   public List getMesObservationsItems() {
      return this.mesObservationsItems;
   }

   public void setMesObservationsItems(List var1) {
      this.mesObservationsItems = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
   }

   public String getActivitesRec() {
      return this.activitesRec;
   }

   public void setActivitesRec(String var1) {
      this.activitesRec = var1;
   }

   public String getAppreciationRec() {
      return this.appreciationRec;
   }

   public void setAppreciationRec(String var1) {
      this.appreciationRec = var1;
   }

   public String getCategorieRec() {
      return this.categorieRec;
   }

   public void setCategorieRec(String var1) {
      this.categorieRec = var1;
   }

   public String getFamilleRec() {
      return this.familleRec;
   }

   public void setFamilleRec(String var1) {
      this.familleRec = var1;
   }

   public String getNomRec() {
      return this.nomRec;
   }

   public void setNomRec(String var1) {
      this.nomRec = var1;
   }

   public String getObservationsRec() {
      return this.observationsRec;
   }

   public void setObservationsRec(String var1) {
      this.observationsRec = var1;
   }

   public String getPaysRec() {
      return this.paysRec;
   }

   public void setPaysRec(String var1) {
      this.paysRec = var1;
   }

   public String getPdvRec() {
      return this.pdvRec;
   }

   public void setPdvRec(String var1) {
      this.pdvRec = var1;
   }

   public String getVilleRec() {
      return this.villeRec;
   }

   public void setVilleRec(String var1) {
      this.villeRec = var1;
   }

   public String getTelRec() {
      return this.telRec;
   }

   public void setTelRec(String var1) {
      this.telRec = var1;
   }

   public boolean isContactBanque() {
      return this.contactBanque;
   }

   public void setContactBanque(boolean var1) {
      this.contactBanque = var1;
   }

   public String getMailRec() {
      return this.mailRec;
   }

   public void setMailRec(String var1) {
      this.mailRec = var1;
   }

   public String getPrenomRec() {
      return this.prenomRec;
   }

   public void setPrenomRec(String var1) {
      this.prenomRec = var1;
   }

   public String getFonctionRec() {
      return this.fonctionRec;
   }

   public void setFonctionRec(String var1) {
      this.fonctionRec = var1;
   }

   public String getObsRec() {
      return this.obsRec;
   }

   public void setObsRec(String var1) {
      this.obsRec = var1;
   }

   public String getServiceRec() {
      return this.serviceRec;
   }

   public void setServiceRec(String var1) {
      this.serviceRec = var1;
   }

   public boolean isShowModalPanelPrintContact() {
      return this.showModalPanelPrintContact;
   }

   public void setShowModalPanelPrintContact(boolean var1) {
      this.showModalPanelPrintContact = var1;
   }

   public String getTypeRec() {
      return this.typeRec;
   }

   public void setTypeRec(String var1) {
      this.typeRec = var1;
   }

   public boolean isShowModalSupTiers() {
      return this.showModalSupTiers;
   }

   public void setShowModalSupTiers(boolean var1) {
      this.showModalSupTiers = var1;
   }

   public String getSuppressionRejet() {
      return this.suppressionRejet;
   }

   public void setSuppressionRejet(String var1) {
      this.suppressionRejet = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public DataModel getDataModelParticipants() {
      return this.dataModelParticipants;
   }

   public void setDataModelParticipants(DataModel var1) {
      this.dataModelParticipants = var1;
   }

   public DataModel getDataModelParticipantsContact() {
      return this.dataModelParticipantsContact;
   }

   public void setDataModelParticipantsContact(DataModel var1) {
      this.dataModelParticipantsContact = var1;
   }

   public CampagneParticipantVentes getCampagneParticipantVentes() {
      return this.campagneParticipantVentes;
   }

   public void setCampagneParticipantVentes(CampagneParticipantVentes var1) {
      this.campagneParticipantVentes = var1;
   }

   public boolean isShowModalPanelParticipant() {
      return this.showModalPanelParticipant;
   }

   public void setShowModalPanelParticipant(boolean var1) {
      this.showModalPanelParticipant = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public boolean isImmobExist() {
      return this.immobExist;
   }

   public void setImmobExist(boolean var1) {
      this.immobExist = var1;
   }

   public int getInpInactif() {
      return this.inpInactif;
   }

   public void setInpInactif(int var1) {
      this.inpInactif = var1;
   }

   public DataModel getDataModelBaux() {
      return this.dataModelBaux;
   }

   public void setDataModelBaux(DataModel var1) {
      this.dataModelBaux = var1;
   }

   public DataModel getDataModelBiens() {
      return this.dataModelBiens;
   }

   public void setDataModelBiens(DataModel var1) {
      this.dataModelBiens = var1;
   }

   public DataModel getDataModelGerances() {
      return this.dataModelGerances;
   }

   public void setDataModelGerances(DataModel var1) {
      this.dataModelGerances = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isInterimExist() {
      return this.interimExist;
   }

   public void setInterimExist(boolean var1) {
      this.interimExist = var1;
   }

   public String getMessageSms() {
      return this.messageSms;
   }

   public void setMessageSms(String var1) {
      this.messageSms = var1;
   }

   public boolean isShowModalPanelSms() {
      return this.showModalPanelSms;
   }

   public void setShowModalPanelSms(boolean var1) {
      this.showModalPanelSms = var1;
   }

   public String getNumeroMobile() {
      return this.numeroMobile;
   }

   public void setNumeroMobile(String var1) {
      this.numeroMobile = var1;
   }

   public DataModel getDataModelCatalogueFichier() {
      return this.dataModelCatalogueFichier;
   }

   public void setDataModelCatalogueFichier(DataModel var1) {
      this.dataModelCatalogueFichier = var1;
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

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public int getCompteLitige() {
      return this.compteLitige;
   }

   public void setCompteLitige(int var1) {
      this.compteLitige = var1;
   }

   public boolean isShowModalPanelIncident() {
      return this.showModalPanelIncident;
   }

   public void setShowModalPanelIncident(boolean var1) {
      this.showModalPanelIncident = var1;
   }

   public DataModel getDataModelIncidents() {
      return this.dataModelIncidents;
   }

   public void setDataModelIncidents(DataModel var1) {
      this.dataModelIncidents = var1;
   }

   public DataModel getDataModelReglements() {
      return this.dataModelReglements;
   }

   public void setDataModelReglements(DataModel var1) {
      this.dataModelReglements = var1;
   }

   public double getTotDocument() {
      return this.totDocument;
   }

   public void setTotDocument(double var1) {
      this.totDocument = var1;
   }

   public double getTotReglement() {
      return this.totReglement;
   }

   public void setTotReglement(double var1) {
      this.totReglement = var1;
   }

   public DataModel getDataModelCadeaux() {
      return this.dataModelCadeaux;
   }

   public void setDataModelCadeaux(DataModel var1) {
      this.dataModelCadeaux = var1;
   }

   public boolean isShowModalPanelPrintCatalogue() {
      return this.showModalPanelPrintCatalogue;
   }

   public void setShowModalPanelPrintCatalogue(boolean var1) {
      this.showModalPanelPrintCatalogue = var1;
   }

   public boolean isMedicalExist() {
      return this.medicalExist;
   }

   public void setMedicalExist(boolean var1) {
      this.medicalExist = var1;
   }

   public boolean isAffiche_convention() {
      return this.affiche_convention;
   }

   public void setAffiche_convention(boolean var1) {
      this.affiche_convention = var1;
   }

   public boolean isAffiche_adhesion() {
      return this.affiche_adhesion;
   }

   public void setAffiche_adhesion(boolean var1) {
      this.affiche_adhesion = var1;
   }

   public DataModel getDataModelAdherent() {
      return this.dataModelAdherent;
   }

   public void setDataModelAdherent(DataModel var1) {
      this.dataModelAdherent = var1;
   }

   public boolean isShowModalPanelAdherent() {
      return this.showModalPanelAdherent;
   }

   public void setShowModalPanelAdherent(boolean var1) {
      this.showModalPanelAdherent = var1;
   }

   public boolean isAfficheButtAdherent() {
      return this.afficheButtAdherent;
   }

   public void setAfficheButtAdherent(boolean var1) {
      this.afficheButtAdherent = var1;
   }

   public TiersAdherent getTiersAdherent() {
      return this.tiersAdherent;
   }

   public void setTiersAdherent(TiersAdherent var1) {
      this.tiersAdherent = var1;
   }

   public DataModel getDataModelServiceInterim() {
      return this.dataModelServiceInterim;
   }

   public void setDataModelServiceInterim(DataModel var1) {
      this.dataModelServiceInterim = var1;
   }

   public Site getServiceInterim() {
      return this.serviceInterim;
   }

   public void setServiceInterim(Site var1) {
      this.serviceInterim = var1;
   }

   public boolean isShomModalPanelServiceInterim() {
      return this.shomModalPanelServiceInterim;
   }

   public void setShomModalPanelServiceInterim(boolean var1) {
      this.shomModalPanelServiceInterim = var1;
   }

   public boolean isAfficheServiceInterim() {
      return this.afficheServiceInterim;
   }

   public void setAfficheServiceInterim(boolean var1) {
      this.afficheServiceInterim = var1;
   }

   public String getCodeAgence() {
      return this.codeAgence;
   }

   public void setCodeAgence(String var1) {
      this.codeAgence = var1;
   }

   public String getCodeBanque() {
      return this.codeBanque;
   }

   public void setCodeBanque(String var1) {
      this.codeBanque = var1;
   }

   public String getNumCompte() {
      return this.numCompte;
   }

   public void setNumCompte(String var1) {
      this.numCompte = var1;
   }

   public String getNumCleCtrl() {
      return this.numCleCtrl;
   }

   public void setNumCleCtrl(String var1) {
      this.numCleCtrl = var1;
   }

   public boolean isModifAgence() {
      return this.modifAgence;
   }

   public void setModifAgence(boolean var1) {
      this.modifAgence = var1;
   }

   public DataModel getDataModelDocumnts() {
      return this.dataModelDocumnts;
   }

   public void setDataModelDocumnts(DataModel var1) {
      this.dataModelDocumnts = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public String getNomDocument() {
      return this.nomDocument;
   }

   public void setNomDocument(String var1) {
      this.nomDocument = var1;
   }

   public long getConseillersRec() {
      return this.conseillersRec;
   }

   public void setConseillersRec(long var1) {
      this.conseillersRec = var1;
   }

   public DataModel getDatamodelProcuration() {
      return this.datamodelProcuration;
   }

   public void setDatamodelProcuration(DataModel var1) {
      this.datamodelProcuration = var1;
   }

   public DataModel getDatamodelTestament() {
      return this.datamodelTestament;
   }

   public void setDatamodelTestament(DataModel var1) {
      this.datamodelTestament = var1;
   }

   public boolean isShowModalPanelProcuration() {
      return this.showModalPanelProcuration;
   }

   public void setShowModalPanelProcuration(boolean var1) {
      this.showModalPanelProcuration = var1;
   }

   public boolean isShowModalPanelTestament() {
      return this.showModalPanelTestament;
   }

   public void setShowModalPanelTestament(boolean var1) {
      this.showModalPanelTestament = var1;
   }

   public Contacts getContactsProcuration() {
      return this.contactsProcuration;
   }

   public void setContactsProcuration(Contacts var1) {
      this.contactsProcuration = var1;
   }

   public Contacts getContactsTestament() {
      return this.contactsTestament;
   }

   public void setContactsTestament(Contacts var1) {
      this.contactsTestament = var1;
   }

   public String getUrlphotoProcuration() {
      return this.urlphotoProcuration;
   }

   public void setUrlphotoProcuration(String var1) {
      this.urlphotoProcuration = var1;
   }

   public String getUrlsignatureProcuration() {
      return this.urlsignatureProcuration;
   }

   public void setUrlsignatureProcuration(String var1) {
      this.urlsignatureProcuration = var1;
   }

   public double getCaHt() {
      return this.caHt;
   }

   public void setCaHt(double var1) {
      this.caHt = var1;
   }

   public double getCaJour() {
      return this.caJour;
   }

   public void setCaJour(double var1) {
      this.caJour = var1;
   }

   public double getCaMoyen() {
      return this.caMoyen;
   }

   public void setCaMoyen(double var1) {
      this.caMoyen = var1;
   }

   public double getCaTrf() {
      return this.caTrf;
   }

   public void setCaTrf(double var1) {
      this.caTrf = var1;
   }

   public int getNbDoc() {
      return this.nbDoc;
   }

   public void setNbDoc(int var1) {
      this.nbDoc = var1;
   }

   public int getNbJour() {
      return this.nbJour;
   }

   public void setNbJour(int var1) {
      this.nbJour = var1;
   }

   public int getNbProduit() {
      return this.nbProduit;
   }

   public void setNbProduit(int var1) {
      this.nbProduit = var1;
   }

   public int getNbTrf() {
      return this.nbTrf;
   }

   public void setNbTrf(int var1) {
      this.nbTrf = var1;
   }

   public float getTauxJour() {
      return this.tauxJour;
   }

   public void setTauxJour(float var1) {
      this.tauxJour = var1;
   }

   public float getTauxTrf() {
      return this.tauxTrf;
   }

   public void setTauxTrf(float var1) {
      this.tauxTrf = var1;
   }

   public int getSansSources() {
      return this.sansSources;
   }

   public void setSansSources(int var1) {
      this.sansSources = var1;
   }

   public double getPrixMoyen() {
      return this.prixMoyen;
   }

   public void setPrixMoyen(double var1) {
      this.prixMoyen = var1;
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

   public boolean isShowModalPanelRistourne() {
      return this.showModalPanelRistourne;
   }

   public void setShowModalPanelRistourne(boolean var1) {
      this.showModalPanelRistourne = var1;
   }

   public boolean isTestRistourne() {
      return this.testRistourne;
   }

   public void setTestRistourne(boolean var1) {
      this.testRistourne = var1;
   }

   public List getMesSeries() {
      return this.mesSeries;
   }

   public void setMesSeries(List var1) {
      this.mesSeries = var1;
   }

   public String getChoixSeries() {
      return this.choixSeries;
   }

   public void setChoixSeries(String var1) {
      this.choixSeries = var1;
   }

   public Date getDateRistourne() {
      return this.dateRistourne;
   }

   public void setDateRistourne(Date var1) {
      this.dateRistourne = var1;
   }

   public double getMontantRistourne() {
      return this.montantRistourne;
   }

   public void setMontantRistourne(double var1) {
      this.montantRistourne = var1;
   }

   public boolean isShowModalPanelDepot() {
      return this.showModalPanelDepot;
   }

   public void setShowModalPanelDepot(boolean var1) {
      this.showModalPanelDepot = var1;
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

   public boolean isShowModalPanelTransfert() {
      return this.showModalPanelTransfert;
   }

   public void setShowModalPanelTransfert(boolean var1) {
      this.showModalPanelTransfert = var1;
   }

   public List getListBeneficiaireItems() {
      return this.listBeneficiaireItems;
   }

   public void setListBeneficiaireItems(List var1) {
      this.listBeneficiaireItems = var1;
   }

   public long getIdBeneficiaire() {
      return this.idBeneficiaire;
   }

   public void setIdBeneficiaire(long var1) {
      this.idBeneficiaire = var1;
   }

   public double getMontantMax() {
      return this.montantMax;
   }

   public void setMontantMax(double var1) {
      this.montantMax = var1;
   }

   public DataModel getDataModelConditionCalcul() {
      return this.dataModelConditionCalcul;
   }

   public void setDataModelConditionCalcul(DataModel var1) {
      this.dataModelConditionCalcul = var1;
   }

   public FraisTheoAchats getFraisTheoAchats() {
      return this.fraisTheoAchats;
   }

   public void setFraisTheoAchats(FraisTheoAchats var1) {
      this.fraisTheoAchats = var1;
   }

   public DataModel getDataModelProdExoTva() {
      return this.dataModelProdExoTva;
   }

   public void setDataModelProdExoTva(DataModel var1) {
      this.dataModelProdExoTva = var1;
   }

   public boolean isAbnExist() {
      return this.abnExist;
   }

   public void setAbnExist(boolean var1) {
      this.abnExist = var1;
   }

   public String getRegRec() {
      return this.regRec;
   }

   public void setRegRec(String var1) {
      this.regRec = var1;
   }

   public long getVar_memo_id_master() {
      return this.var_memo_id_master;
   }

   public void setVar_memo_id_master(long var1) {
      this.var_memo_id_master = var1;
   }

   public boolean isGestionTiers() {
      return this.gestionTiers;
   }

   public void setGestionTiers(boolean var1) {
      this.gestionTiers = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public String getGenreTiers() {
      return this.genreTiers;
   }

   public void setGenreTiers(String var1) {
      this.genreTiers = var1;
   }

   public boolean isShowModalPanelContrat() {
      return this.showModalPanelContrat;
   }

   public void setShowModalPanelContrat(boolean var1) {
      this.showModalPanelContrat = var1;
   }

   public ContratEnteteVentes getContratEnteteVentes() {
      return this.contratEnteteVentes;
   }

   public void setContratEnteteVentes(ContratEnteteVentes var1) {
      this.contratEnteteVentes = var1;
   }

   public List getMesContactItem() {
      return this.mesContactItem;
   }

   public void setMesContactItem(List var1) {
      this.mesContactItem = var1;
   }

   public List getMesModelesItems() {
      return this.mesModelesItems;
   }

   public void setMesModelesItems(List var1) {
      this.mesModelesItems = var1;
   }

   public boolean isAfficheTexteContrat() {
      return this.afficheTexteContrat;
   }

   public void setAfficheTexteContrat(boolean var1) {
      this.afficheTexteContrat = var1;
   }

   public String getVar_code_modele() {
      return this.var_code_modele;
   }

   public void setVar_code_modele(String var1) {
      this.var_code_modele = var1;
   }

   public List getMesBiensItems() {
      return this.mesBiensItems;
   }

   public void setMesBiensItems(List var1) {
      this.mesBiensItems = var1;
   }

   public boolean isVisibiliteContrat() {
      return this.visibiliteContrat;
   }

   public void setVisibiliteContrat(boolean var1) {
      this.visibiliteContrat = var1;
   }

   public boolean isShowModalPanelEcheance() {
      return this.showModalPanelEcheance;
   }

   public void setShowModalPanelEcheance(boolean var1) {
      this.showModalPanelEcheance = var1;
   }

   public boolean isVisibiliteEcheance() {
      return this.visibiliteEcheance;
   }

   public void setVisibiliteEcheance(boolean var1) {
      this.visibiliteEcheance = var1;
   }

   public ContratEcheanceVentes getContratEcheanceVentes() {
      return this.contratEcheanceVentes;
   }

   public void setContratEcheanceVentes(ContratEcheanceVentes var1) {
      this.contratEcheanceVentes = var1;
   }

   public boolean isValideFiche() {
      return this.valideFiche;
   }

   public void setValideFiche(boolean var1) {
      this.valideFiche = var1;
   }

   public String getNomCreateur() {
      return this.nomCreateur;
   }

   public void setNomCreateur(String var1) {
      this.nomCreateur = var1;
   }

   public List getMesNaturesRdvItems() {
      return this.mesNaturesRdvItems;
   }

   public void setMesNaturesRdvItems(List var1) {
      this.mesNaturesRdvItems = var1;
   }

   public String getObservationsDirectRec() {
      return this.observationsDirectRec;
   }

   public void setObservationsDirectRec(String var1) {
      this.observationsDirectRec = var1;
   }

   public String getEvenementRec() {
      return this.evenementRec;
   }

   public void setEvenementRec(String var1) {
      this.evenementRec = var1;
   }

   public List getMesEvenementsItems() {
      return this.mesEvenementsItems;
   }

   public void setMesEvenementsItems(List var1) {
      this.mesEvenementsItems = var1;
   }

   public DataModel getDataModelCentreInteret() {
      return this.dataModelCentreInteret;
   }

   public void setDataModelCentreInteret(DataModel var1) {
      this.dataModelCentreInteret = var1;
   }

   public boolean isShowModalPanelCentreInteret() {
      return this.showModalPanelCentreInteret;
   }

   public void setShowModalPanelCentreInteret(boolean var1) {
      this.showModalPanelCentreInteret = var1;
   }

   public String getCentreInteretRec() {
      return this.centreInteretRec;
   }

   public void setCentreInteretRec(String var1) {
      this.centreInteretRec = var1;
   }

   public List getMesCentresIntereItems() {
      return this.mesCentresIntereItems;
   }

   public void setMesCentresIntereItems(List var1) {
      this.mesCentresIntereItems = var1;
   }

   public String getOrigineRec() {
      return this.origineRec;
   }

   public void setOrigineRec(String var1) {
      this.origineRec = var1;
   }

   public String getSitMatRec() {
      return this.sitMatRec;
   }

   public void setSitMatRec(String var1) {
      this.sitMatRec = var1;
   }

   public boolean isChronoActif() {
      return this.chronoActif;
   }

   public void setChronoActif(boolean var1) {
      this.chronoActif = var1;
   }

   public Chrono getChrono() {
      return this.chrono;
   }

   public void setChrono(Chrono var1) {
      this.chrono = var1;
   }
}
