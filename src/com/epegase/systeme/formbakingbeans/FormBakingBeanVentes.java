package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormExercicesVentes;
import com.epegase.forms.commun.FormAffaires;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.ventes.FormAvoirVentes;
import com.epegase.forms.ventes.FormBesoinVentes;
import com.epegase.forms.ventes.FormBonEncaissementVente;
import com.epegase.forms.ventes.FormCampagneVentes;
import com.epegase.forms.ventes.FormChargementVentes;
import com.epegase.forms.ventes.FormCommandeVentes;
import com.epegase.forms.ventes.FormCommissionsVentes;
import com.epegase.forms.ventes.FormContratVentes;
import com.epegase.forms.ventes.FormDevisVentes;
import com.epegase.forms.ventes.FormFactureInterneVentes;
import com.epegase.forms.ventes.FormFactureVentes;
import com.epegase.forms.ventes.FormImpressionVentes;
import com.epegase.forms.ventes.FormLivraisonVentes;
import com.epegase.forms.ventes.FormNoteDebitVentes;
import com.epegase.forms.ventes.FormObjectifVentes;
import com.epegase.forms.ventes.FormProduitsVtes;
import com.epegase.forms.ventes.FormRetourVentes;
import com.epegase.forms.ventes.FormSimulContratVentes;
import com.epegase.forms.ventes.FormTicketVentes;
import com.epegase.forms.ventes.FormTransfertVentes;
import com.epegase.systeme.classe.CampagneEnteteVentes;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.UsersFavoris;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.CampagneEnteteVentesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.CouleurDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.DouanesPositionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.MarquesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.UsersFavorisDao;
import com.epegase.systeme.menu.MenudroitVentesCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LectureIncoterm;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureNatureVentes;
import com.epegase.systeme.xml.LectureReglementClient;
import com.epegase.systeme.xml.LectureSourcesTiers;
import com.epegase.systeme.xml.LireLesoptionsParcs;
import com.epegase.systeme.xml.LireLesoptionsTiers;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionConfigListe;
import com.epegase.systeme.xml.OptionParcs;
import com.epegase.systeme.xml.OptionTiers;
import com.epegase.systeme.xml.OptionVentes;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.xml.sax.SAXException;

