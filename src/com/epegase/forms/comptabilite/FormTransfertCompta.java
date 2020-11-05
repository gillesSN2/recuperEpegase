package com.epegase.forms.comptabilite;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneAchats;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.BienFacture;
import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinMois;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesOperations;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.ConsultationActes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DocumentTraceAchats;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteMedical;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureInterneEnteteVentes;
import com.epegase.systeme.classe.FactureInterneLigneVentes;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FactureLigneMedical;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.FraisLigneAchats;
import com.epegase.systeme.classe.HospitalisationActes;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.HospitalisationLabo;
import com.epegase.systeme.classe.HospitalisationMedi;
import com.epegase.systeme.classe.HospitalisationPrest;
import com.epegase.systeme.classe.HospitalisationSejour;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LaboratoireLigne;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.NoteDebitLigneAchats;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesPretsLignes;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.TicketEnteteVentes;
import com.epegase.systeme.classe.TicketLigneVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.control.TransfertCompta;
import com.epegase.systeme.control.TransfertVentes;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BienFactureDao;
import com.epegase.systeme.dao.BrouillardDao;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.BulletinMoisDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CaissesOperationsDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DocumentTraceAchatsDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureEnteteMedicalDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneLigneVentesDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneMedicalDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FeuilleCalculDao;
import com.epegase.systeme.dao.FeuilleCalculRubriqueDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.HospitalisationActesDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.HospitalisationLaboDao;
import com.epegase.systeme.dao.HospitalisationMediDao;
import com.epegase.systeme.dao.HospitalisationPrestDao;
import com.epegase.systeme.dao.HospitalisationSejourDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.JournauxMoisDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LaboratoireLigneDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RacinesDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.SalariesPretsLignesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TicketEnteteVentesDao;
import com.epegase.systeme.dao.TicketLigneVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilExcel;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.xml.LectureFamillesFournisseurs;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LireLesoptionsAchats;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.LireLesoptionsMedical;
import com.epegase.systeme.xml.LireLesoptionsPaye;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetPays;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionMedical;
import com.epegase.systeme.xml.OptionPaye;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormTransfertCompta implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private int var_memo_action;
   private String pageIndex;
   private FormRecherche formRecherche;
   private int nature;
   private OptionComptabilite optionComptabilite;
   private OptionVentes optionVentes;
   private OptionAchats optionAchats;
   private OptionMedical optionMedical;
   private List lesTransfertCompta = new ArrayList();
   private List lesTransfertVentes = new ArrayList();
   private transient DataModel dataModelTransfertCompta = new ListDataModel();
   private List lesTransfertErreur = new ArrayList();
   private transient DataModel dataModelTransfertErreur = new ListDataModel();
   private TransfertCompta transfertCompta;
   private TransfertVentes transfertVentes;
   private TransfertCompta transfertErreur;
   private Date datedefin;
   private double totalDeb;
   private double totalCred;
   private double ecart;
   private int nbligne;
   private int pljFormatDevise;
   private String testdateEcheance = "false";
   private String testDateValeur = "false";
   private ExercicesComptable exercicesComptable = new ExercicesComptable();
   private boolean var_verif_transfert = false;
   private boolean showModalPanelModif = false;
   private boolean showModalPanelAnalytique = false;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_nb_max;
   private int var_nb_carcactere;
   private UtilDate utilDate = new UtilDate();
   private boolean decoupageActivite;
   private int cpteMaxFlush = 100;
   private int modeReception;
   private String onglet;
   private SiteDao siteDao;
   private DepartementDao departementDao;
   private ServiceDao serviceDao;
   private RegionDao regionDao;
   private SecteurDao secteurDao;
   private PointDeVenteDao pointDeVenteDao;
   private DocumentEntete documentEntete = new DocumentEntete();
   private transient DataModel datamodelPlanComptable;
   private PlanComptableDao planComptableDao;
   private EcrituresAnalytiquesDao ecrituresAnalytiquesDao;
   private JournauxComptables journauxComptables = new JournauxComptables();
   private JournauxComptablesDao journauxComptablesDao;
   private RacinesDao racinesDao;
   private JournauxMoisDao journauxMoisDao;
   private double var_debit;
   private double var_credit;
   private String var_ref1;
   private String var_memoRef1;
   private Brouillard brouillard;
   private BrouillardDao brouillardDao;
   private String formatExport;
   private Element racine;
   private Document document;
   private String cheminExportOrigine;
   private String cheminExportDestination;
   private String nomRapport;
   private List lesModelsimpression = new ArrayList();
   private boolean affMail = false;
   private UtilPrint utilPrint;
   private String format;
   private int modele;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean showModalPanelPrint = false;
   private LecturePays lecturePays;
   private List listPays;
   private ObjetPays objetPays;
   private Chrono chrono;
   private Chrono chronoTransfert;
   private ChronoDao chronoDao;
   private Produits produits;
   private List listeDocumentTransfert = new ArrayList();
   private FormTransfertCtrl formTransfertCtrl = new FormTransfertCtrl();
   private List listeFamilleFournisseur;
   private FamillesProduitsAchats famillesProduitsAchats;
   private FactureEnteteAchats factureEnteteAchats;
   private FactureEnteteAchatsDao factureEnteteAchatsDao;
   private FactureLigneAchats factureLigneAchats;
   private FactureLigneAchatsDao factureLigneAchatsDao;
   private AvoirEnteteAchats avoirEnteteAchats;
   private AvoirEnteteAchatsDao avoirEnteteAchatsDao;
   private AvoirLigneAchats avoirLigneAchats;
   private AvoirLigneAchatsDao avoirLigneAchatsDao;
   private NoteDebitEnteteAchats noteDebitEnteteAchats;
   private NoteDebitEnteteAchatsDao noteDebitEnteteAchatsDao;
   private NoteDebitLigneAchats noteDebitLigneAchats;
   private NoteDebitLigneAchatsDao noteDebitLigneAchatsDao;
   private FraisEnteteAchats fraisEnteteAchats;
   private FraisEnteteAchatsDao fraisEnteteAchatsDao;
   private FraisLigneAchats fraisLigneAchats;
   private FraisLigneAchatsDao fraisLigneAchatsDao;
   private ValorisationEnteteAchats valorisationEnteteAchats;
   private ValorisationEnteteAchatsDao valorisationEnteteAchatsDao;
   private DocumentTraceAchats documentTraceAchats;
   private DocumentTraceAchatsDao documentTraceAchatsDao;
   private TaxesVentes taxesVentes;
   private TaxesVentesDao taxesVentesDao;
   private FamillesProduitsVentes famillesProduitsVentes;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private ProduitsVtesDao produitsVtesDao;
   private TicketEnteteVentes ticketEnteteVentes;
   private TicketEnteteVentesDao ticketEnteteVentesDao;
   private TicketLigneVentes ticketLigneVentes;
   private TicketLigneVentesDao ticketLigneVentesDao;
   private CommandeEnteteVentes commandeEnteteVentes;
   private CommandeEnteteVentesDao commandeEnteteVentesDao;
   private CommandeLigneVentes commandeLigneVentes;
   private CommandeLigneVentesDao commandeLigneVentesDao;
   private LivraisonEnteteVentes livraisonEnteteVentes;
   private LivraisonEnteteVentesDao livraisonEnteteVentesDao;
   private LivraisonLigneVentes livraisonLigneVentes;
   private LivraisonLigneVentesDao livraisonLigneVentesDao;
   private FactureEnteteVentes factureEnteteVentes;
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private FactureLigneVentes factureLigneVentes;
   private FactureLigneVentesDao factureLigneVentesDao;
   private FactureInterneEnteteVentes factureInterneEnteteVentes;
   private FactureInterneEnteteVentesDao factureInterneEnteteVentesDao;
   private FactureInterneLigneVentes factureInterneLigneVentes;
   private FactureInterneLigneVentesDao factureInterneLigneVentesDao;
   private AvoirEnteteVentes avoirEnteteVentes;
   private AvoirEnteteVentesDao avoirEnteteVentesDao;
   private AvoirLigneVentes avoirLigneVentes;
   private AvoirLigneVentesDao avoirLigneVentesDao;
   private NoteDebitEnteteVentes noteDebitEnteteVentes;
   private NoteDebitEnteteVentesDao noteDebitEnteteVentesDao;
   private NoteDebitLigneVentes noteDebitLigneVentes;
   private NoteDebitLigneVentesDao noteDebitLigneVentesDao;
   private DocumentTraceVentes documentTraceVentes;
   private DocumentTraceVentesDao documentTraceVentesDao;
   private BienFacture bienFacture;
   private BienFactureDao bienFactureDao;
   private OptionCaisses optionCaisses;
   private Reglements reglements;
   private ReglementsDao reglementsDao;
   private CaissesCommerciales caissesCommerciales;
   private CaissesCommercialesDao caissesCommercialesDao;
   private Tiers tiers;
   private TiersDao tiersDao;
   private Salaries salaries;
   private String journalCaisseEspece;
   private String journalCaisseCheque;
   private String journalCaisseViement;
   private String journalCaisseTraite;
   private String journalCaisseTpe;
   private String journalCaisseTransfert;
   private String journalCaisseePaiement;
   private String journalCaisseCredoc;
   private String journalCaisseFactor;
   private String journalCaisseCompense;
   private String journalCaisseTerme;
   private String journalCaisseLettreGarantie;
   private String journalCaissePrelevement;
   private String journalCaisseAlcoin;
   private CaissesOperations caissesOperations;
   private CaissesOperationsDao caissesOperationsDao;
   private ParcDao parcDao;
   private OptionPaye optionPaye;
   private BulletinSalaire bulletinSalaire;
   private BulletinSalaireDao bulletinSalaireDao;
   private BulletinLigne bulletinLigne;
   private BulletinLigneDao bulletinLigneDao;
   private BulletinMois bulletinMois;
   private BulletinMoisDao bulletinMoisDao;
   private FeuilleCalcul feuilleCalcul;
   private FeuilleCalculDao feuilleCalculDao;
   private FeuilleCalculRubrique feuilleCalculRubrique;
   private FeuilleCalculRubriqueDao feuilleCalculRubriqueDao;
   private PlanPaye planPaye;
   private PlanPayeDao planPayeDao;
   private ConsultationEnteteGene consultationEnteteGene;
   private ConsultationEnteteGeneDao consultationEnteteGeneDao;
   private ConsultationActes consultationActes;
   private ConsultationActesDao consultationActesDao;
   private PharmacieEntete pharmacieEntete;
   private PharmacieEnteteDao pharmacieEnteteDao;
   private PharmacieLigne pharmacieLigne;
   private PharmacieLigneDao pharmacieLigneDao;
   private LaboratoireEntete laboratoireEntete;
   private LaboratoireEnteteDao laboratoireEnteteDao;
   private LaboratoireLigne laboratoireLigne;
   private LaboratoireLigneDao laboratoireLigneDao;
   private HospitalisationEntete hospitalisationEntete;
   private HospitalisationEnteteDao hospitalisationEnteteDao;
   private HospitalisationActes hospitalisationActes;
   private HospitalisationActesDao hospitalisationActesDao;
   private HospitalisationLabo hospitalisationLabo;
   private HospitalisationLaboDao hospitalisationLaboDao;
   private HospitalisationMedi hospitalisationMedi;
   private HospitalisationMediDao hospitalisationMediDao;
   private HospitalisationPrest hospitalisationPrest;
   private HospitalisationPrestDao hospitalisationPrestDao;
   private HospitalisationSejour hospitalisationSejour;
   private HospitalisationSejourDao hospitalisationSejourDao;
   private FactureEnteteMedical factureEnteteMedical;
   private FactureEnteteMedicalDao factureEnteteMedicalDao;
   private FactureLigneMedical factureLigneMedical;
   private FactureLigneMedicalDao factureLigneMedicalDao;
   private int var_choix_importation;
   private boolean changerPartout;
   private int balance;
   private boolean anExiste;
   private List lePlanComptable;
   private List lesTiers;
   private boolean importSage;
   private boolean ecritureGeneSage;
   private boolean immobilisationSage;
   private boolean planGeneralSage;
   private boolean planTiersSage;
   private boolean journauxSage;
   private boolean analytiqueSage;
   private int compteurFournisseur;
   private int compteurclient;
   private int compteurPersonnel;
   private int compteurAssocie;
   private int compteurAttente;
   private int compteurInvestissement;
   private boolean variableExcel;
   private boolean affiche_activite = false;
   private boolean affiche_site = false;
   private boolean affiche_departement = false;
   private boolean affiche_service = false;
   private boolean affiche_region = false;
   private boolean affiche_secteur = false;
   private boolean affiche_pdv = false;
   private boolean affiche_sitePrdv = false;
   private boolean affiche_ligne = false;
   private boolean affiche_atelier = false;
   private boolean affiche_parc = false;
   private boolean affiche_str = false;
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private List laColonne1Items = new ArrayList();
   private List laColonne2Items = new ArrayList();
   private List laColonne3Items = new ArrayList();
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private EcrituresAnalytiqueCtrl ecrituresAnalytiqueCtrl;
   private List lesDecoupagesActivites = new ArrayList();
   private transient DataModel dataModelDecoupageActivtes = new ListDataModel();
   private double totalImputation;
   private double soldeImputation;
   private String fichierMine;
   private URL fichierUrl;
   private String nomFichier;
   private boolean afficheFichierExport = false;
   private boolean var_showBarProg = false;
   private String var_info;
   private int var_currentValue;
   private transient DataModel dataModelChampAmortissement = new ListDataModel();
   private UtilTdt utilTdt = new UtilTdt();
   private int choixRacine;
   private String selecFiscalite;

   public void InstancesDaoUtilses() {
      this.dataModelTransfertCompta = new ListDataModel();
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.brouillardDao = new BrouillardDao(this.baseLog, this.utilInitHibernate);
      this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.departementDao = new DepartementDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.regionDao = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.secteurDao = new SecteurDao(this.baseLog, this.utilInitHibernate);
      this.pointDeVenteDao = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
      this.racinesDao = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
      this.journauxMoisDao = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.parcDao = new ParcDao(this.baseLog, this.utilInitHibernate);
   }

   public void init() {
      if (this.optionComptabilite.getNbLigneMaxJr() != null && !this.optionComptabilite.getNbLigneMaxJr().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxJr());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionComptabilite.getNbcr() != null && !this.optionComptabilite.getNbcr().isEmpty()) {
         this.var_nb_carcactere = Integer.parseInt(this.optionComptabilite.getNbcr());
      } else {
         this.var_nb_carcactere = 10;
      }

      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
      } else {
         this.decoupageActivite = false;
      }

      if (this.rechercheModule(60010)) {
         this.modeReception = 1;
      } else if (this.rechercheModule(60020)) {
         this.modeReception = 2;
      } else {
         this.modeReception = 0;
      }

      this.selecFiscalite = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
         long var1 = (long)(this.exercicesComptable.getExecptDateFin().getYear() + 1900);
         if (this.structureLog.getStrdatefiscale2() != null && var1 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale2();
         }
      }

      this.formTransfertCtrl.setBaseLog(this.baseLog);
      this.formTransfertCtrl.setUsersLog(this.usersLog);
      this.formTransfertCtrl.setStructureLog(this.structureLog);
      this.formTransfertCtrl.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCtrl.InstancesDaoUtilses();
      this.formTransfertCtrl.setOptionComptabilite(this.optionComptabilite);
      this.formTransfertCtrl.setSelecFiscalite(this.selecFiscalite);
      this.formTransfertCtrl.setChoixRacine(this.choixRacine);
      this.formTransfertCtrl.setVar_nb_max(this.var_nb_max);
      this.formTransfertCtrl.setVar_nb_carcactere(this.var_nb_carcactere);
      this.formTransfertCtrl.setModeReception(this.modeReception);
      this.formTransfertCtrl.setFormRecherche(this.formRecherche);
      this.formTransfertCtrl.setExercicesComptable(this.exercicesComptable);
      this.formTransfertCtrl.setFormTransfertCompta(this);
      this.tab01();
   }

   public void initImportation() throws HibernateException, NamingException {
      this.dataModelChampAmortissement.setWrappedData(this.utilTdt.rubriqueAmortissements(this.utilInitHibernate, this.baseLog));
   }

   public void tab01() {
      this.onglet = "idTab01";
   }

   public void tab02() {
      this.onglet = "idTab02";
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
            break;
         }
      }

      return var2;
   }

   public void chargerSecteur() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.transfertErreur.getTrfRegion() != null && !this.transfertErreur.getTrfRegion().isEmpty() && this.transfertErreur.getTrfRegion().contains(":")) {
         new ArrayList();
         String[] var2 = this.transfertErreur.getTrfRegion().split(":");
         new Region();
         Region var3 = this.regionDao.rechercheRegion(var2[0], (Session)null);
         if (var3 != null) {
            List var1 = this.secteurDao.listSecteurByRegion((Region)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var4 = 0; var4 < var1.size(); ++var4) {
                  this.mesSecteursItems.add(new SelectItem(((Secteur)var1.get(var4)).getSecCode() + ":" + ((Secteur)var1.get(var4)).getSecNomFr()));
               }
            }
         }
      }

   }

   public void chargerPdv() throws HibernateException, NamingException {
      this.mesPdvItems.clear();
      if (this.transfertErreur.getTrfSecteur() != null && !this.transfertErreur.getTrfSecteur().isEmpty() && this.transfertErreur.getTrfSecteur().contains(":")) {
         new ArrayList();
         String[] var2 = this.transfertErreur.getTrfSecteur().split(":");
         new Secteur();
         Secteur var3 = this.secteurDao.rechercheSecteur(var2[0], (Session)null);
         if (var3 != null) {
            List var1 = this.pointDeVenteDao.listPdvBySecteur((Secteur)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var4 = 0; var4 < var1.size(); ++var4) {
                  this.mesPdvItems.add(new SelectItem(((PointDeVente)var1.get(var4)).getPdvCode() + ":" + ((PointDeVente)var1.get(var4)).getPdvNomFr()));
               }
            }
         }
      }

   }

   public void chargerDepartement() throws HibernateException, NamingException {
      this.mesDepartementsItems.clear();
      this.mesServicesItems.clear();
      if (this.transfertErreur.getTrfSite() != null && !this.transfertErreur.getTrfSite().isEmpty() && this.transfertErreur.getTrfSite().contains(":")) {
         new ArrayList();
         String[] var2 = this.transfertErreur.getTrfSite().split(":");
         new Site();
         Site var3 = this.siteDao.rechercheSite(var2[0], (Session)null);
         if (var3 != null) {
            List var1 = this.departementDao.listDepartementBySit((Site)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var4 = 0; var4 < var1.size(); ++var4) {
                  this.mesDepartementsItems.add(new SelectItem(((Departement)var1.get(var4)).getDepCode() + ":" + ((Departement)var1.get(var4)).getDepNomFr()));
               }
            }
         }
      }

   }

   public void chargerService() throws HibernateException, NamingException {
      this.mesServicesItems.clear();
      if (this.transfertErreur.getTrfDepartement() != null && !this.transfertErreur.getTrfDepartement().isEmpty() && this.transfertErreur.getTrfDepartement().contains(":")) {
         new ArrayList();
         String[] var2 = this.transfertErreur.getTrfDepartement().split(":");
         new Departement();
         Departement var3 = this.departementDao.rechercheDepartement(var2[0], (Session)null);
         if (var3 != null) {
            List var1 = this.serviceDao.listServiceByDep((Departement)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var4 = 0; var4 < var1.size(); ++var4) {
                  this.mesServicesItems.add(new SelectItem(((Service)var1.get(var4)).getSerCode() + ":" + ((Service)var1.get(var4)).getSerNomFr()));
               }
            }
         }
      }

   }

   public void calculTotalDebCred() throws HibernateException, NamingException {
      this.totalCred = 0.0D;
      this.totalDeb = 0.0D;
      this.ecart = 0.0D;
      this.nbligne = 0;

      int var1;
      TransfertCompta var2;
      for(var1 = 0; var1 < this.lesTransfertCompta.size(); ++var1) {
         var2 = (TransfertCompta)this.lesTransfertCompta.get(var1);
         this.totalCred += this.utilNombre.myRoundDevise(var2.getTrfCreditSaisie() + var2.getTrfCreditMvts(), this.structureLog.getStrdevise());
         this.totalDeb += this.utilNombre.myRoundDevise(var2.getTrfDebitSaisie() + var2.getTrfDebitMvts(), this.structureLog.getStrdevise());
      }

      for(var1 = 0; var1 < this.lesTransfertErreur.size(); ++var1) {
         var2 = (TransfertCompta)this.lesTransfertErreur.get(var1);
         this.totalCred += this.utilNombre.myRoundDevise(var2.getTrfCreditSaisie() + var2.getTrfCreditMvts(), this.structureLog.getStrdevise());
         this.totalDeb += this.utilNombre.myRoundDevise(var2.getTrfDebitSaisie() + var2.getTrfDebitMvts(), this.structureLog.getStrdevise());
      }

      if (this.totalCred != this.totalDeb) {
         if (this.balance == 0) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta = (TransfertCompta)this.lesTransfertCompta.get(0);
            TransfertCompta var3 = new TransfertCompta();
            var3.setTrfActivite("");
            this.transfertCompta.setTrfAnal1("");
            this.transfertCompta.setTrfAnal3("");
            var3.setTrfAgent("");
            var3.setTrfBudget("");
            var3.setTrfCategorie(this.transfertCompta.getTrfCategorie());
            var3.setTrfCle1("");
            var3.setTrfCode(this.transfertCompta.getTrfCode());
            var3.setTrfCompte(this.formTransfertCtrl.calculeCompteAttente((Session)null));
            if (this.totalCred > this.totalDeb) {
               var3.setTrfDebitSaisie(this.totalCred - this.totalDeb);
               var3.setTrfCreditSaisie(0.0D);
            } else {
               var3.setTrfDebitSaisie(0.0D);
               var3.setTrfCreditSaisie(this.totalDeb - this.totalCred);
            }

            var3.setTrfDateEcheance((Date)null);
            var3.setTrfDateSaisie(this.transfertCompta.getTrfDateSaisie());
            var3.setTrfDateValeurTheo((Date)null);
            var3.setTrfDepartement("");
            var3.setTrfDossier("");
            var3.setTrfIdOrigine(this.transfertCompta.getTrfIdOrigine());
            var3.setTrfLibelle("Régularisation journal");
            var3.setTrfModeReglement(0);
            var3.setTrfNature(0);
            var3.setTrfParc("");
            var3.setTrfPdv("");
            var3.setTrfPeriode(this.transfertCompta.getTrfPeriode());
            var3.setTrfPiece("");
            var3.setTrfProjet("");
            var3.setTrfReference1("");
            var3.setTrfReference2("");
            var3.setTrfRegion("");
            var3.setTrfRepartitionCle1("");
            var3.setTrfRepartitionCle2("");
            var3.setTrfSecteur("");
            var3.setTrfService("");
            var3.setTrfSite("");
            var3.setTrfSuite("");
            var3.setTrfTreso("");
            var3.setTrfTypeImport(this.transfertCompta.getTrfTypeImport());
            var3.setTrfTypeOrigine(this.transfertCompta.getTrfTypeOrigine());
            this.lesTransfertCompta.add(var3);
         }

         this.totalCred = 0.0D;
         this.totalDeb = 0.0D;
         this.ecart = 0.0D;
         this.nbligne = 0;

         for(var1 = 0; var1 < this.lesTransfertCompta.size(); this.nbligne = var1++) {
            var2 = (TransfertCompta)this.lesTransfertCompta.get(var1);
            this.totalCred += this.utilNombre.myRoundDevise(var2.getTrfCreditSaisie() + var2.getTrfCreditMvts(), this.structureLog.getStrdevise());
            this.totalDeb += this.utilNombre.myRoundDevise(var2.getTrfDebitSaisie() + var2.getTrfDebitMvts(), this.structureLog.getStrdevise());
         }

         for(var1 = 0; var1 < this.lesTransfertErreur.size(); ++var1) {
            var2 = (TransfertCompta)this.lesTransfertErreur.get(var1);
            this.totalCred += this.utilNombre.myRoundDevise(var2.getTrfCreditSaisie() + var2.getTrfCreditMvts(), this.structureLog.getStrdevise());
            this.totalDeb += this.utilNombre.myRoundDevise(var2.getTrfDebitSaisie() + var2.getTrfDebitMvts(), this.structureLog.getStrdevise());
         }

         if (this.totalDeb > this.totalCred) {
            this.ecart = this.totalDeb - this.totalCred;
         } else {
            this.ecart = this.totalCred - this.totalDeb;
         }
      }

   }

   public void optimisationResultat(String var1) throws HibernateException, NamingException, ParseException {
      this.lesTransfertErreur.clear();
      this.dataModelTransfertErreur.setWrappedData(this.lesTransfertErreur);
      if (this.balance == 0 && (var1 == null || var1.isEmpty())) {
         var1 = "0";
         this.calculTotalDebCred();
      } else if (this.balance == 1) {
         var1 = "0";
         this.calculTotalDebCred();
      } else if (this.balance != 2 && this.balance != 4 && this.balance != 5) {
         if (this.balance == 3) {
            this.totalCred = 0.0D;
            this.totalDeb = 0.0D;
            this.ecart = 0.0D;
            this.nbligne = 0;
            this.dataModelTransfertCompta.setWrappedData(this.lesTransfertCompta);
            this.transfertCompta = null;
            this.var_verif_transfert = true;
         }
      } else {
         this.totalCred = 0.0D;
         this.totalDeb = 0.0D;
         this.ecart = 0.0D;
         this.nbligne = 0;
         this.dataModelTransfertCompta.setWrappedData(this.lesTransfertCompta);
         this.transfertCompta = null;
         this.var_verif_transfert = true;
      }

      this.verificationLgCompte();
      if (this.balance != 2 && this.balance != 3 && this.balance != 4 && this.balance != 5 && this.lesTransfertCompta.size() != 0) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
         if (!var1.equals("0")) {
            if (var1.equals("1")) {
               this.optimisation01();
            } else if (var1.equals("2")) {
               this.optimisation02();
            } else if (var1.equals("3")) {
               this.optimisation03();
            } else if (var1.equals("4")) {
               this.optimisation04(var2);
            } else if (var1.equals("5")) {
               this.optimisation05(var2);
            } else if (var1.equals("6")) {
               this.optimisation06();
            } else if (var1.equals("7")) {
               this.optimisation07();
            } else if (var1.equals("8")) {
               this.optimisation08();
            } else if (var1.equals("9")) {
               this.optimisation09();
            }
         }

         this.verificationTransfert(var2);
         this.utilInitHibernate.closeSession();
      }

   }

   public void optimisation01() {
      ArrayList var1 = new ArrayList();
      new TransfertCompta();

      for(int var3 = 0; var3 < this.lesTransfertCompta.size(); ++var3) {
         TransfertCompta var2 = (TransfertCompta)this.lesTransfertCompta.get(var3);
         if (var2.getTrfCompte() != null && !var2.getTrfCompte().isEmpty()) {
            String var4 = var2.getTrfCompte();
            Date var5 = var2.getTrfDateSaisie();
            String var6 = var2.getTrfCode();
            String var7 = var2.getTrfLibelle() + " " + var2.getTrfSuite();
            String var8 = var2.getTrfReference1();
            String var9 = var2.getTrfReference2();
            String var10 = var2.getTrfActivite();
            double var11 = 0.0D;
            double var13 = 0.0D;
            boolean var15 = false;
            int var16 = 0;
            new TransfertCompta();

            for(int var18 = 0; var18 < var1.size(); ++var18) {
               TransfertCompta var17 = (TransfertCompta)var1.get(var18);
               String var19 = var17.getTrfLibelle() + " " + var17.getTrfSuite();
               if (var17.getTrfCompte() != null && var17.getTrfCompte().equals(var4) && var17.getTrfDateSaisie().equals(var5) && var17.getTrfCode() != null && var17.getTrfCode().equals(var6) && var19 != null && var19.equals(var7)) {
                  boolean var20 = false;
                  if (var17.getTrfReference1() != null && !var17.getTrfReference1().isEmpty()) {
                     if (var17.getTrfReference1().equals(var8)) {
                        var20 = true;
                     }
                  } else {
                     var20 = true;
                  }

                  if (var20) {
                     boolean var21 = false;
                     if (var17.getTrfReference2() != null && !var17.getTrfReference2().isEmpty()) {
                        if (var17.getTrfReference2().equals(var9)) {
                           var21 = true;
                        }
                     } else {
                        var21 = true;
                     }

                     if (var21) {
                        boolean var22 = false;
                        if (var17.getTrfActivite() != null && !var17.getTrfActivite().isEmpty()) {
                           if (var17.getTrfActivite().equals(var10)) {
                              var22 = true;
                           }
                        } else {
                           var22 = true;
                        }

                        if (var22) {
                           var15 = true;
                           var16 = var18;
                           var11 = var17.getTrfDebitSaisie();
                           var13 = var17.getTrfCreditSaisie();
                        }
                     }
                  }
               }
            }

            if (!var15) {
               var1.add(var2);
            } else {
               if (var2.getTrfDebitSaisie() + var11 != var2.getTrfCreditSaisie() + var13) {
                  var1.remove(var16);
                  var2.setTrfDebitSaisie(var11 + var2.getTrfDebitSaisie());
                  var2.setTrfCreditSaisie(var13 + var2.getTrfCreditSaisie());
               }

               var1.add(var2);
            }
         } else {
            var1.add(var2);
         }
      }

      this.lesTransfertCompta = var1;
   }

   public void optimisation02() {
      ArrayList var1 = new ArrayList();
      new TransfertCompta();

      for(int var3 = 0; var3 < this.lesTransfertCompta.size(); ++var3) {
         TransfertCompta var2 = (TransfertCompta)this.lesTransfertCompta.get(var3);
         if (var2.getTrfCompte() != null && !var2.getTrfCompte().isEmpty()) {
            String var4 = var2.getTrfCompte();
            String var5 = var2.getTrfCode();
            String var6 = var2.getTrfDepartement();
            double var7 = 0.0D;
            double var9 = 0.0D;
            boolean var11 = false;
            int var12 = 0;
            new TransfertCompta();

            for(int var14 = 0; var14 < var1.size(); ++var14) {
               TransfertCompta var13 = (TransfertCompta)var1.get(var14);
               if (var13.getTrfCompte() != null && var13.getTrfCompte().equals(var4) && var13.getTrfCode() != null && var13.getTrfCode().equals(var5)) {
                  boolean var15 = false;
                  if (var6 != null && !var6.isEmpty()) {
                     if (var13.getTrfDepartement() != null && !var13.getTrfDepartement().isEmpty() && var13.getTrfDepartement().equals(var6)) {
                        var15 = true;
                     }
                  } else if (var13.getTrfDepartement() == null || var13.getTrfDepartement().isEmpty()) {
                     var15 = true;
                  }

                  if (var15) {
                     var11 = true;
                     var12 = var14;
                     var7 = var13.getTrfDebitSaisie();
                     var9 = var13.getTrfCreditSaisie();
                  }
               }
            }

            if (!var11) {
               var1.add(var2);
            } else {
               if (var2.getTrfDebitSaisie() + var7 != var2.getTrfCreditSaisie() + var9) {
                  var1.remove(var12);
                  var2.setTrfDebitSaisie(var7 + var2.getTrfDebitSaisie());
                  var2.setTrfCreditSaisie(var9 + var2.getTrfCreditSaisie());
                  if (var2.getTrfCompte().startsWith("5")) {
                     var2.setTrfLibelle("Centralisation mensuelle");
                  }
               }

               var1.add(var2);
            }
         } else {
            var1.add(var2);
         }
      }

      this.lesTransfertCompta = var1;
   }

   public void optimisation03() {
      ArrayList var1 = new ArrayList();
      new TransfertCompta();

      for(int var3 = 0; var3 < this.lesTransfertCompta.size(); ++var3) {
         TransfertCompta var2 = (TransfertCompta)this.lesTransfertCompta.get(var3);
         if (var2.getTrfCompte() != null && !var2.getTrfCompte().isEmpty()) {
            String var4 = var2.getTrfCompte();
            String var5 = var2.getTrfReference1();
            double var6 = 0.0D;
            double var8 = 0.0D;
            boolean var10 = false;
            int var11 = 0;
            new TransfertCompta();

            for(int var13 = 0; var13 < var1.size(); ++var13) {
               TransfertCompta var12 = (TransfertCompta)var1.get(var13);
               if (var12.getTrfCompte() != null && var12.getTrfCompte().equals(var4)) {
                  boolean var14 = false;
                  if (var12.getTrfReference1() != null && !var12.getTrfReference1().isEmpty()) {
                     if (var12.getTrfReference1().equals(var5)) {
                        var14 = true;
                     }
                  } else {
                     var14 = true;
                  }

                  if (var14) {
                     var10 = true;
                     var11 = var13;
                     var6 = var12.getTrfDebitSaisie();
                     var8 = var12.getTrfCreditSaisie();
                  }
               }
            }

            if (!var10) {
               var1.add(var2);
            } else {
               if (var2.getTrfDebitSaisie() + var6 != var2.getTrfCreditSaisie() + var8) {
                  var1.remove(var11);
                  var2.setTrfDebitSaisie(var6 + var2.getTrfDebitSaisie());
                  var2.setTrfCreditSaisie(var8 + var2.getTrfCreditSaisie());
                  var2.setTrfReference2("");
                  if (var2.getTrfCompte().startsWith("5")) {
                     var2.setTrfLibelle("Centralisation mensuelle");
                  }
               }

               var1.add(var2);
            }
         } else {
            var1.add(var2);
         }
      }

      this.lesTransfertCompta = var1;
   }

   public void optimisation04(Session var1) throws HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      new TransfertCompta();

      for(int var4 = 0; var4 < this.lesTransfertCompta.size(); ++var4) {
         TransfertCompta var3 = (TransfertCompta)this.lesTransfertCompta.get(var4);
         if (var3.getTrfCompte() != null && !var3.getTrfCompte().isEmpty()) {
            String var5 = var3.getTrfCompte();
            String var6 = var3.getTrfDateSaisie().getMonth() + 1 + ":" + (var3.getTrfDateSaisie().getYear() + 1900);
            double var7 = 0.0D;
            double var9 = 0.0D;
            boolean var11 = false;
            int var12 = 0;
            new TransfertCompta();

            for(int var14 = 0; var14 < var2.size(); ++var14) {
               TransfertCompta var13 = (TransfertCompta)var2.get(var14);
               if (var13.getTrfCompte() != null && var13.getTrfCompte().equals(var5)) {
                  boolean var15 = false;
                  String var16 = var13.getTrfDateSaisie().getMonth() + 1 + ":" + (var13.getTrfDateSaisie().getYear() + 1900);
                  if (var16.equals(var6)) {
                     var15 = true;
                  }

                  if (var15) {
                     var11 = true;
                     var12 = var14;
                     var7 = var13.getTrfDebitSaisie();
                     var9 = var13.getTrfCreditSaisie();
                  }
               }
            }

            if (!var11) {
               var3.setTrfLibelle(this.formTransfertCtrl.calculeLibelleCompte(var3.getTrfCompte(), var1));
               var3.setTrfReference1(var6);
               var2.add(var3);
            } else {
               if (var3.getTrfDebitSaisie() + var7 != var3.getTrfCreditSaisie() + var9) {
                  var2.remove(var12);
                  var3.setTrfDebitSaisie(var7 + var3.getTrfDebitSaisie());
                  var3.setTrfCreditSaisie(var9 + var3.getTrfCreditSaisie());
                  var3.setTrfLibelle(this.formTransfertCtrl.calculeLibelleCompte(var3.getTrfCompte(), var1));
                  var3.setTrfReference1(var6);
                  var3.setTrfReference2("");
                  if (var3.getTrfCompte().startsWith("5")) {
                     var3.setTrfLibelle("Centralisation mensuelle");
                  }
               }

               var2.add(var3);
            }
         } else {
            var2.add(var3);
         }
      }

      this.lesTransfertCompta = var2;
   }

   public void optimisation05(Session var1) throws HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      new TransfertCompta();

      for(int var4 = 0; var4 < this.lesTransfertCompta.size(); ++var4) {
         TransfertCompta var3 = (TransfertCompta)this.lesTransfertCompta.get(var4);
         if (var3.getTrfCompte() != null && !var3.getTrfCompte().isEmpty()) {
            String var5 = var3.getTrfCompte();
            String var6 = "" + (var3.getTrfDateSaisie().getYear() + 1900);
            double var7 = 0.0D;
            double var9 = 0.0D;
            boolean var11 = false;
            int var12 = 0;
            new TransfertCompta();

            for(int var14 = 0; var14 < var2.size(); ++var14) {
               TransfertCompta var13 = (TransfertCompta)var2.get(var14);
               if (var13.getTrfCompte() != null && var13.getTrfCompte().equals(var5)) {
                  boolean var15 = false;
                  String var16 = "" + (var13.getTrfDateSaisie().getYear() + 1900);
                  if (var16.equals(var6)) {
                     var15 = true;
                  }

                  if (var15) {
                     var11 = true;
                     var12 = var14;
                     var7 = var13.getTrfDebitSaisie();
                     var9 = var13.getTrfCreditSaisie();
                  }
               }
            }

            if (!var11) {
               var3.setTrfLibelle(this.formTransfertCtrl.calculeLibelleCompte(var3.getTrfCompte(), var1));
               var3.setTrfReference1(var6);
               var2.add(var3);
            } else {
               if (var3.getTrfDebitSaisie() + var7 != var3.getTrfCreditSaisie() + var9) {
                  var2.remove(var12);
                  var3.setTrfDebitSaisie(var7 + var3.getTrfDebitSaisie());
                  var3.setTrfCreditSaisie(var9 + var3.getTrfCreditSaisie());
                  var3.setTrfLibelle(this.formTransfertCtrl.calculeLibelleCompte(var3.getTrfCompte(), var1));
                  var3.setTrfReference1(var6);
                  var3.setTrfReference2("");
                  if (var3.getTrfCompte().startsWith("5")) {
                     var3.setTrfLibelle("Centralisation mensuelle");
                  }
               }

               var2.add(var3);
            }
         } else {
            var2.add(var3);
         }
      }

      this.lesTransfertCompta = var2;
   }

   public void optimisation06() throws ParseException {
      ArrayList var1 = new ArrayList();
      new TransfertCompta();

      for(int var3 = 0; var3 < this.lesTransfertCompta.size(); ++var3) {
         TransfertCompta var2 = (TransfertCompta)this.lesTransfertCompta.get(var3);
         String var4;
         String var6;
         if (var2.getTrfNature() != 71 && var2.getTrfNature() != 73 && var2.getTrfNature() != 74 && var2.getTrfNature() != 76) {
            if (var2.getTrfNature() == 78) {
               if (var2.getTrfCompte() != null && !var2.getTrfCompte().isEmpty()) {
                  var4 = var2.getTrfCompte();
                  String var16 = var2.getTrfLibelle();
                  var6 = var2.getTrfCode();
                  String var17 = var2.getTrfReference1();
                  double var8 = 0.0D;
                  double var10 = 0.0D;
                  boolean var18 = false;
                  int var19 = 0;
                  new TransfertCompta();

                  for(int var15 = 0; var15 < var1.size(); ++var15) {
                     TransfertCompta var20 = (TransfertCompta)var1.get(var15);
                     if (var20.getTrfNature() == 78 && var20.getTrfReference1() != null && var20.getTrfReference1().equals(var17) && var20.getTrfLibelle() != null && var20.getTrfLibelle().equals(var16) && var20.getTrfCompte() != null && var20.getTrfCompte().equals(var4) && var20.getTrfCode() != null && var20.getTrfCode().equals(var6)) {
                        var19 = var15;
                        var18 = true;
                        var8 = var20.getTrfDebitSaisie();
                        var10 = var20.getTrfCreditSaisie();
                     }
                  }

                  if (!var18) {
                     var1.add(var2);
                  } else {
                     if (var2.getTrfDebitSaisie() + var8 != var2.getTrfCreditSaisie() + var10) {
                        var1.remove(var19);
                        var2.setTrfDebitSaisie(var8 + var2.getTrfDebitSaisie());
                        var2.setTrfCreditSaisie(var10 + var2.getTrfCreditSaisie());
                     }

                     var1.add(var2);
                  }
               } else {
                  var1.add(var2);
               }
            }
         } else if (var2.getTrfCompte() != null && !var2.getTrfCompte().isEmpty()) {
            var4 = var2.getTrfCompte();
            Date var5 = this.utilDate.dateToSQLLight(var2.getTrfDateSaisie());
            var6 = var2.getTrfCode();
            double var7 = 0.0D;
            double var9 = 0.0D;
            boolean var11 = false;
            int var12 = 0;
            new TransfertCompta();

            for(int var14 = 0; var14 < var1.size(); ++var14) {
               TransfertCompta var13 = (TransfertCompta)var1.get(var14);
               if (var13.getTrfNature() != 78 && var13.getTrfCompte() != null && var13.getTrfCompte().equals(var4) && this.utilDate.dateToSQLLight(var13.getTrfDateSaisie()).equals(var5) && var13.getTrfCode() != null && var13.getTrfCode().equals(var6)) {
                  var12 = var14;
                  var11 = true;
                  var7 = var13.getTrfDebitSaisie();
                  var9 = var13.getTrfCreditSaisie();
               }
            }

            if (!var11) {
               var2.setTrfReference1("");
               var2.setTrfReference2("");
               var1.add(var2);
            } else {
               if (var2.getTrfDebitSaisie() + var7 != var2.getTrfCreditSaisie() + var9) {
                  var1.remove(var12);
                  var2.setTrfReference1("");
                  var2.setTrfReference2("");
                  var2.setTrfDebitSaisie(var7 + var2.getTrfDebitSaisie());
                  var2.setTrfCreditSaisie(var9 + var2.getTrfCreditSaisie());
               }

               var1.add(var2);
            }
         } else {
            var1.add(var2);
         }
      }

      this.lesTransfertCompta = var1;
   }

   public void optimisation07() throws ParseException {
      ArrayList var1 = new ArrayList();
      new TransfertCompta();

      for(int var3 = 0; var3 < this.lesTransfertCompta.size(); ++var3) {
         TransfertCompta var2 = (TransfertCompta)this.lesTransfertCompta.get(var3);
         if (var2.getTrfNature() != 71 && var2.getTrfNature() != 73 && var2.getTrfNature() != 74 && var2.getTrfNature() != 76) {
            var1.add(var2);
         } else if (var2.getTrfCompte() != null && !var2.getTrfCompte().isEmpty()) {
            String var4 = var2.getTrfCompte();
            Date var5 = this.utilDate.dateToSQLLight(var2.getTrfDateSaisie());
            String var6 = var2.getTrfCode();
            double var7 = 0.0D;
            double var9 = 0.0D;
            boolean var11 = false;
            int var12 = 0;
            new TransfertCompta();

            for(int var14 = 0; var14 < var1.size(); ++var14) {
               TransfertCompta var13 = (TransfertCompta)var1.get(var14);
               if (var13.getTrfCompte() != null && var13.getTrfCompte().equals(var4) && this.utilDate.dateToSQLLight(var13.getTrfDateSaisie()).equals(var5) && var13.getTrfCode() != null && var13.getTrfCode().equals(var6)) {
                  var12 = var14;
                  var11 = true;
                  var7 = var13.getTrfDebitSaisie();
                  var9 = var13.getTrfCreditSaisie();
               }
            }

            if (!var11) {
               var2.setTrfReference1("");
               var2.setTrfReference2("");
               var1.add(var2);
            } else {
               if (var2.getTrfDebitSaisie() + var7 != var2.getTrfCreditSaisie() + var9) {
                  var1.remove(var12);
                  var2.setTrfReference1("");
                  var2.setTrfReference2("");
                  var2.setTrfDebitSaisie(var7 + var2.getTrfDebitSaisie());
                  var2.setTrfCreditSaisie(var9 + var2.getTrfCreditSaisie());
               }

               var1.add(var2);
            }
         } else {
            var1.add(var2);
         }
      }

      this.lesTransfertCompta = var1;
   }

   public void optimisation08() {
      ArrayList var1 = new ArrayList();
      new TransfertCompta();

      int var3;
      for(var3 = 0; var3 < this.lesTransfertCompta.size(); ++var3) {
         TransfertCompta var2 = (TransfertCompta)this.lesTransfertCompta.get(var3);
         if (var2.getTrfCompte() != null && !var2.getTrfCompte().isEmpty()) {
            String var4 = var2.getTrfCompte();
            String var5 = var2.getTrfCode();
            String var6 = var2.getTrfActivite();
            String var7 = var2.getTrfLibelle() + " " + var2.getTrfSuite();
            double var8 = 0.0D;
            double var10 = 0.0D;
            boolean var12 = false;
            int var13 = 0;
            new TransfertCompta();

            for(int var15 = 0; var15 < var1.size(); ++var15) {
               TransfertCompta var14 = (TransfertCompta)var1.get(var15);
               if (var14.getTrfCompte() != null && !var14.getTrfCompte().isEmpty() && var14.getTrfCode() != null && !var14.getTrfCode().isEmpty() && var14.getTrfCode().equals(var5)) {
                  boolean var16 = false;
                  if (var14.getTrfCompte().startsWith("421")) {
                     String var17 = var14.getTrfLibelle() + " " + var14.getTrfSuite();
                     if (var17.equals(var7)) {
                        var16 = true;
                     }
                  } else if (var14.getTrfCompte().equals(var4)) {
                     if (var6 != null && !var6.isEmpty()) {
                        if (var14.getTrfActivite() != null && !var14.getTrfActivite().isEmpty() && var14.getTrfActivite().equals(var6)) {
                           var16 = true;
                        }
                     } else if (var14.getTrfActivite() == null || var14.getTrfActivite().isEmpty()) {
                        var16 = true;
                     }

                     if (var16) {
                        var12 = true;
                        var13 = var15;
                        var8 = var14.getTrfDebitSaisie();
                        var10 = var14.getTrfCreditSaisie();
                     }
                  }
               }
            }

            if (!var12) {
               var1.add(var2);
            } else {
               if (var2.getTrfDebitSaisie() + var8 != var2.getTrfCreditSaisie() + var10) {
                  var1.remove(var13);
                  var2.setTrfDebitSaisie(var8 + var2.getTrfDebitSaisie());
                  var2.setTrfCreditSaisie(var10 + var2.getTrfCreditSaisie());
                  if (var2.getTrfCompte().startsWith("5")) {
                     var2.setTrfLibelle("Centralisation mensuelle");
                  }
               } else {
                  var2.setTrfDebitSaisie(var8 + var2.getTrfDebitSaisie());
                  var2.setTrfCreditSaisie(var10 + var2.getTrfCreditSaisie());
               }

               var1.add(var2);
            }
         } else {
            var1.add(var2);
         }
      }

      this.lesTransfertCompta.clear();

      for(var3 = 0; var3 < var1.size(); ++var3) {
         this.lesTransfertCompta.add(var1.get(var3));
      }

   }

   public void optimisation09() {
      ArrayList var1 = new ArrayList();
      new TransfertCompta();

      int var3;
      for(var3 = 0; var3 < this.lesTransfertCompta.size(); ++var3) {
         TransfertCompta var2 = (TransfertCompta)this.lesTransfertCompta.get(var3);
         if (var2.getTrfCompte() != null && !var2.getTrfCompte().isEmpty()) {
            String var4 = var2.getTrfCompte();
            String var5 = var2.getTrfCode();
            String var6 = var2.getTrfActivite();
            String var7 = var2.getTrfLibelle() + " " + var2.getTrfSuite();
            double var8 = 0.0D;
            double var10 = 0.0D;
            boolean var12 = false;
            int var13 = 0;
            new TransfertCompta();

            for(int var15 = 0; var15 < var1.size(); ++var15) {
               TransfertCompta var14 = (TransfertCompta)var1.get(var15);
               if (var14.getTrfCompte() != null && !var14.getTrfCompte().isEmpty() && var14.getTrfCode() != null && !var14.getTrfCode().isEmpty() && var14.getTrfCode().equals(var5)) {
                  boolean var16 = false;
                  if (var14.getTrfCompte().startsWith("421")) {
                     String var17 = var14.getTrfLibelle() + " " + var14.getTrfSuite();
                     if (var17.equals(var7)) {
                        var16 = true;
                     }
                  } else if (!var14.getTrfCompte().startsWith("4478") && var14.getTrfCompte().equals(var4)) {
                     if (var6 != null && !var6.isEmpty()) {
                        if (var14.getTrfActivite() != null && !var14.getTrfActivite().isEmpty() && var14.getTrfActivite().equals(var6)) {
                           var16 = true;
                        }
                     } else if (var14.getTrfActivite() == null || var14.getTrfActivite().isEmpty()) {
                        var16 = true;
                     }

                     if (var16) {
                        var12 = true;
                        var13 = var15;
                        var8 = var14.getTrfDebitSaisie();
                        var10 = var14.getTrfCreditSaisie();
                     }
                  }
               }
            }

            if (!var12) {
               var1.add(var2);
            } else {
               if (var2.getTrfDebitSaisie() + var8 != var2.getTrfCreditSaisie() + var10) {
                  var1.remove(var13);
                  var2.setTrfDebitSaisie(var8 + var2.getTrfDebitSaisie());
                  var2.setTrfCreditSaisie(var10 + var2.getTrfCreditSaisie());
                  if (var2.getTrfCompte().startsWith("5")) {
                     var2.setTrfLibelle("Centralisation mensuelle");
                  }
               } else {
                  var2.setTrfDebitSaisie(var8 + var2.getTrfDebitSaisie());
                  var2.setTrfCreditSaisie(var10 + var2.getTrfCreditSaisie());
               }

               var1.add(var2);
            }
         } else {
            var1.add(var2);
         }
      }

      this.lesTransfertCompta.clear();

      for(var3 = 0; var3 < var1.size(); ++var3) {
         this.lesTransfertCompta.add(var1.get(var3));
      }

   }

   public void verificationLgCompte() {
      if (this.lesTransfertCompta.size() != 0) {
         boolean var1 = true;
         if (this.optionPaye != null && this.optionPaye.getExportOd().equals("1") && this.optionPaye.getNbcrExport().equals("0")) {
            var1 = false;
         }

         if (var1) {
            for(int var2 = 0; var2 < this.lesTransfertCompta.size(); ++var2) {
               this.transfertCompta = (TransfertCompta)this.lesTransfertCompta.get(var2);
               if (this.transfertCompta.getTrfCompte() != null && !this.transfertCompta.getTrfCompte().isEmpty() && !this.transfertCompta.getTrfCompte().contains(":")) {
                  if (this.transfertCompta.getTrfCompte().length() < this.var_nb_carcactere) {
                     int var3 = this.var_nb_carcactere - this.transfertCompta.getTrfCompte().length();
                     String var4 = this.transfertCompta.getTrfCompte();
                     if (var3 == 1) {
                        var4 = var4 + "0";
                     } else if (var3 == 2) {
                        var4 = var4 + "00";
                     } else if (var3 == 3) {
                        var4 = var4 + "000";
                     } else if (var3 == 4) {
                        var4 = var4 + "0000";
                     } else if (var3 == 5) {
                        var4 = var4 + "00000";
                     } else if (var3 == 6) {
                        var4 = var4 + "000000";
                     } else if (var3 == 7) {
                        var4 = var4 + "0000000";
                     } else if (var3 == 8) {
                        var4 = var4 + "00000000";
                     } else if (var3 == 9) {
                        var4 = var4 + "000000000";
                     } else if (var3 == 10) {
                        var4 = var4 + "0000000000";
                     } else if (var3 == 11) {
                        var4 = var4 + "00000000000";
                     } else if (var3 == 12) {
                        var4 = var4 + "000000000000";
                     } else if (var3 == 13) {
                        var4 = var4 + "0000000000000";
                     } else if (var3 == 14) {
                        var4 = var4 + "00000000000000";
                     } else if (var3 == 15) {
                        var4 = var4 + "000000000000000";
                     } else if (var3 == 16) {
                        var4 = var4 + "0000000000000000";
                     } else if (var3 == 17) {
                        var4 = var4 + "00000000000000000";
                     } else if (var3 == 18) {
                        var4 = var4 + "000000000000000000";
                     } else if (var3 == 19) {
                        var4 = var4 + "0000000000000000000";
                     }

                     this.transfertCompta.setTrfCompte(var4);
                  } else if (this.transfertCompta.getTrfCompte().length() > this.var_nb_carcactere) {
                     String var5 = this.transfertCompta.getTrfCompte().substring(0, this.var_nb_carcactere);
                     this.transfertCompta.setTrfCompte(var5);
                  }
               }
            }
         }
      }

   }

   public void selectionLigne() {
      if (this.dataModelTransfertCompta.isRowAvailable()) {
         this.transfertCompta = (TransfertCompta)this.dataModelTransfertCompta.getRowData();
      }

   }

   public void selectionLigneErreur() {
      if (this.dataModelTransfertErreur.isRowAvailable()) {
         this.transfertErreur = (TransfertCompta)this.dataModelTransfertErreur.getRowData();
      }

   }

   public void verificationTransfert(Session var1) throws HibernateException, NamingException {
      this.dataModelTransfertCompta.setWrappedData(this.lesTransfertCompta);
      this.dataModelTransfertErreur.setWrappedData(this.lesTransfertErreur);
      this.var_verif_transfert = true;
      this.totalCred = 0.0D;
      this.totalDeb = 0.0D;
      this.ecart = 0.0D;
      this.nbligne = 0;
      if (this.lesTransfertCompta.size() != 0) {
         UtilTrie var2 = new UtilTrie();
         this.lesTransfertCompta = var2.triListeTransfertComptaRef1(this.lesTransfertCompta);

         for(int var3 = 0; var3 < this.lesTransfertCompta.size(); ++var3) {
            this.transfertCompta = (TransfertCompta)this.lesTransfertCompta.get(var3);
            this.totalDeb += this.transfertCompta.getTrfDebitSaisie();
            this.totalCred += this.transfertCompta.getTrfCreditSaisie();
            this.nbligne = var3;
            if (this.transfertCompta.getTrfCompte() == null || this.transfertCompta.getTrfCompte().isEmpty()) {
               this.transfertCompta.setTrfErreur("Erreur COMPTE");
               this.transfertErreur = this.transfertCompta;
               this.lesTransfertErreur.add(this.transfertErreur);
               this.lesTransfertCompta.remove(var3);
               --var3;
               this.var_verif_transfert = false;
            }
         }

         this.ecart = this.totalDeb - this.totalCred;
         if (this.optionComptabilite.getAnalytique().equals("true") && this.optionComptabilite.getAnalytiqueTransfert().equals("1")) {
            boolean var5 = false;
            if (var1 == null) {
               var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
               var5 = true;
            }

            int var4 = 0;

            while(true) {
               if (var4 >= this.lesTransfertCompta.size()) {
                  if (var5) {
                     this.utilInitHibernate.closeSession();
                  }
                  break;
               }

               this.transfertCompta = (TransfertCompta)this.lesTransfertCompta.get(var4);
               if (this.transfertCompta.getTrfCompte() != null && !this.transfertCompta.getTrfCompte().isEmpty() && this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var1) && (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty())) {
                  this.transfertCompta.setTrfErreur("Erreur ACTIVITES");
                  this.transfertErreur = this.transfertCompta;
                  this.lesTransfertErreur.add(this.transfertErreur);
                  this.lesTransfertCompta.remove(this.transfertCompta);
                  --var4;
                  this.var_verif_transfert = false;
               }

               ++var4;
            }
         }

         if (this.lesTransfertErreur.size() != 0) {
            this.var_verif_transfert = false;
            if (this.formRecherche == null) {
               this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
            }

            this.formRecherche.setMessageTexte("Le transfert est impossible car soit il manque des comptes soit il manque des imputations analytiques obligatoires. Les erreurs à corriger se trouvent dans l'onglet Eléments en erreur.");
            this.formRecherche.setShowModalPanelMessage(true);
         } else {
            this.var_verif_transfert = true;
         }
      }

      this.dataModelTransfertCompta.setWrappedData(this.lesTransfertCompta);
      this.dataModelTransfertErreur.setWrappedData(this.lesTransfertErreur);
      this.transfertCompta = null;
      this.transfertErreur = null;
   }

   public void ouvrirmodifligne() {
      this.changerPartout = false;
      this.showModalPanelModif = true;
   }

   public void annuleModifLigne() {
      this.showModalPanelModif = false;
   }

   public void miseajourLigne() throws HibernateException, NamingException {
      if (!this.changerPartout) {
         this.transfertErreur.setTrfErreur("");
         this.transfertCompta = this.transfertErreur;
         this.lesTransfertCompta.add(this.transfertCompta);
         this.lesTransfertErreur.remove(this.transfertErreur);
         this.verificationTransfert((Session)null);
      } else {
         String var1 = this.transfertErreur.getTrfCompte();

         for(int var2 = 0; var2 < this.lesTransfertErreur.size(); ++var2) {
            this.transfertErreur = (TransfertCompta)this.lesTransfertErreur.get(var2);
            if (this.transfertErreur.getTrfCompte() == null || this.transfertErreur.getTrfCompte().isEmpty() || this.transfertErreur.getTrfCompte() != null && !this.transfertErreur.getTrfCompte().isEmpty() && this.transfertErreur.getTrfCompte().equals(var1)) {
               this.transfertErreur.setTrfCompte(var1);
               this.transfertErreur.setTrfErreur("");
               this.transfertCompta = this.transfertErreur;
               this.lesTransfertCompta.add(this.transfertCompta);
               this.lesTransfertErreur.remove(var2);
               --var2;
            }
         }

         this.verificationTransfert((Session)null);
      }

      this.transfertErreur = null;
      this.transfertCompta = null;
      this.showModalPanelModif = false;
   }

   public void ouvrirmodifAnal() throws HibernateException, NamingException {
      this.formTransfertCtrl.calculerLesDecoupagesActivites();
      this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite) {
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.showModalPanelAnalytique = true;
   }

   public void annuleModifAnal() {
      this.showModalPanelAnalytique = false;
   }

   public void miseajourAnal() throws HibernateException, NamingException {
      if (this.transfertErreur.getTrfSite() != null && this.transfertErreur.getTrfSite().equals("0")) {
         this.transfertErreur.setTrfSite("");
      }

      if (this.transfertErreur.getTrfDepartement() != null && this.transfertErreur.getTrfDepartement().equals("0")) {
         this.transfertErreur.setTrfDepartement("");
      }

      if (this.transfertErreur.getTrfService() != null && this.transfertErreur.getTrfService().equals("0")) {
         this.transfertErreur.setTrfService("");
      }

      String[] var1;
      if (this.transfertErreur.getTrfRegion() != null && !this.transfertErreur.getTrfRegion().isEmpty() && this.transfertErreur.getTrfRegion().contains(":")) {
         var1 = this.transfertErreur.getTrfRegion().split(":");
         this.transfertErreur.setTrfRegion(var1[0]);
      } else {
         this.transfertErreur.setTrfRegion("");
      }

      if (this.transfertErreur.getTrfSecteur() != null && !this.transfertErreur.getTrfSecteur().isEmpty() && this.transfertErreur.getTrfSecteur().contains(":")) {
         var1 = this.transfertErreur.getTrfSecteur().split(":");
         this.transfertErreur.setTrfSecteur(var1[0]);
      } else {
         this.transfertErreur.setTrfSecteur("");
      }

      if (this.transfertErreur.getTrfPdv() != null && !this.transfertErreur.getTrfPdv().isEmpty() && this.transfertErreur.getTrfPdv().contains(":")) {
         var1 = this.transfertErreur.getTrfPdv().split(":");
         this.transfertErreur.setTrfPdv(var1[0]);
      } else {
         this.transfertErreur.setTrfPdv("");
      }

      if (this.transfertErreur.getTrfRepartitionCle1() != null && !this.transfertErreur.getTrfRepartitionCle1().isEmpty() && this.transfertErreur.getTrfRepartitionCle1().contains(":")) {
         var1 = this.transfertErreur.getTrfRepartitionCle1().split(":");
         this.transfertErreur.setTrfRepartitionCle1(var1[0]);
      } else {
         this.transfertErreur.setTrfRepartitionCle1("");
      }

      if (this.transfertErreur.getTrfRepartitionCle2() != null && !this.transfertErreur.getTrfRepartitionCle2().isEmpty() && this.transfertErreur.getTrfRepartitionCle2().contains(":")) {
         var1 = this.transfertErreur.getTrfRepartitionCle2().split(":");
         this.transfertErreur.setTrfRepartitionCle2(var1[0]);
      } else {
         this.transfertErreur.setTrfRepartitionCle2("");
      }

      if (this.transfertErreur.getTrfDossier() != null && !this.transfertErreur.getTrfDossier().isEmpty() && this.transfertErreur.getTrfDossier().contains(":")) {
         var1 = this.transfertErreur.getTrfDossier().split(":");
         this.transfertErreur.setTrfDossier(var1[0]);
      } else {
         this.transfertErreur.setTrfDossier("");
      }

      if (this.transfertErreur.getTrfParc() != null && this.transfertErreur.getTrfParc().equals("0")) {
         this.transfertErreur.setTrfParc("");
      }

      if (this.transfertErreur.getTrfBudget() != null && this.transfertErreur.getTrfBudget().equals("100")) {
         this.transfertErreur.setTrfBudget("");
      }

      if (this.decoupageActivite) {
         String var4 = "";
         boolean var2 = true;
         if (this.lesDecoupagesActivites.size() != 0) {
            for(int var3 = 0; var3 < this.lesDecoupagesActivites.size(); ++var3) {
               this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var3);
               if (var2) {
                  var4 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  var2 = false;
               } else {
                  var4 = var4 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               }
            }
         }

         this.transfertErreur.setTrfActivite(var4);
      } else if (this.transfertErreur.getTrfActivite() != null && this.transfertErreur.getTrfActivite().contains("0")) {
         this.transfertErreur.setTrfActivite("");
      }

      this.transfertCompta = this.transfertErreur;
      this.lesTransfertCompta.add(this.transfertCompta);
      this.lesTransfertErreur.remove(this.transfertErreur);
      this.verificationTransfert((Session)null);
      this.transfertErreur = null;
      this.transfertCompta = null;
      this.showModalPanelAnalytique = false;
   }

   public void recherchePlanComptable() throws JDOMException, IOException, HibernateException, NamingException {
      this.formTransfertCtrl.recherchePlanComptable();
   }

   public void recherchePlanComptableErreur() throws JDOMException, IOException, HibernateException, NamingException {
      this.formTransfertCtrl.recherchePlanComptableErreur();
   }

   public void transfertImmobilisation(List var1) throws HibernateException, NamingException, ParseException {
      this.init();
      this.lesTransfertCompta = var1;
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.optimisationResultat(this.optionComptabilite.getTrf_cpteImmo());
   }

   public void transfertLoyer(List var1) throws HibernateException, NamingException, ParseException {
      this.init();
      this.lesTransfertCompta = var1;
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.optimisationResultat(this.optionComptabilite.getTrf_cpte());
   }

   public void transfertAchat(List var1) throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      this.init();
      this.optionAchats = new OptionAchats();
      LireLesoptionsAchats var2 = new LireLesoptionsAchats();
      var2.setStrId(this.structureLog.getStrid());
      this.optionAchats = var2.lancer();
      this.listeDocumentTransfert = var1;
      this.objetPays = new ObjetPays();
      this.lecturePays = new LecturePays();
      this.listPays = this.lecturePays.getMespays();
      this.listeFamilleFournisseur = new ArrayList();
      LectureFamillesFournisseurs var3 = new LectureFamillesFournisseurs();
      var3.setStrId(this.structureLog.getStrid());
      var3.setStructureLog(this.structureLog);
      var3.chargerMesFamillesFournisseurItems();
      this.listeFamilleFournisseur = var3.getMesFamillesFournisseurs();
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.produits = new Produits();
      this.famillesProduitsAchats = new FamillesProduitsAchats();
      this.documentTraceAchats = new DocumentTraceAchats();
      this.documentTraceAchatsDao = new DocumentTraceAchatsDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteAchats = new FactureEnteteAchats();
      this.factureEnteteAchatsDao = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneAchats = new FactureLigneAchats();
      this.factureLigneAchatsDao = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteAchats = new AvoirEnteteAchats();
      this.avoirEnteteAchatsDao = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.avoirLigneAchats = new AvoirLigneAchats();
      this.avoirLigneAchatsDao = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteAchats = new NoteDebitEnteteAchats();
      this.noteDebitEnteteAchatsDao = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitLigneAchats = new NoteDebitLigneAchats();
      this.noteDebitLigneAchatsDao = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.fraisEnteteAchats = new FraisEnteteAchats();
      this.fraisEnteteAchatsDao = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.fraisLigneAchats = new FraisLigneAchats();
      this.fraisLigneAchatsDao = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.valorisationEnteteAchats = new ValorisationEnteteAchats();
      this.valorisationEnteteAchatsDao = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.lesTransfertCompta.clear();
      this.lesTransfertErreur.clear();
      if (this.listeDocumentTransfert.size() != 0) {
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
         this.documentEntete = new DocumentEntete();

         for(int var5 = 0; var5 < this.listeDocumentTransfert.size(); ++var5) {
            this.documentEntete = (DocumentEntete)this.listeDocumentTransfert.get(var5);
            if (this.documentEntete.isDocSelect()) {
               if (this.documentEntete.getDocNature() == 15) {
                  this.traitementFactureAchats(this.documentEntete, var4);
               } else if (this.documentEntete.getDocNature() == 16) {
                  this.traitementAvoirAchats(this.documentEntete, var4);
               } else if (this.documentEntete.getDocNature() == 17) {
                  this.traitementNoteDebitAchats(this.documentEntete, var4);
               } else if (this.documentEntete.getDocNature() == 18) {
                  this.traitementFraisAchat(this.documentEntete, var4);
               } else if (this.documentEntete.getDocNature() == 35 && this.optionAchats.getTrfCompta().equals("1")) {
                  this.traitementValorisationAchat(this.documentEntete, var4);
               }
            }
         }

         this.utilInitHibernate.closeSession();
         this.optimisationResultat(this.optionComptabilite.getTrf_cpteAchats());
      }

   }

   public void traitementFactureAchats(DocumentEntete var1, Session var2) throws HibernateException, NamingException {
      this.factureEnteteAchats = this.factureEnteteAchatsDao.pourParapheur(var1.getDocId(), var2);
      if (this.factureEnteteAchats != null) {
         String var3 = "" + (this.factureEnteteAchats.getFcfDate().getYear() + 1900);
         String var4 = this.formTransfertCtrl.calculeJournalSerie(15, this.factureEnteteAchats.getFcfSerie(), var3, var2);
         String var5 = "";
         if (var4 != null && !var4.isEmpty() && this.factureEnteteAchats.getTiers().getTietransfertCpte() == 0) {
            if (this.listeFamilleFournisseur.size() != 0) {
               for(int var6 = 0; var6 < this.listeFamilleFournisseur.size(); ++var6) {
                  if (this.factureEnteteAchats.getFcfCat() != null && !this.factureEnteteAchats.getFcfCat().isEmpty() && this.factureEnteteAchats.getFcfCat().equalsIgnoreCase(((ObjetFamilleTiers)this.listeFamilleFournisseur.get(var6)).getLibelle()) && ((ObjetFamilleTiers)this.listeFamilleFournisseur.get(var6)).getSerie() != null && !((ObjetFamilleTiers)this.listeFamilleFournisseur.get(var6)).getSerie().isEmpty() && ((ObjetFamilleTiers)this.listeFamilleFournisseur.get(var6)).getSerie() != null && !((ObjetFamilleTiers)this.listeFamilleFournisseur.get(var6)).getSerie().isEmpty() && ((ObjetFamilleTiers)this.listeFamilleFournisseur.get(var6)).getSerie().length() >= 2) {
                     var4 = ((ObjetFamilleTiers)this.listeFamilleFournisseur.get(var6)).getSerie();
                  }
               }
            }

            this.documentTraceAchats = this.documentTraceAchatsDao.chercherDestinationTrace(this.factureEnteteAchats.getFcfId(), 15, var2);
            int var8;
            if (this.documentTraceAchats != null) {
               long var14 = this.documentTraceAchats.getDoctrfOrgId();
               var8 = this.documentTraceAchats.getDoctrfOrgType();
               this.documentTraceAchats = this.documentTraceAchatsDao.chercherDestinationTrace(var14, var8, var2);
               if (this.documentTraceAchats != null) {
                  var5 = this.documentTraceAchats.getDoctrfOrgSerie() + ":" + this.documentTraceAchats.getDoctrfOrgNum();
               }
            }

            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("15");
            if (this.factureEnteteAchats.getFcfCat() != null && !this.factureEnteteAchats.getFcfCat().isEmpty()) {
               if (this.factureEnteteAchats.getFcfCat().equalsIgnoreCase("import")) {
                  this.transfertCompta.setTrfCategorie(1);
               } else {
                  this.transfertCompta.setTrfCategorie(0);
               }
            } else {
               this.transfertCompta.setTrfCategorie(0);
            }

            this.transfertCompta.setTrfNature(15);
            this.transfertCompta.setTrfIdOrigine(this.factureEnteteAchats.getFcfId());
            this.transfertCompta.setTrfAgent(this.factureEnteteAchats.getFcfNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.factureEnteteAchats.getFcfDate());
            this.transfertCompta.setTrfCode(var4);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.factureEnteteAchats.getFcfDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteAchats.getFcfDate()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.factureEnteteAchats.getTiers().getTieid(), var2));
            this.transfertCompta.setTrfDebitSaisie(0.0D);
            this.transfertCompta.setTrfCreditSaisie(this.factureEnteteAchats.getFcfTotTtc());
            this.transfertCompta.setTrfDateEcheance(this.factureEnteteAchats.getFcfDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneFactureAchats(var5);
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            if (this.optionAchats.getModeCifCfrREC().equals("0") && this.optionAchats.getModeCifCfrFAC().equals("1")) {
               if (this.factureEnteteAchats.getFcfTotFretLocal() + this.factureEnteteAchats.getFcfTotFret2Local() != 0.0D) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("15");
                  if (this.factureEnteteAchats.getFcfCat() != null && !this.factureEnteteAchats.getFcfCat().isEmpty()) {
                     if (this.factureEnteteAchats.getFcfCat().equalsIgnoreCase("import")) {
                        this.transfertCompta.setTrfCategorie(1);
                     } else {
                        this.transfertCompta.setTrfCategorie(0);
                     }
                  } else {
                     this.transfertCompta.setTrfCategorie(0);
                  }

                  this.transfertCompta.setTrfNature(15);
                  this.transfertCompta.setTrfIdOrigine(this.factureEnteteAchats.getFcfId());
                  this.transfertCompta.setTrfAgent(this.factureEnteteAchats.getFcfNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.factureEnteteAchats.getFcfDate());
                  this.transfertCompta.setTrfCode(var4);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.factureEnteteAchats.getFcfDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteAchats.getFcfDate()));
                  this.transfertCompta.setTrfCompte(this.optionAchats.getCompteFretFAC());
                  this.transfertCompta.setTrfDebitSaisie(this.factureEnteteAchats.getFcfTotFretLocal() + this.factureEnteteAchats.getFcfTotFret2Local());
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneFactureAchats(var5);
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }

               if (this.factureEnteteAchats.getFcfTotAssuranceLocal() != 0.0D) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("15");
                  if (this.factureEnteteAchats.getFcfCat() != null && !this.factureEnteteAchats.getFcfCat().isEmpty()) {
                     if (this.factureEnteteAchats.getFcfCat().equalsIgnoreCase("import")) {
                        this.transfertCompta.setTrfCategorie(1);
                     } else {
                        this.transfertCompta.setTrfCategorie(0);
                     }
                  } else {
                     this.transfertCompta.setTrfCategorie(0);
                  }

                  this.transfertCompta.setTrfNature(15);
                  this.transfertCompta.setTrfIdOrigine(this.factureEnteteAchats.getFcfId());
                  this.transfertCompta.setTrfAgent(this.factureEnteteAchats.getFcfNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.factureEnteteAchats.getFcfDate());
                  this.transfertCompta.setTrfCode(var4);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.factureEnteteAchats.getFcfDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteAchats.getFcfDate()));
                  this.transfertCompta.setTrfCompte(this.optionAchats.getCompteAssuranceFAC());
                  this.transfertCompta.setTrfDebitSaisie(this.factureEnteteAchats.getFcfTotAssuranceLocal());
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneFactureAchats(var5);
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }

            ArrayList var15 = new ArrayList();
            new ArrayList();
            List var7 = this.factureLigneAchatsDao.chargerLesLignes(this.factureEnteteAchats, var2);
            if (var7.size() != 0) {
               for(var8 = 0; var8 < var7.size(); ++var8) {
                  this.factureLigneAchats = new FactureLigneAchats();
                  this.factureLigneAchats = (FactureLigneAchats)var7.get(var8);
                  double var9 = 0.0D;
                  if (this.optionAchats.getModeCifCfrREC().equals("0") && this.optionAchats.getModeCifCfrFAC().equals("0")) {
                     double var11 = this.factureLigneAchats.getFcfligPt() / this.factureEnteteAchats.getFcfTotHt();
                     var9 = this.utilNombre.myRoundDevise((this.factureEnteteAchats.getFcfTotFretLocal() + this.factureEnteteAchats.getFcfTotFret2Local() + this.factureEnteteAchats.getFcfTotAssuranceLocal()) * var11, this.structureLog.getStrdevise());
                  }

                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("15");
                  if (this.factureEnteteAchats.getFcfCat() != null && !this.factureEnteteAchats.getFcfCat().isEmpty()) {
                     if (this.factureEnteteAchats.getFcfCat().equalsIgnoreCase("import")) {
                        this.transfertCompta.setTrfCategorie(1);
                     } else {
                        this.transfertCompta.setTrfCategorie(0);
                     }
                  } else {
                     this.transfertCompta.setTrfCategorie(0);
                  }

                  this.transfertCompta.setTrfNature(15);
                  this.transfertCompta.setTrfIdOrigine(this.factureEnteteAchats.getFcfId());
                  this.transfertCompta.setTrfAgent(this.factureEnteteAchats.getFcfNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.factureEnteteAchats.getFcfDate());
                  this.transfertCompta.setTrfCode(var4);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.factureEnteteAchats.getFcfDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteAchats.getFcfDate()));
                  String var17 = this.formTransfertCtrl.calculeCompteProduitAchats(this.optionAchats, this.factureLigneAchats.getFcfligCode(), this.factureEnteteAchats.getTiers().getTiecodepays(), this.factureEnteteAchats.getExercicesAchats().getExeachId(), var5, this.listPays, var2);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var17);
                  this.transfertCompta.setTrfDebitSaisie(this.factureLigneAchats.getFcfligPt() + var9);
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneFactureAchats(var5);
                  boolean var12 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var2);
                  if (var12 || this.transfertCompta.getTrfCompte().startsWith("38") && this.modeReception == 1) {
                     this.analytiqueFactureAchats();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var13 = new Stock();
                  var13.setStkTva(this.factureLigneAchats.getFcfligTva());
                  var13.setStkTaxe(this.factureLigneAchats.getFcfligTaxe());
                  var15.add(var13);
               }
            }

            if (var15.size() != 0) {
               for(var8 = 0; var8 < var15.size(); ++var8) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("15");
                  if (this.factureEnteteAchats.getFcfCat() != null && !this.factureEnteteAchats.getFcfCat().isEmpty()) {
                     if (this.factureEnteteAchats.getFcfCat().equalsIgnoreCase("import")) {
                        this.transfertCompta.setTrfCategorie(1);
                     } else {
                        this.transfertCompta.setTrfCategorie(0);
                     }
                  } else {
                     this.transfertCompta.setTrfCategorie(0);
                  }

                  this.transfertCompta.setTrfNature(15);
                  this.transfertCompta.setTrfIdOrigine(this.factureEnteteAchats.getFcfId());
                  this.transfertCompta.setTrfAgent(this.factureEnteteAchats.getFcfNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.factureEnteteAchats.getFcfDate());
                  this.transfertCompta.setTrfCode(var4);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.factureEnteteAchats.getFcfDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteAchats.getFcfDate()));
                  String var16 = this.formTransfertCtrl.calculeCompteTvaAchats(((Stock)var15.get(var8)).getStkTaxe(), this.factureEnteteAchats.getExercicesAchats().getExeachId(), var2);
                  this.transfertCompta.setTrfCompte(var16);
                  this.transfertCompta.setTrfDebitSaisie(((Stock)var15.get(var8)).getStkTva());
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneFactureAchats(var5);
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneFactureAchats(String var1) {
      if (this.optionAchats.getZoneRef1().equals("0")) {
         if (this.optionAchats.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfSerie() + ":" + this.factureEnteteAchats.getFcfNum());
         } else if (this.optionAchats.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfNum());
         }
      } else if (this.optionAchats.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1(var1);
      } else if (this.optionAchats.getZoneRef1().equals("2")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfProformaFour());
      } else if (this.optionAchats.getZoneRef1().equals("3")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfAnal4());
      } else if (this.optionAchats.getZoneRef1().equals("11")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfInfo1());
      } else if (this.optionAchats.getZoneRef1().equals("12")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfInfo2());
      } else if (this.optionAchats.getZoneRef1().equals("13")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfInfo3());
      } else if (this.optionAchats.getZoneRef1().equals("14")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfInfo4());
      } else if (this.optionAchats.getZoneRef1().equals("15")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfInfo5());
      } else if (this.optionAchats.getZoneRef1().equals("16")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfInfo6());
      } else if (this.optionAchats.getZoneRef1().equals("17")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfInfo7());
      } else if (this.optionAchats.getZoneRef1().equals("18")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfInfo8());
      } else if (this.optionAchats.getZoneRef1().equals("19")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfInfo9());
      } else if (this.optionAchats.getZoneRef1().equals("20")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteAchats.getFcfInfo10());
      }

      if (this.optionAchats.getZoneRef2().equals("0")) {
         if (this.optionAchats.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfSerie() + ":" + this.factureEnteteAchats.getFcfNum());
         } else if (this.optionAchats.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfNum());
         }
      } else if (this.optionAchats.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2(var1);
      } else if (this.optionAchats.getZoneRef2().equals("2")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfProformaFour());
      } else if (this.optionAchats.getZoneRef2().equals("3")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfAnal4());
      } else if (this.optionAchats.getZoneRef2().equals("11")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfInfo1());
      } else if (this.optionAchats.getZoneRef2().equals("12")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfInfo2());
      } else if (this.optionAchats.getZoneRef2().equals("13")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfInfo3());
      } else if (this.optionAchats.getZoneRef2().equals("14")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfInfo4());
      } else if (this.optionAchats.getZoneRef2().equals("15")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfInfo5());
      } else if (this.optionAchats.getZoneRef2().equals("16")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfInfo6());
      } else if (this.optionAchats.getZoneRef2().equals("17")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfInfo7());
      } else if (this.optionAchats.getZoneRef2().equals("18")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfInfo8());
      } else if (this.optionAchats.getZoneRef2().equals("19")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfInfo9());
      } else if (this.optionAchats.getZoneRef2().equals("20")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfInfo10());
      }

      if (this.optionAchats.getZoneLibelle().equals("0")) {
         if (this.factureEnteteAchats.getFcfDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.factureEnteteAchats.getFcfDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.factureEnteteAchats.getFcfNomTiers());
         }
      } else if (this.optionAchats.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.factureEnteteAchats.getFcfObject());
      } else if (this.optionAchats.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.factureEnteteAchats.getFcfObject() + " date " + this.utilDate.dateToStringFr(this.factureEnteteAchats.getFcfDate()));
      } else if (this.optionAchats.getZoneLibelle().equals("3")) {
         if (this.factureEnteteAchats.getFcfDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.factureEnteteAchats.getFcfDiversNom() + "  Dossier N° " + this.factureEnteteAchats.getFcfAnal4());
         } else {
            this.transfertCompta.setTrfLibelle(this.factureEnteteAchats.getFcfNomTiers() + "  Dossier N° " + this.factureEnteteAchats.getFcfAnal4());
         }
      }

      if (this.optionAchats.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteAchats.getFcfObject());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("11")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteAchats.getFcfInfo1());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("12")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteAchats.getFcfInfo2());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("13")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteAchats.getFcfInfo3());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("14")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteAchats.getFcfInfo4());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("15")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteAchats.getFcfInfo5());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("16")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteAchats.getFcfInfo6());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("17")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteAchats.getFcfInfo7());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("18")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteAchats.getFcfInfo8());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("19")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteAchats.getFcfInfo9());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("20")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteAchats.getFcfInfo10());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueFactureAchats() {
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.produits != null) {
         if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":") || this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
            if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":")) {
               var1 = this.produits.getProCle1().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
               var1 = this.produits.getProCle2().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         } else if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.produits.getProActivite());
            } else {
               var1 = this.produits.getProActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         }

         if (this.famillesProduitsAchats != null) {
            if ((this.famillesProduitsAchats.getFamachCle1() == null || this.famillesProduitsAchats.getFamachCle1().isEmpty() || !this.famillesProduitsAchats.getFamachCle1().contains(":")) && (this.famillesProduitsAchats.getFamachCle2() == null || this.famillesProduitsAchats.getFamachCle2().isEmpty() || !this.famillesProduitsAchats.getFamachCle2().contains(":"))) {
               if (this.famillesProduitsAchats.getFamachActivite() != null && !this.famillesProduitsAchats.getFamachActivite().isEmpty() && this.famillesProduitsAchats.getFamachActivite().contains(":") && (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty())) {
                  if (this.decoupageActivite) {
                     this.transfertCompta.setTrfActivite(this.transfertCompta.getTrfActivite());
                  } else {
                     var1 = this.famillesProduitsAchats.getFamachActivite().split(":");
                     this.transfertCompta.setTrfActivite(var1[0]);
                  }
               }
            } else {
               if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && this.famillesProduitsAchats.getFamachCle1() != null && !this.famillesProduitsAchats.getFamachCle1().isEmpty() && this.famillesProduitsAchats.getFamachCle1().contains(":")) {
                  var1 = this.famillesProduitsAchats.getFamachCle1().split(":");
                  this.transfertCompta.setTrfRepartitionCle1(var1[0]);
               }

               if ((this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty()) && this.famillesProduitsAchats.getFamachCle2() != null && !this.famillesProduitsAchats.getFamachCle2().isEmpty() && this.famillesProduitsAchats.getFamachCle2().contains(":")) {
                  var1 = this.famillesProduitsAchats.getFamachCle2().split(":");
                  this.transfertCompta.setTrfRepartitionCle2(var1[0]);
               }
            }
         }
      }

      this.transfertCompta.setTrfDossier(this.factureEnteteAchats.getFcfAnal4());
      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.factureEnteteAchats.getFcfActivite() != null && !this.factureEnteteAchats.getFcfActivite().isEmpty() && this.factureEnteteAchats.getFcfActivite().contains(":") && this.factureEnteteAchats.getFcfActivite().length() >= 3) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.factureEnteteAchats.getFcfActivite());
            } else {
               var1 = this.factureEnteteAchats.getFcfActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         } else {
            this.transfertCompta.setTrfActivite(this.factureEnteteAchats.getFcfActivite());
         }

         if (this.factureEnteteAchats.getFcfSite() != null && !this.factureEnteteAchats.getFcfSite().isEmpty() && this.factureEnteteAchats.getFcfSite().contains(":") && this.factureEnteteAchats.getFcfSite().length() >= 3) {
            var1 = this.factureEnteteAchats.getFcfSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.factureEnteteAchats.getFcfSite());
         }

         if (this.factureEnteteAchats.getFcfDepartement() != null && !this.factureEnteteAchats.getFcfDepartement().isEmpty() && this.factureEnteteAchats.getFcfDepartement().contains(":") && this.factureEnteteAchats.getFcfDepartement().length() >= 3) {
            var1 = this.factureEnteteAchats.getFcfDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.factureEnteteAchats.getFcfDepartement());
         }

         if (this.factureEnteteAchats.getFcfService() != null && !this.factureEnteteAchats.getFcfService().isEmpty() && this.factureEnteteAchats.getFcfService().contains(":") && this.factureEnteteAchats.getFcfService().length() >= 3) {
            var1 = this.factureEnteteAchats.getFcfService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.factureEnteteAchats.getFcfService());
         }

         if (this.factureEnteteAchats.getFcfRegion() != null && !this.factureEnteteAchats.getFcfRegion().isEmpty() && this.factureEnteteAchats.getFcfRegion().contains(":") && this.factureEnteteAchats.getFcfRegion().length() >= 3) {
            var1 = this.factureEnteteAchats.getFcfRegion().split(":");
            this.transfertCompta.setTrfRegion(var1[0]);
         } else {
            this.transfertCompta.setTrfRegion(this.factureEnteteAchats.getFcfRegion());
         }

         if (this.factureEnteteAchats.getFcfSecteur() != null && !this.factureEnteteAchats.getFcfSecteur().isEmpty() && this.factureEnteteAchats.getFcfSecteur().contains(":") && this.factureEnteteAchats.getFcfSecteur().length() >= 3) {
            var1 = this.factureEnteteAchats.getFcfSecteur().split(":");
            this.transfertCompta.setTrfSecteur(var1[0]);
         } else {
            this.transfertCompta.setTrfSecteur(this.factureEnteteAchats.getFcfSecteur());
         }

         if (this.factureEnteteAchats.getFcfAnal2() != null && !this.factureEnteteAchats.getFcfAnal2().isEmpty() && this.factureEnteteAchats.getFcfAnal2().contains(":") && this.factureEnteteAchats.getFcfAnal2().length() >= 3) {
            var1 = this.factureEnteteAchats.getFcfAnal2().split(":");
            this.transfertCompta.setTrfParc(var1[0]);
         } else {
            this.transfertCompta.setTrfParc(this.factureEnteteAchats.getFcfAnal2());
         }

         if (this.factureEnteteAchats.getFcfBudget() != null && !this.factureEnteteAchats.getFcfBudget().isEmpty() && this.factureEnteteAchats.getFcfBudget().contains(":") && this.factureEnteteAchats.getFcfBudget().length() >= 3) {
            var1 = this.factureEnteteAchats.getFcfBudget().split(":");
            this.transfertCompta.setTrfBudget(var1[0]);
         } else {
            this.transfertCompta.setTrfBudget(this.factureEnteteAchats.getFcfBudget());
         }

         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
      }

   }

   public void traitementAvoirAchats(DocumentEntete var1, Session var2) throws HibernateException, NamingException {
      this.avoirEnteteAchats = this.avoirEnteteAchatsDao.pourParapheur(var1.getDocId(), var2);
      if (this.avoirEnteteAchats != null) {
         String var3 = "" + (this.avoirEnteteAchats.getAvfDate().getYear() + 1900);
         String var4 = this.formTransfertCtrl.calculeJournalSerie(16, this.avoirEnteteAchats.getAvfSerie(), var3, var2);
         String var5 = "";
         if (var4 != null && !var4.isEmpty() && this.avoirEnteteAchats.getTiers().getTietransfertCpte() == 0) {
            this.documentTraceAchats = this.documentTraceAchatsDao.chercherDestinationTrace(this.avoirEnteteAchats.getAvfId(), 16, var2);
            int var8;
            if (this.documentTraceAchats != null) {
               long var6 = this.documentTraceAchats.getDoctrfOrgId();
               var8 = this.documentTraceAchats.getDoctrfOrgType();
               this.documentTraceAchats = this.documentTraceAchatsDao.chercherDestinationTrace(var6, var8, var2);
               if (this.documentTraceAchats != null) {
                  var5 = this.documentTraceAchats.getDoctrfOrgSerie() + ":" + this.documentTraceAchats.getDoctrfOrgNum();
               }
            }

            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("16");
            if (this.avoirEnteteAchats.getAvfCat() != null && !this.avoirEnteteAchats.getAvfCat().isEmpty()) {
               if (this.avoirEnteteAchats.getAvfCat().equalsIgnoreCase("import")) {
                  this.transfertCompta.setTrfCategorie(1);
               } else {
                  this.transfertCompta.setTrfCategorie(0);
               }
            } else {
               this.transfertCompta.setTrfCategorie(0);
            }

            this.transfertCompta.setTrfNature(16);
            this.transfertCompta.setTrfIdOrigine(this.avoirEnteteAchats.getAvfId());
            this.transfertCompta.setTrfAgent(this.avoirEnteteAchats.getAvfNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.avoirEnteteAchats.getAvfDate());
            this.transfertCompta.setTrfCode(var4);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.avoirEnteteAchats.getAvfDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.avoirEnteteAchats.getAvfDate()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.avoirEnteteAchats.getTiers().getTieid(), var2));
            this.transfertCompta.setTrfDebitSaisie(this.avoirEnteteAchats.getAvfTotTtc());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance(this.avoirEnteteAchats.getAvfDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneAvoirAchats(var5);
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            ArrayList var12 = new ArrayList();
            new ArrayList();
            List var7 = this.avoirLigneAchatsDao.chargerLesLignes(this.avoirEnteteAchats, var2);
            String var9;
            if (var7.size() != 0) {
               for(var8 = 0; var8 < var7.size(); ++var8) {
                  this.avoirLigneAchats = new AvoirLigneAchats();
                  this.avoirLigneAchats = (AvoirLigneAchats)var7.get(var8);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("16");
                  if (this.avoirEnteteAchats.getAvfCat() != null && !this.avoirEnteteAchats.getAvfCat().isEmpty()) {
                     if (this.avoirEnteteAchats.getAvfCat().equalsIgnoreCase("import")) {
                        this.transfertCompta.setTrfCategorie(1);
                     } else {
                        this.transfertCompta.setTrfCategorie(0);
                     }
                  } else {
                     this.transfertCompta.setTrfCategorie(0);
                  }

                  this.transfertCompta.setTrfNature(16);
                  this.transfertCompta.setTrfIdOrigine(this.avoirEnteteAchats.getAvfId());
                  this.transfertCompta.setTrfAgent(this.avoirEnteteAchats.getAvfNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.avoirEnteteAchats.getAvfDate());
                  this.transfertCompta.setTrfCode(var4);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.avoirEnteteAchats.getAvfDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.avoirEnteteAchats.getAvfDate()));
                  var9 = this.formTransfertCtrl.calculeCompteProduitAchats(this.optionAchats, this.avoirLigneAchats.getAvfligCode(), this.avoirEnteteAchats.getTiers().getTiecodepays(), this.avoirEnteteAchats.getExercicesAchats().getExeachId(), "", this.listPays, var2);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var9);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.avoirLigneAchats.getAvfligPt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneAvoirAchats(var5);
                  boolean var10 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var2);
                  if (var10 || this.transfertCompta.getTrfCompte().startsWith("38") && this.modeReception == 1) {
                     this.analytiqueAvoirAchats();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var11 = new Stock();
                  var11.setStkTva(this.avoirLigneAchats.getAvfligTva());
                  var11.setStkTaxe(this.avoirLigneAchats.getAvfligTaxe());
                  var12.add(var11);
               }
            }

            if (var12.size() != 0) {
               for(var8 = 0; var8 < var12.size(); ++var8) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("16");
                  if (this.avoirEnteteAchats.getAvfCat() != null && !this.avoirEnteteAchats.getAvfCat().isEmpty()) {
                     if (this.avoirEnteteAchats.getAvfCat().equalsIgnoreCase("import")) {
                        this.transfertCompta.setTrfCategorie(1);
                     } else {
                        this.transfertCompta.setTrfCategorie(0);
                     }
                  } else {
                     this.transfertCompta.setTrfCategorie(0);
                  }

                  this.transfertCompta.setTrfNature(16);
                  this.transfertCompta.setTrfIdOrigine(this.avoirEnteteAchats.getAvfId());
                  this.transfertCompta.setTrfAgent(this.avoirEnteteAchats.getAvfNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.avoirEnteteAchats.getAvfDate());
                  this.transfertCompta.setTrfCode(var4);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.avoirEnteteAchats.getAvfDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.avoirEnteteAchats.getAvfDate()));
                  var9 = this.formTransfertCtrl.calculeCompteTvaAchats(((Stock)var12.get(var8)).getStkTaxe(), this.avoirEnteteAchats.getExercicesAchats().getExeachId(), var2);
                  this.transfertCompta.setTrfCompte(var9);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var12.get(var8)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneAvoirAchats(var5);
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneAvoirAchats(String var1) {
      if (this.optionAchats.getZoneRef1().equals("0")) {
         if (this.optionAchats.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfSerie() + ":" + this.avoirEnteteAchats.getAvfNum());
         } else if (this.optionAchats.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfNum());
         }
      } else if (this.optionAchats.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1(var1);
      } else if (this.optionAchats.getZoneRef1().equals("2")) {
         this.transfertCompta.setTrfReference1("");
      } else if (this.optionAchats.getZoneRef1().equals("3")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfAnal4());
      } else if (this.optionAchats.getZoneRef1().equals("11")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfInfo1());
      } else if (this.optionAchats.getZoneRef1().equals("12")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfInfo2());
      } else if (this.optionAchats.getZoneRef1().equals("13")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfInfo3());
      } else if (this.optionAchats.getZoneRef1().equals("14")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfInfo4());
      } else if (this.optionAchats.getZoneRef1().equals("15")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfInfo5());
      } else if (this.optionAchats.getZoneRef1().equals("16")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfInfo6());
      } else if (this.optionAchats.getZoneRef1().equals("17")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfInfo7());
      } else if (this.optionAchats.getZoneRef1().equals("18")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfInfo8());
      } else if (this.optionAchats.getZoneRef1().equals("19")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfInfo9());
      } else if (this.optionAchats.getZoneRef1().equals("20")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteAchats.getAvfInfo10());
      }

      if (this.optionAchats.getZoneRef2().equals("0")) {
         if (this.optionAchats.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfSerie() + ":" + this.avoirEnteteAchats.getAvfNum());
         } else if (this.optionAchats.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfNum());
         }
      } else if (this.optionAchats.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2(var1);
      } else if (this.optionAchats.getZoneRef2().equals("2")) {
         this.transfertCompta.setTrfReference2("");
      } else if (this.optionAchats.getZoneRef2().equals("3")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfAnal4());
      } else if (this.optionAchats.getZoneRef2().equals("11")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfInfo1());
      } else if (this.optionAchats.getZoneRef2().equals("12")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfInfo2());
      } else if (this.optionAchats.getZoneRef2().equals("13")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfInfo3());
      } else if (this.optionAchats.getZoneRef2().equals("14")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfInfo4());
      } else if (this.optionAchats.getZoneRef2().equals("15")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfInfo5());
      } else if (this.optionAchats.getZoneRef2().equals("16")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfInfo6());
      } else if (this.optionAchats.getZoneRef2().equals("17")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfInfo7());
      } else if (this.optionAchats.getZoneRef2().equals("18")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfInfo8());
      } else if (this.optionAchats.getZoneRef2().equals("19")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfInfo9());
      } else if (this.optionAchats.getZoneRef2().equals("20")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteAchats.getAvfInfo10());
      }

      if (this.optionAchats.getZoneLibelle().equals("0")) {
         if (this.avoirEnteteAchats.getAvfDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.avoirEnteteAchats.getAvfDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.avoirEnteteAchats.getAvfNomTiers());
         }
      } else if (this.optionAchats.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.avoirEnteteAchats.getAvfObject());
      } else if (this.optionAchats.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.avoirEnteteAchats.getAvfObject() + " date " + this.utilDate.dateToStringFr(this.avoirEnteteAchats.getAvfDate()));
      }

      if (this.optionAchats.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteAchats.getAvfObject());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("11")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteAchats.getAvfInfo1());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("12")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteAchats.getAvfInfo2());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("13")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteAchats.getAvfInfo3());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("14")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteAchats.getAvfInfo4());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("15")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteAchats.getAvfInfo5());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("16")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteAchats.getAvfInfo6());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("17")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteAchats.getAvfInfo7());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("18")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteAchats.getAvfInfo8());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("19")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteAchats.getAvfInfo9());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("20")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteAchats.getAvfInfo10());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueAvoirAchats() {
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.produits != null) {
         if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":") || this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
            if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":")) {
               var1 = this.produits.getProCle1().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
               var1 = this.produits.getProCle2().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         } else if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.produits.getProActivite());
            } else {
               var1 = this.produits.getProActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         }

         if (this.famillesProduitsAchats != null) {
            if ((this.famillesProduitsAchats.getFamachCle1() == null || this.famillesProduitsAchats.getFamachCle1().isEmpty() || !this.famillesProduitsAchats.getFamachCle1().contains(":")) && (this.famillesProduitsAchats.getFamachCle2() == null || this.famillesProduitsAchats.getFamachCle2().isEmpty() || !this.famillesProduitsAchats.getFamachCle2().contains(":"))) {
               if (this.famillesProduitsAchats.getFamachActivite() != null && !this.famillesProduitsAchats.getFamachActivite().isEmpty() && this.famillesProduitsAchats.getFamachActivite().contains(":") && (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty())) {
                  if (this.decoupageActivite) {
                     this.transfertCompta.setTrfActivite(this.transfertCompta.getTrfActivite());
                  } else {
                     var1 = this.famillesProduitsAchats.getFamachActivite().split(":");
                     this.transfertCompta.setTrfActivite(var1[0]);
                  }
               }
            } else {
               if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && this.famillesProduitsAchats.getFamachCle1() != null && !this.famillesProduitsAchats.getFamachCle1().isEmpty() && this.famillesProduitsAchats.getFamachCle1().contains(":")) {
                  var1 = this.famillesProduitsAchats.getFamachCle1().split(":");
                  this.transfertCompta.setTrfRepartitionCle1(var1[0]);
               }

               if ((this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty()) && this.famillesProduitsAchats.getFamachCle2() != null && !this.famillesProduitsAchats.getFamachCle2().isEmpty() && this.famillesProduitsAchats.getFamachCle2().contains(":")) {
                  var1 = this.famillesProduitsAchats.getFamachCle2().split(":");
                  this.transfertCompta.setTrfRepartitionCle2(var1[0]);
               }
            }
         }
      }

      this.transfertCompta.setTrfDossier(this.factureEnteteAchats.getFcfAnal4());
      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.avoirEnteteAchats.getAvfActivite() != null && !this.avoirEnteteAchats.getAvfActivite().isEmpty() && this.avoirEnteteAchats.getAvfActivite().contains(":") && this.avoirEnteteAchats.getAvfActivite().length() >= 3) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.avoirEnteteAchats.getAvfActivite());
            } else {
               var1 = this.avoirEnteteAchats.getAvfActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         } else {
            this.transfertCompta.setTrfActivite(this.avoirEnteteAchats.getAvfActivite());
         }

         if (this.avoirEnteteAchats.getAvfSite() != null && !this.avoirEnteteAchats.getAvfSite().isEmpty() && this.avoirEnteteAchats.getAvfSite().contains(":") && this.avoirEnteteAchats.getAvfSite().length() >= 3) {
            var1 = this.avoirEnteteAchats.getAvfSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.avoirEnteteAchats.getAvfSite());
         }

         if (this.avoirEnteteAchats.getAvfDepartement() != null && !this.avoirEnteteAchats.getAvfDepartement().isEmpty() && this.avoirEnteteAchats.getAvfDepartement().contains(":") && this.avoirEnteteAchats.getAvfDepartement().length() >= 3) {
            var1 = this.avoirEnteteAchats.getAvfDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.avoirEnteteAchats.getAvfDepartement());
         }

         if (this.avoirEnteteAchats.getAvfService() != null && !this.avoirEnteteAchats.getAvfService().isEmpty() && this.avoirEnteteAchats.getAvfService().contains(":") && this.avoirEnteteAchats.getAvfService().length() >= 3) {
            var1 = this.avoirEnteteAchats.getAvfService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.avoirEnteteAchats.getAvfService());
         }

         if (this.avoirEnteteAchats.getAvfRegion() != null && !this.avoirEnteteAchats.getAvfRegion().isEmpty() && this.avoirEnteteAchats.getAvfRegion().contains(":") && this.avoirEnteteAchats.getAvfRegion().length() >= 3) {
            var1 = this.avoirEnteteAchats.getAvfRegion().split(":");
            this.transfertCompta.setTrfRegion(var1[0]);
         } else {
            this.transfertCompta.setTrfRegion(this.avoirEnteteAchats.getAvfRegion());
         }

         if (this.avoirEnteteAchats.getAvfSecteur() != null && !this.avoirEnteteAchats.getAvfSecteur().isEmpty() && this.avoirEnteteAchats.getAvfSecteur().contains(":") && this.avoirEnteteAchats.getAvfSecteur().length() >= 3) {
            var1 = this.avoirEnteteAchats.getAvfSecteur().split(":");
            this.transfertCompta.setTrfSecteur(var1[0]);
         } else {
            this.transfertCompta.setTrfSecteur(this.avoirEnteteAchats.getAvfSecteur());
         }

         if (this.avoirEnteteAchats.getAvfAnal2() != null && !this.avoirEnteteAchats.getAvfAnal2().isEmpty() && this.avoirEnteteAchats.getAvfAnal2().contains(":") && this.avoirEnteteAchats.getAvfAnal2().length() >= 3) {
            var1 = this.avoirEnteteAchats.getAvfAnal2().split(":");
            this.transfertCompta.setTrfParc(var1[0]);
         } else {
            this.transfertCompta.setTrfParc(this.avoirEnteteAchats.getAvfAnal2());
         }

         if (this.avoirEnteteAchats.getAvfBudget() != null && !this.avoirEnteteAchats.getAvfBudget().isEmpty() && this.avoirEnteteAchats.getAvfBudget().contains(":") && this.avoirEnteteAchats.getAvfBudget().length() >= 3) {
            var1 = this.avoirEnteteAchats.getAvfBudget().split(":");
            this.transfertCompta.setTrfBudget(var1[0]);
         } else {
            this.transfertCompta.setTrfBudget(this.avoirEnteteAchats.getAvfBudget());
         }

         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
      }

   }

   public void traitementNoteDebitAchats(DocumentEntete var1, Session var2) throws HibernateException, NamingException {
      this.noteDebitEnteteAchats = this.noteDebitEnteteAchatsDao.pourParapheur(var1.getDocId(), var2);
      if (this.noteDebitEnteteAchats != null) {
         String var3 = "" + (this.noteDebitEnteteAchats.getNdfDate().getYear() + 1900);
         String var4 = this.formTransfertCtrl.calculeJournalSerie(17, this.noteDebitEnteteAchats.getNdfSerie(), var3, var2);
         if (var4 != null && !var4.isEmpty() && this.noteDebitEnteteAchats.getTiers().getTietransfertCpte() == 0) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("17");
            if (this.noteDebitEnteteAchats.getNdfCat() != null && !this.noteDebitEnteteAchats.getNdfCat().isEmpty()) {
               if (this.noteDebitEnteteAchats.getNdfCat().equalsIgnoreCase("import")) {
                  this.transfertCompta.setTrfCategorie(1);
               } else {
                  this.transfertCompta.setTrfCategorie(0);
               }
            } else {
               this.transfertCompta.setTrfCategorie(0);
            }

            this.transfertCompta.setTrfNature(17);
            this.transfertCompta.setTrfIdOrigine(this.noteDebitEnteteAchats.getNdfId());
            this.transfertCompta.setTrfAgent(this.noteDebitEnteteAchats.getNdfNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.noteDebitEnteteAchats.getNdfDate());
            this.transfertCompta.setTrfCode(var4);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.noteDebitEnteteAchats.getNdfDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.noteDebitEnteteAchats.getNdfDate()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.noteDebitEnteteAchats.getTiers().getTieid(), var2));
            this.transfertCompta.setTrfDebitSaisie(this.noteDebitEnteteAchats.getNdfTotTtc());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance(this.noteDebitEnteteAchats.getNdfDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneNoteDebitAchats("");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            ArrayList var5 = new ArrayList();
            new ArrayList();
            List var6 = this.noteDebitLigneAchatsDao.chargerLesLignes(this.noteDebitEnteteAchats, var2);
            int var7;
            String var8;
            if (var6.size() != 0) {
               for(var7 = 0; var7 < var6.size(); ++var7) {
                  this.noteDebitLigneAchats = new NoteDebitLigneAchats();
                  this.noteDebitLigneAchats = (NoteDebitLigneAchats)var6.get(var7);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("17");
                  if (this.noteDebitEnteteAchats.getNdfCat() != null && !this.noteDebitEnteteAchats.getNdfCat().isEmpty()) {
                     if (this.noteDebitEnteteAchats.getNdfCat().equalsIgnoreCase("import")) {
                        this.transfertCompta.setTrfCategorie(1);
                     } else {
                        this.transfertCompta.setTrfCategorie(0);
                     }
                  } else {
                     this.transfertCompta.setTrfCategorie(0);
                  }

                  this.transfertCompta.setTrfNature(17);
                  this.transfertCompta.setTrfIdOrigine(this.noteDebitEnteteAchats.getNdfId());
                  this.transfertCompta.setTrfAgent(this.noteDebitEnteteAchats.getNdfNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.noteDebitEnteteAchats.getNdfDate());
                  this.transfertCompta.setTrfCode(var4);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.noteDebitEnteteAchats.getNdfDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.noteDebitEnteteAchats.getNdfDate()));
                  var8 = this.formTransfertCtrl.calculeCompteProduitAchats(this.optionAchats, this.noteDebitLigneAchats.getNdfligCode(), this.noteDebitEnteteAchats.getTiers().getTiecodepays(), this.noteDebitEnteteAchats.getExercicesAchats().getExeachId(), "", this.listPays, var2);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var8);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.noteDebitLigneAchats.getNdfligPt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneNoteDebitAchats("");
                  boolean var9 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var2);
                  if (var9 || this.transfertCompta.getTrfCompte().startsWith("38") && this.modeReception == 1) {
                     this.analytiqueNoteDebitAchats();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var10 = new Stock();
                  var10.setStkTva(this.noteDebitLigneAchats.getNdfligTva());
                  var10.setStkTaxe(this.noteDebitLigneAchats.getNdfligTaxe());
                  var5.add(var10);
               }
            }

            if (var5.size() != 0) {
               for(var7 = 0; var7 < var5.size(); ++var7) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("17");
                  if (this.noteDebitEnteteAchats.getNdfCat() != null && !this.noteDebitEnteteAchats.getNdfCat().isEmpty()) {
                     if (this.noteDebitEnteteAchats.getNdfCat().equalsIgnoreCase("import")) {
                        this.transfertCompta.setTrfCategorie(1);
                     } else {
                        this.transfertCompta.setTrfCategorie(0);
                     }
                  } else {
                     this.transfertCompta.setTrfCategorie(0);
                  }

                  this.transfertCompta.setTrfNature(17);
                  this.transfertCompta.setTrfIdOrigine(this.noteDebitEnteteAchats.getNdfId());
                  this.transfertCompta.setTrfAgent(this.noteDebitEnteteAchats.getNdfNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.noteDebitEnteteAchats.getNdfDate());
                  this.transfertCompta.setTrfCode(var4);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.noteDebitEnteteAchats.getNdfDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.noteDebitEnteteAchats.getNdfDate()));
                  var8 = this.formTransfertCtrl.calculeCompteTvaAchats(((Stock)var5.get(var7)).getStkTaxe(), this.noteDebitEnteteAchats.getExercicesAchats().getExeachId(), var2);
                  this.transfertCompta.setTrfCompte(var8);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var5.get(var7)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneNoteDebitAchats("");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneNoteDebitAchats(String var1) {
      if (this.optionAchats.getZoneRef1().equals("0")) {
         if (this.optionAchats.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfSerie() + ":" + this.noteDebitEnteteAchats.getNdfNum());
         } else if (this.optionAchats.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfNum());
         }
      } else if (this.optionAchats.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1(var1);
      } else if (this.optionAchats.getZoneRef1().equals("2")) {
         this.transfertCompta.setTrfReference1("");
      } else if (this.optionAchats.getZoneRef1().equals("3")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfAnal4());
      } else if (this.optionAchats.getZoneRef1().equals("11")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfInfo1());
      } else if (this.optionAchats.getZoneRef1().equals("12")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfInfo2());
      } else if (this.optionAchats.getZoneRef1().equals("13")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfInfo3());
      } else if (this.optionAchats.getZoneRef1().equals("14")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfInfo4());
      } else if (this.optionAchats.getZoneRef1().equals("15")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfInfo5());
      } else if (this.optionAchats.getZoneRef1().equals("16")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfInfo6());
      } else if (this.optionAchats.getZoneRef1().equals("17")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfInfo7());
      } else if (this.optionAchats.getZoneRef1().equals("18")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfInfo8());
      } else if (this.optionAchats.getZoneRef1().equals("19")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfInfo9());
      } else if (this.optionAchats.getZoneRef1().equals("20")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteAchats.getNdfInfo10());
      }

      if (this.optionAchats.getZoneRef2().equals("0")) {
         if (this.optionAchats.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfSerie() + ":" + this.noteDebitEnteteAchats.getNdfNum());
         } else if (this.optionAchats.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfNum());
         }
      } else if (this.optionAchats.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2(var1);
      } else if (this.optionAchats.getZoneRef2().equals("2")) {
         this.transfertCompta.setTrfReference2("");
      } else if (this.optionAchats.getZoneRef2().equals("3")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfAnal4());
      } else if (this.optionAchats.getZoneRef2().equals("11")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfInfo1());
      } else if (this.optionAchats.getZoneRef2().equals("12")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfInfo2());
      } else if (this.optionAchats.getZoneRef2().equals("13")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfInfo3());
      } else if (this.optionAchats.getZoneRef2().equals("14")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfInfo4());
      } else if (this.optionAchats.getZoneRef2().equals("15")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfInfo5());
      } else if (this.optionAchats.getZoneRef2().equals("16")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfInfo6());
      } else if (this.optionAchats.getZoneRef2().equals("17")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfInfo7());
      } else if (this.optionAchats.getZoneRef2().equals("18")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfInfo8());
      } else if (this.optionAchats.getZoneRef2().equals("19")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfInfo9());
      } else if (this.optionAchats.getZoneRef2().equals("20")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteAchats.getNdfInfo10());
      }

      if (this.optionAchats.getZoneLibelle().equals("0")) {
         if (this.noteDebitEnteteAchats.getNdfDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.noteDebitEnteteAchats.getNdfDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.noteDebitEnteteAchats.getNdfNomTiers());
         }
      } else if (this.optionAchats.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.noteDebitEnteteAchats.getNdfObject());
      } else if (this.optionAchats.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.noteDebitEnteteAchats.getNdfObject() + " date " + this.utilDate.dateToStringFr(this.noteDebitEnteteAchats.getNdfDate()));
      }

      if (this.optionAchats.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteAchats.getNdfObject());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("11")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteAchats.getNdfInfo1());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("12")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteAchats.getNdfInfo2());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("13")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteAchats.getNdfInfo3());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("14")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteAchats.getNdfInfo4());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("15")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteAchats.getNdfInfo5());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("16")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteAchats.getNdfInfo6());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("17")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteAchats.getNdfInfo7());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("18")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteAchats.getNdfInfo8());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("19")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteAchats.getNdfInfo9());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("20")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteAchats.getNdfInfo10());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueNoteDebitAchats() {
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.produits != null) {
         if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":") || this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
            if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":")) {
               var1 = this.produits.getProCle1().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
               var1 = this.produits.getProCle2().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         } else if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.produits.getProActivite());
            } else {
               var1 = this.produits.getProActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         }

         if (this.famillesProduitsAchats != null) {
            if ((this.famillesProduitsAchats.getFamachCle1() == null || this.famillesProduitsAchats.getFamachCle1().isEmpty() || !this.famillesProduitsAchats.getFamachCle1().contains(":")) && (this.famillesProduitsAchats.getFamachCle2() == null || this.famillesProduitsAchats.getFamachCle2().isEmpty() || !this.famillesProduitsAchats.getFamachCle2().contains(":"))) {
               if (this.famillesProduitsAchats.getFamachActivite() != null && !this.famillesProduitsAchats.getFamachActivite().isEmpty() && this.famillesProduitsAchats.getFamachActivite().contains(":")) {
                  if (this.decoupageActivite) {
                     this.transfertCompta.setTrfActivite(this.famillesProduitsAchats.getFamachActivite());
                  } else if (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty()) {
                     var1 = this.famillesProduitsAchats.getFamachActivite().split(":");
                     this.transfertCompta.setTrfActivite(var1[0]);
                  }
               }
            } else {
               if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && this.famillesProduitsAchats.getFamachCle1() != null && !this.famillesProduitsAchats.getFamachCle1().isEmpty() && this.famillesProduitsAchats.getFamachCle1().contains(":")) {
                  var1 = this.famillesProduitsAchats.getFamachCle1().split(":");
                  this.transfertCompta.setTrfRepartitionCle1(var1[0]);
               }

               if ((this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty()) && this.famillesProduitsAchats.getFamachCle2() != null && !this.famillesProduitsAchats.getFamachCle2().isEmpty() && this.famillesProduitsAchats.getFamachCle2().contains(":")) {
                  var1 = this.famillesProduitsAchats.getFamachCle2().split(":");
                  this.transfertCompta.setTrfRepartitionCle2(var1[0]);
               }
            }
         }
      }

      this.transfertCompta.setTrfDossier(this.factureEnteteAchats.getFcfAnal4());
      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.noteDebitEnteteAchats.getNdfActivite() != null && !this.noteDebitEnteteAchats.getNdfActivite().isEmpty() && this.noteDebitEnteteAchats.getNdfActivite().contains(":") && this.noteDebitEnteteAchats.getNdfActivite().length() >= 3) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.noteDebitEnteteAchats.getNdfActivite());
            } else {
               var1 = this.noteDebitEnteteAchats.getNdfActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         } else {
            this.transfertCompta.setTrfActivite(this.noteDebitEnteteAchats.getNdfActivite());
         }

         if (this.noteDebitEnteteAchats.getNdfSite() != null && !this.noteDebitEnteteAchats.getNdfSite().isEmpty() && this.noteDebitEnteteAchats.getNdfSite().contains(":") && this.noteDebitEnteteAchats.getNdfSite().length() >= 3) {
            var1 = this.noteDebitEnteteAchats.getNdfSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.noteDebitEnteteAchats.getNdfSite());
         }

         if (this.noteDebitEnteteAchats.getNdfDepartement() != null && !this.noteDebitEnteteAchats.getNdfDepartement().isEmpty() && this.noteDebitEnteteAchats.getNdfDepartement().contains(":") && this.noteDebitEnteteAchats.getNdfDepartement().length() >= 3) {
            var1 = this.noteDebitEnteteAchats.getNdfDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.noteDebitEnteteAchats.getNdfDepartement());
         }

         if (this.noteDebitEnteteAchats.getNdfService() != null && !this.noteDebitEnteteAchats.getNdfService().isEmpty() && this.noteDebitEnteteAchats.getNdfService().contains(":") && this.noteDebitEnteteAchats.getNdfService().length() >= 3) {
            var1 = this.noteDebitEnteteAchats.getNdfService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.noteDebitEnteteAchats.getNdfService());
         }

         if (this.noteDebitEnteteAchats.getNdfRegion() != null && !this.noteDebitEnteteAchats.getNdfRegion().isEmpty() && this.noteDebitEnteteAchats.getNdfRegion().contains(":") && this.noteDebitEnteteAchats.getNdfRegion().length() >= 3) {
            var1 = this.noteDebitEnteteAchats.getNdfRegion().split(":");
            this.transfertCompta.setTrfRegion(var1[0]);
         } else {
            this.transfertCompta.setTrfRegion(this.noteDebitEnteteAchats.getNdfRegion());
         }

         if (this.noteDebitEnteteAchats.getNdfSecteur() != null && !this.noteDebitEnteteAchats.getNdfSecteur().isEmpty() && this.noteDebitEnteteAchats.getNdfSecteur().contains(":") && this.noteDebitEnteteAchats.getNdfSecteur().length() >= 3) {
            var1 = this.noteDebitEnteteAchats.getNdfSecteur().split(":");
            this.transfertCompta.setTrfSecteur(var1[0]);
         } else {
            this.transfertCompta.setTrfSecteur(this.noteDebitEnteteAchats.getNdfSecteur());
         }

         if (this.noteDebitEnteteAchats.getNdfAnal2() != null && !this.noteDebitEnteteAchats.getNdfAnal2().isEmpty() && this.noteDebitEnteteAchats.getNdfAnal2().contains(":") && this.noteDebitEnteteAchats.getNdfAnal2().length() >= 3) {
            var1 = this.noteDebitEnteteAchats.getNdfAnal2().split(":");
            this.transfertCompta.setTrfParc(var1[0]);
         } else {
            this.transfertCompta.setTrfParc(this.noteDebitEnteteAchats.getNdfAnal2());
         }

         if (this.noteDebitEnteteAchats.getNdfBudget() != null && !this.noteDebitEnteteAchats.getNdfBudget().isEmpty() && this.noteDebitEnteteAchats.getNdfBudget().contains(":") && this.noteDebitEnteteAchats.getNdfBudget().length() >= 3) {
            var1 = this.noteDebitEnteteAchats.getNdfBudget().split(":");
            this.transfertCompta.setTrfBudget(var1[0]);
         } else {
            this.transfertCompta.setTrfBudget(this.noteDebitEnteteAchats.getNdfBudget());
         }

         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
      }

   }

   public void traitementFraisAchat(DocumentEntete var1, Session var2) throws HibernateException, NamingException {
      this.fraisEnteteAchats = this.fraisEnteteAchatsDao.pourParapheur(var1.getDocId(), var2);
      if (this.fraisEnteteAchats != null) {
         String var3 = "" + (this.fraisEnteteAchats.getFsfDate().getYear() + 1900);
         String var4 = this.formTransfertCtrl.calculeJournalSerie(18, this.fraisEnteteAchats.getFsfSerie(), var3, var2);
         if (var4 != null && !var4.isEmpty() && this.fraisEnteteAchats.getTiers().getTietransfertCpte() == 0) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("18");
            if (this.fraisEnteteAchats.getFsfCat() != null && !this.fraisEnteteAchats.getFsfCat().isEmpty()) {
               if (this.fraisEnteteAchats.getFsfCat().equalsIgnoreCase("import")) {
                  this.transfertCompta.setTrfCategorie(1);
               } else {
                  this.transfertCompta.setTrfCategorie(0);
               }
            } else {
               this.transfertCompta.setTrfCategorie(0);
            }

            this.transfertCompta.setTrfNature(18);
            this.transfertCompta.setTrfIdOrigine(this.fraisEnteteAchats.getFsfId());
            this.transfertCompta.setTrfAgent(this.fraisEnteteAchats.getFsfNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.fraisEnteteAchats.getFsfDate());
            this.transfertCompta.setTrfCode(var4);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.fraisEnteteAchats.getFsfDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.fraisEnteteAchats.getFsfDate()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.fraisEnteteAchats.getTiers().getTieid(), var2));
            this.transfertCompta.setTrfDebitSaisie(0.0D);
            this.transfertCompta.setTrfCreditSaisie(this.fraisEnteteAchats.getFsfTotTtc());
            this.transfertCompta.setTrfDateEcheance(this.fraisEnteteAchats.getFsfDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneFraisAchats("", this.fraisEnteteAchats.getFsfObject());
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            ArrayList var5 = new ArrayList();
            new ArrayList();
            List var6 = this.fraisLigneAchatsDao.chargerLesLignes(this.fraisEnteteAchats, var2);
            int var7;
            String var8;
            if (var6.size() != 0) {
               for(var7 = 0; var7 < var6.size(); ++var7) {
                  this.fraisLigneAchats = new FraisLigneAchats();
                  this.fraisLigneAchats = (FraisLigneAchats)var6.get(var7);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("18");
                  if (this.fraisEnteteAchats.getFsfCat() != null && !this.fraisEnteteAchats.getFsfCat().isEmpty()) {
                     if (this.fraisEnteteAchats.getFsfCat().equalsIgnoreCase("import")) {
                        this.transfertCompta.setTrfCategorie(1);
                     } else {
                        this.transfertCompta.setTrfCategorie(0);
                     }
                  } else {
                     this.transfertCompta.setTrfCategorie(0);
                  }

                  this.transfertCompta.setTrfNature(18);
                  this.transfertCompta.setTrfIdOrigine(this.fraisEnteteAchats.getFsfId());
                  this.transfertCompta.setTrfAgent(this.fraisEnteteAchats.getFsfNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.fraisEnteteAchats.getFsfDate());
                  this.transfertCompta.setTrfCode(var4);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.fraisEnteteAchats.getFsfDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.fraisEnteteAchats.getFsfDate()));
                  var8 = this.formTransfertCtrl.calculeCompteProduitAchats(this.optionAchats, this.fraisLigneAchats.getFsfligCode(), this.fraisEnteteAchats.getTiers().getTiecodepays(), this.fraisEnteteAchats.getExercicesAchats().getExeachId(), this.fraisEnteteAchats.getFsfAnal4(), this.listPays, var2);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var8);
                  this.transfertCompta.setTrfDebitSaisie(this.fraisLigneAchats.getFsfligPt());
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  if (this.fraisLigneAchats.getFsfligNunFactureFour2() != null && !this.fraisLigneAchats.getFsfligNunFactureFour2().isEmpty()) {
                     this.calculeZoneFraisAchats("", this.fraisLigneAchats.getFsfligNunFactureFour2());
                  } else {
                     this.calculeZoneFraisAchats("", this.fraisEnteteAchats.getFsfObject());
                  }

                  boolean var9 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var2);
                  if (var9 || this.transfertCompta.getTrfCompte().startsWith("38") && this.modeReception == 1) {
                     this.analytiqueFraisAchats();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var10 = new Stock();
                  var10.setStkTva(this.fraisLigneAchats.getFsfligTva());
                  var10.setStkTaxe(this.fraisLigneAchats.getFsfligTaxe());
                  var5.add(var10);
               }
            }

            if (var5.size() != 0) {
               for(var7 = 0; var7 < var5.size(); ++var7) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("18");
                  if (this.fraisEnteteAchats.getFsfCat() != null && !this.fraisEnteteAchats.getFsfCat().isEmpty()) {
                     if (this.fraisEnteteAchats.getFsfCat().equalsIgnoreCase("import")) {
                        this.transfertCompta.setTrfCategorie(1);
                     } else {
                        this.transfertCompta.setTrfCategorie(0);
                     }
                  } else {
                     this.transfertCompta.setTrfCategorie(0);
                  }

                  this.transfertCompta.setTrfNature(18);
                  this.transfertCompta.setTrfIdOrigine(this.fraisEnteteAchats.getFsfId());
                  this.transfertCompta.setTrfAgent(this.fraisEnteteAchats.getFsfNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.fraisEnteteAchats.getFsfDate());
                  this.transfertCompta.setTrfCode(var4);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.fraisEnteteAchats.getFsfDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.fraisEnteteAchats.getFsfDate()));
                  var8 = this.formTransfertCtrl.calculeCompteTvaAchats(((Stock)var5.get(var7)).getStkTaxe(), this.fraisEnteteAchats.getExercicesAchats().getExeachId(), var2);
                  this.transfertCompta.setTrfCompte(var8);
                  this.transfertCompta.setTrfDebitSaisie(((Stock)var5.get(var7)).getStkTva());
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  if (this.fraisLigneAchats.getFsfligNunFactureFour2() != null && !this.fraisLigneAchats.getFsfligNunFactureFour2().isEmpty()) {
                     this.calculeZoneFraisAchats("", this.fraisLigneAchats.getFsfligNunFactureFour2());
                  } else {
                     this.calculeZoneFraisAchats("", this.fraisEnteteAchats.getFsfObject());
                  }

                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneFraisAchats(String var1, String var2) {
      if (this.optionAchats.getZoneRef1().equals("0")) {
         if (this.optionAchats.getZoneRef1Serie().equals("0")) {
            if (this.optionAchats.getZoneRef1Serie().equals("0")) {
               this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfSerie() + ":" + this.fraisEnteteAchats.getFsfNum() + "(FRS)");
            } else if (this.optionAchats.getZoneRef1Serie().equals("1")) {
               this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfNum() + "(FRS)");
            }
         } else if (this.optionAchats.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfNum() + "(FRS)");
         }
      } else if (this.optionAchats.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1(var1);
      } else if (this.optionAchats.getZoneRef1().equals("2")) {
         this.transfertCompta.setTrfReference1(var2);
      } else if (this.optionAchats.getZoneRef1().equals("3")) {
         this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfAnal4());
      } else if (this.optionAchats.getZoneRef1().equals("11")) {
         this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfInfo1());
      } else if (this.optionAchats.getZoneRef1().equals("12")) {
         this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfInfo2());
      } else if (this.optionAchats.getZoneRef1().equals("13")) {
         this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfInfo3());
      } else if (this.optionAchats.getZoneRef1().equals("14")) {
         this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfInfo4());
      } else if (this.optionAchats.getZoneRef1().equals("15")) {
         this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfInfo5());
      } else if (this.optionAchats.getZoneRef1().equals("16")) {
         this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfInfo6());
      } else if (this.optionAchats.getZoneRef1().equals("17")) {
         this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfInfo7());
      } else if (this.optionAchats.getZoneRef1().equals("18")) {
         this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfInfo8());
      } else if (this.optionAchats.getZoneRef1().equals("19")) {
         this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfInfo9());
      } else if (this.optionAchats.getZoneRef1().equals("20")) {
         this.transfertCompta.setTrfReference1(this.fraisEnteteAchats.getFsfInfo10());
      }

      if (this.optionAchats.getZoneRef2().equals("0")) {
         if (this.optionAchats.getZoneRef2Serie().equals("0")) {
            if (this.optionAchats.getZoneRef2Serie().equals("0")) {
               this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfSerie() + ":" + this.fraisEnteteAchats.getFsfNum());
            } else if (this.optionAchats.getZoneRef2Serie().equals("1")) {
               this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfNum());
            }
         } else if (this.optionAchats.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfNum());
         }
      } else if (this.optionAchats.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2(var1);
      } else if (this.optionAchats.getZoneRef2().equals("2")) {
         this.transfertCompta.setTrfReference2(var2);
      } else if (this.optionAchats.getZoneRef2().equals("3")) {
         this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfAnal4());
      } else if (this.optionAchats.getZoneRef2().equals("11")) {
         this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfInfo1());
      } else if (this.optionAchats.getZoneRef2().equals("12")) {
         this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfInfo2());
      } else if (this.optionAchats.getZoneRef2().equals("13")) {
         this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfInfo3());
      } else if (this.optionAchats.getZoneRef2().equals("14")) {
         this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfInfo4());
      } else if (this.optionAchats.getZoneRef2().equals("15")) {
         this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfInfo5());
      } else if (this.optionAchats.getZoneRef2().equals("16")) {
         this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfInfo6());
      } else if (this.optionAchats.getZoneRef2().equals("17")) {
         this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfInfo7());
      } else if (this.optionAchats.getZoneRef2().equals("18")) {
         this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfInfo8());
      } else if (this.optionAchats.getZoneRef2().equals("19")) {
         this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfInfo9());
      } else if (this.optionAchats.getZoneRef2().equals("20")) {
         this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfInfo10());
      }

      if (this.optionAchats.getZoneLibelle().equals("0")) {
         if (this.fraisEnteteAchats.getFsfDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.fraisEnteteAchats.getFsfDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.fraisEnteteAchats.getFsfNomTiers());
         }
      } else if (this.optionAchats.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.fraisEnteteAchats.getFsfObject());
      } else if (this.optionAchats.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.fraisEnteteAchats.getFsfObject() + " date " + this.utilDate.dateToStringFr(this.fraisEnteteAchats.getFsfDate()));
      } else if (this.optionAchats.getZoneLibelle().equals("3")) {
         if (this.fraisEnteteAchats.getFsfDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.fraisEnteteAchats.getFsfDiversNom() + "  Dossier N° " + this.fraisEnteteAchats.getFsfAnal4());
         } else {
            this.transfertCompta.setTrfLibelle(this.fraisEnteteAchats.getFsfNomTiers() + "  Dossier N° " + this.fraisEnteteAchats.getFsfAnal4());
         }
      }

      if (this.optionAchats.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.fraisEnteteAchats.getFsfObject());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("11")) {
         this.transfertCompta.setTrfSuite(this.fraisEnteteAchats.getFsfInfo1());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("12")) {
         this.transfertCompta.setTrfSuite(this.fraisEnteteAchats.getFsfInfo2());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("13")) {
         this.transfertCompta.setTrfSuite(this.fraisEnteteAchats.getFsfInfo3());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("14")) {
         this.transfertCompta.setTrfSuite(this.fraisEnteteAchats.getFsfInfo4());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("15")) {
         this.transfertCompta.setTrfSuite(this.fraisEnteteAchats.getFsfInfo5());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("16")) {
         this.transfertCompta.setTrfSuite(this.fraisEnteteAchats.getFsfInfo6());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("17")) {
         this.transfertCompta.setTrfSuite(this.fraisEnteteAchats.getFsfInfo7());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("18")) {
         this.transfertCompta.setTrfSuite(this.fraisEnteteAchats.getFsfInfo8());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("19")) {
         this.transfertCompta.setTrfSuite(this.fraisEnteteAchats.getFsfInfo9());
      } else if (this.optionAchats.getZoneLibelleSuite().equals("20")) {
         this.transfertCompta.setTrfSuite(this.fraisEnteteAchats.getFsfInfo10());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueFraisAchats() {
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.produits != null) {
         if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":") || this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
            if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":")) {
               var1 = this.produits.getProCle1().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
               var1 = this.produits.getProCle2().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         } else if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.produits.getProActivite());
            } else {
               var1 = this.produits.getProActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         }

         if (this.famillesProduitsAchats != null) {
            if ((this.famillesProduitsAchats.getFamachCle1() == null || this.famillesProduitsAchats.getFamachCle1().isEmpty() || !this.famillesProduitsAchats.getFamachCle1().contains(":")) && (this.famillesProduitsAchats.getFamachCle2() == null || this.famillesProduitsAchats.getFamachCle2().isEmpty() || !this.famillesProduitsAchats.getFamachCle2().contains(":"))) {
               if (this.famillesProduitsAchats.getFamachActivite() != null && !this.famillesProduitsAchats.getFamachActivite().isEmpty() && this.famillesProduitsAchats.getFamachActivite().contains(":")) {
                  if (this.decoupageActivite) {
                     this.transfertCompta.setTrfActivite(this.famillesProduitsAchats.getFamachActivite());
                  } else if (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty()) {
                     var1 = this.famillesProduitsAchats.getFamachActivite().split(":");
                     this.transfertCompta.setTrfActivite(var1[0]);
                  }
               }
            } else {
               if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && this.famillesProduitsAchats.getFamachCle1() != null && !this.famillesProduitsAchats.getFamachCle1().isEmpty() && this.famillesProduitsAchats.getFamachCle1().contains(":")) {
                  var1 = this.famillesProduitsAchats.getFamachCle1().split(":");
                  this.transfertCompta.setTrfRepartitionCle1(var1[0]);
               }

               if ((this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty()) && this.famillesProduitsAchats.getFamachCle2() != null && !this.famillesProduitsAchats.getFamachCle2().isEmpty() && this.famillesProduitsAchats.getFamachCle2().contains(":")) {
                  var1 = this.famillesProduitsAchats.getFamachCle2().split(":");
                  this.transfertCompta.setTrfRepartitionCle2(var1[0]);
               }
            }
         }
      }

      this.transfertCompta.setTrfDossier(this.fraisEnteteAchats.getFsfAnal4());
      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.fraisEnteteAchats.getFsfActivite() != null && !this.fraisEnteteAchats.getFsfActivite().isEmpty() && this.fraisEnteteAchats.getFsfActivite().contains(":") && this.fraisEnteteAchats.getFsfActivite().length() >= 3) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.fraisEnteteAchats.getFsfActivite());
            } else {
               var1 = this.fraisEnteteAchats.getFsfActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         } else {
            this.transfertCompta.setTrfActivite(this.fraisEnteteAchats.getFsfActivite());
         }

         if (this.fraisEnteteAchats.getFsfSite() != null && !this.fraisEnteteAchats.getFsfSite().isEmpty() && this.fraisEnteteAchats.getFsfSite().contains(":") && this.fraisEnteteAchats.getFsfSite().length() >= 3) {
            var1 = this.fraisEnteteAchats.getFsfSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.fraisEnteteAchats.getFsfSite());
         }

         if (this.fraisEnteteAchats.getFsfDepartement() != null && !this.fraisEnteteAchats.getFsfDepartement().isEmpty() && this.fraisEnteteAchats.getFsfDepartement().contains(":") && this.fraisEnteteAchats.getFsfDepartement().length() >= 3) {
            var1 = this.fraisEnteteAchats.getFsfDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.fraisEnteteAchats.getFsfDepartement());
         }

         if (this.fraisEnteteAchats.getFsfService() != null && !this.fraisEnteteAchats.getFsfService().isEmpty() && this.fraisEnteteAchats.getFsfService().contains(":") && this.fraisEnteteAchats.getFsfService().length() >= 3) {
            var1 = this.fraisEnteteAchats.getFsfService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.fraisEnteteAchats.getFsfService());
         }

         if (this.fraisEnteteAchats.getFsfRegion() != null && !this.fraisEnteteAchats.getFsfRegion().isEmpty() && this.fraisEnteteAchats.getFsfRegion().contains(":") && this.fraisEnteteAchats.getFsfRegion().length() >= 3) {
            var1 = this.fraisEnteteAchats.getFsfRegion().split(":");
            this.transfertCompta.setTrfRegion(var1[0]);
         } else {
            this.transfertCompta.setTrfRegion(this.fraisEnteteAchats.getFsfRegion());
         }

         if (this.fraisEnteteAchats.getFsfSecteur() != null && !this.fraisEnteteAchats.getFsfSecteur().isEmpty() && this.fraisEnteteAchats.getFsfSecteur().contains(":") && this.fraisEnteteAchats.getFsfSecteur().length() >= 3) {
            var1 = this.fraisEnteteAchats.getFsfSecteur().split(":");
            this.transfertCompta.setTrfSecteur(var1[0]);
         } else {
            this.transfertCompta.setTrfSecteur(this.fraisEnteteAchats.getFsfSecteur());
         }

         if (this.fraisEnteteAchats.getFsfAnal2() != null && !this.fraisEnteteAchats.getFsfAnal2().isEmpty() && this.fraisEnteteAchats.getFsfAnal2().contains(":") && this.fraisEnteteAchats.getFsfAnal2().length() >= 3) {
            var1 = this.fraisEnteteAchats.getFsfAnal2().split(":");
            this.transfertCompta.setTrfParc(var1[0]);
         } else {
            this.transfertCompta.setTrfParc(this.fraisEnteteAchats.getFsfAnal2());
         }

         if (this.fraisEnteteAchats.getFsfBudget() != null && !this.fraisEnteteAchats.getFsfBudget().isEmpty() && this.fraisEnteteAchats.getFsfBudget().contains(":") && this.fraisEnteteAchats.getFsfBudget().length() >= 3) {
            var1 = this.fraisEnteteAchats.getFsfBudget().split(":");
            this.transfertCompta.setTrfBudget(var1[0]);
         } else {
            this.transfertCompta.setTrfBudget(this.fraisEnteteAchats.getFsfBudget());
         }

         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
      }

   }

   public void traitementValorisationAchat(DocumentEntete var1, Session var2) throws HibernateException, NamingException {
      this.valorisationEnteteAchats = this.valorisationEnteteAchatsDao.pourParapheur(var1.getDocId(), var2);
      if (this.valorisationEnteteAchats != null) {
         String var3 = "" + (this.valorisationEnteteAchats.getValDate().getYear() + 1900);
         String var4 = this.formTransfertCtrl.calculeJournalSerie(35, this.valorisationEnteteAchats.getValSerie(), var3, var2);
         if (var4 != null && !var4.isEmpty()) {
            double var5 = 0.0D;
            Object var7 = new ArrayList();
            ArrayList var8 = new ArrayList();
            new ArrayList();
            List var9 = this.fraisEnteteAchatsDao.rechercheByValo(this.valorisationEnteteAchats.getValNum(), var2);
            int var10;
            if (var9.size() != 0) {
               for(var10 = 0; var10 < var9.size(); ++var10) {
                  this.fraisEnteteAchats = new FraisEnteteAchats();
                  this.fraisEnteteAchats = (FraisEnteteAchats)var9.get(var10);
                  var5 += this.fraisEnteteAchats.getFsfTotHt();
                  ((List)var7).clear();
                  var7 = this.fraisLigneAchatsDao.chargerLesLignes(this.fraisEnteteAchats, var2);
                  if (((List)var7).size() != 0) {
                     for(int var11 = 0; var11 < ((List)var7).size(); ++var11) {
                        var8.add(((List)var7).get(var11));
                     }
                  }
               }
            }

            if (var8.size() != 0) {
               for(var10 = 0; var10 < var8.size(); ++var10) {
                  new FraisLigneAchats();
                  FraisLigneAchats var21 = (FraisLigneAchats)var8.get(var10);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("35");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(35);
                  this.transfertCompta.setTrfIdOrigine(this.valorisationEnteteAchats.getValId());
                  this.transfertCompta.setTrfAgent(this.valorisationEnteteAchats.getValNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.valorisationEnteteAchats.getValDate());
                  this.transfertCompta.setTrfCode(var4);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.valorisationEnteteAchats.getValDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.valorisationEnteteAchats.getValDate()));
                  String var12 = this.formTransfertCtrl.calculeCompteProduitAchats(this.optionAchats, var21.getFsfligCode(), var21.getFraisEnteteAchats().getTiers().getTiecodepays(), this.valorisationEnteteAchats.getExercicesAchats().getExeachId(), var21.getFraisEnteteAchats().getFsfAnal4(), this.listPays, var2);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var12);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(var21.getFsfligPt());
                  this.transfertCompta.setTrfLibelle(" Valorisation N° " + this.valorisationEnteteAchats.getValNum());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneValorisationAchats("");
                  boolean var13 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var2);
                  if (var13 || this.transfertCompta.getTrfCompte().startsWith("38") && this.modeReception == 1) {
                     this.analytiqueValorisationAchats();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }

            if (this.valorisationEnteteAchats.getValNature1() != 12 && this.valorisationEnteteAchats.getValNature1() == 13) {
               ReceptionEnteteAchatsDao var20 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               ReceptionLigneAchatsDao var22 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               new ArrayList();
               new ArrayList();
               List var23 = var20.rechercheByValo(this.valorisationEnteteAchats.getValNum(), var2);
               if (var23.size() != 0) {
                  for(int var14 = 0; var14 < var23.size(); ++var14) {
                     new ReceptionEnteteAchats();
                     ReceptionEnteteAchats var15 = (ReceptionEnteteAchats)var23.get(var14);
                     List var24 = var22.chargerLesLignes(var15, var2);
                     if (var24.size() != 0) {
                        for(int var16 = 0; var16 < var24.size(); ++var16) {
                           new ReceptionLigneAchats();
                           ReceptionLigneAchats var17 = (ReceptionLigneAchats)var24.get(var16);
                           if (var17.getRecligPr() != 0.0D) {
                              this.transfertCompta = new TransfertCompta();
                              this.transfertCompta.setTrfTypeOrigine("35");
                              this.transfertCompta.setTrfCategorie(0);
                              this.transfertCompta.setTrfNature(35);
                              this.transfertCompta.setTrfIdOrigine(this.valorisationEnteteAchats.getValId());
                              this.transfertCompta.setTrfAgent(this.valorisationEnteteAchats.getValNomResponsable());
                              this.transfertCompta.setTrfDateSaisie(this.valorisationEnteteAchats.getValDate());
                              this.transfertCompta.setTrfCode(var4);
                              this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.valorisationEnteteAchats.getValDate()));
                              this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.valorisationEnteteAchats.getValDate()));
                              String var18 = this.formTransfertCtrl.calculeCompteProduitAchatsNormal(var17.getRecligCode(), var15.getTiers().getTiecodepays(), this.valorisationEnteteAchats.getExercicesAchats().getExeachId(), "", this.listPays, var2);
                              this.transfertCompta.setTrfCompte(var18);
                              this.transfertCompta.setTrfDebitSaisie(this.utilNombre.myRoundDevise(var17.getRecligPr(), this.structureLog.getStrdevise()));
                              this.transfertCompta.setTrfCreditSaisie(0.0D);
                              this.transfertCompta.setTrfDateEcheance((Date)null);
                              this.transfertCompta.setTrfDateValeurTheo((Date)null);
                              this.transfertCompta.setTrfPiece("");
                              this.calculeZoneValorisationAchats("");
                              boolean var19 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var2);
                              if (var19) {
                                 this.analytiqueValorisationAchats();
                                 if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                                    this.lesTransfertCompta.add(this.transfertCompta);
                                 }
                              } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                                 this.lesTransfertCompta.add(this.transfertCompta);
                              }

                              this.transfertCompta = new TransfertCompta();
                              this.transfertCompta.setTrfTypeOrigine("35");
                              this.transfertCompta.setTrfCategorie(0);
                              this.transfertCompta.setTrfNature(35);
                              this.transfertCompta.setTrfIdOrigine(this.valorisationEnteteAchats.getValId());
                              this.transfertCompta.setTrfAgent(this.valorisationEnteteAchats.getValNomResponsable());
                              this.transfertCompta.setTrfDateSaisie(this.valorisationEnteteAchats.getValDate());
                              this.transfertCompta.setTrfCode(var4);
                              this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var4, this.valorisationEnteteAchats.getValDate()));
                              this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.valorisationEnteteAchats.getValDate()));
                              var18 = this.formTransfertCtrl.calculeCompteProduitAchats(this.optionAchats, var17.getRecligCode(), var15.getTiers().getTiecodepays(), this.valorisationEnteteAchats.getExercicesAchats().getExeachId(), "", this.listPays, var2);
                              this.transfertCompta.setTrfCompte(var18);
                              this.transfertCompta.setTrfDebitSaisie(0.0D);
                              this.transfertCompta.setTrfCreditSaisie(var17.getRecligPt());
                              this.transfertCompta.setTrfDateEcheance((Date)null);
                              this.transfertCompta.setTrfDateValeurTheo((Date)null);
                              this.transfertCompta.setTrfPiece("");
                              this.calculeZoneValorisationAchats("");
                              var19 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var2);
                              if (var19) {
                                 this.analytiqueValorisationAchats();
                                 if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                                    this.lesTransfertCompta.add(this.transfertCompta);
                                 }
                              } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                                 this.lesTransfertCompta.add(this.transfertCompta);
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

   public void calculeZoneValorisationAchats(String var1) {
      if (!this.optionAchats.getZoneRef1().equals("") && !this.optionAchats.getZoneRef1().equals("0")) {
         if (this.optionAchats.getZoneRef1().equals("1")) {
            this.transfertCompta.setTrfReference1("");
         } else if (this.optionAchats.getZoneRef1().equals("2")) {
            this.transfertCompta.setTrfReference1("");
         } else if (this.optionAchats.getZoneRef1().equals("3")) {
            this.transfertCompta.setTrfReference1(this.valorisationEnteteAchats.getValDossierTransit());
         }
      } else if (this.optionAchats.getZoneRef1Serie().equals("0")) {
         this.transfertCompta.setTrfReference1(this.valorisationEnteteAchats.getValSerie() + ":" + this.valorisationEnteteAchats.getValNum());
      } else if (this.optionAchats.getZoneRef1Serie().equals("1")) {
         this.transfertCompta.setTrfReference1(this.valorisationEnteteAchats.getValNum());
      }

      if (!this.optionAchats.getZoneRef2().equals("") && !this.optionAchats.getZoneRef2().equals("0")) {
         if (this.optionAchats.getZoneRef2().equals("1")) {
            this.transfertCompta.setTrfReference2("");
         } else if (this.optionAchats.getZoneRef2().equals("2")) {
            this.transfertCompta.setTrfReference2("");
         } else if (this.optionAchats.getZoneRef2().equals("3")) {
            this.transfertCompta.setTrfReference2(this.valorisationEnteteAchats.getValDossierTransit());
         }
      } else if (this.optionAchats.getZoneRef2Serie().equals("0")) {
         this.transfertCompta.setTrfReference2(this.valorisationEnteteAchats.getValSerie() + ":" + this.valorisationEnteteAchats.getValNum());
      } else if (this.optionAchats.getZoneRef2Serie().equals("1")) {
         this.transfertCompta.setTrfReference2(this.valorisationEnteteAchats.getValNum());
      }

      if (!this.optionAchats.getZoneLibelle().equals("") && !this.optionAchats.getZoneLibelle().equals("0")) {
         if (this.optionAchats.getZoneLibelle().equals("1")) {
            this.transfertCompta.setTrfLibelle(this.valorisationEnteteAchats.getValNum());
         } else if (this.optionAchats.getZoneLibelle().equals("2")) {
            this.transfertCompta.setTrfLibelle(this.valorisationEnteteAchats.getValNum() + " date " + this.utilDate.dateToStringFr(this.valorisationEnteteAchats.getValDate()));
         }
      } else {
         this.transfertCompta.setTrfLibelle(this.valorisationEnteteAchats.getValNum());
      }

      if (this.valorisationEnteteAchats.getValFictif() == 2) {
         this.transfertCompta.setTrfSuite("Calul Provisoire");
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueValorisationAchats() {
      this.transfertCompta.setTrfDossier(this.valorisationEnteteAchats.getValDossierTransit());
   }

   public void transfertVentes(List var1) throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      this.init();
      this.listeDocumentTransfert = var1;
      this.objetPays = new ObjetPays();
      this.lecturePays = new LecturePays();
      this.listPays = this.lecturePays.getMespays();
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.produits = new Produits();
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentes = new TaxesVentes();
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentes = new FamillesProduitsVentes();
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.documentTraceVentes = new DocumentTraceVentes();
      this.documentTraceVentesDao = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
      this.ticketEnteteVentes = new TicketEnteteVentes();
      this.ticketEnteteVentesDao = new TicketEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.ticketLigneVentes = new TicketLigneVentes();
      this.ticketLigneVentesDao = new TicketLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteVentes = new CommandeEnteteVentes();
      this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeLigneVentes = new CommandeLigneVentes();
      this.commandeLigneVentesDao = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonEnteteVentes = new LivraisonEnteteVentes();
      this.livraisonEnteteVentesDao = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonLigneVentes = new LivraisonLigneVentes();
      this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentes = new FactureEnteteVentes();
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneVentes = new FactureLigneVentes();
      this.factureLigneVentesDao = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureInterneEnteteVentes = new FactureInterneEnteteVentes();
      this.factureInterneEnteteVentesDao = new FactureInterneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureInterneLigneVentes = new FactureInterneLigneVentes();
      this.factureInterneLigneVentesDao = new FactureInterneLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteVentes = new AvoirEnteteVentes();
      this.avoirEnteteVentesDao = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirLigneVentes = new AvoirLigneVentes();
      this.avoirLigneVentesDao = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitLigneVentes = new NoteDebitLigneVentes();
      this.noteDebitLigneVentesDao = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.lesTransfertCompta.clear();
      this.lesTransfertErreur.clear();
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      this.optionVentes = var2.lancer();
      if (this.optionVentes.getDecrmtPrsChrStock() == null) {
         this.optionVentes.setDecrmtPrsChrStock("");
      }

      String var3 = "";
      new ArrayList();
      List var4 = this.taxesVentesDao.selectActifTaxes(0L, (Session)null);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            if (((TaxesVentes)var4.get(var5)).getTaxvteTc() != 0 && ((TaxesVentes)var4.get(var5)).getTaxvteCompte() != null && !((TaxesVentes)var4.get(var5)).getTaxvteCompte().isEmpty()) {
               var3 = ((TaxesVentes)var4.get(var5)).getTaxvteCompte();
               break;
            }
         }
      }

      if (this.listeDocumentTransfert.size() != 0) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         this.documentEntete = new DocumentEntete();

         for(int var6 = 0; var6 < this.listeDocumentTransfert.size(); ++var6) {
            this.documentEntete = (DocumentEntete)this.listeDocumentTransfert.get(var6);
            if (this.documentEntete.isDocSelect()) {
               if (this.documentEntete.getDocNature() == 6) {
                  this.traitementTicketVentes(this.documentEntete, var3, var7);
               } else if (this.documentEntete.getDocNature() == 22) {
                  this.traitementCommandeVentes(this.documentEntete, var3, var7);
               } else if (this.documentEntete.getDocNature() == 23) {
                  this.traitementLivraisonVentes(this.documentEntete, var3, var7);
               } else if (this.documentEntete.getDocNature() == 25) {
                  this.traitementFactureVentes(this.documentEntete, var3, var7);
               } else if (this.documentEntete.getDocNature() == 26) {
                  this.traitementAvoirVentes(this.documentEntete, var3, var7);
               } else if (this.documentEntete.getDocNature() == 27) {
                  this.traitementNoteDebitVentes(this.documentEntete, var3, var7);
               } else if (this.documentEntete.getDocNature() == 142) {
                  this.traitementFactureInterneVentes(this.documentEntete, var3, var7);
               }
            }
         }

         this.utilInitHibernate.closeSession();
         this.optimisationResultat(this.optionComptabilite.getTrf_cpteVentes());
      }

      this.var_showBarProg = false;
   }

   public void traitementTicketVentes(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.ticketEnteteVentes = this.ticketEnteteVentesDao.pourParapheur(var1.getDocId(), var3);
      if (this.ticketEnteteVentes != null) {
         String var4 = "" + (this.ticketEnteteVentes.getTicDate().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(6, "", var4, var3);
         if (var5 != null && !var5.isEmpty() && this.ticketEnteteVentes.getTiers().getTietransfertCpte() == 0) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("6");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(6);
            this.transfertCompta.setTrfIdOrigine(this.ticketEnteteVentes.getTicId());
            this.transfertCompta.setTrfAgent(this.ticketEnteteVentes.getTicNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.ticketEnteteVentes.getTicDate());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.ticketEnteteVentes.getTicDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.ticketEnteteVentes.getTicDate()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.ticketEnteteVentes.getTiers().getTieid(), var3));
            this.transfertCompta.setTrfDebitSaisie(this.ticketEnteteVentes.getTicTotalTtc() + this.ticketEnteteVentes.getTicTotalTc());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfLibelle(this.ticketEnteteVentes.getTicNomTiers() + " Ticket N° " + this.ticketEnteteVentes.getTicNum());
            this.transfertCompta.setTrfDateEcheance(this.ticketEnteteVentes.getTicDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.transfertCompta.setTrfReference1(this.ticketEnteteVentes.getTicNum());
            this.transfertCompta.setTrfReference2("");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            if (this.ticketEnteteVentes.getTicTotalTc() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("6");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(6);
               this.transfertCompta.setTrfIdOrigine(this.ticketEnteteVentes.getTicId());
               this.transfertCompta.setTrfAgent(this.ticketEnteteVentes.getTicNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.ticketEnteteVentes.getTicDate());
               this.transfertCompta.setTrfCode(var5);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.ticketEnteteVentes.getTicDate()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.ticketEnteteVentes.getTicDate()));
               this.transfertCompta.setTrfCompte(var2);
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.ticketEnteteVentes.getTicTotalTc());
               this.transfertCompta.setTrfLibelle(this.ticketEnteteVentes.getTicNomTiers() + " Ticket N° " + this.ticketEnteteVentes.getTicNum());
               this.transfertCompta.setTrfDateEcheance(this.ticketEnteteVentes.getTicDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.transfertCompta.setTrfReference1(this.ticketEnteteVentes.getTicNum());
               this.transfertCompta.setTrfReference2("");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            ArrayList var6 = new ArrayList();
            new ArrayList();
            List var7 = this.ticketLigneVentesDao.chargerLesLignes(this.ticketEnteteVentes, var3);
            int var8;
            String var9;
            if (var7.size() != 0) {
               for(var8 = 0; var8 < var7.size(); ++var8) {
                  this.ticketLigneVentes = new TicketLigneVentes();
                  this.ticketLigneVentes = (TicketLigneVentes)var7.get(var8);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("6");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(6);
                  this.transfertCompta.setTrfIdOrigine(this.ticketEnteteVentes.getTicId());
                  this.transfertCompta.setTrfAgent(this.ticketEnteteVentes.getTicNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.ticketEnteteVentes.getTicDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.ticketEnteteVentes.getTicDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.ticketEnteteVentes.getTicDate()));
                  var9 = this.formTransfertCtrl.calculeCompteProduitVentes(0, this.ticketEnteteVentes.getTicTotalTva(), this.factureLigneVentes.getFacligCode(), this.ticketEnteteVentes.getTiers().getTiecodepays(), this.ticketEnteteVentes.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var9);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.ticketLigneVentes.getTicligPt());
                  this.transfertCompta.setTrfLibelle(this.ticketEnteteVentes.getTicNomTiers() + " Ticket N° " + this.ticketEnteteVentes.getTicNum());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.transfertCompta.setTrfReference1(this.ticketEnteteVentes.getTicNum());
                  this.transfertCompta.setTrfReference2("");
                  boolean var10 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var3);
                  if (var10) {
                     this.analytiqueTicketVentes();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var11 = new Stock();
                  var11.setStkTva(this.ticketLigneVentes.getTicligTva());
                  var11.setStkTaxe(this.ticketLigneVentes.getTicligTaxe());
                  var6.add(var11);
               }
            }

            if (var6.size() != 0) {
               for(var8 = 0; var8 < var6.size(); ++var8) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("6");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(6);
                  this.transfertCompta.setTrfIdOrigine(this.ticketEnteteVentes.getTicId());
                  this.transfertCompta.setTrfAgent(this.ticketEnteteVentes.getTicNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.ticketEnteteVentes.getTicDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.ticketEnteteVentes.getTicDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.ticketEnteteVentes.getTicDate()));
                  var9 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var6.get(var8)).getStkTaxe(), this.ticketEnteteVentes.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var9);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var6.get(var8)).getStkTva());
                  this.transfertCompta.setTrfLibelle(this.ticketEnteteVentes.getTicNomTiers() + " Ticket N° " + this.ticketEnteteVentes.getTicNum());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.transfertCompta.setTrfReference1(this.ticketEnteteVentes.getTicNum());
                  this.transfertCompta.setTrfReference2("");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void analytiqueTicketVentes() {
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.produits != null) {
         if ((this.produits.getProCle1() == null || this.produits.getProCle1().isEmpty() || !this.produits.getProCle1().contains(":")) && (this.produits.getProCle2() == null || this.produits.getProCle2().isEmpty() || !this.produits.getProCle2().contains(":"))) {
            if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
               var1 = this.produits.getProActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         } else {
            if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":")) {
               var1 = this.produits.getProCle1().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
               var1 = this.produits.getProCle2().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         }

         if (this.famillesProduitsVentes != null) {
            if (this.famillesProduitsVentes.getFamvteCle1() != null && !this.famillesProduitsVentes.getFamvteCle1().isEmpty() && this.famillesProduitsVentes.getFamvteCle1().contains(":") || this.famillesProduitsVentes.getFamvteCle2() != null && !this.famillesProduitsVentes.getFamvteCle2().isEmpty() && this.famillesProduitsVentes.getFamvteCle2().contains(":")) {
               if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && this.famillesProduitsVentes.getFamvteCle1() != null && !this.famillesProduitsVentes.getFamvteCle1().isEmpty() && this.famillesProduitsVentes.getFamvteCle1().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle1().split(":");
                  this.transfertCompta.setTrfRepartitionCle1(var1[0]);
               }

               if ((this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty()) && this.famillesProduitsVentes.getFamvteCle2() != null && !this.famillesProduitsVentes.getFamvteCle2().isEmpty() && this.famillesProduitsVentes.getFamvteCle2().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle2().split(":");
                  this.transfertCompta.setTrfRepartitionCle2(var1[0]);
               }
            } else if (this.famillesProduitsVentes.getFamvteActivite() != null && !this.famillesProduitsVentes.getFamvteActivite().isEmpty() && this.famillesProduitsVentes.getFamvteActivite().contains(":") && (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty())) {
               var1 = this.famillesProduitsVentes.getFamvteActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         }
      }

      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty()) {
            if (this.ticketLigneVentes.getTicligActivite() != null && !this.ticketLigneVentes.getTicligActivite().isEmpty() && this.ticketLigneVentes.getTicligActivite().contains(":") && this.ticketLigneVentes.getTicligActivite().length() >= 3) {
               var1 = this.ticketLigneVentes.getTicligActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            } else {
               this.transfertCompta.setTrfActivite(this.ticketLigneVentes.getTicligActivite());
            }
         }

         if (this.ticketEnteteVentes.getTicSite() != null && !this.ticketEnteteVentes.getTicSite().isEmpty() && this.ticketEnteteVentes.getTicSite().contains(":") && this.ticketEnteteVentes.getTicSite().length() >= 3) {
            var1 = this.ticketEnteteVentes.getTicSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.ticketEnteteVentes.getTicSite());
         }

         if (this.ticketEnteteVentes.getTicDepartement() != null && !this.ticketEnteteVentes.getTicDepartement().isEmpty() && this.ticketEnteteVentes.getTicDepartement().contains(":") && this.ticketEnteteVentes.getTicDepartement().length() >= 3) {
            var1 = this.ticketEnteteVentes.getTicDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.ticketEnteteVentes.getTicDepartement());
         }

         if (this.ticketEnteteVentes.getTicService() != null && !this.ticketEnteteVentes.getTicService().isEmpty() && this.ticketEnteteVentes.getTicService().contains(":") && this.ticketEnteteVentes.getTicService().length() >= 3) {
            var1 = this.ticketEnteteVentes.getTicService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.ticketEnteteVentes.getTicService());
         }

         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfDossier("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfDossier("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
      }

   }

   public void traitementCommandeVentes(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.commandeEnteteVentes = this.commandeEnteteVentesDao.pourParapheur(var1.getDocId(), var3);
      if (this.commandeEnteteVentes != null) {
         String var4 = "" + (this.commandeEnteteVentes.getBcmDate().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(22, this.commandeEnteteVentes.getBcmSerie(), var4, var3);
         String var6 = "";
         String var7 = "";
         if (var5 != null && !var5.isEmpty() && this.commandeEnteteVentes.getTiers().getTietransfertCpte() == 0) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("22");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(22);
            this.transfertCompta.setTrfIdOrigine(this.commandeEnteteVentes.getBcmId());
            this.transfertCompta.setTrfAgent(this.commandeEnteteVentes.getBcmNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.commandeEnteteVentes.getBcmDate());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.commandeEnteteVentes.getBcmDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.commandeEnteteVentes.getBcmDate()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.commandeEnteteVentes.getTiers().getTieid(), var3));
            this.transfertCompta.setTrfDebitSaisie(this.commandeEnteteVentes.getBcmTotTtc() + this.commandeEnteteVentes.getBcmTotTc());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance(this.commandeEnteteVentes.getBcmDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneCommandeVentes(var6, var7, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            if (this.commandeEnteteVentes.getBcmTotTc() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("22");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(22);
               this.transfertCompta.setTrfIdOrigine(this.commandeEnteteVentes.getBcmId());
               this.transfertCompta.setTrfAgent(this.commandeEnteteVentes.getBcmNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.commandeEnteteVentes.getBcmDate());
               this.transfertCompta.setTrfCode(var5);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.commandeEnteteVentes.getBcmDate()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.commandeEnteteVentes.getBcmDate()));
               this.transfertCompta.setTrfCompte(var2);
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.commandeEnteteVentes.getBcmTotTc());
               this.transfertCompta.setTrfDateEcheance(this.commandeEnteteVentes.getBcmDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneCommandeVentes(var6, var7, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            ArrayList var8 = new ArrayList();
            new ArrayList();
            List var9 = this.commandeLigneVentesDao.chargerLesLignes(this.commandeEnteteVentes, var3);
            int var10;
            String var11;
            if (var9.size() != 0) {
               for(var10 = 0; var10 < var9.size(); ++var10) {
                  this.commandeLigneVentes = new CommandeLigneVentes();
                  this.commandeLigneVentes = (CommandeLigneVentes)var9.get(var10);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("22");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(22);
                  this.transfertCompta.setTrfIdOrigine(this.commandeEnteteVentes.getBcmId());
                  this.transfertCompta.setTrfAgent(this.commandeEnteteVentes.getBcmNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.commandeEnteteVentes.getBcmDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.commandeEnteteVentes.getBcmDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.commandeEnteteVentes.getBcmDate()));
                  var11 = this.formTransfertCtrl.calculeCompteProduitVentes(this.commandeEnteteVentes.getBcmExoTva(), this.commandeEnteteVentes.getBcmTotTva(), this.commandeLigneVentes.getBcmligCode(), this.commandeEnteteVentes.getTiers().getTiecodepays(), this.commandeEnteteVentes.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var11);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.commandeLigneVentes.getBcmligPt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneCommandeVentes(var6, var7, this.commandeLigneVentes.getBcmligLibelle());
                  boolean var12 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var3);
                  if (var12) {
                     this.analytiqueFactureVentes();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var13 = new Stock();
                  var13.setStkTva(this.commandeLigneVentes.getBcmligTva());
                  var13.setStkTaxe(this.commandeLigneVentes.getBcmligTaxe());
                  var8.add(var13);
               }
            }

            if (var8.size() != 0) {
               for(var10 = 0; var10 < var8.size(); ++var10) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("22");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(22);
                  this.transfertCompta.setTrfIdOrigine(this.commandeEnteteVentes.getBcmId());
                  this.transfertCompta.setTrfAgent(this.commandeEnteteVentes.getBcmNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.commandeEnteteVentes.getBcmDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.commandeEnteteVentes.getBcmDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.commandeEnteteVentes.getBcmDate()));
                  var11 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var8.get(var10)).getStkTaxe(), this.commandeEnteteVentes.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var11);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var8.get(var10)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneCommandeVentes(var6, var7, "");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneCommandeVentes(String var1, String var2, String var3) {
      if (this.optionVentes.getZoneRef1().equals("0")) {
         if (this.optionVentes.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmSerie() + ":" + this.commandeEnteteVentes.getBcmNum());
         } else if (this.optionVentes.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmNum());
         }
      } else if (this.optionVentes.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1(var1);
      } else if (this.optionVentes.getZoneRef1().equals("2")) {
         this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmAnal4());
      } else if (this.optionVentes.getZoneRef1().equals("11")) {
         this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmInfo1());
      } else if (this.optionVentes.getZoneRef1().equals("12")) {
         this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmInfo2());
      } else if (this.optionVentes.getZoneRef1().equals("13")) {
         this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmInfo3());
      } else if (this.optionVentes.getZoneRef1().equals("14")) {
         this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmInfo4());
      } else if (this.optionVentes.getZoneRef1().equals("15")) {
         this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmInfo5());
      } else if (this.optionVentes.getZoneRef1().equals("16")) {
         this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmInfo6());
      } else if (this.optionVentes.getZoneRef1().equals("17")) {
         this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmInfo7());
      } else if (this.optionVentes.getZoneRef1().equals("18")) {
         this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmInfo8());
      } else if (this.optionVentes.getZoneRef1().equals("19")) {
         this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmInfo9());
      } else if (this.optionVentes.getZoneRef1().equals("20")) {
         this.transfertCompta.setTrfReference1(this.commandeEnteteVentes.getBcmInfo10());
      }

      if (this.optionVentes.getZoneRef2().equals("0")) {
         if (this.optionVentes.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmSerie() + ":" + this.commandeEnteteVentes.getBcmNum());
         } else if (this.optionVentes.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmNum());
         }
      } else if (this.optionVentes.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2(var1);
      } else if (this.optionVentes.getZoneRef2().equals("2")) {
         this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmAnal4());
      } else if (this.optionVentes.getZoneRef2().equals("3")) {
         this.transfertCompta.setTrfReference2(var2);
      } else if (this.optionVentes.getZoneRef2().equals("11")) {
         this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmInfo1());
      } else if (this.optionVentes.getZoneRef2().equals("12")) {
         this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmInfo2());
      } else if (this.optionVentes.getZoneRef2().equals("13")) {
         this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmInfo3());
      } else if (this.optionVentes.getZoneRef2().equals("14")) {
         this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmInfo4());
      } else if (this.optionVentes.getZoneRef2().equals("15")) {
         this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmInfo5());
      } else if (this.optionVentes.getZoneRef2().equals("16")) {
         this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmInfo6());
      } else if (this.optionVentes.getZoneRef2().equals("17")) {
         this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmInfo7());
      } else if (this.optionVentes.getZoneRef2().equals("18")) {
         this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmInfo8());
      } else if (this.optionVentes.getZoneRef2().equals("19")) {
         this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmInfo9());
      } else if (this.optionVentes.getZoneRef2().equals("20")) {
         this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmInfo10());
      }

      if (this.optionVentes.getZoneLibelle().equals("0")) {
         if (this.commandeEnteteVentes.getBcmDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.commandeEnteteVentes.getBcmDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.commandeEnteteVentes.getBcmNomTiers());
         }
      } else if (this.optionVentes.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.commandeEnteteVentes.getBcmObject());
      } else if (this.optionVentes.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.commandeEnteteVentes.getBcmObject() + " date " + this.utilDate.dateToStringFr(this.commandeEnteteVentes.getBcmDate()));
      } else if (this.optionVentes.getZoneLibelle().equals("3")) {
         if (var3 != null && !var3.isEmpty()) {
            if (this.commandeEnteteVentes.getBcmDiversTiers() == 99) {
               this.transfertCompta.setTrfLibelle(var3 + " " + this.commandeEnteteVentes.getBcmDiversNom());
            } else {
               this.transfertCompta.setTrfLibelle(var3 + " " + this.commandeEnteteVentes.getBcmNomTiers());
            }
         } else if (this.commandeEnteteVentes.getBcmDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.commandeEnteteVentes.getBcmDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.commandeEnteteVentes.getBcmNomTiers());
         }
      }

      if (this.optionVentes.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.commandeEnteteVentes.getBcmObject());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("11")) {
         this.transfertCompta.setTrfSuite(this.commandeEnteteVentes.getBcmInfo1());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("12")) {
         this.transfertCompta.setTrfSuite(this.commandeEnteteVentes.getBcmInfo2());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("13")) {
         this.transfertCompta.setTrfSuite(this.commandeEnteteVentes.getBcmInfo3());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("14")) {
         this.transfertCompta.setTrfSuite(this.commandeEnteteVentes.getBcmInfo4());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("15")) {
         this.transfertCompta.setTrfSuite(this.commandeEnteteVentes.getBcmInfo5());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("16")) {
         this.transfertCompta.setTrfSuite(this.commandeEnteteVentes.getBcmInfo6());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("17")) {
         this.transfertCompta.setTrfSuite(this.commandeEnteteVentes.getBcmInfo7());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("18")) {
         this.transfertCompta.setTrfSuite(this.commandeEnteteVentes.getBcmInfo8());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("19")) {
         this.transfertCompta.setTrfSuite(this.commandeEnteteVentes.getBcmInfo9());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("20")) {
         this.transfertCompta.setTrfSuite(this.commandeEnteteVentes.getBcmInfo10());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueCommandeVentes() {
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.produits != null) {
         if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":") || this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
            if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":")) {
               var1 = this.produits.getProCle1().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
               var1 = this.produits.getProCle2().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         } else if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.produits.getProActivite());
            } else {
               var1 = this.produits.getProActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         }

         if (this.famillesProduitsVentes != null) {
            if ((this.famillesProduitsVentes.getFamvteCle1() == null || this.famillesProduitsVentes.getFamvteCle1().isEmpty() || !this.famillesProduitsVentes.getFamvteCle1().contains(":")) && (this.famillesProduitsVentes.getFamvteCle2() == null || this.famillesProduitsVentes.getFamvteCle2().isEmpty() || !this.famillesProduitsVentes.getFamvteCle2().contains(":"))) {
               if (this.famillesProduitsVentes.getFamvteActivite() != null && !this.famillesProduitsVentes.getFamvteActivite().isEmpty() && this.famillesProduitsVentes.getFamvteActivite().contains(":") && (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty())) {
                  if (this.decoupageActivite) {
                     this.transfertCompta.setTrfActivite(this.famillesProduitsVentes.getFamvteActivite());
                  } else {
                     var1 = this.famillesProduitsVentes.getFamvteActivite().split(":");
                     this.transfertCompta.setTrfActivite(var1[0]);
                  }
               }
            } else {
               if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && this.famillesProduitsVentes.getFamvteCle1() != null && !this.famillesProduitsVentes.getFamvteCle1().isEmpty() && this.famillesProduitsVentes.getFamvteCle1().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle1().split(":");
                  this.transfertCompta.setTrfRepartitionCle1(var1[0]);
               }

               if ((this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty()) && this.famillesProduitsVentes.getFamvteCle2() != null && !this.famillesProduitsVentes.getFamvteCle2().isEmpty() && this.famillesProduitsVentes.getFamvteCle2().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle2().split(":");
                  this.transfertCompta.setTrfRepartitionCle2(var1[0]);
               }
            }
         }
      }

      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty()) {
            if (this.commandeEnteteVentes.getBcmActivite() != null && !this.commandeEnteteVentes.getBcmActivite().isEmpty() && this.commandeEnteteVentes.getBcmActivite().contains(":") && this.commandeEnteteVentes.getBcmActivite().length() >= 3) {
               if (this.decoupageActivite) {
                  this.transfertCompta.setTrfActivite(this.commandeEnteteVentes.getBcmActivite());
               } else {
                  var1 = this.commandeEnteteVentes.getBcmActivite().split(":");
                  this.transfertCompta.setTrfActivite(var1[0]);
               }
            } else {
               this.transfertCompta.setTrfActivite(this.commandeEnteteVentes.getBcmActivite());
            }
         }

         if (this.commandeEnteteVentes.getBcmSite() != null && !this.commandeEnteteVentes.getBcmSite().isEmpty() && this.commandeEnteteVentes.getBcmSite().contains(":") && this.commandeEnteteVentes.getBcmSite().length() >= 3) {
            var1 = this.commandeEnteteVentes.getBcmSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.commandeEnteteVentes.getBcmSite());
         }

         if (this.commandeEnteteVentes.getBcmDepartement() != null && !this.commandeEnteteVentes.getBcmDepartement().isEmpty() && this.commandeEnteteVentes.getBcmDepartement().contains(":") && this.commandeEnteteVentes.getBcmDepartement().length() >= 3) {
            var1 = this.commandeEnteteVentes.getBcmDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.commandeEnteteVentes.getBcmDepartement());
         }

         if (this.commandeEnteteVentes.getBcmService() != null && !this.commandeEnteteVentes.getBcmService().isEmpty() && this.commandeEnteteVentes.getBcmService().contains(":") && this.commandeEnteteVentes.getBcmService().length() >= 3) {
            var1 = this.commandeEnteteVentes.getBcmService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.commandeEnteteVentes.getBcmService());
         }

         if (this.commandeEnteteVentes.getBcmRegion() != null && !this.commandeEnteteVentes.getBcmRegion().isEmpty() && this.commandeEnteteVentes.getBcmRegion().contains(":") && this.commandeEnteteVentes.getBcmRegion().length() >= 3) {
            var1 = this.commandeEnteteVentes.getBcmRegion().split(":");
            this.transfertCompta.setTrfRegion(var1[0]);
         } else {
            this.transfertCompta.setTrfRegion(this.commandeEnteteVentes.getBcmRegion());
         }

         if (this.commandeEnteteVentes.getBcmSecteur() != null && !this.commandeEnteteVentes.getBcmSecteur().isEmpty() && this.commandeEnteteVentes.getBcmSecteur().contains(":") && this.commandeEnteteVentes.getBcmSecteur().length() >= 3) {
            var1 = this.commandeEnteteVentes.getBcmSecteur().split(":");
            this.transfertCompta.setTrfSecteur(var1[0]);
         } else {
            this.transfertCompta.setTrfSecteur(this.commandeEnteteVentes.getBcmSecteur());
         }

         if (this.commandeEnteteVentes.getBcmPdv() != null && !this.commandeEnteteVentes.getBcmPdv().isEmpty() && this.commandeEnteteVentes.getBcmPdv().contains(":") && this.commandeEnteteVentes.getBcmPdv().length() >= 3) {
            var1 = this.commandeEnteteVentes.getBcmPdv().split(":");
            this.transfertCompta.setTrfPdv(var1[0]);
         } else {
            this.transfertCompta.setTrfPdv(this.commandeEnteteVentes.getBcmPdv());
         }

         if (this.commandeEnteteVentes.getBcmAnal4() != null && !this.commandeEnteteVentes.getBcmAnal4().isEmpty() && this.commandeEnteteVentes.getBcmAnal4().contains(":") && this.commandeEnteteVentes.getBcmAnal4().length() >= 3) {
            var1 = this.commandeEnteteVentes.getBcmAnal4().split(":");
            this.transfertCompta.setTrfDossier(var1[0]);
         } else {
            this.transfertCompta.setTrfDossier(this.commandeEnteteVentes.getBcmAnal4());
         }

         if (this.commandeEnteteVentes.getBcmAnal2() != null && !this.commandeEnteteVentes.getBcmAnal2().isEmpty() && this.commandeEnteteVentes.getBcmAnal2().contains(":") && this.commandeEnteteVentes.getBcmAnal2().length() >= 3) {
            var1 = this.commandeEnteteVentes.getBcmAnal2().split(":");
            this.transfertCompta.setTrfParc(var1[0]);
         } else {
            this.transfertCompta.setTrfParc(this.commandeEnteteVentes.getBcmAnal2());
         }

         if (this.commandeEnteteVentes.getBcmBudget() != null && !this.commandeEnteteVentes.getBcmBudget().isEmpty() && this.commandeEnteteVentes.getBcmBudget().contains(":") && this.commandeEnteteVentes.getBcmBudget().length() >= 3) {
            var1 = this.commandeEnteteVentes.getBcmBudget().split(":");
            this.transfertCompta.setTrfBudget(var1[0]);
         } else {
            this.transfertCompta.setTrfBudget(this.commandeEnteteVentes.getBcmBudget());
         }

         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfDossier("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
      }

   }

   public void traitementLivraisonVentes(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.livraisonEnteteVentes = this.livraisonEnteteVentesDao.pourParapheur(var1.getDocId(), var3);
      if (this.livraisonEnteteVentes != null) {
         String var4 = "" + (this.livraisonEnteteVentes.getBlvDate().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(23, this.livraisonEnteteVentes.getBlvSerie(), var4, var3);
         String var6 = "";
         String var7 = "";
         if (var5 != null && !var5.isEmpty() && this.livraisonEnteteVentes.getTiers().getTietransfertCpte() == 0) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("23");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(22);
            this.transfertCompta.setTrfIdOrigine(this.livraisonEnteteVentes.getBlvId());
            this.transfertCompta.setTrfAgent(this.livraisonEnteteVentes.getBlvNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.livraisonEnteteVentes.getBlvDate());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.livraisonEnteteVentes.getBlvDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.livraisonEnteteVentes.getBlvDate()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.livraisonEnteteVentes.getTiers().getTieid(), var3));
            this.transfertCompta.setTrfDebitSaisie(this.livraisonEnteteVentes.getBlvTotTtc() + this.livraisonEnteteVentes.getBlvTotTc());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance(this.livraisonEnteteVentes.getBlvDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneLivraisonVentes(var6, var7, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            if (this.livraisonEnteteVentes.getBlvTotTc() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("23");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(23);
               this.transfertCompta.setTrfIdOrigine(this.livraisonEnteteVentes.getBlvId());
               this.transfertCompta.setTrfAgent(this.livraisonEnteteVentes.getBlvNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.livraisonEnteteVentes.getBlvDate());
               this.transfertCompta.setTrfCode(var5);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.livraisonEnteteVentes.getBlvDate()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.livraisonEnteteVentes.getBlvDate()));
               this.transfertCompta.setTrfCompte(var2);
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.livraisonEnteteVentes.getBlvTotTc());
               this.transfertCompta.setTrfDateEcheance(this.livraisonEnteteVentes.getBlvDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneLivraisonVentes(var6, var7, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            ArrayList var8 = new ArrayList();
            new ArrayList();
            List var9 = this.livraisonLigneVentesDao.chargerLesLignes(this.livraisonEnteteVentes, var3);
            int var10;
            String var11;
            if (var9.size() != 0) {
               for(var10 = 0; var10 < var9.size(); ++var10) {
                  this.livraisonLigneVentes = new LivraisonLigneVentes();
                  this.livraisonLigneVentes = (LivraisonLigneVentes)var9.get(var10);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("23");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(23);
                  this.transfertCompta.setTrfIdOrigine(this.livraisonEnteteVentes.getBlvId());
                  this.transfertCompta.setTrfAgent(this.livraisonEnteteVentes.getBlvNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.livraisonEnteteVentes.getBlvDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.livraisonEnteteVentes.getBlvDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.livraisonEnteteVentes.getBlvDate()));
                  var11 = this.formTransfertCtrl.calculeCompteProduitVentes(this.livraisonEnteteVentes.getBlvExoTva(), this.livraisonEnteteVentes.getBlvTotTva(), this.commandeLigneVentes.getBcmligCode(), this.commandeEnteteVentes.getTiers().getTiecodepays(), this.commandeEnteteVentes.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var11);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.livraisonLigneVentes.getBlvligPt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneLivraisonVentes(var6, var7, this.livraisonLigneVentes.getBlvligLibelle());
                  boolean var12 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var3);
                  if (var12) {
                     this.analytiqueLivraisonVentes();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var13 = new Stock();
                  var13.setStkTva(this.livraisonLigneVentes.getBlvligTva());
                  var13.setStkTaxe(this.livraisonLigneVentes.getBlvligTaxe());
                  var8.add(var13);
               }
            }

            if (var8.size() != 0) {
               for(var10 = 0; var10 < var8.size(); ++var10) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("23");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(23);
                  this.transfertCompta.setTrfIdOrigine(this.livraisonEnteteVentes.getBlvId());
                  this.transfertCompta.setTrfAgent(this.livraisonEnteteVentes.getBlvNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.livraisonEnteteVentes.getBlvDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.livraisonEnteteVentes.getBlvDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.livraisonEnteteVentes.getBlvDate()));
                  var11 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var8.get(var10)).getStkTaxe(), this.livraisonEnteteVentes.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var11);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var8.get(var10)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneLivraisonVentes(var6, var7, "");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneLivraisonVentes(String var1, String var2, String var3) {
      if (this.optionVentes.getZoneRef1().equals("0")) {
         if (this.optionVentes.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvSerie() + ":" + this.livraisonEnteteVentes.getBlvNum());
         } else if (this.optionVentes.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvNum());
         }
      } else if (this.optionVentes.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1(var1);
      } else if (this.optionVentes.getZoneRef1().equals("2")) {
         this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvAnal4());
      } else if (this.optionVentes.getZoneRef1().equals("11")) {
         this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvInfo1());
      } else if (this.optionVentes.getZoneRef1().equals("12")) {
         this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvInfo2());
      } else if (this.optionVentes.getZoneRef1().equals("13")) {
         this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvInfo3());
      } else if (this.optionVentes.getZoneRef1().equals("14")) {
         this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvInfo4());
      } else if (this.optionVentes.getZoneRef1().equals("15")) {
         this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvInfo5());
      } else if (this.optionVentes.getZoneRef1().equals("16")) {
         this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvInfo6());
      } else if (this.optionVentes.getZoneRef1().equals("17")) {
         this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvInfo7());
      } else if (this.optionVentes.getZoneRef1().equals("18")) {
         this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvInfo8());
      } else if (this.optionVentes.getZoneRef1().equals("19")) {
         this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvInfo9());
      } else if (this.optionVentes.getZoneRef1().equals("20")) {
         this.transfertCompta.setTrfReference1(this.livraisonEnteteVentes.getBlvInfo10());
      }

      if (this.optionVentes.getZoneRef2().equals("0")) {
         if (this.optionVentes.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvSerie() + ":" + this.livraisonEnteteVentes.getBlvNum());
         } else if (this.optionVentes.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvNum());
         }
      } else if (this.optionVentes.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2(var1);
      } else if (this.optionVentes.getZoneRef2().equals("2")) {
         this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvAnal4());
      } else if (this.optionVentes.getZoneRef2().equals("3")) {
         this.transfertCompta.setTrfReference2(var2);
      } else if (this.optionVentes.getZoneRef2().equals("11")) {
         this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvInfo1());
      } else if (this.optionVentes.getZoneRef2().equals("12")) {
         this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvInfo2());
      } else if (this.optionVentes.getZoneRef2().equals("13")) {
         this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvInfo3());
      } else if (this.optionVentes.getZoneRef2().equals("14")) {
         this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvInfo4());
      } else if (this.optionVentes.getZoneRef2().equals("15")) {
         this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvInfo5());
      } else if (this.optionVentes.getZoneRef2().equals("16")) {
         this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvInfo6());
      } else if (this.optionVentes.getZoneRef2().equals("17")) {
         this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvInfo7());
      } else if (this.optionVentes.getZoneRef2().equals("18")) {
         this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvInfo8());
      } else if (this.optionVentes.getZoneRef2().equals("19")) {
         this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvInfo9());
      } else if (this.optionVentes.getZoneRef2().equals("20")) {
         this.transfertCompta.setTrfReference2(this.livraisonEnteteVentes.getBlvInfo10());
      }

      if (this.optionVentes.getZoneLibelle().equals("0")) {
         if (this.livraisonEnteteVentes.getBlvDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.livraisonEnteteVentes.getBlvDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.livraisonEnteteVentes.getBlvNomTiers());
         }
      } else if (this.optionVentes.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.livraisonEnteteVentes.getBlvObject());
      } else if (this.optionVentes.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.livraisonEnteteVentes.getBlvObject() + " date " + this.utilDate.dateToStringFr(this.livraisonEnteteVentes.getBlvDate()));
      } else if (this.optionVentes.getZoneLibelle().equals("3")) {
         if (var3 != null && !var3.isEmpty()) {
            if (this.livraisonEnteteVentes.getBlvDiversTiers() == 99) {
               this.transfertCompta.setTrfLibelle(var3 + " " + this.livraisonEnteteVentes.getBlvDiversNom());
            } else {
               this.transfertCompta.setTrfLibelle(var3 + " " + this.livraisonEnteteVentes.getBlvNomTiers());
            }
         } else if (this.livraisonEnteteVentes.getBlvDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.livraisonEnteteVentes.getBlvDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.livraisonEnteteVentes.getBlvNomTiers());
         }
      }

      if (this.optionVentes.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.livraisonEnteteVentes.getBlvObject());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("11")) {
         this.transfertCompta.setTrfSuite(this.livraisonEnteteVentes.getBlvInfo1());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("12")) {
         this.transfertCompta.setTrfSuite(this.livraisonEnteteVentes.getBlvInfo2());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("13")) {
         this.transfertCompta.setTrfSuite(this.livraisonEnteteVentes.getBlvInfo3());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("14")) {
         this.transfertCompta.setTrfSuite(this.livraisonEnteteVentes.getBlvInfo4());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("15")) {
         this.transfertCompta.setTrfSuite(this.livraisonEnteteVentes.getBlvInfo5());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("16")) {
         this.transfertCompta.setTrfSuite(this.livraisonEnteteVentes.getBlvInfo6());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("17")) {
         this.transfertCompta.setTrfSuite(this.livraisonEnteteVentes.getBlvInfo7());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("18")) {
         this.transfertCompta.setTrfSuite(this.livraisonEnteteVentes.getBlvInfo8());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("19")) {
         this.transfertCompta.setTrfSuite(this.livraisonEnteteVentes.getBlvInfo9());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("20")) {
         this.transfertCompta.setTrfSuite(this.livraisonEnteteVentes.getBlvInfo10());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueLivraisonVentes() {
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.produits != null) {
         if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":") || this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
            if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":")) {
               var1 = this.produits.getProCle1().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
               var1 = this.produits.getProCle2().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         } else if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.produits.getProActivite());
            } else {
               var1 = this.produits.getProActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         }

         if (this.famillesProduitsVentes != null) {
            if ((this.famillesProduitsVentes.getFamvteCle1() == null || this.famillesProduitsVentes.getFamvteCle1().isEmpty() || !this.famillesProduitsVentes.getFamvteCle1().contains(":")) && (this.famillesProduitsVentes.getFamvteCle2() == null || this.famillesProduitsVentes.getFamvteCle2().isEmpty() || !this.famillesProduitsVentes.getFamvteCle2().contains(":"))) {
               if (this.famillesProduitsVentes.getFamvteActivite() != null && !this.famillesProduitsVentes.getFamvteActivite().isEmpty() && this.famillesProduitsVentes.getFamvteActivite().contains(":") && (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty())) {
                  if (this.decoupageActivite) {
                     this.transfertCompta.setTrfActivite(this.famillesProduitsVentes.getFamvteActivite());
                  } else {
                     var1 = this.famillesProduitsVentes.getFamvteActivite().split(":");
                     this.transfertCompta.setTrfActivite(var1[0]);
                  }
               }
            } else {
               if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && this.famillesProduitsVentes.getFamvteCle1() != null && !this.famillesProduitsVentes.getFamvteCle1().isEmpty() && this.famillesProduitsVentes.getFamvteCle1().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle1().split(":");
                  this.transfertCompta.setTrfRepartitionCle1(var1[0]);
               }

               if ((this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty()) && this.famillesProduitsVentes.getFamvteCle2() != null && !this.famillesProduitsVentes.getFamvteCle2().isEmpty() && this.famillesProduitsVentes.getFamvteCle2().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle2().split(":");
                  this.transfertCompta.setTrfRepartitionCle2(var1[0]);
               }
            }
         }
      }

      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty()) {
            if (this.livraisonEnteteVentes.getBlvActivite() != null && !this.livraisonEnteteVentes.getBlvActivite().isEmpty() && this.livraisonEnteteVentes.getBlvActivite().contains(":") && this.livraisonEnteteVentes.getBlvActivite().length() >= 3) {
               if (this.decoupageActivite) {
                  this.transfertCompta.setTrfActivite(this.livraisonEnteteVentes.getBlvActivite());
               } else {
                  var1 = this.livraisonEnteteVentes.getBlvActivite().split(":");
                  this.transfertCompta.setTrfActivite(var1[0]);
               }
            } else {
               this.transfertCompta.setTrfActivite(this.livraisonEnteteVentes.getBlvActivite());
            }
         }

         if (this.livraisonEnteteVentes.getBlvSite() != null && !this.livraisonEnteteVentes.getBlvSite().isEmpty() && this.livraisonEnteteVentes.getBlvSite().contains(":") && this.livraisonEnteteVentes.getBlvSite().length() >= 3) {
            var1 = this.livraisonEnteteVentes.getBlvSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.livraisonEnteteVentes.getBlvSite());
         }

         if (this.livraisonEnteteVentes.getBlvDepartement() != null && !this.livraisonEnteteVentes.getBlvDepartement().isEmpty() && this.livraisonEnteteVentes.getBlvDepartement().contains(":") && this.livraisonEnteteVentes.getBlvDepartement().length() >= 3) {
            var1 = this.livraisonEnteteVentes.getBlvDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.livraisonEnteteVentes.getBlvDepartement());
         }

         if (this.livraisonEnteteVentes.getBlvService() != null && !this.livraisonEnteteVentes.getBlvService().isEmpty() && this.livraisonEnteteVentes.getBlvService().contains(":") && this.livraisonEnteteVentes.getBlvService().length() >= 3) {
            var1 = this.livraisonEnteteVentes.getBlvService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.livraisonEnteteVentes.getBlvService());
         }

         if (this.livraisonEnteteVentes.getBlvRegion() != null && !this.livraisonEnteteVentes.getBlvRegion().isEmpty() && this.livraisonEnteteVentes.getBlvRegion().contains(":") && this.livraisonEnteteVentes.getBlvRegion().length() >= 3) {
            var1 = this.livraisonEnteteVentes.getBlvRegion().split(":");
            this.transfertCompta.setTrfRegion(var1[0]);
         } else {
            this.transfertCompta.setTrfRegion(this.livraisonEnteteVentes.getBlvRegion());
         }

         if (this.livraisonEnteteVentes.getBlvSecteur() != null && !this.livraisonEnteteVentes.getBlvSecteur().isEmpty() && this.livraisonEnteteVentes.getBlvSecteur().contains(":") && this.livraisonEnteteVentes.getBlvSecteur().length() >= 3) {
            var1 = this.livraisonEnteteVentes.getBlvSecteur().split(":");
            this.transfertCompta.setTrfSecteur(var1[0]);
         } else {
            this.transfertCompta.setTrfSecteur(this.livraisonEnteteVentes.getBlvSecteur());
         }

         if (this.livraisonEnteteVentes.getBlvPdv() != null && !this.livraisonEnteteVentes.getBlvPdv().isEmpty() && this.livraisonEnteteVentes.getBlvPdv().contains(":") && this.livraisonEnteteVentes.getBlvPdv().length() >= 3) {
            var1 = this.livraisonEnteteVentes.getBlvPdv().split(":");
            this.transfertCompta.setTrfPdv(var1[0]);
         } else {
            this.transfertCompta.setTrfPdv(this.livraisonEnteteVentes.getBlvPdv());
         }

         if (this.livraisonEnteteVentes.getBlvAnal4() != null && !this.livraisonEnteteVentes.getBlvAnal4().isEmpty() && this.livraisonEnteteVentes.getBlvAnal4().contains(":") && this.livraisonEnteteVentes.getBlvAnal4().length() >= 3) {
            var1 = this.livraisonEnteteVentes.getBlvAnal4().split(":");
            this.transfertCompta.setTrfDossier(var1[0]);
         } else {
            this.transfertCompta.setTrfDossier(this.livraisonEnteteVentes.getBlvAnal4());
         }

         if (this.livraisonEnteteVentes.getBlvAnal2() != null && !this.livraisonEnteteVentes.getBlvAnal2().isEmpty() && this.livraisonEnteteVentes.getBlvAnal2().contains(":") && this.livraisonEnteteVentes.getBlvAnal2().length() >= 3) {
            var1 = this.livraisonEnteteVentes.getBlvAnal2().split(":");
            this.transfertCompta.setTrfParc(var1[0]);
         } else {
            this.transfertCompta.setTrfParc(this.livraisonEnteteVentes.getBlvAnal2());
         }

         if (this.livraisonEnteteVentes.getBlvBudget() != null && !this.livraisonEnteteVentes.getBlvBudget().isEmpty() && this.livraisonEnteteVentes.getBlvBudget().contains(":") && this.livraisonEnteteVentes.getBlvBudget().length() >= 3) {
            var1 = this.livraisonEnteteVentes.getBlvBudget().split(":");
            this.transfertCompta.setTrfBudget(var1[0]);
         } else {
            this.transfertCompta.setTrfBudget(this.livraisonEnteteVentes.getBlvBudget());
         }

         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfDossier("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
      }

   }

   public void traitementFactureVentes(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(var1.getDocId(), var3);
      if (this.factureEnteteVentes != null) {
         String var4 = "" + (this.factureEnteteVentes.getFacDate().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(25, this.factureEnteteVentes.getFacSerie(), var4, var3);
         String var6 = "";
         String var7 = "";
         if (var5 != null && !var5.isEmpty() && this.factureEnteteVentes.getTiers().getTietransfertCpte() == 0) {
            this.documentTraceVentes = this.documentTraceVentesDao.chercherDestinationTrace(this.factureEnteteVentes.getFacId(), 25, var3);
            if (this.documentTraceVentes != null) {
               if (this.optionVentes.getZoneRef1Serie().equals("0")) {
                  var6 = this.documentTraceVentes.getDoctraOrgSerie() + ":" + this.documentTraceVentes.getDoctraOrgNum();
               } else {
                  var6 = this.documentTraceVentes.getDoctraOrgNum();
               }

               if (var6 != null && !var6.isEmpty()) {
                  this.documentTraceVentes = this.documentTraceVentesDao.chercherDestinationTrace(this.documentTraceVentes.getDoctraOrgId(), 23, var3);
                  if (this.documentTraceVentes != null) {
                     if (this.optionVentes.getZoneRef1Serie().equals("0")) {
                        var7 = this.documentTraceVentes.getDoctraOrgSerie() + ":" + this.documentTraceVentes.getDoctraOrgNum();
                     } else {
                        var7 = this.documentTraceVentes.getDoctraOrgNum();
                     }
                  }
               }
            }

            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("25");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(25);
            this.transfertCompta.setTrfIdOrigine(this.factureEnteteVentes.getFacId());
            this.transfertCompta.setTrfAgent(this.factureEnteteVentes.getFacNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.factureEnteteVentes.getFacDate());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.factureEnteteVentes.getFacDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteVentes.getFacDate()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.factureEnteteVentes.getTiers().getTieid(), var3));
            this.transfertCompta.setTrfDebitSaisie(this.factureEnteteVentes.getFacTotTtc() + this.factureEnteteVentes.getFacTotTc());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance(this.factureEnteteVentes.getFacDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneFactureVentes(var6, var7, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            if (this.factureEnteteVentes.getFacTotTc() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("25");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(25);
               this.transfertCompta.setTrfIdOrigine(this.factureEnteteVentes.getFacId());
               this.transfertCompta.setTrfAgent(this.factureEnteteVentes.getFacNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.factureEnteteVentes.getFacDate());
               this.transfertCompta.setTrfCode(var5);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.factureEnteteVentes.getFacDate()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteVentes.getFacDate()));
               this.transfertCompta.setTrfCompte(var2);
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.factureEnteteVentes.getFacTotTc());
               this.transfertCompta.setTrfDateEcheance(this.factureEnteteVentes.getFacDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneFactureVentes(var6, var7, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            ArrayList var8 = new ArrayList();
            new ArrayList();
            List var9 = this.factureLigneVentesDao.chargerLesLignes(this.factureEnteteVentes, var3);
            int var10;
            String var11;
            if (var9.size() != 0) {
               for(var10 = 0; var10 < var9.size(); ++var10) {
                  this.factureLigneVentes = new FactureLigneVentes();
                  this.factureLigneVentes = (FactureLigneVentes)var9.get(var10);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("25");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(25);
                  this.transfertCompta.setTrfIdOrigine(this.factureEnteteVentes.getFacId());
                  this.transfertCompta.setTrfAgent(this.factureEnteteVentes.getFacNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.factureEnteteVentes.getFacDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.factureEnteteVentes.getFacDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteVentes.getFacDate()));
                  var11 = this.formTransfertCtrl.calculeCompteProduitVentes(this.factureEnteteVentes.getFacExoTva(), this.factureEnteteVentes.getFacTotTva(), this.factureLigneVentes.getFacligCode(), this.factureEnteteVentes.getTiers().getTiecodepays(), this.factureEnteteVentes.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var11);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.factureLigneVentes.getFacligPt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneFactureVentes(var6, var7, this.factureLigneVentes.getFacligLibelle());
                  boolean var12 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var3);
                  if (var12) {
                     this.analytiqueFactureVentes();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var13 = new Stock();
                  var13.setStkTva(this.factureLigneVentes.getFacligTva());
                  var13.setStkTaxe(this.factureLigneVentes.getFacligTaxe());
                  var8.add(var13);
               }
            }

            if (var8.size() != 0) {
               for(var10 = 0; var10 < var8.size(); ++var10) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("25");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(25);
                  this.transfertCompta.setTrfIdOrigine(this.factureEnteteVentes.getFacId());
                  this.transfertCompta.setTrfAgent(this.factureEnteteVentes.getFacNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.factureEnteteVentes.getFacDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.factureEnteteVentes.getFacDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteVentes.getFacDate()));
                  var11 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var8.get(var10)).getStkTaxe(), this.factureEnteteVentes.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var11);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var8.get(var10)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneFactureVentes(var6, var7, "");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneFactureVentes(String var1, String var2, String var3) {
      if (this.optionVentes.getZoneRef1().equals("0")) {
         if (this.optionVentes.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacSerie() + ":" + this.factureEnteteVentes.getFacNum());
         } else if (this.optionVentes.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacNum());
         }
      } else if (this.optionVentes.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1(var1);
      } else if (this.optionVentes.getZoneRef1().equals("2")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacAnal4());
      } else if (this.optionVentes.getZoneRef1().equals("11")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacInfo1());
      } else if (this.optionVentes.getZoneRef1().equals("12")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacInfo2());
      } else if (this.optionVentes.getZoneRef1().equals("13")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacInfo3());
      } else if (this.optionVentes.getZoneRef1().equals("14")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacInfo4());
      } else if (this.optionVentes.getZoneRef1().equals("15")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacInfo5());
      } else if (this.optionVentes.getZoneRef1().equals("16")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacInfo6());
      } else if (this.optionVentes.getZoneRef1().equals("17")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacInfo7());
      } else if (this.optionVentes.getZoneRef1().equals("18")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacInfo8());
      } else if (this.optionVentes.getZoneRef1().equals("19")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacInfo9());
      } else if (this.optionVentes.getZoneRef1().equals("20")) {
         this.transfertCompta.setTrfReference1(this.factureEnteteVentes.getFacInfo10());
      }

      if (this.optionVentes.getZoneRef2().equals("0")) {
         if (this.optionVentes.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacSerie() + ":" + this.factureEnteteVentes.getFacNum());
         } else if (this.optionVentes.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacNum());
         }
      } else if (this.optionVentes.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2(var1);
      } else if (this.optionVentes.getZoneRef2().equals("2")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacAnal4());
      } else if (this.optionVentes.getZoneRef2().equals("3")) {
         this.transfertCompta.setTrfReference2(var2);
      } else if (this.optionVentes.getZoneRef2().equals("11")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacInfo1());
      } else if (this.optionVentes.getZoneRef2().equals("12")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacInfo2());
      } else if (this.optionVentes.getZoneRef2().equals("13")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacInfo3());
      } else if (this.optionVentes.getZoneRef2().equals("14")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacInfo4());
      } else if (this.optionVentes.getZoneRef2().equals("15")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacInfo5());
      } else if (this.optionVentes.getZoneRef2().equals("16")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacInfo6());
      } else if (this.optionVentes.getZoneRef2().equals("17")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacInfo7());
      } else if (this.optionVentes.getZoneRef2().equals("18")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacInfo8());
      } else if (this.optionVentes.getZoneRef2().equals("19")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacInfo9());
      } else if (this.optionVentes.getZoneRef2().equals("20")) {
         this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacInfo10());
      }

      if (this.optionVentes.getZoneLibelle().equals("0")) {
         if (this.factureEnteteVentes.getFacDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.factureEnteteVentes.getFacDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.factureEnteteVentes.getFacNomTiers());
         }
      } else if (this.optionVentes.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.factureEnteteVentes.getFacObject());
      } else if (this.optionVentes.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.factureEnteteVentes.getFacObject() + " date " + this.utilDate.dateToStringFr(this.factureEnteteVentes.getFacDate()));
      } else if (this.optionVentes.getZoneLibelle().equals("3")) {
         if (var3 != null && !var3.isEmpty()) {
            if (this.factureEnteteVentes.getFacDiversTiers() == 99) {
               this.transfertCompta.setTrfLibelle(var3 + " " + this.factureEnteteVentes.getFacDiversNom());
            } else {
               this.transfertCompta.setTrfLibelle(var3 + " " + this.factureEnteteVentes.getFacNomTiers());
            }
         } else if (this.factureEnteteVentes.getFacDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.factureEnteteVentes.getFacDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.factureEnteteVentes.getFacNomTiers());
         }
      }

      if (this.optionVentes.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteVentes.getFacObject());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("11")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteVentes.getFacInfo1());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("12")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteVentes.getFacInfo2());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("13")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteVentes.getFacInfo3());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("14")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteVentes.getFacInfo4());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("15")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteVentes.getFacInfo5());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("16")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteVentes.getFacInfo6());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("17")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteVentes.getFacInfo7());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("18")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteVentes.getFacInfo8());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("19")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteVentes.getFacInfo9());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("20")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteVentes.getFacInfo10());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueFactureVentes() {
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.produits != null) {
         if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":") || this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
            if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":")) {
               var1 = this.produits.getProCle1().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
               var1 = this.produits.getProCle2().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         } else if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.produits.getProActivite());
            } else {
               var1 = this.produits.getProActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         }

         if (this.famillesProduitsVentes != null) {
            if ((this.famillesProduitsVentes.getFamvteCle1() == null || this.famillesProduitsVentes.getFamvteCle1().isEmpty() || !this.famillesProduitsVentes.getFamvteCle1().contains(":")) && (this.famillesProduitsVentes.getFamvteCle2() == null || this.famillesProduitsVentes.getFamvteCle2().isEmpty() || !this.famillesProduitsVentes.getFamvteCle2().contains(":"))) {
               if (this.famillesProduitsVentes.getFamvteActivite() != null && !this.famillesProduitsVentes.getFamvteActivite().isEmpty() && this.famillesProduitsVentes.getFamvteActivite().contains(":") && (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty())) {
                  if (this.decoupageActivite) {
                     this.transfertCompta.setTrfActivite(this.famillesProduitsVentes.getFamvteActivite());
                  } else {
                     var1 = this.famillesProduitsVentes.getFamvteActivite().split(":");
                     this.transfertCompta.setTrfActivite(var1[0]);
                  }
               }
            } else {
               if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && this.famillesProduitsVentes.getFamvteCle1() != null && !this.famillesProduitsVentes.getFamvteCle1().isEmpty() && this.famillesProduitsVentes.getFamvteCle1().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle1().split(":");
                  this.transfertCompta.setTrfRepartitionCle1(var1[0]);
               }

               if ((this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty()) && this.famillesProduitsVentes.getFamvteCle2() != null && !this.famillesProduitsVentes.getFamvteCle2().isEmpty() && this.famillesProduitsVentes.getFamvteCle2().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle2().split(":");
                  this.transfertCompta.setTrfRepartitionCle2(var1[0]);
               }
            }
         }
      }

      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty()) {
            if (this.factureEnteteVentes.getFacActivite() != null && !this.factureEnteteVentes.getFacActivite().isEmpty() && this.factureEnteteVentes.getFacActivite().contains(":") && this.factureEnteteVentes.getFacActivite().length() >= 3) {
               if (this.decoupageActivite) {
                  this.transfertCompta.setTrfActivite(this.factureEnteteVentes.getFacActivite());
               } else {
                  var1 = this.factureEnteteVentes.getFacActivite().split(":");
                  this.transfertCompta.setTrfActivite(var1[0]);
               }
            } else {
               this.transfertCompta.setTrfActivite(this.factureEnteteVentes.getFacActivite());
            }
         }

         if (this.factureEnteteVentes.getFacSite() != null && !this.factureEnteteVentes.getFacSite().isEmpty() && this.factureEnteteVentes.getFacSite().contains(":") && this.factureEnteteVentes.getFacSite().length() >= 3) {
            var1 = this.factureEnteteVentes.getFacSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.factureEnteteVentes.getFacSite());
         }

         if (this.factureEnteteVentes.getFacDepartement() != null && !this.factureEnteteVentes.getFacDepartement().isEmpty() && this.factureEnteteVentes.getFacDepartement().contains(":") && this.factureEnteteVentes.getFacDepartement().length() >= 3) {
            var1 = this.factureEnteteVentes.getFacDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.factureEnteteVentes.getFacDepartement());
         }

         if (this.factureEnteteVentes.getFacService() != null && !this.factureEnteteVentes.getFacService().isEmpty() && this.factureEnteteVentes.getFacService().contains(":") && this.factureEnteteVentes.getFacService().length() >= 3) {
            var1 = this.factureEnteteVentes.getFacService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.factureEnteteVentes.getFacService());
         }

         if (this.factureEnteteVentes.getFacRegion() != null && !this.factureEnteteVentes.getFacRegion().isEmpty() && this.factureEnteteVentes.getFacRegion().contains(":") && this.factureEnteteVentes.getFacRegion().length() >= 3) {
            var1 = this.factureEnteteVentes.getFacRegion().split(":");
            this.transfertCompta.setTrfRegion(var1[0]);
         } else {
            this.transfertCompta.setTrfRegion(this.factureEnteteVentes.getFacRegion());
         }

         if (this.factureEnteteVentes.getFacSecteur() != null && !this.factureEnteteVentes.getFacSecteur().isEmpty() && this.factureEnteteVentes.getFacSecteur().contains(":") && this.factureEnteteVentes.getFacSecteur().length() >= 3) {
            var1 = this.factureEnteteVentes.getFacSecteur().split(":");
            this.transfertCompta.setTrfSecteur(var1[0]);
         } else {
            this.transfertCompta.setTrfSecteur(this.factureEnteteVentes.getFacSecteur());
         }

         if (this.factureEnteteVentes.getFacPdv() != null && !this.factureEnteteVentes.getFacPdv().isEmpty() && this.factureEnteteVentes.getFacPdv().contains(":") && this.factureEnteteVentes.getFacPdv().length() >= 3) {
            var1 = this.factureEnteteVentes.getFacPdv().split(":");
            this.transfertCompta.setTrfPdv(var1[0]);
         } else {
            this.transfertCompta.setTrfPdv(this.factureEnteteVentes.getFacPdv());
         }

         if (this.factureEnteteVentes.getFacAnal4() != null && !this.factureEnteteVentes.getFacAnal4().isEmpty() && this.factureEnteteVentes.getFacAnal4().contains(":") && this.factureEnteteVentes.getFacAnal4().length() >= 3) {
            var1 = this.factureEnteteVentes.getFacAnal4().split(":");
            this.transfertCompta.setTrfDossier(var1[0]);
         } else {
            this.transfertCompta.setTrfDossier(this.factureEnteteVentes.getFacAnal4());
         }

         if (this.factureEnteteVentes.getFacAnal2() != null && !this.factureEnteteVentes.getFacAnal2().isEmpty() && this.factureEnteteVentes.getFacAnal2().contains(":") && this.factureEnteteVentes.getFacAnal2().length() >= 3) {
            var1 = this.factureEnteteVentes.getFacAnal2().split(":");
            this.transfertCompta.setTrfParc(var1[0]);
         } else {
            this.transfertCompta.setTrfParc(this.factureEnteteVentes.getFacAnal2());
         }

         if (this.factureEnteteVentes.getFacBudget() != null && !this.factureEnteteVentes.getFacBudget().isEmpty() && this.factureEnteteVentes.getFacBudget().contains(":") && this.factureEnteteVentes.getFacBudget().length() >= 3) {
            var1 = this.factureEnteteVentes.getFacBudget().split(":");
            this.transfertCompta.setTrfBudget(var1[0]);
         } else {
            this.transfertCompta.setTrfBudget(this.factureEnteteVentes.getFacBudget());
         }

         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfDossier("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
      }

   }

   public void traitementFactureInterneVentes(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.pourParapheur(var1.getDocId(), var3);
      if (this.factureInterneEnteteVentes != null) {
         String var4 = "" + (this.factureInterneEnteteVentes.getFitDate().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(142, this.factureInterneEnteteVentes.getFitSerie(), var4, var3);
         if (var5 != null && !var5.isEmpty() && this.factureInterneEnteteVentes.getTiers().getTietransfertCpte() == 0) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("142");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(142);
            this.transfertCompta.setTrfIdOrigine(this.factureInterneEnteteVentes.getFitId());
            this.transfertCompta.setTrfAgent(this.factureInterneEnteteVentes.getFitNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.factureInterneEnteteVentes.getFitDate());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.factureInterneEnteteVentes.getFitDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureInterneEnteteVentes.getFitDate()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.factureInterneEnteteVentes.getTiers().getTieid(), var3));
            this.transfertCompta.setTrfDebitSaisie(this.factureInterneEnteteVentes.getFitTotTtc() + this.factureInterneEnteteVentes.getFitTotTc());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance(this.factureInterneEnteteVentes.getFitDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneFactureInterneVentes("");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            if (this.factureInterneEnteteVentes.getFitTotTc() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("142");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(142);
               this.transfertCompta.setTrfIdOrigine(this.factureInterneEnteteVentes.getFitId());
               this.transfertCompta.setTrfAgent(this.factureInterneEnteteVentes.getFitNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.factureInterneEnteteVentes.getFitDate());
               this.transfertCompta.setTrfCode(var5);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.factureInterneEnteteVentes.getFitDate()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureInterneEnteteVentes.getFitDate()));
               this.transfertCompta.setTrfCompte(var2);
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.factureInterneEnteteVentes.getFitTotTc());
               this.transfertCompta.setTrfDateEcheance(this.factureInterneEnteteVentes.getFitDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneFactureInterneVentes("");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            ArrayList var6 = new ArrayList();
            new ArrayList();
            List var7 = this.factureInterneLigneVentesDao.chargerLesLignes(this.factureInterneEnteteVentes, var3);
            int var8;
            String var9;
            if (var7.size() != 0) {
               for(var8 = 0; var8 < var7.size(); ++var8) {
                  this.factureInterneLigneVentes = new FactureInterneLigneVentes();
                  this.factureInterneLigneVentes = (FactureInterneLigneVentes)var7.get(var8);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("142");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(142);
                  this.transfertCompta.setTrfIdOrigine(this.factureInterneEnteteVentes.getFitId());
                  this.transfertCompta.setTrfAgent(this.factureInterneEnteteVentes.getFitNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.factureInterneEnteteVentes.getFitDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.factureInterneEnteteVentes.getFitDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureInterneEnteteVentes.getFitDate()));
                  var9 = this.formTransfertCtrl.calculeCompteProduitVentes(this.factureInterneEnteteVentes.getFitExoTva(), this.factureInterneEnteteVentes.getFitTotTva(), this.factureInterneLigneVentes.getFitligCode(), this.factureInterneEnteteVentes.getTiers().getTiecodepays(), this.factureInterneEnteteVentes.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var9);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.factureInterneLigneVentes.getFitligPt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneFactureInterneVentes(this.factureInterneLigneVentes.getFitligLibelle());
                  boolean var10 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var3);
                  if (var10) {
                     this.analytiqueFactureInterneVentes();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var11 = new Stock();
                  var11.setStkTva(this.factureInterneLigneVentes.getFitligTva());
                  var11.setStkTaxe(this.factureInterneLigneVentes.getFitligTaxe());
                  var6.add(var11);
               }
            }

            if (var6.size() != 0) {
               for(var8 = 0; var8 < var6.size(); ++var8) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("142");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(142);
                  this.transfertCompta.setTrfIdOrigine(this.factureInterneEnteteVentes.getFitId());
                  this.transfertCompta.setTrfAgent(this.factureInterneEnteteVentes.getFitNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.factureInterneEnteteVentes.getFitDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.factureInterneEnteteVentes.getFitDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureInterneEnteteVentes.getFitDate()));
                  var9 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var6.get(var8)).getStkTaxe(), this.factureInterneEnteteVentes.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var9);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var6.get(var8)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneFactureInterneVentes("");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneFactureInterneVentes(String var1) {
      if (this.optionVentes.getZoneRef1().equals("0")) {
         if (this.optionVentes.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitSerie() + ":" + this.factureInterneEnteteVentes.getFitNum());
         } else if (this.optionVentes.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitNum());
         }
      } else if (!this.optionVentes.getZoneRef1().equals("1")) {
         if (this.optionVentes.getZoneRef1().equals("2")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitAnal4());
         } else if (this.optionVentes.getZoneRef1().equals("11")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitInfo1());
         } else if (this.optionVentes.getZoneRef1().equals("12")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitInfo2());
         } else if (this.optionVentes.getZoneRef1().equals("13")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitInfo3());
         } else if (this.optionVentes.getZoneRef1().equals("14")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitInfo4());
         } else if (this.optionVentes.getZoneRef1().equals("15")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitInfo5());
         } else if (this.optionVentes.getZoneRef1().equals("16")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitInfo6());
         } else if (this.optionVentes.getZoneRef1().equals("17")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitInfo7());
         } else if (this.optionVentes.getZoneRef1().equals("18")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitInfo8());
         } else if (this.optionVentes.getZoneRef1().equals("19")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitInfo9());
         } else if (this.optionVentes.getZoneRef1().equals("20")) {
            this.transfertCompta.setTrfReference1(this.factureInterneEnteteVentes.getFitInfo10());
         }
      }

      if (this.optionVentes.getZoneRef2().equals("0")) {
         if (this.optionVentes.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitSerie() + ":" + this.factureInterneEnteteVentes.getFitNum());
         } else if (this.optionVentes.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitNum());
         }
      } else if (!this.optionVentes.getZoneRef2().equals("1")) {
         if (this.optionVentes.getZoneRef2().equals("2")) {
            this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitAnal4());
         } else if (!this.optionVentes.getZoneRef2().equals("3")) {
            if (this.optionVentes.getZoneRef2().equals("11")) {
               this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitInfo1());
            } else if (this.optionVentes.getZoneRef2().equals("12")) {
               this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitInfo2());
            } else if (this.optionVentes.getZoneRef2().equals("13")) {
               this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitInfo3());
            } else if (this.optionVentes.getZoneRef2().equals("14")) {
               this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitInfo4());
            } else if (this.optionVentes.getZoneRef2().equals("15")) {
               this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitInfo5());
            } else if (this.optionVentes.getZoneRef2().equals("16")) {
               this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitInfo6());
            } else if (this.optionVentes.getZoneRef2().equals("17")) {
               this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitInfo7());
            } else if (this.optionVentes.getZoneRef2().equals("18")) {
               this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitInfo8());
            } else if (this.optionVentes.getZoneRef2().equals("19")) {
               this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitInfo9());
            } else if (this.optionVentes.getZoneRef2().equals("20")) {
               this.transfertCompta.setTrfReference2(this.factureInterneEnteteVentes.getFitInfo10());
            }
         }
      }

      if (this.optionVentes.getZoneLibelle().equals("0")) {
         if (this.factureInterneEnteteVentes.getFitDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.factureInterneEnteteVentes.getFitDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.factureInterneEnteteVentes.getFitNomTiers());
         }
      } else if (this.optionVentes.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.factureInterneEnteteVentes.getFitObject());
      } else if (this.optionVentes.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.factureInterneEnteteVentes.getFitObject() + " date " + this.utilDate.dateToStringFr(this.factureInterneEnteteVentes.getFitDate()));
      } else if (this.optionVentes.getZoneLibelle().equals("3")) {
         if (var1 != null && !var1.isEmpty()) {
            if (this.factureInterneEnteteVentes.getFitDiversTiers() == 99) {
               this.transfertCompta.setTrfLibelle(var1 + " " + this.factureInterneEnteteVentes.getFitDiversNom());
            } else {
               this.transfertCompta.setTrfLibelle(var1 + " " + this.factureInterneEnteteVentes.getFitNomTiers());
            }
         } else if (this.factureInterneEnteteVentes.getFitDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.factureInterneEnteteVentes.getFitDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.factureInterneEnteteVentes.getFitNomTiers());
         }
      }

      if (this.optionVentes.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.factureInterneEnteteVentes.getFitObject());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("11")) {
         this.transfertCompta.setTrfSuite(this.factureInterneEnteteVentes.getFitInfo1());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("12")) {
         this.transfertCompta.setTrfSuite(this.factureInterneEnteteVentes.getFitInfo2());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("13")) {
         this.transfertCompta.setTrfSuite(this.factureInterneEnteteVentes.getFitInfo3());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("14")) {
         this.transfertCompta.setTrfSuite(this.factureInterneEnteteVentes.getFitInfo4());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("15")) {
         this.transfertCompta.setTrfSuite(this.factureInterneEnteteVentes.getFitInfo5());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("16")) {
         this.transfertCompta.setTrfSuite(this.factureInterneEnteteVentes.getFitInfo6());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("17")) {
         this.transfertCompta.setTrfSuite(this.factureInterneEnteteVentes.getFitInfo7());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("18")) {
         this.transfertCompta.setTrfSuite(this.factureInterneEnteteVentes.getFitInfo8());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("19")) {
         this.transfertCompta.setTrfSuite(this.factureInterneEnteteVentes.getFitInfo9());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("20")) {
         this.transfertCompta.setTrfSuite(this.factureInterneEnteteVentes.getFitInfo10());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueFactureInterneVentes() {
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.produits != null) {
         if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":") || this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
            if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":")) {
               var1 = this.produits.getProCle1().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
               var1 = this.produits.getProCle2().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         } else if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.produits.getProActivite());
            } else {
               var1 = this.produits.getProActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         }

         if (this.famillesProduitsVentes != null) {
            if ((this.famillesProduitsVentes.getFamvteCle1() == null || this.famillesProduitsVentes.getFamvteCle1().isEmpty() || !this.famillesProduitsVentes.getFamvteCle1().contains(":")) && (this.famillesProduitsVentes.getFamvteCle2() == null || this.famillesProduitsVentes.getFamvteCle2().isEmpty() || !this.famillesProduitsVentes.getFamvteCle2().contains(":"))) {
               if (this.famillesProduitsVentes.getFamvteActivite() != null && !this.famillesProduitsVentes.getFamvteActivite().isEmpty() && this.famillesProduitsVentes.getFamvteActivite().contains(":") && (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty())) {
                  if (this.decoupageActivite) {
                     this.transfertCompta.setTrfActivite(this.famillesProduitsVentes.getFamvteActivite());
                  } else {
                     var1 = this.famillesProduitsVentes.getFamvteActivite().split(":");
                     this.transfertCompta.setTrfActivite(var1[0]);
                  }
               }
            } else {
               if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && this.famillesProduitsVentes.getFamvteCle1() != null && !this.famillesProduitsVentes.getFamvteCle1().isEmpty() && this.famillesProduitsVentes.getFamvteCle1().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle1().split(":");
                  this.transfertCompta.setTrfRepartitionCle1(var1[0]);
               }

               if ((this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty()) && this.famillesProduitsVentes.getFamvteCle2() != null && !this.famillesProduitsVentes.getFamvteCle2().isEmpty() && this.famillesProduitsVentes.getFamvteCle2().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle2().split(":");
                  this.transfertCompta.setTrfRepartitionCle2(var1[0]);
               }
            }
         }
      }

      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty()) {
            if (this.factureInterneEnteteVentes.getFitActivite() != null && !this.factureInterneEnteteVentes.getFitActivite().isEmpty() && this.factureInterneEnteteVentes.getFitActivite().contains(":") && this.factureInterneEnteteVentes.getFitActivite().length() >= 3) {
               if (this.decoupageActivite) {
                  this.transfertCompta.setTrfActivite(this.factureInterneEnteteVentes.getFitActivite());
               } else {
                  var1 = this.factureInterneEnteteVentes.getFitActivite().split(":");
                  this.transfertCompta.setTrfActivite(var1[0]);
               }
            } else {
               this.transfertCompta.setTrfActivite(this.factureInterneEnteteVentes.getFitActivite());
            }
         }

         if (this.factureInterneEnteteVentes.getFitSite() != null && !this.factureInterneEnteteVentes.getFitSite().isEmpty() && this.factureInterneEnteteVentes.getFitSite().contains(":") && this.factureInterneEnteteVentes.getFitSite().length() >= 3) {
            var1 = this.factureInterneEnteteVentes.getFitSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.factureInterneEnteteVentes.getFitSite());
         }

         if (this.factureInterneEnteteVentes.getFitDepartement() != null && !this.factureInterneEnteteVentes.getFitDepartement().isEmpty() && this.factureInterneEnteteVentes.getFitDepartement().contains(":") && this.factureInterneEnteteVentes.getFitDepartement().length() >= 3) {
            var1 = this.factureInterneEnteteVentes.getFitDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.factureInterneEnteteVentes.getFitDepartement());
         }

         if (this.factureInterneEnteteVentes.getFitService() != null && !this.factureInterneEnteteVentes.getFitService().isEmpty() && this.factureInterneEnteteVentes.getFitService().contains(":") && this.factureInterneEnteteVentes.getFitService().length() >= 3) {
            var1 = this.factureInterneEnteteVentes.getFitService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.factureInterneEnteteVentes.getFitService());
         }

         if (this.factureInterneEnteteVentes.getFitRegion() != null && !this.factureInterneEnteteVentes.getFitRegion().isEmpty() && this.factureInterneEnteteVentes.getFitRegion().contains(":") && this.factureInterneEnteteVentes.getFitRegion().length() >= 3) {
            var1 = this.factureInterneEnteteVentes.getFitRegion().split(":");
            this.transfertCompta.setTrfRegion(var1[0]);
         } else {
            this.transfertCompta.setTrfRegion(this.factureInterneEnteteVentes.getFitRegion());
         }

         if (this.factureInterneEnteteVentes.getFitSecteur() != null && !this.factureInterneEnteteVentes.getFitSecteur().isEmpty() && this.factureInterneEnteteVentes.getFitSecteur().contains(":") && this.factureInterneEnteteVentes.getFitSecteur().length() >= 3) {
            var1 = this.factureInterneEnteteVentes.getFitSecteur().split(":");
            this.transfertCompta.setTrfSecteur(var1[0]);
         } else {
            this.transfertCompta.setTrfSecteur(this.factureInterneEnteteVentes.getFitSecteur());
         }

         if (this.factureInterneEnteteVentes.getFitPdv() != null && !this.factureInterneEnteteVentes.getFitPdv().isEmpty() && this.factureInterneEnteteVentes.getFitPdv().contains(":") && this.factureInterneEnteteVentes.getFitPdv().length() >= 3) {
            var1 = this.factureInterneEnteteVentes.getFitPdv().split(":");
            this.transfertCompta.setTrfPdv(var1[0]);
         } else {
            this.transfertCompta.setTrfPdv(this.factureInterneEnteteVentes.getFitPdv());
         }

         if (this.factureInterneEnteteVentes.getFitAnal4() != null && !this.factureInterneEnteteVentes.getFitAnal4().isEmpty() && this.factureInterneEnteteVentes.getFitAnal4().contains(":") && this.factureInterneEnteteVentes.getFitAnal4().length() >= 3) {
            var1 = this.factureInterneEnteteVentes.getFitAnal4().split(":");
            this.transfertCompta.setTrfDossier(var1[0]);
         } else {
            this.transfertCompta.setTrfDossier(this.factureInterneEnteteVentes.getFitAnal4());
         }

         if (this.factureInterneEnteteVentes.getFitAnal2() != null && !this.factureInterneEnteteVentes.getFitAnal2().isEmpty() && this.factureInterneEnteteVentes.getFitAnal2().contains(":") && this.factureInterneEnteteVentes.getFitAnal2().length() >= 3) {
            var1 = this.factureInterneEnteteVentes.getFitAnal2().split(":");
            this.transfertCompta.setTrfParc(var1[0]);
         } else {
            this.transfertCompta.setTrfParc(this.factureInterneEnteteVentes.getFitAnal2());
         }

         if (this.factureInterneEnteteVentes.getFitBudget() != null && !this.factureInterneEnteteVentes.getFitBudget().isEmpty() && this.factureInterneEnteteVentes.getFitBudget().contains(":") && this.factureInterneEnteteVentes.getFitBudget().length() >= 3) {
            var1 = this.factureInterneEnteteVentes.getFitBudget().split(":");
            this.transfertCompta.setTrfBudget(var1[0]);
         } else {
            this.transfertCompta.setTrfBudget(this.factureInterneEnteteVentes.getFitBudget());
         }

         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfDossier("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
      }

   }

   public void traitementAvoirVentes(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.avoirEnteteVentes = this.avoirEnteteVentesDao.pourParapheur(var1.getDocId(), var3);
      if (this.avoirEnteteVentes != null) {
         String var4 = "" + (this.avoirEnteteVentes.getAvrDate().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(26, this.avoirEnteteVentes.getAvrSerie(), var4, var3);
         String var6 = "";
         String var7 = "";
         if (var5 != null && !var5.isEmpty() && this.avoirEnteteVentes.getTiers().getTietransfertCpte() == 0) {
            if (this.optionVentes.getPaiementAVOIR().equals("1")) {
               if (this.avoirEnteteVentes.getAvrNumBC() != null && !this.avoirEnteteVentes.getAvrNumBC().isEmpty()) {
                  this.commandeEnteteVentes = new CommandeEnteteVentes();
                  this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  this.commandeEnteteVentes = this.commandeEnteteVentesDao.pourParapheurByNum(this.avoirEnteteVentes.getAvrNumBC(), this.avoirEnteteVentes.getAvrSerie(), var3);
                  if (this.commandeEnteteVentes != null) {
                     if (this.optionVentes.getZoneRef1Serie().equals("0")) {
                        var7 = this.commandeEnteteVentes.getBcmSerie() + ":" + this.commandeEnteteVentes.getBcmNum();
                     } else {
                        var7 = this.commandeEnteteVentes.getBcmNum();
                     }

                     var6 = "";
                  }
               }
            } else if (this.avoirEnteteVentes.getAvrNumFacture() != null && !this.avoirEnteteVentes.getAvrNumFacture().isEmpty()) {
               this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(this.avoirEnteteVentes.getAvrNumFacture(), this.avoirEnteteVentes.getAvrSerie(), var3);
               if (this.factureEnteteVentes != null) {
                  var7 = "";
                  if (this.optionVentes.getZoneRef1Serie().equals("0")) {
                     var6 = this.factureEnteteVentes.getFacSerie() + ":" + this.factureEnteteVentes.getFacNum();
                  } else {
                     var6 = this.factureEnteteVentes.getFacNum();
                  }
               }
            }

            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("26");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(26);
            this.transfertCompta.setTrfIdOrigine(this.avoirEnteteVentes.getAvrId());
            this.transfertCompta.setTrfAgent(this.avoirEnteteVentes.getAvrNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.avoirEnteteVentes.getAvrDate());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.avoirEnteteVentes.getAvrDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.avoirEnteteVentes.getAvrDate()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.avoirEnteteVentes.getTiers().getTieid(), var3));
            this.transfertCompta.setTrfDebitSaisie(0.0D);
            this.transfertCompta.setTrfCreditSaisie(this.avoirEnteteVentes.getAvrTotTtc() + this.avoirEnteteVentes.getAvrTotTc());
            this.transfertCompta.setTrfDateEcheance(this.avoirEnteteVentes.getAvrDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneAvoirVentes(var6, var7, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            if (this.avoirEnteteVentes.getAvrTotTc() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("26");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(26);
               this.transfertCompta.setTrfIdOrigine(this.avoirEnteteVentes.getAvrId());
               this.transfertCompta.setTrfAgent(this.avoirEnteteVentes.getAvrNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.avoirEnteteVentes.getAvrDate());
               this.transfertCompta.setTrfCode(var5);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.avoirEnteteVentes.getAvrDate()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.avoirEnteteVentes.getAvrDate()));
               this.transfertCompta.setTrfCompte(var2);
               this.transfertCompta.setTrfDebitSaisie(this.avoirEnteteVentes.getAvrTotTc());
               this.transfertCompta.setTrfCreditSaisie(0.0D);
               this.transfertCompta.setTrfDateEcheance(this.avoirEnteteVentes.getAvrDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneAvoirVentes(var6, var7, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            ArrayList var8 = new ArrayList();
            new ArrayList();
            List var9 = this.avoirLigneVentesDao.chargerLesLignes(this.avoirEnteteVentes, var3);
            int var10;
            String var11;
            if (var9.size() != 0) {
               for(var10 = 0; var10 < var9.size(); ++var10) {
                  this.avoirLigneVentes = new AvoirLigneVentes();
                  this.avoirLigneVentes = (AvoirLigneVentes)var9.get(var10);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("26");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(26);
                  this.transfertCompta.setTrfIdOrigine(this.avoirEnteteVentes.getAvrId());
                  this.transfertCompta.setTrfAgent(this.avoirEnteteVentes.getAvrNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.avoirEnteteVentes.getAvrDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.avoirEnteteVentes.getAvrDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.avoirEnteteVentes.getAvrDate()));
                  var11 = this.formTransfertCtrl.calculeCompteProduitVentes(this.avoirEnteteVentes.getAvrExoTva(), this.avoirEnteteVentes.getAvrTotTva(), this.avoirLigneVentes.getAvrligCode(), this.avoirEnteteVentes.getTiers().getTiecodepays(), this.avoirEnteteVentes.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var11);
                  this.transfertCompta.setTrfDebitSaisie(this.avoirLigneVentes.getAvrligPt());
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneAvoirVentes(var6, var7, this.avoirLigneVentes.getAvrligLibelle());
                  boolean var12 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var3);
                  if (var12) {
                     this.analytiqueAvoirVentes();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var13 = new Stock();
                  var13.setStkTva(this.avoirLigneVentes.getAvrligTva());
                  var13.setStkTaxe(this.avoirLigneVentes.getAvrligTaxe());
                  var8.add(var13);
               }
            }

            if (var8.size() != 0) {
               for(var10 = 0; var10 < var8.size(); ++var10) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("26");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(26);
                  this.transfertCompta.setTrfIdOrigine(this.avoirEnteteVentes.getAvrId());
                  this.transfertCompta.setTrfAgent(this.avoirEnteteVentes.getAvrNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.avoirEnteteVentes.getAvrDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.avoirEnteteVentes.getAvrDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.avoirEnteteVentes.getAvrDate()));
                  var11 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var8.get(var10)).getStkTaxe(), this.avoirEnteteVentes.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var11);
                  this.transfertCompta.setTrfDebitSaisie(((Stock)var8.get(var10)).getStkTva());
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneAvoirVentes(var6, var7, "");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneAvoirVentes(String var1, String var2, String var3) {
      if (this.optionVentes.getZoneRef1().equals("0")) {
         if (this.optionVentes.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrSerie() + ":" + this.avoirEnteteVentes.getAvrNum());
         } else if (this.optionVentes.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrNum());
         }
      } else if (this.optionVentes.getZoneRef1().equals("1")) {
         if (this.optionVentes.getPaiementAVOIR().equals("1")) {
            this.transfertCompta.setTrfReference1(var2);
         } else {
            this.transfertCompta.setTrfReference1(var1);
         }
      } else if (this.optionVentes.getZoneRef1().equals("2")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrAnal4());
      } else if (this.optionVentes.getZoneRef1().equals("11")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrInfo1());
      } else if (this.optionVentes.getZoneRef1().equals("12")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrInfo2());
      } else if (this.optionVentes.getZoneRef1().equals("13")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrInfo3());
      } else if (this.optionVentes.getZoneRef1().equals("14")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrInfo4());
      } else if (this.optionVentes.getZoneRef1().equals("15")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrInfo5());
      } else if (this.optionVentes.getZoneRef1().equals("16")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrInfo6());
      } else if (this.optionVentes.getZoneRef1().equals("17")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrInfo7());
      } else if (this.optionVentes.getZoneRef1().equals("18")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrInfo8());
      } else if (this.optionVentes.getZoneRef1().equals("19")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrInfo9());
      } else if (this.optionVentes.getZoneRef1().equals("20")) {
         this.transfertCompta.setTrfReference1(this.avoirEnteteVentes.getAvrInfo10());
      }

      if (this.optionVentes.getZoneRef2().equals("0")) {
         if (this.optionVentes.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrSerie() + ":" + this.avoirEnteteVentes.getAvrNum());
         } else if (this.optionVentes.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrNum());
         }
      } else if (this.optionVentes.getZoneRef2().equals("1")) {
         if (this.optionVentes.getPaiementAVOIR().equals("1")) {
            this.transfertCompta.setTrfReference2(var2);
         } else {
            this.transfertCompta.setTrfReference2(var1);
         }
      } else if (this.optionVentes.getZoneRef2().equals("2")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrAnal4());
      } else if (this.optionVentes.getZoneRef2().equals("3")) {
         if (this.optionVentes.getPaiementAVOIR().equals("1")) {
            this.transfertCompta.setTrfReference2(var2);
         } else {
            this.transfertCompta.setTrfReference2(var1);
         }
      } else if (this.optionVentes.getZoneRef2().equals("11")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrInfo1());
      } else if (this.optionVentes.getZoneRef2().equals("12")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrInfo2());
      } else if (this.optionVentes.getZoneRef2().equals("13")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrInfo3());
      } else if (this.optionVentes.getZoneRef2().equals("14")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrInfo4());
      } else if (this.optionVentes.getZoneRef2().equals("15")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrInfo5());
      } else if (this.optionVentes.getZoneRef2().equals("16")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrInfo6());
      } else if (this.optionVentes.getZoneRef2().equals("17")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrInfo7());
      } else if (this.optionVentes.getZoneRef2().equals("18")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrInfo8());
      } else if (this.optionVentes.getZoneRef2().equals("19")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrInfo9());
      } else if (this.optionVentes.getZoneRef2().equals("20")) {
         this.transfertCompta.setTrfReference2(this.avoirEnteteVentes.getAvrInfo10());
      }

      if (this.optionVentes.getZoneLibelle().equals("0")) {
         if (this.avoirEnteteVentes.getAvrDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.avoirEnteteVentes.getAvrDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.avoirEnteteVentes.getAvrNomTiers());
         }
      } else if (this.optionVentes.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.avoirEnteteVentes.getAvrObject());
      } else if (this.optionVentes.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.avoirEnteteVentes.getAvrObject() + " date " + this.utilDate.dateToStringFr(this.avoirEnteteVentes.getAvrDate()));
      } else if (this.optionVentes.getZoneLibelle().equals("3")) {
         if (var3 != null && !var3.isEmpty()) {
            if (this.avoirEnteteVentes.getAvrDiversTiers() == 99) {
               this.transfertCompta.setTrfLibelle(var3 + " " + this.avoirEnteteVentes.getAvrDiversNom());
            } else {
               this.transfertCompta.setTrfLibelle(var3 + " " + this.avoirEnteteVentes.getAvrNomTiers());
            }
         } else if (this.avoirEnteteVentes.getAvrDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.avoirEnteteVentes.getAvrDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.avoirEnteteVentes.getAvrNomTiers());
         }
      }

      if (this.optionVentes.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteVentes.getAvrObject());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("11")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteVentes.getAvrInfo1());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("12")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteVentes.getAvrInfo2());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("13")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteVentes.getAvrInfo3());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("14")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteVentes.getAvrInfo4());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("15")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteVentes.getAvrInfo5());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("16")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteVentes.getAvrInfo6());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("17")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteVentes.getAvrInfo7());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("18")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteVentes.getAvrInfo8());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("19")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteVentes.getAvrInfo9());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("20")) {
         this.transfertCompta.setTrfSuite(this.avoirEnteteVentes.getAvrInfo10());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueAvoirVentes() {
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.produits != null) {
         if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":") || this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
            if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":")) {
               var1 = this.produits.getProCle1().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
               var1 = this.produits.getProCle2().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         } else if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.produits.getProActivite());
            } else {
               var1 = this.produits.getProActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            }
         }

         if (this.famillesProduitsVentes != null) {
            if ((this.famillesProduitsVentes.getFamvteCle1() == null || this.famillesProduitsVentes.getFamvteCle1().isEmpty() || !this.famillesProduitsVentes.getFamvteCle1().contains(":")) && (this.famillesProduitsVentes.getFamvteCle2() == null || this.famillesProduitsVentes.getFamvteCle2().isEmpty() || !this.famillesProduitsVentes.getFamvteCle2().contains(":"))) {
               if (this.famillesProduitsVentes.getFamvteActivite() != null && !this.famillesProduitsVentes.getFamvteActivite().isEmpty() && this.famillesProduitsVentes.getFamvteActivite().contains(":") && (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty())) {
                  if (this.decoupageActivite) {
                     this.transfertCompta.setTrfActivite(this.transfertCompta.getTrfActivite());
                  } else {
                     var1 = this.famillesProduitsVentes.getFamvteActivite().split(":");
                     this.transfertCompta.setTrfActivite(var1[0]);
                  }
               }
            } else {
               if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && this.famillesProduitsVentes.getFamvteCle1() != null && !this.famillesProduitsVentes.getFamvteCle1().isEmpty() && this.famillesProduitsVentes.getFamvteCle1().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle1().split(":");
                  this.transfertCompta.setTrfRepartitionCle1(var1[0]);
               }

               if ((this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty()) && this.famillesProduitsVentes.getFamvteCle2() != null && !this.famillesProduitsVentes.getFamvteCle2().isEmpty() && this.famillesProduitsVentes.getFamvteCle2().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle2().split(":");
                  this.transfertCompta.setTrfRepartitionCle2(var1[0]);
               }
            }
         }
      }

      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty()) {
            if (this.avoirEnteteVentes.getAvrActivite() != null && !this.avoirEnteteVentes.getAvrActivite().isEmpty() && this.avoirEnteteVentes.getAvrActivite().contains(":") && this.avoirEnteteVentes.getAvrActivite().length() >= 3) {
               if (this.decoupageActivite) {
                  this.transfertCompta.setTrfActivite(this.avoirEnteteVentes.getAvrActivite());
               } else {
                  var1 = this.avoirEnteteVentes.getAvrActivite().split(":");
                  this.transfertCompta.setTrfActivite(var1[0]);
               }
            } else {
               this.transfertCompta.setTrfActivite(this.avoirEnteteVentes.getAvrActivite());
            }
         }

         if (this.avoirEnteteVentes.getAvrSite() != null && !this.avoirEnteteVentes.getAvrSite().isEmpty() && this.avoirEnteteVentes.getAvrSite().contains(":") && this.avoirEnteteVentes.getAvrSite().length() >= 3) {
            var1 = this.avoirEnteteVentes.getAvrSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.avoirEnteteVentes.getAvrSite());
         }

         if (this.avoirEnteteVentes.getAvrDepartement() != null && !this.avoirEnteteVentes.getAvrDepartement().isEmpty() && this.avoirEnteteVentes.getAvrDepartement().contains(":") && this.avoirEnteteVentes.getAvrDepartement().length() >= 3) {
            var1 = this.avoirEnteteVentes.getAvrDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.avoirEnteteVentes.getAvrDepartement());
         }

         if (this.avoirEnteteVentes.getAvrService() != null && !this.avoirEnteteVentes.getAvrService().isEmpty() && this.avoirEnteteVentes.getAvrService().contains(":") && this.avoirEnteteVentes.getAvrService().length() >= 3) {
            var1 = this.avoirEnteteVentes.getAvrService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.avoirEnteteVentes.getAvrService());
         }

         if (this.avoirEnteteVentes.getAvrRegion() != null && !this.avoirEnteteVentes.getAvrRegion().isEmpty() && this.avoirEnteteVentes.getAvrRegion().contains(":") && this.avoirEnteteVentes.getAvrRegion().length() >= 3) {
            var1 = this.avoirEnteteVentes.getAvrRegion().split(":");
            this.transfertCompta.setTrfRegion(var1[0]);
         } else {
            this.transfertCompta.setTrfRegion(this.avoirEnteteVentes.getAvrRegion());
         }

         if (this.avoirEnteteVentes.getAvrSecteur() != null && !this.avoirEnteteVentes.getAvrSecteur().isEmpty() && this.avoirEnteteVentes.getAvrSecteur().contains(":") && this.avoirEnteteVentes.getAvrSecteur().length() >= 3) {
            var1 = this.avoirEnteteVentes.getAvrSecteur().split(":");
            this.transfertCompta.setTrfSecteur(var1[0]);
         } else {
            this.transfertCompta.setTrfSecteur(this.avoirEnteteVentes.getAvrSecteur());
         }

         if (this.avoirEnteteVentes.getAvrAnal4() != null && !this.avoirEnteteVentes.getAvrAnal4().isEmpty() && this.avoirEnteteVentes.getAvrAnal4().contains(":") && this.avoirEnteteVentes.getAvrAnal4().length() >= 3) {
            var1 = this.avoirEnteteVentes.getAvrAnal4().split(":");
            this.transfertCompta.setTrfDossier(var1[0]);
         } else {
            this.transfertCompta.setTrfDossier(this.avoirEnteteVentes.getAvrAnal4());
         }

         if (this.avoirEnteteVentes.getAvrAnal2() != null && !this.avoirEnteteVentes.getAvrAnal2().isEmpty() && this.avoirEnteteVentes.getAvrAnal2().contains(":") && this.avoirEnteteVentes.getAvrAnal2().length() >= 3) {
            var1 = this.avoirEnteteVentes.getAvrAnal2().split(":");
            this.transfertCompta.setTrfParc(var1[0]);
         } else {
            this.transfertCompta.setTrfParc(this.avoirEnteteVentes.getAvrAnal2());
         }

         if (this.avoirEnteteVentes.getAvrBudget() != null && !this.avoirEnteteVentes.getAvrBudget().isEmpty() && this.avoirEnteteVentes.getAvrBudget().contains(":") && this.avoirEnteteVentes.getAvrBudget().length() >= 3) {
            var1 = this.avoirEnteteVentes.getAvrBudget().split(":");
            this.transfertCompta.setTrfBudget(var1[0]);
         } else {
            this.transfertCompta.setTrfBudget(this.avoirEnteteVentes.getAvrBudget());
         }

         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfDossier("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
      }

   }

   public void traitementNoteDebitVentes(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.pourParapheur(var1.getDocId(), var3);
      if (this.noteDebitEnteteVentes != null) {
         String var4 = "" + (this.noteDebitEnteteVentes.getNdbDate().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(27, this.noteDebitEnteteVentes.getNdbSerie(), var4, var3);
         String var6 = "";
         if (var5 != null && !var5.isEmpty() && this.noteDebitEnteteVentes.getTiers().getTietransfertCpte() == 0) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("27");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(27);
            this.transfertCompta.setTrfIdOrigine(this.noteDebitEnteteVentes.getNdbId());
            this.transfertCompta.setTrfAgent(this.noteDebitEnteteVentes.getNdbNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.noteDebitEnteteVentes.getNdbDate());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.noteDebitEnteteVentes.getNdbDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.noteDebitEnteteVentes.getNdbDate()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.noteDebitEnteteVentes.getTiers().getTieid(), var3));
            this.transfertCompta.setTrfDebitSaisie(this.noteDebitEnteteVentes.getNdbTotTtc() + this.noteDebitEnteteVentes.getNdbTotTc());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance(this.noteDebitEnteteVentes.getNdbDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneNoteDebitVentes(var6);
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            if (this.noteDebitEnteteVentes.getNdbTotTc() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("27");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(27);
               this.transfertCompta.setTrfIdOrigine(this.noteDebitEnteteVentes.getNdbId());
               this.transfertCompta.setTrfAgent(this.noteDebitEnteteVentes.getNdbNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.noteDebitEnteteVentes.getNdbDate());
               this.transfertCompta.setTrfCode(var5);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.noteDebitEnteteVentes.getNdbDate()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.noteDebitEnteteVentes.getNdbDate()));
               this.transfertCompta.setTrfCompte(var2);
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.noteDebitEnteteVentes.getNdbTotTc());
               this.transfertCompta.setTrfDateEcheance(this.noteDebitEnteteVentes.getNdbDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneNoteDebitVentes(var6);
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            ArrayList var7 = new ArrayList();
            new ArrayList();
            List var8 = this.noteDebitLigneVentesDao.chargerLesLignes(this.noteDebitEnteteVentes, var3);
            int var9;
            String var10;
            if (var8.size() != 0) {
               for(var9 = 0; var9 < var8.size(); ++var9) {
                  this.noteDebitLigneVentes = new NoteDebitLigneVentes();
                  this.noteDebitLigneVentes = (NoteDebitLigneVentes)var8.get(var9);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("27");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(27);
                  this.transfertCompta.setTrfIdOrigine(this.noteDebitEnteteVentes.getNdbId());
                  this.transfertCompta.setTrfAgent(this.noteDebitEnteteVentes.getNdbNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.noteDebitEnteteVentes.getNdbDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.noteDebitEnteteVentes.getNdbDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.noteDebitEnteteVentes.getNdbDate()));
                  var10 = this.formTransfertCtrl.calculeCompteProduitVentes(this.noteDebitEnteteVentes.getNdbExoTva(), this.noteDebitEnteteVentes.getNdbTotTva(), this.noteDebitLigneVentes.getNdbligCode(), this.noteDebitEnteteVentes.getTiers().getTiecodepays(), this.noteDebitEnteteVentes.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var10);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.noteDebitLigneVentes.getNdbligPt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneNoteDebitVentes(var6);
                  boolean var11 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var3);
                  if (var11) {
                     this.analytiqueNoteDebitVentes();
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var12 = new Stock();
                  var12.setStkTva(this.noteDebitLigneVentes.getNdbligTva());
                  var12.setStkTaxe(this.noteDebitLigneVentes.getNdbligTaxe());
                  var7.add(var12);
               }
            }

            if (var7.size() != 0) {
               for(var9 = 0; var9 < var7.size(); ++var9) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("27");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(27);
                  this.transfertCompta.setTrfIdOrigine(this.noteDebitEnteteVentes.getNdbId());
                  this.transfertCompta.setTrfAgent(this.noteDebitEnteteVentes.getNdbNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.noteDebitEnteteVentes.getNdbDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.noteDebitEnteteVentes.getNdbDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.noteDebitEnteteVentes.getNdbDate()));
                  var10 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var7.get(var9)).getStkTaxe(), this.noteDebitEnteteVentes.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var10);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var7.get(var9)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneNoteDebitVentes(var6);
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneNoteDebitVentes(String var1) {
      if (this.optionVentes.getZoneRef1().equals("0")) {
         if (this.optionVentes.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbSerie() + ":" + this.noteDebitEnteteVentes.getNdbNum());
         } else if (this.optionVentes.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbNum());
         }
      } else if (this.optionVentes.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1(var1);
      } else if (this.optionVentes.getZoneRef1().equals("2")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbAnal4());
      } else if (this.optionVentes.getZoneRef1().equals("11")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbInfo1());
      } else if (this.optionVentes.getZoneRef1().equals("12")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbInfo2());
      } else if (this.optionVentes.getZoneRef1().equals("13")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbInfo3());
      } else if (this.optionVentes.getZoneRef1().equals("14")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbInfo4());
      } else if (this.optionVentes.getZoneRef1().equals("15")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbInfo5());
      } else if (this.optionVentes.getZoneRef1().equals("16")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbInfo6());
      } else if (this.optionVentes.getZoneRef1().equals("17")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbInfo7());
      } else if (this.optionVentes.getZoneRef1().equals("18")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbInfo8());
      } else if (this.optionVentes.getZoneRef1().equals("19")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbInfo9());
      } else if (this.optionVentes.getZoneRef1().equals("20")) {
         this.transfertCompta.setTrfReference1(this.noteDebitEnteteVentes.getNdbInfo10());
      }

      if (this.optionVentes.getZoneRef2().equals("0")) {
         if (this.optionVentes.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbSerie() + ":" + this.noteDebitEnteteVentes.getNdbNum());
         } else if (this.optionVentes.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbNum());
         }
      } else if (this.optionVentes.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2(var1);
      } else if (this.optionVentes.getZoneRef2().equals("2")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbAnal4());
      } else if (this.optionVentes.getZoneRef2().equals("11")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbInfo1());
      } else if (this.optionVentes.getZoneRef2().equals("12")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbInfo2());
      } else if (this.optionVentes.getZoneRef2().equals("13")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbInfo3());
      } else if (this.optionVentes.getZoneRef2().equals("14")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbInfo4());
      } else if (this.optionVentes.getZoneRef2().equals("15")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbInfo5());
      } else if (this.optionVentes.getZoneRef2().equals("16")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbInfo6());
      } else if (this.optionVentes.getZoneRef2().equals("17")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbInfo7());
      } else if (this.optionVentes.getZoneRef2().equals("18")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbInfo8());
      } else if (this.optionVentes.getZoneRef2().equals("19")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbInfo9());
      } else if (this.optionVentes.getZoneRef2().equals("20")) {
         this.transfertCompta.setTrfReference2(this.noteDebitEnteteVentes.getNdbInfo10());
      }

      if (this.optionVentes.getZoneLibelle().equals("0")) {
         if (this.factureEnteteVentes.getFacDiversTiers() == 99) {
            this.transfertCompta.setTrfLibelle(this.noteDebitEnteteVentes.getNdbDiversNom());
         } else {
            this.transfertCompta.setTrfLibelle(this.noteDebitEnteteVentes.getNdbNomTiers());
         }
      } else if (this.optionVentes.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.noteDebitEnteteVentes.getNdbObject());
      } else if (this.optionVentes.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.noteDebitEnteteVentes.getNdbObject() + " date " + this.utilDate.dateToStringFr(this.noteDebitEnteteVentes.getNdbDate()));
      }

      if (this.optionVentes.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteVentes.getNdbObject());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("11")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteVentes.getNdbInfo1());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("12")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteVentes.getNdbInfo2());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("13")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteVentes.getNdbInfo3());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("14")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteVentes.getNdbInfo4());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("15")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteVentes.getNdbInfo5());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("16")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteVentes.getNdbInfo6());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("17")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteVentes.getNdbInfo7());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("18")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteVentes.getNdbInfo8());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("19")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteVentes.getNdbInfo9());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("20")) {
         this.transfertCompta.setTrfSuite(this.noteDebitEnteteVentes.getNdbInfo10());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueNoteDebitVentes() {
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.produits != null) {
         if ((this.produits.getProCle1() == null || this.produits.getProCle1().isEmpty() || !this.produits.getProCle1().contains(":")) && (this.produits.getProCle2() == null || this.produits.getProCle2().isEmpty() || !this.produits.getProCle2().contains(":"))) {
            if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty() && this.produits.getProActivite().contains(":")) {
               if (this.decoupageActivite) {
                  this.transfertCompta.setTrfActivite(this.produits.getProActivite());
               } else {
                  var1 = this.produits.getProActivite().split(":");
                  this.transfertCompta.setTrfActivite(var1[0]);
               }
            }
         } else {
            if (this.produits.getProCle1() != null && !this.produits.getProCle1().isEmpty() && this.produits.getProCle1().contains(":")) {
               var1 = this.produits.getProCle1().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.produits.getProCle2() != null && !this.produits.getProCle2().isEmpty() && this.produits.getProCle2().contains(":")) {
               var1 = this.produits.getProCle2().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         }

         if (this.famillesProduitsVentes != null) {
            if ((this.famillesProduitsVentes.getFamvteCle1() == null || this.famillesProduitsVentes.getFamvteCle1().isEmpty() || !this.famillesProduitsVentes.getFamvteCle1().contains(":")) && (this.famillesProduitsVentes.getFamvteCle2() == null || this.famillesProduitsVentes.getFamvteCle2().isEmpty() || !this.famillesProduitsVentes.getFamvteCle2().contains(":"))) {
               if (this.famillesProduitsVentes.getFamvteActivite() != null && !this.famillesProduitsVentes.getFamvteActivite().isEmpty() && this.famillesProduitsVentes.getFamvteActivite().contains(":")) {
                  if (this.decoupageActivite) {
                     this.transfertCompta.setTrfActivite(this.famillesProduitsVentes.getFamvteActivite());
                  } else if (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty()) {
                     var1 = this.famillesProduitsVentes.getFamvteActivite().split(":");
                     this.transfertCompta.setTrfActivite(var1[0]);
                  }
               }
            } else {
               if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && this.famillesProduitsVentes.getFamvteCle1() != null && !this.famillesProduitsVentes.getFamvteCle1().isEmpty() && this.famillesProduitsVentes.getFamvteCle1().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle1().split(":");
                  this.transfertCompta.setTrfRepartitionCle1(var1[0]);
               }

               if ((this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty()) && this.famillesProduitsVentes.getFamvteCle2() != null && !this.famillesProduitsVentes.getFamvteCle2().isEmpty() && this.famillesProduitsVentes.getFamvteCle2().contains(":")) {
                  var1 = this.famillesProduitsVentes.getFamvteCle2().split(":");
                  this.transfertCompta.setTrfRepartitionCle2(var1[0]);
               }
            }
         }
      }

      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty()) {
            if (this.noteDebitEnteteVentes.getNdbActivite() != null && !this.noteDebitEnteteVentes.getNdbActivite().isEmpty() && this.noteDebitEnteteVentes.getNdbActivite().contains(":") && this.noteDebitEnteteVentes.getNdbActivite().length() >= 3) {
               if (this.decoupageActivite) {
                  this.transfertCompta.setTrfActivite(this.noteDebitEnteteVentes.getNdbActivite());
               } else {
                  var1 = this.noteDebitEnteteVentes.getNdbActivite().split(":");
                  this.transfertCompta.setTrfActivite(var1[0]);
               }
            } else {
               this.transfertCompta.setTrfActivite(this.noteDebitEnteteVentes.getNdbActivite());
            }
         }

         if (this.noteDebitEnteteVentes.getNdbSite() != null && !this.noteDebitEnteteVentes.getNdbSite().isEmpty() && this.noteDebitEnteteVentes.getNdbSite().contains(":") && this.noteDebitEnteteVentes.getNdbSite().length() >= 3) {
            var1 = this.noteDebitEnteteVentes.getNdbSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.noteDebitEnteteVentes.getNdbSite());
         }

         if (this.noteDebitEnteteVentes.getNdbDepartement() != null && !this.noteDebitEnteteVentes.getNdbDepartement().isEmpty() && this.noteDebitEnteteVentes.getNdbDepartement().contains(":") && this.noteDebitEnteteVentes.getNdbDepartement().length() >= 3) {
            var1 = this.noteDebitEnteteVentes.getNdbDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.noteDebitEnteteVentes.getNdbDepartement());
         }

         if (this.noteDebitEnteteVentes.getNdbService() != null && !this.noteDebitEnteteVentes.getNdbService().isEmpty() && this.noteDebitEnteteVentes.getNdbService().contains(":") && this.noteDebitEnteteVentes.getNdbService().length() >= 3) {
            var1 = this.noteDebitEnteteVentes.getNdbService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.noteDebitEnteteVentes.getNdbService());
         }

         if (this.noteDebitEnteteVentes.getNdbRegion() != null && !this.noteDebitEnteteVentes.getNdbRegion().isEmpty() && this.noteDebitEnteteVentes.getNdbRegion().contains(":") && this.noteDebitEnteteVentes.getNdbRegion().length() >= 3) {
            var1 = this.noteDebitEnteteVentes.getNdbRegion().split(":");
            this.transfertCompta.setTrfRegion(var1[0]);
         } else {
            this.transfertCompta.setTrfRegion(this.noteDebitEnteteVentes.getNdbRegion());
         }

         if (this.noteDebitEnteteVentes.getNdbSecteur() != null && !this.noteDebitEnteteVentes.getNdbSecteur().isEmpty() && this.noteDebitEnteteVentes.getNdbSecteur().contains(":") && this.noteDebitEnteteVentes.getNdbSecteur().length() >= 3) {
            var1 = this.noteDebitEnteteVentes.getNdbSecteur().split(":");
            this.transfertCompta.setTrfSecteur(var1[0]);
         } else {
            this.transfertCompta.setTrfSecteur(this.noteDebitEnteteVentes.getNdbSecteur());
         }

         if (this.noteDebitEnteteVentes.getNdbAnal4() != null && !this.noteDebitEnteteVentes.getNdbAnal4().isEmpty() && this.noteDebitEnteteVentes.getNdbAnal4().contains(":") && this.noteDebitEnteteVentes.getNdbAnal4().length() >= 3) {
            var1 = this.noteDebitEnteteVentes.getNdbAnal4().split(":");
            this.transfertCompta.setTrfDossier(var1[0]);
         } else {
            this.transfertCompta.setTrfDossier(this.noteDebitEnteteVentes.getNdbAnal4());
         }

         if (this.noteDebitEnteteVentes.getNdbAnal2() != null && !this.noteDebitEnteteVentes.getNdbAnal2().isEmpty() && this.noteDebitEnteteVentes.getNdbAnal2().contains(":") && this.noteDebitEnteteVentes.getNdbAnal2().length() >= 3) {
            var1 = this.noteDebitEnteteVentes.getNdbAnal2().split(":");
            this.transfertCompta.setTrfParc(var1[0]);
         } else {
            this.transfertCompta.setTrfParc(this.noteDebitEnteteVentes.getNdbAnal2());
         }

         if (this.noteDebitEnteteVentes.getNdbBudget() != null && !this.noteDebitEnteteVentes.getNdbBudget().isEmpty() && this.noteDebitEnteteVentes.getNdbBudget().contains(":") && this.noteDebitEnteteVentes.getNdbBudget().length() >= 3) {
            var1 = this.noteDebitEnteteVentes.getNdbBudget().split(":");
            this.transfertCompta.setTrfBudget(var1[0]);
         } else {
            this.transfertCompta.setTrfBudget(this.noteDebitEnteteVentes.getNdbBudget());
         }

         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfDossier("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
      }

   }

   public void transfertImmobilier(List var1) throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      this.init();
      this.listeDocumentTransfert = var1;
      this.objetPays = new ObjetPays();
      this.lecturePays = new LecturePays();
      this.listPays = this.lecturePays.getMespays();
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentes = new TaxesVentes();
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.bienFacture = new BienFacture();
      this.bienFactureDao = new BienFactureDao(this.baseLog, this.utilInitHibernate);
      this.lesTransfertCompta.clear();
      this.lesTransfertErreur.clear();
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      this.optionVentes = var2.lancer();
      if (this.optionVentes.getDecrmtPrsChrStock() == null) {
         this.optionVentes.setDecrmtPrsChrStock("");
      }

      String var3 = "";
      new ArrayList();
      List var4 = this.taxesVentesDao.selectActifTaxes(0L, (Session)null);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            if (((TaxesVentes)var4.get(var5)).getTaxvteTc() != 0 && ((TaxesVentes)var4.get(var5)).getTaxvteCompte() != null && !((TaxesVentes)var4.get(var5)).getTaxvteCompte().isEmpty()) {
               var3 = ((TaxesVentes)var4.get(var5)).getTaxvteCompte();
               break;
            }
         }
      }

      if (this.listeDocumentTransfert.size() != 0) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.documentEntete = new DocumentEntete();

         for(int var6 = 0; var6 < this.listeDocumentTransfert.size(); ++var6) {
            this.documentEntete = (DocumentEntete)this.listeDocumentTransfert.get(var6);
            if (this.documentEntete.isDocSelect() && this.documentEntete.getDocNature() == 165) {
               this.traitementFactureImmobilier(this.documentEntete, var3, var7);
            }
         }

         this.utilInitHibernate.closeSession();
         this.optimisationResultat(this.optionComptabilite.getTrf_cpteVentes());
      }

      this.var_showBarProg = false;
   }

   public void traitementFactureImmobilier(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.bienFacture = this.bienFactureDao.pourParapheur(var1.getDocId(), var3);
      if (this.bienFacture != null) {
         float var4 = 0.0F;
         if (this.bienFacture.getBiefacRegTmp() == this.bienFacture.getBiefacTotTtc()) {
            var4 = 1.0F;
         } else {
            var4 = (float)(this.bienFacture.getBiefacRegTmp() / this.bienFacture.getBiefacTotTtc());
         }

         new Tiers();
         String var6 = "" + (this.bienFacture.getBiefacDateDebut().getYear() + 1900);
         String var7 = this.formTransfertCtrl.calculeJournalSerie(165, this.bienFacture.getBiefacSerie(), var6, var3);
         String var8 = this.formTransfertCtrl.calculeJournalSerieOD(165, this.bienFacture.getBiefacSerie(), var6, var3);
         String var9 = "";
         String var10 = "";
         if (var7 != null && !var7.isEmpty() && this.bienFacture.getTiers().getTietransfertCpte() == 0) {
            var9 = this.bienFacture.getBiefacBail();
            var10 = this.bienFacture.getBiefacBien();
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("165");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(165);
            this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
            this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
            this.transfertCompta.setTrfCode(var7);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var7, this.bienFacture.getBiefacDateDebut()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.bienFacture.getTiers().getTieid(), var3));
            this.transfertCompta.setTrfDebitSaisie(this.utilNombre.myRoundDevise((this.bienFacture.getBiefacTotTtc() + this.bienFacture.getBiefacTotTc()) * (double)var4, this.structureLog.getStrdevise()));
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneFactureImmobilier("", var9, var10, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("165");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(165);
            this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
            this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
            this.transfertCompta.setTrfCode(var7);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var7, this.bienFacture.getBiefacDateDebut()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.bienFacture.getBiefacIdProprietaire(), var3));
            this.transfertCompta.setTrfDebitSaisie(0.0D);
            this.transfertCompta.setTrfCreditSaisie(this.utilNombre.myRoundDevise((this.bienFacture.getBiefacTotTtc() + this.bienFacture.getBiefacTotTc()) * (double)var4, this.structureLog.getStrdevise()));
            this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneFactureImmobilier("", var9, var10, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }
         }

         if (var8 != null && !var8.isEmpty() && this.bienFacture.getTiers().getTietransfertCpte() == 0) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("165");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(165);
            this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
            this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
            this.transfertCompta.setTrfCode(var8);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var8, this.bienFacture.getBiefacDateDebut()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteTiers(this.bienFacture.getBiefacIdProprietaire(), var3));
            this.transfertCompta.setTrfDebitSaisie(this.utilNombre.myRoundDevise((this.bienFacture.getBiefacTotTtc() + this.bienFacture.getBiefacTotTc()) * (double)var4, this.structureLog.getStrdevise()));
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneFactureImmobilier("TTC ", var9, var10, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("165");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(165);
            this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
            this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
            this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
            this.transfertCompta.setTrfCode(var8);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var8, this.bienFacture.getBiefacDateDebut()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
            this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteProprietaire(this.bienFacture.getBiefacIdProprietaire(), var3));
            this.transfertCompta.setTrfDebitSaisie(0.0D);
            this.transfertCompta.setTrfCreditSaisie(this.utilNombre.myRoundDevise(this.bienFacture.getBiefacLoyerBrut() * (double)var4, this.structureLog.getStrdevise()));
            this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneFactureImmobilier("Loyer brut ", var9, var10, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            if (this.bienFacture.getBiefacTom() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("165");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(165);
               this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
               this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
               this.transfertCompta.setTrfCode(var8);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var8, this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteProprietaire(this.bienFacture.getBiefacIdProprietaire(), var3));
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.utilNombre.myRoundDevise(this.bienFacture.getBiefacTom() * (double)var4, this.structureLog.getStrdevise()));
               this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneFactureImmobilier("TOM ", var9, var10, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            if (this.bienFacture.getBiefacChargesImmeuble() + this.bienFacture.getBiefacDiversFrais() + this.bienFacture.getBiefacEau() + this.bienFacture.getBiefacElectricite() + this.bienFacture.getBiefacFraisComplement() + this.bienFacture.getBiefacGardiennage() + this.bienFacture.getBiefacGroupeElectro() + this.bienFacture.getBiefacJardinnier() + this.bienFacture.getBiefacParking() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("165");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(165);
               this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
               this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
               this.transfertCompta.setTrfCode(var8);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var8, this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompte47Proprietaire(this.bienFacture.getBiefacIdProprietaire(), var3));
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.utilNombre.myRoundDevise((this.bienFacture.getBiefacChargesImmeuble() + this.bienFacture.getBiefacDiversFrais() + this.bienFacture.getBiefacEau() + this.bienFacture.getBiefacElectricite() + this.bienFacture.getBiefacFraisComplement() + this.bienFacture.getBiefacGardiennage() + this.bienFacture.getBiefacGroupeElectro() + this.bienFacture.getBiefacJardinnier() + this.bienFacture.getBiefacParking()) * (double)var4, this.structureLog.getStrdevise()));
               this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneFactureImmobilier("Charges ", var9, var10, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            if (this.bienFacture.getBiefacTotTva() != 0.0D && this.bienFacture.getBiefacIdProprietaire() != 0L) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("165");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(165);
               this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
               this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
               this.transfertCompta.setTrfCode(var8);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var8, this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
               Tiers var5 = this.tiersDao.selectTierD(this.bienFacture.getBiefacIdProprietaire(), var3);
               if (var5 != null) {
                  if (var5.getTieDeclarationTva() == 3) {
                     if (this.optionComptabilite.getExportOd().equals("1") && this.tiers.getTiecompteSage() != null && !this.tiers.getTiecompteSage().isEmpty()) {
                        this.transfertCompta.setTrfCompte(var5.getTiecompte0() + ":" + var5.getTiecompteSage());
                     } else {
                        this.transfertCompta.setTrfCompte(var5.getTiecompte0());
                     }
                  } else if (var5.getTienum1() != null && !var5.getTienum1().isEmpty()) {
                     this.transfertCompta.setTrfCompte("4431000");
                  } else {
                     this.transfertCompta.setTrfCompte("4431009");
                  }
               } else {
                  this.transfertCompta.setTrfCompte("4431009");
               }

               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.utilNombre.myRoundDevise(this.bienFacture.getBiefacTotTva() * (double)var4, this.structureLog.getStrdevise()));
               this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneFactureImmobilier("Tva ", var9, var10, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            if (this.bienFacture.getBiefacTotalCom() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("165");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(165);
               this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
               this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
               this.transfertCompta.setTrfCode(var8);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var8, this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfCompte("7061200");
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.utilNombre.myRoundDevise(this.bienFacture.getBiefacTotalCom() * (double)var4, this.structureLog.getStrdevise()));
               this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneFactureImmobilier("Commission ", var9, var10, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }

               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("165");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(165);
               this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
               this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
               this.transfertCompta.setTrfCode(var8);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var8, this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompte407Proprietaire(this.bienFacture.getBiefacIdProprietaire(), var3));
               this.transfertCompta.setTrfDebitSaisie(this.utilNombre.myRoundDevise((this.bienFacture.getBiefacTotalCom() + this.bienFacture.getBiefacTvaCom()) * (double)var4, this.structureLog.getStrdevise()));
               this.transfertCompta.setTrfCreditSaisie(0.0D);
               this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneFactureImmobilier("Commission TTC ", var9, var10, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            if (this.bienFacture.getBiefacTvaCom() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("165");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(165);
               this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
               this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
               this.transfertCompta.setTrfCode(var8);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var8, this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfCompte("443210");
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.utilNombre.myRoundDevise(this.bienFacture.getBiefacTvaCom() * (double)var4, this.structureLog.getStrdevise()));
               this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneFactureImmobilier("Tva/Com.", var9, var10, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            if (this.bienFacture.getBiefacTotalIrpp() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("165");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(165);
               this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
               this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
               this.transfertCompta.setTrfCode(var8);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var8, this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompte449Proprietaire(this.bienFacture.getBiefacIdProprietaire(), var3));
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.utilNombre.myRoundDevise(this.bienFacture.getBiefacTotalIrpp() * (double)var4, this.structureLog.getStrdevise()));
               this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneFactureImmobilier("Irpp ", var9, var10, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }

               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("165");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(165);
               this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
               this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
               this.transfertCompta.setTrfCode(var8);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var8, this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfCompte(this.formTransfertCtrl.calculeCompteProprietaire(this.bienFacture.getBiefacIdProprietaire(), var3));
               this.transfertCompta.setTrfDebitSaisie(this.utilNombre.myRoundDevise(this.bienFacture.getBiefacTotalIrpp() * (double)var4, this.structureLog.getStrdevise()));
               this.transfertCompta.setTrfCreditSaisie(0.0D);
               this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneFactureImmobilier("Irpp ", var9, var10, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }

            if (this.bienFacture.getBiefacTlv() != 0.0D) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("165");
               this.transfertCompta.setTrfCategorie(0);
               this.transfertCompta.setTrfNature(165);
               this.transfertCompta.setTrfIdOrigine(this.bienFacture.getBiefacId());
               this.transfertCompta.setTrfAgent(this.bienFacture.getBiefacNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.bienFacture.getBiefacDateDebut());
               this.transfertCompta.setTrfCode(var8);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var8, this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bienFacture.getBiefacDateDebut()));
               this.transfertCompta.setTrfCompte("4490000");
               this.transfertCompta.setTrfDebitSaisie(0.0D);
               this.transfertCompta.setTrfCreditSaisie(this.utilNombre.myRoundDevise(this.bienFacture.getBiefacTlv() * (double)var4, this.structureLog.getStrdevise()));
               this.transfertCompta.setTrfDateEcheance(this.bienFacture.getBiefacDateEcheReg());
               this.transfertCompta.setTrfDateValeurTheo((Date)null);
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneFactureImmobilier("Tlv ", var9, var10, "");
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }
            }
         }
      }

   }

   public void calculeZoneFactureImmobilier(String var1, String var2, String var3, String var4) {
      if (this.optionVentes.getZoneRef1().equals("0")) {
         if (this.optionVentes.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacSerie() + ":" + this.bienFacture.getBiefacNum());
         } else if (this.optionVentes.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacNum());
         }
      } else if (this.optionVentes.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1(var2);
      } else if (!this.optionVentes.getZoneRef1().equals("2")) {
         if (this.optionVentes.getZoneRef1().equals("11")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacInfo1());
         } else if (this.optionVentes.getZoneRef1().equals("12")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacInfo2());
         } else if (this.optionVentes.getZoneRef1().equals("13")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacInfo3());
         } else if (this.optionVentes.getZoneRef1().equals("14")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacInfo4());
         } else if (this.optionVentes.getZoneRef1().equals("15")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacInfo5());
         } else if (this.optionVentes.getZoneRef1().equals("16")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacInfo6());
         } else if (this.optionVentes.getZoneRef1().equals("17")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacInfo7());
         } else if (this.optionVentes.getZoneRef1().equals("18")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacInfo8());
         } else if (this.optionVentes.getZoneRef1().equals("19")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacInfo9());
         } else if (this.optionVentes.getZoneRef1().equals("20")) {
            this.transfertCompta.setTrfReference1(this.bienFacture.getBiefacInfo10());
         }
      }

      if (this.optionVentes.getZoneRef2().equals("0")) {
         if (this.optionVentes.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacSerie() + ":" + this.bienFacture.getBiefacNum());
         } else if (this.optionVentes.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacNum());
         }
      } else if (this.optionVentes.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2(var2);
      } else if (!this.optionVentes.getZoneRef2().equals("2")) {
         if (this.optionVentes.getZoneRef2().equals("3")) {
            this.transfertCompta.setTrfReference2(var3);
         } else if (this.optionVentes.getZoneRef2().equals("11")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacInfo1());
         } else if (this.optionVentes.getZoneRef2().equals("12")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacInfo2());
         } else if (this.optionVentes.getZoneRef2().equals("13")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacInfo3());
         } else if (this.optionVentes.getZoneRef2().equals("14")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacInfo4());
         } else if (this.optionVentes.getZoneRef2().equals("15")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacInfo5());
         } else if (this.optionVentes.getZoneRef2().equals("16")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacInfo6());
         } else if (this.optionVentes.getZoneRef2().equals("17")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacInfo7());
         } else if (this.optionVentes.getZoneRef2().equals("18")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacInfo8());
         } else if (this.optionVentes.getZoneRef2().equals("19")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacInfo9());
         } else if (this.optionVentes.getZoneRef2().equals("20")) {
            this.transfertCompta.setTrfReference2(this.bienFacture.getBiefacInfo10());
         }
      }

      if (this.optionVentes.getZoneLibelle().equals("0")) {
         if (this.transfertCompta.getTrfCompte().contains(":45")) {
            this.transfertCompta.setTrfLibelle(var1 + this.bienFacture.getBiefacNomProprietaire());
         } else {
            this.transfertCompta.setTrfLibelle(var1 + this.bienFacture.getBiefacNomTiers());
         }
      } else if (this.optionVentes.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(var1 + this.bienFacture.getBiefacObject());
      } else if (this.optionVentes.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(var1 + this.bienFacture.getBiefacObject() + " date " + this.utilDate.dateToStringFr(this.bienFacture.getBiefacDate()));
      } else if (this.optionVentes.getZoneLibelle().equals("3")) {
         if (var4 != null && !var4.isEmpty()) {
            if (this.transfertCompta.getTrfCompte().startsWith("45")) {
               this.transfertCompta.setTrfLibelle(var1 + var4 + " " + this.bienFacture.getBiefacNomTiers());
            } else {
               this.transfertCompta.setTrfLibelle(var1 + var4 + " " + this.bienFacture.getBiefacNomTiers());
            }
         } else if (this.transfertCompta.getTrfCompte().contains(":45")) {
            this.transfertCompta.setTrfLibelle(var1 + this.bienFacture.getBiefacNomProprietaire());
         } else {
            this.transfertCompta.setTrfLibelle(var1 + this.bienFacture.getBiefacNomTiers());
         }
      } else if (this.optionVentes.getZoneLibelle().equals("4")) {
         if (this.transfertCompta.getTrfCode().equals("60")) {
            this.transfertCompta.setTrfLibelle(var1 + "Loyer " + this.bienFacture.getBiefacObject() + " " + this.bienFacture.getBiefacNomTiers());
         } else if (this.transfertCompta.getTrfCompte().startsWith("45")) {
            this.transfertCompta.setTrfLibelle(var1 + var4 + " " + this.bienFacture.getBiefacObject() + " " + this.bienFacture.getBiefacNomProprietaire());
         } else {
            this.transfertCompta.setTrfLibelle(var1 + var4 + " " + this.bienFacture.getBiefacObject() + " " + this.bienFacture.getBiefacNomTiers());
         }
      }

      if (this.optionVentes.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.bienFacture.getBiefacObject());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("11")) {
         this.transfertCompta.setTrfSuite(this.bienFacture.getBiefacInfo1());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("12")) {
         this.transfertCompta.setTrfSuite(this.bienFacture.getBiefacInfo2());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("13")) {
         this.transfertCompta.setTrfSuite(this.bienFacture.getBiefacInfo3());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("14")) {
         this.transfertCompta.setTrfSuite(this.bienFacture.getBiefacInfo4());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("15")) {
         this.transfertCompta.setTrfSuite(this.bienFacture.getBiefacInfo5());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("16")) {
         this.transfertCompta.setTrfSuite(this.bienFacture.getBiefacInfo6());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("17")) {
         this.transfertCompta.setTrfSuite(this.bienFacture.getBiefacInfo7());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("18")) {
         this.transfertCompta.setTrfSuite(this.bienFacture.getBiefacInfo8());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("19")) {
         this.transfertCompta.setTrfSuite(this.bienFacture.getBiefacInfo9());
      } else if (this.optionVentes.getZoneLibelleSuite().equals("20")) {
         this.transfertCompta.setTrfSuite(this.bienFacture.getBiefacInfo10());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void analytiqueFactureImmobilier() {
   }

   public void transfertMedical(List var1) throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      this.init();
      this.listeDocumentTransfert = var1;
      this.objetPays = new ObjetPays();
      this.lecturePays = new LecturePays();
      this.listPays = this.lecturePays.getMespays();
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.produits = new Produits();
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentes = new TaxesVentes();
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentes = new FamillesProduitsVentes();
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.consultationEnteteGeneDao = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      this.consultationActesDao = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
      this.pharmacieEnteteDao = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      this.pharmacieLigneDao = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireEnteteDao = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireLigneDao = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationEnteteDao = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationActesDao = new HospitalisationActesDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationLaboDao = new HospitalisationLaboDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationMediDao = new HospitalisationMediDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationPrestDao = new HospitalisationPrestDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationSejourDao = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteMedicalDao = new FactureEnteteMedicalDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneMedicalDao = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
      this.lesTransfertCompta.clear();
      this.lesTransfertErreur.clear();
      this.optionMedical = new OptionMedical();
      LireLesoptionsMedical var2 = new LireLesoptionsMedical();
      var2.setStrId(this.structureLog.getStrid());
      this.optionMedical = var2.lancer();
      String var3 = "";
      new ArrayList();
      List var4 = this.taxesVentesDao.selectActifTaxes(0L, (Session)null);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            if (((TaxesVentes)var4.get(var5)).getTaxvteTc() != 0 && ((TaxesVentes)var4.get(var5)).getTaxvteCompte() != null && !((TaxesVentes)var4.get(var5)).getTaxvteCompte().isEmpty()) {
               var3 = ((TaxesVentes)var4.get(var5)).getTaxvteCompte();
               break;
            }
         }
      }

      if (this.listeDocumentTransfert.size() != 0) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         this.documentEntete = new DocumentEntete();

         for(int var6 = 0; var6 < this.listeDocumentTransfert.size(); ++var6) {
            this.documentEntete = (DocumentEntete)this.listeDocumentTransfert.get(var6);
            if (this.documentEntete.isDocSelect()) {
               if (this.documentEntete.getDocNature() == 71) {
                  this.traitementConsultation(this.documentEntete, var3, var7);
               } else if (this.documentEntete.getDocNature() == 73) {
                  this.traitementPharmacie(this.documentEntete, var3, var7);
               } else if (this.documentEntete.getDocNature() == 74) {
                  this.traitementLaboratoire(this.documentEntete, var3, var7);
               } else if (this.documentEntete.getDocNature() == 76) {
                  this.traitementHospitalisation(this.documentEntete, var3, var7);
               } else if (this.documentEntete.getDocNature() == 78) {
                  this.traitementRefacturation(this.documentEntete, var3, var7);
               }
            }
         }

         this.utilInitHibernate.closeSession();
         this.optimisationResultat(this.optionComptabilite.getTrf_cpteVentes());
      }

      this.var_showBarProg = false;
   }

   public void traitementConsultation(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(var1.getDocId(), var3);
      if (this.consultationEnteteGene != null) {
         String var4 = "" + (this.consultationEnteteGene.getCsgDate().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(71, this.consultationEnteteGene.getCsgSerie(), var4, var3);
         if (var5 != null && !var5.isEmpty()) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("71");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(71);
            this.transfertCompta.setTrfIdOrigine(this.consultationEnteteGene.getCsgId());
            this.transfertCompta.setTrfAgent(this.consultationEnteteGene.getCsgNomCreateur());
            this.transfertCompta.setTrfDateSaisie(this.consultationEnteteGene.getCsgDate());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.consultationEnteteGene.getCsgDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.consultationEnteteGene.getCsgDate()));
            this.transfertCompta.setTrfCompte(var1.getNumComptetier());
            this.transfertCompta.setTrfDebitSaisie(this.consultationEnteteGene.getCsgTotPatient());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance((Date)null);
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneConsultation(var1, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            ArrayList var6 = new ArrayList();
            new ArrayList();
            List var7 = this.consultationActesDao.selectConsActesByConsEnt(this.consultationEnteteGene, var3);
            int var8;
            String var9;
            if (var7.size() != 0) {
               for(var8 = 0; var8 < var7.size(); ++var8) {
                  this.consultationActes = new ConsultationActes();
                  this.consultationActes = (ConsultationActes)var7.get(var8);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("71");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(71);
                  this.transfertCompta.setTrfIdOrigine(this.consultationEnteteGene.getCsgId());
                  this.transfertCompta.setTrfAgent(this.consultationEnteteGene.getCsgNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.consultationEnteteGene.getCsgDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.consultationEnteteGene.getCsgDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.consultationEnteteGene.getCsgDate()));
                  var9 = this.formTransfertCtrl.calculeCompteProduitVentes(0, this.consultationEnteteGene.getCsgTotTaxePatient(), this.consultationActes.getCslactProduit(), this.structureLog.getStrcodepays(), this.consultationEnteteGene.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  if (var9 != null && !var9.isEmpty()) {
                     this.transfertCompta.setTrfCompte(var9);
                  } else {
                     this.transfertCompta.setTrfCompte(this.optionMedical.getCompteProduit());
                  }

                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.consultationActes.getCslactPatientHt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneConsultation(var1, this.consultationActes.getCslactLibelle());
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var10 = new Stock();
                  var10.setStkTva(this.consultationActes.getCslactPatientTaxe());
                  var10.setStkTaxe(this.consultationActes.getCslactCodeTva());
                  var6.add(var10);
               }
            }

            if (var6.size() != 0) {
               for(var8 = 0; var8 < var6.size(); ++var8) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("71");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(71);
                  this.transfertCompta.setTrfIdOrigine(this.consultationEnteteGene.getCsgId());
                  this.transfertCompta.setTrfAgent(this.consultationEnteteGene.getCsgNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.consultationEnteteGene.getCsgDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.consultationEnteteGene.getCsgDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.consultationEnteteGene.getCsgDate()));
                  var9 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var6.get(var8)).getStkTaxe(), this.consultationEnteteGene.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var9);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var6.get(var8)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneConsultation(var1, "");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneConsultation(DocumentEntete var1, String var2) {
      if (this.optionMedical.getZoneRef1().equals("0")) {
         if (this.optionMedical.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.consultationEnteteGene.getCsgSerie() + ":" + this.consultationEnteteGene.getCsgNum());
         } else if (this.optionMedical.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.consultationEnteteGene.getCsgNum());
         }
      } else if (this.optionMedical.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1("");
      }

      if (this.optionMedical.getZoneRef2().equals("0")) {
         if (this.optionMedical.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.consultationEnteteGene.getCsgSerie() + ":" + this.consultationEnteteGene.getCsgNum());
         } else if (this.optionMedical.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.consultationEnteteGene.getCsgNum());
         }
      } else if (this.optionMedical.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2("");
      }

      if (this.optionMedical.getZoneLibelle().equals("0")) {
         this.transfertCompta.setTrfLibelle(var1.getDocNomTiers());
      } else if (this.optionMedical.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.consultationEnteteGene.getCsgObjet());
      } else if (this.optionMedical.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.consultationEnteteGene.getCsgObjet() + " date " + this.utilDate.dateToStringFr(this.consultationEnteteGene.getCsgDate()));
      } else if (this.optionMedical.getZoneLibelle().equals("3")) {
         if (var2 != null && !var2.isEmpty()) {
            this.transfertCompta.setTrfLibelle(var2 + " " + var1.getDocNomTiers());
         } else {
            this.transfertCompta.setTrfLibelle(var1.getDocNomTiers());
         }
      }

      if (this.optionMedical.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.consultationEnteteGene.getCsgObjet());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void traitementPharmacie(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.pharmacieEntete = this.pharmacieEnteteDao.selectById(var1.getDocId(), var3);
      if (this.pharmacieEntete != null) {
         String var4 = "" + (this.pharmacieEntete.getPhaDate().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(73, this.pharmacieEntete.getPhaSerie(), var4, var3);
         if (var5 != null && !var5.isEmpty()) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("73");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(73);
            this.transfertCompta.setTrfIdOrigine(this.pharmacieEntete.getPhaId());
            this.transfertCompta.setTrfAgent(this.pharmacieEntete.getPhaNomCreateur());
            this.transfertCompta.setTrfDateSaisie(this.pharmacieEntete.getPhaDate());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.pharmacieEntete.getPhaDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.pharmacieEntete.getPhaDate()));
            this.transfertCompta.setTrfCompte(var1.getNumComptetier());
            this.transfertCompta.setTrfDebitSaisie(this.pharmacieEntete.getPhaTotPatient());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance((Date)null);
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZonePharmacie(var1, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            ArrayList var6 = new ArrayList();
            new ArrayList();
            List var7 = this.pharmacieLigneDao.selectConsActesByConsEnt(this.pharmacieEntete, var3);
            int var8;
            String var9;
            if (var7.size() != 0) {
               for(var8 = 0; var8 < var7.size(); ++var8) {
                  this.pharmacieLigne = new PharmacieLigne();
                  this.pharmacieLigne = (PharmacieLigne)var7.get(var8);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("73");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(73);
                  this.transfertCompta.setTrfIdOrigine(this.pharmacieEntete.getPhaId());
                  this.transfertCompta.setTrfAgent(this.pharmacieEntete.getPhaNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.pharmacieEntete.getPhaDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.pharmacieEntete.getPhaDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.pharmacieEntete.getPhaDate()));
                  var9 = this.formTransfertCtrl.calculeCompteProduitVentes(0, this.pharmacieEntete.getPhaTotTaxePatient(), this.pharmacieLigne.getPhaligProduit(), this.structureLog.getStrcodepays(), this.pharmacieEntete.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  if (var9 != null && !var9.isEmpty()) {
                     this.transfertCompta.setTrfCompte(var9);
                  } else {
                     this.transfertCompta.setTrfCompte(this.optionMedical.getCompteProduit());
                  }

                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.pharmacieLigne.getPhaligPatientHt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZonePharmacie(var1, this.pharmacieLigne.getPhaligLibelle());
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var10 = new Stock();
                  var10.setStkTva(this.consultationActes.getCslactPatientTaxe());
                  var10.setStkTaxe(this.consultationActes.getCslactCodeTva());
                  var6.add(var10);
               }
            }

            if (var6.size() != 0) {
               for(var8 = 0; var8 < var6.size(); ++var8) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("73");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(73);
                  this.transfertCompta.setTrfIdOrigine(this.pharmacieEntete.getPhaId());
                  this.transfertCompta.setTrfAgent(this.pharmacieEntete.getPhaNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.pharmacieEntete.getPhaDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.pharmacieEntete.getPhaDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.pharmacieEntete.getPhaDate()));
                  var9 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var6.get(var8)).getStkTaxe(), this.pharmacieEntete.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var9);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var6.get(var8)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZonePharmacie(var1, "");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZonePharmacie(DocumentEntete var1, String var2) {
      if (this.optionMedical.getZoneRef1().equals("0")) {
         if (this.optionMedical.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.pharmacieEntete.getPhaSerie() + ":" + this.pharmacieEntete.getPhaNum());
         } else if (this.optionMedical.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.pharmacieEntete.getPhaNum());
         }
      } else if (this.optionMedical.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1("");
      }

      if (this.optionMedical.getZoneRef2().equals("0")) {
         if (this.optionMedical.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.pharmacieEntete.getPhaSerie() + ":" + this.pharmacieEntete.getPhaNum());
         } else if (this.optionMedical.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.pharmacieEntete.getPhaNum());
         }
      } else if (this.optionMedical.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2("");
      }

      if (this.optionMedical.getZoneLibelle().equals("0")) {
         this.transfertCompta.setTrfLibelle(var1.getDocNomTiers());
      } else if (this.optionMedical.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle("");
      } else if (this.optionMedical.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(" date " + this.utilDate.dateToStringFr(this.pharmacieEntete.getPhaDate()));
      } else if (this.optionMedical.getZoneLibelle().equals("3")) {
         if (var2 != null && !var2.isEmpty()) {
            this.transfertCompta.setTrfLibelle(var2 + " " + var1.getDocNomTiers());
         } else {
            this.transfertCompta.setTrfLibelle(var1.getDocNomTiers());
         }
      }

      if (this.optionMedical.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite("");
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void traitementLaboratoire(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.laboratoireEntete = this.laboratoireEnteteDao.selectById(var1.getDocId(), var3);
      if (this.laboratoireEntete != null) {
         String var4 = "" + (this.laboratoireEntete.getLabDate().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(74, this.laboratoireEntete.getLabSerie(), var4, var3);
         if (var5 != null && !var5.isEmpty()) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("74");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(74);
            this.transfertCompta.setTrfIdOrigine(this.laboratoireEntete.getLabId());
            this.transfertCompta.setTrfAgent(this.laboratoireEntete.getLabNomCreateur());
            this.transfertCompta.setTrfDateSaisie(this.laboratoireEntete.getLabDate());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.laboratoireEntete.getLabDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.laboratoireEntete.getLabDate()));
            this.transfertCompta.setTrfCompte(var1.getNumComptetier());
            this.transfertCompta.setTrfDebitSaisie(this.laboratoireEntete.getLabTotPatient());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance((Date)null);
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneLaboratoire(var1, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            ArrayList var6 = new ArrayList();
            new ArrayList();
            List var7 = this.laboratoireLigneDao.selectConsActesByConsEnt(this.laboratoireEntete, var3);
            int var8;
            String var9;
            if (var7.size() != 0) {
               for(var8 = 0; var8 < var7.size(); ++var8) {
                  this.laboratoireLigne = new LaboratoireLigne();
                  this.laboratoireLigne = (LaboratoireLigne)var7.get(var8);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("74");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(74);
                  this.transfertCompta.setTrfIdOrigine(this.laboratoireEntete.getLabId());
                  this.transfertCompta.setTrfAgent(this.laboratoireEntete.getLabNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.laboratoireEntete.getLabDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.laboratoireEntete.getLabDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.laboratoireEntete.getLabDate()));
                  var9 = this.formTransfertCtrl.calculeCompteProduitVentes(0, this.laboratoireEntete.getLabTotTaxePatient(), this.laboratoireLigne.getLabligProduit(), this.structureLog.getStrcodepays(), this.laboratoireEntete.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  if (var9 != null && !var9.isEmpty()) {
                     this.transfertCompta.setTrfCompte(var9);
                  } else {
                     this.transfertCompta.setTrfCompte(this.optionMedical.getCompteProduit());
                  }

                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.laboratoireLigne.getLabligPatientHt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneLaboratoire(var1, this.laboratoireLigne.getLabligLibelle());
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  Stock var10 = new Stock();
                  var10.setStkTva(this.laboratoireLigne.getLabligPatientTaxe());
                  var10.setStkTaxe(this.laboratoireLigne.getLabligCodeTva());
                  var6.add(var10);
               }
            }

            if (var6.size() != 0) {
               for(var8 = 0; var8 < var6.size(); ++var8) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("74");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(74);
                  this.transfertCompta.setTrfIdOrigine(this.laboratoireEntete.getLabId());
                  this.transfertCompta.setTrfAgent(this.laboratoireEntete.getLabNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.laboratoireEntete.getLabDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.laboratoireEntete.getLabDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.laboratoireEntete.getLabDate()));
                  var9 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var6.get(var8)).getStkTaxe(), this.laboratoireEntete.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var9);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var6.get(var8)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneLaboratoire(var1, "");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneLaboratoire(DocumentEntete var1, String var2) {
      if (this.optionMedical.getZoneRef1().equals("0")) {
         if (this.optionMedical.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.laboratoireEntete.getLabSerie() + ":" + this.laboratoireEntete.getLabNum());
         } else if (this.optionMedical.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.laboratoireEntete.getLabNum());
         }
      } else if (this.optionMedical.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1("");
      }

      if (this.optionMedical.getZoneRef2().equals("0")) {
         if (this.optionMedical.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.laboratoireEntete.getLabSerie() + ":" + this.laboratoireEntete.getLabNum());
         } else if (this.optionMedical.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.laboratoireEntete.getLabNum());
         }
      } else if (this.optionMedical.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2("");
      }

      if (this.optionMedical.getZoneLibelle().equals("0")) {
         this.transfertCompta.setTrfLibelle(var1.getDocNomTiers());
      } else if (this.optionMedical.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle("");
      } else if (this.optionMedical.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(" date " + this.utilDate.dateToStringFr(this.laboratoireEntete.getLabDate()));
      } else if (this.optionMedical.getZoneLibelle().equals("3")) {
         if (var2 != null && !var2.isEmpty()) {
            this.transfertCompta.setTrfLibelle(var2 + " " + var1.getDocNomTiers());
         } else {
            this.transfertCompta.setTrfLibelle(var1.getDocNomTiers());
         }
      }

      if (this.optionMedical.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite("");
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void traitementHospitalisation(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(var1.getDocId(), var3);
      if (this.hospitalisationEntete != null) {
         String var4 = "" + (this.hospitalisationEntete.getHosDateSortie().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(76, this.hospitalisationEntete.getHosSerie(), var4, var3);
         if (var5 != null && !var5.isEmpty()) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("76");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(76);
            this.transfertCompta.setTrfIdOrigine(this.hospitalisationEntete.getHosId());
            this.transfertCompta.setTrfAgent(this.hospitalisationEntete.getHosNomCreateur());
            this.transfertCompta.setTrfDateSaisie(this.hospitalisationEntete.getHosDateSortie());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.hospitalisationEntete.getHosDateSortie()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.hospitalisationEntete.getHosDateSortie()));
            this.transfertCompta.setTrfCompte(var1.getNumComptetier());
            this.transfertCompta.setTrfDebitSaisie(this.hospitalisationEntete.getHosTotPatient());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance((Date)null);
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneConsultation(var1, "");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            ArrayList var6 = new ArrayList();
            new ArrayList();
            List var7 = this.hospitalisationSejourDao.selectSejourByEnt(this.hospitalisationEntete, var3);
            if (var7.size() != 0) {
               for(int var8 = 0; var8 < var7.size(); ++var8) {
                  this.hospitalisationSejour = new HospitalisationSejour();
                  this.hospitalisationSejour = (HospitalisationSejour)var7.get(var8);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("76");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(76);
                  this.transfertCompta.setTrfIdOrigine(this.hospitalisationEntete.getHosId());
                  this.transfertCompta.setTrfAgent(this.hospitalisationEntete.getHosNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.hospitalisationEntete.getHosDateSortie());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.hospitalisationEntete.getHosDateSortie()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.hospitalisationEntete.getHosDateSortie()));
                  String var9 = this.formTransfertCtrl.calculeCompteProduitVentes(0, this.hospitalisationEntete.getHosTotTaxePatient(), this.hospitalisationSejour.getHossejLit(), this.structureLog.getStrcodepays(), this.hospitalisationEntete.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  this.transfertCompta.setTrfCompte(var9);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.hospitalisationSejour.getHossejPatientHt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneHospitalisation(var1, this.hospitalisationSejour.getHossejLibelle());
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  if (this.hospitalisationSejour.getHossejPatientTaxe() != 0.0D) {
                     Stock var10 = new Stock();
                     var10.setStkTva(this.hospitalisationSejour.getHossejPatientTaxe());
                     var10.setStkTaxe(this.hospitalisationSejour.getHossejCodeTva());
                     var6.add(var10);
                  }
               }
            }

            new ArrayList();
            List var15 = this.hospitalisationActesDao.selectActesByEnt(this.hospitalisationEntete, var3);
            if (var15.size() != 0) {
               for(int var16 = 0; var16 < var15.size(); ++var16) {
                  this.hospitalisationActes = new HospitalisationActes();
                  this.hospitalisationActes = (HospitalisationActes)var15.get(var16);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("76");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(76);
                  this.transfertCompta.setTrfIdOrigine(this.hospitalisationEntete.getHosId());
                  this.transfertCompta.setTrfAgent(this.hospitalisationEntete.getHosNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.hospitalisationEntete.getHosDateSortie());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.hospitalisationEntete.getHosDateSortie()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.hospitalisationEntete.getHosDateSortie()));
                  String var18 = this.formTransfertCtrl.calculeCompteProduitVentes(0, this.hospitalisationEntete.getHosTotTaxePatient(), this.hospitalisationActes.getHosactProduit(), this.structureLog.getStrcodepays(), this.hospitalisationEntete.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  if (var18 != null && !var18.isEmpty()) {
                     this.transfertCompta.setTrfCompte(var18);
                  } else {
                     this.transfertCompta.setTrfCompte(this.optionMedical.getCompteProduit());
                  }

                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.hospitalisationActes.getHosactPatientHt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneHospitalisation(var1, this.hospitalisationActes.getHosactLibelle());
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  if (this.hospitalisationActes.getHosactPatientTaxe() != 0.0D) {
                     Stock var11 = new Stock();
                     var11.setStkTva(this.hospitalisationActes.getHosactPatientTaxe());
                     var11.setStkTaxe(this.hospitalisationActes.getHosactCodeTva());
                     var6.add(var11);
                  }
               }
            }

            new ArrayList();
            List var17 = this.hospitalisationLaboDao.selectLaboByEnt(this.hospitalisationEntete, var3);
            if (var17.size() != 0) {
               for(int var19 = 0; var19 < var17.size(); ++var19) {
                  this.hospitalisationLabo = new HospitalisationLabo();
                  this.hospitalisationLabo = (HospitalisationLabo)var17.get(var19);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("76");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(76);
                  this.transfertCompta.setTrfIdOrigine(this.hospitalisationEntete.getHosId());
                  this.transfertCompta.setTrfAgent(this.hospitalisationEntete.getHosNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.hospitalisationEntete.getHosDateSortie());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.hospitalisationEntete.getHosDateSortie()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.hospitalisationEntete.getHosDateSortie()));
                  String var21 = this.formTransfertCtrl.calculeCompteProduitVentes(0, this.hospitalisationEntete.getHosTotTaxePatient(), this.hospitalisationLabo.getHoslabProduit(), this.structureLog.getStrcodepays(), this.hospitalisationEntete.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  if (var21 != null && !var21.isEmpty()) {
                     this.transfertCompta.setTrfCompte(var21);
                  } else {
                     this.transfertCompta.setTrfCompte(this.optionMedical.getCompteProduit());
                  }

                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.hospitalisationLabo.getHoslabPatientHt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneHospitalisation(var1, this.hospitalisationLabo.getHoslabLibelle());
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  if (this.hospitalisationLabo.getHoslabPatientTaxe() != 0.0D) {
                     Stock var12 = new Stock();
                     var12.setStkTva(this.hospitalisationLabo.getHoslabPatientTaxe());
                     var12.setStkTaxe(this.hospitalisationLabo.getHoslabCodeTva());
                     var6.add(var12);
                  }
               }
            }

            new ArrayList();
            List var20 = this.hospitalisationMediDao.selectMediByEnt(this.hospitalisationEntete, var3);
            if (var20.size() != 0) {
               for(int var22 = 0; var22 < var20.size(); ++var22) {
                  this.hospitalisationMedi = new HospitalisationMedi();
                  this.hospitalisationMedi = (HospitalisationMedi)var20.get(var22);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("76");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(76);
                  this.transfertCompta.setTrfIdOrigine(this.hospitalisationEntete.getHosId());
                  this.transfertCompta.setTrfAgent(this.hospitalisationEntete.getHosNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.hospitalisationEntete.getHosDateSortie());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.hospitalisationEntete.getHosDateSortie()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.hospitalisationEntete.getHosDateSortie()));
                  String var24 = this.formTransfertCtrl.calculeCompteProduitVentes(0, this.hospitalisationEntete.getHosTotTaxePatient(), this.hospitalisationMedi.getHosmedProduit(), this.structureLog.getStrcodepays(), this.hospitalisationEntete.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  if (var24 != null && !var24.isEmpty()) {
                     this.transfertCompta.setTrfCompte(var24);
                  } else {
                     this.transfertCompta.setTrfCompte(this.optionMedical.getCompteProduit());
                  }

                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.hospitalisationMedi.getHosmedPatientHt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneHospitalisation(var1, this.hospitalisationMedi.getHosmedLibelle());
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  if (this.hospitalisationMedi.getHosmedPatientTaxe() != 0.0D) {
                     Stock var13 = new Stock();
                     var13.setStkTva(this.hospitalisationMedi.getHosmedPatientTaxe());
                     var13.setStkTaxe(this.hospitalisationMedi.getHosmedCodeTva());
                     var6.add(var13);
                  }
               }
            }

            new ArrayList();
            List var23 = this.hospitalisationPrestDao.selectPrestByEnt(this.hospitalisationEntete, var3);
            int var25;
            String var26;
            if (var23.size() != 0) {
               for(var25 = 0; var25 < var23.size(); ++var25) {
                  this.hospitalisationPrest = new HospitalisationPrest();
                  this.hospitalisationPrest = (HospitalisationPrest)var23.get(var25);
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("76");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(76);
                  this.transfertCompta.setTrfIdOrigine(this.hospitalisationEntete.getHosId());
                  this.transfertCompta.setTrfAgent(this.hospitalisationEntete.getHosNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.hospitalisationEntete.getHosDateSortie());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.hospitalisationEntete.getHosDateSortie()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.hospitalisationEntete.getHosDateSortie()));
                  var26 = this.formTransfertCtrl.calculeCompteProduitVentes(0, this.hospitalisationEntete.getHosTotTaxePatient(), this.hospitalisationPrest.getHosprtProduit(), this.structureLog.getStrcodepays(), this.hospitalisationEntete.getExerciceventes().getExevteId(), this.listPays, var3);
                  this.produits = this.formTransfertCtrl.getProduits();
                  if (var26 != null && !var26.isEmpty()) {
                     this.transfertCompta.setTrfCompte(var26);
                  } else {
                     this.transfertCompta.setTrfCompte(this.optionMedical.getCompteProduit());
                  }

                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.hospitalisationPrest.getHosprtPatientHt());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneHospitalisation(var1, this.hospitalisationPrest.getHosprtLibelle());
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  if (this.hospitalisationPrest.getHosprtPatientTaxe() != 0.0D) {
                     Stock var14 = new Stock();
                     var14.setStkTva(this.hospitalisationPrest.getHosprtPatientTaxe());
                     var14.setStkTaxe(this.hospitalisationPrest.getHosprtCodeTva());
                     var6.add(var14);
                  }
               }
            }

            if (var6.size() != 0) {
               for(var25 = 0; var25 < var6.size(); ++var25) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("76");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(76);
                  this.transfertCompta.setTrfIdOrigine(this.hospitalisationEntete.getHosId());
                  this.transfertCompta.setTrfAgent(this.hospitalisationEntete.getHosNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.hospitalisationEntete.getHosDateSortie());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.hospitalisationEntete.getHosDateSortie()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.hospitalisationEntete.getHosDateSortie()));
                  var26 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var6.get(var25)).getStkTaxe(), this.hospitalisationEntete.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var26);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var6.get(var25)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneHospitalisation(var1, "");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneHospitalisation(DocumentEntete var1, String var2) {
      if (this.optionMedical.getZoneRef1().equals("0")) {
         if (this.optionMedical.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.hospitalisationEntete.getHosSerie() + ":" + this.hospitalisationEntete.getHosNum());
         } else if (this.optionMedical.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.hospitalisationEntete.getHosNum());
         }
      } else if (this.optionMedical.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1("");
      }

      if (this.optionMedical.getZoneRef2().equals("0")) {
         if (this.optionMedical.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.hospitalisationEntete.getHosSerie() + ":" + this.hospitalisationEntete.getHosNum());
         } else if (this.optionMedical.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.hospitalisationEntete.getHosNum());
         }
      } else if (this.optionMedical.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2("");
      }

      if (this.optionMedical.getZoneLibelle().equals("0")) {
         this.transfertCompta.setTrfLibelle(var1.getDocNomTiers());
      } else if (this.optionMedical.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle("");
      } else if (this.optionMedical.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(" date " + this.utilDate.dateToStringFr(this.hospitalisationEntete.getHosDateSortie()));
      } else if (this.optionMedical.getZoneLibelle().equals("3")) {
         if (var2 != null && !var2.isEmpty()) {
            this.transfertCompta.setTrfLibelle(var2 + " " + this.hospitalisationEntete.getHosNomPatient());
         } else {
            this.transfertCompta.setTrfLibelle(var1.getDocNomTiers());
         }
      }

      if (this.optionMedical.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite("");
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void traitementRefacturation(DocumentEntete var1, String var2, Session var3) throws HibernateException, NamingException {
      this.factureEnteteMedical = this.factureEnteteMedicalDao.pourParapheur(var1.getDocId(), var3);
      if (this.factureEnteteMedical != null) {
         String var4 = "" + (this.factureEnteteMedical.getFacDate().getYear() + 1900);
         String var5 = this.formTransfertCtrl.calculeJournalSerie(78, this.factureEnteteMedical.getFacSerie(), var4, var3);
         if (var5 != null && !var5.isEmpty()) {
            this.transfertCompta = new TransfertCompta();
            this.transfertCompta.setTrfTypeOrigine("78");
            this.transfertCompta.setTrfCategorie(0);
            this.transfertCompta.setTrfNature(78);
            this.transfertCompta.setTrfIdOrigine(this.factureEnteteMedical.getFacId());
            this.transfertCompta.setTrfAgent(this.factureEnteteMedical.getFacNomCreateur());
            this.transfertCompta.setTrfDateSaisie(this.factureEnteteMedical.getFacDate());
            this.transfertCompta.setTrfCode(var5);
            this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.factureEnteteMedical.getFacDate()));
            this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteMedical.getFacDate()));
            this.transfertCompta.setTrfCompte(var1.getNumComptetier());
            this.transfertCompta.setTrfDebitSaisie(this.factureEnteteMedical.getFacTotHt());
            this.transfertCompta.setTrfCreditSaisie(0.0D);
            this.transfertCompta.setTrfDateEcheance(this.factureEnteteMedical.getFacDateEcheReg());
            this.transfertCompta.setTrfDateValeurTheo((Date)null);
            this.transfertCompta.setTrfPiece("");
            this.calculeZoneReFacturation("");
            if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
               this.lesTransfertCompta.add(this.transfertCompta);
            }

            ArrayList var6 = new ArrayList();
            new ArrayList();
            List var7 = this.factureLigneMedicalDao.chargerLesLignes(this.factureEnteteMedical, var3);
            int var8;
            if (var7.size() != 0) {
               for(var8 = 0; var8 < var7.size(); ++var8) {
                  this.factureLigneMedical = new FactureLigneMedical();
                  this.factureLigneMedical = (FactureLigneMedical)var7.get(var8);
                  this.calculeLigneProduit(var5, this.factureLigneMedical, var3);
                  Stock var9 = new Stock();
                  if (this.factureLigneMedical.getFacligTva() != 0.0D) {
                     var9.setStkTva(this.factureLigneMedical.getFacligTva());
                     var9.setStkTaxe(this.factureLigneMedical.getFacligTaxe());
                     var6.add(var9);
                  }
               }
            }

            if (var6.size() != 0) {
               for(var8 = 0; var8 < var6.size(); ++var8) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("78");
                  this.transfertCompta.setTrfCategorie(0);
                  this.transfertCompta.setTrfNature(78);
                  this.transfertCompta.setTrfIdOrigine(this.factureEnteteMedical.getFacId());
                  this.transfertCompta.setTrfAgent(this.factureEnteteMedical.getFacNomCreateur());
                  this.transfertCompta.setTrfDateSaisie(this.factureEnteteMedical.getFacDate());
                  this.transfertCompta.setTrfCode(var5);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.factureEnteteMedical.getFacDate()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteMedical.getFacDate()));
                  String var10 = this.formTransfertCtrl.calculeCompteTvaVentes(((Stock)var6.get(var8)).getStkTaxe(), this.factureEnteteMedical.getExerciceventes().getExevteId(), var3);
                  this.transfertCompta.setTrfCompte(var10);
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(((Stock)var6.get(var8)).getStkTva());
                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo((Date)null);
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneReFacturation("");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeLigneProduit(String var1, FactureLigneMedical var2, Session var3) throws HibernateException, NamingException {
      List var4;
      int var5;
      double var6;
      if (var2.getFacligIdConsultation() != 0L) {
         new ArrayList();
         var4 = this.consultationActesDao.selectConsActesByConsEnt(var2.getFacligIdConsultation(), var3);
         if (var4.size() != 0) {
            for(var5 = 0; var5 < var4.size(); ++var5) {
               var6 = ((ConsultationActes)var4.get(var5)).getCslactAssuranceHt() + ((ConsultationActes)var4.get(var5)).getCslactSocieteHt();
               this.calculLigneProduitsuite(var1, ((ConsultationActes)var4.get(var5)).getCslactProduit(), var6, var3);
            }
         }
      } else if (var2.getFacligIdPharmacie() != 0L) {
         new ArrayList();
         var4 = this.pharmacieLigneDao.selectConsActesByConsEnt(var2.getFacligIdPharmacie(), var3);
         if (var4.size() != 0) {
            for(var5 = 0; var5 < var4.size(); ++var5) {
               var6 = ((PharmacieLigne)var4.get(var5)).getPhaligAssuranceHt() + ((PharmacieLigne)var4.get(var5)).getPhaligSocieteHt();
               this.calculLigneProduitsuite(var1, ((PharmacieLigne)var4.get(var5)).getPhaligProduit(), var6, var3);
            }
         }
      } else if (var2.getFacligIdLaboratoire() != 0L) {
         new ArrayList();
         var4 = this.laboratoireLigneDao.selectConsActesByConsEnt(var2.getFacligIdLaboratoire(), var3);
         if (var4.size() != 0) {
            for(var5 = 0; var5 < var4.size(); ++var5) {
               var6 = ((LaboratoireLigne)var4.get(var5)).getLabligAssuranceHt() + ((LaboratoireLigne)var4.get(var5)).getLabligSocieteHt();
               this.calculLigneProduitsuite(var1, ((LaboratoireLigne)var4.get(var5)).getLabligProduit(), var6, var3);
            }
         }
      } else if (var2.getFacligIdHospitalisationActe() == 0L && var2.getFacligIdHospitalisationLabo() == 0L && var2.getFacligIdHospitalisationMedic() == 0L && var2.getFacligIdHospitalisationPrest() == 0L && var2.getFacligIdHospitalisationSejour() != 0L) {
      }

   }

   public void calculLigneProduitsuite(String var1, String var2, double var3, Session var5) throws HibernateException, NamingException {
      this.transfertCompta = new TransfertCompta();
      this.transfertCompta.setTrfTypeOrigine("78");
      this.transfertCompta.setTrfCategorie(0);
      this.transfertCompta.setTrfNature(78);
      this.transfertCompta.setTrfIdOrigine(this.factureEnteteMedical.getFacId());
      this.transfertCompta.setTrfAgent(this.factureEnteteMedical.getFacNomCreateur());
      this.transfertCompta.setTrfDateSaisie(this.factureEnteteMedical.getFacDate());
      this.transfertCompta.setTrfCode(var1);
      this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var1, this.factureEnteteMedical.getFacDate()));
      this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.factureEnteteMedical.getFacDate()));
      String var6 = this.formTransfertCtrl.calculeCompteProduitVentes(0, this.factureEnteteMedical.getFacTotTva(), var2, this.structureLog.getStrcodepays(), this.factureEnteteMedical.getExerciceventes().getExevteId(), this.listPays, var5);
      if (var6 != null && !var6.isEmpty()) {
         this.transfertCompta.setTrfCompte(var6);
      } else {
         this.transfertCompta.setTrfCompte(this.optionMedical.getCompteProduit());
      }

      this.transfertCompta.setTrfDebitSaisie(0.0D);
      this.transfertCompta.setTrfCreditSaisie(var3);
      this.transfertCompta.setTrfDateEcheance((Date)null);
      this.transfertCompta.setTrfDateValeurTheo((Date)null);
      this.transfertCompta.setTrfPiece("");
      this.calculeZoneReFacturation(this.factureLigneMedical.getFacligLibelle());
      if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
         this.lesTransfertCompta.add(this.transfertCompta);
      }

   }

   public void calculeZoneReFacturation(String var1) {
      if (this.optionMedical.getZoneRef1().equals("0")) {
         if (this.optionMedical.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.factureEnteteMedical.getFacSerie() + ":" + this.factureEnteteMedical.getFacNum());
         } else if (this.optionMedical.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.factureEnteteMedical.getFacNum());
         }
      } else if (this.optionMedical.getZoneRef1().equals("1")) {
         this.transfertCompta.setTrfReference1("");
      }

      if (this.optionMedical.getZoneRef2().equals("0")) {
         if (this.optionMedical.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.factureEnteteMedical.getFacSerie() + ":" + this.factureEnteteMedical.getFacNum());
         } else if (this.optionMedical.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.factureEnteteMedical.getFacNum());
         }
      } else if (this.optionMedical.getZoneRef2().equals("1")) {
         this.transfertCompta.setTrfReference2("");
      }

      if (this.optionMedical.getZoneLibelle().equals("0")) {
         this.transfertCompta.setTrfLibelle(this.factureEnteteMedical.getFacNomTiers());
      } else if (this.optionMedical.getZoneLibelle().equals("1")) {
         this.transfertCompta.setTrfLibelle(this.factureEnteteMedical.getFacObject());
      } else if (this.optionMedical.getZoneLibelle().equals("2")) {
         this.transfertCompta.setTrfLibelle(this.factureEnteteMedical.getFacObject() + " date " + this.utilDate.dateToStringFr(this.factureEnteteMedical.getFacDate()));
      } else if (this.optionMedical.getZoneLibelle().equals("3")) {
         if (var1 != null && !var1.isEmpty()) {
            this.transfertCompta.setTrfLibelle(var1 + " " + this.factureEnteteMedical.getFacNomTiers());
         } else {
            this.transfertCompta.setTrfLibelle(this.factureEnteteMedical.getFacNomTiers());
         }
      }

      if (this.optionMedical.getZoneLibelleSuite().equals("1")) {
         this.transfertCompta.setTrfSuite(this.factureEnteteMedical.getFacObject());
      } else {
         this.transfertCompta.setTrfSuite("");
      }

   }

   public void transfertCaisse(List var1) throws HibernateException, NamingException, ParseException {
      this.init();
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "TaxesVentes");
      this.listeDocumentTransfert = var1;
      this.objetPays = new ObjetPays();
      this.lecturePays = new LecturePays();
      this.listPays = this.lecturePays.getMespays();
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var3 = new LireLesoptionsVentes();
      var3.setStrId(this.structureLog.getStrid());
      this.optionVentes = var3.lancer();
      this.optionCaisses = new OptionCaisses();
      LireLesoptionsCaisses var4 = new LireLesoptionsCaisses();
      var4.setStrId(this.structureLog.getStrid());
      this.optionCaisses = var4.lancer();
      this.optionMedical = new OptionMedical();
      LireLesoptionsMedical var5 = new LireLesoptionsMedical();
      var5.setStrId(this.structureLog.getStrid());
      this.optionMedical = var5.lancer();
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.reglements = new Reglements();
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommerciales = new CaissesCommerciales();
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.caissesOperations = new CaissesOperations();
      this.caissesOperationsDao = new CaissesOperationsDao(this.baseLog, this.utilInitHibernate);
      this.tiers = new Tiers();
      this.salaries = new Salaries();
      new ExercicesCaisse();
      ExercicesCaisseDao var7 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
      ExercicesCaisse var6 = var7.recupererLastExo(var2);
      new ExercicesPaye();
      ExercicesPayeDao var9 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      ExercicesPaye var8 = var9.recupererLastExo(var2);
      String var10 = "";
      new ExercicesVentes();
      ExercicesVentesDao var12 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var11 = var12.recupererLastExo(var2);
      int var14;
      if (var11 != null) {
         new ArrayList();
         List var13 = this.taxesVentesDao.selectActifTaxes(var11.getExevteId(), var2);
         if (var13.size() != 0) {
            for(var14 = 0; var14 < var13.size(); ++var14) {
               if (((TaxesVentes)var13.get(var14)).getTaxvteTimbre() != 0 && ((TaxesVentes)var13.get(var14)).getTaxvteCompte() != null && !((TaxesVentes)var13.get(var14)).getTaxvteCompte().isEmpty()) {
                  String[] var15 = ((TaxesVentes)var13.get(var14)).getTaxvteCompte().split(":");
                  var10 = var15[0];
                  break;
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
      this.lesTransfertCompta.clear();
      this.lesTransfertErreur.clear();
      if (this.listeDocumentTransfert.size() != 0) {
         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
         this.documentEntete = new DocumentEntete();
         String var16 = "";

         for(var14 = 0; var14 < this.listeDocumentTransfert.size(); ++var14) {
            this.documentEntete = (DocumentEntete)this.listeDocumentTransfert.get(var14);
            if (this.documentEntete.isDocSelect()) {
               if (this.documentEntete.getDocNature() == 64) {
                  var16 = this.traitementOperationVirement(this.documentEntete, var6, var8, var16, var2);
               } else {
                  this.traitementOperationCaisse(this.documentEntete, var6, var8, var10, var2);
               }
            }
         }

         this.utilInitHibernate.closeSession();
         this.optimisationResultat(this.optionComptabilite.getTrf_cpteTreso());
      }

   }

   public void traitementOperationCaisse(DocumentEntete var1, ExercicesCaisse var2, ExercicesPaye var3, String var4, Session var5) throws HibernateException, NamingException {
      this.reglements = this.reglementsDao.pourParapheur(var1.getDocId(), var5);
      if (this.reglements != null) {
         boolean var6 = true;
         this.caissesCommerciales = this.caissesCommercialesDao.selectCaisse(var2.getExecaiId(), this.reglements.getRglCodeCaiss(), var5);
         if (this.caissesCommerciales != null) {
            if (this.reglements.getRglTypeReg() != 0 && this.reglements.getRglTypeReg() != 11 && this.reglements.getRglTypeReg() != 100) {
               if (this.reglements.getRglTypeReg() == 1) {
                  this.journalCaisseCheque = this.caissesCommerciales.getCaiJrCheque();
                  if (!this.caissesCommerciales.isCaiExportJrCheque()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 2) {
                  this.journalCaisseViement = this.caissesCommerciales.getCaiJrVirement();
                  if (!this.caissesCommerciales.isCaiExportJrVirement()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 3) {
                  this.journalCaisseTraite = this.caissesCommerciales.getCaiJrTraite();
                  if (!this.caissesCommerciales.isCaiExportJrTraite()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 4) {
                  this.journalCaisseTpe = this.caissesCommerciales.getCaiJrTpe();
                  if (!this.caissesCommerciales.isCaiExportJrTpe()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 5) {
                  this.journalCaisseTransfert = this.caissesCommerciales.getCaiJrTransfert();
                  if (!this.caissesCommerciales.isCaiExportJrTrf()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 6) {
                  this.journalCaisseePaiement = this.caissesCommerciales.getCaiJrePaiement();
                  if (!this.caissesCommerciales.isCaiExportJrePaiement()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 7) {
                  this.journalCaisseCredoc = this.caissesCommerciales.getCaiJrCredoc();
                  if (!this.caissesCommerciales.isCaiExportJrCredoc()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 8) {
                  this.journalCaisseFactor = this.caissesCommerciales.getCaiJrFactor();
                  if (!this.caissesCommerciales.isCaiExportJrFactor()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 9) {
                  this.journalCaisseCompense = this.caissesCommerciales.getCaiJrCompense();
                  if (!this.caissesCommerciales.isCaiExportJrCompense()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 10) {
                  this.journalCaisseTerme = this.caissesCommerciales.getCaiJrTerme();
                  if (!this.caissesCommerciales.isCaiExportJrTerme()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 12) {
                  this.journalCaisseTerme = this.caissesCommerciales.getCaiJrLettreGarantie();
                  if (!this.caissesCommerciales.isCaiExportJrLettreGarantie()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 13) {
                  this.journalCaisseTerme = this.caissesCommerciales.getCaiJrPrelevement();
                  if (!this.caissesCommerciales.isCaiExportJrPrelevement()) {
                     var6 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 14) {
                  this.journalCaisseTerme = this.caissesCommerciales.getCaiJrAlcoin();
                  if (!this.caissesCommerciales.isCaiExportJrAlcoin()) {
                     var6 = false;
                  }
               }
            } else {
               this.journalCaisseEspece = this.caissesCommerciales.getCaiJrEspece();
               if (!this.caissesCommerciales.isCaiExportJrEspece()) {
                  var6 = false;
               }
            }
         }

         if (var6 && this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty()) {
            this.caissesOperations = new CaissesOperations();
            this.caissesOperations = this.caissesOperationsDao.selectOperationByCode(this.reglements.getRglOperation(), var5);
            if (this.caissesOperations != null && this.caissesOperations.getCaiopeTransfert() == 1) {
               var6 = false;
            }
         }

         if (var6) {
            String var7 = "";
            String var8 = "" + (var1.getDocDate().getYear() + 1900);
            if (var1.getDocCodeEmetrice() != null && !var1.getDocCodeEmetrice().isEmpty()) {
               this.formTransfertCtrl.calculeJournal(53, var1.getDocCodeEmetrice(), var8, var5);
            } else {
               this.formTransfertCtrl.calculeJournalTreso(var1.getDocCodeCaiss(), var2, var8, var5);
            }

            if (this.reglements.getRglTypeReg() != 0 && this.reglements.getRglTypeReg() != 11) {
               if (this.reglements.getRglTypeReg() == 1) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseCheque;
                  }
               } else if (this.reglements.getRglTypeReg() == 2) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseViement;
                  }
               } else if (this.reglements.getRglTypeReg() == 3) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseTraite;
                  }
               } else if (this.reglements.getRglTypeReg() == 4) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseTpe;
                  }
               } else if (this.reglements.getRglTypeReg() == 5) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseTransfert;
                  }
               } else if (this.reglements.getRglTypeReg() == 6) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseePaiement;
                  }
               } else if (this.reglements.getRglTypeReg() == 7) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseCredoc;
                  }
               } else if (this.reglements.getRglTypeReg() == 8) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseFactor;
                  }
               } else if (this.reglements.getRglTypeReg() == 9) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseCompense;
                  }
               } else if (this.reglements.getRglTypeReg() == 10) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseTerme;
                  }
               } else if (this.reglements.getRglTypeReg() == 12) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseLettreGarantie;
                  }
               } else if (this.reglements.getRglTypeReg() == 13) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaissePrelevement;
                  }
               } else if (this.reglements.getRglTypeReg() == 14) {
                  if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                     var7 = this.reglements.getRglCodeEmetrice();
                  } else {
                     var7 = this.journalCaisseAlcoin;
                  }
               }
            } else {
               var7 = this.journalCaisseEspece;
            }

            if (var7 != null && !var7.isEmpty() && !var7.startsWith("XX")) {
               String var9 = this.formTransfertCtrl.calculeCompteTreso(var7, var5);
               String var10 = this.caissesCommercialesDao.selectCaisseByCode(var1.getDocCodeCaiss(), var2, var5).getCaiCompteEff();
               if (var10 == null || var10.isEmpty()) {
                  var10 = var9;
               }

               double var11 = 0.0D;
               double var13 = 0.0D;
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("60");
               this.transfertCompta.setTrfCategorie(this.reglements.getRglCategorie());
               this.transfertCompta.setTrfNature(this.reglements.getRglNatureDoc());
               this.transfertCompta.setTrfIdResponsable(this.reglements.getRglIdResponsable());
               this.transfertCompta.setTrfNomResponsable(this.reglements.getRglNomResponsable());
               String var15 = "";
               String var16 = "";
               if (this.reglements.getRglBanqueTireur() != null && !this.reglements.getRglBanqueTireur().isEmpty() && !this.reglements.getRglBanqueTireur().equals("0")) {
                  var15 = this.reglements.getRglBanqueTireur();
               }

               if (this.reglements.getRglNumChqBdx() != null && !this.reglements.getRglNumChqBdx().isEmpty() && !this.reglements.getRglNumChqBdx().equals("0")) {
                  var15 = var15 + " " + this.reglements.getRglNumChqBdx();
                  var16 = this.reglements.getRglNumChqBdx();
               }

               String[] var17;
               if (this.reglements.getRglActivite() != null && !this.reglements.getRglActivite().isEmpty() && !this.reglements.getRglActivite().equals("0") && !this.decoupageActivite) {
                  if (this.reglements.getRglActivite() != null && !this.reglements.getRglActivite().isEmpty() && this.reglements.getRglActivite().contains(":")) {
                     var17 = this.reglements.getRglActivite().split(":");
                     var15 = var15 + " " + var17[0];
                  } else {
                     var15 = var15 + " " + this.reglements.getRglActivite();
                  }
               }

               if (this.reglements.getRglDossier() != null && !this.reglements.getRglDossier().isEmpty() && !this.reglements.getRglDossier().equals("0")) {
                  var15 = var15 + " " + this.reglements.getRglDossier();
               }

               this.transfertCompta.setTrfSuite(var15);
               this.transfertCompta.setTrfIdOrigine(this.reglements.getRglId());
               this.transfertCompta.setTrfAgent(this.reglements.getRglNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.reglements.getRglDateReg());
               this.transfertCompta.setTrfCode(var7);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var7, this.reglements.getRglDateReg()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.reglements.getRglDateReg()));
               String var19;
               if (this.reglements.getRglTypeTiers() != 0 && (this.reglements.getRglTypeTiers() != 1 || this.reglements.getRglIdTiers() == 0L)) {
                  if (this.reglements.getRglTypeTiers() == 2 && this.reglements.getRglIdTiers() != 0L) {
                     var19 = this.formTransfertCtrl.calculeCompteAgent(this.reglements.getRglIdTiers(), var3, var5);
                     this.transfertCompta.setTrfCompte(var19);
                  } else if (this.reglements.getRglTypeTiers() == 3 && this.reglements.getRglIdTiers() == 0L) {
                     if (this.reglements.getRglNomTiers() != null && !this.reglements.getRglNomTiers().isEmpty() && this.reglements.getRglNomTiers().contains(":")) {
                        var17 = this.reglements.getRglNomTiers().split(":");
                        this.transfertCompta.setTrfCompte(var17[0]);
                     } else {
                        this.transfertCompta.setTrfCompte(this.reglements.getRglNomTiers());
                     }
                  } else if (this.reglements.getRglTypeTiers() == 4 && this.reglements.getRglIdTiers() != 0L) {
                     this.transfertCompta.setTrfCompte(this.optionMedical.getComptePatient());
                     this.transfertCompta.setTrfLibelle("Patient comptant");
                  } else if (this.reglements.getRglTypeTiers() == 5 && this.reglements.getRglIdTiers() == 0L) {
                     if (this.reglements.getRglNomTiers() != null && !this.reglements.getRglNomTiers().isEmpty() && this.reglements.getRglNomTiers().contains(":")) {
                        var17 = this.reglements.getRglNomTiers().split(":");
                        this.transfertCompta.setTrfCompte(var17[0]);
                     } else {
                        this.transfertCompta.setTrfCompte(this.reglements.getRglNomTiers());
                     }
                  } else if (this.reglements.getRglTypeTiers() == 6 && this.reglements.getRglIdTiers() != 0L) {
                     var19 = this.formTransfertCtrl.calculeCompteUser(this.reglements.getRglIdTiers(), var5);
                     this.transfertCompta.setTrfCompte(var19);
                  }
               } else {
                  var19 = "";
                  if (this.reglements.getRglNatureDoc() == 7) {
                     var19 = this.optionVentes.getCompteDebit();
                     this.transfertCompta.setTrfCompte(var19);
                  } else {
                     var19 = this.formTransfertCtrl.calculeCompteTiers(this.reglements.getRglIdTiers(), var5);
                     this.transfertCompta.setTrfCompte(var19);
                  }
               }

               if (this.structureLog.getStrid() == 20L) {
                  if (this.transfertCompta.getTrfCompte() == null || this.transfertCompta.getTrfCompte().isEmpty()) {
                     if (this.transfertCompta.getTrfCategorie() == 20) {
                        this.transfertCompta.setTrfCompte("41119999");
                     } else {
                        this.transfertCompta.setTrfCompte("47119999");
                     }
                  }
               } else if (this.structureLog.getStrid() == 24L) {
                  if (this.transfertCompta.getTrfCompte() != null && !this.transfertCompta.getTrfCompte().isEmpty()) {
                     if (!this.transfertCompta.getTrfCompte().startsWith("1") && !this.transfertCompta.getTrfCompte().startsWith("2") && !this.transfertCompta.getTrfCompte().startsWith("3") && !this.transfertCompta.getTrfCompte().startsWith("4") && !this.transfertCompta.getTrfCompte().startsWith("5") && !this.transfertCompta.getTrfCompte().startsWith("6") && !this.transfertCompta.getTrfCompte().startsWith("7") && !this.transfertCompta.getTrfCompte().startsWith("8") && !this.transfertCompta.getTrfCompte().startsWith("9")) {
                        this.transfertCompta.setTrfCompte("47110000");
                     }
                  } else {
                     this.transfertCompta.setTrfCompte("47110000");
                  }
               }

               if (this.reglements.getRglActiviteCompte() != null && !this.reglements.getRglActiviteCompte().isEmpty() && !this.reglements.isRglActiviteExo() && this.reglements.getRglActiviteTaux() != 0.0F) {
                  if (this.reglements.getRglDepense() != 0.0D && this.reglements.getRglRecette() == 0.0D) {
                     var13 = this.utilNombre.myRoundDevise(this.reglements.getRglDepense() / (double)(1.0F + this.reglements.getRglActiviteTaux() / 100.0F), this.structureLog.getStrdevise());
                     this.transfertCompta.setTrfDebitSaisie(var13);
                     this.transfertCompta.setTrfCreditSaisie(0.0D);
                  } else {
                     this.transfertCompta.setTrfDebitSaisie(0.0D);
                     var11 = this.utilNombre.myRoundDevise(this.reglements.getRglRecette() / (double)(1.0F + this.reglements.getRglActiviteTaux() / 100.0F), this.structureLog.getStrdevise());
                     this.transfertCompta.setTrfCreditSaisie(var11);
                  }
               } else if (this.reglements.getRglDepense() != 0.0D && this.reglements.getRglRecette() == 0.0D) {
                  this.transfertCompta.setTrfDebitSaisie(this.reglements.getRglDepense());
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
               } else {
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.reglements.getRglRecette());
               }

               this.transfertCompta.setTrfDateEcheance((Date)null);
               this.transfertCompta.setTrfDateValeurTheo(this.reglements.getRglDateValeur());
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneCaisse(var16, var5);
               if (this.reglements.getRglTypeTiers() == 4 && this.reglements.getRglIdTiers() != 0L) {
                  this.transfertCompta.setTrfLibelle("Patient comptant");
               }

               this.transfertCompta.setTrfBudget("");
               boolean var20;
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  if (this.transfertCompta.getTrfCompte() != null && !this.transfertCompta.getTrfCompte().isEmpty()) {
                     var20 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var5);
                     if (var20) {
                        this.analytiqueOperationCaisse();
                        this.lesTransfertCompta.add(this.transfertCompta);
                     } else {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  } else {
                     this.analytiqueOperationCaisse();
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }

               if (this.reglements.getRglActiviteCompte() != null && !this.reglements.getRglActiviteCompte().isEmpty() && !this.reglements.isRglActiviteExo() && this.reglements.getRglActiviteTaux() != 0.0F) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("60");
                  this.transfertCompta.setTrfCategorie(this.reglements.getRglCategorie());
                  this.transfertCompta.setTrfNature(this.reglements.getRglNatureDoc());
                  this.transfertCompta.setTrfIdResponsable(this.reglements.getRglIdResponsable());
                  this.transfertCompta.setTrfNomResponsable(this.reglements.getRglNomResponsable());
                  var15 = "";
                  var16 = "";
                  if (this.reglements.getRglBanqueTireur() != null && !this.reglements.getRglBanqueTireur().isEmpty() && !this.reglements.getRglBanqueTireur().equals("0")) {
                     var15 = this.reglements.getRglBanqueTireur();
                  }

                  if (this.reglements.getRglNumChqBdx() != null && !this.reglements.getRglNumChqBdx().isEmpty() && !this.reglements.getRglNumChqBdx().equals("0")) {
                     var15 = var15 + " " + this.reglements.getRglNumChqBdx();
                     var16 = this.reglements.getRglNumChqBdx();
                  }

                  if (this.reglements.getRglActivite() != null && !this.reglements.getRglActivite().isEmpty() && !this.reglements.getRglActivite().equals("0") && !this.decoupageActivite) {
                     if (this.reglements.getRglActivite() != null && !this.reglements.getRglActivite().isEmpty() && this.reglements.getRglActivite().contains(":")) {
                        var17 = this.reglements.getRglActivite().split(":");
                        var15 = var15 + " " + var17[0];
                     } else {
                        var15 = var15 + " " + this.reglements.getRglActivite();
                     }
                  }

                  if (this.reglements.getRglDossier() != null && !this.reglements.getRglDossier().isEmpty() && !this.reglements.getRglDossier().equals("0")) {
                     var15 = var15 + " " + this.reglements.getRglDossier();
                  }

                  this.transfertCompta.setTrfSuite(var15);
                  this.transfertCompta.setTrfIdOrigine(this.reglements.getRglId());
                  this.transfertCompta.setTrfAgent(this.reglements.getRglNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.reglements.getRglDateReg());
                  this.transfertCompta.setTrfCode(var7);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var7, this.reglements.getRglDateReg()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.reglements.getRglDateReg()));
                  this.transfertCompta.setTrfCompte(this.reglements.getRglActiviteCompte());
                  double var21;
                  if (this.reglements.getRglDepense() != 0.0D && this.reglements.getRglRecette() == 0.0D) {
                     var21 = this.reglements.getRglDepense() - var13;
                     this.transfertCompta.setTrfDebitSaisie(var21);
                     this.transfertCompta.setTrfCreditSaisie(0.0D);
                  } else {
                     this.transfertCompta.setTrfDebitSaisie(0.0D);
                     var21 = this.reglements.getRglRecette() - var11;
                     this.transfertCompta.setTrfCreditSaisie(var21);
                  }

                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo(this.reglements.getRglDateValeur());
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneCaisse(var16, var5);
                  this.transfertCompta.setTrfBudget("");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     if (this.transfertCompta.getTrfCompte() != null && !this.transfertCompta.getTrfCompte().isEmpty()) {
                        var20 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var5);
                        if (var20) {
                           this.analytiqueOperationCaisse();
                           this.lesTransfertCompta.add(this.transfertCompta);
                        } else {
                           this.lesTransfertCompta.add(this.transfertCompta);
                        }
                     } else {
                        this.analytiqueOperationCaisse();
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  }
               }

               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("60");
               this.transfertCompta.setTrfCategorie(this.reglements.getRglCategorie());
               this.transfertCompta.setTrfNature(this.reglements.getRglNatureDoc());
               this.transfertCompta.setTrfIdResponsable(this.reglements.getRglIdResponsable());
               this.transfertCompta.setTrfNomResponsable(this.reglements.getRglNomResponsable());
               var15 = "";
               if (this.reglements.getRglBanqueTireur() != null && !this.reglements.getRglBanqueTireur().isEmpty() && !this.reglements.getRglBanqueTireur().equals("0")) {
                  var15 = this.reglements.getRglBanqueTireur();
               }

               if (this.reglements.getRglNumChqBdx() != null && !this.reglements.getRglNumChqBdx().isEmpty() && !this.reglements.getRglNumChqBdx().equals("0")) {
                  var15 = var15 + " " + this.reglements.getRglNumChqBdx();
               }

               if (this.reglements.getRglActivite() != null && !this.reglements.getRglActivite().isEmpty() && !this.reglements.getRglActivite().equals("0") && !this.decoupageActivite) {
                  if (this.reglements.getRglActivite() != null && !this.reglements.getRglActivite().isEmpty() && this.reglements.getRglActivite().contains(":")) {
                     var17 = this.reglements.getRglActivite().split(":");
                     var15 = var15 + " " + var17[0];
                  } else {
                     var15 = var15 + " " + this.reglements.getRglActivite();
                  }
               }

               if (this.reglements.getRglDossier() != null && !this.reglements.getRglDossier().isEmpty() && !this.reglements.getRglDossier().equals("0")) {
                  var15 = var15 + " " + this.reglements.getRglDossier();
               }

               this.transfertCompta.setTrfSuite(var15);
               this.transfertCompta.setTrfIdOrigine(this.reglements.getRglId());
               this.transfertCompta.setTrfAgent(this.reglements.getRglNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.reglements.getRglDateReg());
               this.transfertCompta.setTrfCode(var7);
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var7, this.reglements.getRglDateReg()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.reglements.getRglDateReg()));
               if (this.reglements.getRglTypeReg() == 1) {
                  this.transfertCompta.setTrfCompte(var10);
               } else {
                  this.transfertCompta.setTrfCompte(var9);
               }

               if (this.reglements.getRglDepense() != 0.0D && this.reglements.getRglRecette() == 0.0D) {
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.reglements.getRglDepense() + this.reglements.getRglTimbre());
               } else {
                  this.transfertCompta.setTrfDebitSaisie(this.reglements.getRglRecette() + this.reglements.getRglTimbre());
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
               }

               this.transfertCompta.setTrfDateEcheance((Date)null);
               this.transfertCompta.setTrfDateValeurTheo(this.reglements.getRglDateValeur());
               this.transfertCompta.setTrfPiece("");
               this.calculeZoneCaisse(var16, var5);
               if (this.reglements.getRglCodeBudgetTreso() != null && !this.reglements.getRglCodeBudgetTreso().isEmpty()) {
                  this.transfertCompta.setTrfBudget(this.reglements.getRglCodePosteTreso() + ":" + this.reglements.getRglCodeBudgetTreso());
               } else {
                  this.transfertCompta.setTrfBudget(this.reglements.getRglCodePosteTreso());
               }

               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }

               if (this.reglements.getRglTimbre() != 0.0D) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("60");
                  this.transfertCompta.setTrfCategorie(this.reglements.getRglCategorie());
                  this.transfertCompta.setTrfNature(this.reglements.getRglNatureDoc());
                  this.transfertCompta.setTrfIdResponsable(this.reglements.getRglIdResponsable());
                  this.transfertCompta.setTrfNomResponsable(this.reglements.getRglNomResponsable());
                  this.transfertCompta.setTrfIdOrigine(this.reglements.getRglId());
                  this.transfertCompta.setTrfAgent(this.reglements.getRglNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.reglements.getRglDateReg());
                  this.transfertCompta.setTrfCode(var7);
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var7, this.reglements.getRglDateReg()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.reglements.getRglDateReg()));
                  this.transfertCompta.setTrfCompte(var4);
                  if (this.reglements.getRglDepense() != 0.0D && this.reglements.getRglRecette() == 0.0D) {
                     this.transfertCompta.setTrfDebitSaisie(this.reglements.getRglTimbre());
                     this.transfertCompta.setTrfCreditSaisie(0.0D);
                  } else {
                     this.transfertCompta.setTrfDebitSaisie(0.0D);
                     this.transfertCompta.setTrfCreditSaisie(this.reglements.getRglTimbre());
                  }

                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo(this.reglements.getRglDateValeur());
                  this.transfertCompta.setTrfPiece("");
                  this.calculeZoneCaisse(var16, var5);
                  this.transfertCompta.setTrfBudget("");
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }
         }
      }

   }

   public void calculeZoneCaisse(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = "";
      if (this.optionCaisses.getZoneRef1() != null && !this.optionCaisses.getZoneRef1().isEmpty() && !this.optionCaisses.getZoneRef1().equals("") && !this.optionCaisses.getZoneRef1().equals("0")) {
         if (this.optionCaisses.getZoneRef1() != null && !this.optionCaisses.getZoneRef1().isEmpty() && this.optionCaisses.getZoneRef1().equals("1")) {
            this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
         }
      } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
         if (this.optionCaisses.getZoneRef1Serie().equals("0")) {
            this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
         } else if (this.optionCaisses.getZoneRef1Serie().equals("1")) {
            this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
         }
      } else {
         this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
      }

      if (this.optionCaisses.getZoneRef2() != null && !this.optionCaisses.getZoneRef2().isEmpty() && !this.optionCaisses.getZoneRef2().equals("") && !this.optionCaisses.getZoneRef2().equals("0")) {
         if (this.optionCaisses.getZoneRef2() != null && !this.optionCaisses.getZoneRef2().isEmpty() && this.optionCaisses.getZoneRef2().equals("1")) {
            if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
               if (this.optionCaisses.getZoneRef2Serie().equals("0")) {
                  this.transfertCompta.setTrfReference2(this.reglements.getRglSerie() + ":" + this.reglements.getRglDocument());
               } else if (this.optionCaisses.getZoneRef2Serie().equals("1")) {
                  this.transfertCompta.setTrfReference2(this.reglements.getRglNum());
               }
            } else {
               this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
            }
         } else if (this.optionCaisses.getZoneRef2() != null && !this.optionCaisses.getZoneRef2().isEmpty() && this.optionCaisses.getZoneRef2().equals("2")) {
            if (this.reglements.getRglCategorie() == 10) {
               if (this.reglements.getRglNatureDoc() == 12 && this.reglements.getRglIdDocument() != 0L) {
                  new CommandeEnteteAchats();
                  CommandeEnteteAchatsDao var5 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                  CommandeEnteteAchats var4 = var5.pourParapheur(this.reglements.getRglIdDocument(), var2);
                  if (var4 != null) {
                     this.transfertCompta.setTrfReference2(var4.getCmdAnal4());
                     var3 = var4.getCmdObject();
                  } else {
                     if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                        if (this.optionCaisses.getZoneRef2Serie().equals("0")) {
                           this.transfertCompta.setTrfReference2(this.reglements.getRglSerie() + ":" + this.reglements.getRglDocument() + "CMD ");
                        } else if (this.optionCaisses.getZoneRef2Serie().equals("1")) {
                           this.transfertCompta.setTrfReference2(this.reglements.getRglDocument() + "CMD ");
                        }
                     } else {
                        this.transfertCompta.setTrfReference2(this.reglements.getRglDocument() + "CMD ");
                     }

                     var3 = this.reglements.getRglObjet();
                  }
               } else if (this.reglements.getRglNatureDoc() == 15 && this.reglements.getRglIdDocument() != 0L) {
                  this.factureEnteteAchats = new FactureEnteteAchats();
                  this.factureEnteteAchatsDao = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                  this.factureEnteteAchats = this.factureEnteteAchatsDao.pourParapheur(this.reglements.getRglIdDocument(), var2);
                  if (this.factureEnteteAchats != null) {
                     this.transfertCompta.setTrfReference2(this.factureEnteteAchats.getFcfAnal4());
                     var3 = this.factureEnteteAchats.getFcfObject();
                  } else {
                     if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                        if (this.optionCaisses.getZoneRef2Serie().equals("0")) {
                           this.transfertCompta.setTrfReference2(this.reglements.getRglSerie() + ":" + this.reglements.getRglDocument() + "FCF ");
                        } else if (this.optionCaisses.getZoneRef2Serie().equals("1")) {
                           this.transfertCompta.setTrfReference2(this.reglements.getRglDocument() + "FCF ");
                        }
                     } else {
                        this.transfertCompta.setTrfReference2(this.reglements.getRglDocument() + "FCF ");
                     }

                     var3 = this.reglements.getRglObjet();
                  }
               } else if (this.reglements.getRglNatureDoc() == 18 && this.reglements.getRglIdDocument() != 0L) {
                  this.fraisEnteteAchats = new FraisEnteteAchats();
                  this.fraisEnteteAchatsDao = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                  this.fraisEnteteAchats = this.fraisEnteteAchatsDao.pourParapheur(this.reglements.getRglIdDocument(), var2);
                  if (this.fraisEnteteAchats != null) {
                     this.transfertCompta.setTrfReference2(this.fraisEnteteAchats.getFsfAnal4());
                     var3 = this.fraisEnteteAchats.getFsfObject();
                  } else {
                     if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                        if (this.optionCaisses.getZoneRef2Serie().equals("0")) {
                           this.transfertCompta.setTrfReference2(this.reglements.getRglSerie() + ":" + this.reglements.getRglDocument() + "FSF ");
                        } else if (this.optionCaisses.getZoneRef2Serie().equals("1")) {
                           this.transfertCompta.setTrfReference2(this.reglements.getRglDocument() + "FSF ");
                        }
                     } else {
                        this.transfertCompta.setTrfReference2(this.reglements.getRglDocument() + "FSF ");
                     }

                     var3 = this.reglements.getRglObjet();
                  }
               } else {
                  this.transfertCompta.setTrfReference2("Decaissement Nature doc " + this.reglements.getRglSerie() + ":" + this.reglements.getRglNatureDoc());
               }
            } else if (this.reglements.getRglCategorie() != 20 && this.reglements.getRglCategorie() != 30 && this.reglements.getRglCategorie() != 40) {
               if (this.reglements.getRglCategorie() == 62) {
                  this.transfertCompta.setTrfReference2(this.reglements.getRglNum());
                  var3 = this.reglements.getRglNomTiers() + this.reglements.getRglObjet() + var1;
               } else if (this.reglements.getRglCategorie() == 63) {
                  this.transfertCompta.setTrfReference2(this.reglements.getRglNum());
                  var3 = this.reglements.getRglNomTiers() + this.reglements.getRglObjet() + var1;
               } else if (this.reglements.getRglCategorie() == 64) {
                  this.transfertCompta.setTrfReference2(this.reglements.getRglNum());
               } else {
                  this.transfertCompta.setTrfReference2("Autre Nature doc " + this.reglements.getRglNatureDoc());
               }
            } else if (this.reglements.getRglNatureDoc() == 22 && this.reglements.getRglIdDocument() != 0L) {
               this.commandeEnteteVentes = new CommandeEnteteVentes();
               this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               this.commandeEnteteVentes = this.commandeEnteteVentesDao.pourParapheur(this.reglements.getRglIdDocument(), var2);
               if (this.commandeEnteteVentes != null) {
                  this.transfertCompta.setTrfReference2(this.commandeEnteteVentes.getBcmNum());
                  var3 = this.commandeEnteteVentes.getBcmObject();
               } else {
                  if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                     if (this.optionCaisses.getZoneRef2Serie().equals("0")) {
                        this.transfertCompta.setTrfReference2(this.reglements.getRglSerie() + ":" + this.reglements.getRglDocument() + "BCM ");
                     } else if (this.optionCaisses.getZoneRef2Serie().equals("1")) {
                        this.transfertCompta.setTrfReference2(this.reglements.getRglDocument() + "BCM ");
                     }
                  } else {
                     this.transfertCompta.setTrfReference2(this.reglements.getRglDocument() + "BCM ");
                  }

                  var3 = this.reglements.getRglObjet();
               }
            } else if (this.reglements.getRglNatureDoc() == 25 && this.reglements.getRglIdDocument() != 0L) {
               this.factureEnteteVentes = new FactureEnteteVentes();
               this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(this.reglements.getRglIdDocument(), var2);
               if (this.factureEnteteVentes != null) {
                  this.transfertCompta.setTrfReference2(this.factureEnteteVentes.getFacNum());
                  var3 = this.factureEnteteVentes.getFacObject();
               } else {
                  if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                     if (this.optionCaisses.getZoneRef2Serie().equals("0")) {
                        this.transfertCompta.setTrfReference2(this.reglements.getRglSerie() + ":" + this.reglements.getRglDocument() + "FAC ");
                     } else if (this.optionCaisses.getZoneRef2Serie().equals("1")) {
                        this.transfertCompta.setTrfReference2(this.reglements.getRglDocument() + "FAC ");
                     }
                  } else {
                     this.transfertCompta.setTrfReference2(this.reglements.getRglDocument() + "FAC ");
                  }

                  var3 = this.reglements.getRglObjet();
               }
            } else if (this.optionCaisses.getZoneRef2Serie().equals("0")) {
               this.transfertCompta.setTrfReference2("Encaissement Nature doc " + this.reglements.getRglSerie() + ":" + this.reglements.getRglNatureDoc());
            } else if (this.optionCaisses.getZoneRef2Serie().equals("1")) {
               this.transfertCompta.setTrfReference2("Encaissement Nature doc :" + this.reglements.getRglNatureDoc());
            }
         }
      } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
         if (this.optionCaisses.getZoneRef2Serie().equals("0")) {
            this.transfertCompta.setTrfReference2(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
         } else if (this.optionCaisses.getZoneRef2Serie().equals("1")) {
            this.transfertCompta.setTrfReference2(this.reglements.getRglNum());
         }
      } else {
         this.transfertCompta.setTrfReference2(this.reglements.getRglNum());
      }

      String var8 = "";
      if (this.reglements.getRglObjet() != null && !this.reglements.getRglObjet().isEmpty()) {
         var8 = this.reglements.getRglObjet();
      }

      String var9 = "";
      if (this.reglements.getRglLibelle() != null && !this.reglements.getRglLibelle().isEmpty()) {
         var9 = " " + this.reglements.getRglLibelle();
      }

      String var6 = "";
      if (this.reglements.getRglNomTiers() != null && !this.reglements.getRglNomTiers().isEmpty()) {
         if (this.reglements.getRglNomTiers() != null && !this.reglements.getRglNomTiers().isEmpty() && this.reglements.getRglNomTiers().contains(":") && !this.reglements.getRglNomTiers().endsWith(":")) {
            String[] var7 = this.reglements.getRglNomTiers().split(":");
            var6 = " " + var7[1];
         } else {
            var6 = " " + this.reglements.getRglNomTiers();
         }
      }

      if (this.reglements.getRglCategorie() != 62 && this.reglements.getRglCategorie() != 63) {
         if (this.optionCaisses.getZoneLibelle() != null && !this.optionCaisses.getZoneLibelle().isEmpty() && this.optionCaisses.getZoneLibelle().contains("0")) {
            this.transfertCompta.setTrfLibelle(var8 + var9 + var6);
         } else if (this.optionCaisses.getZoneLibelle() != null && !this.optionCaisses.getZoneLibelle().isEmpty() && this.optionCaisses.getZoneLibelle().contains("1")) {
            var8 = "DOC." + this.reglements.getRglDocument();
            this.transfertCompta.setTrfLibelle(var8 + " " + var6);
         } else if (this.optionCaisses.getZoneLibelle() != null && !this.optionCaisses.getZoneLibelle().isEmpty() && this.optionCaisses.getZoneLibelle().contains("2")) {
            this.transfertCompta.setTrfLibelle(var6);
         } else if (this.optionCaisses.getZoneLibelle() != null && !this.optionCaisses.getZoneLibelle().isEmpty() && this.optionCaisses.getZoneLibelle().contains("3")) {
            var8 = "DOC." + this.reglements.getRglDocument();
            this.transfertCompta.setTrfLibelle(var8);
         } else if (this.optionCaisses.getZoneLibelle() != null && !this.optionCaisses.getZoneLibelle().isEmpty() && this.optionCaisses.getZoneLibelle().contains("4")) {
            this.transfertCompta.setTrfLibelle(var8 + var9 + var1 + var6);
         } else if (this.optionCaisses.getZoneLibelle() != null && !this.optionCaisses.getZoneLibelle().isEmpty() && this.optionCaisses.getZoneLibelle().contains("5")) {
            this.transfertCompta.setTrfLibelle(var3);
         }
      } else if (this.optionCaisses.getZoneLibelle() != null && !this.optionCaisses.getZoneLibelle().isEmpty() && this.optionCaisses.getZoneLibelle().contains("5")) {
         this.transfertCompta.setTrfLibelle(var3);
      } else {
         this.transfertCompta.setTrfLibelle(var8 + "" + var9);
      }

   }

   public void analytiqueOperationCaisse() {
      this.transfertCompta.setTrfProjet(this.reglements.getRglCodeBudgetTreso());
      this.transfertCompta.setTrfTreso(this.reglements.getRglCodePosteTreso());
      this.transfertCompta.setTrfRepartitionCle1("");
      this.transfertCompta.setTrfRepartitionCle2("");
      String[] var1;
      if (this.reglements.getRglCle1Repartition() != null && !this.reglements.getRglCle1Repartition().isEmpty() && this.reglements.getRglCle1Repartition().contains(":") || this.reglements.getRglCle2Repartition() != null && !this.reglements.getRglCle2Repartition().isEmpty() && this.reglements.getRglCle2Repartition().contains(":")) {
         if (this.reglements.getRglCle1Repartition() != null && !this.reglements.getRglCle1Repartition().isEmpty() && this.reglements.getRglCle1().contains(":")) {
            var1 = this.reglements.getRglCle1Repartition().split(":");
            this.transfertCompta.setTrfRepartitionCle1(var1[0]);
         }

         if (this.reglements.getRglCle2Repartition() != null && !this.reglements.getRglCle2Repartition().isEmpty() && this.reglements.getRglCle2Repartition().contains(":")) {
            var1 = this.reglements.getRglCle2Repartition().split(":");
            this.transfertCompta.setTrfRepartitionCle2(var1[0]);
         }
      }

      if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
         if (this.transfertCompta.getTrfActivite() == null || this.transfertCompta.getTrfActivite().isEmpty()) {
            if (this.decoupageActivite) {
               this.transfertCompta.setTrfActivite(this.reglements.getRglActivite());
            } else if (this.reglements.getRglActivite() != null && !this.reglements.getRglActivite().isEmpty() && this.reglements.getRglActivite().contains(":") && this.reglements.getRglActivite().length() >= 3) {
               var1 = this.reglements.getRglActivite().split(":");
               this.transfertCompta.setTrfActivite(var1[0]);
            } else {
               this.transfertCompta.setTrfActivite(this.reglements.getRglActivite());
            }
         }

         if (this.reglements.getRglSite() != null && !this.reglements.getRglSite().isEmpty() && this.reglements.getRglSite().contains(":") && this.reglements.getRglSite().length() >= 3) {
            var1 = this.reglements.getRglSite().split(":");
            this.transfertCompta.setTrfSite(var1[0]);
         } else {
            this.transfertCompta.setTrfSite(this.reglements.getRglSite());
         }

         if (this.reglements.getRglDepartement() != null && !this.reglements.getRglDepartement().isEmpty() && this.reglements.getRglDepartement().contains(":") && this.reglements.getRglDepartement().length() >= 3) {
            var1 = this.reglements.getRglDepartement().split(":");
            this.transfertCompta.setTrfDepartement(var1[0]);
         } else {
            this.transfertCompta.setTrfDepartement(this.reglements.getRglDepartement());
         }

         if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && this.reglements.getRglService().contains(":") && this.reglements.getRglService().length() >= 3) {
            var1 = this.reglements.getRglService().split(":");
            this.transfertCompta.setTrfService(var1[0]);
         } else {
            this.transfertCompta.setTrfService(this.reglements.getRglService());
         }

         if (this.reglements.getRglRegion() != null && !this.reglements.getRglRegion().isEmpty() && this.reglements.getRglRegion().contains(":") && this.reglements.getRglRegion().length() >= 3) {
            var1 = this.reglements.getRglRegion().split(":");
            this.transfertCompta.setTrfRegion(var1[0]);
         } else {
            this.transfertCompta.setTrfRegion(this.reglements.getRglRegion());
         }

         if (this.reglements.getRglSecteur() != null && !this.reglements.getRglSecteur().isEmpty() && this.reglements.getRglSecteur().contains(":") && this.reglements.getRglSecteur().length() >= 3) {
            var1 = this.reglements.getRglSecteur().split(":");
            this.transfertCompta.setTrfSecteur(var1[0]);
         } else {
            this.transfertCompta.setTrfSecteur(this.reglements.getRglSecteur());
         }

         if (this.reglements.getRglPdv() != null && !this.reglements.getRglPdv().isEmpty() && this.reglements.getRglPdv().contains(":") && this.reglements.getRglPdv().length() >= 3) {
            var1 = this.reglements.getRglPdv().split(":");
            this.transfertCompta.setTrfPdv(var1[0]);
         } else {
            this.transfertCompta.setTrfPdv(this.reglements.getRglPdv());
         }

         if (this.reglements.getRglDossier() != null && !this.reglements.getRglDossier().isEmpty() && this.reglements.getRglDossier().contains(":") && this.reglements.getRglDossier().length() >= 3) {
            var1 = this.reglements.getRglDossier().split(":");
            this.transfertCompta.setTrfDossier(var1[0]);
         } else {
            this.transfertCompta.setTrfDossier(this.reglements.getRglDossier());
         }

         if (this.reglements.getRglParc() != null && !this.reglements.getRglParc().isEmpty() && this.reglements.getRglParc().length() >= 3) {
            if (this.reglements.getRglParc().contains(":0:")) {
               this.transfertCompta.setTrfParc(this.reglements.getRglParc());
            } else if (this.reglements.getRglParc().contains(":")) {
               var1 = this.reglements.getRglParc().split(":");
               this.transfertCompta.setTrfParc(var1[0]);
            } else {
               this.transfertCompta.setTrfParc(this.reglements.getRglParc());
            }
         } else {
            this.transfertCompta.setTrfParc(this.reglements.getRglParc());
         }
      } else {
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfDossier("");
         this.transfertCompta.setTrfParc("");
      }

   }

   public String traitementOperationVirement(DocumentEntete var1, ExercicesCaisse var2, ExercicesPaye var3, String var4, Session var5) throws HibernateException, NamingException {
      String var6 = "";
      this.reglements = this.reglementsDao.pourParapheur(var1.getDocId(), var5);
      if (this.reglements != null) {
         boolean var7 = true;
         this.caissesCommerciales = this.caissesCommercialesDao.selectCaisse(var2.getExecaiId(), this.reglements.getRglCodeCaiss(), var5);
         if (this.caissesCommerciales != null) {
            if (this.reglements.getRglTypeReg() != 0 && this.reglements.getRglTypeReg() != 11 && this.reglements.getRglTypeReg() != 100) {
               if (this.reglements.getRglTypeReg() == 1) {
                  if (!this.caissesCommerciales.isCaiExportJrCheque()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 2) {
                  if (!this.caissesCommerciales.isCaiExportJrVirement()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 3) {
                  if (!this.caissesCommerciales.isCaiExportJrTraite()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 4) {
                  if (!this.caissesCommerciales.isCaiExportJrTpe()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 5) {
                  if (!this.caissesCommerciales.isCaiExportJrTrf()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 6) {
                  if (!this.caissesCommerciales.isCaiExportJrePaiement()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 7) {
                  if (!this.caissesCommerciales.isCaiExportJrCredoc()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 8) {
                  if (!this.caissesCommerciales.isCaiExportJrFactor()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 9) {
                  if (!this.caissesCommerciales.isCaiExportJrCompense()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 10) {
                  if (!this.caissesCommerciales.isCaiExportJrTerme()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 12) {
                  if (!this.caissesCommerciales.isCaiExportJrLettreGarantie()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 13) {
                  if (!this.caissesCommerciales.isCaiExportJrPrelevement()) {
                     var7 = false;
                  }
               } else if (this.reglements.getRglTypeReg() == 14 && !this.caissesCommerciales.isCaiExportJrAlcoin()) {
                  var7 = false;
               }
            } else if (!this.caissesCommerciales.isCaiExportJrEspece()) {
               var7 = false;
            }
         }

         if (var7 && this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty()) {
            this.caissesOperations = new CaissesOperations();
            this.caissesOperations = this.caissesOperationsDao.selectOperationByCode(this.reglements.getRglOperation(), var5);
            if (this.caissesOperations != null && this.caissesOperations.getCaiopeTransfert() == 1) {
               var7 = false;
            }
         }

         if (var7) {
            boolean var8 = false;
            boolean var9 = false;
            int var10 = 0;
            int var11 = 0;
            if (var1.getDocCodeEmetrice() != null && !var1.getDocCodeEmetrice().isEmpty() || var1.getDocCodeReceptrice() != null && !var1.getDocCodeReceptrice().isEmpty()) {
               JournauxComptables var12;
               if (var1.getDocCodeEmetrice() != null && !var1.getDocCodeEmetrice().isEmpty()) {
                  new JournauxComptables();
                  var12 = this.journauxComptablesDao.chercherCode(var1.getDocCodeEmetrice(), this.exercicesComptable.getExecpt_id(), var5);
                  if (var12 != null) {
                     var10 = var12.getPljNature();
                  }
               }

               if (var1.getDocCodeReceptrice() != null && !var1.getDocCodeReceptrice().isEmpty()) {
                  new JournauxComptables();
                  var12 = this.journauxComptablesDao.chercherCode(var1.getDocCodeReceptrice(), this.exercicesComptable.getExecpt_id(), var5);
                  if (var12 != null) {
                     var11 = var12.getPljNature();
                  }
               }

               if ((var10 == 7 || var10 == 8) && var11 == 0) {
                  var8 = true;
                  var9 = false;
                  var4 = "";
               } else if ((var10 == 9 || var10 == 10) && var11 == 0) {
                  var8 = true;
                  var9 = false;
                  var4 = "";
               } else if ((var11 == 7 || var11 == 8) && var10 == 0) {
                  var8 = false;
                  var9 = true;
               } else if ((var11 == 9 || var11 == 10) && var10 == 0) {
                  var8 = false;
                  var9 = true;
               } else if (var10 != 7 && var10 != 8 || var11 != 7 && var11 != 8) {
                  if ((var10 == 7 || var10 == 8) && (var11 == 9 || var11 == 10)) {
                     var8 = true;
                     var9 = true;
                  } else if (var10 != 9 && var10 != 10 || var11 != 7 && var11 != 8) {
                     if ((var10 == 9 || var10 == 10) && (var11 == 9 || var11 == 10)) {
                        var8 = true;
                        var9 = true;
                     }
                  } else {
                     var8 = true;
                     var9 = false;
                  }
               } else {
                  var8 = true;
                  var9 = false;
               }
            }

            String var13;
            String var14;
            String var15;
            if (var8 && var1.getDocCodeEmetrice() != null && !var1.getDocCodeEmetrice().isEmpty()) {
               if (var4 != null && !var4.isEmpty()) {
                  var6 = var4;
               } else {
                  var6 = this.formTransfertCtrl.calculeCompteVirtInterne(var1.getDocCodeCaiss(), var1.getDocCodeEmetrice(), var1.getDocCodeReceptrice(), var2, var5);
               }

               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("60");
               this.transfertCompta.setTrfCategorie(this.reglements.getRglCategorie());
               this.transfertCompta.setTrfNature(this.reglements.getRglNatureDoc());
               this.transfertCompta.setTrfSuite("");
               this.transfertCompta.setTrfIdOrigine(this.reglements.getRglId());
               this.transfertCompta.setTrfAgent(this.reglements.getRglNomResponsable());
               this.transfertCompta.setTrfDateSaisie(this.reglements.getRglDateReg());
               this.transfertCompta.setTrfCode(var1.getDocCodeEmetrice());
               this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var1.getDocCodeEmetrice(), this.reglements.getRglDateReg()));
               this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.reglements.getRglDateReg()));
               var15 = "";
               if (this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && this.reglements.getRglOperation().equals("77")) {
                  var15 = this.formTransfertCtrl.calculeCompteCheque(this.reglements.getRglCodeCaiss(), var2, var5);
               } else {
                  var15 = this.formTransfertCtrl.calculeCompteTreso(this.reglements.getRglCodeEmetrice(), var5);
               }

               this.transfertCompta.setTrfCompte(var15);
               if (this.reglements.getRglDepense() != 0.0D && this.reglements.getRglRecette() == 0.0D) {
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
                  this.transfertCompta.setTrfCreditSaisie(this.reglements.getRglDepense());
               } else {
                  this.transfertCompta.setTrfDebitSaisie(this.reglements.getRglRecette());
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
               }

               this.transfertCompta.setTrfDateEcheance((Date)null);
               this.transfertCompta.setTrfDateValeurTheo(this.reglements.getRglDateValeur());
               this.transfertCompta.setTrfPiece("");
               if (this.optionCaisses.getZoneRef1() != null && !this.optionCaisses.getZoneRef1().isEmpty() && !this.optionCaisses.getZoneRef1().equals("") && !this.optionCaisses.getZoneRef1().equals("0")) {
                  if (this.optionCaisses.getZoneRef1().equals("1")) {
                     this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                  }
               } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                  this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
               } else {
                  this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
               }

               if (this.optionCaisses.getZoneRef2() != null && !this.optionCaisses.getZoneRef2().isEmpty() && !this.optionCaisses.getZoneRef2().equals("") && !this.optionCaisses.getZoneRef2().equals("0")) {
                  if (this.optionCaisses.getZoneRef2().equals("1")) {
                     this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                  }
               } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                  this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
               } else {
                  this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
               }

               var13 = "";
               if (this.reglements.getRglObjet() != null && !this.reglements.getRglObjet().isEmpty()) {
                  var13 = this.reglements.getRglObjet();
               }

               var14 = "";
               if (this.reglements.getRglLibelle() != null && !this.reglements.getRglLibelle().isEmpty()) {
                  var14 = " " + this.reglements.getRglLibelle();
               }

               this.transfertCompta.setTrfLibelle(var13 + " " + var14);
               if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                  this.lesTransfertCompta.add(this.transfertCompta);
               }

               if (var6 != null && !var6.isEmpty()) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("60");
                  this.transfertCompta.setTrfCategorie(this.reglements.getRglCategorie());
                  this.transfertCompta.setTrfNature(this.reglements.getRglNatureDoc());
                  this.transfertCompta.setTrfSuite("");
                  this.transfertCompta.setTrfIdOrigine(this.reglements.getRglId());
                  this.transfertCompta.setTrfAgent(this.reglements.getRglNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.reglements.getRglDateReg());
                  this.transfertCompta.setTrfCode(var1.getDocCodeEmetrice());
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var1.getDocCodeEmetrice(), this.reglements.getRglDateReg()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.reglements.getRglDateReg()));
                  this.transfertCompta.setTrfCompte(var6);
                  if (this.reglements.getRglDepense() != 0.0D && this.reglements.getRglRecette() == 0.0D) {
                     this.transfertCompta.setTrfDebitSaisie(this.reglements.getRglDepense());
                     this.transfertCompta.setTrfCreditSaisie(0.0D);
                  } else {
                     this.transfertCompta.setTrfDebitSaisie(0.0D);
                     this.transfertCompta.setTrfCreditSaisie(this.reglements.getRglRecette());
                  }

                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo(this.reglements.getRglDateValeur());
                  this.transfertCompta.setTrfPiece("");
                  if (this.optionCaisses.getZoneRef1() != null && !this.optionCaisses.getZoneRef1().isEmpty() && !this.optionCaisses.getZoneRef1().equals("") && !this.optionCaisses.getZoneRef1().equals("0")) {
                     if (this.optionCaisses.getZoneRef1().equals("1")) {
                        this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                     }
                  } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                     this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
                  } else {
                     this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
                  }

                  if (this.optionCaisses.getZoneRef2() != null && !this.optionCaisses.getZoneRef2().isEmpty() && !this.optionCaisses.getZoneRef2().equals("") && !this.optionCaisses.getZoneRef2().equals("0")) {
                     if (this.optionCaisses.getZoneRef2().equals("1")) {
                        this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                     }
                  } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                     this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
                  } else {
                     this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
                  }

                  var13 = "";
                  if (this.reglements.getRglObjet() != null && !this.reglements.getRglObjet().isEmpty()) {
                     var13 = this.reglements.getRglObjet();
                  }

                  var14 = "";
                  if (this.reglements.getRglLibelle() != null && !this.reglements.getRglLibelle().isEmpty()) {
                     var14 = " " + this.reglements.getRglLibelle();
                  }

                  this.transfertCompta.setTrfLibelle(var13 + " " + var14);
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }
               }
            }

            if (var9) {
               if ((var11 == 7 || var11 == 8 || var11 == 10) && var10 == 0) {
                  if (var1.getDocCodeReceptrice() != null && !var1.getDocCodeReceptrice().isEmpty()) {
                     if (var4 != null && !var4.isEmpty()) {
                        var6 = var4;
                     } else {
                        var6 = this.formTransfertCtrl.calculeCompteVirtInterne(var1.getDocCodeCaiss(), var1.getDocCodeEmetrice(), var1.getDocCodeReceptrice(), var2, var5);
                     }

                     this.transfertCompta = new TransfertCompta();
                     this.transfertCompta.setTrfTypeOrigine("60");
                     this.transfertCompta.setTrfCategorie(this.reglements.getRglCategorie());
                     this.transfertCompta.setTrfNature(this.reglements.getRglNatureDoc());
                     this.transfertCompta.setTrfSuite("");
                     this.transfertCompta.setTrfIdOrigine(this.reglements.getRglId());
                     this.transfertCompta.setTrfAgent(this.reglements.getRglNomResponsable());
                     this.transfertCompta.setTrfDateSaisie(this.reglements.getRglDateReg());
                     this.transfertCompta.setTrfCode(var1.getDocCodeReceptrice());
                     this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var1.getDocCodeReceptrice(), this.reglements.getRglDateReg()));
                     this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.reglements.getRglDateReg()));
                     var15 = this.formTransfertCtrl.calculeCompteTreso(this.reglements.getRglCodeReceptrice(), var5);
                     this.transfertCompta.setTrfCompte(var15);
                     if (this.reglements.getRglDepense() != 0.0D && this.reglements.getRglRecette() == 0.0D) {
                        this.transfertCompta.setTrfDebitSaisie(0.0D);
                        this.transfertCompta.setTrfCreditSaisie(this.reglements.getRglDepense());
                     } else {
                        this.transfertCompta.setTrfDebitSaisie(this.reglements.getRglRecette());
                        this.transfertCompta.setTrfCreditSaisie(0.0D);
                     }

                     this.transfertCompta.setTrfDateEcheance((Date)null);
                     this.transfertCompta.setTrfDateValeurTheo(this.reglements.getRglDateValeur());
                     this.transfertCompta.setTrfPiece("");
                     if (this.optionCaisses.getZoneRef1() != null && !this.optionCaisses.getZoneRef1().isEmpty() && !this.optionCaisses.getZoneRef1().equals("") && !this.optionCaisses.getZoneRef1().equals("0")) {
                        if (this.optionCaisses.getZoneRef1().equals("1")) {
                           this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                        }
                     } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                        this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
                     } else {
                        this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
                     }

                     if (this.optionCaisses.getZoneRef2() != null && !this.optionCaisses.getZoneRef2().isEmpty() && !this.optionCaisses.getZoneRef2().equals("") && !this.optionCaisses.getZoneRef2().equals("0")) {
                        if (this.optionCaisses.getZoneRef2().equals("1")) {
                           this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                        }
                     } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                        this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
                     } else {
                        this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
                     }

                     var13 = "";
                     if (this.reglements.getRglObjet() != null && !this.reglements.getRglObjet().isEmpty()) {
                        var13 = this.reglements.getRglObjet();
                     }

                     var14 = "";
                     if (this.reglements.getRglLibelle() != null && !this.reglements.getRglLibelle().isEmpty()) {
                        var14 = " " + this.reglements.getRglLibelle();
                     }

                     this.transfertCompta.setTrfLibelle(var13 + " " + var14);
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }

                     if (var6 != null && !var6.isEmpty()) {
                        this.transfertCompta = new TransfertCompta();
                        this.transfertCompta.setTrfTypeOrigine("60");
                        this.transfertCompta.setTrfCategorie(this.reglements.getRglCategorie());
                        this.transfertCompta.setTrfNature(this.reglements.getRglNatureDoc());
                        this.transfertCompta.setTrfSuite("");
                        this.transfertCompta.setTrfIdOrigine(this.reglements.getRglId());
                        this.transfertCompta.setTrfAgent(this.reglements.getRglNomResponsable());
                        this.transfertCompta.setTrfDateSaisie(this.reglements.getRglDateReg());
                        this.transfertCompta.setTrfCode(var1.getDocCodeReceptrice());
                        this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var1.getDocCodeReceptrice(), this.reglements.getRglDateReg()));
                        this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.reglements.getRglDateReg()));
                        this.transfertCompta.setTrfCompte(var6);
                        if (this.reglements.getRglDepense() != 0.0D && this.reglements.getRglRecette() == 0.0D) {
                           this.transfertCompta.setTrfDebitSaisie(this.reglements.getRglDepense());
                           this.transfertCompta.setTrfCreditSaisie(0.0D);
                        } else {
                           this.transfertCompta.setTrfDebitSaisie(0.0D);
                           this.transfertCompta.setTrfCreditSaisie(this.reglements.getRglRecette());
                        }

                        this.transfertCompta.setTrfDateEcheance((Date)null);
                        this.transfertCompta.setTrfDateValeurTheo(this.reglements.getRglDateValeur());
                        this.transfertCompta.setTrfPiece("");
                        if (this.optionCaisses.getZoneRef1() != null && !this.optionCaisses.getZoneRef1().isEmpty() && !this.optionCaisses.getZoneRef1().equals("") && !this.optionCaisses.getZoneRef1().equals("0")) {
                           if (this.optionCaisses.getZoneRef1().equals("1")) {
                              this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                           }
                        } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                           this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
                        } else {
                           this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
                        }

                        if (this.optionCaisses.getZoneRef2() != null && !this.optionCaisses.getZoneRef2().isEmpty() && !this.optionCaisses.getZoneRef2().equals("") && !this.optionCaisses.getZoneRef2().equals("0")) {
                           if (this.optionCaisses.getZoneRef2().equals("1")) {
                              this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                           }
                        } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                           this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
                        } else {
                           this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
                        }

                        var13 = "";
                        if (this.reglements.getRglObjet() != null && !this.reglements.getRglObjet().isEmpty()) {
                           var13 = this.reglements.getRglObjet();
                        }

                        var14 = "";
                        if (this.reglements.getRglLibelle() != null && !this.reglements.getRglLibelle().isEmpty()) {
                           var14 = " " + this.reglements.getRglLibelle();
                        }

                        this.transfertCompta.setTrfLibelle(var13 + " " + var14);
                        if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                           this.lesTransfertCompta.add(this.transfertCompta);
                        }
                     }
                  }
               } else if (var1.getDocCodeReceptrice() != null && !var1.getDocCodeReceptrice().isEmpty()) {
                  if (var4 != null && !var4.isEmpty()) {
                     var6 = var4;
                  } else {
                     var6 = this.formTransfertCtrl.calculeCompteVirtInterne(var1.getDocCodeCaiss(), var1.getDocCodeEmetrice(), var1.getDocCodeReceptrice(), var2, var5);
                  }

                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("60");
                  this.transfertCompta.setTrfCategorie(this.reglements.getRglCategorie());
                  this.transfertCompta.setTrfNature(this.reglements.getRglNatureDoc());
                  this.transfertCompta.setTrfSuite("");
                  this.transfertCompta.setTrfIdOrigine(this.reglements.getRglId());
                  this.transfertCompta.setTrfAgent(this.reglements.getRglNomResponsable());
                  this.transfertCompta.setTrfDateSaisie(this.reglements.getRglDateReg());
                  this.transfertCompta.setTrfCode(var1.getDocCodeReceptrice());
                  this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var1.getDocCodeReceptrice(), this.reglements.getRglDateReg()));
                  this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.reglements.getRglDateReg()));
                  var15 = this.formTransfertCtrl.calculeCompteTreso(this.reglements.getRglCodeReceptrice(), var5);
                  this.transfertCompta.setTrfCompte(var15);
                  if (this.reglements.getRglDepense() != 0.0D && this.reglements.getRglRecette() == 0.0D) {
                     this.transfertCompta.setTrfDebitSaisie(this.reglements.getRglDepense());
                     this.transfertCompta.setTrfCreditSaisie(0.0D);
                  } else {
                     this.transfertCompta.setTrfDebitSaisie(0.0D);
                     this.transfertCompta.setTrfCreditSaisie(this.reglements.getRglRecette());
                  }

                  this.transfertCompta.setTrfDateEcheance((Date)null);
                  this.transfertCompta.setTrfDateValeurTheo(this.reglements.getRglDateValeur());
                  this.transfertCompta.setTrfPiece("");
                  if (this.optionCaisses.getZoneRef1() != null && !this.optionCaisses.getZoneRef1().isEmpty() && !this.optionCaisses.getZoneRef1().equals("") && !this.optionCaisses.getZoneRef1().equals("0")) {
                     if (this.optionCaisses.getZoneRef1().equals("1")) {
                        this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                     }
                  } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                     this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
                  } else {
                     this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
                  }

                  if (this.optionCaisses.getZoneRef2() != null && !this.optionCaisses.getZoneRef2().isEmpty() && !this.optionCaisses.getZoneRef2().equals("") && !this.optionCaisses.getZoneRef2().equals("0")) {
                     if (this.optionCaisses.getZoneRef2().equals("1")) {
                        this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                     }
                  } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                     this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
                  } else {
                     this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
                  }

                  var13 = "";
                  if (this.reglements.getRglObjet() != null && !this.reglements.getRglObjet().isEmpty()) {
                     var13 = this.reglements.getRglObjet();
                  }

                  var14 = "";
                  if (this.reglements.getRglLibelle() != null && !this.reglements.getRglLibelle().isEmpty()) {
                     var14 = " " + this.reglements.getRglLibelle();
                  }

                  this.transfertCompta.setTrfLibelle(var13 + " " + var14);
                  if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                     this.lesTransfertCompta.add(this.transfertCompta);
                  }

                  if (var6 != null && !var6.isEmpty()) {
                     this.transfertCompta = new TransfertCompta();
                     this.transfertCompta.setTrfTypeOrigine("60");
                     this.transfertCompta.setTrfCategorie(this.reglements.getRglCategorie());
                     this.transfertCompta.setTrfNature(this.reglements.getRglNatureDoc());
                     this.transfertCompta.setTrfSuite("");
                     this.transfertCompta.setTrfIdOrigine(this.reglements.getRglId());
                     this.transfertCompta.setTrfAgent(this.reglements.getRglNomResponsable());
                     this.transfertCompta.setTrfDateSaisie(this.reglements.getRglDateReg());
                     this.transfertCompta.setTrfCode(var1.getDocCodeReceptrice());
                     this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var1.getDocCodeReceptrice(), this.reglements.getRglDateReg()));
                     this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.reglements.getRglDateReg()));
                     this.transfertCompta.setTrfCompte(var6);
                     if (this.reglements.getRglDepense() != 0.0D && this.reglements.getRglRecette() == 0.0D) {
                        this.transfertCompta.setTrfDebitSaisie(0.0D);
                        this.transfertCompta.setTrfCreditSaisie(this.reglements.getRglDepense());
                     } else {
                        this.transfertCompta.setTrfDebitSaisie(this.reglements.getRglRecette());
                        this.transfertCompta.setTrfCreditSaisie(0.0D);
                     }

                     this.transfertCompta.setTrfDateEcheance((Date)null);
                     this.transfertCompta.setTrfDateValeurTheo(this.reglements.getRglDateValeur());
                     this.transfertCompta.setTrfPiece("");
                     if (this.optionCaisses.getZoneRef1() != null && !this.optionCaisses.getZoneRef1().isEmpty() && !this.optionCaisses.getZoneRef1().equals("") && !this.optionCaisses.getZoneRef1().equals("0")) {
                        if (this.optionCaisses.getZoneRef1().equals("1")) {
                           this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                        }
                     } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                        this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
                     } else {
                        this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
                     }

                     if (this.optionCaisses.getZoneRef2() != null && !this.optionCaisses.getZoneRef2().isEmpty() && !this.optionCaisses.getZoneRef2().equals("") && !this.optionCaisses.getZoneRef2().equals("0")) {
                        if (this.optionCaisses.getZoneRef2().equals("1")) {
                           this.transfertCompta.setTrfReference2(this.reglements.getRglDocument());
                        }
                     } else if (this.reglements.getRglSerie() != null && !this.reglements.getRglSerie().isEmpty()) {
                        this.transfertCompta.setTrfReference1(this.reglements.getRglSerie() + ":" + this.reglements.getRglNum());
                     } else {
                        this.transfertCompta.setTrfReference1(this.reglements.getRglNum());
                     }

                     var13 = "";
                     if (this.reglements.getRglObjet() != null && !this.reglements.getRglObjet().isEmpty()) {
                        var13 = this.reglements.getRglObjet();
                     }

                     var14 = "";
                     if (this.reglements.getRglLibelle() != null && !this.reglements.getRglLibelle().isEmpty()) {
                        var14 = " " + this.reglements.getRglLibelle();
                     }

                     this.transfertCompta.setTrfLibelle(var13 + " " + var14);
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        this.lesTransfertCompta.add(this.transfertCompta);
                     }
                  }
               }
            }
         }
      }

      return var6;
   }

   public void transfertPaye(List var1) throws HibernateException, NamingException, ParseException {
      this.init();
      this.objetPays = new ObjetPays();
      this.lecturePays = new LecturePays();
      this.listPays = this.lecturePays.getMespays();
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "TrfSalarie");
      this.listeDocumentTransfert = var1;
      this.optionPaye = new OptionPaye();
      LireLesoptionsPaye var3 = new LireLesoptionsPaye();
      var3.setStrId(this.structureLog.getStrid());
      this.optionPaye = var3.lancer();
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.bulletinSalaire = new BulletinSalaire();
      this.bulletinSalaireDao = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      this.bulletinLigne = new BulletinLigne();
      this.bulletinLigneDao = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      this.bulletinMois = new BulletinMois();
      this.bulletinMoisDao = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
      this.salaries = new Salaries();
      this.feuilleCalcul = new FeuilleCalcul();
      this.feuilleCalculDao = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalculRubrique = new FeuilleCalculRubrique();
      this.feuilleCalculRubriqueDao = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
      this.planPaye = new PlanPaye();
      this.planPayeDao = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
      new ExercicesPaye();
      ExercicesPayeDao var5 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      ExercicesPaye var4 = var5.recupererLastExo(var2);
      this.lesTransfertCompta.clear();
      this.lesTransfertErreur.clear();
      this.documentEntete = new DocumentEntete();
      if (this.listeDocumentTransfert.size() != 0) {
         for(int var6 = 0; var6 < this.listeDocumentTransfert.size(); ++var6) {
            this.documentEntete = (DocumentEntete)this.listeDocumentTransfert.get(var6);
            if (this.documentEntete.isDocSelect() && this.documentEntete.getDocNature() == 88) {
               this.traitementBulletin(this.documentEntete, var4, var2);
            }
         }

         if (!this.optionPaye.getTrfCptePaye().equals("0")) {
            this.optimisationResultat(this.optionPaye.getTrfCptePaye());
         } else {
            this.optimisationResultat(this.optionComptabilite.getTrf_cptePaye());
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void traitementBulletin(DocumentEntete var1, ExercicesPaye var2, Session var3) throws HibernateException, NamingException {
      this.bulletinSalaire = this.bulletinSalaireDao.pourParapheur(var1.getDocId(), var3);
      if (this.bulletinSalaire != null) {
         new ArrayList();
         List var4 = this.bulletinLigneDao.chargerleslignesBulletin(this.bulletinSalaire, var3);
         if (var4.size() != 0) {
            String var5 = "";
            this.feuilleCalcul = this.feuilleCalculDao.chercherCode(this.bulletinSalaire.getBulsalFeuille(), var2.getExepayId(), var3);
            if (this.feuilleCalcul != null && this.feuilleCalcul.getFeuJournal() != null && !this.feuilleCalcul.getFeuJournal().isEmpty()) {
               if (this.feuilleCalcul.getFeuJournal().contains(":")) {
                  String[] var6 = this.feuilleCalcul.getFeuJournal().split(":");
                  var5 = var6[0];
               } else {
                  var5 = this.feuilleCalcul.getFeuJournal();
               }
            }

            if (var5 != null && !var5.isEmpty() && !var5.startsWith("XX")) {
               String var12 = "";
               String var7 = "";
               String var8 = "";

               for(int var9 = 0; var9 < var4.size(); ++var9) {
                  this.bulletinLigne = (BulletinLigne)var4.get(var9);
                  this.salaries = this.bulletinLigne.getSalaries();
                  var12 = "";
                  var7 = "";
                  var8 = "";
                  if (this.bulletinLigne.getBulligRubrique().equals("600000")) {
                     var12 = this.bulletinLigne.getSalaries().getSalCompteAcompte();
                  } else if (this.bulletinLigne.getBulligRubrique().equals("600100")) {
                     var12 = this.bulletinLigne.getSalaries().getSalCompteAvance();
                  } else if (this.bulletinLigne.getBulligRubrique().equals("600200")) {
                     var12 = this.bulletinLigne.getSalaries().getSalComptePretInt();
                  } else if (this.bulletinLigne.getBulligRubrique().equals("600300")) {
                     var12 = this.bulletinLigne.getSalaries().getSalComptePretExt();
                  } else if (this.bulletinLigne.getBulligRubrique().equals("699999")) {
                     var12 = this.bulletinLigne.getSalaries().getSalCompteNet();
                  } else if ((this.bulletinLigne.getBulligRubrique().equals("600200") || this.bulletinLigne.getBulligRubrique().equals("600300")) && this.bulletinLigne.getBulligIdPretligne() != 0L) {
                     new SalariesPretsLignes();
                     SalariesPretsLignesDao var11 = new SalariesPretsLignesDao(this.baseLog, this.utilInitHibernate);
                     SalariesPretsLignes var10 = var11.pourParapheur(this.bulletinLigne.getBulligIdPretligne(), var3);
                     if (var10 != null && var10.getSalariesPrets().getSalpreCompte() != null && !var10.getSalariesPrets().getSalpreCompte().isEmpty()) {
                        var12 = var10.getSalariesPrets().getSalpreCompte();
                     }
                  }

                  if (var12 == null || var12.isEmpty()) {
                     this.feuilleCalculRubrique = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille((FeuilleCalcul)this.feuilleCalcul, this.bulletinLigne.getBulligRubrique(), 1, var3);
                     if (this.feuilleCalculRubrique != null && this.feuilleCalculRubrique.getFeurubCompte() != null && !this.feuilleCalculRubrique.getFeurubCompte().isEmpty()) {
                        var12 = this.feuilleCalculRubrique.getFeurubCompte();
                     }
                  }

                  this.planPaye = this.planPayeDao.chercherCode(this.bulletinLigne.getBulligRubrique(), var2.getExepayId(), var3);
                  if (this.planPaye != null) {
                     if (var12 == null || var12.isEmpty()) {
                        if (this.bulletinSalaire.getBulsalNature().equals("13") && this.planPaye.getPlpComptePrestataire() != null && !this.planPaye.getPlpComptePrestataire().isEmpty()) {
                           var12 = this.planPaye.getPlpComptePrestataire();
                        } else {
                           var12 = this.planPaye.getPlpCompteNormal();
                        }
                     }

                     if (this.planPaye.getPlpCommentaire() != null && !this.planPaye.getPlpCommentaire().isEmpty()) {
                        var8 = this.planPaye.getPlpCommentaire();
                     }

                     if (this.bulletinSalaire.getBulsalNature().equals("13") && this.planPaye.getPlpCpPrestataire() != null && !this.planPaye.getPlpCpPrestataire().isEmpty()) {
                        var7 = this.planPaye.getPlpCpPrestataire();
                     } else {
                        var7 = this.planPaye.getPlpCpNormal();
                     }
                  }

                  if (var12 != null && !var12.isEmpty()) {
                     this.transfertCompta = new TransfertCompta();
                     var12 = this.calculCompte(var12);
                     this.transfertCompta.setTrfTypeOrigine("80");
                     this.transfertCompta.setTrfCategorie(0);
                     this.transfertCompta.setTrfNature(88);
                     this.transfertCompta.setTrfIdOrigine(this.bulletinLigne.getBulligId());
                     this.transfertCompta.setTrfAgent(this.usersLog.getUsrPatronyme());
                     this.transfertCompta.setTrfDateSaisie(this.bulletinSalaire.getBulsalDateFin());
                     this.transfertCompta.setTrfCode(var5);
                     this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.bulletinSalaire.getBulsalDateFin()));
                     this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bulletinSalaire.getBulsalDateFin()));
                     this.transfertCompta.setTrfCompte(var12);
                     if (this.bulletinLigne.getBulligNature() >= 10 && this.bulletinLigne.getBulligNature() <= 59) {
                        this.transfertCompta.setTrfDebitSaisie(this.bulletinLigne.getBulligValColE());
                        this.transfertCompta.setTrfCreditSaisie(0.0D);
                     } else if (this.bulletinLigne.getBulligNature() != 60 && this.bulletinLigne.getBulligNature() != 61 && (this.bulletinLigne.getBulligNature() != 90 || !var12.startsWith("4")) && this.bulletinLigne.getBulligNature() != 80) {
                        if (this.bulletinLigne.getBulligNature() == 70) {
                           this.transfertCompta.setTrfDebitSaisie(this.bulletinLigne.getBulligValColE());
                           this.transfertCompta.setTrfCreditSaisie(0.0D);
                        } else if (this.bulletinLigne.getBulligNature() == 88) {
                           if (this.bulletinLigne.getBulligRubrique().equals("609000")) {
                              this.transfertCompta.setTrfDebitSaisie(this.bulletinLigne.getBulligValColE());
                              this.transfertCompta.setTrfCreditSaisie(0.0D);
                           } else {
                              this.transfertCompta.setTrfDebitSaisie(0.0D);
                              this.transfertCompta.setTrfCreditSaisie(this.bulletinLigne.getBulligValColE() * -1.0D);
                           }
                        } else if (this.bulletinLigne.getBulligNature() == 89) {
                           this.transfertCompta.setTrfDebitSaisie(0.0D);
                           this.transfertCompta.setTrfCreditSaisie(this.bulletinLigne.getBulligValColE());
                        } else {
                           this.transfertCompta.setTrfDebitSaisie(0.0D);
                           this.transfertCompta.setTrfCreditSaisie(0.0D);
                        }
                     } else {
                        this.transfertCompta.setTrfDebitSaisie(0.0D);
                        this.transfertCompta.setTrfCreditSaisie(this.bulletinLigne.getBulligValColE() * -1.0D);
                     }

                     this.transfertCompta.setTrfDateEcheance((Date)null);
                     this.transfertCompta.setTrfDateValeurTheo((Date)null);
                     this.transfertCompta.setTrfPiece("");
                     this.transfertCompta.setTrfReference1(this.bulletinSalaire.getBulsalPeriode());
                     if (this.bulletinLigne.getBulligNumPret() != null && !this.bulletinLigne.getBulligNumPret().isEmpty()) {
                        this.transfertCompta.setTrfReference2(this.bulletinLigne.getBulligNumPret());
                     } else {
                        this.transfertCompta.setTrfReference2("");
                     }

                     if (var8 != null && !var8.isEmpty()) {
                        this.transfertCompta.setTrfLibelle(var8);
                     } else {
                        this.transfertCompta.setTrfLibelle(this.bulletinLigne.getBulligLibelle());
                     }

                     boolean var13;
                     if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                        var13 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var3);
                        if (var13) {
                           this.analytiqueBulletin();
                           this.lesTransfertCompta.add(this.transfertCompta);
                        } else {
                           this.lesTransfertCompta.add(this.transfertCompta);
                        }
                     }

                     if (var7 != null && !var7.isEmpty()) {
                        this.transfertCompta = new TransfertCompta();
                        var7 = this.calculCompteCp(var7);
                        this.transfertCompta.setTrfTypeOrigine("80");
                        this.transfertCompta.setTrfCategorie(0);
                        this.transfertCompta.setTrfNature(88);
                        this.transfertCompta.setTrfIdOrigine(this.bulletinLigne.getBulligId());
                        this.transfertCompta.setTrfAgent(this.usersLog.getUsrPatronyme());
                        this.transfertCompta.setTrfDateSaisie(this.bulletinSalaire.getBulsalDateFin());
                        this.transfertCompta.setTrfCode(var5);
                        this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(var5, this.bulletinSalaire.getBulsalDateFin()));
                        this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.bulletinSalaire.getBulsalDateFin()));
                        this.transfertCompta.setTrfCompte(var7);
                        if (this.bulletinLigne.getBulligNature() == 90) {
                           this.transfertCompta.setTrfDebitSaisie(this.bulletinLigne.getBulligValColE() * -1.0D);
                           this.transfertCompta.setTrfCreditSaisie(0.0D);
                        } else if (this.bulletinLigne.getBulligNature() == 61) {
                           this.transfertCompta.setTrfDebitSaisie(this.bulletinLigne.getBulligValColE() * -1.0D);
                           this.transfertCompta.setTrfCreditSaisie(0.0D);
                        } else if (this.bulletinLigne.getBulligNature() == 50) {
                           this.transfertCompta.setTrfDebitSaisie(0.0D);
                           this.transfertCompta.setTrfCreditSaisie(this.bulletinLigne.getBulligValColE());
                        } else {
                           this.transfertCompta.setTrfDebitSaisie(0.0D);
                           this.transfertCompta.setTrfCreditSaisie(0.0D);
                        }

                        this.transfertCompta.setTrfDateEcheance((Date)null);
                        this.transfertCompta.setTrfDateValeurTheo((Date)null);
                        this.transfertCompta.setTrfPiece("");
                        this.transfertCompta.setTrfReference1(this.bulletinSalaire.getBulsalPeriode());
                        if (this.bulletinLigne.getBulligNumPret() != null && !this.bulletinLigne.getBulligNumPret().isEmpty()) {
                           this.transfertCompta.setTrfReference2(this.bulletinLigne.getBulligNumPret());
                        } else {
                           this.transfertCompta.setTrfReference2("");
                        }

                        this.transfertCompta.setTrfLibelle(this.bulletinLigne.getBulligLibelle());
                        if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
                           var13 = this.formTransfertCtrl.testCompteAnalytique(this.transfertCompta.getTrfCompte(), var3);
                           if (var13) {
                              this.analytiqueBulletin();
                              this.lesTransfertCompta.add(this.transfertCompta);
                           } else {
                              this.lesTransfertCompta.add(this.transfertCompta);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public String calculCompte(String var1) {
      if (this.planPaye.getPlpGroupe() == 0) {
         if (var1 != null && !var1.isEmpty() && var1.startsWith("4478") && this.optionPaye != null && this.optionPaye.getTrfCptePaye().equals("9")) {
            this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalMatricule() + ": " + this.bulletinSalaire.getPatronyme());
         } else {
            this.transfertCompta.setTrfSuite("");
         }
      } else if (this.planPaye.getPlpGroupe() == 1) {
         var1 = var1 + this.bulletinSalaire.getBulsalClassement();
         this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalLibClassement());
      } else if (this.planPaye.getPlpGroupe() == 2) {
         if (this.optionPaye.getNbcrExport() != null && !this.optionPaye.getNbcrExport().isEmpty() && this.optionPaye.getNbcrExport().equals("8")) {
            String var2 = "" + this.structureLog.getStrid();
            if (var2.equals("200000000003")) {
               int var3 = this.bulletinSalaire.getBulsalMatricule().length();
               if (var1.length() == 3) {
                  var1 = var1 + "000";
               } else if (var1.length() == 4) {
                  var1 = var1 + "00";
               } else if (var1.length() == 5) {
                  var1 = var1 + "0";
               }

               var1 = var1 + this.bulletinSalaire.getBulsalMatricule().substring(var3 - 2, var3);
            } else {
               var1 = var1 + this.bulletinSalaire.getBulsalMatricule().substring(2, 6);
            }
         } else {
            var1 = var1 + this.bulletinSalaire.getBulsalMatricule();
         }

         if (this.bulletinSalaire.getSalaries().getSalCompteSage() != null && !this.bulletinSalaire.getSalaries().getSalCompteSage().isEmpty()) {
            this.transfertCompta.setTrfSuite(this.bulletinSalaire.getSalaries().getSalCompteSage() + ": " + this.bulletinSalaire.getPatronyme());
         } else {
            this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalMatricule() + ": " + this.bulletinSalaire.getPatronyme());
         }
      } else {
         int var5;
         if (this.planPaye.getPlpGroupe() == 3) {
            var5 = var1.length();
            if (var1 != null && !var1.isEmpty() && (var1.length() == 4 || var1.length() == 5 || var1.length() == 6)) {
               if (var1.startsWith("664")) {
                  if (this.bulletinSalaire.getSalaries().getSalNationnalite() != null && !this.bulletinSalaire.getSalaries().getSalNationnalite().isEmpty()) {
                     if (this.verifLocalEtranger(this.bulletinSalaire.getSalaries().getSalNationnalite())) {
                        var1 = var1.substring(0, 3) + "1" + var1.substring(4, var5);
                        this.transfertCompta.setTrfSuite("LOCAL");
                     } else {
                        var1 = var1.substring(0, 3) + "2" + var1.substring(4, var5);
                        this.transfertCompta.setTrfSuite("ETRANGER");
                     }
                  } else {
                     var1 = var1.substring(0, 3) + "1" + var1.substring(4, var5);
                     this.transfertCompta.setTrfSuite(this.structureLog.getStrnompays());
                  }
               } else if (this.bulletinSalaire.getSalaries().getSalNationnalite() != null && !this.bulletinSalaire.getSalaries().getSalNationnalite().isEmpty()) {
                  if (this.verifLocalEtranger(this.bulletinSalaire.getSalaries().getSalNationnalite())) {
                     var1 = var1.substring(0, 2) + "1" + var1.substring(3, var5);
                     this.transfertCompta.setTrfSuite("LOCAL");
                  } else {
                     var1 = var1.substring(0, 2) + "2" + var1.substring(3, var5);
                     this.transfertCompta.setTrfSuite("ETRANGER");
                  }
               } else {
                  var1 = var1.substring(0, 2) + "1" + var1.substring(3, var5);
                  this.transfertCompta.setTrfSuite(this.structureLog.getStrnompays());
               }
            } else if (this.bulletinSalaire.getSalaries().getSalNationnalite() != null && !this.bulletinSalaire.getSalaries().getSalNationnalite().isEmpty()) {
               if (this.verifLocalEtranger(this.bulletinSalaire.getSalaries().getSalNationnalite())) {
                  var1 = var1 + "1";
                  this.transfertCompta.setTrfSuite("LOCAL");
               } else {
                  var1 = var1 + "2";
                  this.transfertCompta.setTrfSuite("ETRANGER");
               }
            } else {
               var1 = var1 + "1";
               this.transfertCompta.setTrfSuite(this.structureLog.getStrnompays());
            }
         } else if (this.planPaye.getPlpGroupe() == 4) {
            var5 = var1.length();
            if (var1 != null && !var1.isEmpty() && var1.length() == 4) {
               String var6 = var1.substring(0, 2);
               var1.substring(2, var5);
               if (this.bulletinSalaire.getSalaries().getSalNationnalite() != null && !this.bulletinSalaire.getSalaries().getSalNationnalite().isEmpty()) {
                  if (this.verifLocalEtranger(this.bulletinSalaire.getSalaries().getSalNationnalite())) {
                     var1 = var1.substring(0, 2) + "1" + var1.substring(3, var5) + this.bulletinSalaire.getBulsalClassement();
                  } else {
                     var1 = var1.substring(0, 2) + "2" + var1.substring(3, var5) + this.bulletinSalaire.getBulsalClassement();
                  }
               } else {
                  var1 = var1.substring(0, 2) + "1" + var1.substring(3, var5) + this.bulletinSalaire.getBulsalClassement();
               }

               this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalLibClassement());
            } else {
               if (this.bulletinSalaire.getSalaries().getSalNationnalite() != null && !this.bulletinSalaire.getSalaries().getSalNationnalite().isEmpty()) {
                  if (this.verifLocalEtranger(this.bulletinSalaire.getSalaries().getSalNationnalite())) {
                     var1 = var1 + "1" + this.bulletinSalaire.getBulsalClassement();
                  } else {
                     var1 = var1 + "2" + this.bulletinSalaire.getBulsalClassement();
                  }
               } else {
                  var1 = var1 + "1" + this.bulletinSalaire.getBulsalClassement();
               }

               this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalLibClassement());
            }
         } else if (this.planPaye.getPlpGroupe() == 7) {
            var1 = var1 + this.bulletinSalaire.getBulsalFeuille();
            this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalFeuille());
         } else if (this.planPaye.getPlpGroupe() == 8) {
            var1 = var1 + this.bulletinSalaire.getBulsalCentresImpots();
            this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalLibCentresImpots());
         } else if (this.planPaye.getPlpGroupe() == 9) {
            var1 = var1 + this.bulletinSalaire.getBulsalService();
            this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalService());
         }
      }

      return var1;
   }

   public String calculCompteCp(String var1) {
      if (this.planPaye.getPlpGroupeCp() == 0) {
         this.transfertCompta.setTrfSuite("");
      } else if (this.planPaye.getPlpGroupeCp() == 1) {
         var1 = var1 + this.bulletinSalaire.getBulsalClassement();
         this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalLibClassement());
      } else if (this.planPaye.getPlpGroupeCp() == 2) {
         if (this.optionPaye.getNbcrExport() != null && !this.optionPaye.getNbcrExport().isEmpty() && this.optionPaye.getNbcrExport().equals("8")) {
            var1 = var1 + this.bulletinSalaire.getBulsalMatricule().substring(2, 6);
         } else {
            var1 = var1 + this.bulletinSalaire.getBulsalMatricule();
         }

         if (this.bulletinSalaire.getSalaries().getSalCompteSage() != null && !this.bulletinSalaire.getSalaries().getSalCompteSage().isEmpty()) {
            this.transfertCompta.setTrfSuite(this.bulletinSalaire.getSalaries().getSalCompteSage() + ": " + this.bulletinSalaire.getPatronyme());
         } else {
            this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalMatricule() + ": " + this.bulletinSalaire.getPatronyme());
         }
      } else {
         int var2;
         if (this.planPaye.getPlpGroupeCp() == 3) {
            var2 = var1.length();
            if (var1 == null || var1.isEmpty() || var1.length() != 4 && var1.length() != 5 && var1.length() != 6) {
               if (this.bulletinSalaire.getSalaries().getSalNationnalite() != null && !this.bulletinSalaire.getSalaries().getSalNationnalite().isEmpty()) {
                  if (this.verifLocalEtranger(this.bulletinSalaire.getSalaries().getSalNationnalite())) {
                     var1 = var1 + "1";
                     this.transfertCompta.setTrfSuite("LOCAL");
                  } else {
                     var1 = var1 + "2";
                     this.transfertCompta.setTrfSuite("ETRANGER");
                  }
               } else {
                  var1 = var1 + "1";
                  this.transfertCompta.setTrfSuite(this.structureLog.getStrnompays());
               }
            } else if (var1.startsWith("664")) {
               if (this.bulletinSalaire.getSalaries().getSalNationnalite() != null && !this.bulletinSalaire.getSalaries().getSalNationnalite().isEmpty()) {
                  if (this.verifLocalEtranger(this.bulletinSalaire.getSalaries().getSalNationnalite())) {
                     var1 = var1.substring(0, 3) + "1" + var1.substring(4, var2);
                     this.transfertCompta.setTrfSuite("LOCAL");
                  } else {
                     if (var1.length() <= 5) {
                        var1 = this.ctrlLgCompte(var1);
                     }

                     var1 = var1.substring(0, 3) + "2" + var1.substring(4, var2);
                     this.transfertCompta.setTrfSuite("ETRANGER");
                  }
               } else {
                  if (var1.length() <= 5) {
                     var1 = this.ctrlLgCompte(var1);
                  }

                  var1 = var1.substring(0, 3) + "1" + var1.substring(4, var2);
                  this.transfertCompta.setTrfSuite(this.structureLog.getStrnompays());
               }
            } else if (this.bulletinSalaire.getSalaries().getSalNationnalite() != null && !this.bulletinSalaire.getSalaries().getSalNationnalite().isEmpty()) {
               if (this.verifLocalEtranger(this.bulletinSalaire.getSalaries().getSalNationnalite())) {
                  if (var1.length() <= 5) {
                     var1 = this.ctrlLgCompte(var1);
                  }

                  var1 = var1.substring(0, 2) + "1" + var1.substring(3, var2);
                  this.transfertCompta.setTrfSuite("LOCAL");
               } else {
                  if (var1.length() <= 5) {
                     var1 = this.ctrlLgCompte(var1);
                  }

                  var1 = var1.substring(0, 2) + "2" + var1.substring(3, var2);
                  this.transfertCompta.setTrfSuite("ETRANGER");
               }
            } else {
               if (var1.length() <= 5) {
                  var1 = this.ctrlLgCompte(var1);
               }

               var1 = var1.substring(0, 2) + "1" + var1.substring(3, var2);
               this.transfertCompta.setTrfSuite(this.structureLog.getStrnompays());
            }
         } else if (this.planPaye.getPlpGroupeCp() == 4) {
            var2 = var1.length();
            if (var1 != null && !var1.isEmpty() && var1.length() == 4) {
               if (this.bulletinSalaire.getSalaries().getSalNationnalite() != null && !this.bulletinSalaire.getSalaries().getSalNationnalite().isEmpty()) {
                  if (this.verifLocalEtranger(this.bulletinSalaire.getSalaries().getSalNationnalite())) {
                     if (var1.length() <= 5) {
                        var1 = this.ctrlLgCompte(var1);
                     }

                     var1 = var1.substring(0, 2) + "1" + var1.substring(3, var2) + this.bulletinSalaire.getBulsalClassement();
                  } else {
                     if (var1.length() <= 5) {
                        var1 = this.ctrlLgCompte(var1);
                     }

                     var1 = var1.substring(0, 2) + "2" + var1.substring(3, var2) + this.bulletinSalaire.getBulsalClassement();
                  }
               } else {
                  if (var1.length() <= 5) {
                     var1 = this.ctrlLgCompte(var1);
                  }

                  var1 = var1.substring(0, 2) + "1" + var1.substring(3, var2) + this.bulletinSalaire.getBulsalClassement();
               }

               this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalLibClassement());
            } else {
               if (this.bulletinSalaire.getSalaries().getSalNationnalite() != null && !this.bulletinSalaire.getSalaries().getSalNationnalite().isEmpty()) {
                  if (this.verifLocalEtranger(this.bulletinSalaire.getSalaries().getSalNationnalite())) {
                     var1 = var1 + "1" + this.bulletinSalaire.getBulsalClassement();
                  } else {
                     var1 = var1 + "2" + this.bulletinSalaire.getBulsalClassement();
                  }
               } else {
                  var1 = var1 + "1" + this.bulletinSalaire.getBulsalClassement();
               }

               this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalLibClassement());
            }
         } else if (this.planPaye.getPlpGroupeCp() == 7) {
            var1 = var1 + this.bulletinSalaire.getBulsalFeuille();
            this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalFeuille());
         } else if (this.planPaye.getPlpGroupeCp() == 8) {
            var1 = var1 + this.bulletinSalaire.getBulsalCentresImpots();
            this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalLibCentresImpots());
         } else if (this.planPaye.getPlpGroupeCp() == 9) {
            var1 = var1 + this.bulletinSalaire.getBulsalService();
            this.transfertCompta.setTrfSuite(this.bulletinSalaire.getBulsalService());
         }
      }

      return var1;
   }

   public boolean verifLocalEtranger(String var1) {
      boolean var2 = false;
      if (this.listPays.size() != 0) {
         for(int var3 = 0; var3 < this.listPays.size(); ++var3) {
            if (var1 != null && !var1.isEmpty() && ((ObjetPays)this.listPays.get(var3)).getNationnalite_FR() != null && !((ObjetPays)this.listPays.get(var3)).getNationnalite_FR().isEmpty() && var1.equalsIgnoreCase(((ObjetPays)this.listPays.get(var3)).getNationnalite_FR())) {
               if (((ObjetPays)this.listPays.get(var3)).getIdentification().equals(this.structureLog.getStrcodepays())) {
                  var2 = true;
               } else {
                  var2 = false;
               }
               break;
            }
         }
      }

      return var2;
   }

   public String ctrlLgCompte(String var1) {
      String var2 = "";
      if (var1.length() == 1) {
         var2 = var1 + "0000";
      } else if (var1.length() == 2) {
         var2 = var1 + "000";
      } else if (var1.length() == 3) {
         var2 = var1 + "00";
      } else if (var1.length() == 4) {
         var2 = var1 + "0";
      } else {
         var2 = var1;
      }

      return var2;
   }

   public void analytiqueBulletin() {
      if (!this.optionPaye.getAxeStructure().equals("true") && !this.optionPaye.getAxeSite().equals("true") && !this.optionPaye.getAxeUsine().equals("true") && !this.optionPaye.getAxeAgent().equals("true") && !this.optionPaye.getAxeParc().equals("true") && !this.optionPaye.getAxeProjet().equals("true") && !this.optionPaye.getAxeActivite().equals("true") && !this.optionPaye.getAxeDossier().equals("1")) {
         this.transfertCompta.setTrfRepartitionCle1("");
         this.transfertCompta.setTrfRepartitionCle2("");
         this.transfertCompta.setTrfActivite("");
         this.transfertCompta.setTrfAnal1("");
         this.transfertCompta.setTrfAnal3("");
         this.transfertCompta.setTrfSite("");
         this.transfertCompta.setTrfDepartement("");
         this.transfertCompta.setTrfService("");
         this.transfertCompta.setTrfRegion("");
         this.transfertCompta.setTrfSecteur("");
         this.transfertCompta.setTrfPdv("");
         this.transfertCompta.setTrfDossier("");
         this.transfertCompta.setTrfParc("");
         this.transfertCompta.setTrfBudget("");
         this.transfertCompta.setTrfProjet("");
         this.transfertCompta.setTrfTreso("");
      } else {
         this.transfertCompta.setTrfRepartitionCle1("");
         this.transfertCompta.setTrfRepartitionCle2("");
         String[] var1;
         if (this.bulletinSalaire.getBulsalCle1Anal() != null && !this.bulletinSalaire.getBulsalCle1Anal().isEmpty() && this.bulletinSalaire.getBulsalCle1Anal().contains(":") || this.bulletinSalaire.getBulsalCle2Anal() != null && !this.bulletinSalaire.getBulsalCle2Anal().isEmpty() && this.bulletinSalaire.getBulsalCle2Anal().contains(":")) {
            if (this.bulletinSalaire.getBulsalCle1Anal().contains(":")) {
               var1 = this.bulletinSalaire.getBulsalCle1Anal().split(":");
               this.transfertCompta.setTrfRepartitionCle1(var1[0]);
            }

            if (this.bulletinSalaire.getBulsalCle2Anal() != null && !this.bulletinSalaire.getBulsalCle2Anal().isEmpty() && this.bulletinSalaire.getBulsalCle2Anal().contains(":")) {
               var1 = this.bulletinSalaire.getBulsalCle2Anal().split(":");
               this.transfertCompta.setTrfRepartitionCle2(var1[0]);
            }
         }

         if ((this.transfertCompta.getTrfRepartitionCle1() == null || this.transfertCompta.getTrfRepartitionCle1().isEmpty()) && (this.transfertCompta.getTrfRepartitionCle2() == null || this.transfertCompta.getTrfRepartitionCle2().isEmpty())) {
            if (this.planPaye != null && this.planPaye.getPlpActivite() != null && !this.planPaye.getPlpActivite().isEmpty()) {
               this.transfertCompta.setTrfActivite(this.planPaye.getPlpActivite());
            } else if (this.bulletinSalaire.getBulsalActivite() != null && !this.bulletinSalaire.getBulsalActivite().isEmpty()) {
               if (this.bulletinSalaire.getBulsalActivite().contains(":") && this.bulletinSalaire.getBulsalActivite().length() >= 3) {
                  if (this.decoupageActivite) {
                     this.transfertCompta.setTrfActivite(this.bulletinSalaire.getBulsalActivite());
                  } else {
                     var1 = this.bulletinSalaire.getBulsalActivite().split(":");
                     this.transfertCompta.setTrfActivite(var1[0]);
                  }
               } else {
                  this.transfertCompta.setTrfActivite(this.bulletinSalaire.getBulsalActivite());
               }
            }

            if (this.bulletinSalaire.getBulsalSite() != null && !this.bulletinSalaire.getBulsalSite().isEmpty() && this.bulletinSalaire.getBulsalSite().contains(":") && this.bulletinSalaire.getBulsalSite().length() >= 3) {
               var1 = this.bulletinSalaire.getBulsalSite().split(":");
               this.transfertCompta.setTrfSite(var1[0]);
            } else {
               this.transfertCompta.setTrfSite(this.bulletinSalaire.getBulsalSite());
            }

            if (this.bulletinSalaire.getBulsalDepartement() != null && !this.bulletinSalaire.getBulsalDepartement().isEmpty() && this.bulletinSalaire.getBulsalDepartement().contains(":") && this.bulletinSalaire.getBulsalDepartement().length() >= 3) {
               var1 = this.bulletinSalaire.getBulsalDepartement().split(":");
               this.transfertCompta.setTrfDepartement(var1[0]);
            } else {
               this.transfertCompta.setTrfDepartement(this.bulletinSalaire.getBulsalDepartement());
            }

            if (this.bulletinSalaire.getBulsalService() != null && !this.bulletinSalaire.getBulsalService().isEmpty() && this.bulletinSalaire.getBulsalService().contains(":") && this.bulletinSalaire.getBulsalService().length() >= 3) {
               var1 = this.bulletinSalaire.getBulsalService().split(":");
               this.transfertCompta.setTrfService(var1[0]);
            } else {
               this.transfertCompta.setTrfService(this.bulletinSalaire.getBulsalService());
            }

            this.transfertCompta.setTrfRegion("");
            this.transfertCompta.setTrfSecteur("");
            this.transfertCompta.setTrfPdv("");
            this.transfertCompta.setTrfDossier("");
            if (this.bulletinSalaire.getBulsalParc() != null && !this.bulletinSalaire.getBulsalParc().isEmpty() && this.bulletinSalaire.getBulsalParc().contains(":") && this.bulletinSalaire.getBulsalParc().length() >= 3) {
               var1 = this.bulletinSalaire.getBulsalParc().split(":");
               this.transfertCompta.setTrfParc(var1[0]);
            } else {
               this.transfertCompta.setTrfParc(this.bulletinSalaire.getBulsalParc());
            }

            if (this.bulletinSalaire.getBulsalBudget() != null && !this.bulletinSalaire.getBulsalBudget().isEmpty() && this.bulletinSalaire.getBulsalBudget().contains(":") && this.bulletinSalaire.getBulsalBudget().length() >= 3) {
               var1 = this.bulletinSalaire.getBulsalBudget().split(":");
               this.transfertCompta.setTrfBudget(var1[0]);
            } else {
               this.transfertCompta.setTrfBudget(this.bulletinSalaire.getBulsalBudget());
            }

            this.transfertCompta.setTrfProjet("");
            this.transfertCompta.setTrfTreso("");
         } else {
            this.transfertCompta.setTrfActivite("");
            this.transfertCompta.setTrfAnal1("");
            this.transfertCompta.setTrfAnal3("");
            this.transfertCompta.setTrfSite("");
            this.transfertCompta.setTrfDepartement("");
            this.transfertCompta.setTrfService("");
            this.transfertCompta.setTrfRegion("");
            this.transfertCompta.setTrfSecteur("");
            this.transfertCompta.setTrfPdv("");
            this.transfertCompta.setTrfDossier("");
            this.transfertCompta.setTrfParc("");
            this.transfertCompta.setTrfBudget("");
         }
      }

   }

   public void transfertImport(List var1) throws HibernateException, NamingException, ParseException {
      this.init();
      int var2 = 0;
      this.importSage = false;
      this.variableExcel = false;
      this.ecritureGeneSage = false;
      this.immobilisationSage = false;
      this.planGeneralSage = false;
      this.planTiersSage = false;
      this.journauxSage = false;
      this.analytiqueSage = false;
      this.compteurFournisseur = 0;
      this.compteurclient = 0;
      this.compteurPersonnel = 0;
      this.compteurAssocie = 0;
      this.compteurAttente = 0;
      this.compteurInvestissement = 0;
      this.balance = 0;
      this.objetPays = new ObjetPays();
      this.lecturePays = new LecturePays();
      this.listPays = this.lecturePays.getMespays();
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.lesTransfertCompta.clear();
      this.lesTransfertErreur.clear();
      this.lePlanComptable = new ArrayList();
      this.lePlanComptable = this.planComptableDao.chargerTousLesPlcComptables((String)null, this.exercicesComptable.getExecpt_id(), (Session)null);
      this.lesTiers = new ArrayList();
      this.lesTiers = this.tiersDao.chargerLesTiers("100", (Session)null);
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            String var4 = (String)var1.get(var3);
            if (var4.toString().contains(".xls:") || var4.toString().contains(".xlsx:") || var4.toString().contains(".XLS:") || var4.toString().contains(".XLSX:")) {
               this.variableExcel = true;
               String[] var10 = var4.split(":");
               this.balance = this.importComptaExcel(var10[1]);
               break;
            }

            if (var4 != null && !var4.isEmpty() && var4.contains("#FLG")) {
               this.importSage = true;
            }

            if (this.importSage && var4 != null && !var4.isEmpty() && var4.equals("#MECG")) {
               this.ecritureGeneSage = true;
            } else if (this.importSage && var4 != null && !var4.isEmpty() && var4.equals("#IIMO")) {
               this.immobilisationSage = true;
            } else if (this.importSage && var4 != null && !var4.isEmpty() && var4.equals("#MPLG")) {
               this.planGeneralSage = true;
            } else if (this.importSage && var4 != null && !var4.isEmpty() && var4.equals("#MPCT")) {
               this.planTiersSage = true;
            } else if (this.importSage && var4 != null && !var4.isEmpty() && var4.equals("#MCJR")) {
               this.journauxSage = true;
            }

            boolean var5 = false;
            String[] var6 = null;
            int var9;
            if (this.importSage) {
               var9 = 1;
            } else if (var4 != null && !var4.isEmpty() && var4.contains(",")) {
               var6 = var4.split(",");
               var9 = var6.length;
            } else {
               var9 = 1;
            }

            if (var9 == 22) {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("1");
               this.transfertCompta.setTrfIdOrigine(0L);
               this.transfertCompta.setTrfAgent(this.usersLog.getUsrPatronyme());
               if (var6[21] != null && !var6[21].isEmpty()) {
                  if (var6[21].equals("SPC-ELEVE")) {
                     this.importEleve(var6);
                  } else if (var6[21].equals("SPC-VACAT")) {
                     this.importVacataire(var6);
                  } else {
                     this.importStandard(var6);
                  }
               } else {
                  this.importStandard(var6);
               }
            } else if (var9 != 13 && var9 != 14 && var9 != 15 && var9 != 18) {
               if (var9 == 12) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("1");
                  this.transfertCompta.setTrfIdOrigine(0L);
                  this.transfertCompta.setTrfAgent(this.usersLog.getUsrPatronyme());
                  this.importStandardLight1(var6);
               } else if (var9 == 10) {
                  if (var4 != null && !var4.isEmpty() && var4.contains("/")) {
                     this.transfertCompta = new TransfertCompta();
                     this.transfertCompta.setTrfTypeOrigine("1");
                     this.transfertCompta.setTrfIdOrigine(0L);
                     this.transfertCompta.setTrfAgent(this.usersLog.getUsrPatronyme());
                     this.importStandardLight2(var6);
                  }
               } else if (var9 == 8) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("1");
                  this.transfertCompta.setTrfIdOrigine(0L);
                  this.transfertCompta.setTrfAgent(this.usersLog.getUsrPatronyme());
                  this.balance = 1;
                  this.importBalance(var6);
               } else if (var9 == 3) {
                  this.transfertCompta = new TransfertCompta();
                  this.transfertCompta.setTrfTypeOrigine("1");
                  this.transfertCompta.setTrfIdOrigine(0L);
                  this.transfertCompta.setTrfAgent(this.usersLog.getUsrPatronyme());
                  this.balance = 2;
                  this.importPlanComptable(var6);
               } else if (var9 == 1 && (this.ecritureGeneSage || this.immobilisationSage || this.planGeneralSage || this.planTiersSage || this.journauxSage)) {
                  if (var4 == null || var4.isEmpty() || !var4.equals("#MECG") && !var4.equals("#IIMO") && !var4.equals("#MPLG") && !var4.equals("#MPCT") && !var4.equals("#MCJR") && !var4.equals("#FIN")) {
                     if (var4 != null && !var4.isEmpty() && var4.equals("#MACA")) {
                        this.analytiqueSage = true;
                     }

                     if (!this.analytiqueSage) {
                        ++var2;
                        if (this.ecritureGeneSage) {
                           this.importEcritureSage(var2, var4);
                        } else if (this.immobilisationSage) {
                           this.balance = 3;
                           this.importImmobilisationSage(var2, var4);
                        } else if (this.planGeneralSage) {
                           this.balance = 4;
                           this.importPlanGeneralSage(var2, var4);
                        } else if (this.planTiersSage) {
                           this.balance = 4;
                           this.importPlanTiersSage(var2, var4);
                        } else if (this.journauxSage) {
                           this.balance = 5;
                           this.importJournauxSage(var2, var4);
                        }
                     }
                  } else {
                     if (var2 != 0) {
                        if (this.transfertCompta.getTrfCompte() != null && !this.transfertCompta.getTrfCompte().isEmpty()) {
                           if (!this.transfertCompta.getTrfCompte().startsWith("1") && !this.transfertCompta.getTrfCompte().startsWith("2") && !this.transfertCompta.getTrfCompte().startsWith("3") && !this.transfertCompta.getTrfCompte().startsWith("4") && !this.transfertCompta.getTrfCompte().startsWith("5") && !this.transfertCompta.getTrfCompte().startsWith("6") && !this.transfertCompta.getTrfCompte().startsWith("7") && !this.transfertCompta.getTrfCompte().startsWith("8") && !this.transfertCompta.getTrfCompte().startsWith("9")) {
                              this.transfertCompta.setTrfErreur("Compte non conforme");
                              this.lesTransfertErreur.add(this.transfertCompta);
                           } else {
                              this.lesTransfertCompta.add(this.transfertCompta);
                              if (var4.equals("#MPCT") && this.transfertCompta.getTrfCompte().startsWith("40")) {
                                 ++this.compteurFournisseur;
                              } else if (var4.equals("#MPCT") && this.transfertCompta.getTrfCompte().startsWith("41")) {
                                 ++this.compteurclient;
                              } else if (var4.equals("#MPCT") && this.transfertCompta.getTrfCompte().startsWith("42")) {
                                 ++this.compteurPersonnel;
                              } else if (var4.equals("#MPCT") && this.transfertCompta.getTrfCompte().startsWith("46")) {
                                 ++this.compteurAssocie;
                              } else if (var4.equals("#MPCT") && this.transfertCompta.getTrfCompte().startsWith("47")) {
                                 ++this.compteurAttente;
                              } else if (var4.equals("#MPCT") && this.transfertCompta.getTrfCompte().startsWith("48")) {
                                 ++this.compteurInvestissement;
                              }
                           }
                        } else if (this.transfertCompta.getTrfCode() != null && !this.transfertCompta.getTrfCode().isEmpty() && (this.immobilisationSage || this.journauxSage)) {
                           this.lesTransfertCompta.add(this.transfertCompta);
                        }
                     }

                     var2 = 0;
                     this.transfertCompta = new TransfertCompta();
                     this.transfertCompta.setTrfTypeOrigine("1");
                     this.transfertCompta.setTrfIdOrigine(0L);
                     this.transfertCompta.setTrfAgent(this.usersLog.getUsrPatronyme());
                     this.analytiqueSage = false;
                  }
               }
            } else {
               this.transfertCompta = new TransfertCompta();
               this.transfertCompta.setTrfTypeOrigine("1");
               this.transfertCompta.setTrfIdOrigine(0L);
               this.transfertCompta.setTrfAgent(this.usersLog.getUsrPatronyme());
               this.importSageExpert(var6);
            }
         }

         if (this.lesTransfertCompta.size() != 0) {
            this.transfertCompta = (TransfertCompta)this.lesTransfertCompta.get(0);
            if (this.transfertCompta.getTrfTypeImport() != null && !this.transfertCompta.getTrfTypeImport().isEmpty()) {
               if (this.transfertCompta.getTrfTypeImport().equals("SPC-VACAT")) {
                  this.mefVacataire();
               } else if (this.transfertCompta.getTrfTypeImport().equals("SPC-ELEVE")) {
                  this.mefEleve();
               }
            }
         } else if (this.lesTransfertVentes.size() != 0) {
         }

         if (this.balance != 80 && this.balance != 81) {
            ArrayList var7 = new ArrayList();
            if (this.lesTransfertErreur.size() != 0) {
               for(int var8 = 0; var8 < this.lesTransfertErreur.size(); ++var8) {
                  var7.add(this.lesTransfertErreur.get(var8));
               }
            }

            this.optimisationResultat(this.optionComptabilite.getTrf_cpte());
            this.dataModelTransfertErreur.setWrappedData(var7);
            if (var7.size() != 0) {
               this.var_verif_transfert = false;
            } else {
               this.var_verif_transfert = true;
            }
         } else {
            this.dataModelTransfertCompta.setWrappedData(this.lesTransfertVentes);
            this.var_verif_transfert = true;
         }
      }

   }

   public int importComptaExcel(String var1) throws HibernateException, NamingException {
      UtilExcel var2 = new UtilExcel();
      File var3 = new File(var1);
      int var4 = var2.lectureComptaExcel(var3);
      if (var4 == 0) {
         this.importEcritureExcel(var1);
         this.balance = 0;
      } else if (var4 == 1) {
         this.importBalanceExcel(var1);
         this.balance = 1;
      } else if (var4 == 80) {
         this.balance = 80;
         this.importLibre(var1);
      } else if (var4 == 81) {
         this.balance = 81;
         this.importLibre(var1);
      } else {
         this.balance = 99;
      }

      return this.balance;
   }

   public void importBalanceExcel(String var1) throws HibernateException, NamingException {
      UtilExcel var2 = new UtilExcel();
      File var3 = new File(var1);
      new ArrayList();
      List var4 = var2.lectureFichierBalance(var3);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            this.transfertCompta = (TransfertCompta)var4.get(var5);
            this.transfertCompta.setTrfTypeImport("BALANCE");
            if (this.transfertCompta.getTrfCode().equals("AN")) {
               this.transfertCompta.setTrfDateSaisie(this.exercicesComptable.getExecptDateDebut());
            } else {
               this.transfertCompta.setTrfDateSaisie(this.exercicesComptable.getExecptDateFin());
            }

            this.lesTransfertCompta.add(var4.get(var5));
         }
      }

   }

   public void importEcritureExcel(String var1) throws HibernateException, NamingException {
      UtilExcel var2 = new UtilExcel();
      File var3 = new File(var1);
      new ArrayList();
      List var4 = var2.lectureFichierEcriture(var3);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            this.transfertCompta = (TransfertCompta)var4.get(var5);
            this.transfertCompta.setTrfTypeImport((String)null);
            this.lesTransfertCompta.add(var4.get(var5));
         }
      }

   }

   public void importStandard(String[] var1) throws ParseException {
      if (var1[0] != null && !var1[0].isEmpty()) {
         this.transfertCompta.setTrfCode(var1[0]);
      } else {
         this.transfertCompta.setTrfCode((String)null);
      }

      Date var2 = null;
      String var3;
      if (var1[1] != null && !var1[1].isEmpty()) {
         var3 = var1[1];
         if (var3.length() == 5 || var3.length() == 7) {
            var3 = "0" + var3;
         }

         if (var3.length() == 6) {
            var3 = "20" + var3.substring(4, 6) + "-" + var3.substring(2, 4) + "-" + var3.substring(0, 2);
         } else if (var3.length() == 8) {
            var3 = var3.substring(5, 8) + "-" + var3.substring(3, 5) + "-" + var3.substring(1, 2);
         }

         var2 = this.utilDate.stringToDateSQLLight(var3);
      } else {
         var2 = this.utilDate.stringToDateSQLLight((String)null);
      }

      this.transfertCompta.setTrfDateSaisie(var2);
      this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(this.transfertCompta.getTrfCode(), this.transfertCompta.getTrfDateSaisie()));
      this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.transfertCompta.getTrfDateSaisie()));
      if (var1[2] != null && !var1[2].isEmpty()) {
         this.transfertCompta.setTrfCompte(var1[2]);
      } else {
         this.transfertCompta.setTrfCompte((String)null);
      }

      if (var1[3] != null && !var1[3].isEmpty()) {
         if (var1[3].length() >= 20) {
            this.transfertCompta.setTrfPiece(var1[3].substring(0, 20));
         } else {
            this.transfertCompta.setTrfPiece(var1[3]);
         }
      } else {
         this.transfertCompta.setTrfPiece((String)null);
      }

      if (var1[4] != null && !var1[4].isEmpty()) {
         this.transfertCompta.setTrfReference1(var1[4]);
      } else {
         this.transfertCompta.setTrfReference1((String)null);
      }

      if (var1[5] != null && !var1[5].isEmpty()) {
         this.transfertCompta.setTrfReference2(var1[5]);
      } else {
         this.transfertCompta.setTrfReference2((String)null);
      }

      if (var1[6] != null && !var1[6].isEmpty()) {
         this.transfertCompta.setTrfDebitSaisie(Double.parseDouble(var1[6]));
      } else {
         this.transfertCompta.setTrfDebitSaisie(0.0D);
      }

      if (var1[7] != null && !var1[7].isEmpty()) {
         this.transfertCompta.setTrfCreditSaisie(Double.parseDouble(var1[7]));
      } else {
         this.transfertCompta.setTrfCreditSaisie(0.0D);
      }

      if (var1[8] != null && !var1[8].isEmpty()) {
         this.transfertCompta.setTrfLettre(var1[8]);
      } else {
         this.transfertCompta.setTrfLettre((String)null);
      }

      if (var1[9] != null && !var1[9].isEmpty()) {
         this.transfertCompta.setTrfLibelle(var1[9]);
      } else {
         this.transfertCompta.setTrfLibelle((String)null);
      }

      if (var1[10] != null && !var1[10].isEmpty()) {
         if (var1[10].equalsIgnoreCase("null")) {
            this.transfertCompta.setTrfDateEcheance((Date)null);
         } else {
            Date var6 = this.utilDate.stringToDateSQLLight(var1[10]);
            this.transfertCompta.setTrfDateEcheance(var6);
         }
      } else {
         this.transfertCompta.setTrfDateEcheance((Date)null);
      }

      if (var1[11] != null && !var1[11].isEmpty()) {
         if (this.structureLog.getStrid() == 45L) {
            var3 = "";
            String var4 = "";
            String var5 = "";
            if (var1[11].length() == 3) {
               var3 = var1[11];
               var4 = "null";
               var5 = "null";
            } else {
               var3 = var1[11].substring(0, 3);
               var4 = var1[11].substring(3, 4);
               var5 = var1[11].substring(4, 6);
            }

            this.transfertCompta.setTrfActivite(var3 + ":" + var4 + ":" + var5);
         } else {
            this.transfertCompta.setTrfActivite(var1[11]);
         }
      } else {
         this.transfertCompta.setTrfActivite((String)null);
      }

      if (var1[12] != null && !var1[12].isEmpty()) {
         this.transfertCompta.setTrfDossier(var1[12]);
      } else {
         this.transfertCompta.setTrfDossier((String)null);
      }

      if (var1[13] != null && !var1[13].isEmpty()) {
         this.transfertCompta.setTrfParc(var1[13]);
      } else {
         this.transfertCompta.setTrfParc((String)null);
      }

      if (var1[14] != null && !var1[14].isEmpty()) {
         this.transfertCompta.setTrfSite(var1[14]);
      } else {
         this.transfertCompta.setTrfSite((String)null);
      }

      if (var1[15] != null && !var1[15].isEmpty()) {
         this.transfertCompta.setTrfDepartement(var1[15]);
      } else {
         this.transfertCompta.setTrfDepartement((String)null);
      }

      if (var1[16] != null && !var1[16].isEmpty()) {
         this.transfertCompta.setTrfService(var1[16]);
      } else {
         this.transfertCompta.setTrfService((String)null);
      }

      if (var1[17] != null && !var1[17].isEmpty()) {
         this.transfertCompta.setTrfRegion(var1[17]);
      } else {
         this.transfertCompta.setTrfRegion((String)null);
      }

      if (var1[18] != null && !var1[18].isEmpty()) {
         this.transfertCompta.setTrfSecteur(var1[18]);
      } else {
         this.transfertCompta.setTrfSecteur((String)null);
      }

      if (var1[19] != null && !var1[19].isEmpty()) {
         this.transfertCompta.setTrfPdv(var1[19]);
      } else {
         this.transfertCompta.setTrfPdv((String)null);
      }

      if (var1[20] != null && !var1[20].isEmpty()) {
         this.transfertCompta.setTrfBudget(var1[20]);
      } else {
         this.transfertCompta.setTrfBudget((String)null);
      }

      this.transfertCompta.setTrfTypeImport((String)null);
      if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
         this.lesTransfertCompta.add(this.transfertCompta);
      }

   }

   public void importStandardLight1(String[] var1) throws ParseException {
      if (var1[0] != null && !var1[0].isEmpty()) {
         this.transfertCompta.setTrfCode(var1[0]);
      } else {
         this.transfertCompta.setTrfCode((String)null);
      }

      Date var2 = null;
      String var3;
      if (var1[1] != null && !var1[1].isEmpty()) {
         var3 = var1[1].replace("/", "-");
         if (var3.length() == 5 || var3.length() == 7) {
            var3 = "0" + var3;
         }

         if (var3.length() == 6) {
            var3 = "20" + var3.substring(4, 6) + "-" + var3.substring(2, 4) + "-" + var3.substring(0, 2);
         } else if (var3.length() == 8) {
            var3 = var3.substring(5, 8) + "-" + var3.substring(3, 5) + "-" + var3.substring(1, 2);
         }

         var2 = this.utilDate.stringToDateSQLLight(var3);
      } else {
         var2 = this.utilDate.stringToDateSQLLight((String)null);
      }

      this.transfertCompta.setTrfDateSaisie(var2);
      this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(this.transfertCompta.getTrfCode(), this.transfertCompta.getTrfDateSaisie()));
      this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.transfertCompta.getTrfDateSaisie()));
      if (var1[2] != null && !var1[2].isEmpty()) {
         this.transfertCompta.setTrfCompte(var1[2]);
      } else {
         this.transfertCompta.setTrfCompte((String)null);
      }

      if (var1[3] != null && !var1[3].isEmpty()) {
         this.transfertCompta.setTrfCp(var1[3]);
      } else {
         this.transfertCompta.setTrfCp((String)null);
      }

      if (var1[4] != null && !var1[4].isEmpty()) {
         if (var1[4].length() >= 20) {
            this.transfertCompta.setTrfPiece(var1[4].substring(0, 20));
         } else {
            this.transfertCompta.setTrfPiece(var1[4]);
         }
      } else {
         this.transfertCompta.setTrfPiece((String)null);
      }

      if (var1[5] != null && !var1[5].isEmpty()) {
         this.transfertCompta.setTrfReference1(var1[5]);
      } else {
         this.transfertCompta.setTrfReference1((String)null);
      }

      if (var1[6] != null && !var1[6].isEmpty()) {
         this.transfertCompta.setTrfReference2(var1[6]);
      } else {
         this.transfertCompta.setTrfReference2((String)null);
      }

      if (var1[7] != null && !var1[7].isEmpty()) {
         this.transfertCompta.setTrfDebitSaisie(Double.parseDouble(var1[7]));
      } else {
         this.transfertCompta.setTrfDebitSaisie(0.0D);
      }

      if (var1[8] != null && !var1[8].isEmpty()) {
         this.transfertCompta.setTrfCreditSaisie(Double.parseDouble(var1[8]));
      } else {
         this.transfertCompta.setTrfCreditSaisie(0.0D);
      }

      if (var1[9] != null && !var1[9].isEmpty()) {
         this.transfertCompta.setTrfLettre(var1[9]);
      } else {
         this.transfertCompta.setTrfLettre((String)null);
      }

      if (var1[10] != null && !var1[10].isEmpty()) {
         if (var1[10].equalsIgnoreCase("null")) {
            this.transfertCompta.setTrfDateEcheance((Date)null);
         } else {
            var3 = var1[10].replace("/", "-");
            if (var3.length() == 5 || var3.length() == 7) {
               var3 = "0" + var3;
            }

            if (var3.length() == 6) {
               var3 = "20" + var3.substring(4, 6) + "-" + var3.substring(2, 4) + "-" + var3.substring(0, 2);
            } else if (var3.length() == 8) {
               var3 = var3.substring(5, 8) + "-" + var3.substring(3, 5) + "-" + var3.substring(1, 2);
            }

            Date var4 = this.utilDate.stringToDateSQLLight(var3);
            this.transfertCompta.setTrfDateEcheance(var4);
         }
      } else {
         this.transfertCompta.setTrfDateEcheance((Date)null);
      }

      if (var1[11] != null && !var1[11].isEmpty()) {
         this.transfertCompta.setTrfLibelle(var1[11]);
      } else {
         this.transfertCompta.setTrfLibelle((String)null);
      }

      this.transfertCompta.setTrfTypeImport((String)null);
      if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
         int var5;
         boolean var6;
         if (this.transfertCompta.getTrfCp() != null && !this.transfertCompta.getTrfCp().isEmpty()) {
            var6 = false;
            if (this.lePlanComptable.size() != 0) {
               for(var5 = 0; var5 < this.lePlanComptable.size(); ++var5) {
                  if (((PlanComptable)this.lePlanComptable.get(var5)).getPlcSage() != null && !((PlanComptable)this.lePlanComptable.get(var5)).getPlcSage().isEmpty() && ((PlanComptable)this.lePlanComptable.get(var5)).getPlcSage().startsWith(this.transfertCompta.getTrfCp())) {
                     this.transfertCompta.setTrfCompte(((PlanComptable)this.lePlanComptable.get(var5)).getPlcCompte());
                     var6 = true;
                     break;
                  }
               }
            }

            if (!var6) {
               this.transfertCompta.setTrfCompte(this.transfertCompta.getTrfCp());
            }

            this.transfertCompta.setTrfCp("");
         } else if (this.transfertCompta.getTrfCompte() != null && !this.transfertCompta.getTrfCompte().isEmpty()) {
            var6 = false;
            if (this.lePlanComptable.size() != 0) {
               for(var5 = 0; var5 < this.lePlanComptable.size(); ++var5) {
                  if (((PlanComptable)this.lePlanComptable.get(var5)).getPlcSage() != null && !((PlanComptable)this.lePlanComptable.get(var5)).getPlcSage().isEmpty() && ((PlanComptable)this.lePlanComptable.get(var5)).getPlcSage().equalsIgnoreCase(this.transfertCompta.getTrfCompte())) {
                     this.transfertCompta.setTrfCompte(((PlanComptable)this.lePlanComptable.get(var5)).getPlcCompte());
                     var6 = true;
                     break;
                  }

                  if ((((PlanComptable)this.lePlanComptable.get(var5)).getPlcSage() == null || ((PlanComptable)this.lePlanComptable.get(var5)).getPlcSage().isEmpty()) && ((PlanComptable)this.lePlanComptable.get(var5)).getPlcCompte().startsWith(this.transfertCompta.getTrfCompte())) {
                     this.transfertCompta.setTrfCompte(((PlanComptable)this.lePlanComptable.get(var5)).getPlcCompte());
                     var6 = true;
                     break;
                  }
               }
            }

            if (!var6) {
               if (this.lesTiers.size() != 0) {
                  for(var5 = 0; var5 < this.lesTiers.size(); ++var5) {
                     if (((Tiers)this.lesTiers.get(var5)).getTiecompteSage() != null && !((Tiers)this.lesTiers.get(var5)).getTiecompteSage().isEmpty() && ((Tiers)this.lesTiers.get(var5)).getTiecompteSage().equalsIgnoreCase(this.transfertCompta.getTrfCompte())) {
                        this.transfertCompta.setTrfCompte(((Tiers)this.lesTiers.get(var5)).getTiecompte0());
                        var6 = true;
                        break;
                     }
                  }
               }

               if (!var6) {
               }
            }
         }

         var6 = false;
         if (var1[2] != null && !var1[2].isEmpty() && var1[2].startsWith("521") && var1[3] != null && !var1[3].isEmpty() && var1[3].startsWith("401") && this.transfertCompta.getTrfDebitSaisie() != 0.0D && this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
            var6 = true;
            this.transfertCompta.setTrfCreditSaisie(0.0D);
         }

         this.lesTransfertCompta.add(this.transfertCompta);
         if (var1[2] != null && !var1[2].isEmpty() && var1[2].startsWith("521") && var1[3] != null && !var1[3].isEmpty() && var1[3].startsWith("401") && var6) {
            this.importStandardLightSuite(var1);
         }
      }

   }

   public void importStandardLight2(String[] var1) throws ParseException {
      if (var1[0] != null && !var1[0].isEmpty()) {
         this.transfertCompta.setTrfCompte(var1[0]);
      } else {
         this.transfertCompta.setTrfCompte((String)null);
      }

      Date var2 = null;
      if (var1[1] != null && !var1[1].isEmpty()) {
         String[] var3 = var1[1].split("/");
         var2 = this.utilDate.stringToDateSQLLight(var3[2] + "-" + var3[1] + "-" + var3[0]);
      } else {
         var2 = this.utilDate.stringToDateSQLLight((String)null);
      }

      this.transfertCompta.setTrfDateSaisie(var2);
      if (var1[2] != null && !var1[2].isEmpty()) {
         this.transfertCompta.setTrfCode(var1[2]);
      } else {
         this.transfertCompta.setTrfCode((String)null);
      }

      if (var1[3] != null && !var1[3].isEmpty()) {
         this.transfertCompta.setTrfDebitSaisie(Double.parseDouble(var1[3]));
      } else {
         this.transfertCompta.setTrfDebitSaisie(0.0D);
      }

      if (var1[4] != null && !var1[4].isEmpty()) {
         this.transfertCompta.setTrfCreditSaisie(Double.parseDouble(var1[4]));
      } else {
         this.transfertCompta.setTrfCreditSaisie(0.0D);
      }

      if (var1[5] != null && !var1[5].isEmpty()) {
         this.transfertCompta.setTrfLibelle(var1[5]);
      } else {
         this.transfertCompta.setTrfLibelle((String)null);
      }

      if (var1[6] != null && !var1[6].isEmpty()) {
         if (var1[6].length() >= 20) {
            this.transfertCompta.setTrfPiece(var1[6].substring(0, 20));
         } else {
            this.transfertCompta.setTrfPiece(var1[6]);
         }
      } else {
         this.transfertCompta.setTrfPiece((String)null);
      }

      if (var1[8] != null && !var1[8].isEmpty()) {
         this.transfertCompta.setTrfReference1(var1[8]);
      } else {
         this.transfertCompta.setTrfReference1((String)null);
      }

      this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(this.transfertCompta.getTrfCode(), this.transfertCompta.getTrfDateSaisie()));
      this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.transfertCompta.getTrfDateSaisie()));
      this.transfertCompta.setTrfTypeImport((String)null);
      if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
         if (this.transfertCompta.getTrfCompte() != null && !this.transfertCompta.getTrfCompte().isEmpty()) {
            boolean var5 = false;
            int var4;
            if (this.lePlanComptable.size() != 0) {
               for(var4 = 0; var4 < this.lePlanComptable.size(); ++var4) {
                  if (((PlanComptable)this.lePlanComptable.get(var4)).getPlcSage() != null && !((PlanComptable)this.lePlanComptable.get(var4)).getPlcSage().isEmpty() && ((PlanComptable)this.lePlanComptable.get(var4)).getPlcSage().equalsIgnoreCase(this.transfertCompta.getTrfCompte())) {
                     this.transfertCompta.setTrfCompte(((PlanComptable)this.lePlanComptable.get(var4)).getPlcCompte());
                     var5 = true;
                     break;
                  }

                  if ((((PlanComptable)this.lePlanComptable.get(var4)).getPlcSage() == null || ((PlanComptable)this.lePlanComptable.get(var4)).getPlcSage().isEmpty()) && ((PlanComptable)this.lePlanComptable.get(var4)).getPlcCompte().startsWith(this.transfertCompta.getTrfCompte())) {
                     this.transfertCompta.setTrfCompte(((PlanComptable)this.lePlanComptable.get(var4)).getPlcCompte());
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               if (this.lesTiers.size() != 0) {
                  for(var4 = 0; var4 < this.lesTiers.size(); ++var4) {
                     if (((Tiers)this.lesTiers.get(var4)).getTiecompteSage() != null && !((Tiers)this.lesTiers.get(var4)).getTiecompteSage().isEmpty() && ((Tiers)this.lesTiers.get(var4)).getTiecompteSage().equalsIgnoreCase(this.transfertCompta.getTrfCompte())) {
                        this.transfertCompta.setTrfCompte(((Tiers)this.lesTiers.get(var4)).getTiecompte0());
                        var5 = true;
                        break;
                     }
                  }
               }

               if (!var5) {
               }
            }
         }

         this.lesTransfertCompta.add(this.transfertCompta);
      }

   }

   public void importSageExpert(String[] var1) throws ParseException {
      if (var1[11] != null && !var1[11].isEmpty() && this.filtreNumerique(var1[11]) || var1[12] != null && !var1[12].isEmpty() && this.filtreNumerique(var1[12])) {
         if (var1[0] != null && !var1[0].isEmpty()) {
            this.transfertCompta.setTrfCode(var1[0]);
         } else {
            this.transfertCompta.setTrfCode((String)null);
         }

         Date var2 = null;
         if (var1[3] != null && !var1[3].isEmpty() && var1[3].length() == 8) {
            String var3 = var1[3].substring(0, 4);
            String var4 = var1[3].substring(4, 6);
            String var5 = var1[3].substring(6, 8);
            var2 = this.utilDate.stringToDateSQLLight(var3 + "-" + var4 + "-" + var5);
         }

         this.transfertCompta.setTrfDateSaisie(var2);
         if (var1[4] != null && !var1[4].isEmpty()) {
            this.transfertCompta.setTrfCompte(var1[4]);
         } else {
            this.transfertCompta.setTrfCompte((String)null);
         }

         if (var1[5] != null && !var1[5].isEmpty()) {
            this.transfertCompta.setTrfSuite(var1[5]);
         } else {
            this.transfertCompta.setTrfSuite((String)null);
         }

         if (var1[6] != null && !var1[6].isEmpty()) {
            this.transfertCompta.setTrfCp(var1[6]);
            if (this.transfertCompta.getTrfCp() != null && !this.transfertCompta.getTrfCp().isEmpty()) {
               boolean var6 = false;
               if (this.lePlanComptable.size() != 0) {
                  for(int var7 = 0; var7 < this.lePlanComptable.size(); ++var7) {
                     if (((PlanComptable)this.lePlanComptable.get(var7)).getPlcCompte() != null && !((PlanComptable)this.lePlanComptable.get(var7)).getPlcCompte().isEmpty() && ((PlanComptable)this.lePlanComptable.get(var7)).getPlcCompte().equalsIgnoreCase(this.transfertCompta.getTrfCp())) {
                        this.transfertCompta.setTrfCompte(((PlanComptable)this.lePlanComptable.get(var7)).getPlcCompte());
                        var6 = true;
                        break;
                     }
                  }
               }

               if (!var6) {
                  this.transfertCompta.setTrfCompte(this.transfertCompta.getTrfCp());
               }

               this.transfertCompta.setTrfCp("");
            }
         } else {
            this.transfertCompta.setTrfCp((String)null);
         }

         if (var1[7] != null && !var1[7].isEmpty()) {
            this.transfertCompta.setTrfSuite(var1[7]);
         }

         if (var1[8] != null && !var1[8].isEmpty()) {
            if (var1[8].length() >= 20) {
               this.transfertCompta.setTrfPiece(var1[8].substring(0, 20));
            } else {
               this.transfertCompta.setTrfPiece(var1[8]);
            }
         } else {
            this.transfertCompta.setTrfPiece((String)null);
         }

         if (var1[10] != null && !var1[10].isEmpty()) {
            this.transfertCompta.setTrfLibelle(var1[10]);
         } else {
            this.transfertCompta.setTrfLibelle((String)null);
         }

         if (var1[11] != null && !var1[11].isEmpty()) {
            this.transfertCompta.setTrfDebitSaisie(Double.parseDouble(var1[11]));
         } else {
            this.transfertCompta.setTrfDebitSaisie(0.0D);
         }

         if (var1[12] != null && !var1[12].isEmpty()) {
            this.transfertCompta.setTrfCreditSaisie(Double.parseDouble(var1[12]));
         } else {
            this.transfertCompta.setTrfCreditSaisie(0.0D);
         }

         if (var1.length == 14 || var1.length == 15) {
            if (var1[13] != null && !var1[13].isEmpty()) {
               this.transfertCompta.setTrfLettre(var1[13]);
            } else {
               this.transfertCompta.setTrfLettre("");
            }
         }

         this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(this.transfertCompta.getTrfCode(), this.transfertCompta.getTrfDateSaisie()));
         this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.transfertCompta.getTrfDateSaisie()));
         this.transfertCompta.setTrfTypeImport((String)null);
         if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
            this.lesTransfertCompta.add(this.transfertCompta);
         }
      }

   }

   public void importStandardLightSuite(String[] var1) throws ParseException, ParseException {
      this.transfertCompta = new TransfertCompta();
      this.transfertCompta.setTrfTypeOrigine("1");
      this.transfertCompta.setTrfIdOrigine(0L);
      this.transfertCompta.setTrfAgent(this.usersLog.getUsrPatronyme());
      if (var1[0] != null && !var1[0].isEmpty()) {
         this.transfertCompta.setTrfCode(var1[0]);
      } else {
         this.transfertCompta.setTrfCode((String)null);
      }

      Date var2 = null;
      String var3;
      if (var1[1] != null && !var1[1].isEmpty()) {
         var3 = var1[1].replace("/", "-");
         if (var3.length() == 5 || var3.length() == 7) {
            var3 = "0" + var3;
         }

         if (var3.length() == 6) {
            var3 = "20" + var3.substring(4, 6) + "-" + var3.substring(2, 4) + "-" + var3.substring(0, 2);
         } else if (var3.length() == 8) {
            var3 = var3.substring(5, 8) + "-" + var3.substring(3, 5) + "-" + var3.substring(1, 2);
         }

         var2 = this.utilDate.stringToDateSQLLight(var3);
      } else {
         var2 = this.utilDate.stringToDateSQLLight((String)null);
      }

      this.transfertCompta.setTrfDateSaisie(var2);
      this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(this.transfertCompta.getTrfCode(), this.transfertCompta.getTrfDateSaisie()));
      this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.transfertCompta.getTrfDateSaisie()));
      if (var1[2] != null && !var1[2].isEmpty()) {
         this.transfertCompta.setTrfCompte(var1[2]);
      } else {
         this.transfertCompta.setTrfCompte((String)null);
      }

      this.transfertCompta.setTrfCp((String)null);
      if (var1[4] != null && !var1[4].isEmpty()) {
         if (var1[4].length() >= 20) {
            this.transfertCompta.setTrfPiece(var1[4].substring(0, 20));
         } else {
            this.transfertCompta.setTrfPiece(var1[4]);
         }
      } else {
         this.transfertCompta.setTrfPiece((String)null);
      }

      if (var1[5] != null && !var1[5].isEmpty()) {
         this.transfertCompta.setTrfReference1(var1[5]);
      } else {
         this.transfertCompta.setTrfReference1((String)null);
      }

      if (var1[6] != null && !var1[6].isEmpty()) {
         this.transfertCompta.setTrfReference2(var1[6]);
      } else {
         this.transfertCompta.setTrfReference2((String)null);
      }

      if (var1[7] != null && !var1[7].isEmpty()) {
         this.transfertCompta.setTrfDebitSaisie(Double.parseDouble(var1[7]));
      } else {
         this.transfertCompta.setTrfDebitSaisie(0.0D);
      }

      if (var1[8] != null && !var1[8].isEmpty()) {
         this.transfertCompta.setTrfCreditSaisie(Double.parseDouble(var1[8]));
      } else {
         this.transfertCompta.setTrfCreditSaisie(0.0D);
      }

      if (var1[9] != null && !var1[9].isEmpty()) {
         this.transfertCompta.setTrfLettre(var1[9]);
      } else {
         this.transfertCompta.setTrfLettre((String)null);
      }

      if (var1[10] != null && !var1[10].isEmpty()) {
         this.transfertCompta.setTrfLibelle(var1[10]);
      } else {
         this.transfertCompta.setTrfLibelle((String)null);
      }

      if (var1[10] != null && !var1[10].isEmpty()) {
         if (var1[10].equalsIgnoreCase("null")) {
            this.transfertCompta.setTrfDateEcheance((Date)null);
         } else {
            var3 = var1[10].replace("/", "-");
            if (var3.length() == 5 || var3.length() == 7) {
               var3 = "0" + var3;
            }

            if (var3.length() == 6) {
               var3 = "20" + var3.substring(4, 6) + "-" + var3.substring(2, 4) + "-" + var3.substring(0, 2);
            } else if (var3.length() == 8) {
               var3 = var3.substring(5, 8) + "-" + var3.substring(3, 5) + "-" + var3.substring(1, 2);
            }

            Date var4 = this.utilDate.stringToDateSQLLight(var3);
            this.transfertCompta.setTrfDateEcheance(var4);
         }
      } else {
         this.transfertCompta.setTrfDateEcheance((Date)null);
      }

      if (var1[11] != null && !var1[11].isEmpty()) {
         this.transfertCompta.setTrfLibelle(var1[11]);
      } else {
         this.transfertCompta.setTrfLibelle((String)null);
      }

      this.transfertCompta.setTrfTypeImport((String)null);
      if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
         this.transfertCompta.setTrfDebitSaisie(0.0D);
         this.lesTransfertCompta.add(this.transfertCompta);
      }

   }

   public void importBalance(String[] var1) throws ParseException {
      if (var1[0] != null && !var1[0].isEmpty()) {
         this.transfertCompta.setTrfCompte(var1[0]);
      } else {
         this.transfertCompta.setTrfCompte((String)null);
      }

      if (this.transfertCompta.getTrfCompte() != null && !this.transfertCompta.getTrfCompte().isEmpty() && !this.transfertCompta.getTrfCompte().contains("N COMPTE")) {
         if (var1[1] != null && !var1[1].isEmpty()) {
            this.transfertCompta.setTrfLibelle(this.filtreCaracteres(var1[1]));
         } else {
            this.transfertCompta.setTrfLibelle((String)null);
         }

         if (var1[2] != null && !var1[2].isEmpty()) {
            this.transfertCompta.setTrfDebitSaisie(Double.parseDouble(var1[2]));
         } else {
            this.transfertCompta.setTrfDebitSaisie(0.0D);
         }

         if (var1[3] != null && !var1[3].isEmpty()) {
            this.transfertCompta.setTrfCreditSaisie(Double.parseDouble(var1[3]));
         } else {
            this.transfertCompta.setTrfCreditSaisie(0.0D);
         }

         if (var1[4] != null && !var1[4].isEmpty()) {
            this.transfertCompta.setTrfDebitMvts(Double.parseDouble(var1[4]));
         }

         if (var1[5] != null && !var1[5].isEmpty()) {
            this.transfertCompta.setTrfCreditMvts(Double.parseDouble(var1[5]));
         }

         if (var1[6] != null && !var1[6].isEmpty()) {
         }

         if (var1[7] != null && !var1[7].isEmpty()) {
         }

         String var2 = this.transfertCompta.getTrfCompte();
         String var3 = this.transfertCompta.getTrfLibelle();
         double var4 = this.transfertCompta.getTrfDebitSaisie();
         double var6 = this.transfertCompta.getTrfCreditSaisie();
         double var8 = this.transfertCompta.getTrfDebitMvts();
         double var10 = this.transfertCompta.getTrfCreditMvts();
         TransfertCompta var12 = null;
         if (var4 != 0.0D) {
            var12 = new TransfertCompta();
            var12.setTrfDateSaisie(this.utilDate.stringToDateSQLLight(this.exercicesComptable.getExecptDateFin().getYear() + 1900 + "-01-01"));
            var12.setTrfCompte(var2);
            var12.setTrfLibelle(var3);
            var12.setTrfCode("AN");
            var12.setTrfPiece("AN");
            var12.setTrfCle1(this.formTransfertCtrl.calculCle1(var12.getTrfCode(), var12.getTrfDateSaisie()));
            var12.setTrfPeriode(this.formTransfertCtrl.calculPeriode(var12.getTrfDateSaisie()));
            var12.setTrfDateEcheance((Date)null);
            var12.setTrfTypeImport("BALANCE");
            var12.setTrfDebitSaisie(var4);
            var12.setTrfCreditSaisie(0.0D);
            var12.setTrfDebitMvts(0.0D);
            var12.setTrfCreditMvts(0.0D);
            this.lesTransfertCompta.add(var12);
         }

         if (var6 != 0.0D) {
            var12 = new TransfertCompta();
            var12.setTrfDateSaisie(this.utilDate.stringToDateSQLLight(this.exercicesComptable.getExecptDateFin().getYear() + 1900 + "-01-01"));
            var12.setTrfCompte(var2);
            var12.setTrfLibelle(var3);
            var12.setTrfCode("AN");
            var12.setTrfPiece("AN");
            var12.setTrfCle1(this.formTransfertCtrl.calculCle1(var12.getTrfCode(), var12.getTrfDateSaisie()));
            var12.setTrfPeriode(this.formTransfertCtrl.calculPeriode(var12.getTrfDateSaisie()));
            var12.setTrfDateEcheance((Date)null);
            var12.setTrfTypeImport("BALANCE");
            var12.setTrfDebitSaisie(0.0D);
            var12.setTrfCreditSaisie(var6);
            var12.setTrfDebitMvts(0.0D);
            var12.setTrfCreditMvts(0.0D);
            this.lesTransfertCompta.add(var12);
         }

         if (var8 != 0.0D) {
            var12 = new TransfertCompta();
            var12.setTrfDateSaisie(this.utilDate.stringToDateSQLLight(this.exercicesComptable.getExecptDateFin().getYear() + 1900 + "-12-31"));
            var12.setTrfCompte(var2);
            var12.setTrfLibelle(var3);
            var12.setTrfCode("OD");
            var12.setTrfPiece("OD");
            var12.setTrfCle1(this.formTransfertCtrl.calculCle1(var12.getTrfCode(), var12.getTrfDateSaisie()));
            var12.setTrfPeriode(this.formTransfertCtrl.calculPeriode(var12.getTrfDateSaisie()));
            var12.setTrfDateEcheance((Date)null);
            var12.setTrfTypeImport("BALANCE");
            var12.setTrfDebitSaisie(0.0D);
            var12.setTrfCreditSaisie(0.0D);
            var12.setTrfDebitMvts(var8);
            var12.setTrfCreditMvts(0.0D);
            this.lesTransfertCompta.add(var12);
         }

         if (var10 != 0.0D) {
            var12 = new TransfertCompta();
            var12.setTrfDateSaisie(this.utilDate.stringToDateSQLLight(this.exercicesComptable.getExecptDateFin().getYear() + 1900 + "-12-31"));
            var12.setTrfCompte(var2);
            var12.setTrfLibelle(var3);
            var12.setTrfCode("OD");
            var12.setTrfPiece("OD");
            var12.setTrfCle1(this.formTransfertCtrl.calculCle1(var12.getTrfCode(), var12.getTrfDateSaisie()));
            var12.setTrfPeriode(this.formTransfertCtrl.calculPeriode(var12.getTrfDateSaisie()));
            var12.setTrfDateEcheance((Date)null);
            var12.setTrfTypeImport("BALANCE");
            var12.setTrfDebitSaisie(0.0D);
            var12.setTrfCreditSaisie(0.0D);
            var12.setTrfDebitMvts(0.0D);
            var12.setTrfCreditMvts(var10);
            this.lesTransfertCompta.add(var12);
         }
      }

   }

   public void importPlanComptable(String[] var1) {
      int var5;
      if (var1[0] != null && !var1[0].isEmpty()) {
         if (var1[1] != null && !var1[1].isEmpty()) {
            if (var1[0].length() != Integer.parseInt(this.optionComptabilite.getNbcr())) {
               String var2 = "";
               boolean var3 = false;
               String var4 = "";
               var4 = var1[0].substring(0, 4);
               if (var4.startsWith("40")) {
                  var2 = "" + this.compteurFournisseur;
                  ++this.compteurFournisseur;
               } else if (var4.startsWith("41")) {
                  var2 = "" + this.compteurclient;
                  ++this.compteurclient;
               } else if (var4.startsWith("42")) {
                  var2 = "" + this.compteurPersonnel;
                  ++this.compteurPersonnel;
               } else if (var4.startsWith("46")) {
                  var2 = "" + this.compteurAssocie;
                  ++this.compteurAssocie;
               } else if (var4.startsWith("47")) {
                  var2 = "" + this.compteurAttente;
                  ++this.compteurAttente;
               } else if (var4.startsWith("48")) {
                  var2 = "" + this.compteurInvestissement;
                  ++this.compteurInvestissement;
               }

               var5 = Integer.parseInt(this.optionComptabilite.getNbcr()) - 4 - var2.length();
               if (var5 == 1) {
                  var2 = "0" + var2;
               } else if (var5 == 2) {
                  var2 = "00" + var2;
               } else if (var5 == 3) {
                  var2 = "000" + var2;
               } else if (var5 == 4) {
                  var2 = "0000" + var2;
               } else if (var5 == 5) {
                  var2 = "00000" + var2;
               } else if (var5 == 6) {
                  var2 = "000000" + var2;
               } else if (var5 == 7) {
                  var2 = "0000000" + var2;
               } else if (var5 == 8) {
                  var2 = "00000000" + var2;
               } else if (var5 == 9) {
                  var2 = "000000000" + var2;
               } else if (var5 == 10) {
                  var2 = "0000000000" + var2;
               }

               this.transfertCompta.setTrfCompte(var4 + var2);
            } else {
               this.transfertCompta.setTrfCompte(var1[0]);
            }
         } else {
            this.transfertCompta.setTrfCompte(var1[0]);
         }
      } else {
         this.transfertCompta.setTrfCompte((String)null);
      }

      if (var1[1] != null && !var1[1].isEmpty()) {
         this.transfertCompta.setTrfCp(var1[1]);
      } else {
         this.transfertCompta.setTrfCp((String)null);
      }

      if (var1[2] != null && !var1[2].isEmpty()) {
         this.transfertCompta.setTrfLibelle(var1[2].toUpperCase());
      } else {
         this.transfertCompta.setTrfLibelle((String)null);
      }

      if (this.transfertCompta.getTrfCompte() != null && !this.transfertCompta.getTrfCompte().isEmpty()) {
         boolean var6 = false;
         if (this.lePlanComptable.size() != 0) {
            for(var5 = 0; var5 < this.lePlanComptable.size(); ++var5) {
               if (((PlanComptable)this.lePlanComptable.get(var5)).getPlcCompte() != null && !((PlanComptable)this.lePlanComptable.get(var5)).getPlcCompte().isEmpty() && this.transfertCompta.getTrfCompte() != null && !this.transfertCompta.getTrfCompte().isEmpty() && ((PlanComptable)this.lePlanComptable.get(var5)).getPlcCompte().equals(this.transfertCompta.getTrfCompte())) {
                  var6 = true;
                  break;
               }
            }
         }

         if (!var6) {
            this.transfertCompta.setTrfTypeImport("PLANCOMPTABLE");
            this.lesTransfertCompta.add(this.transfertCompta);
         }
      }

   }

   public void importEcritureSage(int var1, String var2) throws ParseException {
      if (var1 == 1) {
         this.transfertCompta.setTrfCode(var2);
      } else {
         String var5;
         String var6;
         Date var7;
         if (var1 == 2 && var2 != null && !var2.isEmpty()) {
            var5 = null;
            var6 = var2;
            if (var2.length() == 5 || var2.length() == 7) {
               var6 = "0" + var2;
            }

            if (var6.length() == 6) {
               var6 = "20" + var6.substring(4, 6) + "-" + var6.substring(2, 4) + "-" + var6.substring(0, 2);
            } else if (var6.length() == 8) {
               var6 = var6.substring(5, 8) + "-" + var6.substring(3, 5) + "-" + var6.substring(1, 2);
            }

            var7 = this.utilDate.stringToDateSQLLight(var6);
            this.transfertCompta.setTrfDateSaisie(var7);
         } else if (var1 == 4) {
            this.transfertCompta.setTrfPiece(var2);
         } else if (var1 == 5) {
            this.transfertCompta.setTrfReference1(var2);
         } else if (var1 == 7) {
            this.transfertCompta.setTrfCompte(var2);
         } else if (var1 == 9) {
            this.transfertCompta.setTrfCp(var2);
            if (this.transfertCompta.getTrfCp() != null && !this.transfertCompta.getTrfCp().isEmpty()) {
               boolean var3 = false;
               if (this.lePlanComptable.size() != 0) {
                  for(int var4 = 0; var4 < this.lePlanComptable.size(); ++var4) {
                     if (((PlanComptable)this.lePlanComptable.get(var4)).getPlcSage() != null && !((PlanComptable)this.lePlanComptable.get(var4)).getPlcSage().isEmpty() && ((PlanComptable)this.lePlanComptable.get(var4)).getPlcSage().equalsIgnoreCase(this.transfertCompta.getTrfCp()) && ((PlanComptable)this.lePlanComptable.get(var4)).getPlcCompte().substring(0, 4).equals(this.transfertCompta.getTrfCompte().substring(0, 4))) {
                        this.transfertCompta.setTrfCompte(((PlanComptable)this.lePlanComptable.get(var4)).getPlcCompte());
                        var3 = true;
                        break;
                     }
                  }
               }

               if (!var3) {
                  this.transfertCompta.setTrfCompte(this.transfertCompta.getTrfCp());
               }

               this.transfertCompta.setTrfCp("");
            }
         } else if (var1 == 11) {
            this.transfertCompta.setTrfLibelle(var2);
         } else if (var1 == 13 && var2 != null && !var2.isEmpty()) {
            var5 = null;
            var6 = var2;
            if (var2.length() == 5 || var2.length() == 7) {
               var6 = "0" + var2;
            }

            if (var6.length() == 6) {
               var6 = "20" + var6.substring(4, 6) + "-" + var6.substring(2, 4) + "-" + var6.substring(0, 2);
            } else if (var6.length() == 8) {
               var6 = var6.substring(5, 8) + "-" + var6.substring(3, 5) + "-" + var6.substring(1, 2);
            }

            var7 = this.utilDate.stringToDateSQLLight(var6);
            this.transfertCompta.setTrfDateEcheance(var7);
         } else if (var1 == 17) {
            if (var2 != null && !var2.isEmpty()) {
               this.transfertCompta.setTrfSuite(var2);
            } else {
               this.transfertCompta.setTrfSuite("0");
            }
         } else if (var1 == 18) {
            if (var2 != null && !var2.isEmpty()) {
               if (this.transfertCompta.getTrfSuite() != null && !this.transfertCompta.getTrfSuite().isEmpty() && this.transfertCompta.getTrfSuite().equals("0")) {
                  this.transfertCompta.setTrfDebitSaisie(Double.parseDouble(var2.replace(",", ".")));
                  this.transfertCompta.setTrfCreditSaisie(0.0D);
               } else {
                  this.transfertCompta.setTrfCreditSaisie(Double.parseDouble(var2.replace(",", ".")));
                  this.transfertCompta.setTrfDebitSaisie(0.0D);
               }
            }

            this.transfertCompta.setTrfSuite("");
         } else if (var1 == 19) {
            this.transfertCompta.setTrfLettre(var2);
         } else if (var1 == 32) {
            var5 = "";
            if (var2 != null && !var2.isEmpty()) {
               if (var2.length() == 5) {
                  var2 = "0" + var2;
               }

               if (var2.length() == 6) {
                  var5 = "20" + var2.substring(4, 6) + ":" + var2.substring(2, 4);
               }
            }

            this.transfertCompta.setTrfTreso(var5);
         } else if (var1 == 33) {
            this.transfertCompta.setTrfReference2(var2);
         } else if (var1 == 41) {
            this.transfertCompta.setTrfDossier(var2);
         }
      }

   }

   public void importImmobilisationSage(int var1, String var2) throws ParseException {
      if (var1 == 2) {
         this.transfertCompta.setTrfCode(var2);
      } else if (var1 == 4) {
         this.transfertCompta.setTrfLibelle(var2);
      } else if (var1 == 7) {
         this.transfertCompta.setTrfDossier(var2);
      } else if (var1 == 9) {
         this.transfertCompta.setTrfSuite(var2);
      } else if (var1 == 11) {
         this.transfertCompta.setTrfPiece(var2);
      } else if (var1 == 12 && var2 != null && !var2.isEmpty()) {
         this.transfertCompta.setTrfDebitSaisie(Double.parseDouble(var2));
      } else if (var1 == 13 && var2 != null && !var2.isEmpty()) {
         this.transfertCompta.setTrfCreditSaisie(Double.parseDouble(var2));
      } else {
         Date var3;
         String var4;
         if (var1 == 14 && var2 != null && !var2.isEmpty()) {
            var3 = null;
            var4 = var2;
            if (var2.length() == 5 || var2.length() == 7) {
               var4 = "0" + var2;
            }

            if (var4.length() == 6) {
               var4 = "20" + var4.substring(4, 6) + "-" + var4.substring(2, 4) + "-" + var4.substring(0, 2);
            } else if (var4.length() == 8) {
               var4 = var4.substring(4, 8) + "-" + var4.substring(2, 4) + "-" + var4.substring(0, 2);
            }

            var3 = this.utilDate.stringToDateSQLLight(var4);
            this.transfertCompta.setTrfDateSaisie(var3);
         } else if (var1 == 15 && var2 != null && !var2.isEmpty()) {
            var3 = null;
            var4 = var2;
            if (var2.length() == 5 || var2.length() == 7) {
               var4 = "0" + var2;
            }

            if (var4.length() == 6) {
               var4 = "20" + var4.substring(4, 6) + "-" + var4.substring(2, 4) + "-" + var4.substring(0, 2);
            } else if (var4.length() == 8) {
               var4 = var4.substring(4, 8) + "-" + var4.substring(2, 4) + "-" + var4.substring(0, 2);
            }

            var3 = this.utilDate.stringToDateSQLLight(var4);
            this.transfertCompta.setTrfDateValeurTheo(var3);
         } else if (var1 == 34) {
            this.transfertCompta.setTrfCompte(var2);
         } else if (var1 == 35) {
            this.transfertCompta.setTrfCp(var2);
         } else if (var1 == 36) {
            this.transfertCompta.setTrfBudget(var2);
         } else if (var1 == 50 && var2 != null && !var2.isEmpty()) {
            this.transfertCompta.setTrfDebitMvts(Double.parseDouble(var2));
         } else if (var1 == 51 && var2 != null && !var2.isEmpty()) {
            this.transfertCompta.setTrfCreditMvts(Double.parseDouble(var2));
         } else if (var1 == 104) {
            this.transfertCompta.setTrfReference2(var2);
         }
      }

   }

   public void importPlanGeneralSage(int var1, String var2) throws ParseException {
      if (var1 == 1) {
         if ((var2 == null || var2.isEmpty() || !var2.startsWith("1")) && !var2.startsWith("2") && !var2.startsWith("3") && !var2.startsWith("4") && !var2.startsWith("5") && !var2.startsWith("6") && !var2.startsWith("7") && !var2.startsWith("8") && !var2.startsWith("9")) {
            this.transfertCompta.setTrfCompte("????");
         } else {
            this.transfertCompta.setTrfCompte(var2);
         }
      } else if (var1 == 3) {
         if (var2 != null && !var2.isEmpty()) {
            this.transfertCompta.setTrfLibelle(var2.toUpperCase());
         } else {
            this.transfertCompta.setTrfLibelle("????");
         }
      }

      this.transfertCompta.setTrfTypeImport("PLANCOMPTABLE");
   }

   public void importPlanTiersSage(int var1, String var2) throws ParseException {
      if (var1 == 1) {
         this.transfertCompta.setTrfCp(var2);
      } else if (var1 == 2) {
         this.transfertCompta.setTrfLibelle(var2.toUpperCase());
      } else if (var1 == 4) {
         String var3 = "";
         boolean var4 = false;
         String var5 = "";
         var5 = var2.substring(0, 4);
         if (var5.startsWith("40")) {
            var3 = "" + this.compteurFournisseur;
         } else if (var5.startsWith("41")) {
            var3 = "" + this.compteurclient;
         } else if (var5.startsWith("42")) {
            var3 = "" + this.compteurPersonnel;
         } else if (var5.startsWith("46")) {
            var3 = "" + this.compteurAssocie;
         } else if (var5.startsWith("47")) {
            var3 = "" + this.compteurAttente;
         } else if (var5.startsWith("48")) {
            var3 = "" + this.compteurInvestissement;
         }

         int var6 = Integer.parseInt(this.optionComptabilite.getNbcr()) - 4 - var3.length();
         if (var6 == 1) {
            var3 = "0" + var3;
         } else if (var6 == 2) {
            var3 = "00" + var3;
         } else if (var6 == 3) {
            var3 = "000" + var3;
         } else if (var6 == 4) {
            var3 = "0000" + var3;
         } else if (var6 == 5) {
            var3 = "00000" + var3;
         } else if (var6 == 6) {
            var3 = "000000" + var3;
         } else if (var6 == 7) {
            var3 = "0000000" + var3;
         } else if (var6 == 8) {
            var3 = "00000000" + var3;
         } else if (var6 == 9) {
            var3 = "000000000" + var3;
         } else if (var6 == 10) {
            var3 = "0000000000" + var3;
         }

         this.transfertCompta.setTrfTypeImport("PLANCOMPTABLE");
         this.transfertCompta.setTrfCompte(var5 + var3);
      }

   }

   public void importJournauxSage(int var1, String var2) throws ParseException {
      if (var1 == 1) {
         this.transfertCompta.setTrfCode(var2);
      } else if (var1 == 2) {
         this.transfertCompta.setTrfLibelle(var2.toUpperCase());
      } else if (var1 == 3) {
         if (var2 != null && !var2.isEmpty()) {
            String var3 = "";
            boolean var4 = false;
            int var5 = Integer.parseInt(this.optionComptabilite.getNbcr()) - var2.length();
            if (var5 == 1) {
               var3 = var2 + "0";
            } else if (var5 == 2) {
               var3 = var2 + "00";
            } else if (var5 == 3) {
               var3 = var2 + "000";
            } else if (var5 == 4) {
               var3 = var2 + "0000";
            } else if (var5 == 5) {
               var3 = var2 + "00000";
            } else if (var5 == 6) {
               var3 = var2 + "000000";
            } else if (var5 == 7) {
               var3 = var2 + "0000000";
            } else if (var5 == 8) {
               var3 = var2 + "00000000";
            } else if (var5 == 9) {
               var3 = var2 + "000000000";
            } else if (var5 == 10) {
               var3 = var2 + "0000000000";
            }

            this.transfertCompta.setTrfCp(var3);
         } else {
            this.transfertCompta.setTrfCp("");
         }
      } else if (var1 == 4) {
         int var6 = Integer.parseInt(var2);
         if (var6 == 0) {
            this.transfertCompta.setTrfCategorie(1);
         } else if (var6 == 1) {
            this.transfertCompta.setTrfCategorie(2);
         } else if (var6 == 2) {
            if (this.transfertCompta.getTrfCp() != null && !this.transfertCompta.getTrfCp().isEmpty()) {
               if (this.transfertCompta.getTrfCp().startsWith("52")) {
                  this.transfertCompta.setTrfCategorie(8);
               } else if (this.transfertCompta.getTrfCp().startsWith("57")) {
                  this.transfertCompta.setTrfCategorie(10);
               } else if (this.transfertCompta.getTrfCp().startsWith("17")) {
                  this.transfertCompta.setTrfCategorie(8);
               } else {
                  this.transfertCompta.setTrfCategorie(0);
               }
            } else {
               this.transfertCompta.setTrfCategorie(0);
            }
         } else {
            this.transfertCompta.setTrfCategorie(0);
         }
      }

      this.transfertCompta.setTrfTypeImport("JOURNAUX");
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz./+-*=()%_&1234567890".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         } else if (var3.equals("'")) {
            var2 = var2 + "`";
         } else {
            var2 = var2 + " ";
         }
      }

      return var2;
   }

   public boolean filtreNumerique(String var1) {
      boolean var2 = false;
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("1234567890".contains(var3)) {
            var2 = true;
            break;
         }
      }

      return var2;
   }

   public void importVacataire(String[] var1) throws ParseException {
      this.transfertCompta.setTrfCode("VAC");
      Date var2 = null;
      if (var1[1] != null && !var1[1].isEmpty()) {
         var2 = this.utilDate.stringToDateSQLLight(var1[1]);
      } else {
         var2 = this.utilDate.stringToDateSQLLight((String)null);
      }

      this.transfertCompta.setTrfDateSaisie(var2);
      this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(this.transfertCompta.getTrfCode(), this.transfertCompta.getTrfDateSaisie()));
      this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.transfertCompta.getTrfDateSaisie()));
      if (var1[12] != null && !var1[12].isEmpty()) {
         if (var1[12].contains("-")) {
            String[] var3 = var1[12].split("-");
            this.transfertCompta.setTrfCompte("401100" + var3[1]);
         } else {
            this.transfertCompta.setTrfCompte(var1[12]);
         }
      } else {
         this.transfertCompta.setTrfCompte((String)null);
      }

      this.transfertCompta.setTrfPiece((String)null);
      if (var1[4] != null && !var1[4].isEmpty()) {
         this.transfertCompta.setTrfReference1(var1[4]);
      } else {
         this.transfertCompta.setTrfReference1((String)null);
      }

      this.transfertCompta.setTrfReference2((String)null);
      this.transfertCompta.setTrfDebitSaisie(0.0D);
      this.transfertCompta.setTrfCreditSaisie(Double.parseDouble(var1[7]));
      this.transfertCompta.setTrfTreso((String)null);
      if (var1[9] != null && !var1[9].isEmpty()) {
         this.transfertCompta.setTrfLibelle(var1[9]);
      } else {
         this.transfertCompta.setTrfLibelle((String)null);
      }

      if (var1[10] != null && !var1[10].isEmpty()) {
         if (var1[10].equalsIgnoreCase("null")) {
            this.transfertCompta.setTrfDateEcheance((Date)null);
         } else {
            Date var5 = this.utilDate.stringToDateSQLLight(var1[10]);
            this.transfertCompta.setTrfDateEcheance(var5);
         }
      } else {
         this.transfertCompta.setTrfDateEcheance((Date)null);
      }

      this.transfertCompta.setTrfActivite((String)null);
      if (var1[12] != null && !var1[12].isEmpty()) {
         this.transfertCompta.setTrfDossier(var1[12]);
      } else {
         this.transfertCompta.setTrfDossier((String)null);
      }

      if (var1[13] != null && !var1[13].isEmpty()) {
         this.transfertCompta.setTrfParc(var1[13]);
      } else {
         this.transfertCompta.setTrfParc((String)null);
      }

      if (var1[14] != null && !var1[14].isEmpty()) {
         this.transfertCompta.setTrfSite(var1[14]);
      } else {
         this.transfertCompta.setTrfSite((String)null);
      }

      if (var1[15] != null && !var1[15].isEmpty()) {
         this.transfertCompta.setTrfDepartement(var1[15]);
      } else {
         this.transfertCompta.setTrfDepartement((String)null);
      }

      if (var1[11] != null && !var1[11].isEmpty()) {
         this.transfertCompta.setTrfService((String)null);
      } else {
         this.transfertCompta.setTrfService((String)null);
      }

      String var6 = this.utilNombre.beginSimple(Double.parseDouble(var1[17]), "");
      this.transfertCompta.setTrfRegion(var6);
      String var4 = this.utilNombre.beginSimple(Double.parseDouble(var1[18]), "");
      this.transfertCompta.setTrfSecteur(var4);
      this.transfertCompta.setTrfPdv((String)null);
      if (var1[20] != null && !var1[20].isEmpty()) {
         this.transfertCompta.setTrfBudget(var1[20]);
      } else {
         this.transfertCompta.setTrfBudget((String)null);
      }

      this.transfertCompta.setTrfTypeImport(var1[21]);
      if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D || this.transfertCompta.getTrfRegion() != null && !this.transfertCompta.getTrfRegion().isEmpty()) {
         this.lesTransfertCompta.add(this.transfertCompta);
      }

   }

   public void mefVacataire() {
      ArrayList var1 = new ArrayList();
      new TransfertCompta();

      int var3;
      for(var3 = 0; var3 < this.lesTransfertCompta.size(); ++var3) {
         this.transfertCompta = (TransfertCompta)this.lesTransfertCompta.get(var3);
         TransfertCompta var2 = new TransfertCompta();
         var2.setTrfActivite(this.transfertCompta.getTrfActivite());
         var2.setTrfAgent(this.transfertCompta.getTrfAgent());
         var2.setTrfBudget(this.transfertCompta.getTrfBudget());
         var2.setTrfCategorie(this.transfertCompta.getTrfCategorie());
         var2.setTrfCle1(this.transfertCompta.getTrfCle1());
         var2.setTrfCode(this.transfertCompta.getTrfCode());
         var2.setTrfCompte(this.transfertCompta.getTrfCompte());
         var2.setTrfCreditSaisie(this.transfertCompta.getTrfCreditSaisie());
         var2.setTrfDateEcheance(this.transfertCompta.getTrfDateEcheance());
         var2.setTrfDateSaisie(this.transfertCompta.getTrfDateSaisie());
         var2.setTrfDateValeurTheo(this.transfertCompta.getTrfDateValeurTheo());
         var2.setTrfDebitSaisie(0.0D);
         var2.setTrfDepartement("");
         var2.setTrfDossier("");
         var2.setTrfIdOrigine(this.transfertCompta.getTrfIdOrigine());
         var2.setTrfLibelle(this.transfertCompta.getTrfLibelle() + " " + this.transfertCompta.getTrfParc());
         var2.setTrfModeReglement(this.transfertCompta.getTrfModeReglement());
         var2.setTrfNature(this.transfertCompta.getTrfNature());
         var2.setTrfParc("");
         var2.setTrfPdv("");
         var2.setTrfPeriode(this.transfertCompta.getTrfPeriode());
         var2.setTrfPiece(this.transfertCompta.getTrfPiece());
         var2.setTrfProjet("");
         var2.setTrfReference1(this.transfertCompta.getTrfReference1());
         var2.setTrfReference2(this.transfertCompta.getTrfReference2());
         var2.setTrfRegion("");
         var2.setTrfRepartitionCle1(this.transfertCompta.getTrfRepartitionCle1());
         var2.setTrfRepartitionCle2(this.transfertCompta.getTrfRepartitionCle2());
         var2.setTrfSecteur("");
         var2.setTrfService("");
         var2.setTrfSite("");
         var2.setTrfSuite(this.transfertCompta.getTrfSuite());
         var2.setTrfTreso(this.transfertCompta.getTrfTreso());
         var2.setTrfTypeImport(this.transfertCompta.getTrfTypeImport());
         var2.setTrfTypeOrigine(this.transfertCompta.getTrfTypeOrigine());
         var1.add(var2);
         var2 = new TransfertCompta();
         var2.setTrfActivite(this.transfertCompta.getTrfActivite());
         var2.setTrfAgent(this.transfertCompta.getTrfAgent());
         var2.setTrfBudget(this.transfertCompta.getTrfBudget());
         var2.setTrfCategorie(this.transfertCompta.getTrfCategorie());
         var2.setTrfCle1(this.transfertCompta.getTrfCle1());
         var2.setTrfCode(this.transfertCompta.getTrfCode());
         var2.setTrfCompte("6328200000");
         var2.setTrfCreditSaisie(0.0D);
         var2.setTrfDateEcheance(this.transfertCompta.getTrfDateEcheance());
         var2.setTrfDateSaisie(this.transfertCompta.getTrfDateSaisie());
         var2.setTrfDateValeurTheo(this.transfertCompta.getTrfDateValeurTheo());
         var2.setTrfDebitSaisie(Double.parseDouble(this.transfertCompta.getTrfRegion()));
         var2.setTrfDepartement(this.transfertCompta.getTrfDepartement());
         var2.setTrfDossier("");
         var2.setTrfIdOrigine(this.transfertCompta.getTrfIdOrigine());
         var2.setTrfLibelle(this.transfertCompta.getTrfLibelle());
         var2.setTrfModeReglement(this.transfertCompta.getTrfModeReglement());
         var2.setTrfNature(this.transfertCompta.getTrfNature());
         var2.setTrfParc("");
         var2.setTrfPdv("");
         var2.setTrfPeriode(this.transfertCompta.getTrfPeriode());
         var2.setTrfPiece(this.transfertCompta.getTrfPiece());
         var2.setTrfProjet("");
         var2.setTrfReference1(this.transfertCompta.getTrfReference1());
         var2.setTrfReference2(this.transfertCompta.getTrfReference2());
         var2.setTrfRegion("");
         var2.setTrfRepartitionCle1(this.transfertCompta.getTrfRepartitionCle1());
         var2.setTrfRepartitionCle2(this.transfertCompta.getTrfRepartitionCle2());
         var2.setTrfSecteur("");
         var2.setTrfService("");
         var2.setTrfSite(this.transfertCompta.getTrfSite());
         var2.setTrfSuite(this.transfertCompta.getTrfDepartement());
         var2.setTrfTreso(this.transfertCompta.getTrfTreso());
         var2.setTrfTypeImport(this.transfertCompta.getTrfTypeImport());
         var2.setTrfTypeOrigine(this.transfertCompta.getTrfTypeOrigine());
         var1.add(var2);
         var2 = new TransfertCompta();
         var2.setTrfActivite(this.transfertCompta.getTrfActivite());
         var2.setTrfAgent(this.transfertCompta.getTrfAgent());
         var2.setTrfBudget(this.transfertCompta.getTrfBudget());
         var2.setTrfCategorie(this.transfertCompta.getTrfCategorie());
         var2.setTrfCle1(this.transfertCompta.getTrfCle1());
         var2.setTrfCode(this.transfertCompta.getTrfCode());
         var2.setTrfCompte("4473000000");
         var2.setTrfCreditSaisie(Double.parseDouble(this.transfertCompta.getTrfSecteur()));
         var2.setTrfDateEcheance(this.transfertCompta.getTrfDateEcheance());
         var2.setTrfDateSaisie(this.transfertCompta.getTrfDateSaisie());
         var2.setTrfDateValeurTheo(this.transfertCompta.getTrfDateValeurTheo());
         var2.setTrfDebitSaisie(0.0D);
         var2.setTrfDepartement("");
         var2.setTrfDossier("");
         var2.setTrfIdOrigine(this.transfertCompta.getTrfIdOrigine());
         var2.setTrfLibelle("RETENUE A LA SOURCE BRS 5%");
         var2.setTrfModeReglement(this.transfertCompta.getTrfModeReglement());
         var2.setTrfNature(this.transfertCompta.getTrfNature());
         var2.setTrfParc("");
         var2.setTrfPdv("");
         var2.setTrfPeriode(this.transfertCompta.getTrfPeriode());
         var2.setTrfPiece(this.transfertCompta.getTrfPiece());
         var2.setTrfProjet("");
         var2.setTrfReference1(this.transfertCompta.getTrfReference1());
         var2.setTrfReference2(this.transfertCompta.getTrfReference2());
         var2.setTrfRegion("");
         var2.setTrfRepartitionCle1(this.transfertCompta.getTrfRepartitionCle1());
         var2.setTrfRepartitionCle2(this.transfertCompta.getTrfRepartitionCle2());
         var2.setTrfSecteur("");
         var2.setTrfService("");
         var2.setTrfSite("");
         var2.setTrfSuite(this.transfertCompta.getTrfSuite());
         var2.setTrfTreso(this.transfertCompta.getTrfTreso());
         var2.setTrfTypeImport(this.transfertCompta.getTrfTypeImport());
         var2.setTrfTypeOrigine(this.transfertCompta.getTrfTypeOrigine());
         var1.add(var2);
      }

      this.lesTransfertCompta.clear();

      for(var3 = 0; var3 < var1.size(); ++var3) {
         this.transfertCompta = (TransfertCompta)var1.get(var3);
         this.lesTransfertCompta.add(this.transfertCompta);
      }

      var1.clear();
   }

   public void importEleve(String[] var1) throws ParseException {
      if (var1[0] != null && !var1[0].isEmpty()) {
         this.transfertCompta.setTrfCode(var1[0]);
      } else if (var1[4] != null && !var1[4].isEmpty()) {
         this.transfertCompta.setTrfCode(var1[4].substring(0, 3));
      } else {
         this.transfertCompta.setTrfCode("XXX");
      }

      if (this.transfertCompta.getTrfCode().equals("SAN")) {
         this.transfertCompta.setTrfCode("CA1");
      } else if (this.transfertCompta.getTrfCode().equals("CHN")) {
         this.transfertCompta.setTrfCode("CA1");
      } else if (this.transfertCompta.getTrfCode().equals("CHE")) {
         this.transfertCompta.setTrfCode("CA1");
      } else if (this.transfertCompta.getTrfCode().equals("PAD")) {
         this.transfertCompta.setTrfCode("CRPE");
      } else if (this.transfertCompta.getTrfCode().equals("SOA")) {
         this.transfertCompta.setTrfCode("CAR6");
      } else if (this.transfertCompta.getTrfCode().equals("DKH")) {
         this.transfertCompta.setTrfCode("CAR4");
      } else if (this.transfertCompta.getTrfCode().equals("BAB")) {
         this.transfertCompta.setTrfCode("CAR4");
      }

      Date var2 = null;
      if (var1[1] != null && !var1[1].isEmpty()) {
         var2 = this.utilDate.stringToDateSQLLight(var1[1]);
      } else {
         var2 = this.utilDate.stringToDateSQLLight((String)null);
      }

      this.transfertCompta.setTrfDateSaisie(var2);
      this.transfertCompta.setTrfCle1(this.formTransfertCtrl.calculCle1(this.transfertCompta.getTrfCode(), this.transfertCompta.getTrfDateSaisie()));
      this.transfertCompta.setTrfPeriode(this.formTransfertCtrl.calculPeriode(this.transfertCompta.getTrfDateSaisie()));
      if (var1[12] != null && !var1[12].isEmpty()) {
         if (var1[12].contains("-")) {
            String[] var3 = var1[12].split("-");
            String var4 = var3[0].substring(0, 3);
            String var5 = var3[0].substring(6, 7);
            this.transfertCompta.setTrfCompte("41" + var4 + var5 + var3[1]);
         } else if (var1[12].length() >= 11) {
            this.transfertCompta.setTrfCompte("41" + var1[12].substring(3, 11));
         } else {
            this.transfertCompta.setTrfCompte(var1[12]);
         }
      } else {
         this.transfertCompta.setTrfCompte((String)null);
      }

      this.transfertCompta.setTrfPiece((String)null);
      if (var1[4] != null && !var1[4].isEmpty()) {
         this.transfertCompta.setTrfReference1(var1[4]);
      } else {
         this.transfertCompta.setTrfReference1((String)null);
      }

      this.transfertCompta.setTrfReference2((String)null);
      this.transfertCompta.setTrfDebitSaisie(0.0D);
      this.transfertCompta.setTrfCreditSaisie(Double.parseDouble(var1[6]));
      if (var1[5] != null && !var1[5].isEmpty()) {
         this.transfertCompta.setTrfTreso(var1[5]);
      } else {
         this.transfertCompta.setTrfTreso("0");
      }

      if (var1[9] != null && !var1[9].isEmpty()) {
         this.transfertCompta.setTrfLibelle(var1[9]);
      } else {
         this.transfertCompta.setTrfLibelle((String)null);
      }

      if (var1[10] != null && !var1[10].isEmpty()) {
         if (var1[10].equalsIgnoreCase("null")) {
            this.transfertCompta.setTrfDateEcheance((Date)null);
         } else {
            Date var6 = this.utilDate.stringToDateSQLLight(var1[10]);
            this.transfertCompta.setTrfDateEcheance(var6);
         }
      } else {
         this.transfertCompta.setTrfDateEcheance((Date)null);
      }

      this.transfertCompta.setTrfActivite((String)null);
      if (var1[12] != null && !var1[12].isEmpty()) {
         this.transfertCompta.setTrfDossier(var1[12]);
      } else {
         this.transfertCompta.setTrfDossier((String)null);
      }

      if (var1[13] != null && !var1[13].isEmpty()) {
         this.transfertCompta.setTrfParc(var1[13]);
      } else {
         this.transfertCompta.setTrfParc((String)null);
      }

      if (var1[14] != null && !var1[14].isEmpty()) {
         this.transfertCompta.setTrfSite(var1[14]);
      } else {
         this.transfertCompta.setTrfSite((String)null);
      }

      if (var1[15] != null && !var1[15].isEmpty()) {
         this.transfertCompta.setTrfDepartement(var1[15]);
      } else {
         this.transfertCompta.setTrfDepartement((String)null);
      }

      if (var1[11] != null && !var1[11].isEmpty()) {
         this.transfertCompta.setTrfService((String)null);
      } else {
         this.transfertCompta.setTrfService((String)null);
      }

      this.transfertCompta.setTrfRegion((String)null);
      this.transfertCompta.setTrfSecteur((String)null);
      this.transfertCompta.setTrfPdv((String)null);
      if (var1[20] != null && !var1[20].isEmpty()) {
         this.transfertCompta.setTrfBudget(var1[20]);
      } else {
         this.transfertCompta.setTrfBudget((String)null);
      }

      this.transfertCompta.setTrfTypeImport(var1[21]);
      if (this.transfertCompta.getTrfDebitSaisie() + this.transfertCompta.getTrfCreditSaisie() != 0.0D) {
         this.lesTransfertCompta.add(this.transfertCompta);
      }

   }

   public void mefEleve() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
      this.journauxComptables = new JournauxComptables();
      ArrayList var2 = new ArrayList();
      new TransfertCompta();

      int var4;
      for(var4 = 0; var4 < this.lesTransfertCompta.size(); ++var4) {
         this.transfertCompta = (TransfertCompta)this.lesTransfertCompta.get(var4);
         TransfertCompta var3 = new TransfertCompta();
         var3.setTrfActivite(this.transfertCompta.getTrfActivite());
         var3.setTrfAgent(this.transfertCompta.getTrfAgent());
         var3.setTrfBudget(this.transfertCompta.getTrfBudget());
         var3.setTrfCategorie(this.transfertCompta.getTrfCategorie());
         var3.setTrfCle1(this.transfertCompta.getTrfCle1());
         var3.setTrfCode(this.transfertCompta.getTrfCode());
         var3.setTrfCompte(this.transfertCompta.getTrfCompte());
         var3.setTrfCreditSaisie(this.transfertCompta.getTrfCreditSaisie());
         var3.setTrfDateEcheance(this.transfertCompta.getTrfDateEcheance());
         var3.setTrfDateSaisie(this.transfertCompta.getTrfDateSaisie());
         var3.setTrfDateValeurTheo(this.transfertCompta.getTrfDateValeurTheo());
         var3.setTrfDebitSaisie(0.0D);
         var3.setTrfDepartement("");
         var3.setTrfDossier("");
         var3.setTrfIdOrigine(this.transfertCompta.getTrfIdOrigine());
         var3.setTrfLibelle(this.transfertCompta.getTrfLibelle() + " " + this.transfertCompta.getTrfParc());
         var3.setTrfModeReglement(this.transfertCompta.getTrfModeReglement());
         var3.setTrfNature(this.transfertCompta.getTrfNature());
         var3.setTrfParc("");
         var3.setTrfPdv("");
         var3.setTrfPeriode(this.transfertCompta.getTrfPeriode());
         var3.setTrfPiece(this.transfertCompta.getTrfPiece());
         var3.setTrfProjet("");
         var3.setTrfReference1(this.transfertCompta.getTrfReference1());
         var3.setTrfReference2(this.transfertCompta.getTrfReference2());
         var3.setTrfRegion("");
         var3.setTrfRepartitionCle1(this.transfertCompta.getTrfRepartitionCle1());
         var3.setTrfRepartitionCle2(this.transfertCompta.getTrfRepartitionCle2());
         var3.setTrfSecteur("");
         var3.setTrfService("");
         var3.setTrfSite("");
         var3.setTrfSuite(this.transfertCompta.getTrfParc());
         var3.setTrfTreso("");
         var3.setTrfTypeImport(this.transfertCompta.getTrfTypeImport());
         var3.setTrfTypeOrigine(this.transfertCompta.getTrfTypeOrigine());
         var2.add(var3);
         String var5 = "";
         if (this.transfertCompta.getTrfTreso().equals("1")) {
            var5 = "5131100000";
         } else {
            this.journauxComptables = this.journauxComptablesDao.chercherCode(this.transfertCompta.getTrfCode(), this.exercicesComptable.getExecpt_id(), var1);
            if (this.journauxComptables != null) {
               var5 = this.journauxComptables.getPljCompteTreso();
            } else {
               var5 = "";
            }
         }

         var3 = new TransfertCompta();
         var3.setTrfActivite(this.transfertCompta.getTrfActivite());
         var3.setTrfAgent(this.transfertCompta.getTrfAgent());
         var3.setTrfBudget(this.transfertCompta.getTrfBudget());
         var3.setTrfCategorie(this.transfertCompta.getTrfCategorie());
         var3.setTrfCle1(this.transfertCompta.getTrfCle1());
         var3.setTrfCode(this.transfertCompta.getTrfCode());
         var3.setTrfCompte(var5);
         var3.setTrfCreditSaisie(0.0D);
         var3.setTrfDateEcheance(this.transfertCompta.getTrfDateEcheance());
         var3.setTrfDateSaisie(this.transfertCompta.getTrfDateSaisie());
         var3.setTrfDateValeurTheo(this.transfertCompta.getTrfDateValeurTheo());
         var3.setTrfDebitSaisie(this.transfertCompta.getTrfCreditSaisie());
         var3.setTrfDepartement(this.transfertCompta.getTrfDepartement());
         var3.setTrfDossier("");
         var3.setTrfIdOrigine(this.transfertCompta.getTrfIdOrigine());
         var3.setTrfLibelle(this.transfertCompta.getTrfLibelle());
         var3.setTrfModeReglement(this.transfertCompta.getTrfModeReglement());
         var3.setTrfNature(this.transfertCompta.getTrfNature());
         var3.setTrfParc("");
         var3.setTrfPdv("");
         var3.setTrfPeriode(this.transfertCompta.getTrfPeriode());
         var3.setTrfPiece(this.transfertCompta.getTrfPiece());
         var3.setTrfProjet("");
         var3.setTrfReference1(this.transfertCompta.getTrfReference1());
         var3.setTrfReference2(this.transfertCompta.getTrfReference2());
         var3.setTrfRegion("");
         var3.setTrfRepartitionCle1(this.transfertCompta.getTrfRepartitionCle1());
         var3.setTrfRepartitionCle2(this.transfertCompta.getTrfRepartitionCle2());
         var3.setTrfSecteur("");
         var3.setTrfService("");
         var3.setTrfSite(this.transfertCompta.getTrfSite());
         var3.setTrfSuite("");
         var3.setTrfTreso("");
         var3.setTrfTypeImport(this.transfertCompta.getTrfTypeImport());
         var3.setTrfTypeOrigine(this.transfertCompta.getTrfTypeOrigine());
         var2.add(var3);
      }

      this.utilInitHibernate.closeSession();
      this.lesTransfertCompta.clear();

      for(var4 = 0; var4 < var2.size(); ++var4) {
         this.transfertCompta = (TransfertCompta)var2.get(var4);
         this.lesTransfertCompta.add(this.transfertCompta);
      }

      var2.clear();
   }

   public void importLibre(String var1) {
      UtilExcel var2 = new UtilExcel();
      File var3 = new File(var1);
      new ArrayList();
      List var4 = var2.lectureFichierVentes(var3);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            this.transfertVentes = (TransfertVentes)var4.get(var5);
            this.transfertVentes.setTrfTypeImport(this.balance);
            this.lesTransfertVentes.add(var4.get(var5));
         }
      }

   }

   public String exportationEcritures(String var1) throws IOException, HibernateException, NamingException, FileNotFoundException, WriteException {
      this.afficheFichierExport = false;
      File var2 = null;
      String var3 = this.utilDate.dateToStringSQL(new Date());
      String[] var4 = var3.split(" ");
      String[] var5 = var4[1].split(":");
      String var6 = "";
      if (this.formatExport.equals("12")) {
         var6 = "EXPORT_" + var4[0] + "_" + var5[0] + "-" + var5[1] + "-" + var5[2] + ".XLS";
      } else {
         var6 = "EXPORT_" + var4[0] + "_" + var5[0] + "-" + var5[1] + "-" + var5[2] + ".TXT";
      }

      String var7 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "export" + File.separator;
      this.verificationRepertoireOrigine(var7);
      this.cheminExportOrigine = var7 + var6;
      var2 = new File(this.cheminExportOrigine);
      if (var2.exists()) {
         var2.delete();
         var2 = new File(this.cheminExportOrigine);
      }

      this.verificationRepertoireDestination(this.optionComptabilite.getDossierExport(), var6);
      String var8 = "";
      if (this.cheminExportOrigine != null && !this.cheminExportOrigine.isEmpty()) {
         var8 = this.formTransfertCtrl.chronoTransfert();
         if (var8 == null || var8.isEmpty()) {
            var8 = "00000";
         }

         if (this.formatExport.equals("0")) {
            this.exportTexte(var2, var8);
         } else if (!this.formatExport.equals("1")) {
            if (this.formatExport.equals("2")) {
               this.exportSageV11(var2, var8);
            } else if (this.formatExport.equals("3")) {
               this.exportSageV16(var2, var8);
            } else if (this.formatExport.equals("4")) {
               this.exportSageVI7(var2, var8);
            } else if (this.formatExport.equals("5")) {
               this.exportSageVI8(var2, var8);
            } else if (this.formatExport.equals("6")) {
               this.exportSagePNM(var2, var8);
            } else if (!this.formatExport.equals("7")) {
               if (this.formatExport.equals("8")) {
                  this.exportS2R(var2, var8);
               } else if (this.formatExport.equals("9")) {
                  this.exportGIN(var2, var8);
               } else if (!this.formatExport.equals("10")) {
                  if (this.formatExport.equals("11")) {
                     this.exportationXML(var2);
                  } else if (this.formatExport.equals("12")) {
                     this.exportationXLS(var2);
                  }
               }
            }
         }

         if (var6 != null && !var6.isEmpty()) {
            this.nomFichier = var6;
            UtilDownload var9 = new UtilDownload();
            String var10 = var1 + "epegase" + File.separator + "clients" + File.separator + this.baseLog + File.separator + "export" + File.separator + var6;
            this.fichierUrl = var9.convertirFichierUtl(var10, var1);
            this.fichierMine = var9.calculeTypeMine(this.nomFichier);
            var8 = var8 + ":" + var6;
            this.afficheFichierExport = true;
         }
      } else {
         var8 = null;
      }

      return var8;
   }

   public void verificationRepertoireOrigine(String var1) {
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdirs();
      }

   }

   public void verificationRepertoireDestination(String var1, String var2) {
      if (var1 != null && !var1.isEmpty()) {
         if (!var1.endsWith(".TXT") && !var1.endsWith(".txt")) {
            if (var1.endsWith("/")) {
               this.cheminExportDestination = var1 + var2;
            } else {
               this.cheminExportDestination = var1 + File.separator + var2;
            }
         } else {
            this.cheminExportDestination = var1;
         }
      } else {
         var1 = "C:" + File.separator + "EXPORT" + File.separator;
         this.cheminExportDestination = var1 + var2;
      }

   }

   public String longueurTexte(String var1, int var2) {
      boolean var3 = false;
      if (var2 < 0) {
         var3 = true;
         var2 *= -1;
      }

      String var4 = "";
      if (var1 != null && !var1.isEmpty() && var1.length() > var2) {
         var4 = var1.substring(0, var2);
      } else if (var1 != null && !var1.isEmpty() && var1.length() >= var2) {
         var4 = var1;
      } else {
         boolean var5 = false;
         int var7;
         if (var1 != null && !var1.isEmpty()) {
            var7 = var2 - var1.length();
         } else {
            var1 = "";
            var7 = var2;
         }

         var4 = "";

         for(int var6 = 0; var6 < var7; ++var6) {
            var4 = var4 + " ";
         }

         if (var3) {
            var4 = var4 + var1;
         } else {
            var4 = var1 + var4;
         }
      }

      return var4;
   }

   public void exportTexte(File var1, String var2) throws IOException {
      if (this.lesTransfertCompta.size() != 0) {
         new TransfertCompta();
         SimpleDateFormat var4 = new SimpleDateFormat("dd-MM-yyyy");
         List var5 = this.lesTransfertCompta;
         PrintWriter var6 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));

         for(int var7 = 0; var7 < var5.size(); ++var7) {
            TransfertCompta var3 = (TransfertCompta)var5.get(var7);
            String var8 = var3.getTrfCode();
            String var9 = "";
            if (var3.getTrfCompte() != null && !var3.getTrfCompte().isEmpty()) {
               var9 = var3.getTrfCompte();
            }

            var4.format(var3.getTrfDateSaisie());
            String var11 = "" + var4.format(var3.getTrfDateSaisie());
            String[] var12 = var11.split("-");
            String var13 = var12[0] + var12[1] + var12[2];
            String var14 = "";
            String var15 = "";
            long var16 = 0L;
            if (var3.getTrfDebitSaisie() != 0.0D && var3.getTrfCreditSaisie() == 0.0D) {
               var16 = (long)this.utilNombre.myRoundDevise(var3.getTrfDebitSaisie(), this.structureLog.getStrdevise());
               var14 = this.chiffreExport(var16);
               var15 = "";
            } else {
               var14 = "";
               var16 = (long)this.utilNombre.myRoundDevise(var3.getTrfCreditSaisie(), this.structureLog.getStrdevise());
               var15 = this.chiffreExport(var16);
            }

            String var18 = var3.getTrfLibelle();
            String var19 = var3.getTrfSuite();
            String var20 = "" + var3.getTrfModeReglement();
            String var21 = "";
            if (var3.getTrfReference1() != null && !var3.getTrfReference1().isEmpty() && var3.getTrfReference1().contains("-")) {
               String[] var22 = var3.getTrfReference1().split("-");
               var21 = var22[1];
            } else {
               var21 = var3.getTrfReference1();
            }

            String var24 = "";
            if (var3.getTrfDateEcheance() != null) {
               var4.format(var3.getTrfDateEcheance());
               var11 = "" + var4.format(var3.getTrfDateEcheance());
               String[] var23 = var11.split("-");
               var24 = var23[0] + var23[1] + var23[2];
            }

            var6.print(var8 + "|" + var9 + "|" + var2 + "|" + var13 + "|" + var14 + "|" + var15 + "|" + var18 + "|" + var19 + "|" + var19 + "|" + var20 + "|" + var21 + "|" + var24 + "|" + "\r\n");
         }

         var6.close();
      }

   }

   public void exportSageV11(File var1, String var2) throws IOException, HibernateException, NamingException {
      this.journauxComptables = null;
      this.chrono = null;
      long var3 = 0L;
      double var5 = 0.0D;
      double var7 = 0.0D;
      Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var10 = null;

      try {
         var10 = var9.beginTransaction();
         var9.setFlushMode(FlushMode.MANUAL);
         if (this.lesTransfertCompta.size() != 0) {
            new Tiers();
            new TransfertCompta();
            SimpleDateFormat var13 = new SimpleDateFormat("dd-MM-yyyy");
            List var14 = this.lesTransfertCompta;
            PrintWriter var15 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
            var15.print("#VER 4\r\n");
            String var16 = "";
            String var17 = "";
            String var18 = "";
            String var19 = "";
            String var20 = "";
            String var21 = "";
            String var22 = "";
            String var23 = "";
            String var24 = "";
            String var25 = "";
            String var26 = "";
            String var27 = "";
            String var28 = "0";
            String var29 = "";
            String var30 = "";
            String var31 = "";
            String var32 = "0";
            String var33 = "0";
            String var34 = "0";
            String var35 = "";
            String var36 = "";
            String var37 = "";
            String var38 = "0";
            String var39 = "0";
            String var40 = "0";
            int var41 = 0;
            int var42 = 0;
            String var43 = "";
            if (this.optionPaye != null) {
               var41 = Integer.parseInt(this.optionPaye.getNbcrExport());
               var42 = Integer.parseInt(this.optionPaye.getNbcrTiersExport());
               var43 = this.optionPaye.getPrefixeTiersExport();
               if (var43 == null || var43.isEmpty()) {
                  var43 = "";
               }
            }

            for(int var44 = 0; var44 < var14.size(); ++var44) {
               TransfertCompta var12 = (TransfertCompta)var14.get(var44);
               var16 = "#MECG";
               var17 = var12.getTrfCode();
               var5 += var12.getTrfDebitSaisie();
               var7 += var12.getTrfCreditSaisie();
               String var45 = "";
               if (var12.getTrfCompte() != null && !var12.getTrfCompte().isEmpty()) {
                  if (var41 != 0) {
                     var45 = var12.getTrfCompte().substring(0, var41);
                  } else {
                     var45 = var12.getTrfCompte();
                  }
               }

               if (var12.getTrfSuite() != null && !var12.getTrfSuite().isEmpty() && var12.getTrfSuite().contains(":")) {
                  String[] var46 = var12.getTrfSuite().split(":");
                  int var47 = var46[0].length();
                  var23 = var43 + var46[0].substring(var47 - var42, var47);
                  var25 = var46[1];
               } else {
                  var23 = var45;
                  var25 = "";
               }

               var13.format(var12.getTrfDateSaisie());
               String var61 = "" + var13.format(var12.getTrfDateSaisie());
               String[] var48 = var61.split("-");
               var18 = var48[0] + var48[1] + (Integer.parseInt(var48[2]) - 2000);
               var19 = "";
               String var49 = "";
               String var50 = "";
               long var51;
               if (var12.getTrfDebitSaisie() != 0.0D && var12.getTrfCreditSaisie() == 0.0D) {
                  var51 = 0L;
                  var51 = (long)this.utilNombre.myRoundDevise(var12.getTrfDebitSaisie(), this.structureLog.getStrdevise());
                  var49 = this.chiffreExport(var51);
                  var50 = "";
                  var33 = "0";
                  var34 = var49;
               } else {
                  var49 = "";
                  var51 = 0L;
                  var51 = (long)this.utilNombre.myRoundDevise(var12.getTrfCreditSaisie(), this.structureLog.getStrdevise());
                  var50 = this.chiffreExport(var51);
                  var33 = "1";
                  var34 = var50;
               }

               String var62 = var12.getTrfLibelle();
               String var52 = var12.getTrfSuite();
               var27 = var62;
               if (var52 != null && !var52.isEmpty()) {
                  var27 = var62 + " " + var52;
               }

               if (var27.length() >= 34) {
                  var27 = var27.substring(0, 34);
               }

               (new StringBuilder()).append("").append(var12.getTrfModeReglement()).toString();
               String[] var54;
               if (var12.getTrfReference1() != null && !var12.getTrfReference1().isEmpty() && var12.getTrfReference1().contains("-")) {
                  var54 = var12.getTrfReference1().split("-");
                  var21 = var54[1];
               } else {
                  var21 = var12.getTrfReference1();
               }

               this.journauxComptables = this.journauxComptablesDao.chercherCode(var17, this.exercicesComptable.getExecpt_id(), var9);
               String var63;
               if (this.journauxComptables != null && this.journauxComptables.getPljNature() == 1) {
                  var63 = "" + (var12.getTrfDateSaisie().getYear() + 1900);
                  if (this.chrono == null) {
                     this.chrono = this.chronoDao.chronoByNatAndJournalPeriode(53, var17, var63, var9);
                     if (this.chrono == null) {
                        break;
                     }

                     var3 = this.chrono.getChrNumAn();
                  }

                  var20 = "" + var3;
                  if (var5 == var7) {
                     ++var3;
                     var5 = 0.0D;
                     var7 = 0.0D;
                  }
               } else {
                  var63 = "";
                  String[] var55;
                  if (var21.contains(":")) {
                     var55 = var21.split(":");
                     var63 = var55[1];
                  } else {
                     var63 = var21;
                  }

                  if (var63.contains("/")) {
                     var55 = var63.split("/");
                     var20 = var55[0];
                  } else {
                     var20 = var63;
                  }
               }

               var21 = "";
               if (var12.getTrfDateEcheance() != null) {
                  var13.format(var12.getTrfDateEcheance());
                  var61 = "" + var13.format(var12.getTrfDateEcheance());
                  var54 = var61.split("-");
                  var29 = var54[0] + var54[1] + (Integer.parseInt(var48[2]) - 2000);
               } else {
                  var29 = "";
               }

               var15.print(var16 + "\r\n");
               var15.print(var17 + "\r\n");
               var15.print(var18 + "\r\n");
               var15.print(var19 + "\r\n");
               var15.print(var20 + "\r\n");
               var15.print(var21 + "\r\n");
               var15.print(var22 + "\r\n");
               var15.print(var23 + "\r\n");
               var15.print(var24 + "\r\n");
               var15.print(var25 + "\r\n");
               var15.print(var26 + "\r\n");
               var15.print(var27 + "\r\n");
               var15.print(var28 + "\r\n");
               var15.print(var29 + "\r\n");
               var15.print(var30 + "\r\n");
               var15.print(var31 + "\r\n");
               var15.print(var32 + "\r\n");
               var15.print(var33 + "\r\n");
               var15.print(var34 + "\r\n");
               var15.print(var35 + "\r\n");
               var15.print(var36 + "\r\n");
               var15.print(var37 + "\r\n");
               var15.print(var38 + "\r\n");
               var15.print(var39 + "\r\n");
               var15.print(var40 + "\r\n");
            }

            var15.print("#FIN\r\n");
            var15.close();
         }

         if (this.chrono != null) {
            this.chrono.setChrNumAn(var3);
            this.chrono = this.chronoDao.modifierChrono(this.chrono, var9);
            var9.flush();
         }

         var10.commit();
      } catch (HibernateException var59) {
         if (var10 != null) {
            var10.rollback();
         }

         throw var59;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void exportSageV16(File var1, String var2) throws IOException, HibernateException, NamingException {
      this.journauxComptables = null;
      this.chrono = null;
      long var3 = 0L;
      double var5 = 0.0D;
      double var7 = 0.0D;
      Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var10 = null;

      try {
         var10 = var9.beginTransaction();
         var9.setFlushMode(FlushMode.MANUAL);
         if (this.lesTransfertCompta.size() != 0) {
            new Tiers();
            new TransfertCompta();
            SimpleDateFormat var13 = new SimpleDateFormat("dd-MM-yyyy");
            List var14 = this.lesTransfertCompta;
            PrintWriter var15 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
            var15.print("#FLG 000\r\n");
            var15.print("#VER 5\r\n");
            var15.print("#DEV " + this.structureLog.getStrdevise() + "\r\n");
            String var16 = "";
            String var17 = "";
            String var18 = "";
            String var19 = "";
            String var20 = "";
            String var21 = "";
            String var22 = "";
            String var23 = "";
            String var24 = "";
            String var25 = "";
            String var26 = "";
            String var27 = "";
            String var28 = "0";
            String var29 = "";
            String var30 = "0";
            String var31 = "0";
            String var32 = "0";
            String var33 = "";
            String var34 = "";
            String var35 = "";
            String var36 = "";
            String var37 = "";
            String var38 = "0";
            String var39 = "0";
            String var40 = "0";
            String var41 = "";
            String var42 = "";
            int var43 = 0;
            int var44 = 0;
            String var45 = "";
            if (this.optionPaye != null) {
               var43 = Integer.parseInt(this.optionPaye.getNbcrExport());
               var44 = Integer.parseInt(this.optionPaye.getNbcrTiersExport());
               var45 = this.optionPaye.getPrefixeTiersExport();
               if (var45 == null || var45.isEmpty()) {
                  var45 = "";
               }
            }

            for(int var46 = 0; var46 < var14.size(); ++var46) {
               TransfertCompta var12 = (TransfertCompta)var14.get(var46);
               var16 = "#MECG";
               var17 = var12.getTrfCode();
               var5 += var12.getTrfDebitSaisie();
               var7 += var12.getTrfCreditSaisie();
               String var47 = "";
               if (var12.getTrfCompte() != null && !var12.getTrfCompte().isEmpty()) {
                  if (var43 != 0) {
                     var47 = var12.getTrfCompte().substring(0, var43);
                  } else {
                     var47 = var12.getTrfCompte();
                  }
               }

               if (var12.getTrfSuite() != null && !var12.getTrfSuite().isEmpty() && var12.getTrfSuite().contains(":")) {
                  String[] var48 = var12.getTrfSuite().split(":");
                  int var49 = var48[0].length();
                  var23 = var45 + var48[0].substring(var49 - var44, var49);
                  var25 = var48[1];
               } else {
                  var23 = var47;
                  var25 = "";
               }

               var13.format(var12.getTrfDateSaisie());
               String var63 = "" + var13.format(var12.getTrfDateSaisie());
               String[] var50 = var63.split("-");
               var18 = var50[0] + var50[1] + (Integer.parseInt(var50[2]) - 2000);
               String var51 = "";
               String var52 = "";
               long var53;
               if (var12.getTrfDebitSaisie() != 0.0D && var12.getTrfCreditSaisie() == 0.0D) {
                  var53 = 0L;
                  var53 = (long)this.utilNombre.myRoundDevise(var12.getTrfDebitSaisie(), this.structureLog.getStrdevise());
                  var51 = this.chiffreExport(var53);
                  var52 = "";
                  var33 = "0";
                  var34 = var51;
               } else {
                  var51 = "";
                  var53 = 0L;
                  var53 = (long)this.utilNombre.myRoundDevise(var12.getTrfCreditSaisie(), this.structureLog.getStrdevise());
                  var52 = this.chiffreExport(var53);
                  var33 = "1";
                  var34 = var52;
               }

               String var64 = var12.getTrfLibelle();
               String var54 = var12.getTrfSuite();
               var27 = var64;
               if (var54 != null && !var54.isEmpty()) {
                  var27 = var64 + " " + var54;
               }

               if (var27.length() >= 34) {
                  var27 = var27.substring(0, 34);
               }

               (new StringBuilder()).append("").append(var12.getTrfModeReglement()).toString();
               String[] var56;
               if (var12.getTrfReference1() != null && !var12.getTrfReference1().isEmpty() && var12.getTrfReference1().contains("-")) {
                  var56 = var12.getTrfReference1().split("-");
                  var21 = var56[1];
               } else {
                  var21 = var12.getTrfReference1();
               }

               this.journauxComptables = this.journauxComptablesDao.chercherCode(var17, this.exercicesComptable.getExecpt_id(), var9);
               String var65;
               if (this.journauxComptables != null && this.journauxComptables.getPljNature() == 1) {
                  var65 = "" + (var12.getTrfDateSaisie().getYear() + 1900);
                  if (this.chrono == null) {
                     this.chrono = this.chronoDao.chronoByNatAndJournalPeriode(53, var17, var65, var9);
                     if (this.chrono == null) {
                        break;
                     }

                     var3 = this.chrono.getChrNumAn();
                  }

                  var20 = "" + var3;
                  if (var5 == var7) {
                     ++var3;
                     var5 = 0.0D;
                     var7 = 0.0D;
                  }
               } else {
                  var65 = "";
                  String[] var57;
                  if (var21.contains(":")) {
                     var57 = var21.split(":");
                     var65 = var57[1];
                  } else {
                     var65 = var21;
                  }

                  if (var65.contains("/")) {
                     var57 = var65.split("/");
                     var20 = var57[0];
                  } else {
                     var20 = var65;
                  }
               }

               if (var12.getTrfDateEcheance() != null) {
                  var13.format(var12.getTrfDateEcheance());
                  var63 = "" + var13.format(var12.getTrfDateEcheance());
                  var56 = var63.split("-");
                  var29 = var56[0] + var56[1] + (Integer.parseInt(var50[2]) - 2000);
               } else {
                  var29 = "";
               }

               var15.print(var16 + "\r\n");
               var15.print(var17 + "\r\n");
               var15.print(var18 + "\r\n");
               var15.print(var19 + "\r\n");
               var15.print(var20 + "\r\n");
               var15.print(var21 + "\r\n");
               var15.print(var22 + "\r\n");
               var15.print(var23 + "\r\n");
               var15.print(var24 + "\r\n");
               var15.print(var25 + "\r\n");
               var15.print(var26 + "\r\n");
               var15.print(var27 + "\r\n");
               var15.print(var28 + "\r\n");
               var15.print(var29 + "\r\n");
               var15.print(var30 + "\r\n");
               var15.print(var31 + "\r\n");
               var15.print(var32 + "\r\n");
               var15.print(var33 + "\r\n");
               var15.print(var34 + "\r\n");
               var15.print(var35 + "\r\n");
               var15.print(var36 + "\r\n");
               var15.print(var37 + "\r\n");
               var15.print(var38 + "\r\n");
               var15.print(var39 + "\r\n");
               var15.print(var40 + "\r\n");
               var15.print(var41 + "\r\n");
               var15.print(var42 + "\r\n");
            }

            var15.print("#FIN\r\n");
            var15.close();
         }

         if (this.chrono != null) {
            this.chrono.setChrNumAn(var3);
            this.chrono = this.chronoDao.modifierChrono(this.chrono, var9);
            var9.flush();
         }

         var10.commit();
      } catch (HibernateException var61) {
         if (var10 != null) {
            var10.rollback();
         }

         throw var61;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void exportSageVI7(File var1, String var2) throws IOException, HibernateException, NamingException {
      this.journauxComptables = null;
      this.chrono = null;
      long var3 = 0L;
      double var5 = 0.0D;
      double var7 = 0.0D;
      Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var10 = null;

      try {
         var10 = var9.beginTransaction();
         var9.setFlushMode(FlushMode.MANUAL);
         if (this.lesTransfertCompta.size() != 0) {
            new Tiers();
            new TransfertCompta();
            SimpleDateFormat var13 = new SimpleDateFormat("dd-MM-yyyy");
            List var14 = this.lesTransfertCompta;
            PrintWriter var15 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
            var15.print("#FLG 000\r\n");
            var15.print("#VER 17\r\n");
            var15.print("#DEV " + this.structureLog.getStrdevise() + "\r\n");
            String var16 = "";
            String var17 = "";
            String var18 = "";
            String var19 = "";
            String var20 = "";
            String var21 = "";
            String var22 = "";
            String var23 = "";
            String var24 = "";
            String var25 = "";
            String var26 = "";
            String var27 = "";
            String var28 = "0";
            String var29 = "";
            String var30 = "0";
            String var31 = "0";
            String var32 = "0";
            String var33 = "";
            String var34 = "";
            String var35 = "";
            String var36 = "";
            String var37 = "";
            String var38 = "0";
            String var39 = "0";
            String var40 = "0";
            String var41 = "";
            String var42 = "";
            int var43 = 0;
            int var44 = 0;
            String var45 = "";
            if (this.optionPaye != null) {
               var43 = Integer.parseInt(this.optionPaye.getNbcrExport());
               var44 = Integer.parseInt(this.optionPaye.getNbcrTiersExport());
               var45 = this.optionPaye.getPrefixeTiersExport();
               if (var45 == null || var45.isEmpty()) {
                  var45 = "";
               }
            }

            for(int var46 = 0; var46 < var14.size(); ++var46) {
               TransfertCompta var12 = (TransfertCompta)var14.get(var46);
               var16 = "#MECG";
               var17 = var12.getTrfCode();
               var5 += var12.getTrfDebitSaisie();
               var7 += var12.getTrfCreditSaisie();
               String var47 = "";
               if (var12.getTrfCompte() != null && !var12.getTrfCompte().isEmpty()) {
                  if (var43 != 0) {
                     var47 = var12.getTrfCompte().substring(0, var43);
                  } else {
                     var47 = var12.getTrfCompte();
                  }
               }

               if (var12.getTrfSuite() != null && !var12.getTrfSuite().isEmpty() && var12.getTrfSuite().contains(":")) {
                  String[] var48 = var12.getTrfSuite().split(":");
                  int var49 = var48[0].length();
                  var23 = var45 + var48[0].substring(var49 - var44, var49);
                  var25 = var48[1];
               } else {
                  var23 = var47;
                  var25 = "";
               }

               var13.format(var12.getTrfDateSaisie());
               String var63 = "" + var13.format(var12.getTrfDateSaisie());
               String[] var50 = var63.split("-");
               var18 = var50[0] + var50[1] + (Integer.parseInt(var50[2]) - 2000);
               String var51 = "";
               String var52 = "";
               long var53;
               if (var12.getTrfDebitSaisie() != 0.0D && var12.getTrfCreditSaisie() == 0.0D) {
                  var53 = 0L;
                  var53 = (long)this.utilNombre.myRoundDevise(var12.getTrfDebitSaisie(), this.structureLog.getStrdevise());
                  var51 = this.chiffreExport(var53);
                  var52 = "";
                  var33 = "0";
                  var34 = var51;
               } else {
                  var51 = "";
                  var53 = 0L;
                  var53 = (long)this.utilNombre.myRoundDevise(var12.getTrfCreditSaisie(), this.structureLog.getStrdevise());
                  var52 = this.chiffreExport(var53);
                  var33 = "1";
                  var34 = var52;
               }

               String var64 = var12.getTrfLibelle();
               String var54 = var12.getTrfSuite();
               var27 = var64;
               if (var54 != null && !var54.isEmpty()) {
                  var27 = var64 + " " + var54;
               }

               if (var27.length() >= 34) {
                  var27 = var27.substring(0, 34);
               }

               (new StringBuilder()).append("").append(var12.getTrfModeReglement()).toString();
               String[] var56;
               if (var12.getTrfReference1() != null && !var12.getTrfReference1().isEmpty() && var12.getTrfReference1().contains("-")) {
                  var56 = var12.getTrfReference1().split("-");
                  var21 = var56[1];
               } else {
                  var21 = var12.getTrfReference1();
               }

               this.journauxComptables = this.journauxComptablesDao.chercherCode(var17, this.exercicesComptable.getExecpt_id(), var9);
               String var65;
               if (this.journauxComptables != null && this.journauxComptables.getPljNature() == 1) {
                  var65 = "" + (var12.getTrfDateSaisie().getYear() + 1900);
                  if (this.chrono == null) {
                     this.chrono = this.chronoDao.chronoByNatAndJournalPeriode(53, var17, var65, var9);
                     if (this.chrono == null) {
                        break;
                     }

                     var3 = this.chrono.getChrNumAn();
                  }

                  var20 = "" + var3;
                  if (var5 == var7) {
                     ++var3;
                     var5 = 0.0D;
                     var7 = 0.0D;
                  }
               } else {
                  var65 = "";
                  String[] var57;
                  if (var21.contains(":")) {
                     var57 = var21.split(":");
                     var65 = var57[1];
                  } else {
                     var65 = var21;
                  }

                  if (var65.contains("/")) {
                     var57 = var65.split("/");
                     var20 = var57[0];
                  } else {
                     var20 = var65;
                  }
               }

               if (var12.getTrfDateEcheance() != null) {
                  var13.format(var12.getTrfDateEcheance());
                  var63 = "" + var13.format(var12.getTrfDateEcheance());
                  var56 = var63.split("-");
                  var29 = var56[0] + var56[1] + (Integer.parseInt(var50[2]) - 2000);
               } else {
                  var29 = "";
               }

               var15.print(var16 + "\r\n");
               var15.print(var17 + "\r\n");
               var15.print(var18 + "\r\n");
               var15.print(var19 + "\r\n");
               var15.print(var20 + "\r\n");
               var15.print(var21 + "\r\n");
               var15.print(var22 + "\r\n");
               var15.print(var23 + "\r\n");
               var15.print(var24 + "\r\n");
               var15.print(var25 + "\r\n");
               var15.print(var26 + "\r\n");
               var15.print(var27 + "\r\n");
               var15.print(var28 + "\r\n");
               var15.print(var29 + "\r\n");
               var15.print(var30 + "\r\n");
               var15.print(var31 + "\r\n");
               var15.print(var32 + "\r\n");
               var15.print(var33 + "\r\n");
               var15.print(var34 + "\r\n");
               var15.print(var35 + "\r\n");
               var15.print(var36 + "\r\n");
               var15.print(var37 + "\r\n");
               var15.print(var38 + "\r\n");
               var15.print(var39 + "\r\n");
               var15.print(var40 + "\r\n");
               var15.print(var41 + "\r\n");
               var15.print(var42 + "\r\n");
            }

            var15.print("#FIN\r\n");
            var15.close();
         }

         if (this.chrono != null) {
            this.chrono.setChrNumAn(var3);
            this.chrono = this.chronoDao.modifierChrono(this.chrono, var9);
            var9.flush();
         }

         var10.commit();
      } catch (HibernateException var61) {
         if (var10 != null) {
            var10.rollback();
         }

         throw var61;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void exportSageVI8(File var1, String var2) throws IOException, HibernateException, NamingException {
      this.journauxComptables = null;
      this.chrono = null;
      long var3 = 0L;
      double var5 = 0.0D;
      double var7 = 0.0D;
      Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var10 = null;

      try {
         var10 = var9.beginTransaction();
         var9.setFlushMode(FlushMode.MANUAL);
         if (this.lesTransfertCompta.size() != 0) {
            new Tiers();
            new TransfertCompta();
            SimpleDateFormat var13 = new SimpleDateFormat("dd-MM-yyyy");
            List var14 = this.lesTransfertCompta;
            PrintWriter var15 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
            var15.print("#FLG 000\r\n");
            var15.print("#VER 18\r\n");
            var15.print("#DEV " + this.structureLog.getStrdevise() + "\r\n");
            String var16 = "";
            String var17 = "";
            String var18 = "";
            String var19 = "";
            String var20 = "";
            String var21 = "";
            String var22 = "";
            String var23 = "";
            String var24 = "";
            String var25 = "";
            String var26 = "";
            String var27 = "";
            String var28 = "0";
            String var29 = "";
            String var30 = "";
            String var31 = "0";
            String var32 = "0";
            String var33 = "";
            String var34 = "";
            String var35 = "";
            String var36 = "";
            String var37 = "";
            String var38 = "0";
            String var39 = "0";
            String var40 = "0";
            String var41 = "";
            String var42 = "";
            String var43 = "0";
            String var44 = "0";
            String var45 = "0";
            String var46 = "";
            String var47 = "";
            String var48 = "";
            String var49 = "";
            String var50 = "0";
            String var51 = "";
            String var52 = "";
            String var53 = "";
            String var54 = "0";
            String var55 = "";
            int var56 = 0;
            int var57 = 0;
            String var58 = "";
            if (this.optionPaye != null) {
               var56 = Integer.parseInt(this.optionPaye.getNbcrExport());
               var57 = Integer.parseInt(this.optionPaye.getNbcrTiersExport());
               var58 = this.optionPaye.getPrefixeTiersExport();
               if (var58 == null || var58.isEmpty()) {
                  var58 = "";
               }
            }

            for(int var59 = 0; var59 < var14.size(); ++var59) {
               TransfertCompta var12 = (TransfertCompta)var14.get(var59);
               var16 = "#MECG";
               var17 = var12.getTrfCode();
               var5 += var12.getTrfDebitSaisie();
               var7 += var12.getTrfCreditSaisie();
               String var60 = "";
               if (var12.getTrfCompte() != null && !var12.getTrfCompte().isEmpty()) {
                  if (var56 != 0) {
                     var60 = var12.getTrfCompte().substring(0, var56);
                  } else {
                     var60 = var12.getTrfCompte();
                  }
               }

               if (var12.getTrfSuite() != null && !var12.getTrfSuite().isEmpty() && var12.getTrfSuite().contains(":")) {
                  String[] var61 = var12.getTrfSuite().split(":");
                  int var62 = var61[0].length();
                  var23 = var58 + var61[0].substring(var62 - var57, var62);
                  var25 = var61[1];
               } else {
                  var23 = var60;
                  var25 = "";
               }

               var13.format(var12.getTrfDateSaisie());
               String var76 = "" + var13.format(var12.getTrfDateSaisie());
               String[] var63 = var76.split("-");
               var18 = var63[0] + var63[1] + (Integer.parseInt(var63[2]) - 2000);
               String var64 = "";
               String var65 = "";
               long var66;
               if (var12.getTrfDebitSaisie() != 0.0D && var12.getTrfCreditSaisie() == 0.0D) {
                  var66 = 0L;
                  var66 = (long)this.utilNombre.myRoundDevise(var12.getTrfDebitSaisie(), this.structureLog.getStrdevise());
                  var64 = this.chiffreExport(var66);
                  var65 = "";
                  var33 = "0";
                  var34 = var64;
               } else {
                  var64 = "";
                  var66 = 0L;
                  var66 = (long)this.utilNombre.myRoundDevise(var12.getTrfCreditSaisie(), this.structureLog.getStrdevise());
                  var65 = this.chiffreExport(var66);
                  var33 = "1";
                  var34 = var65;
               }

               String var77 = var12.getTrfLibelle();
               String var67 = var12.getTrfSuite();
               var27 = var77;
               if (var67 != null && !var67.isEmpty()) {
                  var27 = var77 + " " + var67;
               }

               if (var27.length() >= 34) {
                  var27 = var27.substring(0, 34);
               }

               (new StringBuilder()).append("").append(var12.getTrfModeReglement()).toString();
               String[] var69;
               if (var12.getTrfReference1() != null && !var12.getTrfReference1().isEmpty() && var12.getTrfReference1().contains("-")) {
                  var69 = var12.getTrfReference1().split("-");
                  var21 = var69[1];
               } else {
                  var21 = var12.getTrfReference1();
               }

               this.journauxComptables = this.journauxComptablesDao.chercherCode(var17, this.exercicesComptable.getExecpt_id(), var9);
               String var78;
               if (this.journauxComptables != null && this.journauxComptables.getPljNature() == 1) {
                  var78 = "" + (var12.getTrfDateSaisie().getYear() + 1900);
                  if (this.chrono == null) {
                     this.chrono = this.chronoDao.chronoByNatAndJournalPeriode(53, var17, var78, var9);
                     if (this.chrono == null) {
                        break;
                     }

                     var3 = this.chrono.getChrNumAn();
                  }

                  var20 = "" + var3;
                  if (var5 == var7) {
                     ++var3;
                     var5 = 0.0D;
                     var7 = 0.0D;
                  }
               } else {
                  var78 = "";
                  String[] var70;
                  if (var21.contains(":")) {
                     var70 = var21.split(":");
                     var78 = var70[1];
                  } else {
                     var78 = var21;
                  }

                  if (var78.contains("/")) {
                     var70 = var78.split("/");
                     var20 = var70[0];
                  } else {
                     var20 = var78;
                  }
               }

               if (var12.getTrfDateEcheance() != null) {
                  var13.format(var12.getTrfDateEcheance());
                  var76 = "" + var13.format(var12.getTrfDateEcheance());
                  var69 = var76.split("-");
                  var29 = var69[0] + var69[1] + (Integer.parseInt(var63[2]) - 2000);
               } else {
                  var29 = "";
               }

               var15.print(var16 + "\r\n");
               var15.print(var17 + "\r\n");
               var15.print(var18 + "\r\n");
               var15.print(var19 + "\r\n");
               var15.print(var20 + "\r\n");
               var15.print(var21 + "\r\n");
               var15.print(var22 + "\r\n");
               var15.print(var23 + "\r\n");
               var15.print(var24 + "\r\n");
               var15.print(var25 + "\r\n");
               var15.print(var26 + "\r\n");
               var15.print(var27 + "\r\n");
               var15.print(var28 + "\r\n");
               var15.print(var29 + "\r\n");
               var15.print(var30 + "\r\n");
               var15.print(var31 + "\r\n");
               var15.print(var32 + "\r\n");
               var15.print(var33 + "\r\n");
               var15.print(var34 + "\r\n");
               var15.print(var35 + "\r\n");
               var15.print(var36 + "\r\n");
               var15.print(var37 + "\r\n");
               var15.print(var38 + "\r\n");
               var15.print(var39 + "\r\n");
               var15.print(var40 + "\r\n");
               var15.print(var41 + "\r\n");
               var15.print(var42 + "\r\n");
               var15.print(var43 + "\r\n");
               var15.print(var44 + "\r\n");
               var15.print(var45 + "\r\n");
               var15.print(var46 + "\r\n");
               var15.print(var47 + "\r\n");
               var15.print(var48 + "\r\n");
               var15.print(var49 + "\r\n");
               var15.print(var50 + "\r\n");
               var15.print(var51 + "\r\n");
               var15.print(var52 + "\r\n");
               var15.print(var53 + "\r\n");
               var15.print(var54 + "\r\n");
               var15.print(var55 + "\r\n");
            }

            var15.print("#FIN\r\n");
            var15.close();
         }

         if (this.chrono != null) {
            this.chrono.setChrNumAn(var3);
            this.chrono = this.chronoDao.modifierChrono(this.chrono, var9);
            var9.flush();
         }

         var10.commit();
      } catch (HibernateException var74) {
         if (var10 != null) {
            var10.rollback();
         }

         throw var74;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void exportSagePNM(File var1, String var2) throws IOException, HibernateException, NamingException {
      this.journauxComptables = null;
      this.chrono = null;
      long var3 = 0L;
      double var5 = 0.0D;
      double var7 = 0.0D;
      Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var10 = null;

      try {
         var10 = var9.beginTransaction();
         var9.setFlushMode(FlushMode.MANUAL);
         if (this.lesTransfertCompta.size() != 0) {
            new Tiers();
            new TransfertCompta();
            SimpleDateFormat var13 = new SimpleDateFormat("dd-MM-yyyy");
            List var14 = this.lesTransfertCompta;
            String var15 = "";
            String var16 = "";
            String var17 = "";
            String var18 = "";
            String var19 = "";
            String var20 = "";
            String var21 = "";
            String var22 = "";
            String var23 = "";
            String var24 = "";
            String var25 = "";
            String var26 = "";
            String var27 = "";
            String var28 = "";
            String var29 = "";
            String var30 = "";
            PrintWriter var31 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));

            for(int var32 = 0; var32 < var14.size(); ++var32) {
               TransfertCompta var12 = (TransfertCompta)var14.get(var32);
               var15 = this.longueurTexte(var12.getTrfCode(), 3);
               var13.format(var12.getTrfDateSaisie());
               String var33 = "" + var13.format(var12.getTrfDateSaisie());
               String[] var34 = var33.split("-");
               var16 = var34[0] + var34[1] + (Integer.parseInt(var34[2]) - 2000);
               var17 = "OD";
               String[] var35;
               if (var12.getTrfSuite() != null && !var12.getTrfSuite().isEmpty() && var12.getTrfSuite().contains(":")) {
                  var35 = var12.getTrfSuite().split(":");
                  var18 = this.longueurTexte(var12.getTrfCompte().substring(0, 4), 13);
                  var19 = "X";
                  var20 = this.longueurTexte(var35[0], 13);
               } else {
                  var18 = this.longueurTexte(var12.getTrfCompte(), 13);
                  var19 = " ";
                  var20 = "             ";
               }

               if (var12.getTrfReference1() != null && !var12.getTrfReference1().isEmpty() && var12.getTrfReference1().contains("-")) {
                  var35 = var12.getTrfReference1().split("-");
                  var21 = this.longueurTexte(var35[1], 13);
               } else {
                  var21 = this.longueurTexte(var12.getTrfReference1(), 13);
               }

               String var47 = var12.getTrfLibelle();
               String var36 = var12.getTrfSuite();
               var22 = var47;
               if (var36 != null && !var36.isEmpty()) {
                  var22 = var47 + " " + var36;
               }

               var22 = this.longueurTexte(var22, 25);
               var23 = "S";
               if (var12.getTrfDateEcheance() != null) {
                  var13.format(var12.getTrfDateEcheance());
                  var33 = "" + var13.format(var12.getTrfDateEcheance());
                  String[] var37 = var33.split("-");
                  var24 = var37[0] + var37[1] + (Integer.parseInt(var34[2]) - 2000);
               } else {
                  var24 = "      ";
               }

               var5 += var12.getTrfDebitSaisie();
               var7 += var12.getTrfCreditSaisie();
               String var38 = "";
               String var39 = "";
               long var40;
               if (var12.getTrfDebitSaisie() != 0.0D && var12.getTrfCreditSaisie() == 0.0D) {
                  var40 = 0L;
                  var40 = (long)this.utilNombre.myRoundDevise(var12.getTrfDebitSaisie(), this.structureLog.getStrdevise());
                  var38 = this.chiffreExport(var40);
                  var39 = "";
                  var25 = "D";
                  var26 = var38;
               } else {
                  var38 = "";
                  var40 = 0L;
                  var40 = (long)this.utilNombre.myRoundDevise(var12.getTrfCreditSaisie(), this.structureLog.getStrdevise());
                  var39 = this.chiffreExport(var40);
                  var25 = "C";
                  var26 = var39;
               }

               var26 = this.longueurTexte(var26, -20);
               var27 = "N";
               this.journauxComptables = this.journauxComptablesDao.chercherCode(var15, this.exercicesComptable.getExecpt_id(), var9);
               String var48;
               if (this.journauxComptables != null && this.journauxComptables.getPljNature() == 1) {
                  var48 = "" + (var12.getTrfDateSaisie().getYear() + 1900);
                  if (this.chrono == null) {
                     this.chrono = this.chronoDao.chronoByNatAndJournalPeriode(53, var15, var48, var9);
                     if (this.chrono == null) {
                        break;
                     }

                     var3 = this.chrono.getChrNumAn();
                  }

                  var28 = "" + var3;
                  if (var5 == var7) {
                     ++var3;
                     var5 = 0.0D;
                     var7 = 0.0D;
                  }
               } else {
                  var48 = "";
                  String[] var41;
                  if (var28 != null && !var28.isEmpty() && var28.contains(":")) {
                     var41 = var21.split(":");
                     var48 = var41[1];
                  } else {
                     var48 = var28;
                  }

                  if (var48.contains("/")) {
                     var41 = var48.split("/");
                     var28 = var41[0];
                  } else {
                     var28 = var48;
                  }
               }

               var28 = this.longueurTexte(var28, -7);
               var29 = "                          ";
               var30 = this.structureLog.getStrdevise();
               var31.print(var15 + var16 + var17 + var18 + var19 + var20 + var21 + var22 + var23 + var24 + var25 + var26 + var27 + var28 + var29 + var30 + "\r\n");
            }

            var31.print("\r\n");
            var31.close();
         }

         if (this.chrono != null) {
            this.chrono.setChrNumAn(var3);
            this.chrono = this.chronoDao.modifierChrono(this.chrono, var9);
            var9.flush();
         }

         var10.commit();
      } catch (HibernateException var45) {
         if (var10 != null) {
            var10.rollback();
         }

         throw var45;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void exportS2R(File var1, String var2) throws IOException {
      if (this.lesTransfertCompta.size() != 0) {
         UtilTrie var3 = new UtilTrie();
         this.lesTransfertCompta = var3.triListeTrfCompta(this.lesTransfertCompta);
         this.lesTransfertCompta = var3.triListeTrfCompta(this.lesTransfertCompta);
         this.lesTransfertCompta = var3.triListeTrfCompta(this.lesTransfertCompta);
         this.lesTransfertCompta = var3.triListeTrfCompta(this.lesTransfertCompta);
         new TransfertCompta();
         new TransfertCompta();
         PrintWriter var6 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
         SimpleDateFormat var7 = new SimpleDateFormat("dd-MM-yy");
         ArrayList var8 = new ArrayList();

         TransfertCompta var4;
         int var9;
         String var14;
         for(var9 = 0; var9 < this.lesTransfertCompta.size(); ++var9) {
            var4 = (TransfertCompta)this.lesTransfertCompta.get(var9);
            if (var4.getTrfCompte() != null && !var4.getTrfCompte().isEmpty() && var4.getTrfActivite() != null && !var4.getTrfActivite().isEmpty()) {
               double var10 = 0.0D;
               double var12 = 0.0D;
               var14 = "";

               for(int var15 = 0; var15 < this.lesTransfertCompta.size(); ++var15) {
                  TransfertCompta var5 = (TransfertCompta)this.lesTransfertCompta.get(var15);
                  if (((TransfertCompta)this.lesTransfertCompta.get(var15)).getTrfCompte().equals(var4.getTrfCompte()) && ((TransfertCompta)this.lesTransfertCompta.get(var15)).getTrfActivite() != null && !((TransfertCompta)this.lesTransfertCompta.get(var15)).getTrfActivite().isEmpty()) {
                     var10 += this.utilNombre.myRoundDevise(((TransfertCompta)this.lesTransfertCompta.get(var15)).getTrfDebitSaisie(), this.structureLog.getStrdevise());
                     var12 += this.utilNombre.myRoundDevise(((TransfertCompta)this.lesTransfertCompta.get(var15)).getTrfCreditSaisie(), this.structureLog.getStrdevise());
                     double var16 = this.utilNombre.myRoundDevise(((TransfertCompta)this.lesTransfertCompta.get(var15)).getTrfDebitSaisie(), this.structureLog.getStrdevise()) + this.utilNombre.myRoundDevise(((TransfertCompta)this.lesTransfertCompta.get(var15)).getTrfCreditSaisie(), this.structureLog.getStrdevise());
                     if (var14 != null && !var14.isEmpty()) {
                        var14 = var14 + "#" + ((TransfertCompta)this.lesTransfertCompta.get(var15)).getTrfActivite() + ":" + var16;
                     } else {
                        var14 = ((TransfertCompta)this.lesTransfertCompta.get(var15)).getTrfActivite() + ":" + var16;
                     }

                     if (var5 != var4) {
                        this.lesTransfertCompta.remove(var5);
                        --var15;
                     }
                  }
               }

               var4.setTrfDebitSaisie(var10);
               var4.setTrfCreditSaisie(var12);
               var4.setTrfActivite(var14);
               var8.add(var4);
            } else {
               var8.add(var4);
            }
         }

         if (var8.size() != 0) {
            this.lesTransfertCompta.clear();

            for(var9 = 0; var9 < var8.size(); ++var9) {
               this.lesTransfertCompta.add(var8.get(var9));
            }
         }

         for(var9 = 0; var9 < this.lesTransfertCompta.size(); ++var9) {
            var4 = (TransfertCompta)this.lesTransfertCompta.get(var9);
            if (var4.getTrfCode().startsWith("0")) {
               var4.setTrfCode(var4.getTrfCode().substring(1, var4.getTrfCode().length()));
            }

            String var32 = var4.getTrfCode();
            String var11 = "";
            if (var4.getTrfCompte() != null && !var4.getTrfCompte().isEmpty()) {
               var11 = var4.getTrfCompte();
            } else if (var4.getTrfCategorie() == 20) {
               var11 = "41119999";
            } else {
               var11 = "47119999";
            }

            String var33 = this.longueurTexte(var11, 8);
            this.longueurTexte(var2, 10);
            var7.format(var4.getTrfDateSaisie());
            var14 = "" + var7.format(var4.getTrfDateSaisie());
            String[] var34 = var14.split("-");
            String var35 = var34[0] + "/" + var34[1] + "/" + var34[2];
            String var17 = "";
            String var18 = "";
            long var19 = 0L;
            if (var4.getTrfDebitSaisie() != 0.0D && var4.getTrfCreditSaisie() == 0.0D) {
               var17 = "D";
               var19 = 0L;
               var19 = (long)this.utilNombre.myRoundDevise(var4.getTrfDebitSaisie(), this.structureLog.getStrdevise());
               var18 = this.chiffreExport(var19);
            } else {
               var17 = "C";
               var19 = 0L;
               var19 = (long)this.utilNombre.myRoundDevise(var4.getTrfCreditSaisie(), this.structureLog.getStrdevise());
               var18 = this.chiffreExport(var19);
            }

            this.longueurTexte(var4.getTrfLibelle(), 35);
            String var23 = var4.getTrfLibelle() + " " + var4.getTrfSuite();
            String var24 = this.longueurTexte(var23, 60);
            var6.print("EC|" + var32 + "|" + var35 + "|" + var35 + "|" + "|" + "|" + var24 + "|" + var33 + "|" + var17 + "|" + var18 + "|" + "\r\n");
            if (var4.getTrfActivite() != null && !var4.getTrfActivite().isEmpty()) {
               String[] var25 = var4.getTrfActivite().split("#");
               int var26 = var25.length;

               for(int var27 = 0; var27 < var26; ++var27) {
                  String[] var28 = var25[var27].split(":");
                  long var29 = (long)Double.parseDouble(var28[1]);
                  String var31 = "" + this.utilNombre.myRoundDevise(Double.parseDouble(var28[1]), this.structureLog.getStrdevise());
                  var31 = "" + var29;
                  var6.print("RP|LASA|" + var28[0] + "|" + var31 + "|" + "\r\n");
               }
            }
         }

         var6.close();
      }

   }

   public void exportGIN(File var1, String var2) throws IOException {
      if (this.lesTransfertCompta.size() != 0) {
         new TransfertCompta();
         PrintWriter var4 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
         SimpleDateFormat var5 = new SimpleDateFormat("dd-MM-yy");

         for(int var6 = 0; var6 < this.lesTransfertCompta.size(); ++var6) {
            TransfertCompta var3 = (TransfertCompta)this.lesTransfertCompta.get(var6);
            String var7 = "";
            var5.format(var3.getTrfDateSaisie());
            String var8 = "" + var5.format(var3.getTrfDateSaisie());
            String[] var9 = var8.split("-");
            (new StringBuilder()).append(var9[0]).append(var9[1]).append(var9[2]).toString();
            var7 = var9[0];
            String var11 = var9[1];
            String var12 = var9[2];
            String var13 = "";
            if (var3.getTrfCompte() != null && !var3.getTrfCompte().isEmpty()) {
               var13 = var3.getTrfCompte();
            }

            String var14 = this.longueurTexte(var13, 6);
            String var15 = "";
            if (!var14.startsWith("6") && !var14.startsWith("7")) {
               var15 = "  ";
            } else {
               var15 = var3.getTrfActivite();
               if (var15 == null || var15.isEmpty()) {
                  var15 = "  ";
               }
            }

            String var16 = "";
            if (var3.getTrfSuite() != null && !var3.getTrfSuite().isEmpty() && var3.getTrfSuite().contains(":")) {
               String[] var17 = var3.getTrfSuite().split(":");
               var16 = var17[0];
               int var18 = Integer.parseInt(var16);
               if (var18 <= 9) {
                  var16 = "00" + var18;
               } else if (var18 >= 10 && var18 <= 99) {
                  var16 = "0" + var18;
               } else {
                  var16 = "" + var18;
               }

               var16 = this.longueurTexte(var16, 4);
            } else {
               var16 = "    ";
            }

            String var23 = "";
            String var24 = "";
            long var19 = 0L;
            if (var3.getTrfDebitSaisie() != 0.0D && var3.getTrfCreditSaisie() == 0.0D) {
               var23 = "D";
               var19 = 0L;
               var19 = (long)this.utilNombre.myRoundDevise(var3.getTrfDebitSaisie(), this.structureLog.getStrdevise());
               var24 = this.longueurTexte(this.chiffreExport(var19), 13);
            } else {
               var23 = "C";
               var19 = 0L;
               var19 = (long)this.utilNombre.myRoundDevise(var3.getTrfCreditSaisie(), this.structureLog.getStrdevise());
               var24 = this.longueurTexte(this.chiffreExport(var19), 13);
            }

            String var22 = this.longueurTexte(var3.getTrfLibelle().replace("À", "A").replace("É", "E").replace("°", "."), 30);
            var4.print(var7 + var11 + ":" + var12 + var14 + var15 + var16 + var23 + var24 + var22 + "\r\n");
         }

         var4.close();
      }

   }

   public String chiffreExport(long var1) {
      String var3 = "";
      String var4 = "" + var1;
      if (var4.contains(".")) {
         String var5 = "";
         boolean var6 = false;
         int var7 = var4.indexOf(".");
         var5 = var4.substring(0, var7);
         var3 = var5;
      } else {
         var3 = var4;
      }

      return var3;
   }

   public File exportationXML(File var1) {
      new SAXBuilder();

      try {
         String var3 = var1.getAbsolutePath();
         this.racine = new Element("transfert");
         this.document = new Document(this.racine);
         List var4 = this.lesTransfertCompta;

         for(int var5 = 0; var5 < var4.size(); ++var5) {
            new TransfertCompta();
            TransfertCompta var6 = (TransfertCompta)var4.get(var5);
            Element var7 = new Element("ligne");
            Element var8 = new Element("code");
            var7.addContent(var8);
            var8.setText(var6.getTrfCode());
            Element var9 = new Element("date");
            var7.addContent(var9);
            var9.setText("" + var6.getTrfDateSaisie());
            Element var10 = new Element("periode");
            var7.addContent(var10);
            var10.setText(var6.getTrfPeriode());
            Element var11 = new Element("compte");
            var7.addContent(var11);
            var11.setText(var6.getTrfCompte());
            Element var12 = new Element("debit");
            var7.addContent(var12);
            var12.setText("" + var6.getTrfDebitSaisie());
            Element var13 = new Element("credit");
            var7.addContent(var13);
            var13.setText("" + var6.getTrfCreditSaisie());
            Element var14 = new Element("echeance");
            var7.addContent(var14);
            var14.setText("" + var6.getTrfDateEcheance());
            Element var15 = new Element("valeur");
            var7.addContent(var15);
            var15.setText("" + var6.getTrfDateValeurTheo());
            Element var16 = new Element("libelle");
            var7.addContent(var16);
            var16.setText(var6.getTrfLibelle());
            Element var17 = new Element("piece");
            var7.addContent(var17);
            var17.setText(var6.getTrfPiece());
            Element var18 = new Element("ref1");
            var7.addContent(var18);
            var18.setText(var6.getTrfReference1());
            Element var19 = new Element("ref2");
            var7.addContent(var19);
            var19.setText(var6.getTrfReference2());
            Element var20 = new Element("treso");
            var7.addContent(var20);
            var20.setText(var6.getTrfTreso());
            Element var21 = new Element("site");
            var7.addContent(var21);
            var21.setText(var6.getTrfSite());
            Element var22 = new Element("dept");
            var7.addContent(var22);
            var22.setText(var6.getTrfDepartement());
            Element var23 = new Element("serv");
            var7.addContent(var23);
            var23.setText(var6.getTrfService());
            Element var24 = new Element("region");
            var7.addContent(var24);
            var24.setText(var6.getTrfRegion());
            Element var25 = new Element("secteur");
            var7.addContent(var25);
            var25.setText(var6.getTrfSecteur());
            Element var26 = new Element("pdv");
            var7.addContent(var26);
            var26.setText(var6.getTrfPdv());
            Element var27 = new Element("anal1");
            var7.addContent(var27);
            var27.setText(var6.getTrfDossier());
            Element var28 = new Element("anal2");
            var7.addContent(var28);
            var28.setText(var6.getTrfParc());
            Element var29 = new Element("anal4");
            var7.addContent(var29);
            var29.setText(var6.getTrfDossier());
            Element var30 = new Element("activite");
            var7.addContent(var30);
            var30.setText(var6.getTrfActivite());
            Element var31 = new Element("projet");
            var7.addContent(var31);
            var31.setText(var6.getTrfProjet());
            Element var32 = new Element("budget");
            var7.addContent(var32);
            var32.setText(var6.getTrfBudget());
            this.racine.addContent(var7);
         }

         this.enregistre(var1);
         return var1;
      } catch (Exception var33) {
         return null;
      }
   }

   public void enregistre(File var1) {
      try {
         XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var3 = new FileOutputStream(var1);
         var2.output(this.document, var3);
         var3.close();
      } catch (IOException var4) {
      }

   }

   public void exportationXLS(File var1) throws FileNotFoundException, IOException, WriteException {
      try {
         WritableWorkbook var2 = Workbook.createWorkbook(var1);
         WritableSheet var3 = var2.createSheet("Feuille HORUS", 0);
         Label var4 = null;
         WritableCellFormat var5 = new WritableCellFormat();
         var5.setBackground(Colour.GREY_25_PERCENT);
         var5.setBorder(Border.ALL, BorderLineStyle.THIN);
         var4 = new Label(0, 0, "code");
         var3.addCell(var4);
         var4 = new Label(1, 0, "date");
         var3.addCell(var4);
         var4 = new Label(2, 0, "periode");
         var3.addCell(var4);
         var4 = new Label(3, 0, "compte");
         var3.addCell(var4);
         var4 = new Label(4, 0, "debit");
         var3.addCell(var4);
         var4 = new Label(5, 0, "credit");
         var3.addCell(var4);
         var4 = new Label(6, 0, "echeance");
         var3.addCell(var4);
         var4 = new Label(7, 0, "libelle");
         var3.addCell(var4);
         var4 = new Label(8, 0, "piece");
         var3.addCell(var4);
         var4 = new Label(9, 0, "ref1");
         var3.addCell(var4);
         var4 = new Label(10, 0, "ref2");
         var3.addCell(var4);
         var4 = new Label(11, 0, "activité");
         var3.addCell(var4);
         var4 = new Label(12, 0, "anal1");
         var3.addCell(var4);
         var4 = new Label(13, 0, "anal3");
         var3.addCell(var4);
         var4 = new Label(14, 0, "parc");
         var3.addCell(var4);
         WritableCellFormat var6 = new WritableCellFormat();
         var6.setBackground(Colour.WHITE);
         var6.setBorder(Border.ALL, BorderLineStyle.THIN);
         boolean var7 = false;

         for(int var8 = 0; var8 < this.lesTransfertCompta.size(); ++var8) {
            var4 = new Label(0, var8 + 1, ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfCode());
            var3.addCell(var4);
            var4 = new Label(1, var8 + 1, this.utilDate.dateToStringFrLg(((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfDateSaisie()));
            var3.addCell(var4);
            var4 = new Label(2, var8 + 1, ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfPeriode());
            var3.addCell(var4);
            var4 = new Label(3, var8 + 1, ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfCompte());
            var3.addCell(var4);
            var4 = new Label(4, var8 + 1, "" + ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfDebitSaisie());
            var3.addCell(var4);
            var4 = new Label(5, var8 + 1, "" + ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfCreditSaisie());
            var3.addCell(var4);
            if (((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfDateEcheance() != null) {
               var4 = new Label(6, var8 + 1, this.utilDate.dateToStringFrLg(((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfDateEcheance()));
            } else {
               var4 = new Label(6, var8 + 1, "");
            }

            var3.addCell(var4);
            var4 = new Label(7, var8 + 1, ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfLibelle());
            var3.addCell(var4);
            var4 = new Label(8, var8 + 1, ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfPiece());
            var3.addCell(var4);
            var4 = new Label(9, var8 + 1, ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfReference1());
            var3.addCell(var4);
            var4 = new Label(10, var8 + 1, ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfReference2());
            var3.addCell(var4);
            var4 = new Label(11, var8 + 1, ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfActivite());
            var3.addCell(var4);
            var4 = new Label(12, var8 + 1, ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfAnal1());
            var3.addCell(var4);
            var4 = new Label(13, var8 + 1, ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfAnal3());
            var3.addCell(var4);
            var4 = new Label(14, var8 + 1, ((TransfertCompta)this.lesTransfertCompta.get(var8)).getTrfParc());
            var3.addCell(var4);
            int var12 = var8 + 1;
         }

         new CellView();

         for(int var9 = 0; var9 < var3.getColumns(); ++var9) {
            CellView var13 = var3.getColumnView(var9);
            var13.setSize(10);
            var13.setDimension(10);
            var3.setColumnView(var9, var13);
         }

         var2.write();
         var2.close();
      } catch (IOException var10) {
         var10.printStackTrace();
      } catch (WriteException var11) {
         var11.printStackTrace();
      }

   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.chargerLesModelesImpresion();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
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

   public String chargerLesModelesImpresion() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "transfert";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         this.lesModelsimpression = new ArrayList();

         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.endsWith("jasper")) {
               int var6 = var5.indexOf(".");
               var5 = var5.substring(0, var6);
               this.lesModelsimpression.add(new SelectItem(var5));
            }
         }
      }

      return "";
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

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      this.utilPrint.setRapport(this.nomRapport);
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "transfert" + File.separator);
      this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
      this.utilPrint.setEntete("Impression Transfert en comptabilité");
      this.utilPrint.setFormat(this.format);
      this.utilPrint.setEmetteur(this.impEmetteur);
      this.utilPrint.setDestinataire(this.impDestinataire);
      this.utilPrint.setDestinataireCC(this.impDestinataireCC);
      this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
      ArrayList var1 = new ArrayList();
      new TransfertCompta();
      TransfertCompta var2;
      int var3;
      if (this.lesTransfertCompta.size() != 0) {
         for(var3 = 0; var3 < this.lesTransfertCompta.size(); ++var3) {
            var2 = (TransfertCompta)this.lesTransfertCompta.get(var3);
            var2.setModeErreur(0);
            var1.add(var2);
         }
      }

      if (this.lesTransfertErreur.size() != 0) {
         for(var3 = 0; var3 < this.lesTransfertErreur.size(); ++var3) {
            var2 = (TransfertCompta)this.lesTransfertErreur.get(var3);
            var2.setModeErreur(1);
            var1.add(var2);
         }
      }

      JRBeanCollectionDataSource var4 = new JRBeanCollectionDataSource(var1);
      this.utilPrint.setjRBeanCollectionDataSource(var4);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      this.utilPrint.imprimeRapport();
   }

   public String getTestDateValeur() {
      return this.testDateValeur;
   }

   public void setTestDateValeur(String var1) {
      this.testDateValeur = var1;
   }

   public String getTestdateEcheance() {
      return this.testdateEcheance;
   }

   public void setTestdateEcheance(String var1) {
      this.testdateEcheance = var1;
   }

   public Date getDatedefin() {
      return this.datedefin;
   }

   public void setDatedefin(Date var1) {
      this.datedefin = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public JournauxComptables getJournauxComptables() {
      return this.journauxComptables;
   }

   public void setJournauxComptables(JournauxComptables var1) {
      this.journauxComptables = var1;
   }

   public double getEcart() {
      return this.ecart;
   }

   public void setEcart(double var1) {
      this.ecart = var1;
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

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public List getLesModelsimpression() {
      return this.lesModelsimpression;
   }

   public void setLesModelsimpression(List var1) {
      this.lesModelsimpression = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public int getPljFormatDevise() {
      return this.pljFormatDevise;
   }

   public void setPljFormatDevise(int var1) {
      this.pljFormatDevise = var1;
   }

   public String getFormatExport() {
      return this.formatExport;
   }

   public void setFormatExport(String var1) {
      this.formatExport = var1;
   }

   public String getNomRapport() {
      return this.nomRapport;
   }

   public void setNomRapport(String var1) {
      this.nomRapport = var1;
   }

   public TransfertCompta getTransfertCompta() {
      return this.transfertCompta;
   }

   public void setTransfertCompta(TransfertCompta var1) {
      this.transfertCompta = var1;
   }

   public DataModel getDataModelTransfertCompta() {
      return this.dataModelTransfertCompta;
   }

   public void setDataModelTransfertCompta(DataModel var1) {
      this.dataModelTransfertCompta = var1;
   }

   public boolean isVar_verif_transfert() {
      return this.var_verif_transfert;
   }

   public void setVar_verif_transfert(boolean var1) {
      this.var_verif_transfert = var1;
   }

   public boolean isShowModalPanelModif() {
      return this.showModalPanelModif;
   }

   public void setShowModalPanelModif(boolean var1) {
      this.showModalPanelModif = var1;
   }

   public DataModel getDatamodelPlanComptable() {
      return this.datamodelPlanComptable;
   }

   public void setDatamodelPlanComptable(DataModel var1) {
      this.datamodelPlanComptable = var1;
   }

   public DocumentEntete getDocumentEntete() {
      return this.documentEntete;
   }

   public void setDocumentEntete(DocumentEntete var1) {
      this.documentEntete = var1;
   }

   public int getVar_choix_importation() {
      return this.var_choix_importation;
   }

   public void setVar_choix_importation(int var1) {
      this.var_choix_importation = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
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

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public boolean isShowModalPanelAnalytique() {
      return this.showModalPanelAnalytique;
   }

   public void setShowModalPanelAnalytique(boolean var1) {
      this.showModalPanelAnalytique = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
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

   public String getCheminExportDestination() {
      return this.cheminExportDestination;
   }

   public void setCheminExportDestination(String var1) {
      this.cheminExportDestination = var1;
   }

   public String getCheminExportOrigine() {
      return this.cheminExportOrigine;
   }

   public void setCheminExportOrigine(String var1) {
      this.cheminExportOrigine = var1;
   }

   public boolean isChangerPartout() {
      return this.changerPartout;
   }

   public void setChangerPartout(boolean var1) {
      this.changerPartout = var1;
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

   public String getNomFichier() {
      return this.nomFichier;
   }

   public void setNomFichier(String var1) {
      this.nomFichier = var1;
   }

   public boolean isAfficheFichierExport() {
      return this.afficheFichierExport;
   }

   public void setAfficheFichierExport(boolean var1) {
      this.afficheFichierExport = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public String getVar_info() {
      return this.var_info;
   }

   public void setVar_info(String var1) {
      this.var_info = var1;
   }

   public boolean isVar_showBarProg() {
      return this.var_showBarProg;
   }

   public void setVar_showBarProg(boolean var1) {
      this.var_showBarProg = var1;
   }

   public int getBalance() {
      return this.balance;
   }

   public void setBalance(int var1) {
      this.balance = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelTransfertErreur() {
      return this.dataModelTransfertErreur;
   }

   public void setDataModelTransfertErreur(DataModel var1) {
      this.dataModelTransfertErreur = var1;
   }

   public TransfertCompta getTransfertErreur() {
      return this.transfertErreur;
   }

   public void setTransfertErreur(TransfertCompta var1) {
      this.transfertErreur = var1;
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

   public int getNbligne() {
      return this.nbligne;
   }

   public void setNbligne(int var1) {
      this.nbligne = var1;
   }

   public FormTransfertCtrl getFormTransfertCtrl() {
      return this.formTransfertCtrl;
   }

   public void setFormTransfertCtrl(FormTransfertCtrl var1) {
      this.formTransfertCtrl = var1;
   }

   public List getLesTransfertCompta() {
      return this.lesTransfertCompta;
   }

   public void setLesTransfertCompta(List var1) {
      this.lesTransfertCompta = var1;
   }

   public String getOnglet() {
      return this.onglet;
   }

   public void setOnglet(String var1) {
      this.onglet = var1;
   }

   public List getListeDocumentTransfert() {
      return this.listeDocumentTransfert;
   }

   public void setListeDocumentTransfert(List var1) {
      this.listeDocumentTransfert = var1;
   }

   public List getLesTransfertVentes() {
      return this.lesTransfertVentes;
   }

   public void setLesTransfertVentes(List var1) {
      this.lesTransfertVentes = var1;
   }

   public DataModel getDataModelChampAmortissement() {
      return this.dataModelChampAmortissement;
   }

   public void setDataModelChampAmortissement(DataModel var1) {
      this.dataModelChampAmortissement = var1;
   }
}
