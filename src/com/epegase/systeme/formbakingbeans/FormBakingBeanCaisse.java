package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormExercicesCaisse;
import com.epegase.forms.caisse.FormBonEntreeCaiss;
import com.epegase.forms.caisse.FormBonSortieCaiss;
import com.epegase.forms.caisse.FormCaissesInventaire;
import com.epegase.forms.caisse.FormCaissesPrevision;
import com.epegase.forms.caisse.FormImpressionCaisse;
import com.epegase.forms.caisse.FormJournauxCaisse;
import com.epegase.forms.caisse.FormRegCaisse;
import com.epegase.forms.caisse.FormTraite;
import com.epegase.forms.caisse.FormTransfertCaisse;
import com.epegase.forms.caisse.FormVirementInterne;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.CampagneEnteteVentes;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CampagneEnteteVentesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitCaisseCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureReglementClient;
import com.epegase.systeme.xml.LectureTypeReglement;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionConfigListe;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.FileOutputStream;
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
import org.xml.sax.SAXException;

public class FormBakingBeanCaisse implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private MenudroitCaisseCtrl menudroitCaisseCtrl;
   private OptionCaisses optionCaisses;
   private OptionVentes optionVentes;
   private OptionComptabilite optionComptabilite;
   private LectureModulesOnglets lesOnglets;
   private LireLesoptionsCaisses lireLesoptionsCaisses;
   private LireLesoptionsVentes lireLesoptionsVentes;
   private LireLesoptionsCompta lireLesoptionsCompta;
   private FormExercicesCaisse formExercicesCaisse;
   private ExercicesCaisse exoselectionne = new ExercicesCaisse();
   private ExercicesCaisse lastExercice = new ExercicesCaisse();
   private ObjetLigneMenu menucaisse;
   private ObjetLigneMenu menucaisseMemo = new ObjetLigneMenu();
   private int nature;
   private long leIdExo;
   private Habilitation habilitation;
   private List mesClesItems;
   private List mesActivitesItems;
   private List mesBudgetsItems;
   private List mesSitesItems;
   private List mesRegionsItems;
   private List mesDossiersItems;
   private List mesParcsItems;
   private List mesServiceItem;
   private List mesTypeReglementsItem;
   private List mesTypeReglementsClientItem;
   private List mesdevisesItem;
   private List mesBanquesItems;
   private List mesBanquesEmetteursItems;
   private List mesBanquesRecepteursItems;
   private List mesBanquesCaissesItems;
   private List mesSeriesUsersItem;
   private List mesOperationsItems;
   private List listeImpressionItems;
   private List modeleImpressionItems;
   private List mesResponsablesItems;
   private List mesSourceItems;
   private List listCaisses;
   private ExercicesComptable exercicesComptable = new ExercicesComptable();
   private ExercicesAchats exercicesAchats = new ExercicesAchats();
   private ExercicesVentes exercicesVentes = new ExercicesVentes();
   private DeviseDao deviseDao;
   private JournauxComptablesDao journauxComptablesDao;
   private ServiceDao serviceDao;
   private ActivitesDao activitesDao;
   private BudgetDao budgetDao;
   private SiteDao siteDao;
   private RegionDao regionDao;
   private PlansAnalytiquesDao analytiqueDao;
   private CaissesCommercialesDao caissesCommercialesDao;
   private UserDao userDao;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private String messageAlerte;
   private FormRegCaisse formRegCaisse;
   private FormBonSortieCaiss formBonSortieCaiss;
   private FormBonEntreeCaiss formBonEntreeCaiss;
   private FormVirementInterne formVirementInterne;
   private FormImpressionCaisse formImpressionCaisse;
   private FormTransfertCaisse formTransfertCaisse;
   private FormJournauxCaisse formJournauxCaisse;
   private FormTraite formTraite;
   private FormCaissesInventaire formCaissesInventaire;
   private FormCaissesPrevision formCaissesPrevision;
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
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

   public void InstancesDaoUtilses() {
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.regionDao = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.analytiqueDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.budgetDao = new BudgetDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.deviseDao = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererExercices(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      ExercicesCaisseDao var2 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      this.leIdExo = this.exoselectionne.getExecaiId();
      this.lastExercice = var2.recupererLastExo(var1);
      ExercicesComptableDao var3 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.exercicesComptable = var3.recupererLastExo(var1);
      ExercicesAchatsDao var4 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.exercicesAchats = var4.recupererLastExo(var1);
      ExercicesVentesDao var5 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentes = var5.recupererLastExo(var1);
   }

   public void recupererLeIdExo() throws HibernateException, NamingException {
      this.recupererLeIdExo((Session)null);
   }

   public ExercicesCaisse recupererLeIdExo(Session var1) throws NamingException {
      ExercicesCaisseDao var2 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
      if (this.leIdExo != 0L) {
         this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      } else {
         this.exoselectionne = var2.recupererLastExo(var1);
      }

      this.leIdExo = this.exoselectionne.getExecaiId();
      return this.exoselectionne;
   }

   public List getLesExerciceCaisse(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesCaisse = new FormExercicesCaisse();
      this.formExercicesCaisse.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesCaisse.setBaseLog(this.baseLog);
      this.formExercicesCaisse.setStructureLog(this.structureLog);
      this.formExercicesCaisse.setUsersLog(this.usersLog);
      this.formExercicesCaisse.InstancesDaoUtilses();
      return this.formExercicesCaisse.recupererLesexercices(var1);
   }

   public void menuGaucheCaisse() throws JDOMException, IOException {
      if (this.menudroitCaisseCtrl == null) {
         this.menudroitCaisseCtrl = new MenudroitCaisseCtrl();
         this.menudroitCaisseCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitCaisseCtrl.chargerMenudroitCaisseXml(this.usersLog.getUsrCollaboration());
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("90000", this.usersLog.getUsrCollaboration());
   }

   public void menuGaucheCaisseGuest() throws JDOMException, IOException {
      if (this.menudroitCaisseCtrl == null) {
         this.menudroitCaisseCtrl = new MenudroitCaisseCtrl();
         this.menudroitCaisseCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitCaisseCtrl.chargerMenuGaucheCaisseGuestXml(this.structureLog);
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("90100", this.usersLog.getUsrCollaboration());
   }

   public void razMemoire() {
      this.formBonEntreeCaiss = null;
      this.formBonSortieCaiss = null;
      this.formCaissesInventaire = null;
      this.formImpressionCaisse = null;
      this.formJournauxCaisse = null;
      this.formRegCaisse = null;
      this.formTraite = null;
      this.formTransfertCaisse = null;
      this.formVirementInterne = null;
   }

   public void gestionCaisse() throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.menucaisse = new ObjetLigneMenu();
      if (this.menudroitCaisseCtrl.getDataModelMenudroitCaisseXmlList().isRowAvailable()) {
         this.menucaisse = (ObjetLigneMenu)this.menudroitCaisseCtrl.getDataModelMenudroitCaisseXmlList().getRowData();
         if (this.menucaisse.getLibelle_FR() != null && !this.menucaisse.getLibelle_FR().isEmpty()) {
            this.menucaisseMemo = this.menucaisse;
            this.aiguillageCaisse();
         }
      }

   }

   public void gestionCaisseFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, ParseException {
      this.menucaisse = var1;
      this.menucaisseMemo = this.menucaisse;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheCaisse();
      }

      this.aiguillageCaisse();
   }

   public void aiguillageCaisse() throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      if (this.lastExercice.getExecaiId() != this.exoselectionne.getExecaiId()) {
         this.menucaisse.setAdd(false);
         this.menucaisse.setMaj(false);
         this.menucaisse.setSup(false);
         this.menucaisse.setDup(false);
         this.menucaisse.setClo(false);
         this.menucaisse.setTrf(false);
         this.menucaisse.setImp(true);
      } else {
         this.menucaisse.setAdd(this.menucaisseMemo.isAdd());
         this.menucaisse.setMaj(this.menucaisseMemo.isMaj());
         this.menucaisse.setSup(this.menucaisseMemo.isSup());
         this.menucaisse.setDup(this.menucaisseMemo.isDup());
         this.menucaisse.setClo(this.menucaisseMemo.isClo());
         this.menucaisse.setTrf(this.menucaisseMemo.isTrf());
         this.menucaisse.setImp(this.menucaisseMemo.isImp());
      }

      this.razMemoire();
      Session var1;
      String var2;
      if (this.menucaisse.getCommande().equalsIgnoreCase("90000:01")) {
         this.nature = 60;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 61, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/DocumentsEncoursInit.jsp";
               this.menuCaisseEnCours(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/caisse/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:10")) {
         this.nature = 600;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, 60, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 60, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/JournauxJournaliersInit.jsp";
               this.menuJournauxJournaliers(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/caisse/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:11")) {
         this.nature = 600;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, 60, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 60, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/JournauxMensuelsInit.jsp";
               this.menuJournauxMensuels(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/caisse/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:12")) {
         this.nature = 68;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 60, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/CaissesInventaireInit.jsp";
               this.menuInventaireCaisse(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/caisse/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:13")) {
         this.nature = 69;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 60, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/PrevisionnelInit.jsp";
               this.menuObjectifTresorerie(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/caisse/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:02")) {
         this.nature = 62;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/BonSortieInit.jsp";
               this.menuBonSortie(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/caisse/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:03")) {
         this.nature = 63;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/BonEntreeInit.jsp";
               this.menuBonEntree(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/caisse/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:04")) {
         this.nature = 64;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/VirementInterneInit.jsp";
               this.menuVirementInterne(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/caisse/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:05")) {
         this.nature = 65;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/TraiteInit.jsp";
               this.menuTraiteDomiciliee(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/caisse/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:06")) {
         this.nature = 66;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/TraiteInit.jsp";
               this.menuTraiteSimplifiee(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/caisse/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:07")) {
         this.nature = 67;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/TraiteInit.jsp";
               this.menuTraiteEntreprise(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/caisse/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:90")) {
         this.affichePage = "/caisse/ImpressionCaisse.jsp";
         this.menuImpressionCaisse();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:98")) {
         this.affichePage = "/caisse/TransfertCaisse.jsp";
         this.menuTransfertCaisse();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90000:99")) {
         this.affichePage = "/caisse/SelectionExercicesCaisse.jsp";
         this.menuSelectionExercicesCaisse();
      } else if (this.menucaisse.getCommande().equalsIgnoreCase("90100:02")) {
         this.nature = 62;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviCaisse");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono == null) {
               this.chrono = this.chronoDao.chronoBySerieNat((String)null, this.nature, var2, var1);
            }

            if (this.chrono != null) {
               this.affichePage = "/caisse/BonSortieInit.jsp";
               this.menuMesBonSortie(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat((String)null, this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/caisse/BonSortieInit.jsp";
               this.menuMesBonSortie(var1);
            } else {
               this.affichePage = "/caisse/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void menuCaisseEnCours(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formRegCaisse = new FormRegCaisse();
      this.formRegCaisse.setutilInitHibernate(this.utilInitHibernate);
      this.formRegCaisse.setBaseLog(this.baseLog);
      this.formRegCaisse.setStructureLog(this.structureLog);
      this.formRegCaisse.setUsersLog(this.usersLog);
      this.formRegCaisse.InstancesDaoUtilses();
      this.formRegCaisse.setNature(this.nature);
      this.formRegCaisse.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formRegCaisse.setOptionCaisses(this.optionCaisses);
      this.formRegCaisse.setOptionVentes(this.optionVentes);
      this.formRegCaisse.setOptionComptabilite(this.optionComptabilite);
      this.formRegCaisse.setSelectedExo(this.exoselectionne);
      this.formRegCaisse.setLastExo(this.lastExercice);
      this.formRegCaisse.setExercicesAchats(this.exercicesAchats);
      this.formRegCaisse.setExercicesVentes(this.exercicesVentes);
      this.formRegCaisse.setExercicesComptable(this.exercicesComptable);
      this.formRegCaisse.setUsersChrono(this.usersChrono);
      this.recupererSerieUserItem(this.nature, var1);
      this.recupererLesItemsDocs(var1);
      this.formRegCaisse.accesResteintUser();
      this.formRegCaisse.accesResteintGroupe();
      this.formRegCaisse.setInpEtat(1);
      this.formRegCaisse.setInpService("100");
      this.formRegCaisse.setListCaisses(this.listCaisses);
      this.formRegCaisse.configCaisses(var1);
      this.formRegCaisse.setFormRecherche(this.formRecherche);
      this.formRegCaisse.setMesModeReglements(this.mesTypeReglementsClientItem);
      this.formRegCaisse.calculerLesDecoupagesActivites(var1);
      this.formRegCaisse.setTypeVente(this.typeVente);
      this.formRegCaisse.recupererMoisEnCours(var1);
   }

   public void menuJournauxJournaliers(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formJournauxCaisse = new FormJournauxCaisse();
      this.formJournauxCaisse.setutilInitHibernate(this.utilInitHibernate);
      this.formJournauxCaisse.setBaseLog(this.baseLog);
      this.formJournauxCaisse.setStructureLog(this.structureLog);
      this.formJournauxCaisse.setUsersLog(this.usersLog);
      this.formJournauxCaisse.InstancesDaoUtilses();
      this.formJournauxCaisse.setNature(60);
      this.formJournauxCaisse.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formJournauxCaisse.setOptionCaisses(this.optionCaisses);
      this.formJournauxCaisse.setSelectedExo(this.exoselectionne);
      this.formJournauxCaisse.setLastExo(this.lastExercice);
      this.recupererSerieUserItem(this.nature, var1);
      this.recupererLesItemsDocs(var1);
      this.formJournauxCaisse.accesResteintUser();
      this.formJournauxCaisse.accesResteintGroupe();
      this.formJournauxCaisse.configCaisses(var1);
      this.formJournauxCaisse.chargerCaisseCommerciale(var1);
      this.formJournauxCaisse.calculPeriode();
      this.formJournauxCaisse.setModeJournal(0);
      this.formJournauxCaisse.setTypeVente(this.typeVente);
      this.formJournauxCaisse.setMesModeReglements(this.mesTypeReglementsClientItem);
   }

   public void menuJournauxMensuels(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formJournauxCaisse = new FormJournauxCaisse();
      this.formJournauxCaisse.setutilInitHibernate(this.utilInitHibernate);
      this.formJournauxCaisse.setBaseLog(this.baseLog);
      this.formJournauxCaisse.setStructureLog(this.structureLog);
      this.formJournauxCaisse.setUsersLog(this.usersLog);
      this.formJournauxCaisse.InstancesDaoUtilses();
      this.formJournauxCaisse.setNature(60);
      this.formJournauxCaisse.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formJournauxCaisse.setOptionCaisses(this.optionCaisses);
      this.formJournauxCaisse.setSelectedExo(this.exoselectionne);
      this.formJournauxCaisse.setLastExo(this.lastExercice);
      this.recupererSerieUserItem(this.nature, var1);
      this.recupererLesItemsDocs(var1);
      this.formJournauxCaisse.accesResteintUser();
      this.formJournauxCaisse.accesResteintGroupe();
      this.formJournauxCaisse.configCaisses(var1);
      this.formJournauxCaisse.chargerCaisseCommerciale(var1);
      this.formJournauxCaisse.calculPeriode();
      this.formJournauxCaisse.setModeJournal(1);
      this.formJournauxCaisse.setMesModeReglements(this.mesTypeReglementsClientItem);
   }

   public void menuInventaireCaisse(Session var1) throws HibernateException, NamingException, IOException, JDOMException, ParseException {
      this.formCaissesInventaire = new FormCaissesInventaire();
      this.formCaissesInventaire.setutilInitHibernate(this.utilInitHibernate);
      this.formCaissesInventaire.setBaseLog(this.baseLog);
      this.formCaissesInventaire.setStructureLog(this.structureLog);
      this.formCaissesInventaire.setUsersLog(this.usersLog);
      this.formCaissesInventaire.InstancesDaoUtilses();
      this.formCaissesInventaire.setNature(this.nature);
      this.formCaissesInventaire.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCaissesInventaire.setOptionCaisses(this.optionCaisses);
      this.formCaissesInventaire.configCaisses(var1);
      this.formCaissesInventaire.setSelectedExo(this.exoselectionne);
      this.formCaissesInventaire.setLastExo(this.lastExercice);
      this.recupererSerieUserItem(this.nature, var1);
      this.recupererLesItemsDocs(var1);
      this.formCaissesInventaire.accesResteintUser();
      this.formCaissesInventaire.accesResteintGroupe();
      this.formCaissesInventaire.setInpEtat(0);
      this.formCaissesInventaire.setInpService("100");
   }

   public void menuObjectifTresorerie(Session var1) throws HibernateException, NamingException, IOException, JDOMException, ParseException {
      this.formCaissesPrevision = new FormCaissesPrevision();
      this.formCaissesPrevision.setutilInitHibernate(this.utilInitHibernate);
      this.formCaissesPrevision.setBaseLog(this.baseLog);
      this.formCaissesPrevision.setStructureLog(this.structureLog);
      this.formCaissesPrevision.setUsersLog(this.usersLog);
      this.formCaissesPrevision.InstancesDaoUtilses();
      this.formCaissesPrevision.setNature(this.nature);
      this.formCaissesPrevision.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCaissesPrevision.setOptionCaisses(this.optionCaisses);
      this.formCaissesPrevision.setSelectedExo(this.exoselectionne);
      this.formCaissesPrevision.setLastExo(this.lastExercice);
      this.formCaissesPrevision.configCaisses(var1);
      this.recupererSerieUserItem(this.nature, var1);
      this.recupererLesItemsDocs(var1);
      this.formCaissesPrevision.accesResteintUser();
      this.formCaissesPrevision.accesResteintGroupe();
      this.formCaissesPrevision.setInpEtat(0);
      this.formCaissesPrevision.setFormRecherche(this.formRecherche);
      this.formCaissesPrevision.setTypeVente(this.typeVente);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuBonSortie(Session var1) throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.formBonSortieCaiss = new FormBonSortieCaiss();
      this.formBonSortieCaiss.setutilInitHibernate(this.utilInitHibernate);
      this.formBonSortieCaiss.setBaseLog(this.baseLog);
      this.formBonSortieCaiss.setStructureLog(this.structureLog);
      this.formBonSortieCaiss.setUsersLog(this.usersLog);
      this.formBonSortieCaiss.InstancesDaoUtilses();
      this.formBonSortieCaiss.setNature(this.nature);
      this.formBonSortieCaiss.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formBonSortieCaiss.setOptionCaisses(this.optionCaisses);
      this.formBonSortieCaiss.setSelectedExo(this.exoselectionne);
      this.formBonSortieCaiss.setLastExo(this.lastExercice);
      this.formBonSortieCaiss.setExercicesComptable(this.exercicesComptable);
      this.formBonSortieCaiss.setOptionComptabilite(this.optionComptabilite);
      this.recupererSerieUserItem(this.nature, var1);
      this.recupererLesItemsDocs(var1);
      this.formBonSortieCaiss.accesResteintUser();
      this.formBonSortieCaiss.accesResteintGroupe();
      this.formBonSortieCaiss.setInpEtat(0);
      this.formBonSortieCaiss.setInpService("100");
      this.formBonSortieCaiss.setListCaisses(this.listCaisses);
      this.formBonSortieCaiss.configCaisses(var1);
      this.formBonSortieCaiss.recupererMoisEnCours(var1);
      this.formBonSortieCaiss.setHabilitation(this.habilitation);
      this.formBonSortieCaiss.setFormRecherche(this.formRecherche);
      this.formBonSortieCaiss.calculerLesDecoupagesActivites(var1);
      this.formBonSortieCaiss.setTypeVente(this.typeVente);
   }

   public void menuBonEntree(Session var1) throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.formBonEntreeCaiss = new FormBonEntreeCaiss();
      this.formBonEntreeCaiss.setutilInitHibernate(this.utilInitHibernate);
      this.formBonEntreeCaiss.setBaseLog(this.baseLog);
      this.formBonEntreeCaiss.setStructureLog(this.structureLog);
      this.formBonEntreeCaiss.setUsersLog(this.usersLog);
      this.formBonEntreeCaiss.InstancesDaoUtilses();
      this.formBonEntreeCaiss.setNature(this.nature);
      this.formBonEntreeCaiss.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formBonEntreeCaiss.setOptionCaisses(this.optionCaisses);
      this.formBonEntreeCaiss.setSelectedExo(this.exoselectionne);
      this.formBonEntreeCaiss.setLastExo(this.lastExercice);
      this.formBonEntreeCaiss.setExercicesComptable(this.exercicesComptable);
      this.recupererSerieUserItem(this.nature, var1);
      this.recupererLesItemsDocs(var1);
      this.formBonEntreeCaiss.accesResteintUser();
      this.formBonEntreeCaiss.accesResteintGroupe();
      this.formBonEntreeCaiss.setInpEtat(0);
      this.formBonEntreeCaiss.setInpService("100");
      this.formBonEntreeCaiss.setListCaisses(this.listCaisses);
      this.formBonEntreeCaiss.configCaisses(var1);
      this.formBonEntreeCaiss.recupererMoisEnCours(var1);
      this.formBonEntreeCaiss.setHabilitation(this.habilitation);
      this.formBonEntreeCaiss.setFormRecherche(this.formRecherche);
      this.formBonEntreeCaiss.calculerLesDecoupagesActivites(var1);
      this.formBonEntreeCaiss.setTypeVente(this.typeVente);
   }

   public void menuVirementInterne(Session var1) throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.formVirementInterne = new FormVirementInterne();
      this.formVirementInterne.setutilInitHibernate(this.utilInitHibernate);
      this.formVirementInterne.setBaseLog(this.baseLog);
      this.formVirementInterne.setStructureLog(this.structureLog);
      this.formVirementInterne.setUsersLog(this.usersLog);
      this.formVirementInterne.InstancesDaoUtilses();
      this.formVirementInterne.setNature(this.nature);
      this.formVirementInterne.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formVirementInterne.setOptionCaisses(this.optionCaisses);
      this.formVirementInterne.setSelectedExo(this.exoselectionne);
      this.formVirementInterne.setLastExo(this.lastExercice);
      this.formVirementInterne.setExercicesComptable(this.exercicesComptable);
      this.recupererSerieUserItem(this.nature, var1);
      this.recupererLesItemsDocs(var1);
      this.formVirementInterne.accesResteintUser();
      this.formVirementInterne.accesResteintGroupe();
      this.formVirementInterne.setInpEtat(0);
      this.formVirementInterne.setInpService("100");
      this.formVirementInterne.setListCaisses(this.listCaisses);
      this.formVirementInterne.configCaisses(var1);
      this.formVirementInterne.recupererMoisEnCours(var1);
      this.formVirementInterne.setHabilitation(this.habilitation);
      this.formVirementInterne.setFormRecherche(this.formRecherche);
      this.formVirementInterne.calculerLesDecoupagesActivites(var1);
      this.formVirementInterne.setTypeVente(this.typeVente);
   }

   public void menuTraiteDomiciliee(Session var1) throws HibernateException, NamingException, IOException, JDOMException {
      this.formTraite = new FormTraite();
      this.formTraite.setutilInitHibernate(this.utilInitHibernate);
      this.formTraite.setBaseLog(this.baseLog);
      this.formTraite.setStructureLog(this.structureLog);
      this.formTraite.setUsersLog(this.usersLog);
      this.formTraite.InstancesDaoUtilses();
      this.formTraite.setNature(this.nature);
      this.formTraite.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formTraite.setOptionCaisses(this.optionCaisses);
      this.formTraite.configCaisses(var1);
      this.formTraite.setSelectedExo(this.exoselectionne);
      this.formTraite.setLastExo(this.lastExercice);
      this.recupererSerieUserItem(this.nature, var1);
      this.recupererLesItemsDocs(var1);
      this.formTraite.accesResteintUser();
      this.formTraite.accesResteintGroupe();
      this.formTraite.setInpEtat(0);
      this.formTraite.setInpService("100");
      this.formTraite.setNomRepMod("traite1");
      this.formTraite.setVar_intitule("GESTION DES TRAITES DOMICILEES");
      this.formTraite.setFormRecherche(this.formRecherche);
      this.formTraite.setTypeVente(this.typeVente);
   }

   public void menuTraiteSimplifiee(Session var1) throws HibernateException, NamingException, IOException, JDOMException {
      this.formTraite = new FormTraite();
      this.formTraite.setutilInitHibernate(this.utilInitHibernate);
      this.formTraite.setBaseLog(this.baseLog);
      this.formTraite.setStructureLog(this.structureLog);
      this.formTraite.setUsersLog(this.usersLog);
      this.formTraite.InstancesDaoUtilses();
      this.formTraite.setNature(this.nature);
      this.formTraite.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formTraite.setOptionCaisses(this.optionCaisses);
      this.formTraite.configCaisses(var1);
      this.formTraite.setSelectedExo(this.exoselectionne);
      this.formTraite.setLastExo(this.lastExercice);
      this.recupererSerieUserItem(this.nature, var1);
      this.recupererLesItemsDocs(var1);
      this.formTraite.accesResteintUser();
      this.formTraite.accesResteintGroupe();
      this.formTraite.setInpEtat(0);
      this.formTraite.setInpService("100");
      this.formTraite.setNomRepMod("traite2");
      this.formTraite.setVar_intitule("GESTION DES TRAITES SIMPLIFIEES");
      this.formTraite.setFormRecherche(this.formRecherche);
      this.formTraite.setTypeVente(this.typeVente);
   }

   public void menuTraiteEntreprise(Session var1) throws HibernateException, NamingException, IOException, JDOMException {
      this.formTraite = new FormTraite();
      this.formTraite.setutilInitHibernate(this.utilInitHibernate);
      this.formTraite.setBaseLog(this.baseLog);
      this.formTraite.setStructureLog(this.structureLog);
      this.formTraite.setUsersLog(this.usersLog);
      this.formTraite.InstancesDaoUtilses();
      this.formTraite.setNature(this.nature);
      this.formTraite.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formTraite.setOptionCaisses(this.optionCaisses);
      this.formTraite.configCaisses(var1);
      this.formTraite.setSelectedExo(this.exoselectionne);
      this.formTraite.setLastExo(this.lastExercice);
      this.recupererSerieUserItem(this.nature, var1);
      this.recupererLesItemsDocs(var1);
      this.formTraite.accesResteintUser();
      this.formTraite.accesResteintGroupe();
      this.formTraite.setInpEtat(0);
      this.formTraite.setInpService("100");
      this.formTraite.setNomRepMod("traite3");
      this.formTraite.setVar_intitule("GESTION DES TRAITES ENTREPRISES");
      this.formTraite.setFormRecherche(this.formRecherche);
      this.formTraite.setTypeVente(this.typeVente);
   }

   public void menuImpressionCaisse() throws ParseException {
      this.formImpressionCaisse = new FormImpressionCaisse();
      this.formImpressionCaisse.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionCaisse.setBaseLog(this.baseLog);
      this.formImpressionCaisse.setStructureLog(this.structureLog);
      this.formImpressionCaisse.setUsersLog(this.usersLog);
      this.formImpressionCaisse.InstancesDaoUtilses();
      this.formImpressionCaisse.setExoSelectionne(this.exoselectionne);
      this.formImpressionCaisse.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionCaisse.setListCaisses(this.listCaisses);
      this.formImpressionCaisse.setOptionCaisses(this.optionCaisses);
      this.formImpressionCaisse.calculeAnalytique();
      this.formImpressionCaisse.chargerLesRepImpCaisses();
      this.formImpressionCaisse.initImpression();
      this.formImpressionCaisse.chargerPeriodes();
      this.formImpressionCaisse.setDecoupageActivite(this.decoupageActivite);
      this.formImpressionCaisse.setLaColonne1Items(this.laColonne1Items);
      this.formImpressionCaisse.setLaColonne2Items(this.laColonne2Items);
      this.formImpressionCaisse.setLaColonne3Items(this.laColonne3Items);
   }

   public void menuTransfertCaisse() throws IOException, JDOMException, HibernateException, NamingException {
      this.formTransfertCaisse = new FormTransfertCaisse();
      this.formTransfertCaisse.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertCaisse.setBaseLog(this.baseLog);
      this.formTransfertCaisse.setStructureLog(this.structureLog);
      this.formTransfertCaisse.setUsersLog(this.usersLog);
      this.formTransfertCaisse.InstancesDaoUtilses();
      this.formTransfertCaisse.setExercicesCaisse(this.exoselectionne);
      this.formTransfertCaisse.setOptionsCaisse(this.optionCaisses);
      this.formTransfertCaisse.setListCaisses(this.listCaisses);
      this.formTransfertCaisse.configTransfert();
      this.recupererOperations();
   }

   public void menuSelectionExercicesCaisse() throws IOException, JDOMException, NamingException {
      this.formExercicesCaisse = new FormExercicesCaisse();
      this.formExercicesCaisse.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesCaisse.setBaseLog(this.baseLog);
      this.formExercicesCaisse.setStructureLog(this.structureLog);
      this.formExercicesCaisse.setUsersLog(this.usersLog);
      this.formExercicesCaisse.InstancesDaoUtilses();
      this.leIdExo = this.exoselectionne.getExecaiId();
      this.formExercicesCaisse.setLesexercicesCaisse(this.formExercicesCaisse.recupererLesexercices((Session)null));
   }

   public void menuMesBonSortie(Session var1) throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (this.usersLog.getUsrCaissier() == 1 && this.usersLog.getGroupe().getGrpModuleCai() == 2) {
         this.formBonSortieCaiss = new FormBonSortieCaiss();
         this.formBonSortieCaiss.setutilInitHibernate(this.utilInitHibernate);
         this.formBonSortieCaiss.setBaseLog(this.baseLog);
         this.formBonSortieCaiss.setStructureLog(this.structureLog);
         this.formBonSortieCaiss.setUsersLog(this.usersLog);
         this.formBonSortieCaiss.InstancesDaoUtilses();
         this.formBonSortieCaiss.setNature(this.nature);
         this.formBonSortieCaiss.setMesOnglets(this.lesOnglets.getMesOnglets());
         this.formBonSortieCaiss.setOptionCaisses(this.optionCaisses);
         this.formBonSortieCaiss.setSelectedExo(this.exoselectionne);
         this.formBonSortieCaiss.setLastExo(this.lastExercice);
         this.formBonSortieCaiss.setExercicesComptable(this.exercicesComptable);
         this.formBonSortieCaiss.setOptionComptabilite(this.optionComptabilite);
         this.formBonSortieCaiss.configCaisses(var1);
         this.recupererSerieUserItem(this.nature, var1);
         this.recupererLesItemsDocs(var1);
         this.formBonSortieCaiss.accesResteintUser();
         this.formBonSortieCaiss.accesResteintGroupe();
         this.formBonSortieCaiss.setInpEtat(0);
         this.formBonSortieCaiss.setInpService("100");
         this.formBonSortieCaiss.recupererMoisEnCours(var1);
         this.formBonSortieCaiss.setHabilitation(this.habilitation);
         this.formBonSortieCaiss.setFormRecherche(this.formRecherche);
         this.formBonSortieCaiss.calculerLesDecoupagesActivites(var1);
         this.formBonSortieCaiss.setTypeVente(this.typeVente);
      }

   }

   public void recupererTousLesItems(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.recupererOptionsCaisse();
      this.recupererOptionsVentes();
      this.recupererOptionsComptabilite();
      this.recupererModelesAutorises();
      this.recupererBanques(var1, 1);
      this.recupererBanquesCaisses(var1, 2);
      this.recupererClesItem(var1);
      this.recupererActiviteItem(var1);
      this.recupererBudgetItem(var1);
      this.recupererSiteItem(var1);
      this.recupererRegionItem(var1);
      this.recupererParcItem(var1);
      this.recupererDossierItem(var1);
      this.recupererServiceItem(var1);
      this.recupererTypeReglementItem(var1);
      this.recupererDevises(var1);
      this.recupererCaisses(var1);
      this.recupererResponsables(var1);
   }

   public void recupererLesItemsDocs(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.recupererModeleListe();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
      this.recupererModeleDocument();
      this.recupererHabilitation(var1);
      this.recupererSourceListe(var1);
   }

   public void recupererOptionsCaisse() {
      this.optionCaisses = new OptionCaisses();
      this.lireLesoptionsCaisses = new LireLesoptionsCaisses();
      this.lireLesoptionsCaisses.setStrId(this.structureLog.getStrid());
      this.optionCaisses = this.lireLesoptionsCaisses.lancer();
   }

   public void recupererOptionsVentes() {
      this.optionVentes = new OptionVentes();
      this.lireLesoptionsVentes = new LireLesoptionsVentes();
      this.lireLesoptionsVentes.setStrId(this.structureLog.getStrid());
      this.optionVentes = this.lireLesoptionsVentes.lancer();
   }

   public void recupererOptionsComptabilite() throws IOException {
      this.optionComptabilite = new OptionComptabilite();
      this.lireLesoptionsCompta = new LireLesoptionsCompta(this.structureLog);
      this.lireLesoptionsCompta.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = this.lireLesoptionsCompta.lancer();
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "caisses" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "caisses" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

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

   public void recupererOperations() throws HibernateException, NamingException {
      this.mesOperationsItems = new ArrayList();
      this.mesOperationsItems.add(new SelectItem(0, "Toutes Opérations"));
      this.mesOperationsItems.add(new SelectItem(6, "6:Ticket"));
      this.mesOperationsItems.add(new SelectItem(15, "15:Facture Fournisseur"));
      this.mesOperationsItems.add(new SelectItem(16, "16:Avoir Fournisseur"));
      this.mesOperationsItems.add(new SelectItem(17, "17:Note de débit Fournisseur"));
      this.mesOperationsItems.add(new SelectItem(25, "25:Facture Client"));
      this.mesOperationsItems.add(new SelectItem(26, "26:Avoir Client"));
      this.mesOperationsItems.add(new SelectItem(27, "27:Note de débit Client"));
      this.mesOperationsItems.add(new SelectItem(60, "60:Opérations Caisse"));
      this.mesOperationsItems.add(new SelectItem(61, "61:Reçus Caisse"));
      this.mesOperationsItems.add(new SelectItem(62, "62:Bons de sortie Caisse"));
      this.mesOperationsItems.add(new SelectItem(63, "63:Bons d`entrée Caisse"));
      this.mesOperationsItems.add(new SelectItem(64, "64:Virements internes Caisse"));
   }

   public void recupererBanques(Session var1, int var2) throws HibernateException, NamingException {
      this.mesBanquesItems = new ArrayList();
      this.mesBanquesItems = this.journauxComptablesDao.chargerLesJournaux(this.exercicesComptable, var2, this.usersLog.getUsrJrxReserve(), var1);
   }

   public void recupererBanquesCaisses(Session var1, int var2) throws HibernateException, NamingException {
      this.mesBanquesCaissesItems = new ArrayList();
      this.mesBanquesRecepteursItems = new ArrayList();
      this.mesBanquesCaissesItems = this.journauxComptablesDao.chargerLesJournaux(this.exercicesComptable, var2, this.usersLog.getUsrJrxReserve(), var1);
      this.mesBanquesEmetteursItems = this.mesBanquesCaissesItems;
      this.mesBanquesRecepteursItems = this.mesBanquesCaissesItems;
   }

   public void recupererServiceItem(Session var1) throws HibernateException, NamingException {
      this.mesServiceItem = new ArrayList();
      if (this.usersLog.getUsrCaissierService() == 1 && this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         this.mesServiceItem.add(new SelectItem(this.usersLog.getUsrService()));
      } else {
         this.mesServiceItem = this.serviceDao.chargerLesServicesItems(0, false, var1);
      }

   }

   public void recupererClesItem(Session var1) throws HibernateException, NamingException {
      this.mesClesItems = new ArrayList();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.mesClesItems = var2.chargerLesAnalytiques("9", var1);
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

   public void recupererBudgetItem(Session var1) throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      this.mesBudgetsItems = this.budgetDao.selectAllBudget(this.exercicesComptable.getExecpt_id(), var1);
   }

   public void recupererSiteItem(Session var1) throws HibernateException, NamingException {
      this.mesSitesItems = new ArrayList();
      this.mesSitesItems = this.siteDao.chargerLesSitesItems(var1);
   }

   public void recupererRegionItem(Session var1) throws HibernateException, NamingException {
      this.mesRegionsItems = new ArrayList();
      this.mesRegionsItems = this.regionDao.chargerLesRegionItems(var1);
   }

   public void recupererDossierItem(Session var1) throws HibernateException, NamingException {
      this.mesDossiersItems = new ArrayList();
      this.mesDossiersItems = this.analytiqueDao.chargerLesAnalytiques("6", var1);
   }

   public void recupererParcItem(Session var1) throws HibernateException, NamingException {
      this.mesParcsItems = new ArrayList();
      this.mesParcsItems = this.analytiqueDao.chargerLesAnalytiques("8", var1);
   }

   public void recupererTypeReglementItem(Session var1) {
      this.mesTypeReglementsItem = new ArrayList();
      LectureTypeReglement var2 = new LectureTypeReglement(this.baseLog);
      this.mesTypeReglementsItem = var2.getMesTypeReglementItems();
      this.mesTypeReglementsClientItem = new ArrayList();
      LectureReglementClient var3 = new LectureReglementClient();
      var3.setStrId(this.structureLog.getStrid());
      var3.setStructureLog(this.structureLog);
      var3.recupereReglementClient();
      this.mesTypeReglementsClientItem = var3.getMesReglementClientItems();
   }

   public void recupererDevises(Session var1) throws HibernateException, NamingException {
      this.mesdevisesItem = new ArrayList();
      this.mesdevisesItem = this.deviseDao.chargerLesDevisesUtiliseesItem(this.structureLog, var1);
   }

   public void recupererResponsables(Session var1) throws HibernateException, NamingException {
      this.mesResponsablesItems = new ArrayList();
      new ArrayList();
      List var2 = this.userDao.chargerLesSignataires("Caisse", var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.mesResponsablesItems.add(new SelectItem(((Users)var2.get(var3)).getUsrid(), ((Users)var2.get(var3)).getUsrNom() + ":" + ((Users)var2.get(var3)).getUsrPrenom()));
         }
      } else {
         this.mesResponsablesItems.add(new SelectItem(0, ""));
      }

   }

   public void recupererSerieUserItem(int var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      this.mesSeriesUsersItem = new ArrayList();
      List var3 = this.usersChronoDao.selectListByUserNat(this.usersLog, var1, var2);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            if (this.usersLog.getUsrJrxReserve() == 1) {
               if (((UsersChrono)var3.get(var4)).getUsrchrPrive() == 0) {
                  this.mesSeriesUsersItem.add(new SelectItem(((UsersChrono)var3.get(var4)).getUsrchrSerie()));
               }
            } else {
               this.mesSeriesUsersItem.add(new SelectItem(((UsersChrono)var3.get(var4)).getUsrchrSerie()));
            }
         }
      }

   }

   public void recupererModeleListe() {
      String var1 = "";
      if (this.nature == 60) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "documents_liste" + File.separator;
      } else if (this.nature == 600) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "journaux" + File.separator;
      } else if (this.nature == 62) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "bons_sortie_liste" + File.separator;
      } else if (this.nature == 63) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "bons_entree_liste" + File.separator;
      } else if (this.nature == 64) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "bons_virement_liste" + File.separator;
      } else if (this.nature == 65) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "traite1" + File.separator;
      } else if (this.nature == 66) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "traite2" + File.separator;
      } else if (this.nature == 67) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "traite3" + File.separator;
      } else if (this.nature == 68) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "inventaire" + File.separator;
      } else if (this.nature == 69) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "previsionnel" + File.separator;
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

   public void recupererModeleDocument() {
      String var1 = "";
      if (this.nature == 65) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsTraites" + File.separator + "traite1" + File.separator;
      } else if (this.nature == 66) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsTraites" + File.separator + "traite2" + File.separator;
      } else if (this.nature == 67) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "documentsTraites" + File.separator + "traite3" + File.separator;
      }

      if (var1 != null && !var1.isEmpty()) {
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.modeleImpressionItems = new ArrayList();
         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4];
                  if (this.verificationAutorisation(var5)) {
                     String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                     this.modeleImpressionItems.add(new SelectItem(var6));
                  }
               }
            }
         }
      }

   }

   public void recupererSourceListe(Session var1) throws HibernateException, NamingException {
      this.mesSourceItems = new ArrayList();
      new ArrayList();
      CampagneEnteteVentesDao var3 = new CampagneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.rechercheCampagneActive(var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            this.mesSourceItems.add(new SelectItem(((CampagneEnteteVentes)var2.get(var4)).getCamNum() + ":" + ((CampagneEnteteVentes)var2.get(var4)).getCamObjet()));
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

   public FormExercicesCaisse getFormExercicesCaisse() {
      return this.formExercicesCaisse;
   }

   public void setFormExercicesCaisse(FormExercicesCaisse var1) {
      this.formExercicesCaisse = var1;
   }

   public ExercicesCaisse getLastExercice() {
      return this.lastExercice;
   }

   public void setLastExercice(ExercicesCaisse var1) {
      this.lastExercice = var1;
   }

   public LectureModulesOnglets getLesOnglets() {
      return this.lesOnglets;
   }

   public void setLesOnglets(LectureModulesOnglets var1) {
      this.lesOnglets = var1;
   }

   public MenudroitCaisseCtrl getMenudroitCaisseCtrl() {
      return this.menudroitCaisseCtrl;
   }

   public void setMenudroitCaisseCtrl(MenudroitCaisseCtrl var1) {
      this.menudroitCaisseCtrl = var1;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public ObjetLigneMenu getMenucaisse() {
      return this.menucaisse;
   }

   public void setMenucaisse(ObjetLigneMenu var1) {
      this.menucaisse = var1;
   }

   public LireLesoptionsCaisses getLireLesoptionsCaisses() {
      return this.lireLesoptionsCaisses;
   }

   public void setLireLesoptionsCaisses(LireLesoptionsCaisses var1) {
      this.lireLesoptionsCaisses = var1;
   }

   public FormRegCaisse getFormRegCaisse() {
      return this.formRegCaisse;
   }

   public void setFormRegCaisse(FormRegCaisse var1) {
      this.formRegCaisse = var1;
   }

   public FormBonSortieCaiss getFormBonSortieCaiss() {
      return this.formBonSortieCaiss;
   }

   public void setFormBonSortieCaiss(FormBonSortieCaiss var1) {
      this.formBonSortieCaiss = var1;
   }

   public FormBonEntreeCaiss getFormBonEntreeCaiss() {
      return this.formBonEntreeCaiss;
   }

   public void setFormBonEntreeCaiss(FormBonEntreeCaiss var1) {
      this.formBonEntreeCaiss = var1;
   }

   public FormVirementInterne getFormVirementInterne() {
      return this.formVirementInterne;
   }

   public void setFormVirementInterne(FormVirementInterne var1) {
      this.formVirementInterne = var1;
   }

   public ExercicesCaisse getExoselectionne() {
      return this.exoselectionne;
   }

   public void setExoselectionne(ExercicesCaisse var1) {
      this.exoselectionne = var1;
   }

   public long getLeIdExo() {
      return this.leIdExo;
   }

   public void setLeIdExo(long var1) {
      this.leIdExo = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public List getMesBudgetsItems() {
      return this.mesBudgetsItems;
   }

   public void setMesBudgetsItems(List var1) {
      this.mesBudgetsItems = var1;
   }

   public List getMesDossiersItems() {
      return this.mesDossiersItems;
   }

   public void setMesDossiersItems(List var1) {
      this.mesDossiersItems = var1;
   }

   public List getMesParcsItems() {
      return this.mesParcsItems;
   }

   public void setMesParcsItems(List var1) {
      this.mesParcsItems = var1;
   }

   public List getMesRegionsItems() {
      return this.mesRegionsItems;
   }

   public void setMesRegionsItems(List var1) {
      this.mesRegionsItems = var1;
   }

   public List getMesSeriesUsersItem() {
      return this.mesSeriesUsersItem;
   }

   public void setMesSeriesUsersItem(List var1) {
      this.mesSeriesUsersItem = var1;
   }

   public List getMesServiceItem() {
      return this.mesServiceItem;
   }

   public void setMesServiceItem(List var1) {
      this.mesServiceItem = var1;
   }

   public List getMesSitesItems() {
      return this.mesSitesItems;
   }

   public void setMesSitesItems(List var1) {
      this.mesSitesItems = var1;
   }

   public List getMesdevisesItem() {
      return this.mesdevisesItem;
   }

   public void setMesdevisesItem(List var1) {
      this.mesdevisesItem = var1;
   }

   public List getMesTypeReglementsItem() {
      return this.mesTypeReglementsItem;
   }

   public void setMesTypeReglementsItem(List var1) {
      this.mesTypeReglementsItem = var1;
   }

   public List getListeImpressionItems() {
      return this.listeImpressionItems;
   }

   public void setListeImpressionItems(List var1) {
      this.listeImpressionItems = var1;
   }

   public FormTransfertCaisse getFormTransfertCaisse() {
      return this.formTransfertCaisse;
   }

   public void setFormTransfertCaisse(FormTransfertCaisse var1) {
      this.formTransfertCaisse = var1;
   }

   public FormImpressionCaisse getFormImpressionCaisse() {
      return this.formImpressionCaisse;
   }

   public void setFormImpressionCaisse(FormImpressionCaisse var1) {
      this.formImpressionCaisse = var1;
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

   public List getMesTypeReglementsClientItem() {
      return this.mesTypeReglementsClientItem;
   }

   public void setMesTypeReglementsClientItem(List var1) {
      this.mesTypeReglementsClientItem = var1;
   }

   public FormJournauxCaisse getFormJournauxCaisse() {
      return this.formJournauxCaisse;
   }

   public void setFormJournauxCaisse(FormJournauxCaisse var1) {
      this.formJournauxCaisse = var1;
   }

   public FormTraite getFormTraite() {
      return this.formTraite;
   }

   public void setFormTraite(FormTraite var1) {
      this.formTraite = var1;
   }

   public FormCaissesInventaire getFormCaissesInventaire() {
      return this.formCaissesInventaire;
   }

   public void setFormCaissesInventaire(FormCaissesInventaire var1) {
      this.formCaissesInventaire = var1;
   }

   public List getMesOperationsItems() {
      return this.mesOperationsItems;
   }

   public void setMesOperationsItems(List var1) {
      this.mesOperationsItems = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public List getModeleImpressionItems() {
      return this.modeleImpressionItems;
   }

   public void setModeleImpressionItems(List var1) {
      this.modeleImpressionItems = var1;
   }

   public List getMesResponsablesItems() {
      return this.mesResponsablesItems;
   }

   public void setMesResponsablesItems(List var1) {
      this.mesResponsablesItems = var1;
   }

   public FormCaissesPrevision getFormCaissesPrevision() {
      return this.formCaissesPrevision;
   }

   public void setFormCaissesPrevision(FormCaissesPrevision var1) {
      this.formCaissesPrevision = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public List getMesBanquesCaissesItems() {
      return this.mesBanquesCaissesItems;
   }

   public void setMesBanquesCaissesItems(List var1) {
      this.mesBanquesCaissesItems = var1;
   }

   public List getMesBanquesEmetteursItems() {
      return this.mesBanquesEmetteursItems;
   }

   public void setMesBanquesEmetteursItems(List var1) {
      this.mesBanquesEmetteursItems = var1;
   }

   public List getMesBanquesRecepteursItems() {
      return this.mesBanquesRecepteursItems;
   }

   public void setMesBanquesRecepteursItems(List var1) {
      this.mesBanquesRecepteursItems = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
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

   public List getMesSourceItems() {
      return this.mesSourceItems;
   }

   public void setMesSourceItems(List var1) {
      this.mesSourceItems = var1;
   }
}
