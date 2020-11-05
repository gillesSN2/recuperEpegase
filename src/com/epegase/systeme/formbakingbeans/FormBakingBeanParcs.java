package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormExercicesParcs;
import com.epegase.forms.administration.FormExercicesVentes;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.parc.FormConsommation;
import com.epegase.forms.parc.FormImpressionParc;
import com.epegase.forms.parc.FormLocalisationGps;
import com.epegase.forms.parc.FormManifestePrc;
import com.epegase.forms.parc.FormParcListe;
import com.epegase.forms.parc.FormParcLocation;
import com.epegase.forms.parc.FormParcOr;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.ExercicesParcsDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FamillesParc1Dao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitParcsCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureNatureParc;
import com.epegase.systeme.xml.LireLesoptionsParcs;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionConfigListe;
import com.epegase.systeme.xml.OptionParcs;
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

public class FormBakingBeanParcs implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private MenudroitParcsCtrl menudroitParcCtrl;
   private ObjetLigneMenu menuparc;
   private ObjetLigneMenu menuparcMemo = new ObjetLigneMenu();
   private LectureModulesOnglets lesOnglets;
   private List mesEtatsItems = new ArrayList();
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
   private int nature;
   private OptionVentes optionVentes;
   private ExercicesVentes exoselectionneVentes = new ExercicesVentes();
   private ExercicesVentes lastExerciceVentes = new ExercicesVentes();
   private long leIdExoVentes;
   private OptionParcs optionParcs;
   private Habilitation habilitation;
   private ExercicesParc exoselectionne = new ExercicesParc();
   private ExercicesParc lastExerciceParc = new ExercicesParc();
   private long leIdExo;
   private int var_timbre;
   private int var_tc_type;
   private String var_tc_libelle;
   private float var_tc_taux;
   private boolean verifBareme;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private Chrono chrono;
   private ChronoDao chronoDao;
   private String messageAlerte;
   private long var_memo_id_master;
   private FormExercicesParcs formExercicesParcs;
   private FormExercicesVentes formExercicesVentes;
   private FormParcListe formParcListe;
   private FormConsommation formConsommation;
   private FormParcOr formParcOr;
   private FormImpressionParc formImpressionParc;
   private FormLocalisationGps formLocalisationGps;
   private FormManifestePrc formManifestePrc;
   private FormParcLocation formParcLocation;
   private List mesdevisesItem;
   private List mesServicesItems;
   private List mesSitesItems;
   private List mesDepartementsItems;
   private List mesSerieUserItem;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private List mesTaxesItems;
   private List mesNatureItems = new ArrayList();
   private List mesServiceItems = new ArrayList();
   private List mesActivitesItems = new ArrayList();
   private List mesFamilleItems = new ArrayList();
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private FileCtrl fileCtrl;
   private ArrayList listFiles;
   private UploadItem item;
   private int uploadsAvailable = 1;
   private boolean showModalPanelImportation = false;
   private int var_choix_importation;
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;

   public FormBakingBeanParcs() throws IOException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererExercices(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      ExercicesParcsDao var2 = new ExercicesParcsDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      this.leIdExo = this.exoselectionne.getExeprcId();
      this.lastExerciceParc = var2.recupererLastExo(var1);
      ExercicesVentesDao var3 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionneVentes = var3.recupererLExoSelect(this.leIdExoVentes, var1);
      this.leIdExoVentes = this.exoselectionneVentes.getExevteId();
      this.lastExerciceVentes = var3.recupererLastExo(var1);
   }

   public void recupererLeIdExo() throws HibernateException, NamingException {
      this.recupererLeIdExo((Session)null);
   }

   public ExercicesParc recupererLeIdExo(Session var1) throws NamingException {
      ExercicesParcsDao var2 = new ExercicesParcsDao(this.baseLog, this.utilInitHibernate);
      if (this.leIdExo != 0L) {
         this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      } else {
         this.exoselectionne = var2.recupererLastExo(var1);
      }

      this.leIdExo = this.exoselectionne.getExeprcId();
      return this.exoselectionne;
   }

   public List getLesExerciceParc(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesParcs = new FormExercicesParcs();
      this.formExercicesParcs.InstancesDaoUtilses();
      return this.formExercicesParcs.recupererLesexercices(var1);
   }

   public List getLesExerciceVentes(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formExercicesVentes = new FormExercicesVentes();
      this.formExercicesVentes.InstancesDaoUtilses();
      return this.formExercicesVentes.recupererLesexercices(var1);
   }

   public void menuGaucheParcs() throws JDOMException, IOException {
      if (this.menudroitParcCtrl == null) {
         this.menudroitParcCtrl = new MenudroitParcsCtrl(this.optionParcs);
         this.menudroitParcCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitParcCtrl.chargerMenuGaucheParcsXml(this.usersLog.getUsrCollaboration());
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("70000", this.usersLog.getUsrCollaboration());
   }

   public void gestionParc() throws JDOMException, IOException, NamingException, HibernateException, ParseException, SAXException {
      this.menuparc = new ObjetLigneMenu();
      if (this.menudroitParcCtrl.getDataModelMenudroitParcsXmlList().isRowAvailable()) {
         this.menuparc = (ObjetLigneMenu)this.menudroitParcCtrl.getDataModelMenudroitParcsXmlList().getRowData();
         if (this.menuparc.getLibelle_FR() != null && !this.menuparc.getLibelle_FR().isEmpty()) {
            this.menuparcMemo = this.menuparc;
            this.aiguillageParc();
         }
      }

   }

   public void razMemoire() {
      this.formConsommation = null;
      this.formParcListe = null;
      this.formParcOr = null;
      this.formImpressionParc = null;
      this.formManifestePrc = null;
   }

   public void gestionParcFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, ParseException {
      this.menuparc = var1;
      this.menuparcMemo = this.menuparc;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheParcs();
      }

      this.aiguillageParc();
   }

   public void aiguillageParc() throws JDOMException, IOException, NamingException, HibernateException, ParseException, SAXException {
      if (this.lastExerciceParc.getExeprcId() != this.exoselectionne.getExeprcId()) {
         this.menuparc.setAdd(false);
         this.menuparc.setMaj(false);
         this.menuparc.setSup(false);
         this.menuparc.setDup(false);
         this.menuparc.setClo(false);
         this.menuparc.setTrf(false);
         this.menuparc.setImp(true);
      } else {
         this.menuparc.setAdd(this.menuparcMemo.isAdd());
         this.menuparc.setMaj(this.menuparcMemo.isMaj());
         this.menuparc.setSup(this.menuparcMemo.isSup());
         this.menuparc.setDup(this.menuparcMemo.isDup());
         this.menuparc.setClo(this.menuparcMemo.isClo());
         this.menuparc.setTrf(this.menuparcMemo.isTrf());
         this.menuparc.setImp(this.menuparcMemo.isImp());
      }

      this.razMemoire();
      if (this.menuparc.getCommande().equalsIgnoreCase("70000:01")) {
         this.affichePage = "/parc/ParcListeInit.jsp";
         this.menuListeParc();
      } else if (this.menuparc.getCommande().equalsIgnoreCase("70000:07")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else if (this.menuparc.getCommande().equalsIgnoreCase("70000:02")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else if (this.menuparc.getCommande().equalsIgnoreCase("70000:03")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else if (this.menuparc.getCommande().equalsIgnoreCase("70000:04")) {
         this.affichePage = "/pageenconstruction.jsp";
      } else {
         Session var1;
         String var2;
         if (this.menuparc.getCommande().equalsIgnoreCase("70000:05")) {
            this.nature = 43;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/parc/LocationInit.jsp";
                  this.menuLocation(var1);
               } else {
                  this.affichePage = "/parc/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/parc/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuparc.getCommande().equalsIgnoreCase("70000:06")) {
            this.nature = 44;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LocalisationParc");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/parc/LocalisationGpsInit.jsp";
                  this.menuLocalisationGps(var1);
               } else {
                  this.affichePage = "/parc/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/parc/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuparc.getCommande().equalsIgnoreCase("70000:10")) {
            this.nature = 45;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsommationParc");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/parc/ConsommationInit.jsp";
                  this.menuConsommation(var1);
               } else {
                  this.affichePage = "/parc/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/parc/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuparc.getCommande().equalsIgnoreCase("70000:11")) {
            this.nature = 46;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/parc/ParcOrInit.jsp";
                  this.menuOr(var1);
               } else {
                  this.affichePage = "/parc/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/parc/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuparc.getCommande().equalsIgnoreCase("70000:15")) {
            this.nature = 47;
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
            if (this.usersChrono != null) {
               var2 = "" + ((new Date()).getYear() + 1900);
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
               if (this.chrono != null) {
                  this.affichePage = "/parc/ManifestInit.jsp";
                  this.menuManifeste(var1);
               } else {
                  this.affichePage = "/parc/ErreurAcces.jsp";
                  this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
               }
            } else {
               this.affichePage = "/parc/ErreurAcces.jsp";
               this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
            }

            this.utilInitHibernate.closeSession();
         } else if (this.menuparc.getCommande().equalsIgnoreCase("70000:90")) {
            this.affichePage = "/parc/ImpressionParc.jsp";
            this.menuImpressionParc();
         } else if (this.menuparc.getCommande().equalsIgnoreCase("70000:99")) {
            this.affichePage = "/parc/SelectionExercicesParc.jsp";
            this.menuSelectionExercicesParc();
         }
      }

   }

   public void menuListeParc() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc");
      this.formParcListe = new FormParcListe();
      this.formParcListe.setutilInitHibernate(this.utilInitHibernate);
      this.formParcListe.setBaseLog(this.baseLog);
      this.formParcListe.setStructureLog(this.structureLog);
      this.formParcListe.setUsersLog(this.usersLog);
      this.formParcListe.InstancesDaoUtilses();
      this.formParcListe.setOptionParcs(this.optionParcs);
      this.formParcListe.setSelectedExo(this.exoselectionne);
      this.formParcListe.setLastExo(this.lastExerciceParc);
      this.formParcListe.setMesNatureItems(this.mesNatureItems);
      this.formParcListe.setMesServiceItems(this.mesServiceItems);
      this.formParcListe.setMesFamilleItems_rec(this.mesFamilleItems);
      this.formParcListe.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formParcListe.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formParcListe.initialisation(var1);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionParcs.getChargementListe() != null && !this.optionParcs.getChargementListe().isEmpty() && this.optionParcs.getChargementListe().equals("1")) {
         this.formParcListe.rechercherParc(var1);
      }

      this.utilInitHibernate.closeSession();
   }

   public void menuLocalisationGps(Session var1) throws HibernateException, NamingException, ParseException {
      this.formLocalisationGps = new FormLocalisationGps();
      this.formLocalisationGps.setutilInitHibernate(this.utilInitHibernate);
      this.formLocalisationGps.setBaseLog(this.baseLog);
      this.formLocalisationGps.setStructureLog(this.structureLog);
      this.formLocalisationGps.setUsersLog(this.usersLog);
      this.formLocalisationGps.InstancesDaoUtilses();
      this.formLocalisationGps.setNature(this.nature);
      this.formLocalisationGps.setOptionParcs(this.optionParcs);
      this.formLocalisationGps.setSelectedExo(this.exoselectionne);
      this.formLocalisationGps.setLastExo(this.lastExerciceParc);
      this.formLocalisationGps.setMesNatureItems(this.mesNatureItems);
      this.formLocalisationGps.setMesServiceItems(this.mesServiceItems);
      this.formLocalisationGps.setMesFamilleItems_rec(this.mesFamilleItems);
      this.formLocalisationGps.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formLocalisationGps.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formLocalisationGps.initialisation(var1);
      this.formLocalisationGps.setMesServiceItems(this.mesServiceItems);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionParcs.getChargementListe() != null && !this.optionParcs.getChargementListe().isEmpty() && this.optionParcs.getChargementListe().equals("1")) {
         this.formLocalisationGps.rechercherLocalisation(var1);
      }

      this.formLocalisationGps.setFormRecherche(this.formRecherche);
   }

   public void menuConsommation(Session var1) throws HibernateException, NamingException, ParseException {
      this.formConsommation = new FormConsommation();
      this.formConsommation.setutilInitHibernate(this.utilInitHibernate);
      this.formConsommation.setBaseLog(this.baseLog);
      this.formConsommation.setStructureLog(this.structureLog);
      this.formConsommation.setUsersLog(this.usersLog);
      this.formConsommation.InstancesDaoUtilses();
      this.formConsommation.setNature(this.nature);
      this.formConsommation.setOptionParcs(this.optionParcs);
      this.formConsommation.setSelectedExo(this.exoselectionne);
      this.formConsommation.setLastExo(this.lastExerciceParc);
      this.formConsommation.setMesNatureItems(this.mesNatureItems);
      this.formConsommation.setMesServiceItems(this.mesServiceItems);
      this.formConsommation.setMesFamilleItems_rec(this.mesFamilleItems);
      this.formConsommation.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formConsommation.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.formConsommation.initialisation(var1);
      this.formConsommation.setMesServiceItems(this.mesServiceItems);
      this.formConsommation.setMesActivitesItems(this.mesActivitesItems);
      this.formConsommation.setDecoupageActivite(this.decoupageActivite);
      this.formConsommation.setLaColonne1Items(this.laColonne1Items);
      this.formConsommation.setLaColonne2Items(this.laColonne2Items);
      this.formConsommation.setLaColonne3Items(this.laColonne3Items);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionParcs.getChargementListe() != null && !this.optionParcs.getChargementListe().isEmpty() && this.optionParcs.getChargementListe().equals("1")) {
         this.formConsommation.rechercherConsommation(var1);
      }

      this.formConsommation.setFormRecherche(this.formRecherche);
   }

   public void menuOr(Session var1) throws HibernateException, NamingException, ParseException {
      this.formParcOr = new FormParcOr();
      this.formParcOr.setutilInitHibernate(this.utilInitHibernate);
      this.formParcOr.setBaseLog(this.baseLog);
      this.formParcOr.setStructureLog(this.structureLog);
      this.formParcOr.setUsersLog(this.usersLog);
      this.formParcOr.InstancesDaoUtilses();
      this.formParcOr.setNature(this.nature);
      this.formParcOr.setOptionParcs(this.optionParcs);
      this.formParcOr.setSelectedExo(this.exoselectionne);
      this.formParcOr.setLastExo(this.lastExerciceParc);
      this.formParcOr.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formParcOr.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.verifBareme(var1);
      this.formParcOr.initialisation(var1);
      this.formParcOr.setHabilitation(this.habilitation);
      this.formParcOr.setVerifBareme(this.verifBareme);
      this.formParcOr.setMesServicesItems(this.mesServiceItems);
      this.formParcOr.setMesSerieUserItem(this.mesSerieUserItem);
      this.formParcOr.setMesActivitesItems(this.mesActivitesItems);
      this.formParcOr.setDecoupageActivite(this.decoupageActivite);
      this.formParcOr.setLaColonne1Items(this.laColonne1Items);
      this.formParcOr.setLaColonne2Items(this.laColonne2Items);
      this.formParcOr.setLaColonne3Items(this.laColonne3Items);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionParcs.getChargementListe() != null && !this.optionParcs.getChargementListe().isEmpty() && this.optionParcs.getChargementListe().equals("1")) {
         this.formParcOr.rechercherOr(var1);
      }

      this.formParcOr.setFormRecherche(this.formRecherche);
   }

   public void menuLocation(Session var1) throws HibernateException, NamingException, ParseException {
      this.formParcLocation = new FormParcLocation();
      this.formParcLocation.setutilInitHibernate(this.utilInitHibernate);
      this.formParcLocation.setBaseLog(this.baseLog);
      this.formParcLocation.setStructureLog(this.structureLog);
      this.formParcLocation.setUsersLog(this.usersLog);
      this.formParcLocation.InstancesDaoUtilses();
      this.formParcLocation.setNature(this.nature);
      this.formParcLocation.setOptionParcs(this.optionParcs);
      this.formParcLocation.setOptionsVentes(this.optionVentes);
      this.formParcLocation.setSelectedExo(this.exoselectionne);
      this.formParcLocation.setLastExo(this.lastExerciceParc);
      this.formParcLocation.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formParcLocation.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.recupererDevisesItem(var1);
      this.formParcLocation.initialisation(var1);
      this.formParcLocation.setHabilitation(this.habilitation);
      this.formParcLocation.setMesServicesItems(this.mesServiceItems);
      this.formParcLocation.setMesSerieUserItem(this.mesSerieUserItem);
      this.formParcLocation.setMesActivitesItems(this.mesActivitesItems);
      this.formParcLocation.setDecoupageActivite(this.decoupageActivite);
      this.formParcLocation.setLaColonne1Items(this.laColonne1Items);
      this.formParcLocation.setLaColonne2Items(this.laColonne2Items);
      this.formParcLocation.setLaColonne3Items(this.laColonne3Items);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionParcs.getChargementListe() != null && !this.optionParcs.getChargementListe().isEmpty() && this.optionParcs.getChargementListe().equals("1")) {
         this.formParcLocation.rechercherLocation(var1);
      }

      this.formParcLocation.setFormRecherche(this.formRecherche);
   }

   public void menuManifeste(Session var1) throws JDOMException, IOException, SAXException, HibernateException, NamingException, ParseException {
      this.formManifestePrc = new FormManifestePrc();
      this.formManifestePrc.setutilInitHibernate(this.utilInitHibernate);
      this.formManifestePrc.setBaseLog(this.baseLog);
      this.formManifestePrc.setStructureLog(this.structureLog);
      this.formManifestePrc.setUsersLog(this.usersLog);
      this.formManifestePrc.InstancesDaoUtilses();
      this.formManifestePrc.setNature(this.nature);
      this.formManifestePrc.setExercicesParc(this.exoselectionne);
      this.formManifestePrc.setLastExoParc(this.lastExerciceParc);
      this.formManifestePrc.setExercicesVentes(this.exoselectionneVentes);
      this.formManifestePrc.setLastExoVentes(this.lastExerciceVentes);
      this.formManifestePrc.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formManifestePrc.setOptionsVentes(this.optionVentes);
      this.formManifestePrc.setOptionParcs(this.optionParcs);
      if (this.optionParcs != null) {
         if (this.optionParcs == null || this.optionParcs.getType() == null || this.optionParcs.getType().isEmpty() || !this.optionParcs.getType().equals("0") && !this.optionParcs.getType().equals("1")) {
            this.formManifestePrc.setVar_option_parc(100);
         } else {
            this.formManifestePrc.setVar_option_parc(Integer.parseInt(this.optionParcs.getType()));
         }
      } else {
         this.formManifestePrc.setVar_option_parc(100);
      }

      this.chargerMesCodesTaxeVnt(var1);
      this.formManifestePrc.setMesTaxesVentesItems(this.mesTaxesItems);
      this.formManifestePrc.setVar_timbre(this.var_timbre);
      this.formManifestePrc.setVar_tc_type(this.var_tc_type);
      this.formManifestePrc.setVar_tc_libelle(this.var_tc_libelle);
      this.formManifestePrc.setVar_tc_taux(this.var_tc_taux);
      this.formManifestePrc.configVentes(var1);
      this.formManifestePrc.accesResteintUser();
      this.formManifestePrc.accesResteintGroupe();
      this.recupererLesItemsDoc(var1);
      this.verifBareme(var1);
      this.formManifestePrc.chargerCommerciauxResponsable(var1);
      this.formManifestePrc.setHabilitation(this.habilitation);
      this.formManifestePrc.setVerifBareme(this.verifBareme);
      this.formManifestePrc.setFormRecherche(this.formRecherche);
      this.formManifestePrc.setMesSerieUserItem(this.mesSerieUserItem);
      this.formManifestePrc.setDecoupageActivite(this.decoupageActivite);
      this.formManifestePrc.setLaColonne1Items(this.laColonne1Items);
      this.formManifestePrc.setLaColonne2Items(this.laColonne2Items);
      this.formManifestePrc.setLaColonne3Items(this.laColonne3Items);
      this.formManifestePrc.setTypeVente(this.typeVente);
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, Integer.parseInt(this.optionVentes.getPaiementAVOIR()));
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionParcs.getChargementListe() != null && !this.optionParcs.getChargementListe().isEmpty() && this.optionParcs.getChargementListe().equals("1") && this.mesSerieUserItem.size() != 0) {
         this.formManifestePrc.setInpSerie(((SelectItem)this.mesSerieUserItem.get(0)).getValue().toString());
         this.formManifestePrc.executerRequete(var1);
      }

   }

   public void menuImpressionParc() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc");
      this.formImpressionParc = new FormImpressionParc();
      this.formImpressionParc.setutilInitHibernate(this.utilInitHibernate);
      this.formImpressionParc.setBaseLog(this.baseLog);
      this.formImpressionParc.setStructureLog(this.structureLog);
      this.formImpressionParc.setUsersLog(this.usersLog);
      this.formImpressionParc.InstancesDaoUtilses();
      this.formImpressionParc.setExoSelectionne(this.exoselectionne);
      this.formImpressionParc.setOptionParcs(this.optionParcs);
      this.formImpressionParc.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionParc.chargerLesRepImpParc(var1);
      this.formImpressionParc.calculeAnalytique();
      this.recupererLesItemsImpression(var1);
      this.formImpressionParc.setLaColonne1Items(this.laColonne1Items);
      this.formImpressionParc.setLaColonne2Items(this.laColonne2Items);
      this.formImpressionParc.setLaColonne3Items(this.laColonne3Items);
      this.formImpressionParc.initImpression();
      this.formImpressionParc.chargerPeriodes();
      this.utilInitHibernate.closeSession();
      this.mesEtatsItems = this.etatDocument.calculelisteEtatsItems(this.nature, 0);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
   }

   public void menuSelectionExercicesParc() throws IOException, JDOMException, NamingException {
      this.formExercicesParcs = new FormExercicesParcs();
      this.formExercicesParcs.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesParcs.setBaseLog(this.baseLog);
      this.formExercicesParcs.setStructureLog(this.structureLog);
      this.formExercicesParcs.setUsersLog(this.usersLog);
      this.formExercicesParcs.InstancesDaoUtilses();
      this.leIdExo = this.exoselectionne.getExeprcId();
      this.formExercicesParcs.setLesexercicesParc(this.formExercicesParcs.recupererLesexercices((Session)null));
   }

   public void recupererTousLesItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererNature();
      this.recupererOptionsParcs();
      this.recupererModelesAutorises();
      this.recupererServices(var1);
      this.recupererActivites(var1);
      this.recupererFamilles(var1);
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void recupererLesItemsImpression(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
   }

   public void recupererLesItemsDoc(Session var1) throws HibernateException, NamingException {
      this.recupererSerieUserItem(var1);
      this.recupererModeleFicheProduit();
      this.recupererModeleListeProduit();
      this.recupererHabilitation(var1);
      this.recupererServiceItem(var1);
   }

   public void recupererNature() {
      this.mesNatureItems = new ArrayList();
      LectureNatureParc var1 = new LectureNatureParc(this.baseLog);
      this.mesNatureItems = var1.getMesNatureParcItems();
   }

   public void recupererOptionsParcs() {
      this.optionParcs = new OptionParcs();
      LireLesoptionsParcs var1 = new LireLesoptionsParcs();
      var1.setStrId(this.structureLog.getStrid());
      this.optionParcs = var1.lancer();
      this.optionVentes = new OptionVentes();
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      this.optionVentes = var2.lancer();
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

   }

   public void chargerMesCodesTaxeVnt(Session var1) throws HibernateException, NamingException {
      this.mesTaxesItems = new ArrayList();
      this.mesTaxesItems.add(new SelectItem(0, ""));
      TaxesVentesDao var2 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectActifTaxes(this.exoselectionneVentes.getExevteId(), var1);
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

   public void recupererHabilitation(Session var1) throws HibernateException, NamingException {
      this.habilitation = new Habilitation();
      if (this.usersLog.getUsrSansHabilitation() == 0 && this.nature != 0) {
         HabilitationDao var2 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
         this.habilitation = var2.existenceHabilitation(this.nature, var1);
      } else {
         this.habilitation = null;
      }

   }

   public void recupererServices(Session var1) throws HibernateException, NamingException {
      this.mesServiceItems = new ArrayList();
      ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.mesServiceItems = var2.chargerLesServicesItems(1, false, var1);
   }

   public void recupererDevisesItem(Session var1) throws HibernateException, NamingException {
      this.mesdevisesItem = new ArrayList();
      DeviseDao var2 = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.mesdevisesItem = var2.chargerLesDevisesUtiliseesItem(this.structureLog, var1);
   }

   public void recupererActivites(Session var1) throws HibernateException, NamingException {
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

   public void recupererFamilles(Session var1) throws HibernateException, NamingException {
      this.mesFamilleItems = new ArrayList();
      FamillesParc1Dao var2 = new FamillesParc1Dao(this.baseLog, this.utilInitHibernate);
      this.mesFamilleItems = var2.chargerLesFamilles(var1);
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
         ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
         this.mesServicesItems = var2.chargerLesServicesItems(1, false, var1);
      }

   }

   public List recupererModeleFicheProduit() {
      String var1 = "";
      if (this.nature == 40) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "transport_personnel" + File.separator;
      } else if (this.nature == 41) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "transport_materiel" + File.separator;
      } else if (this.nature == 42) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "travaux_public" + File.separator;
      } else if (this.nature == 43) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "location" + File.separator;
      } else if (this.nature == 44) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "localisation" + File.separator;
      } else if (this.nature == 45) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "consommation" + File.separator;
      } else if (this.nature == 46) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "or" + File.separator;
      } else if (this.nature == 47) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "manifest" + File.separator;
      } else {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "parc" + File.separator;
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

      return this.documentImpressionItems;
   }

   public List recupererModeleLettreVoiture() {
      String var1 = "";
      if (this.nature == 47) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "lettre_voiture" + File.separator;
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

      return this.documentImpressionItems;
   }

   public void recupererModeleListeProduit() {
      String var1 = "";
      if (this.nature == 40) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "transport_personnel" + File.separator;
      } else if (this.nature == 41) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "transport_materiel" + File.separator;
      } else if (this.nature == 42) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "travaux_public" + File.separator;
      } else if (this.nature == 43) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "location" + File.separator;
      } else if (this.nature == 44) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "localisation" + File.separator;
      } else if (this.nature == 45) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "consommation" + File.separator;
      } else if (this.nature == 46) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "or" + File.separator;
      } else if (this.nature == 47) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "manifest" + File.separator;
      } else {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "parc" + File.separator;
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

   public void ouvrirImportation() {
      this.listFiles = new ArrayList();
      this.var_choix_importation = 0;
      this.uploadsAvailable = 1;
      this.showModalPanelImportation = true;
   }

   public void fermerImportation() {
      this.showModalPanelImportation = false;
   }

   public void listener(UploadEvent var1) throws NamingException, HibernateException, ParseException {
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

   public void importationFichier() throws NamingException, HibernateException, ParseException {
      try {
         ArrayList var1 = new ArrayList();
         if (this.listFiles.size() != 0) {
            for(int var2 = 0; var2 < this.listFiles.size(); ++var2) {
               this.fileCtrl = (FileCtrl)this.listFiles.get(var2);
               File var3 = new File(this.fileCtrl.getChemin());
               if (var3.exists()) {
                  FileReader var4 = new FileReader(var3);
                  BufferedReader var5 = new BufferedReader(var4);

                  for(String var6 = var5.readLine(); var6 != null; var6 = var5.readLine()) {
                     if (var6.contains("\"")) {
                        char[] var7 = var6.toCharArray();
                        String var8 = "";

                        for(int var9 = 0; var9 < var7.length; ++var9) {
                           if (var7[var9] != '"') {
                              var8 = var8 + var7[var9];
                           }
                        }

                        var6 = var8;
                     }

                     var1.add(var6);
                  }

                  var5.close();
                  var4.close();
                  var3.delete();
               }
            }
         }

         if (var1.size() != 0) {
            this.formLocalisationGps.traitementImortation(var1);
         }
      } catch (IOException var10) {
         var10.printStackTrace();
      }

   }

   public void importFtp() {
   }

   public FormExercicesParcs getFormExercicesParcs() {
      return this.formExercicesParcs;
   }

   public void setFormExercicesParcs(FormExercicesParcs var1) {
      this.formExercicesParcs = var1;
   }

   public ExercicesParc getExoselectionne() {
      return this.exoselectionne;
   }

   public void setExoselectionne(ExercicesParc var1) {
      this.exoselectionne = var1;
   }

   public ExercicesVentes getExoselectionneVentes() {
      return this.exoselectionneVentes;
   }

   public void setExoselectionneVentes(ExercicesVentes var1) {
      this.exoselectionneVentes = var1;
   }

   public ExercicesParc getLastExerciceParc() {
      return this.lastExerciceParc;
   }

   public void setLastExerciceParc(ExercicesParc var1) {
      this.lastExerciceParc = var1;
   }

   public ExercicesVentes getLastExerciceVentes() {
      return this.lastExerciceVentes;
   }

   public void setLastExerciceVentes(ExercicesVentes var1) {
      this.lastExerciceVentes = var1;
   }

   public String getAffichePage() {
      return this.affichePage;
   }

   public void setAffichePage(String var1) {
      this.affichePage = var1;
   }

   public LectureModulesOnglets getLesOnglets() {
      return this.lesOnglets;
   }

   public void setLesOnglets(LectureModulesOnglets var1) {
      this.lesOnglets = var1;
   }

   public MenudroitParcsCtrl getMenudroitParcCtrl() {
      return this.menudroitParcCtrl;
   }

   public void setMenudroitParcCtrl(MenudroitParcsCtrl var1) {
      this.menudroitParcCtrl = var1;
   }

   public ObjetLigneMenu getMenuparc() {
      return this.menuparc;
   }

   public void setMenuparc(ObjetLigneMenu var1) {
      this.menuparc = var1;
   }

   public FormParcListe getFormParcListe() {
      return this.formParcListe;
   }

   public void setFormParcListe(FormParcListe var1) {
      this.formParcListe = var1;
   }

   public long getLeIdExo() {
      return this.leIdExo;
   }

   public void setLeIdExo(long var1) {
      this.leIdExo = var1;
   }

   public long getLeIdExoVentes() {
      return this.leIdExoVentes;
   }

   public void setLeIdExoVentes(long var1) {
      this.leIdExoVentes = var1;
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

   public FormParcOr getFormParcOr() {
      return this.formParcOr;
   }

   public void setFormParcOr(FormParcOr var1) {
      this.formParcOr = var1;
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

   public FormConsommation getFormConsommation() {
      return this.formConsommation;
   }

   public void setFormConsommation(FormConsommation var1) {
      this.formConsommation = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public FormImpressionParc getFormImpressionParc() {
      return this.formImpressionParc;
   }

   public void setFormImpressionParc(FormImpressionParc var1) {
      this.formImpressionParc = var1;
   }

   public FormLocalisationGps getFormLocalisationGps() {
      return this.formLocalisationGps;
   }

   public void setFormLocalisationGps(FormLocalisationGps var1) {
      this.formLocalisationGps = var1;
   }

   public int getUploadsAvailable() {
      return this.uploadsAvailable;
   }

   public void setUploadsAvailable(int var1) {
      this.uploadsAvailable = var1;
   }

   public boolean isShowModalPanelImportation() {
      return this.showModalPanelImportation;
   }

   public void setShowModalPanelImportation(boolean var1) {
      this.showModalPanelImportation = var1;
   }

   public int getVar_choix_importation() {
      return this.var_choix_importation;
   }

   public void setVar_choix_importation(int var1) {
      this.var_choix_importation = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
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

   public FormManifestePrc getFormManifestePrc() {
      return this.formManifestePrc;
   }

   public void setFormManifestePrc(FormManifestePrc var1) {
      this.formManifestePrc = var1;
   }

   public List getMesServiceItems() {
      return this.mesServiceItems;
   }

   public void setMesServiceItems(List var1) {
      this.mesServiceItems = var1;
   }

   public long getVar_memo_id_master() {
      return this.var_memo_id_master;
   }

   public void setVar_memo_id_master(long var1) {
      this.var_memo_id_master = var1;
   }

   public FormParcLocation getFormParcLocation() {
      return this.formParcLocation;
   }

   public void setFormParcLocation(FormParcLocation var1) {
      this.formParcLocation = var1;
   }

   public List getMesdevisesItem() {
      return this.mesdevisesItem;
   }

   public void setMesdevisesItem(List var1) {
      this.mesdevisesItem = var1;
   }
}
