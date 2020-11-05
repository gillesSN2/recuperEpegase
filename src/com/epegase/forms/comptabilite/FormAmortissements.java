package com.epegase.forms.comptabilite;

import com.epegase.systeme.classe.AmortissementInv;
import com.epegase.systeme.classe.AmortissementReg;
import com.epegase.systeme.classe.AmortissementTab;
import com.epegase.systeme.classe.Amortissements;
import com.epegase.systeme.classe.Android;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.EcrituresModeles;
import com.epegase.systeme.classe.EcrituresModelesLignes;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.TransfertCompta;
import com.epegase.systeme.dao.AmortissementInvDao;
import com.epegase.systeme.dao.AmortissementRegDao;
import com.epegase.systeme.dao.AmortissementTabDao;
import com.epegase.systeme.dao.AmortissementsDao;
import com.epegase.systeme.dao.AndroidDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.EcrituresModelesDao;
import com.epegase.systeme.dao.EcrituresModelesLignesDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LocalisationImmobilisationDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RacinesDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.xml.LectureNatureParc;
import com.epegase.systeme.xml.LireLesoptionsGroupe;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionGroupe;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
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
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.apache.xerces.util.URI;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.json.JSONException;
import org.richfaces.model.selection.SimpleSelection;
import org.xml.sax.SAXException;

