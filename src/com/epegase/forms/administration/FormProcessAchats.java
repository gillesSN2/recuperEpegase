package com.epegase.forms.administration;

import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.ProcessEnteteAchats;
import com.epegase.systeme.classe.ProcessLigneAchats;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersFavoris;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetTable;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.ProcessEnteteAchatsDao;
import com.epegase.systeme.dao.ProcessLigneAchatsDao;
import com.epegase.systeme.dao.ProductionAtelierDao;
import com.epegase.systeme.dao.ProductionLigneDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersFavorisDao;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureSuffixeProduction;
import com.epegase.systeme.xml.LireLesoptionsStocks;
import com.epegase.systeme.xml.OptionStocks;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

public class FormProcessAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private UserDao userDao;
   private int nature;
   private OptionStocks optionStocks;
   private LireLesoptionsStocks lireLesoptionsStocks;
   private List mesSuffixeProductionItems = new ArrayList();
   private boolean afficheSuffixe = false;
   private ProcessEnteteAchats processEnteteAchats;
   private List processEnteteList = new ArrayList();
   private transient DataModel datamodelProcessEntete = new ListDataModel();
   private ProcessEnteteAchatsDao processEnteteAchatsDao;
   private boolean showModalPanelProcess = false;
   private boolean var_affiche_bouton = false;
   private ProcessLigneAchatsDao processLigneAchatsDao;
   private boolean inactif;
   private boolean creationLot;
   private List mesServicesRecItems = new ArrayList();
   private String filtreService;
   private List lesServices = new ArrayList();
   private ServiceDao serviceDao;
   private List lesParcs = new ArrayList();
   private ParcDao parcDao;
   private DepotAchatsDao depotAchatsDao;
   private DepotAchats depotAchats;
   private ProcessLigneAchats processGenereAchats = new ProcessLigneAchats();
   private List processGenereList = new ArrayList();
   private transient DataModel datamodelProcessGenere = new ListDataModel();
   private List mesProduitsDepotsGenereItems = new ArrayList();
   private ProcessLigneAchats processIntrantAchats = new ProcessLigneAchats();
   private List processIntrantList = new ArrayList();
   private transient DataModel datamodelProcessIntrant = new ListDataModel();
   private List mesProduitsDepotsIntrantsItems = new ArrayList();
   private boolean showModalPanelProduitInterchangeable = false;
   private List produitInterchangeableList = new ArrayList();
   private transient DataModel datamodelProduitInterchangeable = new ListDataModel();
   private ProcessLigneAchats processSousProduitAchats = new ProcessLigneAchats();
   private List processSousProduitList = new ArrayList();
   private transient DataModel datamodelProcessSousProduit = new ListDataModel();
   private List mesProduitsDepotsSousProduitItems = new ArrayList();
   private ProcessLigneAchats processDechetAchats = new ProcessLigneAchats();
   private List processDechetList = new ArrayList();
   private transient DataModel datamodelProcessDechet = new ListDataModel();
   private List mesProduitsDepotsDechetItems = new ArrayList();
   private Taches taches = new Taches();
   private TachesDao tachesDao;
   private ProcessLigneAchats processTacheAchats = new ProcessLigneAchats();
   private List processTacheList = new ArrayList();
   private transient DataModel datamodelProcessTache = new ListDataModel();
   private transient DataModel datamodelTaches = new ListDataModel();
   private boolean showModalPanelTaches = false;
   private boolean showModalPanelGestionTaches = false;
   private List lesProcessService = new ArrayList();
   private transient DataModel datamodelService = new ListDataModel();
   private List lesProcessParc = new ArrayList();
   private transient DataModel datamodelParc = new ListDataModel();
   private ObjetTable objetTable = new ObjetTable();
   private Produits produitsFabrique = new Produits();
   private Produits produitsGenere = new Produits();
   private Produits produitsUtilise = new Produits();
   private Produits produitsSousProduit;
   private Produits produitsDechet;
   private Produits produits = new Produits();
   private ProduitsAchsDao produitsAchsDao;
   private ProduitsDepot produitsDepot;
   private ProduitsDepotDao produitsDepotDao;
   private List mesProduitsDepotsItems = new ArrayList();
   private List listeProduitDepot = new ArrayList();
   private List mesUnitesProduits = new ArrayList();
   private boolean showModalPanelProduits = false;
   private transient DataModel dataModelProduits = new ListDataModel();
   private int typeProduits;
   private List lesProduits = new ArrayList();
   private boolean var_aff_condit;
   private List mesConditionnementsProduits = new ArrayList();
   private CalculStock calculStock = new CalculStock();
   private List mesSitesItems = new ArrayList();
   private List mesLignesItems = new ArrayList();
   private List mesAteliersItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private List mesActivitesItems;
   private SiteDao siteDao;
   private ProductionLigneDao productionLigneDao;
   private ProductionAtelierDao productionAtelierDao;
   private ActivitesDao activitesDao;
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
   private String var_tarif1;
   private String format;
   private UtilPrint utilPrint;
   private List lesUserHabilites = new ArrayList();
   private transient DataModel dataModelUsersHabilites = new ListDataModel();
   private UsersFavorisDao usersFavorisDao;
   private List lesUsersFavoris = new ArrayList();

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.processEnteteAchatsDao = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.processLigneAchatsDao = new ProcessLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.tachesDao = new TachesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.parcDao = new ParcDao(this.baseLog, this.utilInitHibernate);
      this.depotAchatsDao = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.productionLigneDao = new ProductionLigneDao(this.baseLog, this.utilInitHibernate);
      this.productionAtelierDao = new ProductionAtelierDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.usersFavorisDao = new UsersFavorisDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerProcess(Session var1) throws HibernateException, NamingException, IOException {
      this.lireLesoptionsStocks = new LireLesoptionsStocks();
      this.lireLesoptionsStocks.setStrId(this.structureLog.getStrid());
      this.optionStocks = this.lireLesoptionsStocks.lancer();
      this.processEnteteList = this.processEnteteAchatsDao.selectProcess(var1);
      this.datamodelProcessEntete.setWrappedData(this.processEnteteList);
      this.lesServices = this.serviceDao.chargerLesServices(var1);
      this.mesServicesItems = this.serviceDao.chargerLesServicesItems(0, false, var1);
      this.mesServicesRecItems = this.mesServicesItems;
      this.lesParcs = this.parcDao.chargerLesParcsUsine(var1);
      this.mesSitesItems = this.siteDao.chargerLesSitesItems(var1);
      this.recupererActiviteItem(var1);
      LectureSuffixeProduction var2 = new LectureSuffixeProduction();
      this.mesSuffixeProductionItems = var2.getMesSuffixesItems();
      if (this.mesSuffixeProductionItems != null && this.mesSuffixeProductionItems.size() != 0) {
         this.afficheSuffixe = true;
      } else {
         this.afficheSuffixe = false;
      }

   }

   public void selectionService() throws HibernateException, NamingException {
      if (this.filtreService != null && !this.filtreService.isEmpty() && !this.filtreService.equals("100")) {
         this.processEnteteList = this.processEnteteAchatsDao.selectProcess(this.filtreService, (Session)null);
      } else {
         this.processEnteteList = this.processEnteteAchatsDao.selectProcess((Session)null);
      }

      this.datamodelProcessEntete.setWrappedData(this.processEnteteList);
   }

   public void recupererActiviteItem(Session var1) throws HibernateException, NamingException {
      this.mesActivitesItems = new ArrayList();
      this.laColonne1Items = new ArrayList();
      this.laColonne2Items = new ArrayList();
      this.laColonne3Items = new ArrayList();
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
      } else {
         this.decoupageActivite = false;
      }

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
      } else {
         this.mesActivitesItems = this.activitesDao.chargerLesActivites(var1);
      }

   }

   public void selectionProcess() throws HibernateException, NamingException {
      if (this.datamodelProcessEntete.isRowAvailable()) {
         this.processEnteteAchats = (ProcessEnteteAchats)this.datamodelProcessEntete.getRowData();
         if (this.processEnteteAchats.getProcesInactif() == 1) {
            this.inactif = true;
         } else {
            this.inactif = false;
         }

         if (this.processEnteteAchats.getProcesCreationLot() == 1) {
            this.creationLot = true;
         } else {
            this.creationLot = false;
         }

         this.var_aff_condit = false;
         this.lesUserHabilites.clear();
         this.lesUsersFavoris.clear();
         this.processGenereList.clear();
         this.processIntrantList.clear();
         this.processSousProduitList.clear();
         this.processDechetList.clear();
         this.processTacheList.clear();
         this.lesProcessService.clear();
         this.lesProcessParc.clear();
         this.mesLignesItems.clear();
         this.mesAteliersItems.clear();
         this.mesActivitesItems.clear();
         this.mesConditionnementsProduits.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         if (this.processEnteteAchats.getProcesOption2() == 0) {
            this.produits = this.produitsAchsDao.chargeToutProduit(this.processEnteteAchats.getProcesCode(), var1);
         } else {
            this.produits = null;
         }

         this.typeProduits = 0;
         this.mefConditionnementDepot(this.produits, var1);
         new ArrayList();
         List var2 = this.processLigneAchatsDao.chargerDetailProcess(this.processEnteteAchats, var1);
         if (var2.size() == 0) {
            ArrayList var7 = new ArrayList();
            this.datamodelProcessGenere.setWrappedData(var7);
            this.datamodelProcessIntrant.setWrappedData(var7);
            this.datamodelProcessSousProduit.setWrappedData(var7);
            this.datamodelProcessDechet.setWrappedData(var7);
            this.datamodelProcessTache.setWrappedData(var7);
         } else {
            new ProcessLigneAchats();

            for(int var4 = 0; var4 < var2.size(); ++var4) {
               ProcessLigneAchats var3 = (ProcessLigneAchats)var2.get(var4);
               if (var3.getProcesligType() == 1) {
                  this.processIntrantList.add(var3);
               } else if (var3.getProcesligType() == 2) {
                  this.processSousProduitList.add(var3);
               } else if (var3.getProcesligType() == 3) {
                  this.processDechetList.add(var3);
               } else if (var3.getProcesligType() == 4) {
                  this.processTacheList.add(var3);
               } else if (var3.getProcesligType() == 5) {
                  this.processGenereList.add(var3);
               }
            }

            this.datamodelProcessGenere.setWrappedData(this.processGenereList);
            this.datamodelProcessIntrant.setWrappedData(this.processIntrantList);
            this.datamodelProcessSousProduit.setWrappedData(this.processSousProduitList);
            this.datamodelProcessDechet.setWrappedData(this.processDechetList);
            this.datamodelProcessTache.setWrappedData(this.processTacheList);
            this.lesUsersFavoris = this.usersFavorisDao.selectUsersProcess(this.processEnteteAchats.getProcesCode(), var1);
            this.lesUserHabilites = this.userDao.chargerLesUsers(var1);
            if (this.lesUserHabilites.size() != 0) {
               new Users();

               for(int var5 = 0; var5 < this.lesUserHabilites.size(); ++var5) {
                  Users var8 = (Users)this.lesUserHabilites.get(var5);
                  if (this.lesUsersFavoris.size() == 0) {
                     var8.setSelectUser(false);
                  } else {
                     for(int var6 = 0; var6 < this.lesUsersFavoris.size(); ++var6) {
                        if (((UsersFavoris)this.lesUsersFavoris.get(var6)).getUsers().getUsrid() == var8.getUsrid()) {
                           var8.setSelectUser(true);
                           break;
                        }
                     }
                  }
               }
            }

            this.dataModelUsersHabilites.setWrappedData(this.lesUserHabilites);
            if (this.processEnteteAchats.getProcesSite() != null && !this.processEnteteAchats.getProcesSite().isEmpty()) {
               this.chargerLigne(var1);
               if (this.processEnteteAchats.getProcesLigne() != null && !this.processEnteteAchats.getProcesLigne().isEmpty()) {
                  this.chargerAtelier(var1);
               }
            }

            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }
         }

         this.utilInitHibernate.closeSession();
         this.datamodelService.setWrappedData(this.lesProcessService);
         this.datamodelParc.setWrappedData(this.lesProcessParc);
         this.var_affiche_bouton = true;
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.processEnteteAchats.getProcesActivite() != null && !this.processEnteteAchats.getProcesActivite().isEmpty() && this.processEnteteAchats.getProcesActivite().contains(":")) {
         String[] var1 = null;
         if (!this.processEnteteAchats.getProcesActivite().contains("#")) {
            var1 = this.processEnteteAchats.getProcesActivite().split(":");
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
            String[] var2 = this.processEnteteAchats.getProcesActivite().split("#");

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

   public boolean controlePresenceDepot() {
      boolean var1 = false;
      if (this.depotAchats.getDpoService() != null && !this.depotAchats.getDpoService().isEmpty() && this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         String[] var2 = this.usersLog.getUsrService().split(":");
         if (this.depotAchats.getDpoService().contains(",")) {
            String[] var3 = this.depotAchats.getDpoService().split(",");
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               String var6 = var3[var5];
               if (var6.equals(var2[0])) {
                  var1 = true;
                  break;
               }
            }
         } else if (this.depotAchats.getDpoService().equals(var2[0])) {
            var1 = true;
         }
      }

      return var1;
   }

   public void ajouterProcess() {
      this.processEnteteAchats = new ProcessEnteteAchats();
      this.processGenereAchats = new ProcessLigneAchats();
      this.processIntrantAchats = new ProcessLigneAchats();
      this.processSousProduitAchats = new ProcessLigneAchats();
      this.processDechetAchats = new ProcessLigneAchats();
      this.produitsFabrique = new Produits();
      this.produitsGenere = new Produits();
      this.produitsUtilise = new Produits();
      this.produitsSousProduit = new Produits();
      this.produitsDechet = new Produits();
      this.produits = new Produits();
      this.inactif = false;
      this.creationLot = false;
      this.processGenereList.clear();
      this.datamodelProcessGenere.setWrappedData(this.processGenereList);
      this.processIntrantList.clear();
      this.datamodelProcessIntrant.setWrappedData(this.processIntrantList);
      this.processSousProduitList.clear();
      this.datamodelProcessSousProduit.setWrappedData(this.processSousProduitList);
      this.processDechetList.clear();
      this.datamodelProcessDechet.setWrappedData(this.processDechetList);
      this.lesProcessService.clear();
      this.lesProcessParc.clear();
      this.datamodelService.setWrappedData(this.lesProcessService);
      this.datamodelParc.setWrappedData(this.lesProcessParc);
      this.showModalPanelProcess = true;
   }

   public void modifierProcess() throws HibernateException, NamingException {
      if (this.processEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         if (this.processEnteteAchats.getProcesOption2() == 0) {
            this.produitsFabrique = this.produitsAchsDao.chargeToutProduit(this.processEnteteAchats.getProcesCode(), var1);
            if (this.produitsFabrique != null) {
               this.processEnteteAchats.setProcesStock(this.produits.getProStock());
               this.produits = this.produitsFabrique;
               this.lesProcessService.clear();
               this.lesProcessParc.clear();
               this.datamodelService.setWrappedData(this.lesProcessService);
               this.datamodelParc.setWrappedData(this.lesProcessParc);
               this.ajouterIntrants();
               this.ajouterSousProduits();
               this.ajouterDechets();
               this.ajouterTaches();
               this.showModalPanelProcess = true;
            }
         } else {
            this.processEnteteAchats.setProcesStock(0);
            this.produitsGenere = null;
            this.produits = null;
            this.lesProcessService.clear();
            this.lesProcessParc.clear();
            this.datamodelService.setWrappedData(this.lesProcessService);
            this.datamodelParc.setWrappedData(this.lesProcessParc);
            this.ajouterGeneres();
            this.ajouterIntrants();
            this.ajouterSousProduits();
            this.ajouterDechets();
            this.ajouterTaches();
            this.showModalPanelProcess = true;
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void supprimerProcess() throws HibernateException, NamingException {
      if (this.processEnteteAchats != null) {
         String var1 = this.processEnteteAchats.getProcesCode();
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            this.processEnteteList.remove(this.processEnteteAchats);
            this.datamodelProcessEntete.setWrappedData(this.processEnteteList);
            new ArrayList();
            List var4 = this.processLigneAchatsDao.chargerDetailProcess(this.processEnteteAchats, var2);
            if (var4.size() != 0) {
               new ProcessLigneAchats();

               for(int var6 = 0; var6 < var4.size(); ++var6) {
                  ProcessLigneAchats var5 = (ProcessLigneAchats)var4.get(var6);
                  this.processLigneAchatsDao.delete(var5, var2);
               }
            }

            this.processEnteteAchats = this.processEnteteAchatsDao.rechercheProcess(this.processEnteteAchats.getProcesId(), var2);
            if (this.processEnteteAchats != null) {
               this.processEnteteAchatsDao.delete(this.processEnteteAchats, var2);
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

         this.produits = this.produitsAchsDao.chargeToutProduit(var1, (Session)null);
         if (this.produits != null) {
            this.produits.setProProcess(0);
            this.produits = this.produitsAchsDao.modif(this.produits);
         }
      }

   }

   public void annulerProcess() {
      this.var_affiche_bouton = false;
      this.showModalPanelProcess = false;
   }

   public void saveProcess() throws HibernateException, NamingException {
      int var3;
      if (this.decoupageActivite) {
         String var1 = "";
         boolean var2 = true;
         if (this.lesDecoupagesActivites.size() != 0) {
            for(var3 = 0; var3 < this.lesDecoupagesActivites.size(); ++var3) {
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

         this.processEnteteAchats.setProcesActivite(var1);
      } else if (this.processEnteteAchats.getProcesActivite() != null && this.processEnteteAchats.getProcesActivite().contains(":")) {
         String[] var10 = this.processEnteteAchats.getProcesActivite().split(":");
         this.processEnteteAchats.setProcesActivite(var10[0]);
      } else {
         this.processEnteteAchats.setProcesActivite("");
      }

      if (this.inactif) {
         this.processEnteteAchats.setProcesInactif(1);
      } else {
         this.processEnteteAchats.setProcesInactif(0);
      }

      if (this.creationLot) {
         this.processEnteteAchats.setProcesCreationLot(1);
      } else {
         this.processEnteteAchats.setProcesCreationLot(0);
      }

      if (this.processEnteteAchats.getProcesService() != null && !this.processEnteteAchats.getProcesService().isEmpty() && this.processEnteteAchats.getProcesService().equals("100")) {
         this.processEnteteAchats.setProcesService("");
      }

      if (this.processEnteteAchats.getProcesId() == 0L) {
         this.processEnteteAchats.setProcesUserCreat(this.usersLog.getUsrid());
         this.processEnteteAchats.setProcesDateCreat(new Date());
         this.processEnteteAchats = this.processEnteteAchatsDao.insert(this.processEnteteAchats);
         this.processEnteteList.add(this.processEnteteAchats);
         this.datamodelProcessEntete.setWrappedData(this.processEnteteList);
      } else {
         this.processEnteteAchats.setProcesUserModif(this.usersLog.getUsrid());
         this.processEnteteAchats.setProcesDateModif(new Date());
         this.processEnteteAchats = this.processEnteteAchatsDao.modif(this.processEnteteAchats);
      }

      Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
      Transaction var12 = null;

      try {
         var12 = var11.beginTransaction();
         if (this.processGenereList.size() != 0) {
            for(var3 = 0; var3 < this.processGenereList.size(); ++var3) {
               this.processGenereAchats = this.processLigneAchatsDao.chercherLigne(((ProcessLigneAchats)this.processGenereList.get(var3)).getProcesligId(), var11);
               if (this.processGenereAchats != null) {
                  this.processGenereAchats.setProcesligOrdre(var3 + 1);
                  this.processGenereAchats.setProcessEnteteAchats(this.processEnteteAchats);
                  this.processGenereAchats = this.processLigneAchatsDao.modif(this.processGenereAchats, var11);
               }
            }
         }

         if (this.processIntrantList.size() != 0) {
            for(var3 = 0; var3 < this.processIntrantList.size(); ++var3) {
               this.processIntrantAchats = this.processLigneAchatsDao.chercherLigne(((ProcessLigneAchats)this.processIntrantList.get(var3)).getProcesligId(), var11);
               if (this.processIntrantAchats != null) {
                  this.processIntrantAchats.setProcesligOrdre(var3 + 1);
                  this.processIntrantAchats.setProcessEnteteAchats(this.processEnteteAchats);
                  this.processIntrantAchats = this.processLigneAchatsDao.modif(this.processIntrantAchats, var11);
               }
            }
         }

         if (this.processSousProduitList.size() != 0) {
            for(var3 = 0; var3 < this.processSousProduitList.size(); ++var3) {
               this.processSousProduitAchats = this.processLigneAchatsDao.chercherLigne(((ProcessLigneAchats)this.processSousProduitList.get(var3)).getProcesligId(), var11);
               if (this.processSousProduitAchats != null) {
                  this.processSousProduitAchats.setProcesligOrdre(var3 + 1);
                  this.processSousProduitAchats.setProcessEnteteAchats(this.processEnteteAchats);
                  this.processSousProduitAchats = this.processLigneAchatsDao.modif(this.processSousProduitAchats, var11);
               }
            }
         }

         if (this.processDechetList.size() != 0) {
            for(var3 = 0; var3 < this.processDechetList.size(); ++var3) {
               this.processDechetAchats = this.processLigneAchatsDao.chercherLigne(((ProcessLigneAchats)this.processDechetList.get(var3)).getProcesligId(), var11);
               if (this.processDechetAchats != null) {
                  this.processDechetAchats.setProcesligOrdre(var3 + 1);
                  this.processDechetAchats.setProcessEnteteAchats(this.processEnteteAchats);
                  this.processDechetAchats = this.processLigneAchatsDao.modif(this.processDechetAchats, var11);
               }
            }
         }

         if (this.processTacheList.size() != 0) {
            for(var3 = 0; var3 < this.processTacheList.size(); ++var3) {
               this.processTacheAchats = this.processLigneAchatsDao.chercherLigne(((ProcessLigneAchats)this.processTacheList.get(var3)).getProcesligId(), var11);
               if (this.processTacheAchats != null) {
                  this.processTacheAchats.setProcesligOrdre(var3 + 1);
                  this.processTacheAchats.setProcessEnteteAchats(this.processEnteteAchats);
                  this.processTacheAchats = this.processLigneAchatsDao.modif(this.processTacheAchats, var11);
               }
            }
         }

         if (this.lesUserHabilites.size() != 0) {
            new UsersFavoris();
            int var4;
            UsersFavoris var13;
            if (this.lesUsersFavoris.size() != 0) {
               for(var4 = 0; var4 < this.lesUsersFavoris.size(); ++var4) {
                  var13 = (UsersFavoris)this.lesUsersFavoris.get(var4);
                  this.usersFavorisDao.delete(var13, var11);
               }
            }

            for(var4 = 0; var4 < this.lesUserHabilites.size(); ++var4) {
               if (((Users)this.lesUserHabilites.get(var4)).isSelectUser()) {
                  var13 = new UsersFavoris();
                  var13.setUsrfavCiviliteUser(((Users)this.lesUserHabilites.get(var4)).getUsrCivilite());
                  var13.setUsrfavDateCreat(new Date());
                  var13.setUsrfavFonctionUser(((Users)this.lesUserHabilites.get(var4)).getUsrFonction());
                  var13.setUsrfavIdUser(((Users)this.lesUserHabilites.get(var4)).getUsrid());
                  var13.setUsrfavLogin(this.processEnteteAchats.getProcesCode());
                  var13.setUsrfavNature(4);
                  var13.setUsrfavNom(this.processEnteteAchats.getProcesLibClient());
                  var13.setUsrfavNomUser(((Users)this.lesUserHabilites.get(var4)).getUsrNom());
                  var13.setUsrfavPrenomUser(((Users)this.lesUserHabilites.get(var4)).getUsrPrenom());
                  var13.setUsrfavUserCreat(this.usersLog.getUsrid());
                  var13.setUsrfavInactif(0);
                  var13.setUsers((Users)this.lesUserHabilites.get(var4));
                  this.usersFavorisDao.insert(var13, var11);
               }
            }
         }

         var12.commit();
      } catch (HibernateException var8) {
         if (var12 != null) {
            var12.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (this.processEnteteAchats.getProcesOption2() == 0) {
         this.produits = this.produitsAchsDao.chargeToutProduit(this.processEnteteAchats.getProcesCode(), (Session)null);
         if (this.produits != null) {
            this.produits.setProProcess(1);
            this.produits = this.produitsAchsDao.modif(this.produits);
         }
      }

      this.showModalPanelProcess = false;
      this.var_affiche_bouton = false;
   }

   public void chargerLigne() throws HibernateException, NamingException {
      this.chargerLigne((Session)null);
   }

   public void chargerLigne(Session var1) throws HibernateException, NamingException {
      if (this.processEnteteAchats.getProcesSite() != null && !this.processEnteteAchats.getProcesSite().isEmpty()) {
         this.mesLignesItems.clear();
         this.mesAteliersItems.clear();
         String var2 = "";
         if (this.processEnteteAchats.getProcesSite().contains(":")) {
            String[] var3 = this.processEnteteAchats.getProcesSite().split(":");
            var2 = var3[0];
         } else {
            var2 = this.processEnteteAchats.getProcesSite();
         }

         this.mesLignesItems = this.productionLigneDao.logProductionLigne(var2, var1);
      }

   }

   public void chargerAtelier() throws HibernateException, NamingException {
      this.chargerAtelier((Session)null);
   }

   public void chargerAtelier(Session var1) throws HibernateException, NamingException {
      if (this.processEnteteAchats.getProcesLigne() != null && !this.processEnteteAchats.getProcesLigne().isEmpty()) {
         this.mesAteliersItems.clear();
         String var2 = "";
         if (this.processEnteteAchats.getProcesLigne().contains(":")) {
            String[] var3 = this.processEnteteAchats.getProcesLigne().split(":");
            var2 = var3[0];
         } else {
            var2 = this.processEnteteAchats.getProcesLigne();
         }

         this.mesAteliersItems = this.productionAtelierDao.logProductionAtelier(var2, var1);
      }

   }

   public void selectionGeneres() throws HibernateException, NamingException {
      if (this.datamodelProcessGenere.isRowAvailable()) {
         this.typeProduits = 5;
         this.processGenereAchats = (ProcessLigneAchats)this.datamodelProcessGenere.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         if (this.processGenereAchats.getProcesligCode() != null && !this.processGenereAchats.getProcesligCode().isEmpty()) {
            this.produits = this.produitsAchsDao.chargeToutProduit(this.processGenereAchats.getProcesligCode(), var1);
            if (this.produits != null) {
               this.produitsUtilise = this.produits;
               this.mefConditionnementDepot(this.produits, var1);
            }
         } else {
            this.produits = new Produits();
            this.mefConditionnementDepot(this.produits, var1);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void ajouterGeneres() {
      this.typeProduits = 5;
      this.processGenereAchats = new ProcessLigneAchats();
      this.processIntrantAchats = new ProcessLigneAchats();
      this.processSousProduitAchats = new ProcessLigneAchats();
      this.processDechetAchats = new ProcessLigneAchats();
      this.processTacheAchats = new ProcessLigneAchats();
      this.produits = new Produits();
      this.produitsGenere = new Produits();
      this.produitsUtilise = new Produits();
      this.produitsSousProduit = new Produits();
      this.produitsDechet = new Produits();
      this.mesProduitsDepotsGenereItems.clear();
      this.mesProduitsDepotsGenereItems.add(new SelectItem(""));
   }

   public void supprimerGeneres() throws HibernateException, NamingException {
      if (this.processGenereAchats != null) {
         this.processGenereList.remove(this.processGenereAchats);
         this.processLigneAchatsDao.delete(this.processGenereAchats);
         this.datamodelProcessGenere.setWrappedData(this.processGenereList);
         this.ajouterGeneres();
      }

   }

   public void saveGeneres() throws HibernateException, NamingException {
      if (this.processGenereAchats.getProcesligCode() != null && !this.processGenereAchats.getProcesligCode().isEmpty()) {
         if (this.processEnteteAchats.getProcesId() == 0L) {
            this.processEnteteAchats = this.processEnteteAchatsDao.insert(this.processEnteteAchats);
            this.processEnteteList.add(this.processEnteteAchats);
            this.datamodelProcessEntete.setWrappedData(this.processEnteteList);
         }

         if (this.processGenereAchats.getProcesligId() == 0L) {
            this.processGenereAchats.setProcessEnteteAchats(this.processEnteteAchats);
            this.processGenereAchats.setProcesligType(5);
            this.processGenereAchats = this.processLigneAchatsDao.insert(this.processGenereAchats);
            this.processGenereList.add(this.processGenereAchats);
            this.datamodelProcessGenere.setWrappedData(this.processGenereList);
         } else {
            this.processGenereAchats.setProcesligType(5);
            this.processGenereAchats = this.processLigneAchatsDao.modif(this.processGenereAchats);
         }
      }

      this.ajouterGeneres();
   }

   public void selectionIntrants() throws HibernateException, NamingException {
      if (this.datamodelProcessIntrant.isRowAvailable()) {
         this.typeProduits = 1;
         this.processIntrantAchats = (ProcessLigneAchats)this.datamodelProcessIntrant.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         if (this.processIntrantAchats.getProcesligCode() != null && !this.processIntrantAchats.getProcesligCode().isEmpty()) {
            this.produits = this.produitsAchsDao.chargeToutProduit(this.processIntrantAchats.getProcesligCode(), var1);
            if (this.produits != null) {
               this.produitsUtilise = this.produits;
               this.mefConditionnementDepot(this.produits, var1);
            }
         } else {
            this.produits = new Produits();
            this.mefConditionnementDepot(this.produits, var1);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void ajouterIntrants() {
      this.typeProduits = 1;
      this.processGenereAchats = new ProcessLigneAchats();
      this.processIntrantAchats = new ProcessLigneAchats();
      this.processSousProduitAchats = new ProcessLigneAchats();
      this.processDechetAchats = new ProcessLigneAchats();
      this.processTacheAchats = new ProcessLigneAchats();
      this.produits = new Produits();
      this.produitsGenere = new Produits();
      this.produitsUtilise = new Produits();
      this.produitsSousProduit = new Produits();
      this.produitsDechet = new Produits();
      this.mesProduitsDepotsIntrantsItems.clear();
      this.mesProduitsDepotsIntrantsItems.add(new SelectItem(""));
   }

   public void supprimerIntrants() throws HibernateException, NamingException {
      if (this.processIntrantAchats != null) {
         this.processIntrantList.remove(this.processIntrantAchats);
         this.processLigneAchatsDao.delete(this.processIntrantAchats);
         this.datamodelProcessIntrant.setWrappedData(this.processIntrantList);
         this.ajouterIntrants();
      }

   }

   public void saveIntrants() throws HibernateException, NamingException {
      if (this.processIntrantAchats.getProcesligCode() != null && !this.processIntrantAchats.getProcesligCode().isEmpty()) {
         if (this.processEnteteAchats.getProcesId() == 0L) {
            this.processEnteteAchats = this.processEnteteAchatsDao.insert(this.processEnteteAchats);
            this.processEnteteList.add(this.processEnteteAchats);
            this.datamodelProcessEntete.setWrappedData(this.processEnteteList);
         }

         if (this.processIntrantAchats.getProcesligId() == 0L) {
            this.processIntrantAchats.setProcessEnteteAchats(this.processEnteteAchats);
            this.processIntrantAchats.setProcesligType(1);
            this.processIntrantAchats = this.processLigneAchatsDao.insert(this.processIntrantAchats);
            this.processIntrantList.add(this.processIntrantAchats);
            this.datamodelProcessIntrant.setWrappedData(this.processIntrantList);
         } else {
            this.processIntrantAchats.setProcesligType(1);
            this.processIntrantAchats = this.processLigneAchatsDao.modif(this.processIntrantAchats);
         }
      }

      this.ajouterIntrants();
   }

   public void ajouterProduitInterchangeable() throws HibernateException, NamingException {
      this.typeProduits = 1;
      this.processIntrantAchats = new ProcessLigneAchats();
      this.processIntrantAchats.setProcesligInterChange(true);
      this.produits = new Produits();
      this.produitInterchangeableList.clear();
      this.datamodelProduitInterchangeable.setWrappedData(this.produitInterchangeableList);
      this.mesProduitsDepotsIntrantsItems.clear();
      new ArrayList();
      List var1 = this.depotAchatsDao.selectActifDepot(34, (Session)null);
      if (var1.size() != 0) {
         this.depotAchats = new DepotAchats();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.depotAchats = (DepotAchats)var1.get(var2);
            this.mesProduitsDepotsIntrantsItems.add(new SelectItem(this.depotAchats.getDpoCode()));
         }
      }

      this.showModalPanelProduitInterchangeable = true;
   }

   public void modifierProduitInterchangeable() throws HibernateException, NamingException {
      if (this.processIntrantAchats != null) {
         this.produits = new Produits();
         this.produitInterchangeableList.clear();
         if (this.processIntrantAchats.getProcesligProduitInterchangeable() != null && !this.processIntrantAchats.getProcesligProduitInterchangeable().isEmpty()) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
            if (!this.processIntrantAchats.getProcesligProduitInterchangeable().contains(":")) {
               this.produits = this.produitsAchsDao.chargeToutProduit(this.processIntrantAchats.getProcesligProduitInterchangeable(), var1);
               if (this.produits != null) {
                  this.produitInterchangeableList.add(this.produits);
               }
            } else {
               String[] var2 = this.processIntrantAchats.getProcesligProduitInterchangeable().split(":");
               int var3 = var2.length;

               for(int var4 = 0; var4 < var3; ++var4) {
                  this.produits = this.produitsAchsDao.chargeToutProduit(var2[var4], var1);
                  if (this.produits != null) {
                     this.produitInterchangeableList.add(this.produits);
                  }
               }
            }

            this.utilInitHibernate.closeSession();
         }

         this.datamodelProduitInterchangeable.setWrappedData(this.produitInterchangeableList);
         this.showModalPanelProduitInterchangeable = true;
      }

   }

   public void supprimerProduitInterchangeable() {
      if (this.produits != null) {
         this.produitInterchangeableList.remove(this.produits);
         this.datamodelProduitInterchangeable.setWrappedData(this.produitInterchangeableList);
         this.produits = new Produits();
      }

   }

   public void fermerProduitInterchangeable() {
      this.showModalPanelProduitInterchangeable = false;
   }

   public void validerProduitInterchangeable() throws HibernateException, NamingException {
      if (this.processIntrantAchats != null) {
         String var1 = "";
         if (this.produitInterchangeableList.size() != 0) {
            for(int var2 = 0; var2 < this.produitInterchangeableList.size(); ++var2) {
               this.produits = (Produits)this.produitInterchangeableList.get(var2);
               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + ":" + this.produits.getProCode();
               } else {
                  var1 = this.produits.getProCode();
               }
            }
         }

         this.processIntrantAchats.setProcesligInterChange(true);
         this.processIntrantAchats.setProcesligProduitInterchangeable(var1);
         this.processIntrantAchats.setProcesligCode("");
         this.processIntrantAchats.setProcesligType(1);
         if (this.processEnteteAchats.getProcesId() == 0L) {
            this.processEnteteAchats = this.processEnteteAchatsDao.insert(this.processEnteteAchats);
            this.processEnteteList.add(this.processEnteteAchats);
            this.datamodelProcessEntete.setWrappedData(this.processEnteteList);
         }

         if (this.processIntrantAchats.getProcesligId() == 0L) {
            this.processIntrantAchats.setProcessEnteteAchats(this.processEnteteAchats);
            this.processIntrantAchats.setProcesligType(1);
            this.processIntrantAchats = this.processLigneAchatsDao.insert(this.processIntrantAchats);
            this.processIntrantList.add(this.processIntrantAchats);
            this.datamodelProcessIntrant.setWrappedData(this.processIntrantList);
         } else {
            this.processIntrantAchats.setProcesligType(1);
            this.processIntrantAchats = this.processLigneAchatsDao.modif(this.processIntrantAchats);
         }

         this.ajouterIntrants();
      }

      this.produits = new Produits();
      this.showModalPanelProduitInterchangeable = false;
   }

   public void selectionSousProduits() throws HibernateException, NamingException {
      if (this.datamodelProcessSousProduit.isRowAvailable()) {
         this.typeProduits = 2;
         this.processSousProduitAchats = (ProcessLigneAchats)this.datamodelProcessSousProduit.getRowData();
         this.produits = this.produitsAchsDao.chargeToutProduit(this.processSousProduitAchats.getProcesligCode(), (Session)null);
         if (this.produits != null) {
            this.produitsSousProduit = this.produits;
            this.mefConditionnementDepot(this.produits, (Session)null);
         }
      }

   }

   public void ajouterSousProduits() {
      this.typeProduits = 2;
      this.processGenereAchats = new ProcessLigneAchats();
      this.processIntrantAchats = new ProcessLigneAchats();
      this.processSousProduitAchats = new ProcessLigneAchats();
      this.processDechetAchats = new ProcessLigneAchats();
      this.processTacheAchats = new ProcessLigneAchats();
      this.produits = new Produits();
      this.produitsGenere = new Produits();
      this.produitsUtilise = new Produits();
      this.produitsSousProduit = new Produits();
      this.produitsDechet = new Produits();
      this.mesProduitsDepotsIntrantsItems.clear();
      this.mesProduitsDepotsIntrantsItems.add(new SelectItem(""));
   }

   public void supprimerSousProduits() throws HibernateException, NamingException {
      if (this.processSousProduitAchats != null) {
         this.processSousProduitList.remove(this.processSousProduitAchats);
         this.processLigneAchatsDao.delete(this.processSousProduitAchats);
         this.datamodelProcessSousProduit.setWrappedData(this.processSousProduitList);
         this.ajouterSousProduits();
      }

   }

   public void saveSousProduits() throws HibernateException, NamingException {
      if (this.processSousProduitAchats.getProcesligCode() != null && !this.processSousProduitAchats.getProcesligCode().isEmpty()) {
         if (this.processEnteteAchats.getProcesId() == 0L) {
            this.processEnteteAchats = this.processEnteteAchatsDao.insert(this.processEnteteAchats);
            this.processEnteteList.add(this.processEnteteAchats);
            this.datamodelProcessEntete.setWrappedData(this.processEnteteList);
         }

         if (this.processSousProduitAchats.getProcesligId() == 0L) {
            this.processSousProduitAchats.setProcessEnteteAchats(this.processEnteteAchats);
            this.processSousProduitAchats.setProcesligType(2);
            this.processSousProduitAchats = this.processLigneAchatsDao.insert(this.processSousProduitAchats);
            this.processSousProduitList.add(this.processSousProduitAchats);
            this.datamodelProcessSousProduit.setWrappedData(this.processSousProduitList);
         } else {
            this.processSousProduitAchats = this.processLigneAchatsDao.modif(this.processSousProduitAchats);
         }
      }

      this.ajouterSousProduits();
   }

   public void selectionDechets() throws HibernateException, NamingException {
      if (this.datamodelProcessDechet.isRowAvailable()) {
         this.typeProduits = 3;
         this.processDechetAchats = (ProcessLigneAchats)this.datamodelProcessDechet.getRowData();
         this.produits = this.produitsAchsDao.chargeToutProduit(this.processDechetAchats.getProcesligCode(), (Session)null);
         if (this.produits != null) {
            this.produitsDechet = this.produits;
            this.mefConditionnementDepot(this.produits, (Session)null);
         }
      }

   }

   public void ajouterDechets() {
      this.typeProduits = 3;
      this.processGenereAchats = new ProcessLigneAchats();
      this.processIntrantAchats = new ProcessLigneAchats();
      this.processSousProduitAchats = new ProcessLigneAchats();
      this.processDechetAchats = new ProcessLigneAchats();
      this.processTacheAchats = new ProcessLigneAchats();
      this.produits = new Produits();
      this.produitsGenere = new Produits();
      this.produitsUtilise = new Produits();
      this.produitsSousProduit = new Produits();
      this.produitsDechet = new Produits();
      this.mesProduitsDepotsIntrantsItems.clear();
      this.mesProduitsDepotsIntrantsItems.add(new SelectItem(""));
   }

   public void supprimerDechets() throws HibernateException, NamingException {
      if (this.processDechetAchats != null) {
         this.processDechetList.remove(this.processDechetAchats);
         this.processLigneAchatsDao.delete(this.processDechetAchats);
         this.datamodelProcessDechet.setWrappedData(this.processDechetList);
         this.ajouterDechets();
      }

   }

   public void saveDechets() throws HibernateException, NamingException {
      if (this.processDechetAchats.getProcesligCode() != null && !this.processDechetAchats.getProcesligCode().isEmpty()) {
         if (this.processEnteteAchats.getProcesId() == 0L) {
            this.processEnteteAchats = this.processEnteteAchatsDao.insert(this.processEnteteAchats);
            this.processEnteteList.add(this.processEnteteAchats);
            this.datamodelProcessEntete.setWrappedData(this.processEnteteList);
         }

         if (this.processDechetAchats.getProcesligId() == 0L) {
            this.processDechetAchats.setProcessEnteteAchats(this.processEnteteAchats);
            this.processDechetAchats.setProcesligType(3);
            this.processDechetAchats = this.processLigneAchatsDao.insert(this.processDechetAchats);
            this.processDechetList.add(this.processDechetAchats);
            this.datamodelProcessDechet.setWrappedData(this.processDechetList);
         } else {
            this.processDechetAchats = this.processLigneAchatsDao.modif(this.processDechetAchats);
         }
      }

      this.ajouterDechets();
   }

   public void selectionTaches() throws HibernateException, NamingException {
      if (this.datamodelProcessTache.isRowAvailable()) {
         this.processTacheAchats = (ProcessLigneAchats)this.datamodelProcessTache.getRowData();
      }

   }

   public void ajouterTaches() {
      this.taches = new Taches();
      this.processGenereAchats = new ProcessLigneAchats();
      this.processIntrantAchats = new ProcessLigneAchats();
      this.processSousProduitAchats = new ProcessLigneAchats();
      this.processDechetAchats = new ProcessLigneAchats();
      this.processTacheAchats = new ProcessLigneAchats();
      this.produits = new Produits();
      this.produitsGenere = new Produits();
      this.produitsUtilise = new Produits();
      this.produitsSousProduit = new Produits();
      this.produitsDechet = new Produits();
      this.metiersParc();
      this.showModalPanelGestionTaches = true;
   }

   public void modifierTaches() throws HibernateException, NamingException {
      if (this.processTacheAchats != null) {
         this.taches = this.tachesDao.rechercheTache(this.processTacheAchats.getProcesligCode(), (Session)null);
         if (this.taches == null) {
            this.taches = new Taches();
            this.processTacheAchats.setProcesligCode("");
            this.processTacheAchats.setProcesligLibClient("");
            this.processTacheAchats.setProcesligPrht(0.0D);
            this.processTacheAchats.setProcesligPvht(0.0D);
            this.processTacheAchats.setProcesligJj(0);
            this.processTacheAchats.setProcesligHh(0);
            this.processTacheAchats.setProcesligMm(0);
            this.processTacheAchats.setProcesligSs(0);
         }

         this.metiersParc();
         this.showModalPanelGestionTaches = true;
      }

   }

   public void metiersParc() {
      this.lesProcessService.clear();
      this.lesProcessParc.clear();
      Service var1;
      int var4;
      String var5;
      Parc var6;
      if (this.processTacheAchats.getProcesligId() == 0L) {
         int var2;
         if (this.lesServices.size() != 0) {
            new Service();

            for(var2 = 0; var2 < this.lesServices.size(); ++var2) {
               var1 = (Service)this.lesServices.get(var2);
               boolean var3 = false;
               if (this.lesServices.size() == 0) {
                  var3 = false;
               } else {
                  for(var4 = 0; var4 < this.lesProcessService.size(); ++var4) {
                     var5 = var1.getSerCode() + ":" + var1.getSerNomFr();
                     if (var5.equals(((ObjetTable)this.lesProcessService.get(var4)).getColumn_name())) {
                        var3 = true;
                        break;
                     }
                  }
               }

               if (!var3) {
                  this.objetTable = new ObjetTable();
                  this.objetTable.setColumn_name(var1.getSerCode() + ":" + var1.getSerNomFr());
                  this.objetTable.setColumn_qte(0);
                  this.objetTable.setColumn_pr(0.0D);
                  this.objetTable.setColumn_pv(0.0D);
                  this.lesProcessService.add(this.objetTable);
               }
            }
         }

         if (this.lesParcs.size() != 0) {
            new Parc();

            for(var2 = 0; var2 < this.lesParcs.size(); ++var2) {
               var6 = (Parc)this.lesParcs.get(var2);
               this.objetTable = new ObjetTable();
               this.objetTable.setColumn_id(var6.getPrcId());
               this.objetTable.setColumn_code(var6.getPrcImmatriculation());
               this.objetTable.setColumn_name(var6.getPrcNomFr());
               this.objetTable.setColumn_select(false);
               this.objetTable.setColumn_pr(var6.getPrcPrixRevient());
               this.objetTable.setColumn_pv(var6.getPrcPrixVente());
               this.lesProcessParc.add(this.objetTable);
            }
         }
      } else {
         String var7;
         String[] var8;
         int var10;
         String[] var11;
         if (this.processTacheAchats.getProcesligMetier() != null && !this.processTacheAchats.getProcesligMetier().isEmpty()) {
            if (!this.processTacheAchats.getProcesligMetier().contains(":")) {
               var7 = this.processTacheAchats.getProcesligMetier();
               var8 = var7.split("_");
               this.objetTable = new ObjetTable();
               this.objetTable.setColumn_name(var8[0]);
               this.objetTable.setColumn_qte(Integer.parseInt(var8[1]));
               this.objetTable.setColumn_pr(Double.parseDouble(var8[2]));
               this.objetTable.setColumn_pv(Double.parseDouble(var8[3]));
               this.lesProcessService.add(this.objetTable);
            } else {
               var7 = "";
               var8 = this.processTacheAchats.getProcesligMetier().split(":");

               for(var10 = 0; var10 < var8.length; ++var10) {
                  var7 = var8[var10];
                  var11 = var7.split("_");
                  this.objetTable = new ObjetTable();
                  this.objetTable.setColumn_name(var11[0]);
                  this.objetTable.setColumn_qte(Integer.parseInt(var11[1]));
                  this.objetTable.setColumn_pr(Double.parseDouble(var11[2]));
                  this.objetTable.setColumn_pv(Double.parseDouble(var11[3]));
                  this.lesProcessService.add(this.objetTable);
               }
            }
         }

         boolean var9;
         if (this.lesServices.size() != 0) {
            new Service();
            var9 = false;

            for(var10 = 0; var10 < this.lesServices.size(); ++var10) {
               var1 = (Service)this.lesServices.get(var10);
               var9 = false;
               if (this.lesProcessService.size() != 0) {
                  for(var4 = 0; var4 < this.lesProcessService.size(); ++var4) {
                     var5 = var1.getSerCode() + ":" + var1.getSerNomFr();
                     if (((ObjetTable)this.lesProcessService.get(var4)).getColumn_name().equals(var5)) {
                        var9 = true;
                        break;
                     }
                  }
               }

               if (!var9) {
                  this.objetTable = new ObjetTable();
                  this.objetTable.setColumn_name(var1.getSerCode() + ":" + var1.getSerNomFr());
                  this.objetTable.setColumn_qte(0);
                  this.objetTable.setColumn_pr(0.0D);
                  this.objetTable.setColumn_pv(0.0D);
                  this.lesProcessService.add(this.objetTable);
               }
            }
         }

         if (this.processTacheAchats.getProcesligMateriel() != null && !this.processTacheAchats.getProcesligMateriel().isEmpty()) {
            if (!this.processTacheAchats.getProcesligMateriel().contains(":")) {
               var7 = this.processTacheAchats.getProcesligMateriel();
               var8 = var7.split("_");
               this.objetTable = new ObjetTable();
               this.objetTable.setColumn_select(true);
               this.objetTable.setColumn_id(Long.parseLong(var8[0]));
               this.objetTable.setColumn_code(var8[1]);
               this.objetTable.setColumn_name(var8[2]);
               this.objetTable.setColumn_pr(Double.parseDouble(var8[3]));
               this.objetTable.setColumn_pv(Double.parseDouble(var8[4]));
               this.lesProcessParc.add(this.objetTable);
            } else {
               var7 = "";
               var8 = this.processTacheAchats.getProcesligMateriel().split(":");

               for(var10 = 0; var10 < var8.length; ++var10) {
                  var7 = var8[var10];
                  var11 = var7.split("_");
                  this.objetTable = new ObjetTable();
                  this.objetTable.setColumn_select(true);
                  this.objetTable.setColumn_id(Long.parseLong(var11[0]));
                  this.objetTable.setColumn_code(var11[1]);
                  this.objetTable.setColumn_name(var11[2]);
                  this.objetTable.setColumn_pr(Double.parseDouble(var11[3]));
                  this.objetTable.setColumn_pv(Double.parseDouble(var11[4]));
                  this.lesProcessParc.add(this.objetTable);
               }
            }
         }

         if (this.lesParcs.size() != 0) {
            new Parc();
            var9 = false;

            for(var10 = 0; var10 < this.lesParcs.size(); ++var10) {
               var6 = (Parc)this.lesParcs.get(var10);
               var9 = false;
               if (this.lesProcessParc.size() != 0) {
                  for(var4 = 0; var4 < this.lesProcessParc.size(); ++var4) {
                     if (((ObjetTable)this.lesProcessParc.get(var4)).getColumn_id() == var6.getPrcId()) {
                        var9 = true;
                        break;
                     }
                  }
               }

               if (!var9) {
                  this.objetTable = new ObjetTable();
                  this.objetTable.setColumn_select(false);
                  this.objetTable.setColumn_id(var6.getPrcId());
                  this.objetTable.setColumn_code(var6.getPrcImmatriculation());
                  this.objetTable.setColumn_name(var6.getPrcNomFr());
                  this.objetTable.setColumn_pr(var6.getPrcPrixRevient());
                  this.objetTable.setColumn_pv(var6.getPrcPrixVente());
                  this.lesProcessParc.add(this.objetTable);
               }
            }
         }
      }

      this.datamodelService.setWrappedData(this.lesProcessService);
      this.datamodelParc.setWrappedData(this.lesProcessParc);
   }

   public void fermerTaches() {
      this.showModalPanelGestionTaches = false;
   }

   public void supprimerTaches() throws HibernateException, NamingException {
      if (this.processTacheAchats != null) {
         this.processTacheList.remove(this.processTacheAchats);
         this.processLigneAchatsDao.delete(this.processTacheAchats);
         this.datamodelProcessTache.setWrappedData(this.processTacheList);
         this.taches = new Taches();
      }

   }

   public void saveTaches() throws HibernateException, NamingException {
      if (this.processTacheAchats.getProcesligCode() != null && !this.processTacheAchats.getProcesligCode().isEmpty()) {
         if (this.processEnteteAchats.getProcesId() == 0L) {
            this.processEnteteAchats = this.processEnteteAchatsDao.insert(this.processEnteteAchats);
            this.processEnteteAchats.setProcesUserCreat(this.usersLog.getUsrid());
            this.processEnteteAchats.setProcesDateCreat(new Date());
            this.processEnteteList.add(this.processEnteteAchats);
            this.datamodelProcessEntete.setWrappedData(this.processEnteteList);
         }

         this.processTacheAchats.setProcesligMetier("");
         String var1;
         boolean var2;
         int var3;
         if (this.lesProcessService.size() != 0) {
            var1 = "";
            var2 = true;

            for(var3 = 0; var3 < this.lesProcessService.size(); ++var3) {
               this.objetTable = (ObjetTable)this.lesProcessService.get(var3);
               if (this.objetTable.getColumn_qte() != 0) {
                  if (var2) {
                     var2 = false;
                     var1 = this.objetTable.getColumn_name() + "_" + this.objetTable.getColumn_qte() + "_" + this.objetTable.getColumn_pr() + "_" + this.objetTable.getColumn_pv();
                  } else {
                     var1 = var1 + ":" + this.objetTable.getColumn_name() + "_" + this.objetTable.getColumn_qte() + "_" + this.objetTable.getColumn_pr() + "_" + this.objetTable.getColumn_pv();
                  }
               }
            }

            this.processTacheAchats.setProcesligMetier(var1);
         }

         this.processTacheAchats.setProcesligMateriel("");
         if (this.lesProcessParc.size() != 0) {
            var1 = "";
            var2 = true;

            for(var3 = 0; var3 < this.lesProcessParc.size(); ++var3) {
               this.objetTable = (ObjetTable)this.lesProcessParc.get(var3);
               if (this.objetTable.isColumn_select()) {
                  if (var2) {
                     var2 = false;
                     var1 = this.objetTable.getColumn_id() + "_" + this.objetTable.getColumn_code() + "_" + this.objetTable.getColumn_name() + "_" + this.objetTable.getColumn_pr() + "_" + this.objetTable.getColumn_pv();
                  } else {
                     var1 = var1 + ":" + this.objetTable.getColumn_id() + "_" + this.objetTable.getColumn_code() + "_" + this.objetTable.getColumn_name() + "_" + this.objetTable.getColumn_pr() + "_" + this.objetTable.getColumn_pv();
                  }
               }
            }

            this.processTacheAchats.setProcesligMateriel(var1);
         }

         if (this.processTacheAchats.getProcesligId() == 0L) {
            this.processTacheAchats.setProcessEnteteAchats(this.processEnteteAchats);
            this.processTacheAchats.setProcesligType(4);
            this.processTacheAchats = this.processLigneAchatsDao.insert(this.processTacheAchats);
            this.processTacheList.add(this.processTacheAchats);
            this.datamodelProcessTache.setWrappedData(this.processTacheList);
         } else {
            this.processTacheAchats = this.processLigneAchatsDao.modif(this.processTacheAchats);
         }
      }

      this.processTacheAchats = new ProcessLigneAchats();
      this.taches = new Taches();
      this.showModalPanelGestionTaches = false;
   }

   public void rechercheProduitsFabrique() throws HibernateException, NamingException {
      this.typeProduits = 0;
      Object var1 = new ArrayList();
      this.lesProduits.clear();
      if (this.processEnteteAchats.getProcesCode() != null && !this.processEnteteAchats.getProcesCode().isEmpty()) {
         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrService().contains(":") && this.usersLog.getUsrProdServiceAch() == 1) {
            ProduitsServices var2 = new ProduitsServices();
            ProduitsServicesDao var3 = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
            new Service();
            String[] var5 = this.usersLog.getUsrService().split(":");
            Service var4 = this.serviceDao.chargerLeServiceCode(var5[0], (Session)null);
            if (var4 != null) {
               var2.setServices(var4);
               new ArrayList();
               List var6 = var3.selectProdServiceByservAchs(var2.getServices(), this.processEnteteAchats.getProcesCode(), (String)null, (String)null, (String)null, (String)null, (String)null, 0, (String)null, (Session)null);
               if (var6.size() > 0) {
                  new ProduitsServices();

                  for(int var7 = 0; var7 < var6.size(); ++var7) {
                     var2 = (ProduitsServices)var6.get(var7);
                     this.produits = var2.getProduits();
                     ((List)var1).add(this.produits);
                  }
               }
            }
         } else {
            var1 = this.produitsAchsDao.chargerTousProduitsAchatsVentes(this.processEnteteAchats.getProcesCode(), (Session)null);
         }

         if (((List)var1).size() != 0) {
            for(int var8 = 0; var8 < ((List)var1).size(); ++var8) {
               this.produits = (Produits)((List)var1).get(var8);
               this.lesProduits.add(this.produits);
            }
         }

         this.dataModelProduits.setWrappedData(this.lesProduits);
         this.produits = new Produits();
         this.produitsFabrique = new Produits();
         this.showModalPanelProduits = true;
      } else {
         this.annuleProduits();
      }

   }

   public void rechercheProduitsGenere() throws HibernateException, NamingException {
      this.typeProduits = 5;
      Object var1 = new ArrayList();
      this.lesProduits.clear();
      if (this.processGenereAchats.getProcesligCode() != null && !this.processGenereAchats.getProcesligCode().isEmpty()) {
         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrService().contains(":") && this.usersLog.getUsrProdServiceAch() == 1) {
            ProduitsServices var2 = new ProduitsServices();
            ProduitsServicesDao var3 = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
            new Service();
            String[] var5 = this.usersLog.getUsrService().split(":");
            Service var4 = this.serviceDao.chargerLeServiceCode(var5[0], (Session)null);
            if (var4 != null) {
               var2.setServices(var4);
               new ArrayList();
               List var6 = var3.selectProdServiceByservAchs(var2.getServices(), this.processIntrantAchats.getProcesligCode(), (String)null, (String)null, (String)null, (String)null, (String)null, 0, (String)null, (Session)null);
               if (var6.size() > 0) {
                  new ProduitsServices();

                  for(int var7 = 0; var7 < var6.size(); ++var7) {
                     var2 = (ProduitsServices)var6.get(var7);
                     this.produits = var2.getProduits();
                     ((List)var1).add(this.produits);
                  }
               }
            }
         } else {
            var1 = this.produitsAchsDao.chargerTousProduitsAchatsVentes(this.processGenereAchats.getProcesligCode(), (Session)null);
         }

         if (((List)var1).size() != 0) {
            for(int var8 = 0; var8 < ((List)var1).size(); ++var8) {
               this.produits = (Produits)((List)var1).get(var8);
               if (!this.produits.getProCode().equals(this.processEnteteAchats.getProcesCode())) {
                  this.lesProduits.add(this.produits);
               }
            }
         }

         this.dataModelProduits.setWrappedData(this.lesProduits);
         this.produits = new Produits();
         this.produitsGenere = new Produits();
         this.showModalPanelProduits = true;
      } else {
         this.annuleProduits();
      }

   }

   public void rechercheProduitsUtilise() throws HibernateException, NamingException {
      this.typeProduits = 1;
      Object var1 = new ArrayList();
      this.lesProduits.clear();
      if (this.processIntrantAchats.getProcesligCode() != null && !this.processIntrantAchats.getProcesligCode().isEmpty()) {
         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrService().contains(":") && this.usersLog.getUsrProdServiceAch() == 1) {
            ProduitsServices var2 = new ProduitsServices();
            ProduitsServicesDao var3 = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
            new Service();
            String[] var5 = this.usersLog.getUsrService().split(":");
            Service var4 = this.serviceDao.chargerLeServiceCode(var5[0], (Session)null);
            if (var4 != null) {
               var2.setServices(var4);
               new ArrayList();
               List var6 = var3.selectProdServiceByservAchs(var2.getServices(), this.processIntrantAchats.getProcesligCode(), (String)null, (String)null, (String)null, (String)null, (String)null, 0, (String)null, (Session)null);
               if (var6.size() > 0) {
                  new ProduitsServices();

                  for(int var7 = 0; var7 < var6.size(); ++var7) {
                     var2 = (ProduitsServices)var6.get(var7);
                     this.produits = var2.getProduits();
                     ((List)var1).add(this.produits);
                  }
               }
            }
         } else {
            var1 = this.produitsAchsDao.chargerTousProduitsAchatsVentes(this.processIntrantAchats.getProcesligCode(), (Session)null);
         }

         if (((List)var1).size() != 0) {
            for(int var8 = 0; var8 < ((List)var1).size(); ++var8) {
               this.produits = (Produits)((List)var1).get(var8);
               if (!this.produits.getProCode().equals(this.processEnteteAchats.getProcesCode())) {
                  this.lesProduits.add(this.produits);
               }
            }
         }

         this.produits = new Produits();
         this.produits.setProId(999999999L);
         this.produits.setProLibClient("EAU");
         this.produits.setProCode("EAU");
         this.lesProduits.add(this.produits);
         this.dataModelProduits.setWrappedData(this.lesProduits);
         this.produits = new Produits();
         this.produitsUtilise = new Produits();
         this.showModalPanelProduits = true;
      } else {
         this.annuleProduits();
      }

   }

   public void rechercheSousProduits() throws HibernateException, NamingException {
      this.typeProduits = 2;
      Object var1 = new ArrayList();
      this.lesProduits.clear();
      if (this.processSousProduitAchats.getProcesligCode() != null && !this.processSousProduitAchats.getProcesligCode().isEmpty()) {
         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrService().contains(":") && this.usersLog.getUsrProdServiceAch() == 1) {
            ProduitsServices var2 = new ProduitsServices();
            ProduitsServicesDao var3 = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
            new Service();
            String[] var5 = this.usersLog.getUsrService().split(":");
            Service var4 = this.serviceDao.chargerLeServiceCode(var5[0], (Session)null);
            if (var4 != null) {
               var2.setServices(var4);
               new ArrayList();
               List var6 = var3.selectProdServiceByservAchs(var2.getServices(), this.processSousProduitAchats.getProcesligCode(), (String)null, (String)null, (String)null, (String)null, (String)null, 0, (String)null, (Session)null);
               if (var6.size() > 0) {
                  new ProduitsServices();

                  for(int var7 = 0; var7 < var6.size(); ++var7) {
                     var2 = (ProduitsServices)var6.get(var7);
                     this.produits = var2.getProduits();
                     ((List)var1).add(this.produits);
                  }
               }
            }
         } else {
            var1 = this.produitsAchsDao.chargerTousProduitsAchatsVentes(this.processSousProduitAchats.getProcesligCode(), (Session)null);
         }

         if (((List)var1).size() != 0) {
            for(int var8 = 0; var8 < ((List)var1).size(); ++var8) {
               this.produits = (Produits)((List)var1).get(var8);
               if (!this.produits.getProCode().equals(this.processEnteteAchats.getProcesCode())) {
                  this.lesProduits.add(this.produits);
               }
            }
         }

         this.dataModelProduits.setWrappedData(this.lesProduits);
         this.produits = new Produits();
         this.produitsSousProduit = new Produits();
         this.showModalPanelProduits = true;
      } else {
         this.annuleProduits();
      }

   }

   public void rechercheDechets() throws HibernateException, NamingException {
      this.typeProduits = 3;
      Object var1 = new ArrayList();
      this.lesProduits.clear();
      if (this.processDechetAchats.getProcesligCode() != null && !this.processDechetAchats.getProcesligCode().isEmpty()) {
         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrService().contains(":") && this.usersLog.getUsrProdServiceAch() == 1) {
            ProduitsServices var2 = new ProduitsServices();
            ProduitsServicesDao var3 = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
            new Service();
            String[] var5 = this.usersLog.getUsrService().split(":");
            Service var4 = this.serviceDao.chargerLeServiceCode(var5[0], (Session)null);
            if (var4 != null) {
               var2.setServices(var4);
               new ArrayList();
               List var6 = var3.selectProdServiceByservAchs(var2.getServices(), this.processDechetAchats.getProcesligCode(), (String)null, (String)null, (String)null, (String)null, (String)null, 0, (String)null, (Session)null);
               if (var6.size() > 0) {
                  new ProduitsServices();

                  for(int var7 = 0; var7 < var6.size(); ++var7) {
                     var2 = (ProduitsServices)var6.get(var7);
                     this.produits = var2.getProduits();
                     ((List)var1).add(this.produits);
                  }
               }
            }
         } else {
            var1 = this.produitsAchsDao.chargerTousProduitsAchatsVentes(this.processDechetAchats.getProcesligCode(), (Session)null);
         }

         if (((List)var1).size() != 0) {
            for(int var8 = 0; var8 < ((List)var1).size(); ++var8) {
               this.produits = (Produits)((List)var1).get(var8);
               if (!this.produits.getProCode().equals(this.processEnteteAchats.getProcesCode())) {
                  this.lesProduits.add(this.produits);
               }
            }
         }

         this.dataModelProduits.setWrappedData(this.lesProduits);
         this.produits = new Produits();
         this.produitsDechet = new Produits();
         this.showModalPanelProduits = true;
      } else {
         this.annuleProduits();
      }

   }

   public void rechercheProduitsInterchangeable() throws HibernateException, NamingException {
      this.typeProduits = 4;
      Object var1 = new ArrayList();
      this.lesProduits.clear();
      if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrService().contains(":") && this.usersLog.getUsrProdServiceAch() == 1) {
         ProduitsServices var2 = new ProduitsServices();
         ProduitsServicesDao var3 = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
         new Service();
         String[] var5 = this.usersLog.getUsrService().split(":");
         Service var4 = this.serviceDao.chargerLeServiceCode(var5[0], (Session)null);
         if (var4 != null) {
            var2.setServices(var4);
            new ArrayList();
            List var6 = var3.selectProdServiceByservAchs(var2.getServices(), this.processIntrantAchats.getProcesligCode(), (String)null, (String)null, (String)null, (String)null, (String)null, 0, (String)null, (Session)null);
            if (var6.size() > 0) {
               new ProduitsServices();

               for(int var7 = 0; var7 < var6.size(); ++var7) {
                  var2 = (ProduitsServices)var6.get(var7);
                  this.produits = var2.getProduits();
                  ((List)var1).add(this.produits);
               }
            }
         }
      } else {
         var1 = this.produitsAchsDao.chargerTousProduitsAchatsVentes(this.processIntrantAchats.getProcesligCode(), (Session)null);
      }

      if (((List)var1).size() != 0) {
         for(int var8 = 0; var8 < ((List)var1).size(); ++var8) {
            this.produits = (Produits)((List)var1).get(var8);
            if (!this.produits.getProCode().equals(this.processEnteteAchats.getProcesCode())) {
               this.lesProduits.add(this.produits);
            }
         }
      }

      this.dataModelProduits.setWrappedData(this.lesProduits);
      this.produits = new Produits();
      this.produitsUtilise = new Produits();
      this.showModalPanelProduits = true;
   }

   public void selectionProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.dataModelProduits.isRowAvailable()) {
         this.produits = (Produits)this.dataModelProduits.getRowData();
      }

   }

   public void selectionProduitsInterchangeable() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelProduitInterchangeable.isRowAvailable()) {
         this.produits = (Produits)this.datamodelProduitInterchangeable.getRowData();
      }

   }

   public void annuleProduits() {
      this.produits = null;
      if (this.typeProduits == 0) {
         this.produitsFabrique = new Produits();
         this.produitsDepot = new ProduitsDepot();
         this.processEnteteAchats.setProcesCode("");
         this.processEnteteAchats.setProcesLibClient("");
         this.processEnteteAchats.setProcesLibTech("");
         this.processEnteteAchats.setProcesUnite("");
         this.processEnteteAchats.setProcesDepot("");
         this.mesProduitsDepotsItems.clear();
         this.mesConditionnementsProduits.clear();
         this.mesUnitesProduits.clear();
      } else if (this.typeProduits == 1) {
         this.produitsUtilise = new Produits();
         this.produitsDepot = new ProduitsDepot();
         this.processIntrantAchats.setProcesligCode("");
         this.processIntrantAchats.setProcesligLibClient("");
         this.processIntrantAchats.setProcesligLibTech("");
         this.mesProduitsDepotsIntrantsItems.clear();
      } else if (this.typeProduits == 2) {
         this.produitsSousProduit = new Produits();
         this.produitsDepot = new ProduitsDepot();
         this.processSousProduitAchats.setProcesligCode("");
         this.processSousProduitAchats.setProcesligLibClient("");
         this.processSousProduitAchats.setProcesligLibTech("");
         this.mesProduitsDepotsIntrantsItems.clear();
      } else if (this.typeProduits == 3) {
         this.produitsDechet = new Produits();
         this.produitsDepot = new ProduitsDepot();
         this.processDechetAchats.setProcesligCode("");
         this.processDechetAchats.setProcesligLibClient("");
         this.processDechetAchats.setProcesligLibTech("");
         this.mesProduitsDepotsIntrantsItems.clear();
      } else if (this.typeProduits != 4 && this.typeProduits == 5) {
         this.produitsGenere = new Produits();
         this.produitsDepot = new ProduitsDepot();
         this.processGenereAchats.setProcesligCode("");
         this.processGenereAchats.setProcesligLibClient("");
         this.processGenereAchats.setProcesligLibTech("");
         this.mesProduitsDepotsGenereItems.clear();
      }

      this.showModalPanelProduits = false;
      this.showModalPanelGestionTaches = false;
      this.showModalPanelTaches = false;
   }

   public void calculeProduits() throws HibernateException, NamingException {
      Session var1;
      if (this.produits != null && this.typeProduits == 0) {
         this.produitsFabrique = this.produits;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         this.processEnteteAchats.setProcesCode(this.produitsFabrique.getProCode());
         this.processEnteteAchats.setProcesLibClient(this.produitsFabrique.getProLibClient());
         this.processEnteteAchats.setProcesLibTech(this.produitsFabrique.getProLibTech());
         this.processEnteteAchats.setProcesStock(this.produitsFabrique.getProStock());
         this.mefConditionnementDepot(this.produitsFabrique, var1);
         if (this.produitsDepot == null) {
            this.produitsDepot = new ProduitsDepot();
            this.mesUnitesProduits.clear();
            this.processEnteteAchats.setProcesUnite("");
         } else {
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.processEnteteAchats.setProcesUnite(this.produitsDepot.getProdepUnite());
               this.processEnteteAchats.setProcesEchelle(this.produitsDepot.getProdepEchelle());
            } else {
               this.processEnteteAchats.setProcesUnite("");
               this.processEnteteAchats.setProcesEchelle(0);
            }

            this.processEnteteAchats.setProcesCondition("");
            if (this.mesConditionnementsProduits.size() != 0) {
               this.processEnteteAchats.setProcesCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            }
         }

         this.utilInitHibernate.closeSession();
      } else if (this.produits != null && this.typeProduits == 1) {
         this.produitsUtilise = this.produits;
         if (this.processIntrantAchats == null) {
            this.processIntrantAchats = new ProcessLigneAchats();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         this.processIntrantAchats.setProcesligCode(this.produitsUtilise.getProCode());
         this.processIntrantAchats.setProcesligLibClient(this.produitsUtilise.getProLibClient());
         this.processIntrantAchats.setProcesligLibTech(this.produitsUtilise.getProLibTech());
         this.mefConditionnementDepot(this.produitsUtilise, var1);
         if (this.produitsDepot != null) {
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.processIntrantAchats.setProcesligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.processIntrantAchats.setProcesligUnite("");
            }
         } else {
            this.produitsDepot = new ProduitsDepot();
            this.processIntrantAchats.setProcesligUnite("");
         }

         this.utilInitHibernate.closeSession();
      } else if (this.produits != null && this.typeProduits == 2) {
         this.produitsSousProduit = this.produits;
         if (this.processSousProduitAchats == null) {
            this.processSousProduitAchats = new ProcessLigneAchats();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         this.processSousProduitAchats.setProcesligCode(this.produitsSousProduit.getProCode());
         this.processSousProduitAchats.setProcesligLibClient(this.produitsSousProduit.getProLibClient());
         this.processSousProduitAchats.setProcesligLibTech(this.produitsSousProduit.getProLibTech());
         this.mefConditionnementDepot(this.produitsSousProduit, var1);
         if (this.produitsDepot != null) {
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.processSousProduitAchats.setProcesligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.processSousProduitAchats.setProcesligUnite("");
            }
         } else {
            this.produitsDepot = new ProduitsDepot();
            this.processSousProduitAchats.setProcesligUnite("");
         }

         this.utilInitHibernate.closeSession();
      } else if (this.produits != null && this.typeProduits == 3) {
         this.produitsDechet = this.produits;
         if (this.processDechetAchats == null) {
            this.processDechetAchats = new ProcessLigneAchats();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         this.processDechetAchats.setProcesligCode(this.produitsDechet.getProCode());
         this.processDechetAchats.setProcesligLibClient(this.produitsDechet.getProLibClient());
         this.processDechetAchats.setProcesligLibTech(this.produitsDechet.getProLibTech());
         this.mefConditionnementDepot(this.produitsDechet, var1);
         if (this.produitsDepot != null) {
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.processDechetAchats.setProcesligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.processDechetAchats.setProcesligUnite("");
            }
         } else {
            this.produitsDepot = new ProduitsDepot();
            this.processDechetAchats.setProcesligUnite("");
         }

         this.utilInitHibernate.closeSession();
      } else if (this.produits != null && this.typeProduits == 4) {
         this.typeProduits = 1;
         this.produitInterchangeableList.add(this.produits);
         this.datamodelProduitInterchangeable.setWrappedData(this.produitInterchangeableList);
      } else if (this.produits != null && this.typeProduits == 5) {
         this.produitsGenere = this.produits;
         if (this.processGenereAchats == null) {
            this.processGenereAchats = new ProcessLigneAchats();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
         this.processGenereAchats.setProcesligCode(this.produitsGenere.getProCode());
         this.processGenereAchats.setProcesligLibClient(this.produitsGenere.getProLibClient());
         this.processGenereAchats.setProcesligLibTech(this.produitsGenere.getProLibTech());
         this.mefConditionnementDepot(this.produitsGenere, var1);
         if (this.produitsDepot != null) {
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.processGenereAchats.setProcesligUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.processGenereAchats.setProcesligUnite("");
            }
         } else {
            this.produitsDepot = new ProduitsDepot();
            this.processGenereAchats.setProcesligUnite("");
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.annuleProduits();
      }

      this.showModalPanelProduits = false;
      this.showModalPanelGestionTaches = false;
      this.showModalPanelTaches = false;
   }

   public List chargerConditionnementProduit(Session var1) {
      this.mesConditionnementsProduits.clear();
      this.mesConditionnementsProduits = this.calculStock.calculConditionnementStock((List)null, this.produits, this.produitsDepot, var1);
      if (this.mesConditionnementsProduits.size() != 0) {
         this.var_aff_condit = true;
      } else {
         this.var_aff_condit = false;
      }

      return this.mesConditionnementsProduits;
   }

   public List chargerUniteProduit(Session var1) {
      this.mesUnitesProduits.clear();
      if (this.produits != null && this.produitsDepot != null && this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
         this.mesUnitesProduits.add(new SelectItem(this.produitsDepot.getProdepUnite()));
      }

      return this.mesUnitesProduits;
   }

   public void calculeProduitsMultiple() {
      if (this.lesProduits.size() != 0) {
         for(int var1 = 0; var1 < this.lesProduits.size(); ++var1) {
            this.produits = (Produits)this.lesProduits.get(var1);
            if (this.produits.isVar_select()) {
               boolean var2 = false;
               if (this.produitInterchangeableList.size() != 0) {
                  for(int var3 = 0; var3 < this.produitInterchangeableList.size(); ++var3) {
                     if (this.produits.getProCode().equals(((Produits)this.produitInterchangeableList.get(var3)).getProCode())) {
                        var2 = true;
                        break;
                     }
                  }
               }

               if (!var2) {
                  this.produitInterchangeableList.add(this.produits);
               }
            }

            this.datamodelProduitInterchangeable.setWrappedData(this.produitInterchangeableList);
         }
      }

      this.showModalPanelProduits = false;
      this.showModalPanelGestionTaches = false;
      this.showModalPanelTaches = false;
   }

   public void mefConditionnementDepot(Produits var1, Session var2) throws HibernateException, NamingException {
      if (this.typeProduits == 0) {
         this.mesProduitsDepotsItems.clear();
         this.mesUnitesProduits = this.chargerUniteProduit(var2);
         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var2);
      } else if (this.typeProduits == 1 || this.typeProduits == 2 || this.typeProduits == 3 || this.typeProduits == 5) {
         this.mesProduitsDepotsGenereItems.clear();
         this.mesProduitsDepotsIntrantsItems.clear();
         this.mesProduitsDepotsSousProduitItems.clear();
         this.mesProduitsDepotsDechetItems.clear();
      }

      this.listeProduitDepot.clear();
      if (var1 != null && var1.getProId() >= 1L && var1.getProId() <= 999999998L) {
         if (var1.getProId() != 0L && this.typeProduits == 0) {
            this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(var1, 341, var2);
         } else if (var1.getProId() != 0L && (this.typeProduits == 1 || this.typeProduits == 2 || this.typeProduits == 3 || this.typeProduits == 5)) {
            this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(var1, 342, var2);
         }

         int var4;
         if (this.listeProduitDepot.size() == 0) {
            List var3;
            if (this.typeProduits == 0) {
               new ArrayList();
               var3 = this.depotAchatsDao.selectActifDepot(34, var2);
               if (var3.size() != 0) {
                  this.depotAchats = new DepotAchats();

                  for(var4 = 0; var4 < var3.size(); ++var4) {
                     this.depotAchats = (DepotAchats)var3.get(var4);
                     if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
                        if (this.depotAchats.getDpoService() != null && !this.depotAchats.getDpoService().isEmpty()) {
                           if (this.controlePresenceDepot()) {
                              this.produitsDepot = new ProduitsDepot();
                              this.produitsDepot.setDepot(this.depotAchats);
                              this.listeProduitDepot.add(this.produitsDepot);
                           }
                        } else if (this.depotAchats.getDpoService() == null || this.depotAchats.getDpoService().isEmpty()) {
                           this.produitsDepot = new ProduitsDepot();
                           this.produitsDepot.setDepot(this.depotAchats);
                           this.listeProduitDepot.add(this.produitsDepot);
                        }
                     } else if (this.usersLog.getUsrProdServiceAch() == 0 && this.usersLog.getUsrDepotSel() != 1) {
                        this.produitsDepot = new ProduitsDepot();
                        this.produitsDepot.setDepot(this.depotAchats);
                        this.listeProduitDepot.add(this.produitsDepot);
                     }
                  }
               }
            } else {
               new ArrayList();
               var3 = this.depotAchatsDao.selectActifDepot(34, var2);
               if (var3.size() != 0) {
                  this.depotAchats = new DepotAchats();

                  for(var4 = 0; var4 < var3.size(); ++var4) {
                     this.depotAchats = (DepotAchats)var3.get(var4);
                     if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
                        if (this.depotAchats.getDpoService() != null && !this.depotAchats.getDpoService().isEmpty()) {
                           if (this.controlePresenceDepot()) {
                              this.produitsDepot = new ProduitsDepot();
                              this.produitsDepot.setDepot(this.depotAchats);
                              this.listeProduitDepot.add(this.produitsDepot);
                           }
                        } else if (this.depotAchats.getDpoService() == null || this.depotAchats.getDpoService().isEmpty()) {
                           this.produitsDepot = new ProduitsDepot();
                           this.produitsDepot.setDepot(this.depotAchats);
                           this.listeProduitDepot.add(this.produitsDepot);
                        }
                     } else if (this.usersLog.getUsrProdServiceAch() == 0 && this.usersLog.getUsrDepotSel() != 1) {
                        this.produitsDepot = new ProduitsDepot();
                        this.produitsDepot.setDepot(this.depotAchats);
                        this.listeProduitDepot.add(this.produitsDepot);
                     }
                  }
               }
            }
         }

         if (this.listeProduitDepot.size() != 0) {
            new ProduitsDepot();

            for(var4 = 0; var4 < this.listeProduitDepot.size(); ++var4) {
               ProduitsDepot var5 = (ProduitsDepot)this.listeProduitDepot.get(var4);
               if (this.typeProduits == 0) {
                  if (var5.getProdepCasier() != null && !var5.getProdepCasier().isEmpty()) {
                     this.mesProduitsDepotsItems.add(new SelectItem(var5.getDepot().getDpoCode() + ":" + var5.getProdepCasier()));
                  } else {
                     this.mesProduitsDepotsItems.add(new SelectItem(var5.getDepot().getDpoCode()));
                  }
               } else if (this.typeProduits == 1) {
                  if (var5.getProdepCasier() != null && !var5.getProdepCasier().isEmpty()) {
                     this.mesProduitsDepotsIntrantsItems.add(new SelectItem(var5.getDepot().getDpoCode() + ":" + var5.getProdepCasier()));
                  } else {
                     this.mesProduitsDepotsIntrantsItems.add(new SelectItem(var5.getDepot().getDpoCode()));
                  }
               } else if (this.typeProduits == 2) {
                  if (var5.getProdepCasier() != null && !var5.getProdepCasier().isEmpty()) {
                     this.mesProduitsDepotsSousProduitItems.add(new SelectItem(var5.getDepot().getDpoCode() + ":" + var5.getProdepCasier()));
                  } else {
                     this.mesProduitsDepotsSousProduitItems.add(new SelectItem(var5.getDepot().getDpoCode()));
                  }
               } else if (this.typeProduits == 3) {
                  if (var5.getProdepCasier() != null && !var5.getProdepCasier().isEmpty()) {
                     this.mesProduitsDepotsDechetItems.add(new SelectItem(var5.getDepot().getDpoCode() + ":" + var5.getProdepCasier()));
                  } else {
                     this.mesProduitsDepotsDechetItems.add(new SelectItem(var5.getDepot().getDpoCode()));
                  }
               } else if (this.typeProduits == 5) {
                  if (var5.getProdepCasier() != null && !var5.getProdepCasier().isEmpty()) {
                     this.mesProduitsDepotsGenereItems.add(new SelectItem(var5.getDepot().getDpoCode() + ":" + var5.getProdepCasier()));
                  } else {
                     this.mesProduitsDepotsGenereItems.add(new SelectItem(var5.getDepot().getDpoCode()));
                  }
               }
            }
         }
      }

   }

   public void rechercheTaches() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.processTacheAchats.getProcesligCode() != null && !this.processTacheAchats.getProcesligCode().isEmpty()) {
         new ArrayList();
         List var1 = this.tachesDao.selectTachesActif(this.processTacheAchats.getProcesligCode(), (Session)null);
         this.datamodelTaches.setWrappedData(var1);
         this.taches = new Taches();
         this.showModalPanelTaches = true;
      } else {
         this.annuleTache();
      }

   }

   public void selectionTache() throws JDOMException, IOException {
      if (this.datamodelTaches.isRowAvailable()) {
         this.taches = (Taches)this.datamodelTaches.getRowData();
      }

   }

   public void annuleTache() {
      this.taches = new Taches();
      this.processTacheAchats.setProcesligCode("");
      this.processTacheAchats.setProcesligLibClient("");
      this.processTacheAchats.setProcesligPrht(0.0D);
      this.processTacheAchats.setProcesligPvht(0.0D);
      this.processTacheAchats.setProcesligJj(0);
      this.processTacheAchats.setProcesligHh(0);
      this.processTacheAchats.setProcesligMm(0);
      this.processTacheAchats.setProcesligSs(0);
      this.showModalPanelTaches = false;
   }

   public void calculeTache() throws JDOMException, IOException {
      this.processTacheAchats.setProcesligCode(this.taches.getTacCode());
      this.processTacheAchats.setProcesligLibClient(this.taches.getTacNomFr());
      this.processTacheAchats.setProcesligPrht((double)this.taches.getTacValPr());
      this.processTacheAchats.setProcesligPvht((double)this.taches.getTacValPv());
      this.processTacheAchats.setProcesligJj(this.taches.getTacValJj());
      this.processTacheAchats.setProcesligHh(this.taches.getTacValHh());
      this.processTacheAchats.setProcesligMm(this.taches.getTacValMm());
      this.processTacheAchats.setProcesligSs(this.taches.getTacValSs());
      this.showModalPanelTaches = false;
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

   public void imprimer() throws JRException, IOException, SQLException, ClassNotFoundException, Exception {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      this.utilPrint.setFormat(this.format);
      this.utilPrint.setNbDecQte(this.optionStocks.getNbDecQteProd());
      this.utilPrint.setTiersSelectionne((Tiers)null);
      JRBeanCollectionDataSource var1 = null;
      this.utilPrint.setRapport("StructureProcess");
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator);
      this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "sous_rapport" + File.separator);
      this.utilPrint.setEntete("Structure du process " + this.processEnteteAchats.getProcesCode());
      new ArrayList();
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
      List var2 = this.processLigneAchatsDao.chargerDetailProcess(this.processEnteteAchats, var3);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
         }
      }

      this.utilInitHibernate.closeSession();
      var1 = new JRBeanCollectionDataSource(var2);
      this.utilPrint.setjRBeanCollectionDataSource(var1);
      this.utilPrint.imprimeRapport();
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public boolean isShowModalPanelProcess() {
      return this.showModalPanelProcess;
   }

   public void setShowModalPanelProcess(boolean var1) {
      this.showModalPanelProcess = var1;
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

   public DataModel getDatamodelProcessEntete() {
      return this.datamodelProcessEntete;
   }

   public void setDatamodelProcessEntete(DataModel var1) {
      this.datamodelProcessEntete = var1;
   }

   public DataModel getDatamodelProcessIntrant() {
      return this.datamodelProcessIntrant;
   }

   public void setDatamodelProcessIntrant(DataModel var1) {
      this.datamodelProcessIntrant = var1;
   }

   public ProcessEnteteAchats getProcessEnteteAchats() {
      return this.processEnteteAchats;
   }

   public void setProcessEnteteAchats(ProcessEnteteAchats var1) {
      this.processEnteteAchats = var1;
   }

   public List getMesProduitsDepotsItems() {
      return this.mesProduitsDepotsItems;
   }

   public void setMesProduitsDepotsItems(List var1) {
      this.mesProduitsDepotsItems = var1;
   }

   public List getMesUnitesProduits() {
      return this.mesUnitesProduits;
   }

   public void setMesUnitesProduits(List var1) {
      this.mesUnitesProduits = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public DataModel getDataModelProduits() {
      return this.dataModelProduits;
   }

   public void setDataModelProduits(DataModel var1) {
      this.dataModelProduits = var1;
   }

   public boolean isShowModalPanelProduits() {
      return this.showModalPanelProduits;
   }

   public void setShowModalPanelProduits(boolean var1) {
      this.showModalPanelProduits = var1;
   }

   public Produits getProduitsFabrique() {
      return this.produitsFabrique;
   }

   public void setProduitsFabrique(Produits var1) {
      this.produitsFabrique = var1;
   }

   public DataModel getDatamodelProcessDechet() {
      return this.datamodelProcessDechet;
   }

   public void setDatamodelProcessDechet(DataModel var1) {
      this.datamodelProcessDechet = var1;
   }

   public DataModel getDatamodelProcessSousProduit() {
      return this.datamodelProcessSousProduit;
   }

   public void setDatamodelProcessSousProduit(DataModel var1) {
      this.datamodelProcessSousProduit = var1;
   }

   public ProcessLigneAchats getProcessDechetAchats() {
      return this.processDechetAchats;
   }

   public void setProcessDechetAchats(ProcessLigneAchats var1) {
      this.processDechetAchats = var1;
   }

   public ProcessLigneAchats getProcessIntrantAchats() {
      return this.processIntrantAchats;
   }

   public void setProcessIntrantAchats(ProcessLigneAchats var1) {
      this.processIntrantAchats = var1;
   }

   public List getMesProduitsDepotsIntrantsItems() {
      return this.mesProduitsDepotsIntrantsItems;
   }

   public void setMesProduitsDepotsIntrantsItems(List var1) {
      this.mesProduitsDepotsIntrantsItems = var1;
   }

   public ProcessLigneAchats getProcessSousProduitAchats() {
      return this.processSousProduitAchats;
   }

   public void setProcessSousProduitAchats(ProcessLigneAchats var1) {
      this.processSousProduitAchats = var1;
   }

   public Produits getProduitsDechet() {
      return this.produitsDechet;
   }

   public void setProduitsDechet(Produits var1) {
      this.produitsDechet = var1;
   }

   public Produits getProduitsSousProduit() {
      return this.produitsSousProduit;
   }

   public void setProduitsSousProduit(Produits var1) {
      this.produitsSousProduit = var1;
   }

   public DataModel getDatamodelProcessTache() {
      return this.datamodelProcessTache;
   }

   public void setDatamodelProcessTache(DataModel var1) {
      this.datamodelProcessTache = var1;
   }

   public ProcessLigneAchats getProcessTacheAchats() {
      return this.processTacheAchats;
   }

   public void setProcessTacheAchats(ProcessLigneAchats var1) {
      this.processTacheAchats = var1;
   }

   public DataModel getDatamodelTaches() {
      return this.datamodelTaches;
   }

   public void setDatamodelTaches(DataModel var1) {
      this.datamodelTaches = var1;
   }

   public boolean isShowModalPanelTaches() {
      return this.showModalPanelTaches;
   }

   public void setShowModalPanelTaches(boolean var1) {
      this.showModalPanelTaches = var1;
   }

   public Taches getTaches() {
      return this.taches;
   }

   public void setTaches(Taches var1) {
      this.taches = var1;
   }

   public boolean isShowModalPanelGestionTaches() {
      return this.showModalPanelGestionTaches;
   }

   public void setShowModalPanelGestionTaches(boolean var1) {
      this.showModalPanelGestionTaches = var1;
   }

   public DataModel getDatamodelService() {
      return this.datamodelService;
   }

   public void setDatamodelService(DataModel var1) {
      this.datamodelService = var1;
   }

   public DataModel getDatamodelParc() {
      return this.datamodelParc;
   }

   public void setDatamodelParc(DataModel var1) {
      this.datamodelParc = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getMesProduitsDepotsDechetItems() {
      return this.mesProduitsDepotsDechetItems;
   }

   public void setMesProduitsDepotsDechetItems(List var1) {
      this.mesProduitsDepotsDechetItems = var1;
   }

   public List getMesProduitsDepotsSousProduitItems() {
      return this.mesProduitsDepotsSousProduitItems;
   }

   public void setMesProduitsDepotsSousProduitItems(List var1) {
      this.mesProduitsDepotsSousProduitItems = var1;
   }

   public boolean isShowModalPanelProduitInterchangeable() {
      return this.showModalPanelProduitInterchangeable;
   }

   public void setShowModalPanelProduitInterchangeable(boolean var1) {
      this.showModalPanelProduitInterchangeable = var1;
   }

   public DataModel getDatamodelProduitInterchangeable() {
      return this.datamodelProduitInterchangeable;
   }

   public void setDatamodelProduitInterchangeable(DataModel var1) {
      this.datamodelProduitInterchangeable = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public List getMesAteliersItems() {
      return this.mesAteliersItems;
   }

   public void setMesAteliersItems(List var1) {
      this.mesAteliersItems = var1;
   }

   public List getMesLignesItems() {
      return this.mesLignesItems;
   }

   public void setMesLignesItems(List var1) {
      this.mesLignesItems = var1;
   }

   public List getMesSitesItems() {
      return this.mesSitesItems;
   }

   public void setMesSitesItems(List var1) {
      this.mesSitesItems = var1;
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

   public String getVar_tarif1() {
      return this.var_tarif1;
   }

   public void setVar_tarif1(String var1) {
      this.var_tarif1 = var1;
   }

   public List getProcessEnteteList() {
      return this.processEnteteList;
   }

   public void setProcessEnteteList(List var1) {
      this.processEnteteList = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public OptionStocks getOptionStocks() {
      return this.optionStocks;
   }

   public void setOptionStocks(OptionStocks var1) {
      this.optionStocks = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public List getMesServicesRecItems() {
      return this.mesServicesRecItems;
   }

   public void setMesServicesRecItems(List var1) {
      this.mesServicesRecItems = var1;
   }

   public String getFiltreService() {
      return this.filtreService;
   }

   public void setFiltreService(String var1) {
      this.filtreService = var1;
   }

   public DataModel getDataModelUsersHabilites() {
      return this.dataModelUsersHabilites;
   }

   public void setDataModelUsersHabilites(DataModel var1) {
      this.dataModelUsersHabilites = var1;
   }

   public boolean isCreationLot() {
      return this.creationLot;
   }

   public void setCreationLot(boolean var1) {
      this.creationLot = var1;
   }

   public List getMesConditionnementsProduits() {
      return this.mesConditionnementsProduits;
   }

   public void setMesConditionnementsProduits(List var1) {
      this.mesConditionnementsProduits = var1;
   }

   public boolean isVar_aff_condit() {
      return this.var_aff_condit;
   }

   public void setVar_aff_condit(boolean var1) {
      this.var_aff_condit = var1;
   }

   public boolean isAfficheSuffixe() {
      return this.afficheSuffixe;
   }

   public void setAfficheSuffixe(boolean var1) {
      this.afficheSuffixe = var1;
   }

   public List getMesSuffixeProductionItems() {
      return this.mesSuffixeProductionItems;
   }

   public void setMesSuffixeProductionItems(List var1) {
      this.mesSuffixeProductionItems = var1;
   }

   public DataModel getDatamodelProcessGenere() {
      return this.datamodelProcessGenere;
   }

   public void setDatamodelProcessGenere(DataModel var1) {
      this.datamodelProcessGenere = var1;
   }

   public List getMesProduitsDepotsGenereItems() {
      return this.mesProduitsDepotsGenereItems;
   }

   public void setMesProduitsDepotsGenereItems(List var1) {
      this.mesProduitsDepotsGenereItems = var1;
   }

   public ProcessLigneAchats getProcessGenereAchats() {
      return this.processGenereAchats;
   }

   public void setProcessGenereAchats(ProcessLigneAchats var1) {
      this.processGenereAchats = var1;
   }
}
