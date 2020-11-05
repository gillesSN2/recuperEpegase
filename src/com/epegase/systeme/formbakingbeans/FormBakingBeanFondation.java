package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormExercicesVentes;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.fondation.FormDemandeFondation;
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
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.DouanesPositionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FormulesVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitVentesCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureNatureDemande;
import com.epegase.systeme.xml.LectureNatureVentes;
import com.epegase.systeme.xml.LectureReglementClient;
import com.epegase.systeme.xml.LectureSourcesTiers;
import com.epegase.systeme.xml.LireLesoptionsVentes;
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

public class FormBakingBeanFondation implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private MenudroitVentesCtrl menudroitFondationCtrl;
   private ObjetLigneMenu menufondation;
   private ObjetLigneMenu menufondationMemo = new ObjetLigneMenu();
   private LectureModulesOnglets lesOnglets;
   private int nature;
   private OptionVentes optionsVentes;
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
   private FormExercicesVentes formExercicesVentes;
   private FormDemandeFondation formDemandeFondation;
   private List mesdevisesItem;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private List annexItems;
   private List pageGardeItems;
   private List lesFamilleClientsListe;
   private List mesFamilleClientsItems;
   private List mesTypesDemandestems;
   private List lesModeReglementClientsListe;
   private List mesTypeReglements;
   private List mesSerieUserItem;
   private List mesActivitesItems;
   private List mesServicesItems;
   private List mesDossiersItems;
   private List mesBudgetsItems;
   private List mesFormulesItems;
   private List listCaisses;
   private List mesBanquesItems;
   private List mesTaxesItems;
   private List mesNaturesItems;
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
      this.formDemandeFondation = null;
   }

   public void menuGaucheFondation(int var1) throws JDOMException, IOException {
      if (this.menudroitFondationCtrl == null) {
         this.menudroitFondationCtrl = new MenudroitVentesCtrl();
         this.menudroitFondationCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         boolean var2 = false;
         if (this.optionsVentes != null && this.optionsVentes.getAxeDossier() != null && !this.optionsVentes.getAxeDossier().isEmpty() && this.optionsVentes.getAxeDossier().equals("2")) {
            var2 = true;
         }

         this.menudroitFondationCtrl.chargerMenudroitFondationXml(this.usersLog.getGroupe(), this.structureLog.getStrid(), this.structureLog.getStrmaitrecabinet(), this.usersLog, var2);
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("" + var1, this.usersLog.getUsrCollaboration());
   }

   public void gestionFondation() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menufondation = new ObjetLigneMenu();
      if (this.menudroitFondationCtrl.getDataModelMenudroitVentesXmlList().isRowAvailable()) {
         this.menufondation = (ObjetLigneMenu)this.menudroitFondationCtrl.getDataModelMenudroitVentesXmlList().getRowData();
         if (this.menufondation.getLibelle_FR() != null && !this.menufondation.getLibelle_FR().isEmpty()) {
            this.menufondationMemo = this.menufondation;
            this.aiguillageFondation();
         }
      }

   }

   public void gestionFondationFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      this.menufondation = var1;
      this.menufondationMemo = this.menufondation;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         int var2 = Integer.parseInt(this.typeVente + "00");
         this.menuGaucheFondation(var2);
      }

      this.aiguillageFondation();
   }

   public void aiguillageFondation() throws JDOMException, IOException, SAXException, NamingException, HibernateException, org.apache.velocity.runtime.parser.ParseException, ParseException {
      if (this.lastExoVentes.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menufondation.setAdd(false);
         this.menufondation.setMaj(false);
         this.menufondation.setSup(false);
         this.menufondation.setDup(false);
         this.menufondation.setClo(false);
         this.menufondation.setTrf(false);
         this.menufondation.setImp(true);
      } else {
         this.menufondation.setAdd(this.menufondationMemo.isAdd());
         this.menufondation.setMaj(this.menufondationMemo.isMaj());
         this.menufondation.setSup(this.menufondationMemo.isSup());
         this.menufondation.setDup(this.menufondationMemo.isDup());
         this.menufondation.setClo(this.menufondationMemo.isClo());
         this.menufondation.setTrf(this.menufondationMemo.isTrf());
         this.menufondation.setImp(this.menufondationMemo.isImp());
      }

      this.razMemoire();
      if (this.menufondation.getCommande().equalsIgnoreCase("80300:01")) {
         this.nature = 220;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviFondation");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            String var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/fondation/DemandeInit.jsp";
               this.menuDemande(var1);
            } else {
               this.affichePage = "/fondation/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/fondation/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menufondation.getCommande().equalsIgnoreCase("80300:99")) {
         this.affichePage = "/fondation/SelectionExercicesFondation.jsp";
         this.menuSelectionExercicesFondations();
      }

   }

   public void menuDemande(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formDemandeFondation = new FormDemandeFondation();
      this.formDemandeFondation.setutilInitHibernate(this.utilInitHibernate);
      this.formDemandeFondation.setBaseLog(this.baseLog);
      this.formDemandeFondation.setStructureLog(this.structureLog);
      this.formDemandeFondation.setUsersLog(this.usersLog);
      this.formDemandeFondation.InstancesDaoUtilses();
      this.formDemandeFondation.setNature(this.nature);
      this.formDemandeFondation.setExercicesVentes(this.exoselectionne);
      this.formDemandeFondation.setLastExoVentes(this.lastExoVentes);
      this.formDemandeFondation.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formDemandeFondation.setOptionsVentes(this.optionsVentes);
      this.formDemandeFondation.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formDemandeFondation.setVar_timbre(this.var_timbre);
      this.formDemandeFondation.setLesFamilleClientsListe(this.lesFamilleClientsListe);
      this.formDemandeFondation.setLesModeReglementClientsListe(this.lesModeReglementClientsListe);
      this.formDemandeFondation.configVentes();
      this.formDemandeFondation.accesResteintUser();
      this.formDemandeFondation.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formDemandeFondation.chargerCommerciauxResponsable(var1);
      this.formDemandeFondation.setHabilitation(this.habilitation);
      this.formDemandeFondation.setFormRecherche(this.formRecherche);
      this.formDemandeFondation.setMesSerieUserItem(this.mesSerieUserItem);
      this.formDemandeFondation.setDecoupageActivite(this.decoupageActivite);
      this.formDemandeFondation.setLaColonne1Items(this.laColonne1Items);
      this.formDemandeFondation.setLaColonne2Items(this.laColonne2Items);
      this.formDemandeFondation.setLaColonne3Items(this.laColonne3Items);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionsVentes.getChargementListe() != null && !this.optionsVentes.getChargementListe().isEmpty() && this.optionsVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formDemandeFondation.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formDemandeFondation.executerRequete(var1);
      }

   }

   public void menuSelectionExercicesFondations() throws IOException, JDOMException, HibernateException, NamingException {
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
      this.recupererOptionsVentes();
      this.recupererModelesAutorises();
      this.recupererAnnexe(var1);
      this.recupererPageGarde(var1);
      this.recupererDevisesItem(var1);
      this.recupererFormuleItem(var1);
      this.recupererBanquesItem(var1);
      this.recupererFamillesClientItem();
      this.recupererTypeDemandeItem();
      this.recupererTypesReglementsItem();
      this.recupererCaisses(var1);
      this.chargerMesCodesTaxeVnt(var1);
      this.recupererBudgetItem(var1);
      this.recupererActiviteItem(var1);
      this.recupererDossierItem(var1);
      this.recupererServiceItem(var1);
      this.recupererLesRegionItem(var1);
      this.recupererLesSiteItem(var1);
      this.recupererSourceListe(var1);
   }

   public void recupererLesItemsDoc(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererSerieUserItem(var1);
      this.recupererModeleDocument();
      this.recupererModeleListe();
      this.recupererConfigListeEntete();
      this.recupererHabilitation(var1);
   }

   public void recupererLesItemsImpression(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererLesRegionItem(var1);
      this.recupererLesSiteItem(var1);
      this.recupererLesCommerciauxItem(var1);
      this.recupererLesCreateurItem(var1);
   }

   public void recupererOptionsVentes() {
      this.optionsVentes = new OptionVentes();
      LireLesoptionsVentes var1 = new LireLesoptionsVentes();
      var1.setStrId(this.structureLog.getStrid());
      this.optionsVentes = var1.lancer();
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "fondation" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "fondation" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
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
   }

   public void recupererTypeDemandeItem() throws JDOMException, IOException {
      LectureNatureDemande var1 = new LectureNatureDemande();
      this.mesTypesDemandestems = var1.getMesNatureDemandeItems();
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

   public void recupererModeleDocument() {
      String var1 = "";
      if (this.nature == 220) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "fondation" + File.separator + "document" + File.separator + "demande" + File.separator;
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
      if (this.nature == 220) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "fondation" + File.separator + "liste" + File.separator + "demande" + File.separator;
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

   public void chargerMesClesRepartition(Session var1) throws NamingException {
      this.mesClesItems = new ArrayList();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.mesClesItems = var2.chargerLesAnalytiques("9", var1);
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

   public ObjetLigneMenu getMenufondation() {
      return this.menufondation;
   }

   public void setMenufondation(ObjetLigneMenu var1) {
      this.menufondation = var1;
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

   public List getMesDossiersItems() {
      return this.mesDossiersItems;
   }

   public void setMesDossiersItems(List var1) {
      this.mesDossiersItems = var1;
   }

   public List getMesFamilleClientsItems() {
      return this.mesFamilleClientsItems;
   }

   public void setMesFamilleClientsItems(List var1) {
      this.mesFamilleClientsItems = var1;
   }

   public List getMesFormulesItems() {
      return this.mesFormulesItems;
   }

   public void setMesFormulesItems(List var1) {
      this.mesFormulesItems = var1;
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

   public List getMesSourceItems() {
      return this.mesSourceItems;
   }

   public void setMesSourceItems(List var1) {
      this.mesSourceItems = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public List getMesCompteCaisseItems() {
      return this.mesCompteCaisseItems;
   }

   public void setMesCompteCaisseItems(List var1) {
      this.mesCompteCaisseItems = var1;
   }

   public MenudroitVentesCtrl getMenudroitFondationCtrl() {
      return this.menudroitFondationCtrl;
   }

   public void setMenudroitFondationCtrl(MenudroitVentesCtrl var1) {
      this.menudroitFondationCtrl = var1;
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

   public FormDemandeFondation getFormDemandeFondation() {
      return this.formDemandeFondation;
   }

   public void setFormDemandeFondation(FormDemandeFondation var1) {
      this.formDemandeFondation = var1;
   }

   public List getMesTypesDemandestems() {
      return this.mesTypesDemandestems;
   }

   public void setMesTypesDemandestems(List var1) {
      this.mesTypesDemandestems = var1;
   }
}
