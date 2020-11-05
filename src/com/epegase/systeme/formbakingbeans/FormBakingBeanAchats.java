package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.achats.FormAvoirAchats;
import com.epegase.forms.achats.FormBonDecaissementAchats;
import com.epegase.forms.achats.FormCommandeAchats;
import com.epegase.forms.achats.FormCotationAchats;
import com.epegase.forms.achats.FormDemandeAchats;
import com.epegase.forms.achats.FormExtraitBudget;
import com.epegase.forms.achats.FormFactureAchats;
import com.epegase.forms.achats.FormFraisAchats;
import com.epegase.forms.achats.FormImpressionAchats;
import com.epegase.forms.achats.FormNoteDebitAchats;
import com.epegase.forms.achats.FormProduitsAchs;
import com.epegase.forms.achats.FormReacheminementAchats;
import com.epegase.forms.achats.FormReceptionAchats;
import com.epegase.forms.achats.FormRetourAchats;
import com.epegase.forms.achats.FormSerialisation;
import com.epegase.forms.achats.FormSommierAchats;
import com.epegase.forms.achats.FormTransfertAchats;
import com.epegase.forms.achats.FormValorisationAchats;
import com.epegase.forms.administration.FormExercicesAchats;
import com.epegase.forms.commun.FormAffaires;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.stock.FormBonEntree;
import com.epegase.forms.stock.FormBonSortie;
import com.epegase.forms.stock.FormCession;
import com.epegase.forms.stock.FormImpressionStock;
import com.epegase.forms.stock.FormInventaire;
import com.epegase.forms.stock.FormProduction;
import com.epegase.systeme.classe.CampagneEnteteVentes;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesAchats;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.UsersFavoris;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.CampagneEnteteVentesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.CouleurDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.DouanesPositionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.FormulesAchatsDao;
import com.epegase.systeme.dao.FraisTheoAchatsDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.MarquesDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProcessEnteteAchatsDao;
import com.epegase.systeme.dao.ProductionAtelierDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.UsersFavorisDao;
import com.epegase.systeme.menu.MenudroitAchatsCtrl;
import com.epegase.systeme.menu.MenudroitStockCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LectureFamillesFournisseurs;
import com.epegase.systeme.xml.LectureIncoterm;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureNatureAchats;
import com.epegase.systeme.xml.LectureNatureMedical;
import com.epegase.systeme.xml.LectureNatureVentes;
import com.epegase.systeme.xml.LectureReglementFournisseur;
import com.epegase.systeme.xml.LireLesoptionsAchats;
import com.epegase.systeme.xml.LireLesoptionsParcs;
import com.epegase.systeme.xml.LireLesoptionsStocks;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionConfigListe;
import com.epegase.systeme.xml.OptionParcs;
import com.epegase.systeme.xml.OptionStocks;
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

