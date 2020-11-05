package com.epegase.systeme.utilitaires;

import com.epegase.forms.achats.FormProduitsAchs;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.ventes.FormAvoirVentes;
import com.epegase.forms.ventes.FormCommandeVentes;
import com.epegase.forms.ventes.FormDevisVentes;
import com.epegase.forms.ventes.FormFactureVentes;
import com.epegase.forms.ventes.FormLivraisonVentes;
import com.epegase.forms.ventes.FormNoteDebitVentes;
import com.epegase.forms.ventes.FormRetourVentes;
import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.AmortissementTab;
import com.epegase.systeme.classe.Amortissements;
import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneAchats;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienBail;
import com.epegase.systeme.classe.BienFacture;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.classe.BonSortieLigne;
import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinMois;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesJour;
import com.epegase.systeme.classe.CaissesMois;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.CotationLigneAchats;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.EcrituresAnterieur;
import com.epegase.systeme.classe.EcrituresDestroy;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FabricationEnteteAchats;
import com.epegase.systeme.classe.FabricationLigneAchats;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FactureLigneMedical;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.FraisLigneAchats;
import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.InventaireEntete;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.JournauxJour;
import com.epegase.systeme.classe.JournauxMois;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.LivraisonLivreeVentes;
import com.epegase.systeme.classe.Mails;
import com.epegase.systeme.classe.MailsPj;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.NoteDebitLigneAchats;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.PatientAnt;
import com.epegase.systeme.classe.PatientContact;
import com.epegase.systeme.classe.PatientLettreGarantie;
import com.epegase.systeme.classe.PatientPec;
import com.epegase.systeme.classe.PatientProt;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsActe;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsDetail;
import com.epegase.systeme.classe.ProduitsFourchette;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ProduitsGrp;
import com.epegase.systeme.classe.ProduitsHistoRef;
import com.epegase.systeme.classe.ProduitsLaboratoire;
import com.epegase.systeme.classe.ProduitsMcles;
import com.epegase.systeme.classe.ProduitsPharmacie;
import com.epegase.systeme.classe.ProduitsReponse;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.RetourEnteteAchats;
import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesConges;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesElements;
import com.epegase.systeme.classe.SalariesGrh;
import com.epegase.systeme.classe.SalariesPrets;
import com.epegase.systeme.classe.SalariesPretsLignes;
import com.epegase.systeme.classe.SalariesVariables;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.AmortissementTabDao;
import com.epegase.systeme.dao.AmortissementsDao;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BalDao;
import com.epegase.systeme.dao.BienBailDao;
import com.epegase.systeme.dao.BienDao;
import com.epegase.systeme.dao.BienFactureDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.BrouillardDao;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.BulletinMoisDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CaissesJourDao;
import com.epegase.systeme.dao.CaissesMoisDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.ChargementLigneDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.ContratEnteteVentesDao;
import com.epegase.systeme.dao.CotationEnteteAchatsDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresAnterieurDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesParcsDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FabricationEnteteAchatsDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureEnteteMedicalDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneMedicalDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FeuilleCalculDao;
import com.epegase.systeme.dao.FeuilleCalculRubriqueDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.GroupeDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.InventaireLigneDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.JournauxJourDao;
import com.epegase.systeme.dao.JournauxMoisDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.LivraisonLivreeVentesDao;
import com.epegase.systeme.dao.MailsDao;
import com.epegase.systeme.dao.MailsPJDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.PatientAntDao;
import com.epegase.systeme.dao.PatientContactDao;
import com.epegase.systeme.dao.PatientLettreGarantieDao;
import com.epegase.systeme.dao.PatientPecDao;
import com.epegase.systeme.dao.PatientProtDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsActeDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsDetailDao;
import com.epegase.systeme.dao.ProduitsFourchetteDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsGrpDao;
import com.epegase.systeme.dao.ProduitsHistoRefDao;
import com.epegase.systeme.dao.ProduitsLaboratoireDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsPharmacieDao;
import com.epegase.systeme.dao.ProduitsReponseDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.PumpAchatsDao;
import com.epegase.systeme.dao.RacinesDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.RetourEnteteAchatsDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.SalariesCongesDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesElementsDao;
import com.epegase.systeme.dao.SalariesGrhDao;
import com.epegase.systeme.dao.SalariesHistoriqueDao;
import com.epegase.systeme.dao.SalariesPretsDao;
import com.epegase.systeme.dao.SalariesPretsLignesDao;
import com.epegase.systeme.dao.SalariesVariablesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
import com.epegase.systeme.menu.MenuListe;
import com.epegase.systeme.menu.MenuModule;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.LectureEvolution;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LectureGrilleSalaire;
import com.epegase.systeme.xml.LectureNaturePrets;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LectureReglementClient;
import com.epegase.systeme.xml.LectureReglementFournisseur;
import com.epegase.systeme.xml.LireLesoptionsAchats;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.LireLesoptionsPaye;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetGrilleSalaire;
import com.epegase.systeme.xml.ObjetPays;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionMedical;
import com.epegase.systeme.xml.OptionParcs;
import com.epegase.systeme.xml.OptionPaye;
import com.epegase.systeme.xml.OptionStocks;
import com.epegase.systeme.xml.OptionTiers;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.mail.Authenticator;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.naming.NamingException;
import javax.xml.parsers.ParserConfigurationException;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class FormUtilitaires implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private UserDao userDao;
   private EspionDao espionDao;
   private MenuModule menuModule = new MenuModule();
   private FormRecherche formRecherche;
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
   private String nomStructureEnCours;
   private transient DataModel dataModelMenuHorizontal;
   private String mods;
   private transient DataModel dataModelModuleParam;
   private String choixModule = "";
   private long selectedExo = 0L;
   private int taille = 0;
   private String choixLigne;
   private transient DataModel dataModelUtilTiers;
   private transient DataModel dataModelUtilCompta;
   private transient DataModel dataModelUtilAchats;
   private transient DataModel dataModelUtilVentes;
   private transient DataModel dataModelUtilMedical;
   private transient DataModel dataModelUtilParc;
   private transient DataModel dataModelUtilPaye;
   private transient DataModel dataModelUtilTreso;
   private transient DataModel dataModelUtilImmobilier;
   private boolean accesCompta;
   private boolean accesAchats;
   private boolean accesVentes;
   private boolean accesMedical;
   private boolean accesParc;
   private boolean accesPaye;
   private boolean accesTreso;
   private boolean accesImmobilier;
   private transient DataModel dataModelEcrituresDetruites = new ListDataModel();
   private transient DataModel dataModelEcrituresPB;
   private List lesEcrituresDetruites;
   private List lesEcritures;
   private List mesJournauxComptables = new ArrayList();
   private ExercicesComptableDao exercicesComptableDao;
   private ExercicesAchatsDao exercicesAchatsDao;
   private ExercicesVentesDao exercicesVentesDao;
   private ExercicesPayeDao exercicesPayeDao;
   private ExercicesParcsDao exercicesParcsDao;
   private ExercicesCaisseDao exercicesCaisseDao;
   private OptionComptabilite optionComptabilite;
   private OptionVentes optionVentes;
   private OptionMedical optionMedical;
   private OptionParcs optionParcs;
   private OptionPaye optionPaye;
   private OptionStocks optionStocks;
   private OptionTiers optionTiers;
   private OptionAchats optionAchats;
   private int var_currentValue;
   private String var_info;
   private boolean var_showBarProg = false;
   private List lesDocumentsEntete;
   private transient DataModel dataModelDocumentEntete;
   private String pageIndex;
   private EcrituresDestroy ecrDestroy = new EcrituresDestroy();
   private Ecritures ecrGene = new Ecritures();
   private String dossierCodeOld;
   private String dossierLibelleNew;
   private String dossierCodeNew;
   private int var_plan_origine;
   private int var_plan_destination;
   private Date var_date_deb;
   private Date var_date_fin;
   private String var_journal;
   private transient DataModel dataModelFamille;
   private List listeFamilleAchs;
   private transient DataModel dataModelDepot;
   private List listeDepot;
   private transient DataModel dataModelService;
   private List listeService;
   private List listeFamilleVtes;
   private transient DataModel dataModelTarif;
   private List listeTarif;
   private List lesTiersOrigines;
   private transient DataModel dataModelTiersOrigines;
   private Tiers tiersOrigine;
   private long idOrigine;
   private String genreOrigine;
   private String compteOrigine;
   private List lesTiersDestinataires;
   private transient DataModel dataModelTiersDestinataires;
   private Tiers tiersDestinataire;
   private TiersDao tiersDao;
   private long idDestinataire;
   private String genreDestinataire;
   private String compteDestinataire;
   private String patientOrigine;
   private String patientDestination;
   private List lesPatientsOrigines;
   private Patients patientsOrigine;
   private List lesPatientsDestinataires;
   private Patients patientsDestinataire;
   private PatientsDao patientsDao;
   private BalDao balDao;
   private List lesBal;
   private List lesBalsItems;
   private Bal bal;
   private String balSelectionnee;
   private List lesSalarieItems;
   private List lesContratItems;
   private long var_salarie;
   private long var_contrat;
   private transient DataModel dataModelBulletinsLigne;
   private List lesBulletinLignes;
   private boolean valideBulletin;
   private SalariesDao salariesDao;
   private SalariesContratsDao salariesContratsDao;
   private BulletinSalaire bulletinSalaire;
   private BulletinLigne bulletinLigne;
   private Salaries salaries;
   private SalariesContrats salariesContrats;
   private List mesUsersOriginesItems;
   private List mesUsersDestinataresItems;
   private long userIdOrigine;
   private long userIdDestinataire;
   private List lesParapheurs;
   private Parapheur parapheur;
   private transient DataModel dataModelParapheur;
   private transient DataModel dataModelEvolution;
   private String module;
   private boolean sup_devis;
   private boolean sup_bc;
   private boolean sup_bl;
   private boolean sup_retour;
   private boolean sup_facture;
   private boolean sup_factureInterne;
   private boolean sup_noteDebit;
   private boolean sup_avoir;
   private boolean sup_chargement;
   private boolean sup_ticket;
   private boolean sup_da;
   private boolean sup_cotation;
   private boolean sup_cmd;
   private boolean sup_reception;
   private boolean sup_factureFrais;
   private boolean sup_inventaire;
   private boolean sup_bin;
   private boolean sup_bout;
   private boolean sup_cession;
   private boolean sup_production;

   public FormUtilitaires() throws IOException, JDOMException, ParseException {
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      this.lesDocumentsEntete = new ArrayList();
      this.dataModelDocumentEntete = new ListDataModel();
      this.dataModelParapheur = new ListDataModel();
      this.lesParapheurs = new ArrayList();
      this.dataModelEvolution = new ListDataModel();
   }

   public void InstancesDaoUtilses() throws IOException, SAXException, JDOMException, ParseException {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.exercicesAchatsDao = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentesDao = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesCaisseDao = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      this.exercicesParcsDao = new ExercicesParcsDao(this.baseLog, this.utilInitHibernate);
   }

   public void menuUtilitaires() throws JDOMException, IOException, ParseException {
      this.choixModule = "moduleUtilitaires";
      MenuListe var1 = new MenuListe();
      this.dataModelUtilTiers = new ListDataModel();
      this.dataModelUtilTiers = var1.menuUtilitairesTiers();
      MenuListe var2 = new MenuListe();
      this.dataModelUtilCompta = new ListDataModel();
      this.dataModelUtilCompta = var2.menuUtilitairesCompta();
      MenuListe var3 = new MenuListe();
      this.dataModelUtilAchats = new ListDataModel();
      this.dataModelUtilAchats = var3.menuUtilitairesAchats();
      MenuListe var4 = new MenuListe();
      this.dataModelUtilVentes = new ListDataModel();
      this.dataModelUtilVentes = var4.menuUtilitairesVentes();
      MenuListe var5 = new MenuListe();
      this.dataModelUtilMedical = new ListDataModel();
      this.dataModelUtilMedical = var5.menuUtilitairesMedical();
      MenuListe var6 = new MenuListe();
      this.dataModelUtilParc = new ListDataModel();
      this.dataModelUtilParc = var6.menuUtilitairesParc();
      MenuListe var7 = new MenuListe();
      this.dataModelUtilPaye = new ListDataModel();
      this.dataModelUtilPaye = var7.menuUtilitairesPaye();
      MenuListe var8 = new MenuListe();
      this.dataModelUtilTreso = new ListDataModel();
      this.dataModelUtilTreso = var8.menuUtilitairesTreso();
      MenuListe var9 = new MenuListe();
      this.dataModelUtilImmobilier = new ListDataModel();
      this.dataModelUtilImmobilier = var9.menuUtilitairesImmobilier();
      this.accesCompta = this.verifModuleInstalle("40");
      this.accesAchats = this.verifModuleInstalle("60");
      this.accesVentes = this.verifModuleInstalle("80");
      this.accesMedical = this.verifModuleInstalle("815");
      this.accesParc = this.verifModuleInstalle("70");
      this.accesPaye = this.verifModuleInstalle("50");
      this.accesTreso = this.verifModuleInstalle("90");
      this.accesImmobilier = this.verifModuleInstalle("816");
      this.intEspion();
   }

   public boolean verifModuleInstalle(String var1) {
      boolean var2 = false;
      if (this.structureLog.getStrmod1() != null && this.structureLog.getStrmod1().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod2() != null && this.structureLog.getStrmod2().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod3() != null && this.structureLog.getStrmod3().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod4() != null && this.structureLog.getStrmod4().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod5() != null && this.structureLog.getStrmod5().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod6() != null && this.structureLog.getStrmod6().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod7() != null && this.structureLog.getStrmod7().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod8() != null && this.structureLog.getStrmod8().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod9() != null && this.structureLog.getStrmod9().startsWith(var1)) {
         var2 = true;
      } else if (this.structureLog.getStrmod10() != null && this.structureLog.getStrmod10().startsWith(var1)) {
         var2 = true;
      }

      return var2;
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

   public void mAJEspion(String var1) throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var2 = new Espion();
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         var2.setEspdtecreat(new Date());
         var2.setUsers(this.usersLog);
         var2.setEspaction(var1);
         var2.setEsptype(0);
         this.espionDao.mAJEspion(var2, var3);
         var4.commit();
      } catch (HibernateException var9) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void journauxComptables() throws HibernateException, NamingException {
      this.mesJournauxComptables.clear();
      long var1 = 0L;
      new ExercicesComptable();
      ExercicesComptable var3 = this.exercicesComptableDao.recupererLastExo((Session)null);
      if (var3 != null) {
         var1 = var3.getExecpt_id();
         JournauxComptablesDao var4 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
         this.mesJournauxComptables = var4.mesjournauxActifsItems(var1, "", 0, (Session)null);
      }

   }

   public void journauxTresorerie() throws HibernateException, NamingException {
      this.mesJournauxComptables.clear();
      long var1 = 0L;
      new ExercicesComptable();
      ExercicesComptable var3 = this.exercicesComptableDao.recupererLastExo((Session)null);
      if (var3 != null) {
         var1 = var3.getExecpt_id();
         JournauxComptablesDao var4 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var5 = var4.mesjournauxTresorerieActifs(var1, "", 0, (Session)null);
         if (var5.size() != 0) {
            for(int var6 = 0; var6 < var5.size(); ++var6) {
               new JournauxComptables();
               JournauxComptables var7 = (JournauxComptables)var5.get(var6);
               this.mesJournauxComptables.add(new SelectItem(var7.getPljCode(), var7.getPljCode() + ":" + var7.getPljLibelleFr()));
            }
         }
      }

   }

   public void aiguillageUtilitairesTiers() throws SAXException, IOException, JDOMException, NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.choixModule = "moduleUtilitaires";
      if (this.dataModelUtilTiers.isRowAvailable()) {
         if (this.dataModelUtilTiers.getRowIndex() == 0) {
            this.choixLigne = "fusionTiers";
            this.choixModule = "executionUtilitaires";
            this.var_info = "";
            this.var_currentValue = 0;
            this.chargerLesTiers();
         } else if (this.dataModelUtilTiers.getRowIndex() == 1) {
            this.choixLigne = "recalculTiersACreer";
            this.recalculTiersACreer();
         } else if (this.dataModelUtilTiers.getRowIndex() == 2) {
            this.choixLigne = "flagMails";
            this.choixModule = "executionUtilitaires";
            this.var_info = "";
            this.var_currentValue = 0;
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.chargerLesBal();
         } else if (this.dataModelUtilTiers.getRowIndex() == 3) {
            this.choixLigne = "deflagMails";
            this.choixModule = "executionUtilitaires";
            this.var_info = "";
            this.var_currentValue = 0;
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.chargerLesBal();
         } else if (this.dataModelUtilTiers.getRowIndex() == 4) {
            this.choixLigne = "verificationPj";
            this.verificationPj();
         } else if (this.dataModelUtilTiers.getRowIndex() == 5) {
            this.choixLigne = "reimputationTiers";
            this.reimputationTiers();
         } else if (this.dataModelUtilTiers.getRowIndex() != 6 && this.dataModelUtilTiers.getRowIndex() == 7) {
            this.choixLigne = "transfertParapheur";
            this.choixModule = "executionUtilitaires";
            this.var_info = "";
            this.var_currentValue = 0;
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.chargerLesSignataires();
         }
      }

      this.mAJEspion(this.choixModule + " : " + this.choixLigne);
   }

   public void aiguillageUtilitairesCompta() throws SAXException, IOException, JDOMException, NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.choixModule = "moduleUtilitaires";
      this.dataModelEcrituresDetruites = new ListDataModel();
      if (this.dataModelUtilCompta.isRowAvailable()) {
         if (this.dataModelUtilCompta.getRowIndex() == 0) {
            this.choixLigne = "recalculNatureCompte";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 1) {
            this.choixLigne = "recalculNatureJournaux";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 2) {
            this.choixLigne = "transfertPlansanalytiques";
            this.choixModule = "executionUtilitaires";
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 3) {
            this.choixLigne = "devalidationEcritures";
            this.choixModule = "executionUtilitaires";
            this.journauxComptables();
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 4) {
            this.choixLigne = "effaceSemaphores";
            this.effaceSemaphores();
         } else if (this.dataModelUtilCompta.getRowIndex() == 5) {
            this.choixLigne = "delettrageExercices";
            this.delettrageExercices();
         } else if (this.dataModelUtilCompta.getRowIndex() == 6) {
            this.choixLigne = "forcageTrfDotation";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 7) {
            this.choixLigne = "annuleTransfertDotation";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 8) {
            this.choixLigne = "recalculClesEcritures";
            this.recalculClesEcritures();
         } else if (this.dataModelUtilCompta.getRowIndex() == 9) {
            this.choixLigne = "calculTableauDotation";
            this.calculTableauDotation();
         } else if (this.dataModelUtilCompta.getRowIndex() == 10) {
            this.choixLigne = "recalculAnalytique";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 11) {
            this.choixLigne = "declotureMensuelle";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 12) {
            this.choixLigne = "verificationDecimalesEcritures";
            this.verificationDecimalesEcritures();
         } else if (this.dataModelUtilCompta.getRowIndex() == 13) {
            this.choixLigne = "recalculClesJournauxMois";
            this.recalculClesJournauxMois();
         } else if (this.dataModelUtilCompta.getRowIndex() == 14) {
            this.choixLigne = "restaurationEcritures";
            this.choixModule = "executionUtilitaires";
            this.journauxComptables();
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
            this.lesEcrituresDetruites = new ArrayList();
         } else if (this.dataModelUtilCompta.getRowIndex() == 15) {
            this.choixLigne = "suppressionEcritures";
            this.choixModule = "executionUtilitaires";
            this.journauxComptables();
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 16) {
            this.choixLigne = "flagRapprochement";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 17) {
            this.choixLigne = "analyseReparationEcrGene";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
            this.lesEcritures = new ArrayList();
         } else if (this.dataModelUtilCompta.getRowIndex() == 18) {
            this.choixLigne = "analyseReparationEcrAnal";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
            this.lesEcritures = new ArrayList();
         } else if (this.dataModelUtilCompta.getRowIndex() == 19) {
            this.choixLigne = "declotureRapprochement";
            this.choixModule = "executionUtilitaires";
            this.journauxTresorerie();
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 20) {
            this.choixLigne = "recalculClesRpprochement";
            this.recalculClesRapprochement();
         } else if (this.dataModelUtilCompta.getRowIndex() == 21) {
            this.choixLigne = "recalculPlanComptable";
            this.recalculPlanComptable();
         } else if (this.dataModelUtilCompta.getRowIndex() == 22) {
            this.choixLigne = "recalculCompteAmortissements";
            this.recalculCompteAmortissements();
         } else if (this.dataModelUtilCompta.getRowIndex() == 23) {
            this.choixLigne = "genePlanComptableTiers";
            this.genePlanComptableTiers();
         } else if (this.dataModelUtilCompta.getRowIndex() == 24) {
            this.choixLigne = "recalculCompteEcritures";
            this.recalculCompteEcritures();
         } else if (this.dataModelUtilCompta.getRowIndex() == 25) {
            this.choixLigne = "recalculColonneEuro";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilCompta.getRowIndex() == 26) {
            this.choixLigne = "recalculDateEcheance";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         }

         this.mAJEspion(this.choixModule + " : " + this.choixLigne);
      }

   }

   public void aiguillageUtilitairesAchats() throws SAXException, IOException, JDOMException, NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.choixModule = "moduleUtilitaires";
      if (this.dataModelUtilAchats.isRowAvailable()) {
         if (this.dataModelUtilAchats.getRowIndex() == 0) {
            this.choixLigne = "annuleTransfertAchats";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
            this.lesDocumentsEntete.clear();
            this.dataModelDocumentEntete.setWrappedData(this.lesDocumentsEntete);
         } else if (this.dataModelUtilAchats.getRowIndex() == 1) {
            this.choixLigne = "forceTransfertAchats";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilAchats.getRowIndex() == 2) {
            this.choixLigne = "reimputationDepot";
            this.reimputationDepot();
         } else if (this.dataModelUtilAchats.getRowIndex() == 3) {
            this.choixLigne = "recalculStock";
            this.recalculStock();
         } else if (this.dataModelUtilAchats.getRowIndex() == 4) {
            this.choixLigne = "libelleDocProduitAchs";
            this.libelleDocProduitAchs();
         } else {
            List var2;
            FamillesProduitsAchatsDao var3;
            ExercicesAchats var4;
            int var5;
            String[] var6;
            FamillesProduitsAchats var7;
            int var8;
            String[] var9;
            boolean var10;
            int var11;
            FamillesProduitsVentesDao var13;
            ExercicesVentes var14;
            List var15;
            FamillesProduitsAchats var16;
            if (this.dataModelUtilAchats.getRowIndex() == 5) {
               this.choixLigne = "affectationDepotProduitAchs";
               this.choixModule = "executionUtilitaires";
               this.var_info = "";
               this.var_currentValue = 0;
               this.listeDepot = new ArrayList();
               this.dataModelDepot = new ListDataModel();
               DepotAchatsDao var12 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
               this.listeDepot = var12.selectActifDepot(99, (Session)null);
               this.dataModelDepot.setWrappedData(this.listeDepot);
               this.listeFamilleAchs = new ArrayList();
               this.dataModelFamille = new ListDataModel();
               new ArrayList();
               var3 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
               new ExercicesAchats();
               var4 = this.exercicesAchatsDao.recupererLastExo((Session)null);
               if (var4 != null) {
                  var2 = var3.chargerFamilleProduitAchatsUtilItems(var4.getExeachId(), (Session)null);
                  if (var2.size() != 0) {
                     for(var5 = 0; var5 < var2.size(); ++var5) {
                        if (((SelectItem)var2.get(var5)).getValue().toString().contains(":")) {
                           var6 = ((SelectItem)var2.get(var5)).getValue().toString().split(":");
                           var7 = new FamillesProduitsAchats();
                           var7.setFamachCode(var6[0]);
                           var7.setFamachLibelleFr(var6[1]);
                           this.listeFamilleAchs.add(var7);
                        }
                     }
                  }
               }

               var13 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
               new ExercicesVentes();
               var14 = this.exercicesVentesDao.recupererLastExo((Session)null);
               new ArrayList();
               if (var14 != null) {
                  var15 = var13.chargerFamilleProduitVentesUtilItems(var14.getExevteId(), (Session)null);
                  if (var15.size() != 0) {
                     for(var8 = 0; var8 < var15.size(); ++var8) {
                        if (((SelectItem)var15.get(var8)).getValue().toString().contains(":")) {
                           var9 = ((SelectItem)var15.get(var8)).getValue().toString().split(":");
                           var10 = false;

                           for(var11 = 0; var11 < this.listeFamilleAchs.size(); ++var11) {
                              if (var9[0].equals(((FamillesProduitsAchats)this.listeFamilleAchs.get(var11)).getFamachCode())) {
                                 var10 = true;
                                 break;
                              }
                           }

                           if (!var10) {
                              var16 = new FamillesProduitsAchats();
                              var16.setFamachCode(var9[0]);
                              var16.setFamachLibelleFr(var9[1]);
                              this.listeFamilleAchs.add(var16);
                           }
                        }
                     }
                  }
               }

               this.dataModelFamille.setWrappedData(this.listeFamilleAchs);
            } else if (this.dataModelUtilAchats.getRowIndex() == 6) {
               this.choixLigne = "geneSoldeFacture";
               this.geneSoldeFactureAchats();
            } else if (this.dataModelUtilAchats.getRowIndex() == 7) {
               this.choixLigne = "geneEcheanceFacture";
               this.geneEcheanceFactureAchats();
            } else if (this.dataModelUtilAchats.getRowIndex() == 8) {
               this.choixLigne = "recalculValoReception";
               this.recalculValorisationReception();
            } else if (this.dataModelUtilAchats.getRowIndex() == 9) {
               this.choixLigne = "recalculPUMPEntreeStk";
               this.recalculPUMPEntreeStk();
            } else if (this.dataModelUtilAchats.getRowIndex() == 10) {
               this.choixLigne = "recalculPumpMvts";
               this.recalculPumpMvts();
            } else if (this.dataModelUtilAchats.getRowIndex() == 11) {
               this.choixLigne = "desactivationProdZero";
               this.desactivationProdZero();
            } else if (this.dataModelUtilAchats.getRowIndex() == 12) {
               this.choixLigne = "suppressionProdDesactives";
               this.suppressionProdDesactives();
            } else if (this.dataModelUtilAchats.getRowIndex() == 13) {
               this.choixLigne = "verificationDossierImport";
               this.verificationDossierImport();
            } else if (this.dataModelUtilAchats.getRowIndex() == 14) {
               this.choixLigne = "extractionTvadouaneFacturesFrais";
               this.extractionTvadouaneFacturesFrais();
            } else if (this.dataModelUtilAchats.getRowIndex() == 15) {
               this.choixLigne = "recalculConnexionCCRRFNFA";
               this.choixModule = "executionUtilitaires";
               this.var_date_deb = null;
               this.var_date_fin = null;
               this.var_info = "";
            } else if (this.dataModelUtilAchats.getRowIndex() == 16) {
               this.choixLigne = "changeDossierImportation";
               this.choixModule = "executionUtilitaires";
               this.dossierCodeOld = "";
               this.dossierCodeNew = "";
               this.dossierLibelleNew = "";
               this.var_info = "";
            } else if (this.dataModelUtilAchats.getRowIndex() == 17) {
               this.choixLigne = "correctionFamilleAchat";
               this.correctionFamilleAchat();
            } else if (this.dataModelUtilAchats.getRowIndex() == 18) {
               this.choixLigne = "famillesDocProduitAchs";
               this.famillesDocProduitAchs();
            } else if (this.dataModelUtilAchats.getRowIndex() == 19) {
               this.choixLigne = "recalculDerniereDatesAchs";
               this.recalculDerniereDatesAchs();
            } else if (this.dataModelUtilAchats.getRowIndex() == 20) {
               this.choixLigne = "recalculLibellesFamilles";
               this.recalculLibellesFamilles();
            } else if (this.dataModelUtilAchats.getRowIndex() != 21) {
               if (this.dataModelUtilAchats.getRowIndex() == 22) {
                  this.choixLigne = "suppressionDocumentAchat";
                  this.choixModule = "executionUtilitaires";
                  this.var_date_deb = null;
                  this.var_date_fin = null;
                  this.var_info = "";
                  this.var_currentValue = 0;
               } else if (this.dataModelUtilAchats.getRowIndex() == 23) {
                  this.choixLigne = "desactiveroduitSansMouvement";
                  this.desactiveroduitSansMouvement();
               } else if (this.dataModelUtilAchats.getRowIndex() == 24) {
                  this.choixLigne = "desactiveroduitSansInventaire";
                  this.desactiveroduitSansInventaire();
               } else if (this.dataModelUtilAchats.getRowIndex() == 25) {
                  this.choixLigne = "regenerationProduitsFournisseurs";
                  this.regenerationProduitsFournisseurs();
               } else if (this.dataModelUtilAchats.getRowIndex() == 26) {
                  this.choixLigne = "reconnexionFraisReception";
                  this.reconnexionFraisReception();
               } else if (this.dataModelUtilAchats.getRowIndex() == 27) {
                  this.choixLigne = "recalculReference";
                  this.choixModule = "executionUtilitaires";
                  this.var_date_deb = null;
                  this.var_date_fin = null;
                  this.var_info = "";
                  this.var_currentValue = 0;
               }
            } else {
               this.choixLigne = "affectationServiceProduitAchs";
               this.choixModule = "executionUtilitaires";
               this.var_info = "";
               this.var_currentValue = 0;
               this.listeService = new ArrayList();
               this.dataModelService = new ListDataModel();
               ServiceDao var1 = new ServiceDao(this.baseLog, this.utilInitHibernate);
               this.listeService = var1.chargerLesServices((Session)null);
               this.dataModelService.setWrappedData(this.listeService);
               this.listeFamilleAchs = new ArrayList();
               this.dataModelFamille = new ListDataModel();
               new ArrayList();
               var3 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
               new ExercicesAchats();
               var4 = this.exercicesAchatsDao.recupererLastExo((Session)null);
               if (var4 != null) {
                  var2 = var3.chargerFamilleProduitAchatsUtilItems(var4.getExeachId(), (Session)null);
                  if (var2.size() != 0) {
                     for(var5 = 0; var5 < var2.size(); ++var5) {
                        var6 = ((SelectItem)var2.get(var5)).getValue().toString().split(":");
                        var7 = new FamillesProduitsAchats();
                        var7.setFamachCode(var6[0]);
                        var7.setFamachLibelleFr(var6[1]);
                        this.listeFamilleAchs.add(var7);
                     }
                  }
               }

               var13 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
               new ExercicesVentes();
               var14 = this.exercicesVentesDao.recupererLastExo((Session)null);
               new ArrayList();
               if (var14 != null) {
                  var15 = var13.chargerFamilleProduitVentesUtilItems(var14.getExevteId(), (Session)null);
                  if (var15.size() != 0) {
                     for(var8 = 0; var8 < var15.size(); ++var8) {
                        var9 = ((SelectItem)var15.get(var8)).getValue().toString().split(":");
                        var10 = false;

                        for(var11 = 0; var11 < this.listeFamilleAchs.size(); ++var11) {
                           if (var9[0].equals(((FamillesProduitsAchats)this.listeFamilleAchs.get(var8)).getFamachCode())) {
                              var10 = true;
                              break;
                           }
                        }

                        if (!var10) {
                           var16 = new FamillesProduitsAchats();
                           var16.setFamachCode(var9[0]);
                           var16.setFamachLibelleFr(var9[1]);
                           this.listeFamilleAchs.add(var16);
                        }
                     }
                  }
               }

               this.dataModelFamille.setWrappedData(this.listeFamilleAchs);
            }
         }

         this.mAJEspion(this.choixModule + " : " + this.choixLigne);
      }

   }

   public void aiguillageUtilitairesVentes() throws SAXException, IOException, JDOMException, NamingException, ParseException, ParseException {
      this.choixModule = "moduleUtilitaires";
      if (this.dataModelUtilVentes.isRowAvailable()) {
         if (this.dataModelUtilVentes.getRowIndex() == 0) {
            this.choixLigne = "annuleTransfertVentes";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
            this.lesDocumentsEntete.clear();
            this.dataModelDocumentEntete.setWrappedData(this.lesDocumentsEntete);
         } else if (this.dataModelUtilVentes.getRowIndex() == 1) {
            this.choixLigne = "forceTransfertVentes";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilVentes.getRowIndex() == 2) {
            this.choixLigne = "recalculDernierReglementFacture";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilVentes.getRowIndex() == 3) {
            this.choixLigne = "recalculTarif";
            this.recalculTarif();
         } else if (this.dataModelUtilVentes.getRowIndex() == 4) {
            this.choixLigne = "produitSansTarif";
            this.produitSansTarif();
         } else if (this.dataModelUtilVentes.getRowIndex() == 5) {
            this.choixLigne = "libelleDocProduitVtes";
            this.libelleDocProduitVtes();
         } else if (this.dataModelUtilVentes.getRowIndex() == 6) {
            this.choixLigne = "affectationTarifProduitVtes";
            this.choixModule = "executionUtilitaires";
            this.var_info = "";
            this.var_currentValue = 0;
            this.listeTarif = new ArrayList();
            this.dataModelTarif = new ListDataModel();
            LectureFamillesClients var1 = new LectureFamillesClients();
            var1.setStrId(this.structureLog.getStrid());
            var1.setStructureLog(this.structureLog);
            var1.chargerMesFamillesClientItems();
            this.listeTarif = var1.getMesFamillesClients();
            this.dataModelTarif.setWrappedData(this.listeTarif);
            this.listeFamilleVtes = new ArrayList();
            this.dataModelFamille = new ListDataModel();
            FamillesProduitsVentesDao var2 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
            new ExercicesVentes();
            ExercicesVentes var3 = this.exercicesVentesDao.recupererLastExo((Session)null);
            if (var3 != null) {
               this.listeFamilleVtes = var2.selectAllFamillUtil(var3.getExevteId(), (Session)null);
            }

            this.dataModelFamille.setWrappedData(this.listeFamilleVtes);
         } else if (this.dataModelUtilVentes.getRowIndex() == 7) {
            this.choixLigne = "geneBlsurFactureDirecte";
            this.geneBlsurFactureDirecte();
         } else if (this.dataModelUtilVentes.getRowIndex() == 8) {
            this.choixLigne = "geneSoldeFacture";
            this.geneSoldeFactureVentes();
         } else if (this.dataModelUtilVentes.getRowIndex() == 9) {
            this.choixLigne = "geneEcheanceFacture";
            this.geneEcheanceFactureVentes();
         } else if (this.dataModelUtilVentes.getRowIndex() == 10) {
            this.choixLigne = "recalculNumMemoBlFactureAvoir";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilVentes.getRowIndex() == 11) {
            this.choixLigne = "recalculPuTTC";
            this.recalculPuTTC();
         } else if (this.dataModelUtilVentes.getRowIndex() == 12) {
            this.choixLigne = "recalculBcBl";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilVentes.getRowIndex() == 13) {
            this.choixLigne = "recalculQteLivree";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilVentes.getRowIndex() == 14) {
            this.choixLigne = "recalculConnexionLivree";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
         } else if (this.dataModelUtilVentes.getRowIndex() == 15) {
            this.choixLigne = "recalculConnexionDCLRNFA";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
         } else if (this.dataModelUtilVentes.getRowIndex() == 16) {
            this.choixLigne = "generationReglementFacture";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
         } else if (this.dataModelUtilVentes.getRowIndex() == 17) {
            this.choixLigne = "recalculActiviteEnteteProduit";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
         } else if (this.dataModelUtilVentes.getRowIndex() == 18) {
            this.choixLigne = "recalculQteLivreeCMD";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
         } else if (this.dataModelUtilVentes.getRowIndex() == 19) {
            this.choixLigne = "recalculTimbreDocreglement";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
         } else if (this.dataModelUtilVentes.getRowIndex() == 20) {
            this.choixLigne = "recalculDateFactureBl";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
         } else if (this.dataModelUtilVentes.getRowIndex() == 21) {
            this.choixLigne = "correctionFamilleVente";
            this.correctionFamilleVente();
         } else if (this.dataModelUtilVentes.getRowIndex() == 22) {
            this.choixLigne = "recalculGroupeTiers";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
         } else if (this.dataModelUtilVentes.getRowIndex() == 23) {
            this.choixLigne = "purgeDoublonTracabiliteVentes";
            this.purgeDoublonTracabiliteVentes();
         } else if (this.dataModelUtilVentes.getRowIndex() == 24) {
            this.choixLigne = "familesDocProduitVtes";
            this.famillesDocProduitVtes();
         } else if (this.dataModelUtilVentes.getRowIndex() == 25) {
            this.choixLigne = "recalculTVADCLRNFA";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
         } else if (this.dataModelUtilVentes.getRowIndex() == 26) {
            this.choixLigne = "recalculDerniereDatesVtes";
            this.recalculDerniereDatesVtes();
         } else if (this.dataModelUtilVentes.getRowIndex() == 27) {
            this.choixLigne = "recalculDernierReglementCommande";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilVentes.getRowIndex() == 28) {
            this.choixLigne = "enleveStockSansAchat";
            this.enleveStockSansAchat();
         } else if (this.dataModelUtilVentes.getRowIndex() == 29) {
            this.choixLigne = "livraisonBllivres";
            this.livraisonBllivres();
         } else if (this.dataModelUtilVentes.getRowIndex() == 30) {
            this.choixLigne = "suppressionDocumentVente";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilVentes.getRowIndex() == 31) {
            this.choixLigne = "factureZeroRecupBlDocumentVente";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         }

         this.mAJEspion(this.choixModule + " : " + this.choixLigne);
      }

   }

   public void aiguillageUtilitairesMedical() throws SAXException, IOException, JDOMException, NamingException, HibernateException, ParseException {
      this.choixModule = "moduleUtilitaires";
      if (this.dataModelUtilMedical.isRowAvailable()) {
         if (this.dataModelUtilMedical.getRowIndex() == 0) {
            this.choixLigne = "connexionAyantDroitsAssures";
            this.connexionAyantDroitsAssures();
         } else if (this.dataModelUtilMedical.getRowIndex() == 1) {
            this.choixLigne = "majPatientPec";
            this.majPatientsPec();
         } else if (this.dataModelUtilMedical.getRowIndex() == 2) {
            this.choixLigne = "fusionPatients";
            this.choixModule = "executionUtilitaires";
            this.var_info = "";
            this.var_currentValue = 0;
            this.chargerLesPatients();
         } else if (this.dataModelUtilMedical.getRowIndex() == 3) {
            this.choixLigne = "suppressionDocumentMedicaux";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilMedical.getRowIndex() == 4) {
            this.choixLigne = "recalculDocumentMedicaux";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilMedical.getRowIndex() == 5) {
            this.choixLigne = "annuleTransfertMedical";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
            this.lesDocumentsEntete.clear();
            this.dataModelDocumentEntete.setWrappedData(this.lesDocumentsEntete);
         } else if (this.dataModelUtilMedical.getRowIndex() == 6) {
            this.choixLigne = "forceTransfertMedical";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilMedical.getRowIndex() == 7) {
            this.choixLigne = "recalculEtatDocumentMedicaux";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         }

         this.mAJEspion(this.choixModule + " : " + this.choixLigne);
      }

   }

   public void aiguillageUtilitairesParc() throws SAXException, IOException, JDOMException, NamingException {
      this.choixModule = "moduleUtilitaires";
      if (this.dataModelUtilParc.isRowAvailable()) {
         if (this.dataModelUtilParc.getRowIndex() == 0) {
            this.choixLigne = "deverrouillageManifestes";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         }

         this.mAJEspion(this.choixModule + " : " + this.choixLigne);
      }

   }

   public void aiguillageUtilitairesPaye() throws SAXException, IOException, JDOMException, NamingException, ParseException {
      this.choixModule = "moduleUtilitaires";
      if (this.dataModelUtilPaye.isRowAvailable()) {
         if (this.dataModelUtilPaye.getRowIndex() == 0) {
            this.choixLigne = "recalculBulletin";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilPaye.getRowIndex() == 1) {
            this.choixLigne = "suppressionBulletinSalaire";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilPaye.getRowIndex() == 2) {
            this.choixLigne = "recalculPrets";
            this.recalculPrets();
         } else if (this.dataModelUtilPaye.getRowIndex() == 3) {
            this.choixLigne = "recalculSalaries";
            this.recalculSalaries();
         } else if (this.dataModelUtilPaye.getRowIndex() == 4) {
            this.choixLigne = "declotureBulletin";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
            this.calculRegroupementBulletin();
         } else if (this.dataModelUtilPaye.getRowIndex() == 5) {
            this.choixLigne = "annuleTransfertBulletin";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilPaye.getRowIndex() == 6) {
            this.choixLigne = "effaceSemaphoresPreparations";
            this.effaceSemaphoresPreparation();
         } else if (this.dataModelUtilPaye.getRowIndex() == 7) {
            this.choixLigne = "effaceSemaphoresGenerations";
            this.effaceSemaphoresGeneration();
         } else if (this.dataModelUtilPaye.getRowIndex() == 8) {
            this.choixLigne = "recalculBulletinColA";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilPaye.getRowIndex() == 9) {
            this.choixLigne = "recalculLibelleService";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilPaye.getRowIndex() == 10) {
            this.choixLigne = "recalculNumeroSemaineCP";
            this.recalculNumeroSemaineCP();
         } else if (this.dataModelUtilPaye.getRowIndex() == 11) {
            this.choixLigne = "generationSalairesUsers";
            this.generationSalairesUsers();
         } else if (this.dataModelUtilPaye.getRowIndex() == 12) {
            this.choixLigne = "recalculPrets";
            this.recalculPretsRegenerationEchaences();
         } else if (this.dataModelUtilPaye.getRowIndex() == 13) {
            this.choixLigne = "recopieNatureSalaireContrat";
            this.recopieNatureSalaireContrat();
         } else if (this.dataModelUtilPaye.getRowIndex() == 14) {
            this.choixLigne = "recalculBaseConventionneeContrat";
            this.recalculBaseConventionneeContrat();
         } else if (this.dataModelUtilPaye.getRowIndex() == 15) {
            this.choixLigne = "saisieTurboBulletins";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_salarie = 0L;
            this.var_info = "";
            this.var_currentValue = 0;
            this.preparationSaisieTurbo();
         } else if (this.dataModelUtilPaye.getRowIndex() == 16) {
            this.choixLigne = "geneationContratSalaries";
            this.geneationContratSalaries();
         } else if (this.dataModelUtilPaye.getRowIndex() == 17) {
            this.choixLigne = "recalculSecuCNSSAMO";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilPaye.getRowIndex() == 18) {
            this.choixLigne = "recalculCompteursConges";
            this.recalculCompteursConges();
         } else if (this.dataModelUtilPaye.getRowIndex() == 19) {
            this.choixLigne = "recalculPlanPayeBulletin";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilPaye.getRowIndex() == 20) {
            this.choixLigne = "recalculPlanPayeVariables";
            this.recalculPlanPayeVariables();
         } else if (this.dataModelUtilPaye.getRowIndex() == 21) {
            this.choixLigne = "recopiTiersSalaireContrat";
            this.recopieTiersSalaireContrat();
         } else if (this.dataModelUtilPaye.getRowIndex() == 22) {
            this.choixLigne = "recalculBulletinInformations";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilPaye.getRowIndex() == 23) {
            this.choixLigne = "recalculBasesConges";
            this.recalculBasesConges();
         } else if (this.dataModelUtilPaye.getRowIndex() == 24) {
            this.choixLigne = "recopieVariableM";
            this.recopieVariableM();
         } else if (this.dataModelUtilPaye.getRowIndex() == 25) {
            this.choixLigne = "recalculSalarieRH";
            this.recalculSalarieRH();
         } else if (this.dataModelUtilPaye.getRowIndex() == 26) {
            this.choixLigne = "effacerVariablesRAZ";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
            this.calculRegroupementBulletin();
         } else if (this.dataModelUtilPaye.getRowIndex() == 27) {
            this.choixLigne = "effacerVariablesDoublons";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
            this.calculRegroupementBulletin();
         } else if (this.dataModelUtilPaye.getRowIndex() == 28) {
            this.choixLigne = "recalculClesBulletinsMois";
            this.recalculClesBulletinsMois();
         } else if (this.dataModelUtilPaye.getRowIndex() == 29) {
            this.choixLigne = "recopieMatriculeBulletinElement";
            this.recopieMatriculeBulletinElement();
         } else if (this.dataModelUtilPaye.getRowIndex() == 30) {
            this.choixLigne = "recopieBulletinMatricule";
            this.recopieBulletinMatricule();
         }

         this.mAJEspion(this.choixModule + " : " + this.choixLigne);
      }

   }

   public void aiguillageUtilitairesTreso() throws SAXException, IOException, JDOMException, NamingException, HibernateException, ParseException {
      this.choixModule = "moduleUtilitaires";
      if (this.dataModelUtilTreso.isRowAvailable()) {
         if (this.dataModelUtilTreso.getRowIndex() == 0) {
            this.choixLigne = "annuleTransfertCaisses";
            this.choixModule = "executionUtilitaires";
            this.journauxTresorerie();
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilTreso.getRowIndex() == 1) {
            this.choixLigne = "forceTransfertCaisses";
            this.choixModule = "executionUtilitaires";
            this.journauxTresorerie();
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilTreso.getRowIndex() == 2) {
            this.choixLigne = "vrtCaisseBnq";
            this.vrtCaisseBnq();
         } else if (this.dataModelUtilTreso.getRowIndex() == 3) {
            this.choixLigne = "bonEncaissReglement";
            this.bonEncaissReglement();
         } else if (this.dataModelUtilTreso.getRowIndex() == 4) {
            this.choixLigne = "recalculConnexionTiers";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
         } else if (this.dataModelUtilTreso.getRowIndex() == 5) {
            this.choixLigne = "recalculActiviteReglement";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
         } else if (this.dataModelUtilTreso.getRowIndex() == 6) {
            this.choixLigne = "recalculRecusVides";
            this.recalculRecusVides();
         } else if (this.dataModelUtilTreso.getRowIndex() == 7) {
            this.choixLigne = "suppressionDocumentTresorerie";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilTreso.getRowIndex() == 8) {
            this.choixLigne = "declotureCaissesMensuelles";
            this.choixModule = "executionUtilitaires";
            this.journauxTresorerie();
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilTreso.getRowIndex() == 9) {
            this.choixLigne = "declotureCaissesJournalieres";
            this.choixModule = "executionUtilitaires";
            this.journauxTresorerie();
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilTreso.getRowIndex() == 10) {
            this.choixLigne = "recalculClesReglements";
            this.recalculClesReglements();
         }

         this.mAJEspion(this.choixModule + " : " + this.choixLigne);
      }

   }

   public void aiguillageUtilitairesImmobilier() throws SAXException, IOException, JDOMException, NamingException, HibernateException, ParseException {
      this.choixModule = "moduleUtilitaires";
      if (this.dataModelUtilImmobilier.isRowAvailable()) {
         if (this.dataModelUtilImmobilier.getRowIndex() == 0) {
            this.choixLigne = "annuleTransfertLocation";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 1) {
            this.choixLigne = "forceTransfertLocation";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 2) {
            this.choixLigne = "annuleTransfertSyndic";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 3) {
            this.choixLigne = "forceTransfertSyndic";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 4) {
            this.choixLigne = "annuleTransfertNegoce";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 5) {
            this.choixLigne = "forceTransfertNegoce";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 6) {
            this.choixLigne = "recalculBiens";
            this.recalculBiens();
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 7) {
            this.choixLigne = "recalculBaux";
            this.recalculBaux();
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 8) {
            this.choixLigne = "recalculFacture";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 9) {
            this.choixLigne = "recalculReglement";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 10) {
            this.choixLigne = "recalculReglementFactures";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 11) {
            this.choixLigne = "nettoyerTiersImmobilier";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
            this.nettoyerTiersImmobilier();
         } else if (this.dataModelUtilImmobilier.getRowIndex() == 12) {
            this.choixLigne = "suppressionDocumentImmobilier";
            this.choixModule = "executionUtilitaires";
            this.var_date_deb = null;
            this.var_date_fin = null;
            this.var_info = "";
            this.var_currentValue = 0;
         }

         this.mAJEspion(this.choixModule + " : " + this.choixLigne);
      }

   }

   public void intEvolution() throws ParseException {
      this.var_date_deb = null;
      this.var_date_fin = null;
      this.var_info = "";
      this.module = "";
      ArrayList var1 = new ArrayList();
      this.dataModelEvolution.setWrappedData(var1);
   }

   public void chargementEvolution() throws IOException, SAXException, JDOMException, HibernateException, NamingException, UnknownHostException, ParserConfigurationException, NoSuchAlgorithmException, KeyManagementException, ParseException {
      new ArrayList();
      UtilDate var2 = new UtilDate();
      String var3 = var2.dateToStringSQLLight(this.var_date_deb);
      String var4 = var2.dateToStringSQLLight(this.var_date_fin);
      LectureEvolution var5 = new LectureEvolution(var3, var4, this.module, this.var_info);
      List var1 = var5.getLesEvolutions();
      this.dataModelEvolution.setWrappedData(var1);
   }

   public void annulePlansAnalytiques() {
      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
   }

   private void close(Folder var1) {
      if (var1 != null && var1.isOpen()) {
         try {
            var1.close(false);
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      }

   }

   public void fusionTiers() throws NamingException, HibernateException, ParseException {
      this.tiersOrigine = this.tiersDao.selectTierD(this.idOrigine);
      if (this.tiersOrigine != null) {
         this.tiersDestinataire = this.tiersDao.selectTierD(this.idDestinataire);
         if (this.tiersDestinataire != null) {
            if (this.tiersOrigine.getTieid() != this.tiersDestinataire.getTieid()) {
               if (this.tiersOrigine.getTiegenre().equals(this.tiersDestinataire.getTiegenre())) {
                  this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
                  Espion var1 = new Espion();
                  var1.setEspdtecreat(new Date());
                  var1.setUsers(this.usersLog);
                  var1.setEspaction("fusion du tiers " + this.tiersOrigine.getTieid() + " " + this.tiersOrigine.getTieraisonsocialenom() + " vers le tiers " + this.tiersDestinataire.getTieid() + " " + this.tiersDestinataire.getTieraisonsocialenom());
                  var1.setEsptype(0);
                  this.espionDao.mAJEspion(var1);
                  long var2 = this.tiersOrigine.getTieid();
                  Utilitaires_Tiers var4 = new Utilitaires_Tiers();
                  var4.fusionTiers(var2, this.tiersOrigine, this.tiersDestinataire, this.tiersDao, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate);
                  this.chargerLesTiers();
               } else {
                  this.var_showBarProg = false;
                  this.formRecherche.setMessageTexte("Le genre doit être le même");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else {
               this.var_showBarProg = false;
               this.formRecherche.setMessageTexte("Le tiers d'origine doit être différent que celui de la destination");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         }
      }

      this.tiersOrigine = new Tiers();
      this.tiersDestinataire = new Tiers();
      this.idOrigine = 0L;
      this.genreOrigine = "";
      this.compteOrigine = "";
      this.idDestinataire = 0L;
      this.genreDestinataire = "";
      this.compteDestinataire = "";
   }

   public void selectionTiersOrigine() throws HibernateException, NamingException {
      if (this.dataModelTiersOrigines.isRowAvailable()) {
         new Tiers();
         Tiers var1 = (Tiers)this.dataModelTiersOrigines.getRowData();
         this.idOrigine = var1.getTieid();
         this.genreOrigine = var1.getTiegenre();
         this.compteOrigine = var1.getTiecompte0();
      }

   }

   public void selectionTiersDestination() throws HibernateException, NamingException {
      if (this.dataModelTiersDestinataires.isRowAvailable()) {
         new Tiers();
         Tiers var1 = (Tiers)this.dataModelTiersDestinataires.getRowData();
         this.idDestinataire = var1.getTieid();
         this.genreDestinataire = var1.getTiegenre();
         this.compteDestinataire = var1.getTiecompte0();
      }

   }

   public void recalculTiersACreer() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Tiers A CREER à partir des documents commerciaux");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      UtilNombre var2 = new UtilNombre();
      new ArrayList();
      new Tiers();
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      String var5 = "from Tiers where tieraisonsocialenom like '%CREER%'";
      List var3 = this.tiersDao.listeTiers(var5, (Session)null);
      if (var3.size() != 0) {
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();

            for(int var8 = 0; var8 < var3.size(); ++var8) {
               Tiers var4 = (Tiers)var3.get(var8);
               long var9 = var4.getTieid();
               this.var_info = "Tiers " + var4.getTieid() + " - Nb tiers : " + var3.size();
               if (var8 != 0) {
                  double var11 = (double)var3.size();
                  double var13 = var2.myRound(var11 / (double)var8, 4);
                  double var15 = var2.myRound(100.0D / var13, 2);
                  this.var_currentValue = (int)var15;
               }

               String var26 = "";
               List var12;
               int var14;
               int var16;
               List var29;
               if (var4.getTietype().equals("0")) {
                  new ArrayList();
                  ReceptionEnteteAchatsDao var28 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                  var12 = var28.rechercheByTiers(var4, var6);
                  if (var12.size() != 0) {
                     for(var14 = 0; var14 < var12.size(); ++var14) {
                        var26 = ((ReceptionEnteteAchats)var12.get(var14)).getRecNomTiers();
                        if (var26 != null && !var26.isEmpty()) {
                           break;
                        }
                     }
                  }

                  if (var26 == null || var26.isEmpty()) {
                     new ArrayList();
                     CommandeEnteteAchatsDao var31 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                     var29 = var31.rechercheByTiers(var4, var6);
                     if (var29.size() != 0) {
                        for(var16 = 0; var16 < var29.size(); ++var16) {
                           var26 = ((CommandeEnteteAchats)var29.get(var16)).getCmdNomTiers();
                           if (var26 != null && !var26.isEmpty()) {
                              break;
                           }
                        }
                     }
                  }
               } else if (var4.getTietype().equals("3")) {
                  new ArrayList();
                  FactureEnteteVentesDao var27 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  var12 = var27.rechercheByTiers(var4, var6);
                  if (var12.size() != 0) {
                     for(var14 = 0; var14 < var12.size(); ++var14) {
                        var26 = ((FactureEnteteVentes)var12.get(var14)).getFacNomTiers();
                        if (var26 != null && !var26.isEmpty()) {
                           break;
                        }
                     }
                  }

                  if (var26 == null || var26.isEmpty()) {
                     new ArrayList();
                     LivraisonEnteteVentesDao var30 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                     var29 = var30.rechercheByTiers(var4, var6);
                     if (var29.size() != 0) {
                        for(var16 = 0; var16 < var29.size(); ++var16) {
                           var26 = ((LivraisonEnteteVentes)var29.get(var16)).getBlvNomTiers();
                           if (var26 != null && !var26.isEmpty()) {
                              break;
                           }
                        }
                     }

                     if (var26 == null || var26.isEmpty()) {
                        new ArrayList();
                        CommandeEnteteVentesDao var17 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                        List var32 = var17.rechercheByTiers(var4, var6);
                        if (var32.size() != 0) {
                           for(int var18 = 0; var18 < var32.size(); ++var18) {
                              var26 = ((CommandeEnteteVentes)var32.get(var18)).getBcmNomTiers();
                              if (var26 != null && !var26.isEmpty()) {
                                 break;
                              }
                           }
                        }

                        if (var26 == null || var26.isEmpty()) {
                           new ArrayList();
                           DevisEnteteVentesDao var19 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                           List var33 = var19.rechercheByTiers(var4, var6);
                           if (var33.size() != 0) {
                              for(int var20 = 0; var20 < var33.size(); ++var20) {
                                 var26 = ((DevisEnteteVentes)var33.get(var20)).getDvsNomTiers();
                                 if (var26 != null && !var26.isEmpty()) {
                                    break;
                                 }
                              }
                           }
                        }
                     }
                  }
               }

               if (var26 != null & !var26.isEmpty()) {
                  var4 = this.tiersDao.selectTierD(var9, var6);
                  var4.setTieraisonsocialenom(var26);
                  var4.setTiesigle("");
                  var4.setTiecompte0("");
                  var4.setTiecompte1("");
                  var4.setTiecompte2("");
                  var4.setTiecompte3("");
                  var4.setTiecompte4("");
                  var4.setTieadresse("");
                  var4.setTiebp("");
                  var4.setTieburtel1("");
                  var4.setTieburtel2("");
                  var4.setTieburtel3("");
                  var4.setTieburfax("");
                  this.tiersDao.modif(var4, var6);
               }
            }

            var7.commit();
         } catch (HibernateException var24) {
            if (var7 != null) {
               var7.rollback();
            }

            throw var24;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void chargerLesTiers() throws HibernateException, NamingException, ParseException {
      this.lesTiersOrigines = new ArrayList();
      this.lesTiersDestinataires = new ArrayList();
      this.dataModelTiersOrigines = new ListDataModel();
      this.dataModelTiersDestinataires = new ListDataModel();
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.lesTiersOrigines = this.tiersDao.chargerLesTiers("100", (Session)null);
      if (this.lesTiersOrigines.size() != 0) {
         for(int var1 = 0; var1 < this.lesTiersOrigines.size(); ++var1) {
            this.tiersOrigine = (Tiers)this.lesTiersOrigines.get(var1);
            this.lesTiersDestinataires.add(this.tiersOrigine);
         }
      }

      this.dataModelTiersOrigines.setWrappedData(this.lesTiersOrigines);
      this.dataModelTiersDestinataires.setWrappedData(this.lesTiersDestinataires);
      this.tiersOrigine = new Tiers();
      this.tiersDestinataire = new Tiers();
      this.idOrigine = 0L;
      this.genreOrigine = "";
      this.compteOrigine = "";
      this.idDestinataire = 0L;
      this.genreDestinataire = "";
      this.compteDestinataire = "";
   }

   public void flagMails() throws ParseException, HibernateException, NamingException {
      if (this.bal != null && this.var_date_deb != null && this.var_date_fin != null) {
         UtilDate var1 = new UtilDate();
         String var2 = var1.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         Date var3 = var1.stringToDateSQL(var2);
         String var4 = var1.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         Date var5 = var1.stringToDateSQL(var4);
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var6 = new Espion();
         var6.setEspdtecreat(new Date());
         var6.setUsers(this.usersLog);
         var6.setEspaction("flag les messages du compte " + this.bal.getBaladressemail() + " du " + var2 + " au " + var4);
         var6.setEsptype(0);
         this.espionDao.mAJEspion(var6);
         this.var_info = "Connexion en cours...";
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         if (this.bal.getBalimapport() != 0 || this.bal.getBalpopport() != 0) {
            Properties var7 = new Properties();
            Authenticator var8 = new Authenticator() {
            };
            if (this.bal.getBalimapport() != 0) {
               var7.setProperty("mail.store.protocol", "imap");
               var7.setProperty("mail.imaps.partialfetch", "false");
            } else if (this.bal.getBalpopport() != 0) {
               var7.setProperty("mail.store.protocol", "pop3");
               var7.setProperty("mail.pop3.starttls.enable", "true");
            }

            javax.mail.Session var9 = javax.mail.Session.getDefaultInstance(var7, var8);
            Store var10 = null;
            Folder var11 = null;
            Folder var12 = null;

            try {
               var9.setDebug(false);
               if (this.bal.getBalimapport() != 0) {
                  var10 = var9.getStore("imaps");
                  var10.connect(this.bal.getBalimapserveur(), this.bal.getBalimapport(), this.bal.getBaladressemail(), this.bal.getBalpw());
               } else if (this.bal.getBalpopport() != 0) {
                  var10 = var9.getStore("pop3");
                  var10.connect(this.bal.getBalpopserveur(), this.bal.getBalpopport(), this.bal.getBaladressemail(), this.bal.getBalpw());
               }

               var11 = var10.getDefaultFolder();
               var12 = var11.getFolder("INBOX");
               var12.open(2);
               int var13 = var12.getMessageCount();
               int var14 = var12.getUnreadMessageCount();
               Message[] var15 = var12.getMessages(var14, var13);
               int var16 = var15.length;

               for(int var17 = 0; var17 < var15.length; ++var17) {
                  Message var18 = var15[var17];
                  this.var_info = "Flag du message " + var17 + ", pour un total de " + var13 + " mails total ";
                  if (var17 != 0) {
                     this.var_currentValue = var17 / var16 * 100;
                  }

                  if (var18.getReceivedDate().after(var3) && var18.getReceivedDate().before(var5)) {
                     var18.setFlags(new Flags(Flag.SEEN), true);
                  }
               }
            } catch (Exception var27) {
               var27.printStackTrace();
               this.formRecherche.setMessageTexte("Erreur lecture des mails : Boite mail inaccessible");
               this.formRecherche.setShowModalPanelMessage(true);
            } finally {
               this.close(var12);
               this.close(var11);

               try {
                  if (var10 != null && var10.isConnected()) {
                     var10.close();
                  }
               } catch (MessagingException var26) {
                  var26.printStackTrace();
                  StaticModePegase.setTexte_message("Erreur bal : " + var26);
                  StaticModePegase.setAffiche_message(true);
               }

            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void deflagMails() throws ParseException, HibernateException, NamingException {
      if (this.bal != null && this.var_date_deb != null && this.var_date_fin != null) {
         UtilDate var1 = new UtilDate();
         String var2 = var1.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         Date var3 = var1.stringToDateSQL(var2);
         String var4 = var1.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         Date var5 = var1.stringToDateSQL(var4);
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var6 = new Espion();
         var6.setEspdtecreat(new Date());
         var6.setUsers(this.usersLog);
         var6.setEspaction("dé-flag les messages du compte " + this.bal.getBaladressemail() + " du " + var2 + " au " + var4);
         var6.setEsptype(0);
         this.espionDao.mAJEspion(var6);
         this.var_info = "Connexion en cours...";
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         if (this.bal.getBalimapport() != 0 || this.bal.getBalpopport() != 0) {
            Properties var7 = new Properties();
            Authenticator var8 = new Authenticator() {
            };
            if (this.bal.getBalimapport() != 0) {
               var7.setProperty("mail.store.protocol", "imap");
               var7.setProperty("mail.imaps.partialfetch", "false");
            } else if (this.bal.getBalpopport() != 0) {
               var7.setProperty("mail.store.protocol", "pop3");
               var7.setProperty("mail.pop3.starttls.enable", "true");
            }

            javax.mail.Session var9 = javax.mail.Session.getDefaultInstance(var7, var8);
            Store var10 = null;
            Folder var11 = null;
            Folder var12 = null;

            try {
               var9.setDebug(false);
               if (this.bal.getBalimapport() != 0) {
                  var10 = var9.getStore("imaps");
                  var10.connect(this.bal.getBalimapserveur(), this.bal.getBalimapport(), this.bal.getBaladressemail(), this.bal.getBalpw());
               } else if (this.bal.getBalpopport() != 0) {
                  var10 = var9.getStore("pop3");
                  var10.connect(this.bal.getBalpopserveur(), this.bal.getBalpopport(), this.bal.getBaladressemail(), this.bal.getBalpw());
               }

               var11 = var10.getDefaultFolder();
               var12 = var11.getFolder("INBOX");
               var12.open(2);
               int var13 = var12.getMessageCount();

               for(int var14 = 1; var14 <= var13; ++var14) {
                  Message var15 = var12.getMessage(var14);
                  this.var_info = "De-flag du message " + var14 + ", pour un total de " + var13 + " mails total ";
                  if (var14 != 0) {
                     this.var_currentValue = var14 / var13 * 100;
                  }

                  if (var15.getReceivedDate().after(var3) && var15.getReceivedDate().before(var5)) {
                     var15.setFlags(new Flags(Flag.SEEN), false);
                  }
               }
            } catch (Exception var24) {
               var24.printStackTrace();
               this.formRecherche.setMessageTexte("Erreur lecture des mails : Boite mail inaccessible");
               this.formRecherche.setShowModalPanelMessage(true);
            } finally {
               this.close(var12);
               this.close(var11);

               try {
                  if (var10 != null && var10.isConnected()) {
                     var10.close();
                  }
               } catch (MessagingException var23) {
                  var23.printStackTrace();
                  StaticModePegase.setTexte_message("Erreur bal : " + var23);
                  StaticModePegase.setAffiche_message(true);
               }

            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void chargerLesBal() throws HibernateException, NamingException, ParseException {
      this.bal = new Bal();
      this.lesBal = new ArrayList();
      this.lesBalsItems = new ArrayList();
      this.balDao = new BalDao(this.baseLog, this.utilInitHibernate);
      this.lesBal = this.balDao.selectBal();
      if (this.lesBal.size() != 0) {
         for(int var1 = 0; var1 < this.lesBal.size(); ++var1) {
            this.bal = (Bal)this.lesBal.get(var1);
            this.lesBalsItems.add(new SelectItem(this.bal.getBalid(), this.bal.getBaladressemail()));
         }
      }

      this.bal = null;
   }

   public void selectionBal() throws HibernateException, NamingException {
      if (this.balSelectionnee != null && !this.balSelectionnee.isEmpty() && !this.balSelectionnee.equals("0")) {
         long var1 = Long.parseLong(this.balSelectionnee);
         this.bal = this.balDao.logBal(var1);
      }

   }

   public void verificationPj() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("vérification des pièces jointes");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "mails" + File.separator + "reception" + File.separator;
      File var3 = new File(var2);
      ArrayList var4 = new ArrayList();
      String[] var5 = var3.list();
      if (var5 != null) {
         for(int var6 = 0; var6 < var5.length; ++var6) {
            String var7 = var5[var6];
            var4.add(var7);
         }
      }

      if (var4.size() != 0) {
         boolean var23 = false;
         new ArrayList();
         new MailsPj();
         MailsPJDao var9 = new MailsPJDao(this.baseLog, this.utilInitHibernate);
         File var10 = null;
         new Mails();
         MailsDao var12 = new MailsDao(this.baseLog, this.utilInitHibernate);
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
         Transaction var14 = null;

         try {
            var14 = var13.beginTransaction();

            for(int var15 = 0; var15 < var4.size(); ++var15) {
               String var16 = "";
               if (((String)var4.get(var15)).toString().contains(":")) {
                  String[] var17 = ((String)var4.get(var15)).toString().split(":");
                  var16 = var17[0];
               } else {
                  var16 = ((String)var4.get(var15)).toString();
               }

               Mails var11 = var12.rechercheMails(var16, var13);
               if (var11 == null) {
                  var10 = new File(var2 + ((String)var4.get(var15)).toString());
                  if (var10.exists()) {
                     var10.delete();
                  }
               } else {
                  var23 = false;
                  List var24 = var9.chargerMailsPJ(var11, var13);
                  MailsPj var8;
                  if (var24.size() != 0) {
                     for(int var25 = 0; var25 < var24.size(); ++var25) {
                        var8 = (MailsPj)var24.get(var25);
                        if (var8.getMalpjAcces().equals(((String)var4.get(var15)).toString())) {
                           var23 = true;
                           break;
                        }
                     }
                  }

                  if (!var23) {
                     var8 = new MailsPj();
                     var8.setMails(var11);
                     var8.setMalpjAcces(((String)var4.get(var15)).toString());
                     var9.insertMailPj(var8, var13);
                     var11.setMaiPj(1);
                     var12.modifMail(var11, var13);
                  }
               }
            }

            var14.commit();
         } catch (HibernateException var21) {
            if (var14 != null) {
               var14.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void reimputationTiers() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des réimputations des tiers (suspects, prospects, clients)");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Chargement des tiers....";
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      Object var3 = new ArrayList();
      DevisEnteteVentesDao var4 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      Object var5 = new ArrayList();
      CommandeEnteteVentesDao var6 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      Object var7 = new ArrayList();
      LivraisonEnteteVentesDao var8 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      Object var9 = new ArrayList();
      FactureEnteteVentesDao var10 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      Object var11 = new ArrayList();
      FactureInterneEnteteVentesDao var12 = new FactureInterneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      Object var13 = new ArrayList();
      NoteDebitEnteteVentesDao var14 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      Object var15 = new ArrayList();
      BienFactureDao var16 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
      Object var17 = new ArrayList();
      FactureEnteteMedicalDao var18 = new FactureEnteteMedicalDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new Tiers();
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      List var19 = this.tiersDao.chargerLesTiers("102", (Session)null);
      if (var19.size() != 0) {
         Session var21 = null;
         if (this.typeVente == 816) {
            var21 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         } else if (this.typeVente == 815) {
            var21 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         } else {
            var21 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         }

         Transaction var22 = null;

         try {
            var22 = var21.beginTransaction();
            var21.setFlushMode(FlushMode.MANUAL);

            for(int var23 = 0; var23 < var19.size(); ++var23) {
               Tiers var20 = (Tiers)var19.get(var23);
               long var24 = var20.getTieid();
               this.var_info = "Tier " + var20.getTieraisonsocialenom() + " Numero " + var23 + ", pour un total de " + var19.size() + " total ";
               if (var23 != 0) {
                  double var26 = (double)var19.size();
                  double var28 = var2.myRound(var26 / (double)var23, 4);
                  double var30 = var2.myRound(100.0D / var28, 2);
                  this.var_currentValue = (int)var30;
               }

               ((List)var3).clear();
               ((List)var5).clear();
               ((List)var7).clear();
               ((List)var9).clear();
               ((List)var11).clear();
               ((List)var13).clear();
               ((List)var15).clear();
               if (this.typeVente == 816) {
                  var15 = var16.verifByTiers(var20, var21);
               } else if (this.typeVente == 815) {
                  var3 = var4.verifByTiers(var20, var21);
                  var17 = var18.verifByTiers(var20, var21);
               } else {
                  var3 = var4.verifByTiers(var20, var21);
                  var5 = var6.verifByTiers(var20, var21);
                  var7 = var8.verifByTiers(var20, var21);
                  var9 = var10.verifByTiers(var20, var21);
                  var11 = var12.verifByTiers(var20, var21);
                  var13 = var14.verifByTiers(var20, var21);
               }

               var20 = this.tiersDao.selectTierD(var24, var21);
               if (var20 != null) {
                  if (!var20.getTiegenre().equals("010") && !var20.getTiegenre().equals("020") && !var20.getTiegenre().equals("030") && !var20.getTiegenre().equals("070")) {
                     if (((List)var5).size() == 0 && ((List)var7).size() == 0 && ((List)var9).size() == 0 && ((List)var11).size() == 0 && ((List)var13).size() == 0 && ((List)var15).size() == 0 && ((List)var17).size() == 0) {
                        if (((List)var3).size() != 0 && ((List)var5).size() == 0 && ((List)var7).size() == 0 && ((List)var9).size() == 0 && ((List)var11).size() == 0 && ((List)var13).size() == 0 && ((List)var15).size() == 0 && ((List)var17).size() == 0) {
                           var20.setTietype("2");
                           if (this.typeVente != 815) {
                              if (this.typeVente == 816) {
                                 var20.setTiecategorie("Prospect Société");
                              } else {
                                 var20.setTiecategorie("Prospect Société");
                              }
                           }

                           var20.setTiegenre("021");
                        } else {
                           var20.setTietype("1");
                           if (this.typeVente != 815) {
                              if (this.typeVente == 816) {
                                 var20.setTiecategorie("Suspect Société");
                              } else {
                                 var20.setTiecategorie("Suspect Société");
                              }
                           }

                           var20.setTiegenre("011");
                        }
                     } else {
                        var20.setTietype("3");
                        if (this.typeVente == 815) {
                           var20.setTiegenre("031");
                        } else if (this.typeVente == 816) {
                           var20.setTiecategorie("Locataire Société");
                           var20.setTiegenre("071");
                        } else {
                           var20.setTiecategorie("Client Société");
                           var20.setTiegenre("031");
                        }
                     }

                     this.tiersDao.modif(var20, var21);
                     var21.flush();
                  } else {
                     if (((List)var5).size() == 0 && ((List)var7).size() == 0 && ((List)var9).size() == 0 && ((List)var11).size() == 0 && ((List)var13).size() == 0 && ((List)var15).size() == 0 && ((List)var17).size() == 0) {
                        if (((List)var3).size() != 0 && ((List)var5).size() == 0 && ((List)var7).size() == 0 && ((List)var9).size() == 0 && ((List)var11).size() == 0 && ((List)var13).size() == 0 && ((List)var15).size() == 0 && ((List)var17).size() == 0) {
                           var20.setTietype("2");
                           if (this.typeVente == 815) {
                              var20.setTiecategorie("Prospect Individuel");
                           } else if (this.typeVente == 816) {
                              var20.setTiecategorie("Prospect Individuel");
                           } else {
                              var20.setTiecategorie("Prospect Individuel");
                           }

                           var20.setTiegenre("020");
                        } else {
                           var20.setTietype("1");
                           if (this.typeVente == 815) {
                              var20.setTiecategorie("Suspect Individuel");
                           } else if (this.typeVente == 816) {
                              var20.setTiecategorie("Suspect Individuel");
                           } else {
                              var20.setTiecategorie("Suspect Individuel");
                           }

                           var20.setTiegenre("010");
                        }
                     } else {
                        var20.setTietype("3");
                        if (this.typeVente == 815) {
                           var20.setTiegenre("030");
                        } else if (this.typeVente == 816) {
                           var20.setTiecategorie("Locataire Individuel");
                           var20.setTiegenre("070");
                        } else {
                           var20.setTiecategorie("Client Individuel");
                           var20.setTiegenre("030");
                        }
                     }

                     this.tiersDao.modif(var20, var21);
                     var21.flush();
                  }
               }
            }

            var22.commit();
         } catch (HibernateException var35) {
            if (var22 != null) {
               var22.rollback();
            }

            throw var35;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void codageTexte() throws HibernateException, NamingException, ParseException, groovyjarjarcommonscli.ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("chiffrement de césar des tiers, des salaries et des users)");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Chargement des tiers....";
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      FormChiffrementCesar var2 = new FormChiffrementCesar(this.utilInitHibernate, this.baseLog, this.structureLog, this.usersLog);
      var2.setFormUtilitaires(this);
      var2.codageTexte();
      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void chargerLesSignataires() throws HibernateException, NamingException, ParseException {
      this.lesParapheurs = new ArrayList();
      this.dataModelParapheur = new ListDataModel();
      this.mesUsersOriginesItems = new ArrayList();
      this.mesUsersDestinataresItems = new ArrayList();
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var1 = this.userDao.chargerLesSignataires("TOUS", (Session)null);
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.mesUsersOriginesItems.add(new SelectItem(((Users)var1.get(var2)).getUsrid(), ((Users)var1.get(var2)).getUsrid() + ":" + ((Users)var1.get(var2)).getUsrPatronyme() + ":" + ((Users)var1.get(var2)).getUsrFonction()));
            this.mesUsersDestinataresItems.add(new SelectItem(((Users)var1.get(var2)).getUsrid(), ((Users)var1.get(var2)).getUsrid() + ":" + ((Users)var1.get(var2)).getUsrPatronyme() + ":" + ((Users)var1.get(var2)).getUsrFonction()));
         }
      }

      this.userIdOrigine = 0L;
      this.userIdDestinataire = 0L;
   }

   public void rechercherParapheur() throws HibernateException, NamingException {
      this.lesParapheurs.clear();
      ParapheurDao var1 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      this.lesParapheurs = var1.selectListTransfert(this.userIdOrigine, 0, this.var_date_deb, this.var_date_fin, (Session)null);
      this.dataModelParapheur.setWrappedData(this.lesParapheurs);
   }

   public void selectionElement() {
      if (this.dataModelParapheur.isRowAvailable()) {
         this.parapheur = (Parapheur)this.dataModelParapheur.getRowData();
      }

   }

   public void toutELementDeSelectionner() {
      this.parapheur = new Parapheur();
      if (this.lesParapheurs.size() != 0) {
         for(int var1 = 0; var1 < this.lesParapheurs.size(); ++var1) {
            this.parapheur = (Parapheur)this.lesParapheurs.get(var1);
            this.parapheur.setSelect(false);
         }

         this.dataModelEcrituresDetruites.setWrappedData(this.lesParapheurs);
      }

   }

   public void toutElementSelectionner() {
      this.parapheur = new Parapheur();
      if (this.lesParapheurs.size() != 0) {
         for(int var1 = 0; var1 < this.lesParapheurs.size(); ++var1) {
            this.parapheur = (Parapheur)this.lesParapheurs.get(var1);
            this.parapheur.setSelect(true);
         }

         this.dataModelEcrituresDetruites.setWrappedData(this.lesParapheurs);
      }

   }

   public void transfertParapheur() throws NamingException {
      if (this.userIdOrigine != 0L && this.userIdDestinataire != 0L && this.userIdOrigine != this.userIdDestinataire && this.var_date_deb != null && this.var_date_fin != null && this.lesParapheurs.size() != 0) {
         UtilDate var1 = new UtilDate();
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var2 = new Espion();
         var2.setEspdtecreat(new Date());
         var2.setUsers(this.usersLog);
         var2.setEspaction("Transfert element paraphaeur du user " + this.userIdOrigine + " vers le user " + this.userIdDestinataire + " du " + var1.dateToStringSQLLight(this.var_date_deb) + " au " + var1.dateToStringSQLLight(this.var_date_deb));
         var2.setEsptype(0);
         this.espionDao.mAJEspion(var2);
         this.var_info = "Chargement des tiers....";
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parapheur");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new Users();
            Users var5 = this.userDao.selectUserD(this.userIdDestinataire, var3);
            if (var5 != null) {
               this.parapheur = new Parapheur();
               ParapheurDao var6 = new ParapheurDao(this.baseLog, this.utilInitHibernate);

               for(int var7 = 0; var7 < this.lesParapheurs.size(); ++var7) {
                  this.parapheur = (Parapheur)this.lesParapheurs.get(var7);
                  if (this.parapheur.isSelect()) {
                     if (this.parapheur.getPhrUser1Id() == this.userIdOrigine) {
                        this.parapheur.setPhrUser1Id(var5.getUsrid());
                        this.parapheur.setPhrUser1Nom(var5.getUsrPatronyme());
                        this.parapheur = var6.modif(this.parapheur, var3);
                     }

                     if (this.parapheur.getPhrUser2Id() == this.userIdOrigine) {
                        this.parapheur.setPhrUser2Id(var5.getUsrid());
                        this.parapheur.setPhrUser2Nom(var5.getUsrPatronyme());
                        this.parapheur = var6.modif(this.parapheur, var3);
                     }

                     if (this.parapheur.getPhrUser3Id() == this.userIdOrigine) {
                        this.parapheur.setPhrUser3Id(var5.getUsrid());
                        this.parapheur.setPhrUser3Nom(var5.getUsrPatronyme());
                        this.parapheur = var6.modif(this.parapheur, var3);
                     }

                     if (this.parapheur.getPhrUser4Id() == this.userIdOrigine) {
                        this.parapheur.setPhrUser4Id(var5.getUsrid());
                        this.parapheur.setPhrUser4Nom(var5.getUsrPatronyme());
                        this.parapheur = var6.modif(this.parapheur, var3);
                     }

                     if (this.parapheur.getPhrUser5Id() == this.userIdOrigine) {
                        this.parapheur.setPhrUser5Id(var5.getUsrid());
                        this.parapheur.setPhrUser5Nom(var5.getUsrPatronyme());
                        this.parapheur = var6.modif(this.parapheur, var3);
                     }

                     if (this.parapheur.getPhrUser6Id() == this.userIdOrigine) {
                        this.parapheur.setPhrUser6Id(var5.getUsrid());
                        this.parapheur.setPhrUser6Nom(var5.getUsrPatronyme());
                        this.parapheur = var6.modif(this.parapheur, var3);
                     }
                  }
               }
            }

            var4.commit();
         } catch (HibernateException var11) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.lesParapheurs = new ArrayList();
      this.dataModelParapheur = new ListDataModel();
      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculNatureCompteEcriture() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Nature Compte Ecriture");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Chargement des ecritures en cours...";
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      this.lesEcritures = new ArrayList();
      new Ecritures();
      EcrituresDao var4 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new PlanComptable();
      PlanComptableDao var7 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var9 = null;

      try {
         var9 = var8.beginTransaction();
         var8.setFlushMode(FlushMode.MANUAL);
         List var5 = var4.chargerCompte(this.var_date_deb, this.var_date_fin, var8);
         if (var5.size() != 0) {
            for(int var10 = 0; var10 < var5.size(); ++var10) {
               String var11 = ((String)var5.get(var10)).toString();
               String var12 = this.structureLog.getStrzonefiscale();
               if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.structureLog.getStrdatefiscale2() != null && this.var_date_fin.compareTo(this.structureLog.getStrdatefiscale2()) > 0) {
                  var12 = this.structureLog.getStrzonefiscale2();
               }

               PlanComptable var6 = var7.chercherCompte(var12, var11, 0L, var8);
               if (var6 != null) {
                  this.var_info = "Compte: " + var11;
                  if (var10 != 0) {
                     double var13 = (double)var5.size();
                     double var15 = var2.myRound(var13 / (double)var10, 4);
                     double var17 = var2.myRound(100.0D / var15, 2);
                     this.var_currentValue = (int)var17;
                  }

                  this.lesEcritures = var4.chargerEcrituresByCompte(this.var_date_deb, this.var_date_fin, var11, var8);

                  for(int var24 = 0; var24 < this.lesEcritures.size(); ++var24) {
                     Ecritures var3 = (Ecritures)this.lesEcritures.get(var24);
                     var3.setEcrNature(var6.getPlcNature());
                     var4.modif(var3, var8);
                  }

                  var8.flush();
               }
            }
         }

         var9.commit();
      } catch (HibernateException var22) {
         if (var9 != null) {
            var9.rollback();
         }

         throw var22;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculNatureJournauxEcriture() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Nature Journaux Ecriture");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Chargement des ecritures en cours...";
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      this.lesEcritures = new ArrayList();
      new Ecritures();
      EcrituresDao var4 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new JournauxComptables();
      JournauxComptablesDao var7 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var9 = null;

      try {
         var9 = var8.beginTransaction();
         var8.setFlushMode(FlushMode.MANUAL);
         List var5 = var4.chargerJournaux(this.var_date_deb, this.var_date_fin, var8);
         if (var5.size() != 0) {
            for(int var10 = 0; var10 < var5.size(); ++var10) {
               String var11 = ((String)var5.get(var10)).toString();
               JournauxComptables var6 = var7.chercherCode(var11, 0L, var8);
               if (var6 != null) {
                  this.var_info = "Journal: " + var11;
                  if (var10 != 0) {
                     double var12 = (double)var5.size();
                     double var14 = var2.myRound(var12 / (double)var10, 4);
                     double var16 = var2.myRound(100.0D / var14, 2);
                     this.var_currentValue = (int)var16;
                  }

                  this.lesEcritures = var4.chargerEcritures(this.var_date_deb, this.var_date_fin, var11, var8);

                  for(int var23 = 0; var23 < this.lesEcritures.size(); ++var23) {
                     Ecritures var3 = (Ecritures)this.lesEcritures.get(var23);
                     var3.setEcrNatureJrx(var6.getPljNature());
                     var4.modif(var3, var8);
                  }

                  var8.flush();
               }
            }
         }

         var9.commit();
      } catch (HibernateException var21) {
         if (var9 != null) {
            var9.rollback();
         }

         throw var21;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void transfertPlansAnalytiques() throws HibernateException, NamingException {
      if (this.var_plan_origine != this.var_plan_destination) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("transfert Plans Analytiques");
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            if (this.var_plan_origine == 0) {
               new ArrayList();
               ActivitesDao var5 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
               PlansAnalytiquesDao var6 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
               List var4 = var5.selectActivites(var2);
               if (var4.size() != 0) {
                  int var7;
                  Activites var8;
                  if (this.var_plan_destination == 1) {
                     for(var7 = 0; var7 < var4.size(); ++var7) {
                        new Activites();
                        var8 = (Activites)var4.get(var7);
                        PlansAnalytiques var9 = new PlansAnalytiques();
                        var9.setAnaNature("6");
                        var9.setAnaAch(var8.isActAch());
                        var9.setAnaFrg(var8.isActFrg());
                        var9.setAnaInv(var8.isActInv());
                        var9.setAnaPrd(var8.isActPrd());
                        var9.setAnaSal(var8.isActSal());
                        var9.setAnaTax(var8.isActTax());
                        var9.setAnaTva(var8.isActTva());
                        var9.setAnaVte(var8.isActVte());
                        var9.setAnaCode(var8.getActCode());
                        var9.setAnaAnneeDebut(var8.getActAnneeDebut());
                        var9.setAnaAnneeFin(var8.getActAnneeFin());
                        var9.setAnaInactif(var8.getActInactif());
                        var9.setAnaNomFr(var8.getActNomFr());
                        var9.setAnaNomSp(var8.getActNomSp());
                        var9.setAnaNomUk(var8.getActNomUk());
                        var9.setAnaUserCreat(var8.getActUserCreat());
                        var9.setAnaUserModif(var8.getActUserModif());
                        var9.setAnaDateCreat(var8.getActDateCreat());
                        var9.setAnaDateModif(var8.getActDateModif());
                        var6.insert(var9, var2);
                     }
                  }

                  for(var7 = 0; var7 < var4.size(); ++var7) {
                     new Activites();
                     var8 = (Activites)var4.get(var7);
                     var5.delete(var8, var2);
                  }
               }
            } else if (this.var_plan_origine == 1) {
            }

            var3.commit();
         } catch (HibernateException var13) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var13;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void devalidationEcritures() throws HibernateException, NamingException {
      if (this.var_date_deb != null && this.var_date_fin != null && this.var_journal != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("devalidation Ecritures");
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            this.lesEcritures = new ArrayList();
            EcrituresDao var4 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
            this.lesEcritures = var4.chargerEcritures(this.var_date_deb, this.var_date_fin, this.var_journal, var2);
            if (this.lesEcritures.size() != 0) {
               new Ecritures();

               for(int var6 = 0; var6 < this.lesEcritures.size(); ++var6) {
                  Ecritures var5 = (Ecritures)this.lesEcritures.get(var6);
                  if (var5.getEcrEtat() == 1) {
                     var5.setEcrEtat(0);
                     var4.modif(var5, var2);
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
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void effaceSemaphores() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("efface Semaphores");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Utilitaires_Compta var2 = new Utilitaires_Compta(this);
      ArrayList var3 = new ArrayList();
      JournauxMois var4 = new JournauxMois();
      JournauxMoisDao var5 = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      ArrayList var6 = new ArrayList();
      JournauxJour var7 = new JournauxJour();
      JournauxJourDao var8 = new JournauxJourDao(this.baseLog, this.utilInitHibernate);
      Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
      Transaction var10 = null;

      try {
         var10 = var9.beginTransaction();
         var2.effaceSemaphores(var3, var4, var5, var6, var7, var8, this.baseLog, var9);
         var10.commit();
      } catch (HibernateException var15) {
         if (var10 != null) {
            var10.rollback();
         }

         throw var15;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.utilInitHibernate.closeSession();
      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void delettrageExercices() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("delettrage Exercices");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      Utilitaires_Compta var3 = new Utilitaires_Compta(this);
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         this.var_info = "Chargement des comptes....";
         this.lesEcritures = new ArrayList();
         new ExercicesComptable();
         ExercicesComptable var6 = this.exercicesComptableDao.recupererLastExo(var4);
         if (var6 != null) {
            var3.delettrageExercices(this.structureLog, var6, this.baseLog, this.lesEcritures, var2, this.utilInitHibernate, var4);
         }

         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void forcageTrfDotation() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("forcage Trf Dotation");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
      Transaction var3 = null;
      UtilDate var4 = new UtilDate();
      AmortissementTabDao var5 = new AmortissementTabDao(this.baseLog, this.utilInitHibernate);
      new ExercicesComptable();
      ExercicesComptable var6 = this.exercicesComptableDao.recupererLastExo(var2);
      if (var6 != null) {
         try {
            var3 = var2.beginTransaction();
            new ArrayList();
            String var8 = var4.dateToStringSQLLight(this.var_date_deb);
            String var9 = var4.dateToStringSQLLight(this.var_date_fin);
            List var7 = var5.chargerAmot(var8, var9, var2);
            if (var7.size() != 0) {
               new AmortissementTab();

               for(int var11 = 0; var11 < var7.size(); ++var11) {
                  AmortissementTab var10 = (AmortissementTab)var7.get(var11);
                  var10.setAmotabDateTrf(new Date());
                  var10.setAmotabValeur(var10.getAmotabMontant());
                  var5.modif(var10, var2);
               }
            }

            var3.commit();
         } catch (HibernateException var15) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var15;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void annulationTrfDotation() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("annule Trf Dotations");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
      Transaction var3 = null;
      UtilDate var4 = new UtilDate();
      AmortissementTabDao var5 = new AmortissementTabDao(this.baseLog, this.utilInitHibernate);
      new ExercicesComptable();
      ExercicesComptable var6 = this.exercicesComptableDao.recupererLastExo(var2);
      List var7;
      if (var6 != null) {
         try {
            var3 = var2.beginTransaction();
            new ArrayList();
            String var8 = var4.dateToStringSQLLight(this.var_date_deb);
            String var9 = var4.dateToStringSQLLight(this.var_date_fin);
            var7 = var5.chargerAmot(var8, var9, var2);
            if (var7.size() != 0) {
               new AmortissementTab();

               for(int var11 = 0; var11 < var7.size(); ++var11) {
                  AmortissementTab var10 = (AmortissementTab)var7.get(var11);
                  var10.setAmotabDateTrf((Date)null);
                  var10.setAmotabValeur(0.0D);
                  var5.modif(var10, var2);
               }
            }

            var3.commit();
         } catch (HibernateException var32) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var32;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      var7 = null;
      EcrituresDao var35 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      EcrituresAnalytiquesDao var36 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      JournauxMoisDao var37 = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      new JournauxMois();
      JournauxComptablesDao var12 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      new JournauxComptables();
      if (var6 != null) {
         JournauxComptables var13 = var12.chercherType(5, var6.getExecpt_id(), var2);
         if (var13 != null) {
            try {
               Transaction var34 = var2.beginTransaction();
               this.lesEcritures = new ArrayList();
               new ArrayList();
               String var15 = var4.dateToStringSQLLight(this.var_date_deb);
               String var16 = var4.dateToStringSQLLight(this.var_date_fin);
               String var17 = "exercicesComptable=" + var6.getExecpt_id() + "and ecrCode='" + var13.getPljCode() + "' and ecrDateSaisie>='" + var15 + "' and ecrDateSaisie<='" + var16 + "'";
               this.lesEcritures = var35.ChargerLesEcrituresRecherche(var17, var2);
               if (this.lesEcritures.size() != 0) {
                  new Ecritures();
                  String var19 = "";

                  for(int var20 = 0; var20 < this.lesEcritures.size(); ++var20) {
                     Ecritures var18 = (Ecritures)this.lesEcritures.get(var20);
                     var19 = var18.getEcrCode() + ":" + var18.getEcrPeriode();
                     List var14 = var36.chargerLesEcrituresAnalytiques(var18, var2);
                     if (var14.size() != 0) {
                        var36.nettoyageAnalytiqueByEcriture(var14, var2);
                     }

                     var35.removeSelectedEC0(var18, 0, var2);
                     JournauxMois var38 = var37.recupererJournauxMois(var19, var2);
                     if (var38 != null && var38.getJoumenSaisie() != 0) {
                        var38.setJoumenSaisie(0);
                        var37.majJournal(var38, var2);
                     }
                  }
               }

               var34.commit();
            } catch (HibernateException var30) {
               if (var7 != null) {
                  var7.rollback();
               }

               throw var30;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculClesEcritures() throws HibernateException, NamingException, ParseException, groovyjarjarcommonscli.ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Cles Ecritures");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      ArrayList var2 = new ArrayList();
      new ExercicesComptable();
      ExercicesComptable var3 = this.exercicesComptableDao.recupererLastExo((Session)null);
      if (var3 != null) {
         var2.add(var3);
      }

      UtilNombre var4 = new UtilNombre();
      new UtilDate();
      EcrituresDao var6 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.lesEcritures = new ArrayList();
      EcrituresAnalytiquesDao var7 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      ArrayList var8 = new ArrayList();
      Utilitaires_Compta var9 = new Utilitaires_Compta(this);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      if (var2.size() != 0) {
         for(int var10 = 0; var10 < var2.size(); ++var10) {
            long var11 = ((ExercicesComptable)var2.get(var10)).getExecpt_id();
            if (var11 != 0L) {
               Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
               var13.setFlushMode(FlushMode.MANUAL);
               String var14 = "";
               new PlanComptable();
               PlanComptableDao var16 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
               String var17 = this.structureLog.getStrzonefiscale();
               if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.structureLog.getStrdatefiscale2() != null && var3.getExecptDateFin().compareTo(this.structureLog.getStrdatefiscale2()) > 0) {
                  var17 = this.structureLog.getStrzonefiscale2();
               }

               PlanComptable var15 = var16.chercherCompteStartWith(var17, "47100", var11, var13);
               if (var15 != null) {
                  var14 = var15.getPlcCompte();
               } else {
                  var14 = "4710000";
               }

               this.lesEcritures = var6.chargerEcritures((ExercicesComptable)var2.get(var10), var13);
               if (this.lesEcritures.size() != 0) {
                  Transaction var18 = null;

                  try {
                     var18 = var13.beginTransaction();
                     new Ecritures();
                     int var20 = 0;

                     for(int var21 = 0; var21 < this.lesEcritures.size(); ++var21) {
                        Ecritures var19 = (Ecritures)this.lesEcritures.get(var21);
                        this.var_info = "Exercice : " + var11 + " Numero " + var21 + " sur Nb ecritures : " + this.lesEcritures.size();
                        if (var21 != 0) {
                           double var22 = (double)this.lesEcritures.size();
                           double var24 = var4.myRound(var22 / (double)var21, 4);
                           double var26 = var4.myRound(100.0D / var24, 2);
                           this.var_currentValue = (int)var26;
                        }

                        var9.recalculClesEcritures(var19, var8, var7, var6, var14, var13);
                        ++var20;
                        if (var20 == 400) {
                           var13.flush();
                           var20 = 0;
                        }
                     }

                     var13.flush();
                     var18.commit();
                  } catch (HibernateException var31) {
                     if (var18 != null) {
                        var18.rollback();
                     }

                     throw var31;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }
               } else {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void calculTableauDotation() throws HibernateException, NamingException, ParseException, IOException, groovyjarjarcommonscli.ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("calcul Tableau Dotation");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      Utilitaires_Compta var2 = new Utilitaires_Compta(this);
      UtilNombre var3 = new UtilNombre();
      UtilDate var4 = new UtilDate();
      new Amortissements();
      AmortissementsDao var6 = new AmortissementsDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      AmortissementTab var8 = new AmortissementTab();
      AmortissementTabDao var9 = new AmortissementTabDao(this.baseLog, this.utilInitHibernate);
      ArrayList var10 = new ArrayList();
      this.optionComptabilite = new OptionComptabilite();
      LireLesoptionsCompta var11 = new LireLesoptionsCompta(this.structureLog);
      var11.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = var11.lancer();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      new ArrayList();
      List var12 = var6.chargerAnneeUtilisee((Session)null);
      if (var12.size() != 0) {
         for(int var13 = 0; var13 < var12.size(); ++var13) {
            String var14 = ((SelectItem)var12.get(var13)).getValue().toString();
            String var15 = " amo_date_achat is not null and YEAR(amo_date_achat) = " + Long.parseLong(var14);
            List var7 = var6.chargerlesImmobilisations(var15, (Session)null);
            if (var7.size() != 0) {
               Session var16 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
               Transaction var17 = null;

               try {
                  var17 = var16.beginTransaction();
                  int var18 = 0;

                  for(int var19 = 0; var19 < var7.size(); ++var19) {
                     Amortissements var5 = (Amortissements)var7.get(var19);
                     this.var_info = "Annee " + var14 + " -Nb immobilisations : " + var7.size() + " N0 immo. " + var5.getAmoNum();
                     if (var19 != 0) {
                        double var20 = (double)var7.size();
                        double var22 = var3.myRound(var20 / (double)var19, 4);
                        double var24 = var3.myRound(100.0D / var22, 2);
                        this.var_currentValue = (int)var24;
                     }

                     var2.calculTableauDotation(var3, var9, var5, var10, var4, var8, this.optionComptabilite, this.structureLog, var16);
                     ++var18;
                     if (var18 > 50) {
                        var16.flush();
                        var18 = 0;
                     }
                  }

                  var17.commit();
               } catch (HibernateException var29) {
                  if (var17 != null) {
                     var17.rollback();
                  }

                  throw var29;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculAnalytique() throws HibernateException, NamingException, ParseException, IOException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Analytique");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      Utilitaires_Compta var2 = new Utilitaires_Compta(this);
      UtilNombre var3 = new UtilNombre();
      LireLesoptionsCompta var4 = new LireLesoptionsCompta(this.structureLog);
      var4.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = new OptionComptabilite();
      var4.lancer();
      this.optionComptabilite = var4.getOptionComptabilite();
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      this.dataModelEcrituresPB = new ListDataModel();
      Object var6 = new ArrayList();
      new ArrayList();
      new Ecritures();
      EcrituresDao var9 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      List var7 = var9.chargerEcritures(this.var_date_deb, this.var_date_fin, var5);
      new ArrayList();
      EcrituresAnalytique var11 = new EcrituresAnalytique();
      EcrituresAnalytiquesDao var12 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      List var10 = var12.chargerLesEcrituresAnalytiquesByDate(this.var_date_deb, this.var_date_fin, var5);
      if (var7.size() != 0) {
         Transaction var13 = null;

         try {
            var13 = var5.beginTransaction();
            int var14 = 0;

            for(int var15 = 0; var15 < var7.size(); ++var15) {
               this.var_info = "Ecriture Num : " + var15;
               if (var15 != 0) {
                  double var16 = (double)var7.size();
                  double var18 = var3.myRound(var16 / (double)var15, 4);
                  double var20 = var3.myRound(100.0D / var18, 2);
                  this.var_currentValue = (int)var20;
               }

               Ecritures var8 = (Ecritures)var7.get(var15);
               var6 = var2.recalculAnalytque(this.optionComptabilite, var8, var9, var11, var12, var10, (List)var6, var5);
               ++var14;
               if (var14 == 100) {
                  var5.flush();
               }
            }

            var13.commit();
         } catch (HibernateException var25) {
            if (var13 != null) {
               var13.rollback();
            }

            throw var25;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.dataModelEcrituresPB.setWrappedData(var6);
      this.var_showBarProg = false;
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void declotureMensuelle() throws HibernateException, NamingException, ParseException, groovyjarjarcommonscli.ParseException, Exception {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("decloture Mensuelle");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      UtilDate var2 = new UtilDate();
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      EcrituresDao var4 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      JournauxMois var5 = new JournauxMois();
      JournauxMoisDao var6 = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      String var8 = var2.dateToPeriodeFr(this.var_date_deb);
      String var9 = var2.dateToPeriodeFr(this.var_date_fin);
      List var7 = var6.listeJouMemPourDecloture(var8, var9, var3);
      Utilitaires_Compta var10 = new Utilitaires_Compta(this);
      if (var7.size() == 0 && var7.size() == 0) {
         this.utilInitHibernate.closeSession();
      } else {
         Transaction var11 = null;

         try {
            var11 = var3.beginTransaction();
            var10.declotureMensuelle(this.structureLog, this.usersLog, var2, var7, var5, var6, var4, this.var_date_deb, this.var_date_fin, var3);
            var11.commit();
         } catch (HibernateException var16) {
            if (var11 != null) {
               var11.rollback();
            }

            throw var16;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void verificationDecimalesEcritures() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Cles Ecritures");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      ArrayList var2 = new ArrayList();
      new ExercicesComptable();
      ExercicesComptable var3 = this.exercicesComptableDao.recupererLastExo((Session)null);
      if (var3 != null) {
         var2.add(var3);
      }

      UtilNombre var4 = new UtilNombre();
      EcrituresDao var5 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.lesEcritures = new ArrayList();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      if (var2.size() != 0) {
         for(int var6 = 0; var6 < var2.size(); ++var6) {
            long var7 = ((ExercicesComptable)var2.get(var6)).getExecpt_id();
            if (var7 != 0L) {
               Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
               this.lesEcritures = var5.chargerEcritures((ExercicesComptable)var2.get(var6), var9);
               if (this.lesEcritures.size() != 0) {
                  Transaction var10 = null;

                  try {
                     var10 = var9.beginTransaction();
                     new Ecritures();
                     double var12 = 0.0D;
                     double var14 = 0.0D;
                     int var16 = 0;

                     for(int var17 = 0; var17 < this.lesEcritures.size(); ++var17) {
                        Ecritures var11 = (Ecritures)this.lesEcritures.get(var17);
                        this.var_info = "Exercice : " + var7 + " - Nb ecritures : " + this.lesEcritures.size();
                        if (var17 != 0) {
                           double var18 = (double)this.lesEcritures.size();
                           double var20 = var4.myRound(var18 / (double)var17, 4);
                           double var22 = var4.myRound(100.0D / var20, 2);
                           this.var_currentValue = (int)var22;
                        }

                        if (var11.getEcrDebitSaisie() != 0.0D && var11.getEcrCreditSaisie() == 0.0D) {
                           var12 = var4.myRoundDevise(var11.getEcrDebitSaisie(), this.structureLog.getStrdevise());
                           var14 = 0.0D;
                        } else {
                           var14 = var4.myRoundDevise(var11.getEcrCreditSaisie(), this.structureLog.getStrdevise());
                           var12 = 0.0D;
                        }

                        var11.setEcrDebitSaisie(var12);
                        var11.setEcrCreditSaisie(var14);
                        var11.setEcrDebitEuro(0.0D);
                        var11.setEcrCreditEuro(0.0D);
                        var11.setEcrDebitPays(var12);
                        var11.setEcrCreditPays(var14);
                        var11.setEcrDebitGrp(var12);
                        var11.setEcrCreditGrp(var14);
                        var5.modif(var11, var9);
                        ++var16;
                        if (var16 == 100) {
                           var9.flush();
                           var16 = 0;
                        }
                     }

                     var10.commit();
                  } catch (HibernateException var27) {
                     if (var10 != null) {
                        var10.rollback();
                     }

                     throw var27;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }
               } else {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculClesJournauxMois() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Cles Journaux mois");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      ArrayList var2 = new ArrayList();
      new ExercicesComptable();
      ExercicesComptable var3 = this.exercicesComptableDao.recupererLastExo((Session)null);
      if (var3 != null) {
         var2.add(var3);
      }

      UtilNombre var4 = new UtilNombre();
      new UtilDate();
      JournauxMoisDao var6 = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      EcrituresDao var7 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      if (var2.size() != 0) {
         for(int var9 = 0; var9 < var2.size(); ++var9) {
            long var10 = ((ExercicesComptable)var2.get(var9)).getExecpt_id();
            if (var10 != 0L) {
               Session var12 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
               List var8 = var6.listeJouMemCloture(var3, var12);
               if (var8.size() != 0) {
                  Transaction var13 = null;

                  try {
                     var13 = var12.beginTransaction();
                     new JournauxMois();
                     boolean var15 = false;

                     for(int var16 = 0; var16 < var8.size(); ++var16) {
                        JournauxMois var14 = (JournauxMois)var8.get(var16);
                        this.var_info = "Exercice : " + var10 + " journal num. " + var16 + " / Nb journaux mois : " + var8.size();
                        if (var16 != 0) {
                           double var17 = (double)var8.size();
                           double var19 = var4.myRound(var17 / (double)var16, 4);
                           double var21 = var4.myRound(100.0D / var19, 2);
                           this.var_currentValue = (int)var21;
                        }

                        var15 = var7.verifMouvment(var14.getJoumenPeriode(), var14.getJoumenCode(), var12);
                        if (!var15) {
                           var14.setJoumenUserIdJournal(0L);
                           var14.setJoumenSaisie(0);
                           var14.setJoumenOpenJournal(0);
                           var14.setJoumenOpenUserJournal("");
                        } else {
                           var14.setJoumenUserIdJournal(0L);
                           var14.setJoumenSaisie(1);
                           var14.setJoumenOpenJournal(0);
                           var14.setJoumenOpenUserJournal("");
                        }

                        var6.majJournal(var14, var12);
                     }

                     var13.commit();
                  } catch (HibernateException var26) {
                     if (var13 != null) {
                        var13.rollback();
                     }

                     throw var26;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }
               } else {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void restaurationEcritures() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("restauration écritures");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      UtilNombre var2 = new UtilNombre();
      EcrituresDao var3 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      new Ecritures();
      new ArrayList();
      EcrituresAnalytiquesDao var6 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      JournauxMoisDao var7 = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      new ExercicesComptable();
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      if (this.lesEcrituresDetruites.size() != 0) {
         Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var10 = null;

         try {
            var10 = var9.beginTransaction();

            for(int var11 = 0; var11 < this.lesEcrituresDetruites.size(); ++var11) {
               this.ecrDestroy = (EcrituresDestroy)this.lesEcrituresDetruites.get(var11);
               this.var_info = "Ecriture N° " + this.ecrDestroy.getEcrId();
               if (var11 != 0) {
                  double var12 = (double)this.lesEcrituresDetruites.size();
                  double var14 = var2.myRound(var12 / (double)var11, 4);
                  double var16 = var2.myRound(100.0D / var14, 2);
                  this.var_currentValue = (int)var16;
               }

               if (this.ecrDestroy.isSel_ecriture()) {
                  if (this.ecrDestroy.getEcrAnnee() == null || this.ecrDestroy.getEcrAnnee().isEmpty()) {
                     this.ecrDestroy.setEcrAnnee("" + (this.ecrDestroy.getEcrDateSaisie().getYear() + 1900));
                  }

                  long var24 = Long.parseLong(this.ecrDestroy.getEcrAnnee());
                  ExercicesComptable var8 = this.exercicesComptableDao.recupererLExoPrecis(var24, var9);
                  if (var8 == null) {
                     var8 = this.exercicesComptableDao.recupererLastExo(var9);
                  }

                  if (var8 != null) {
                     Ecritures var4 = var3.inserRestaureDestroy(this.ecrDestroy, var8, var9);
                     List var5 = var6.chargerLesEcrituresAnalytiquesDetruites(this.ecrDestroy, var9);
                     if (var5.size() != 0) {
                        var6.inserRestaureAnalytiquesDestroy(var5, var4, var9);
                        var6.nettoyageAnalytiqueDestroy(var5, var9);
                     }

                     var3.removeDestroy(this.ecrDestroy, var9);
                  }
               }
            }

            new JournauxMois();

            for(int var25 = 0; var25 < this.lesEcrituresDetruites.size(); ++var25) {
               this.ecrDestroy = (EcrituresDestroy)this.lesEcrituresDetruites.get(var25);
               String var13 = this.calculCle1(this.var_journal, this.ecrDestroy.getEcrDateSaisie());
               JournauxMois var23 = var7.recupererJournauxMois(var13, var9);
               if (var23 != null && var23.getJoumenSaisie() == 0) {
                  var23.setJoumenSaisie(1);
                  var7.majJournal(var23, var9);
               }
            }

            var10.commit();
         } catch (HibernateException var21) {
            if (var10 != null) {
               var10.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void suppressionEcritures() throws HibernateException, NamingException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("suppression écritures des journaux");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      UtilNombre var2 = new UtilNombre();
      EcrituresDao var3 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      new Ecritures();
      this.lesEcritures = new ArrayList();
      Object var5 = new ArrayList();
      EcrituresAnalytiquesDao var6 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      if (this.var_journal != null && !this.var_journal.isEmpty()) {
         this.lesEcritures = var3.chargerEcritures(this.var_date_deb, this.var_date_fin, this.var_journal, var7);
      } else {
         this.lesEcritures = var3.chargerEcritures(this.var_date_deb, this.var_date_fin, var7);
      }

      this.utilInitHibernate.closeSession();
      if (this.lesEcritures.size() != 0) {
         var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();

            for(int var9 = 0; var9 < this.lesEcritures.size(); ++var9) {
               Ecritures var4 = (Ecritures)this.lesEcritures.get(var9);
               long var10 = var4.getEcr_id();
               this.var_info = "Ecriture Numero " + var4.getEcr_id() + " sur " + this.lesEcritures.size();
               if (var9 != 0) {
                  double var12 = (double)this.lesEcritures.size();
                  double var14 = var2.myRound(var12 / (double)var9, 4);
                  double var16 = var2.myRound(100.0D / var14, 2);
                  this.var_currentValue = (int)var16;
               }

               ((List)var5).clear();
               var5 = var6.chargerLesEcrituresAnalytiques(var4, var7);
               if (((List)var5).size() != 0) {
                  var6.nettoyageAnalytiqueByEcriture((List)var5, var7);
                  var7.flush();
               }

               var4 = var3.recupererSelectedECById(var10, var7);
               if (var4 != null) {
                  var3.removeSelectedEC0(var4, 0, var7);
               }
            }

            var8.commit();
         } catch (HibernateException var21) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.recalculClesJournauxMois();
      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void rechercheEcrituresDetuites() throws HibernateException, NamingException {
      if (this.var_journal != null && !this.var_journal.isEmpty()) {
         this.lesEcrituresDetruites.clear();
         EcrituresDao var1 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         this.lesEcrituresDetruites = var1.chargerEcrituresDetruites(this.var_date_deb, this.var_date_fin, this.var_journal, var2);
         this.dataModelEcrituresDetruites.setWrappedData(this.lesEcrituresDetruites);
         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionEcrituresDetuites() {
      if (this.dataModelEcrituresDetruites.isRowAvailable()) {
         this.ecrDestroy = (EcrituresDestroy)this.dataModelEcrituresDetruites.getRowData();
      }

   }

   public void toutDeSelectionner() {
      if (this.lesEcrituresDetruites.size() != 0) {
         for(int var1 = 0; var1 < this.lesEcrituresDetruites.size(); ++var1) {
            this.ecrDestroy = (EcrituresDestroy)this.lesEcrituresDetruites.get(var1);
            this.ecrDestroy.setSel_ecriture(false);
         }
      }

   }

   public void toutSelectionner() {
      if (this.lesEcrituresDetruites.size() != 0) {
         for(int var1 = 0; var1 < this.lesEcrituresDetruites.size(); ++var1) {
            this.ecrDestroy = (EcrituresDestroy)this.lesEcrituresDetruites.get(var1);
            this.ecrDestroy.setSel_ecriture(true);
         }
      }

   }

   public String calculCle1(String var1, Date var2) {
      SimpleDateFormat var3 = new SimpleDateFormat("dd-MM-yyyy");
      var3.format(var2);
      String var4 = "" + var3.format(var2);
      String[] var5 = var4.split("-");
      String var6 = var5[1];
      String var7 = var5[2];
      String var8 = var1 + ":" + var6 + ":" + var7;
      return var8;
   }

   public String calculCle2(String var1, Date var2) {
      SimpleDateFormat var3 = new SimpleDateFormat("dd-MM-yyyy");
      var3.format(var2);
      String var4 = "" + var3.format(var2);
      String[] var5 = var4.split("-");
      String var6 = var5[0];
      String var7 = var5[1];
      String var8 = var5[2];
      String var9 = var1 + ":" + var8 + ":" + var7 + ":" + var6;
      return var9;
   }

   public String calculPeriode(Date var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
      var2.format(var1);
      String var3 = "" + var2.format(var1);
      String[] var4 = var3.split("-");
      String var5 = var4[1];
      String var6 = var4[2];
      String var7 = var5 + ":" + var6;
      return var7;
   }

   public void flagRapprochement() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("flag rapprochements bancaires");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      EcrituresDao var4 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      new Ecritures();
      this.lesEcritures = new ArrayList();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      String var6 = var3.dateToStringSQLLight(this.var_date_deb);
      String var7 = var3.dateToStringSQLLight(this.var_date_fin);
      Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      String var9 = " (ecrNatureJrx=7 or ecrNatureJrx=8) and ecrDateSaisie>='" + var6 + "' and ecrDateSaisie<='" + var7 + "'";
      this.lesEcritures = var4.ChargerLesEcrituresRecherche(var9, var8);
      this.utilInitHibernate.closeSession();
      if (this.lesEcritures.size() != 0) {
         var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var10 = null;

         try {
            var10 = var8.beginTransaction();

            for(int var11 = 0; var11 < this.lesEcritures.size(); ++var11) {
               Ecritures var5 = (Ecritures)this.lesEcritures.get(var11);
               this.var_info = "Journal " + var5.getEcrCode() + " sur " + this.lesEcritures.size();
               if (var11 != 0) {
                  double var12 = (double)this.lesEcritures.size();
                  double var14 = var2.myRound(var12 / (double)var11, 4);
                  double var16 = var2.myRound(100.0D / var14, 2);
                  this.var_currentValue = (int)var16;
               }

               if (var5.getEcrRapprochement() == null || var5.getEcrRapprochement().isEmpty()) {
                  var5.setEcrRapprochement(var5.getEcrPeriode());
                  var4.modif(var5, var8);
               }
            }

            var10.commit();
         } catch (HibernateException var21) {
            if (var10 != null) {
               var10.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void rechercheAnalyseReparationEcrGene() throws HibernateException, NamingException, IOException {
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      LireLesoptionsCompta var1 = new LireLesoptionsCompta(this.structureLog);
      var1.setStrId(this.structureLog.getStrid());
      var1.lancer();
      this.optionComptabilite = var1.getOptionComptabilite();
      int var2 = Integer.parseInt(this.optionComptabilite.getNbcr());
      UtilNombre var3 = new UtilNombre();
      Object var4 = new ArrayList();
      JournauxComptablesDao var5 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      new PlanComptable();
      PlanComptableDao var7 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      Object var9 = new ArrayList();
      this.lesEcritures.clear();
      EcrituresDao var10 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      this.var_info = "Chargement du plan comptable et des journaux comptables....";
      new ExercicesComptable();
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      ExercicesComptable var12 = this.exercicesComptableDao.recupererLastExo(var11);
      String var13 = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.structureLog.getStrdatefiscale2() != null && this.var_date_fin.compareTo(this.structureLog.getStrdatefiscale2()) > 0) {
         var13 = this.structureLog.getStrzonefiscale2();
      }

      if (var12 != null) {
         var9 = var7.chargerLesPlanComptables(var13, var12.getExecpt_id(), var11);
         var4 = var5.chargerLesJournauxComptables(var12.getExecpt_id(), 0, var11);
      }

      this.var_info = "Chargement des ecritures generales....";
      List var8 = var10.chargerEcrituresanalyse(this.var_date_deb, this.var_date_fin, var11);
      if (var8.size() != 0) {
         this.ecrGene = new Ecritures();

         for(int var14 = 0; var14 < var8.size(); ++var14) {
            this.ecrGene = (Ecritures)var8.get(var14);
            this.var_info = "Ecriture Numero " + this.ecrGene.getEcr_id() + " sur " + var8.size();
            if (var14 != 0) {
               double var15 = (double)var8.size();
               double var17 = var3.myRound(var15 / (double)var14, 4);
               double var19 = var3.myRound(100.0D / var17, 2);
               this.var_currentValue = (int)var19;
            }

            if (this.ecrGene.getEcrCode() != null && !this.ecrGene.getEcrCode().isEmpty()) {
               boolean var21 = false;
               int var16;
               if (((List)var4).size() != 0) {
                  for(var16 = 0; var16 < ((List)var4).size(); ++var16) {
                     if (this.ecrGene.getEcrCode().equals(((JournauxComptables)((List)var4).get(var16)).getPljCode()) && this.ecrGene.getEcrNatureJrx() != ((JournauxComptables)((List)var4).get(var16)).getPljNature()) {
                        this.ecrGene.setErreurLettrage("La nature du journal est incorrecte: " + this.ecrGene.getEcrNatureJrx() + " au lieu de " + ((JournauxComptables)((List)var4).get(var16)).getPljNature() + " Veuillez exécuter l'utilitaire de recalcul des natures des journaux");
                        this.lesEcritures.add(this.ecrGene);
                        var21 = true;
                        break;
                     }
                  }
               }

               if (!var21) {
                  if (this.ecrGene.getEcrCompte() != null && !this.ecrGene.getEcrCompte().isEmpty()) {
                     if (this.ecrGene.getEcrCompte() != null && !this.ecrGene.getEcrCompte().isEmpty()) {
                        PlanComptable var6;
                        if (((List)var9).size() == 0) {
                           var6 = var7.chercherCompte(var13, this.ecrGene.getEcrCompte(), this.ecrGene.getExercicesComptable().getExecpt_id(), var11);
                           if (var6 == null) {
                              this.ecrGene.setErreurLettrage("Le compte n'existe pas dans le plan comptable Veuillez créer les comptes dans le plan comptable");
                              this.lesEcritures.add(this.ecrGene);
                           }
                        } else {
                           var6 = null;

                           for(var16 = 0; var16 < ((List)var9).size(); ++var16) {
                              if (this.ecrGene.getEcrCompte().equals(((PlanComptable)((List)var9).get(var16)).getPlcCompte())) {
                                 var6 = (PlanComptable)((List)var9).get(var16);
                                 break;
                              }
                           }

                           if (var6 == null) {
                              this.ecrGene.setErreurLettrage("Le compte n'existe pas dans le plan comptable Veuillez créer les comptes dans le plan comptable");
                              this.lesEcritures.add(this.ecrGene);
                           } else if (this.ecrGene.getEcrNature() != var6.getPlcNature()) {
                              this.ecrGene.setErreurLettrage("La nature du compte est incorrecte: " + this.ecrGene.getEcrNature() + " au lieu de " + var6.getPlcNature() + " Veuillez exécuter l'utilitaire de recalcul des natures des comptes");
                              this.lesEcritures.add(this.ecrGene);
                           } else if (this.ecrGene.getEcrCompte().length() != var2) {
                              this.ecrGene.setErreurLettrage("La longueur du compte est incorrecte: " + this.ecrGene.getEcrCompte().length() + " au lieu de " + var2 + " Veuillez exécuter l'interchange des écritures dans les extraits de comptes");
                              this.lesEcritures.add(this.ecrGene);
                           }
                        }
                     } else if (this.ecrGene.getEcrDebitSaisie() == 0.0D && this.ecrGene.getEcrCreditSaisie() == 0.0D) {
                        this.ecrGene.setErreurLettrage("Il manque le montantCette écriture sera supprimée");
                        this.lesEcritures.add(this.ecrGene);
                     } else if (this.ecrGene.getEcrDebitSaisie() != 0.0D && this.ecrGene.getEcrCreditSaisie() != 0.0D) {
                        this.ecrGene.setErreurLettrage("Il y a trop de montants Veuillez corriger la saisie au niveau du journal");
                        this.lesEcritures.add(this.ecrGene);
                     } else if (this.ecrGene.getEcrCoefEuro() != 0.0F && this.ecrGene.getEcrCoefPays() != 0.0F) {
                        if (this.ecrGene.getEcrDebitPays() == 0.0D && this.ecrGene.getEcrCreditPays() == 0.0D) {
                           this.ecrGene.setErreurLettrage("Il manque les montants Pays");
                           this.lesEcritures.add(this.ecrGene);
                        } else if (!this.ecrGene.getEcrPeriode().equals(this.calculPeriode(this.ecrGene.getEcrDateSaisie()))) {
                           this.ecrGene.setErreurLettrage("La période n'est pas correcte");
                           this.lesEcritures.add(this.ecrGene);
                        } else if (!this.ecrGene.getEcrCle1().equals(this.calculCle1(this.ecrGene.getEcrCode(), this.ecrGene.getEcrDateSaisie()))) {
                           this.ecrGene.setErreurLettrage("La période n'est pas correcte");
                           this.lesEcritures.add(this.ecrGene);
                        } else if (!this.ecrGene.getEcrCle2().equals(this.calculCle2(this.ecrGene.getEcrCle2(), this.ecrGene.getEcrDateSaisie()))) {
                           this.ecrGene.setErreurLettrage("La période n'est pas correcte");
                           this.lesEcritures.add(this.ecrGene);
                        }
                     } else {
                        this.ecrGene.setErreurLettrage("Il manque le coef Euro ou le coef Pays");
                        this.lesEcritures.add(this.ecrGene);
                     }
                  } else {
                     this.ecrGene.setErreurLettrage("Il manque le compte Veuillez saisir le compte dans le journal");
                     this.lesEcritures.add(this.ecrGene);
                  }
               }
            } else {
               this.ecrGene.setErreurLettrage("Il manque le journal");
               this.lesEcritures.add(this.ecrGene);
            }
         }
      }

      this.var_showBarProg = false;
      this.dataModelEcrituresDetruites.setWrappedData(this.lesEcritures);
      this.utilInitHibernate.closeSession();
   }

   public void rechercheAnalyseReparationEcrAnal() throws HibernateException, NamingException, IOException {
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      LireLesoptionsCompta var1 = new LireLesoptionsCompta(this.structureLog);
      var1.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = var1.lancer();
      int var2 = Integer.parseInt(this.optionComptabilite.getNbcr());
      UtilNombre var3 = new UtilNombre();
      new ArrayList();
      new ArrayList();
      this.lesEcritures.clear();
      EcrituresDao var6 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      EcrituresAnalytiquesDao var7 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      this.var_info = "Chargement du plan comptable et des journaux comptables....";
      new ExercicesComptable();
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.exercicesComptableDao.recupererLastExo(var8);
      String var10 = "";
      if (this.optionComptabilite.getAnal_c1().equals("true")) {
         var10 = "1";
      }

      if (this.optionComptabilite.getAnal_c2().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "2";
      }

      if (this.optionComptabilite.getAnal_c3().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "3";
      }

      if (this.optionComptabilite.getAnal_c4().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "4";
      }

      if (this.optionComptabilite.getAnal_c5().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "5";
      }

      if (this.optionComptabilite.getAnal_c6().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "6";
      }

      if (this.optionComptabilite.getAnal_c7().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "7";
      }

      if (this.optionComptabilite.getAnal_c8().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "8";
      }

      if (this.optionComptabilite.getAnal_c9().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "9";
      }

      if (this.optionComptabilite.getAnal_c10().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "10";
      }

      if (this.optionComptabilite.getAnal_c11().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "11";
      }

      if (this.optionComptabilite.getAnal_c12().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "12";
      }

      if (this.optionComptabilite.getAnal_c13().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "13";
      }

      if (this.optionComptabilite.getAnal_c14().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "14";
      }

      if (this.optionComptabilite.getAnal_c15().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "15";
      }

      if (this.optionComptabilite.getAnal_c16().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "16";
      }

      if (this.optionComptabilite.getAnal_c17().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "17";
      }

      if (this.optionComptabilite.getAnal_c18().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "18";
      }

      if (this.optionComptabilite.getAnal_c19().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "19";
      }

      if (this.optionComptabilite.getAnal_c20().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "20";
      }

      if (this.optionComptabilite.getAnal_c21().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "21";
      }

      if (this.optionComptabilite.getAnal_c22().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "22";
      }

      if (this.optionComptabilite.getAnal_c23().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "23";
      }

      if (this.optionComptabilite.getAnal_c24().equals("true")) {
         if (var10 != null && !var10.isEmpty()) {
            var10 = var10 + ",";
         }

         var10 = var10 + "24";
      }

      this.var_info = "Chargement des ecritures generales....";
      if (var10 != null && !var10.isEmpty()) {
         List var4 = var6.chargerEcrituresanalytique(var10, this.var_date_deb, this.var_date_fin, var8);
         if (var4.size() != 0) {
            this.ecrGene = new Ecritures();

            for(int var11 = 0; var11 < var4.size(); ++var11) {
               this.ecrGene = (Ecritures)var4.get(var11);
               this.var_info = "Ecriture Numero " + this.ecrGene.getEcr_id() + " sur " + var4.size();
               if (var11 != 0) {
                  double var12 = (double)var4.size();
                  double var14 = var3.myRound(var12 / (double)var11, 4);
                  double var16 = var3.myRound(100.0D / var14, 2);
                  this.var_currentValue = (int)var16;
               }

               List var5 = var7.chargerLesEcrituresAnalytiques(this.ecrGene, var8);
               if (var5.size() == 0) {
                  this.lesEcritures.add(this.ecrGene);
               }
            }
         }
      }

      this.var_showBarProg = false;
      this.dataModelEcrituresDetruites.setWrappedData(this.lesEcritures);
      this.utilInitHibernate.closeSession();
   }

   public void selectionEcrituresGene() {
      if (this.dataModelEcrituresDetruites.isRowAvailable()) {
         this.ecrGene = (Ecritures)this.dataModelEcrituresDetruites.getRowData();
      }

   }

   public void toutDeSelectionnerEcritureGene() {
      if (this.lesEcritures.size() != 0) {
         for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
            this.ecrGene = (Ecritures)this.lesEcritures.get(var1);
            this.ecrGene.setSel_ecriture(false);
         }
      }

   }

   public void toutSelectionnerEcritureGene() {
      if (this.lesEcritures.size() != 0) {
         for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
            this.ecrGene = (Ecritures)this.lesEcritures.get(var1);
            this.ecrGene.setSel_ecriture(true);
         }
      }

   }

   public void toutCorrigerEcritureGene() throws HibernateException, NamingException, IOException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("réparation ecritures generales");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new PlanComptable();
      PlanComptableDao var3 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.ecrGene = new Ecritures();
      EcrituresDao var4 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      new ExercicesComptable();
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.optionComptabilite = new OptionComptabilite();
      LireLesoptionsCompta var6 = new LireLesoptionsCompta(this.structureLog);
      var6.setStrId(this.structureLog.getStrid());
      var6.lancer();
      this.optionComptabilite = var6.getOptionComptabilite();
      int var7 = Integer.parseInt(this.optionComptabilite.getNbcr());
      UtilNombre var8 = new UtilNombre();
      if (this.lesEcritures.size() != 0) {
         Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var10 = null;

         try {
            var10 = var9.beginTransaction();

            for(int var11 = 0; var11 < this.lesEcritures.size(); ++var11) {
               this.ecrGene = (Ecritures)this.lesEcritures.get(var11);
               this.var_info = "Ecriture " + this.ecrGene.getEcr_id() + " sur " + this.lesEcritures.size();
               if (var11 != 0) {
                  double var12 = (double)this.lesEcritures.size();
                  double var14 = var8.myRound(var12 / (double)var11, 4);
                  double var16 = var8.myRound(100.0D / var14, 2);
                  this.var_currentValue = (int)var16;
               }

               if (this.ecrGene.isSel_ecriture()) {
                  String var23 = this.structureLog.getStrzonefiscale();
                  if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
                     long var13 = (long)(this.ecrGene.getEcrDateSaisie().getYear() + 1900);
                     long var15 = (long)(this.ecrGene.getEcrDateSaisie().getYear() + 1900);
                     if (this.structureLog.getStrdatefiscale2() != null && var13 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var15 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
                        var23 = this.structureLog.getStrzonefiscale2();
                     }
                  }

                  if (this.ecrGene.getEcrCode() == null || this.ecrGene.getEcrCode().isEmpty()) {
                     this.ecrGene.setEcrCode("XX");
                  }

                  PlanComptable var2;
                  if (this.ecrGene.getEcrCompte() == null || this.ecrGene.getEcrCompte().isEmpty()) {
                     var2 = var3.chercherCompteStartWith(var23, "4711", this.ecrGene.getExercicesComptable().getExecpt_id(), var9);
                     if (var2 != null) {
                        this.ecrGene.setEcrCompte(var2.getPlcCompte());
                     } else {
                        this.ecrGene.setEcrCompte("4711000000");
                     }
                  }

                  String var24;
                  int var25;
                  if (this.ecrGene.getEcrCompte().length() < var7) {
                     var24 = this.ecrGene.getEcrCompte();
                     var25 = var7 - var24.length();
                     if (var25 == 1) {
                        var24 = "0";
                     } else if (var25 == 2) {
                        var24 = "00";
                     } else if (var25 == 3) {
                        var24 = "000";
                     } else if (var25 == 4) {
                        var24 = "0000";
                     } else if (var25 == 5) {
                        var24 = "00000";
                     } else if (var25 == 6) {
                        var24 = "000000";
                     } else if (var25 == 7) {
                        var24 = "0000000";
                     } else if (var25 == 8) {
                        var24 = "00000000";
                     } else if (var25 == 9) {
                        var24 = "000000000";
                     } else if (var25 == 10) {
                        var24 = "0000000000";
                     }

                     this.ecrGene.setEcrCompte(this.ecrGene.getEcrCompte() + var24);
                  } else if (this.ecrGene.getEcrCompte().length() > var7) {
                     this.ecrGene.setEcrCompte(this.ecrGene.getEcrCompte().substring(0, var7));
                  }

                  if (this.ecrGene.getEcrCompte() != null && !this.ecrGene.getEcrCompte().isEmpty()) {
                     var2 = var3.chercherCompte(var23, this.ecrGene.getEcrCompte(), this.ecrGene.getExercicesComptable().getExecpt_id(), var9);
                     if (var2 == null) {
                        ExercicesComptable var5 = this.ecrGene.getExercicesComptable();
                        if (var5 != null) {
                           var2 = var3.ajouteCompte(var23, var7, this.ecrGene.getEcrCompte(), this.ecrGene.getEcrLibelle(), var5, this.structureLog, var9);
                           if (var2 == null) {
                           }
                        }
                     } else {
                        this.ecrGene.setEcrNature(var2.getPlcNature());
                     }
                  }

                  if (this.ecrGene.getEcrCompte().length() < var7) {
                     var24 = this.ecrGene.getEcrCompte();
                     var25 = var7 - var24.length();
                     if (var25 == 1) {
                        var24 = "0";
                     } else if (var25 == 2) {
                        var24 = "00";
                     } else if (var25 == 3) {
                        var24 = "000";
                     } else if (var25 == 4) {
                        var24 = "0000";
                     } else if (var25 == 5) {
                        var24 = "00000";
                     } else if (var25 == 6) {
                        var24 = "000000";
                     } else if (var25 == 7) {
                        var24 = "0000000";
                     } else if (var25 == 8) {
                        var24 = "00000000";
                     } else if (var25 == 9) {
                        var24 = "000000000";
                     } else if (var25 == 10) {
                        var24 = "0000000000";
                     }

                     this.ecrGene.setEcrCompte(this.ecrGene.getEcrCompte() + var24);
                  } else if (this.ecrGene.getEcrCompte().length() > var7) {
                     this.ecrGene.setEcrCompte(this.ecrGene.getEcrCompte().substring(0, var7));
                  }

                  if (this.ecrGene.getEcrDebitSaisie() != 0.0D && this.ecrGene.getEcrCreditSaisie() != 0.0D) {
                  }

                  if (this.ecrGene.getEcrCoefEuro() == 0.0F) {
                     this.ecrGene.setEcrCoefEuro(1.0F);
                     this.ecrGene.setEcrCreditEuro(this.ecrGene.getEcrCreditEuro());
                     this.ecrGene.setEcrDebitEuro(this.ecrGene.getEcrDebitEuro());
                  }

                  if (this.ecrGene.getEcrCoefPays() == 0.0F) {
                     this.ecrGene.setEcrCoefPays(1.0F);
                  }

                  if (this.ecrGene.getEcrDebitPays() == 0.0D && this.ecrGene.getEcrCreditPays() == 0.0D) {
                     this.ecrGene.setEcrCoefPays(1.0F);
                     this.ecrGene.setEcrCreditPays(this.ecrGene.getEcrCreditSaisie());
                     this.ecrGene.setEcrDebitPays(this.ecrGene.getEcrDebitSaisie());
                  }

                  if (!this.ecrGene.getEcrPeriode().equals(this.calculPeriode(this.ecrGene.getEcrDateSaisie()))) {
                     this.ecrGene.setEcrPeriode(this.calculPeriode(this.ecrGene.getEcrDateSaisie()));
                  }

                  if (!this.ecrGene.getEcrCle1().equals(this.calculCle1(this.ecrGene.getEcrCode(), this.ecrGene.getEcrDateSaisie()))) {
                     this.ecrGene.setEcrCle1(this.calculCle1(this.ecrGene.getEcrCode(), this.ecrGene.getEcrDateSaisie()));
                  }

                  if (!this.ecrGene.getEcrCle2().equals(this.calculCle2(this.ecrGene.getEcrCle2(), this.ecrGene.getEcrDateSaisie()))) {
                     this.ecrGene.setEcrCle2(this.calculCle2(this.ecrGene.getEcrCode(), this.ecrGene.getEcrDateSaisie()));
                  }

                  if (this.ecrGene.getEcrDebitSaisie() == 0.0D && this.ecrGene.getEcrCreditSaisie() == 0.0D) {
                     var4.removeSelectedEC0(this.ecrGene, 0, var9);
                  } else {
                     this.ecrGene = var4.modif(this.ecrGene, var9);
                  }
               }
            }

            var10.commit();
         } catch (HibernateException var21) {
            if (var10 != null) {
               var10.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.dataModelEcrituresDetruites = new ListDataModel();
      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void declotureRapprochement() throws HibernateException, NamingException, Exception {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("décloture rapprochements bancaires");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      UtilDate var2 = new UtilDate();
      JournauxMoisDao var3 = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      JournauxMois var4 = new JournauxMois();
      new ArrayList();
      JournauxJourDao var6 = new JournauxJourDao(this.baseLog, this.utilInitHibernate);
      JournauxJour var7 = new JournauxJour();
      new ArrayList();
      Utilitaires_Compta var9 = new Utilitaires_Compta(this);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      String var10 = "";
      String var11 = "" + (this.var_date_deb.getYear() + 1900);
      if (this.var_date_deb.getMonth() + 1 <= 9) {
         var10 = "0" + (this.var_date_deb.getMonth() + 1);
      } else {
         var10 = "" + (this.var_date_deb.getMonth() + 1);
      }

      String var12 = var10 + ":" + var11;
      Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      List var5 = var3.mesjournauxmois(this.var_journal, (ExercicesComptable)null, var13);
      List var8 = var6.mesjournauxjour(this.var_journal, this.var_date_deb, this.var_date_fin, (ExercicesComptable)null, var13);
      this.utilInitHibernate.closeSession();
      if (var5.size() != 0) {
         var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var14 = null;

         try {
            var14 = var13.beginTransaction();
            var9.declotureRapprochement(this.structureLog, this.usersLog, var2, var5, var4, var12, var3, var8, var7, var6, var13);
            var14.commit();
         } catch (HibernateException var19) {
            if (var14 != null) {
               var14.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculClesRapprochement() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Cles rapprochement");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      new ArrayList();
      List var2 = this.exercicesComptableDao.selectExercicesCompta((Session)null);
      UtilNombre var3 = new UtilNombre();
      UtilDate var4 = new UtilDate();
      EcrituresDao var5 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      EcrituresAnterieurDao var6 = new EcrituresAnterieurDao(this.baseLog, this.utilInitHibernate);
      this.lesEcritures = new ArrayList();
      new ArrayList();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      if (var2.size() != 0) {
         int var8 = 0;

         for(int var9 = 0; var9 < var2.size(); ++var9) {
            long var10 = ((ExercicesComptable)var2.get(var9)).getExecpt_id();
            if (var10 != 0L) {
               Session var12 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
               Transaction var13 = null;

               try {
                  var13 = var12.beginTransaction();
                  this.lesEcritures = var5.ChargerLesEcrituresRapprochees(var10, var12);
                  int var15;
                  double var16;
                  double var18;
                  double var20;
                  String[] var28;
                  if (this.lesEcritures.size() != 0) {
                     new Ecritures();

                     for(var15 = 0; var15 < this.lesEcritures.size(); ++var15) {
                        Ecritures var14 = (Ecritures)this.lesEcritures.get(var15);
                        this.var_info = "Exercice : " + var10 + " ecriture. " + var15 + " / Nb ecriture : " + this.lesEcritures.size();
                        if (var15 != 0) {
                           var16 = (double)this.lesEcritures.size();
                           var18 = var3.myRound(var16 / (double)var15, 4);
                           var20 = var3.myRound(100.0D / var18, 2);
                           this.var_currentValue = (int)var20;
                        }

                        ++var8;
                        if (var14.getEcrRapprochement() != null && !var14.getEcrRapprochement().isEmpty()) {
                           var28 = var14.getEcrRapprochement().split(":");
                           if (var28[0].length() == 2 && var28[1].length() == 4) {
                              var14.setEcrRapprochement(var28[1] + ":" + var28[0]);
                              var14.setEcrDteRapprochement(var4.stringToDateSQLLight(var28[1] + "-" + var28[0] + "-01"));
                           } else {
                              var14.setEcrDteRapprochement(var4.stringToDateSQLLight(var28[0] + "-" + var28[1] + "-01"));
                           }

                           var5.modif(var14, var12);
                           if (var8 == 200) {
                              var12.flush();
                              var8 = 0;
                           }
                        }
                     }
                  }

                  var8 = 0;
                  this.var_currentValue = 0;
                  List var7 = var6.chargerLesEcrituresRapprochees(var10, var12);
                  if (var7.size() != 0) {
                     new EcrituresAnterieur();

                     for(var15 = 0; var15 < var7.size(); ++var15) {
                        EcrituresAnterieur var27 = (EcrituresAnterieur)var7.get(var15);
                        this.var_info = "Exercice anterieure: " + var10 + " ecriture. " + var15 + " / Nb ecriture : " + var7.size();
                        if (var15 != 0) {
                           var16 = (double)var7.size();
                           var18 = var3.myRound(var16 / (double)var15, 4);
                           var20 = var3.myRound(100.0D / var18, 2);
                           this.var_currentValue = (int)var20;
                        }

                        ++var8;
                        if (var27.getEcrantRapprochement() != null && !var27.getEcrantRapprochement().isEmpty()) {
                           var28 = var27.getEcrantRapprochement().split(":");
                           if (var28[0].length() == 2 && var28[1].length() == 4) {
                              var27.setEcrantRapprochement(var28[1] + ":" + var28[0]);
                              var27.setEcrantDteRapprochement(var4.stringToDateSQLLight(var28[1] + "-" + var28[0] + "-01"));
                           } else {
                              var27.setEcrantDteRapprochement(var4.stringToDateSQLLight(var28[0] + "-" + var28[1] + "-01"));
                           }

                           var6.modif(var27, var12);
                           if (var8 == 200) {
                              var12.flush();
                              var8 = 0;
                           }
                        }
                     }
                  }

                  var12.flush();
                  var13.commit();
               } catch (HibernateException var25) {
                  if (var13 != null) {
                     var13.rollback();
                  }

                  throw var25;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            } else {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculPlanComptable() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul plan comptable");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      ArrayList var2 = new ArrayList();
      new ExercicesComptable();
      ExercicesComptable var3 = this.exercicesComptableDao.recupererLastExo((Session)null);
      if (var3 != null) {
         var2.add(var3);
      }

      UtilNombre var4 = new UtilNombre();
      new ArrayList();
      new ArrayList();
      new PlanComptable();
      new Tiers();
      PlanComptableDao var9 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      List var6 = this.tiersDao.selectTiers();
      new Tiers();
      RacinesDao var10 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      if (var2.size() != 0) {
         int var11 = 0;

         for(int var12 = 0; var12 < var2.size(); ++var12) {
            long var13 = ((ExercicesComptable)var2.get(var12)).getExecpt_id();
            if (var13 != 0L) {
               Session var15 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
               Transaction var16 = null;

               try {
                  var16 = var15.beginTransaction();
                  String var17 = this.structureLog.getStrzonefiscale();
                  List var5 = var9.chargerLesPlanscomptables(var17, var13, var15);
                  if (var5.size() != 0) {
                     for(int var18 = 0; var18 < var5.size(); ++var18) {
                        PlanComptable var7 = (PlanComptable)var5.get(var18);
                        this.var_info = "Exercice : " + var13 + " compte. " + var18 + " / Nb compte : " + var5.size();
                        if (var18 != 0) {
                           double var19 = (double)var5.size();
                           double var21 = var4.myRound(var19 / (double)var18, 4);
                           double var23 = var4.myRound(100.0D / var21, 2);
                           this.var_currentValue = (int)var23;
                        }

                        ++var11;
                        if (var7.getPlcSage() != null && !var7.getPlcSage().isEmpty()) {
                           for(int var30 = 0; var30 < var6.size(); ++var30) {
                              Tiers var8 = (Tiers)var6.get(var30);
                              if (var8.getTiecompteSage() != null && !var8.getTiecompteSage().isEmpty() && var8.getTiecompteSage().equals(var7.getPlcSage())) {
                                 var8.setTiecompte0(var7.getPlcCompte());
                                 this.tiersDao.modif(var8, var15);
                                 break;
                              }
                           }
                        }

                        if (var7.getPlcCodeRacine() != null && !var7.getPlcCodeRacine().isEmpty() && var7.getPlcCodeRacine().equals("99999")) {
                           new Racines();
                           Racines var31 = this.rechercheRacine(var10, var7.getPlcCompte(), var7.getPlcFiscalite(), var15);
                           var7.setPlcCodeRacine(var31.getRacCode());
                           int var20;
                           if (var31.getRacLibelleFr() != null && !var31.getRacLibelleFr().isEmpty()) {
                              var20 = var31.getRacLibelleFr().length();
                              if (var20 >= 99) {
                                 var20 = 99;
                              }

                              var7.setPlcLibelleRacineFR(var31.getRacLibelleFr().substring(0, var20));
                           }

                           if (var31.getRacLibelleSp() != null && !var31.getRacLibelleSp().isEmpty()) {
                              var20 = var31.getRacLibelleSp().length();
                              if (var20 >= 99) {
                                 var20 = 99;
                              }

                              var7.setPlcLibelleRacineSP(var31.getRacLibelleSp().substring(0, var20));
                           }

                           if (var31.getRacLibelleUk() != null && !var31.getRacLibelleUk().isEmpty()) {
                              var20 = var31.getRacLibelleUk().length();
                              if (var20 >= 99) {
                                 var20 = 99;
                              }

                              var7.setPlcLibelleRacineUK(var31.getRacLibelleUk().substring(0, var20));
                           }

                           if (var31.getRacCodenature() == null || var31.getRacCodenature().isEmpty()) {
                              var31.setRacCodenature("0");
                           }

                           var20 = Integer.parseInt(var31.getRacCodenature());
                           var7.setPlcNature(var20);
                           var7.setPlcLibelleNatureFR(var31.getRacnature());
                           var7.setPlcLibre(this.calculPlcLibre(var7.getPlcCompte(), var31.getRacCode()));
                           var9.modif(var7, var15);
                        }

                        if (var11 == 200) {
                           var15.flush();
                           var11 = 0;
                        }
                     }
                  }

                  var15.flush();
                  var16.commit();
               } catch (HibernateException var28) {
                  if (var16 != null) {
                     var16.rollback();
                  }

                  throw var28;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            } else {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public Racines rechercheRacine(RacinesDao var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      Racines var5 = new Racines();
      int var6 = var2.length();
      String var7 = "";
      int var8 = 0;

      for(int var9 = var6; var9 != 1; --var9) {
         ++var8;
         var7 = var2.substring(0, var6 - var8);
         String var10 = "";
         if (var3 != null && !var3.isEmpty()) {
            var10 = var3;
         } else {
            var10 = this.structureLog.getStrzonefiscale();
         }

         var5 = var1.rechercherCodeRacine(var10, var7, var4);
         if (var5 != null) {
            break;
         }
      }

      if (var5 == null) {
         var5 = new Racines();
         var5.setRacCode("99999");
         var5.setRacLibelleFr("Racine Inconnue");
         var5.setRacLibelleSp("Unknown root");
         var5.setRacLibelleSp("Racina incognita");
      }

      return var5;
   }

   public String calculPlcLibre(String var1, String var2) {
      String var3 = null;
      int var4 = var2.length();
      var3 = var1.substring(var4);
      return var3;
   }

   public void recalculCompteAmortissements() throws HibernateException, NamingException, IOException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des libellés des comptes des amortissements");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      this.optionComptabilite = new OptionComptabilite();
      LireLesoptionsCompta var2 = new LireLesoptionsCompta(this.structureLog);
      var2.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = var2.lancer();
      ArrayList var3 = new ArrayList();
      new ExercicesComptable();
      ExercicesComptable var4 = this.exercicesComptableDao.recupererLastExo((Session)null);
      if (var4 != null) {
         var3.add(var4);
      }

      Utilitaires_Compta var5 = new Utilitaires_Compta(this);
      UtilNombre var6 = new UtilNombre();
      new ArrayList();
      new PlanComptable();
      PlanComptableDao var9 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new Amortissements();
      AmortissementsDao var12 = new AmortissementsDao(this.baseLog, this.utilInitHibernate);
      List var10 = var12.selectAmortissement();
      new ArrayList();
      ActivitesDao var14 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      boolean var15 = false;
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         var15 = true;
      } else {
         var15 = false;
      }

      long var16 = var12.trouverDernier((Session)null);
      int var18 = Integer.parseInt(this.optionComptabilite.getNbcr());
      int var19 = 0;
      Session var20 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
      Transaction var21 = null;

      try {
         var21 = var20.beginTransaction();
         List var7 = var9.chargerLesPlanscomptables((String)null, 0L, var20);
         List var13 = var14.selectActivites(var20);
         if (var10.size() != 0 && var7.size() != 0) {
            for(int var22 = 0; var22 < var10.size(); ++var22) {
               Amortissements var11 = (Amortissements)var10.get(var22);
               this.var_info = " amortissement. " + var22 + " / Nb amortissements : " + var10.size();
               if (var22 != 0) {
                  double var23 = (double)var10.size();
                  double var25 = var6.myRound(var23 / (double)var22, 4);
                  double var27 = var6.myRound(100.0D / var25, 2);
                  this.var_currentValue = (int)var27;
               }

               ++var19;
               var5.recalculCompteAmortissements(var18, var15, var16, var19, var11, var7, var13, var12, var20);
            }
         }

         var20.flush();
         var21.commit();
      } catch (HibernateException var32) {
         if (var21 != null) {
            var21.rollback();
         }

         throw var32;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void genePlanComptableTiers() throws NamingException, HibernateException, IOException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("Génération plan comptable à partir des tiers");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      Utilitaires_Compta var2 = new Utilitaires_Compta(this);
      new ExercicesComptable();
      ExercicesComptable var3 = this.exercicesComptableDao.recupererLastExo((Session)null);
      new UtilNombre();
      new ArrayList();
      PlanComptable var6 = new PlanComptable();
      PlanComptableDao var7 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      String var8 = this.structureLog.getStrzonefiscale();
      new ArrayList();
      Racines var10 = new Racines();
      RacinesDao var11 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
      List var9 = var11.chargerMesRacines(var8, (Session)null);
      new ArrayList();
      new Tiers();
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      List var12 = this.tiersDao.selectTiers();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      if (var3 != null && var12.size() != 0) {
         Session var14 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
         Transaction var15 = null;

         try {
            var15 = var14.beginTransaction();
            var2.genePlanComptableTiers(var12, var9, var10, var6, var7, this.structureLog, this.usersLog, var3, this.tiersDao, var14);
            var15.commit();
         } catch (HibernateException var20) {
            if (var15 != null) {
               var15.rollback();
            }

            throw var20;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculCompteEcritures() throws HibernateException, NamingException, IOException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des libellés des comptes des écritures");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      this.optionComptabilite = new OptionComptabilite();
      LireLesoptionsCompta var2 = new LireLesoptionsCompta(this.structureLog);
      var2.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = var2.lancer();
      ArrayList var3 = new ArrayList();
      new ExercicesComptable();
      ExercicesComptable var4 = this.exercicesComptableDao.recupererLastExo((Session)null);
      if (var4 != null) {
         var3.add(var4);
      }

      Utilitaires_Compta var5 = new Utilitaires_Compta(this);
      UtilNombre var6 = new UtilNombre();
      new ArrayList();
      new PlanComptable();
      PlanComptableDao var9 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.lesEcritures = new ArrayList();
      new Ecritures();
      EcrituresDao var11 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.lesEcritures = var11.ChargerLesEcritures(var4.getExecpt_id(), (Session)null);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      int var12 = Integer.parseInt(this.optionComptabilite.getNbcr());
      int var13 = 0;
      Session var14 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var15 = null;

      try {
         var15 = var14.beginTransaction();
         List var7 = var9.chargerLesPlanscomptables((String)null, 0L, var14);
         if (this.lesEcritures.size() != 0 && var7.size() != 0) {
            for(int var16 = 0; var16 < this.lesEcritures.size(); ++var16) {
               Ecritures var10 = (Ecritures)this.lesEcritures.get(var16);
               this.var_info = " Ecritures. " + var16 + " / Nb Ecritures : " + this.lesEcritures.size();
               if (var16 != 0) {
                  double var17 = (double)this.lesEcritures.size();
                  double var19 = var6.myRound(var17 / (double)var16, 4);
                  double var21 = var6.myRound(100.0D / var19, 2);
                  this.var_currentValue = (int)var21;
               }

               ++var13;
               var5.recalculCompteEcritures(var12, var13, var10, var7, var11, var14);
            }
         }

         var14.flush();
         var15.commit();
      } catch (HibernateException var26) {
         if (var15 != null) {
            var15.rollback();
         }

         throw var26;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculColonneEuro() throws HibernateException, NamingException, ParseException, IOException, groovyjarjarcommonscli.ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Colonne Euro");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      Utilitaires_Compta var2 = new Utilitaires_Compta(this);
      LireLesoptionsCompta var3 = new LireLesoptionsCompta(this.structureLog);
      var3.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = new OptionComptabilite();
      var3.lancer();
      this.optionComptabilite = var3.getOptionComptabilite();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      new ArrayList();
      EcrituresDao var6 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      List var5 = var6.chargerEcritures(this.var_date_deb, this.var_date_fin, var4);
      if (var5.size() != 0) {
         Transaction var7 = null;

         try {
            var7 = var4.beginTransaction();
            var2.recalculColonneEuro(this.optionComptabilite, var5, var6, var4);
            var7.commit();
         } catch (HibernateException var12) {
            if (var7 != null) {
               var7.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculDateEcheances() throws HibernateException, NamingException, ParseException, IOException, groovyjarjarcommonscli.ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Date echeance");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      Utilitaires_Compta var2 = new Utilitaires_Compta(this);
      LireLesoptionsCompta var3 = new LireLesoptionsCompta(this.structureLog);
      var3.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = new OptionComptabilite();
      var3.lancer();
      this.optionComptabilite = var3.getOptionComptabilite();
      Tiers var4 = new Tiers();
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      UtilDate var5 = new UtilDate();
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      new ArrayList();
      EcrituresDao var8 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      List var7 = var8.chargerEcritures(this.var_date_deb, this.var_date_fin, var6);
      if (var7.size() != 0) {
         Transaction var9 = null;

         try {
            var9 = var6.beginTransaction();
            var2.recalculDateEcheance(var5, var4, this.tiersDao, this.optionComptabilite, var7, var8, var6);
            var9.commit();
         } catch (HibernateException var14) {
            if (var9 != null) {
               var9.rollback();
            }

            throw var14;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void rechercherAnnulTrfAchats() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.lesDocumentsEntete.clear();
         LireLesoptionsAchats var1 = new LireLesoptionsAchats();
         var1.setStrId(this.structureLog.getStrid());
         var1.lancer();
         this.optionAchats = new OptionAchats();
         this.optionAchats = var1.getOptionAchats();
         Utilitaires_Achats var2 = new Utilitaires_Achats();
         this.lesDocumentsEntete = var2.rechercherAnnulTrfAchats(this.var_date_deb, this.var_date_fin, this.lesDocumentsEntete, this.baseLog, this.utilInitHibernate, this.optionAchats);
         this.dataModelDocumentEntete.setWrappedData(this.lesDocumentsEntete);
      }

   }

   public void toutSelectionAnnulTrfAchats() {
      if (this.lesDocumentsEntete.size() != 0) {
         new DocumentEntete();

         for(int var2 = 0; var2 < this.lesDocumentsEntete.size(); ++var2) {
            DocumentEntete var1 = (DocumentEntete)this.lesDocumentsEntete.get(var2);
            var1.setDocSelect(true);
         }
      }

   }

   public void rienSelectionAnnulTrfAchats() {
      if (this.lesDocumentsEntete.size() != 0) {
         new DocumentEntete();

         for(int var2 = 0; var2 < this.lesDocumentsEntete.size(); ++var2) {
            DocumentEntete var1 = (DocumentEntete)this.lesDocumentsEntete.get(var2);
            var1.setDocSelect(false);
         }
      }

   }

   public void annulTrfAchats() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("annule Trf Achats du " + this.var_date_deb + " au " + this.var_date_fin);
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Utilitaires_Achats var2 = new Utilitaires_Achats();
         var2.annulTrfAchats(this.var_date_deb, this.var_date_fin, this.lesDocumentsEntete, this.baseLog, this.utilInitHibernate);
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void forceTrfAchats() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("force Trf Achats du " + this.var_date_deb + " au " + this.var_date_fin);
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Utilitaires_Achats var2 = new Utilitaires_Achats();
         var2.forceTrfAchats(this.var_date_deb, this.var_date_fin, this.baseLog, this.optionAchats, this.utilInitHibernate);
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void reimputationDepot() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("reimputation Depot");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new ArrayList();
      InventaireLigneDao var3 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.rechercheInventaireRequete("invligId<>0", (Session)null);
      if (var2.size() != 0) {
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEntete");
         Transaction var5 = null;

         try {
            var5 = var4.beginTransaction();
            new InventaireLigne();

            for(int var7 = 0; var7 < var2.size(); ++var7) {
               new InventaireLigne();
               InventaireLigne var6 = (InventaireLigne)var2.get(var7);
               var6.setInvligDepot(var6.getInventaireEntete().getInvDepot());
               var3.modifLigne(var6, var4);
            }

            var5.commit();
         } catch (HibernateException var53) {
            if (var5 != null) {
               var5.rollback();
            }

            throw var53;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      CessionLigneDao var56 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
      List var55 = var56.rechercheCessionRequete("cesligId<>0", (Session)null);
      if (var55.size() != 0) {
         Session var57 = this.utilInitHibernate.getOpenSession(this.baseLog, "CessionEntete");
         Transaction var59 = null;

         try {
            var59 = var57.beginTransaction();
            new CessionLigne();

            for(int var9 = 0; var9 < var55.size(); ++var9) {
               new CessionLigne();
               CessionLigne var8 = (CessionLigne)var55.get(var9);
               var8.setCesligDepotOrigine(var8.getCessionEntete().getCesDepotOrigine());
               var8.setCesligDepotDestination(var8.getCessionEntete().getCesDepotDestination());
               var56.modifLigne(var8, var57);
            }

            var59.commit();
         } catch (HibernateException var51) {
            if (var59 != null) {
               var59.rollback();
            }

            throw var51;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      BonEntreeLigneDao var60 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
      List var58 = var60.rechercheBEntreeRequete("binligId<>0", (Session)null);
      if (var58.size() != 0) {
         Session var61 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEntete");
         Transaction var63 = null;

         try {
            var63 = var61.beginTransaction();
            new BonEntreeLigne();

            for(int var11 = 0; var11 < var58.size(); ++var11) {
               new BonEntreeLigne();
               BonEntreeLigne var10 = (BonEntreeLigne)var58.get(var11);
               var10.setBinligDepot(var10.getBonEntreeEntete().getBinDepot());
               var60.modifLigne(var10, var61);
            }

            var63.commit();
         } catch (HibernateException var49) {
            if (var63 != null) {
               var63.rollback();
            }

            throw var49;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      BonSortieLigneDao var64 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
      List var62 = var64.rechercheBonSortieRequete("bouligId<>0", (Session)null);
      if (var62.size() != 0) {
         Session var65 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonSortieEntete");
         Transaction var66 = null;

         try {
            var66 = var65.beginTransaction();
            new BonSortieLigne();

            for(int var13 = 0; var13 < var62.size(); ++var13) {
               new BonSortieLigne();
               BonSortieLigne var12 = (BonSortieLigne)var62.get(var13);
               var12.setBouligDepot(var12.getBonSortieEntete().getBouDepot());
               var64.modifLigne(var12, var65);
            }

            var66.commit();
         } catch (HibernateException var47) {
            if (var66 != null) {
               var66.rollback();
            }

            throw var47;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculStock() throws HibernateException, NamingException, ParseException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Stock");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      var2.lancer();
      this.optionVentes = var2.getOptionsVentes();
      UtilNombre var3 = new UtilNombre();
      new ArrayList();
      CalculStock var5 = new CalculStock();
      DepotAchatsDao var6 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      List var4 = var6.selectAllDepot((Session)null);
      if (var4.size() != 0) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();
            this.var_currentValue = 0;
            this.var_showBarProg = true;

            for(int var9 = 0; var9 < var4.size(); ++var9) {
               new DepotAchats();
               DepotAchats var10 = (DepotAchats)var4.get(var9);
               if (!var10.isInactif()) {
                  this.var_info = "Calcul stock du depot : " + var10.getDpoCode();
                  if (var9 != 0) {
                     double var11 = (double)var4.size();
                     double var13 = var3.myRound(var11 / (double)var9, 4);
                     double var15 = var3.myRound(100.0D / var13, 2);
                     this.var_currentValue = (int)var15;
                  }

                  var5.recalculStockGlobal(var10.getDpoCode(), this.optionVentes.getGestionStockBc(), this.baseLog, this.structureLog, var7);
               }
            }

            var8.commit();
         } catch (HibernateException var20) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var20;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void libelleDocProduitAchs() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("libelle Doc Produit Achs");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new ArrayList();
      ProduitsAchsDao var3 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         List var2 = var3.selectAllProduits(var4);
         if (var2.size() != 0) {
            for(int var6 = 0; var6 < var2.size(); ++var6) {
               new Produits();
               Produits var7 = (Produits)var2.get(var6);
               String var8 = var7.getProCode();
               String var9 = var7.getProLibClient();
               String var10 = var7.getProLibTech();
               new ArrayList();
               CotationLigneAchatsDao var12 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               String var13 = "cotligCode = '" + var8 + "'";
               List var11 = var12.rechercheCotationRequete(var13, var4);
               if (var11.size() != 0) {
                  for(int var14 = 0; var14 < var11.size(); ++var14) {
                     new CotationLigneAchats();
                     CotationLigneAchats var15 = (CotationLigneAchats)var11.get(var14);
                     var15.setCotligLibelle(var9);
                     var15.setCotligReference(var10);
                     var12.modifLigne(var15, var4);
                  }
               }

               new ArrayList();
               CommandeLigneAchatsDao var34 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var13 = "cmdligCode = '" + var8 + "'";
               List var33 = var34.rechercheCommandeRequete(var13, var4);
               if (var33.size() != 0) {
                  for(int var16 = 0; var16 < var33.size(); ++var16) {
                     new CommandeLigneAchats();
                     CommandeLigneAchats var17 = (CommandeLigneAchats)var33.get(var16);
                     var17.setCmdligLibelle(var9);
                     var17.setCmdligReference(var10);
                     var34.modifLigne(var17, var4);
                  }
               }

               new ArrayList();
               ReceptionLigneAchatsDao var36 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var13 = "recligCode = '" + var8 + "'";
               List var35 = var36.rechercheReceptionRequete(var13, var4);
               if (var35.size() != 0) {
                  for(int var18 = 0; var18 < var35.size(); ++var18) {
                     new ReceptionLigneAchats();
                     ReceptionLigneAchats var19 = (ReceptionLigneAchats)var35.get(var18);
                     var19.setRecligLibelle(var9);
                     var19.setRecligReference(var10);
                     var36.modifLigne(var19, var4);
                  }
               }

               new ArrayList();
               RetourLigneAchatsDao var38 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var13 = "brfligCode = '" + var8 + "'";
               List var37 = var38.rechercheRetourRequete(var13, var4);
               if (var37.size() != 0) {
                  for(int var20 = 0; var20 < var37.size(); ++var20) {
                     new RetourLigneAchats();
                     RetourLigneAchats var21 = (RetourLigneAchats)var37.get(var20);
                     var21.setBrfligLibelle(var9);
                     var21.setBrfligReference(var10);
                     var38.modifLigne(var21, var4);
                  }
               }

               new ArrayList();
               FactureLigneAchatsDao var40 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var13 = "fcfligCode = '" + var8 + "'";
               List var39 = var40.rechercheFactureRequete(var13, var4);
               if (var39.size() != 0) {
                  for(int var22 = 0; var22 < var39.size(); ++var22) {
                     new FactureLigneAchats();
                     FactureLigneAchats var23 = (FactureLigneAchats)var39.get(var22);
                     var23.setFcfligLibelle(var9);
                     var23.setFcfligReference(var10);
                     var40.modifLigne(var23, var4);
                  }
               }

               new ArrayList();
               AvoirLigneAchatsDao var42 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var13 = "avfligCode = '" + var8 + "'";
               List var41 = var42.rechercheAvoirRequete(var13, var4);
               if (var41.size() != 0) {
                  for(int var24 = 0; var24 < var41.size(); ++var24) {
                     new AvoirLigneAchats();
                     AvoirLigneAchats var25 = (AvoirLigneAchats)var41.get(var24);
                     var25.setAvfligLibelle(var9);
                     var25.setAvfligReference(var10);
                     var42.modifLigne(var25, var4);
                  }
               }

               new ArrayList();
               NoteDebitLigneAchatsDao var44 = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var13 = "ndfligCode = '" + var8 + "'";
               List var43 = var44.rechercheNoteDebitRequete(var13, var4);
               if (var43.size() != 0) {
                  for(int var26 = 0; var26 < var43.size(); ++var26) {
                     new NoteDebitLigneAchats();
                     NoteDebitLigneAchats var27 = (NoteDebitLigneAchats)var43.get(var26);
                     var27.setNdfligLibelle(var9);
                     var27.setNdfligReference(var10);
                     var44.modifLigne(var27, var4);
                  }
               }
            }
         }

         var5.commit();
      } catch (HibernateException var31) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var31;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void affectationDepotProduitAchs() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("affectation Depot Produit Achs");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      Object var3 = new ArrayList();
      ProduitsAchsDao var4 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      ProduitsVtesDao var5 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      Object var6 = new ArrayList();
      ProduitsDepotDao var7 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      if (this.listeDepot.size() != 0 && this.listeFamilleAchs.size() != 0) {
         Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         Transaction var9 = null;

         try {
            var9 = var8.beginTransaction();
            this.var_currentValue = 0;
            this.var_showBarProg = true;
            new DepotAchats();

            for(int var11 = 0; var11 < this.listeDepot.size(); ++var11) {
               DepotAchats var10 = (DepotAchats)this.listeDepot.get(var11);
               if (var10.isSelectDepot()) {
                  new FamillesProduitsAchats();

                  for(int var13 = 0; var13 < this.listeFamilleAchs.size(); ++var13) {
                     FamillesProduitsAchats var12 = (FamillesProduitsAchats)this.listeFamilleAchs.get(var13);
                     this.var_info = "Dépot: " + var10.getDpoCode() + "  Famille: " + var12.getFamachCode();
                     if (var13 != 0) {
                        double var14 = (double)this.listeFamilleAchs.size();
                        double var16 = var2.myRound(var14 / (double)var13, 4);
                        double var18 = var2.myRound(100.0D / var16, 2);
                        this.var_currentValue = (int)var18;
                     }

                     if (var12.isSelectFamille()) {
                        ((List)var3).clear();
                        var3 = var4.chargerLesProduitsAchatsByFamille(var12.getFamachCode(), var8);
                        int var15;
                        Produits var25;
                        ProduitsDepot var26;
                        if (((List)var3).size() != 0) {
                           new Produits();

                           for(var15 = 0; var15 < ((List)var3).size(); ++var15) {
                              var25 = (Produits)((List)var3).get(var15);
                              ((List)var6).clear();
                              var6 = var7.selectProdDepByprod(var25.getProCode(), var10.getDpoCode(), var8);
                              if (((List)var6).size() == 0) {
                                 var26 = new ProduitsDepot();
                                 var26.setDepot(var10);
                                 var26.setProduits(var25);
                                 var26.setProdepCle(var10.getDpoCode() + ":" + var25.getProCode());
                                 var26.setProdepGroupe("");
                                 var26.setProdepCle2(var26.getProdepGroupe() + ":" + var25.getProCode());
                                 var7.insert(var26, var8);
                              }

                              if (var25.getProStock() == 0) {
                                 var25.setProStock(1);
                                 var4.modif(var25, var8);
                              }
                           }
                        } else {
                           ((List)var3).clear();
                           var3 = var5.chargerLesProduitsVentesByFamille(var12.getFamachCode(), var8);
                           if (((List)var3).size() != 0) {
                              new Produits();

                              for(var15 = 0; var15 < ((List)var3).size(); ++var15) {
                                 var25 = (Produits)((List)var3).get(var15);
                                 ((List)var6).clear();
                                 var6 = var7.selectProdDepByprod(var25.getProCode(), var10.getDpoCode(), var8);
                                 if (((List)var6).size() == 0) {
                                    var26 = new ProduitsDepot();
                                    var26.setDepot(var10);
                                    var26.setProduits(var25);
                                    var26.setProdepCle(var10.getDpoCode() + ":" + var25.getProCode());
                                    var26.setProdepGroupe("");
                                    var26.setProdepCle2(var26.getProdepGroupe() + ":" + var25.getProCode());
                                    var7.insert(var26, var8);
                                 }

                                 if (var25.getProStock() == 0) {
                                    var25.setProStock(1);
                                    var4.modif(var25, var8);
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            var9.commit();
         } catch (HibernateException var23) {
            if (var9 != null) {
               var9.rollback();
            }

            throw var23;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void touteFamilleDeSelectionner() {
      new FamillesProduitsAchats();
      if (this.listeFamilleAchs.size() != 0) {
         for(int var2 = 0; var2 < this.listeFamilleAchs.size(); ++var2) {
            FamillesProduitsAchats var1 = (FamillesProduitsAchats)this.listeFamilleAchs.get(var2);
            var1.setSelectFamille(false);
         }

         this.dataModelFamille.setWrappedData(this.listeFamilleAchs);
      }

   }

   public void touteFamilleSelectionner() {
      new FamillesProduitsAchats();
      if (this.listeFamilleAchs.size() != 0) {
         for(int var2 = 0; var2 < this.listeFamilleAchs.size(); ++var2) {
            FamillesProduitsAchats var1 = (FamillesProduitsAchats)this.listeFamilleAchs.get(var2);
            var1.setSelectFamille(true);
         }

         this.dataModelFamille.setWrappedData(this.listeFamilleAchs);
      }

   }

   public void geneSoldeFactureAchats() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("gene Solde Facture Achats");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      Object var3 = new ArrayList();
      ReglementsDao var4 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      new ExercicesAchats();
      ExercicesAchats var5 = this.exercicesAchatsDao.recupererLastExo(var2);
      double var6 = 0.0D;
      if (var5 != null) {
         String var8 = "exercicesAchats.exeachId=" + var5.getExeachId();
         new ArrayList();
         FactureEnteteAchatsDao var10 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         List var9 = var10.rechercheFactureRequete(var8, var2);
         int var13;
         if (var9.size() != 0) {
            new FactureEnteteAchats();

            for(int var12 = 0; var12 < var9.size(); ++var12) {
               FactureEnteteAchats var11 = (FactureEnteteAchats)var9.get(var12);
               var6 = 0.0D;
               ((List)var3).clear();
               var3 = var4.reglementDocument(var11.getFcfId(), 15, var2);
               if (((List)var3).size() != 0) {
                  for(var13 = 0; var13 < ((List)var3).size(); ++var13) {
                     var6 += ((Reglements)((List)var3).get(var13)).getRglDepense();
                  }
               }

               var11.setFcfTotReglement(var6);
               if (var11.getFcfTotReglement() >= var11.getFcfTotTtc()) {
                  var11.setFcfSolde(1);
               } else {
                  var11.setFcfSolde(0);
               }

               var10.modif(var11, var2);
            }
         }

         new ArrayList();
         NoteDebitEnteteAchatsDao var19 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         List var18 = var19.rechercheNoteDebitRequete(var8, var2);
         int var15;
         if (var18.size() != 0) {
            for(var13 = 0; var13 < var18.size(); ++var13) {
               new NoteDebitEnteteAchats();
               NoteDebitEnteteAchats var14 = (NoteDebitEnteteAchats)var18.get(var13);
               var6 = 0.0D;
               ((List)var3).clear();
               var3 = var4.reglementDocument(var14.getNdfId(), 17, var2);
               if (((List)var3).size() != 0) {
                  for(var15 = 0; var15 < ((List)var3).size(); ++var15) {
                     var6 += ((Reglements)((List)var3).get(var15)).getRglDepense();
                  }
               }

               var14.setNdfTotReglement(var6);
               if (var14.getNdfTotReglement() >= var14.getNdfTotTtc()) {
                  var14.setNdfSolde(1);
               } else {
                  var14.setNdfSolde(0);
               }

               var19.modif(var14, var2);
            }
         }

         new ArrayList();
         FraisEnteteAchatsDao var20 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         List var21 = var20.rechercheFraisRequete(var8, var2);
         if (var21.size() != 0) {
            for(var15 = 0; var15 < var21.size(); ++var15) {
               new FraisEnteteAchats();
               FraisEnteteAchats var16 = (FraisEnteteAchats)var21.get(var15);
               var6 = 0.0D;
               ((List)var3).clear();
               var3 = var4.reglementDocument(var16.getFsfId(), 18, var2);
               if (((List)var3).size() != 0) {
                  for(int var17 = 0; var17 < ((List)var3).size(); ++var17) {
                     var6 += ((Reglements)((List)var3).get(var17)).getRglDepense();
                  }
               }

               var16.setFsfTotReglement(var6);
               if (var16.getFsfTotReglement() >= var16.getFsfTotTtc()) {
                  var16.setFsfSolde(1);
               } else {
                  var16.setFsfSolde(0);
               }

               var20.modif(var16, var2);
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void geneEcheanceFactureAchats() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("gene Echeance Facture Achats");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      ObjetReglement var2 = new ObjetReglement();
      new ArrayList();
      LectureReglementFournisseur var4 = new LectureReglementFournisseur();
      var4.setStrId(this.structureLog.getStrid());
      var4.setStructureLog(this.structureLog);
      var4.recupereReglementFournisseur();
      List var3 = var4.getMesReglementFournisseur();
      if (var3.size() != 0) {
         for(int var5 = 0; var5 < var3.size(); ++var5) {
            if (((ObjetReglement)var3.get(var5)).getDefaut().equals("true")) {
               var2 = (ObjetReglement)var3.get(var5);
            }
         }
      }

      if (var2 != null) {
         UtilDate var20 = new UtilDate();
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
         new ExercicesAchats();
         ExercicesAchats var7 = this.exercicesAchatsDao.recupererLastExo(var6);
         if (var7 != null) {
            String var8 = "exercicesAchats.exeachId=" + var7.getExeachId();
            new ArrayList();
            FactureEnteteAchatsDao var10 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
            List var9 = var10.rechercheFactureRequete(var8, var6);
            int var13;
            if (var9.size() != 0) {
               for(int var11 = 0; var11 < var9.size(); ++var11) {
                  new FactureEnteteAchats();
                  FactureEnteteAchats var12 = (FactureEnteteAchats)var9.get(var11);
                  if (var2.getEcheances() == null || var2.getEcheances().isEmpty()) {
                     var2.setEcheances("0");
                  }

                  var12.setFcfTypeReg(Integer.parseInt(var2.getEcheances()));
                  var12.setFcfModeReg(var2.getCategories() + ":" + var2.getLibelles());
                  var13 = 0;
                  if (var2.getNbjours() != null && !var2.getNbjours().isEmpty()) {
                     var13 = Integer.parseInt(var2.getNbjours());
                  }

                  var12.setFcfNbJourReg(var13);
                  int var14 = 0;
                  if (var2.getArrondis() != null && !var2.getArrondis().isEmpty()) {
                     var14 = Integer.parseInt(var2.getArrondis());
                  }

                  var12.setFcfArrondiReg(var14);
                  Date var15 = var20.CalculDateEcheance(var12.getFcfDate(), var12.getFcfTypeReg(), var12.getFcfNbJourReg(), var12.getFcfArrondiReg());
                  var12.setFcfDateEcheReg(var15);
                  var10.modif(var12, var6);
               }
            }

            new ArrayList();
            NoteDebitEnteteAchatsDao var22 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
            List var21 = var22.rechercheNoteDebitRequete(var8, var6);
            int var26;
            if (var21.size() != 0) {
               for(var13 = 0; var13 < var21.size(); ++var13) {
                  new NoteDebitEnteteAchats();
                  NoteDebitEnteteAchats var24 = (NoteDebitEnteteAchats)var21.get(var13);
                  if (var2.getEcheances() == null || var2.getEcheances().isEmpty()) {
                     var2.setEcheances("0");
                  }

                  var24.setNdfTypeReg(Integer.parseInt(var2.getEcheances()));
                  var24.setNdfModeReg(var2.getCategories() + ":" + var2.getLibelles());
                  var26 = 0;
                  if (var2.getNbjours() != null && !var2.getNbjours().isEmpty()) {
                     var26 = Integer.parseInt(var2.getNbjours());
                  }

                  var24.setNdfNbJourReg(var26);
                  int var16 = 0;
                  if (var2.getArrondis() != null && !var2.getArrondis().isEmpty()) {
                     var16 = Integer.parseInt(var2.getArrondis());
                  }

                  var24.setNdfArrondiReg(var16);
                  Date var17 = var20.CalculDateEcheance(var24.getNdfDate(), var24.getNdfTypeReg(), var24.getNdfNbJourReg(), var24.getNdfArrondiReg());
                  var24.setNdfDateEcheReg(var17);
                  var22.modif(var24, var6);
               }
            }

            new ArrayList();
            FraisEnteteAchatsDao var25 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
            List var23 = var25.rechercheFraisRequete(var8, var6);
            if (var23.size() != 0) {
               for(var26 = 0; var26 < var23.size(); ++var26) {
                  new FraisEnteteAchats();
                  FraisEnteteAchats var27 = (FraisEnteteAchats)var23.get(var26);
                  if (var2.getEcheances() == null || var2.getEcheances().isEmpty()) {
                     var2.setEcheances("0");
                  }

                  var27.setFsfTypeReg(Integer.parseInt(var2.getEcheances()));
                  var27.setFsfModeReg(var2.getCategories() + ":" + var2.getLibelles());
                  int var28 = 0;
                  if (var2.getNbjours() != null && !var2.getNbjours().isEmpty()) {
                     var28 = Integer.parseInt(var2.getNbjours());
                  }

                  var27.setFsfNbJourReg(var28);
                  int var18 = 0;
                  if (var2.getArrondis() != null && !var2.getArrondis().isEmpty()) {
                     var18 = Integer.parseInt(var2.getArrondis());
                  }

                  var27.setFsfArrondiReg(var18);
                  Date var19 = var20.CalculDateEcheance(var27.getFsfDate(), var27.getFsfTypeReg(), var27.getFsfNbJourReg(), var27.getFsfArrondiReg());
                  var27.setFsfDateEcheReg(var19);
                  var25.modif(var27, var6);
               }
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculValorisationReception() throws NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Valorisation Reception");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         DepotAchatsDao var5 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         String var6 = "";
         new ArrayList();
         List var7 = var5.selectActifDepot(13, var3);
         if (var7.size() != 0) {
            for(int var8 = 0; var8 < var7.size(); ++var8) {
               if (((DepotAchats)var7.get(var8)).getDpoType() == 2) {
                  var6 = var6 + "/" + ((DepotAchats)var7.get(var8)).getDpoCode() + "/";
               }
            }
         }

         LireLesoptionsAchats var33 = new LireLesoptionsAchats();
         var33.setStrId(this.structureLog.getStrid());
         this.optionAchats = var33.lancer();
         new ReceptionLigneAchats();
         new ArrayList();
         ReceptionLigneAchatsDao var11 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new FamillesProduitsAchats();
         FamillesProduitsAchatsDao var13 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
         new ReceptionEnteteAchats();
         String var15 = "reclig_id > 0 and (receptionEnteteAchats.recEtat=1 or receptionEnteteAchats.recEtat=4 or receptionEnteteAchats.recEtat=5) and receptionEnteteAchats.recExcluValo=false";
         List var10 = var11.rechercheReceptionRequete(var15, var3);
         if (var10.size() != 0) {
            for(int var16 = 0; var16 < var10.size(); ++var16) {
               ReceptionLigneAchats var9 = (ReceptionLigneAchats)var10.get(var16);
               ReceptionEnteteAchats var14 = var9.getReceptionEnteteAchats();
               this.var_info = "ligne reception: " + var9.getRecligCode() + " " + var9.getRecligLibelle();
               double var17;
               double var19;
               double var21;
               if (var16 != 0) {
                  var17 = (double)var10.size();
                  var19 = var2.myRound(var17 / (double)var16, 4);
                  var21 = var2.myRound(100.0D / var19, 2);
                  this.var_currentValue = (int)var21;
               }

               if (var9.getRecligFamille() != null && !var9.getRecligFamille().isEmpty()) {
                  if (var9.getReceptionEnteteAchats().getRecValorisation() == 0 && var9.getReceptionEnteteAchats().getRecCoefValo() != 0.0F) {
                     var17 = 0.0D;
                     if (var9.getRecligFob() != 0.0D) {
                        var17 = var9.getRecligFob() + var9.getRecligFret() + var9.getRecligAssurance() + var9.getRecligT1() + var9.getRecligT3() + var9.getRecligT5() + var9.getRecligT10() + var9.getRecligT30() + var9.getRecligT31() + var9.getRecligT46() + var9.getRecligT53() + var9.getRecligFrais() + var9.getRecligFinancier();
                     } else {
                        if (var14.getRecCoefValo() == 0.0F) {
                           var14.setRecCoefValo(1.0F);
                        }

                        var17 = var9.getRecligPt() * (double)var14.getRecCoefValo();
                     }

                     if (this.optionAchats.getModCalcPr().equals("1")) {
                        var17 += var9.getRecligTva();
                     }

                     var9.setRecligPr(var17);
                     var19 = 0.0D;
                     if (var9.getRecligQteUtil() != 0.0F) {
                        var19 = var2.myRound(var17 / (double)var9.getRecligQteUtil(), 2);
                     } else if (var9.getRecligQte() != 0.0F) {
                        var19 = var2.myRound(var17 / (double)var9.getRecligQte(), 2);
                     }

                     var9.setRecligPrU(var19);
                     if (var9.getRecligPoidsNet() != 0.0F) {
                        var21 = var2.myRound(var17 / (double)var9.getRecligPoidsNet(), 2);
                        var9.setRecligPrKg(var21);
                     } else {
                        var9.setRecligPrKg(0.0D);
                     }

                     var11.modifLigne(var9, var3);
                  } else if (var9.getReceptionEnteteAchats().getRecValorisation() != 1 && var9.getReceptionEnteteAchats().getRecValorisation() == 2) {
                     String var35 = "";
                     if (var9.getRecligFamille().contains(":")) {
                        String[] var18 = var9.getRecligFamille().split(":");
                        var35 = var18[0];
                     } else {
                        var35 = var9.getRecligFamille();
                     }

                     FamillesProduitsAchats var12 = var13.rechercheFamilleByCode(var9.getReceptionEnteteAchats().getExercicesAchats().getExeachId(), var35, var3);
                     if (var12 != null) {
                        float var36 = 0.0F;
                        if (var12.getFamachCoefValDefaut() != 0.0F) {
                           var36 = var12.getFamachCoefValDefaut();
                        } else {
                           var36 = 1.0F;
                        }

                        var19 = var9.getRecligPu() * (double)var9.getReceptionEnteteAchats().getRecCoefDevise();
                        var21 = 0.0D;
                        String var23 = "/" + var9.getRecligDepot() + "/";
                        if (var6.contains(var23)) {
                           var21 = var19;
                        } else {
                           var21 = var19 + var19 * (double)var36 / 100.0D;
                        }

                        if (this.optionAchats.getModCalcPr().equals("1")) {
                           var21 += var9.getRecligTva();
                        }

                        double var24 = var2.myRound(var21, 2);
                        if (var9.getRecligTauxRemise() != 0.0F) {
                           double var26 = var9.getRecligPu() * (double)var9.getRecligTauxRemise() - var9.getRecligPu() * (double)var9.getRecligTauxRemise() / 100.0D;
                           var9.setRecligPuRem(var26);
                        } else {
                           var9.setRecligPuRem(var9.getRecligPu());
                        }

                        var9.setRecligCoefPr(var36);
                        var9.setRecligPr(var24);
                        var9.setRecligPump(var24);
                        var11.modifLigne(var9, var3);
                     }
                  }
               }
            }
         }

         new FabricationEnteteAchats();
         FabricationEnteteAchatsDao var38 = new FabricationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         FabricationLigneAchatsDao var37 = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         new ArrayList();
         var15 = "fab_id > 0 and fabEtat=1";
         List var39 = var38.rechercheFabricationRequete(var15, var3);
         if (var39.size() != 0) {
            for(int var40 = 0; var40 < var39.size(); ++var40) {
               FabricationEnteteAchats var34 = (FabricationEnteteAchats)var39.get(var40);
               double var22 = 0.0D;
               List var20 = var37.chargerLesLignes(var34, var3);
               if (var20.size() != 0) {
                  for(int var41 = 0; var41 < var20.size(); ++var41) {
                     if (((FabricationLigneAchats)var20.get(var41)).getFabligType() == 1) {
                        var22 += ((FabricationLigneAchats)var20.get(var41)).getFabligPump() * (double)((FabricationLigneAchats)var20.get(var41)).getFabligQte();
                     }
                  }
               }

               var34.setFabTotPump(var22);
               var34.setFabPump(var22 / (double)var34.getFabQte());
               var38.modif(var34, var3);
            }
         }

         var4.commit();
      } catch (HibernateException var31) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var31;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void miseAJourDepot(ProduitsDepot var1, ProduitsDepotDao var2, String var3, double var4, double var6, double var8, float var10, Session var11) throws HibernateException, NamingException {
      if (this.optionAchats.getModDepPump().equals("1")) {
         new ArrayList();
         List var12 = var2.selectProdDepByprod(var3, var11);
         if (var12.size() != 0) {
            new ProduitsDepot();

            for(int var14 = 0; var14 < var12.size(); ++var14) {
               ProduitsDepot var13 = (ProduitsDepot)var12.get(var14);
               var13.setProdepPr(var4);
               var13.setProdepPrKg(var6);
               var13.setProdepPump(var8);
               var13.setProdepCoefPr(var10);
               var2.modif(var13, var11);
            }
         }
      } else {
         var1.setProdepPr(var4);
         var1.setProdepPrKg(var6);
         var1.setProdepPump(var8);
         var1.setProdepCoefPr(var10);
         var2.modif(var1, var11);
      }

   }

   public void recalculPumpMvts() throws NamingException, ParseException, groovyjarjarcommonscli.ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Pump Mvts");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      FormProduitsAchs var2 = new FormProduitsAchs();
      var2.setBaseLog(this.baseLog);
      var2.setStructureLog(this.structureLog);
      var2.setUsersLog(this.usersLog);
      var2.setutilInitHibernate(this.utilInitHibernate);
      this.var_info = "Chargement des produits...";
      UtilDate var3 = new UtilDate();
      new ArrayList();
      new Produits();
      ProduitsFournisseurDao var6 = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
      ProduitsAchsDao var7 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      FamillesProduitsAchatsDao var8 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      ProduitsDepotDao var9 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      InventaireLigneDao var10 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
      BonEntreeLigneDao var11 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
      BonSortieLigneDao var12 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
      CessionLigneDao var13 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
      FabricationLigneAchatsDao var14 = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      CotationLigneAchatsDao var15 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      CommandeLigneAchatsDao var16 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      RetourLigneAchatsDao var17 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      FactureLigneAchatsDao var18 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      AvoirLigneAchatsDao var19 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      DevisLigneVentesDao var20 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
      CommandeLigneVentesDao var21 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
      LivraisonLigneVentesDao var22 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      FactureLigneVentesDao var23 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      RetourLigneVentesDao var24 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
      AvoirLigneVentesDao var25 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      ChargementLigneDao var26 = new ChargementLigneDao(this.baseLog, this.utilInitHibernate);
      PumpAchatsDao var27 = new PumpAchatsDao(this.baseLog, this.utilInitHibernate);
      NoteDebitLigneVentesDao var28 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      new ExercicesAchats();
      ExercicesAchats var29 = this.exercicesAchatsDao.recupererLastExo((Session)null);
      CalculStock var30 = new CalculStock();
      UtilNombre var31 = new UtilNombre();
      Date var32 = var3.stringToDateSQL("2013-01-01 00:00:00");
      Date var33 = new Date();
      Utilitaires_RecalculPUMP var34 = new Utilitaires_RecalculPUMP(this.utilInitHibernate, this.baseLog, this.structureLog, this.usersLog);
      Session var35 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var36 = null;

      try {
         var36 = var35.beginTransaction();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         List var4 = var7.chargerLesProduitsAchats(var35);
         if (var4.size() != 0) {
            int var37 = 0;

            for(int var38 = 0; var38 < var4.size(); ++var38) {
               Produits var5 = (Produits)var4.get(var38);
               this.var_info = "Produit: " + var5.getProCode() + " " + var5.getProLibClient();
               if (var38 != 0) {
                  double var39 = (double)var4.size();
                  double var41 = var31.myRound(var39 / (double)var38, 4);
                  double var43 = var31.myRound(100.0D / var41, 2);
                  this.var_currentValue = (int)var43;
               }

               if (var5.getProInactif() == 0) {
                  new ArrayList();
                  List var50 = var9.selectProdDepByprod(var5, var35);
                  String var40 = "";
                  new ProduitsDepot();

                  for(int var42 = 0; var42 < var50.size(); ++var42) {
                     ProduitsDepot var51 = (ProduitsDepot)var50.get(var42);
                     var40 = var51.getDepot().getDpoCode();
                     var34.recalculPUMP(var3, var5, var40, var30, this.baseLog, this.structureLog, var32, var33, var35, var29, var6, var8, var7, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28);
                  }
               }

               ++var37;
               if (var37 == 100) {
                  var35.flush();
                  var37 = 0;
               }
            }
         }

         var36.commit();
      } catch (HibernateException var48) {
         if (var36 != null) {
            var36.rollback();
         }

         throw var48;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void desactivationProdZero() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("desactivation Prod Zero");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      new ArrayList();
      new ProduitsDepot();
      ProduitsDepotDao var5 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      Produits var6 = new Produits();
      ProduitsAchsDao var7 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      List var3 = var5.selectAllProdDep((Session)null);
      if (var3.size() != 0) {
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsNettoyage");
         Transaction var9 = null;

         try {
            var9 = var8.beginTransaction();

            for(int var10 = 0; var10 < var3.size(); ++var10) {
               ProduitsDepot var4 = (ProduitsDepot)var3.get(var10);
               this.var_info = "Produit: " + var6.getProCode() + " " + var6.getProLibClient();
               if (var10 != 0) {
                  double var11 = (double)var3.size();
                  double var13 = var2.myRound(var11 / (double)var10, 4);
                  double var15 = var2.myRound(100.0D / var13, 2);
                  this.var_currentValue = (int)var15;
               }

               if (var4.getProdepQteStk() == 0.0F) {
                  String var22 = var4.getProduits().getProCode();
                  var6 = var7.chargeProduit(var22, var8);
                  if (var6 != null) {
                     var6.setProInactif(1);
                     var6 = var7.modif(var6, var8);
                  }
               }
            }

            var9.commit();
         } catch (HibernateException var20) {
            if (var9 != null) {
               var9.rollback();
            }

            throw var20;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void suppressionProdDesactives() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("suppression Prod Desactives");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Utilitaires_Achats var2 = new Utilitaires_Achats();
      new ArrayList();
      new ArrayList();
      new ProduitsActe();
      ProduitsActeDao var6 = new ProduitsActeDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsDepot();
      ProduitsDepotDao var9 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsDetail();
      ProduitsDetailDao var12 = new ProduitsDetailDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsFourchette();
      ProduitsFourchetteDao var15 = new ProduitsFourchetteDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsFournisseur();
      ProduitsFournisseurDao var18 = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsGrp();
      ProduitsGrpDao var21 = new ProduitsGrpDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsHistoRef();
      ProduitsHistoRefDao var24 = new ProduitsHistoRefDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsLaboratoire();
      ProduitsLaboratoireDao var27 = new ProduitsLaboratoireDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsMcles();
      ProduitsMclesDao var30 = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsPharmacie();
      ProduitsPharmacieDao var33 = new ProduitsPharmacieDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsReponse();
      ProduitsReponseDao var36 = new ProduitsReponseDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsServices();
      ProduitsServicesDao var39 = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ProduitsTarif();
      ProduitsTarifDao var42 = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      new Produits();
      ProduitsAchsDao var44 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      UtilNombre var45 = new UtilNombre();
      List var3 = var44.chargerLesProduitsDesactive((Session)null);
      if (var3.size() != 0) {
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         Session var46 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsNettoyage");
         Transaction var47 = null;

         try {
            var47 = var46.beginTransaction();

            for(int var48 = 0; var48 < var3.size(); ++var48) {
               new Produits();
               Produits var43 = (Produits)var3.get(var48);
               long var49 = var43.getProId();
               this.var_info = "Produit: " + var43.getProCode() + " " + var43.getProLibClient();
               if (var48 != 0) {
                  double var51 = (double)var3.size();
                  double var53 = var45.myRound(var51 / (double)var48, 4);
                  double var55 = var45.myRound(100.0D / var53, 2);
                  this.var_currentValue = (int)var55;
               }

               var2.suppressionProduitsDesactive(var43, var6, var9, var12, var15, var18, var21, var24, var27, var30, var33, var36, var39, var42, var46);
               var43 = var44.chargeProduit(var49, var46);
               if (var43 != null) {
                  var44.delete(var43, var46);
               }
            }

            var47.commit();
         } catch (HibernateException var60) {
            if (var47 != null) {
               var47.rollback();
            }

            throw var60;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void verificationDossierImport() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("vérification dossier importation");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new PlansAnalytiques();
      new ArrayList();
      PlansAnalytiquesDao var4 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      new ValorisationEnteteAchats();
      List var3 = var4.selectAnal("6", (Session)null);
      new ArrayList();
      ValorisationEnteteAchatsDao var7 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      List var6 = var7.recherche((Session)null);
      new ReceptionEnteteAchats();
      ReceptionEnteteAchatsDao var9 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
      Transaction var11 = null;

      try {
         var11 = var10.beginTransaction();
         PlansAnalytiques var2;
         int var12;
         boolean var13;
         int var14;
         if (var6.size() != 0) {
            for(var12 = 0; var12 < var6.size(); ++var12) {
               ValorisationEnteteAchats var5 = (ValorisationEnteteAchats)var6.get(var12);
               if (var3.size() != 0) {
                  var13 = false;

                  for(var14 = 0; var14 < var3.size(); ++var14) {
                     var2 = (PlansAnalytiques)var3.get(var14);
                     if (var2.getAnaCode().equals(var5.getValDossierTransit())) {
                        var2.setAnaAch(true);
                        var2.setAnaFrg(false);
                        var2.setAnaInv(false);
                        var2.setAnaPrd(false);
                        var2.setAnaSal(false);
                        var2.setAnaTax(false);
                        var2.setAnaTva(false);
                        var2.setAnaVte(false);
                        var2.setAnaTypeDevise(var5.getValDevise());
                        var2.setAnaAnnee("" + (var5.getExercicesAchats().getExeachDateDebut().getYear() + 1900));
                        var2.setAnaTypeTauxDevise(var5.getValCoefDeviseDouane());
                        var2.setAnaTypeExoTva(var5.isValExoTva());
                        var2.setAnaTypeExoDouane(var5.isValExoDouane());
                        var2.setAnaTypeDossier("" + var5.getValMode());
                        if (var5.getValEtat() == 1) {
                           var2.setAnaInactif(3);
                        } else {
                           var2.setAnaInactif(0);
                        }

                        var4.modif(var2, var10);
                        ReceptionEnteteAchats var8 = var9.pourParapheurByDossier(var2.getAnaCode(), var10);
                        if (var8 != null && (var8.getRecObject() == null || var8.getRecObject().isEmpty())) {
                           var8.setRecObject(var2.getAnaNomFr());
                        }

                        var13 = true;
                        break;
                     }
                  }

                  if (!var13) {
                     var2 = new PlansAnalytiques();
                     var2.setAnaNature("6");
                     var2.setAnaAch(true);
                     var2.setAnaFrg(false);
                     var2.setAnaInv(false);
                     var2.setAnaPrd(false);
                     var2.setAnaSal(false);
                     var2.setAnaTax(false);
                     var2.setAnaTva(false);
                     var2.setAnaVte(false);
                     var2.setAnaCode(var5.getValDossierTransit());
                     var2.setAnaTypeDevise(var5.getValDevise());
                     var2.setAnaAnnee("" + (var5.getExercicesAchats().getExeachDateDebut().getYear() + 1900));
                     var2.setAnaTypeTauxDevise(var5.getValCoefDeviseDouane());
                     var2.setAnaTypeExoTva(var5.isValExoTva());
                     var2.setAnaTypeExoDouane(var5.isValExoDouane());
                     if (var5.getValEtat() == 1) {
                        var2.setAnaInactif(3);
                     } else {
                        var2.setAnaInactif(0);
                     }

                     var4.insert(var2, var10);
                  }
               }
            }
         }

         if (var3.size() != 0) {
            for(var12 = 0; var12 < var3.size(); ++var12) {
               var2 = (PlansAnalytiques)var3.get(var12);
               var13 = false;
               if (var6.size() != 0) {
                  for(var14 = 0; var14 < var6.size(); ++var14) {
                     if (((ValorisationEnteteAchats)var6.get(var14)).getValDossierTransit().equals(var2.getAnaCode())) {
                        var13 = true;
                        break;
                     }
                  }
               }

               if (!var13) {
                  var4.delete(var2, var10);
               }
            }
         }

         var11.commit();
      } catch (HibernateException var18) {
         if (var11 != null) {
            var11.rollback();
         }

         throw var18;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void extractionTvadouaneFacturesFrais() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("extraction TVA/douanes dans les factures de frais");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new ArrayList();
      new FraisEnteteAchats();
      FraisLigneAchatsDao var4 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      FraisEnteteAchatsDao var5 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      List var2 = var4.chargerTvaDouane((Session)null);
      new ArrayList();
      Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         if (var2.size() != 0) {
            for(int var9 = 0; var9 < var2.size(); ++var9) {
               FraisEnteteAchats var3 = ((FraisLigneAchats)var2.get(var9)).getFraisEnteteAchats();
               long var10 = var3.getFsfId();
               List var6 = var4.chargerLesLignes(var3, var7);
               if (var6.size() != 0) {
                  double var12 = 0.0D;
                  double var14 = 0.0D;
                  double var16 = 0.0D;
                  double var18 = 0.0D;
                  double var20 = 0.0D;

                  for(int var22 = 0; var22 < var6.size(); ++var22) {
                     new FraisLigneAchats();
                     FraisLigneAchats var23 = (FraisLigneAchats)var6.get(var22);
                     if (var23.getFsfligMode() == 4) {
                        var16 += var23.getFsfligTtc();
                        var14 = var14 + var23.getFsfligTva() + var23.getFsfligTtc();
                        var18 += var23.getFsfligTtc();
                     } else {
                        var12 += var23.getFsfligPt();
                        var18 += var23.getFsfligTtc();
                        var14 += var23.getFsfligTva();
                     }

                     if (var23.getFsfligRabais() != 0.0D || var23.getFsfligTauxRemise() != 0.0F) {
                        var20 += var23.getFsfligPu() * (double)var23.getFsfligQte() - var23.getFsfligPt();
                     }
                  }

                  var3 = var5.pourParapheur(var10, var7);
                  if (var3 != null) {
                     var3.setFsfTotHt(var12);
                     var3.setFsfTotTtc(var18);
                     var3.setFsfTotTva(var14);
                     var3.setFsfTotTvaDouane(var16);
                     var3.setFsfTotRemise(var20);
                     var5.modif(var3, var7);
                  }
               }
            }
         }

         var8.commit();
      } catch (HibernateException var27) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var27;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculConnexionCCRRFNFA() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul connexion de la table Cotation, BC, Réception, BR, Facture, Ndb, Frais, Avoir");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Utilitaires_Achats var2 = new Utilitaires_Achats();
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      UtilNombre var3 = new UtilNombre();
      UtilDate var4 = new UtilDate();
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      Transaction var6 = null;

      try {
         var6 = var5.beginTransaction();
         this.var_showBarProg = true;
         String var7 = var4.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         String var8 = var4.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         this.var_currentValue = 0;
         this.var_info = "Chargement des cotations...";
         var2.recalculConnexionCotation(this.tiersDao, var3, var7, var8, this.baseLog, this.utilInitHibernate, var5);
         this.var_currentValue = 1;
         this.var_info = "Chargement des bons de commande...";
         var2.recalculConnexionCommande(this.tiersDao, var3, var7, var8, this.baseLog, this.utilInitHibernate, var5);
         this.var_currentValue = 2;
         this.var_info = "Chargement des réceptions...";
         var2.recalculConnexionReception(this.tiersDao, var3, var7, var8, this.baseLog, this.utilInitHibernate, var5);
         this.var_currentValue = 3;
         this.var_info = "Chargement des bons de retour...";
         var2.recalculConnexionRetour(this.tiersDao, var3, var7, var8, this.baseLog, this.utilInitHibernate, var5);
         this.var_currentValue = 4;
         this.var_info = "Chargement des factures...";
         var2.recalculConnexionFacture(this.tiersDao, var3, var7, var8, this.baseLog, this.utilInitHibernate, var5);
         this.var_currentValue = 5;
         this.var_info = "Chargement des notes de débit...";
         var2.recalculConnexionNoteDebit(this.tiersDao, var3, var7, var8, this.baseLog, this.utilInitHibernate, var5);
         this.var_currentValue = 6;
         this.var_info = "Chargement des avoirs...";
         var2.recalculConnexionAvoir(this.tiersDao, var3, var7, var8, this.baseLog, this.utilInitHibernate, var5);
         this.var_currentValue = 7;
         this.var_info = "Chargement des frais...";
         var2.recalculConnexionFrais(this.tiersDao, var3, var7, var8, this.baseLog, this.utilInitHibernate, var5);
         var6.commit();
      } catch (HibernateException var12) {
         if (var6 != null) {
            var6.rollback();
         }

         throw var12;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void changeDossierImportation() throws HibernateException, NamingException {
      if (this.dossierCodeOld != null && !this.dossierCodeOld.isEmpty() && this.dossierCodeNew != null && !this.dossierCodeNew.isEmpty()) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("change code dossier importation");
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "changeDossier");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            String var4 = "";
            new ArrayList();
            CommandeEnteteAchatsDao var6 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
            var4 = "cmdAnal4='" + this.dossierCodeOld + "'";
            List var5 = var6.rechercheCommandeRequete(var4, var2);
            if (var5.size() != 0) {
               new CommandeEnteteAchats();

               for(int var8 = 0; var8 < var5.size(); ++var8) {
                  CommandeEnteteAchats var7 = (CommandeEnteteAchats)var5.get(var8);
                  if (this.dossierCodeNew != null && !this.dossierCodeNew.isEmpty()) {
                     var7.setCmdAnal4(this.dossierCodeNew);
                  }

                  if (this.dossierLibelleNew != null && !this.dossierLibelleNew.isEmpty()) {
                     var7.setCmdObject(this.dossierLibelleNew);
                  }

                  var6.modif(var7, var2);
               }
            }

            new ArrayList();
            ReceptionEnteteAchatsDao var23 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
            var4 = "recAnal4='" + this.dossierCodeOld + "'";
            List var22 = var23.rechercheReceptionRequete(var4, var2);
            if (var22.size() != 0) {
               new ReceptionEnteteAchats();

               for(int var10 = 0; var10 < var22.size(); ++var10) {
                  ReceptionEnteteAchats var9 = (ReceptionEnteteAchats)var22.get(var10);
                  if (this.dossierCodeNew != null && !this.dossierCodeNew.isEmpty()) {
                     var9.setRecAnal4(this.dossierCodeNew);
                  }

                  if (this.dossierLibelleNew != null && !this.dossierLibelleNew.isEmpty()) {
                     var9.setRecObject(this.dossierLibelleNew);
                  }

                  var23.modif(var9, var2);
               }
            }

            new ArrayList();
            FraisEnteteAchatsDao var25 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
            var4 = "fsfAnal4='" + this.dossierCodeOld + "'";
            List var24 = var25.rechercheFraisRequete(var4, var2);
            if (var24.size() != 0) {
               new FraisEnteteAchats();

               for(int var12 = 0; var12 < var24.size(); ++var12) {
                  FraisEnteteAchats var11 = (FraisEnteteAchats)var24.get(var12);
                  if (this.dossierCodeNew != null && !this.dossierCodeNew.isEmpty()) {
                     var11.setFsfAnal4(this.dossierCodeNew);
                     var25.modif(var11, var2);
                  }
               }
            }

            new ArrayList();
            ValorisationEnteteAchatsDao var27 = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
            var4 = "valDossierTransit='" + this.dossierCodeOld + "'";
            List var26 = var27.rechercheValorisationRequete(var4, var2);
            if (var26.size() != 0) {
               new ValorisationEnteteAchats();

               for(int var14 = 0; var14 < var26.size(); ++var14) {
                  ValorisationEnteteAchats var13 = (ValorisationEnteteAchats)var26.get(var14);
                  if (this.dossierCodeNew != null && !this.dossierCodeNew.isEmpty()) {
                     var13.setValDossierTransit(this.dossierCodeNew);
                  }

                  if (this.dossierLibelleNew != null && !this.dossierLibelleNew.isEmpty()) {
                     var13.setValObjet(this.dossierLibelleNew);
                  }

                  var27.modif(var13, var2);
               }
            }

            new ArrayList();
            PlansAnalytiquesDao var29 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
            var4 = "anaCode='" + this.dossierCodeOld + "' and anaNature='6'";
            List var28 = var29.rechercheAnalytiqueRequete(var4, var2);
            if (var28.size() != 0) {
               new PlansAnalytiques();

               for(int var16 = 0; var16 < var28.size(); ++var16) {
                  PlansAnalytiques var15 = (PlansAnalytiques)var28.get(var16);
                  if (this.dossierCodeNew != null && !this.dossierCodeNew.isEmpty()) {
                     var15.setAnaCode(this.dossierCodeNew);
                  }

                  if (this.dossierLibelleNew != null && !this.dossierLibelleNew.isEmpty()) {
                     var15.setAnaNomFr(this.dossierLibelleNew);
                  }

                  var29.modif(var15, var2);
               }
            }

            var3.commit();
         } catch (HibernateException var20) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var20;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void correctionFamilleAchat() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("correction des familles achats");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      ArrayList var3 = new ArrayList();
      new ArrayList();
      new Produits();
      ProduitsAchsDao var6 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      new FamillesProduitsAchats();
      FamillesProduitsAchatsDao var8 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.var_info = "Chargement des familles achats....";
      new ExercicesAchats();
      this.exercicesAchatsDao = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      ExercicesAchats var9 = this.exercicesAchatsDao.recupererLastExo((Session)null);
      if (var9 != null) {
         List var4 = var6.selectAllProduits((Session)null);
         if (var4.size() != 0) {
            Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");

            Produits var5;
            FamillesProduitsAchats var7;
            for(int var11 = 0; var11 < var4.size(); ++var11) {
               var5 = (Produits)var4.get(var11);
               if (var5.getProAchCode() == null && var5.getProAchCode().isEmpty()) {
                  var3.add(var5);
               } else {
                  var7 = var8.rechercheFamilleByProd(var9.getExeachId(), var5, var10);
                  if (var7 == null) {
                     var3.add(var5);
                  }
               }
            }

            if (var3.size() != 0) {
               boolean var25 = false;
               Transaction var12 = null;

               try {
                  var12 = var10.beginTransaction();

                  for(int var13 = 0; var13 < var3.size(); ++var13) {
                     var5 = (Produits)var3.get(var13);
                     this.var_info = "Famille " + ((Produits)var3.get(var13)).getProAchCode() + " Numero " + var13 + ", pour un total de " + var3.size() + " total ";
                     if (var13 != 0) {
                        double var14 = (double)var3.size();
                        double var16 = var2.myRound(var14 / (double)var13, 4);
                        double var18 = var2.myRound(100.0D / var16, 2);
                        this.var_currentValue = (int)var18;
                     }

                     if (var5.getProAchCode() == null || var5.getProAchCode().isEmpty()) {
                        var5.setProAchCode("XX");
                     }

                     boolean var26 = var8.existCode(var9.getExeachId(), var5.getProAchCode(), var10);
                     if (var26) {
                        var7 = new FamillesProduitsAchats();
                        var7.setExercicesAchats(var9);
                        var7.setFamachCode(var5.getProAchCode());
                        var7.setFamachLibelleFr(var5.getProAchLib());
                        var7.setFamachNature("0101");
                        var7.setFamachLibNature("Produits finis");
                        var7.setFamachCat(0);
                        var7.setFamachStock(0);
                        var8.insert(var7, var10);
                     }
                  }

                  var12.commit();
               } catch (HibernateException var23) {
                  if (var12 != null) {
                     var12.rollback();
                  }

                  throw var23;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            } else {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void famillesDocProduitAchs() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("famille Doc Produit Achs");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      new ArrayList();
      ProduitsAchsDao var4 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var6 = null;

      try {
         var6 = var5.beginTransaction();
         List var3 = var4.selectAllProduits(var5);
         if (var3.size() != 0) {
            new Produits();

            for(int var8 = 0; var8 < var3.size(); ++var8) {
               Produits var7 = (Produits)var3.get(var8);
               this.var_info = "Produit " + ((Produits)var3.get(var8)).getProCode() + " Numero " + var8 + ", pour un total de " + var3.size() + " total ";
               if (var8 != 0) {
                  double var9 = (double)var3.size();
                  double var11 = var2.myRound(var9 / (double)var8, 4);
                  double var13 = var2.myRound(100.0D / var11, 2);
                  this.var_currentValue = (int)var13;
               }

               String var43 = var7.getProCode();
               String var10 = var7.getProAchCode();
               new ArrayList();
               CotationLigneAchatsDao var12 = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               String var45 = "cotligCode = '" + var43 + "'";
               List var44 = var12.rechercheCotationRequete(var45, var5);
               if (var44.size() != 0) {
                  new CotationLigneAchats();

                  for(int var15 = 0; var15 < var44.size(); ++var15) {
                     CotationLigneAchats var14 = (CotationLigneAchats)var44.get(var15);
                     if (!var14.getCotligFamille().equals(var10)) {
                        var14.setCotligFamille(var10);
                        var12.modifLigne(var14, var5);
                     }
                  }
               }

               new ArrayList();
               CommandeLigneAchatsDao var47 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var45 = "cmdligCode = '" + var43 + "'";
               List var46 = var47.rechercheCommandeRequete(var45, var5);
               if (var46.size() != 0) {
                  new CommandeLigneAchats();

                  for(int var17 = 0; var17 < var46.size(); ++var17) {
                     CommandeLigneAchats var16 = (CommandeLigneAchats)var46.get(var17);
                     if (!var16.getCmdligFamille().equals(var10)) {
                        var16.setCmdligFamille(var10);
                        var47.modifLigne(var16, var5);
                     }
                  }
               }

               new ArrayList();
               ReceptionLigneAchatsDao var49 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var45 = "recligCode = '" + var43 + "'";
               List var48 = var49.rechercheReceptionRequete(var45, var5);
               if (var48.size() != 0) {
                  new ReceptionLigneAchats();

                  for(int var19 = 0; var19 < var48.size(); ++var19) {
                     ReceptionLigneAchats var18 = (ReceptionLigneAchats)var48.get(var19);
                     if (!var18.getRecligFamille().equals(var10)) {
                        var18.setRecligFamille(var10);
                        var49.modifLigne(var18, var5);
                     }
                  }
               }

               new ArrayList();
               RetourLigneAchatsDao var51 = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var45 = "brfligCode = '" + var43 + "'";
               List var50 = var51.rechercheRetourRequete(var45, var5);
               if (var50.size() != 0) {
                  new RetourLigneAchats();

                  for(int var21 = 0; var21 < var50.size(); ++var21) {
                     RetourLigneAchats var20 = (RetourLigneAchats)var50.get(var21);
                     if (!var20.getBrfligFamille().equals(var10)) {
                        var20.setBrfligFamille(var10);
                        var51.modifLigne(var20, var5);
                     }
                  }
               }

               new ArrayList();
               FactureLigneAchatsDao var53 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var45 = "fcfligCode = '" + var43 + "'";
               List var52 = var53.rechercheFactureRequete(var45, var5);
               if (var52.size() != 0) {
                  new FactureLigneAchats();

                  for(int var23 = 0; var23 < var52.size(); ++var23) {
                     FactureLigneAchats var22 = (FactureLigneAchats)var52.get(var23);
                     if (!var22.getFcfligFamille().equals(var10)) {
                        var22.setFcfligFamille(var10);
                        var53.modifLigne(var22, var5);
                     }
                  }
               }

               new ArrayList();
               FraisLigneAchatsDao var55 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var45 = "fsfligCode = '" + var43 + "'";
               List var54 = var55.rechercheFraisRequete(var45, var5);
               if (var54.size() != 0) {
                  new FraisLigneAchats();

                  for(int var25 = 0; var25 < var54.size(); ++var25) {
                     FraisLigneAchats var24 = (FraisLigneAchats)var54.get(var25);
                     if (!var24.getFsfligFamille().equals(var10)) {
                        var24.setFsfligFamille(var10);
                        var55.modifLigne(var24, var5);
                     }
                  }
               }

               new ArrayList();
               AvoirLigneAchatsDao var57 = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var45 = "avfligCode = '" + var43 + "'";
               List var56 = var57.rechercheAvoirRequete(var45, var5);
               if (var56.size() != 0) {
                  new AvoirLigneAchats();

                  for(int var27 = 0; var27 < var56.size(); ++var27) {
                     AvoirLigneAchats var26 = (AvoirLigneAchats)var56.get(var27);
                     if (!var26.getAvfligFamille().equals(var10)) {
                        var26.setAvfligFamille(var10);
                        var57.modifLigne(var26, var5);
                     }
                  }
               }

               new ArrayList();
               NoteDebitLigneAchatsDao var59 = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               var45 = "ndfligCode = '" + var43 + "'";
               List var58 = var59.rechercheNoteDebitRequete(var45, var5);
               if (var58.size() != 0) {
                  new NoteDebitLigneAchats();

                  for(int var29 = 0; var29 < var58.size(); ++var29) {
                     NoteDebitLigneAchats var28 = (NoteDebitLigneAchats)var58.get(var29);
                     if (!var28.getNdfligFamille().equals(var10)) {
                        var28.setNdfligFamille(var10);
                        var59.modifLigne(var28, var5);
                     }
                  }
               }

               new ArrayList();
               BonEntreeLigneDao var61 = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
               var45 = "binligCode = '" + var43 + "'";
               List var60 = var61.rechercheBEntreeRequete(var45, var5);
               if (var60.size() != 0) {
                  new BonEntreeLigne();

                  for(int var31 = 0; var31 < var60.size(); ++var31) {
                     BonEntreeLigne var30 = (BonEntreeLigne)var60.get(var31);
                     if (!var30.getBinligFamille().equals(var10)) {
                        var30.setBinligFamille(var10);
                        var61.modifLigne(var30, var5);
                     }
                  }
               }

               new ArrayList();
               BonSortieLigneDao var63 = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
               var45 = "bouligCode = '" + var43 + "'";
               List var62 = var63.rechercheBSortieRequete(var45, var5);
               if (var62.size() != 0) {
                  new BonSortieLigne();

                  for(int var33 = 0; var33 < var62.size(); ++var33) {
                     BonSortieLigne var32 = (BonSortieLigne)var62.get(var33);
                     if (!var32.getBouligFamille().equals(var10)) {
                        var32.setBouligFamille(var10);
                        var63.modifLigne(var32, var5);
                     }
                  }
               }

               new ArrayList();
               CessionLigneDao var65 = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
               var45 = "cesligCode = '" + var43 + "'";
               List var64 = var65.rechercheCessionRequete(var45, var5);
               if (var64.size() != 0) {
                  new CessionLigne();

                  for(int var35 = 0; var35 < var64.size(); ++var35) {
                     CessionLigne var34 = (CessionLigne)var64.get(var35);
                     if (!var34.getCesligFamille().equals(var10)) {
                        var34.setCesligFamille(var10);
                        var65.modifLigne(var34, var5);
                     }
                  }
               }

               new ArrayList();
               InventaireLigneDao var67 = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
               var45 = "invligCode = '" + var43 + "'";
               List var66 = var67.rechercheInventaireRequete(var45, var5);
               if (var66.size() != 0) {
                  new InventaireLigne();

                  for(int var37 = 0; var37 < var66.size(); ++var37) {
                     InventaireLigne var36 = (InventaireLigne)var66.get(var37);
                     if (!var36.getInvligFamille().equals(var10)) {
                        var36.setInvligFamille(var10);
                        var67.modifLigne(var36, var5);
                     }
                  }
               }

               var5.flush();
            }
         }

         var6.commit();
      } catch (HibernateException var41) {
         if (var6 != null) {
            var6.rollback();
         }

         throw var41;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculDerniereDatesAchs() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul dernières dates Cotations, CMD, REC, facture, note débit, avoir");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         UtilNombre var4 = new UtilNombre();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         this.var_info = "Chargement des fournisseurs...";
         String var5 = "";
         new Tiers();
         new ArrayList();
         new ArrayList();
         ReglementsDao var9 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         Object var10 = new ArrayList();
         CotationEnteteAchatsDao var11 = new CotationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         CommandeEnteteAchatsDao var13 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         ReceptionEnteteAchatsDao var15 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         RetourEnteteAchatsDao var17 = new RetourEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         FactureEnteteAchatsDao var19 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         NoteDebitEnteteAchatsDao var21 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         AvoirEnteteAchatsDao var23 = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         Date var24 = null;
         Date var25 = null;
         Date var26 = null;
         Date var27 = null;
         Date var28 = null;
         Date var29 = null;
         Date var30 = null;
         Date var31 = null;
         int var32 = 0;
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         var5 = "from Tiers where tietype=0";
         List var7 = this.tiersDao.listeTiers(var5, var2);
         if (var7.size() != 0) {
            for(int var33 = 0; var33 < var7.size(); ++var33) {
               Tiers var6 = (Tiers)var7.get(var33);
               ++var32;
               if (var33 != 0) {
                  double var34 = (double)((List)var10).size();
                  double var36 = var4.myRound(var34 / (double)var33, 4);
                  double var38 = var4.myRound(100.0D / var36, 2);
                  this.var_currentValue = (int)var38;
               }

               this.var_info = "Mise a jour de " + var6.getTieraisonsocialenom() + " Numero " + var33 + ", pour un total de " + var7.size() + " total ";
               var24 = null;
               var25 = null;
               var26 = null;
               var27 = null;
               var28 = null;
               var29 = null;
               var30 = null;
               var31 = null;
               var5 = "rglIdTiers=" + var6.getTieid() + " and rglCategorie=10 order by rglDateReg desc";
               List var8 = var9.rechercheReglementsRequete(var5, var2);
               if (var8.size() != 0) {
                  var24 = ((Reglements)var8.get(0)).getRglDateReg();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by cotDate desc";
               var10 = var11.rechercheCotationRequete(var5, var2);
               if (((List)var10).size() != 0) {
                  var25 = ((CotationEnteteAchats)((List)var10).get(0)).getCotDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by cmdDate desc";
               List var12 = var13.rechercheCommandeRequete(var5, var2);
               if (var12.size() != 0) {
                  var26 = ((CommandeEnteteAchats)var12.get(0)).getCmdDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by recDate desc";
               List var14 = var15.rechercheReceptionRequete(var5, var2);
               if (var14.size() != 0) {
                  var27 = ((ReceptionEnteteAchats)var14.get(0)).getRecDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by brfDate desc";
               List var16 = var17.rechercheRetourRequete(var5, var2);
               if (var16.size() != 0) {
                  var28 = ((RetourEnteteAchats)var16.get(0)).getBrfDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by fcfDate desc";
               List var18 = var19.rechercheFactureRequete(var5, var2);
               if (var18.size() != 0) {
                  var29 = ((FactureEnteteAchats)var18.get(0)).getFcfDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by ndfDate desc";
               List var20 = var21.rechercheNoteDebitRequete(var5, var2);
               if (var20.size() != 0) {
                  var30 = ((NoteDebitEnteteAchats)var20.get(0)).getNdfDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by avfDate desc";
               List var22 = var23.rechercheAvoirRequete(var5, var2);
               if (var22.size() != 0) {
                  var31 = ((AvoirEnteteAchats)var22.get(0)).getAvfDate();
               }

               var6.setTieDteRegement(var24);
               var6.setTieDteDocument1(var25);
               var6.setTieDteDocument2(var26);
               var6.setTieDteDocument3(var27);
               var6.setTieDteDocument4(var28);
               var6.setTieDteDocument5(var29);
               var6.setTieDteDocument6(var30);
               var6.setTieDteDocument7(var31);
               this.tiersDao.modif(var6, var2);
               if (var32 == 200) {
                  var2.flush();
                  var32 = 0;
               }
            }
         }

         var3.commit();
      } catch (HibernateException var43) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var43;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculLibellesFamilles() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des libelles des familles de produits");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         UtilNombre var4 = new UtilNombre();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         this.var_info = "Chargement des produits...";
         new Produits();
         ProduitsAchsDao var6 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         Object var8 = new ArrayList();
         FamillesProduitsAchatsDao var9 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
         Object var10 = new ArrayList();
         FamillesProduitsVentesDao var11 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
         new ExercicesAchats();
         this.exercicesAchatsDao = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
         ExercicesAchats var12 = this.exercicesAchatsDao.recupererLastExo(var2);
         new ExercicesVentes();
         this.exercicesVentesDao = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
         ExercicesVentes var13 = this.exercicesVentesDao.recupererLastExo(var2);
         if (var12 != null) {
            var8 = var9.selectAllFamillProd(var12.getExeachId(), var2);
         }

         if (var13 != null) {
            var10 = var11.selectAllFamillProd(var13.getExevteId(), var2);
         }

         List var7 = var6.selectAllProduitsAchVte(var2);
         if (var7.size() != 0) {
            for(int var14 = 0; var14 < var7.size(); ++var14) {
               Produits var5 = (Produits)var7.get(var14);
               if (var14 != 0) {
                  double var15 = (double)var7.size();
                  double var17 = var4.myRound(var15 / (double)var14, 4);
                  double var19 = var4.myRound(100.0D / var17, 2);
                  this.var_currentValue = (int)var19;
               }

               this.var_info = "Mise a jour de " + var5.getProCode() + " Numero " + var14 + ", pour un total de " + var7.size() + " total ";
               var5.setProAchLib((String)null);
               int var26;
               if (var5.getProAchCode() != null && !var5.getProAchCode().isEmpty()) {
                  for(var26 = 0; var26 < ((List)var8).size(); ++var26) {
                     if (((FamillesProduitsAchats)((List)var8).get(var26)).getFamachCode().equals(var5.getProAchCode())) {
                        var5.setProAchLib(((FamillesProduitsAchats)((List)var8).get(var26)).getFamachLibelleFr());
                        break;
                     }
                  }
               }

               var5.setProVteLib((String)null);
               if (var5.getProVteCode() != null && !var5.getProVteCode().isEmpty()) {
                  for(var26 = 0; var26 < ((List)var10).size(); ++var26) {
                     if (((FamillesProduitsVentes)((List)var10).get(var26)).getFamvteCode().equals(var5.getProVteCode())) {
                        var5.setProVteLib(((FamillesProduitsVentes)((List)var10).get(var26)).getFamvteLibelleFr());
                        break;
                     }
                  }
               }

               var6.modif(var5, var2);
            }
         }

         var3.commit();
      } catch (HibernateException var24) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var24;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void affectationServiceProduitAchs() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("affectation Service Produit Achs");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      Object var3 = new ArrayList();
      ProduitsAchsDao var4 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      ProduitsVtesDao var5 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      Object var6 = new ArrayList();
      ProduitsServicesDao var7 = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      if (this.listeService.size() != 0 && this.listeFamilleAchs.size() != 0) {
         Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         Transaction var9 = null;

         try {
            var9 = var8.beginTransaction();
            this.var_currentValue = 0;
            this.var_showBarProg = true;
            new Service();
            new FamillesProduitsAchats();
            new Produits();

            for(int var13 = 0; var13 < this.listeService.size(); ++var13) {
               Service var10 = (Service)this.listeService.get(var13);
               if (var10.isSelect()) {
                  for(int var14 = 0; var14 < this.listeFamilleAchs.size(); ++var14) {
                     FamillesProduitsAchats var11 = (FamillesProduitsAchats)this.listeFamilleAchs.get(var14);
                     this.var_info = "Service: " + var10.getSerCode() + "  Famille: " + var11.getFamachCode();
                     if (var14 != 0) {
                        double var15 = (double)this.listeFamilleAchs.size();
                        double var17 = var2.myRound(var15 / (double)var14, 4);
                        double var19 = var2.myRound(100.0D / var17, 2);
                        this.var_currentValue = (int)var19;
                     }

                     if (var11.isSelectFamille()) {
                        ((List)var3).clear();
                        List var26 = var4.chargerLesProduitsAchatsByFamille(var11.getFamachCode(), var8);
                        Produits var12;
                        int var16;
                        int var27;
                        ProduitsServices var28;
                        if (var26.size() != 0) {
                           for(var27 = 0; var27 < var26.size(); ++var27) {
                              var12 = (Produits)var26.get(var27);
                              ((List)var6).clear();
                              var6 = var7.selectProdServiceByservAchs(var10, var12.getProCode(), (String)null, var8);
                              if (((List)var6).size() != 0) {
                                 for(var16 = 0; var16 < ((List)var6).size(); ++var16) {
                                    var7.delete((ProduitsServices)((List)var6).get(var16), var8);
                                 }

                                 var8.flush();
                              }

                              var28 = new ProduitsServices();
                              var28.setProduits(var12);
                              var28.setProserCode(var10.getSerCode());
                              var28.setProserNomFr(var10.getSerNomFr());
                              var28.setProserQte(0.0F);
                              var28.setServices(var10);
                              var7.insert(var28, var8);
                              if (!var12.isProAvecService()) {
                                 var12.setProAvecService(true);
                                 var4.modif(var12, var8);
                              }
                           }
                        }

                        var26.clear();
                        var3 = var5.chargerLesProduitsVentesByFamille(var11.getFamachCode(), var8);
                        if (((List)var3).size() != 0) {
                           for(var27 = 0; var27 < ((List)var3).size(); ++var27) {
                              var12 = (Produits)((List)var3).get(var27);
                              ((List)var6).clear();
                              var6 = var7.selectProdServiceByservAchs(var10, var12.getProCode(), (String)null, var8);
                              if (((List)var6).size() != 0) {
                                 for(var16 = 0; var16 < ((List)var6).size(); ++var16) {
                                    var7.delete((ProduitsServices)((List)var6).get(var16), var8);
                                 }

                                 var8.flush();
                              }

                              var28 = new ProduitsServices();
                              var28.setProduits(var12);
                              var28.setProserCode(var10.getSerCode());
                              var28.setProserNomFr(var10.getSerNomFr());
                              var28.setProserQte(0.0F);
                              var28.setServices(var10);
                              var7.insert(var28, var8);
                              if (!var12.isProAvecService()) {
                                 var12.setProAvecService(true);
                                 var4.modif(var12, var8);
                              }
                           }
                        }
                     }
                  }
               }
            }

            var9.commit();
         } catch (HibernateException var24) {
            if (var9 != null) {
               var9.rollback();
            }

            throw var24;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void suppressionDocumentAchat() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("suppression des documents achats");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Suppression des documents d`achat.";
      Utilitaires_Achats var3 = new Utilitaires_Achats();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (this.sup_da) {
            ++this.var_currentValue;
            this.var_info = "Suppression des DA en cours....";
            var3.suppressionDa(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_cotation) {
            ++this.var_currentValue;
            this.var_info = "Suppression des COTATIONS en cours....";
            var3.suppressionCotations(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_cmd) {
            ++this.var_currentValue;
            this.var_info = "Suppression des COMMANDES en cours....";
            var3.suppressionCommandes(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_reception) {
            ++this.var_currentValue;
            this.var_info = "Suppression des RECEPTIONS en cours....";
            var3.suppressionReceptions(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_retour) {
            ++this.var_currentValue;
            this.var_info = "Suppression des RETOURS en cours....";
            var3.suppressionRetours(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_facture) {
            ++this.var_currentValue;
            this.var_info = "Suppression des FACTURES en cours....";
            var3.suppressionFactures(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_factureFrais) {
            this.var_currentValue = 7;
            this.var_info = "Suppression des FRAIS en cours....";
            var3.suppressionFrais(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_noteDebit) {
            ++this.var_currentValue;
            this.var_info = "Suppression des NOTES DE DEBIT en cours....";
            var3.suppressionNotesDebit(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_avoir) {
            ++this.var_currentValue;
            this.var_info = "Suppression des AVOIRS en cours....";
            var3.suppressionAvoirs(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_inventaire) {
            ++this.var_currentValue;
            this.var_info = "Suppression des INVENTAIRES en cours....";
            var3.suppressionInventaires(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bin) {
            ++this.var_currentValue;
            this.var_info = "Suppression des BONS ENTREE en cours....";
            var3.suppressionBonsEntree(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bout) {
            ++this.var_currentValue;
            this.var_info = "Suppression des BONS SORTIE en cours....";
            var3.suppressionBonsSortie(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_cession) {
            ++this.var_currentValue;
            this.var_info = "Suppression des CESSIONS en cours....";
            var3.suppressionCessions(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_production) {
            ++this.var_currentValue;
            this.var_info = "Suppression des PRODUCTIONS en cours....";
            var3.suppressionProductions(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculPUMPEntreeStk() throws HibernateException, HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul PUMP des entrées en stock");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.optionAchats = new OptionAchats();
      LireLesoptionsAchats var3 = new LireLesoptionsAchats();
      var3.setStrId(this.structureLog.getStrid());
      var3.lancer();
      this.optionAchats = var3.getOptionAchats();
      ArrayList var4 = new ArrayList();
      CalculStock var5 = new CalculStock();
      new ArrayList();
      ProduitsDepotDao var7 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      ProduitsAchsDao var8 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      List var6 = var8.selectAllProduitsStock((Session)null);
      new ProduitsDepot();
      if (var6.size() != 0) {
         Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         Transaction var11 = null;

         ProduitsDepot var9;
         Produits var12;
         int var13;
         double var14;
         double var16;
         double var18;
         try {
            var11 = var10.beginTransaction();
            new Produits();
            this.var_currentValue = 0;
            this.var_showBarProg = true;
            var13 = 0;

            while(true) {
               if (var13 >= var6.size()) {
                  var11.commit();
                  break;
               }

               new Produits();
               var12 = (Produits)var6.get(var13);
               this.var_info = "1/2 - calcul PUMP entree, produit : ";
               if (var13 != 0) {
                  var14 = (double)var6.size();
                  var16 = var2.myRound(var14 / (double)var13, 4);
                  var18 = var2.myRound(100.0D / var16, 2);
                  this.var_currentValue = (int)var18;
               }

               if (var12 != null && var12.getProStock() != 0) {
                  new ArrayList();
                  List var36 = var7.selectProdDepByprod(var12, var10);
                  if (var36.size() != 0) {
                     for(int var15 = 0; var15 < var36.size(); ++var15) {
                        new ProduitsDepot();
                        var9 = (ProduitsDepot)var36.get(var15);
                        String var37 = var9.getDepot().getDpoCode() + ":" + var9.getProduits().getProCode();
                        var9.setProdepCle(var37);
                        String var17 = var9.getProdepGroupe() + ":" + var9.getProduits().getProCode();
                        var9.setProdepCle2(var17);
                        if (var12.getProInactif() == 0) {
                           new InventaireLigne();
                           InventaireLigne var38 = var5.chercheDernierInventaire(var12.getProCode(), var9.getDepot().getDpoCode(), this.baseLog, var10);
                           if (var38 == null) {
                              new ReceptionLigneAchats();
                              ReceptionLigneAchats var19 = var5.chercheDernierReception(var12.getProCode(), var9.getDepot().getDpoCode(), this.baseLog, var10);
                              if (var19 != null) {
                                 InventaireEntete var20 = new InventaireEntete();
                                 var38 = new InventaireLigne();
                                 var20.setInvDate(var19.getReceptionEnteteAchats().getRecDate());
                                 var20.setInvEtat(var19.getReceptionEnteteAchats().getRecEtat());
                                 var20.setInvNum(var19.getReceptionEnteteAchats().getRecNum());
                                 var20.setInvActivite(var19.getReceptionEnteteAchats().getRecActivite());
                                 var38.setInventaireEntete(var20);
                                 var38.setInvligCode(var19.getRecligCode());
                                 var38.setInvligLibelle(var19.getRecligLibelle());
                                 var38.setInvligReference(var19.getRecligReference());
                                 var38.setInvligFamille(var19.getRecligFamille());
                                 var38.setInvligDepot(var19.getRecligDepot());
                                 var38.setInvligQte(var19.getRecligQte());
                                 var38.setInvligQteUtil(var19.getRecligQteUtil());
                                 var38.setInvligPump(var19.getRecligPrU());
                                 var38.setInvligPoidsBrut(var19.getRecligPoidsBrut());
                                 var38.setInvligPoidsNet(var19.getRecligPoidsNet());
                                 var38.setInvligUnite(var19.getRecligUnite());
                              }
                           }

                           String var39 = "";
                           if (var12.getProAchNat() == null || var12.getProAchNat().isEmpty() || !var12.getProAchNat().equals("1105") && !var12.getProAchNat().equals("0104") && !var12.getProAchNat().equals("0105") && !var12.getProAchNat().equals("1604") && !var12.getProAchNat().equals("1605")) {
                              if (var12.getProVteNat() != null && !var12.getProVteNat().isEmpty() && (var12.getProVteNat().equals("1105") || var12.getProVteNat().equals("0104") || var12.getProVteNat().equals("0105") || var12.getProVteNat().equals("1604") || var12.getProVteNat().equals("1605"))) {
                                 var39 = var12.getProVteNat();
                              } else if (var12.getProAchNat() != null && !var12.getProAchNat().isEmpty()) {
                                 var39 = var12.getProAchNat();
                              } else if (var12.getProVteNat() != null && !var12.getProVteNat().isEmpty()) {
                                 var39 = var12.getProVteNat();
                              }
                           } else {
                              var39 = var12.getProAchNat();
                           }

                           var9 = var5.recalculPump(this.optionAchats.getModCalcPump(), var39, var9, var38, var12.getProCode(), var12.getProLibTech(), var9.getDepot().getDpoCode(), 0L, this.optionVentes.getGestionStockBc(), this.baseLog, this.structureLog, var10);
                           if (var9 != null) {
                              var4.add(var9);
                           }
                        }
                     }
                  }
               }

               ++var13;
            }
         } catch (HibernateException var33) {
            if (var11 != null) {
               var11.rollback();
            }

            throw var33;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (var4.size() != 0) {
            var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
            var12 = null;

            try {
               Transaction var35 = var10.beginTransaction();

               for(var13 = 0; var13 < var4.size(); ++var13) {
                  var9 = (ProduitsDepot)var4.get(var13);
                  this.var_info = "2/2 - mise à jour PUMP entree, produit : " + var9.getProduits().getProCode() + " Depot : " + var9.getDepot().getDpoCode();
                  if (var13 != 0) {
                     var14 = (double)var4.size();
                     var16 = var2.myRound(var14 / (double)var13, 4);
                     var18 = var2.myRound(100.0D / var16, 2);
                     this.var_currentValue = (int)var18;
                  }

                  if (var9.getProduits().getProInactif() == 0) {
                     var7.modif(var9, var10);
                  }
               }

               var35.commit();
            } catch (HibernateException var31) {
               if (var12 != null) {
                  var12.rollback();
               }

               throw var31;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void desactiveroduitSansMouvement() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("desactivation Prod sans Mvts");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Utilitaires_Achats var2 = new Utilitaires_Achats();
      Utilitaires_Ventes var3 = new Utilitaires_Ventes();
      UtilNombre var4 = new UtilNombre();
      new ArrayList();
      new Produits();
      ProduitsAchsDao var7 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      List var5 = var7.selectAllProduits((Session)null);
      if (var5.size() != 0) {
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         Transaction var9 = null;

         try {
            var9 = var8.beginTransaction();

            for(int var10 = 0; var10 < var5.size(); ++var10) {
               Produits var6 = (Produits)var5.get(var10);
               this.var_info = "Produit: " + var6.getProCode() + " " + var6.getProLibClient();
               if (var10 != 0) {
                  double var11 = (double)var5.size();
                  double var13 = var4.myRound(var11 / (double)var10, 4);
                  double var15 = var4.myRound(100.0D / var13, 2);
                  this.var_currentValue = (int)var15;
               }

               String var22 = var6.getProCode();
               boolean var12 = var2.testAchatsVde(var22, this.baseLog, this.utilInitHibernate, var8);
               if (var12) {
                  var12 = var3.testVentesVde(var22, this.baseLog, this.utilInitHibernate, var8);
                  if (var12) {
                     var6 = var7.chargeProduit(var22, var8);
                     if (var6 != null) {
                        var6.setProInactif(1);
                        var7.modif(var6, var8);
                     }
                  }
               }
            }

            var9.commit();
         } catch (HibernateException var20) {
            if (var9 != null) {
               var9.rollback();
            }

            throw var20;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void desactiveroduitSansInventaire() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("desactivation Prod sans Inventaire");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Utilitaires_Achats var2 = new Utilitaires_Achats();
      UtilNombre var3 = new UtilNombre();
      new ArrayList();
      new Produits();
      ProduitsAchsDao var6 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      List var4 = var6.selectAllProduits((Session)null);
      if (var4.size() != 0) {
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();

            for(int var9 = 0; var9 < var4.size(); ++var9) {
               Produits var5 = (Produits)var4.get(var9);
               this.var_info = "Produit: " + var5.getProCode() + " " + var5.getProLibClient();
               if (var9 != 0) {
                  double var10 = (double)var4.size();
                  double var12 = var3.myRound(var10 / (double)var9, 4);
                  double var14 = var3.myRound(100.0D / var12, 2);
                  this.var_currentValue = (int)var14;
               }

               String var21 = var5.getProCode();
               boolean var11 = var2.testAchatsInv(var21, this.baseLog, this.utilInitHibernate, var7);
               if (var11) {
                  var5 = var6.chargeProduit(var21, var7);
                  if (var5 != null) {
                     var5.setProInactif(1);
                     var6.modif(var5, var7);
                  }
               }
            }

            var8.commit();
         } catch (HibernateException var19) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void regenerationProduitsFournisseurs() throws NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("regénération liaisons produits/fournisseurs avec les réceptions");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Utilitaires_Achats var2 = new Utilitaires_Achats();
      new ArrayList();
      ProduitsAchsDao var4 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      new Produits();
      ProduitsFournisseur var6 = new ProduitsFournisseur();
      ProduitsFournisseurDao var7 = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
      ReceptionLigneAchatsDao var8 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      ReceptionLigneAchats var9 = new ReceptionLigneAchats();
      UtilNombre var10 = new UtilNombre();
      LectureDevises var11 = new LectureDevises();
      List var3 = var4.selectAllProduits((Session)null);
      if (var3.size() != 0) {
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         Session var12 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsFournisseurs");
         Transaction var13 = null;

         try {
            var13 = var12.beginTransaction();

            for(int var14 = 0; var14 < var3.size(); ++var14) {
               new Produits();
               Produits var5 = (Produits)var3.get(var14);
               long var15 = var5.getProId();
               this.var_info = "Produit: " + var5.getProCode() + " " + var5.getProLibClient();
               if (var14 != 0) {
                  double var17 = (double)var3.size();
                  double var19 = var10.myRound(var17 / (double)var14, 4);
                  double var21 = var10.myRound(100.0D / var19, 2);
                  this.var_currentValue = (int)var21;
               }

               var2.regenerationProduitsFournisseurs(this.structureLog, var10, var11, var5, var4, var6, var7, var8, var9, var12);
            }

            var13.commit();
         } catch (HibernateException var26) {
            if (var13 != null) {
               var13.rollback();
            }

            throw var26;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void reconnexionFraisReception() throws NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("reconnexion des frais directs avec les recéptions");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Utilitaires_Achats var2 = new Utilitaires_Achats();
      new ArrayList();
      FraisEnteteAchatsDao var4 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      FraisLigneAchatsDao var5 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      new FraisLigneAchats();
      ReceptionEnteteAchatsDao var7 = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      ReceptionEnteteAchats var8 = new ReceptionEnteteAchats();
      UtilNombre var9 = new UtilNombre();
      String var10 = "fsflig_id <> 0";
      List var3 = var5.rechercheFraisRequete(var10, (Session)null);
      if (var3.size() != 0) {
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
         Transaction var12 = null;

         try {
            var12 = var11.beginTransaction();

            for(int var13 = 0; var13 < var3.size(); ++var13) {
               new FraisLigneAchats();
               FraisLigneAchats var6 = (FraisLigneAchats)var3.get(var13);
               this.var_info = "Frais: " + var6.getFsfligCode() + " " + var6.getFsfligLibelle();
               if (var13 != 0) {
                  double var14 = (double)var3.size();
                  double var16 = var9.myRound(var14 / (double)var13, 4);
                  double var18 = var9.myRound(100.0D / var16, 2);
                  this.var_currentValue = (int)var18;
               }

               var2.reconnexionFraisReception(this.structureLog, var9, var6, var5, var8, var7, var11);
            }

            var2.reconnexionFraisReceptionEntete(this.structureLog, var9, var3, var4, var8, var7, var11);
            var12.commit();
         } catch (HibernateException var23) {
            if (var12 != null) {
               var12.rollback();
            }

            throw var23;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculReference() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("Recalcul des références fournisseurs");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Recalcul des références fournisseurs";
      Utilitaires_Achats var3 = new Utilitaires_Achats();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         ++this.var_currentValue;
         this.var_info = "Recalcul références en cours....";
         var3.recalculReference(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void rechercherAnnulTrfVentes() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.lesDocumentsEntete.clear();
         Utilitaires_Ventes var1 = new Utilitaires_Ventes();
         this.lesDocumentsEntete = var1.rechercherAnnulTrfVentes(this.var_date_deb, this.var_date_fin, this.lesDocumentsEntete, this.baseLog, this.utilInitHibernate);
         this.dataModelDocumentEntete.setWrappedData(this.lesDocumentsEntete);
      }

   }

   public void toutSelectionAnnulTrfVentes() {
      if (this.lesDocumentsEntete.size() != 0) {
         new DocumentEntete();

         for(int var2 = 0; var2 < this.lesDocumentsEntete.size(); ++var2) {
            DocumentEntete var1 = (DocumentEntete)this.lesDocumentsEntete.get(var2);
            var1.setDocSelect(true);
         }
      }

   }

   public void rienSelectionAnnulTrfVentes() {
      if (this.lesDocumentsEntete.size() != 0) {
         new DocumentEntete();

         for(int var2 = 0; var2 < this.lesDocumentsEntete.size(); ++var2) {
            DocumentEntete var1 = (DocumentEntete)this.lesDocumentsEntete.get(var2);
            var1.setDocSelect(false);
         }
      }

   }

   public void annulTrfVentes() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("annule Trf Ventes du " + this.var_date_deb + " au " + this.var_date_fin);
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Utilitaires_Ventes var2 = new Utilitaires_Ventes();
         var2.annulTrfVentes(this.var_date_deb, this.var_date_fin, this.lesDocumentsEntete, this.baseLog, this.utilInitHibernate);
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void forceTrfVentes() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("force Trf Ventes du " + this.var_date_deb + " au " + this.var_date_fin);
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Utilitaires_Ventes var2 = new Utilitaires_Ventes();
         var2.forceTrfVentes(this.var_date_deb, this.var_date_fin, this.baseLog, this.utilInitHibernate);
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculDernierReglementFacture() throws HibernateException, NamingException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("recalcul Dernier Reglement facture");
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         UtilDate var2 = new UtilDate();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new ArrayList();
            FactureEnteteVentesDao var6 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            ReglementsDao var7 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
            String var8 = var2.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
            String var9 = var2.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
            List var5 = var6.rechercheDejaPayer(var8, var9, var3);
            if (var5.size() != 0) {
               for(int var10 = 0; var10 < var5.size(); ++var10) {
                  new FactureEnteteVentes();
                  FactureEnteteVentes var11 = (FactureEnteteVentes)var5.get(var10);
                  new ArrayList();
                  List var12 = var7.reglementDocument(var11.getFacId(), 25, var3);
                  if (var12.size() != 0) {
                     int var13 = var12.size() - 1;
                     var11.setFacDateLastReg(((Reglements)var12.get(var13)).getRglDateReg());
                  } else {
                     var11.setFacDateLastReg((Date)null);
                  }

                  var6.modif(var11, var3);
               }

               var4.commit();
            }
         } catch (HibernateException var17) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculTarif() throws NamingException, JDOMException, IOException, ParseException {
      new ArrayList();
      new ArrayList();
      LectureFamillesClients var3 = new LectureFamillesClients();
      var3.setStrId(this.structureLog.getStrid());
      var3.setStructureLog(this.structureLog);
      var3.chargerMesFamillesClientItems();
      List var2 = var3.getMesFamillesClients();
      if (var2.size() != 0) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var4 = new Espion();
         var4.setEspdtecreat(new Date());
         var4.setUsers(this.usersLog);
         var4.setEspaction("recalcul Tarif");
         var4.setEsptype(0);
         this.espionDao.mAJEspion(var4);
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         Transaction var6 = null;

         try {
            var6 = var5.beginTransaction();
            new ExercicesVentes();
            ExercicesVentes var7 = this.exercicesVentesDao.recupererLastExo(var5);
            if (var7 != null) {
               TaxesVentesDao var8 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
               FamillesProduitsVentesDao var9 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
               ProduitsTarifDao var10 = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
               List var1 = var10.selectAllProduitsTarif(var5);
               if (var1.size() != 0) {
                  for(int var11 = 0; var11 < var1.size(); ++var11) {
                     new ProduitsTarif();
                     ProduitsTarif var12 = (ProduitsTarif)var1.get(var11);
                     String var13 = var12.getProtarClient();
                     boolean var14 = false;
                     boolean var15 = false;

                     for(int var16 = 0; var16 < var2.size(); ++var16) {
                        if (((ObjetFamilleTiers)var2.get(var16)).getLibelle().equals(var13)) {
                           if (((ObjetFamilleTiers)var2.get(var16)).getExoTva().equalsIgnoreCase("true")) {
                              var14 = true;
                           } else {
                              var14 = false;
                           }

                           if (((ObjetFamilleTiers)var2.get(var16)).getExoDouane().equalsIgnoreCase("true")) {
                              var15 = true;
                           } else {
                              var15 = false;
                           }
                           break;
                        }
                     }

                     var12.setProtarExoTva(var14);
                     var12.setProtarExoDd(var15);
                     float var24 = 0.0F;
                     if (var12.getProduits().getProVteTva() != null && !var12.getProduits().getProVteTva().isEmpty()) {
                        new TaxesVentes();
                        TaxesVentes var25 = var8.selectTva(var7.getExevteId(), var12.getProduits().getProVteTva(), var5);
                        if (var25 != null) {
                           var24 = var25.getTaxvteTaux();
                        }
                     } else {
                        new FamillesProduitsVentes();
                        FamillesProduitsVentes var17 = var9.rechercheFamilleByProd(var7.getExevteId(), var12.getProduits(), var5);
                        if (var17 != null) {
                           new TaxesVentes();
                           TaxesVentes var18 = var8.selectTva(var7.getExevteId(), var17.getFamvteTaxe(), var5);
                           if (var18 != null) {
                              var24 = var18.getTaxvteTaux();
                           }
                        }
                     }

                     var12.setProtarTauxTva(var24);
                     var10.modif(var12, var5);
                  }
               }

               var6.commit();
            }
         } catch (HibernateException var22) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var22;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void produitSansTarif() throws NamingException, JDOMException, IOException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("produit Sans Tarif");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new ArrayList();
      new ArrayList();
      ProduitsVtesDao var4 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      ProduitsTarifDao var5 = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      Transaction var7 = null;

      try {
         var7 = var6.beginTransaction();
         List var2 = var4.selectAllProduits(var6);
         if (var2.size() != 0) {
            for(int var8 = 0; var8 < var2.size(); ++var8) {
               new Produits();
               Produits var9 = (Produits)var2.get(var8);
               if (var9.getProInactif() != 2) {
                  List var3 = var5.selectProdTarifByprod(var9, var6);
                  if (var3.size() != 0) {
                     var9.setProInactif(0);
                  } else {
                     var9.setProInactif(1);
                  }

                  var4.modifProduit(var9, var6);
               }
            }
         }

         var7.commit();
      } catch (HibernateException var13) {
         if (var7 != null) {
            var7.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void libelleDocProduitVtes() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("libelle Doc Produit Vtes");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new ArrayList();
      ProduitsVtesDao var3 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         List var2 = var3.selectAllProduits(var4);
         if (var2.size() != 0) {
            for(int var6 = 0; var6 < var2.size(); ++var6) {
               new Produits();
               Produits var7 = (Produits)var2.get(var6);
               String var8 = var7.getProCode();
               String var9 = var7.getProLibClient();
               new ArrayList();
               DevisLigneVentesDao var11 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
               String var12 = "dvsligCode = '" + var8 + "'";
               List var10 = var11.rechercheDevisRequete(var12, var4);
               if (var10.size() != 0) {
                  for(int var13 = 0; var13 < var10.size(); ++var13) {
                     new DevisLigneVentes();
                     DevisLigneVentes var14 = (DevisLigneVentes)var10.get(var13);
                     var14.setDvsligLibelle(var9);
                     var11.modifLigne(var14, var4);
                  }
               }

               new ArrayList();
               CommandeLigneVentesDao var33 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var12 = "bcmligCode = '" + var8 + "'";
               List var32 = var33.rechercheCommandeRequete(var12, var4);
               if (var32.size() != 0) {
                  for(int var15 = 0; var15 < var32.size(); ++var15) {
                     new CommandeLigneVentes();
                     CommandeLigneVentes var16 = (CommandeLigneVentes)var32.get(var15);
                     var16.setBcmligLibelle(var9);
                     var33.modifLigne(var16, var4);
                  }
               }

               new ArrayList();
               LivraisonLigneVentesDao var35 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var12 = "blvligCode = '" + var8 + "'";
               List var34 = var35.rechercheLivraisonRequete(var12, var4);
               if (var34.size() != 0) {
                  for(int var17 = 0; var17 < var34.size(); ++var17) {
                     new LivraisonLigneVentes();
                     LivraisonLigneVentes var18 = (LivraisonLigneVentes)var34.get(var17);
                     var18.setBlvligLibelle(var9);
                     var35.modif(var18, var4);
                  }
               }

               new ArrayList();
               RetourLigneVentesDao var37 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var12 = "brtligCode = '" + var8 + "'";
               List var36 = var37.rechercheRetourRequete(var12, var4);
               if (var36.size() != 0) {
                  for(int var19 = 0; var19 < var36.size(); ++var19) {
                     new RetourLigneVentes();
                     RetourLigneVentes var20 = (RetourLigneVentes)var36.get(var19);
                     var20.setBrtligLibelle(var9);
                     var37.modifLigne(var20, var4);
                  }
               }

               new ArrayList();
               FactureLigneVentesDao var39 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var12 = "facligCode = '" + var8 + "'";
               List var38 = var39.rechercheFactureRequete(var12, var4);
               if (var38.size() != 0) {
                  for(int var21 = 0; var21 < var38.size(); ++var21) {
                     new FactureLigneVentes();
                     FactureLigneVentes var22 = (FactureLigneVentes)var38.get(var21);
                     var22.setFacligLibelle(var9);
                     var39.modifLigne(var22, var4);
                  }
               }

               new ArrayList();
               AvoirLigneVentesDao var41 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var12 = "avrligCode = '" + var8 + "'";
               List var40 = var41.rechercheAvoirRequete(var12, var4);
               if (var40.size() != 0) {
                  for(int var23 = 0; var23 < var40.size(); ++var23) {
                     new AvoirLigneVentes();
                     AvoirLigneVentes var24 = (AvoirLigneVentes)var40.get(var23);
                     var24.setAvrligLibelle(var9);
                     var41.modifLigne(var24, var4);
                  }
               }

               new ArrayList();
               NoteDebitLigneVentesDao var43 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var12 = "ndbligCode = '" + var8 + "'";
               List var42 = var43.rechercheNoteDebitRequete(var12, var4);
               if (var42.size() != 0) {
                  for(int var25 = 0; var25 < var42.size(); ++var25) {
                     new NoteDebitLigneVentes();
                     NoteDebitLigneVentes var26 = (NoteDebitLigneVentes)var42.get(var25);
                     var26.setNdbligLibelle(var9);
                     var43.modifLigne(var26, var4);
                  }
               }
            }
         }

         var5.commit();
      } catch (HibernateException var30) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var30;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void affectationTarifProduitVtes() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("affectation Tarif Produit Vtes");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      Object var3 = new ArrayList();
      new ProduitsTarif();
      ProduitsVtesDao var5 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      Object var6 = new ArrayList();
      ProduitsTarifDao var7 = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      if (this.listeTarif.size() != 0 && this.listeFamilleVtes.size() != 0) {
         Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         Transaction var9 = null;

         try {
            var9 = var8.beginTransaction();
            this.var_currentValue = 0;
            this.var_showBarProg = true;

            for(int var10 = 0; var10 < this.listeTarif.size(); ++var10) {
               new ObjetFamilleTiers();
               ObjetFamilleTiers var11 = (ObjetFamilleTiers)this.listeTarif.get(var10);
               if (var11.isSelectFamille()) {
                  int var12 = var11.getIndice();
                  String var13 = var11.getLibelle();

                  for(int var14 = 0; var14 < this.listeFamilleVtes.size(); ++var14) {
                     new FamillesProduitsVentes();
                     FamillesProduitsVentes var15 = (FamillesProduitsVentes)this.listeFamilleVtes.get(var14);
                     this.var_info = "Tarif: " + var11.getLibelle() + "  Famille: " + var15.getFamvteCode();
                     if (var14 != 0) {
                        double var16 = (double)this.listeFamilleVtes.size();
                        double var18 = var2.myRound(var16 / (double)var14, 4);
                        double var20 = var2.myRound(100.0D / var18, 2);
                        this.var_currentValue = (int)var20;
                     }

                     if (var15.isSelectFamille()) {
                        ((List)var3).clear();
                        var3 = var5.chargerLesProduitsVentesByFamille(var15.getFamvteCode(), var8);
                        if (((List)var3).size() != 0) {
                           for(int var27 = 0; var27 < ((List)var3).size(); ++var27) {
                              new Produits();
                              Produits var17 = (Produits)((List)var3).get(var27);
                              ((List)var6).clear();
                              var6 = var7.selectProdTarifByprod(var17, var8);
                              boolean var28 = false;
                              if (((List)var6).size() != 0) {
                                 for(int var19 = 0; var19 < ((List)var6).size(); ++var19) {
                                    if (((ProduitsTarif)((List)var6).get(var19)).getProtarClient().equals(var13)) {
                                       var28 = true;
                                    }
                                 }
                              }

                              if (!var28) {
                                 ProduitsTarif var4 = new ProduitsTarif();
                                 var4.setProduits(var17);
                                 var4.setProtarClient(var13);
                                 var4.setProtarOrdre(var12);
                                 var7.insert(var4, var8);
                              }
                           }
                        }
                     }
                  }
               }
            }

            var9.commit();
         } catch (HibernateException var25) {
            if (var9 != null) {
               var9.rollback();
            }

            throw var25;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void geneBlsurFactureDirecte() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("gene Bl sur Facture Directe");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      ArrayList var3 = new ArrayList();
      FactureEnteteVentesDao var4 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      FactureLigneVentesDao var5 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      new DocumentTraceVentes();
      DocumentTraceVentesDao var7 = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
      new ExercicesVentes();
      ExercicesVentes var8 = this.exercicesVentesDao.recupererLastExo(var2);
      if (var8 != null) {
         String var9 = "exerciceventes.exevteId=" + var8.getExevteId();
         new ArrayList();
         List var10 = var4.rechercheFactureRequete(var9, var2);
         int var11;
         FactureEnteteVentes var12;
         if (var10.size() != 0) {
            for(var11 = 0; var11 < var10.size(); ++var11) {
               new FactureEnteteVentes();
               var12 = (FactureEnteteVentes)var10.get(var11);
               DocumentTraceVentes var6 = var7.chercherDestinationTrace(var12.getFacId(), 25, var2);
               if (var6 == null) {
                  var3.add(var12);
               }
            }
         }

         if (var3.size() != 0) {
            for(var11 = 0; var11 < var3.size(); ++var11) {
               new FactureEnteteVentes();
               var12 = (FactureEnteteVentes)var3.get(var11);
               var12.setFacStock(1);
               var12 = var4.modif(var12, var2);
               new ArrayList();
               List var13 = var5.chargerLesLignes(var12, var2);
               if (var13.size() != 0) {
                  for(int var14 = 0; var14 < var13.size(); ++var14) {
                     new FactureLigneVentes();
                     FactureLigneVentes var15 = (FactureLigneVentes)var13.get(var14);
                     var15.setFacligEntStock(1);
                     var5.modifLigne(var15, var2);
                  }
               }
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void geneSoldeFactureVentes() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("gene Solde BC, BL, Facture et Ndb Ventes");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_showBarProg = true;
      this.var_currentValue = 0;
      this.var_info = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Object var3 = new ArrayList();
      ReglementsDao var4 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      new ExercicesVentes();
      new ArrayList();
      List var6 = this.exercicesVentesDao.selectExercicesVentes(var2);

      for(int var7 = 0; var7 < var6.size(); ++var7) {
         ExercicesVentes var5 = (ExercicesVentes)var6.get(var7);
         this.utilInitHibernate.closeSession();
         double var8 = 0.0D;
         int var10 = 0;
         if (var5 != null) {
            String var11 = "exerciceventes.exevteId=" + var5.getExevteId();
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
            Transaction var12 = null;

            List var13;
            CommandeEnteteVentesDao var14;
            CommandeEnteteVentes var15;
            int var17;
            try {
               var12 = var2.beginTransaction();
               this.var_currentValue = 1;
               this.var_info = "Traitement des BC " + var5.getExevteId();
               new ArrayList();
               var14 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               var13 = var14.rechercheCommandeRequete(var11, var2);
               if (var13.size() != 0) {
                  new CommandeEnteteVentes();

                  for(int var16 = 0; var16 < var13.size(); ++var16) {
                     ++var10;
                     var15 = (CommandeEnteteVentes)var13.get(var16);
                     var8 = 0.0D;
                     ((List)var3).clear();
                     var3 = var4.reglementDocument(var15.getBcmId(), 22, var2);
                     if (((List)var3).size() != 0) {
                        for(var17 = 0; var17 < ((List)var3).size(); ++var17) {
                           var8 += ((Reglements)((List)var3).get(var17)).getRglRecette();
                        }
                     }

                     var15.setBcmTotReglement(var8);
                     if (var15.getBcmTotReglement() >= var15.getBcmTotTtc()) {
                        var15.setBcmSolde(1);
                     } else {
                        var15.setBcmSolde(0);
                     }

                     var14.modif(var15, var2);
                     if (var10 >= 100) {
                        var2.flush();
                        var10 = 0;
                     }
                  }
               }

               var12.commit();
            } catch (HibernateException var60) {
               if (var12 != null) {
                  var12.rollback();
               }

               throw var60;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            var10 = 0;
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
            var13 = null;

            int var18;
            try {
               Transaction var62 = var2.beginTransaction();
               this.var_currentValue = 2;
               this.var_info = "Traitement des BL " + var5.getExevteId();
               new ArrayList();
               LivraisonEnteteVentesDao var65 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               List var63 = var65.rechercheLivraisonRequete(var11, var2);
               if (var63.size() != 0) {
                  new LivraisonEnteteVentes();

                  for(var17 = 0; var17 < var63.size(); ++var17) {
                     LivraisonEnteteVentes var68 = (LivraisonEnteteVentes)var63.get(var17);
                     ++var10;
                     var8 = 0.0D;
                     ((List)var3).clear();
                     var3 = var4.reglementDocument(var68.getBlvId(), 23, var2);
                     if (((List)var3).size() != 0) {
                        for(var18 = 0; var18 < ((List)var3).size(); ++var18) {
                           var8 += ((Reglements)((List)var3).get(var18)).getRglRecette();
                        }
                     }

                     var68.setBlvTotReglement(var8);
                     if (var68.getBlvTotReglement() >= var68.getBlvTotTtc()) {
                        var68.setBlvSolde(1);
                     } else {
                        var68.setBlvSolde(0);
                     }

                     var65.modif(var68, var2);
                     if (var10 >= 100) {
                        var2.flush();
                        var10 = 0;
                     }
                  }
               }

               var62.commit();
            } catch (HibernateException var58) {
               if (var13 != null) {
                  var13.rollback();
               }

               throw var58;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            var10 = 0;
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
            var14 = null;

            try {
               Transaction var64 = var2.beginTransaction();
               this.var_currentValue = 3;
               this.var_info = "Traitement des Factures " + var5.getExevteId();
               new ArrayList();
               FactureEnteteVentesDao var69 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               List var66 = var69.rechercheFactureRequete(var11, var2);
               if (var66.size() != 0) {
                  new FactureEnteteVentes();

                  for(var18 = 0; var18 < var66.size(); ++var18) {
                     FactureEnteteVentes var71 = (FactureEnteteVentes)var66.get(var18);
                     ++var10;
                     var8 = 0.0D;
                     ((List)var3).clear();
                     var3 = var4.reglementDocument(var71.getFacId(), 25, var2);
                     if (((List)var3).size() != 0) {
                        for(int var19 = 0; var19 < ((List)var3).size(); ++var19) {
                           var8 += ((Reglements)((List)var3).get(var19)).getRglRecette();
                        }
                     }

                     var71.setFacTotReglement(var8);
                     if (var71.getFacTotReglement() >= var71.getFacTotTtc()) {
                        var71.setFacSolde(1);
                     } else {
                        var71.setFacSolde(0);
                     }

                     var69.modif(var71, var2);
                     if (var10 >= 100) {
                        var2.flush();
                        var10 = 0;
                     }
                  }
               }

               var64.commit();
            } catch (HibernateException var56) {
               if (var14 != null) {
                  var14.rollback();
               }

               throw var56;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            var10 = 0;
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
            var15 = null;

            try {
               Transaction var67 = var2.beginTransaction();
               this.var_currentValue = 4;
               this.var_info = "Traitement des Notes de debit " + var5.getExevteId();
               new ArrayList();
               NoteDebitEnteteVentesDao var72 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               List var70 = var72.rechercheNoteDebitRequete(var11, var2);
               if (var70.size() != 0) {
                  for(var18 = 0; var18 < var70.size(); ++var18) {
                     new NoteDebitEnteteVentes();
                     NoteDebitEnteteVentes var73 = (NoteDebitEnteteVentes)var70.get(var18);
                     ++var10;
                     var8 = 0.0D;
                     ((List)var3).clear();
                     var3 = var4.reglementDocument(var73.getNdbId(), 27, var2);
                     if (((List)var3).size() != 0) {
                        for(int var20 = 0; var20 < ((List)var3).size(); ++var20) {
                           var8 += ((Reglements)((List)var3).get(var20)).getRglRecette();
                        }
                     }

                     var73.setNdbTotReglement(var8);
                     if (var73.getNdbTotReglement() >= var73.getNdbTotTtc()) {
                        var73.setNdbSolde(1);
                     } else {
                        var73.setNdbSolde(0);
                     }

                     var72.modif(var73, var2);
                     if (var10 >= 100) {
                        var2.flush();
                        var10 = 0;
                     }
                  }
               }

               var67.commit();
            } catch (HibernateException var54) {
               if (var15 != null) {
                  var15.rollback();
               }

               throw var54;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void geneEcheanceFactureVentes() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("gene Echeance Facture Ventes");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      ObjetReglement var2 = new ObjetReglement();
      new ArrayList();
      LectureReglementClient var4 = new LectureReglementClient();
      var4.setStrId(this.structureLog.getStrid());
      var4.setStructureLog(this.structureLog);
      var4.recupereReglementClient();
      List var3 = var4.getMesReglementClient();
      if (var3.size() != 0) {
         for(int var5 = 0; var5 < var3.size(); ++var5) {
            if (((ObjetReglement)var3.get(var5)).getDefaut().equals("true")) {
               var2 = (ObjetReglement)var3.get(var5);
            }
         }
      }

      if (var2 != null) {
         UtilDate var18 = new UtilDate();
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         new ExercicesVentes();
         ExercicesVentes var7 = this.exercicesVentesDao.recupererLastExo(var6);
         if (var7 != null) {
            String var8 = "exerciceventes.exevteId=" + var7.getExevteId();
            new ArrayList();
            FactureEnteteVentesDao var10 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            List var9 = var10.rechercheFactureRequete(var8, var6);
            int var13;
            if (var9.size() != 0) {
               for(int var11 = 0; var11 < var9.size(); ++var11) {
                  new FactureEnteteVentes();
                  FactureEnteteVentes var12 = (FactureEnteteVentes)var9.get(var11);
                  if (var2.getEcheances() == null || var2.getEcheances().isEmpty()) {
                     var2.setEcheances("0");
                  }

                  var12.setFacTypeReg(Integer.parseInt(var2.getEcheances()));
                  var12.setFacModeReg(var2.getCategories() + ":" + var2.getLibelles());
                  var13 = 0;
                  if (var2.getNbjours() != null && !var2.getNbjours().isEmpty()) {
                     var13 = Integer.parseInt(var2.getNbjours());
                  }

                  var12.setFacNbJourReg(var13);
                  int var14 = 0;
                  if (var2.getArrondis() != null && !var2.getArrondis().isEmpty()) {
                     var14 = Integer.parseInt(var2.getArrondis());
                  }

                  var12.setFacArrondiReg(var14);
                  Date var15 = var18.CalculDateEcheance(var12.getFacDate(), var12.getFacTypeReg(), var12.getFacNbJourReg(), var12.getFacArrondiReg());
                  var12.setFacDateEcheReg(var15);
                  var10.modif(var12, var6);
               }
            }

            new ArrayList();
            NoteDebitEnteteVentesDao var20 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            List var19 = var20.rechercheNoteDebitRequete(var8, var6);
            if (var19.size() != 0) {
               for(var13 = 0; var13 < var19.size(); ++var13) {
                  new NoteDebitEnteteVentes();
                  NoteDebitEnteteVentes var21 = (NoteDebitEnteteVentes)var19.get(var13);
                  if (var2.getEcheances() == null || var2.getEcheances().isEmpty()) {
                     var2.setEcheances("0");
                  }

                  var21.setNdbTypeReg(Integer.parseInt(var2.getEcheances()));
                  var21.setNdbModeReg(var2.getCategories() + ":" + var2.getLibelles());
                  int var22 = 0;
                  if (var2.getNbjours() != null && !var2.getNbjours().isEmpty()) {
                     var22 = Integer.parseInt(var2.getNbjours());
                  }

                  var21.setNdbNbJourReg(var22);
                  int var16 = 0;
                  if (var2.getArrondis() != null && !var2.getArrondis().isEmpty()) {
                     var16 = Integer.parseInt(var2.getArrondis());
                  }

                  var21.setNdbArrondiReg(var16);
                  Date var17 = var18.CalculDateEcheance(var21.getNdbDate(), var21.getNdbTypeReg(), var21.getNdbNbJourReg(), var21.getNdbArrondiReg());
                  var21.setNdbDateEcheReg(var17);
                  var20.modif(var21, var6);
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculNumMemoBlFactureAvoir() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul NumMemo Bl Facture Avoir");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "";
      int var2 = 0;
      UtilNombre var3 = new UtilNombre();
      UtilDate var4 = new UtilDate();
      Object var5 = new ArrayList();
      new LivraisonEnteteVentes();
      LivraisonEnteteVentesDao var7 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new FactureEnteteVentes();
      FactureEnteteVentesDao var9 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new AvoirEnteteVentes();
      AvoirEnteteVentesDao var11 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new RetourEnteteVentes();
      RetourEnteteVentesDao var13 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new DocumentTraceVentes();
      DocumentTraceVentesDao var15 = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
      String var16 = var4.dateToStringSQLLight(this.var_date_deb);
      String var17 = var4.dateToStringSQLLight(this.var_date_fin);
      Date var18 = var4.stringToDateSQL(var16 + " 00:00:00");
      Date var19 = var4.stringToDateSQL(var17 + " 23:59:59");
      Session var20 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      new ExercicesVentes();
      ExercicesVentes var21 = this.exercicesVentesDao.recupererLastExo(var20);
      FactureEnteteVentes var8;
      DocumentTraceVentes var14;
      Transaction var22;
      int var23;
      double var24;
      double var26;
      double var28;
      if (var21 != null) {
         var22 = null;

         try {
            var22 = var20.beginTransaction();
            ((List)var5).clear();
            this.var_info = "Chargement des factures/bl";
            var5 = var15.listeDestinationTrace(25, var20);
            if (((List)var5).size() != 0) {
               for(var23 = 0; var23 < ((List)var5).size(); ++var23) {
                  var14 = (DocumentTraceVentes)((List)var5).get(var23);
                  if (var14.getDoctraOrgType() == 23 && var14.getDoctraOrgId() != 0L && var14.getDoctraDstId() != 0L && var14.getDoctraDstDate().after(var18) && var14.getDoctraDstDate().before(var19)) {
                     this.var_info = "factures/bl: " + var14.getDoctraDstNum();
                     this.var_currentValue = 0;
                     if (var23 != 0) {
                        var24 = (double)((List)var5).size();
                        var26 = var3.myRound(var24 / (double)var23, 4);
                        var28 = var3.myRound(100.0D / var26, 2);
                        this.var_currentValue = (int)var28;
                     }

                     new LivraisonEnteteVentes();
                     LivraisonEnteteVentes var6 = var7.pourParapheur(var14.getDoctraOrgId(), var20);
                     if (var6 != null) {
                        var6.setBlvNumFacture(var14.getDoctraDstNum());
                        var7.modif(var6, var20);
                        new FactureEnteteVentes();
                        var8 = var9.pourParapheur(var14.getDoctraDstId(), var20);
                        if (var8 != null) {
                           var8.setFacNumBl(var14.getDoctraOrgNum());
                           var9.modif(var8, var20);
                        }

                        ++var2;
                        if (var2 == 50) {
                           var20.flush();
                           var2 = 0;
                        }
                     }
                  }
               }
            }

            var22.commit();
         } catch (HibernateException var55) {
            if (var22 != null) {
               var22.rollback();
            }

            throw var55;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      var20 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      AvoirEnteteVentes var10;
      if (var21 != null) {
         var22 = null;

         try {
            var22 = var20.beginTransaction();
            var2 = 0;
            ((List)var5).clear();
            this.var_info = "Chargement des avoirs/retours";
            var5 = var15.listeDestinationTrace(26, var20);
            if (((List)var5).size() != 0) {
               for(var23 = 0; var23 < ((List)var5).size(); ++var23) {
                  var14 = (DocumentTraceVentes)((List)var5).get(var23);
                  if (var14.getDoctraOrgType() == 24 && var14.getDoctraOrgId() != 0L && var14.getDoctraDstId() != 0L && var14.getDoctraDstDate().after(var18) && var14.getDoctraDstDate().before(var19)) {
                     this.var_info = "avoirs/retours: " + var14.getDoctraDstNum();
                     this.var_currentValue = 0;
                     if (var23 != 0) {
                        var24 = (double)((List)var5).size();
                        var26 = var3.myRound(var24 / (double)var23, 4);
                        var28 = var3.myRound(100.0D / var26, 2);
                        this.var_currentValue = (int)var28;
                     }

                     new RetourEnteteVentes();
                     RetourEnteteVentes var12 = var13.pourParapheur(var14.getDoctraOrgId(), var20);
                     if (var12 != null) {
                        var12.setBrtNumAvoir(var14.getDoctraDstNum());
                        var13.modif(var12, var20);
                        new AvoirEnteteVentes();
                        var10 = var11.pourParapheur(var14.getDoctraDstId(), var20);
                        if (var10 != null) {
                           var10.setAvrNumRetour(var14.getDoctraOrgNum());
                           var11.modif(var10, var20);
                        }

                        ++var2;
                        if (var2 == 50) {
                           var20.flush();
                           var2 = 0;
                        }
                     }
                  }
               }
            }

            var22.commit();
         } catch (HibernateException var53) {
            if (var22 != null) {
               var22.rollback();
            }

            throw var53;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      var20 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      if (var21 != null) {
         var22 = null;

         try {
            var22 = var20.beginTransaction();
            var2 = 0;
            ((List)var5).clear();
            this.var_info = "Chargement des avoirs/factures";
            List var57 = var15.listeDestinationTrace(27, var20);
            if (var57.size() != 0) {
               for(var23 = 0; var23 < var57.size(); ++var23) {
                  var14 = (DocumentTraceVentes)var57.get(var23);
                  if (var14.getDoctraOrgType() == 25 && var14.getDoctraOrgId() != 0L && var14.getDoctraDstId() != 0L && var14.getDoctraDstDate().after(var18) && var14.getDoctraDstDate().before(var19)) {
                     this.var_info = "avoirs/factures: " + var14.getDoctraDstNum();
                     this.var_currentValue = 0;
                     if (var23 != 0) {
                        var24 = (double)var57.size();
                        var26 = var3.myRound(var24 / (double)var23, 4);
                        var28 = var3.myRound(100.0D / var26, 2);
                        this.var_currentValue = (int)var28;
                     }

                     new FactureEnteteVentes();
                     var8 = var9.pourParapheur(var14.getDoctraOrgId(), var20);
                     if (var8 != null) {
                        var8.setFacNumAvoir(var14.getDoctraDstNum());
                        var9.modif(var8, var20);
                        new AvoirEnteteVentes();
                        var10 = var11.pourParapheur(var14.getDoctraDstId(), var20);
                        if (var10 != null) {
                           var10.setAvrNumFacture(var14.getDoctraOrgNum());
                           var11.modif(var10, var20);
                        }

                        ++var2;
                        if (var2 == 50) {
                           var20.flush();
                           var2 = 0;
                        }
                     }
                  }
               }
            }

            var22.commit();
         } catch (HibernateException var51) {
            if (var22 != null) {
               var22.rollback();
            }

            throw var51;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculPuTTC() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul P.U en TTC");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         new ArrayList();
         FactureLigneVentesDao var6 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
         String var7 = "faclig_id >= 0";
         List var5 = var6.rechercheFactureRequete(var7, var3);
         if (var5.size() != 0) {
            int var8 = 0;
            new FactureLigneVentes();

            for(int var10 = 0; var10 < var5.size(); ++var10) {
               FactureLigneVentes var9 = (FactureLigneVentes)var5.get(var10);
               if (var9.getFacligTauxTaxe() == 0.0F) {
                  var9.setFacligPuTtc(var9.getFacligPu());
                  var9.setFacligPuRemTtc(var9.getFacligPuRem());
               } else {
                  double var11 = var2.myRoundDevise(var9.getFacligPu() * (double)(1.0F + var9.getFacligTauxTaxe() / 100.0F), var9.getFactureEnteteVentes().getFacDevise());
                  var9.setFacligPuTtc(var11);
                  double var13 = var2.myRoundDevise(var9.getFacligPuRem() * (double)(1.0F + var9.getFacligTauxTaxe() / 100.0F), var9.getFactureEnteteVentes().getFacDevise());
                  var9.setFacligPuRemTtc(var13);
               }

               var6.modifLigne(var9, var3);
               ++var8;
               if (var8 == 100) {
                  var3.flush();
                  var8 = 0;
               }
            }
         }

         var4.commit();
      } catch (HibernateException var18) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var18;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculBcBl() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul liaisons BC => BL");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         UtilNombre var4 = new UtilNombre();
         UtilDate var5 = new UtilDate();
         new LivraisonEnteteVentes();
         new LivraisonLigneVentes();
         LivraisonEnteteVentesDao var8 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         LivraisonLigneVentesDao var9 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         ArrayList var10 = new ArrayList();
         Object var11 = new ArrayList();
         Object var12 = new ArrayList();
         ArrayList var13 = new ArrayList();
         DocumentTraceVentesDao var14 = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
         new CommandeLigneVentes();
         Object var16 = new ArrayList();
         CommandeLigneVentesDao var17 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         CommandeEnteteVentesDao var19 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         String var20 = var5.dateToStringSQLLight(this.var_date_deb);
         String var21 = var5.dateToStringSQLLight(this.var_date_fin);
         Date var22 = var5.stringToDateSQL(var20 + " 00:00:00");
         Date var23 = var5.stringToDateSQL(var21 + " 23:59:59");
         int var24 = 0;
         List var18 = var19.rechercheCommandeByDate(var22, var23, var2);
         if (var18.size() != 0) {
            new CommandeEnteteVentes();
            new DocumentTraceVentes();

            for(int var27 = 0; var27 < var18.size(); ++var27) {
               CommandeEnteteVentes var25 = (CommandeEnteteVentes)var18.get(var27);
               ((List)var16).clear();
               var13.clear();
               ((List)var12).clear();
               var10.clear();
               ((List)var11).clear();
               this.var_info = "Commande: " + var25.getBcmNum();
               double var28;
               double var30;
               if (var27 != 0) {
                  var28 = (double)var18.size();
                  var30 = var4.myRound(var28 / (double)var27, 4);
                  double var32 = var4.myRound(100.0D / var30, 2);
                  this.var_currentValue = (int)var32;
               }

               var16 = var17.chargerLesLignes(var25, var2);
               if (((List)var16).size() != 0) {
                  var12 = var14.chargerLesDocumentsTrace(var25.getBcmId(), 22, var2);
                  if (((List)var12).size() != 0) {
                     DocumentTraceVentes var26;
                     int var39;
                     for(var39 = 0; var39 < ((List)var12).size(); ++var39) {
                        var26 = (DocumentTraceVentes)((List)var12).get(var39);
                        if (var26.getDoctraDstType() == 23) {
                           var13.add(var26);
                        }
                     }

                     if (var13.size() != 0) {
                        LivraisonLigneVentes var7;
                        for(var39 = 0; var39 < var13.size(); ++var39) {
                           var26 = (DocumentTraceVentes)var13.get(var39);
                           var10.clear();
                           ((List)var11).clear();
                           LivraisonEnteteVentes var6 = var8.pourParapheur(var26.getDoctraDstId(), var2);
                           if (var6 != null) {
                              var11 = var9.chargerLesLignes(var6, var2);
                              if (((List)var11).size() != 0) {
                                 for(int var29 = 0; var29 < ((List)var11).size(); ++var29) {
                                    var7 = (LivraisonLigneVentes)((List)var11).get(var29);
                                    if (var7.getBlvligCode() != null && !var7.getBlvligCode().isEmpty()) {
                                       var10.add(var7);
                                    } else if (var7.getBlvligIdBcm() != 0L) {
                                       var10.add(var7);
                                    }
                                 }
                              }
                           }
                        }

                        if (var10.size() != 0) {
                           ++var24;

                           for(var39 = 0; var39 < ((List)var16).size(); ++var39) {
                              CommandeLigneVentes var15 = (CommandeLigneVentes)((List)var16).get(var39);
                              float var40 = 0.0F;

                              for(int var41 = 0; var41 < var10.size(); ++var41) {
                                 var7 = (LivraisonLigneVentes)var10.get(var41);
                                 if (var7.getBlvligIdBcm() != 0L && var7.getBlvligIdBcm() == var15.getBcmligId()) {
                                    var40 += var7.getBlvligQteUtil();
                                    var15.setBcmligDepot(var7.getBlvligDepot());
                                    var9.modif(var7, var2);
                                 } else if ((this.structureLog.getStrid() >= 42L && this.structureLog.getStrid() <= 45L || this.structureLog.getStrid() == 53L) && var7.getBlvligCode() != null && !var7.getBlvligCode().isEmpty() && var15.getBcmligCode() != null && !var15.getBcmligCode().isEmpty() && var7.getBlvligCode().equals(var15.getBcmligCode())) {
                                    var40 += var7.getBlvligQteUtil();
                                    var15.setBcmligDepot(var7.getBlvligDepot());
                                    var7.setBlvligIdBcm(var15.getBcmligId());
                                    var9.modif(var7, var2);
                                 }
                              }

                              var15.setBcmligQteLivree(var40);
                              var17.modifLigne(var15, var2);
                           }

                           if (((List)var16).size() != 0) {
                              var28 = 0.0D;
                              var30 = 0.0D;
                              new CommandeLigneVentes();

                              for(int var33 = 0; var33 < ((List)var16).size(); ++var33) {
                                 CommandeLigneVentes var42 = (CommandeLigneVentes)((List)var16).get(var33);
                                 var28 += (double)var42.getBcmligQteUtil();
                                 var30 += (double)var42.getBcmligQteLivree();
                              }

                              if (var30 != 0.0D) {
                                 if (var30 >= var28) {
                                    var25.setBcmEtat(5);
                                    var19.modif(var25, var2);
                                 } else {
                                    var25.setBcmEtat(4);
                                    var19.modif(var25, var2);
                                 }
                              } else {
                                 var25.setBcmEtat(1);
                                 var19.modif(var25, var2);
                              }
                           }

                           if (var24 == 100) {
                              var2.flush();
                              var24 = 0;
                           }
                        }
                     }
                  }
               }
            }
         }

         var3.commit();
      } catch (HibernateException var37) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var37;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculQteLivree() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul qte livrée des BL");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         this.var_info = "Chargement des lignes de BL...";
         LireLesoptionsVentes var6 = new LireLesoptionsVentes();
         var6.setStrId(this.structureLog.getStrid());
         this.optionVentes = new OptionVentes();
         var6.lancer();
         this.optionVentes = var6.getOptionsVentes();
         new LivraisonEnteteVentes();
         LivraisonEnteteVentesDao var8 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         LivraisonLivreeVentesDao var10 = new LivraisonLivreeVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         LivraisonLigneVentesDao var12 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         String var13 = var3.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         String var14 = var3.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         String var15 = "livraisonEnteteVentes.blvDate>='" + var13 + "' and livraisonEnteteVentes.blvDate<='" + var14 + "'";
         List var11 = var12.rechercheLivraisonRequete(var15, var4);
         if (var11.size() != 0) {
            int var16 = 0;
            float var17 = 0.0F;
            float var18 = 0.0F;
            new LivraisonLigneVentes();

            for(int var20 = 0; var20 < var11.size(); ++var20) {
               LivraisonLigneVentes var19 = (LivraisonLigneVentes)var11.get(var20);
               this.var_info = "Livraison: " + var19.getLivraisonEnteteVentes().getBlvNum();
               if (var20 != 0) {
                  double var21 = (double)var11.size();
                  double var23 = var2.myRound(var21 / (double)var20, 4);
                  double var25 = var2.myRound(100.0D / var23, 2);
                  this.var_currentValue = (int)var25;
               }

               LivraisonEnteteVentes var7;
               if (!this.optionVentes.getGestionLivreur().equals("1")) {
                  var19.setBlvligQteStock(var19.getBlvligQte());
                  var19.setBlvligQteUtilStock(var19.getBlvligQteUtil());
                  var19 = var12.modif(var19, var4);
                  var7 = var19.getLivraisonEnteteVentes();
                  var7.setBlvLivreur(0);
                  var8.modif(var7, var4);
               } else {
                  var17 = 0.0F;
                  var18 = 0.0F;
                  List var9 = var10.chargerLesLivraisons(var19, var4);
                  if (var9.size() != 0) {
                     for(int var32 = 0; var32 < var9.size(); ++var32) {
                        var17 += ((LivraisonLivreeVentes)var9.get(var32)).getBlvlivQteLivree();
                        var18 += ((LivraisonLivreeVentes)var9.get(var32)).getBlvlivQteUtilLivree();
                     }
                  }

                  var19.setBlvligQteStock(var17);
                  var19.setBlvligQteUtilStock(var18);
                  var19 = var12.modif(var19, var4);
                  var7 = var19.getLivraisonEnteteVentes();
                  var7.setBlvLivreur(1);
                  var8.modif(var7, var4);
               }

               ++var16;
               if (var16 == 100) {
                  var4.flush();
                  var16 = 0;
               }
            }
         }

         var5.commit();
      } catch (HibernateException var30) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var30;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculConnexionLivree() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul connexion de la table livraison livrée");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         this.var_info = "Chargement des livraisons livrées...";
         new ArrayList();
         LivraisonLivreeVentesDao var7 = new LivraisonLivreeVentesDao(this.baseLog, this.utilInitHibernate);
         String var8 = var3.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         String var9 = var3.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         String var10 = "blvlivDate>='" + var8 + "' and blvlivDate<='" + var9 + "'";
         List var6 = var7.rechercheLivreeRequete(var10, var4);
         if (var6.size() != 0) {
            int var11 = 0;
            new LivraisonLivreeVentes();
            new LivraisonLigneVentes();
            new LivraisonEnteteVentes();

            for(int var15 = 0; var15 < var6.size(); ++var15) {
               LivraisonLivreeVentes var12 = (LivraisonLivreeVentes)var6.get(var15);
               LivraisonLigneVentes var13 = var12.getLivraisonLigneVentes();
               if (var13 != null) {
                  LivraisonEnteteVentes var14 = var13.getLivraisonEnteteVentes();
                  if (var14 != null) {
                     this.var_info = "Livre: " + var12.getLivraisonLigneVentes().getLivraisonEnteteVentes().getBlvNum();
                     if (var15 != 0) {
                        double var16 = (double)var6.size();
                        double var18 = var2.myRound(var16 / (double)var15, 4);
                        double var20 = var2.myRound(100.0D / var18, 2);
                        this.var_currentValue = (int)var20;
                     }

                     var12.setBlvlivIdBl(var12.getLivraisonLigneVentes().getLivraisonEnteteVentes().getBlvId());
                  } else {
                     var12.setBlvlivIdBl(0L);
                  }
               } else {
                  var12.setBlvlivIdBl(0L);
               }

               var7.modifLigne(var12, var4);
               ++var11;
               if (var11 == 100) {
                  var4.flush();
                  var11 = 0;
               }
            }
         }

         var5.commit();
      } catch (HibernateException var25) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var25;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculConnexionDCLRNFA() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul connexion de la table Devis, BC, Bl, BR, Facture, Ndb, Avoir");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         String var6 = var3.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         String var7 = var3.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         String var8 = "";
         this.var_info = "Chargement des devis...";
         new ArrayList();
         DevisEnteteVentesDao var10 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var8 = "dvsDate>='" + var6 + "' and dvsDate<='" + var7 + "'";
         List var9 = var10.rechercheDevisRequete(var8, var4);
         double var16;
         double var18;
         if (var9.size() != 0) {
            new DevisEnteteVentes();
            new Tiers();

            for(int var13 = 0; var13 < var9.size(); ++var13) {
               DevisEnteteVentes var11 = (DevisEnteteVentes)var9.get(var13);
               if (var13 != 0) {
                  double var14 = (double)var9.size();
                  var16 = var2.myRound(var14 / (double)var13, 4);
                  var18 = var2.myRound(100.0D / var16, 2);
                  this.var_currentValue = (int)var18;
               }

               Tiers var12 = this.tiersDao.chargerLesTiers("102", var11.getDvsNomTiers(), var4);
               if (var12 != null) {
                  var11.setTiers(var12);
                  var10.modif(var11, var4);
               }
            }

            var4.flush();
         }

         this.var_info = "Chargement des bons de commande...";
         this.var_currentValue = 0;
         new ArrayList();
         CommandeEnteteVentesDao var38 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var8 = "bcmDate>='" + var6 + "' and bcmDate<='" + var7 + "'";
         List var37 = var38.rechercheCommandeRequete(var8, var4);
         double var20;
         if (var37.size() != 0) {
            new CommandeEnteteVentes();
            new Tiers();

            for(int var15 = 0; var15 < var37.size(); ++var15) {
               CommandeEnteteVentes var39 = (CommandeEnteteVentes)var37.get(var15);
               if (var15 != 0) {
                  var16 = (double)var37.size();
                  var18 = var2.myRound(var16 / (double)var15, 4);
                  var20 = var2.myRound(100.0D / var18, 2);
                  this.var_currentValue = (int)var20;
               }

               Tiers var41 = this.tiersDao.chargerLesTiers("3", var39.getBcmNomTiers(), var4);
               if (var41 != null) {
                  var39.setTiers(var41);
                  var38.modif(var39, var4);
               }
            }

            var4.flush();
         }

         this.var_info = "Chargement des bons de livraison...";
         this.var_currentValue = 0;
         new ArrayList();
         LivraisonEnteteVentesDao var42 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var8 = "blvDate>='" + var6 + "' and blvDate<='" + var7 + "'";
         List var40 = var42.rechercheLivraisonRequete(var8, var4);
         double var22;
         if (var40.size() != 0) {
            new LivraisonEnteteVentes();
            new Tiers();

            for(int var17 = 0; var17 < var40.size(); ++var17) {
               LivraisonEnteteVentes var43 = (LivraisonEnteteVentes)var40.get(var17);
               if (var17 != 0) {
                  var18 = (double)var40.size();
                  var20 = var2.myRound(var18 / (double)var17, 4);
                  var22 = var2.myRound(100.0D / var20, 2);
                  this.var_currentValue = (int)var22;
               }

               Tiers var45 = this.tiersDao.chargerLesTiers("3", var43.getBlvNomTiers(), var4);
               if (var45 != null) {
                  var43.setTiers(var45);
                  var42.modif(var43, var4);
               }
            }

            var4.flush();
         }

         this.var_info = "Chargement des bons de retour...";
         this.var_currentValue = 0;
         new ArrayList();
         RetourEnteteVentesDao var46 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var8 = "brtDate>='" + var6 + "' and brtDate<='" + var7 + "'";
         List var44 = var46.rechercheRetourRequete(var8, var4);
         double var24;
         if (var44.size() != 0) {
            new RetourEnteteVentes();
            new Tiers();

            for(int var19 = 0; var19 < var44.size(); ++var19) {
               RetourEnteteVentes var47 = (RetourEnteteVentes)var44.get(var19);
               if (var19 != 0) {
                  var20 = (double)var44.size();
                  var22 = var2.myRound(var20 / (double)var19, 4);
                  var24 = var2.myRound(100.0D / var22, 2);
                  this.var_currentValue = (int)var24;
               }

               Tiers var49 = this.tiersDao.chargerLesTiers("3", var47.getBrtNomTiers(), var4);
               if (var49 != null) {
                  var47.setTiers(var49);
                  var46.modif(var47, var4);
               }
            }

            var4.flush();
         }

         this.var_info = "Chargement des factures...";
         this.var_currentValue = 0;
         new ArrayList();
         FactureEnteteVentesDao var50 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var8 = "facDate>='" + var6 + "' and facDate<='" + var7 + "'";
         List var48 = var50.rechercheFactureRequete(var8, var4);
         double var26;
         if (var48.size() != 0) {
            new FactureEnteteVentes();
            new Tiers();

            for(int var21 = 0; var21 < var48.size(); ++var21) {
               FactureEnteteVentes var51 = (FactureEnteteVentes)var48.get(var21);
               if (var21 != 0) {
                  var22 = (double)var48.size();
                  var24 = var2.myRound(var22 / (double)var21, 4);
                  var26 = var2.myRound(100.0D / var24, 2);
                  this.var_currentValue = (int)var26;
               }

               Tiers var53 = this.tiersDao.chargerLesTiers("3", var51.getFacNomTiers(), var4);
               if (var53 != null) {
                  var51.setTiers(var53);
                  var50.modif(var51, var4);
               }
            }

            var4.flush();
         }

         this.var_info = "Chargement des notes de débit...";
         this.var_currentValue = 0;
         new ArrayList();
         NoteDebitEnteteVentesDao var54 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var8 = "ndbDate>='" + var6 + "' and ndbDate<='" + var7 + "'";
         List var52 = var54.rechercheNoteDebitRequete(var8, var4);
         double var28;
         if (var52.size() != 0) {
            new NoteDebitEnteteVentes();
            new Tiers();

            for(int var23 = 0; var23 < var52.size(); ++var23) {
               NoteDebitEnteteVentes var55 = (NoteDebitEnteteVentes)var52.get(var23);
               if (var23 != 0) {
                  var24 = (double)var52.size();
                  var26 = var2.myRound(var24 / (double)var23, 4);
                  var28 = var2.myRound(100.0D / var26, 2);
                  this.var_currentValue = (int)var28;
               }

               Tiers var57 = this.tiersDao.chargerLesTiers("3", var55.getNdbNomTiers(), var4);
               if (var57 != null) {
                  var55.setTiers(var57);
                  var54.modif(var55, var4);
               }
            }

            var4.flush();
         }

         this.var_info = "Chargement des avoirs...";
         this.var_currentValue = 0;
         new ArrayList();
         AvoirEnteteVentesDao var58 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         var8 = "avrDate>='" + var6 + "' and avrDate<='" + var7 + "'";
         List var56 = var58.rechercheAvoirRequete(var8, var4);
         if (var56.size() != 0) {
            new AvoirEnteteVentes();
            new Tiers();

            for(int var25 = 0; var25 < var56.size(); ++var25) {
               AvoirEnteteVentes var59 = (AvoirEnteteVentes)var56.get(var25);
               if (var25 != 0) {
                  var26 = (double)var56.size();
                  var28 = var2.myRound(var26 / (double)var25, 4);
                  double var30 = var2.myRound(100.0D / var28, 2);
                  this.var_currentValue = (int)var30;
               }

               Tiers var60 = this.tiersDao.chargerLesTiers("3", var59.getAvrNomTiers(), var4);
               if (var60 != null) {
                  var59.setTiers(var60);
                  var58.modif(var59, var4);
               }
            }

            var4.flush();
         }

         var5.commit();
      } catch (HibernateException var35) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var35;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void generationReglementFacture() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("generation réglements Facture Ventes");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new ExercicesCaisse();
         this.exercicesCaisseDao = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
         ExercicesCaisse var4 = this.exercicesCaisseDao.recupererLastExo(var2);
         if (var4 != null) {
            FactureEnteteVentesDao var5 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            UtilDate var6 = new UtilDate();
            String var7 = var6.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
            String var8 = var6.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
            new ArrayList();
            Object var10 = new ArrayList();
            ReglementsDao var11 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
            List var9 = var5.rechercheFacturePeriode(var7, var8, var2);
            if (var9.size() != 0) {
               new FactureEnteteVentes();

               for(int var13 = 0; var13 < var9.size(); ++var13) {
                  FactureEnteteVentes var12 = (FactureEnteteVentes)var9.get(var13);
                  double var14 = 0.0D;
                  ((List)var10).clear();
                  var10 = var11.reglementDocument(var12.getFacId(), 25, var2);
                  if (((List)var10).size() != 0) {
                     for(int var16 = 0; var16 < ((List)var10).size(); ++var16) {
                        var14 += ((Reglements)((List)var10).get(var16)).getRglRecette();
                     }
                  }

                  double var23;
                  if (var14 < var12.getFacTotTtc()) {
                     var23 = var12.getFacTotTtc() - var14;
                     this.generationReglement(var12, var23, var11, var6, var4, var2);
                     var12.setFacTotReglement(var12.getFacTotTtc());
                     var12.setFacSolde(1);
                     var5.modif(var12, var2);
                  } else if (var14 > var12.getFacTotTtc()) {
                     var23 = var12.getFacTotTtc() - var14;
                     this.generationReglement(var12, var23, var11, var6, var4, var2);
                     var12.setFacTotReglement(var12.getFacTotTtc());
                     var12.setFacSolde(1);
                     var5.modif(var12, var2);
                  } else {
                     var12.setFacSolde(1);
                     var12.setFacTotReglement(var12.getFacTotTtc());
                     var5.modif(var12, var2);
                  }
               }
            }
         }

         var3.commit();
      } catch (HibernateException var21) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var21;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void generationReglement(FactureEnteteVentes var1, double var2, ReglementsDao var4, UtilDate var5, ExercicesCaisse var6, Session var7) {
      Reglements var8 = new Reglements();
      var8.setRglOperation("");
      var8.setRglBon("");
      var8.setRglCategorie(20);
      var8.setRglCodeCaiss("");
      var8.setRglLibCaiss("");
      var8.setRglCodeEmetrice("");
      var8.setRglLibEmetrice("");
      var8.setRglCodeReceptrice("");
      var8.setRglLibReceptrice("");
      var8.setRglDateCreation(new Date());
      var8.setRglDateImp((Date)null);
      var8.setRglDateTransfert((Date)null);
      var8.setRglDateValeur((Date)null);
      var8.setRglDateReg(var1.getFacDate());
      var8.setRglDepense(0.0D);
      var8.setRglDocument(var1.getFacNum());
      var8.setRglFormatDevise(var1.getVar_format_devise());
      var8.setRglIdCaissier(this.usersLog.getUsrid());
      var8.setRglIdBon(0L);
      var8.setRglIdDocument(var1.getFacId());
      var8.setRglIdTiers(var1.getTiers().getTieid());
      var8.setRglDepotTiers(0);
      var8.setRglNatureDoc(25);
      var8.setRglLibelle("GENERATION AUTOMATIQUE");
      var8.setRglMode("11");
      var8.setRglTypeReg(11);
      var8.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      var8.setRglIdContact(0L);
      var8.setRglNomContact("");
      var8.setRglNum("");
      var8.setRglParc("");
      var8.setRglRecette(var2);
      var8.setRglTimbre(0.0D);
      var8.setRglTrf(0);
      var8.setRglTypeTiers(0);
      var8.setRglUserCreat(this.usersLog.getUsrid());
      var8.setRglUserModif(0L);
      String var9 = "";
      if (var8.getRglDateReg().getMonth() + 1 <= 9) {
         var9 = "0" + (var8.getRglDateReg().getMonth() + 1);
      } else {
         var9 = "" + (var8.getRglDateReg().getMonth() + 1);
      }

      String var10 = "" + (var8.getRglDateReg().getYear() + 1900);
      var8.setRglPeriode(var9 + ":" + var10);
      var8.setRglCle1(var8.getRglCodeCaiss() + ":" + var8.getRglPeriode());
      String var11 = var5.dateToStringSQLLight(var8.getRglDateReg());
      var8.setRglCle2(var8.getRglCodeCaiss() + ":" + var11);
      var8.setExercicesCaisse(var6);
      var4.insert(var8, var7);
   }

   public void recalculActiviteEnteteProduit() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des activités des entetes des documents à partir des activités des produits");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      this.optionVentes = var2.lancer();
      if (this.optionVentes.getActiviteEnteteLigne().equals("1")) {
         boolean var3 = false;
         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            var3 = true;
         } else {
            var3 = false;
         }

         ProduitsVtesDao var4 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         UtilDate var5 = new UtilDate();
         String var6 = var5.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         String var7 = var5.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         Date var8 = var5.stringToDateSQL(var6);
         Date var9 = var5.stringToDateSQL(var7);
         Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var11 = null;

         CommandeEnteteVentesDao var12;
         CommandeLigneVentesDao var13;
         List var15;
         int var22;
         try {
            var11 = var10.beginTransaction();
            var12 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            var13 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            new ArrayList();
            List var14 = var12.rechercheCommandeByDate(var8, var9, var10);
            if (var14.size() != 0) {
               String var16 = "";
               boolean var17 = true;
               new CommandeEnteteVentes();
               new CommandeLigneVentes();
               new Produits();

               for(int var21 = 0; var21 < var14.size(); ++var21) {
                  CommandeEnteteVentes var18 = (CommandeEnteteVentes)var14.get(var21);
                  var17 = true;
                  var16 = "";
                  var15 = var13.chargerLesLignes(var18, var10);
                  CommandeLigneVentes var19;
                  Produits var20;
                  if (var3) {
                     if (var15.size() != 0) {
                        for(var22 = 0; var22 < var15.size(); ++var22) {
                           var19 = (CommandeLigneVentes)var15.get(var22);
                           if (var19.getBcmligCode() != null && !var19.getBcmligCode().isEmpty()) {
                              var20 = var4.chargeProduit(var19.getBcmligCode(), var10);
                              if (var20 != null && var20.getProActivite() != null && !var20.getProActivite().isEmpty()) {
                                 if (var17) {
                                    var16 = var20.getProActivite();
                                    var17 = false;
                                 } else {
                                    var16 = var16 + "#" + var20.getProActivite();
                                 }
                              }
                           }
                        }
                     }
                  } else if (var15.size() != 0) {
                     for(var22 = 0; var22 < var15.size(); ++var22) {
                        var19 = (CommandeLigneVentes)var15.get(var22);
                        if (var19.getBcmligCode() != null && !var19.getBcmligCode().isEmpty()) {
                           var20 = var4.chargeProduit(var19.getBcmligCode(), var10);
                           if (var20 != null && var20.getProActivite() != null && !var20.getProActivite().isEmpty()) {
                              if (var17) {
                                 var16 = var20.getProActivite();
                                 var17 = false;
                              } else {
                                 var16 = var16 + "#" + var20.getProActivite();
                              }
                           }
                        }
                     }
                  }

                  var18.setBcmActivite(var16);
                  var12.modif(var18, var10);
               }
            }

            var11.commit();
         } catch (HibernateException var50) {
            if (var11 != null) {
               var11.rollback();
            }

            throw var50;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         var12 = null;

         List var58;
         try {
            Transaction var52 = var10.beginTransaction();
            LivraisonEnteteVentesDao var53 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            LivraisonLigneVentesDao var55 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            new ArrayList();
            var15 = var53.rechercheLivraisonByDate(var8, var9, var10);
            if (var15.size() != 0) {
               String var59 = "";
               boolean var60 = true;
               new LivraisonEnteteVentes();
               new LivraisonLigneVentes();
               new Produits();

               for(var22 = 0; var22 < var15.size(); ++var22) {
                  LivraisonEnteteVentes var62 = (LivraisonEnteteVentes)var15.get(var22);
                  var60 = true;
                  var59 = "";
                  var58 = var55.chargerLesLignes(var62, var10);
                  int var23;
                  LivraisonLigneVentes var65;
                  Produits var67;
                  if (var3) {
                     if (var58.size() != 0) {
                        for(var23 = 0; var23 < var58.size(); ++var23) {
                           var65 = (LivraisonLigneVentes)var58.get(var23);
                           if (var65.getBlvligCode() != null && !var65.getBlvligCode().isEmpty()) {
                              var67 = var4.chargeProduit(var65.getBlvligCode(), var10);
                              if (var67 != null && var67.getProActivite() != null && !var67.getProActivite().isEmpty()) {
                                 if (var60) {
                                    var59 = var67.getProActivite();
                                    var60 = false;
                                 } else {
                                    var59 = var59 + "#" + var67.getProActivite();
                                 }
                              }
                           }
                        }
                     }
                  } else if (var58.size() != 0) {
                     for(var23 = 0; var23 < var58.size(); ++var23) {
                        var65 = (LivraisonLigneVentes)var58.get(var23);
                        if (var65.getBlvligCode() != null && !var65.getBlvligCode().isEmpty()) {
                           var67 = var4.chargeProduit(var65.getBlvligCode(), var10);
                           if (var67 != null && var67.getProActivite() != null && !var67.getProActivite().isEmpty()) {
                              if (var60) {
                                 var59 = var67.getProActivite();
                                 var60 = false;
                              } else {
                                 var59 = var59 + "#" + var67.getProActivite();
                              }
                           }
                        }
                     }
                  }

                  var62.setBlvActivite(var59);
                  var53.modif(var62, var10);
               }
            }

            var52.commit();
         } catch (HibernateException var48) {
            if (var12 != null) {
               var12.rollback();
            }

            throw var48;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         var13 = null;

         try {
            Transaction var54 = var10.beginTransaction();
            FactureEnteteVentesDao var56 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            FactureLigneVentesDao var57 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            new ArrayList();
            String var61 = var5.dateToStringSQLLight(var8) + " 00:00:00";
            String var63 = var5.dateToStringSQLLight(var9) + " 23:59:59";
            var58 = var56.rechercheFactureByDate(var61, var63, var10);
            if (var58.size() != 0) {
               String var66 = "";
               boolean var68 = true;
               new FactureEnteteVentes();
               new FactureLigneVentes();
               new Produits();

               for(int var25 = 0; var25 < var58.size(); ++var25) {
                  FactureEnteteVentes var69 = (FactureEnteteVentes)var58.get(var25);
                  var68 = true;
                  var66 = "";
                  List var64 = var57.chargerLesLignes(var69, var10);
                  Produits var24;
                  int var26;
                  FactureLigneVentes var70;
                  if (var3) {
                     if (var64.size() != 0) {
                        for(var26 = 0; var26 < var64.size(); ++var26) {
                           var70 = (FactureLigneVentes)var64.get(var26);
                           if (var70.getFacligCode() != null && !var70.getFacligCode().isEmpty()) {
                              var24 = var4.chargeProduit(var70.getFacligCode(), var10);
                              if (var24 != null && var24.getProActivite() != null && !var24.getProActivite().isEmpty()) {
                                 if (var68) {
                                    var66 = var24.getProActivite();
                                    var68 = false;
                                 } else {
                                    var66 = var66 + "#" + var24.getProActivite();
                                 }
                              }
                           }
                        }
                     }
                  } else if (var64.size() != 0) {
                     for(var26 = 0; var26 < var64.size(); ++var26) {
                        var70 = (FactureLigneVentes)var64.get(var26);
                        if (var70.getFacligCode() != null && !var70.getFacligCode().isEmpty()) {
                           var24 = var4.chargeProduit(var70.getFacligCode(), var10);
                           if (var24 != null && var24.getProActivite() != null && !var24.getProActivite().isEmpty()) {
                              if (var68) {
                                 var66 = var24.getProActivite();
                                 var68 = false;
                              } else {
                                 var66 = var66 + "#" + var24.getProActivite();
                              }
                           }
                        }
                     }
                  }

                  var69.setFacActivite(var66);
                  var56.modif(var69, var10);
               }
            }

            var54.commit();
         } catch (HibernateException var46) {
            if (var13 != null) {
               var13.rollback();
            }

            throw var46;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculQteLivreeCMD() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul qte livrée des COMMANDES");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         this.var_info = "Chargement des COMMANDES...";
         new CommandeEnteteVentes();
         CommandeEnteteVentesDao var7 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         new CommandeLigneVentes();
         DocumentTraceVentesDao var10 = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
         new DocumentTraceVentes();
         Object var12 = new ArrayList();
         ArrayList var13 = new ArrayList();
         Object var14 = new ArrayList();
         CommandeLigneVentesDao var15 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new LivraisonEnteteVentes();
         LivraisonEnteteVentesDao var17 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         Object var18 = new ArrayList();
         ArrayList var19 = new ArrayList();
         LivraisonLigneVentesDao var20 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new LivraisonLigneVentes();
         String var22 = var3.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         String var23 = var3.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         String var24 = "bcmDate>='" + var22 + "' and bcmDate<='" + var23 + "'";
         List var8 = var7.rechercheCommandeRequete(var24, var4);
         int var25 = 0;
         if (var8.size() != 0) {
            for(int var26 = 0; var26 < var8.size(); ++var26) {
               CommandeEnteteVentes var6 = (CommandeEnteteVentes)var8.get(var26);
               this.var_info = "Commande: " + var6.getBcmNum();
               if (var26 != 0) {
                  double var27 = (double)var8.size();
                  double var29 = var2.myRound(var27 / (double)var26, 4);
                  double var31 = var2.myRound(100.0D / var29, 2);
                  this.var_currentValue = (int)var31;
               }

               ((List)var18).clear();
               var19.clear();
               ((List)var14).clear();
               var14 = var15.chargerLesLignes(var6, var4);
               var13.clear();
               ((List)var12).clear();
               var12 = var10.chargerLesDocumentsTrace(var6.getBcmId(), 22, var4);
               DocumentTraceVentes var11;
               int var38;
               if (((List)var12).size() != 0) {
                  for(var38 = 0; var38 < ((List)var12).size(); ++var38) {
                     var11 = (DocumentTraceVentes)((List)var12).get(var38);
                     if (var11.getDoctraDstType() == 23) {
                        var13.add(var11);
                     }
                  }
               }

               CommandeLigneVentes var9;
               if (var13.size() == 0) {
                  for(var38 = 0; var38 < ((List)var14).size(); ++var38) {
                     var9 = (CommandeLigneVentes)((List)var14).get(var38);
                     var9.setBcmligQteLivree(0.0F);
                     var15.modifLigne(var9, var4);
                  }
               } else {
                  ((List)var18).clear();
                  var19.clear();
                  var38 = 0;

                  label231:
                  while(true) {
                     LivraisonLigneVentes var21;
                     if (var38 >= var13.size()) {
                        if (var19.size() == 0) {
                           break;
                        }

                        var38 = 0;

                        while(true) {
                           if (var38 >= ((List)var14).size()) {
                              break label231;
                           }

                           var9 = (CommandeLigneVentes)((List)var14).get(var38);
                           float var39 = 0.0F;

                           for(int var40 = 0; var40 < var19.size(); ++var40) {
                              var21 = (LivraisonLigneVentes)var19.get(var40);
                              if (var21.getBlvligCode().equals(var9.getBcmligCode())) {
                                 var39 += var21.getBlvligQteUtil();
                                 var9.setBcmligDepot(var21.getBlvligDepot());
                                 var21.setBlvligIdBcm(var9.getBcmligId());
                                 var20.modif(var21, var4);
                              }
                           }

                           var9.setBcmligQteLivree(var39);
                           var15.modifLigne(var9, var4);
                           ++var38;
                        }
                     }

                     var11 = (DocumentTraceVentes)var13.get(var38);
                     LivraisonEnteteVentes var16 = var17.pourParapheur(var11.getDoctraDstId(), var4);
                     if (var16 != null) {
                        var18 = var20.chargerLesLignes(var16, var4);
                        if (((List)var18).size() != 0) {
                           for(int var28 = 0; var28 < ((List)var18).size(); ++var28) {
                              var21 = (LivraisonLigneVentes)((List)var18).get(var28);
                              var19.add(var21);
                           }
                        }
                     }

                     ++var38;
                  }
               }

               ++var25;
               if (var25 == 100) {
                  var4.flush();
                  var25 = 0;
               }
            }
         }

         var5.commit();
      } catch (HibernateException var36) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var36;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculTimbreDocreglement() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul cumul des timbres des documents à partir des réglements");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         this.var_info = "Chargement des Factures...";
         FactureEnteteVentesDao var6 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         Object var8 = new ArrayList();
         ReglementsDao var9 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         String var10 = var3.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         String var11 = var3.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         List var7 = var6.rechercheFacturePeriode(var10, var11, var4);
         int var12 = 0;
         if (var7.size() != 0) {
            new FactureEnteteVentes();

            for(int var14 = 0; var14 < var7.size(); ++var14) {
               FactureEnteteVentes var13 = (FactureEnteteVentes)var7.get(var14);
               this.var_info = "Facture: " + var13.getFacNum();
               double var15;
               double var17;
               if (var14 != 0) {
                  var15 = (double)var7.size();
                  var17 = var2.myRound(var15 / (double)var14, 4);
                  double var19 = var2.myRound(100.0D / var17, 2);
                  this.var_currentValue = (int)var19;
               }

               var15 = 0.0D;
               var17 = 0.0D;
               ((List)var8).clear();
               var8 = var9.reglementDocument(var13.getFacId(), 25, var4);
               if (((List)var8).size() != 0) {
                  for(int var26 = 0; var26 < ((List)var8).size(); ++var26) {
                     var15 += ((Reglements)((List)var8).get(var26)).getRglRecette();
                     var17 += ((Reglements)((List)var8).get(var26)).getRglTimbre();
                  }
               }

               var13.setFacTotReglement(var15);
               var13.setFacTotTimbre(var17);
               if (var15 - var17 >= var13.getFacTotTtc() + var13.getFacTotTc()) {
                  var13.setFacSolde(1);
               } else {
                  var13.setFacSolde(0);
               }

               var6.modif(var13, var4);
               ++var12;
               if (var12 == 100) {
                  var4.flush();
                  var12 = 0;
               }
            }
         }

         var5.commit();
      } catch (HibernateException var24) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var24;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculDateFactureBl() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul date facture à partir de la date du BL");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         this.var_info = "Chargement des Factures...";
         new LivraisonEnteteVentes();
         LivraisonEnteteVentesDao var7 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         FactureEnteteVentesDao var8 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         String var10 = var3.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         String var11 = var3.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         List var9 = var8.rechercheFacturePeriode(var10, var11, var4);
         int var12 = 0;
         if (var9.size() != 0) {
            new FactureEnteteVentes();

            for(int var14 = 0; var14 < var9.size(); ++var14) {
               FactureEnteteVentes var13 = (FactureEnteteVentes)var9.get(var14);
               this.var_info = "Facture: " + var13.getFacNum();
               if (var14 != 0) {
                  double var15 = (double)var9.size();
                  double var17 = var2.myRound(var15 / (double)var14, 4);
                  double var19 = var2.myRound(100.0D / var17, 2);
                  this.var_currentValue = (int)var19;
               }

               if (var13.getFacNumBl() != null && !var13.getFacNumBl().isEmpty()) {
                  LivraisonEnteteVentes var6 = var7.pourParapheur(var13.getFacNumBl(), var13.getFacSerie(), var4);
                  if (var6 != null) {
                     var13.setFacDate(var6.getBlvDate());
                     var8.modif(var13, var4);
                     ++var12;
                     if (var12 == 100) {
                        var4.flush();
                        var12 = 0;
                     }
                  }
               }
            }
         }

         var5.commit();
      } catch (HibernateException var24) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var24;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void correctionFamilleVente() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("correction des familles ventes");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      ArrayList var3 = new ArrayList();
      new ArrayList();
      new Produits();
      ProduitsVtesDao var6 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      new FamillesProduitsVentes();
      FamillesProduitsVentesDao var8 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.var_info = "Chargement des familles ventes....";
      new ExercicesVentes();
      this.exercicesVentesDao = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var9 = this.exercicesVentesDao.recupererLastExo((Session)null);
      if (var9 != null) {
         List var4 = var6.selectAllProduits((Session)null);
         if (var4.size() != 0) {
            Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");

            Produits var5;
            FamillesProduitsVentes var7;
            for(int var11 = 0; var11 < var4.size(); ++var11) {
               var5 = (Produits)var4.get(var11);
               if (var5.getProVteCode() == null && var5.getProVteCode().isEmpty()) {
                  var3.add(var5);
               } else {
                  var7 = var8.rechercheFamilleByProd(var9.getExevteId(), var5, var10);
                  if (var7 == null) {
                     var3.add(var5);
                  }
               }
            }

            if (var3.size() != 0) {
               boolean var25 = false;
               Transaction var12 = null;

               try {
                  var12 = var10.beginTransaction();

                  for(int var13 = 0; var13 < var3.size(); ++var13) {
                     var5 = (Produits)var3.get(var13);
                     this.var_info = "Famille " + ((Produits)var3.get(var13)).getProVteCode() + " Numero " + var13 + ", pour un total de " + var3.size() + " total ";
                     if (var13 != 0) {
                        double var14 = (double)var3.size();
                        double var16 = var2.myRound(var14 / (double)var13, 4);
                        double var18 = var2.myRound(100.0D / var16, 2);
                        this.var_currentValue = (int)var18;
                     }

                     if (var5.getProVteCode() == null || var5.getProVteCode().isEmpty()) {
                        var5.setProVteCode("XX");
                     }

                     boolean var26 = var8.existCode(var9.getExevteId(), var5.getProAchCode(), var10);
                     if (var26) {
                        var7 = new FamillesProduitsVentes();
                        var7.setExerciceventes(var9);
                        var7.setFamvteCode(var5.getProVteCode());
                        var7.setFamvteLibelleFr(var5.getProVteLib());
                        var7.setFamvteNature("1601");
                        var7.setFamvteLibNature("Produits finis");
                        var7.setFamvteCat(0);
                        var7.setFamvteStock(0);
                        var8.insert(var7, var10);
                     }
                  }

                  var12.commit();
               } catch (HibernateException var23) {
                  if (var12 != null) {
                     var12.rollback();
                  }

                  throw var23;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            } else {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculGroupeTiers() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalculdes groupes tiers/destinataires");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilDate var2 = new UtilDate();
      UtilNombre var3 = new UtilNombre();
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var4 = new LireLesoptionsVentes();
      var4.setStrId(this.structureLog.getStrid());
      this.optionVentes = var4.lancer();
      boolean var5 = false;
      if (this.optionVentes.getDecrmtPrsChrStock().equals("2")) {
         var5 = true;
      }

      PlansAnalytiques var6 = new PlansAnalytiques();
      PlansAnalytiquesDao var7 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.formRecherche = new FormRecherche(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      this.var_showBarProg = true;
      String var8 = var2.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
      String var9 = var2.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
      String var10 = "";
      this.var_currentValue = 0;
      this.var_info = "Chargement des devis....";
      Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
      new ArrayList();
      DevisEnteteVentesDao var13 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      var10 = "dvsDate>='" + var8 + "' and dvsDate<='" + var9 + "'";
      List var12 = var13.rechercheDevisRequete(var10, var11);
      double var20;
      double var22;
      if (var12.size() != 0) {
         int var14 = 0;
         Transaction var15 = null;

         try {
            var15 = var11.beginTransaction();
            new DevisEnteteVentes();

            for(int var17 = 0; var17 < var12.size(); ++var17) {
               DevisEnteteVentes var16 = (DevisEnteteVentes)var12.get(var17);
               if (var17 != 0) {
                  double var18 = (double)var12.size();
                  var20 = var3.myRound(var18 / (double)var17, 4);
                  var22 = var3.myRound(100.0D / var20, 2);
                  this.var_currentValue = (int)var22;
               }

               if (var16.getUsers() != null) {
                  var16.setDvsSite(var16.getUsers().getUsrSite());
                  var16.setDvsDepartement(var16.getUsers().getUsrDepartement());
                  var16.setDvsService(var16.getUsers().getUsrService());
               } else {
                  var16.setDvsSite("");
                  var16.setDvsDepartement("");
                  var16.setDvsService("");
               }

               if (var5) {
                  var6 = this.formRecherche.rechercheDestinataire(var6, var7, var16.getDvsNomContact(), var11);
                  if (var6 != null) {
                     var16.setDvsTiersRegroupe(var6.getAnaTiersRegroupe());
                     var16.setDvsPdv(var6.getAnaTiersPdv());
                     var16.setDvsSecteur(var6.getAnaTiersSecteur());
                     var16.setDvsRegion(var6.getAnaTiersRegion());
                  } else {
                     var16.setDvsTiersRegroupe(var16.getTiers().getTiesigle());
                     var16.setDvsPdv(var16.getTiers().getTiepdv());
                     var16.setDvsSecteur(var16.getTiers().getTiesecteur());
                     var16.setDvsRegion(var16.getTiers().getTieregion());
                  }
               } else {
                  var16.setDvsNomTiers(var16.getTiers().getTieraisonsocialenom());
                  var16.setDvsTiersRegroupe(var16.getTiers().getTiesigle());
                  var16.setDvsPdv(var16.getTiers().getTiepdv());
                  var16.setDvsSecteur(var16.getTiers().getTiesecteur());
                  var16.setDvsRegion(var16.getTiers().getTieregion());
               }

               var13.modif(var16, var11);
               ++var14;
               if (var14 == 100) {
                  var11.flush();
                  var14 = 0;
               }
            }

            var15.commit();
         } catch (HibernateException var181) {
            if (var15 != null) {
               var15.rollback();
            }

            throw var181;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_currentValue = 0;
      this.var_info = "Chargement des commandes....";
      var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
      new ArrayList();
      CommandeEnteteVentesDao var184 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      var10 = "bcmDate>='" + var8 + "' and bcmDate<='" + var9 + "'";
      List var183 = var184.rechercheCommandeRequete(var10, var11);
      double var24;
      if (var183.size() != 0) {
         int var185 = 0;
         Transaction var187 = null;

         try {
            var187 = var11.beginTransaction();
            new CommandeEnteteVentes();

            for(int var19 = 0; var19 < var183.size(); ++var19) {
               CommandeEnteteVentes var189 = (CommandeEnteteVentes)var183.get(var19);
               if (var19 != 0) {
                  var20 = (double)var183.size();
                  var22 = var3.myRound(var20 / (double)var19, 4);
                  var24 = var3.myRound(100.0D / var22, 2);
                  this.var_currentValue = (int)var24;
               }

               if (var189.getUsers() != null) {
                  var189.setBcmSite(var189.getUsers().getUsrSite());
                  var189.setBcmDepartement(var189.getUsers().getUsrDepartement());
                  var189.setBcmService(var189.getUsers().getUsrService());
               } else {
                  var189.setBcmSite("");
                  var189.setBcmDepartement("");
                  var189.setBcmService("");
               }

               if (var5) {
                  var6 = this.formRecherche.rechercheDestinataire(var6, var7, var189.getBcmNomContact(), var11);
                  if (var6 != null) {
                     var189.setBcmTiersRegroupe(var6.getAnaTiersRegroupe());
                     var189.setBcmPdv(var6.getAnaTiersPdv());
                     var189.setBcmSecteur(var6.getAnaTiersSecteur());
                     var189.setBcmRegion(var6.getAnaTiersRegion());
                  } else {
                     var189.setBcmTiersRegroupe(var189.getTiers().getTiesigle());
                     var189.setBcmPdv(var189.getTiers().getTiepdv());
                     var189.setBcmSecteur(var189.getTiers().getTiesecteur());
                     var189.setBcmRegion(var189.getTiers().getTieregion());
                  }
               } else {
                  var189.setBcmNomTiers(var189.getTiers().getTieraisonsocialenom());
                  var189.setBcmTiersRegroupe(var189.getTiers().getTiesigle());
                  var189.setBcmPdv(var189.getTiers().getTiepdv());
                  var189.setBcmSecteur(var189.getTiers().getTiesecteur());
                  var189.setBcmRegion(var189.getTiers().getTieregion());
               }

               var184.modif(var189, var11);
               ++var185;
               if (var185 == 100) {
                  var11.flush();
                  var185 = 0;
               }
            }

            var187.commit();
         } catch (HibernateException var179) {
            if (var187 != null) {
               var187.rollback();
            }

            throw var179;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_currentValue = 0;
      this.var_info = "Chargement des livraisons....";
      var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");
      new ArrayList();
      LivraisonEnteteVentesDao var188 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      var10 = "blvDate>='" + var8 + "' and blvDate<='" + var9 + "'";
      List var186 = var188.rechercheLivraisonRequete(var10, var11);
      double var26;
      if (var186.size() != 0) {
         int var190 = 0;
         Transaction var191 = null;

         try {
            var191 = var11.beginTransaction();
            new LivraisonEnteteVentes();

            for(int var21 = 0; var21 < var186.size(); ++var21) {
               LivraisonEnteteVentes var194 = (LivraisonEnteteVentes)var186.get(var21);
               if (var21 != 0) {
                  var22 = (double)var186.size();
                  var24 = var3.myRound(var22 / (double)var21, 4);
                  var26 = var3.myRound(100.0D / var24, 2);
                  this.var_currentValue = (int)var26;
               }

               if (var194.getUsers() != null) {
                  var194.setBlvSite(var194.getUsers().getUsrSite());
                  var194.setBlvDepartement(var194.getUsers().getUsrDepartement());
                  var194.setBlvService(var194.getUsers().getUsrService());
               } else {
                  var194.setBlvSite("");
                  var194.setBlvDepartement("");
                  var194.setBlvService("");
               }

               if (var5) {
                  var6 = this.formRecherche.rechercheDestinataire(var6, var7, var194.getBlvNomContact(), var11);
                  if (var6 != null) {
                     var194.setBlvTiersRegroupe(var6.getAnaTiersRegroupe());
                     var194.setBlvPdv(var6.getAnaTiersPdv());
                     var194.setBlvSecteur(var6.getAnaTiersSecteur());
                     var194.setBlvRegion(var6.getAnaTiersRegion());
                  } else {
                     var194.setBlvTiersRegroupe(var194.getTiers().getTiesigle());
                     var194.setBlvPdv(var194.getTiers().getTiepdv());
                     var194.setBlvSecteur(var194.getTiers().getTiesecteur());
                     var194.setBlvRegion(var194.getTiers().getTieregion());
                  }
               } else {
                  var194.setBlvNomTiers(var194.getTiers().getTieraisonsocialenom());
                  var194.setBlvTiersRegroupe(var194.getTiers().getTiesigle());
                  var194.setBlvPdv(var194.getTiers().getTiepdv());
                  var194.setBlvSecteur(var194.getTiers().getTiesecteur());
                  var194.setBlvRegion(var194.getTiers().getTieregion());
               }

               var188.modif(var194, var11);
               ++var190;
               if (var190 == 100) {
                  var11.flush();
                  var190 = 0;
               }
            }

            var191.commit();
         } catch (HibernateException var177) {
            if (var191 != null) {
               var191.rollback();
            }

            throw var177;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_currentValue = 0;
      this.var_info = "Chargement des retours....";
      var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourEnteteLight");
      new ArrayList();
      RetourEnteteVentesDao var193 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      var10 = "brtDate>='" + var8 + "' and brtDate<='" + var9 + "'";
      List var192 = var193.rechercheRetourRequete(var10, var11);
      double var28;
      if (var192.size() != 0) {
         int var195 = 0;
         Transaction var196 = null;

         try {
            var196 = var11.beginTransaction();
            new RetourEnteteVentes();

            for(int var23 = 0; var23 < var192.size(); ++var23) {
               RetourEnteteVentes var199 = (RetourEnteteVentes)var192.get(var23);
               if (var23 != 0) {
                  var24 = (double)var192.size();
                  var26 = var3.myRound(var24 / (double)var23, 4);
                  var28 = var3.myRound(100.0D / var26, 2);
                  this.var_currentValue = (int)var28;
               }

               if (var199.getUsers() != null) {
                  var199.setBrtSite(var199.getUsers().getUsrSite());
                  var199.setBrtDepartement(var199.getUsers().getUsrDepartement());
                  var199.setBrtService(var199.getUsers().getUsrService());
               } else {
                  var199.setBrtSite("");
                  var199.setBrtDepartement("");
                  var199.setBrtService("");
               }

               if (var5) {
                  var6 = this.formRecherche.rechercheDestinataire(var6, var7, var199.getBrtNomContact(), var11);
                  if (var6 != null) {
                     var199.setBrtTiersRegroupe(var6.getAnaTiersRegroupe());
                     var199.setBrtPdv(var6.getAnaTiersPdv());
                     var199.setBrtSecteur(var6.getAnaTiersSecteur());
                     var199.setBrtRegion(var6.getAnaTiersRegion());
                  } else {
                     var199.setBrtTiersRegroupe(var199.getTiers().getTiesigle());
                     var199.setBrtPdv(var199.getTiers().getTiepdv());
                     var199.setBrtSecteur(var199.getTiers().getTiesecteur());
                     var199.setBrtRegion(var199.getTiers().getTieregion());
                  }
               } else {
                  var199.setBrtNomTiers(var199.getTiers().getTieraisonsocialenom());
                  var199.setBrtTiersRegroupe(var199.getTiers().getTiesigle());
                  var199.setBrtPdv(var199.getTiers().getTiepdv());
                  var199.setBrtSecteur(var199.getTiers().getTiesecteur());
                  var199.setBrtRegion(var199.getTiers().getTieregion());
               }

               var193.modif(var199, var11);
               ++var195;
               if (var195 == 100) {
                  var11.flush();
                  var195 = 0;
               }
            }

            var196.commit();
         } catch (HibernateException var175) {
            if (var196 != null) {
               var196.rollback();
            }

            throw var175;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_currentValue = 0;
      this.var_info = "Chargement des factures....";
      var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
      new ArrayList();
      FactureEnteteVentesDao var198 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      var10 = "facDate>='" + var8 + "' and facDate<='" + var9 + "'";
      List var197 = var198.rechercheFactureRequete(var10, var11);
      double var30;
      if (var197.size() != 0) {
         int var200 = 0;
         Transaction var201 = null;

         try {
            var201 = var11.beginTransaction();
            new FactureEnteteVentes();

            for(int var25 = 0; var25 < var197.size(); ++var25) {
               FactureEnteteVentes var204 = (FactureEnteteVentes)var197.get(var25);
               if (var25 != 0) {
                  var26 = (double)var197.size();
                  var28 = var3.myRound(var26 / (double)var25, 4);
                  var30 = var3.myRound(100.0D / var28, 2);
                  this.var_currentValue = (int)var30;
               }

               if (var204.getUsers() != null) {
                  var204.setFacSite(var204.getUsers().getUsrSite());
                  var204.setFacDepartement(var204.getUsers().getUsrDepartement());
                  var204.setFacService(var204.getUsers().getUsrService());
               } else {
                  var204.setFacSite("");
                  var204.setFacDepartement("");
                  var204.setFacService("");
               }

               if (var5) {
                  var6 = this.formRecherche.rechercheDestinataire(var6, var7, var204.getFacNomContact(), var11);
                  if (var6 != null) {
                     var204.setFacTiersRegroupe(var6.getAnaTiersRegroupe());
                     var204.setFacPdv(var6.getAnaTiersPdv());
                     var204.setFacSecteur(var6.getAnaTiersSecteur());
                     var204.setFacRegion(var6.getAnaTiersRegion());
                  } else {
                     var204.setFacTiersRegroupe(var204.getTiers().getTiesigle());
                     var204.setFacPdv(var204.getTiers().getTiepdv());
                     var204.setFacSecteur(var204.getTiers().getTiesecteur());
                     var204.setFacRegion(var204.getTiers().getTieregion());
                  }
               } else {
                  var204.setFacNomTiers(var204.getTiers().getTieraisonsocialenom());
                  var204.setFacTiersRegroupe(var204.getTiers().getTiesigle());
                  var204.setFacPdv(var204.getTiers().getTiepdv());
                  var204.setFacSecteur(var204.getTiers().getTiesecteur());
                  var204.setFacRegion(var204.getTiers().getTieregion());
               }

               var198.modif(var204, var11);
               ++var200;
               if (var200 == 100) {
                  var11.flush();
                  var200 = 0;
               }
            }

            var201.commit();
         } catch (HibernateException var173) {
            if (var201 != null) {
               var201.rollback();
            }

            throw var173;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_currentValue = 0;
      this.var_info = "Chargement des notes de debit....";
      var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
      new ArrayList();
      NoteDebitEnteteVentesDao var202 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      var10 = "ndbDate>='" + var8 + "' and ndbDate<='" + var9 + "'";
      List var203 = var202.rechercheNoteDebitRequete(var10, var11);
      double var32;
      if (var203.size() != 0) {
         int var205 = 0;
         Transaction var206 = null;

         try {
            var206 = var11.beginTransaction();
            new NoteDebitEnteteVentes();

            for(int var27 = 0; var27 < var203.size(); ++var27) {
               NoteDebitEnteteVentes var209 = (NoteDebitEnteteVentes)var203.get(var27);
               if (var27 != 0) {
                  var28 = (double)var203.size();
                  var30 = var3.myRound(var28 / (double)var27, 4);
                  var32 = var3.myRound(100.0D / var30, 2);
                  this.var_currentValue = (int)var32;
               }

               if (var209.getUsers() != null) {
                  var209.setNdbSite(var209.getUsers().getUsrSite());
                  var209.setNdbDepartement(var209.getUsers().getUsrDepartement());
                  var209.setNdbService(var209.getUsers().getUsrService());
               } else {
                  var209.setNdbSite("");
                  var209.setNdbDepartement("");
                  var209.setNdbService("");
               }

               if (var5) {
                  var6 = this.formRecherche.rechercheDestinataire(var6, var7, var209.getNdbNomContact(), var11);
                  if (var6 != null) {
                     var209.setNdbTiersRegroupe(var6.getAnaTiersRegroupe());
                     var209.setNdbPdv(var6.getAnaTiersPdv());
                     var209.setNdbSecteur(var6.getAnaTiersSecteur());
                     var209.setNdbRegion(var6.getAnaTiersRegion());
                  } else {
                     var209.setNdbTiersRegroupe(var209.getTiers().getTiesigle());
                     var209.setNdbPdv(var209.getTiers().getTiepdv());
                     var209.setNdbSecteur(var209.getTiers().getTiesecteur());
                     var209.setNdbRegion(var209.getTiers().getTieregion());
                  }
               } else {
                  var209.setNdbNomTiers(var209.getTiers().getTieraisonsocialenom());
                  var209.setNdbTiersRegroupe(var209.getTiers().getTiesigle());
                  var209.setNdbPdv(var209.getTiers().getTiepdv());
                  var209.setNdbSecteur(var209.getTiers().getTiesecteur());
                  var209.setNdbRegion(var209.getTiers().getTieregion());
               }

               var202.modif(var209, var11);
               ++var205;
               if (var205 == 100) {
                  var11.flush();
                  var205 = 0;
               }
            }

            var206.commit();
         } catch (HibernateException var171) {
            if (var206 != null) {
               var206.rollback();
            }

            throw var171;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_currentValue = 0;
      this.var_info = "Chargement des avoirs....";
      var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
      new ArrayList();
      AvoirEnteteVentesDao var207 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      var10 = "avrDate>='" + var8 + "' and avrDate<='" + var9 + "'";
      List var208 = var207.rechercheAvoirRequete(var10, var11);
      double var34;
      if (var208.size() != 0) {
         int var210 = 0;
         Transaction var211 = null;

         try {
            var211 = var11.beginTransaction();
            new AvoirEnteteVentes();

            for(int var29 = 0; var29 < var208.size(); ++var29) {
               AvoirEnteteVentes var214 = (AvoirEnteteVentes)var208.get(var29);
               if (var29 != 0) {
                  var30 = (double)var208.size();
                  var32 = var3.myRound(var30 / (double)var29, 4);
                  var34 = var3.myRound(100.0D / var32, 2);
                  this.var_currentValue = (int)var34;
               }

               if (var214.getUsers() != null) {
                  var214.setAvrSite(var214.getUsers().getUsrSite());
                  var214.setAvrDepartement(var214.getUsers().getUsrDepartement());
                  var214.setAvrService(var214.getUsers().getUsrService());
               } else {
                  var214.setAvrSite("");
                  var214.setAvrDepartement("");
                  var214.setAvrService("");
               }

               if (var5) {
                  var6 = this.formRecherche.rechercheDestinataire(var6, var7, var214.getAvrNomContact(), var11);
                  if (var6 != null) {
                     var214.setAvrTiersRegroupe(var6.getAnaTiersRegroupe());
                     var214.setAvrPdv(var6.getAnaTiersPdv());
                     var214.setAvrSecteur(var6.getAnaTiersSecteur());
                     var214.setAvrRegion(var6.getAnaTiersRegion());
                  } else {
                     var214.setAvrTiersRegroupe(var214.getTiers().getTiesigle());
                     var214.setAvrPdv(var214.getTiers().getTiepdv());
                     var214.setAvrSecteur(var214.getTiers().getTiesecteur());
                     var214.setAvrRegion(var214.getTiers().getTieregion());
                  }
               } else {
                  var214.setAvrNomTiers(var214.getTiers().getTieraisonsocialenom());
                  var214.setAvrTiersRegroupe(var214.getTiers().getTiesigle());
                  var214.setAvrPdv(var214.getTiers().getTiepdv());
                  var214.setAvrSecteur(var214.getTiers().getTiesecteur());
                  var214.setAvrRegion(var214.getTiers().getTieregion());
               }

               var207.modif(var214, var11);
               ++var210;
               if (var210 == 100) {
                  var11.flush();
                  var210 = 0;
               }
            }

            var211.commit();
         } catch (HibernateException var169) {
            if (var211 != null) {
               var211.rollback();
            }

            throw var169;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_currentValue = 0;
      this.var_info = "Chargement des contrats....";
      var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
      new ArrayList();
      ContratEnteteVentesDao var212 = new ContratEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      var10 = "crtDate>='" + var8 + "' and crtDate<='" + var9 + "'";
      List var213 = var212.rechercheFactureRequete(var10, var11);
      if (var213.size() != 0) {
         int var215 = 0;
         Transaction var216 = null;

         try {
            var216 = var11.beginTransaction();
            new ContratEnteteVentes();

            for(int var31 = 0; var31 < var213.size(); ++var31) {
               ContratEnteteVentes var217 = (ContratEnteteVentes)var213.get(var31);
               if (var31 != 0) {
                  var32 = (double)var213.size();
                  var34 = var3.myRound(var32 / (double)var31, 4);
                  double var36 = var3.myRound(100.0D / var34, 2);
                  this.var_currentValue = (int)var36;
               }

               if (var217.getUsers() != null) {
                  var217.setCrtSite(var217.getUsers().getUsrSite());
                  var217.setCrtDepartement(var217.getUsers().getUsrDepartement());
                  var217.setCrtService(var217.getUsers().getUsrService());
               } else {
                  var217.setCrtSite("");
                  var217.setCrtDepartement("");
                  var217.setCrtService("");
               }

               if (var5) {
                  var6 = this.formRecherche.rechercheDestinataire(var6, var7, var217.getCrtNomContact(), var11);
                  if (var6 != null) {
                     var217.setCrtTiersRegroupe(var6.getAnaTiersRegroupe());
                     var217.setCrtPdv(var6.getAnaTiersPdv());
                     var217.setCrtSecteur(var6.getAnaTiersSecteur());
                     var217.setCrtRegion(var6.getAnaTiersRegion());
                  } else {
                     var217.setCrtTiersRegroupe(var217.getTiers().getTiesigle());
                     var217.setCrtPdv(var217.getTiers().getTiepdv());
                     var217.setCrtSecteur(var217.getTiers().getTiesecteur());
                     var217.setCrtRegion(var217.getTiers().getTieregion());
                  }
               } else {
                  var217.setCrtNomTiers(var217.getTiers().getTieraisonsocialenom());
                  var217.setCrtTiersRegroupe(var217.getTiers().getTiesigle());
                  var217.setCrtPdv(var217.getTiers().getTiepdv());
                  var217.setCrtSecteur(var217.getTiers().getTiesecteur());
                  var217.setCrtRegion(var217.getTiers().getTieregion());
               }

               var212.modif(var217, var11);
               ++var215;
               if (var215 == 100) {
                  var11.flush();
                  var215 = 0;
               }
            }

            var216.commit();
         } catch (HibernateException var167) {
            if (var216 != null) {
               var216.rollback();
            }

            throw var167;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void purgeDoublonTracabiliteVentes() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("Purge doubons des tracabilités de ventes");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      new ArrayList();
      DocumentTraceVentesDao var4 = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
      new DocumentTraceVentes();
      new DocumentTraceVentes();
      this.var_info = "Chargement des tracabilités ventes....";
      Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTraceVentes");
      List var3 = var4.chargerLesDocumentsTrace(var7);
      if (var3.size() != 0) {
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();

            for(int var9 = 0; var9 < var3.size(); ++var9) {
               DocumentTraceVentes var6 = (DocumentTraceVentes)var3.get(var9);
               long var10 = var6.getDoctraId();
               int var12 = var6.getDoctraOrgType();
               int var13 = var6.getDoctraDstType();
               long var14 = var6.getDoctraOrgId();
               long var16 = var6.getDoctraDstId();
               this.var_info = "Tracabilite " + ((DocumentTraceVentes)var3.get(var9)).getDoctraId() + " Numero " + var9 + ", pour un total de " + var3.size() + " total ";
               if (var9 != 0) {
                  double var18 = (double)var3.size();
                  double var20 = var2.myRound(var18 / (double)var9, 4);
                  double var22 = var2.myRound(100.0D / var20, 2);
                  this.var_currentValue = (int)var22;
               }

               for(int var29 = 0; var29 < var3.size(); ++var29) {
                  DocumentTraceVentes var5 = (DocumentTraceVentes)var3.get(var29);
                  if (var10 != var5.getDoctraId() && var12 == var5.getDoctraOrgType() && var13 == var5.getDoctraDstType() && var14 == var5.getDoctraOrgId() && var16 == var5.getDoctraDstId()) {
                     var4.delete(var5, var7);
                     var3.remove(var5);
                  }
               }
            }

            var8.commit();
         } catch (HibernateException var27) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var27;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void famillesDocProduitVtes() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("famille Doc Produit Vtes");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      new ArrayList();
      ProduitsVtesDao var4 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var6 = null;

      try {
         var6 = var5.beginTransaction();
         List var3 = var4.selectAllProduits(var5);
         if (var3.size() != 0) {
            for(int var7 = 0; var7 < var3.size(); ++var7) {
               new Produits();
               Produits var8 = (Produits)var3.get(var7);
               this.var_info = "Produit " + ((Produits)var3.get(var7)).getProCode() + " Numero " + var7 + ", pour un total de " + var3.size() + " total ";
               if (var7 != 0) {
                  double var9 = (double)var3.size();
                  double var11 = var2.myRound(var9 / (double)var7, 4);
                  double var13 = var2.myRound(100.0D / var11, 2);
                  this.var_currentValue = (int)var13;
               }

               String var33 = var8.getProCode();
               String var10 = var8.getProVteCode();
               new ArrayList();
               DevisLigneVentesDao var12 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
               String var35 = "dvsligCode = '" + var33 + "'";
               List var34 = var12.rechercheDevisRequete(var35, var5);
               if (var34.size() != 0) {
                  new DevisLigneVentes();

                  for(int var15 = 0; var15 < var34.size(); ++var15) {
                     DevisLigneVentes var14 = (DevisLigneVentes)var34.get(var15);
                     if (!var14.getDvsligFamille().equals(var10)) {
                        var14.setDvsligFamille(var10);
                        var12.modifLigne(var14, var5);
                     }
                  }
               }

               new ArrayList();
               CommandeLigneVentesDao var37 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var35 = "bcmligCode = '" + var33 + "'";
               List var36 = var37.rechercheCommandeRequete(var35, var5);
               if (var36.size() != 0) {
                  new CommandeLigneVentes();

                  for(int var17 = 0; var17 < var36.size(); ++var17) {
                     CommandeLigneVentes var16 = (CommandeLigneVentes)var36.get(var17);
                     if (!var16.getBcmligFamille().equals(var10)) {
                        var16.setBcmligFamille(var10);
                        var37.modifLigne(var16, var5);
                     }
                  }
               }

               new ArrayList();
               LivraisonLigneVentesDao var39 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var35 = "blvligCode = '" + var33 + "'";
               List var38 = var39.rechercheLivraisonRequete(var35, var5);
               if (var38.size() != 0) {
                  new LivraisonLigneVentes();

                  for(int var19 = 0; var19 < var38.size(); ++var19) {
                     LivraisonLigneVentes var18 = (LivraisonLigneVentes)var38.get(var19);
                     if (!var18.getBlvligFamille().equals(var10)) {
                        var18.setBlvligFamille(var10);
                        var39.modif(var18, var5);
                     }
                  }
               }

               new ArrayList();
               RetourLigneVentesDao var41 = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var35 = "brtligCode = '" + var33 + "'";
               List var40 = var41.rechercheRetourRequete(var35, var5);
               if (var40.size() != 0) {
                  new RetourLigneVentes();

                  for(int var21 = 0; var21 < var40.size(); ++var21) {
                     RetourLigneVentes var20 = (RetourLigneVentes)var40.get(var21);
                     if (!var20.getBrtligFamille().equals(var10)) {
                        var20.setBrtligFamille(var10);
                        var41.modifLigne(var20, var5);
                     }
                  }
               }

               new ArrayList();
               FactureLigneVentesDao var43 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var35 = "facligCode = '" + var33 + "'";
               List var42 = var43.rechercheFactureRequete(var35, var5);
               if (var42.size() != 0) {
                  new FactureLigneVentes();

                  for(int var23 = 0; var23 < var42.size(); ++var23) {
                     FactureLigneVentes var22 = (FactureLigneVentes)var42.get(var23);
                     if (!var22.getFacligFamille().equals(var10)) {
                        var22.setFacligFamille(var10);
                        var43.modifLigne(var22, var5);
                     }
                  }
               }

               new ArrayList();
               AvoirLigneVentesDao var45 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var35 = "avrligCode = '" + var33 + "'";
               List var44 = var45.rechercheAvoirRequete(var35, var5);
               if (var44.size() != 0) {
                  new AvoirLigneVentes();

                  for(int var25 = 0; var25 < var44.size(); ++var25) {
                     AvoirLigneVentes var24 = (AvoirLigneVentes)var44.get(var25);
                     if (!var24.getAvrligFamille().equals(var10)) {
                        var24.setAvrligFamille(var10);
                        var45.modifLigne(var24, var5);
                     }
                  }
               }

               new ArrayList();
               NoteDebitLigneVentesDao var47 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var35 = "ndbligCode = '" + var33 + "'";
               List var46 = var47.rechercheNoteDebitRequete(var35, var5);
               if (var46.size() != 0) {
                  new NoteDebitLigneVentes();

                  for(int var27 = 0; var27 < var46.size(); ++var27) {
                     NoteDebitLigneVentes var26 = (NoteDebitLigneVentes)var46.get(var27);
                     if (!var26.getNdbligFamille().equals(var10)) {
                        var26.setNdbligFamille(var10);
                        var47.modifLigne(var26, var5);
                     }
                  }
               }

               var5.flush();
            }
         }

         var6.commit();
      } catch (HibernateException var31) {
         if (var6 != null) {
            var6.rollback();
         }

         throw var31;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculTVADCLRNFA() throws HibernateException, NamingException, IOException, SAXException, JDOMException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("famille TVA et /ou CSS Devis, BC, BL, facture, note débit, avoir");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      LireLesoptionsVentes var5 = new LireLesoptionsVentes();
      var5.setStrId(this.structureLog.getStrid());
      this.optionVentes = new OptionVentes();
      this.optionVentes = var5.lancer();
      new ExercicesVentes();
      ExercicesVentes var6 = this.exercicesVentesDao.recupererLastExo(var4);
      Transaction var7 = null;

      try {
         var7 = var4.beginTransaction();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         String var8 = var3.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         String var9 = var3.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         String var10 = "";
         this.var_info = "Recalcul TVA/CSS des devis...";
         new DevisEnteteVentes();
         new ArrayList();
         DevisEnteteVentesDao var13 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         FormDevisVentes var14 = new FormDevisVentes();
         var14.setutilInitHibernate(this.utilInitHibernate);
         var14.setBaseLog(this.baseLog);
         var14.setStructureLog(this.structureLog);
         var14.setUsersLog(this.usersLog);
         var14.InstancesDaoUtilses();
         var14.setNature(21);
         var14.setExercicesVentes(var6);
         var14.setLastExoVentes(var6);
         var14.setOptionsVentes(this.optionVentes);
         var14.configVentes();
         var10 = "dvsDate>='" + var8 + "' and dvsDate<='" + var9 + "'";
         List var12 = var13.rechercheDevisRequete(var10, var4);
         double var20;
         if (var12.size() != 0) {
            for(int var15 = 0; var15 < var12.size(); ++var15) {
               DevisEnteteVentes var11 = (DevisEnteteVentes)var12.get(var15);
               if (var15 != 0) {
                  double var16 = (double)var12.size();
                  double var18 = var2.myRound(var16 / (double)var15, 4);
                  var20 = var2.myRound(100.0D / var18, 2);
                  this.var_currentValue = (int)var20;
               }

               var14.recalculTva(var11, var4);
            }

            var4.flush();
         }

         this.var_info = "Recalcul TVA/CSS des bons de commande...";
         this.var_currentValue = 0;
         new CommandeEnteteVentes();
         new ArrayList();
         CommandeEnteteVentesDao var17 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         FormCommandeVentes var53 = new FormCommandeVentes();
         var53.setutilInitHibernate(this.utilInitHibernate);
         var53.setBaseLog(this.baseLog);
         var53.setStructureLog(this.structureLog);
         var53.setUsersLog(this.usersLog);
         var53.InstancesDaoUtilses();
         var53.setNature(22);
         var53.setExercicesVentes(var6);
         var53.setLastExoVentes(var6);
         var53.setOptionsVentes(this.optionVentes);
         var53.configVentes();
         var10 = "bcmDate>='" + var8 + "' and bcmDate<='" + var9 + "'";
         List var52 = var17.rechercheCommandeRequete(var10, var4);
         double var24;
         if (var52.size() != 0) {
            for(int var19 = 0; var19 < var52.size(); ++var19) {
               CommandeEnteteVentes var51 = (CommandeEnteteVentes)var52.get(var19);
               if (var19 != 0) {
                  var20 = (double)var52.size();
                  double var22 = var2.myRound(var20 / (double)var19, 4);
                  var24 = var2.myRound(100.0D / var22, 2);
                  this.var_currentValue = (int)var24;
               }

               var53.recalculTva(var51, var4);
            }

            var4.flush();
         }

         this.var_info = "Recalcul TVA/CSS des bons de livraison...";
         this.var_currentValue = 0;
         new LivraisonEnteteVentes();
         new ArrayList();
         LivraisonEnteteVentesDao var21 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         FormLivraisonVentes var56 = new FormLivraisonVentes();
         var56.setutilInitHibernate(this.utilInitHibernate);
         var56.setBaseLog(this.baseLog);
         var56.setStructureLog(this.structureLog);
         var56.setUsersLog(this.usersLog);
         var56.InstancesDaoUtilses();
         var56.setNature(23);
         var56.setExercicesVentes(var6);
         var56.setLastExoVentes(var6);
         var56.setOptionsVentes(this.optionVentes);
         var56.configVentes();
         var10 = "blvDate>='" + var8 + "' and blvDate<='" + var9 + "'";
         List var55 = var21.rechercheLivraisonRequete(var10, var4);
         double var28;
         if (var55.size() != 0) {
            for(int var23 = 0; var23 < var55.size(); ++var23) {
               LivraisonEnteteVentes var54 = (LivraisonEnteteVentes)var55.get(var23);
               if (var23 != 0) {
                  var24 = (double)var55.size();
                  double var26 = var2.myRound(var24 / (double)var23, 4);
                  var28 = var2.myRound(100.0D / var26, 2);
                  this.var_currentValue = (int)var28;
               }

               var56.recalculTva(var54, var4);
            }

            var4.flush();
         }

         this.var_info = "Recalcul TVA/CSS des bons de retour...";
         this.var_currentValue = 0;
         new RetourEnteteVentes();
         new ArrayList();
         RetourEnteteVentesDao var25 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         FormRetourVentes var59 = new FormRetourVentes();
         var59.setutilInitHibernate(this.utilInitHibernate);
         var59.setBaseLog(this.baseLog);
         var59.setStructureLog(this.structureLog);
         var59.setUsersLog(this.usersLog);
         var59.InstancesDaoUtilses();
         var59.setNature(24);
         var59.setExercicesVentes(var6);
         var59.setLastExoVentes(var6);
         var59.setOptionsVentes(this.optionVentes);
         var59.configVentes();
         var10 = "brtDate>='" + var8 + "' and brtDate<='" + var9 + "'";
         List var58 = var25.rechercheRetourRequete(var10, var4);
         double var32;
         if (var58.size() != 0) {
            for(int var27 = 0; var27 < var58.size(); ++var27) {
               RetourEnteteVentes var57 = (RetourEnteteVentes)var58.get(var27);
               if (var27 != 0) {
                  var28 = (double)var58.size();
                  double var30 = var2.myRound(var28 / (double)var27, 4);
                  var32 = var2.myRound(100.0D / var30, 2);
                  this.var_currentValue = (int)var32;
               }

               var59.recalculTva(var57, var4);
            }

            var4.flush();
         }

         this.var_info = "Recalcul TVA/CSS des factures...";
         this.var_currentValue = 0;
         new FactureEnteteVentes();
         new ArrayList();
         FactureEnteteVentesDao var29 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         FormFactureVentes var62 = new FormFactureVentes();
         var62.setutilInitHibernate(this.utilInitHibernate);
         var62.setBaseLog(this.baseLog);
         var62.setStructureLog(this.structureLog);
         var62.setUsersLog(this.usersLog);
         var62.InstancesDaoUtilses();
         var62.setNature(25);
         var62.setExercicesVentes(var6);
         var62.setLastExoVentes(var6);
         var62.setOptionsVentes(this.optionVentes);
         var62.configVentes();
         var10 = "facDate>='" + var8 + "' and facDate<='" + var9 + "'";
         List var61 = var29.rechercheFactureRequete(var10, var4);
         double var36;
         if (var61.size() != 0) {
            for(int var31 = 0; var31 < var61.size(); ++var31) {
               FactureEnteteVentes var60 = (FactureEnteteVentes)var61.get(var31);
               if (var31 != 0) {
                  var32 = (double)var61.size();
                  double var34 = var2.myRound(var32 / (double)var31, 4);
                  var36 = var2.myRound(100.0D / var34, 2);
                  this.var_currentValue = (int)var36;
               }

               var62.recalculTva(var60, var4);
            }

            var4.flush();
         }

         this.var_info = "Recalcul TVA/CSS des notes de débit...";
         this.var_currentValue = 0;
         new NoteDebitEnteteVentes();
         new ArrayList();
         NoteDebitEnteteVentesDao var33 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         FormNoteDebitVentes var65 = new FormNoteDebitVentes();
         var65.setutilInitHibernate(this.utilInitHibernate);
         var65.setBaseLog(this.baseLog);
         var65.setStructureLog(this.structureLog);
         var65.setUsersLog(this.usersLog);
         var65.InstancesDaoUtilses();
         var65.setNature(27);
         var65.setExercicesVentes(var6);
         var65.setLastExoVentes(var6);
         var65.setOptionsVentes(this.optionVentes);
         var65.configVentes();
         var10 = "ndbDate>='" + var8 + "' and ndbDate<='" + var9 + "'";
         List var64 = var33.rechercheNoteDebitRequete(var10, var4);
         double var40;
         if (var64.size() != 0) {
            for(int var35 = 0; var35 < var64.size(); ++var35) {
               NoteDebitEnteteVentes var63 = (NoteDebitEnteteVentes)var64.get(var35);
               if (var35 != 0) {
                  var36 = (double)var64.size();
                  double var38 = var2.myRound(var36 / (double)var35, 4);
                  var40 = var2.myRound(100.0D / var38, 2);
                  this.var_currentValue = (int)var40;
               }

               var65.recalculTva(var63, var4);
            }

            var4.flush();
         }

         this.var_info = "Recalcul TVA/CSS des avoirs...";
         this.var_currentValue = 0;
         new AvoirEnteteVentes();
         new ArrayList();
         AvoirEnteteVentesDao var37 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         FormAvoirVentes var68 = new FormAvoirVentes();
         var68.setutilInitHibernate(this.utilInitHibernate);
         var68.setBaseLog(this.baseLog);
         var68.setStructureLog(this.structureLog);
         var68.setUsersLog(this.usersLog);
         var68.InstancesDaoUtilses();
         var68.setNature(26);
         var68.setExercicesVentes(var6);
         var68.setLastExoVentes(var6);
         var68.setOptionsVentes(this.optionVentes);
         var68.configVentes();
         var10 = "avrDate>='" + var8 + "' and avrDate<='" + var9 + "'";
         List var67 = var37.rechercheAvoirRequete(var10, var4);
         if (var67.size() != 0) {
            for(int var39 = 0; var39 < var67.size(); ++var39) {
               AvoirEnteteVentes var66 = (AvoirEnteteVentes)var67.get(var39);
               if (var39 != 0) {
                  var40 = (double)var67.size();
                  double var42 = var2.myRound(var40 / (double)var39, 4);
                  double var44 = var2.myRound(100.0D / var42, 2);
                  this.var_currentValue = (int)var44;
               }

               var68.recalculTva(var66, var4);
            }

            var4.flush();
         }

         var7.commit();
      } catch (HibernateException var49) {
         if (var7 != null) {
            var7.rollback();
         }

         throw var49;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculDerniereDatesVtes() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul dernières dates Devis, BC, BL, facture, note débit, avoir");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         UtilNombre var4 = new UtilNombre();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         this.var_info = "Chargement des clients...";
         String var5 = "";
         new Tiers();
         new ArrayList();
         new ArrayList();
         ReglementsDao var9 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         Object var10 = new ArrayList();
         DevisEnteteVentesDao var11 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         CommandeEnteteVentesDao var13 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         LivraisonEnteteVentesDao var15 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         RetourEnteteVentesDao var17 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         FactureEnteteVentesDao var19 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         NoteDebitEnteteVentesDao var21 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         AvoirEnteteVentesDao var23 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         Date var24 = null;
         Date var25 = null;
         Date var26 = null;
         Date var27 = null;
         Date var28 = null;
         Date var29 = null;
         Date var30 = null;
         Date var31 = null;
         int var32 = 0;
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         var5 = "from Tiers where (tietype=2 or tietype=3)";
         List var7 = this.tiersDao.listeTiers(var5, var2);
         if (var7.size() != 0) {
            for(int var33 = 0; var33 < var7.size(); ++var33) {
               Tiers var6 = (Tiers)var7.get(var33);
               ++var32;
               if (var33 != 0) {
                  double var34 = (double)((List)var10).size();
                  double var36 = var4.myRound(var34 / (double)var33, 4);
                  double var38 = var4.myRound(100.0D / var36, 2);
                  this.var_currentValue = (int)var38;
               }

               this.var_info = "Mise a jour de " + var6.getTieraisonsocialenom() + " Numero " + var33 + ", pour un total de " + var7.size() + " total ";
               var24 = null;
               var25 = null;
               var26 = null;
               var27 = null;
               var28 = null;
               var29 = null;
               var30 = null;
               var31 = null;
               var5 = "rglIdTiers=" + var6.getTieid() + " and rglCategorie=20 order by rglDateReg desc";
               List var8 = var9.rechercheReglementsRequete(var5, var2);
               if (var8.size() != 0) {
                  var24 = ((Reglements)var8.get(0)).getRglDateReg();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by dvsDate desc";
               var10 = var11.rechercheDevisRequete(var5, var2);
               if (((List)var10).size() != 0) {
                  var25 = ((DevisEnteteVentes)((List)var10).get(0)).getDvsDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by bcmDate desc";
               List var12 = var13.rechercheCommandeRequete(var5, var2);
               if (var12.size() != 0) {
                  var26 = ((CommandeEnteteVentes)var12.get(0)).getBcmDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by blvDate desc";
               List var14 = var15.rechercheLivraisonRequete(var5, var2);
               if (var14.size() != 0) {
                  var27 = ((LivraisonEnteteVentes)var14.get(0)).getBlvDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by brtDate desc";
               List var16 = var17.rechercheRetourRequete(var5, var2);
               if (var16.size() != 0) {
                  var28 = ((RetourEnteteVentes)var16.get(0)).getBrtDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by facDate desc";
               List var18 = var19.rechercheFactureRequete(var5, var2);
               if (var18.size() != 0) {
                  var29 = ((FactureEnteteVentes)var18.get(0)).getFacDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by ndbDate desc";
               List var20 = var21.rechercheNoteDebitRequete(var5, var2);
               if (var20.size() != 0) {
                  var30 = ((NoteDebitEnteteVentes)var20.get(0)).getNdbDate();
               }

               var5 = "tiers.tieid=" + var6.getTieid() + " order by avrDate desc";
               List var22 = var23.rechercheAvoirRequete(var5, var2);
               if (var22.size() != 0) {
                  var31 = ((AvoirEnteteVentes)var22.get(0)).getAvrDate();
               }

               var6.setTieDteRegement(var24);
               var6.setTieDteDocument1(var25);
               var6.setTieDteDocument2(var26);
               var6.setTieDteDocument3(var27);
               var6.setTieDteDocument4(var28);
               var6.setTieDteDocument5(var29);
               var6.setTieDteDocument6(var30);
               var6.setTieDteDocument7(var31);
               this.tiersDao.modif(var6, var2);
               if (var32 == 200) {
                  var2.flush();
                  var32 = 0;
               }
            }
         }

         var3.commit();
      } catch (HibernateException var43) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var43;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculDernierReglementCommande() throws HibernateException, NamingException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("recalcul Dernier Reglement commande");
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         UtilDate var2 = new UtilDate();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new ArrayList();
            CommandeEnteteVentesDao var6 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            ReglementsDao var7 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
            String var8 = var2.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
            String var9 = var2.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
            List var5 = var6.rechercheDejaPayer(var8, var9, var3);
            if (var5.size() != 0) {
               for(int var10 = 0; var10 < var5.size(); ++var10) {
                  new CommandeEnteteVentes();
                  CommandeEnteteVentes var11 = (CommandeEnteteVentes)var5.get(var10);
                  new ArrayList();
                  List var12 = var7.reglementDocument(var11.getBcmId(), 22, var3);
                  if (var12.size() != 0) {
                     int var13 = var12.size() - 1;
                     var11.setBcmDateLastReg(((Reglements)var12.get(var13)).getRglDateReg());
                  } else {
                     var11.setBcmDateLastReg((Date)null);
                  }

                  var6.modif(var11, var3);
               }

               var4.commit();
            }
         } catch (HibernateException var17) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void enleveStockSansAchat() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("enleve du stock les produits sans famille achat");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des produits sans famille d'achat...";
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         new ArrayList();
         ProduitsVtesDao var6 = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
         List var5 = var6.selectAllProduitsSansAchat(var3);
         new Produits();
         new ArrayList();
         ProduitsDepotDao var9 = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
         new ProduitsDepot();
         if (var5.size() != 0) {
            for(int var11 = 0; var11 < var5.size(); ++var11) {
               Produits var7 = (Produits)var5.get(var11);
               this.var_info = "Produit " + var7.getProLibClient() + " Numero " + var11 + ", pour un total de " + var5.size() + " total ";
               if (var11 != 0) {
                  double var12 = (double)var5.size();
                  double var14 = var2.myRound(var12 / (double)var11, 4);
                  double var16 = var2.myRound(100.0D / var14, 2);
                  this.var_currentValue = (int)var16;
               }

               List var8 = var9.selectProdDepByprod(var7, var3);
               if (var8.size() != 0) {
                  for(int var23 = 0; var23 < var8.size(); ++var23) {
                     ProduitsDepot var10 = (ProduitsDepot)var8.get(var23);
                     var9.delete(var10, var3);
                  }
               }

               var7.setProStock(0);
               var6.modifProduit(var7, var3);
            }

            var4.commit();
         }
      } catch (HibernateException var21) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var21;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void livraisonBllivres() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("livraison des BL livrés");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des BL non livrés...";
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEntete");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         new ArrayList();
         LivraisonEnteteVentesDao var6 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         String var7 = " (blvLivreeEtat = 0 or  blvLivreeEtat = 1)";
         List var5 = var6.rechercheLivraisonRequete(var7, var3);
         new LivraisonEnteteVentes();
         new ArrayList();
         LivraisonLigneVentesDao var10 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         new LivraisonLigneVentes();
         new ArrayList();
         LivraisonLivreeVentesDao var13 = new LivraisonLivreeVentesDao(this.baseLog, this.utilInitHibernate);
         new LivraisonLivreeVentes();
         if (var5.size() != 0) {
            for(int var15 = 0; var15 < var5.size(); ++var15) {
               LivraisonEnteteVentes var8 = (LivraisonEnteteVentes)var5.get(var15);
               Date var16 = var8.getBlvDate();
               long var17 = var8.getBlvId();
               this.var_info = "BL N° " + var8.getBlvNum() + " Numero " + var15 + ", pour un total de " + var5.size() + " total ";
               if (var15 != 0) {
                  double var19 = (double)var5.size();
                  double var21 = var2.myRound(var19 / (double)var15, 4);
                  double var23 = var2.myRound(100.0D / var21, 2);
                  this.var_currentValue = (int)var23;
               }

               List var9 = var10.chargerLesLignes(var8, var3);
               if (var9.size() != 0) {
                  for(int var32 = 0; var32 < var9.size(); ++var32) {
                     LivraisonLigneVentes var11 = (LivraisonLigneVentes)var9.get(var32);
                     float var20 = 0.0F;
                     List var12 = var13.chargerLesLivraisons(var11, var3);
                     if (var12.size() != 0) {
                        for(int var30 = 0; var30 < var12.size(); ++var30) {
                           var20 += ((LivraisonLivreeVentes)var12.get(var30)).getBlvlivQteLivree();
                        }
                     }

                     if (var11.getBlvligQte() > var20) {
                        float var31 = var11.getBlvligQte() - var20;
                        if (var31 != 0.0F) {
                           LivraisonLivreeVentes var14 = new LivraisonLivreeVentes();
                           var14.setLivraisonLigneVentes(var11);
                           var14.setBlvlivCode(var11.getBlvligCode());
                           var14.setBlvlivDate(var16);
                           var14.setBlvlivDepot(var11.getBlvligDepot());
                           var14.setBlvlivIdBl(var17);
                           var14.setBlvlivQteLivree(var31);
                           var14.setBlvlivQteUtilLivree(var31);
                           var13.insertLigne(var14, var3);
                        }
                     }
                  }
               }

               var8.setBlvLivreeEtat(2);
               var6.modif(var8, var3);
            }

            var4.commit();
         }
      } catch (HibernateException var28) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var28;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void suppressionDocumentVente() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("suppression des documents ventes");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Suppression des documents de vente.";
      Utilitaires_Ventes var3 = new Utilitaires_Ventes();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (this.sup_devis) {
            ++this.var_currentValue;
            this.var_info = "Suppression des DEVIS en cours....";
            var3.suppressionDevis(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bc) {
            ++this.var_currentValue;
            this.var_info = "Suppression des BC en cours....";
            var3.suppressionBc(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bl) {
            ++this.var_currentValue;
            this.var_info = "Suppression des BL en cours....";
            var3.suppressionBl(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_retour) {
            ++this.var_currentValue;
            this.var_info = "Suppression des RETOURS en cours....";
            var3.suppressionRetour(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_facture) {
            ++this.var_currentValue;
            this.var_info = "Suppression des FACTURES en cours....";
            var3.suppressionFacture(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_factureInterne) {
            ++this.var_currentValue;
            this.var_info = "Suppression des FACTURES INTERNES en cours....";
            var3.suppressionFactureInterne(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_noteDebit) {
            this.var_currentValue = 7;
            this.var_info = "Suppression des NOTES DE DEBIT en cours....";
            var3.suppressionNoteDebit(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_avoir) {
            ++this.var_currentValue;
            this.var_info = "Suppression des AVOIRS en cours....";
            var3.suppressionAvoir(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_chargement) {
            ++this.var_currentValue;
            this.var_info = "Suppression des CHARGEMENTS en cours....";
            var3.suppressionChargement(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_ticket) {
            ++this.var_currentValue;
            this.var_info = "Suppression des TICKETS en cours....";
            var3.suppressionTicket(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void factureZeroRecupBlDocumentVente() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("si BL ttc <> Facture ttc et factures non lettrées alors récuperer lignes BL");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement bl TTC <> facture TTC";
      Utilitaires_Ventes var3 = new Utilitaires_Ventes();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         new ArrayList();
         Ecritures var7 = new Ecritures();
         EcrituresDao var8 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         EcrituresAnalytiquesDao var9 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         new FactureEnteteVentes();
         FactureEnteteVentesDao var11 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         UtilDate var12 = new UtilDate();
         String var13 = var12.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
         String var14 = var12.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
         List var6 = var11.rechercheFactureByDate(var13, var14, var4);
         LivraisonLigneVentesDao var15 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
         FactureLigneVentesDao var16 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
         int var17 = 0;

         while(true) {
            if (var17 >= var6.size()) {
               var5.commit();
               break;
            }

            FactureEnteteVentes var10 = (FactureEnteteVentes)var6.get(var17);
            if (var10.getFacNumBl() != null && !var10.getFacNumBl().isEmpty()) {
               this.var_info = "Facture N° " + var10.getFacNum() + " Numero " + var17 + ", pour un total de " + var6.size() + " total ";
               if (var17 != 0) {
                  double var18 = (double)var6.size();
                  double var20 = var2.myRound(var18 / (double)var17, 4);
                  double var22 = var2.myRound(100.0D / var20, 2);
                  this.var_currentValue = (int)var22;
               }

               var3.fatureZeroLigneBl(var10, var11, var15, var16, var8, var7, var9, var4);
            }

            ++var17;
         }
      } catch (HibernateException var27) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var27;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void connexionAyantDroitsAssures() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("connexion des ayants-droits avec les assurés");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         UtilNombre var4 = new UtilNombre();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         this.var_info = "Chargement des patients...";
         new Patients();
         new ArrayList();
         new ArrayList();
         this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
         int var8 = 0;
         List var6 = this.patientsDao.chargerListPatients("from Patients where patDossier not like '%-%'", var2);
         List var7 = this.patientsDao.chargerListPatients("from Patients where patDossier like '%-%'", var2);
         if (var7.size() != 0) {
            for(int var9 = 0; var9 < var7.size(); ++var9) {
               Patients var5 = (Patients)var7.get(var9);
               String[] var10 = var5.getPatDossier().split("-");
               ++var8;
               if (var9 != 0) {
                  double var11 = (double)var7.size();
                  double var13 = var4.myRound(var11 / (double)var9, 4);
                  double var15 = var4.myRound(100.0D / var13, 2);
                  this.var_currentValue = (int)var15;
               }

               this.var_info = "Mise a jour de " + var5.getPatNom() + " Numero " + var9 + ", pour un total de " + var7.size() + " total ";
               if (var6.size() != 0) {
                  long var22 = 0L;

                  for(int var23 = 0; var23 < var6.size(); ++var23) {
                     if (((Patients)var6.get(var23)).getPatDossier().equals(var10[0])) {
                        var22 = ((Patients)var6.get(var23)).getPatId();
                        break;
                     }
                  }

                  var5.setPatIdCouvertPar(var22);
                  this.patientsDao.modif(var5, var2);
               }

               if (var8 == 200) {
                  var2.flush();
                  var8 = 0;
               }
            }
         }

         var3.commit();
      } catch (HibernateException var20) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var20;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void majPatientsPec() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("maj patients avec prises en charge");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.setFlushMode(FlushMode.MANUAL);
         UtilNombre var4 = new UtilNombre();
         boolean var5 = false;
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         this.var_info = "Chargement des patients et des prises en charges...";
         new Patients();
         long var7 = 0L;
         new LinkedList();
         new LinkedList();
         LinkedList var11 = new LinkedList();
         new LinkedList();
         this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
         PatientPecDao var13 = new PatientPecDao(this.baseLog, this.utilInitHibernate);
         this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
         var11.clear();
         List var28 = var13.chargerLesPatientsPec(var2);
         if (var28.size() != 0) {
            new PatientPec();
            new Tiers();

            for(int var16 = 0; var16 < var28.size(); ++var16) {
               PatientPec var14 = (PatientPec)var28.get(var16);
               Tiers var15 = var14.getTiers();
               if (var16 != 0) {
                  double var17 = (double)var28.size();
                  double var19 = var4.myRound(var17 / (double)var16, 4);
                  double var21 = var4.myRound(100.0D / var19, 2);
                  this.var_currentValue = (int)var21;
               }

               this.var_info = "Mise a jour de " + var14.getPatient().getPatNom() + " Numero " + var16 + ", pour un total de " + var28.size() + " total ";
               boolean var29 = false;
               if (var15 != null) {
                  if (var14.getPatpecType() == null || var14.getPatpecType().isEmpty()) {
                     var14.setPatpecType(var15.getTiecategorie());
                     var29 = true;
                  }

                  if (var29) {
                     var13.modif(var14, var2);
                     var2.flush();
                  }
               }
            }
         }

         var3.commit();
      } catch (HibernateException var26) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var26;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void fusionPatients() throws NamingException, HibernateException, ParseException {
      this.patientsOrigine = this.patientsDao.selectPatientsD(this.idOrigine);
      if (this.patientsOrigine != null) {
         this.patientsDestinataire = this.patientsDao.selectPatientsD(this.idDestinataire);
         if (this.patientsDestinataire != null) {
            if (this.patientsOrigine.getPatId() != this.patientsDestinataire.getPatId()) {
               this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
               Espion var1 = new Espion();
               var1.setEspdtecreat(new Date());
               var1.setUsers(this.usersLog);
               var1.setEspaction("fusion du patient " + this.patientsOrigine.getPatId() + " " + this.patientsDestinataire.getPatronyme() + " vers le patient " + this.patientsDestinataire.getPatId() + " " + this.patientsDestinataire.getPatronyme());
               var1.setEsptype(0);
               this.espionDao.mAJEspion(var1);
               long var2 = this.patientsOrigine.getPatId();
               Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementMed");
               Transaction var5 = null;

               try {
                  var5 = var4.beginTransaction();
                  new ArrayList();
                  ConsultationEnteteGeneDao var7 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
                  List var6 = var7.chargerLesMvtsPatients(this.patientsOrigine, var4);
                  if (var6.size() != 0) {
                     new ConsultationEnteteGene();

                     for(int var9 = 0; var9 < var6.size(); ++var9) {
                        ConsultationEnteteGene var8 = (ConsultationEnteteGene)var6.get(var9);
                        var8.setPatients(this.patientsDestinataire);
                        var8.setCsgNomPatient(this.patientsDestinataire.getPatronyme());
                        var8.setCsgIdPatient(this.patientsDestinataire.getPatId());
                        var7.modif(var8, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  LaboratoireEnteteDao var39 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
                  List var38 = var39.chargerLesMvtsPatients(this.patientsOrigine, var4);
                  if (var38.size() != 0) {
                     new LaboratoireEntete();

                     for(int var11 = 0; var11 < var38.size(); ++var11) {
                        LaboratoireEntete var10 = (LaboratoireEntete)var38.get(var11);
                        var10.setPatients(this.patientsDestinataire);
                        var10.setLabNomPatient(this.patientsDestinataire.getPatronyme());
                        var10.setLabIdPatient(this.patientsDestinataire.getPatId());
                        var39.modif(var10, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  PharmacieEnteteDao var41 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
                  List var40 = var41.chargerLesMvtsPatients(this.patientsOrigine, var4);
                  if (var40.size() != 0) {
                     new PharmacieEntete();

                     for(int var13 = 0; var13 < var40.size(); ++var13) {
                        PharmacieEntete var12 = (PharmacieEntete)var40.get(var13);
                        var12.setPatients(this.patientsDestinataire);
                        var12.setPhaNomPatient(this.patientsDestinataire.getPatronyme());
                        var12.setPhaIdPatient(this.patientsDestinataire.getPatId());
                        var41.modif(var12, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  HospitalisationEnteteDao var43 = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
                  List var42 = var43.chargerLesMvtsPatients(this.patientsOrigine, var4);
                  if (var42.size() != 0) {
                     new HospitalisationEntete();

                     for(int var15 = 0; var15 < var42.size(); ++var15) {
                        HospitalisationEntete var14 = (HospitalisationEntete)var42.get(var15);
                        var14.setPatients(this.patientsDestinataire);
                        var14.setHosNomPatient(this.patientsDestinataire.getPatronyme());
                        var14.setHosIdPatient(this.patientsDestinataire.getPatId());
                        var43.modif(var14, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  FactureLigneMedicalDao var45 = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
                  List var44 = var45.chargerLesMvtsPatients(this.patientsOrigine.getPatDossier(), var4);
                  if (var44.size() != 0) {
                     new FactureLigneMedical();

                     for(int var17 = 0; var17 < var44.size(); ++var17) {
                        FactureLigneMedical var16 = (FactureLigneMedical)var44.get(var17);
                        var16.setFacligCivilite(this.patientsDestinataire.getPatCivilite());
                        var16.setFacligDossier(this.patientsDestinataire.getPatDossier());
                        var16.setFacligPrenom(this.patientsDestinataire.getPatPrenom());
                        var16.setFacligNom(this.patientsDestinataire.getPatNom());
                        var45.modifLigne(var16, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  BonEncaissementVenteDao var47 = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
                  List var46 = var47.rechercheByTiersPatient(this.patientsOrigine, var4);
                  if (var46.size() != 0) {
                     new BonEncaissementVente();

                     for(int var19 = 0; var19 < var46.size(); ++var19) {
                        BonEncaissementVente var18 = (BonEncaissementVente)var46.get(var19);
                        var18.setBonIdTiers(this.patientsDestinataire.getPatId());
                        var18.setBonNomTiers(this.patientsDestinataire.getPatronyme());
                        var47.ModifBon(var18, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  ReglementsDao var49 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
                  List var48 = var49.rechercheByTiersPatient(this.patientsOrigine, var4);
                  if (var48.size() != 0) {
                     new Reglements();

                     for(int var21 = 0; var21 < var48.size(); ++var21) {
                        Reglements var20 = (Reglements)var48.get(var21);
                        var20.setRglIdTiers(this.patientsDestinataire.getPatId());
                        var20.setRglNomTiers(this.patientsDestinataire.getPatronyme());
                        var49.modifierReg(var20, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  PatientAntDao var51 = new PatientAntDao(this.baseLog, this.utilInitHibernate);
                  List var50 = var51.chargerLesPatientsAntecedents(this.patientsOrigine, var4);
                  if (var50.size() != 0) {
                     new PatientAnt();

                     for(int var23 = 0; var23 < var50.size(); ++var23) {
                        PatientAnt var22 = (PatientAnt)var50.get(var23);
                        var22.setPatient(this.patientsDestinataire);
                        var51.modif(var22, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  PatientContactDao var53 = new PatientContactDao(this.baseLog, this.utilInitHibernate);
                  List var52 = var53.chargerLesPatientsContact(this.patientsOrigine, var4);
                  if (var52.size() != 0) {
                     new PatientContact();

                     for(int var25 = 0; var25 < var52.size(); ++var25) {
                        PatientContact var24 = (PatientContact)var52.get(var25);
                        var24.setPatient(this.patientsDestinataire);
                        var53.modif(var24, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  PatientLettreGarantieDao var55 = new PatientLettreGarantieDao(this.baseLog, this.utilInitHibernate);
                  List var54 = var55.chargerLesLettresByPatients(this.patientsOrigine, 9, 0, var4);
                  if (var54.size() != 0) {
                     new PatientLettreGarantie();

                     for(int var27 = 0; var27 < var54.size(); ++var27) {
                        PatientLettreGarantie var26 = (PatientLettreGarantie)var54.get(var27);
                        var26.setPatient(this.patientsDestinataire);
                        var55.modif(var26, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  List var56 = var55.chargerLesLettresByPatients(this.patientsOrigine, 9, 1, var4);
                  if (var56.size() != 0) {
                     new PatientLettreGarantie();

                     for(int var28 = 0; var28 < var56.size(); ++var28) {
                        PatientLettreGarantie var57 = (PatientLettreGarantie)var56.get(var28);
                        var57.setPatient(this.patientsDestinataire);
                        var55.modif(var57, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  PatientPecDao var59 = new PatientPecDao(this.baseLog, this.utilInitHibernate);
                  List var58 = var59.chargerLesPatientsPec(this.patientsOrigine, 9, var4);
                  if (var58.size() != 0) {
                     new PatientPec();

                     for(int var30 = 0; var30 < var58.size(); ++var30) {
                        PatientPec var29 = (PatientPec)var58.get(var30);
                        var29.setPatient(this.patientsDestinataire);
                        var59.modif(var29, var4);
                     }

                     var4.flush();
                  }

                  new ArrayList();
                  PatientProtDao var61 = new PatientProtDao(this.baseLog, this.utilInitHibernate);
                  List var60 = var61.chargerLesPatientsProtocles(this.patientsOrigine, var4);
                  if (var60.size() != 0) {
                     new PatientProt();

                     for(int var32 = 0; var32 < var60.size(); ++var32) {
                        PatientProt var31 = (PatientProt)var60.get(var32);
                        var31.setPatient(this.patientsDestinataire);
                        var61.modif(var31, var4);
                     }

                     var4.flush();
                  }

                  new Patients();
                  Patients var62 = this.patientsDao.selectPatientsD(var2, var4);
                  if (var62 != null) {
                     this.patientsDao.delete(var62, var4);
                  }

                  var5.commit();
               } catch (HibernateException var36) {
                  if (var5 != null) {
                     var5.rollback();
                  }

                  throw var36;
               } finally {
                  this.utilInitHibernate.closeSession();
               }

               this.lesPatientsOrigines.clear();
               this.lesPatientsDestinataires.clear();
               this.dataModelTiersOrigines.setWrappedData(this.lesPatientsOrigines);
               this.dataModelTiersDestinataires.setWrappedData(this.lesPatientsDestinataires);
            } else {
               this.var_showBarProg = false;
               this.formRecherche.setMessageTexte("Le patient d'origine doit être différent que celui de la destination");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         }
      }

      this.tiersOrigine = new Tiers();
      this.tiersDestinataire = new Tiers();
      this.idOrigine = 0L;
      this.genreOrigine = "";
      this.compteOrigine = "";
      this.idDestinataire = 0L;
      this.genreDestinataire = "";
      this.compteDestinataire = "";
   }

   public void selectionPatientsOrigine() throws HibernateException, NamingException {
      if (this.dataModelTiersOrigines.isRowAvailable()) {
         new Patients();
         Patients var1 = (Patients)this.dataModelTiersOrigines.getRowData();
         this.idOrigine = var1.getPatId();
         this.genreOrigine = var1.getPatCivilite();
         this.compteOrigine = var1.getPatDossier();
      }

   }

   public void selectionPatientsDestination() throws HibernateException, NamingException {
      if (this.dataModelTiersDestinataires.isRowAvailable()) {
         new Patients();
         Patients var1 = (Patients)this.dataModelTiersDestinataires.getRowData();
         this.idDestinataire = var1.getPatId();
         this.genreDestinataire = var1.getPatCivilite();
         this.compteDestinataire = var1.getPatDossier();
      }

   }

   public void chargerLesPatients() throws HibernateException, NamingException, ParseException {
      this.lesPatientsOrigines = new ArrayList();
      this.lesPatientsDestinataires = new ArrayList();
      this.dataModelTiersOrigines = new ListDataModel();
      this.dataModelTiersDestinataires = new ListDataModel();
      this.dataModelTiersOrigines.setWrappedData(this.lesPatientsOrigines);
      this.dataModelTiersDestinataires.setWrappedData(this.lesPatientsDestinataires);
      this.patientsOrigine = new Patients();
      this.patientsDestinataire = new Patients();
      this.idOrigine = 0L;
      this.genreOrigine = "";
      this.compteOrigine = "";
      this.idDestinataire = 0L;
      this.genreDestinataire = "";
      this.compteDestinataire = "";
      this.patientOrigine = "";
      this.patientDestination = "";
      this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesPatientsOrigine() throws HibernateException, NamingException, ParseException {
      this.lesPatientsOrigines.clear();
      if (this.patientOrigine != null && !this.patientOrigine.isEmpty()) {
         this.lesPatientsOrigines = this.patientsDao.chargerListPatientsLight("from Patients where patDossier like '%" + this.patientOrigine + "%' or patNom like '%" + this.patientOrigine + "%'", (Session)null);
      }

      this.dataModelTiersOrigines.setWrappedData(this.lesPatientsOrigines);
      this.lesPatientsDestinataires = this.lesPatientsOrigines;
      this.dataModelTiersDestinataires.setWrappedData(this.lesPatientsDestinataires);
      this.patientsOrigine = new Patients();
      this.genreOrigine = "";
      this.idOrigine = 0L;
      this.compteOrigine = "";
   }

   public void chargerLesPatientsDestination() throws HibernateException, NamingException, ParseException {
      this.lesPatientsDestinataires.clear();
      if (this.patientDestination != null && !this.patientDestination.isEmpty()) {
         this.lesPatientsDestinataires = this.patientsDao.chargerListPatientsLight("from Patients where patDossier like '%" + this.patientDestination + "%' or patNom like '%" + this.patientDestination + "%'", (Session)null);
      }

      this.dataModelTiersDestinataires.setWrappedData(this.lesPatientsDestinataires);
      this.patientsDestinataire = new Patients();
      this.genreDestinataire = "";
      this.idDestinataire = 0L;
      this.compteDestinataire = "";
   }

   public void suppressionDocumentMedicaux() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("suppression des documents medicaux");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Suppression des documents medicaux.";
      Utilitaires_Medical var3 = new Utilitaires_Medical();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (this.sup_devis) {
            ++this.var_currentValue;
            this.var_info = "Suppression des CONSULTATIONS en cours....";
            var3.suppressionConsultation(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bc) {
            ++this.var_currentValue;
            this.var_info = "Suppression des PHARMACIES en cours....";
            var3.suppressionPharmacie(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bl) {
            ++this.var_currentValue;
            this.var_info = "Suppression des LABORATOIRES en cours....";
            var3.suppressionLaboratoire(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_retour) {
            ++this.var_currentValue;
            this.var_info = "Suppression des HOSPTALISATIONS en cours....";
            var3.suppressionHospitalisation(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_facture) {
            ++this.var_currentValue;
            this.var_info = "Suppression des DEVIS en cours....";
            var3.suppressionDevisMedical(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_factureInterne) {
            ++this.var_currentValue;
            this.var_info = "Suppression des REFACTURATION TIERS en cours....";
            var3.suppressionReFacturation(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_noteDebit) {
            this.var_currentValue = 7;
            this.var_info = "Suppression des FACTURES EXTERNES en cours....";
            var3.suppressionFactureExterne(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculDocumentMedicaux() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des documents medicaux");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Recalcul des documents medicaux.";
      Utilitaires_Medical var3 = new Utilitaires_Medical();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (this.sup_devis) {
            ++this.var_currentValue;
            this.var_info = "Recalcul des CONSULTATIONS en cours....";
            var3.recalculConsultation(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bc) {
            ++this.var_currentValue;
            this.var_info = "Recalcul des PHARMACIES en cours....";
            var3.recalculPharmacie(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bl) {
            ++this.var_currentValue;
            this.var_info = "Recalcul des LABORATOIRES en cours....";
            var3.recalculLaboratoire(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_retour) {
            ++this.var_currentValue;
            this.var_info = "Recalcul des HOSPTALISATIONS en cours....";
            var3.recalculHospitalisation(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void rechercherAnnulTrfMedical() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.lesDocumentsEntete.clear();
         Utilitaires_Medical var1 = new Utilitaires_Medical();
         this.lesDocumentsEntete = var1.rechercherAnnulTrfMedical(this.var_date_deb, this.var_date_fin, this.lesDocumentsEntete, this.baseLog, this.utilInitHibernate);
         this.dataModelDocumentEntete.setWrappedData(this.lesDocumentsEntete);
      }

   }

   public void toutSelectionAnnulTrfMedical() {
      if (this.lesDocumentsEntete.size() != 0) {
         new DocumentEntete();

         for(int var2 = 0; var2 < this.lesDocumentsEntete.size(); ++var2) {
            DocumentEntete var1 = (DocumentEntete)this.lesDocumentsEntete.get(var2);
            var1.setDocSelect(true);
         }
      }

   }

   public void rienSelectionAnnulTrfMedical() {
      if (this.lesDocumentsEntete.size() != 0) {
         new DocumentEntete();

         for(int var2 = 0; var2 < this.lesDocumentsEntete.size(); ++var2) {
            DocumentEntete var1 = (DocumentEntete)this.lesDocumentsEntete.get(var2);
            var1.setDocSelect(false);
         }
      }

   }

   public void annulTrfMedical() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("annule Trf Medical du " + this.var_date_deb + " au " + this.var_date_fin);
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Utilitaires_Medical var2 = new Utilitaires_Medical();
         var2.annulTrfMedical(this.var_date_deb, this.var_date_fin, this.lesDocumentsEntete, this.baseLog, this.utilInitHibernate);
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void forceTrfMedical() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("force Trf Médical du " + this.var_date_deb + " au " + this.var_date_fin);
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Utilitaires_Medical var2 = new Utilitaires_Medical();
         var2.forceTrfMedical(this.var_date_deb, this.var_date_fin, this.baseLog, this.utilInitHibernate);
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculEtatDocumentMedicaux() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des etats des documents medicaux");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Recalcul des etats des documents medicaux.";
      Utilitaires_Medical var3 = new Utilitaires_Medical();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (this.sup_devis) {
            ++this.var_currentValue;
            this.var_info = "Recalcul des CONSULTATIONS en cours....";
            var3.recalculEtatConsultation(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bc) {
            ++this.var_currentValue;
            this.var_info = "Recalcul des PHARMACIES en cours....";
            var3.recalculEtatPharmacie(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bl) {
            ++this.var_currentValue;
            this.var_info = "Recalcul des LABORATOIRES en cours....";
            var3.recalculEtatLaboratoire(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_retour) {
            ++this.var_currentValue;
            this.var_info = "Recalcul des HOSPTALISATIONS en cours....";
            var3.recalculEtatHospitalisation(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void rechercherDeverrouilleManifeste() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.lesDocumentsEntete.clear();
         Utilitaires_Parc var1 = new Utilitaires_Parc();
         this.lesDocumentsEntete = var1.rechercherDeverrouilleManifeste(this.var_date_deb, this.var_date_fin, this.lesDocumentsEntete, this.baseLog, this.utilInitHibernate);
         this.dataModelDocumentEntete.setWrappedData(this.lesDocumentsEntete);
      }

   }

   public void recalculBulletin() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Bulletin");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des salaries...";
      Utilitaires_Paye var2 = new Utilitaires_Paye();
      UtilNombre var3 = new UtilNombre();
      UtilDate var4 = new UtilDate();
      Date var5 = var4.dateJourPrecedent(this.var_date_deb);
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var7 = null;

      try {
         var7 = var6.beginTransaction();
         PlanPaye var8 = new PlanPaye();
         PlanPayeDao var9 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
         this.salariesContrats = new SalariesContrats();
         this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         ArrayList var10 = new ArrayList();
         this.salaries = new Salaries();
         SalariesHistoriqueDao var11 = new SalariesHistoriqueDao(this.baseLog, this.utilInitHibernate);
         SalariesElements var12 = new SalariesElements();
         SalariesElementsDao var13 = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
         this.bulletinLigne = new BulletinLigne();
         new ArrayList();
         BulletinLigneDao var15 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
         this.bulletinSalaire = new BulletinSalaire();
         BulletinSalaireDao var16 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         List var14 = var16.chargerlesBulletinsDate(this.var_date_deb, this.var_date_fin, var6);
         if (var14.size() != 0) {
            int var17;
            for(var17 = 0; var17 < var14.size(); ++var17) {
               this.salaries = ((BulletinSalaire)var14.get(var17)).getSalaries();
               if (var10.size() == 0) {
                  var10.add(this.salaries);
               } else {
                  boolean var18 = false;

                  for(int var19 = 0; var19 < var10.size(); ++var19) {
                     if (((Salaries)var10.get(var19)).getSalId() == this.salaries.getSalId()) {
                        var18 = true;
                        break;
                     }
                  }

                  if (!var18) {
                     var10.add(this.salaries);
                  }
               }
            }

            if (var10.size() != 0) {
               for(var17 = 0; var17 < var10.size(); ++var17) {
                  this.salaries = (Salaries)var10.get(var17);
                  this.var_info = "Salarie: " + this.salaries.getSalMatricule() + " " + this.salaries.getPatronyme();
                  if (var17 != 0) {
                     double var29 = (double)var10.size();
                     double var20 = var3.myRound(var29 / (double)var17, 4);
                     double var22 = var3.myRound(100.0D / var20, 2);
                     this.var_currentValue = (int)var22;
                  }

                  var2.recalculBulletin(var5, var14, var8, this.salaries, this.salariesContrats, this.bulletinSalaire, this.bulletinLigne, var12, var11, this.salariesContratsDao, var13, var16, var15, var9, this.structureLog, var6);
               }
            }

            var7.commit();
         }
      } catch (HibernateException var27) {
         if (var7 != null) {
            var7.rollback();
         }

         throw var27;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void suppressionBulletinSalaires() throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("suppression Bulletin Salaires");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         BulletinSalaireDao var5 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         BulletinLigneDao var6 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
         new SalariesPretsLignes();
         SalariesPretsLignesDao var8 = new SalariesPretsLignesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         new ArrayList();
         new ExercicesPaye();
         ExercicesPaye var11 = this.exercicesPayeDao.recupererLExoSelect((long)(this.var_date_deb.getYear() + 1900), var3);
         if (var11 == null) {
            var11 = new ExercicesPaye();
         }

         List var10 = var5.suppressionlesBulletinsDate(var11, this.var_date_deb, this.var_date_fin, var3);
         if (var10.size() != 0) {
            this.bulletinSalaire = new BulletinSalaire();
            this.bulletinLigne = new BulletinLigne();

            for(int var12 = 0; var12 < var10.size(); ++var12) {
               this.bulletinSalaire = (BulletinSalaire)var10.get(var12);
               long var13 = this.bulletinSalaire.getBulsalId();
               List var9 = var6.chargerleslignesBulletin(this.bulletinSalaire, var3);
               if (var9.size() != 0) {
                  for(int var15 = 0; var15 < var9.size(); ++var15) {
                     this.bulletinLigne = (BulletinLigne)var9.get(var15);
                     if (this.bulletinLigne.getBulligIdPretligne() != 0L) {
                        SalariesPretsLignes var7 = var8.pourParapheur(this.bulletinLigne.getBulligIdPretligne(), var3);
                        if (var7 != null) {
                           var7.setSalpreligDateReel((Date)null);
                           var7.setSalpreligMontantReel(0.0D);
                           var8.modif(var7, var3);
                           var2 = true;
                        }
                     }

                     var6.delete(this.bulletinLigne, var3);
                  }
               }

               this.bulletinSalaire = var5.pourParapheur(var13, var3);
               if (this.bulletinSalaire != null) {
                  var5.delete(this.bulletinSalaire, var3);
               }
            }

            var4.commit();
         }
      } catch (HibernateException var19) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var19;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var2) {
         this.recalculPrets();
      } else {
         this.var_showBarProg = false;
         this.choixModule = "moduleUtilitaires";
         this.choixLigne = "";
         this.formRecherche.setMessageTexte("Opérations effectuées..");
         this.formRecherche.setShowModalPanelMessage(true);
      }

   }

   public void recalculPrets() throws NamingException, ParseException, JDOMException, IOException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Prets");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      new UtilDate();
      new ArrayList();
      SalariesPretsDao var5 = new SalariesPretsDao(this.baseLog, this.utilInitHibernate);
      Object var6 = new ArrayList();
      SalariesPretsLignesDao var7 = new SalariesPretsLignesDao(this.baseLog, this.utilInitHibernate);
      new ExercicesPaye();
      ExercicesPaye var8 = this.exercicesPayeDao.recupererLastExo(var2);
      LectureNaturePrets var9 = new LectureNaturePrets();
      var9.setStrId(this.structureLog.getStrid());
      var9.setStructureLog(this.structureLog);
      List var10 = var9.chargerMesNaturesPretsItems();
      if (var8 != null) {
         Transaction var11 = null;

         try {
            var11 = var2.beginTransaction();
            List var4 = var5.chargerTouslesPrets(var2);
            if (var4.size() != 0) {
               new SalariesPrets(var10);
               this.salaries = new Salaries();

               for(int var13 = 0; var13 < var4.size(); ++var13) {
                  SalariesPrets var12 = (SalariesPrets)var4.get(var13);
                  this.salaries = var12.getSalaries();
                  ((List)var6).clear();
                  double var14 = 0.0D;
                  double var16 = 0.0D;
                  var6 = var7.chargerlesPretsLignes(var12, var2);
                  if (((List)var6).size() != 0) {
                     new SalariesPretsLignes();

                     for(int var19 = 0; var19 < ((List)var6).size(); ++var19) {
                        SalariesPretsLignes var18 = (SalariesPretsLignes)((List)var6).get(var19);
                        var18.setSalaries(var12.getSalaries());
                        var18 = var7.modif(var18, var2);
                        var14 += var18.getSalpreligMontantReel();
                        var16 += var18.getSalpreligMontantTheo();
                     }
                  }

                  var12.setSalpreRmb(var14);
                  var12.setSalpreMontant(var16);
                  if (var14 >= var16) {
                     var12.setSalpreRmb(var16);
                  }

                  var5.modif(var12, var2);
               }
            }

            var11.commit();
         } catch (HibernateException var23) {
            if (var11 != null) {
               var11.rollback();
            }

            throw var23;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculPretsRegenerationEchaences() throws NamingException, ParseException, JDOMException, IOException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Prets");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      UtilDate var3 = new UtilDate();
      new ArrayList();
      SalariesPretsDao var5 = new SalariesPretsDao(this.baseLog, this.utilInitHibernate);
      Object var6 = new ArrayList();
      SalariesPretsLignesDao var7 = new SalariesPretsLignesDao(this.baseLog, this.utilInitHibernate);
      new ExercicesPaye();
      ExercicesPaye var8 = this.exercicesPayeDao.recupererLastExo(var2);
      LectureNaturePrets var9 = new LectureNaturePrets();
      var9.setStrId(this.structureLog.getStrid());
      var9.setStructureLog(this.structureLog);
      List var10 = var9.chargerMesNaturesPretsItems();
      if (var8 != null) {
         Transaction var11 = null;

         try {
            var11 = var2.beginTransaction();
            List var4 = var5.chargerTouslesPrets(var2);
            if (var4.size() != 0) {
               new SalariesPrets(var10);
               this.salaries = new Salaries();

               for(int var13 = 0; var13 < var4.size(); ++var13) {
                  SalariesPrets var12 = (SalariesPrets)var4.get(var13);
                  this.salaries = var12.getSalaries();
                  ((List)var6).clear();
                  double var14 = 0.0D;
                  double var16 = 0.0D;
                  var6 = var7.chargerlesPretsLignes(var12, var2);
                  if (((List)var6).size() != 0) {
                     new SalariesPretsLignes();

                     for(int var19 = 0; var19 < ((List)var6).size(); ++var19) {
                        SalariesPretsLignes var18 = (SalariesPretsLignes)((List)var6).get(var19);
                        var18.setSalaries(var12.getSalaries());
                        var18 = var7.modif(var18, var2);
                        var14 += var18.getSalpreligMontantReel();
                        var16 += var18.getSalpreligMontantTheo();
                     }
                  }

                  if (((List)var6).size() < var12.getSalpreEcheance()) {
                     int var32 = var12.getSalpreEcheance() - ((List)var6).size();
                     if (var12.getSalpreEcheance() == 0) {
                        var12.setSalpreEcheance(1);
                     }

                     double var33 = var12.getSalpreMontant() / (double)var12.getSalpreEcheance();
                     Date var21 = var12.getSalpreDateDebut();
                     new SalariesPretsLignes();

                     SalariesPretsLignes var22;
                     int var23;
                     for(var23 = 0; var23 < var32; ++var23) {
                        var22 = new SalariesPretsLignes();
                        var22.setSalaries(this.salaries);
                        var22.setSalariesPrets(var12);
                        var22.setSalpreligDateTheo(var21);
                        var22.setSalpreligDateReel(var22.getSalpreligDateTheo());
                        var22.setSalpreligMontantTheo(var33);
                        var22.setSalpreligMontantReel(var22.getSalpreligMontantTheo());
                        var22.setSalpreligNum(var12.getSalpreNum());
                        var22 = var7.insert(var22, var2);
                        ((List)var6).add(var22);
                        int var24 = var21.getMonth() + 1;
                        int var25 = var21.getYear() + 1900;
                        ++var24;
                        if (var24 > 12) {
                           var24 = 1;
                           ++var25;
                        }

                        String var26 = "";
                        if (var24 <= 9) {
                           var26 = "0" + var24;
                        } else {
                           var26 = "" + var24;
                        }

                        var21 = var3.stringToDateSQLLight(var25 + "-" + var26 + "-01");
                     }

                     var14 = 0.0D;
                     var16 = 0.0D;

                     for(var23 = 0; var23 < ((List)var6).size(); ++var23) {
                        var22 = (SalariesPretsLignes)((List)var6).get(var23);
                        var14 += var22.getSalpreligMontantReel();
                        var16 += var22.getSalpreligMontantTheo();
                     }
                  }

                  var12.setSalpreRmb(var14);
                  var12.setSalpreMontant(var16);
                  if (var14 >= var16) {
                     var12.setSalpreRmb(var16);
                  }

                  var5.modif(var12, var2);
               }
            }

            var11.commit();
         } catch (HibernateException var30) {
            if (var11 != null) {
               var11.rollback();
            }

            throw var30;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculSalaries() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Salaries");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      LecturePays var2 = new LecturePays();
      new ArrayList();
      List var3 = var2.getMespays();
      if (var3.size() != 0) {
         new ArrayList();
         this.salaries = new Salaries();
         this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
         List var4 = this.salariesDao.chargerlesSalariesActif("*", (Session)null);
         if (var4.size() != 0) {
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var6 = null;

            try {
               var6 = var5.beginTransaction();

               for(int var7 = 0; var7 < var4.size(); ++var7) {
                  this.salaries = (Salaries)var4.get(var7);
                  if (this.salaries.getSalPaysNaissance() != null && !this.salaries.getSalPaysNaissance().isEmpty()) {
                     for(int var8 = 0; var8 < var3.size(); ++var8) {
                        if (((ObjetPays)var3.get(var8)).getNom_FR().equals(this.salaries.getSalPaysNaissance())) {
                           this.salaries.setSalCodeNaissance(((ObjetPays)var3.get(var8)).getIdentification());
                           this.salaries = this.salariesDao.modif(this.salaries, var5);
                           break;
                        }
                     }
                  }
               }

               var6.commit();
            } catch (HibernateException var12) {
               if (var6 != null) {
                  var6.rollback();
               }

               throw var12;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void calculRegroupementBulletin() throws HibernateException, NamingException {
      LireLesoptionsPaye var1 = new LireLesoptionsPaye();
      var1.setStrId(this.structureLog.getStrid());
      var1.lancer();
      this.optionPaye = var1.getOptionsPaye();
      this.mesJournauxComptables = new ArrayList();
      if (this.optionPaye.getModeTravail().equals("0")) {
         this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
         new ExercicesPaye();
         ExercicesPaye var2 = this.exercicesPayeDao.recupererLastExo((Session)null);
         if (var2 != null) {
            FeuilleCalculDao var3 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
            this.mesJournauxComptables = var3.chargerFeuilles(var2.getExepayId(), "", (Session)null);
         }
      } else {
         List var4;
         int var5;
         if (this.optionPaye.getModeTravail().equals("1")) {
            new ArrayList();
            this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
            var4 = this.salariesContratsDao.chargerlesContratsByActivites(this.optionPaye.getTriModeTravail(), (Session)null);
            if (var4.size() != 0) {
               for(var5 = 0; var5 < var4.size(); ++var5) {
                  if (((SalariesContrats)var4.get(var5)).getSalconActivite() != null && !((SalariesContrats)var4.get(var5)).getSalconActivite().isEmpty()) {
                     this.mesJournauxComptables.add(new SelectItem(((SalariesContrats)var4.get(var5)).getSalconActivite() + ":" + ((SalariesContrats)var4.get(var5)).getSalconLibActivite()));
                  }
               }
            }
         } else if (this.optionPaye.getModeTravail().equals("2")) {
            new ArrayList();
            this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
            var4 = this.salariesContratsDao.chargerlesContratsByServices(this.optionPaye.getTriModeTravail(), (Session)null);
            if (var4.size() != 0) {
               for(var5 = 0; var5 < var4.size(); ++var5) {
                  if (((SalariesContrats)var4.get(var5)).getSalconService() != null && !((SalariesContrats)var4.get(var5)).getSalconService().isEmpty()) {
                     this.mesJournauxComptables.add(new SelectItem(((SalariesContrats)var4.get(var5)).getSalconService() + ":" + ((SalariesContrats)var4.get(var5)).getSalconLibService()));
                  }
               }
            }
         } else if (this.optionPaye.getModeTravail().equals("3")) {
            new ArrayList();
            this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
            var4 = this.salariesContratsDao.chargerlesContratsByProjets(this.optionPaye.getTriModeTravail(), (Session)null);
            if (var4.size() != 0) {
               for(var5 = 0; var5 < var4.size(); ++var5) {
                  if (((SalariesContrats)var4.get(var5)).getSalconProjet() != null && !((SalariesContrats)var4.get(var5)).getSalconProjet().isEmpty()) {
                     this.mesJournauxComptables.add(new SelectItem(((SalariesContrats)var4.get(var5)).getSalconProjet() + ":" + ((SalariesContrats)var4.get(var5)).getSalconLibProjet()));
                  }
               }
            }
         } else if (this.optionPaye.getModeTravail().equals("4")) {
            new ArrayList();
            this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
            var4 = this.tiersDao.chargerLesTiers("3", (Session)null);
            if (var4.size() != 0) {
               for(var5 = 0; var5 < var4.size(); ++var5) {
                  if (((Tiers)var4.get(var5)).getTieraisonsocialenom() != null && !((Tiers)var4.get(var5)).getTieraisonsocialenom().isEmpty() && ((Tiers)var4.get(var5)).getTiemodecom() != 0) {
                     this.mesJournauxComptables.add(new SelectItem("" + ((Tiers)var4.get(var5)).getTieid() + ":" + ((Tiers)var4.get(var5)).getTieraisonsocialenom()));
                  }
               }
            }
         }
      }

   }

   public void declotureBulletin() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("Dé-cloture Bulletin Salaires");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
         new ExercicesPaye();
         ExercicesPaye var4 = this.exercicesPayeDao.recupererLastExo(var2);
         if (var4 != null) {
            LireLesoptionsPaye var5 = new LireLesoptionsPaye();
            var5.setStrId(this.structureLog.getStrid());
            var5.lancer();
            this.optionPaye = var5.getOptionsPaye();
            int var6 = Integer.parseInt(this.optionPaye.getModeTravail());
            int var7 = this.var_date_deb.getMonth() + 1;
            int var8 = this.var_date_fin.getMonth() + 1;
            String var9 = "";
            if (this.var_journal != null && !this.var_journal.isEmpty()) {
               String[] var10 = this.var_journal.split(":");
               var9 = var10[0];
            }

            BulletinMoisDao var22 = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
            new BulletinMois();
            new ArrayList();
            List var12 = var22.mesFeuillesmois(var6, var4, var2);
            if (var12.size() != 0) {
               for(int var13 = 0; var13 < var12.size(); ++var13) {
                  BulletinMois var11 = (BulletinMois)var12.get(var13);
                  boolean var14 = false;
                  if (var11.getBulmenEtat() == 3) {
                     if (var9 != null && !var9.isEmpty()) {
                        if (var9.equals(var11.getBulmenFeuille())) {
                           var14 = true;
                        }
                     } else {
                        var14 = true;
                     }

                     if (var14) {
                        String[] var15 = var11.getBulmenPeriode().split(":");
                        int var16 = Integer.parseInt(var15[0]);
                        if (var16 >= var7 && var16 <= var8) {
                           var11.setBulmenEtat(2);
                           var22.majJournal(var11, var2);
                        }
                     }
                  }
               }

               var3.commit();
            }
         }
      } catch (HibernateException var20) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var20;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void annulTrfBulletin() throws NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("annulation transfert Bulletins Salaires en compta");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      String var2 = "";
      long var3 = (long)(this.var_date_deb.getYear() + 1900);
      this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      new ExercicesPaye();
      ExercicesPaye var5 = this.exercicesPayeDao.recupererLExoSelect(var3, (Session)null);
      if (var5 != null) {
         LireLesoptionsPaye var6 = new LireLesoptionsPaye();
         var6.setStrId(this.structureLog.getStrid());
         var6.lancer();
         this.optionPaye = var6.getOptionsPaye();
         int var7 = Integer.parseInt(this.optionPaye.getModeTravail());
         Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var9 = null;

         FeuilleCalculDao var10;
         List var11;
         int var12;
         List var49;
         try {
            var9 = var8.beginTransaction();
            var10 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            var11 = var10.chargerFeuillesByJournal(var3, var8);
            if (var11.size() != 0) {
               for(var12 = 0; var12 < var11.size(); ++var12) {
                  if (((FeuilleCalcul)var11.get(var12)).getFeuJournal() != null && !((FeuilleCalcul)var11.get(var12)).getFeuJournal().isEmpty() && ((FeuilleCalcul)var11.get(var12)).getFeuJournal().contains(":")) {
                     String[] var13 = ((FeuilleCalcul)var11.get(var12)).getFeuJournal().split(":");
                     if (var2 != null && !var2.isEmpty()) {
                        if (!var2.contains(var13[0])) {
                           var2 = var2 + "," + var13[0];
                        }
                     } else {
                        var2 = var13[0];
                     }
                  }
               }
            }

            BulletinSalaireDao var48 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
            this.bulletinSalaire = new BulletinSalaire();
            new ArrayList();
            var49 = var48.chargerlesBulletinsDate(this.var_date_deb, this.var_date_fin, var8);
            if (var49.size() != 0) {
               for(int var14 = 0; var14 < var49.size(); ++var14) {
                  this.bulletinSalaire = (BulletinSalaire)var49.get(var14);
                  this.bulletinSalaire.setBulsalDateTransfert((Date)null);
                  this.bulletinSalaire = var48.modif(this.bulletinSalaire, var8);
               }

               var9.commit();
            }
         } catch (HibernateException var43) {
            if (var9 != null) {
               var9.rollback();
            }

            throw var43;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         var10 = null;

         int var18;
         try {
            Transaction var45 = var8.beginTransaction();
            int var46 = this.var_date_deb.getMonth() + 1;
            var12 = this.var_date_fin.getMonth() + 1;
            BulletinMoisDao var51 = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
            new BulletinMois();
            new ArrayList();
            List var15 = var51.mesFeuillesmois(var7, var5, var8);
            if (var15.size() != 0) {
               for(int var16 = 0; var16 < var15.size(); ++var16) {
                  BulletinMois var52 = (BulletinMois)var15.get(var16);
                  if (var52.getBulmenEtat() == 4) {
                     String[] var17 = var52.getBulmenPeriode().split(":");
                     var18 = Integer.parseInt(var17[0]);
                     if (var18 >= var46 && var18 <= var12) {
                        var52.setBulmenEtat(3);
                        var51.majJournal(var52, var8);
                     }
                  }
               }

               var45.commit();
            }
         } catch (HibernateException var41) {
            if (var10 != null) {
               var10.rollback();
            }

            throw var41;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (var2 != null && !var2.isEmpty()) {
            var2 = "('" + var2 + "')";
            var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
            var11 = null;

            try {
               Transaction var47 = var8.beginTransaction();
               EcrituresAnalytiquesDao var50 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
               new ArrayList();
               var49 = var50.chargerLesEcrituresAnalytiquesByListJournal(this.var_date_deb, this.var_date_fin, var2, var8);
               if (var49.size() != 0) {
                  var50.nettoyageAnalytiqueByEcriture(var49, var8);
                  var8.flush();
               }

               EcrituresDao var53 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
               new Ecritures();
               new JournauxMois();
               JournauxMoisDao var56 = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
               this.lesEcritures = new ArrayList();
               this.lesEcritures = var53.chargerEcrituresListJournal(this.var_date_deb, this.var_date_fin, var2, var8);
               if (this.lesEcritures.size() != 0) {
                  for(var18 = 0; var18 < this.lesEcritures.size(); ++var18) {
                     Ecritures var54 = (Ecritures)this.lesEcritures.get(var18);
                     JournauxMois var55 = var56.recupererJournauxMois(var54.getEcrCle1(), var8);
                     if (var55 != null && var55.getJoumenSaisie() != 0) {
                        var55.setJoumenSaisie(0);
                        var56.majJournal(var55, var8);
                     }
                  }

                  var53.removeSelectedEC2(this.lesEcritures, 0, var8);
                  var8.flush();
               }

               var47.commit();
            } catch (HibernateException var39) {
               if (var11 != null) {
                  var11.rollback();
               }

               throw var39;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void effaceSemaphoresPreparation() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("efface Semaphores des préparations");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new ExercicesPaye();
      this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      ExercicesPaye var2 = this.exercicesPayeDao.recupererLastExo((Session)null);
      if (var2 != null) {
         LireLesoptionsPaye var3 = new LireLesoptionsPaye();
         var3.setStrId(this.structureLog.getStrid());
         var3.lancer();
         this.optionPaye = var3.getOptionsPaye();
         int var4 = Integer.parseInt(this.optionPaye.getModeTravail());
         new ArrayList();
         new BulletinMois();
         BulletinMoisDao var7 = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
         List var5 = var7.mesFeuillesmois(var4, var2, (Session)null);
         if (var5.size() != 0) {
            Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var9 = null;

            try {
               var9 = var8.beginTransaction();

               for(int var10 = 0; var10 < var5.size(); ++var10) {
                  new BulletinMois();
                  BulletinMois var6 = (BulletinMois)var5.get(var10);
                  if (var6.getBulmenUserIdJournal() != 0L || var6.getBulmenUserIdJournal() != 0L) {
                     var6.setBulmenUserIdJournal(0L);
                     var6.setBulmenOpenUserJournal("");
                     var6.setBulmenOpenJournal(0);
                     var6.setBulmenEtat(1);
                     var7.majJournal(var6, var8);
                  }
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

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void effaceSemaphoresGeneration() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("efface Semaphores des générations");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new ExercicesPaye();
      this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      ExercicesPaye var2 = this.exercicesPayeDao.recupererLastExo((Session)null);
      if (var2 != null) {
         LireLesoptionsPaye var3 = new LireLesoptionsPaye();
         var3.setStrId(this.structureLog.getStrid());
         var3.lancer();
         this.optionPaye = var3.getOptionsPaye();
         int var4 = Integer.parseInt(this.optionPaye.getModeTravail());
         new ArrayList();
         new BulletinMois();
         BulletinMoisDao var7 = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
         List var5 = var7.mesFeuillesmois(var4, var2, (Session)null);
         if (var5.size() != 0) {
            Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var9 = null;

            try {
               var9 = var8.beginTransaction();

               for(int var10 = 0; var10 < var5.size(); ++var10) {
                  new BulletinMois();
                  BulletinMois var6 = (BulletinMois)var5.get(var10);
                  if (var6.getBulmenUserIdGeneration() != 0L || var6.getBulmenUserIdGeneration() != 0L) {
                     var6.setBulmenUserIdGeneration(0L);
                     var6.setBulmenOpenUserGeneration("");
                     var6.setBulmenOpenGeneration(0);
                     var6.setBulmenEtat(1);
                     var7.majJournal(var6, var8);
                  }
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

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculBulletinColA() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Bulletin");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des bulletins de salaire...";
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      var3.dateJourPrecedent(this.var_date_deb);
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var6 = null;

      try {
         var6 = var5.beginTransaction();
         Object var7 = new ArrayList();
         this.bulletinLigne = new BulletinLigne();
         BulletinLigneDao var8 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         this.bulletinSalaire = new BulletinSalaire();
         BulletinSalaireDao var10 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         List var9 = var10.chargerlesBulletinsDate(this.var_date_deb, this.var_date_fin, var5);
         if (var9.size() != 0) {
            for(int var11 = 0; var11 < var9.size(); ++var11) {
               this.bulletinSalaire = (BulletinSalaire)var9.get(var11);
               this.var_info = "Bulletin: " + this.bulletinSalaire.getSalaries().getSalMatricule() + " " + this.bulletinSalaire.getBulsalPeriode();
               double var12;
               if (var11 != 0) {
                  var12 = (double)var9.size();
                  double var14 = var2.myRound(var12 / (double)var11, 4);
                  double var16 = var2.myRound(100.0D / var14, 2);
                  this.var_currentValue = (int)var16;
               }

               ((List)var7).clear();
               var7 = var8.chargerleslignesBulletin(this.bulletinSalaire, var5);
               if (((List)var7).size() != 0) {
                  var12 = 0.0D;

                  int var23;
                  for(var23 = 0; var23 < ((List)var7).size(); ++var23) {
                     if (((BulletinLigne)((List)var7).get(var23)).getBulligNature() == 50 || ((BulletinLigne)((List)var7).get(var23)).getBulligNature() == 59) {
                        var12 += ((BulletinLigne)((List)var7).get(var23)).getBulligValColE();
                     }
                  }

                  for(var23 = 0; var23 < ((List)var7).size(); ++var23) {
                     this.bulletinLigne = (BulletinLigne)((List)var7).get(var23);
                     if ((this.bulletinLigne.getBulligNature() == 60 || this.bulletinLigne.getBulligNature() == 61 || this.bulletinLigne.getBulligNature() == 62 || this.bulletinLigne.getBulligNature() == 90) && this.bulletinLigne.getBulligValColA() == 0.0D) {
                        this.bulletinLigne.setBulligValColA(var12);
                        var8.modif(this.bulletinLigne, var5);
                     }
                  }

                  for(var23 = 0; var23 < ((List)var7).size(); ++var23) {
                     this.bulletinLigne = (BulletinLigne)((List)var7).get(var23);
                     if (this.bulletinLigne.getBulligRubrique().equals("300000")) {
                        if (this.bulletinLigne.getBulligValColB() == 0.0D) {
                           if (this.structureLog.getStrcodepays().equals("0077")) {
                              if (var12 >= 1500000.0D) {
                                 this.bulletinLigne.setBulligValColB(1500000.0D);
                              } else {
                                 this.bulletinLigne.setBulligValColB(var12);
                              }
                           } else if (this.structureLog.getStrcodepays().equals("0202")) {
                              if (var12 >= 360000.0D) {
                                 this.bulletinLigne.setBulligValColB(360000.0D);
                              } else {
                                 this.bulletinLigne.setBulligValColB(var12);
                              }
                           }

                           var8.modif(this.bulletinLigne, var5);
                        }
                     } else if (this.bulletinLigne.getBulligRubrique().equals("300010")) {
                        if (this.bulletinLigne.getBulligValColB() == 0.0D) {
                           if (this.structureLog.getStrcodepays().equals("0202")) {
                              if (var12 >= 1080000.0D) {
                                 this.bulletinLigne.setBulligValColB(1080000.0D);
                              } else {
                                 this.bulletinLigne.setBulligValColB(var12);
                              }
                           }

                           var8.modif(this.bulletinLigne, var5);
                        }
                     } else if (this.bulletinLigne.getBulligRubrique().equals("300020")) {
                        if (this.bulletinLigne.getBulligValColB() == 0.0D) {
                           if (this.structureLog.getStrcodepays().equals("0077")) {
                              if (var12 >= 2500000.0D) {
                                 this.bulletinLigne.setBulligValColB(2500000.0D);
                              } else {
                                 this.bulletinLigne.setBulligValColB(var12);
                              }
                           }

                           var8.modif(this.bulletinLigne, var5);
                        }
                     } else if (this.bulletinLigne.getBulligRubrique().equals("900000")) {
                        if (this.bulletinLigne.getBulligValColB() == 0.0D) {
                           if (this.structureLog.getStrcodepays().equals("0077")) {
                              if (var12 >= 2500000.0D) {
                                 this.bulletinLigne.setBulligValColB(2500000.0D);
                              } else {
                                 this.bulletinLigne.setBulligValColB(var12);
                              }
                           } else if (this.structureLog.getStrcodepays().equals("0202")) {
                              if (var12 >= 360000.0D) {
                                 this.bulletinLigne.setBulligValColB(360000.0D);
                              } else {
                                 this.bulletinLigne.setBulligValColB(var12);
                              }
                           }

                           var8.modif(this.bulletinLigne, var5);
                        }
                     } else if (this.bulletinLigne.getBulligRubrique().equals("900010")) {
                        if (this.bulletinLigne.getBulligValColB() == 0.0D) {
                           if (this.structureLog.getStrcodepays().equals("0077")) {
                              if (var12 >= 1500000.0D) {
                                 this.bulletinLigne.setBulligValColB(1500000.0D);
                              } else {
                                 this.bulletinLigne.setBulligValColB(var12);
                              }
                           } else if (this.structureLog.getStrcodepays().equals("0202")) {
                              if (var12 >= 1080000.0D) {
                                 this.bulletinLigne.setBulligValColB(1080000.0D);
                              } else {
                                 this.bulletinLigne.setBulligValColB(var12);
                              }
                           }

                           var8.modif(this.bulletinLigne, var5);
                        }
                     } else if (this.bulletinLigne.getBulligRubrique().equals("900020")) {
                        if (this.bulletinLigne.getBulligValColB() == 0.0D) {
                           if (this.structureLog.getStrcodepays().equals("0077")) {
                              if (var12 >= 2500000.0D) {
                                 this.bulletinLigne.setBulligValColB(2500000.0D);
                              } else {
                                 this.bulletinLigne.setBulligValColB(var12);
                              }
                           } else if (this.structureLog.getStrcodepays().equals("0202")) {
                              if (var12 >= 63000.0D) {
                                 this.bulletinLigne.setBulligValColB(63000.0D);
                              } else {
                                 this.bulletinLigne.setBulligValColB(var12);
                              }
                           }

                           var8.modif(this.bulletinLigne, var5);
                        }
                     } else if (this.bulletinLigne.getBulligRubrique().equals("900030") && this.bulletinLigne.getBulligValColB() == 0.0D) {
                        if (this.structureLog.getStrcodepays().equals("0202")) {
                           if (var12 >= 63000.0D) {
                              this.bulletinLigne.setBulligValColB(63000.0D);
                           } else {
                              this.bulletinLigne.setBulligValColB(var12);
                           }
                        }

                        var8.modif(this.bulletinLigne, var5);
                     }
                  }

                  var5.flush();
               }
            }

            var6.commit();
         }
      } catch (HibernateException var21) {
         if (var6 != null) {
            var6.rollback();
         }

         throw var21;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculLibelleService() throws NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recopie contrat dans elements et bulletins");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new ArrayList();
      ServiceDao var3 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerLesServices((Session)null);
      UtilNombre var4 = new UtilNombre();
      if (var2.size() != 0) {
         new ExercicesPaye();
         this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
         ExercicesPaye var5 = this.exercicesPayeDao.recupererLastExo((Session)null);
         if (var5 != null) {
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var7 = null;

            try {
               var7 = var6.beginTransaction();
               this.var_currentValue = 0;
               this.var_showBarProg = true;
               this.var_info = "Chargement des contrats de salaire...";
               new ArrayList();
               this.salariesContrats = new SalariesContrats();
               this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
               List var8 = this.salariesContratsDao.chargerlesContrats(var6);
               if (var8.size() != 0) {
                  this.var_currentValue = 0;
                  this.var_showBarProg = true;
                  this.var_info = "Chargement des bulletins de salaire...";
                  new ArrayList();
                  this.bulletinSalaire = new BulletinSalaire();
                  BulletinSalaireDao var10 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
                  List var9 = var10.chargerlesBulletinsDate(this.var_date_deb, this.var_date_fin, var6);
                  double var16;
                  if (var9.size() != 0) {
                     for(int var11 = 0; var11 < var9.size(); ++var11) {
                        this.bulletinSalaire = (BulletinSalaire)var9.get(var11);
                        this.var_info = "Bulletin: " + this.bulletinSalaire.getSalaries().getSalMatricule() + " " + this.bulletinSalaire.getBulsalPeriode();
                        if (var11 != 0) {
                           double var12 = (double)var9.size();
                           double var14 = var4.myRound(var12 / (double)var11, 4);
                           var16 = var4.myRound(100.0D / var14, 2);
                           this.var_currentValue = (int)var16;
                        }

                        this.salariesContrats = null;

                        for(int var28 = 0; var28 < var8.size(); ++var28) {
                           if (((SalariesContrats)var8.get(var28)).getSalaries().getSalId() == this.bulletinSalaire.getSalaries().getSalId()) {
                              this.salariesContrats = (SalariesContrats)var8.get(var28);
                              break;
                           }
                        }

                        if (this.salariesContrats != null) {
                           this.bulletinSalaire = var10.pourParapheur(this.bulletinSalaire.getBulsalId(), var6);
                           if (this.bulletinSalaire != null) {
                              this.bulletinSalaire.setBulsalActivite(this.salariesContrats.getSalconActivite());
                              this.bulletinSalaire.setBulsalBudget(this.salariesContrats.getSalconBudget());
                              this.bulletinSalaire.setBulsalCentresImpots(this.salariesContrats.getSalconCentresImpots());
                              this.bulletinSalaire.setBulsalCentresSecurite(this.salariesContrats.getSalconCentresSecurite());
                              this.bulletinSalaire.setBulsalClassement(this.salariesContrats.getSalconClassement());
                              this.bulletinSalaire.setBulsalCle1Anal(this.salariesContrats.getSalconCle1Anal());
                              this.bulletinSalaire.setBulsalCle2Anal(this.salariesContrats.getSalconCle2Anal());
                              this.bulletinSalaire.setBulsalConvention(this.salariesContrats.getSalconConvention());
                              this.bulletinSalaire.setBulsalDepartement(this.salariesContrats.getSalconDepartement());
                              this.bulletinSalaire.setBulsalFeuille(this.salariesContrats.getSalconFeuille());
                              this.bulletinSalaire.setBulsalFonction(this.salariesContrats.getSalconFonction());
                              this.bulletinSalaire.setBulsalGrille(this.salariesContrats.getSalconGrille());
                              this.bulletinSalaire.setBulsalLibCentresImpots(this.salariesContrats.getSalconLibCentresImpots());
                              this.bulletinSalaire.setBulsalLibCentresSecurite(this.salariesContrats.getSalconLibCentresSecurite());
                              this.bulletinSalaire.setBulsalLibClassement(this.salariesContrats.getSalconLibClassement());
                              this.bulletinSalaire.setBulsalLibConvention(this.salariesContrats.getSalconLibConvention());
                              this.bulletinSalaire.setBulsalLibNivEmploi(this.salariesContrats.getSalconLibNivEmploi());
                              this.bulletinSalaire.setBulsalLibService(this.salariesContrats.getSalconLibService());
                              this.bulletinSalaire.setBulsalNature(this.salariesContrats.getSalconType());
                              this.bulletinSalaire.setBulsalNivEmploi(this.salariesContrats.getSalconNivEmploi());
                              this.bulletinSalaire.setBulsalParc(this.salariesContrats.getSalconParc());
                              this.bulletinSalaire.setBulsalService(this.salariesContrats.getSalconService());
                              this.bulletinSalaire.setBulsalSite(this.salariesContrats.getSalconSite());
                              var10.modif(this.bulletinSalaire, var6);
                           }
                        }
                     }

                     var6.flush();
                  }

                  this.var_currentValue = 0;
                  this.var_showBarProg = true;
                  this.var_info = "Chargement des elements de salaire...";
                  new ArrayList();
                  new SalariesElements();
                  SalariesElementsDao var13 = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
                  List var27 = var13.chargerlesElements(var6);
                  int var32;
                  if (var27.size() != 0) {
                     for(int var30 = 0; var30 < var27.size(); ++var30) {
                        SalariesElements var29 = (SalariesElements)var27.get(var30);
                        this.var_info = "Element: " + var30;
                        if (var30 != 0) {
                           double var15 = (double)var9.size();
                           double var17 = var4.myRound(var15 / (double)var30, 4);
                           double var19 = var4.myRound(100.0D / var17, 2);
                           this.var_currentValue = (int)var19;
                        }

                        this.salariesContrats = null;

                        for(var32 = 0; var32 < var8.size(); ++var32) {
                           if (((SalariesContrats)var8.get(var32)).getSalaries().getSalId() == var29.getSalaries().getSalId()) {
                              this.salariesContrats = (SalariesContrats)var8.get(var32);
                              break;
                           }
                        }

                        if (this.salariesContrats != null) {
                           var29 = var13.pourParapheur(var29.getSaleleId(), var6);
                           if (var29 != null) {
                              var29.setSaleleActivite(this.salariesContrats.getSalconActivite());
                              var29.setSaleleBudget(this.salariesContrats.getSalconBudget());
                              var29.setSaleleCentresImpots(this.salariesContrats.getSalconCentresImpots());
                              var29.setSaleleCentresSecurite(this.salariesContrats.getSalconCentresSecurite());
                              var29.setSaleleClassement(this.salariesContrats.getSalconClassement());
                              var29.setSaleleCle1Anal(this.salariesContrats.getSalconCle1Anal());
                              var29.setSaleleCle2Anal(this.salariesContrats.getSalconCle2Anal());
                              var29.setSaleleConvention(this.salariesContrats.getSalconConvention());
                              var29.setSaleleDepartement(this.salariesContrats.getSalconDepartement());
                              var29.setSaleleFeuille(this.salariesContrats.getSalconFeuille());
                              var29.setSaleleFonction(this.salariesContrats.getSalconFonction());
                              var29.setSaleleGrille(this.salariesContrats.getSalconGrille());
                              var29.setSaleleLibCentresImpots(this.salariesContrats.getSalconLibCentresImpots());
                              var29.setSaleleLibCentresSecurite(this.salariesContrats.getSalconLibCentresSecurite());
                              var29.setSaleleLibClassement(this.salariesContrats.getSalconLibClassement());
                              var29.setSaleleLibCle1Anal(this.salariesContrats.getSalconLibCle1Anal());
                              var29.setSaleleLibCle2Anal(this.salariesContrats.getSalconLibCle2Anal());
                              var29.setSaleleLibConvention(this.salariesContrats.getSalconLibConvention());
                              var29.setSaleleLibGrille(this.salariesContrats.getSalconLibGrille());
                              var29.setSaleleLibNivEmploi(this.salariesContrats.getSalconLibNivEmploi());
                              var29.setSaleleLibService(this.salariesContrats.getSalconLibService());
                              var29.setSaleleNature(this.salariesContrats.getSalconType());
                              var29.setSaleleNivEmploi(this.salariesContrats.getSalconNivEmploi());
                              var29.setSaleleParc(this.salariesContrats.getSalconParc());
                              var29.setSaleleService(this.salariesContrats.getSalconService());
                              var29.setSaleleSite(this.salariesContrats.getSalconSite());
                              var13.modif(var29, var6);
                           }
                        }
                     }

                     var6.flush();
                  }

                  this.var_currentValue = 0;
                  this.var_showBarProg = true;
                  this.var_info = "Chargement des salaries...";
                  new ArrayList();
                  this.salaries = new Salaries();
                  this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
                  List var31 = this.salariesDao.chargerlesSalariesActif("*", var6);
                  if (var31.size() != 0) {
                     var32 = 0;

                     while(true) {
                        if (var32 >= var31.size()) {
                           var6.flush();
                           break;
                        }

                        this.salaries = (Salaries)var31.get(var32);
                        this.var_info = "Salarie: " + var32;
                        if (var32 != 0) {
                           var16 = (double)var9.size();
                           double var18 = var4.myRound(var16 / (double)var32, 4);
                           double var20 = var4.myRound(100.0D / var18, 2);
                           this.var_currentValue = (int)var20;
                        }

                        this.salariesContrats = null;

                        for(int var33 = 0; var33 < var8.size(); ++var33) {
                           if (((SalariesContrats)var8.get(var33)).getSalaries().getSalId() == this.salaries.getSalId()) {
                              this.salariesContrats = (SalariesContrats)var8.get(var33);
                              break;
                           }
                        }

                        if (this.salariesContrats != null) {
                           this.salaries = this.salariesDao.pourParapheur(this.salaries.getSalId(), var6);
                           if (this.salaries != null) {
                              this.salaries.setSalActivite(this.salariesContrats.getSalconActivite());
                              this.salaries.setSalBudget(this.salariesContrats.getSalconBudget());
                              this.salaries.setSalCentresImpots(this.salariesContrats.getSalconCentresImpots());
                              this.salaries.setSalCentresSecurite(this.salariesContrats.getSalconCentresSecurite());
                              this.salaries.setSalClassement(this.salariesContrats.getSalconClassement());
                              this.salaries.setSalConvention(this.salariesContrats.getSalconConvention());
                              this.salaries.setSalDepartement(this.salariesContrats.getSalconDepartement());
                              this.salaries.setSalFeuille(this.salariesContrats.getSalconFeuille());
                              this.salaries.setSalFonction(this.salariesContrats.getSalconFonction());
                              this.salaries.setSalGrille(this.salariesContrats.getSalconGrille());
                              this.salaries.setSalLibCentresImpots(this.salariesContrats.getSalconLibCentresImpots());
                              this.salaries.setSalLibCentresSecurite(this.salariesContrats.getSalconLibCentresSecurite());
                              this.salaries.setSalLibClassement(this.salariesContrats.getSalconLibClassement());
                              this.salaries.setSalLibConvention(this.salariesContrats.getSalconLibConvention());
                              this.salaries.setSalLibGrille(this.salariesContrats.getSalconLibGrille());
                              this.salaries.setSalLibNivEmploi(this.salariesContrats.getSalconLibNivEmploi());
                              this.salaries.setSalLibService(this.salariesContrats.getSalconLibService());
                              this.salaries.setSalNature(this.salariesContrats.getSalconType());
                              this.salaries.setSalNivEmploi(this.salariesContrats.getSalconNivEmploi());
                              this.salaries.setSalParc(this.salariesContrats.getSalconParc());
                              this.salaries.setSalService(this.salariesContrats.getSalconService());
                              this.salaries.setSalSite(this.salariesContrats.getSalconSite());
                              this.salariesDao.modif(this.salaries, var6);
                           }
                        }

                        ++var32;
                     }
                  }
               }

               var7.commit();
            } catch (HibernateException var25) {
               if (var7 != null) {
                  var7.rollback();
               }

               throw var25;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculNumeroSemaineCP() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des numeros de semaine es CP");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des absences et des conges/absences...";
      new ArrayList();
      SalariesCongesDao var3 = new SalariesCongesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerTous((Session)null);
      UtilNombre var4 = new UtilNombre();
      Calendar var5 = Calendar.getInstance();
      if (var2.size() != 0) {
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();
            new SalariesConges();

            for(int var9 = 0; var9 < var2.size(); ++var9) {
               SalariesConges var8 = (SalariesConges)var2.get(var9);
               this.var_info = "Element: " + var8.getSalaries().getSalMatricule();
               if (var9 != 0) {
                  double var10 = (double)var2.size();
                  double var12 = var4.myRound(var10 / (double)var9, 4);
                  double var14 = var4.myRound(100.0D / var12, 2);
                  this.var_currentValue = (int)var14;
               }

               if (var8.getSalcngDateDebut() != null) {
                  var5.setMinimalDaysInFirstWeek(4);
                  var5.setTime(var8.getSalcngDateDebut());
                  var8.setSalcngSemaineDebut(var5.get(3));
                  if (var8.getSalcngSemaineDebut() >= 53) {
                     var8.setSalcngSemaineDebut(1);
                  }
               } else {
                  var8.setSalcngSemaineDebut(0);
               }

               if (var8.getSalcngDateFin() != null) {
                  var5.setMinimalDaysInFirstWeek(4);
                  var5.setTime(var8.getSalcngDateFin());
                  var8.setSalcngSemaineFin(var5.get(3));
                  if (var8.getSalcngSemaineFin() >= 53) {
                     var8.setSalcngSemaineFin(1);
                  }
               } else {
                  var8.setSalcngSemaineFin(0);
               }

               var3.modif(var8, var6);
            }

            var6.flush();
            var7.commit();
         } catch (HibernateException var19) {
            if (var7 != null) {
               var7.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void generationSalairesUsers() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("génération des salariés en USERS");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des groupes et des salariés...";
      Object var2 = new ArrayList();
      String var3 = "";
      new ArrayList();
      GroupeDao var5 = new GroupeDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.selectGroupe((Session)null);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((Groupe)var4.get(var6)).getGrpModulePay() == 2) {
               var3 = ((Groupe)var4.get(var6)).getGrpCode();
               break;
            }
         }

         this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
         var2 = this.salariesDao.chargerlesSalariesActif((Session)null);
      }

      UtilNombre var21 = new UtilNombre();
      if (((List)var2).size() != 0 && var3 != null && !var3.isEmpty()) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();
            this.salaries = new Salaries();

            for(int var9 = 0; var9 < ((List)var2).size(); ++var9) {
               this.salaries = (Salaries)((List)var2).get(var9);
               this.var_info = "Element: " + this.salaries.getSalMatricule();
               if (var9 != 0) {
                  double var10 = (double)((List)var2).size();
                  double var12 = var21.myRound(var10 / (double)var9, 4);
                  double var14 = var21.myRound(100.0D / var12, 2);
                  this.var_currentValue = (int)var14;
               }

               new Users();
               Users var22 = this.userDao.selectByIdUsers(this.salaries.getSalId(), var7);
               if (var22 == null) {
                  var22 = new Users();
                  var22.setUsrNom(this.salaries.getSalNom());
                  var22.setUsrPrenom(this.salaries.getSalPrenom());
                  var22.setUsrCivilite(this.salaries.getSalCivilite());
                  var22.setUsrFonction(this.salaries.getSalFonction());
                  var22.setUsrCollaboration(var3);
                  var22.setUsrIdSalarieGuest(this.salaries.getSalId());
                  this.userDao.insert(var22, var7);
               }
            }

            var7.flush();
            var8.commit();
         } catch (HibernateException var19) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recopieNatureSalaireContrat() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recopie nature salarié dans nature contrat");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des salaries et des contrats...";
      new ArrayList();
      this.salariesContrats = new SalariesContrats();
      this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      List var3 = this.salariesContratsDao.chargerlesContrats((Session)null);
      if (var3.size() != 0) {
         new ArrayList();
         this.salaries = new Salaries();
         this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
         List var4 = this.salariesDao.chargerlesSalariesActif("***", (Session)null);
         if (var4.size() != 0) {
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var6 = null;

            try {
               var6 = var5.beginTransaction();

               for(int var7 = 0; var7 < var4.size(); ++var7) {
                  this.salaries = (Salaries)var4.get(var7);
                  this.var_info = "Salarie: " + this.salaries.getSalMatricule() + " " + this.salaries.getPatronyme();
                  if (var7 != 0) {
                     double var8 = (double)var4.size();
                     double var10 = var2.myRound(var8 / (double)var7, 4);
                     double var12 = var2.myRound(100.0D / var10, 2);
                     this.var_currentValue = (int)var12;
                  }

                  if (this.salaries.getSalNature() != null && !this.salaries.getSalNature().isEmpty()) {
                     for(int var19 = 0; var19 < var3.size(); ++var19) {
                        this.salariesContrats = (SalariesContrats)var3.get(var19);
                        if (this.salariesContrats.getSalaries() != null && this.salariesContrats.getSalaries().getSalId() == this.salaries.getSalId()) {
                           this.salariesContrats.setSalconType(this.salaries.getSalNature());
                           this.salariesContrats.setSalaries(this.salaries);
                           this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var5);
                        }
                     }
                  }
               }

               var6.commit();
            } catch (HibernateException var17) {
               if (var6 != null) {
                  var6.rollback();
               }

               throw var17;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculBaseConventionneeContrat() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul base conventionnée dans contrat");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des contrats...";
      new ArrayList();
      this.salariesContrats = new SalariesContrats();
      this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      List var3 = this.salariesContratsDao.chargerlesContrats((Session)null);
      if (var3.size() != 0) {
         LectureGrilleSalaire var4 = new LectureGrilleSalaire();
         var4.setStructureLog(this.structureLog);
         Object var5 = new ArrayList();
         new ObjetGrilleSalaire();
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();

            for(int var9 = 0; var9 < var3.size(); ++var9) {
               this.salariesContrats = (SalariesContrats)var3.get(var9);
               this.salaries = this.salariesContrats.getSalaries();
               this.var_info = "Salarie: " + this.salariesContrats.getSalaries().getSalMatricule();
               if (var9 != 0) {
                  double var10 = (double)var3.size();
                  double var12 = var2.myRound(var10 / (double)var9, 4);
                  double var14 = var2.myRound(100.0D / var12, 2);
                  this.var_currentValue = (int)var14;
               }

               boolean var21 = true;
               if (this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty() && this.salariesContrats.getSalconGrille() != null && !this.salariesContrats.getSalconGrille().isEmpty()) {
                  ((List)var5).clear();
                  var4.recuperePaye(this.salariesContrats.getSalconConvention());
                  var5 = var4.getMesGrillesSalaires();
                  if (((List)var5).size() != 0) {
                     for(int var11 = 0; var11 < ((List)var5).size(); ++var11) {
                        ObjetGrilleSalaire var6 = (ObjetGrilleSalaire)((List)var5).get(var11);
                        if (this.salariesContrats.getSalconGrille().equals(var6.getCode())) {
                           var21 = false;
                           this.salariesContrats.setSalconLibGrille(var6.getLib_FR());
                           if (this.salariesContrats.getSalconType() != null && !this.salariesContrats.getSalconType().isEmpty() && (this.salariesContrats.getSalconType().equals("03D") || this.salariesContrats.getSalconType().equals("03I"))) {
                              this.salariesContrats.setSalconBase((double)var6.getVal_heure());
                           } else if (this.salariesContrats.getSalconType() == null || this.salariesContrats.getSalconType().isEmpty() || !this.salariesContrats.getSalconType().equals("01D") && !this.salariesContrats.getSalconType().equals("01I") && !this.salariesContrats.getSalconType().equals("02D") && !this.salariesContrats.getSalconType().equals("02I")) {
                              this.salariesContrats.setSalconBase((double)var6.getVal_mois());
                           } else {
                              this.salariesContrats.setSalconBase((double)var6.getVal_mois());
                           }

                           this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var7);
                           break;
                        }
                     }
                  }
               }

               if (var21) {
                  this.salariesContrats.setSalconLibGrille("ERREUR");
                  this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var7);
               }

               this.salaries.setSalGrille(this.salariesContrats.getSalconGrille());
               this.salaries.setSalLibGrille(this.salariesContrats.getSalconLibGrille());
               this.salaries.setSalConvention(this.salariesContrats.getSalconConvention());
               this.salaries.setSalLibConvention(this.salariesContrats.getSalconLibConvention());
               this.salaries = this.salariesDao.modif(this.salaries, var7);
            }

            var8.commit();
         } catch (HibernateException var19) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void preparationSaisieTurbo() throws HibernateException, NamingException {
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      this.dataModelBulletinsLigne = new ListDataModel();
      this.lesBulletinLignes = new ArrayList();
      this.lesContratItems = new ArrayList();
      this.lesContratItems.add(new SelectItem(0, "Sélection Cobtrat"));
      this.lesSalarieItems = new ArrayList();
      this.lesSalarieItems = this.salariesDao.chargerlesSalariesActifItem("*", (Session)null);
      this.valideBulletin = false;
   }

   public void contratsSalaries() throws HibernateException, NamingException {
      this.lesContratItems.clear();
      this.salaries = new Salaries();
      this.salaries = this.salariesDao.chercherIdSalaries(this.var_salarie, (Session)null);
      if (this.salaries != null) {
         this.lesContratItems = this.salariesContratsDao.chargerlesContratsBySalaries(this.salaries, (Session)null);
      } else {
         this.lesContratItems.add(new SelectItem(0, "Sélection Contrat"));
      }

   }

   public void rechercherBulletin() throws HibernateException, NamingException {
      if (this.var_salarie != 0L && this.var_contrat != 0L && this.var_date_deb != null && this.var_date_fin != null) {
         String var1 = "";
         String var2 = "";
         if (this.var_date_fin.getMonth() + 1 <= 9) {
            var2 = "0" + (this.var_date_fin.getMonth() + 1);
         } else {
            var2 = "" + (this.var_date_fin.getMonth() + 1);
         }

         String var3 = "" + (this.var_date_fin.getYear() + 1900);
         var1 = var2 + ":" + var3;
         this.salaries = new Salaries();
         this.salaries = this.salariesDao.chercherIdSalaries(this.var_salarie, (Session)null);
         if (this.salaries != null) {
            this.salariesContrats = new SalariesContrats();
            this.salariesContrats = this.salariesContratsDao.pourParapheur(this.var_contrat, (Session)null);
            if (this.salariesContrats != null) {
               this.bulletinSalaire = new BulletinSalaire();
               BulletinSalaireDao var4 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
               BulletinLigneDao var5 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
               this.bulletinLigne = new BulletinLigne();
               this.bulletinSalaire = var4.rechercheBulletinSalariePeriode(this.salaries.getSalMatricule(), this.salariesContrats.getSalconNum(), var1, (Session)null);
               boolean var6 = false;
               this.lesBulletinLignes.clear();
               if (this.bulletinSalaire != null) {
                  this.lesBulletinLignes = var5.chargerleslignesBulletin(this.bulletinSalaire, (Session)null);
                  var6 = true;
               } else {
                  this.bulletinSalaire = new BulletinSalaire();
               }

               new ArrayList();
               FeuilleCalculRubriqueDao var8 = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
               List var7 = var8.chargerRubriqueFeuilleActive((String)this.salariesContrats.getSalconFeuille(), 0L, (Session)null);
               if (var7.size() != 0) {
                  new FeuilleCalculRubrique();

                  for(int var10 = 0; var10 < var7.size(); ++var10) {
                     FeuilleCalculRubrique var9 = (FeuilleCalculRubrique)var7.get(var10);
                     if (this.lesBulletinLignes.size() == 0) {
                        var6 = false;
                     } else {
                        var6 = false;

                        for(int var11 = 0; var11 < this.lesBulletinLignes.size(); ++var11) {
                           if (((BulletinLigne)this.lesBulletinLignes.get(var11)).getBulligRubrique().equals(var9.getFeurubCode())) {
                              var6 = true;
                              break;
                           }
                        }
                     }

                     if (!var6) {
                        this.bulletinLigne = new BulletinLigne();
                        this.bulletinLigne.setBulligAffColA(var9.isFeurubColA());
                        this.bulletinLigne.setBulligAffColB(var9.isFeurubColB());
                        this.bulletinLigne.setBulligAffColC(var9.isFeurubColC());
                        this.bulletinLigne.setBulligAffColD(var9.isFeurubColD());
                        this.bulletinLigne.setBulligAffColE(var9.isFeurubColE());
                        this.bulletinLigne.setBulligLibelle(var9.getPlanPaye().getPlpLibelleFR());
                        this.bulletinLigne.setBulligRubrique(var9.getFeurubCode());
                        this.bulletinLigne.setBulligSens(var9.getPlanPaye().getPlpSens());
                        this.bulletinLigne.setBulligNature(var9.getPlanPaye().getPlpNature());
                        this.lesBulletinLignes.add(this.bulletinLigne);
                     }
                  }
               }

               this.dataModelBulletinsLigne.setWrappedData(this.lesBulletinLignes);
               this.valideBulletin = true;
            }
         }
      }

   }

   public void selectionligneBulletin() {
      if (this.dataModelBulletinsLigne.isRowAvailable()) {
         this.bulletinLigne = (BulletinLigne)this.dataModelBulletinsLigne.getRowData();
      }

   }

   public void calculeTotaux() {
      if (this.lesBulletinLignes.size() != 0) {
         double var1 = 0.0D;
         double var3 = 0.0D;
         double var5 = 0.0D;

         int var7;
         for(var7 = 0; var7 < this.lesBulletinLignes.size(); ++var7) {
            this.bulletinLigne = (BulletinLigne)this.lesBulletinLignes.get(var7);
            if (this.bulletinLigne.getBulligNature() < 50) {
               var1 += this.bulletinLigne.getBulligValColE();
            }

            if (this.bulletinLigne.getBulligNature() < 50 || this.bulletinLigne.getBulligNature() >= 60 && this.bulletinLigne.getBulligNature() <= 68) {
               var3 += this.bulletinLigne.getBulligValColE();
            }

            if (this.bulletinLigne.getBulligNature() < 50 || this.bulletinLigne.getBulligNature() >= 60 && this.bulletinLigne.getBulligNature() <= 68 || this.bulletinLigne.getBulligNature() >= 70 && this.bulletinLigne.getBulligNature() <= 88) {
               var5 += this.bulletinLigne.getBulligValColE();
            }
         }

         for(var7 = 0; var7 < this.lesBulletinLignes.size(); ++var7) {
            this.bulletinLigne = (BulletinLigne)this.lesBulletinLignes.get(var7);
            if (this.bulletinLigne.getBulligNature() == 59) {
               this.bulletinLigne.setBulligValColE(var1);
            } else if (this.bulletinLigne.getBulligNature() == 69) {
               this.bulletinLigne.setBulligValColE(var3);
            } else if (this.bulletinLigne.getBulligNature() == 89) {
               this.bulletinLigne.setBulligValColE(var5);
            }
         }

         this.dataModelBulletinsLigne.setWrappedData(this.lesBulletinLignes);
      }

   }

   public void enregistrerBulletin() throws HibernateException, NamingException {
      if (this.var_salarie != 0L && this.var_contrat != 0L && this.var_date_deb != null && this.var_date_fin != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ExercicesPaye();
            this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
            ExercicesPaye var3 = this.exercicesPayeDao.recupererLastExo(var1);
            if (var3 != null) {
               BulletinSalaireDao var4 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
               BulletinLigneDao var5 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
               String var6 = "";
               String var7 = "";
               if (this.var_date_fin.getMonth() + 1 <= 9) {
                  var7 = "0" + (this.var_date_fin.getMonth() + 1);
               } else {
                  var7 = "" + (this.var_date_fin.getMonth() + 1);
               }

               String var8 = "" + (this.var_date_fin.getYear() + 1900);
               var6 = var7 + ":" + var8;
               if (this.bulletinSalaire.getBulsalId() != 0L) {
                  this.bulletinSalaire = var4.modif(this.bulletinSalaire, var1);
               } else {
                  this.bulletinSalaire.setExercicesPaye(var3);
                  this.bulletinSalaire.setSalaries(this.salaries);
                  this.bulletinSalaire.setBulsalActivite(this.salariesContrats.getSalconActivite());
                  this.bulletinSalaire.setBulsalCentresImpots(this.salariesContrats.getSalconCentresImpots());
                  this.bulletinSalaire.setBulsalCentresSecurite(this.salariesContrats.getSalconCentresSecurite());
                  this.bulletinSalaire.setBulsalCivilite(this.salaries.getSalCivilite());
                  this.bulletinSalaire.setBulsalClassement(this.salariesContrats.getSalconClassement());
                  this.bulletinSalaire.setBulsalCle1Anal(this.salariesContrats.getSalconCle1Anal());
                  this.bulletinSalaire.setBulsalCle2Anal(this.salariesContrats.getSalconCle2Anal());
                  this.bulletinSalaire.setBulsalCleBanque(this.salaries.getSalCleBanque());
                  this.bulletinSalaire.setBulsalCompteBanque(this.salaries.getSalCompteBanque());
                  this.bulletinSalaire.setBulsalContrat(this.salariesContrats.getSalconNum());
                  this.bulletinSalaire.setBulsalConvention(this.salariesContrats.getSalconConvention());
                  this.bulletinSalaire.setBulsalDateDebut(this.var_date_deb);
                  this.bulletinSalaire.setBulsalDateFin(this.var_date_fin);
                  this.bulletinSalaire.setBulsalDateentree(this.salariesContrats.getSalconDateDebut());
                  this.bulletinSalaire.setBulsalDepartement(this.salariesContrats.getSalconDepartement());
                  this.bulletinSalaire.setBulsalFeuille(this.salariesContrats.getSalconFeuille());
                  this.bulletinSalaire.setBulsalFonction(this.salariesContrats.getSalconFonction());
                  this.bulletinSalaire.setBulsalGenre(this.salaries.getSalGenre());
                  this.bulletinSalaire.setBulsalGrille(this.salariesContrats.getSalconGrille());
                  this.bulletinSalaire.setBulsalGuichetBanque(this.salaries.getSalGuichetBanque());
                  this.bulletinSalaire.setBulsalIban(this.salaries.getSalIban());
                  this.bulletinSalaire.setBulsalLibCentresImpots(this.salariesContrats.getSalconLibCentresImpots());
                  this.bulletinSalaire.setBulsalLibCentresSecurite(this.salariesContrats.getSalconLibCentresSecurite());
                  this.bulletinSalaire.setBulsalLibClassement(this.salariesContrats.getSalconLibClassement());
                  this.bulletinSalaire.setBulsalLibConvention(this.salariesContrats.getSalconLibConvention());
                  this.bulletinSalaire.setBulsalLibGrille(this.salariesContrats.getSalconLibGrille());
                  this.bulletinSalaire.setBulsalLibNivEmploi(this.salariesContrats.getSalconLibNivEmploi());
                  this.bulletinSalaire.setBulsalLibService(this.salariesContrats.getSalconLibService());
                  this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                  this.bulletinSalaire.setBulsalNature(this.salaries.getSalNature());
                  this.bulletinSalaire.setBulsalNbEnfant(this.salaries.getSalNbEnfant());
                  this.bulletinSalaire.setBulsalNbFemme(this.salaries.getSalNbFemme());
                  this.bulletinSalaire.setBulsalNbPartFiscal(this.salaries.getSalNbPartFiscal());
                  this.bulletinSalaire.setBulsalNbPartTrimf(this.salaries.getSalNbPartTrimf());
                  this.bulletinSalaire.setBulsalNivEmploi(this.salariesContrats.getSalconNivEmploi());
                  this.bulletinSalaire.setBulsalNumBanque(this.salaries.getSalNumBanque());
                  this.bulletinSalaire.setBulsalParc(this.salariesContrats.getSalconParc());
                  this.bulletinSalaire.setBulsalPeriode(var6);
                  this.bulletinSalaire.setBulsalProjet(this.salariesContrats.getSalconProjet());
                  this.bulletinSalaire.setBulsalService(this.salariesContrats.getSalconService());
                  this.bulletinSalaire.setBulsalSitFamille(this.salaries.getSalSitFamille());
                  this.bulletinSalaire.setBulsalSite(this.salariesContrats.getSalconSite());
                  this.bulletinSalaire.setBulsalSwift(this.salaries.getSalSwift());
                  this.bulletinSalaire.setBulsalUserCreat(this.usersLog.getUsrid());
                  float var9 = 0.0F;
                  double var10 = 0.0D;
                  double var12 = 0.0D;
                  double var14 = 0.0D;
                  double var16 = 0.0D;
                  double var18 = 0.0D;
                  double var20 = 0.0D;
                  double var22 = 0.0D;
                  double var24 = 0.0D;
                  double var26 = 0.0D;
                  double var28 = 0.0D;
                  double var30 = 0.0D;
                  double var32 = 0.0D;
                  double var34 = 0.0D;
                  float var36 = 0.0F;
                  float var37 = 0.0F;
                  float var38 = 0.0F;
                  double var39 = 0.0D;
                  double var41 = 0.0D;
                  if (this.lesBulletinLignes.size() != 0) {
                     BulletinLigne var43 = new BulletinLigne();

                     for(int var44 = 0; var44 < this.lesBulletinLignes.size(); ++var44) {
                        if (var43.getBulligNature() == 50) {
                           if (var43.getBulletinSalaire().getBulsalId() == this.bulletinSalaire.getBulsalId()) {
                              var10 += var43.getBulligValColE();
                           }
                        } else if (var43.getBulligNature() == 59) {
                           if (var43.getBulletinSalaire().getBulsalId() == this.bulletinSalaire.getBulsalId()) {
                              var41 = var43.getBulligValColE();
                           }
                        } else if (var43.getBulligNature() == 40) {
                           if (var43.getBulletinSalaire().getBulsalId() == this.bulletinSalaire.getBulsalId()) {
                              var14 += var43.getBulligValColE();
                           }

                           if (var43.getBulligRubrique().startsWith("208000")) {
                              var37 = (float)((double)var37 + var43.getBulligValColD());
                           }
                        } else if (var43.getBulligNature() == 89) {
                           if (var43.getBulletinSalaire().getBulsalId() == this.bulletinSalaire.getBulsalId()) {
                              var39 += var43.getBulligValColE();
                           }
                        } else if (var43.getBulligRubrique() != null && !var43.getBulligRubrique().isEmpty() && !this.structureLog.getStrcodepays().equals("0041") && !this.structureLog.getStrcodepays().equals("0056")) {
                           if (this.structureLog.getStrcodepays().equals("0077")) {
                              if (var43.getBulligRubrique().equals("100000")) {
                                 var9 = (float)((double)var9 + var43.getBulligValColD());
                              } else if (var43.getBulligRubrique().equals("100050")) {
                                 var9 = (float)((double)var9 - var43.getBulligValColD());
                              } else if (var43.getBulligRubrique().startsWith("300000")) {
                                 var16 += var43.getBulligValColE();
                              } else if (var43.getBulligRubrique().startsWith("300020")) {
                                 var18 += var43.getBulligValColE();
                              } else if (var43.getBulligRubrique().startsWith("300100")) {
                                 var20 += var43.getBulligValColE();
                              } else if (var43.getBulligRubrique().startsWith("300200")) {
                                 var22 += var43.getBulligValColE();
                              } else {
                                 var24 = 0.0D;
                                 var26 = 0.0D;
                                 var28 = 0.0D;
                                 var30 = 0.0D;
                                 var32 = 0.0D;
                                 var34 = 0.0D;
                              }
                           } else if (this.structureLog.getStrcodepays().equals("0138")) {
                              if (var43.getBulligRubrique().equals("100000")) {
                                 var9 = (float)((double)var9 + var43.getBulligValColD());
                              } else if (var43.getBulligRubrique().equals("100050")) {
                                 var9 = (float)((double)var9 - var43.getBulligValColD());
                              } else if (var43.getBulligRubrique().startsWith("300010")) {
                                 var16 += var43.getBulligValColE();
                              } else if (!var43.getBulligRubrique().startsWith("300020") && !var43.getBulligRubrique().startsWith("300021") && !var43.getBulligRubrique().startsWith("300022") && !var43.getBulligRubrique().startsWith("300023") && !var43.getBulligRubrique().startsWith("300024") && !var43.getBulligRubrique().startsWith("300025") && !var43.getBulligRubrique().startsWith("300026") && !var43.getBulligRubrique().startsWith("300027") && !var43.getBulligRubrique().startsWith("300028") && !var43.getBulligRubrique().startsWith("300029")) {
                                 if (var43.getBulligRubrique().startsWith("300220")) {
                                    var20 += var43.getBulligValColE();
                                 } else if (var43.getBulligRubrique().startsWith("900020")) {
                                    var22 += var43.getBulligValColE();
                                 } else if (!var43.getBulligRubrique().startsWith("900040") && !var43.getBulligRubrique().startsWith("900041") && !var43.getBulligRubrique().startsWith("900042") && !var43.getBulligRubrique().startsWith("900043") && !var43.getBulligRubrique().startsWith("900044") && !var43.getBulligRubrique().startsWith("900045") && !var43.getBulligRubrique().startsWith("900046") && !var43.getBulligRubrique().startsWith("900047") && !var43.getBulligRubrique().startsWith("900048") && !var43.getBulligRubrique().startsWith("900049")) {
                                    var26 = 0.0D;
                                    var28 = 0.0D;
                                    var30 = 0.0D;
                                    var32 = 0.0D;
                                    var34 = 0.0D;
                                 } else {
                                    var24 += var43.getBulligValColE();
                                 }
                              } else {
                                 var18 += var43.getBulligValColE();
                              }
                           } else if (this.structureLog.getStrcodepays().equals("0202")) {
                              if (var43.getBulligRubrique().equals("100000")) {
                                 var9 = (float)((double)var9 + var43.getBulligValColD());
                              } else if (var43.getBulligRubrique().equals("100050")) {
                                 var9 = (float)((double)var9 - var43.getBulligValColD());
                              } else if (!var43.getBulligRubrique().startsWith("300000") && !var43.getBulligRubrique().startsWith("300010") && !var43.getBulligRubrique().startsWith("300020")) {
                                 if (var43.getBulligRubrique().startsWith("300100")) {
                                    var18 += var43.getBulligValColE();
                                 } else if (!var43.getBulligRubrique().startsWith("300200") && !var43.getBulligRubrique().startsWith("300220")) {
                                    if (var43.getBulligRubrique().startsWith("300300")) {
                                       var22 += var43.getBulligValColE();
                                    } else {
                                       var24 = 0.0D;
                                       var26 = 0.0D;
                                       var28 = 0.0D;
                                       var30 = 0.0D;
                                       var32 = 0.0D;
                                       var34 = 0.0D;
                                    }
                                 } else {
                                    var20 += var43.getBulligValColE();
                                 }
                              } else {
                                 var16 += var43.getBulligValColE();
                              }
                           } else if (var43.getBulligRubrique().equals("100000")) {
                              var9 = (float)((double)var9 + var43.getBulligValColD());
                           } else if (var43.getBulligRubrique().equals("100050")) {
                              var9 = (float)((double)var9 - var43.getBulligValColD());
                           } else {
                              var16 = 0.0D;
                              var18 = 0.0D;
                              var20 = 0.0D;
                              var22 = 0.0D;
                              var24 = 0.0D;
                              var26 = 0.0D;
                              var28 = 0.0D;
                              var30 = 0.0D;
                              var32 = 0.0D;
                              var34 = 0.0D;
                           }
                        }
                     }
                  }

                  this.bulletinSalaire.setBulsalAvNat(var10);
                  this.bulletinSalaire.setBulsalBaseImposableFiscale(0.0D);
                  this.bulletinSalaire.setBulsalBaseImposableSociale(0.0D);
                  this.bulletinSalaire.setBulsalImpot1(var16);
                  this.bulletinSalaire.setBulsalImpot2(var18);
                  this.bulletinSalaire.setBulsalImpot3(var20);
                  this.bulletinSalaire.setBulsalImpot4(var22);
                  this.bulletinSalaire.setBulsalImpot5(var24);
                  this.bulletinSalaire.setBulsalImpot6(var26);
                  this.bulletinSalaire.setBulsalImpot7(var28);
                  this.bulletinSalaire.setBulsalImpot8(var30);
                  this.bulletinSalaire.setBulsalImpot9(var32);
                  this.bulletinSalaire.setBulsalImpot10(var34);
                  this.bulletinSalaire = var4.insert(this.bulletinSalaire, var1);
               }

               if (this.lesBulletinLignes.size() != 0) {
                  this.bulletinLigne = new BulletinLigne();

                  for(int var50 = 0; var50 < this.lesBulletinLignes.size(); ++var50) {
                     this.bulletinLigne = (BulletinLigne)this.lesBulletinLignes.get(var50);
                     if (this.bulletinLigne.getBulligValColE() != 0.0D) {
                        if (this.bulletinLigne.getBulligId() == 0L) {
                           this.bulletinLigne.setExercicesPaye(var3);
                           this.bulletinLigne.setBulletinSalaire(this.bulletinSalaire);
                           this.bulletinLigne.setSalaries(this.salaries);
                           this.bulletinLigne = var5.insert(this.bulletinLigne, var1);
                        } else {
                           this.bulletinLigne = var5.modif(this.bulletinLigne, var1);
                        }
                     } else if (this.bulletinLigne.getBulligId() != 0L) {
                        var5.delete(this.bulletinLigne, var1);
                     }
                  }
               }

               var2.commit();
            }
         } catch (HibernateException var48) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var48;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.lesBulletinLignes.clear();
      this.dataModelBulletinsLigne.setWrappedData(this.lesBulletinLignes);
      this.valideBulletin = false;
   }

   public void geneationContratSalaries() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("génération contrat à partir des salariés");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des salariés...";
      Utilitaires_Paye var3 = new Utilitaires_Paye();
      this.salaries = new Salaries();
      new ArrayList();
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      List var4 = this.salariesDao.chargerlesSalariesActif((Session)null);
      this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      if (var4.size() != 0) {
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();

            for(int var8 = 0; var8 < var4.size(); ++var8) {
               this.salaries = (Salaries)var4.get(var8);
               this.var_info = "Salarie: " + this.salaries.getSalMatricule();
               if (var8 != 0) {
                  double var9 = (double)var4.size();
                  double var11 = var2.myRound(var9 / (double)var8, 4);
                  double var13 = var2.myRound(100.0D / var11, 2);
                  this.var_currentValue = (int)var13;
               }

               List var5 = this.salariesContratsDao.chargerlesContrats(this.salaries, var6);
               if (var5.size() == 0) {
                  this.salariesContrats = new SalariesContrats();
                  var3.geneationContratSalaries(false, this.salaries, this.salariesContrats, this.salariesContratsDao, this.usersLog, var6);
               } else {
                  this.salariesContrats = (SalariesContrats)var5.get(0);
                  var3.geneationContratSalaries(true, this.salaries, this.salariesContrats, this.salariesContratsDao, this.usersLog, var6);
               }
            }

            var7.commit();
         } catch (HibernateException var18) {
            if (var7 != null) {
               var7.rollback();
            }

            throw var18;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public String filtreNumerique(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("1234567890.".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         }
      }

      return var2;
   }

   public void recalculSecuCNSSAMO() throws NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul n° SECU, CNSS, AMO, CNAMGS...dans les buletins");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des bulletins de salaire...";
      this.salaries = new Salaries();
      this.bulletinSalaire = new BulletinSalaire();
      new ArrayList();
      BulletinSalaireDao var4 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      List var3 = var4.chargerlesBulletinsDate(this.var_date_deb, this.var_date_fin, (Session)null);
      if (var3.size() != 0) {
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var6 = null;

         try {
            var6 = var5.beginTransaction();

            for(int var7 = 0; var7 < var3.size(); ++var7) {
               this.bulletinSalaire = (BulletinSalaire)var3.get(var7);
               this.salaries = this.bulletinSalaire.getSalaries();
               this.var_info = "Salarie: " + this.salaries.getSalMatricule();
               if (var7 != 0) {
                  double var8 = (double)var3.size();
                  double var10 = var2.myRound(var8 / (double)var7, 4);
                  double var12 = var2.myRound(100.0D / var10, 2);
                  this.var_currentValue = (int)var12;
               }

               this.bulletinSalaire.setBulsalSecu1(this.salaries.getSalNumSecu());
               if (this.structureLog.getStrcodepays().equals("0077")) {
                  this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumCnamgs());
               } else if (this.structureLog.getStrcodepays().equals("0138")) {
                  this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumAmo());
               } else {
                  this.bulletinSalaire.setBulsalSecu2("");
               }

               this.bulletinSalaire = var4.modif(this.bulletinSalaire, var5);
            }

            var6.commit();
         } catch (HibernateException var17) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculCompteursConges() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("reclacul des compteurs des congés");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des salariés...";
      Utilitaires_Paye var3 = new Utilitaires_Paye();
      new ExercicesPaye();
      this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      ExercicesPaye var4 = this.exercicesPayeDao.recupererLastExo((Session)null);
      if (var4 != null) {
         this.salaries = new Salaries();
         new ArrayList();
         this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
         this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         List var5 = this.salariesDao.chargerlesSalariesActif((Session)null);
         SalariesHistoriqueDao var6 = new SalariesHistoriqueDao(this.baseLog, this.utilInitHibernate);
         SalariesCongesDao var7 = new SalariesCongesDao(this.baseLog, this.utilInitHibernate);
         BulletinSalaireDao var8 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         BulletinLigneDao var9 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
         if (var5.size() != 0) {
            Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var11 = null;

            try {
               var11 = var10.beginTransaction();
               var10.setFlushMode(FlushMode.MANUAL);

               for(int var12 = 0; var12 < var5.size(); ++var12) {
                  this.salaries = (Salaries)var5.get(var12);
                  this.var_info = "Salarie: " + this.salaries.getSalMatricule();
                  if (var12 != 0) {
                     double var13 = (double)var5.size();
                     double var15 = var2.myRound(var13 / (double)var12, 4);
                     double var17 = var2.myRound(100.0D / var15, 2);
                     this.var_currentValue = (int)var17;
                  }

                  var3.recalculCompteursConges(var2, var8, var6, var9, var7, this.salariesContratsDao, this.salaries, this.optionPaye, var4, this.baseLog, this.structureLog, this.utilInitHibernate, var10);
               }

               var11.commit();
            } catch (HibernateException var22) {
               if (var11 != null) {
                  var11.rollback();
               }

               throw var22;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculPlanPayeBulletin() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul plan de pays dans lignes de bulletin");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des elements...";
      new ArrayList();
      new PlanPaye();
      PlanPayeDao var5 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      this.bulletinLigne = new BulletinLigne();
      BulletinLigneDao var7 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      new ExercicesPaye();
      ExercicesPaye var8 = this.exercicesPayeDao.recupererLastExo((Session)null);
      if (var8 != null) {
         Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var10 = null;

         try {
            var10 = var9.beginTransaction();
            List var6 = var7.chargerLigneBulletins(this.var_date_deb, this.var_date_fin, var9);
            if (var6.size() != 0) {
               List var3 = var5.chargerPlanPaye(var8.getExepayId(), var9);
               if (var3.size() != 0) {
                  for(int var11 = 0; var11 < var3.size(); ++var11) {
                     PlanPaye var4 = (PlanPaye)var3.get(var11);
                     this.var_info = "Rubrique: " + var4.getPlpCode();
                     if (var11 != 0) {
                        double var12 = (double)var3.size();
                        double var14 = var2.myRound(var12 / (double)var11, 4);
                        double var16 = var2.myRound(100.0D / var14, 2);
                        this.var_currentValue = (int)var16;
                     }

                     for(int var23 = 0; var23 < var6.size(); ++var23) {
                        this.bulletinLigne = (BulletinLigne)var6.get(var23);
                        if (this.bulletinLigne.getBulligRubrique().equals(var4.getPlpCode())) {
                           this.bulletinLigne.setBulligBaseFiscale(var4.isPlpBaseFiscale());
                           this.bulletinLigne.setBulligBaseSociale(var4.isPlpBaseSociale());
                           this.bulletinLigne.setBulligBaseConges(var4.isPlpBaseConges());
                           this.bulletinLigne.setBulligBasePatronale(var4.isPlpBasePatronale());
                           this.bulletinLigne.setBulligBaseAutre(var4.isPlpBaseAutre());
                           this.bulletinLigne = var7.modif(this.bulletinLigne, var9);
                        }
                     }

                     var9.flush();
                  }
               }
            }

            var10.commit();
         } catch (HibernateException var21) {
            if (var10 != null) {
               var10.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculPlanPayeVariables() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul plan de pays dans variables");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des elements...";
      new ArrayList();
      PlanPaye var4 = new PlanPaye();
      PlanPayeDao var5 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new SalariesVariables();
      SalariesVariablesDao var8 = new SalariesVariablesDao(this.baseLog, this.utilInitHibernate);
      new ExercicesPaye();
      ExercicesPaye var9 = this.exercicesPayeDao.recupererLastExo((Session)null);
      if (var9 != null) {
         Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var11 = null;

         try {
            var11 = var10.beginTransaction();
            String var12 = "";
            String var13 = "" + var9.getExepayId();
            List var6 = var8.chargerlesVariablesByExercice(var13, var10);
            if (var6.size() != 0) {
               List var3 = var5.chargerPlanPaye(var9.getExepayId(), var10);
               if (var3.size() != 0) {
                  for(int var14 = 0; var14 < var6.size(); ++var14) {
                     SalariesVariables var7 = (SalariesVariables)var6.get(var14);
                     this.var_info = "Rubrique: " + var7.getSalvarCode();
                     if (var14 != 0) {
                        double var15 = (double)var6.size();
                        double var17 = var2.myRound(var15 / (double)var14, 4);
                        double var19 = var2.myRound(100.0D / var17, 2);
                        this.var_currentValue = (int)var19;
                     }

                     if (var12 != null && !var12.isEmpty() && var12.equals(var7.getSalvarCode()) && var7.getSalvarCode().equals(var4.getPlpCode())) {
                        var7.setPlanPaye(var4);
                        var7 = var8.modif(var7, var10);
                     } else {
                        for(int var26 = 0; var26 < var3.size(); ++var26) {
                           var4 = (PlanPaye)var3.get(var26);
                           if (var7.getSalvarCode().equals(var4.getPlpCode())) {
                              var7.setPlanPaye(var4);
                              var7 = var8.modif(var7, var10);
                              break;
                           }
                        }
                     }

                     var12 = var7.getSalvarCode();
                     var10.flush();
                  }
               }
            }

            var11.commit();
         } catch (HibernateException var24) {
            if (var11 != null) {
               var11.rollback();
            }

            throw var24;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recopieTiersSalaireContrat() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recopie tiers salarié dans contrat et bulletin");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des salaries et des contrats...";
      new ExercicesPaye();
      this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      ExercicesPaye var3 = this.exercicesPayeDao.recupererLastExo((Session)null);
      if (var3 != null) {
         new Site();
         SiteDao var5 = new SiteDao(this.baseLog, this.utilInitHibernate);
         new Service();
         ServiceDao var7 = new ServiceDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         this.bulletinSalaire = new BulletinSalaire();
         BulletinSalaireDao var9 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         this.salariesContrats = new SalariesContrats();
         this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         List var10 = this.salariesContratsDao.chargerlesContrats((Session)null);
         if (var10.size() != 0) {
            new ArrayList();
            this.salaries = new Salaries();
            this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
            List var11 = this.salariesDao.chargerlesSalariesActif("***", (Session)null);
            if (var11.size() != 0) {
               Session var12 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
               Transaction var13 = null;

               try {
                  var13 = var12.beginTransaction();

                  for(int var14 = 0; var14 < var11.size(); ++var14) {
                     this.salaries = (Salaries)var11.get(var14);
                     if (this.salaries.getSalService() != null && !this.salaries.getSalService().isEmpty()) {
                        if (this.rechercheModule(80400)) {
                           Site var4 = var5.rechercheSite(this.salaries.getSalService(), var12);
                           if (var4 != null) {
                              this.salaries.setSalLibService(var4.getSitNomFr());
                           } else {
                              this.salaries.setSalLibService("...");
                           }
                        } else {
                           Service var6 = var7.chargerLeServiceCode(this.salaries.getSalService(), var12);
                           if (var6 != null) {
                              this.salaries.setSalLibService(var6.getSerNomFr());
                           } else {
                              this.salaries.setSalLibService("...");
                           }
                        }
                     }

                     this.var_info = "Salarie: " + this.salaries.getSalMatricule() + " " + this.salaries.getPatronyme();
                     if (var14 != 0) {
                        double var15 = (double)var11.size();
                        double var17 = var2.myRound(var15 / (double)var14, 4);
                        double var19 = var2.myRound(100.0D / var17, 2);
                        this.var_currentValue = (int)var19;
                     }

                     int var26;
                     for(var26 = 0; var26 < var10.size(); ++var26) {
                        this.salariesContrats = (SalariesContrats)var10.get(var26);
                        if (this.salariesContrats.getSalaries() != null && this.salariesContrats.getSalaries().getSalId() == this.salaries.getSalId()) {
                           if (this.salaries.getSalIdTiers() != 0L) {
                              this.salariesContrats.setSalconIdTiers(this.salaries.getSalIdTiers());
                              this.salariesContrats.setSalconNomTiers(this.salaries.getSalNomTiers());
                           } else {
                              this.salariesContrats.setSalconIdTiers(0L);
                              this.salariesContrats.setSalconNomTiers((String)null);
                           }

                           this.salariesContrats.setSalconService(this.salaries.getSalService());
                           this.salariesContrats.setSalconLibService(this.salaries.getSalLibService());
                           this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var12);
                        }
                     }

                     List var8 = var9.chargerDernierBulletinsbySalarie(var3.getExepayId(), this.salaries, var3.getExepayDateFin(), var12);
                     if (var8.size() != 0) {
                        for(var26 = 0; var26 < var8.size(); ++var26) {
                           this.bulletinSalaire = (BulletinSalaire)var8.get(var26);
                           this.bulletinSalaire.setBulsalIdTiers(this.salaries.getSalIdTiers());
                           this.bulletinSalaire.setBulsalService(this.salaries.getSalService());
                           this.bulletinSalaire.setBulsalLibService(this.salaries.getSalLibService());
                           this.bulletinSalaire = var9.modif(this.bulletinSalaire, var12);
                        }
                     }
                  }

                  var13.commit();
               } catch (HibernateException var24) {
                  if (var13 != null) {
                     var13.rollback();
                  }

                  throw var24;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recopieInfoBulletin() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recopie infos salariés dans bulletins");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des salaries...";
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      var3.dateJourPrecedent(this.var_date_deb);
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var6 = null;

      try {
         var6 = var5.beginTransaction();
         int var7 = 0;
         this.salaries = new Salaries();
         new ArrayList();
         this.bulletinSalaire = new BulletinSalaire();
         BulletinSalaireDao var9 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         List var8 = var9.chargerlesBulletinsDate(this.var_date_deb, this.var_date_fin, var5);
         if (var8.size() != 0) {
            for(int var10 = 0; var10 < var8.size(); ++var10) {
               this.bulletinSalaire = (BulletinSalaire)var8.get(var10);
               this.salaries = this.bulletinSalaire.getSalaries();
               this.var_info = "Salarie: " + this.salaries.getSalMatricule() + " " + this.salaries.getPatronyme();
               if (var10 != 0) {
                  double var11 = (double)var8.size();
                  double var13 = var2.myRound(var11 / (double)var10, 4);
                  double var15 = var2.myRound(100.0D / var13, 2);
                  this.var_currentValue = (int)var15;
               }

               this.bulletinSalaire.setBulsalNature(this.salaries.getSalNature());
               this.bulletinSalaire.setBulsalEtat(this.salaries.getSalEtat());
               this.bulletinSalaire.setBulsalCivilite(this.salaries.getSalCivilite());
               this.bulletinSalaire.setBulsalFonction(this.salaries.getSalFonction());
               this.bulletinSalaire.setBulsalSite(this.salaries.getSalSite());
               this.bulletinSalaire.setBulsalDepartement(this.salaries.getSalDepartement());
               this.bulletinSalaire.setBulsalService(this.salaries.getSalService());
               this.bulletinSalaire.setBulsalLibService(this.salaries.getSalLibService());
               this.bulletinSalaire.setBulsalActivite(this.salaries.getSalActivite());
               this.bulletinSalaire.setBulsalBudget(this.salaries.getSalBudget());
               this.bulletinSalaire.setBulsalParc(this.salaries.getSalParc());
               this.bulletinSalaire.setBulsalGenre(this.salaries.getSalGenre());
               this.bulletinSalaire.setBulsalSitFamille(this.salaries.getSalSitFamille());
               this.bulletinSalaire.setBulsalNbEnfant(this.salaries.getSalNbEnfant());
               this.bulletinSalaire.setBulsalNbPartFiscal(this.salaries.getSalNbPartFiscal());
               this.bulletinSalaire.setBulsalNbFemme(this.salaries.getSalNbEnfant());
               this.bulletinSalaire.setBulsalNbPartTrimf(this.salaries.getSalNbPartTrimf());
               this.bulletinSalaire.setBulsalDateSortie(this.salaries.getSalDateSortie());
               this.bulletinSalaire.setBulsalMotifSortie(this.salaries.getSalMotifSortie());
               this.bulletinSalaire.setBulsalConvention(this.salaries.getSalConvention());
               this.bulletinSalaire.setBulsalLibConvention(this.salaries.getSalLibConvention());
               this.bulletinSalaire.setBulsalCentresImpots(this.salaries.getSalCentresImpots());
               this.bulletinSalaire.setBulsalLibCentresImpots(this.salaries.getSalCentresImpots());
               this.bulletinSalaire.setBulsalCentresSecurite(this.salaries.getSalCentresSecurite());
               this.bulletinSalaire.setBulsalLibCentresSecurite(this.salaries.getSalCentresSecurite());
               this.bulletinSalaire.setBulsalClassement(this.salaries.getSalClassement());
               this.bulletinSalaire.setBulsalLibClassement(this.salaries.getSalLibClassement());
               this.bulletinSalaire.setBulsalNivEmploi(this.salaries.getSalNivEmploi());
               this.bulletinSalaire.setBulsalLibNivEmploi(this.salaries.getSalLibNivEmploi());
               this.bulletinSalaire.setBulsalGrille(this.salaries.getSalGrille());
               this.bulletinSalaire.setBulsalCle1Anal(this.salaries.getSalCleAnal1());
               this.bulletinSalaire.setBulsalCle2Anal(this.salaries.getSalCleAnal2());
               this.bulletinSalaire.setBulsalModeReglement(this.salaries.getSalModeReglement());
               this.bulletinSalaire.setBulsalNumBanque(this.salaries.getSalNumBanque());
               this.bulletinSalaire.setBulsalGuichetBanque(this.salaries.getSalGuichetBanque());
               this.bulletinSalaire.setBulsalCompteBanque(this.salaries.getSalCompteBanque());
               this.bulletinSalaire.setBulsalCompteMembre(this.salaries.getSalCompteMembre());
               this.bulletinSalaire.setBulsalCleBanque(this.salaries.getSalCleBanque());
               this.bulletinSalaire.setBulsalIban(this.salaries.getSalIban());
               this.bulletinSalaire.setBulsalSwift(this.salaries.getSalSwift());
               this.bulletinSalaire.setBulsalNbFemme(this.salaries.getSalNbEnfant());
               this.bulletinSalaire = var9.modif(this.bulletinSalaire, var5);
               ++var7;
               if (var7 == 100) {
                  var5.flush();
                  var7 = 0;
               }
            }

            var6.commit();
         }
      } catch (HibernateException var20) {
         if (var6 != null) {
            var6.rollback();
         }

         throw var20;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculBasesConges() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("reclacul de la base des congés");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des salariés...";
      Utilitaires_Paye var4 = new Utilitaires_Paye();
      new ExercicesPaye();
      this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      ExercicesPaye var5 = this.exercicesPayeDao.recupererLastExo((Session)null);
      if (var5 != null) {
         this.optionPaye = new OptionPaye();
         LireLesoptionsPaye var6 = new LireLesoptionsPaye();
         var6.setStrId(this.structureLog.getStrid());
         var6.lancer();
         this.optionPaye = var6.getOptionsPaye();
         this.salaries = new Salaries();
         new ArrayList();
         this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
         this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         List var7 = this.salariesDao.chargerlesSalariesActif((Session)null);
         SalariesHistoriqueDao var8 = new SalariesHistoriqueDao(this.baseLog, this.utilInitHibernate);
         BulletinSalaireDao var9 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         BulletinLigneDao var10 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
         PlanPayeDao var11 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
         ArrayList var12 = new ArrayList();
         ArrayList var13 = new ArrayList();
         ArrayList var14 = new ArrayList();
         if (var7.size() != 0) {
            Session var15 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var16 = null;

            try {
               var16 = var15.beginTransaction();
               var15.setFlushMode(FlushMode.MANUAL);

               for(int var17 = 0; var17 < var7.size(); ++var17) {
                  this.salaries = (Salaries)var7.get(var17);
                  this.var_info = "Salarie: " + this.salaries.getSalMatricule();
                  if (var17 != 0) {
                     double var18 = (double)var7.size();
                     double var20 = var2.myRound(var18 / (double)var17, 4);
                     double var22 = var2.myRound(100.0D / var20, 2);
                     this.var_currentValue = (int)var22;
                  }

                  var4.recalculBaseConges(var3, var2, var12, var13, var14, var11, var9, var8, var10, this.salaries, this.optionPaye, var5, this.baseLog, this.structureLog, this.utilInitHibernate, var15);
               }

               var16.commit();
            } catch (HibernateException var27) {
               if (var16 != null) {
                  var16.rollback();
               }

               throw var27;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recopieVariableM() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recopie variables Décembre vers Janvier");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des salariés...";
      Utilitaires_Paye var4 = new Utilitaires_Paye();
      new ExercicesPaye();
      this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      ExercicesPaye var5 = this.exercicesPayeDao.recupererLastExo((Session)null);
      if (var5 != null) {
         this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var6 = this.salariesDao.chargerlesSalariesActif((Session)null);
         this.optionPaye = new OptionPaye();
         LireLesoptionsPaye var7 = new LireLesoptionsPaye();
         var7.setStrId(this.structureLog.getStrid());
         var7.lancer();
         this.optionPaye = var7.getOptionsPaye();
         if (var6.size() != 0) {
            Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var9 = null;

            try {
               var9 = var8.beginTransaction();
               var8.setFlushMode(FlushMode.MANUAL);
               new ArrayList();
               PlanPayeDao var11 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
               List var10 = var11.chargerPlanPaye(var5.getExepayId(), var8);
               String var12 = "";
               if (var3.dateJourPrecedent(var5.getExepayDateDebut()).getMonth() + 1 <= 9) {
                  var12 = "0" + (var3.dateJourPrecedent(var5.getExepayDateDebut()).getMonth() + 1);
               } else {
                  var12 = "" + (var3.dateJourPrecedent(var5.getExepayDateDebut()).getMonth() + 1);
               }

               String var13 = "" + (var3.dateJourPrecedent(var5.getExepayDateDebut()).getYear() + 1900);
               String var14 = var12 + ":" + var13;
               String var15 = "";
               if (var5.getExepayDateDebut().getMonth() + 1 <= 9) {
                  var15 = "0" + (var5.getExepayDateDebut().getMonth() + 1);
               } else {
                  var15 = "" + (var5.getExepayDateDebut().getMonth() + 1);
               }

               String var16 = "" + (var5.getExepayDateDebut().getYear() + 1900);
               String var17 = var15 + ":" + var16;
               this.salaries = new Salaries();

               for(int var18 = 0; var18 < var6.size(); ++var18) {
                  this.salaries = (Salaries)var6.get(var18);
                  this.var_info = "Salarie: " + this.salaries.getSalMatricule();
                  if (var18 != 0) {
                     double var19 = (double)var6.size();
                     double var21 = var2.myRound(var19 / (double)var18, 4);
                     double var23 = var2.myRound(100.0D / var21, 2);
                     this.var_currentValue = (int)var23;
                  }

                  var4.recopieVariablesM(this.salaries, var10, var14, var17, var3, this.optionPaye, var5, this.baseLog, this.structureLog, this.utilInitHibernate, var8);
               }

               var9.commit();
            } catch (HibernateException var28) {
               if (var9 != null) {
                  var9.rollback();
               }

               throw var28;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }

         this.var_showBarProg = false;
         this.choixModule = "moduleUtilitaires";
         this.choixLigne = "";
         this.formRecherche.setMessageTexte("Opérations effectuées..");
         this.formRecherche.setShowModalPanelMessage(true);
      }

   }

   public void recalculSalarieRH() throws HibernateException, NamingException, ParseException, IOException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul table Salarie_RH");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Chargement des salariés...";
      Utilitaires_Paye var4 = new Utilitaires_Paye();
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      SalariesGrh var5 = new SalariesGrh();
      SalariesGrhDao var6 = new SalariesGrhDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var7 = this.salariesDao.chargerlesSalariesTous((Session)null);
      this.optionPaye = new OptionPaye();
      LireLesoptionsPaye var8 = new LireLesoptionsPaye();
      var8.setStrId(this.structureLog.getStrid());
      var8.lancer();
      this.optionPaye = var8.getOptionsPaye();
      if (var7.size() != 0) {
         var4.moveDossierRH(this.structureLog);
         Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var10 = null;

         try {
            var10 = var9.beginTransaction();
            var9.setFlushMode(FlushMode.MANUAL);
            this.salaries = new Salaries();

            for(int var11 = 0; var11 < var7.size(); ++var11) {
               this.salaries = (Salaries)var7.get(var11);
               this.var_info = "Salarie: " + this.salaries.getSalMatricule();
               if (var11 != 0) {
                  double var12 = (double)var7.size();
                  double var14 = var2.myRound(var12 / (double)var11, 4);
                  double var16 = var2.myRound(100.0D / var14, 2);
                  this.var_currentValue = (int)var16;
               }

               var4.recalculSalarieRH(this.salaries, var5, var6, var3, this.optionPaye, this.baseLog, this.structureLog, this.utilInitHibernate, var9);
            }

            var10.commit();
         } catch (HibernateException var21) {
            if (var10 != null) {
               var10.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void effacerVariablesRAZ() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("Efface variables salariés");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
         new ExercicesPaye();
         ExercicesPaye var4 = this.exercicesPayeDao.recupererLastExo(var2);
         if (var4 != null) {
            LireLesoptionsPaye var5 = new LireLesoptionsPaye();
            var5.setStrId(this.structureLog.getStrid());
            var5.lancer();
            this.optionPaye = var5.getOptionsPaye();
            int var6 = Integer.parseInt(this.optionPaye.getModeTravail());
            String var7 = "";
            if (this.var_date_deb.getMonth() + 1 <= 9) {
               var7 = "0" + (this.var_date_deb.getMonth() + 1);
            } else {
               var7 = "" + (this.var_date_deb.getMonth() + 1);
            }

            String var8 = "" + (this.var_date_deb.getYear() + 1900);
            String var9 = var7 + ":" + var8;
            new ArrayList();
            new FeuilleCalculRubrique();
            FeuilleCalculRubriqueDao var12 = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
            List var10 = var12.chargerRubriqueFeuilleActive(var4.getExepayId(), var2);
            SalariesVariablesDao var13 = new SalariesVariablesDao(this.baseLog, this.utilInitHibernate);
            new SalariesVariables();
            new ArrayList();
            List var15 = var13.chargerlesVariablesFeuille(var9, this.var_date_deb, this.var_date_fin, this.var_journal, var2);
            if (var15.size() != 0) {
               for(int var16 = 0; var16 < var15.size(); ++var16) {
                  SalariesVariables var14 = (SalariesVariables)var15.get(var16);

                  for(int var17 = 0; var17 < var10.size(); ++var17) {
                     FeuilleCalculRubrique var11 = (FeuilleCalculRubrique)var10.get(var17);
                     if (var14.getSalvarCode().equals(var11.getFeurubCode()) && var14.getSalaries().getSalFeuille().equals(var11.getFeuilleCalcul().getFeuCode()) && (var11.isFeurubColARaz() || var11.isFeurubColBRaz() || var11.isFeurubColCRaz() || var11.isFeurubColDRaz() || var11.isFeurubColERaz())) {
                        if (var11.isFeurubColA()) {
                           var14.setSalvarValeurColA(0.0D);
                        }

                        if (var11.isFeurubColB()) {
                           var14.setSalvarValeurColB(0.0D);
                        }

                        if (var11.isFeurubColC()) {
                           var14.setSalvarValeurColC(0.0D);
                        }

                        if (var11.isFeurubColD()) {
                           var14.setSalvarValeurColD(0.0D);
                        }

                        if (var11.isFeurubColE()) {
                           var14.setSalvarValeurColE(0.0D);
                        }

                        var13.modif(var14, var2);
                        break;
                     }
                  }
               }

               var3.commit();
            }
         }
      } catch (HibernateException var21) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var21;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void effacerVariablesDoublons() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("Efface variables en doublon");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
         new ExercicesPaye();
         ExercicesPaye var4 = this.exercicesPayeDao.recupererLastExo(var2);
         if (var4 != null) {
            String var5 = "";
            if (this.var_date_deb.getMonth() + 1 <= 9) {
               var5 = "0" + (this.var_date_deb.getMonth() + 1);
            } else {
               var5 = "" + (this.var_date_deb.getMonth() + 1);
            }

            String var6 = "" + (this.var_date_deb.getYear() + 1900);
            String var7 = var5 + ":" + var6;
            Utilitaires_Paye var8 = new Utilitaires_Paye();
            var8.effacerVariablesDoublons(var7, this.var_date_deb, this.var_date_fin, this.var_journal, var4, this.baseLog, this.structureLog, this.utilInitHibernate, var2);
            var3.commit();
         }
      } catch (HibernateException var12) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var12;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculClesBulletinsMois() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul Cles Bulletins mois");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      ArrayList var2 = new ArrayList();
      new ExercicesPaye();
      ExercicesPaye var3 = this.exercicesPayeDao.recupererLastExo((Session)null);
      if (var3 != null) {
         var2.add(var3);
      }

      UtilNombre var4 = new UtilNombre();
      new UtilDate();
      BulletinMoisDao var6 = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
      BulletinSalaireDao var7 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      if (var2.size() != 0) {
         for(int var9 = 0; var9 < var2.size(); ++var9) {
            long var10 = ((ExercicesPaye)var2.get(var9)).getExepayId();
            if (var10 != 0L) {
               Session var12 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
               List var8 = var6.listeJouMemCloture(var3, var12);
               if (var8.size() != 0) {
                  Transaction var13 = null;

                  try {
                     var13 = var12.beginTransaction();
                     new BulletinMois();
                     boolean var15 = false;

                     for(int var16 = 0; var16 < var8.size(); ++var16) {
                        BulletinMois var14 = (BulletinMois)var8.get(var16);
                        this.var_info = "Exercice : " + var10 + " journal num. " + var16 + " / Nb journaux mois : " + var8.size();
                        if (var16 != 0) {
                           double var17 = (double)var8.size();
                           double var19 = var4.myRound(var17 / (double)var16, 4);
                           double var21 = var4.myRound(100.0D / var19, 2);
                           this.var_currentValue = (int)var21;
                        }

                        var15 = var7.verifMouvment(var14.getBulmenPeriode(), var14.getBulmenFeuille(), var12);
                        if (!var15) {
                           var14.setBulmenUserIdJournal(0L);
                           var14.setBulmenOpenGeneration(0);
                           var14.setBulmenOpenUserJournal("");
                           var14.setBulmenOpenJournal(0);
                           var14.setBulmenOpenUserJournal("");
                           var14.setBulmenEtat(0);
                        } else {
                           var14.setBulmenUserIdJournal(0L);
                           var14.setBulmenOpenGeneration(0);
                           var14.setBulmenOpenUserJournal("");
                           var14.setBulmenOpenJournal(0);
                           var14.setBulmenOpenUserJournal("");
                           if (var14.getBulmenEtat() == 0) {
                              var14.setBulmenEtat(1);
                           }
                        }

                        var6.majJournal(var14, var12);
                     }

                     var13.commit();
                  } catch (HibernateException var26) {
                     if (var13 != null) {
                        var13.rollback();
                     }

                     throw var26;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }
               } else {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recopieMatriculeBulletinElement() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recopie matriucle dans bulletins et elements");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      Utilitaires_Paye var2 = new Utilitaires_Paye();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         this.var_info = "Recopie Matricules dans bulletins";
         this.var_currentValue = 1;
         var2.recopieMatriculeBulletinElement1(this.baseLog, this.utilInitHibernate, var3);
         this.var_info = "Recopie Matricules dans Elements";
         this.var_currentValue = 2;
         var2.recopieMatriculeBulletinElement2(this.baseLog, this.utilInitHibernate, var3);
         var4.commit();
      } catch (HibernateException var9) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recopieBulletinMatricule() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recopie matriucle et nature depuis salarié vers bulletins");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      Utilitaires_Paye var2 = new Utilitaires_Paye();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         this.var_info = "Recopie Matricules dans salariés";
         this.var_currentValue = 1;
         var2.recopieBulletinMatricule(this.baseLog, this.utilInitHibernate, var3);
         var4.commit();
      } catch (HibernateException var9) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void annulTrfCaisses() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null && this.var_journal != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("annule Trf Caisses du " + this.var_date_deb + " au " + this.var_date_fin);
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresCaisse");
         EcrituresAnalytiquesDao var3 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         EcrituresDao var4 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         BrouillardDao var5 = new BrouillardDao(this.baseLog, this.utilInitHibernate);
         ReglementsDao var6 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         Transaction var7 = null;

         try {
            var7 = var2.beginTransaction();
            new ArrayList();
            List var8 = var3.chargerLesEcrituresAnalytiquesByJournalTransfert(this.var_date_deb, this.var_date_fin, this.var_journal, var2);
            if (var8.size() != 0) {
               var3.nettoyageAnalytiqueByEcriture(var8, var2);
            }

            new ArrayList();
            List var9 = var4.chargerEcrituresTransfert(this.var_date_deb, this.var_date_fin, this.var_journal, var2);
            if (var9.size() != 0) {
               var4.removeSelectedEC2(var9, 0, var2);
            }

            new ArrayList();
            List var10 = var5.chargerBrouillardsTransfert(this.var_date_deb, this.var_date_fin, this.var_journal, var2);
            if (var10.size() != 0) {
               var5.removeSelected(var10, var2);
            }

            new ArrayList();
            CaissesCommercialesDao var12 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
            List var11 = var12.selectActifCaisse(this.usersLog.getUsrJrxReserve(), var2);
            if (var11.size() != 0) {
               String var13 = "";

               for(int var14 = 0; var14 < var11.size(); ++var14) {
                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrCheque() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrCheque().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrCheque().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrCompense() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrCompense().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrCompense().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrCredoc() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrCredoc().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrCredoc().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrEspece() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrEspece().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrEspece().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrEspeceST() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrEspeceST().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrEspeceST().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrFactor() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrFactor().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrFactor().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrTerme() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrTerme().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrTerme().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrTpe() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrTpe().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrTpe().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrTraite() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrTraite().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrTraite().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrTransfert() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrTransfert().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrTransfert().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrVirement() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrVirement().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrVirement().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var11.get(var14)).getCaiJrePaiement() != null && !((CaissesCommerciales)var11.get(var14)).getCaiJrePaiement().isEmpty() && ((CaissesCommerciales)var11.get(var14)).getCaiJrePaiement().equals(this.var_journal)) {
                     var13 = ((CaissesCommerciales)var11.get(var14)).getCaiCode();
                     break;
                  }
               }

               if (var13 != null && !var13.isEmpty()) {
                  new ArrayList();
                  List var22 = var6.rechercheReglementDejaTransfererCompta(this.var_date_deb, this.var_date_fin, var13, var2);
                  if (var22.size() != 0) {
                     new Reglements();

                     for(int var16 = 0; var16 < var22.size(); ++var16) {
                        Reglements var15 = (Reglements)var22.get(var16);
                        var15.setRglDateTransfert((Date)null);
                        var6.modifierReg(var15, var2);
                     }
                  }
               }
            }

            var7.commit();
         } catch (HibernateException var20) {
            if (var7 != null) {
               var7.rollback();
            }

            throw var20;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void forceTrfCaisses() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null && this.var_journal != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("force Trf Caisses du " + this.var_date_deb + " au " + this.var_date_fin);
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresCaisse");
         ReglementsDao var3 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         Transaction var4 = null;

         try {
            var4 = var2.beginTransaction();
            UtilDate var5 = new UtilDate();
            String var6 = var5.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
            String var7 = var5.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
            new ArrayList();
            CaissesCommercialesDao var9 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
            List var8 = var9.selectActifCaisse(this.usersLog.getUsrJrxReserve(), var2);
            if (var8.size() != 0) {
               String var10 = "";

               for(int var11 = 0; var11 < var8.size(); ++var11) {
                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrCheque() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrCheque().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrCheque().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrCompense() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrCompense().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrCompense().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrCredoc() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrCredoc().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrCredoc().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrEspece() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrEspece().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrEspece().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrEspeceST() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrEspeceST().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrEspeceST().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrFactor() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrFactor().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrFactor().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrTerme() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrTerme().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrTerme().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrTpe() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrTpe().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrTpe().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrTraite() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrTraite().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrTraite().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrTransfert() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrTransfert().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrTransfert().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrVirement() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrVirement().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrVirement().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }

                  if (((CaissesCommerciales)var8.get(var11)).getCaiJrePaiement() != null && !((CaissesCommerciales)var8.get(var11)).getCaiJrePaiement().isEmpty() && ((CaissesCommerciales)var8.get(var11)).getCaiJrePaiement().equals(this.var_journal)) {
                     var10 = ((CaissesCommerciales)var8.get(var11)).getCaiCode();
                     break;
                  }
               }

               if (var10 != null && !var10.isEmpty()) {
                  new ArrayList();
                  List var19 = var3.rechercheReglementATransfererCompta("", "", var6, var7, var10, 0, 99, false, var2);
                  if (var19.size() != 0) {
                     new Reglements();

                     for(int var13 = 0; var13 < var19.size(); ++var13) {
                        Reglements var12 = (Reglements)var19.get(var13);
                        var12.setRglDateTransfert(var12.getRglDateReg());
                        var3.modifierReg(var12, var2);
                     }
                  }
               }
            }

            var4.commit();
         } catch (HibernateException var17) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void vrtCaisseBnq() throws HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("vrt Caisse Bnq");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new ArrayList();
      new Reglements();
      new JournauxComptables();
      ReglementsDao var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      JournauxComptablesDao var6 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var5.rechercheVrtCaisseBnq((Session)null);
      if (var2.size() != 0) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();

            for(int var9 = 0; var9 < var2.size(); ++var9) {
               new Reglements();
               Reglements var3 = (Reglements)var2.get(var9);
               new JournauxComptables();
               JournauxComptables var4 = var6.chercherCode(var3.getRglCodeReceptrice(), 0L, var7);
               if (var4 != null && (var4.getPljNature() == 7 || var4.getPljNature() == 8)) {
                  var3.setRglImp(1);
                  var5.modifierReg(var3, var7);
               }
            }

            var8.commit();
         } catch (HibernateException var13) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var13;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void bonEncaissReglement() throws HibernateException, HibernateException, NamingException, ParseException {
      new ExercicesVentes();
      this.exercicesVentesDao = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var1 = this.exercicesVentesDao.recupererLastExo((Session)null);
      if (var1 != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var2 = new Espion();
         var2.setEspdtecreat(new Date());
         var2.setUsers(this.usersLog);
         var2.setEspaction("bon Encaiss Reglement");
         var2.setEsptype(0);
         this.espionDao.mAJEspion(var2);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            ReglementsDao var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            new ArrayList();
            new BonEncaissementVente();
            BonEncaissementVenteDao var9 = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
            List var7 = var9.rechercheBeByDocExercice(var3);
            if (var7.size() != 0) {
               for(int var10 = 0; var10 < var7.size(); ++var10) {
                  BonEncaissementVente var8 = (BonEncaissementVente)var7.get(var10);
                  new Reglements();
                  List var6 = var5.reglementDocument(var8.getBonIdRef(), var8.getBonNatRef(), var3);
                  Reglements var11;
                  if (var6.size() == 1) {
                     var11 = (Reglements)var6.get(0);
                     var11.setRglIdBon(var8.getBonId());
                     var11.setRglBon(var8.getBonNum());
                     var5.modifierReg(var11, var3);
                     var8.setBonEtat(1);
                  } else if (var6.size() >= 2) {
                     for(int var12 = 1; var12 < var6.size(); ++var12) {
                        var11 = (Reglements)var6.get(var12);
                        var5.delete(var11, var3);
                     }
                  }
               }
            }

            var4.commit();
         } catch (HibernateException var16) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var16;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculConnexionTiers() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul connexion de la table Tiers en trésorerie");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         String var6 = var3.dateToStringSQLLight(this.var_date_deb);
         String var7 = var3.dateToStringSQLLight(this.var_date_fin);
         String var8 = "";
         this.var_info = "Chargement des reglements...";
         new ArrayList();
         ReglementsDao var10 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         var8 = "rglDateReg>='" + var6 + "' and rglDateReg<='" + var7 + "'";
         List var9 = var10.rechercheReglementsRequete(var8, var4);
         if (var9.size() != 0) {
            new Reglements();
            new Tiers();

            for(int var13 = 0; var13 < var9.size(); ++var13) {
               Reglements var11 = (Reglements)var9.get(var13);
               if (var13 != 0) {
                  double var14 = (double)var9.size();
                  double var16 = var2.myRound(var14 / (double)var13, 4);
                  double var18 = var2.myRound(100.0D / var16, 2);
                  this.var_currentValue = (int)var18;
               }

               if (var11.getRglIdTiers() != 0L && var11.getRglNomTiers() != null && !var11.getRglNomTiers().isEmpty()) {
                  Tiers var12;
                  if (var11.getRglDepense() != 0.0D && var11.getRglRecette() == 0.0D) {
                     var12 = this.tiersDao.chargerLesTiers("0", var11.getRglNomTiers(), var4);
                  } else {
                     var12 = this.tiersDao.chargerLesTiers("3", var11.getRglNomTiers(), var4);
                  }

                  if (var12 != null) {
                     var11.setRglIdTiers(var12.getTieid());
                     var10.modifierReg(var11, var4);
                  }
               }
            }

            var4.flush();
         }

         var5.commit();
      } catch (HibernateException var23) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var23;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculActiviteReglement() throws ParseException, HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des activités des reglements à partir des activités des documents");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_showBarProg = true;
      this.var_currentValue = 0;
      this.var_info = "Chargement des reglements....";
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      this.optionVentes = var2.lancer();
      boolean var3 = false;
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         var3 = true;
      } else {
         var3 = false;
      }

      UtilNombre var4 = new UtilNombre();
      UtilDate var5 = new UtilDate();
      String var6 = var5.dateToStringSQL(this.var_date_deb);
      String var7 = var5.dateToStringSQL(this.var_date_fin);
      new Reglements();
      ReglementsDao var9 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new CommandeEnteteVentes();
      CommandeEnteteVentesDao var12 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new LivraisonEnteteVentes();
      LivraisonEnteteVentesDao var14 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      new FactureEnteteVentes();
      FactureEnteteVentesDao var16 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      String var17 = " rgl_date_reg>='" + var6 + "' and rgl_date_reg<='" + var7 + "' and (rgl_nature_doc=22 or rgl_nature_doc=23 or rgl_nature_doc=25)";
      List var10 = var9.rechercheReglementsRequete(var17, (Session)null);
      Reglements var8;
      CommandeEnteteVentes var11;
      LivraisonEnteteVentes var13;
      FactureEnteteVentes var15;
      Session var18;
      Transaction var19;
      int var20;
      int var21;
      double var22;
      double var24;
      double var26;
      if (var3) {
         var18 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         var19 = null;

         try {
            var19 = var18.beginTransaction();
            var20 = 0;
            if (var10.size() != 0) {
               for(var21 = 0; var21 < var10.size(); ++var21) {
                  var8 = (Reglements)var10.get(var21);
                  if (var21 != 0) {
                     var22 = (double)var10.size();
                     var24 = var4.myRound(var22 / (double)var21, 4);
                     var26 = var4.myRound(100.0D / var24, 2);
                     this.var_currentValue = (int)var26;
                  }

                  if (var8.getRglNatureDoc() == 22) {
                     this.var_info = "Reglement du BC Num. " + var8.getRglDocument();
                     var11 = var12.pourParapheur(var8.getRglIdDocument(), var18);
                     if (var11 != null) {
                        if (var8.getRglDateReg().compareTo(var11.getBcmDate()) >= 0) {
                           var8.setRglActivite(var11.getBcmActivite());
                        } else {
                           var8.setRglIdDocument(0L);
                        }

                        var9.modifierReg(var8, var18);
                     }
                  } else if (var8.getRglNatureDoc() == 23) {
                     this.var_info = "Reglement du BL Num. " + var8.getRglDocument();
                     var13 = var14.pourParapheur(var8.getRglIdDocument(), var18);
                     if (var13 != null) {
                        if (var8.getRglDateReg().compareTo(var13.getBlvDate()) >= 0) {
                           var8.setRglActivite(var13.getBlvActivite());
                        } else {
                           var8.setRglIdDocument(0L);
                        }

                        var9.modifierReg(var8, var18);
                     }
                  } else if (var8.getRglNatureDoc() == 25) {
                     this.var_info = "Reglement du Fac Num. " + var8.getRglDocument();
                     var15 = var16.pourParapheur(var8.getRglIdDocument(), var18);
                     if (var15 != null) {
                        if (var8.getRglDateReg().compareTo(var15.getFacDate()) >= 0) {
                           var8.setRglActivite(var15.getFacActivite());
                        } else {
                           var8.setRglIdDocument(0L);
                        }

                        var9.modifierReg(var8, var18);
                     }
                  }

                  ++var20;
                  if (var20 == 500) {
                     var18.flush();
                     var20 = 0;
                  }
               }

               var19.commit();
            }
         } catch (HibernateException var40) {
            if (var19 != null) {
               var19.rollback();
            }

            throw var40;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         var18 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         var19 = null;

         try {
            var19 = var18.beginTransaction();
            var20 = 0;
            if (var10.size() != 0) {
               for(var21 = 0; var21 < var10.size(); ++var21) {
                  var8 = (Reglements)var10.get(var21);
                  if (var21 != 0) {
                     var22 = (double)var10.size();
                     var24 = var4.myRound(var22 / (double)var21, 4);
                     var26 = var4.myRound(100.0D / var24, 2);
                     this.var_currentValue = (int)var26;
                  }

                  if (var8.getRglNatureDoc() == 22) {
                     this.var_info = "Reglement du BC Num. " + var8.getRglDocument();
                     var11 = var12.pourParapheur(var8.getRglIdDocument(), var18);
                     if (var11 != null && var8.getRglDateReg().compareTo(var11.getBcmDate()) < 0) {
                        var8.setRglIdDocument(0L);
                        var9.modifierReg(var8, var18);
                     }
                  } else if (var8.getRglNatureDoc() == 23) {
                     this.var_info = "Reglement du BL Num. " + var8.getRglDocument();
                     var13 = var14.pourParapheur(var8.getRglIdDocument(), var18);
                     if (var13 != null && var8.getRglDateReg().compareTo(var13.getBlvDate()) < 0) {
                        var8.setRglIdDocument(0L);
                        var9.modifierReg(var8, var18);
                     }
                  } else if (var8.getRglNatureDoc() == 25) {
                     this.var_info = "Reglement du Fac Num. " + var8.getRglDocument();
                     var15 = var16.pourParapheur(var8.getRglIdDocument(), var18);
                     if (var15 != null) {
                        var5.dateToStringFr(var8.getRglDateReg());
                        var5.dateToStringFr(var15.getFacDate());
                        if (var15.getFacNum().equals("00059/15")) {
                           boolean var42 = false;
                        }

                        if (var8.getRglDateReg().compareTo(var15.getFacDate()) < 0) {
                           var8.setRglIdDocument(0L);
                           var9.modifierReg(var8, var18);
                        }
                     }
                  }

                  ++var20;
                  if (var20 == 500) {
                     var18.flush();
                     var20 = 0;
                  }
               }

               var19.commit();
            }
         } catch (HibernateException var38) {
            if (var19 != null) {
               var19.rollback();
            }

            throw var38;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculRecusVides() throws HibernateException, HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul numeros recus vides");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_showBarProg = true;
      this.var_currentValue = 0;
      this.var_info = "Chargement des reglements....";
      UtilNombre var2 = new UtilNombre();
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         ReglementsDao var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var6 = var5.rechercheRecu(var3);
         if (var6.size() != 0) {
            new Reglements();

            for(int var8 = 0; var8 < var6.size(); ++var8) {
               Reglements var7 = (Reglements)var6.get(var8);
               this.var_info = "Reglement du BC ID Num. " + var7.getRglId();
               if (var8 != 0) {
                  double var9 = (double)var6.size();
                  double var11 = var2.myRound(var9 / (double)var8, 4);
                  double var13 = var2.myRound(100.0D / var11, 2);
                  this.var_currentValue = (int)var13;
               }

               if (var7.getRglNum() == null || var7.getRglNum().isEmpty()) {
                  var7.setRglNum("R" + var7.getRglId());
                  var5.modifierReg(var7, var3);
               }
            }
         }

         var4.commit();
      } catch (HibernateException var18) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var18;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void suppressionDocumentTresorerie() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("suppression des documents trésorerie");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Suppression des documents trésorerie.";
      Utilitaires_Tresorerie var3 = new Utilitaires_Tresorerie();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (this.sup_devis) {
            ++this.var_currentValue;
            this.var_info = "Suppression des BONS DECAISSEMENTS en cours....";
            var3.suppressionBDecaissement(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bc) {
            ++this.var_currentValue;
            this.var_info = "Suppression des BONS ENCAISSEMENTS en cours....";
            var3.suppressionBEncaissement(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bl) {
            ++this.var_currentValue;
            this.var_info = "Suppression des TOUS RECUS en cours....";
            var3.suppressionRecu(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_noteDebit) {
            ++this.var_currentValue;
            this.var_info = "Suppression des RECUS DEPOSITS en cours....";
            var3.suppressionRecuDeposits(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_cession) {
            ++this.var_currentValue;
            this.var_info = "Suppression des RECUS RISTOURNES en cours....";
            var3.suppressionRecuRistournes(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_retour) {
            ++this.var_currentValue;
            this.var_info = "Suppression des BONS ENTREES en cours....";
            var3.suppressionBEntree(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_facture) {
            ++this.var_currentValue;
            this.var_info = "Suppression des BONS SORTIES en cours....";
            var3.suppressionBSortie(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_factureInterne) {
            ++this.var_currentValue;
            this.var_info = "Suppression des VIREMENTS en cours....";
            var3.suppressionVirement(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_noteDebit) {
            this.var_currentValue = 7;
            this.var_info = "Suppression des TRAITES DOMICILIEES en cours....";
            var3.suppressionTDomiciliee(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_avoir) {
            ++this.var_currentValue;
            this.var_info = "Suppression des TRAITES SIMLIFIEES en cours....";
            var3.suppressionTSimplifiee(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_chargement) {
            ++this.var_currentValue;
            this.var_info = "Suppression des TRAITES ENTREPRISES en cours....";
            var3.suppressionTEntreprise(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void declotureCaissesMensuelles() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("décloture caisses commerciales mensuelles");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      UtilNombre var2 = new UtilNombre();
      new UtilDate();
      CaissesMoisDao var4 = new CaissesMoisDao(this.baseLog, this.utilInitHibernate);
      new CaissesMois();
      new ArrayList();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      String var7 = "";
      String var8 = "" + (this.var_date_deb.getYear() + 1900);
      if (this.var_date_deb.getMonth() + 1 <= 9) {
         var7 = "0" + (this.var_date_deb.getMonth() + 1);
      } else {
         var7 = "" + (this.var_date_deb.getMonth() + 1);
      }

      String var9 = var7 + ":" + var8;
      Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "GestionCaisseAutres");
      List var6 = var4.mesjournauxmois(this.var_journal, (ExercicesCaisse)null, var10);
      if (var6.size() != 0) {
         Transaction var11 = null;

         try {
            var11 = var10.beginTransaction();

            for(int var12 = 0; var12 < var6.size(); ++var12) {
               CaissesMois var5 = (CaissesMois)var6.get(var12);
               this.var_info = "Caisse " + var5.getCaimenCode() + " sur " + var6.size();
               if (var12 != 0) {
                  double var13 = (double)var6.size();
                  double var15 = var2.myRound(var13 / (double)var12, 4);
                  double var17 = var2.myRound(100.0D / var15, 2);
                  this.var_currentValue = (int)var17;
               }

               if (var5.getCaimenPeriode().equals(var9)) {
                  var5.setCaimenEtat(0);
                  var5.setCaimenSoldeAlcoin(0.0D);
                  var5.setCaimenSoldeBonCaisse(0.0D);
                  var5.setCaimenSoldeCheque(0.0D);
                  var5.setCaimenSoldeCompense(0.0D);
                  var5.setCaimenSoldeCredoc(0.0D);
                  var5.setCaimenSoldeEspece(0.0D);
                  var5.setCaimenSoldeFactor(0.0D);
                  var5.setCaimenSoldeLettreGarantie(0.0D);
                  var5.setCaimenSoldePrelevement(0.0D);
                  var5.setCaimenSoldeTerme(0.0D);
                  var5.setCaimenSoldeTpe(0.0D);
                  var5.setCaimenSoldeTraite(0.0D);
                  var5.setCaimenSoldeVirement(0.0D);
                  var5.setCaimenSoldeePaiement(0.0D);
                  var4.majJournal(var5, var10);
               }
            }

            var11.commit();
         } catch (HibernateException var22) {
            if (var11 != null) {
               var11.rollback();
            }

            throw var22;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void declotureCaissesJournalieres() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("décloture caisses commerciales journalieres");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Initialisation en cours...";
      UtilNombre var2 = new UtilNombre();
      new UtilDate();
      CaissesJourDao var4 = new CaissesJourDao(this.baseLog, this.utilInitHibernate);
      new CaissesJour();
      new ArrayList();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      String var7 = "";
      String var8 = "" + (this.var_date_deb.getYear() + 1900);
      if (this.var_date_deb.getMonth() + 1 <= 9) {
         var7 = "0" + (this.var_date_deb.getMonth() + 1);
      } else {
         var7 = "" + (this.var_date_deb.getMonth() + 1);
      }

      String var9 = var7 + ":" + var8;
      Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "GestionCaisseAutres");
      List var6 = var4.mesjournauxjour(this.var_journal, var9, (ExercicesCaisse)null, var10);
      if (var6.size() != 0) {
         Transaction var11 = null;

         try {
            var11 = var10.beginTransaction();

            for(int var12 = 0; var12 < var6.size(); ++var12) {
               CaissesJour var5 = (CaissesJour)var6.get(var12);
               this.var_info = "Caisse " + var5.getCaijouCode() + " sur " + var6.size();
               if (var12 != 0) {
                  double var13 = (double)var6.size();
                  double var15 = var2.myRound(var13 / (double)var12, 4);
                  double var17 = var2.myRound(100.0D / var15, 2);
                  this.var_currentValue = (int)var17;
               }

               if (var5.getCaijouPeriode().equals(var9)) {
                  var5.setCaijouEtat(0);
                  var5.setCaijouSoldeAlcoin(0.0D);
                  var5.setCaijouSoldeBonCaisse(0.0D);
                  var5.setCaijouSoldeCheque(0.0D);
                  var5.setCaijouSoldeCompense(0.0D);
                  var5.setCaijouSoldeCredoc(0.0D);
                  var5.setCaijouSoldeEspece(0.0D);
                  var5.setCaijouSoldeFactor(0.0D);
                  var5.setCaijouSoldeLettreGarantie(0.0D);
                  var5.setCaijouSoldePrelevement(0.0D);
                  var5.setCaijouSoldeTerme(0.0D);
                  var5.setCaijouSoldeTpe(0.0D);
                  var5.setCaijouSoldeTraite(0.0D);
                  var5.setCaijouSoldeVirement(0.0D);
                  var5.setCaijouSoldeePaiement(0.0D);
                  var4.majJournal(var5, var10);
               }
            }

            var11.commit();
         } catch (HibernateException var22) {
            if (var11 != null) {
               var11.rollback();
            }

            throw var22;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculClesReglements() throws HibernateException, HibernateException, NamingException, ParseException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des clés des reglements");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_showBarProg = true;
      this.var_currentValue = 0;
      this.var_info = "Chargement des reglements....";
      UtilNombre var2 = new UtilNombre();
      UtilDate var3 = new UtilDate();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         ReglementsDao var6 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var7 = var6.rechercheTousRecus(var4);
         if (var7.size() != 0) {
            new Reglements();

            for(int var9 = 0; var9 < var7.size(); ++var9) {
               Reglements var8 = (Reglements)var7.get(var9);
               this.var_info = "Reglement du ID Num. " + var8.getRglId();
               if (var9 != 0) {
                  double var10 = (double)var7.size();
                  double var12 = var2.myRound(var10 / (double)var9, 4);
                  double var14 = var2.myRound(100.0D / var12, 2);
                  this.var_currentValue = (int)var14;
               }

               if (var8.getRglDateReg() == null) {
                  var8.setRglDateReg(var8.getRglDateCreation());
               }

               String var21 = "";
               if (var8.getRglDateReg().getMonth() + 1 <= 9) {
                  var21 = "0" + (var8.getRglDateReg().getMonth() + 1);
               } else {
                  var21 = "" + (var8.getRglDateReg().getMonth() + 1);
               }

               String var11 = "" + (var8.getRglDateReg().getYear() + 1900);
               var8.setRglPeriode(var21 + ":" + var11);
               var8.setRglCle1(var8.getRglCodeCaiss() + ":" + var8.getRglPeriode());
               String var22 = var3.dateToStringSQLLight(var8.getRglDateReg());
               var8.setRglCle2(var8.getRglCodeCaiss() + ":" + var22);
               var8.setRglCle3(var8.getRglCodeReceptrice() + ":" + var8.getRglPeriode());
               var8.setRglCle4(var8.getRglCodeReceptrice() + ":" + var22);
               var6.modifierReg(var8, var4);
            }
         }

         var5.commit();
      } catch (HibernateException var19) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var19;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void annulTrfLocation() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("annule Trf Ventes Location du " + this.var_date_deb + " au " + this.var_date_fin);
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         ArrayList var2 = new ArrayList();
         new ArrayList();
         ChronoDao var4 = new ChronoDao(this.baseLog, this.utilInitHibernate);
         List var3 = var4.selectListVente(1, (Session)null);
         if (var3.size() != 0) {
            for(int var5 = 0; var5 < var3.size(); ++var5) {
               boolean var6;
               int var7;
               if (((Chrono)var3.get(var5)).getChrJournal() != null && !((Chrono)var3.get(var5)).getChrJournal().isEmpty()) {
                  var6 = false;
                  if (var2.size() != 0) {
                     for(var7 = 0; var7 < var2.size(); ++var7) {
                        if (((String)var2.get(var7)).toString().equals(((Chrono)var3.get(var5)).getChrJournal())) {
                           var6 = true;
                           break;
                        }
                     }
                  }

                  if (!var6) {
                     var2.add(((Chrono)var3.get(var5)).getChrJournal());
                  }
               }

               if (((Chrono)var3.get(var5)).getChrJournalOd() != null && !((Chrono)var3.get(var5)).getChrJournalOd().isEmpty()) {
                  var6 = false;
                  if (var2.size() != 0) {
                     for(var7 = 0; var7 < var2.size(); ++var7) {
                        if (((String)var2.get(var7)).toString().equals(((Chrono)var3.get(var5)).getChrJournalOd())) {
                           var6 = true;
                           break;
                        }
                     }
                  }

                  if (!var6) {
                     var2.add(((Chrono)var3.get(var5)).getChrJournalOd());
                  }
               }
            }
         }

         if (var2.size() != 0) {
            Session var33 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresVentes");
            EcrituresAnalytiquesDao var34 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
            EcrituresDao var35 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
            BrouillardDao var8 = new BrouillardDao(this.baseLog, this.utilInitHibernate);
            BienFactureDao var9 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
            boolean var10 = true;
            Transaction var11 = null;

            try {
               var11 = var33.beginTransaction();
               int var12 = 0;

               while(true) {
                  if (var12 >= var2.size()) {
                     var11.commit();
                     break;
                  }

                  String var13 = ((String)var2.get(var12)).toString();
                  new ArrayList();
                  List var14 = var34.chargerLesEcrituresAnalytiquesByJournalTransfert(this.var_date_deb, this.var_date_fin, var13, var33);
                  if (var14.size() != 0) {
                     var34.nettoyageAnalytiqueByEcriture(var14, var33);
                  }

                  new ArrayList();
                  List var15 = var35.chargerEcrituresTransfert(this.var_date_deb, this.var_date_fin, var13, var33);
                  if (var15.size() != 0) {
                     var35.removeSelectedEC2(var15, 0, var33);
                  }

                  new ArrayList();
                  List var16 = var8.chargerBrouillardsTransfert(this.var_date_deb, this.var_date_fin, var13, var33);
                  if (var16.size() != 0) {
                     var8.removeSelected(var16, var33);
                  }

                  ++var12;
               }
            } catch (HibernateException var31) {
               var10 = false;
               if (var11 != null) {
                  var11.rollback();
               }

               throw var31;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            if (var10) {
               var33 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
               Transaction var36 = null;

               try {
                  var36 = var33.beginTransaction();

                  for(int var37 = 0; var37 < var2.size(); ++var37) {
                     UtilDate var38 = new UtilDate();
                     String var39 = var38.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
                     String var40 = var38.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
                     new ArrayList();
                     List var17 = var9.rechercheFactureDejaTransfererCompta(var39, var40, var33);
                     if (var17.size() != 0) {
                        new BienFacture();

                        for(int var19 = 0; var19 < var17.size(); ++var19) {
                           BienFacture var18 = (BienFacture)var17.get(var19);
                           var18.setBiefacDateTransfert((Date)null);
                           var9.modif(var18, var33);
                        }
                     }
                  }

                  var36.commit();
               } catch (HibernateException var29) {
                  if (var36 != null) {
                     var36.rollback();
                  }

                  throw var29;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void forceTrfLocation() throws HibernateException, NamingException, ParseException {
      if (this.var_date_deb != null && this.var_date_fin != null) {
         this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
         Espion var1 = new Espion();
         var1.setEspdtecreat(new Date());
         var1.setUsers(this.usersLog);
         var1.setEspaction("force Trf Ventes Locations du " + this.var_date_deb + " au " + this.var_date_fin);
         var1.setEsptype(0);
         this.espionDao.mAJEspion(var1);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         BienFactureDao var3 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
         Transaction var4 = null;

         try {
            var4 = var2.beginTransaction();
            UtilDate var5 = new UtilDate();
            String var6 = var5.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
            String var7 = var5.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
            new ArrayList();
            List var8 = var3.rechercheFactureATransfererCompta("1", "", "", var6, var7, false, var2);
            if (var8.size() != 0) {
               new BienFacture();

               for(int var10 = 0; var10 < var8.size(); ++var10) {
                  BienFacture var9 = (BienFacture)var8.get(var10);
                  var9.setBiefacDateTransfert(var9.getBiefacDate());
                  var3.modif(var9, var2);
               }
            }

            var4.commit();
         } catch (HibernateException var14) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var14;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void annulTrfSyndic() throws HibernateException, NamingException, ParseException {
   }

   public void forceTrfSyndic() throws HibernateException, NamingException, ParseException {
   }

   public void annulTrfNegoce() throws HibernateException, NamingException, ParseException {
   }

   public void forceTrfNegoce() throws HibernateException, NamingException, ParseException {
   }

   public void recalculBiens() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des biens");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Chargement des biens....";
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      new ArrayList();
      new Bien();
      BienDao var5 = new BienDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      List var3 = var5.chargeBien(9, 9, (Session)null);
      if (var3.size() != 0) {
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();
            new Bien();
            new Bien();
            new Tiers();

            for(int var10 = 0; var10 < var3.size(); ++var10) {
               Bien var4 = (Bien)var3.get(var10);
               this.var_info = "Bien " + var4.getBieNum() + " Numero " + var10 + ", pour un total de " + var3.size() + " total ";
               if (var10 != 0) {
                  double var11 = (double)var3.size();
                  double var13 = var2.myRound(var11 / (double)var10, 4);
                  double var15 = var2.myRound(100.0D / var13, 2);
                  this.var_currentValue = (int)var15;
               }

               Tiers var9;
               if (var4.getBieTiers() != null && !var4.getBieTiers().isEmpty()) {
                  var9 = this.tiersDao.selectTierSigle(var4.getBieTiers(), var6);
               } else {
                  var9 = null;
               }

               String var23 = "";
               long var12 = 0L;
               String var14 = "";
               String var24 = "";
               String var16 = "";
               if (var4.getBieType() != 2) {
                  if (var4.getBieGroupe() != null && !var4.getBieGroupe().isEmpty()) {
                     Bien var8 = var5.chargeGroupe(var4.getBieGroupe(), var6);
                     if (var8 != null) {
                        var23 = var8.getBieNom();
                        var12 = var8.getBieId();
                     }
                  }
               } else if (var4.getBieType() == 2 && var4.getTiers() != null) {
                  var14 = var4.getTiers().getTieraisonsocialenom();
                  var24 = var4.getTiers().getTiesigle();
                  var16 = var4.getTiers().getTiecivilite();
               }

               var4 = (Bien)var3.get(var10);
               var4 = var5.logBienId(var4.getBieId(), var6);
               if (var4 != null) {
                  if (var9 != null) {
                     var4.setTiers(var9);
                     var4.setBieTiers(var9.getTiesigle());
                     var4.setBieNomTiers(var9.getTieraisonsocialenom());
                     var4.setBieCivilTiers(var9.getTiecivilite());
                  } else {
                     var4.setBieTiers((String)null);
                     var4.setBieNomTiers((String)null);
                     var4.setBieCivilTiers((String)null);
                  }

                  if (var4.getBieType() != 2) {
                     var4.setBieNomGroupe(var23);
                     var4.setBieIdGroupe(var12);
                     var4.setBieCopropriete(false);
                  } else {
                     var4.setBieIdGroupe(0L);
                     if (var4.getTiers() == null) {
                        var4.setBieTiers((String)null);
                        var4.setBieNomTiers((String)null);
                        var4.setBieCivilTiers((String)null);
                        var4.setBieCopropriete(true);
                     } else {
                        var4.setBieTiers(var24);
                        var4.setBieNomTiers(var14);
                        var4.setBieCivilTiers(var16);
                        var4.setBieCopropriete(false);
                     }
                  }

                  String var17;
                  if (var4.getBieNom() != null && !var4.getBieNom().isEmpty() && var4.getBieNom().contains("Â°")) {
                     var17 = var4.getBieNom().replace("Â°", "e");
                     var4.setBieNom(var17);
                  }

                  if (var4.getBieNom() != null && !var4.getBieNom().isEmpty() && var4.getBieNom().contains("Ã©")) {
                     var17 = var4.getBieNom().replace("Ã©", "é");
                     var4.setBieNom(var17);
                  }

                  if (var4.getBieNom() != null && !var4.getBieNom().isEmpty() && var4.getBieNom().contains("Ã¨")) {
                     var17 = var4.getBieNom().replace("Ã¨", "è");
                     var4.setBieNom(var17);
                  }

                  if (var4.getBieAdresse() != null && !var4.getBieAdresse().isEmpty() && var4.getBieAdresse().contains("Â°")) {
                     var17 = var4.getBieAdresse().replace("Â°", "e");
                     var4.setBieAdresse(var17);
                  }

                  if (var4.getBieAdresse() != null && !var4.getBieAdresse().isEmpty() && var4.getBieAdresse().contains("Ã©")) {
                     var17 = var4.getBieAdresse().replace("Ã©", "é");
                     var4.setBieAdresse(var17);
                  }

                  if (var4.getBieAdresse() != null && !var4.getBieAdresse().isEmpty() && var4.getBieAdresse().contains("Ã¨")) {
                     var17 = var4.getBieAdresse().replace("Ã¨", "è");
                     var4.setBieAdresse(var17);
                  }

                  var5.modif(var4, var6);
               }
            }

            var7.commit();
         } catch (HibernateException var21) {
            if (var7 != null) {
               var7.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculBaux() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des baux");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Chargement des baux....";
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      new ArrayList();
      new BienBail();
      BienBailDao var5 = new BienBailDao(this.baseLog, this.utilInitHibernate);
      BienDao var6 = new BienDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      List var3 = var5.chargerBaux((Session)null);
      if (var3.size() != 0) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();
            new BienBail();

            for(int var9 = 0; var9 < var3.size(); ++var9) {
               BienBail var4 = (BienBail)var3.get(var9);
               this.var_info = "Bail " + var4.getBiebaiNum() + " Numero " + var9 + ", pour un total de " + var3.size() + " total ";
               if (var9 != 0) {
                  double var10 = (double)var3.size();
                  double var12 = var2.myRound(var10 / (double)var9, 4);
                  double var14 = var2.myRound(100.0D / var12, 2);
                  this.var_currentValue = (int)var14;
               }

               new Tiers();
               if (var4.getBiebaiLocataire() != null && !var4.getBiebaiLocataire().isEmpty()) {
                  Tiers var21 = this.tiersDao.selectTierSigle(var4.getBiebaiLocataire(), var7);
                  if (var21 != null) {
                     var4.setBiebaiLocataire(var21.getTiesigle());
                     var4.setBiebaiNomTiers(var21.getTieraisonsocialenom());
                     var4.setBiebaiCivilTiers(var21.getTiecivilite());
                     var4.setTiers(var21);
                  } else {
                     var4.setBiebaiNomTiers((String)null);
                     var4.setBiebaiCivilTiers((String)null);
                     var4.setTiers((Tiers)null);
                  }
               } else {
                  var4.setBiebaiNomTiers((String)null);
                  var4.setBiebaiCivilTiers((String)null);
                  var4.setTiers((Tiers)null);
               }

               new Bien();
               if (var4.getBiebaiLocal() != null && !var4.getBiebaiLocal().isEmpty()) {
                  Bien var11 = var6.logBienNum(var4.getBiebaiLocal(), var7);
                  if (var11 != null) {
                     var4.setBiebaiLocal(var11.getBieNum());
                     var4.setBien(var11);
                  } else {
                     var4.setBien((Bien)null);
                  }
               } else {
                  var4.setBien((Bien)null);
               }

               new Tiers();
               if (var4.getBiebaiProprietaire() != null && !var4.getBiebaiProprietaire().isEmpty()) {
                  Tiers var22 = this.tiersDao.selectTierSigle(var4.getBiebaiProprietaire(), var7);
                  if (var22 != null) {
                     var4.setBiebaiProprietaire(var22.getTiesigle());
                     var4.setBiebaiNomProprietaire(var22.getTieraisonsocialenom());
                     var4.setBiebaiCivilProprietaire(var22.getTiecivilite());
                     var4.setBiebaiIdProprietaire(var22.getTieid());
                     var4.setBiebaiTypeProprietaire(var22.getTieAssujettissement());
                  } else {
                     var4.setBiebaiNomProprietaire((String)null);
                     var4.setBiebaiCivilProprietaire((String)null);
                     var4.setBiebaiIdProprietaire(0L);
                     var4.setBiebaiTypeProprietaire(0);
                  }
               } else {
                  var4.setBiebaiNomProprietaire((String)null);
                  var4.setBiebaiCivilProprietaire((String)null);
                  var4.setBiebaiIdProprietaire(0L);
                  var4.setBiebaiTypeProprietaire(0);
               }

               if (var4.getBiebaiTypeProprietaire() != 0 && var4.getBiebaiTypeProprietaire() != 2) {
                  double var13 = var2.myRoundDevise(var4.getBiebaiLoyerBrut() * (double)var4.getBiebaiTauxIrpp() / 100.0D, this.structureLog.getStrdevise());
                  var4.setBiebaiIrpp(var13);
               } else {
                  var4.setBiebaiIrpp(0.0D);
               }

               var4.setBiebaiAnnee(var4.getBiebaiDate().getYear() + 1900);
               if (var4.getBiebaiUsage() == 0) {
                  var4.setBiebaiExoTva(1);
               } else {
                  var4.setBiebaiExoTva(0);
               }

               var4.setBiebaiExoTom(0);
               if (var4.getBiebaiEtat() == 0) {
                  var4.setBiebaiEtat(1);
               }

               var5.modif(var4, var7);
            }

            var8.commit();
         } catch (HibernateException var19) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculFacture() throws ParseException, HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des factures");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Chargement des factures....";
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      new ArrayList();
      this.exercicesVentesDao = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      List var3 = this.exercicesVentesDao.selectExercicesVentes((Session)null);
      new ExercicesVentes();
      new ArrayList();
      new BienFacture();
      BienFactureDao var7 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      BienDao var8 = new BienDao(this.baseLog, this.utilInitHibernate);
      UtilDate var9 = new UtilDate();
      Date var10 = var9.dateToSQL(this.var_date_deb, "00", "00", "00");
      Date var11 = var9.dateToSQL(this.var_date_fin, "23", "23", "59");
      List var5 = var7.chargerFactures(var10, var11, (Session)null);
      if (var5.size() != 0) {
         int var12 = 0;
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var14 = null;

         try {
            var14 = var13.beginTransaction();
            new BienFacture();

            for(int var15 = 0; var15 < var5.size(); ++var15) {
               BienFacture var6 = (BienFacture)var5.get(var15);
               this.var_info = "Facture " + var6.getBiefacNum() + " Numero " + var15 + ", pour un total de " + var5.size() + " total ";
               if (var15 != 0) {
                  double var16 = (double)var5.size();
                  double var18 = var2.myRound(var16 / (double)var15, 4);
                  double var20 = var2.myRound(100.0D / var18, 2);
                  this.var_currentValue = (int)var20;
               }

               long var27 = (long)(var6.getBiefacDate().getYear() + 1900);

               for(int var28 = 0; var28 < var3.size(); ++var28) {
                  if (((ExercicesVentes)var3.get(var28)).getExevteId() == var27) {
                     ExercicesVentes var4 = (ExercicesVentes)var3.get(var28);
                     var6.setExerciceventes(var4);
                     break;
                  }
               }

               Tiers var29;
               if (var6.getBiefacTiers() != null && !var6.getBiefacTiers().isEmpty()) {
                  new Tiers();
                  var29 = this.tiersDao.selectTierSigle(var6.getBiefacTiers(), var13);
                  if (var29 != null) {
                     var6.setBiefacTiers(var29.getTiesigle());
                     var6.setBiefacNomTiers(var29.getTieraisonsocialenom());
                     var6.setBiefacCivilTiers(var29.getTiecivilite());
                     var6.setTiers(var29);
                  } else {
                     var6.setBiefacNomTiers((String)null);
                     var6.setBiefacCivilTiers((String)null);
                     var6.setTiers((Tiers)null);
                  }
               } else {
                  var6.setBiefacNomTiers((String)null);
                  var6.setBiefacCivilTiers((String)null);
                  var6.setTiers((Tiers)null);
               }

               if (var6.getBiefacProprietaire() != null && !var6.getBiefacProprietaire().isEmpty()) {
                  new Tiers();
                  var29 = this.tiersDao.selectTierSigle(var6.getBiefacProprietaire(), var13);
                  if (var29 != null) {
                     var6.setBiefacProprietaire(var29.getTiesigle());
                     var6.setBiefacNomProprietaire(var29.getTieraisonsocialenom());
                     var6.setBiefacCivilProprietaire(var29.getTiecivilite());
                     var6.setBiefacIdProprietaire(var29.getTieid());
                  } else {
                     var6.setBiefacNomProprietaire((String)null);
                     var6.setBiefacCivilProprietaire((String)null);
                     var6.setBiefacIdProprietaire(0L);
                  }
               } else {
                  var6.setBiefacNomProprietaire((String)null);
                  var6.setBiefacCivilProprietaire((String)null);
                  var6.setBiefacIdProprietaire(0L);
               }

               new Bien();
               if (var6.getBiefacBien() != null && !var6.getBiefacBien().isEmpty()) {
                  Bien var30 = var8.logBienNum(var6.getBiefacBien(), var13);
                  if (var30 != null) {
                     var6.setBiefacBien(var30.getBieNum());
                     var6.setBien(var30);
                  } else {
                     var6.setBien((Bien)null);
                  }
               } else {
                  var6.setBien((Bien)null);
               }

               var6.setUsers(this.usersLog);
               String var19;
               if (var6.getBiefacObject() != null && !var6.getBiefacObject().isEmpty() && var6.getBiefacObject().contains("Â°")) {
                  var19 = var6.getBiefacObject().replace("Â°", "e");
                  var6.setBiefacObject(var19);
               }

               if (var6.getBiefacObject() != null && !var6.getBiefacObject().isEmpty() && var6.getBiefacObject().contains("Ã©")) {
                  var19 = var6.getBiefacObject().replace("Ã©", "é");
                  var6.setBiefacObject(var19);
               }

               if (var6.getBiefacObject() != null && !var6.getBiefacObject().isEmpty() && var6.getBiefacObject().contains("Ã¨")) {
                  var19 = var6.getBiefacObject().replace("Ã¨", "è");
                  var6.setBiefacObject(var19);
               }

               var7.modif(var6, var13);
               ++var12;
               if (var12 >= 500) {
                  var13.flush();
                  var12 = 0;
               }
            }

            var14.commit();
         } catch (HibernateException var25) {
            if (var14 != null) {
               var14.rollback();
            }

            throw var25;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculReglement() throws ParseException, HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des règlements");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      new ArrayList();
      new Reglements();
      ReglementsDao var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.var_info = "Chargement des tiers....";
      new Tiers();
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var7 = this.tiersDao.chargerLesTiers("102", (Session)null);
      this.var_info = "Chargement des factures....";
      new BienFacture();
      BienFactureDao var9 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var10 = var9.rechercheFactureRequete(" biefacId>0", (Session)null);
      this.var_info = "Chargement des règlements....";
      UtilDate var11 = new UtilDate();
      String var12 = var11.dateToStringSQLLight(this.var_date_deb);
      String var13 = var11.dateToStringSQLLight(this.var_date_fin);
      ArrayList var14 = new ArrayList();
      List var3 = var5.selectFind("100", "100", var14, "100", "", "", var12, var13, 0, 0L, 0, var14, var14, 0.0D, (Session)null);
      if (var3.size() != 0) {
         int var15 = 0;
         Session var16 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
         Transaction var17 = null;

         try {
            var17 = var16.beginTransaction();
            new Reglements();

            for(int var18 = 0; var18 < var3.size(); ++var18) {
               Reglements var4 = (Reglements)var3.get(var18);
               this.var_info = "Reglements " + var4.getRglId() + " Numero " + var18 + ", pour un total de " + var3.size() + " total ";
               if (var18 != 0) {
                  double var19 = (double)var3.size();
                  double var21 = var2.myRound(var19 / (double)var18, 4);
                  double var23 = var2.myRound(100.0D / var21, 2);
                  this.var_currentValue = (int)var23;
               }

               int var30;
               if (var4.getRglNomTiers() != null && !var4.getRglNomTiers().isEmpty() && var4.getRglIdTiers() == 0L) {
                  Tiers var6 = null;
                  if (var7.size() != 0) {
                     for(var30 = 0; var30 < var7.size(); ++var30) {
                        if (((Tiers)var7.get(var30)).getTiesigle().equals(var4.getRglNomTiers())) {
                           var6 = (Tiers)var7.get(var30);
                           break;
                        }
                     }
                  }

                  if (var6 != null) {
                     var4.setRglNomTiers(var6.getTieraisonsocialenom());
                     var4.setRglIdTiers(var6.getTieid());
                  }
               }

               var4.setRglTypeTiers(0);
               var4.setRglCategorie(20);
               var4.setRglNatureDoc(25);
               if (var4.getRglDocument() != null && !var4.getRglDocument().isEmpty()) {
                  BienFacture var8 = null;
                  if (var10.size() != 0) {
                     for(var30 = 0; var30 < var10.size(); ++var30) {
                        if (((BienFacture)var10.get(var30)).getBiefacNum().equals(var4.getRglDocument())) {
                           var8 = (BienFacture)var10.get(var30);
                           break;
                        }
                     }
                  }

                  if (var8 != null) {
                     var4.setRglIdDocument(var8.getBiefacId());
                  }
               }

               var4.setRglDevise("XOF");
               var4.setRglCodeReceptrice("");
               String var31 = "";
               if (var4.getRglDateReg().getMonth() + 1 <= 9) {
                  var31 = "0" + (var4.getRglDateReg().getMonth() + 1);
               } else {
                  var31 = "" + (var4.getRglDateReg().getMonth() + 1);
               }

               String var20 = "" + (var4.getRglDateReg().getYear() + 1900);
               var4.setRglPeriode(var31 + ":" + var20);
               var4.setRglCle1(var4.getRglCodeCaiss() + ":" + var4.getRglPeriode());
               String var32 = var11.dateToStringSQLLight(var4.getRglDateReg());
               var4.setRglCle2(var4.getRglCodeCaiss() + ":" + var32);
               var4.setRglCle3(var4.getRglCodeReceptrice() + ":" + var4.getRglPeriode());
               var4.setRglCle4(var4.getRglCodeReceptrice() + ":" + var32);
               var5.modifierReg(var4, var16);
               ++var15;
               if (var15 >= 500) {
                  var16.flush();
                  var15 = 0;
               }
            }

            var17.commit();
         } catch (HibernateException var28) {
            if (var17 != null) {
               var17.rollback();
            }

            throw var28;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void recalculReglementFactures() throws ParseException, HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("recalcul des règlements des factures");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      new ArrayList();
      new Reglements();
      ReglementsDao var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.var_info = "Chargement des factures....";
      UtilDate var6 = new UtilDate();
      var6.dateToStringSQLLight(this.var_date_deb);
      var6.dateToStringSQLLight(this.var_date_fin);
      new BienFacture();
      BienFactureDao var10 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var11 = var10.chargerFactures(this.var_date_deb, this.var_date_fin, (Session)null);
      this.var_info = "Chargement des règlements....";
      List var3 = var5.rechercheReglementsRequete(" rglNatureDoc=165", (Session)null);
      if (var11.size() != 0) {
         int var12 = 0;
         Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var14 = null;

         try {
            var14 = var13.beginTransaction();
            new BienFacture();

            for(int var15 = 0; var15 < var11.size(); ++var15) {
               BienFacture var9 = (BienFacture)var11.get(var15);
               this.var_info = "Facture " + var9.getBiefacNum() + " Numero " + var15 + ", pour un total de " + var11.size() + " total ";
               double var16;
               if (var15 != 0) {
                  var16 = (double)var11.size();
                  double var18 = var2.myRound(var16 / (double)var15, 4);
                  double var20 = var2.myRound(100.0D / var18, 2);
                  this.var_currentValue = (int)var20;
               }

               if (var3.size() != 0) {
                  Reglements var4 = null;
                  var16 = 0.0D;

                  for(int var27 = 0; var27 < var3.size(); ++var27) {
                     if (((Reglements)var3.get(var27)).getRglIdDocument() == var9.getBiefacId()) {
                        var4 = (Reglements)var3.get(var27);
                        var16 += var4.getRglRecette();
                     }
                  }

                  if (var4 != null) {
                     var9.setBiefacTotReglement(var16);
                     var9.setBiefacDateLastReg(var4.getRglDateReg());
                     if (var9.getBiefacTotReglement() >= var9.getBiefacTotTtc()) {
                        var9.setBiefacSolde(1);
                     } else {
                        var9.setBiefacSolde(0);
                     }
                  } else {
                     var9.setBiefacTotReglement(0.0D);
                     var9.setBiefacDateLastReg((Date)null);
                     var9.setBiefacSolde(0);
                  }

                  var10.modif(var9, var13);
                  ++var12;
                  if (var12 >= 500) {
                     var13.flush();
                     var12 = 0;
                  }
               }
            }

            var14.commit();
         } catch (HibernateException var25) {
            if (var14 != null) {
               var14.rollback();
            }

            throw var25;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void nettoyerTiersImmobilier() throws ParseException, HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("nettoyage des tiers immobilier");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      this.var_info = "Chargement des factures....";
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      UtilNombre var2 = new UtilNombre();
      new ArrayList();
      new Tiers();
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      List var3 = this.tiersDao.selectTiers();
      new ArrayList();
      BienFactureDao var6 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
      UtilDate var7 = new UtilDate();
      Date var8 = var7.dateToSQL(var7.stringToDateSQLLight("2010-01-01"), "00", "00", "00");
      Date var9 = var7.dateToSQL(new Date(), "23", "23", "59");
      List var5 = var6.chargerFactures(var8, var9, (Session)null);
      if (var3.size() != 0) {
         boolean var10 = false;
         Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         Transaction var12 = null;

         try {
            var12 = var11.beginTransaction();

            for(int var13 = 0; var13 < var3.size(); ++var13) {
               Tiers var4 = (Tiers)var3.get(var13);
               this.var_info = "Tiers " + var4.getTieraisonsocialenom() + " Numero " + var13 + ", pour un total de " + var3.size() + " total ";
               if (var13 != 0) {
                  double var14 = (double)var3.size();
                  double var16 = var2.myRound(var14 / (double)var13, 4);
                  double var18 = var2.myRound(100.0D / var16, 2);
                  this.var_currentValue = (int)var18;
               }

               boolean var25 = false;
               boolean var15 = false;
               int var26;
               if (var4.getTietype().equals("3")) {
                  for(var26 = 0; var26 < var5.size(); ++var26) {
                     if (((BienFacture)var5.get(var26)).getTiers().getTieid() == var4.getTieid()) {
                        var25 = true;
                        break;
                     }
                  }
               } else {
                  for(var26 = 0; var26 < var5.size(); ++var26) {
                     if (((BienFacture)var5.get(var26)).getBiefacIdProprietaire() == var4.getTieid()) {
                        var15 = true;
                        break;
                     }
                  }
               }

               if (!var25 && !var15) {
                  var4.setTieetat(2);
                  this.tiersDao.modif(var4, var11);
               }
            }

            var12.commit();
         } catch (HibernateException var23) {
            if (var12 != null) {
               var12.rollback();
            }

            throw var23;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées..");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void suppressionDocumentImmobilier() throws HibernateException, NamingException {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      Espion var1 = new Espion();
      var1.setEspdtecreat(new Date());
      var1.setUsers(this.usersLog);
      var1.setEspaction("suppression des documents immobiliers");
      var1.setEsptype(0);
      this.espionDao.mAJEspion(var1);
      new UtilNombre();
      this.var_currentValue = 0;
      this.var_showBarProg = true;
      this.var_info = "Suppression des documents immobilier.";
      Utilitaires_Ventes var3 = new Utilitaires_Ventes();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (this.sup_devis) {
            ++this.var_currentValue;
            this.var_info = "Suppression des APPELS DE CHARGES en cours....";
            var3.suppressionAppelCharge(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bc) {
            ++this.var_currentValue;
            this.var_info = "Suppression des FACTURES DE CHARGES en cours....";
            var3.suppressionFactureCharge(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         if (this.sup_bl) {
            ++this.var_currentValue;
            this.var_info = "Suppression des FACTURES LOCATIONS en cours....";
            var3.suppressionFactureLocation(this.var_date_deb, this.var_date_fin, this.structureLog, this.usersLog, this.baseLog, this.utilInitHibernate, var4);
            var4.flush();
         }

         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_showBarProg = false;
      this.choixModule = "moduleUtilitaires";
      this.choixLigne = "";
      this.formRecherche.setMessageTexte("Opérations effectuées...");
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public void intEspion() throws ParseException {
      this.var_plan_origine = 0;
      UtilDate var1 = new UtilDate();
      if (this.var_date_deb == null) {
         this.var_date_deb = var1.datePremierJourAnnee(new Date());
      }

      if (this.var_date_fin == null) {
         this.var_date_fin = var1.dateDernierJourAnnee(new Date());
      }

      this.var_info = "";
      ArrayList var2 = new ArrayList();
      this.dataModelEcrituresDetruites.setWrappedData(var2);
   }

   public void analyseActivite() throws HibernateException, HibernateException, NamingException, ParseException {
      UtilDate var1 = new UtilDate();
      if (this.var_date_deb == null) {
         this.var_date_deb = var1.datePremierJourAnnee(new Date());
      }

      if (this.var_date_fin == null) {
         this.var_date_fin = var1.dateDernierJourAnnee(new Date());
      }

      String var2 = var1.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
      String var3 = var1.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
      new ArrayList();
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      List var4 = this.espionDao.rechercheEspion(this.var_plan_origine, this.var_info, var2, var3);
      this.dataModelEcrituresDetruites.setWrappedData(var4);
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public DataModel getDataModelMenuHorizontal() {
      return this.dataModelMenuHorizontal;
   }

   public void setDataModelMenuHorizontal(DataModel var1) {
      this.dataModelMenuHorizontal = var1;
   }

   public String getMods() {
      return this.mods;
   }

   public void setMods(String var1) {
      this.mods = var1;
   }

   public DataModel getDataModelModuleParam() {
      return this.dataModelModuleParam;
   }

   public void setDataModelModuleParam(DataModel var1) {
      this.dataModelModuleParam = var1;
   }

   public String getChoixModule() {
      return this.choixModule;
   }

   public void setChoixModule(String var1) {
      this.choixModule = var1;
   }

   public long getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(long var1) {
      this.selectedExo = var1;
   }

   public int getTaille() {
      return this.taille;
   }

   public void setTaille(int var1) {
      this.taille = var1;
   }

   public String getChoixLigne() {
      return this.choixLigne;
   }

   public void setChoixLigne(String var1) {
      this.choixLigne = var1;
   }

   public List getMesJournauxComptables() {
      return this.mesJournauxComptables;
   }

   public void setMesJournauxComptables(List var1) {
      this.mesJournauxComptables = var1;
   }

   public DataModel getDataModelUtilAchats() {
      return this.dataModelUtilAchats;
   }

   public void setDataModelUtilAchats(DataModel var1) {
      this.dataModelUtilAchats = var1;
   }

   public DataModel getDataModelUtilCompta() {
      return this.dataModelUtilCompta;
   }

   public void setDataModelUtilCompta(DataModel var1) {
      this.dataModelUtilCompta = var1;
   }

   public DataModel getDataModelUtilMedical() {
      return this.dataModelUtilMedical;
   }

   public void setDataModelUtilMedical(DataModel var1) {
      this.dataModelUtilMedical = var1;
   }

   public DataModel getDataModelUtilParc() {
      return this.dataModelUtilParc;
   }

   public void setDataModelUtilParc(DataModel var1) {
      this.dataModelUtilParc = var1;
   }

   public DataModel getDataModelUtilPaye() {
      return this.dataModelUtilPaye;
   }

   public void setDataModelUtilPaye(DataModel var1) {
      this.dataModelUtilPaye = var1;
   }

   public DataModel getDataModelUtilTiers() {
      return this.dataModelUtilTiers;
   }

   public void setDataModelUtilTiers(DataModel var1) {
      this.dataModelUtilTiers = var1;
   }

   public DataModel getDataModelUtilVentes() {
      return this.dataModelUtilVentes;
   }

   public void setDataModelUtilVentes(DataModel var1) {
      this.dataModelUtilVentes = var1;
   }

   public DataModel getDataModelUtilTreso() {
      return this.dataModelUtilTreso;
   }

   public void setDataModelUtilTreso(DataModel var1) {
      this.dataModelUtilTreso = var1;
   }

   public boolean isAccesAchats() {
      return this.accesAchats;
   }

   public void setAccesAchats(boolean var1) {
      this.accesAchats = var1;
   }

   public boolean isAccesCompta() {
      return this.accesCompta;
   }

   public void setAccesCompta(boolean var1) {
      this.accesCompta = var1;
   }

   public boolean isAccesMedical() {
      return this.accesMedical;
   }

   public void setAccesMedical(boolean var1) {
      this.accesMedical = var1;
   }

   public boolean isAccesParc() {
      return this.accesParc;
   }

   public void setAccesParc(boolean var1) {
      this.accesParc = var1;
   }

   public boolean isAccesPaye() {
      return this.accesPaye;
   }

   public void setAccesPaye(boolean var1) {
      this.accesPaye = var1;
   }

   public boolean isAccesTreso() {
      return this.accesTreso;
   }

   public void setAccesTreso(boolean var1) {
      this.accesTreso = var1;
   }

   public boolean isAccesVentes() {
      return this.accesVentes;
   }

   public void setAccesVentes(boolean var1) {
      this.accesVentes = var1;
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

   public UtilInitHibernate getInitHibernateSessionFactory_2() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public int getVar_plan_destination() {
      return this.var_plan_destination;
   }

   public void setVar_plan_destination(int var1) {
      this.var_plan_destination = var1;
   }

   public int getVar_plan_origine() {
      return this.var_plan_origine;
   }

   public void setVar_plan_origine(int var1) {
      this.var_plan_origine = var1;
   }

   public MenuModule getMenuModule() {
      return this.menuModule;
   }

   public void setMenuModule(MenuModule var1) {
      this.menuModule = var1;
   }

   public Date getVar_date_deb() {
      return this.var_date_deb;
   }

   public void setVar_date_deb(Date var1) {
      this.var_date_deb = var1;
   }

   public Date getVar_date_fin() {
      return this.var_date_fin;
   }

   public void setVar_date_fin(Date var1) {
      this.var_date_fin = var1;
   }

   public String getVar_journal() {
      return this.var_journal;
   }

   public void setVar_journal(String var1) {
      this.var_journal = var1;
   }

   public DataModel getDataModelDepot() {
      return this.dataModelDepot;
   }

   public void setDataModelDepot(DataModel var1) {
      this.dataModelDepot = var1;
   }

   public DataModel getDataModelFamille() {
      return this.dataModelFamille;
   }

   public void setDataModelFamille(DataModel var1) {
      this.dataModelFamille = var1;
   }

   public DataModel getDataModelTarif() {
      return this.dataModelTarif;
   }

   public void setDataModelTarif(DataModel var1) {
      this.dataModelTarif = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public DataModel getDataModelTiersDestinataires() {
      return this.dataModelTiersDestinataires;
   }

   public void setDataModelTiersDestinataires(DataModel var1) {
      this.dataModelTiersDestinataires = var1;
   }

   public DataModel getDataModelTiersOrigines() {
      return this.dataModelTiersOrigines;
   }

   public void setDataModelTiersOrigines(DataModel var1) {
      this.dataModelTiersOrigines = var1;
   }

   public String getCompteDestinataire() {
      return this.compteDestinataire;
   }

   public void setCompteDestinataire(String var1) {
      this.compteDestinataire = var1;
   }

   public String getCompteOrigine() {
      return this.compteOrigine;
   }

   public void setCompteOrigine(String var1) {
      this.compteOrigine = var1;
   }

   public String getGenreDestinataire() {
      return this.genreDestinataire;
   }

   public void setGenreDestinataire(String var1) {
      this.genreDestinataire = var1;
   }

   public String getGenreOrigine() {
      return this.genreOrigine;
   }

   public void setGenreOrigine(String var1) {
      this.genreOrigine = var1;
   }

   public long getIdDestinataire() {
      return this.idDestinataire;
   }

   public void setIdDestinataire(long var1) {
      this.idDestinataire = var1;
   }

   public long getIdOrigine() {
      return this.idOrigine;
   }

   public void setIdOrigine(long var1) {
      this.idOrigine = var1;
   }

   public List getLesTiersDestinataires() {
      return this.lesTiersDestinataires;
   }

   public void setLesTiersDestinataires(List var1) {
      this.lesTiersDestinataires = var1;
   }

   public List getLesTiersOrigines() {
      return this.lesTiersOrigines;
   }

   public void setLesTiersOrigines(List var1) {
      this.lesTiersOrigines = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public String getBalSelectionnee() {
      return this.balSelectionnee;
   }

   public void setBalSelectionnee(String var1) {
      this.balSelectionnee = var1;
   }

   public List getLesBalsItems() {
      return this.lesBalsItems;
   }

   public void setLesBalsItems(List var1) {
      this.lesBalsItems = var1;
   }

   public String getNomStructureEnCours() {
      return this.nomStructureEnCours;
   }

   public void setNomStructureEnCours(String var1) {
      this.nomStructureEnCours = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public DataModel getDataModelEcrituresDetruites() {
      return this.dataModelEcrituresDetruites;
   }

   public void setDataModelEcrituresDetruites(DataModel var1) {
      this.dataModelEcrituresDetruites = var1;
   }

   public String getDossierCodeNew() {
      return this.dossierCodeNew;
   }

   public void setDossierCodeNew(String var1) {
      this.dossierCodeNew = var1;
   }

   public String getDossierCodeOld() {
      return this.dossierCodeOld;
   }

   public void setDossierCodeOld(String var1) {
      this.dossierCodeOld = var1;
   }

   public String getDossierLibelleNew() {
      return this.dossierLibelleNew;
   }

   public void setDossierLibelleNew(String var1) {
      this.dossierLibelleNew = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public boolean isAccesImmobilier() {
      return this.accesImmobilier;
   }

   public void setAccesImmobilier(boolean var1) {
      this.accesImmobilier = var1;
   }

   public DataModel getDataModelUtilImmobilier() {
      return this.dataModelUtilImmobilier;
   }

   public void setDataModelUtilImmobilier(DataModel var1) {
      this.dataModelUtilImmobilier = var1;
   }

   public DataModel getDataModelDocumentEntete() {
      return this.dataModelDocumentEntete;
   }

   public void setDataModelDocumentEntete(DataModel var1) {
      this.dataModelDocumentEntete = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelEcrituresPB() {
      return this.dataModelEcrituresPB;
   }

   public void setDataModelEcrituresPB(DataModel var1) {
      this.dataModelEcrituresPB = var1;
   }

   public List getLesSalarieItems() {
      return this.lesSalarieItems;
   }

   public void setLesSalarieItems(List var1) {
      this.lesSalarieItems = var1;
   }

   public long getVar_salarie() {
      return this.var_salarie;
   }

   public void setVar_salarie(long var1) {
      this.var_salarie = var1;
   }

   public List getLesContratItems() {
      return this.lesContratItems;
   }

   public void setLesContratItems(List var1) {
      this.lesContratItems = var1;
   }

   public long getVar_contrat() {
      return this.var_contrat;
   }

   public void setVar_contrat(long var1) {
      this.var_contrat = var1;
   }

   public DataModel getDataModelBulletinsLigne() {
      return this.dataModelBulletinsLigne;
   }

   public void setDataModelBulletinsLigne(DataModel var1) {
      this.dataModelBulletinsLigne = var1;
   }

   public boolean isValideBulletin() {
      return this.valideBulletin;
   }

   public void setValideBulletin(boolean var1) {
      this.valideBulletin = var1;
   }

   public String getPatientDestination() {
      return this.patientDestination;
   }

   public void setPatientDestination(String var1) {
      this.patientDestination = var1;
   }

   public String getPatientOrigine() {
      return this.patientOrigine;
   }

   public void setPatientOrigine(String var1) {
      this.patientOrigine = var1;
   }

   public DataModel getDataModelService() {
      return this.dataModelService;
   }

   public void setDataModelService(DataModel var1) {
      this.dataModelService = var1;
   }

   public List getMesUsersDestinataresItems() {
      return this.mesUsersDestinataresItems;
   }

   public void setMesUsersDestinataresItems(List var1) {
      this.mesUsersDestinataresItems = var1;
   }

   public List getMesUsersOriginesItems() {
      return this.mesUsersOriginesItems;
   }

   public void setMesUsersOriginesItems(List var1) {
      this.mesUsersOriginesItems = var1;
   }

   public long getUserIdDestinataire() {
      return this.userIdDestinataire;
   }

   public void setUserIdDestinataire(long var1) {
      this.userIdDestinataire = var1;
   }

   public long getUserIdOrigine() {
      return this.userIdOrigine;
   }

   public void setUserIdOrigine(long var1) {
      this.userIdOrigine = var1;
   }

   public DataModel getDataModelParapheur() {
      return this.dataModelParapheur;
   }

   public void setDataModelParapheur(DataModel var1) {
      this.dataModelParapheur = var1;
   }

   public DataModel getDataModelEvolution() {
      return this.dataModelEvolution;
   }

   public void setDataModelEvolution(DataModel var1) {
      this.dataModelEvolution = var1;
   }

   public String getModule() {
      return this.module;
   }

   public void setModule(String var1) {
      this.module = var1;
   }

   public boolean isSup_avoir() {
      return this.sup_avoir;
   }

   public void setSup_avoir(boolean var1) {
      this.sup_avoir = var1;
   }

   public boolean isSup_bc() {
      return this.sup_bc;
   }

   public void setSup_bc(boolean var1) {
      this.sup_bc = var1;
   }

   public boolean isSup_bl() {
      return this.sup_bl;
   }

   public void setSup_bl(boolean var1) {
      this.sup_bl = var1;
   }

   public boolean isSup_chargement() {
      return this.sup_chargement;
   }

   public void setSup_chargement(boolean var1) {
      this.sup_chargement = var1;
   }

   public boolean isSup_devis() {
      return this.sup_devis;
   }

   public void setSup_devis(boolean var1) {
      this.sup_devis = var1;
   }

   public boolean isSup_facture() {
      return this.sup_facture;
   }

   public void setSup_facture(boolean var1) {
      this.sup_facture = var1;
   }

   public boolean isSup_factureInterne() {
      return this.sup_factureInterne;
   }

   public void setSup_factureInterne(boolean var1) {
      this.sup_factureInterne = var1;
   }

   public boolean isSup_noteDebit() {
      return this.sup_noteDebit;
   }

   public void setSup_noteDebit(boolean var1) {
      this.sup_noteDebit = var1;
   }

   public boolean isSup_retour() {
      return this.sup_retour;
   }

   public void setSup_retour(boolean var1) {
      this.sup_retour = var1;
   }

   public boolean isSup_ticket() {
      return this.sup_ticket;
   }

   public void setSup_ticket(boolean var1) {
      this.sup_ticket = var1;
   }

   public boolean isSup_cmd() {
      return this.sup_cmd;
   }

   public void setSup_cmd(boolean var1) {
      this.sup_cmd = var1;
   }

   public boolean isSup_cotation() {
      return this.sup_cotation;
   }

   public void setSup_cotation(boolean var1) {
      this.sup_cotation = var1;
   }

   public boolean isSup_da() {
      return this.sup_da;
   }

   public void setSup_da(boolean var1) {
      this.sup_da = var1;
   }

   public boolean isSup_factureFrais() {
      return this.sup_factureFrais;
   }

   public void setSup_factureFrais(boolean var1) {
      this.sup_factureFrais = var1;
   }

   public boolean isSup_reception() {
      return this.sup_reception;
   }

   public void setSup_reception(boolean var1) {
      this.sup_reception = var1;
   }

   public boolean isSup_bin() {
      return this.sup_bin;
   }

   public void setSup_bin(boolean var1) {
      this.sup_bin = var1;
   }

   public boolean isSup_bout() {
      return this.sup_bout;
   }

   public void setSup_bout(boolean var1) {
      this.sup_bout = var1;
   }

   public boolean isSup_cession() {
      return this.sup_cession;
   }

   public void setSup_cession(boolean var1) {
      this.sup_cession = var1;
   }

   public boolean isSup_inventaire() {
      return this.sup_inventaire;
   }

   public void setSup_inventaire(boolean var1) {
      this.sup_inventaire = var1;
   }

   public boolean isSup_production() {
      return this.sup_production;
   }

   public void setSup_production(boolean var1) {
      this.sup_production = var1;
   }
}
