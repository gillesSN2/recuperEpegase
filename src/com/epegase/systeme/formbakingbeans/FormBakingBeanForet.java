package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormExercicesForet;
import com.epegase.forms.commun.FormDocumentsOfficiels;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.foret.FormForetCarnet;
import com.epegase.forms.foret.FormForetInventaire;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitForetCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureClassementForet;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureEssenceForet;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LireLesoptionsParcs;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionConfigListe;
import com.epegase.systeme.xml.OptionParcs;
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

public class FormBakingBeanForet implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private MenudroitForetCtrl menudroitForetCtrl;
   private ObjetLigneMenu menuforet;
   private ObjetLigneMenu menuforetMemo = new ObjetLigneMenu();
   private LectureModulesOnglets lesOnglets;
   private int nature;
   private OptionVentes optionVentes;
   private OptionParcs optionParcs;
   private Habilitation habilitation;
   private ExercicesVentes exoselectionne = new ExercicesVentes();
   private ExercicesVentes lastExoForet = new ExercicesVentes();
   private long leIdExo;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private String messageAlerte;
   private FormDocumentsOfficiels formDocumentsOfficiels;
   private FormExercicesForet formExercicesForet;
   private FormForetInventaire formForetInventaire;
   private FormForetCarnet formForetCarnet;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private List listeImpressionMvtsItems;
   private List mesEssenceItems;
   private List mesClassementItems;
   private List mesLieuxItems;
   private List mesSerieUserItem;
   private List mesRegionsItems;
   private List mesEtatsItems = new ArrayList();
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;

   public FormBakingBeanForet() throws IOException, ParseException {
   }

   public void instanceOptionForet() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererExercices(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      this.leIdExo = this.exoselectionne.getExevteId();
      this.lastExoForet = var2.recupererLastExo(var1);
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

   public List getLesExerciceForet(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesForet = new FormExercicesForet();
      this.formExercicesForet.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesForet.setBaseLog(this.baseLog);
      this.formExercicesForet.setStructureLog(this.structureLog);
      this.formExercicesForet.setUsersLog(this.usersLog);
      this.formExercicesForet.InstancesDaoUtilses();
      return this.formExercicesForet.recupererLesexercices(var1);
   }

   public void menuGaucheForet(int var1) throws JDOMException, IOException {
      if (this.menudroitForetCtrl == null) {
         this.menudroitForetCtrl = new MenudroitForetCtrl();
         this.menudroitForetCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         if (var1 == 81400) {
            this.menudroitForetCtrl.chargerMenudroitForetXml(this.usersLog.getUsrCollaboration());
         } else if (var1 == 81410) {
            this.menudroitForetCtrl.chargerMenudroitUsineDerouageXml(this.usersLog.getUsrCollaboration());
         } else if (var1 == 81420) {
            this.menudroitForetCtrl.chargerMenudroitUsinePlaquageXml(this.usersLog.getUsrCollaboration());
         } else if (var1 == 81430) {
            this.menudroitForetCtrl.chargerMenudroitUsineSciageXml(this.usersLog.getUsrCollaboration());
         } else if (var1 == 81490) {
            this.menudroitForetCtrl.chargerMenudroitForetXml(this.usersLog.getUsrCollaboration());
         }
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("81400", this.usersLog.getUsrCollaboration());
   }

   public void razMemoire() {
      this.formForetInventaire = null;
   }

   public void gestionForet() throws JDOMException, IOException, NamingException, ParseException {
      this.menuforet = new ObjetLigneMenu();
      if (this.menudroitForetCtrl.getDataModelMenudroitForetXmlList().isRowAvailable()) {
         this.menuforet = (ObjetLigneMenu)this.menudroitForetCtrl.getDataModelMenudroitForetXmlList().getRowData();
         if (this.menuforet.getLibelle_FR() != null && !this.menuforet.getLibelle_FR().isEmpty()) {
            this.menuforetMemo = this.menuforet;
            this.aiguillageForet();
         }
      }

   }

   public void gestionForetFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, ParseException {
      this.menuforet = var1;
      this.menuforetMemo = this.menuforet;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheForet(81490);
      }

      this.aiguillageForet();
   }

   public void aiguillageForet() throws JDOMException, IOException, NamingException, ParseException {
      if (this.lastExoForet.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menuforet.setAdd(false);
         this.menuforet.setMaj(false);
         this.menuforet.setSup(false);
         this.menuforet.setDup(false);
         this.menuforet.setClo(false);
         this.menuforet.setTrf(false);
         this.menuforet.setImp(true);
      } else {
         this.menuforet.setAdd(this.menuforetMemo.isAdd());
         this.menuforet.setMaj(this.menuforetMemo.isMaj());
         this.menuforet.setSup(this.menuforetMemo.isSup());
         this.menuforet.setDup(this.menuforetMemo.isDup());
         this.menuforet.setClo(this.menuforetMemo.isClo());
         this.menuforet.setTrf(this.menuforetMemo.isTrf());
         this.menuforet.setImp(this.menuforetMemo.isImp());
      }

      this.razMemoire();
      Session var1;
      String var2;
      if (this.menuforet.getCommande().equalsIgnoreCase("81400:01")) {
         this.nature = 250;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ForetEntete");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/foret/ForetInventaireInit.jsp";
               this.menuForetInventaire(var1);
            } else {
               this.affichePage = "/foret/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/foret/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuforet.getCommande().equalsIgnoreCase("81400:02")) {
         this.nature = 251;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ForetEntete");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + ((new Date()).getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/foret/ForetCarnetInit.jsp";
               this.menuForetCarnet(var1);
            } else {
               this.affichePage = "/foret/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/foret/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menuforet.getCommande().equalsIgnoreCase("80900:97")) {
         this.affichePage = "/commun/documentsOfficiels.jsp";
         this.nature = 100;
         this.menuDocuentsOfficiels();
      }

   }

   public void menuForetInventaire(Session var1) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.formForetInventaire = new FormForetInventaire();
      this.formForetInventaire.setUtilInitHibernate(this.utilInitHibernate);
      this.formForetInventaire.setBaseLog(this.baseLog);
      this.formForetInventaire.setStructureLog(this.structureLog);
      this.formForetInventaire.setUsersLog(this.usersLog);
      this.formForetInventaire.InstancesDaoUtilses();
      this.formForetInventaire.setNature(this.nature);
      this.formForetInventaire.setExercicesVentes(this.exoselectionne);
      this.formForetInventaire.setLastExoVentes(this.lastExoForet);
      this.formForetInventaire.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formForetInventaire.setOptionsVentes(this.optionVentes);
      this.formForetInventaire.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formForetInventaire.setVar_option_parc(100);
         } else {
            this.formForetInventaire.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formForetInventaire.setVar_option_parc(100);
      }

      this.formForetInventaire.configVentes(var1);
      this.formForetInventaire.accesResteintUser();
      this.formForetInventaire.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.recupererLieuxItem(var1);
      this.formForetInventaire.setMesEssencesItem(this.mesEssenceItems);
      this.formForetInventaire.setMesClassementsItem(this.mesClassementItems);
      this.formForetInventaire.setMesLieuxItem(this.mesLieuxItems);
      this.formForetInventaire.chargerCommerciauxResponsable(var1);
      this.formForetInventaire.setHabilitation(this.habilitation);
      this.formForetInventaire.setFormRecherche(this.formRecherche);
      this.formForetInventaire.setMesSerieUserItem(this.mesSerieUserItem);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionVentes.getChargementListe() != null && !this.optionVentes.getChargementListe().isEmpty() && this.optionVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formForetInventaire.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formForetInventaire.executerRequete(var1);
      }

   }

   public void menuForetCarnet(Session var1) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.formForetCarnet = new FormForetCarnet();
      this.formForetCarnet.setUtilInitHibernate(this.utilInitHibernate);
      this.formForetCarnet.setBaseLog(this.baseLog);
      this.formForetCarnet.setStructureLog(this.structureLog);
      this.formForetCarnet.setUsersLog(this.usersLog);
      this.formForetCarnet.InstancesDaoUtilses();
      this.formForetCarnet.setNature(this.nature);
      this.formForetCarnet.setExercicesVentes(this.exoselectionne);
      this.formForetCarnet.setLastExoVentes(this.lastExoForet);
      this.formForetCarnet.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formForetCarnet.setOptionsVentes(this.optionVentes);
      this.formForetCarnet.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formForetCarnet.setVar_option_parc(100);
         } else {
            this.formForetCarnet.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formForetCarnet.setVar_option_parc(100);
      }

      this.formForetCarnet.configVentes(var1);
      this.formForetCarnet.accesResteintUser();
      this.formForetCarnet.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.recupererLieuxItem(var1);
      this.formForetCarnet.setMesEssencesItem(this.mesEssenceItems);
      this.formForetCarnet.setMesClassementsItem(this.mesClassementItems);
      this.formForetCarnet.setMesLieuxItem(this.mesLieuxItems);
      this.formForetCarnet.chargerCommerciauxResponsable(var1);
      this.formForetCarnet.setHabilitation(this.habilitation);
      this.formForetCarnet.setFormRecherche(this.formRecherche);
      this.formForetCarnet.setMesSerieUserItem(this.mesSerieUserItem);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionVentes.getChargementListe() != null && !this.optionVentes.getChargementListe().isEmpty() && this.optionVentes.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formForetCarnet.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formForetCarnet.executerRequete(var1);
      }

   }

   public void menuDocuentsOfficiels() throws IOException, HibernateException, NamingException {
      this.formDocumentsOfficiels.ouvrirDocument();
   }

   public void menuSelectionExercicesForet() throws IOException, JDOMException, NamingException {
      this.formExercicesForet = new FormExercicesForet();
      this.formExercicesForet.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesForet.setBaseLog(this.baseLog);
      this.formExercicesForet.setStructureLog(this.structureLog);
      this.formExercicesForet.setUsersLog(this.usersLog);
      this.formExercicesForet.InstancesDaoUtilses();
      this.leIdExo = this.exoselectionne.getExevteId();
      this.formExercicesForet.setLesexercicesVentes(this.formExercicesForet.recupererLesexercices((Session)null));
   }

   public void recupererTousLesItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererOptionsForet();
      this.recupererModelesAutorises();
      this.recupererEssencesItem(var1);
      this.recupererClassementsItem(var1);
      this.recupererRegionItem(var1);
   }

   public void recupererLesItemsDoc(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererSerieUserItem(var1);
      this.recupererModeleDocument();
      this.recupererModeleListe();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
      this.recupererHabilitation(var1);
   }

   public void recupererOptionsForet() {
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var1 = new LireLesoptionsVentes();
      var1.setStrId(this.structureLog.getStrid());
      var1.lancer();
      this.optionVentes = var1.lancer();
      this.optionParcs = new OptionParcs();
      LireLesoptionsParcs var2 = new LireLesoptionsParcs();
      var2.setStrId(this.structureLog.getStrid());
      var2.lancer();
      this.optionParcs = var2.lancer();
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

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

   public void recupererEssencesItem(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      this.mesEssenceItems = new ArrayList();
      LectureEssenceForet var2 = new LectureEssenceForet();
      var2.setStrId(this.structureLog.getStrid());
      var2.setStructureLog(this.structureLog);
      this.mesEssenceItems = var2.chargerEssences();
   }

   public void recupererClassementsItem(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      this.mesClassementItems = new ArrayList();
      LectureClassementForet var2 = new LectureClassementForet();
      var2.setStrId(this.structureLog.getStrid());
      var2.setStructureLog(this.structureLog);
      this.mesClassementItems = var2.chargerClassements();
   }

   public void recupererRegionItem(Session var1) throws HibernateException, NamingException {
      this.mesRegionsItems = new ArrayList();
      RegionDao var2 = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.mesRegionsItems = var2.chargerLesRegionItems(var1);
   }

   public void recupererLieuxItem(Session var1) throws HibernateException, NamingException {
      this.mesLieuxItems = new ArrayList();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.chargerLesPlansAnalytiques("7", var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            if (this.nature == 250 && ((PlansAnalytiques)var3.get(var4)).getAnaType() == 0) {
               this.mesLieuxItems.add(new SelectItem(((PlansAnalytiques)var3.get(var4)).getAnaCode(), ((PlansAnalytiques)var3.get(var4)).getAnaCode() + ":" + ((PlansAnalytiques)var3.get(var4)).getAnaNomFr()));
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
      }

   }

   public void recupererModeleDocument() {
      String var1 = "";
      if (this.nature == 250) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "inventaire" + File.separator;
      } else if (this.nature == 251) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "carnet" + File.separator;
      } else if (this.nature == 252) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "b_rupture" + File.separator;
      } else if (this.nature == 253) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "b_route" + File.separator;
      } else if (this.nature == 254) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "b_expedition" + File.separator;
      } else if (this.nature == 255) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "note_credit" + File.separator;
      } else if (this.nature == 256) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "specification" + File.separator;
      } else if (this.nature == 257) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "taxe_martelage" + File.separator;
      } else if (this.nature == 258) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "redevance_attibution" + File.separator;
      } else if (this.nature == 259) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "releve_snbg" + File.separator;
      } else if (this.nature == 260) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "document" + File.separator + "fermage_precompte" + File.separator;
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
      if (this.nature == 250) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "inventaire" + File.separator;
      } else if (this.nature == 251) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "carnet" + File.separator;
      } else if (this.nature == 252) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "b_rupture" + File.separator;
      } else if (this.nature == 253) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "b_route" + File.separator;
      } else if (this.nature == 254) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "b_expedition" + File.separator;
      } else if (this.nature == 255) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "note_credit" + File.separator;
      } else if (this.nature == 256) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "specification" + File.separator;
      } else if (this.nature == 257) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "taxe_martelage" + File.separator;
      } else if (this.nature == 258) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "redevance_attibution" + File.separator;
      } else if (this.nature == 259) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "releve_snbg" + File.separator;
      } else if (this.nature == 260) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "foret" + File.separator + "liste" + File.separator + "fermage_precompte" + File.separator;
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

   public LectureModulesOnglets getLesOnglets() {
      return this.lesOnglets;
   }

   public void setLesOnglets(LectureModulesOnglets var1) {
      this.lesOnglets = var1;
   }

   public MenudroitForetCtrl getMenudroitForetCtrl() {
      return this.menudroitForetCtrl;
   }

   public void setMenudroitForetCtrl(MenudroitForetCtrl var1) {
      this.menudroitForetCtrl = var1;
   }

   public ObjetLigneMenu getMenuforet() {
      return this.menuforet;
   }

   public void setMenuforet(ObjetLigneMenu var1) {
      this.menuforet = var1;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public long getLeIdExo() {
      return this.leIdExo;
   }

   public void setLeIdExo(long var1) {
      this.leIdExo = var1;
   }

   public ExercicesVentes getExoselectionne() {
      return this.exoselectionne;
   }

   public void setExoselectionne(ExercicesVentes var1) {
      this.exoselectionne = var1;
   }

   public ExercicesVentes getLastExoForet() {
      return this.lastExoForet;
   }

   public void setLastExoForet(ExercicesVentes var1) {
      this.lastExoForet = var1;
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

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
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

   public List getListeImpressionMvtsItems() {
      return this.listeImpressionMvtsItems;
   }

   public void setListeImpressionMvtsItems(List var1) {
      this.listeImpressionMvtsItems = var1;
   }

   public String getMessageAlerte() {
      return this.messageAlerte;
   }

   public void setMessageAlerte(String var1) {
      this.messageAlerte = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
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

   public FormExercicesForet getFormExercicesForet() {
      return this.formExercicesForet;
   }

   public void setFormExercicesForet(FormExercicesForet var1) {
      this.formExercicesForet = var1;
   }

   public FormDocumentsOfficiels getFormDocumentsOfficiels() {
      return this.formDocumentsOfficiels;
   }

   public void setFormDocumentsOfficiels(FormDocumentsOfficiels var1) {
      this.formDocumentsOfficiels = var1;
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

   public List getMesRegionsItems() {
      return this.mesRegionsItems;
   }

   public void setMesRegionsItems(List var1) {
      this.mesRegionsItems = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public FormForetInventaire getFormForetInventaire() {
      return this.formForetInventaire;
   }

   public void setFormForetInventaire(FormForetInventaire var1) {
      this.formForetInventaire = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public List getMesEtatsItems() {
      return this.mesEtatsItems;
   }

   public void setMesEtatsItems(List var1) {
      this.mesEtatsItems = var1;
   }

   public FormForetCarnet getFormForetCarnet() {
      return this.formForetCarnet;
   }

   public void setFormForetCarnet(FormForetCarnet var1) {
      this.formForetCarnet = var1;
   }
}
