package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormExercicesVentes;
import com.epegase.forms.commun.FormDocumentsOfficiels;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.immobilier.FormAppelChargeImmobilier;
import com.epegase.forms.immobilier.FormBailImmobilier;
import com.epegase.forms.immobilier.FormBiensImmobilier;
import com.epegase.forms.immobilier.FormBonEncaissementImmobilier;
import com.epegase.forms.immobilier.FormBudgetImmobilier;
import com.epegase.forms.immobilier.FormFactureImmobilier;
import com.epegase.forms.immobilier.FormGeranceImmobilier;
import com.epegase.forms.immobilier.FormImpressionImmobilier;
import com.epegase.forms.immobilier.FormPvImmobilier;
import com.epegase.forms.immobilier.FormSyndicImmobilier;
import com.epegase.forms.immobilier.FormTransfertImmobilier;
import com.epegase.forms.immobilier.FormTravauxImmobilier;
import com.epegase.systeme.classe.CampagneEnteteVentes;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.CampagneEnteteVentesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitLocationCtrl;
import com.epegase.systeme.menu.MenudroitNegoceCtrl;
import com.epegase.systeme.menu.MenudroitPromoteurCtrl;
import com.epegase.systeme.menu.MenudroitSyndicCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureNatureBiens;
import com.epegase.systeme.xml.LectureNatureVentes;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LectureReglementClient;
import com.epegase.systeme.xml.LectureSourcesTiers;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetLigneMenu;
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