public class FormBakingBeanVentes implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private MenudroitVentesCtrl menudroitVentesCtrl;
   private ObjetLigneMenu menuvente;
   private ObjetLigneMenu menuventeMemo = new ObjetLigneMenu();
   private LectureModulesOnglets lesOnglets;
   private int nature;
   private OptionVentes optionsVentes;
   private OptionParcs optionParcs;
   private Habilitation habilitation;
   private ExercicesVentes exoselectionne = new ExercicesVentes();
   private ExercicesVentes lastExoVentes = new ExercicesVentes();
   private ExercicesComptable lastExoCompta;
   private ExercicesAchats lastExoAchats;
   private long leIdExo;
   private int var_timbre;
   private int var_tc_type;
   private String var_tc_libelle;
   private float var_tc_taux;
   private boolean var_marque_util = false;
   private List mesEtatsItems = new ArrayList();
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
   private boolean poidsAff;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private String messageAlerte;
   private boolean verifBareme;
   private long var_memo_id_master;
   private FormExercicesVentes formExercicesVentes;
   private FormProduitsVtes formProduitsVtes;
   private FormSimulContratVentes formSimulContratVentes;
   private FormDevisVentes formDevisVentes;
   private FormCommandeVentes formCommandeVentes;
   private FormLivraisonVentes formLivraisonVentes;
   private FormRetourVentes formRetourVentes;
   private FormFactureVentes formFactureVentes;
   private FormAvoirVentes formAvoirVentes;
   private FormNoteDebitVentes formNoteDebitVentes;
   private FormBonEncaissementVente formBonEncaissementVente;
   private FormImpressionVentes formImpressionVentes;
   private FormTransfertVentes formTransfertVentes;
   private FormChargementVentes formChargementVentes;
   private FormBesoinVentes formBesoinVentes;
   private FormCommissionsVentes formCommissionsVentes;
   private FormTicketVentes formTicketVentes;
   private FormContratVentes formContratVentes;
   private FormCampagneVentes formCampagneVentes;
   private FormObjectifVentes formObjectifVentes;
   private FormAffaires formAffaires;
   private FormFactureInterneVentes formFactureInterneVentes;
   private List mesdevisesItem;
   private List mesParcsItems;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private List listeImpressionMvtsItems;
   private List annexItems;
   private List pageGardeItems;
   private List mesIncotermesItems;
   private List lesFamilleClientsListe;
   private List mesFamilleClientsItems;
   private List lesModeReglementClientsListe;
   private List mesTypeReglements;
   private List mesSerieUserItem;
   private List mesActivitesItems;
   private List mesServicesItems;
   private List mesMarquesItems;
   private List mesCouleursItems;
   private List mesDossiersItems;
   private List mesBudgetsItems;
   private List mesFormulesItems;
   private List mesUnitesItems;
   private List mesConditionnementsItems;
   private List listCaisses;
   private List mesBanquesItems;
   private List mesFactorsItems;
   private List mesTaxesItems;
   private List mesNaturesItems;
   private List mesFamillesVentesItems;
   private List mesFamillesVentesUtilItems;
   private List mesFamillesAchatsItems;
   private List mesFamillesAchatsUtilItems;
   private List mesFamillesGlobalItems;
   private List mesDepotItems;
   private List mesDepotCodeItems;
   private List mesCompteProduitsItems;
   private List mesCompteStocksItems;
   private List mesCompteVteLocItems;
   private List mesCompteVteZItems;
   private List mesCompteVteHzItems;
   private List mesCompteCaisseItems;
   private List mesDouanesItems;
   private List mesRegionsItems;
   private List mesSecteursItems;
   private List mesPdvItems;
   private List mesSitesItems;
   private List mesDepartementsItems;
   private List mesServices2Items;
   private List mesCommerciauxItems;
   private List mesResponsablesItems;
   private List mesCreateursItems;
   private List mesClesItems;
   private List mesSourceItems;
   private String listeDepotUser;
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
   private boolean var_aff_tarif1;
   private boolean var_aff_tarif2;
   private boolean var_aff_tarif3;
   private boolean var_aff_tarif4;
   private boolean var_aff_tarif5;
   private boolean var_aff_tarif6;
   private boolean var_aff_tarif7;
   private boolean var_aff_tarif8;
   private boolean var_aff_tarif9;
   private boolean var_aff_tarif10;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;
   private FileCtrl fileCtrl;
   private ArrayList listFiles;
   private UploadItem item;
   private int uploadsAvailable = 1;
   private String numRecup;
   private String quelTransfert;

   public void InstancesDaoUtilses() throws IOException, SAXException, JDOMException, ParseException {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererExercices(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      this.leIdExo = this.exoselectionne.getExevteId();
      this.lastExoVentes = var2.recupererLastExo(var1);
      ExercicesComptableDao var3 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.lastExoCompta = var3.recupererLastExo(var1);
      ExercicesAchatsDao var4 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.lastExoAchats = var4.recupererLastExo(var1);
   }

   public void recupererLeIdExo() throws HibernateException, NamingException {
      this.recupererLeIdExo((Session)null);
   }

   public ExercicesVentes recupererLeIdExo(Session var1) throws NamingException {
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      if (this.leIdExo != 0L) {
         this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      } else {
         this.exoselectionne = var2.recupererLastExo(var1);
      }

      this.leIdExo = this.exoselectionne.getExevteId();
      return this.exoselectionne;
   }

   public List getLesExerciceVente(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesVentes = new FormExercicesVentes();
      this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesVentes.setBaseLog(this.baseLog);
      this.formExercicesVentes.setStructureLog(this.structureLog);
      this.formExercicesVentes.setUsersLog(this.usersLog);
      this.formExercicesVentes.InstancesDaoUtilses();
      return this.formExercicesVentes.recupererLesexercices(var1);
   }

   public void razMemoire() {
      this.formAffaires = null;
      this.formAvoirVentes = null;
      this.formBesoinVentes = null;
      this.formBonEncaissementVente = null;
      this.formCampagneVentes = null;
      this.formChargementVentes = null;
      this.formCommandeVentes = null;
      this.formCommissionsVentes = null;
      this.formContratVentes = null;
      this.formDevisVentes = null;
      this.formFactureVentes = null;
      this.formFactureInterneVentes = null;
      this.formImpressionVentes = null;
      this.formLivraisonVentes = null;
      this.formNoteDebitVentes = null;
      this.formObjectifVentes = null;
      this.formProduitsVtes = null;
      this.formRetourVentes = null;
      this.formSimulContratVentes = null;
      this.formTicketVentes = null;
      this.formTransfertVentes = null;
   }

   public void menuGaucheVentes(int var1) throws JDOMException, IOException {
      if (this.menudroitVentesCtrl == null) {
         this.menudroitVentesCtrl = new MenudroitVentesCtrl();
         this.menudroitVentesCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         boolean var2 = false;
         if (this.optionsVentes != null && this.optionsVentes.getAxeDossier() != null && !this.optionsVentes.getAxeDossier().isEmpty() && this.optionsVentes.getAxeDossier().equals("2")) {
            var2 = true;
         }

         if (var1 == 80200) {
            this.menudroitVentesCtrl.chargerMenudroitVentesTicketXml(this.usersLog.getGroupe(), this.structureLog.getStrid(), this.structureLog.getStrmaitrecabinet(), this.usersLog, var2);
         } else if (var1 == 80400) {
            this.menudroitVentesCtrl.chargerMenudroitVentesInterimXml(this.usersLog.getGroupe(), this.structureLog.getStrid(), this.structureLog.getStrmaitrecabinet(), this.usersLog, var2);
         } else if (var1 == 80500) {
            this.menudroitVentesCtrl.chargerMenudroitVentesCabinetXml(this.usersLog.getGroupe(), this.structureLog.getStrid(), this.structureLog.getStrmaitrecabinet(), this.usersLog, var2);
         } else if (var1 == 80600) {
            this.menudroitVentesCtrl.chargerMenudroitTransitXml(this.usersLog.getGroupe(), this.structureLog.getStrid(), this.structureLog.getStrmaitrecabinet(), this.usersLog, var2);
         } else if (var1 == 81000) {
            this.menudroitVentesCtrl.chargerMenudroitAbonnementXml(this.usersLog.getGroupe(), this.structureLog.getStrid(), this.structureLog.getStrmaitrecabinet(), this.usersLog, var2);
         } else if (var1 == 81700) {
            this.menudroitVentesCtrl.chargerMenudroitRestaurantXml(this.usersLog.getGroupe(), this.structureLog.getStrid(), this.structureLog.getStrmaitrecabinet(), this.usersLog, var2);
         } else if (var1 == 81710) {
            this.menudroitVentesCtrl.chargerMenudroitHotelerieXml(this.usersLog.getGroupe(), this.structureLog.getStrid(), this.structureLog.getStrmaitrecabinet(), this.usersLog, var2);
         } else {
            boolean var3 = false;
            if (this.optionsVentes.getModeAvoir().equals("1")) {
               var3 = true;
            }

            this.menudroitVentesCtrl.chargerMenudroitVentesXml(this.usersLog.getGroupe(), this.structureLog.getStrid(), this.structureLog.getStrmaitrecabinet(), this.usersLog, var2, var3);
         }
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("" + var1, this.usersLog.getUsrCollaboration());
   }

   public void gestionVentes() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuvente = new ObjetLigneMenu();
      if (this.menudroitVentesCtrl.getDataModelMenudroitVentesXmlList().isRowAvailable()) {
         this.menuvente = (ObjetLigneMenu)this.menudroitVentesCtrl.getDataModelMenudroitVentesXmlList().getRowData();
         if (this.menuvente.getLibelle_FR() != null && !this.menuvente.getLibelle_FR().isEmpty()) {
            this.menuventeMemo = this.menuvente;
            this.aiguillageVentes();
         }
      }

   }

   public void gestionVentesFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuvente = var1;
      this.menuventeMemo = this.menuvente;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         int var2 = Integer.parseInt(this.typeVente + "00");
         this.menuGaucheVentes(var2);
      }

      this.aiguillageVentes();
   }

   public void gestionVentesTicket() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuvente = new ObjetLigneMenu();
      if (this.menudroitVentesCtrl.getDataModelMenudroitVentesXmlList().isRowAvailable()) {
         this.menuvente = (ObjetLigneMenu)this.menudroitVentesCtrl.getDataModelMenudroitVentesXmlList().getRowData();
         if (this.menuvente.getLibelle_FR() != null && !this.menuvente.getLibelle_FR().isEmpty()) {
            this.menuventeMemo = this.menuvente;
            this.aiguillageVentesTicket();
         }
      }

   }

   public void gestionCaisseAuto() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuvente = new ObjetLigneMenu();
      this.menuvente.setCommande("80100:15");
      this.aiguillageVentesTicket();
   }

   public void gestionVentesInterim() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuvente = new ObjetLigneMenu();
      if (this.menudroitVentesCtrl.getDataModelMenudroitVentesXmlList().isRowAvailable()) {
         this.menuvente = (ObjetLigneMenu)this.menudroitVentesCtrl.getDataModelMenudroitVentesXmlList().getRowData();
         if (this.menuvente.getLibelle_FR() != null && !this.menuvente.getLibelle_FR().isEmpty()) {
            this.menuventeMemo = this.menuvente;
            this.aiguillageVentesInterim();
         }
      }

   }

   public void gestionRestaurant() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuvente = new ObjetLigneMenu();
      if (this.menudroitVentesCtrl.getDataModelMenudroitVentesXmlList().isRowAvailable()) {
         this.menuvente = (ObjetLigneMenu)this.menudroitVentesCtrl.getDataModelMenudroitVentesXmlList().getRowData();
         if (this.menuvente.getLibelle_FR() != null && !this.menuvente.getLibelle_FR().isEmpty()) {
            this.menuventeMemo = this.menuvente;
            this.aiguillageRestaurant();
         }
      }

   }

   public void gestionHotelerie() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuvente = new ObjetLigneMenu();
      if (this.menudroitVentesCtrl.getDataModelMenudroitVentesXmlList().isRowAvailable()) {
         this.menuvente = (ObjetLigneMenu)this.menudroitVentesCtrl.getDataModelMenudroitVentesXmlList().getRowData();
         if (this.menuvente.getLibelle_FR() != null && !this.menuvente.getLibelle_FR().isEmpty()) {
            this.menuventeMemo = this.menuvente;
            this.aiguillageHotelerie();
         }
      }

   }

   public void aiguillageVentes() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      if (this.lastExoVentes.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menuvente.setAdd(false);
         this.menuvente.setMaj(false);
         this.menuvente.setSup(false);
         this.menuvente.setDup(false);
         this.menuvente.setClo(false);
         this.menuvente.setTrf(false);
         this.menuvente.setImp(true);
      } else {
         this.menuvente.setAdd(this.menuventeMemo.isAdd());
         this.menuvente.setMaj(this.menuventeMemo.isMaj());
         this.menuvente.setSup(this.menuventeMemo.isSup());
         this.menuvente.setDup(this.menuventeMemo.isDup());
         this.menuvente.setClo(this.menuventeMemo.isClo());
         this.menuvente.setTrf(this.menuventeMemo.isTrf());
         this.menuvente.setImp(this.menuventeMemo.isImp());
      }

      this.razMemoire();
      if (this.menuvente.getCommande().equalsIgnoreCase("80100:00")) {
         this.nature = 600;
         this.affichePage = "/ventes/ProduitsInit.jsp";
         this.menuProduitVente();
      } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:14")) {
         this.affichePage = "/ventes/EtudePrixInit.jsp";
         this.menuEtudePrix();
      } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:18")) {
         this.affichePage = "/ventes/ObjectifInit.jsp";
         this.menuObjectif();
      } else {
         Session var1;
         String var2;
         if (this.menuvente.getCommande().equalsIgnoreCase("80100:01")) {
            this.nature = 141;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CampagneEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/CampagneInit.jsp";
                  this.menuCampagneVentes(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:02")) {
            this.nature = 20;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/BesoinInit.jsp";
                  this.menuBesoin(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:12")) {
            this.nature = 8;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SimulEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/SimulContratInit.jsp";
                  this.menuSimulContrat(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:03")) {
            this.nature = 21;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/DevisInit.jsp";
                  this.menuDevis(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:04")) {
            this.nature = 22;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/CommandeInit.jsp";
                  this.menuBcommande(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:05")) {
            this.nature = 23;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/LivraisonInit.jsp";
                  this.menuBlivraison(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:06")) {
            this.nature = 24;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/RetourInit.jsp";
                  this.menuBretour(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:07")) {
            this.nature = 25;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  if (this.typeVente == 810) {
                     this.affichePage = "/ventes/FactureAbonnementInit.jsp";
                  } else {
                     this.affichePage = "/ventes/FactureInit.jsp";
                  }

                  this.menuFacture(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:08")) {
            this.nature = 26;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/AvoirInit.jsp";
                  this.menuAvoir(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:09")) {
            this.nature = 27;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/NoteDebitInit.jsp";
                  this.menuNoteDebit(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:20")) {
            this.nature = 142;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BbactureInterneEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/FactureInterneInit.jsp";
                  this.menuFactureInterne(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:19")) {
            this.nature = 127;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/AffairesInit.jsp";
                  this.menuAffaires(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:13")) {
            this.nature = 28;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/ChargementInit.jsp";
                  this.menuChargement(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:17")) {
            this.nature = 140;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  if (this.typeVente == 805) {
                     this.affichePage = "/ventes/ContratMissionInit.jsp";
                  } else if (this.typeVente == 810) {
                     this.affichePage = "/ventes/ContratAbonnementInit.jsp";
                  } else {
                     this.affichePage = "/ventes/ContratInit.jsp";
                  }

                  this.menuContrat(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:10")) {
            this.nature = 29;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/BonEncaissementInit.jsp";
                  this.menuBonEncaissement();
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:16")) {
            this.nature = 25;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/LissageFactureInit.jsp";
                  this.menuLissageFacture(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:11")) {
            this.affichePage = "/pageenconstruction.jsp";
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:90")) {
            this.affichePage = "/ventes/ImpressionVentes.jsp";
            this.menuImpressionVentes();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:91")) {
            this.nature = 7;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommissionEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/CommissionsInit.jsp";
                  this.menuCommissionsVentes(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:98")) {
            this.affichePage = "/ventes/TransfertVentes.jsp";
            this.menuTransfertVentes();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:99")) {
            this.affichePage = "/ventes/SelectionExercicesVentes.jsp";
            this.menuSelectionExercicesVentes();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:95")) {
            this.affichePage = "/ventes/ImportationVentes.jsp";
            this.menuImportationGesCom();
         }
      }

   }

   public void aiguillageVentesTicket() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      if (this.lastExoVentes.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menuvente.setAdd(false);
         this.menuvente.setMaj(false);
         this.menuvente.setSup(false);
         this.menuvente.setDup(false);
         this.menuvente.setClo(false);
         this.menuvente.setTrf(false);
         this.menuvente.setImp(true);
      } else {
         this.menuvente.setAdd(this.menuventeMemo.isAdd());
         this.menuvente.setMaj(this.menuventeMemo.isMaj());
         this.menuvente.setSup(this.menuventeMemo.isSup());
         this.menuvente.setDup(this.menuventeMemo.isDup());
         this.menuvente.setClo(this.menuventeMemo.isClo());
         this.menuvente.setTrf(this.menuventeMemo.isTrf());
         this.menuvente.setImp(this.menuventeMemo.isImp());
      }

      this.razMemoire();
      if (this.menuvente.getCommande().equalsIgnoreCase("80100:00")) {
         this.nature = 600;
         this.affichePage = "/ventes/ProduitsInit.jsp";
         this.menuProduitVente();
      } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:14")) {
         this.affichePage = "/ventes/EtudePrixInit.jsp";
         this.menuEtudePrix();
      } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:18")) {
         this.affichePage = "/ventes/ObjectifInit.jsp";
         this.menuObjectif();
      } else {
         Session var1;
         String var2;
         if (this.menuvente.getCommande().equalsIgnoreCase("80100:01")) {
            this.nature = 141;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcampagneEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/CapagneInit.jsp";
                  this.menuCampagneVentes(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:02")) {
            this.nature = 20;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BesoinEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/BesoinInit.jsp";
                  this.menuBesoin(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:12")) {
            this.nature = 8;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SimulEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/SimulContratInit.jsp";
                  this.menuSimulContrat(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:03")) {
            this.nature = 21;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/DevisInit.jsp";
                  this.menuDevis(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:04")) {
            this.nature = 22;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/CommandeInit.jsp";
                  this.menuBcommande(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:05")) {
            this.nature = 23;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/LivraisonInit.jsp";
                  this.menuBlivraison(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:06")) {
            this.nature = 24;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/RetourInit.jsp";
                  this.menuBretour(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:07")) {
            this.nature = 25;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/FactureInit.jsp";
                  this.menuFacture(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:08")) {
            this.nature = 26;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/AvoirInit.jsp";
                  this.menuAvoir(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:09")) {
            this.nature = 27;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/NoteDebitInit.jsp";
                  this.menuNoteDebit(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:19")) {
            this.nature = 127;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/AffairesInit.jsp";
                  this.menuAffaires(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:13")) {
            this.nature = 28;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BchargementEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/ChargementInit.jsp";
                  this.menuChargement(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:17")) {
            this.nature = 140;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcontratEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/ContratInit.jsp";
                  this.menuContrat(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:10")) {
            this.nature = 29;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/BonEncaissementInit.jsp";
                  this.menuBonEncaissement();
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:11")) {
            this.affichePage = "/pageenconstruction.jsp";
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:90")) {
            this.affichePage = "/ventes/ImpressionVentes.jsp";
            this.menuImpressionVentes();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:91")) {
            this.nature = 7;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommissionEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/CommissionsInit.jsp";
                  this.menuCommissionsVentes(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:15")) {
            this.nature = 6;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BticketLigne");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/TicketInit.jsp";
                  this.menuTicket(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:98")) {
            this.affichePage = "/ventes/TransfertVentes.jsp";
            this.menuTransfertVentes();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:99")) {
            this.affichePage = "/ventes/SelectionExercicesVentes.jsp";
            this.menuSelectionExercicesVentes();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80100:95")) {
            this.affichePage = "/ventes/ImportationVentes.jsp";
            this.menuImportationGesCom();
         }
      }

   }

   public void aiguillageVentesInterim() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      if (this.lastExoVentes.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menuvente.setAdd(false);
         this.menuvente.setMaj(false);
         this.menuvente.setSup(false);
         this.menuvente.setDup(false);
         this.menuvente.setClo(false);
         this.menuvente.setTrf(false);
         this.menuvente.setImp(true);
      } else {
         this.menuvente.setAdd(this.menuventeMemo.isAdd());
         this.menuvente.setMaj(this.menuventeMemo.isMaj());
         this.menuvente.setSup(this.menuventeMemo.isSup());
         this.menuvente.setDup(this.menuventeMemo.isDup());
         this.menuvente.setClo(this.menuventeMemo.isClo());
         this.menuvente.setTrf(this.menuventeMemo.isTrf());
         this.menuvente.setImp(this.menuventeMemo.isImp());
      }

      this.razMemoire();
      if (this.menuvente.getCommande().equalsIgnoreCase("80400:00")) {
         this.nature = 600;
         this.affichePage = "/ventes/ProduitsInit.jsp";
         this.menuProduitVente();
      } else {
         Session var1;
         String var2;
         if (this.menuvente.getCommande().equalsIgnoreCase("80400:03")) {
            this.nature = 21;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/DevisInit.jsp";
                  this.menuDevis(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80400:07")) {
            this.nature = 25;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/interim/FactureInit.jsp";
                  this.menuFacture(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80400:08")) {
            this.nature = 26;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BavoirEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/AvoirInit.jsp";
                  this.menuAvoir(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80400:09")) {
            this.nature = 27;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/NoteDebitInit.jsp";
                  this.menuNoteDebit(var1);
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80400:10")) {
            this.nature = 29;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/ventes/BonEncaissementInit.jsp";
                  this.menuBonEncaissement();
               } else {
                  this.affichePage = "/ventes/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/ventes/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80400:90")) {
            this.affichePage = "/ventes/ImpressionVentes.jsp";
            this.menuImpressionVentes();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80400:98")) {
            this.affichePage = "/ventes/TransfertVentes.jsp";
            this.menuTransfertVentes();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80400:99")) {
            this.affichePage = "/ventes/SelectionExercicesVentes.jsp";
            this.menuSelectionExercicesVentes();
         } else if (this.menuvente.getCommande().equalsIgnoreCase("80400:95")) {
            this.affichePage = "/ventes/ImportationVentes.jsp";
            this.menuImportationGesCom();
         }
      }

   }

   public void aiguillageRestaurant() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      if (this.lastExoVentes.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menuvente.setAdd(false);
         this.menuvente.setMaj(false);
         this.menuvente.setSup(false);
         this.menuvente.setDup(false);
         this.menuvente.setClo(false);
         this.menuvente.setTrf(false);
         this.menuvente.setImp(true);
      } else {
         this.menuvente.setAdd(this.menuventeMemo.isAdd());
         this.menuvente.setMaj(this.menuventeMemo.isMaj());
         this.menuvente.setSup(this.menuventeMemo.isSup());
         this.menuvente.setDup(this.menuventeMemo.isDup());
         this.menuvente.setClo(this.menuventeMemo.isClo());
         this.menuvente.setTrf(this.menuventeMemo.isTrf());
         this.menuvente.setImp(this.menuventeMemo.isImp());
      }

      this.razMemoire();
      if (this.menuvente.getCommande().equalsIgnoreCase("81700:00")) {
         this.nature = 600;
         this.affichePage = "/ventes/ProduitsInit.jsp";
         this.menuProduitVente();
      } else if (this.menuvente.getCommande().equalsIgnoreCase("81700:01")) {
         this.nature = 600;
         this.affichePage = "/restaurant/CartesInit.jsp";
         this.menuCarte();
      } else if (this.menuvente.getCommande().equalsIgnoreCase("81700:99")) {
         this.affichePage = "/ventes/SelectionExercicesVentes.jsp";
         this.menuSelectionExercicesVentes();
      }

   }

   public void aiguillageHotelerie() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      if (this.lastExoVentes.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menuvente.setAdd(false);
         this.menuvente.setMaj(false);
         this.menuvente.setSup(false);
         this.menuvente.setDup(false);
         this.menuvente.setClo(false);
         this.menuvente.setTrf(false);
         this.menuvente.setImp(true);
      } else {
         this.menuvente.setAdd(this.menuventeMemo.isAdd());
         this.menuvente.setMaj(this.menuventeMemo.isMaj());
         this.menuvente.setSup(this.menuventeMemo.isSup());
         this.menuvente.setDup(this.menuventeMemo.isDup());
         this.menuvente.setClo(this.menuventeMemo.isClo());
         this.menuvente.setTrf(this.menuventeMemo.isTrf());
         this.menuvente.setImp(this.menuventeMemo.isImp());
      }

      this.razMemoire();
      if (this.menuvente.getCommande().equalsIgnoreCase("81710:00")) {
         this.nature = 600;
         this.affichePage = "/ventes/ProduitsInit.jsp";
         this.menuProduitVente();
      } else if (this.menuvente.getCommande().equalsIgnoreCase("81710:99")) {
         this.affichePage = "/ventes/SelectionExercicesVentes.jsp";
         this.menuSelectionExercicesVentes();
      }

   }

   public void menuProduitVente() throws JDOMException, IOException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      this.formProduitsVtes = new FormProduitsVtes();
      this.formProduitsVtes.setutilInitHibernate(this.utilInitHibernate);
      this.formProduitsVtes.setBaseLog(this.baseLog);
      this.formProduitsVtes.setStructureLog(this.structureLog);
      this.formProduitsVtes.setUsersLog(this.usersLog);
      this.formProduitsVtes.instanceDaoUtilises();
      this.formProduitsVtes.setVar_memo_id_master(this.var_memo_id_master);
      this.formProduitsVtes.setExercicesVentes(this.exoselectionne);
      this.formProduitsVtes.setLastExoVentes(this.lastExoVentes);
      this.formProduitsVtes.setLastExoCompta(this.lastExoCompta);
      this.formProduitsVtes.setLastExoAchats(this.lastExoAchats);
      this.recupererLesItemsProd(var1);
      this.formProduitsVtes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formProduitsVtes.setOptionsVentes(this.optionsVentes);
      this.formProduitsVtes.setLesFamillesclients(this.lesFamilleClientsListe);
      this.formProduitsVtes.setFormRecherche(this.formRecherche);
      this.formProduitsVtes.accesResteintGroupe();
      this.formProduitsVtes.setMesMarquesItems(this.mesMarquesItems);
      this.formProduitsVtes.setMesFamillesItems(this.mesFamillesGlobalItems);
      this.formProduitsVtes.setVar_aff_tarif1(this.var_aff_tarif1);
      this.formProduitsVtes.setVar_aff_tarif2(this.var_aff_tarif2);
      this.formProduitsVtes.setVar_aff_tarif3(this.var_aff_tarif3);
      this.formProduitsVtes.setVar_aff_tarif4(this.var_aff_tarif4);
      this.formProduitsVtes.setVar_aff_tarif5(this.var_aff_tarif5);
      this.formProduitsVtes.setVar_tarif1(this.var_tarif1);
      this.formProduitsVtes.setVar_tarif2(this.var_tarif2);
      this.formProduitsVtes.setVar_tarif3(this.var_tarif3);
      this.formProduitsVtes.setVar_tarif4(this.var_tarif4);
      this.formProduitsVtes.setVar_tarif5(this.var_tarif5);
      this.formProduitsVtes.setDecoupageActivite(this.decoupageActivite);
      this.formProduitsVtes.setLaColonne1Items(this.laColonne1Items);
      this.formProduitsVtes.setLaColonne2Items(this.laColonne2Items);
      this.formProduitsVtes.setLaColonne3Items(this.laColonne3Items);
      this.formProduitsVtes.setMesProduitsDepotsItems(this.mesDepotItems);
      this.utilInitHibernate.closeSession();
      this.formProduitsVtes.recupererOptions();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuEtudePrix() throws JDOMException, IOException, HibernateException, NamingException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      this.formProduitsVtes = new FormProduitsVtes();
      this.formProduitsVtes.setutilInitHibernate(this.utilInitHibernate);
      this.formProduitsVtes.setBaseLog(this.baseLog);
      this.formProduitsVtes.setStructureLog(this.structureLog);
      this.formProduitsVtes.setUsersLog(this.usersLog);
      this.formProduitsVtes.instanceDaoUtilises();
      this.formProduitsVtes.setExercicesVentes(this.exoselectionne);
      this.formProduitsVtes.setLastExoVentes(this.lastExoVentes);
      this.formProduitsVtes.setLastExoCompta(this.lastExoCompta);
      this.formProduitsVtes.setLastExoAchats(this.lastExoAchats);
      this.recupererLesItemsProd(var1);
      this.formProduitsVtes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formProduitsVtes.setOptionsVentes(this.optionsVentes);
      this.formProduitsVtes.setLesFamillesclients(this.lesFamilleClientsListe);
      this.formProduitsVtes.recupererOptions();
      this.formProduitsVtes.accesResteintGroupe();
      this.formProduitsVtes.setMesMarquesItems(this.mesMarquesItems);
      this.formProduitsVtes.setMesFamillesItems(this.mesFamillesGlobalItems);
      this.formProduitsVtes.setVar_aff_tarif1(this.var_aff_tarif1);
      this.formProduitsVtes.setVar_aff_tarif2(this.var_aff_tarif2);
      this.formProduitsVtes.setVar_aff_tarif3(this.var_aff_tarif3);
      this.formProduitsVtes.setVar_aff_tarif4(this.var_aff_tarif4);
      this.formProduitsVtes.setVar_aff_tarif5(this.var_aff_tarif5);
      this.formProduitsVtes.setVar_tarif1(this.var_tarif1);
      this.formProduitsVtes.setVar_tarif2(this.var_tarif2);
      this.formProduitsVtes.setVar_tarif3(this.var_tarif3);
      this.formProduitsVtes.setVar_tarif4(this.var_tarif4);
      this.formProduitsVtes.setVar_tarif5(this.var_tarif5);
      this.formProduitsVtes.setVar_tarif6(this.var_tarif6);
      this.formProduitsVtes.setVar_tarif7(this.var_tarif7);
      this.formProduitsVtes.setVar_tarif8(this.var_tarif8);
      this.formProduitsVtes.setVar_tarif9(this.var_tarif9);
      this.formProduitsVtes.setVar_tarif10(this.var_tarif10);
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuCarte() throws JDOMException, IOException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      this.formProduitsVtes = new FormProduitsVtes();
      this.formProduitsVtes.setutilInitHibernate(this.utilInitHibernate);
      this.formProduitsVtes.setBaseLog(this.baseLog);
      this.formProduitsVtes.setStructureLog(this.structureLog);
      this.formProduitsVtes.setUsersLog(this.usersLog);
      this.formProduitsVtes.instanceDaoUtilises();
      this.formProduitsVtes.setExercicesVentes(this.exoselectionne);
      this.formProduitsVtes.setLastExoVentes(this.lastExoVentes);
      this.formProduitsVtes.setLastExoCompta(this.lastExoCompta);
      this.formProduitsVtes.setLastExoAchats(this.lastExoAchats);
      this.recupererLesItemsProd(var1);
      this.formProduitsVtes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formProduitsVtes.setOptionsVentes(this.optionsVentes);
      this.formProduitsVtes.setLesFamillesclients(this.lesFamilleClientsListe);
      this.formProduitsVtes.setFormRecherche(this.formRecherche);
      this.formProduitsVtes.recupererOptions();
      this.formProduitsVtes.accesResteintGroupe();
      this.formProduitsVtes.setMesMarquesItems(this.mesMarquesItems);
      this.formProduitsVtes.setMesFamillesItems(this.mesFamillesGlobalItems);
      this.formProduitsVtes.setVar_aff_tarif1(this.var_aff_tarif1);
      this.formProduitsVtes.setVar_aff_tarif2(this.var_aff_tarif2);
      this.formProduitsVtes.setVar_aff_tarif3(this.var_aff_tarif3);
      this.formProduitsVtes.setVar_aff_tarif4(this.var_aff_tarif4);
      this.formProduitsVtes.setVar_aff_tarif5(this.var_aff_tarif5);
      this.formProduitsVtes.setVar_tarif1(this.var_tarif1);
      this.formProduitsVtes.setVar_tarif2(this.var_tarif2);
      this.formProduitsVtes.setVar_tarif3(this.var_tarif3);
      this.formProduitsVtes.setVar_tarif4(this.var_tarif4);
      this.formProduitsVtes.setVar_tarif5(this.var_tarif5);
      this.formProduitsVtes.setDecoupageActivite(this.decoupageActivite);
      this.formProduitsVtes.setLaColonne1Items(this.laColonne1Items);
      this.formProduitsVtes.setLaColonne2Items(this.laColonne2Items);
      this.formProduitsVtes.setLaColonne3Items(this.laColonne3Items);
      this.formProduitsVtes.setMesProduitsDepotsItems(this.mesDepotItems);
      this.formProduitsVtes.initCarte(var1);
      this.utilInitHibernate.closeSession();
   }

   public void menuObjectif() throws JDOMException, IOException, HibernateException, NamingException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Site");
      this.formObjectifVentes = new FormObjectifVentes();
      this.formObjectifVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formObjectifVentes.setBaseLog(this.baseLog);
      this.formObjectifVentes.setStructureLog(this.structureLog);
      this.formObjectifVentes.setUsersLog(this.usersLog);
      this.formObjectifVentes.InstancesDaoUtilses();
      this.formObjectifVentes.setLigneMenu(this.menuvente);
      new OptionTiers();
      LireLesoptionsTiers var3 = new LireLesoptionsTiers();
      var3.setStrId(this.structureLog.getStrid());
      OptionTiers var2 = var3.lancer();
      this.formObjectifVentes.setOptionTiers(var2);
      this.formObjectifVentes.recupererOptionsTiers(var1);
      this.formObjectifVentes.chargerAnnees(var1);
      this.formObjectifVentes.chargerServices(var1);
      this.formObjectifVentes.recupererModeleListe();
      this.utilInitHibernate.closeSession();
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuCampagneVentes(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formCampagneVentes = new FormCampagneVentes();
      this.formCampagneVentes.setUtilInitHibernate(this.utilInitHibernate);
      this.formCampagneVentes.setBaseLog(this.baseLog);
      this.formCampagneVentes.setStructureLog(this.structureLog);
      this.formCampagneVentes.setUsersLog(this.usersLog);
      this.formCampagneVentes.InstancesDaoUtilses();
      this.formCampagneVentes.setNature(this.nature);
      this.formCampagneVentes.setExercicesVentes(this.exoselectionne);
      this.formCampagneVentes.setLastExoVentes(this.lastExoVentes);
      this.formCampagneVentes.setOptionsVentes(this.optionsVentes);
      this.formCampagneVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCampagneVentes.configVentes(var1);
      this.formCampagneVentes.accesResteintUser();
      this.formCampagneVentes.accesResteintGroupe();
      this.recupererLesItemsDocCampagne(var1);
      this.formCampagneVentes.setHabilitation(this.habilitation);
      this.formCampagneVentes.setFormRecherche(this.formRecherche);
      this.formCampagneVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1")) {
         this.formCampagneVentes.executerRequete(var1);
      }

   }

   public void menuBesoin(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formBesoinVentes = new FormBesoinVentes();
      this.formBesoinVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formBesoinVentes.setBaseLog(this.baseLog);
      this.formBesoinVentes.setStructureLog(this.structureLog);
      this.formBesoinVentes.setUsersLog(this.usersLog);
      this.formBesoinVentes.InstancesDaoUtilses();
      this.formBesoinVentes.setNature(this.nature);
      this.formBesoinVentes.setExercicesVentes(this.exoselectionne);
      this.formBesoinVentes.setLastExoVentes(this.lastExoVentes);
      this.formBesoinVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formBesoinVentes.setOptionsVentes(this.optionsVentes);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formBesoinVentes.setVar_option_parc(100);
         } else {
            this.formBesoinVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formBesoinVentes.setVar_option_parc(100);
      }

      this.formBesoinVentes.setMesParcsItems(this.mesParcsItems);
      this.formBesoinVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formBesoinVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formBesoinVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formBesoinVentes.setVar_timbre(this.var_timbre);
      this.formBesoinVentes.setVar_tc_type(this.var_tc_type);
      this.formBesoinVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formBesoinVentes.setVar_tc_taux(this.var_tc_taux);
      this.formBesoinVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formBesoinVentes.configVentes();
      this.formBesoinVentes.accesResteintUser();
      this.formBesoinVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formBesoinVentes.setHabilitation(this.habilitation);
      this.formBesoinVentes.setFormRecherche(this.formRecherche);
      this.formBesoinVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formBesoinVentes.setDecoupageActivite(this.decoupageActivite);
      this.formBesoinVentes.setLaColonne1Items(this.laColonne1Items);
      this.formBesoinVentes.setLaColonne2Items(this.laColonne2Items);
      this.formBesoinVentes.setLaColonne3Items(this.laColonne3Items);
      this.formBesoinVentes.setVerifBareme(this.verifBareme);
      this.formBesoinVentes.chargerLesUsers(var1);
      this.formBesoinVentes.chargerCampagne(var1);
      this.formBesoinVentes.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formBesoinVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formBesoinVentes.chargeListeDetail(var1);
      }

   }

   public void menuSimulContrat(Session var1) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.formSimulContratVentes = new FormSimulContratVentes();
      this.formSimulContratVentes.setUtilInitHibernate(this.utilInitHibernate);
      this.formSimulContratVentes.setBaseLog(this.baseLog);
      this.formSimulContratVentes.setStructureLog(this.structureLog);
      this.formSimulContratVentes.setUsersLog(this.usersLog);
      this.formSimulContratVentes.InstancesDaoUtilses();
      this.formSimulContratVentes.setNature(this.nature);
      this.formSimulContratVentes.setExercicesVentes(this.exoselectionne);
      this.formSimulContratVentes.setLastExoVentes(this.lastExoVentes);
      this.formSimulContratVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formSimulContratVentes.setOptionsVentes(this.optionsVentes);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formSimulContratVentes.setVar_option_parc(100);
         } else {
            this.formSimulContratVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formSimulContratVentes.setVar_option_parc(100);
      }

      this.formSimulContratVentes.setMesParcsItems(this.mesParcsItems);
      this.formSimulContratVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formSimulContratVentes.setVar_timbre(this.var_timbre);
      this.formSimulContratVentes.setVar_tc_type(this.var_tc_type);
      this.formSimulContratVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formSimulContratVentes.setVar_tc_taux(this.var_tc_taux);
      this.formSimulContratVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formSimulContratVentes.configVentes();
      this.formSimulContratVentes.accesResteintUser();
      this.formSimulContratVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formSimulContratVentes.setHabilitation(this.habilitation);
      this.formSimulContratVentes.chargerCommerciauxResponsable(var1);
      this.formSimulContratVentes.recupererTypeContrat(var1);
      this.formSimulContratVentes.recupererMarque(var1);
      this.formSimulContratVentes.setFormRecherche(this.formRecherche);
      this.formSimulContratVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formSimulContratVentes.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formSimulContratVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formSimulContratVentes.chargeListeDetail(var1);
      }

   }

   public void menuDevis(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formDevisVentes = new FormDevisVentes();
      this.formDevisVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formDevisVentes.setBaseLog(this.baseLog);
      this.formDevisVentes.setStructureLog(this.structureLog);
      this.formDevisVentes.setUsersLog(this.usersLog);
      this.formDevisVentes.InstancesDaoUtilses();
      this.formDevisVentes.setNature(this.nature);
      this.formDevisVentes.setExercicesVentes(this.exoselectionne);
      this.formDevisVentes.setLastExoVentes(this.lastExoVentes);
      this.formDevisVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formDevisVentes.setOptionsVentes(this.optionsVentes);
      this.formDevisVentes.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formDevisVentes.setVar_option_parc(100);
         } else {
            this.formDevisVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formDevisVentes.setVar_option_parc(100);
      }

      this.formDevisVentes.setMesParcsItems(this.mesParcsItems);
      this.formDevisVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formDevisVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formDevisVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formDevisVentes.setVar_timbre(this.var_timbre);
      this.formDevisVentes.setVar_tc_type(this.var_tc_type);
      this.formDevisVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formDevisVentes.setVar_tc_taux(this.var_tc_taux);
      this.formDevisVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formDevisVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formDevisVentes.configVentes();
      this.formDevisVentes.accesResteintUser();
      this.formDevisVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formDevisVentes.chargerCommerciauxResponsable(var1);
      this.formDevisVentes.setHabilitation(this.habilitation);
      this.formDevisVentes.setFormRecherche(this.formRecherche);
      this.formDevisVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formDevisVentes.setDecoupageActivite(this.decoupageActivite);
      this.formDevisVentes.setLaColonne1Items(this.laColonne1Items);
      this.formDevisVentes.setLaColonne2Items(this.laColonne2Items);
      this.formDevisVentes.setLaColonne3Items(this.laColonne3Items);
      this.formDevisVentes.setVerifBareme(this.verifBareme);
      this.formDevisVentes.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formDevisVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formDevisVentes.executerRequete(var1);
      }

   }

   public void menuBcommande(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formCommandeVentes = new FormCommandeVentes();
      this.formCommandeVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formCommandeVentes.setBaseLog(this.baseLog);
      this.formCommandeVentes.setStructureLog(this.structureLog);
      this.formCommandeVentes.setUsersLog(this.usersLog);
      this.formCommandeVentes.InstancesDaoUtilses();
      this.formCommandeVentes.setNature(this.nature);
      this.formCommandeVentes.setExercicesVentes(this.exoselectionne);
      this.formCommandeVentes.setLastExoVentes(this.lastExoVentes);
      this.formCommandeVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCommandeVentes.setOptionsVentes(this.optionsVentes);
      this.formCommandeVentes.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formCommandeVentes.setVar_option_parc(100);
         } else {
            this.formCommandeVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formCommandeVentes.setVar_option_parc(100);
      }

      this.formCommandeVentes.setMesParcsItems(this.mesParcsItems);
      this.formCommandeVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formCommandeVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formCommandeVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formCommandeVentes.setVar_timbre(this.var_timbre);
      this.formCommandeVentes.setVar_tc_type(this.var_tc_type);
      this.formCommandeVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formCommandeVentes.setVar_tc_taux(this.var_tc_taux);
      this.formCommandeVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formCommandeVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formCommandeVentes.setTypeVente(this.typeVente);
      this.formCommandeVentes.configVentes();
      this.formCommandeVentes.accesResteintUser();
      this.formCommandeVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formCommandeVentes.chargerCommerciauxResponsable(var1);
      this.formCommandeVentes.setHabilitation(this.habilitation);
      this.formCommandeVentes.setFormRecherche(this.formRecherche);
      this.formCommandeVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formCommandeVentes.setDecoupageActivite(this.decoupageActivite);
      this.formCommandeVentes.setLaColonne1Items(this.laColonne1Items);
      this.formCommandeVentes.setLaColonne2Items(this.laColonne2Items);
      this.formCommandeVentes.setLaColonne3Items(this.laColonne3Items);
      this.formCommandeVentes.setVerifBareme(this.verifBareme);
      this.formCommandeVentes.setListCaisses(this.listCaisses);
      this.formCommandeVentes.setUrlExplorateur(this.urlExplorateur);
      this.formCommandeVentes.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, Integer.parseInt(this.optionsVentes.getPaiementAVOIR()));
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formCommandeVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formCommandeVentes.executerRequete(var1);
      }

   }

   public void menuBlivraison(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formLivraisonVentes = new FormLivraisonVentes();
      this.formLivraisonVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formLivraisonVentes.setBaseLog(this.baseLog);
      this.formLivraisonVentes.setStructureLog(this.structureLog);
      this.formLivraisonVentes.setUsersLog(this.usersLog);
      this.formLivraisonVentes.InstancesDaoUtilses();
      this.formLivraisonVentes.setNature(this.nature);
      this.formLivraisonVentes.setExercicesVentes(this.exoselectionne);
      this.formLivraisonVentes.setLastExoVentes(this.lastExoVentes);
      this.formLivraisonVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formLivraisonVentes.setOptionsVentes(this.optionsVentes);
      this.formLivraisonVentes.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formLivraisonVentes.setVar_option_parc(100);
         } else {
            this.formLivraisonVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formLivraisonVentes.setVar_option_parc(100);
      }

      this.formLivraisonVentes.setMesParcsItems(this.mesParcsItems);
      this.formLivraisonVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formLivraisonVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formLivraisonVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formLivraisonVentes.setVar_timbre(this.var_timbre);
      this.formLivraisonVentes.setVar_tc_type(this.var_tc_type);
      this.formLivraisonVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formLivraisonVentes.setVar_tc_taux(this.var_tc_taux);
      this.formLivraisonVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formLivraisonVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formLivraisonVentes.setTypeVente(this.typeVente);
      this.formLivraisonVentes.configVentes();
      this.formLivraisonVentes.accesResteintUser();
      this.formLivraisonVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formLivraisonVentes.chargerCommerciauxResponsable(var1);
      this.formLivraisonVentes.setHabilitation(this.habilitation);
      this.formLivraisonVentes.setFormRecherche(this.formRecherche);
      this.formLivraisonVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formLivraisonVentes.setDecoupageActivite(this.decoupageActivite);
      this.formLivraisonVentes.setLaColonne1Items(this.laColonne1Items);
      this.formLivraisonVentes.setLaColonne2Items(this.laColonne2Items);
      this.formLivraisonVentes.setLaColonne3Items(this.laColonne3Items);
      this.formLivraisonVentes.setVerifBareme(this.verifBareme);
      this.formLivraisonVentes.setListCaisses(this.listCaisses);
      this.formLivraisonVentes.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, Integer.parseInt(this.optionsVentes.getPaiementAVOIR()));
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formLivraisonVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formLivraisonVentes.executerRequete(var1);
      }

   }

   public void menuBretour(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formRetourVentes = new FormRetourVentes();
      this.formRetourVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formRetourVentes.setBaseLog(this.baseLog);
      this.formRetourVentes.setStructureLog(this.structureLog);
      this.formRetourVentes.setUsersLog(this.usersLog);
      this.formRetourVentes.InstancesDaoUtilses();
      this.formRetourVentes.setNature(this.nature);
      this.formRetourVentes.setExercicesVentes(this.exoselectionne);
      this.formRetourVentes.setLastExoVentes(this.lastExoVentes);
      this.formRetourVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formRetourVentes.setOptionsVentes(this.optionsVentes);
      this.formRetourVentes.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formRetourVentes.setVar_option_parc(100);
         } else {
            this.formRetourVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formRetourVentes.setVar_option_parc(100);
      }

      this.formRetourVentes.setMesParcsItems(this.mesParcsItems);
      this.formRetourVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formRetourVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formRetourVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formRetourVentes.setVar_timbre(this.var_timbre);
      this.formRetourVentes.setVar_tc_type(this.var_tc_type);
      this.formRetourVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formRetourVentes.setVar_tc_taux(this.var_tc_taux);
      this.formRetourVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formRetourVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formRetourVentes.configVentes();
      this.formRetourVentes.accesResteintUser();
      this.formRetourVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formRetourVentes.chargerCommerciauxResponsable(var1);
      this.formRetourVentes.setHabilitation(this.habilitation);
      this.formRetourVentes.setFormRecherche(this.formRecherche);
      this.formRetourVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formRetourVentes.setDecoupageActivite(this.decoupageActivite);
      this.formRetourVentes.setLaColonne1Items(this.laColonne1Items);
      this.formRetourVentes.setLaColonne2Items(this.laColonne2Items);
      this.formRetourVentes.setLaColonne3Items(this.laColonne3Items);
      this.formRetourVentes.setVerifBareme(this.verifBareme);
      this.formRetourVentes.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formRetourVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formRetourVentes.executerRequete(var1);
      }

   }

   public void menuFacture(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formFactureVentes = new FormFactureVentes();
      this.formFactureVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formFactureVentes.setBaseLog(this.baseLog);
      this.formFactureVentes.setStructureLog(this.structureLog);
      this.formFactureVentes.setUsersLog(this.usersLog);
      this.formFactureVentes.InstancesDaoUtilses();
      this.formFactureVentes.setNature(this.nature);
      this.formFactureVentes.setExercicesVentes(this.exoselectionne);
      this.formFactureVentes.setLastExoVentes(this.lastExoVentes);
      this.formFactureVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFactureVentes.setOptionsVentes(this.optionsVentes);
      this.formFactureVentes.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formFactureVentes.setVar_option_parc(100);
         } else {
            this.formFactureVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formFactureVentes.setVar_option_parc(100);
      }

      this.formFactureVentes.setMesParcsItems(this.mesParcsItems);
      this.formFactureVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formFactureVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formFactureVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formFactureVentes.setVar_timbre(this.var_timbre);
      this.formFactureVentes.setVar_tc_type(this.var_tc_type);
      this.formFactureVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formFactureVentes.setVar_tc_taux(this.var_tc_taux);
      this.formFactureVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formFactureVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formFactureVentes.setTypeVente(this.typeVente);
      this.formFactureVentes.configVentes();
      this.formFactureVentes.accesResteintUser();
      this.formFactureVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formFactureVentes.chargerCommerciauxResponsable(var1);
      this.formFactureVentes.setHabilitation(this.habilitation);
      this.formFactureVentes.setFormRecherche(this.formRecherche);
      this.formFactureVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formFactureVentes.setDecoupageActivite(this.decoupageActivite);
      this.formFactureVentes.setLaColonne1Items(this.laColonne1Items);
      this.formFactureVentes.setLaColonne2Items(this.laColonne2Items);
      this.formFactureVentes.setLaColonne3Items(this.laColonne3Items);
      this.formFactureVentes.setVerifBareme(this.verifBareme);
      this.formFactureVentes.setListCaisses(this.listCaisses);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, Integer.parseInt(this.optionsVentes.getPaiementAVOIR()));
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formFactureVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formFactureVentes.executerRequete(var1);
      }

   }

   public void menuAvoir(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formAvoirVentes = new FormAvoirVentes();
      this.formAvoirVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formAvoirVentes.setBaseLog(this.baseLog);
      this.formAvoirVentes.setStructureLog(this.structureLog);
      this.formAvoirVentes.setUsersLog(this.usersLog);
      this.formAvoirVentes.InstancesDaoUtilses();
      this.formAvoirVentes.setNature(this.nature);
      this.formAvoirVentes.setExercicesVentes(this.exoselectionne);
      this.formAvoirVentes.setLastExoVentes(this.lastExoVentes);
      this.formAvoirVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formAvoirVentes.setOptionsVentes(this.optionsVentes);
      this.formAvoirVentes.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formAvoirVentes.setVar_option_parc(100);
         } else {
            this.formAvoirVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formAvoirVentes.setVar_option_parc(100);
      }

      this.formAvoirVentes.setMesParcsItems(this.mesParcsItems);
      this.formAvoirVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formAvoirVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formAvoirVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formAvoirVentes.setVar_timbre(this.var_timbre);
      this.formAvoirVentes.setVar_tc_type(this.var_tc_type);
      this.formAvoirVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formAvoirVentes.setVar_tc_taux(this.var_tc_taux);
      this.formAvoirVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formAvoirVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formAvoirVentes.configVentes();
      this.formAvoirVentes.accesResteintUser();
      this.formAvoirVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formAvoirVentes.chargerCommerciauxResponsable(var1);
      this.formAvoirVentes.setHabilitation(this.habilitation);
      this.formAvoirVentes.setFormRecherche(this.formRecherche);
      this.formAvoirVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formAvoirVentes.setDecoupageActivite(this.decoupageActivite);
      this.formAvoirVentes.setLaColonne1Items(this.laColonne1Items);
      this.formAvoirVentes.setLaColonne2Items(this.laColonne2Items);
      this.formAvoirVentes.setLaColonne3Items(this.laColonne3Items);
      this.formAvoirVentes.setVerifBareme(this.verifBareme);
      this.formAvoirVentes.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formAvoirVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formAvoirVentes.executerRequete(var1);
      }

   }

   public void menuNoteDebit(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formNoteDebitVentes = new FormNoteDebitVentes();
      this.formNoteDebitVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formNoteDebitVentes.setBaseLog(this.baseLog);
      this.formNoteDebitVentes.setStructureLog(this.structureLog);
      this.formNoteDebitVentes.setUsersLog(this.usersLog);
      this.formNoteDebitVentes.InstancesDaoUtilses();
      this.formNoteDebitVentes.setNature(this.nature);
      this.formNoteDebitVentes.setExercicesVentes(this.exoselectionne);
      this.formNoteDebitVentes.setLastExoVentes(this.lastExoVentes);
      this.formNoteDebitVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formNoteDebitVentes.setOptionsVentes(this.optionsVentes);
      this.formNoteDebitVentes.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formNoteDebitVentes.setVar_option_parc(100);
         } else {
            this.formNoteDebitVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formNoteDebitVentes.setVar_option_parc(100);
      }

      this.formNoteDebitVentes.setMesParcsItems(this.mesParcsItems);
      this.formNoteDebitVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formNoteDebitVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formNoteDebitVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formNoteDebitVentes.setVar_timbre(this.var_timbre);
      this.formNoteDebitVentes.setVar_tc_type(this.var_tc_type);
      this.formNoteDebitVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formNoteDebitVentes.setVar_tc_taux(this.var_tc_taux);
      this.formNoteDebitVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formNoteDebitVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formNoteDebitVentes.setTypeVente(this.typeVente);
      this.formNoteDebitVentes.configVentes();
      this.formNoteDebitVentes.accesResteintUser();
      this.formNoteDebitVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formNoteDebitVentes.chargerCommerciauxResponsable(var1);
      this.formNoteDebitVentes.setHabilitation(this.habilitation);
      this.formNoteDebitVentes.setFormRecherche(this.formRecherche);
      this.formNoteDebitVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formNoteDebitVentes.setDecoupageActivite(this.decoupageActivite);
      this.formNoteDebitVentes.setLaColonne1Items(this.laColonne1Items);
      this.formNoteDebitVentes.setLaColonne2Items(this.laColonne2Items);
      this.formNoteDebitVentes.setLaColonne3Items(this.laColonne3Items);
      this.formNoteDebitVentes.setVerifBareme(this.verifBareme);
      this.formNoteDebitVentes.setListCaisses(this.listCaisses);
      this.formNoteDebitVentes.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formNoteDebitVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formNoteDebitVentes.executerRequete(var1);
      }

   }

   public void menuFactureInterne(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formFactureInterneVentes = new FormFactureInterneVentes();
      this.formFactureInterneVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formFactureInterneVentes.setBaseLog(this.baseLog);
      this.formFactureInterneVentes.setStructureLog(this.structureLog);
      this.formFactureInterneVentes.setUsersLog(this.usersLog);
      this.formFactureInterneVentes.InstancesDaoUtilses();
      this.formFactureInterneVentes.setNature(this.nature);
      this.formFactureInterneVentes.setExercicesVentes(this.exoselectionne);
      this.formFactureInterneVentes.setLastExoVentes(this.lastExoVentes);
      this.formFactureInterneVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFactureInterneVentes.setOptionsVentes(this.optionsVentes);
      this.formFactureInterneVentes.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formFactureInterneVentes.setVar_option_parc(100);
         } else {
            this.formFactureInterneVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formFactureInterneVentes.setVar_option_parc(100);
      }

      this.formFactureInterneVentes.setMesParcsItems(this.mesParcsItems);
      this.formFactureInterneVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formFactureInterneVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formFactureInterneVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formFactureInterneVentes.setVar_timbre(this.var_timbre);
      this.formFactureInterneVentes.setVar_tc_type(this.var_tc_type);
      this.formFactureInterneVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formFactureInterneVentes.setVar_tc_taux(this.var_tc_taux);
      this.formFactureInterneVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formFactureInterneVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formFactureInterneVentes.setTypeVente(this.typeVente);
      this.formFactureInterneVentes.configVentes();
      this.formFactureInterneVentes.accesResteintUser();
      this.formFactureInterneVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formFactureInterneVentes.chargerCommerciauxResponsable(var1);
      this.formFactureInterneVentes.setHabilitation(this.habilitation);
      this.formFactureInterneVentes.setFormRecherche(this.formRecherche);
      this.formFactureInterneVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formFactureInterneVentes.setDecoupageActivite(this.decoupageActivite);
      this.formFactureInterneVentes.setLaColonne1Items(this.laColonne1Items);
      this.formFactureInterneVentes.setLaColonne2Items(this.laColonne2Items);
      this.formFactureInterneVentes.setLaColonne3Items(this.laColonne3Items);
      this.formFactureInterneVentes.setVerifBareme(this.verifBareme);
      this.formFactureInterneVentes.setListCaisses(this.listCaisses);
      this.formFactureInterneVentes.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formFactureInterneVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formFactureInterneVentes.executerRequete(var1);
      }

   }

   public void menuAffaires(Session var1) throws ParseException, NamingException, IOException, JDOMException {
      this.formAffaires = new FormAffaires();
      this.formAffaires.setutilInitHibernate(this.utilInitHibernate);
      this.formAffaires.setBaseLog(this.baseLog);
      this.formAffaires.setStructureLog(this.structureLog);
      this.formAffaires.setUsersLog(this.usersLog);
      this.formAffaires.InstancesDaoUtilses();
      this.formAffaires.setLigneMenu(this.menuvente);
      this.formAffaires.setNature(this.nature);
      this.formAffaires.recupererOptionsTiersVentes(var1);
      this.formAffaires.chargerAnnees(var1);
      this.formAffaires.chargerServices(var1);
      this.recupererLesItemsDoc(var1);
      this.formAffaires.setVar_timbre(this.var_timbre);
      this.formAffaires.setVar_tc_type(this.var_tc_type);
      this.formAffaires.setVar_tc_libelle(this.var_tc_libelle);
      this.formAffaires.setVar_tc_taux(this.var_tc_taux);
      this.formAffaires.chargerCommerciauxResponsable(var1);
      this.formAffaires.setHabilitation(this.habilitation);
      this.formAffaires.setFormRecherche(this.formRecherche);
      this.formAffaires.setUrlExplorateur(this.urlExplorateur);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formAffaires.chargerLesAffaires(var1);
      }

   }

   public void menuChargement(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formChargementVentes = new FormChargementVentes();
      this.formChargementVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formChargementVentes.setBaseLog(this.baseLog);
      this.formChargementVentes.setStructureLog(this.structureLog);
      this.formChargementVentes.setUsersLog(this.usersLog);
      this.formChargementVentes.InstancesDaoUtilses();
      this.formChargementVentes.setNature(this.nature);
      this.formChargementVentes.setExercicesVentes(this.exoselectionne);
      this.formChargementVentes.setLastExoVentes(this.lastExoVentes);
      this.formChargementVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formChargementVentes.setOptionsVentes(this.optionsVentes);
      this.formChargementVentes.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formChargementVentes.setVar_option_parc(100);
         } else {
            this.formChargementVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formChargementVentes.setVar_option_parc(100);
      }

      this.formChargementVentes.setMesParcsItems(this.mesParcsItems);
      this.formChargementVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formChargementVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formChargementVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formChargementVentes.setVar_timbre(this.var_timbre);
      this.formChargementVentes.setVar_tc_type(this.var_tc_type);
      this.formChargementVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formChargementVentes.setVar_tc_taux(this.var_tc_taux);
      this.formChargementVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formChargementVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formChargementVentes.configVentes();
      this.formChargementVentes.accesResteintUser();
      this.formChargementVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formChargementVentes.setHabilitation(this.habilitation);
      this.formChargementVentes.setFormRecherche(this.formRecherche);
      this.formChargementVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formChargementVentes.chargerLesUsers(var1);
      this.formChargementVentes.chargerLesDepots(var1);
      this.formChargementVentes.chargerLesProduitsFrais(var1);
      this.formChargementVentes.setDecoupageActivite(this.decoupageActivite);
      this.formChargementVentes.setLaColonne1Items(this.laColonne1Items);
      this.formChargementVentes.setLaColonne2Items(this.laColonne2Items);
      this.formChargementVentes.setLaColonne3Items(this.laColonne3Items);
      this.formChargementVentes.setVerifBareme(this.verifBareme);
      this.formChargementVentes.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formChargementVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formChargementVentes.chargeListeDetail(var1);
      }

   }

   public void menuContrat(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formContratVentes = new FormContratVentes();
      this.formContratVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formContratVentes.setBaseLog(this.baseLog);
      this.formContratVentes.setStructureLog(this.structureLog);
      this.formContratVentes.setUsersLog(this.usersLog);
      this.formContratVentes.InstancesDaoUtilses();
      this.formContratVentes.setNature(this.nature);
      this.formContratVentes.setExercicesVentes(this.exoselectionne);
      this.formContratVentes.setLastExoVentes(this.lastExoVentes);
      this.formContratVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formContratVentes.setOptionsVentes(this.optionsVentes);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formContratVentes.setVar_option_parc(100);
         } else {
            this.formContratVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formContratVentes.setVar_option_parc(100);
      }

      this.formContratVentes.setMesParcsItems(this.mesParcsItems);
      this.formContratVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formContratVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formContratVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formContratVentes.setVar_timbre(this.var_timbre);
      this.formContratVentes.setVar_tc_type(this.var_tc_type);
      this.formContratVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formContratVentes.setVar_tc_taux(this.var_tc_taux);
      this.formContratVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formContratVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formContratVentes.setTypeVente(this.typeVente);
      this.formContratVentes.configVentes();
      this.formContratVentes.accesResteintUser();
      this.formContratVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formContratVentes.chargerCommerciauxResponsable(var1);
      this.formContratVentes.setHabilitation(this.habilitation);
      this.formContratVentes.setFormRecherche(this.formRecherche);
      this.formContratVentes.setMesSerieUserItem(this.mesSerieUserItem);
      this.formContratVentes.setDecoupageActivite(this.decoupageActivite);
      this.formContratVentes.setLaColonne1Items(this.laColonne1Items);
      this.formContratVentes.setLaColonne2Items(this.laColonne2Items);
      this.formContratVentes.setLaColonne3Items(this.laColonne3Items);
      this.formContratVentes.setVerifBareme(this.verifBareme);
      this.formContratVentes.recupererModelesItem(var1);
      this.formContratVentes.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formContratVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formContratVentes.executerRequete(var1);
      }

   }

   public void menuBonEncaissement() throws JDOMException, IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
      this.formBonEncaissementVente = new FormBonEncaissementVente();
      this.formBonEncaissementVente.setutilInitHibernate(this.utilInitHibernate);
      this.formBonEncaissementVente.setBaseLog(this.baseLog);
      this.formBonEncaissementVente.setStructureLog(this.structureLog);
      this.formBonEncaissementVente.setUsersLog(this.usersLog);
      this.formBonEncaissementVente.InstancesDaoUtilses();
      this.formBonEncaissementVente.setExercicesVentes(this.exoselectionne);
      this.formBonEncaissementVente.setOptionsVentes(this.optionsVentes);
      this.formBonEncaissementVente.setUsersChrono(this.usersChrono);
      this.formBonEncaissementVente.chargerFind(var1);
      this.recupererLesItemsDoc(var1);
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuLissageFacture(Session var1) throws IOException, SAXException, JDOMException, HibernateException, NamingException, ParseException {
      this.formFactureVentes = new FormFactureVentes();
      this.formFactureVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formFactureVentes.setBaseLog(this.baseLog);
      this.formFactureVentes.setStructureLog(this.structureLog);
      this.formFactureVentes.setUsersLog(this.usersLog);
      this.formFactureVentes.InstancesDaoUtilses();
      this.formFactureVentes.setNature(this.nature);
      this.formFactureVentes.setExercicesVentes(this.exoselectionne);
      this.formFactureVentes.setLastExoVentes(this.lastExoVentes);
      this.formFactureVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFactureVentes.setOptionsVentes(this.optionsVentes);
      this.formFactureVentes.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formFactureVentes.setVar_option_parc(100);
         } else {
            this.formFactureVentes.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formFactureVentes.setVar_option_parc(100);
      }

      this.formFactureVentes.setMesParcsItems(this.mesParcsItems);
      this.formFactureVentes.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formFactureVentes.setMesUnitesItems(this.mesUnitesItems);
      this.formFactureVentes.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formFactureVentes.setVar_timbre(this.var_timbre);
      this.formFactureVentes.setVar_tc_type(this.var_tc_type);
      this.formFactureVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formFactureVentes.setVar_tc_taux(this.var_tc_taux);
      this.formFactureVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formFactureVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formFactureVentes.configVentes();
      this.formFactureVentes.accesResteintUser();
      this.formFactureVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formFactureVentes.chargerCommerciauxResponsable(var1);
      this.formFactureVentes.setHabilitation(this.habilitation);
      this.formFactureVentes.setFormRecherche(this.formRecherche);
      this.formFactureVentes.setVar_more_search(false);
      this.formFactureVentes.moreSearch();
      this.formFactureVentes.setInpEtat(100);
      this.formFactureVentes.setMesSerieUserItem(this.mesSerieUserItem);
      if (this.mesSerieUserItem.size() != 0) {
         this.formFactureVentes.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
      } else {
         this.formFactureVentes.setInpSerie("");
      }

      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formFactureVentes.executerRequete(var1);
      }

   }

   public void menuTicket(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException {
      this.formTicketVentes = new FormTicketVentes();
      this.formTicketVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formTicketVentes.setBaseLog(this.baseLog);
      this.formTicketVentes.setStructureLog(this.structureLog);
      this.formTicketVentes.setUsersLog(this.usersLog);
      this.formTicketVentes.InstancesDaoUtilses();
      this.formTicketVentes.setNature(this.nature);
      this.formTicketVentes.setExercicesVentes(this.exoselectionne);
      this.formTicketVentes.setLastExoVentes(this.lastExoVentes);
      new ExercicesCaisse();
      ExercicesCaisseDao var3 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
      ExercicesCaisse var2 = var3.recupererLastExo(var1);
      this.formTicketVentes.setExercicesCaisse(var2);
      this.formTicketVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formTicketVentes.setOptionsVentes(this.optionsVentes);
      this.formTicketVentes.setVar_timbre(this.var_timbre);
      this.formTicketVentes.setVar_tc_type(this.var_tc_type);
      this.formTicketVentes.setVar_tc_libelle(this.var_tc_libelle);
      this.formTicketVentes.setVar_tc_taux(this.var_tc_taux);
      this.formTicketVentes.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formTicketVentes.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formTicketVentes.configVentes(var1);
      this.formTicketVentes.accesResteintUser();
      this.formTicketVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.recupererModeleStock();
      this.formTicketVentes.setVerifBareme(this.verifBareme);
      this.formTicketVentes.setFormRecherche(this.formRecherche);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuImpressionVentes() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      this.formImpressionVentes = new FormImpressionVentes();
      this.formImpressionVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionVentes.setBaseLog(this.baseLog);
      this.formImpressionVentes.setStructureLog(this.structureLog);
      this.formImpressionVentes.setUsersLog(this.usersLog);
      this.formImpressionVentes.InstancesDaoUtilses();
      this.formImpressionVentes.setExoSelectionne(this.exoselectionne);
      this.formImpressionVentes.setOptionVentes(this.optionsVentes);
      this.formImpressionVentes.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionVentes.chargerLesRepImpVentes(var1);
      this.formImpressionVentes.calculeAnalytique();
      this.recupererLesItemsImpression(var1);
      this.formImpressionVentes.setLaColonne1Items(this.laColonne1Items);
      this.formImpressionVentes.setLaColonne2Items(this.laColonne2Items);
      this.formImpressionVentes.setLaColonne3Items(this.laColonne3Items);
      this.formImpressionVentes.initImpression();
      this.formImpressionVentes.chargerPeriodes();
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuCommissionsVentes(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException {
      this.formCommissionsVentes = new FormCommissionsVentes();
      this.formCommissionsVentes.setUtilInitHibernate(this.utilInitHibernate);
      this.formCommissionsVentes.setBaseLog(this.baseLog);
      this.formCommissionsVentes.setStructureLog(this.structureLog);
      this.formCommissionsVentes.setUsersLog(this.usersLog);
      this.formCommissionsVentes.InstancesDaoUtilses();
      this.formCommissionsVentes.setNature(this.nature);
      this.formCommissionsVentes.setExercicesVentes(this.exoselectionne);
      this.formCommissionsVentes.setLastExoVentes(this.lastExoVentes);
      this.formCommissionsVentes.setOptionsVentes(this.optionsVentes);
      this.formCommissionsVentes.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCommissionsVentes.setOptionsVentes(this.optionsVentes);
      this.formCommissionsVentes.configVentes(var1);
      this.formCommissionsVentes.accesResteintUser();
      this.formCommissionsVentes.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formCommissionsVentes.setHabilitation(this.habilitation);
      this.formCommissionsVentes.setFormRecherche(this.formRecherche);
      this.recupererLesCommerciauxItem(var1);
      this.formCommissionsVentes.setMesResponsablesItems(this.mesResponsablesItems);
      this.formCommissionsVentes.setMesCommerciauxItems(this.mesCommerciauxItems);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuTransfertVentes() throws IOException, JDOMException, HibernateException, NamingException {
      this.formTransfertVentes = new FormTransfertVentes();
      this.formTransfertVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertVentes.setBaseLog(this.baseLog);
      this.formTransfertVentes.setStructureLog(this.structureLog);
      this.formTransfertVentes.setUsersLog(this.usersLog);
      this.formTransfertVentes.InstancesDaoUtilses();
      this.formTransfertVentes.setExercicesVentes(this.exoselectionne);
      this.formTransfertVentes.setOptionsVentes(this.optionsVentes);
      this.formTransfertVentes.init();
   }

   public void menuSelectionExercicesVentes() throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesVentes = new FormExercicesVentes();
      this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesVentes.setBaseLog(this.baseLog);
      this.formExercicesVentes.setStructureLog(this.structureLog);
      this.formExercicesVentes.setUsersLog(this.usersLog);
      this.formExercicesVentes.InstancesDaoUtilses();
      this.leIdExo = this.exoselectionne.getExevteId();
      this.formExercicesVentes.setLesexercicesVentes(this.formExercicesVentes.recupererLesexercices((Session)null));
   }

   public void menuImportationGesCom() throws HibernateException, NamingException {
      this.formTransfertVentes = new FormTransfertVentes();
      this.formTransfertVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertVentes.setBaseLog(this.baseLog);
      this.formTransfertVentes.setStructureLog(this.structureLog);
      this.formTransfertVentes.setUsersLog(this.usersLog);
      this.formTransfertVentes.InstancesDaoUtilses();
      this.formTransfertVentes.setNature(this.nature);
      this.formTransfertVentes.setExercicesVentes(this.exoselectionne);
      this.formTransfertVentes.setFormRecherche(this.formRecherche);
      this.formTransfertVentes.initImportation();
      this.listFiles = new ArrayList();
      this.uploadsAvailable = 1;
   }

   public void recupererTousLesItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererOptionsVentes();
      this.recupererOptionsParc(var1);
      this.recupererModelesAutorises();
      this.recupererAnnexe(var1);
      this.recupererPageGarde(var1);
      this.recupererLesIncotermsItem();
      this.recupererDevisesItem(var1);
      this.recupererFormuleItem(var1);
      this.recupererConditionnementItem(var1);
      this.recupererUniteItem(var1);
      this.recupererFactorsItem(var1);
      this.recupererBanquesItem(var1);
      this.recupererFamillesClientItem();
      this.recupererTypesReglementsItem();
      this.recupererCaisses(var1);
      this.chargerMesCodesTaxeVnt(var1);
      this.recupererBudgetItem(var1);
      this.recupererActiviteItem(var1);
      this.recupererDossierItem(var1);
      this.recupererServiceItem(var1);
      this.recupererLesRegionItem(var1);
      this.recupererLesSiteItem(var1);
      this.verifBareme(var1);
   }

   public void recupererLesItemsDoc(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererSerieUserItem(var1);
      this.recupererModeleDocument();
      this.recupererModeleListe();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
      this.recupererHabilitation(var1);
      this.recupererDepotItem(var1, this.nature);
      this.recupererSourceListe(var1);
   }

   public void recupererLesItemsDocCampagne(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererSerieUserItem(var1);
      this.recupererModeleDocument();
      this.recupererModeleListe();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
      this.recupererHabilitation(var1);
      this.recupererPdvItem(var1);
   }

   public void recupererLesItemsProd(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererLesNaturesItem();
      this.recupererFamilleProduitAchatsUtilItem(var1);
      this.recupererFamilleProduitVentesUtilItem(var1);
      this.recupererFamillesGlobal();
      this.recupererDepotItem(var1, 0);
      this.chargerMesCodesTaxeVnt(var1);
      this.chargerMesCompte(var1);
      this.chargerMesDouanes(var1);
      this.recupererLesMarquesItem(var1);
      this.recupererCouleursItem(var1);
      this.chargerMesClesRepartition(var1);
      this.recupererModeleFicheProduit();
      this.recupererModeleListeProduit();
      this.recupererModeleListeMouvements();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void recupererLesItemsImpression(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererLesRegionItem(var1);
      this.recupererLesSiteItem(var1);
      this.recupererLesCommerciauxItem(var1);
      this.recupererLesCreateurItem(var1);
      this.recupererFamilleProduitVentesItem(var1);
      this.recupererFamilleProduitAchatsItem(var1);
      this.recupererFamillesGlobal();
      this.recupererDepotItem(var1, 0);
      this.recupererSourceListe(var1);
   }

   public void verifBareme(Session var1) {
      boolean var2 = false;
      Object var3 = var1.createQuery("SELECT COUNT(*) FROM Baremes").uniqueResult();
      int var4 = Integer.parseInt(var3.toString());
      if (var4 > 0) {
         this.verifBareme = true;
      } else {
         this.verifBareme = false;
      }

   }

   public void recupererOptionsVentes() {
      this.optionsVentes = new OptionVentes();
      LireLesoptionsVentes var1 = new LireLesoptionsVentes();
      var1.setStrId(this.structureLog.getStrid());
      this.optionsVentes = var1.lancer();
      if (this.optionsVentes.getImpPoids().equals("1")) {
         this.poidsAff = true;
      } else {
         this.poidsAff = false;
      }

   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

   }

   public void recupererOptionsParc(Session var1) throws HibernateException, NamingException {
      boolean var2 = this.rechercheModule(70000);
      this.mesParcsItems = new ArrayList();
      if (var2) {
         this.optionParcs = new OptionParcs();
         LireLesoptionsParcs var3 = new LireLesoptionsParcs();
         var3.setStrId(this.structureLog.getStrid());
         this.optionParcs = var3.lancer();
         if (this.optionParcs != null && this.optionParcs.getType() != null && !this.optionParcs.getType().isEmpty() && this.optionParcs.getType().equals("0")) {
            ParcDao var4 = new ParcDao(this.baseLog, this.utilInitHibernate);
            this.mesParcsItems = var4.chargerLesParcs(var1);
         }
      } else {
         this.optionParcs = null;
      }

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

   public void recupererAnnexe(Session var1) throws HibernateException, NamingException {
      this.annexItems = new ArrayList();
      ModelesCourriersDao var2 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.annexItems = var2.chargerLesModeles(21, "0", var1);
   }

   public void recupererPageGarde(Session var1) throws HibernateException, NamingException {
      this.pageGardeItems = new ArrayList();
      ModelesCourriersDao var2 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.pageGardeItems = var2.chargerLesModeles(20, "0", var1);
   }

   public void recupererLesIncotermsItem() {
      LectureIncoterm var1 = new LectureIncoterm();
      this.mesIncotermesItems = var1.getMesIncotermActifsItems();
   }

   public void recupererDevisesItem(Session var1) throws HibernateException, NamingException {
      this.mesdevisesItem = new ArrayList();
      DeviseDao var2 = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.mesdevisesItem = var2.chargerLesDevisesUtiliseesItem(this.structureLog, var1);
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

      ActivitesDao var2 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      if (this.decoupageActivite) {
         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            this.laColonne1Items = var2.chargerLesDecoupages(this.structureLog.getStrCode1(), var1);
         }

         if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
            this.laColonne2Items = var2.chargerLesDecoupages(this.structureLog.getStrCode2(), var1);
         }

         if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
            this.laColonne3Items = var2.chargerLesDecoupages(this.structureLog.getStrCode3(), var1);
         }
      } else {
         this.mesActivitesItems = var2.chargerLesActivites(var1);
      }

   }

   public void recupererBudgetItem(Session var1) throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      BudgetDao var2 = new BudgetDao(this.baseLog, this.utilInitHibernate);
      this.mesBudgetsItems = var2.selectAllBudget(this.lastExoCompta.getExecpt_id(), var1);
   }

   public void recupererDossierItem(Session var1) throws HibernateException, NamingException {
      this.mesDossiersItems = new ArrayList();
      if (!this.rechercheModule(80600)) {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesDossiersItems = var2.chargerLesAnalytiques("6", var1);
      }

   }

   public void recupererServiceItem(Session var1) throws HibernateException, NamingException {
      this.mesSitesItems = new ArrayList();
      this.mesDepartementsItems = new ArrayList();
      this.mesServicesItems = new ArrayList();
      if (this.usersLog.getUsrProdService() == 1 && this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         this.mesSitesItems.add(new SelectItem(this.usersLog.getUsrSite()));
         this.mesDepartementsItems.add(new SelectItem(this.usersLog.getUsrDepartement()));
         this.mesServicesItems.add(new SelectItem(this.usersLog.getUsrService()));
      } else {
         ServiceDao var2;
         if (this.rechercheModule(80400)) {
            var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
            this.mesServicesItems = var2.chargerLesServicesItems(1, false, var1);
         } else {
            var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
            this.mesServicesItems = var2.chargerLesServicesItems(1, false, var1);
         }
      }

   }

   public void recupererFormuleItem(Session var1) throws HibernateException, NamingException {
      this.mesFormulesItems = new ArrayList();
      FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
      this.mesFormulesItems = var2.chargerLesFormules(this.exoselectionne.getExevteId(), var1);
   }

   public void recupererConditionnementItem(Session var1) throws HibernateException, NamingException {
      this.mesConditionnementsItems = new ArrayList();
      ConditionnementDao var2 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
      this.mesConditionnementsItems = var2.chargerLesConditionnements(var1);
   }

   public void recupererUniteItem(Session var1) throws HibernateException, NamingException {
      this.mesUnitesItems = new ArrayList();
      UniteDao var2 = new UniteDao(this.baseLog, this.utilInitHibernate);
      this.mesUnitesItems = var2.chargerLesUnitesItems(var1);
   }

   public void recupererFactorsItem(Session var1) throws HibernateException, NamingException {
      this.mesFactorsItems = new ArrayList();
      TiersDao var2 = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.mesFactorsItems = var2.chargerLesFactorsItems(var1);
   }

   public void recupererBanquesItem(Session var1) throws HibernateException, NamingException {
      this.mesBanquesItems = new ArrayList();
      ContactDao var2 = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.mesBanquesItems = var2.chargerLesContactsBqItems(var1);
   }

   public void recupererFamillesClientItem() throws JDOMException, IOException {
      LectureFamillesClients var1 = new LectureFamillesClients();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesClientItems();
      this.mesFamilleClientsItems = var1.getMesFamillesClientsItems();
      this.lesFamilleClientsListe = var1.getMesFamillesClients();
      this.var_tarif1 = "";
      this.var_tarif2 = "";
      this.var_tarif3 = "";
      this.var_tarif4 = "";
      this.var_tarif5 = "";
      this.var_tarif6 = "";
      this.var_tarif7 = "";
      this.var_tarif8 = "";
      this.var_tarif9 = "";
      this.var_tarif10 = "";
      this.var_aff_tarif1 = false;
      this.var_aff_tarif2 = false;
      this.var_aff_tarif3 = false;
      this.var_aff_tarif4 = false;
      this.var_aff_tarif5 = false;
      this.var_aff_tarif6 = false;
      this.var_aff_tarif7 = false;
      this.var_aff_tarif8 = false;
      this.var_aff_tarif9 = false;
      this.var_aff_tarif10 = false;

      for(int var2 = 0; var2 < this.lesFamilleClientsListe.size(); ++var2) {
         if (var2 == 0) {
            this.var_tarif1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(0)).getLibelle();
            this.var_aff_tarif1 = true;
         } else if (var2 == 1) {
            this.var_tarif2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(1)).getLibelle();
            this.var_aff_tarif2 = true;
         } else if (var2 == 2) {
            this.var_tarif3 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(2)).getLibelle();
            this.var_aff_tarif3 = true;
         } else if (var2 == 3) {
            this.var_tarif4 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(3)).getLibelle();
            this.var_aff_tarif4 = true;
         } else if (var2 == 4) {
            this.var_tarif5 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(4)).getLibelle();
            this.var_aff_tarif5 = true;
         } else if (var2 == 5) {
            this.var_tarif6 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(5)).getLibelle();
            this.var_aff_tarif6 = true;
         } else if (var2 == 6) {
            this.var_tarif7 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(6)).getLibelle();
            this.var_aff_tarif7 = true;
         } else if (var2 == 7) {
            this.var_tarif8 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(7)).getLibelle();
            this.var_aff_tarif8 = true;
         } else if (var2 == 8) {
            this.var_tarif9 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(8)).getLibelle();
            this.var_aff_tarif9 = true;
         } else if (var2 == 9) {
            this.var_tarif10 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(9)).getLibelle();
            this.var_aff_tarif10 = true;
         }
      }

   }

   public void recupererTypesReglementsItem() throws JDOMException, IOException {
      LectureReglementClient var1 = new LectureReglementClient();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.recupereReglementClient();
      this.mesTypeReglements = var1.getMesReglementClientItems();
      this.lesModeReglementClientsListe = var1.getMesReglementClient();
   }

   public void recupererCaisses(Session var1) throws HibernateException, NamingException {
      this.listCaisses = new ArrayList();
      new ArrayList();
      List var2 = this.usersChronoDao.selectListCaisseByUser(this.usersLog, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if ((((UsersChrono)var2.get(var3)).getUsrchrNature() == 60 || ((UsersChrono)var2.get(var3)).getUsrchrNature() == 61) && ((UsersChrono)var2.get(var3)).getUsrchrCodeCaisse() != null && !((UsersChrono)var2.get(var3)).getUsrchrCodeCaisse().isEmpty()) {
               String var4 = ((UsersChrono)var2.get(var3)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)var2.get(var3)).getUsrchrLib();
               this.listCaisses.add(var2.get(var3));
            }
         }
      }

   }

   public void recupererSerieUserItem(Session var1) throws HibernateException, NamingException {
      this.mesSerieUserItem = new ArrayList();
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      List var2 = this.usersChronoDao.selectListByUserNat(this.usersLog, this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (this.usersLog.getUsrJrxReserve() == 1) {
               if (((UsersChrono)var2.get(var3)).getUsrchrPrive() == 0) {
                  this.mesSerieUserItem.add(new SelectItem(((UsersChrono)var2.get(var3)).getUsrchrSerie()));
               }
            } else {
               this.mesSerieUserItem.add(new SelectItem(((UsersChrono)var2.get(var3)).getUsrchrSerie()));
            }
         }

         if (this.mesSerieUserItem.size() >= 2 || this.usersLog.getUsrJrxReserve() == 0) {
            String var5 = "";

            for(int var4 = 0; var4 < this.mesSerieUserItem.size(); ++var4) {
               if (var5 != null && !var5.isEmpty()) {
                  var5 = var5 + "," + ((SelectItem)this.mesSerieUserItem.get(var4)).getValue().toString();
               } else {
                  var5 = ((SelectItem)this.mesSerieUserItem.get(var4)).getValue().toString();
               }
            }

            var5 = var5 + "," + null;
            this.mesSerieUserItem.add(new SelectItem(var5, "Toutes séries"));
         }
      }

   }

   public void recupererModeleFicheProduit() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "produit" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.documentImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleListeProduit() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "produit" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.listeImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleListeMouvements() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "mouvement" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionMvtsItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.listeImpressionMvtsItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleStock() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits" + File.separator + "ligne_ticket" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionMvtsItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.listeImpressionMvtsItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleDocument() {
      String var1 = "";
      if (this.nature == 6) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "ticket" + File.separator;
      } else if (this.nature == 7) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commission" + File.separator;
      } else if (this.nature == 8) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "simulation" + File.separator;
      } else if (this.nature == 9) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "contrat" + File.separator;
      } else if (this.nature == 20) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "besoin" + File.separator;
      } else if (this.nature == 21) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "devis" + File.separator;
      } else if (this.nature == 22) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (this.nature == 23) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "livraison" + File.separator;
      } else if (this.nature == 24) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (this.nature == 25) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (this.nature == 26) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (this.nature == 27) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (this.nature == 28) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "chargement" + File.separator;
      } else if (this.nature == 29) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "bon_encaissement" + File.separator;
      } else if (this.nature == 127) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "affaire" + File.separator;
      } else if (this.nature == 140) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "contratVente" + File.separator;
      } else if (this.nature == 141) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "campagne" + File.separator;
      } else if (this.nature == 142) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture_interne" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.documentImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleRechargement() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "rechargement" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.documentImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleDechargement() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "dechargement" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.documentImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleLettreVoiture() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "lettre_voiture" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.documentImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererModeleListe() {
      String var1 = "";
      if (this.nature == 6) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "ticket" + File.separator;
      } else if (this.nature == 7) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "commission" + File.separator;
      } else if (this.nature == 8) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "simulation" + File.separator;
      } else if (this.nature == 9) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "contrat" + File.separator;
      } else if (this.nature == 20) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "besoin" + File.separator;
      } else if (this.nature == 21) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "devis" + File.separator;
      } else if (this.nature == 22) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "commande" + File.separator;
      } else if (this.nature == 23) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "livraison" + File.separator;
      } else if (this.nature == 24) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "retour" + File.separator;
      } else if (this.nature == 25) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "facture" + File.separator;
      } else if (this.nature == 26) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "avoir" + File.separator;
      } else if (this.nature == 27) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "note_de_debit" + File.separator;
      } else if (this.nature == 28) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "chargement" + File.separator;
      } else if (this.nature == 29) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "bon_encaissement" + File.separator;
      } else if (this.nature == 127) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "affaire" + File.separator;
      } else if (this.nature == 140) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "contratVente" + File.separator;
      } else if (this.nature == 141) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "campagne" + File.separator;
      } else if (this.nature == 142) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "facture_interne" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.listeImpressionItems.add(new SelectItem(var6));
               }
            }
         }
      }

   }

   public void recupererSourceListe(Session var1) throws HibernateException, NamingException {
      this.mesSourceItems = new ArrayList();
      LectureSourcesTiers var2 = new LectureSourcesTiers(this.structureLog.getStrid());
      this.mesSourceItems = var2.getMesSourcesTiersItems();
      new ArrayList();
      CampagneEnteteVentesDao var4 = new CampagneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      List var3 = var4.rechercheCampagneActive(var1);
      if (var3.size() != 0) {
         for(int var5 = 0; var5 < var3.size(); ++var5) {
            this.mesSourceItems.add(new SelectItem(((CampagneEnteteVentes)var3.get(var5)).getCamNum() + ":" + ((CampagneEnteteVentes)var3.get(var5)).getCamObjet()));
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

   public void recupererConfigListeEntete() throws IOException {
      LectureConfigListeEntete var1 = new LectureConfigListeEntete();
      var1.recupereFonctions(this.structureLog.getStrid(), this.nature, "");
      this.configListeEntete = var1.getConfigListeEntete();
   }

   public void memoriseConfigListeEntete() throws IOException {
      LectureConfigListeEntete var1 = new LectureConfigListeEntete();
      String var2 = var1.calculeFichierConfig(this.structureLog.getStrid(), this.nature, "");
      if (var2 != null && !var2.isEmpty()) {
         Element var3 = new Element("configuration");
         Document var4 = new Document(var3);
         var3.removeContent();
         OptionConfigListe var5 = new OptionConfigListe();
         var5.setConfiguration(this.configListeEntete);
         Element var6 = new Element("configListe");
         var3.addContent(var6);
         var6.setText(var5.getConfiguration());
         XMLOutputter var7 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var8 = new FileOutputStream(StaticModePegase.getCheminContext() + var2);
         var7.output(var4, var8);
         var8.close();
      }

   }

   public void recupererConfigListeLigne() throws IOException {
      LectureConfigListeLigne var1 = new LectureConfigListeLigne();
      var1.recupereFonctions(this.structureLog.getStrid(), this.nature, "");
      this.configListeLigne = var1.getConfigListeLigne();
   }

   public void memoriseConfigListeLigne() throws IOException {
      LectureConfigListeLigne var1 = new LectureConfigListeLigne();
      String var2 = var1.calculeFichierConfig(this.structureLog.getStrid(), this.nature, "");
      if (var2 != null && !var2.isEmpty()) {
         Element var3 = new Element("configuration");
         Document var4 = new Document(var3);
         var3.removeContent();
         OptionConfigListe var5 = new OptionConfigListe();
         var5.setConfiguration(this.configListeLigne);
         Element var6 = new Element("configListe");
         var3.addContent(var6);
         var6.setText(var5.getConfiguration());
         XMLOutputter var7 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var8 = new FileOutputStream(StaticModePegase.getCheminContext() + var2);
         var7.output(var4, var8);
         var8.close();
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

   public void recupererHabilitation(Session var1) throws HibernateException, NamingException {
      this.habilitation = new Habilitation();
      if (this.usersLog.getUsrSansHabilitation() == 0) {
         HabilitationDao var2 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
         this.habilitation = var2.existenceHabilitation(this.nature, var1);
      } else {
         this.habilitation = null;
      }

   }

   public void recupererLesNaturesItem() {
      LectureNatureVentes var1 = new LectureNatureVentes();
      this.mesNaturesItems = var1.getMesNatureVentesItems();
   }

   public void recupererFamilleProduitAchatsUtilItem(Session var1) throws HibernateException, NamingException {
      this.mesFamillesAchatsItems = new ArrayList();
      this.mesFamillesAchatsUtilItems = new ArrayList();
      if (this.optionsVentes.getProduitAchat().equals("1")) {
         FamillesProduitsAchatsDao var2 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
         this.mesFamillesAchatsItems = var2.chargerFamilleProduitAchatsFamItems(this.lastExoAchats.getExeachId(), var1);
         if (this.mesFamillesAchatsItems.size() == 0) {
            this.mesFamillesAchatsItems = var2.chargerFamilleProduitAchatsUtilItems(this.lastExoAchats.getExeachId(), var1);
            this.mesFamillesAchatsUtilItems = this.mesFamillesAchatsItems;
         } else {
            this.mesFamillesAchatsUtilItems = var2.chargerFamilleProduitAchatsUtilItems(this.lastExoAchats.getExeachId(), var1);
         }
      }

   }

   public void recupererFamilleProduitVentesUtilItem(Session var1) throws HibernateException, NamingException {
      this.mesFamillesVentesItems = new ArrayList();
      this.mesFamillesVentesUtilItems = new ArrayList();
      FamillesProduitsVentesDao var2 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.mesFamillesVentesItems = var2.chargerFamilleProduitVentesFamItems(this.lastExoVentes.getExevteId(), var1);
      if (this.mesFamillesVentesItems.size() == 0) {
         this.mesFamillesVentesItems = var2.chargerFamilleProduitVentesUtilItems(this.lastExoVentes.getExevteId(), var1);
         this.mesFamillesVentesUtilItems = this.mesFamillesVentesItems;
      } else {
         this.mesFamillesVentesUtilItems = var2.chargerFamilleProduitVentesUtilItems(this.lastExoVentes.getExevteId(), var1);
      }

   }

   public void recupererFamilleProduitVentesItem(Session var1) throws HibernateException, NamingException {
      this.mesFamillesVentesItems = new ArrayList();
      FamillesProduitsVentesDao var2 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.mesFamillesVentesItems = var2.chargerFamilleProduitVentesItems(this.lastExoVentes.getExevteId(), var1);
   }

   public void recupererFamilleProduitAchatsItem(Session var1) throws HibernateException, NamingException {
      this.mesFamillesAchatsItems = new ArrayList();
      FamillesProduitsAchatsDao var2 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.mesFamillesAchatsItems = var2.chargerFamilleProduitAchatsItems(this.lastExoAchats.getExeachId(), var1);
   }

   public void recupererFamillesGlobal() {
      this.mesFamillesGlobalItems = new ArrayList();
      int var1;
      String var2;
      String[] var3;
      if (this.optionsVentes.getProduitAchat().equals("1")) {
         if (this.mesFamillesAchatsItems.size() != 0) {
            this.mesFamillesGlobalItems.add(new SelectItem("", "********* ACHATS *********"));

            for(var1 = 0; var1 < this.mesFamillesAchatsItems.size(); ++var1) {
               var2 = (String)((SelectItem)this.mesFamillesAchatsItems.get(var1)).getValue();
               if (!var2.endsWith(":")) {
                  var3 = var2.split(":");
                  this.mesFamillesGlobalItems.add(new SelectItem(var3[0], var3[0] + ":" + var3[1]));
               }
            }
         }

         this.mesFamillesGlobalItems.add(new SelectItem("", "********* VENTES *********"));

         for(var1 = 0; var1 < this.mesFamillesVentesItems.size(); ++var1) {
            var2 = (String)((SelectItem)this.mesFamillesVentesItems.get(var1)).getValue();
            if (!var2.endsWith(":")) {
               var3 = var2.split(":");
               this.mesFamillesGlobalItems.add(new SelectItem(var3[0], var3[0] + ":" + var3[1]));
            }
         }
      } else if (this.mesFamillesVentesItems.size() != 0) {
         for(var1 = 0; var1 < this.mesFamillesVentesItems.size(); ++var1) {
            var2 = (String)((SelectItem)this.mesFamillesVentesItems.get(var1)).getValue();
            if (!var2.endsWith(":")) {
               var3 = var2.split(":");
               this.mesFamillesGlobalItems.add(new SelectItem(var3[0], var3[0] + ":" + var3[1]));
            }
         }
      }

   }

   public void recupererDepotItem(Session var1, int var2) throws NamingException {
      this.listeDepotUser = "";
      if (this.usersLog.getUsrDepotSel() == 1) {
         UsersFavorisDao var3 = new UsersFavorisDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var4 = var3.chargerUsersDepot(this.usersLog, var1);
         if (var4.size() != 0) {
            for(int var5 = 0; var5 < var4.size(); ++var5) {
               if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
                  this.listeDepotUser = this.listeDepotUser + "," + ((UsersFavoris)var4.get(var5)).getUsrfavLogin();
               } else {
                  this.listeDepotUser = ((UsersFavoris)var4.get(var5)).getUsrfavLogin();
               }
            }
         }
      }

      this.mesDepotItems = new ArrayList();
      this.mesDepotCodeItems = new ArrayList();
      if (this.lastExoAchats != null) {
         DepotAchatsDao var6 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
            if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
               this.mesDepotItems = var6.selectActifDepotUsersItems(var2, this.usersLog.getUsrService(), this.listeDepotUser, var1);
            } else {
               this.mesDepotItems = var6.selectActifDepotItems(var2, this.usersLog.getUsrService(), var1);
            }
         } else if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
            this.mesDepotItems = var6.selectActifDepotUsersItems(var2, this.listeDepotUser, var1);
         } else {
            this.mesDepotItems = var6.selectActifDepotItems(var2, var1);
         }

         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
            if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
               this.mesDepotCodeItems = var6.selectActifDepotUsersCodeItems(var2, this.usersLog.getUsrService(), this.listeDepotUser, var1);
            } else {
               this.mesDepotCodeItems = var6.selectActifDepotCodeItems(var2, this.usersLog.getUsrService(), var1);
            }
         } else if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
            this.mesDepotItems = var6.selectActifDepotUsersItems(var2, this.listeDepotUser, var1);
         } else {
            this.mesDepotCodeItems = var6.selectActifDepotCodeItems(var2, var1);
         }
      }

   }

   public void chargerMesCodesTaxeVnt(Session var1) throws HibernateException, NamingException {
      this.mesTaxesItems = new ArrayList();
      this.mesTaxesItems.add(new SelectItem(0, ""));
      TaxesVentesDao var2 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectActifTaxes(this.exoselectionne.getExevteId(), var1);
      this.var_timbre = 0;
      this.var_tc_type = 0;
      this.var_tc_libelle = "";
      this.var_tc_taux = 0.0F;
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            TaxesVentes var5 = (TaxesVentes)var3.get(var4);
            if (var5.getTaxvteTimbre() != 0) {
               this.var_timbre = var5.getTaxvteTimbre();
            } else if (var5.getTaxvteTc() != 1 && var5.getTaxvteTc() != 2 && var5.getTaxvteTc() != 6 && var5.getTaxvteTc() != 7) {
               if (var5.getTaxvteCode() != null && !var5.getTaxvteCode().isEmpty()) {
                  this.mesTaxesItems.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
               }
            } else {
               this.var_tc_type = var5.getTaxvteTc();
               this.var_tc_taux = var5.getTaxvteTaux();
               if (var5.getTaxvteTc() == 1) {
                  this.var_tc_libelle = "C.A.";
               } else if (var5.getTaxvteTc() == 2) {
                  this.var_tc_libelle = "T.E.";
               } else if (var5.getTaxvteTc() == 6) {
                  this.var_tc_libelle = "AIRSI";
               } else if (var5.getTaxvteTc() == 7) {
                  this.var_tc_libelle = "C.S.S.";
               }
            }
         }
      }

   }

   public void chargerMesDouanes(Session var1) throws NamingException {
      this.mesDouanesItems = new ArrayList();
      DouanesPositionDao var2 = new DouanesPositionDao(this.baseLog, this.utilInitHibernate);
      this.mesDouanesItems = var2.listePositionsItems(this.structureLog.getStrzonecommerciale(), var1);
   }

   public void chargerMesCompte(Session var1) throws NamingException {
      this.mesCompteProduitsItems = new ArrayList();
      this.mesCompteStocksItems = new ArrayList();
      this.mesCompteVteLocItems = new ArrayList();
      this.mesCompteVteZItems = new ArrayList();
      this.mesCompteVteHzItems = new ArrayList();
      this.mesCompteCaisseItems = new ArrayList();
      if (this.lastExoCompta != null && this.lastExoCompta.getExecpt_id() != 0L) {
         String var2 = this.structureLog.getStrzonefiscale();
         if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
            long var3 = (long)(this.lastExoCompta.getExecptDateDebut().getYear() + 1900);
            long var5 = (long)(this.lastExoCompta.getExecptDateFin().getYear() + 1900);
            if (this.structureLog.getStrdatefiscale2() != null && var3 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var5 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
               var2 = this.structureLog.getStrzonefiscale2();
            } else if (this.structureLog.getStrdatefiscale2() != null && var3 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var5 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
               var2 = this.structureLog.getStrzonefiscale();
            } else {
               var2 = null;
            }
         }

         PlanComptableDao var7 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
         String var4 = "";
         var4 = "(9,17)";
         this.mesCompteProduitsItems = var7.chargerPlanCmptItems(var2, this.lastExoCompta.getExecpt_id(), var4, 0, var1);
         this.mesCompteVteLocItems = this.mesCompteProduitsItems;
         this.mesCompteVteZItems = this.mesCompteProduitsItems;
         this.mesCompteVteHzItems = this.mesCompteProduitsItems;
         var4 = "(5,9,16)";
         this.mesCompteStocksItems = var7.chargerPlanCmptItems(var2, this.lastExoCompta.getExecpt_id(), var4, 0, var1);
         var4 = "(11)";
         this.mesCompteCaisseItems = var7.chargerPlanCmptItems(var2, this.lastExoCompta.getExecpt_id(), var4, 0, var1);
      }

   }

   public void recupererLesRegionItem(Session var1) throws HibernateException, NamingException {
      this.mesRegionsItems = new ArrayList();
      RegionDao var2 = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.mesRegionsItems = var2.chargerLesRegionItems(var1);
   }

   public void recupererLesSiteItem(Session var1) throws HibernateException, NamingException {
      this.mesSitesItems = new ArrayList();
      SiteDao var2 = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.mesSitesItems = var2.chargerLesSitesItems(var1);
   }

   public void recupererPdvItem(Session var1) throws HibernateException, NamingException {
      this.mesPdvItems = new ArrayList();
      PointDeVenteDao var2 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
      this.mesPdvItems = var2.chargerLesPointDeVenteItems(var1);
   }

   public void recupererLesCommerciauxItem(Session var1) throws HibernateException, NamingException {
      UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.mesResponsablesItems = new ArrayList();
      this.mesCommerciauxItems = new ArrayList();
      if (this.optionsVentes.getResponsable() == null || this.optionsVentes.getResponsable().isEmpty()) {
         this.optionsVentes.setResponsable("0");
      }

      if (!this.optionsVentes.getResponsable().equals("1") && !this.optionsVentes.getResponsable().equals("2")) {
         this.mesResponsablesItems = var2.chargerLesUsersItem(var1);
      } else {
         new ArrayList();
         List var3 = var2.chargerLesSignataires("Ventes", var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.mesResponsablesItems.add(new SelectItem(((Users)var3.get(var4)).getUsrid(), ((Users)var3.get(var4)).getUsrNom() + ":" + ((Users)var3.get(var4)).getUsrPrenom()));
            }
         }

         new ArrayList();
         List var6 = var2.chargerLesCommerciaux(var1);
         if (var6.size() != 0) {
            for(int var5 = 0; var5 < var6.size(); ++var5) {
               this.mesCommerciauxItems.add(new SelectItem(((Users)var6.get(var5)).getUsrid(), ((Users)var6.get(var5)).getUsrNom() + ":" + ((Users)var6.get(var5)).getUsrPrenom()));
            }
         }
      }

   }

   public void recupererLesCreateurItem(Session var1) {
      this.mesCreateursItems = new ArrayList();
      this.mesCreateursItems = this.mesCommerciauxItems;
   }

   public void recupererCouleursItem(Session var1) throws HibernateException, NamingException {
      this.mesCouleursItems = new ArrayList();
      CouleurDao var2 = new CouleurDao(this.baseLog, this.utilInitHibernate);
      this.mesCouleursItems = var2.chargerLesCouleurs(var1);
   }

   public void chargerMesClesRepartition(Session var1) throws NamingException {
      this.mesClesItems = new ArrayList();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.mesClesItems = var2.chargerLesAnalytiques("9", var1);
   }

   public void recupererLesMarquesItem(Session var1) throws HibernateException, NamingException {
      this.mesMarquesItems = new ArrayList();
      MarquesDao var2 = new MarquesDao(this.baseLog, this.utilInitHibernate);
      this.mesMarquesItems = var2.chargerLesMarques(var1);
      if (this.mesMarquesItems.size() != 0) {
         this.var_marque_util = true;
      } else {
         this.var_marque_util = false;
      }

   }

   public void listener(UploadEvent var1) throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.item = var1.getUploadItem();
      this.fileCtrl = new FileCtrl();
      this.fileCtrl.setLength(this.item.getFileSize());
      this.fileCtrl.setName(this.item.getFileName());
      this.fileCtrl.setChemin(this.item.getFile().getPath().toString());
      this.fileCtrl.setData(this.item.getData());
      this.listFiles.add(this.fileCtrl);
      --this.uploadsAvailable;
      this.importationFichier();
   }

   public void importationFichier() throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      try {
         ArrayList var1 = new ArrayList();
         if (this.listFiles.size() != 0) {
            for(int var2 = 0; var2 < this.listFiles.size(); ++var2) {
               this.fileCtrl = (FileCtrl)this.listFiles.get(var2);
               String var3 = ((FileCtrl)this.listFiles.get(var2)).getName();
               File var4 = new File(this.fileCtrl.getChemin());
               if (var4.exists()) {
                  FileReader var5 = new FileReader(var4);
                  BufferedReader var6 = new BufferedReader(var5);
                  boolean var7 = false;
                  if (!var3.toString().endsWith("xls") && !var3.toString().endsWith("xlsx") && !var3.toString().endsWith("XLS") && !var3.toString().endsWith("XLSX")) {
                     for(String var8 = var6.readLine(); var8 != null; var8 = var6.readLine()) {
                        if (var8.contains("#MECG")) {
                           var7 = true;
                        }

                        if (var8.contains("\"")) {
                           char[] var9 = var8.toCharArray();
                           String var10 = "";

                           for(int var11 = 0; var11 < var9.length; ++var11) {
                              if (var9[var11] != '"') {
                                 var10 = var10 + var9[var11];
                              }
                           }

                           var8 = var10;
                        }

                        if (var7 && var8.contains(",")) {
                           var8.replace(",", ".");
                        }

                        if (var8.contains("'")) {
                           var8.replace("'", "`");
                        }

                        var1.add(var8);
                     }
                  } else {
                     var1.add(var3.toString() + ":" + var4);
                  }

                  var6.close();
                  var5.close();
               }
            }
         }

         if (var1.size() != 0) {
            this.preparationTransfertImport(var1);
         }
      } catch (IOException var12) {
         var12.printStackTrace();
      }

   }

   public void importFtp() {
   }

   public void preparationTransfertImport(List var1) throws IOException, NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.formTransfertVentes = new FormTransfertVentes();
      this.formTransfertVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertVentes.setBaseLog(this.baseLog);
      this.formTransfertVentes.setStructureLog(this.structureLog);
      this.formTransfertVentes.setUsersLog(this.usersLog);
      this.formTransfertVentes.InstancesDaoUtilses();
      this.formTransfertVentes.setOptionsVentes(this.optionsVentes);
      this.formTransfertVentes.setExercicesVentes(this.exoselectionne);
      this.formTransfertVentes.transfertImport(var1);
      this.formTransfertVentes.setFormRecherche(this.formRecherche);
      this.affichePage = "/ventes/TransfertVentes.jsp";
      this.setQuelTransfert("importExterne");
   }

   public ExercicesVentes getExoselectionne() {
      return this.exoselectionne;
   }

   public void setExoselectionne(ExercicesVentes var1) {
      this.exoselectionne = var1;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public FormAvoirVentes getFormAvoirVentes() {
      return this.formAvoirVentes;
   }

   public void setFormAvoirVentes(FormAvoirVentes var1) {
      this.formAvoirVentes = var1;
   }

   public FormBonEncaissementVente getFormBonEncaissementVente() {
      return this.formBonEncaissementVente;
   }

   public void setFormBonEncaissementVente(FormBonEncaissementVente var1) {
      this.formBonEncaissementVente = var1;
   }

   public FormCommandeVentes getFormCommandeVentes() {
      return this.formCommandeVentes;
   }

   public void setFormCommandeVentes(FormCommandeVentes var1) {
      this.formCommandeVentes = var1;
   }

   public FormDevisVentes getFormDevisVentes() {
      return this.formDevisVentes;
   }

   public void setFormDevisVentes(FormDevisVentes var1) {
      this.formDevisVentes = var1;
   }

   public FormExercicesVentes getFormExercicesVentes() {
      return this.formExercicesVentes;
   }

   public void setFormExercicesVentes(FormExercicesVentes var1) {
      this.formExercicesVentes = var1;
   }

   public FormFactureVentes getFormFactureVentes() {
      return this.formFactureVentes;
   }

   public void setFormFactureVentes(FormFactureVentes var1) {
      this.formFactureVentes = var1;
   }

   public FormLivraisonVentes getFormLivraisonVentes() {
      return this.formLivraisonVentes;
   }

   public void setFormLivraisonVentes(FormLivraisonVentes var1) {
      this.formLivraisonVentes = var1;
   }

   public FormNoteDebitVentes getFormNoteDebitVentes() {
      return this.formNoteDebitVentes;
   }

   public void setFormNoteDebitVentes(FormNoteDebitVentes var1) {
      this.formNoteDebitVentes = var1;
   }

   public FormProduitsVtes FgetFormProduitsVtes() {
      return this.formProduitsVtes;
   }

   public void setFormProduitsVtes(FormProduitsVtes var1) {
      this.formProduitsVtes = var1;
   }

   public FormRetourVentes getFormRetourVentes() {
      return this.formRetourVentes;
   }

   public void setFormRetourVentes(FormRetourVentes var1) {
      this.formRetourVentes = var1;
   }

   public ObjetLigneMenu getMenuvente() {
      return this.menuvente;
   }

   public void setMenuvente(ObjetLigneMenu var1) {
      this.menuvente = var1;
   }

   public FormImpressionVentes getFormImpressionVentes() {
      return this.formImpressionVentes;
   }

   public void setFormImpressionVentes(FormImpressionVentes var1) {
      this.formImpressionVentes = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public List getMesBudgetsItems() {
      return this.mesBudgetsItems;
   }

   public void setMesBudgetsItems(List var1) {
      this.mesBudgetsItems = var1;
   }

   public List getMesCommerciauxItems() {
      return this.mesCommerciauxItems;
   }

   public void setMesCommerciauxItems(List var1) {
      this.mesCommerciauxItems = var1;
   }

   public List getMesCompteProduitsItems() {
      return this.mesCompteProduitsItems;
   }

   public void setMesCompteProduitsItems(List var1) {
      this.mesCompteProduitsItems = var1;
   }

   public List getMesCompteStocksItems() {
      return this.mesCompteStocksItems;
   }

   public void setMesCompteStocksItems(List var1) {
      this.mesCompteStocksItems = var1;
   }

   public List getMesConditionnementsItems() {
      return this.mesConditionnementsItems;
   }

   public void setMesConditionnementsItems(List var1) {
      this.mesConditionnementsItems = var1;
   }

   public List getMesCreateursItems() {
      return this.mesCreateursItems;
   }

   public void setMesCreateursItems(List var1) {
      this.mesCreateursItems = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesDepotItems() {
      return this.mesDepotItems;
   }

   public void setMesDepotItems(List var1) {
      this.mesDepotItems = var1;
   }

   public List getMesDossiersItems() {
      return this.mesDossiersItems;
   }

   public void setMesDossiersItems(List var1) {
      this.mesDossiersItems = var1;
   }

   public List getMesFactorsItems() {
      return this.mesFactorsItems;
   }

   public void setMesFactorsItems(List var1) {
      this.mesFactorsItems = var1;
   }

   public List getMesFamilleClientsItems() {
      return this.mesFamilleClientsItems;
   }

   public void setMesFamilleClientsItems(List var1) {
      this.mesFamilleClientsItems = var1;
   }

   public List getMesFamillesVentesItems() {
      return this.mesFamillesVentesItems;
   }

   public void setMesFamillesVentesItems(List var1) {
      this.mesFamillesVentesItems = var1;
   }

   public List getMesFormulesItems() {
      return this.mesFormulesItems;
   }

   public void setMesFormulesItems(List var1) {
      this.mesFormulesItems = var1;
   }

   public List getMesIncotermesItems() {
      return this.mesIncotermesItems;
   }

   public void setMesIncotermesItems(List var1) {
      this.mesIncotermesItems = var1;
   }

   public List getMesNaturesItems() {
      return this.mesNaturesItems;
   }

   public void setMesNaturesItems(List var1) {
      this.mesNaturesItems = var1;
   }

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }

   public List getMesRegionsItems() {
      return this.mesRegionsItems;
   }

   public void setMesRegionsItems(List var1) {
      this.mesRegionsItems = var1;
   }

   public List getMesSecteursItems() {
      return this.mesSecteursItems;
   }

   public void setMesSecteursItems(List var1) {
      this.mesSecteursItems = var1;
   }

   public List getMesServices2Items() {
      return this.mesServices2Items;
   }

   public void setMesServices2Items(List var1) {
      this.mesServices2Items = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public List getMesSitesItems() {
      return this.mesSitesItems;
   }

   public void setMesSitesItems(List var1) {
      this.mesSitesItems = var1;
   }

   public List getMesTaxesItems() {
      return this.mesTaxesItems;
   }

   public void setMesTaxesItems(List var1) {
      this.mesTaxesItems = var1;
   }

   public List getMesTypeReglements() {
      return this.mesTypeReglements;
   }

   public void setMesTypeReglements(List var1) {
      this.mesTypeReglements = var1;
   }

   public List getMesUnitesItems() {
      return this.mesUnitesItems;
   }

   public void setMesUnitesItems(List var1) {
      this.mesUnitesItems = var1;
   }

   public List getMesdevisesItem() {
      return this.mesdevisesItem;
   }

   public void setMesdevisesItem(List var1) {
      this.mesdevisesItem = var1;
   }

   public List getAnnexItems() {
      return this.annexItems;
   }

   public void setAnnexItems(List var1) {
      this.annexItems = var1;
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

   public List getPageGardeItems() {
      return this.pageGardeItems;
   }

   public void setPageGardeItems(List var1) {
      this.pageGardeItems = var1;
   }

   public long getLeIdExo() {
      return this.leIdExo;
   }

   public void setLeIdExo(long var1) {
      this.leIdExo = var1;
   }

   public List getListeImpressionMvtsItems() {
      return this.listeImpressionMvtsItems;
   }

   public void setListeImpressionMvtsItems(List var1) {
      this.listeImpressionMvtsItems = var1;
   }

   public List getMesCompteVteHzItems() {
      return this.mesCompteVteHzItems;
   }

   public void setMesCompteVteHzItems(List var1) {
      this.mesCompteVteHzItems = var1;
   }

   public List getMesCompteVteLocItems() {
      return this.mesCompteVteLocItems;
   }

   public void setMesCompteVteLocItems(List var1) {
      this.mesCompteVteLocItems = var1;
   }

   public List getMesCompteVteZItems() {
      return this.mesCompteVteZItems;
   }

   public void setMesCompteVteZItems(List var1) {
      this.mesCompteVteZItems = var1;
   }

   public FormTransfertVentes getFormTransfertVentes() {
      return this.formTransfertVentes;
   }

   public void setFormTransfertVentes(FormTransfertVentes var1) {
      this.formTransfertVentes = var1;
   }

   public List getMesParcsItems() {
      return this.mesParcsItems;
   }

   public void setMesParcsItems(List var1) {
      this.mesParcsItems = var1;
   }

   public String getMessageAlerte() {
      return this.messageAlerte;
   }

   public void setMessageAlerte(String var1) {
      this.messageAlerte = var1;
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

   public FormSimulContratVentes getFormSimulContratVentes() {
      return this.formSimulContratVentes;
   }

   public void setFormSimulContratVentes(FormSimulContratVentes var1) {
      this.formSimulContratVentes = var1;
   }

   public List getMesMarquesItems() {
      return this.mesMarquesItems;
   }

   public void setMesMarquesItems(List var1) {
      this.mesMarquesItems = var1;
   }

   public boolean isVar_marque_util() {
      return this.var_marque_util;
   }

   public void setVar_marque_util(boolean var1) {
      this.var_marque_util = var1;
   }

   public List getMesCouleursItems() {
      return this.mesCouleursItems;
   }

   public void setMesCouleursItems(List var1) {
      this.mesCouleursItems = var1;
   }

   public List getMesDouanesItems() {
      return this.mesDouanesItems;
   }

   public void setMesDouanesItems(List var1) {
      this.mesDouanesItems = var1;
   }

   public List getMesClesItems() {
      return this.mesClesItems;
   }

   public void setMesClesItems(List var1) {
      this.mesClesItems = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public FormChargementVentes getFormChargementVentes() {
      return this.formChargementVentes;
   }

   public void setFormChargementVentes(FormChargementVentes var1) {
      this.formChargementVentes = var1;
   }

   public FormBesoinVentes getFormBesoinVentes() {
      return this.formBesoinVentes;
   }

   public void setFormBesoinVentes(FormBesoinVentes var1) {
      this.formBesoinVentes = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public FormCommissionsVentes getFormCommissionsVentes() {
      return this.formCommissionsVentes;
   }

   public void setFormCommissionsVentes(FormCommissionsVentes var1) {
      this.formCommissionsVentes = var1;
   }

   public FormTicketVentes getFormTicketVentes() {
      return this.formTicketVentes;
   }

   public void setFormTicketVentes(FormTicketVentes var1) {
      this.formTicketVentes = var1;
   }

   public List getMesResponsablesItems() {
      return this.mesResponsablesItems;
   }

   public void setMesResponsablesItems(List var1) {
      this.mesResponsablesItems = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public List getMesEtatsItems() {
      return this.mesEtatsItems;
   }

   public void setMesEtatsItems(List var1) {
      this.mesEtatsItems = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public List getMesSourceItems() {
      return this.mesSourceItems;
   }

   public void setMesSourceItems(List var1) {
      this.mesSourceItems = var1;
   }

   public FormContratVentes getFormContratVentes() {
      return this.formContratVentes;
   }

   public void setFormContratVentes(FormContratVentes var1) {
      this.formContratVentes = var1;
   }

   public List getMesFamillesVentesUtilItems() {
      return this.mesFamillesVentesUtilItems;
   }

   public void setMesFamillesVentesUtilItems(List var1) {
      this.mesFamillesVentesUtilItems = var1;
   }

   public FormCampagneVentes getFormCampagneVentes() {
      return this.formCampagneVentes;
   }

   public void setFormCampagneVentes(FormCampagneVentes var1) {
      this.formCampagneVentes = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public FormObjectifVentes getFormObjectifVentes() {
      return this.formObjectifVentes;
   }

   public void setFormObjectifVentes(FormObjectifVentes var1) {
      this.formObjectifVentes = var1;
   }

   public FormAffaires getFormAffaires() {
      return this.formAffaires;
   }

   public void setFormAffaires(FormAffaires var1) {
      this.formAffaires = var1;
   }

   public List getMesCompteCaisseItems() {
      return this.mesCompteCaisseItems;
   }

   public void setMesCompteCaisseItems(List var1) {
      this.mesCompteCaisseItems = var1;
   }

   public MenudroitVentesCtrl getMenudroitVentesCtrl() {
      return this.menudroitVentesCtrl;
   }

   public void setMenudroitVentesCtrl(MenudroitVentesCtrl var1) {
      this.menudroitVentesCtrl = var1;
   }

   public FormFactureInterneVentes getFormFactureInterneVentes() {
      return this.formFactureInterneVentes;
   }

   public void setFormFactureInterneVentes(FormFactureInterneVentes var1) {
      this.formFactureInterneVentes = var1;
   }

   public List getMesDepotCodeItems() {
      return this.mesDepotCodeItems;
   }

   public void setMesDepotCodeItems(List var1) {
      this.mesDepotCodeItems = var1;
   }

   public String getConfigListeEntete() {
      return this.configListeEntete;
   }

   public void setConfigListeEntete(String var1) {
      this.configListeEntete = var1;
   }

   public String getConfigListeLigne() {
      return this.configListeLigne;
   }

   public void setConfigListeLigne(String var1) {
      this.configListeLigne = var1;
   }

   public String getQuelTransfert() {
      return this.quelTransfert;
   }

   public void setQuelTransfert(String var1) {
      this.quelTransfert = var1;
   }

   public int getUploadsAvailable() {
      return this.uploadsAvailable;
   }

   public void setUploadsAvailable(int var1) {
      this.uploadsAvailable = var1;
   }

   public boolean isPoidsAff() {
      return this.poidsAff;
   }

   public void setPoidsAff(boolean var1) {
      this.poidsAff = var1;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
   }

   public long getVar_memo_id_master() {
      return this.var_memo_id_master;
   }

   public void setVar_memo_id_master(long var1) {
      this.var_memo_id_master = var1;
   }
}
