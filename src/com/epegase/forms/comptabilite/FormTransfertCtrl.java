package com.epegase.forms.comptabilite;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.Amortissements;
import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienFacture;
import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.BulletinMois;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesOperations;
import com.epegase.systeme.classe.ChargementEntete;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteMedical;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureInterneEnteteVentes;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.JournauxMois;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LocalisationImmobilisation;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PlanAnalytiqueRepartition;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.PlansBudgetaires;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.ProductionAtelier;
import com.epegase.systeme.classe.ProductionLigne;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesAchats;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.TicketEnteteVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.TransfertCompta;
import com.epegase.systeme.control.TransfertVentes;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.AmortissementsDao;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.BrouillardDao;
import com.epegase.systeme.dao.BulletinMoisDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CaissesOperationsDao;
import com.epegase.systeme.dao.ChargementEnteteDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.ElevesDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureEnteteMedicalDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneEnteteVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.JournauxMoisDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LocalisationImmobilisationDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PlanAnalytiqueRepartitionDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProductionAtelierDao;
import com.epegase.systeme.dao.ProductionLigneDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.RacinesDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TicketEnteteVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.xml.ObjetPays;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionMedical;
import com.epegase.systeme.xml.OptionPaye;
import com.epegase.systeme.xml.OptionVentes;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.DataModel;
import javax.naming.NamingException;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormTransfertCtrl implements Serializable {
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
   private boolean anExiste = false;
   private int balance;
   private SiteDao siteDao;
   private DepartementDao departementDao;
   private ServiceDao serviceDao;
   private RegionDao regionDao;
   private SecteurDao secteurDao;
   private PointDeVenteDao pointDeVenteDao;
   private PlansAnalytiquesDao analytiqueDao;
   private ActivitesDao activitesDao;
   private ProjetsDao projetsDao;
   private PlansBudgetairesDao plansBudgetairesDao;
   private DocumentEntete documentEntete;
   private PlanComptable planComptable = new PlanComptable();
   private List lesplanComptables;
   private transient DataModel datamodelPlanComptable;
   private PlanComptableDao planComptableDao;
   private EcrituresDao ecrituresDao;
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
   private ObjetPays objetPays;
   private Chrono chrono;
   private Chrono chronoTransfert;
   private ChronoDao chronoDao;
   private Produits produits;
   private TaxesAchats taxesAchats;
   private TaxesAchatsDao taxesAchatsDao;
   private FamillesProduitsAchats famillesProduitsAchats;
   private FamillesProduitsAchatsDao famillesProduitsAchatsDao;
   private ProduitsAchsDao produitsAchsDao;
   private FactureEnteteAchats factureEnteteAchats;
   private FactureEnteteAchatsDao factureEnteteAchatsDao;
   private AvoirEnteteAchats avoirEnteteAchats;
   private AvoirEnteteAchatsDao avoirEnteteAchatsDao;
   private NoteDebitEnteteAchats noteDebitEnteteAchats;
   private NoteDebitEnteteAchatsDao noteDebitEnteteAchatsDao;
   private FraisEnteteAchats fraisEnteteAchats;
   private FraisEnteteAchatsDao fraisEnteteAchatsDao;
   private ValorisationEnteteAchats valorisationEnteteAchats;
   private ValorisationEnteteAchatsDao valorisationEnteteAchatsDao;
   private TaxesVentes taxesVentes;
   private TaxesVentesDao taxesVentesDao;
   private FamillesProduitsVentes famillesProduitsVentes;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private ProduitsVtesDao produitsVtesDao;
   private CommandeEnteteVentes commandeEnteteVentes;
   private CommandeEnteteVentesDao commandeEnteteVentesDao;
   private FactureEnteteVentes factureEnteteVentes;
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private AvoirEnteteVentes avoirEnteteVentes;
   private AvoirEnteteVentesDao avoirEnteteVentesDao;
   private NoteDebitEnteteVentes noteDebitEnteteVentes;
   private NoteDebitEnteteVentesDao noteDebitEnteteVentesDao;
   private FactureInterneEnteteVentes factureInterneEnteteVentes;
   private FactureInterneEnteteVentesDao factureInterneEnteteVentesDao;
   private TicketEnteteVentes ticketEnteteVentes;
   private TicketEnteteVentesDao ticketEnteteVentesDao;
   private ConsultationEnteteGeneDao consultationEnteteGeneDao;
   private PharmacieEnteteDao pharmacieEnteteDao;
   private LaboratoireEnteteDao laboratoireEnteteDao;
   private HospitalisationEnteteDao hospitalisationEnteteDao;
   private FactureEnteteMedicalDao factureEnteteMedicalDao;
   private BienFacture bienFacture;
   private OptionCaisses optionCaisses;
   private Reglements reglements;
   private ReglementsDao reglementsDao;
   private CaissesCommerciales caissesCommerciales;
   private CaissesCommercialesDao caissesCommercialesDao;
   private Tiers tiers;
   private TiersDao tiersDao;
   private Salaries salaries;
   private SalariesDao salariesDao;
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
   private BulletinMois bulletinMois;
   private BulletinMoisDao bulletinMoisDao;
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
   private List lesDecoupagesActivites;
   private transient DataModel dataModelDecoupageActivtes;
   private double totalImputation;
   private double soldeImputation;
   private int choixRacine;
   private String selecFiscalite;
   private FormTransfertCompta formTransfertCompta;
   private String messageErreur;
   private List lesErreurs = new ArrayList();
   private Amortissements amortissements;
   private AmortissementsDao amortissementsDao;
   private TransfertVentes transfertVentes;

   public void InstancesDaoUtilses() {
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.brouillardDao = new BrouillardDao(this.baseLog, this.utilInitHibernate);
      this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.departementDao = new DepartementDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.regionDao = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.secteurDao = new SecteurDao(this.baseLog, this.utilInitHibernate);
      this.pointDeVenteDao = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
      this.analytiqueDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.racinesDao = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.journauxMoisDao = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.parcDao = new ParcDao(this.baseLog, this.utilInitHibernate);
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.plansBudgetairesDao = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      this.taxesAchatsDao = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
   }

   public double calculeNbDecimale(double var1) {
      double var3 = 0.0D;
      var3 = this.utilNombre.myRoundDevise(var1, this.structureLog.getStrdevise());
      return var3;
   }

   public String calculeLibelleCompte(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = "";
      new PlanComptable();
      PlanComptable var4 = this.planComptableDao.chercherCompte(this.selecFiscalite, var1, this.exercicesComptable.getExecpt_id(), var2);
      if (var4 != null) {
         var3 = var4.getPlcLibelleCpteFR();
      } else {
         var3 = "???";
      }

      return var3;
   }

   public void filtreCompta() throws HibernateException, NamingException, ParseException {
      this.formTransfertCompta.setVar_info("Chargement des ecritures de la periode...");
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      new ArrayList();
      ArrayList var2 = new ArrayList();
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      if (this.formTransfertCompta.getLesTransfertCompta().size() != 0) {
         String var4 = ((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(0)).getTrfCode();
         Date var5 = null;
         Date var6 = null;
         var5 = this.utilDate.datePremierJourMois(((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(0)).getTrfDateSaisie());
         var6 = this.utilDate.dateDernierJourMois(((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(0)).getTrfDateSaisie());
         String var7 = this.utilDate.dateToStringSQLLight(var5);
         String var8 = this.utilDate.dateToStringSQLLight(var6);
         List var1 = this.ecrituresDao.mesextraitCompte(var7, var8, var4, var3);

         for(int var9 = 0; var9 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var9) {
            this.formTransfertCompta.setTransfertCompta((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var9));
            this.formTransfertCompta.setVar_info("Ref1 " + this.formTransfertCompta.getTransfertCompta().getTrfReference1() + " - Nb lignes : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var9 != 0) {
               double var10 = (double)this.formTransfertCompta.getLesTransfertCompta().size();
               double var12 = this.utilNombre.myRound(var10 / (double)var9, 4);
               double var14 = this.utilNombre.myRound(100.0D / var12, 2);
               this.formTransfertCompta.setVar_currentValue((int)var14);
            }

            if (this.formTransfertCompta.getTransfertCompta().getTrfReference1() != null && !this.formTransfertCompta.getTransfertCompta().getTrfReference1().isEmpty()) {
               Boolean var17 = false;

               for(int var11 = 0; var11 < var1.size(); ++var11) {
                  if (((Ecritures)var1.get(var11)).getEcrReference1() != null && !((Ecritures)var1.get(var11)).getEcrReference1().isEmpty() && ((Ecritures)var1.get(var11)).getEcrReference1().equals(this.formTransfertCompta.getTransfertCompta().getTrfReference1())) {
                     var17 = true;
                     break;
                  }
               }

               if (!var17) {
                  var2.add(this.formTransfertCompta.getTransfertCompta());
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
      this.formTransfertCompta.getLesTransfertCompta().clear();

      for(int var16 = 0; var16 < var2.size(); ++var16) {
         this.formTransfertCompta.getLesTransfertCompta().add(var2.get(var16));
      }

      this.formTransfertCompta.getDataModelTransfertCompta().setWrappedData(this.formTransfertCompta.getLesTransfertCompta());
      this.formTransfertCompta.calculTotalDebCred();
      this.formTransfertCompta.setVar_showBarProg(false);
      if (this.formTransfertCompta.getLesTransfertCompta().size() == 0) {
         this.var_verif_transfert = false;
      }

   }

   public void calculerLesDecoupagesActivites() throws HibernateException, NamingException {
      if (this.decoupageActivite && this.laColonne1Items.size() == 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Activites");
         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            this.laColonne1Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode1(), var1);
         }

         if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
            this.laColonne2Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode2(), var1);
         }

         if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
            this.laColonne3Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode3(), var1);
         }

         this.utilInitHibernate.closeSession();
      }

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
         if (this.formTransfertCompta.getTransfertErreur().getTrfDebitSaisie() != 0.0D && this.formTransfertCompta.getTransfertErreur().getTrfCreditSaisie() == 0.0D) {
            var1 = Math.abs(this.formTransfertCompta.getTransfertErreur().getTrfDebitSaisie());
         } else {
            var1 = Math.abs(this.formTransfertCompta.getTransfertErreur().getTrfCreditSaisie());
         }

         double var3 = this.utilNombre.myRoundDevise(var1 * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
         this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(var3);
      }

   }

   public void controleEcartAnalytique() {
      if (this.lesDecoupagesActivites.size() != 0) {
         this.totalImputation = 0.0D;
         this.soldeImputation = 0.0D;

         for(int var1 = 0; var1 < this.lesDecoupagesActivites.size(); ++var1) {
            this.totalImputation += ((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var1)).getEcranaMontantSaisie();
         }

         double var3 = 0.0D;
         if (this.formTransfertCompta.getTransfertErreur().getTrfDebitSaisie() != 0.0D && this.formTransfertCompta.getTransfertErreur().getTrfCreditSaisie() == 0.0D) {
            var3 = Math.abs(this.formTransfertCompta.getTransfertErreur().getTrfDebitSaisie());
         } else {
            var3 = Math.abs(this.formTransfertCompta.getTransfertErreur().getTrfCreditSaisie());
         }

         this.soldeImputation = var3 - this.totalImputation;
         if (this.soldeImputation > 0.0D) {
            this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
            this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         }
      }

   }

   public void recherchePlanComptable() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.formTransfertCompta.getTransfertCompta().getTrfCompte() != null && !this.formTransfertCompta.getTransfertCompta().getTrfCompte().isEmpty()) {
         this.planComptable = this.formRecherche.recherchePlanComptable(this.selecFiscalite, this.formTransfertCompta.getTransfertCompta().getTrfCompte(), 536, this.exercicesComptable, 0, this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
         if (this.planComptable != null) {
            if (this.planComptable.getPlcId() != 0L) {
               this.calculePlanComptable();
            } else {
               this.var_action = 10;
            }
         } else if (this.planComptable == null) {
            this.calculePlanComptable();
         }
      }

   }

   public void recherchePlanComptableErreur() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.formTransfertCompta.getTransfertErreur().getTrfCompte() != null && !this.formTransfertCompta.getTransfertErreur().getTrfCompte().isEmpty()) {
         this.planComptable = this.formRecherche.recherchePlanComptable(this.selecFiscalite, this.formTransfertCompta.getTransfertErreur().getTrfCompte(), 536, this.exercicesComptable, 0, this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
         if (this.planComptable != null) {
            if (this.planComptable.getPlcId() != 0L) {
               this.calculePlanComptable();
            } else {
               this.var_action = 10;
            }
         } else if (this.planComptable == null) {
            this.calculePlanComptable();
         }
      }

   }

   public void recuperationPlanComptable() throws JDOMException, IOException, HibernateException, NamingException {
      this.planComptable = this.formRecherche.calculePlanComptable();
      this.calculePlanComptable();
   }

   public void calculePlanComptable() throws JDOMException, IOException {
      if (this.planComptable != null) {
         if (this.formTransfertCompta.getTransfertCompta() != null) {
            this.formTransfertCompta.getTransfertCompta().setTrfCompte(this.planComptable.getPlcCompte());
         }

         if (this.formTransfertCompta.getTransfertErreur() != null) {
            this.formTransfertCompta.getTransfertErreur().setTrfCompte(this.planComptable.getPlcCompte());
         }
      } else {
         this.annulePlanComptable();
      }

      this.var_action = this.var_memo_action;
   }

   public void annulePlanComptable() {
      if (this.formTransfertCompta.getTransfertCompta() != null) {
         this.formTransfertCompta.getTransfertCompta().setTrfCompte("");
      }

      if (this.formTransfertCompta.getTransfertErreur() != null) {
         this.formTransfertCompta.getTransfertErreur().setTrfCompte("");
      }

      this.var_action = this.var_memo_action;
   }

   public void verifNumcompte(String var1, Date var2, Session var3) throws IOException, JDOMException, HibernateException, NamingException {
      if (var1 != null && !var1.isEmpty() && !var1.contains(":")) {
         this.planComptable = new PlanComptable();
         this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, var1, this.exercicesComptable.getExecpt_id(), var3);
         if (this.planComptable == null) {
            new Racines();
            Racines var4 = this.rechercheRacine(var1, var2, var3);
            PlanComptable var5 = new PlanComptable();
            var5.setExercicesComptable(this.exercicesComptable);
            var5.setPlcCompte(var1);
            var5.setPlcCodeRacine(var4.getRacCode());
            int var6;
            if (var4.getRacLibelleFr() != null && !var4.getRacLibelleFr().isEmpty()) {
               var6 = var4.getRacLibelleFr().length();
               if (var6 >= 99) {
                  var6 = 99;
               }

               var5.setPlcLibelleRacineFR(var4.getRacLibelleFr().substring(0, var6));
            }

            if (var4.getRacLibelleSp() != null && !var4.getRacLibelleSp().isEmpty()) {
               var6 = var4.getRacLibelleSp().length();
               if (var6 >= 99) {
                  var6 = 99;
               }

               var5.setPlcLibelleRacineSP(var4.getRacLibelleSp().substring(0, var6));
            }

            if (var4.getRacLibelleUk() != null && !var4.getRacLibelleUk().isEmpty()) {
               var6 = var4.getRacLibelleUk().length();
               if (var6 >= 99) {
                  var6 = 99;
               }

               var5.setPlcLibelleRacineUK(var4.getRacLibelleUk().substring(0, var6));
            }

            if (var4.getRacCodenature() == null || var4.getRacCodenature().isEmpty()) {
               var4.setRacCodenature("0");
            }

            var6 = Integer.parseInt(var4.getRacCodenature());
            var5.setPlcNature(var6);
            var5.setPlcLibelleNatureFR(var4.getRacnature());
            var5.setPlcLibre(this.calculPlcLibre(var1, var4.getRacCode()));
            var5.setPlcLibelleCpteFR("compte à creer");
            var5.setPlcLibelleCpteSP("compte à creer");
            var5.setPlcLibelleCpteUK("compte à creer");
            var5.setPlcUserCreat(this.usersLog.getUsrid());
            var5.setPlcDateCreat(new Date());
            this.planComptable = this.planComptableDao.insert(var5, var3);
            var3.flush();
         }
      }

   }

   public void verifNumcompte(String var1, String var2, Date var3, String var4, Session var5) throws IOException, JDOMException, HibernateException, NamingException {
      if (var1 != null && !var1.isEmpty() && !var1.contains(":")) {
         if (var2 != null && !var2.isEmpty()) {
            this.planComptable = new PlanComptable();
            this.planComptable = this.planComptableDao.chercherCompteSage(this.selecFiscalite, var1, var2, this.exercicesComptable.getExecpt_id(), var5);
            if (this.planComptable != null) {
               var1 = this.planComptable.getPlcCompte();
            }
         }

         this.planComptable = new PlanComptable();
         this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, var1, this.exercicesComptable.getExecpt_id(), var5);
         Racines var6;
         if (this.planComptable == null) {
            new Racines();
            var6 = this.rechercheRacine(var1, var3, var5);
            PlanComptable var7 = new PlanComptable();
            var7.setExercicesComptable(this.exercicesComptable);
            var7.setPlcCompte(var1);
            var7.setPlcSage(var2);
            var7.setPlcFiscalite(this.selecFiscalite);
            var7.setPlcCodeRacine(var6.getRacCode());
            int var8;
            if (var6.getRacLibelleFr() != null && !var6.getRacLibelleFr().isEmpty()) {
               var8 = var6.getRacLibelleFr().length();
               if (var8 >= 99) {
                  var8 = 99;
               }

               var7.setPlcLibelleRacineFR(var6.getRacLibelleFr().substring(0, var8));
            }

            if (var6.getRacLibelleSp() != null && !var6.getRacLibelleSp().isEmpty()) {
               var8 = var6.getRacLibelleSp().length();
               if (var8 >= 99) {
                  var8 = 99;
               }

               var7.setPlcLibelleRacineSP(var6.getRacLibelleSp().substring(0, var8));
            }

            if (var6.getRacLibelleUk() != null && !var6.getRacLibelleUk().isEmpty()) {
               var8 = var6.getRacLibelleUk().length();
               if (var8 >= 99) {
                  var8 = 99;
               }

               var7.setPlcLibelleRacineUK(var6.getRacLibelleUk().substring(0, var8));
            }

            if (var6.getRacCodenature() == null || var6.getRacCodenature().isEmpty()) {
               var6.setRacCodenature("0");
            }

            var8 = Integer.parseInt(var6.getRacCodenature());
            var7.setPlcNature(var8);
            var7.setPlcLibelleNatureFR(var6.getRacnature());
            var7.setPlcLibre(this.calculPlcLibre(var1, var6.getRacCode()));
            var7.setPlcLibelleCpteFR(var4);
            var7.setPlcLibelleCpteSP("compte à creer");
            var7.setPlcLibelleCpteUK("compte à creer");
            var7.setPlcUserCreat(this.usersLog.getUsrid());
            var7.setPlcDateCreat(new Date());
            this.planComptable = this.planComptableDao.insert(var7, var5);
            var5.flush();
         } else {
            new Racines();
            var6 = this.rechercheRacine(var1, var3, var5);
            this.planComptable.setExercicesComptable(this.exercicesComptable);
            this.planComptable.setPlcCompte(var1);
            this.planComptable.setPlcSage(var2);
            this.planComptable.setPlcFiscalite(this.selecFiscalite);
            this.planComptable.setPlcCodeRacine(var6.getRacCode());
            int var9;
            if (var6.getRacLibelleFr() != null && !var6.getRacLibelleFr().isEmpty()) {
               var9 = var6.getRacLibelleFr().length();
               if (var9 >= 99) {
                  var9 = 99;
               }

               this.planComptable.setPlcLibelleRacineFR(var6.getRacLibelleFr().substring(0, var9));
            }

            if (var6.getRacLibelleSp() != null && !var6.getRacLibelleSp().isEmpty()) {
               var9 = var6.getRacLibelleSp().length();
               if (var9 >= 99) {
                  var9 = 99;
               }

               this.planComptable.setPlcLibelleRacineSP(var6.getRacLibelleSp().substring(0, var9));
            }

            if (var6.getRacLibelleUk() != null && !var6.getRacLibelleUk().isEmpty()) {
               var9 = var6.getRacLibelleUk().length();
               if (var9 >= 99) {
                  var9 = 99;
               }

               this.planComptable.setPlcLibelleRacineUK(var6.getRacLibelleUk().substring(0, var9));
            }

            if (var6.getRacCodenature() == null || var6.getRacCodenature().isEmpty()) {
               var6.setRacCodenature("0");
            }

            var9 = Integer.parseInt(var6.getRacCodenature());
            this.planComptable.setPlcNature(var9);
            this.planComptable.setPlcLibelleNatureFR(var6.getRacnature());
            this.planComptable.setPlcLibre(this.calculPlcLibre(var1, var6.getRacCode()));
            this.planComptable.setPlcLibelleCpteFR(var4);
            this.planComptable.setPlcLibelleCpteSP("compte à creer");
            this.planComptable.setPlcLibelleCpteUK("compte à creer");
            this.planComptable.setPlcUserCreat(this.usersLog.getUsrid());
            this.planComptable.setPlcDateCreat(new Date());
            this.planComptable = this.planComptableDao.modif(this.planComptable, var5);
            var5.flush();
         }
      }

   }

   public void verifLieu(String var1, Session var2) throws IOException, JDOMException, HibernateException, NamingException {
      if (var1 != null && !var1.isEmpty() && !var1.contains(":")) {
         new LocalisationImmobilisation();
         LocalisationImmobilisationDao var4 = new LocalisationImmobilisationDao(this.baseLog, this.utilInitHibernate);
         LocalisationImmobilisation var3 = var4.chargeLieu(var1, var2);
         if (var3 == null) {
            var3 = new LocalisationImmobilisation();
            var3.setLocimmDateCreat(new Date());
            var3.setLocimmDateModif((Date)null);
            var3.setLocimmInactif(0);
            var3.setLocimmLatitude(0L);
            var3.setLocimmLongitude(0L);
            int var5 = var1.length();
            if (var5 >= 99) {
               var5 = 99;
            }

            var3.setLocimmNomFr(var1.substring(0, var5));
            var3.setLocimmNomSp("");
            var3.setLocimmNomUk("");
            var3.setLocimmUserCreat(this.usersLog.getUsrid());
            var3.setLocimmUserModif(0L);
            var4.insert(var3, var2);
         }
      }

   }

   public void verifTiers(String var1, String var2, Date var3, String var4, Tiers var5, Session var6) throws HibernateException, NamingException {
      if (var2 != null && !var2.isEmpty() && var1 != null && !var1.isEmpty()) {
         var5 = this.tiersDao.chargerTiersByCompteSage(var2, var6);
         if (var5 == null) {
            var5 = new Tiers();
            var5.setTieraisonsocialenom(var4);
            var5.setTiecompte0(var1);
            var5.setTiecompteSage(var2);
            var5.setTienompays(this.structureLog.getStrnompays());
            var5.setTiecodepays(this.structureLog.getStrcodepays());
            var5.setTiedevise(this.structureLog.getStrdevise());
            var5.setTieFormatDevise(this.structureLog.getStrformatdevise());
            var5.setTielangue("Français");
            var5.setTiedatecreat(new Date());
            var5.setTieusercreat(this.usersLog.getUsrid());
            if (var1.startsWith("40")) {
               var5.setTietype("0");
               var5.setTiegenre("001");
               var5.setTiecategorie("Fournisseur");
               var5.setTiecivilite("Autre");
               this.tiersDao.insert(var5, var6);
               var6.flush();
            } else if (var1.startsWith("41")) {
               var5.setTietype("3");
               var5.setTiegenre("031");
               var5.setTiecategorie("Client Société");
               var5.setTiecivilite("Autre");
               this.tiersDao.insert(var5, var6);
               var6.flush();
            }
         } else {
            var5.setTiecompte0(var1);
            this.tiersDao.modif(var5, var6);
            var6.flush();
         }
      } else if (var1 != null && !var1.isEmpty()) {
         var5 = this.tiersDao.chargerTiersByCompte(var1, var6);
         if (var5 == null) {
            var5 = new Tiers();
            var5.setTieraisonsocialenom(var4);
            var5.setTiecompte0(var1);
            var5.setTiecompteSage(var2);
            var5.setTienompays(this.structureLog.getStrnompays());
            var5.setTiecodepays(this.structureLog.getStrcodepays());
            var5.setTiedevise(this.structureLog.getStrdevise());
            var5.setTieFormatDevise(this.structureLog.getStrformatdevise());
            var5.setTielangue("Français");
            var5.setTiedatecreat(new Date());
            var5.setTieusercreat(this.usersLog.getUsrid());
            if (var1.startsWith("40")) {
               var5.setTietype("0");
               var5.setTiegenre("001");
               var5.setTiecategorie("Fournisseur");
               var5.setTiecivilite("Autre");
               this.tiersDao.insert(var5, var6);
               var6.flush();
            } else if (var1.startsWith("41")) {
               var5.setTietype("3");
               var5.setTiegenre("031");
               var5.setTiecategorie("Client Société");
               var5.setTiecivilite("Autre");
               this.tiersDao.insert(var5, var6);
               var6.flush();
            }
         }
      }

   }

   public Racines rechercheRacine(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      Racines var4 = new Racines();
      int var5 = var1.length();
      String var6 = "";
      int var7 = 0;

      for(int var8 = var5; var8 != 1; --var8) {
         ++var7;
         var6 = var1.substring(0, var5 - var7);
         if (var2 == null) {
            var2 = this.exercicesComptable.getExecptDateDebut();
         }

         this.selecFiscalite = this.structureLog.getStrzonefiscale();
         if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.structureLog.getStrdatefiscale2() != null && var2.compareTo(this.structureLog.getStrdatefiscale2()) >= 0) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale2();
         }

         var4 = this.racinesDao.rechercherCodeRacine(this.selecFiscalite, var6, var3);
         if (var4 != null) {
            break;
         }
      }

      if (var4 == null) {
         var4 = new Racines();
         var4.setRacCode("99999");
         var4.setRacLibelleFr("Racine Inconnue");
         var4.setRacLibelleSp("Unknown root");
         var4.setRacLibelleSp("Racina incognita");
      }

      return var4;
   }

   public String calculPlcLibre(String var1, String var2) {
      String var3 = null;
      int var4 = var2.length();
      var3 = var1.substring(var4);
      return var3;
   }

   public void verifJournal(String var1, String var2, int var3, String var4, Session var5) throws IOException, JDOMException, HibernateException, NamingException {
      this.journauxComptables = new JournauxComptables();
      this.journauxComptables = this.journauxComptablesDao.chercherCode(var1, this.exercicesComptable.getExecpt_id(), var5);
      if (this.journauxComptables == null) {
         this.journauxComptables = new JournauxComptables();
         this.journauxComptables.setExercice(this.exercicesComptable);
         if (var1.equals("AM")) {
            this.journauxComptables.setPljNature(5);
            this.journauxComptables.setPljLibelleFr("AMORTISSEMENTS");
         } else if (var1.equals("LOY")) {
            this.journauxComptables.setPljNature(4);
            this.journauxComptables.setPljLibelleFr("LOYERS");
         } else {
            this.journauxComptables.setPljNature(0);
            this.journauxComptables.setPljLibelleFr("Journal à créer");
         }

         this.journauxComptables.setPljCode(var1);
         this.journauxComptables.setPljChoixDevise(this.structureLog.getStrdevise());
         this.journauxComptables.setPljFormatDevise(this.structureLog.getStrformatdevise());
         this.journauxComptables.setPljLibelleSp("Journal à créer");
         this.journauxComptables.setPljLibelleUk("Journal à créer");
         if (var3 != 99) {
            this.journauxComptables.setPljNature(var3);
            this.journauxComptables.setPljPiece(2);
            this.journauxComptables.setPljLibelleFr(var4);
            if (var2 != null && !var2.isEmpty()) {
               this.journauxComptables.setPljCompteTreso(var2);
            } else {
               this.journauxComptables.setPljCompteTreso((String)null);
            }
         }

         this.journauxComptables.setPljUserCreat(this.usersLog.getUsrid());
         this.journauxComptables.setPljDateCreat(new Date());
         this.journauxComptablesDao.insert(this.journauxComptables, var5);
         var5.flush();
      } else if (var3 != 99) {
         this.journauxComptables.setPljNature(var3);
         this.journauxComptables.setPljPiece(2);
         this.journauxComptables.setPljLibelleFr(var4);
         if (var2 != null && !var2.isEmpty()) {
            this.journauxComptables.setPljCompteTreso(var2);
         } else {
            this.journauxComptables.setPljCompteTreso((String)null);
         }

         this.journauxComptables.setPljUserModif(this.usersLog.getUsrid());
         this.journauxComptables.setPljDateModif(new Date());
         this.journauxComptablesDao.modif(this.journauxComptables, var5);
         var5.flush();
      }

   }

   public void verifAnalytique() throws HibernateException, NamingException {
      this.formTransfertCompta.setVar_info("Verification des analytiques en cours...");
      if (this.optionComptabilite.getAnalytique().equalsIgnoreCase("true") && this.formTransfertCompta.getLesTransfertCompta().size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         int var3;
         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            var3 = 0;

            while(true) {
               if (var3 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
                  var2.commit();
                  break;
               }

               this.formTransfertCompta.setTransfertCompta((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var3));
               if (this.formTransfertCompta.getTransfertCompta().getTrfSite() != null && !this.formTransfertCompta.getTransfertCompta().getTrfSite().isEmpty()) {
                  this.verifSite(this.formTransfertCompta.getTransfertCompta().getTrfSite(), var1);
               }

               ++var3;
            }
         } catch (HibernateException var154) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var154;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            var3 = 0;

            while(true) {
               if (var3 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
                  var2.commit();
                  break;
               }

               this.formTransfertCompta.setTransfertCompta((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var3));
               if (this.formTransfertCompta.getTransfertCompta().getTrfDepartement() != null && !this.formTransfertCompta.getTransfertCompta().getTrfDepartement().isEmpty()) {
                  this.verifDepartement(this.formTransfertCompta.getTransfertCompta().getTrfSite(), this.formTransfertCompta.getTransfertCompta().getTrfDepartement(), var1);
               }

               ++var3;
            }
         } catch (HibernateException var152) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var152;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(var3 = 0; var3 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var3) {
               this.formTransfertCompta.setTransfertCompta((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var3));
               if (this.formTransfertCompta.getTransfertCompta().getTrfService() != null && !this.formTransfertCompta.getTransfertCompta().getTrfService().isEmpty()) {
                  this.verifService(this.formTransfertCompta.getTransfertCompta().getTrfSite(), this.formTransfertCompta.getTransfertCompta().getTrfDepartement(), this.formTransfertCompta.getTransfertCompta().getTrfService(), var1);
               }
            }

            var2.commit();
         } catch (HibernateException var150) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var150;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            var3 = 0;

            while(true) {
               if (var3 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
                  var2.commit();
                  break;
               }

               this.formTransfertCompta.setTransfertCompta((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var3));
               if ((this.formTransfertCompta.getTransfertCompta().getTrfTypeImport() == null || this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().isEmpty() || this.formTransfertCompta.getTransfertCompta().getTrfTypeImport() != null && !this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().isEmpty() && this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().equals("SPC-ELEVE") && this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().equals("SPC-VACAT")) && this.formTransfertCompta.getTransfertCompta().getTrfRegion() != null && !this.formTransfertCompta.getTransfertCompta().getTrfRegion().isEmpty()) {
                  this.verifRegion(this.formTransfertCompta.getTransfertCompta().getTrfRegion(), var1);
               }

               ++var3;
            }
         } catch (HibernateException var148) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var148;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            var3 = 0;

            while(true) {
               if (var3 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
                  var2.commit();
                  break;
               }

               this.formTransfertCompta.setTransfertCompta((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var3));
               if ((this.formTransfertCompta.getTransfertCompta().getTrfTypeImport() == null || this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().isEmpty() || this.formTransfertCompta.getTransfertCompta().getTrfTypeImport() != null && !this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().isEmpty() && this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().equals("SPC-ELEVE") && this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().equals("SPC-VACAT")) && this.formTransfertCompta.getTransfertCompta().getTrfSecteur() != null && !this.formTransfertCompta.getTransfertCompta().getTrfSecteur().isEmpty()) {
                  this.verifSecteur(this.formTransfertCompta.getTransfertCompta().getTrfRegion(), this.formTransfertCompta.getTransfertCompta().getTrfSecteur(), var1);
               }

               ++var3;
            }
         } catch (HibernateException var146) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var146;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(var3 = 0; var3 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var3) {
               this.formTransfertCompta.setTransfertCompta((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var3));
               if ((this.formTransfertCompta.getTransfertCompta().getTrfTypeImport() == null || this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().isEmpty() || this.formTransfertCompta.getTransfertCompta().getTrfTypeImport() != null && !this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().isEmpty() && this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().equals("SPC-ELEVE") && this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().equals("SPC-VACAT")) && this.formTransfertCompta.getTransfertCompta().getTrfPdv() != null && !this.formTransfertCompta.getTransfertCompta().getTrfPdv().isEmpty()) {
                  this.verifPDV(this.formTransfertCompta.getTransfertCompta().getTrfRegion(), this.formTransfertCompta.getTransfertCompta().getTrfSecteur(), this.formTransfertCompta.getTransfertCompta().getTrfPdv(), var1);
               }
            }

            var2.commit();
         } catch (HibernateException var144) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var144;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(var3 = 0; var3 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var3) {
               this.formTransfertCompta.setTransfertCompta((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var3));
               if ((this.formTransfertCompta.getTransfertCompta().getTrfTypeImport() == null || this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().isEmpty() || this.formTransfertCompta.getTransfertCompta().getTrfTypeImport() != null && !this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().isEmpty() && !this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().equals("SPC-ELEVE") && !this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().equals("SPC-VACAT")) && this.formTransfertCompta.getTransfertCompta().getTrfParc() != null && !this.formTransfertCompta.getTransfertCompta().getTrfParc().isEmpty()) {
                  this.verifParc(this.formTransfertCompta.getTransfertCompta().getTrfParc(), var1);
               }
            }

            var2.commit();
         } catch (HibernateException var142) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var142;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(var3 = 0; var3 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var3) {
               this.formTransfertCompta.setTransfertCompta((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var3));
               if ((this.formTransfertCompta.getTransfertCompta().getTrfTypeImport() == null || this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().isEmpty() || this.formTransfertCompta.getTransfertCompta().getTrfTypeImport() != null && !this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().isEmpty() && !this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().equals("SPC-ELEVE") && !this.formTransfertCompta.getTransfertCompta().getTrfTypeImport().equals("SPC-VACAT")) && this.formTransfertCompta.getTransfertCompta().getTrfDossier() != null && !this.formTransfertCompta.getTransfertCompta().getTrfDossier().isEmpty()) {
                  this.verifDossier(this.formTransfertCompta.getTransfertCompta().getTrfDossier(), this.formTransfertCompta.getTransfertCompta().getTrfLibelle(), this.formTransfertCompta.getTransfertCompta().getTrfDateSaisie(), var1);
               }
            }

            var2.commit();
         } catch (HibernateException var140) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var140;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public Site verifSite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Site var4 = new Site();
      if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         String var5 = "";
         if (var1.contains(":")) {
            String[] var6 = var1.split(":");
            var5 = var6[0];
         } else {
            var5 = var1;
         }

         var3 = this.siteDao.existCode(var5, var2);
         if (!var3) {
            var4 = new Site();
            var4.setSitCode(var5);
            var4.setSitNomFr("site à creer");
            var4.setSitNomUk("site à creer");
            var4.setSitNomSp("site à creer");
            var4.setSitInactif(0);
            var4.setSitDateCreat(new Date());
            var4.setSitUserCreat(this.usersLog.getUsrid());
            var4 = this.siteDao.insert(var4, var2);
         } else {
            var4 = this.siteDao.rechercheSite(var1, var2);
         }

         var2.flush();
      }

      return var4;
   }

   public Departement verifDepartement(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      Departement var5 = new Departement();
      if (var1 != null && !var1.isEmpty() && !var1.equals("0") && var2 != null && !var2.isEmpty() && !var2.equals("0")) {
         String var6 = "";
         if (var2.contains(":")) {
            String[] var7 = var2.split(":");
            var6 = var7[0];
         } else {
            var6 = var2;
         }

         var4 = this.departementDao.existCode(var6, var3);
         if (!var4) {
            new Site();
            String var8 = "";
            if (var2.contains(":")) {
               String[] var9 = var2.split(":");
               var8 = var9[0];
            } else {
               var8 = var2;
            }

            Site var10 = this.verifSite(var8, var3);
            if (var10 != null) {
               var5 = new Departement();
               var5.setDepCode(var6);
               var5.setSite(var10);
               var5.setDepNomFr("departement à creer");
               var5.setDepNomUk("departement à creer");
               var5.setDepNomSp("departement à creer");
               var5.setDepDateCreat(new Date());
               var5.setDepUserCreat(this.usersLog.getUsrid());
               var5 = this.departementDao.insert(var5, var3);
            }
         } else {
            var5 = this.departementDao.rechercheDepartement(var2, var3);
         }

         var3.flush();
      }

      return var5;
   }

   public void verifService(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      new Service();
      if (var3 != null && !var3.isEmpty() && !var3.equals("0") && var2 != null && !var2.isEmpty() && !var2.equals("0") && var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         String var7 = "";
         if (var3.contains(":")) {
            String[] var8 = var3.split(":");
            var7 = var8[0];
         } else {
            var7 = var3;
         }

         var5 = this.serviceDao.existCode(var7, var4);
         if (!var5) {
            new Site();
            String var9 = "";
            if (var1.contains(":")) {
               String[] var10 = var1.split(":");
               var9 = var10[0];
            } else {
               var9 = var1;
            }

            Site var13 = this.verifSite(var9, var4);
            if (var13 != null) {
               new Departement();
               String var11 = "";
               if (var2.contains(":")) {
                  String[] var12 = var2.split(":");
                  var11 = var12[0];
               } else {
                  var11 = var2;
               }

               Departement var14 = this.verifDepartement(var9, var11, var4);
               if (var14 != null) {
                  Service var6 = new Service();
                  var6.setSerCode(var3);
                  var6.setSite(var13);
                  var6.setDepartement(var14);
                  var6.setSerNomFr("service à creer");
                  var6.setSerNomUk("service à creer");
                  var6.setSerNomSp("service à creer");
                  var6.setSerInactif(0);
                  var6.setSerDateCreat(new Date());
                  var6.setSerUserCreat(this.usersLog.getUsrid());
                  this.serviceDao.insert(var6, var4);
                  var4.flush();
               }
            }
         }
      }

   }

   public Region verifRegion(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Region var4 = new Region();
      if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         String var5 = "";
         if (var1.contains(":")) {
            String[] var6 = var1.split(":");
            var5 = var6[0];
         } else {
            var5 = var1;
         }

         var3 = this.regionDao.existCode(var5, var2);
         if (!var3) {
            var4 = new Region();
            var4.setRegCode(var5);
            var4.setRegNomFr("region à creer");
            var4.setRegNomSp("region à creer");
            var4.setRegNomUk("region à creer");
            var4.setRegInactif(0);
            var4.setRegDateCreat(new Date());
            var4.setRegUserCreat(this.usersLog.getUsrid());
            var4 = this.regionDao.insert(var4, var2);
         } else {
            var4 = this.regionDao.rechercheRegion(var5, var2);
         }

         var2.flush();
      }

      return var4;
   }

   public Secteur verifSecteur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      Secteur var5 = new Secteur();
      if (var1 != null && !var1.isEmpty() && !var1.equals("0") && var2 != null && !var2.isEmpty() && !var2.equals("0")) {
         String var6 = "";
         if (var2.contains(":")) {
            String[] var7 = var2.split(":");
            var6 = var7[0];
         } else {
            var6 = var2;
         }

         var4 = this.secteurDao.existCode(var6, var3);
         if (!var4) {
            new Region();
            String var8 = "";
            if (var1.contains(":")) {
               String[] var9 = var1.split(":");
               var8 = var9[0];
            } else {
               var8 = var1;
            }

            Region var10 = this.verifRegion(var8, var3);
            if (var10 != null) {
               var5 = new Secteur();
               var5.setRegion(var10);
               var5.setSecCode(var6);
               var5.setSecNomFr("secteur à creer");
               var5.setSecNomUk("secteur à creer");
               var5.setSecNomSp("secteur à creer");
               var5.setSecDateCreat(new Date());
               var5.setSecUserCreat(this.usersLog.getUsrid());
               var5 = this.secteurDao.insert(var5);
            }
         } else {
            var5 = this.secteurDao.rechercheSecteur(var2, var3);
         }

         var3.flush();
      }

      return var5;
   }

   public void verifPDV(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var1 != null && !var1.isEmpty() && !var1.equals("0") && var2 != null && !var2.isEmpty() && !var2.equals("0") && var3 != null && !var3.isEmpty() && !var3.equals("0")) {
         var5 = this.pointDeVenteDao.existCode(var3, var4);
         if (!var5) {
            new Region();
            String var7 = "";
            if (var1.contains(":")) {
               String[] var8 = var1.split(":");
               var7 = var8[0];
            } else {
               var7 = var1;
            }

            Region var6 = this.verifRegion(var7, var4);
            if (var6 != null) {
               new Secteur();
               String var9 = "";
               if (var2.contains(":")) {
                  String[] var10 = var2.split(":");
                  var9 = var10[0];
               } else {
                  var9 = var1;
               }

               Secteur var11 = this.verifSecteur(var7, var9, var4);
               if (var11 != null) {
                  PointDeVente var12 = new PointDeVente();
                  var12.setRegion(var6);
                  var12.setSecteur(var11);
                  var12.setPdvCode(var3);
                  var12.setPdvNomFr("pdv à creer");
                  var12.setPdvNomUk("pdv à creer");
                  var12.setPdvNomSp("pdv à creer");
                  var12.setPdvDateCreat(new Date());
                  var12.setPdvUserCreat(this.usersLog.getUsrid());
                  this.pointDeVenteDao.insert(var12);
                  var4.flush();
               }
            }
         }
      }

   }

   public ProductionLigne verifLigne(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      ProductionLigne var5 = new ProductionLigne();
      if (var1 != null && !var1.isEmpty() && !var1.equals("0") && var2 != null && !var2.isEmpty() && !var2.equals("0")) {
         ProductionLigneDao var6 = new ProductionLigneDao(this.baseLog, this.utilInitHibernate);
         var4 = var6.existCode(var2, var3);
         if (!var4) {
            new Site();
            Site var7 = this.verifSite(var1, var3);
            if (var7 != null) {
               var5 = new ProductionLigne();
               var5.setSite(var7);
               var5.setLigCode(var2);
               var5.setLigNomFr("ligne à creer");
               var5.setLigNomUk("ligne à creer");
               var5.setLigNomSp("ligne à creer");
               var5.setLigDateCreat(new Date());
               var5.setLigUserCreat(this.usersLog.getUsrid());
               var5 = var6.insert(var5);
            }
         } else {
            var5 = var6.rechercheProductionLigne(var2, var3);
         }

         var3.flush();
      }

      return var5;
   }

   public void verifAtelier(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var1 != null && !var1.isEmpty() && !var1.equals("0") && var2 != null && !var2.isEmpty() && !var2.equals("0") && var3 != null && !var3.isEmpty() && !var3.equals("0")) {
         ProductionAtelierDao var6 = new ProductionAtelierDao(this.baseLog, this.utilInitHibernate);
         var5 = var6.existCode(var3, var4);
         if (!var5) {
            new Site();
            Site var7 = this.verifSite(var1, var4);
            if (var7 != null) {
               new ProductionLigne();
               ProductionLigne var8 = this.verifLigne(var1, var2, var4);
               if (var8 != null) {
                  ProductionAtelier var9 = new ProductionAtelier();
                  var9.setSite(var7);
                  var9.setProductionLigne(var8);
                  var9.setAteCode(var3);
                  var9.setAteNomFr("pdv à creer");
                  var9.setAteNomSp("pdv à creer");
                  var9.setAteNomUk("pdv à creer");
                  var9.setAteDateCreat(new Date());
                  var9.setAteUserCreat(this.usersLog.getUsrid());
                  var6.insert(var9);
                  var4.flush();
               }
            }
         }
      }

   }

   public boolean verifAnal2(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         String var4 = "";
         if (var1.contains(":")) {
            String[] var5 = var1.split(":");
            var4 = var5[0];
         } else {
            var4 = var1;
         }

         var3 = this.analytiqueDao.existCode("2", var4, var2);
         if (!var3) {
            PlansAnalytiques var6 = new PlansAnalytiques();
            var6.setAnaDateCreat(new Date());
            var6.setAnaUserCreat(this.usersLog.getUsrid());
            var6.setAnaNature("2");
            var6.setAnaCode(var4);
            var6.setAnaNomFr("analytique 2 à creer");
            var6.setAnaNomSp("analytique 2 à creer");
            var6.setAnaNomUk("analytique 2 à creer");
            this.analytiqueDao.insert(var6, var2);
            var2.flush();
            var3 = true;
         }
      }

      return var3;
   }

   public boolean verifAnal4(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         String var4 = "";
         if (var1.contains(":")) {
            String[] var5 = var1.split(":");
            var4 = var5[0];
         } else {
            var4 = var1;
         }

         var3 = this.analytiqueDao.existCode("4", var4, var2);
         if (!var3) {
            PlansAnalytiques var6 = new PlansAnalytiques();
            var6.setAnaDateCreat(new Date());
            var6.setAnaUserCreat(this.usersLog.getUsrid());
            var6.setAnaNature("4");
            var6.setAnaCode(var4);
            var6.setAnaNomFr("analytique 4 à creer");
            var6.setAnaNomSp("analytique 4 à creer");
            var6.setAnaNomUk("analytique 4 à creer");
            this.analytiqueDao.insert(var6, var2);
            var2.flush();
            var3 = true;
         }
      }

      return var3;
   }

   public boolean verifParc(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         String var4 = "";
         if (var1.contains(":")) {
            String[] var5 = var1.split(":");
            var4 = var5[0];
         } else {
            var4 = var1;
         }

         var3 = this.parcDao.existCode(var4, var2);
         if (!var3) {
            Parc var6 = new Parc();
            var6.setPrcDateCreat(new Date());
            var6.setPrcUserCreat(this.usersLog.getUsrid());
            var6.setPrcImmatriculation(var4);
            var6.setPrcNomFr("parc à creer");
            this.parcDao.insert(var6, var2);
            var2.flush();
            var3 = true;
         }
      }

      return var3;
   }

   public boolean verifAgent(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         var3 = true;
      }

      return var3;
   }

   public boolean verifDossier(String var1, String var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         if (var1.length() >= 19) {
            var1 = var1.substring(0, 19);
         }

         String var6 = "";
         if (var1.contains(":")) {
            String[] var7 = var1.split(":");
            var6 = var7[0];
         } else {
            var6 = var1;
         }

         var5 = this.analytiqueDao.existCode("6", var6, var4);
         if (!var5) {
            PlansAnalytiques var8 = new PlansAnalytiques();
            var8.setAnaDateCreat(new Date());
            var8.setAnaUserCreat(this.usersLog.getUsrid());
            var8.setAnaNature("6");
            var8.setAnaCode(var6);
            var8.setAnaNomFr(var2);
            var8.setAnaNomSp("dossier à creer");
            var8.setAnaNomUk("dossier à creer");
            if (var3 != null) {
               var8.setAnaAnnee("" + (var3.getYear() + 1900));
            } else {
               var8.setAnaAnnee((String)null);
            }

            this.analytiqueDao.insert(var8, var4);
            var4.flush();
            var5 = true;
         }
      }

      return var5;
   }

   public boolean verifChantier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         String var4 = "";
         if (var1.contains(":")) {
            String[] var5 = var1.split(":");
            var4 = var5[0];
         } else {
            var4 = var1;
         }

         var3 = this.analytiqueDao.existCode("7", var4, var2);
         if (!var3) {
            PlansAnalytiques var6 = new PlansAnalytiques();
            var6.setAnaDateCreat(new Date());
            var6.setAnaUserCreat(this.usersLog.getUsrid());
            var6.setAnaNature("7");
            var6.setAnaCode(var4);
            var6.setAnaNomFr("chantier à creer");
            var6.setAnaNomSp("chantier à creer");
            var6.setAnaNomUk("chantier à creer");
            this.analytiqueDao.insert(var6, var2);
            var2.flush();
            var3 = true;
         }
      }

      return var3;
   }

   public boolean verifMission(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         String var4 = "";
         if (var1.contains(":")) {
            String[] var5 = var1.split(":");
            var4 = var5[0];
         } else {
            var4 = var1;
         }

         var3 = this.analytiqueDao.existCode("8", var4, var2);
         if (!var3) {
            PlansAnalytiques var6 = new PlansAnalytiques();
            var6.setAnaDateCreat(new Date());
            var6.setAnaUserCreat(this.usersLog.getUsrid());
            var6.setAnaNature("8");
            var6.setAnaCode(var4);
            var6.setAnaNomFr("mission à creer");
            var6.setAnaNomSp("mission à creer");
            var6.setAnaNomUk("mission à creer");
            this.analytiqueDao.insert(var6, var2);
            var2.flush();
            var3 = true;
         }
      }

      return var3;
   }

   public boolean verifProjet(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         String var4 = "";
         if (var1.contains(":")) {
            String[] var5 = var1.split(":");
            var4 = var5[0];
         } else {
            var4 = var1;
         }

         var3 = this.projetsDao.existCode(0, var4);
         if (!var3) {
            Projets var6 = new Projets();
            var6.setProDateCreat(new Date());
            var6.setProUserCreat(this.usersLog.getUsrid());
            var6.setProCode(var4);
            var6.setProNomFR("projet à creer");
            var6.setProNomUK("projet à creer");
            var6.setProNomSP("projet à creer");
            var6.setProDescription("description du projet");
            var6.setProDateDebut(this.datedefin);
            var6.setProDateFin(this.datedefin);
            var6.setProInactif(0);
            this.projetsDao.insert(var6, var2);
            var2.flush();
            var3 = true;
         }
      }

      return var3;
   }

   public boolean verifBudget(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
         String var4 = "";
         if (var1.contains(":")) {
            String[] var5 = var1.split(":");
            var4 = var5[0];
         } else {
            var4 = var1;
         }

         var3 = this.plansBudgetairesDao.existCode(0, var4, "0", this.exercicesComptable.getExecpt_id(), var2);
         if (!var3) {
            PlansBudgetaires var6 = new PlansBudgetaires();
            var6.setPlbUserCreat(this.usersLog.getUsrid());
            var6.setPlbDateCreat(new Date());
            var6.setPlbCode(var4);
            var6.setPlbLibelleFr("Budget à creer ");
            var6.setPlbLibelleUk("Budget à creer ");
            var6.setPlbLibelleSp("Budget à creer ");
            var6.setPlbInactif(0);
            this.plansBudgetairesDao.insert(var6, var2);
            var2.flush();
            var3 = true;
         }
      }

      return var3;
   }

   public boolean verifActivite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (!this.decoupageActivite) {
         if (var1 != null && !var1.isEmpty() && !var1.equals("0")) {
            String var4 = "";
            if (var1.contains(":")) {
               String[] var5 = var1.split(":");
               var4 = var5[0];
            } else {
               var4 = var1;
            }

            var3 = this.activitesDao.existCode(var4, var2);
            if (!var3) {
               Activites var6 = new Activites();
               var6.setActDateCreat(new Date());
               var6.setActCode(var4);
               var6.setActNomFr("activite  à creer");
               var6.setActNomUk("activite  à creer");
               var6.setActNomSp("activite  à creer");
               var6.setActInactif(0);
               this.activitesDao.insert(var6, var2);
               var2.flush();
               var3 = true;
            }
         }
      } else {
         var3 = true;
      }

      return var3;
   }

   public void analyseCle(String var1, Ecritures var2, Session var3) throws HibernateException, NamingException {
      String var4 = "" + (var2.getEcrDateSaisie().getYear() + 1900);
      new PlansAnalytiques();
      PlansAnalytiquesDao var6 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      ArrayList var7 = new ArrayList();
      new ArrayList();
      List var8 = var6.selectAnal("9", var1, var4, this.nature, var3);
      if (var8.size() != 0) {
         PlansAnalytiques var5 = (PlansAnalytiques)var8.get(0);
         int var9 = var5.getAnaNatureRepartition();
         if (var9 != 0) {
            double var10 = 0.0D;
            if (var2.getEcrDebitSaisie() != 0.0D && var2.getEcrCreditSaisie() == 0.0D) {
               var10 = var2.getEcrDebitSaisie();
            } else {
               var10 = var2.getEcrCreditSaisie();
            }

            this.affiche_activite = false;
            this.affiche_site = false;
            this.affiche_departement = false;
            this.affiche_service = false;
            this.affiche_region = false;
            this.affiche_secteur = false;
            this.affiche_pdv = false;
            this.affiche_sitePrdv = false;
            this.affiche_ligne = false;
            this.affiche_atelier = false;
            this.affiche_parc = false;
            this.affiche_str = false;
            new ArrayList();
            PlanAnalytiqueRepartitionDao var13 = new PlanAnalytiqueRepartitionDao(this.baseLog, this.utilInitHibernate);
            List var12 = var13.chargerLesRepartitions(var5, var3);
            if (var12.size() != 0) {
               for(int var14 = 0; var14 < var12.size(); ++var14) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var15 = (PlanAnalytiqueRepartition)var12.get(var14);
                  this.verifActivite(var15.getCleCodeActivite(), var3);
                  EcrituresAnalytique var16 = new EcrituresAnalytique();
                  var16.setEcranaActivite(var15.getCleCodeActivite());
                  var16.setEcranaActiviteLib(var15.getCleLibelleActivite());
                  var16.setEcranaAxe(var9);
                  if (var9 == 30) {
                     var16.setEcranaSite(var15.getCleCodeSite());
                     var16.setEcranaSiteLib(var15.getCleLibelleSite());
                     var16.setEcranaLigne(var15.getCleCodeLigne());
                     var16.setEcranaLigneLib(var15.getCleLibelleLigne());
                     var16.setEcranaAtelier(var15.getCleCodeAtelier());
                     var16.setEcranaAtelierLib(var15.getCleLibelleAtelier());
                  } else {
                     var16.setEcranaSite(var15.getCleCodeSite());
                     var16.setEcranaSiteLib(var15.getCleLibelleSite());
                     var16.setEcranaDepartement(var15.getCleCodeDepartement());
                     var16.setEcranaDepartementLib(var15.getCleLibelleDepartement());
                     var16.setEcranaService(var15.getCleCodeService());
                     var16.setEcranaServiceLib(var15.getCleLibelleService());
                     var16.setEcranaRegion(var15.getCleCodeRegion());
                     var16.setEcranaRegionLib(var15.getCleLibelleRegion());
                     var16.setEcranaSecteur(var15.getCleCodeSecteur());
                     var16.setEcranaSecteurLib(var15.getCleLibelleSecteur());
                     var16.setEcranaPdv(var15.getCleCodePdv());
                     var16.setEcranaPdvLib(var15.getCleLibellePdv());
                     var16.setEcranaStr(var15.getCleSigleStr());
                     var16.setEcranaStrLib(var15.getCleNomStr());
                  }

                  var7.add(var16);
               }

               List var21 = this.miseEnFormeCle(var7);
               if (var21.size() != 0) {
                  double var22 = 0.0D;
                  if (var21.size() != 0) {
                     for(int var23 = 0; var23 < var21.size(); ++var23) {
                        var22 += ((EcrituresAnalytique)var21.get(var23)).getEcranaMontantSaisie();
                     }
                  }

                  double var10000 = var10 - var22;

                  for(int var18 = 0; var18 < var21.size(); ++var18) {
                     new EcrituresAnalytique();
                     EcrituresAnalytique var19 = (EcrituresAnalytique)var21.get(var18);
                     String var20 = var5.getAnaCode() + ":" + var5.getAnaNomFr();
                     this.ecrituresAnalytiquesDao.miseAJourAnalytiqueByEcriture(var20, var2, var21, var3);
                  }
               }
            }
         }
      }

   }

   public void analyseCleStructure(String var1, Ecritures var2, Session var3) throws HibernateException, NamingException {
      String var4 = "" + (var2.getEcrDateSaisie().getYear() + 1900);
      new PlansAnalytiques();
      PlansAnalytiquesDao var6 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ArrayList();
      List var8 = var6.selectAnalStructure("200", var1, var4, var3);
      if (var8.size() != 0) {
         PlansAnalytiques var5 = (PlansAnalytiques)var8.get(0);
         int var9 = var5.getAnaNatureRepartition();
         if (var9 != 0) {
            double var10 = 0.0D;
            if (var2.getEcrDebitSaisie() != 0.0D && var2.getEcrCreditSaisie() == 0.0D) {
               var10 = var2.getEcrDebitSaisie();
            } else {
               var10 = var2.getEcrCreditSaisie();
            }

            this.affiche_str = false;
            new ArrayList();
            PlanAnalytiqueRepartitionDao var13 = new PlanAnalytiqueRepartitionDao(this.baseLog, this.utilInitHibernate);
            List var12 = var13.chargerLesRepartitions(var5, var3);
            if (var12.size() != 0) {
               for(int var14 = 0; var14 < var12.size(); ++var14) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var15 = (PlanAnalytiqueRepartition)var12.get(var14);
                  this.verifActivite(var15.getCleCodeActivite(), var3);
                  EcrituresAnalytique var16 = new EcrituresAnalytique();
                  var16.setEcranaAxe(var9);
                  var16.setEcranaStr(var15.getCleSigleStr());
                  var16.setEcranaStrLib(var15.getCleNomStr());
               }
            }
         }
      }

   }

   public void analyseImputationDirecteSite(TransfertCompta var1, Ecritures var2, Session var3) throws HibernateException, NamingException {
      ArrayList var4 = new ArrayList();
      double var5 = 0.0D;
      if (var2.getEcrDebitSaisie() != 0.0D && var2.getEcrCreditSaisie() == 0.0D) {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrDebitSaisie()));
      } else {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrCreditSaisie()));
      }

      if (var5 != 0.0D) {
         EcrituresAnalytique var7 = new EcrituresAnalytique();
         var7.setEcritures(var2);
         var7.setEcranaSite(var1.getTrfSite());
         var7.setEcranaDepartement(var1.getTrfDepartement());
         var7.setEcranaService(var1.getTrfService());
         double var8 = 0.0D;
         if (var5 != 0.0D && var1.getTrfSite() != null && !var1.getTrfSite().isEmpty()) {
            new Site();
            Site var10 = this.siteDao.rechercheSite(var1.getTrfSite(), var3);
            if (var10 != null) {
               var7 = new EcrituresAnalytique();
               var7.setEcritures(var2);
               var7.setEcranaSite(var10.getSitCode());
               var7.setEcranaSiteLib(var10.getSitNomFr());
               if (var7.getEcranaPourcentage() == 0.0F) {
                  var7.setEcranaPourcentage(100.0F);
               }

               var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
               var7.setEcranaMontantSaisie(var8);
               if (var5 != 0.0D && var1.getTrfDepartement() != null && !var1.getTrfDepartement().isEmpty()) {
                  new Departement();
                  Departement var11 = this.departementDao.rechercheDepartement(var1.getTrfDepartement(), var3);
                  if (var11 != null) {
                     var7.setEcranaDepartement(var11.getDepCode());
                     var7.setEcranaDepartementLib(var11.getDepNomFr());
                     var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
                     var7.setEcranaMontantSaisie(var8);
                     if (var5 != 0.0D && var1.getTrfService() != null && !var1.getTrfService().isEmpty()) {
                        new Service();
                        Service var12 = this.serviceDao.rechercheService(var1.getTrfService(), var3);
                        if (var12 != null) {
                           var7.setEcranaService(var12.getSerCode());
                           var7.setEcranaServiceLib(var12.getSerNomFr());
                           var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
                           var7.setEcranaMontantSaisie(var8);
                        }
                     }
                  }
               }
            }
         }

         if (var1.getTrfSite() != null && !var1.getTrfSite().isEmpty()) {
            if (var7.getEcritures().getEcrDebitSaisie() != 0.0D && var7.getEcritures().getEcrCreditSaisie() == 0.0D) {
               if (var7.getEcritures().getEcrDebitSaisie() < 0.0D) {
                  var7.setEcranaSens(1);
               } else {
                  var7.setEcranaSens(0);
               }
            } else if (var7.getEcritures().getEcrCreditSaisie() < 0.0D) {
               var7.setEcranaSens(0);
            } else {
               var7.setEcranaSens(1);
            }

            var7.setEcranaAxe(100);
            var4.add(var7);
         }

         if (var4.size() != 0) {
            this.ecrituresAnalytiquesDao.miseAJourAnalytiqueByEcriture("", var2, var4, var3);
         }
      }

   }

   public void analyseImputationDirecteRegion(TransfertCompta var1, Ecritures var2, Session var3) throws HibernateException, NamingException {
      ArrayList var4 = new ArrayList();
      double var5 = 0.0D;
      if (var2.getEcrDebitSaisie() != 0.0D && var2.getEcrCreditSaisie() == 0.0D) {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrDebitSaisie()));
      } else {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrCreditSaisie()));
      }

      if (var5 != 0.0D) {
         EcrituresAnalytique var7 = new EcrituresAnalytique();
         var7.setEcritures(var2);
         var7.setEcranaRegion(var1.getTrfRegion());
         var7.setEcranaSecteur(var1.getTrfSecteur());
         var7.setEcranaPdv(var1.getTrfPdv());
         double var8 = 0.0D;
         if (var5 != 0.0D && var1.getTrfRegion() != null && !var1.getTrfRegion().isEmpty()) {
            new Region();
            Region var10 = this.regionDao.rechercheRegion(var1.getTrfRegion(), var3);
            if (var10 != null) {
               var7 = new EcrituresAnalytique();
               var7.setEcritures(var2);
               var7.setEcranaRegion(var10.getRegCode());
               var7.setEcranaRegionLib(var10.getRegNomFr());
               if (var7.getEcranaPourcentage() == 0.0F) {
                  var7.setEcranaPourcentage(100.0F);
               }

               var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
               var7.setEcranaMontantSaisie(var8);
               if (var5 != 0.0D && var1.getTrfSecteur() != null && !var1.getTrfSecteur().isEmpty()) {
                  new Secteur();
                  Secteur var11 = this.secteurDao.rechercheSecteur(var1.getTrfSecteur(), var3);
                  if (var11 != null) {
                     var7.setEcranaSecteur(var11.getSecCode());
                     var7.setEcranaSecteurLib(var11.getSecNomFr());
                     var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
                     var7.setEcranaMontantSaisie(var8);
                     if (var5 != 0.0D && var1.getTrfPdv() != null && !var1.getTrfPdv().isEmpty()) {
                        new PointDeVente();
                        PointDeVente var12 = this.pointDeVenteDao.recherchePdv(var1.getTrfPdv(), var3);
                        if (var12 != null) {
                           var7.setEcranaPdv(var12.getPdvCode());
                           var7.setEcranaPdvLib(var12.getPdvNomFr());
                           var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
                           var7.setEcranaMontantSaisie(var8);
                        }
                     }
                  }
               }
            }
         }

         if (var1.getTrfRegion() != null && !var1.getTrfRegion().isEmpty()) {
            if (var7.getEcritures().getEcrDebitSaisie() != 0.0D && var7.getEcritures().getEcrCreditSaisie() == 0.0D) {
               if (var7.getEcritures().getEcrDebitSaisie() < 0.0D) {
                  var7.setEcranaSens(1);
               } else {
                  var7.setEcranaSens(0);
               }
            } else if (var7.getEcritures().getEcrCreditSaisie() < 0.0D) {
               var7.setEcranaSens(0);
            } else {
               var7.setEcranaSens(1);
            }

            var7.setEcranaAxe(101);
            var4.add(var7);
         }

         if (var4.size() != 0) {
            this.ecrituresAnalytiquesDao.miseAJourAnalytiqueByEcriture("", var2, var4, var3);
         }
      }

   }

   public void analyseImputationDirecteProduction(TransfertCompta var1, Ecritures var2, Session var3) throws HibernateException, NamingException {
      ArrayList var4 = new ArrayList();
      double var5 = 0.0D;
      if (var2.getEcrDebitSaisie() != 0.0D && var2.getEcrCreditSaisie() == 0.0D) {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrDebitSaisie()));
      } else {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrCreditSaisie()));
      }

      if (var5 != 0.0D) {
         EcrituresAnalytique var7 = new EcrituresAnalytique();
         var7.setEcritures(var2);
         var7.setEcranaSite(var1.getTrfSite());
         var7.setEcranaLigne(var1.getTrfDepartement());
         var7.setEcranaAtelier(var1.getTrfService());
         double var8 = 0.0D;
         if (var5 != 0.0D && var1.getTrfSite() != null && !var1.getTrfSite().isEmpty()) {
            new Site();
            Site var10 = this.siteDao.rechercheSite(var1.getTrfSite(), var3);
            if (var10 != null) {
               var7 = new EcrituresAnalytique();
               var7.setEcritures(var2);
               var7.setEcranaSite(var10.getSitCode());
               var7.setEcranaSiteLib(var10.getSitNomFr());
               if (var7.getEcranaPourcentage() == 0.0F) {
                  var7.setEcranaPourcentage(100.0F);
               }

               var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
               var7.setEcranaMontantSaisie(var8);
               if (var5 != 0.0D && var1.getTrfLigne() != null && !var1.getTrfLigne().isEmpty()) {
                  new ProductionLigne();
                  ProductionLigneDao var12 = new ProductionLigneDao(this.baseLog, this.utilInitHibernate);
                  ProductionLigne var11 = var12.rechercheProductionLigne(var1.getTrfLigne(), var3);
                  if (var11 != null) {
                     var7.setEcranaLigne(var11.getLigCode());
                     var7.setEcranaLigneLib(var11.getLigNomFr());
                     var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
                     var7.setEcranaMontantSaisie(var8);
                     if (var5 != 0.0D && var1.getTrfAtelier() != null && !var1.getTrfAtelier().isEmpty()) {
                        new ProductionAtelier();
                        ProductionAtelierDao var14 = new ProductionAtelierDao(this.baseLog, this.utilInitHibernate);
                        ProductionAtelier var13 = var14.rechercheProductionAtelier(var1.getTrfAtelier(), var3);
                        if (var13 != null) {
                           var7.setEcranaAtelier(var13.getAteCode());
                           var7.setEcranaAtelierLib(var13.getAteNomFr());
                           var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
                           var7.setEcranaMontantSaisie(var8);
                        }
                     }
                  }
               }
            }
         }

         if (var1.getTrfSite() != null && !var1.getTrfSite().isEmpty()) {
            if (var7.getEcritures().getEcrDebitSaisie() != 0.0D && var7.getEcritures().getEcrCreditSaisie() == 0.0D) {
               if (var7.getEcritures().getEcrDebitSaisie() < 0.0D) {
                  var7.setEcranaSens(1);
               } else {
                  var7.setEcranaSens(0);
               }
            } else if (var7.getEcritures().getEcrCreditSaisie() < 0.0D) {
               var7.setEcranaSens(0);
            } else {
               var7.setEcranaSens(1);
            }

            var7.setEcranaAxe(102);
            var4.add(var7);
         }

         if (var4.size() != 0) {
            this.ecrituresAnalytiquesDao.miseAJourAnalytiqueByEcriture("", var2, var4, var3);
         }
      }

   }

   public void analyseImputationDirecteActivite(TransfertCompta var1, Ecritures var2, Session var3) throws HibernateException, NamingException {
      ArrayList var4 = new ArrayList();
      double var5 = 0.0D;
      if (var2.getEcrDebitSaisie() != 0.0D && var2.getEcrCreditSaisie() == 0.0D) {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrDebitSaisie()));
      } else {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrCreditSaisie()));
      }

      if (var5 != 0.0D) {
         EcrituresAnalytique var7 = new EcrituresAnalytique();
         var7.setEcritures(var2);
         var7.setEcranaActivite(var1.getTrfActivite());
         double var8 = 0.0D;
         String var10 = var7.getEcranaActivite();
         if (!this.decoupageActivite && !var10.contains(":")) {
            if (var5 != 0.0D && var1.getTrfActivite() != null && !var1.getTrfActivite().isEmpty()) {
               new Activites();
               Activites var14 = this.activitesDao.rechercheActivite(var1.getTrfActivite(), var3);
               if (var14 != null) {
                  var7 = new EcrituresAnalytique();
                  var7.setEcritures(var2);
                  var7.setEcranaActivite(var14.getActCode());
                  var7.setEcranaActiviteLib(var14.getActNomFr());
                  if (var7.getEcranaPourcentage() == 0.0F) {
                     var7.setEcranaPourcentage(100.0F);
                  }

                  var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
                  var7.setEcranaMontantSaisie(var8);
                  if (var7.getEcritures().getEcrDebitSaisie() != 0.0D && var7.getEcritures().getEcrCreditSaisie() == 0.0D) {
                     if (var7.getEcritures().getEcrDebitSaisie() < 0.0D) {
                        var7.setEcranaSens(1);
                     } else {
                        var7.setEcranaSens(0);
                     }
                  } else if (var7.getEcritures().getEcrCreditSaisie() < 0.0D) {
                     var7.setEcranaSens(0);
                  } else {
                     var7.setEcranaSens(1);
                  }

                  var7.setEcranaAxe(110);
                  var4.add(var7);
                  this.ecrituresAnalytiquesDao.miseAJourAnalytiqueByEcriture("", var2, var4, var3);
               }
            }
         } else if (var10 != null && !var10.isEmpty() && var10.contains(":")) {
            String[] var11 = null;
            if (!var10.contains("#")) {
               var11 = var10.split(":");
               var7 = new EcrituresAnalytique();
               var7.setEcritures(var2);
               if (var11.length == 3) {
                  var7.setEcranaActivite(var11[0]);
                  Activites var15;
                  if (var7.getEcranaActivite().equals("null")) {
                     var7.setEcranaActivite("");
                     var7.setEcranaActiviteLib("");
                  } else {
                     new Activites();
                     var15 = this.activitesDao.rechercheActivite(var11[0], var3);
                     if (var15 != null) {
                        var7.setEcranaActiviteLib(var15.getActNomFr());
                     }
                  }

                  var7.setEcranaAnal1(var11[1]);
                  if (var7.getEcranaAnal1().equals("null")) {
                     var7.setEcranaAnal1("");
                     var7.setEcranaAnal1Lib("");
                  } else {
                     new Activites();
                     var15 = this.activitesDao.rechercheActivite(var11[1], var3);
                     if (var15 != null) {
                        var7.setEcranaAnal1Lib(var15.getActNomFr());
                     }
                  }

                  var7.setEcranaAnal3(var11[2]);
                  if (var7.getEcranaAnal3().equals("null")) {
                     var7.setEcranaAnal3("");
                     var7.setEcranaAnal3Lib("");
                  } else {
                     new Activites();
                     var15 = this.activitesDao.rechercheActivite(var11[2], var3);
                     if (var15 != null) {
                        var7.setEcranaAnal3Lib(var15.getActNomFr());
                     }
                  }

                  var7.setEcranaPourcentage(100.0F);
                  var7.setEcranaMontantSaisie(var5);
               } else {
                  var7.setEcranaActivite(var11[0]);
                  if (var7.getEcranaActivite().equals("null")) {
                     var7.setEcranaActivite("");
                  }

                  var7.setEcranaActiviteLib(var11[1]);
                  if (var7.getEcranaActiviteLib().equals("null")) {
                     var7.setEcranaActiviteLib("");
                  }

                  var7.setEcranaAnal1(var11[2]);
                  if (var7.getEcranaAnal1().equals("null")) {
                     var7.setEcranaAnal1("");
                  }

                  var7.setEcranaAnal1Lib(var11[3]);
                  if (var7.getEcranaAnal1Lib().equals("null")) {
                     var7.setEcranaAnal1Lib("");
                  }

                  var7.setEcranaAnal3(var11[4]);
                  if (var7.getEcranaAnal3().equals("null")) {
                     var7.setEcranaAnal3("");
                  }

                  var7.setEcranaAnal3Lib(var11[5]);
                  if (var7.getEcranaAnal3Lib().equals("null")) {
                     var7.setEcranaAnal3Lib("");
                  }

                  var7.setEcranaPourcentage(Float.parseFloat(var11[6]));
                  if (var11.length == 8) {
                     var7.setEcranaMontantSaisie(Double.parseDouble(var11[7]));
                  } else {
                     var7.setEcranaMontantSaisie(0.0D);
                  }
               }

               var7.setEcranaAxe(110);
               var7.setEcranaCle((String)null);
               var7.setEcranaCle1((String)null);
               var7.setEcranaCle2((String)null);
               var4.add(var7);
            } else {
               String[] var12 = var10.split("#");

               for(int var13 = 0; var13 < var12.length; ++var13) {
                  var11 = var12[var13].split(":");
                  var7 = new EcrituresAnalytique();
                  var7.setEcritures(var2);
                  var7.setEcranaActivite(var11[0]);
                  if (var7.getEcranaActivite().equals("null")) {
                     var7.setEcranaActivite("");
                  }

                  var7.setEcranaActiviteLib(var11[1]);
                  if (var7.getEcranaActiviteLib().equals("null")) {
                     var7.setEcranaActiviteLib("");
                  }

                  var7.setEcranaAnal1(var11[2]);
                  if (var7.getEcranaAnal1().equals("null")) {
                     var7.setEcranaAnal1("");
                  }

                  var7.setEcranaAnal1Lib(var11[3]);
                  if (var7.getEcranaAnal1Lib().equals("null")) {
                     var7.setEcranaAnal1Lib("");
                  }

                  var7.setEcranaAnal3(var11[4]);
                  if (var7.getEcranaAnal3().equals("null")) {
                     var7.setEcranaAnal3("");
                  }

                  var7.setEcranaAnal3Lib(var11[5]);
                  if (var7.getEcranaAnal3Lib().equals("null")) {
                     var7.setEcranaAnal3Lib("");
                  }

                  var7.setEcranaPourcentage(Float.parseFloat(var11[6]));
                  if (var11.length == 8) {
                     var7.setEcranaMontantSaisie(Double.parseDouble(var11[7]));
                  } else {
                     var7.setEcranaMontantSaisie(0.0D);
                  }

                  var7.setEcranaAxe(110);
                  var7.setEcranaCle((String)null);
                  var7.setEcranaCle1((String)null);
                  var7.setEcranaCle2((String)null);
                  var4.add(var7);
               }
            }

            this.ecrituresAnalytiquesDao.miseAJourAnalytiqueByEcriture("", var2, var4, var3);
         }
      }

   }

   public void analyseImputationDirecteParc(String var1, double var2, TransfertCompta var4, Ecritures var5, Session var6) throws HibernateException, NamingException {
      ArrayList var7 = new ArrayList();
      if (var2 != 0.0D) {
         EcrituresAnalytique var8 = new EcrituresAnalytique();
         var8.setEcritures(var5);
         double var9 = 0.0D;
         if (var2 != 0.0D && var1 != null && !var1.isEmpty()) {
            new Parc();
            Parc var11 = this.parcDao.rechercheParc(var1, var6);
            if (var11 != null) {
               var8 = new EcrituresAnalytique();
               var8.setEcritures(var5);
               if (var11.getPrcImmatriculation() != null && !var11.getPrcImmatriculation().isEmpty()) {
                  var8.setEcranaAnal2(var11.getPrcImmatriculation());
               } else {
                  var8.setEcranaAnal2(var1);
               }

               var8.setEcranaAnal2Lib(var11.getLibelleParc());
               double var12 = Math.abs(var8.getEcritures().getEcrDebitSaisie() + var8.getEcritures().getEcrCreditSaisie());
               float var14 = (float)(Math.abs(var2) / var12 * 100.0D);
               var8.setEcranaPourcentage(var14);
               var9 = this.utilNombre.myRoundFormat(var2, this.pljFormatDevise);
               var8.setEcranaMontantSaisie(var9);
               if (var8.getEcritures().getEcrDebitSaisie() != 0.0D && var8.getEcritures().getEcrCreditSaisie() == 0.0D) {
                  if (var8.getEcritures().getEcrDebitSaisie() < 0.0D) {
                     var8.setEcranaSens(1);
                  } else {
                     var8.setEcranaSens(0);
                  }
               } else if (var8.getEcritures().getEcrCreditSaisie() < 0.0D) {
                  var8.setEcranaSens(0);
               } else {
                  var8.setEcranaSens(1);
               }

               var8.setEcranaAxe(120);
               var7.add(var8);
               this.ecrituresAnalytiquesDao.miseAJourAnalytiqueByEcriture("", var5, var7, var6);
            }
         }
      }

   }

   public void analyseImputationDirecteDossier(TransfertCompta var1, Ecritures var2, Session var3) throws HibernateException, NamingException {
      ArrayList var4 = new ArrayList();
      double var5 = 0.0D;
      if (var2.getEcrDebitSaisie() != 0.0D && var2.getEcrCreditSaisie() == 0.0D) {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrDebitSaisie()));
      } else {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrCreditSaisie()));
      }

      if (var5 != 0.0D) {
         EcrituresAnalytique var7 = new EcrituresAnalytique();
         var7.setEcritures(var2);
         var7.setEcranaAnal4(var1.getTrfDossier());
         double var8 = 0.0D;
         if (var5 != 0.0D && var1.getTrfDossier() != null && !var1.getTrfDossier().isEmpty()) {
            new PlansAnalytiques();
            PlansAnalytiques var10 = this.analytiqueDao.rechercheAnal("6", var1.getTrfDossier(), var3);
            if (var10 != null) {
               var7 = new EcrituresAnalytique();
               var7.setEcritures(var2);
               var7.setEcranaAnal4(var10.getAnaCode());
               var7.setEcranaAnal4Lib(var10.getAnaNomFr());
               if (var7.getEcranaPourcentage() == 0.0F) {
                  var7.setEcranaPourcentage(100.0F);
               }

               var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
               var7.setEcranaMontantSaisie(var8);
               if (var7.getEcritures().getEcrDebitSaisie() != 0.0D && var7.getEcritures().getEcrCreditSaisie() == 0.0D) {
                  if (var7.getEcritures().getEcrDebitSaisie() < 0.0D) {
                     var7.setEcranaSens(1);
                  } else {
                     var7.setEcranaSens(0);
                  }
               } else if (var7.getEcritures().getEcrCreditSaisie() < 0.0D) {
                  var7.setEcranaSens(0);
               } else {
                  var7.setEcranaSens(1);
               }

               var7.setEcranaAxe(6);
               var4.add(var7);
               this.ecrituresAnalytiquesDao.miseAJourAnalytiqueByEcriture("", var2, var4, var3);
            }
         }
      }

   }

   public void analyseImputationDirecteChantier(TransfertCompta var1, Ecritures var2, Session var3) throws HibernateException, NamingException {
      ArrayList var4 = new ArrayList();
      double var5 = 0.0D;
      if (var2.getEcrDebitSaisie() != 0.0D && var2.getEcrCreditSaisie() == 0.0D) {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrDebitSaisie()));
      } else {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrCreditSaisie()));
      }

      if (var5 != 0.0D) {
         EcrituresAnalytique var7 = new EcrituresAnalytique();
         var7.setEcritures(var2);
         var7.setEcranaAnal1(var1.getTrfDossier());
         double var8 = 0.0D;
         if (var5 != 0.0D && var1.getTrfChantier() != null && !var1.getTrfChantier().isEmpty()) {
            new PlansAnalytiques();
            PlansAnalytiques var10 = this.analytiqueDao.rechercheAnal("7", var1.getTrfChantier(), var3);
            if (var10 != null) {
               var7 = new EcrituresAnalytique();
               var7.setEcritures(var2);
               var7.setEcranaAnal1(var10.getAnaCode());
               var7.setEcranaAnal1Lib(var10.getAnaNomFr());
               if (var7.getEcranaPourcentage() == 0.0F) {
                  var7.setEcranaPourcentage(100.0F);
               }

               var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
               var7.setEcranaMontantSaisie(var8);
               if (var7.getEcritures().getEcrDebitSaisie() != 0.0D && var7.getEcritures().getEcrCreditSaisie() == 0.0D) {
                  if (var7.getEcritures().getEcrDebitSaisie() < 0.0D) {
                     var7.setEcranaSens(1);
                  } else {
                     var7.setEcranaSens(0);
                  }
               } else if (var7.getEcritures().getEcrCreditSaisie() < 0.0D) {
                  var7.setEcranaSens(0);
               } else {
                  var7.setEcranaSens(1);
               }

               var7.setEcranaAxe(7);
               var4.add(var7);
               this.ecrituresAnalytiquesDao.miseAJourAnalytiqueByEcriture("", var2, var4, var3);
            }
         }
      }

   }

   public void analyseImputationDirecteMission(TransfertCompta var1, Ecritures var2, Session var3) throws HibernateException, NamingException {
      ArrayList var4 = new ArrayList();
      double var5 = 0.0D;
      if (var2.getEcrDebitSaisie() != 0.0D && var2.getEcrCreditSaisie() == 0.0D) {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrDebitSaisie()));
      } else {
         var5 = Math.abs(this.calculeNbDecimale(var2.getEcrCreditSaisie()));
      }

      if (var5 != 0.0D) {
         EcrituresAnalytique var7 = new EcrituresAnalytique();
         var7.setEcritures(var2);
         var7.setEcranaAnal3(var1.getTrfMission());
         double var8 = 0.0D;
         if (var5 != 0.0D && var1.getTrfMission() != null && !var1.getTrfMission().isEmpty()) {
            new PlansAnalytiques();
            PlansAnalytiques var10 = this.analytiqueDao.rechercheAnal("8", var1.getTrfMission(), var3);
            if (var10 != null) {
               var7 = new EcrituresAnalytique();
               var7.setEcritures(var2);
               var7.setEcranaAnal3(var10.getAnaCode());
               var7.setEcranaAnal3Lib(var10.getAnaNomFr());
               if (var7.getEcranaPourcentage() == 0.0F) {
                  var7.setEcranaPourcentage(100.0F);
               }

               var8 = this.utilNombre.myRoundFormat(var5 * (double)var7.getEcranaPourcentage() / 100.0D, this.pljFormatDevise);
               var7.setEcranaMontantSaisie(var8);
               if (var7.getEcritures().getEcrDebitSaisie() != 0.0D && var7.getEcritures().getEcrCreditSaisie() == 0.0D) {
                  if (var7.getEcritures().getEcrDebitSaisie() < 0.0D) {
                     var7.setEcranaSens(1);
                  } else {
                     var7.setEcranaSens(0);
                  }
               } else if (var7.getEcritures().getEcrCreditSaisie() < 0.0D) {
                  var7.setEcranaSens(0);
               } else {
                  var7.setEcranaSens(1);
               }

               var7.setEcranaAxe(8);
               var4.add(var7);
               this.ecrituresAnalytiquesDao.miseAJourAnalytiqueByEcriture("", var2, var4, var3);
            }
         }
      }

   }

   public void analyseImputationDirecteProjet(TransfertCompta var1, Ecritures var2, Session var3) throws HibernateException, NamingException {
   }

   public List miseEnFormeCle(List var1) {
      if (var1.size() != 0) {
         String var2 = "";
         String var3 = "";
         String var4 = "";
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         String var9 = "";
         String var10 = "";
         String var11 = "";
         String var12 = "";
         new EcrituresAnalytique();

         for(int var14 = 0; var14 < var1.size(); ++var14) {
            EcrituresAnalytique var13 = (EcrituresAnalytique)var1.get(var14);
            if (this.affiche_activite && !var2.equals(var13.getEcranaActivite())) {
               var2 = var13.getEcranaActivite();
            }

            if (this.affiche_site) {
               if (!var3.equals(var13.getEcranaSite())) {
                  var3 = var13.getEcranaSite();
               }

               if (this.affiche_departement) {
                  if (!var4.equals(var13.getEcranaDepartement())) {
                     var4 = var13.getEcranaDepartement();
                  }

                  if (this.affiche_service && !var5.equals(var13.getEcranaService())) {
                     var5 = var13.getEcranaService();
                  }
               }
            }

            if (this.affiche_region) {
               if (!var6.equals(var13.getEcranaRegion())) {
                  var6 = var13.getEcranaRegion();
               }

               if (this.affiche_secteur) {
                  if (!var7.equals(var13.getEcranaSecteur())) {
                     var7 = var13.getEcranaSecteur();
                  }

                  if (this.affiche_pdv && !var8.equals(var13.getEcranaPdv())) {
                     var8 = var13.getEcranaPdv();
                  }
               }
            }

            if (this.affiche_sitePrdv) {
               if (!var9.equals(var13.getEcranaSite())) {
                  var9 = var13.getEcranaSite();
               }

               if (this.affiche_ligne) {
                  if (!var10.equals(var13.getEcranaLigne())) {
                     var10 = var13.getEcranaLigne();
                  }

                  if (this.affiche_atelier && !var11.equals(var13.getEcranaAtelier())) {
                     var11 = var13.getEcranaAtelier();
                  }
               }
            }

            if (this.affiche_str && var13.getEcranaStr() != null && !var13.getEcranaStr().isEmpty() && !var12.equals(var13.getEcranaStr())) {
               var12 = var13.getEcranaStr();
            }
         }
      }

      return var1;
   }

   public JournauxMois recupererJournauxMois(String var1, Session var2) throws HibernateException, NamingException {
      new JournauxMois();
      JournauxMois var3 = this.journauxMoisDao.recupererJournauxMois(var1, this.exercicesComptable, var2);
      return var3;
   }

   public Brouillard genererBrouillard(Session var1, String var2, long var3, String var5, String var6, String var7, Date var8, String var9, String var10, String var11, double var12, double var14, long var16, String var18) throws HibernateException, NamingException {
      Brouillard var19 = new Brouillard();
      var19.setExercicescomptable(this.exercicesComptable);
      var19.setBroAnnee("" + this.exercicesComptable.getExecpt_id());
      var19.setBroDateCreat(new Date());
      var19.setBroUserCreat(this.usersLog.getUsrid());
      var19.setBroNumTrf(var2);
      var19.setBroIdOrigine(var3);
      var19.setBroTypeOrigine(var5);
      var19.setBroIdResponsable(var16);
      var19.setBroNomResponsable(var18);
      var19.setBroCode(var6);
      var19.setBroDateSaisie(var8);
      var19.setBroJour(var19.getBroDateSaisie().getDate());
      if (var9 != null && !var9.isEmpty() && var9.length() > 99) {
         String var20 = var9.substring(0, 99);
         var9 = var20;
      }

      var19.setBroLibelle(var9);
      var19.setBroPeriode(this.calculPeriode(var8));
      var19.setBroReference1(var10);
      var19.setBroReference2(var11);
      var19.setBroNum(this.brouillardDao.chercherDernierBrouillard(var6, var19.getBroPeriode(), this.usersLog.getUsrid(), this.exercicesComptable.getExecpt_id(), var1));
      var19.setBroPiece(var7);
      var19.setBroDebitSaisie(this.calculeNbDecimale(var12 + var14));
      var19.setBroCreditSaisie(this.calculeNbDecimale(var12 + var14));
      var19.setBroDeviseSaisie(this.structureLog.getStrdevise());
      var19.setBroCoefEuro(this.utilNombre.deviseTaux1(var19.getBroDeviseSaisie(), var19.getBroDateSaisie()));
      var19.setBroDebitEuro(this.utilNombre.myRoundFormat(var19.getBroDebitSaisie() * (double)var19.getBroCoefEuro(), 1));
      var19.setBroCreditEuro(this.utilNombre.myRoundFormat(var19.getBroCreditSaisie() * (double)var19.getBroCoefEuro(), 1));
      var19.setBroDevisePays(this.structureLog.getStrdevise());
      if (var19.getBroDevisePays().equalsIgnoreCase(var19.getBroDeviseSaisie())) {
         var19.setBroCoefPays(1.0F);
         var19.setBroDebitPays(var19.getBroDebitSaisie());
         var19.setBroCreditPays(var19.getBroCreditSaisie());
      } else {
         var19.setBroCoefPays(this.utilNombre.deviseTaux2(var19.getBroDevisePays(), var19.getBroDateSaisie()));
         var19.setBroDebitPays(this.utilNombre.myRoundDevise(var19.getBroDebitSaisie() * (double)var19.getBroCoefPays(), var19.getBroDevisePays()));
         var19.setBroCreditPays(this.utilNombre.myRoundDevise(var19.getBroCreditSaisie() * (double)var19.getBroCoefPays(), var19.getBroDevisePays()));
      }

      var19.setBroDeviseGrp(this.structureLog.getStrdevise());
      var19.setBroCoefGrp(1.0F);
      var19.setBroDebitGrp(var19.getBroDebitSaisie());
      var19.setBroCreditGrp(var19.getBroCreditSaisie());
      var19 = this.brouillardDao.insert(var19, var1);
      var1.flush();
      return var19;
   }

   public boolean testCompteAnalytique(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 != null && !var1.isEmpty()) {
         this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, var1, this.exercicesComptable.getExecpt_id(), var2);
         if (this.planComptable != null) {
            if (this.planComptable.getPlcNature() == 1) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c1());
            } else if (this.planComptable.getPlcNature() == 2) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c2());
            } else if (this.planComptable.getPlcNature() == 3) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c3());
            } else if (this.planComptable.getPlcNature() == 4) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c4());
            } else if (this.planComptable.getPlcNature() == 5) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c5());
            } else if (this.planComptable.getPlcNature() == 6) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c6());
            } else if (this.planComptable.getPlcNature() == 7) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c7());
            } else if (this.planComptable.getPlcNature() == 8) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c8());
            } else if (this.planComptable.getPlcNature() == 9) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c9());
            } else if (this.planComptable.getPlcNature() == 10) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c10());
            } else if (this.planComptable.getPlcNature() == 11) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c11());
            } else if (this.planComptable.getPlcNature() == 12) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c12());
            } else if (this.planComptable.getPlcNature() == 13) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c13());
            } else if (this.planComptable.getPlcNature() == 14) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c14());
            } else if (this.planComptable.getPlcNature() == 15) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c15());
            } else if (this.planComptable.getPlcNature() == 16) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c16());
            } else if (this.planComptable.getPlcNature() == 17) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c17());
            } else if (this.planComptable.getPlcNature() == 18) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c18());
            } else if (this.planComptable.getPlcNature() == 19) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c19());
            } else if (this.planComptable.getPlcNature() == 20) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c20());
            } else if (this.planComptable.getPlcNature() == 21) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c21());
            } else if (this.planComptable.getPlcNature() == 22) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c22());
            } else if (this.planComptable.getPlcNature() == 23) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c23());
            } else if (this.planComptable.getPlcNature() == 24) {
               var3 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c24());
            } else {
               var3 = false;
            }
         } else if (!var1.startsWith("6") && !var1.startsWith("7")) {
            var3 = false;
         } else {
            var3 = true;
         }
      }

      return var3;
   }

   public Ecritures genererEcriture(Session var1, Brouillard var2, String var3, long var4, String var6, String var7, String var8, String var9, Date var10, String var11, String var12, String var13, double var14, double var16, Date var18, String var19, String var20, String var21, String var22) throws HibernateException, NamingException {
      Ecritures var23 = new Ecritures();
      if (var2 != null) {
         var23.setBrouillard(var2);
      } else {
         var23.setBrouillard((Brouillard)null);
      }

      var23.setExercicesComptable(this.exercicesComptable);
      var23.setEcrDateCreat(new Date());
      var23.setEcrUserCreat(this.usersLog.getUsrid());
      var23.setEcrNumTrf(var3);
      var23.setEcrIdOrigine(var4);
      var23.setEcrTypeOrigine(var6);
      var23.setEcrEtat(0);
      var23.setEcrCode(var7);
      var23.setEcrDateSaisie(var10);
      var23.setEcrJour(var23.getEcrDateSaisie().getDate());
      int var24 = var23.getEcrDateSaisie().getYear() + 1900;
      var23.setEcrAnnee("" + var24);
      var23.setEcrCompte(var8);
      var23.setEcrLibCompte(this.planComptable.getPlcLibelleCpteFR());
      var23.setEcrClasse(var8.substring(0, 1));
      if (var11 != null && !var11.isEmpty() && var11.length() > 99) {
         String var25 = var11.substring(0, 99);
         var11 = var25;
      }

      var23.setEcrLibelle(var11);
      var23.setEcrNature(this.planComptable.getPlcNature());
      var23.setEcrNatureJrx(this.journauxComptables.getPljNature());
      var23.setEcrReserve(this.journauxComptables.getPljReserve());
      var23.setEcrPeriode(this.calculPeriode(var10));
      var23.setEcrReference1(var12);
      var23.setEcrReference2(var13);
      var23.setEcrPiece(var9);
      var23.setEcrLettrage(var20);
      var23.setEcrRapprochement(var21);
      var23.setEcrDebitSaisie(this.calculeNbDecimale(var14));
      var23.setEcrCreditSaisie(this.calculeNbDecimale(var16));
      var23.setEcrDeviseSaisie(this.structureLog.getStrdevise());
      var23.setEcrCoefEuro(this.utilNombre.deviseTaux1(var23.getEcrDeviseSaisie(), var23.getEcrDateSaisie()));
      var23.setEcrDebitEuro(this.utilNombre.myRoundFormat(var23.getEcrDebitSaisie() * (double)var23.getEcrCoefEuro(), 1));
      var23.setEcrCreditEuro(this.utilNombre.myRoundFormat(var23.getEcrCreditSaisie() * (double)var23.getEcrCoefEuro(), 1));
      var23.setEcrDevisePays(this.structureLog.getStrdevise());
      if (var23.getEcrDevisePays().equalsIgnoreCase(var23.getEcrDeviseSaisie())) {
         var23.setEcrCoefPays(1.0F);
         var23.setEcrDebitPays(var23.getEcrDebitSaisie());
         var23.setEcrCreditPays(var23.getEcrCreditSaisie());
      } else {
         var23.setEcrCoefPays(this.utilNombre.deviseTaux2(var23.getEcrDevisePays(), var23.getEcrDateSaisie()));
         var23.setEcrDebitPays(this.utilNombre.myRoundDevise(var23.getEcrDebitSaisie() * (double)var23.getEcrCoefPays(), var23.getEcrDevisePays()));
         var23.setEcrCreditPays(this.utilNombre.myRoundDevise(var23.getEcrCreditSaisie() * (double)var23.getEcrCoefPays(), var23.getEcrDevisePays()));
      }

      var23.setEcrDeviseGrp(this.structureLog.getStrdevise());
      var23.setEcrCoefGrp(1.0F);
      var23.setEcrDebitGrp(var23.getEcrDebitSaisie());
      var23.setEcrCreditGrp(var23.getEcrCreditSaisie());
      var23.setEcrDateEcheance(var18);
      var23.setEcrDateValeurTheo((Date)null);
      var23.setEcrTreso("");
      var23.setEcrCle1(this.calculCle1(var7, var10));
      var23.setEcrCle2(this.calculCle2(var7, var10));
      if (var22 != null && !var22.isEmpty() && var22.length() >= 19) {
         var22 = var22.substring(0, 19);
         var23.setEcrDossier(var22);
      } else {
         var23.setEcrDossier(var22);
      }

      boolean var27 = this.testCompteAnalytique(var8, var1);
      if (var27) {
         var23.setEcrAnaActif(1);
      } else {
         var23.setEcrAnaActif(0);
      }

      if (var19 != null && !var19.isEmpty()) {
         if (var19.contains(":")) {
            String[] var26 = var19.split(":");
            var23.setEcrBudgetTreso(var26[1]);
            var23.setEcrPosteTreso(var26[0]);
         } else {
            var23.setEcrBudgetTreso("");
            var23.setEcrPosteTreso(var19);
         }
      }

      var23 = this.ecrituresDao.insert(var23, var1);
      var1.flush();
      return var23;
   }

   public void genererMajJournauxMois() throws HibernateException, NamingException {
      if (this.formTransfertCompta.getLesTransfertCompta().size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            new JournauxMois();

            for(int var4 = 0; var4 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var4) {
               this.formTransfertCompta.setTransfertCompta((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var4));
               if (this.formTransfertCompta.getTransfertCompta().getTrfCode() != null && !this.formTransfertCompta.getTransfertCompta().getTrfCode().isEmpty() && this.formTransfertCompta.getTransfertCompta().getTrfDateSaisie() != null) {
                  String var5 = this.calculCle1(this.formTransfertCompta.getTransfertCompta().getTrfCode(), this.formTransfertCompta.getTransfertCompta().getTrfDateSaisie());
                  JournauxMois var3 = this.journauxMoisDao.recupererJournauxMois(var5, this.exercicesComptable, var1);
                  if (var3 != null && var3.getJoumenSaisie() == 0) {
                     var3.setJoumenSaisie(1);
                     this.journauxMoisDao.majJournal(var3, var1);
                     var1.flush();
                  }
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

   public String calculeJournalSerie(int var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      String var5 = "";
      this.chrono = this.chronoDao.chronoBySerieNat(var2, var1, var3, var4);
      if (this.chrono != null) {
         var5 = this.chrono.getChrJournal();
      }

      return var5;
   }

   public String calculeJournalSerieOD(int var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      String var5 = "";
      this.chrono = this.chronoDao.chronoBySerieNat(var2, var1, var3, var4);
      if (this.chrono != null) {
         var5 = this.chrono.getChrJournalOd();
      }

      return var5;
   }

   public String calculeJournal(int var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      this.chrono = this.chronoDao.chronoByNatAndJournalPeriode(var1, var2, var3, var4);
      if (this.chrono != null) {
         var2 = this.chrono.getChrJournal();
      }

      return var2;
   }

   public void calculeJournalTreso(String var1, ExercicesCaisse var2, String var3, Session var4) throws HibernateException, NamingException {
      this.journalCaisseEspece = "";
      this.journalCaisseCheque = "";
      this.journalCaisseViement = "";
      this.journalCaisseTraite = "";
      this.journalCaisseTpe = "";
      this.journalCaisseTransfert = "";
      this.journalCaisseePaiement = "";
      this.journalCaisseCredoc = "";
      this.journalCaisseFactor = "";
      this.journalCaisseCompense = "";
      this.journalCaisseTerme = "";
      this.caissesCommerciales = this.caissesCommercialesDao.selectCaisseByCode(var1, var2, var4);
      if (this.caissesCommerciales != null) {
         String var5 = this.caissesCommerciales.getCaiJrEspece();
         if (var5 != null && !var5.isEmpty()) {
            this.journalCaisseEspece = this.calculeJournal(53, var5, var3, var4);
         }

         String var6 = this.caissesCommerciales.getCaiJrCheque();
         if (var6 != null && !var6.isEmpty()) {
            this.journalCaisseCheque = this.calculeJournal(53, var6, var3, var4);
         }

         String var7 = this.caissesCommerciales.getCaiJrVirement();
         if (var7 != null && !var7.isEmpty()) {
            this.journalCaisseViement = this.calculeJournal(53, var7, var3, var4);
         }

         String var8 = this.caissesCommerciales.getCaiJrTraite();
         if (var8 != null && !var8.isEmpty()) {
            this.journalCaisseTraite = this.calculeJournal(53, var8, var3, var4);
         }

         String var9 = this.caissesCommerciales.getCaiJrTpe();
         if (var9 != null && !var9.isEmpty()) {
            this.journalCaisseTpe = this.calculeJournal(53, var9, var3, var4);
         }

         String var10 = this.caissesCommerciales.getCaiJrTransfert();
         if (var10 != null && !var10.isEmpty()) {
            this.journalCaisseTransfert = this.calculeJournal(53, var10, var3, var4);
         }

         String var11 = this.caissesCommerciales.getCaiJrePaiement();
         if (var11 != null && !var11.isEmpty()) {
            this.journalCaisseePaiement = this.calculeJournal(53, var11, var3, var4);
         }

         String var12 = this.caissesCommerciales.getCaiJrCredoc();
         if (var12 != null && !var12.isEmpty()) {
            this.journalCaisseCredoc = this.calculeJournal(53, var12, var3, var4);
         }

         String var13 = this.caissesCommerciales.getCaiJrFactor();
         if (var13 != null && !var13.isEmpty()) {
            this.journalCaisseFactor = this.calculeJournal(53, var13, var3, var4);
         }

         String var14 = this.caissesCommerciales.getCaiJrCompense();
         if (var14 != null && !var14.isEmpty()) {
            this.journalCaisseCompense = this.calculeJournal(53, var14, var3, var4);
         }

         String var15 = this.caissesCommerciales.getCaiJrTerme();
         if (var15 != null && !var15.isEmpty()) {
            this.journalCaisseTerme = this.calculeJournal(53, var15, var3, var4);
         }
      }

   }

   public String compteDefaut(String var1) {
      if (this.structureLog.getStrid() == 24L) {
         if (var1 != null && !var1.isEmpty()) {
            if (var1.contains("*")) {
               var1 = "47110000";
            }
         } else {
            var1 = "47110000";
         }
      }

      return var1;
   }

   public String calculeCompteCheque(String var1, ExercicesCaisse var2, Session var3) throws HibernateException, NamingException {
      String var4 = "";
      new CaissesCommerciales();
      CaissesCommerciales var5 = this.caissesCommercialesDao.selectCaisseByCode(var1, var2, var3);
      if (var5 != null) {
         var4 = var5.getCaiCompteEff();
      }

      if (var4 == null || var4.isEmpty()) {
         new CaissesCommerciales();
         var5 = this.caissesCommercialesDao.chercheCaisseByJournal(var2.getExecaiId(), var1, var3);
         if (var5 != null) {
            var4 = var5.getCaiCompteEff();
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         if (var4.contains(":")) {
            String[] var6 = var4.split(":");
            var4 = var6[0];
         }
      } else {
         var4 = "";
      }

      var4 = this.compteDefaut(var4);
      return var4;
   }

   public String calculeCompteVirtInterne(String var1, String var2, String var3, ExercicesCaisse var4, Session var5) throws HibernateException, NamingException {
      String var6 = "";
      new CaissesCommerciales();
      CaissesCommerciales var7 = this.caissesCommercialesDao.selectCaisseByCode(var1, var4, var5);
      if (var7 != null) {
         var6 = var7.getCaiCompteVrt();
      }

      if (var6 == null || var6.isEmpty()) {
         new CaissesCommerciales();
         var7 = this.caissesCommercialesDao.selectCaisseByCode(var2, var4, var5);
         if (var7 != null) {
            var6 = var7.getCaiCompteVrt();
         }
      }

      if (var6 == null || var6.isEmpty()) {
         new CaissesCommerciales();
         var7 = this.caissesCommercialesDao.selectCaisseByCode(var3, var4, var5);
         if (var7 != null) {
            var6 = var7.getCaiCompteVrt();
         }
      }

      if (var6 == null || var6.isEmpty()) {
         new CaissesCommerciales();
         var7 = this.caissesCommercialesDao.chercheCaisseByJournal(var4.getExecaiId(), var1, var5);
         if (var7 != null) {
            var6 = var7.getCaiCompteVrt();
         }
      }

      if (var6 == null || var6.isEmpty()) {
         new CaissesCommerciales();
         var7 = this.caissesCommercialesDao.chercheCaisseByJournal(var4.getExecaiId(), var2, var5);
         if (var7 != null) {
            var6 = var7.getCaiCompteVrt();
         }
      }

      if (var6 == null || var6.isEmpty()) {
         new CaissesCommerciales();
         var7 = this.caissesCommercialesDao.chercheCaisseByJournal(var4.getExecaiId(), var3, var5);
         if (var7 != null) {
            var6 = var7.getCaiCompteVrt();
         }
      }

      if (var6 != null && !var6.isEmpty()) {
         if (var6.contains(":")) {
            String[] var8 = var6.split(":");
            var6 = var8[0];
         }
      } else {
         var6 = "";
      }

      var6 = this.compteDefaut(var6);
      return var6;
   }

   public String calculeCompteProduitAchats(OptionAchats var1, String var2, String var3, long var4, String var6, List var7, Session var8) throws HibernateException, NamingException {
      String var9 = "";
      this.produits = null;
      String[] var10;
      if (var2 != null && !var2.isEmpty()) {
         this.produits = this.produitsAchsDao.chargeProduit(var2, var8);
         if (this.produits != null) {
            if (var1.getTrfCompta().equals("1")) {
               if (this.produits.getProAchCpteEc() != null && !this.produits.getProAchCpteEc().isEmpty()) {
                  if (this.produits.getProAchCpteEc().contains(":")) {
                     var10 = this.produits.getProAchCpteEc().split(":");
                     var9 = var10[0];
                  } else {
                     var9 = this.produits.getProAchCpteEc();
                  }
               }

               if (var9 == null || var9.isEmpty()) {
                  this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(var4, this.produits.getProAchCode(), var8);
                  if (this.famillesProduitsAchats != null && this.famillesProduitsAchats.getFamachCompteEncours() != null && !this.famillesProduitsAchats.getFamachCompteEncours().isEmpty()) {
                     if (this.famillesProduitsAchats.getFamachCompteEncours().contains(":")) {
                        var10 = this.famillesProduitsAchats.getFamachCompteEncours().split(":");
                        var9 = var10[0];
                     } else {
                        var9 = this.famillesProduitsAchats.getFamachCompteEncours();
                     }
                  }
               }
            }

            if (var9 == null || var9.isEmpty()) {
               var9 = this.calculeCompteProduitAchatsNormal(var2, var3, var4, var6, var7, var8);
            }
         }
      }

      if (var9 != null && !var9.isEmpty()) {
         if (var9.contains(":")) {
            var10 = var9.split(":");
            var9 = var10[0];
         }
      } else {
         var9 = "";
      }

      var9 = this.compteDefaut(var9);
      return var9;
   }

   public String calculeCompteProduitAchatsNormal(String var1, String var2, long var3, String var5, List var6, Session var7) throws HibernateException, NamingException {
      String var8 = "";
      this.produits = null;
      String[] var9;
      if (var1 != null && !var1.isEmpty()) {
         this.produits = this.produitsAchsDao.chargeProduit(var1, var7);
         if (this.produits != null) {
            if (var2 != null && !var2.isEmpty() && var2.equalsIgnoreCase(this.structureLog.getStrcodepays())) {
               if (this.produits.getProAchCpteLoc() != null && !this.produits.getProAchCpteLoc().isEmpty()) {
                  if (this.produits.getProAchCpteLoc().contains(":")) {
                     var9 = this.produits.getProAchCpteLoc().split(":");
                     var8 = var9[0];
                  } else {
                     var8 = this.produits.getProAchCpteLoc();
                  }
               }

               if (var8 == null || var8.isEmpty()) {
                  this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(var3, this.produits.getProAchCode(), var7);
                  if (this.famillesProduitsAchats != null && this.famillesProduitsAchats.getFamachCompteLocal() != null && !this.famillesProduitsAchats.getFamachCompteLocal().isEmpty()) {
                     if (this.famillesProduitsAchats.getFamachCompteLocal().contains(":")) {
                        var9 = this.famillesProduitsAchats.getFamachCompteLocal().split(":");
                        var8 = var9[0];
                     } else {
                        var8 = this.famillesProduitsAchats.getFamachCompteLocal();
                     }
                  }
               }
            } else if (this.structureLog.getStrzonefiscale() != null && !this.structureLog.getStrzonefiscale().isEmpty()) {
               boolean var11 = false;

               for(int var10 = 0; var10 < var6.size(); ++var10) {
                  this.objetPays = (ObjetPays)var6.get(var10);
                  if (this.objetPays.getFiscalite().equalsIgnoreCase(this.structureLog.getStrzonefiscale())) {
                     var11 = true;
                     break;
                  }
               }

               String[] var12;
               if (var11) {
                  if (this.produits.getProAchCpteZ() != null && !this.produits.getProAchCpteZ().isEmpty()) {
                     if (this.produits.getProAchCpteZ().contains(":")) {
                        var12 = this.produits.getProAchCpteZ().split(":");
                        var8 = var12[0];
                     } else {
                        var8 = this.produits.getProAchCpteZ();
                     }
                  }

                  if (var8 == null || var8.isEmpty()) {
                     this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(var3, this.produits.getProAchCode(), var7);
                     if (this.famillesProduitsAchats != null && this.famillesProduitsAchats.getFamachCompteZone() != null && !this.famillesProduitsAchats.getFamachCompteZone().isEmpty()) {
                        if (this.famillesProduitsAchats.getFamachCompteZone().contains(":")) {
                           var12 = this.famillesProduitsAchats.getFamachCompteZone().split(":");
                           var8 = var12[0];
                        } else {
                           var8 = this.famillesProduitsAchats.getFamachCompteZone();
                        }
                     }
                  }
               } else {
                  if (this.produits.getProVteCpteHz() != null && !this.produits.getProVteCpteHz().isEmpty()) {
                     if (this.produits.getProAchCpteHz().contains(":")) {
                        var12 = this.produits.getProAchCpteHz().split(":");
                        var8 = var12[0];
                     } else {
                        var8 = this.produits.getProAchCpteHz();
                     }
                  }

                  if (var8 == null || var8.isEmpty()) {
                     this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(var3, this.produits.getProAchCode(), var7);
                     if (this.famillesProduitsAchats != null && this.famillesProduitsAchats.getFamachCompteExterieur() != null && !this.famillesProduitsAchats.getFamachCompteExterieur().isEmpty()) {
                        if (this.famillesProduitsAchats.getFamachCompteExterieur().contains(":")) {
                           var12 = this.famillesProduitsAchats.getFamachCompteExterieur().split(":");
                           var8 = var12[0];
                        } else {
                           var8 = this.famillesProduitsVentes.getFamvteCompteExterieur();
                        }
                     }
                  }
               }
            } else {
               if (this.produits.getProAchCpteLoc() != null && !this.produits.getProAchCpteLoc().isEmpty()) {
                  if (this.produits.getProAchCpteLoc().contains(":")) {
                     var9 = this.produits.getProAchCpteLoc().split(":");
                     var8 = var9[0];
                  } else {
                     var8 = this.produits.getProAchCpteLoc();
                  }
               }

               if (var8 == null || var8.isEmpty()) {
                  this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(var3, this.produits.getProAchCode(), var7);
                  if (this.famillesProduitsAchats != null && this.famillesProduitsAchats.getFamachCompteLocal() != null && !this.famillesProduitsAchats.getFamachCompteLocal().isEmpty()) {
                     if (this.famillesProduitsAchats.getFamachCompteLocal().contains(":")) {
                        var9 = this.famillesProduitsAchats.getFamachCompteLocal().split(":");
                        var8 = var9[0];
                     } else {
                        var8 = this.famillesProduitsAchats.getFamachCompteLocal();
                     }
                  }
               }
            }
         }
      }

      if (var8 != null && !var8.isEmpty()) {
         if (var8.contains(":")) {
            var9 = var8.split(":");
            var8 = var9[0];
         }
      } else {
         var8 = "";
      }

      var8 = this.compteDefaut(var8);
      return var8;
   }

   public String calculeCompteTvaAchats(String var1, long var2, Session var4) throws HibernateException, NamingException {
      String var5 = "";
      String[] var6;
      if (var1 != null && !var1.isEmpty()) {
         this.taxesAchats = this.taxesAchatsDao.selectTva(var2, var1, var4);
         if (this.taxesAchats != null) {
            if (this.taxesAchats.getTaxachCompte() != null && !this.taxesAchats.getTaxachCompte().isEmpty() && this.taxesAchats.getTaxachCompte().contains(":")) {
               var6 = this.taxesAchats.getTaxachCompte().split(":");
               var5 = var6[0];
            } else {
               var5 = this.taxesAchats.getTaxachCompte();
            }
         }
      }

      if (var5 != null && !var5.isEmpty()) {
         if (var5.contains(":")) {
            var6 = var5.split(":");
            var5 = var6[0];
         }
      } else {
         var5 = "";
      }

      var5 = this.compteDefaut(var5);
      return var5;
   }

   public String calculeCompteProduitVentes(int var1, double var2, String var4, String var5, long var6, List var8, Session var9) throws HibernateException, NamingException {
      String var10 = "";
      if (var5 == null || var5.isEmpty()) {
         var5 = this.structureLog.getStrcodepays();
      }

      this.produits = null;
      this.famillesProduitsVentes = null;
      String[] var11;
      if (var4 != null && !var4.isEmpty()) {
         this.produits = this.produitsVtesDao.chargeProduit(var4, var9);
         if (this.produits != null) {
            if (var5 != null && !var5.isEmpty() && var5.equalsIgnoreCase(this.structureLog.getStrcodepays())) {
               if (var1 != 1 && var2 != 0.0D) {
                  if (this.produits.getProVteCpteCa() != null && !this.produits.getProVteCpteCa().isEmpty()) {
                     if (this.produits.getProVteCpteCa().contains(":")) {
                        var11 = this.produits.getProVteCpteCa().split(":");
                        var10 = var11[0];
                     } else {
                        var10 = this.produits.getProVteCpteCa();
                     }
                  } else if (this.produits.getProVteCpteLoc() != null && !this.produits.getProVteCpteLoc().isEmpty()) {
                     if (this.produits.getProVteCpteLoc().contains(":")) {
                        var11 = this.produits.getProVteCpteLoc().split(":");
                        var10 = var11[0];
                     } else {
                        var10 = this.produits.getProVteCpteLoc();
                     }
                  }

                  if (var10 == null || var10.isEmpty()) {
                     this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(var6, this.produits.getProVteCode(), var9);
                     if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCompteCaisse() != null && !this.famillesProduitsVentes.getFamvteCompteCaisse().isEmpty()) {
                        if (this.famillesProduitsVentes.getFamvteCompteCaisse().contains(":")) {
                           var11 = this.famillesProduitsVentes.getFamvteCompteCaisse().split(":");
                           var10 = var11[0];
                        } else {
                           var10 = this.famillesProduitsVentes.getFamvteCompteCaisse();
                        }
                     } else if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCompteLocal() != null && !this.famillesProduitsVentes.getFamvteCompteLocal().isEmpty()) {
                        if (this.famillesProduitsVentes.getFamvteCompteLocal().contains(":")) {
                           var11 = this.famillesProduitsVentes.getFamvteCompteLocal().split(":");
                           var10 = var11[0];
                        } else {
                           var10 = this.famillesProduitsVentes.getFamvteCompteLocal();
                        }
                     }
                  }
               } else {
                  if (this.produits.getProVteCpteCa() != null && !this.produits.getProVteCpteCa().isEmpty()) {
                     if (this.produits.getProVteCpteCa().contains(":")) {
                        var11 = this.produits.getProVteCpteCa().split(":");
                        var10 = var11[0];
                     } else {
                        var10 = this.produits.getProVteCpteCa();
                     }
                  } else if (this.produits.getProVteCpteNTx() != null && !this.produits.getProVteCpteNTx().isEmpty()) {
                     if (this.produits.getProVteCpteNTx().contains(":")) {
                        var11 = this.produits.getProVteCpteNTx().split(":");
                        var10 = var11[0];
                     } else {
                        var10 = this.produits.getProVteCpteNTx();
                     }
                  }

                  if (var10 == null || var10.isEmpty()) {
                     this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(var6, this.produits.getProVteCode(), var9);
                     if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCompteCaisse() != null && !this.famillesProduitsVentes.getFamvteCompteCaisse().isEmpty()) {
                        if (this.famillesProduitsVentes.getFamvteCompteCaisse().contains(":")) {
                           var11 = this.famillesProduitsVentes.getFamvteCompteCaisse().split(":");
                           var10 = var11[0];
                        } else {
                           var10 = this.famillesProduitsVentes.getFamvteCompteCaisse();
                        }
                     } else if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCompteNonTaxable() != null && !this.famillesProduitsVentes.getFamvteCompteNonTaxable().isEmpty()) {
                        if (this.famillesProduitsVentes.getFamvteCompteNonTaxable().contains(":")) {
                           var11 = this.famillesProduitsVentes.getFamvteCompteNonTaxable().split(":");
                           var10 = var11[0];
                        } else {
                           var10 = this.famillesProduitsVentes.getFamvteCompteNonTaxable();
                        }
                     }
                  }
               }
            } else if (this.structureLog.getStrzonefiscale() != null && !this.structureLog.getStrzonefiscale().isEmpty()) {
               boolean var13 = false;

               for(int var12 = 0; var12 < var8.size(); ++var12) {
                  this.objetPays = (ObjetPays)var8.get(var12);
                  if (this.objetPays.getFiscalite().equalsIgnoreCase(this.structureLog.getStrzonefiscale())) {
                     var13 = true;
                     break;
                  }
               }

               String[] var14;
               if (var13) {
                  if (this.produits.getProVteCpteCa() != null && !this.produits.getProVteCpteCa().isEmpty()) {
                     if (this.produits.getProVteCpteCa().contains(":")) {
                        var14 = this.produits.getProVteCpteCa().split(":");
                        var10 = var14[0];
                     } else {
                        var10 = this.produits.getProVteCpteCa();
                     }
                  } else if (this.produits.getProVteCpteZ() != null && !this.produits.getProVteCpteZ().isEmpty()) {
                     if (this.produits.getProVteCpteZ().contains(":")) {
                        var14 = this.produits.getProVteCpteZ().split(":");
                        var10 = var14[0];
                     } else {
                        var10 = this.produits.getProVteCpteZ();
                     }
                  }

                  if (var10 == null || var10.isEmpty()) {
                     this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(var6, this.produits.getProVteCode(), var9);
                     if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCompteCaisse() != null && !this.famillesProduitsVentes.getFamvteCompteCaisse().isEmpty()) {
                        if (this.famillesProduitsVentes.getFamvteCompteCaisse().contains(":")) {
                           var14 = this.famillesProduitsVentes.getFamvteCompteCaisse().split(":");
                           var10 = var14[0];
                        } else {
                           var10 = this.famillesProduitsVentes.getFamvteCompteCaisse();
                        }
                     } else if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCompteZone() != null && !this.famillesProduitsVentes.getFamvteCompteZone().isEmpty()) {
                        if (this.famillesProduitsVentes.getFamvteCompteZone().contains(":")) {
                           var14 = this.famillesProduitsVentes.getFamvteCompteZone().split(":");
                           var10 = var14[0];
                        } else {
                           var10 = this.famillesProduitsVentes.getFamvteCompteZone();
                        }
                     }
                  }
               } else {
                  if (this.produits.getProVteCpteCa() != null && !this.produits.getProVteCpteCa().isEmpty()) {
                     if (this.produits.getProVteCpteCa().contains(":")) {
                        var14 = this.produits.getProVteCpteCa().split(":");
                        var10 = var14[0];
                     } else {
                        var10 = this.produits.getProVteCpteCa();
                     }
                  } else if (this.produits.getProVteCpteHz() != null && !this.produits.getProVteCpteHz().isEmpty()) {
                     if (this.produits.getProVteCpteHz() != null && !this.produits.getProVteCpteHz().isEmpty() && this.produits.getProVteCpteHz().contains(":")) {
                        var14 = this.produits.getProVteCpteHz().split(":");
                        var10 = var14[0];
                     } else {
                        var10 = this.produits.getProVteCpteHz();
                     }
                  }

                  if (var10 == null || var10.isEmpty()) {
                     this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(var6, this.produits.getProVteCode(), var9);
                     if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCompteCaisse() != null && !this.famillesProduitsVentes.getFamvteCompteCaisse().isEmpty()) {
                        if (this.famillesProduitsVentes.getFamvteCompteCaisse().contains(":")) {
                           var14 = this.famillesProduitsVentes.getFamvteCompteCaisse().split(":");
                           var10 = var14[0];
                        } else {
                           var10 = this.famillesProduitsVentes.getFamvteCompteCaisse();
                        }
                     } else if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCompteExterieur() != null && !this.famillesProduitsVentes.getFamvteCompteExterieur().isEmpty()) {
                        if (this.famillesProduitsVentes.getFamvteCompteExterieur().contains(":")) {
                           var14 = this.famillesProduitsVentes.getFamvteCompteExterieur().split(":");
                           var10 = var14[0];
                        } else {
                           var10 = this.famillesProduitsVentes.getFamvteCompteExterieur();
                        }
                     }
                  }
               }
            } else {
               if (this.produits.getProVteCpteCa() != null && !this.produits.getProVteCpteCa().isEmpty()) {
                  if (this.produits.getProVteCpteCa().contains(":")) {
                     var11 = this.produits.getProVteCpteCa().split(":");
                     var10 = var11[0];
                  } else {
                     var10 = this.produits.getProVteCpteCa();
                  }
               } else if (this.produits.getProVteCpteLoc() != null && !this.produits.getProVteCpteLoc().isEmpty()) {
                  if (this.produits.getProVteCpteLoc().contains(":")) {
                     var11 = this.produits.getProVteCpteLoc().split(":");
                     var10 = var11[0];
                  } else {
                     var10 = this.produits.getProVteCpteLoc();
                  }
               }

               if (var10 == null || var10.isEmpty()) {
                  this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(var6, this.produits.getProVteCode(), var9);
                  if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCompteCaisse() != null && !this.famillesProduitsVentes.getFamvteCompteCaisse().isEmpty()) {
                     if (this.famillesProduitsVentes.getFamvteCompteCaisse().contains(":")) {
                        var11 = this.famillesProduitsVentes.getFamvteCompteCaisse().split(":");
                        var10 = var11[0];
                     } else {
                        var10 = this.famillesProduitsVentes.getFamvteCompteCaisse();
                     }
                  } else if (this.famillesProduitsVentes != null && this.famillesProduitsVentes.getFamvteCompteLocal() != null && !this.famillesProduitsVentes.getFamvteCompteLocal().isEmpty()) {
                     if (this.famillesProduitsVentes.getFamvteCompteLocal().contains(":")) {
                        var11 = this.famillesProduitsVentes.getFamvteCompteLocal().split(":");
                        var10 = var11[0];
                     } else {
                        var10 = this.famillesProduitsVentes.getFamvteCompteLocal();
                     }
                  }
               }
            }
         }
      }

      if (var10 != null && !var10.isEmpty()) {
         if (var10.contains(":")) {
            var11 = var10.split(":");
            var10 = var11[0];
         }
      } else {
         var10 = "";
      }

      var10 = this.compteDefaut(var10);
      return var10;
   }

   public String calculeCompteTvaVentes(String var1, long var2, Session var4) throws HibernateException, NamingException {
      String var5 = "";
      String[] var6;
      if (var1 != null && !var1.isEmpty()) {
         this.taxesVentes = this.taxesVentesDao.selectTva(var2, var1, var4);
         if (this.taxesVentes != null) {
            if (this.taxesVentes.getTaxvteCompte() != null && !this.taxesVentes.getTaxvteCompte().isEmpty() && this.taxesVentes.getTaxvteCompte().contains(":")) {
               var6 = this.taxesVentes.getTaxvteCompte().split(":");
               var5 = var6[0];
            } else {
               var5 = this.taxesVentes.getTaxvteCompte();
            }
         }
      }

      if (var5 != null && !var5.isEmpty()) {
         if (var5.contains(":")) {
            var6 = var5.split(":");
            var5 = var6[0];
         }
      } else {
         var5 = "";
      }

      var5 = this.compteDefaut(var5);
      return var5;
   }

   public String calculeCompteTreso(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = "";
      this.journauxComptables = this.journauxComptablesDao.chercherCode(var1, this.exercicesComptable.getExecpt_id(), var2);
      if (this.journauxComptables != null) {
         var3 = this.journauxComptables.getPljCompteTreso();
      }

      if (var3 != null && !var3.isEmpty()) {
         if (var3.contains(":")) {
            String[] var4 = var3.split(":");
            var3 = var4[0];
         }
      } else {
         var3 = "";
      }

      var3 = this.compteDefaut(var3);
      return var3;
   }

   public String calculeCompteTiers(long var1, Session var3) throws HibernateException, NamingException {
      String var4 = "";
      String var5 = "";
      boolean var6 = false;
      this.tiers = this.tiersDao.selectTierD(var1, var3);
      if (this.tiers != null) {
         if (this.optionComptabilite.getExportOd().equals("1") && this.tiers.getTiecompteSage() != null && !this.tiers.getTiecompteSage().isEmpty()) {
            var5 = this.tiers.getTiecompteSage();
            String var7 = "";
            var6 = true;
            if (this.tiers.getTiecompte0() != null && !this.tiers.getTiecompte0().isEmpty()) {
               if (this.structureLog.getStrid() == 51L) {
                  if (this.tiers.getTietype() != null && !this.tiers.getTietype().isEmpty() && this.tiers.getTietype().equals("0")) {
                     if (this.tiers.getTiecategorie() != null && !this.tiers.getTiecategorie().isEmpty() && this.tiers.getTiecategorie().startsWith("Propr")) {
                        var7 = "45" + this.tiers.getTiecompte0().substring(2);
                     } else {
                        var7 = this.tiers.getTiecompte0();
                     }
                  } else {
                     var7 = this.tiers.getTiecompte0();
                  }
               } else {
                  var7 = this.tiers.getTiecompte0().substring(0, 4);
               }
            } else if (this.structureLog.getStrid() == 40L) {
               if (this.tiers.getTietype().equals("0")) {
                  var7 = "4011";
               } else {
                  var7 = "4110";
               }
            } else if (this.tiers.getTietype().equals("0")) {
               var7 = "4011";
            } else {
               var7 = "4111";
            }

            if (this.structureLog.getStrid() == 51L) {
               var4 = var7 + ":" + var5;
            } else {
               var4 = var7 + ":" + var5;
            }
         } else {
            var6 = false;
            var4 = this.tiers.getTiecompte0();
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var6 = false;
         if (false && var4.contains(":")) {
            String[] var8 = var4.split(":");
            var4 = var8[0];
         }
      } else {
         var4 = "";
      }

      var4 = this.compteDefaut(var4);
      return var4;
   }

   public String calculeCompteProprietaire(long var1, Session var3) throws HibernateException, NamingException {
      String var4 = "";
      String var5 = "";
      boolean var6 = false;
      this.tiers = this.tiersDao.selectTierD(var1, var3);
      if (this.tiers != null) {
         if (this.optionComptabilite.getExportOd().equals("1") && this.tiers.getTiecompteSage() != null && !this.tiers.getTiecompteSage().isEmpty()) {
            var5 = this.tiers.getTiecompteSage();
            String var7 = "";
            var6 = true;
            if (this.tiers.getTiecompte0() != null && !this.tiers.getTiecompte0().isEmpty()) {
               if (this.structureLog.getStrid() == 51L) {
                  if (this.tiers.getTietype().equals("0")) {
                     var7 = this.tiers.getTiecompte0();
                     var5 = "4060000";
                  } else {
                     var7 = this.tiers.getTiecompte0();
                  }
               } else {
                  var7 = this.tiers.getTiecompte0().substring(0, 4);
               }
            } else if (this.tiers.getTietype().equals("0")) {
               var7 = "4011";
            } else {
               var7 = "4111";
            }

            if (this.structureLog.getStrid() == 51L) {
               var4 = var7 + ":" + var5;
            } else {
               var4 = var7 + ":" + var5;
            }
         } else {
            var6 = false;
            var4 = this.tiers.getTiecompte0();
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var6 = false;
         if (false && var4.contains(":")) {
            String[] var8 = var4.split(":");
            var4 = var8[0];
         }
      } else {
         var4 = "";
      }

      var4 = this.compteDefaut(var4);
      return var4;
   }

   public String calculeCompte47Proprietaire(long var1, Session var3) throws HibernateException, NamingException {
      String var4 = "";
      String var5 = "";
      boolean var6 = false;
      this.tiers = this.tiersDao.selectTierD(var1, var3);
      if (this.tiers != null) {
         if (this.optionComptabilite.getExportOd().equals("1") && this.tiers.getTiecompteSage() != null && !this.tiers.getTiecompteSage().isEmpty()) {
            var5 = this.tiers.getTiecompteSage();
            String var7 = "";
            var6 = true;
            if (this.tiers.getTiecompte0() != null && !this.tiers.getTiecompte0().isEmpty()) {
               if (this.structureLog.getStrid() == 51L) {
                  if (this.tiers.getTietype().equals("0")) {
                     new Bien();
                     Bien var8 = this.bienFacture.getBien();
                     if (var8.getBieCompteCharge() != null && !var8.getBieCompteCharge().isEmpty()) {
                        var7 = var8.getBieCompteCharge();
                     } else {
                        var7 = this.tiers.getTiecompte0();
                     }
                  } else {
                     var7 = this.tiers.getTiecompte0();
                  }
               } else {
                  var7 = this.tiers.getTiecompte0().substring(0, 4);
               }
            } else if (this.structureLog.getStrid() == 40L) {
               if (this.tiers.getTietype().equals("0")) {
                  var7 = "4011";
               } else {
                  var7 = "4110";
               }
            } else if (this.tiers.getTietype().equals("0")) {
               var7 = "4011";
            } else {
               var7 = "4111";
            }

            if (this.structureLog.getStrid() == 51L) {
               var4 = var7 + ":" + var5;
            } else {
               var4 = var7 + ":" + var5;
            }
         } else {
            var6 = false;
            var4 = this.tiers.getTiecompte0();
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var6 = false;
         if (false && var4.contains(":")) {
            String[] var9 = var4.split(":");
            var4 = var9[0];
         }
      } else {
         var4 = "";
      }

      var4 = this.compteDefaut(var4);
      return var4;
   }

   public String calculeCompte449Proprietaire(long var1, Session var3) throws HibernateException, NamingException {
      String var4 = "";
      String var5 = "";
      boolean var6 = false;
      this.tiers = this.tiersDao.selectTierD(var1, var3);
      if (this.tiers != null) {
         if (this.optionComptabilite.getExportOd().equals("1") && this.tiers.getTiecompteSage() != null && !this.tiers.getTiecompteSage().isEmpty()) {
            var5 = this.tiers.getTiecompteSage();
            String var7 = "";
            var6 = true;
            if (this.tiers.getTiecompte0() != null && !this.tiers.getTiecompte0().isEmpty()) {
               if (this.structureLog.getStrid() == 51L) {
                  if (this.tiers.getTietype().equals("0")) {
                     var7 = "449" + this.tiers.getTiecompte0().substring(2);
                     var5 = "4492001";
                  } else {
                     var7 = this.tiers.getTiecompte0();
                  }
               } else {
                  var7 = this.tiers.getTiecompte0().substring(0, 4);
               }
            } else if (this.structureLog.getStrid() == 40L) {
               if (this.tiers.getTietype().equals("0")) {
                  var7 = "4011";
               } else {
                  var7 = "4110";
               }
            } else if (this.tiers.getTietype().equals("0")) {
               var7 = "4011";
            } else {
               var7 = "4111";
            }

            if (this.structureLog.getStrid() == 51L) {
               var4 = var7 + ":" + var5;
            } else {
               var4 = var7 + ":" + var5;
            }
         } else {
            var6 = false;
            var4 = this.tiers.getTiecompte0();
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var6 = false;
         if (false && var4.contains(":")) {
            String[] var8 = var4.split(":");
            var4 = var8[0];
         }
      } else {
         var4 = "";
      }

      var4 = this.compteDefaut(var4);
      return var4;
   }

   public String calculeCompte407Proprietaire(long var1, Session var3) throws HibernateException, NamingException {
      String var4 = "";
      String var5 = "";
      boolean var6 = false;
      this.tiers = this.tiersDao.selectTierD(var1, var3);
      if (this.tiers != null) {
         if (this.optionComptabilite.getExportOd().equals("1") && this.tiers.getTiecompteSage() != null && !this.tiers.getTiecompteSage().isEmpty()) {
            var5 = this.tiers.getTiecompteSage();
            String var7 = "";
            var6 = true;
            if (this.tiers.getTiecompte0() != null && !this.tiers.getTiecompte0().isEmpty()) {
               if (this.structureLog.getStrid() == 51L) {
                  if (this.tiers.getTietype().equals("0")) {
                     var7 = this.tiers.getTiecompte0();
                  } else {
                     var7 = this.tiers.getTiecompte0();
                  }
               } else {
                  var7 = this.tiers.getTiecompte0().substring(0, 4);
               }
            } else if (this.structureLog.getStrid() == 40L) {
               if (this.tiers.getTietype().equals("0")) {
                  var7 = "4011";
               } else {
                  var7 = "4110";
               }
            } else if (this.tiers.getTietype().equals("0")) {
               var7 = "4011";
            } else {
               var7 = "4111";
            }

            if (this.structureLog.getStrid() == 51L) {
               var4 = var7 + ":" + var5;
            } else {
               var4 = var7 + ":" + var5;
            }
         } else {
            var6 = false;
            var4 = this.tiers.getTiecompte0();
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var6 = false;
         if (false && var4.contains(":")) {
            String[] var8 = var4.split(":");
            var4 = var8[0];
         }
      } else {
         var4 = "";
      }

      var4 = this.compteDefaut(var4);
      return var4;
   }

   public String calculeCompteAgent(long var1, ExercicesPaye var3, Session var4) throws HibernateException, NamingException {
      String var5 = "";
      this.salaries = this.salariesDao.chercherIdSalaries(var1, var4);
      if (this.salaries != null) {
         var5 = "42XXXX";
      }

      if (var5 != null && !var5.isEmpty()) {
         if (var5.contains(":")) {
            String[] var6 = var5.split(":");
            var5 = var6[0];
         }
      } else {
         var5 = "";
      }

      var5 = this.compteDefaut(var5);
      return var5;
   }

   public String calculeCompteUser(long var1, Session var3) throws HibernateException, NamingException {
      String var4 = "";
      new Users();
      UserDao var6 = new UserDao(this.baseLog, this.utilInitHibernate);
      Users var5 = var6.selectLeUserId(var1, var3);
      if (var5 != null) {
         var4 = var5.getUsrCompte();
      }

      if (var4 != null && !var4.isEmpty()) {
         if (var4.contains(":")) {
            String[] var7 = var4.split(":");
            var4 = var7[0];
         }
      } else {
         var4 = "";
      }

      var4 = this.compteDefaut(var4);
      return var4;
   }

   public String calculeCompteAttente(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new PlanComptable();
      new ArrayList();
      List var4 = this.planComptableDao.chargeNumCpte(this.selecFiscalite, "4711", this.exercicesComptable.getExecpt_id(), 0, this.usersLog.getUsrCptInterdit(), var1);
      if (var4.size() != 0) {
         var2 = ((PlanComptable)var4.get(0)).getPlcCompte();
      } else {
         var2 = "4711000000";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.contains(":")) {
            String[] var5 = var2.split(":");
            var2 = var5[0];
         }
      } else {
         var2 = "";
      }

      var2 = this.compteDefaut(var2);
      return var2;
   }

   public String numComposeJournal(String var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      String var5 = "";
      long var6 = 0L;
      byte var8 = 53;
      int var9 = this.journauxComptables.getPljPiece();
      if (var9 >= 1) {
         String var10 = this.calculPeriode(var2);
         String var11 = "" + (var2.getYear() + 1900);
         this.chrono = new Chrono();
         this.chrono = this.chronoDao.chronoByNatAndJournalPeriode(var8, var1, var11, var4);
         if (this.chrono != null) {
            CalculChrono var12 = new CalculChrono(this.baseLog, this.utilInitHibernate);
            if (var9 == 1) {
               var6 = this.enregitrerNumero(var10, var4);
            } else if (var9 != 2) {
               var6 = this.recupererNumero(var10);
            } else if (this.var_debit != this.var_credit && (this.var_ref1 == null || this.var_ref1.isEmpty() || this.var_memoRef1 == null || this.var_memoRef1.isEmpty() || this.var_ref1.equals(this.var_memoRef1))) {
               var6 = this.recupererNumero(var10);
            } else {
               var6 = this.enregitrerNumero(var10, var4);
            }

            var5 = var12.formattageChrono(this.chrono, var6, var1, "", var2);
         } else {
            var5 = var3;
         }
      } else {
         var5 = var3;
      }

      return var5;
   }

   public long recupererNumero(String var1) {
      long var2 = 0L;
      if (this.chrono.getChrMode() == 0) {
         var2 = this.chrono.getChrNumAn();
      } else if (this.chrono.getChrMode() == 1) {
         String[] var4 = var1.split(":");
         String var5 = var4[0];
         if (var5.equalsIgnoreCase("01")) {
            var2 = this.chrono.getChrNum01();
         } else if (var5.equalsIgnoreCase("02")) {
            var2 = this.chrono.getChrNum02();
         } else if (var5.equalsIgnoreCase("03")) {
            var2 = this.chrono.getChrNum03();
         } else if (var5.equalsIgnoreCase("04")) {
            var2 = this.chrono.getChrNum04();
         } else if (var5.equalsIgnoreCase("05")) {
            var2 = this.chrono.getChrNum05();
         } else if (var5.equalsIgnoreCase("06")) {
            var2 = this.chrono.getChrNum06();
         } else if (var5.equalsIgnoreCase("07")) {
            var2 = this.chrono.getChrNum07();
         } else if (var5.equalsIgnoreCase("08")) {
            var2 = this.chrono.getChrNum08();
         } else if (var5.equalsIgnoreCase("09")) {
            var2 = this.chrono.getChrNum09();
         } else if (var5.equalsIgnoreCase("10")) {
            var2 = this.chrono.getChrNum10();
         } else if (var5.equalsIgnoreCase("11")) {
            var2 = this.chrono.getChrNum11();
         } else if (var5.equalsIgnoreCase("12")) {
            var2 = this.chrono.getChrNum12();
         }
      } else if (this.chrono.getChrMode() == 2) {
         var2 = this.chrono.getChrNum();
      }

      return var2;
   }

   public long enregitrerNumero(String var1, Session var2) throws HibernateException, NamingException {
      long var3 = 0L;
      if (this.chrono.getChrMode() == 0) {
         this.chrono.setChrNumAn(this.chrono.getChrNumAn() + 1L);
         var3 = this.chrono.getChrNumAn();
      } else if (this.chrono.getChrMode() == 1) {
         String[] var5 = var1.split(":");
         String var6 = var5[0];
         if (var6.equalsIgnoreCase("01")) {
            this.chrono.setChrNum01(this.chrono.getChrNum01() + 1L);
            var3 = this.chrono.getChrNum01();
         } else if (var6.equalsIgnoreCase("02")) {
            this.chrono.setChrNum02(this.chrono.getChrNum02() + 1L);
            var3 = this.chrono.getChrNum02();
         } else if (var6.equalsIgnoreCase("03")) {
            this.chrono.setChrNum03(this.chrono.getChrNum03() + 1L);
            var3 = this.chrono.getChrNum03();
         } else if (var6.equalsIgnoreCase("04")) {
            this.chrono.setChrNum04(this.chrono.getChrNum04() + 1L);
            var3 = this.chrono.getChrNum04();
         } else if (var6.equalsIgnoreCase("05")) {
            this.chrono.setChrNum05(this.chrono.getChrNum05() + 1L);
            var3 = this.chrono.getChrNum05();
         } else if (var6.equalsIgnoreCase("06")) {
            this.chrono.setChrNum06(this.chrono.getChrNum06() + 1L);
            var3 = this.chrono.getChrNum06();
         } else if (var6.equalsIgnoreCase("07")) {
            this.chrono.setChrNum07(this.chrono.getChrNum07() + 1L);
            var3 = this.chrono.getChrNum07();
         } else if (var6.equalsIgnoreCase("08")) {
            this.chrono.setChrNum08(this.chrono.getChrNum08() + 1L);
            var3 = this.chrono.getChrNum08();
         } else if (var6.equalsIgnoreCase("09")) {
            this.chrono.setChrNum09(this.chrono.getChrNum09() + 1L);
            var3 = this.chrono.getChrNum09();
         } else if (var6.equalsIgnoreCase("10")) {
            this.chrono.setChrNum10(this.chrono.getChrNum10() + 1L);
            var3 = this.chrono.getChrNum10();
         } else if (var6.equalsIgnoreCase("11")) {
            this.chrono.setChrNum11(this.chrono.getChrNum11() + 1L);
            var3 = this.chrono.getChrNum11();
         } else if (var6.equalsIgnoreCase("12")) {
            this.chrono.setChrNum12(this.chrono.getChrNum12() + 1L);
            var3 = this.chrono.getChrNum12();
         }
      } else if (this.chrono.getChrMode() == 2) {
         this.chrono.setChrNum(this.chrono.getChrNum() + 1L);
         var3 = this.chrono.getChrNum();
      }

      this.chronoDao.modifierChrono(this.chrono, var2);
      var2.flush();
      return var3;
   }

   public String chronoTransfert() throws HibernateException, NamingException {
      String var1 = "";
      this.chronoTransfert = new Chrono();
      this.chronoTransfert = this.chronoDao.chronoByNat(55, (Session)null);
      if (this.chronoTransfert != null) {
         CalculChrono var2 = new CalculChrono(this.baseLog, this.utilInitHibernate);
         String var3 = this.calculPeriode(new Date());
         this.enregitrerNumeroTransfert(var3, (Session)null);
         long var4 = this.recupererNumeroTransfert(var3);
         var1 = var2.formattageChrono(this.chronoTransfert, var4, "", "", new Date());
      }

      return var1;
   }

   public long enregitrerNumeroTransfert(String var1, Session var2) throws HibernateException, NamingException {
      long var3 = 0L;
      if (this.chronoTransfert.getChrMode() == 0) {
         this.chronoTransfert.setChrNumAn(this.chronoTransfert.getChrNumAn() + 1L);
         var3 = this.chronoTransfert.getChrNumAn();
      } else if (this.chronoTransfert.getChrMode() == 1) {
         String[] var5 = var1.split(":");
         String var6 = var5[0];
         if (var6.equalsIgnoreCase("01")) {
            this.chronoTransfert.setChrNum01(this.chronoTransfert.getChrNum01() + 1L);
            var3 = this.chronoTransfert.getChrNum01();
         } else if (var6.equalsIgnoreCase("02")) {
            this.chronoTransfert.setChrNum02(this.chronoTransfert.getChrNum02() + 1L);
            var3 = this.chronoTransfert.getChrNum02();
         } else if (var6.equalsIgnoreCase("03")) {
            this.chronoTransfert.setChrNum03(this.chronoTransfert.getChrNum03() + 1L);
            var3 = this.chronoTransfert.getChrNum03();
         } else if (var6.equalsIgnoreCase("04")) {
            this.chronoTransfert.setChrNum04(this.chronoTransfert.getChrNum04() + 1L);
            var3 = this.chronoTransfert.getChrNum04();
         } else if (var6.equalsIgnoreCase("05")) {
            this.chronoTransfert.setChrNum05(this.chronoTransfert.getChrNum05() + 1L);
            var3 = this.chronoTransfert.getChrNum05();
         } else if (var6.equalsIgnoreCase("06")) {
            this.chronoTransfert.setChrNum06(this.chronoTransfert.getChrNum06() + 1L);
            var3 = this.chronoTransfert.getChrNum06();
         } else if (var6.equalsIgnoreCase("07")) {
            this.chronoTransfert.setChrNum07(this.chronoTransfert.getChrNum07() + 1L);
            var3 = this.chronoTransfert.getChrNum07();
         } else if (var6.equalsIgnoreCase("08")) {
            this.chronoTransfert.setChrNum08(this.chronoTransfert.getChrNum08() + 1L);
            var3 = this.chronoTransfert.getChrNum08();
         } else if (var6.equalsIgnoreCase("09")) {
            this.chronoTransfert.setChrNum09(this.chronoTransfert.getChrNum09() + 1L);
            var3 = this.chronoTransfert.getChrNum09();
         } else if (var6.equalsIgnoreCase("10")) {
            this.chronoTransfert.setChrNum10(this.chronoTransfert.getChrNum10() + 1L);
            var3 = this.chronoTransfert.getChrNum10();
         } else if (var6.equalsIgnoreCase("11")) {
            this.chronoTransfert.setChrNum11(this.chronoTransfert.getChrNum11() + 1L);
            var3 = this.chronoTransfert.getChrNum11();
         } else if (var6.equalsIgnoreCase("12")) {
            this.chronoTransfert.setChrNum12(this.chronoTransfert.getChrNum12() + 1L);
            var3 = this.chronoTransfert.getChrNum12();
         }
      } else if (this.chronoTransfert.getChrMode() == 2) {
         this.chronoTransfert.setChrNum(this.chronoTransfert.getChrNum() + 1L);
         var3 = this.chronoTransfert.getChrNum();
      }

      this.chronoDao.modifierChrono(this.chronoTransfert, var2);
      return var3;
   }

   public long recupererNumeroTransfert(String var1) {
      long var2 = 0L;
      if (this.chronoTransfert.getChrMode() == 0) {
         var2 = this.chronoTransfert.getChrNumAn();
      } else if (this.chronoTransfert.getChrMode() == 1) {
         String[] var4 = var1.split(":");
         String var5 = var4[0];
         if (var5.equalsIgnoreCase("01")) {
            var2 = this.chronoTransfert.getChrNum01();
         } else if (var5.equalsIgnoreCase("02")) {
            var2 = this.chronoTransfert.getChrNum02();
         } else if (var5.equalsIgnoreCase("03")) {
            var2 = this.chronoTransfert.getChrNum03();
         } else if (var5.equalsIgnoreCase("04")) {
            var2 = this.chronoTransfert.getChrNum04();
         } else if (var5.equalsIgnoreCase("05")) {
            var2 = this.chronoTransfert.getChrNum05();
         } else if (var5.equalsIgnoreCase("06")) {
            var2 = this.chronoTransfert.getChrNum06();
         } else if (var5.equalsIgnoreCase("07")) {
            var2 = this.chronoTransfert.getChrNum07();
         } else if (var5.equalsIgnoreCase("08")) {
            var2 = this.chronoTransfert.getChrNum08();
         } else if (var5.equalsIgnoreCase("09")) {
            var2 = this.chronoTransfert.getChrNum09();
         } else if (var5.equalsIgnoreCase("10")) {
            var2 = this.chronoTransfert.getChrNum10();
         } else if (var5.equalsIgnoreCase("11")) {
            var2 = this.chronoTransfert.getChrNum11();
         } else if (var5.equalsIgnoreCase("12")) {
            var2 = this.chronoTransfert.getChrNum12();
         }
      } else if (this.chronoTransfert.getChrMode() == 2) {
         var2 = this.chronoTransfert.getChrNum();
      }

      return var2;
   }

   public void generationComptaImmo() throws IOException, JDOMException, HibernateException, NamingException {
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Initialisation du transfert en comptabilite...");
      double var1 = (double)this.formTransfertCompta.getLesTransfertCompta().size();
      UtilTrie var3 = new UtilTrie();
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.verifAnalytique();
      String var4 = this.chronoTransfert();
      int var5 = 0;
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var7 = null;

      try {
         var7 = var6.beginTransaction();
         var6.setFlushMode(FlushMode.MANUAL);
         this.var_debit = 0.0D;
         this.var_credit = 0.0D;
         Brouillard var8 = null;
         boolean var9 = false;
         new TransfertCompta();
         int var11 = 0;

         while(true) {
            if (var11 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
               var6.flush();
               var7.commit();
               break;
            }

            TransfertCompta var10 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var11);
            this.formTransfertCompta.setVar_info("Ligne : " + var11 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var11 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var11)));
            }

            this.verifJournal(var10.getTrfCode(), (String)null, 99, (String)null, var6);
            this.verifNumcompte(var10.getTrfCompte(), var10.getTrfDateSaisie(), var6);
            String var12 = this.numComposeJournal(var10.getTrfCode(), var10.getTrfDateSaisie(), var10.getTrfReference1(), var6);
            var9 = false;
            if (false) {
               var8 = this.genererBrouillard(var6, var4, var10.getTrfIdOrigine(), "AM", var10.getTrfCode(), var12, var10.getTrfDateSaisie(), var10.getTrfLibelle(), var10.getTrfReference1(), var10.getTrfReference2(), var10.getTrfDebitSaisie(), var10.getTrfCreditSaisie(), var10.getTrfIdResponsable(), var10.getTrfNomResponsable());
               var9 = true;
            }

            new Ecritures();
            Ecritures var13 = this.genererEcriture(var6, var8, var4, var10.getTrfIdOrigine(), "AM", var10.getTrfCode(), var10.getTrfCompte(), var12, var10.getTrfDateSaisie(), var10.getTrfLibelle(), var10.getTrfReference1(), var10.getTrfReference2(), var10.getTrfDebitSaisie(), var10.getTrfCreditSaisie(), var10.getTrfDateEcheance(), var10.getTrfBudget(), var10.getTrfLettre(), (String)null, var10.getTrfDossier());
            this.ventilationAnalytique(var10, var13, var6);
            ++var5;
            if (var5 == this.cpteMaxFlush) {
               var6.flush();
               var5 = 0;
            }

            this.var_debit += var10.getTrfDebitSaisie();
            this.var_credit += var10.getTrfCreditSaisie();
            ++var11;
         }
      } catch (HibernateException var17) {
         if (var7 != null) {
            var7.rollback();
         }

         throw var17;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void generationComptaLoyer() throws IOException, JDOMException, HibernateException, NamingException {
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Initialisation du transfert en comptabilite...");
      double var1 = (double)this.formTransfertCompta.getLesTransfertCompta().size();
      UtilTrie var3 = new UtilTrie();
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.verifAnalytique();
      String var4 = this.chronoTransfert();
      int var5 = 0;
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var7 = null;

      try {
         var7 = var6.beginTransaction();
         var6.setFlushMode(FlushMode.MANUAL);
         this.var_debit = 0.0D;
         this.var_credit = 0.0D;
         Brouillard var8 = null;
         boolean var9 = false;
         new TransfertCompta();
         int var11 = 0;

         while(true) {
            if (var11 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
               var6.flush();
               var7.commit();
               break;
            }

            TransfertCompta var10 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var11);
            this.formTransfertCompta.setVar_info("Ligne : " + var11 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var11 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var11)));
            }

            this.verifJournal(var10.getTrfCode(), (String)null, 99, (String)null, var6);
            this.verifNumcompte(var10.getTrfCompte(), var10.getTrfDateSaisie(), var6);
            String var12 = this.numComposeJournal(var10.getTrfCode(), var10.getTrfDateSaisie(), var10.getTrfReference1(), var6);
            var9 = false;
            if (false) {
               var8 = this.genererBrouillard(var6, var4, var10.getTrfIdOrigine(), "LO", var10.getTrfCode(), var12, var10.getTrfDateSaisie(), var10.getTrfLibelle(), var10.getTrfReference1(), var10.getTrfReference2(), var10.getTrfDebitSaisie(), var10.getTrfCreditSaisie(), var10.getTrfIdResponsable(), var10.getTrfNomResponsable());
               var9 = true;
            }

            new Ecritures();
            Ecritures var13 = this.genererEcriture(var6, var8, var4, var10.getTrfIdOrigine(), "LO", var10.getTrfCode(), var10.getTrfCompte(), var12, var10.getTrfDateSaisie(), var10.getTrfLibelle(), var10.getTrfReference1(), var10.getTrfReference2(), var10.getTrfDebitSaisie(), var10.getTrfCreditSaisie(), var10.getTrfDateEcheance(), var10.getTrfBudget(), var10.getTrfLettre(), (String)null, var10.getTrfDossier());
            this.ventilationAnalytique(var10, var13, var6);
            ++var5;
            if (var5 == this.cpteMaxFlush) {
               var6.flush();
               var5 = 0;
            }

            this.var_debit += var10.getTrfDebitSaisie();
            this.var_credit += var10.getTrfCreditSaisie();
            ++var11;
         }
      } catch (HibernateException var17) {
         if (var7 != null) {
            var7.rollback();
         }

         throw var17;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void generationComptaAchats() throws IOException, JDOMException, HibernateException, NamingException {
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Initialisation du transfert en comptabilite...");
      double var1 = (double)this.formTransfertCompta.getLesTransfertCompta().size();
      UtilTrie var3 = new UtilTrie();
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.verifAnalytique();
      String var4 = this.chronoTransfert();
      int var5 = 0;
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresAchats");
      Transaction var7 = null;

      try {
         var7 = var6.beginTransaction();
         var6.setFlushMode(FlushMode.MANUAL);
         this.var_debit = 0.0D;
         this.var_credit = 0.0D;
         this.var_ref1 = "";
         this.var_memoRef1 = ((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(0)).getTrfReference1();
         Brouillard var8 = null;
         new TransfertCompta();
         int var10 = 0;

         while(true) {
            if (var10 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
               this.traitementApresTransfertAchats(var6, var4);
               var6.flush();
               var7.commit();
               break;
            }

            TransfertCompta var9 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var10);
            this.formTransfertCompta.setVar_info("Ligne : " + var10 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var10 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var10)));
            }

            this.verifJournal(var9.getTrfCode(), (String)null, 99, (String)null, var6);
            this.verifNumcompte(var9.getTrfCompte(), var9.getTrfDateSaisie(), var6);
            this.var_ref1 = var9.getTrfReference1();
            String var11 = this.numComposeJournal(var9.getTrfCode(), var9.getTrfDateSaisie(), var9.getTrfReference1(), var6);
            if (this.var_debit == this.var_credit && this.var_debit - this.var_credit == 0.0D) {
               var8 = this.genererBrouillard(var6, var4, var9.getTrfIdOrigine(), var9.getTrfTypeOrigine(), var9.getTrfCode(), var11, var9.getTrfDateSaisie(), var9.getTrfLibelle(), var9.getTrfReference1(), var9.getTrfReference2(), var9.getTrfDebitSaisie(), var9.getTrfCreditSaisie(), var9.getTrfIdResponsable(), var9.getTrfNomResponsable());
            }

            Ecritures var12 = null;
            var12 = this.genererEcriture(var6, var8, var4, var9.getTrfIdOrigine(), var9.getTrfTypeOrigine(), var9.getTrfCode(), var9.getTrfCompte(), var11, var9.getTrfDateSaisie(), var9.getTrfLibelle(), var9.getTrfReference1(), var9.getTrfReference2(), var9.getTrfDebitSaisie(), var9.getTrfCreditSaisie(), var9.getTrfDateEcheance(), var9.getTrfBudget(), var9.getTrfLettre(), (String)null, var9.getTrfDossier());
            this.ventilationAnalytique(var9, var12, var6);
            ++var5;
            if (var5 == this.cpteMaxFlush) {
               var6.flush();
               var5 = 0;
            }

            this.var_debit += var9.getTrfDebitSaisie();
            this.var_credit += var9.getTrfCreditSaisie();
            this.var_memoRef1 = var9.getTrfReference1();
            ++var10;
         }
      } catch (HibernateException var16) {
         if (var7 != null) {
            var7.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void traitementApresTransfertAchats(Session var1, String var2) throws HibernateException, NamingException {
      this.factureEnteteAchatsDao = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteAchatsDao = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteAchatsDao = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.fraisEnteteAchatsDao = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.valorisationEnteteAchatsDao = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Finalisation du transfert...");
      double var3 = (double)this.formTransfertCompta.getListeDocumentTransfert().size();
      if (this.formTransfertCompta.getListeDocumentTransfert().size() != 0) {
         new DocumentEntete();

         for(int var6 = 0; var6 < this.formTransfertCompta.getListeDocumentTransfert().size(); ++var6) {
            DocumentEntete var5 = (DocumentEntete)this.formTransfertCompta.getListeDocumentTransfert().get(var6);
            this.formTransfertCompta.setVar_info("Finalisation du transfert Ligne : " + var6 + " sur : " + this.formTransfertCompta.getListeDocumentTransfert().size());
            if (var6 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var3 / (double)var6)));
            }

            if (var5.isDocSelect()) {
               if (var5.getDocNature() == 15) {
                  this.factureEnteteAchats = this.factureEnteteAchatsDao.pourParapheur(var5.getDocId(), var1);
                  if (this.factureEnteteAchats != null) {
                     if (this.factureEnteteAchats.getFcfEtat() == 0) {
                        this.factureEnteteAchats.setFcfEtat(1);
                     }

                     this.factureEnteteAchats.setFcfDateTransfert(new Date());
                     this.factureEnteteAchats.setFcfNumTrf(var2);
                     this.factureEnteteAchatsDao.modif(this.factureEnteteAchats, var1);
                     var1.flush();
                  }
               } else if (var5.getDocNature() == 16) {
                  this.avoirEnteteAchats = this.avoirEnteteAchatsDao.pourParapheur(var5.getDocId(), var1);
                  if (this.avoirEnteteAchats != null) {
                     if (this.avoirEnteteAchats.getAvfEtat() == 0) {
                        this.avoirEnteteAchats.setAvfEtat(1);
                     }

                     this.avoirEnteteAchats.setAvfDateTransfert(new Date());
                     this.avoirEnteteAchats.setAvfNumTrf(var2);
                     this.avoirEnteteAchatsDao.modif(this.avoirEnteteAchats, var1);
                     var1.flush();
                  }
               } else if (var5.getDocNature() == 17) {
                  this.noteDebitEnteteAchats = this.noteDebitEnteteAchatsDao.pourParapheur(var5.getDocId(), var1);
                  if (this.noteDebitEnteteAchats != null) {
                     if (this.noteDebitEnteteAchats.getNdfEtat() == 0) {
                        this.noteDebitEnteteAchats.setNdfEtat(1);
                     }

                     this.noteDebitEnteteAchats.setNdfDateTransfert(new Date());
                     this.noteDebitEnteteAchats.setNdfNumTrf(var2);
                     this.noteDebitEnteteAchatsDao.modif(this.noteDebitEnteteAchats, var1);
                     var1.flush();
                  }
               } else if (var5.getDocNature() == 18) {
                  this.fraisEnteteAchats = this.fraisEnteteAchatsDao.pourParapheur(var5.getDocId(), var1);
                  if (this.fraisEnteteAchats != null) {
                     if (this.fraisEnteteAchats.getFsfEtat() == 0) {
                        this.fraisEnteteAchats.setFsfEtat(1);
                     }

                     this.fraisEnteteAchats.setFsfDateTransfert(new Date());
                     this.fraisEnteteAchats.setFsfNumTrf(var2);
                     this.fraisEnteteAchatsDao.modif(this.fraisEnteteAchats, var1);
                     var1.flush();
                  }
               } else if (var5.getDocNature() == 35) {
                  this.valorisationEnteteAchats = this.valorisationEnteteAchatsDao.pourParapheur(var5.getDocId(), var1);
                  if (this.valorisationEnteteAchats != null) {
                     if (this.valorisationEnteteAchats.getValEtat() == 0) {
                        this.valorisationEnteteAchats.setValEtat(1);
                     }

                     this.valorisationEnteteAchats.setValDateTransfert(new Date());
                     this.valorisationEnteteAchats.setValNumTrf(var2);
                     this.valorisationEnteteAchatsDao.modif(this.valorisationEnteteAchats, var1);
                     var1.flush();
                  }
               }
            }
         }
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void generationComptaVentes() throws IOException, JDOMException, HibernateException, NamingException {
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Initialisation du transfert en comptabilite...");
      double var1 = (double)this.formTransfertCompta.getLesTransfertCompta().size();
      UtilTrie var3 = new UtilTrie();
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.verifAnalytique();
      String var4 = this.chronoTransfert();
      int var5 = 0;
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresVentes");
      Transaction var7 = null;

      try {
         var7 = var6.beginTransaction();
         var6.setFlushMode(FlushMode.MANUAL);
         this.var_debit = 0.0D;
         this.var_credit = 0.0D;
         Brouillard var8 = null;
         new TransfertCompta();
         int var10 = 0;

         while(true) {
            if (var10 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
               this.traitementApresTransfertVente(var6, var4);
               var6.flush();
               var7.commit();
               break;
            }

            TransfertCompta var9 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var10);
            this.formTransfertCompta.setVar_info("Ligne : " + var10 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var10 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var10)));
            }

            this.verifJournal(var9.getTrfCode(), (String)null, 99, (String)null, var6);
            this.verifNumcompte(var9.getTrfCompte(), var9.getTrfDateSaisie(), var6);
            String var11 = this.numComposeJournal(var9.getTrfCode(), var9.getTrfDateSaisie(), var9.getTrfReference1(), var6);
            if (this.var_debit == this.var_credit && this.var_debit - this.var_credit == 0.0D) {
               var8 = this.genererBrouillard(var6, var4, var9.getTrfIdOrigine(), var9.getTrfTypeOrigine(), var9.getTrfCode(), var11, var9.getTrfDateSaisie(), var9.getTrfLibelle(), var9.getTrfReference1(), var9.getTrfReference2(), var9.getTrfDebitSaisie(), var9.getTrfCreditSaisie(), var9.getTrfIdResponsable(), var9.getTrfNomResponsable());
            }

            Ecritures var12 = null;
            var12 = this.genererEcriture(var6, var8, var4, var9.getTrfIdOrigine(), var9.getTrfTypeOrigine(), var9.getTrfCode(), var9.getTrfCompte(), var11, var9.getTrfDateSaisie(), var9.getTrfLibelle(), var9.getTrfReference1(), var9.getTrfReference2(), var9.getTrfDebitSaisie(), var9.getTrfCreditSaisie(), var9.getTrfDateEcheance(), var9.getTrfBudget(), var9.getTrfLettre(), (String)null, var9.getTrfDossier());
            this.ventilationAnalytique(var9, var12, var6);
            ++var5;
            if (var5 == this.cpteMaxFlush) {
               var6.flush();
               var5 = 0;
            }

            this.var_debit += var9.getTrfDebitSaisie();
            this.var_credit += var9.getTrfCreditSaisie();
            ++var10;
         }
      } catch (HibernateException var16) {
         if (var7 != null) {
            var7.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void traitementApresTransfertVente(Session var1, String var2) throws HibernateException, NamingException {
      this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteVentesDao = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureInterneEnteteVentesDao = new FactureInterneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.ticketEnteteVentesDao = new TicketEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Finalisation du transfert...");
      double var3 = (double)this.formTransfertCompta.getListeDocumentTransfert().size();
      if (this.formTransfertCompta.getListeDocumentTransfert().size() != 0) {
         new DocumentEntete();

         for(int var6 = 0; var6 < this.formTransfertCompta.getListeDocumentTransfert().size(); ++var6) {
            DocumentEntete var5 = (DocumentEntete)this.formTransfertCompta.getListeDocumentTransfert().get(var6);
            this.formTransfertCompta.setVar_info("Finalisation du transfert Ligne : " + var6 + " sur : " + this.formTransfertCompta.getListeDocumentTransfert().size());
            if (var6 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var3 / (double)var6)));
            }

            if (var5.isDocSelect()) {
               if (var5.getDocNature() == 6) {
                  this.ticketEnteteVentes = this.ticketEnteteVentesDao.pourParapheur(var5.getDocId(), var1);
                  if (this.ticketEnteteVentes != null) {
                     if (this.ticketEnteteVentes.getTicEtat() == 0) {
                        this.ticketEnteteVentes.setTicEtat(1);
                     }

                     this.ticketEnteteVentes.setTicDateTransfert(new Date());
                     this.ticketEnteteVentesDao.modif(this.ticketEnteteVentes, var1);
                     var1.flush();
                  }
               } else if (var5.getDocNature() == 22) {
                  this.commandeEnteteVentes = this.commandeEnteteVentesDao.pourParapheur(var5.getDocId(), var1);
                  if (this.commandeEnteteVentes != null) {
                     if (this.commandeEnteteVentes.getBcmEtat() == 0) {
                        this.commandeEnteteVentes.setBcmEtat(1);
                     }

                     this.commandeEnteteVentes.setBcmDateTransfert(new Date());
                     this.commandeEnteteVentes.setBcmNumTrf(var2);
                     this.commandeEnteteVentesDao.modif(this.commandeEnteteVentes, var1);
                     var1.flush();
                  }
               } else if (var5.getDocNature() == 25) {
                  this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(var5.getDocId(), var1);
                  if (this.factureEnteteVentes != null) {
                     if (this.factureEnteteVentes.getFacEtat() == 0) {
                        this.factureEnteteVentes.setFacEtat(1);
                     }

                     this.factureEnteteVentes.setFacDateTransfert(new Date());
                     this.factureEnteteVentes.setFacNumTrf(var2);
                     this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
                     var1.flush();
                  }
               } else if (var5.getDocNature() == 26) {
                  this.avoirEnteteVentes = this.avoirEnteteVentesDao.pourParapheur(var5.getDocId(), var1);
                  if (this.avoirEnteteVentes != null) {
                     if (this.avoirEnteteVentes.getAvrEtat() == 0) {
                        this.avoirEnteteVentes.setAvrEtat(1);
                     }

                     this.avoirEnteteVentes.setAvrDateTransfert(new Date());
                     this.avoirEnteteVentes.setAvrNumTrf(var2);
                     this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var1);
                     var1.flush();
                  }
               } else if (var5.getDocNature() == 27) {
                  this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.pourParapheur(var5.getDocId(), var1);
                  if (this.noteDebitEnteteVentes != null) {
                     if (this.noteDebitEnteteVentes.getNdbEtat() == 0) {
                        this.noteDebitEnteteVentes.setNdbEtat(1);
                     }

                     this.noteDebitEnteteVentes.setNdbDateTransfert(new Date());
                     this.noteDebitEnteteVentes.setNdbNumTrf(var2);
                     this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
                     var1.flush();
                  }
               } else if (var5.getDocNature() == 142) {
                  this.factureInterneEnteteVentes = this.factureInterneEnteteVentesDao.pourParapheur(var5.getDocId(), var1);
                  if (this.factureInterneEnteteVentes != null) {
                     if (this.factureInterneEnteteVentes.getFitEtat() == 0) {
                        this.factureInterneEnteteVentes.setFitEtat(1);
                     }

                     this.factureInterneEnteteVentes.setFitDateTransfert(new Date());
                     this.factureInterneEnteteVentes.setFitNumTrf(var2);
                     this.factureInterneEnteteVentesDao.modif(this.factureInterneEnteteVentes, var1);
                     var1.flush();
                  }
               }
            }
         }
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void generationComptaImmobilier() throws IOException, JDOMException, HibernateException, NamingException {
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Initialisation du transfert en comptabilite...");
      double var1 = (double)this.formTransfertCompta.getLesTransfertCompta().size();
      UtilTrie var3 = new UtilTrie();
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.verifAnalytique();
      String var4 = this.chronoTransfert();
      int var5 = 0;
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresVentes");
      Transaction var7 = null;

      try {
         var7 = var6.beginTransaction();
         var6.setFlushMode(FlushMode.MANUAL);
         this.var_debit = 0.0D;
         this.var_credit = 0.0D;
         Brouillard var8 = null;
         new TransfertCompta();
         int var10 = 0;

         while(true) {
            if (var10 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
               this.traitementApresTransfertImmobilier(var6, var4);
               var6.flush();
               var7.commit();
               break;
            }

            TransfertCompta var9 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var10);
            this.formTransfertCompta.setVar_info("Ligne : " + var10 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var10 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var10)));
            }

            this.verifJournal(var9.getTrfCode(), (String)null, 99, (String)null, var6);
            this.verifNumcompte(var9.getTrfCompte(), var9.getTrfDateSaisie(), var6);
            String var11 = this.numComposeJournal(var9.getTrfCode(), var9.getTrfDateSaisie(), var9.getTrfReference1(), var6);
            if (this.var_debit == this.var_credit && this.var_debit - this.var_credit == 0.0D) {
               var8 = this.genererBrouillard(var6, var4, var9.getTrfIdOrigine(), var9.getTrfTypeOrigine(), var9.getTrfCode(), var11, var9.getTrfDateSaisie(), var9.getTrfLibelle(), var9.getTrfReference1(), var9.getTrfReference2(), var9.getTrfDebitSaisie(), var9.getTrfCreditSaisie(), var9.getTrfIdResponsable(), var9.getTrfNomResponsable());
            }

            Ecritures var12 = null;
            var12 = this.genererEcriture(var6, var8, var4, var9.getTrfIdOrigine(), var9.getTrfTypeOrigine(), var9.getTrfCode(), var9.getTrfCompte(), var11, var9.getTrfDateSaisie(), var9.getTrfLibelle(), var9.getTrfReference1(), var9.getTrfReference2(), var9.getTrfDebitSaisie(), var9.getTrfCreditSaisie(), var9.getTrfDateEcheance(), var9.getTrfBudget(), var9.getTrfLettre(), (String)null, var9.getTrfDossier());
            this.ventilationAnalytique(var9, var12, var6);
            ++var5;
            if (var5 == this.cpteMaxFlush) {
               var6.flush();
               var5 = 0;
            }

            this.var_debit += var9.getTrfDebitSaisie();
            this.var_credit += var9.getTrfCreditSaisie();
            ++var10;
         }
      } catch (HibernateException var16) {
         if (var7 != null) {
            var7.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void traitementApresTransfertImmobilier(Session var1, String var2) throws HibernateException, NamingException {
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteVentesDao = new AvoirEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Finalisation du transfert...");
      double var3 = (double)this.formTransfertCompta.getListeDocumentTransfert().size();
      if (this.formTransfertCompta.getListeDocumentTransfert().size() != 0) {
         new DocumentEntete();

         for(int var6 = 0; var6 < this.formTransfertCompta.getListeDocumentTransfert().size(); ++var6) {
            DocumentEntete var5 = (DocumentEntete)this.formTransfertCompta.getListeDocumentTransfert().get(var6);
            this.formTransfertCompta.setVar_info("Finalisation du transfert Ligne : " + var6 + " sur : " + this.formTransfertCompta.getListeDocumentTransfert().size());
            if (var6 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var3 / (double)var6)));
            }

            if (var5.isDocSelect()) {
               if (var5.getDocNature() == 25) {
                  this.factureEnteteVentes = this.factureEnteteVentesDao.pourParapheur(var5.getDocId(), var1);
                  if (this.factureEnteteVentes != null) {
                     if (this.factureEnteteVentes.getFacEtat() == 0) {
                        this.factureEnteteVentes.setFacEtat(1);
                     }

                     this.factureEnteteVentes.setFacDateTransfert(new Date());
                     this.factureEnteteVentes.setFacNumTrf(var2);
                     this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
                     var1.flush();
                  }
               } else if (var5.getDocNature() == 26) {
                  this.avoirEnteteVentes = this.avoirEnteteVentesDao.pourParapheur(var5.getDocId(), var1);
                  if (this.avoirEnteteVentes != null) {
                     if (this.avoirEnteteVentes.getAvrEtat() == 0) {
                        this.avoirEnteteVentes.setAvrEtat(1);
                     }

                     this.avoirEnteteVentes.setAvrDateTransfert(new Date());
                     this.avoirEnteteVentes.setAvrNumTrf(var2);
                     this.avoirEnteteVentesDao.modif(this.avoirEnteteVentes, var1);
                     var1.flush();
                  }
               } else if (var5.getDocNature() == 27) {
                  this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.pourParapheur(var5.getDocId(), var1);
                  if (this.noteDebitEnteteVentes != null) {
                     if (this.noteDebitEnteteVentes.getNdbEtat() == 0) {
                        this.noteDebitEnteteVentes.setNdbEtat(1);
                     }

                     this.noteDebitEnteteVentes.setNdbDateTransfert(new Date());
                     this.noteDebitEnteteVentes.setNdbNumTrf(var2);
                     this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
                     var1.flush();
                  }
               }
            }
         }
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void generationComptaMedical() throws IOException, JDOMException, HibernateException, NamingException {
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Initialisation du transfert en comptabilite...");
      double var1 = (double)this.formTransfertCompta.getLesTransfertCompta().size();
      UtilTrie var3 = new UtilTrie();
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.verifAnalytique();
      String var4 = this.chronoTransfert();
      int var5 = 0;
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresMedical");
      Transaction var7 = null;

      try {
         var7 = var6.beginTransaction();
         var6.setFlushMode(FlushMode.MANUAL);
         this.var_debit = 0.0D;
         this.var_credit = 0.0D;
         Brouillard var8 = null;
         new TransfertCompta();
         int var10 = 0;

         while(true) {
            if (var10 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
               this.traitementApresTransfertMedical(var6, var4);
               var6.flush();
               var7.commit();
               break;
            }

            TransfertCompta var9 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var10);
            this.formTransfertCompta.setVar_info("Ligne : " + var10 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var10 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var10)));
            }

            this.verifJournal(var9.getTrfCode(), (String)null, 99, (String)null, var6);
            this.verifNumcompte(var9.getTrfCompte(), var9.getTrfDateSaisie(), var6);
            String var11 = this.numComposeJournal(var9.getTrfCode(), var9.getTrfDateSaisie(), var9.getTrfReference1(), var6);
            if (this.var_debit == this.var_credit && this.var_debit - this.var_credit == 0.0D) {
               var8 = this.genererBrouillard(var6, var4, var9.getTrfIdOrigine(), var9.getTrfTypeOrigine(), var9.getTrfCode(), var11, var9.getTrfDateSaisie(), var9.getTrfLibelle(), var9.getTrfReference1(), var9.getTrfReference2(), var9.getTrfDebitSaisie(), var9.getTrfCreditSaisie(), var9.getTrfIdResponsable(), var9.getTrfNomResponsable());
            }

            Ecritures var12 = null;
            var12 = this.genererEcriture(var6, var8, var4, var9.getTrfIdOrigine(), var9.getTrfTypeOrigine(), var9.getTrfCode(), var9.getTrfCompte(), var11, var9.getTrfDateSaisie(), var9.getTrfLibelle(), var9.getTrfReference1(), var9.getTrfReference2(), var9.getTrfDebitSaisie(), var9.getTrfCreditSaisie(), var9.getTrfDateEcheance(), var9.getTrfBudget(), var9.getTrfLettre(), (String)null, var9.getTrfDossier());
            this.ventilationAnalytique(var9, var12, var6);
            ++var5;
            if (var5 == this.cpteMaxFlush) {
               var6.flush();
               var5 = 0;
            }

            this.var_debit += var9.getTrfDebitSaisie();
            this.var_credit += var9.getTrfCreditSaisie();
            ++var10;
         }
      } catch (HibernateException var16) {
         if (var7 != null) {
            var7.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void traitementApresTransfertMedical(Session var1, String var2) throws HibernateException, NamingException {
      this.consultationEnteteGeneDao = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      this.pharmacieEnteteDao = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireEnteteDao = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationEnteteDao = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteMedicalDao = new FactureEnteteMedicalDao(this.baseLog, this.utilInitHibernate);
      new ConsultationEnteteGene();
      new PharmacieEntete();
      new LaboratoireEntete();
      new HospitalisationEntete();
      new FactureEnteteMedical();
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Finalisation du transfert...");
      double var8 = (double)this.formTransfertCompta.getListeDocumentTransfert().size();
      if (this.formTransfertCompta.getListeDocumentTransfert().size() != 0) {
         new DocumentEntete();

         for(int var11 = 0; var11 < this.formTransfertCompta.getListeDocumentTransfert().size(); ++var11) {
            DocumentEntete var10 = (DocumentEntete)this.formTransfertCompta.getListeDocumentTransfert().get(var11);
            this.formTransfertCompta.setVar_info("Finalisation du transfert Ligne : " + var11 + " sur : " + this.formTransfertCompta.getListeDocumentTransfert().size());
            if (var11 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var8 / (double)var11)));
            }

            if (var10.isDocSelect()) {
               if (var10.getDocNature() == 71) {
                  ConsultationEnteteGene var3 = this.consultationEnteteGeneDao.selectById(var10.getDocId(), var1);
                  if (var3 != null) {
                     var3.setCsgDateTransfert(new Date());
                     this.consultationEnteteGeneDao.modif(var3, var1);
                  }
               } else if (var10.getDocNature() == 73) {
                  PharmacieEntete var4 = this.pharmacieEnteteDao.selectById(var10.getDocId(), var1);
                  if (var4 != null) {
                     var4.setPhaDateTransfert(new Date());
                     this.pharmacieEnteteDao.modif(var4, var1);
                  }
               } else if (var10.getDocNature() == 74) {
                  LaboratoireEntete var5 = this.laboratoireEnteteDao.selectById(var10.getDocId(), var1);
                  if (var5 != null) {
                     var5.setLabDateTransfert(new Date());
                     this.laboratoireEnteteDao.modif(var5, var1);
                  }
               } else if (var10.getDocNature() == 76) {
                  HospitalisationEntete var6 = this.hospitalisationEnteteDao.selectById(var10.getDocId(), var1);
                  if (var6 != null) {
                     var6.setHosDateTransfert(new Date());
                     this.hospitalisationEnteteDao.modif(var6, var1);
                  }
               } else if (var10.getDocNature() == 78) {
                  FactureEnteteMedical var7 = this.factureEnteteMedicalDao.pourParapheur(var10.getDocId(), var1);
                  if (var7 != null) {
                     if (var7.getFacEtat() == 0) {
                        var7.setFacEtat(1);
                     }

                     var7.setFacDateTransfert(new Date());
                     this.factureEnteteMedicalDao.modif(var7, var1);
                  }
               }
            }
         }
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void generationComptaCaisse() throws IOException, JDOMException, HibernateException, NamingException {
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Initialisation du transfert en comptabilite...");
      double var1 = (double)this.formTransfertCompta.getLesTransfertCompta().size();
      UtilTrie var3 = new UtilTrie();
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var3.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.verifAnalytique();
      String var4 = this.chronoTransfert();
      int var5 = 0;
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresCaisse");
      Transaction var7 = null;

      try {
         var7 = var6.beginTransaction();
         var6.setFlushMode(FlushMode.MANUAL);
         this.var_debit = 0.0D;
         this.var_credit = 0.0D;
         Brouillard var8 = null;
         new TransfertCompta();
         int var10 = 0;

         while(true) {
            if (var10 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
               this.traitementApresTransfertCaisse(var6, var4);
               var6.flush();
               var7.commit();
               break;
            }

            TransfertCompta var9 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var10);
            this.formTransfertCompta.setVar_info("Ligne : " + var10 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var10 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var10)));
            }

            this.verifJournal(var9.getTrfCode(), (String)null, 99, (String)null, var6);
            this.verifNumcompte(var9.getTrfCompte(), var9.getTrfDateSaisie(), var6);
            String var11 = this.numComposeJournal(var9.getTrfCode(), var9.getTrfDateSaisie(), var9.getTrfReference1(), var6);
            if (this.var_debit == this.var_credit && this.var_debit - this.var_credit == 0.0D) {
               var8 = this.genererBrouillard(var6, var4, var9.getTrfIdOrigine(), var9.getTrfTypeOrigine(), var9.getTrfCode(), var11, var9.getTrfDateSaisie(), var9.getTrfLibelle(), var9.getTrfReference1(), var9.getTrfReference2(), var9.getTrfDebitSaisie(), var9.getTrfCreditSaisie(), var9.getTrfIdResponsable(), var9.getTrfNomResponsable());
            }

            Ecritures var12 = null;
            var12 = this.genererEcriture(var6, var8, var4, var9.getTrfIdOrigine(), var9.getTrfTypeOrigine(), var9.getTrfCode(), var9.getTrfCompte(), var11, var9.getTrfDateSaisie(), var9.getTrfLibelle(), var9.getTrfReference1(), var9.getTrfReference2(), var9.getTrfDebitSaisie(), var9.getTrfCreditSaisie(), var9.getTrfDateEcheance(), var9.getTrfBudget(), var9.getTrfLettre(), (String)null, var9.getTrfDossier());
            this.ventilationAnalytique(var9, var12, var6);
            ++var5;
            if (var5 == this.cpteMaxFlush) {
               var6.flush();
               var5 = 0;
            }

            this.var_debit += var9.getTrfDebitSaisie();
            this.var_credit += var9.getTrfCreditSaisie();
            ++var10;
         }
      } catch (HibernateException var16) {
         if (var7 != null) {
            var7.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void traitementApresTransfertCaisse(Session var1, String var2) throws HibernateException, NamingException {
      ChargementEnteteDao var3 = new ChargementEnteteDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Finalisation du transfert...");
      double var4 = (double)this.formTransfertCompta.getListeDocumentTransfert().size();
      if (this.formTransfertCompta.getListeDocumentTransfert().size() != 0) {
         new DocumentEntete();

         for(int var7 = 0; var7 < this.formTransfertCompta.getListeDocumentTransfert().size(); ++var7) {
            DocumentEntete var6 = (DocumentEntete)this.formTransfertCompta.getListeDocumentTransfert().get(var7);
            this.formTransfertCompta.setVar_info("Finalisation du transfert Ligne : " + var7 + " sur : " + this.formTransfertCompta.getListeDocumentTransfert().size());
            if (var7 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var4 / (double)var7)));
            }

            if (var6.isDocSelect() && var6.getDocNature() != 0) {
               this.reglements = this.reglementsDao.pourParapheur(var6.getDocId(), var1);
               if (this.reglements != null) {
                  this.reglements.setRglDateTransfert(new Date());
                  this.reglements.setRglNumTrf(var2);
                  this.reglementsDao.modifierReg(this.reglements, var1);
                  var1.flush();
                  if (this.reglements.getRglNatureDoc() == 28) {
                     new ChargementEntete();
                     ChargementEntete var8 = var3.pourParapheur(this.reglements.getRglIdDocument(), var1);
                     if (var8 != null) {
                        var8.setChamobEtat(5);
                        var3.modif(var8, var1);
                        var1.flush();
                     }
                  }
               }
            }
         }
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void generationComptaPaye() throws IOException, JDOMException, HibernateException, NamingException {
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Initialisation du transfert en comptabilite...");
      double var1 = (double)this.formTransfertCompta.getLesTransfertCompta().size();
      this.verifAnalytique();
      String var3 = this.chronoTransfert();
      int var4 = 0;
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "TrfSalarie");
      Transaction var6 = null;

      try {
         var6 = var5.beginTransaction();
         var5.setFlushMode(FlushMode.MANUAL);
         this.var_debit = 0.0D;
         this.var_credit = 0.0D;
         Brouillard var7 = null;
         new TransfertCompta();
         int var9 = 0;

         while(true) {
            if (var9 >= this.formTransfertCompta.getLesTransfertCompta().size()) {
               this.traitementApresTransfertPaye(var5, var3);
               var5.flush();
               var6.commit();
               break;
            }

            TransfertCompta var8 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var9);
            this.formTransfertCompta.setVar_info("Ligne : " + var9 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var9 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var9)));
            }

            this.verifJournal(var8.getTrfCode(), (String)null, 99, (String)null, var5);
            this.verifNumcompte(var8.getTrfCompte(), var8.getTrfDateSaisie(), var5);
            String var10 = this.numComposeJournal(var8.getTrfCode(), var8.getTrfDateSaisie(), var8.getTrfReference1(), var5);
            if (this.var_debit == this.var_credit && this.var_debit - this.var_credit == 0.0D) {
               var7 = this.genererBrouillard(var5, var3, var8.getTrfIdOrigine(), "PY", var8.getTrfCode(), var10, var8.getTrfDateSaisie(), var8.getTrfLibelle(), var8.getTrfReference1(), var8.getTrfReference2(), var8.getTrfDebitSaisie(), var8.getTrfCreditSaisie(), var8.getTrfIdResponsable(), var8.getTrfNomResponsable());
            }

            Ecritures var11 = null;
            var11 = this.genererEcriture(var5, var7, var3, var8.getTrfIdOrigine(), "PY", var8.getTrfCode(), var8.getTrfCompte(), var10, var8.getTrfDateSaisie(), var8.getTrfLibelle(), var8.getTrfReference1(), var8.getTrfReference2(), var8.getTrfDebitSaisie(), var8.getTrfCreditSaisie(), var8.getTrfDateEcheance(), var8.getTrfBudget(), var8.getTrfLettre(), (String)null, var8.getTrfDossier());
            this.ventilationAnalytique(var8, var11, var5);
            ++var4;
            if (var4 == this.cpteMaxFlush) {
               var5.flush();
               var4 = 0;
            }

            this.var_debit += var8.getTrfDebitSaisie();
            this.var_credit += var8.getTrfCreditSaisie();
            ++var9;
         }
      } catch (HibernateException var15) {
         if (var6 != null) {
            var6.rollback();
         }

         throw var15;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void traitementApresTransfertPaye(Session var1, String var2) throws HibernateException, NamingException {
      this.bulletinSalaireDao = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      this.bulletinMoisDao = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Finalisation du transfert...");
      double var3 = (double)this.formTransfertCompta.getListeDocumentTransfert().size();
      if (this.formTransfertCompta.getListeDocumentTransfert().size() != 0) {
         new DocumentEntete();

         for(int var6 = 0; var6 < this.formTransfertCompta.getListeDocumentTransfert().size(); ++var6) {
            DocumentEntete var5 = (DocumentEntete)this.formTransfertCompta.getListeDocumentTransfert().get(var6);
            this.formTransfertCompta.setVar_info("Finalisation du transfert Ligne : " + var6 + " sur : " + this.formTransfertCompta.getListeDocumentTransfert().size());
            if (var6 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var3 / (double)var6)));
            }

            if (var5.isDocSelect()) {
               this.bulletinSalaire = this.bulletinSalaireDao.pourParapheur(var5.getDocId(), var1);
               if (this.bulletinSalaire != null) {
                  this.bulletinSalaire.setBulsalDateTransfert(new Date());
                  this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire, var1);
                  var1.flush();
                  this.bulletinMois = this.bulletinMoisDao.recupererBulletinMoisFeuille(this.bulletinSalaire.getBulsalPeriode(), this.bulletinSalaire.getBulsalFeuille(), var1);
                  if (this.bulletinMois != null) {
                     this.bulletinMois.setBulmenEtat(4);
                     this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois, var1);
                     var1.flush();
                  }
               }
            }
         }
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void generationImportation() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.formTransfertCompta.setVar_currentValue(0);
      this.formTransfertCompta.setVar_showBarProg(true);
      this.formTransfertCompta.setVar_info("Initialisation du transfert en comptabilite...");
      UtilTrie var1 = new UtilTrie();
      this.formTransfertCompta.setLesTransfertCompta(var1.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var1.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      this.formTransfertCompta.setLesTransfertCompta(var1.triListeTransfertComptaRef1(this.formTransfertCompta.getLesTransfertCompta()));
      if (this.formTransfertCompta.getLesTransfertCompta().size() != 0) {
         new TransfertCompta();
         TransfertCompta var2 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(0);
         if (var2.getTrfTypeImport() != null && !var2.getTrfTypeImport().isEmpty() && var2.getTrfTypeImport().equals("BALANCE")) {
            this.balance = 1;
         } else if (var2.getTrfTypeImport() != null && !var2.getTrfTypeImport().isEmpty() && var2.getTrfTypeImport().equals("PLANCOMPTABLE")) {
            this.balance = 4;
         } else if (var2.getTrfTypeImport() != null && !var2.getTrfTypeImport().isEmpty() && var2.getTrfTypeImport().equals("JOURNAUX")) {
            this.balance = 5;
         }
      } else if (this.formTransfertCompta.getLesTransfertVentes().size() != 0) {
         new TransfertVentes();
         TransfertVentes var17 = (TransfertVentes)this.formTransfertCompta.getLesTransfertVentes().get(0);
         if (var17.getTrfTypeImport() == 80) {
            this.balance = 80;
         } else if (var17.getTrfTypeImport() == 81) {
            this.balance = 81;
         }
      }

      if (this.balance != 2 && this.balance != 4) {
         if (this.balance == 5) {
            this.importSuiteJournauxComptbles((double)this.formTransfertCompta.getLesTransfertCompta().size());
         } else if (this.balance == 3) {
            this.importSuiteImmobilisation((double)this.formTransfertCompta.getLesTransfertCompta().size());
         } else if (this.balance == 80) {
            this.importImmobilisationLibre((double)this.formTransfertCompta.getLesTransfertVentes().size());
         } else if (this.balance == 81) {
            this.importEcritureLibre((double)this.formTransfertCompta.getLesTransfertVentes().size());
         } else {
            byte var18 = 0;
            new TransfertCompta();

            TransfertCompta var3;
            int var4;
            for(var4 = 0; var4 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var4) {
               var3 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var4);
               if (this.exercicesComptable.getExecptEtat() != 0) {
                  var18 = 1;
                  break;
               }

               if (var3.getTrfDateSaisie().getYear() + 1900 < this.exercicesComptable.getExecptDateDebut().getYear() + 1900 || var3.getTrfDateSaisie().getYear() + 1900 > this.exercicesComptable.getExecptDateFin().getYear() + 1900) {
                  var18 = 2;
                  break;
               }
            }

            if (var18 == 1) {
               this.formRecherche.setMessageTexte("L'exercice concerné est déjà cloturé. L'importation est impossible...");
               this.formRecherche.setShowModalPanelMessage(true);
            } else if (var18 == 2) {
               this.formRecherche.setMessageTexte("Les écritures n'appartiennent pas à l'exercice " + this.exercicesComptable.getExecpt_id() + ". L'importation est impossible...");
               this.formRecherche.setShowModalPanelMessage(true);
            } else {
               var4 = this.formTransfertCompta.getLesTransfertCompta().size();
               this.anExiste = false;
               if (this.balance == 0) {
                  this.verifAnalytique();
               }

               if (((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(0)).getTrfTypeImport() != null && !((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(0)).getTrfTypeImport().isEmpty() && ((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(0)).getTrfTypeImport().equals("SPC-ELEVE")) {
                  this.importationEleve();
               } else if (((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(0)).getTrfTypeImport() != null && !((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(0)).getTrfTypeImport().isEmpty() && ((TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(0)).getTrfTypeImport().equals("BALANCE")) {
                  this.nettoyageAvantImport();
               }

               String var5 = this.chronoTransfert();
               Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresCaisse");
               Transaction var7 = null;

               try {
                  var7 = var6.beginTransaction();
                  var6.setFlushMode(FlushMode.MANUAL);
                  this.var_debit = 0.0D;
                  this.var_credit = 0.0D;
                  Brouillard var8 = null;
                  new TransfertCompta();

                  for(int var9 = 0; var9 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var9) {
                     var3 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var9);
                     this.formTransfertCompta.setVar_info("Ligne : " + var9 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
                     if (var9 != 0) {
                        this.formTransfertCompta.setVar_currentValue(100 / (var4 / var9));
                     }

                     if (this.balance == 0 || this.balance == 1 && (!var3.getTrfCode().equals("AN") || var3.getTrfCode().equals("AN") && !this.anExiste)) {
                        this.verifJournal(var3.getTrfCode(), (String)null, 99, (String)null, var6);
                        if (var3.getTrfTypeImport() == null || var3.getTrfTypeImport().isEmpty() || !var3.getTrfTypeImport().equals("SPC-ELEVE") && !var3.getTrfTypeImport().equals("SPC-VACAT")) {
                           if (var3.getTrfTypeImport() != null && !var3.getTrfTypeImport().isEmpty() && var3.getTrfTypeImport().equals("BALANCE")) {
                              this.verifNumcompte(var3.getTrfCompte(), "", var3.getTrfDateSaisie(), var3.getTrfLibelle(), var6);
                           } else if (var3.getTrfSuite() != null && !var3.getTrfSuite().isEmpty()) {
                              this.verifNumcompte(var3.getTrfCompte(), "", var3.getTrfDateSaisie(), var3.getTrfSuite(), var6);
                           } else {
                              this.verifNumcompte(var3.getTrfCompte(), var3.getTrfDateSaisie(), var6);
                           }
                        } else {
                           this.verifNumcompte(var3.getTrfCompte(), "", var3.getTrfDateSaisie(), var3.getTrfParc(), var6);
                        }

                        String var10 = "";
                        if (this.balance == 1) {
                           var10 = var3.getTrfPiece();
                        } else if (var3.getTrfPiece() != null && !var3.getTrfPiece().isEmpty()) {
                           var10 = var3.getTrfPiece();
                        } else {
                           var10 = this.numComposeJournal(var3.getTrfCode(), var3.getTrfDateSaisie(), var3.getTrfReference1(), var6);
                        }

                        if (this.balance == 0 && this.var_debit == this.var_credit && this.var_debit - this.var_credit == 0.0D) {
                           if (this.optionComptabilite.getBrouillardImport().equals("1")) {
                              var8 = this.genererBrouillard(var6, var5, var3.getTrfIdOrigine(), "IM", var3.getTrfCode(), var10, var3.getTrfDateSaisie(), var3.getTrfLibelle(), var3.getTrfReference1(), var3.getTrfReference2(), var3.getTrfDebitSaisie(), var3.getTrfCreditSaisie(), var3.getTrfIdResponsable(), var3.getTrfNomResponsable());
                           } else {
                              var8 = null;
                           }
                        }

                        Ecritures var11 = null;
                        if (this.balance == 1 && var3.getTrfCode().equals("OD") && (var3.getTrfDebitMvts() != 0.0D || var3.getTrfCreditMvts() != 0.0D)) {
                           var3.setTrfDebitSaisie(var3.getTrfDebitMvts());
                           var3.setTrfCreditSaisie(var3.getTrfCreditMvts());
                        }

                        var11 = this.genererEcriture(var6, var8, var5, var3.getTrfIdOrigine(), "IM", var3.getTrfCode(), var3.getTrfCompte(), var10, var3.getTrfDateSaisie(), var3.getTrfLibelle(), var3.getTrfReference1(), var3.getTrfReference2(), var3.getTrfDebitSaisie(), var3.getTrfCreditSaisie(), var3.getTrfDateEcheance(), var3.getTrfBudget(), var3.getTrfLettre(), var3.getTrfTreso(), var3.getTrfDossier());
                        this.var_debit += var11.getEcrDebitPays();
                        this.var_credit += var11.getEcrCreditPays();
                        if (this.balance == 0 && var11.getEcrAnaActif() == 1) {
                           this.ventilationAnalytique(var3, var11, var6);
                        }
                     }
                  }

                  var7.commit();
               } catch (HibernateException var15) {
                  if (var7 != null) {
                     var7.rollback();
                  }

                  throw var15;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }
         }
      } else {
         this.importSuitePlanComptble((double)this.formTransfertCompta.getLesTransfertCompta().size());
      }

      this.formTransfertCompta.setVar_showBarProg(false);
   }

   public void importSuitePlanComptble(double var1) throws IOException, JDOMException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ImportationPlanComptable");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         var3.setFlushMode(FlushMode.MANUAL);
         this.var_debit = 0.0D;
         this.var_credit = 0.0D;
         new TransfertCompta();
         this.tiers = new Tiers();

         for(int var6 = 0; var6 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var6) {
            TransfertCompta var5 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var6);
            this.formTransfertCompta.setVar_info("Ligne : " + var6 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var6 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var6)));
            }

            this.verifNumcompte(var5.getTrfCompte(), var5.getTrfCp(), var5.getTrfDateSaisie(), var5.getTrfLibelle(), var3);
            this.verifTiers(var5.getTrfCompte(), var5.getTrfCp(), var5.getTrfDateSaisie(), var5.getTrfLibelle(), this.tiers, var3);
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

   public void importSuiteJournauxComptbles(double var1) throws IOException, JDOMException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ImportationPlanComptable");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         var3.setFlushMode(FlushMode.MANUAL);
         this.var_debit = 0.0D;
         this.var_credit = 0.0D;
         new TransfertCompta();
         this.tiers = new Tiers();

         for(int var6 = 0; var6 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var6) {
            TransfertCompta var5 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var6);
            this.formTransfertCompta.setVar_info("Ligne : " + var6 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var6 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var6)));
            }

            this.verifJournal(var5.getTrfCode(), var5.getTrfCp(), var5.getTrfCategorie(), var5.getTrfLibelle(), var3);
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

   public void importSuiteImmobilisation(double var1) throws HibernateException, NamingException, IOException, JDOMException {
      int var3 = 0;
      this.amortissements = new Amortissements();
      this.amortissementsDao = new AmortissementsDao(this.baseLog, this.utilInitHibernate);
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         var4.setFlushMode(FlushMode.MANUAL);
         this.var_debit = 0.0D;
         this.var_credit = 0.0D;
         new TransfertCompta();
         this.tiers = new Tiers();
         int var7 = 0;

         for(int var8 = 0; var8 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var8) {
            TransfertCompta var6 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var8);
            ++var7;
            this.formTransfertCompta.setVar_info("Ligne : " + var8 + " sur : " + this.formTransfertCompta.getLesTransfertCompta().size());
            if (var8 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var8)));
            }

            this.verifNumcompte(var6.getTrfCompte(), var6.getTrfDateSaisie(), var4);
            this.verifNumcompte(var6.getTrfCp(), var6.getTrfDateSaisie(), var4);
            this.verifNumcompte(var6.getTrfBudget(), var6.getTrfDateSaisie(), var4);
            this.verifLieu(var6.getTrfDossier(), var4);
            this.amortissements = new Amortissements();
            this.amortissements.setAmoActivite("");
            this.amortissements.setAmoAgent("");
            this.amortissements.setAmoAnterieur(0.0D);
            this.amortissements.setAmoBudget("");
            this.amortissements.setAmoCede(0.0D);
            this.amortissements.setAmoChassis("");
            this.amortissements.setAmoCle1("");
            this.amortissements.setAmoCompteAmo(var6.getTrfCp());
            this.amortissements.setAmoCompteImmo(var6.getTrfCompte());
            this.amortissements.setAmoCompteDotation(var6.getTrfBudget());
            this.amortissements.setAmoCompteCes("");
            this.amortissements.setAmoDateAchat(var6.getTrfDateSaisie());
            this.amortissements.setAmoDateAnterieur((Date)null);
            this.amortissements.setAmoDateCreat(new Date());
            this.amortissements.setAmoDateModif((Date)null);
            this.amortissements.setAmoDateReevalue((Date)null);
            this.amortissements.setAmoDateService(var6.getTrfDateValeurTheo());
            this.amortissements.setAmoDateSortie((Date)null);
            this.amortissements.setAmoDepartement("");
            this.amortissements.setAmoDossier("");
            this.amortissements.setAmoDotation(0.0D);
            this.amortissements.setAmoFactureAchat("");
            this.amortissements.setAmoFactureCession("");
            this.amortissements.setAmoFinancement(0);
            this.amortissements.setAmoFournisseur("");
            this.amortissements.setAmoFraisAnnexe(0.0D);
            this.amortissements.setAmoHorsExp(0.0D);
            this.amortissements.setAmoIdReception(0L);
            this.amortissements.setAmoInactif(0);
            this.amortissements.setAmoInfosCpl("");
            this.amortissements.setAmoLibActivite("");
            this.amortissements.setAmoLibAgent("");
            this.amortissements.setAmoLibBudget("");
            if (this.amortissements.getAmoCompteAmo() != null && !this.amortissements.getAmoCompteAmo().isEmpty()) {
               this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, this.amortissements.getAmoCompteAmo(), this.exercicesComptable.getExecpt_id(), var4);
               if (this.planComptable != null) {
                  this.amortissements.setAmoLibCompteAmo(this.planComptable.getPlcLibelleCpteFR());
               } else {
                  this.amortissements.setAmoLibCompteAmo("");
               }
            } else {
               this.amortissements.setAmoLibCompteAmo("");
            }

            if (this.amortissements.getAmoCompteImmo() != null && !this.amortissements.getAmoCompteImmo().isEmpty()) {
               this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, this.amortissements.getAmoCompteImmo(), this.exercicesComptable.getExecpt_id(), var4);
               if (this.planComptable != null) {
                  this.amortissements.setAmoLibCompteImo(this.planComptable.getPlcLibelleCpteFR());
               } else {
                  this.amortissements.setAmoLibCompteImo("");
               }
            } else {
               this.amortissements.setAmoLibCompteImo("");
            }

            if (this.amortissements.getAmoCompteDotation() != null && !this.amortissements.getAmoCompteDotation().isEmpty()) {
               this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, this.amortissements.getAmoCompteDotation(), this.exercicesComptable.getExecpt_id(), var4);
               if (this.planComptable != null) {
                  this.amortissements.setAmoLibCompteDot(this.planComptable.getPlcLibelleCpteFR());
               } else {
                  this.amortissements.setAmoLibCompteDot("");
               }
            } else {
               this.amortissements.setAmoLibCompteDot("");
            }

            this.amortissements.setAmoLibCompteCes("");
            this.amortissements.setAmoLibDepartement("");
            this.amortissements.setAmoLibDossier("");
            this.amortissements.setAmoLibelle(var6.getTrfLibelle());
            this.amortissements.setAmoLibMission("");
            this.amortissements.setAmoLibParc("");
            this.amortissements.setAmoLibPdv("");
            this.amortissements.setAmoLibProjet("");
            this.amortissements.setAmoLibRegion("");
            this.amortissements.setAmoLibSecteur("");
            this.amortissements.setAmoLibService("");
            this.amortissements.setAmoMission("");
            this.amortissements.setAmoMode(0);
            this.amortissements.setAmoNature(0);
            this.amortissements.setAmoNatureDetail(0);
            String var9 = "" + this.utilNombre.myConvertString(var6.getTrfDebitMvts(), 0);
            String var10 = "" + this.utilNombre.myConvertString(var6.getTrfCreditMvts(), 0);
            this.amortissements.setAmoNbAnneeCpte(Float.parseFloat(var9 + "." + var10));
            this.amortissements.setAmoNbAnneeFiscal(0.0F);
            this.amortissements.setAmoNetAPayer(0.0D);
            this.amortissements.setAmoNomClient("");
            if (this.verifNumerique(var6.getTrfCode())) {
               this.amortissements.setAmoNum((long)Integer.parseInt(var6.getTrfCode()));
            } else {
               this.amortissements.setAmoNum((long)var7);
            }

            this.amortissements.setAmoOldId(0L);
            this.amortissements.setAmoOrigine("");
            this.amortissements.setAmoParc("");
            this.amortissements.setAmoPdv("");
            this.amortissements.setAmoPeriodeDeb((Date)null);
            this.amortissements.setAmoPeriodeFin((Date)null);
            this.amortissements.setAmoPhoto((String)null);
            this.amortissements.setAmoPieceAchat("");
            this.amortissements.setAmoPieceCession("");
            this.amortissements.setAmoProjet("");
            this.amortissements.setAmoReference(var6.getTrfCode());
            this.amortissements.setAmoRegion("");
            this.amortissements.setAmoReinvestissement(0);
            this.amortissements.setAmoScan((String)null);
            this.amortissements.setAmoSecteur("");
            this.amortissements.setAmoService("");
            this.amortissements.setAmoSite("");
            this.amortissements.setAmoSolde(0.0D);
            if (this.amortissements.getAmoNbAnneeCpte() != 0.0F) {
               this.amortissements.setAmoTauxComptable(100.0F / this.amortissements.getAmoNbAnneeCpte());
            } else {
               this.amortissements.setAmoTauxComptable(0.0F);
            }

            this.amortissements.setAmoTauxFiscal(0.0F);
            this.amortissements.setAmoTotalAmort(0.0D);
            this.amortissements.setAmoTotalReglement(0.0D);
            this.amortissements.setAmoTvaResiduelle(0.0D);
            this.amortissements.setAmoTvaTaux(0.0F);
            this.amortissements.setAmoTvaTotal(0.0D);
            this.amortissements.setAmoTypeSortie(0);
            this.amortissements.setAmoUserCreat(this.usersLog.getUsrid());
            this.amortissements.setAmoUserModif(0);
            this.amortissements.setAmoUserModif(0);
            this.amortissements.setAmoValeurAchat(var6.getTrfDebitSaisie());
            this.amortissements.setAmoValeurCession(0.0D);
            this.amortissements.setAmoValeurReevalue(0.0D);
            this.amortissements.setAmoValeurResiduelle(var6.getTrfCreditSaisie());
            this.amortissements = this.amortissementsDao.insert(this.amortissements, var4);
            ++var3;
            if (var3 == this.cpteMaxFlush) {
               var4.flush();
               var3 = 0;
            }
         }

         var4.flush();
         var5.commit();
      } catch (HibernateException var14) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var14;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public boolean verifNumerique(String var1) {
      boolean var2 = true;

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         String var4 = (String)var1.subSequence(var3, var3 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXY".contains(var4)) {
            var2 = false;
            break;
         }
      }

      return var2;
   }

   public void importationEleve() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      boolean var1 = false;
      new ExercicesVentes();
      ExercicesVentesDao var3 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var2 = var3.recupererLastExo((Session)null);
      if (var2 != null) {
         new Eleves();
         ElevesDao var5 = new ElevesDao(this.baseLog, this.utilInitHibernate);
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();
            var6.setFlushMode(FlushMode.MANUAL);

            for(int var8 = 0; var8 < this.formTransfertCompta.getLesTransfertCompta().size(); ++var8) {
               new TransfertCompta();
               TransfertCompta var9 = (TransfertCompta)this.formTransfertCompta.getLesTransfertCompta().get(var8);
               if (var9.getTrfSuite() != null && !var9.getTrfSuite().isEmpty()) {
                  this.verifNumcompte(var9.getTrfCompte(), "", var9.getTrfDateSaisie(), var9.getTrfSuite(), var6);
                  Eleves var4 = var5.getElevesByCompte(var9.getTrfCompte(), var6);
                  if (var4 == null) {
                     var4 = new Eleves();
                     var4.setEleDossier(var9.getTrfCompte().substring(2, 10));
                     var4.setEleCompte0(var9.getTrfCompte());
                     var4.setEleCivilite("Monsieur");
                     var4.setElePays(this.structureLog.getStrnompays());
                     var4.setEleNom(var9.getTrfSuite());
                     var5.insert(var4, var6);
                  }
               }
            }

            var6.flush();
            var7.commit();
            var1 = true;
         } catch (HibernateException var13) {
            var1 = false;
            if (var7 != null) {
               var7.rollback();
            }

            throw var13;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void nettoyageAvantImport() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresCaisse");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         var1.setFlushMode(FlushMode.MANUAL);
         this.formTransfertCompta.setVar_info("Nettoyage avant importation...");
         String var3 = "";
         var3 = "01:" + (this.exercicesComptable.getExecptDateFin().getYear() + 1900);
         new ArrayList();
         List var4 = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiquesByJournal(var3, "AN", var1);
         if (var4.size() != 0) {
            this.ecrituresAnalytiquesDao.nettoyageAnalytiqueByEcriture(var4, var1);
            var1.flush();
         }

         new ArrayList();
         List var5 = this.ecrituresDao.ChargerLesEcrituresJrPeriode("AN", var3, var1);
         if (var5.size() != 0) {
            this.ecrituresDao.removeSelectedEC2(var5, 100, var1);
            var1.flush();
         }

         this.anExiste = false;
         var3 = "12:" + (this.exercicesComptable.getExecptDateFin().getYear() + 1900);
         new ArrayList();
         List var6 = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiquesByJournal(var3, "OD", var1);
         if (var6.size() != 0) {
            this.ecrituresAnalytiquesDao.nettoyageAnalytiqueByEcriture(var6, var1);
            var1.flush();
         }

         new ArrayList();
         List var7 = this.ecrituresDao.ChargerLesEcrituresJrPeriode("OD", var3, var1);
         if (var7.size() != 0) {
            this.ecrituresDao.removeSelectedEC2(var7, 100, var1);
            var1.flush();
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

   public void ventilationAnalytique(TransfertCompta var1, Ecritures var2, Session var3) throws HibernateException, NamingException {
      if (this.optionComptabilite.getAnalytique().equals("true")) {
         boolean var4 = this.testCompteAnalytique(var2.getEcrCompte(), var3);
         if (var4) {
            if (var1.getTrfSite() != null && !var1.getTrfSite().isEmpty() || var1.getTrfDepartement() != null && !var1.getTrfDepartement().isEmpty() || var1.getTrfService() != null && !var1.getTrfService().isEmpty()) {
               this.verifSite(var1.getTrfSite(), var3);
               this.verifDepartement(var1.getTrfSite(), var1.getTrfDepartement(), var3);
               this.verifService(var1.getTrfSite(), var1.getTrfDepartement(), var1.getTrfService(), var3);
               this.analyseImputationDirecteSite(var1, var2, var3);
               var3.flush();
            }

            if (var1.getTrfRegion() != null && !var1.getTrfRegion().isEmpty() || var1.getTrfSecteur() != null && !var1.getTrfSecteur().isEmpty() || var1.getTrfPdv() != null && !var1.getTrfPdv().isEmpty()) {
               this.verifRegion(var1.getTrfRegion(), var3);
               this.verifSecteur(var1.getTrfRegion(), var1.getTrfSecteur(), var3);
               this.verifPDV(var1.getTrfRegion(), var1.getTrfSecteur(), var1.getTrfPdv(), var3);
               this.analyseImputationDirecteRegion(var1, var2, var3);
               var3.flush();
            }

            if (var1.getTrfSitePrd() != null && !var1.getTrfSitePrd().isEmpty() || var1.getTrfLigne() != null && !var1.getTrfLigne().isEmpty() || var1.getTrfAtelier() != null && !var1.getTrfAtelier().isEmpty()) {
               this.verifSite(var1.getTrfSitePrd(), var3);
               this.verifLigne(var1.getTrfSitePrd(), var1.getTrfLigne(), var3);
               this.verifAtelier(var1.getTrfSitePrd(), var1.getTrfLigne(), var1.getTrfAtelier(), var3);
               this.analyseImputationDirecteProduction(var1, var2, var3);
               var3.flush();
            }

            if (var1.getTrfAgent() != null && !var1.getTrfAgent().isEmpty()) {
               this.verifAgent(var1.getTrfAgent(), var3);
            }

            if (var1.getTrfActivite() != null && !var1.getTrfActivite().isEmpty()) {
               this.verifActivite(var1.getTrfActivite(), var3);
               this.analyseImputationDirecteActivite(var1, var2, var3);
               var3.flush();
            }

            if (var1.getTrfChantier() != null && !var1.getTrfChantier().isEmpty()) {
               this.verifChantier(var1.getTrfChantier(), var3);
               this.analyseImputationDirecteChantier(var1, var2, var3);
               var3.flush();
            }

            if (var1.getTrfParc() != null && !var1.getTrfParc().isEmpty()) {
               String[] var5;
               if (var1.getTrfParc().contains("#")) {
                  var5 = var1.getTrfParc().split("#");
                  int var12 = var5.length;

                  for(int var7 = 0; var7 < var12; ++var7) {
                     String[] var8 = var5[var7].split(":");
                     this.verifParc(var8[0], var3);
                     double var9 = Double.parseDouble(var8[3]);
                     this.analyseImputationDirecteParc(var8[0], var9, var1, var2, var3);
                     var3.flush();
                  }
               } else if (var1.getTrfParc().contains(":")) {
                  var5 = var1.getTrfParc().split(":");
                  this.verifParc(var5[0], var3);
                  double var6 = var1.getTrfCreditSaisie() + var1.getTrfDebitSaisie();
                  this.analyseImputationDirecteParc(var5[0], var6, var1, var2, var3);
                  var3.flush();
               } else if (var1.getTrfParc() != null && !var1.getTrfParc().isEmpty()) {
                  this.verifParc(var1.getTrfParc(), var3);
                  double var11 = var1.getTrfCreditSaisie() + var1.getTrfDebitSaisie();
                  this.analyseImputationDirecteParc(var1.getTrfParc(), var11, var1, var2, var3);
                  var3.flush();
               }
            }

            if (var1.getTrfMission() != null && !var1.getTrfMission().isEmpty()) {
               this.verifMission(var1.getTrfMission(), var3);
               this.analyseImputationDirecteMission(var1, var2, var3);
               var3.flush();
            }

            if (var1.getTrfDossier() != null && !var1.getTrfDossier().isEmpty() && this.structureLog.getStrDossier() == 1) {
               this.verifDossier(var1.getTrfDossier(), var1.getTrfLibelle(), var1.getTrfDateSaisie(), var3);
               this.analyseImputationDirecteDossier(var1, var2, var3);
               var3.flush();
            }

            if (var1.getTrfProjet() != null && !var1.getTrfProjet().isEmpty()) {
            }

            if (var1.getTrfRepartitionCle1() != null && !var1.getTrfRepartitionCle1().isEmpty()) {
               this.analyseCle(var1.getTrfRepartitionCle1(), var2, var3);
               var3.flush();
            }

            if (var1.getTrfRepartitionCle2() != null && !var1.getTrfRepartitionCle2().isEmpty()) {
               this.analyseCle(var1.getTrfRepartitionCle2(), var2, var3);
               var3.flush();
            }

            if (var1.getTrfStructure() != null && !var1.getTrfStructure().isEmpty()) {
               this.analyseCleStructure(var1.getTrfStructure(), var2, var3);
               var3.flush();
            }
         }
      }

   }

   public void importImmobilisationLibre(double var1) throws HibernateException, NamingException, ParseException {
      String var3 = "";
      String var4 = "";
      String var5 = "";
      String var6 = "";
      String var7 = "";
      String var8 = "";
      String var9 = "";
      String var10 = "";
      String var11 = "";
      String var12 = "";
      String var13 = "";
      String var14 = "";
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
      String var31 = "";
      String var32 = "";
      String var33 = "";
      String var34 = "";
      String var35 = "";
      String var36 = "";
      String var37 = "";
      String var38 = "";
      String var39 = "";
      String var40 = "";
      String var41 = "";
      String var42 = "";
      String var43 = "";
      String var44 = "";
      String var45 = "";
      boolean var46 = false;
      this.amortissements = new Amortissements();
      this.amortissementsDao = new AmortissementsDao(this.baseLog, this.utilInitHibernate);
      Session var47 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
      Transaction var48 = null;

      try {
         var48 = var47.beginTransaction();
         var47.setFlushMode(FlushMode.MANUAL);
         this.transfertVentes = new TransfertVentes();
         this.tiers = new Tiers();
         int var49 = 0;
         int var50 = 0;

         while(true) {
            if (var50 >= this.formTransfertCompta.getLesTransfertVentes().size()) {
               var48.commit();
               break;
            }

            this.transfertVentes = (TransfertVentes)this.formTransfertCompta.getLesTransfertVentes().get(var50);
            ++var49;
            this.formTransfertCompta.setVar_info("Ligne : " + var50 + " sur : " + this.formTransfertCompta.getLesTransfertVentes().size());
            if (var50 != 0) {
               this.formTransfertCompta.setVar_currentValue((int)(100.0D / (var1 / (double)var50)));
            }

            if (var50 == 0) {
               var5 = this.transfertVentes.getTrfColT00();
               var6 = this.transfertVentes.getTrfColT01();
               var7 = this.transfertVentes.getTrfColT02();
               var8 = this.transfertVentes.getTrfColT03();
               var9 = this.transfertVentes.getTrfColT04();
               var10 = this.transfertVentes.getTrfColT05();
               var11 = this.transfertVentes.getTrfColT06();
               var12 = this.transfertVentes.getTrfColT07();
               var13 = this.transfertVentes.getTrfColT08();
               var14 = this.transfertVentes.getTrfColT09();
               var15 = this.transfertVentes.getTrfColT10();
               var16 = this.transfertVentes.getTrfColT11();
               var17 = this.transfertVentes.getTrfColT12();
               var18 = this.transfertVentes.getTrfColT13();
               var19 = this.transfertVentes.getTrfColT14();
               var20 = this.transfertVentes.getTrfColT15();
               var21 = this.transfertVentes.getTrfColT16();
               var22 = this.transfertVentes.getTrfColT17();
               var23 = this.transfertVentes.getTrfColT18();
               var24 = this.transfertVentes.getTrfColT19();
               var25 = this.transfertVentes.getTrfColT20();
               var26 = this.transfertVentes.getTrfColT21();
               var27 = this.transfertVentes.getTrfColT22();
               var28 = this.transfertVentes.getTrfColT23();
               var29 = this.transfertVentes.getTrfColT24();
               var30 = this.transfertVentes.getTrfColT25();
               var31 = this.transfertVentes.getTrfColT26();
               var32 = this.transfertVentes.getTrfColT27();
               var33 = this.transfertVentes.getTrfColT28();
               var34 = this.transfertVentes.getTrfColT29();
               var35 = this.transfertVentes.getTrfColT30();
               var36 = this.transfertVentes.getTrfColT31();
               var37 = this.transfertVentes.getTrfColT32();
               var38 = this.transfertVentes.getTrfColT33();
               var39 = this.transfertVentes.getTrfColT34();
               var40 = this.transfertVentes.getTrfColT35();
               var41 = this.transfertVentes.getTrfColT36();
               var42 = this.transfertVentes.getTrfColT37();
               var43 = this.transfertVentes.getTrfColT38();
               var44 = this.transfertVentes.getTrfColT39();
               var45 = this.transfertVentes.getTrfColT40();
            } else {
               boolean var51 = false;
               var51 = this.recherhceImmobilisation(this.transfertVentes.getTrfColT00(), var47);
               if (var6 != null && !var6.isEmpty()) {
                  this.calculeRubImmobilisation(var6, this.transfertVentes.getTrfColT01(), var47);
               }

               if (var7 != null && !var7.isEmpty()) {
                  this.calculeRubImmobilisation(var7, this.transfertVentes.getTrfColT02(), var47);
               }

               if (var8 != null && !var8.isEmpty()) {
                  this.calculeRubImmobilisation(var8, this.transfertVentes.getTrfColT03(), var47);
               }

               if (var9 != null && !var9.isEmpty()) {
                  this.calculeRubImmobilisation(var9, this.transfertVentes.getTrfColT04(), var47);
               }

               if (var10 != null && !var10.isEmpty()) {
                  this.calculeRubImmobilisation(var10, this.transfertVentes.getTrfColT05(), var47);
               }

               if (var11 != null && !var11.isEmpty()) {
                  this.calculeRubImmobilisation(var11, this.transfertVentes.getTrfColT06(), var47);
               }

               if (var12 != null && !var12.isEmpty()) {
                  this.calculeRubImmobilisation(var12, this.transfertVentes.getTrfColT07(), var47);
               }

               if (var13 != null && !var13.isEmpty()) {
                  this.calculeRubImmobilisation(var13, this.transfertVentes.getTrfColT08(), var47);
               }

               if (var14 != null && !var14.isEmpty()) {
                  this.calculeRubImmobilisation(var14, this.transfertVentes.getTrfColT09(), var47);
               }

               if (var15 != null && !var15.isEmpty()) {
                  this.calculeRubImmobilisation(var15, this.transfertVentes.getTrfColT10(), var47);
               }

               if (var16 != null && !var16.isEmpty()) {
                  this.calculeRubImmobilisation(var16, this.transfertVentes.getTrfColT11(), var47);
               }

               if (var17 != null && !var17.isEmpty()) {
                  this.calculeRubImmobilisation(var17, this.transfertVentes.getTrfColT12(), var47);
               }

               if (var18 != null && !var18.isEmpty()) {
                  this.calculeRubImmobilisation(var18, this.transfertVentes.getTrfColT13(), var47);
               }

               if (var19 != null && !var19.isEmpty()) {
                  this.calculeRubImmobilisation(var19, this.transfertVentes.getTrfColT14(), var47);
               }

               if (var20 != null && !var20.isEmpty()) {
                  this.calculeRubImmobilisation(var20, this.transfertVentes.getTrfColT15(), var47);
               }

               if (var21 != null && !var21.isEmpty()) {
                  this.calculeRubImmobilisation(var21, this.transfertVentes.getTrfColT16(), var47);
               }

               if (var22 != null && !var22.isEmpty()) {
                  this.calculeRubImmobilisation(var22, this.transfertVentes.getTrfColT17(), var47);
               }

               if (var23 != null && !var23.isEmpty()) {
                  this.calculeRubImmobilisation(var23, this.transfertVentes.getTrfColT18(), var47);
               }

               if (var24 != null && !var24.isEmpty()) {
                  this.calculeRubImmobilisation(var24, this.transfertVentes.getTrfColT19(), var47);
               }

               if (var25 != null && !var25.isEmpty()) {
                  this.calculeRubImmobilisation(var25, this.transfertVentes.getTrfColT20(), var47);
               }

               if (var26 != null && !var26.isEmpty()) {
                  this.calculeRubImmobilisation(var26, this.transfertVentes.getTrfColT21(), var47);
               }

               if (var27 != null && !var27.isEmpty()) {
                  this.calculeRubImmobilisation(var27, this.transfertVentes.getTrfColT22(), var47);
               }

               if (var28 != null && !var28.isEmpty()) {
                  this.calculeRubImmobilisation(var28, this.transfertVentes.getTrfColT23(), var47);
               }

               if (var29 != null && !var29.isEmpty()) {
                  this.calculeRubImmobilisation(var29, this.transfertVentes.getTrfColT24(), var47);
               }

               if (var30 != null && !var30.isEmpty()) {
                  this.calculeRubImmobilisation(var30, this.transfertVentes.getTrfColT25(), var47);
               }

               if (var31 != null && !var31.isEmpty()) {
                  this.calculeRubImmobilisation(var31, this.transfertVentes.getTrfColT26(), var47);
               }

               if (var32 != null && !var32.isEmpty()) {
                  this.calculeRubImmobilisation(var32, this.transfertVentes.getTrfColT27(), var47);
               }

               if (var33 != null && !var33.isEmpty()) {
                  this.calculeRubImmobilisation(var33, this.transfertVentes.getTrfColT28(), var47);
               }

               if (var34 != null && !var34.isEmpty()) {
                  this.calculeRubImmobilisation(var34, this.transfertVentes.getTrfColT29(), var47);
               }

               if (var35 != null && !var35.isEmpty()) {
                  this.calculeRubImmobilisation(var35, this.transfertVentes.getTrfColT30(), var47);
               }

               if (var36 != null && !var36.isEmpty()) {
                  this.calculeRubImmobilisation(var36, this.transfertVentes.getTrfColT31(), var47);
               }

               if (var37 != null && !var37.isEmpty()) {
                  this.calculeRubImmobilisation(var37, this.transfertVentes.getTrfColT32(), var47);
               }

               if (var38 != null && !var38.isEmpty()) {
                  this.calculeRubImmobilisation(var38, this.transfertVentes.getTrfColT33(), var47);
               }

               if (var39 != null && !var39.isEmpty()) {
                  this.calculeRubImmobilisation(var39, this.transfertVentes.getTrfColT34(), var47);
               }

               if (var40 != null && !var40.isEmpty()) {
                  this.calculeRubImmobilisation(var40, this.transfertVentes.getTrfColT35(), var47);
               }

               if (var41 != null && !var41.isEmpty()) {
                  this.calculeRubImmobilisation(var41, this.transfertVentes.getTrfColT36(), var47);
               }

               if (var42 != null && !var42.isEmpty()) {
                  this.calculeRubImmobilisation(var42, this.transfertVentes.getTrfColT37(), var47);
               }

               if (var43 != null && !var43.isEmpty()) {
                  this.calculeRubImmobilisation(var43, this.transfertVentes.getTrfColT38(), var47);
               }

               if (var44 != null && !var44.isEmpty()) {
                  this.calculeRubImmobilisation(var44, this.transfertVentes.getTrfColT39(), var47);
               }

               if (var45 != null && !var45.isEmpty()) {
                  this.calculeRubImmobilisation(var45, this.transfertVentes.getTrfColT40(), var47);
               }

               if (!var51) {
                  if (this.amortissements.getAmoNum() == 0L) {
                     this.amortissements.setAmoNum(this.amortissementsDao.trouverDernier(var47));
                  }

                  this.amortissements.setAmoDateCreat(new Date());
                  this.amortissements.setAmoUserCreat(this.usersLog.getUsrid());
                  this.amortissements = this.amortissementsDao.insert(this.amortissements, var47);
               } else {
                  this.amortissements.setAmoDateModif(new Date());
                  this.amortissements.setAmoUserModif(this.usersLog.getUsrid());
                  this.amortissements = this.amortissementsDao.modif(this.amortissements, var47);
               }

               var47.flush();
            }

            ++var50;
         }
      } catch (HibernateException var55) {
         if (var48 != null) {
            var48.rollback();
         }

         throw var55;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.formTransfertCompta.getDataModelTransfertErreur().setWrappedData(this.lesErreurs);
      this.formTransfertCompta.setBalance(2);
   }

   public boolean recherhceImmobilisation(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      var1 = this.enlevePoint(var1);
      long var4 = Long.parseLong(var1);
      this.amortissements = this.amortissementsDao.trouverImmobilisationByNum(var4, var2);
      if (this.amortissements != null) {
         var3 = true;
      } else {
         this.amortissements = new Amortissements();
         var3 = false;
      }

      return var3;
   }

   public void calculeRubImmobilisation(String var1, String var2, Session var3) throws ParseException, HibernateException, NamingException {
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("amo_old_id")) {
         this.amortissements.setAmoOldId(this.conversionLong(var2));
      } else if (var1.equalsIgnoreCase("amo_id_reception")) {
         this.amortissements.setAmoIdReception(this.conversionLong(var2));
      } else if (!var1.equalsIgnoreCase("amo_date_creat") && !var1.equalsIgnoreCase("amo_date_modif") && !var1.equalsIgnoreCase("amo_user_creat") && !var1.equalsIgnoreCase("amo_user_modif")) {
         if (var1.equalsIgnoreCase("amo_num")) {
            this.amortissements.setAmoNum(this.conversionLong(var2));
         } else if (var1.equalsIgnoreCase("amo_libelle")) {
            if (var2 != null && !var2.isEmpty()) {
               this.amortissements.setAmoLibelle(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("amo_date_achat")) {
            this.amortissements.setAmoDateAchat(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("amo_date_service")) {
            this.amortissements.setAmoDateService(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("amo_valeur_achat")) {
            this.amortissements.setAmoValeurAchat(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("amo_valeur_reevalue")) {
            this.amortissements.setAmoValeurReevalue(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("amo_date_reevalue")) {
            this.amortissements.setAmoDateReevalue(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("amo_tva_taux")) {
            this.amortissements.setAmoTvaTaux((float)this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("amo_tva_total")) {
            this.amortissements.setAmoTvaTotal(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("amo_tva_residuelle")) {
            this.amortissements.setAmoTvaResiduelle(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("amo_mode")) {
            this.amortissements.setAmoMode(this.conversionInteger(var2));
         } else if (var1.equalsIgnoreCase("amo_taux_comptable")) {
            this.amortissements.setAmoTauxComptable((float)this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("amo_nb_annee_cpte")) {
            this.amortissements.setAmoNbAnneeCpte((float)this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("amo_taux_fiscal")) {
            this.amortissements.setAmoTauxFiscal((float)this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("amo_nb_annee_fiscal")) {
            this.amortissements.setAmoNbAnneeFiscal((float)this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("amo_anterieur")) {
            this.amortissements.setAmoAnterieur(this.conversionDouble(var2));
         } else if (var1.equalsIgnoreCase("amo_date_anterieur")) {
            this.amortissements.setAmoDateAnterieur(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("amo_reference")) {
            if (var2 != null && !var2.isEmpty()) {
               this.amortissements.setAmoReference(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("amo_piece_achat")) {
            if (var2 != null && !var2.isEmpty()) {
               this.amortissements.setAmoPieceAchat(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("amo_chassis")) {
            if (var2 != null && !var2.isEmpty()) {
               this.amortissements.setAmoChassis(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("amo_nature")) {
            this.amortissements.setAmoNature(this.conversionInteger(var2));
         } else if (var1.equalsIgnoreCase("amo_nature_detail")) {
            this.amortissements.setAmoNatureDetail(this.conversionInteger(var2));
         } else if (var1.equalsIgnoreCase("amo_nature_detail_lib")) {
            if (var2 != null && !var2.isEmpty()) {
               this.amortissements.setAmoNatureDetailLib(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("amo_infos_cpl")) {
            if (var2 != null && !var2.isEmpty()) {
               this.amortissements.setAmoInfosCpl(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("amo_origine")) {
            if (var2 != null && !var2.isEmpty()) {
               this.amortissements.setAmoOrigine(this.enlevePoint(var2).toUpperCase());
            }
         } else if (!var1.equalsIgnoreCase("amo_site") && !var1.equalsIgnoreCase("amo_lib_site") && !var1.equalsIgnoreCase("amo_departement") && !var1.equalsIgnoreCase("amo_lib_departement") && !var1.equalsIgnoreCase("amo_service") && !var1.equalsIgnoreCase("amo_lib_service") && !var1.equalsIgnoreCase("amo_region") && !var1.equalsIgnoreCase("amo_lib_region") && !var1.equalsIgnoreCase("amo_secteur") && !var1.equalsIgnoreCase("amo_lib_secteur") && !var1.equalsIgnoreCase("amo_pdv") && !var1.equalsIgnoreCase("amo_lib_pdv") && !var1.equalsIgnoreCase("amo_dossier") && !var1.equalsIgnoreCase("amo_lib_dossier") && !var1.equalsIgnoreCase("amo_mission") && !var1.equalsIgnoreCase("amo_lib_mission") && !var1.equalsIgnoreCase("amo_parc") && !var1.equalsIgnoreCase("amo_lib_parc") && !var1.equalsIgnoreCase("amo_cle1") && !var1.equalsIgnoreCase("amo_lib_cle1") && !var1.equalsIgnoreCase("amo_agent") && !var1.equalsIgnoreCase("amo_lib_agent") && !var1.equalsIgnoreCase("amo_activite") && !var1.equalsIgnoreCase("amo_lib_activite") && !var1.equalsIgnoreCase("amo_projet") && !var1.equalsIgnoreCase("amo_lib_projet") && !var1.equalsIgnoreCase("amo_budget") && !var1.equalsIgnoreCase("amo_lib_budget") && !var1.equalsIgnoreCase("amo_localisation")) {
            if (var1.equalsIgnoreCase("amo_periode_deb")) {
               this.amortissements.setAmoPeriodeDeb(this.conversionDate(var2));
            } else if (var1.equalsIgnoreCase("amo_periode_fin")) {
               this.amortissements.setAmoPeriodeFin(this.conversionDate(var2));
            } else if (var1.equalsIgnoreCase("amo_dotation")) {
               this.amortissements.setAmoDotation(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("amo_total_amort")) {
               this.amortissements.setAmoTotalAmort(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("amo_valeur_residuelle")) {
               this.amortissements.setAmoValeurResiduelle(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("amo_date_sortie")) {
               this.amortissements.setAmoDateSortie(this.conversionDate(var2));
            } else if (var1.equalsIgnoreCase("amo_type_sortie")) {
               this.produits.setProInactif(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("amo_nom_client")) {
               this.produits.setProPhoto(this.enlevePoint(var2));
            } else if (var1.equalsIgnoreCase("amo_valeur_cession")) {
               this.amortissements.setAmoValeurCession(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("amo_frais_annexe")) {
               this.amortissements.setAmoFraisAnnexe(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("amo_reinvestissement")) {
               this.amortissements.setAmoReinvestissement(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("amo_facture_cession")) {
               if (var2 != null && !var2.isEmpty()) {
                  this.amortissements.setAmoFactureCession(this.enlevePoint(var2).toUpperCase());
               }
            } else if (var1.equalsIgnoreCase("amo_piece_cession")) {
               if (var2 != null && !var2.isEmpty()) {
                  this.amortissements.setAmoPieceCession(this.enlevePoint(var2).toUpperCase());
               }
            } else if (var1.equalsIgnoreCase("amo_net_a_payer")) {
               this.amortissements.setAmoNetAPayer(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("amo_total_reglement")) {
               this.amortissements.setAmoTotalReglement(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("amo_solde")) {
               this.amortissements.setAmoSolde(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("amo_financement")) {
               this.amortissements.setAmoFinancement(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("amo_inactif")) {
               this.amortissements.setAmoInactif(this.conversionInteger(var2));
            } else if (var1.equalsIgnoreCase("amo_facture_achat")) {
               if (var2 != null && !var2.isEmpty()) {
                  this.amortissements.setAmoFactureAchat(this.enlevePoint(var2).toUpperCase());
               }
            } else if (var1.equalsIgnoreCase("amo_hors_exp")) {
               this.amortissements.setAmoHorsExp(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("amo_cede")) {
               this.amortissements.setAmoCede(this.conversionDouble(var2));
            } else if (var1.equalsIgnoreCase("amo_compte_ces")) {
               if (var2 != null && !var2.isEmpty()) {
                  this.verifCompte(var2, var3);
                  if (this.planComptable != null) {
                     this.amortissements.setAmoCompteCes(this.planComptable.getPlcCompte());
                     this.amortissements.setAmoLibCompteCes(this.planComptable.getPlcLibelleCpteFR());
                  }
               }
            } else if (!var1.equalsIgnoreCase("amo_lib_compte_ces")) {
               if (var1.equalsIgnoreCase("amo_compte_amo")) {
                  if (var2 != null && !var2.isEmpty()) {
                     this.verifCompte(var2, var3);
                     if (this.planComptable != null) {
                        this.amortissements.setAmoCompteAmo(this.planComptable.getPlcCompte());
                        this.amortissements.setAmoLibCompteAmo(this.planComptable.getPlcLibelleCpteFR());
                     }
                  }
               } else if (!var1.equalsIgnoreCase("amo_lib_compte_amo")) {
                  if (var1.equalsIgnoreCase("amo_compte_dotation")) {
                     if (var2 != null && !var2.isEmpty()) {
                        this.verifCompte(var2, var3);
                        if (this.planComptable != null) {
                           this.amortissements.setAmoCompteDotation(this.planComptable.getPlcCompte());
                           this.amortissements.setAmoLibCompteDot(this.planComptable.getPlcLibelleCpteFR());
                        }
                     }
                  } else if (!var1.equalsIgnoreCase("amo_lib_compte_dot")) {
                     if (var1.equalsIgnoreCase("amo_compte_immo")) {
                        if (var2 != null && !var2.isEmpty()) {
                           this.verifCompte(var2, var3);
                           if (this.planComptable != null) {
                              this.amortissements.setAmoCompteImmo(this.planComptable.getPlcCompte());
                              this.amortissements.setAmoLibCompteImo(this.planComptable.getPlcLibelleCpteFR());
                           }
                        }
                     } else if (!var1.equalsIgnoreCase("amo_lib_compte_imo")) {
                        if (var1.equalsIgnoreCase("amo_fournisseur")) {
                           if (var2 != null && !var2.isEmpty()) {
                              this.verifCompte(var2, var3);
                              if (this.planComptable != null) {
                                 this.amortissements.setAmoFournisseur(this.planComptable.getPlcCompte());
                                 this.amortissements.setAmoLibFournisseur(this.planComptable.getPlcLibelleCpteFR());
                              }
                           }
                        } else if (!var1.equalsIgnoreCase("amo_lib_fournisseur")) {
                           this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
                        }
                     }
                  }
               }
            }
         }
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertVentes.setTrfNomFeuille(this.messageErreur);
         this.lesErreurs.add(this.transfertVentes);
      }

   }

   public void verifCompte(String var1, Session var2) throws HibernateException, NamingException {
      var1 = this.enlevePoint(var1).toUpperCase();
      this.planComptable = this.planComptableDao.trouveCompte("", this.exercicesComptable.getExecpt_id(), var1, var2);
   }

   public void importEcritureLibre(double var1) {
   }

   public String enlevePoint(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty() && var1.contains(".0")) {
         int var3 = var1.indexOf(".0");
         var2 = var1.substring(0, var3);
      } else {
         var2 = var1;
      }

      if (var2 != null && !var2.isEmpty()) {
         var2 = var2.replace("'", "`");
      }

      return var2;
   }

   public int conversionInteger(String var1) {
      String var2 = "";
      int var3 = 0;
      if (var1 != null && !var1.isEmpty()) {
         var1 = var1.replace("%", "");
         var1 = var1.replace(",", ".");
         int var4;
         if (var1.contains(".0")) {
            var4 = var1.indexOf(".0");
            var2 = var1.substring(0, var4);
         } else if (var1.contains(".")) {
            var4 = var1.indexOf(".");
            var2 = var1.substring(0, var4);
         } else {
            var2 = var1;
         }

         var3 = Integer.parseInt(var2);
      }

      return var3;
   }

   public double conversionDouble(String var1) {
      double var2 = 0.0D;
      if (var1 != null && !var1.isEmpty()) {
         var1 = var1.replace("%", "");
         var1 = var1.replace(",", ".");
         var2 = Double.parseDouble(var1);
      }

      return var2;
   }

   public Boolean conversionBoolean(String var1) {
      boolean var2 = false;
      if (var1 != null && !var1.isEmpty() && (var1.equals("1") || var1.equals("true") || var1.equals("TRUE"))) {
         var2 = true;
      }

      return var2;
   }

   public long conversionLong(String var1) {
      String var2 = "";
      long var3 = 0L;
      if (var1 != null && !var1.isEmpty()) {
         var1 = var1.replace("%", "");
         var1 = var1.replace(",", ".");
         if (var1.contains(".0")) {
            int var5 = var1.indexOf(".0");
            var2 = var1.substring(0, var5);
         } else {
            var2 = var1;
         }

         var3 = Long.parseLong(var2);
      }

      return var3;
   }

   public Date conversionDate(String var1) throws ParseException {
      Date var2 = null;
      if (var1 != null && !var1.isEmpty()) {
         if (!var1.contains("-") && !var1.contains("/")) {
            int var7 = this.conversionInteger(var1);
            if (var7 >= 10000 && var7 <= 60000) {
               GregorianCalendar var8 = new GregorianCalendar(1900, 0, 1);
               var8.add(5, var7 - 2);
               var2 = var8.getTime();
            } else {
               var2 = null;
            }
         } else if (var1.substring(4, 4).equals("-")) {
            String[] var3 = var1.split("-");
            String var4 = var3[2];
            String var5 = var3[1];
            String var6 = var3[0];
            var2 = this.utilDate.stringToDateSQLLight(var4 + "-" + var5 + "-" + var6);
         } else if (var1.length() == 10) {
            var2 = this.utilDate.stringToDateSQLLight(var1);
         } else {
            var2 = this.utilDate.stringToDateFrLg(var1);
         }
      } else {
         var2 = null;
      }

      return var2;
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

   public int getPljFormatDevise() {
      return this.pljFormatDevise;
   }

   public void setPljFormatDevise(int var1) {
      this.pljFormatDevise = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
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

   public FormTransfertCompta getFormTransfertCompta() {
      return this.formTransfertCompta;
   }

   public void setFormTransfertCompta(FormTransfertCompta var1) {
      this.formTransfertCompta = var1;
   }

   public String getOnglet() {
      return this.onglet;
   }

   public void setOnglet(String var1) {
      this.onglet = var1;
   }

   public boolean isAnExiste() {
      return this.anExiste;
   }

   public void setAnExiste(boolean var1) {
      this.anExiste = var1;
   }

   public int getBalance() {
      return this.balance;
   }

   public void setBalance(int var1) {
      this.balance = var1;
   }

   public String getSelecFiscalite() {
      return this.selecFiscalite;
   }

   public void setSelecFiscalite(String var1) {
      this.selecFiscalite = var1;
   }

   public int getChoixRacine() {
      return this.choixRacine;
   }

   public void setChoixRacine(int var1) {
      this.choixRacine = var1;
   }

   public int getVar_nb_carcactere() {
      return this.var_nb_carcactere;
   }

   public void setVar_nb_carcactere(int var1) {
      this.var_nb_carcactere = var1;
   }

   public int getModeReception() {
      return this.modeReception;
   }

   public void setModeReception(int var1) {
      this.modeReception = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }
}