public class FormBakingBeanAchats implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private LectureModulesOnglets lesOnglets;
   private ObjetLigneMenu menuachat;
   private ObjetLigneMenu menuachatMemo = new ObjetLigneMenu();
   private MenudroitAchatsCtrl menudroitAchatsCtrl;
   private ObjetLigneMenu menustock;
   private ObjetLigneMenu menustockMemo = new ObjetLigneMenu();
   private MenudroitStockCtrl menudroitStockCtrl;
   private int nature;
   private OptionAchats optionAchats;
   private OptionStocks optionStocks;
   private OptionParcs optionParcs;
   private OptionVentes optionVentes;
   private Habilitation habilitation;
   private ExercicesAchats exoselectionne;
   private ExercicesAchats lastExoAchats;
   private ExercicesComptable lastExoCompta;
   private ExercicesVentes lastExoVentes;
   private long leIdExo;
   private String quelTransfert;
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
   private long var_memo_id_master;
   private FormExercicesAchats formExercicesAchats;
   private FormProduitsAchs formProduitsAchs;
   private FormCotationAchats formCotationAchats;
   private FormCommandeAchats formCommandeAchats;
   private FormReceptionAchats formReceptionAchats;
   private FormRetourAchats formRetourAchats;
   private FormFactureAchats formFactureAchats;
   private FormAvoirAchats formAvoirAchats;
   private FormNoteDebitAchats formNoteDebitAchats;
   private FormFraisAchats formFraisAchats;
   private FormImpressionAchats formImpressionAchats;
   private FormBonDecaissementAchats formBonDecaissementAchats;
   private FormDemandeAchats formDemandeAchats;
   private FormValorisationAchats formValorisationAchats;
   private FormTransfertAchats formTransfertAchats;
   private FormSommierAchats formSommierAchats;
   private FormExtraitBudget formExtraitBudget;
   private FormSerialisation formSerialisation;
   private FormProduction formProduction;
   private FormAffaires formAffaires;
   private FormReacheminementAchats formReacheminementAchats;
   private FormInventaire formInventaire;
   private FormBonEntree formBonEntree;
   private FormBonSortie formBonSortie;
   private FormCession formCession;
   private FormImpressionStock formImpressionStock;
   private List mesdevisesItem;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private List listeImpressionMvtsItems;
   private List annexItems;
   private List mesIncotermesItems;
   private List lesFamilleFournisseursListe;
   private List lesFamilleClientsListe;
   private List mesFamilleFournisseursItems;
   private List mesFamilleClientsItems;
   private List mesTypeReglements;
   private List lesModeReglementFournisseurListe;
   private List mesResponsablesItems;
   private List lesUsers;
   private List mesSerieUserItem;
   private List mesActivitesItems;
   private List mesServicesItems;
   private List mesMarquesItems;
   private List mesCouleursItems;
   private List mesChantiersItems;
   private List mesParcsItems;
   private List mesDossiersItems;
   private List mesBudgetsItems;
   private List mesFormulesItems;
   private List mesUnitesItems;
   private List mesConditionnementsItems;
   private List listCaisses;
   private List mesBanquesItems;
   private List mesFactorsItems;
   private List mesNaturesFournisseurItems;
   private List mesNaturesClientItems;
   private List mesNaturesGlobaltems;
   private List mesFamillesVentesItems;
   private List mesFamillesVentesUtilItems;
   private List mesFamillesAchatsItems;
   private List mesFamillesAchatsUtilItems;
   private List mesFamillesGlobalItems;
   private List mesFamillesUtilItems;
   private List mesDepotAchItems;
   private List mesDepotPrdItems;
   private List mesDepotVteItems;
   private List mesDepotAchCodeItems;
   private List mesDepotPrdCodeItems;
   private List mesDepotVteCodeItems;
   private List mesRegionsItems;
   private List mesSecteursItems;
   private List mesPdvItems;
   private List mesSitesItems;
   private List mesDepartementsItems;
   private List mesCommerciauxItems;
   private List mesCreateursItems;
   private List mesTaxesAchItems;
   private List listTaxesAch;
   private List mesTaxesVteItems;
   private List mesCompteAchLocItems;
   private List mesCompteAchZItems;
   private List mesCompteAchHzItems;
   private List mesCompteVteLocItems;
   private List mesCompteVteZItems;
   private List mesCompteVteHzItems;
   private List mesCompteProduitsItems;
   private List mesCompteStocksAchItems;
   private List mesCompteStocksVteItems;
   private List mesCompteChargeItems;
   private List mesDouanesItems;
   private List mesClesItems;
   private List modeleBonDecaissementItems;
   private List mesProcessItems;
   private List mesAteliersItems;
   private List mesSourceItems;
   private String listeDepotUser;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private String var_tarif1;
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;

   public void InstancesDaoUtilses() throws IOException, SAXException, JDOMException, ParseException {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererExercices(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      ExercicesAchatsDao var2 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      this.leIdExo = this.exoselectionne.getExeachId();
      this.lastExoAchats = var2.recupererLastExo(var1);
      ExercicesComptableDao var3 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.lastExoCompta = var3.recupererLastExo(var1);
      ExercicesVentesDao var4 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.lastExoVentes = var4.recupererLastExo(var1);
   }

   public void recupererLeIdExo() throws HibernateException, NamingException {
      this.recupererLeIdExo((Session)null);
   }

   public ExercicesAchats recupererLeIdExo(Session var1) throws NamingException {
      ExercicesAchatsDao var2 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      if (this.leIdExo != 0L) {
         this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      } else {
         this.exoselectionne = var2.recupererLastExo(var1);
      }

      this.leIdExo = this.exoselectionne.getExeachId();
      return this.exoselectionne;
   }

   public List getLesExerciceAchat(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesAchats = new FormExercicesAchats();
      this.formExercicesAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesAchats.setBaseLog(this.baseLog);
      this.formExercicesAchats.setStructureLog(this.structureLog);
      this.formExercicesAchats.setUsersLog(this.usersLog);
      this.formExercicesAchats.InstancesDaoUtilses();
      return this.formExercicesAchats.recupererLesexercices(var1);
   }

   public void menuGaucheAchats() throws JDOMException, IOException {
      if (this.menudroitAchatsCtrl == null) {
         this.menudroitAchatsCtrl = new MenudroitAchatsCtrl();
         this.menudroitAchatsCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         boolean var1 = false;
         if (this.optionAchats != null) {
            if (this.optionAchats.getAxeDossier() != null && !this.optionAchats.getAxeDossier().isEmpty() && this.optionAchats.getAxeDossier().equals("2")) {
               var1 = true;
            }

            if (this.structureLog.getStrmaitrecabinet() == 2) {
               this.menudroitAchatsCtrl.chargerMenudroitAchatsGroupeXml(this.usersLog.getUsrCollaboration(), this.optionAchats.getReacheminementREC(), var1);
            } else {
               this.menudroitAchatsCtrl.chargerMenudroitAchatsXml(this.usersLog.getUsrCollaboration(), this.optionAchats.getReacheminementREC(), var1);
            }
         }
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("60000", this.usersLog.getUsrCollaboration());
   }

   public void menuGaucheAchatsPapier() throws JDOMException, IOException {
      if (this.menudroitAchatsCtrl == null) {
         this.menudroitAchatsCtrl = new MenudroitAchatsCtrl();
         this.menudroitAchatsCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         boolean var1 = false;
         if (this.optionAchats != null) {
            if (this.optionAchats.getAxeDossier() != null && !this.optionAchats.getAxeDossier().isEmpty() && this.optionAchats.getAxeDossier().equals("2")) {
               var1 = true;
            }

            this.menudroitAchatsCtrl.chargerMenudroitAchatsPapierXml(this.usersLog.getUsrCollaboration(), var1);
         }
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("60010", this.usersLog.getUsrCollaboration());
   }

   public void menuGaucheAchatsPoulet() throws JDOMException, IOException {
      if (this.menudroitAchatsCtrl == null) {
         this.menudroitAchatsCtrl = new MenudroitAchatsCtrl();
         this.menudroitAchatsCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         boolean var1 = false;
         if (this.optionAchats != null) {
            if (this.optionAchats.getAxeDossier() != null && !this.optionAchats.getAxeDossier().isEmpty() && this.optionAchats.getAxeDossier().equals("2")) {
               var1 = true;
            }

            this.menudroitAchatsCtrl.chargerMenudroitAchatsPouletXml(this.usersLog.getUsrCollaboration(), var1);
         }
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("60020", this.usersLog.getUsrCollaboration());
   }

   public void menuGaucheStock() throws JDOMException, IOException {
      if (this.menudroitStockCtrl == null) {
         this.menudroitStockCtrl = new MenudroitStockCtrl();
         this.menudroitStockCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitStockCtrl.chargerMenudroitStockXml(this.usersLog.getUsrCollaboration(), this.structureLog);
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("60100", this.usersLog.getUsrCollaboration());
   }

   public void razMemoire() {
      this.formAffaires = null;
      this.formAvoirAchats = null;
      this.formBonDecaissementAchats = null;
      this.formBonEntree = null;
      this.formBonSortie = null;
      this.formCession = null;
      this.formCommandeAchats = null;
      this.formCotationAchats = null;
      this.formDemandeAchats = null;
      this.formFactureAchats = null;
      this.formFraisAchats = null;
      this.formImpressionAchats = null;
      this.formImpressionStock = null;
      this.formInventaire = null;
      this.formNoteDebitAchats = null;
      this.formProduction = null;
      this.formProduitsAchs = null;
      this.formSerialisation = null;
      this.formSommierAchats = null;
      this.formTransfertAchats = null;
      this.formValorisationAchats = null;
   }

   public void gestionAchats() throws JDOMException, IOException, SAXException, NamingException, org.apache.commons.el.parser.ParseException, ParseException, org.apache.taglibs.standard.extra.spath.ParseException {
      this.menuachat = new ObjetLigneMenu();
      if (this.menudroitAchatsCtrl.getDataModelMenudroitAchatsXmlList().isRowAvailable()) {
         this.menuachat = (ObjetLigneMenu)this.menudroitAchatsCtrl.getDataModelMenudroitAchatsXmlList().getRowData();
         if (this.menuachat.getLibelle_FR() != null && !this.menuachat.getLibelle_FR().isEmpty()) {
            this.menuachatMemo = this.menuachat;
            this.aiguillageAchats();
         }
      }

   }

   public void gestionAchatsFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, org.apache.commons.el.parser.ParseException, ParseException, org.apache.taglibs.standard.extra.spath.ParseException {
      this.menuachat = var1;
      this.menuachatMemo = this.menuachat;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheAchats();
      }

      this.aiguillageAchats();
   }

   public void aiguillageAchats() throws JDOMException, IOException, SAXException, NamingException, org.apache.commons.el.parser.ParseException, ParseException, org.apache.taglibs.standard.extra.spath.ParseException {
      if (this.lastExoAchats.getExeachId() != this.exoselectionne.getExeachId()) {
         this.menuachat.setAdd(false);
         this.menuachat.setMaj(false);
         this.menuachat.setSup(false);
         this.menuachat.setDup(false);
         this.menuachat.setClo(false);
         this.menuachat.setTrf(false);
      } else {
         this.menuachat.setAdd(this.menuachatMemo.isAdd());
         this.menuachat.setMaj(this.menuachatMemo.isMaj());
         this.menuachat.setSup(this.menuachatMemo.isSup());
         this.menuachat.setDup(this.menuachatMemo.isDup());
         this.menuachat.setClo(this.menuachatMemo.isClo());
         this.menuachat.setTrf(this.menuachatMemo.isTrf());
      }

      this.razMemoire();
      if (!this.menuachat.getCommande().equalsIgnoreCase("60000:01") && !this.menuachat.getCommande().equalsIgnoreCase("60010:01") && !this.menuachat.getCommande().equalsIgnoreCase("60020:01")) {
         Session var1;
         String var2;
         if (!this.menuachat.getCommande().equalsIgnoreCase("60000:02") && !this.menuachat.getCommande().equalsIgnoreCase("60010:02") && !this.menuachat.getCommande().equalsIgnoreCase("60020:02")) {
            if (!this.menuachat.getCommande().equalsIgnoreCase("60000:03") && !this.menuachat.getCommande().equalsIgnoreCase("60010:03") && !this.menuachat.getCommande().equalsIgnoreCase("60020:03")) {
               if (!this.menuachat.getCommande().equalsIgnoreCase("60000:04") && !this.menuachat.getCommande().equalsIgnoreCase("60010:04") && !this.menuachat.getCommande().equalsIgnoreCase("60020:04")) {
                  if (!this.menuachat.getCommande().equalsIgnoreCase("60000:05") && !this.menuachat.getCommande().equalsIgnoreCase("60010:05") && !this.menuachat.getCommande().equalsIgnoreCase("60020:05")) {
                     if (!this.menuachat.getCommande().equalsIgnoreCase("60000:06") && !this.menuachat.getCommande().equalsIgnoreCase("60010:06") && !this.menuachat.getCommande().equalsIgnoreCase("60020:06")) {
                        if (!this.menuachat.getCommande().equalsIgnoreCase("60000:07") && !this.menuachat.getCommande().equalsIgnoreCase("60010:07") && !this.menuachat.getCommande().equalsIgnoreCase("60020:07")) {
                           if (!this.menuachat.getCommande().equalsIgnoreCase("60000:08") && !this.menuachat.getCommande().equalsIgnoreCase("60010:08") && !this.menuachat.getCommande().equalsIgnoreCase("60020:08")) {
                              if (!this.menuachat.getCommande().equalsIgnoreCase("60000:09") && !this.menuachat.getCommande().equalsIgnoreCase("60010:09") && !this.menuachat.getCommande().equalsIgnoreCase("60020:09")) {
                                 if (!this.menuachat.getCommande().equalsIgnoreCase("60000:10") && !this.menuachat.getCommande().equalsIgnoreCase("60010:10") && !this.menuachat.getCommande().equalsIgnoreCase("60020:10")) {
                                    if (!this.menuachat.getCommande().equalsIgnoreCase("60000:11") && !this.menuachat.getCommande().equalsIgnoreCase("60010:11") && !this.menuachat.getCommande().equalsIgnoreCase("60020:11")) {
                                       if (!this.menuachat.getCommande().equalsIgnoreCase("60000:15") && !this.menuachat.getCommande().equalsIgnoreCase("60010:15") && !this.menuachat.getCommande().equalsIgnoreCase("60020:15")) {
                                          if (!this.menuachat.getCommande().equalsIgnoreCase("60000:16") && !this.menuachat.getCommande().equalsIgnoreCase("60010:16") && !this.menuachat.getCommande().equalsIgnoreCase("60020:16")) {
                                             if (!this.menuachat.getCommande().equalsIgnoreCase("60000:17") && !this.menuachat.getCommande().equalsIgnoreCase("60010:17") && !this.menuachat.getCommande().equalsIgnoreCase("60020:17")) {
                                                if (!this.menuachat.getCommande().equalsIgnoreCase("60000:19") && !this.menuachat.getCommande().equalsIgnoreCase("60010:19") && !this.menuachat.getCommande().equalsIgnoreCase("60020:19")) {
                                                   if (!this.menuachat.getCommande().equalsIgnoreCase("60000:20") && !this.menuachat.getCommande().equalsIgnoreCase("60010:20") && !this.menuachat.getCommande().equalsIgnoreCase("60020:20")) {
                                                      if (!this.menuachat.getCommande().equalsIgnoreCase("60000:90") && !this.menuachat.getCommande().equalsIgnoreCase("60010:90") && !this.menuachat.getCommande().equalsIgnoreCase("60020:90")) {
                                                         if (!this.menuachat.getCommande().equalsIgnoreCase("60000:98") && !this.menuachat.getCommande().equalsIgnoreCase("60010:98") && !this.menuachat.getCommande().equalsIgnoreCase("60020:98")) {
                                                            if (this.menuachat.getCommande().equalsIgnoreCase("60000:99") || this.menuachat.getCommande().equalsIgnoreCase("60010:99") || this.menuachat.getCommande().equalsIgnoreCase("60020:99")) {
                                                               this.affichePage = "/achats/SelectionExercicesAchats.jsp";
                                                               this.menuSelectionExercicesAchats();
                                                            }
                                                         } else {
                                                            this.affichePage = "/achats/TransfertAchats.jsp";
                                                            this.menuTransfertAchats();
                                                         }
                                                      } else {
                                                         this.affichePage = "/achats/ImpressionAchats.jsp";
                                                         this.menuImpressionAchats();
                                                      }
                                                   } else {
                                                      this.nature = 19;
                                                      var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonDecaissementAchat");
                                                      this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
                                                      if (this.usersChrono != null) {
                                                         var2 = "" + ((new Date()).getYear() + 1900);
                                                         this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                                                         if (this.chrono != null) {
                                                            this.affichePage = "/achats/BonDecaissementInit.jsp";
                                                            this.menuBonDecaissement();
                                                         } else {
                                                            this.affichePage = "/achats/ErreurAcces.jsp";
                                                            this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                                                         }
                                                      } else {
                                                         this.affichePage = "/achats/ErreurAcces.jsp";
                                                         this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
                                                      }

                                                      this.utilInitHibernate.closeSession();
                                                   }
                                                } else {
                                                   this.nature = 127;
                                                   var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
                                                   this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
                                                   if (this.usersChrono != null) {
                                                      var2 = "" + ((new Date()).getYear() + 1900);
                                                      this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                                                      if (this.chrono != null) {
                                                         this.affichePage = "/achats/AffairesInit.jsp";
                                                         this.menuAffaires(var1);
                                                      } else {
                                                         this.affichePage = "/achats/ErreurAcces.jsp";
                                                         this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                                                      }
                                                   } else {
                                                      this.affichePage = "/ventes/ErreurAcces.jsp";
                                                      this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
                                                   }

                                                   this.utilInitHibernate.closeSession();
                                                }
                                             } else {
                                                this.nature = 37;
                                                this.affichePage = "/achats/ExtraitBudgetInit.jsp";
                                                this.menuExtraitBudget();
                                             }
                                          } else {
                                             this.nature = 36;
                                             var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SommierEnteteLight");
                                             this.affichePage = "/achats/SommierInit.jsp";
                                             this.menuSommier(var1);
                                             this.utilInitHibernate.closeSession();
                                          }
                                       } else {
                                          this.nature = 35;
                                          var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ValorisationEnteteLight");
                                          this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
                                          if (this.usersChrono != null) {
                                             var2 = "" + ((new Date()).getYear() + 1900);
                                             this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                                             if (this.chrono != null) {
                                                this.affichePage = "/achats/ValorisationInit.jsp";
                                                this.menuValorisation(var1);
                                             } else {
                                                this.affichePage = "/achats/ErreurAcces.jsp";
                                                this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                                             }
                                          } else {
                                             this.affichePage = "/achats/ErreurAcces.jsp";
                                             this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
                                          }

                                          this.utilInitHibernate.closeSession();
                                       }
                                    } else {
                                       this.nature = 150;
                                       var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReacheminementEntete");
                                       this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
                                       if (this.usersChrono != null) {
                                          var2 = "" + ((new Date()).getYear() + 1900);
                                          this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                                          if (this.chrono != null) {
                                             this.affichePage = "/achats/ReacheminementInit.jsp";
                                             this.menuReacheminement(var1);
                                          } else {
                                             this.affichePage = "/achats/ErreurAcces.jsp";
                                             this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                                          }
                                       } else {
                                          this.affichePage = "/achats/ErreurAcces.jsp";
                                          this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
                                       }

                                       this.utilInitHibernate.closeSession();
                                    }
                                 } else {
                                    this.nature = 16;
                                    var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AvoirEnteteLight");
                                    this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
                                    if (this.usersChrono != null) {
                                       var2 = "" + ((new Date()).getYear() + 1900);
                                       this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                                       if (this.chrono != null) {
                                          this.affichePage = "/achats/AvoirInit.jsp";
                                          this.menuAvoir(var1);
                                       } else {
                                          this.affichePage = "/achats/ErreurAcces.jsp";
                                          this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                                       }
                                    } else {
                                       this.affichePage = "/achats/ErreurAcces.jsp";
                                       this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
                                    }

                                    this.utilInitHibernate.closeSession();
                                 }
                              } else {
                                 this.nature = 17;
                                 var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "NoteDebitEnteteLight");
                                 this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
                                 if (this.usersChrono != null) {
                                    var2 = "" + ((new Date()).getYear() + 1900);
                                    this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                                    if (this.chrono != null) {
                                       this.affichePage = "/achats/NoteDebitInit.jsp";
                                       this.menuNoteDebit(var1);
                                    } else {
                                       this.affichePage = "/achats/ErreurAcces.jsp";
                                       this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                                    }
                                 } else {
                                    this.affichePage = "/achats/ErreurAcces.jsp";
                                    this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
                                 }

                                 this.utilInitHibernate.closeSession();
                              }
                           } else {
                              this.nature = 18;
                              var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FraisEnteteLight");
                              this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
                              if (this.usersChrono != null) {
                                 var2 = "" + ((new Date()).getYear() + 1900);
                                 this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                                 if (this.chrono != null) {
                                    this.affichePage = "/achats/FraisInit.jsp";
                                    this.menuFactureFrais(var1);
                                 } else {
                                    this.affichePage = "/achats/ErreurAcces.jsp";
                                    this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                                 }
                              } else {
                                 this.affichePage = "/achats/ErreurAcces.jsp";
                                 this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
                              }

                              this.utilInitHibernate.closeSession();
                           }
                        } else {
                           this.nature = 15;
                           var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FactureEnteteLight");
                           this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
                           if (this.usersChrono != null) {
                              var2 = "" + ((new Date()).getYear() + 1900);
                              this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                              if (this.chrono != null) {
                                 this.affichePage = "/achats/FactureInit.jsp";
                                 this.menuFactureAchat(var1);
                              } else {
                                 this.affichePage = "/achats/ErreurAcces.jsp";
                                 this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                              }
                           } else {
                              this.affichePage = "/achats/ErreurAcces.jsp";
                              this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
                           }

                           this.utilInitHibernate.closeSession();
                        }
                     } else {
                        this.nature = 14;
                        var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "RetourEnteteLight");
                        this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
                        if (this.usersChrono != null) {
                           var2 = "" + ((new Date()).getYear() + 1900);
                           this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                           if (this.chrono != null) {
                              this.affichePage = "/achats/RetourInit.jsp";
                              this.menuRetour(var1);
                           } else {
                              this.affichePage = "/achats/ErreurAcces.jsp";
                              this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                           }
                        } else {
                           this.affichePage = "/achats/ErreurAcces.jsp";
                           this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
                        }

                        this.utilInitHibernate.closeSession();
                     }
                  } else {
                     this.nature = 13;
                     var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionEnteteLight");
                     this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
                     if (this.usersChrono != null) {
                        var2 = "" + ((new Date()).getYear() + 1900);
                        this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                        if (this.chrono != null) {
                           this.affichePage = "/achats/ReceptionInit.jsp";
                           this.menuReception(var1);
                        } else {
                           this.affichePage = "/achats/ErreurAcces.jsp";
                           this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                        }
                     } else {
                        this.affichePage = "/achats/ErreurAcces.jsp";
                        this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
                     }

                     this.utilInitHibernate.closeSession();
                  }
               } else {
                  this.nature = 12;
                  var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CommandeEnteteLight");
                  this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
                  if (this.usersChrono != null) {
                     var2 = "" + ((new Date()).getYear() + 1900);
                     this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                     if (this.chrono != null) {
                        this.affichePage = "/achats/CommandeInit.jsp";
                        this.menuCommande(var1);
                     } else {
                        this.affichePage = "/achats/ErreurAcces.jsp";
                        this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                     }
                  } else {
                     this.affichePage = "/achats/ErreurAcces.jsp";
                     this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
                  }

                  this.utilInitHibernate.closeSession();
               }
            } else {
               this.nature = 11;
               var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CotationEnteteLight");
               this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
               if (this.usersChrono != null) {
                  var2 = "" + ((new Date()).getYear() + 1900);
                  this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
                  if (this.chrono != null) {
                     this.affichePage = "/achats/CotationInit.jsp";
                     this.menuCotation(var1);
                  } else {
                     this.affichePage = "/achats/ErreurAcces.jsp";
                     this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
                  }
               } else {
                  this.affichePage = "/achats/ErreurAcces.jsp";
                  this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
               }

               this.utilInitHibernate.closeSession();
            }
         } else {
            this.nature = 10;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DemandeEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/achats/DemandeInit.jsp";
                  this.menuDemande(var1);
               } else {
                  this.affichePage = "/achats/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/achats/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         }
      } else {
         this.nature = 500;
         this.affichePage = "/achats/ProduitsInit.jsp";
         this.menuProduitAchat();
      }

   }

   public void gestionStock() throws JDOMException, IOException, SAXException, NamingException, ParseException {
      this.menustock = new ObjetLigneMenu();
      if (this.menudroitStockCtrl.getDataModelMenudroitStockXmlList().isRowAvailable()) {
         this.menustock = (ObjetLigneMenu)this.menudroitStockCtrl.getDataModelMenudroitStockXmlList().getRowData();
         if (this.menustock.getLibelle_FR() != null && !this.menustock.getLibelle_FR().isEmpty()) {
            this.menustockMemo = this.menustock;
            this.aiguillageStock();
         }
      }

   }

   public void gestionStockFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, ParseException {
      this.menustock = var1;
      this.menustockMemo = this.menustock;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheStock();
      }

      this.aiguillageStock();
   }

   public void aiguillageStock() throws JDOMException, IOException, SAXException, NamingException, ParseException {
      if (this.lastExoAchats.getExeachId() != this.exoselectionne.getExeachId()) {
         this.menustock.setAdd(false);
         this.menustock.setMaj(false);
         this.menustock.setSup(false);
         this.menustock.setDup(false);
         this.menustock.setClo(false);
         this.menustock.setTrf(false);
      } else {
         this.menustock.setAdd(this.menustockMemo.isAdd());
         this.menustock.setMaj(this.menustockMemo.isMaj());
         this.menustock.setSup(this.menustockMemo.isSup());
         this.menustock.setDup(this.menustockMemo.isDup());
         this.menustock.setClo(this.menustockMemo.isClo());
         this.menustock.setTrf(this.menustockMemo.isTrf());
      }

      this.razMemoire();
      if (this.menustock.getCommande().equalsIgnoreCase("60100:01")) {
         this.nature = 500;
         this.affichePage = "/achats/ProduitsInit.jsp";
         this.menuProduitAchat();
      } else {
         Session var1;
         String var2;
         if (this.menustock.getCommande().equalsIgnoreCase("60100:10")) {
            this.nature = 30;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "InventaireEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/stock/InventaireInit.jsp";
                  this.menuInventaire(var1);
               } else {
                  this.affichePage = "/stock/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/stock/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menustock.getCommande().equalsIgnoreCase("60100:11")) {
            this.nature = 31;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEntreeEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/stock/BonEntreeInit.jsp";
                  this.menuBonEntree(var1);
               } else {
                  this.affichePage = "/stock/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/stock/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menustock.getCommande().equalsIgnoreCase("60100:12")) {
            this.nature = 32;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonSortieEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/stock/BonSortieInit.jsp";
                  this.menuBonSortie(var1);
               } else {
                  this.affichePage = "/stock/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/stock/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menustock.getCommande().equalsIgnoreCase("60100:13")) {
            this.nature = 33;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CessionEnteteLight");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/stock/CessionInit.jsp";
                  this.menuCession(var1);
               } else {
                  this.affichePage = "/stock/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/stock/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menustock.getCommande().equalsIgnoreCase("60100:14")) {
            this.nature = 34;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/stock/ProductionInit.jsp";
                  this.menuProduction(var1);
               } else {
                  this.affichePage = "/stock/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/stock/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menustock.getCommande().equalsIgnoreCase("60100:15")) {
            this.nature = 34;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/stock/SimulationProductionInit.jsp";
                  this.menuSimulation(var1);
               } else {
                  this.affichePage = "/stock/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/stock/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menustock.getCommande().equalsIgnoreCase("60100:94")) {
            this.affichePage = "/stock/LotsInit.jsp";
            this.menuLots();
         } else if (this.menustock.getCommande().equalsIgnoreCase("60100:95")) {
            this.affichePage = "/stock/SeriesList.jsp";
            this.menuSeries();
         } else if (this.menustock.getCommande().equalsIgnoreCase("60100:90")) {
            this.affichePage = "/stock/ImpressionStock.jsp";
            this.menuImpressionStock();
         } else if (this.menustock.getCommande().equalsIgnoreCase("60100:98")) {
            this.affichePage = "/stock/TransfertStock.jsp";
         } else if (this.menustock.getCommande().equalsIgnoreCase("60100:99")) {
            this.affichePage = "/achats/SelectionExercicesAchats.jsp";
            this.menuSelectionExercicesAchats();
         }
      }

   }

   public void menuProduitAchat() throws JDOMException, IOException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsAchs");
      this.formProduitsAchs = new FormProduitsAchs();
      this.formProduitsAchs.setutilInitHibernate(this.utilInitHibernate);
      this.formProduitsAchs.setBaseLog(this.baseLog);
      this.formProduitsAchs.setStructureLog(this.structureLog);
      this.formProduitsAchs.setUsersLog(this.usersLog);
      this.formProduitsAchs.instanceDaoUtilises();
      this.formProduitsAchs.setVar_memo_id_master(this.var_memo_id_master);
      this.formProduitsAchs.setExercicesAchats(this.lastExoAchats);
      this.formProduitsAchs.setExercicesVentes(this.lastExoVentes);
      this.formProduitsAchs.setExercicesComptable(this.lastExoCompta);
      this.recupererLesItemsProd(var1);
      this.formProduitsAchs.setVar_simluationPr(this.simulationPrProduit(var1));
      this.formProduitsAchs.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formProduitsAchs.setOptionAchats(this.optionAchats);
      this.formProduitsAchs.setOptionsVentes(this.optionVentes);
      this.formProduitsAchs.setLesFamillesclients(this.lesFamilleClientsListe);
      this.formProduitsAchs.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formProduitsAchs.setFormRecherche(this.formRecherche);
      this.formProduitsAchs.accesResteintGroupe();
      this.formProduitsAchs.setMesMarquesItems(this.mesMarquesItems);
      this.formProduitsAchs.setMesFamillesItems(this.mesFamillesGlobalItems);
      this.formProduitsAchs.setDecoupageActivite(this.decoupageActivite);
      this.formProduitsAchs.setLaColonne1Items(this.laColonne1Items);
      this.formProduitsAchs.setLaColonne2Items(this.laColonne2Items);
      this.formProduitsAchs.setLaColonne3Items(this.laColonne3Items);
      this.formProduitsAchs.setVar_tarif1(this.var_tarif1);
      this.formProduitsAchs.setMesProduitsDepotsItems(this.mesDepotAchItems);
      this.utilInitHibernate.closeSession();
      this.formProduitsAchs.recupererOptions();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuDemande(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formDemandeAchats = new FormDemandeAchats();
      this.formDemandeAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formDemandeAchats.setBaseLog(this.baseLog);
      this.formDemandeAchats.setStructureLog(this.structureLog);
      this.formDemandeAchats.setUsersLog(this.usersLog);
      this.formDemandeAchats.InstancesDaoUtilses();
      this.formDemandeAchats.setNature(this.nature);
      this.formDemandeAchats.setExercicesAchats(this.exoselectionne);
      this.formDemandeAchats.setLastExoAchats(this.lastExoAchats);
      this.formDemandeAchats.setLastExoCompta(this.lastExoCompta);
      this.formDemandeAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formDemandeAchats.setOptionAchats(this.optionAchats);
      if (this.optionParcs != null) {
         this.formDemandeAchats.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
      } else {
         this.formDemandeAchats.setVar_option_parc(100);
      }

      this.formDemandeAchats.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formDemandeAchats.setMesUnitesItems(this.mesUnitesItems);
      this.formDemandeAchats.setMesTaxesAchatsItems(this.mesTaxesAchItems);
      this.formDemandeAchats.setLisTaxesAchats(this.listTaxesAch);
      this.formDemandeAchats.configAchats();
      this.formDemandeAchats.accesResteintUser();
      this.formDemandeAchats.accesResteintGroupe();
      this.formDemandeAchats.chargerLesUsers(var1);
      this.recupererLesItemsDoc(var1);
      byte var2 = 0;
      if (this.mesServicesItems != null && this.mesServicesItems.size() >= 2) {
         var2 = 3;
      } else {
         this.recupererDepartementItem(var1);
         if (this.mesDepartementsItems != null && this.mesDepartementsItems.size() >= 2) {
            var2 = 2;
         } else {
            this.recupererSiteItem(var1);
            if (this.mesSitesItems != null && this.mesSitesItems.size() >= 2) {
               var2 = 1;
            }
         }
      }

      this.formDemandeAchats.setChoixSitDepSer(var2);
      this.formDemandeAchats.setHabilitation(this.habilitation);
      this.formDemandeAchats.setFormRecherche(this.formRecherche);
      this.formDemandeAchats.setDecoupageActivite(this.decoupageActivite);
      this.formDemandeAchats.setLaColonne1Items(this.laColonne1Items);
      this.formDemandeAchats.setLaColonne2Items(this.laColonne2Items);
      this.formDemandeAchats.setLaColonne3Items(this.laColonne3Items);
      this.formDemandeAchats.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formDemandeAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formDemandeAchats.chargeListeDetail(var1);
      }

   }

   public void menuCotation(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formCotationAchats = new FormCotationAchats();
      this.formCotationAchats.setUrlExplorateur(this.urlExplorateur);
      this.formCotationAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formCotationAchats.setBaseLog(this.baseLog);
      this.formCotationAchats.setStructureLog(this.structureLog);
      this.formCotationAchats.setUsersLog(this.usersLog);
      this.formCotationAchats.InstancesDaoUtilses();
      this.formCotationAchats.setNature(this.nature);
      this.formCotationAchats.setExercicesAchats(this.exoselectionne);
      this.formCotationAchats.setLastExoAchats(this.lastExoAchats);
      this.formCotationAchats.setLastExoCompta(this.lastExoCompta);
      this.formCotationAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCotationAchats.setOptionAchats(this.optionAchats);
      if (this.optionParcs != null) {
         this.formCotationAchats.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
      } else {
         this.formCotationAchats.setVar_option_parc(100);
      }

      this.recupererLesItemsDoc(var1);
      this.formCotationAchats.setVar_simluationPr(this.simulationPrCot(var1));
      this.formCotationAchats.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formCotationAchats.setMesUnitesItems(this.mesUnitesItems);
      this.formCotationAchats.setMesTaxesAchatsItems(this.mesTaxesAchItems);
      this.formCotationAchats.setLisTaxesAchats(this.listTaxesAch);
      this.formCotationAchats.setLesFamilleFournisseursListe(this.lesFamilleFournisseursListe);
      this.formCotationAchats.setLesModeReglementFournisseurListe(this.lesModeReglementFournisseurListe);
      this.formCotationAchats.configAchats(var1);
      this.formCotationAchats.accesResteintUser();
      this.formCotationAchats.accesResteintGroupe();
      this.formCotationAchats.setHabilitation(this.habilitation);
      this.formCotationAchats.setFormRecherche(this.formRecherche);
      this.formCotationAchats.setDecoupageActivite(this.decoupageActivite);
      this.formCotationAchats.setLaColonne1Items(this.laColonne1Items);
      this.formCotationAchats.setLaColonne2Items(this.laColonne2Items);
      this.formCotationAchats.setLaColonne3Items(this.laColonne3Items);
      this.formCotationAchats.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formCotationAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formCotationAchats.chargeListeDetail(var1);
      }

   }

   public void menuCommande(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formCommandeAchats = new FormCommandeAchats();
      this.formCommandeAchats.setUrlExplorateur(this.urlExplorateur);
      this.formCommandeAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formCommandeAchats.setBaseLog(this.baseLog);
      this.formCommandeAchats.setStructureLog(this.structureLog);
      this.formCommandeAchats.setUsersLog(this.usersLog);
      this.formCommandeAchats.InstancesDaoUtilses();
      this.formCommandeAchats.setNature(this.nature);
      this.formCommandeAchats.setExercicesAchats(this.exoselectionne);
      this.formCommandeAchats.setLastExoAchats(this.lastExoAchats);
      this.formCommandeAchats.setLastExoCompta(this.lastExoCompta);
      this.formCommandeAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCommandeAchats.setOptionAchats(this.optionAchats);
      if (this.optionParcs != null) {
         this.formCommandeAchats.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
      } else {
         this.formCommandeAchats.setVar_option_parc(100);
      }

      this.recupererLesItemsDoc(var1);
      this.formCommandeAchats.setVar_simluationPr(this.simulationPrCmd(var1));
      this.formCommandeAchats.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formCommandeAchats.setMesUnitesItems(this.mesUnitesItems);
      this.formCommandeAchats.setMesTaxesAchatsItems(this.mesTaxesAchItems);
      this.formCommandeAchats.setLisTaxesAchats(this.listTaxesAch);
      this.formCommandeAchats.setLesFamilleFournisseursListe(this.lesFamilleFournisseursListe);
      this.formCommandeAchats.setLesModeReglementFournisseurListe(this.lesModeReglementFournisseurListe);
      this.formCommandeAchats.configAchats();
      this.formCommandeAchats.accesResteintUser();
      this.formCommandeAchats.accesResteintGroupe();
      this.formCommandeAchats.setHabilitation(this.habilitation);
      this.formCommandeAchats.setFormRecherche(this.formRecherche);
      this.formCommandeAchats.setDecoupageActivite(this.decoupageActivite);
      this.formCommandeAchats.setLaColonne1Items(this.laColonne1Items);
      this.formCommandeAchats.setLaColonne2Items(this.laColonne2Items);
      this.formCommandeAchats.setLaColonne3Items(this.laColonne3Items);
      this.formCommandeAchats.setListCaisses(this.listCaisses);
      this.formCommandeAchats.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, Integer.parseInt(this.optionAchats.getPaiementAVOIR()));
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formCommandeAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formCommandeAchats.chargeListeDetail(var1);
      }

   }

   public void menuReception(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formReceptionAchats = new FormReceptionAchats();
      this.formReceptionAchats.setUrlExplorateur(this.urlExplorateur);
      this.formReceptionAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formReceptionAchats.setBaseLog(this.baseLog);
      this.formReceptionAchats.setStructureLog(this.structureLog);
      this.formReceptionAchats.setUsersLog(this.usersLog);
      this.formReceptionAchats.InstancesDaoUtilses();
      this.formReceptionAchats.setNature(this.nature);
      this.formReceptionAchats.setExercicesAchats(this.exoselectionne);
      this.formReceptionAchats.setLastExoAchats(this.lastExoAchats);
      this.formReceptionAchats.setLastExoCompta(this.lastExoCompta);
      this.formReceptionAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formReceptionAchats.setOptionAchats(this.optionAchats);
      if (this.optionParcs != null) {
         this.formReceptionAchats.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
      } else {
         this.formReceptionAchats.setVar_option_parc(100);
      }

      this.recupererLesItemsDoc(var1);
      this.formReceptionAchats.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formReceptionAchats.setMesUnitesItems(this.mesUnitesItems);
      this.formReceptionAchats.setMesTaxesAchatsItems(this.mesTaxesAchItems);
      this.formReceptionAchats.setLisTaxesAchats(this.listTaxesAch);
      this.formReceptionAchats.setLesFamilleFournisseursListe(this.lesFamilleFournisseursListe);
      this.formReceptionAchats.setLesModeReglementFournisseurListe(this.lesModeReglementFournisseurListe);
      this.formReceptionAchats.setMesDepotAchItems(this.mesDepotAchItems);
      this.formReceptionAchats.configAchats();
      this.formReceptionAchats.accesResteintUser();
      this.formReceptionAchats.accesResteintGroupe();
      this.formReceptionAchats.setHabilitation(this.habilitation);
      this.formReceptionAchats.setFormRecherche(this.formRecherche);
      this.formReceptionAchats.setDecoupageActivite(this.decoupageActivite);
      this.formReceptionAchats.setLaColonne1Items(this.laColonne1Items);
      this.formReceptionAchats.setLaColonne2Items(this.laColonne2Items);
      this.formReceptionAchats.setLaColonne3Items(this.laColonne3Items);
      this.formReceptionAchats.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formReceptionAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formReceptionAchats.chargeListeDetail(var1);
      }

   }

   public void menuReacheminement(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formReacheminementAchats = new FormReacheminementAchats();
      this.formReacheminementAchats.setUrlExplorateur(this.urlExplorateur);
      this.formReacheminementAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formReacheminementAchats.setBaseLog(this.baseLog);
      this.formReacheminementAchats.setStructureLog(this.structureLog);
      this.formReacheminementAchats.setUsersLog(this.usersLog);
      this.formReacheminementAchats.InstancesDaoUtilses();
      this.formReacheminementAchats.setNature(this.nature);
      this.formReacheminementAchats.setExercicesAchats(this.exoselectionne);
      this.formReacheminementAchats.setLastExoAchats(this.lastExoAchats);
      this.formReacheminementAchats.setLastExoCompta(this.lastExoCompta);
      this.formReacheminementAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formReacheminementAchats.setOptionAchats(this.optionAchats);
      this.formReacheminementAchats.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
      this.recupererLesItemsDoc(var1);
      this.formReacheminementAchats.setLesFamilleFournisseursListe(this.lesFamilleFournisseursListe);
      this.formReacheminementAchats.configAchats();
      this.formReacheminementAchats.accesResteintUser();
      this.formReacheminementAchats.accesResteintGroupe();
      this.formReacheminementAchats.setHabilitation(this.habilitation);
      this.formReacheminementAchats.setFormRecherche(this.formRecherche);
      this.formReacheminementAchats.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formReacheminementAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formReacheminementAchats.chargeListeDetail(var1);
      }

   }

   public void menuRetour(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formRetourAchats = new FormRetourAchats();
      this.formRetourAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formRetourAchats.setBaseLog(this.baseLog);
      this.formRetourAchats.setStructureLog(this.structureLog);
      this.formRetourAchats.setUsersLog(this.usersLog);
      this.formRetourAchats.InstancesDaoUtilses();
      this.formRetourAchats.setNature(this.nature);
      this.formRetourAchats.setExercicesAchats(this.exoselectionne);
      this.formRetourAchats.setLastExoAchats(this.lastExoAchats);
      this.formRetourAchats.setLastExoCompta(this.lastExoCompta);
      this.formRetourAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formRetourAchats.setOptionAchats(this.optionAchats);
      if (this.optionParcs != null) {
         this.formRetourAchats.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
      } else {
         this.formRetourAchats.setVar_option_parc(100);
      }

      this.recupererLesItemsDoc(var1);
      this.formRetourAchats.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formRetourAchats.setMesUnitesItems(this.mesUnitesItems);
      this.formRetourAchats.setMesTaxesAchatsItems(this.mesTaxesAchItems);
      this.formRetourAchats.setLisTaxesAchats(this.listTaxesAch);
      this.formRetourAchats.setLesFamilleFournisseursListe(this.lesFamilleFournisseursListe);
      this.formRetourAchats.setLesModeReglementFournisseurListe(this.lesModeReglementFournisseurListe);
      this.formRetourAchats.setMesDepotAchItems(this.mesDepotAchItems);
      this.formRetourAchats.configAchats();
      this.formRetourAchats.accesResteintUser();
      this.formRetourAchats.accesResteintGroupe();
      this.formRetourAchats.setHabilitation(this.habilitation);
      this.formRetourAchats.setFormRecherche(this.formRecherche);
      this.formRetourAchats.setDecoupageActivite(this.decoupageActivite);
      this.formRetourAchats.setLaColonne1Items(this.laColonne1Items);
      this.formRetourAchats.setLaColonne2Items(this.laColonne2Items);
      this.formRetourAchats.setLaColonne3Items(this.laColonne3Items);
      this.formRetourAchats.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formRetourAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formRetourAchats.chargeListeDetail(var1);
      }

   }

   public void menuFactureAchat(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formFactureAchats = new FormFactureAchats();
      this.formFactureAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formFactureAchats.setBaseLog(this.baseLog);
      this.formFactureAchats.setStructureLog(this.structureLog);
      this.formFactureAchats.setUsersLog(this.usersLog);
      this.formFactureAchats.InstancesDaoUtilses();
      this.formFactureAchats.setNature(this.nature);
      this.formFactureAchats.setExercicesAchats(this.exoselectionne);
      this.formFactureAchats.setLastExoAchats(this.lastExoAchats);
      this.formFactureAchats.setLastExoCompta(this.lastExoCompta);
      this.formFactureAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFactureAchats.setOptionAchats(this.optionAchats);
      if (this.optionParcs != null) {
         this.formFactureAchats.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
      } else {
         this.formFactureAchats.setVar_option_parc(100);
      }

      this.recupererLesItemsDoc(var1);
      this.formFactureAchats.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formFactureAchats.setMesUnitesItems(this.mesUnitesItems);
      this.formFactureAchats.setMesTaxesAchatsItems(this.mesTaxesAchItems);
      this.formFactureAchats.setLisTaxesAchats(this.listTaxesAch);
      this.formFactureAchats.setLesFamilleFournisseursListe(this.lesFamilleFournisseursListe);
      this.formFactureAchats.setLesModeReglementFournisseurListe(this.lesModeReglementFournisseurListe);
      this.formFactureAchats.configAchats();
      this.formFactureAchats.accesResteintUser();
      this.formFactureAchats.accesResteintGroupe();
      this.formFactureAchats.setHabilitation(this.habilitation);
      this.formFactureAchats.setFormRecherche(this.formRecherche);
      this.formFactureAchats.setDecoupageActivite(this.decoupageActivite);
      this.formFactureAchats.setLaColonne1Items(this.laColonne1Items);
      this.formFactureAchats.setLaColonne2Items(this.laColonne2Items);
      this.formFactureAchats.setLaColonne3Items(this.laColonne3Items);
      this.formFactureAchats.setListCaisses(this.listCaisses);
      this.formFactureAchats.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, Integer.parseInt(this.optionAchats.getPaiementAVOIR()));
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formFactureAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formFactureAchats.chargeListeDetail(var1);
      }

   }

   public void menuFactureFrais(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formFraisAchats = new FormFraisAchats();
      this.formFraisAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formFraisAchats.setBaseLog(this.baseLog);
      this.formFraisAchats.setStructureLog(this.structureLog);
      this.formFraisAchats.setUsersLog(this.usersLog);
      this.formFraisAchats.InstancesDaoUtilses();
      this.formFraisAchats.setNature(this.nature);
      this.formFraisAchats.setExercicesAchats(this.exoselectionne);
      this.formFraisAchats.setLastExoAchats(this.lastExoAchats);
      this.formFraisAchats.setLastExoCompta(this.lastExoCompta);
      this.formFraisAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFraisAchats.setOptionAchats(this.optionAchats);
      if (this.optionParcs != null) {
         this.formFraisAchats.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
      } else {
         this.formFraisAchats.setVar_option_parc(100);
      }

      this.recupererLesItemsDoc(var1);
      this.formFraisAchats.setMesUnitesItems(this.mesUnitesItems);
      this.formFraisAchats.setMesTaxesAchatsItems(this.mesTaxesAchItems);
      this.formFraisAchats.setLisTaxesAchats(this.listTaxesAch);
      this.formFraisAchats.setLesFamilleFournisseursListe(this.lesFamilleFournisseursListe);
      this.formFraisAchats.setLesModeReglementFournisseurListe(this.lesModeReglementFournisseurListe);
      this.formFraisAchats.configAchats();
      this.formFraisAchats.accesResteintUser();
      this.formFraisAchats.accesResteintGroupe();
      this.formFraisAchats.setHabilitation(this.habilitation);
      this.formFraisAchats.setFormRecherche(this.formRecherche);
      this.formFraisAchats.setDecoupageActivite(this.decoupageActivite);
      this.formFraisAchats.setLaColonne1Items(this.laColonne1Items);
      this.formFraisAchats.setLaColonne2Items(this.laColonne2Items);
      this.formFraisAchats.setLaColonne3Items(this.laColonne3Items);
      this.formFraisAchats.setListCaisses(this.listCaisses);
      this.formFraisAchats.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formFraisAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formFraisAchats.chargeListeDetail(var1);
      }

   }

   public void menuAvoir(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formAvoirAchats = new FormAvoirAchats();
      this.formAvoirAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formAvoirAchats.setBaseLog(this.baseLog);
      this.formAvoirAchats.setStructureLog(this.structureLog);
      this.formAvoirAchats.setUsersLog(this.usersLog);
      this.formAvoirAchats.InstancesDaoUtilses();
      this.formAvoirAchats.setNature(this.nature);
      this.formAvoirAchats.setExercicesAchats(this.exoselectionne);
      this.formAvoirAchats.setLastExoAchats(this.lastExoAchats);
      this.formAvoirAchats.setLastExoCompta(this.lastExoCompta);
      this.formAvoirAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formAvoirAchats.setOptionAchats(this.optionAchats);
      if (this.optionParcs != null) {
         this.formAvoirAchats.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
      } else {
         this.formAvoirAchats.setVar_option_parc(100);
      }

      this.recupererLesItemsDoc(var1);
      this.formAvoirAchats.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formAvoirAchats.setMesUnitesItems(this.mesUnitesItems);
      this.formAvoirAchats.setMesTaxesAchatsItems(this.mesTaxesAchItems);
      this.formAvoirAchats.setLisTaxesAchats(this.listTaxesAch);
      this.formAvoirAchats.setLesFamilleFournisseursListe(this.lesFamilleFournisseursListe);
      this.formAvoirAchats.setLesModeReglementFournisseurListe(this.lesModeReglementFournisseurListe);
      this.formAvoirAchats.configAchats();
      this.formAvoirAchats.accesResteintUser();
      this.formAvoirAchats.accesResteintGroupe();
      this.formAvoirAchats.setHabilitation(this.habilitation);
      this.formAvoirAchats.setFormRecherche(this.formRecherche);
      this.formAvoirAchats.setDecoupageActivite(this.decoupageActivite);
      this.formAvoirAchats.setLaColonne1Items(this.laColonne1Items);
      this.formAvoirAchats.setLaColonne2Items(this.laColonne2Items);
      this.formAvoirAchats.setLaColonne3Items(this.laColonne3Items);
      this.formAvoirAchats.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formAvoirAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formAvoirAchats.chargeListeDetail(var1);
      }

   }

   public void menuNoteDebit(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formNoteDebitAchats = new FormNoteDebitAchats();
      this.formNoteDebitAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formNoteDebitAchats.setBaseLog(this.baseLog);
      this.formNoteDebitAchats.setStructureLog(this.structureLog);
      this.formNoteDebitAchats.setUsersLog(this.usersLog);
      this.formNoteDebitAchats.InstancesDaoUtilses();
      this.formNoteDebitAchats.setNature(this.nature);
      this.formNoteDebitAchats.setExercicesAchats(this.exoselectionne);
      this.formNoteDebitAchats.setLastExoAchats(this.lastExoAchats);
      this.formNoteDebitAchats.setLastExoCompta(this.lastExoCompta);
      this.formNoteDebitAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formNoteDebitAchats.setOptionAchats(this.optionAchats);
      if (this.optionParcs != null) {
         this.formNoteDebitAchats.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
      } else {
         this.formNoteDebitAchats.setVar_option_parc(100);
      }

      this.recupererLesItemsDoc(var1);
      this.formNoteDebitAchats.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formNoteDebitAchats.setMesUnitesItems(this.mesUnitesItems);
      this.formNoteDebitAchats.setMesTaxesAchatsItems(this.mesTaxesAchItems);
      this.formNoteDebitAchats.setLisTaxesAchats(this.listTaxesAch);
      this.formNoteDebitAchats.setLesFamilleFournisseursListe(this.lesFamilleFournisseursListe);
      this.formNoteDebitAchats.setLesModeReglementFournisseurListe(this.lesModeReglementFournisseurListe);
      this.formNoteDebitAchats.configAchats();
      this.formNoteDebitAchats.accesResteintUser();
      this.formNoteDebitAchats.accesResteintGroupe();
      this.formNoteDebitAchats.setHabilitation(this.habilitation);
      this.formNoteDebitAchats.setFormRecherche(this.formRecherche);
      this.formNoteDebitAchats.setDecoupageActivite(this.decoupageActivite);
      this.formNoteDebitAchats.setLaColonne1Items(this.laColonne1Items);
      this.formNoteDebitAchats.setLaColonne2Items(this.laColonne2Items);
      this.formNoteDebitAchats.setLaColonne3Items(this.laColonne3Items);
      this.formNoteDebitAchats.setListCaisses(this.listCaisses);
      this.formNoteDebitAchats.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formNoteDebitAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formNoteDebitAchats.chargeListeDetail(var1);
      }

   }

   public void menuValorisation(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formValorisationAchats = new FormValorisationAchats();
      this.formValorisationAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formValorisationAchats.setBaseLog(this.baseLog);
      this.formValorisationAchats.setStructureLog(this.structureLog);
      this.formValorisationAchats.setUsersLog(this.usersLog);
      this.formValorisationAchats.InstancesDaoUtilses();
      this.formValorisationAchats.setNature(this.nature);
      this.formValorisationAchats.setExercicesAchats(this.exoselectionne);
      this.formValorisationAchats.setLastExoAchats(this.lastExoAchats);
      this.formValorisationAchats.setLastExoCompta(this.lastExoCompta);
      this.formValorisationAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formValorisationAchats.setOptionAchats(this.optionAchats);
      this.formValorisationAchats.configAchats();
      this.formValorisationAchats.accesResteintUser();
      this.formValorisationAchats.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formValorisationAchats.setHabilitation(this.habilitation);
      this.formValorisationAchats.setFormRecherche(this.formRecherche);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formValorisationAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formValorisationAchats.chargeListeDetail(var1);
      }

   }

   public void menuSommier(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, org.apache.commons.el.parser.ParseException, ParseException {
      this.formSommierAchats = new FormSommierAchats();
      this.formSommierAchats.setUtilInitHibernate(this.utilInitHibernate);
      this.formSommierAchats.setBaseLog(this.baseLog);
      this.formSommierAchats.setStructureLog(this.structureLog);
      this.formSommierAchats.setUsersLog(this.usersLog);
      this.formSommierAchats.InstancesDaoUtilses();
      this.formSommierAchats.setNature(this.nature);
      this.formSommierAchats.setExercicesAchats(this.exoselectionne);
      this.formSommierAchats.setLastExoAchats(this.lastExoAchats);
      this.formSommierAchats.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formSommierAchats.setOptionAchats(this.optionAchats);
      this.formSommierAchats.configAchats();
      this.formSommierAchats.accesResteintUser();
      this.formSommierAchats.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formSommierAchats.setFormRecherche(this.formRecherche);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formSommierAchats.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formSommierAchats.chargeListeDetail(var1);
      }

   }

   public void menuAffaires(Session var1) throws ParseException, NamingException, IOException, JDOMException {
      this.formAffaires = new FormAffaires();
      this.formAffaires.setutilInitHibernate(this.utilInitHibernate);
      this.formAffaires.setBaseLog(this.baseLog);
      this.formAffaires.setStructureLog(this.structureLog);
      this.formAffaires.setUsersLog(this.usersLog);
      this.formAffaires.InstancesDaoUtilses();
      this.formAffaires.setLigneMenu(this.menuachat);
      this.formAffaires.recupererOptionsTiersAchats(var1);
      this.formAffaires.chargerAnnees(var1);
      this.formAffaires.chargerServices(var1);
      this.recupererLesItemsDoc(var1);
      this.formAffaires.chargerCommerciauxResponsable(var1);
      this.formAffaires.setHabilitation(this.habilitation);
      this.formAffaires.setFormRecherche(this.formRecherche);
      this.formAffaires.setUrlExplorateur(this.urlExplorateur);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formAffaires.chargerLesAffaires(var1);
      }

   }

   public void menuExtraitBudget() throws IOException, org.apache.taglibs.standard.extra.spath.ParseException, HibernateException, NamingException {
      this.formExtraitBudget = new FormExtraitBudget();
      this.formExtraitBudget.setutilInitHibernate(this.utilInitHibernate);
      this.formExtraitBudget.setBaseLog(this.baseLog);
      this.formExtraitBudget.setStructureLog(this.structureLog);
      this.formExtraitBudget.setUsersLog(this.usersLog);
      this.formExtraitBudget.InstancesDaoUtilses();
      this.formExtraitBudget.setOptionAchats(this.optionAchats);
      this.formExtraitBudget.setLesModelesAutorises(this.lesModelesAutorises);
      this.formExtraitBudget.setSelectedExo(this.exoselectionne);
      this.formExtraitBudget.setLastExo(this.lastExoAchats);
      this.formExtraitBudget.setLastExoCompta(this.lastExoCompta);
      this.formExtraitBudget.setNature(this.nature);
      this.formExtraitBudget.initAnalytique();
      this.formExtraitBudget.calculAnnee();
   }

   public void menuBonDecaissement() throws JDOMException, IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonDecaissementAchat");
      this.formBonDecaissementAchats = new FormBonDecaissementAchats();
      this.formBonDecaissementAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formBonDecaissementAchats.setBaseLog(this.baseLog);
      this.formBonDecaissementAchats.setStructureLog(this.structureLog);
      this.formBonDecaissementAchats.setUsersLog(this.usersLog);
      this.formBonDecaissementAchats.InstancesDaoUtilses();
      this.formBonDecaissementAchats.setExercicesAchats(this.exoselectionne);
      this.formBonDecaissementAchats.setOptionAchats(this.optionAchats);
      this.formBonDecaissementAchats.setUsersChrono(this.usersChrono);
      this.formBonDecaissementAchats.chargerFind(var1);
      this.recupererLesItemsDoc(var1);
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuImpressionAchats() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      this.formImpressionAchats = new FormImpressionAchats();
      this.formImpressionAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionAchats.setBaseLog(this.baseLog);
      this.formImpressionAchats.setStructureLog(this.structureLog);
      this.formImpressionAchats.setUsersLog(this.usersLog);
      this.formImpressionAchats.InstancesDaoUtilses();
      this.formImpressionAchats.setExoSelectionne(this.exoselectionne);
      this.formImpressionAchats.setOptionAchats(this.optionAchats);
      this.formImpressionAchats.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionAchats.chargerLesRepImpAchats(var1);
      this.formImpressionAchats.calculeAnalytique();
      this.recupererLesItemsImpression(var1);
      this.formImpressionAchats.initImpression();
      this.formImpressionAchats.chargerPeriodes();
      this.utilInitHibernate.closeSession();
   }

   public void menuTransfertAchats() {
      this.formTransfertAchats = new FormTransfertAchats();
      this.formTransfertAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertAchats.setBaseLog(this.baseLog);
      this.formTransfertAchats.setStructureLog(this.structureLog);
      this.formTransfertAchats.setUsersLog(this.usersLog);
      this.formTransfertAchats.InstancesDaoUtilses();
      this.formTransfertAchats.setOptionAchats(this.optionAchats);
   }

   public void menuSelectionExercicesAchats() throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesAchats = new FormExercicesAchats();
      this.formExercicesAchats.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesAchats.setBaseLog(this.baseLog);
      this.formExercicesAchats.setStructureLog(this.structureLog);
      this.formExercicesAchats.setUsersLog(this.usersLog);
      this.formExercicesAchats.InstancesDaoUtilses();
      this.leIdExo = this.exoselectionne.getExeachId();
      this.formExercicesAchats.setLesexercicesAchats(this.formExercicesAchats.recupererLesexercices((Session)null));
   }

   public void menuInventaire(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formInventaire = new FormInventaire();
      this.formInventaire.setutilInitHibernate(this.utilInitHibernate);
      this.formInventaire.setBaseLog(this.baseLog);
      this.formInventaire.setStructureLog(this.structureLog);
      this.formInventaire.setUsersLog(this.usersLog);
      this.formInventaire.InstancesDaoUtilses();
      this.formInventaire.setNature(this.nature);
      this.formInventaire.setExercicesAchats(this.exoselectionne);
      this.formInventaire.setLastExoAchats(this.lastExoAchats);
      this.formInventaire.setLastExoCompta(this.lastExoCompta);
      this.formInventaire.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formInventaire.setOptionAchats(this.optionAchats);
      this.formInventaire.setOptionStocks(this.optionStocks);
      this.formInventaire.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formInventaire.setMesUnitesItems(this.mesUnitesItems);
      this.formInventaire.configAchats();
      this.formInventaire.accesResteintUser();
      this.formInventaire.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.chargerLesUsers(var1);
      this.formInventaire.chargerEquipes(var1);
      this.formInventaire.setHabilitation(this.habilitation);
      this.formInventaire.setFormRecherche(this.formRecherche);
      this.formInventaire.setDecoupageActivite(this.decoupageActivite);
      this.formInventaire.setLaColonne1Items(this.laColonne1Items);
      this.formInventaire.setLaColonne2Items(this.laColonne2Items);
      this.formInventaire.setLaColonne3Items(this.laColonne3Items);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1")) {
         if (this.mesServicesItems.size() != 0) {
            this.formInventaire.setInpService(((SelectItem)this.mesServicesItems.get(0)).getLabel().toString());
         } else {
            this.formInventaire.setInpService("100");
         }

         this.formInventaire.chargeListeDetail(var1);
      }

   }

   public void menuBonEntree(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formBonEntree = new FormBonEntree();
      this.formBonEntree.setutilInitHibernate(this.utilInitHibernate);
      this.formBonEntree.setBaseLog(this.baseLog);
      this.formBonEntree.setStructureLog(this.structureLog);
      this.formBonEntree.setUsersLog(this.usersLog);
      this.formBonEntree.InstancesDaoUtilses();
      this.formBonEntree.setNature(this.nature);
      this.formBonEntree.setExercicesAchats(this.exoselectionne);
      this.formBonEntree.setLastExoAchats(this.lastExoAchats);
      this.formBonEntree.setLastExoCompta(this.lastExoCompta);
      this.formBonEntree.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formBonEntree.setOptionAchats(this.optionAchats);
      this.formBonEntree.setOptionStocks(this.optionStocks);
      this.formBonEntree.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formBonEntree.setMesUnitesItems(this.mesUnitesItems);
      this.formBonEntree.configAchats();
      this.formBonEntree.accesResteintUser();
      this.formBonEntree.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.chargerLesUsers(var1);
      this.recupererLesCommerciauxStockItem(var1);
      this.formBonEntree.chargerEquipes(var1);
      this.formBonEntree.setLesRapporteurItems(this.mesCommerciauxItems);
      this.formBonEntree.setHabilitation(this.habilitation);
      this.formBonEntree.setFormRecherche(this.formRecherche);
      this.formBonEntree.setDecoupageActivite(this.decoupageActivite);
      this.formBonEntree.setLaColonne1Items(this.laColonne1Items);
      this.formBonEntree.setLaColonne2Items(this.laColonne2Items);
      this.formBonEntree.setLaColonne3Items(this.laColonne3Items);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1")) {
         if (this.mesServicesItems.size() != 0) {
            this.formBonEntree.setInpService(((SelectItem)this.mesServicesItems.get(0)).getLabel().toString());
         } else {
            this.formBonEntree.setInpService("100");
         }

         this.formBonEntree.chargeListeDetail(var1);
      }

   }

   public void menuBonSortie(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formBonSortie = new FormBonSortie();
      this.formBonSortie.setutilInitHibernate(this.utilInitHibernate);
      this.formBonSortie.setBaseLog(this.baseLog);
      this.formBonSortie.setStructureLog(this.structureLog);
      this.formBonSortie.setUsersLog(this.usersLog);
      this.formBonSortie.InstancesDaoUtilses();
      this.formBonSortie.setNature(this.nature);
      this.formBonSortie.setExercicesAchats(this.exoselectionne);
      this.formBonSortie.setLastExoAchats(this.lastExoAchats);
      this.formBonSortie.setLastExoCompta(this.lastExoCompta);
      this.formBonSortie.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formBonSortie.setOptionAchats(this.optionAchats);
      this.formBonSortie.setOptionStocks(this.optionStocks);
      this.formBonSortie.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formBonSortie.setMesUnitesItems(this.mesUnitesItems);
      this.formBonSortie.configAchats();
      this.formBonSortie.accesResteintUser();
      this.formBonSortie.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.chargerLesUsers(var1);
      this.recupererLesCommerciauxStockItem(var1);
      this.formBonSortie.setLesDemandeursItems(this.mesCommerciauxItems);
      this.formBonSortie.chargerEquipes(var1);
      this.formBonSortie.setHabilitation(this.habilitation);
      this.formBonSortie.setFormRecherche(this.formRecherche);
      this.formBonSortie.setDecoupageActivite(this.decoupageActivite);
      this.formBonSortie.setLaColonne1Items(this.laColonne1Items);
      this.formBonSortie.setLaColonne2Items(this.laColonne2Items);
      this.formBonSortie.setLaColonne3Items(this.laColonne3Items);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1")) {
         if (this.mesServicesItems.size() != 0) {
            this.formBonSortie.setInpService(((SelectItem)this.mesServicesItems.get(0)).getLabel().toString());
         } else {
            this.formBonSortie.setInpService("100");
         }

         this.formBonSortie.chargeListeDetail(var1);
      }

   }

   public void menuCession(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formCession = new FormCession();
      this.formCession.setutilInitHibernate(this.utilInitHibernate);
      this.formCession.setBaseLog(this.baseLog);
      this.formCession.setStructureLog(this.structureLog);
      this.formCession.setUsersLog(this.usersLog);
      this.formCession.InstancesDaoUtilses();
      this.formCession.setNature(this.nature);
      this.formCession.setExercicesAchats(this.exoselectionne);
      this.formCession.setLastExoAchats(this.lastExoAchats);
      this.formCession.setLastExoCompta(this.lastExoCompta);
      this.formCession.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCession.setOptionAchats(this.optionAchats);
      this.formCession.setOptionStocks(this.optionStocks);
      this.formCession.setMesConditionnementsItems(this.mesConditionnementsItems);
      this.formCession.setMesUnitesItems(this.mesUnitesItems);
      this.formCession.configAchats();
      this.formCession.accesResteintUser();
      this.formCession.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.chargerLesUsers(var1);
      this.formCession.chargerEquipes(var1);
      this.formCession.chargerDepotDestinations(var1);
      this.formCession.setHabilitation(this.habilitation);
      this.formCession.setFormRecherche(this.formRecherche);
      this.formCession.setDecoupageActivite(this.decoupageActivite);
      this.formCession.setLaColonne1Items(this.laColonne1Items);
      this.formCession.setLaColonne2Items(this.laColonne2Items);
      this.formCession.setLaColonne3Items(this.laColonne3Items);
      this.formCession.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1")) {
         if (this.mesServicesItems.size() != 0) {
            this.formCession.setInpService(((SelectItem)this.mesServicesItems.get(0)).getLabel().toString());
         } else {
            this.formCession.setInpService("100");
         }

         this.formCession.chargeListeDetail(var1);
      }

   }

   public void menuProduction(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formProduction = new FormProduction();
      this.formProduction.setutilInitHibernate(this.utilInitHibernate);
      this.formProduction.setBaseLog(this.baseLog);
      this.formProduction.setStructureLog(this.structureLog);
      this.formProduction.setUsersLog(this.usersLog);
      this.formProduction.InstancesDaoUtilses();
      this.formProduction.setNature(this.nature);
      this.formProduction.setExercicesAchats(this.exoselectionne);
      this.formProduction.setLastExoAchats(this.lastExoAchats);
      this.formProduction.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formProduction.setOptionAchats(this.optionAchats);
      this.formProduction.setOptionStocks(this.optionStocks);
      this.formProduction.setMesUnitesItems(this.mesUnitesItems);
      this.formProduction.configAchats(var1);
      this.formProduction.accesResteintUser();
      this.formProduction.accesResteintGroupe();
      this.recupererLesItemsFabrication(var1);
      this.chargerLesUsers(var1);
      this.formProduction.chargerEquipes(var1);
      if (this.mesServicesItems.size() != 0) {
         this.formProduction.setInpService(((SelectItem)this.mesServicesItems.get(0)).getValue().toString());
         this.formProduction.chargerlisteProcess(var1);
         this.formProduction.chargerlisteDepot(var1);
      } else {
         this.formProduction.setMesProcessItems(this.mesProcessItems);
         this.formProduction.setMesDepotAchItems(this.mesDepotAchCodeItems);
      }

      this.formProduction.setHabilitation(this.habilitation);
      this.formProduction.setMesAteliersItems(this.mesAteliersItems);
      this.formProduction.setFormRecherche(this.formRecherche);
      this.formProduction.setDecoupageActivite(this.decoupageActivite);
      this.formProduction.setLaColonne1Items(this.laColonne1Items);
      this.formProduction.setLaColonne2Items(this.laColonne2Items);
      this.formProduction.setLaColonne3Items(this.laColonne3Items);
      this.formProduction.setVerrouDepotUser(this.listeDepotUser);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionAchats.getChargementListe() != null && !this.optionAchats.getChargementListe().isEmpty() && this.optionAchats.getChargementListe().equals("1")) {
         this.formProduction.chargeListeDetail(var1);
      }

   }

   public void menuSimulation(Session var1) throws JDOMException, IOException, SAXException {
   }

   public void menuLots() {
      this.formSerialisation = new FormSerialisation();
      this.formSerialisation.setUtilInitHibernate(this.utilInitHibernate);
      this.formSerialisation.setBaseLog(this.baseLog);
      this.formSerialisation.setStructureLog(this.structureLog);
      this.formSerialisation.setUsersLog(this.usersLog);
      this.formSerialisation.InstancesDaoUtilses();
      this.formSerialisation.setExercicesAchats(this.lastExoAchats);
      this.formSerialisation.setOptionAchats(this.optionAchats);
      this.formSerialisation.configAchats();
   }

   public void menuSeries() throws IOException, SAXException, JDOMException {
      this.formSerialisation = new FormSerialisation();
      this.formSerialisation.setUtilInitHibernate(this.utilInitHibernate);
      this.formSerialisation.setBaseLog(this.baseLog);
      this.formSerialisation.setStructureLog(this.structureLog);
      this.formSerialisation.setUsersLog(this.usersLog);
      this.formSerialisation.InstancesDaoUtilses();
      this.formSerialisation.setExercicesAchats(this.lastExoAchats);
      this.formSerialisation.setOptionAchats(this.optionAchats);
      this.formSerialisation.configAchats();
   }

   public void menuImpressionStock() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentStock");
      this.formImpressionStock = new FormImpressionStock();
      this.formImpressionStock.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionStock.setBaseLog(this.baseLog);
      this.formImpressionStock.setStructureLog(this.structureLog);
      this.formImpressionStock.setUsersLog(this.usersLog);
      this.formImpressionStock.InstancesDaoUtilses();
      this.formImpressionStock.setExoSelectionne(this.exoselectionne);
      this.formImpressionStock.setOptionAchats(this.optionAchats);
      this.formImpressionStock.setOptionStocks(this.optionStocks);
      this.formImpressionStock.setOptionVentes(this.optionVentes);
      this.formImpressionStock.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionStock.chargerLesRepImpStocks(var1);
      this.formImpressionStock.calculeAnalytique();
      this.recupererLesItemsImpression(var1);
      this.formImpressionStock.setLaColonne1Items(this.laColonne1Items);
      this.formImpressionStock.setLaColonne2Items(this.laColonne2Items);
      this.formImpressionStock.setLaColonne3Items(this.laColonne3Items);
      this.formImpressionStock.initImpression();
      this.formImpressionStock.chargerPeriodes();
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void recupererTousLesItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererOptionsAchats();
      this.recupererOptionsStocks();
      this.recupererOptionsVentes();
      this.recupererModelesAutorises();
      this.recupererAnnexe(var1);
      this.recupererLesIncotermsItem();
      this.recupererDevisesItem(var1);
      this.recupererFormuleItem(var1);
      this.recupererConditionnementItem(var1);
      this.recupererCouleursItem(var1);
      this.recupererUniteItem(var1);
      this.recupererFactorsItem(var1);
      this.recupererBanquesItem(var1);
      this.recupererFamillesFournisseurItem();
      this.recupererTypesReglementsItem();
      this.recupererCaisses(var1);
      this.chargerMesCodesTaxeAch(var1);
      this.recupererBudgetItem(var1);
      this.recupererChantierItem(var1);
      this.recupererActiviteItem(var1);
      this.recupererParcItem(var1);
      this.recupererDossierItem(var1);
      this.recupererServiceItem(var1);
      this.recupererModeleBonDecaissement();
   }

   public void recupererLesItemsDoc(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererSerieUserItem(var1);
      this.recupererModeleDocument();
      this.recupererModeleListe();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
      this.recupererHabilitation(var1);
      this.recupererDepotItem(var1, this.nature);
      this.recupererFamilleProduitAchatsUtilItem(var1);
      this.recupererSourceListe(var1);
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "achats" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "achats" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

   }

   public boolean simulationPrProduit(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      FraisTheoAchatsDao var3 = new FraisTheoAchatsDao(this.baseLog, this.utilInitHibernate);
      var2 = var3.verifSimulationPrProduit(var1);
      return var2;
   }

   public boolean simulationPrCot(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      FraisTheoAchatsDao var3 = new FraisTheoAchatsDao(this.baseLog, this.utilInitHibernate);
      var2 = var3.verifSimulationPrCot(var1);
      return var2;
   }

   public boolean simulationPrCmd(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      FraisTheoAchatsDao var3 = new FraisTheoAchatsDao(this.baseLog, this.utilInitHibernate);
      var2 = var3.verifSimulationPrCmd(var1);
      return var2;
   }

   public void recupererLesItemsProd(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererLesNaturesAchItem();
      this.recupererLesNaturesVteItem();
      this.recupererLesNaturesGlobalItem();
      this.recupererFamillesClientItem();
      this.recupererFamilleProduitAchatsUtilItem(var1);
      this.recupererFamilleProduitVentesUtilItem(var1);
      this.recupererFamillesGlobal();
      this.recupererDepotItem(var1, 0);
      this.chargerMesCodesTaxeVnt(var1);
      this.chargerMesCompte(var1);
      this.chargerMesDouanes(var1);
      this.chargerMesClesRepartition(var1);
      this.recupererModeleFicheProduit();
      this.recupererModeleListeProduit();
      this.recupererModeleListeMouvements();
      this.recupererLesMarquesItem(var1);
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void recupererLesItemsFabrication(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererSerieUserItem(var1);
      this.recupererModeleDocument();
      this.recupererModeleListe();
      this.recupererHabilitation(var1);
      this.recupererDepotItem(var1, this.nature);
      this.recupererFamilleProduitAchatsUtilItem(var1);
      this.recupererProcessItem(var1);
      this.recupererAtelierItem(var1);
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void recupererLesItemsImpression(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererLesRegionItem(var1);
      this.recupererLesSiteItem(var1);
      this.recupererLesCommerciauxAchatsItem(var1);
      this.recupererLesCreateurItem(var1);
      this.recupererFamilleProduitAchatsItem(var1);
      this.recupererFamilleProduitVentesItem(var1);
      this.recupererFamillesGlobal();
      this.recupererDepotItem(var1, 0);
   }

   public void recupererOptionsAchats() {
      this.optionAchats = new OptionAchats();
      LireLesoptionsAchats var1 = new LireLesoptionsAchats();
      var1.setStrId(this.structureLog.getStrid());
      this.optionAchats = var1.lancer();
   }

   public void recupererOptionsStocks() {
      this.optionStocks = new OptionStocks();
      LireLesoptionsStocks var1 = new LireLesoptionsStocks();
      var1.setStrId(this.structureLog.getStrid());
      this.optionStocks = var1.lancer();
   }

   public void recupererOptionsVentes() {
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var1 = new LireLesoptionsVentes();
      var1.setStrId(this.structureLog.getStrid());
      this.optionVentes = var1.lancer();
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
      if (this.optionAchats.getAxeActivite().equals("true")) {
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

   }

   public void recupererBudgetItem(Session var1) throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      this.mesBudgetsItems.add(new SelectItem(1, "Ventes"));
      this.mesBudgetsItems.add(new SelectItem(2, "Achats"));
      if (this.structureLog.getStrtypeentreprise() != null && !this.structureLog.getStrtypeentreprise().isEmpty() && this.structureLog.getStrtypeentreprise().equals("2")) {
         this.mesBudgetsItems.add(new SelectItem(3, "Production"));
      }

      this.mesBudgetsItems.add(new SelectItem(4, "Frais généraux"));
      this.mesBudgetsItems.add(new SelectItem(5, "Investissements"));
      this.mesBudgetsItems.add(new SelectItem(6, "TVA"));
      this.mesBudgetsItems.add(new SelectItem(7, "Impôts et Taxes"));
      this.mesBudgetsItems.add(new SelectItem(8, "Personnels"));
      this.mesBudgetsItems.add(new SelectItem(9, "Familles/Produits Achats"));
      new ArrayList();
      ProjetsDao var3 = new ProjetsDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectAllProjets(1, var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            if (((Projets)var2.get(var4)).getProCode() != null && !((Projets)var2.get(var4)).getProCode().isEmpty()) {
               this.mesBudgetsItems.add(new SelectItem(((Projets)var2.get(var4)).getProCode(), ((Projets)var2.get(var4)).getProCode() + ":" + ((Projets)var2.get(var4)).getProNomFR()));
            }
         }
      }

   }

   public void recupererChantierItem(Session var1) throws HibernateException, NamingException {
      this.mesChantiersItems = new ArrayList();
      if (this.optionAchats.getAxeChantier().equals("true")) {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesChantiersItems = var2.chargerLesAnalytiques("7", var1);
      }

   }

   public void recupererDossierItem(Session var1) throws HibernateException, NamingException {
      this.mesDossiersItems = new ArrayList();
      if (!this.optionAchats.getAxeDossier().equals("0")) {
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.mesDossiersItems = var2.chargerLesAnalytiques("6", var1);
      }

   }

   public void recupererParcItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = this.rechercheModule(70000);
      this.mesParcsItems = new ArrayList();
      if (var2) {
         if (this.optionAchats.getAxeParc().equals("true")) {
            this.optionParcs = new OptionParcs();
            LireLesoptionsParcs var3 = new LireLesoptionsParcs();
            var3.setStrId(this.structureLog.getStrid());
            this.optionParcs = var3.lancer();
            if (this.optionParcs != null && this.optionParcs.getType() != null && !this.optionParcs.getType().isEmpty() && this.optionParcs.getType().equals("0")) {
               ParcDao var4 = new ParcDao(this.baseLog, this.utilInitHibernate);
               this.mesParcsItems = var4.chargerLesParcs(var1);
            }
         }
      } else {
         this.optionParcs = null;
      }

   }

   public void recupererServiceItem(Session var1) throws HibernateException, NamingException {
      this.mesServicesItems = new ArrayList();
      if (this.usersLog.getUsrProdServiceAch() == 1 && this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         this.mesServicesItems.add(new SelectItem(this.usersLog.getUsrService()));
      } else if (this.optionAchats.getAxeSite().equals("true")) {
         ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
         this.mesServicesItems = var2.chargerLesServicesItems(1, false, var1);
      } else {
         this.mesServicesItems.add(new SelectItem("100", "Tous Services"));
      }

   }

   public void recupererAtelierItem(Session var1) throws HibernateException, NamingException {
      this.mesAteliersItems = new ArrayList();
      if (this.optionAchats.getAxeUsine().equals("true")) {
         ProductionAtelierDao var2 = new ProductionAtelierDao(this.baseLog, this.utilInitHibernate);
         this.mesAteliersItems = var2.chargerLesProductionAtelierItems(0, var1);
      }

   }

   public void recupererDepartementItem(Session var1) throws HibernateException, NamingException {
      this.mesDepartementsItems = new ArrayList();
      if (this.optionAchats.getAxeSite().equals("true")) {
         DepartementDao var2 = new DepartementDao(this.baseLog, this.utilInitHibernate);
         this.mesDepartementsItems = var2.chargerLesDepartementsItems(0, var1);
      }

   }

   public void recupererSiteItem(Session var1) throws HibernateException, NamingException {
      this.mesSitesItems = new ArrayList();
      if (this.optionAchats.getAxeSite().equals("true")) {
         SiteDao var2 = new SiteDao(this.baseLog, this.utilInitHibernate);
         this.mesSitesItems = var2.chargerLesSitesItems(0, var1);
      } else {
         this.mesSitesItems.add(new SelectItem("100", "Tous Sites"));
      }

   }

   public void recupererFormuleItem(Session var1) throws HibernateException, NamingException {
      this.mesFormulesItems = new ArrayList();
      FormulesAchatsDao var2 = new FormulesAchatsDao(this.baseLog, this.utilInitHibernate);
      this.mesFormulesItems = var2.chargerLesFormules(this.exoselectionne.getExeachId(), var1);
   }

   public void recupererConditionnementItem(Session var1) throws HibernateException, NamingException {
      this.mesConditionnementsItems = new ArrayList();
      ConditionnementDao var2 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
      this.mesConditionnementsItems = var2.chargerLesConditionnements(var1);
   }

   public void recupererCouleursItem(Session var1) throws HibernateException, NamingException {
      this.mesCouleursItems = new ArrayList();
      CouleurDao var2 = new CouleurDao(this.baseLog, this.utilInitHibernate);
      this.mesCouleursItems = var2.chargerLesCouleurs(var1);
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

   public void recupererFamillesFournisseurItem() throws JDOMException, IOException {
      LectureFamillesFournisseurs var1 = new LectureFamillesFournisseurs();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesFournisseurItems();
      this.mesFamilleFournisseursItems = var1.getMesFamillesFournisseursItems();
      this.lesFamilleFournisseursListe = var1.getMesFamillesFournisseurs();
   }

   public void recupererFamillesClientItem() throws JDOMException, IOException {
      LectureFamillesClients var1 = new LectureFamillesClients();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesClientItems();
      this.mesFamilleClientsItems = var1.getMesFamillesClientsItems();
      this.lesFamilleClientsListe = var1.getMesFamillesClients();
      this.var_tarif1 = "";

      for(int var2 = 0; var2 < this.lesFamilleClientsListe.size(); ++var2) {
         if (var2 == 0) {
            this.var_tarif1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(0)).getLibelle();
         }
      }

   }

   public void recupererTypesReglementsItem() throws JDOMException, IOException {
      LectureReglementFournisseur var1 = new LectureReglementFournisseur();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.recupereReglementFournisseur();
      this.mesTypeReglements = var1.getMesReglementFournisseurItems();
      this.lesModeReglementFournisseurListe = var1.getMesReglementFournisseur();
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

   public void recupererProcessItem(Session var1) throws HibernateException, NamingException {
      this.mesProcessItems = new ArrayList();
      ProcessEnteteAchatsDao var2 = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.mesProcessItems = var2.chargerLesProcess(var1);
   }

   public void recupererModeleBonDecaissement() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "bon_decaissement" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.modeleBonDecaissementItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.modeleBonDecaissementItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public void recupererModeleFicheProduit() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "produit" + File.separator;
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "produit" + File.separator;
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "mouvement" + File.separator;
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
      if (this.nature == 10) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "da" + File.separator;
      } else if (this.nature == 11) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "cotation" + File.separator;
      } else if (this.nature == 12) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (this.nature == 13) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "reception" + File.separator;
      } else if (this.nature == 14) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (this.nature == 15) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (this.nature == 16) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (this.nature == 17) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (this.nature == 18) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "frais" + File.separator;
      } else if (this.nature == 19) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "bon_decaissement" + File.separator;
      } else if (this.nature == 30) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "inventaire" + File.separator;
      } else if (this.nature == 31) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_entree" + File.separator;
      } else if (this.nature == 32) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "bon_sortie" + File.separator;
      } else if (this.nature == 33) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "cession" + File.separator;
      } else if (this.nature == 34) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "production" + File.separator;
      } else if (this.nature == 35) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "valorisation" + File.separator;
      } else if (this.nature == 36) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "sommier" + File.separator;
      } else if (this.nature == 127) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "affaire" + File.separator;
      } else if (this.nature == 150) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "document" + File.separator + "reacheminement" + File.separator;
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

   public void recupererModeleListe() {
      String var1 = "";
      if (this.nature == 10) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "da" + File.separator;
      } else if (this.nature == 11) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "cotation" + File.separator;
      } else if (this.nature == 12) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "commande" + File.separator;
      } else if (this.nature == 13) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "reception" + File.separator;
      } else if (this.nature == 14) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "retour" + File.separator;
      } else if (this.nature == 15) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "facture" + File.separator;
      } else if (this.nature == 16) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "avoir" + File.separator;
      } else if (this.nature == 17) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "note_de_debit" + File.separator;
      } else if (this.nature == 18) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "frais" + File.separator;
      } else if (this.nature == 19) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "bon_decaissement" + File.separator;
      } else if (this.nature == 30) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "liste" + File.separator + "inventaire" + File.separator;
      } else if (this.nature == 31) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "liste" + File.separator + "bon_entree" + File.separator;
      } else if (this.nature == 32) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "liste" + File.separator + "bon_sortie" + File.separator;
      } else if (this.nature == 33) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "liste" + File.separator + "cession" + File.separator;
      } else if (this.nature == 34) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "liste" + File.separator + "production" + File.separator;
      } else if (this.nature == 35) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "valorisation" + File.separator;
      } else if (this.nature == 36) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "sommier" + File.separator;
      } else if (this.nature == 127) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "affaire" + File.separator;
      } else if (this.nature == 150) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "liste" + File.separator + "reacheminement" + File.separator;
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

   public void recupererLesNaturesAchItem() {
      LectureNatureAchats var1 = new LectureNatureAchats();
      this.mesNaturesFournisseurItems = var1.getMesNatureAchatsItems();
   }

   public void recupererLesNaturesVteItem() {
      if (this.typeVente == 815) {
         LectureNatureMedical var1 = new LectureNatureMedical();
         this.mesNaturesClientItems = var1.getMesNatureMedicalItems();
      } else {
         LectureNatureVentes var2 = new LectureNatureVentes();
         this.mesNaturesClientItems = var2.getMesNatureVentesItems();
      }

   }

   public void recupererLesNaturesGlobalItem() {
      this.mesNaturesGlobaltems = new ArrayList();
      int var1;
      if (this.mesNaturesFournisseurItems.size() != 0) {
         for(var1 = 0; var1 < this.mesNaturesFournisseurItems.size(); ++var1) {
            this.mesNaturesGlobaltems.add(new SelectItem(((SelectItem)this.mesNaturesFournisseurItems.get(var1)).getValue()));
         }
      }

      if (this.mesNaturesClientItems.size() != 0) {
         for(var1 = 0; var1 < this.mesNaturesClientItems.size(); ++var1) {
            this.mesNaturesGlobaltems.add(new SelectItem(((SelectItem)this.mesNaturesClientItems.get(var1)).getValue()));
         }
      }

   }

   public void recupererFamilleProduitAchatsUtilItem(Session var1) throws HibernateException, NamingException {
      this.mesFamillesAchatsItems = new ArrayList();
      this.mesFamillesAchatsUtilItems = new ArrayList();
      FamillesProduitsAchatsDao var2 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.mesFamillesAchatsItems = var2.chargerFamilleProduitAchatsFamItems(this.exoselectionne.getExeachId(), var1);
      if (this.mesFamillesAchatsItems.size() == 0) {
         this.mesFamillesAchatsItems = var2.chargerFamilleProduitAchatsUtilItems(this.exoselectionne.getExeachId(), var1);
         this.mesFamillesAchatsUtilItems = this.mesFamillesAchatsItems;
      } else {
         this.mesFamillesAchatsUtilItems = var2.chargerFamilleProduitAchatsUtilItems(this.exoselectionne.getExeachId(), var1);
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

   public void recupererFamilleProduitAchatsItem(Session var1) throws HibernateException, NamingException {
      this.mesFamillesAchatsItems = new ArrayList();
      FamillesProduitsAchatsDao var2 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.mesFamillesAchatsItems = var2.chargerFamilleProduitAchatsItems(this.exoselectionne.getExeachId(), var1);
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

      if (this.mesFamillesVentesItems.size() != 0) {
         if (this.typeVente == 815) {
            this.mesFamillesGlobalItems.add(new SelectItem("", "********* MEDICAL *********"));
         } else {
            this.mesFamillesGlobalItems.add(new SelectItem("", "********* VENTES *********"));
         }

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

      this.mesDepotAchItems = new ArrayList();
      this.mesDepotPrdItems = new ArrayList();
      this.mesDepotVteItems = new ArrayList();
      this.mesDepotAchCodeItems = new ArrayList();
      this.mesDepotPrdCodeItems = new ArrayList();
      this.mesDepotVteCodeItems = new ArrayList();
      if (this.lastExoAchats != null) {
         DepotAchatsDao var6 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
            if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
               this.mesDepotAchItems = var6.selectActifDepotUsersItems(var2, this.usersLog.getUsrService(), this.listeDepotUser, var1);
            } else {
               this.mesDepotAchItems = var6.selectActifDepotItems(var2, this.usersLog.getUsrService(), var1);
            }
         } else if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
            this.mesDepotAchItems = var6.selectActifDepotUsersItems(var2, this.listeDepotUser, var1);
         } else {
            this.mesDepotAchItems = var6.selectActifDepotItems(var2, var1);
         }

         this.mesDepotPrdItems = this.mesDepotAchItems;
         this.mesDepotVteItems = this.mesDepotAchItems;
         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
            if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
               this.mesDepotAchCodeItems = var6.selectActifDepotUsersCodeItems(var2, this.usersLog.getUsrService(), this.listeDepotUser, var1);
            } else {
               this.mesDepotAchCodeItems = var6.selectActifDepotCodeItems(var2, this.usersLog.getUsrService(), var1);
            }
         } else if (this.listeDepotUser != null && !this.listeDepotUser.isEmpty()) {
            this.mesDepotAchCodeItems = var6.selectActifDepotUsersCodeItems(var2, this.listeDepotUser, var1);
         } else {
            this.mesDepotAchCodeItems = var6.selectActifDepotCodeItems(var2, var1);
         }

         this.mesDepotPrdCodeItems = this.mesDepotAchCodeItems;
         this.mesDepotVteCodeItems = this.mesDepotAchCodeItems;
      }

   }

   public void chargerMesCodesTaxeAch(Session var1) throws HibernateException, NamingException {
      this.listTaxesAch = new ArrayList();
      this.mesTaxesAchItems = new ArrayList();
      this.mesTaxesAchItems.add(new SelectItem(0, ""));
      TaxesAchatsDao var2 = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectActifTaxes(this.exoselectionne.getExeachId(), var1);
      this.var_timbre = 0;
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            TaxesAchats var5 = (TaxesAchats)var3.get(var4);
            if (var5.getTaxachTimbre() != 0) {
               this.var_timbre = var5.getTaxachTimbre();
            } else if (var5.getTaxachCode() != null && !var5.getTaxachCode().isEmpty()) {
               this.mesTaxesAchItems.add(new SelectItem(var5.getTaxachCode(), var5.getTaxachCode() + ":" + var5.getTaxachTaux()));
               this.listTaxesAch.add(var5);
            }
         }
      }

   }

   public void chargerMesCodesTaxeVnt(Session var1) throws HibernateException, NamingException {
      this.mesTaxesVteItems = new ArrayList();
      this.mesTaxesVteItems.add(new SelectItem(0, ""));
      TaxesVentesDao var2 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new ExercicesVentes();
      ExercicesVentesDao var5 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var4 = var5.recupererLastExo(var1);
      if (var4 != null) {
         List var3 = var2.selectActifTaxes(var4.getExevteId(), var1);
         if (var3.size() != 0) {
            for(int var6 = 0; var6 < var3.size(); ++var6) {
               TaxesVentes var7 = (TaxesVentes)var3.get(var6);
               if (var7.getTaxvteTimbre() == 0 && var7.getTaxvteCode() != null && !var7.getTaxvteCode().isEmpty()) {
                  this.mesTaxesVteItems.add(new SelectItem(var7.getTaxvteCode(), var7.getTaxvteCode() + ":" + var7.getTaxvteTaux()));
               }
            }
         }
      }

   }

   public void chargerMesCompte(Session var1) throws NamingException {
      this.mesCompteAchLocItems = new ArrayList();
      this.mesCompteAchZItems = new ArrayList();
      this.mesCompteAchHzItems = new ArrayList();
      this.mesCompteVteLocItems = new ArrayList();
      this.mesCompteVteZItems = new ArrayList();
      this.mesCompteVteHzItems = new ArrayList();
      this.mesCompteProduitsItems = new ArrayList();
      this.mesCompteStocksAchItems = new ArrayList();
      this.mesCompteStocksVteItems = new ArrayList();
      this.mesCompteChargeItems = new ArrayList();
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
         if (this.optionAchats.getTrfCompta() == null || this.optionAchats.getTrfCompta().isEmpty()) {
            this.optionAchats.setTrfCompta("0");
         }

         if (this.optionAchats.getTrfCompta().equals("1")) {
            var4 = "(5,9,16,13)";
         } else {
            var4 = "(5,9,16)";
         }

         this.mesCompteStocksAchItems = var7.chargerPlanCmptItems(var2, this.lastExoCompta.getExecpt_id(), var4, 0, var1);
         this.mesCompteStocksVteItems = this.mesCompteStocksAchItems;
         var4 = "(3,9,13,16)";
         this.mesCompteChargeItems = var7.chargerPlanCmptItems(var2, this.lastExoCompta.getExecpt_id(), var4, 0, var1);
         this.mesCompteAchLocItems = this.mesCompteChargeItems;
         this.mesCompteAchZItems = this.mesCompteChargeItems;
         this.mesCompteAchHzItems = this.mesCompteChargeItems;
      }

   }

   public void chargerMesDouanes(Session var1) throws NamingException {
      this.mesDouanesItems = new ArrayList();
      DouanesPositionDao var2 = new DouanesPositionDao(this.baseLog, this.utilInitHibernate);
      this.mesDouanesItems = var2.listePositionsItems(this.structureLog.getStrzonecommerciale(), var1);
   }

   public void chargerMesClesRepartition(Session var1) throws NamingException {
      this.mesClesItems = new ArrayList();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.mesClesItems = var2.chargerLesAnalytiques("9", var1);
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

   public void recupererLesCommerciauxAchatsItem(Session var1) throws HibernateException, NamingException {
      this.mesCommerciauxItems = new ArrayList();
      UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.mesCommerciauxItems = var2.chargerLesUsersItem(var1);
   }

   public void recupererLesCommerciauxStockItem(Session var1) throws HibernateException, NamingException {
      this.mesCommerciauxItems = new ArrayList();
      UserDao var2;
      if (this.optionStocks.getDemandeurRapporteur().equals("0")) {
         var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         this.mesCommerciauxItems = var2.chargerLesUsersItem(var1);
         if (this.mesCommerciauxItems.size() == 0) {
            this.mesCommerciauxItems.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom()));
         }
      } else if (this.optionStocks.getDemandeurRapporteur().equals("1")) {
         var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesSignataires("Achats", var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.mesCommerciauxItems.add(new SelectItem(((Users)var3.get(var4)).getUsrid(), ((Users)var3.get(var4)).getUsrNom() + " " + ((Users)var3.get(var4)).getUsrPrenom()));
            }
         }

         if (this.mesCommerciauxItems.size() == 0) {
            this.mesCommerciauxItems.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom()));
         }
      } else if (this.optionStocks.getDemandeurRapporteur().equals("2")) {
         var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         this.mesCommerciauxItems = var2.chargerLesDemandeursItem(var1);
         if (this.mesCommerciauxItems.size() == 0) {
            this.mesCommerciauxItems.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom()));
         }
      } else if (this.optionStocks.getDemandeurRapporteur().equals("3")) {
         SalariesDao var5 = new SalariesDao(this.baseLog, this.utilInitHibernate);
         this.mesCommerciauxItems = var5.chargerlesSalariesActifItem("*", var1);
      }

   }

   public void recupererLesCreateurItem(Session var1) throws HibernateException, NamingException {
      this.mesCreateursItems = new ArrayList();
      UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.mesCreateursItems = var2.chargerLesUsersItem(var1);
   }

   public void chargerLesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.lesUsers = new ArrayList();
      UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
      if (this.usersLog.getUsrCommAchats() == 0) {
         this.lesUsers = var2.chargerLesUsers(var1);
      } else if (this.usersLog.getUsrCommAchats() == 1) {
         this.lesUsers = var2.chargerLesUsers(var1);
      } else {
         this.lesUsers.add(this.usersLog);
      }

      if (this.lesUsers.size() == 0) {
         this.lesUsers.add(this.usersLog);
      }

      this.recupererUsersItem();
   }

   public void recupererUsersItem() {
      this.mesResponsablesItems = new ArrayList();
      if (this.usersLog.getUsrCommAchats() != 0 && this.usersLog.getUsrCommAchats() != 1) {
         this.mesResponsablesItems.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
      } else {
         for(int var1 = 0; var1 < this.lesUsers.size(); ++var1) {
            Users var2 = (Users)this.lesUsers.get(var1);
            if (var2.getUsrPatronyme() != null && !var2.getUsrPatronyme().isEmpty()) {
               this.mesResponsablesItems.add(new SelectItem(var2.getUsrid(), var2.getUsrPatronyme()));
            }
         }
      }

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

   public ExercicesAchats getExoselectionne() {
      return this.exoselectionne;
   }

   public void setExoselectionne(ExercicesAchats var1) {
      this.exoselectionne = var1;
   }

   public FormAvoirAchats getFormAvoirAchats() {
      return this.formAvoirAchats;
   }

   public void setFormAvoirAchats(FormAvoirAchats var1) {
      this.formAvoirAchats = var1;
   }

   public FormCommandeAchats getFormCommandeAchats() {
      return this.formCommandeAchats;
   }

   public void setFormCommandeAchats(FormCommandeAchats var1) {
      this.formCommandeAchats = var1;
   }

   public FormExercicesAchats getFormExercicesAchats() {
      return this.formExercicesAchats;
   }

   public void setFormExercicesAchats(FormExercicesAchats var1) {
      this.formExercicesAchats = var1;
   }

   public FormFactureAchats getFormFactureAchats() {
      return this.formFactureAchats;
   }

   public void setFormFactureAchats(FormFactureAchats var1) {
      this.formFactureAchats = var1;
   }

   public FormNoteDebitAchats getFormNoteDebitAchats() {
      return this.formNoteDebitAchats;
   }

   public void setFormNoteDebitAchats(FormNoteDebitAchats var1) {
      this.formNoteDebitAchats = var1;
   }

   public FormProduitsAchs getFormProduitsAchs() {
      return this.formProduitsAchs;
   }

   public void setFormProduitsAchs(FormProduitsAchs var1) {
      this.formProduitsAchs = var1;
   }

   public FormReceptionAchats getFormReceptionAchats() {
      return this.formReceptionAchats;
   }

   public void setFormReceptionAchats(FormReceptionAchats var1) {
      this.formReceptionAchats = var1;
   }

   public FormRetourAchats getFormRetourAchats() {
      return this.formRetourAchats;
   }

   public void setFormRetourAchats(FormRetourAchats var1) {
      this.formRetourAchats = var1;
   }

   public ObjetLigneMenu getMenuachat() {
      return this.menuachat;
   }

   public void setMenuachat(ObjetLigneMenu var1) {
      this.menuachat = var1;
   }

   public MenudroitAchatsCtrl getMenudroitAchatsCtrl() {
      return this.menudroitAchatsCtrl;
   }

   public void setMenudroitAchatsCtrl(MenudroitAchatsCtrl var1) {
      this.menudroitAchatsCtrl = var1;
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

   public List getMesDepotAchItems() {
      return this.mesDepotAchItems;
   }

   public void setMesDepotAchItems(List var1) {
      this.mesDepotAchItems = var1;
   }

   public List getMesDepotPrdItems() {
      return this.mesDepotPrdItems;
   }

   public void setMesDepotPrdItems(List var1) {
      this.mesDepotPrdItems = var1;
   }

   public List getMesDepotVteItems() {
      return this.mesDepotVteItems;
   }

   public void setMesDepotVteItems(List var1) {
      this.mesDepotVteItems = var1;
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

   public List getMesNaturesClientItems() {
      return this.mesNaturesClientItems;
   }

   public void setMesNaturesClientItems(List var1) {
      this.mesNaturesClientItems = var1;
   }

   public List getMesNaturesFournisseurItems() {
      return this.mesNaturesFournisseurItems;
   }

   public void setMesNaturesFournisseurItems(List var1) {
      this.mesNaturesFournisseurItems = var1;
   }

   public List getMesNaturesGlobaltems() {
      return this.mesNaturesGlobaltems;
   }

   public void setMesNaturesGlobaltems(List var1) {
      this.mesNaturesGlobaltems = var1;
   }

   public List getMesParcsItems() {
      return this.mesParcsItems;
   }

   public void setMesParcsItems(List var1) {
      this.mesParcsItems = var1;
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

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
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

   public List getMesFamilleFournisseursItems() {
      return this.mesFamilleFournisseursItems;
   }

   public void setMesFamilleFournisseursItems(List var1) {
      this.mesFamilleFournisseursItems = var1;
   }

   public List getMesTaxesAchItems() {
      return this.mesTaxesAchItems;
   }

   public void setMesTaxesAchItems(List var1) {
      this.mesTaxesAchItems = var1;
   }

   public List getMesTaxesVteItems() {
      return this.mesTaxesVteItems;
   }

   public void setMesTaxesVteItems(List var1) {
      this.mesTaxesVteItems = var1;
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

   public FormFraisAchats getFormFraisAchats() {
      return this.formFraisAchats;
   }

   public void setFormFraisAchats(FormFraisAchats var1) {
      this.formFraisAchats = var1;
   }

   public FormImpressionAchats getFormImpressionAchats() {
      return this.formImpressionAchats;
   }

   public void setFormImpressionAchats(FormImpressionAchats var1) {
      this.formImpressionAchats = var1;
   }

   public List getMesFamillesAchatsItems() {
      return this.mesFamillesAchatsItems;
   }

   public void setMesFamillesAchatsItems(List var1) {
      this.mesFamillesAchatsItems = var1;
   }

   public List getMesFamillesGlobalItems() {
      return this.mesFamillesGlobalItems;
   }

   public void setMesFamillesGlobalItems(List var1) {
      this.mesFamillesGlobalItems = var1;
   }

   public List getMesCompteAchHzItems() {
      return this.mesCompteAchHzItems;
   }

   public void setMesCompteAchHzItems(List var1) {
      this.mesCompteAchHzItems = var1;
   }

   public List getMesCompteAchLocItems() {
      return this.mesCompteAchLocItems;
   }

   public void setMesCompteAchLocItems(List var1) {
      this.mesCompteAchLocItems = var1;
   }

   public List getMesCompteAchZItems() {
      return this.mesCompteAchZItems;
   }

   public void setMesCompteAchZItems(List var1) {
      this.mesCompteAchZItems = var1;
   }

   public List getMesCompteChargeItems() {
      return this.mesCompteChargeItems;
   }

   public void setMesCompteChargeItems(List var1) {
      this.mesCompteChargeItems = var1;
   }

   public List getMesCompteProduitsItems() {
      return this.mesCompteProduitsItems;
   }

   public void setMesCompteProduitsItems(List var1) {
      this.mesCompteProduitsItems = var1;
   }

   public List getMesCompteStocksAchItems() {
      return this.mesCompteStocksAchItems;
   }

   public void setMesCompteStocksAchItems(List var1) {
      this.mesCompteStocksAchItems = var1;
   }

   public List getMesCompteStocksVteItems() {
      return this.mesCompteStocksVteItems;
   }

   public void setMesCompteStocksVteItems(List var1) {
      this.mesCompteStocksVteItems = var1;
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

   public FormCotationAchats getFormCotationAchats() {
      return this.formCotationAchats;
   }

   public void setFormCotationAchats(FormCotationAchats var1) {
      this.formCotationAchats = var1;
   }

   public FormBonDecaissementAchats getFormBonDecaissementAchats() {
      return this.formBonDecaissementAchats;
   }

   public void setFormBonDecaissementAchats(FormBonDecaissementAchats var1) {
      this.formBonDecaissementAchats = var1;
   }

   public FormDemandeAchats getFormDemandeAchats() {
      return this.formDemandeAchats;
   }

   public void setFormDemandeAchats(FormDemandeAchats var1) {
      this.formDemandeAchats = var1;
   }

   public FormValorisationAchats getFormValorisationAchats() {
      return this.formValorisationAchats;
   }

   public void setFormValorisationAchats(FormValorisationAchats var1) {
      this.formValorisationAchats = var1;
   }

   public FormTransfertAchats getFormTransfertAchats() {
      return this.formTransfertAchats;
   }

   public void setFormTransfertAchats(FormTransfertAchats var1) {
      this.formTransfertAchats = var1;
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

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
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

   public MenudroitStockCtrl getMenudroitStockCtrl() {
      return this.menudroitStockCtrl;
   }

   public void setMenudroitStockCtrl(MenudroitStockCtrl var1) {
      this.menudroitStockCtrl = var1;
   }

   public ObjetLigneMenu getMenustock() {
      return this.menustock;
   }

   public void setMenustock(ObjetLigneMenu var1) {
      this.menustock = var1;
   }

   public FormBonEntree getFormBonEntree() {
      return this.formBonEntree;
   }

   public void setFormBonEntree(FormBonEntree var1) {
      this.formBonEntree = var1;
   }

   public FormBonSortie getFormBonSortie() {
      return this.formBonSortie;
   }

   public void setFormBonSortie(FormBonSortie var1) {
      this.formBonSortie = var1;
   }

   public FormCession getFormCession() {
      return this.formCession;
   }

   public void setFormCession(FormCession var1) {
      this.formCession = var1;
   }

   public FormImpressionStock getFormImpressionStock() {
      return this.formImpressionStock;
   }

   public void setFormImpressionStock(FormImpressionStock var1) {
      this.formImpressionStock = var1;
   }

   public FormInventaire getFormInventaire() {
      return this.formInventaire;
   }

   public void setFormInventaire(FormInventaire var1) {
      this.formInventaire = var1;
   }

   public List getMesResponsablesItems() {
      return this.mesResponsablesItems;
   }

   public void setMesResponsablesItems(List var1) {
      this.mesResponsablesItems = var1;
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

   public List getModeleBonDecaissementItems() {
      return this.modeleBonDecaissementItems;
   }

   public void setModeleBonDecaissementItems(List var1) {
      this.modeleBonDecaissementItems = var1;
   }

   public FormSommierAchats getFormSommierAchats() {
      return this.formSommierAchats;
   }

   public void setFormSommierAchats(FormSommierAchats var1) {
      this.formSommierAchats = var1;
   }

   public FormSerialisation getFormSerialisation() {
      return this.formSerialisation;
   }

   public void setFormSerialisation(FormSerialisation var1) {
      this.formSerialisation = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public FormProduction getFormProduction() {
      return this.formProduction;
   }

   public void setFormProduction(FormProduction var1) {
      this.formProduction = var1;
   }

   public List getMesProcessItems() {
      return this.mesProcessItems;
   }

   public void setMesProcessItems(List var1) {
      this.mesProcessItems = var1;
   }

   public List getMesAteliersItems() {
      return this.mesAteliersItems;
   }

   public void setMesAteliersItems(List var1) {
      this.mesAteliersItems = var1;
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

   public List getMesFamillesAchatsUtilItems() {
      return this.mesFamillesAchatsUtilItems;
   }

   public void setMesFamillesAchatsUtilItems(List var1) {
      this.mesFamillesAchatsUtilItems = var1;
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

   public List getMesDepotAchCodeItems() {
      return this.mesDepotAchCodeItems;
   }

   public void setMesDepotAchCodeItems(List var1) {
      this.mesDepotAchCodeItems = var1;
   }

   public List getMesDepotPrdCodeItems() {
      return this.mesDepotPrdCodeItems;
   }

   public void setMesDepotPrdCodeItems(List var1) {
      this.mesDepotPrdCodeItems = var1;
   }

   public List getMesDepotVteCodeItems() {
      return this.mesDepotVteCodeItems;
   }

   public void setMesDepotVteCodeItems(List var1) {
      this.mesDepotVteCodeItems = var1;
   }

   public FormExtraitBudget getFormExtraitBudget() {
      return this.formExtraitBudget;
   }

   public void setFormExtraitBudget(FormExtraitBudget var1) {
      this.formExtraitBudget = var1;
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

   public FormReacheminementAchats getFormReacheminementAchats() {
      return this.formReacheminementAchats;
   }

   public void setFormReacheminementAchats(FormReacheminementAchats var1) {
      this.formReacheminementAchats = var1;
   }

   public FormAffaires getFormAffaires() {
      return this.formAffaires;
   }

   public void setFormAffaires(FormAffaires var1) {
      this.formAffaires = var1;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }

   public long getVar_memo_id_master() {
      return this.var_memo_id_master;
   }

   public void setVar_memo_id_master(long var1) {
      this.var_memo_id_master = var1;
   }

   public List getMesSourceItems() {
      return this.mesSourceItems;
   }

   public void setMesSourceItems(List var1) {
      this.mesSourceItems = var1;
   }

   public List getMesChantiersItems() {
      return this.mesChantiersItems;
   }

   public void setMesChantiersItems(List var1) {
      this.mesChantiersItems = var1;
   }
}
