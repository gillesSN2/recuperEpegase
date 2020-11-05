package com.epegase.forms.office;

import com.epegase.systeme.classe.Android;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.EcrituresNotes;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.RdvSemaine;
import com.epegase.systeme.dao.AndroidDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.EcrituresNotesDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.RdvDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureElementRdv;
import com.epegase.systeme.xml.LectureNatureRdv;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionTiers;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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

public class FormPlanning implements Serializable {
   private int typeVente;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int modeRdv;
   private boolean compteRendu = false;
   private OptionTiers optionTiers;
   private String pageIndex;
   private Rdv rdv = new Rdv();
   private RdvSemaine rdvSemaine = new RdvSemaine();
   private RdvDao rdvDao;
   private List listRdvMois = new ArrayList();
   private List listRdvSemaine = new ArrayList();
   private List listRdvJour = new ArrayList();
   private List listRdv = new ArrayList();
   private transient DataModel datamodelRdv = new ListDataModel();
   private transient DataModel datamodelLesRdvParJour = new ListDataModel();
   private transient DataModel datamodelLesRdvParSemaine = new ListDataModel();
   private transient DataModel datamodelLesRdvParMois = new ListDataModel();
   private Date parMois = new Date();
   private Date parSemaine = new Date();
   private Date parJour = new Date();
   private Date jourDeb = new Date();
   private Date jourFin = new Date();
   private int valNatMois = 99;
   private int valNatSemaine = 99;
   private int valNatJour = 99;
   private int valNatListe = 99;
   private String lienRdv;
   private boolean afficheRdv = false;
   private boolean afficheRdvJour = false;
   private String selectedUserdest;
   private int typeRdv;
   private String dateLun;
   private String dateMar;
   private String dateMer;
   private String dateJeu;
   private String dateVen;
   private String dateSam;
   private String dateDim;
   private boolean testAffRdv = false;
   private boolean showModalPanelRdv = false;
   private long refCollaborateur;
   private boolean rdvdetails;
   private UtilDate utilDate = new UtilDate();
   private boolean dateVerrouillee = false;
   private List mesNaturesRdvItems;
   private transient DataModel dataModelHistorique;
   private List lesSujetsItems;
   private List lesLieuxItems;
   private List lesBudgetItems;
   private List lesApportItems;
   private List lesModeFinItems;
   private List lesDelaisItems;
   private List lesActionItems;
   private List lesConclusionItems;
   private boolean sujetRdv;
   private boolean lieuxRdv;
   private boolean budgetRdv;
   private boolean apportRdv;
   private boolean modeFinRdv;
   private boolean delaisRdv;
   private boolean actionRdv;
   private boolean conclusionRdv;
   private boolean showModalPanelReport = false;
   private Date dateReport;
   private String heureReport;
   private String minuteReport;
   private String motifReport;
   private List lesCollaborateurs;
   private List lesCollaborateursSelectionnes;
   private transient DataModel dataModelCollaborateur;
   private List lesMedecinsItems;
   private TachesDao tachesDao;
   private String choixTache;
   private boolean showModalPanelTiers = false;
   private transient DataModel datamodelTiers = new ListDataModel();
   private List lesTiers;
   private Tiers tiers;
   private TiersDao tiersDao;
   private List lesContacts = new ArrayList();
   private List lesContactsMemo = new ArrayList();
   private ContactDao contactDao;
   private transient DataModel dataModelContacts = new ListDataModel();
   private List lesDestinatairesItems = new ArrayList();
   private boolean gestionPatient;
   private boolean showModalPanelPatients = false;
   private transient DataModel datamodelPatients = new ListDataModel();
   private List lesPatients;
   private Patients patients;
   private PatientsDao patientsDao;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private String filtre = "";
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean visibleOptionMail = false;
   private String nomModeleDocument;
   private List listeImpressionsItems = new ArrayList();
   private boolean showModalPanelPrint = false;
   private Users userSelectionne;
   private UserDao userDao;
   private transient DataModel datamodelUsersService;
   private List lesServicesItems;
   private String serviceSelectionne;
   private Users userRecup;
   private Contacts contactsRecup;
   private Tiers tiersRecup;
   private EcrituresNotes ecrituresNotes;
   private EcrituresNotesDao ecrituresNotesDao;
   private URI uri;
   private String coordonnees;
   private String origine;
   private String legende;

