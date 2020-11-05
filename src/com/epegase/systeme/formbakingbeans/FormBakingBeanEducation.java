package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormExercicesVentes;
import com.epegase.forms.commun.FormDocumentsOfficiels;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.education.FormBonEncaissementEducation;
import com.epegase.forms.education.FormDocumentMediatheque;
import com.epegase.forms.education.FormGestionEleves;
import com.epegase.forms.education.FormImpressionEducation;
import com.epegase.systeme.classe.Chrono;
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
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FilieresEducationDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitEducationCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureReglementClient;
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

public class FormBakingBeanEducation implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private MenudroitEducationCtrl menudroitEducationCtrl;
   private ObjetLigneMenu menueducation;
   private ObjetLigneMenu menueducationMemo = new ObjetLigneMenu();
   private LectureModulesOnglets lesOnglets;
   private int nature;
   private OptionVentes optionVentes;
   private Habilitation habilitation;
   private ExercicesVentes exoselectionne = new ExercicesVentes();
   private ExercicesVentes lastExoEducation = new ExercicesVentes();
   private long leIdExo;
   private int var_timbre;
   private boolean var_marque_util = false;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private String messageAlerte;
   private long var_memo_id_master;
   private FormDocumentsOfficiels formDocumentsOfficiels;
   private FormDocumentMediatheque formDocumentMediatheque;
   private FormGestionEleves formGestionEleves;
   private FormBonEncaissementEducation formBonEncaissementEducation;
   private FormImpressionEducation formImpressionEducation;
   private FormExercicesVentes formExercicesVentes;
   private List mesdevisesItem;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private List mesTypeReglements;
   private List mesClasseItems;
   private List mesCaissesItems;
   private List mesBanquesItems;
   private List mesSerieUserItem;
   private List mesActivitesItems;
   private List mesBudgetsItems;
   private List mesSitesItems;
   private List mesRegionsItems;
   private List mesEtatsItems = new ArrayList();
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;

   public FormBakingBeanEducation() throws IOException, ParseException {
   }

   public void instanceOptionEducation() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererExercices(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      this.leIdExo = this.exoselectionne.getExevteId();
      this.lastExoEducation = var2.recupererLastExo(var1);
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

   public List getLesExerciceEducation(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesVentes = new FormExercicesVentes();
      this.formExercicesVentes.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesVentes.setBaseLog(this.baseLog);
      this.formExercicesVentes.setStructureLog(this.structureLog);
      this.formExercicesVentes.setUsersLog(this.usersLog);
      this.formExercicesVentes.InstancesDaoUtilses();
      return this.formExercicesVentes.recupererLesexercices(var1);
   }

   public void menuGaucheEducation() throws JDOMException, IOException {
      if (this.menudroitEducationCtrl == null) {
         this.menudroitEducationCtrl = new MenudroitEducationCtrl();
         this.menudroitEducationCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitEducationCtrl.chargerMenudroitEducationXml(this.usersLog.getUsrCollaboration());
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("80900", this.usersLog.getUsrCollaboration());
   }

   public void razMemoire() {
   }

   public void gestionEducation() throws JDOMException, IOException, NamingException, ParseException {
      this.menueducation = new ObjetLigneMenu();
      if (this.menudroitEducationCtrl.getDataModelMenudroitEducationXmlList().isRowAvailable()) {
         this.menueducation = (ObjetLigneMenu)this.menudroitEducationCtrl.getDataModelMenudroitEducationXmlList().getRowData();
         if (this.menueducation.getLibelle_FR() != null && !this.menueducation.getLibelle_FR().isEmpty()) {
            this.menueducationMemo = this.menueducation;
            this.aiguillageEducation();
         }
      }

   }

   public void gestionEducationFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, ParseException {
      this.menueducation = var1;
      this.menueducationMemo = this.menueducation;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheEducation();
      }

      this.aiguillageEducation();
   }

   public void aiguillageEducation() throws JDOMException, IOException, NamingException, ParseException {
      if (this.lastExoEducation.getExevteId() != this.exoselectionne.getExevteId()) {
         this.menueducation.setAdd(false);
         this.menueducation.setMaj(false);
         this.menueducation.setSup(false);
         this.menueducation.setDup(false);
         this.menueducation.setClo(false);
         this.menueducation.setTrf(false);
         this.menueducation.setImp(true);
      } else {
         this.menueducation.setAdd(this.menueducationMemo.isAdd());
         this.menueducation.setMaj(this.menueducationMemo.isMaj());
         this.menueducation.setSup(this.menueducationMemo.isSup());
         this.menueducation.setDup(this.menueducationMemo.isDup());
         this.menueducation.setClo(this.menueducationMemo.isClo());
         this.menueducation.setTrf(this.menueducationMemo.isTrf());
         this.menueducation.setImp(this.menueducationMemo.isImp());
      }

      this.razMemoire();
      if (this.menueducation.getCommande().equalsIgnoreCase("80900:01")) {
         this.nature = 101;
         this.affichePage = "/education/MediathequeInit.jsp";
         this.menuDocumentMediatheque();
      } else if (this.menueducation.getCommande().equalsIgnoreCase("80900:02")) {
         this.affichePage = "/education/GestionElevesInit.jsp";
         this.nature = 100;
         this.menuGestionEleve();
      } else {
         Session var1;
         String var2;
         if (this.menueducation.getCommande().equalsIgnoreCase("80900:03")) {
            this.nature = 103;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviEducation");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/education/GestionAppelsInit.jsp";
                  this.menuGestionAppels(var1);
               } else {
                  this.affichePage = "/education/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/education/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menueducation.getCommande().equalsIgnoreCase("80900:04")) {
            this.nature = 104;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviEducation");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/education/GestionNoteInit.jsp";
                  this.menuGestionNote(var1);
               } else {
                  this.affichePage = "/education/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/education/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menueducation.getCommande().equalsIgnoreCase("80900:05")) {
            this.nature = 105;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviEducation");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/education/GestionViolencesInit.jsp";
                  this.menuGestionViolences(var1);
               } else {
                  this.affichePage = "/education/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/education/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menueducation.getCommande().equalsIgnoreCase("80900:10")) {
            this.nature = 109;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementEducation");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/education/BonEncaissementInit.jsp";
                  this.menuBonEncaissement(var1);
               } else {
                  this.affichePage = "/education/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/education/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menueducation.getCommande().equalsIgnoreCase("80900:97")) {
            this.affichePage = "/commun/documentsOfficiels.jsp";
            this.nature = 100;
            this.menuDocuentsOfficiels();
         } else if (this.menueducation.getCommande().equalsIgnoreCase("80900:90")) {
            this.affichePage = "/education/ImpressionEducation.jsp";
            this.menuImpressionEducation();
         } else if (this.menueducation.getCommande().equalsIgnoreCase("80900:99")) {
            this.affichePage = "/education/SelectionExercicesVentes.jsp";
            this.menuSelectionExercicesVentes();
         }
      }

   }

   public void menuDocumentMediatheque() throws JDOMException, IOException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ClassementMediatheque");
      this.formDocumentMediatheque = new FormDocumentMediatheque();
      this.formDocumentMediatheque.setUtilInitHibernate(this.utilInitHibernate);
      this.formDocumentMediatheque.setBaseLog(this.baseLog);
      this.formDocumentMediatheque.setStructureLog(this.structureLog);
      this.formDocumentMediatheque.setUsersLog(this.usersLog);
      this.formDocumentMediatheque.InstancesDaoUtilses();
      this.formDocumentMediatheque.setNature(this.nature);
      this.formDocumentMediatheque.setUrlExplorateur(this.urlExplorateur);
      this.formDocumentMediatheque.setExercicesVentes(this.exoselectionne);
      this.formDocumentMediatheque.setLastExoVentes(this.lastExoEducation);
      this.formDocumentMediatheque.setOptionsVentes(this.optionVentes);
      this.formDocumentMediatheque.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formDocumentMediatheque.configVentes(var1);
      this.formDocumentMediatheque.accesResteintUser();
      this.formDocumentMediatheque.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formDocumentMediatheque.setFormRecherche(this.formRecherche);
      this.utilInitHibernate.closeSession();
   }

   public void menuGestionEleve() throws JDOMException, IOException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviEducation");
      this.formGestionEleves = new FormGestionEleves();
      this.formGestionEleves.setUtilInitHibernate(this.utilInitHibernate);
      this.formGestionEleves.setBaseLog(this.baseLog);
      this.formGestionEleves.setStructureLog(this.structureLog);
      this.formGestionEleves.setUsersLog(this.usersLog);
      this.formGestionEleves.InstancesDaoUtilses();
      this.formGestionEleves.setNature(this.nature);
      this.formGestionEleves.setUrlExplorateur(this.urlExplorateur);
      this.formGestionEleves.setExercicesVentes(this.exoselectionne);
      this.formGestionEleves.setLastExoVentes(this.lastExoEducation);
      this.formGestionEleves.setOptionsVentes(this.optionVentes);
      this.formGestionEleves.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formGestionEleves.configVentes(var1);
      this.formGestionEleves.accesResteintUser();
      this.formGestionEleves.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formGestionEleves.setFormRecherche(this.formRecherche);
      this.formGestionEleves.setUsersChrono(this.usersChrono);
      this.utilInitHibernate.closeSession();
   }

   public void menuGestionAppels(Session var1) throws JDOMException, IOException, NamingException, ParseException {
      this.formGestionEleves = new FormGestionEleves();
      this.formGestionEleves.setUtilInitHibernate(this.utilInitHibernate);
      this.formGestionEleves.setBaseLog(this.baseLog);
      this.formGestionEleves.setStructureLog(this.structureLog);
      this.formGestionEleves.setUsersLog(this.usersLog);
      this.formGestionEleves.InstancesDaoUtilses();
      this.formGestionEleves.setNature(this.nature);
      this.formGestionEleves.setUrlExplorateur(this.urlExplorateur);
      this.formGestionEleves.setExercicesVentes(this.exoselectionne);
      this.formGestionEleves.setLastExoVentes(this.lastExoEducation);
      this.formGestionEleves.setOptionsVentes(this.optionVentes);
      this.formGestionEleves.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formGestionEleves.configVentes(var1);
      this.formGestionEleves.accesResteintUser();
      this.formGestionEleves.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formGestionEleves.setFormRecherche(this.formRecherche);
      this.formGestionEleves.setUsersChrono(this.usersChrono);
   }

   public void menuGestionNote(Session var1) throws JDOMException, IOException, NamingException, ParseException {
      this.formGestionEleves = new FormGestionEleves();
      this.formGestionEleves.setUtilInitHibernate(this.utilInitHibernate);
      this.formGestionEleves.setBaseLog(this.baseLog);
      this.formGestionEleves.setStructureLog(this.structureLog);
      this.formGestionEleves.setUsersLog(this.usersLog);
      this.formGestionEleves.InstancesDaoUtilses();
      this.formGestionEleves.setNature(this.nature);
      this.formGestionEleves.setUrlExplorateur(this.urlExplorateur);
      this.formGestionEleves.setExercicesVentes(this.exoselectionne);
      this.formGestionEleves.setLastExoVentes(this.lastExoEducation);
      this.formGestionEleves.setOptionsVentes(this.optionVentes);
      this.formGestionEleves.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formGestionEleves.configVentes(var1);
      this.formGestionEleves.accesResteintUser();
      this.formGestionEleves.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formGestionEleves.setFormRecherche(this.formRecherche);
      this.formGestionEleves.setUsersChrono(this.usersChrono);
   }

   public void menuGestionViolences(Session var1) throws JDOMException, IOException, NamingException, ParseException {
      this.formGestionEleves = new FormGestionEleves();
      this.formGestionEleves.setUtilInitHibernate(this.utilInitHibernate);
      this.formGestionEleves.setBaseLog(this.baseLog);
      this.formGestionEleves.setStructureLog(this.structureLog);
      this.formGestionEleves.setUsersLog(this.usersLog);
      this.formGestionEleves.InstancesDaoUtilses();
      this.formGestionEleves.setNature(this.nature);
      this.formGestionEleves.setUrlExplorateur(this.urlExplorateur);
      this.formGestionEleves.setExercicesVentes(this.exoselectionne);
      this.formGestionEleves.setLastExoVentes(this.lastExoEducation);
      this.formGestionEleves.setOptionsVentes(this.optionVentes);
      this.formGestionEleves.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formGestionEleves.configVentes(var1);
      this.formGestionEleves.accesResteintUser();
      this.formGestionEleves.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formGestionEleves.setFormRecherche(this.formRecherche);
      this.formGestionEleves.setUsersChrono(this.usersChrono);
   }

   public void menuBonEncaissement(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.formBonEncaissementEducation = new FormBonEncaissementEducation();
      this.formBonEncaissementEducation.setutilInitHibernate(this.utilInitHibernate);
      this.formBonEncaissementEducation.setBaseLog(this.baseLog);
      this.formBonEncaissementEducation.setStructureLog(this.structureLog);
      this.formBonEncaissementEducation.setUsersLog(this.usersLog);
      this.formBonEncaissementEducation.InstancesDaoUtilses();
      this.formBonEncaissementEducation.setExercicesVentes(this.exoselectionne);
      this.formBonEncaissementEducation.setOptionsVentes(this.optionVentes);
      this.formBonEncaissementEducation.setUsersChrono(this.usersChrono);
      this.formBonEncaissementEducation.chargerFind(var1);
      this.recupererLesItemsDoc(var1);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuDocuentsOfficiels() throws IOException, HibernateException, NamingException {
      this.formDocumentsOfficiels.ouvrirDocument();
   }

   public void menuImpressionEducation() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviEducation");
      this.formImpressionEducation = new FormImpressionEducation();
      this.formImpressionEducation.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionEducation.setBaseLog(this.baseLog);
      this.formImpressionEducation.setStructureLog(this.structureLog);
      this.formImpressionEducation.setUsersLog(this.usersLog);
      this.formImpressionEducation.InstancesDaoUtilses();
      this.formImpressionEducation.setExoSelectionne(this.exoselectionne);
      this.formImpressionEducation.setOptionVentes(this.optionVentes);
      this.formImpressionEducation.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionEducation.chargerLesRepImpEducation(var1);
      this.formImpressionEducation.calculeAnalytique();
      this.recupererLesItemsImpression(var1);
      this.formImpressionEducation.initImpression();
      this.formImpressionEducation.chargerPeriodes();
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuSelectionExercicesVentes() throws IOException, JDOMException, NamingException {
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
      this.recupererOptionsEducation();
      this.recupererModelesAutorises();
      this.recupererClassesItem(var1);
      this.recupererLesSiteItem(var1);
      this.recupererRegionItem(var1);
      this.recupererClassesItem(var1);
      this.recupererCaissesItem(var1);
      this.recupererBanquesItem(var1);
      this.recupererBudgetItem(var1);
      this.recupererActiviteItem(var1);
      this.recupererTypesReglementsItem();
   }

   public void recupererLesItemsImpression(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
   }

   public void recupererLesItemsDoc(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererSerieUserItem(var1);
      this.recupererModeleDocument();
      this.recupererModeleListe();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
      this.recupererHabilitation(var1);
   }

   public void recupererOptionsEducation() {
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var1 = new LireLesoptionsVentes();
      var1.setStrId(this.structureLog.getStrid());
      var1.lancer();
      this.optionVentes = var1.lancer();
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "education" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "education" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
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

   public void recupererClassesItem(Session var1) throws HibernateException, NamingException {
      this.mesClasseItems = new ArrayList();
      FilieresEducationDao var2 = new FilieresEducationDao(this.baseLog, this.utilInitHibernate);
      this.mesClasseItems = var2.mesFilieresItems(var1);
   }

   public void recupererActiviteItem(Session var1) throws HibernateException, NamingException {
      this.mesActivitesItems = new ArrayList();
      ActivitesDao var2 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.mesActivitesItems = var2.chargerLesActivites(var1);
   }

   public void recupererBudgetItem(Session var1) throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      BudgetDao var2 = new BudgetDao(this.baseLog, this.utilInitHibernate);
      this.mesBudgetsItems = var2.selectAllBudget(this.exoselectionne.getExevteId(), var1);
   }

   public void recupererCaissesItem(Session var1) throws HibernateException, NamingException {
      this.mesCaissesItems = new ArrayList();
      CaissesCommercialesDao var2 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.mesCaissesItems = var2.selectActifCaisseItems(var1);
   }

   public void recupererBanquesItem(Session var1) throws HibernateException, NamingException {
      this.mesBanquesItems = new ArrayList();
      new ExercicesComptable();
      ExercicesComptableDao var3 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      ExercicesComptable var2 = var3.recupererLastExo(var1);
      if (var2 != null) {
         JournauxComptablesDao var4 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
         this.mesBanquesItems = var4.chargerLesJournaux(var2, var1);
      }

   }

   public void recupererLesSiteItem(Session var1) throws HibernateException, NamingException {
      this.mesSitesItems = new ArrayList();
      SiteDao var2 = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.mesSitesItems = var2.chargerLesSitesItems(var1);
   }

   public void recupererRegionItem(Session var1) throws HibernateException, NamingException {
      this.mesRegionsItems = new ArrayList();
      RegionDao var2 = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.mesRegionsItems = var2.chargerLesRegionItems(var1);
   }

   public void recupererTypesReglementsItem() throws JDOMException, IOException {
      LectureReglementClient var1 = new LectureReglementClient();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.recupereReglementClient();
      this.mesTypeReglements = var1.getMesReglementClientItems();
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
      if (this.nature == 100) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "eleve" + File.separator;
      } else if (this.nature == 101) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "mediatheque" + File.separator;
      } else if (this.nature == 102) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "inscription" + File.separator;
      } else if (this.nature == 103) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "appel" + File.separator;
      } else if (this.nature == 104) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "note" + File.separator;
      } else if (this.nature == 109) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "document" + File.separator + "bon_encaissement" + File.separator;
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
      if (this.nature == 100) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "eleve" + File.separator;
      } else if (this.nature == 101) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "mediatheque" + File.separator;
      } else if (this.nature == 102) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "inscription" + File.separator;
      } else if (this.nature == 103) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "appel" + File.separator;
      } else if (this.nature == 104) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "note" + File.separator;
      } else if (this.nature == 109) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education" + File.separator + "liste" + File.separator + "bon_encaissement" + File.separator;
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

   public MenudroitEducationCtrl getMenudroitEducationCtrl() {
      return this.menudroitEducationCtrl;
   }

   public void setMenudroitEducationCtrl(MenudroitEducationCtrl var1) {
      this.menudroitEducationCtrl = var1;
   }

   public ObjetLigneMenu getMenueducation() {
      return this.menueducation;
   }

   public void setMenueducation(ObjetLigneMenu var1) {
      this.menueducation = var1;
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

   public ExercicesVentes getLastExoEducation() {
      return this.lastExoEducation;
   }

   public void setLastExoEducation(ExercicesVentes var1) {
      this.lastExoEducation = var1;
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

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
   }

   public List getMesSitesItems() {
      return this.mesSitesItems;
   }

   public void setMesSitesItems(List var1) {
      this.mesSitesItems = var1;
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

   public FormExercicesVentes getFormExercicesVentes() {
      return this.formExercicesVentes;
   }

   public void setFormExercicesVentes(FormExercicesVentes var1) {
      this.formExercicesVentes = var1;
   }

   public FormDocumentMediatheque getFormDocumentMediatheque() {
      return this.formDocumentMediatheque;
   }

   public void setFormDocumentMediatheque(FormDocumentMediatheque var1) {
      this.formDocumentMediatheque = var1;
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

   public FormGestionEleves getFormGestionEleves() {
      return this.formGestionEleves;
   }

   public void setFormGestionEleves(FormGestionEleves var1) {
      this.formGestionEleves = var1;
   }

   public List getMesClasseItems() {
      return this.mesClasseItems;
   }

   public void setMesClasseItems(List var1) {
      this.mesClasseItems = var1;
   }

   public FormBonEncaissementEducation getFormBonEncaissementEducation() {
      return this.formBonEncaissementEducation;
   }

   public void setFormBonEncaissementEducation(FormBonEncaissementEducation var1) {
      this.formBonEncaissementEducation = var1;
   }

   public List getMesRegionsItems() {
      return this.mesRegionsItems;
   }

   public void setMesRegionsItems(List var1) {
      this.mesRegionsItems = var1;
   }

   public List getMesCaissesItems() {
      return this.mesCaissesItems;
   }

   public void setMesCaissesItems(List var1) {
      this.mesCaissesItems = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public FormImpressionEducation getFormImpressionEducation() {
      return this.formImpressionEducation;
   }

   public void setFormImpressionEducation(FormImpressionEducation var1) {
      this.formImpressionEducation = var1;
   }

   public long getVar_memo_id_master() {
      return this.var_memo_id_master;
   }

   public void setVar_memo_id_master(long var1) {
      this.var_memo_id_master = var1;
   }
}
