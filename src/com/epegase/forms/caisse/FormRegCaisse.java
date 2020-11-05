package com.epegase.forms.caisse;

import com.epegase.forms.achats.FormCommandeAchats;
import com.epegase.forms.achats.FormFactureAchats;
import com.epegase.forms.achats.FormFraisAchats;
import com.epegase.forms.achats.FormNoteDebitAchats;
import com.epegase.forms.commun.FormAnalytique;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.immobilier.FormAppelChargeImmobilier;
import com.epegase.forms.immobilier.FormFactureImmobilier;
import com.epegase.forms.medical.FormConsultationGene;
import com.epegase.forms.medical.FormHospitalisation;
import com.epegase.forms.medical.FormLaboratoire;
import com.epegase.forms.medical.FormPharmacie;
import com.epegase.forms.ventes.FormCommandeVentes;
import com.epegase.forms.ventes.FormDevisVentes;
import com.epegase.forms.ventes.FormFactureVentes;
import com.epegase.forms.ventes.FormLivraisonVentes;
import com.epegase.forms.ventes.FormNoteDebitVentes;
import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.AppelCharge;
import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.BienFacture;
import com.epegase.systeme.classe.BonDecaissementAchat;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.BonEntreCaiss;
import com.epegase.systeme.classe.BonSortieCaiss;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesJour;
import com.epegase.systeme.classe.CaissesOperations;
import com.epegase.systeme.classe.ChargementEntete;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CleAnalytique;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommissionEnteteVentes;
import com.epegase.systeme.classe.ConsultationActes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConsultationReglement;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ElevesFacture;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.HospitalisationCaution;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.HospitalisationMedi;
import com.epegase.systeme.classe.HospitalisationReglement;
import com.epegase.systeme.classe.HospitalisationSejour;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LaboratoireLigne;
import com.epegase.systeme.classe.LaboratoireReglement;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PatientLettreGarantie;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.PharmacieReglement;
import com.epegase.systeme.classe.PlanAnalytiqueRepartition;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.TraiteLigne;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.VirementInterne;
import com.epegase.systeme.control.BonCaisse;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.AppelChargeDao;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.BienFactureDao;
import com.epegase.systeme.dao.BonDecaissementAchatDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.BonEntreCaissDao;
import com.epegase.systeme.dao.BonSortieCaissDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CaissesJourDao;
import com.epegase.systeme.dao.CaissesOperationsDao;
import com.epegase.systeme.dao.ChargementEnteteDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CleAnalytiqueDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.CommissionEnteteVentesDao;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.ConsultationReglementDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.ElevesDao;
import com.epegase.systeme.dao.ElevesFactureDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.HospitalisationActesDao;
import com.epegase.systeme.dao.HospitalisationCautionDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.HospitalisationLaboDao;
import com.epegase.systeme.dao.HospitalisationMediDao;
import com.epegase.systeme.dao.HospitalisationPrestDao;
import com.epegase.systeme.dao.HospitalisationReglementDao;
import com.epegase.systeme.dao.HospitalisationSejourDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LaboratoireLigneDao;
import com.epegase.systeme.dao.LaboratoireReglementDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.PatientLettreGarantieDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.PharmacieReglementDao;
import com.epegase.systeme.dao.PlanAnalytiqueRepartitionDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.TraiteLigneDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.VirementInterneDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureTypeReglement;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

public class FormRegCaisse implements Serializable {
   private int typeVente;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private OptionCaisses optionCaisses;
   private OptionVentes optionVentes;
   private OptionComptabilite optionComptabilite;
   private ExercicesCaisse selectedExo;
   private ExercicesCaisse lastExo;
   private ExercicesAchats exercicesAchats;
   private ExercicesVentes exercicesVentes;
   private ExercicesComptable exercicesComptable;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private List mesOnglets;
   private int var_nb_max = 100;
   private String inpNature = "100";
   private int inpEtat = 1;
   private Date dateDebut;
   private Date dateFin;
   private String inpService = "100";
   private String inpCaisse = "100";
   private Date inpDate;
   private String recherchePiece = "";
   private String rechercheRecu = "";
   private double rechercheMontant = 0.0D;
   private String rechercheTiers = "";
   private List var_caisse_privee;
   private List var_caisse_publique;
   private List var_liste_groupe = new ArrayList();
   private List var_liste_sans_execution = new ArrayList();
   private List mesTiersItems = new ArrayList();
   private double totalRecette;
   private double totalDepense;
   private boolean var_valide = false;
   private Reglements reglements = new Reglements();
   private boolean existCaiss = false;
   private boolean affichBanq = false;
   private CalculChrono calculChrono;
   private boolean visibiliteBton = false;
   private String serieCaisse;
   private int natCaisse;
   private String var_titre_recu;
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private boolean var_site;
   private boolean var_departement;
   private boolean var_service;
   private boolean var_region;
   private boolean var_secteur;
   private boolean var_pdv;
   private boolean var_activite;
   private boolean var_dossier;
   private boolean var_parc;
   private boolean var_cle;
   private boolean var_budget;
   private boolean decoupageActivite = false;
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
   private List lesActivites;
   private CaissesCommerciales caissesCommerciales = new CaissesCommerciales();
   private CaissesCommercialesDao caissesCommercialesDao;
   private String var_caisse;
   private String var_modele;
   private String var_banque;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private boolean champCltVide = false;
   private boolean var_acc_descriptif = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean visibleOnglet = false;
   private boolean var_affiche_depot = false;
   private boolean var_depot = false;
   private boolean var_verrou_caisse = false;
   private String inputBanqEmetteur;
   private String inputBanqRecepteur;
   private int var_choix_modele;
   private String requete;
   private String filtre;
   private String format = "PDF";
   private String nomModeleListe;
   private String nomModeleDocument;
   private String nomRepMod;
   private boolean visibleOptionMail = false;
   private List documentImpressionItems = new ArrayList();
   private List listeImpressionItems = new ArrayList();
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean showModalPanelPrint = false;
   private Habilitation habilitation;
   private HabilitationDao habilitationDao;
   private Parapheur parapheur;
   private ParapheurDao parapheurDao;
   private ReglementsDao reglementsDao;
   private transient DataModel datamodelElement = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private BonCaisse bonCaisse = new BonCaisse();
   private List mesTypeTiers = new ArrayList();
   private List lesElements = new ArrayList();
   private BonSortieCaiss bonSortieCaiss = new BonSortieCaiss();
   private BonSortieCaissDao bonSortieCaissDao;
   private BonEntreCaiss bonEntreCaiss = new BonEntreCaiss();
   private BonEntreCaissDao bonEntreCaissDao;
   private VirementInterne virementInterne = new VirementInterne();
   private VirementInterneDao virementInterneDao;
   private BonEncaissementVente bonEncaissementVente = new BonEncaissementVente();
   private BonEncaissementVenteDao bonEncaissementVenteDao;
   private BonDecaissementAchat bonDecaissementAchat = new BonDecaissementAchat();
   private BonDecaissementAchatDao bonDecaissementAchatDao;
   private boolean var_affiche_banque;
   private boolean var_affiche_lettreGarantie;
   private String inputBanq;
   private String var_modeReglement;
   private double var_montant_recu;
   private double var_ecart;
   private boolean var_rendu;
   private String var_obs;
   private double var_timbre;
   private double var_aPayer;
   private List mesModesReglementsItem = new ArrayList();
   private List mesModesReglementsRecItem = new ArrayList();
   private boolean planfond_depasse = false;
   private Reglements regCheque;
   private double soldeCaisse;
   private boolean showModalpanelDetail = false;
   private String var_mode_reglement;
   private List mesModeReglements;
   private boolean showModalPanelMotifAnnuler = false;
   private boolean showModalPanelMotifSupprimer = false;
   private PlanComptable planComptable;
   private Users usersConcerne;
   private List lesPeriodes = new ArrayList();
   private String periode;
   private List mesCaissesItems = new ArrayList();
   private boolean visibleSuite = false;
   private String natureOperation;
   private CaissesOperations caissesOperations;
   private CaissesOperationsDao caissesOperationsDao;
   private List userOperationsCaisses;
   private List mesOperationsItems;
   private boolean var_garde;
   private Tiers tiers = new Tiers();
   private Patients patients = new Patients();
   private Eleves eleves = new Eleves();
   private double var_aEncaisser;
   private double var_montant_rendu;
   private double var_monnaie;
   private double var_total_bon;
   private String libActivite;
   private boolean affActivite = false;
   private Salaries salaries;
   private boolean var_verrouCaisseExecutrice;
   private List mesEmetteursItems;
   private List mesRecepteursItems;
   private JournauxComptablesDao journauxComptablesDao;
   private List listOperations = new ArrayList();
   private boolean affichage_espece = false;
   private boolean affichage_cheque = false;
   private boolean affichage_effet = false;
   private boolean affichage_bonCaisse = false;
   private List lesChequesARemettre;
   private List lesEffetsARemettre;
   private transient DataModel dataModelDetailAremettre;
   private List mesCaissesRecetteItems = new ArrayList();
   private List mesCaissesDepenseItems = new ArrayList();
   private List mesCaissesExecutriceItems = new ArrayList();
   private List mesCaissesRecusItems = new ArrayList();
   private List mesBonsCaisse;
   private List listCaisses;
   private List listCaissesAutorisees = new ArrayList();
   private List listRecusAutorises = new ArrayList();
   private List listFacture = new ArrayList();
   private List listLivraison = new ArrayList();
   private List listCommande = new ArrayList();
   private transient DataModel datamodelTransfert = new ListDataModel();
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private LivraisonEnteteVentesDao livraisonEnteteVentesDao;
   private CommandeEnteteVentesDao commandeEnteteVentesDao;
   private int typeDocumentAPayer;
   private TaxesVentesDao taxesVentesDao;
   private List listFactureEleve;
   private ElevesFactureDao elevesFactureDao;
   private List listAppelCharge = new ArrayList();
   private List listFactureLocation = new ArrayList();
   private List listCommission = new ArrayList();
   private CommissionEnteteVentesDao commissionEnteteVentesDao;
   private int val_b1 = 0;
   private int val_b2 = 0;
   private int val_b3 = 0;
   private int val_b4 = 0;
   private int val_b5 = 0;
   private int val_b6 = 0;
   private int val_b7 = 0;
   private int val_b8 = 0;
   private int val_b9 = 0;
   private int val_b10 = 0;
   private int val_p1 = 0;
   private int val_p2 = 0;
   private int val_p3 = 0;
   private int val_p4 = 0;
   private int val_p5 = 0;
   private int val_p6 = 0;
   private int val_p7 = 0;
   private int val_p8 = 0;
   private int val_p9 = 0;
   private int val_p10 = 0;
   private double tot_b1 = 0.0D;
   private double tot_b2 = 0.0D;
   private double tot_b3 = 0.0D;
   private double tot_b4 = 0.0D;
   private double tot_b5 = 0.0D;
   private double tot_b6 = 0.0D;
   private double tot_b7 = 0.0D;
   private double tot_b8 = 0.0D;
   private double tot_b9 = 0.0D;
   private double tot_b10 = 0.0D;
   private double tot_p1 = 0.0D;
   private double tot_p2 = 0.0D;
   private double tot_p3 = 0.0D;
   private double tot_p4 = 0.0D;
   private double tot_p5 = 0.0D;
   private double tot_p6 = 0.0D;
   private double tot_p7 = 0.0D;
   private double tot_p8 = 0.0D;
   private double tot_p9 = 0.0D;
   private double tot_p10 = 0.0D;
   private double totalBillet = 0.0D;
   private double totalPiece = 0.0D;
   private TraiteLigneDao traiteLigneDao;
   private Reglements reglementsOrigine;
   private boolean regul = false;
   private boolean showModalPanelEncaissement = false;
   private boolean projetActif;
   private List lesPostesBudgetaires = new ArrayList();
   private boolean affichageExoCompte;
   private ActivitesDao activitesDao;
   private String memoCompteTaxe;
   private float memoTauxTaxe;
   private boolean memoExoTaxe;
   private FormAnalytique formAnalytique;
   private transient DataModel dataModelCle1 = new ListDataModel();
   private List leDetailcle1 = new ArrayList();
   private transient DataModel dataModelCle2 = new ListDataModel();
   private List leDetailcle2 = new ArrayList();
   private CleAnalytique cleAnalytique;
   private CleAnalytiqueDao cleAnalytiqueDao;
   private boolean affiche_Cle1 = false;
   private boolean affiche_Cle2 = false;
   private boolean showModalpanelMessage = false;
   private String texteMessae;

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
      this.bonDecaissementAchatDao = new BonDecaissementAchatDao(this.baseLog, this.utilInitHibernate);
      this.bonSortieCaissDao = new BonSortieCaissDao(this.baseLog, this.utilInitHibernate);
      this.bonEntreCaissDao = new BonEntreCaissDao(this.baseLog, this.utilInitHibernate);
      this.virementInterneDao = new VirementInterneDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.caissesOperationsDao = new CaissesOperationsDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonEnteteVentesDao = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.elevesFactureDao = new ElevesFactureDao(this.baseLog, this.utilInitHibernate);
      this.commissionEnteteVentesDao = new CommissionEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.cleAnalytiqueDao = new CleAnalytiqueDao(this.baseLog, this.utilInitHibernate);
   }

   public void configCaisses(Session var1) throws HibernateException, NamingException {
      this.visibiliteBton = false;
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;
      this.mesTypeTiers = new ArrayList();
      boolean var5 = false;
      Object var6 = null;
      if (this.optionCaisses.getNbLigneMax() != null && !this.optionCaisses.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionCaisses.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.typeVente == 815) {
         var2 = true;
      } else {
         var2 = false;
      }

      var5 = false;
      var6 = var1.createQuery("SELECT COUNT(*) FROM ExercicesPaye").uniqueResult();
      int var11 = Integer.parseInt(var6.toString());
      if (var11 > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var2) {
         this.mesTypeTiers.add(new SelectItem("4", "Patient"));
         this.mesTypeTiers.add(new SelectItem("1", "Fournisseur"));
         if (var4) {
            this.mesTypeTiers.add(new SelectItem("2", "Agent"));
         }

         this.mesTypeTiers.add(new SelectItem("3", "Plan comptable"));
      } else if (var3) {
         this.mesTypeTiers.add(new SelectItem("5", "Elève"));
         this.mesTypeTiers.add(new SelectItem("1", "Fournisseur"));
         if (var4) {
            this.mesTypeTiers.add(new SelectItem("2", "Agent"));
         }

         this.mesTypeTiers.add(new SelectItem("3", "Plan comptable"));
      } else {
         this.mesTypeTiers.add(new SelectItem("0", "Client"));
         this.mesTypeTiers.add(new SelectItem("1", "Fournisseur"));
         if (var4) {
            this.mesTypeTiers.add(new SelectItem("2", "Agent"));
         }

         this.mesTypeTiers.add(new SelectItem("3", "Plan comptable"));
      }

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

      this.mesModesReglementsRecItem.clear();
      LectureTypeReglement var7 = new LectureTypeReglement(this.baseLog);
      new ArrayList();
      List var8 = var7.getMesTypeReglement();
      int var10;
      if (var8.size() != 0) {
         new ObjetCompte();

         for(var10 = 0; var10 < var8.size(); ++var10) {
            ObjetCompte var9 = (ObjetCompte)var8.get(var10);
            if (var9.isValide() && !var9.getCode().equals("11")) {
               this.mesModesReglementsRecItem.add(new SelectItem(var9.getCode() + ":" + var9.getNom_FR()));
            }
         }
      }

      this.chargerListeDocument();
      if (this.optionCaisses.getAxeSite().equals("true")) {
         this.var_site = true;
         this.var_departement = true;
         this.var_service = true;
      }

      if (this.optionCaisses.getAxeRegion().equals("true")) {
         this.var_region = true;
         this.var_secteur = true;
         this.var_pdv = true;
      }

      if (this.optionCaisses.getAxeActivite().equals("true")) {
         this.var_activite = true;
      } else {
         this.var_activite = false;
      }

      if (this.optionCaisses.getAxeParc().equals("true")) {
         this.var_parc = true;
      } else {
         this.var_parc = false;
      }

      if (this.optionCaisses.getAxeCles().equals("true")) {
         this.var_cle = true;
      } else {
         this.var_cle = false;
      }

      if (!this.optionCaisses.getAxeSite().equals("1") && !this.optionCaisses.getAxeSite().equals("2")) {
         this.var_dossier = false;
      } else {
         this.var_dossier = true;
      }

      this.var_budget = false;
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
      } else {
         this.decoupageActivite = false;
      }

      this.var_caisse_privee = new ArrayList();
      this.var_caisse_publique = new ArrayList();
      new ArrayList();
      List var12 = this.caissesCommercialesDao.selectActifCaisse(this.selectedExo.getExecaiId(), var1);
      if (var12.size() != 0) {
         for(var10 = 0; var10 < var12.size(); ++var10) {
            if (((CaissesCommerciales)var12.get(var10)).getCaiPrive() == 0) {
               this.var_caisse_publique.add(((CaissesCommerciales)var12.get(var10)).getCaiCode());
            } else if (((CaissesCommerciales)var12.get(var10)).getCaiPrive() == 1) {
               this.var_caisse_privee.add(((CaissesCommerciales)var12.get(var10)).getCaiCode());
            }
         }
      }

      this.var_caisse_publique.add("");
      this.var_caisse_publique.add((Object)null);
      this.projetActif = false;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty() && this.structureLog.getStrmod1().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty() && this.structureLog.getStrmod2().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty() && this.structureLog.getStrmod3().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty() && this.structureLog.getStrmod4().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty() && this.structureLog.getStrmod5().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty() && this.structureLog.getStrmod6().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty() && this.structureLog.getStrmod7().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty() && this.structureLog.getStrmod8().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty() && this.structureLog.getStrmod9().equals("40300")) {
         this.projetActif = true;
      } else if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty() && this.structureLog.getStrmod10().equals("40300")) {
         this.projetActif = true;
      }

      this.listCaissesAutorisees.clear();
      this.listRecusAutorises.clear();
      this.var_liste_sans_execution.clear();
      this.mesCaissesDepenseItems.clear();
      this.mesCaissesRecetteItems.clear();
      if (this.listCaisses.size() != 0) {
         for(var10 = 0; var10 < this.listCaisses.size(); ++var10) {
            if (((UsersChrono)this.listCaisses.get(var10)).getUsrchrCodeCaisse() != null && !((UsersChrono)this.listCaisses.get(var10)).getUsrchrCodeCaisse().isEmpty()) {
               if (((UsersChrono)this.listCaisses.get(var10)).getUsrchrNature() != 60) {
                  if (((UsersChrono)this.listCaisses.get(var10)).getUsrchrNature() == 61) {
                     this.listRecusAutorises.add(((UsersChrono)this.listCaisses.get(var10)).getUsrchrCodeCaisse());
                  }
               } else {
                  this.listCaissesAutorisees.add(((UsersChrono)this.listCaisses.get(var10)).getUsrchrCodeCaisse());
                  if (((UsersChrono)this.listCaisses.get(var10)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var10)).getUsrchrModeCaisse() == 1) {
                     this.mesCaissesDepenseItems.add(new SelectItem(((UsersChrono)this.listCaisses.get(var10)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var10)).getUsrchrLib()));
                  }

                  if (((UsersChrono)this.listCaisses.get(var10)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var10)).getUsrchrModeCaisse() == 2) {
                     this.mesCaissesRecetteItems.add(new SelectItem(((UsersChrono)this.listCaisses.get(var10)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var10)).getUsrchrLib()));
                  }

                  if (((UsersChrono)this.listCaisses.get(var10)).getUsrchrExecution() == 0) {
                     this.var_liste_sans_execution.add(((UsersChrono)this.listCaisses.get(var10)).getUsrchrCodeCaisse());
                  }
               }
            }
         }
      }

      this.selectionElementRecu();
   }

   public void recupererMoisEnCours(Session var1) throws NamingException, ParseException {
      this.dateDebut = this.utilDate.datePremierJourMois(new Date());
      this.dateFin = this.utilDate.dateDernierJourMois(new Date());
      Object var2 = new ArrayList();
      if (this.usersLog.getUsrRecus() == 3) {
         new ArrayList();
         List var3 = this.usersChronoDao.selectChronoByUserNat(this.usersLog, 61, var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               String var5 = ((SelectItem)var3.get(var4)).getValue().toString();
               String[] var6 = var5.split(":");
               ((List)var2).add(var6[0]);
            }
         } else {
            var2 = this.listCaissesAutorisees;
         }
      }

      this.chargerFind((List)var2, var1);
   }

   public void calculerLesDecoupagesActivites(Session var1) throws HibernateException, NamingException {
      if (this.decoupageActivite) {
         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            this.laColonne1Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode1(), var1);
         }

         if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
            this.laColonne2Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode2(), var1);
         }

         if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
            this.laColonne3Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode3(), var1);
         }
      }

      this.lesActivites = this.activitesDao.selectActivites(var1);
   }

   public void accesResteintUser() {
      this.var_liste_groupe.clear();
      if (this.usersLog.getUsrRecus() == 2 && this.usersLog.getGroupe().getGrpLie() != null && !this.usersLog.getGroupe().getGrpLie().isEmpty()) {
         if (this.usersLog.getGroupe().getGrpLie().contains(",")) {
            this.var_liste_groupe.add(this.usersLog.getUsrCollaboration());
            String[] var1 = this.usersLog.getGroupe().getGrpLie().split(",");

            for(int var2 = 0; var2 < var1.length; ++var2) {
               this.var_liste_groupe.add(var1[var2]);
            }
         } else {
            this.var_liste_groupe.add(this.usersLog.getUsrCollaboration());
            this.var_liste_groupe.add(this.usersLog.getGroupe().getGrpLie());
         }
      }

   }

   public void accesResteintGroupe() {
   }

   public void calculeNomRep(int var1, int var2) {
      if (var2 == 77) {
         this.nomRepMod = "operations" + File.separator + "cheques";
      } else if (var2 != 81 && var2 != 83) {
         if (var2 != 11 && var2 != 12 && var2 != 22 && var2 != 82 && var2 != 84) {
            if (var2 != 80 && var2 != 85) {
               if (var1 != 0 && var1 != 11) {
                  if (var1 != 1 && var1 != 10) {
                     if (var1 == 2) {
                        this.nomRepMod = "virements";
                     } else if (var1 == 3) {
                        this.nomRepMod = "traites";
                     } else if (var1 == 4) {
                        this.nomRepMod = "cartes";
                     } else if (var1 == 5) {
                        this.nomRepMod = "transferts";
                     } else if (var1 == 6) {
                        this.nomRepMod = "epaiements";
                     } else if (var1 == 7) {
                        this.nomRepMod = "credocs";
                     } else if (var1 == 8) {
                        this.nomRepMod = "factors";
                     } else if (var1 == 9) {
                        this.nomRepMod = "compenses";
                     } else if (var1 == 12) {
                        this.nomRepMod = "lettres_garantie";
                     } else if (var1 == 13) {
                        this.nomRepMod = "prelevements";
                     } else if (var1 == 14) {
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
            } else {
               this.nomRepMod = "operations" + File.separator + "especes";
            }
         } else {
            this.nomRepMod = "operations" + File.separator + "traites";
         }
      } else {
         this.nomRepMod = "operations" + File.separator + "cheques";
      }

      this.chargerModeleDocument();
   }

   public void chargerModeleDocument() {
      this.documentImpressionItems = new ArrayList();
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
                  this.documentImpressionItems.add(new SelectItem(var5));
               }
            }
         }
      }

   }

   public void chargerListeDocument() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.endsWith(".jasper")) {
               String var6 = var5.substring(0, var5.indexOf("."));
               this.listeImpressionItems.add(new SelectItem(var6));
            }
         }
      }

   }

   public void calculPeriode() throws ParseException {
      int var1 = 0;
      Date var2 = this.selectedExo.getExecaiDateDebut();
      GregorianCalendar var3 = new GregorianCalendar();
      var3.setTime(var2);
      Date var4 = this.selectedExo.getExecaiDateFin();
      GregorianCalendar var5 = new GregorianCalendar();
      var5.setTime(var4);
      var3.add(2, -1);
      var5.add(2, -1);
      String var6 = null;

      while(var3.compareTo(var5) < 0) {
         var3.add(2, 1);
         Date var7 = var3.getTime();
         var6 = this.formatPeriode(var7);
         ++var1;
         this.lesPeriodes.add(new SelectItem(var6));
      }

   }

   public String formatPeriode(Date var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
      var2.format(var1);
      String var3 = "" + var2.format(var1);
      String[] var4 = var3.split("-");
      String var5 = var4[0];
      String var6 = var4[1];
      String var7 = var4[2];
      String var8 = var6 + ":" + var7;
      return var8;
   }

   public void chargerSecteur() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.reglements.getRglRegion() != null && !this.reglements.getRglRegion().isEmpty() && this.reglements.getRglRegion().contains(":")) {
         new ArrayList();
         String[] var2 = this.reglements.getRglRegion().split(":");
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
      if (this.reglements.getRglSecteur() != null && !this.reglements.getRglSecteur().isEmpty() && this.reglements.getRglSecteur().contains(":")) {
         new ArrayList();
         String[] var2 = this.reglements.getRglSecteur().split(":");
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

   public void chargerDepartement() throws HibernateException, NamingException {
      this.mesDepartementsItems.clear();
      this.mesServicesItems.clear();
      if (this.reglements.getRglSite() != null && !this.reglements.getRglSite().isEmpty() && this.reglements.getRglSite().contains(":")) {
         new ArrayList();
         String[] var2 = this.reglements.getRglSite().split(":");
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
      if (this.reglements.getRglDepartement() != null && !this.reglements.getRglDepartement().isEmpty() && this.reglements.getRglDepartement().contains(":")) {
         new ArrayList();
         String[] var2 = this.reglements.getRglDepartement().split(":");
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

   public void fermerMessage() {
      this.showModalpanelMessage = false;
   }

   public void selectionElementRecu() {
      this.visibiliteBton = false;
      this.visibleOnglet = false;
      this.lesElements.clear();
      this.datamodelElement.setWrappedData(this.lesElements);
      this.bonCaisse = new BonCaisse();
      this.mesCaissesExecutriceItems.clear();
      this.mesCaissesRecusItems.clear();
      int var1;
      if (this.inpEtat == 1) {
         for(var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() != null && !((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse().isEmpty()) {
               this.mesCaissesExecutriceItems.add(new SelectItem(((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var1)).getUsrchrLib()));
            }
         }

         if (this.mesCaissesExecutriceItems.size() >= 1) {
            this.mesCaissesExecutriceItems.add(0, new SelectItem(100, "Toutes les caisses"));
         }

         if (this.mesCaissesExecutriceItems.size() != 0) {
            this.inpCaisse = ((SelectItem)this.mesCaissesExecutriceItems.get(0)).getValue().toString();
         } else {
            this.inpCaisse = "100";
         }
      } else if (this.inpEtat == 2) {
         this.rechercheMontant = 0.0D;
         this.recherchePiece = "";
         this.rechercheRecu = "";

         for(var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() != null && !((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse().isEmpty()) {
               this.mesCaissesRecusItems.add(new SelectItem(((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var1)).getUsrchrLib()));
            }
         }

         if (this.mesCaissesRecusItems.size() >= 1) {
            this.mesCaissesRecusItems.add(0, new SelectItem(100, "Toutes les caisses"));
         }

         if (this.mesCaissesRecusItems.size() != 0) {
            this.inpCaisse = ((SelectItem)this.mesCaissesRecusItems.get(0)).getValue().toString();
         } else {
            this.inpCaisse = "100";
         }
      }

   }

   public void chargerFind() throws HibernateException, NamingException, ParseException {
      this.chargerFind(this.listCaissesAutorisees, (Session)null);
   }

   public void chargerFind(List var1, Session var2) throws HibernateException, NamingException, ParseException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         var3 = true;
      }

      this.lesElements.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.totalDepense = 0.0D;
      this.totalRecette = 0.0D;
      if (this.usersLog.getUsrRecusJour() == 1) {
         this.dateDebut = new Date();
         this.dateFin = this.dateDebut;
      }

      String var4 = "";
      if (this.dateDebut.getDate() <= 9) {
         var4 = "0" + this.dateDebut.getDate();
      } else {
         var4 = "" + this.dateDebut.getDate();
      }

      String var5 = "";
      if (this.dateDebut.getMonth() + 1 <= 9) {
         var5 = "0" + (this.dateDebut.getMonth() + 1);
      } else {
         var5 = "" + (this.dateDebut.getMonth() + 1);
      }

      String var6 = "" + (this.dateDebut.getYear() + 1900);
      String var7 = var6 + "-" + var5 + "-" + var4;
      String var8 = "";
      if (this.dateFin.getDate() <= 9) {
         var8 = "0" + this.dateFin.getDate();
      } else {
         var8 = "" + this.dateFin.getDate();
      }

      String var9 = "";
      if (this.dateFin.getMonth() + 1 <= 9) {
         var9 = "0" + (this.dateFin.getMonth() + 1);
      } else {
         var9 = "" + (this.dateFin.getMonth() + 1);
      }

      String var10 = "" + (this.dateFin.getYear() + 1900);
      String var11 = var10 + "-" + var9 + "-" + var8;
      this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, 60, var2);
      if (this.usersChrono == null) {
         this.usersChrono = new UsersChrono();
      }

      String var12 = "";
      if (this.inpCaisse != null && !this.inpCaisse.isEmpty() && !this.inpCaisse.equals("100")) {
         if (this.inpCaisse.contains(":")) {
            String[] var13 = this.inpCaisse.split(":");
            var12 = var13[0];
         } else {
            var12 = this.inpCaisse;
         }
      } else {
         this.inpCaisse = "";
      }

      boolean var25 = false;
      List var14;
      int var16;
      if (this.inpEtat == 1) {
         new ArrayList();
         int var26 = Integer.parseInt(this.inpNature);
         var14 = this.bonSortieCaissDao.selectFind(1, var26, this.inpService, var1, var12, var7, var11, this.usersLog.getUsrRecus(), this.usersLog.getUsrid(), this.rechercheTiers, this.usersLog.getUsrJrxReserve(), this.var_caisse_publique, this.var_liste_groupe, var2);
         if (var14.size() != 0) {
            new BonSortieCaiss();

            for(var16 = 0; var16 < var14.size(); ++var16) {
               this.bonCaisse = new BonCaisse();
               BonSortieCaiss var15 = (BonSortieCaiss)var14.get(var16);
               this.bonCaisse.setBonDateMvt2((Date)null);
               this.bonCaisse.setOrigine(1);
               this.bonCaisse.setBonGrp(var15.getSortGrp());
               this.bonCaisse.setBonCaisActivite(var15.getSortActivite());
               this.bonCaisse.setBonCaisCodeBanqEmetteur(var15.getSortCodeBanq());
               this.bonCaisse.setBonCaisCodeBanqRecepteur((String)null);
               this.bonCaisse.setBonCaisCodeCaiss(var15.getSortCodeCaiss());
               this.bonCaisse.setBonCaisDate(var15.getSortDate());
               this.bonCaisse.setBonCaisDateRemise((Date)null);
               this.bonCaisse.setBonCaisDevise(var15.getSortDevise());
               this.bonCaisse.setBonCaisId(var15.getSortId());
               this.bonCaisse.setBonCaisLibBanqEmetteur(var15.getSortLibBanq());
               this.bonCaisse.setBonCaisLibBanqRecepteur((String)null);
               this.bonCaisse.setBonCaisLibCaiss(var15.getSortLibCaiss());
               this.bonCaisse.setBonCaisLibelle(var15.getSortLibelle());
               this.bonCaisse.setBonCaisMontant(var15.getSortMontant());
               this.bonCaisse.setBonCaisNature(var15.getSortNature());
               this.bonCaisse.setBonCaisNomResponsable(var15.getSortNomResponsable());
               this.bonCaisse.setBonCaisNomTiers(var15.getSortNomTiers());
               this.bonCaisse.setBonCaisIdTiers(0L);
               this.bonCaisse.setBonCaisNum(var15.getSortNum());
               this.bonCaisse.setBonCaisNumOrigine("");
               this.bonCaisse.setBonCaisIdOrigine(0L);
               this.bonCaisse.setBonCaisOperation("20");
               this.bonCaisse.setBonCaisSerie(var15.getSortSerie());
               this.bonCaisse.setBonCaisTypeReg(var15.getSortTypeReg());
               this.bonCaisse.setBonCaisTypeTiers(var15.getSortTypeTiers());
               this.bonCaisse.setBonCaisModeleImp(var15.getSortModeleImp());
               this.bonCaisse.setBonCaisClient("");
               this.bonCaisse.setBonCaisFacture("");
               this.bonCaisse.setBonCaisService("");
               this.bonCaisse.setBonDateCloture((Date)null);
               this.bonCaisse.setBonDateTransfert((Date)null);
               if (var15.getSortDepotTiers() == 1) {
                  this.bonCaisse.setBonCaisDepot(true);
               } else {
                  this.bonCaisse.setBonCaisDepot(false);
               }

               this.bonCaisse.setBonAnnuler(false);
               this.lesElements.add(this.bonCaisse);
            }
         }

         new ArrayList();
         var26 = Integer.parseInt(this.inpNature);
         List var27 = this.bonEntreCaissDao.selectFind(1, var26, this.inpService, var1, var12, var7, var11, this.usersLog.getUsrRecus(), this.usersLog.getUsrid(), this.rechercheTiers, this.usersLog.getUsrJrxReserve(), this.var_caisse_publique, this.var_liste_groupe, var2);
         if (var27.size() != 0) {
            new BonEntreCaiss();

            for(int var17 = 0; var17 < var27.size(); ++var17) {
               this.bonCaisse = new BonCaisse();
               BonEntreCaiss var29 = (BonEntreCaiss)var27.get(var17);
               this.bonCaisse.setBonDateMvt2((Date)null);
               this.bonCaisse.setOrigine(2);
               this.bonCaisse.setBonGrp(var29.getEntrGrp());
               this.bonCaisse.setBonCaisActivite(var29.getEntrActivite());
               this.bonCaisse.setBonCaisCodeBanqEmetteur(var29.getEntrCodeBanq());
               this.bonCaisse.setBonCaisCodeBanqRecepteur((String)null);
               this.bonCaisse.setBonCaisCodeCaiss(var29.getEntrCodeCaiss());
               this.bonCaisse.setBonCaisDate(var29.getEntrDate());
               this.bonCaisse.setBonCaisDateRemise((Date)null);
               this.bonCaisse.setBonCaisDevise(var29.getEntrDevise());
               this.bonCaisse.setBonCaisId(var29.getEntrId());
               this.bonCaisse.setBonCaisLibBanqEmetteur(var29.getEntrLibBanq());
               this.bonCaisse.setBonCaisLibBanqRecepteur((String)null);
               this.bonCaisse.setBonCaisLibCaiss(var29.getEntrLibCaiss());
               this.bonCaisse.setBonCaisLibelle(var29.getEntrLibelle());
               this.bonCaisse.setBonCaisMontant(var29.getEntrMontant());
               this.bonCaisse.setBonCaisNature(var29.getEntrNature());
               this.bonCaisse.setBonCaisNomResponsable(var29.getEntrNomResponsable());
               this.bonCaisse.setBonCaisNomTiers(var29.getEntrNomTiers());
               this.bonCaisse.setBonCaisIdTiers(0L);
               this.bonCaisse.setBonCaisNum(var29.getEntrNum());
               this.bonCaisse.setBonCaisNumOrigine("");
               this.bonCaisse.setBonCaisIdOrigine(0L);
               this.bonCaisse.setBonCaisOperation("10");
               this.bonCaisse.setBonCaisSerie(var29.getEntrSerie());
               this.bonCaisse.setBonCaisTypeReg(var29.getEntrTypeReg());
               this.bonCaisse.setBonCaisTypeTiers(var29.getEntrTypeTiers());
               this.bonCaisse.setBonCaisModeleImp(var29.getEntrModeleImp());
               this.bonCaisse.setBonCaisClient("");
               this.bonCaisse.setBonCaisFacture("");
               this.bonCaisse.setBonCaisService("");
               this.bonCaisse.setBonDateCloture((Date)null);
               this.bonCaisse.setBonDateTransfert((Date)null);
               if (var29.getEntrDepotTiers() == 1) {
                  this.bonCaisse.setBonCaisDepot(true);
               } else {
                  this.bonCaisse.setBonCaisDepot(false);
               }

               this.bonCaisse.setBonAnnuler(false);
               this.lesElements.add(this.bonCaisse);
            }
         }

         new ArrayList();
         var26 = Integer.parseInt(this.inpNature);
         List var30 = this.virementInterneDao.selectFind(1, var26, this.inpService, var1, var12, var7, var11, this.usersLog.getUsrRecus(), this.usersLog.getUsrid(), this.usersLog.getUsrJrxReserve(), this.var_caisse_publique, this.var_liste_groupe, var2);
         if (var30.size() != 0) {
            new VirementInterne();

            for(int var18 = 0; var18 < var30.size(); ++var18) {
               this.bonCaisse = new BonCaisse();
               VirementInterne var31 = (VirementInterne)var30.get(var18);
               this.bonCaisse.setBonDateMvt2((Date)null);
               this.bonCaisse.setOrigine(3);
               this.bonCaisse.setBonGrp(var31.getVirGrp());
               this.bonCaisse.setBonCaisActivite(var31.getVirActivite());
               this.bonCaisse.setBonCaisCodeBanqEmetteur(var31.getVirCodEmetrice());
               this.bonCaisse.setBonCaisCodeBanqRecepteur(var31.getVirCodReceptrice());
               this.bonCaisse.setBonCaisCodeCaiss(var31.getVirCodeCaiss());
               this.bonCaisse.setBonCaisDate(var31.getVirDate());
               this.bonCaisse.setBonCaisDateRemise((Date)null);
               this.bonCaisse.setBonCaisDevise(var31.getVirDevise());
               this.bonCaisse.setBonCaisId(var31.getVirId());
               this.bonCaisse.setBonCaisLibBanqEmetteur(var31.getVirNomEmetrice());
               this.bonCaisse.setBonCaisLibBanqRecepteur(var31.getVirNomReceptrice());
               this.bonCaisse.setBonCaisLibCaiss(var31.getVirLibCaiss());
               this.bonCaisse.setBonCaisLibelle(var31.getVirLibelle());
               this.bonCaisse.setBonCaisMontant(var31.getVirMontant());
               this.bonCaisse.setBonCaisNature(var31.getVirNature());
               this.bonCaisse.setBonCaisNomResponsable(var31.getVirNomResponsable());
               this.bonCaisse.setBonCaisNomTiers("");
               this.bonCaisse.setBonCaisIdTiers(0L);
               this.bonCaisse.setBonCaisNum(var31.getVirNum());
               this.bonCaisse.setBonCaisNumOrigine("");
               this.bonCaisse.setBonCaisIdOrigine(0L);
               this.bonCaisse.setBonCaisOperation("");
               this.bonCaisse.setBonCaisSerie(var31.getVirSerie());
               this.bonCaisse.setBonCaisTypeReg(var31.getVirTypeReg());
               this.bonCaisse.setBonCaisTypeTiers(0);
               this.bonCaisse.setBonCaisModeleImp(var31.getVirModeleImp());
               this.bonCaisse.setBonCaisClient("");
               this.bonCaisse.setBonCaisFacture("");
               this.bonCaisse.setBonCaisService("");
               this.bonCaisse.setBonDateCloture((Date)null);
               this.bonCaisse.setBonDateTransfert((Date)null);
               this.bonCaisse.setBonCaisDepot(false);
               this.bonCaisse.setBonAnnuler(false);
               this.lesElements.add(this.bonCaisse);
            }
         }

         new ArrayList();
         var26 = Integer.parseInt(this.inpNature);
         List var32 = this.bonEncaissementVenteDao.selectFind(0, var26, this.inpService, var1, var12, var7, var11, this.usersLog.getUsrRecus(), this.usersLog.getUsrid(), this.rechercheTiers, this.usersLog.getUsrJrxReserve(), this.var_caisse_publique, this.var_liste_groupe, var2);
         int var19;
         if (var32.size() != 0) {
            new BonEncaissementVente();

            for(var19 = 0; var19 < var32.size(); ++var19) {
               this.bonCaisse = new BonCaisse();
               BonEncaissementVente var33 = (BonEncaissementVente)var32.get(var19);
               this.bonCaisse.setBonDateMvt2((Date)null);
               if (var33.getBonNatRef() == 7) {
                  this.bonCaisse.setOrigine(7);
               } else {
                  this.bonCaisse.setOrigine(4);
               }

               this.bonCaisse.setBonGrp(var33.getBonGrp());
               this.bonCaisse.setBonCaisActivite(var33.getBonActivite());
               this.bonCaisse.setBonCaisCodeBanqEmetteur((String)null);
               this.bonCaisse.setBonCaisCodeBanqRecepteur(var33.getBonCodeBanq());
               this.bonCaisse.setBonCaisCodeCaiss(var33.getBonCodeCaisse());
               this.bonCaisse.setBonCaisDate(var33.getBonDate());
               this.bonCaisse.setBonCaisDateRemise(var33.getBonDateRemise());
               this.bonCaisse.setBonCaisDevise(var33.getBonDevise());
               this.bonCaisse.setBonCaisId(var33.getBonId());
               this.bonCaisse.setBonCaisLibBanqEmetteur((String)null);
               this.bonCaisse.setBonCaisLibBanqRecepteur(var33.getBonLibBanq());
               this.bonCaisse.setBonCaisLibCaiss(var33.getBonLibCaisse());
               this.bonCaisse.setBonCaisLibelle(var33.getBonLibelle());
               this.bonCaisse.setBonCaisMontant(var33.getBonAPayer());
               this.bonCaisse.setBonCaisNature(var33.getBonNatRef());
               this.bonCaisse.setBonCaisNomResponsable(var33.getBonNomResponsable());
               this.bonCaisse.setBonCaisNomTiers(var33.getBonNomTiers());
               this.bonCaisse.setBonCaisIdTiers(var33.getBonIdTiers());
               this.bonCaisse.setBonCaisNum(var33.getBonNum());
               this.bonCaisse.setBonCaisNumOrigine(var33.getBonRef());
               this.bonCaisse.setBonCaisIdOrigine(var33.getBonIdRef());
               this.bonCaisse.setBonCaisOperation("01");
               this.bonCaisse.setBonCaisSerie(var33.getBonSerie());
               this.bonCaisse.setBonCaisTypeReg(var33.getBonTypeReg());
               this.bonCaisse.setBonCaisTypeTiers(0);
               this.bonCaisse.setBonCaisModeleImp("");
               this.bonCaisse.setBonCaisClient(var33.getBonClient());
               this.bonCaisse.setBonCaisFacture(var33.getBonFacture());
               if (var33.getBonNatRef() == 74) {
                  if (var33.getBonPdv() != null && !var33.getBonPdv().isEmpty() && var33.getBonPdv().contains(":")) {
                     this.bonCaisse.setBonCaisService(var33.getBonPdv());
                  } else {
                     this.bonCaisse.setBonCaisService(var33.getBonService());
                  }
               } else {
                  this.bonCaisse.setBonCaisService(var33.getBonService());
               }

               this.bonCaisse.setBonDateCloture((Date)null);
               this.bonCaisse.setBonDateTransfert((Date)null);
               this.bonCaisse.setBonCaisDepot(false);
               this.bonCaisse.setBonAnnuler(false);
               this.lesElements.add(this.bonCaisse);
            }
         }

         new ArrayList();
         var26 = Integer.parseInt(this.inpNature);
         List var34 = this.bonDecaissementAchatDao.selectFind(0, var26, this.inpService, var1, var12, var7, var11, this.usersLog.getUsrRecus(), this.usersLog.getUsrid(), this.rechercheTiers, this.usersLog.getUsrJrxReserve(), this.var_caisse_publique, this.var_liste_groupe, var2);
         int var20;
         if (var34.size() != 0) {
            new BonDecaissementAchat();

            for(var20 = 0; var20 < var34.size(); ++var20) {
               this.bonCaisse = new BonCaisse();
               BonDecaissementAchat var35 = (BonDecaissementAchat)var34.get(var20);
               this.bonCaisse.setBonDateMvt2((Date)null);
               this.bonCaisse.setOrigine(5);
               this.bonCaisse.setBonGrp(var35.getBonGrp());
               this.bonCaisse.setBonCaisActivite(var35.getBonActivite());
               this.bonCaisse.setBonCaisCodeBanqEmetteur(var35.getBonCodeBanq());
               this.bonCaisse.setBonCaisCodeBanqRecepteur(var35.getBonLibBanq());
               this.bonCaisse.setBonCaisCodeCaiss(var35.getBonCodeCaisse());
               this.bonCaisse.setBonCaisDate(var35.getBonDate());
               this.bonCaisse.setBonCaisDateRemise(var35.getBonDateRemise());
               this.bonCaisse.setBonCaisDevise(var35.getBonDevise());
               this.bonCaisse.setBonCaisId(var35.getBonId());
               this.bonCaisse.setBonCaisLibBanqEmetteur((String)null);
               this.bonCaisse.setBonCaisLibBanqRecepteur((String)null);
               this.bonCaisse.setBonCaisLibCaiss(var35.getBonLibCaisse());
               this.bonCaisse.setBonCaisLibelle(var35.getBonLibelle());
               this.bonCaisse.setBonCaisMontant(var35.getBonAPayer());
               this.bonCaisse.setBonCaisNature(var35.getBonNatRef());
               this.bonCaisse.setBonCaisNomResponsable(var35.getBonNomResponsable());
               this.bonCaisse.setBonCaisNomTiers(var35.getBonNomTiers());
               this.bonCaisse.setBonCaisIdTiers(var35.getBonIdTiers());
               this.bonCaisse.setBonCaisNum(var35.getBonNum());
               this.bonCaisse.setBonCaisNumOrigine(var35.getBonRef());
               this.bonCaisse.setBonCaisIdOrigine(var35.getBonIdRef());
               this.bonCaisse.setBonCaisOperation("21");
               this.bonCaisse.setBonCaisSerie(var35.getBonSerie());
               this.bonCaisse.setBonCaisTypeReg(var35.getBonTypeReg());
               this.bonCaisse.setBonCaisTypeTiers(0);
               this.bonCaisse.setBonCaisModeleImp("");
               this.bonCaisse.setBonCaisClient("");
               this.bonCaisse.setBonCaisFacture("");
               this.bonCaisse.setBonCaisService(var35.getBonService());
               this.bonCaisse.setBonDateCloture((Date)null);
               this.bonCaisse.setBonDateTransfert((Date)null);
               this.bonCaisse.setBonCaisDepot(false);
               this.bonCaisse.setBonAnnuler(false);
               this.lesElements.add(this.bonCaisse);
            }
         }

         this.lesElements = this.triListeNomTiers(this.lesElements);
         this.mesTiersItems.clear();

         for(var19 = 0; var19 < this.lesElements.size(); ++var19) {
            this.totalDepense += ((BonCaisse)this.lesElements.get(var19)).getDepense();
            this.totalRecette += ((BonCaisse)this.lesElements.get(var19)).getRecette();
            if (((BonCaisse)this.lesElements.get(var19)).getBonCaisNomTiers() != null && !((BonCaisse)this.lesElements.get(var19)).getBonCaisNomTiers().isEmpty()) {
               boolean var37 = false;
               if (this.mesTiersItems.size() != 0) {
                  for(int var21 = 0; var21 < this.mesTiersItems.size(); ++var21) {
                     if (((SelectItem)this.mesTiersItems.get(var21)).getValue().toString().equals(((BonCaisse)this.lesElements.get(var19)).getBonCaisNomTiers())) {
                        var37 = true;
                        break;
                     }
                  }
               }

               if (!var37) {
                  this.mesTiersItems.add(new SelectItem(((BonCaisse)this.lesElements.get(var19)).getBonCaisNomTiers()));
               }
            }
         }

         this.lesElements = this.triListeDate(this.lesElements);
         if (this.var_liste_sans_execution.size() != 0 && this.lesElements.size() != 0) {
            ArrayList var36 = new ArrayList();

            for(var20 = 0; var20 < this.var_liste_sans_execution.size(); ++var20) {
               String var38 = (String)this.var_liste_sans_execution.get(var20);

               for(int var22 = 0; var22 < this.lesElements.size(); ++var22) {
                  if (((BonCaisse)this.lesElements.get(var22)).getBonCaisCodeCaiss() != null && !((BonCaisse)this.lesElements.get(var22)).getBonCaisCodeCaiss().isEmpty() && !((BonCaisse)this.lesElements.get(var22)).getBonCaisCodeCaiss().equals(var38)) {
                     boolean var23 = false;
                     if (var36.size() != 0) {
                        for(int var24 = 0; var24 < var36.size(); ++var24) {
                           if (((BonCaisse)var36.get(var24)).getBonCaisId() == ((BonCaisse)this.lesElements.get(var22)).getBonCaisId()) {
                              var23 = true;
                              break;
                           }
                        }
                     }

                     if (!var23) {
                        var36.add(this.lesElements.get(var22));
                     }
                  }
               }
            }

            this.lesElements = var36;
         }
      } else if (this.inpEtat == 2) {
         new ArrayList();
         var14 = this.reglementsDao.selectFind(this.inpNature, this.inpService, this.listCaissesAutorisees, var12, this.recherchePiece, this.rechercheRecu, var7, var11, this.usersLog.getUsrRecus(), this.usersLog.getUsrid(), this.usersLog.getUsrJrxReserve(), this.var_caisse_publique, this.var_liste_groupe, this.rechercheMontant, var2);
         if (var14.size() != 0) {
            new Reglements();

            for(var16 = 0; var16 < var14.size(); ++var16) {
               this.bonCaisse = new BonCaisse();
               Reglements var28 = (Reglements)var14.get(var16);
               if (var28.getRglImp() == 0) {
                  this.bonCaisse.setOrigine(6);
                  this.bonCaisse.setBonGrp(var28.getRglGrp());
                  this.bonCaisse.setBonDateMvt2(var28.getRglDateMvt2());
                  this.bonCaisse.setBonCaisDateEncaissement(var28.getRglDateEncaissement());
                  this.bonCaisse.setBonCaisDateRejet(var28.getRglDateRejet());
                  this.bonCaisse.setTimbre(var28.getRglTimbre());
                  this.bonCaisse.setBonCaisNature(var28.getRglNatureDoc());
                  this.bonCaisse.setBonCaisOperation(var28.getRglOperation());
                  this.bonCaisse.setBonCaisActivite(var28.getRglActivite());
                  this.bonCaisse.setBonCaisBanqueTirreur(var28.getRglBanqueTireur());
                  this.bonCaisse.setBonCaisCodeBanqEmetteur(var28.getRglCodeEmetrice());
                  this.bonCaisse.setBonCaisCodeBanqRecepteur(var28.getRglCodeReceptrice());
                  this.bonCaisse.setBonCaisCodeCaiss(var28.getRglCodeCaiss());
                  this.bonCaisse.setBonCaisDate(var28.getRglDateReg());
                  this.bonCaisse.setBonCaisDateRemise(var28.getRglDateRemise());
                  this.bonCaisse.setBonCaisDevise(var28.getRglDevise());
                  this.bonCaisse.setBonCaisId(var28.getRglId());
                  this.bonCaisse.setBonCaisLibBanqEmetteur(var28.getRglLibEmetrice());
                  this.bonCaisse.setBonCaisLibBanqRecepteur(var28.getRglLibReceptrice());
                  this.bonCaisse.setBonCaisLibCaiss(var28.getRglLibCaiss());
                  this.bonCaisse.setBonCaisLibelle(var28.getRglObjet() + " " + var28.getRglLibelle() + " " + var28.getRglService());
                  this.bonCaisse.setBonCaisMontant(var28.getRglDepense() + var28.getRglRecette() - var28.getRglRendu());
                  this.bonCaisse.setBonCaisNomResponsable(var28.getRglNomResponsable());
                  this.bonCaisse.setBonCaisNomTiers(var28.getRglNomTiers());
                  this.bonCaisse.setBonCaisIdTiers(var28.getRglIdTiers());
                  this.bonCaisse.setBonCaisNum(var28.getRglNum());
                  this.bonCaisse.setBonCaisNumOrigine(var28.getRglDocument());
                  this.bonCaisse.setBonCaisIdOrigine(var28.getRglIdDocument());
                  this.bonCaisse.setBonCaisNumChqBdx(var28.getRglNumChqBdx());
                  this.bonCaisse.setBonCaisSerie(var28.getRglSerie());
                  this.bonCaisse.setBonCaisTypeReg(var28.getRglTypeReg());
                  this.bonCaisse.setBonCaisTypeTiers(var28.getRglTypeTiers());
                  this.bonCaisse.setBonCaisModeleImp("");
                  this.bonCaisse.setBonCaisClient("");
                  this.bonCaisse.setBonCaisFacture("");
                  this.bonCaisse.setBonCaisService(var28.getRglService());
                  this.bonCaisse.setBonDateCloture(var28.getRglDateCloture());
                  this.bonCaisse.setBonDateTransfert(var28.getRglDateTransfert());
                  if (var28.getRglDepotTiers() == 1) {
                     this.bonCaisse.setBonCaisDepot(true);
                  } else {
                     this.bonCaisse.setBonCaisDepot(false);
                  }

                  this.bonCaisse.setBonAnnuler(var28.isRglAnnuler());
                  this.totalDepense += this.bonCaisse.getDepense();
                  this.totalRecette += this.bonCaisse.getRecette();
                  this.lesElements.add(this.bonCaisse);
               }
            }
         }
      }

      this.datamodelElement.setWrappedData(this.lesElements);
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.visibiliteBton = false;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

   }

   public List triListeNomTiers(List var1) {
      ArrayList var2 = new ArrayList();
      new BonCaisse();
      new BonCaisse();
      String var5 = "";
      String var6 = "";
      if (var1.size() != 0) {
         for(int var7 = 0; var7 < var1.size(); ++var7) {
            BonCaisse var3 = (BonCaisse)var1.get(var7);
            var5 = var3.getBonCaisNomTiers();
            var6 = "";
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var8 = false;

               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  BonCaisse var4 = (BonCaisse)var2.get(var9);
                  int var10 = var9 - 1;
                  if (var10 < 0) {
                     var10 = 0;
                  }

                  var6 = var4.getBonCaisNomTiers();
                  if (var5.compareTo(var6) < 0) {
                     var2.add(var10, var3);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List triListeDate(List var1) {
      ArrayList var2 = new ArrayList();
      new BonCaisse();
      new BonCaisse();
      Date var5 = null;
      Date var6 = null;
      if (var1.size() != 0) {
         for(int var7 = 0; var7 < var1.size(); ++var7) {
            BonCaisse var3 = (BonCaisse)var1.get(var7);
            var5 = var3.getBonCaisDate();
            var6 = null;
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var8 = false;

               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  BonCaisse var4 = (BonCaisse)var2.get(var9);
                  int var10 = var9 - 1;
                  if (var10 < 0) {
                     var10 = 0;
                  }

                  var6 = var4.getBonCaisDate();
                  if (var5.compareTo(var6) < 0) {
                     var2.add(var10, var3);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public void selectionLigne() throws HibernateException, NamingException {
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
            this.bonCaisse = (BonCaisse)var1.get(0);
            if (this.bonCaisse != null) {
               int var4 = 0;
               this.bonSortieCaiss = new BonSortieCaiss();
               this.bonEntreCaiss = new BonEntreCaiss();
               this.virementInterne = new VirementInterne();
               this.bonEncaissementVente = new BonEncaissementVente();
               this.bonDecaissementAchat = new BonDecaissementAchat();
               this.reglements = new Reglements();
               if (this.bonCaisse.getOrigine() != 1) {
                  if (this.bonCaisse.getOrigine() == 2) {
                     this.bonEntreCaiss = this.bonEntreCaissDao.selectById(this.bonCaisse.getBonCaisId(), (Session)null);
                     this.var_modeReglement = "" + this.bonEntreCaiss.getEntrTypeReg();
                     this.chargerDetailanalytiqueEntree();
                  } else if (this.bonCaisse.getOrigine() == 3) {
                     this.virementInterne = this.virementInterneDao.selectById(this.bonCaisse.getBonCaisId(), (Session)null);
                     this.var_modeReglement = "" + this.virementInterne.getVirTypeReg();
                  } else if (this.bonCaisse.getOrigine() == 4) {
                     this.bonEncaissementVente = this.bonEncaissementVenteDao.selectById(this.bonCaisse.getBonCaisId(), (Session)null);
                     this.var_modeReglement = "";
                     this.var_aPayer = this.bonEncaissementVente.getBonAPayer();
                     this.var_timbre = 0.0D;
                     this.bonEncaissementVente.getBonTypeReg();
                     this.var_modeReglement = "" + this.bonEncaissementVente.getBonTypeReg();
                     this.choixTypeReglement();
                  } else if (this.bonCaisse.getOrigine() == 5) {
                     this.bonDecaissementAchat = this.bonDecaissementAchatDao.selectById(this.bonCaisse.getBonCaisId(), (Session)null);
                     this.var_modeReglement = "";
                     this.var_aPayer = this.bonEncaissementVente.getBonAPayer();
                     this.var_timbre = 0.0D;
                     this.bonDecaissementAchat.getBonTypeReg();
                  } else if (this.bonCaisse.getOrigine() == 6) {
                     this.reglements = this.reglementsDao.selectById(this.bonCaisse.getBonCaisId(), (Session)null);
                     this.var_timbre = this.reglements.getRglTimbre();
                     this.var_aPayer = this.reglements.getRglRecette() + this.reglements.getRglDepense() + this.var_timbre;
                     if (this.reglements.getRglTypeReg() == 100) {
                        this.reglements.setRglTypeReg(0);
                     }

                     this.var_modeReglement = "" + this.reglements.getRglTypeReg();
                     if (this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty()) {
                        var4 = Integer.parseInt(this.reglements.getRglOperation());
                     }
                  } else if (this.bonCaisse.getOrigine() == 7) {
                     this.bonEncaissementVente = this.bonEncaissementVenteDao.selectById(this.bonCaisse.getBonCaisId(), (Session)null);
                     this.var_modeReglement = "" + this.bonEncaissementVente.getBonTypeReg();
                  }
               } else {
                  this.bonSortieCaiss = this.bonSortieCaissDao.selectById(this.bonCaisse.getBonCaisId(), (Session)null);
                  this.var_modeReglement = "" + this.bonSortieCaiss.getSortTypeReg();
                  if (this.bonSortieCaiss.getSortTypeReg() != 1 && this.bonSortieCaiss.getSortTypeReg() != 2) {
                     this.var_banque = "";
                  } else {
                     this.var_banque = this.bonSortieCaiss.getSortCodeBanq() + ":" + this.bonSortieCaiss.getSortLibBanq();
                  }

                  this.chargerDetailanalytiqueSortie();
               }

               this.visibiliteBton = true;
               if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
                  this.var_modeReglement = "0";
               }

               this.calculeNomRep(Integer.parseInt(this.var_modeReglement), var4);
               this.var_caisse = "";
               this.existCaiss = false;
               this.var_valide = false;
               this.var_verrou_caisse = false;
               this.mesCaissesItems.clear();
               this.mesCaissesItems = this.usersChronoDao.selectChronoByUserNat(this.usersLog, 61, (Session)null);
               if (this.bonCaisse.getBonCaisCodeCaiss() != null && !this.bonCaisse.getBonCaisCodeCaiss().isEmpty()) {
                  if (this.bonCaisse.getOrigine() == 6) {
                     this.var_caisse = this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglLibCaiss();
                  } else {
                     this.var_caisse = this.bonCaisse.getBonCaisCodeCaiss() + ":" + this.bonCaisse.getBonCaisLibCaiss();
                  }

                  this.existCaiss = true;
                  this.var_valide = true;
                  this.choixCaissePiece((Session)null);
               } else if (this.mesCaissesItems.size() != 0) {
                  if (this.bonCaisse.getOrigine() == 6) {
                     this.var_caisse = this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglLibCaiss();
                  } else {
                     this.var_caisse = ((SelectItem)this.mesCaissesItems.get(0)).getValue().toString();
                  }

                  this.existCaiss = true;
                  this.var_valide = true;
                  this.choixCaissePiece((Session)null);
               }

               if (this.bonCaisse.getBonCaisCodeBanqEmetteur() != null && !this.bonCaisse.getBonCaisCodeBanqEmetteur().isEmpty()) {
                  this.inputBanqEmetteur = this.bonCaisse.getBonCaisCodeBanqEmetteur() + ":" + this.bonCaisse.getBonCaisLibBanqEmetteur();
               } else {
                  this.inputBanqEmetteur = "";
               }

               if (this.bonCaisse.getBonCaisCodeBanqRecepteur() != null && !this.bonCaisse.getBonCaisCodeBanqRecepteur().isEmpty()) {
                  this.inputBanqRecepteur = this.bonCaisse.getBonCaisCodeBanqRecepteur() + ":" + this.bonCaisse.getBonCaisLibBanqRecepteur();
               } else {
                  this.inputBanqRecepteur = "";
               }

               if (this.bonCaisse.getOrigine() == 4) {
                  if (this.bonEncaissementVente.getBonCodeBanq() != null && !this.bonEncaissementVente.getBonCodeBanq().isEmpty()) {
                     this.inputBanq = this.bonEncaissementVente.getBonCodeBanq() + ":" + this.bonEncaissementVente.getBonLibBanq();
                  } else {
                     this.inputBanq = "";
                  }
               }

               if (this.bonCaisse.getBonCaisTypeReg() != 1 && this.bonCaisse.getBonCaisTypeReg() != 2 && this.bonCaisse.getBonCaisTypeReg() != 3 && this.bonCaisse.getBonCaisTypeReg() != 4 && this.bonCaisse.getBonCaisTypeReg() != 6 && this.bonCaisse.getBonCaisTypeReg() != 7) {
                  this.affichBanq = false;
               } else {
                  this.affichBanq = true;
               }

               if (this.bonCaisse.isBonCaisDepot()) {
                  this.var_affiche_depot = true;
                  this.var_depot = true;
               } else {
                  this.var_affiche_depot = false;
                  this.var_depot = false;
               }

               this.chargerUserChrono((Session)null);
            }
         } else {
            this.visibiliteBton = false;
            this.var_caisse = "";
            this.inputBanqEmetteur = "";
            this.inputBanqRecepteur = "";
            this.existCaiss = false;
            this.affichBanq = false;
            this.var_banque = "";
            this.var_affiche_depot = false;
            this.var_depot = false;
            this.var_verrou_caisse = false;
         }
      } else {
         this.visibiliteBton = false;
         this.var_caisse = "";
         this.inputBanqEmetteur = "";
         this.inputBanqRecepteur = "";
         this.existCaiss = false;
         this.affichBanq = false;
         this.var_banque = "";
         this.var_affiche_depot = false;
         this.var_depot = false;
         this.var_verrou_caisse = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.bonCaisse != null) {
         if (this.inpEtat == 1) {
            this.ajoutDocument();
         } else if (this.inpEtat == 2) {
            this.consultDocument();
         }
      }

   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.bonCaisse != null && this.bonCaisse.getBonCaisSerie() != null && !this.bonCaisse.getBonCaisSerie().isEmpty()) {
         if (this.mesCaissesItems.size() != 0) {
            String var2 = "";

            for(int var3 = 0; var3 < this.mesCaissesItems.size(); ++var3) {
               if (((SelectItem)this.mesCaissesItems.get(var3)).getValue().toString() != null && !((SelectItem)this.mesCaissesItems.get(var3)).getValue().toString().isEmpty() && ((SelectItem)this.mesCaissesItems.get(var3)).getValue().toString().contains(":")) {
                  var2 = ((SelectItem)this.mesCaissesItems.get(var3)).getValue().toString();
                  break;
               }
            }

            String[] var4 = var2.split(":");
            this.usersChrono = this.usersChronoDao.selectUnique(this.bonCaisse.getBonCaisSerie(), var4[0], this.nature, this.usersLog, var1);
            if (this.usersChrono == null) {
               this.usersChrono = this.usersChronoDao.selectUnique(var4[0], this.nature, this.usersLog, var1);
            }
         }

         if (this.usersChrono == null) {
            if (this.bonCaisse.getBonCaisCodeCaiss() != null && !this.bonCaisse.getBonCaisCodeCaiss().isEmpty()) {
               this.usersChrono = this.usersChronoDao.selectUnique(this.bonCaisse.getBonCaisSerie(), this.bonCaisse.getBonCaisCodeCaiss(), this.nature, this.usersLog, var1);
            } else {
               this.usersChrono = this.usersChronoDao.selectUnique(this.bonCaisse.getBonCaisSerie(), this.nature, this.usersLog, var1);
            }

            if (this.usersChrono == null && this.bonCaisse.getBonCaisCodeCaiss() != null && !this.bonCaisse.getBonCaisCodeCaiss().isEmpty()) {
               this.usersChrono = this.usersChronoDao.selectUnique(this.bonCaisse.getBonCaisCodeCaiss(), this.nature, this.usersLog, var1);
            }
         }
      }

      if (this.usersChrono == null) {
         this.usersChrono = new UsersChrono();
      }

   }

   public void chargerDetailanalytiqueEntree() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.bonEntreCaiss.getEntrActivite() != null && !this.bonEntreCaiss.getEntrActivite().isEmpty() && this.bonEntreCaiss.getEntrActivite().contains(":")) {
         String[] var1 = null;
         if (!this.bonEntreCaiss.getEntrActivite().contains("#")) {
            var1 = this.bonEntreCaiss.getEntrActivite().split(":");
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
            this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(0.0F);
            if (var1.length == 8) {
               this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
            } else {
               this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[6]));
            }

            this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
            this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         } else {
            String[] var2 = this.bonEntreCaiss.getEntrActivite().split("#");

            for(int var3 = 0; var3 < var2.length; ++var3) {
               var1 = var2[var3].split(":");
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
               this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(0.0F);
               if (var1.length == 8) {
                  this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
               } else {
                  this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[6]));
               }

               this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         }
      }

      this.soldeImputation = this.bonEntreCaiss.getEntrMontant() - this.totalImputation;
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void chargerDetailanalytiqueSortie() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.bonSortieCaiss.getSortActivite() != null && !this.bonSortieCaiss.getSortActivite().isEmpty() && this.bonSortieCaiss.getSortActivite().contains(":")) {
         String[] var1 = null;
         if (!this.bonSortieCaiss.getSortActivite().contains("#")) {
            var1 = this.bonSortieCaiss.getSortActivite().split(":");
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
            this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(0.0F);
            if (var1.length == 8) {
               this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
            } else {
               this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[6]));
            }

            this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
            this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         } else {
            String[] var2 = this.bonSortieCaiss.getSortActivite().split("#");

            for(int var3 = 0; var3 < var2.length; ++var3) {
               var1 = var2[var3].split(":");
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
               this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(0.0F);
               if (var1.length == 8) {
                  this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
               } else {
                  this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[6]));
               }

               this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         }
      }

      this.soldeImputation = this.bonSortieCaiss.getSortMontant() - this.totalImputation;
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void chargerCaisse(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         String[] var3 = this.var_caisse.split(":");
         var2 = var3[0];
      } else {
         var2 = this.var_caisse;
      }

      this.natCaisse = 61;
      this.serieCaisse = this.bonCaisse.getBonCaisSerie();
   }

   public void ajoutDocument() throws HibernateException, NamingException, ParseException {
      if (this.bonCaisse != null) {
         this.reglements = new Reglements();
         this.tiers = new Tiers();
         this.soldeCaisse = 0.0D;
         if (this.bonCaisse.getBonCaisFacture() != null && !this.bonCaisse.getBonCaisFacture().isEmpty() && this.bonCaisse.getBonCaisFacture().contains(":")) {
            if (this.bonCaisse.getBonCaisNature() == 7) {
               this.listeCommission();
            } else if (this.bonCaisse.getBonCaisNature() == 173) {
               this.listeAppelCharge();
            } else if (this.bonCaisse.getBonCaisNature() == 165) {
               this.listeFactureLocation();
            } else if (this.bonCaisse.getBonCaisNature() == 101) {
               this.listeFactureEleve();
            } else {
               this.listeFacture();
            }

            this.var_action = 2;
         } else {
            this.var_action = 1;
         }

         this.memoCompteTaxe = "";
         this.memoTauxTaxe = 0.0F;
         this.memoExoTaxe = false;
         this.affichageExoCompte = false;
         this.lesDecoupagesActivites.clear();
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         TiersDao var1;
         if (this.optionCaisses.getExecution().equals("0")) {
            this.reglements.setRglDateReg(new Date());
            if (this.bonCaisse.getBonCaisNature() >= 11 && this.bonCaisse.getBonCaisNature() <= 19) {
               this.bonDecaissementAchat.setBonDate(new Date());
            } else if (this.bonCaisse.getBonCaisNature() == 7) {
               this.bonEncaissementVente.setBonDate(new Date());
            } else if (this.bonCaisse.getBonCaisNature() >= 20 && this.bonCaisse.getBonCaisNature() <= 29) {
               this.bonEncaissementVente.setBonDate(new Date());
               var1 = new TiersDao(this.baseLog, this.utilInitHibernate);
               this.tiers = var1.selectTierD(this.bonCaisse.getBonCaisIdTiers());
               if (this.tiers == null) {
                  this.tiers = new Tiers();
               }
            } else if (this.bonCaisse.getBonCaisNature() == 62) {
               this.bonSortieCaiss.setSortDate(new Date());
               this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
               this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
               if (this.bonSortieCaiss.getSortCodeCaiss() != null && !this.bonSortieCaiss.getSortCodeCaiss().isEmpty()) {
                  this.caissesCommerciales = this.caissesCommercialesDao.selectCaisse(this.selectedExo.getExecaiId(), this.bonSortieCaiss.getSortCodeCaiss(), (Session)null);
                  if (this.caissesCommerciales != null) {
                     this.calculeSoldeCaisse(this.bonSortieCaiss.getSortCodeCaiss(), this.bonSortieCaiss.getSortDate());
                  }
               }
            } else if (this.bonCaisse.getBonCaisNature() == 63) {
               this.bonEntreCaiss.setEntrDate(new Date());
               this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
               this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
            } else if (this.bonCaisse.getBonCaisNature() == 64) {
               this.virementInterne.setVirDate(new Date());
            } else if (this.bonCaisse.getBonCaisNature() != 65) {
               if (this.bonCaisse.getBonCaisNature() >= 70 && this.bonCaisse.getBonCaisNature() <= 79) {
                  this.bonEncaissementVente.setBonDate(new Date());
               } else if (this.bonCaisse.getBonCaisNature() >= 100 && this.bonCaisse.getBonCaisNature() <= 109) {
                  this.bonEncaissementVente.setBonDate(new Date());
               } else if (this.bonCaisse.getBonCaisNature() >= 160 && this.bonCaisse.getBonCaisNature() <= 169) {
                  this.bonEncaissementVente.setBonDate(new Date());
               } else if (this.bonCaisse.getBonCaisNature() >= 170 && this.bonCaisse.getBonCaisNature() <= 179) {
                  this.bonEncaissementVente.setBonDate(new Date());
               }
            }
         } else if (this.bonCaisse.getBonCaisNature() >= 11 && this.bonCaisse.getBonCaisNature() <= 19) {
            this.reglements.setRglDateReg(this.bonDecaissementAchat.getBonDate());
         } else if (this.bonCaisse.getBonCaisNature() == 7) {
            this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
         } else if (this.bonCaisse.getBonCaisNature() >= 20 && this.bonCaisse.getBonCaisNature() <= 29) {
            this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
            var1 = new TiersDao(this.baseLog, this.utilInitHibernate);
            this.tiers = var1.selectTierD(this.bonEncaissementVente.getBonIdTiers());
            if (this.tiers == null) {
               this.tiers = new Tiers();
            }
         } else if (this.bonCaisse.getBonCaisNature() == 62) {
            this.reglements.setRglDateReg(this.bonSortieCaiss.getSortDate());
            this.calculeSoldeCaisse(this.bonSortieCaiss.getSortCodeCaiss(), this.bonSortieCaiss.getSortDate());
         } else if (this.bonCaisse.getBonCaisNature() == 63) {
            this.reglements.setRglDateReg(this.bonEntreCaiss.getEntrDate());
         } else if (this.bonCaisse.getBonCaisNature() == 64) {
            this.reglements.setRglDateReg(this.virementInterne.getVirDate());
         } else if (this.bonCaisse.getBonCaisNature() != 65) {
            if (this.bonCaisse.getBonCaisNature() >= 70 && this.bonCaisse.getBonCaisNature() <= 79) {
               this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
            } else if (this.bonCaisse.getBonCaisNature() >= 100 && this.bonCaisse.getBonCaisNature() <= 109) {
               this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
            } else if (this.bonCaisse.getBonCaisNature() >= 160 && this.bonCaisse.getBonCaisNature() <= 169) {
               this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
            } else if (this.bonCaisse.getBonCaisNature() >= 170 && this.bonCaisse.getBonCaisNature() <= 179) {
               this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
            }
         }

         this.mesCaissesItems.clear();
         this.var_modeReglement = "";
         this.mesModesReglementsItem.clear();
         boolean var7 = false;
         if (this.inpCaisse != null && !this.inpCaisse.isEmpty() && !this.inpCaisse.equals("100") && this.inpCaisse.contains(":")) {
            String[] var2 = this.inpCaisse.split(":");
            this.caissesCommerciales = this.caissesCommercialesDao.selectCaisse(0L, var2[0], (Session)null);
            if (this.caissesCommerciales != null) {
               this.mesCaissesItems.add(new SelectItem(this.caissesCommerciales.getCaiCode() + ":" + this.caissesCommerciales.getCaiNom()));
               this.var_caisse = this.inpCaisse;
               this.var_verrou_caisse = true;
               this.calculModeReglement();
               this.choixTypeReglement();
               var7 = true;
            } else {
               this.var_caisse = "";
            }
         }

         if (!var7) {
            if (this.bonCaisse.getBonCaisSerie() == null || this.bonCaisse.getBonCaisSerie().isEmpty()) {
               this.bonCaisse.setBonCaisSerie("A");
            }

            if (!this.existCaiss) {
               this.mesCaissesItems = this.usersChronoDao.selectChronoByUserNat(this.usersLog, 61, this.bonCaisse.getBonCaisSerie(), (Session)null);
               this.var_caisse = "";
               this.calculModeReglement();
               this.choixTypeReglement();
            } else if (this.bonCaisse.getBonCaisSerie() != null && !this.bonCaisse.getBonCaisSerie().isEmpty()) {
               this.mesCaissesItems = this.usersChronoDao.selectChronoByUserNat(this.usersLog, 61, this.bonCaisse.getBonCaisSerie(), (Session)null);
               if (this.mesCaissesItems.size() == 0) {
                  this.mesCaissesItems.add(new SelectItem(""));
                  this.var_caisse = "";
               } else {
                  boolean var8 = false;
                  String var3 = "";
                  if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                     String[] var4 = this.var_caisse.split(":");
                     var3 = var4[0];

                     for(int var5 = 0; var5 < this.mesCaissesItems.size(); ++var5) {
                        String[] var6 = ((SelectItem)this.mesCaissesItems.get(var5)).getValue().toString().split(":");
                        if (var6[0].toString().equals(var3)) {
                           this.var_caisse = ((SelectItem)this.mesCaissesItems.get(var5)).getValue().toString();
                           var8 = true;
                           break;
                        }
                     }
                  }

                  if (!var8) {
                     this.var_caisse = "";
                     if (this.mesCaissesItems.size() != 0) {
                        this.var_caisse = ((SelectItem)this.mesCaissesItems.get(0)).getValue().toString();
                     }
                  }

                  this.calculModeReglement();
                  this.choixTypeReglement();
               }
            } else {
               this.mesCaissesItems.add(new SelectItem(""));
               this.var_caisse = "";
            }
         }

         if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":") && this.var_modeReglement != null && !this.var_modeReglement.isEmpty() && this.var_modeReglement.equals("1")) {
            this.inputBanq = this.var_caisse;
         }

         this.afficheValide();
      }

   }

   public void calculeSoldeCaisse(String var1, Date var2) throws HibernateException, NamingException, ParseException {
      this.soldeCaisse = 0.0D;
      if (this.caissesCommerciales != null && this.caissesCommerciales.getCaiNegatif() == 1 && var1 != null && !var1.isEmpty()) {
         var2 = this.utilDate.dateJourSuivant(var2);
         double var3 = 0.0D;
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "GestionCaisseAutres");
         new ArrayList();
         CaissesJourDao var7 = new CaissesJourDao(this.baseLog, this.utilInitHibernate);
         List var6 = var7.listeDateDebut(var1, this.selectedExo.getExecaiDateDebut(), var2, var5);
         CaissesJour var8 = new CaissesJour();
         boolean var9 = false;
         if (var6.size() != 0) {
            for(int var10 = var6.size() - 1; var10 >= 0; --var10) {
               var8 = (CaissesJour)var6.get(var10);
               if (var8.getCaijouEtat() == 1) {
                  var9 = true;
                  break;
               }
            }
         }

         ExercicesCaisse var20;
         if (!var9) {
            new ExercicesCaisse();
            ExercicesCaisseDao var11 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            var20 = var11.recupererLExoSelect(this.selectedExo.getExecaiId() - 1L, var5);
            int var12;
            if (var20 != null) {
               var6 = var7.listeDateDebut(var1, var20.getExecaiDateDebut(), var2, var5);
               var8 = new CaissesJour();
               var9 = false;
               if (var6.size() != 0) {
                  for(var12 = var6.size() - 1; var12 >= 0; --var12) {
                     var8 = (CaissesJour)var6.get(var12);
                     if (var8.getCaijouEtat() == 1) {
                        var9 = true;
                        break;
                     }
                  }
               }
            }

            if (!var9) {
               var20 = var11.recupererLExoSelect(this.selectedExo.getExecaiId() - 2L, var5);
               if (var20 != null) {
                  var6 = var7.listeDateDebut(var1, var20.getExecaiDateDebut(), var2, var5);
                  var8 = new CaissesJour();
                  var9 = false;
                  if (var6.size() != 0) {
                     for(var12 = var6.size() - 1; var12 >= 0; --var12) {
                        var8 = (CaissesJour)var6.get(var12);
                        if (var8.getCaijouEtat() == 1) {
                           var9 = true;
                           break;
                        }
                     }
                  }
               }

               if (!var9) {
                  var20 = var11.recupererLExoSelect(this.selectedExo.getExecaiId() - 3L, var5);
                  if (var20 != null) {
                     var6 = var7.listeDateDebut(var1, var20.getExecaiDateDebut(), var2, var5);
                     var8 = new CaissesJour();
                     var9 = false;
                     if (var6.size() != 0) {
                        for(var12 = var6.size() - 1; var12 >= 0; --var12) {
                           var8 = (CaissesJour)var6.get(var12);
                           if (var8.getCaijouEtat() == 1) {
                              var9 = true;
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         var20 = null;
         Date var22;
         if (var9) {
            var22 = var8.getCaijouDate();
            var3 = var8.getCaijouSoldeEspece() + var8.getCaijouSoldeCheque() + var8.getCaijouSoldeVirement() + var8.getCaijouSoldeTraite() + var8.getCaijouSoldeTpe() + var8.getCaijouSoldeTransfert() + var8.getCaijouSoldeePaiement() + var8.getCaijouSoldeCredoc() + var8.getCaijouSoldeFactor() + var8.getCaijouSoldeCompense() + var8.getCaijouSoldeTerme() + var8.getCaijouSoldeBonCaisse();
         } else {
            var22 = this.caissesCommerciales.getCaiDateInit();
            if (var22 == null) {
               var22 = this.selectedExo.getExecaiDateDebut();
            }

            var3 = this.caissesCommerciales.getCaiMontantInitEspece() + this.caissesCommerciales.getCaiMontantInitCheque() + this.caissesCommerciales.getCaiMontantInitVirement() + this.caissesCommerciales.getCaiMontantInitTraite() + this.caissesCommerciales.getCaiMontantInitTpe() + this.caissesCommerciales.getCaiMontantInitTransfert() + this.caissesCommerciales.getCaiMontantInitePaiement() + this.caissesCommerciales.getCaiMontantInitCredoc() + this.caissesCommerciales.getCaiMontantInitFactor() + this.caissesCommerciales.getCaiMontantInitCompense() + this.caissesCommerciales.getCaiMontantInitTerme();
         }

         new ArrayList();
         List var21 = this.reglementsDao.calculToutSoldeAnterieur(var1, var22, var2, var5);
         double var23 = 0.0D;
         double var14 = 0.0D;
         if (var21.size() != 0) {
            new Reglements();

            for(int var17 = 0; var17 < var21.size(); ++var17) {
               Reglements var16 = (Reglements)var21.get(var17);
               if (var16.getRglCodeCaiss() != null && !var16.getRglCodeCaiss().isEmpty() && !var16.getRglCodeCaiss().equals(var1)) {
                  double var18 = var16.getRglRecette();
                  var16.setRglRecette(var16.getRglDepense());
                  var16.setRglDepense(var18);
               }

               if (var16.getRglOperation() == null || var16.getRglOperation().isEmpty()) {
                  var16.setRglOperation("00");
               }

               var16.setSel_ecriture(false);
               if (var16.getRglTypeReg() == 11) {
                  var16.setRglTypeReg(0);
               } else if (var16.getRglTypeReg() == 10) {
                  var16.setRglTypeReg(0);
               }

               if (var16.getRglTypeReg() == 0 || var16.getRglCategorie() == 64 && (var16.getRglOperation().equals("71") || var16.getRglOperation().equals("73") || var16.getRglOperation().equals("77") || var16.getRglOperation().equals("80") || var16.getRglOperation().equals("85"))) {
                  var23 += var16.getRglDepense();
                  var14 += var16.getRglRecette();
               } else if (var16.getRglTypeReg() == 1) {
                  if (var16.getRglOperation() != null && !var16.getRglOperation().isEmpty() && var16.getRglOperation().equals("81")) {
                     var16.setRglNumMvt1(var16.getRglNum());
                  }

                  var23 += var16.getRglDepense();
                  var14 += var16.getRglRecette();
               } else if (var16.getRglTypeReg() == 2) {
                  var23 += var16.getRglDepense();
                  var14 += var16.getRglRecette();
               } else if (var16.getRglTypeReg() == 3) {
                  var23 += var16.getRglDepense();
                  var14 += var16.getRglRecette();
               } else if (var16.getRglTypeReg() == 4) {
                  var23 += var16.getRglDepense();
                  var14 += var16.getRglRecette();
               } else if (var16.getRglTypeReg() == 5) {
                  var23 += var16.getRglDepense();
                  var14 += var16.getRglRecette();
               } else if (var16.getRglTypeReg() == 6) {
                  var23 += var16.getRglDepense();
                  var14 += var16.getRglRecette();
               } else if (var16.getRglTypeReg() == 7) {
                  var23 += var16.getRglDepense();
                  var14 += var16.getRglRecette();
               } else if (var16.getRglTypeReg() == 8) {
                  var23 += var16.getRglDepense();
                  var14 += var16.getRglRecette();
               } else if (var16.getRglTypeReg() == 9) {
                  var23 += var16.getRglDepense();
                  var14 += var16.getRglRecette();
               } else if (var16.getRglTypeReg() == 10) {
                  var23 += var16.getRglDepense();
                  var14 += var16.getRglRecette();
               }
            }
         }

         this.soldeCaisse = var3 + var14 - var23;
         this.utilInitHibernate.closeSession();
      }

   }

   public void consultDocument() throws HibernateException, NamingException {
      if (this.bonCaisse != null) {
         this.var_valide = false;
         this.regul = false;
         this.var_action = 3;
         this.var_titre_recu = "CONSULTATION D'UN RECU";
      }

   }

   public void listeFacture() throws HibernateException, NamingException {
      this.listFacture.clear();
      if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEntete");
         int var2 = this.regexOccur(this.bonEncaissementVente.getBonFacture(), Pattern.quote(":"));
         if (var2 != 0) {
            String[] var3 = this.bonEncaissementVente.getBonFacture().split(":");

            for(int var4 = 0; var4 < var2; ++var4) {
               new FactureEnteteVentes();
               FactureEnteteVentes var5 = this.factureEnteteVentesDao.pourParapheur(var3[var4], var1);
               if (var5 != null && var5.getFacNum() != null && !var5.getFacNum().isEmpty()) {
                  this.listFacture.add(var5);
               }
            }

            this.datamodelTransfert.setWrappedData(this.listFacture);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void listeFactureEleve() throws HibernateException, NamingException {
      this.listFactureEleve.clear();
      if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         int var2 = this.regexOccur(this.bonEncaissementVente.getBonFacture(), Pattern.quote(":"));
         if (var2 != 0) {
            String[] var3 = this.bonEncaissementVente.getBonFacture().split(":");

            for(int var4 = 0; var4 < var2; ++var4) {
               new ElevesFacture();
               ElevesFacture var5 = this.elevesFactureDao.pourParapheur(var3[var4], var1);
               if (var5 != null && var5.getElefacNum() != null && !var5.getElefacNum().isEmpty()) {
                  this.listFactureEleve.add(var5);
               }
            }

            this.datamodelTransfert.setWrappedData(this.listFactureEleve);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void listeAppelCharge() throws HibernateException, NamingException {
      this.listAppelCharge.clear();
      if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicAppelCharge");
         AppelChargeDao var2 = new AppelChargeDao(this.baseLog, this.utilInitHibernate);
         int var3 = this.regexOccur(this.bonEncaissementVente.getBonFacture(), Pattern.quote(":"));
         if (var3 != 0) {
            String[] var4 = this.bonEncaissementVente.getBonFacture().split(":");

            for(int var5 = 0; var5 < var3; ++var5) {
               new AppelCharge();
               AppelCharge var6 = var2.pourParapheur(var4[var5], var1);
               if (var6 != null && var6.getAppchaNum() != null && !var6.getAppchaNum().isEmpty()) {
                  this.listAppelCharge.add(var6);
               }
            }

            this.datamodelTransfert.setWrappedData(this.listAppelCharge);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void listeFactureLocation() throws HibernateException, NamingException {
      this.listFactureLocation.clear();
      if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicAppelCharge");
         BienFactureDao var2 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
         int var3 = this.regexOccur(this.bonEncaissementVente.getBonFacture(), Pattern.quote(":"));
         if (var3 != 0) {
            String[] var4 = this.bonEncaissementVente.getBonFacture().split(":");

            for(int var5 = 0; var5 < var3; ++var5) {
               new BienFacture();
               BienFacture var6 = var2.pourParapheur(var4[var5], var1);
               if (var6 != null && var6.getBiefacNum() != null && !var6.getBiefacNum().isEmpty()) {
                  this.listFactureLocation.add(var6);
               }
            }

            this.datamodelTransfert.setWrappedData(this.listFactureLocation);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void listeCommission() throws HibernateException, NamingException {
      this.listCommission.clear();
      if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommissionEntete");
         int var2 = this.regexOccur(this.bonEncaissementVente.getBonFacture(), Pattern.quote(":"));
         if (var2 != 0) {
            String[] var3 = this.bonEncaissementVente.getBonFacture().split(":");

            for(int var4 = 0; var4 < var2; ++var4) {
               new CommissionEnteteVentes();
               CommissionEnteteVentes var5 = this.commissionEnteteVentesDao.pourParapheur(var3[var4], var1);
               if (var5 != null && var5.getComNum() != null && !var5.getComNum().isEmpty()) {
                  this.listCommission.add(var5);
               }
            }

            this.datamodelTransfert.setWrappedData(this.listCommission);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public int regexOccur(String var1, String var2) {
      Matcher var3 = Pattern.compile(var2).matcher(var1);

      int var4;
      for(var4 = 0; var3.find(); ++var4) {
      }

      return var4;
   }

   public void annulerSaisie() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void afficheValide() {
      this.var_valide = false;
      if (this.bonCaisse.getBonCaisNature() == 62) {
         if (this.caissesCommerciales != null && this.caissesCommerciales.getCaiNegatif() == 1) {
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":") && this.soldeCaisse != 0.0D && this.soldeCaisse >= this.bonSortieCaiss.getSortMontant()) {
               this.var_valide = true;
            }
         } else if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
            this.var_valide = true;
         }
      } else if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         this.var_valide = true;
      }

   }

   public void afficheBanque() {
      if (this.bonSortieCaiss.getSortTypeReg() == 0) {
         this.affichBanq = false;
      } else {
         this.affichBanq = true;
      }

   }

   public void actualiserTiers() throws HibernateException, NamingException, ParseException {
      if (this.lesElements.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "TiersReglement");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
            PatientsDao var4 = new PatientsDao(this.baseLog, this.utilInitHibernate);
            ElevesDao var5 = new ElevesDao(this.baseLog, this.utilInitHibernate);
            SalariesDao var6 = new SalariesDao(this.baseLog, this.utilInitHibernate);
            int var7 = 0;

            while(true) {
               if (var7 >= this.lesElements.size()) {
                  var2.commit();
                  break;
               }

               this.bonCaisse = (BonCaisse)this.lesElements.get(var7);
               if (this.bonCaisse.getBonCaisId() != 0L && this.bonCaisse.getBonCaisIdTiers() != 0L && this.inpEtat != 1 && this.inpEtat == 2 && this.bonCaisse.getOrigine() == 6) {
                  this.reglements = this.reglementsDao.selectById(this.bonCaisse.getBonCaisId(), var1);
                  if (this.reglements != null) {
                     if (this.bonCaisse.getBonCaisTypeTiers() != 0 && this.bonCaisse.getBonCaisTypeTiers() != 1) {
                        if (this.bonCaisse.getBonCaisTypeTiers() == 2) {
                           this.salaries = var6.chercherIdSalaries(this.reglements.getRglIdTiers(), var1);
                           if (this.salaries != null) {
                              this.reglements.setRglNomTiers(this.salaries.getPatronyme());
                              this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
                           }
                        } else if (this.bonCaisse.getBonCaisTypeTiers() != 3) {
                           if (this.bonCaisse.getBonCaisTypeTiers() == 4) {
                              this.patients = var4.selectPatientsD(this.reglements.getRglIdTiers(), var1);
                              if (this.patients != null) {
                                 this.reglements.setRglNomTiers(this.patients.getPatronyme());
                                 this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
                              }
                           } else if (this.bonCaisse.getBonCaisTypeTiers() == 5) {
                              this.eleves = var5.selectElevesD(this.reglements.getRglIdTiers(), var1);
                              if (this.eleves != null) {
                                 this.reglements.setRglNomTiers(this.eleves.getPatronyme());
                                 this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
                              }
                           } else if (this.bonCaisse.getBonCaisTypeTiers() == 6) {
                           }
                        }
                     } else {
                        this.tiers = var3.selectTierD(this.reglements.getRglIdTiers(), var1);
                        if (this.tiers != null) {
                           this.reglements.setRglNomTiers(this.tiers.getPatronyme());
                           this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
                        }
                     }
                  }
               }

               ++var7;
            }
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerFind();
      }

   }

   public void validationExecution() throws HibernateException, NamingException, IOException, ParseException {
      this.var_choix_modele = 0;
      if (this.bonCaisse != null) {
         if (this.bonCaisse.getBonCaisNature() >= 11 && this.bonCaisse.getBonCaisNature() <= 19) {
            this.casBonDecaissement();
         } else if (this.bonCaisse.getBonCaisNature() == 7) {
            this.casBonCommission();
         } else if ((this.bonCaisse.getBonCaisNature() < 20 || this.bonCaisse.getBonCaisNature() > 27) && this.bonCaisse.getBonCaisNature() != 29) {
            if (this.bonCaisse.getBonCaisNature() == 28) {
               this.casBonEncaissementChargement();
            } else if (this.bonCaisse.getBonCaisNature() == 62) {
               this.casBonSortie();
            } else if (this.bonCaisse.getBonCaisNature() == 63) {
               this.casBonEntree();
            } else if (this.bonCaisse.getBonCaisNature() == 64) {
               this.casBonVirement();
            } else if (this.bonCaisse.getBonCaisNature() == 65) {
               this.casOrdrePaiement();
            } else if (this.bonCaisse.getBonCaisNature() >= 70 && this.bonCaisse.getBonCaisNature() <= 79) {
               this.casBonPatient();
            } else if (this.bonCaisse.getBonCaisNature() >= 100 && this.bonCaisse.getBonCaisNature() <= 109) {
               this.casBonEleve();
            } else if (this.bonCaisse.getBonCaisNature() >= 170 && this.bonCaisse.getBonCaisNature() <= 179) {
               this.casBonSyndic();
            }
         } else {
            this.casBonEncaissement();
         }

         this.bonCaisse.setBonCaisId(this.reglements.getRglId());
         this.lesElements.remove(this.bonCaisse);
         this.datamodelElement.setWrappedData(this.lesElements);
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
         this.initImpression();
         if (this.bonCaisse.getBonCaisNature() == 64 && this.virementInterne != null && this.virementInterne.getVirCodEmetrice() != null && !this.virementInterne.getVirCodEmetrice().isEmpty() && this.virementInterne.getVirCodReceptrice() != null && !this.virementInterne.getVirCodReceptrice().isEmpty()) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "VirementInterne");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               if (this.exercicesComptable != null) {
                  new JournauxComptables();
                  JournauxComptables var3 = this.journauxComptablesDao.chercherCode(this.virementInterne.getVirCodEmetrice(), this.exercicesComptable.getExecpt_id(), var1);
                  if (var3 != null) {
                     int var4 = var3.getPljNature();
                     var3 = this.journauxComptablesDao.chercherCode(this.virementInterne.getVirCodReceptrice(), this.exercicesComptable.getExecpt_id(), var1);
                     if (var3 != null) {
                        int var5 = var3.getPljNature();
                        if ((var4 == 7 || var4 == 8 || var4 == 9 || var4 == 10) && (var5 == 7 || var5 == 8)) {
                           String var6 = this.calculChrono.numCompose(this.virementInterne.getVirDate(), this.virementInterne.getVirNature(), this.virementInterne.getVirSerie(), var1);
                           new VirementInterne();
                           VirementInterne var7 = this.virementInterne;
                           this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
                           this.virementInterne = new VirementInterne();
                           this.virementInterne = var7;
                           this.virementInterne.setVirId(0L);
                           this.virementInterne.setVirCodeCaiss((String)null);
                           this.virementInterne.setVirLibCaiss((String)null);
                           this.virementInterne.setVirCodEmetrice((String)null);
                           this.virementInterne.setVirNomEmetrice((String)null);
                           this.virementInterne.setVirDate(this.virementInterne.getVirDate());
                           this.virementInterne.setVirDateCreat(new Date());
                           this.virementInterne.setVirUserCreat(this.usersLog.getUsrid());
                           this.virementInterne.setVirGrp(this.usersLog.getUsrCollaboration());
                           this.virementInterne.setVirNum(var6);
                           this.virementInterne.setVirEtat(1);
                           this.virementInterne.setVirCle(this.virementInterne.getVirNum() + ":" + this.virementInterne.getVirNature());
                           this.virementInterne.setExercicesCaisse(this.selectedExo);
                           this.virementInterne = this.virementInterneDao.insert(this.virementInterne, var1);
                        }
                     }
                  }
               }

               var2.commit();
            } catch (HibernateException var11) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var11;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }

         this.var_action = 0;
         this.visibiliteBton = false;
      }

   }

   public void casBonDecaissement() throws HibernateException, NamingException {
      if (this.bonDecaissementAchat != null && this.bonDecaissementAchat.getBonEtat() == 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonDecaissementAchat");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.chargerCaisse(var1);
            this.reglements.setRglDateReg(this.bonDecaissementAchat.getBonDate());
            if (this.reglements.getRglDateReg() == null) {
               this.reglements.setRglDateReg(new Date());
            }

            String var3 = "";
            if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
               this.var_modeReglement = "0";
            }

            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var3 = this.calculChrono.numComposeCaisse(this.bonDecaissementAchat.getBonDate(), 61, this.var_modeReglement, this.serieCaisse, this.var_caisse, var1);
            } else if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("2")) {
               var3 = this.calculChrono.numComposeCaisse(this.bonDecaissementAchat.getBonDate(), 61, this.serieCaisse, this.var_caisse, var1);
            } else {
               var3 = this.calculChrono.numComposeCaisse(this.bonDecaissementAchat.getBonDate(), 61, this.serieCaisse, this.var_caisse, var1);
            }

            if (var3 != null && !var3.isEmpty()) {
               this.reglements.setRglOperation("21");
               this.reglements.setRglActivite(this.bonDecaissementAchat.getBonActivite());
               this.reglements.setRglBanqueTireur("");
               this.reglements.setRglBudget(this.bonDecaissementAchat.getBonBudget());
               this.reglements.setRglBon(this.bonDecaissementAchat.getBonNum());
               this.reglements.setRglCategorie(10);
               String[] var4;
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                  var4 = this.var_caisse.split(":");
                  this.reglements.setRglCodeCaiss(var4[0]);
                  this.reglements.setRglLibCaiss(var4[1]);
               } else {
                  this.reglements.setRglCodeCaiss((String)null);
                  this.reglements.setRglLibCaiss((String)null);
               }

               if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                  var4 = this.inputBanq.split(":");
                  this.reglements.setRglCodeEmetrice(var4[0]);
                  this.reglements.setRglLibEmetrice(var4[1]);
               } else {
                  this.reglements.setRglCodeEmetrice((String)null);
                  this.reglements.setRglLibEmetrice((String)null);
               }

               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateRemise(this.bonDecaissementAchat.getBonDateRemise());
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepartement(this.bonDecaissementAchat.getBonDepartement());
               this.reglements.setRglDepense(this.bonDecaissementAchat.getBonAPayer());
               if (this.bonDecaissementAchat.getBonDevise() != null && !this.bonDecaissementAchat.getBonDevise().isEmpty()) {
                  this.reglements.setRglDevise(this.bonDecaissementAchat.getBonDevise());
               } else {
                  this.reglements.setRglDevise(this.structureLog.getStrdevise());
               }

               this.reglements.setRglDossier("");
               this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
               this.reglements.setRglDocument(this.bonDecaissementAchat.getBonRef());
               this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
               this.reglements.setRglIdBon(this.bonDecaissementAchat.getBonId());
               this.reglements.setRglIdDocument(this.bonDecaissementAchat.getBonIdRef());
               this.reglements.setRglIdTiers(this.bonDecaissementAchat.getBonIdTiers());
               this.reglements.setRglDepotTiers(0);
               this.reglements.setRglLibelle(this.bonDecaissementAchat.getBonObject());
               this.reglements.setRglMode(this.var_modeReglement);
               this.reglements.setRglModele(this.bonDecaissementAchat.getBonModeleImp());
               this.reglements.setRglNumChqBdx(this.bonDecaissementAchat.getBonNumChqBdx());
               this.reglements.setRglNatureDoc(this.bonDecaissementAchat.getBonNatRef());
               this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
               this.reglements.setRglNomTiers(this.bonDecaissementAchat.getBonNomTiers());
               this.reglements.setRglNum(var3);
               this.reglements.setRglObjet(this.bonDecaissementAchat.getBonObject());
               this.reglements.setRglParc("");
               this.reglements.setRglPdv(this.bonDecaissementAchat.getBonPdv());
               this.reglements.setRglRecette(0.0D);
               this.reglements.setRglTimbre(this.var_timbre);
               this.reglements.setRglRegion(this.bonDecaissementAchat.getBonRegion());
               this.reglements.setRglSecteur(this.bonDecaissementAchat.getBonSecteur());
               this.reglements.setRglSerie(this.bonDecaissementAchat.getBonSerie());
               this.reglements.setRglService(this.bonDecaissementAchat.getBonService());
               this.reglements.setRglSite(this.bonDecaissementAchat.getBonSite());
               this.reglements.setRglTrf(0);
               this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
               this.reglements.setRglTypeTiers(0);
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
               this.reglements.setRglUserModif(0L);
               this.reglements.setRglIdResponsable(0L);
               this.reglements.setRglNomResponsable(this.bonDecaissementAchat.getBonNomResponsable());
               this.reglements.setRglIdCommercial(0L);
               this.reglements.setRglNomCommercial((String)null);
               this.reglements.setRglIdEquipe(0L);
               this.reglements.setRglNomEquipe((String)null);
               String var14 = "";
               if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                  var14 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
               } else {
                  var14 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
               }

               String var5 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
               this.reglements.setRglPeriode(var14 + ":" + var5);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               String var6 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var6);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var6);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglements = this.reglementsDao.insert(this.reglements, var1);
               if (this.bonDecaissementAchat != null) {
                  if (this.bonDecaissementAchat.getBonIdRef() != 0L && this.bonDecaissementAchat.getBonNatRef() == 12) {
                     new CommandeEnteteAchats();
                     CommandeEnteteAchatsDao var20 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                     CommandeEnteteAchats var17 = var20.pourParapheur(this.bonDecaissementAchat.getBonIdRef(), var1);
                     if (var17 != null) {
                        var17.setCmdTotReglement(var17.getCmdTotReglement() + this.bonDecaissementAchat.getBonAPayer());
                        if (var17.getCmdTotReglement() >= var17.getCmdTotTtc()) {
                           var17.setCmdSolde(1);
                        } else {
                           var17.setCmdSolde(0);
                        }

                        var20.modif(var17, var1);
                     }
                  } else if (this.bonDecaissementAchat.getBonIdRef() != 0L && this.bonDecaissementAchat.getBonNatRef() == 15) {
                     new FactureEnteteAchats();
                     FactureEnteteAchatsDao var19 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                     FactureEnteteAchats var16 = var19.pourParapheur(this.bonDecaissementAchat.getBonIdRef(), var1);
                     if (var16 != null) {
                        var16.setFcfTotReglement(var16.getFcfTotReglement() + this.bonDecaissementAchat.getBonAPayer());
                        if (var16.getFcfTotReglement() >= var16.getFcfTotTtc()) {
                           var16.setFcfSolde(1);
                        } else {
                           var16.setFcfSolde(0);
                        }

                        var19.modif(var16, var1);
                     }
                  } else if (this.bonDecaissementAchat.getBonIdRef() != 0L && this.bonDecaissementAchat.getBonNatRef() == 17) {
                     new NoteDebitEnteteAchats();
                     NoteDebitEnteteAchatsDao var18 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                     NoteDebitEnteteAchats var15 = var18.pourParapheur(this.bonDecaissementAchat.getBonIdRef(), var1);
                     if (var15 != null) {
                        var15.setNdfTotReglement(var15.getNdfTotReglement() + this.bonDecaissementAchat.getBonAPayer());
                        if (var15.getNdfTotReglement() >= var15.getNdfTotTtc()) {
                           var15.setNdfSolde(1);
                        } else {
                           var15.setNdfSolde(0);
                        }

                        var18.modif(var15, var1);
                     }
                  } else if (this.bonDecaissementAchat.getBonIdRef() != 0L && this.bonDecaissementAchat.getBonNatRef() == 18) {
                     new FraisEnteteAchats();
                     FraisEnteteAchatsDao var8 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
                     FraisEnteteAchats var7 = var8.pourParapheur(this.bonDecaissementAchat.getBonIdRef(), var1);
                     if (var7 != null) {
                        var7.setFsfTotReglement(var7.getFsfTotReglement() + this.bonDecaissementAchat.getBonAPayer());
                        if (var7.getFsfTotReglement() >= var7.getFsfTotTtc()) {
                           var7.setFsfSolde(1);
                        } else {
                           var7.setFsfSolde(0);
                        }

                        var8.modif(var7, var1);
                     }
                  }

                  if (this.optionCaisses.getBonDecaissement().equals("1")) {
                     this.bonDecaissementAchatDao.delete(this.bonDecaissementAchat, var1);
                  } else {
                     this.bonDecaissementAchat.setBonDateModif(new Date());
                     this.bonDecaissementAchat.setBonUserModif(this.usersLog.getUsrid());
                     this.bonDecaissementAchat.setBonEtat(1);
                     this.bonDecaissementAchat = this.bonDecaissementAchatDao.ModifBon(this.bonDecaissementAchat, var1);
                  }
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
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

   public void casBonCommission() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null && this.bonEncaissementVente.getBonEtat() == 0) {
         if (this.bonEncaissementVente.getBonEncaisse() == 0.0D) {
            this.bonEncaissementVente.setBonEncaisse(this.bonEncaissementVente.getBonAPayer());
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.chargerCaisse(var1);
            String var3 = "";
            if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
               this.var_modeReglement = "0";
            }

            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var3 = this.calculChrono.numCompose(this.bonEncaissementVente.getBonDate(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var1);
            } else {
               var3 = this.calculChrono.numCompose(this.bonEncaissementVente.getBonDate(), this.natCaisse, this.serieCaisse, var1);
            }

            if (var3 != null && !var3.isEmpty()) {
               new Reglements();
               String var5 = "";
               String var6 = "";
               String var7 = "";
               double var8 = this.bonEncaissementVente.getBonAPayer();
               double var10 = 0.0D;
               CommissionEnteteVentes var23;
               if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":") && this.listCommission.size() != 0) {
                  new CommissionEnteteVentes();

                  for(int var13 = 0; var13 < this.listCommission.size(); ++var13) {
                     var23 = (CommissionEnteteVentes)this.listCommission.get(var13);
                     if (var8 >= var23.getComTotCommission()) {
                        var10 = var23.getComTotCommission();
                     } else {
                        var10 = var8;
                     }

                     if (var10 != 0.0D) {
                        var8 -= var23.getComTotCommission();
                        this.reglements = new Reglements();
                        this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                        if (this.reglements.getRglDateReg() == null) {
                           this.reglements.setRglDateReg(new Date());
                        }

                        this.reglements.setRglOperation("24");
                        this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                        this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                        this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                        this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                        this.reglements.setRglCategorie(80);
                        String[] var14;
                        if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                           var14 = this.var_caisse.split(":");
                           this.reglements.setRglCodeCaiss(var14[0]);
                           this.reglements.setRglLibCaiss(var14[1]);
                        } else {
                           this.reglements.setRglCodeCaiss((String)null);
                           this.reglements.setRglLibCaiss((String)null);
                        }

                        if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                           var14 = this.inputBanq.split(":");
                           this.reglements.setRglCodeEmetrice(var14[0]);
                           this.reglements.setRglLibEmetrice(var14[1]);
                        } else {
                           this.reglements.setRglCodeEmetrice((String)null);
                           this.reglements.setRglLibEmetrice((String)null);
                        }

                        this.reglements.setRglCodeReceptrice((String)null);
                        this.reglements.setRglLibReceptrice((String)null);
                        this.reglements.setRglDateCreation(new Date());
                        this.reglements.setRglDateImp((Date)null);
                        this.reglements.setRglDateTransfert((Date)null);
                        this.reglements.setRglDateValeur((Date)null);
                        this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                        this.reglements.setRglDepense(var10);
                        if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                           this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                        } else {
                           this.reglements.setRglDevise(this.structureLog.getStrdevise());
                        }

                        this.reglements.setRglDossier("");
                        this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                        this.reglements.setRglDocument(var23.getComNum());
                        this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                        this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                        this.reglements.setRglIdDocument(var23.getComId());
                        this.reglements.setRglIdTiers(0L);
                        this.reglements.setRglDepotTiers(0);
                        this.reglements.setRglLibelle(this.bonEncaissementVente.getBonObject());
                        this.reglements.setRglMode(this.var_modeReglement);
                        this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                        this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
                        this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                        this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                        if (var23.getComIdResponsable() != 0L) {
                           this.reglements.setRglNomTiers(var23.getComNomResponsable());
                           this.reglements.setRglIdContact(var23.getComIdResponsable());
                           this.reglements.setRglNomContact(var23.getComNomResponsable());
                        } else {
                           this.reglements.setRglNomTiers(var23.getComNomCommercial());
                           this.reglements.setRglIdContact(var23.getComIdCommercial());
                           this.reglements.setRglNomContact(var23.getComNomCommercial());
                        }

                        this.reglements.setRglNum(var3);
                        this.reglements.setRglObjet(this.bonEncaissementVente.getBonObject());
                        this.reglements.setRglParc("");
                        this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                        this.reglements.setRglRecette(0.0D);
                        this.reglements.setRglTimbre(0.0D);
                        this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                        this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                        this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                        this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                        this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                        this.reglements.setRglTrf(0);
                        this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
                        this.reglements.setRglTypeTiers(0);
                        this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                        this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                        this.reglements.setRglUserModif(0L);
                        this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                        this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                        this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                        this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                        this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
                        this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
                        if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                           var5 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                        } else {
                           var5 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                        }

                        var6 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                        this.reglements.setRglPeriode(var5 + ":" + var6);
                        this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                        var7 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                        this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var7);
                        this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                        this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var7);
                        this.reglements.setExercicesCaisse(this.selectedExo);
                        this.reglements = this.reglementsDao.insert(this.reglements, var1);
                     }
                  }
               } else {
                  this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                  if (this.reglements.getRglDateReg() == null) {
                     this.reglements.setRglDateReg(new Date());
                  }

                  this.reglements.setRglOperation("24");
                  this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                  this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                  this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                  this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                  this.reglements.setRglCategorie(80);
                  String[] var12;
                  if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                     var12 = this.var_caisse.split(":");
                     this.reglements.setRglCodeCaiss(var12[0]);
                     this.reglements.setRglLibCaiss(var12[1]);
                  } else {
                     this.reglements.setRglCodeCaiss((String)null);
                     this.reglements.setRglLibCaiss((String)null);
                  }

                  if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                     var12 = this.inputBanq.split(":");
                     this.reglements.setRglCodeEmetrice(var12[0]);
                     this.reglements.setRglLibEmetrice(var12[1]);
                  } else {
                     this.reglements.setRglCodeEmetrice((String)null);
                     this.reglements.setRglLibEmetrice((String)null);
                  }

                  this.reglements.setRglCodeReceptrice((String)null);
                  this.reglements.setRglLibReceptrice((String)null);
                  this.reglements.setRglDateCreation(new Date());
                  this.reglements.setRglDateImp((Date)null);
                  this.reglements.setRglDateTransfert((Date)null);
                  this.reglements.setRglDateValeur((Date)null);
                  this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                  this.reglements.setRglDepense(this.bonEncaissementVente.getBonAPayer());
                  if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                     this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                  } else {
                     this.reglements.setRglDevise(this.structureLog.getStrdevise());
                  }

                  this.reglements.setRglDossier("");
                  this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                  this.reglements.setRglDocument(this.bonEncaissementVente.getBonRef());
                  this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                  this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                  this.reglements.setRglIdDocument(this.bonEncaissementVente.getBonIdRef());
                  this.reglements.setRglIdTiers(this.bonEncaissementVente.getBonIdTiers());
                  this.reglements.setRglDepotTiers(0);
                  this.reglements.setRglLibelle(this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglMode(this.var_modeReglement);
                  this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                  this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
                  this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                  this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                  this.reglements.setRglNomTiers(this.bonEncaissementVente.getBonNomTiers());
                  this.reglements.setRglIdContact(this.bonEncaissementVente.getBonIdContact());
                  this.reglements.setRglNomContact(this.bonEncaissementVente.getBonNomContact());
                  this.reglements.setRglNum(var3);
                  this.reglements.setRglObjet(this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglParc("");
                  this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                  this.reglements.setRglRecette(0.0D);
                  this.reglements.setRglTimbre(0.0D);
                  this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                  this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                  this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                  this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                  this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                  this.reglements.setRglTrf(0);
                  this.reglements.setRglTypeReg(this.bonCaisse.getBonCaisTypeReg());
                  this.reglements.setRglTypeTiers(0);
                  this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                  this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                  this.reglements.setRglUserModif(0L);
                  this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                  this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                  this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                  this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                  this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
                  this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
                  if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                     var5 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                  } else {
                     var5 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                  }

                  var6 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                  this.reglements.setRglPeriode(var5 + ":" + var6);
                  this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                  var7 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                  this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var7);
                  this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                  this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var7);
                  this.reglements.setExercicesCaisse(this.selectedExo);
                  this.reglements = this.reglementsDao.insert(this.reglements, var1);
                  Reglements var4 = this.reglements;
               }

               if (this.bonEncaissementVente != null) {
                  if (this.bonEncaissementVente.getBonIdRef() != 0L && this.bonEncaissementVente.getBonNatRef() == 7) {
                     if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":")) {
                        new ArrayList();
                        new CommissionEnteteVentes();

                        for(int var26 = 0; var26 < this.listCommission.size(); ++var26) {
                           CommissionEnteteVentes var25 = (CommissionEnteteVentes)this.listCommission.get(var26);
                           if (var25 != null) {
                              double var15 = 0.0D;
                              List var24 = this.reglementsDao.reglementDocument(var25.getComId(), 7, var1);
                              if (var24.size() != 0) {
                                 for(int var17 = 0; var17 < var24.size(); ++var17) {
                                    var15 += ((Reglements)var24.get(var17)).getRglDepense();
                                 }
                              }

                              var25.setComTotReglement(var15);
                              if (var25.getComTotReglement() >= var25.getComTotCommission()) {
                                 var25.setComSolde(1);
                              } else {
                                 var25.setComSolde(0);
                              }

                              var25.setComDateLastReg(this.reglements.getRglDateReg());
                              this.commissionEnteteVentesDao.modif(var25, var1);
                           }
                        }
                     } else {
                        new CommissionEnteteVentes();
                        var23 = this.commissionEnteteVentesDao.pourParapheur(this.bonEncaissementVente.getBonIdRef(), var1);
                        if (var23 != null) {
                           var23.setComTotReglement(var23.getComTotReglement() + this.bonEncaissementVente.getBonAPayer());
                           if (var23.getComTotReglement() >= var23.getComTotCommission()) {
                              var23.setComSolde(1);
                           } else {
                              var23.setComSolde(0);
                           }

                           var23.setComDateLastReg(this.reglements.getRglDateReg());
                           this.commissionEnteteVentesDao.modif(var23, var1);
                        }
                     }
                  }

                  if (this.optionCaisses.getBonEncaissement().equals("1")) {
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var1);
                  } else {
                     this.bonEncaissementVente.setBonDateModif(new Date());
                     this.bonEncaissementVente.setBonUserModif(this.usersLog.getUsrid());
                     this.bonEncaissementVente.setBonEtat(1);
                     this.bonEncaissementVente = this.bonEncaissementVenteDao.ModifBon(this.bonEncaissementVente, var1);
                  }
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
            }

            var2.commit();
         } catch (HibernateException var21) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void casBonEncaissement() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null && this.bonEncaissementVente.getBonEtat() == 0) {
         if (this.bonEncaissementVente.getBonEncaisse() == 0.0D) {
            this.bonEncaissementVente.setBonEncaisse(this.bonEncaissementVente.getBonAPayer());
         }

         double var1 = 0.0D;
         double var3 = 0.0D;
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
         Transaction var6 = null;

         try {
            var6 = var5.beginTransaction();
            this.chargerCaisse(var5);
            String var7 = "";
            if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
               this.var_modeReglement = "0";
            }

            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.var_modeReglement, this.serieCaisse, this.var_caisse, var5);
            } else if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("2")) {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.serieCaisse, this.var_caisse, var5);
            } else {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.serieCaisse, this.var_caisse, var5);
            }

            if (var7 != null && !var7.isEmpty()) {
               Reglements var8 = new Reglements();
               String var9 = "";
               String var10 = "";
               String var11 = "";
               if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":") && this.listFacture.size() != 0) {
                  double var26 = 0.0D;
                  if (this.bonEncaissementVente.isBonGarde()) {
                     var26 = this.bonEncaissementVente.getBonAPayer();
                  } else {
                     var26 = this.bonEncaissementVente.getBonEncaisse();
                  }

                  new FactureEnteteVentes();

                  for(int var15 = 0; var15 < this.listFacture.size(); ++var15) {
                     FactureEnteteVentes var14 = (FactureEnteteVentes)this.listFacture.get(var15);
                     if (var26 >= var14.getFacTotTtc()) {
                        var1 = var14.getFacTotTtc();
                     } else {
                        var1 = var26;
                     }

                     if (var1 != 0.0D) {
                        var26 -= var14.getFacTotTtc();
                        if (this.var_timbre != 0.0D) {
                           var3 = this.calculTimbreVentes(var26, this.bonEncaissementVente.getBonDevise(), var5);
                        } else {
                           var3 = 0.0D;
                        }

                        this.reglements = new Reglements();
                        this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                        if (this.reglements.getRglDateReg() == null) {
                           this.reglements.setRglDateReg(new Date());
                        }

                        this.reglements.setRglOperation("01");
                        this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                        this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                        this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                        this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                        this.reglements.setRglCategorie(20);
                        String[] var16;
                        if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                           var16 = this.var_caisse.split(":");
                           this.reglements.setRglCodeCaiss(var16[0]);
                           this.reglements.setRglLibCaiss(var16[1]);
                        } else {
                           this.reglements.setRglCodeCaiss((String)null);
                           this.reglements.setRglLibCaiss((String)null);
                        }

                        if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                           var16 = this.inputBanq.split(":");
                           this.reglements.setRglCodeEmetrice(var16[0]);
                           this.reglements.setRglLibEmetrice(var16[1]);
                        } else {
                           this.reglements.setRglCodeEmetrice((String)null);
                           this.reglements.setRglLibEmetrice((String)null);
                        }

                        this.reglements.setRglCodeReceptrice((String)null);
                        this.reglements.setRglLibReceptrice((String)null);
                        this.reglements.setRglDateCreation(new Date());
                        this.reglements.setRglDateImp((Date)null);
                        this.reglements.setRglDateTransfert((Date)null);
                        this.reglements.setRglDateValeur((Date)null);
                        this.reglements.setRglDateRemise(this.bonEncaissementVente.getBonDateRemise());
                        this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                        this.reglements.setRglDepense(0.0D);
                        if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                           this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                        } else {
                           this.reglements.setRglDevise(this.structureLog.getStrdevise());
                        }

                        this.reglements.setRglDossier("");
                        this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                        this.reglements.setRglDocument(var14.getFacNum());
                        this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                        this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                        this.reglements.setRglIdDocument(var14.getFacId());
                        this.reglements.setRglIdTiers(var14.getTiers().getTieid());
                        if (Integer.parseInt(this.var_modeReglement) == 90) {
                           this.reglements.setRglDepotTiers(3);
                        } else if (this.reglements.getRglOperation() == null || this.reglements.getRglOperation().isEmpty() || !this.reglements.getRglOperation().equals("13") && !this.reglements.getRglOperation().equals("15")) {
                           this.reglements.setRglDepotTiers(0);
                        } else {
                           this.reglements.setRglDepotTiers(1);
                        }

                        this.reglements.setRglLibelle(this.bonEncaissementVente.getBonObject());
                        this.reglements.setRglMode(this.var_modeReglement);
                        this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                        this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
                        this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                        this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                        if (var14.getFacDiversNom() != null && !var14.getFacDiversNom().isEmpty()) {
                           this.reglements.setRglNomTiers(var14.getFacDiversNom());
                        } else {
                           this.reglements.setRglNomTiers(var14.getFacNomTiers());
                        }

                        if (this.optionVentes.getDecrmtPrsChrStock() != null && this.optionVentes.getDecrmtPrsChrStock().equals("2")) {
                           this.reglements.setRglIdContact(var14.getFacIdContact());
                           this.reglements.setRglNomContact(var14.getFacNomContact());
                        } else {
                           this.reglements.setRglIdContact(0L);
                           this.reglements.setRglNomContact("");
                        }

                        this.reglements.setRglNum(var7);
                        this.reglements.setRglObjet(this.bonEncaissementVente.getBonObject());
                        this.reglements.setRglParc("");
                        this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                        this.reglements.setRglRecette(var1);
                        this.reglements.setRglRendu(0.0D);
                        this.reglements.setRglTimbre(var3);
                        this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                        this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                        this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                        this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                        this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                        this.reglements.setRglTrf(0);
                        this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
                        this.reglements.setRglTypeTiers(0);
                        this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                        this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                        this.reglements.setRglUserModif(0L);
                        this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                        this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                        this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                        this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                        this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
                        this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
                        if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                           var9 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                        } else {
                           var9 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                        }

                        var10 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                        this.reglements.setRglPeriode(var9 + ":" + var10);
                        this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                        var11 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                        this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var11);
                        this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                        this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var11);
                        this.reglements.setExercicesCaisse(this.selectedExo);
                        this.reglements = this.reglementsDao.insert(this.reglements, var5);
                     }
                  }
               } else {
                  this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                  if (this.reglements.getRglDateReg() == null) {
                     this.reglements.setRglDateReg(new Date());
                  }

                  if (this.bonEncaissementVente.isBonGarde()) {
                     var1 = this.bonEncaissementVente.getBonAPayer() + this.var_timbre;
                  } else {
                     var1 = this.bonEncaissementVente.getBonEncaisse() + this.var_timbre;
                  }

                  this.reglements.setRglOperation("01");
                  this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                  this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                  this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                  this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                  this.reglements.setRglCategorie(20);
                  String[] var12;
                  if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                     var12 = this.var_caisse.split(":");
                     this.reglements.setRglCodeCaiss(var12[0]);
                     this.reglements.setRglLibCaiss(var12[1]);
                  } else {
                     this.reglements.setRglCodeCaiss((String)null);
                     this.reglements.setRglLibCaiss((String)null);
                  }

                  if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                     var12 = this.inputBanq.split(":");
                     this.reglements.setRglCodeEmetrice(var12[0]);
                     this.reglements.setRglLibEmetrice(var12[1]);
                  } else {
                     this.reglements.setRglCodeEmetrice((String)null);
                     this.reglements.setRglLibEmetrice((String)null);
                  }

                  this.reglements.setRglCodeReceptrice((String)null);
                  this.reglements.setRglLibReceptrice((String)null);
                  this.reglements.setRglDateCreation(new Date());
                  this.reglements.setRglDateImp((Date)null);
                  this.reglements.setRglDateTransfert((Date)null);
                  this.reglements.setRglDateRemise(this.bonEncaissementVente.getBonDateRemise());
                  this.reglements.setRglDateValeur((Date)null);
                  this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                  this.reglements.setRglDepense(0.0D);
                  if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                     this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                  } else {
                     this.reglements.setRglDevise(this.structureLog.getStrdevise());
                  }

                  this.reglements.setRglDossier("");
                  this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                  this.reglements.setRglDocument(this.bonEncaissementVente.getBonRef());
                  this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                  this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                  this.reglements.setRglIdDocument(this.bonEncaissementVente.getBonIdRef());
                  this.reglements.setRglIdTiers(this.bonEncaissementVente.getBonIdTiers());
                  if (Integer.parseInt(this.var_modeReglement) == 90) {
                     this.reglements.setRglDepotTiers(3);
                  } else if (this.reglements.getRglOperation() == null || this.reglements.getRglOperation().isEmpty() || !this.reglements.getRglOperation().equals("13") && !this.reglements.getRglOperation().equals("15")) {
                     this.reglements.setRglDepotTiers(0);
                  } else {
                     this.reglements.setRglDepotTiers(1);
                  }

                  this.reglements.setRglLibelle(this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglMode(this.var_modeReglement);
                  this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                  this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
                  this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                  this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                  this.reglements.setRglNomTiers(this.bonEncaissementVente.getBonNomTiers());
                  if (this.optionVentes.getDecrmtPrsChrStock() != null && this.optionVentes.getDecrmtPrsChrStock().equals("2")) {
                     this.reglements.setRglIdContact(this.bonEncaissementVente.getBonIdContact());
                     this.reglements.setRglNomContact(this.bonEncaissementVente.getBonNomContact());
                  } else {
                     this.reglements.setRglIdContact(0L);
                     this.reglements.setRglNomContact("");
                  }

                  this.reglements.setRglNum(var7);
                  this.reglements.setRglObjet(this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglParc("");
                  this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                  this.reglements.setRglRecette(this.var_aPayer);
                  if (!this.bonEncaissementVente.isBonGarde() && this.bonEncaissementVente.getBonRendu() != 0.0D) {
                     this.reglements.setRglRendu(this.bonEncaissementVente.getBonRendu());
                  } else {
                     this.reglements.setRglRendu(0.0D);
                  }

                  this.reglements.setRglTimbre(this.var_timbre);
                  this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                  this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                  this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                  this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                  this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                  this.reglements.setRglTrf(0);
                  this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
                  this.reglements.setRglTypeTiers(0);
                  this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                  this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                  this.reglements.setRglUserModif(0L);
                  this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                  this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                  this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                  this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                  this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
                  this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
                  if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                     var9 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                  } else {
                     var9 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                  }

                  var10 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                  this.reglements.setRglPeriode(var9 + ":" + var10);
                  this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                  var11 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                  this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var11);
                  this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                  this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var11);
                  this.reglements.setExercicesCaisse(this.selectedExo);
                  this.reglements = this.reglementsDao.insert(this.reglements, var5);
                  var8 = this.reglements;
               }

               if (this.bonEncaissementVente != null) {
                  if (this.bonEncaissementVente.getBonIdRef() != 0L && this.bonEncaissementVente.getBonNatRef() == 21) {
                     new DevisEnteteVentes();
                     DevisEnteteVentesDao var29 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                     DevisEnteteVentes var41 = var29.pourParapheur(this.bonEncaissementVente.getBonIdRef(), var5);
                     if (var41 != null) {
                        var41.setDvsTotReglement(var41.getDvsTotReglement() + var1);
                        if (Math.abs(var41.getDvsTotReglement()) >= Math.abs(var41.getDvsTotTtc())) {
                           var41.setDvsSolde(1);
                        } else {
                           var41.setDvsSolde(0);
                        }

                        var29.modif(var41, var5);
                     }
                  } else if (this.bonEncaissementVente.getBonIdRef() != 0L && this.bonEncaissementVente.getBonNatRef() == 22) {
                     new CommandeEnteteVentes();
                     CommandeEnteteVentes var39 = this.commandeEnteteVentesDao.pourParapheur(this.bonEncaissementVente.getBonIdRef(), var5);
                     if (var39 != null) {
                        var39.setBcmTotReglement(var39.getBcmTotReglement() + var1);
                        if (Math.abs(var39.getBcmTotReglement()) >= Math.abs(var39.getBcmTotTtc())) {
                           var39.setBcmSolde(1);
                        } else {
                           var39.setBcmSolde(0);
                        }

                        var39.setBcmDateLastReg(this.reglements.getRglDateReg());
                        this.commandeEnteteVentesDao.modif(var39, var5);
                     }
                  } else if (this.bonEncaissementVente.getBonIdRef() != 0L && this.bonEncaissementVente.getBonNatRef() == 23) {
                     new LivraisonEnteteVentes();
                     LivraisonEnteteVentes var37 = this.livraisonEnteteVentesDao.pourParapheur(this.bonEncaissementVente.getBonIdRef(), var5);
                     if (var37 != null) {
                        var37.setBlvTotReglement(var37.getBlvTotReglement() + var1);
                        if (Math.abs(var37.getBlvTotReglement()) >= Math.abs(var37.getBlvTotTtc())) {
                           var37.setBlvSolde(1);
                        } else {
                           var37.setBlvSolde(0);
                        }

                        this.livraisonEnteteVentesDao.modif(var37, var5);
                     }
                  } else if (this.bonEncaissementVente.getBonNatRef() != 25) {
                     if (this.bonEncaissementVente.getBonIdRef() != 0L && this.bonEncaissementVente.getBonNatRef() == 27) {
                        new NoteDebitEnteteVentes();
                        NoteDebitEnteteVentesDao var28 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                        NoteDebitEnteteVentes var36 = var28.pourParapheur(this.bonEncaissementVente.getBonIdRef(), var5);
                        if (var36 != null) {
                           var36.setNdbTotReglement(var36.getNdbTotReglement() + var1);
                           if (Math.abs(var36.getNdbTotReglement()) >= Math.abs(var36.getNdbTotTtc())) {
                              var36.setNdbSolde(1);
                           } else {
                              var36.setNdbSolde(0);
                           }

                           var28.modif(var36, var5);
                        }
                     }
                  } else {
                     double var40;
                     if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":")) {
                        new ArrayList();
                        new FactureEnteteVentes();

                        for(int var34 = 0; var34 < this.listFacture.size(); ++var34) {
                           FactureEnteteVentes var27 = (FactureEnteteVentes)this.listFacture.get(var34);
                           if (var27 != null) {
                              var40 = 0.0D;
                              double var17 = 0.0D;
                              List var35 = this.reglementsDao.reglementDocument(var27.getFacId(), 25, var5);
                              if (var35.size() != 0) {
                                 for(int var19 = 0; var19 < var35.size(); ++var19) {
                                    var40 += ((Reglements)var35.get(var19)).getRglRecette();
                                    var17 += ((Reglements)var35.get(var19)).getRglTimbre();
                                 }
                              }

                              var27.setFacTotReglement(var40);
                              var27.setFacTotTimbre(var17);
                              if (Math.abs(var27.getFacTotReglement()) >= Math.abs(var27.getFacTotTtc() + var27.getFacTotTimbre())) {
                                 var27.setFacSolde(1);
                              } else {
                                 var27.setFacSolde(0);
                              }

                              var27.setFacDateLastReg(this.reglements.getRglDateReg());
                              this.factureEnteteVentesDao.modif(var27, var5);
                              if (var27.getFacContrat() != null && !var27.getFacContrat().isEmpty() && var27.getFacContrat().contains("CH:")) {
                                 new ChargementEntete();
                                 ChargementEnteteDao var20 = new ChargementEnteteDao(this.baseLog, this.utilInitHibernate);
                                 ChargementEntete var45 = var20.pourChargement(var27.getFacContrat(), var27.getFacSerie(), var5);
                                 if (var45 != null) {
                                    var45.setChamobDateReglement(this.reglements.getRglDateReg());
                                    var45.setChamobTotReglement(var40);
                                    var20.modif(var45, var5);
                                 }
                              }
                           }
                        }
                     } else if (this.bonEncaissementVente.getBonIdRef() != 0L) {
                        new FactureEnteteVentes();
                        FactureEnteteVentes var31 = this.factureEnteteVentesDao.pourParapheur(this.bonEncaissementVente.getBonIdRef(), var5);
                        if (var31 != null) {
                           var31.setFacTotReglement(var31.getFacTotReglement() + this.var_aPayer);
                           if (Math.abs(var31.getFacTotReglement()) >= Math.abs(var31.getFacTotTtc())) {
                              var31.setFacSolde(1);
                           } else {
                              var31.setFacSolde(0);
                           }

                           var31.setFacTotTimbre(var31.getFacTotTimbre() + this.var_timbre);
                           var31.setFacDateLastReg(this.reglements.getRglDateReg());
                           this.factureEnteteVentesDao.modif(var31, var5);
                           if (this.bonEncaissementVente.getBonIdChg() != 0L) {
                              new ChargementEntete();
                              ChargementEnteteDao var32 = new ChargementEnteteDao(this.baseLog, this.utilInitHibernate);
                              ChargementEntete var13 = var32.pourParapheur(this.bonEncaissementVente.getBonIdChg(), var5);
                              if (var13 != null) {
                                 var13.setChamobDateReglement(this.reglements.getRglDateReg());
                                 var40 = var13.getChamobTotReglement() + var1;
                                 var13.setChamobTotReglement(var40);
                                 var32.modif(var13, var5);
                              }
                           }
                        }
                     }
                  }

                  if (this.optionCaisses.getBonEncaissement().equals("1")) {
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var5);
                  } else {
                     this.bonEncaissementVente.setBonDateModif(new Date());
                     this.bonEncaissementVente.setBonUserModif(this.usersLog.getUsrid());
                     this.bonEncaissementVente.setBonEtat(1);
                     this.bonEncaissementVente = this.bonEncaissementVenteDao.ModifBon(this.bonEncaissementVente, var5);
                  }
               }

               boolean var42 = false;
               if (this.bonEncaissementVente.isBonGarde() && this.bonEncaissementVente.getBonRendu() != 0.0D) {
                  this.reglements = new Reglements();
                  this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                  if (this.reglements.getRglDateReg() == null) {
                     this.reglements.setRglDateReg(new Date());
                  }

                  this.reglements.setRglOperation("13");
                  this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                  this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                  this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                  this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                  this.reglements.setRglCategorie(20);
                  if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                     String[] var30 = this.var_caisse.split(":");
                     this.reglements.setRglCodeCaiss(var30[0]);
                     this.reglements.setRglLibCaiss(var30[1]);
                  } else {
                     this.reglements.setRglCodeCaiss((String)null);
                     this.reglements.setRglLibCaiss((String)null);
                  }

                  this.reglements.setRglCodeEmetrice(this.bonEncaissementVente.getBonCodeBanq());
                  this.reglements.setRglCodeReceptrice((String)null);
                  this.reglements.setRglDateCreation(new Date());
                  this.reglements.setRglDateImp((Date)null);
                  this.reglements.setRglDateTransfert((Date)null);
                  this.reglements.setRglDateRemise(this.bonEncaissementVente.getBonDateRemise());
                  this.reglements.setRglDateValeur((Date)null);
                  this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                  this.reglements.setRglDepense(0.0D);
                  if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                     this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                  } else {
                     this.reglements.setRglDevise(this.structureLog.getStrdevise());
                  }

                  this.reglements.setRglDossier("");
                  this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                  this.reglements.setRglDocument("");
                  this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                  this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                  this.reglements.setRglIdDocument(0L);
                  this.reglements.setRglIdTiers(this.bonEncaissementVente.getBonIdTiers());
                  this.reglements.setRglDepotTiers(1);
                  this.reglements.setRglLibEmetrice(this.bonEncaissementVente.getBonLibBanq());
                  this.reglements.setRglLibReceptrice("");
                  this.reglements.setRglLibelle("(déposit) " + this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglMode(this.var_modeReglement);
                  this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                  this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
                  this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                  this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                  this.reglements.setRglNomTiers(this.bonEncaissementVente.getBonNomTiers());
                  this.reglements.setRglNum(var7);
                  this.reglements.setRglObjet("(déposit) " + this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglParc("");
                  this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                  this.reglements.setRglRecette(this.bonEncaissementVente.getBonRendu());
                  this.reglements.setRglTimbre(0.0D);
                  this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                  this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                  this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                  this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                  this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                  this.reglements.setRglTrf(0);
                  this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                  this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                  this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                  this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                  this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
                  this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
                  this.reglements.setRglTypeReg(this.bonCaisse.getBonCaisTypeReg());
                  this.reglements.setRglTypeTiers(0);
                  this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                  this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                  this.reglements.setRglUserModif(0L);
                  this.reglements.setRglPeriode(var9 + ":" + var10);
                  this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                  this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var11);
                  this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                  this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var11);
                  this.reglements.setExercicesCaisse(this.selectedExo);
                  this.reglementsDao.insert(this.reglements, var5);
                  this.reglements = var8;
                  var42 = true;
               }

               if (Integer.parseInt(this.var_modeReglement) == 90 || this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && (this.reglements.getRglOperation().equals("13") || this.reglements.getRglOperation().equals("15"))) {
                  var42 = true;
               }

               if (var42) {
                  new ArrayList();
                  List var33 = this.reglementsDao.rechercheHistoDepot(this.tiers.getTieid(), var5);
                  double var38 = 0.0D;
                  if (var33.size() != 0) {
                     for(int var43 = 0; var43 < var33.size(); ++var43) {
                        if (((Reglements)var33.get(var43)).getRglTypeReg() == 90) {
                           if (((Reglements)var33.get(var43)).getRglCategorie() == 10) {
                              var38 = var38 - ((Reglements)var33.get(var43)).getRglRecette() + ((Reglements)var33.get(var43)).getRglDepense();
                           } else {
                              var38 = var38 - ((Reglements)var33.get(var43)).getRglRecette() - ((Reglements)var33.get(var43)).getRglDepense();
                           }
                        } else {
                           var38 = var38 + ((Reglements)var33.get(var43)).getRglRecette() - ((Reglements)var33.get(var43)).getRglDepense();
                        }
                     }
                  }

                  TiersDao var44 = new TiersDao(this.baseLog, this.utilInitHibernate);
                  this.tiers = var44.selectTierD(this.tiers.getTieid(), var5);
                  if (this.tiers != null) {
                     this.tiers.setTiedepotavance(var38);
                     this.tiers = var44.modif(this.tiers, var5);
                  }
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
            }

            var6.commit();
         } catch (HibernateException var24) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var24;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void casBonEncaissementChargement() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null && this.bonEncaissementVente.getBonEtat() == 0) {
         if (this.bonEncaissementVente.getBonEncaisse() == 0.0D) {
            this.bonEncaissementVente.setBonEncaisse(this.bonEncaissementVente.getBonAPayer());
         }

         double var1 = 0.0D;
         double var3 = 0.0D;
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
         Transaction var6 = null;

         try {
            var6 = var5.beginTransaction();
            this.chargerCaisse(var5);
            String var7 = "";
            if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
               this.var_modeReglement = "0";
            }

            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var7 = this.calculChrono.numCompose(this.bonEncaissementVente.getBonDate(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var5);
            } else {
               var7 = this.calculChrono.numCompose(this.bonEncaissementVente.getBonDate(), this.natCaisse, this.serieCaisse, var5);
            }

            if (var7 != null && !var7.isEmpty()) {
               String var8 = "";
               String var9 = "";
               String var10 = "";
               this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
               if (this.reglements.getRglDateReg() == null) {
                  this.reglements.setRglDateReg(new Date());
               }

               if (this.bonEncaissementVente.isBonGarde()) {
                  var1 = this.bonEncaissementVente.getBonAPayer() - this.var_timbre;
               } else {
                  var1 = this.bonEncaissementVente.getBonEncaisse() - this.var_timbre;
               }

               this.reglements.setRglOperation("30");
               this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
               this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
               this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
               this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
               this.reglements.setRglCategorie(20);
               String[] var11;
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                  var11 = this.var_caisse.split(":");
                  this.reglements.setRglCodeCaiss(var11[0]);
                  this.reglements.setRglLibCaiss(var11[1]);
               } else {
                  this.reglements.setRglCodeCaiss((String)null);
                  this.reglements.setRglLibCaiss((String)null);
               }

               if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                  var11 = this.inputBanq.split(":");
                  this.reglements.setRglCodeEmetrice(var11[0]);
                  this.reglements.setRglLibEmetrice(var11[1]);
               } else {
                  this.reglements.setRglCodeEmetrice((String)null);
                  this.reglements.setRglLibEmetrice((String)null);
               }

               this.reglements.setRglCodeReceptrice((String)null);
               this.reglements.setRglLibReceptrice((String)null);
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateRemise(this.bonEncaissementVente.getBonDateRemise());
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
               this.reglements.setRglDepense(var1);
               if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                  this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
               } else {
                  this.reglements.setRglDevise(this.structureLog.getStrdevise());
               }

               this.reglements.setRglDossier("");
               this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
               this.reglements.setRglDocument(this.bonEncaissementVente.getBonRef());
               this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
               this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
               this.reglements.setRglIdDocument(this.bonEncaissementVente.getBonIdRef());
               this.reglements.setRglIdTiers(this.bonEncaissementVente.getBonIdTiers());
               this.reglements.setRglDepotTiers(0);
               this.reglements.setRglLibelle(this.bonEncaissementVente.getBonObject());
               this.reglements.setRglMode(this.var_modeReglement);
               this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
               this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
               this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
               this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
               this.reglements.setRglNomTiers(this.bonEncaissementVente.getBonNomTiers());
               this.reglements.setRglIdContact(0L);
               this.reglements.setRglNomContact("");
               this.reglements.setRglNum(var7);
               this.reglements.setRglObjet(this.bonEncaissementVente.getBonObject());
               this.reglements.setRglParc("");
               this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
               this.reglements.setRglRecette(0.0D);
               if (!this.bonEncaissementVente.isBonGarde() && this.bonEncaissementVente.getBonRendu() != 0.0D) {
                  this.reglements.setRglRendu(this.bonEncaissementVente.getBonRendu());
               } else {
                  this.reglements.setRglRendu(0.0D);
               }

               this.reglements.setRglTimbre(this.var_timbre);
               this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
               this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
               this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
               this.reglements.setRglService(this.bonEncaissementVente.getBonService());
               this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
               this.reglements.setRglTrf(0);
               this.reglements.setRglTypeReg(this.bonCaisse.getBonCaisTypeReg());
               this.reglements.setRglTypeTiers(6);
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
               this.reglements.setRglUserModif(0L);
               this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
               this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
               this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
               this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
               this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
               this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
               if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                  var8 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
               } else {
                  var8 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
               }

               var9 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
               this.reglements.setRglPeriode(var8 + ":" + var9);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               var10 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var10);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var10);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglements = this.reglementsDao.insert(this.reglements, var5);
               if (this.optionCaisses.getBonEncaissement().equals("1")) {
                  this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var5);
               } else {
                  this.bonEncaissementVente.setBonDateModif(new Date());
                  this.bonEncaissementVente.setBonUserModif(this.usersLog.getUsrid());
                  this.bonEncaissementVente.setBonEtat(1);
                  this.bonEncaissementVente = this.bonEncaissementVenteDao.ModifBon(this.bonEncaissementVente, var5);
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
            }

            var6.commit();
         } catch (HibernateException var15) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var15;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void casBonSortie() throws HibernateException, NamingException {
      if (this.bonSortieCaiss != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonSortieCaiss");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.chargerCaisse(var1);
            this.reglements.setRglDateReg(this.bonSortieCaiss.getSortDate());
            if (this.reglements.getRglDateReg() == null) {
               this.reglements.setRglDateReg(new Date());
            }

            String var3 = "";
            if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
               this.var_modeReglement = "0";
            }

            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var3 = this.calculChrono.numCompose(this.reglements.getRglDateReg(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var1);
            } else {
               var3 = this.calculChrono.numCompose(this.reglements.getRglDateReg(), this.natCaisse, this.serieCaisse, var1);
            }

            if (var3 != null && !var3.isEmpty()) {
               if (this.bonSortieCaiss.getSortOperation() != null && !this.bonSortieCaiss.getSortOperation().isEmpty() && this.bonSortieCaiss.getSortOperation().equals("25")) {
                  this.reglements.setRglOperation("25");
                  this.reglements.setRglDepotTiers(0);
               } else if (this.bonSortieCaiss.getSortOperation() != null && !this.bonSortieCaiss.getSortOperation().isEmpty() && this.bonSortieCaiss.getSortOperation().equals("15")) {
                  this.reglements.setRglOperation("15");
                  this.reglements.setRglDepotTiers(1);
               } else {
                  this.reglements.setRglOperation("20");
                  this.reglements.setRglDepotTiers(0);
               }

               this.reglements.setRglActivite(this.bonSortieCaiss.getSortActivite());
               this.reglements.setRglBanqueTireur(this.bonSortieCaiss.getSortBanqueTireur());
               this.reglements.setRglBudget(this.bonSortieCaiss.getSortBudget());
               this.reglements.setRglBon(this.bonSortieCaiss.getSortNum());
               this.reglements.setRglCategorie(this.bonSortieCaiss.getSortNature());
               String[] var4;
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                  var4 = this.var_caisse.split(":");
                  this.reglements.setRglCodeCaiss(var4[0]);
                  this.reglements.setRglLibCaiss(var4[1]);
               } else {
                  this.reglements.setRglCodeCaiss((String)null);
                  this.reglements.setRglLibCaiss((String)null);
               }

               if (this.var_banque != null && !this.var_banque.isEmpty() && this.var_banque.contains(":")) {
                  var4 = this.var_banque.split(":");
                  this.reglements.setRglCodeEmetrice(var4[0]);
               } else {
                  this.reglements.setRglCodeEmetrice(this.bonSortieCaiss.getSortCodeBanq());
               }

               this.reglements.setRglCodeReceptrice((String)null);
               this.reglements.setRglCodePosteTreso(this.bonSortieCaiss.getSortCodePosteTreso());
               this.reglements.setRglCodeBudgetTreso(this.bonSortieCaiss.getSortCodeBudgetTreso());
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepartement(this.bonSortieCaiss.getSortDepartement());
               this.reglements.setRglDepense(this.bonSortieCaiss.getSortMontant());
               if (this.bonSortieCaiss.getSortDevise() != null && !this.bonSortieCaiss.getSortDevise().isEmpty()) {
                  this.reglements.setRglDevise(this.bonSortieCaiss.getSortDevise());
               } else {
                  this.reglements.setRglDevise(this.structureLog.getStrdevise());
               }

               this.reglements.setRglDossier(this.bonSortieCaiss.getSortDossier());
               this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
               this.reglements.setRglDocument("");
               this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
               this.reglements.setRglIdBon(this.bonSortieCaiss.getSortId());
               this.reglements.setRglIdDocument(0L);
               this.reglements.setRglIdTiers(this.bonSortieCaiss.getSortIdTiers());
               if (this.var_banque != null && !this.var_banque.isEmpty() && this.var_banque.contains(":")) {
                  var4 = this.var_banque.split(":");
                  this.reglements.setRglLibEmetrice(var4[1]);
               } else {
                  this.reglements.setRglLibEmetrice(this.bonSortieCaiss.getSortLibBanq());
               }

               this.reglements.setRglLibReceptrice((String)null);
               if (this.reglements.getRglDepotTiers() == 1) {
                  this.reglements.setRglLibelle("(déposit)" + this.bonSortieCaiss.getSortLibelle());
                  this.reglements.setRglObjet("(déposit)");
               } else {
                  this.reglements.setRglLibelle(this.bonSortieCaiss.getSortLibelle());
                  this.reglements.setRglObjet("");
               }

               this.reglements.setRglMode(this.var_modeReglement);
               this.reglements.setRglModele(this.bonSortieCaiss.getSortModeleImp());
               this.reglements.setRglNumChqBdx(this.bonSortieCaiss.getSortNumChqBdx());
               this.reglements.setRglNatureDoc(0);
               this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
               this.reglements.setRglNomTiers(this.bonSortieCaiss.getSortNomTiers());
               this.reglements.setRglNum(var3);
               this.reglements.setRglParc(this.bonSortieCaiss.getSortParc());
               this.reglements.setRglPdv(this.bonSortieCaiss.getSortPdv());
               this.reglements.setRglRecette(0.0D);
               this.reglements.setRglTimbre(0.0D);
               this.reglements.setRglRegion(this.bonSortieCaiss.getSortRegion());
               this.reglements.setRglSecteur(this.bonSortieCaiss.getSortSecteur());
               this.reglements.setRglSerie(this.bonSortieCaiss.getSortSerie());
               this.reglements.setRglService(this.bonSortieCaiss.getSortService());
               this.reglements.setRglSite(this.bonSortieCaiss.getSortSite());
               this.reglements.setRglSource(this.bonSortieCaiss.getSortSource());
               this.reglements.setRglCle1Repartition(this.bonSortieCaiss.getSortCle1Repartition());
               this.reglements.setRglCle2Repartition(this.bonSortieCaiss.getSortCle2Repartition());
               this.reglements.setRglTrf(0);
               this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
               this.reglements.setRglTypeTiers(this.bonSortieCaiss.getSortTypeTiers());
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
               this.reglements.setRglUserModif(0L);
               if (this.bonSortieCaiss.getSortIdResponsable() != 0L) {
                  this.reglements.setRglIdResponsable(this.bonSortieCaiss.getSortIdResponsable());
                  this.reglements.setRglNomResponsable(this.bonSortieCaiss.getSortNomResponsable());
               } else {
                  this.reglements.setRglIdResponsable(this.bonSortieCaiss.getSortUserCreat());
                  new Users();
                  UserDao var5 = new UserDao(this.baseLog, this.utilInitHibernate);
                  Users var15 = var5.selectByIdUsers(this.bonSortieCaiss.getSortUserCreat(), var1);
                  if (var15 != null) {
                     this.reglements.setRglNomResponsable(var15.getUsrPatronyme());
                  }
               }

               this.reglements.setRglIdCommercial(0L);
               this.reglements.setRglNomCommercial((String)null);
               this.reglements.setRglIdEquipe(0L);
               this.reglements.setRglNomEquipe((String)null);
               String var16 = "";
               if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                  var16 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
               } else {
                  var16 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
               }

               String var17 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
               this.reglements.setRglPeriode(var16 + ":" + var17);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               String var6 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var6);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var6);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglements = this.reglementsDao.insert(this.reglements, var1);
               if (this.bonSortieCaiss != null) {
                  this.bonSortieCaiss.setSortEtat(4);
                  this.bonSortieCaiss.setSortDateModif(new Date());
                  this.bonSortieCaiss.setSortUserModif(this.usersLog.getUsrid());
                  this.bonSortieCaiss = this.bonSortieCaissDao.modif(this.bonSortieCaiss, var1);
               }

               if (this.bonSortieCaiss.getSortDepotTiers() == 1 && (this.bonSortieCaiss.getSortTypeTiers() == 0 || this.bonSortieCaiss.getSortTypeTiers() == 1)) {
                  this.tiers = new Tiers();
                  TiersDao var7 = new TiersDao(this.baseLog, this.utilInitHibernate);
                  this.tiers = var7.selectTierD(this.bonSortieCaiss.getSortIdTiers(), var1);
                  double var8 = this.tiers.getTiedepotavance() - this.bonSortieCaiss.getSortMontant();
                  this.tiers.setTiedepotavance(var8);
                  var7.modif(this.tiers, var1);
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
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
      }

   }

   public void casBonEntree() throws HibernateException, NamingException {
      if (this.bonEntreCaiss != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeCaiss");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.chargerCaisse(var1);
            this.reglements.setRglDateReg(this.bonEntreCaiss.getEntrDate());
            if (this.reglements.getRglDateReg() == null) {
               this.reglements.setRglDateReg(new Date());
            }

            String var3 = "";
            if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
               this.var_modeReglement = "0";
            }

            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var3 = this.calculChrono.numCompose(this.reglements.getRglDateReg(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var1);
            } else {
               var3 = this.calculChrono.numCompose(this.reglements.getRglDateReg(), this.natCaisse, this.serieCaisse, var1);
            }

            if (var3 != null && !var3.isEmpty()) {
               this.reglements.setRglOperation("10");
               this.reglements.setRglActivite(this.bonEntreCaiss.getEntrActivite());
               this.reglements.setRglBanqueTireur(this.bonEntreCaiss.getEntrBanqueTireur());
               this.reglements.setRglBudget(this.bonEntreCaiss.getEntrBudget());
               this.reglements.setRglBon(this.bonEntreCaiss.getEntrNum());
               this.reglements.setRglCategorie(this.bonEntreCaiss.getEntrNature());
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                  String[] var4 = this.var_caisse.split(":");
                  this.reglements.setRglCodeCaiss(var4[0]);
                  this.reglements.setRglLibCaiss(var4[1]);
               } else {
                  this.reglements.setRglCodeCaiss((String)null);
                  this.reglements.setRglLibCaiss((String)null);
               }

               this.reglements.setRglCodeEmetrice(this.bonEntreCaiss.getEntrCodeBanq());
               this.reglements.setRglCodeReceptrice((String)null);
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepartement(this.bonEntreCaiss.getEntrDepartement());
               this.reglements.setRglDepense(0.0D);
               if (this.bonEntreCaiss.getEntrDevise() != null && !this.bonEntreCaiss.getEntrDevise().isEmpty()) {
                  this.reglements.setRglDevise(this.bonEntreCaiss.getEntrDevise());
               } else {
                  this.reglements.setRglDevise(this.structureLog.getStrdevise());
               }

               this.reglements.setRglDossier("");
               this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
               this.reglements.setRglDocument("");
               this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
               this.reglements.setRglIdBon(this.bonEntreCaiss.getEntrId());
               this.reglements.setRglIdDocument(0L);
               this.reglements.setRglIdTiers(this.bonEntreCaiss.getEntrIdTiers());
               this.reglements.setRglDepotTiers(this.bonEntreCaiss.getEntrDepotTiers());
               this.reglements.setRglLibEmetrice(this.bonEntreCaiss.getEntrLibBanq());
               this.reglements.setRglLibReceptrice("");
               this.reglements.setRglLibelle(this.bonEntreCaiss.getEntrLibelle());
               this.reglements.setRglMode(this.var_modeReglement);
               this.reglements.setRglModele(this.bonEntreCaiss.getEntrModeleImp());
               this.reglements.setRglNumChqBdx(this.bonEntreCaiss.getEntrNumChqBdx());
               this.reglements.setRglNatureDoc(0);
               this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
               this.reglements.setRglNomTiers(this.bonEntreCaiss.getEntrNomTiers());
               this.reglements.setRglNum(var3);
               this.reglements.setRglObjet("");
               this.reglements.setRglParc(this.bonEntreCaiss.getEntrParc());
               this.reglements.setRglPdv(this.bonEntreCaiss.getEntrPdv());
               this.reglements.setRglRecette(this.bonEntreCaiss.getEntrMontant());
               this.reglements.setRglTimbre(0.0D);
               this.reglements.setRglRegion(this.bonEntreCaiss.getEntrRegion());
               this.reglements.setRglSecteur(this.bonEntreCaiss.getEntrSecteur());
               this.reglements.setRglSerie(this.bonEntreCaiss.getEntrSerie());
               this.reglements.setRglService(this.bonEntreCaiss.getEntrService());
               this.reglements.setRglSite(this.bonEntreCaiss.getEntrSite());
               this.reglements.setRglSource(this.bonEntreCaiss.getEntrSource());
               this.reglements.setRglTrf(0);
               this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
               this.reglements.setRglTypeTiers(this.bonEntreCaiss.getEntrTypeTiers());
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
               this.reglements.setRglUserModif(0L);
               if (this.bonEntreCaiss.getEntrIdResponsable() != 0L) {
                  this.reglements.setRglIdResponsable(this.bonEntreCaiss.getEntrIdResponsable());
                  this.reglements.setRglNomResponsable(this.bonEntreCaiss.getEntrNomResponsable());
               } else {
                  this.reglements.setRglIdResponsable(this.bonEntreCaiss.getEntrUserCreat());
                  new Users();
                  UserDao var5 = new UserDao(this.baseLog, this.utilInitHibernate);
                  Users var15 = var5.selectByIdUsers(this.bonEntreCaiss.getEntrUserCreat(), var1);
                  if (var15 != null) {
                     this.reglements.setRglNomResponsable(var15.getUsrPatronyme());
                  }
               }

               this.reglements.setRglIdCommercial(0L);
               this.reglements.setRglNomCommercial((String)null);
               this.reglements.setRglIdEquipe(0L);
               this.reglements.setRglNomEquipe((String)null);
               String var16 = "";
               if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                  var16 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
               } else {
                  var16 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
               }

               String var17 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
               this.reglements.setRglPeriode(var16 + ":" + var17);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               String var6 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var6);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var6);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglements = this.reglementsDao.insert(this.reglements, var1);
               if (this.bonEntreCaiss != null) {
                  this.bonEntreCaiss.setEntrEtat(4);
                  this.bonEntreCaiss.setEntrDateModif(new Date());
                  this.bonEntreCaiss.setEntrUserModif(this.usersLog.getUsrid());
                  this.bonEntreCaiss = this.bonEntreCaissDao.modif(this.bonEntreCaiss, var1);
               }

               if (this.bonEntreCaiss.getEntrDepotTiers() == 1 && (this.bonEntreCaiss.getEntrTypeTiers() == 0 || this.bonEntreCaiss.getEntrTypeTiers() == 1)) {
                  this.tiers = new Tiers();
                  TiersDao var7 = new TiersDao(this.baseLog, this.utilInitHibernate);
                  this.tiers = var7.selectTierD(this.bonEntreCaiss.getEntrIdTiers(), var1);
                  double var8 = this.tiers.getTiedepotavance() + this.bonEntreCaiss.getEntrMontant();
                  this.tiers.setTiedepotavance(var8);
                  var7.modif(this.tiers, var1);
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
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
      }

   }

   public void casBonVirement() throws HibernateException, NamingException {
      if (this.virementInterne != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "VirementInterne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.chargerCaisse(var1);
            this.reglements.setRglDateReg(this.virementInterne.getVirDate());
            if (this.reglements.getRglDateReg() == null) {
               this.reglements.setRglDateReg(new Date());
            }

            String var3 = "";
            if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
               this.var_modeReglement = "0";
            }

            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var3 = this.calculChrono.numCompose(this.reglements.getRglDateReg(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var1);
            } else {
               var3 = this.calculChrono.numCompose(this.reglements.getRglDateReg(), this.natCaisse, this.serieCaisse, var1);
            }

            if (var3 != null && !var3.isEmpty()) {
               JournauxComptables var4;
               if (this.var_modeReglement != null && !this.var_modeReglement.isEmpty() && this.var_modeReglement.startsWith("1")) {
                  this.reglements.setRglOperation("73");
                  this.reglements.setRglTypeReg(1);
                  if (this.virementInterne.getVirCodReceptrice() != null && !this.virementInterne.getVirCodReceptrice().isEmpty()) {
                     new JournauxComptables();
                     var4 = this.journauxComptablesDao.chercherCode(this.virementInterne.getVirCodReceptrice(), 0L, var1);
                     if (var4.getPljNature() == 7 || var4.getPljNature() == 8) {
                        this.reglements.setRglOperation("76");
                     }
                  }
               } else if (this.var_modeReglement != null && !this.var_modeReglement.isEmpty() && this.var_modeReglement.startsWith("2")) {
                  this.reglements.setRglOperation("73");
                  this.reglements.setRglTypeReg(2);
                  if (this.virementInterne.getVirCodReceptrice() != null && !this.virementInterne.getVirCodReceptrice().isEmpty()) {
                     new JournauxComptables();
                     var4 = this.journauxComptablesDao.chercherCode(this.virementInterne.getVirCodReceptrice(), 0L, var1);
                     if (var4.getPljNature() == 7 || var4.getPljNature() == 8) {
                        this.reglements.setRglOperation("74");
                     }
                  }
               } else {
                  this.reglements.setRglOperation("71");
                  this.reglements.setRglTypeReg(2);
               }

               this.reglements.setRglActivite(this.virementInterne.getVirActivite());
               this.reglements.setRglBanqueTireur("");
               this.reglements.setRglBudget(this.virementInterne.getVirBudget());
               this.reglements.setRglBon(this.virementInterne.getVirNum());
               this.reglements.setRglCategorie(this.virementInterne.getVirNature());
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                  String[] var13 = this.var_caisse.split(":");
                  this.reglements.setRglCodeCaiss(var13[0]);
                  this.reglements.setRglLibCaiss(var13[1]);
               } else {
                  this.reglements.setRglCodeCaiss((String)null);
                  this.reglements.setRglLibCaiss((String)null);
               }

               this.reglements.setRglCodeEmetrice(this.virementInterne.getVirCodEmetrice());
               this.reglements.setRglCodeReceptrice(this.virementInterne.getVirCodReceptrice());
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepartement(this.virementInterne.getVirDepartement());
               if (this.virementInterne.getVirDevise() != null && !this.virementInterne.getVirDevise().isEmpty()) {
                  this.reglements.setRglDevise(this.virementInterne.getVirDevise());
               } else {
                  this.reglements.setRglDevise(this.structureLog.getStrdevise());
               }

               this.reglements.setRglDossier("");
               this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
               this.reglements.setRglDocument("");
               this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
               this.reglements.setRglIdBon(this.virementInterne.getVirId());
               this.reglements.setRglIdDocument(0L);
               this.reglements.setRglIdTiers(0L);
               this.reglements.setRglDepotTiers(0);
               this.reglements.setRglLibEmetrice(this.virementInterne.getVirNomEmetrice());
               this.reglements.setRglLibReceptrice(this.virementInterne.getVirNomReceptrice());
               this.reglements.setRglLibelle(this.virementInterne.getVirLibelle());
               this.reglements.setRglMode(this.var_modeReglement);
               this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
               this.reglements.setRglNumChqBdx(this.virementInterne.getVirNumChqBdx());
               this.reglements.setRglNatureDoc(0);
               this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
               this.reglements.setRglNomTiers("");
               this.reglements.setRglNum(var3);
               this.reglements.setRglObjet("");
               this.reglements.setRglParc(this.virementInterne.getVirParc());
               this.reglements.setRglPdv(this.virementInterne.getVirPdv());
               if (this.reglements.getRglCodeEmetrice() != null && !this.reglements.getRglCodeEmetrice().isEmpty()) {
                  this.reglements.setRglDepense(this.virementInterne.getVirMontant());
                  this.reglements.setRglRecette(0.0D);
               } else {
                  this.reglements.setRglDepense(0.0D);
                  this.reglements.setRglRecette(this.virementInterne.getVirMontant());
               }

               this.reglements.setRglTimbre(0.0D);
               this.reglements.setRglRegion(this.virementInterne.getVirRegion());
               this.reglements.setRglSecteur(this.virementInterne.getVirSecteur());
               this.reglements.setRglSerie(this.virementInterne.getVirSerie());
               this.reglements.setRglService(this.virementInterne.getVirService());
               this.reglements.setRglSite(this.virementInterne.getVirSite());
               this.reglements.setRglTrf(0);
               this.reglements.setRglTypeTiers(0);
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
               this.reglements.setRglUserModif(0L);
               if (this.virementInterne.getVirIdResponsable() != 0L) {
                  this.reglements.setRglIdResponsable(this.virementInterne.getVirIdResponsable());
                  this.reglements.setRglNomResponsable(this.virementInterne.getVirNomResponsable());
               } else {
                  this.reglements.setRglIdResponsable(this.virementInterne.getVirUserCreat());
                  new Users();
                  UserDao var5 = new UserDao(this.baseLog, this.utilInitHibernate);
                  Users var14 = var5.selectByIdUsers(this.virementInterne.getVirUserCreat(), var1);
                  if (var14 != null) {
                     this.reglements.setRglNomResponsable(var14.getUsrPatronyme());
                  }
               }

               this.reglements.setRglIdCommercial(0L);
               this.reglements.setRglNomCommercial((String)null);
               this.reglements.setRglIdEquipe(0L);
               this.reglements.setRglNomEquipe((String)null);
               String var15 = "";
               if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                  var15 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
               } else {
                  var15 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
               }

               String var16 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
               this.reglements.setRglPeriode(var15 + ":" + var16);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               String var6 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var6);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var6);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglements.setRglImp(0);
               if (this.reglements.getRglCodeCaiss() != null && !this.reglements.getRglCodeCaiss().isEmpty() && this.reglements.getRglCodeReceptrice() != null && !this.reglements.getRglCodeReceptrice().isEmpty() && (this.reglements.getRglCodeEmetrice() == null || this.reglements.getRglCodeEmetrice().isEmpty())) {
                  new JournauxComptables();
                  JournauxComptables var7 = this.journauxComptablesDao.chercherCode(this.reglements.getRglCodeReceptrice(), 0L, var1);
                  if (var7.getPljNature() != 7 && var7.getPljNature() == 8) {
                  }
               }

               this.reglements = this.reglementsDao.insert(this.reglements, var1);
               if (this.virementInterne != null) {
                  this.virementInterne.setVirEtat(4);
                  this.virementInterne.setVirDateModif(new Date());
                  this.virementInterne.setVirUserModif(this.usersLog.getUsrid());
                  this.virementInterne = this.virementInterneDao.modif(this.virementInterne, var1);
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
            }

            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void casOrdrePaiement() {
   }

   public void casBonPatient() throws HibernateException, NamingException, ParseException {
      if (this.bonEncaissementVente != null && this.bonEncaissementVente.getBonEtat() == 0) {
         if (this.bonEncaissementVente.getBonEncaisse() == 0.0D) {
            this.bonEncaissementVente.setBonEncaisse(this.bonEncaissementVente.getBonAPayer());
         }

         double var1 = 0.0D;
         double var3 = 0.0D;
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementMedical");
         Transaction var6 = null;

         try {
            var6 = var5.beginTransaction();
            this.chargerCaisse(var5);
            String var7 = "";
            if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
               this.var_modeReglement = "0";
            }

            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.var_modeReglement, this.serieCaisse, this.var_caisse, var5);
            } else if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("2")) {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.serieCaisse, this.var_caisse, var5);
            } else {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.serieCaisse, this.var_caisse, var5);
            }

            if (var7 != null && !var7.isEmpty()) {
               this.var_timbre = 0.0D;
               if (this.bonEncaissementVente.isBonGarde()) {
                  var1 = this.bonEncaissementVente.getBonAPayer() - this.var_timbre;
               } else {
                  var1 = this.bonEncaissementVente.getBonEncaisse() - this.var_timbre;
               }

               String var8 = "";
               String var9 = "";
               String var10 = "";
               this.reglements = new Reglements();
               this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
               if (this.reglements.getRglDateReg() == null) {
                  this.reglements.setRglDateReg(new Date());
               }

               int var18;
               if (this.structureLog.getStrQuart1DebutHeure() != null && !this.structureLog.getStrQuart1DebutHeure().isEmpty()) {
                  int var11 = this.reglements.getRglDateReg().getHours();
                  int var12 = this.reglements.getRglDateReg().getMinutes();
                  int var13 = Integer.parseInt(this.structureLog.getStrQuart1DebutHeure());
                  int var14 = Integer.parseInt(this.structureLog.getStrQuart1DebutMinute());
                  int var15 = Integer.parseInt(this.structureLog.getStrQuart1FinHeure());
                  int var16 = Integer.parseInt(this.structureLog.getStrQuart1FinMinute());
                  int var17 = Integer.parseInt(this.structureLog.getStrQuart2FinHeure());
                  var18 = Integer.parseInt(this.structureLog.getStrQuart2FinMinute());
                  int var19 = Integer.parseInt(this.structureLog.getStrQuart3FinHeure());
                  int var20 = Integer.parseInt(this.structureLog.getStrQuart3FinMinute());
                  if (var11 >= var13 && var11 <= var15 && var12 >= var14 && var12 <= var16) {
                     this.reglements.setRglQuart("1");
                     this.reglements.setRglDateRegQuart(this.reglements.getRglDateReg());
                  } else if (var11 >= var15 && var11 <= var17 && var12 >= var16 && var12 <= var18) {
                     this.reglements.setRglQuart("2");
                     this.reglements.setRglDateRegQuart(this.reglements.getRglDateReg());
                  } else if (var11 >= var17 && var11 <= var19 && var12 >= var18 && var12 <= var20) {
                     this.reglements.setRglQuart("3");
                     if (var12 >= 0 && var12 <= var20) {
                        this.reglements.setRglDateRegQuart(this.utilDate.dateJourPrecedent(this.reglements.getRglDateReg()));
                     } else {
                        this.reglements.setRglDateRegQuart(this.reglements.getRglDateReg());
                     }
                  }
               } else {
                  this.reglements.setRglDateRegQuart((Date)null);
                  this.reglements.setRglQuart("");
               }

               this.reglements.setRglOperation("01");
               this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
               this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
               this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
               this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
               this.reglements.setRglCategorie(30);
               String[] var29;
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                  var29 = this.var_caisse.split(":");
                  this.reglements.setRglCodeCaiss(var29[0]);
                  this.reglements.setRglLibCaiss(var29[1]);
               } else {
                  this.reglements.setRglCodeCaiss((String)null);
                  this.reglements.setRglLibCaiss((String)null);
               }

               if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                  var29 = this.inputBanq.split(":");
                  this.reglements.setRglCodeEmetrice(var29[0]);
                  this.reglements.setRglLibEmetrice(var29[1]);
               } else {
                  this.reglements.setRglCodeEmetrice((String)null);
                  this.reglements.setRglLibEmetrice((String)null);
               }

               this.reglements.setRglCodeReceptrice((String)null);
               this.reglements.setRglLibReceptrice((String)null);
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateRemise(this.bonEncaissementVente.getBonDateRemise());
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepartement(this.bonEncaissementVente.getBonActivite());
               this.reglements.setRglDepense(0.0D);
               if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                  this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
               } else {
                  this.reglements.setRglDevise(this.structureLog.getStrdevise());
               }

               this.reglements.setRglDossier("");
               this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
               this.reglements.setRglDocument(this.bonEncaissementVente.getBonRef());
               this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
               this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
               this.reglements.setRglIdDocument(this.bonEncaissementVente.getBonIdRef());
               this.reglements.setRglIdTiers(this.bonEncaissementVente.getBonIdTiers());
               this.reglements.setRglDepotTiers(0);
               this.reglements.setRglLibelle(this.bonEncaissementVente.getBonObject());
               this.reglements.setRglMode(this.var_modeReglement);
               this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
               if (this.bonEncaissementVente.getBonLettreGarantie() != null && !this.bonEncaissementVente.getBonLettreGarantie().isEmpty()) {
                  this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonLettreGarantie());
               } else {
                  this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
               }

               this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
               this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
               this.reglements.setRglNomTiers(this.bonEncaissementVente.getBonNomTiers());
               this.reglements.setRglIdContact(this.bonEncaissementVente.getBonIdContact());
               this.reglements.setRglNomContact(this.bonEncaissementVente.getBonNomContact());
               this.reglements.setRglNum(var7);
               this.reglements.setRglObjet(this.bonEncaissementVente.getBonObject());
               this.reglements.setRglParc("");
               this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
               this.reglements.setRglRecette(var1);
               this.reglements.setRglRendu(this.bonEncaissementVente.getBonRendu());
               this.reglements.setRglTimbre(this.var_timbre);
               this.reglements.setRglRegion("");
               this.reglements.setRglSecteur("");
               this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
               this.reglements.setRglService(this.bonEncaissementVente.getBonService());
               this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
               this.reglements.setRglTrf(0);
               this.reglements.setRglTypeReg(this.bonCaisse.getBonCaisTypeReg());
               this.reglements.setRglTypeTiers(4);
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
               this.reglements.setRglUserModif(0L);
               this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
               this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
               this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
               this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
               this.reglements.setRglIdEquipe(0L);
               this.reglements.setRglNomEquipe("");
               if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                  var8 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
               } else {
                  var8 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
               }

               var9 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
               this.reglements.setRglPeriode(var8 + ":" + var9);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               var10 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var10);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var10);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglements = this.reglementsDao.insert(this.reglements, var5);
               long var30 = this.reglements.getRglId();
               if (this.bonEncaissementVente.getBonNatRef() != 76 && this.bonEncaissementVente.getBonAPayerReliquat() != 0.0D) {
                  this.reglements = new Reglements();
                  this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                  if (this.reglements.getRglDateReg() == null) {
                     this.reglements.setRglDateReg(new Date());
                  }

                  this.reglements.setRglOperation("01");
                  this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                  this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                  this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                  this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                  this.reglements.setRglCategorie(30);
                  String[] var31;
                  if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                     var31 = this.var_caisse.split(":");
                     this.reglements.setRglCodeCaiss(var31[0]);
                     this.reglements.setRglLibCaiss(var31[1]);
                  } else {
                     this.reglements.setRglCodeCaiss((String)null);
                     this.reglements.setRglLibCaiss((String)null);
                  }

                  if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                     var31 = this.inputBanq.split(":");
                     this.reglements.setRglCodeEmetrice(var31[0]);
                     this.reglements.setRglLibEmetrice(var31[1]);
                  } else {
                     this.reglements.setRglCodeEmetrice((String)null);
                     this.reglements.setRglLibEmetrice((String)null);
                  }

                  this.reglements.setRglCodeReceptrice((String)null);
                  this.reglements.setRglLibReceptrice((String)null);
                  this.reglements.setRglDateCreation(new Date());
                  this.reglements.setRglDateImp((Date)null);
                  this.reglements.setRglDateTransfert((Date)null);
                  this.reglements.setRglDateRemise(this.bonEncaissementVente.getBonDateRemise());
                  this.reglements.setRglDateValeur((Date)null);
                  this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                  this.reglements.setRglDepense(0.0D);
                  if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                     this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                  } else {
                     this.reglements.setRglDevise(this.structureLog.getStrdevise());
                  }

                  this.reglements.setRglDossier("");
                  this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                  this.reglements.setRglDocument(this.bonEncaissementVente.getBonRef());
                  this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                  this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                  this.reglements.setRglIdDocument(this.bonEncaissementVente.getBonIdRef());
                  this.reglements.setRglIdTiers(this.bonEncaissementVente.getBonIdTiers());
                  this.reglements.setRglDepotTiers(0);
                  this.reglements.setRglLibelle(this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglMode(this.var_modeReglement);
                  this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                  this.reglements.setRglNumChqBdx("");
                  this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                  this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                  this.reglements.setRglNomTiers(this.bonEncaissementVente.getBonNomTiers());
                  this.reglements.setRglIdContact(this.bonEncaissementVente.getBonIdContact());
                  this.reglements.setRglNomContact(this.bonEncaissementVente.getBonNomContact());
                  this.reglements.setRglNum(var7);
                  this.reglements.setRglObjet(this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglParc("");
                  this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                  this.reglements.setRglRecette(this.bonEncaissementVente.getBonAPayerReliquat());
                  this.reglements.setRglRendu(0.0D);
                  this.reglements.setRglTimbre(this.var_timbre);
                  this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                  this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                  this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                  this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                  this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                  this.reglements.setRglTrf(0);
                  this.reglements.setRglTypeReg(this.bonCaisse.getBonCaisTypeReg());
                  this.reglements.setRglTypeTiers(4);
                  this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                  this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                  this.reglements.setRglUserModif(0L);
                  this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                  this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                  this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                  this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                  this.reglements.setRglIdEquipe(0L);
                  this.reglements.setRglNomEquipe("");
                  if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                     var8 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                  } else {
                     var8 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                  }

                  var9 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                  this.reglements.setRglPeriode(var8 + ":" + var9);
                  this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                  var10 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                  this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var10);
                  this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                  this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var10);
                  this.reglements.setExercicesCaisse(this.selectedExo);
                  this.reglements = this.reglementsDao.insert(this.reglements, var5);
               }

               if (this.bonEncaissementVente.getBonLettreGarantie() != null && !this.bonEncaissementVente.getBonLettreGarantie().isEmpty()) {
                  new PatientLettreGarantie();
                  PatientLettreGarantieDao var33 = new PatientLettreGarantieDao(this.baseLog, this.utilInitHibernate);
                  PatientLettreGarantie var32 = var33.trouverLettreGarantie(this.bonEncaissementVente.getBonLettreGarantie(), 0, var5);
                  if (var32 != null) {
                     var32.setPatlgaConsomme(var32.getPatlgaConsomme() + var1);
                     var32.setPatlgaSolde(var32.getPatlgaMontant() - var32.getPatlgaConsomme());
                     var33.modif(var32, var5);
                  }
               }

               if (this.bonEncaissementVente.getBonIdEquipe() != 0L) {
                  new HospitalisationCaution();
                  HospitalisationCautionDao var35 = new HospitalisationCautionDao(this.baseLog, this.utilInitHibernate);
                  HospitalisationCaution var34 = var35.selectReglement(this.bonEncaissementVente.getBonIdEquipe(), var5);
                  if (var34 != null) {
                     var34.setHoscauIdBonEncaissement(this.bonEncaissementVente.getBonId());
                     var34.setHoscauIdRecu(this.reglements.getRglId());
                     var34.setHoscauNumRecu(this.reglements.getRglNum());
                     var34.setHoscauEtat(1);
                     var35.modif(var34, var5);
                  }
               }

               if (this.bonEncaissementVente != null) {
                  int var23;
                  List var45;
                  ArrayList var47;
                  double var58;
                  double var64;
                  int var68;
                  String[] var70;
                  if (this.bonEncaissementVente.getBonIdRef() != 0L && this.bonEncaissementVente.getBonNatRef() == 71) {
                     new ConsultationEnteteGene();
                     ConsultationEnteteGeneDao var44 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
                     ConsultationEnteteGene var42 = var44.selectById(this.bonEncaissementVente.getBonIdRef(), var5);
                     if (var42 != null) {
                        var42.setCsgRegPatient(var42.getCsgRegPatient() + var1);
                        if (var42.getCsgRegPatient() >= var42.getTotalPatient()) {
                           var42.setCsgSoldePatient(1);
                           var42.setCsgNumPieceTiers("");
                        } else {
                           var42.setCsgSoldePatient(0);
                        }

                        var44.modif(var42, var5);
                        new ArrayList();
                        var47 = new ArrayList();
                        ConsultationActesDao var52 = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
                        var45 = var52.selectConsActesByConsEnt(var42, var5);
                        if (var45.size() != 0) {
                           new ConsultationActes();
                           var58 = this.bonEncaissementVente.getBonAPayer();
                           var64 = 0.0D;

                           for(var23 = 0; var23 < var45.size(); ++var23) {
                              ConsultationActes var62 = (ConsultationActes)var45.get(var23);
                              if (var62.getCslactPatientHt() + var62.getCslactPatientTaxe() - var62.getCslactRegPatient() != 0.0D) {
                                 if (var62.getCslactPatientHt() + var62.getCslactPatientTaxe() <= var58) {
                                    var62.setCslactRegPatient(var62.getCslactPatientHt() + var62.getCslactPatientTaxe());
                                    var64 = var62.getCslactRegPatient();
                                 } else {
                                    var62.setCslactRegPatient(var58);
                                    var64 = var58;
                                 }

                                 var58 -= var62.getCslactRegPatient();
                                 if (var58 < 0.0D) {
                                    var58 = 0.0D;
                                 }

                                 var62 = var52.modif(var62, var5);
                                 var62.setNouveauPaiement(var64);
                                 var47.add(var62);
                              }
                           }
                        }

                        if (var47.size() != 0) {
                           ConsultationReglementDao var67 = new ConsultationReglementDao(this.baseLog, this.utilInitHibernate);
                           new ConsultationReglement();
                           new ConsultationActes();

                           for(var68 = 0; var68 < var47.size(); ++var68) {
                              ConsultationActes var65 = (ConsultationActes)var47.get(var68);
                              ConsultationReglement var71 = new ConsultationReglement();
                              if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                                 var70 = this.var_caisse.split(":");
                                 var71.setCsgregCaisse(var70[0]);
                              } else {
                                 var71.setCsgregCaisse("");
                              }

                              var71.setCsgregEtat(1);
                              if (this.bonEncaissementVente.getBonDate() == null) {
                                 this.bonEncaissementVente.setBonDate(new Date());
                              }

                              var71.setCsgregDate(this.bonEncaissementVente.getBonDate());
                              var71.setCsgregNumRecu(var7);
                              var71.setCsgregIdRecu(var30);
                              var71.setConsultationEnteteGene(var42);
                              var71.setCsgregIdBonEncaissement(0L);
                              var71.setCsgregLibelle(var65.getCslactLibelle());
                              var71.setCsgregPatient(var65.getNouveauPaiement());
                              var71.setCsgregProduit(var65.getCslactProduit());
                              var71.setCsgregService(var65.getConsultationEnteteGene().getCsgService());
                              var71.setCsgregNumPieceTiers(var65.getConsultationEnteteGene().getCsgNumPieceTiers());
                              var67.insert(var71, var5);
                           }
                        }
                     }
                  } else if (this.bonEncaissementVente.getBonIdRef() != 0L && this.bonEncaissementVente.getBonNatRef() == 73) {
                     new PharmacieEntete();
                     PharmacieEnteteDao var43 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
                     PharmacieEntete var39 = var43.selectById(this.bonEncaissementVente.getBonIdRef(), var5);
                     if (var39 != null) {
                        var39.setPhaRegPatient(var39.getPhaRegPatient() + var1);
                        if (var39.getPhaRegPatient() >= var39.getTotalPatient()) {
                           var39.setPhaSoldePatient(1);
                           var39.setPhaNumPieceTiers("");
                        } else {
                           var39.setPhaSoldePatient(0);
                        }

                        var43.modif(var39, var5);
                        new ArrayList();
                        var47 = new ArrayList();
                        PharmacieLigneDao var51 = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
                        var45 = var51.selectConsActesByConsEnt(var39, var5);
                        if (var45.size() != 0) {
                           new PharmacieLigne();
                           var58 = this.bonEncaissementVente.getBonAPayer();
                           var64 = 0.0D;

                           for(var23 = 0; var23 < var45.size(); ++var23) {
                              PharmacieLigne var56 = (PharmacieLigne)var45.get(var23);
                              if (var56.getPhaligPatientHt() + var56.getPhaligPatientTaxe() - var56.getPhaligRegPatient() != 0.0D) {
                                 if (var56.getPhaligPatientHt() + var56.getPhaligPatientTaxe() <= var58) {
                                    var56.setPhaligRegPatient(var56.getPhaligPatientHt() + var56.getPhaligPatientTaxe());
                                    var64 = var56.getPhaligRegPatient();
                                 } else {
                                    var56.setPhaligRegPatient(var58);
                                    var64 = var58;
                                 }

                                 var58 -= var56.getPhaligRegPatient();
                                 if (var58 < 0.0D) {
                                    var58 = 0.0D;
                                 }

                                 var56 = var51.modif(var56, var5);
                                 var56.setNouveauPaiement(var64);
                                 var47.add(var56);
                              }
                           }
                        }

                        if (var47.size() != 0) {
                           PharmacieReglementDao var60 = new PharmacieReglementDao(this.baseLog, this.utilInitHibernate);
                           new PharmacieReglement();
                           new PharmacieLigne();

                           for(var68 = 0; var68 < var47.size(); ++var68) {
                              PharmacieLigne var63 = (PharmacieLigne)var47.get(var68);
                              PharmacieReglement var69 = new PharmacieReglement();
                              if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                                 var70 = this.var_caisse.split(":");
                                 var69.setPharegCaisse(var70[0]);
                              } else {
                                 var69.setPharegCaisse("");
                              }

                              var69.setPharegEtat(1);
                              if (this.bonEncaissementVente.getBonDate() == null) {
                                 this.bonEncaissementVente.setBonDate(new Date());
                              }

                              var69.setPharegDate(this.bonEncaissementVente.getBonDate());
                              var69.setPharegNumRecu(var7);
                              var69.setPharegIdRecu(var30);
                              var69.setPharmacieEntete(var39);
                              var69.setPharegIdBonEncaissement(0L);
                              var69.setPharegLibelle(var63.getPhaligLibelle());
                              var69.setPharegPatient(var63.getNouveauPaiement());
                              var69.setPharegProduit(var63.getPhaligProduit());
                              var69.setPharegService(var63.getPharmacieEntete().getPhaPharmacie());
                              var69.setPharegNumPieceTiers(var63.getPharmacieEntete().getPhaNumPieceTiers());
                              var60.insert(var69, var5);
                           }
                        }
                     }
                  } else if (this.bonEncaissementVente.getBonIdRef() != 0L && this.bonEncaissementVente.getBonNatRef() == 74) {
                     new LaboratoireEntete();
                     LaboratoireEnteteDao var40 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
                     LaboratoireEntete var37 = var40.selectById(this.bonEncaissementVente.getBonIdRef(), var5);
                     if (var37 != null) {
                        var37.setLabRegPatient(var37.getLabRegPatient() + var1);
                        if (var37.getLabRegPatient() >= var37.getTotalPatient()) {
                           var37.setLabSoldePatient(1);
                           var37.setLabNumPieceTiers("");
                        } else {
                           var37.setLabSoldePatient(0);
                        }

                        var40.modif(var37, var5);
                        new ArrayList();
                        var47 = new ArrayList();
                        LaboratoireLigneDao var50 = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
                        var45 = var50.selectConsActesByConsEnt(var37, var5);
                        if (var45.size() != 0) {
                           new LaboratoireLigne();
                           var58 = this.bonEncaissementVente.getBonAPayer();
                           var64 = 0.0D;

                           for(var23 = 0; var23 < var45.size(); ++var23) {
                              LaboratoireLigne var53 = (LaboratoireLigne)var45.get(var23);
                              if ((var53.getLabligLaboratoire() != null && !var53.getLabligLaboratoire().isEmpty() && this.reglements.getRglPdv() != null && !this.reglements.getRglPdv().isEmpty() && var53.getLabligLaboratoire().equals(this.reglements.getRglPdv()) || (var53.getLabligLaboratoire() == null || var53.getLabligLaboratoire().isEmpty()) && (this.reglements.getRglPdv() == null || this.reglements.getRglPdv().isEmpty())) && var53.getLabligPatientHt() + var53.getLabligPatientTaxe() - var53.getLabligRegPatient() != 0.0D) {
                                 if (var53.getLabligPatientHt() + var53.getLabligPatientTaxe() <= var58) {
                                    var53.setLabligRegPatient(var53.getLabligPatientHt() + var53.getLabligPatientTaxe());
                                    var64 = var53.getLabligRegPatient();
                                 } else {
                                    var53.setLabligRegPatient(var58);
                                    var64 = var58;
                                 }

                                 var58 -= var53.getLabligRegPatient();
                                 if (var58 < 0.0D) {
                                    var58 = 0.0D;
                                 }

                                 var53 = var50.modif(var53, var5);
                                 var53.setNouveauPaiement(var64);
                                 var47.add(var53);
                              }
                           }
                        }

                        if (var47.size() != 0) {
                           LaboratoireReglementDao var55 = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
                           new LaboratoireReglement();
                           new LaboratoireLigne();

                           for(var68 = 0; var68 < var47.size(); ++var68) {
                              LaboratoireLigne var61 = (LaboratoireLigne)var47.get(var68);
                              LaboratoireReglement var66 = new LaboratoireReglement();
                              if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                                 var70 = this.var_caisse.split(":");
                                 var66.setLabregCaisse(var70[0]);
                              } else {
                                 var66.setLabregCaisse("");
                              }

                              var66.setLabregEtat(1);
                              if (this.bonEncaissementVente.getBonDate() == null) {
                                 this.bonEncaissementVente.setBonDate(new Date());
                              }

                              var66.setLabregDate(this.bonEncaissementVente.getBonDate());
                              var66.setLabregNumRecu(var7);
                              var66.setLabregIdRecu(var30);
                              var66.setLaboratoireEntete(var37);
                              var66.setLabregIdBonEncaissement(0L);
                              var66.setLabregIdLaboratoire(0L);
                              if (var61.getLaboratoireEntete().getLabLaboratoire() != null && !var61.getLaboratoireEntete().getLabLaboratoire().isEmpty()) {
                                 var66.setLabregLaboratoire(var61.getLaboratoireEntete().getLabLaboratoire());
                              } else {
                                 var66.setLabregLaboratoire(var61.getLabligLaboratoire());
                              }

                              var66.setLabregLibelle(var61.getLabligLibelle());
                              var66.setLabregPatient(var61.getNouveauPaiement());
                              var66.setLabregProduit(var61.getLabligProduit());
                              var66.setLabregService(var61.getLaboratoireEntete().getLabService());
                              var66.setLabregNumPieceTiers(var61.getLaboratoireEntete().getLabNumPieceTiers());
                              var55.insert(var66, var5);
                           }
                        }
                     }
                  } else if (this.bonEncaissementVente.getBonIdRef() != 0L && this.bonEncaissementVente.getBonNatRef() == 76) {
                     new HospitalisationEntete();
                     HospitalisationEnteteDao var38 = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
                     HospitalisationEntete var36 = var38.selectById(this.bonEncaissementVente.getBonIdRef(), var5);
                     if (var36 != null) {
                        var36.setHosRegPatient(var36.getHosRegPatient() + var1);
                        if (var36.getHosRegPatient() >= var36.getTotalPatient()) {
                           var36.setHosSoldePatient(1);
                           var36.setHosNumPieceTiers("");
                        } else {
                           var36.setHosSoldePatient(0);
                        }

                        var38.modif(var36, var5);
                        new HospitalisationReglement();
                        HospitalisationReglementDao var46 = new HospitalisationReglementDao(this.baseLog, this.utilInitHibernate);
                        HospitalisationReglement var41;
                        if (this.bonEncaissementVente.getBonAPayer() < 0.0D) {
                           long var48 = 0L;
                           HospitalisationEntete var54 = new HospitalisationEntete();
                           new ArrayList();
                           HospitalisationSejourDao var21 = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
                           List var59 = var21.chargerLesMvtsHospit(this.bonEncaissementVente.getBonIdRef(), var5);
                           if (var59.size() != 0) {
                              for(int var22 = 0; var22 < var59.size(); ++var22) {
                                 var48 = ((HospitalisationSejour)var59.get(var22)).getHossejId();
                                 var54 = ((HospitalisationSejour)var59.get(var22)).getHospitalisationEntete();
                              }
                           }

                           if (var48 != 0L) {
                              var41 = new HospitalisationReglement();
                              var41.setHosregCaisse(this.bonEncaissementVente.getBonCodeCaisse());
                              if (this.bonEncaissementVente.getBonDate() == null) {
                                 this.bonEncaissementVente.setBonDate(new Date());
                              }

                              var41.setHosregDate(this.bonEncaissementVente.getBonDate());
                              var41.setHosregEtat(1);
                              var41.setHosregIdBonEncaissement(this.bonEncaissementVente.getBonId());
                              var41.setHosregIdRecu(var30);
                              var41.setHosregIdSejour(var48);
                              var41.setHosregLaboratoire("Remboursement Caution");
                              var41.setHosregNumRecu(var7);
                              var41.setHosregPatient(this.var_aPayer);
                              var41.setHosregService(this.bonEncaissementVente.getBonService());
                              var41.setHospitalisationEntete(var54);
                              var46.insert(var41, var5);
                           }
                        }

                        new ArrayList();
                        List var49 = var46.selectReglementByBonEncaissement(this.bonEncaissementVente.getBonId(), var5);
                        if (var49.size() != 0) {
                           for(var18 = 0; var18 < var49.size(); ++var18) {
                              var41 = (HospitalisationReglement)var49.get(var18);
                              if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                                 String[] var57 = this.var_caisse.split(":");
                                 var41.setHosregCaisse(var57[0]);
                              } else {
                                 var41.setHosregCaisse("");
                              }

                              var41.setHosregEtat(1);
                              if (this.bonEncaissementVente.getBonDate() == null) {
                                 this.bonEncaissementVente.setBonDate(new Date());
                              }

                              var41.setHosregDate(this.bonEncaissementVente.getBonDate());
                              var41.setHosregNumRecu(var7);
                              var41.setHosregIdRecu(var30);
                              var41.setHosregIdSejour(((HospitalisationReglement)var49.get(var18)).getHosregIdSejour());
                              var46.modif(var41, var5);
                           }
                        }
                     }
                  }

                  if (this.optionCaisses.getBonEncaissement().equals("1")) {
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var5);
                  } else {
                     this.bonEncaissementVente.setBonDateModif(new Date());
                     this.bonEncaissementVente.setBonUserModif(this.usersLog.getUsrid());
                     this.bonEncaissementVente.setBonEtat(1);
                     this.bonEncaissementVente = this.bonEncaissementVenteDao.ModifBon(this.bonEncaissementVente, var5);
                  }
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
            }

            var6.commit();
         } catch (HibernateException var27) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var27;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void casBonEleve() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null && this.bonEncaissementVente.getBonEtat() == 0) {
         if (this.bonEncaissementVente.getBonEncaisse() == 0.0D) {
            this.bonEncaissementVente.setBonEncaisse(this.bonEncaissementVente.getBonAPayer());
         }

         double var1 = 0.0D;
         double var3 = 0.0D;
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementEducation");
         Transaction var6 = null;

         try {
            var6 = var5.beginTransaction();
            this.chargerCaisse(var5);
            String var7 = "";
            if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
               this.var_modeReglement = "0";
            }

            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.var_modeReglement, this.serieCaisse, this.var_caisse, var5);
            } else if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("2")) {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.serieCaisse, this.var_caisse, var5);
            } else {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.serieCaisse, this.var_caisse, var5);
            }

            if (var7 != null && !var7.isEmpty()) {
               Reglements var8 = new Reglements();
               String var9 = "";
               String var10 = "";
               String var11 = "";
               String[] var12;
               if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":") && this.listAppelCharge.size() != 0) {
                  double var22 = 0.0D;
                  if (this.bonEncaissementVente.isBonGarde()) {
                     var22 = this.bonEncaissementVente.getBonAPayer() - this.var_timbre;
                  } else {
                     var22 = this.bonEncaissementVente.getBonEncaisse() - this.var_timbre;
                  }

                  new AppelCharge();

                  for(int var15 = 0; var15 < this.listAppelCharge.size(); ++var15) {
                     AppelCharge var14 = (AppelCharge)this.listAppelCharge.get(var15);
                     if (var22 >= var14.getAppchaTotTtc()) {
                        var1 = var14.getAppchaTotTtc();
                     } else {
                        var1 = var22;
                     }

                     if (var1 != 0.0D) {
                        var22 -= var14.getAppchaTotTtc();
                        if (this.var_timbre != 0.0D) {
                           var3 = this.calculTimbreVentes(var22, this.bonEncaissementVente.getBonDevise(), var5);
                        } else {
                           var3 = 0.0D;
                        }

                        this.reglements = new Reglements();
                        this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                        if (this.reglements.getRglDateReg() == null) {
                           this.reglements.setRglDateReg(new Date());
                        }

                        this.reglements.setRglOperation("01");
                        this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                        this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                        this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                        this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                        this.reglements.setRglCategorie(40);
                        String[] var16;
                        if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                           var16 = this.var_caisse.split(":");
                           this.reglements.setRglCodeCaiss(var16[0]);
                           this.reglements.setRglLibCaiss(var16[1]);
                        } else {
                           this.reglements.setRglCodeCaiss((String)null);
                           this.reglements.setRglLibCaiss((String)null);
                        }

                        if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                           var16 = this.inputBanq.split(":");
                           this.reglements.setRglCodeEmetrice(var16[0]);
                           this.reglements.setRglLibEmetrice(var16[1]);
                        } else {
                           this.reglements.setRglCodeEmetrice((String)null);
                           this.reglements.setRglLibEmetrice((String)null);
                        }

                        this.reglements.setRglCodeReceptrice((String)null);
                        this.reglements.setRglLibReceptrice((String)null);
                        this.reglements.setRglDateCreation(new Date());
                        this.reglements.setRglDateImp((Date)null);
                        this.reglements.setRglDateTransfert((Date)null);
                        this.reglements.setRglDateValeur((Date)null);
                        this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                        this.reglements.setRglDepense(0.0D);
                        if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                           this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                        } else {
                           this.reglements.setRglDevise(this.structureLog.getStrdevise());
                        }

                        this.reglements.setRglDossier("");
                        this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                        this.reglements.setRglDocument(var14.getAppchaNum());
                        this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                        this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                        this.reglements.setRglIdDocument(var14.getAppchaId());
                        this.reglements.setRglIdTiers(var14.getAppchaIdTiers());
                        this.reglements.setRglDepotTiers(0);
                        this.reglements.setRglLibelle(var14.getAppchaObject());
                        this.reglements.setRglMode(this.var_modeReglement);
                        this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                        this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
                        this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                        this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                        this.reglements.setRglNomTiers(var14.getAppchaNomTiers());
                        if (this.optionVentes.getDecrmtPrsChrStock() != null && this.optionVentes.getDecrmtPrsChrStock().equals("2")) {
                           this.reglements.setRglIdContact(var14.getAppchaIdContact());
                           this.reglements.setRglNomContact(var14.getAppchaNomContact());
                        } else {
                           this.reglements.setRglIdContact(0L);
                           this.reglements.setRglNomContact("");
                        }

                        this.reglements.setRglNum(var7);
                        this.reglements.setRglObjet(this.bonEncaissementVente.getBonObject());
                        this.reglements.setRglParc("");
                        this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                        this.reglements.setRglRecette(var1);
                        this.reglements.setRglRendu(0.0D);
                        this.reglements.setRglTimbre(var3);
                        this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                        this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                        this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                        this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                        this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                        this.reglements.setRglTrf(0);
                        this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
                        this.reglements.setRglTypeTiers(5);
                        this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                        this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                        this.reglements.setRglUserModif(0L);
                        this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                        this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                        this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                        this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                        this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
                        this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
                        if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                           var9 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                        } else {
                           var9 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                        }

                        var10 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                        this.reglements.setRglPeriode(var9 + ":" + var10);
                        this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                        var11 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                        this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var11);
                        this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                        this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var11);
                        this.reglements.setExercicesCaisse(this.selectedExo);
                        this.reglements = this.reglementsDao.insert(this.reglements, var5);
                     }
                  }
               } else {
                  this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                  if (this.reglements.getRglDateReg() == null) {
                     this.reglements.setRglDateReg(new Date());
                  }

                  if (this.bonEncaissementVente.isBonGarde()) {
                     var1 = this.bonEncaissementVente.getBonAPayer() - this.var_timbre;
                  } else {
                     var1 = this.bonEncaissementVente.getBonEncaisse() - this.var_timbre;
                  }

                  this.reglements.setRglOperation("01");
                  this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                  this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                  this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                  this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                  this.reglements.setRglCategorie(40);
                  if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                     var12 = this.var_caisse.split(":");
                     this.reglements.setRglCodeCaiss(var12[0]);
                     this.reglements.setRglLibCaiss(var12[1]);
                  } else {
                     this.reglements.setRglCodeCaiss((String)null);
                     this.reglements.setRglLibCaiss((String)null);
                  }

                  if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                     var12 = this.inputBanq.split(":");
                     this.reglements.setRglCodeEmetrice(var12[0]);
                     this.reglements.setRglLibEmetrice(var12[1]);
                  } else {
                     this.reglements.setRglCodeEmetrice((String)null);
                     this.reglements.setRglLibEmetrice((String)null);
                  }

                  this.reglements.setRglCodeReceptrice((String)null);
                  this.reglements.setRglLibReceptrice((String)null);
                  this.reglements.setRglDateCreation(new Date());
                  this.reglements.setRglDateImp((Date)null);
                  this.reglements.setRglDateTransfert((Date)null);
                  this.reglements.setRglDateValeur((Date)null);
                  this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                  this.reglements.setRglDepense(0.0D);
                  if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                     this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                  } else {
                     this.reglements.setRglDevise(this.structureLog.getStrdevise());
                  }

                  this.reglements.setRglDossier("");
                  this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                  this.reglements.setRglDocument(this.bonEncaissementVente.getBonRef());
                  this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                  this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                  this.reglements.setRglIdDocument(this.bonEncaissementVente.getBonIdRef());
                  this.reglements.setRglIdTiers(this.bonEncaissementVente.getBonIdTiers());
                  this.reglements.setRglDepotTiers(0);
                  this.reglements.setRglLibelle(this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglMode(this.var_modeReglement);
                  this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                  this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
                  this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                  this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                  this.reglements.setRglNomTiers(this.bonEncaissementVente.getBonNomTiers());
                  if (this.optionVentes.getDecrmtPrsChrStock() != null && this.optionVentes.getDecrmtPrsChrStock().equals("2")) {
                     this.reglements.setRglIdContact(this.bonEncaissementVente.getBonIdContact());
                     this.reglements.setRglNomContact(this.bonEncaissementVente.getBonNomContact());
                  } else {
                     this.reglements.setRglIdContact(0L);
                     this.reglements.setRglNomContact("");
                  }

                  this.reglements.setRglNum(var7);
                  this.reglements.setRglObjet(this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglParc("");
                  this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                  this.reglements.setRglRecette(var1);
                  if (!this.bonEncaissementVente.isBonGarde() && this.bonEncaissementVente.getBonRendu() != 0.0D) {
                     this.reglements.setRglRendu(this.bonEncaissementVente.getBonRendu());
                  } else {
                     this.reglements.setRglRendu(0.0D);
                  }

                  this.reglements.setRglTimbre(this.var_timbre);
                  this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                  this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                  this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                  this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                  this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                  this.reglements.setRglTrf(0);
                  this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
                  this.reglements.setRglTypeTiers(5);
                  this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                  this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                  this.reglements.setRglUserModif(0L);
                  this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                  this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                  this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                  this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                  this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
                  this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
                  if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                     var9 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                  } else {
                     var9 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                  }

                  var10 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                  this.reglements.setRglPeriode(var9 + ":" + var10);
                  this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                  var11 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                  this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var11);
                  this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                  this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var11);
                  this.reglements.setExercicesCaisse(this.selectedExo);
                  this.reglements = this.reglementsDao.insert(this.reglements, var5);
                  var8 = this.reglements;
               }

               if (this.bonEncaissementVente != null) {
                  if (this.bonEncaissementVente.getBonIdRef() != 0L && this.bonEncaissementVente.getBonNatRef() == 102) {
                     new ElevesFacture();
                     ElevesFacture var23 = this.elevesFactureDao.pourParapheur(this.bonEncaissementVente.getBonIdRef(), var5);
                     if (var23 != null) {
                        var23.setElefacReglement(var23.getElefacReglement() + var1);
                        if (var23.getElefacReglement() >= var23.getTotalTtc()) {
                           var23.setElefacSolde(1);
                        } else {
                           var23.setElefacSolde(0);
                        }

                        this.elevesFactureDao.modif(var23, var5);
                     }
                  }

                  if (this.optionCaisses.getBonEncaissement().equals("0")) {
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var5);
                  } else {
                     this.bonEncaissementVente.setBonDateModif(new Date());
                     this.bonEncaissementVente.setBonUserModif(this.usersLog.getUsrid());
                     this.bonEncaissementVente.setBonEtat(1);
                     this.bonEncaissementVente = this.bonEncaissementVenteDao.ModifBon(this.bonEncaissementVente, var5);
                  }

                  if (this.bonEncaissementVente.isBonGarde() && this.bonEncaissementVente.getBonRendu() != 0.0D) {
                     this.reglements = new Reglements();
                     this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                     if (this.reglements.getRglDateReg() == null) {
                        this.reglements.setRglDateReg(new Date());
                     }

                     this.reglements.setRglOperation("13");
                     this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                     this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                     this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                     this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                     this.reglements.setRglCategorie(40);
                     if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                        var12 = this.var_caisse.split(":");
                        this.reglements.setRglCodeCaiss(var12[0]);
                        this.reglements.setRglLibCaiss(var12[1]);
                     } else {
                        this.reglements.setRglCodeCaiss((String)null);
                        this.reglements.setRglLibCaiss((String)null);
                     }

                     this.reglements.setRglCodeEmetrice(this.bonEncaissementVente.getBonCodeBanq());
                     this.reglements.setRglCodeReceptrice("");
                     this.reglements.setRglDateCreation(new Date());
                     this.reglements.setRglDateImp((Date)null);
                     this.reglements.setRglDateTransfert((Date)null);
                     this.reglements.setRglDateValeur((Date)null);
                     this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                     this.reglements.setRglDepense(0.0D);
                     if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                        this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                     } else {
                        this.reglements.setRglDevise(this.structureLog.getStrdevise());
                     }

                     this.reglements.setRglDossier("");
                     this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                     this.reglements.setRglDocument("");
                     this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                     this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                     this.reglements.setRglIdDocument(0L);
                     this.reglements.setRglIdTiers(this.bonEncaissementVente.getBonIdTiers());
                     this.reglements.setRglDepotTiers(1);
                     this.reglements.setRglLibEmetrice(this.bonEncaissementVente.getBonLibBanq());
                     this.reglements.setRglLibReceptrice((String)null);
                     this.reglements.setRglLibelle("(déposit) " + this.bonEncaissementVente.getBonObject());
                     this.reglements.setRglMode(this.var_modeReglement);
                     this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                     this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
                     this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                     this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                     this.reglements.setRglNomTiers(this.bonEncaissementVente.getBonNomTiers());
                     this.reglements.setRglNum(var7);
                     this.reglements.setRglObjet("(déposit) " + this.bonEncaissementVente.getBonObject());
                     this.reglements.setRglParc("");
                     this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                     this.reglements.setRglRecette(this.bonEncaissementVente.getBonRendu());
                     this.reglements.setRglTimbre(0.0D);
                     this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                     this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                     this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                     this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                     this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                     this.reglements.setRglTrf(0);
                     this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                     this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                     this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                     this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                     this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
                     this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
                     this.reglements.setRglTypeReg(this.bonCaisse.getBonCaisTypeReg());
                     this.reglements.setRglTypeTiers(5);
                     this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                     this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                     this.reglements.setRglUserModif(0L);
                     this.reglements.setRglPeriode(var9 + ":" + var10);
                     this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                     this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var11);
                     this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                     this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var11);
                     this.reglements.setExercicesCaisse(this.selectedExo);
                     this.reglementsDao.insert(this.reglements, var5);
                     this.reglements = var8;
                     this.eleves = new Eleves();
                     ElevesDao var24 = new ElevesDao(this.baseLog, this.utilInitHibernate);
                     this.eleves = var24.selectElevesD(this.bonEncaissementVente.getBonIdTiers(), var5);
                     if (this.eleves != null) {
                        double var13 = this.eleves.getEleDepotAvance() + this.bonEncaissementVente.getBonRendu();
                        this.eleves.setEleDepotAvance(var13);
                        var24.modif(this.eleves, var5);
                     }
                  }
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
            }

            var6.commit();
         } catch (HibernateException var20) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var20;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void casBonSyndic() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null && this.bonEncaissementVente.getBonEtat() == 0) {
         if (this.bonEncaissementVente.getBonEncaisse() == 0.0D) {
            this.bonEncaissementVente.setBonEncaisse(this.bonEncaissementVente.getBonAPayer());
         }

         double var1 = 0.0D;
         double var3 = 0.0D;
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicAppelCharge");
         Transaction var6 = null;

         try {
            var6 = var5.beginTransaction();
            this.chargerCaisse(var5);
            String var7 = "";
            if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
               this.var_modeReglement = "0";
            }

            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.var_modeReglement, this.serieCaisse, this.var_caisse, var5);
            } else if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("2")) {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.serieCaisse, this.var_caisse, var5);
            } else {
               var7 = this.calculChrono.numComposeCaisse(this.bonEncaissementVente.getBonDate(), 61, this.serieCaisse, this.var_caisse, var5);
            }

            if (var7 != null && !var7.isEmpty()) {
               Reglements var8 = new Reglements();
               String var9 = "";
               String var10 = "";
               String var11 = "";
               String[] var12;
               AppelCharge var14;
               int var15;
               if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":") && this.listAppelCharge.size() != 0) {
                  double var26 = 0.0D;
                  if (this.bonEncaissementVente.isBonGarde()) {
                     var26 = this.bonEncaissementVente.getBonAPayer() - this.var_timbre;
                  } else {
                     var26 = this.bonEncaissementVente.getBonEncaisse() - this.var_timbre;
                  }

                  new AppelCharge();

                  for(var15 = 0; var15 < this.listAppelCharge.size(); ++var15) {
                     var14 = (AppelCharge)this.listAppelCharge.get(var15);
                     if (var26 >= var14.getAppchaTotTtc()) {
                        var1 = var14.getAppchaTotTtc();
                     } else {
                        var1 = var26;
                     }

                     if (var1 != 0.0D) {
                        var26 -= var14.getAppchaTotTtc();
                        if (this.var_timbre != 0.0D) {
                           var3 = this.calculTimbreVentes(var26, this.bonEncaissementVente.getBonDevise(), var5);
                        } else {
                           var3 = 0.0D;
                        }

                        this.reglements = new Reglements();
                        this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                        if (this.reglements.getRglDateReg() == null) {
                           this.reglements.setRglDateReg(new Date());
                        }

                        this.reglements.setRglOperation("01");
                        this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                        this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                        this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                        this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                        this.reglements.setRglCategorie(20);
                        String[] var16;
                        if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                           var16 = this.var_caisse.split(":");
                           this.reglements.setRglCodeCaiss(var16[0]);
                           this.reglements.setRglLibCaiss(var16[1]);
                        } else {
                           this.reglements.setRglCodeCaiss((String)null);
                           this.reglements.setRglLibCaiss((String)null);
                        }

                        if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                           var16 = this.inputBanq.split(":");
                           this.reglements.setRglCodeEmetrice(var16[0]);
                           this.reglements.setRglLibEmetrice(var16[1]);
                        } else {
                           this.reglements.setRglCodeEmetrice((String)null);
                           this.reglements.setRglLibEmetrice((String)null);
                        }

                        this.reglements.setRglCodeReceptrice((String)null);
                        this.reglements.setRglLibReceptrice((String)null);
                        this.reglements.setRglDateCreation(new Date());
                        this.reglements.setRglDateImp((Date)null);
                        this.reglements.setRglDateTransfert((Date)null);
                        this.reglements.setRglDateValeur((Date)null);
                        this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                        this.reglements.setRglDepense(0.0D);
                        if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                           this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                        } else {
                           this.reglements.setRglDevise(this.structureLog.getStrdevise());
                        }

                        this.reglements.setRglDossier("");
                        this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                        this.reglements.setRglDocument(var14.getAppchaNum());
                        this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                        this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                        this.reglements.setRglIdDocument(var14.getAppchaId());
                        this.reglements.setRglIdTiers(var14.getAppchaIdTiers());
                        this.reglements.setRglDepotTiers(0);
                        this.reglements.setRglLibelle(var14.getAppchaObject());
                        this.reglements.setRglMode(this.var_modeReglement);
                        this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                        this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
                        this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                        this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                        this.reglements.setRglNomTiers(var14.getAppchaNomTiers());
                        if (this.optionVentes.getDecrmtPrsChrStock() != null && this.optionVentes.getDecrmtPrsChrStock().equals("2")) {
                           this.reglements.setRglIdContact(var14.getAppchaIdContact());
                           this.reglements.setRglNomContact(var14.getAppchaNomContact());
                        } else {
                           this.reglements.setRglIdContact(0L);
                           this.reglements.setRglNomContact("");
                        }

                        this.reglements.setRglNum(var7);
                        this.reglements.setRglObjet(this.bonEncaissementVente.getBonObject());
                        this.reglements.setRglParc("");
                        this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                        this.reglements.setRglRecette(var1);
                        this.reglements.setRglRendu(0.0D);
                        this.reglements.setRglTimbre(var3);
                        this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                        this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                        this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                        this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                        this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                        this.reglements.setRglTrf(0);
                        this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
                        this.reglements.setRglTypeTiers(0);
                        this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                        this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                        this.reglements.setRglUserModif(0L);
                        this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                        this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                        this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                        this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                        this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
                        this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
                        if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                           var9 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                        } else {
                           var9 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                        }

                        var10 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                        this.reglements.setRglPeriode(var9 + ":" + var10);
                        this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                        var11 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                        this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var11);
                        this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                        this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var11);
                        this.reglements.setExercicesCaisse(this.selectedExo);
                        this.reglements = this.reglementsDao.insert(this.reglements, var5);
                     }
                  }
               } else {
                  this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                  if (this.reglements.getRglDateReg() == null) {
                     this.reglements.setRglDateReg(new Date());
                  }

                  if (this.bonEncaissementVente.isBonGarde()) {
                     var1 = this.bonEncaissementVente.getBonAPayer() - this.var_timbre;
                  } else {
                     var1 = this.bonEncaissementVente.getBonEncaisse() - this.var_timbre;
                  }

                  this.reglements.setRglOperation("01");
                  this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                  this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                  this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                  this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                  this.reglements.setRglCategorie(20);
                  if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                     var12 = this.var_caisse.split(":");
                     this.reglements.setRglCodeCaiss(var12[0]);
                     this.reglements.setRglLibCaiss(var12[1]);
                  } else {
                     this.reglements.setRglCodeCaiss((String)null);
                     this.reglements.setRglLibCaiss((String)null);
                  }

                  if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                     var12 = this.inputBanq.split(":");
                     this.reglements.setRglCodeEmetrice(var12[0]);
                     this.reglements.setRglLibEmetrice(var12[1]);
                  } else {
                     this.reglements.setRglCodeEmetrice((String)null);
                     this.reglements.setRglLibEmetrice((String)null);
                  }

                  this.reglements.setRglCodeReceptrice((String)null);
                  this.reglements.setRglLibReceptrice((String)null);
                  this.reglements.setRglDateCreation(new Date());
                  this.reglements.setRglDateImp((Date)null);
                  this.reglements.setRglDateTransfert((Date)null);
                  this.reglements.setRglDateValeur((Date)null);
                  this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                  this.reglements.setRglDepense(0.0D);
                  if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                     this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                  } else {
                     this.reglements.setRglDevise(this.structureLog.getStrdevise());
                  }

                  this.reglements.setRglDossier("");
                  this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                  this.reglements.setRglDocument(this.bonEncaissementVente.getBonRef());
                  this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                  this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                  this.reglements.setRglIdDocument(this.bonEncaissementVente.getBonIdRef());
                  this.reglements.setRglIdTiers(this.bonEncaissementVente.getBonIdTiers());
                  this.reglements.setRglDepotTiers(0);
                  this.reglements.setRglLibelle(this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglMode(this.var_modeReglement);
                  this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                  this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
                  this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                  this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                  this.reglements.setRglNomTiers(this.bonEncaissementVente.getBonNomTiers());
                  if (this.optionVentes.getDecrmtPrsChrStock() != null && this.optionVentes.getDecrmtPrsChrStock().equals("2")) {
                     this.reglements.setRglIdContact(this.bonEncaissementVente.getBonIdContact());
                     this.reglements.setRglNomContact(this.bonEncaissementVente.getBonNomContact());
                  } else {
                     this.reglements.setRglIdContact(0L);
                     this.reglements.setRglNomContact("");
                  }

                  this.reglements.setRglNum(var7);
                  this.reglements.setRglObjet(this.bonEncaissementVente.getBonObject());
                  this.reglements.setRglParc("");
                  this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                  this.reglements.setRglRecette(var1);
                  if (!this.bonEncaissementVente.isBonGarde() && this.bonEncaissementVente.getBonRendu() != 0.0D) {
                     this.reglements.setRglRendu(this.bonEncaissementVente.getBonRendu());
                  } else {
                     this.reglements.setRglRendu(0.0D);
                  }

                  this.reglements.setRglTimbre(this.var_timbre);
                  this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                  this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                  this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                  this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                  this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                  this.reglements.setRglTrf(0);
                  this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
                  this.reglements.setRglTypeTiers(0);
                  this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                  this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                  this.reglements.setRglUserModif(0L);
                  this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                  this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                  this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                  this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                  this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
                  this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
                  if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                     var9 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
                  } else {
                     var9 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
                  }

                  var10 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
                  this.reglements.setRglPeriode(var9 + ":" + var10);
                  this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                  var11 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
                  this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var11);
                  this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                  this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var11);
                  this.reglements.setExercicesCaisse(this.selectedExo);
                  this.reglements = this.reglementsDao.insert(this.reglements, var5);
                  var8 = this.reglements;
               }

               if (this.bonEncaissementVente != null) {
                  if (this.bonEncaissementVente.getBonIdRef() != 0L && this.bonEncaissementVente.getBonNatRef() == 173) {
                     new AppelCharge();
                     AppelChargeDao var28 = new AppelChargeDao(this.baseLog, this.utilInitHibernate);
                     AppelCharge var31 = var28.pourParapheur(this.bonEncaissementVente.getBonIdRef(), var5);
                     if (var31 != null) {
                        var31.setAppchaTotReglement(var31.getAppchaTotReglement() + var1);
                        if (var31.getAppchaTotReglement() >= var31.getAppchaTotTtc()) {
                           var31.setAppchaSolde(1);
                        } else {
                           var31.setAppchaSolde(0);
                        }

                        var28.modif(var31, var5);
                     }
                  } else if (this.bonEncaissementVente.getBonIdRef() == 0L && this.bonEncaissementVente.getBonNatRef() == 173) {
                     AppelChargeDao var30;
                     if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":")) {
                        var30 = new AppelChargeDao(this.baseLog, this.utilInitHibernate);
                        new ArrayList();
                        new AppelCharge();

                        for(var15 = 0; var15 < this.listAppelCharge.size(); ++var15) {
                           var14 = (AppelCharge)this.listAppelCharge.get(var15);
                           if (var14 != null) {
                              double var33 = 0.0D;
                              double var18 = 0.0D;
                              List var27 = this.reglementsDao.reglementDocument(var14.getAppchaId(), 173, var5);
                              if (var27.size() != 0) {
                                 for(int var20 = 0; var20 < var27.size(); ++var20) {
                                    var33 += ((Reglements)var27.get(var20)).getRglRecette();
                                    var18 += ((Reglements)var27.get(var20)).getRglTimbre();
                                 }
                              }

                              var14.setAppchaTotReglement(var33);
                              var14.setAppchaTotTimbre(var18);
                              if (var14.getAppchaTotReglement() >= var14.getAppchaTotTtc() + var14.getAppchaTotTimbre()) {
                                 var14.setAppchaSolde(1);
                              } else {
                                 var14.setAppchaSolde(0);
                              }

                              var14.setAppchaDateLastReg(this.reglements.getRglDateReg());
                              var30.modif(var14, var5);
                           }
                        }
                     } else if (this.bonEncaissementVente.getBonIdRef() != 0L) {
                        var30 = new AppelChargeDao(this.baseLog, this.utilInitHibernate);
                        new AppelCharge();
                        AppelCharge var13 = var30.pourParapheur(this.bonEncaissementVente.getBonIdRef(), var5);
                        if (var13 != null) {
                           var13.setAppchaTotReglement(var13.getAppchaTotReglement() + var1);
                           if (var13.getAppchaTotReglement() >= var13.getAppchaTotTtc()) {
                              var13.setAppchaSolde(1);
                           } else {
                              var13.setAppchaSolde(0);
                           }

                           var13.setAppchaDateLastReg(this.reglements.getRglDateReg());
                           var30.modif(var13, var5);
                        }
                     }
                  }

                  if (this.optionCaisses.getBonEncaissement().equals("0")) {
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var5);
                  } else {
                     this.bonEncaissementVente.setBonDateModif(new Date());
                     this.bonEncaissementVente.setBonUserModif(this.usersLog.getUsrid());
                     this.bonEncaissementVente.setBonEtat(1);
                     this.bonEncaissementVente = this.bonEncaissementVenteDao.ModifBon(this.bonEncaissementVente, var5);
                  }

                  if (this.bonEncaissementVente.isBonGarde() && this.bonEncaissementVente.getBonRendu() != 0.0D) {
                     this.reglements = new Reglements();
                     this.reglements.setRglDateReg(this.bonEncaissementVente.getBonDate());
                     if (this.reglements.getRglDateReg() == null) {
                        this.reglements.setRglDateReg(new Date());
                     }

                     this.reglements.setRglOperation("13");
                     this.reglements.setRglActivite(this.bonEncaissementVente.getBonActivite());
                     this.reglements.setRglBanqueTireur(this.bonEncaissementVente.getBonBanqueTireur());
                     this.reglements.setRglBudget(this.bonEncaissementVente.getBonBudget());
                     this.reglements.setRglBon(this.bonEncaissementVente.getBonNum());
                     this.reglements.setRglCategorie(20);
                     if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                        var12 = this.var_caisse.split(":");
                        this.reglements.setRglCodeCaiss(var12[0]);
                        this.reglements.setRglLibCaiss(var12[1]);
                     } else {
                        this.reglements.setRglCodeCaiss((String)null);
                        this.reglements.setRglLibCaiss((String)null);
                     }

                     this.reglements.setRglCodeEmetrice(this.bonEncaissementVente.getBonCodeBanq());
                     this.reglements.setRglCodeReceptrice("");
                     this.reglements.setRglDateCreation(new Date());
                     this.reglements.setRglDateImp((Date)null);
                     this.reglements.setRglDateTransfert((Date)null);
                     this.reglements.setRglDateValeur((Date)null);
                     this.reglements.setRglDepartement(this.bonEncaissementVente.getBonDepartement());
                     this.reglements.setRglDepense(0.0D);
                     if (this.bonEncaissementVente.getBonDevise() != null && !this.bonEncaissementVente.getBonDevise().isEmpty()) {
                        this.reglements.setRglDevise(this.bonEncaissementVente.getBonDevise());
                     } else {
                        this.reglements.setRglDevise(this.structureLog.getStrdevise());
                     }

                     this.reglements.setRglDossier("");
                     this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
                     this.reglements.setRglDocument("");
                     this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
                     this.reglements.setRglIdBon(this.bonEncaissementVente.getBonId());
                     this.reglements.setRglIdDocument(0L);
                     this.reglements.setRglIdTiers(this.bonEncaissementVente.getBonIdTiers());
                     this.reglements.setRglDepotTiers(1);
                     this.reglements.setRglLibEmetrice(this.bonEncaissementVente.getBonLibBanq());
                     this.reglements.setRglLibReceptrice((String)null);
                     this.reglements.setRglLibelle("(déposit) " + this.bonEncaissementVente.getBonObject());
                     this.reglements.setRglMode(this.var_modeReglement);
                     this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
                     this.reglements.setRglNumChqBdx(this.bonEncaissementVente.getBonNumChqBdx());
                     this.reglements.setRglNatureDoc(this.bonEncaissementVente.getBonNatRef());
                     this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
                     this.reglements.setRglNomTiers(this.bonEncaissementVente.getBonNomTiers());
                     this.reglements.setRglNum(var7);
                     this.reglements.setRglObjet("(déposit) " + this.bonEncaissementVente.getBonObject());
                     this.reglements.setRglParc("");
                     this.reglements.setRglPdv(this.bonEncaissementVente.getBonPdv());
                     this.reglements.setRglRecette(this.bonEncaissementVente.getBonRendu());
                     this.reglements.setRglTimbre(0.0D);
                     this.reglements.setRglRegion(this.bonEncaissementVente.getBonRegion());
                     this.reglements.setRglSecteur(this.bonEncaissementVente.getBonSecteur());
                     this.reglements.setRglSerie(this.bonEncaissementVente.getBonSerie());
                     this.reglements.setRglService(this.bonEncaissementVente.getBonService());
                     this.reglements.setRglSite(this.bonEncaissementVente.getBonSite());
                     this.reglements.setRglTrf(0);
                     this.reglements.setRglIdResponsable(this.bonEncaissementVente.getBonIdResponsable());
                     this.reglements.setRglNomResponsable(this.bonEncaissementVente.getBonNomResponsable());
                     this.reglements.setRglIdCommercial(this.bonEncaissementVente.getBonIdCommercial());
                     this.reglements.setRglNomCommercial(this.bonEncaissementVente.getBonNomCommercial());
                     this.reglements.setRglIdEquipe(this.bonEncaissementVente.getBonIdEquipe());
                     this.reglements.setRglNomEquipe(this.bonEncaissementVente.getBonNomEquipe());
                     this.reglements.setRglTypeReg(this.bonCaisse.getBonCaisTypeReg());
                     this.reglements.setRglTypeTiers(0);
                     this.reglements.setRglUserCreat(this.usersLog.getUsrid());
                     this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
                     this.reglements.setRglUserModif(0L);
                     this.reglements.setRglPeriode(var9 + ":" + var10);
                     this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
                     this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var11);
                     this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
                     this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var11);
                     this.reglements.setExercicesCaisse(this.selectedExo);
                     this.reglementsDao.insert(this.reglements, var5);
                     this.reglements = var8;
                     this.tiers = new Tiers();
                     TiersDao var32 = new TiersDao(this.baseLog, this.utilInitHibernate);
                     this.tiers = var32.selectTierD(this.bonEncaissementVente.getBonIdTiers(), var5);
                     if (this.tiers != null) {
                        double var29 = this.tiers.getTiedepotavance() + this.bonEncaissementVente.getBonRendu();
                        this.tiers.setTiedepotavance(var29);
                        var32.modif(this.tiers, var5);
                     }
                  }
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du reçu n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
            }

            var6.commit();
         } catch (HibernateException var24) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var24;
         } finally {
            this.utilInitHibernate.closeSession();
         }
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

   public double calculTimbreAchats(double var1, String var3, Session var4) throws HibernateException, NamingException {
      double var5 = 0.0D;
      if (this.var_modeReglement.equals("0")) {
         TaxesAchatsDao var7 = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
         boolean var8 = var7.timbreExist(this.exercicesAchats.getExeachId(), var4);
         if (var8) {
            int var9 = (new Date()).getYear() + 1900;
            var5 = this.utilNombre.myRoundDevise(this.utilNombre.calculTimbre(this.structureLog, var1, var9, var3, new Date()), var3);
         }
      }

      return var5;
   }

   public double calculTimbreVentes(double var1, String var3, Session var4) throws HibernateException, NamingException {
      double var5 = 0.0D;
      if (this.var_modeReglement.equals("0")) {
         boolean var7 = this.taxesVentesDao.timbreExist(this.exercicesVentes.getExevteId(), var4);
         if (var7) {
            int var8 = (new Date()).getYear() + 1900;
            var5 = this.utilNombre.myRoundDevise(this.utilNombre.calculTimbre(this.structureLog, var1, var8, var3, new Date()), var3);
         }
      }

      return var5;
   }

   public void choixCaisse() throws HibernateException, NamingException {
      this.mesModesReglementsItem.clear();
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         String[] var1 = this.var_caisse.split(":");
         this.bonCaisse.setBonCaisCodeCaiss(var1[0]);
         this.bonCaisse.setBonCaisLibCaiss(var1[1]);
         if (this.bonCaisse.getBonCaisCodeCaiss() != null && !this.bonCaisse.getBonCaisCodeCaiss().isEmpty()) {
            this.caissesCommerciales = this.caissesCommercialesDao.selectCaisseByCode(var1[0], this.selectedExo, (Session)null);
            this.calculModeReglement();
            if (this.documentImpressionItems.size() == 0) {
               this.calculeNomRep(Integer.parseInt(this.var_modeReglement), 0);
            }

            if (this.documentImpressionItems.size() != 0 && (this.var_modele == null || this.var_modele.isEmpty())) {
               this.var_modele = ((SelectItem)this.documentImpressionItems.get(0)).getLabel();
            }

            if (this.mesModesReglementsItem.size() == 0) {
               this.calculModeReglement();
            }

            if (this.var_modele != null && !this.var_modele.isEmpty()) {
               this.bonCaisse.setBonCaisModeleImp(this.var_modele);
               if (this.mesModesReglementsItem.size() != 0) {
                  this.var_valide = true;
                  if (((SelectItem)this.mesModesReglementsItem.get(0)).getLabel() != null && !((SelectItem)this.mesModesReglementsItem.get(0)).getLabel().isEmpty() && ((SelectItem)this.mesModesReglementsItem.get(0)).getLabel().contains(":")) {
                     String[] var2 = ((SelectItem)this.mesModesReglementsItem.get(0)).getLabel().split(":");
                     this.var_modeReglement = var2[0];
                     this.choixTypeReglement();
                  }
               } else {
                  this.var_valide = false;
               }
            } else {
               this.bonCaisse.setBonCaisModeleImp("");
               this.var_valide = false;
            }
         } else {
            this.caissesCommerciales = null;
            this.bonCaisse.setBonCaisCodeCaiss("");
            this.bonCaisse.setBonCaisLibCaiss("");
            this.bonCaisse.setBonCaisModeleImp("");
            this.var_valide = false;
         }
      } else {
         this.bonCaisse.setBonCaisCodeCaiss("");
         this.bonCaisse.setBonCaisLibCaiss("");
         this.bonCaisse.setBonCaisModeleImp("");
         this.var_valide = false;
      }

   }

   public void choixTypeReglement() throws HibernateException, NamingException {
      if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
         this.var_modeReglement = "0";
      }

      this.bonCaisse.setBonCaisTypeReg(Integer.parseInt(this.var_modeReglement));
      if (this.bonCaisse.getBonCaisTypeReg() != 1 && this.bonCaisse.getBonCaisTypeReg() != 2 && this.bonCaisse.getBonCaisTypeReg() != 3 && this.bonCaisse.getBonCaisTypeReg() != 4 && this.bonCaisse.getBonCaisTypeReg() != 6 && this.bonCaisse.getBonCaisTypeReg() != 7) {
         if (this.bonCaisse.getBonCaisTypeReg() == 12) {
            this.var_affiche_banque = false;
            this.var_affiche_lettreGarantie = true;
            this.var_timbre = 0.0D;
            if (this.bonCaisse.getBonCaisNature() >= 70 && this.bonCaisse.getBonCaisNature() <= 79) {
               this.bonEncaissementVente.setBonEncaisse(0.0D);
               this.bonEncaissementVente.setBonRendu(0.0D);
               this.bonEncaissementVente.setBonGarde(false);
            }
         } else {
            this.var_affiche_banque = false;
            this.var_affiche_lettreGarantie = false;
            if (this.bonCaisse.getBonCaisNature() >= 11 && this.bonCaisse.getBonCaisNature() <= 19) {
               this.var_timbre = this.calculTimbreAchats(this.bonCaisse.getBonCaisMontant(), this.bonCaisse.getBonCaisDevise(), (Session)null);
            } else if (this.bonCaisse.getBonCaisNature() >= 20 && this.bonCaisse.getBonCaisNature() <= 29) {
               this.var_timbre = this.calculTimbreVentes(this.bonCaisse.getBonCaisMontant(), this.bonCaisse.getBonCaisDevise(), (Session)null);
            } else if (this.bonCaisse.getBonCaisNature() >= 70 && this.bonCaisse.getBonCaisNature() <= 79) {
               this.var_timbre = 0.0D;
            } else if (this.bonCaisse.getBonCaisNature() >= 160 && this.bonCaisse.getBonCaisNature() <= 179) {
               this.var_timbre = this.calculTimbreVentes(this.bonCaisse.getBonCaisMontant(), this.bonCaisse.getBonCaisDevise(), (Session)null);
            } else {
               this.var_timbre = 0.0D;
            }

            this.nomRepMod = "";
         }
      } else {
         if (this.bonCaisse.getBonCaisNature() < 11 || this.bonCaisse.getBonCaisNature() > 19) {
            if (this.bonCaisse.getBonCaisNature() >= 20 && this.bonCaisse.getBonCaisNature() <= 29) {
               this.bonEncaissementVente.setBonEncaisse(0.0D);
               this.bonEncaissementVente.setBonRendu(0.0D);
               this.bonEncaissementVente.setBonGarde(false);
            } else if (this.bonCaisse.getBonCaisNature() != 62 && this.bonCaisse.getBonCaisNature() != 63 && this.bonCaisse.getBonCaisNature() != 64 && this.bonCaisse.getBonCaisNature() >= 70 && this.bonCaisse.getBonCaisNature() <= 79) {
               this.bonEncaissementVente.setBonEncaisse(0.0D);
               this.bonEncaissementVente.setBonRendu(0.0D);
               this.bonEncaissementVente.setBonGarde(false);
            }
         }

         this.var_affiche_banque = true;
         this.var_affiche_lettreGarantie = false;
         this.var_timbre = 0.0D;
      }

      this.var_aPayer = this.bonCaisse.getBonCaisMontant() + this.var_timbre;
      this.calculeNomRep(this.bonCaisse.getBonCaisTypeReg(), 0);
      if (this.var_affiche_banque) {
         if (this.caissesCommerciales.getCaiCodeBanqueDefaut() != null && !this.caissesCommerciales.getCaiCodeBanqueDefaut().isEmpty()) {
            this.inputBanq = this.caissesCommerciales.getCaiCodeBanqueDefaut() + ":" + this.caissesCommerciales.getCaiNomBanqueDefaut();
         } else {
            this.inputBanq = "";
         }
      } else {
         this.inputBanq = "";
      }

   }

   public void choixBanq() {
      if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
         String[] var1 = this.inputBanq.split(":");
         this.bonCaisse.setBonCaisCodeBanqEmetteur(var1[0]);
         this.bonCaisse.setBonCaisLibBanqEmetteur(var1[1]);
      } else {
         this.bonCaisse.setBonCaisCodeBanqEmetteur("");
         this.bonCaisse.setBonCaisLibBanqEmetteur("");
      }

   }

   public void annule() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void calculRendu() {
      double var1 = 0.0D;
      if (this.bonEncaissementVente.getBonEncaisse() != 0.0D) {
         var1 = this.bonEncaissementVente.getBonEncaisse() - this.var_aPayer;
      }

      this.bonEncaissementVente.setBonRendu(var1);
   }

   public void calculModeReglement() throws HibernateException, NamingException {
      this.mesModesReglementsItem.clear();
      if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
         this.var_modeReglement = "0";
      }

      if (this.caissesCommerciales != null) {
         if (this.caissesCommerciales.getCaiJrEspece() != null && !this.caissesCommerciales.getCaiJrEspece().isEmpty() && !this.caissesCommerciales.getCaiJrEspece().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(0, "0:Espèces"));
         }

         if (this.caissesCommerciales.getCaiJrCheque() != null && !this.caissesCommerciales.getCaiJrCheque().isEmpty() && !this.caissesCommerciales.getCaiJrCheque().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(1, "1:Chèque"));
         }

         if (this.caissesCommerciales.getCaiJrVirement() != null && !this.caissesCommerciales.getCaiJrVirement().isEmpty() && !this.caissesCommerciales.getCaiJrVirement().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(2, "2:Virement"));
         }

         if (this.caissesCommerciales.getCaiJrTraite() != null && !this.caissesCommerciales.getCaiJrTraite().isEmpty() && !this.caissesCommerciales.getCaiJrTraite().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(3, "3:Traites"));
         }

         if (this.caissesCommerciales.getCaiJrTpe() != null && !this.caissesCommerciales.getCaiJrTpe().isEmpty() && !this.caissesCommerciales.getCaiJrTpe().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(4, "4:Carte bancaire"));
         }

         if (this.caissesCommerciales.getCaiJrTransfert() != null && !this.caissesCommerciales.getCaiJrTransfert().isEmpty() && !this.caissesCommerciales.getCaiJrTransfert().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(5, "5:Transfert d`argent"));
         }

         if (this.caissesCommerciales.getCaiJrePaiement() != null && !this.caissesCommerciales.getCaiJrePaiement().isEmpty() && !this.caissesCommerciales.getCaiJrePaiement().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(6, "6:ePaiement"));
         }

         if (this.caissesCommerciales.getCaiJrCredoc() != null && !this.caissesCommerciales.getCaiJrCredoc().isEmpty() && !this.caissesCommerciales.getCaiJrCredoc().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(7, "7:Crédoc"));
         }

         if (this.caissesCommerciales.getCaiJrFactor() != null && !this.caissesCommerciales.getCaiJrFactor().isEmpty() && !this.caissesCommerciales.getCaiJrFactor().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(8, "8:Factor"));
         }

         if (this.caissesCommerciales.getCaiJrCompense() != null && !this.caissesCommerciales.getCaiJrCompense().isEmpty() && !this.caissesCommerciales.getCaiJrCompense().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(9, "9:Compense"));
         }

         if (this.caissesCommerciales.getCaiJrTerme() != null && !this.caissesCommerciales.getCaiJrTerme().isEmpty() && !this.caissesCommerciales.getCaiJrTerme().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(10, "10:Terme"));
         }

         if (this.caissesCommerciales.getCaiJrEspeceST() != null && !this.caissesCommerciales.getCaiJrEspeceST().isEmpty() && !this.caissesCommerciales.getCaiJrEspeceST().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(11, "11:Espèces sans timbre"));
         }

         if (this.caissesCommerciales.getCaiJrLettreGarantie() != null && !this.caissesCommerciales.getCaiJrLettreGarantie().isEmpty() && !this.caissesCommerciales.getCaiJrLettreGarantie().equals("100")) {
            this.mesModesReglementsItem.add(new SelectItem(12, "12:Lettre de garantie"));
         }

         if (this.caissesCommerciales.getCaiJrPrelevement() != null && !this.caissesCommerciales.getCaiJrPrelevement().isEmpty()) {
            this.mesModesReglementsItem.add(new SelectItem(13, "13:Prélèvement"));
         }

         if (this.caissesCommerciales.getCaiJrAlcoin() != null && !this.caissesCommerciales.getCaiJrAlcoin().isEmpty()) {
            this.mesModesReglementsItem.add(new SelectItem(14, "14:ALCoin"));
         }

         if (this.tiers != null && this.tiers.getTieid() != 0L && this.tiers.getTiedepotavance() != 0.0D) {
            this.mesModesReglementsItem.add(new SelectItem(90, "90:Déposit-Avance/Ristournes"));
         }

         if (this.mesModesReglementsItem.size() != 0) {
            if (this.var_modeReglement != null && !this.var_modeReglement.isEmpty() && this.var_modeReglement.equals("100")) {
               if (this.bonCaisse != null) {
                  this.var_modeReglement = "" + this.bonCaisse.getBonCaisTypeReg();
               } else if (((SelectItem)this.mesModesReglementsItem.get(0)).getLabel() != null && !((SelectItem)this.mesModesReglementsItem.get(0)).getLabel().isEmpty() && ((SelectItem)this.mesModesReglementsItem.get(0)).getLabel().contains(":")) {
                  String[] var1 = ((SelectItem)this.mesModesReglementsItem.get(0)).getLabel().split(":");
                  this.var_modeReglement = var1[0];
               }
            } else if (this.var_modeReglement != null && !this.var_modeReglement.isEmpty() && !this.var_modeReglement.equals("100") && this.bonCaisse != null) {
               this.var_modeReglement = "" + this.bonCaisse.getBonCaisTypeReg();
            }
         }
      }

   }

   public void ajoutEncaissement() throws HibernateException, NamingException {
      if (this.bonCaisse != null) {
         this.reglements = this.reglementsDao.pourParapheur(this.bonCaisse.getBonCaisId(), (Session)null);
         if (this.reglements != null) {
            this.showModalPanelEncaissement = true;
         }
      }

   }

   public void fermerEncaissement() {
      this.showModalPanelEncaissement = false;
   }

   public void validerEncaissement() throws HibernateException, NamingException {
      this.reglements = this.reglementsDao.modifier(this.reglements);
      this.showModalPanelEncaissement = false;
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

   public void calculPourcentage() {
      if (this.ecrituresAnalytiqueCtrl != null && this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
         double var1 = 0.0D;
         if (this.var_montant_recu != 0.0D) {
            var1 = this.var_montant_recu;
         } else if (this.var_total_bon != 0.0D) {
            var1 = this.var_total_bon;
         } else if (this.var_aEncaisser != 0.0D) {
            var1 = this.var_aEncaisser;
         } else if (this.var_aEncaisser != 0.0D) {
            var1 = this.var_aEncaisser;
         }

         double var3 = this.utilNombre.myRoundDevise(var1 * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
         this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(var3);
      }

   }

   public void controleEcartAnalytique() throws HibernateException, NamingException {
      this.affichageExoCompte = false;
      if (this.lesDecoupagesActivites.size() != 0) {
         this.totalImputation = 0.0D;
         this.soldeImputation = 0.0D;
         new EcrituresAnalytiqueCtrl();
         Activites var2 = new Activites();

         for(int var3 = 0; var3 < this.lesDecoupagesActivites.size(); ++var3) {
            EcrituresAnalytiqueCtrl var1 = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var3);
            this.totalImputation += var1.getEcranaMontantSaisie();
            this.calculeCompteActivite(var1, var2);
         }

         double var5 = 0.0D;
         if (this.reglements.getRglDepense() == 0.0D && this.reglements.getRglRecette() != 0.0D) {
            var5 = this.reglements.getRglRecette();
         } else {
            var5 = this.reglements.getRglDepense();
         }

         this.soldeImputation = var5 - this.totalImputation;
         if (this.soldeImputation > 0.0D) {
            this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
            this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         }
      }

   }

   public void calculeCompteActivite(EcrituresAnalytiqueCtrl var1, Activites var2) throws HibernateException, NamingException {
      this.affichageExoCompte = false;
      if (var1.getEcranaAnal3() != null && !var1.getEcranaAnal3().isEmpty()) {
         var2 = this.chercherActivite(var1.getEcranaAnal3(), var2);
         if (var2 != null && var2.getActCompteTaxe() != null && !var2.getActCompteTaxe().isEmpty()) {
            this.memoCompteTaxe = var2.getActCompteTaxe();
            this.memoTauxTaxe = var2.getActTauxTaxe();
            this.affichageExoCompte = true;
         }
      }

      if (!this.affichageExoCompte) {
         if (var1.getEcranaAnal2() != null && !var1.getEcranaAnal2().isEmpty()) {
            var2 = this.chercherActivite(var1.getEcranaAnal2(), var2);
            if (var2 != null && var2.getActCompteTaxe() != null && !var2.getActCompteTaxe().isEmpty()) {
               this.memoCompteTaxe = var2.getActCompteTaxe();
               this.memoTauxTaxe = var2.getActTauxTaxe();
               this.affichageExoCompte = true;
            }
         }

         if (!this.affichageExoCompte && var1.getEcranaAnal1() != null && !var1.getEcranaAnal1().isEmpty()) {
            var2 = this.chercherActivite(var1.getEcranaAnal1(), var2);
            if (var2 != null && var2.getActCompteTaxe() != null && !var2.getActCompteTaxe().isEmpty()) {
               this.memoCompteTaxe = var2.getActCompteTaxe();
               this.memoTauxTaxe = var2.getActTauxTaxe();
               this.affichageExoCompte = true;
            }
         }
      }

   }

   public Activites chercherActivite(String var1, Activites var2) {
      var2 = null;
      if (this.lesActivites.size() != 0) {
         for(int var3 = 0; var3 < this.lesActivites.size(); ++var3) {
            if (((Activites)this.lesActivites.get(var3)).getActCode().equals(var1)) {
               var2 = (Activites)this.lesActivites.get(var3);
               break;
            }
         }
      }

      return var2;
   }

   public void calculeMontantImputationRecette() {
      if (this.var_parc) {
         this.formAnalytique.fixeMontantImputRecette07(this.var_montant_recu);
      }

   }

   public void calculeMontantImputationDepense() {
      if (this.var_parc) {
         this.formAnalytique.fixeMontantImputRecette07(this.var_montant_recu);
      }

   }

   public void consultDocumentOrigine() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.bonCaisse != null && this.bonCaisse.getBonCaisIdOrigine() != 0L) {
         this.var_valide = false;
         this.regul = false;
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         if (this.bonCaisse.getBonCaisNature() == 12) {
            this.visuCommandeAchat();
         } else if (this.bonCaisse.getBonCaisNature() == 15) {
            this.visuFactureAchat();
         } else if (this.bonCaisse.getBonCaisNature() == 17) {
            this.visuNoteDebitAchat();
         } else if (this.bonCaisse.getBonCaisNature() == 18) {
            this.visuFraisAchat();
         } else if (this.bonCaisse.getBonCaisNature() == 21) {
            this.visuDevisVente();
         } else if (this.bonCaisse.getBonCaisNature() == 22) {
            this.visuCommandeVente();
         } else if (this.bonCaisse.getBonCaisNature() == 23) {
            this.visuLivraisonVente();
         } else if (this.bonCaisse.getBonCaisNature() == 25) {
            this.visuFactureVente();
         } else if (this.bonCaisse.getBonCaisNature() == 27) {
            this.visuNoteDebitVente();
         } else if (this.bonCaisse.getBonCaisNature() == 71 && this.inpEtat == 1) {
            this.visuConsultationRecu();
         } else if (this.bonCaisse.getBonCaisNature() == 73 && this.inpEtat == 1) {
            this.visuPharmacieRecu();
         } else if (this.bonCaisse.getBonCaisNature() == 74 && this.inpEtat == 1) {
            this.visuLaboratoireRecu();
         } else if (this.bonCaisse.getBonCaisNature() == 76 && this.inpEtat == 1) {
            this.visuHospitalisationRecu();
         } else if (this.bonCaisse.getBonCaisNature() == 71 && this.inpEtat == 2) {
            this.visuConsultationFacture();
         } else if (this.bonCaisse.getBonCaisNature() == 73 && this.inpEtat == 2) {
            this.visuPharmacieFacture();
         } else if (this.bonCaisse.getBonCaisNature() == 74 && this.inpEtat == 2) {
            this.visuLaboratoireFacture();
         } else if (this.bonCaisse.getBonCaisNature() == 76 && this.inpEtat == 2) {
            this.visuHospitalisationFacture();
         } else if (this.bonCaisse.getBonCaisNature() == 165) {
            this.visuFactureLocation();
         } else if (this.bonCaisse.getBonCaisNature() == 173) {
            this.visuFactureAppelCharge();
         }
      }

   }

   public String calculeEtatDefaut(int var1, String var2) {
      String var3 = "";
      String var4 = "";
      if (var1 == 10) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "da" + File.separator;
      } else if (var1 == 11) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "cotation" + File.separator;
      } else if (var1 == 12) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (var1 == 13) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "reception" + File.separator;
      } else if (var1 == 14) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (var1 == 15) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (var1 == 16) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (var1 == 17) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (var1 == 18) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "frais" + File.separator;
      } else if (var1 == 19) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "bon_decaissement" + File.separator;
      } else if (var1 == 35) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      } else if (var1 == 30) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "inventaire" + File.separator;
      } else if (var1 == 31) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_entree" + File.separator;
      } else if (var1 == 32) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_sortie" + File.separator;
      } else if (var1 == 33) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "cession" + File.separator;
      } else if (var1 == 34) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "production" + File.separator;
      } else if (var1 == 35) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      } else if (var1 == 36) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "sommier" + File.separator;
      } else if (var1 == 6) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "ticket" + File.separator;
      } else if (var1 == 7) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commission" + File.separator;
      } else if (var1 == 8) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "simulation" + File.separator;
      } else if (var1 == 9) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "contrat" + File.separator;
      } else if (var1 == 20) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "besoin" + File.separator;
      } else if (var1 == 21) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "devis" + File.separator;
      } else if (var1 == 22) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (var1 == 23) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "livraison" + File.separator;
      } else if (var1 == 24) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (var1 == 25) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (var1 == 26) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (var1 == 27) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (var1 == 28) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "chargement" + File.separator;
      } else if (var1 == 29) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "bon_encaissement" + File.separator;
      } else if ((var1 == 71 || var1 == 73 || var1 == 74 || var1 == 76) && this.inpEtat == 1) {
         if (this.bonCaisse.getBonCaisTypeReg() != 0 && this.bonCaisse.getBonCaisTypeReg() != 11) {
            if (this.bonCaisse.getBonCaisTypeReg() != 1 && this.bonCaisse.getBonCaisTypeReg() != 10) {
               if (this.bonCaisse.getBonCaisTypeReg() == 2) {
                  this.nomRepMod = "virements";
               } else if (this.bonCaisse.getBonCaisTypeReg() == 3) {
                  this.nomRepMod = "traites";
               } else if (this.bonCaisse.getBonCaisTypeReg() == 4) {
                  this.nomRepMod = "cartes";
               } else if (this.bonCaisse.getBonCaisTypeReg() == 5) {
                  this.nomRepMod = "transferts";
               } else if (this.bonCaisse.getBonCaisTypeReg() == 6) {
                  this.nomRepMod = "epaiements";
               } else if (this.bonCaisse.getBonCaisTypeReg() == 7) {
                  this.nomRepMod = "credocs";
               } else if (this.bonCaisse.getBonCaisTypeReg() == 8) {
                  this.nomRepMod = "factors";
               } else if (this.bonCaisse.getBonCaisTypeReg() == 9) {
                  this.nomRepMod = "compenses";
               } else if (this.bonCaisse.getBonCaisTypeReg() == 12) {
                  this.nomRepMod = "lettres_garantie";
               } else if (this.bonCaisse.getBonCaisTypeReg() == 13) {
                  this.nomRepMod = "prelevements";
               } else if (this.bonCaisse.getBonCaisTypeReg() == 14) {
                  this.nomRepMod = "alcoins";
               } else {
                  this.nomRepMod = "especes";
               }
            } else {
               this.nomRepMod = "cheques";
            }
         } else {
            this.nomRepMod = "especes";
         }

         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + this.nomRepMod + File.separator;
      } else if (var1 == 71 && this.inpEtat == 2) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "consultationGene" + File.separator;
      } else if (var1 == 73 && this.inpEtat == 2) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "pharmacie" + File.separator;
      } else if (var1 == 74 && this.inpEtat == 2) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "laboratoire" + File.separator;
      } else if (var1 == 76 && this.inpEtat == 2) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "hospitalisation" + File.separator;
      } else if (var1 == 140) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "contratVente" + File.separator;
      } else if (var1 == 141) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "campagne" + File.separator;
      } else if (var1 == 142) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture_interne" + File.separator;
      }

      File var5 = new File(var4);
      if (!var5.exists()) {
         var5.mkdir();
      }

      String[] var6 = var5.list();
      if (var6 != null) {
         var6 = this.triAlphabetique(var6, var6.length);

         int var7;
         String var8;
         for(var7 = 0; var7 < var6.length; ++var7) {
            if (var6[var7].endsWith("jasper")) {
               var8 = var6[var7].substring(0, var6[var7].indexOf("."));
               if (var2 == null || var2.isEmpty()) {
                  var3 = var8;
                  break;
               }

               if (var8.equals(var2)) {
                  var3 = var8;
                  break;
               }
            }
         }

         if (var3 == null || var3.isEmpty()) {
            for(var7 = 0; var7 < var6.length; ++var7) {
               if (var6[var7].endsWith("jasper")) {
                  var8 = var6[var7].substring(0, var6[var7].indexOf("."));
                  var3 = var8;
                  break;
               }
            }
         }
      }

      return var3;
   }

   public void visuCommandeAchat() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormCommandeAchats var1 = new FormCommandeAchats();
      new CommandeEnteteAchats();
      CommandeEnteteAchatsDao var3 = new CommandeEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      CommandeEnteteAchats var2 = var3.pourParapheur(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getCmdModeleImp() == null || var2.getCmdModeleImp().isEmpty()) {
            var2.setCmdModeleImp(this.calculeEtatDefaut(12, ""));
         }

         if (var2.getCmdModeleImp() != null && !var2.getCmdModeleImp().isEmpty()) {
            CommandeLigneAchatsDao var4 = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               String var7 = this.utilNombre.begin(var2.getCmdTotTtc() + var2.getCmdTotTc(), var2.getCmdDevise());
               this.utilPrint.setRapport(var2.getCmdModeleImp());
               this.utilPrint.setEntete("Impression commande achat");
               this.utilPrint.setMontant_lettre(var7);
               this.utilPrint.setPageGarde((String)null);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 12));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getCmdIdResponsable());
               this.utilPrint.setIdCommercial(0L);
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(12);
               this.utilPrint.setId_doc(var2.getCmdId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuFactureAchat() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormFactureAchats var1 = new FormFactureAchats();
      new FactureEnteteAchats();
      FactureEnteteAchatsDao var3 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      FactureEnteteAchats var2 = var3.pourParapheur(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getFcfModeleImp() == null || var2.getFcfModeleImp().isEmpty()) {
            var2.setFcfModeleImp(this.calculeEtatDefaut(15, ""));
         }

         if (var2.getFcfModeleImp() != null && !var2.getFcfModeleImp().isEmpty()) {
            FactureLigneAchatsDao var4 = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               String var7 = this.utilNombre.begin(var2.getFcfTotTtc() + var2.getFcfTotTc(), var2.getFcfDevise());
               this.utilPrint.setRapport(var2.getFcfModeleImp());
               this.utilPrint.setEntete("Impression facture achat");
               this.utilPrint.setMontant_lettre(var7);
               this.utilPrint.setPageGarde((String)null);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 15));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getFcfIdResponsable());
               this.utilPrint.setIdCommercial(0L);
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(15);
               this.utilPrint.setId_doc(var2.getFcfId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuNoteDebitAchat() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormNoteDebitAchats var1 = new FormNoteDebitAchats();
      new NoteDebitEnteteAchats();
      NoteDebitEnteteAchatsDao var3 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      NoteDebitEnteteAchats var2 = var3.pourParapheur(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getNdfModeleImp() == null || var2.getNdfModeleImp().isEmpty()) {
            var2.setNdfModeleImp(this.calculeEtatDefaut(17, ""));
         }

         if (var2.getNdfModeleImp() != null && !var2.getNdfModeleImp().isEmpty()) {
            NoteDebitLigneAchatsDao var4 = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               String var7 = this.utilNombre.begin(var2.getNdfTotTtc() + var2.getNdfTotTc(), var2.getNdfDevise());
               this.utilPrint.setRapport(var2.getNdfModeleImp());
               this.utilPrint.setEntete("Impression note de débit achat");
               this.utilPrint.setMontant_lettre(var7);
               this.utilPrint.setPageGarde((String)null);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 17));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getNdfIdResponsable());
               this.utilPrint.setIdCommercial(0L);
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(17);
               this.utilPrint.setId_doc(var2.getNdfId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuFraisAchat() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormFraisAchats var1 = new FormFraisAchats();
      new FraisEnteteAchats();
      FraisEnteteAchatsDao var3 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      FraisEnteteAchats var2 = var3.pourParapheur(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getFsfModeleImp() == null || var2.getFsfModeleImp().isEmpty()) {
            var2.setFsfModeleImp(this.calculeEtatDefaut(18, ""));
         }

         if (var2.getFsfModeleImp() != null && !var2.getFsfModeleImp().isEmpty()) {
            FraisLigneAchatsDao var4 = new FraisLigneAchatsDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               String var7 = this.utilNombre.begin(var2.getFsfTotTtc() + var2.getFsfTotTc(), var2.getFsfDevise());
               this.utilPrint.setRapport(var2.getFsfModeleImp());
               this.utilPrint.setEntete("Impression facture frais achat");
               this.utilPrint.setMontant_lettre(var7);
               this.utilPrint.setPageGarde((String)null);
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getFsfIdResponsable());
               this.utilPrint.setIdCommercial(0L);
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(18);
               this.utilPrint.setId_doc(var2.getFsfId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuDevisVente() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormDevisVentes var1 = new FormDevisVentes();
      new DevisEnteteVentes();
      DevisEnteteVentesDao var3 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      DevisEnteteVentes var2 = var3.pourParapheur(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getDvsModeleImp() == null || var2.getDvsModeleImp().isEmpty()) {
            var2.setDvsModeleImp(this.calculeEtatDefaut(21, ""));
         }

         if (var2.getDvsModeleImp() != null && !var2.getDvsModeleImp().isEmpty()) {
            DevisLigneVentesDao var4 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               String var7 = this.utilNombre.begin(var2.getDvsTotTtc() + var2.getDvsTotTc(), var2.getDvsDevise());
               this.utilPrint.setRapport(var2.getDvsModeleImp());
               this.utilPrint.setEntete("Impression devis");
               this.utilPrint.setMontant_lettre(var7);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 21));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getDvsIdResponsable());
               this.utilPrint.setIdCommercial(var2.getDvsIdCommercial());
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(21);
               this.utilPrint.setId_doc(var2.getDvsId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuCommandeVente() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormCommandeVentes var1 = new FormCommandeVentes();
      new CommandeEnteteVentes();
      CommandeEnteteVentes var2 = this.commandeEnteteVentesDao.pourParapheur(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getBcmModeleImp() == null || var2.getBcmModeleImp().isEmpty()) {
            var2.setBcmModeleImp(this.calculeEtatDefaut(22, ""));
         }

         if (var2.getBcmModeleImp() != null && !var2.getBcmModeleImp().isEmpty()) {
            CommandeLigneVentesDao var3 = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var4 = var3.chargerLesLignes(var2, (Session)null);
            if (var4.size() != 0) {
               JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var4);
               this.utilPrint.setjRBeanCollectionDataSource(var5);
               String var6 = this.utilNombre.begin(var2.getBcmTotTtc() + var2.getBcmTotTc(), var2.getBcmDevise());
               this.utilPrint.setRapport(var2.getBcmModeleImp());
               this.utilPrint.setEntete("Impression commande");
               this.utilPrint.setMontant_lettre(var6);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 22));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getBcmIdResponsable());
               this.utilPrint.setIdCommercial(var2.getBcmIdCommercial());
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(22);
               this.utilPrint.setId_doc(var2.getBcmId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuLivraisonVente() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormLivraisonVentes var1 = new FormLivraisonVentes();
      new LivraisonEnteteVentes();
      LivraisonEnteteVentes var2 = this.livraisonEnteteVentesDao.pourParapheur(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getBlvModeleImp() == null || var2.getBlvModeleImp().isEmpty()) {
            var2.setBlvModeleImp(this.calculeEtatDefaut(23, ""));
         }

         if (var2.getBlvModeleImp() != null && !var2.getBlvModeleImp().isEmpty()) {
            LivraisonLigneVentesDao var3 = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var4 = var3.chargerLesLignes(var2, (Session)null);
            if (var4.size() != 0) {
               JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var4);
               this.utilPrint.setjRBeanCollectionDataSource(var5);
               String var6 = this.utilNombre.begin(var2.getBlvTotTtc() + var2.getBlvTotTc(), var2.getBlvDevise());
               this.utilPrint.setRapport(var2.getBlvModeleImp());
               this.utilPrint.setEntete("Impression livraison");
               this.utilPrint.setMontant_lettre(var6);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 23));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getBlvIdResponsable());
               this.utilPrint.setIdCommercial(var2.getBlvIdCommercial());
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(23);
               this.utilPrint.setId_doc(var2.getBlvId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuFactureVente() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormFactureVentes var1 = new FormFactureVentes();
      new FactureEnteteVentes();
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      FactureEnteteVentes var2 = this.factureEnteteVentesDao.pourParapheur(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getFacModeleImp() == null || var2.getFacModeleImp().isEmpty()) {
            var2.setFacModeleImp(this.calculeEtatDefaut(25, ""));
         }

         if (var2.getFacModeleImp() != null && !var2.getFacModeleImp().isEmpty()) {
            FactureLigneVentesDao var3 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var4 = var3.chargerLesLignes(var2, (Session)null);
            if (var4.size() != 0) {
               JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var4);
               this.utilPrint.setjRBeanCollectionDataSource(var5);
               String var6 = this.utilNombre.begin(var2.getFacTotTtc() + var2.getFacTotTc(), var2.getFacDevise());
               this.utilPrint.setRapport(var2.getFacModeleImp());
               this.utilPrint.setEntete("Impression facture");
               this.utilPrint.setMontant_lettre(var6);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 25));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getFacIdResponsable());
               this.utilPrint.setIdCommercial(var2.getFacIdCommercial());
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(25);
               this.utilPrint.setId_doc(var2.getFacId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuNoteDebitVente() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormNoteDebitVentes var1 = new FormNoteDebitVentes();
      new NoteDebitEnteteVentes();
      NoteDebitEnteteVentesDao var3 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      NoteDebitEnteteVentes var2 = var3.pourParapheur(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getNdbModeleImp() == null || var2.getNdbModeleImp().isEmpty()) {
            var2.setNdbModeleImp(this.calculeEtatDefaut(27, ""));
         }

         if (var2.getNdbModeleImp() != null && !var2.getNdbModeleImp().isEmpty()) {
            NoteDebitLigneVentesDao var4 = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.chargerLesLignes(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               String var7 = this.utilNombre.begin(var2.getNdbTotTtc() + var2.getNdbTotTc(), var2.getNdbDevise());
               this.utilPrint.setRapport(var2.getNdbModeleImp());
               this.utilPrint.setEntete("Impression note de débit");
               this.utilPrint.setMontant_lettre(var7);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid(), 27));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getNdbIdResponsable());
               this.utilPrint.setIdCommercial(var2.getNdbIdCommercial());
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(27);
               this.utilPrint.setId_doc(var2.getNdbId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuConsultationRecu() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      ArrayList var1 = new ArrayList();
      new ConsultationEnteteGene();
      ConsultationEnteteGeneDao var3 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      ConsultationEnteteGene var2 = var3.selectById(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         new ArrayList();
         ArrayList var5 = new ArrayList();
         ConsultationActesDao var6 = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
         List var4 = var6.selectConsActesByConsEnt(var2, (Session)null);
         if (var4.size() != 0) {
            new ConsultationActes();
            double var8 = this.bonCaisse.getBonCaisMontant();
            double var10 = 0.0D;

            for(int var12 = 0; var12 < var4.size(); ++var12) {
               ConsultationActes var7 = (ConsultationActes)var4.get(var12);
               if (var7.getCslactPatientHt() + var7.getCslactPatientTaxe() - var7.getCslactRegPatient() != 0.0D) {
                  if (var7.getCslactPatientHt() + var7.getCslactPatientTaxe() <= var8) {
                     var7.setCslactRegPatient(var7.getCslactPatientHt() + var7.getCslactPatientTaxe());
                     var10 = var7.getCslactRegPatient();
                  } else {
                     var7.setCslactRegPatient(var8);
                     var10 = var8;
                  }

                  var8 -= var7.getCslactRegPatient();
                  if (var8 < 0.0D) {
                     var8 = 0.0D;
                  }

                  var7.setNouveauPaiement(var10);
                  var5.add(var7);
               }
            }
         }

         if (var5.size() != 0) {
            for(int var13 = 0; var13 < var5.size(); ++var13) {
               Reglements var15 = new Reglements();
               var15.setRglNum(this.bonCaisse.getBonCaisNum());
               var15.setRglDocument(var2.getCsgNum());
               var15.setRglIdDocument(var2.getCsgId());
               var15.setRglDateReg(this.bonCaisse.getBonCaisDate());
               var15.setRglNumChqBdx(this.bonCaisse.getBonCaisNumChqBdx());
               var15.setRglBanqueTireur(this.bonCaisse.getBonCaisBanqueTirreur());
               var15.setRglMode(this.bonCaisse.getLibelleTypeReg());
               var15.setRglNomCaissier(this.bonCaisse.getBonCaisCodeCaiss());
               var15.setRglDepense(0.0D);
               var15.setRglRecette(((ConsultationActes)var5.get(var13)).getNouveauPaiement());
               var15.setRglTimbre(this.bonCaisse.getTimbre());
               var15.setRglDevise(this.bonCaisse.getBonCaisDevise());
               var15.setRglInfo4(var2.getCsgNumPieceTiers());
               var15.setRglNomTiers(var2.getPatients().getPatDossier() + "  " + var2.getCsgNomPatient());
               var15.setRglNomEquipe("N° Consultation");
               if (var2.isCsgAyantDroit()) {
                  var15.setRglNomCommercial(var2.getCsgNomAssurePrincipal());
               } else {
                  var15.setRglNomCommercial("");
                  if (var2.getPatients().getPatSexe() == 0) {
                     var15.setRglNomCommercial("Elle-même");
                  } else {
                     var15.setRglNomCommercial("Lui-même");
                  }
               }

               if (var2.getCsgIdAssurance() != 0L) {
                  var15.setRglNomResponsable(var2.getCsgNomAssurance());
                  var15.setRglNumTrf(var2.getCsgContratAssurance());
               } else if (var2.getCsgIdSociete() != 0L) {
                  var15.setRglNomResponsable(var2.getCsgNomSociete());
                  var15.setRglNumTrf(var2.getCsgMatricule());
               } else {
                  var15.setRglNomResponsable("");
                  var15.setRglNumTrf("");
               }

               var15.setRglInfo1(((ConsultationActes)var5.get(var13)).getCslactProduit());
               var15.setRglInfo2(((ConsultationActes)var5.get(var13)).getCslactLibelle());
               var15.setRglInfo3(var2.getCsgService());
               var15.setRglRecette(((ConsultationActes)var5.get(var13)).getNouveauPaiement());
               var1.add(var15);
            }

            JRBeanCollectionDataSource var14 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var14);
            String var16 = this.utilNombre.begin(this.bonCaisse.getBonCaisMontant(), this.bonCaisse.getBonCaisDevise());
            this.utilPrint.setRapport(this.calculeEtatDefaut(71, ""));
            this.utilPrint.setEntete("Impression du reçu en cours");
            this.utilPrint.setMontant_lettre(var16);
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nomRepMod));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
            this.utilPrint.setFormat("PDF");
            this.utilPrint.setEmetteur("");
            this.utilPrint.setDestinataire("");
            this.utilPrint.setDestinataireCC("");
            this.utilPrint.setDestinataireCCI("");
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setVar_nom_col6(this.bonCaisse.getBonCaisOperation());
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

   }

   public void visuPharmacieRecu() throws HibernateException, NamingException, SQLException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      ArrayList var1 = new ArrayList();
      new PharmacieEntete();
      PharmacieEnteteDao var3 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      PharmacieEntete var2 = var3.selectById(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         new ArrayList();
         ArrayList var5 = new ArrayList();
         PharmacieLigneDao var6 = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
         List var4 = var6.selectConsActesByConsEnt((PharmacieEntete)var2, (Session)null);
         if (var4.size() != 0) {
            new PharmacieLigne();
            double var8 = this.bonCaisse.getBonCaisMontant();
            double var10 = 0.0D;

            for(int var12 = 0; var12 < var4.size(); ++var12) {
               PharmacieLigne var7 = (PharmacieLigne)var4.get(var12);
               if (var7.getPhaligPatientHt() + var7.getPhaligPatientTaxe() - var7.getPhaligRegPatient() != 0.0D) {
                  if (var7.getPhaligPatientHt() + var7.getPhaligPatientTaxe() <= var8) {
                     var7.setPhaligRegPatient(var7.getPhaligPatientHt() + var7.getPhaligPatientTaxe());
                     var10 = var7.getPhaligRegPatient();
                  } else {
                     var7.setPhaligRegPatient(var8);
                     var10 = var8;
                  }

                  var8 -= var7.getPhaligRegPatient();
                  if (var8 < 0.0D) {
                     var8 = 0.0D;
                  }

                  var7.setNouveauPaiement(var10);
                  var5.add(var7);
               }
            }
         }

         if (var5.size() != 0) {
            for(int var13 = 0; var13 < var5.size(); ++var13) {
               Reglements var15 = new Reglements();
               var15.setRglNum(this.bonCaisse.getBonCaisNum());
               var15.setRglDocument(var2.getPhaNum());
               var15.setRglIdDocument(var2.getPhaId());
               var15.setRglDateReg(this.bonCaisse.getBonCaisDate());
               var15.setRglNumChqBdx(this.bonCaisse.getBonCaisNumChqBdx());
               var15.setRglBanqueTireur(this.bonCaisse.getBonCaisBanqueTirreur());
               var15.setRglMode(this.bonCaisse.getLibelleTypeReg());
               var15.setRglNomCaissier(this.bonCaisse.getBonCaisCodeCaiss());
               var15.setRglDepense(0.0D);
               var15.setRglRecette(((PharmacieLigne)var5.get(var13)).getNouveauPaiement());
               var15.setRglTimbre(this.bonCaisse.getTimbre());
               var15.setRglDevise(this.bonCaisse.getBonCaisDevise());
               var15.setRglInfo4(var2.getPhaNumPieceTiers());
               var15.setRglNomTiers(var2.getPatients().getPatDossier() + "  " + var2.getPhaNomPatient());
               var15.setRglNomEquipe("N° Pharmacie");
               if (var2.isPhaAyantDroit()) {
                  var15.setRglNomCommercial(var2.getPhaNomAssurePrincipal());
               } else {
                  var15.setRglNomCommercial("");
                  if (((PharmacieLigne)var5.get(var13)).getPharmacieEntete().getPatients().getPatSexe() == 0) {
                     var15.setRglNomCommercial("Elle-même");
                  } else {
                     var15.setRglNomCommercial("Lui-même");
                  }
               }

               if (var2.getPhaIdAssurance() != 0L) {
                  var15.setRglNomResponsable(var2.getPhaNomAssurance());
                  var15.setRglNumTrf(var2.getPhaContratAssurance());
               } else if (var2.getPhaIdSociete() != 0L) {
                  var15.setRglNomResponsable(var2.getPhaNomSociete());
                  var15.setRglNumTrf(var2.getPhaMatricule());
               } else {
                  var15.setRglNomResponsable("");
                  var15.setRglNumTrf("");
               }

               var15.setRglInfo1(((PharmacieLigne)var5.get(var13)).getPhaligProduit());
               var15.setRglInfo2(((PharmacieLigne)var5.get(var13)).getPhaligLibelle());
               var15.setRglInfo3(var2.getPhaService());
               var15.setRglRecette(((PharmacieLigne)var5.get(var13)).getNouveauPaiement());
               var1.add(var15);
            }

            JRBeanCollectionDataSource var14 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var14);
            String var16 = this.utilNombre.begin(this.bonCaisse.getBonCaisMontant(), this.bonCaisse.getBonCaisDevise());
            this.utilPrint.setRapport(this.calculeEtatDefaut(73, ""));
            this.utilPrint.setEntete("Impression du reçu en cours");
            this.utilPrint.setMontant_lettre(var16);
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nomRepMod));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
            this.utilPrint.setFormat("PDF");
            this.utilPrint.setEmetteur("");
            this.utilPrint.setDestinataire("");
            this.utilPrint.setDestinataireCC("");
            this.utilPrint.setDestinataireCCI("");
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setVar_nom_col6(this.bonCaisse.getBonCaisOperation());
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

   }

   public void visuLaboratoireRecu() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      ArrayList var1 = new ArrayList();
      new LaboratoireEntete();
      LaboratoireEnteteDao var3 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      LaboratoireEntete var2 = var3.selectById(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         new ArrayList();
         ArrayList var5 = new ArrayList();
         LaboratoireLigneDao var6 = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
         List var4 = var6.selectConsActesByConsEnt(var2, (Session)null);
         if (var4.size() != 0) {
            new LaboratoireLigne();
            double var8 = this.bonCaisse.getBonCaisMontant();
            double var10 = 0.0D;

            for(int var12 = 0; var12 < var4.size(); ++var12) {
               LaboratoireLigne var7 = (LaboratoireLigne)var4.get(var12);
               if ((var7.getLabligLaboratoire() != null && !var7.getLabligLaboratoire().isEmpty() && this.bonCaisse.getBonCaisService() != null && !this.bonCaisse.getBonCaisService().isEmpty() && var7.getLabligLaboratoire().equals(this.bonCaisse.getBonCaisService()) || var7.getLabligLaboratoire() == null || var7.getLabligLaboratoire().isEmpty() && this.bonCaisse.getBonCaisService() == null || this.bonCaisse.getBonCaisService().isEmpty()) && var7.getLabligPatientHt() + var7.getLabligPatientTaxe() - var7.getLabligRegPatient() != 0.0D) {
                  if (var7.getLabligPatientHt() + var7.getLabligPatientTaxe() <= var8) {
                     var7.setLabligRegPatient(var7.getLabligPatientHt() + var7.getLabligPatientTaxe());
                     var10 = var7.getLabligRegPatient();
                  } else {
                     var7.setLabligRegPatient(var8);
                     var10 = var8;
                  }

                  var8 -= var7.getLabligRegPatient();
                  if (var8 < 0.0D) {
                     var8 = 0.0D;
                  }

                  var7.setNouveauPaiement(var10);
                  var5.add(var7);
               }
            }
         }

         if (var5.size() != 0) {
            for(int var13 = 0; var13 < var5.size(); ++var13) {
               Reglements var15 = new Reglements();
               var15.setRglNum(this.bonCaisse.getBonCaisNum());
               var15.setRglDocument(var2.getLabNum());
               var15.setRglIdDocument(var2.getLabId());
               var15.setRglDateReg(this.bonCaisse.getBonCaisDate());
               var15.setRglNumChqBdx(this.bonCaisse.getBonCaisNumChqBdx());
               var15.setRglBanqueTireur(this.bonCaisse.getBonCaisBanqueTirreur());
               var15.setRglMode(this.bonCaisse.getLibelleTypeReg());
               var15.setRglNomCaissier(this.bonCaisse.getBonCaisCodeCaiss());
               var15.setRglDepense(0.0D);
               var15.setRglRecette(((LaboratoireLigne)var5.get(var13)).getNouveauPaiement());
               var15.setRglTimbre(this.bonCaisse.getTimbre());
               var15.setRglDevise(this.bonCaisse.getBonCaisDevise());
               var15.setRglInfo4(var2.getLabNumPieceTiers());
               var15.setRglNomTiers(var2.getPatients().getPatDossier() + "  " + var2.getLabNomPatient());
               var15.setRglNomEquipe("N° Laboratoire");
               if (var2.isLabAyantDroit()) {
                  var15.setRglNomCommercial(var2.getLabNomAssurePrincipal());
               } else {
                  var15.setRglNomCommercial("");
                  if (var2.getPatients().getPatSexe() == 0) {
                     var15.setRglNomCommercial("Elle-même");
                  } else {
                     var15.setRglNomCommercial("Lui-même");
                  }
               }

               if (var2.getLabIdAssurance() != 0L) {
                  var15.setRglNomResponsable(var2.getLabNomAssurance());
                  var15.setRglNumTrf(var2.getLabContratAssurance());
               } else if (var2.getLabIdSociete() != 0L) {
                  var15.setRglNomResponsable(var2.getLabNomSociete());
                  var15.setRglNumTrf(var2.getLabMatricule());
               } else {
                  var15.setRglNomResponsable("");
                  var15.setRglNumTrf("");
               }

               var15.setRglInfo1(((LaboratoireLigne)var5.get(var13)).getLabligProduit());
               var15.setRglInfo2(((LaboratoireLigne)var5.get(var13)).getLabligLibelle());
               if (((LaboratoireLigne)var5.get(var13)).getLaboratoireEntete().getLabLaboratoire() != null && !((LaboratoireLigne)var5.get(var13)).getLaboratoireEntete().getLabLaboratoire().isEmpty()) {
                  var15.setRglInfo3(((LaboratoireLigne)var5.get(var13)).getLaboratoireEntete().getLabLaboratoire());
               } else {
                  var15.setRglInfo3(((LaboratoireLigne)var5.get(var13)).getLabligLaboratoire());
               }

               var15.setRglRecette(((LaboratoireLigne)var5.get(var13)).getNouveauPaiement());
               var1.add(var15);
            }

            JRBeanCollectionDataSource var14 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var14);
            String var16 = this.utilNombre.begin(this.bonCaisse.getBonCaisMontant(), this.bonCaisse.getBonCaisDevise());
            this.utilPrint.setRapport(this.calculeEtatDefaut(74, ""));
            this.utilPrint.setEntete("Impression du reçu en cours");
            this.utilPrint.setMontant_lettre(var16);
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nomRepMod));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
            this.utilPrint.setFormat("PDF");
            this.utilPrint.setEmetteur("");
            this.utilPrint.setDestinataire("");
            this.utilPrint.setDestinataireCC("");
            this.utilPrint.setDestinataireCCI("");
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setVar_nom_col6(this.bonCaisse.getBonCaisOperation());
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

   }

   public void visuHospitalisationRecu() throws HibernateException, NamingException, SQLException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      ArrayList var1 = new ArrayList();
      new HospitalisationEntete();
      HospitalisationEnteteDao var3 = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
      HospitalisationEntete var2 = var3.selectById(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         new ArrayList();
         new HospitalisationReglement();
         HospitalisationReglementDao var6 = new HospitalisationReglementDao(this.baseLog, this.utilInitHibernate);
         List var4 = var6.selectReglementByBonEncaissement(this.bonEncaissementVente.getBonId(), (Session)null);
         if (var4.size() != 0) {
            new HospitalisationReglement();

            for(int var8 = 0; var8 < var4.size(); ++var8) {
               Reglements var9 = new Reglements();
               var9.setRglNum(this.bonCaisse.getBonCaisNum());
               var9.setRglDocument(var2.getHosNum());
               var9.setRglIdDocument(var2.getHosId());
               var9.setRglDateReg(this.bonCaisse.getBonCaisDate());
               var9.setRglNumChqBdx(this.bonCaisse.getBonCaisNumChqBdx());
               var9.setRglBanqueTireur(this.bonCaisse.getBonCaisBanqueTirreur());
               var9.setRglMode(this.bonCaisse.getLibelleTypeReg());
               var9.setRglNomCaissier(this.bonCaisse.getBonCaisCodeCaiss());
               var9.setRglDepense(0.0D);
               var9.setRglRecette(((HospitalisationReglement)var4.get(var8)).getHosregPatient());
               var9.setRglTimbre(this.bonCaisse.getTimbre());
               var9.setRglDevise(this.bonCaisse.getBonCaisDevise());
               var9.setRglInfo4(var2.getHosNumPieceTiers());
               var9.setRglNomTiers(var2.getPatients().getPatDossier() + "  " + var2.getHosNomPatient());
               var9.setRglNomEquipe("N° Hospitalisation");
               if (var2.isHosAyantDroit()) {
                  var9.setRglNomCommercial(var2.getHosNomAssurePrincipal());
               } else {
                  var9.setRglNomCommercial("");
                  if (var2.getPatients().getPatSexe() == 0) {
                     var9.setRglNomCommercial("Elle-même");
                  } else {
                     var9.setRglNomCommercial("Lui-même");
                  }
               }

               if (var2.getHosIdAssurance() != 0L) {
                  var9.setRglNomResponsable(var2.getHosNomAssurance());
                  var9.setRglNumTrf(var2.getHosContratAssurance());
               } else if (var2.getHosIdSociete() != 0L) {
                  var9.setRglNomResponsable(var2.getHosNomSociete());
                  var9.setRglNumTrf(var2.getHosMatricule());
               } else {
                  var9.setRglNomResponsable("");
                  var9.setRglNumTrf("");
               }

               if (((HospitalisationReglement)var4.get(var8)).getHosregLaboratoire() != null && !((HospitalisationReglement)var4.get(var8)).getHosregLaboratoire().isEmpty()) {
                  var9.setRglInfo3(((HospitalisationReglement)var4.get(var8)).getHosregLaboratoire());
               } else {
                  var9.setRglInfo3(((HospitalisationReglement)var4.get(var8)).getHosregService());
               }

               var9.setRglRecette(((HospitalisationReglement)var4.get(var8)).getHosregPatient());
               var1.add(var9);
            }

            JRBeanCollectionDataSource var10 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var10);
            String var11 = this.utilNombre.begin(this.bonCaisse.getBonCaisMontant(), this.bonCaisse.getBonCaisDevise());
            this.utilPrint.setRapport(this.calculeEtatDefaut(76, ""));
            this.utilPrint.setEntete("Impression du reçu en cours");
            this.utilPrint.setMontant_lettre(var11);
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nomRepMod));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
            this.utilPrint.setFormat("PDF");
            this.utilPrint.setEmetteur("");
            this.utilPrint.setDestinataire("");
            this.utilPrint.setDestinataireCC("");
            this.utilPrint.setDestinataireCCI("");
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setVar_nom_col6(this.bonCaisse.getBonCaisOperation());
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

   }

   public void visuConsultationFacture() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormConsultationGene var1 = new FormConsultationGene();
      new ConsultationEnteteGene();
      ConsultationEnteteGeneDao var3 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      ConsultationEnteteGene var2 = var3.selectById(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getCsgModeleImp() == null || var2.getCsgModeleImp().isEmpty()) {
            var2.setCsgModeleImp(this.calculeEtatDefaut(71, "FacturePatient"));
         }

         if (var2.getCsgModeleImp() != null && !var2.getCsgModeleImp().isEmpty()) {
            ConsultationActesDao var4 = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.selectConsActesByConsEnt(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               String var7 = this.utilNombre.begin(var2.getCsgTotPatient() + var2.getCsgTotTaxePatient(), this.structureLog.getStrdevise());
               this.utilPrint.setRapport(var2.getCsgModeleImp());
               this.utilPrint.setEntete("Impression consultation générale");
               this.utilPrint.setMontant_lettre(var7);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getCsgIdMedecin());
               this.utilPrint.setIdCommercial(var2.getCsgIdCreateur());
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(71);
               this.utilPrint.setId_doc(var2.getCsgId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuPharmacieFacture() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormPharmacie var1 = new FormPharmacie();
      new PharmacieEntete();
      PharmacieEnteteDao var3 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      PharmacieEntete var2 = var3.selectById(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getPhaModeleImp() == null || var2.getPhaModeleImp().isEmpty()) {
            var2.setPhaModeleImp(this.calculeEtatDefaut(73, "FacturePharmacie"));
         }

         if (var2.getPhaModeleImp() != null && !var2.getPhaModeleImp().isEmpty()) {
            PharmacieLigneDao var4 = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.selectConsActesByConsEnt((PharmacieEntete)var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               String var7 = this.utilNombre.begin(var2.getPhaTotPatient() + var2.getPhaTotTaxePatient(), this.structureLog.getStrdevise());
               this.utilPrint.setRapport(var2.getPhaModeleImp());
               this.utilPrint.setEntete("Impression pharmacie");
               this.utilPrint.setMontant_lettre(var7);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getPhaIdMedecin());
               this.utilPrint.setIdCommercial(var2.getPhaIdCreateur());
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(73);
               this.utilPrint.setId_doc(var2.getPhaId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuLaboratoireFacture() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormLaboratoire var1 = new FormLaboratoire();
      new LaboratoireEntete();
      LaboratoireEnteteDao var3 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      LaboratoireEntete var2 = var3.selectById(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getLabModeleImp() == null || var2.getLabModeleImp().isEmpty()) {
            var2.setLabModeleImp(this.calculeEtatDefaut(74, "FactureLaboratoire"));
         }

         if (var2.getLabModeleImp() != null && !var2.getLabModeleImp().isEmpty()) {
            LaboratoireLigneDao var4 = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.selectConsActesByConsEnt(var2, (Session)null);
            if (var5.size() != 0) {
               JRBeanCollectionDataSource var6 = new JRBeanCollectionDataSource(var5);
               this.utilPrint.setjRBeanCollectionDataSource(var6);
               String var7 = this.utilNombre.begin(var2.getLabTotPatient() + var2.getLabTotTaxePatient(), this.structureLog.getStrdevise());
               this.utilPrint.setRapport(var2.getLabModeleImp());
               this.utilPrint.setEntete("Impression laboratoire");
               this.utilPrint.setMontant_lettre(var7);
               this.utilPrint.setPageGarde(var1.conversionGarde());
               this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
               this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getLabIdMedecin());
               this.utilPrint.setIdCommercial(var2.getLabIdCreateur());
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(74);
               this.utilPrint.setId_doc(var2.getLabId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuHospitalisationFacture() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormHospitalisation var1 = new FormHospitalisation();
      new HospitalisationEntete();
      HospitalisationEnteteDao var3 = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
      HospitalisationEntete var2 = var3.selectById(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getHosModeleImp() == null || var2.getHosModeleImp().isEmpty()) {
            var2.setHosModeleImp(this.calculeEtatDefaut(76, "FactureHospitalisation"));
         }

         if (var2.getHosModeleImp() != null && !var2.getHosModeleImp().isEmpty()) {
            HospitalisationSejourDao var4 = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var5 = var4.selectSejourByEnt(var2, (Session)null);
            var1.setLesSejours(var5);
            HospitalisationActesDao var6 = new HospitalisationActesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var7 = var6.selectActesByEnt(var2, (Session)null);
            var1.setLesActes(var7);
            HospitalisationMediDao var8 = new HospitalisationMediDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var9 = var8.selectMediByEnt(var2, (Session)null);
            var1.setLesMedis(var9);
            HospitalisationLaboDao var10 = new HospitalisationLaboDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var11 = var10.selectLaboByEnt(var2, (Session)null);
            var1.setLesLabos(var11);
            HospitalisationPrestDao var12 = new HospitalisationPrestDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var13 = var12.selectPrestByEnt(var2, (Session)null);
            var1.setLesPrests(var13);
            this.utilPrint.setjRBeanCollectionDataSource(var1.calculeImpressionCommun(var2.getHosModeleImp()));
            String var14 = this.utilNombre.begin(var2.getHosTotPatient() + var2.getHosTotTaxePatient(), this.structureLog.getStrdevise());
            this.utilPrint.setRapport(var2.getHosModeleImp());
            this.utilPrint.setEntete("Impression hospitalisation");
            this.utilPrint.setMontant_lettre(var14);
            this.utilPrint.setPageGarde(var1.conversionGarde());
            this.utilPrint.setAnnexe1(var1.conversionAnnexe1());
            this.utilPrint.setAnnexe2(var1.conversionAnnexe2());
            this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
            this.utilPrint.setDuplicata("true");
            this.utilPrint.setFormat("PDF");
            this.utilPrint.setEmetteur("");
            this.utilPrint.setDestinataire("");
            this.utilPrint.setDestinataireCC("");
            this.utilPrint.setDestinataireCCI("");
            this.utilPrint.setIdResponsable(var2.getHosIdMedecin());
            this.utilPrint.setIdCommercial(var2.getHosIdCreateur());
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setNature(76);
            this.utilPrint.setId_doc(var2.getHosId());
            this.utilPrint.setParc((Parc)null);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

   }

   public void visuFactureLocation() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormFactureImmobilier var1 = new FormFactureImmobilier();
      new BienFacture();
      BienFactureDao var3 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
      BienFacture var2 = var3.pourParapheur(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getBiefacModeleImp() == null || var2.getBiefacModeleImp().isEmpty()) {
            var2.setBiefacModeleImp(this.calculeEtatDefaut(165, ""));
         }

         if (var2.getBiefacModeleImp() != null && !var2.getBiefacModeleImp().isEmpty()) {
            ArrayList var4 = new ArrayList();
            var4.add(var2);
            if (var4.size() != 0) {
               JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var4);
               this.utilPrint.setjRBeanCollectionDataSource(var5);
               String var6 = this.utilNombre.begin(var2.getBiefacTotTtc() + var2.getBiefacTotTc(), var2.getBiefacDevise());
               this.utilPrint.setRapport(var2.getBiefacModeleImp());
               this.utilPrint.setEntete("Impression facture location");
               this.utilPrint.setMontant_lettre(var6);
               this.utilPrint.setPageGarde((String)null);
               this.utilPrint.setAnnexe1((String)null);
               this.utilPrint.setAnnexe2((String)null);
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getBiefacIdResponsable());
               this.utilPrint.setIdCommercial(var2.getBiefacIdCommercial());
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(165);
               this.utilPrint.setId_doc(var2.getBiefacId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void visuFactureAppelCharge() throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      FormAppelChargeImmobilier var1 = new FormAppelChargeImmobilier();
      new AppelCharge();
      AppelChargeDao var3 = new AppelChargeDao(this.baseLog, this.utilInitHibernate);
      AppelCharge var2 = var3.pourParapheur(this.bonCaisse.getBonCaisIdOrigine(), (Session)null);
      if (var2 != null) {
         if (var2.getAppchaModeleImp() == null || var2.getAppchaModeleImp().isEmpty()) {
            var2.setAppchaModeleImp(this.calculeEtatDefaut(173, ""));
         }

         if (var2.getAppchaModeleImp() != null && !var2.getAppchaModeleImp().isEmpty()) {
            ArrayList var4 = new ArrayList();
            var4.add(var2);
            if (var4.size() != 0) {
               JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var4);
               this.utilPrint.setjRBeanCollectionDataSource(var5);
               String var6 = this.utilNombre.begin(var2.getAppchaTotTtc() + var2.getAppchaTotTc(), var2.getAppchaDevise());
               this.utilPrint.setRapport(var2.getAppchaModeleImp());
               this.utilPrint.setEntete("Impression appel de charge");
               this.utilPrint.setMontant_lettre(var6);
               this.utilPrint.setPageGarde((String)null);
               this.utilPrint.setAnnexe1((String)null);
               this.utilPrint.setAnnexe2((String)null);
               this.utilPrint.setCheminRapport(var1.calculeCheminRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setCheminSousrapport(var1.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               this.utilPrint.setImageFondPage(var1.calculeImageFond("structure" + this.structureLog.getStrid(), 30));
               this.utilPrint.setDuplicata("true");
               this.utilPrint.setFormat("PDF");
               this.utilPrint.setEmetteur("");
               this.utilPrint.setDestinataire("");
               this.utilPrint.setDestinataireCC("");
               this.utilPrint.setDestinataireCCI("");
               this.utilPrint.setIdResponsable(var2.getAppchaIdResponsable());
               this.utilPrint.setIdCommercial(var2.getAppchaIdCommercial());
               this.utilPrint.setTiersSelectionne((Tiers)null);
               this.utilPrint.setNature(173);
               this.utilPrint.setId_doc(var2.getAppchaId());
               this.utilPrint.setParc((Parc)null);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      }

   }

   public void ajouterRecettes() throws HibernateException, NamingException, ParseException {
      this.memoCompteTaxe = "";
      this.memoTauxTaxe = 0.0F;
      this.affichageExoCompte = false;
      this.memoExoTaxe = false;
      this.visibleSuite = false;
      this.var_valide = false;
      this.affichBanq = false;
      this.affichage_espece = false;
      this.affichage_cheque = false;
      this.affichage_effet = false;
      this.affichage_bonCaisse = false;
      this.natureOperation = "";
      this.mesEmetteursItems = new ArrayList();
      this.mesRecepteursItems = new ArrayList();
      this.caissesOperations = new CaissesOperations();
      this.mesOperationsItems = new ArrayList();
      this.userOperationsCaisses = new ArrayList();
      this.lesChequesARemettre = new ArrayList();
      this.lesEffetsARemettre = new ArrayList();
      this.dataModelDetailAremettre = new ListDataModel();
      if (this.mesCaissesRecetteItems.size() == 1) {
         this.var_caisse = ((SelectItem)this.mesCaissesRecetteItems.get(0)).getValue().toString();
      } else if (this.mesCaissesRecetteItems.size() != 0) {
         this.var_caisse = ((SelectItem)this.mesCaissesRecetteItems.get(0)).getValue().toString();
      } else {
         this.var_caisse = "";
      }

      if (this.usersChrono != null) {
         this.listOperations.clear();
         this.listOperations = this.caissesOperationsDao.selectActifOperation(0, (Session)null);
         if (this.listOperations.size() != 0) {
            this.var_action = 4;
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && !this.var_caisse.equals("100")) {
               this.selectionCaisse();
            }

            this.var_memo_action = this.var_action;
         }
      }

      if (this.var_parc) {
         this.formAnalytique = new FormAnalytique(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
         this.formAnalytique.ongletAxe07();
         this.formAnalytique.utilisationAxe07();
      }

      this.lesDecoupagesActivites.clear();
      this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
      this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.selectionCaisse();
   }

   public void ajouterDepenses() throws HibernateException, NamingException, ParseException {
      this.memoCompteTaxe = "";
      this.memoTauxTaxe = 0.0F;
      this.affichageExoCompte = false;
      this.memoExoTaxe = false;
      this.visibleSuite = false;
      this.var_valide = false;
      this.affichBanq = false;
      this.affichage_espece = false;
      this.affichage_cheque = false;
      this.affichage_effet = false;
      this.affichage_bonCaisse = false;
      this.natureOperation = "";
      this.mesEmetteursItems = new ArrayList();
      this.mesRecepteursItems = new ArrayList();
      this.caissesOperations = new CaissesOperations();
      this.mesOperationsItems = new ArrayList();
      this.userOperationsCaisses = new ArrayList();
      this.lesChequesARemettre = new ArrayList();
      this.lesEffetsARemettre = new ArrayList();
      this.dataModelDetailAremettre = new ListDataModel();
      if (this.mesCaissesRecetteItems.size() == 1) {
         this.var_caisse = ((SelectItem)this.mesCaissesRecetteItems.get(0)).getValue().toString();
      } else if (this.mesCaissesRecetteItems.size() != 0) {
         this.var_caisse = ((SelectItem)this.mesCaissesRecetteItems.get(0)).getValue().toString();
      } else {
         this.var_caisse = "";
      }

      if (this.usersChrono != null) {
         this.listOperations.clear();
         this.listOperations = this.caissesOperationsDao.selectActifOperation(1, (Session)null);
         if (this.listOperations.size() != 0) {
            this.var_action = 5;
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && !this.var_caisse.equals("100")) {
               this.selectionCaisse();
            }

            this.var_memo_action = this.var_action;
         }
      }

      if (this.var_parc) {
         this.formAnalytique = new FormAnalytique(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
         this.formAnalytique.ongletAxe07();
         this.formAnalytique.utilisationAxe07();
      }

      this.lesDecoupagesActivites.clear();
      this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
      this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.selectionCaisse();
   }

   public void ajouterTransfert() throws HibernateException, NamingException, ParseException {
      this.memoCompteTaxe = "";
      this.memoTauxTaxe = 0.0F;
      this.affichageExoCompte = false;
      this.memoExoTaxe = false;
      this.visibleSuite = false;
      this.var_valide = false;
      this.natureOperation = "";
      this.affichage_espece = false;
      this.affichage_cheque = false;
      this.affichage_effet = false;
      this.affichage_bonCaisse = false;
      this.affichBanq = false;
      this.mesEmetteursItems = new ArrayList();
      this.mesRecepteursItems = new ArrayList();
      this.caissesOperations = new CaissesOperations();
      this.lesChequesARemettre = new ArrayList();
      this.lesEffetsARemettre = new ArrayList();
      this.dataModelDetailAremettre = new ListDataModel();
      this.mesOperationsItems = new ArrayList();
      this.userOperationsCaisses = new ArrayList();
      if (this.mesCaissesRecetteItems.size() == 1) {
         this.var_caisse = ((SelectItem)this.mesCaissesRecetteItems.get(0)).getValue().toString();
      } else if (this.mesCaissesRecetteItems.size() != 0) {
         this.var_caisse = ((SelectItem)this.mesCaissesRecetteItems.get(0)).getValue().toString();
      } else {
         this.var_caisse = "";
      }

      if (this.usersChrono != null) {
         this.listOperations.clear();
         this.listOperations = this.caissesOperationsDao.selectActifOperation(2, (Session)null);
         if (this.listOperations.size() != 0) {
            this.var_action = 6;
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && !this.var_caisse.equals("100")) {
               this.selectionCaisse();
            }

            this.var_memo_action = this.var_action;
         }
      }

      this.selectionCaisse();
   }

   public void selectionCaisse() throws HibernateException, NamingException, ParseException {
      this.typeDocumentAPayer = 0;
      this.listCommande.clear();
      this.listLivraison.clear();
      this.listFacture.clear();
      this.tiers = null;
      this.planComptable = null;
      this.datamodelTransfert.setWrappedData(this.listFacture);
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         String[] var1 = this.var_caisse.split(":");
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
         this.caissesCommerciales = this.caissesCommercialesDao.selectCaisseByCode(var1[0], this.selectedExo, var2);
         if (this.caissesCommerciales != null) {
            this.chargerlesOperationsCaisse();
            this.choixCaissePiece(var2);
            if (this.var_action == 5) {
               this.calculeSoldeCaisse(this.caissesCommerciales.getCaiCode(), new Date());
            }
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.caissesCommerciales = null;
         this.userOperationsCaisses.clear();
         this.mesOperationsItems.clear();
      }

      this.visibleSuite = false;
      this.natureOperation = "";
   }

   public void chargerlesOperationsCaisse() throws HibernateException, NamingException {
      this.userOperationsCaisses.clear();
      this.mesOperationsItems.clear();
      if (this.caissesCommerciales != null && this.caissesCommerciales.getCaiOperation() != null && !this.caissesCommerciales.getCaiOperation().isEmpty()) {
         if (!this.caissesCommerciales.getCaiOperation().contains(":")) {
            String var4 = this.caissesCommerciales.getCaiOperation();
            this.chargerlesUsersOperationsCaisse(var4);
         } else {
            String[] var1 = this.caissesCommerciales.getCaiOperation().split(":");

            for(int var2 = 0; var2 < var1.length; ++var2) {
               String var3 = var1[var2];
               this.chargerlesUsersOperationsCaisse(var3);
            }
         }

         if (this.userOperationsCaisses.size() != 0) {
            for(int var5 = 0; var5 < this.userOperationsCaisses.size(); ++var5) {
               this.mesOperationsItems.add(new SelectItem(((CaissesOperations)this.userOperationsCaisses.get(var5)).getCaiopeCode(), ((CaissesOperations)this.userOperationsCaisses.get(var5)).getCaiopeCode() + ":" + ((CaissesOperations)this.userOperationsCaisses.get(var5)).getCaiopeNom()));
            }
         }
      }

   }

   public void chargerlesUsersOperationsCaisse(String var1) {
      if (this.usersChrono != null && this.usersChrono.getUsrchrMode() != null && !this.usersChrono.getUsrchrMode().isEmpty()) {
         String var2 = "";
         double var3 = 0.0D;
         if (!this.usersChrono.getUsrchrMode().contains(":")) {
            if (this.usersChrono.getUsrchrMode().equals(var1)) {
               var2 = this.usersChrono.getUsrchrMode();
               var3 = Double.parseDouble(this.usersChrono.getUsrchrPlafond());

               for(int var5 = 0; var5 < this.listOperations.size(); ++var5) {
                  this.caissesOperations = new CaissesOperations();
                  this.caissesOperations = (CaissesOperations)this.listOperations.get(var5);
                  if (this.caissesOperations.getCaiopeCode() != null && !this.caissesOperations.getCaiopeCode().isEmpty() && this.caissesOperations.getCaiopeCode().equals(var2)) {
                     this.caissesOperations.setSelect(true);
                     this.caissesOperations.setPlafond(var3);
                     this.userOperationsCaisses.add(this.caissesOperations);
                  }
               }
            }
         } else {
            String[] var10 = this.usersChrono.getUsrchrMode().split(":");
            String[] var6 = this.usersChrono.getUsrchrPlafond().split(":");
            int var7 = 0;
            if (var10.length == var6.length) {
               var7 = var10.length;
            } else if (var10.length > var6.length) {
               var7 = var6.length;
            } else if (var10.length < var6.length) {
               var7 = var10.length;
            }

            for(int var8 = 0; var8 < var7; ++var8) {
               var2 = var10[var8];
               var3 = Double.parseDouble(var6[var8]);
               if (var1.equals(var2)) {
                  for(int var9 = 0; var9 < this.listOperations.size(); ++var9) {
                     this.caissesOperations = (CaissesOperations)this.listOperations.get(var9);
                     if (this.caissesOperations.getCaiopeCode() != null && !this.caissesOperations.getCaiopeCode().isEmpty() && this.caissesOperations.getCaiopeCode().equals(var2)) {
                        this.caissesOperations.setSelect(true);
                        this.caissesOperations.setPlafond(var3);
                        this.userOperationsCaisses.add(this.caissesOperations);
                        break;
                     }
                  }
               }
            }
         }
      }

   }

   public void selectionOperation() throws HibernateException, NamingException {
      this.typeDocumentAPayer = 0;
      this.listCommande.clear();
      this.listLivraison.clear();
      this.listFacture.clear();
      this.datamodelTransfert.setWrappedData(this.listFacture);
      if (this.var_caisse != null && !this.var_caisse.isEmpty()) {
         if (this.natureOperation != null && !this.natureOperation.isEmpty()) {
            this.caissesOperations = new CaissesOperations();
            if (this.userOperationsCaisses.size() != 0) {
               this.caissesOperations = new CaissesOperations();

               for(int var1 = 0; var1 < this.userOperationsCaisses.size(); ++var1) {
                  if (((CaissesOperations)this.userOperationsCaisses.get(var1)).getCaiopeCode().equals(this.natureOperation)) {
                     this.caissesOperations = (CaissesOperations)this.userOperationsCaisses.get(var1);
                     this.visibleSuite = true;
                     break;
                  }
               }
            }

            if (!this.visibleSuite || this.caissesOperations == null || !this.caissesOperations.getCaiopeCode().equals("11") && !this.caissesOperations.getCaiopeCode().equals("12") && !this.caissesOperations.getCaiopeCode().equals("22")) {
               if ((!this.visibleSuite || this.caissesOperations == null || !this.caissesOperations.getCaiopeCode().equals("19")) && (!this.visibleSuite || this.caissesOperations == null || !this.caissesOperations.getCaiopeCode().equals("29"))) {
                  List var9;
                  String var10;
                  int var11;
                  String var12;
                  if (this.visibleSuite && this.caissesOperations != null && this.caissesOperations.getCaiopeCode().equals("26")) {
                     this.mesBonsCaisse = new ArrayList();
                     new ArrayList();
                     var9 = this.reglementsDao.chargeBonCaisseDisponible(this.var_caisse, new Date(), (Session)null);
                     if (var9.size() != 0) {
                        for(var11 = 0; var11 < var9.size(); ++var11) {
                           var12 = this.utilDate.dateToStringFr(((Reglements)var9.get(var11)).getRglDateReg());
                           var10 = this.utilNombre.beginSimple(((Reglements)var9.get(var11)).getRglDepense(), this.structureLog.getStrdevise());
                           this.mesBonsCaisse.add(new SelectItem(((Reglements)var9.get(var11)).getRglId(), "N° " + ((Reglements)var9.get(var11)).getRglNum() + " du " + var12 + " montant " + var10));
                        }
                     }

                     this.affichage_bonCaisse = true;
                  } else if (this.visibleSuite && this.caissesOperations != null && this.caissesOperations.getCaiopeCode().equals("18")) {
                     this.mesBonsCaisse = new ArrayList();
                     new ArrayList();
                     var9 = this.reglementsDao.chargeRegulCaisseDisponibleRecette(this.var_caisse, new Date(), (Session)null);
                     if (var9.size() != 0) {
                        for(var11 = 0; var11 < var9.size(); ++var11) {
                           var12 = this.utilDate.dateToStringFr(((Reglements)var9.get(var11)).getRglDateReg());
                           var10 = this.utilNombre.beginSimple(((Reglements)var9.get(var11)).getRglDepense(), this.structureLog.getStrdevise());
                           this.mesBonsCaisse.add(new SelectItem(((Reglements)var9.get(var11)).getRglId(), "N° " + ((Reglements)var9.get(var11)).getRglNum() + " du " + var12 + " montant " + var10));
                        }
                     }

                     this.affichage_bonCaisse = true;
                  } else if (this.visibleSuite && this.caissesOperations != null && this.caissesOperations.getCaiopeCode().equals("28")) {
                     this.mesBonsCaisse = new ArrayList();
                     new ArrayList();
                     var9 = this.reglementsDao.chargeRegulCaisseDisponibleDepense(this.var_caisse, new Date(), (Session)null);
                     if (var9.size() != 0) {
                        for(var11 = 0; var11 < var9.size(); ++var11) {
                           var12 = this.utilDate.dateToStringFr(((Reglements)var9.get(var11)).getRglDateReg());
                           var10 = this.utilNombre.beginSimple(((Reglements)var9.get(var11)).getRglDepense(), this.structureLog.getStrdevise());
                           this.mesBonsCaisse.add(new SelectItem(((Reglements)var9.get(var11)).getRglId(), "N° " + ((Reglements)var9.get(var11)).getRglNum() + " du " + var12 + " montant " + var10));
                        }
                     }

                     this.affichage_bonCaisse = true;
                  } else if ((!this.visibleSuite || this.caissesOperations == null || !this.caissesOperations.getCaiopeCode().equals("30")) && this.visibleSuite && this.caissesOperations != null && this.var_action == 6) {
                     this.affichage_espece = false;
                     this.affichage_cheque = false;
                     this.affichage_effet = false;
                     Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
                     this.mesEmetteursItems = new ArrayList();
                     this.mesRecepteursItems = new ArrayList();
                     byte var2 = 0;
                     byte var3 = 0;
                     if (this.caissesOperations.getCaiopeCode().equals("71")) {
                        var2 = 0;
                        var3 = 0;
                     } else if (this.caissesOperations.getCaiopeCode().equals("73")) {
                        var2 = 1;
                        var3 = 0;
                     } else if (this.caissesOperations.getCaiopeCode().equals("74")) {
                        var2 = 1;
                        var3 = 1;
                     } else if (this.caissesOperations.getCaiopeCode().equals("76")) {
                        var2 = 0;
                        var3 = 1;
                     } else if (this.caissesOperations.getCaiopeCode().equals("77")) {
                        var2 = 0;
                        var3 = 0;
                     } else if (this.caissesOperations.getCaiopeCode().equals("80")) {
                        var2 = 0;
                        var3 = 0;
                        this.affichage_espece = true;
                     } else if (this.caissesOperations.getCaiopeCode().equals("81")) {
                        var2 = 0;
                        var3 = 0;
                        this.affichage_cheque = true;
                     } else if (this.caissesOperations.getCaiopeCode().equals("82")) {
                        var2 = 0;
                        var3 = 0;
                        this.affichage_effet = true;
                     } else if (this.caissesOperations.getCaiopeCode().equals("83")) {
                        var2 = 0;
                        var3 = 1;
                        this.affichage_cheque = true;
                     } else if (this.caissesOperations.getCaiopeCode().equals("84")) {
                        var2 = 0;
                        var3 = 1;
                        this.affichage_effet = true;
                     } else if (this.caissesOperations.getCaiopeCode().equals("85")) {
                        var2 = 0;
                        var3 = 1;
                        this.affichage_espece = true;
                     }

                     if (!this.caissesOperations.getCaiopeCode().equals("80") && !this.caissesOperations.getCaiopeCode().equals("81") && !this.caissesOperations.getCaiopeCode().equals("82")) {
                        this.mesEmetteursItems = this.journauxComptablesDao.chargerLesJournaux(this.exercicesComptable, var2, this.usersLog.getUsrJrxReserve(), var8);
                        this.mesRecepteursItems = this.journauxComptablesDao.chargerLesJournaux(this.exercicesComptable, var3, this.usersLog.getUsrJrxReserve(), var8);
                     } else {
                        this.mesEmetteursItems.clear();
                        this.mesEmetteursItems.add(new SelectItem(this.var_caisse));
                        this.inputBanqEmetteur = this.var_caisse;
                        this.mesRecepteursItems.clear();
                        new CaissesCommerciales();

                        for(int var5 = 0; var5 < this.mesCaissesExecutriceItems.size(); ++var5) {
                           if (!((SelectItem)this.mesCaissesExecutriceItems.get(var5)).getValue().toString().equals(this.var_caisse)) {
                              String var6 = "";
                              if (((SelectItem)this.mesCaissesExecutriceItems.get(var5)).getValue().toString().contains(":")) {
                                 String[] var7 = ((SelectItem)this.mesCaissesExecutriceItems.get(var5)).getValue().toString().split(":");
                                 var6 = var7[0];
                              } else {
                                 var6 = ((SelectItem)this.mesCaissesExecutriceItems.get(var5)).getValue().toString();
                              }

                              CaissesCommerciales var4 = this.caissesCommercialesDao.chercheCaisseByJournal(this.selectedExo.getExecaiId(), var6, var8);
                              if (var4 != null) {
                                 if (var4.getCaiJrEspece() != null && !var4.getCaiJrEspece().isEmpty() && this.caissesOperations.getCaiopeCode().equals("80")) {
                                    this.mesRecepteursItems.add(new SelectItem(((SelectItem)this.mesCaissesExecutriceItems.get(var5)).getValue().toString()));
                                 } else if (var4.getCaiJrCheque() != null && !var4.getCaiJrCheque().isEmpty() && this.caissesOperations.getCaiopeCode().equals("81")) {
                                    this.mesRecepteursItems.add(new SelectItem(((SelectItem)this.mesCaissesExecutriceItems.get(var5)).getValue().toString()));
                                 } else if (var4.getCaiJrTraite() != null && !var4.getCaiJrTraite().isEmpty() && this.caissesOperations.getCaiopeCode().equals("82")) {
                                    this.mesRecepteursItems.add(new SelectItem(((SelectItem)this.mesCaissesExecutriceItems.get(var5)).getValue().toString()));
                                 }
                              }
                           }
                        }
                     }

                     this.utilInitHibernate.closeSession();
                  }
               }
            } else {
               this.affichage_effet = true;
               this.traiteLigneDao = new TraiteLigneDao(this.baseLog, this.utilInitHibernate);
            }

            if (!this.regul) {
               this.ajouterPiece();
            }

            if (this.natureOperation != null && !this.natureOperation.isEmpty() && (this.natureOperation.equals("01") || this.natureOperation.equals("02"))) {
               if (this.optionVentes.getPaiementAVOIR().equals("0")) {
                  this.typeDocumentAPayer = 25;
               } else if (this.optionVentes.getPaiementAVOIR().equals("1")) {
                  this.typeDocumentAPayer = 22;
               } else if (this.optionVentes.getPaiementAVOIR().equals("2")) {
                  this.typeDocumentAPayer = 23;
               }
            }
         }
      } else {
         this.visibleSuite = false;
      }

   }

   public void ajouterPiece() throws HibernateException, NamingException {
      byte var1 = 0;
      if (this.caissesOperations.getCaiopeCategorie() == 0) {
         var1 = 25;
      } else if (this.caissesOperations.getCaiopeCategorie() == 1) {
         var1 = 15;
      } else if (this.caissesOperations.getCaiopeCategorie() == 2) {
         if (this.caissesOperations.getCaiopeType() == 0) {
            var1 = 87;
         } else {
            var1 = 88;
         }
      } else if (this.caissesOperations.getCaiopeCategorie() == 3) {
         var1 = 64;
      } else if (this.caissesOperations.getCaiopeCategorie() == 4) {
         if (this.caissesOperations.getCaiopeType() == 0) {
            var1 = 25;
         } else {
            var1 = 15;
         }
      } else if (this.caissesOperations.getCaiopeCategorie() == 5) {
         var1 = 15;
      }

      this.visibleSuite = true;
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.bonCaisse = new BonCaisse();
      this.reglements = new Reglements();
      this.reglements.setRglDateReg(new Date());
      this.reglements.setRglDevise(this.structureLog.getStrdevise());
      this.reglements.setRglFormatDevise(this.structureLog.getStrformatdevise());
      this.reglements.setRglNomResponsable(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglNatureDoc(var1);
      this.var_aEncaisser = 0.0D;
      this.var_montant_recu = 0.0D;
      this.var_timbre = 0.0D;
      this.var_montant_rendu = 0.0D;
      this.var_monnaie = 0.0D;
      this.var_total_bon = 0.0D;
      this.var_verrou_caisse = false;
      this.inputBanq = "";
      if (!this.caissesOperations.getCaiopeCode().equals("19") && !this.caissesOperations.getCaiopeCode().equals("29") && !this.caissesOperations.getCaiopeCode().equals("76") && !this.caissesOperations.getCaiopeCode().equals("77") && !this.caissesOperations.getCaiopeCode().equals("81") && !this.caissesOperations.getCaiopeCode().equals("83")) {
         this.var_modeReglement = "100";
      } else {
         this.var_modeReglement = "1";
      }

      this.planfond_depasse = false;
      this.regul = false;
      this.choixTypeReglementPiece();
   }

   public void chargeCheque() throws HibernateException, NamingException {
      this.lesChequesARemettre.clear();

      try {
         if (this.caissesOperations.getCaiopeCode().equals("81")) {
            this.lesChequesARemettre = this.reglementsDao.chargeChequeCaisseCaisse(this.var_caisse, this.reglements.getRglDateReg(), this.reglements.getRglNum(), (Session)null);
         } else if (this.caissesOperations.getCaiopeCode().equals("83")) {
            String var1 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.lesChequesARemettre = this.reglementsDao.chargeChequeCaisseBanque(this.var_caisse, var1, this.reglements.getRglNum(), (Session)null);
         }
      } catch (HibernateException var2) {
         throw var2;
      }

      this.dataModelDetailAremettre.setWrappedData(this.lesChequesARemettre);
   }

   public void selectionToutCheque() {
      this.var_aEncaisser = 0.0D;
      if (this.lesChequesARemettre.size() != 0) {
         new Reglements();

         for(int var2 = 0; var2 < this.lesChequesARemettre.size(); ++var2) {
            Reglements var1 = (Reglements)this.lesChequesARemettre.get(var2);
            var1.setSel_ecriture(true);
            this.var_aEncaisser += var1.getRglRecette() - var1.getRglDepense();
         }
      }

   }

   public void selectionAucunCheque() {
      this.var_aEncaisser = 0.0D;
      if (this.lesChequesARemettre.size() != 0) {
         new Reglements();

         for(int var2 = 0; var2 < this.lesChequesARemettre.size(); ++var2) {
            Reglements var1 = (Reglements)this.lesChequesARemettre.get(var2);
            var1.setSel_ecriture(false);
         }
      }

   }

   public void calculeMontantATransferer() {
      this.var_aEncaisser = 0.0D;
      Reglements var1;
      int var2;
      if (this.lesChequesARemettre.size() != 0) {
         new Reglements();

         for(var2 = 0; var2 < this.lesChequesARemettre.size(); ++var2) {
            var1 = (Reglements)this.lesChequesARemettre.get(var2);
            if (var1.isSel_ecriture()) {
               this.var_aEncaisser += var1.getRglRecette() - var1.getRglDepense();
            }
         }
      } else if (this.lesEffetsARemettre.size() != 0) {
         new Reglements();

         for(var2 = 0; var2 < this.lesEffetsARemettre.size(); ++var2) {
            var1 = (Reglements)this.lesEffetsARemettre.get(var2);
            if (var1.isSel_ecriture()) {
               this.var_aEncaisser += var1.getRglRecette() - var1.getRglDepense();
            }
         }
      }

   }

   public void chargeEffet() throws HibernateException, NamingException, ParseException {
      this.lesEffetsARemettre.clear();
      TraiteLigne var2;
      int var3;
      Reglements var4;
      if (!this.caissesOperations.getCaiopeCode().equals("11") && !this.caissesOperations.getCaiopeCode().equals("12")) {
         if (this.caissesOperations.getCaiopeCode().equals("21")) {
            new ArrayList();
            List var5 = this.traiteLigneDao.chargerLigneDepot(67, this.reglements.getRglDateReg(), (Session)null);
            if (var5.size() != 0) {
               new TraiteLigne();

               for(var3 = 0; var3 < var5.size(); ++var3) {
                  var4 = new Reglements();
                  var2 = (TraiteLigne)var5.get(var3);
                  var4.setExercicesCaisse(this.selectedExo);
                  var4.setRglBon(var2.getTraiteEntete().getTrtNum());
                  var4.setRglIdBon(var2.getTrtligId());
                  var4.setRglIdTiers(var2.getTraiteEntete().getTrtIdTiers());
                  var4.setRglNomTiers(var2.getTraiteEntete().getTrtNomTiers());
                  var4.setRglDepense(var2.getTrtligMontant());
                  var4.setRglObjet("Paiement traites");
                  var4.setRglDateReg(this.reglements.getRglDateReg());
                  this.lesEffetsARemettre.add(var4);
               }
            }
         } else if (this.caissesOperations.getCaiopeCode().equals("82")) {
            this.lesEffetsARemettre = this.reglementsDao.chargeEffetCaisseCaisse(this.var_caisse, this.reglements.getRglDateReg(), this.reglements.getRglNum(), (Session)null);
         } else if (this.caissesOperations.getCaiopeCode().equals("84")) {
            this.lesEffetsARemettre = this.reglementsDao.chargeEffetCaisseBanque(this.var_caisse, this.reglements.getRglDateReg(), this.reglements.getRglNum(), (Session)null);
         }
      } else {
         Object var1 = new ArrayList();
         if (this.caissesOperations.getCaiopeCode().equals("11")) {
            var1 = this.traiteLigneDao.chargerLigneDepot(65, this.reglements.getRglDateReg(), (Session)null);
         } else if (this.caissesOperations.getCaiopeCode().equals("12")) {
            var1 = this.traiteLigneDao.chargerLigneDepot(66, this.reglements.getRglDateReg(), (Session)null);
         }

         if (((List)var1).size() != 0) {
            new TraiteLigne();

            for(var3 = 0; var3 < ((List)var1).size(); ++var3) {
               var4 = new Reglements();
               var2 = (TraiteLigne)((List)var1).get(var3);
               var4.setExercicesCaisse(this.selectedExo);
               var4.setRglBon(var2.getTraiteEntete().getTrtNum());
               var4.setRglIdBon(var2.getTrtligId());
               var4.setRglIdTiers(var2.getTraiteEntete().getTrtIdTiers());
               var4.setRglNomTiers(var2.getTraiteEntete().getTrtNomTiers());
               var4.setRglRecette(var2.getTrtligMontant());
               var4.setRglObjet("Paiement traites");
               var4.setRglDateReg(this.reglements.getRglDateReg());
               this.lesEffetsARemettre.add(var4);
            }
         }
      }

      this.dataModelDetailAremettre.setWrappedData(this.lesEffetsARemettre);
   }

   public void selectionToutEffet() {
      this.var_aEncaisser = 0.0D;
      if (this.lesEffetsARemettre.size() != 0) {
         new Reglements();

         for(int var2 = 0; var2 < this.lesEffetsARemettre.size(); ++var2) {
            Reglements var1 = (Reglements)this.lesEffetsARemettre.get(var2);
            var1.setSel_ecriture(true);
            this.var_aEncaisser += var1.getRglRecette() - var1.getRglDepense();
         }
      }

   }

   public void selectionAucunEffet() {
      this.var_aEncaisser = 0.0D;
      if (this.lesEffetsARemettre.size() != 0) {
         new Reglements();

         for(int var2 = 0; var2 < this.lesEffetsARemettre.size(); ++var2) {
            Reglements var1 = (Reglements)this.lesEffetsARemettre.get(var2);
            var1.setSel_ecriture(false);
         }
      }

   }

   public void chargerDocumentAPayer() throws HibernateException, NamingException {
      if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
         this.var_modeReglement = "0";
      }

      this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
      if (this.tiers != null && this.caissesCommerciales != null) {
         new ArrayList();
         ChronoDao var2 = new ChronoDao(this.baseLog, this.utilInitHibernate);
         String var3 = "";
         List var1;
         int var4;
         if (this.typeDocumentAPayer == 22) {
            this.listCommande.clear();
            if (this.caissesCommerciales.getCaiPrive() == 1) {
               var1 = var2.selectListByNature(22, 1, (Session)null);
            } else {
               var1 = var2.selectListByNature(22, 0, (Session)null);
            }

            if (var1.size() != 0) {
               var4 = 0;

               while(true) {
                  if (var4 >= var1.size()) {
                     this.listCommande = this.commandeEnteteVentesDao.rechercheNonPayeesByTiers(this.tiers, var3, (Session)null);
                     this.calculTimbreFactureVentes((Session)null);
                     break;
                  }

                  if (var3 != null && !var3.isEmpty()) {
                     var3 = var3 + ",'" + ((Chrono)var1.get(var4)).getChrSerie() + "'";
                  } else {
                     var3 = "'" + ((Chrono)var1.get(var4)).getChrSerie() + "'";
                  }

                  ++var4;
               }
            }

            this.datamodelTransfert.setWrappedData(this.listCommande);
         } else if (this.typeDocumentAPayer == 23) {
            this.listLivraison.clear();
            if (this.caissesCommerciales.getCaiPrive() == 1) {
               var1 = var2.selectListByNature(23, 1, (Session)null);
            } else {
               var1 = var2.selectListByNature(23, 0, (Session)null);
            }

            if (var1.size() != 0) {
               var4 = 0;

               while(true) {
                  if (var4 >= var1.size()) {
                     this.listLivraison = this.livraisonEnteteVentesDao.rechercheNonPayeesByTiers(this.tiers, var3, (Session)null);
                     this.calculTimbreFactureVentes((Session)null);
                     break;
                  }

                  if (var3 != null && !var3.isEmpty()) {
                     var3 = var3 + ",'" + ((Chrono)var1.get(var4)).getChrSerie() + "'";
                  } else {
                     var3 = "'" + ((Chrono)var1.get(var4)).getChrSerie() + "'";
                  }

                  ++var4;
               }
            }

            this.datamodelTransfert.setWrappedData(this.listLivraison);
         } else if (this.typeDocumentAPayer == 25) {
            this.listFacture.clear();
            if (this.caissesCommerciales.getCaiPrive() == 1) {
               var1 = var2.selectListByNature(25, 1, (Session)null);
            } else {
               var1 = var2.selectListByNature(25, 0, (Session)null);
            }

            if (var1.size() != 0) {
               var4 = 0;

               while(true) {
                  if (var4 >= var1.size()) {
                     this.listFacture = this.factureEnteteVentesDao.rechercheNonPayeesByTiers(this.tiers, var3, (Session)null);
                     this.calculTimbreFactureVentes((Session)null);
                     break;
                  }

                  if (var3 != null && !var3.isEmpty()) {
                     var3 = var3 + ",'" + ((Chrono)var1.get(var4)).getChrSerie() + "'";
                  } else {
                     var3 = "'" + ((Chrono)var1.get(var4)).getChrSerie() + "'";
                  }

                  ++var4;
               }
            }

            this.datamodelTransfert.setWrappedData(this.listFacture);
         }
      }

   }

   public void calculTimbreFactureVentes(Session var1) throws HibernateException, NamingException {
      int var3;
      double var4;
      if (this.typeDocumentAPayer == 22) {
         if (this.listCommande.size() != 0) {
            new CommandeEnteteVentes();

            for(var3 = 0; var3 < this.listCommande.size(); ++var3) {
               CommandeEnteteVentes var2 = (CommandeEnteteVentes)this.listCommande.get(var3);
               var4 = var2.getBcmTotTtc() + var2.getBcmTotTc() - var2.getBcmTotReglement();
               if (this.var_modeReglement != null && !this.var_modeReglement.isEmpty() && this.var_modeReglement.equals("0")) {
                  var2.setVar_fac_timbre(this.calculTimbreVentesPiece(var4, var2.getBcmDevise(), var1));
               } else {
                  var2.setVar_fac_timbre(0.0D);
               }
            }
         }
      } else if (this.typeDocumentAPayer == 23) {
         if (this.listLivraison.size() != 0) {
            new LivraisonEnteteVentes();

            for(var3 = 0; var3 < this.listLivraison.size(); ++var3) {
               LivraisonEnteteVentes var6 = (LivraisonEnteteVentes)this.listLivraison.get(var3);
               var4 = var6.getBlvTotTtc() + var6.getBlvTotTc() - var6.getBlvTotReglement();
               if (this.var_modeReglement != null && !this.var_modeReglement.isEmpty() && this.var_modeReglement.equals("0")) {
                  var6.setVar_blv_timbre(this.calculTimbreVentesPiece(var4, var6.getBlvDevise(), var1));
               } else {
                  var6.setVar_blv_timbre(0.0D);
               }
            }
         }
      } else if (this.typeDocumentAPayer == 25 && this.listFacture.size() != 0) {
         new FactureEnteteVentes();

         for(var3 = 0; var3 < this.listFacture.size(); ++var3) {
            FactureEnteteVentes var7 = (FactureEnteteVentes)this.listFacture.get(var3);
            var4 = var7.getFacTotTtc() + var7.getFacTotTc() - var7.getFacTotReglement();
            if (this.var_modeReglement != null && !this.var_modeReglement.isEmpty() && this.var_modeReglement.equals("0")) {
               var7.setVar_fac_timbre(this.calculTimbreVentesPiece(var4, var7.getFacDevise(), var1));
            } else {
               var7.setVar_fac_timbre(0.0D);
            }
         }
      }

   }

   public void selectionFactureAPayer() {
      if (this.datamodelTransfert.isRowAvailable()) {
         this.var_aEncaisser = 0.0D;
         int var1;
         if (this.typeDocumentAPayer == 22) {
            for(var1 = 0; var1 < this.listCommande.size(); ++var1) {
               if (((CommandeEnteteVentes)this.listCommande.get(var1)).isVar_select_ligne()) {
                  this.var_aEncaisser += ((CommandeEnteteVentes)this.listCommande.get(var1)).getBcmTotTtc() + ((CommandeEnteteVentes)this.listCommande.get(var1)).getBcmTotTc() + ((CommandeEnteteVentes)this.listCommande.get(var1)).getVar_fac_timbre() - ((CommandeEnteteVentes)this.listCommande.get(var1)).getBcmTotReglement();
               }
            }
         } else if (this.typeDocumentAPayer == 23) {
            for(var1 = 0; var1 < this.listLivraison.size(); ++var1) {
               if (((LivraisonEnteteVentes)this.listLivraison.get(var1)).isVar_select_ligne()) {
                  this.var_aEncaisser += ((LivraisonEnteteVentes)this.listLivraison.get(var1)).getBlvTotTtc() + ((LivraisonEnteteVentes)this.listLivraison.get(var1)).getBlvTotTc() + ((LivraisonEnteteVentes)this.listLivraison.get(var1)).getVar_blv_timbre() - ((LivraisonEnteteVentes)this.listLivraison.get(var1)).getBlvTotReglement();
               }
            }
         } else if (this.typeDocumentAPayer == 25) {
            for(var1 = 0; var1 < this.listFacture.size(); ++var1) {
               if (((FactureEnteteVentes)this.listFacture.get(var1)).isVar_select_ligne()) {
                  this.var_aEncaisser += ((FactureEnteteVentes)this.listFacture.get(var1)).getFacTotTtc() + ((FactureEnteteVentes)this.listFacture.get(var1)).getFacTotTc() + ((FactureEnteteVentes)this.listFacture.get(var1)).getVar_fac_timbre() - ((FactureEnteteVentes)this.listFacture.get(var1)).getFacTotReglement();
               }
            }
         }
      }

   }

   public void annulerPiece() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void selectionBonCaisse() throws HibernateException, NamingException {
      this.var_total_bon = 0.0D;
      if (this.reglements.getRglIdBon() != 0L) {
         new Reglements();
         Reglements var1 = this.reglementsDao.pourParapheur(this.reglements.getRglIdBon(), (Session)null);
         if (var1 != null) {
            this.var_total_bon = var1.getRglDepense();
         }
      }

      this.verifRegulBonCaisse();
   }

   public void validerPiece() throws HibernateException, NamingException, IOException {
      if (this.reglements.getRglNatureDoc() == 15) {
         this.casFournisseur();
      } else if (this.reglements.getRglNatureDoc() >= 21 && this.reglements.getRglNatureDoc() <= 29) {
         this.casClient();
      } else if (this.reglements.getRglNatureDoc() >= 101 && this.reglements.getRglNatureDoc() <= 109) {
         this.casEleve();
      } else if (this.reglements.getRglNatureDoc() >= 71 && this.reglements.getRglNatureDoc() <= 79) {
         this.casPatient();
      } else if (this.reglements.getRglNatureDoc() == 87) {
         this.casSalariePret();
      } else if (this.reglements.getRglNatureDoc() == 88) {
         this.casSalarieBulletin();
      } else if (this.reglements.getRglNatureDoc() == 64) {
         if (this.natureOperation.equals("77")) {
            this.casEchangeChequeEspece();
         } else {
            this.casVirement();
         }
      }

      this.initImpression();
      this.var_action = 0;
   }

   public void casFournisseur() throws NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonDecaissementAchat");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.chargerCaisse(var1);
         String var3 = "";
         if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
            var3 = this.calculChrono.numCompose(new Date(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var1);
         } else {
            var3 = this.calculChrono.numComposeCaisse(new Date(), this.natCaisse, this.serieCaisse, this.var_caisse, var1);
         }

         String[] var4;
         String var12;
         String var13;
         String var14;
         if (this.natureOperation.equals("26")) {
            if (this.var_aEncaisser != 0.0D) {
               if (this.caissesOperations != null) {
                  this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
               } else {
                  this.reglements.setRglOperation("");
               }

               this.reglements.setRglBon("");
               this.reglements.setRglCategorie(10);
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                  var4 = this.var_caisse.split(":");
                  this.reglements.setRglCodeCaiss(var4[0]);
                  this.reglements.setRglLibCaiss(var4[1]);
               } else {
                  this.reglements.setRglCodeCaiss((String)null);
                  this.reglements.setRglLibCaiss((String)null);
               }

               if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
                  var4 = this.inputBanq.split(":");
                  this.reglements.setRglCodeEmetrice(var4[0]);
                  this.reglements.setRglLibEmetrice(var4[1]);
               } else {
                  this.reglements.setRglCodeEmetrice((String)null);
                  this.reglements.setRglLibEmetrice((String)null);
               }

               this.reglements.setRglCodeReceptrice((String)null);
               this.reglements.setRglLibReceptrice((String)null);
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepense(this.var_aEncaisser);
               this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
               this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
               this.reglements.setRglIdDocument(0L);
               if (this.caissesOperations.getCaiopeCategorie() == 4) {
                  this.reglements.setRglIdTiers(0L);
               } else if (this.tiers != null) {
                  this.reglements.setRglIdTiers(this.tiers.getTieid());
               } else {
                  this.reglements.setRglIdTiers(0L);
               }

               this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
               this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
               this.reglements.setRglActiviteExo(this.memoExoTaxe);
               this.reglements.setRglDepotTiers(0);
               this.reglements.setRglMode(this.var_modeReglement);
               this.reglements.setRglModele(this.var_modele);
               this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
               this.reglements.setRglIdContact(0L);
               this.reglements.setRglNomContact("");
               this.reglements.setRglNum(var3);
               if (this.formAnalytique != null && this.var_parc) {
                  this.reglements.setRglParc(this.formAnalytique.calculeValeurListe07());
               } else {
                  this.reglements.setRglParc("");
               }

               this.reglements.setRglRecette(0.0D);
               this.reglements.setRglTimbre(0.0D);
               this.reglements.setRglTrf(0);
               if (this.caissesOperations.getCaiopeCategorie() == 4) {
                  this.reglements.setRglTypeTiers(3);
               } else {
                  this.reglements.setRglTypeTiers(1);
               }

               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
               this.reglements.setRglUserModif(0L);
               var12 = "";
               if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                  var12 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
               } else {
                  var12 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
               }

               var13 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
               this.reglements.setRglPeriode(var12 + ":" + var13);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               var14 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var14);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var14);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglements = this.reglementsDao.insert(this.reglements, var1);
            }

            if (this.var_aEncaisser + this.var_monnaie == this.var_total_bon) {
               new Reglements();
               Reglements var15 = this.reglementsDao.pourParapheur(this.reglements.getRglIdBon(), var1);
               if (var15 != null) {
                  var15.setRglDateExecBc(this.reglements.getRglDateReg());
                  this.reglementsDao.modifierReg(var15, var1);
               }
            }
         } else {
            if (this.caissesOperations != null) {
               this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
            } else {
               this.reglements.setRglOperation("");
            }

            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(10);
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
               var4 = this.var_caisse.split(":");
               this.reglements.setRglCodeCaiss(var4[0]);
               this.reglements.setRglLibCaiss(var4[1]);
            } else {
               this.reglements.setRglCodeCaiss((String)null);
               this.reglements.setRglLibCaiss((String)null);
            }

            if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
               var4 = this.inputBanq.split(":");
               this.reglements.setRglCodeEmetrice(var4[0]);
               this.reglements.setRglLibEmetrice(var4[1]);
            } else {
               this.reglements.setRglCodeEmetrice((String)null);
               this.reglements.setRglLibEmetrice((String)null);
            }

            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
            if (this.decoupageActivite) {
               var12 = "";
               boolean var5 = true;
               if (this.lesDecoupagesActivites.size() != 0) {
                  for(int var6 = 0; var6 < this.lesDecoupagesActivites.size(); ++var6) {
                     this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var6);
                     if (var5) {
                        var12 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var5 = false;
                     } else {
                        var12 = var12 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }

               this.reglements.setRglActivite(var12);
            }

            this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
            this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
            this.reglements.setRglActiviteExo(this.memoExoTaxe);
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDepense(this.var_aPayer);
            this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(0L);
            if (this.caissesOperations.getCaiopeCategorie() == 4) {
               this.reglements.setRglIdTiers(0L);
            } else if (this.tiers != null) {
               this.reglements.setRglIdTiers(this.tiers.getTieid());
            } else {
               this.reglements.setRglIdTiers(0L);
            }

            if (this.reglements.getRglOperation() == null || this.reglements.getRglOperation().isEmpty() || !this.reglements.getRglOperation().equals("13") && !this.reglements.getRglOperation().equals("15")) {
               this.reglements.setRglDepotTiers(0);
            } else {
               this.reglements.setRglDepotTiers(1);
               this.reglements.setRglLibelle("(déposit) " + this.reglements.getRglLibelle());
               this.reglements.setRglObjet("(déposit) " + this.reglements.getRglObjet());
            }

            this.reglements.setRglMode(this.var_modeReglement);
            this.reglements.setRglModele(this.var_modele);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglIdContact(0L);
            this.reglements.setRglNomContact("");
            this.reglements.setRglNum(var3);
            if (this.formAnalytique != null && this.var_parc) {
               this.reglements.setRglParc(this.formAnalytique.calculeValeurListe07());
            } else {
               this.reglements.setRglParc("");
            }

            this.reglements.setRglRecette(0.0D);
            this.reglements.setRglTimbre(0.0D);
            this.reglements.setRglTrf(0);
            if (this.caissesOperations.getCaiopeCategorie() == 4) {
               this.reglements.setRglTypeTiers(3);
            } else {
               this.reglements.setRglTypeTiers(1);
            }

            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
            this.reglements.setRglUserModif(0L);
            var12 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var12 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var12 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            var13 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var12 + ":" + var13);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            var14 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var14);
            this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
            this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var14);
            this.reglements.setExercicesCaisse(this.selectedExo);
            this.reglements = this.reglementsDao.insert(this.reglements, var1);
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

   public void casClient() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.chargerCaisse(var1);
         if (this.caissesOperations.getCaiopeCode() != null && !this.caissesOperations.getCaiopeCode().isEmpty()) {
            String var3 = "";
            if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
               var3 = this.calculChrono.numCompose(new Date(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var1);
            } else {
               var3 = this.calculChrono.numComposeCaisse(new Date(), this.natCaisse, this.serieCaisse, this.var_caisse, var1);
            }

            if (this.caissesOperations.getCaiopeCode().equals("19")) {
               this.casClientImpaye(var3, var1);
            } else if (this.typeDocumentAPayer != 0 && (this.caissesOperations.getCaiopeCode().equals("01") || this.caissesOperations.getCaiopeCode().equals("02"))) {
               if (this.typeDocumentAPayer == 22) {
                  this.casClientPaiementCommande(var3, var1);
               } else if (this.typeDocumentAPayer == 23) {
                  this.casClientPaiementLivraison(var3, var1);
               } else if (this.typeDocumentAPayer == 25) {
                  this.casClientPaiementFacture(var3, var1);
               }
            } else {
               this.casClientAutrePaiement(var3, var1);
            }

            var2.commit();
         }
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void casClientImpaye(String var1, Session var2) throws HibernateException, NamingException {
      if (this.caissesOperations != null) {
         this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
      } else {
         this.reglements.setRglOperation("");
      }

      this.reglements.setRglBon("");
      this.reglements.setRglCategorie(20);
      String[] var3;
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         var3 = this.var_caisse.split(":");
         this.reglements.setRglCodeCaiss(var3[0]);
         this.reglements.setRglLibCaiss(var3[1]);
      } else {
         this.reglements.setRglCodeCaiss((String)null);
         this.reglements.setRglLibCaiss((String)null);
      }

      if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
         var3 = this.inputBanq.split(":");
         this.reglements.setRglCodeEmetrice(var3[0]);
         this.reglements.setRglLibEmetrice(var3[1]);
      } else {
         this.reglements.setRglCodeEmetrice((String)null);
         this.reglements.setRglLibEmetrice((String)null);
      }

      this.reglements.setRglCodeReceptrice((String)null);
      this.reglements.setRglLibReceptrice((String)null);
      String var11;
      if (this.decoupageActivite) {
         var11 = "";
         boolean var4 = true;
         if (this.lesDecoupagesActivites.size() != 0) {
            for(int var5 = 0; var5 < this.lesDecoupagesActivites.size(); ++var5) {
               this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var5);
               if (var4) {
                  var11 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  var4 = false;
               } else {
                  var11 = var11 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               }
            }
         }

         this.reglements.setRglActivite(var11);
      }

      this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
      this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
      this.reglements.setRglActiviteExo(this.memoExoTaxe);
      this.reglements.setRglDateCreation(new Date());
      this.reglements.setRglDateImp((Date)null);
      this.reglements.setRglDateTransfert((Date)null);
      this.reglements.setRglDateValeur((Date)null);
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglDepotTiers(0);
      this.reglements.setRglMode("1");
      this.reglements.setRglTypeReg(1);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglIdContact(0L);
      this.reglements.setRglNomContact("");
      this.reglements.setRglNum(var1);
      if (this.formAnalytique != null && this.var_parc) {
         this.reglements.setRglParc(this.formAnalytique.calculeValeurListe07());
      } else {
         this.reglements.setRglParc("");
      }

      this.reglements.setRglRecette(this.reglements.getVal_recette() * -1.0D);
      this.reglements.setRglTimbre(this.var_timbre);
      this.reglements.setRglTrf(0);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      var11 = "";
      if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
         var11 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
      } else {
         var11 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
      }

      String var12 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
      this.reglements.setRglPeriode(var11 + ":" + var12);
      this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
      String var13 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
      this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var13);
      this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
      this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var13);
      this.reglements.setExercicesCaisse(this.selectedExo);
      this.reglements = this.reglementsDao.insert(this.reglements, var2);
      new Reglements();
      Reglements var6 = this.reglements;
      if (this.reglements.getRglFrais() != 0.0D) {
         this.reglements = new Reglements();
         this.reglements.setRglOperation(var6.getRglOperation());
         this.reglements.setRglDateReg(var6.getRglDateReg());
         this.reglements.setRglActivite(var6.getRglActivite());
         this.reglements.setRglBanqueTireur(var6.getRglBanqueTireur());
         this.reglements.setRglBudget(var6.getRglBudget());
         this.reglements.setRglBon(var6.getRglNum());
         this.reglements.setRglCategorie(20);
         if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
            String[] var7 = this.var_caisse.split(":");
            this.reglements.setRglCodeCaiss(var7[0]);
            this.reglements.setRglLibCaiss(var7[1]);
         } else {
            this.reglements.setRglCodeCaiss((String)null);
            this.reglements.setRglLibCaiss((String)null);
         }

         this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
         this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
         this.reglements.setRglActiviteExo(this.memoExoTaxe);
         this.reglements.setRglCodeEmetrice(var6.getRglCodeEmetrice());
         this.reglements.setRglCodeReceptrice((String)null);
         this.reglements.setRglDateCreation(new Date());
         this.reglements.setRglDateImp((Date)null);
         this.reglements.setRglDateTransfert((Date)null);
         this.reglements.setRglDateValeur((Date)null);
         this.reglements.setRglDepartement(var6.getRglDepartement());
         this.reglements.setRglDepense(0.0D);
         this.reglements.setRglDevise(var6.getRglDevise());
         this.reglements.setRglDossier(var6.getRglDossier());
         this.reglements.setRglFormatDevise(this.calculformatDevise(var6.getRglDevise()));
         this.reglements.setRglDocument(var6.getRglDocument());
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(var6.getRglIdDocument());
         this.reglements.setRglIdTiers(var6.getRglIdTiers());
         this.reglements.setRglDepotTiers(0);
         this.reglements.setRglLibEmetrice(var6.getRglLibEmetrice());
         this.reglements.setRglLibReceptrice((String)null);
         this.reglements.setRglLibelle("(Frais impayés)");
         this.reglements.setRglMode(var6.getRglMode());
         this.reglements.setRglModele(var6.getRglModele());
         this.reglements.setRglNumChqBdx(var6.getRglNumChqBdx());
         this.reglements.setRglNatureDoc(var6.getRglNatureDoc());
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglNomResponsable(var6.getRglNomResponsable());
         this.reglements.setRglNomTiers(var6.getRglNomTiers());
         this.reglements.setRglNum(var1);
         this.reglements.setRglObjet("(Frais impayés)");
         this.reglements.setRglParc("");
         this.reglements.setRglPdv(var6.getRglPdv());
         this.reglements.setRglRecette(var6.getRglFrais() * -1.0D);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglRegion(var6.getRglRegion());
         this.reglements.setRglSecteur(var6.getRglSecteur());
         this.reglements.setRglSerie(var6.getRglSerie());
         this.reglements.setRglService(var6.getRglService());
         this.reglements.setRglSite(var6.getRglSite());
         this.reglements.setRglTrf(0);
         this.reglements.setRglTypeReg(var6.getRglTypeReg());
         this.reglements.setRglTypeTiers(0);
         this.reglements.setRglUserCreat(this.usersLog.getUsrid());
         this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
         this.reglements.setRglUserModif(0L);
         this.reglements.setRglPeriode(var11 + ":" + var12);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var13);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var13);
         this.reglements.setExercicesCaisse(this.selectedExo);
         this.reglementsDao.insert(this.reglements, var2);
         if (this.reglements.getRglIdTiers() != 0L) {
            TiersDao var14 = new TiersDao(this.baseLog, this.utilInitHibernate);
            this.tiers = var14.selectTierD(this.reglements.getRglIdTiers(), var2);
            if (this.tiers != null) {
               this.tiers.setTiechequeinterdit(1);
               this.tiers.setTienbincident(this.tiers.getTienbincident() + 1);
               if (this.optionCaisses.getBlocageCompte().equals("0")) {
                  this.tiers.setTiecomptebloque(0);
               } else {
                  int var8 = Integer.parseInt(this.optionCaisses.getBlocageCompte());
                  if (this.tiers.getTienbincident() >= var8) {
                     this.tiers.setTiecomptebloque(1);
                  } else {
                     this.tiers.setTiecomptebloque(0);
                  }
               }

               this.tiers = var14.modif(this.tiers, var2);
            }
         }
      }

      if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglDocument() != null && !this.reglements.getRglDocument().isEmpty()) {
         double var9;
         if (this.reglements.getRglNatureDoc() == 21) {
            new DevisEnteteVentes();
            DevisEnteteVentesDao var17 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            DevisEnteteVentes var15 = var17.pourParapheur(this.reglements.getRglIdDocument(), var2);
            if (var15 != null) {
               var9 = var15.getDvsTotReglement() - (Math.abs(var6.getRglRecette()) + var6.getRglFrais());
               var15.setDvsTotReglement(var9);
               var15.setDvsSolde(0);
               var17.modif(var15, var2);
            }
         } else {
            double var19;
            if (this.reglements.getRglNatureDoc() == 22) {
               new CommandeEnteteVentes();
               CommandeEnteteVentes var16 = this.commandeEnteteVentesDao.pourParapheur(this.reglements.getRglIdDocument(), var2);
               if (var16 != null) {
                  var19 = var16.getBcmTotReglement() - (Math.abs(var6.getRglRecette()) + var6.getRglFrais());
                  var16.setBcmTotReglement(var19);
                  var16.setBcmSolde(0);
                  this.commandeEnteteVentesDao.modif(var16, var2);
               }
            } else if (this.reglements.getRglNatureDoc() == 23) {
               new LivraisonEnteteVentes();
               LivraisonEnteteVentes var18 = this.livraisonEnteteVentesDao.pourParapheur(this.reglements.getRglIdDocument(), var2);
               if (var18 != null) {
                  var19 = var18.getBlvTotReglement() - (Math.abs(var6.getRglRecette()) + var6.getRglFrais());
                  var18.setBlvTotReglement(var19);
                  var18.setBlvSolde(0);
                  this.livraisonEnteteVentesDao.modif(var18, var2);
               }
            } else if (this.reglements.getRglNatureDoc() == 25) {
               new FactureEnteteVentes();
               FactureEnteteVentes var20 = this.factureEnteteVentesDao.pourParapheur(this.reglements.getRglIdDocument(), var2);
               if (var20 != null) {
                  var19 = var20.getFacTotReglement() - (Math.abs(var6.getRglRecette()) + var6.getRglFrais());
                  var20.setFacTotReglement(var19);
                  var20.setFacSolde(0);
                  this.factureEnteteVentesDao.modif(var20, var2);
               }
            } else if (this.reglements.getRglNatureDoc() == 26) {
               new NoteDebitEnteteVentes();
               NoteDebitEnteteVentesDao var23 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
               NoteDebitEnteteVentes var21 = var23.pourParapheur(this.reglements.getRglIdDocument(), var2);
               if (var21 != null) {
                  var9 = var21.getNdbTotReglement() - (Math.abs(var6.getRglRecette()) + var6.getRglFrais());
                  var21.setNdbTotReglement(var9);
                  var21.setNdbSolde(0);
                  var23.modif(var21, var2);
               }
            } else if (this.reglements.getRglNatureDoc() == 28) {
               new ChargementEntete();
               ChargementEnteteDao var24 = new ChargementEnteteDao(this.baseLog, this.utilInitHibernate);
               ChargementEntete var22 = var24.pourParapheur(this.reglements.getRglIdDocument(), var2);
               if (var22 != null) {
                  var9 = var22.getChamobTotReglement() - (Math.abs(var6.getRglRecette()) + var6.getRglFrais());
                  var22.setChamobTotReglement(var9);
                  var22.setChamobSolde(0);
                  var24.modif(var22, var2);
               }
            }
         }
      }

   }

   public void casClientAutrePaiement(String var1, Session var2) throws HibernateException, NamingException {
      double var3 = 0.0D;
      if (this.var_garde) {
         var3 = this.var_aEncaisser + this.var_montant_rendu;
      } else {
         var3 = this.var_aEncaisser;
      }

      if (this.caissesOperations != null) {
         this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
      } else {
         this.reglements.setRglOperation("");
      }

      this.reglements.setRglBon("");
      this.reglements.setRglCategorie(20);
      String[] var5;
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         var5 = this.var_caisse.split(":");
         this.reglements.setRglCodeCaiss(var5[0]);
         this.reglements.setRglLibCaiss(var5[1]);
      } else {
         this.reglements.setRglCodeCaiss((String)null);
         this.reglements.setRglLibCaiss((String)null);
      }

      if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
         var5 = this.inputBanq.split(":");
         this.reglements.setRglCodeEmetrice(var5[0]);
         this.reglements.setRglLibEmetrice(var5[1]);
      } else {
         this.reglements.setRglCodeEmetrice((String)null);
         this.reglements.setRglLibEmetrice((String)null);
      }

      this.reglements.setRglCodeReceptrice((String)null);
      this.reglements.setRglLibReceptrice((String)null);
      String var12;
      if (this.decoupageActivite) {
         var12 = "";
         boolean var6 = true;
         if (this.lesDecoupagesActivites.size() != 0) {
            for(int var7 = 0; var7 < this.lesDecoupagesActivites.size(); ++var7) {
               this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var7);
               if (var6) {
                  var12 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  var6 = false;
               } else {
                  var12 = var12 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               }
            }
         }

         this.reglements.setRglActivite(var12);
      }

      this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
      this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
      this.reglements.setRglActiviteExo(this.memoExoTaxe);
      this.reglements.setRglDateCreation(new Date());
      this.reglements.setRglDateImp((Date)null);
      this.reglements.setRglDateTransfert((Date)null);
      this.reglements.setRglDateValeur((Date)null);
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(0L);
      if (this.caissesOperations.getCaiopeCategorie() == 4) {
         this.reglements.setRglIdTiers(0L);
      } else if (this.tiers != null) {
         this.reglements.setRglIdTiers(this.tiers.getTieid());
      } else {
         this.reglements.setRglIdTiers(0L);
      }

      if (!this.reglements.getRglOperation().equals("13") && !this.reglements.getRglOperation().equals("15")) {
         this.reglements.setRglDepotTiers(0);
      } else {
         this.reglements.setRglDepotTiers(1);
         this.reglements.setRglLibelle("(déposit) " + this.reglements.getRglLibelle());
         this.reglements.setRglObjet("(déposit) " + this.reglements.getRglObjet());
      }

      this.reglements.setRglMode(this.var_modeReglement);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglIdContact(0L);
      this.reglements.setRglNomContact("");
      this.reglements.setRglNum(var1);
      if (this.formAnalytique != null && this.var_parc) {
         this.reglements.setRglParc(this.formAnalytique.calculeValeurListe07());
      } else {
         this.reglements.setRglParc("");
      }

      this.reglements.setRglRecette(var3);
      this.reglements.setRglTimbre(this.var_timbre);
      this.reglements.setRglTrf(0);
      if (this.caissesOperations.getCaiopeCategorie() == 4) {
         this.reglements.setRglTypeTiers(3);
      } else {
         this.reglements.setRglTypeTiers(0);
      }

      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      var12 = "";
      if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
         var12 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
      } else {
         var12 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
      }

      String var13 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
      this.reglements.setRglPeriode(var12 + ":" + var13);
      this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
      String var14 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
      this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var14);
      this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
      this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var14);
      this.reglements.setExercicesCaisse(this.selectedExo);
      this.reglements = this.reglementsDao.insert(this.reglements, var2);
      new Reglements();
      Reglements var8 = this.reglements;
      if (this.var_garde && this.var_montant_rendu != 0.0D && this.caissesOperations.getCaiopeCategorie() != 4) {
         this.reglements = new Reglements();
         this.reglements.setRglDateReg(var8.getRglDateReg());
         this.reglements.setRglActivite(var8.getRglActivite());
         this.reglements.setRglBanqueTireur(var8.getRglBanqueTireur());
         this.reglements.setRglBudget(var8.getRglBudget());
         this.reglements.setRglBon(var8.getRglNum());
         this.reglements.setRglCategorie(20);
         if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
            String[] var9 = this.var_caisse.split(":");
            this.reglements.setRglCodeCaiss(var9[0]);
            this.reglements.setRglLibCaiss(var9[1]);
         } else {
            this.reglements.setRglCodeCaiss((String)null);
            this.reglements.setRglLibCaiss((String)null);
         }

         this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
         this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
         this.reglements.setRglActiviteExo(this.memoExoTaxe);
         this.reglements.setRglCodeEmetrice(var8.getRglCodeEmetrice());
         this.reglements.setRglCodeReceptrice((String)null);
         this.reglements.setRglDateCreation(new Date());
         this.reglements.setRglDateImp((Date)null);
         this.reglements.setRglDateTransfert((Date)null);
         this.reglements.setRglDateValeur((Date)null);
         this.reglements.setRglDepartement(var8.getRglDepartement());
         this.reglements.setRglDepense(0.0D);
         this.reglements.setRglDevise(var8.getRglDevise());
         this.reglements.setRglDossier(var8.getRglDossier());
         this.reglements.setRglFormatDevise(this.calculformatDevise(var8.getRglDevise()));
         this.reglements.setRglDocument(var8.getRglDocument());
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(0L);
         this.reglements.setRglIdTiers(var8.getRglIdTiers());
         this.reglements.setRglDepotTiers(1);
         this.reglements.setRglLibEmetrice(var8.getRglLibEmetrice());
         this.reglements.setRglLibReceptrice((String)null);
         this.reglements.setRglLibelle("(déposit) " + var8.getRglLibelle());
         this.reglements.setRglMode(this.var_modeReglement);
         this.reglements.setRglModele(var8.getRglModele());
         this.reglements.setRglNumChqBdx(var8.getRglNumChqBdx());
         this.reglements.setRglNatureDoc(var8.getRglNatureDoc());
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglNomResponsable(var8.getRglNomResponsable());
         this.reglements.setRglNomTiers(var8.getRglNomTiers());
         this.reglements.setRglNum(var1);
         this.reglements.setRglObjet("(déposit) " + var8.getRglObjet());
         this.reglements.setRglParc("");
         this.reglements.setRglPdv(var8.getRglPdv());
         this.reglements.setRglRecette(this.var_montant_rendu);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglRegion(var8.getRglRegion());
         this.reglements.setRglSecteur(var8.getRglSecteur());
         this.reglements.setRglSerie(var8.getRglSerie());
         this.reglements.setRglService(var8.getRglService());
         this.reglements.setRglSite(var8.getRglSite());
         this.reglements.setRglTrf(0);
         this.reglements.setRglTypeReg(var8.getRglTypeReg());
         this.reglements.setRglTypeTiers(0);
         this.reglements.setRglUserCreat(this.usersLog.getUsrid());
         this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
         this.reglements.setRglUserModif(0L);
         this.reglements.setRglPeriode(var12 + ":" + var13);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var14);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var14);
         this.reglements.setExercicesCaisse(this.selectedExo);
         this.reglementsDao.insert(this.reglements, var2);
         this.reglements = var8;
      }

      if (this.reglements.getRglDepotTiers() == 1 && var8 != null) {
         if (var8.getRglOperation() != null && !var8.getRglOperation().isEmpty() && var8.getRglOperation().equals("13")) {
            this.var_montant_rendu = var8.getRglRecette();
         }

         this.tiers = new Tiers();
         TiersDao var15 = new TiersDao(this.baseLog, this.utilInitHibernate);
         this.tiers = var15.selectTierD(var8.getRglIdTiers(), var2);
         if (this.tiers != null) {
            double var10 = this.tiers.getTiedepotavance() + this.var_montant_rendu;
            this.tiers.setTiedepotavance(var10);
            var15.modif(this.tiers, var2);
         }
      }

   }

   public void casClientPaiementCommande(String var1, Session var2) throws HibernateException, NamingException {
      double var3 = this.var_aEncaisser;
      Date var5 = this.reglements.getRglDateReg();
      int var6 = this.reglements.getRglTypeReg();
      String var7 = this.reglements.getRglDevise();
      String var8 = this.reglements.getRglObjet();
      String var9 = this.reglements.getRglLibelle();
      String var10 = this.reglements.getRglBanqueTireur();
      String var11 = this.reglements.getRglNumChqBdx();
      Date var12 = this.reglements.getRglDateValeur();
      new CommandeEnteteVentes();

      for(int var14 = 0; var14 < this.listCommande.size(); ++var14) {
         CommandeEnteteVentes var13 = (CommandeEnteteVentes)this.listCommande.get(var14);
         if (var13.isVar_select_ligne() && var3 != 0.0D) {
            this.reglements = new Reglements();
            if (this.caissesOperations != null) {
               this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
            } else {
               this.reglements.setRglOperation("");
            }

            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(20);
            String[] var15;
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
               var15 = this.var_caisse.split(":");
               this.reglements.setRglCodeCaiss(var15[0]);
               this.reglements.setRglLibCaiss(var15[1]);
            } else {
               this.reglements.setRglCodeCaiss((String)null);
               this.reglements.setRglLibCaiss((String)null);
            }

            if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
               var15 = this.inputBanq.split(":");
               this.reglements.setRglCodeEmetrice(var15[0]);
               this.reglements.setRglLibEmetrice(var15[1]);
            } else {
               this.reglements.setRglCodeEmetrice((String)null);
               this.reglements.setRglLibEmetrice((String)null);
            }

            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
            String var19;
            if (this.decoupageActivite) {
               var19 = "";
               boolean var16 = true;
               if (this.lesDecoupagesActivites.size() != 0) {
                  for(int var17 = 0; var17 < this.lesDecoupagesActivites.size(); ++var17) {
                     this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var17);
                     if (var16) {
                        var19 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var16 = false;
                     } else {
                        var19 = var19 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }

               this.reglements.setRglActivite(var19);
            }

            this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
            this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
            this.reglements.setRglActiviteExo(this.memoExoTaxe);
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur(var12);
            this.reglements.setRglDateReg(var5);
            this.reglements.setRglDevise(var7);
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglDocument(var13.getBcmNum());
            this.reglements.setRglFormatDevise(this.calculformatDevise(var13.getBcmDevise()));
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(var13.getBcmId());
            this.reglements.setRglIdTiers(var13.getTiers().getTieid());
            this.reglements.setRglDepotTiers(0);
            this.reglements.setRglMode(this.var_modeReglement);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglIdContact(var13.getBcmIdContact());
            this.reglements.setRglNomContact(var13.getBcmNomContact());
            this.reglements.setRglNum(var1);
            this.reglements.setRglObjet(var13.getBcmObject());
            this.reglements.setRglLibelle(var9);
            this.reglements.setRglBanqueTireur(var10);
            this.reglements.setRglNumChqBdx(var11);
            this.reglements.setRglSerie(var13.getBcmSerie());
            this.reglements.setRglNatureDoc(22);
            this.reglements.setRglNomTiers(var13.getBcmNomTiers());
            this.reglements.setRglNomResponsable(var13.getBcmNomResponsable());
            this.reglements.setRglIdResponsable(var13.getBcmIdResponsable());
            this.reglements.setRglNomCommercial(var13.getBcmNomCommercial());
            this.reglements.setRglIdCommercial(var13.getBcmIdCommercial());
            this.reglements.setRglTypeReg(var6);
            this.reglements.setRglMode("" + var6);
            if (this.formAnalytique != null && this.var_parc) {
               this.reglements.setRglParc(this.formAnalytique.calculeValeurListe07());
            } else {
               this.reglements.setRglParc("");
            }

            if (var3 >= var13.getBcmTotTtc() + var13.getBcmTotTc() - var13.getBcmTotReglement()) {
               this.reglements.setRglRecette(var13.getBcmTotTtc() + var13.getBcmTotTc() - var13.getBcmTotReglement());
               var3 -= this.reglements.getRglRecette();
            } else {
               this.reglements.setRglRecette(var3);
               var3 = 0.0D;
            }

            if (this.reglements.getRglTypeReg() == 0) {
               this.reglements.setRglTimbre(this.calculTimbreVentesPiece(this.reglements.getRglRecette(), this.reglements.getRglDevise(), var2));
            } else {
               this.reglements.setRglTimbre(0.0D);
            }

            this.reglements.setRglTrf(0);
            this.reglements.setRglTypeTiers(0);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
            this.reglements.setRglUserModif(0L);
            var19 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var19 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var19 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            String var20 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var19 + ":" + var20);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            String var21 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var21);
            this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
            this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var21);
            this.reglements.setExercicesCaisse(this.selectedExo);
            this.reglements = this.reglementsDao.insert(this.reglements, var2);
            if (var13 != null) {
               var13.setBcmTotReglement(var13.getBcmTotReglement() + this.reglements.getRglRecette());
               if (var13.getBcmTotReglement() >= var13.getBcmTotTtc() + var13.getBcmTotTc()) {
                  var13.setBcmSolde(1);
               } else {
                  var13.setBcmSolde(0);
               }

               this.commandeEnteteVentesDao.modif(var13, var2);
            }

            new Reglements();
            Reglements var18 = this.reglements;
         }
      }

   }

   public void casClientPaiementLivraison(String var1, Session var2) throws HibernateException, NamingException {
      double var3 = this.var_aEncaisser;
      Date var5 = this.reglements.getRglDateReg();
      int var6 = this.reglements.getRglTypeReg();
      String var7 = this.reglements.getRglDevise();
      String var8 = this.reglements.getRglObjet();
      String var9 = this.reglements.getRglLibelle();
      String var10 = this.reglements.getRglBanqueTireur();
      String var11 = this.reglements.getRglNumChqBdx();
      Date var12 = this.reglements.getRglDateValeur();
      new LivraisonEnteteVentes();

      for(int var14 = 0; var14 < this.listLivraison.size(); ++var14) {
         LivraisonEnteteVentes var13 = (LivraisonEnteteVentes)this.listLivraison.get(var14);
         if (var13.isVar_select_ligne() && var3 != 0.0D) {
            this.reglements = new Reglements();
            if (this.caissesOperations != null) {
               this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
            } else {
               this.reglements.setRglOperation("");
            }

            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(20);
            String[] var15;
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
               var15 = this.var_caisse.split(":");
               this.reglements.setRglCodeCaiss(var15[0]);
               this.reglements.setRglLibCaiss(var15[1]);
            } else {
               this.reglements.setRglCodeCaiss((String)null);
               this.reglements.setRglLibCaiss((String)null);
            }

            if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
               var15 = this.inputBanq.split(":");
               this.reglements.setRglCodeEmetrice(var15[0]);
               this.reglements.setRglLibEmetrice(var15[1]);
            } else {
               this.reglements.setRglCodeEmetrice((String)null);
               this.reglements.setRglLibEmetrice((String)null);
            }

            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
            String var19;
            if (this.decoupageActivite) {
               var19 = "";
               boolean var16 = true;
               if (this.lesDecoupagesActivites.size() != 0) {
                  for(int var17 = 0; var17 < this.lesDecoupagesActivites.size(); ++var17) {
                     this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var17);
                     if (var16) {
                        var19 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var16 = false;
                     } else {
                        var19 = var19 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }

               this.reglements.setRglActivite(var19);
            }

            this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
            this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
            this.reglements.setRglActiviteExo(this.memoExoTaxe);
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur(var12);
            this.reglements.setRglDateReg(var5);
            this.reglements.setRglDevise(var7);
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglDocument(var13.getBlvNum());
            this.reglements.setRglFormatDevise(this.calculformatDevise(var13.getBlvDevise()));
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(var13.getBlvId());
            this.reglements.setRglIdTiers(var13.getTiers().getTieid());
            this.reglements.setRglDepotTiers(0);
            this.reglements.setRglMode(this.var_modeReglement);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglIdContact(var13.getBlvIdContact());
            this.reglements.setRglNomContact(var13.getBlvNomContact());
            this.reglements.setRglNum(var1);
            this.reglements.setRglObjet(var13.getBlvObject());
            this.reglements.setRglLibelle(var9);
            this.reglements.setRglBanqueTireur(var10);
            this.reglements.setRglNumChqBdx(var11);
            this.reglements.setRglSerie(var13.getBlvSerie());
            this.reglements.setRglNatureDoc(23);
            this.reglements.setRglNomTiers(var13.getBlvNomTiers());
            this.reglements.setRglNomResponsable(var13.getBlvNomResponsable());
            this.reglements.setRglIdResponsable(var13.getBlvIdResponsable());
            this.reglements.setRglNomCommercial(var13.getBlvNomCommercial());
            this.reglements.setRglIdCommercial(var13.getBlvIdCommercial());
            this.reglements.setRglTypeReg(var6);
            this.reglements.setRglMode("" + var6);
            if (this.formAnalytique != null && this.var_parc) {
               this.reglements.setRglParc(this.formAnalytique.calculeValeurListe07());
            } else {
               this.reglements.setRglParc("");
            }

            if (var3 >= var13.getBlvTotTtc() + var13.getBlvTotTc() - var13.getBlvTotReglement()) {
               this.reglements.setRglRecette(var13.getBlvTotTtc() + var13.getBlvTotTc() - var13.getBlvTotReglement());
               var3 -= this.reglements.getRglRecette();
            } else {
               this.reglements.setRglRecette(var3);
               var3 = 0.0D;
            }

            if (this.reglements.getRglTypeReg() == 0) {
               this.reglements.setRglTimbre(this.calculTimbreVentesPiece(this.reglements.getRglRecette(), this.reglements.getRglDevise(), var2));
            } else {
               this.reglements.setRglTimbre(0.0D);
            }

            this.reglements.setRglTrf(0);
            this.reglements.setRglTypeTiers(0);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
            this.reglements.setRglUserModif(0L);
            var19 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var19 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var19 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            String var20 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var19 + ":" + var20);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            String var21 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var21);
            this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
            this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var21);
            this.reglements.setExercicesCaisse(this.selectedExo);
            this.reglements = this.reglementsDao.insert(this.reglements, var2);
            if (var13 != null) {
               var13.setBlvTotReglement(var13.getBlvTotReglement() + this.reglements.getRglRecette());
               if (var13.getBlvTotReglement() >= var13.getBlvTotTtc() + var13.getBlvTotTc()) {
                  var13.setBlvSolde(1);
               } else {
                  var13.setBlvSolde(0);
               }

               this.livraisonEnteteVentesDao.modif(var13, var2);
            }

            new Reglements();
            Reglements var18 = this.reglements;
         }
      }

   }

   public void casClientPaiementFacture(String var1, Session var2) throws HibernateException, NamingException {
      double var3 = this.var_aEncaisser;
      Date var5 = this.reglements.getRglDateReg();
      int var6 = this.reglements.getRglTypeReg();
      String var7 = this.reglements.getRglDevise();
      String var8 = this.reglements.getRglObjet();
      String var9 = this.reglements.getRglLibelle();
      String var10 = this.reglements.getRglBanqueTireur();
      String var11 = this.reglements.getRglNumChqBdx();
      Date var12 = this.reglements.getRglDateValeur();
      new FactureEnteteVentes();

      for(int var14 = 0; var14 < this.listFacture.size(); ++var14) {
         FactureEnteteVentes var13 = (FactureEnteteVentes)this.listFacture.get(var14);
         if (var13.isVar_select_ligne() && var3 != 0.0D) {
            this.reglements = new Reglements();
            if (this.caissesOperations != null) {
               this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
            } else {
               this.reglements.setRglOperation("");
            }

            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(20);
            String[] var15;
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
               var15 = this.var_caisse.split(":");
               this.reglements.setRglCodeCaiss(var15[0]);
               this.reglements.setRglLibCaiss(var15[1]);
            } else {
               this.reglements.setRglCodeCaiss((String)null);
               this.reglements.setRglLibCaiss((String)null);
            }

            if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
               var15 = this.inputBanq.split(":");
               this.reglements.setRglCodeEmetrice(var15[0]);
               this.reglements.setRglLibEmetrice(var15[1]);
            } else {
               this.reglements.setRglCodeEmetrice((String)null);
               this.reglements.setRglLibEmetrice((String)null);
            }

            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
            String var19;
            if (this.decoupageActivite) {
               var19 = "";
               boolean var16 = true;
               if (this.lesDecoupagesActivites.size() != 0) {
                  for(int var17 = 0; var17 < this.lesDecoupagesActivites.size(); ++var17) {
                     this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var17);
                     if (var16) {
                        var19 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var16 = false;
                     } else {
                        var19 = var19 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }

               this.reglements.setRglActivite(var19);
            }

            this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
            this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
            this.reglements.setRglActiviteExo(this.memoExoTaxe);
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur(var12);
            this.reglements.setRglDateReg(var5);
            this.reglements.setRglDevise(var7);
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglDocument(var13.getFacNum());
            this.reglements.setRglFormatDevise(this.calculformatDevise(var13.getFacDevise()));
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(var13.getFacId());
            this.reglements.setRglIdTiers(var13.getTiers().getTieid());
            if (this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && (this.reglements.getRglOperation().equals("13") || this.reglements.getRglOperation().equals("15"))) {
               this.reglements.setRglDepotTiers(1);
               this.reglements.setRglLibelle("(déposit) " + this.reglements.getRglLibelle());
               this.reglements.setRglObjet("(déposit) " + this.reglements.getRglObjet());
            } else {
               this.reglements.setRglDepotTiers(0);
            }

            this.reglements.setRglMode(this.var_modeReglement);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglIdContact(var13.getFacIdContact());
            this.reglements.setRglNomContact(var13.getFacNomContact());
            this.reglements.setRglNum(var1);
            this.reglements.setRglObjet(var13.getFacObject());
            this.reglements.setRglLibelle(var9);
            this.reglements.setRglBanqueTireur(var10);
            this.reglements.setRglNumChqBdx(var11);
            this.reglements.setRglSerie(var13.getFacSerie());
            this.reglements.setRglNatureDoc(25);
            this.reglements.setRglNomTiers(var13.getFacNomTiers());
            this.reglements.setRglNomResponsable(var13.getFacNomResponsable());
            this.reglements.setRglIdResponsable(var13.getFacIdResponsable());
            this.reglements.setRglNomCommercial(var13.getFacNomCommercial());
            this.reglements.setRglIdCommercial(var13.getFacIdCommercial());
            this.reglements.setRglTypeReg(var6);
            this.reglements.setRglMode("" + var6);
            if (this.formAnalytique != null && this.var_parc) {
               this.reglements.setRglParc(this.formAnalytique.calculeValeurListe07());
            } else {
               this.reglements.setRglParc("");
            }

            if (var3 >= var13.getFacTotTtc() + var13.getFacTotTc() - var13.getFacTotReglement()) {
               this.reglements.setRglRecette(var13.getFacTotTtc() + var13.getFacTotTc() - var13.getFacTotReglement());
               var3 -= this.reglements.getRglRecette();
            } else {
               this.reglements.setRglRecette(var3);
               var3 = 0.0D;
            }

            if (this.reglements.getRglTypeReg() == 0) {
               this.reglements.setRglTimbre(this.calculTimbreVentesPiece(this.reglements.getRglRecette(), this.reglements.getRglDevise(), var2));
            } else {
               this.reglements.setRglTimbre(0.0D);
            }

            this.reglements.setRglTrf(0);
            this.reglements.setRglTypeTiers(0);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
            this.reglements.setRglUserModif(0L);
            var19 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var19 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var19 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            String var20 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var19 + ":" + var20);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            String var21 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var21);
            this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
            this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var21);
            this.reglements.setExercicesCaisse(this.selectedExo);
            this.reglements = this.reglementsDao.insert(this.reglements, var2);
            if (var13 != null) {
               var13.setFacTotReglement(var13.getFacTotReglement() + this.reglements.getRglRecette());
               if (var13.getFacTotReglement() >= var13.getFacTotTtc() + var13.getFacTotTc()) {
                  var13.setFacSolde(1);
               } else {
                  var13.setFacSolde(0);
               }

               this.factureEnteteVentesDao.modif(var13, var2);
            }

            new Reglements();
            Reglements var18 = this.reglements;
         }
      }

   }

   public void casPatient() throws HibernateException, NamingException {
      double var1 = 0.0D;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementMedical");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         this.chargerCaisse(var3);
         String var5 = "";
         if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
            var5 = this.calculChrono.numCompose(new Date(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var3);
         } else {
            var5 = this.calculChrono.numComposeCaisse(new Date(), this.natCaisse, this.serieCaisse, this.var_caisse, var3);
         }

         String[] var6;
         boolean var7;
         int var8;
         String var19;
         String var20;
         String var21;
         if (this.caissesOperations.getCaiopeCode().equals("19")) {
            if (this.caissesOperations != null) {
               this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
            } else {
               this.reglements.setRglOperation("");
            }

            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(30);
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
               var6 = this.var_caisse.split(":");
               this.reglements.setRglCodeCaiss(var6[0]);
               this.reglements.setRglLibCaiss(var6[1]);
            } else {
               this.reglements.setRglCodeCaiss((String)null);
               this.reglements.setRglLibCaiss((String)null);
            }

            if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
               var6 = this.inputBanq.split(":");
               this.reglements.setRglCodeEmetrice(var6[0]);
               this.reglements.setRglLibEmetrice(var6[1]);
            } else {
               this.reglements.setRglCodeEmetrice((String)null);
               this.reglements.setRglLibEmetrice((String)null);
            }

            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
            if (this.decoupageActivite) {
               var19 = "";
               var7 = true;
               if (this.lesDecoupagesActivites.size() != 0) {
                  for(var8 = 0; var8 < this.lesDecoupagesActivites.size(); ++var8) {
                     this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var8);
                     if (var7) {
                        var19 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var7 = false;
                     } else {
                        var19 = var19 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }

               this.reglements.setRglActivite(var19);
            }

            this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
            this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
            this.reglements.setRglActiviteExo(this.memoExoTaxe);
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdTiers(this.tiers.getTieid());
            this.reglements.setRglDepotTiers(0);
            this.reglements.setRglMode("1");
            this.reglements.setRglTypeReg(1);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglIdContact(0L);
            this.reglements.setRglNomContact("");
            this.reglements.setRglNum(var5);
            this.reglements.setRglParc("");
            this.reglements.setRglRecette(this.reglements.getVal_recette() * -1.0D);
            this.reglements.setRglTimbre(this.var_timbre);
            this.reglements.setRglTrf(0);
            if (this.caissesOperations.getCaiopeCategorie() == 4) {
               this.reglements.setRglTypeTiers(3);
            } else {
               this.reglements.setRglTypeTiers(0);
            }

            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
            this.reglements.setRglUserModif(0L);
            var19 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var19 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var19 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            var20 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var19 + ":" + var20);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            var21 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var21);
            this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
            this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var21);
            this.reglements.setExercicesCaisse(this.selectedExo);
            this.reglements = this.reglementsDao.insert(this.reglements, var3);
            new Reglements();
            Reglements var9 = this.reglements;
            if (this.reglements.getRglFrais() != 0.0D) {
               this.reglements = new Reglements();
               this.reglements.setRglOperation(var9.getRglOperation());
               this.reglements.setRglDateReg(var9.getRglDateReg());
               this.reglements.setRglActivite(var9.getRglActivite());
               this.reglements.setRglBanqueTireur(var9.getRglBanqueTireur());
               this.reglements.setRglBudget(var9.getRglBudget());
               this.reglements.setRglBon(var9.getRglNum());
               this.reglements.setRglCategorie(30);
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                  String[] var10 = this.var_caisse.split(":");
                  this.reglements.setRglCodeCaiss(var10[0]);
                  this.reglements.setRglLibCaiss(var10[1]);
               } else {
                  this.reglements.setRglCodeCaiss((String)null);
                  this.reglements.setRglLibCaiss((String)null);
               }

               this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
               this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
               this.reglements.setRglActiviteExo(this.memoExoTaxe);
               this.reglements.setRglCodeEmetrice(var9.getRglCodeEmetrice());
               this.reglements.setRglCodeReceptrice((String)null);
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepartement(var9.getRglDepartement());
               this.reglements.setRglDepense(0.0D);
               this.reglements.setRglDevise(var9.getRglDevise());
               this.reglements.setRglDossier(var9.getRglDossier());
               this.reglements.setRglFormatDevise(this.calculformatDevise(var9.getRglDevise()));
               this.reglements.setRglDocument(var9.getRglDocument());
               this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
               this.reglements.setRglIdBon(0L);
               this.reglements.setRglIdDocument(var9.getRglIdDocument());
               this.reglements.setRglIdTiers(var9.getRglIdTiers());
               this.reglements.setRglDepotTiers(0);
               this.reglements.setRglLibEmetrice(var9.getRglLibEmetrice());
               this.reglements.setRglLibReceptrice((String)null);
               this.reglements.setRglLibelle("(Frais impayés)");
               this.reglements.setRglMode(var9.getRglMode());
               this.reglements.setRglModele(var9.getRglModele());
               this.reglements.setRglNumChqBdx(var9.getRglNumChqBdx());
               this.reglements.setRglNatureDoc(var9.getRglNatureDoc());
               this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
               this.reglements.setRglNomResponsable(var9.getRglNomResponsable());
               this.reglements.setRglNomTiers(var9.getRglNomTiers());
               this.reglements.setRglNum(var5);
               this.reglements.setRglObjet("(Frais impayés)");
               this.reglements.setRglParc("");
               this.reglements.setRglPdv(var9.getRglPdv());
               this.reglements.setRglRecette(var9.getRglFrais());
               this.reglements.setRglTimbre(0.0D);
               this.reglements.setRglRegion(var9.getRglRegion());
               this.reglements.setRglSecteur(var9.getRglSecteur());
               this.reglements.setRglSerie(var9.getRglSerie());
               this.reglements.setRglService(var9.getRglService());
               this.reglements.setRglSite(var9.getRglSite());
               this.reglements.setRglTrf(0);
               this.reglements.setRglTypeReg(var9.getRglTypeReg());
               this.reglements.setRglTypeTiers(4);
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
               this.reglements.setRglUserModif(0L);
               this.reglements.setRglPeriode(var19 + ":" + var20);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var21);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var21);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglementsDao.insert(this.reglements, var3);
            }

            if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglDocument() != null && !this.reglements.getRglDocument().isEmpty()) {
               double var12;
               if (this.reglements.getRglNatureDoc() == 71) {
                  new ConsultationEnteteGene();
                  ConsultationEnteteGeneDao var11 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
                  ConsultationEnteteGene var22 = var11.selectById(this.bonEncaissementVente.getBonIdRef(), var3);
                  if (var22 != null) {
                     var12 = var22.getCsgRegPatient() - (Math.abs(var9.getRglRecette()) + var9.getRglFrais());
                     var22.setCsgRegPatient(var12);
                     var22.setCsgSoldePatient(0);
                     var11.modif(var22, var3);
                  }
               } else if (this.reglements.getRglNatureDoc() == 76) {
                  new HospitalisationEntete();
                  HospitalisationEnteteDao var24 = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
                  HospitalisationEntete var23 = var24.selectById(this.bonEncaissementVente.getBonIdRef(), var3);
                  if (var23 != null) {
                     var12 = var23.getHosRegPatient() - (Math.abs(var9.getRglRecette()) + var9.getRglFrais());
                     var23.setHosRegPatient(var12);
                     var23.setHosSoldePatient(0);
                     var24.modif(var23, var3);
                  }
               }
            }
         } else {
            var1 = this.var_aEncaisser;
            if (this.caissesOperations != null) {
               this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
            } else {
               this.reglements.setRglOperation("");
            }

            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(30);
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
               var6 = this.var_caisse.split(":");
               this.reglements.setRglCodeCaiss(var6[0]);
               this.reglements.setRglLibCaiss(var6[1]);
            } else {
               this.reglements.setRglCodeCaiss((String)null);
               this.reglements.setRglLibCaiss((String)null);
            }

            if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
               var6 = this.inputBanq.split(":");
               this.reglements.setRglCodeEmetrice(var6[0]);
               this.reglements.setRglLibEmetrice(var6[1]);
            } else {
               this.reglements.setRglCodeEmetrice((String)null);
               this.reglements.setRglLibEmetrice((String)null);
            }

            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
            if (this.decoupageActivite) {
               var19 = "";
               var7 = true;
               if (this.lesDecoupagesActivites.size() != 0) {
                  for(var8 = 0; var8 < this.lesDecoupagesActivites.size(); ++var8) {
                     this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var8);
                     if (var7) {
                        var19 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var7 = false;
                     } else {
                        var19 = var19 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }

               this.reglements.setRglActivite(var19);
            }

            this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
            this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
            this.reglements.setRglActiviteExo(this.memoExoTaxe);
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(0L);
            this.reglements.setRglIdTiers(this.tiers.getTieid());
            this.reglements.setRglDepotTiers(0);
            this.reglements.setRglMode(this.var_modeReglement);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglIdContact(0L);
            this.reglements.setRglNomContact("");
            this.reglements.setRglNum(var5);
            this.reglements.setRglParc("");
            this.reglements.setRglRecette(var1);
            this.reglements.setRglTimbre(this.var_timbre);
            this.reglements.setRglTrf(0);
            this.reglements.setRglTypeTiers(4);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
            this.reglements.setRglUserModif(0L);
            var19 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var19 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var19 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            var20 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var19 + ":" + var20);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            var21 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var21);
            this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
            this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var21);
            this.reglements.setExercicesCaisse(this.selectedExo);
            this.reglements = this.reglementsDao.insert(this.reglements, var3);
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

   public void casEleve() throws HibernateException, NamingException {
      double var1 = 0.0D;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         this.chargerCaisse(var3);
         String var5 = "";
         if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
            var5 = this.calculChrono.numCompose(new Date(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var3);
         } else {
            var5 = this.calculChrono.numComposeCaisse(new Date(), this.natCaisse, this.serieCaisse, this.var_caisse, var3);
         }

         String[] var6;
         boolean var7;
         int var8;
         Reglements var9;
         String[] var10;
         String var18;
         String var19;
         String var20;
         if (this.caissesOperations.getCaiopeCode().equals("19")) {
            if (this.caissesOperations != null) {
               this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
            } else {
               this.reglements.setRglOperation("");
            }

            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(40);
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
               var6 = this.var_caisse.split(":");
               this.reglements.setRglCodeCaiss(var6[0]);
               this.reglements.setRglLibCaiss(var6[1]);
            } else {
               this.reglements.setRglCodeCaiss((String)null);
               this.reglements.setRglLibCaiss((String)null);
            }

            if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
               var6 = this.inputBanq.split(":");
               this.reglements.setRglCodeEmetrice(var6[0]);
               this.reglements.setRglLibEmetrice(var6[1]);
            } else {
               this.reglements.setRglCodeEmetrice((String)null);
               this.reglements.setRglLibEmetrice((String)null);
            }

            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
            if (this.decoupageActivite) {
               var18 = "";
               var7 = true;
               if (this.lesDecoupagesActivites.size() != 0) {
                  for(var8 = 0; var8 < this.lesDecoupagesActivites.size(); ++var8) {
                     this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var8);
                     if (var7) {
                        var18 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var7 = false;
                     } else {
                        var18 = var18 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }

               this.reglements.setRglActivite(var18);
            }

            this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
            this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
            this.reglements.setRglActiviteExo(this.memoExoTaxe);
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDepense(this.reglements.getVal_recette());
            this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdTiers(this.eleves.getEleId());
            this.reglements.setRglDepotTiers(0);
            this.reglements.setRglMode("1");
            this.reglements.setRglTypeReg(1);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglIdContact(0L);
            this.reglements.setRglNomContact("");
            this.reglements.setRglNum(var5);
            this.reglements.setRglParc("");
            this.reglements.setRglRecette(0.0D);
            this.reglements.setRglTimbre(this.var_timbre);
            this.reglements.setRglTrf(0);
            this.reglements.setRglTypeTiers(5);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
            this.reglements.setRglUserModif(0L);
            var18 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var18 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var18 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            var19 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var18 + ":" + var19);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            var20 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var20);
            this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
            this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var20);
            this.reglements.setExercicesCaisse(this.selectedExo);
            this.reglements = this.reglementsDao.insert(this.reglements, var3);
            new Reglements();
            var9 = this.reglements;
            if (this.reglements.getRglFrais() != 0.0D) {
               this.reglements = new Reglements();
               this.reglements.setRglOperation(var9.getRglOperation());
               this.reglements.setRglDateReg(var9.getRglDateReg());
               this.reglements.setRglActivite(var9.getRglActivite());
               this.reglements.setRglBanqueTireur(var9.getRglBanqueTireur());
               this.reglements.setRglBudget(var9.getRglBudget());
               this.reglements.setRglBon(var9.getRglNum());
               this.reglements.setRglCategorie(20);
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                  var10 = this.var_caisse.split(":");
                  this.reglements.setRglCodeCaiss(var10[0]);
                  this.reglements.setRglLibCaiss(var10[1]);
               } else {
                  this.reglements.setRglCodeCaiss((String)null);
                  this.reglements.setRglLibCaiss((String)null);
               }

               this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
               this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
               this.reglements.setRglActiviteExo(this.memoExoTaxe);
               this.reglements.setRglCodeEmetrice(var9.getRglCodeEmetrice());
               this.reglements.setRglCodeReceptrice((String)null);
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepartement(var9.getRglDepartement());
               this.reglements.setRglDepense(var9.getRglFrais());
               this.reglements.setRglDevise(var9.getRglDevise());
               this.reglements.setRglDossier(var9.getRglDossier());
               this.reglements.setRglFormatDevise(this.calculformatDevise(var9.getRglDevise()));
               this.reglements.setRglDocument(var9.getRglDocument());
               this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
               this.reglements.setRglIdBon(0L);
               this.reglements.setRglIdDocument(var9.getRglIdDocument());
               this.reglements.setRglIdTiers(var9.getRglIdTiers());
               this.reglements.setRglDepotTiers(0);
               this.reglements.setRglLibEmetrice(var9.getRglLibEmetrice());
               this.reglements.setRglLibReceptrice((String)null);
               this.reglements.setRglLibelle("(Frais impayés)");
               this.reglements.setRglMode(var9.getRglMode());
               this.reglements.setRglModele(var9.getRglModele());
               this.reglements.setRglNumChqBdx(var9.getRglNumChqBdx());
               this.reglements.setRglNatureDoc(var9.getRglNatureDoc());
               this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
               this.reglements.setRglNomResponsable(var9.getRglNomResponsable());
               this.reglements.setRglNomTiers(var9.getRglNomTiers());
               this.reglements.setRglNum(var5);
               this.reglements.setRglObjet("(Frais impayés)");
               this.reglements.setRglParc("");
               this.reglements.setRglPdv(var9.getRglPdv());
               this.reglements.setRglRecette(0.0D);
               this.reglements.setRglTimbre(0.0D);
               this.reglements.setRglRegion(var9.getRglRegion());
               this.reglements.setRglSecteur(var9.getRglSecteur());
               this.reglements.setRglSerie(var9.getRglSerie());
               this.reglements.setRglService(var9.getRglService());
               this.reglements.setRglSite(var9.getRglSite());
               this.reglements.setRglTrf(0);
               this.reglements.setRglTypeReg(var9.getRglTypeReg());
               this.reglements.setRglTypeTiers(0);
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
               this.reglements.setRglUserModif(0L);
               this.reglements.setRglPeriode(var18 + ":" + var19);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var20);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var20);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglementsDao.insert(this.reglements, var3);
            }

            if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglDocument() != null && !this.reglements.getRglDocument().isEmpty()) {
               new FactureEnteteVentes();
               FactureEnteteVentes var21 = this.factureEnteteVentesDao.pourParapheur(this.reglements.getRglIdDocument(), var3);
               if (var21 != null) {
                  double var11 = var21.getFacTotReglement() - (var9.getRglDepense() + var9.getRglFrais());
                  var21.setFacTotReglement(var11);
                  var21.setFacSolde(0);
                  this.factureEnteteVentesDao.modif(var21, var3);
               }
            }
         } else {
            if (this.var_garde) {
               var1 = this.var_aEncaisser + this.var_montant_rendu;
            } else {
               var1 = this.var_aEncaisser;
            }

            if (this.caissesOperations != null) {
               this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
            } else {
               this.reglements.setRglOperation("");
            }

            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(40);
            if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
               var6 = this.var_caisse.split(":");
               this.reglements.setRglCodeCaiss(var6[0]);
               this.reglements.setRglLibCaiss(var6[1]);
            } else {
               this.reglements.setRglCodeCaiss((String)null);
               this.reglements.setRglLibCaiss((String)null);
            }

            if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
               var6 = this.inputBanq.split(":");
               this.reglements.setRglCodeEmetrice(var6[0]);
               this.reglements.setRglLibEmetrice(var6[1]);
            } else {
               this.reglements.setRglCodeEmetrice((String)null);
               this.reglements.setRglLibEmetrice((String)null);
            }

            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
            if (this.decoupageActivite) {
               var18 = "";
               var7 = true;
               if (this.lesDecoupagesActivites.size() != 0) {
                  for(var8 = 0; var8 < this.lesDecoupagesActivites.size(); ++var8) {
                     this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var8);
                     if (var7) {
                        var18 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var7 = false;
                     } else {
                        var18 = var18 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":0:" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }

               this.reglements.setRglActivite(var18);
            }

            this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
            this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
            this.reglements.setRglActiviteExo(this.memoExoTaxe);
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(0L);
            this.reglements.setRglIdTiers(this.eleves.getEleId());
            this.reglements.setRglDepotTiers(0);
            this.reglements.setRglMode(this.var_modeReglement);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglIdContact(0L);
            this.reglements.setRglNomContact("");
            this.reglements.setRglNum(var5);
            this.reglements.setRglParc("");
            this.reglements.setRglRecette(var1);
            this.reglements.setRglTimbre(this.var_timbre);
            this.reglements.setRglTrf(0);
            this.reglements.setRglTypeTiers(5);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
            this.reglements.setRglUserModif(0L);
            var18 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var18 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var18 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            var19 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var18 + ":" + var19);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            var20 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var20);
            this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
            this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var20);
            this.reglements.setExercicesCaisse(this.selectedExo);
            this.reglements = this.reglementsDao.insert(this.reglements, var3);
            new Reglements();
            var9 = this.reglements;
            if (this.var_garde && this.var_montant_rendu != 0.0D && this.caissesOperations.getCaiopeCategorie() != 4) {
               this.reglements = new Reglements();
               this.reglements.setRglDateReg(var9.getRglDateReg());
               this.reglements.setRglActivite(var9.getRglActivite());
               this.reglements.setRglBanqueTireur(var9.getRglBanqueTireur());
               this.reglements.setRglBudget(var9.getRglBudget());
               this.reglements.setRglBon(var9.getRglNum());
               this.reglements.setRglCategorie(20);
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
                  var10 = this.var_caisse.split(":");
                  this.reglements.setRglCodeCaiss(var10[0]);
                  this.reglements.setRglLibCaiss(var10[1]);
               } else {
                  this.reglements.setRglCodeCaiss((String)null);
                  this.reglements.setRglLibCaiss((String)null);
               }

               this.reglements.setRglActiviteCompte(this.memoCompteTaxe);
               this.reglements.setRglActiviteTaux(this.memoTauxTaxe);
               this.reglements.setRglActiviteExo(this.memoExoTaxe);
               this.reglements.setRglCodeEmetrice(var9.getRglCodeEmetrice());
               this.reglements.setRglCodeReceptrice((String)null);
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepartement(var9.getRglDepartement());
               this.reglements.setRglDepense(0.0D);
               this.reglements.setRglDevise(var9.getRglDevise());
               this.reglements.setRglDossier(var9.getRglDossier());
               this.reglements.setRglFormatDevise(this.calculformatDevise(var9.getRglDevise()));
               this.reglements.setRglDocument("");
               this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
               this.reglements.setRglIdBon(0L);
               this.reglements.setRglIdDocument(0L);
               this.reglements.setRglIdTiers(var9.getRglIdTiers());
               this.reglements.setRglDepotTiers(1);
               this.reglements.setRglLibEmetrice(var9.getRglLibEmetrice());
               this.reglements.setRglLibReceptrice((String)null);
               this.reglements.setRglLibelle("(déposit) " + var9.getRglLibelle());
               this.reglements.setRglMode(this.var_modeReglement);
               this.reglements.setRglModele(var9.getRglModele());
               this.reglements.setRglNumChqBdx(var9.getRglNumChqBdx());
               this.reglements.setRglNatureDoc(var9.getRglNatureDoc());
               this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
               this.reglements.setRglNomResponsable(var9.getRglNomResponsable());
               this.reglements.setRglNomTiers(var9.getRglNomTiers());
               this.reglements.setRglNum(var5);
               this.reglements.setRglObjet("(déposit) " + var9.getRglObjet());
               this.reglements.setRglParc("");
               this.reglements.setRglPdv(var9.getRglPdv());
               this.reglements.setRglRecette(this.var_montant_rendu);
               this.reglements.setRglTimbre(0.0D);
               this.reglements.setRglRegion(var9.getRglRegion());
               this.reglements.setRglSecteur(var9.getRglSecteur());
               this.reglements.setRglSerie(var9.getRglSerie());
               this.reglements.setRglService(var9.getRglService());
               this.reglements.setRglSite(var9.getRglSite());
               this.reglements.setRglTrf(0);
               this.reglements.setRglTypeReg(var9.getRglTypeReg());
               this.reglements.setRglTypeTiers(0);
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
               this.reglements.setRglUserModif(0L);
               this.reglements.setRglPeriode(var18 + ":" + var19);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var20);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var20);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglementsDao.insert(this.reglements, var3);
               this.reglements = var9;
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

   public void casSalariePret() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.chargerCaisse(var1);
         String var3 = "";
         if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
            var3 = this.calculChrono.numCompose(new Date(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var1);
         } else {
            var3 = this.calculChrono.numComposeCaisse(new Date(), this.natCaisse, this.serieCaisse, this.var_caisse, var1);
         }

         if (this.caissesOperations != null) {
            this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
         } else {
            this.reglements.setRglOperation("");
         }

         this.reglements.setRglBon("");
         this.reglements.setRglCategorie(80);
         String[] var4;
         if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
            var4 = this.var_caisse.split(":");
            this.reglements.setRglCodeCaiss(var4[0]);
            this.reglements.setRglLibCaiss(var4[1]);
         } else {
            this.reglements.setRglCodeCaiss("");
            this.reglements.setRglLibCaiss("");
         }

         if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
            var4 = this.inputBanq.split(":");
            this.reglements.setRglCodeEmetrice(var4[0]);
            this.reglements.setRglLibEmetrice(var4[1]);
         } else {
            this.reglements.setRglCodeEmetrice((String)null);
            this.reglements.setRglLibEmetrice((String)null);
         }

         this.reglements.setRglActiviteCompte("");
         this.reglements.setRglActiviteTaux(0.0F);
         this.reglements.setRglActiviteExo(false);
         this.reglements.setRglCodeReceptrice((String)null);
         this.reglements.setRglLibReceptrice((String)null);
         this.reglements.setRglDateCreation(new Date());
         this.reglements.setRglDateImp((Date)null);
         this.reglements.setRglDateTransfert((Date)null);
         this.reglements.setRglDateValeur((Date)null);
         this.reglements.setRglDepense(0.0D);
         this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(0L);
         if (this.tiers != null) {
            this.reglements.setRglIdTiers(this.tiers.getTieid());
         } else {
            this.reglements.setRglIdTiers(0L);
         }

         this.reglements.setRglDepotTiers(0);
         this.reglements.setRglMode(this.var_modeReglement);
         this.reglements.setRglModele(this.var_modele);
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
         this.reglements.setRglNum(var3);
         this.reglements.setRglParc("");
         this.reglements.setRglRecette(this.var_aEncaisser);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglTrf(0);
         this.reglements.setRglTypeTiers(2);
         this.reglements.setRglUserCreat(this.usersLog.getUsrid());
         this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
         this.reglements.setRglUserModif(0L);
         String var12 = "";
         if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
            var12 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
         } else {
            var12 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
         }

         String var5 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
         this.reglements.setRglPeriode(var12 + ":" + var5);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         String var6 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var6);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var6);
         this.reglements.setExercicesCaisse(this.selectedExo);
         this.reglements = this.reglementsDao.insert(this.reglements, var1);
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

   public void casSalarieBulletin() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonDecaissementAchat");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.chargerCaisse(var1);
         String var3 = "";
         if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
            var3 = this.calculChrono.numCompose(new Date(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var1);
         } else {
            var3 = this.calculChrono.numComposeCaisse(new Date(), this.natCaisse, this.serieCaisse, this.var_caisse, var1);
         }

         if (this.caissesOperations != null) {
            this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
         } else {
            this.reglements.setRglOperation("");
         }

         this.reglements.setRglBon("");
         this.reglements.setRglCategorie(80);
         String[] var4;
         if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
            var4 = this.var_caisse.split(":");
            this.reglements.setRglCodeCaiss(var4[0]);
            this.reglements.setRglLibCaiss(var4[1]);
         } else {
            this.reglements.setRglCodeCaiss((String)null);
            this.reglements.setRglLibCaiss((String)null);
         }

         if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
            var4 = this.inputBanq.split(":");
            this.reglements.setRglCodeEmetrice(var4[0]);
            this.reglements.setRglLibEmetrice(var4[1]);
         } else {
            this.reglements.setRglCodeEmetrice((String)null);
            this.reglements.setRglLibEmetrice((String)null);
         }

         this.reglements.setRglActiviteCompte("");
         this.reglements.setRglActiviteTaux(0.0F);
         this.reglements.setRglActiviteExo(false);
         this.reglements.setRglCodeReceptrice((String)null);
         this.reglements.setRglLibReceptrice((String)null);
         this.reglements.setRglDateCreation(new Date());
         this.reglements.setRglDateImp((Date)null);
         this.reglements.setRglDateTransfert((Date)null);
         this.reglements.setRglDateValeur((Date)null);
         this.reglements.setRglDepense(this.var_aEncaisser);
         this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(0L);
         if (this.tiers != null) {
            this.reglements.setRglIdTiers(this.tiers.getTieid());
         } else {
            this.reglements.setRglIdTiers(0L);
         }

         this.reglements.setRglDepotTiers(0);
         this.reglements.setRglMode(this.var_modeReglement);
         this.reglements.setRglModele(this.var_modele);
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
         this.reglements.setRglNum(var3);
         this.reglements.setRglParc("");
         this.reglements.setRglRecette(0.0D);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglTrf(0);
         this.reglements.setRglTypeTiers(2);
         this.reglements.setRglUserCreat(this.usersLog.getUsrid());
         this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
         this.reglements.setRglUserModif(0L);
         String var12 = "";
         if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
            var12 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
         } else {
            var12 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
         }

         String var5 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
         this.reglements.setRglPeriode(var12 + ":" + var5);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         String var6 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var6);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var6);
         this.reglements.setExercicesCaisse(this.selectedExo);
         this.reglements = this.reglementsDao.insert(this.reglements, var1);
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

   public void casEchangeChequeEspece() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "VirementInterne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.chargerCaisse(var1);
         String var3 = "";
         if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
            var3 = this.calculChrono.numCompose(new Date(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var1);
         } else {
            var3 = this.calculChrono.numCompose(new Date(), this.natCaisse, this.serieCaisse, this.var_caisse, var1);
         }

         if (this.caissesOperations != null) {
            this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
         } else {
            this.reglements.setRglOperation("");
         }

         this.reglements.setRglBon("");
         this.reglements.setRglCategorie(60);
         this.reglements.setRglActivite("");
         this.reglements.setRglBudget("");
         if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
            String[] var4 = this.var_caisse.split(":");
            this.reglements.setRglCodeCaiss(var4[0]);
            this.reglements.setRglLibCaiss(var4[1]);
            new CaissesCommerciales();
            CaissesCommerciales var5 = this.caissesCommercialesDao.selectCaisse(this.selectedExo.getExecaiId(), this.reglements.getRglCodeCaiss(), var1);
            if (var5 != null) {
               this.reglements.setRglCodeEmetrice(var5.getCaiJrEspece());
               this.reglements.setRglLibEmetrice(var5.getCaiNomJrEspece());
            } else {
               this.reglements.setRglCodeEmetrice((String)null);
               this.reglements.setRglLibEmetrice((String)null);
            }
         } else {
            this.reglements.setRglCodeCaiss((String)null);
            this.reglements.setRglLibCaiss((String)null);
            this.reglements.setRglCodeEmetrice((String)null);
            this.reglements.setRglLibEmetrice((String)null);
         }

         this.reglements.setRglActiviteCompte("");
         this.reglements.setRglActiviteTaux(0.0F);
         this.reglements.setRglActiviteExo(false);
         this.reglements.setRglCodeReceptrice((String)null);
         this.reglements.setRglLibReceptrice((String)null);
         this.reglements.setRglDateCreation(new Date());
         this.reglements.setRglDateImp((Date)null);
         this.reglements.setRglDateTransfert((Date)null);
         this.reglements.setRglDateValeur((Date)null);
         this.reglements.setRglDepartement("");
         this.reglements.setRglDossier("");
         this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
         this.reglements.setRglDocument("");
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(0L);
         this.reglements.setRglIdTiers(0L);
         this.reglements.setRglDepotTiers(0);
         this.reglements.setRglMode("1");
         this.reglements.setRglModele(this.var_modele);
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglNomTiers("");
         this.reglements.setRglNum(var3);
         this.reglements.setRglParc("");
         this.reglements.setRglPdv("");
         this.reglements.setRglDepense(0.0D);
         this.reglements.setRglRecette(this.var_aEncaisser);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglRegion("");
         this.reglements.setRglSecteur("");
         this.reglements.setRglSerie("");
         this.reglements.setRglService("");
         this.reglements.setRglSite("");
         this.reglements.setRglTrf(0);
         this.reglements.setRglTypeReg(1);
         this.reglements.setRglTypeTiers(0);
         this.reglements.setRglUserCreat(this.usersLog.getUsrid());
         this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
         this.reglements.setRglUserModif(0L);
         String var14 = "";
         if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
            var14 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
         } else {
            var14 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
         }

         String var15 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
         this.reglements.setRglPeriode(var14 + ":" + var15);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         String var6 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var6);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var6);
         this.reglements.setExercicesCaisse(this.selectedExo);
         this.reglements.setRglImp(0);
         this.reglements = this.reglementsDao.insert(this.reglements, var1);
         new Reglements();
         Reglements var7 = this.reglements;
         new CaissesCommerciales();
         this.reglements = new Reglements();
         this.reglements.setRglDateReg(var7.getRglDateReg());
         this.reglements.setRglActivite(var7.getRglActivite());
         this.reglements.setRglBanqueTireur(var7.getRglBanqueTireur());
         this.reglements.setRglBudget(var7.getRglBudget());
         this.reglements.setRglBon(var7.getRglNum());
         this.reglements.setRglCategorie(60);
         this.reglements.setRglCodeCaiss(var7.getRglCodeCaiss());
         this.reglements.setRglLibCaiss(var7.getRglLibCaiss());
         this.reglements.setRglCodeEmetrice((String)null);
         this.reglements.setRglLibEmetrice((String)null);
         this.reglements.setRglCodeReceptrice(var7.getRglCodeEmetrice());
         this.reglements.setRglLibReceptrice(var7.getRglLibEmetrice());
         this.reglements.setRglOperation(var7.getRglOperation());
         this.reglements.setRglDateCreation(new Date());
         this.reglements.setRglDateImp((Date)null);
         this.reglements.setRglDateTransfert((Date)null);
         this.reglements.setRglDateValeur((Date)null);
         this.reglements.setRglActiviteCompte("");
         this.reglements.setRglActiviteTaux(0.0F);
         this.reglements.setRglActiviteExo(false);
         this.reglements.setRglDepartement(var7.getRglDepartement());
         this.reglements.setRglDepense(this.var_aEncaisser);
         this.reglements.setRglDevise(var7.getRglDevise());
         this.reglements.setRglDossier(var7.getRglDossier());
         this.reglements.setRglFormatDevise(this.calculformatDevise(var7.getRglDevise()));
         this.reglements.setRglDocument(var7.getRglDocument());
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(0L);
         this.reglements.setRglIdTiers(0L);
         this.reglements.setRglDepotTiers(0);
         this.reglements.setRglLibEmetrice("");
         this.reglements.setRglLibelle(var7.getRglLibelle());
         this.reglements.setRglMode("0");
         this.reglements.setRglModele(var7.getRglModele());
         this.reglements.setRglNumChqBdx(var7.getRglNumChqBdx());
         this.reglements.setRglNatureDoc(var7.getRglNatureDoc());
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglNomResponsable(var7.getRglNomResponsable());
         this.reglements.setRglNomTiers("");
         this.reglements.setRglNum(var3);
         this.reglements.setRglObjet(var7.getRglObjet());
         this.reglements.setRglParc(var7.getRglParc());
         this.reglements.setRglPdv(var7.getRglPdv());
         this.reglements.setRglRecette(0.0D);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglRegion(var7.getRglRegion());
         this.reglements.setRglSecteur(var7.getRglSecteur());
         this.reglements.setRglSerie(var7.getRglSerie());
         this.reglements.setRglService(var7.getRglService());
         this.reglements.setRglSite(var7.getRglSite());
         this.reglements.setRglTrf(0);
         this.reglements.setRglTypeReg(0);
         this.reglements.setRglTypeTiers(0);
         this.reglements.setRglUserCreat(this.usersLog.getUsrid());
         this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
         this.reglements.setRglUserModif(0L);
         this.reglements.setRglPeriode(var14 + ":" + var15);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var6);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var6);
         this.reglements.setExercicesCaisse(this.selectedExo);
         this.reglements.setRglImp(0);
         this.reglementsDao.insert(this.reglements, var1);
         this.reglements = var7;
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

   public void casVirement() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "VirementInterne");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.chargerCaisse(var1);
         String var3 = "";
         if (this.optionCaisses.getChronoReglement() != null && !this.optionCaisses.getChronoReglement().isEmpty() && this.optionCaisses.getChronoReglement().equals("1")) {
            var3 = this.calculChrono.numCompose(new Date(), this.natCaisse, this.var_modeReglement, this.serieCaisse, var1);
         } else {
            var3 = this.calculChrono.numComposeCaisse(new Date(), this.natCaisse, this.serieCaisse, this.var_caisse, var1);
         }

         if (this.caissesOperations != null) {
            this.reglements.setRglOperation(this.caissesOperations.getCaiopeCode());
         } else {
            this.reglements.setRglOperation("");
         }

         this.reglements.setRglBon("");
         this.reglements.setRglCategorie(60);
         this.reglements.setRglActivite("");
         this.reglements.setRglBudget("");
         String[] var4;
         if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
            var4 = this.var_caisse.split(":");
            this.reglements.setRglCodeCaiss(var4[0]);
            this.reglements.setRglLibCaiss(var4[1]);
         } else {
            this.reglements.setRglCodeCaiss((String)null);
            this.reglements.setRglLibCaiss((String)null);
         }

         this.reglements.setRglImp(0);
         if (this.inputBanqEmetteur != null && !this.inputBanqEmetteur.isEmpty() && this.inputBanqEmetteur.contains(":")) {
            var4 = this.inputBanqEmetteur.split(":");
            this.reglements.setRglCodeEmetrice(var4[0]);
            this.reglements.setRglLibEmetrice(var4[1]);
            if (this.caissesOperations.getCaiopeCode().equals("73")) {
               new CaissesCommerciales();
               CaissesCommerciales var5 = this.caissesCommercialesDao.chercheCaisseByJournal(this.selectedExo.getExecaiId(), this.reglements.getRglCodeEmetrice(), var1);
               if (var5 != null) {
                  this.reglements.setRglCodeCaiss(var5.getCaiCode());
                  this.reglements.setRglLibCaiss(var5.getCaiNom());
               } else {
                  this.reglements.setRglCodeCaiss(this.reglements.getRglCodeEmetrice());
                  this.reglements.setRglLibCaiss(this.reglements.getRglLibEmetrice());
               }
            } else if (this.caissesOperations.getCaiopeCode().equals("74")) {
            }

            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
         } else {
            this.reglements.setRglCodeEmetrice((String)null);
            this.reglements.setRglLibEmetrice((String)null);
            if (this.inputBanqRecepteur != null && !this.inputBanqRecepteur.isEmpty() && this.inputBanqRecepteur.contains(":")) {
               var4 = this.inputBanqRecepteur.split(":");
               this.reglements.setRglCodeReceptrice(var4[0]);
               this.reglements.setRglLibReceptrice(var4[1]);
            } else {
               this.reglements.setRglCodeReceptrice((String)null);
               this.reglements.setRglLibReceptrice((String)null);
            }
         }

         this.reglements.setRglActiviteCompte("");
         this.reglements.setRglActiviteTaux(0.0F);
         this.reglements.setRglActiviteExo(false);
         this.reglements.setRglDateCreation(new Date());
         this.reglements.setRglDateImp((Date)null);
         this.reglements.setRglDateTransfert((Date)null);
         this.reglements.setRglDateValeur((Date)null);
         this.reglements.setRglDepartement("");
         this.reglements.setRglDossier("");
         this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
         this.reglements.setRglDocument("");
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(0L);
         this.reglements.setRglIdTiers(0L);
         this.reglements.setRglDepotTiers(0);
         this.reglements.setRglMode(this.var_modeReglement);
         if (this.reglements.getRglMode().equals("100")) {
            this.reglements.setRglMode("0");
         }

         this.reglements.setRglModele(this.var_modele);
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglNomTiers("");
         this.reglements.setRglNum(var3);
         this.reglements.setRglParc("");
         this.reglements.setRglPdv("");
         this.reglements.setRglDepense(this.var_aEncaisser);
         this.reglements.setRglRecette(0.0D);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglRegion("");
         this.reglements.setRglSecteur("");
         this.reglements.setRglSerie("");
         this.reglements.setRglService("");
         this.reglements.setRglSite("");
         this.reglements.setRglTrf(0);
         if (this.reglements.getRglTypeReg() == 100) {
            this.reglements.setRglTypeReg(0);
         }

         this.reglements.setRglTypeTiers(0);
         this.reglements.setRglUserCreat(this.usersLog.getUsrid());
         this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
         this.reglements.setRglUserModif(0L);
         String var16 = "";
         if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
            var16 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
         } else {
            var16 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
         }

         String var17 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
         this.reglements.setRglPeriode(var16 + ":" + var17);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         String var6 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var6);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var6);
         this.reglements.setExercicesCaisse(this.selectedExo);
         this.reglements = this.reglementsDao.insert(this.reglements, var1);
         new Reglements();
         Reglements var7 = this.reglements;
         new CaissesCommerciales();
         this.reglements = new Reglements();
         this.reglements.setRglDateReg(var7.getRglDateReg());
         this.reglements.setRglActivite(var7.getRglActivite());
         this.reglements.setRglBanqueTireur(var7.getRglBanqueTireur());
         this.reglements.setRglBudget(var7.getRglBudget());
         this.reglements.setRglBon(var7.getRglNum());
         this.reglements.setRglCategorie(60);
         this.reglements.setRglCodeEmetrice("");
         this.reglements.setRglLibEmetrice("");
         this.reglements.setRglImp(0);
         if (this.inputBanqRecepteur != null && !this.inputBanqRecepteur.isEmpty() && this.inputBanqRecepteur.contains(":")) {
            String[] var9 = this.inputBanqRecepteur.split(":");
            this.reglements.setRglCodeReceptrice(var9[0]);
            this.reglements.setRglLibReceptrice(var9[1]);
         } else {
            this.reglements.setRglCodeReceptrice((String)null);
            this.reglements.setRglLibReceptrice((String)null);
         }

         CaissesCommerciales var8 = this.caissesCommercialesDao.chercheCaisseByJournal(this.selectedExo.getExecaiId(), this.reglements.getRglCodeReceptrice(), var1);
         if (var8 != null) {
            this.reglements.setRglCodeCaiss(var8.getCaiCode());
            this.reglements.setRglLibCaiss(var8.getCaiNom());
         } else {
            this.reglements.setRglCodeCaiss(var7.getRglCodeReceptrice());
            this.reglements.setRglLibCaiss(var7.getRglLibReceptrice());
         }

         this.reglements.setRglActiviteCompte("");
         this.reglements.setRglActiviteTaux(0.0F);
         this.reglements.setRglActiviteExo(false);
         this.reglements.setRglOperation(var7.getRglOperation());
         this.reglements.setRglDateCreation(new Date());
         this.reglements.setRglDateImp((Date)null);
         this.reglements.setRglDateTransfert((Date)null);
         this.reglements.setRglDateValeur((Date)null);
         this.reglements.setRglDepartement(var7.getRglDepartement());
         this.reglements.setRglDepense(0.0D);
         this.reglements.setRglDevise(var7.getRglDevise());
         this.reglements.setRglDossier(var7.getRglDossier());
         this.reglements.setRglFormatDevise(this.calculformatDevise(var7.getRglDevise()));
         this.reglements.setRglDocument(var7.getRglDocument());
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(0L);
         this.reglements.setRglIdTiers(0L);
         this.reglements.setRglDepotTiers(0);
         this.reglements.setRglLibelle(var7.getRglLibelle());
         this.reglements.setRglMode(var7.getRglMode());
         this.reglements.setRglModele(var7.getRglModele());
         this.reglements.setRglNumChqBdx(var7.getRglNumChqBdx());
         this.reglements.setRglNatureDoc(var7.getRglNatureDoc());
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglNomResponsable(var7.getRglNomResponsable());
         this.reglements.setRglNomTiers("");
         this.reglements.setRglNum(var3);
         this.reglements.setRglObjet(var7.getRglObjet());
         this.reglements.setRglParc(var7.getRglParc());
         this.reglements.setRglPdv(var7.getRglPdv());
         this.reglements.setRglRecette(this.var_aEncaisser);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglRegion(var7.getRglRegion());
         this.reglements.setRglSecteur(var7.getRglSecteur());
         this.reglements.setRglSerie(var7.getRglSerie());
         this.reglements.setRglService(var7.getRglService());
         this.reglements.setRglSite(var7.getRglSite());
         this.reglements.setRglTrf(0);
         this.reglements.setRglTypeReg(var7.getRglTypeReg());
         this.reglements.setRglTypeTiers(0);
         this.reglements.setRglUserCreat(this.usersLog.getUsrid());
         this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
         this.reglements.setRglUserModif(0L);
         this.reglements.setRglPeriode(var16 + ":" + var17);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var6);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var6);
         this.reglements.setExercicesCaisse(this.selectedExo);
         this.reglementsDao.insert(this.reglements, var1);
         this.reglements = var7;
         int var10;
         Reglements var18;
         if (this.lesChequesARemettre.size() != 0) {
            if (this.caissesOperations.getCaiopeCode().equals("81")) {
               new Reglements();

               for(var10 = 0; var10 < this.lesChequesARemettre.size(); ++var10) {
                  var18 = (Reglements)this.lesChequesARemettre.get(var10);
                  if (var18.isSel_ecriture()) {
                     var18.setRglNumMvt1(this.reglements.getRglNum());
                     var18.setRglDateMvt1(this.reglements.getRglDateReg());
                     var18.setRglCaisseMvt1(this.reglements.getRglCodeReceptrice());
                     this.reglementsDao.modifierReg(var18, var1);
                  }
               }
            } else if (this.caissesOperations.getCaiopeCode().equals("83")) {
               new Reglements();

               for(var10 = 0; var10 < this.lesChequesARemettre.size(); ++var10) {
                  var18 = (Reglements)this.lesChequesARemettre.get(var10);
                  if (var18.isSel_ecriture()) {
                     var18.setRglNumMvt2(this.reglements.getRglNum());
                     var18.setRglDateMvt2(this.reglements.getRglDateReg());
                     var18.setRglBanqueMvt2(this.reglements.getRglCodeReceptrice());
                     this.reglementsDao.modifierReg(var18, var1);
                  }
               }
            }
         } else if (this.lesEffetsARemettre.size() != 0) {
            if (this.caissesOperations.getCaiopeCode().equals("82")) {
               new Reglements();

               for(var10 = 0; var10 < this.lesEffetsARemettre.size(); ++var10) {
                  var18 = (Reglements)this.lesEffetsARemettre.get(var10);
                  if (var18.isSel_ecriture()) {
                     var18.setRglNumMvt1(this.reglements.getRglNum());
                     var18.setRglDateMvt1(this.reglements.getRglDateReg());
                     var18.setRglCaisseMvt1(this.reglements.getRglCodeReceptrice());
                     this.reglementsDao.modifierReg(var18, var1);
                  }
               }
            } else if (this.caissesOperations.getCaiopeCode().equals("84")) {
               new Reglements();

               for(var10 = 0; var10 < this.lesEffetsARemettre.size(); ++var10) {
                  var18 = (Reglements)this.lesEffetsARemettre.get(var10);
                  if (var18.isSel_ecriture()) {
                     var18.setRglNumMvt2(this.reglements.getRglNum());
                     var18.setRglDateMvt2(this.reglements.getRglDateReg());
                     var18.setRglBanqueMvt2(this.reglements.getRglCodeReceptrice());
                     this.reglementsDao.modifierReg(var18, var1);
                  }
               }
            }
         }

         var2.commit();
      } catch (HibernateException var14) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var14;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void choixCaissePiece() throws HibernateException, NamingException, ParseException {
      this.choixCaissePiece((Session)null);
      this.calculeSoldeCaisse(this.reglements.getRglCodeCaiss(), this.bonSortieCaiss.getSortDate());
      this.afficheValide();
   }

   public void choixCaissePiece(Session var1) throws HibernateException, NamingException {
      this.mesModesReglementsItem.clear();
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         String[] var2 = this.var_caisse.split(":");
         this.reglements.setRglCodeCaiss(var2[0]);
         this.reglements.setRglLibCaiss(var2[1]);
         if (this.reglements.getRglCodeCaiss() != null && !this.reglements.getRglCodeCaiss().isEmpty()) {
            this.caissesCommerciales = this.caissesCommercialesDao.selectCaisseByCode(var2[0], this.selectedExo, var1);
            this.calculModeReglement();
            if (this.documentImpressionItems.size() == 0) {
               int var3 = 0;
               if (this.natureOperation != null && !this.natureOperation.isEmpty()) {
                  if (this.natureOperation.contains(":")) {
                     String[] var4 = this.natureOperation.split(":");
                     var3 = Integer.parseInt(var4[0]);
                  } else {
                     var3 = Integer.parseInt(this.natureOperation);
                  }
               }

               this.calculeNomRep(Integer.parseInt(this.var_modeReglement), var3);
            }

            if (this.documentImpressionItems.size() != 0 && (this.var_modele == null || this.var_modele.isEmpty())) {
               this.var_modele = ((SelectItem)this.documentImpressionItems.get(0)).getLabel();
            }

            if (this.mesModesReglementsItem.size() == 0) {
               this.calculModeReglement();
            }

            if (this.var_modele != null && !this.var_modele.isEmpty()) {
               this.reglements.setRglModele(this.var_modele);
               if (this.mesModesReglementsItem.size() != 0) {
                  this.var_valide = true;
                  if (((SelectItem)this.mesModesReglementsItem.get(0)).getLabel() != null && !((SelectItem)this.mesModesReglementsItem.get(0)).getLabel().isEmpty() && ((SelectItem)this.mesModesReglementsItem.get(0)).getLabel().contains(":")) {
                     if (this.var_modeReglement.equals("100")) {
                        String[] var5 = ((SelectItem)this.mesModesReglementsItem.get(0)).getLabel().split(":");
                        this.var_modeReglement = var5[0];
                     }

                     this.choixTypeReglementPiece();
                  }
               } else {
                  this.var_valide = false;
               }
            } else {
               this.reglements.setRglModele("");
               this.var_valide = false;
            }
         } else {
            this.caissesCommerciales = null;
            this.reglements.setRglCodeCaiss("");
            this.reglements.setRglLibCaiss("");
            this.reglements.setRglModele("");
            this.var_valide = false;
         }
      } else {
         this.reglements.setRglCodeCaiss("");
         this.reglements.setRglLibCaiss("");
         this.reglements.setRglModele("");
         this.var_valide = false;
      }

   }

   public void verifPlafondOperation() throws HibernateException, NamingException {
      if (this.caissesOperations != null) {
         if (this.caissesOperations.getPlafond() != 0.0D) {
            if (this.var_aEncaisser > this.caissesOperations.getPlafond()) {
               this.planfond_depasse = true;
            } else {
               this.planfond_depasse = false;
               this.choixTypeReglementPiece();
            }
         } else {
            this.planfond_depasse = false;
            this.choixTypeReglementPiece();
         }
      }

      this.var_monnaie = this.var_total_bon - this.var_aEncaisser;
      this.verifRegulBonCaisse();
      this.calculCle1();
   }

   public void verifRegulBonCaisse() {
      if (this.natureOperation != null && !this.natureOperation.isEmpty()) {
         if (this.natureOperation.equals("26")) {
            double var1 = this.var_total_bon - (this.var_aEncaisser + this.var_monnaie);
            if (var1 != 0.0D) {
               this.var_valide = false;
            } else {
               this.var_valide = true;
            }
         }
      } else {
         this.var_valide = true;
      }

      if (this.caissesCommerciales != null && this.caissesCommerciales.getCaiNegatif() == 1 && this.var_aEncaisser > this.soldeCaisse && this.soldeCaisse != 0.0D) {
         this.var_valide = false;
      }

   }

   public void choixTypeReglementPiece() throws HibernateException, NamingException {
      if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
         this.var_modeReglement = "100";
      }

      this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
      if (this.reglements.getRglTypeReg() != 1 && this.reglements.getRglTypeReg() != 2 && this.reglements.getRglTypeReg() != 3 && this.reglements.getRglTypeReg() != 4 && this.reglements.getRglTypeReg() != 6 && this.reglements.getRglTypeReg() != 7) {
         if (this.reglements.getRglTypeReg() == 11) {
            this.var_affiche_banque = false;
            this.var_affiche_lettreGarantie = false;
            if (this.reglements.getRglNatureDoc() >= 10 && this.reglements.getRglNatureDoc() <= 19) {
               this.var_aPayer = this.var_aEncaisser;
            } else if (this.reglements.getRglNatureDoc() >= 20 && this.reglements.getRglNatureDoc() <= 29) {
               this.reglements.setRglDepense(0.0D);
               this.var_montant_rendu = 0.0D;
               this.var_garde = false;
               this.var_aPayer = this.var_aEncaisser;
               this.calculTimbreFactureVentes((Session)null);
            }

            this.var_timbre = 0.0D;
         } else if (this.reglements.getRglTypeReg() == 12) {
            this.var_affiche_lettreGarantie = true;
            if (this.reglements.getRglNatureDoc() >= 70 && this.reglements.getRglNatureDoc() <= 79) {
               this.reglements.setRglDepense(0.0D);
               this.var_montant_rendu = 0.0D;
               this.var_garde = false;
               this.var_aPayer = this.var_aEncaisser;
            }

            this.var_timbre = 0.0D;
         } else {
            this.var_affiche_banque = false;
            this.var_affiche_lettreGarantie = false;
            if (this.reglements.getRglNatureDoc() >= 10 && this.reglements.getRglNatureDoc() <= 19) {
               this.var_timbre = this.calculTimbreAchats(this.var_aEncaisser, this.reglements.getRglDevise(), (Session)null);
               this.var_aPayer = this.var_aEncaisser + this.var_timbre;
            } else if (this.reglements.getRglNatureDoc() >= 20 && this.reglements.getRglNatureDoc() <= 29) {
               this.var_timbre = this.calculTimbreVentes(this.var_aEncaisser, this.reglements.getRglDevise(), (Session)null);
               this.var_aPayer = this.var_aEncaisser + this.var_timbre;
               this.calculTimbreFactureVentes((Session)null);
            } else {
               this.var_timbre = 0.0D;
            }
         }
      } else {
         if (this.reglements.getRglNatureDoc() >= 10 && this.reglements.getRglNatureDoc() <= 19) {
            this.var_aPayer = this.var_aEncaisser;
         } else if (this.reglements.getRglNatureDoc() >= 20 && this.reglements.getRglNatureDoc() <= 29) {
            this.reglements.setRglDepense(0.0D);
            this.var_montant_rendu = 0.0D;
            this.var_garde = false;
            this.var_aPayer = this.var_aEncaisser;
            this.calculTimbreFactureVentes((Session)null);
         } else if (this.reglements.getRglNatureDoc() != 62 && this.reglements.getRglNatureDoc() != 63 && this.reglements.getRglNatureDoc() != 64 && this.reglements.getRglNatureDoc() != 87 && this.reglements.getRglNatureDoc() == 88) {
         }

         this.var_affiche_banque = true;
         this.var_affiche_lettreGarantie = false;
         this.var_timbre = 0.0D;
      }

      this.nomRepMod = "";
      int var1 = 0;
      if (this.natureOperation != null && !this.natureOperation.isEmpty()) {
         if (this.natureOperation.contains(":")) {
            String[] var2 = this.natureOperation.split(":");
            var1 = Integer.parseInt(var2[0]);
         } else {
            var1 = Integer.parseInt(this.natureOperation);
         }
      }

      this.calculeNomRep(this.reglements.getRglTypeReg(), var1);
      if (this.var_affiche_banque) {
         if (this.caissesCommerciales.getCaiCodeBanqueDefaut() != null && !this.caissesCommerciales.getCaiCodeBanqueDefaut().isEmpty()) {
            this.inputBanq = this.caissesCommerciales.getCaiCodeBanqueDefaut() + ":" + this.caissesCommerciales.getCaiNomBanqueDefaut();
         } else if (this.bonCaisse != null) {
            this.inputBanq = this.bonCaisse.getBonCaisCodeBanqRecepteur() + ":" + this.bonCaisse.getBonCaisLibBanqRecepteur();
         } else {
            this.inputBanq = "";
         }
      } else {
         this.inputBanq = "";
      }

      this.var_montant_recu = this.var_aEncaisser + this.var_timbre;
      this.calculRenduPiece();
   }

   public void choixBanqPiece() {
      if (this.inputBanq != null && !this.inputBanq.isEmpty() && this.inputBanq.contains(":")) {
         String[] var1 = this.inputBanq.split(":");
         this.reglements.setRglCodeEmetrice(var1[0]);
         this.reglements.setRglLibEmetrice(var1[1]);
      } else {
         this.reglements.setRglCodeEmetrice("");
         this.reglements.setRglLibEmetrice("");
      }

   }

   public void calculRenduPiece() {
      double var1 = 0.0D;
      if (this.var_montant_recu != 0.0D) {
         var1 = this.var_montant_recu - this.var_aEncaisser - this.var_timbre;
      }

      this.var_montant_rendu = var1;
      this.var_valide = false;
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         if (this.natureOperation != null && !this.natureOperation.isEmpty()) {
            if (this.caissesOperations.getPlafond() != 0.0D) {
               if (this.var_aEncaisser > this.caissesOperations.getPlafond()) {
                  this.planfond_depasse = true;
                  this.var_valide = false;
               } else {
                  this.planfond_depasse = false;
                  this.var_valide = true;
               }
            } else {
               this.planfond_depasse = false;
               this.var_valide = true;
            }
         } else {
            this.var_valide = true;
         }
      }

   }

   public double calculTimbreAchatsPiece(double var1, String var3, Session var4) throws HibernateException, NamingException {
      double var5 = 0.0D;
      if (this.reglements.getRglTypeReg() == 0) {
         TaxesAchatsDao var7 = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
         boolean var8 = var7.timbreExist(this.exercicesAchats.getExeachId(), var4);
         if (var8) {
            int var9 = (new Date()).getYear() + 1900;
            var5 = this.utilNombre.myRoundDevise(this.utilNombre.calculTimbre(this.structureLog, var1, var9, var3, new Date()), var3);
         }
      }

      return var5;
   }

   public double calculTimbreVentesPiece(double var1, String var3, Session var4) throws HibernateException, NamingException {
      double var5 = 0.0D;
      if (this.reglements.getRglTypeReg() == 0) {
         boolean var7 = this.taxesVentesDao.timbreExist(this.exercicesVentes.getExevteId(), var4);
         if (var7) {
            int var8 = (new Date()).getYear() + 1900;
            var5 = this.utilNombre.myRoundDevise(this.utilNombre.calculTimbre(this.structureLog, var1, var8, var3, new Date()), var3);
         }
      }

      return var5;
   }

   public void choixActivite() throws HibernateException, NamingException {
      this.libActivite = "";
      this.affActivite = false;
      if (this.reglements.getRglActivite() != null && !this.reglements.getRglActivite().isEmpty() && this.reglements.getRglActivite().contains(":")) {
         String[] var1 = this.reglements.getRglActivite().split(":");
         new Activites();
         Activites var2 = this.activitesDao.rechercheActivite(var1[0], (Session)null);
         if (var2 != null) {
            if (var2.getActOptions() == 1) {
               this.libActivite = "N° Contrat";
               this.affActivite = true;
            } else if (var2.getActOptions() == 2) {
               this.libActivite = "N° Dossier";
               this.affActivite = true;
            } else if (var2.getActOptions() == 3) {
               this.libActivite = "N° Parc";
               this.affActivite = true;
            } else if (var2.getActOptions() == 4) {
               this.libActivite = "N° O.R.";
               this.affActivite = true;
            } else if (var2.getActOptions() == 5) {
               this.libActivite = "N° CMD";
               this.affActivite = true;
            }
         }
      }

   }

   public void verifEmetteur() throws HibernateException, NamingException {
   }

   public void verifRecepteur() throws HibernateException, NamingException {
   }

   public void calculBilletage() {
      this.tot_b1 = (double)(this.val_b1 * this.reglements.getRglB1());
      this.tot_b2 = (double)(this.val_b2 * this.reglements.getRglB2());
      this.tot_b3 = (double)(this.val_b3 * this.reglements.getRglB3());
      this.tot_b4 = (double)(this.val_b4 * this.reglements.getRglB4());
      this.tot_b5 = (double)(this.val_b5 * this.reglements.getRglB5());
      this.tot_b6 = (double)(this.val_b6 * this.reglements.getRglB6());
      this.tot_b7 = (double)(this.val_b7 * this.reglements.getRglB7());
      this.tot_b8 = (double)(this.val_b8 * this.reglements.getRglB8());
      this.tot_b9 = (double)(this.val_b9 * this.reglements.getRglB9());
      this.tot_b10 = (double)(this.val_b10 * this.reglements.getRglB10());
      this.totalBillet = this.tot_b1 + this.tot_b2 + this.tot_b3 + this.tot_b4 + this.tot_b5 + this.tot_b6 + this.tot_b7 + this.tot_b8 + this.tot_b9 + this.tot_b10;
      this.tot_p1 = (double)(this.val_p1 * this.reglements.getRglP1());
      this.tot_p2 = (double)(this.val_p2 * this.reglements.getRglP2());
      this.tot_p3 = (double)(this.val_p3 * this.reglements.getRglP3());
      this.tot_p4 = (double)(this.val_p4 * this.reglements.getRglP4());
      this.tot_p5 = (double)(this.val_p5 * this.reglements.getRglP5());
      this.tot_p6 = (double)(this.val_p6 * this.reglements.getRglP6());
      this.tot_p7 = (double)(this.val_p7 * this.reglements.getRglP7());
      this.tot_p8 = (double)(this.val_p8 * this.reglements.getRglP8());
      this.tot_p9 = (double)(this.val_p9 * this.reglements.getRglP9());
      this.tot_p10 = (double)(this.val_p10 * this.reglements.getRglP10());
      this.totalPiece = this.tot_p1 + this.tot_p2 + this.tot_p3 + this.tot_p4 + this.tot_p5 + this.tot_p6 + this.tot_p7 + this.tot_p8 + this.tot_p9 + this.tot_p10;
      this.var_aEncaisser = this.totalBillet + this.totalPiece;
   }

   public void modifierRegularisation() throws HibernateException, NamingException {
      if (this.bonCaisse != null) {
         this.var_valide = true;
         this.regul = true;
         this.var_action = 3;
         this.reglements = this.reglementsDao.pourParapheur(this.bonCaisse.getBonCaisId(), (Session)null);
         if (this.reglements != null) {
            this.bonCaisse.setBonCaisDate(this.reglements.getRglDateReg());
            this.var_caisse = this.bonCaisse.getBonCaisCodeCaiss() + ":" + this.bonCaisse.getBonCaisLibCaiss();
         } else {
            this.bonCaisse.setBonCaisDate(new Date());
            this.var_caisse = "";
         }

         this.var_memo_action = this.var_action;
         this.var_titre_recu = "MODIFICATION D'UN RECU";
      }

   }

   public void validerRegularisation() throws HibernateException, NamingException, IOException, ParseException {
      if (this.bonCaisse != null) {
         this.regul = false;
         String var1 = "";
         this.reglements = this.reglementsDao.pourParapheur(this.bonCaisse.getBonCaisId(), (Session)null);
         if (this.reglements != null) {
            double var4;
            if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 15) {
               new FactureEnteteAchats();
               FactureEnteteAchatsDao var35 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               FactureEnteteAchats var29 = var35.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
               if (var29 != null) {
                  var4 = var29.getFcfTotReglement() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                  var29.setFcfTotReglement(var4);
                  if (var29.getFcfTotReglement() == var29.getFcfTotTtc() + var29.getFcfTotTc()) {
                     var29.setFcfSolde(1);
                     var1 = "01";
                  } else {
                     var29.setFcfSolde(0);
                     var1 = "02";
                  }

                  var35.modif(var29);
               }
            } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 16) {
               new AvoirEnteteAchats();
               AvoirEnteteAchatsDao var34 = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               AvoirEnteteAchats var28 = var34.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
               if (var28 != null) {
                  var4 = var28.getAvfTotReglement() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                  var28.setAvfTotReglement(var4);
                  if (var28.getAvfTotReglement() == var28.getAvfTotTtc() + var28.getAvfTotTc()) {
                     var28.setAvfSolde(1);
                     var1 = "01";
                  } else {
                     var28.setAvfSolde(0);
                     var1 = "02";
                  }

                  var34.modif(var28);
               }
            } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 17) {
               new NoteDebitEnteteAchats();
               NoteDebitEnteteAchatsDao var32 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               NoteDebitEnteteAchats var26 = var32.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
               if (var26 != null) {
                  var4 = var26.getNdfTotReglement() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                  var26.setNdfTotReglement(var4);
                  if (var26.getNdfTotReglement() == var26.getNdfTotTtc() + var26.getNdfTotTc()) {
                     var26.setNdfSolde(1);
                     var1 = "01";
                  } else {
                     var26.setNdfSolde(0);
                     var1 = "02";
                  }

                  var32.modif(var26);
               }
            } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 18) {
               new FraisEnteteAchats();
               FraisEnteteAchatsDao var30 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
               FraisEnteteAchats var23 = var30.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
               if (var23 != null) {
                  var4 = var23.getFsfTotReglement() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                  var23.setFsfTotReglement(var4);
                  if (var23.getFsfTotReglement() == var23.getFsfTotTtc() + var23.getFsfTotTc()) {
                     var23.setFsfSolde(1);
                     var1 = "01";
                  } else {
                     var23.setFsfSolde(0);
                     var1 = "02";
                  }

                  var30.modif(var23);
               }
            } else {
               double var27;
               if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 22) {
                  new CommandeEnteteVentes();
                  CommandeEnteteVentes var21 = this.commandeEnteteVentesDao.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
                  if (var21 != null) {
                     var27 = var21.getBcmTotReglement() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                     var21.setBcmTotReglement(var27);
                     if (var21.getBcmTotReglement() == var21.getBcmTotTtc() + var21.getBcmTotTc()) {
                        var21.setBcmSolde(1);
                        var1 = "01";
                     } else {
                        var21.setBcmSolde(0);
                        var1 = "02";
                     }

                     this.commandeEnteteVentesDao.modif(var21);
                  }
               } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 25) {
                  new FactureEnteteVentes();
                  this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  FactureEnteteVentes var19 = this.factureEnteteVentesDao.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
                  if (var19 != null) {
                     var27 = var19.getFacTotReglement() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                     double var5 = var19.getFacTotTimbre() - this.reglements.getRglTimbre() + this.bonCaisse.getTimbre();
                     var19.setFacTotReglement(var27);
                     var19.setFacTotTimbre(var5);
                     if (var19.getFacTotReglement() == var19.getFacTotTtc() + var19.getFacTotTc()) {
                        var19.setFacSolde(1);
                        var1 = "01";
                     } else {
                        var19.setFacSolde(0);
                        var1 = "02";
                     }

                     this.factureEnteteVentesDao.modif(var19);
                  }
               } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 26) {
                  new AvoirEnteteVentes();
                  AvoirEnteteVentesDao var25 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  AvoirEnteteVentes var17 = var25.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
                  if (var17 != null) {
                     var4 = var17.getAvrTotReglement() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                     var17.setAvrTotReglement(var4);
                     if (var17.getAvrTotReglement() == var17.getAvrTotTtc() + var17.getAvrTotTc()) {
                        var17.setAvrSolde(1);
                        var1 = "01";
                     } else {
                        var17.setAvrSolde(0);
                        var1 = "02";
                     }

                     var25.modif(var17);
                  }
               } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 27) {
                  new NoteDebitEnteteVentes();
                  NoteDebitEnteteVentesDao var22 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
                  NoteDebitEnteteVentes var15 = var22.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
                  if (var15 != null) {
                     var4 = var15.getNdbTotReglement() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                     var15.setNdbTotReglement(var4);
                     if (var15.getNdbTotReglement() == var15.getNdbTotTtc() + var15.getNdbTotTc()) {
                        var15.setNdbSolde(1);
                        var1 = "01";
                     } else {
                        var15.setNdbSolde(0);
                        var1 = "02";
                     }

                     var22.modif(var15);
                  }
               } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 71) {
                  new ConsultationEnteteGene();
                  ConsultationEnteteGeneDao var20 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
                  ConsultationEnteteGene var13 = var20.selectById(this.reglements.getRglIdDocument(), (Session)null);
                  if (var13 != null) {
                     var4 = var13.getCsgRegPatient() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                     var13.setCsgRegPatient(var4);
                     if (var13.getCsgRegPatient() == var13.getCsgTotPatient()) {
                        var13.setCsgSoldePatient(1);
                        var1 = "01";
                     } else {
                        var13.setCsgSoldePatient(0);
                        var1 = "02";
                     }

                     var20.modif(var13);
                  }
               } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 73) {
                  new PharmacieEntete();
                  PharmacieEnteteDao var18 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
                  PharmacieEntete var11 = var18.selectById(this.reglements.getRglIdDocument(), (Session)null);
                  if (var11 != null) {
                     var4 = var11.getPhaRegPatient() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                     var11.setPhaRegPatient(var4);
                     if (var11.getPhaRegPatient() == var11.getPhaTotPatient()) {
                        var11.setPhaSoldePatient(1);
                        var1 = "01";
                     } else {
                        var11.setPhaSoldePatient(0);
                        var1 = "02";
                     }

                     var18.modif(var11);
                  }
               } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 74) {
                  new LaboratoireEntete();
                  LaboratoireEnteteDao var16 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
                  LaboratoireEntete var10 = var16.selectById(this.reglements.getRglIdDocument(), (Session)null);
                  if (var10 != null) {
                     var4 = var10.getLabRegPatient() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                     var10.setLabRegPatient(var4);
                     if (var10.getLabRegPatient() == var10.getLabTotPatient()) {
                        var10.setLabSoldePatient(1);
                        var1 = "01";
                     } else {
                        var10.setLabSoldePatient(0);
                        var1 = "02";
                     }

                     var16.modif(var10);
                  }
               } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 76) {
                  new HospitalisationEntete();
                  HospitalisationEnteteDao var14 = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
                  HospitalisationEntete var9 = var14.selectById(this.reglements.getRglIdDocument(), (Session)null);
                  if (var9 != null) {
                     var4 = var9.getHosRegPatient() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                     var9.setHosRegPatient(var4);
                     if (var9.getHosRegPatient() == var9.getHosTotPatient()) {
                        var9.setHosSoldePatient(1);
                        var1 = "01";
                     } else {
                        var9.setHosSoldePatient(0);
                        var1 = "02";
                     }

                     var14.modif(var9);
                  }
               } else {
                  double var6;
                  if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 165) {
                     new BienFacture();
                     BienFactureDao var12 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
                     BienFacture var8 = var12.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
                     if (var8 != null) {
                        var4 = var8.getBiefacTotReglement() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                        var6 = var8.getBiefacTotTimbre() - this.reglements.getRglTimbre() + this.bonCaisse.getTimbre();
                        var8.setBiefacTotReglement(var4);
                        var8.setBiefacTotTimbre(var6);
                        if (var8.getBiefacTotReglement() == var8.getBiefacTotTtc()) {
                           var8.setBiefacSolde(1);
                           var1 = "01";
                        } else {
                           var8.setBiefacSolde(0);
                           var1 = "02";
                        }

                        var12.modif(var8);
                     }
                  } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 173) {
                     new AppelCharge();
                     AppelChargeDao var3 = new AppelChargeDao(this.baseLog, this.utilInitHibernate);
                     AppelCharge var2 = var3.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
                     if (var2 != null) {
                        var4 = var2.getAppchaTotReglement() - this.reglements.getRglRecette() + this.bonCaisse.getBonCaisMontant();
                        var6 = var2.getAppchaTotTimbre() - this.reglements.getRglTimbre() + this.bonCaisse.getTimbre();
                        var2.setAppchaTotReglement(var4);
                        var2.setAppchaTotTimbre(var6);
                        if (var2.getAppchaTotReglement() == var2.getAppchaTotTtc()) {
                           var2.setAppchaSolde(1);
                           var1 = "01";
                        } else {
                           var2.setAppchaSolde(0);
                           var1 = "02";
                        }

                        var3.modif(var2);
                     }
                  }
               }
            }

            if (this.reglements.getRglNatureDoc() >= 15 && this.reglements.getRglNatureDoc() <= 18 || this.reglements.getRglNatureDoc() >= 22 && this.reglements.getRglNatureDoc() <= 27 || this.reglements.getRglNatureDoc() == 165 || this.reglements.getRglNatureDoc() == 173 || this.reglements.getRglNatureDoc() == 0 && this.reglements.getRglCategorie() >= 62 && this.reglements.getRglCategorie() <= 64 || this.reglements.getRglNatureDoc() >= 71 && this.reglements.getRglNatureDoc() <= 79 || this.reglements.getRglNatureDoc() == 64 && this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && (this.reglements.getRglOperation().equals("71") || this.reglements.getRglOperation().equals("73") || this.reglements.getRglOperation().equals("74") || this.reglements.getRglOperation().equals("76") || this.reglements.getRglOperation().equals("77") || this.reglements.getRglOperation().equals("80") || this.reglements.getRglOperation().equals("81") || this.reglements.getRglOperation().equals("82"))) {
               EspionDao var31 = new EspionDao(this.baseLog, this.utilInitHibernate);
               Espion var36 = new Espion();
               var36.setUsers(this.usersLog);
               var36.setEsptype(0);
               var36.setEspdtecreat(new Date());
               var36.setEspaction("Modification Reçu N° " + this.reglements.getRglNum() + " du " + this.utilDate.dateToStringFr(this.reglements.getRglDateReg()));
               var31.mAJEspion(var36);
               this.reglements.setRglRecette(this.bonCaisse.getBonCaisMontant());
               this.reglements.setRglTimbre(this.bonCaisse.getTimbre());
               this.reglements.setRglDateReg(this.bonCaisse.getBonCaisDate());
               this.reglements.setRglNumChqBdx(this.bonCaisse.getBonCaisNumChqBdx());
               this.reglements.setRglBanqueTireur(this.bonCaisse.getBonCaisBanqueTirreur());
               this.reglements.setRglLibelle(this.bonCaisse.getBonCaisLibelle());
               this.reglements.setRglModele(this.bonCaisse.getBonCaisModeleImp());
               this.reglements.setRglOperation(var1);
               this.reglements.setRglCodeCaiss("");
               this.reglements.setRglLibCaiss("");
               if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
                  this.var_modeReglement = "0";
               }

               this.reglements.setRglMode(this.var_modeReglement);
               this.reglements.setRglTypeReg(Integer.parseInt(this.var_modeReglement));
               if (this.var_caisse != null && !this.var_caisse.isEmpty() && !this.var_caisse.equals("100")) {
                  String[] var37 = this.var_caisse.split(":");
                  this.reglements.setRglCodeCaiss(var37[0]);
                  this.reglements.setRglLibCaiss(var37[1]);
               } else {
                  this.reglements.setRglCodeCaiss("");
                  this.reglements.setRglLibCaiss("");
               }

               String var38 = "";
               if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                  var38 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
               } else {
                  var38 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
               }

               String var24 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
               this.reglements.setRglPeriode(var38 + ":" + var24);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               String var33 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var33);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var33);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglements = this.reglementsDao.modifier(this.reglements);
            }
         }
      }

      this.annulerSaisie();
      this.chargerFind();
   }

   public void annulerRecu() throws HibernateException, NamingException, ParseException {
      if (this.bonCaisse != null) {
         this.regul = false;
         this.reglements = this.reglementsDao.pourParapheur(this.bonCaisse.getBonCaisId(), (Session)null);
         if (this.reglements != null) {
            if (!this.reglements.isRglAnnuler()) {
               this.reglements.setRglInfo10((String)null);
               this.showModalPanelMotifAnnuler = true;
            } else {
               this.texteMessae = "Ce reçu a déjà été annulé. Il ne peut pas être encore annulé....";
               this.showModalpanelMessage = true;
            }
         }
      }

   }

   public void validationAnnulerRecu() throws HibernateException, NamingException, ParseException {
      if (this.reglements != null && this.reglements.getRglInfo10() != null && !this.reglements.getRglInfo10().isEmpty()) {
         this.annuleSupressCommun();
         if (this.reglements.getRglNatureDoc() >= 15 && this.reglements.getRglNatureDoc() <= 18 || this.reglements.getRglNatureDoc() >= 22 && this.reglements.getRglNatureDoc() <= 27 || this.reglements.getRglNatureDoc() == 165 || this.reglements.getRglNatureDoc() == 173 || this.reglements.getRglNatureDoc() == 64 || this.reglements.getRglNatureDoc() == 0 && this.reglements.getRglCategorie() >= 62 && this.reglements.getRglCategorie() <= 64 || this.reglements.getRglNatureDoc() >= 71 && this.reglements.getRglNatureDoc() <= 79 || this.reglements.getRglNatureDoc() == 64 && this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && (this.reglements.getRglOperation().equals("71") || this.reglements.getRglOperation().equals("73") || this.reglements.getRglOperation().equals("74") || this.reglements.getRglOperation().equals("76") || this.reglements.getRglOperation().equals("77") || this.reglements.getRglOperation().equals("80") || this.reglements.getRglOperation().equals("81") || this.reglements.getRglOperation().equals("82"))) {
            EspionDao var1 = new EspionDao(this.baseLog, this.utilInitHibernate);
            Espion var2 = new Espion();
            var2.setUsers(this.usersLog);
            var2.setEsptype(0);
            var2.setEspdtecreat(new Date());
            var2.setEspaction("Annulation Reçu N° " + this.reglements.getRglNum() + " du " + this.utilDate.dateToStringFr(this.reglements.getRglDateReg()));
            var1.mAJEspion(var2);
            this.reglements.setRglAnnuler(true);
            this.reglements = this.reglementsDao.modifier(this.reglements);
            if (this.reglements.getRglNatureDoc() == 64 && this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && (this.reglements.getRglOperation().equals("71") || this.reglements.getRglOperation().equals("73") || this.reglements.getRglOperation().equals("74") || this.reglements.getRglOperation().equals("76") || this.reglements.getRglOperation().equals("77") || this.reglements.getRglOperation().equals("80") || this.reglements.getRglOperation().equals("81") || this.reglements.getRglOperation().equals("82") || this.reglements.getRglOperation().equals("83") || this.reglements.getRglOperation().equals("84") || this.reglements.getRglOperation().equals("85")) && this.reglements.getRglNum() != null && !this.reglements.getRglNum().isEmpty()) {
               this.annulationPiece();
            } else {
               this.annulationSimple();
            }

            this.visibiliteBton = false;
            this.chargerFind();
         }
      }

      this.showModalPanelMotifAnnuler = false;
   }

   public void annulationSimple() throws HibernateException, NamingException {
      new Reglements();
      Reglements var1 = this.reglements;
      this.reglements = new Reglements();
      this.reglements.setRglActivite(var1.getRglActivite());
      this.reglements.setRglBanqueTireur(var1.getRglBanqueTireur());
      this.reglements.setRglBudget(var1.getRglBudget());
      this.reglements.setRglBon(var1.getRglBon());
      this.reglements.setRglCategorie(var1.getRglCategorie());
      this.reglements.setRglCodeCaiss(var1.getRglCodeCaiss());
      this.reglements.setRglLibCaiss(var1.getRglLibCaiss());
      this.reglements.setRglCodeEmetrice(var1.getRglCodeEmetrice());
      this.reglements.setRglCodeReceptrice(var1.getRglCodeReceptrice());
      this.reglements.setRglDateCreation(new Date());
      this.reglements.setRglDateImp((Date)null);
      this.reglements.setRglDateTransfert((Date)null);
      this.reglements.setRglDateValeur((Date)null);
      this.reglements.setRglDepartement(var1.getRglDepartement());
      this.reglements.setRglDevise(var1.getRglDevise());
      this.reglements.setRglDossier(var1.getRglDossier());
      this.reglements.setRglFormatDevise(var1.getRglFormatDevise());
      this.reglements.setRglDocument(var1.getRglDocument());
      this.reglements.setRglIdCaissier(var1.getRglIdCaissier());
      this.reglements.setRglIdBon(var1.getRglIdBon());
      this.reglements.setRglIdDocument(var1.getRglIdDocument());
      this.reglements.setRglIdTiers(var1.getRglIdTiers());
      this.reglements.setRglInfo10(var1.getRglInfo10());
      this.reglements.setRglDepotTiers(var1.getRglDepotTiers());
      this.reglements.setRglLibEmetrice(var1.getRglLibEmetrice());
      this.reglements.setRglLibReceptrice(var1.getRglLibReceptrice());
      this.reglements.setRglLibelle("ANNULATION " + var1.getRglLibelle());
      this.reglements.setRglMode(var1.getRglMode());
      this.reglements.setRglModele(var1.getRglModele());
      this.reglements.setRglNumChqBdx(var1.getRglNumChqBdx());
      this.reglements.setRglNatureDoc(var1.getRglNatureDoc());
      this.reglements.setRglNomCaissier(var1.getRglNomCaissier());
      this.reglements.setRglNomResponsable(var1.getRglNomResponsable());
      this.reglements.setRglNomTiers(var1.getRglNomTiers());
      this.reglements.setRglNum(var1.getRglNum());
      this.reglements.setRglObjet(var1.getRglObjet());
      this.reglements.setRglOperation(var1.getRglOperation());
      this.reglements.setRglParc(var1.getRglParc());
      this.reglements.setRglPdv(var1.getRglPdv());
      this.reglements.setRglRegion(var1.getRglRegion());
      this.reglements.setRglSecteur(var1.getRglSecteur());
      this.reglements.setRglSerie(var1.getRglSerie());
      this.reglements.setRglService(var1.getRglService());
      this.reglements.setRglSite(var1.getRglSite());
      this.reglements.setRglTrf(var1.getRglTrf());
      this.reglements.setRglTypeReg(var1.getRglTypeReg());
      this.reglements.setRglTypeTiers(var1.getRglTypeTiers());
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglUserModif(0L);
      if (this.optionCaisses.getDateSuppression().equals("1")) {
         this.reglements.setRglDateReg(new Date());
      } else {
         this.reglements.setRglDateReg(var1.getRglDateReg());
      }

      this.reglements.setRglDepense(var1.getRglDepense() * -1.0D);
      this.reglements.setRglRecette(var1.getRglRecette() * -1.0D);
      this.reglements.setRglTimbre(var1.getRglTimbre() * -1.0D);
      String var2 = "";
      if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
         var2 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
      } else {
         var2 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
      }

      String var3 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
      this.reglements.setRglPeriode(var2 + ":" + var3);
      this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
      String var4 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
      this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var4);
      this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
      this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var4);
      this.reglements.setRglAnnuler(true);
      this.reglements.setExercicesCaisse(this.selectedExo);
      this.reglements = this.reglementsDao.insert(this.reglements);
      this.annuleReglementMedic(var1.getRglId(), this.reglements.getRglId(), this.reglements.getRglNum(), this.reglements.getRglCodeCaiss(), this.reglements.getRglDateReg());
   }

   public void annulationPiece() throws HibernateException, NamingException, ParseException {
      String var1 = "rglNum='" + this.reglements.getRglNum() + "' and rglCategorie=" + this.reglements.getRglCategorie() + " and rglOperation='" + this.reglements.getRglOperation() + "' and rglDateReg='" + this.reglements.getRglDateReg() + "'";
      new ArrayList();
      List var2 = this.reglementsDao.rechercheReglementsRequete(var1, (Session)null);
      if (var2.size() != 0) {
         new Reglements();
         new Reglements();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            Reglements var3 = (Reglements)var2.get(var5);
            this.reglements = new Reglements();
            this.reglements.setRglActivite(var3.getRglActivite());
            this.reglements.setRglBanqueTireur(var3.getRglBanqueTireur());
            this.reglements.setRglBudget(var3.getRglBudget());
            this.reglements.setRglBon(var3.getRglBon());
            this.reglements.setRglCategorie(var3.getRglCategorie());
            this.reglements.setRglCodeCaiss(var3.getRglCodeCaiss());
            this.reglements.setRglLibCaiss(var3.getRglLibCaiss());
            this.reglements.setRglCodeEmetrice(var3.getRglCodeEmetrice());
            this.reglements.setRglCodeReceptrice(var3.getRglCodeReceptrice());
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDepartement(var3.getRglDepartement());
            this.reglements.setRglDevise(var3.getRglDevise());
            this.reglements.setRglDossier(var3.getRglDossier());
            this.reglements.setRglFormatDevise(var3.getRglFormatDevise());
            this.reglements.setRglDocument(var3.getRglDocument());
            this.reglements.setRglIdCaissier(var3.getRglIdCaissier());
            this.reglements.setRglIdBon(var3.getRglIdBon());
            this.reglements.setRglIdDocument(var3.getRglIdDocument());
            this.reglements.setRglIdTiers(var3.getRglIdTiers());
            this.reglements.setRglInfo10(var3.getRglInfo10());
            this.reglements.setRglDepotTiers(var3.getRglDepotTiers());
            this.reglements.setRglLibEmetrice(var3.getRglLibEmetrice());
            this.reglements.setRglLibReceptrice(var3.getRglLibReceptrice());
            this.reglements.setRglLibelle("ANNULATION " + var3.getRglLibelle());
            this.reglements.setRglMode(var3.getRglMode());
            this.reglements.setRglModele(var3.getRglModele());
            this.reglements.setRglNumChqBdx(var3.getRglNumChqBdx());
            this.reglements.setRglNatureDoc(var3.getRglNatureDoc());
            this.reglements.setRglNomCaissier(var3.getRglNomCaissier());
            this.reglements.setRglNomResponsable(var3.getRglNomResponsable());
            this.reglements.setRglNomTiers(var3.getRglNomTiers());
            this.reglements.setRglNum(var3.getRglNum());
            this.reglements.setRglObjet(var3.getRglObjet());
            this.reglements.setRglOperation(var3.getRglOperation());
            this.reglements.setRglParc(var3.getRglParc());
            this.reglements.setRglPdv(var3.getRglPdv());
            this.reglements.setRglRegion(var3.getRglRegion());
            this.reglements.setRglSecteur(var3.getRglSecteur());
            this.reglements.setRglSerie(var3.getRglSerie());
            this.reglements.setRglService(var3.getRglService());
            this.reglements.setRglSite(var3.getRglSite());
            this.reglements.setRglTrf(var3.getRglTrf());
            this.reglements.setRglTypeReg(var3.getRglTypeReg());
            this.reglements.setRglTypeTiers(var3.getRglTypeTiers());
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglUserModif(0L);
            if (this.optionCaisses.getDateSuppression().equals("1")) {
               this.reglements.setRglDateReg(new Date());
            } else {
               this.reglements.setRglDateReg(var3.getRglDateReg());
            }

            this.reglements.setRglDepense(var3.getRglDepense() * -1.0D);
            this.reglements.setRglRecette(var3.getRglRecette() * -1.0D);
            this.reglements.setRglTimbre(var3.getRglTimbre() * -1.0D);
            String var6 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var6 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var6 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            String var7 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var6 + ":" + var7);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            String var8 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var8);
            this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
            this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var8);
            this.reglements.setRglAnnuler(true);
            this.reglements.setExercicesCaisse(this.selectedExo);
            this.reglements = this.reglementsDao.insert(this.reglements);
         }
      }

   }

   public void supprimerRecu() throws HibernateException, NamingException, ParseException {
      if (this.bonCaisse != null) {
         this.regul = false;
         this.reglements = this.reglementsDao.pourParapheur(this.bonCaisse.getBonCaisId(), (Session)null);
         if (this.reglements != null) {
            if (!this.reglements.isRglAnnuler()) {
               this.reglements.setRglInfo10((String)null);
               this.showModalPanelMotifSupprimer = true;
            } else {
               this.texteMessae = "Ce reçu a déjà été supprimé. Il ne peut pas être encore supprimé....";
               this.showModalpanelMessage = true;
            }
         }
      }

   }

   public void validationSupprimerRecu() throws HibernateException, NamingException, ParseException {
      if (this.reglements != null && this.reglements.getRglInfo10() != null && !this.reglements.getRglInfo10().isEmpty()) {
         this.annuleSupressCommun();
         if (this.reglements.getRglNatureDoc() >= 15 && this.reglements.getRglNatureDoc() <= 18 || this.reglements.getRglNatureDoc() >= 22 && this.reglements.getRglNatureDoc() <= 27 || this.reglements.getRglNatureDoc() == 165 || this.reglements.getRglNatureDoc() == 173 || this.reglements.getRglNatureDoc() == 64 || this.reglements.getRglNatureDoc() == 0 && this.reglements.getRglCategorie() >= 62 && this.reglements.getRglCategorie() <= 64 || this.reglements.getRglNatureDoc() >= 71 && this.reglements.getRglNatureDoc() <= 79 || this.reglements.getRglNatureDoc() == 64 && this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && (this.reglements.getRglOperation().equals("71") || this.reglements.getRglOperation().equals("73") || this.reglements.getRglOperation().equals("74") || this.reglements.getRglOperation().equals("76") || this.reglements.getRglOperation().equals("77") || this.reglements.getRglOperation().equals("80") || this.reglements.getRglOperation().equals("81") || this.reglements.getRglOperation().equals("82"))) {
            EspionDao var1 = new EspionDao(this.baseLog, this.utilInitHibernate);
            Espion var2 = new Espion();
            var2.setUsers(this.usersLog);
            var2.setEsptype(0);
            var2.setEspdtecreat(new Date());
            var2.setEspaction("Suppression Reçu N° " + this.reglements.getRglNum() + " du " + this.utilDate.dateToStringFr(this.reglements.getRglDateReg()));
            var1.mAJEspion(var2);
            this.reglements.setRglAnnuler(true);
            this.reglements = this.reglementsDao.modifier(this.reglements);
            if (this.reglements.getRglNatureDoc() == 64 && this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && (this.reglements.getRglOperation().equals("71") || this.reglements.getRglOperation().equals("73") || this.reglements.getRglOperation().equals("74") || this.reglements.getRglOperation().equals("76") || this.reglements.getRglOperation().equals("77") || this.reglements.getRglOperation().equals("80") || this.reglements.getRglOperation().equals("81") || this.reglements.getRglOperation().equals("82") || this.reglements.getRglOperation().equals("83") || this.reglements.getRglOperation().equals("84") || this.reglements.getRglOperation().equals("85")) && this.reglements.getRglNum() != null && !this.reglements.getRglNum().isEmpty()) {
               this.suppressionPiece();
            } else {
               this.suppressionSimple();
            }

            this.visibiliteBton = false;
            this.chargerFind();
         }
      }

      this.showModalPanelMotifSupprimer = false;
   }

   public void suppressionSimple() throws HibernateException, NamingException {
      if (this.reglements.getRglDateTransfert() == null) {
         this.reglementsDao.delete(this.reglements);
         this.lesElements.remove(this.bonCaisse);
         this.datamodelElement.setWrappedData(this.lesElements);
      } else {
         new Reglements();
         Reglements var1 = this.reglements;
         this.reglements = new Reglements();
         this.reglements.setRglActivite(var1.getRglActivite());
         this.reglements.setRglBanqueTireur(var1.getRglBanqueTireur());
         this.reglements.setRglBudget(var1.getRglBudget());
         this.reglements.setRglBon(var1.getRglBon());
         this.reglements.setRglCategorie(var1.getRglCategorie());
         this.reglements.setRglCodeCaiss(var1.getRglCodeCaiss());
         this.reglements.setRglLibCaiss(var1.getRglLibCaiss());
         this.reglements.setRglCodeEmetrice(var1.getRglCodeEmetrice());
         this.reglements.setRglCodeReceptrice(var1.getRglCodeReceptrice());
         this.reglements.setRglDateCreation(new Date());
         this.reglements.setRglDateImp((Date)null);
         this.reglements.setRglDateTransfert((Date)null);
         this.reglements.setRglDateValeur((Date)null);
         this.reglements.setRglDepartement(var1.getRglDepartement());
         this.reglements.setRglDevise(var1.getRglDevise());
         this.reglements.setRglDossier(var1.getRglDossier());
         this.reglements.setRglFormatDevise(var1.getRglFormatDevise());
         this.reglements.setRglDocument(var1.getRglDocument());
         this.reglements.setRglIdCaissier(var1.getRglIdCaissier());
         this.reglements.setRglIdBon(var1.getRglIdBon());
         this.reglements.setRglIdDocument(var1.getRglIdDocument());
         this.reglements.setRglIdTiers(var1.getRglIdTiers());
         this.reglements.setRglInfo10(var1.getRglInfo10());
         this.reglements.setRglDepotTiers(var1.getRglDepotTiers());
         this.reglements.setRglLibEmetrice(var1.getRglLibEmetrice());
         this.reglements.setRglLibReceptrice(var1.getRglLibReceptrice());
         this.reglements.setRglLibelle("ANNULATION " + var1.getRglLibelle());
         this.reglements.setRglMode(var1.getRglMode());
         this.reglements.setRglModele(var1.getRglModele());
         this.reglements.setRglNumChqBdx(var1.getRglNumChqBdx());
         this.reglements.setRglNatureDoc(var1.getRglNatureDoc());
         this.reglements.setRglNomCaissier(var1.getRglNomCaissier());
         this.reglements.setRglNomResponsable(var1.getRglNomResponsable());
         this.reglements.setRglNomTiers(var1.getRglNomTiers());
         this.reglements.setRglNum(var1.getRglNum());
         this.reglements.setRglObjet(var1.getRglObjet());
         this.reglements.setRglOperation(var1.getRglOperation());
         this.reglements.setRglParc(var1.getRglParc());
         this.reglements.setRglPdv(var1.getRglPdv());
         this.reglements.setRglRegion(var1.getRglRegion());
         this.reglements.setRglSecteur(var1.getRglSecteur());
         this.reglements.setRglSerie(var1.getRglSerie());
         this.reglements.setRglService(var1.getRglService());
         this.reglements.setRglSite(var1.getRglSite());
         this.reglements.setRglTrf(var1.getRglTrf());
         this.reglements.setRglTypeReg(var1.getRglTypeReg());
         this.reglements.setRglTypeTiers(var1.getRglTypeTiers());
         this.reglements.setRglUserCreat(this.usersLog.getUsrid());
         this.reglements.setRglUserModif(0L);
         if (this.optionCaisses.getDateSuppression().equals("1")) {
            this.reglements.setRglDateReg(new Date());
         } else {
            this.reglements.setRglDateReg(var1.getRglDateReg());
         }

         this.reglements.setRglDepense(var1.getRglDepense() * -1.0D);
         this.reglements.setRglRecette(var1.getRglRecette() * -1.0D);
         this.reglements.setRglTimbre(var1.getRglTimbre() * -1.0D);
         String var2 = "";
         if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
            var2 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
         } else {
            var2 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
         }

         String var3 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
         this.reglements.setRglPeriode(var2 + ":" + var3);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         String var4 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var4);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var4);
         this.reglements.setExercicesCaisse(this.selectedExo);
         this.reglements = this.reglementsDao.insert(this.reglements);
         this.annuleReglementMedic(var1.getRglId(), this.reglements.getRglId(), this.reglements.getRglNum(), this.reglements.getRglCodeCaiss(), this.reglements.getRglDateReg());
      }

   }

   public void suppressionPiece() throws HibernateException, NamingException, ParseException {
      String var1 = "rglNum='" + this.reglements.getRglNum() + "' and rglCategorie=" + this.reglements.getRglCategorie() + " and rglOperation='" + this.reglements.getRglOperation() + "' and rglDateReg='" + this.reglements.getRglDateReg() + "'";
      new ArrayList();
      List var2 = this.reglementsDao.rechercheReglementsRequete(var1, (Session)null);
      if (var2.size() != 0) {
         Reglements var3;
         if (this.reglements.getRglDateTransfert() == null) {
            new Reglements();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               var3 = (Reglements)var2.get(var4);
               this.reglementsDao.delete(var3);
            }
         } else {
            new Reglements();
            new Reglements();

            for(int var5 = 0; var5 < var2.size(); ++var5) {
               var3 = (Reglements)var2.get(var5);
               this.reglements = new Reglements();
               this.reglements.setRglActivite(var3.getRglActivite());
               this.reglements.setRglBanqueTireur(var3.getRglBanqueTireur());
               this.reglements.setRglBudget(var3.getRglBudget());
               this.reglements.setRglBon(var3.getRglBon());
               this.reglements.setRglCategorie(var3.getRglCategorie());
               this.reglements.setRglCodeCaiss(var3.getRglCodeCaiss());
               this.reglements.setRglLibCaiss(var3.getRglLibCaiss());
               this.reglements.setRglCodeEmetrice(var3.getRglCodeEmetrice());
               this.reglements.setRglCodeReceptrice(var3.getRglCodeReceptrice());
               this.reglements.setRglDateCreation(new Date());
               this.reglements.setRglDateImp((Date)null);
               this.reglements.setRglDateTransfert((Date)null);
               this.reglements.setRglDateValeur((Date)null);
               this.reglements.setRglDepartement(var3.getRglDepartement());
               this.reglements.setRglDevise(var3.getRglDevise());
               this.reglements.setRglDossier(var3.getRglDossier());
               this.reglements.setRglFormatDevise(var3.getRglFormatDevise());
               this.reglements.setRglDocument(var3.getRglDocument());
               this.reglements.setRglIdCaissier(var3.getRglIdCaissier());
               this.reglements.setRglIdBon(var3.getRglIdBon());
               this.reglements.setRglIdDocument(var3.getRglIdDocument());
               this.reglements.setRglIdTiers(var3.getRglIdTiers());
               this.reglements.setRglInfo10(var3.getRglInfo10());
               this.reglements.setRglDepotTiers(var3.getRglDepotTiers());
               this.reglements.setRglLibEmetrice(var3.getRglLibEmetrice());
               this.reglements.setRglLibReceptrice(var3.getRglLibReceptrice());
               this.reglements.setRglLibelle("ANNULATION " + var3.getRglLibelle());
               this.reglements.setRglMode(var3.getRglMode());
               this.reglements.setRglModele(var3.getRglModele());
               this.reglements.setRglNumChqBdx(var3.getRglNumChqBdx());
               this.reglements.setRglNatureDoc(var3.getRglNatureDoc());
               this.reglements.setRglNomCaissier(var3.getRglNomCaissier());
               this.reglements.setRglNomResponsable(var3.getRglNomResponsable());
               this.reglements.setRglNomTiers(var3.getRglNomTiers());
               this.reglements.setRglNum(var3.getRglNum());
               this.reglements.setRglObjet(var3.getRglObjet());
               this.reglements.setRglOperation(var3.getRglOperation());
               this.reglements.setRglParc(var3.getRglParc());
               this.reglements.setRglPdv(var3.getRglPdv());
               this.reglements.setRglRegion(var3.getRglRegion());
               this.reglements.setRglSecteur(var3.getRglSecteur());
               this.reglements.setRglSerie(var3.getRglSerie());
               this.reglements.setRglService(var3.getRglService());
               this.reglements.setRglSite(var3.getRglSite());
               this.reglements.setRglTrf(var3.getRglTrf());
               this.reglements.setRglTypeReg(var3.getRglTypeReg());
               this.reglements.setRglTypeTiers(var3.getRglTypeTiers());
               this.reglements.setRglUserCreat(this.usersLog.getUsrid());
               this.reglements.setRglUserModif(0L);
               if (this.optionCaisses.getDateSuppression().equals("1")) {
                  this.reglements.setRglDateReg(new Date());
               } else {
                  this.reglements.setRglDateReg(var3.getRglDateReg());
               }

               this.reglements.setRglDepense(var3.getRglDepense() * -1.0D);
               this.reglements.setRglRecette(var3.getRglRecette() * -1.0D);
               this.reglements.setRglTimbre(var3.getRglTimbre() * -1.0D);
               String var6 = "";
               if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
                  var6 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
               } else {
                  var6 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
               }

               String var7 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
               this.reglements.setRglPeriode(var6 + ":" + var7);
               this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
               String var8 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
               this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var8);
               this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
               this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var8);
               this.reglements.setExercicesCaisse(this.selectedExo);
               this.reglements = this.reglementsDao.insert(this.reglements);
            }
         }
      }

   }

   public void annuleSupressCommun() throws HibernateException, NamingException {
      double var3;
      if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 15) {
         new FactureEnteteAchats();
         FactureEnteteAchatsDao var64 = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         FactureEnteteAchats var57 = var64.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
         if (var57 != null) {
            var3 = var57.getFcfTotReglement() - this.reglements.getRglRecette();
            var57.setFcfTotReglement(var3);
            var57.setFcfSolde(0);
            var64.modif(var57);
         }
      } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 16) {
         new AvoirEnteteAchats();
         AvoirEnteteAchatsDao var63 = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         AvoirEnteteAchats var54 = var63.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
         if (var54 != null) {
            var3 = var54.getAvfTotReglement() - this.reglements.getRglRecette();
            var54.setAvfTotReglement(var3);
            var54.setAvfSolde(0);
            var63.modif(var54);
         }
      } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 17) {
         new NoteDebitEnteteAchats();
         NoteDebitEnteteAchatsDao var62 = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         NoteDebitEnteteAchats var51 = var62.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
         if (var51 != null) {
            var3 = var51.getNdfTotReglement() - this.reglements.getRglRecette();
            var51.setNdfTotReglement(var3);
            var51.setNdfSolde(0);
            var62.modif(var51);
         }
      } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 18) {
         new FraisEnteteAchats();
         FraisEnteteAchatsDao var61 = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
         FraisEnteteAchats var49 = var61.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
         if (var49 != null) {
            var3 = var49.getFsfTotReglement() - this.reglements.getRglRecette();
            var49.setFsfTotReglement(var3);
            var49.setFsfSolde(0);
            var61.modif(var49);
         }
      } else {
         double var60;
         if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 22) {
            new CommandeEnteteVentes();
            CommandeEnteteVentes var47 = this.commandeEnteteVentesDao.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
            if (var47 != null) {
               var60 = var47.getBcmTotReglement() - this.reglements.getRglRecette();
               var47.setBcmTotReglement(var60);
               var47.setBcmSolde(0);
               this.commandeEnteteVentesDao.modif(var47);
            }
         } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 25) {
            new FactureEnteteVentes();
            this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            FactureEnteteVentes var46 = this.factureEnteteVentesDao.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
            if (var46 != null) {
               var60 = var46.getFacTotReglement() - this.reglements.getRglRecette();
               double var55 = var46.getFacTotTimbre() - this.reglements.getRglTimbre();
               var46.setFacTotReglement(var60);
               var46.setFacTotTimbre(var55);
               var46.setFacSolde(0);
               this.factureEnteteVentesDao.modif(var46);
            }
         } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 26) {
            new AvoirEnteteVentes();
            AvoirEnteteVentesDao var58 = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            AvoirEnteteVentes var44 = var58.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
            if (var44 != null) {
               var3 = var44.getAvrTotReglement() - this.reglements.getRglRecette();
               var44.setAvrTotReglement(var3);
               var44.setAvrSolde(0);
               var58.modif(var44);
            }
         } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 27) {
            new NoteDebitEnteteVentes();
            NoteDebitEnteteVentesDao var56 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            NoteDebitEnteteVentes var43 = var56.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
            if (var43 != null) {
               var3 = var43.getNdbTotReglement() - this.reglements.getRglRecette();
               var43.setNdbTotReglement(var3);
               var43.setNdbSolde(0);
               var56.modif(var43);
            }
         } else {
            AppelChargeDao var2;
            double var5;
            List var7;
            int var10;
            Session var40;
            Transaction var45;
            if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 71) {
               var40 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
               var2 = null;

               try {
                  var45 = var40.beginTransaction();
                  new ConsultationEnteteGene();
                  ConsultationEnteteGeneDao var52 = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
                  ConsultationEnteteGene var59 = var52.selectById(this.reglements.getRglIdDocument(), var40);
                  if (var59 != null) {
                     var5 = var59.getCsgRegPatient() - this.reglements.getRglRecette();
                     var59.setCsgRegPatient(var5);
                     var59.setCsgSoldePatient(0);
                     var59 = var52.modif(var59, var40);
                     new ArrayList();
                     ConsultationActesDao var66 = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
                     var7 = var66.selectConsActesByConsEnt(var59, var40);
                     if (var7.size() != 0) {
                        new ConsultationActes();

                        for(var10 = 0; var10 < var7.size(); ++var10) {
                           ConsultationActes var68 = (ConsultationActes)var7.get(var10);
                           if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && var59.getCsgService() != null && !var59.getCsgService().isEmpty() && var59.getCsgService().contains(":") && this.reglements.getRglService().equals(var59.getCsgService())) {
                              var68.setCslactRegPatient(0.0D);
                              var66.modif(var68, var40);
                           } else if (this.reglements.getRglService() == null || this.reglements.getRglService().isEmpty() || var59.getCsgService() == null || var59.getCsgService().isEmpty()) {
                              var68.setCslactRegPatient(0.0D);
                              var66.modif(var68, var40);
                           }
                        }
                     }
                  }

                  var45.commit();
               } catch (HibernateException var36) {
                  if (var2 != null) {
                     var2.rollback();
                  }

                  throw var36;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 73) {
               var40 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
               var2 = null;

               try {
                  var45 = var40.beginTransaction();
                  new PharmacieEntete();
                  PharmacieEnteteDao var50 = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
                  PharmacieEntete var53 = var50.selectById(this.reglements.getRglIdDocument(), var40);
                  if (var53 != null) {
                     var5 = var53.getPhaRegPatient() - this.reglements.getRglRecette();
                     var53.setPhaRegPatient(var5);
                     var53.setPhaSoldePatient(0);
                     var53 = var50.modif(var53, var40);
                     new ArrayList();
                     PharmacieLigneDao var65 = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
                     var7 = var65.selectConsActesByConsEnt(var53, var40);
                     if (var7.size() != 0) {
                        new PharmacieLigne();

                        for(var10 = 0; var10 < var7.size(); ++var10) {
                           PharmacieLigne var67 = (PharmacieLigne)var7.get(var10);
                           if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && var53.getPhaService() != null && !var53.getPhaService().isEmpty() && var53.getPhaService().contains(":") && this.reglements.getRglService().equals(var53.getPhaService())) {
                              var67.setPhaligRegPatient(0.0D);
                              var65.modif(var67, var40);
                           } else if (this.reglements.getRglService() == null || this.reglements.getRglService().isEmpty() || var53.getPhaService() == null || var53.getPhaService().isEmpty()) {
                              var67.setPhaligRegPatient(0.0D);
                              var65.modif(var67, var40);
                           }
                        }
                     }
                  }

                  var45.commit();
               } catch (HibernateException var34) {
                  if (var2 != null) {
                     var2.rollback();
                  }

                  throw var34;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 74) {
               var40 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
               var2 = null;

               try {
                  var45 = var40.beginTransaction();
                  new LaboratoireEntete();
                  LaboratoireEnteteDao var4 = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
                  LaboratoireEntete var48 = var4.selectById(this.reglements.getRglIdDocument(), var40);
                  if (var48 != null) {
                     var5 = var48.getLabRegPatient() - this.reglements.getRglRecette();
                     var48.setLabRegPatient(var5);
                     var48.setLabSoldePatient(0);
                     var48 = var4.modif(var48, var40);
                     new ArrayList();
                     LaboratoireLigneDao var8 = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
                     var7 = var8.selectConsActesByConsEnt(var48, var40);
                     if (var7.size() != 0) {
                        new LaboratoireLigne();

                        for(var10 = 0; var10 < var7.size(); ++var10) {
                           LaboratoireLigne var9 = (LaboratoireLigne)var7.get(var10);
                           if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && var48.getLabService() != null && !var48.getLabService().isEmpty() && var48.getLabService().contains(":") && this.reglements.getRglService().equals(var48.getLabService())) {
                              var9.setLabligRegPatient(0.0D);
                              var8.modif(var9, var40);
                           } else if (this.reglements.getRglService() != null && !this.reglements.getRglService().isEmpty() && var9.getLabligLaboratoire() != null && !var9.getLabligLaboratoire().isEmpty() && var9.getLabligLaboratoire().contains(":") && this.reglements.getRglService().equals(var9.getLabligLaboratoire())) {
                              var9.setLabligRegPatient(0.0D);
                              var8.modif(var9, var40);
                           }
                        }
                     }
                  }

                  var45.commit();
               } catch (HibernateException var32) {
                  if (var2 != null) {
                     var2.rollback();
                  }

                  throw var32;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 76) {
               new HospitalisationEntete();
               HospitalisationEnteteDao var42 = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
               HospitalisationEntete var39 = var42.selectById(this.reglements.getRglIdDocument(), (Session)null);
               if (var39 != null) {
                  var3 = var39.getHosRegPatient() - this.reglements.getRglRecette();
                  var39.setHosRegPatient(var3);
                  var39.setHosSoldePatient(0);
                  var42.modif(var39);
               }
            } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 165) {
               new BienFacture();
               BienFactureDao var41 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
               BienFacture var38 = var41.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
               if (var38 != null) {
                  var3 = var38.getBiefacTotReglement() - this.reglements.getRglRecette();
                  var5 = var38.getBiefacTotTimbre() - this.reglements.getRglTimbre();
                  var38.setBiefacTotReglement(var3);
                  var38.setBiefacTotTimbre(var5);
                  var38.setBiefacSolde(0);
                  var41.modif(var38);
               }
            } else if (this.reglements.getRglIdDocument() != 0L && this.reglements.getRglNatureDoc() == 173) {
               new AppelCharge();
               var2 = new AppelChargeDao(this.baseLog, this.utilInitHibernate);
               AppelCharge var1 = var2.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
               if (var1 != null) {
                  var3 = var1.getAppchaTotReglement() - this.reglements.getRglRecette();
                  var5 = var1.getAppchaTotTimbre() - this.reglements.getRglTimbre();
                  var1.setAppchaTotReglement(var3);
                  var1.setAppchaTotTimbre(var5);
                  var1.setAppchaSolde(0);
                  var2.modif(var1);
               }
            } else if (this.reglements.getRglIdDocument() == 0L) {
               if (this.reglements.getRglCategorie() == 62) {
                  this.bonSortieCaiss = this.bonSortieCaissDao.selectById(this.reglements.getRglIdBon(), (Session)null);
                  if (this.bonSortieCaiss != null) {
                     this.bonSortieCaiss.setSortEtat(1);
                     this.bonSortieCaiss = this.bonSortieCaissDao.modif(this.bonSortieCaiss);
                  }
               } else if (this.reglements.getRglCategorie() == 63) {
                  this.bonEntreCaiss = this.bonEntreCaissDao.selectById(this.reglements.getRglIdBon(), (Session)null);
                  if (this.bonEntreCaiss != null) {
                     this.bonEntreCaiss.setEntrEtat(1);
                     this.bonEntreCaiss = this.bonEntreCaissDao.modif(this.bonEntreCaiss);
                  }
               } else if (this.reglements.getRglCategorie() == 64) {
                  this.virementInterne = this.virementInterneDao.selectById(this.reglements.getRglIdBon(), (Session)null);
                  if (this.virementInterne != null) {
                     this.virementInterne.setVirEtat(1);
                     this.virementInterne = this.virementInterneDao.modif(this.virementInterne);
                  }
               }
            }
         }
      }

   }

   public void annuleReglementMedic(long var1, long var3, String var5, String var6, Date var7) throws HibernateException, NamingException {
      List var8;
      int var12;
      if (this.reglements.getRglNatureDoc() == 71) {
         new ArrayList();
         ConsultationReglementDao var9 = new ConsultationReglementDao(this.baseLog, this.utilInitHibernate);
         var8 = var9.selectReglementByIdRecu(var1, (Session)null);
         if (var8.size() != 0) {
            new ConsultationReglement();
            new ConsultationReglement();

            for(var12 = 0; var12 < var8.size(); ++var12) {
               ConsultationReglement var10 = (ConsultationReglement)var8.get(var12);
               ConsultationReglement var11 = new ConsultationReglement();
               var11.setConsultationEnteteGene(var10.getConsultationEnteteGene());
               var11.setCsgregAssurance(var10.getCsgregAssurance() * -1.0D);
               var11.setCsgregCaisse(var6);
               var11.setCsgregComplementaire(var10.getCsgregComplementaire() * -1.0D);
               var11.setCsgregDate(var7);
               var11.setCsgregEtat(0);
               var11.setCsgregIdBonEncaissement(0L);
               var11.setCsgregIdRecu(var3);
               var11.setCsgregLibelle(var10.getCsgregLibelle());
               var11.setCsgregNumPieceTiers(var10.getCsgregNumPieceTiers());
               var11.setCsgregNumRecu(var5);
               var11.setCsgregPatient(var10.getCsgregPatient() * -1.0D);
               var11.setCsgregProduit(var10.getCsgregProduit());
               var11.setCsgregService(var10.getCsgregService());
               var11.setCsgregSociete(var10.getCsgregSociete() * -1.0D);
               var9.insert(var11);
            }
         }
      } else if (this.reglements.getRglNatureDoc() == 73) {
         new ArrayList();
         PharmacieReglementDao var13 = new PharmacieReglementDao(this.baseLog, this.utilInitHibernate);
         var8 = var13.selectReglementByIdRecu(var1, (Session)null);
         if (var8.size() != 0) {
            new PharmacieReglement();
            new PharmacieReglement();

            for(var12 = 0; var12 < var8.size(); ++var12) {
               PharmacieReglement var16 = (PharmacieReglement)var8.get(var12);
               PharmacieReglement var19 = new PharmacieReglement();
               var19.setPharmacieEntete(var16.getPharmacieEntete());
               var19.setPharegAssurance(var16.getPharegAssurance() * -1.0D);
               var19.setPharegCaisse(var6);
               var19.setPharegComplementaire(var16.getPharegComplementaire() * -1.0D);
               var19.setPharegDate(var7);
               var19.setPharegEtat(0);
               var19.setPharegIdBonEncaissement(0L);
               var19.setPharegIdRecu(var3);
               var19.setPharegLibelle(var16.getPharegLibelle());
               var19.setPharegNumPieceTiers(var16.getPharegNumPieceTiers());
               var19.setPharegNumRecu(var5);
               var19.setPharegPatient(var16.getPharegPatient() * -1.0D);
               var19.setPharegProduit(var16.getPharegProduit());
               var19.setPharegService(var16.getPharegService());
               var19.setPharegSociete(var16.getPharegSociete() * -1.0D);
               var13.insert(var19);
            }
         }
      } else if (this.reglements.getRglNatureDoc() == 74) {
         new ArrayList();
         LaboratoireReglementDao var14 = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
         var8 = var14.selectReglementByIdRecu(var1, (Session)null);
         if (var8.size() != 0) {
            new LaboratoireReglement();
            new LaboratoireReglement();

            for(var12 = 0; var12 < var8.size(); ++var12) {
               LaboratoireReglement var17 = (LaboratoireReglement)var8.get(var12);
               LaboratoireReglement var20 = new LaboratoireReglement();
               var20.setLaboratoireEntete(var17.getLaboratoireEntete());
               var20.setLabregAssurance(var17.getLabregAssurance() * -1.0D);
               var20.setLabregCaisse(var6);
               var20.setLabregComplementaire(var17.getLabregComplementaire() * -1.0D);
               var20.setLabregDate(var7);
               var20.setLabregEtat(0);
               var20.setLabregIdBonEncaissement(0L);
               var20.setLabregIdRecu(var3);
               var20.setLabregLaboratoire(var17.getLabregLaboratoire());
               var20.setLabregLibelle(var17.getLabregLibelle());
               var20.setLabregNumPieceTiers(var17.getLabregNumPieceTiers());
               var20.setLabregNumRecu(var5);
               var20.setLabregPatient(var17.getLabregPatient() * -1.0D);
               var20.setLabregProduit(var17.getLabregProduit());
               var20.setLabregService(var17.getLabregService());
               var20.setLabregSociete(var17.getLabregSociete() * -1.0D);
               var14.insert(var20);
            }
         }
      } else if (this.reglements.getRglNatureDoc() == 76) {
         new ArrayList();
         HospitalisationReglementDao var15 = new HospitalisationReglementDao(this.baseLog, this.utilInitHibernate);
         var8 = var15.selectReglementByIdRecu(var1, this.reglements.getRglIdDocument(), (Session)null);
         if (var8.size() != 0) {
            new HospitalisationReglement();
            new HospitalisationReglement();

            for(var12 = 0; var12 < var8.size(); ++var12) {
               HospitalisationReglement var18 = (HospitalisationReglement)var8.get(var12);
               HospitalisationReglement var21 = new HospitalisationReglement();
               var21.setHospitalisationEntete(var18.getHospitalisationEntete());
               var21.setHosregAssurance(var18.getHosregAssurance() * -1.0D);
               var21.setHosregCaisse(var6);
               var21.setHosregComplementaire(var18.getHosregComplementaire() * -1.0D);
               var21.setHosregDate(var7);
               var21.setHosregEtat(0);
               var21.setHosregIdBonEncaissement(0L);
               var21.setHosregIdRecu(var3);
               var21.setHosregLaboratoire(var18.getHosregLaboratoire());
               var21.setHosregNumPieceTiers(var18.getHosregNumPieceTiers());
               var21.setHosregNumRecu(var5);
               var21.setHosregPatient(var18.getHosregPatient() * -1.0D);
               var21.setHosregService(var18.getHosregService());
               var21.setHosregSociete(var18.getHosregSociete() * -1.0D);
               var15.insert(var21);
            }
         }
      }

   }

   public void fermerDetailReglement() {
      this.showModalpanelDetail = false;
   }

   public void majReglementJour() throws HibernateException, NamingException {
      if (this.reglements != null) {
         if (this.var_mode_reglement.contains(":")) {
            String[] var1 = this.var_mode_reglement.split(":");
            this.reglements.setRglMode(var1[0]);
            this.reglements.setRglTypeReg(Integer.parseInt(var1[0]));
         }

         String var4 = "";
         if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
            var4 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
         } else {
            var4 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
         }

         String var2 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
         this.reglements.setRglPeriode(var4 + ":" + var2);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         String var3 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var3);
         this.reglements.setRglCle3(this.reglements.getRglCodeReceptrice() + ":" + this.reglements.getRglPeriode());
         this.reglements.setRglCle4(this.reglements.getRglCodeReceptrice() + ":" + var3);
         this.reglements.setRglDateModif(new Date());
         this.reglements.setRglUserModif(this.usersLog.getUsrid());
         this.reglements = this.reglementsDao.modifier(this.reglements);
         this.showModalpanelDetail = false;
      }

   }

   public void calculCle1() throws HibernateException, NamingException {
      this.leDetailcle1.clear();
      this.affiche_Cle1 = false;
      if (this.reglements.getRglCle1Repartition() != null && !this.reglements.getRglCle1Repartition().isEmpty() && this.reglements.getRglCle1Repartition().contains(":")) {
         String[] var1 = this.reglements.getRglCle1Repartition().split(":");
         new PlansAnalytiques();
         PlansAnalytiquesDao var3 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         PlansAnalytiques var2 = var3.rechercheAnal("9", var1[0], (Session)null);
         if (var2 != null) {
            new ArrayList();
            PlanAnalytiqueRepartitionDao var5 = new PlanAnalytiqueRepartitionDao(this.baseLog, this.utilInitHibernate);
            List var4 = var5.chargerLesRepartitions((PlansAnalytiques)var2, (Session)null);
            if (var4.size() != 0) {
               for(int var6 = 0; var6 < var4.size(); ++var6) {
                  this.cleAnalytique = new CleAnalytique();
                  if (((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeActivite() != null && !((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeActivite().isEmpty()) {
                     this.cleAnalytique.setCleanaCode(((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeActivite());
                     this.cleAnalytique.setCleanaLibelle(((PlanAnalytiqueRepartition)var4.get(var6)).getCleLibelleActivite());
                     this.cleAnalytique.setCleanaTaux((float)((PlanAnalytiqueRepartition)var4.get(var6)).getCleRepActivite());
                  } else if (((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeAgent() != null && !((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeAgent().isEmpty()) {
                     this.cleAnalytique.setCleanaCode(((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeAgent());
                     this.cleAnalytique.setCleanaLibelle(((PlanAnalytiqueRepartition)var4.get(var6)).getCleLibelleAgent());
                     this.cleAnalytique.setCleanaTaux((float)((PlanAnalytiqueRepartition)var4.get(var6)).getCleRepAgent());
                  } else if (((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeSite() != null && !((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeSite().isEmpty()) {
                     this.cleAnalytique.setCleanaCode(((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeSite());
                     this.cleAnalytique.setCleanaLibelle(((PlanAnalytiqueRepartition)var4.get(var6)).getCleLibelleSite());
                     this.cleAnalytique.setCleanaTaux((float)((PlanAnalytiqueRepartition)var4.get(var6)).getCleRepSite());
                     if (((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeDepartement() != null && !((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeDepartement().isEmpty()) {
                        this.cleAnalytique.setCleanaCode(((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeDepartement());
                        this.cleAnalytique.setCleanaLibelle(((PlanAnalytiqueRepartition)var4.get(var6)).getCleLibelleDepartement());
                        this.cleAnalytique.setCleanaTaux((float)((PlanAnalytiqueRepartition)var4.get(var6)).getCleRepDepartement());
                        if (((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeService() != null && !((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeService().isEmpty()) {
                           this.cleAnalytique.setCleanaCode(((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeService());
                           this.cleAnalytique.setCleanaLibelle(((PlanAnalytiqueRepartition)var4.get(var6)).getCleLibelleService());
                           this.cleAnalytique.setCleanaTaux((float)((PlanAnalytiqueRepartition)var4.get(var6)).getCleRepService());
                        }
                     }
                  } else if (((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeRegion() != null && !((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeRegion().isEmpty()) {
                     this.cleAnalytique.setCleanaCode(((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeRegion());
                     this.cleAnalytique.setCleanaLibelle(((PlanAnalytiqueRepartition)var4.get(var6)).getCleLibelleRegion());
                     this.cleAnalytique.setCleanaTaux((float)((PlanAnalytiqueRepartition)var4.get(var6)).getCleRepRegion());
                     if (((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeSecteur() != null && !((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeSecteur().isEmpty()) {
                        this.cleAnalytique.setCleanaCode(((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeSecteur());
                        this.cleAnalytique.setCleanaLibelle(((PlanAnalytiqueRepartition)var4.get(var6)).getCleLibelleSecteur());
                        this.cleAnalytique.setCleanaTaux((float)((PlanAnalytiqueRepartition)var4.get(var6)).getCleRepSecteur());
                        if (((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodePdv() != null && !((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodePdv().isEmpty()) {
                           this.cleAnalytique.setCleanaCode(((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodePdv());
                           this.cleAnalytique.setCleanaLibelle(((PlanAnalytiqueRepartition)var4.get(var6)).getCleLibellePdv());
                           this.cleAnalytique.setCleanaTaux((float)((PlanAnalytiqueRepartition)var4.get(var6)).getCleRepPdv());
                        }
                     }
                  } else if (((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeParc() != null && !((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeParc().isEmpty()) {
                     this.cleAnalytique.setCleanaCode(((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeParc());
                     this.cleAnalytique.setCleanaLibelle(((PlanAnalytiqueRepartition)var4.get(var6)).getCleLibelleParc());
                     this.cleAnalytique.setCleanaTaux((float)((PlanAnalytiqueRepartition)var4.get(var6)).getCleRepParc());
                  } else if (((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeDossier() != null && !((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeDossier().isEmpty()) {
                     this.cleAnalytique.setCleanaCode(((PlanAnalytiqueRepartition)var4.get(var6)).getCleCodeDossier());
                     this.cleAnalytique.setCleanaLibelle(((PlanAnalytiqueRepartition)var4.get(var6)).getCleLibelleDossier());
                     this.cleAnalytique.setCleanaTaux((float)((PlanAnalytiqueRepartition)var4.get(var6)).getCleRepDossier());
                  } else if (((PlanAnalytiqueRepartition)var4.get(var6)).getCleSigleStr() != null && !((PlanAnalytiqueRepartition)var4.get(var6)).getCleSigleStr().isEmpty()) {
                     this.cleAnalytique.setCleanaCode(((PlanAnalytiqueRepartition)var4.get(var6)).getCleSigleStr());
                     this.cleAnalytique.setCleanaLibelle(((PlanAnalytiqueRepartition)var4.get(var6)).getCleNomStr());
                     this.cleAnalytique.setCleanaTaux((float)((PlanAnalytiqueRepartition)var4.get(var6)).getCleRepStr());
                  }

                  this.cleAnalytique.setCleanaValeur(0.0D);
                  this.cleAnalytique.setCleanaDate(this.reglements.getCom_date());
                  this.cleAnalytique.setCleanaNature(this.nature);
                  this.cleAnalytique.setCleanaIdDocument(0L);
                  this.cleAnalytique.setCleanaNumDocument("");
                  this.leDetailcle1.add(this.cleAnalytique);
               }

               this.affiche_Cle1 = true;
            }
         }
      }

      this.dataModelCle1.setWrappedData(this.leDetailcle1);
   }

   public void selectionCle1() {
      if (this.dataModelCle1.isRowAvailable()) {
         this.cleAnalytique = (CleAnalytique)this.dataModelCle1.getRowData();
      }

   }

   public void calculPourcentageCle1() {
      if (this.leDetailcle1.size() != 0) {
         for(int var1 = 0; var1 < this.leDetailcle1.size(); ++var1) {
            this.cleAnalytique = (CleAnalytique)this.leDetailcle1.get(var1);
            if (this.cleAnalytique.getCleanaTaux() != 0.0F) {
               double var2 = this.utilNombre.myRoundDevise(this.var_aEncaisser * (double)this.cleAnalytique.getCleanaTaux() / 100.0D, this.structureLog.getStrdevise());
               this.cleAnalytique.setCleanaValeur(var2);
            }
         }
      }

   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.listCommande.clear();
      this.listLivraison.clear();
      this.listFacture.clear();
      this.datamodelTransfert.setWrappedData(this.listFacture);
      this.var_memo_action = this.var_action;
      this.tiers = this.formRecherche.rechercheTiers(3, this.reglements.getRglNomTiers(), this.nature);
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

   public void rechercheTiersFournisseur() throws JDOMException, IOException, HibernateException, NamingException {
      this.tiers = this.formRecherche.rechercheTiers(0, this.reglements.getRglNomTiers(), this.nature);
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
         String var1 = "";
         if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
            var1 = this.tiers.getTieraisonsocialenom();
         } else {
            var1 = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
         }

         this.reglements.setRglNomTiers(var1);
      } else {
         this.annuleTiers();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.reglements.setRglNomTiers("");
      this.var_action = this.var_memo_action;
   }

   public void recherchePatients() throws JDOMException, IOException, HibernateException, NamingException {
      this.var_memo_action = this.var_action;
      this.patients = this.formRecherche.recherchePatients(this.reglements.getRglNomTiers(), this.nature);
      if (this.patients != null) {
         if (this.patients.getPatId() != 0L) {
            this.calculePatients();
         } else {
            this.var_action = 14;
         }
      } else if (this.patients == null) {
         this.calculePatients();
      }

   }

   public void recuperationPatients() throws JDOMException, IOException, HibernateException, NamingException {
      this.patients = this.formRecherche.calculePatients();
      this.calculePatients();
   }

   public void calculePatients() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.patients != null) {
         String var1 = "";
         var1 = this.patients.getPatronyme();
         this.reglements.setRglNomTiers(var1);
         this.reglements.setRglTypeTiers(4);
      } else {
         this.annulePatients();
      }

      this.var_action = this.var_memo_action;
   }

   public void annulePatients() {
      this.patients = null;
      this.reglements.setRglNomTiers("");
      this.var_action = this.var_memo_action;
   }

   public void rechercheEleves() throws JDOMException, IOException, HibernateException, NamingException {
      this.var_memo_action = this.var_action;
      this.eleves = this.formRecherche.rechercheEleves(this.reglements.getRglNomTiers(), this.nature);
      if (this.eleves != null) {
         if (this.eleves.getEleId() != 0L) {
            this.calculeEleves();
         } else {
            this.var_action = 15;
         }
      } else if (this.eleves == null) {
         this.calculeEleves();
      }

   }

   public void recuperationEleves() throws JDOMException, IOException, HibernateException, NamingException {
      this.eleves = this.formRecherche.calculeEleves();
      this.calculeEleves();
   }

   public void calculeEleves() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.eleves != null) {
         String var1 = "";
         var1 = this.eleves.getPatronyme();
         this.reglements.setRglNomTiers(var1);
         this.reglements.setRglTypeTiers(5);
         this.reglements.setRglNatureDoc(102);
      } else {
         this.annuleEleves();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleEleves() {
      this.eleves = null;
      this.reglements.setRglNomTiers("");
      this.var_action = this.var_memo_action;
   }

   public void rechercheSalarie() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.var_memo_action = this.var_action;
      new ExercicesPaye();
      ExercicesPayeDao var2 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      ExercicesPaye var1 = var2.recupererLastExo((Session)null);
      if (var1 != null) {
         this.salaries = this.formRecherche.rechercheSalarie(this.reglements.getRglNomTiers(), this.nature, var1.getExepayId());
         if (this.salaries != null) {
            if (this.salaries.getSalId() != 0L) {
               this.calculeSalarie();
            } else {
               this.var_action = 10;
            }
         } else if (this.salaries == null) {
            this.calculeSalarie();
         }
      }

   }

   public void recuperationSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      this.salaries = this.formRecherche.calculeSalarie();
      this.calculeSalarie();
   }

   public void calculeSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.salaries != null) {
         String var1 = "";
         if (this.salaries.getSalPrenom() != null && !this.salaries.getSalPrenom().isEmpty()) {
            var1 = this.salaries.getSalNom() + " " + this.salaries.getSalPrenom();
         } else {
            var1 = this.salaries.getSalNom();
         }

         this.reglements.setRglNomTiers(var1);
      } else {
         this.annuleSalarie();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleSalarie() {
      this.salaries = null;
      this.reglements.setRglNomTiers("");
      this.var_action = this.var_memo_action;
   }

   public void recherchePlanComptable() throws JDOMException, IOException, HibernateException, NamingException {
      this.var_memo_action = this.var_action;
      this.planComptable = this.formRecherche.recherchePlanComptable("", this.reglements.getRglNomTiers(), this.nature, this.exercicesComptable, 0, this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
      if (this.planComptable != null) {
         if (this.planComptable.getPlcId() != 0L) {
            this.calculePlanComptable();
         } else {
            this.var_action = 11;
         }
      } else if (this.planComptable == null) {
         this.calculePlanComptable();
      }

   }

   public void recuperationPlanComptable() throws JDOMException, IOException, HibernateException, NamingException {
      this.planComptable = this.formRecherche.calculePlanComptable();
      this.calculePlanComptable();
   }

   public void calculePlanComptable() throws JDOMException, IOException {
      if (this.planComptable != null) {
         this.reglements.setRglNomTiers(this.planComptable.getPlcCompte() + ":" + this.planComptable.getPlcLibelleCpteFR());
      } else {
         this.reglements.setRglNomTiers("");
      }

      this.var_action = this.var_memo_action;
   }

   public void annulePlanComptable() {
      this.reglements.setRglNomTiers("");
      this.var_action = this.var_memo_action;
   }

   public void rechercheUtilisateur() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.var_memo_action = this.var_action;
      this.usersConcerne = this.formRecherche.rechercheUtilisateur(this.reglements.getRglNomTiers(), this.nature);
      if (this.usersConcerne != null) {
         if (this.usersConcerne.getUsrid() != 0L) {
            this.calculeUtilisateur();
         } else {
            this.var_action = 13;
         }
      } else if (this.usersConcerne == null) {
         this.calculeUtilisateur();
      }

   }

   public void recuperationUtilisateur() throws JDOMException, IOException, HibernateException, NamingException {
      this.usersConcerne = this.formRecherche.calculeUtilisateur();
      this.calculeUtilisateur();
   }

   public void calculeUtilisateur() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.usersConcerne != null) {
         String var1 = "";
         if (this.usersConcerne.getUsrPrenom() != null && !this.usersConcerne.getUsrPrenom().isEmpty()) {
            var1 = this.usersConcerne.getUsrNom() + " " + this.usersConcerne.getUsrPrenom();
         } else {
            var1 = this.usersConcerne.getUsrNom();
         }

         this.reglements.setRglNomTiers(var1);
      } else {
         this.annuleUtilisateur();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleUtilisateur() {
      this.usersConcerne = null;
      this.reglements.setRglNomTiers("");
      this.var_action = this.var_memo_action;
   }

   public void rechercheCheque() throws JDOMException, IOException, HibernateException, NamingException {
      this.var_memo_action = this.var_action;
      this.regCheque = new Reglements();
      this.regCheque = this.formRecherche.rechercheChequesClient(this.reglements.getRglNumChqBdx(), this.nature, this.selectedExo);
      if (this.regCheque != null) {
         if (this.regCheque.getRglId() != 0L) {
            this.calculeCheque();
         } else {
            this.var_action = 12;
         }
      } else if (this.regCheque == null) {
         this.calculeCheque();
      }

   }

   public void recuperationCheque() throws JDOMException, IOException, HibernateException, NamingException {
      this.regCheque = this.formRecherche.calculeCheque();
      this.calculeCheque();
   }

   public void calculeCheque() throws JDOMException, IOException {
      if (this.regCheque != null) {
         this.reglements.setRglNumChqBdx(this.regCheque.getRglNumChqBdx());
         this.reglements.setRglBanqueTireur(this.regCheque.getRglBanqueTireur());
         this.reglements.setRglRecette(this.regCheque.getRglRecette());
         this.reglements.setRglOperation(this.regCheque.getRglOperation());
         this.reglements.setRglIdTiers(this.regCheque.getRglIdTiers());
         this.reglements.setRglNomTiers(this.regCheque.getRglNomTiers());
         this.reglements.setRglTypeTiers(this.regCheque.getRglTypeTiers());
         this.reglements.setRglNatureDoc(this.regCheque.getRglNatureDoc());
         this.reglements.setRglDocument(this.regCheque.getRglDocument());
         this.reglements.setRglIdDocument(this.regCheque.getRglIdDocument());
         this.reglements.setRglSerie(this.regCheque.getRglSerie());
         if (this.decoupageActivite) {
            this.totalImputation = 0.0D;
            this.soldeImputation = 0.0D;
            this.lesDecoupagesActivites.clear();
            if (this.regCheque.getRglActivite() != null && !this.regCheque.getRglActivite().isEmpty()) {
               if (this.regCheque.getRglActivite().contains(":")) {
                  String[] var1 = null;
                  if (!this.regCheque.getRglActivite().contains("#")) {
                     var1 = this.regCheque.getRglActivite().split(":");
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
                     this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(0.0F);
                     if (var1.length == 8) {
                        this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
                     } else {
                        this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[6]));
                     }

                     this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
                  } else {
                     String[] var2 = this.regCheque.getRglActivite().split("#");

                     for(int var3 = 0; var3 < var2.length; ++var3) {
                        var1 = var2[var3].split(":");
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
                        this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(0.0F);
                        if (var1.length == 8) {
                           this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
                        } else {
                           this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[6]));
                        }

                        this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
                     }
                  }
               }
            } else {
               this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         } else {
            this.reglements.setRglActivite(this.regCheque.getRglActivite());
         }

         this.reglements.setRglSite(this.regCheque.getRglSite());
         this.reglements.setRglDepartement(this.regCheque.getRglDepartement());
         this.reglements.setRglService(this.regCheque.getRglService());
         this.reglements.setRglRegion(this.regCheque.getRglRegion());
         this.reglements.setRglSecteur(this.regCheque.getRglSecteur());
         this.reglements.setRglPdv(this.regCheque.getRglPdv());
         this.reglements.setRglParc(this.regCheque.getRglParc());
         this.reglements.setRglFrais(0.0D);
         this.reglements.setRglCodeEmetrice(this.regCheque.getRglCodeEmetrice());
         this.reglements.setRglLibEmetrice(this.regCheque.getRglLibEmetrice());
         this.inputBanq = this.regCheque.getRglCodeEmetrice() + ":" + this.regCheque.getRglLibEmetrice();
      } else {
         this.annuleCheque();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleCheque() {
      this.regCheque = null;
      this.reglements.setRglNumChqBdx("");
      this.reglements.setRglBanqueTireur("");
      this.reglements.setRglRecette(0.0D);
      this.reglements.setRglOperation("");
      this.reglements.setRglIdTiers(0L);
      this.reglements.setRglNomTiers("");
      this.reglements.setRglNatureDoc(0);
      this.reglements.setRglDocument("");
      this.reglements.setRglIdDocument(0L);
      this.reglements.setRglFrais(0.0D);
      this.var_action = this.var_memo_action;
   }

   public void initImpression() throws IOException {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      if (this.var_modeReglement == null || this.var_modeReglement.isEmpty()) {
         this.var_modeReglement = "100";
      }

      if (this.reglements != null) {
         int var1 = 0;
         if (this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty()) {
            var1 = Integer.parseInt(this.reglements.getRglOperation());
         }

         this.calculeNomRep(Integer.parseInt(this.var_modeReglement), var1);
      } else {
         this.calculeNomRep(Integer.parseInt(this.var_modeReglement), 0);
      }

      this.affMail = false;
      this.var_choix_modele = 0;
      this.ListeDocImp();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.var_action = 0;
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

   public void OptionMail() {
      if (this.format.equalsIgnoreCase("MAIL")) {
         this.visibleOptionMail = true;
      } else {
         this.visibleOptionMail = false;
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

   public void ListeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else {
         this.affListeDoc = true;
      }

   }

   public String calculeCheminRapport(String var1, String var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsRecu" + File.separator + var2 + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1, int var2) throws HibernateException, NamingException {
      String var3 = "";
      File var4;
      if (var2 == 20) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatParapheur.jpg");
         if (var4.exists()) {
            var3 = "formatParapheur.jpg";
         }
      } else if (var2 == 30) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatCaisse.jpg");
         if (var4.exists()) {
            var3 = "formatCaisse.jpg";
         }
      } else if (var2 == 0) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatOperation.jpg");
         if (var4.exists()) {
            var3 = "formatOperation.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      Object var1 = new ArrayList();
      this.reglements = this.reglementsDao.selectById(this.reglements.getRglId(), (Session)null);
      if (this.reglements != null) {
         this.reglements.setDemandeurBs(this.bonSortieCaiss.getSortNomResponsable());
         this.reglements.setMotifBs(this.bonSortieCaiss.getSortLibelle());
         if (this.reglements.getRglNatureDoc() == 71) {
            var1 = this.calculeConsultationGne();
         } else if (this.reglements.getRglNatureDoc() != 72) {
            if (this.reglements.getRglNatureDoc() == 73) {
               var1 = this.calculePharmacie();
            } else if (this.reglements.getRglNatureDoc() == 74) {
               var1 = this.calculeLaboratoire();
            } else if (this.reglements.getRglNatureDoc() == 76) {
               var1 = this.calculeHospitalisation();
            } else if (this.reglements.getRglNatureDoc() != 78) {
               ((List)var1).add(this.reglements);
            }
         }
      } else {
         ((List)var1).add(this.reglements);
      }

      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource((Collection)var1);
      return var2;
   }

   public List calculeConsultationGne() throws HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      new ArrayList();
      ConsultationReglementDao var3 = new ConsultationReglementDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectReglementByRecu(this.reglements.getRglIdDocument(), (Session)null);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            Reglements var5 = new Reglements();
            var5.setRglNum(this.reglements.getRglNum());
            var5.setRglDocument(this.reglements.getRglDocument());
            var5.setRglIdDocument(this.reglements.getRglIdDocument());
            var5.setRglDateReg(this.reglements.getRglDateReg());
            var5.setRglNumChqBdx(this.reglements.getRglNumChqBdx());
            var5.setRglBanqueTireur(this.reglements.getRglBanqueTireur());
            var5.setRglMode(this.reglements.getRglMode());
            var5.setRglCodeCaiss(this.reglements.getRglCodeCaiss());
            var5.setRglNomCaissier(this.reglements.getRglNomCaissier());
            var5.setRglDepense(this.reglements.getRglDepense());
            var5.setRglRecette(this.reglements.getRglRecette());
            var5.setRglTimbre(this.reglements.getRglTimbre());
            var5.setRglDevise(this.reglements.getRglDevise());
            var5.setRglInfo4(((ConsultationReglement)var2.get(var4)).getCsgregNumPieceTiers());
            var5.setRglNomTiers(((ConsultationReglement)var2.get(var4)).getConsultationEnteteGene().getPatients().getPatDossier() + "  " + this.reglements.getRglNomTiers());
            var5.setRglNomEquipe("N° Consultation");
            if (((ConsultationReglement)var2.get(var4)).getConsultationEnteteGene().isCsgAyantDroit()) {
               var5.setRglNomCommercial(((ConsultationReglement)var2.get(var4)).getConsultationEnteteGene().getCsgNomAssurePrincipal());
            } else {
               var5.setRglNomCommercial("");
               if (((ConsultationReglement)var2.get(var4)).getConsultationEnteteGene().getPatients().getPatSexe() == 0) {
                  var5.setRglNomCommercial("Elle-même");
               } else {
                  var5.setRglNomCommercial("Lui-même");
               }
            }

            if (((ConsultationReglement)var2.get(var4)).getConsultationEnteteGene().getCsgIdAssurance() != 0L) {
               var5.setRglNomResponsable(((ConsultationReglement)var2.get(var4)).getConsultationEnteteGene().getCsgNomAssurance());
               var5.setRglNumTrf(((ConsultationReglement)var2.get(var4)).getConsultationEnteteGene().getCsgContratAssurance());
            } else if (((ConsultationReglement)var2.get(var4)).getConsultationEnteteGene().getCsgIdSociete() != 0L) {
               var5.setRglNomResponsable(((ConsultationReglement)var2.get(var4)).getConsultationEnteteGene().getCsgNomSociete());
               var5.setRglNumTrf(((ConsultationReglement)var2.get(var4)).getConsultationEnteteGene().getCsgMatricule());
            } else {
               var5.setRglNomResponsable("");
               var5.setRglNumTrf("");
            }

            var5.setRglInfo1(((ConsultationReglement)var2.get(var4)).getCsgregProduit());
            var5.setRglInfo2(((ConsultationReglement)var2.get(var4)).getCsgregLibelle());
            var5.setRglInfo3(((ConsultationReglement)var2.get(var4)).getCsgregService());
            var5.setRglRecette(((ConsultationReglement)var2.get(var4)).getCsgregPatient());
            if (((ConsultationReglement)var2.get(var4)).getCsgregIdRecu() == 0L || this.reglements.getRglId() == ((ConsultationReglement)var2.get(var4)).getCsgregIdRecu()) {
               var1.add(var5);
            }
         }
      } else {
         Reglements var6 = new Reglements();
         var6.setRglNum(this.reglements.getRglNum());
         var6.setRglDocument(this.reglements.getRglDocument());
         var6.setRglIdDocument(this.reglements.getRglIdDocument());
         var6.setRglDateReg(this.reglements.getRglDateReg());
         var6.setRglNumChqBdx(this.reglements.getRglNumChqBdx());
         var6.setRglBanqueTireur(this.reglements.getRglBanqueTireur());
         var6.setRglMode(this.reglements.getRglMode());
         var6.setRglCodeCaiss(this.reglements.getRglCodeCaiss());
         var6.setRglNomCaissier(this.reglements.getRglNomCaissier());
         var6.setRglDepense(this.reglements.getRglDepense());
         var6.setRglRecette(this.reglements.getRglRecette());
         var6.setRglTimbre(this.reglements.getRglTimbre());
         var6.setRglDevise(this.reglements.getRglDevise());
         var6.setRglInfo4("");
         var6.setRglNomTiers(this.reglements.getRglNomTiers());
         var6.setRglNomEquipe("N° Consultation");
         var6.setRglNomCommercial("****");
         var6.setRglNomResponsable("");
         var6.setRglNumTrf("");
         var6.setRglInfo1("");
         if (this.reglements.getRglRecette() < 0.0D) {
            var6.setRglInfo1("Remboursement");
            var6.setRglInfo2("Remboursement patient");
         } else {
            var6.setRglInfo1("Versement");
            var6.setRglInfo2("Versement patient");
         }

         var6.setRglInfo3(this.reglements.getRglService());
         var6.setRglInfo5(this.reglements.getRglObjet());
         var1.add(var6);
      }

      return var1;
   }

   public List calculePharmacie() throws HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      new ArrayList();
      PharmacieReglementDao var3 = new PharmacieReglementDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectReglementByRecu(this.reglements.getRglIdDocument(), (Session)null);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            Reglements var5 = new Reglements();
            var5.setRglNum(this.reglements.getRglNum());
            var5.setRglDocument(this.reglements.getRglDocument());
            var5.setRglIdDocument(this.reglements.getRglIdDocument());
            var5.setRglDateReg(this.reglements.getRglDateReg());
            var5.setRglNumChqBdx(this.reglements.getRglNumChqBdx());
            var5.setRglBanqueTireur(this.reglements.getRglBanqueTireur());
            var5.setRglMode(this.reglements.getRglMode());
            var5.setRglCodeCaiss(this.reglements.getRglCodeCaiss());
            var5.setRglNomCaissier(this.reglements.getRglNomCaissier());
            var5.setRglDepense(this.reglements.getRglDepense());
            var5.setRglRecette(this.reglements.getRglRecette());
            var5.setRglTimbre(this.reglements.getRglTimbre());
            var5.setRglDevise(this.reglements.getRglDevise());
            if (((PharmacieReglement)var2.get(var4)).getPharmacieEntete() != null) {
               var5.setRglInfo4(((PharmacieReglement)var2.get(var4)).getPharegNumPieceTiers());
               var5.setRglNomTiers(((PharmacieReglement)var2.get(var4)).getPharmacieEntete().getPatients().getPatDossier() + "  " + this.reglements.getRglNomTiers());
               var5.setRglNomEquipe("N° Pharmacie");
               if (((PharmacieReglement)var2.get(var4)).getPharmacieEntete().isPhaAyantDroit()) {
                  var5.setRglNomCommercial(((PharmacieReglement)var2.get(var4)).getPharmacieEntete().getPhaNomAssurePrincipal());
               } else {
                  var5.setRglNomCommercial("");
                  if (((PharmacieReglement)var2.get(var4)).getPharmacieEntete().getPatients().getPatSexe() == 0) {
                     var5.setRglNomCommercial("Elle-même");
                  } else {
                     var5.setRglNomCommercial("Lui-même");
                  }
               }

               if (((PharmacieReglement)var2.get(var4)).getPharmacieEntete().getPhaIdAssurance() != 0L) {
                  var5.setRglNomResponsable(((PharmacieReglement)var2.get(var4)).getPharmacieEntete().getPhaNomAssurance());
                  var5.setRglNumTrf(((PharmacieReglement)var2.get(var4)).getPharmacieEntete().getPhaContratAssurance());
               } else if (((PharmacieReglement)var2.get(var4)).getPharmacieEntete().getPhaIdSociete() != 0L) {
                  var5.setRglNomResponsable(((PharmacieReglement)var2.get(var4)).getPharmacieEntete().getPhaNomSociete());
                  var5.setRglNumTrf(((PharmacieReglement)var2.get(var4)).getPharmacieEntete().getPhaMatricule());
               } else {
                  var5.setRglNomResponsable("");
                  var5.setRglNumTrf("");
               }
            } else {
               var5.setRglInfo4("");
               var5.setRglNomTiers(this.reglements.getRglNomTiers());
               var5.setRglNomEquipe("N° Consultation");
               var5.setRglNomCommercial("");
               var5.setRglNomResponsable("");
               var5.setRglNumTrf("");
            }

            var5.setRglInfo1(((PharmacieReglement)var2.get(var4)).getPharegProduit());
            var5.setRglInfo2(((PharmacieReglement)var2.get(var4)).getPharegLibelle());
            var5.setRglInfo3(((PharmacieReglement)var2.get(var4)).getPharegService());
            var5.setRglRecette(((PharmacieReglement)var2.get(var4)).getPharegPatient());
            if (((PharmacieReglement)var2.get(var4)).getPharegIdRecu() == 0L || this.reglements.getRglId() == ((PharmacieReglement)var2.get(var4)).getPharegIdRecu()) {
               var1.add(var5);
            }
         }
      } else {
         Reglements var6 = new Reglements();
         var6.setRglNum(this.reglements.getRglNum());
         var6.setRglDocument(this.reglements.getRglDocument());
         var6.setRglIdDocument(this.reglements.getRglIdDocument());
         var6.setRglDateReg(this.reglements.getRglDateReg());
         var6.setRglNumChqBdx(this.reglements.getRglNumChqBdx());
         var6.setRglBanqueTireur(this.reglements.getRglBanqueTireur());
         var6.setRglMode(this.reglements.getRglMode());
         var6.setRglCodeCaiss(this.reglements.getRglCodeCaiss());
         var6.setRglNomCaissier(this.reglements.getRglNomCaissier());
         var6.setRglDepense(this.reglements.getRglDepense());
         var6.setRglRecette(this.reglements.getRglRecette());
         var6.setRglTimbre(this.reglements.getRglTimbre());
         var6.setRglDevise(this.reglements.getRglDevise());
         var6.setRglInfo4("");
         var6.setRglNomTiers(this.reglements.getRglNomTiers());
         var6.setRglNomEquipe("N° Pharmacie");
         var6.setRglNomCommercial("****");
         var6.setRglNomResponsable("");
         var6.setRglNumTrf("");
         var6.setRglInfo1("");
         if (this.reglements.getRglRecette() < 0.0D) {
            var6.setRglInfo1("Remboursement");
            var6.setRglInfo2("Remboursement patient");
         } else {
            var6.setRglInfo1("Versement");
            var6.setRglInfo2("Versement patient");
         }

         var6.setRglInfo3(this.reglements.getRglService());
         var6.setRglInfo5(this.reglements.getRglObjet());
         var1.add(var6);
      }

      return var1;
   }

   public List calculeLaboratoire() throws HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      new ArrayList();
      LaboratoireReglementDao var3 = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectReglementByRecu(this.reglements.getRglIdDocument(), (Session)null);
      String var4 = this.reglements.getRglPdv();
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            if (var4 != null && !var4.isEmpty() && ((LaboratoireReglement)var2.get(var5)).getLabregLaboratoire() != null && !((LaboratoireReglement)var2.get(var5)).getLabregLaboratoire().isEmpty() && var4.equals(((LaboratoireReglement)var2.get(var5)).getLabregLaboratoire()) || var4 == null || var4.isEmpty() && ((LaboratoireReglement)var2.get(var5)).getLabregLaboratoire() == null || ((LaboratoireReglement)var2.get(var5)).getLabregLaboratoire().isEmpty()) {
               Reglements var6 = new Reglements();
               var6.setRglNum(this.reglements.getRglNum());
               var6.setRglDocument(this.reglements.getRglDocument());
               var6.setRglIdDocument(this.reglements.getRglIdDocument());
               var6.setRglDateReg(this.reglements.getRglDateReg());
               var6.setRglNumChqBdx(this.reglements.getRglNumChqBdx());
               var6.setRglBanqueTireur(this.reglements.getRglBanqueTireur());
               var6.setRglMode(this.reglements.getRglMode());
               var6.setRglCodeCaiss(this.reglements.getRglCodeCaiss());
               var6.setRglNomCaissier(this.reglements.getRglNomCaissier());
               var6.setRglDepense(this.reglements.getRglDepense());
               var6.setRglRecette(this.reglements.getRglRecette());
               var6.setRglTimbre(this.reglements.getRglTimbre());
               var6.setRglDevise(this.reglements.getRglDevise());
               var6.setRglInfo4(((LaboratoireReglement)var2.get(var5)).getLabregNumPieceTiers());
               var6.setRglNomTiers(((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getPatients().getPatDossier() + "  " + this.reglements.getRglNomTiers());
               var6.setRglNomEquipe("N° Laboratoire");
               if (((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().isLabAyantDroit()) {
                  var6.setRglNomCommercial(((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getLabNomAssurePrincipal());
               } else {
                  var6.setRglNomCommercial("");
                  if (((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getPatients().getPatSexe() == 0) {
                     var6.setRglNomCommercial("Elle-même");
                  } else {
                     var6.setRglNomCommercial("Lui-même");
                  }
               }

               if (((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getLabIdAssurance() != 0L) {
                  var6.setRglNomResponsable(((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getLabNomAssurance());
                  var6.setRglNumTrf(((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getLabContratAssurance());
               } else if (((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getLabIdSociete() != 0L) {
                  var6.setRglNomResponsable(((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getLabNomSociete());
                  var6.setRglNumTrf(((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getLabMatricule());
               } else {
                  var6.setRglNomResponsable("");
                  var6.setRglNumTrf("");
               }

               var6.setRglInfo1(((LaboratoireReglement)var2.get(var5)).getLabregProduit());
               var6.setRglInfo2(((LaboratoireReglement)var2.get(var5)).getLabregLibelle());
               if (((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getLabLaboratoire() != null && !((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getLabLaboratoire().isEmpty()) {
                  var6.setRglInfo3(((LaboratoireReglement)var2.get(var5)).getLaboratoireEntete().getLabLaboratoire());
               } else {
                  var6.setRglInfo3(((LaboratoireReglement)var2.get(var5)).getLabregLaboratoire());
               }

               var6.setRglRecette(((LaboratoireReglement)var2.get(var5)).getLabregPatient());
               if (((LaboratoireReglement)var2.get(var5)).getLabregIdRecu() == 0L || this.reglements.getRglId() == ((LaboratoireReglement)var2.get(var5)).getLabregIdRecu()) {
                  var1.add(var6);
               }
            }
         }
      } else {
         Reglements var7 = new Reglements();
         var7.setRglNum(this.reglements.getRglNum());
         var7.setRglDocument(this.reglements.getRglDocument());
         var7.setRglIdDocument(this.reglements.getRglIdDocument());
         var7.setRglDateReg(this.reglements.getRglDateReg());
         var7.setRglNumChqBdx(this.reglements.getRglNumChqBdx());
         var7.setRglBanqueTireur(this.reglements.getRglBanqueTireur());
         var7.setRglMode(this.reglements.getRglMode());
         var7.setRglCodeCaiss(this.reglements.getRglCodeCaiss());
         var7.setRglNomCaissier(this.reglements.getRglNomCaissier());
         var7.setRglDepense(this.reglements.getRglDepense());
         var7.setRglRecette(this.reglements.getRglRecette());
         var7.setRglTimbre(this.reglements.getRglTimbre());
         var7.setRglDevise(this.reglements.getRglDevise());
         var7.setRglInfo4("");
         var7.setRglNomTiers(this.reglements.getRglNomTiers());
         var7.setRglNomEquipe("N° Laboratoire");
         var7.setRglNomCommercial("****");
         var7.setRglNomResponsable("");
         var7.setRglNumTrf("");
         var7.setRglInfo1("");
         if (this.reglements.getRglRecette() < 0.0D) {
            var7.setRglInfo1("Remboursement");
            var7.setRglInfo2("Remboursement patient");
         } else {
            var7.setRglInfo1("Versement");
            var7.setRglInfo2("Versement patient");
         }

         var7.setRglInfo3(this.reglements.getRglService());
         var7.setRglInfo5(this.reglements.getRglObjet());
         var1.add(var7);
      }

      return var1;
   }

   public List calculeHospitalisation() throws HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      new ArrayList();
      HospitalisationReglementDao var3 = new HospitalisationReglementDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectReglementByIdRecu(this.reglements.getRglId(), this.reglements.getRglIdDocument(), (Session)null);
      if (var2.size() != 0) {
         boolean var4 = false;
         double var5 = 0.0D;
         boolean var7 = false;
         boolean var8 = false;
         double var9 = 0.0D;
         int var11 = 0;

         for(int var12 = 0; var12 < var2.size(); ++var12) {
            if (((HospitalisationReglement)var2.get(var12)).getHosregService() != null && !((HospitalisationReglement)var2.get(var12)).getHosregService().isEmpty() && ((HospitalisationReglement)var2.get(var12)).getHosregService().equals("41:PHARMACIE CENTRALE")) {
               var9 = ((HospitalisationReglement)var2.get(var12)).getHosregPatient();
               var11 = var12;
               var8 = true;
            }

            if (((HospitalisationReglement)var2.get(var12)).getHosregService() != null && !((HospitalisationReglement)var2.get(var12)).getHosregService().isEmpty() && ((HospitalisationReglement)var2.get(var12)).getHosregService().equals("23:REANIMATION")) {
               var5 = ((HospitalisationReglement)var2.get(var12)).getHosregPatient();
               var4 = true;
            }
         }

         new HospitalisationReglement();

         for(int var13 = 0; var13 < var2.size(); ++var13) {
            HospitalisationReglement var19 = (HospitalisationReglement)var2.get(var13);
            if (var19.getHosregIdRecu() == this.reglements.getRglId()) {
               Reglements var14 = new Reglements();
               if (((HospitalisationReglement)var2.get(var13)).getHosregService() != null && !((HospitalisationReglement)var2.get(var13)).getHosregService().isEmpty() && !((HospitalisationReglement)var2.get(var13)).getHosregService().equals("41:PHARMACIE CENTRALE")) {
                  var14.setRglNum(this.reglements.getRglNum());
                  var14.setRglDocument(this.reglements.getRglDocument());
                  var14.setRglIdDocument(this.reglements.getRglIdDocument());
                  var14.setRglDateReg(((HospitalisationReglement)var2.get(var13)).getHosregDate());
                  var14.setRglNumChqBdx(this.reglements.getRglNumChqBdx());
                  var14.setRglBanqueTireur(this.reglements.getRglBanqueTireur());
                  var14.setRglMode(this.reglements.getRglMode());
                  var14.setRglCodeCaiss(this.reglements.getRglCodeCaiss());
                  var14.setRglNomCaissier(this.reglements.getRglNomCaissier());
                  var14.setRglDepense(this.reglements.getRglDepense());
                  var14.setRglRecette(this.reglements.getRglRecette());
                  var14.setRglTimbre(this.reglements.getRglTimbre());
                  var14.setRglDevise(this.reglements.getRglDevise());
                  var14.setRglInfo4(((HospitalisationReglement)var2.get(var13)).getHosregNumPieceTiers());
                  var14.setRglNomTiers(((HospitalisationReglement)var2.get(var13)).getHospitalisationEntete().getPatients().getPatDossier() + "  " + this.reglements.getRglNomTiers());
                  var14.setRglNomEquipe("N° Hospitalisation");
                  if (((HospitalisationReglement)var2.get(var13)).getHospitalisationEntete().isHosAyantDroit()) {
                     var14.setRglNomCommercial(((HospitalisationReglement)var2.get(var13)).getHospitalisationEntete().getHosNomAssurePrincipal());
                  } else {
                     var14.setRglNomCommercial("");
                     if (((HospitalisationReglement)var2.get(var13)).getHospitalisationEntete().getPatients().getPatSexe() == 0) {
                        var14.setRglNomCommercial("Elle-même");
                     } else {
                        var14.setRglNomCommercial("Lui-même");
                     }
                  }

                  if (((HospitalisationReglement)var2.get(var13)).getHospitalisationEntete().getHosIdAssurance() != 0L) {
                     var14.setRglNomResponsable(((HospitalisationReglement)var2.get(var13)).getHospitalisationEntete().getHosNomAssurance());
                     var14.setRglNumTrf(((HospitalisationReglement)var2.get(var13)).getHospitalisationEntete().getHosContratAssurance());
                  } else if (((HospitalisationReglement)var2.get(var13)).getHospitalisationEntete().getHosIdSociete() != 0L) {
                     var14.setRglNomResponsable(((HospitalisationReglement)var2.get(var13)).getHospitalisationEntete().getHosNomSociete());
                     var14.setRglNumTrf(((HospitalisationReglement)var2.get(var13)).getHospitalisationEntete().getHosMatricule());
                  } else {
                     var14.setRglNomResponsable("");
                     var14.setRglNumTrf("");
                  }

                  if (this.reglements.getRglRecette() < 0.0D) {
                     var14.setRglInfo1("Remboursement");
                     if (((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire() != null && !((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire().isEmpty() && ((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire().contains("Caution")) {
                        if (((HospitalisationReglement)var2.get(var13)).getHosregService() != null && !((HospitalisationReglement)var2.get(var13)).getHosregService().isEmpty()) {
                           var14.setRglInfo2(((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire());
                           this.reglements.setRglService(((HospitalisationReglement)var2.get(var13)).getHosregService());
                        } else {
                           var14.setRglInfo2(((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire());
                        }
                     } else if (((HospitalisationReglement)var2.get(var13)).getHosregService() != null && !((HospitalisationReglement)var2.get(var13)).getHosregService().isEmpty()) {
                        var14.setRglInfo2("Remboursement patient");
                        this.reglements.setRglService(((HospitalisationReglement)var2.get(var13)).getHosregService());
                     } else {
                        var14.setRglInfo2("Remboursement patient");
                     }
                  } else {
                     var14.setRglInfo1("Versement");
                     if (((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire() != null && !((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire().isEmpty() && ((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire().contains("Caution")) {
                        if (((HospitalisationReglement)var2.get(var13)).getHosregService() != null && !((HospitalisationReglement)var2.get(var13)).getHosregService().isEmpty()) {
                           var14.setRglInfo2(((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire());
                           this.reglements.setRglService(((HospitalisationReglement)var2.get(var13)).getHosregService());
                        } else {
                           var14.setRglInfo2(((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire());
                        }
                     } else if (((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire() != null && !((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire().isEmpty() && !((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire().contains("Caution")) {
                        if (((HospitalisationReglement)var2.get(var13)).getHosregService() != null && !((HospitalisationReglement)var2.get(var13)).getHosregService().isEmpty()) {
                           var14.setRglInfo2(((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire());
                           this.reglements.setRglService(((HospitalisationReglement)var2.get(var13)).getHosregService());
                        } else {
                           var14.setRglInfo2(((HospitalisationReglement)var2.get(var13)).getHosregLaboratoire());
                        }
                     } else if (((HospitalisationReglement)var2.get(var13)).getHosregService() != null && !((HospitalisationReglement)var2.get(var13)).getHosregService().isEmpty()) {
                        var14.setRglInfo2("Versement patient");
                        this.reglements.setRglService(((HospitalisationReglement)var2.get(var13)).getHosregService());
                     } else {
                        var14.setRglInfo2("Versement patient");
                     }
                  }

                  var14.setRglInfo3(this.reglements.getRglService());
                  var14.setRglInfo5(this.reglements.getRglObjet());
                  var14.setRglRecette(this.reglements.getRglRecette() - var9 - var5);
                  var1.add(var14);
                  break;
               }
            }
         }

         Reglements var20;
         if (var8 && var9 != 0.0D) {
            new Reglements();
            HospitalisationMediDao var21 = new HospitalisationMediDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            String var16 = "hosmedService='" + ((HospitalisationReglement)var2.get(var11)).getHosregService() + "' and hosmedIdSejour=" + ((HospitalisationReglement)var2.get(var11)).getHosregIdSejour();
            List var15 = var21.chargerMediByRequete(var16, (Session)null);
            if (var15.size() != 0) {
               for(int var17 = 0; var17 < var15.size(); ++var17) {
                  var20 = new Reglements();
                  if (this.verifProduitHospit(var2, ((HospitalisationMedi)var15.get(var17)).getHosmedProduit())) {
                     var20.setRglNum(this.reglements.getRglNum());
                     var20.setRglDocument(this.reglements.getRglDocument());
                     var20.setRglIdDocument(this.reglements.getRglIdDocument());
                     var20.setRglDateReg(this.reglements.getRglDateReg());
                     var20.setRglNumChqBdx(this.reglements.getRglNumChqBdx());
                     var20.setRglBanqueTireur(this.reglements.getRglBanqueTireur());
                     var20.setRglMode(this.reglements.getRglMode());
                     var20.setRglCodeCaiss(this.reglements.getRglCodeCaiss());
                     var20.setRglNomCaissier(this.reglements.getRglNomCaissier());
                     var20.setRglDepense(this.reglements.getRglDepense());
                     var20.setRglRecette(this.reglements.getRglRecette());
                     var20.setRglTimbre(this.reglements.getRglTimbre());
                     var20.setRglDevise(this.reglements.getRglDevise());
                     var20.setRglInfo4(((HospitalisationReglement)var2.get(var11)).getHosregNumPieceTiers());
                     var20.setRglNomTiers(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getPatients().getPatDossier() + "  " + this.reglements.getRglNomTiers());
                     var20.setRglNomEquipe("N° Hospitalisation");
                     if (((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().isHosAyantDroit()) {
                        var20.setRglNomCommercial(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosNomAssurePrincipal());
                     } else {
                        var20.setRglNomCommercial("");
                        if (((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getPatients().getPatSexe() == 0) {
                           var20.setRglNomCommercial("Elle-même");
                        } else {
                           var20.setRglNomCommercial("Lui-même");
                        }
                     }

                     if (((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosIdAssurance() != 0L) {
                        var20.setRglNomResponsable(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosNomAssurance());
                        var20.setRglNumTrf(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosContratAssurance());
                     } else if (((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosIdSociete() != 0L) {
                        var20.setRglNomResponsable(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosNomSociete());
                        var20.setRglNumTrf(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosMatricule());
                     } else {
                        var20.setRglNomResponsable("");
                        var20.setRglNumTrf("");
                     }

                     if (this.reglements.getRglRecette() < 0.0D) {
                        var20.setRglInfo1("Remboursement");
                        var20.setRglInfo2("Remboursement patient");
                     } else {
                        var20.setRglInfo1("Versement");
                        var20.setRglInfo2(((HospitalisationMedi)var15.get(var17)).getHosmedLibelle());
                        if (((HospitalisationReglement)var2.get(var11)).getHosregService() != null && !((HospitalisationReglement)var2.get(var11)).getHosregService().isEmpty()) {
                           this.reglements.setRglService(((HospitalisationReglement)var2.get(var11)).getHosregService());
                        }
                     }

                     var20.setRglInfo3(this.reglements.getRglService());
                     var20.setRglInfo5(this.reglements.getRglObjet());
                     var20.setRglRecette(((HospitalisationMedi)var15.get(var17)).getHosmedPatientHt() + ((HospitalisationMedi)var15.get(var17)).getHosmedPatientTaxe());
                     var1.add(var20);
                  }
               }
            }
         }

         if (var4 && var5 != 0.0D) {
            new Reglements();
            var20 = new Reglements();
            var20.setRglNum(this.reglements.getRglNum());
            var20.setRglDocument(this.reglements.getRglDocument());
            var20.setRglIdDocument(this.reglements.getRglIdDocument());
            var20.setRglDateReg(this.reglements.getRglDateReg());
            var20.setRglNumChqBdx(this.reglements.getRglNumChqBdx());
            var20.setRglBanqueTireur(this.reglements.getRglBanqueTireur());
            var20.setRglMode(this.reglements.getRglMode());
            var20.setRglCodeCaiss(this.reglements.getRglCodeCaiss());
            var20.setRglNomCaissier(this.reglements.getRglNomCaissier());
            var20.setRglDepense(this.reglements.getRglDepense());
            var20.setRglRecette(this.reglements.getRglRecette());
            var20.setRglTimbre(this.reglements.getRglTimbre());
            var20.setRglDevise(this.reglements.getRglDevise());
            var20.setRglInfo4(((HospitalisationReglement)var2.get(var11)).getHosregNumPieceTiers());
            var20.setRglNomTiers(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getPatients().getPatDossier() + "  " + this.reglements.getRglNomTiers());
            var20.setRglNomEquipe("N° Hospitalisation");
            if (((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().isHosAyantDroit()) {
               var20.setRglNomCommercial(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosNomAssurePrincipal());
            } else {
               var20.setRglNomCommercial("");
               if (((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getPatients().getPatSexe() == 0) {
                  var20.setRglNomCommercial("Elle-même");
               } else {
                  var20.setRglNomCommercial("Lui-même");
               }
            }

            if (((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosIdAssurance() != 0L) {
               var20.setRglNomResponsable(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosNomAssurance());
               var20.setRglNumTrf(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosContratAssurance());
            } else if (((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosIdSociete() != 0L) {
               var20.setRglNomResponsable(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosNomSociete());
               var20.setRglNumTrf(((HospitalisationReglement)var2.get(var11)).getHospitalisationEntete().getHosMatricule());
            } else {
               var20.setRglNomResponsable("");
               var20.setRglNumTrf("");
            }

            if (this.reglements.getRglRecette() < 0.0D) {
               var20.setRglInfo1("Remboursement");
               var20.setRglInfo2("Remboursement patient");
            } else {
               var20.setRglInfo1("Versement");
               var20.setRglInfo2("ANESTHESIE");
               this.reglements.setRglService("23:REANIMATION");
            }

            var20.setRglInfo3(this.reglements.getRglService());
            var20.setRglInfo5(this.reglements.getRglObjet());
            var20.setRglRecette(var5);
            var1.add(var20);
         }
      } else {
         Reglements var18 = new Reglements();
         var18.setRglNum(this.reglements.getRglNum());
         var18.setRglDocument(this.reglements.getRglDocument());
         var18.setRglIdDocument(this.reglements.getRglIdDocument());
         var18.setRglDateReg(this.reglements.getRglDateReg());
         var18.setRglNumChqBdx(this.reglements.getRglNumChqBdx());
         var18.setRglBanqueTireur(this.reglements.getRglBanqueTireur());
         var18.setRglMode(this.reglements.getRglMode());
         var18.setRglCodeCaiss(this.reglements.getRglCodeCaiss());
         var18.setRglNomCaissier(this.reglements.getRglNomCaissier());
         var18.setRglDepense(this.reglements.getRglDepense());
         var18.setRglRecette(this.reglements.getRglRecette());
         var18.setRglTimbre(this.reglements.getRglTimbre());
         var18.setRglDevise(this.reglements.getRglDevise());
         var18.setRglInfo4("");
         var18.setRglNomTiers(this.reglements.getRglDossier() + "  " + this.reglements.getRglNomTiers());
         var18.setRglNomEquipe("N° Hospitalisation");
         var18.setRglNomCommercial("****");
         var18.setRglNomResponsable("");
         var18.setRglNumTrf("");
         if (this.reglements.getRglRecette() < 0.0D) {
            var18.setRglInfo1("Remboursement");
            var18.setRglInfo2("Remboursement patient");
         } else {
            var18.setRglInfo1("Versement");
            var18.setRglInfo2("Versement patient");
         }

         var18.setRglInfo3(this.reglements.getRglService());
         var18.setRglInfo5(this.reglements.getRglObjet());
         var1.add(var18);
      }

      return var1;
   }

   public boolean verifProduitHospit(List var1, String var2) {
      boolean var3 = false;
      if (var1.size() != 0) {
         for(int var4 = 0; var4 < var1.size(); ++var4) {
            if (((HospitalisationReglement)var1.get(var4)).getHosregProduit() != null && !((HospitalisationReglement)var1.get(var4)).getHosregProduit().isEmpty() && ((HospitalisationReglement)var1.get(var4)).getHosregProduit().equals(var2)) {
               var3 = true;
               break;
            }
         }
      }

      return var3;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty() && this.reglements != null) {
            String var1 = this.utilNombre.begin(this.reglements.getRglRecette() + this.reglements.getRglDepense() + this.reglements.getRglTimbre(), this.reglements.getRglDevise());
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setEntete("Impression du reçu en cours");
            this.utilPrint.setMontant_lettre(var1);
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nomRepMod));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), 0));
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setNumDoc(this.reglements.getRglNum());
            String var12;
            List var16;
            int var21;
            JRBeanCollectionDataSource var22;
            if (this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && this.reglements.getRglOperation().equals("81")) {
               var12 = this.reglements.getRglNum();
               this.utilPrint.setVar_nom_col4("");
               new ArrayList();
               var16 = this.reglementsDao.chargeRecuByNum(var12, this.reglements.getRglCodeCaiss(), (Session)null);
               if (var16.size() != 0) {
                  for(var21 = 0; var21 < var16.size(); ++var21) {
                     if (((Reglements)var16.get(var21)).getRglLibReceptrice() != null && !((Reglements)var16.get(var21)).getRglLibReceptrice().isEmpty()) {
                        this.utilPrint.setVar_nom_col4(((Reglements)var16.get(var21)).getRglLibReceptrice());
                     }
                  }
               }

               this.lesChequesARemettre = new ArrayList();
               this.lesChequesARemettre = this.reglementsDao.chargeChequeCaisseImpression(this.reglements.getExercicesCaisse().getExecaiId(), this.reglements.getRglCodeCaiss(), var12, (Session)null);
               var22 = new JRBeanCollectionDataSource(this.lesChequesARemettre);
               this.utilPrint.setjRBeanCollectionDataSource(var22);
               this.utilPrint.setVar_nom_col1(this.reglements.getRglNum());
               this.utilPrint.setVar_nom_col2(this.utilDate.dateToStringFr(this.reglements.getRglDateReg()));
               this.utilPrint.setVar_nom_col3(this.reglements.getRglLibCaiss());
               this.utilPrint.setVar_nom_col5(this.reglements.getRglNomCaissier());
               this.utilPrint.setVar_nom_col6(this.reglements.getRglOperation());
               this.utilPrint.setVar_nom_col7(this.reglements.getRglLibelle());
               this.utilPrint.setVar_nom_col8(this.reglements.getRglObjet());
            } else if (this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && this.reglements.getRglOperation().equals("82")) {
               var12 = this.reglements.getRglNum();
               this.utilPrint.setVar_nom_col4("");
               new ArrayList();
               var16 = this.reglementsDao.chargeRecuByNum(var12, this.reglements.getRglCodeCaiss(), (Session)null);
               if (var16.size() != 0) {
                  for(var21 = 0; var21 < var16.size(); ++var21) {
                     if (((Reglements)var16.get(var21)).getRglLibReceptrice() != null && !((Reglements)var16.get(var21)).getRglLibReceptrice().isEmpty()) {
                        this.utilPrint.setVar_nom_col4(((Reglements)var16.get(var21)).getRglLibReceptrice());
                     }
                  }
               }

               this.lesEffetsARemettre = new ArrayList();
               this.lesEffetsARemettre = this.reglementsDao.chargeEffetCaisseImpression(this.reglements.getRglCodeCaiss(), var12, (Session)null);
               var22 = new JRBeanCollectionDataSource(this.lesEffetsARemettre);
               this.utilPrint.setjRBeanCollectionDataSource(var22);
               this.utilPrint.setVar_nom_col1(this.reglements.getRglNum());
               this.utilPrint.setVar_nom_col2(this.utilDate.dateToStringFr(this.reglements.getRglDateReg()));
               this.utilPrint.setVar_nom_col3(this.reglements.getRglLibCaiss());
               this.utilPrint.setVar_nom_col5(this.reglements.getRglNomCaissier());
               this.utilPrint.setVar_nom_col6(this.reglements.getRglOperation());
               this.utilPrint.setVar_nom_col7(this.reglements.getRglLibelle());
               this.utilPrint.setVar_nom_col8(this.reglements.getRglObjet());
            } else if (this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && this.reglements.getRglOperation().equals("83")) {
               var12 = this.reglements.getRglNum();
               this.utilPrint.setVar_nom_col4("");
               new ArrayList();
               var16 = this.reglementsDao.chargeRecuByNum(var12, this.reglements.getRglCodeCaiss(), (Session)null);
               if (var16.size() != 0) {
                  for(var21 = 0; var21 < var16.size(); ++var21) {
                     if (((Reglements)var16.get(var21)).getRglLibReceptrice() != null && !((Reglements)var16.get(var21)).getRglLibReceptrice().isEmpty()) {
                        this.utilPrint.setVar_nom_col4(((Reglements)var16.get(var21)).getRglLibReceptrice());
                     }
                  }
               }

               this.lesChequesARemettre = new ArrayList();
               this.lesChequesARemettre = this.reglementsDao.chargeChequeBanqueImpression(this.reglements.getRglCodeEmetrice(), var12, (Session)null);
               var22 = new JRBeanCollectionDataSource(this.lesChequesARemettre);
               this.utilPrint.setjRBeanCollectionDataSource(var22);
               this.utilPrint.setVar_nom_col1(this.reglements.getRglNum());
               this.utilPrint.setVar_nom_col2(this.utilDate.dateToStringFr(this.reglements.getRglDateReg()));
               this.utilPrint.setVar_nom_col3(this.reglements.getRglLibCaiss());
               this.utilPrint.setVar_nom_col5(this.reglements.getRglNomCaissier());
               this.utilPrint.setVar_nom_col6(this.reglements.getRglOperation());
               this.utilPrint.setVar_nom_col7(this.reglements.getRglLibelle());
               this.utilPrint.setVar_nom_col8(this.reglements.getRglObjet());
            } else if (this.reglements.getRglOperation() != null && !this.reglements.getRglOperation().isEmpty() && this.reglements.getRglOperation().equals("84")) {
               var12 = this.reglements.getRglNum();
               this.utilPrint.setVar_nom_col4("");
               new ArrayList();
               var16 = this.reglementsDao.chargeRecuByNum(var12, this.reglements.getRglCodeCaiss(), (Session)null);
               if (var16.size() != 0) {
                  for(var21 = 0; var21 < var16.size(); ++var21) {
                     if (((Reglements)var16.get(var21)).getRglLibReceptrice() != null && !((Reglements)var16.get(var21)).getRglLibReceptrice().isEmpty()) {
                        this.utilPrint.setVar_nom_col4(((Reglements)var16.get(var21)).getRglLibReceptrice());
                     }
                  }
               }

               this.lesEffetsARemettre = new ArrayList();
               this.lesEffetsARemettre = this.reglementsDao.chargeEffetBanqueImpression(this.reglements.getRglCodeEmetrice(), var12, (Session)null);
               var22 = new JRBeanCollectionDataSource(this.lesEffetsARemettre);
               this.utilPrint.setjRBeanCollectionDataSource(var22);
               this.utilPrint.setVar_nom_col1(this.reglements.getRglNum());
               this.utilPrint.setVar_nom_col2(this.utilDate.dateToStringFr(this.reglements.getRglDateReg()));
               this.utilPrint.setVar_nom_col3(this.reglements.getRglLibCaiss());
               this.utilPrint.setVar_nom_col5(this.reglements.getRglNomCaissier());
               this.utilPrint.setVar_nom_col6(this.reglements.getRglOperation());
               this.utilPrint.setVar_nom_col7(this.reglements.getRglLibelle());
               this.utilPrint.setVar_nom_col8(this.reglements.getRglObjet());
            } else {
               this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
               this.utilPrint.setVar_nom_col6(this.reglements.getRglOperation());
               this.reglements.setNumeCompte("");
               if (this.reglements.getRglOperation() == null || this.reglements.getRglOperation().isEmpty() || !this.reglements.getRglOperation().equals("83") && !this.reglements.getRglOperation().equals("84") && !this.reglements.getRglOperation().equals("85")) {
                  List var6;
                  int var7;
                  double var14;
                  if (this.reglements.getRglNatureDoc() != 22 && this.reglements.getRglNatureDoc() != 25 && this.reglements.getRglNatureDoc() != 27 && this.reglements.getRglNatureDoc() != 142) {
                     List var9;
                     int var10;
                     double var26;
                     if (this.reglements.getRglNatureDoc() == 165) {
                        var14 = 0.0D;
                        new BienFacture();
                        BienFactureDao var25 = new BienFactureDao(this.baseLog, this.utilInitHibernate);
                        BienFacture var20 = var25.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
                        if (var20 == null) {
                           this.reglements.setTotalFacture(0.0D);
                           this.reglements.setTotalReglement(0.0D);
                        } else {
                           new ArrayList();
                           var6 = this.reglementsDao.findRegByNatNum(165, var20.getBiefacNum(), (Session)null);
                           if (var6.size() != 0) {
                              for(var7 = 0; var7 < var6.size(); ++var7) {
                                 if (((Reglements)var6.get(var7)).getRglId() <= this.reglements.getRglId()) {
                                    var14 += ((Reglements)var6.get(var7)).getRglRecette();
                                 }
                              }
                           }

                           var26 = 0.0D;
                           new ArrayList();
                           var9 = this.reglementsDao.findRegByNatRecu(173, this.reglements.getRglNum(), (Session)null);
                           if (var9.size() != 0) {
                              for(var10 = 0; var10 < var9.size(); ++var10) {
                                 var26 += ((Reglements)var9.get(var10)).getRglRecette();
                              }
                           }

                           this.reglements.setTotalFacture(var20.getBiefacTotTtc());
                           this.reglements.setTotalReglement(var14);
                           this.reglements.setTotalRecette(var26);
                        }
                     } else if (this.reglements.getRglNatureDoc() == 173) {
                        var14 = 0.0D;
                        new AppelCharge();
                        AppelChargeDao var24 = new AppelChargeDao(this.baseLog, this.utilInitHibernate);
                        AppelCharge var19 = var24.pourParapheur(this.reglements.getRglIdDocument(), (Session)null);
                        if (var19 == null) {
                           this.reglements.setTotalFacture(0.0D);
                           this.reglements.setTotalReglement(0.0D);
                        } else {
                           new ArrayList();
                           var6 = this.reglementsDao.findRegByNatNum(173, var19.getAppchaNum(), (Session)null);
                           if (var6.size() != 0) {
                              for(var7 = 0; var7 < var6.size(); ++var7) {
                                 if (((Reglements)var6.get(var7)).getRglId() <= this.reglements.getRglId()) {
                                    var14 += ((Reglements)var6.get(var7)).getRglRecette();
                                 }
                              }
                           }

                           var26 = 0.0D;
                           new ArrayList();
                           var9 = this.reglementsDao.findRegByNatRecu(173, this.reglements.getRglNum(), (Session)null);
                           if (var9.size() != 0) {
                              for(var10 = 0; var10 < var9.size(); ++var10) {
                                 var26 += ((Reglements)var9.get(var10)).getRglRecette();
                              }
                           }

                           this.reglements.setTotalFacture(var19.getAppchaTotTtc());
                           this.reglements.setTotalReglement(var14);
                           this.reglements.setTotalRecette(var26);
                        }
                     }
                  } else {
                     var14 = 0.0D;
                     String var17 = "";
                     String var18 = "";
                     new ArrayList();
                     var6 = this.reglementsDao.chargeRecuByNum(this.reglements.getRglNum(), this.reglements.getRglCodeCaiss(), this.reglements.getRglNatureDoc(), this.reglements.getRglDateReg(), (Session)null);
                     if (var6.size() != 0) {
                        for(var7 = 0; var7 < var6.size(); ++var7) {
                           if (var17 == null && var17.isEmpty()) {
                              var17 = ((Reglements)var6.get(var7)).getRglDocument();
                              var18 = "" + this.utilNombre.beginText(((Reglements)var6.get(var7)).getRglRecette() + ((Reglements)var6.get(var7)).getRglTimbre(), this.structureLog.getStrformatdevise());
                           } else {
                              var17 = var17 + "\n" + ((Reglements)var6.get(var7)).getRglDocument();
                              var18 = var18 + "\n" + this.utilNombre.beginText(((Reglements)var6.get(var7)).getRglRecette() + ((Reglements)var6.get(var7)).getRglTimbre(), this.structureLog.getStrformatdevise());
                           }

                           var14 = var14 + ((Reglements)var6.get(var7)).getRglRecette() + ((Reglements)var6.get(var7)).getRglTimbre();
                        }

                        if (var6.size() == 1) {
                           var17 = null;
                           var18 = null;
                        }
                     } else {
                        var17 = null;
                        var18 = null;
                     }

                     var1 = this.utilNombre.begin(var14, this.reglements.getRglDevise());
                     var6.clear();
                     var6.add(this.reglements);
                     JRBeanCollectionDataSource var23 = new JRBeanCollectionDataSource(var6);
                     this.utilPrint.setjRBeanCollectionDataSource(var23);
                     this.utilPrint.setEntete("Impression reçu");
                     this.utilPrint.setImageFondPage((String)null);
                     this.utilPrint.setTaux(1.0F);
                     this.utilPrint.setAnnexe1(var17);
                     this.utilPrint.setAnnexe2(var18);
                     this.utilPrint.setPlafond(var14);
                     this.utilPrint.setMontant_lettre(var1);
                     this.utilPrint.setIdResponsable(this.reglements.getRglIdResponsable());
                     this.utilPrint.setIdCommercial(this.reglements.getRglIdCommercial());
                     this.utilPrint.setTiersSelectionne((Tiers)null);
                     this.utilPrint.setContact((Contacts)null);
                     this.utilPrint.setNumDoc(this.reglements.getRglNum());
                     this.utilPrint.setNature(this.nature);
                     this.utilPrint.setId_doc(this.reglements.getRglId());
                     this.utilPrint.setParc((Parc)null);
                  }
               } else {
                  if (this.reglements.getRglCodeReceptrice() == null || this.reglements.getRglCodeReceptrice().isEmpty()) {
                     new ArrayList();
                     String var3 = "rglNum='" + this.reglements.getRglNum() + "' and rglCategorie=" + this.reglements.getRglCategorie() + " and rglOperation='" + this.reglements.getRglOperation() + "' and rglDateReg='" + this.reglements.getRglDateReg() + "'";
                     List var2 = this.reglementsDao.rechercheReglementsRequete(var3, (Session)null);
                     if (var2.size() != 0) {
                        new Reglements();

                        for(int var5 = 0; var5 < var2.size(); ++var5) {
                           Reglements var4 = (Reglements)var2.get(var5);
                           if (var4.getRglCodeReceptrice() != null && !var4.getRglCodeReceptrice().isEmpty()) {
                              this.reglements.setRglCodeReceptrice(var4.getRglCodeReceptrice());
                              break;
                           }
                        }
                     }
                  }

                  if (this.reglements.getRglCodeReceptrice() != null && !this.reglements.getRglCodeReceptrice().isEmpty()) {
                     var12 = "";
                     if (this.reglements.getRglCodeReceptrice().contains(":")) {
                        String[] var13 = this.reglements.getRglCodeReceptrice().split(":");
                        var12 = var13[0];
                     } else {
                        var12 = this.reglements.getRglCodeReceptrice();
                     }

                     new JournauxComptables();
                     this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
                     JournauxComptables var15 = this.journauxComptablesDao.chercherCode(var12, this.exercicesComptable.getExecpt_id(), (Session)null);
                     if (var15 != null) {
                        this.reglements.setRglLibReceptrice(var15.getPljLibelleFr());
                        this.reglements.setNumeCompte(var15.getPljCodeBanque() + " " + var15.getPljCodeGuichet() + " " + var15.getPljNumeroCompte() + "/" + var15.getPljCleRib());
                     }
                  }
               }
            }

            if (this.utilPrint.getjRBeanCollectionDataSource().getRecordCount() != 0) {
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            }
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des reçus");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsListe" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.nature);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var11 = new JRBeanCollectionDataSource(this.lesElements);
         this.utilPrint.setjRBeanCollectionDataSource(var11);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public void initImpressionMensuelle() throws IOException {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.affMail = false;
      this.showModalPanelPrint = true;
   }

   public void imprimerPRTCaisse() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.imprimerCaisse();
   }

   public void imprimerJRVCaisse() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimerCaisse();
   }

   public void imprimerPDFCaisse() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimerCaisse();
   }

   public void imprimerODTCaisse() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimerCaisse();
   }

   public void imprimerXLSCaisse() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimerCaisse();
   }

   public void imprimerDOCCaisse() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimerCaisse();
   }

   public void imprimerHTMLCaisse() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimerCaisse();
   }

   public void imprimerXMLCaisse() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimerCaisse();
   }

   public void imprimerMAILCaisse() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimerCaisse();
      }

   }

   public void imprimerCaisse() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des règlements");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsListe" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.nature);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesElements);
         this.utilPrint.setjRBeanCollectionDataSource(var1);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

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

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public String getVar_caisse() {
      return this.var_caisse;
   }

   public void setVar_caisse(String var1) {
      this.var_caisse = var1;
   }

   public ExercicesCaisse getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesCaisse var1) {
      this.lastExo = var1;
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

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
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

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
   }

   public ExercicesCaisse getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesCaisse var1) {
      this.selectedExo = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isVar_acc_descriptif() {
      return this.var_acc_descriptif;
   }

   public void setVar_acc_descriptif(boolean var1) {
      this.var_acc_descriptif = var1;
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

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public BonCaisse getBonCaisse() {
      return this.bonCaisse;
   }

   public void setBonCaisse(BonCaisse var1) {
      this.bonCaisse = var1;
   }

   public DataModel getDatamodelElement() {
      return this.datamodelElement;
   }

   public void setDatamodelElement(DataModel var1) {
      this.datamodelElement = var1;
   }

   public List getMesTypeTiers() {
      return this.mesTypeTiers;
   }

   public void setMesTypeTiers(List var1) {
      this.mesTypeTiers = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public String getInpCaisse() {
      return this.inpCaisse;
   }

   public void setInpCaisse(String var1) {
      this.inpCaisse = var1;
   }

   public String getInpNature() {
      return this.inpNature;
   }

   public void setInpNature(String var1) {
      this.inpNature = var1;
   }

   public boolean isVar_valide() {
      return this.var_valide;
   }

   public void setVar_valide(boolean var1) {
      this.var_valide = var1;
   }

   public String getInputBanq() {
      return this.inputBanq;
   }

   public void setInputBanq(String var1) {
      this.inputBanq = var1;
   }

   public boolean isVar_affiche_banque() {
      return this.var_affiche_banque;
   }

   public void setVar_affiche_banque(boolean var1) {
      this.var_affiche_banque = var1;
   }

   public String getVar_modeReglement() {
      return this.var_modeReglement;
   }

   public void setVar_modeReglement(String var1) {
      this.var_modeReglement = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public OptionCaisses getOptionCaisses() {
      return this.optionCaisses;
   }

   public void setOptionCaisses(OptionCaisses var1) {
      this.optionCaisses = var1;
   }

   public BonEncaissementVente getBonEncaissementVente() {
      return this.bonEncaissementVente;
   }

   public void setBonEncaissementVente(BonEncaissementVente var1) {
      this.bonEncaissementVente = var1;
   }

   public Reglements getReglements() {
      return this.reglements;
   }

   public void setReglements(Reglements var1) {
      this.reglements = var1;
   }

   public boolean isAffichBanq() {
      return this.affichBanq;
   }

   public void setAffichBanq(boolean var1) {
      this.affichBanq = var1;
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

   public boolean isVar_verrou_caisse() {
      return this.var_verrou_caisse;
   }

   public void setVar_verrou_caisse(boolean var1) {
      this.var_verrou_caisse = var1;
   }

   public BonDecaissementAchat getBonDecaissementAchat() {
      return this.bonDecaissementAchat;
   }

   public void setBonDecaissementAchat(BonDecaissementAchat var1) {
      this.bonDecaissementAchat = var1;
   }

   public BonEntreCaiss getBonEntreCaiss() {
      return this.bonEntreCaiss;
   }

   public void setBonEntreCaiss(BonEntreCaiss var1) {
      this.bonEntreCaiss = var1;
   }

   public BonSortieCaiss getBonSortieCaiss() {
      return this.bonSortieCaiss;
   }

   public void setBonSortieCaiss(BonSortieCaiss var1) {
      this.bonSortieCaiss = var1;
   }

   public VirementInterne getVirementInterne() {
      return this.virementInterne;
   }

   public void setVirementInterne(VirementInterne var1) {
      this.virementInterne = var1;
   }

   public boolean isExistCaiss() {
      return this.existCaiss;
   }

   public void setExistCaiss(boolean var1) {
      this.existCaiss = var1;
   }

   public boolean isVar_affiche_depot() {
      return this.var_affiche_depot;
   }

   public void setVar_affiche_depot(boolean var1) {
      this.var_affiche_depot = var1;
   }

   public String getInputBanqEmetteur() {
      return this.inputBanqEmetteur;
   }

   public void setInputBanqEmetteur(String var1) {
      this.inputBanqEmetteur = var1;
   }

   public String getInputBanqRecepteur() {
      return this.inputBanqRecepteur;
   }

   public void setInputBanqRecepteur(String var1) {
      this.inputBanqRecepteur = var1;
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

   public String getVar_modele() {
      return this.var_modele;
   }

   public void setVar_modele(String var1) {
      this.var_modele = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public double getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(double var1) {
      this.var_timbre = var1;
   }

   public double getVar_aPayer() {
      return this.var_aPayer;
   }

   public void setVar_aPayer(double var1) {
      this.var_aPayer = var1;
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

   public String getVar_titre_recu() {
      return this.var_titre_recu;
   }

   public void setVar_titre_recu(String var1) {
      this.var_titre_recu = var1;
   }

   public String getVar_banque() {
      return this.var_banque;
   }

   public void setVar_banque(String var1) {
      this.var_banque = var1;
   }

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
   }

   public boolean isVar_depot() {
      return this.var_depot;
   }

   public void setVar_depot(boolean var1) {
      this.var_depot = var1;
   }

   public List getLesPeriodes() {
      return this.lesPeriodes;
   }

   public void setLesPeriodes(List var1) {
      this.lesPeriodes = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public Date getInpDate() {
      return this.inpDate;
   }

   public void setInpDate(Date var1) {
      this.inpDate = var1;
   }

   public boolean isVar_rendu() {
      return this.var_rendu;
   }

   public void setVar_rendu(boolean var1) {
      this.var_rendu = var1;
   }

   public boolean isVar_garde() {
      return this.var_garde;
   }

   public void setVar_garde(boolean var1) {
      this.var_garde = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public double getVar_aEncaisser() {
      return this.var_aEncaisser;
   }

   public void setVar_aEncaisser(double var1) {
      this.var_aEncaisser = var1;
   }

   public double getVar_montant_recu() {
      return this.var_montant_recu;
   }

   public void setVar_montant_recu(double var1) {
      this.var_montant_recu = var1;
   }

   public double getVar_montant_rendu() {
      return this.var_montant_rendu;
   }

   public void setVar_montant_rendu(double var1) {
      this.var_montant_rendu = var1;
   }

   public String getLibActivite() {
      return this.libActivite;
   }

   public void setLibActivite(String var1) {
      this.libActivite = var1;
   }

   public boolean isAffActivite() {
      return this.affActivite;
   }

   public void setAffActivite(boolean var1) {
      this.affActivite = var1;
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

   public DataModel getDatamodelTransfert() {
      return this.datamodelTransfert;
   }

   public void setDatamodelTransfert(DataModel var1) {
      this.datamodelTransfert = var1;
   }

   public CaissesCommerciales getCaissesCommerciales() {
      return this.caissesCommerciales;
   }

   public void setCaissesCommerciales(CaissesCommerciales var1) {
      this.caissesCommerciales = var1;
   }

   public List getMesModesReglementsItem() {
      return this.mesModesReglementsItem;
   }

   public void setMesModesReglementsItem(List var1) {
      this.mesModesReglementsItem = var1;
   }

   public List getMesOperationsItems() {
      return this.mesOperationsItems;
   }

   public void setMesOperationsItems(List var1) {
      this.mesOperationsItems = var1;
   }

   public String getNatureOperation() {
      return this.natureOperation;
   }

   public void setNatureOperation(String var1) {
      this.natureOperation = var1;
   }

   public boolean isVisibleSuite() {
      return this.visibleSuite;
   }

   public void setVisibleSuite(boolean var1) {
      this.visibleSuite = var1;
   }

   public CaissesOperations getCaissesOperations() {
      return this.caissesOperations;
   }

   public void setCaissesOperations(CaissesOperations var1) {
      this.caissesOperations = var1;
   }

   public boolean isPlanfond_depasse() {
      return this.planfond_depasse;
   }

   public void setPlanfond_depasse(boolean var1) {
      this.planfond_depasse = var1;
   }

   public boolean isVar_verrouCaisseExecutrice() {
      return this.var_verrouCaisseExecutrice;
   }

   public void setVar_verrouCaisseExecutrice(boolean var1) {
      this.var_verrouCaisseExecutrice = var1;
   }

   public List getMesEmetteursItems() {
      return this.mesEmetteursItems;
   }

   public void setMesEmetteursItems(List var1) {
      this.mesEmetteursItems = var1;
   }

   public List getMesRecepteursItems() {
      return this.mesRecepteursItems;
   }

   public void setMesRecepteursItems(List var1) {
      this.mesRecepteursItems = var1;
   }

   public boolean isAffichage_cheque() {
      return this.affichage_cheque;
   }

   public void setAffichage_cheque(boolean var1) {
      this.affichage_cheque = var1;
   }

   public boolean isAffichage_effet() {
      return this.affichage_effet;
   }

   public void setAffichage_effet(boolean var1) {
      this.affichage_effet = var1;
   }

   public DataModel getDataModelDetailAremettre() {
      return this.dataModelDetailAremettre;
   }

   public void setDataModelDetailAremettre(DataModel var1) {
      this.dataModelDetailAremettre = var1;
   }

   public List getMesCaissesDepenseItems() {
      return this.mesCaissesDepenseItems;
   }

   public void setMesCaissesDepenseItems(List var1) {
      this.mesCaissesDepenseItems = var1;
   }

   public List getMesCaissesExecutriceItems() {
      return this.mesCaissesExecutriceItems;
   }

   public void setMesCaissesExecutriceItems(List var1) {
      this.mesCaissesExecutriceItems = var1;
   }

   public List getMesCaissesRecetteItems() {
      return this.mesCaissesRecetteItems;
   }

   public void setMesCaissesRecetteItems(List var1) {
      this.mesCaissesRecetteItems = var1;
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

   public boolean isAffichage_espece() {
      return this.affichage_espece;
   }

   public void setAffichage_espece(boolean var1) {
      this.affichage_espece = var1;
   }

   public double getTot_b1() {
      return this.tot_b1;
   }

   public void setTot_b1(double var1) {
      this.tot_b1 = var1;
   }

   public double getTot_b10() {
      return this.tot_b10;
   }

   public void setTot_b10(double var1) {
      this.tot_b10 = var1;
   }

   public double getTot_b2() {
      return this.tot_b2;
   }

   public void setTot_b2(double var1) {
      this.tot_b2 = var1;
   }

   public double getTot_b3() {
      return this.tot_b3;
   }

   public void setTot_b3(double var1) {
      this.tot_b3 = var1;
   }

   public double getTot_b4() {
      return this.tot_b4;
   }

   public void setTot_b4(double var1) {
      this.tot_b4 = var1;
   }

   public double getTot_b5() {
      return this.tot_b5;
   }

   public void setTot_b5(double var1) {
      this.tot_b5 = var1;
   }

   public double getTot_b6() {
      return this.tot_b6;
   }

   public void setTot_b6(double var1) {
      this.tot_b6 = var1;
   }

   public double getTot_b7() {
      return this.tot_b7;
   }

   public void setTot_b7(double var1) {
      this.tot_b7 = var1;
   }

   public double getTot_b8() {
      return this.tot_b8;
   }

   public void setTot_b8(double var1) {
      this.tot_b8 = var1;
   }

   public double getTot_b9() {
      return this.tot_b9;
   }

   public void setTot_b9(double var1) {
      this.tot_b9 = var1;
   }

   public double getTot_p1() {
      return this.tot_p1;
   }

   public void setTot_p1(double var1) {
      this.tot_p1 = var1;
   }

   public double getTot_p10() {
      return this.tot_p10;
   }

   public void setTot_p10(double var1) {
      this.tot_p10 = var1;
   }

   public double getTot_p2() {
      return this.tot_p2;
   }

   public void setTot_p2(double var1) {
      this.tot_p2 = var1;
   }

   public double getTot_p3() {
      return this.tot_p3;
   }

   public void setTot_p3(double var1) {
      this.tot_p3 = var1;
   }

   public double getTot_p4() {
      return this.tot_p4;
   }

   public void setTot_p4(double var1) {
      this.tot_p4 = var1;
   }

   public double getTot_p5() {
      return this.tot_p5;
   }

   public void setTot_p5(double var1) {
      this.tot_p5 = var1;
   }

   public double getTot_p6() {
      return this.tot_p6;
   }

   public void setTot_p6(double var1) {
      this.tot_p6 = var1;
   }

   public double getTot_p7() {
      return this.tot_p7;
   }

   public void setTot_p7(double var1) {
      this.tot_p7 = var1;
   }

   public double getTot_p8() {
      return this.tot_p8;
   }

   public void setTot_p8(double var1) {
      this.tot_p8 = var1;
   }

   public double getTot_p9() {
      return this.tot_p9;
   }

   public void setTot_p9(double var1) {
      this.tot_p9 = var1;
   }

   public double getTotalBillet() {
      return this.totalBillet;
   }

   public void setTotalBillet(double var1) {
      this.totalBillet = var1;
   }

   public double getTotalPiece() {
      return this.totalPiece;
   }

   public void setTotalPiece(double var1) {
      this.totalPiece = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public boolean isRegul() {
      return this.regul;
   }

   public void setRegul(boolean var1) {
      this.regul = var1;
   }

   public List getMesModesReglementsRecItem() {
      return this.mesModesReglementsRecItem;
   }

   public void setMesModesReglementsRecItem(List var1) {
      this.mesModesReglementsRecItem = var1;
   }

   public List getMesBonsCaisse() {
      return this.mesBonsCaisse;
   }

   public void setMesBonsCaisse(List var1) {
      this.mesBonsCaisse = var1;
   }

   public boolean isAffichage_bonCaisse() {
      return this.affichage_bonCaisse;
   }

   public void setAffichage_bonCaisse(boolean var1) {
      this.affichage_bonCaisse = var1;
   }

   public double getVar_monnaie() {
      return this.var_monnaie;
   }

   public void setVar_monnaie(double var1) {
      this.var_monnaie = var1;
   }

   public double getVar_total_bon() {
      return this.var_total_bon;
   }

   public void setVar_total_bon(double var1) {
      this.var_total_bon = var1;
   }

   public boolean isShowModalpanelDetail() {
      return this.showModalpanelDetail;
   }

   public void setShowModalpanelDetail(boolean var1) {
      this.showModalpanelDetail = var1;
   }

   public String getVar_mode_reglement() {
      return this.var_mode_reglement;
   }

   public void setVar_mode_reglement(String var1) {
      this.var_mode_reglement = var1;
   }

   public List getMesModeReglements() {
      return this.mesModeReglements;
   }

   public void setMesModeReglements(List var1) {
      this.mesModeReglements = var1;
   }

   public String getRecherchePiece() {
      return this.recherchePiece;
   }

   public void setRecherchePiece(String var1) {
      this.recherchePiece = var1;
   }

   public String getRechercheTiers() {
      return this.rechercheTiers;
   }

   public void setRechercheTiers(String var1) {
      this.rechercheTiers = var1;
   }

   public List getMesCaissesItems() {
      return this.mesCaissesItems;
   }

   public void setMesCaissesItems(List var1) {
      this.mesCaissesItems = var1;
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

   public DataModel getDataModelDecoupageActivtes() {
      return this.dataModelDecoupageActivtes;
   }

   public void setDataModelDecoupageActivtes(DataModel var1) {
      this.dataModelDecoupageActivtes = var1;
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

   public String getRechercheRecu() {
      return this.rechercheRecu;
   }

   public void setRechercheRecu(String var1) {
      this.rechercheRecu = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public boolean isShowModalPanelEncaissement() {
      return this.showModalPanelEncaissement;
   }

   public void setShowModalPanelEncaissement(boolean var1) {
      this.showModalPanelEncaissement = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public double getSoldeCaisse() {
      return this.soldeCaisse;
   }

   public void setSoldeCaisse(double var1) {
      this.soldeCaisse = var1;
   }

   public boolean isProjetActif() {
      return this.projetActif;
   }

   public void setProjetActif(boolean var1) {
      this.projetActif = var1;
   }

   public List getLesPostesBudgetaires() {
      return this.lesPostesBudgetaires;
   }

   public void setLesPostesBudgetaires(List var1) {
      this.lesPostesBudgetaires = var1;
   }

   public boolean isVar_activite() {
      return this.var_activite;
   }

   public void setVar_activite(boolean var1) {
      this.var_activite = var1;
   }

   public boolean isVar_budget() {
      return this.var_budget;
   }

   public void setVar_budget(boolean var1) {
      this.var_budget = var1;
   }

   public boolean isVar_departement() {
      return this.var_departement;
   }

   public void setVar_departement(boolean var1) {
      this.var_departement = var1;
   }

   public boolean isVar_dossier() {
      return this.var_dossier;
   }

   public void setVar_dossier(boolean var1) {
      this.var_dossier = var1;
   }

   public boolean isVar_parc() {
      return this.var_parc;
   }

   public void setVar_parc(boolean var1) {
      this.var_parc = var1;
   }

   public boolean isVar_pdv() {
      return this.var_pdv;
   }

   public void setVar_pdv(boolean var1) {
      this.var_pdv = var1;
   }

   public boolean isVar_region() {
      return this.var_region;
   }

   public void setVar_region(boolean var1) {
      this.var_region = var1;
   }

   public boolean isVar_secteur() {
      return this.var_secteur;
   }

   public void setVar_secteur(boolean var1) {
      this.var_secteur = var1;
   }

   public boolean isVar_service() {
      return this.var_service;
   }

   public void setVar_service(boolean var1) {
      this.var_service = var1;
   }

   public boolean isVar_site() {
      return this.var_site;
   }

   public void setVar_site(boolean var1) {
      this.var_site = var1;
   }

   public boolean isAffichageExoCompte() {
      return this.affichageExoCompte;
   }

   public void setAffichageExoCompte(boolean var1) {
      this.affichageExoCompte = var1;
   }

   public boolean isMemoExoTaxe() {
      return this.memoExoTaxe;
   }

   public void setMemoExoTaxe(boolean var1) {
      this.memoExoTaxe = var1;
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

   public boolean isVar_affiche_lettreGarantie() {
      return this.var_affiche_lettreGarantie;
   }

   public void setVar_affiche_lettreGarantie(boolean var1) {
      this.var_affiche_lettreGarantie = var1;
   }

   public DataModel getDataModelCle1() {
      return this.dataModelCle1;
   }

   public void setDataModelCle1(DataModel var1) {
      this.dataModelCle1 = var1;
   }

   public DataModel getDataModelCle2() {
      return this.dataModelCle2;
   }

   public void setDataModelCle2(DataModel var1) {
      this.dataModelCle2 = var1;
   }

   public boolean isAffiche_Cle1() {
      return this.affiche_Cle1;
   }

   public void setAffiche_Cle1(boolean var1) {
      this.affiche_Cle1 = var1;
   }

   public boolean isAffiche_Cle2() {
      return this.affiche_Cle2;
   }

   public void setAffiche_Cle2(boolean var1) {
      this.affiche_Cle2 = var1;
   }

   public boolean isVar_cle() {
      return this.var_cle;
   }

   public void setVar_cle(boolean var1) {
      this.var_cle = var1;
   }

   public List getListCaisses() {
      return this.listCaisses;
   }

   public void setListCaisses(List var1) {
      this.listCaisses = var1;
   }

   public List getMesCaissesRecusItems() {
      return this.mesCaissesRecusItems;
   }

   public void setMesCaissesRecusItems(List var1) {
      this.mesCaissesRecusItems = var1;
   }

   public List getMesTiersItems() {
      return this.mesTiersItems;
   }

   public void setMesTiersItems(List var1) {
      this.mesTiersItems = var1;
   }

   public double getTotalDepense() {
      return this.totalDepense;
   }

   public void setTotalDepense(double var1) {
      this.totalDepense = var1;
   }

   public double getTotalRecette() {
      return this.totalRecette;
   }

   public void setTotalRecette(double var1) {
      this.totalRecette = var1;
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

   public boolean isShowModalpanelMessage() {
      return this.showModalpanelMessage;
   }

   public void setShowModalpanelMessage(boolean var1) {
      this.showModalpanelMessage = var1;
   }

   public String getTexteMessae() {
      return this.texteMessae;
   }

   public void setTexteMessae(String var1) {
      this.texteMessae = var1;
   }

   public double getRechercheMontant() {
      return this.rechercheMontant;
   }

   public void setRechercheMontant(double var1) {
      this.rechercheMontant = var1;
   }

   public boolean isShowModalPanelMotifAnnuler() {
      return this.showModalPanelMotifAnnuler;
   }

   public void setShowModalPanelMotifAnnuler(boolean var1) {
      this.showModalPanelMotifAnnuler = var1;
   }

   public boolean isShowModalPanelMotifSupprimer() {
      return this.showModalPanelMotifSupprimer;
   }

   public void setShowModalPanelMotifSupprimer(boolean var1) {
      this.showModalPanelMotifSupprimer = var1;
   }

   public int getTypeDocumentAPayer() {
      return this.typeDocumentAPayer;
   }

   public void setTypeDocumentAPayer(int var1) {
      this.typeDocumentAPayer = var1;
   }

   public FormAnalytique getFormAnalytique() {
      return this.formAnalytique;
   }

   public void setFormAnalytique(FormAnalytique var1) {
      this.formAnalytique = var1;
   }
}