   public FormPlanning() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.userSelectionne = new Users();
      this.lesCollaborateurs = new ArrayList();
      this.lesCollaborateursSelectionnes = new ArrayList();
      this.dataModelCollaborateur = new ListDataModel();
      this.lesMedecinsItems = new ArrayList();
      this.userRecup = new Users();
      this.contactsRecup = new Contacts();
      this.tiersRecup = new Tiers();
      this.ecrituresNotes = new EcrituresNotes();
      this.lesSujetsItems = new ArrayList();
      this.lesLieuxItems = new ArrayList();
      this.lesBudgetItems = new ArrayList();
      this.lesApportItems = new ArrayList();
      this.lesModeFinItems = new ArrayList();
      this.lesDelaisItems = new ArrayList();
      this.lesActionItems = new ArrayList();
      this.lesConclusionItems = new ArrayList();
      this.mesNaturesRdvItems = new ArrayList();
      this.dataModelHistorique = new ListDataModel();
   }

   public void InstancesDaoUtilses() {
      this.rdvDao = new RdvDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresNotesDao = new EcrituresNotesDao(this.baseLog, this.utilInitHibernate);
   }

   public void initRdv(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      if (this.typeVente == 815) {
         this.gestionPatient = true;
      } else {
         this.gestionPatient = false;
      }

      this.userSelectionne = new Users();
      this.userSelectionne = this.usersLog;
      this.lesCollaborateurs.clear();
      this.lesCollaborateurs = this.userDao.selectUserActif(var1);
      RdvSemaine var2 = new RdvSemaine();
      this.listRdvMois.clear();
      this.listRdvMois.add(var2);
      this.datamodelLesRdvParMois.setWrappedData(this.listRdvMois);
      this.listRdvSemaine.clear();
      this.listRdvSemaine.add(var2);
      this.datamodelLesRdvParSemaine.setWrappedData(this.listRdvSemaine);
      this.mesNaturesRdvItems.clear();
      LectureNatureRdv var3 = new LectureNatureRdv(this.baseLog);
      new ArrayList();
      List var4 = var3.getMesNatureRdvUtil();

      for(int var5 = 0; var5 < var4.size(); ++var5) {
         if (((ObjetCompte)var4.get(var5)).isValide()) {
            this.mesNaturesRdvItems.add(new SelectItem(((ObjetCompte)var4.get(var5)).getCode(), ((ObjetCompte)var4.get(var5)).getCode() + ":" + ((ObjetCompte)var4.get(var5)).getNom_FR()));
         }
      }

      if (this.mesNaturesRdvItems == null || this.mesNaturesRdvItems.size() == 0) {
         this.mesNaturesRdvItems.add(new SelectItem("1", "1:Rdv (défaut)"));
      }

      this.initCommerciaux();
   }

   public void initRdvMulti(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      this.lesServicesItems = new ArrayList();
      Object var2 = new ArrayList();
      this.userSelectionne = new Users();
      this.datamodelUsersService = new ListDataModel();
      if (this.typeVente == 815) {
         this.gestionPatient = true;
      } else {
         this.gestionPatient = false;
      }

      ServiceDao var3 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         if (this.usersLog.getUsrPlanningService() != null && !this.usersLog.getUsrPlanningService().isEmpty() && this.usersLog.getUsrPlanningService().equals("0")) {
            this.lesServicesItems = var3.chargerLesServicesItems(0, false, var1);
         } else {
            this.lesServicesItems.add(new SelectItem(this.usersLog.getUsrService()));
         }
      } else {
         this.lesServicesItems = var3.chargerLesServicesItems(0, false, var1);
      }

      if (this.lesServicesItems.size() == 1) {
         if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
            this.serviceSelectionne = this.usersLog.getUsrService();
            var2 = this.userDao.selectUserSevice(this.usersLog.getUsrService(), var1);
         } else {
            var2 = this.userDao.selectUserActif(var1);
         }
      } else if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         this.serviceSelectionne = this.usersLog.getUsrService();
         var2 = this.userDao.selectUserSevice(this.usersLog.getUsrService(), var1);
      }

      this.datamodelUsersService.setWrappedData(var2);
      this.lesCollaborateurs.clear();
      this.lesCollaborateurs = this.userDao.selectUserActif(var1);
      RdvSemaine var4 = new RdvSemaine();
      this.listRdvMois.clear();
      this.listRdvMois.add(var4);
      this.datamodelLesRdvParMois.setWrappedData(this.listRdvMois);
      this.listRdvSemaine.clear();
      this.listRdvSemaine.add(var4);
      this.datamodelLesRdvParSemaine.setWrappedData(this.listRdvSemaine);
      this.mesNaturesRdvItems.clear();
      LectureNatureRdv var5 = new LectureNatureRdv(this.baseLog);
      new ArrayList();
      List var6 = var5.getMesNatureRdvUtil();

      for(int var7 = 0; var7 < var6.size(); ++var7) {
         if (((ObjetCompte)var6.get(var7)).isValide()) {
            this.mesNaturesRdvItems.add(new SelectItem(((ObjetCompte)var6.get(var7)).getCode(), ((ObjetCompte)var6.get(var7)).getCode() + ":" + ((ObjetCompte)var6.get(var7)).getNom_FR()));
         }
      }

      if (this.mesNaturesRdvItems == null || this.mesNaturesRdvItems.size() == 0) {
         this.mesNaturesRdvItems.add(new SelectItem("1", "1:Rdv (défaut)"));
      }

      this.initCommerciaux();
   }

   public void initRdvPatient(Session var1) throws HibernateException, NamingException {
      this.lesServicesItems = new ArrayList();
      this.gestionPatient = true;
      this.userSelectionne = new Users();
      this.userSelectionne = this.usersLog;
      ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         if (this.usersLog.getUsrPlanningService() != null && !this.usersLog.getUsrPlanningService().isEmpty() && this.usersLog.getUsrPlanningService().equals("0")) {
            this.lesServicesItems = var2.chargerLesServicesItems(0, false, var1);
         } else {
            this.lesServicesItems.add(new SelectItem(this.usersLog.getUsrService()));
         }
      } else {
         this.lesServicesItems = var2.chargerLesServicesItems(1, false, var1);
      }

      this.lesCollaborateurs.clear();
      this.lesCollaborateursSelectionnes.clear();
      RdvSemaine var3 = new RdvSemaine();
      this.listRdvMois.clear();
      this.listRdvMois.add(var3);
      this.datamodelLesRdvParMois.setWrappedData(this.listRdvMois);
      this.listRdvSemaine.clear();
      this.listRdvSemaine.add(var3);
      this.datamodelLesRdvParSemaine.setWrappedData(this.listRdvSemaine);
      this.mesNaturesRdvItems.clear();
      LectureNatureRdv var4 = new LectureNatureRdv(this.baseLog);
      new ArrayList();
      List var5 = var4.getMesNatureRdvUtil();

      for(int var6 = 0; var6 < var5.size(); ++var6) {
         if (((ObjetCompte)var5.get(var6)).isValide()) {
            this.mesNaturesRdvItems.add(new SelectItem(((ObjetCompte)var5.get(var6)).getCode(), ((ObjetCompte)var5.get(var6)).getCode() + ":" + ((ObjetCompte)var5.get(var6)).getNom_FR()));
         }
      }

      if (this.mesNaturesRdvItems == null || this.mesNaturesRdvItems.size() == 0) {
         this.mesNaturesRdvItems.add(new SelectItem("1", "1:Rdv (défaut)"));
      }

   }

   public void initCommerciaux() throws JDOMException, IOException {
      LectureElementRdv var1 = new LectureElementRdv();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      this.lesSujetsItems = var1.chargerMesSujetRdv();
      if (this.lesSujetsItems != null && this.lesSujetsItems.size() != 0) {
         this.sujetRdv = true;
      } else {
         this.sujetRdv = false;
      }

      this.lesLieuxItems = var1.chargerMesLieuxRdv();
      if (this.lesLieuxItems != null && this.lesLieuxItems.size() != 0) {
         this.lieuxRdv = true;
      } else {
         this.lieuxRdv = false;
      }

      this.lesBudgetItems = var1.chargerMesBudgetRdv();
      if (this.lesBudgetItems != null && this.lesBudgetItems.size() != 0) {
         this.budgetRdv = true;
      } else {
         this.budgetRdv = false;
      }

      this.lesApportItems = var1.chargerMesApportRdv();
      if (this.lesApportItems != null && this.lesApportItems.size() != 0) {
         this.apportRdv = true;
      } else {
         this.apportRdv = false;
      }

      this.lesModeFinItems = var1.chargerMesModeFinRdv();
      if (this.lesModeFinItems != null && this.lesModeFinItems.size() != 0) {
         this.modeFinRdv = true;
      } else {
         this.modeFinRdv = false;
      }

      this.lesDelaisItems = var1.chargerMesDelaisRdv();
      if (this.lesDelaisItems != null && this.lesDelaisItems.size() != 0) {
         this.delaisRdv = true;
      } else {
         this.delaisRdv = false;
      }

      this.lesActionItems = var1.chargerMesActionRdv();
      if (this.lesActionItems != null && this.lesActionItems.size() != 0) {
         this.actionRdv = true;
      } else {
         this.actionRdv = false;
      }

      this.lesConclusionItems = var1.chargerMesConclusionRdv();
      if (this.lesConclusionItems != null && this.lesConclusionItems.size() != 0) {
         this.conclusionRdv = true;
      } else {
         this.conclusionRdv = false;
      }

   }

   public void modeMois() {
      this.modeRdv = 0;
   }

   public void modeSemaine() {
      this.modeRdv = 1;
   }

   public void modeJour() {
      this.modeRdv = 2;
   }

   public void modeListe() {
      this.modeRdv = 3;
   }

   public void selectionService() throws HibernateException, NamingException {
      if (!this.gestionPatient) {
         Object var1 = new ArrayList();
         if (this.serviceSelectionne != null && !this.serviceSelectionne.isEmpty()) {
            if (this.serviceSelectionne.contains(":")) {
               var1 = this.userDao.selectUserSevice(this.serviceSelectionne, (Session)null);
            } else {
               this.serviceSelectionne = "";
            }
         } else {
            this.serviceSelectionne = "";
         }

         this.datamodelUsersService.setWrappedData(var1);
      }

   }

   public void chargerMedecinService() throws HibernateException, NamingException {
      this.lesMedecinsItems.clear();
      new ArrayList();
      List var1 = this.userDao.chargerLesMedecins((Session)null);
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            if (((Users)var1.get(var2)).getUsrService() != null && !((Users)var1.get(var2)).getUsrService().isEmpty()) {
               if (((Users)var1.get(var2)).getUsrService() != null && !((Users)var1.get(var2)).getUsrService().isEmpty()) {
                  if (this.rdv.getRdvService() != null && !this.rdv.getRdvService().isEmpty()) {
                     if (((Users)var1.get(var2)).getUsrService().equals(this.rdv.getRdvService())) {
                        this.lesMedecinsItems.add(new SelectItem(((Users)var1.get(var2)).getUsrid(), ((Users)var1.get(var2)).getUsrCivilite() + " " + ((Users)var1.get(var2)).getUsrPatronyme()));
                     }
                  } else {
                     this.lesMedecinsItems.add(new SelectItem(((Users)var1.get(var2)).getUsrid(), ((Users)var1.get(var2)).getUsrCivilite() + " " + ((Users)var1.get(var2)).getUsrPatronyme()));
                  }
               }
            } else {
               this.lesMedecinsItems.add(new SelectItem(((Users)var1.get(var2)).getUsrid(), ((Users)var1.get(var2)).getUsrCivilite() + " " + ((Users)var1.get(var2)).getUsrPatronyme()));
            }
         }
      }

   }

   public void selectionUser() throws HibernateException, NamingException, ParseException {
      if (this.datamodelUsersService.isRowAvailable()) {
         this.userSelectionne = (Users)this.datamodelUsersService.getRowData();
         this.datamodelLesRdvParMois = new ListDataModel();
         this.datamodelLesRdvParSemaine = new ListDataModel();
         this.datamodelLesRdvParJour = new ListDataModel();
         this.datamodelRdv = new ListDataModel();
         if (this.modeRdv == 0) {
            this.chargerLesRdvByMois();
         } else if (this.modeRdv == 1) {
            this.chargerLesRdvBySemaine();
         } else if (this.modeRdv == 2) {
            this.chargerLesRdvByJour();
         } else if (this.modeRdv == 3) {
            this.chargerLesRdv();
         }
      }

   }

   public void chargerLesRdv() throws HibernateException, NamingException {
      this.listRdvMois.clear();
      this.listRdvSemaine.clear();
      this.listRdvJour.clear();
      if (!this.gestionPatient) {
         this.serviceSelectionne = null;
      }

      this.listRdv = this.rdvDao.selectRdv(this.userSelectionne.getUsrid(), this.jourDeb, this.jourFin, this.valNatListe, this.serviceSelectionne, (Session)null);
      this.datamodelRdv.setWrappedData(this.listRdv);
   }

   public void chargerLesRdvByJour() throws HibernateException, NamingException {
      this.chargerLesRdvByJour(this.userSelectionne);
   }

   public void chargerLesRdvByJourPrecedent() throws HibernateException, NamingException, ParseException {
      if (this.parJour == null) {
         this.parJour = new Date();
      }

      Date var1 = this.parJour;
      this.parJour = this.utilDate.dateJourPrecedent(var1);
      this.chargerLesRdvByJour(this.userSelectionne);
   }

   public void chargerLesRdvByJourSuivant() throws HibernateException, NamingException, ParseException {
      if (this.parJour == null) {
         this.parJour = new Date();
      }

      Date var1 = this.parJour;
      this.parJour = this.utilDate.dateJourSuivant(var1);
      this.chargerLesRdvByJour(this.userSelectionne);
   }

   public void chargerLesRdvByJour(Users var1) throws HibernateException, NamingException {
      if (this.parJour != null) {
         this.listRdv.clear();
         if (!this.gestionPatient) {
            this.serviceSelectionne = null;
         }

         this.listRdv = this.rdvDao.selectRdv(var1.getUsrid(), this.parJour, this.valNatJour, this.serviceSelectionne, (Session)null);
         this.listRdvJour.clear();
         if (this.structureLog.getStrHrDeb() == null || this.structureLog.getStrHrDeb().isEmpty()) {
            this.structureLog.setStrHrDeb("00");
         }

         int var2 = Integer.parseInt(this.structureLog.getStrHrDeb());
         if (var2 == 0) {
            var2 = 8;
         }

         if (this.structureLog.getStrMnDeb() == null || this.structureLog.getStrMnDeb().isEmpty()) {
            this.structureLog.setStrMnDeb("00");
         }

         int var3 = Integer.parseInt(this.structureLog.getStrMnDeb());
         if (this.structureLog.getStrHrFin() == null || this.structureLog.getStrHrFin().isEmpty()) {
            this.structureLog.setStrHrFin("00");
         }

         int var4 = Integer.parseInt(this.structureLog.getStrHrFin());
         if (var4 == 0) {
            var4 = 19;
         }

         if (this.structureLog.getStrMnFin() == null || this.structureLog.getStrMnFin().isEmpty()) {
            this.structureLog.setStrMnFin("00");
         }

         int var5 = Integer.parseInt(this.structureLog.getStrMnFin());
         if (this.structureLog.getStrHrPas() == null || this.structureLog.getStrHrPas().isEmpty()) {
            this.structureLog.setStrHrPas("00");
         }

         int var6 = Integer.parseInt(this.structureLog.getStrHrPas());
         if (this.structureLog.getStrMnPas() == null || this.structureLog.getStrMnPas().isEmpty()) {
            this.structureLog.setStrMnPas("00");
         }

         int var7 = Integer.parseInt(this.structureLog.getStrMnPas());
         if (var6 == 0 && var7 == 0) {
            var6 = 0;
            var7 = 30;
         }

         int var8 = var2 * 60 + var3;
         int var9 = var4 * 60 + var5;
         int var10 = var6 * 60 + var7;

         for(int var11 = var8; var11 < var9; var11 += var10) {
            int var12 = var11 % 60;
            String var13 = "";
            if (var12 < 10) {
               var13 = "0" + var12;
            } else {
               var13 = "" + var12;
            }

            String var14 = "";
            if (Math.abs(var11 / 60) < 10) {
               var14 = "0" + Math.abs(var11 / 60);
            } else {
               var14 = "" + Math.abs(var11 / 60);
            }

            (new StringBuilder()).append(var14).append(":").append(var13).toString();
            this.rdv = new Rdv();
            boolean var16 = false;

            for(int var17 = 0; var17 < this.listRdv.size(); ++var17) {
               this.rdv = (Rdv)this.listRdv.get(var17);
               if (this.rdv.getRdvHrDe() == null) {
                  this.rdv.setRdvHrDe("08");
               }

               if (this.rdv.getRdvMnDe() == null) {
                  this.rdv.setRdvMnDe("00");
               }

               int var18 = Integer.parseInt(var14);
               int var19 = Integer.parseInt(this.rdv.getRdvHrDe());
               if (var19 >= var18 && var19 <= var18) {
                  this.listRdvJour.add(this.rdv);
                  var16 = true;
               }
            }

            if (!var16) {
               this.rdv = new Rdv();
               this.rdv.setRdvHrDe(var14);
               this.rdv.setRdvMnDe(var13);
               this.listRdvJour.add(this.rdv);
            }
         }

         this.datamodelLesRdvParJour.setWrappedData(this.listRdvJour);
      }

   }

   public void chargerLesRdvBySemaine() throws HibernateException, NamingException, ParseException {
      this.chargerLesRdvBySemaine(this.userSelectionne, (Session)null);
   }

   public void chargerLesRdvBySemainePrecedent() throws HibernateException, NamingException, ParseException {
      if (this.dateLun == null || this.dateLun.isEmpty()) {
         this.dateLun = this.utilDate.dateToStringFrLg(new Date());
      }

      this.parSemaine = this.utilDate.dateJourPrecedent(this.calculeDate(this.dateLun));
      this.chargerLesRdvBySemaine(this.userSelectionne, (Session)null);
   }

   public void chargerLesRdvBySemaineSuivant() throws HibernateException, NamingException, ParseException {
      if (this.dateDim == null || this.dateDim.isEmpty()) {
         this.dateDim = this.utilDate.dateToStringFrLg(new Date());
      }

      this.parSemaine = this.utilDate.dateJourSuivant(this.calculeDate(this.dateDim));
      this.chargerLesRdvBySemaine(this.userSelectionne, (Session)null);
   }

   public void chargerLesRdvBySemaine(Users var1, Session var2) throws HibernateException, NamingException, ParseException {
      if (this.parSemaine != null) {
         int var3 = Integer.parseInt(this.optionTiers.getNbJoursPasses());
         Date var4 = this.utilDate.dateToSQLLight(this.utilDate.datedevaleurTheo(new Date(), var3));
         Date var5 = null;
         Date var6 = null;
         Calendar var7 = Calendar.getInstance();
         var7.setTime(this.parSemaine);
         String var8 = "" + var7.getTime();
         if (var8.contains("Mon")) {
            var5 = var7.getTime();
            var7.add(7, 6);
            var6 = var7.getTime();
         } else if (var8.contains("Tue")) {
            var7.add(7, -1);
            var5 = var7.getTime();
            var7.add(7, 6);
            var6 = var7.getTime();
         } else if (var8.contains("Wed")) {
            var7.add(7, -2);
            var5 = var7.getTime();
            var7.add(7, 6);
            var6 = var7.getTime();
         } else if (var8.contains("Thu")) {
            var7.add(7, -3);
            var5 = var7.getTime();
            var7.add(7, 6);
            var6 = var7.getTime();
         } else if (var8.contains("Fri")) {
            var7.add(7, -4);
            var5 = var7.getTime();
            var7.add(7, 6);
            var6 = var7.getTime();
         } else if (var8.contains("Sat")) {
            var7.add(7, -5);
            var5 = var7.getTime();
            var7.add(7, 6);
            var6 = var7.getTime();
         } else if (var8.contains("Sun")) {
            var7.add(7, -6);
            var5 = var7.getTime();
            var7.add(7, 6);
            var6 = var7.getTime();
         }

         Calendar var9 = Calendar.getInstance();
         var9.setTime(var5);
         SimpleDateFormat var10 = new SimpleDateFormat("dd/MM/yy", Locale.FRANCE);
         this.dateLun = var10.format(var5);
         var9.add(7, 1);
         this.dateMar = var10.format(var9.getTime());
         var9.add(7, 1);
         this.dateMer = var10.format(var9.getTime());
         var9.add(7, 1);
         this.dateJeu = var10.format(var9.getTime());
         var9.add(7, 1);
         this.dateVen = var10.format(var9.getTime());
         var9.add(7, 1);
         this.dateSam = var10.format(var9.getTime());
         this.dateDim = var10.format(var6);
         this.listRdv.clear();
         if (!this.gestionPatient) {
            this.serviceSelectionne = null;
         }

         this.listRdv = this.rdvDao.selectRdv(var1.getUsrid(), var5, var6, this.valNatSemaine, this.serviceSelectionne, var2);
         this.listRdvSemaine.clear();
         if (this.structureLog.getStrHrDeb() == null || this.structureLog.getStrHrDeb().isEmpty()) {
            this.structureLog.setStrHrDeb("00");
         }

         int var11 = Integer.parseInt(this.structureLog.getStrHrDeb());
         if (var11 == 0) {
            var11 = 8;
         }

         if (this.structureLog.getStrMnDeb() == null || this.structureLog.getStrMnDeb().isEmpty()) {
            this.structureLog.setStrMnDeb("00");
         }

         int var12 = Integer.parseInt(this.structureLog.getStrMnDeb());
         if (this.structureLog.getStrHrFin() == null || this.structureLog.getStrHrFin().isEmpty()) {
            this.structureLog.setStrHrFin("00");
         }

         int var13 = Integer.parseInt(this.structureLog.getStrHrFin());
         if (var13 == 0) {
            var13 = 19;
         }

         if (this.structureLog.getStrMnFin() == null || this.structureLog.getStrMnFin().isEmpty()) {
            this.structureLog.setStrMnFin("00");
         }

         int var14 = Integer.parseInt(this.structureLog.getStrMnFin());
         if (this.structureLog.getStrHrPas() == null || this.structureLog.getStrHrPas().isEmpty()) {
            this.structureLog.setStrHrPas("00");
         }

         int var15 = Integer.parseInt(this.structureLog.getStrHrPas());
         if (this.structureLog.getStrMnPas() == null || this.structureLog.getStrMnPas().isEmpty()) {
            this.structureLog.setStrMnPas("00");
         }

         int var16 = Integer.parseInt(this.structureLog.getStrMnPas());
         if (var15 == 0 && var16 == 0) {
            var15 = 0;
            var16 = 30;
         }

         int var17 = var11 * 60 + var12;
         int var18 = var13 * 60 + var14;
         int var19 = var15 * 60 + var16;

         int var21;
         for(int var20 = var17; var20 < var18; var20 += var19) {
            var21 = var20 % 60;
            String var22 = "";
            if (var21 < 10) {
               var22 = "0" + var21;
            } else {
               var22 = "" + var21;
            }

            String var23 = "";
            if (Math.abs(var20 / 60) < 10) {
               var23 = "0" + Math.abs(var20 / 60);
            } else {
               var23 = "" + Math.abs(var20 / 60);
            }

            String var24 = var23 + ":" + var22;
            this.rdv = new Rdv();
            RdvSemaine var25 = new RdvSemaine();
            boolean var26 = false;

            for(int var27 = 0; var27 < this.listRdv.size(); ++var27) {
               this.rdv = (Rdv)this.listRdv.get(var27);
               if (this.rdv.getRdvHrDe() == null) {
                  this.rdv.setRdvHrDe("08");
               }

               if (this.rdv.getRdvMnDe() == null) {
                  this.rdv.setRdvMnDe("00");
               }

               SimpleDateFormat var28 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
               var28.format(this.rdv.getRdvDteDe());
               Calendar var30 = Calendar.getInstance();
               var30.setTime(this.rdv.getRdvDteDe());
               String var31 = "" + var30.getTime();
               var25.setHeure(var24);
               int var32 = Integer.parseInt(var23);
               int var33 = Integer.parseInt(this.rdv.getRdvHrDe());
               if (var33 >= var32 && var33 <= var32) {
                  if (var31.contains("Mon")) {
                     var25.setLundi(this.rdv.getTexteAffiche());
                     var25.setRdvUsrLundi(this.rdv.getRdvUsrDe());
                     var25.setRdvIdLundi(this.rdv.getRdvId());
                     var25.setRdvEtatLundi(this.rdv.getRdvEtat());
                     var25.setRdvErreurLundi(this.rdv.isRdvErreur());
                  } else if (var31.contains("Tue")) {
                     var25.setMardi(this.rdv.getTexteAffiche());
                     var25.setRdvUsrMardi(this.rdv.getRdvUsrDe());
                     var25.setRdvIdMardi(this.rdv.getRdvId());
                     var25.setRdvEtatMardi(this.rdv.getRdvEtat());
                     var25.setRdvErreurMardi(this.rdv.isRdvErreur());
                  } else if (var31.contains("Wed")) {
                     var25.setMercredi(this.rdv.getTexteAffiche());
                     var25.setRdvUsrMercredi(this.rdv.getRdvUsrDe());
                     var25.setRdvIdMercredi(this.rdv.getRdvId());
                     var25.setRdvEtatMercredi(this.rdv.getRdvEtat());
                     var25.setRdvErreurMercredi(this.rdv.isRdvErreur());
                  } else if (var31.contains("Thu")) {
                     var25.setJeudi(this.rdv.getTexteAffiche());
                     var25.setRdvUsrJeudi(this.rdv.getRdvUsrDe());
                     var25.setRdvIdJeudi(this.rdv.getRdvId());
                     var25.setRdvEtatJeudi(this.rdv.getRdvEtat());
                     var25.setRdvErreurJeudi(this.rdv.isRdvErreur());
                  } else if (var31.contains("Fri")) {
                     var25.setVendredi(this.rdv.getTexteAffiche());
                     var25.setRdvUsrVendredi(this.rdv.getRdvUsrDe());
                     var25.setRdvIdVendredi(this.rdv.getRdvId());
                     var25.setRdvEtatVendredi(this.rdv.getRdvEtat());
                     var25.setRdvErreurVendredi(this.rdv.isRdvErreur());
                  } else if (var31.contains("Sat")) {
                     var25.setSamedi(this.rdv.getTexteAffiche());
                     var25.setRdvUsrSamedi(this.rdv.getRdvUsrDe());
                     var25.setRdvIdSamedi(this.rdv.getRdvId());
                     var25.setRdvEtatSamedi(this.rdv.getRdvEtat());
                     var25.setRdvErreurSamedi(this.rdv.isRdvErreur());
                  } else if (var31.contains("Sun")) {
                     var25.setDimanche(this.rdv.getTexteAffiche());
                     var25.setRdvUsrDimanche(this.rdv.getRdvUsrDe());
                     var25.setRdvIdDimanche(this.rdv.getRdvId());
                     var25.setRdvEtatDimanche(this.rdv.getRdvEtat());
                     var25.setRdvErreurDimanche(this.rdv.isRdvErreur());
                  }

                  var26 = true;
               }
            }

            if (!var26) {
               var25 = new RdvSemaine();
               var25.setHeure(var23 + ":" + var22);
            }

            this.listRdvSemaine.add(var25);
         }

         if (this.listRdvSemaine.size() != 0) {
            new RdvSemaine();

            for(var21 = 0; var21 < this.listRdvSemaine.size(); ++var21) {
               RdvSemaine var34 = (RdvSemaine)this.listRdvSemaine.get(var21);
               var34.setAffiche01(false);
               var34.setAffiche01Sup(false);
               if (this.calculeDate(this.dateLun).after(var4) || this.calculeDate(this.dateLun).equals(var4)) {
                  if (var34.getLundi() == null || var34.getLundi().isEmpty()) {
                     var34.setAffiche01(true);
                  }

                  if (var34.getLundi() != null && !var34.getLundi().isEmpty()) {
                     var34.setAffiche01Sup(true);
                  }
               }

               var34.setAffiche02(false);
               var34.setAffiche02Sup(false);
               if (this.calculeDate(this.dateMar).after(var4) || this.calculeDate(this.dateMar).equals(var4)) {
                  if (var34.getMardi() == null || var34.getMardi().isEmpty()) {
                     var34.setAffiche02(true);
                  }

                  if (var34.getMardi() != null && !var34.getMardi().isEmpty()) {
                     var34.setAffiche02Sup(true);
                  }
               }

               var34.setAffiche03(false);
               var34.setAffiche03Sup(false);
               if (this.calculeDate(this.dateMer).after(var4) || this.calculeDate(this.dateMer).equals(var4)) {
                  if (var34.getMercredi() == null || var34.getMercredi().isEmpty()) {
                     var34.setAffiche03(true);
                  }

                  if (var34.getMercredi() != null && !var34.getMercredi().isEmpty()) {
                     var34.setAffiche03Sup(true);
                  }
               }

               var34.setAffiche04(false);
               var34.setAffiche04Sup(false);
               if (this.calculeDate(this.dateJeu).after(var4) || this.calculeDate(this.dateJeu).equals(var4)) {
                  if (var34.getJeudi() == null || var34.getJeudi().isEmpty()) {
                     var34.setAffiche04(true);
                  }

                  if (var34.getJeudi() != null && !var34.getJeudi().isEmpty()) {
                     var34.setAffiche04Sup(true);
                  }
               }

               var34.setAffiche05(false);
               var34.setAffiche05Sup(false);
               if (this.calculeDate(this.dateVen).after(var4) || this.calculeDate(this.dateVen).equals(var4)) {
                  if (var34.getVendredi() == null || var34.getVendredi().isEmpty()) {
                     var34.setAffiche05(true);
                  }

                  if (var34.getVendredi() != null && !var34.getVendredi().isEmpty()) {
                     var34.setAffiche05Sup(true);
                  }
               }

               var34.setAffiche06(false);
               var34.setAffiche06Sup(false);
               if (this.calculeDate(this.dateSam).after(var4) || this.calculeDate(this.dateSam).equals(var4)) {
                  if (var34.getSamedi() != null || var34.getSamedi().isEmpty()) {
                     var34.setAffiche06(true);
                  }

                  if (var34.getSamedi() != null && !var34.getSamedi().isEmpty()) {
                     var34.setAffiche06Sup(true);
                  }
               }

               var34.setAffiche07(false);
               var34.setAffiche07Sup(false);
               if (this.calculeDate(this.dateDim).after(var4) || this.calculeDate(this.dateDim).equals(var4)) {
                  if (var34.getDimanche() == null || var34.getDimanche().isEmpty()) {
                     var34.setAffiche07(true);
                  }

                  if (var34.getDimanche() != null && !var34.getDimanche().isEmpty()) {
                     var34.setAffiche07Sup(true);
                  }
               }
            }
         }

         this.datamodelLesRdvParSemaine.setWrappedData(this.listRdvSemaine);
      }

   }

   public Date calculeDate(String var1) throws ParseException {
      String[] var2 = var1.split("/");
      int var3 = 2000 + Integer.parseInt(var2[2]);
      Date var4 = this.utilDate.stringToDateSQLLight(var3 + "-" + var2[1] + "-" + var2[0]);
      return var4;
   }

   public void chargerLesRdvByMois() throws HibernateException, NamingException, ParseException {
      this.chargerLesRdvByMois(this.userSelectionne, (Session)null);
   }

   public void chargerLesRdvByMoisPrecedent() throws HibernateException, NamingException, ParseException {
      if (this.parMois == null) {
         this.parMois = new Date();
      }

      Date var1 = this.parMois;
      this.parMois = this.utilDate.dateMoisPrecedent(var1);
      this.chargerLesRdvByMois(this.userSelectionne, (Session)null);
   }

   public void chargerLesRdvByMoisSuivant() throws HibernateException, NamingException, ParseException {
      if (this.parMois == null) {
         this.parMois = new Date();
      }

      Date var1 = this.parMois;
      this.parMois = this.utilDate.dateMoisSuivant(var1);
      this.chargerLesRdvByMois(this.userSelectionne, (Session)null);
   }

   public void chargerLesRdvByMois(Users var1, Session var2) throws HibernateException, NamingException, ParseException {
      if (this.parMois != null) {
         int var3 = Integer.parseInt(this.optionTiers.getNbJoursPasses());
         Date var4 = this.utilDate.dateToSQLLight(this.utilDate.datedevaleurTheo(new Date(), var3));
         Date var5 = this.parMois;
         Calendar var6 = Calendar.getInstance();
         var6.setTime(var5);
         var6.add(2, 1);
         SimpleDateFormat var7 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         String var8 = var7.format(var6.getTime());
         String[] var9 = var8.split("-");
         String var10 = "01-" + var9[1] + "-" + var9[2];
         SimpleDateFormat var11 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         Date var12 = var11.parse(var10);
         Calendar var13 = Calendar.getInstance();
         var13.setTime(var12);
         var13.add(2, -1);
         Date var14 = var13.getTime();
         var13.add(2, 1);
         var13.add(5, -1);
         Date var15 = var13.getTime();
         SimpleDateFormat var16 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         String var17 = var16.format(var15);
         String[] var18 = var17.split("-");
         int var19 = Integer.parseInt(var18[0]);
         this.rdv = new Rdv();
         this.listRdv.clear();
         if (!this.gestionPatient) {
            this.serviceSelectionne = null;
         }

         this.listRdv = this.rdvDao.selectRdv(var1.getUsrid(), var14, var15, this.valNatMois, this.serviceSelectionne, var2);
         this.listRdvMois.clear();
         RdvSemaine var20 = new RdvSemaine();
         int var21 = 1;

         for(int var22 = 1; var22 <= var19; ++var22) {
            String var23 = var16.format(var14).substring(0, 2);
            String var24 = "" + var14;
            ListDataModel var25;
            if (var24.contains("Mon")) {
               if (!var23.equals("01")) {
                  ++var21;
               }

               var20.setNum_sem(var21);
               var20.setLundi(var23);
               var20.setLesRdvJourLundi(this.rechercherRDVMois(this.listRdv, var14));
               var25 = new ListDataModel();
               var25.setWrappedData(var20.getLesRdvJourLundi());
               if (!var14.after(var4) && !var14.equals(var4)) {
                  var20.setAffiche01(false);
               } else {
                  var20.setAffiche01(true);
               }

               var20.setDataModelLundi(var25);
            } else if (var24.contains("Tue")) {
               var20.setNum_sem(var21);
               var20.setMardi(var23);
               var20.setLesRdvJourMardi(this.rechercherRDVMois(this.listRdv, var14));
               var25 = new ListDataModel();
               var25.setWrappedData(var20.getLesRdvJourMardi());
               if (!var14.after(var4) && !var14.equals(var4)) {
                  var20.setAffiche02(false);
               } else {
                  var20.setAffiche02(true);
               }

               var20.setDataModelMardi(var25);
            } else if (var24.contains("Wed")) {
               var20.setNum_sem(var21);
               var20.setMercredi(var23);
               var20.setLesRdvJourMercredi(this.rechercherRDVMois(this.listRdv, var14));
               var25 = new ListDataModel();
               var25.setWrappedData(var20.getLesRdvJourMercredi());
               if (!var14.after(var4) && !var14.equals(var4)) {
                  var20.setAffiche03(false);
               } else {
                  var20.setAffiche03(true);
               }

               var20.setDataModelMercredi(var25);
            } else if (var24.contains("Thu")) {
               var20.setNum_sem(var21);
               var20.setJeudi(var23);
               var20.setLesRdvJourJeudi(this.rechercherRDVMois(this.listRdv, var14));
               var25 = new ListDataModel();
               var25.setWrappedData(var20.getLesRdvJourJeudi());
               if (!var14.after(var4) && !var14.equals(var4)) {
                  var20.setAffiche04(false);
               } else {
                  var20.setAffiche04(true);
               }

               var20.setDataModelJeudi(var25);
            } else if (var24.contains("Fri")) {
               var20.setNum_sem(var21);
               var20.setVendredi(var23);
               var20.setLesRdvJourVendredi(this.rechercherRDVMois(this.listRdv, var14));
               var25 = new ListDataModel();
               var25.setWrappedData(var20.getLesRdvJourVendredi());
               if (!var14.after(var4) && !var14.equals(var4)) {
                  var20.setAffiche05(false);
               } else {
                  var20.setAffiche05(true);
               }

               var20.setDataModelVendredi(var25);
            } else if (var24.contains("Sat")) {
               var20.setNum_sem(var21);
               var20.setSamedi(var23);
               var20.setLesRdvJourSamedi(this.rechercherRDVMois(this.listRdv, var14));
               var25 = new ListDataModel();
               var25.setWrappedData(var20.getLesRdvJourSamedi());
               if (!var14.after(var4) && !var14.equals(var4)) {
                  var20.setAffiche06(false);
               } else {
                  var20.setAffiche06(true);
               }

               var20.setDataModelSamedi(var25);
            } else if (var24.contains("Sun")) {
               var20.setNum_sem(var21);
               var20.setDimanche(var23);
               var20.setLesRdvJourDimanche(this.rechercherRDVMois(this.listRdv, var14));
               var25 = new ListDataModel();
               var25.setWrappedData(var20.getLesRdvJourDimanche());
               if (!var14.after(var4) && !var14.equals(var4)) {
                  var20.setAffiche07(false);
               } else {
                  var20.setAffiche07(true);
               }

               var20.setDataModelDimanche(var25);
               this.listRdvMois.add(var20);
               var20 = new RdvSemaine();
            }

            Calendar var26 = Calendar.getInstance();
            var26.setTime(var14);
            var26.add(5, 1);
            var14 = var26.getTime();
         }

         if (var21 == 6) {
            if (var20.getLundi() != null && !var20.getLundi().isEmpty()) {
               this.listRdvMois.add(var20);
            }
         } else if (var21 == 5 && var20.getLundi() != null && !var20.getLundi().isEmpty()) {
            this.listRdvMois.add(var20);
         }

         this.datamodelLesRdvParMois.setWrappedData(this.listRdvMois);
      }

   }

   public List rechercherRDVMois(List var1, Date var2) throws ParseException {
      ArrayList var3 = new ArrayList();
      SimpleDateFormat var4 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
      String var5 = var4.format(var2);

      for(int var6 = 0; var6 < var1.size(); ++var6) {
         this.rdv = new Rdv();
         this.rdv = (Rdv)var1.get(var6);
         SimpleDateFormat var7 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
         String var8 = var7.format(this.rdv.getRdvDteDe());
         if (var8.equals(var5)) {
            if (this.rdv.getRdvHrDe() == null) {
               this.rdv.setRdvHrDe("08");
            }

            if (this.rdv.getRdvMnDe() == null) {
               this.rdv.setRdvMnDe("00");
            }

            var3.add(this.rdv);
         }
      }

      return var3;
   }

   public void selectionRdv() throws HibernateException, NamingException {
      if (this.datamodelRdv.isRowAvailable()) {
         this.rdv = (Rdv)this.datamodelRdv.getRowData();
         this.refCollaborateur = this.rdv.getRdvUsrDe();
         this.afficheRdv = true;
      }

   }

   public void selectionRdvJour() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParJour.isRowAvailable()) {
         this.rdv = (Rdv)this.datamodelLesRdvParJour.getRowData();
         this.refCollaborateur = this.rdv.getRdvUsrDe();
         this.afficheRdvJour = true;
      }

   }

   public void ajouterRdv() throws HibernateException, NamingException {
      this.tiers = new Tiers();
      this.patients = new Patients();
      this.rdv = new Rdv();
      this.rdv.setRdvDteDe(new Date());
      this.rdv.setRdvNature(1);
      this.lesContacts.clear();
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.lesCollaborateursSelectionnes.clear();
      if (this.lesCollaborateurs.size() != 0) {
         new Users();

         for(int var2 = 0; var2 < this.lesCollaborateurs.size(); ++var2) {
            Users var1 = (Users)this.lesCollaborateurs.get(var2);
            if (var1.getUsrid() != this.userSelectionne.getUsrid()) {
               var1.setSelectUser(false);
               this.lesCollaborateursSelectionnes.add(var1);
            }
         }
      }

      this.dataModelCollaborateur.setWrappedData(this.lesCollaborateursSelectionnes);
      this.choixTypeRdv();
      this.refCollaborateur = 0L;
      this.rdv.setRdvService(this.serviceSelectionne);
      this.chargerMedecinService();
      this.showModalPanelRdv = true;
      this.rdvdetails = false;
      this.compteRendu = false;
   }

   public void ajouterRdvJour() throws HibernateException, NamingException {
      this.tiers = new Tiers();
      this.patients = new Patients();
      this.rdv = new Rdv();
      this.rdv.setRdvDteDe(new Date());
      this.rdv.setRdvNature(1);
      this.lesContacts.clear();
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.lesCollaborateursSelectionnes.clear();
      if (this.lesCollaborateurs.size() != 0) {
         new Users();

         for(int var2 = 0; var2 < this.lesCollaborateurs.size(); ++var2) {
            Users var1 = (Users)this.lesCollaborateurs.get(var2);
            if (var1.getUsrid() != this.userSelectionne.getUsrid()) {
               var1.setSelectUser(false);
               this.lesCollaborateursSelectionnes.add(var1);
            }
         }
      }

      this.dataModelCollaborateur.setWrappedData(this.lesCollaborateursSelectionnes);
      this.choixTypeRdv();
      this.refCollaborateur = 0L;
      this.rdv.setRdvService(this.serviceSelectionne);
      this.chargerMedecinService();
      this.showModalPanelRdv = true;
      this.rdvdetails = false;
      this.compteRendu = false;
   }

   public void ajouterRdvMois(Date var1) throws HibernateException, NamingException {
      this.tiers = new Tiers();
      this.patients = new Patients();
      this.rdv = new Rdv();
      this.rdv.setRdvDteDe(var1);
      this.rdv.setRdvNature(1);
      this.lesContacts.clear();
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.lesCollaborateursSelectionnes.clear();
      if (this.lesCollaborateurs.size() != 0) {
         new Users();

         for(int var3 = 0; var3 < this.lesCollaborateurs.size(); ++var3) {
            Users var2 = (Users)this.lesCollaborateurs.get(var3);
            if (var2.getUsrid() != this.userSelectionne.getUsrid()) {
               var2.setSelectUser(false);
               this.lesCollaborateursSelectionnes.add(var2);
            }
         }
      }

      this.dataModelCollaborateur.setWrappedData(this.lesCollaborateursSelectionnes);
      this.choixTypeRdv();
      this.refCollaborateur = this.usersLog.getUsrid();
      this.rdv.setRdvService(this.serviceSelectionne);
      this.chargerMedecinService();
      this.dateVerrouillee = true;
      this.showModalPanelRdv = true;
      this.rdvdetails = false;
      this.compteRendu = false;
   }

   public void ajouterRdvMoisHeure(Date var1, String var2, String var3) throws HibernateException, NamingException {
      this.tiers = new Tiers();
      this.patients = new Patients();
      this.rdv = new Rdv();
      this.rdv.setRdvDteDe(var1);
      this.rdv.setRdvHrDe(var2);
      this.rdv.setRdvMnDe(var3);
      this.rdv.setRdvNature(1);
      this.lesContacts.clear();
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.lesCollaborateursSelectionnes.clear();
      if (this.lesCollaborateurs.size() != 0) {
         new Users();

         for(int var5 = 0; var5 < this.lesCollaborateurs.size(); ++var5) {
            Users var4 = (Users)this.lesCollaborateurs.get(var5);
            if (var4.getUsrid() != this.userSelectionne.getUsrid()) {
               var4.setSelectUser(false);
               this.lesCollaborateursSelectionnes.add(var4);
            }
         }
      }

      this.choixTypeRdv();
      this.refCollaborateur = 0L;
      this.rdv.setRdvService(this.serviceSelectionne);
      this.chargerMedecinService();
      this.dateVerrouillee = true;
      this.showModalPanelRdv = true;
      this.rdvdetails = false;
      this.compteRendu = false;
   }

   public void modifierRdv() throws HibernateException, NamingException, ParseException {
      if (this.rdv != null) {
         this.choixTypeRdv();
         this.showModalPanelRdv = true;
         Date var1 = this.utilDate.dateToSQLLight(new Date());
         if (this.rdv.getRdvEtat() == 0 && !this.rdv.getRdvDteDe().before(var1) && this.rdv.getRdvIdPrincipal() == 0L && this.rdv.getRdvUsrDe() == this.userSelectionne.getUsrid()) {
            this.rdvdetails = false;
         } else {
            this.rdvdetails = true;
         }

         this.compteRendu = true;
         this.chargerContactTiers();
         this.refCollaborateur = this.rdv.getRdvUsrDe();
         this.chargerMedecinService();
      }

   }

   public void modifierRdvJour() throws HibernateException, NamingException, ParseException {
      if (this.rdv != null) {
         this.choixTypeRdv();
         this.showModalPanelRdv = true;
         Date var1 = this.utilDate.dateToSQLLight(new Date());
         if (this.gestionPatient) {
            if (this.rdv.getRdvEtat() == 0 && !this.rdv.getRdvDteDe().before(var1) && this.rdv.getRdvIdPrincipal() == 0L) {
               this.rdvdetails = false;
            } else {
               this.rdvdetails = true;
            }
         } else if (this.rdv.getRdvEtat() == 0 && !this.rdv.getRdvDteDe().before(var1) && this.rdv.getRdvIdPrincipal() == 0L && this.rdv.getRdvUsrDe() == this.userSelectionne.getUsrid()) {
            this.rdvdetails = false;
         } else {
            this.rdvdetails = true;
         }

         this.compteRendu = true;
         this.chargerContactTiers();
         this.refCollaborateur = this.rdv.getRdvUsrDe();
         this.chargerMedecinService();
      }

   }

   public void modifierRdvMois() throws ParseException, HibernateException, NamingException {
      if (this.rdv != null) {
         this.choixTypeRdv();
         this.dateVerrouillee = true;
         this.showModalPanelRdv = true;
         this.compteRendu = true;
         Date var1 = this.utilDate.dateToSQLLight(new Date());
         if (this.gestionPatient) {
            if (this.rdv.getRdvEtat() == 0 && !this.rdv.getRdvDteDe().before(var1) && this.rdv.getRdvIdPrincipal() == 0L) {
               this.rdvdetails = false;
            } else {
               this.rdvdetails = true;
            }
         } else if (this.rdv.getRdvEtat() == 0 && !this.rdv.getRdvDteDe().before(var1) && this.rdv.getRdvIdPrincipal() == 0L && this.rdv.getRdvUsrDe() == this.userSelectionne.getUsrid()) {
            this.rdvdetails = false;
         } else {
            this.rdvdetails = true;
         }

         this.lesCollaborateursSelectionnes.clear();
         if (this.lesCollaborateurs.size() != 0) {
            new Users();

            for(int var3 = 0; var3 < this.lesCollaborateurs.size(); ++var3) {
               Users var2 = (Users)this.lesCollaborateurs.get(var3);
               if (var2.getUsrid() != this.userSelectionne.getUsrid()) {
                  var2.setSelectUser(false);
                  this.lesCollaborateursSelectionnes.add(var2);
               }
            }
         }

         this.chargerContactTiers();
         this.refCollaborateur = this.rdv.getRdvUsrDe();
         this.chargerMedecinService();
      }

   }

   public void consulterRdv() throws HibernateException, NamingException {
      if (this.rdv != null) {
         this.showModalPanelRdv = true;
         this.rdvdetails = true;
         this.compteRendu = true;
         this.choixTypeRdv();
         this.lesCollaborateursSelectionnes.clear();
         if (this.lesCollaborateurs.size() != 0) {
            new Users();

            for(int var2 = 0; var2 < this.lesCollaborateurs.size(); ++var2) {
               Users var1 = (Users)this.lesCollaborateurs.get(var2);
               if (var1.getUsrid() != this.userSelectionne.getUsrid()) {
                  var1.setSelectUser(false);
                  this.lesCollaborateursSelectionnes.add(var1);
               }
            }
         }

         this.chargerContactTiers();
         this.refCollaborateur = this.rdv.getRdvUsrDe();
         this.chargerMedecinService();
      }

   }

   public void chargerContactTiers() throws HibernateException, NamingException {
      this.lesContacts.clear();
      if (this.rdv.getRdvNature() == 1 || this.rdv.getRdvNature() == 8) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         String[] var3;
         String[] var4;
         int var5;
         int var6;
         int var8;
         if (this.rdv.getRdvTieIdDe() != 0L) {
            new Contacts();
            this.tiers = this.tiersDao.selectTierD(this.rdv.getRdvTieIdDe(), var1);
            if (this.tiers != null) {
               this.chargerMailsTiers();
               if (this.lesContacts.size() != 0 && this.rdv.getRdvMailContact() != null && !this.rdv.getRdvMailContact().isEmpty()) {
                  var3 = null;
                  Contacts var2;
                  if (!this.rdv.getRdvMailContact().contains("#")) {
                     var3 = this.rdv.getRdvMailContact().split(":");

                     for(var8 = 0; var8 < this.lesContacts.size(); ++var8) {
                        var2 = (Contacts)this.lesContacts.get(var8);
                        if (var2.getConpatronyme().equals(var3[0])) {
                           var2.setSelect(true);
                        }
                     }
                  } else {
                     var4 = this.rdv.getRdvMailContact().split("#");

                     for(var5 = 0; var5 < var4.length; ++var5) {
                        var3 = var4[var5].split(":");

                        for(var6 = 0; var6 < this.lesContacts.size(); ++var6) {
                           var2 = (Contacts)this.lesContacts.get(var6);
                           if (var2.getConpatronyme().equals(var3[0])) {
                              var2.setSelect(true);
                           }
                        }
                     }
                  }
               }
            }
         }

         if (this.rdv.getRdvCollaborateur() != null && !this.rdv.getRdvCollaborateur().isEmpty()) {
            new Users();
            if (this.lesCollaborateursSelectionnes.size() != 0 && this.rdv.getRdvCollaborateur() != null && !this.rdv.getRdvCollaborateur().isEmpty()) {
               var3 = null;
               Users var7;
               if (!this.rdv.getRdvCollaborateur().contains("#")) {
                  var3 = this.rdv.getRdvCollaborateur().split(":");

                  for(var8 = 0; var8 < this.lesCollaborateursSelectionnes.size(); ++var8) {
                     var7 = (Users)this.lesCollaborateursSelectionnes.get(var8);
                     if (var7.getUsrPatronyme().equals(var3[0])) {
                        var7.setSelectUser(true);
                     }
                  }
               } else {
                  var4 = this.rdv.getRdvCollaborateur().split("#");

                  for(var5 = 0; var5 < var4.length; ++var5) {
                     var3 = var4[var5].split(":");

                     for(var6 = 0; var6 < this.lesCollaborateursSelectionnes.size(); ++var6) {
                        var7 = (Users)this.lesCollaborateursSelectionnes.get(var6);
                        if (var7.getUsrPatronyme().equals(var3[0])) {
                           var7.setSelectUser(true);
                        }
                     }
                  }
               }
            }
         }
      }

      this.dataModelCollaborateur.setWrappedData(this.lesCollaborateursSelectionnes);
      this.dataModelContacts.setWrappedData(this.lesContacts);
      this.utilInitHibernate.closeSession();
   }

   public void supprimerRdv() throws HibernateException, NamingException, ParseException {
      if (this.rdv != null) {
         this.rdvDao.delete(this.rdv);
         this.chargerLesRdv();
      }

   }

   public void supprimerRdvJour() throws HibernateException, NamingException, ParseException {
      if (this.rdv != null) {
         this.rdvDao.delete(this.rdv);
         this.chargerLesRdvByJour();
      }

   }

   public void ajouterRdvCol01() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getLundi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol02() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getMardi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol03() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getMercredi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol04() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getJeudi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol05() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getVendredi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol06() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getSamedi());
         this.ajouterRdvMois(var3);
      }

   }

   public void ajouterRdvCol07() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         int var2 = this.parMois.getYear() + 1900;
         Date var3 = this.utilDate.stringToDateSQLLight(var2 + "-" + var1 + "-" + this.rdvSemaine.getDimanche());
         this.ajouterRdvMois(var3);
      }

   }

   public void modifierRdvCol01() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelLundi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelLundi().getRowData();
            this.modifierRdvMois();
         }
      }

   }

   public void modifierRdvCol02() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMardi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelMardi().getRowData();
            this.modifierRdvMois();
         }
      }

   }

   public void modifierRdvCol03() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMercredi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelMercredi().getRowData();
            this.modifierRdvMois();
         }
      }

   }

   public void modifierRdvCol04() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelJeudi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelJeudi().getRowData();
            this.modifierRdvMois();
         }
      }

   }

   public void modifierRdvCol05() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelVendredi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelVendredi().getRowData();
            this.modifierRdvMois();
         }
      }

   }

   public void modifierRdvCol06() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelSamedi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelSamedi().getRowData();
            this.modifierRdvMois();
         }
      }

   }

   public void modifierRdvCol07() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelDimanche().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelDimanche().getRowData();
            this.modifierRdvMois();
         }
      }

   }

   public void supprimerRdvCol01() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelLundi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelLundi().getRowData();
            if (this.rdv != null) {
               long var1 = this.rdv.getRdvId();
               this.rdvSemaine.getLesRdvJourJeudi().remove(this.rdv);
               ListDataModel var3 = new ListDataModel();
               var3.setWrappedData(this.rdvSemaine.getLesRdvJourLundi());
               this.rdvSemaine.setDataModelLundi(var3);
               this.rdvDao.delete(this.rdv);
               this.purgeRdvChaine(var1);
            }
         }
      }

   }

   public void supprimerRdvCol02() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMardi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelMardi().getRowData();
            if (this.rdv != null) {
               long var1 = this.rdv.getRdvId();
               this.rdvSemaine.getLesRdvJourMardi().remove(this.rdv);
               ListDataModel var3 = new ListDataModel();
               var3.setWrappedData(this.rdvSemaine.getLesRdvJourMardi());
               this.rdvSemaine.setDataModelMardi(var3);
               this.rdvDao.delete(this.rdv);
               this.purgeRdvChaine(var1);
            }
         }
      }

   }

   public void supprimerRdvCol03() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelMercredi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelMercredi().getRowData();
            if (this.rdv != null) {
               long var1 = this.rdv.getRdvId();
               this.rdvSemaine.getLesRdvJourMercredi().remove(this.rdv);
               ListDataModel var3 = new ListDataModel();
               var3.setWrappedData(this.rdvSemaine.getLesRdvJourMercredi());
               this.rdvSemaine.setDataModelMercredi(var3);
               this.rdvDao.delete(this.rdv);
               this.purgeRdvChaine(var1);
            }
         }
      }

   }

   public void supprimerRdvCol04() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelJeudi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelJeudi().getRowData();
            if (this.rdv != null) {
               long var1 = this.rdv.getRdvId();
               this.rdvSemaine.getLesRdvJourJeudi().remove(this.rdv);
               ListDataModel var3 = new ListDataModel();
               var3.setWrappedData(this.rdvSemaine.getLesRdvJourJeudi());
               this.rdvSemaine.setDataModelJeudi(var3);
               this.rdvDao.delete(this.rdv);
               this.purgeRdvChaine(var1);
            }
         }
      }

   }

   public void supprimerRdvCol05() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelVendredi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelVendredi().getRowData();
            if (this.rdv != null) {
               long var1 = this.rdv.getRdvId();
               this.rdvSemaine.getLesRdvJourVendredi().remove(this.rdv);
               ListDataModel var3 = new ListDataModel();
               var3.setWrappedData(this.rdvSemaine.getLesRdvJourVendredi());
               this.rdvSemaine.setDataModelVendredi(var3);
               this.rdvDao.delete(this.rdv);
               this.purgeRdvChaine(var1);
            }
         }
      }

   }

   public void supprimerRdvCol06() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelSamedi().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelSamedi().getRowData();
            if (this.rdv != null) {
               long var1 = this.rdv.getRdvId();
               this.rdvSemaine.getLesRdvJourSamedi().remove(this.rdv);
               ListDataModel var3 = new ListDataModel();
               var3.setWrappedData(this.rdvSemaine.getLesRdvJourSamedi());
               this.rdvSemaine.setDataModelSamedi(var3);
               this.rdvDao.delete(this.rdv);
               this.purgeRdvChaine(var1);
            }
         }
      }

   }

   public void supprimerRdvCol07() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParMois.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParMois.getRowData();
         if (this.rdvSemaine.getDataModelDimanche().isRowAvailable()) {
            this.rdv = (Rdv)this.rdvSemaine.getDataModelDimanche().getRowData();
            if (this.rdv != null) {
               long var1 = this.rdv.getRdvId();
               this.rdvSemaine.getLesRdvJourDimanche().remove(this.rdv);
               ListDataModel var3 = new ListDataModel();
               var3.setWrappedData(this.rdvSemaine.getLesRdvJourDimanche());
               this.rdvSemaine.setDataModelDimanche(var3);
               this.rdvDao.delete(this.rdv);
               this.purgeRdvChaine(var1);
            }
         }
      }

   }

   public void purgeRdvChaine(long var1) throws HibernateException, NamingException {
      new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         List var3 = this.rdvDao.chargerRdvInvite(var1, var4);
         if (var3.size() != 0) {
            for(int var6 = 0; var6 < var3.size(); ++var6) {
               this.rdv = (Rdv)var3.get(var6);
               this.rdvDao.delete(this.rdv, var4);
            }

            var5.commit();
         }
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void ajouterRdvCol01Semaine() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         String[] var1 = this.rdvSemaine.getHeure().split(":");
         String var2 = var1[0];
         String var3 = var1[1];
         Date var4 = this.calculeDate(this.dateLun);
         this.ajouterRdvMoisHeure(var4, var2, var3);
      }

   }

   public void ajouterRdvCol02Semaine() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         String[] var1 = this.rdvSemaine.getHeure().split(":");
         String var2 = var1[0];
         String var3 = var1[1];
         Date var4 = this.calculeDate(this.dateMar);
         this.ajouterRdvMoisHeure(var4, var2, var3);
      }

   }

   public void ajouterRdvCol03Semaine() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         String[] var1 = this.rdvSemaine.getHeure().split(":");
         String var2 = var1[0];
         String var3 = var1[1];
         Date var4 = this.calculeDate(this.dateMer);
         this.ajouterRdvMoisHeure(var4, var2, var3);
      }

   }

   public void ajouterRdvCol04Semaine() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         String[] var1 = this.rdvSemaine.getHeure().split(":");
         String var2 = var1[0];
         String var3 = var1[1];
         Date var4 = this.calculeDate(this.dateJeu);
         this.ajouterRdvMoisHeure(var4, var2, var3);
      }

   }

   public void ajouterRdvCol05Semaine() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         String[] var1 = this.rdvSemaine.getHeure().split(":");
         String var2 = var1[0];
         String var3 = var1[1];
         Date var4 = this.calculeDate(this.dateVen);
         this.ajouterRdvMoisHeure(var4, var2, var3);
      }

   }

   public void ajouterRdvCol06Semaine() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         String[] var1 = this.rdvSemaine.getHeure().split(":");
         String var2 = var1[0];
         String var3 = var1[1];
         Date var4 = this.calculeDate(this.dateSam);
         this.ajouterRdvMoisHeure(var4, var2, var3);
      }

   }

   public void ajouterRdvCol07Semaine() throws ParseException, HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         String[] var1 = this.rdvSemaine.getHeure().split(":");
         String var2 = var1[0];
         String var3 = var1[1];
         Date var4 = this.calculeDate(this.dateDim);
         this.ajouterRdvMoisHeure(var4, var2, var3);
      }

   }

   public void modifierRdvCol01Semaine() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdLundi() != 0L) {
            this.rdv = this.rdvDao.logRdv(this.rdvSemaine.getRdvIdLundi());
            if (this.rdv != null) {
               this.modifierRdvMois();
            }
         }
      }

   }

   public void modifierRdvCol02Semaine() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdMardi() != 0L) {
            this.rdv = this.rdvDao.logRdv(this.rdvSemaine.getRdvIdMardi());
            if (this.rdv != null) {
               this.modifierRdvMois();
            }
         }
      }

   }

   public void modifierRdvCol03Semaine() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdMercredi() != 0L) {
            this.rdv = this.rdvDao.logRdv(this.rdvSemaine.getRdvIdMercredi());
            if (this.rdv != null) {
               this.modifierRdvMois();
            }
         }
      }

   }

   public void modifierRdvCol04Semaine() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdJeudi() != 0L) {
            this.rdv = this.rdvDao.logRdv(this.rdvSemaine.getRdvIdJeudi());
            if (this.rdv != null) {
               this.modifierRdvMois();
            }
         }
      }

   }

   public void modifierRdvCol05Semaine() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdVendredi() != 0L) {
            this.rdv = this.rdvDao.logRdv(this.rdvSemaine.getRdvIdVendredi());
            if (this.rdv != null) {
               this.modifierRdvMois();
            }
         }
      }

   }

   public void modifierRdvCol06Semaine() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdSamedi() != 0L) {
            this.rdv = this.rdvDao.logRdv(this.rdvSemaine.getRdvIdSamedi());
            if (this.rdv != null) {
               this.modifierRdvMois();
            }
         }
      }

   }

   public void modifierRdvCol07Semaine() throws HibernateException, NamingException, ParseException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdDimanche() != 0L) {
            this.rdv = this.rdvDao.logRdv(this.rdvSemaine.getRdvIdDimanche());
            if (this.rdv != null) {
               this.modifierRdvMois();
            }
         }
      }

   }

   public void supprimerRdvCol01Semaine() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdLundi() != 0L) {
            this.rdvDao.delRdv(this.rdvSemaine.getRdvIdLundi());
            this.rdvSemaine.setLundi("");
            this.rdvSemaine.setRdvIdLundi(0L);
            this.rdvSemaine.setRdvUsrLundi(0L);
            this.rdvSemaine.setRdvEtatLundi(0);
         }
      }

   }

   public void supprimerRdvCol02Semaine() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdMardi() != 0L) {
            this.rdvDao.delRdv(this.rdvSemaine.getRdvIdMardi());
            this.rdvSemaine.setMardi("");
            this.rdvSemaine.setRdvIdMardi(0L);
            this.rdvSemaine.setRdvUsrMardi(0L);
            this.rdvSemaine.setRdvEtatMardi(0);
         }
      }

   }

   public void supprimerRdvCol03Semaine() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdMercredi() != 0L) {
            this.rdvDao.delRdv(this.rdvSemaine.getRdvIdMercredi());
            this.rdvSemaine.setMercredi("");
            this.rdvSemaine.setRdvIdMercredi(0L);
            this.rdvSemaine.setRdvUsrMercredi(0L);
            this.rdvSemaine.setRdvEtatMercredi(0);
         }
      }

   }

   public void supprimerRdvCol04Semaine() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdJeudi() != 0L) {
            this.rdvDao.delRdv(this.rdvSemaine.getRdvIdJeudi());
            this.rdvSemaine.setJeudi("");
            this.rdvSemaine.setRdvIdJeudi(0L);
            this.rdvSemaine.setRdvUsrJeudi(0L);
            this.rdvSemaine.setRdvEtatJeudi(0);
         }
      }

   }

   public void supprimerRdvCol05Semaine() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdVendredi() != 0L) {
            this.rdvDao.delRdv(this.rdvSemaine.getRdvIdVendredi());
            this.rdvSemaine.setVendredi("");
            this.rdvSemaine.setRdvIdVendredi(0L);
            this.rdvSemaine.setRdvUsrVendredi(0L);
            this.rdvSemaine.setRdvEtatVendredi(0);
         }
      }

   }

   public void supprimerRdvCol06Semaine() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdSamedi() != 0L) {
            this.rdvDao.delRdv(this.rdvSemaine.getRdvIdSamedi());
            this.rdvSemaine.setSamedi("");
            this.rdvSemaine.setRdvIdSamedi(0L);
            this.rdvSemaine.setRdvUsrSamedi(0L);
            this.rdvSemaine.setRdvEtatSamedi(0);
         }
      }

   }

   public void supprimerRdvCol07Semaine() throws HibernateException, NamingException {
      if (this.datamodelLesRdvParSemaine.isRowAvailable()) {
         this.rdvSemaine = (RdvSemaine)this.datamodelLesRdvParSemaine.getRowData();
         if (this.rdvSemaine.getRdvIdDimanche() != 0L) {
            this.rdvDao.delRdv(this.rdvSemaine.getRdvIdDimanche());
            this.rdvSemaine.setDimanche("");
            this.rdvSemaine.setRdvIdDimanche(0L);
            this.rdvSemaine.setRdvUsrDimanche(0L);
            this.rdvSemaine.setRdvEtatDimanche(0);
         }
      }

   }

   public void reporterRdv() {
      if (this.rdv != null) {
         this.dateReport = new Date();
         this.heureReport = this.rdv.getRdvHrDe();
         this.minuteReport = this.rdv.getRdvMnDe();
         this.motifReport = "Rdv Reporté";
         this.showModalPanelReport = true;
      }

   }

   public void fermerReportRdv() {
      if (this.rdv != null) {
         this.showModalPanelReport = false;
      }

   }

   public void validerReport() throws HibernateException, NamingException, ParseException, Exception {
      byte var1 = 0;
      if (this.rdv != null && this.dateReport != null) {
         if (this.gestionPatient) {
            this.rdvDao.delete(this.rdv);
         } else {
            this.rdv.setRdvEtat(2);
            this.rdv.setRdvCr(this.motifReport);
            this.rdv = this.rdvDao.modif(this.rdv);
         }

         if ((this.rdv.getRdvNature() == 1 || this.rdv.getRdvNature() == 8) && this.rdv.getRdvMailContact() != null && !this.rdv.getRdvMailContact().isEmpty()) {
            UtilMail var2 = new UtilMail(this.structureLog);
            String var3 = "";
            var3 = var2.envoieMailRdv(this.structureLog, this.userSelectionne, this.rdv, this.utilDate);
            if (var3 != null && !var3.isEmpty()) {
               this.rdv.setRdvStatut(var3);
               this.rdv.setRdvErreur(true);
               this.rdv = this.rdvDao.modif(this.rdv);
            }
         }

         Rdv var4 = new Rdv();
         var4.setUsers(this.rdv.getUsers());
         var4.setRdvCr((String)null);
         var4.setRdvCollaborateur(this.rdv.getRdvCollaborateur());
         var4.setRdvIdPrincipal(0L);
         var4.setRdvDateCreation(new Date());
         var4.setRdvDescript(this.rdv.getRdvDescript());
         var4.setRdvDiversNom(this.rdv.getRdvDiversNom());
         var4.setRdvDiversTiers(this.rdv.getRdvDiversTiers());
         var4.setRdvDteDe(this.dateReport);
         var4.setRdvDteExec((Date)null);
         var4.setRdvDteFi((Date)null);
         var4.setRdvEtat(0);
         var4.setRdvHrDe(this.heureReport);
         var4.setRdvHrDuree(this.rdv.getRdvHrDuree());
         var4.setRdvHrFi((String)null);
         var4.setRdvLieu(this.rdv.getRdvLieu());
         var4.setRdvMailContact(this.rdv.getRdvMailContact());
         var4.setRdvMnDe(this.minuteReport);
         var4.setRdvMnDuree(this.rdv.getRdvMnDuree());
         var4.setRdvMnFi((String)null);
         var4.setRdvMode(this.rdv.getRdvMode());
         var4.setRdvNature(this.rdv.getRdvNature());
         var4.setRdvNomPat(this.rdv.getRdvNomPat());
         var4.setRdvNomSal(this.rdv.getRdvNomSal());
         var4.setRdvNomTiers(this.rdv.getRdvNomTiers());
         var4.setRdvNomUsers(this.rdv.getRdvNomUsers());
         var4.setRdvPatIdDe(this.rdv.getRdvPatIdDe());
         var4.setRdvSalIdDe(this.rdv.getRdvSalIdDe());
         var4.setRdvSujet(this.rdv.getRdvSujet());
         var4.setRdvTache(this.rdv.getRdvTache());
         var4.setRdvTachePr(this.rdv.getRdvTachePr());
         var4.setRdvTachePv(this.rdv.getRdvTachePv());
         var4.setRdvTieIdDe(this.rdv.getRdvTieIdDe());
         var4.setRdvUsrDe(this.rdv.getRdvUsrDe());
         var4 = this.rdvDao.insert(var4);
         this.generationMailInvitation(var4, this.rdv.getRdvId(), var1);
      }

      this.showModalPanelRdv = false;
      this.showModalPanelReport = false;
      this.afficheRdv = false;
   }

   public void choixTypeRdv() {
      if (this.rdv.getRdvNature() != 0 && this.rdv.getRdvNature() != 6 && this.rdv.getRdvNature() != 13) {
         if (this.rdv.getRdvNature() != 2 && this.rdv.getRdvNature() != 10 && this.rdv.getRdvNature() != 11) {
            if (this.rdv.getRdvNature() == 9) {
               this.typeRdv = 9;
            } else {
               this.typeRdv = 0;
            }
         } else {
            this.typeRdv = 2;
         }
      } else {
         this.typeRdv = 1;
      }

   }

   public void saveEvent() throws HibernateException, NamingException, ParseException, Exception {
      boolean var1 = false;
      if (this.optionTiers.getZoneObligatoire().equals("0")) {
         if (this.rdv.getNomTiers() != null && !this.rdv.getRdvNomTiers().isEmpty() || this.rdv.getRdvNomPat() != null && !this.rdv.getRdvNomPat().isEmpty()) {
            var1 = true;
         }
      } else if (this.optionTiers.getZoneObligatoire().equals("1")) {
         if ((this.rdv.getNomTiers() != null && !this.rdv.getRdvNomTiers().isEmpty() || this.rdv.getRdvNomPat() != null && !this.rdv.getRdvNomPat().isEmpty()) && this.rdv.getRdvSujet() != null && !this.rdv.getRdvSujet().isEmpty() && !this.rdv.getRdvSujet().equals("pas de sujet")) {
            var1 = true;
         }
      } else if (this.optionTiers.getZoneObligatoire().equals("2")) {
         if ((this.rdv.getNomTiers() != null && !this.rdv.getRdvNomTiers().isEmpty() || this.rdv.getRdvNomPat() != null && !this.rdv.getRdvNomPat().isEmpty()) && this.rdv.getRdvSujet() != null && !this.rdv.getRdvSujet().isEmpty() && !this.rdv.getRdvSujet().equals("pas de sujet") && this.rdv.getRdvTache() != null && !this.rdv.getRdvTache().isEmpty() && !this.rdv.getRdvTache().equals("pas d`action")) {
            var1 = true;
         }
      } else if (this.optionTiers.getZoneObligatoire().equals("3") && (this.rdv.getNomTiers() != null && !this.rdv.getRdvNomTiers().isEmpty() || this.rdv.getRdvNomPat() != null && !this.rdv.getRdvNomPat().isEmpty()) && this.rdv.getRdvSujet() != null && !this.rdv.getRdvSujet().isEmpty() && this.rdv.getRdvTache() != null && !this.rdv.getRdvTache().isEmpty() && !this.rdv.getRdvTache().equals("pas d`action") && this.rdv.getRdvCr() != null && !this.rdv.getRdvCr().isEmpty()) {
         var1 = true;
      }

      if (var1) {
         boolean var2 = false;
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         Transaction var4 = null;

         byte var14;
         try {
            var4 = var3.beginTransaction();
            if (this.refCollaborateur != 0L) {
               this.rdv.setRdvUsrDe(this.refCollaborateur);
               this.rdv.setRdvNomUsers(this.userDao.selectUserD(this.refCollaborateur, var3).getUsrPatronyme());
            } else {
               this.rdv.setRdvUsrDe(0L);
               this.rdv.setRdvNomUsers("");
            }

            if (!this.actionRdv) {
               if (this.choixTache != null && !this.choixTache.isEmpty() && this.choixTache.contains(":")) {
                  String[] var5 = this.choixTache.split(":");
                  this.rdv.setRdvTache(var5[0]);
                  this.tachesDao = new TachesDao(this.baseLog, this.utilInitHibernate);
                  new Taches();
                  Taches var6 = this.tachesDao.rechercheTache(var5[0], var3);
                  if (var6 != null) {
                     this.rdv.setRdvTache(var6.getTacCode());
                     this.rdv.setRdvTachePr(var6.getTacValPr());
                     this.rdv.setRdvTachePv(var6.getTacValPr());
                  } else {
                     this.rdv.setRdvTache("");
                     this.rdv.setRdvTachePr(0.0F);
                     this.rdv.setRdvTachePv(0.0F);
                  }
               } else {
                  this.rdv.setRdvTache("");
                  this.rdv.setRdvTachePr(0.0F);
                  this.rdv.setRdvTachePv(0.0F);
               }
            }

            if (this.rdv.getRdvNature() == 10) {
               this.rdv.setRdvDteDe((Date)null);
            } else if (this.rdv.getRdvDteDe() == null) {
               this.rdv.setRdvDteDe(new Date());
            }

            if (this.rdv.getRdvNature() != 1 && this.rdv.getRdvNature() != 8) {
               this.rdv.setRdvMailContact((String)null);
            }

            this.rdv.setRdvMailContact((String)null);
            int var8;
            String var15;
            boolean var16;
            if ((this.rdv.getRdvNature() == 1 || this.rdv.getRdvNature() == 8) && this.lesContacts.size() != 0) {
               var15 = "";
               var16 = true;
               new Contacts();

               for(var8 = 0; var8 < this.lesContacts.size(); ++var8) {
                  Contacts var7 = (Contacts)this.lesContacts.get(var8);
                  if (var7.isSelect()) {
                     if (var16) {
                        var16 = false;
                        var15 = var7.getConpatronyme() + ":" + var7.getMailCumul();
                     } else {
                        var15 = var15 + "#" + var7.getConpatronyme() + ":" + var7.getMailCumul();
                     }
                  }
               }

               this.rdv.setRdvMailContact(var15);
            }

            this.rdv.setRdvCollaborateur((String)null);
            if ((this.rdv.getRdvNature() == 1 || this.rdv.getRdvNature() == 8) && this.lesCollaborateursSelectionnes.size() != 0) {
               var15 = "";
               var16 = true;
               new Users();

               for(var8 = 0; var8 < this.lesCollaborateursSelectionnes.size(); ++var8) {
                  Users var17 = (Users)this.lesCollaborateursSelectionnes.get(var8);
                  if (var17.isSelectUser()) {
                     if (var16) {
                        var16 = false;
                        var15 = var17.getUsrPatronyme() + ":" + var17.getUsrid() + ":" + var17.getUsrCivilite() + ":" + var17.getUsrMail();
                     } else {
                        var15 = var15 + "#" + var17.getUsrPatronyme() + ":" + var17.getUsrid() + ":" + var17.getUsrCivilite() + ":" + var17.getUsrMail();
                     }
                  }
               }

               this.rdv.setRdvCollaborateur(var15);
            }

            if (this.rdv.getRdvId() == 0L) {
               var14 = 0;
               this.rdv.setRdvDateCreation(new Date());
               this.rdv.setRdvEtat(0);
               if (this.userSelectionne != null) {
                  this.rdv.setUsers(this.userSelectionne);
               } else {
                  this.rdv.setUsers(this.usersLog);
               }

               this.rdv = this.rdvDao.insert(this.rdv, var3);
            } else {
               var14 = 1;
               this.rdv = this.rdvDao.modif(this.rdv, var3);
            }

            var4.commit();
         } catch (HibernateException var12) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.generationProchainRdv(this.rdv, this.rdv.getRdvId());
         this.generationMailInvitation(this.rdv, this.rdv.getRdvId(), var14);
         this.afficheRdv = false;
         this.showModalPanelRdv = false;
      }

   }

   public void generationProchainRdv(Rdv var1, long var2) throws HibernateException, NamingException {
      if (var1.getRdvDateProchaine() != null) {
         Rdv var4;
         if (this.optionTiers.getMajTodo().equals("1") || this.optionTiers.getMajTodo().equals("3")) {
            new Rdv();
            var4 = this.rdvDao.logRdvIdPrincipalRdv(var2, (Session)null);
            if (var4 == null) {
               var4 = new Rdv();
            }

            var4.setUsers(this.usersLog);
            var4.setRdvDateCreation(new Date());
            var4.setRdvDiversNom(var1.getRdvDiversNom());
            var4.setRdvDteDe(var1.getRdvDateProchaine());
            var4.setRdvHrDe(var1.getRdvHrDe());
            var4.setRdvMnDe(var1.getRdvMnDe());
            var4.setRdvIdPrincipalRdv(var2);
            var4.setRdvLieu(var1.getRdvLieu());
            var4.setRdvMode(var1.getRdvMode());
            var4.setRdvNature(var1.getRdvNature());
            var4.setRdvNomPat(var1.getRdvNomPat());
            var4.setRdvNomSal(var1.getRdvNomSal());
            var4.setRdvNomTiers(var1.getRdvNomTiers());
            var4.setRdvNomUsers(var1.getRdvNomUsers());
            var4.setRdvPatIdDe(var1.getRdvPatIdDe());
            var4.setRdvSalIdDe(var1.getRdvSalIdDe());
            var4.setRdvService(var1.getRdvService());
            if (var1.getRdvTache() != null && !var1.getRdvTache().isEmpty()) {
               var4.setRdvSujet(var1.getRdvTache());
            } else {
               var4.setRdvSujet(var1.getRdvSujet());
            }

            var4.setRdvTieIdDe(var1.getRdvTieIdDe());
            var4.setRdvUsrDe(var1.getRdvUsrDe());
            if (var4.getRdvId() == 0L) {
               this.rdvDao.insert(var4);
            } else {
               this.rdvDao.modif(var4);
            }
         }

         if (this.optionTiers.getMajTodo().equals("2") || this.optionTiers.getMajTodo().equals("3")) {
            new Rdv();
            var4 = this.rdvDao.logRdvIdPrincipalTodo(var2, (Session)null);
            if (var4 == null) {
               var4 = new Rdv();
            }

            var4.setUsers(this.usersLog);
            var4.setRdvDateCreation(new Date());
            var4.setRdvDiversNom(var1.getRdvDiversNom());
            var4.setRdvDteDe(var1.getRdvDateProchaine());
            var4.setRdvHrDe(var1.getRdvHrDe());
            var4.setRdvMnDe(var1.getRdvMnDe());
            var4.setRdvIdPrincipalRdv(var2);
            var4.setRdvLieu(var1.getRdvLieu());
            var4.setRdvMode(var1.getRdvMode());
            var4.setRdvNature(2);
            var4.setRdvNomPat(var1.getRdvNomPat());
            var4.setRdvNomSal(var1.getRdvNomSal());
            var4.setRdvNomTiers(var1.getRdvNomTiers());
            var4.setRdvNomUsers(var1.getRdvNomUsers());
            var4.setRdvPatIdDe(var1.getRdvPatIdDe());
            var4.setRdvSalIdDe(var1.getRdvSalIdDe());
            var4.setRdvService(var1.getRdvService());
            if (var1.getRdvTache() != null && !var1.getRdvTache().isEmpty()) {
               var4.setRdvSujet(var1.getRdvTache());
            } else {
               var4.setRdvSujet(var1.getRdvSujet());
            }

            var4.setRdvTieIdDe(var1.getRdvTieIdDe());
            var4.setRdvUsrDe(var1.getRdvUsrDe());
            if (var4.getRdvId() == 0L) {
               this.rdvDao.insert(var4);
            } else {
               this.rdvDao.modif(var4);
            }
         }
      }

   }

   public void generationMailInvitation(Rdv var1, long var2, int var4) throws Exception {
      String var6;
      if (StaticModePegase.getInternet_actif() >= 1 && (var1.getRdvNature() == 1 || var1.getRdvNature() == 8) && (var4 == 0 || var4 != 0 && var1.getRdvStatut() != null && !var1.getRdvStatut().isEmpty()) && var1.getRdvMailContact() != null && !var1.getRdvMailContact().isEmpty()) {
         UtilMail var5 = new UtilMail(this.structureLog);
         var6 = "";
         var6 = var5.envoieMailRdv(this.structureLog, this.userSelectionne, var1, this.utilDate);
         if (var6 != null && !var6.isEmpty()) {
            var1.setRdvStatut(var6);
            var1.setRdvErreur(true);
            var1 = this.rdvDao.modif(this.rdv);
         } else if (var1.getRdvStatut() != null && !var1.getRdvStatut().isEmpty()) {
            var1.setRdvStatut("");
            var1.setRdvErreur(false);
            var1 = this.rdvDao.modif(this.rdv);
         }
      }

      if (var1.getRdvNature() == 1 || var1.getRdvNature() == 8) {
         Session var18 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         var6 = null;

         try {
            Transaction var19 = var18.beginTransaction();
            new ArrayList();
            List var7 = this.rdvDao.chargerRdvInvite(var2, var18);
            if (var7.size() != 0) {
               new Rdv();

               for(int var9 = 0; var9 < var7.size(); ++var9) {
                  Rdv var8 = (Rdv)var7.get(var9);
                  this.rdvDao.delete(var8, var18);
               }
            }

            long var20 = 0L;
            if (var1.getRdvCollaborateur() != null && !var1.getRdvCollaborateur().isEmpty() && var1.getRdvCollaborateur() != null && !var1.getRdvCollaborateur().isEmpty()) {
               String[] var10 = null;
               if (!var1.getRdvCollaborateur().contains("#")) {
                  var10 = var1.getRdvCollaborateur().split(":");
                  var20 = Long.parseLong(var10[1]);
                  this.generationInvitation(var1, var20, var18);
               } else {
                  String[] var11 = var1.getRdvCollaborateur().split("#");

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     var10 = var11[var12].split(":");
                     var20 = Long.parseLong(var10[1]);
                     this.generationInvitation(var1, var20, var18);
                  }
               }
            }

            var19.commit();
         } catch (HibernateException var16) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var16;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      if (this.modeRdv == 0) {
         this.chargerLesRdvByMois();
      } else if (this.modeRdv == 1) {
         this.chargerLesRdvBySemaine();
      } else if (this.modeRdv == 2) {
         this.chargerLesRdvByJour();
      } else if (this.modeRdv == 3) {
      }

   }

   public void generationInvitation(Rdv var1, long var2, Session var4) throws HibernateException, NamingException {
      new Users();
      Users var5 = this.userDao.selectUserD(var2, var4);
      if (var5 != null) {
         Rdv var6 = new Rdv();
         var6.setUsers(var5);
         var6.setRdvCr(var1.getRdvCr());
         var6.setRdvCollaborateur((String)null);
         if ((var1.getRdvNature() == 1 || var1.getRdvNature() == 8) && this.lesCollaborateursSelectionnes.size() != 0) {
            String var7 = "";
            boolean var8 = true;
            new Users();

            for(int var10 = 0; var10 < this.lesCollaborateursSelectionnes.size(); ++var10) {
               Users var9 = (Users)this.lesCollaborateursSelectionnes.get(var10);
               if (var9.getUsrid() != var2 && var9.isSelectUser()) {
                  if (var8) {
                     var8 = false;
                     var7 = var9.getUsrPatronyme() + ":" + var9.getUsrid() + ":" + var9.getUsrCivilite() + ":" + var9.getUsrMail();
                  } else {
                     var7 = var7 + "#" + var9.getUsrPatronyme() + ":" + var9.getUsrid() + ":" + var9.getUsrCivilite() + ":" + var9.getUsrMail();
                  }
               }
            }

            if (var8) {
               var8 = false;
               var7 = this.userSelectionne.getUsrPatronyme() + ":" + this.userSelectionne.getUsrid() + ":" + this.userSelectionne.getUsrCivilite() + ":" + this.userSelectionne.getUsrMail();
            } else {
               var7 = var7 + "#" + this.userSelectionne.getUsrPatronyme() + ":" + this.userSelectionne.getUsrid() + ":" + this.userSelectionne.getUsrCivilite() + ":" + this.userSelectionne.getUsrMail();
            }

            var6.setRdvCollaborateur(var7);
         }

         var6.setRdvIdPrincipal(var1.getRdvId());
         var6.setRdvDateCreation(var1.getRdvDateCreation());
         var6.setRdvDescript(var1.getRdvDescript());
         var6.setRdvDiversNom(var1.getRdvDiversNom());
         var6.setRdvDiversTiers(var1.getRdvDiversTiers());
         var6.setRdvDteDe(var1.getRdvDteDe());
         var6.setRdvDteExec((Date)null);
         var6.setRdvDteFi(var1.getRdvDteFi());
         var6.setRdvEtat(var1.getRdvEtat());
         var6.setRdvHrDe(var1.getRdvHrDe());
         var6.setRdvHrDuree(var1.getRdvHrDuree());
         var6.setRdvHrFi(var1.getRdvHrFi());
         var6.setRdvLieu(var1.getRdvLieu());
         var6.setRdvMailContact(var1.getRdvMailContact());
         var6.setRdvMnDe(var1.getRdvMnDe());
         var6.setRdvMnDuree(var1.getRdvMnDuree());
         var6.setRdvMnFi(var1.getRdvMnFi());
         var6.setRdvMode(var1.getRdvMode());
         var6.setRdvNature(var1.getRdvNature());
         var6.setRdvNomPat(var1.getRdvNomPat());
         var6.setRdvNomSal(var1.getRdvNomSal());
         var6.setRdvNomTiers(var1.getRdvNomTiers());
         var6.setRdvNomUsers(var5.getUsrPatronyme());
         var6.setRdvPatIdDe(var1.getRdvPatIdDe());
         var6.setRdvSalIdDe(var1.getRdvSalIdDe());
         var6.setRdvSujet(var1.getRdvSujet());
         var6.setRdvTache(var1.getRdvTache());
         var6.setRdvTachePr(var1.getRdvTachePr());
         var6.setRdvTachePv(var1.getRdvTachePv());
         var6.setRdvTieIdDe(var1.getRdvTieIdDe());
         var6.setRdvUsrDe(var5.getUsrid());
         this.rdvDao.insert(var6, var4);
      }

   }

   public void annule() {
      this.afficheRdv = false;
      this.showModalPanelRdv = false;
   }

   public void rechercheTiers() throws HibernateException, NamingException {
      this.lesTiers = new ArrayList();
      this.dataModelHistorique = new ListDataModel();
      if (this.rdv.getRdvNomTiers() != null && !this.rdv.getRdvNomTiers().isEmpty()) {
         this.lesTiers = this.tiersDao.verifTiers(this.usersLog, "", this.rdv.getRdvNomTiers(), (Session)null);
         if (this.lesTiers.size() != 0) {
            this.datamodelTiers.setWrappedData(this.lesTiers);
            this.showModalPanelTiers = true;
         } else {
            this.tiers = null;
            this.rdv.setRdvNomTiers("");
            this.rdv.setRdvTieIdDe(0L);
         }
      }

   }

   public void selectionTiers() {
      if (this.datamodelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
      }

   }

   public void calculeTiers() throws HibernateException, NamingException {
      if (this.lesTiers.size() != 0) {
         if (this.tiers != null) {
            if (this.tiers.getTieprenom() != null) {
               this.rdv.setRdvNomTiers(this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom());
            } else {
               this.rdv.setRdvNomTiers(this.tiers.getTieraisonsocialenom());
            }

            this.rdv.setRdvTieIdDe(this.tiers.getTieid());
            this.chargerMailsTiers();
            this.dataModelContacts.setWrappedData(this.lesContacts);
            new ArrayList();
            List var1 = this.rdvDao.chargerRdvTiers(99, this.tiers.getTieid(), (Session)null);
            this.dataModelHistorique.setWrappedData(var1);
         } else {
            this.annuleTiers();
         }
      } else {
         this.annuleTiers();
      }

      this.showModalPanelTiers = false;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.rdv.setRdvNomTiers("");
      this.rdv.setRdvTieIdDe(0L);
      this.lesContacts.clear();
      this.dataModelContacts.setWrappedData(this.lesContacts);
      ArrayList var1 = new ArrayList();
      this.dataModelHistorique.setWrappedData(var1);
      this.showModalPanelTiers = false;
   }

   public void chargerMailsTiers() throws HibernateException, NamingException {
      this.lesContacts.clear();
      this.lesContacts = this.contactDao.listContactByTiersMail(this.tiers);
      Contacts var1;
      if (this.tiers.getTiemail1() != null && !this.tiers.getTiemail1().isEmpty()) {
         var1 = new Contacts();
         var1.setConpatronyme(this.tiers.getTieraisonsocialenom() + "(1)");
         var1.setConmail1(this.tiers.getTiemail1());
         this.lesContacts.add(var1);
      }

      if (this.tiers.getTiemail2() != null && !this.tiers.getTiemail2().isEmpty()) {
         var1 = new Contacts();
         var1.setConpatronyme(this.tiers.getTieraisonsocialenom() + "(2)");
         var1.setConmail1(this.tiers.getTiemail2());
         this.lesContacts.add(var1);
      }

      if (this.tiers.getTiemail3() != null && !this.tiers.getTiemail3().isEmpty()) {
         var1 = new Contacts();
         var1.setConpatronyme(this.tiers.getTieraisonsocialenom() + "(3)");
         var1.setConmail1(this.tiers.getTiemail3());
         this.lesContacts.add(var1);
      }

      if (this.tiers.getTiemail4() != null && !this.tiers.getTiemail4().isEmpty()) {
         var1 = new Contacts();
         var1.setConpatronyme(this.tiers.getTieraisonsocialenom() + "(4)");
         var1.setConmail1(this.tiers.getTiemail4());
         this.lesContacts.add(var1);
      }

      if (this.tiers.getTiemail5() != null && !this.tiers.getTiemail5().isEmpty()) {
         var1 = new Contacts();
         var1.setConpatronyme(this.tiers.getTieraisonsocialenom() + "(5)");
         var1.setConmail1(this.tiers.getTiemail5());
         this.lesContacts.add(var1);
      }

   }

   public void recherchePatients() throws HibernateException, NamingException {
      this.lesPatients = new ArrayList();
      this.dataModelHistorique = new ListDataModel();
      if (this.rdv.getRdvNomPat() != null && !this.rdv.getRdvNomPat().isEmpty()) {
         this.lesPatients = this.patientsDao.chargerlesPatients(this.rdv.getRdvNomPat(), (Session)null);
         if (this.lesPatients.size() != 0) {
            this.datamodelPatients.setWrappedData(this.lesPatients);
            this.showModalPanelPatients = true;
         } else {
            this.patients = null;
            this.rdv.setRdvNomPat("");
            this.rdv.setRdvPatIdDe(0L);
         }
      }

   }

   public void selectionPatients() {
      if (this.datamodelPatients.isRowAvailable()) {
         this.patients = (Patients)this.datamodelPatients.getRowData();
      }

   }

   public void calculePatients() throws HibernateException, NamingException {
      if (this.lesPatients.size() != 0) {
         if (this.patients != null) {
            if (this.patients.getPatPrenom() != null) {
               this.rdv.setRdvNomPat(this.patients.getPatNom() + " " + this.patients.getPatPrenom());
            } else {
               this.rdv.setRdvNomPat(this.patients.getPatNom());
            }

            this.rdv.setRdvPatIdDe(this.patients.getPatId());
            new ArrayList();
            List var1 = this.rdvDao.chargerRdvTiers(99, this.patients.getPatId(), (Session)null);
            this.dataModelHistorique.setWrappedData(var1);
         } else {
            this.patients = null;
            this.rdv.setRdvNomPat("");
            this.rdv.setRdvPatIdDe(0L);
         }
      } else {
         this.patients = null;
         this.rdv.setRdvNomPat("");
         this.rdv.setRdvPatIdDe(0L);
      }

      this.showModalPanelPatients = false;
   }

   public void annulePatients() {
      this.patients = null;
      this.rdv.setRdvNomPat("");
      this.rdv.setRdvPatIdDe(0L);
      this.showModalPanelPatients = false;
   }

   public void traitementAndroide() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "TraitementAndroid");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new Android();
         new ArrayList();
         AndroidDao var5 = new AndroidDao(this.baseLog, this.utilInitHibernate);
         var5.majidTier(var1);
         var1.flush();
         List var4 = var5.selectAndroid(var1);
         if (var4.size() != 0) {
            int var6 = 0;

            label270:
            while(true) {
               Android var3;
               if (var6 >= var4.size()) {
                  var6 = 0;

                  while(true) {
                     if (var6 >= var4.size()) {
                        break label270;
                     }

                     var3 = (Android)var4.get(var6);
                     var5.delete(var3, var1);
                     ++var6;
                  }
               }

               var3 = (Android)var4.get(var6);
               if (var3.getEveHoraire() != null && (var3.getEveCategorie() != 1 || var3.getEveNature() != 1) && (var3.getEveCategorie() != 1 || var3.getEveNature() != 2) && (var3.getEveCategorie() != 1 || var3.getEveNature() != 3) && (var3.getEveCategorie() != 1 || var3.getEveNature() != 4)) {
                  if (var3.getEveCategorie() == 1 && var3.getEveNature() == 5) {
                     this.casNotes(var3, var1);
                  } else if (var3.getEveCategorie() == 2 && var3.getEveNature() == 1) {
                     this.casFrais(var3, var1);
                  } else if (var3.getEveCategorie() == 3 && var3.getEveNature() == 1) {
                     this.casDebutRdvCommercial(0, var3, var1);
                  } else if (var3.getEveCategorie() == 3 && var3.getEveNature() == 2) {
                     this.casDebutRdvCommercial(1, var3, var1);
                  } else if (var3.getEveCategorie() == 3 && var3.getEveNature() == 3) {
                     this.casFinRdvCommercial(var3, var1);
                  } else if (var3.getEveCategorie() != 4 && var3.getEveCategorie() != 5 && (var3.getEveCategorie() != 6 || var3.getEveNature() != 1) && (var3.getEveCategorie() != 6 || var3.getEveNature() != 2)) {
                     if (var3.getEveCategorie() == 6 && var3.getEveNature() == 3) {
                        this.casMvtsRonde(var3, var4, var1);
                     } else if ((var3.getEveCategorie() != 7 || var3.getEveNature() != 1) && (var3.getEveCategorie() != 7 || var3.getEveNature() != 2) && var3.getEveCategorie() == 7 && var3.getEveNature() == 3) {
                     }
                  }
               }

               ++var6;
            }
         }

         var2.commit();
      } catch (HibernateException var10) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void casDebutRdvCommercial(int var1, Android var2, Session var3) throws ParseException, HibernateException, NamingException {
      this.rdv = new Rdv();
      this.tiersRecup = new Tiers();
      this.userRecup = new Users();
      this.rdv.setRdvDateCreation(new Date());
      this.rdv.setRdvDteExec((Date)null);
      this.rdv.setRdvErreur(false);
      this.rdv.setRdvEtat(1);
      this.rdv.setRdvIdPrincipal(var2.getEveId());
      this.rdv.setRdvStatut((String)null);
      if (var1 == 0) {
         this.rdv.setRdvSujet("Visite Android (debut)");
         this.rdv.setRdvNature(4);
      } else if (var1 == 1) {
         this.rdv.setRdvSujet("Intervention ANDROID (debut)");
         this.rdv.setRdvNature(5);
      } else {
         this.rdv.setRdvSujet("RDV Android (debut)");
         this.rdv.setRdvNature(1);
      }

      this.rdv.setRdvDteDe(this.utilDate.dateToSQLLight(var2.getEveHoraire()));
      if (var2.getEveHoraire().getHours() <= 9) {
         this.rdv.setRdvHrDe("0" + var2.getEveHoraire().getHours());
      } else {
         this.rdv.setRdvHrDe("" + var2.getEveHoraire().getHours());
      }

      if (var2.getEveHoraire().getMinutes() <= 9) {
         this.rdv.setRdvMnDe("0" + var2.getEveHoraire().getMinutes());
      } else {
         this.rdv.setRdvMnDe("" + var2.getEveHoraire().getMinutes());
      }

      this.rdv.setRdvPatIdDe(0L);
      this.rdv.setRdvSalIdDe(0L);
      this.rdv.setRdvNomPat((String)null);
      this.rdv.setRdvNomSal((String)null);
      if (var2.getEveIdTie() != 0L) {
         this.tiersRecup = this.tiersDao.selectTierD(var2.getEveIdTie(), var3);
         if (this.tiersRecup != null) {
            this.rdv.setRdvTieIdDe(var2.getEveIdTie());
            this.rdv.setRdvNomTiers(var2.getEveTieRaisonSocialeNom());
            this.rdv.setRdvDiversNom((String)null);
            this.rdv.setRdvDiversTiers(0);
         } else {
            this.tiersRecup = new Tiers();
            this.tiersRecup.setTietype("1");
            this.tiersRecup.setTiegenre("011");
            this.tiersRecup.setTiecategorie("Suspect Société");
            this.tiersRecup.setTieraisonsocialenom(var2.getEveTieRaisonSocialeNom());
            this.tiersRecup.setTiecodepays(this.structureLog.getStrcodepays());
            this.tiersRecup.setTienompays(this.structureLog.getStrnompays());
            this.tiersRecup.setTiedevise(this.structureLog.getStrdevise());
            this.tiersRecup.setTieFormatDevise(this.structureLog.getStrformatdevise());
            this.tiersRecup.setTielangue(this.structureLog.getStrlangue());
            this.tiersRecup.setTienoteman("Plomb");
            this.tiersRecup.setTiedatecreat(new Date());
            this.tiersRecup.setTieusercreat(this.userRecup.getUsrid());
            this.tiersRecup = this.tiersDao.insert(this.tiersRecup, var3);
            this.rdv.setRdvTieIdDe(var2.getEveIdTie());
            this.rdv.setRdvNomTiers(var2.getEveTieRaisonSocialeNom());
            this.rdv.setRdvDiversNom((String)null);
            this.rdv.setRdvDiversTiers(0);
         }
      } else if (var2.getEveTieRaisonSocialeNom() != null && !var2.getEveTieRaisonSocialeNom().isEmpty()) {
         this.tiersRecup = new Tiers();
         this.tiersRecup.setTietype("1");
         this.tiersRecup.setTiegenre("011");
         this.tiersRecup.setTiecategorie("Suspect Société");
         this.tiersRecup.setTieraisonsocialenom(var2.getEveTieRaisonSocialeNom());
         this.tiersRecup.setTiecodepays(this.structureLog.getStrcodepays());
         this.tiersRecup.setTienompays(this.structureLog.getStrnompays());
         this.tiersRecup.setTiedevise(this.structureLog.getStrdevise());
         this.tiersRecup.setTieFormatDevise(this.structureLog.getStrformatdevise());
         this.tiersRecup.setTielangue(this.structureLog.getStrlangue());
         this.tiersRecup.setTienoteman("Plomb");
         this.tiersRecup.setTiedatecreat(new Date());
         this.tiersRecup.setTieusercreat(this.userRecup.getUsrid());
         this.tiersRecup = this.tiersDao.insert(this.tiersRecup, var3);
         this.rdv.setRdvTieIdDe(var2.getEveIdTie());
         this.rdv.setRdvNomTiers(var2.getEveTieRaisonSocialeNom());
         this.rdv.setRdvDiversNom((String)null);
         this.rdv.setRdvDiversTiers(0);
      } else {
         this.rdv.setRdvTieIdDe(0L);
         this.rdv.setRdvNomTiers((String)null);
         this.rdv.setRdvDiversNom((String)null);
         this.rdv.setRdvDiversTiers(0);
         this.tiersRecup = null;
      }

      if (this.tiersRecup != null) {
         this.rdv.setRdvMailContact(var2.getEveConPatroyme());
         if (this.tiersRecup != null && var2.getEveConPatroyme() != null && !var2.getEveConPatroyme().isEmpty()) {
            this.contactsRecup = this.contactDao.chargerLesContactsPatronyme(this.tiersRecup.getTieid(), var2.getEveConPatroyme(), var3);
            if (this.contactsRecup != null) {
            }
         }

         this.rdv.setRdvUsrDe(var2.getEveIdUser());
         this.userRecup = this.userDao.selectByIdUsers(var2.getEveIdUser(), var3);
         if (this.userRecup != null) {
            this.rdv.setRdvNomUsers(this.userRecup.getUsrPatronyme());
            if (this.userRecup.getUsrService() != null && !this.userRecup.getUsrService().isEmpty()) {
               if (this.userRecup.getUsrService().contains(":")) {
                  String[] var4 = this.userRecup.getUsrService().split(":");
                  this.rdv.setRdvService(var4[0]);
               } else {
                  this.rdv.setRdvService(this.userRecup.getUsrService());
               }
            }

            this.rdv.setRdvCollaborateur((String)null);
            this.rdv.setRdvTache((String)null);
            this.rdv.setRdvTachePr(0.0F);
            this.rdv.setRdvTachePv(0.0F);
            this.rdv.setUsers(this.userRecup);
            this.rdv.setRdvLieu("");
            this.rdv.setRdvX(var2.getEveLongitude());
            this.rdv.setRdvY(var2.getEveLatitude());
            this.rdv = this.rdvDao.insert(this.rdv, var3);
         }
      }

   }

   public void casFinRdvCommercial(Android var1, Session var2) throws HibernateException, NamingException, ParseException {
      this.rdv = this.rdvDao.logRdvIdPrincipal(var1.getEveIdInit(), var2);
      if (this.rdv != null && this.tiersRecup != null && this.userRecup != null) {
         this.rdv.setRdvDteFi(this.utilDate.dateToSQLLight(var1.getEveHoraire()));
         if (var1.getEveHoraire().getHours() <= 9) {
            this.rdv.setRdvHrFi("0" + var1.getEveHoraire().getHours());
         } else {
            this.rdv.setRdvHrFi("" + var1.getEveHoraire().getHours());
         }

         if (var1.getEveHoraire().getMinutes() <= 9) {
            this.rdv.setRdvMnFi("0" + var1.getEveHoraire().getMinutes());
         } else {
            this.rdv.setRdvMnFi("" + var1.getEveHoraire().getMinutes());
         }

         long var3 = this.rdv.getRdvDteDe().getTime();
         long var5 = this.rdv.getRdvDteFi().getTime();
         long var7 = var5 - var3;
         int var9 = 0;
         int var10 = 0;
         if (var7 != 0L) {
            Date var11 = new Date(var7);
            var9 = var11.getHours();
            var10 = var11.getMinutes();
         }

         if (var9 <= 9) {
            this.rdv.setRdvHrDuree("0" + var9);
         } else {
            this.rdv.setRdvHrDuree("" + var9);
         }

         if (var10 <= 9) {
            this.rdv.setRdvMnDuree("0" + var10);
         } else {
            this.rdv.setRdvMnDuree("" + var10);
         }

         this.rdv.setRdvCr(var1.getEveMessage());
         if (this.rdv.getRdvNature() == 4) {
            this.rdv.setRdvSujet("Visite Android");
            this.rdv.setRdvNature(4);
            if (var1.getEveEstimation() == 0) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat estimé: Trés Positif");
            } else if (var1.getEveEstimation() == 1) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat estimé: Positif");
            } else if (var1.getEveEstimation() == 2) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat estimé: Sans plus");
            } else if (var1.getEveEstimation() == 3) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat estimé: Négatif");
            } else if (var1.getEveEstimation() == 4) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat estimé: Très Négatif");
            } else {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat estimé: Inconnu");
            }
         } else if (this.rdv.getRdvNature() == 1) {
            this.rdv.setRdvSujet("Intervention ANDROID");
            this.rdv.setRdvNature(5);
            if (var1.getEveEstimation() == 0) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat visite: Effectué avec succès");
            } else if (var1.getEveEstimation() == 1) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat visite: Effectué avec échec");
            } else if (var1.getEveEstimation() == 2) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat visite: Non effectué");
            } else if (var1.getEveEstimation() == 3) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat visite: Reporté par le client");
            } else if (var1.getEveEstimation() == 4) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat visite: Reporté par la société");
            } else if (var1.getEveEstimation() == 5) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat visite: Annulé par le client");
            } else if (var1.getEveEstimation() == 6) {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat visite: Annulé par la société");
            } else {
               this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat visite: Inconnu");
            }
         } else {
            this.rdv.setRdvSujet("RDV Android");
            this.rdv.setRdvNature(1);
            this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "Résultat visite: Inconnu");
         }

         this.rdv.setRdvMode("Déplacement");
         this.rdv.setRdvLieu("");
         this.rdv.setRdvX(var1.getEveLongitude());
         this.rdv.setRdvY(var1.getEveLatitude());
         this.rdv = this.rdvDao.modif(this.rdv, var2);
      }

   }

   public void casNotes(Android var1, Session var2) throws HibernateException, NamingException, ParseException {
      this.rdv = new Rdv();
      this.userRecup = new Users();
      this.userRecup = this.userDao.selectByIdUsers(var1.getEveIdUser(), var2);
      if (this.userRecup != null) {
         this.rdv.setRdvNomUsers(this.userRecup.getUsrPatronyme());
         if (this.userRecup.getUsrService() != null && !this.userRecup.getUsrService().isEmpty()) {
            if (this.userRecup.getUsrService().contains(":")) {
               String[] var3 = this.userRecup.getUsrService().split(":");
               this.rdv.setRdvService(var3[0]);
            } else {
               this.rdv.setRdvService(this.userRecup.getUsrService());
            }
         }

         this.rdv.setRdvDateCreation(new Date());
         this.rdv.setRdvCollaborateur((String)null);
         this.rdv.setRdvDteExec(this.utilDate.dateToSQLLight(var1.getEveHoraire()));
         this.rdv.setRdvDteDe(this.utilDate.dateToSQLLight(var1.getEveHoraire()));
         this.rdv.setRdvCr(var1.getEveMessage());
         this.rdv.setRdvNature(10);
         this.rdv.setRdvEtat(1);
         this.rdv.setRdvMode("");
         this.rdv.setRdvTache((String)null);
         this.rdv.setRdvTachePr(0.0F);
         this.rdv.setRdvTachePv(0.0F);
         this.rdv.setUsers(this.userRecup);
         this.rdv.setRdvLieu("");
         this.rdv.setRdvX(var1.getEveLongitude());
         this.rdv.setRdvY(var1.getEveLatitude());
         this.rdv = this.rdvDao.insert(this.rdv, var2);
      }

   }

   public void casMvtsRonde(Android var1, List var2, Session var3) throws HibernateException, NamingException, ParseException {
      this.rdv = new Rdv();
      this.userRecup = new Users();
      this.rdv.setRdvDateCreation(new Date());
      this.rdv.setRdvDteExec((Date)null);
      this.rdv.setRdvErreur(false);
      this.rdv.setRdvEtat(1);
      this.rdv.setRdvIdPrincipal(var1.getEveId());
      this.rdv.setRdvStatut((String)null);
      this.rdv.setRdvSujet("RONDE");
      this.rdv.setRdvNature(14);
      if (var1.getEveEstimation() == 0) {
         this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "RAZ");
      } else if (var1.getEveEstimation() == 1) {
         this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "ALERTE LEGERE");
      } else if (var1.getEveEstimation() == 2) {
         this.rdv.setRdvCr(this.rdv.getRdvCr() + "\n" + "ALERTE GRAVE");
      }

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         if (((Android)var2.get(var4)).getEveIdInit() == var1.getEveIdInit()) {
            this.rdv.setRdvDteDe(this.utilDate.dateToSQLLight(((Android)var2.get(var4)).getEveHoraire()));
            if (((Android)var2.get(var4)).getEveHoraire().getHours() <= 9) {
               this.rdv.setRdvHrDe("0" + ((Android)var2.get(var4)).getEveHoraire().getHours());
            } else {
               this.rdv.setRdvHrDe("" + ((Android)var2.get(var4)).getEveHoraire().getHours());
            }

            if (((Android)var2.get(var4)).getEveHoraire().getMinutes() <= 9) {
               this.rdv.setRdvMnDe("0" + ((Android)var2.get(var4)).getEveHoraire().getMinutes());
            } else {
               this.rdv.setRdvMnDe("" + ((Android)var2.get(var4)).getEveHoraire().getMinutes());
            }
            break;
         }
      }

      if (this.rdv.getRdvDteDe() == null) {
         this.rdv.setRdvDteDe(this.utilDate.dateToSQLLight(var1.getEveHoraire()));
      }

      this.rdv.setRdvDteDe(this.utilDate.dateToSQLLight(var1.getEveHoraire()));
      if (var1.getEveHoraire().getHours() <= 9) {
         this.rdv.setRdvHrDe("0" + var1.getEveHoraire().getHours());
      } else {
         this.rdv.setRdvHrDe("" + var1.getEveHoraire().getHours());
      }

      if (var1.getEveHoraire().getMinutes() <= 9) {
         this.rdv.setRdvMnDe("0" + var1.getEveHoraire().getMinutes());
      } else {
         this.rdv.setRdvMnDe("" + var1.getEveHoraire().getMinutes());
      }

      this.rdv.setRdvHrDuree("00");
      this.rdv.setRdvMnDuree("00");
      this.userRecup = this.userDao.selectByIdUsers(var1.getEveIdUser(), var3);
      if (this.userRecup != null) {
         this.rdv.setRdvPatIdDe(0L);
         this.rdv.setRdvSalIdDe(0L);
         this.rdv.setRdvNomPat((String)null);
         this.rdv.setRdvNomSal((String)null);
         this.tiersRecup = null;
         this.rdv.setRdvTache((String)null);
         this.rdv.setRdvTachePr(0.0F);
         this.rdv.setRdvTachePv(0.0F);
         this.rdv.setUsers(this.userRecup);
         this.rdv.setRdvLieu("");
         this.rdv.setRdvX(var1.getEveLongitude());
         this.rdv.setRdvY(var1.getEveLatitude());
         this.rdv = this.rdvDao.insert(this.rdv, var3);
      }

   }

   public void casFrais(Android var1, Session var2) throws HibernateException, NamingException {
      this.userRecup = new Users();
      this.userRecup = this.userDao.selectByIdUsers(var1.getEveIdUser(), var2);
      this.ecrituresNotes = new EcrituresNotes();
      this.ecrituresNotes.setEcrnotDateCreat(new Date());
      this.ecrituresNotes.setEcrnotUserCreat(this.usersLog.getUsrid());
      this.ecrituresNotes.setEcrnotDate(var1.getEveHoraire());
      this.ecrituresNotes.setEcrnotAnnee("" + (this.ecrituresNotes.getEcrnotDate().getYear() + 1900));
      String var3 = "";
      if (var1.getEveHoraire().getMonth() + 1 <= 9) {
         var3 = "0" + (var1.getEveHoraire().getMonth() + 1);
      } else {
         var3 = "" + (var1.getEveHoraire().getMonth() + 1);
      }

      this.ecrituresNotes.setEcrnotPeriode(var3 + ":" + this.ecrituresNotes.getEcrnotAnnee());
      this.ecrituresNotes.setEcrnotLibelle(var1.getEveMessage());
      this.ecrituresNotes.setEcrnotMontant((double)var1.getEveMontant());
      this.ecrituresNotes.setEcrnotPiece(var1.getEveTache());
      this.ecrituresNotes.setEcrnotCategorie(var1.getEveEstimation());
      this.ecrituresNotes.setEcrnotType(0);
      this.ecrituresNotes.setEcrnotEtat(0);
      this.ecrituresNotes.setEcrnotLongitude(var1.getEveLongitude());
      this.ecrituresNotes.setEcrnotLatitude(var1.getEveLatitude());
      if (this.userRecup != null) {
         this.ecrituresNotes.setUsers(this.userRecup);
      } else {
         this.ecrituresNotes.setUsers((Users)null);
      }

      this.ecrituresNotes = this.ecrituresNotesDao.insert(this.ecrituresNotes, var2);
   }

   public void caluleMap() throws URISyntaxException {
      if (this.listRdv.size() != 0) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.coordonnees = var1.calculPointMapBox(this.listRdv);
         int var2 = this.listRdv.size() - 1;
         this.origine = ((Rdv)this.listRdv.get(var2)).getRdvX() + "," + ((Rdv)this.listRdv.get(var2)).getRdvY();
      }

   }

   public void caluleMapRdv() throws URISyntaxException {
      if (this.rdv != null) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.coordonnees = var1.calculPointMapBoxRdv(this.rdv);
         this.origine = this.rdv.getRdvX() + "," + this.rdv.getRdvY();
      }

   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.visibleOptionMail = false;
      this.affMail = false;
      this.nomModeleDocument = "";
      this.recupererModeleListe();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void recupererModeleListe() {
      String var1 = "";
      if (this.modeRdv == 0) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "planning" + File.separator + "mois" + File.separator;
      } else if (this.modeRdv == 1) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "planning" + File.separator + "semaine" + File.separator;
      } else if (this.modeRdv == 2) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "planning" + File.separator + "jour" + File.separator;
      } else if (this.modeRdv == 3) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "planning" + File.separator + "liste" + File.separator;
      }

      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.listeImpressionsItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.listeImpressionsItems.add(new SelectItem(var5));
            }
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

   public void OptionMail() {
      if (this.format.equalsIgnoreCase("MAIL")) {
         this.visibleOptionMail = true;
      } else {
         this.visibleOptionMail = false;
      }

   }

   public String calculeCheminRapport(String var1) {
      String var2 = "";
      if (this.modeRdv == 0) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "planning" + File.separator + "mois" + File.separator;
      } else if (this.modeRdv == 1) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "planning" + File.separator + "semaine" + File.separator;
      } else if (this.modeRdv == 2) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "planning" + File.separator + "jour" + File.separator;
      } else if (this.modeRdv == 3) {
         var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "document" + File.separator + "planning" + File.separator + "liste" + File.separator;
      }

      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      File var3 = new File(this.calculeCheminSousRapport(var1) + "formatTiers.jpg");
      if (var3.exists()) {
         var2 = "formatTiers.jpg";
      }

      return var2;
   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimer();
   }

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.userSelectionne, (Tiers)null, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
         if (this.utilPrint == null) {
            this.utilPrint = new UtilPrint(this.utilInitHibernate);
         }

         this.utilPrint.setRapport(this.nomModeleDocument);
         this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setFiltre(this.calculFiltre());
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setImageFondPage(this.calculeImageFond(this.baseLog));
         this.utilPrint.setIdResponsable(this.userSelectionne.getUsrid());
         this.utilPrint.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var1 = null;
         String var2 = "";
         ArrayList var3;
         int var4;
         int var5;
         if (this.nomModeleDocument.contains("CompteRendu")) {
            this.utilPrint.setEntete("Compte rendu de " + this.userSelectionne.getUsrPatronyme());
            var3 = new ArrayList();
            if (this.modeRdv == 0) {
               if (this.listRdvMois.size() != 0) {
                  for(var4 = 0; var4 < this.listRdvMois.size(); ++var4) {
                     this.rdvSemaine = (RdvSemaine)this.listRdvMois.get(var4);
                     if (this.rdvSemaine.getLundi() != null && !this.rdvSemaine.getLundi().isEmpty() && this.rdvSemaine.getLesRdvJourLundi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourLundi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourLundi().get(var5);
                           var3.add(this.rdv);
                        }
                     }

                     if (this.rdvSemaine.getMardi() != null && !this.rdvSemaine.getMardi().isEmpty() && this.rdvSemaine.getLesRdvJourMardi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourMardi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourMardi().get(var5);
                           var3.add(this.rdv);
                        }
                     }

                     if (this.rdvSemaine.getMercredi() != null && !this.rdvSemaine.getMercredi().isEmpty() && this.rdvSemaine.getLesRdvJourMercredi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourMercredi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourMercredi().get(var5);
                           var3.add(this.rdv);
                        }
                     }

                     if (this.rdvSemaine.getJeudi() != null && !this.rdvSemaine.getJeudi().isEmpty() && this.rdvSemaine.getLesRdvJourJeudi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourJeudi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourJeudi().get(var5);
                           var3.add(this.rdv);
                        }
                     }

                     if (this.rdvSemaine.getVendredi() != null && !this.rdvSemaine.getVendredi().isEmpty() && this.rdvSemaine.getLesRdvJourVendredi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourVendredi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourVendredi().get(var5);
                           var3.add(this.rdv);
                        }
                     }

                     if (this.rdvSemaine.getSamedi() != null && !this.rdvSemaine.getSamedi().isEmpty() && this.rdvSemaine.getLesRdvJourSamedi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourSamedi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourSamedi().get(var5);
                           var3.add(this.rdv);
                        }
                     }

                     if (this.rdvSemaine.getDimanche() != null && !this.rdvSemaine.getDimanche().isEmpty() && this.rdvSemaine.getLesRdvJourDimanche().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourDimanche().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourDimanche().get(var5);
                           var3.add(this.rdv);
                        }
                     }
                  }
               }
            } else if (this.modeRdv == 1) {
               Date var8 = null;
               Date var9 = null;
               Calendar var6 = Calendar.getInstance();
               var6.setTime(this.parSemaine);
               String var7 = "" + var6.getTime();
               if (var7.contains("Mon")) {
                  var8 = var6.getTime();
                  var6.add(7, 6);
                  var9 = var6.getTime();
               } else if (var7.contains("Tue")) {
                  var6.add(7, -1);
                  var8 = var6.getTime();
                  var6.add(7, 6);
                  var9 = var6.getTime();
               } else if (var7.contains("Wed")) {
                  var6.add(7, -2);
                  var8 = var6.getTime();
                  var6.add(7, 6);
                  var9 = var6.getTime();
               } else if (var7.contains("Thu")) {
                  var6.add(7, -3);
                  var8 = var6.getTime();
                  var6.add(7, 6);
                  var9 = var6.getTime();
               } else if (var7.contains("Fri")) {
                  var6.add(7, -4);
                  var8 = var6.getTime();
                  var6.add(7, 6);
                  var9 = var6.getTime();
               } else if (var7.contains("Sat")) {
                  var6.add(7, -5);
                  var8 = var6.getTime();
                  var6.add(7, 6);
                  var9 = var6.getTime();
               } else if (var7.contains("Sun")) {
                  var6.add(7, -6);
                  var8 = var6.getTime();
                  var6.add(7, 6);
                  var9 = var6.getTime();
               }

               var3 = (ArrayList)this.rdvDao.selectRdv(this.userSelectionne.getUsrid(), var8, var9, this.valNatSemaine, (String)null, (Session)null);
            } else if (this.modeRdv == 2) {
               if (this.listRdvJour.size() != 0) {
                  for(var4 = 0; var4 < this.listRdvJour.size(); ++var4) {
                     this.rdv = (Rdv)this.listRdvJour.get(var4);
                     if (this.rdv.getRdvNomTiers() != null && !this.rdv.getRdvNomTiers().isEmpty() || this.rdv.getRdvCr() != null && !this.rdv.getRdvCr().isEmpty()) {
                        var3.add(this.rdv);
                     }
                  }
               }
            } else if (this.modeRdv == 3 && this.listRdv.size() != 0) {
               for(var4 = 0; var4 < this.listRdv.size(); ++var4) {
                  var3.add(this.listRdv.get(var4));
               }
            }

            var1 = new JRBeanCollectionDataSource(var3);
         } else {
            this.utilPrint.setEntete("Planning de " + this.userSelectionne.getUsrPatronyme());
            if (this.modeRdv == 0) {
               var3 = new ArrayList();
               if (this.listRdvMois.size() != 0) {
                  for(var4 = 0; var4 < this.listRdvMois.size(); ++var4) {
                     this.rdvSemaine = (RdvSemaine)this.listRdvMois.get(var4);
                     var2 = "";
                     if (this.rdvSemaine.getLundi() != null && !this.rdvSemaine.getLundi().isEmpty() && this.rdvSemaine.getLesRdvJourLundi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourLundi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourLundi().get(var5);
                           var2 = var2 + this.rdv.getRdvHrDe() + ":" + this.rdv.getRdvMnDe() + " " + this.rdv.getTexteAffiche() + " => " + this.rdv.getLibEtat() + "\n";
                        }
                     }

                     this.rdvSemaine.setImpcol01(var2);
                     var2 = "";
                     if (this.rdvSemaine.getMardi() != null && !this.rdvSemaine.getMardi().isEmpty() && this.rdvSemaine.getLesRdvJourMardi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourMardi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourMardi().get(var5);
                           var2 = var2 + this.rdv.getRdvHrDe() + ":" + this.rdv.getRdvMnDe() + " " + this.rdv.getTexteAffiche() + " => " + this.rdv.getLibEtat() + "\n";
                        }
                     }

                     this.rdvSemaine.setImpcol02(var2);
                     var2 = "";
                     if (this.rdvSemaine.getMercredi() != null && !this.rdvSemaine.getMercredi().isEmpty() && this.rdvSemaine.getLesRdvJourMercredi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourMercredi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourMercredi().get(var5);
                           var2 = var2 + this.rdv.getRdvHrDe() + ":" + this.rdv.getRdvMnDe() + " " + this.rdv.getTexteAffiche() + " => " + this.rdv.getLibEtat() + "\n";
                        }
                     }

                     this.rdvSemaine.setImpcol03(var2);
                     var2 = "";
                     if (this.rdvSemaine.getJeudi() != null && !this.rdvSemaine.getJeudi().isEmpty() && this.rdvSemaine.getLesRdvJourJeudi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourJeudi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourJeudi().get(var5);
                           var2 = var2 + this.rdv.getRdvHrDe() + ":" + this.rdv.getRdvMnDe() + " " + this.rdv.getTexteAffiche() + " => " + this.rdv.getLibEtat() + "\n";
                        }
                     }

                     this.rdvSemaine.setImpcol04(var2);
                     var2 = "";
                     if (this.rdvSemaine.getVendredi() != null && !this.rdvSemaine.getVendredi().isEmpty() && this.rdvSemaine.getLesRdvJourVendredi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourVendredi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourVendredi().get(var5);
                           var2 = var2 + this.rdv.getRdvHrDe() + ":" + this.rdv.getRdvMnDe() + " " + this.rdv.getTexteAffiche() + " => " + this.rdv.getLibEtat() + "\n";
                        }
                     }

                     this.rdvSemaine.setImpcol05(var2);
                     var2 = "";
                     if (this.rdvSemaine.getSamedi() != null && !this.rdvSemaine.getSamedi().isEmpty() && this.rdvSemaine.getLesRdvJourSamedi().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourSamedi().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourSamedi().get(var5);
                           var2 = var2 + this.rdv.getRdvHrDe() + ":" + this.rdv.getRdvMnDe() + " " + this.rdv.getTexteAffiche() + " => " + this.rdv.getLibEtat() + "\n";
                        }
                     }

                     this.rdvSemaine.setImpcol06(var2);
                     var2 = "";
                     if (this.rdvSemaine.getDimanche() != null && !this.rdvSemaine.getDimanche().isEmpty() && this.rdvSemaine.getLesRdvJourDimanche().size() != 0) {
                        for(var5 = 0; var5 < this.rdvSemaine.getLesRdvJourDimanche().size(); ++var5) {
                           this.rdv = (Rdv)this.rdvSemaine.getLesRdvJourDimanche().get(var5);
                           var2 = var2 + this.rdv.getRdvHrDe() + ":" + this.rdv.getRdvMnDe() + " " + this.rdv.getTexteAffiche() + " => " + this.rdv.getLibEtat() + "\n";
                        }
                     }

                     this.rdvSemaine.setImpcol07(var2);
                     var3.add(this.rdvSemaine);
                  }
               }

               var1 = new JRBeanCollectionDataSource(var3);
            } else if (this.modeRdv != 1) {
               if (this.modeRdv == 2) {
                  var1 = new JRBeanCollectionDataSource(this.listRdvJour);
               } else if (this.modeRdv == 3) {
                  var1 = new JRBeanCollectionDataSource(this.listRdv);
               }
            } else {
               var3 = new ArrayList();
               if (this.listRdvSemaine.size() != 0) {
                  for(var4 = 0; var4 < this.listRdvSemaine.size(); ++var4) {
                     this.rdvSemaine = (RdvSemaine)this.listRdvSemaine.get(var4);
                     this.rdvSemaine.setImpcol01(this.dateLun);
                     this.rdvSemaine.setImpcol02(this.dateMar);
                     this.rdvSemaine.setImpcol03(this.dateMer);
                     this.rdvSemaine.setImpcol04(this.dateJeu);
                     this.rdvSemaine.setImpcol05(this.dateVen);
                     this.rdvSemaine.setImpcol06(this.dateSam);
                     this.rdvSemaine.setImpcol07(this.dateDim);
                     var3.add(this.rdvSemaine);
                  }
               }

               var1 = new JRBeanCollectionDataSource(var3);
            }
         }

         this.utilPrint.setjRBeanCollectionDataSource(var1);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.userSelectionne);
         this.utilPrint.imprimeRapport();
      }

   }

   public String calculFiltre() {
      this.filtre = "";
      if (this.modeRdv == 0) {
         String var1 = "";
         if (this.parMois.getMonth() + 1 <= 9) {
            var1 = "0" + (this.parMois.getMonth() + 1);
         } else {
            var1 = "" + (this.parMois.getMonth() + 1);
         }

         this.filtre = "Mois de " + var1 + ":" + (this.parMois.getYear() + 1900);
      } else if (this.modeRdv == 1) {
         this.filtre = "Semaine du " + this.dateLun + " au " + this.dateDim;
      } else if (this.modeRdv == 2) {
         this.filtre = "Journée du " + this.utilDate.dateToStringFr(this.parJour);
      } else if (this.modeRdv == 3) {
         this.filtre = "Période du " + this.utilDate.dateToStringFr(this.jourDeb) + " au " + this.utilDate.dateToStringFr(this.jourFin);
      }

      if (this.serviceSelectionne != null && !this.serviceSelectionne.isEmpty()) {
         this.filtre = this.filtre + " Service: " + this.serviceSelectionne;
      }

      return this.filtre;
   }

   public Rdv getRdv() {
      return this.rdv;
   }

   public void setRdv(Rdv var1) {
      this.rdv = var1;
   }

   public DataModel getDatamodelRdv() {
      return this.datamodelRdv;
   }

   public void setDatamodelRdv(DataModel var1) {
      this.datamodelRdv = var1;
   }

   public DataModel getDatamodelLesRdvParJour() {
      return this.datamodelLesRdvParJour;
   }

   public void setDatamodelLesRdvParJour(DataModel var1) {
      this.datamodelLesRdvParJour = var1;
   }

   public Date getJourDeb() {
      return this.jourDeb;
   }

   public void setJourDeb(Date var1) {
      this.jourDeb = var1;
   }

   public Date getJourFin() {
      return this.jourFin;
   }

   public void setJourFin(Date var1) {
      this.jourFin = var1;
   }

   public int getValNatJour() {
      return this.valNatJour;
   }

   public void setValNatJour(int var1) {
      this.valNatJour = var1;
   }

   public int getValNatListe() {
      return this.valNatListe;
   }

   public void setValNatListe(int var1) {
      this.valNatListe = var1;
   }

   public int getValNatMois() {
      return this.valNatMois;
   }

   public void setValNatMois(int var1) {
      this.valNatMois = var1;
   }

   public int getValNatSemaine() {
      return this.valNatSemaine;
   }

   public void setValNatSemaine(int var1) {
      this.valNatSemaine = var1;
   }

   public String getLienRdv() {
      return this.lienRdv;
   }

   public void setLienRdv(String var1) {
      this.lienRdv = var1;
   }

   public String getSelectedUserdest() {
      return this.selectedUserdest;
   }

   public void setSelectedUserdest(String var1) {
      this.selectedUserdest = var1;
   }

   public int getTypeRdv() {
      return this.typeRdv;
   }

   public void setTypeRdv(int var1) {
      this.typeRdv = var1;
   }

   public DataModel getDatamodelLesRdvParSemaine() {
      return this.datamodelLesRdvParSemaine;
   }

   public void setDatamodelLesRdvParSemaine(DataModel var1) {
      this.datamodelLesRdvParSemaine = var1;
   }

   public String getDateDim() {
      return this.dateDim;
   }

   public void setDateDim(String var1) {
      this.dateDim = var1;
   }

   public String getDateJeu() {
      return this.dateJeu;
   }

   public void setDateJeu(String var1) {
      this.dateJeu = var1;
   }

   public String getDateLun() {
      return this.dateLun;
   }

   public void setDateLun(String var1) {
      this.dateLun = var1;
   }

   public String getDateMar() {
      return this.dateMar;
   }

   public void setDateMar(String var1) {
      this.dateMar = var1;
   }

   public String getDateMer() {
      return this.dateMer;
   }

   public void setDateMer(String var1) {
      this.dateMer = var1;
   }

   public String getDateSam() {
      return this.dateSam;
   }

   public void setDateSam(String var1) {
      this.dateSam = var1;
   }

   public String getDateVen() {
      return this.dateVen;
   }

   public void setDateVen(String var1) {
      this.dateVen = var1;
   }

   public DataModel getDatamodelLesRdvParMois() {
      return this.datamodelLesRdvParMois;
   }

   public void setDatamodelLesRdvParMois(DataModel var1) {
      this.datamodelLesRdvParMois = var1;
   }

   public boolean isTestAffRdv() {
      return this.testAffRdv;
   }

   public void setTestAffRdv(boolean var1) {
      this.testAffRdv = var1;
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

   public boolean isShowModalPanelRdv() {
      return this.showModalPanelRdv;
   }

   public void setShowModalPanelRdv(boolean var1) {
      this.showModalPanelRdv = var1;
   }

   public boolean isAfficheRdv() {
      return this.afficheRdv;
   }

   public void setAfficheRdv(boolean var1) {
      this.afficheRdv = var1;
   }

   public long getRefCollaborateur() {
      return this.refCollaborateur;
   }

   public void setRefCollaborateur(long var1) {
      this.refCollaborateur = var1;
   }

   public boolean isRdvdetails() {
      return this.rdvdetails;
   }

   public void setRdvdetails(boolean var1) {
      this.rdvdetails = var1;
   }

   public DataModel getDatamodelPatients() {
      return this.datamodelPatients;
   }

   public void setDatamodelPatients(DataModel var1) {
      this.datamodelPatients = var1;
   }

   public DataModel getDatamodelTiers() {
      return this.datamodelTiers;
   }

   public void setDatamodelTiers(DataModel var1) {
      this.datamodelTiers = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }

   public boolean isShowModalPanelPatients() {
      return this.showModalPanelPatients;
   }

   public void setShowModalPanelPatients(boolean var1) {
      this.showModalPanelPatients = var1;
   }

   public boolean isShowModalPanelTiers() {
      return this.showModalPanelTiers;
   }

   public void setShowModalPanelTiers(boolean var1) {
      this.showModalPanelTiers = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public boolean isGestionPatient() {
      return this.gestionPatient;
   }

   public void setGestionPatient(boolean var1) {
      this.gestionPatient = var1;
   }

   public String getChoixTache() {
      return this.choixTache;
   }

   public void setChoixTache(String var1) {
      this.choixTache = var1;
   }

   public boolean isDateVerrouillee() {
      return this.dateVerrouillee;
   }

   public void setDateVerrouillee(boolean var1) {
      this.dateVerrouillee = var1;
   }

   public Date getParMois() {
      return this.parMois;
   }

   public void setParMois(Date var1) {
      this.parMois = var1;
   }

   public Date getParJour() {
      return this.parJour;
   }

   public void setParJour(Date var1) {
      this.parJour = var1;
   }

   public Date getParSemaine() {
      return this.parSemaine;
   }

   public void setParSemaine(Date var1) {
      this.parSemaine = var1;
   }

   public int getModeRdv() {
      return this.modeRdv;
   }

   public void setModeRdv(int var1) {
      this.modeRdv = var1;
   }

   public boolean isCompteRendu() {
      return this.compteRendu;
   }

   public void setCompteRendu(boolean var1) {
      this.compteRendu = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
   }

   public String getImpDestinataireCC() {
      return this.impDestinataireCC;
   }

   public void setImpDestinataireCC(String var1) {
      this.impDestinataireCC = var1;
   }

   public String getImpDestinataireCCI() {
      return this.impDestinataireCCI;
   }

   public void setImpDestinataireCCI(String var1) {
      this.impDestinataireCCI = var1;
   }

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public List getListeImpressionsItems() {
      return this.listeImpressionsItems;
   }

   public void setListeImpressionsItems(List var1) {
      this.listeImpressionsItems = var1;
   }

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public DataModel getDatamodelUsersService() {
      return this.datamodelUsersService;
   }

   public void setDatamodelUsersService(DataModel var1) {
      this.datamodelUsersService = var1;
   }

   public List getLesServicesItems() {
      return this.lesServicesItems;
   }

   public void setLesServicesItems(List var1) {
      this.lesServicesItems = var1;
   }

   public String getServiceSelectionne() {
      return this.serviceSelectionne;
   }

   public void setServiceSelectionne(String var1) {
      this.serviceSelectionne = var1;
   }

   public DataModel getDataModelContacts() {
      return this.dataModelContacts;
   }

   public void setDataModelContacts(DataModel var1) {
      this.dataModelContacts = var1;
   }

   public boolean isShowModalPanelReport() {
      return this.showModalPanelReport;
   }

   public void setShowModalPanelReport(boolean var1) {
      this.showModalPanelReport = var1;
   }

   public Date getDateReport() {
      return this.dateReport;
   }

   public void setDateReport(Date var1) {
      this.dateReport = var1;
   }

   public String getHeureReport() {
      return this.heureReport;
   }

   public void setHeureReport(String var1) {
      this.heureReport = var1;
   }

   public String getMinuteReport() {
      return this.minuteReport;
   }

   public void setMinuteReport(String var1) {
      this.minuteReport = var1;
   }

   public String getMotifReport() {
      return this.motifReport;
   }

   public void setMotifReport(String var1) {
      this.motifReport = var1;
   }

   public DataModel getDataModelCollaborateur() {
      return this.dataModelCollaborateur;
   }

   public void setDataModelCollaborateur(DataModel var1) {
      this.dataModelCollaborateur = var1;
   }

   public Users getUserSelectionne() {
      return this.userSelectionne;
   }

   public void setUserSelectionne(Users var1) {
      this.userSelectionne = var1;
   }

   public List getLesDestinatairesItems() {
      return this.lesDestinatairesItems;
   }

   public void setLesDestinatairesItems(List var1) {
      this.lesDestinatairesItems = var1;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getLesMedecinsItems() {
      return this.lesMedecinsItems;
   }

   public void setLesMedecinsItems(List var1) {
      this.lesMedecinsItems = var1;
   }

   public boolean isAfficheRdvJour() {
      return this.afficheRdvJour;
   }

   public void setAfficheRdvJour(boolean var1) {
      this.afficheRdvJour = var1;
   }

   public String getCoordonnees() {
      return this.coordonnees;
   }

   public void setCoordonnees(String var1) {
      this.coordonnees = var1;
   }

   public String getLegende() {
      return this.legende;
   }

   public void setLegende(String var1) {
      this.legende = var1;
   }

   public String getOrigine() {
      return this.origine;
   }

   public void setOrigine(String var1) {
      this.origine = var1;
   }

   public boolean isActionRdv() {
      return this.actionRdv;
   }

   public void setActionRdv(boolean var1) {
      this.actionRdv = var1;
   }

   public boolean isApportRdv() {
      return this.apportRdv;
   }

   public void setApportRdv(boolean var1) {
      this.apportRdv = var1;
   }

   public boolean isBudgetRdv() {
      return this.budgetRdv;
   }

   public void setBudgetRdv(boolean var1) {
      this.budgetRdv = var1;
   }

   public boolean isConclusionRdv() {
      return this.conclusionRdv;
   }

   public void setConclusionRdv(boolean var1) {
      this.conclusionRdv = var1;
   }

   public boolean isDelaisRdv() {
      return this.delaisRdv;
   }

   public void setDelaisRdv(boolean var1) {
      this.delaisRdv = var1;
   }

   public List getLesActionItems() {
      return this.lesActionItems;
   }

   public void setLesActionItems(List var1) {
      this.lesActionItems = var1;
   }

   public List getLesApportItems() {
      return this.lesApportItems;
   }

   public void setLesApportItems(List var1) {
      this.lesApportItems = var1;
   }

   public List getLesBudgetItems() {
      return this.lesBudgetItems;
   }

   public void setLesBudgetItems(List var1) {
      this.lesBudgetItems = var1;
   }

   public List getLesConclusionItems() {
      return this.lesConclusionItems;
   }

   public void setLesConclusionItems(List var1) {
      this.lesConclusionItems = var1;
   }

   public List getLesDelaisItems() {
      return this.lesDelaisItems;
   }

   public void setLesDelaisItems(List var1) {
      this.lesDelaisItems = var1;
   }

   public List getLesLieuxItems() {
      return this.lesLieuxItems;
   }

   public void setLesLieuxItems(List var1) {
      this.lesLieuxItems = var1;
   }

   public List getLesModeFinItems() {
      return this.lesModeFinItems;
   }

   public void setLesModeFinItems(List var1) {
      this.lesModeFinItems = var1;
   }

   public List getLesSujetsItems() {
      return this.lesSujetsItems;
   }

   public void setLesSujetsItems(List var1) {
      this.lesSujetsItems = var1;
   }

   public boolean isLieuxRdv() {
      return this.lieuxRdv;
   }

   public void setLieuxRdv(boolean var1) {
      this.lieuxRdv = var1;
   }

   public boolean isModeFinRdv() {
      return this.modeFinRdv;
   }

   public void setModeFinRdv(boolean var1) {
      this.modeFinRdv = var1;
   }

   public boolean isSujetRdv() {
      return this.sujetRdv;
   }

   public void setSujetRdv(boolean var1) {
      this.sujetRdv = var1;
   }

   public List getMesNaturesRdvItems() {
      return this.mesNaturesRdvItems;
   }

   public void setMesNaturesRdvItems(List var1) {
      this.mesNaturesRdvItems = var1;
   }

   public DataModel getDataModelHistorique() {
      return this.dataModelHistorique;
   }

   public void setDataModelHistorique(DataModel var1) {
      this.dataModelHistorique = var1;
   }
}