public class FormAmortissements implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private String pageIndex;
   private int nature;
   private int var_nb_max = 100;
   private OptionComptabilite optionComptabilite;
   private ExercicesComptable selectedExo;
   private ExercicesComptable lastExo;
   private AmortissementsDao amortissementDao;
   private AmortissementRegDao amortissementRegDao;
   private Amortissements amortissements = new Amortissements();
   private List lesamortissements = new ArrayList();
   private transient DataModel datamodelAmortissement = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private UtilDate utilDate = new UtilDate();
   private PlanComptableDao plancomptableDao;
   private boolean inactif;
   private boolean reinvestissement;
   private Chrono chrono;
   private CalculChrono calculChrono;
   private ChronoDao chronoDao;
   private boolean verrouNum = false;
   private double totalValeurAchat;
   private int nbLigne;
   private boolean testMode = false;
   private boolean presenceParc = false;
   private String natureDetail;
   private List mesNatureDetail = new ArrayList();
   private List mesModelesItems = new ArrayList();
   private EcrituresModelesDao ecrituresModelesDao;
   private EcrituresModelesLignesDao ecrituresModelesLignesDao;
   private int var_nat_bien = 100;
   private String var_periode = "0";
   private String var_compte = "0";
   private String var_localisation;
   private String var_activite;
   private int var_etat = 8;
   private long var_numero;
   private String var_filtretsd = "";
   private String var_chassis;
   private boolean showModalPanelFind = false;
   private List lesPeriodesItems = new ArrayList();
   private SiteDao siteDao;
   private DepartementDao departementDao;
   private ServiceDao serviceDao;
   private RegionDao regionDao;
   private SecteurDao secteurDao;
   private PlansAnalytiquesDao analytiqueDao;
   private PointDeVenteDao pointDeVenteDao;
   private BudgetDao budgetDao;
   private String activite;
   private String site;
   private String dept;
   private String service;
   private String region;
   private String secteur;
   private String pdv;
   private String dossier;
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
   private boolean testParc = false;
   private boolean testagent = false;
   private String compte_immo;
   private String compte_amo;
   private String compte_dot;
   private String compte_ces;
   private String compte_fournisseur;
   private List lesdepartements;
   private List lesServices;
   private List lesSecteur;
   private List lesPointDeVente;
   private List lesplanComptablesCmptDotItems = new ArrayList();
   private List lesplanComptablesCmptAmoItems = new ArrayList();
   private List lesplanComptablesCmptImoItems = new ArrayList();
   private List lesplanComptablesCmptCesItems = new ArrayList();
   private List lesComptesUtilisesItems = new ArrayList();
   private List lesplanComptablesFournisseursItems = new ArrayList();
   private float nbreAnCmp = 0.0F;
   private float nbreAnFix = 0.0F;
   private boolean bttvalider;
   private boolean zoneInterdite = false;
   private List impressionStandardsItems = new ArrayList();
   private UtilNombre utilNombre = new UtilNombre();
   private boolean showModalPanelPrint = false;
   private String format;
   private boolean showModalPanelPrintQrCode = false;
   private AmortissementTab amortissementTab = new AmortissementTab();
   private AmortissementTabDao amortissementTabDao;
   private List lesTableaux = new ArrayList();
   private transient DataModel datamodelTableau = new ListDataModel();
   private double tot_dot_theo;
   private double tot_dot_trf;
   private double ecart_dot;
   private double totAnt = 0.0D;
   private double totDot = 0.0D;
   private int ligneDotation;
   private boolean calculForce = false;
   private boolean shoModalPanelReglement = false;
   private AmortissementReg amortissementReg = new AmortissementReg();
   private List lesamortissementReg = new ArrayList();
   private transient DataModel dataModelReglement = new ListDataModel();
   private double soldeAmort;
   private double tot_reg;
   private boolean visibiliteAmortReg = false;
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
   private List meslocalisationsItems = new ArrayList();
   private UserDao userDao;
   private List lesModelesAutorises;
   private UtilDownload utilDownload = new UtilDownload();
   private boolean var_affFicPdf;
   private String urlphotoProd;
   private boolean existPdfFile;
   private String fileName;
   private String pdfFileName;
   private UploadedFile uploadedFile;
   private UploadedFile uploadedPDFFile;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private boolean showModalPanelScan = false;
   private int typeFichier;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private int choixRacine;
   private String selecFiscalite;
   private AmortissementInv amortissementInv;
   private AmortissementInvDao amortissementInvDao;
   private transient DataModel dataModelInventaire;
   private List lesInventaires;
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
   private URI uri;
   private String coordonnees;
   private String origine;
   private String legende;
   private boolean shoModalPanelMapbox = false;

   public FormAmortissements() throws IOException, SAXException {
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.dataModelInventaire = new ListDataModel();
      this.lesInventaires = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.amortissementDao = new AmortissementsDao(this.baseLog, this.utilInitHibernate);
      this.amortissementRegDao = new AmortissementRegDao(this.baseLog, this.utilInitHibernate);
      this.amortissementTabDao = new AmortissementTabDao(this.baseLog, this.utilInitHibernate);
      this.amortissementInvDao = new AmortissementInvDao(this.baseLog, this.utilInitHibernate);
      this.plancomptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.departementDao = new DepartementDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.regionDao = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.secteurDao = new SecteurDao(this.baseLog, this.utilInitHibernate);
      this.pointDeVenteDao = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
      this.analytiqueDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.budgetDao = new BudgetDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresModelesDao = new EcrituresModelesDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresModelesLignesDao = new EcrituresModelesLignesDao(this.baseLog, this.utilInitHibernate);
   }

   public void initAnalytique(Session var1) throws HibernateException, NamingException {
      if (this.optionComptabilite.getNbLigneMaxAm() != null && !this.optionComptabilite.getNbLigneMaxAm().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxAm());
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
      this.testParc = this.structureLog.isStrParc();
      this.testagent = this.structureLog.isStrAgent();
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

      new ArrayList();
      this.mesModelesItems.clear();
      List var6 = this.ecrituresModelesDao.selectModelesByNature(1, var1);
      if (var6.size() != 0) {
         for(int var3 = 0; var3 < var6.size(); ++var3) {
            this.mesModelesItems.add(new SelectItem(((EcrituresModeles)var6.get(var3)).getModCode(), ((EcrituresModeles)var6.get(var3)).getModCode() + ":" + ((EcrituresModeles)var6.get(var3)).getModLibelle()));
         }
      }

   }

   public void recupAndroidInventnaire() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      Object var2 = new ArrayList();
      LireLesoptionsGroupe var4;
      if (this.structureLog.getStrmaitrecabinet() != 0) {
         new OptionGroupe();
         var4 = new LireLesoptionsGroupe();
         var4.setStrId(this.structureLog.getStrid());
         OptionGroupe var3 = var4.lancerExploitation();
         this.userDao = new UserDao("structure" + var3.getIdGroupe(), this.utilInitHibernate);
         var2 = this.userDao.chargerLesUsers((Session)null);
         this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
         var1 = this.userDao.chargerLesUsers((Session)null);
      }

      Session var18 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
      var4 = null;

      try {
         Transaction var19 = var18.beginTransaction();
         new ArrayList();
         AndroidDao var6 = new AndroidDao(this.baseLog, this.utilInitHibernate);
         var6.majidTier(var18);
         var18.flush();
         List var5 = var6.selectAndroidImmobilisation(var18);
         new Android();
         if (var5.size() != 0) {
            for(int var8 = 0; var8 < var5.size(); ++var8) {
               Android var7 = (Android)var5.get(var8);
               this.amortissements = this.amortissementDao.trouverImmobilisationByNum(var7.getEveIdTie(), var18);
               if (this.amortissements != null) {
                  this.amortissementInv = new AmortissementInv();
                  this.amortissementInv.setAmoinvDateCreat(var7.getEveHoraire());
                  this.amortissementInv.setAmoinvEtat(var7.getEveTraitee());
                  this.amortissementInv.setAmoinvObs(var7.getEveMessage());
                  this.amortissementInv.setAmoinvLongitude(var7.getEveLongitude());
                  this.amortissementInv.setAmoinvLatitude(var7.getEveLatitude());
                  this.amortissementInv.setAmoinvPhoto((String)null);
                  if (this.structureLog.getStrmaitrecabinet() != 0) {
                     long var9 = 0L;

                     label157:
                     for(int var11 = 0; var11 < ((List)var2).size(); ++var11) {
                        if (var7.getEveIdUser() == ((Users)((List)var2).get(var11)).getUsrid()) {
                           int var12 = 0;

                           while(true) {
                              if (var12 >= ((List)var1).size()) {
                                 break label157;
                              }

                              if (((Users)((List)var2).get(var11)).getUsrMail() != null && !((Users)((List)var2).get(var11)).getUsrMail().isEmpty() && ((Users)((List)var1).get(var12)).getUsrMail() != null && !((Users)((List)var1).get(var12)).getUsrMail().isEmpty() && ((Users)((List)var2).get(var11)).getUsrMail().equals(((Users)((List)var1).get(var12)).getUsrMail())) {
                                 var9 = ((Users)((List)var1).get(var12)).getUsrid();
                                 break label157;
                              }

                              ++var12;
                           }
                        }
                     }

                     if (var9 != 0L) {
                        this.amortissementInv.setAmoinvUserCreat(var9);
                     } else {
                        this.amortissementInv.setAmoinvUserCreat(this.usersLog.getUsrid());
                     }
                  } else {
                     this.amortissementInv.setAmoinvUserCreat(var7.getEveIdUser());
                  }

                  this.amortissementInv.setAmortissements(this.amortissements);
                  this.amortissementInv = this.amortissementInvDao.insert(this.amortissementInv, var18);
                  var6.delete(var7, var18);
               }
            }
         }

         var19.commit();
      } catch (HibernateException var16) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void chargerLesComptes(Session var1) throws HibernateException, NamingException {
      this.chargerPlanComptables(var1);
      this.lesComptesUtilisesItems = this.amortissementDao.chargerCompteImoUtilise(var1);
      this.lesplanComptablesFournisseursItems = this.plancomptableDao.chargerPlanCmptItems(this.selecFiscalite, this.selectedExo.getExecpt_id(), "(6)", 0, var1);
      this.lesPeriodesItems.clear();
      this.lesPeriodesItems = this.amortissementDao.chargerAnneeUtilisee(var1);
   }

   public void chargerPlanComptables(Session var1) throws HibernateException, NamingException {
      this.lesplanComptablesCmptImoItems.clear();
      this.lesplanComptablesCmptAmoItems.clear();
      this.lesplanComptablesCmptDotItems.clear();
      this.lesplanComptablesCmptCesItems.clear();
      this.compte_immo = "";
      this.compte_amo = "";
      this.compte_dot = "";
      this.compte_ces = "";
      if (this.amortissements == null || this.amortissements.getAmoModele() == null || this.amortissements.getAmoModele().isEmpty() || this.amortissements.getAmoModele() != null && !this.amortissements.getAmoModele().isEmpty() && this.amortissements.getAmoModele().equals("XXX")) {
         this.lesplanComptablesCmptImoItems = this.plancomptableDao.chargerPlanCmptItems(this.selecFiscalite, this.selectedExo.getExecpt_id(), "(3,16)", 0, var1);
         this.lesplanComptablesCmptAmoItems = this.plancomptableDao.chargerPlanCmptItems(this.selecFiscalite, this.selectedExo.getExecpt_id(), "(4)", 0, var1);
         this.lesplanComptablesCmptDotItems = this.plancomptableDao.chargerPlanCmptItems(this.selecFiscalite, this.selectedExo.getExecpt_id(), "(18)", 0, var1);
         this.lesplanComptablesCmptCesItems = this.plancomptableDao.chargerPlanCmptItems(this.selecFiscalite, this.selectedExo.getExecpt_id(), "(25)", 0, var1);
      } else {
         new ArrayList();
         new EcrituresModeles();
         EcrituresModeles var3 = this.ecrituresModelesDao.chargerModele(this.amortissements.getAmoModele(), var1);
         if (var3 != null) {
            List var2 = this.ecrituresModelesLignesDao.selectModelesLignes(var3, var1);
            if (var2.size() != 0) {
               for(int var4 = 0; var4 < var2.size(); ++var4) {
                  if (((EcrituresModelesLignes)var2.get(var4)).getModligNature() == 1) {
                     this.lesplanComptablesCmptImoItems.add(new SelectItem(((EcrituresModelesLignes)var2.get(var4)).getModligCompte(), ((EcrituresModelesLignes)var2.get(var4)).getModligCompte() + ":" + ((EcrituresModelesLignes)var2.get(var4)).getModligLibelle()));
                     this.compte_immo = ((EcrituresModelesLignes)var2.get(var4)).getModligCompte();
                  } else if (((EcrituresModelesLignes)var2.get(var4)).getModligNature() == 2) {
                     this.lesplanComptablesCmptAmoItems.add(new SelectItem(((EcrituresModelesLignes)var2.get(var4)).getModligCompte(), ((EcrituresModelesLignes)var2.get(var4)).getModligCompte() + ":" + ((EcrituresModelesLignes)var2.get(var4)).getModligLibelle()));
                     this.compte_amo = ((EcrituresModelesLignes)var2.get(var4)).getModligCompte();
                  } else if (((EcrituresModelesLignes)var2.get(var4)).getModligNature() == 3) {
                     this.lesplanComptablesCmptDotItems.add(new SelectItem(((EcrituresModelesLignes)var2.get(var4)).getModligCompte(), ((EcrituresModelesLignes)var2.get(var4)).getModligCompte() + ":" + ((EcrituresModelesLignes)var2.get(var4)).getModligLibelle()));
                     this.compte_dot = ((EcrituresModelesLignes)var2.get(var4)).getModligCompte();
                  } else if (((EcrituresModelesLignes)var2.get(var4)).getModligNature() == 4) {
                     this.lesplanComptablesCmptCesItems.add(new SelectItem(((EcrituresModelesLignes)var2.get(var4)).getModligCompte(), ((EcrituresModelesLignes)var2.get(var4)).getModligCompte() + ":" + ((EcrituresModelesLignes)var2.get(var4)).getModligLibelle()));
                     this.compte_ces = ((EcrituresModelesLignes)var2.get(var4)).getModligCompte();
                  }
               }
            }
         }
      }

   }

   public void chargerLesLocalisations(Session var1) throws HibernateException, NamingException {
      LocalisationImmobilisationDao var2 = new LocalisationImmobilisationDao(this.baseLog, this.utilInitHibernate);
      this.meslocalisationsItems = var2.chargerLesLocalisationImmobilisation(var1);
   }

   public void verifPresenceParc(Session var1) {
      boolean var2 = false;
      Object var3 = var1.createQuery("SELECT COUNT(*) FROM ExercicesParc").uniqueResult();
      int var5 = Integer.parseInt(var3.toString());
      if (var5 > 0) {
         this.presenceParc = true;
         LectureNatureParc var4 = new LectureNatureParc(this.baseLog);
         this.mesNatureDetail = var4.getMesNatureParcItems();
      } else {
         this.presenceParc = false;
      }

   }

   public void recherche() throws HibernateException, NamingException, ParseException {
      this.lesamortissements.clear();
      if (this.dateDebut == null) {
         this.dateDebut = this.selectedExo.getExecptDateDebut();
      }

      if (this.dateFin == null) {
         this.dateFin = this.selectedExo.getExecptDateFin();
      }

      this.lesamortissements = this.amortissementDao.selectAmortissement(this.var_periode, this.dateDebut, this.dateFin, this.var_etat, this.var_compte, this.var_localisation, this.var_activite, this.var_numero, this.var_filtretsd, this.var_chassis, this.var_nat_bien, (Session)null);
      this.totalValeurAchat = 0.0D;
      this.nbLigne = 0;
      if (this.lesamortissements.size() != 0) {
         for(int var1 = 0; var1 < this.lesamortissements.size(); this.nbLigne = var1++) {
            this.totalValeurAchat += ((Amortissements)this.lesamortissements.get(var1)).getAmoValeurAchat();
         }

         ++this.nbLigne;
      }

      this.datamodelAmortissement.setWrappedData(this.lesamortissements);
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.amortissements = new Amortissements();
   }

   public void autreFiltre() {
      this.showModalPanelFind = true;
   }

   public void fermeAutreFiltre() {
      this.showModalPanelFind = false;
   }

   public void ValideAutreFiltre() {
      this.showModalPanelFind = false;
   }

   public void ajoutImmo() throws HibernateException, NamingException {
      this.compte_immo = "";
      this.compte_amo = "";
      this.compte_dot = "";
      this.compte_ces = "";
      this.amortissements = new Amortissements();
      this.lesdepartements = new ArrayList();
      this.lesServices = new ArrayList();
      this.lesSecteur = new ArrayList();
      this.lesPointDeVente = new ArrayList();
      this.verifExitChrono();
      this.amortissements.setAmoDateAchat(new Date());
      this.activite = "";
      this.site = "";
      this.dept = "";
      this.service = "";
      this.region = "";
      this.secteur = "";
      this.pdv = "";
      this.dossier = "";
      this.parc = "";
      this.cle1 = "";
      this.agent = "";
      this.budget = "";
      this.bttvalider = false;
      this.inactif = false;
      this.reinvestissement = false;
      if (this.decoupageActivite) {
         this.lesDecoupagesActivites.clear();
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

      this.zoneInterdite = false;
      this.var_action = 1;
   }

   public void modifImmo() throws ParseException, HibernateException, NamingException, IOException, SQLException {
      if (this.amortissements != null) {
         this.ligneCommune();
         this.bttvalider = true;
         this.var_action = 2;
      }

   }

   public void consultImmo() throws HibernateException, NamingException, IOException, SQLException {
      if (this.amortissements != null) {
         this.ligneCommune();
         this.bttvalider = false;
         this.var_action = 3;
      }

   }

   public void selectionAmortissement() throws HibernateException, NamingException, IOException, SQLException {
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
            this.amortissements = (Amortissements)var1.get(0);
            this.ligneCommune();
         }
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, SQLException {
      if (this.datamodelAmortissement.isRowAvailable()) {
         this.amortissements = (Amortissements)this.datamodelAmortissement.getRowData();
         this.ligneCommune();
      }

   }

   public void ligneCommune() throws HibernateException, NamingException, IOException, SQLException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
      this.calculForce = false;
      this.chargerPlanComptables(var1);
      this.chargerTableaux(var1);
      this.chargerReglements(var1);
      this.chargerInventaires(var1);
      this.affichePhotoProduit();
      this.showModalPanelPrintQrCode = false;
      this.utilInitHibernate.closeSession();
      this.lesdepartements = new ArrayList();
      this.lesServices = new ArrayList();
      this.lesSecteur = new ArrayList();
      this.lesPointDeVente = new ArrayList();
      if (this.amortissements.getAmoInactif() == 0) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      if (this.amortissements.getAmoReinvestissement() == 0) {
         this.reinvestissement = false;
      } else {
         this.reinvestissement = true;
      }

      if (this.amortissements.getAmoCompteAmo() != null && !this.amortissements.getAmoCompteAmo().isEmpty()) {
         this.compte_amo = this.amortissements.getAmoCompteAmo();
      } else {
         this.compte_amo = "";
      }

      if (this.amortissements.getAmoCompteImmo() != null && !this.amortissements.getAmoCompteImmo().isEmpty()) {
         this.compte_immo = this.amortissements.getAmoCompteImmo();
      } else {
         this.compte_immo = "";
      }

      if (this.amortissements.getAmoCompteDotation() != null && !this.amortissements.getAmoCompteDotation().isEmpty()) {
         this.compte_dot = this.amortissements.getAmoCompteDotation();
      } else {
         this.compte_dot = "";
      }

      if (this.amortissements.getAmoCompteCes() != null && !this.amortissements.getAmoCompteCes().isEmpty()) {
         this.compte_ces = this.amortissements.getAmoCompteCes();
      } else {
         this.compte_ces = "";
      }

      if (this.amortissements.getAmoFournisseur() != null && !this.amortissements.getAmoFournisseur().isEmpty()) {
         this.compte_fournisseur = this.amortissements.getAmoFournisseur();
      } else {
         this.compte_fournisseur = "";
      }

      if (this.decoupageActivite) {
         this.chargerDetailanalytique();
         this.controleEcartAnalytique();
         this.activite = this.amortissements.getAmoActivite();
      } else if (this.amortissements.getAmoActivite() != null && !this.amortissements.getAmoActivite().isEmpty()) {
         this.activite = this.amortissements.getAmoActivite() + ":" + this.amortissements.getAmoLibActivite();
      } else {
         this.activite = "";
      }

      if (this.amortissements.getAmoBudget() != null && !this.amortissements.getAmoBudget().isEmpty()) {
         this.budget = this.amortissements.getAmoBudget() + ":" + this.amortissements.getAmoLibBudget();
      } else {
         this.budget = "";
      }

      if (this.amortissements.getAmoSite() != null && !this.amortissements.getAmoSite().isEmpty()) {
         this.site = this.amortissements.getAmoSite() + ":" + this.amortissements.getAmoLibSite();
      } else {
         this.site = "";
      }

      if (this.amortissements.getAmoDepartement() != null && !this.amortissements.getAmoDepartement().isEmpty()) {
         this.dept = this.amortissements.getAmoDepartement() + ":" + this.amortissements.getAmoLibDepartement();
         this.lesdepartements.add(new SelectItem(this.dept));
      } else {
         this.dept = "";
      }

      if (this.amortissements.getAmoService() != null && !this.amortissements.getAmoService().isEmpty()) {
         this.service = this.amortissements.getAmoService() + ":" + this.amortissements.getAmoLibService();
         this.lesServices.add(new SelectItem(this.service));
      } else {
         this.service = "";
      }

      if (this.amortissements.getAmoRegion() != null && !this.amortissements.getAmoRegion().isEmpty()) {
         this.region = this.amortissements.getAmoRegion() + ":" + this.amortissements.getAmoLibRegion();
      } else {
         this.region = "";
      }

      if (this.amortissements.getAmoSecteur() != null && !this.amortissements.getAmoSecteur().isEmpty()) {
         this.secteur = this.amortissements.getAmoSecteur() + ":" + this.amortissements.getAmoLibSecteur();
         this.lesSecteur.add(new SelectItem(this.secteur));
      } else {
         this.secteur = "";
      }

      if (this.amortissements.getAmoPdv() != null && !this.amortissements.getAmoPdv().isEmpty()) {
         this.pdv = this.amortissements.getAmoPdv() + ":" + this.amortissements.getAmoLibPdv();
         this.lesPointDeVente.add(new SelectItem(this.pdv));
      } else {
         this.pdv = "";
      }

      if (this.amortissements.getAmoDossier() != null && !this.amortissements.getAmoDossier().isEmpty()) {
         this.dossier = this.amortissements.getAmoDossier() + ":" + this.amortissements.getAmoLibDossier();
      } else {
         this.dossier = "";
      }

      if (this.amortissements.getAmoParc() != null && !this.amortissements.getAmoParc().isEmpty()) {
         this.parc = this.amortissements.getAmoParc() + ":" + this.amortissements.getAmoLibParc();
      } else {
         this.parc = "";
      }

      if (this.amortissements.getAmoAgent() != null && !this.amortissements.getAmoAgent().isEmpty()) {
         this.agent = this.amortissements.getAmoAgent() + ":" + this.amortissements.getAmoLibAgent();
      } else {
         this.agent = "";
      }

      if (this.amortissements.getAmoCle1() != null && !this.amortissements.getAmoCle1().isEmpty()) {
         this.cle1 = this.amortissements.getAmoCle1() + ":" + this.amortissements.getAmoLibCle1();
      } else {
         this.cle1 = "";
      }

      if (this.amortissements.getAmoNatureDetail() != 0) {
         this.natureDetail = this.amortissements.getAmoNatureDetail() + ":" + this.amortissements.getAmoNatureDetailLib();
      } else {
         this.natureDetail = "";
      }

   }

   public void chargerTableaux(Session var1) throws HibernateException, NamingException {
      this.calculForce = false;
      this.lesTableaux.clear();
      this.lesTableaux = this.amortissementTabDao.chargeTableau(this.amortissements, var1);
      this.datamodelTableau.setWrappedData(this.lesTableaux);
      this.tot_dot_theo = 0.0D;
      this.tot_dot_trf = 0.0D;
      this.ecart_dot = 0.0D;
      if (this.lesTableaux.size() != 0) {
         for(int var2 = 0; var2 < this.lesTableaux.size(); ++var2) {
            this.tot_dot_theo += ((AmortissementTab)this.lesTableaux.get(var2)).getAmotabMontant();
            this.tot_dot_trf += ((AmortissementTab)this.lesTableaux.get(var2)).getAmotabValeur();
            if (((AmortissementTab)this.lesTableaux.get(var2)).getAmotabMontantForce() == 1) {
               this.calculForce = true;
            }
         }

         this.ecart_dot = this.tot_dot_theo - this.tot_dot_trf;
      }

      if (this.tot_dot_trf != 0.0D) {
         this.zoneInterdite = true;
      } else {
         this.zoneInterdite = false;
      }

   }

   public void chargerReglements(Session var1) throws HibernateException, NamingException {
      this.lesamortissementReg.clear();
      this.lesamortissementReg = this.amortissementRegDao.chargerReglement(this.amortissements, var1);
      this.dataModelReglement.setWrappedData(this.lesamortissementReg);
      this.soldeAmort = 0.0D;
      this.tot_reg = 0.0D;
      if (this.lesamortissementReg.size() != 0) {
         for(int var2 = 0; var2 < this.lesamortissementReg.size(); ++var2) {
            this.tot_reg += ((AmortissementReg)this.lesamortissementReg.get(var2)).getAmoregMontant();
         }

         this.soldeAmort = this.amortissements.getAmoNetAPayer() - this.tot_reg;
      }

   }

   public void chargerInventaires(Session var1) throws HibernateException, NamingException {
      this.lesInventaires.clear();
      this.lesInventaires = this.amortissementInvDao.chargerInventaire(this.amortissements, var1);
      if (this.lesInventaires.size() != 0) {
         new ArrayList();
         List var2 = this.userDao.chargerLesUsers(var1);

         for(int var3 = 0; var3 < this.lesInventaires.size(); ++var3) {
            this.amortissementInv = (AmortissementInv)this.lesInventaires.get(var3);

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               if (this.amortissementInv.getAmoinvUserCreat() == ((Users)var2.get(var4)).getUsrid()) {
                  this.amortissementInv.setLibelleAgent(((Users)var2.get(var4)).getUsrPatronyme());
                  break;
               }
            }
         }
      }

      this.dataModelInventaire.setWrappedData(this.lesInventaires);
   }

   public void reactiverCompte() throws HibernateException, NamingException {
      this.amortissements.setAmoDateModif(new Date());
      this.amortissements.setAmoUserModif(Integer.parseInt(Long.toString(this.usersLog.getUsrid())));
      this.amortissements.setAmoInactif(0);
      this.amortissements = this.amortissementDao.modif(this.amortissements);
   }

   public void removeCompte() throws HibernateException, NamingException {
      this.amortissements.setAmoDateModif(new Date());
      this.amortissements.setAmoUserModif(Integer.parseInt(Long.toString(this.usersLog.getUsrid())));
      this.amortissements.setAmoInactif(2);
      this.amortissements = this.amortissementDao.modif(this.amortissements);
   }

   public void removeSelectedImmo() throws NamingException, NamingException {
      if (this.amortissements != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            int var3;
            if (this.lesTableaux.size() != 0) {
               for(var3 = 0; var3 < this.lesTableaux.size(); ++var3) {
                  this.amortissementTab = new AmortissementTab();
                  this.amortissementTab = (AmortissementTab)this.lesTableaux.get(var3);
                  this.amortissementTabDao.delete(this.amortissementTab, var1);
                  var1.flush();
               }
            }

            if (this.lesamortissementReg.size() != 0) {
               for(var3 = 0; var3 < this.lesamortissementReg.size(); ++var3) {
                  this.amortissementReg = new AmortissementReg();
                  this.amortissementReg = (AmortissementReg)this.lesamortissementReg.get(var3);
                  this.amortissementRegDao.delete(this.amortissementReg, var1);
                  var1.flush();
               }
            }

            this.amortissementDao.delete(this.amortissements, var1);
            var1.flush();
            this.lesamortissements.remove(this.amortissements);
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

   }

   public void annulerSaisie() {
      this.var_action = 0;
   }

   public void saveAmortissements() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.amortissements.getAmoTauxComptable() <= 100.0F && this.amortissements.getAmoTauxFiscal() <= 100.0F && this.amortissements.getAmoTvaTaux() <= 100.0F) {
            this.setBttvalider(false);
            if (this.decoupageActivite) {
               String var3 = "";
               boolean var4 = true;
               if (this.lesDecoupagesActivites.size() != 0) {
                  for(int var5 = 0; var5 < this.lesDecoupagesActivites.size(); ++var5) {
                     this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var5);
                     if (this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
                        if (var4) {
                           var3 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                           var4 = false;
                        } else {
                           var3 = var3 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage();
                        }
                     }
                  }
               }

               this.amortissements.setAmoActivite(var3);
               this.amortissements.setAmoLibActivite("DécoupageActivité");
            } else {
               this.amortissements.setAmoActivite(this.splitForCpte(this.activite));
               this.amortissements.setAmoLibActivite(this.splitForLib(this.activite));
            }

            this.amortissements.setAmoSite(this.splitForCpte(this.site));
            this.amortissements.setAmoLibSite(this.splitForLib(this.site));
            this.amortissements.setAmoDepartement(this.splitForCpte(this.dept));
            this.amortissements.setAmoLibDepartement(this.splitForLib(this.dept));
            this.amortissements.setAmoService(this.splitForCpte(this.service));
            this.amortissements.setAmoLibService(this.splitForLib(this.service));
            this.amortissements.setAmoRegion(this.splitForCpte(this.region));
            this.amortissements.setAmoLibRegion(this.splitForLib(this.region));
            this.amortissements.setAmoSecteur(this.splitForCpte(this.secteur));
            this.amortissements.setAmoLibSecteur(this.splitForLib(this.secteur));
            this.amortissements.setAmoPdv(this.splitForCpte(this.pdv));
            this.amortissements.setAmoLibPdv(this.splitForLib(this.pdv));
            this.amortissements.setAmoDossier(this.splitForCpte(this.dossier));
            this.amortissements.setAmoLibDossier(this.splitForLib(this.dossier));
            this.amortissements.setAmoParc(this.splitForCpte(this.parc));
            this.amortissements.setAmoLibParc(this.splitForLib(this.parc));
            this.amortissements.setAmoAgent(this.splitForCpte(this.agent));
            this.amortissements.setAmoLibAgent(this.splitForLib(this.agent));
            this.amortissements.setAmoCle1(this.splitForCpte(this.cle1));
            this.amortissements.setAmoLibCle1(this.splitForLib(this.cle1));
            this.amortissements.setAmoBudget(this.splitForCpte(this.budget));
            this.amortissements.setAmoLibBudget(this.splitForLib(this.budget));
            this.amortissements.setAmoCompteAmo(this.compte_amo);
            this.amortissements.setAmoLibCompteAmo(this.chercherLib(this.compte_amo, this.lesplanComptablesCmptAmoItems));
            this.amortissements.setAmoCompteImmo(this.compte_immo);
            this.amortissements.setAmoLibCompteImo(this.chercherLib(this.compte_immo, this.lesplanComptablesCmptImoItems));
            this.amortissements.setAmoCompteDotation(this.compte_dot);
            this.amortissements.setAmoLibCompteDot(this.chercherLib(this.compte_dot, this.lesplanComptablesCmptDotItems));
            this.amortissements.setAmoCompteCes(this.compte_ces);
            this.amortissements.setAmoLibCompteCes(this.chercherLib(this.compte_ces, this.lesplanComptablesCmptCesItems));
            this.amortissements.setAmoFournisseur(this.compte_fournisseur);
            this.amortissements.setAmoLibFournisseur(this.chercherLib(this.compte_fournisseur, this.lesplanComptablesFournisseursItems));
            if (this.amortissements.getAmoNature() == 3) {
               this.amortissements.setAmoCompteAmo("");
               this.amortissements.setAmoLibCompteAmo("");
               this.amortissements.setAmoCompteDotation("");
               this.amortissements.setAmoLibCompteDot("");
               this.amortissements.setAmoCompteCes("");
               this.amortissements.setAmoLibCompteCes("");
            }

            boolean var11 = false;
            String var13 = this.splitForCpte(this.natureDetail);
            int var12;
            if (var13 != null && !var13.isEmpty()) {
               var12 = Integer.parseInt(var13);
            } else {
               var12 = 0;
            }

            this.amortissements.setAmoNatureDetail(var12);
            this.amortissements.setAmoNatureDetailLib(this.splitForLib(this.natureDetail));
            if (!this.inactif) {
               this.amortissements.setAmoInactif(0);
            } else {
               this.amortissements.setAmoInactif(1);
            }

            if (!this.reinvestissement) {
               this.amortissements.setAmoReinvestissement(0);
            } else {
               this.amortissements.setAmoReinvestissement(1);
            }

            if (this.amortissements.getAmoTypeSortie() == 0) {
               this.amortissements.setAmoDateSortie((Date)null);
               this.amortissements.setAmoValeurCession(0.0D);
               this.amortissements.setAmoFraisAnnexe(0.0D);
               this.amortissements.setAmoFraisAnnexe(0.0D);
               this.amortissements.setAmoTvaResiduelle(0.0D);
               this.amortissements.setAmoNetAPayer(0.0D);
               this.amortissements.setAmoNomClient("");
               this.amortissements.setAmoPieceCession("");
               this.amortissements.setAmoFactureCession("");
               this.amortissements.setAmoReinvestissement(0);
            } else if (this.amortissements.getAmoTypeSortie() == 2) {
               this.amortissements.setAmoValeurCession(0.0D);
               this.amortissements.setAmoFraisAnnexe(0.0D);
               this.amortissements.setAmoFraisAnnexe(0.0D);
               this.amortissements.setAmoTvaResiduelle(0.0D);
               this.amortissements.setAmoNetAPayer(0.0D);
               this.amortissements.setAmoNomClient("");
               this.amortissements.setAmoPieceCession("");
               this.amortissements.setAmoFactureCession("");
               this.amortissements.setAmoReinvestissement(0);
            }

            if (this.amortissements.getAmoId() == 0L) {
               if (this.verrouNum) {
                  this.amortissements.setAmoNum(this.numCompose(var1));
               } else {
                  this.amortissements.setAmoNum(this.amortissementDao.trouverDernier(var1));
               }

               this.amortissements.setAmoDateCreat(new Date());
               this.amortissements.setAmoUserCreat((long)Integer.parseInt(Long.toString(this.usersLog.getUsrid())));
               this.amortissements = this.amortissementDao.insert(this.amortissements, var1);
               this.lesamortissements.add(this.amortissements);
               this.datamodelAmortissement.setWrappedData(this.lesamortissements);
               this.simpleSelectionEntete.clear();
               this.extDTable = new HtmlExtendedDataTable();
               this.calculeTableau(var1);
            } else {
               if (this.amortissements.getAmoNum() == 0L) {
                  this.amortissements.setAmoNum((long)((int)this.amortissements.getAmoId()));
               }

               this.amortissements.setAmoDateModif(new Date());
               this.amortissements.setAmoUserModif(Integer.parseInt(Long.toString(this.usersLog.getUsrid())));
               this.amortissements = this.amortissementDao.modif(this.amortissements, var1);
               if (!this.calculForce) {
                  this.supprimeTableau(var1);
                  this.calculeTableau(var1);
                  this.calculValeurCedee(var1);
               } else {
                  this.majCalculForce(var1);
               }
            }
         } else {
            this.setBttvalider(true);
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

      this.var_action = 0;
   }

   public void calculeTableauInit() throws NamingException, ParseException {
      if (this.lesTableaux.size() == 0) {
         this.calculeTableau();
      }

   }

   public void calculeTableau() throws NamingException, ParseException {
      this.calculeTableau((Session)null);
   }

   public void calculeTableau(Session var1) throws NamingException, ParseException {
      if (this.amortissements != null && this.amortissements.getAmoTauxComptable() != 0.0F && this.amortissements.getAmoNature() != 3 && this.amortissements.getAmoDateAchat() != null) {
         if (this.amortissements.getAmoNbAnneeCpte() == 0.0F) {
            this.calculNbreAnCmptble();
         }

         if (this.amortissements.getAmoTauxComptable() > 100.0F) {
            this.amortissements.setAmoTauxComptable(100.0F);
         }

         Date var2 = null;
         if (this.amortissements.getAmoDateService() != null) {
            var2 = this.amortissements.getAmoDateService();
            if (var2.getYear() + 1900 < 1950) {
               var2 = this.amortissements.getAmoDateAchat();
            }
         } else {
            var2 = this.amortissements.getAmoDateAchat();
         }

         if (var2.getYear() + 1900 < 1950) {
            var2 = null;
         }

         if (var2 != null) {
            double var3 = 0.0D;
            if (this.optionComptabilite.getCalculImmobilisation().equals("1")) {
               var3 = this.amortissements.getAmoValeurAchat() * (double)(this.amortissements.getAmoTauxComptable() / 100.0F) / 360.0D;
            } else {
               var3 = this.amortissements.getAmoValeurAchat() * (double)(this.amortissements.getAmoTauxComptable() / 100.0F) / 365.0D;
            }

            Date var5 = var2;
            Date var6 = null;
            double var7 = this.amortissements.getAmoValeurAchat();
            double var9 = 0.0D;
            boolean var11 = false;
            boolean var12 = false;

            int var18;
            for(int var13 = 0; var7 > 0.0D; ++var13) {
               if (this.optionComptabilite.getCalculImmobilisation().equals("1")) {
                  if (!var12) {
                     var18 = 30;
                     if (var5.getDate() != 1) {
                        var18 = var18 - var5.getDate() - 1;
                     }
                  } else {
                     var18 = 30;
                  }
               } else if (!var12) {
                  var18 = this.utilDate.dateNbJourMois(var5);
                  if (var5.getDate() != 1) {
                     var18 = var18 - var5.getDate() - 1;
                  }
               } else {
                  var18 = this.utilDate.dateNbJourMois(var5);
               }

               if (var18 >= 1) {
                  var9 = this.utilNombre.myRoundDevise(var3 * (double)var18, this.structureLog.getStrdevise());
                  if (var7 <= var9) {
                     double var14 = 0.0D;

                     for(int var16 = 0; var16 < this.lesTableaux.size(); ++var16) {
                        var14 += ((AmortissementTab)this.lesTableaux.get(var16)).getAmotabMontant();
                     }

                     var9 = this.amortissements.getAmoValeurAchat() - var14;
                     var7 = 0.0D;
                  } else {
                     var7 -= var9;
                  }

                  this.amortissementTab = new AmortissementTab();
                  this.amortissementTab.setAmortissements(this.amortissements);
                  if (!var12) {
                     this.amortissementTab.setAmotabDateDeb(var2);
                  } else {
                     this.amortissementTab.setAmotabDateDeb(this.utilDate.datePremierJourMois(var5));
                  }

                  this.amortissementTab.setAmotabDateFin(this.utilDate.dateDernierJourMois(var5));
                  this.amortissementTab.setAmotabMontant(var9);
                  this.amortissementTab.setAmotabVnc(var7);
                  var12 = true;
                  boolean var20 = false;

                  for(int var15 = 0; var15 < this.lesTableaux.size(); ++var15) {
                     if (this.amortissementTab.getAmotabDateDeb().compareTo(((AmortissementTab)this.lesTableaux.get(var15)).getAmotabDateDeb()) == 0 && this.amortissementTab.getAmotabDateFin().compareTo(((AmortissementTab)this.lesTableaux.get(var15)).getAmotabDateFin()) == 0) {
                        var20 = true;
                        break;
                     }
                  }

                  if (!var20) {
                     this.lesTableaux.add(this.amortissementTab);
                  }
               }

               var5 = this.utilDate.dateMoisSuivant(var5);
            }

            UtilTrie var19 = new UtilTrie();
            this.lesTableaux = var19.triListeAmortissementDate(this.lesTableaux);
            int var21;
            if (this.amortissements.getAmoDateAnterieur() != null && this.amortissements.getAmoAnterieur() != 0.0D) {
               var6 = this.amortissements.getAmoDateAnterieur();
               var7 = this.amortissements.getAmoValeurAchat() - this.amortissements.getAmoAnterieur();
               var21 = 0;

               label154:
               while(true) {
                  if (var21 >= this.lesTableaux.size()) {
                     var18 = 0;

                     for(var21 = 0; var21 < this.lesTableaux.size(); ++var21) {
                        this.amortissementTab = (AmortissementTab)this.lesTableaux.get(var21);
                        if (this.amortissementTab.getAmotabDateFin().compareTo(var6) > 0) {
                           if (this.optionComptabilite.getCalculImmobilisation().equals("1")) {
                              var18 += 30;
                           } else {
                              var18 += this.utilDate.dateNbJourMois(this.amortissementTab.getAmotabDateDeb());
                           }
                        }
                     }

                     var3 = (this.amortissements.getAmoValeurAchat() - this.amortissements.getAmoAnterieur()) / (double)var18;
                     var21 = 0;

                     while(true) {
                        if (var21 >= this.lesTableaux.size()) {
                           break label154;
                        }

                        this.amortissementTab = (AmortissementTab)this.lesTableaux.get(var21);
                        if (this.amortissementTab.getAmotabDateFin().compareTo(var6) > 0) {
                           if (this.optionComptabilite.getCalculImmobilisation().equals("1")) {
                              var18 = 30;
                           } else {
                              var18 = this.utilDate.dateNbJourMois(this.amortissementTab.getAmotabDateDeb());
                           }

                           var9 = this.utilNombre.myRoundDevise(var3 * (double)var18, this.structureLog.getStrdevise());
                           if (var21 + 1 == this.lesTableaux.size()) {
                              double var22 = 0.0D;

                              for(int var17 = 0; var17 < this.lesTableaux.size(); ++var17) {
                                 var22 += ((AmortissementTab)this.lesTableaux.get(var17)).getAmotabMontant();
                              }

                              var9 = this.amortissements.getAmoValeurAchat() - var22;
                              this.amortissementTab.setAmotabMontant(var9);
                              this.amortissementTab.setAmotabVnc(0.0D);
                              break label154;
                           }

                           var7 -= var9;
                           this.amortissementTab.setAmotabMontant(var9);
                           this.amortissementTab.setAmotabVnc(var7);
                        }

                        ++var21;
                     }
                  }

                  this.amortissementTab = (AmortissementTab)this.lesTableaux.get(var21);
                  if (this.amortissementTab.getAmotabDateDeb().compareTo(var6) != 0 && this.amortissementTab.getAmotabDateFin().compareTo(var6) != 0) {
                     if (this.amortissementTab.getAmotabDateDeb().compareTo(var6) < 0) {
                        this.amortissementTab.setAmotabMontant(0.0D);
                        this.amortissementTab.setAmotabVnc(0.0D);
                     } else if (this.amortissementTab.getAmotabDateFin().compareTo(var6) > 0) {
                        this.amortissementTab.setAmotabMontant(0.0D);
                        this.amortissementTab.setAmotabVnc(0.0D);
                     }
                  } else {
                     this.amortissementTab.setAmotabMontant(this.amortissements.getAmoAnterieur());
                     this.amortissementTab.setAmotabVnc(var7);
                  }

                  ++var21;
               }
            }

            this.tot_dot_theo = 0.0D;
            this.tot_dot_trf = 0.0D;
            this.ecart_dot = 0.0D;

            for(var21 = 0; var21 < this.lesTableaux.size(); ++var21) {
               this.tot_dot_theo += ((AmortissementTab)this.lesTableaux.get(var21)).getAmotabMontant();
               this.tot_dot_trf += ((AmortissementTab)this.lesTableaux.get(var21)).getAmotabValeur();
            }

            this.ecart_dot = this.tot_dot_theo - this.tot_dot_trf;
            if (this.lesTableaux.size() != 0) {
               if (var1 != null) {
                  this.amortissementTabDao.maj(this.lesTableaux, var1);
               } else {
                  this.amortissementTabDao.maj(this.lesTableaux);
               }
            }
         }
      }

   }

   public void supprimeTableau() throws HibernateException, NamingException {
      this.supprimeTableau((Session)null);
   }

   public void supprimeTableau(Session var1) throws HibernateException, NamingException {
      if (this.lesTableaux.size() != 0) {
         ArrayList var2 = new ArrayList();
         if (this.lesTableaux.size() != 0) {
            for(int var3 = 0; var3 < this.lesTableaux.size(); ++var3) {
               this.amortissementTab = (AmortissementTab)this.lesTableaux.get(var3);
               if (this.amortissementTab.getAmotabDateTrf() == null) {
                  var2.add(this.amortissementTab);
               }
            }
         }

         if (var1 != null) {
            this.amortissementTabDao.delete((List)var2, var1);
         } else {
            this.amortissementTabDao.delete(var2);
         }

         this.lesTableaux.clear();
         this.lesTableaux = this.amortissementTabDao.chargeTableau(this.amortissements, var1);
      }

   }

   public void calculValeurCedee() throws HibernateException, NamingException {
      this.calculValeurCedee((Session)null);
   }

   public void calculValeurCedee(Session var1) throws HibernateException, NamingException {
      if (this.amortissements.getAmoDateSortie() != null) {
         List var2;
         if (var1 != null) {
            new ArrayList();
            var2 = this.amortissementTabDao.chargeTableau(this.amortissements, var1);
            if (var2.size() != 0) {
               for(int var3 = 0; var3 < var2.size(); ++var3) {
                  new AmortissementTab();
                  AmortissementTab var4 = (AmortissementTab)var2.get(var3);
                  if (var4.getAmotabDateDeb() != null && var4.getAmotabDateFin() != null) {
                     if ((this.amortissements.getAmoDateSortie().after(var4.getAmotabDateDeb()) || var4.getAmotabDateDeb().equals(this.amortissements.getAmoDateSortie())) && (this.amortissements.getAmoDateSortie().before(var4.getAmotabDateFin()) || var4.getAmotabDateFin().equals(this.amortissements.getAmoDateSortie()))) {
                        if (!var4.getAmotabDateFin().equals(this.amortissements.getAmoDateSortie())) {
                           long var5 = (this.amortissements.getAmoDateSortie().getTime() - var4.getAmotabDateDeb().getTime()) / 86400000L;
                           double var7 = var4.getAmotabMontant() / 30.0D * (double)var5;
                           var4.setAmotabMontant(var7);
                        }

                        var4.setAmotabDateSortie(this.amortissements.getAmoDateSortie());
                        var4.setAmotabValeurCession(this.amortissements.getAmoValeurCession());
                        this.amortissementTabDao.modif(var4, var1);
                     } else if (var4.getAmotabDateFin().after(this.amortissements.getAmoDateSortie())) {
                        var4.setAmotabMontant(0.0D);
                        this.amortissementTabDao.modif(var4, var1);
                     }

                     var1.flush();
                  }
               }
            }
         } else {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
            var2 = null;

            try {
               Transaction var15 = var1.beginTransaction();
               var1.setFlushMode(FlushMode.MANUAL);
               new ArrayList();
               List var16 = this.amortissementTabDao.chargeTableau(this.amortissements, var1);
               if (var16.size() != 0) {
                  for(int var17 = 0; var17 < var16.size(); ++var17) {
                     new AmortissementTab();
                     AmortissementTab var18 = (AmortissementTab)var16.get(var17);
                     if (var18.getAmotabDateDeb() != null && var18.getAmotabDateFin() != null) {
                        if ((this.amortissements.getAmoDateSortie().after(var18.getAmotabDateDeb()) || var18.getAmotabDateDeb().equals(this.amortissements.getAmoDateSortie())) && (this.amortissements.getAmoDateSortie().before(var18.getAmotabDateFin()) || var18.getAmotabDateFin().equals(this.amortissements.getAmoDateSortie()))) {
                           if (!var18.getAmotabDateFin().equals(this.amortissements.getAmoDateSortie())) {
                              long var6 = (this.amortissements.getAmoDateSortie().getTime() - var18.getAmotabDateDeb().getTime()) / 86400000L;
                              double var8 = var18.getAmotabMontant() / 30.0D * (double)var6;
                              var18.setAmotabMontant(var8);
                           }

                           var18.setAmotabDateSortie(this.amortissements.getAmoDateSortie());
                           var18.setAmotabValeurCession(this.amortissements.getAmoValeurCession());
                           this.amortissementTabDao.modif(var18, var1);
                        } else if (var18.getAmotabDateFin().after(this.amortissements.getAmoDateSortie())) {
                           var18.setAmotabMontant(0.0D);
                           this.amortissementTabDao.modif(var18, var1);
                        }

                        var1.flush();
                     }
                  }
               }

               var15.commit();
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

   }

   public void majCalculForce() throws HibernateException, NamingException {
      this.majCalculForce((Session)null);
   }

   public void majCalculForce(Session var1) throws HibernateException, NamingException {
      AmortissementTab var2;
      if (var1 != null) {
         if (this.lesTableaux.size() != 0) {
            new AmortissementTab();

            for(int var3 = 0; var3 < this.lesTableaux.size(); ++var3) {
               var2 = (AmortissementTab)this.lesTableaux.get(var3);
               if (var2.getAmotabDateTrf() == null) {
                  var2.setAmotabMontantForce(1);
                  this.amortissementTabDao.modif(var2, var1);
               }
            }
         }
      } else {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
         var2 = null;

         try {
            Transaction var10 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            if (this.lesTableaux.size() != 0) {
               new AmortissementTab();

               for(int var4 = 0; var4 < this.lesTableaux.size(); ++var4) {
                  AmortissementTab var11 = (AmortissementTab)this.lesTableaux.get(var4);
                  if (var11.getAmotabDateTrf() == null) {
                     var11.setAmotabMontantForce(1);
                     this.amortissementTabDao.modif(var11, var1);
                     var1.flush();
                  }
               }
            }

            var10.commit();
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public String splitForCpte(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty() && var1.contains(":")) {
         String[] var3 = var1.split(":");
         var2 = var3[0];
      }

      return var2;
   }

   public String splitForLib(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty() && var1.contains(":")) {
         String[] var3 = var1.split(":");
         var2 = var3[1];
      }

      return var2;
   }

   public String chercherLib(String var1, List var2) throws HibernateException, NamingException {
      String var3 = "";
      if (var1 != null && !var1.isEmpty() && var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            if (((SelectItem)var2.get(var4)).getValue().toString() != null && !((SelectItem)var2.get(var4)).getValue().toString().isEmpty() && ((SelectItem)var2.get(var4)).getValue().toString().equals(var1)) {
               var3 = ((SelectItem)var2.get(var4)).getLabel().toString();
               break;
            }
         }
      }

      return var3;
   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.amortissements.getAmoActivite() != null && !this.amortissements.getAmoActivite().isEmpty() && this.amortissements.getAmoActivite().contains(":")) {
         String[] var1 = null;
         if (!this.amortissements.getAmoActivite().contains("#")) {
            var1 = this.amortissements.getAmoActivite().split(":");
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
            String[] var2 = this.amortissements.getAmoActivite().split("#");

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

   public void razListe() {
      this.lesamortissements.clear();
      this.datamodelAmortissement.setWrappedData(this.lesamortissements);
      this.amortissements = new Amortissements();
   }

   public void toutSelectionner() {
      if (this.lesamortissements.size() != 0) {
         for(int var1 = 0; var1 < this.lesamortissements.size(); ++var1) {
            this.amortissements = (Amortissements)this.lesamortissements.get(var1);
            this.amortissements.setSelect(true);
         }

         this.datamodelAmortissement.setWrappedData(this.lesamortissements);
      }

   }

   public void rienSelectionner() {
      if (this.lesamortissements.size() != 0) {
         for(int var1 = 0; var1 < this.lesamortissements.size(); ++var1) {
            this.amortissements = (Amortissements)this.lesamortissements.get(var1);
            this.amortissements.setSelect(false);
         }

         this.datamodelAmortissement.setWrappedData(this.lesamortissements);
      }

   }

   public void inverserSelection() {
      if (this.lesamortissements.size() != 0) {
         for(int var1 = 0; var1 < this.lesamortissements.size(); ++var1) {
            this.amortissements = (Amortissements)this.lesamortissements.get(var1);
            if (!this.amortissements.isSelect()) {
               this.amortissements.setSelect(true);
            } else {
               this.amortissements.setSelect(false);
            }
         }

         this.datamodelAmortissement.setWrappedData(this.lesamortissements);
      }

   }

   public void calculeModele() throws HibernateException, NamingException {
      if (this.amortissements.getAmoModele() != null && !this.amortissements.getAmoModele().isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
         this.chargerPlanComptables(var1);
         this.utilInitHibernate.closeSession();
      }

   }

   public void controleSave() throws ParseException {
      int var1 = 0;
      if (this.amortissements.getAmoDateAchat() != null) {
         var1 = this.amortissements.getAmoDateAchat().getYear() + 1900;
      }

      if (this.amortissements.getAmoLibelle() != null && !this.amortissements.getAmoLibelle().isEmpty() && var1 != 0 && this.amortissements.getAmoValeurAchat() != 0.0D) {
         this.bttvalider = true;
      } else {
         this.bttvalider = false;
      }

      if (this.amortissements.getAmoTauxComptable() == 0.0F) {
         this.amortissements.setAmoDotation(0.0D);
      }

      double var2;
      if (this.amortissements.getAmoTvaTaux() != 0.0F) {
         var2 = this.amortissements.getAmoValeurAchat() * (double)this.amortissements.getAmoTvaTaux() / 100.0D;
         this.amortissements.setAmoTvaTotal(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.amortissements.setAmoTvaTotal(0.0D);
      }

      if (this.amortissements.getAmoTvaTaux() != 0.0F) {
         var2 = this.amortissements.getAmoValeurAchat() * (double)this.amortissements.getAmoTvaTaux() / 100.0D;
      } else {
         this.amortissements.setAmoTvaResiduelle(0.0D);
      }

   }

   public void calculMontTva() {
      double var1 = this.getAmortissements().getAmoValeurAchat();
      float var3 = this.getAmortissements().getAmoTvaTaux();
      if (var3 >= 0.0F && var3 <= 100.0F) {
         double var4 = var1 * (double)(var3 / 100.0F);
         this.getAmortissements().setAmoTvaTotal(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      } else {
         this.getAmortissements().setAmoTvaTotal(0.0D);
      }

   }

   public void calculNbreAnCmptble() throws ParseException {
      float var1 = this.amortissements.getAmoTauxComptable();
      if (var1 > 0.0F && var1 <= 100.0F) {
         this.nbreAnCmp = 100.0F / var1;
         this.amortissements.setAmoNbAnneeCpte(this.nbreAnCmp);
      } else if (var1 == 0.0F) {
         this.amortissements.setAmoNbAnneeCpte(0.0F);
      }

   }

   public void calculNbreAnFix() {
      float var1 = this.getAmortissements().getAmoTauxFiscal();
      if (var1 > 0.0F && var1 <= 100.0F) {
         this.nbreAnFix = (float)((int)(100.0F / var1));
         this.amortissements.setAmoNbAnneeFiscal(this.nbreAnFix);
      } else if (var1 == 0.0F) {
         this.amortissements.setAmoNbAnneeFiscal(0.0F);
      }

   }

   public void calculValeurCession() throws HibernateException, NamingException, ParseException {
      this.dateFin = this.selectedExo.getExecptDateDebut();
      if (this.amortissements.getAmoTypeSortie() == 0) {
         this.amortissements.setAmoValeurCession(0.0D);
         this.amortissements.setAmoDateSortie((Date)null);
      } else if (this.amortissements.getAmoTypeSortie() == 1) {
         if (this.amortissements.getAmoDateSortie() != null) {
            this.calculDotation(0, this.amortissements, this.selectedExo.getExecptDateDebut(), this.amortissements.getAmoDateSortie(), (Session)null);
            this.amortissements.setAmoValeurCession(this.amortissements.getAmoValeurAchat() - this.totAnt - this.totDot);
         } else {
            this.amortissements.setAmoValeurCession(0.0D);
         }
      } else if (this.amortissements.getAmoTypeSortie() == 2) {
         this.amortissements.setAmoValeurCession(0.0D);
      } else if (this.amortissements.getAmoTypeSortie() != 3 && this.amortissements.getAmoTypeSortie() == 4) {
      }

   }

   public void selectionDotation() {
      if (this.datamodelTableau.isRowAvailable()) {
         this.amortissementTab = (AmortissementTab)this.datamodelTableau.getRowData();
         this.ligneDotation = this.datamodelTableau.getRowIndex();
      }

   }

   public void recalculDotationligne() {
      if (this.amortissementTab != null) {
         double var1 = this.amortissementTab.getAmotabMontant();
         double var3 = 0.0D;
         double var5 = this.amortissements.getAmoValeurAchat();

         int var7;
         for(var7 = 0; var7 < this.lesTableaux.size(); ++var7) {
            this.amortissementTab = (AmortissementTab)this.lesTableaux.get(var7);
            if (this.ligneDotation == var7) {
               this.amortissementTab.setAmotabMontant(var1);
               this.calculForce = true;
            }

            var5 -= this.amortissementTab.getAmotabMontant();
            if (this.amortissementTab.getAmotabMontant() == 0.0D) {
               this.amortissementTab.setAmotabVnc(0.0D);
            } else {
               this.amortissementTab.setAmotabVnc(var5);
            }

            if (var7 == this.lesTableaux.size() - 1) {
               this.amortissementTab.setAmotabVnc(0.0D);
               this.amortissementTab.setAmotabMontant(0.0D);
            }

            var3 += this.amortissementTab.getAmotabMontant();
         }

         var3 = 0.0D;

         for(var7 = 0; var7 < this.lesTableaux.size(); ++var7) {
            this.amortissementTab = (AmortissementTab)this.lesTableaux.get(var7);
            if (var7 == this.lesTableaux.size() - 1) {
               this.amortissementTab.setAmotabMontant(this.amortissements.getAmoValeurAchat() - var3);
            }

            var3 += this.amortissementTab.getAmotabMontant();
         }

         this.datamodelTableau.setWrappedData(this.lesTableaux);
         this.tot_dot_theo = var3;
      }

   }

   public void affichePhotoProduit() throws IOException, SQLException {
      if (this.amortissements.getAmoPhoto() != null) {
         this.urlphotoProd = this.baseLog + "/photos/amortissement/photo/" + this.amortissements.getAmoPhoto();
      } else {
         this.urlphotoProd = "";
      }

      if (this.amortissements.getAmoScan() != null) {
         if (!this.amortissements.getAmoScan().endsWith(".pdf") && !this.amortissements.getAmoScan().endsWith(".PDF")) {
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + "/photos/amortissement/photo/" + this.amortissements.getAmoScan();
            this.typeFichier = 0;
         } else {
            String var1 = "epegase" + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "amortissement" + File.separator + "pdf" + File.separator;
            this.fichierUrl = this.utilDownload.convertirFichierUtl(var1 + this.amortissements.getAmoScan(), this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(this.amortissements.getAmoScan());
            this.typeFichier = 1;
         }

         this.var_affFicPdf = true;
      } else {
         this.var_affFicPdf = false;
      }

   }

   public void verifierPdf() {
      this.existPdfFile = this.isExistPdfFile();
   }

   public boolean isExistPdfFile() {
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "amortissement" + File.separator + "pdf") + File.separator + this.amortissements.getAmoNum() + ".pdf";
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
      String var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "amortissement" + File.separator + "pdf") + File.separator + this.amortissements.getAmoNum() + ".pdf";
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

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException, SQLException {
      FacesContext var1 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "amortissement" + File.separator + "photo") + File.separator + this.amortissements.getAmoNum();
            File var3 = new File(var2);
            if (var3.exists()) {
               var3.delete();
            }

            String var4 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = this.amortissements.getAmoNum() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "amortissement" + File.separator + "photo" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
            this.fileName = var4;
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.amortissements.setAmoPhoto(var4);
            this.amortissementDao.modif(this.amortissements);
            this.affichePhotoProduit();
         }
      } catch (IOException var7) {
         this.amortissements.setAmoPhoto(this.fileName);
         var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var7.printStackTrace();
      }

   }

   public void submitPDF() throws IOException, JDOMException, HibernateException, NamingException, SQLException {
      if (this.uploadedPDFFile != null) {
         String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "amortissement" + File.separator + "pdf") + File.separator + this.amortissements.getAmoNum() + ".pdf";
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         FacesContext var3 = FacesContext.getCurrentInstance();

         try {
            String var4 = this.utilDownload.trimFilePath(this.uploadedPDFFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = this.amortissements.getAmoNum() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "amortissement" + File.separator + "pdf" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var4;
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.amortissements.setAmoScan(var4);
            this.amortissementDao.modif(this.amortissements);
            this.affichePhotoProduit();
         } catch (IOException var7) {
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var7.printStackTrace();
         }
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException, IOException, SQLException {
      String var1 = "";
      int var2 = this.amortissements.getAmoPhoto().lastIndexOf(46);
      if (0 < var2 && var2 <= this.amortissements.getAmoPhoto().length() - 2) {
         var1 = "." + this.amortissements.getAmoPhoto().substring(var2 + 1);
      }

      String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "amortissement" + File.separator + "photo") + File.separator + this.amortissements.getAmoNum() + var1;
      File var4 = new File(var3);
      if (var4.exists()) {
         var4.delete();
      }

      this.amortissements.setAmoPhoto((String)null);
      this.amortissementDao.modif(this.amortissements);
      this.affichePhotoProduit();
   }

   public void reInitPDF() throws HibernateException, NamingException, IOException, SQLException {
      this.amortissements.setAmoScan((String)null);
      this.amortissementDao.modif(this.amortissements);
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "amortissement" + File.separator + "pdf") + File.separator + this.amortissements.getAmoNum() + ".pdf";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      this.affichePhotoProduit();
   }

   public void afficherScan() throws HibernateException, NamingException, IOException, SQLException {
      if (this.datamodelAmortissement.isRowAvailable()) {
         this.amortissements = (Amortissements)this.datamodelAmortissement.getRowData();
         this.affichePhotoProduit();
      }

      if (this.amortissements != null && this.amortissements.getAmoScan() != null && !this.amortissements.getAmoScan().isEmpty()) {
         this.showModalPanelScan = true;
      }

   }

   public void fermerScan() {
      this.showModalPanelScan = false;
   }

   public void ajouterReglement() {
      this.amortissementReg = new AmortissementReg();
      this.amortissementReg.setAmoregId(0L);
      this.amortissementReg.setAmoregDateReg(new Date());
      this.shoModalPanelReglement = true;
   }

   public void modifierReglement() {
      this.shoModalPanelReglement = true;
   }

   public void selectionReglement() {
      if (this.dataModelReglement.isRowAvailable()) {
         this.amortissementReg = (AmortissementReg)this.dataModelReglement.getRowData();
         this.visibiliteAmortReg = true;
      }

   }

   public void annuleReg() {
      this.shoModalPanelReglement = false;
   }

   public void saveAmoReg() throws HibernateException, NamingException {
      if (this.amortissementReg.getAmoregId() == 0L) {
         this.amortissementReg.setAmortissements(this.amortissements);
         this.amortissementReg.setAmoregDateCreat(new Date());
         this.amortissementReg.setAmoregUserCreat(this.usersLog.getUsrid());
         this.amortissementReg = this.amortissementRegDao.insert(this.amortissementReg);
      } else {
         this.amortissementReg.setAmoregDateModif(new Date());
         this.amortissementReg.setAmoregUserModif(this.usersLog.getUsrid());
         this.amortissementReg = this.amortissementRegDao.modif(this.amortissementReg);
      }

      this.chargerReglements((Session)null);
      this.amortissements.setAmoSolde(this.soldeAmort);
      this.amortissements = this.amortissementDao.modif(this.amortissements);
      this.shoModalPanelReglement = false;
   }

   public void supprimerReglement() throws HibernateException, NamingException {
      this.amortissementRegDao.delete(this.amortissementReg);
      this.chargerReglements((Session)null);
   }

   public void selectionInventaire() {
      if (this.dataModelInventaire.isRowAvailable()) {
         this.amortissementInv = (AmortissementInv)this.dataModelInventaire.getRowData();
      }

   }

   public void caluleMapBien() throws URISyntaxException {
      if (this.amortissementInv != null) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.coordonnees = var1.calculPointMapBoxImmo(this.amortissementInv);
         this.origine = this.amortissementInv.getAmoinvLongitude() + "," + this.amortissementInv.getAmoinvLatitude();
      }

      this.shoModalPanelMapbox = true;
   }

   public void annuleMapbox() {
      this.shoModalPanelMapbox = false;
   }

   public void openModalPanel() throws IOException, SAXException, HibernateException, NamingException {
      this.dateDebut = this.lastExo.getExecptDateDebut();
      this.dateFin = this.lastExo.getExecptDateFin();
      this.showModalPanelTransfert = true;
   }

   public void closeModalPanel() {
      this.showModalPanelTransfert = false;
   }

   public void transfertElement() throws IOException, SAXException, HibernateException, NamingException {
      new ArrayList();
      JournauxComptablesDao var2 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      List var1 = var2.verifJCExit(this.lastExo.getExecpt_id(), 5);
      this.journauxComptables = new JournauxComptables();
      if (var1.size() == 0) {
         this.journauxComptables.setExercice(this.lastExo);
         this.journauxComptables.setPljLibelleFr("Amortissement");
         this.journauxComptables.setPljLibelleUk("Amortissement");
         this.journauxComptables.setPljLibelleSp("Amortissement");
         this.journauxComptables.setPljCode("AM");
         this.journauxComptables.setPljNature(5);
         var2.save(this.journauxComptables);
      } else {
         this.journauxComptables = (JournauxComptables)var1.get(0);
      }

      this.lesElementsTrf = new ArrayList();
      String var3 = this.utilDate.dateToStringSQL(this.dateDebut);
      String var4 = this.utilDate.dateToStringSQL(this.dateFin);
      this.lesElementsTrf = this.amortissementTabDao.chargerAmotDot(var3, var4, (Session)null);
      this.genererLesTransfertCompta();
   }

   public void genererLesTransfertCompta() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      this.lesTransfertCompta = new ArrayList();
      if (this.lesElementsTrf.size() > 0) {
         new AmortissementTab();

         for(int var6 = 0; var6 < this.lesElementsTrf.size(); ++var6) {
            new TransfertCompta();
            new TransfertCompta();
            AmortissementTab var5 = (AmortissementTab)this.lesElementsTrf.get(var6);
            if (var5.getAmotabDateDeb() != null) {
               var5 = (AmortissementTab)this.lesElementsTrf.get(var6);
               if (var5.getAmortissements().getAmoCompteImmo() != null && !var5.getAmortissements().getAmoCompteImmo().isEmpty()) {
                  var1 = 0.0D;
                  var3 = var5.getAmotabMontant();
                  TransfertCompta var7 = this.genererLigne(var5.getAmortissements().getAmoId(), var5.getAmotabDateFin(), var5.getAmortissements().getAmoCompteAmo(), "" + var5.getAmortissements().getAmoNum(), var5.getAmortissements().getAmoReference(), var5.getAmortissements().getAmoLibelle(), var1, var3, var5.getAmortissements().getAmoSite(), var5.getAmortissements().getAmoDepartement(), var5.getAmortissements().getAmoService(), var5.getAmortissements().getAmoRegion(), var5.getAmortissements().getAmoSecteur(), var5.getAmortissements().getAmoPdv(), var5.getAmortissements().getAmoDossier(), var5.getAmortissements().getAmoMission(), var5.getAmortissements().getAmoParc(), var5.getAmortissements().getAmoCle1(), var5.getAmortissements().getAmoBudget(), var5.getAmortissements().getAmoActivite(), var5.getAmortissements().getAmoProjet(), var5.getAmortissements().getAmoAgent());
                  this.lesTransfertCompta.add(var7);
               }

               if (var5.getAmortissements().getAmoCompteDotation() != null && !var5.getAmortissements().getAmoCompteDotation().isEmpty()) {
                  var1 = var5.getAmotabMontant();
                  var3 = 0.0D;
                  TransfertCompta var8 = this.genererLigne(var5.getAmortissements().getAmoId(), var5.getAmotabDateFin(), var5.getAmortissements().getAmoCompteDotation(), "" + var5.getAmortissements().getAmoNum(), var5.getAmortissements().getAmoReference(), var5.getAmortissements().getAmoLibelle(), var1, var3, var5.getAmortissements().getAmoSite(), var5.getAmortissements().getAmoDepartement(), var5.getAmortissements().getAmoService(), var5.getAmortissements().getAmoRegion(), var5.getAmortissements().getAmoSecteur(), var5.getAmortissements().getAmoPdv(), var5.getAmortissements().getAmoDossier(), var5.getAmortissements().getAmoMission(), var5.getAmortissements().getAmoParc(), var5.getAmortissements().getAmoCle1(), var5.getAmortissements().getAmoBudget(), var5.getAmortissements().getAmoActivite(), var5.getAmortissements().getAmoProjet(), var5.getAmortissements().getAmoAgent());
                  this.lesTransfertCompta.add(var8);
               }
            }
         }
      }

   }

   public TransfertCompta genererLigne(long var1, Date var3, String var4, String var5, String var6, String var7, double var8, double var10, String var12, String var13, String var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25) {
      TransfertCompta var26 = new TransfertCompta();
      var26.setTrfCode(this.journauxComptables.getPljCode());
      var26.setTrfIdOrigine(var1);
      var26.setTrfTypeOrigine("AM");
      var26.setTrfDateSaisie(var3);
      var26.setTrfCompte(var4);
      var26.setTrfLibelle(var7);
      var26.setTrfReference1(var5);
      var26.setTrfReference2(var6);
      var26.setTrfPiece("XXXXXX");
      var26.setTrfDebitSaisie(var8);
      var26.setTrfCreditSaisie(var10);
      var26.setTrfDateEcheance((Date)null);
      var26.setTrfDateValeurTheo((Date)null);
      var26.setTrfSite(var12);
      var26.setTrfDepartement(var13);
      var26.setTrfService(var14);
      var26.setTrfRegion(var15);
      var26.setTrfSecteur(var16);
      var26.setTrfPdv(var17);
      var26.setTrfDossier(var18);
      var26.setTrfParc(var20);
      var26.setTrfCle1(var21);
      var26.setTrfTreso("");
      var26.setTrfActivite(var23);
      var26.setTrfAgent(var25);
      var26.setTrfBudget(var22);
      var26.setTrfProjet(var24);
      return var26;
   }

   public void traitementApresTransfert() throws HibernateException, NamingException {
      if (this.lesElementsTrf.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            new AmortissementTab();

            for(int var4 = 0; var4 < this.lesElementsTrf.size(); ++var4) {
               AmortissementTab var3 = (AmortissementTab)this.lesElementsTrf.get(var4);
               var3.setAmotabValeur(var3.getAmotabMontant());
               var3.setAmotabDateTrf(new Date());
               this.amortissementTabDao.modif(var3, var1);
               var1.flush();
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

   public long numCompose(Session var1) throws HibernateException, NamingException {
      long var2 = 0L;
      if (this.verrouNum) {
         this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
         this.enregitrerNumero(var1);
         var2 = (long)((int)this.chrono.getChrNum());
      } else {
         var2 = this.amortissements.getAmoNum();
      }

      return var2;
   }

   public void enregitrerNumero(Session var1) throws HibernateException, NamingException {
      this.chrono.setChrNum(this.chrono.getChrNum() + 1L);
      if (var1 != null) {
         this.chronoDao.modifierChrono(this.chrono, var1);
      } else {
         this.chronoDao.modifierChrono(this.chrono);
      }

   }

   public void printQrCode() {
      if (this.amortissements != null) {
         this.showModalPanelPrintQrCode = true;
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
      if (this.amortissements != null) {
         UtilPrint var1 = new UtilPrint(this.utilInitHibernate);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.setRapport("ImmobilisationQrCode");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(this.format);
         var1.setFiltre((String)null);
         var1.setEmetteur((String)null);
         var1.setDestinataire((String)null);
         var1.setDestinataire((String)null);
         var1.setDestinataire((String)null);
         var1.setTiersSelectionne((Tiers)null);
         ArrayList var2 = new ArrayList();
         this.amortissements.setQrCode(this.calculQrCode(var1));
         var2.add(this.amortissements);
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var2);
         var1.setjRBeanCollectionDataSource(var3);
         var1.imprimeRapport();
      }

      this.showModalPanelPrintQrCode = false;
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "amortissement";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.impressionStandardsItems = new ArrayList();
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
                  this.impressionStandardsItems.add(new SelectItem(var5));
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
         if (var1 == null) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "amortissement" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setRapport(var4);
         var1.setFormat(var5);
         String var11 = this.utilDate.dateToStringFr(this.dateDebut);
         (new StringBuilder()).append(var11.substring(6, 10)).append("-").append(var11.substring(3, 5)).append("-").append(var11.substring(0, 2)).toString();
         String var13 = this.utilDate.dateToStringFr(this.dateFin);
         (new StringBuilder()).append(var13.substring(6, 10)).append("-").append(var13.substring(3, 5)).append("-").append(var13.substring(0, 2)).toString();
         String var15 = this.utilDate.dateToStringFr(this.dateDebut);
         String var16 = this.utilDate.dateToStringFr(this.dateFin);
         String var17 = "Calcul du " + var15 + " au " + var16;
         var1.setFiltre(var17);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataire(var8);
         var1.setDestinataire(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         var1.setDateDeb(this.dateDebut);
         if (this.lesamortissements.size() != 0) {
            if (var4.equals("AmortissementsAvecInventaire")) {
               this.impressionAvecInventaire(var4, var1);
            } else if (var4.equals("AmortissementsSansInventaire")) {
               this.impressionSansInventaire(var4, var1);
            } else {
               this.impressionAmortissement(var4, var1);
            }
         }
      }

   }

   public void impressionAvecInventaire(String var1, UtilPrint var2) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      String var3 = "";

      for(int var4 = 0; var4 < this.lesamortissements.size(); ++var4) {
         if (var3 != null && !var3.isEmpty()) {
            var3 = var3 + "," + ((Amortissements)this.lesamortissements.get(var4)).getAmoId();
         } else {
            var3 = "" + ((Amortissements)this.lesamortissements.get(var4)).getAmoId();
         }
      }

      new ArrayList();
      String var5 = this.utilDate.dateToStringSQLLight(this.dateFin) + " 00:00:00";
      String var6 = this.utilDate.dateToStringSQLLight(this.dateFin) + " 23:59:59";
      List var8 = this.amortissementInvDao.chargerInventaire(var3, var5, var6, (Session)null);
      JRBeanCollectionDataSource var7 = new JRBeanCollectionDataSource(var8);
      var2.setjRBeanCollectionDataSource(var7);
      var2.imprimeRapport();
   }

   public void impressionSansInventaire(String var1, UtilPrint var2) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      String var3 = "";

      for(int var4 = 0; var4 < this.lesamortissements.size(); ++var4) {
         if (var3 != null && !var3.isEmpty()) {
            var3 = var3 + "," + ((Amortissements)this.lesamortissements.get(var4)).getAmoId();
         } else {
            var3 = "" + ((Amortissements)this.lesamortissements.get(var4)).getAmoId();
         }
      }

      new ArrayList();
      String var5 = this.utilDate.dateToStringSQLLight(this.dateFin) + " 00:00:00";
      String var6 = this.utilDate.dateToStringSQLLight(this.dateFin) + " 23:59:59";
      List var11 = this.amortissementInvDao.chargerInventaire(var3, var5, var6, (Session)null);
      ArrayList var7 = new ArrayList();

      for(int var8 = 0; var8 < this.lesamortissements.size(); ++var8) {
         this.amortissements = (Amortissements)this.lesamortissements.get(var8);
         boolean var9 = false;

         for(int var10 = 0; var10 < var11.size(); ++var10) {
            if (this.amortissements.getAmoId() == ((AmortissementInv)var11.get(var10)).getAmortissements().getAmoId()) {
               var9 = true;
               break;
            }
         }

         if (!var9) {
            var7.add(this.amortissements);
         }
      }

      JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var7);
      var2.setjRBeanCollectionDataSource(var12);
      var2.imprimeRapport();
   }

   public void impressionAmortissement(String var1, UtilPrint var2) throws HibernateException, NamingException, ParseException, JSONException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      ArrayList var3 = new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Amortissements");
      RacinesDao var5 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
      new ArrayList();
      List var6 = var5.chargerMesRacines(var4);
      boolean var7 = false;

      int var8;
      for(var8 = 0; var8 < this.lesamortissements.size(); ++var8) {
         if (((Amortissements)this.lesamortissements.get(var8)).isSelect()) {
            var7 = true;
            break;
         }
      }

      if (var7) {
         for(var8 = 0; var8 < this.lesamortissements.size(); ++var8) {
            if (((Amortissements)this.lesamortissements.get(var8)).isSelect()) {
               this.amortissements = (Amortissements)this.lesamortissements.get(var8);
               if (this.amortissements.getAmoDateAchat() != null && this.amortissements.getAmoDateAchat().compareTo(this.dateFin) <= 0) {
                  if (var1 != null && !var1.isEmpty() && var1.contains("Annuel")) {
                     this.calculAmortissement(1, var4);
                  } else {
                     this.calculAmortissement(0, var4);
                  }

                  this.calculLibelleRacine(var6);
                  this.amortissements.setQrCode(this.calculQrCode(var2));
                  this.amortissements.setPhotoPrint(this.calculPhoto());
                  var3.add(this.amortissements);
               }
            }
         }
      } else {
         for(var8 = 0; var8 < this.lesamortissements.size(); ++var8) {
            this.amortissements = (Amortissements)this.lesamortissements.get(var8);
            if (this.amortissements.getAmoDateAchat() != null && this.amortissements.getAmoDateAchat().compareTo(this.dateFin) <= 0) {
               if (var1 != null && !var1.isEmpty() && var1.contains("Annuel")) {
                  this.calculAmortissement(1, var4);
               } else {
                  this.calculAmortissement(0, var4);
               }

               this.calculLibelleRacine(var6);
               this.amortissements.setQrCode(this.calculQrCode(var2));
               this.amortissements.setPhotoPrint(this.calculPhoto());
               var3.add(this.amortissements);
            }
         }
      }

      this.utilInitHibernate.closeSession();
      JRBeanCollectionDataSource var9 = new JRBeanCollectionDataSource(var3);
      var2.setjRBeanCollectionDataSource(var9);
      var2.imprimeRapport();
   }

   public void calculLibelleRacine(List var1) throws HibernateException, NamingException {
      new Racines();
      if (this.amortissements.getAmoCompteImmo() != null && !this.amortissements.getAmoCompteImmo().isEmpty()) {
         int var3 = this.amortissements.getAmoCompteImmo().length();
         String var4 = "";
         int var5 = 0;
         Racines var2 = null;

         for(int var6 = var3; var6 != 1; --var6) {
            ++var5;
            var4 = this.amortissements.getAmoCompteImmo().substring(0, var3 - var5);
            String var7 = this.structureLog.getStrzonefiscale();
            if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.structureLog.getStrdatefiscale2() != null && this.amortissements.getAmoDateAchat().compareTo(this.structureLog.getStrdatefiscale2()) >= 0) {
               var7 = this.structureLog.getStrzonefiscale2();
            }

            boolean var8 = false;

            for(int var9 = 0; var9 < var1.size(); ++var9) {
               var2 = (Racines)var1.get(var9);
               if (var2.getRacCode().equals(var4) && var2.getRacFiscalite().equals(var7)) {
                  var8 = true;
                  break;
               }
            }

            if (var8) {
               break;
            }
         }

         if (var2 == null) {
            this.amortissements.setCodeRacine("???");
            this.amortissements.setLibelleRacine("Racine inconnue");
         } else {
            this.amortissements.setCodeRacine(var2.getRacCode());
            this.amortissements.setLibelleRacine(var2.getRacLibelleFr());
         }
      } else {
         this.amortissements.setCodeRacine("???");
         this.amortissements.setLibelleRacine("Sans compte d`immobilisation");
      }

   }

   public String calculQrCode(UtilPrint var1) throws JSONException {
      String var2 = var1.calculeSecurityCode("ImmobilisationQrCode", this.amortissements.getAmoNum());
      return var2;
   }

   public String calculPhoto() {
      String var1 = null;
      if (this.amortissements.getAmoPhoto() != null && !this.amortissements.getAmoPhoto().isEmpty()) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "amortissement" + File.separator + "photo" + File.separator + this.amortissements.getAmoPhoto();
      }

      return var1;
   }

   public void calculAmortissement(int var1, Session var2) throws HibernateException, NamingException, ParseException {
      if (this.amortissements.getAmoDateAchat() != null) {
         boolean var3 = this.calculDotation(var1, this.amortissements, this.dateDebut, this.dateFin, var2);
         this.amortissements.setAmoAnterieur(this.totAnt);
         double var4 = 0.0D;
         double var6 = 0.0D;
         this.amortissements.setAmoDotation(this.totDot + var4);
         this.amortissements.setAmoTotalAmort(this.amortissements.getAmoAnterieur() + this.amortissements.getAmoDotation() + this.amortissements.getAmoCede());
         if (this.amortissements.getAmoTotalAmort() == 0.0D) {
            this.amortissements.setAmoValeurResiduelle(0.0D);
         } else {
            this.amortissements.setAmoValeurResiduelle(this.amortissements.getAmoValeurAchat() - this.amortissements.getAmoTotalAmort());
         }

         if (this.amortissements.getAmoValeurResiduelle() < 0.0D) {
            double var8 = this.amortissements.getAmoDotation() + this.amortissements.getAmoValeurResiduelle();
            if (var8 >= 0.0D) {
               this.amortissements.setAmoDotation(this.amortissements.getAmoDotation() + this.amortissements.getAmoValeurResiduelle());
               this.amortissements.setAmoDotation(0.0D);
               this.amortissements.setAmoTotalAmort(this.amortissements.getAmoAnterieur() + this.amortissements.getAmoDotation() + this.amortissements.getAmoCede());
               this.amortissements.setAmoValeurResiduelle(0.0D);
            }
         } else if (this.amortissements.getAmoValeurResiduelle() > 0.0D && (this.amortissements.getAmoDateSortie() != null && this.amortissements.getAmoDateSortie().getYear() + 1900 == this.dateFin.getYear() + 1900 || var3)) {
            this.amortissements.setAmoDotation(this.amortissements.getAmoDotation() + this.amortissements.getAmoValeurResiduelle());
            this.amortissements.setAmoTotalAmort(this.amortissements.getAmoAnterieur() + this.amortissements.getAmoDotation() + this.amortissements.getAmoCede());
            this.amortissements.setAmoValeurResiduelle(0.0D);
         }

         if (this.amortissements.getAmoValeurResiduelle() == 0.0D && this.amortissements.getAmoAnterieur() == 0.0D) {
            if (this.amortissements.getAmoTauxComptable() == 0.0F) {
               this.amortissements.setAmoAnterieur(0.0D);
            } else if (this.amortissements.getAmoDateService() != null) {
               if (this.amortissements.getAmoDateService().compareTo(this.dateFin) <= 0) {
                  this.amortissements.setAmoAnterieur(this.amortissements.getAmoValeurAchat());
               }
            } else if (this.amortissements.getAmoDateAchat() != null && this.amortissements.getAmoDateService().compareTo(this.dateFin) <= 0) {
               this.amortissements.setAmoAnterieur(this.amortissements.getAmoValeurAchat());
            }
         }
      }

   }

   public boolean calculDotation(int var1, Amortissements var2, Date var3, Date var4, Session var5) throws HibernateException, NamingException, ParseException {
      this.totAnt = 0.0D;
      this.totDot = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
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
      boolean var30 = false;
      new ArrayList();
      if (var2 != null) {
         List var31 = this.amortissementTabDao.chargeTableau(var2, var5);
         if (var31.size() != 0) {
            new AmortissementTab();

            AmortissementTab var32;
            for(int var33 = 0; var33 < var31.size(); ++var33) {
               var32 = (AmortissementTab)var31.get(var33);
               if (var32.getAmotabDateDeb() != null && var32.getAmotabDateFin() != null) {
                  if (var1 == 1) {
                     long var37 = (long)(this.dateDebut.getYear() + 1900);
                     if (var32.getAmotabDateDeb().compareTo(var3) >= 0) {
                        this.totDot += var32.getAmotabMontant();
                        Date var36 = var32.getAmotabDateDeb();
                        if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37) {
                           var6 += var32.getAmotabMontant();
                        } else if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37 + 1L) {
                           var8 += var32.getAmotabMontant();
                        } else if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37 + 2L) {
                           var10 += var32.getAmotabMontant();
                        } else if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37 + 3L) {
                           var12 += var32.getAmotabMontant();
                        } else if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37 + 4L) {
                           var14 += var32.getAmotabMontant();
                        } else if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37 + 5L) {
                           var16 += var32.getAmotabMontant();
                        } else if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37 + 6L) {
                           var18 += var32.getAmotabMontant();
                        } else if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37 + 7L) {
                           var20 += var32.getAmotabMontant();
                        } else if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37 + 8L) {
                           var22 += var32.getAmotabMontant();
                        } else if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37 + 9L) {
                           var24 += var32.getAmotabMontant();
                        } else if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37 + 10L) {
                           var26 += var32.getAmotabMontant();
                        } else if ((long)(var32.getAmotabDateDeb().getYear() + 1900) == var37 + 11L) {
                           var28 += var32.getAmotabMontant();
                        }
                     } else if (var32.getAmotabDateDeb().compareTo(var3) < 0) {
                        this.totAnt += var32.getAmotabMontant();
                     }
                  } else if (var32.getAmotabDateDeb().compareTo(var3) >= 0 && var32.getAmotabDateFin().compareTo(var4) <= 0) {
                     this.totDot += var32.getAmotabMontant();
                     int var34 = var32.getAmotabDateDeb().getMonth() + 1;
                     if (var34 == 1) {
                        var6 = var32.getAmotabMontant();
                     } else if (var34 == 2) {
                        var8 = var32.getAmotabMontant();
                     } else if (var34 == 3) {
                        var10 = var32.getAmotabMontant();
                     } else if (var34 == 4) {
                        var12 = var32.getAmotabMontant();
                     } else if (var34 == 5) {
                        var14 = var32.getAmotabMontant();
                     } else if (var34 == 6) {
                        var16 = var32.getAmotabMontant();
                     } else if (var34 == 7) {
                        var18 = var32.getAmotabMontant();
                     } else if (var34 == 8) {
                        var20 = var32.getAmotabMontant();
                     } else if (var34 == 9) {
                        var22 = var32.getAmotabMontant();
                     } else if (var34 == 10) {
                        var24 = var32.getAmotabMontant();
                     } else if (var34 == 11) {
                        var26 = var32.getAmotabMontant();
                     } else if (var34 == 12) {
                        var28 = var32.getAmotabMontant();
                     }
                  } else if (var32.getAmotabDateDeb().compareTo(var3) < 0) {
                     this.totAnt += var32.getAmotabMontant();
                  }
               }
            }

            var2.setV01(var6);
            var2.setV02(var8);
            var2.setV03(var10);
            var2.setV04(var12);
            var2.setV05(var14);
            var2.setV06(var16);
            var2.setV07(var18);
            var2.setV08(var20);
            var2.setV09(var22);
            var2.setV10(var24);
            var2.setV11(var26);
            var2.setV12(var28);
            var32 = (AmortissementTab)var31.get(var31.size() - 1);
            if (var32.getAmotabDateDeb() != null && var32.getAmotabDateFin() != null) {
               if (var32.getAmotabDateDeb().getYear() + 1900 == this.dateFin.getYear() + 1900) {
                  var30 = true;
               } else {
                  var30 = false;
               }
            }
         }
      }

      if (var2.getAmoTauxComptable() == 0.0F) {
         this.totAnt = 0.0D;
      }

      return var30;
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
      if (this.lesamortissements.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "IMMOBILISATIONS : Veleur d`achat en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "IMMOBILISATIONS : Nombre de biens";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         }

         this.titreGraph = "Analyse des immobilisations : ";
         this.sousTitreGraph = "";
         if (this.modeGraph == 0) {
            this.sousTitreGraph = this.sousTitreGraph + " - En global(" + this.uniteGraph + ")";
         } else if (this.modeGraph == 1) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par compte immobilisation (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 2) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par compte amortissement (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 3) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par compte dotation (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 4) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par nature (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 5) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par etat (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 6) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par activité (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 7) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par localisation (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 12) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par site (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 13) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par departement (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 14) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par service (" + this.uniteGraph + ")";
         }

         if (this.lesamortissements.size() != 0) {
            String var2 = "";
            long var3 = 0L;
            boolean var5 = false;
            new Amortissements();
            int var7 = 0;

            while(true) {
               if (var7 >= this.lesamortissements.size()) {
                  var1 = this.calculePourcentage((List)var1);
                  break;
               }

               Amortissements var6 = (Amortissements)this.lesamortissements.get(var7);
               var2 = "";
               var3 = 0L;
               int var9 = 0;
               if (this.modeGraph == 0) {
                  int var8 = var6.getAmoDateAchat().getYear() + 1900;
                  if (var6.getAmoDateService() != null) {
                     var8 = var6.getAmoDateService().getYear() + 1900;
                  }

                  var2 = "" + var8;
               } else if (this.modeGraph == 1) {
                  if (var6.getAmoCompteImmo() != null && !var6.getAmoCompteImmo().isEmpty()) {
                     var2 = var6.getAmoCompteImmo() + ":" + var6.getAmoLibCompteImo();
                  } else {
                     var2 = "Sans Compte immobililisation";
                  }
               } else if (this.modeGraph == 2) {
                  if (var6.getAmoCompteAmo() != null && !var6.getAmoCompteAmo().isEmpty()) {
                     var2 = var6.getAmoCompteAmo() + ":" + var6.getAmoLibCompteAmo();
                  } else {
                     var2 = "Sans Compte amortissement";
                  }
               } else if (this.modeGraph == 3) {
                  if (var6.getAmoCompteDotation() != null && !var6.getAmoCompteDotation().isEmpty()) {
                     var2 = var6.getAmoCompteDotation() + ":" + var6.getAmoLibCompteDot();
                  } else {
                     var2 = "Sans Compte dotation";
                  }
               } else if (this.modeGraph == 4) {
                  if (var6.getAmoNature() == 0) {
                     var2 = "Immobilier";
                  } else if (var6.getAmoNature() == 1) {
                     var2 = "Mobilier";
                  } else if (var6.getAmoNature() == 2) {
                     var2 = "Autre";
                  } else if (var6.getAmoNature() == 3) {
                     var2 = "Caution";
                  } else if (var6.getAmoNature() == 4) {
                     var2 = "Frais de constitution";
                  }
               } else if (this.modeGraph == 5) {
                  if (var6.getAmoTypeSortie() == 0) {
                     var2 = "En cours";
                  } else if (var6.getAmoTypeSortie() == 1) {
                     var2 = "Cessions";
                  } else if (var6.getAmoTypeSortie() == 2) {
                     var2 = "Rebuts";
                  } else if (var6.getAmoTypeSortie() == 3) {
                     var2 = "Amortis";
                  } else if (var6.getAmoTypeSortie() == 4) {
                     var2 = "Desactive";
                  }
               } else if (this.modeGraph == 6) {
                  if (var6.getAmoActivite() != null && !var6.getAmoActivite().isEmpty()) {
                     var2 = var6.getAmoActivite() + ":" + var6.getAmoLibActivite();
                  } else {
                     var2 = "Sans Activité";
                  }
               } else if (this.modeGraph == 7) {
                  if (var6.getAmoLocalisation() != null && !var6.getAmoLocalisation().isEmpty()) {
                     var2 = var6.getAmoLocalisation();
                  } else {
                     var2 = "Sans Localisation";
                  }
               } else if (this.modeGraph == 12) {
                  if (var6.getAmoSite() != null && !var6.getAmoSite().isEmpty()) {
                     var2 = var6.getAmoSite() + ":" + var6.getAmoLibSite();
                  } else {
                     var2 = "Sans Site";
                  }
               } else if (this.modeGraph == 13) {
                  if (var6.getAmoDepartement() != null && !var6.getAmoDepartement().isEmpty()) {
                     var2 = var6.getAmoDepartement() + ":" + var6.getAmoLibDepartement();
                  } else {
                     var2 = "Sans Departement";
                  }
               } else if (this.modeGraph == 14) {
                  if (var6.getAmoService() != null && !var6.getAmoService().isEmpty()) {
                     var2 = var6.getAmoService() + ":" + var6.getAmoLibService();
                  } else {
                     var2 = "Sans Service";
                  }
               }

               if (this.valQteGraph == 0) {
                  var3 = (long)var6.getAmoValeurAchat();
               } else if (this.valQteGraph == 1) {
                  ++var3;
               }

               if (this.timeDecoupage == 1) {
                  var9 = var6.getAmoDateAchat().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var6.getAmoDateAchat().getMonth() + 1 >= 1 && var6.getAmoDateAchat().getMonth() + 1 <= 3) {
                     var9 = 1;
                  } else if (var6.getAmoDateAchat().getMonth() + 1 >= 4 && var6.getAmoDateAchat().getMonth() + 1 <= 6) {
                     var9 = 2;
                  } else if (var6.getAmoDateAchat().getMonth() + 1 >= 7 && var6.getAmoDateAchat().getMonth() + 1 <= 9) {
                     var9 = 3;
                  } else if (var6.getAmoDateAchat().getMonth() + 1 >= 10 && var6.getAmoDateAchat().getMonth() + 1 <= 12) {
                     var9 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var6.getAmoDateAchat().getMonth() + 1 >= 1 && var6.getAmoDateAchat().getMonth() + 1 <= 6) {
                     var9 = 1;
                  } else if (var6.getAmoDateAchat().getMonth() + 1 >= 7 && var6.getAmoDateAchat().getMonth() + 1 <= 12) {
                     var9 = 2;
                  }
               } else if (this.timeDecoupage == 4) {
                  var9 = 1;
               } else if (this.timeDecoupage == 5) {
                  var9 = var6.getAmoDateAchat().getHours();
               }

               var1 = this.calculeListe((List)var1, var2, var9, var3);
               ++var7;
            }
         }

         this.utilInitHibernate.closeSession();
      }

      this.showModele = true;
      return (List)var1;
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
            var8.setV13(var8.getV13() + var4);
         } else if (var3 == 14) {
            var8.setV14(var8.getV14() + var4);
         } else if (var3 == 15) {
            var8.setV15(var8.getV15() + var4);
         } else if (var3 == 16) {
            var8.setV16(var8.getV16() + var4);
         } else if (var3 == 17) {
            var8.setV17(var8.getV17() + var4);
         } else if (var3 == 18) {
            var8.setV18(var8.getV18() + var4);
         } else if (var3 == 19) {
            var8.setV19(var8.getV19() + var4);
         } else if (var3 == 20) {
            var8.setV20(var8.getV20() + var4);
         } else if (var3 == 21) {
            var8.setV21(var8.getV21() + var4);
         } else if (var3 == 22) {
            var8.setV22(var8.getV22() + var4);
         } else if (var3 == 23) {
            var8.setV23(var8.getV23() + var4);
         } else if (var3 == 24) {
            var8.setV24(var8.getV24() + var4);
         } else if (var3 == 25) {
            var8.setV25(var8.getV25() + var4);
         } else if (var3 == 26) {
            var8.setV26(var8.getV26() + var4);
         } else if (var3 == 27) {
            var8.setV27(var8.getV27() + var4);
         } else if (var3 == 28) {
            var8.setV28(var8.getV28() + var4);
         } else if (var3 == 29) {
            var8.setV29(var8.getV29() + var4);
         } else if (var3 == 30) {
            var8.setV30(var8.getV30() + var4);
         } else if (var3 == 31) {
            var8.setV31(var8.getV31() + var4);
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

   public double getTotalValeurAchat() {
      return this.totalValeurAchat;
   }

   public void setTotalValeurAchat(double var1) {
      this.totalValeurAchat = var1;
   }

   public List getImpressionStandardsItems() {
      return this.impressionStandardsItems;
   }

   public void setImpressionStandardsItems(List var1) {
      this.impressionStandardsItems = var1;
   }

   public ExercicesComptable getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesComptable var1) {
      this.lastExo = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVerrouNum() {
      return this.verrouNum;
   }

   public void setVerrouNum(boolean var1) {
      this.verrouNum = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public double getSoldeAmort() {
      return this.soldeAmort;
   }

   public void setSoldeAmort(double var1) {
      this.soldeAmort = var1;
   }

   public String getVar_compte() {
      return this.var_compte;
   }

   public void setVar_compte(String var1) {
      this.var_compte = var1;
   }

   public int getVar_etat() {
      return this.var_etat;
   }

   public void setVar_etat(int var1) {
      this.var_etat = var1;
   }

   public String getVar_filtretsd() {
      return this.var_filtretsd;
   }

   public void setVar_filtretsd(String var1) {
      this.var_filtretsd = var1;
   }

   public String getVar_periode() {
      return this.var_periode;
   }

   public void setVar_periode(String var1) {
      this.var_periode = var1;
   }

   public String getDossier() {
      return this.dossier;
   }

   public void setDossier(String var1) {
      this.dossier = var1;
   }

   public String getParc() {
      return this.parc;
   }

   public void setParc(String var1) {
      this.parc = var1;
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

   public float getNbreAnCmp() {
      return this.nbreAnCmp;
   }

   public void setNbreAnCmp(float var1) {
      this.nbreAnCmp = var1;
   }

   public float getNbreAnFix() {
      return this.nbreAnFix;
   }

   public void setNbreAnFix(float var1) {
      this.nbreAnFix = var1;
   }

   public boolean isBttvalider() {
      return this.bttvalider;
   }

   public void setBttvalider(boolean var1) {
      this.bttvalider = var1;
   }

   public Amortissements getAmortissements() {
      return this.amortissements;
   }

   public void setAmortissements(Amortissements var1) {
      this.amortissements = var1;
   }

   public AmortissementReg getAmortissementReg() {
      return this.amortissementReg;
   }

   public void setAmortissementReg(AmortissementReg var1) {
      this.amortissementReg = var1;
   }

   public DataModel getDataModelReglement() {
      return this.dataModelReglement;
   }

   public void setDataModelReglement(DataModel var1) {
      this.dataModelReglement = var1;
   }

   public double getEcart_dot() {
      return this.ecart_dot;
   }

   public void setEcart_dot(double var1) {
      this.ecart_dot = var1;
   }

   public double getTot_dot_theo() {
      return this.tot_dot_theo;
   }

   public void setTot_dot_theo(double var1) {
      this.tot_dot_theo = var1;
   }

   public double getTot_dot_trf() {
      return this.tot_dot_trf;
   }

   public void setTot_dot_trf(double var1) {
      this.tot_dot_trf = var1;
   }

   public boolean isTestMode() {
      if (this.amortissements.getAmoTypeSortie() == 1) {
         this.testMode = true;
      } else {
         this.testMode = false;
      }

      return this.testMode;
   }

   public void setTestMode(boolean var1) {
      this.testMode = var1;
   }

   public boolean isShoModalPanelReglement() {
      return this.shoModalPanelReglement;
   }

   public void setShoModalPanelReglement(boolean var1) {
      this.shoModalPanelReglement = var1;
   }

   public DataModel getDatamodelAmortissement() {
      return this.datamodelAmortissement;
   }

   public void setDatamodelAmortissement(DataModel var1) {
      this.datamodelAmortissement = var1;
   }

   public ExercicesComptable getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesComptable var1) {
      this.selectedExo = var1;
   }

   public String getActivite() {
      return this.activite;
   }

   public void setActivite(String var1) {
      this.activite = var1;
   }

   public String getCompte_amo() {
      return this.compte_amo;
   }

   public void setCompte_amo(String var1) {
      this.compte_amo = var1;
   }

   public String getCompte_dot() {
      return this.compte_dot;
   }

   public void setCompte_dot(String var1) {
      this.compte_dot = var1;
   }

   public String getCompte_immo() {
      return this.compte_immo;
   }

   public void setCompte_immo(String var1) {
      this.compte_immo = var1;
   }

   public String getCompte_ces() {
      return this.compte_ces;
   }

   public void setCompte_ces(String var1) {
      this.compte_ces = var1;
   }

   public UtilDate getUtilDate() {
      return this.utilDate;
   }

   public void setUtilDate(UtilDate var1) {
      this.utilDate = var1;
   }

   public boolean isReinvestissement() {
      return this.reinvestissement;
   }

   public void setReinvestissement(boolean var1) {
      this.reinvestissement = var1;
   }

   public boolean isVisibiliteAmortReg() {
      return this.visibiliteAmortReg;
   }

   public void setVisibiliteAmortReg(boolean var1) {
      this.visibiliteAmortReg = var1;
   }

   public DataModel getDatamodelTableau() {
      return this.datamodelTableau;
   }

   public void setDatamodelTableau(DataModel var1) {
      this.datamodelTableau = var1;
   }

   public Date getDateDebut() {
      return this.dateDebut;
   }

   public void setDateDebut(Date var1) {
      this.dateDebut = var1;
   }

   public boolean isShowModalPanelTransfert() {
      return this.showModalPanelTransfert;
   }

   public void setShowModalPanelTransfert(boolean var1) {
      this.showModalPanelTransfert = var1;
   }

   public double getTot_reg() {
      return this.tot_reg;
   }

   public void setTot_reg(double var1) {
      this.tot_reg = var1;
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

   public TransfertCompta getTransfertCompta() {
      return this.transfertCompta;
   }

   public void setTransfertCompta(TransfertCompta var1) {
      this.transfertCompta = var1;
   }

   public Date getDateFin() {
      return this.dateFin;
   }

   public void setDateFin(Date var1) {
      this.dateFin = var1;
   }

   public int getTestDossier() {
      return this.testDossier;
   }

   public void setTestDossier(int var1) {
      this.testDossier = var1;
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

   public String getAgent() {
      return this.agent;
   }

   public void setAgent(String var1) {
      this.agent = var1;
   }

   public String getCle1() {
      return this.cle1;
   }

   public void setCle1(String var1) {
      this.cle1 = var1;
   }

   public boolean isTestactivite() {
      return this.testactivite;
   }

   public void setTestactivite(boolean var1) {
      this.testactivite = var1;
   }

   public boolean isTestagent() {
      return this.testagent;
   }

   public void setTestagent(boolean var1) {
      this.testagent = var1;
   }

   public String getNatureDetail() {
      return this.natureDetail;
   }

   public void setNatureDetail(String var1) {
      this.natureDetail = var1;
   }

   public boolean isPresenceParc() {
      return this.presenceParc;
   }

   public void setPresenceParc(boolean var1) {
      this.presenceParc = var1;
   }

   public List getMesNatureDetail() {
      return this.mesNatureDetail;
   }

   public void setMesNatureDetail(List var1) {
      this.mesNatureDetail = var1;
   }

   public List getLesPointDeVente() {
      return this.lesPointDeVente;
   }

   public void setLesPointDeVente(List var1) {
      this.lesPointDeVente = var1;
   }

   public List getLesSecteur() {
      return this.lesSecteur;
   }

   public void setLesSecteur(List var1) {
      this.lesSecteur = var1;
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

   public List getLesplanComptablesCmptAmoItems() {
      return this.lesplanComptablesCmptAmoItems;
   }

   public void setLesplanComptablesCmptAmoItems(List var1) {
      this.lesplanComptablesCmptAmoItems = var1;
   }

   public List getLesplanComptablesCmptCesItems() {
      return this.lesplanComptablesCmptCesItems;
   }

   public void setLesplanComptablesCmptCesItems(List var1) {
      this.lesplanComptablesCmptCesItems = var1;
   }

   public List getLesplanComptablesCmptDotItems() {
      return this.lesplanComptablesCmptDotItems;
   }

   public void setLesplanComptablesCmptDotItems(List var1) {
      this.lesplanComptablesCmptDotItems = var1;
   }

   public List getLesplanComptablesCmptImoItems() {
      return this.lesplanComptablesCmptImoItems;
   }

   public void setLesplanComptablesCmptImoItems(List var1) {
      this.lesplanComptablesCmptImoItems = var1;
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

   public int getNbLigne() {
      return this.nbLigne;
   }

   public void setNbLigne(int var1) {
      this.nbLigne = var1;
   }

   public boolean isShowModalPanelFind() {
      return this.showModalPanelFind;
   }

   public void setShowModalPanelFind(boolean var1) {
      this.showModalPanelFind = var1;
   }

   public List getLesComptesUtilisesItems() {
      return this.lesComptesUtilisesItems;
   }

   public void setLesComptesUtilisesItems(List var1) {
      this.lesComptesUtilisesItems = var1;
   }

   public int getVar_nat_bien() {
      return this.var_nat_bien;
   }

   public void setVar_nat_bien(int var1) {
      this.var_nat_bien = var1;
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

   public String getVar_chassis() {
      return this.var_chassis;
   }

   public void setVar_chassis(String var1) {
      this.var_chassis = var1;
   }

   public List getLesPeriodesItems() {
      return this.lesPeriodesItems;
   }

   public void setLesPeriodesItems(List var1) {
      this.lesPeriodesItems = var1;
   }

   public long getVar_numero() {
      return this.var_numero;
   }

   public void setVar_numero(long var1) {
      this.var_numero = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isZoneInterdite() {
      return this.zoneInterdite;
   }

   public void setZoneInterdite(boolean var1) {
      this.zoneInterdite = var1;
   }

   public List getMeslocalisationsItems() {
      return this.meslocalisationsItems;
   }

   public void setMeslocalisationsItems(List var1) {
      this.meslocalisationsItems = var1;
   }

   public String getVar_localisation() {
      return this.var_localisation;
   }

   public void setVar_localisation(String var1) {
      this.var_localisation = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
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

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public String getPdfFileName() {
      return this.pdfFileName;
   }

   public void setPdfFileName(String var1) {
      this.pdfFileName = var1;
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

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public boolean isVar_affFicPdf() {
      return this.var_affFicPdf;
   }

   public void setVar_affFicPdf(boolean var1) {
      this.var_affFicPdf = var1;
   }

   public boolean isShowModalPanelScan() {
      return this.showModalPanelScan;
   }

   public void setShowModalPanelScan(boolean var1) {
      this.showModalPanelScan = var1;
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

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public DataModel getDataModelInventaire() {
      return this.dataModelInventaire;
   }

   public void setDataModelInventaire(DataModel var1) {
      this.dataModelInventaire = var1;
   }

   public boolean isShowModalPanelPrintQrCode() {
      return this.showModalPanelPrintQrCode;
   }

   public void setShowModalPanelPrintQrCode(boolean var1) {
      this.showModalPanelPrintQrCode = var1;
   }

   public String getVar_activite() {
      return this.var_activite;
   }

   public void setVar_activite(String var1) {
      this.var_activite = var1;
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

   public int getModeGraph() {
      return this.modeGraph;
   }

   public void setModeGraph(int var1) {
      this.modeGraph = var1;
   }

   public int getValQteGraph() {
      return this.valQteGraph;
   }

   public void setValQteGraph(int var1) {
      this.valQteGraph = var1;
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

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
   }

   public int getNbDecGraph() {
      return this.nbDecGraph;
   }

   public void setNbDecGraph(int var1) {
      this.nbDecGraph = var1;
   }

   public String getUniteGraph() {
      return this.uniteGraph;
   }

   public void setUniteGraph(String var1) {
      this.uniteGraph = var1;
   }

   public String getSousTitreGraph() {
      return this.sousTitreGraph;
   }

   public void setSousTitreGraph(String var1) {
      this.sousTitreGraph = var1;
   }

   public List getLesplanComptablesFournisseursItems() {
      return this.lesplanComptablesFournisseursItems;
   }

   public void setLesplanComptablesFournisseursItems(List var1) {
      this.lesplanComptablesFournisseursItems = var1;
   }

   public String getCompte_fournisseur() {
      return this.compte_fournisseur;
   }

   public void setCompte_fournisseur(String var1) {
      this.compte_fournisseur = var1;
   }

   public String getCoordonnees() {
      return this.coordonnees;
   }

   public void setCoordonnees(String var1) {
      this.coordonnees = var1;
   }

   public String getOrigine() {
      return this.origine;
   }

   public void setOrigine(String var1) {
      this.origine = var1;
   }

   public boolean isShoModalPanelMapbox() {
      return this.shoModalPanelMapbox;
   }

   public void setShoModalPanelMapbox(boolean var1) {
      this.shoModalPanelMapbox = var1;
   }

   public List getMesModelesItems() {
      return this.mesModelesItems;
   }

   public void setMesModelesItems(List var1) {
      this.mesModelesItems = var1;
   }
}
