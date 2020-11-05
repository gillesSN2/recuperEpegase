package com.epegase.forms.comptabilite;

import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.Loyer;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.LibDate;
import com.epegase.systeme.control.TransfertCompta;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LoyerDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.xml.sax.SAXException;

public class FormLoyers implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private String pageIndex;
   private int nature;
   private LoyerDao loyerDao;
   private int var_nb_max = 100;
   private OptionComptabilite optionComptabilite;
   private ExercicesComptable selectedExo;
   private ExercicesComptable lastExo;
   private PlanComptableDao planComptableDao;
   private List leSCptesChargesOrProdItems;
   private List leSCptesChargesItems;
   private List leSCptesProdItems;
   private List lesCptestaxesItems = new ArrayList();
   private List lesCptesImpotsItems = new ArrayList();
   private List lesCptesTiersItems;
   private Loyer loyer = new Loyer();
   private ChronoDao chronoDao;
   private Chrono chrono;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private CalculChrono calculChrono;
   private boolean typeLoyer = true;
   private boolean testgriserImpot = true;
   private boolean testgriserTaxe = true;
   private transient DataModel dataModelLesloyers = new ListDataModel();
   private List lesloyers = new ArrayList();
   private String cpteLoyer = "";
   private String cpteTaxe = "";
   private String cpteImpot = "";
   private String cpteTiers = "";
   private boolean testAffModif;
   private SiteDao siteDao;
   private List lesdepartements = new ArrayList();
   private List lesServices = new ArrayList();
   private DepartementDao departementDao;
   private ServiceDao serviceDao;
   private RegionDao regionDao;
   private List lesSecteur = new ArrayList();
   private SecteurDao secteurDao;
   private List lesPointDeVente = new ArrayList();
   private PointDeVenteDao pointDeVenteDao;
   private List lesActivite;
   private PlansAnalytiquesDao analytiqueDao;
   private String activite;
   private String site;
   private String dept;
   private String service;
   private String region;
   private String secteur;
   private String pdv;
   private String dossier;
   private String mission;
   private String parc;
   private String agent;
   private String cle1;
   private String budget;
   private boolean testactivite = false;
   private boolean testsite = false;
   private boolean testdept = false;
   private boolean testservice = false;
   private boolean testreg = false;
   private boolean testsecteur = false;
   private boolean testPVD = false;
   private int testDossier;
   private boolean testMission = false;
   private boolean testParc = false;
   private boolean testAgent = false;
   private List lesModelsimpression = new ArrayList();
   private boolean showModalPanelPrint = false;
   private boolean verrouNum = false;
   private JournauxComptables journauxComptables;
   private Date dateDebut;
   private Date dateFin;
   private boolean showModalPanelTransfert = false;
   private List lesElementsTrf = new ArrayList();
   private TransfertCompta transfertCompta = new TransfertCompta();
   private List lesTransfertCompta = new ArrayList();
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
   private List lesModelesAutorises;
   private int choixRacine;
   private String selecFiscalite;

   public void InstancesDaoUtilses() {
      this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.departementDao = new DepartementDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.regionDao = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.secteurDao = new SecteurDao(this.baseLog, this.utilInitHibernate);
      this.pointDeVenteDao = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.loyerDao = new LoyerDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void initAnalytique() {
      if (this.optionComptabilite.getNbLigneMaxLo() != null && !this.optionComptabilite.getNbLigneMaxLo().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxLo());
      } else {
         this.var_nb_max = 100;
      }

      this.testactivite = this.structureLog.isStrActivite();
      if (this.structureLog.isStrSite()) {
         this.testsite = true;
         this.testdept = true;
         this.testservice = true;
      }

      if (this.structureLog.isStrRegion()) {
         this.testreg = true;
         this.testsecteur = true;
         this.testPVD = true;
      }

      this.testDossier = this.structureLog.getStrDossier();
      this.testMission = false;
      this.testParc = this.structureLog.isStrParc();
      this.testAgent = this.structureLog.isStrAgent();
   }

   public void chargerLesloyers(Session var1) throws HibernateException, NamingException {
      this.lesloyers = this.loyerDao.chargerLesloyers(this.selectedExo.getExecpt_id(), var1);
      this.dataModelLesloyers.setWrappedData(this.lesloyers);
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
         long var2 = (long)(this.selectedExo.getExecptDateDebut().getYear() + 1900);
         long var4 = (long)(this.selectedExo.getExecptDateFin().getYear() + 1900);
         if (this.structureLog.getStrdatefiscale2() != null && var2 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var4 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale2();
         } else if (this.structureLog.getStrdatefiscale2() != null && var2 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var4 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale();
         } else {
            this.selecFiscalite = null;
         }
      }

   }

   public void chargerLesComptes(Session var1) throws HibernateException, NamingException {
      this.leSCptesChargesItems = new ArrayList();
      this.leSCptesChargesItems = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.selectedExo.getExecpt_id(), "(16)", 0, var1);
      this.leSCptesProdItems = new ArrayList();
      this.leSCptesProdItems = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.selectedExo.getExecpt_id(), "(17)", 0, var1);
      this.lesCptesImpotsItems = new ArrayList();
      this.lesCptesImpotsItems = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.selectedExo.getExecpt_id(), "(13,16)", 0, var1);
      this.lesCptestaxesItems = new ArrayList();
      this.lesCptestaxesItems = this.lesCptesImpotsItems;
      this.setTestgriserTaxe(true);
      this.cpteTaxe = "";
      this.setTestgriserImpot(true);
      this.cpteImpot = "";
   }

   public void activerLeSCptesChargesOrProd() throws HibernateException, NamingException {
      this.loyer.setLoyType(this.loyer.getLoyType());
      if (this.loyer.getLoyType() == 0) {
         this.typeLoyer = true;
      } else {
         this.typeLoyer = false;
      }

      this.chargerLeSCptesTiers();
   }

   public void chargerLeSCptesTiers() throws HibernateException, NamingException {
      this.lesCptesTiersItems = new ArrayList();
      if (this.getLoyer().getLoyType() == 0) {
         this.lesCptesTiersItems = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.selectedExo.getExecpt_id(), "(6)", 0, (Session)null);
      } else if (this.getLoyer().getLoyType() == 1) {
         this.lesCptesTiersItems = this.planComptableDao.chargerPlanCmptItems(this.selecFiscalite, this.selectedExo.getExecpt_id(), "(7)", 0, (Session)null);
      }

   }

   public void activerLeSCptesTaxe() {
      if (this.getLoyer().getLoyTypeTaxe() != 1 && this.getLoyer().getLoyTypeTaxe() != 2) {
         this.setTestgriserTaxe(true);
         this.getLoyer().setLoyCompteTaxe("");
         this.loyer.setLoyTauxTaxe(0.0F);
         this.loyer.setLoyMontantTaxe(0.0D);
         this.cpteTaxe = "";
      } else {
         this.setTestgriserTaxe(false);
      }

   }

   public void activerLeSCptesImpot() {
      if (this.getLoyer().getLoyTypeImpot() != 1 && this.getLoyer().getLoyTypeImpot() != 2) {
         this.setTestgriserImpot(true);
         this.getLoyer().setLoyCompteImpot("");
         this.loyer.setLoyTauxImpot(0.0F);
         this.loyer.setLoyMontantImpot(0.0D);
         this.cpteImpot = "";
      } else {
         this.setTestgriserImpot(false);
      }

   }

   public void ajoutLoyer() throws HibernateException, NamingException {
      this.loyer = new Loyer();
      this.chargerLeSCptesTiers();
      this.lesdepartements = new ArrayList();
      this.lesServices = new ArrayList();
      this.lesSecteur = new ArrayList();
      this.lesPointDeVente = new ArrayList();
      this.loyer.setLoyDateDebut(this.selectedExo.getExecptDateDebut());
      this.loyer.setLoyDateFin(this.selectedExo.getExecptDateFin());
      this.verifExitChrono();
      this.activite = "";
      this.site = "";
      this.dept = "";
      this.service = "";
      this.region = "";
      this.secteur = "";
      this.pdv = "";
      this.dossier = "";
      this.mission = "";
      this.parc = "";
      this.agent = "";
      this.cle1 = "";
      if (this.decoupageActivite) {
         this.lesDecoupagesActivites.clear();
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

      this.var_action = 1;
   }

   public void selectionLoyer() throws HibernateException, NamingException {
      if (this.dataModelLesloyers.isRowAvailable()) {
         this.loyer = (Loyer)this.dataModelLesloyers.getRowData();
         this.activerLeSCptesChargesOrProd();
         this.activerLeSCptesImpot();
         this.activerLeSCptesTaxe();
         this.lesdepartements = new ArrayList();
         this.lesServices = new ArrayList();
         this.lesSecteur = new ArrayList();
         this.lesPointDeVente = new ArrayList();
         if (this.getLoyer().getLoyCompteLoyer() != null && !this.getLoyer().getLoyCompteLoyer().isEmpty()) {
            this.cpteLoyer = this.getLoyer().getLoyCompteLoyer();
         } else {
            this.cpteLoyer = "";
         }

         if (this.getLoyer().getLoyCompteImpot() != null && !this.getLoyer().getLoyCompteImpot().isEmpty()) {
            this.cpteImpot = this.getLoyer().getLoyCompteImpot();
         } else {
            this.cpteImpot = "";
         }

         if (this.getLoyer().getLoyCompteTaxe() != null && !this.getLoyer().getLoyCompteTaxe().isEmpty()) {
            this.cpteTaxe = this.getLoyer().getLoyCompteTaxe();
         } else {
            this.cpteTaxe = "";
         }

         if (this.getLoyer().getLoyCompteTiers() != null && !this.getLoyer().getLoyCompteTiers().isEmpty()) {
            this.cpteTiers = this.getLoyer().getLoyCompteTiers();
         } else {
            this.cpteTiers = "";
         }

         if (this.decoupageActivite) {
            this.chargerDetailanalytique();
            this.controleEcartAnalytique();
            this.activite = this.loyer.getLoyActiviteCode();
         } else if (this.getLoyer().getLoyActiviteCode() != null && !this.getLoyer().getLoyActiviteCode().isEmpty()) {
            this.activite = this.getLoyer().getLoyActiviteCode() + ":" + this.getLoyer().getLoyActiviteLib();
         } else {
            this.activite = "";
         }

         if (this.getLoyer().getLoySiteCode() != null && !this.getLoyer().getLoySiteCode().isEmpty()) {
            this.site = this.getLoyer().getLoySiteCode() + ":" + this.getLoyer().getLoySiteLib();
         } else {
            this.site = "";
         }

         if (this.getLoyer().getLoyDepartementCode() != null && !this.getLoyer().getLoyDepartementCode().isEmpty()) {
            this.dept = this.getLoyer().getLoyDepartementCode() + ":" + this.getLoyer().getLoyDepartementLib();
            this.lesdepartements.add(new SelectItem(this.dept));
         } else {
            this.dept = "";
         }

         if (this.getLoyer().getLoyServiceCode() != null && !this.getLoyer().getLoyServiceCode().isEmpty()) {
            this.service = this.getLoyer().getLoyServiceCode() + ":" + this.getLoyer().getLoyServiceLib();
            this.lesServices.add(new SelectItem(this.service));
         } else {
            this.service = "";
         }

         if (this.getLoyer().getLoyRegionCode() != null && !this.getLoyer().getLoyRegionCode().isEmpty()) {
            this.region = this.getLoyer().getLoyRegionCode() + ":" + this.getLoyer().getLoyRegionLib();
         } else {
            this.region = "";
         }

         if (this.getLoyer().getLoySecteurCode() != null && !this.getLoyer().getLoySecteurCode().isEmpty()) {
            this.secteur = this.getLoyer().getLoySecteurCode() + ":" + this.getLoyer().getLoySecteurLib();
            this.lesSecteur.add(new SelectItem(this.secteur));
         } else {
            this.secteur = "";
         }

         if (this.getLoyer().getLoyPdvCode() != null && !this.getLoyer().getLoyPdvCode().isEmpty()) {
            this.pdv = this.getLoyer().getLoyPdvCode() + ":" + this.getLoyer().getLoyPdvLib();
            this.lesPointDeVente.add(new SelectItem(this.pdv));
         } else {
            this.pdv = "";
         }

         if (this.getLoyer().getLoyDossierCode() != null && !this.getLoyer().getLoyDossierCode().isEmpty()) {
            this.dossier = this.getLoyer().getLoyDossierCode() + ":" + this.getLoyer().getLoyDossierLib();
         } else {
            this.dossier = "";
         }

         if (this.getLoyer().getLoyMissionCode() != null && !this.getLoyer().getLoyMissionCode().isEmpty()) {
            this.mission = this.getLoyer().getLoyMissionCode() + ":" + this.getLoyer().getLoyMissionLib();
         } else {
            this.mission = "";
         }

         if (this.getLoyer().getLoyParcCode() != null && !this.getLoyer().getLoyParcCode().isEmpty()) {
            this.parc = this.getLoyer().getLoyParcCode() + ":" + this.getLoyer().getLoyParcLib();
         } else {
            this.parc = "";
         }

         if (this.getLoyer().getLoyCle1Code() != null && !this.getLoyer().getLoyCle1Code().isEmpty()) {
            this.cle1 = this.getLoyer().getLoyCle1Code() + ":" + this.getLoyer().getLoyCle1Lib();
         } else {
            this.cle1 = "";
         }

         if (this.getLoyer().getLoyAgentCode() != null && !this.getLoyer().getLoyAgentCode().isEmpty()) {
            this.agent = this.getLoyer().getLoyAgentCode() + ":" + this.getLoyer().getLoyAgentLib();
         } else {
            this.agent = "";
         }
      }

   }

   public void modifLoyer() throws HibernateException, NamingException {
      if (this.loyer != null) {
         this.chargerLeSCptesTiers();
         this.var_action = 2;
      }

   }

   public void consultLoyer() throws HibernateException, NamingException {
      if (this.loyer != null) {
         this.chargerLeSCptesTiers();
         this.var_action = 3;
      }

   }

   public void reactiverLoyer() throws HibernateException, NamingException {
      if (this.loyer != null) {
         this.loyer.setLoyUserModif(this.usersLog.getUsrid());
         this.loyer.setLoyDateModif(new Date());
         this.loyer.setLoyInactif(0);
         this.loyer = this.loyerDao.modif(this.loyer);
      }

   }

   public void removeSelectedLoyer() throws HibernateException, NamingException {
      if (this.loyer != null) {
         this.loyerDao.delete(this.loyer);
         this.lesloyers.remove(this.loyer);
      }

   }

   public void annulerSaisie() {
      this.var_action = 0;
   }

   public void saveLoyer() throws HibernateException, NamingException {
      if (this.decoupageActivite) {
         String var1 = "";
         boolean var2 = true;
         if (this.lesDecoupagesActivites.size() != 0) {
            for(int var3 = 0; var3 < this.lesDecoupagesActivites.size(); ++var3) {
               this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var3);
               if (this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
                  if (var2) {
                     var1 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                     var2 = false;
                  } else {
                     var1 = var1 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                  }
               }
            }
         }

         this.loyer.setLoyActiviteCode(var1);
         this.loyer.setLoyActiviteLib("DécoupageActivité");
      } else {
         this.loyer.setLoyActiviteCode(this.splitForCpte(this.activite));
         this.loyer.setLoyActiviteLib(this.splitForLib(this.activite));
      }

      this.loyer.setLoySiteCode(this.splitForCpte(this.site));
      this.loyer.setLoySiteLib(this.splitForLib(this.site));
      this.loyer.setLoyDepartementCode(this.splitForCpte(this.dept));
      this.loyer.setLoyDepartementLib(this.splitForLib(this.dept));
      this.loyer.setLoyServiceCode(this.splitForCpte(this.service));
      this.loyer.setLoyServiceLib(this.splitForLib(this.service));
      this.loyer.setLoyRegionCode(this.splitForCpte(this.region));
      this.loyer.setLoyRegionLib(this.splitForLib(this.region));
      this.loyer.setLoySecteurCode(this.splitForCpte(this.secteur));
      this.loyer.setLoySecteurLib(this.splitForLib(this.secteur));
      this.loyer.setLoyPdvCode(this.splitForCpte(this.pdv));
      this.loyer.setLoyPdvLib(this.splitForLib(this.pdv));
      this.loyer.setLoyDossierCode(this.splitForCpte(this.dossier));
      this.loyer.setLoyDossierLib(this.splitForLib(this.dossier));
      this.loyer.setLoyMissionCode(this.splitForCpte(this.mission));
      this.loyer.setLoyMissionLib(this.splitForLib(this.mission));
      this.loyer.setLoyParcCode(this.splitForCpte(this.parc));
      this.loyer.setLoyParcLib(this.splitForLib(this.parc));
      this.loyer.setLoyCle1Code(this.splitForCpte(this.cle1));
      this.loyer.setLoyCle1Lib(this.splitForLib(this.cle1));
      this.loyer.setLoyAgentCode(this.splitForCpte(this.agent));
      this.loyer.setLoyAgentLib(this.splitForLib(this.agent));
      this.loyer.setLoyCompteLoyer(this.cpteLoyer);
      this.loyer.setLoyLibCompteLoyer(this.chercherLib(this.cpteLoyer));
      this.loyer.setLoyBudgetCode(this.splitForCpte(this.budget));
      this.loyer.setLoyBudgetLib(this.splitForLib(this.budget));
      this.loyer.setLoyCompteTiers(this.cpteTiers);
      this.loyer.setLoyLibCompteTiers(this.chercherLib(this.cpteTiers));
      if (this.loyer.getLoyTypeTaxe() != 0) {
         this.loyer.setLoyCompteTaxe(this.cpteTaxe);
         this.loyer.setLoyLibCompteTaxe(this.chercherLib(this.cpteTaxe));
      } else {
         this.loyer.setLoyCompteTaxe("");
         this.loyer.setLoyLibCompteTaxe("");
      }

      if (this.loyer.getLoyTypeImpot() != 0) {
         this.loyer.setLoyCompteImpot(this.cpteImpot);
         this.loyer.setLoyLibCompteImpot(this.chercherLib(this.cpteImpot));
      } else {
         this.loyer.setLoyCompteImpot("");
         this.loyer.setLoyLibCompteImpot("");
      }

      if (this.loyer.getLoyId() == 0L) {
         if (this.verrouNum) {
            this.loyer.setLoyNumBail(this.numCompose((Session)null));
         } else {
            boolean var4 = false;
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Loyer");
            Object var7 = var6.createQuery("SELECT COUNT(*) FROM Loyer").uniqueResult();
            int var5 = Integer.parseInt(var7.toString());
            this.utilInitHibernate.closeSession();
            this.loyer.setLoyNumBail("" + var5);
         }

         this.loyer.setExercicescomptable(this.selectedExo);
         this.loyer.setLoyUserCreat(this.usersLog.getUsrid());
         this.loyer.setLoyDateCreat(new Date());
         this.loyer = this.loyerDao.insert(this.loyer);
         this.lesloyers.add(this.loyer);
         this.dataModelLesloyers.setWrappedData(this.lesloyers);
      } else {
         if (this.loyer.getLoyNumBail() == null || this.loyer.getLoyNumBail().isEmpty()) {
            this.loyer.setLoyNumBail("" + this.loyer.getLoyId());
         }

         this.loyer.setLoyUserModif(this.usersLog.getUsrid());
         this.loyer.setLoyDateModif(new Date());
         this.loyer = this.loyerDao.modif(this.loyer);
      }

      this.var_action = 0;
   }

   public String splitForCpte(String var1) {
      String var2 = "";
      if (var1 != null && var1.contains(":")) {
         String[] var3 = var1.split(":");
         var2 = var3[0];
      }

      return var2;
   }

   public String splitForLib(String var1) {
      String var2 = "";
      if (var1 != null && var1.contains(":")) {
         String[] var3 = var1.split(":");
         var2 = var3[1];
      }

      return var2;
   }

   public String chercherLib(String var1) throws HibernateException, NamingException {
      String var2 = "";
      if (var1 != null && !var1.isEmpty()) {
         new PlanComptable();
         PlanComptable var3 = this.planComptableDao.chercherCompte(this.selecFiscalite, var1, this.selectedExo.getExecpt_id(), (Session)null);
         if (var3 != null) {
            var2 = var3.getPlcLibelleCpteFR();
         }
      }

      return var2;
   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.loyer.getLoyActiviteCode() != null && !this.loyer.getLoyActiviteCode().isEmpty() && this.loyer.getLoyActiviteCode().contains(":")) {
         String[] var1 = null;
         if (!this.loyer.getLoyActiviteCode().contains("#")) {
            var1 = this.loyer.getLoyActiviteCode().split(":");
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
            String[] var2 = this.loyer.getLoyActiviteCode().split("#");

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

   public void calculMontantImpot() {
      double var1;
      double var3;
      if (this.getLoyer().getLoyTauxImpot() > 0.0F && this.getLoyer().getLoyTypeImpot() == 1) {
         var1 = (double)(1.0F + this.getLoyer().getLoyTauxImpot() / 100.0F);
         var3 = this.getLoyer().getLoyMontantNet() - this.getLoyer().getLoyMontantNet() / var1;
         var3 = this.utilNombre.myRoundDevise(var3, this.structureLog.getStrdevise());
         this.getLoyer().setLoyMontantImpot(var3);
      } else {
         this.getLoyer().setLoyMontantImpot(0.0D);
      }

      if (this.getLoyer().getLoyTauxTaxe() <= 0.0F || this.getLoyer().getLoyTypeTaxe() != 1 && this.getLoyer().getLoyTypeTaxe() != 2) {
         this.getLoyer().setLoyMontantTaxe(0.0D);
      } else {
         var1 = (double)(1.0F + this.getLoyer().getLoyTauxTaxe() / 100.0F);
         var3 = this.getLoyer().getLoyMontantNet() - this.getLoyer().getLoyMontantImpot();
         double var5 = var3 - var3 / var1;
         var5 = this.utilNombre.myRoundDevise(var5, this.structureLog.getStrdevise());
         this.getLoyer().setLoyMontantTaxe(var5);
      }

      var1 = this.getLoyer().getLoyMontantNet() - this.getLoyer().getLoyMontantImpot() - this.getLoyer().getLoyMontantTaxe();
      this.getLoyer().setLoyMontantBrut(var1);
   }

   public String concatString(String var1, String var2) {
      String var3 = null;
      if (var1 != null && !var1.equalsIgnoreCase("") && var2 != null && !var2.equalsIgnoreCase("")) {
         var3 = var1 + ":" + var2;
      }

      return var3;
   }

   public void chargerDepartement() throws HibernateException, NamingException {
      new Site();
      new ArrayList();
      this.lesdepartements = new ArrayList();
      (new StringBuilder()).append("").append(this.lastExo.getExecpt_id()).toString();
      if (!this.site.equals("")) {
         String var4 = this.splitForCpte(this.site);
         String var5 = this.splitForLib(this.site);
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
         Site var1 = this.siteDao.rechercheSite(var4, var6);
         List var2 = this.departementDao.listDepartementBySitCle(var1, var6);
         this.utilInitHibernate.closeSession();

         for(int var7 = 0; var7 < var2.size(); ++var7) {
            new Departement();
            Departement var8 = (Departement)var2.get(var7);
            this.lesdepartements.add(new SelectItem(var8.getDepCode() + ":" + var8.getDepNomFr()));
         }
      }

   }

   public void chargerService() throws HibernateException, NamingException {
      new Departement();
      new ArrayList();
      this.lesServices = new ArrayList();
      (new StringBuilder()).append("").append(this.lastExo.getExecpt_id()).toString();
      if (!this.dept.equals("")) {
         String var4 = this.splitForCpte(this.dept);
         String var5 = this.splitForLib(this.site);
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
         Departement var1 = this.departementDao.rechercheDepartement(var4, var6);
         List var2 = this.serviceDao.listServiceByDep(var1, var6);
         this.utilInitHibernate.closeSession();

         for(int var7 = 0; var7 < var2.size(); ++var7) {
            new Service();
            Service var8 = (Service)var2.get(var7);
            this.lesServices.add(new SelectItem(var8.getSerCode() + ":" + var8.getSerNomFr()));
         }
      }

   }

   public void chargerSecteur() throws HibernateException, NamingException {
      new Region();
      new ArrayList();
      this.lesSecteur = new ArrayList();
      (new StringBuilder()).append("").append(this.lastExo.getExecpt_id()).toString();
      if (!this.region.equals("")) {
         String var4 = this.splitForCpte(this.region);
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
         Region var1 = this.regionDao.rechercheRegion(var4, var5);
         List var2 = this.secteurDao.listSecteurByReg(var1, var5);
         this.utilInitHibernate.closeSession();

         for(int var6 = 0; var6 < var2.size(); ++var6) {
            new Secteur();
            Secteur var7 = (Secteur)var2.get(var6);
            this.lesSecteur.add(new SelectItem(var7.getSecCode() + ":" + var7.getSecNomFr()));
         }
      }

   }

   public void chargerPdv() throws HibernateException, NamingException {
      new Secteur();
      new ArrayList();
      this.lesPointDeVente = new ArrayList();
      String var3 = "" + this.lastExo.getExecpt_id();
      if (!this.secteur.equals("")) {
         String var4 = this.splitForCpte(this.secteur);
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
         Secteur var1 = (Secteur)this.secteurDao.chargerLesSecteurs(var4, var5);
         List var2 = this.pointDeVenteDao.listPdvBySecteur(var3, var1, var5);
         this.utilInitHibernate.closeSession();

         for(int var6 = 0; var6 < var2.size(); ++var6) {
            new PointDeVente();
            PointDeVente var7 = (PointDeVente)var2.get(var6);
            this.lesPointDeVente.add(new SelectItem(var7.getPdvCode() + ":" + var7.getPdvNomFr()));
         }
      }

   }

   public void verifExitChrono() throws HibernateException, NamingException {
      this.chrono = new Chrono();
      this.chrono = this.chronoDao.chronoByNat(this.nature, (Session)null);
      if (this.chrono != null) {
         this.verrouNum = true;
      } else {
         this.verrouNum = false;
      }

   }

   public String numCompose(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      if (this.verrouNum) {
         this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
         this.enregitrerNumero(var1);
         var2 = this.calculChrono.formattageChrono(this.chrono, "", "", this.loyer.getLoyDateDebut());
      } else {
         var2 = this.loyer.getLoyNumBail();
      }

      return var2;
   }

   public void enregitrerNumero(Session var1) throws HibernateException, NamingException {
      this.chrono.setChrNum(this.chrono.getChrNum() + 1L);
      this.chronoDao.modifierChrono(this.chrono, var1);
   }

   public void openModalPanel() {
      this.dateDebut = this.lastExo.getExecptDateDebut();
      this.dateFin = this.lastExo.getExecptDateFin();
      this.showModalPanelTransfert = true;
   }

   public void closeModalPanel() {
      this.showModalPanelTransfert = false;
   }

   public void transfertElement() throws IOException, SAXException, NamingException, ParseException {
      new ArrayList();
      JournauxComptablesDao var2 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      List var1 = var2.verifJCExit(this.lastExo.getExecpt_id(), 4);
      this.journauxComptables = new JournauxComptables();
      if (var1.size() == 0) {
         this.journauxComptables.setExercice(this.lastExo);
         this.journauxComptables.setPljLibelleFr("Loyer");
         this.journauxComptables.setPljLibelleUk("Loyer");
         this.journauxComptables.setPljLibelleSp("Loyer");
         this.journauxComptables.setPljCode("LO");
         this.journauxComptables.setPljNature(4);
         var2.save(this.journauxComptables);
      } else {
         this.journauxComptables = (JournauxComptables)var1.get(0);
      }

      this.lesElementsTrf = new ArrayList();
      String var3 = this.utilDate.dateToStringSQL(this.dateDebut);
      String var4 = this.utilDate.dateToStringSQL(this.dateFin);
      this.lesElementsTrf = this.loyerDao.chargerLesloyers(this.lastExo.getExecpt_id(), (Session)null);
      this.genererLesTransfertCompta();
   }

   public void genererLesTransfertCompta() throws ParseException {
      double var1 = 0.0D;
      double var3 = 0.0D;
      this.lesTransfertCompta = new ArrayList();
      if (this.lesElementsTrf.size() > 0) {
         for(int var5 = 0; var5 < this.lesElementsTrf.size(); ++var5) {
            new TransfertCompta();
            new Loyer();
            Loyer var7 = (Loyer)this.lesElementsTrf.get(var5);
            if (var7.getLoyMontantNet() != 0.0D) {
               List var8 = this.calculLeNombreDeMois(var7);

               for(int var9 = 0; var9 < var8.size(); ++var9) {
                  new LibDate();
                  LibDate var10 = (LibDate)var8.get(var9);
                  String var11 = var10.getLibelle();
                  Date var12 = var10.getDate();
                  TransfertCompta var6;
                  if (var7.getLoyType() == 0) {
                     var1 = var7.getLoyMontantBrut();
                     var3 = 0.0D;
                     var6 = this.genererLigne(var7.getLoyId(), var12, var7.getLoyCompteLoyer(), var7.getLoyNumBail(), var11, var1, var3, var7.getLoySiteCode(), var7.getLoyDepartementCode(), var7.getLoyServiceCode(), var7.getLoyRegionCode(), var7.getLoySecteurCode(), var7.getLoyPdvCode(), var7.getLoyDossierCode(), var7.getLoyMissionCode(), var7.getLoyParcCode(), var7.getLoyCle1Code(), var7.getLoyBudgetCode(), var7.getLoyActiviteCode(), "", var7.getLoyAgentCode());
                     this.lesTransfertCompta.add(var6);
                     var1 = 0.0D;
                     var3 = var7.getLoyMontantNet();
                     var6 = this.genererLigne(var7.getLoyId(), var12, var7.getLoyCompteTiers(), var7.getLoyNumBail(), var11, var1, var3, var7.getLoySiteCode(), var7.getLoyDepartementCode(), var7.getLoyServiceCode(), var7.getLoyRegionCode(), var7.getLoySecteurCode(), var7.getLoyPdvCode(), var7.getLoyDossierCode(), var7.getLoyMissionCode(), var7.getLoyParcCode(), var7.getLoyCle1Code(), var7.getLoyBudgetCode(), var7.getLoyActiviteCode(), "", var7.getLoyAgentCode());
                     this.lesTransfertCompta.add(var6);
                     if ((var7.getLoyTypeTaxe() == 1 || var7.getLoyTypeTaxe() == 2) && var7.getLoyMontantTaxe() != 0.0D) {
                        var1 = var7.getLoyMontantTaxe();
                        var3 = 0.0D;
                        var6 = this.genererLigne(var7.getLoyId(), var12, var7.getLoyCompteTaxe(), var7.getLoyNumBail(), var11, var1, var3, var7.getLoySiteCode(), var7.getLoyDepartementCode(), var7.getLoyServiceCode(), var7.getLoyRegionCode(), var7.getLoySecteurCode(), var7.getLoyPdvCode(), var7.getLoyDossierCode(), var7.getLoyMissionCode(), var7.getLoyParcCode(), var7.getLoyCle1Code(), var7.getLoyBudgetCode(), var7.getLoyActiviteCode(), "", var7.getLoyAgentCode());
                        this.lesTransfertCompta.add(var6);
                     }

                     if (var7.getLoyTypeImpot() == 1 && var7.getLoyMontantImpot() != 0.0D) {
                        var1 = var7.getLoyMontantImpot();
                        var3 = 0.0D;
                        var6 = this.genererLigne(var7.getLoyId(), var12, var7.getLoyCompteImpot(), var7.getLoyNumBail(), var11, var1, var3, var7.getLoySiteCode(), var7.getLoyDepartementCode(), var7.getLoyServiceCode(), var7.getLoyRegionCode(), var7.getLoySecteurCode(), var7.getLoyPdvCode(), var7.getLoyDossierCode(), var7.getLoyMissionCode(), var7.getLoyParcCode(), var7.getLoyCle1Code(), var7.getLoyBudgetCode(), var7.getLoyActiviteCode(), "", var7.getLoyAgentCode());
                        this.lesTransfertCompta.add(var6);
                     }
                  } else if (var7.getLoyType() == 1) {
                     var1 = 0.0D;
                     var3 = var7.getLoyMontantBrut();
                     var6 = this.genererLigne(var7.getLoyId(), var12, var7.getLoyCompteLoyer(), var7.getLoyNumBail(), var11, var1, var3, var7.getLoySiteCode(), var7.getLoyDepartementCode(), var7.getLoyServiceCode(), var7.getLoyRegionCode(), var7.getLoySecteurCode(), var7.getLoyPdvCode(), var7.getLoyDossierCode(), var7.getLoyMissionCode(), var7.getLoyParcCode(), var7.getLoyCle1Code(), var7.getLoyBudgetCode(), var7.getLoyActiviteCode(), "", var7.getLoyAgentCode());
                     this.lesTransfertCompta.add(var6);
                     var1 = var7.getLoyMontantNet();
                     var3 = 0.0D;
                     var6 = this.genererLigne(var7.getLoyId(), var12, var7.getLoyCompteTiers(), var7.getLoyNumBail(), var11, var1, var3, var7.getLoySiteCode(), var7.getLoyDepartementCode(), var7.getLoyServiceCode(), var7.getLoyRegionCode(), var7.getLoySecteurCode(), var7.getLoyPdvCode(), var7.getLoyDossierCode(), var7.getLoyMissionCode(), var7.getLoyParcCode(), var7.getLoyCle1Code(), var7.getLoyBudgetCode(), var7.getLoyActiviteCode(), "", var7.getLoyAgentCode());
                     this.lesTransfertCompta.add(var6);
                     if ((var7.getLoyTypeTaxe() == 1 || var7.getLoyTypeTaxe() == 2) && var7.getLoyMontantTaxe() != 0.0D) {
                        var1 = 0.0D;
                        var3 = var7.getLoyMontantTaxe();
                        var6 = this.genererLigne(var7.getLoyId(), var12, var7.getLoyCompteTaxe(), var7.getLoyNumBail(), var11, var1, var3, var7.getLoySiteCode(), var7.getLoyDepartementCode(), var7.getLoyServiceCode(), var7.getLoyRegionCode(), var7.getLoySecteurCode(), var7.getLoyPdvCode(), var7.getLoyDossierCode(), var7.getLoyMissionCode(), var7.getLoyParcCode(), var7.getLoyCle1Code(), var7.getLoyBudgetCode(), var7.getLoyActiviteCode(), "", var7.getLoyAgentCode());
                        this.lesTransfertCompta.add(var6);
                     }

                     if (var7.getLoyTypeImpot() == 1 && var7.getLoyMontantImpot() != 0.0D) {
                        var1 = 0.0D;
                        var3 = var7.getLoyMontantImpot();
                        var6 = this.genererLigne(var7.getLoyId(), var12, var7.getLoyCompteImpot(), var7.getLoyNumBail(), var11, var1, var3, var7.getLoySiteCode(), var7.getLoyDepartementCode(), var7.getLoyServiceCode(), var7.getLoyRegionCode(), var7.getLoySecteurCode(), var7.getLoyPdvCode(), var7.getLoyDossierCode(), var7.getLoyMissionCode(), var7.getLoyParcCode(), var7.getLoyCle1Code(), var7.getLoyBudgetCode(), var7.getLoyActiviteCode(), "", var7.getLoyAgentCode());
                        this.lesTransfertCompta.add(var6);
                     }
                  }
               }
            }
         }
      }

   }

   public List calculLeNombreDeMois(Loyer var1) throws ParseException {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(this.dateDebut);
      GregorianCalendar var5 = new GregorianCalendar();
      var5.setTime(this.dateFin);
      GregorianCalendar var6 = new GregorianCalendar();
      var6.setTime(var1.getLoyDateDebut());
      GregorianCalendar var7 = new GregorianCalendar();
      var7.setTime(var1.getLoyDateFin());
      var4.add(2, -1);
      var5.add(2, -1);
      int var8 = 0;
      int var9 = 0;

      while(var4.compareTo(var5) < 0) {
         Date var10;
         LibDate var11;
         if (var1.getLoyMode() == 0) {
            var4.add(2, 1);
            var10 = var4.getTime();
            if (var4.compareTo(var7) <= 0 && var4.compareTo(var6) >= 0) {
               var11 = new LibDate();
               var11.setDate(var10);
               var11.setLibelle("loyer mois:" + this.calculmois(var10) + "/" + this.calculAnnee(var10));
               var3.add(var11);
            }
         } else if (var1.getLoyMode() == 1) {
            var4.add(2, 3);
            var10 = var4.getTime();
            if (var4.compareTo(var7) <= 0 && var4.compareTo(var6) >= 0) {
               ++var8;
               var11 = new LibDate();
               var11.setDate(var10);
               var11.setLibelle("loyer trimestre n° " + var8 + "  " + this.calculAnnee(var10));
               var3.add(var11);
            }
         } else if (var1.getLoyMode() == 2) {
            var4.add(2, 6);
            var10 = var4.getTime();
            if (var4.compareTo(var7) <= 0 && var4.compareTo(var6) >= 0) {
               ++var9;
               var11 = new LibDate();
               var11.setDate(var10);
               var11.setLibelle("loyer semestre n° " + var9 + "  " + this.calculAnnee(var10));
               var3.add(var11);
            }
         } else if (var1.getLoyMode() == 3) {
            var4.add(2, 12);
            var10 = var4.getTime();
            if (var4.compareTo(var7) <= 0 && var4.compareTo(var6) >= 0) {
               var11 = new LibDate();
               var11.setDate(var10);
               var11.setLibelle("loyer année:" + this.calculAnnee(var10));
               var3.add(var11);
            }
         }
      }

      return var3;
   }

   public String calculAnnee(Date var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
      var2.format(var1);
      String var3 = "" + var2.format(var1);
      String[] var4 = var3.split("-");
      String var5 = var4[2];
      return var5;
   }

   public String calculmois(Date var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
      var2.format(var1);
      String var3 = "" + var2.format(var1);
      String[] var4 = var3.split("-");
      String var5 = var4[1];
      return var5;
   }

   public TransfertCompta genererLigne(long var1, Date var3, String var4, String var5, String var6, double var7, double var9, String var11, String var12, String var13, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24) {
      TransfertCompta var25 = new TransfertCompta();
      var25.setTrfCode(this.journauxComptables.getPljCode());
      var25.setTrfIdOrigine(var1);
      var25.setTrfTypeOrigine("LO");
      var25.setTrfDateSaisie(var3);
      var25.setTrfCompte(var4);
      var25.setTrfLibelle(var6);
      var25.setTrfReference1(var5);
      var25.setTrfPiece("XXXXXX");
      var25.setTrfDebitSaisie(var7);
      var25.setTrfCreditSaisie(var9);
      var25.setTrfDateEcheance((Date)null);
      var25.setTrfDateValeurTheo((Date)null);
      var25.setTrfSite(var11);
      var25.setTrfDepartement(var12);
      var25.setTrfService(var13);
      var25.setTrfRegion(var14);
      var25.setTrfSecteur(var15);
      var25.setTrfPdv(var16);
      var25.setTrfDossier(var17);
      var25.setTrfParc(var19);
      var25.setTrfCle1(var20);
      var25.setTrfTreso("");
      var25.setTrfActivite(var22);
      var25.setTrfAgent(var24);
      var25.setTrfBudget(var21);
      var25.setTrfProjet(var23);
      return var25;
   }

   public void traitementApresTransfert() {
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

   public void chargerLesModelesImpresion() {
      this.dateDebut = this.selectedExo.getExecptDateDebut();
      this.dateFin = this.selectedExo.getExecptDateFin();
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "loyer";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.lesModelsimpression = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.endsWith("jasper")) {
               String var6 = var3[var4];
               if (this.verificationAutorisation(var6)) {
                  int var7 = var5.indexOf(".");
                  var5 = var5.substring(0, var7);
                  this.lesModelsimpression.add(new SelectItem(var5));
               }
            }
         }
      }

   }

   public boolean verificationAutorisation(String var1) {
      boolean var2 = false;
      if (this.lesModelesAutorises != null && this.lesModelesAutorises.size() != 0) {
         for(int var3 = 0; var3 < this.lesModelesAutorises.size(); ++var3) {
            if (((String)this.lesModelesAutorises.get(var3)).toString().toLowerCase().contains(var1.toLowerCase())) {
               var2 = true;
               break;
            }
         }
      } else {
         var2 = true;
      }

      return var2;
   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "loyer" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setEntete("Impression Loyer");
         var1.setNomMapping("Loyer");
         String var11 = this.utilDate.dateToStringSQLLight(this.dateDebut);
         String var12 = this.utilDate.dateToStringSQLLight(this.dateFin);
         String var13 = "loy_inactif=0 and loy_date_debut<='" + var11 + "' and loy_date_fin>='" + var12 + "'";
         var1.setDateDeb(this.dateDebut);
         var1.setDateFin(this.dateFin);
         int var14 = this.dateFin.getMonth() - this.dateDebut.getMonth() + 1;
         var1.setPage_init(var14);
         String var15 = "";
         String var16 = "";
         if (var14 == 1) {
            var16 = "ETAT MENSUEL des sommes versées en " + (this.dateDebut.getYear() + 1900);
            if (var14 == 1) {
               var15 = "Janvier " + (this.dateDebut.getYear() + 1900);
            } else if (var14 == 2) {
               var15 = "Février " + (this.dateDebut.getYear() + 1900);
            } else if (var14 == 3) {
               var15 = "Mars " + (this.dateDebut.getYear() + 1900);
            } else if (var14 == 4) {
               var15 = "Avril " + (this.dateDebut.getYear() + 1900);
            } else if (var14 == 5) {
               var15 = "Mai " + (this.dateDebut.getYear() + 1900);
            } else if (var14 == 6) {
               var15 = "Juin " + (this.dateDebut.getYear() + 1900);
            } else if (var14 == 7) {
               var15 = "Juillet " + (this.dateDebut.getYear() + 1900);
            } else if (var14 == 8) {
               var15 = "Aout " + (this.dateDebut.getYear() + 1900);
            } else if (var14 == 9) {
               var15 = "Septembre " + (this.dateDebut.getYear() + 1900);
            } else if (var14 == 10) {
               var15 = "Octobre " + (this.dateDebut.getYear() + 1900);
            } else if (var14 == 11) {
               var15 = "Novembre " + (this.dateDebut.getYear() + 1900);
            } else if (var14 == 12) {
               var15 = "Décembre " + (this.dateDebut.getYear() + 1900);
            }
         } else if (var14 == 3) {
            var16 = "ETAT TRIMESTRIEL des sommes versées en " + (this.dateDebut.getYear() + 1900);
            if (var14 <= 3) {
               var15 = "Premier trimestre " + (this.dateDebut.getYear() + 1900);
            } else if (var14 >= 4 && var14 <= 6) {
               var15 = "Deuxième trimestre " + (this.dateDebut.getYear() + 1900);
            } else if (var14 >= 7 && var14 <= 9) {
               var15 = "Troisième trimestre " + (this.dateDebut.getYear() + 1900);
            } else if (var14 >= 10 && var14 <= 12) {
               var15 = "Quatrième trimestre " + (this.dateDebut.getYear() + 1900);
            }
         } else if (var14 == 6) {
            var16 = "ETAT SEMESTRIEL des sommes versées en " + (this.dateDebut.getYear() + 1900);
            if (var14 <= 6) {
               var15 = "Premier semestre " + (this.dateDebut.getYear() + 1900);
            } else {
               var15 = "Deuxième semestre " + (this.dateDebut.getYear() + 1900);
            }
         } else if (var14 == 12) {
            var16 = "ETAT ANNUEL des sommes versées en " + (this.dateDebut.getYear() + 1900);
            var15 = "Année :" + (this.dateDebut.getYear() + 1900);
         } else {
            var15 = "*** Erreur Période ***";
         }

         var1.setVar_nom_col1(var15);
         var1.setVar_nom_col2(var16);
         var1.setRequete(var13);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         ArrayList var17 = new ArrayList();
         JRBeanCollectionDataSource var18 = new JRBeanCollectionDataSource(var17);
         var1.setjRBeanCollectionDataSource(var18);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public String refreshSite() {
      return null;
   }

   public ExercicesComptable getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesComptable var1) {
      this.lastExo = var1;
   }

   public ExercicesComptable getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesComptable var1) {
      this.selectedExo = var1;
   }

   public DataModel getDataModelLesloyers() {
      return this.dataModelLesloyers;
   }

   public void setDataModelLesloyers(DataModel var1) {
      this.dataModelLesloyers = var1;
   }

   public List getLeSCptesChargesOrProdItems() {
      return this.leSCptesChargesOrProdItems;
   }

   public void setLeSCptesChargesOrProdItems(List var1) {
      this.leSCptesChargesOrProdItems = var1;
   }

   public Loyer getLoyer() {
      return this.loyer;
   }

   public void setLoyer(Loyer var1) {
      this.loyer = var1;
   }

   public List getLesCptesImpotsItems() {
      return this.lesCptesImpotsItems;
   }

   public void setLesCptesImpotsItems(List var1) {
      this.lesCptesImpotsItems = var1;
   }

   public List getLesCptestaxesItems() {
      return this.lesCptestaxesItems;
   }

   public void setLeSCptestaxesItems(List var1) {
      this.lesCptestaxesItems = var1;
   }

   public boolean isTestgriserImpot() {
      return this.testgriserImpot;
   }

   public void setTestgriserImpot(boolean var1) {
      this.testgriserImpot = var1;
   }

   public boolean isTestgriserTaxe() {
      return this.testgriserTaxe;
   }

   public void setTestgriserTaxe(boolean var1) {
      this.testgriserTaxe = var1;
   }

   public List getLesCptesTiersItems() {
      return this.lesCptesTiersItems;
   }

   public void setLesCptesTiersItems(List var1) {
      this.lesCptesTiersItems = var1;
   }

   public boolean isTestAffModif() {
      return this.testAffModif;
   }

   public void setTestAffModif(boolean var1) {
      this.testAffModif = var1;
   }

   public String getCpteImpot() {
      return this.cpteImpot;
   }

   public void setCpteImpot(String var1) {
      this.cpteImpot = var1;
   }

   public String getCpteLoyer() {
      return this.cpteLoyer;
   }

   public void setCpteLoyer(String var1) {
      this.cpteLoyer = var1;
   }

   public String getCpteTaxe() {
      return this.cpteTaxe;
   }

   public void setCpteTaxe(String var1) {
      this.cpteTaxe = var1;
   }

   public String getCpteTiers() {
      return this.cpteTiers;
   }

   public void setCpteTiers(String var1) {
      this.cpteTiers = var1;
   }

   public List getLeSCptesChargesItems() {
      return this.leSCptesChargesItems;
   }

   public void setLeSCptesChargesItems(List var1) {
      this.leSCptesChargesItems = var1;
   }

   public List getLeSCptesProdItems() {
      return this.leSCptesProdItems;
   }

   public void setLeSCptesProdItems(List var1) {
      this.leSCptesProdItems = var1;
   }

   public boolean isTypeLoyer() {
      return this.typeLoyer;
   }

   public void setTypeLoyer(boolean var1) {
      this.typeLoyer = var1;
   }

   public List getLesServices() {
      return this.lesServices;
   }

   public void setLesServices(List var1) {
      this.lesServices = var1;
   }

   public List getLesdepartements() {
      return this.lesdepartements;
   }

   public void setLesdepartements(List var1) {
      this.lesdepartements = var1;
   }

   public List getLesSecteur() {
      return this.lesSecteur;
   }

   public void setLesSecteur(List var1) {
      this.lesSecteur = var1;
   }

   public List getLesPointDeVente() {
      return this.lesPointDeVente;
   }

   public void setLesPointDeVente(List var1) {
      this.lesPointDeVente = var1;
   }

   public String getBudget() {
      return this.budget;
   }

   public void setBudget(String var1) {
      this.budget = var1;
   }

   public String getDept() {
      return this.dept;
   }

   public String getCle1() {
      return this.cle1;
   }

   public void setCle1(String var1) {
      this.cle1 = var1;
   }

   public String getDossier() {
      return this.dossier;
   }

   public void setDossier(String var1) {
      this.dossier = var1;
   }

   public String getMission() {
      return this.mission;
   }

   public void setMission(String var1) {
      this.mission = var1;
   }

   public String getParc() {
      return this.parc;
   }

   public void setParc(String var1) {
      this.parc = var1;
   }

   public void setDept(String var1) {
      this.dept = var1;
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

   public List getLesModelsimpression() {
      return this.lesModelsimpression;
   }

   public void setLesModelsimpression(List var1) {
      this.lesModelsimpression = var1;
   }

   public SecteurDao getSecteurDao() {
      return this.secteurDao;
   }

   public void setSecteurDao(SecteurDao var1) {
      this.secteurDao = var1;
   }

   public boolean isVerrouNum() {
      return this.verrouNum;
   }

   public void setVerrouNum(boolean var1) {
      this.verrouNum = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public List getLesActivite() {
      return this.lesActivite;
   }

   public void setLesActivite(List var1) {
      this.lesActivite = var1;
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

   public List getLesloyers() {
      return this.lesloyers;
   }

   public void setLesloyers(List var1) {
      this.lesloyers = var1;
   }

   public Chrono getChrono() {
      return this.chrono;
   }

   public void setChrono(Chrono var1) {
      this.chrono = var1;
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

   public JournauxComptables getJournauxComptables() {
      return this.journauxComptables;
   }

   public void setJournauxComptables(JournauxComptables var1) {
      this.journauxComptables = var1;
   }

   public List getLesElementsTrf() {
      return this.lesElementsTrf;
   }

   public void setLesElementsTrf(List var1) {
      this.lesElementsTrf = var1;
   }

   public List getLesTransfertCompta() {
      return this.lesTransfertCompta;
   }

   public void setLesTransfertCompta(List var1) {
      this.lesTransfertCompta = var1;
   }

   public boolean isShowModalPanelTransfert() {
      return this.showModalPanelTransfert;
   }

   public void setShowModalPanelTransfert(boolean var1) {
      this.showModalPanelTransfert = var1;
   }

   public TransfertCompta getTransfertCompta() {
      return this.transfertCompta;
   }

   public void setTransfertCompta(TransfertCompta var1) {
      this.transfertCompta = var1;
   }

   public CalculChrono getCalculChrono() {
      return this.calculChrono;
   }

   public void setCalculChrono(CalculChrono var1) {
      this.calculChrono = var1;
   }

   public int getTestDossier() {
      return this.testDossier;
   }

   public void setTestDossier(int var1) {
      this.testDossier = var1;
   }

   public boolean isTestMission() {
      return this.testMission;
   }

   public void setTestMission(boolean var1) {
      this.testMission = var1;
   }

   public boolean isTestPVD() {
      return this.testPVD;
   }

   public void setTestPVD(boolean var1) {
      this.testPVD = var1;
   }

   public boolean isTestParc() {
      return this.testParc;
   }

   public void setTestParc(boolean var1) {
      this.testParc = var1;
   }

   public boolean isTestdept() {
      return this.testdept;
   }

   public void setTestdept(boolean var1) {
      this.testdept = var1;
   }

   public boolean isTestreg() {
      return this.testreg;
   }

   public void setTestreg(boolean var1) {
      this.testreg = var1;
   }

   public boolean isTestsecteur() {
      return this.testsecteur;
   }

   public void setTestsecteur(boolean var1) {
      this.testsecteur = var1;
   }

   public boolean isTestservice() {
      return this.testservice;
   }

   public void setTestservice(boolean var1) {
      this.testservice = var1;
   }

   public boolean isTestsite() {
      return this.testsite;
   }

   public void setTestsite(boolean var1) {
      this.testsite = var1;
   }

   public UtilDate getUtilDate() {
      return this.utilDate;
   }

   public void setUtilDate(UtilDate var1) {
      this.utilDate = var1;
   }

   public boolean isTestAgent() {
      return this.testAgent;
   }

   public void setTestAgent(boolean var1) {
      this.testAgent = var1;
   }

   public boolean isTestactivite() {
      return this.testactivite;
   }

   public void setTestactivite(boolean var1) {
      this.testactivite = var1;
   }

   public String getActivite() {
      return this.activite;
   }

   public void setActivite(String var1) {
      this.activite = var1;
   }

   public String getAgent() {
      return this.agent;
   }

   public void setAgent(String var1) {
      this.agent = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }
}
