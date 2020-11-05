package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.office.FormBrowser;
import com.epegase.forms.office.FormCertificationDocument;
import com.epegase.forms.office.FormImpressionCommerciale;
import com.epegase.forms.office.FormMessagerie;
import com.epegase.forms.office.FormParapheur;
import com.epegase.forms.office.FormPlanning;
import com.epegase.forms.office.FormReunion;
import com.epegase.forms.office.FormSms;
import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BalDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitOfficeCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LireLesoptionsTiers;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionConfigListe;
import com.epegase.systeme.xml.OptionTiers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;
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

public class FormBakingBeanOffice implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private int typePlateforme;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private MenudroitOfficeCtrl menudroitOfficeCtrl;
   private ObjetLigneMenu menuoffice;
   private LectureModulesOnglets lesOnglets;
   private List mesPeriodesItems = new ArrayList();
   private EtatDocument etatDocument = new EtatDocument();
   private int nature;
   private Habilitation habilitation;
   private FormPlanning formOffice;
   private FormParapheur formParapheur;
   private FormMessagerie formMessagerie;
   private FormReunion formReunion;
   private FormPlanning formPlanning;
   private FormBrowser formBrowser;
   private FormSms formSms;
   private FormCertificationDocument formCertificationDocument;
   private UsersChronoDao usersChronoDao;
   private List mesServicesItems;
   private List mesActivitesItems;
   private List mesBalEmetteursItems;
   private LireLesoptionsTiers lireLesOptionsTiers;
   private LectureFamillesClients lesClients;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private List mesUsersItem;
   private List mesModelesItem;
   private List lesUsers;
   private OptionTiers optionTiers;
   private FormImpressionCommerciale formImpressionCommerciale;
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public void menuGaucheOffice() throws JDOMException, IOException {
      if (this.menudroitOfficeCtrl == null) {
         this.menudroitOfficeCtrl = new MenudroitOfficeCtrl();
         this.menudroitOfficeCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitOfficeCtrl.chargerMenuOfficeXml(this.usersLog.getUsrCollaboration());
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("10000", this.usersLog.getUsrCollaboration());
   }

   public void razMemoire() {
      this.formBrowser = null;
      this.formImpressionCommerciale = null;
      this.formMessagerie = null;
      this.formParapheur = null;
      this.formPlanning = null;
      this.formRecherche = null;
      this.formSms = null;
   }

   public void gestionOffice() throws IOException, HibernateException, NamingException, JDOMException, ParseException {
      this.menuoffice = new ObjetLigneMenu();
      if (this.menudroitOfficeCtrl.getDataModelMenudroitOfficeXmlList().isRowAvailable()) {
         this.menuoffice = (ObjetLigneMenu)this.menudroitOfficeCtrl.getDataModelMenudroitOfficeXmlList().getRowData();
         if (this.menuoffice.getLibelle_FR() != null && !this.menuoffice.getLibelle_FR().isEmpty()) {
            this.aiguillageOffice();
         }
      }

   }

   public void gestionOfficeFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.menuoffice = var1;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGaucheOffice();
      }

      this.aiguillageOffice();
   }

   public void aiguillageOffice() throws IOException, HibernateException, NamingException, JDOMException, ParseException {
      this.razMemoire();
      if (this.menuoffice.getCommande().equalsIgnoreCase("20000:01")) {
         this.affichePage = "/office/Browser.jsp";
         this.nature = 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Office");
         this.menuBrowser(var1, this.urlExplorateur, this.typePlateforme);
         this.utilInitHibernate.closeSession();
      } else {
         boolean var2;
         if (this.menuoffice.getCommande().equalsIgnoreCase("20000:02")) {
            this.nature = 2;
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, this.nature, (Session)null);
            if (var2) {
               this.affichePage = "/office/MessagerieInit.jsp";
               this.menuMessagerie();
            } else {
               this.affichePage = "/office/ErreurAcces.jsp";
            }
         } else if (this.menuoffice.getCommande().equalsIgnoreCase("20000:08")) {
            this.nature = 122;
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, this.nature, (Session)null);
            if (var2) {
               this.affichePage = "/office/SmsListe.jsp";
               this.menuSms();
            } else {
               this.affichePage = "/office/ErreurAcces.jsp";
            }
         } else if (this.menuoffice.getCommande().equalsIgnoreCase("20000:11")) {
            this.nature = 124;
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, this.nature, (Session)null);
            if (var2) {
               this.affichePage = "/office/CertificationsListe.jsp";
               this.menuCertificationDocument();
            } else {
               this.affichePage = "/office/ErreurAcces.jsp";
            }
         } else if (this.menuoffice.getCommande().equalsIgnoreCase("20000:03")) {
            this.affichePage = "/office/PlanningMono.jsp";
            this.nature = 3;
            this.menuPlanning();
         } else if (this.menuoffice.getCommande().equalsIgnoreCase("20000:06")) {
            this.affichePage = "/office/PlanningMulti.jsp";
            this.nature = 6;
            this.menuMultiPlanning();
         } else if (this.menuoffice.getCommande().equalsIgnoreCase("20000:04")) {
            this.affichePage = "/office/Parapheur.jsp";
            this.nature = 4;
            this.menuParapheur();
         } else if (this.menuoffice.getCommande().equalsIgnoreCase("20000:05")) {
            this.nature = 5;
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, this.nature, (Session)null);
            if (var2) {
               this.affichePage = "/office/ReunionInterneInit.jsp";
               this.menuReunionInterne();
            } else {
               this.affichePage = "/office/ErreurAcces.jsp";
            }
         } else if (this.menuoffice.getCommande().equalsIgnoreCase("20000:07")) {
            this.nature = 120;
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, this.nature, (Session)null);
            if (var2) {
               this.affichePage = "/office/ReunionTiersInit.jsp";
               this.menuReunionTiers();
            } else {
               this.affichePage = "/office/ErreurAcces.jsp";
            }
         } else if (this.menuoffice.getCommande().equalsIgnoreCase("20000:09")) {
            this.nature = 121;
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, this.nature, (Session)null);
            if (var2) {
               this.affichePage = "/office/ReunionCommercialeInit.jsp";
               this.menuReunionCommerciale();
            } else {
               this.affichePage = "/office/ErreurAcces.jsp";
            }
         } else if (this.menuoffice.getCommande().equalsIgnoreCase("20000:10")) {
            this.nature = 123;
            var2 = this.usersChronoDao.existByUserNat(this.usersLog, this.nature, (Session)null);
            if (var2) {
               this.affichePage = "/office/Visioconference.jsp";
               this.menuVisioconference();
            } else {
               this.affichePage = "/office/ErreurAcces.jsp";
            }
         } else if (this.menuoffice.getCommande().equalsIgnoreCase("20000:90")) {
            this.nature = 100;
            this.affichePage = "/office/ImpressionCommerciale.jsp";
            this.menuImpressionCommerciale();
         }
      }

   }

   public void menuBrowser(Session var1, String var2, int var3) throws UnknownHostException, HibernateException, NamingException, IOException, ParseException {
      this.formBrowser = new FormBrowser();
      this.formBrowser.setutilInitHibernate(this.utilInitHibernate);
      this.formBrowser.setBaseLog(this.baseLog);
      this.formBrowser.setStructureLog(this.structureLog);
      this.formBrowser.setUsersLog(this.usersLog);
      this.formBrowser.InstancesDaoUtilses();
      this.formBrowser.accueil(var1, var2, var3);
      this.formBrowser.setTypeVente(this.typeVente);
   }

   public void menuMessagerie() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
      this.formMessagerie = new FormMessagerie();
      this.formMessagerie.setutilInitHibernate(this.utilInitHibernate);
      this.formMessagerie.setBaseLog(this.baseLog);
      this.formMessagerie.setStructureLog(this.structureLog);
      this.formMessagerie.setUsersLog(this.usersLog);
      this.formMessagerie.InstancesDaoUtilses();
      this.formMessagerie.setTiers((Tiers)null);
      this.formMessagerie.setPatients((Patients)null);
      this.formMessagerie.setSalaries((Salaries)null);
      this.formMessagerie.setUrlExplorateur(this.urlExplorateur);
      this.formMessagerie.initMsg(var1);
      this.formMessagerie.setSens(99);
      this.formMessagerie.setTypeVente(this.typeVente);
      this.formMessagerie.calculeActivitesServicesUsed(var1);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionTiers.getChargementListe() != null && !this.optionTiers.getChargementListe().isEmpty() && this.optionTiers.getChargementListe().equals("1")) {
         this.formMessagerie.executerRequete(var1);
      }

      this.utilInitHibernate.closeSession();
      this.formMessagerie.menuGroupeListesociete();
   }

   public void menuSms() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Sms");
      this.formSms = new FormSms();
      this.formSms.setutilInitHibernate(this.utilInitHibernate);
      this.formSms.setBaseLog(this.baseLog);
      this.formSms.setStructureLog(this.structureLog);
      this.formSms.setUsersLog(this.usersLog);
      this.formSms.InstancesDaoUtilses();
      this.formSms.setNature(this.nature);
      this.formSms.setOptionTiers(this.optionTiers);
      this.formSms.initPage(var1);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionTiers.getChargementListe() != null && !this.optionTiers.getChargementListe().isEmpty() && this.optionTiers.getChargementListe().equals("1")) {
         this.formSms.chargerLesSms(var1);
      }

      this.utilInitHibernate.closeSession();
   }

   public void menuCertificationDocument() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CertificationDocument");
      this.formCertificationDocument = new FormCertificationDocument();
      this.formCertificationDocument.setutilInitHibernate(this.utilInitHibernate);
      this.formCertificationDocument.setBaseLog(this.baseLog);
      this.formCertificationDocument.setStructureLog(this.structureLog);
      this.formCertificationDocument.setUsersLog(this.usersLog);
      this.formCertificationDocument.InstancesDaoUtilses();
      this.formCertificationDocument.setNature(this.nature);
      this.formCertificationDocument.setOptionTiers(this.optionTiers);
      this.formCertificationDocument.initPage(var1);
      this.mesPeriodesItems = this.etatDocument.calculelistePeriodeItems();
      if (this.optionTiers.getChargementListe() != null && !this.optionTiers.getChargementListe().isEmpty() && this.optionTiers.getChargementListe().equals("1")) {
         this.formCertificationDocument.chargerLesCertificationDocument(var1);
      }

      this.utilInitHibernate.closeSession();
   }

   public void menuPlanning() throws IOException, HibernateException, NamingException, JDOMException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
      this.formPlanning = new FormPlanning();
      this.formPlanning.setutilInitHibernate(this.utilInitHibernate);
      this.formPlanning.setBaseLog(this.baseLog);
      this.formPlanning.setStructureLog(this.structureLog);
      this.formPlanning.setUsersLog(this.usersLog);
      this.formPlanning.InstancesDaoUtilses();
      this.recupererLesItemsDoc(var1);
      this.formPlanning.initRdv(var1);
      this.formPlanning.setOptionTiers(this.optionTiers);
      this.formPlanning.setTypeVente(this.typeVente);
      if (this.optionTiers.getChargementListe() != null && !this.optionTiers.getChargementListe().isEmpty() && this.optionTiers.getChargementListe().equals("1")) {
         this.formPlanning.chargerLesRdvByMois(this.usersLog, var1);
      }

      this.utilInitHibernate.closeSession();
      this.formPlanning.traitementAndroide();
   }

   public void menuParapheur() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parapheur");
      this.formParapheur = new FormParapheur();
      this.formParapheur.setutilInitHibernate(this.utilInitHibernate);
      this.formParapheur.setBaseLog(this.baseLog);
      this.formParapheur.setStructureLog(this.structureLog);
      this.formParapheur.setUsersLog(this.usersLog);
      this.formParapheur.InstancesDaoUtilses();
      this.lesClients = new LectureFamillesClients();
      this.lesClients.setStrId(this.structureLog.getStrid());
      this.lesClients.setStructureLog(this.structureLog);
      this.formParapheur.setMesFamillesClients(this.lesClients.chargerMesFamillesClientItems());
      this.formParapheur.setEtatRqt(0);
      this.recupererLesItemsDoc(var1);
      this.formParapheur.lesParapheurs(var1);
      this.formParapheur.lesIndisponibles(var1);
      this.formParapheur.initDate();
      this.utilInitHibernate.closeSession();
   }

   public void menuReunionInterne() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
      this.formReunion = new FormReunion();
      this.formReunion.setutilInitHibernate(this.utilInitHibernate);
      this.formReunion.setBaseLog(this.baseLog);
      this.formReunion.setStructureLog(this.structureLog);
      this.formReunion.setUsersLog(this.usersLog);
      this.formReunion.InstancesDaoUtilses();
      this.formReunion.setNature(this.nature);
      this.recupererLesItemsDoc(var1);
      this.formReunion.setHabilitation(this.habilitation);
      this.formReunion.initPage();
      if (this.optionTiers.getChargementListe() != null && !this.optionTiers.getChargementListe().isEmpty() && this.optionTiers.getChargementListe().equals("1")) {
         this.formReunion.chargerLesReunions(var1);
      }

      this.utilInitHibernate.closeSession();
   }

   public void menuReunionTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
      this.formReunion = new FormReunion();
      this.formReunion.setutilInitHibernate(this.utilInitHibernate);
      this.formReunion.setBaseLog(this.baseLog);
      this.formReunion.setStructureLog(this.structureLog);
      this.formReunion.setUsersLog(this.usersLog);
      this.formReunion.InstancesDaoUtilses();
      this.formReunion.setNature(this.nature);
      this.recupererLesItemsDoc(var1);
      this.formReunion.setHabilitation(this.habilitation);
      this.formReunion.initPage();
      if (this.optionTiers.getChargementListe() != null && !this.optionTiers.getChargementListe().isEmpty() && this.optionTiers.getChargementListe().equals("1")) {
         this.formReunion.chargerLesReunions(var1);
      }

      this.utilInitHibernate.closeSession();
   }

   public void menuReunionCommerciale() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReunionEntete");
      this.formReunion = new FormReunion();
      this.formReunion.setutilInitHibernate(this.utilInitHibernate);
      this.formReunion.setBaseLog(this.baseLog);
      this.formReunion.setStructureLog(this.structureLog);
      this.formReunion.setUsersLog(this.usersLog);
      this.formReunion.InstancesDaoUtilses();
      this.formReunion.setNature(this.nature);
      this.recupererLesItemsDoc(var1);
      this.formReunion.setHabilitation(this.habilitation);
      this.formReunion.initPage();
      if (this.optionTiers.getChargementListe() != null && !this.optionTiers.getChargementListe().isEmpty() && this.optionTiers.getChargementListe().equals("1")) {
         this.formReunion.chargerLesReunions(var1);
      }

      this.utilInitHibernate.closeSession();
   }

   public void menuVisioconference() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
   }

   public void menuMultiPlanning() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
      this.formPlanning = new FormPlanning();
      this.formPlanning.setutilInitHibernate(this.utilInitHibernate);
      this.formPlanning.setBaseLog(this.baseLog);
      this.formPlanning.setStructureLog(this.structureLog);
      this.formPlanning.setUsersLog(this.usersLog);
      this.formPlanning.InstancesDaoUtilses();
      this.recupererLesItemsDoc(var1);
      this.formPlanning.initRdvMulti(var1);
      this.formPlanning.setOptionTiers(this.optionTiers);
      this.utilInitHibernate.closeSession();
      this.formPlanning.traitementAndroide();
   }

   public void menuImpressionCommerciale() throws HibernateException, NamingException, ParseException, JDOMException, IOException {
      this.formImpressionCommerciale = new FormImpressionCommerciale();
      this.formImpressionCommerciale.setUtilInitHibernate(this.utilInitHibernate);
      this.formImpressionCommerciale.setBaseLog(this.baseLog);
      this.formImpressionCommerciale.setStructureLog(this.structureLog);
      this.formImpressionCommerciale.setUsersLog(this.usersLog);
      this.formImpressionCommerciale.InstancesDaoUtilses();
      this.formImpressionCommerciale.setOptionTiers(this.optionTiers);
      this.formImpressionCommerciale.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionCommerciale.initImpression();
      this.formImpressionCommerciale.chargerPeriodes();
   }

   public void recupererTousLesItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererOptionsOffice();
      this.recupererModelesAutorises();
      this.recupererServiceItem(var1);
      this.recupererActiviteItem(var1);
      this.recupererModeleItem(var1);
      this.recupererBalEmetteurItem(var1);
      this.recupererUsersItem(var1);
   }

   public void recupererLesItemsDoc(Session var1) throws JDOMException, IOException, ParseException, HibernateException, NamingException {
      this.recupererModeleDocument();
      this.recupererModeleListe();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
      this.recupererHabilitation(var1);
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

   public void recupererOptionsOffice() {
      this.optionTiers = new OptionTiers();
      LireLesoptionsTiers var1 = new LireLesoptionsTiers();
      var1.setStrId(this.structureLog.getStrid());
      this.optionTiers = var1.lancer();
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

   }

   public void recupererServiceItem(Session var1) throws HibernateException, NamingException {
      this.mesServicesItems = new ArrayList();
      ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.mesServicesItems = var2.chargerLesServicesItems(0, false, var1);
   }

   public void recupererActiviteItem(Session var1) throws HibernateException, NamingException {
      this.mesActivitesItems = new ArrayList();
      ActivitesDao var2 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.mesActivitesItems = var2.chargerLesActivites(var1);
   }

   public void recupererModeleItem(Session var1) throws HibernateException, NamingException {
      this.mesModelesItem = new ArrayList();
      ModelesCourriersDao var2 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.mesModelesItem = var2.chargerLesModeles(10, "0", var1);
   }

   public void recupererBalEmetteurItem(Session var1) throws HibernateException, NamingException {
      this.mesBalEmetteursItems = new ArrayList();
      BalDao var2 = new BalDao(this.baseLog, this.utilInitHibernate);
      ArrayList var3 = new ArrayList();
      new ArrayList();
      new ArrayList();
      new ArrayList();
      List var4 = var2.selectBalLogActif(this.structureLog.getStrid(), var1);
      List var5 = var2.selectBalGrpLogActif(this.usersLog.getUsrCollaboration(), var1);
      List var6 = var2.selectBalUserLogActif(this.usersLog.getUsrid(), var1);
      int var7;
      if (var4.size() != 0) {
         for(var7 = 0; var7 < var4.size(); ++var7) {
            var3.add(var4.get(var7));
         }
      }

      if (var5.size() != 0) {
         for(var7 = 0; var7 < var5.size(); ++var7) {
            var3.add(var5.get(var7));
         }
      }

      if (var6.size() != 0) {
         for(var7 = 0; var7 < var6.size(); ++var7) {
            var3.add(var6.get(var7));
         }
      }

      if (var3.size() != 0) {
         for(var7 = 0; var7 < var3.size(); ++var7) {
            new Bal();
            Bal var8 = (Bal)var3.get(var7);
            this.mesBalEmetteursItems.add(new SelectItem(var8.getBaladressemail()));
         }
      }

   }

   public void recupererUsersItem(Session var1) throws HibernateException, NamingException {
      this.lesUsers = new ArrayList();
      this.mesUsersItem = new ArrayList();
      UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.lesUsers = var2.chargerLesUsers(var1);
      this.mesUsersItem = var2.chargerLesUsersItem(var1);
   }

   public void recupererModeleDocument() {
      String var1 = "";
      if (this.nature == 1) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "document" + File.separator;
      } else if (this.nature == 2) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "messagerie" + File.separator;
      } else if (this.nature == 3) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "planning" + File.separator;
      } else if (this.nature == 4) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "parapheur" + File.separator;
      } else if (this.nature == 6) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "multiPlanning" + File.separator;
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
      if (this.nature == 1) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "document" + File.separator;
      } else if (this.nature == 2) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "messagerie" + File.separator;
      } else if (this.nature == 3) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "planning" + File.separator;
      } else if (this.nature == 4) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "parapheur" + File.separator;
      } else if (this.nature == 6) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "liste" + File.separator + "multiPlanning" + File.separator;
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

   public FormPlanning getFormOffice() {
      return this.formOffice;
   }

   public void setFormOffice(FormPlanning var1) {
      this.formOffice = var1;
   }

   public FormParapheur getFormParapheur() {
      return this.formParapheur;
   }

   public void setFormParapheur(FormParapheur var1) {
      this.formParapheur = var1;
   }

   public FormMessagerie getFormMessagerie() {
      return this.formMessagerie;
   }

   public void setFormMessagerie(FormMessagerie var1) {
      this.formMessagerie = var1;
   }

   public MenudroitOfficeCtrl getMenudroitOfficeCtrl() {
      return this.menudroitOfficeCtrl;
   }

   public void setMenudroitOfficeCtrl(MenudroitOfficeCtrl var1) {
      this.menudroitOfficeCtrl = var1;
   }

   public FormReunion getFormReunion() {
      return this.formReunion;
   }

   public void setFormReunion(FormReunion var1) {
      this.formReunion = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public ObjetLigneMenu getMenuoffice() {
      return this.menuoffice;
   }

   public void setMenuoffice(ObjetLigneMenu var1) {
      this.menuoffice = var1;
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

   public List getMesUsersItem() {
      return this.mesUsersItem;
   }

   public void setMesUsersItem(List var1) {
      this.mesUsersItem = var1;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
   }

   public List getMesBalEmetteursItems() {
      return this.mesBalEmetteursItems;
   }

   public void setMesBalEmetteursItems(List var1) {
      this.mesBalEmetteursItems = var1;
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

   public FormPlanning getFormPlanning() {
      return this.formPlanning;
   }

   public void setFormPlanning(FormPlanning var1) {
      this.formPlanning = var1;
   }

   public List getMesModelesItem() {
      return this.mesModelesItem;
   }

   public void setMesModelesItem(List var1) {
      this.mesModelesItem = var1;
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

   public FormImpressionCommerciale getFormImpressionCommerciale() {
      return this.formImpressionCommerciale;
   }

   public void setFormImpressionCommerciale(FormImpressionCommerciale var1) {
      this.formImpressionCommerciale = var1;
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

   public FormBrowser getFormBrowser() {
      return this.formBrowser;
   }

   public void setFormBrowser(FormBrowser var1) {
      this.formBrowser = var1;
   }

   public int getTypePlateforme() {
      return this.typePlateforme;
   }

   public void setTypePlateforme(int var1) {
      this.typePlateforme = var1;
   }

   public FormSms getFormSms() {
      return this.formSms;
   }

   public void setFormSms(FormSms var1) {
      this.formSms = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public FormCertificationDocument getFormCertificationDocument() {
      return this.formCertificationDocument;
   }

   public void setFormCertificationDocument(FormCertificationDocument var1) {
      this.formCertificationDocument = var1;
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
}