public class FormBakingBeanImmobilier implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private MenudroitLocationCtrl menudroitLocationCtrl;
   private MenudroitSyndicCtrl menudroitSyndicCtrl;
   private MenudroitNegoceCtrl menudroitNegoceCtrl;
   private MenudroitPromoteurCtrl menudroitPromoteurCtrl;
   private ObjetLigneMenu menuimmobilier;
   private ObjetLigneMenu menuimmobilierMemo = new ObjetLigneMenu();
   private LectureModulesOnglets lesOnglets;
   private int nature;
   private OptionVentes optionVentes;
   private Habilitation habilitation;
   private ExercicesVentes exoselectionne = new ExercicesVentes();
   private ExercicesVentes lastExoVentes = new ExercicesVentes();
   private ExercicesComptable lastExoCompta;
   private ExercicesAchats lastExoAchats;
   private long leIdExo;
   private int var_timbre;
   private boolean var_marque_util = false;
   private List mesEtatsItems = new ArrayList();
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private String messageAlerte;
   private int categorie;
   private boolean var_acc_villa;
   private boolean var_acc_appartement;
   private boolean var_acc_immeuble;
   private boolean var_acc_bureau;
   private boolean var_acc_commerce;
   private boolean var_acc_garage;
   private boolean var_acc_hanger;
   private boolean var_acc_usine;
   private boolean var_acc_box;
   private boolean var_acc_terrain;
   private boolean var_acc_chambre;
   private FormExercicesVentes formExercicesVentes;
   private FormBiensImmobilier formBiensImmobilier;
   private FormBailImmobilier formBailImmobilier;
   private FormGeranceImmobilier formGeranceImmobilier;
   private FormTravauxImmobilier formTravauxImmobilier;
   private FormFactureImmobilier formFactureImmobilier;
   private FormTransfertImmobilier formTransfertImmobilier;
   private FormImpressionImmobilier formImpressionImmobilier;
   private FormBudgetImmobilier formBudgetImmobilier;
   private FormSyndicImmobilier formSyndicImmobilier;
   private FormAppelChargeImmobilier formAppelChargeImmobilier;
   private FormPvImmobilier formPvImmobilier;
   private FormBonEncaissementImmobilier formBonEncaissementImmobilier;
   private List mesdevisesItem;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private List lesFamilleClientsListe;
   private List mesFamilleClientsItems;
   private List lesModeReglementClientsListe;
   private List mesTypeReglements;
   private List mesPaysItems;
   private List mesSerieUserItem;
   private List mesActivitesItems;
   private List mesServicesItems;
   private List mesDossiersItems;
   private List mesBudgetsItems;
   private List mesFormulesItems;
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
   private List mesCompteProduitsItems;
   private List mesCompteStocksItems;
   private List mesCompteVteLocItems;
   private List mesCompteVteZItems;
   private List mesCompteVteHzItems;
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
   private FormDocumentsOfficiels formDocumentsOfficiels;
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;

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

   public void menuGaucheLocation() throws JDOMException, IOException {
      if (this.menudroitLocationCtrl == null) {
         this.menudroitLocationCtrl = new MenudroitLocationCtrl();
         this.menudroitLocationCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitLocationCtrl.chargerMenudroitLocationXml(this.usersLog.getUsrCollaboration(), this.structureLog.getStrid());
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("81600", this.usersLog.getUsrCollaboration());
   }

   public void menuGaucheSyndic() throws JDOMException, IOException {
      if (this.menudroitSyndicCtrl == null) {
         this.menudroitSyndicCtrl = new MenudroitSyndicCtrl();
         this.menudroitSyndicCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitSyndicCtrl.chargerMenudroitSyndicXml(this.usersLog.getUsrCollaboration(), this.structureLog.getStrid(), this.usersLog);
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("81610", this.usersLog.getUsrCollaboration());
   }

   public void menuGaucheNegoce() throws JDOMException, IOException {
      if (this.menudroitNegoceCtrl == null) {
         this.menudroitNegoceCtrl = new MenudroitNegoceCtrl();
         this.menudroitNegoceCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitNegoceCtrl.chargerMenudroitNegoceXml(this.usersLog.getUsrCollaboration(), this.structureLog.getStrid(), this.usersLog);
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("81620", this.usersLog.getUsrCollaboration());
   }

   public void menuGauchePromotion() throws JDOMException, IOException {
      if (this.menudroitPromoteurCtrl == null) {
         this.menudroitPromoteurCtrl = new MenudroitPromoteurCtrl();
         this.menudroitPromoteurCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitPromoteurCtrl.chargerMenudroitPromoteurXml(this.usersLog.getUsrCollaboration(), this.structureLog.getStrid(), this.usersLog);
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("81630", this.usersLog.getUsrCollaboration());
   }

   public void razMemoire() {
      this.formBailImmobilier = null;
      this.formBiensImmobilier = null;
      this.formFactureImmobilier = null;
      this.formGeranceImmobilier = null;
      this.formImpressionImmobilier = null;
      this.formTransfertImmobilier = null;
      this.formTravauxImmobilier = null;
   }

   public void gestionLocation() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuimmobilier = new ObjetLigneMenu();
      if (this.menudroitLocationCtrl.getDataModelMenudroitLocationXmlList().isRowAvailable()) {
         this.menuimmobilier = (ObjetLigneMenu)this.menudroitLocationCtrl.getDataModelMenudroitLocationXmlList().getRowData();
         if (this.menuimmobilier.getLibelle_FR() != null && !this.menuimmobilier.getLibelle_FR().isEmpty()) {
            this.menuimmobilierMemo = this.menuimmobilier;
            this.aiguillageLocation();
         }
      }

   }

   public void gestionSyndic() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuimmobilier = new ObjetLigneMenu();
      if (this.menudroitSyndicCtrl.getDataModelMenudroitSyndicXmlList().isRowAvailable()) {
         this.menuimmobilier = (ObjetLigneMenu)this.menudroitSyndicCtrl.getDataModelMenudroitSyndicXmlList().getRowData();
         if (this.menuimmobilier.getLibelle_FR() != null && !this.menuimmobilier.getLibelle_FR().isEmpty()) {
            this.menuimmobilierMemo = this.menuimmobilier;
            this.aiguillageSyndic();
         }
      }

   }

   public void gestionNegoce() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuimmobilier = new ObjetLigneMenu();
      if (this.menudroitNegoceCtrl.getDataModelMenudroitNegoceXmlList().isRowAvailable()) {
         this.menuimmobilier = (ObjetLigneMenu)this.menudroitNegoceCtrl.getDataModelMenudroitNegoceXmlList().getRowData();
         if (this.menuimmobilier.getLibelle_FR() != null && !this.menuimmobilier.getLibelle_FR().isEmpty()) {
            this.menuimmobilierMemo = this.menuimmobilier;
            this.aiguillageNegoce();
         }
      }

   }

   public void gestionPromotion() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuimmobilier = new ObjetLigneMenu();
      if (this.menudroitPromoteurCtrl.getDataModelMenudroitPromoteurXmlList().isRowAvailable()) {
         this.menuimmobilier = (ObjetLigneMenu)this.menudroitPromoteurCtrl.getDataModelMenudroitPromoteurXmlList().getRowData();
         if (this.menuimmobilier.getLibelle_FR() != null && !this.menuimmobilier.getLibelle_FR().isEmpty()) {
            this.menuimmobilierMemo = this.menuimmobilier;
            this.aiguillagePromoteur();
         }
      }

   }

   public void gestionLocationFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuimmobilier = var1;
      this.menuimmobilierMemo = this.menuimmobilier;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheLocation();
      }

      this.aiguillageLocation();
   }

   public void gestionSyndicFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuimmobilier = var1;
      this.menuimmobilierMemo = this.menuimmobilier;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheSyndic();
      }

      this.aiguillageSyndic();
   }

   public void gestionNegoceFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menuimmobilier = var1;
      this.menuimmobilierMemo = this.menuimmobilier;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheNegoce();
      }

      this.aiguillageNegoce();
   }

   public void aiguillageLocation() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      if (this.lastExoVentes.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menuimmobilier.setAdd(false);
         this.menuimmobilier.setMaj(false);
         this.menuimmobilier.setSup(false);
         this.menuimmobilier.setDup(false);
         this.menuimmobilier.setClo(false);
         this.menuimmobilier.setTrf(false);
         this.menuimmobilier.setImp(true);
      } else {
         this.menuimmobilier.setAdd(this.menuimmobilierMemo.isAdd());
         this.menuimmobilier.setMaj(this.menuimmobilierMemo.isMaj());
         this.menuimmobilier.setSup(this.menuimmobilierMemo.isSup());
         this.menuimmobilier.setDup(this.menuimmobilierMemo.isDup());
         this.menuimmobilier.setClo(this.menuimmobilierMemo.isClo());
         this.menuimmobilier.setTrf(this.menuimmobilierMemo.isTrf());
         this.menuimmobilier.setImp(this.menuimmobilierMemo.isImp());
      }

      this.categorie = 0;
      Session var1;
      String var2;
      if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:01")) {
         this.nature = 160;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/BiensInit.jsp";
               this.menuBiensImmobilier(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:02")) {
         this.nature = 161;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/GeranceInit.jsp";
               this.menuGeranceImmobilier(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:03")) {
         this.nature = 162;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/BauxInit.jsp";
               this.menuBauxImmobilier(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:04")) {
         this.nature = 163;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/TravauxInit.jsp";
               this.menuTravauxImmobilier(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:05")) {
         this.nature = 164;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/FactureChargeInit.jsp";
               this.menuFactureCharge(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:06")) {
         this.nature = 165;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/FactureLocationInit.jsp";
               this.menuFacturationImmobilier(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:07")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:08")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:90")) {
         this.affichePage = "/immobilier/ImpressionImmobilier.jsp";
         this.menuImpressionLocation();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:97")) {
         this.affichePage = "/commun/documentsOfficiels.jsp";
         this.nature = 160;
         this.menuDocuentsOfficiels();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:98")) {
         this.affichePage = "/immobilier/TransfertImmobilier.jsp";
         this.menuTransfertLocation();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81600:99")) {
         this.affichePage = "/immobilier/SelectionExercicesVentes.jsp";
         this.menuSelectionExercicesImmobilier();
      }

   }

   public void aiguillageSyndic() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      if (this.lastExoVentes.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menuimmobilier.setAdd(false);
         this.menuimmobilier.setMaj(false);
         this.menuimmobilier.setSup(false);
         this.menuimmobilier.setDup(false);
         this.menuimmobilier.setClo(false);
         this.menuimmobilier.setTrf(false);
         this.menuimmobilier.setImp(true);
      } else {
         this.menuimmobilier.setAdd(this.menuimmobilierMemo.isAdd());
         this.menuimmobilier.setMaj(this.menuimmobilierMemo.isMaj());
         this.menuimmobilier.setSup(this.menuimmobilierMemo.isSup());
         this.menuimmobilier.setDup(this.menuimmobilierMemo.isDup());
         this.menuimmobilier.setClo(this.menuimmobilierMemo.isClo());
         this.menuimmobilier.setTrf(this.menuimmobilierMemo.isTrf());
         this.menuimmobilier.setImp(this.menuimmobilierMemo.isImp());
      }

      this.categorie = 1;
      Session var1;
      String var2;
      if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:01")) {
         this.nature = 160;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/BiensInit.jsp";
               this.menuBiensImmobilier(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:02")) {
         this.nature = 171;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/SyndicInit.jsp";
               this.menuSyndicImmobilier(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:03")) {
         this.nature = 172;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/BudgetInit.jsp";
               this.menuBudgetImmobilier(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:04")) {
         this.nature = 173;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/AppelChargeInit.jsp";
               this.menuAppelCharge(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:05")) {
         this.nature = 164;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/FactureChargeInit.jsp";
               this.menuFactureCharge(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:10")) {
         this.nature = 173;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/BonEncaissementInit.jsp";
               this.menuBonEncaissement();
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:06")) {
         this.nature = 175;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SyndicPv");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/PvInit.jsp";
               this.menuPv(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:07")) {
         this.nature = 176;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/DecisionAgInit.jsp";
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:08")) {
         this.nature = 163;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/TravauxInit.jsp";
               this.menuTravauxImmobilier(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:90")) {
         this.affichePage = "/immobilier/ImpressionImmobilier.jsp";
         this.menuImpressionSyndic();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:97")) {
         this.affichePage = "/commun/documentsOfficiels.jsp";
         this.nature = 170;
         this.menuDocuentsOfficiels();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:98")) {
         this.affichePage = "/immobilier/TransfertImmobilier.jsp";
         this.menuTransfertSyndic();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81610:99")) {
         this.affichePage = "/immobilier/SelectionExercicesVentes.jsp";
         this.menuSelectionExercicesImmobilier();
      }

   }

   public void aiguillageNegoce() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      if (this.lastExoVentes.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menuimmobilier.setAdd(false);
         this.menuimmobilier.setMaj(false);
         this.menuimmobilier.setSup(false);
         this.menuimmobilier.setDup(false);
         this.menuimmobilier.setClo(false);
         this.menuimmobilier.setTrf(false);
         this.menuimmobilier.setImp(true);
      } else {
         this.menuimmobilier.setAdd(this.menuimmobilierMemo.isAdd());
         this.menuimmobilier.setMaj(this.menuimmobilierMemo.isMaj());
         this.menuimmobilier.setSup(this.menuimmobilierMemo.isSup());
         this.menuimmobilier.setDup(this.menuimmobilierMemo.isDup());
         this.menuimmobilier.setClo(this.menuimmobilierMemo.isClo());
         this.menuimmobilier.setTrf(this.menuimmobilierMemo.isTrf());
         this.menuimmobilier.setImp(this.menuimmobilierMemo.isImp());
      }

      this.categorie = 2;
      if (this.menuimmobilier.getCommande().equalsIgnoreCase("81620:01")) {
         this.nature = 160;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            String var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/BiensInit.jsp";
               this.menuBiensImmobilier(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81620:07")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81620:08")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81620:09")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81620:90")) {
         this.affichePage = "/immobilier/ImpressionImmobilier.jsp";
         this.menuImpressionNegoce();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81620:97")) {
         this.affichePage = "/commun/documentsOfficiels.jsp";
         this.nature = 180;
         this.menuDocuentsOfficiels();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81620:98")) {
         this.affichePage = "/immobilier/TransfertImobilier.jsp";
         this.menuTransfertNegoce();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81620:99")) {
         this.affichePage = "/immobilier/SelectionExercicesVentes.jsp";
         this.menuSelectionExercicesImmobilier();
      }

   }

   public void aiguillagePromoteur() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      if (this.lastExoVentes.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menuimmobilier.setAdd(false);
         this.menuimmobilier.setMaj(false);
         this.menuimmobilier.setSup(false);
         this.menuimmobilier.setDup(false);
         this.menuimmobilier.setClo(false);
         this.menuimmobilier.setTrf(false);
         this.menuimmobilier.setImp(true);
      } else {
         this.menuimmobilier.setAdd(this.menuimmobilierMemo.isAdd());
         this.menuimmobilier.setMaj(this.menuimmobilierMemo.isMaj());
         this.menuimmobilier.setSup(this.menuimmobilierMemo.isSup());
         this.menuimmobilier.setDup(this.menuimmobilierMemo.isDup());
         this.menuimmobilier.setClo(this.menuimmobilierMemo.isClo());
         this.menuimmobilier.setTrf(this.menuimmobilierMemo.isTrf());
         this.menuimmobilier.setImp(this.menuimmobilierMemo.isImp());
      }

      this.categorie = 3;
      if (this.menuimmobilier.getCommande().equalsIgnoreCase("81630:01")) {
         this.nature = 160;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            String var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/immobilier/BiensInit.jsp";
               this.menuBiensImmobilier(var1);
            } else {
               this.affichePage = "/immobilier/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/immobilier/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81630:07")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81630:08")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81630:09")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81630:90")) {
         this.affichePage = "/immobilier/ImpressionImmobilier.jsp";
         this.menuImpressionNegoce();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81630:97")) {
         this.affichePage = "/commun/documentsOfficiels.jsp";
         this.nature = 180;
         this.menuDocuentsOfficiels();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81630:98")) {
         this.affichePage = "/immobilier/TransfertImobilier.jsp";
         this.menuTransfertNegoce();
      } else if (this.menuimmobilier.getCommande().equalsIgnoreCase("81630:99")) {
         this.affichePage = "/immobilier/SelectionExercicesVentes.jsp";
         this.menuSelectionExercicesImmobilier();
      }

   }

   public void menuBiensImmobilier(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException {
      this.formBiensImmobilier = new FormBiensImmobilier();
      this.formBiensImmobilier.setUtilInitHibernate(this.utilInitHibernate);
      this.formBiensImmobilier.setBaseLog(this.baseLog);
      this.formBiensImmobilier.setStructureLog(this.structureLog);
      this.formBiensImmobilier.setUsersLog(this.usersLog);
      this.formBiensImmobilier.InstancesDaoUtilses();
      this.formBiensImmobilier.setNature(this.nature);
      this.formBiensImmobilier.setCategorieModule(this.categorie);
      this.formBiensImmobilier.setExercicesVentes(this.exoselectionne);
      this.formBiensImmobilier.setLastExoVentes(this.lastExoVentes);
      this.formBiensImmobilier.setOptionsVentes(this.optionVentes);
      this.formBiensImmobilier.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formBiensImmobilier.configVentes(var1);
      this.formBiensImmobilier.accesResteintUser();
      this.formBiensImmobilier.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formBiensImmobilier.setFormRecherche(this.formRecherche);
      this.formBiensImmobilier.setUrlExplorateur(this.urlExplorateur);
      this.formBiensImmobilier.setVar_acc_villa(this.var_acc_villa);
      this.formBiensImmobilier.setVar_acc_appartement(this.var_acc_appartement);
      this.formBiensImmobilier.setVar_acc_immeuble(this.var_acc_immeuble);
      this.formBiensImmobilier.setVar_acc_bureau(this.var_acc_bureau);
      this.formBiensImmobilier.setVar_acc_commerce(this.var_acc_commerce);
      this.formBiensImmobilier.setVar_acc_garage(this.var_acc_garage);
      this.formBiensImmobilier.setVar_acc_hanger(this.var_acc_hanger);
      this.formBiensImmobilier.setVar_acc_usine(this.var_acc_usine);
      this.formBiensImmobilier.setVar_acc_box(this.var_acc_box);
      this.formBiensImmobilier.setVar_acc_terrain(this.var_acc_terrain);
      this.formBiensImmobilier.setVar_acc_chambre(this.var_acc_chambre);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.categorie == 1) {
         this.formBiensImmobilier.setEtat(2);
      } else {
         this.formBiensImmobilier.setEtat(9);
      }

      this.formBiensImmobilier.chargerBiens(var1);
   }

   public void menuGeranceImmobilier(Session var1) throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.formGeranceImmobilier = new FormGeranceImmobilier();
      this.formGeranceImmobilier.setUtilInitHibernate(this.utilInitHibernate);
      this.formGeranceImmobilier.setBaseLog(this.baseLog);
      this.formGeranceImmobilier.setStructureLog(this.structureLog);
      this.formGeranceImmobilier.setUsersLog(this.usersLog);
      this.formGeranceImmobilier.InstancesDaoUtilses();
      this.formGeranceImmobilier.setNature(this.nature);
      this.formGeranceImmobilier.setCategorie(this.categorie);
      this.formGeranceImmobilier.setExercicesVentes(this.exoselectionne);
      this.formGeranceImmobilier.setLastExoVentes(this.lastExoVentes);
      this.formGeranceImmobilier.setOptionsVentes(this.optionVentes);
      this.formGeranceImmobilier.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formGeranceImmobilier.configVentes(var1);
      this.formGeranceImmobilier.accesResteintUser();
      this.formGeranceImmobilier.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formGeranceImmobilier.setMesSerieUserItem(this.mesSerieUserItem);
      this.formGeranceImmobilier.setFormRecherche(this.formRecherche);
      this.formGeranceImmobilier.setVar_acc_villa(this.var_acc_villa);
      this.formGeranceImmobilier.setVar_acc_appartement(this.var_acc_appartement);
      this.formGeranceImmobilier.setVar_acc_immeuble(this.var_acc_immeuble);
      this.formGeranceImmobilier.setVar_acc_bureau(this.var_acc_bureau);
      this.formGeranceImmobilier.setVar_acc_commerce(this.var_acc_commerce);
      this.formGeranceImmobilier.setVar_acc_garage(this.var_acc_garage);
      this.formGeranceImmobilier.setVar_acc_hanger(this.var_acc_hanger);
      this.formGeranceImmobilier.setVar_acc_usine(this.var_acc_usine);
      this.formGeranceImmobilier.setVar_acc_box(this.var_acc_box);
      this.formGeranceImmobilier.setVar_acc_terrain(this.var_acc_terrain);
      this.formGeranceImmobilier.setVar_acc_chambre(this.var_acc_chambre);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionVentes.getChargementListe() != null && !this.optionVentes.getChargementListe().isEmpty() && this.optionVentes.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formGeranceImmobilier.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formGeranceImmobilier.chargeListeDetail(var1);
      }

   }

   public void menuSyndicImmobilier(Session var1) throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.formSyndicImmobilier = new FormSyndicImmobilier();
      this.formSyndicImmobilier.setUtilInitHibernate(this.utilInitHibernate);
      this.formSyndicImmobilier.setBaseLog(this.baseLog);
      this.formSyndicImmobilier.setStructureLog(this.structureLog);
      this.formSyndicImmobilier.setUsersLog(this.usersLog);
      this.formSyndicImmobilier.InstancesDaoUtilses();
      this.formSyndicImmobilier.setNature(this.nature);
      this.formSyndicImmobilier.setCategorie(this.categorie);
      this.formSyndicImmobilier.setExercicesVentes(this.exoselectionne);
      this.formSyndicImmobilier.setLastExoVentes(this.lastExoVentes);
      this.formSyndicImmobilier.setOptionsVentes(this.optionVentes);
      this.formSyndicImmobilier.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formSyndicImmobilier.configVentes(var1);
      this.formSyndicImmobilier.accesResteintUser();
      this.formSyndicImmobilier.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formSyndicImmobilier.setMesSerieUserItem(this.mesSerieUserItem);
      this.formSyndicImmobilier.setFormRecherche(this.formRecherche);
      this.formSyndicImmobilier.setVar_acc_villa(this.var_acc_villa);
      this.formSyndicImmobilier.setVar_acc_appartement(this.var_acc_appartement);
      this.formSyndicImmobilier.setVar_acc_immeuble(this.var_acc_immeuble);
      this.formSyndicImmobilier.setVar_acc_bureau(this.var_acc_bureau);
      this.formSyndicImmobilier.setVar_acc_commerce(this.var_acc_commerce);
      this.formSyndicImmobilier.setVar_acc_garage(this.var_acc_garage);
      this.formSyndicImmobilier.setVar_acc_hanger(this.var_acc_hanger);
      this.formSyndicImmobilier.setVar_acc_usine(this.var_acc_usine);
      this.formSyndicImmobilier.setVar_acc_box(this.var_acc_box);
      this.formSyndicImmobilier.setVar_acc_terrain(this.var_acc_terrain);
      this.formSyndicImmobilier.setVar_acc_chambre(this.var_acc_chambre);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionVentes.getChargementListe() != null && !this.optionVentes.getChargementListe().isEmpty() && this.optionVentes.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formSyndicImmobilier.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formSyndicImmobilier.chargeListeDetail(var1);
      }

   }

   public void menuBauxImmobilier(Session var1) throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.formBailImmobilier = new FormBailImmobilier();
      this.formBailImmobilier.setUtilInitHibernate(this.utilInitHibernate);
      this.formBailImmobilier.setBaseLog(this.baseLog);
      this.formBailImmobilier.setStructureLog(this.structureLog);
      this.formBailImmobilier.setUsersLog(this.usersLog);
      this.formBailImmobilier.InstancesDaoUtilses();
      this.formBailImmobilier.setNature(this.nature);
      this.formBailImmobilier.setCategorie(this.categorie);
      this.formBailImmobilier.setExercicesVentes(this.exoselectionne);
      this.formBailImmobilier.setLastExoVentes(this.lastExoVentes);
      this.formBailImmobilier.setOptionsVentes(this.optionVentes);
      this.formBailImmobilier.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formBailImmobilier.configVentes(var1);
      this.formBailImmobilier.accesResteintUser();
      this.formBailImmobilier.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formBailImmobilier.setHabilitation(this.habilitation);
      this.formBailImmobilier.setMesSerieUserItem(this.mesSerieUserItem);
      this.formBailImmobilier.setFormRecherche(this.formRecherche);
      this.formBailImmobilier.setVar_acc_villa(this.var_acc_villa);
      this.formBailImmobilier.setVar_acc_appartement(this.var_acc_appartement);
      this.formBailImmobilier.setVar_acc_immeuble(this.var_acc_immeuble);
      this.formBailImmobilier.setVar_acc_bureau(this.var_acc_bureau);
      this.formBailImmobilier.setVar_acc_commerce(this.var_acc_commerce);
      this.formBailImmobilier.setVar_acc_garage(this.var_acc_garage);
      this.formBailImmobilier.setVar_acc_hanger(this.var_acc_hanger);
      this.formBailImmobilier.setVar_acc_usine(this.var_acc_usine);
      this.formBailImmobilier.setVar_acc_box(this.var_acc_box);
      this.formBailImmobilier.setVar_acc_terrain(this.var_acc_terrain);
      this.formBailImmobilier.setVar_acc_chambre(this.var_acc_chambre);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionVentes.getChargementListe() != null && !this.optionVentes.getChargementListe().isEmpty() && this.optionVentes.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formBailImmobilier.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formBailImmobilier.chargeListeDetail(var1);
      }

   }

   public void menuTravauxImmobilier(Session var1) throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.formTravauxImmobilier = new FormTravauxImmobilier();
      this.formTravauxImmobilier.setUtilInitHibernate(this.utilInitHibernate);
      this.formTravauxImmobilier.setBaseLog(this.baseLog);
      this.formTravauxImmobilier.setStructureLog(this.structureLog);
      this.formTravauxImmobilier.setUsersLog(this.usersLog);
      this.formTravauxImmobilier.InstancesDaoUtilses();
      this.formTravauxImmobilier.setNature(this.nature);
      this.formTravauxImmobilier.setCategorie(this.categorie);
      this.formTravauxImmobilier.setExercicesVentes(this.exoselectionne);
      this.formTravauxImmobilier.setLastExoVentes(this.lastExoVentes);
      this.formTravauxImmobilier.setOptionsVentes(this.optionVentes);
      this.formTravauxImmobilier.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formTravauxImmobilier.configVentes(var1);
      this.formTravauxImmobilier.accesResteintUser();
      this.formTravauxImmobilier.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formTravauxImmobilier.setMesSerieUserItem(this.mesSerieUserItem);
      this.formTravauxImmobilier.setFormRecherche(this.formRecherche);
      this.formTravauxImmobilier.setVar_acc_villa(this.var_acc_villa);
      this.formTravauxImmobilier.setVar_acc_appartement(this.var_acc_appartement);
      this.formTravauxImmobilier.setVar_acc_immeuble(this.var_acc_immeuble);
      this.formTravauxImmobilier.setVar_acc_bureau(this.var_acc_bureau);
      this.formTravauxImmobilier.setVar_acc_commerce(this.var_acc_commerce);
      this.formTravauxImmobilier.setVar_acc_garage(this.var_acc_garage);
      this.formTravauxImmobilier.setVar_acc_hanger(this.var_acc_hanger);
      this.formTravauxImmobilier.setVar_acc_usine(this.var_acc_usine);
      this.formTravauxImmobilier.setVar_acc_box(this.var_acc_box);
      this.formTravauxImmobilier.setVar_acc_terrain(this.var_acc_terrain);
      this.formTravauxImmobilier.setVar_acc_chambre(this.var_acc_chambre);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionVentes.getChargementListe() != null && !this.optionVentes.getChargementListe().isEmpty() && this.optionVentes.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formTravauxImmobilier.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formTravauxImmobilier.chargeListeDetail(var1);
      }

   }

   public void menuAppelCharge(Session var1) throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.formAppelChargeImmobilier = new FormAppelChargeImmobilier();
      this.formAppelChargeImmobilier.setUtilInitHibernate(this.utilInitHibernate);
      this.formAppelChargeImmobilier.setBaseLog(this.baseLog);
      this.formAppelChargeImmobilier.setStructureLog(this.structureLog);
      this.formAppelChargeImmobilier.setUsersLog(this.usersLog);
      this.formAppelChargeImmobilier.InstancesDaoUtilses();
      this.formAppelChargeImmobilier.setNature(this.nature);
      this.formAppelChargeImmobilier.setCategorie(this.categorie);
      this.formAppelChargeImmobilier.setExercicesVentes(this.exoselectionne);
      this.formAppelChargeImmobilier.setLastExoVentes(this.lastExoVentes);
      this.formAppelChargeImmobilier.setOptionsVentes(this.optionVentes);
      this.formAppelChargeImmobilier.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formAppelChargeImmobilier.configVentes(var1);
      this.formAppelChargeImmobilier.accesResteintUser();
      this.formAppelChargeImmobilier.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formAppelChargeImmobilier.setMesSerieUserItem(this.mesSerieUserItem);
      this.formAppelChargeImmobilier.setFormRecherche(this.formRecherche);
      this.formAppelChargeImmobilier.setVar_acc_villa(this.var_acc_villa);
      this.formAppelChargeImmobilier.setVar_acc_appartement(this.var_acc_appartement);
      this.formAppelChargeImmobilier.setVar_acc_immeuble(this.var_acc_immeuble);
      this.formAppelChargeImmobilier.setVar_acc_bureau(this.var_acc_bureau);
      this.formAppelChargeImmobilier.setVar_acc_commerce(this.var_acc_commerce);
      this.formAppelChargeImmobilier.setVar_acc_garage(this.var_acc_garage);
      this.formAppelChargeImmobilier.setVar_acc_hanger(this.var_acc_hanger);
      this.formAppelChargeImmobilier.setVar_acc_usine(this.var_acc_usine);
      this.formAppelChargeImmobilier.setVar_acc_box(this.var_acc_box);
      this.formAppelChargeImmobilier.setVar_acc_terrain(this.var_acc_terrain);
      this.formAppelChargeImmobilier.setVar_acc_chambre(this.var_acc_chambre);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionVentes.getChargementListe() != null && !this.optionVentes.getChargementListe().isEmpty() && this.optionVentes.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formAppelChargeImmobilier.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formAppelChargeImmobilier.chargeListeDetail(var1);
      }

   }

   public void menuFactureCharge(Session var1) throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.formTravauxImmobilier = new FormTravauxImmobilier();
      this.formTravauxImmobilier.setUtilInitHibernate(this.utilInitHibernate);
      this.formTravauxImmobilier.setBaseLog(this.baseLog);
      this.formTravauxImmobilier.setStructureLog(this.structureLog);
      this.formTravauxImmobilier.setUsersLog(this.usersLog);
      this.formTravauxImmobilier.InstancesDaoUtilses();
      this.formTravauxImmobilier.setNature(this.nature);
      this.formTravauxImmobilier.setCategorie(this.categorie);
      this.formTravauxImmobilier.setExercicesVentes(this.exoselectionne);
      this.formTravauxImmobilier.setLastExoVentes(this.lastExoVentes);
      this.formTravauxImmobilier.setOptionsVentes(this.optionVentes);
      this.formTravauxImmobilier.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formTravauxImmobilier.configVentes(var1);
      this.formTravauxImmobilier.accesResteintUser();
      this.formTravauxImmobilier.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formTravauxImmobilier.setMesSerieUserItem(this.mesSerieUserItem);
      this.formTravauxImmobilier.setFormRecherche(this.formRecherche);
      this.formTravauxImmobilier.setVar_acc_villa(this.var_acc_villa);
      this.formTravauxImmobilier.setVar_acc_appartement(this.var_acc_appartement);
      this.formTravauxImmobilier.setVar_acc_immeuble(this.var_acc_immeuble);
      this.formTravauxImmobilier.setVar_acc_bureau(this.var_acc_bureau);
      this.formTravauxImmobilier.setVar_acc_commerce(this.var_acc_commerce);
      this.formTravauxImmobilier.setVar_acc_garage(this.var_acc_garage);
      this.formTravauxImmobilier.setVar_acc_hanger(this.var_acc_hanger);
      this.formTravauxImmobilier.setVar_acc_usine(this.var_acc_usine);
      this.formTravauxImmobilier.setVar_acc_box(this.var_acc_box);
      this.formTravauxImmobilier.setVar_acc_terrain(this.var_acc_terrain);
      this.formTravauxImmobilier.setVar_acc_chambre(this.var_acc_chambre);
      this.formTravauxImmobilier.setUrlExplorateur(this.urlExplorateur);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionVentes.getChargementListe() != null && !this.optionVentes.getChargementListe().isEmpty() && this.optionVentes.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formTravauxImmobilier.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formTravauxImmobilier.chargeListeDetail(var1);
      }

   }

   public void menuFacturationImmobilier(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formFactureImmobilier = new FormFactureImmobilier();
      this.formFactureImmobilier.setUtilInitHibernate(this.utilInitHibernate);
      this.formFactureImmobilier.setBaseLog(this.baseLog);
      this.formFactureImmobilier.setStructureLog(this.structureLog);
      this.formFactureImmobilier.setUsersLog(this.usersLog);
      this.formFactureImmobilier.InstancesDaoUtilses();
      this.formFactureImmobilier.setNature(this.nature);
      this.formFactureImmobilier.setCategorie(this.categorie);
      this.formFactureImmobilier.setExercicesVentes(this.exoselectionne);
      this.formFactureImmobilier.setLastExoVentes(this.lastExoVentes);
      this.formFactureImmobilier.setOptionsVentes(this.optionVentes);
      this.formFactureImmobilier.setVar_timbre(this.var_timbre);
      this.formFactureImmobilier.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFactureImmobilier.configVentes(var1);
      this.formFactureImmobilier.accesResteintUser();
      this.formFactureImmobilier.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formFactureImmobilier.setHabilitation(this.habilitation);
      this.formFactureImmobilier.setMesSerieUserItem(this.mesSerieUserItem);
      this.formFactureImmobilier.setFormRecherche(this.formRecherche);
      this.formFactureImmobilier.setVar_acc_villa(this.var_acc_villa);
      this.formFactureImmobilier.setVar_acc_appartement(this.var_acc_appartement);
      this.formFactureImmobilier.setVar_acc_immeuble(this.var_acc_immeuble);
      this.formFactureImmobilier.setVar_acc_bureau(this.var_acc_bureau);
      this.formFactureImmobilier.setVar_acc_commerce(this.var_acc_commerce);
      this.formFactureImmobilier.setVar_acc_garage(this.var_acc_garage);
      this.formFactureImmobilier.setVar_acc_hanger(this.var_acc_hanger);
      this.formFactureImmobilier.setVar_acc_usine(this.var_acc_usine);
      this.formFactureImmobilier.setVar_acc_box(this.var_acc_box);
      this.formFactureImmobilier.setVar_acc_terrain(this.var_acc_terrain);
      this.formFactureImmobilier.setVar_acc_chambre(this.var_acc_chambre);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      if (this.optionVentes.getChargementListe() != null && !this.optionVentes.getChargementListe().isEmpty() && this.optionVentes.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formFactureImmobilier.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formFactureImmobilier.chargeListeDetail(var1);
      }

   }

   public void menuBudgetImmobilier(Session var1) throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.formBudgetImmobilier = new FormBudgetImmobilier();
      this.formBudgetImmobilier.setUtilInitHibernate(this.utilInitHibernate);
      this.formBudgetImmobilier.setBaseLog(this.baseLog);
      this.formBudgetImmobilier.setStructureLog(this.structureLog);
      this.formBudgetImmobilier.setUsersLog(this.usersLog);
      this.formBudgetImmobilier.InstancesDaoUtilses();
      this.formBudgetImmobilier.setNature(this.nature);
      this.formBudgetImmobilier.setCategorie(this.categorie);
      this.formBudgetImmobilier.setExercicesVentes(this.exoselectionne);
      this.formBudgetImmobilier.setLastExoVentes(this.lastExoVentes);
      this.formBudgetImmobilier.setOptionsVentes(this.optionVentes);
      this.formBudgetImmobilier.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formBudgetImmobilier.configVentes(var1);
      this.formBudgetImmobilier.accesResteintUser();
      this.formBudgetImmobilier.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formBudgetImmobilier.setMesSerieUserItem(this.mesSerieUserItem);
      this.formBudgetImmobilier.setFormRecherche(this.formRecherche);
      this.formBudgetImmobilier.setVar_acc_villa(this.var_acc_villa);
      this.formBudgetImmobilier.setVar_acc_appartement(this.var_acc_appartement);
      this.formBudgetImmobilier.setVar_acc_immeuble(this.var_acc_immeuble);
      this.formBudgetImmobilier.setVar_acc_bureau(this.var_acc_bureau);
      this.formBudgetImmobilier.setVar_acc_commerce(this.var_acc_commerce);
      this.formBudgetImmobilier.setVar_acc_garage(this.var_acc_garage);
      this.formBudgetImmobilier.setVar_acc_hanger(this.var_acc_hanger);
      this.formBudgetImmobilier.setVar_acc_usine(this.var_acc_usine);
      this.formBudgetImmobilier.setVar_acc_box(this.var_acc_box);
      this.formBudgetImmobilier.setVar_acc_terrain(this.var_acc_terrain);
      this.formBudgetImmobilier.setVar_acc_chambre(this.var_acc_chambre);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionVentes.getChargementListe() != null && !this.optionVentes.getChargementListe().isEmpty() && this.optionVentes.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formBudgetImmobilier.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formBudgetImmobilier.chargeListeDetail(var1);
      }

   }

   public void menuPv(Session var1) throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.formPvImmobilier = new FormPvImmobilier();
      this.formPvImmobilier.setUtilInitHibernate(this.utilInitHibernate);
      this.formPvImmobilier.setBaseLog(this.baseLog);
      this.formPvImmobilier.setStructureLog(this.structureLog);
      this.formPvImmobilier.setUsersLog(this.usersLog);
      this.formPvImmobilier.InstancesDaoUtilses();
      this.formPvImmobilier.setNature(this.nature);
      this.formPvImmobilier.setCategorie(this.categorie);
      this.formPvImmobilier.setExercicesVentes(this.exoselectionne);
      this.formPvImmobilier.setLastExoVentes(this.lastExoVentes);
      this.formPvImmobilier.setOptionsVentes(this.optionVentes);
      this.formPvImmobilier.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formPvImmobilier.configVentes(var1);
      this.formPvImmobilier.accesResteintUser();
      this.formPvImmobilier.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formPvImmobilier.setMesSerieUserItem(this.mesSerieUserItem);
      this.formPvImmobilier.setFormRecherche(this.formRecherche);
      this.formPvImmobilier.setVar_acc_villa(this.var_acc_villa);
      this.formPvImmobilier.setVar_acc_appartement(this.var_acc_appartement);
      this.formPvImmobilier.setVar_acc_immeuble(this.var_acc_immeuble);
      this.formPvImmobilier.setVar_acc_bureau(this.var_acc_bureau);
      this.formPvImmobilier.setVar_acc_commerce(this.var_acc_commerce);
      this.formPvImmobilier.setVar_acc_garage(this.var_acc_garage);
      this.formPvImmobilier.setVar_acc_hanger(this.var_acc_hanger);
      this.formPvImmobilier.setVar_acc_usine(this.var_acc_usine);
      this.formPvImmobilier.setVar_acc_box(this.var_acc_box);
      this.formPvImmobilier.setVar_acc_terrain(this.var_acc_terrain);
      this.formPvImmobilier.setVar_acc_chambre(this.var_acc_chambre);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionVentes.getChargementListe() != null && !this.optionVentes.getChargementListe().isEmpty() && this.optionVentes.getChargementListe().equals("1")) {
         if (this.mesSerieUserItem.size() != 0) {
            this.formPvImmobilier.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         }

         this.formPvImmobilier.chargeListeDetail(var1);
      }

   }

   public void menuBonEncaissement() throws JDOMException, IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementVente");
      this.formBonEncaissementImmobilier = new FormBonEncaissementImmobilier();
      this.formBonEncaissementImmobilier.setutilInitHibernate(this.utilInitHibernate);
      this.formBonEncaissementImmobilier.setBaseLog(this.baseLog);
      this.formBonEncaissementImmobilier.setStructureLog(this.structureLog);
      this.formBonEncaissementImmobilier.setUsersLog(this.usersLog);
      this.formBonEncaissementImmobilier.InstancesDaoUtilses();
      this.formBonEncaissementImmobilier.setExercicesVentes(this.exoselectionne);
      this.formBonEncaissementImmobilier.setOptionsVentes(this.optionVentes);
      this.formBonEncaissementImmobilier.setNature(this.nature);
      this.formBonEncaissementImmobilier.setUsersChrono(this.usersChrono);
      this.formBonEncaissementImmobilier.chargerFind(var1);
      this.recupererLesItemsDoc(var1);
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuImpressionLocation() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      this.formImpressionImmobilier = new FormImpressionImmobilier();
      this.formImpressionImmobilier.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionImmobilier.setBaseLog(this.baseLog);
      this.formImpressionImmobilier.setStructureLog(this.structureLog);
      this.formImpressionImmobilier.setUsersLog(this.usersLog);
      this.formImpressionImmobilier.InstancesDaoUtilses();
      this.formImpressionImmobilier.setExoSelectionne(this.exoselectionne);
      this.formImpressionImmobilier.setOptionVentes(this.optionVentes);
      this.formImpressionImmobilier.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionImmobilier.setTypeImmobilier(0);
      this.formImpressionImmobilier.chargerLesRepImpLocation(var1);
      this.recupererLesItemsImpression(var1);
      this.formImpressionImmobilier.initImpression();
      this.formImpressionImmobilier.chargerPeriodes();
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuImpressionSyndic() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      this.formImpressionImmobilier = new FormImpressionImmobilier();
      this.formImpressionImmobilier.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionImmobilier.setBaseLog(this.baseLog);
      this.formImpressionImmobilier.setStructureLog(this.structureLog);
      this.formImpressionImmobilier.setUsersLog(this.usersLog);
      this.formImpressionImmobilier.InstancesDaoUtilses();
      this.formImpressionImmobilier.setExoSelectionne(this.exoselectionne);
      this.formImpressionImmobilier.setOptionVentes(this.optionVentes);
      this.formImpressionImmobilier.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionImmobilier.setTypeImmobilier(1);
      this.formImpressionImmobilier.chargerLesRepImpLocation(var1);
      this.recupererLesItemsImpression(var1);
      this.formImpressionImmobilier.initImpression();
      this.formImpressionImmobilier.chargerPeriodes();
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuImpressionNegoce() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      this.formImpressionImmobilier = new FormImpressionImmobilier();
      this.formImpressionImmobilier.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionImmobilier.setBaseLog(this.baseLog);
      this.formImpressionImmobilier.setStructureLog(this.structureLog);
      this.formImpressionImmobilier.setUsersLog(this.usersLog);
      this.formImpressionImmobilier.InstancesDaoUtilses();
      this.formImpressionImmobilier.setExoSelectionne(this.exoselectionne);
      this.formImpressionImmobilier.setOptionVentes(this.optionVentes);
      this.formImpressionImmobilier.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionImmobilier.setTypeImmobilier(2);
      this.formImpressionImmobilier.chargerLesRepImpLocation(var1);
      this.recupererLesItemsImpression(var1);
      this.formImpressionImmobilier.initImpression();
      this.formImpressionImmobilier.chargerPeriodes();
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuDocuentsOfficiels() throws IOException, HibernateException, NamingException {
      this.formDocumentsOfficiels.ouvrirDocument();
   }

   public void menuTransfertLocation() throws IOException, JDOMException {
      this.formTransfertImmobilier = new FormTransfertImmobilier();
      this.formTransfertImmobilier.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertImmobilier.setBaseLog(this.baseLog);
      this.formTransfertImmobilier.setStructureLog(this.structureLog);
      this.formTransfertImmobilier.setUsersLog(this.usersLog);
      this.formTransfertImmobilier.InstancesDaoUtilses();
      this.formTransfertImmobilier.setExercicesVentes(this.exoselectionne);
      this.formTransfertImmobilier.setOptionsVentes(this.optionVentes);
      this.formTransfertImmobilier.setTypeImmobilier(0);
      this.formTransfertImmobilier.init();
   }

   public void menuTransfertSyndic() throws IOException, JDOMException {
      this.formTransfertImmobilier = new FormTransfertImmobilier();
      this.formTransfertImmobilier.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertImmobilier.setBaseLog(this.baseLog);
      this.formTransfertImmobilier.setStructureLog(this.structureLog);
      this.formTransfertImmobilier.setUsersLog(this.usersLog);
      this.formTransfertImmobilier.InstancesDaoUtilses();
      this.formTransfertImmobilier.setExercicesVentes(this.exoselectionne);
      this.formTransfertImmobilier.setOptionsVentes(this.optionVentes);
      this.formTransfertImmobilier.setTypeImmobilier(1);
      this.formTransfertImmobilier.init();
   }

   public void menuTransfertNegoce() throws IOException, JDOMException {
      this.formTransfertImmobilier = new FormTransfertImmobilier();
      this.formTransfertImmobilier.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertImmobilier.setBaseLog(this.baseLog);
      this.formTransfertImmobilier.setStructureLog(this.structureLog);
      this.formTransfertImmobilier.setUsersLog(this.usersLog);
      this.formTransfertImmobilier.InstancesDaoUtilses();
      this.formTransfertImmobilier.setExercicesVentes(this.exoselectionne);
      this.formTransfertImmobilier.setOptionsVentes(this.optionVentes);
      this.formTransfertImmobilier.setTypeImmobilier(2);
      this.formTransfertImmobilier.init();
   }

   public void menuSelectionExercicesImmobilier() throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesVentes = new FormExercicesVentes();
      this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesVentes.setBaseLog(this.baseLog);
      this.formExercicesVentes.setStructureLog(this.structureLog);
      this.formExercicesVentes.setUsersLog(this.usersLog);
      this.formExercicesVentes.InstancesDaoUtilses();
      this.leIdExo = this.exoselectionne.getExevteId();
      this.formExercicesVentes.setLesexercicesVentes(this.formExercicesVentes.recupererLesexercices((Session)null));
   }

   public void recupererTousLesItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererOptionsImmobilier();
      this.recupererModelesAutorises();
      this.recupererPaysItem();
      this.recupererDevisesItem(var1);
      this.recupererFactorsItem(var1);
      this.recupererBanquesItem(var1);
      this.recupererFormuleItem(var1);
      this.recupererFamillesClientItem();
      this.recupererTypesReglementsItem();
      this.recupererCaisses(var1);
      this.chargerMesCodesTaxeVnt(var1);
      this.recupererBudgetItem(var1);
      this.recupererActiviteItem(var1);
      this.recupererDossierItem(var1);
      this.recupererServiceItem(var1);
      this.recupererSourceListe(var1);
   }

   public void recupererLesItemsDoc(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererSerieUserItem(var1);
      this.recupererModeleDocument();
      this.recupererModeleListe();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
      this.recupererHabilitation(var1);
      this.recupererLesCommerciauxItem(var1);
   }

   public void recupererLesItemsProd(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererLesNaturesItem();
      this.recupererFamilleProduitAchatsUtilItem(var1);
      this.recupererFamilleProduitVentesUtilItem(var1);
      this.recupererFamillesGlobal();
      this.recupererDepotItem(var1, 0);
      this.chargerMesCodesTaxeVnt(var1);
      this.chargerMesCompte(var1);
      this.chargerMesClesRepartition(var1);
      this.recupererModeleFicheProduit();
      this.recupererModeleListeProduit();
   }

   public void recupererLesItemsImpression(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererLesCommerciauxItem(var1);
      this.recupererLesCreateurItem(var1);
   }

   public void recupererOptionsImmobilier() {
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var1 = new LireLesoptionsVentes();
      var1.setStrId(this.structureLog.getStrid());
      this.optionVentes = var1.lancer();
      this.var_acc_villa = false;
      this.var_acc_appartement = false;
      this.var_acc_immeuble = false;
      this.var_acc_bureau = false;
      this.var_acc_commerce = false;
      this.var_acc_hanger = false;
      this.var_acc_garage = false;
      this.var_acc_usine = false;
      this.var_acc_box = false;
      this.var_acc_terrain = false;
      this.var_acc_chambre = false;
      LectureNatureBiens var2 = new LectureNatureBiens(this.baseLog);
      new ArrayList();
      var2.recupereNatureBiens(this.baseLog);
      List var3 = var2.getMesNatureBiens();
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            if (this.categorie == 0) {
               if (((ObjetCompte)var3.get(var4)).getCode().equals("0")) {
                  this.var_acc_villa = ((ObjetCompte)var3.get(var4)).isValideLocation();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("1")) {
                  this.var_acc_appartement = ((ObjetCompte)var3.get(var4)).isValideLocation();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("2")) {
                  this.var_acc_immeuble = ((ObjetCompte)var3.get(var4)).isValideLocation();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("3")) {
                  this.var_acc_bureau = ((ObjetCompte)var3.get(var4)).isValideLocation();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("4")) {
                  this.var_acc_commerce = ((ObjetCompte)var3.get(var4)).isValideLocation();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("5")) {
                  this.var_acc_garage = ((ObjetCompte)var3.get(var4)).isValideLocation();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("6")) {
                  this.var_acc_hanger = ((ObjetCompte)var3.get(var4)).isValideLocation();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("7")) {
                  this.var_acc_usine = ((ObjetCompte)var3.get(var4)).isValideLocation();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("8")) {
                  this.var_acc_box = ((ObjetCompte)var3.get(var4)).isValideLocation();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("9")) {
                  this.var_acc_terrain = ((ObjetCompte)var3.get(var4)).isValideLocation();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("10")) {
                  this.var_acc_chambre = ((ObjetCompte)var3.get(var4)).isValideLocation();
               }
            } else if (this.categorie == 1) {
               if (((ObjetCompte)var3.get(var4)).getCode().equals("0")) {
                  this.var_acc_villa = ((ObjetCompte)var3.get(var4)).isValideSyndic();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("1")) {
                  this.var_acc_appartement = ((ObjetCompte)var3.get(var4)).isValideSyndic();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("2")) {
                  this.var_acc_immeuble = ((ObjetCompte)var3.get(var4)).isValideSyndic();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("3")) {
                  this.var_acc_bureau = ((ObjetCompte)var3.get(var4)).isValideSyndic();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("4")) {
                  this.var_acc_commerce = ((ObjetCompte)var3.get(var4)).isValideSyndic();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("5")) {
                  this.var_acc_garage = ((ObjetCompte)var3.get(var4)).isValideSyndic();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("6")) {
                  this.var_acc_hanger = ((ObjetCompte)var3.get(var4)).isValideSyndic();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("7")) {
                  this.var_acc_usine = ((ObjetCompte)var3.get(var4)).isValideSyndic();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("8")) {
                  this.var_acc_box = ((ObjetCompte)var3.get(var4)).isValideSyndic();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("9")) {
                  this.var_acc_terrain = ((ObjetCompte)var3.get(var4)).isValideSyndic();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("10")) {
                  this.var_acc_chambre = ((ObjetCompte)var3.get(var4)).isValideSyndic();
               }
            } else if (this.categorie == 2) {
               if (((ObjetCompte)var3.get(var4)).getCode().equals("0")) {
                  this.var_acc_villa = ((ObjetCompte)var3.get(var4)).isValideNegoce();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("1")) {
                  this.var_acc_appartement = ((ObjetCompte)var3.get(var4)).isValideNegoce();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("2")) {
                  this.var_acc_immeuble = ((ObjetCompte)var3.get(var4)).isValideNegoce();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("3")) {
                  this.var_acc_bureau = ((ObjetCompte)var3.get(var4)).isValideNegoce();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("4")) {
                  this.var_acc_commerce = ((ObjetCompte)var3.get(var4)).isValideNegoce();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("5")) {
                  this.var_acc_garage = ((ObjetCompte)var3.get(var4)).isValideNegoce();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("6")) {
                  this.var_acc_hanger = ((ObjetCompte)var3.get(var4)).isValideNegoce();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("7")) {
                  this.var_acc_usine = ((ObjetCompte)var3.get(var4)).isValideNegoce();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("8")) {
                  this.var_acc_box = ((ObjetCompte)var3.get(var4)).isValideNegoce();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("9")) {
                  this.var_acc_terrain = ((ObjetCompte)var3.get(var4)).isValideNegoce();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("10")) {
                  this.var_acc_chambre = ((ObjetCompte)var3.get(var4)).isValideNegoce();
               }
            } else if (this.categorie == 3) {
               if (((ObjetCompte)var3.get(var4)).getCode().equals("0")) {
                  this.var_acc_villa = ((ObjetCompte)var3.get(var4)).isValidePromoteur();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("1")) {
                  this.var_acc_appartement = ((ObjetCompte)var3.get(var4)).isValidePromoteur();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("2")) {
                  this.var_acc_immeuble = ((ObjetCompte)var3.get(var4)).isValidePromoteur();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("3")) {
                  this.var_acc_bureau = ((ObjetCompte)var3.get(var4)).isValidePromoteur();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("4")) {
                  this.var_acc_commerce = ((ObjetCompte)var3.get(var4)).isValidePromoteur();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("5")) {
                  this.var_acc_garage = ((ObjetCompte)var3.get(var4)).isValidePromoteur();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("6")) {
                  this.var_acc_hanger = ((ObjetCompte)var3.get(var4)).isValidePromoteur();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("7")) {
                  this.var_acc_usine = ((ObjetCompte)var3.get(var4)).isValidePromoteur();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("8")) {
                  this.var_acc_box = ((ObjetCompte)var3.get(var4)).isValidePromoteur();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("9")) {
                  this.var_acc_terrain = ((ObjetCompte)var3.get(var4)).isValidePromoteur();
               } else if (((ObjetCompte)var3.get(var4)).getCode().equals("10")) {
                  this.var_acc_chambre = ((ObjetCompte)var3.get(var4)).isValidePromoteur();
               }
            }
         }
      }

   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "immobilier" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "immobilier" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
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
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.mesDossiersItems = var2.chargerLesAnalytiques("6", var1);
   }

   public void recupererServiceItem(Session var1) throws HibernateException, NamingException {
      this.mesServicesItems = new ArrayList();
      ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.mesServicesItems = var2.chargerLesServicesItems(0, false, var1);
   }

   public void recupererFormuleItem(Session var1) throws HibernateException, NamingException {
      this.mesFormulesItems = new ArrayList();
      FormulesVentesDao var2 = new FormulesVentesDao(this.baseLog, this.utilInitHibernate);
      this.mesFormulesItems = var2.chargerLesFormules(this.exoselectionne.getExevteId(), var1);
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

         if (this.mesSerieUserItem.size() >= 2) {
            String var5 = "";

            for(int var4 = 0; var4 < this.mesSerieUserItem.size(); ++var4) {
               if (var5 != null && !var5.isEmpty()) {
                  var5 = var5 + "," + ((SelectItem)this.mesSerieUserItem.get(var4)).getValue().toString();
               } else {
                  var5 = ((SelectItem)this.mesSerieUserItem.get(var4)).getValue().toString();
               }
            }

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
         if (var3 != null) {
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
         if (var3 != null) {
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

   }

   public void recupererModeleDocument() {
      String var1 = "";
      if (this.nature == 160) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentCommun" + File.separator + "bien" + File.separator;
      } else if (this.nature == 161) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentLocation" + File.separator + "gerance" + File.separator;
      } else if (this.nature == 162) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentLocation" + File.separator + "bail" + File.separator;
      } else if (this.nature == 163) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentCommun" + File.separator + "ot" + File.separator;
      } else if (this.nature == 164) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentCommun" + File.separator + "facture_charge" + File.separator;
      } else if (this.nature == 165) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentLocation" + File.separator + "location" + File.separator;
      } else if (this.nature == 171) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentSyndic" + File.separator + "syndic" + File.separator;
      } else if (this.nature == 172) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentSyndic" + File.separator + "budget" + File.separator;
      } else if (this.nature == 173) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentSyndic" + File.separator + "appel_charge" + File.separator;
      } else if (this.nature == 175) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentSyndic" + File.separator + "preparation_pv" + File.separator;
      } else if (this.nature == 176) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "documentSyndic" + File.separator + "decision_ag" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.documentImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
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

   }

   public void recupererModeleListe() {
      String var1 = "";
      if (this.nature == 160) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeCommun" + File.separator + "bien" + File.separator;
      } else if (this.nature == 161) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeLocation" + File.separator + "gerance" + File.separator;
      } else if (this.nature == 162) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeLocation" + File.separator + "bail" + File.separator;
      } else if (this.nature == 163) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeCommun" + File.separator + "ot" + File.separator;
      } else if (this.nature == 164) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeCommun" + File.separator + "facture_charge" + File.separator;
      } else if (this.nature == 165) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeLocation" + File.separator + "location" + File.separator;
      } else if (this.nature == 171) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeSyndic" + File.separator + "syndic" + File.separator;
      } else if (this.nature == 172) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeSyndic" + File.separator + "budget" + File.separator;
      } else if (this.nature == 173) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeSyndic" + File.separator + "appel_charge" + File.separator;
      } else if (this.nature == 175) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeSyndic" + File.separator + "preparation_pv" + File.separator;
      } else if (this.nature == 176) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "immobilier" + File.separator + "listeSyndic" + File.separator + "decision_ag" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         if (var3 != null) {
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
      if (this.optionVentes.getProduitAchat().equals("1")) {
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

   public void recupererFamillesGlobal() {
      this.mesFamillesGlobalItems = new ArrayList();
      int var1;
      String var2;
      String[] var3;
      if (this.optionVentes.getProduitAchat().equals("1")) {
         if (this.mesFamillesAchatsItems.size() != 0) {
            this.mesFamillesGlobalItems.add(new SelectItem("", "********* ACHATS *********"));

            for(var1 = 0; var1 < this.mesFamillesAchatsItems.size(); ++var1) {
               var2 = (String)((SelectItem)this.mesFamillesAchatsItems.get(var1)).getValue();
               var3 = var2.split(":");
               this.mesFamillesGlobalItems.add(new SelectItem(var3[0], var3[0] + ":" + var3[1]));
            }
         }

         this.mesFamillesGlobalItems.add(new SelectItem("", "********* VENTES *********"));

         for(var1 = 0; var1 < this.mesFamillesVentesItems.size(); ++var1) {
            var2 = (String)((SelectItem)this.mesFamillesVentesItems.get(var1)).getValue();
            var3 = var2.split(":");
            this.mesFamillesGlobalItems.add(new SelectItem(var3[0], var3[0] + ":" + var3[1]));
         }
      } else if (this.mesFamillesVentesItems.size() != 0) {
         for(var1 = 0; var1 < this.mesFamillesVentesItems.size(); ++var1) {
            var2 = (String)((SelectItem)this.mesFamillesVentesItems.get(var1)).getValue();
            var3 = var2.split(":");
            this.mesFamillesGlobalItems.add(new SelectItem(var3[0], var3[0] + ":" + var3[1]));
         }
      }

   }

   public void recupererDepotItem(Session var1, int var2) throws NamingException {
      this.mesDepotItems = new ArrayList();
      if (this.lastExoAchats != null) {
         DepotAchatsDao var3 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         this.mesDepotItems = var3.selectActifDepotItems(var2, var1);
      }

   }

   public void chargerMesCodesTaxeVnt(Session var1) throws HibernateException, NamingException {
      this.mesTaxesItems = new ArrayList();
      this.mesTaxesItems.add(new SelectItem(0, ""));
      TaxesVentesDao var2 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectActifTaxes(this.exoselectionne.getExevteId(), var1);
      this.var_timbre = 0;
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            TaxesVentes var5 = (TaxesVentes)var3.get(var4);
            if (var5.getTaxvteTimbre() != 0) {
               this.var_timbre = var5.getTaxvteTimbre();
            } else if (var5.getTaxvteCode() != null && !var5.getTaxvteCode().isEmpty()) {
               this.mesTaxesItems.add(new SelectItem(var5.getTaxvteCode(), var5.getTaxvteCode() + ":" + var5.getTaxvteTaux()));
            }
         }
      }

   }

   public void chargerMesCompte(Session var1) throws NamingException {
      this.mesCompteProduitsItems = new ArrayList();
      this.mesCompteStocksItems = new ArrayList();
      this.mesCompteVteLocItems = new ArrayList();
      this.mesCompteVteZItems = new ArrayList();
      this.mesCompteVteHzItems = new ArrayList();
      if (this.lastExoCompta != null && this.lastExoCompta.getExecpt_id() != 0L) {
         String var2 = this.structureLog.getStrzonefiscale();
         PlanComptableDao var3 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
         String var4 = "";
         var4 = "(9,17)";
         this.mesCompteProduitsItems = var3.chargerPlanCmptItems(var2, this.lastExoCompta.getExecpt_id(), var4, 0, var1);
         this.mesCompteVteLocItems = this.mesCompteProduitsItems;
         this.mesCompteVteZItems = this.mesCompteProduitsItems;
         this.mesCompteVteHzItems = this.mesCompteProduitsItems;
         var4 = "(5,9,16)";
         this.mesCompteStocksItems = var3.chargerPlanCmptItems(var2, this.lastExoCompta.getExecpt_id(), var4, 0, var1);
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

   public void recupererLesCommerciauxItem(Session var1) throws HibernateException, NamingException {
      UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.mesResponsablesItems = new ArrayList();
      this.mesCommerciauxItems = new ArrayList();
      if (this.optionVentes.getResponsable() == null || this.optionVentes.getResponsable().isEmpty()) {
         this.optionVentes.setResponsable("0");
      }

      if (this.optionVentes.getResponsable().equals("1")) {
         new ArrayList();
         List var3 = var2.chargerLesSignataires("Ventes", var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               new Users();
               Users var5 = (Users)var3.get(var4);
               this.mesResponsablesItems.add(new SelectItem(var5.getUsrid(), var5.getUsrNom() + ":" + var5.getUsrPrenom()));
            }
         }

         new ArrayList();
         List var7 = var2.chargerLesCommerciaux(var1);
         if (var7.size() != 0) {
            for(int var8 = 0; var8 < var7.size(); ++var8) {
               new Users();
               Users var6 = (Users)var7.get(var8);
               this.mesCommerciauxItems.add(new SelectItem(var6.getUsrid(), var6.getUsrNom() + ":" + var6.getUsrPrenom()));
            }
         }
      } else {
         this.mesResponsablesItems = var2.chargerLesUsersItem(var1);
      }

   }

   public void recupererLesCreateurItem(Session var1) {
      this.mesCreateursItems = new ArrayList();
      this.mesCreateursItems = this.mesCommerciauxItems;
   }

   public void chargerMesClesRepartition(Session var1) throws NamingException {
      this.mesClesItems = new ArrayList();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.mesClesItems = var2.chargerLesAnalytiques("9", var1);
   }

   public void recupererPaysItem() throws IOException {
      this.mesPaysItems = new ArrayList();
      LecturePays var1 = new LecturePays();
      this.mesPaysItems = var1.getMesPaysItems();
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

   public FormExercicesVentes getFormExercicesVentes() {
      return this.formExercicesVentes;
   }

   public void setFormExercicesVentes(FormExercicesVentes var1) {
      this.formExercicesVentes = var1;
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

   public List getMesdevisesItem() {
      return this.mesdevisesItem;
   }

   public void setMesdevisesItem(List var1) {
      this.mesdevisesItem = var1;
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

   public long getLeIdExo() {
      return this.leIdExo;
   }

   public void setLeIdExo(long var1) {
      this.leIdExo = var1;
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

   public boolean isVar_marque_util() {
      return this.var_marque_util;
   }

   public void setVar_marque_util(boolean var1) {
      this.var_marque_util = var1;
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

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
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

   public List getMesFamillesVentesUtilItems() {
      return this.mesFamillesVentesUtilItems;
   }

   public void setMesFamillesVentesUtilItems(List var1) {
      this.mesFamillesVentesUtilItems = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public MenudroitLocationCtrl getMenudroitLocationCtrl() {
      return this.menudroitLocationCtrl;
   }

   public void setMenudroitLocationCtrl(MenudroitLocationCtrl var1) {
      this.menudroitLocationCtrl = var1;
   }

   public MenudroitNegoceCtrl getMenudroitNegoceCtrl() {
      return this.menudroitNegoceCtrl;
   }

   public void setMenudroitNegoceCtrl(MenudroitNegoceCtrl var1) {
      this.menudroitNegoceCtrl = var1;
   }

   public MenudroitSyndicCtrl getMenudroitSyndicCtrl() {
      return this.menudroitSyndicCtrl;
   }

   public void setMenudroitSyndicCtrl(MenudroitSyndicCtrl var1) {
      this.menudroitSyndicCtrl = var1;
   }

   public ObjetLigneMenu getMenuimmobilier() {
      return this.menuimmobilier;
   }

   public void setMenuimmobilier(ObjetLigneMenu var1) {
      this.menuimmobilier = var1;
   }

   public FormBiensImmobilier getFormBiensImmobilier() {
      return this.formBiensImmobilier;
   }

   public void setFormBiensImmobilier(FormBiensImmobilier var1) {
      this.formBiensImmobilier = var1;
   }

   public boolean isVar_acc_appartement() {
      return this.var_acc_appartement;
   }

   public void setVar_acc_appartement(boolean var1) {
      this.var_acc_appartement = var1;
   }

   public boolean isVar_acc_box() {
      return this.var_acc_box;
   }

   public void setVar_acc_box(boolean var1) {
      this.var_acc_box = var1;
   }

   public boolean isVar_acc_bureau() {
      return this.var_acc_bureau;
   }

   public void setVar_acc_bureau(boolean var1) {
      this.var_acc_bureau = var1;
   }

   public boolean isVar_acc_commerce() {
      return this.var_acc_commerce;
   }

   public void setVar_acc_commerce(boolean var1) {
      this.var_acc_commerce = var1;
   }

   public boolean isVar_acc_garage() {
      return this.var_acc_garage;
   }

   public void setVar_acc_garage(boolean var1) {
      this.var_acc_garage = var1;
   }

   public boolean isVar_acc_hanger() {
      return this.var_acc_hanger;
   }

   public void setVar_acc_hanger(boolean var1) {
      this.var_acc_hanger = var1;
   }

   public boolean isVar_acc_immeuble() {
      return this.var_acc_immeuble;
   }

   public void setVar_acc_immeuble(boolean var1) {
      this.var_acc_immeuble = var1;
   }

   public boolean isVar_acc_terrain() {
      return this.var_acc_terrain;
   }

   public void setVar_acc_terrain(boolean var1) {
      this.var_acc_terrain = var1;
   }

   public boolean isVar_acc_usine() {
      return this.var_acc_usine;
   }

   public void setVar_acc_usine(boolean var1) {
      this.var_acc_usine = var1;
   }

   public boolean isVar_acc_villa() {
      return this.var_acc_villa;
   }

   public void setVar_acc_villa(boolean var1) {
      this.var_acc_villa = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
   }

   public FormBailImmobilier getFormBailImmobilier() {
      return this.formBailImmobilier;
   }

   public void setFormBailImmobilier(FormBailImmobilier var1) {
      this.formBailImmobilier = var1;
   }

   public FormGeranceImmobilier getFormGeranceImmobilier() {
      return this.formGeranceImmobilier;
   }

   public void setFormGeranceImmobilier(FormGeranceImmobilier var1) {
      this.formGeranceImmobilier = var1;
   }

   public FormTravauxImmobilier getFormTravauxImmobilier() {
      return this.formTravauxImmobilier;
   }

   public void setFormTravauxImmobilier(FormTravauxImmobilier var1) {
      this.formTravauxImmobilier = var1;
   }

   public int getCategorie() {
      return this.categorie;
   }

   public void setCategorie(int var1) {
      this.categorie = var1;
   }

   public FormFactureImmobilier getFormFactureImmobilier() {
      return this.formFactureImmobilier;
   }

   public void setFormFactureImmobilier(FormFactureImmobilier var1) {
      this.formFactureImmobilier = var1;
   }

   public List getMesSourceItems() {
      return this.mesSourceItems;
   }

   public void setMesSourceItems(List var1) {
      this.mesSourceItems = var1;
   }

   public List getMesFormulesItems() {
      return this.mesFormulesItems;
   }

   public void setMesFormulesItems(List var1) {
      this.mesFormulesItems = var1;
   }

   public FormTransfertImmobilier getFormTransfertImmobilier() {
      return this.formTransfertImmobilier;
   }

   public void setFormTransfertImmobilier(FormTransfertImmobilier var1) {
      this.formTransfertImmobilier = var1;
   }

   public FormImpressionImmobilier getFormImpressionImmobilier() {
      return this.formImpressionImmobilier;
   }

   public void setFormImpressionImmobilier(FormImpressionImmobilier var1) {
      this.formImpressionImmobilier = var1;
   }

   public FormBudgetImmobilier getFormBudgetImmobilier() {
      return this.formBudgetImmobilier;
   }

   public void setFormBudgetImmobilier(FormBudgetImmobilier var1) {
      this.formBudgetImmobilier = var1;
   }

   public FormSyndicImmobilier getFormSyndicImmobilier() {
      return this.formSyndicImmobilier;
   }

   public void setFormSyndicImmobilier(FormSyndicImmobilier var1) {
      this.formSyndicImmobilier = var1;
   }

   public FormDocumentsOfficiels getFormDocumentsOfficiels() {
      return this.formDocumentsOfficiels;
   }

   public void setFormDocumentsOfficiels(FormDocumentsOfficiels var1) {
      this.formDocumentsOfficiels = var1;
   }

   public FormAppelChargeImmobilier getFormAppelChargeImmobilier() {
      return this.formAppelChargeImmobilier;
   }

   public void setFormAppelChargeImmobilier(FormAppelChargeImmobilier var1) {
      this.formAppelChargeImmobilier = var1;
   }

   public FormPvImmobilier getFormPvImmobilier() {
      return this.formPvImmobilier;
   }

   public void setFormPvImmobilier(FormPvImmobilier var1) {
      this.formPvImmobilier = var1;
   }

   public FormBonEncaissementImmobilier getFormBonEncaissementImmobilier() {
      return this.formBonEncaissementImmobilier;
   }

   public void setFormBonEncaissementImmobilier(FormBonEncaissementImmobilier var1) {
      this.formBonEncaissementImmobilier = var1;
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

   public MenudroitPromoteurCtrl getMenudroitPromoteurCtrl() {
      return this.menudroitPromoteurCtrl;
   }

   public void setMenudroitPromoteurCtrl(MenudroitPromoteurCtrl var1) {
      this.menudroitPromoteurCtrl = var1;
   }
}
