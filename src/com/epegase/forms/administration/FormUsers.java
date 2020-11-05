package com.epegase.forms.administration;

import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesOperations;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.ProcessEnteteAchats;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.UsersFavoris;
import com.epegase.systeme.classe.UsersPeg;
import com.epegase.systeme.control.RandPass;
import com.epegase.systeme.dao.BalDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CaissesOperationsDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.GroupeDao;
import com.epegase.systeme.dao.ProcessEnteteAchatsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.UsersFavorisDao;
import com.epegase.systeme.menu.MenudroitCoAdministrationCtrl;
import com.epegase.systeme.util.MD5Password;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureAppreciations;
import com.epegase.systeme.xml.LectureCivilites;
import com.epegase.systeme.xml.LectureFonctions;
import com.epegase.systeme.xml.LectureLangues;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LectureSourcesTiers;
import com.epegase.systeme.xml.LectureTypeTiers;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.json.JSONException;
import org.richfaces.json.JSONObject;
import org.richfaces.model.selection.SimpleSelection;

public class FormUsers implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private Users newUser;
   private UserDao userDao;
   private UsersChronoDao usersChronoDao;
   private UsersFavorisDao usersFavorisDao;
   private int var_action;
   private boolean var_aff_bouton;
   private transient DataModel datamodelUserSt = new ListDataModel();
   private UIDataTable extDTableSt;
   private SimpleSelection simpleSelectionSt;
   private transient DataModel datamodelUserCoAdm = new ListDataModel();
   private UIDataTable extDTableCoAdm;
   private SimpleSelection simpleSelectionCoAdm;
   private transient DataModel datamodelUserAdm = new ListDataModel();
   private UIDataTable extDTableAdm;
   private SimpleSelection simpleSelectionAdm;
   private transient DataModel datamodelUserGu = new ListDataModel();
   private UIDataTable extDTableGu;
   private SimpleSelection simpleSelectionGu;
   private transient DataModel datamodelUserIn = new ListDataModel();
   private UIDataTable extDTableIn;
   private SimpleSelection simpleSelectionIn;
   private transient DataModel datamodelUserMed = new ListDataModel();
   private UIDataTable extDTableMed;
   private SimpleSelection simpleSelectionMed;
   private List lesActifs = new ArrayList();
   private List lesCoAdm = new ArrayList();
   private List lesAdm = new ArrayList();
   private List lesGuest = new ArrayList();
   private List lesInactif = new ArrayList();
   private List lesMedical = new ArrayList();
   private boolean verif_admin;
   private String memo_pw;
   private String memo_cs;
   private boolean var_affiche_tout = false;
   private int typeSelectionne;
   private String ongletActif = "userSt";
   private boolean mail_Mesg;
   private boolean disablemail;
   private boolean testAffLogin;
   private boolean testAffPwdCS;
   private boolean testAffGenPwdCs;
   private Groupe groupe;
   private GroupeDao groupeDao;
   private LectureFonctions mesFonctions;
   private LectureAppreciations lesAppreciations;
   private LectureCivilites lesCivilites;
   private LectureSourcesTiers lesSourcesTiers;
   private LectureTypeTiers lesCategoriesTiers;
   private LecturePays lespays;
   private LectureLangues lesLangues;
   private LectureFonctions lesFonctions;
   private List mesGroupesItems = new ArrayList();
   private List mesAppreciationsItems = new ArrayList();
   private List mesCiviliteItems = new ArrayList();
   private List mesSourcesTiersItems = new ArrayList();
   private List mesCategoriesTiersItems = new ArrayList();
   private List mesPaysItems = new ArrayList();
   private List mesFonctionsItems = new ArrayList();
   private List mesLanguesItems = new ArrayList();
   private List mesChronoAchatsItems;
   private List mesChronoVentesItems;
   private List mesChronoComptaItems;
   private List mesChronoOfficeItems;
   private List mesChronoMedicalItems;
   private List mesChronoParcItems;
   private List mesOperationsCaisses;
   private CaissesOperationsDao caissesOperationsDao;
   private List userOperationsCaisses;
   private transient DataModel dataModelOperation;
   private CaissesOperations caissesOperations;
   private OptionVentes optionVentes;
   private String libelleService;
   private String libelleServiceSecondaire;
   private List mesServicesItems = new ArrayList();
   private ServiceDao serviceDao;
   private String var_service;
   private String var_departement;
   private String var_site;
   private boolean showModalPanelOffice = false;
   private List usersChronoListOff;
   private transient ListDataModel datamodelUsersChronoOff;
   private boolean testSelectSerieOff;
   private boolean visibiliteBtonOff = false;
   private boolean var_aff_val_chronoOff;
   private String inputChronoOff;
   private boolean showModalPanelCpt = false;
   private List usersChronoListCpt;
   private transient ListDataModel datamodelUsersChronoCpt;
   private boolean testSelectSerieCpt;
   private boolean visibiliteBtonCpt = false;
   private boolean var_aff_val_chronoCpt;
   private String inputChronoCpt;
   private boolean showModalPanelAchat = false;
   private ChronoDao chronoDao;
   private List usersChronoListAch;
   private transient ListDataModel datamodelUsersChronoAch;
   private boolean testSelectSerieAch;
   private String depot;
   private boolean visibiliteBtonAch = false;
   private UsersChrono usersChrono;
   private boolean var_aff_val_chronoAch;
   private String inputChronoAch;
   private boolean showModalPanelVente = false;
   private List usersChronoListVte;
   private transient ListDataModel datamodelUsersChronoVte;
   private boolean testSelectSerieVte;
   private boolean visibiliteBtonVte;
   private String inputChronoVte;
   private boolean var_aff_val_chronoVte;
   private List lesresponsablesItems;
   private boolean showModalPanelCaisse = false;
   private List usersChronoListCaiss;
   private transient ListDataModel datamodelUsersChronoCaiss;
   private boolean testSelectSerieCaiss;
   private boolean visibiliteBtonCaiss;
   private String inputChronoCaisse;
   private List mesChronoCaisseItems;
   private boolean var_aff_val_chronoCaisse;
   private List mesCaissesItems;
   private CaissesCommerciales caissesCommerciales;
   private CaissesCommercialesDao caissesCommercialesDao;
   private boolean showModalPanelBal = false;
   private transient ListDataModel datamodelBal;
   private BalDao balDao;
   private List listbal;
   private Bal ball;
   private String balmsg = "";
   private String lienPanel = "";
   private String var_memo_pw;
   private boolean verifExistMail;
   private boolean boutonBalgrpSup = false;
   private boolean showModalPanelPaye = false;
   private boolean testSelectSeriePaye = false;
   private boolean visibiliteBtonPaye = false;
   private List usersChronoListPaye;
   private transient ListDataModel datamodelUsersChronoPaye;
   private String inputChronoPaye;
   private boolean var_aff_val_chronoPaye;
   private List mesChronoPayeItems;
   private boolean showModalPanelMedical = false;
   private List usersChronoListMed;
   private transient ListDataModel datamodelUsersChronoMed;
   private boolean testSelectSerieMed;
   private boolean visibiliteBtonMed;
   private String inputChronoMed;
   private boolean var_aff_val_chronoMed;
   private boolean showModalPanelParc = false;
   private List usersChronoListPar;
   private transient ListDataModel datamodelUsersChronoPar;
   private boolean testSelectSeriePar;
   private boolean visibiliteBtonPar;
   private String inputChronoPar;
   private boolean var_aff_val_chronoPar;
   private transient DataModel datamodelCoAdministration;
   private List listLigneMenusConfig;
   private transient DataModel datamodelCoConfig;
   private List listLigneMenus;
   private boolean showModalPanelFonction = false;
   private ObjetLigneMenu ligneMenu;
   private Element racine;
   private Document document;
   private List lesTiersItems;
   private List lesSalariesItems;
   private boolean showModalPanelChangeIdentifiant = false;
   private boolean md = false;
   private boolean cs = false;
   private boolean mail = false;
   private String var_old_pw;
   private String var_old_mail;
   private List listeDepot;
   private DepotAchatsDao depotAchatsDao;
   private transient DataModel dataModelDepotHabilites;
   private List lesDepotsFavoris;
   private List listeProcess;
   private ProcessEnteteAchatsDao processEnteteAchatsDao;
   private transient DataModel dataModelProcessHabilites;
   private List lesProcessFavoris;
   private boolean showModalPanelPermission = false;
   private boolean affichagePermission = false;
   private String saisiePermission;
   private boolean permission01;
   private boolean permission02;
   private boolean permission03;
   private boolean permission04;
   private boolean permission05;
   private boolean permission06;
   private boolean permission07;
   private boolean permission08;
   private boolean permission09;
   private boolean permission10;
   private String format;
   private List lesStructuresPeg;

   public FormUsers() {
      this.mesGroupesItems = new ArrayList();
      this.mesServicesItems = new ArrayList();
      this.mesChronoComptaItems = new ArrayList();
      this.mesChronoAchatsItems = new ArrayList();
      this.mesChronoVentesItems = new ArrayList();
      this.usersChronoListAch = new ArrayList();
      this.datamodelUsersChronoAch = new ListDataModel();
      this.usersChronoListVte = new ArrayList();
      this.datamodelUsersChronoVte = new ListDataModel();
      this.usersChronoListMed = new ArrayList();
      this.datamodelUsersChronoMed = new ListDataModel();
      this.mesChronoMedicalItems = new ArrayList();
      this.usersChronoListCpt = new ArrayList();
      this.datamodelUsersChronoCpt = new ListDataModel();
      this.usersChronoListOff = new ArrayList();
      this.datamodelUsersChronoOff = new ListDataModel();
      this.usersChronoListPaye = new ArrayList();
      this.datamodelUsersChronoPaye = new ListDataModel();
      this.usersChronoListCaiss = new ArrayList();
      this.mesCaissesItems = new ArrayList();
      this.datamodelUsersChronoCaiss = new ListDataModel();
      this.usersChronoListPar = new ArrayList();
      this.datamodelUsersChronoPar = new ListDataModel();
      this.mesChronoParcItems = new ArrayList();
      this.ball = new Bal();
      this.groupe = new Groupe();
      this.listbal = new ArrayList();
      this.datamodelBal = new ListDataModel();
      this.lesresponsablesItems = new ArrayList();
      this.listLigneMenus = new ArrayList();
      this.listLigneMenusConfig = new ArrayList();
      this.datamodelCoAdministration = new ListDataModel();
      this.datamodelCoConfig = new ListDataModel();
      this.ligneMenu = new ObjetLigneMenu();
      this.mesOperationsCaisses = new ArrayList();
      this.userOperationsCaisses = new ArrayList();
      this.dataModelOperation = new ListDataModel();
      this.optionVentes = new OptionVentes();
      this.lesTiersItems = new ArrayList();
      this.lesSalariesItems = new ArrayList();
      this.listeDepot = new ArrayList();
      this.lesDepotsFavoris = new ArrayList();
      this.dataModelDepotHabilites = new ListDataModel();
      this.listeProcess = new ArrayList();
      this.lesProcessFavoris = new ArrayList();
      this.dataModelProcessHabilites = new ListDataModel();
      this.extDTableAdm = new HtmlExtendedDataTable();
      this.extDTableCoAdm = new HtmlExtendedDataTable();
      this.extDTableGu = new HtmlExtendedDataTable();
      this.extDTableIn = new HtmlExtendedDataTable();
      this.extDTableMed = new HtmlExtendedDataTable();
      this.extDTableSt = new HtmlExtendedDataTable();
      this.simpleSelectionAdm = new SimpleSelection();
      this.simpleSelectionCoAdm = new SimpleSelection();
      this.simpleSelectionGu = new SimpleSelection();
      this.simpleSelectionIn = new SimpleSelection();
      this.simpleSelectionMed = new SimpleSelection();
      this.simpleSelectionSt = new SimpleSelection();
   }

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.groupeDao = new GroupeDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.usersFavorisDao = new UsersFavorisDao(this.baseLog, this.utilInitHibernate);
      this.balDao = new BalDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.caissesOperationsDao = new CaissesOperationsDao(this.baseLog, this.utilInitHibernate);
      this.depotAchatsDao = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.processEnteteAchatsDao = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerUtilisateurs() throws JDOMException, IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
      this.chargerUtilisateursSuite(var1);
      this.chargerLesAppreciations();
      this.chargerLesCivilites();
      this.chargerLesCategoriesTiers();
      this.chargerLesLangues();
      this.chargerLesPays();
      this.chargerLesSourcesTiers();
      this.chargerLesDepots(var1);
      this.chargerLesProcess(var1);
      this.chargerLesGroupes(var1);
      this.chargerLesServices(var1);
      this.chargerLesChronoCpt(var1);
      this.chargerLesChronoOff(var1);
      this.chargerLesChronoAch(var1);
      this.chargerLesChronoVte(var1);
      this.chargerLesChronoCaisse(var1);
      this.chargerLesOperationsCaisse(var1);
      this.chargerLesChronoPaye(var1);
      this.chargerLesChronoMedical(var1);
      this.chargerLesChronoParc(var1);
      this.utilInitHibernate.closeSession();
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      this.optionVentes = var2.lancer();
      this.typeSelectionne = 0;
   }

   public void chargerUtilisateursSuite(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         var2 = true;
      }

      this.mail_Mesg = false;
      this.disablemail = false;
      this.testAffLogin = false;
      this.var_aff_bouton = false;
      this.var_affiche_tout = true;
      this.lesActifs.clear();
      this.lesCoAdm.clear();
      this.lesAdm.clear();
      this.lesGuest.clear();
      this.lesInactif.clear();
      this.lesMedical.clear();
      this.extDTableAdm = new HtmlExtendedDataTable();
      this.extDTableCoAdm = new HtmlExtendedDataTable();
      this.extDTableGu = new HtmlExtendedDataTable();
      this.extDTableIn = new HtmlExtendedDataTable();
      this.extDTableMed = new HtmlExtendedDataTable();
      this.extDTableSt = new HtmlExtendedDataTable();
      this.simpleSelectionAdm.clear();
      this.simpleSelectionCoAdm.clear();
      this.simpleSelectionGu.clear();
      this.simpleSelectionIn.clear();
      this.simpleSelectionMed.clear();
      this.simpleSelectionSt.clear();
      new Users();
      new ArrayList();
      List var4 = this.userDao.selectAllUser(var1);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            Users var3 = (Users)var4.get(var5);
            if (var3.getUsrEtat() == 0) {
               this.lesInactif.add(var3);
            } else if (var3.getUsrFonction() != null && !var3.getUsrFonction().isEmpty() && (var3.getUsrFonction().contains("Professeur") || var3.getUsrFonction().contains("Médecin") || var3.getUsrFonction().contains("Infirmier"))) {
               this.lesMedical.add(var3);
            } else if (var3.getUsrSysteme() == 0) {
               this.lesActifs.add(var3);
            } else if (var3.getUsrSysteme() == 1) {
               this.lesCoAdm.add(var3);
            } else if (var3.getUsrSysteme() == 2) {
               this.lesAdm.add(var3);
            } else if (var3.getUsrSysteme() == 3) {
               if (this.structureLog.getStrid() == 1L) {
                  this.lesAdm.add(var3);
               }
            } else if (var3.getUsrSysteme() == 4) {
               this.lesGuest.add(var3);
            }
         }
      }

      this.datamodelUserSt.setWrappedData(this.lesActifs);
      this.datamodelUserCoAdm.setWrappedData(this.lesCoAdm);
      this.datamodelUserAdm.setWrappedData(this.lesAdm);
      this.datamodelUserGu.setWrappedData(this.lesGuest);
      this.datamodelUserIn.setWrappedData(this.lesInactif);
      this.datamodelUserMed.setWrappedData(this.lesMedical);
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionUtilisateurSt() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.extDTableSt != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionSt.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableSt.setRowKey(var3);
            if (this.extDTableSt.isRowAvailable()) {
               var1.add(this.extDTableSt.getRowData());
            }
         }

         this.newUser = (Users)var1.get(0);
         this.selectionUtilisateur();
      }

   }

   public void visualisationSt() throws IOException, JDOMException {
      if (this.newUser != null) {
         this.modifUser();
      }

   }

   public void selectionUtilisateurCoAdm() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.extDTableCoAdm != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionCoAdm.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableCoAdm.setRowKey(var3);
            if (this.extDTableCoAdm.isRowAvailable()) {
               var1.add(this.extDTableCoAdm.getRowData());
            }
         }

         this.newUser = (Users)var1.get(0);
         this.selectionUtilisateur();
      }

   }

   public void visualisationCoAdm() throws IOException, JDOMException {
      if (this.newUser != null) {
         this.modifUser();
      }

   }

   public void selectionUtilisateurAdm() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.extDTableAdm != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionAdm.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableAdm.setRowKey(var3);
            if (this.extDTableAdm.isRowAvailable()) {
               var1.add(this.extDTableAdm.getRowData());
            }
         }

         this.newUser = (Users)var1.get(0);
         this.selectionUtilisateur();
      }

   }

   public void visualisationAdm() throws IOException, JDOMException {
      if (this.newUser != null) {
         this.modifUser();
      }

   }

   public void selectionUtilisateurGu() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.extDTableGu != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionGu.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableGu.setRowKey(var3);
            if (this.extDTableGu.isRowAvailable()) {
               var1.add(this.extDTableGu.getRowData());
            }
         }

         this.newUser = (Users)var1.get(0);
         this.selectionUtilisateur();
      }

   }

   public void visualisationGu() throws IOException, JDOMException {
      if (this.newUser != null) {
         this.modifUser();
      }

   }

   public void selectionUtilisateurIn() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.extDTableIn != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionIn.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableIn.setRowKey(var3);
            if (this.extDTableIn.isRowAvailable()) {
               var1.add(this.extDTableIn.getRowData());
            }
         }

         this.newUser = (Users)var1.get(0);
         this.selectionUtilisateur();
      }

   }

   public void visualisationIn() throws IOException, JDOMException {
      if (this.newUser != null) {
         this.modifUser();
      }

   }

   public void selectionUtilisateurMed() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.extDTableMed != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionMed.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableMed.setRowKey(var3);
            if (this.extDTableMed.isRowAvailable()) {
               var1.add(this.extDTableMed.getRowData());
            }
         }

         this.newUser = (Users)var1.get(0);
         this.selectionUtilisateur();
      }

   }

   public void visualisationMed() throws IOException, JDOMException {
      if (this.newUser != null) {
         this.modifUser();
      }

   }

   public void selectionUtilisateur() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.newUser != null) {
         this.groupe = this.newUser.getGroupe();
         if (this.groupe == null && this.newUser.getUsrCollaboration() != null && !this.newUser.getUsrCollaboration().isEmpty()) {
            this.groupe = this.groupeDao.groupeByCode(this.newUser.getUsrCollaboration(), (Session)null);
            if (this.groupe == null) {
               this.groupe = new Groupe();
            }
         }

         this.memo_pw = this.newUser.getUsrPw();
         this.memo_cs = this.newUser.getUsrCodeSecret();
         if (this.newUser.getUsrService() != null && !this.newUser.getUsrService().isEmpty()) {
            this.libelleService = this.newUser.getUsrService() + ":" + this.newUser.getUsrDepartement() + ":" + this.newUser.getUsrSite();
         } else {
            this.libelleService = "";
         }

         if (this.newUser.getUsrServiceSecondaire() != null && !this.newUser.getUsrServiceSecondaire().isEmpty()) {
            this.libelleServiceSecondaire = this.newUser.getUsrServiceSecondaire() + ":" + this.newUser.getUsrDepartementSecondaire() + ":" + this.newUser.getUsrSiteSecondaire();
         } else {
            this.libelleServiceSecondaire = "";
         }

         if (this.structureLog.getStrmaitrecabinet() < 10 && this.newUser.getUsrMail() != null && !this.newUser.getUsrMail().isEmpty()) {
            this.disablemail = true;
         } else {
            this.disablemail = false;
         }

         this.mail_Mesg = false;
         if (this.newUser.getUsrSysteme() >= 1) {
            this.verif_admin = true;
         } else {
            this.verif_admin = false;
         }

         if (this.newUser.getUsrLogin() != null && !this.newUser.getUsrLogin().isEmpty()) {
            this.testAffPwdCS = false;
            this.testAffLogin = true;
         } else {
            this.testAffPwdCS = true;
            this.testAffLogin = false;
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         this.chargerlesUsersCoAdministration();
         this.chargerLesFonctions();
         this.chargerLesResponsables(var1);
         this.chargerMessageriesUsers(var1);
         this.chargerlesUsersChronosCpt(var1);
         this.chargerlesUsersChronosOff(var1);
         this.chargerlesUsersChronosAch(var1);
         this.chargerlesUsersChronosVte(var1);
         this.chargerlesUsersChronosCaisse(var1);
         this.chargerlesUsersChronosPaye(var1);
         this.chargerlesUsersChronosMed(var1);
         this.chargerlesUsersChronosPar(var1);
         this.lesTiersItems.clear();
         if (this.newUser.getUsrIdTiersGuest() != 0L) {
            this.lesTiersItems.add(new SelectItem(this.newUser.getUsrIdTiersGuest(), this.newUser.getUsrNomTiersGuest()));
         } else {
            this.lesTiersItems.add(new SelectItem(0, ""));
         }

         this.lesSalariesItems.clear();
         if (this.newUser.getUsrIdSalarieGuest() != 0L) {
            this.lesSalariesItems.add(new SelectItem(this.newUser.getUsrIdSalarieGuest(), this.newUser.getUsrNomSalarieGuest()));
         } else {
            this.lesSalariesItems.add(new SelectItem(0, ""));
         }

         int var3;
         int var4;
         if (this.structureLog.getStrtypeentreprise() != null && !this.structureLog.getStrtypeentreprise().isEmpty() && this.structureLog.getStrtypeentreprise().equals("2")) {
            this.lesProcessFavoris = this.usersFavorisDao.selectUsersProcess(this.newUser, var1);
            if (this.listeProcess.size() != 0) {
               new ProcessEnteteAchats();

               ProcessEnteteAchats var2;
               for(var3 = 0; var3 < this.listeProcess.size(); ++var3) {
                  var2 = (ProcessEnteteAchats)this.listeProcess.get(var3);
                  var2.setSelectProcess(false);
               }

               for(var3 = 0; var3 < this.listeProcess.size(); ++var3) {
                  var2 = (ProcessEnteteAchats)this.listeProcess.get(var3);
                  if (this.lesProcessFavoris.size() == 0) {
                     var2.setSelectProcess(false);
                  } else {
                     for(var4 = 0; var4 < this.lesProcessFavoris.size(); ++var4) {
                        if (((UsersFavoris)this.lesProcessFavoris.get(var4)).getUsrfavLogin().equals(var2.getProcesCode())) {
                           var2.setSelectProcess(true);
                           break;
                        }
                     }
                  }
               }
            }
         } else {
            this.listeProcess.clear();
         }

         this.dataModelProcessHabilites.setWrappedData(this.listeProcess);
         if (this.structureLog.getStrtypeentreprise() != null && !this.structureLog.getStrtypeentreprise().isEmpty() && (this.structureLog.getStrtypeentreprise().equals("0") || this.structureLog.getStrtypeentreprise().equals("2"))) {
            this.lesDepotsFavoris = this.usersFavorisDao.chargerUsersDepot(this.newUser, var1);
            if (this.listeDepot.size() != 0) {
               new DepotAchats();

               DepotAchats var5;
               for(var3 = 0; var3 < this.listeDepot.size(); ++var3) {
                  var5 = (DepotAchats)this.listeDepot.get(var3);
                  var5.setSelectDepot(false);
               }

               for(var3 = 0; var3 < this.listeDepot.size(); ++var3) {
                  var5 = (DepotAchats)this.listeDepot.get(var3);
                  if (this.lesDepotsFavoris.size() == 0) {
                     var5.setSelectDepot(false);
                  } else {
                     for(var4 = 0; var4 < this.lesDepotsFavoris.size(); ++var4) {
                        if (((UsersFavoris)this.lesDepotsFavoris.get(var4)).getUsrfavLogin().equals(var5.getDpoCode())) {
                           var5.setSelectDepot(true);
                           break;
                        }
                     }
                  }
               }
            }
         } else {
            this.listeDepot.clear();
         }

         this.dataModelDepotHabilites.setWrappedData(this.listeDepot);
         this.utilInitHibernate.closeSession();
         this.var_aff_bouton = true;
      } else {
         this.var_aff_bouton = false;
      }

   }

   public void agentActif() {
      this.typeSelectionne = 0;
      this.ongletActif = "userSt";
   }

   public void agentCoAdm() {
      this.typeSelectionne = 1;
      this.ongletActif = "userCoAdm";
   }

   public void agentAdm() {
      this.typeSelectionne = 2;
      this.ongletActif = "userAdm";
   }

   public void agentGuest() {
      this.typeSelectionne = 3;
      this.ongletActif = "userGu";
   }

   public void agentInActif() {
      this.typeSelectionne = 4;
      this.ongletActif = "userIn";
   }

   public void agentMed() {
      this.typeSelectionne = 5;
      this.ongletActif = "userMed";
   }

   public void annuleUser() {
      this.var_action = 0;
   }

   public void ajoutUser() throws IOException, JDOMException {
      this.newUser = new Users();
      this.newUser.setUsrNomPays(this.structureLog.getStrnompays());
      this.mail_Mesg = false;
      this.disablemail = false;
      this.testAffLogin = false;
      this.testAffPwdCS = true;
      this.newUser.setUsrCivilite("Madame");
      this.chargerLesFonctions();
      this.newUser.setUsrLogin("");
      this.newUser.setUsrPw("");
      this.newUser.setUsrPwEspaceClient("");
      this.var_action = 1;
   }

   public void valideAjout() throws IOException, JDOMException, HibernateException, NamingException {
      UserDao var1 = new UserDao(this.baseLog, this.utilInitHibernate);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.newUser.setUsrUserCreat(this.usersLog.getUsrid());
         this.newUser.setUsrDateCreat(new Date());
         this.calculGroupe(var2);
         this.calculSDS(var2);
         this.calculAttributFonction();
         if (this.newUser.getUsrPrenom() != null && !this.newUser.getUsrPrenom().isEmpty()) {
            this.newUser.setUsrPatronyme(this.newUser.getUsrNom() + " " + this.newUser.getUsrPrenom());
         } else {
            this.newUser.setUsrPatronyme(this.newUser.getUsrNom());
         }

         String var4 = "";
         if (this.newUser.getUsrDateNaissance() != null) {
            DateFormat var5 = DateFormat.getDateInstance(3);
            var4 = var5.format(this.newUser.getUsrDateNaissance()).substring(0, 5);
         }

         this.newUser.setUsrAnniversaire(var4);
         MD5Password var14;
         if (this.newUser.getUsrPw() != null && !this.newUser.getUsrPw().isEmpty()) {
            var14 = new MD5Password();
            this.newUser.setUsrPw(var14.getEncodedPassword(this.newUser.getUsrPw()));
         }

         if (this.newUser.getUsrCodeSecret() != null && !this.newUser.getUsrCodeSecret().isEmpty()) {
            var14 = new MD5Password();
            this.newUser.setUsrCodeSecret(var14.getEncodedPassword(this.newUser.getUsrCodeSecret()));
         }

         int var6;
         long var7;
         String var15;
         if (this.newUser.getUsrIdTiersGuest() == 0L) {
            this.newUser.setUsrNomTiersGuest("");
         } else {
            var15 = "";

            for(var6 = 0; var6 < this.lesTiersItems.size(); ++var6) {
               var7 = Long.parseLong(((SelectItem)this.lesTiersItems.get(var6)).getValue().toString());
               if (var7 == this.newUser.getUsrIdTiersGuest()) {
                  var15 = ((SelectItem)this.lesTiersItems.get(var6)).getLabel().toString();
                  break;
               }
            }

            this.newUser.setUsrNomTiersGuest(var15);
         }

         if (this.newUser.getUsrIdSalarieGuest() != 0L) {
            var15 = "";

            for(var6 = 0; var6 < this.lesSalariesItems.size(); ++var6) {
               var7 = Long.parseLong(((SelectItem)this.lesSalariesItems.get(var6)).getValue().toString());
               if (var7 == this.newUser.getUsrIdSalarieGuest()) {
                  var15 = ((SelectItem)this.lesSalariesItems.get(var6)).getLabel().toString();
                  break;
               }
            }

            this.newUser.setUsrNomSalarieGuest(var15);
         } else {
            this.newUser.setUsrNomSalarieGuest("");
         }

         this.newUser = var1.insert(this.newUser, var2);
         this.majProcessUser(var2);
         this.majDepotUser(var2);
         var3.commit();
      } catch (HibernateException var12) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var12;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.majPegUser(this.newUser);
      this.chargerUtilisateursSuite((Session)null);
      this.var_action = 0;
   }

   public void modifUser() throws IOException, JDOMException {
      this.var_action = 2;
   }

   public void valideModif() throws IOException, JDOMException, HibernateException, NamingException {
      UserDao var1 = new UserDao(this.baseLog, this.utilInitHibernate);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.newUser.setUsrUserModif(this.usersLog.getUsrid());
         this.newUser.setUsrDateModif(new Date());
         this.calculGroupe(var2);
         this.calculSDS(var2);
         this.calculAttributFonction();
         if (this.newUser.getUsrPrenom() != null && !this.newUser.getUsrPrenom().isEmpty()) {
            this.newUser.setUsrPatronyme(this.newUser.getUsrNom() + " " + this.newUser.getUsrPrenom());
         } else {
            this.newUser.setUsrPatronyme(this.newUser.getUsrNom());
         }

         String var4 = "";
         if (this.newUser.getUsrDateNaissance() != null) {
            DateFormat var5 = DateFormat.getDateInstance(3);
            var4 = var5.format(this.newUser.getUsrDateNaissance()).substring(0, 5);
         }

         this.newUser.setUsrAnniversaire(var4);
         if (this.newUser.getUsrService().isEmpty()) {
            this.newUser.setUsrCaissierService(0);
            this.newUser.setUsrProdService(0);
            this.newUser.setUsrProdServiceAch(0);
         }

         MD5Password var14;
         if (this.newUser.getUsrPw() != null && !this.newUser.getUsrPw().isEmpty() && !this.memo_pw.equals(this.newUser.getUsrPw())) {
            var14 = new MD5Password();
            this.newUser.setUsrPw(var14.getEncodedPassword(this.newUser.getUsrPw()));
         }

         if (this.newUser.getUsrCodeSecret() != null && !this.newUser.getUsrCodeSecret().isEmpty() && !this.memo_cs.equals(this.newUser.getUsrCodeSecret())) {
            var14 = new MD5Password();
            this.newUser.setUsrCodeSecret(var14.getEncodedPassword(this.newUser.getUsrCodeSecret()));
         }

         int var6;
         long var7;
         String var15;
         if (this.newUser.getUsrIdTiersGuest() == 0L) {
            this.newUser.setUsrNomTiersGuest("");
         } else {
            var15 = "";

            for(var6 = 0; var6 < this.lesTiersItems.size(); ++var6) {
               var7 = Long.parseLong(((SelectItem)this.lesTiersItems.get(var6)).getValue().toString());
               if (var7 == this.newUser.getUsrIdTiersGuest()) {
                  var15 = ((SelectItem)this.lesTiersItems.get(var6)).getLabel().toString();
                  break;
               }
            }

            this.newUser.setUsrNomTiersGuest(var15);
         }

         if (this.newUser.getUsrIdSalarieGuest() == 0L) {
            this.newUser.setUsrNomSalarieGuest("");
         } else {
            var15 = "";

            for(var6 = 0; var6 < this.lesSalariesItems.size(); ++var6) {
               var7 = Long.parseLong(((SelectItem)this.lesSalariesItems.get(var6)).getValue().toString());
               if (var7 == this.newUser.getUsrIdSalarieGuest()) {
                  var15 = ((SelectItem)this.lesSalariesItems.get(var6)).getLabel().toString();
                  break;
               }
            }

            this.newUser.setUsrNomSalarieGuest(var15);
         }

         this.newUser = var1.modUser(this.newUser, var2);
         this.majProcessUser(var2);
         this.majDepotUser(var2);
         var3.commit();
      } catch (HibernateException var12) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var12;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.majPegUser(this.newUser);
      if (this.lesStructuresPeg.size() != 0 && this.structureLog.getStrmaitrecabinet() >= 1 && this.structureLog.getStrmaitrecabinet() <= 9) {
         this.majUserStructure(this.newUser.getUsrMail());
      }

      this.chargerUtilisateursSuite((Session)null);
      this.var_action = 0;
   }

   public void majProcessUser(Session var1) {
      if (this.listeProcess.size() != 0) {
         new UsersFavoris();
         UsersFavoris var2;
         int var3;
         if (this.lesProcessFavoris.size() != 0) {
            for(var3 = 0; var3 < this.lesProcessFavoris.size(); ++var3) {
               var2 = (UsersFavoris)this.lesProcessFavoris.get(var3);
               this.usersFavorisDao.delete(var2, var1);
            }
         }

         for(var3 = 0; var3 < this.listeProcess.size(); ++var3) {
            if (((ProcessEnteteAchats)this.listeProcess.get(var3)).isSelectProcess()) {
               var2 = new UsersFavoris();
               var2.setUsrfavCiviliteUser(this.newUser.getUsrCivilite());
               var2.setUsrfavDateCreat(new Date());
               var2.setUsrfavFonctionUser(this.newUser.getUsrFonction());
               var2.setUsrfavIdUser(this.newUser.getUsrid());
               var2.setUsrfavLogin(((ProcessEnteteAchats)this.listeProcess.get(var3)).getProcesCode());
               var2.setUsrfavNature(4);
               var2.setUsrfavNom(((ProcessEnteteAchats)this.listeProcess.get(var3)).getProcesLibClient());
               var2.setUsrfavNomUser(this.newUser.getUsrNom());
               var2.setUsrfavPrenomUser(this.newUser.getUsrPrenom());
               var2.setUsrfavUserCreat(this.usersLog.getUsrid());
               var2.setUsrfavInactif(0);
               var2.setUsers(this.newUser);
               this.usersFavorisDao.insert(var2, var1);
            }
         }
      }

   }

   public void majDepotUser(Session var1) {
      if (this.listeDepot.size() != 0) {
         new UsersFavoris();
         UsersFavoris var2;
         int var3;
         if (this.lesDepotsFavoris.size() != 0) {
            for(var3 = 0; var3 < this.lesDepotsFavoris.size(); ++var3) {
               var2 = (UsersFavoris)this.lesDepotsFavoris.get(var3);
               this.usersFavorisDao.delete(var2, var1);
            }
         }

         for(var3 = 0; var3 < this.listeDepot.size(); ++var3) {
            if (((DepotAchats)this.listeDepot.get(var3)).isSelectDepot()) {
               var2 = new UsersFavoris();
               var2.setUsrfavCiviliteUser(this.newUser.getUsrCivilite());
               var2.setUsrfavDateCreat(new Date());
               var2.setUsrfavFonctionUser(this.newUser.getUsrFonction());
               var2.setUsrfavIdUser(this.newUser.getUsrid());
               var2.setUsrfavLogin(((DepotAchats)this.listeDepot.get(var3)).getDpoCode());
               var2.setUsrfavNature(5);
               var2.setUsrfavNom(((DepotAchats)this.listeDepot.get(var3)).getDpoLibelle());
               var2.setUsrfavNomUser(this.newUser.getUsrNom());
               var2.setUsrfavPrenomUser(this.newUser.getUsrPrenom());
               var2.setUsrfavUserCreat(this.usersLog.getUsrid());
               var2.setUsrfavInactif(0);
               var2.setUsers(this.newUser);
               this.usersFavorisDao.insert(var2, var1);
            }
         }
      }

   }

   public void majUserStructure(String var1) throws HibernateException, NamingException {
      if (var1 != null && !var1.isEmpty()) {
         new Users();

         for(int var3 = 0; var3 < this.lesStructuresPeg.size(); ++var3) {
            this.userDao = new UserDao("structure" + ((StructurePeg)this.lesStructuresPeg.get(var3)).getStrId(), this.utilInitHibernate);
            Users var2 = this.userDao.selectByMailUsers(var1, (Session)null);
            if (var2 != null) {
               this.groupe = this.groupeDao.groupeByCode(this.newUser.getUsrCollaboration(), (Session)null);
               if (this.groupe != null) {
                  var2.setGroupe(this.groupe);
                  var2.setUsrCollaboration(this.groupe.getGrpCode());
               } else {
                  var2.setGroupe((Groupe)null);
                  var2.setUsrCollaboration("");
               }

               var2.setUsrLogin(this.newUser.getUsrLogin());
               var2.setUsrCodeSecret(this.newUser.getUsrCodeSecret());
               var2.setUsrPw(this.newUser.getUsrPw());
               var2.setUsrMail(this.newUser.getUsrMail());
               var2.setUsrSysteme(this.newUser.getUsrSysteme());
               var2.setUsrEtat(this.newUser.getUsrEtat());
               var2.setUsrNom(this.newUser.getUsrNom());
               var2.setUsrPrenom(this.newUser.getUsrPrenom());
               var2.setUsrCivilite(this.newUser.getUsrCivilite());
               var2.setUsrDateNaissance(this.newUser.getUsrDateNaissance());
               var2.setUsrAdresse(this.newUser.getUsrAdresse());
               var2.setUsrBp(this.newUser.getUsrBp());
               var2.setUsrVille(this.newUser.getUsrVille());
               var2.setUsrNomPays(this.newUser.getUsrNomPays());
               var2.setUsrTelBureau(this.newUser.getUsrTelBureau());
               var2.setUsrTelDomicile(this.newUser.getUsrTelDomicile());
               var2.setUsrCel1(this.newUser.getUsrCel1());
               var2.setUsrCel1(this.newUser.getUsrCel2());
               var2.setUsrCel3(this.newUser.getUsrCel3());
               var2.setUsrTemplates(this.newUser.getUsrTemplates());
               var2.setUsrSkype(this.newUser.getUsrSkype());
               var2.setUsrChange(this.newUser.getUsrChange());
               var2.setUsrLangue(this.newUser.getUsrLangue());
               var2.setUsrFonction(this.newUser.getUsrFonction());
               var2.setUsrMetier(this.newUser.getUsrMetier());
               var2.setUsrInitiale(this.newUser.getUsrInitiale());
               var2.setUsrCompte(this.newUser.getUsrCompte());
               var2.setUsrStartup(this.newUser.getUsrStartup());
               var2.setUsrTiers(this.newUser.getUsrTiers());
               var2.setUsrPr(this.newUser.getUsrPr());
               var2.setUsrPv(this.newUser.getUsrPv());
               var2.setUsrJrxReserve(this.newUser.getUsrJrxReserve());
               var2.setUsrCreationSociete(this.newUser.getUsrCreationSociete());
               var2.setUsrDemandeurAchats(this.newUser.getUsrDemandeurAchats());
               var2.setUsrBaseCopie(this.newUser.getUsrBaseCopie());
               var2.setUsrSansHabilitation(this.newUser.getUsrSansHabilitation());
               var2.setUsrConfigListe(this.newUser.getUsrConfigListe());
               var2.setUsrAssistant(this.newUser.getUsrAssistant());
               var2.setUsrAccesCorrection(this.newUser.getUsrAccesCorrection());
               var2.setUsrModifLiasse(this.newUser.getUsrModifLiasse());
               var2.setUsrAccesBrouillard(this.newUser.getUsrAccesBrouillard());
               var2.setUsrSignatureCompta(this.newUser.getUsrSignatureCompta());
               this.userDao.modUser(var2);
            }
         }
      }

   }

   public void calculGroupe() throws HibernateException, NamingException {
      this.calculGroupe((Session)null);
   }

   public void calculGroupe(Session var1) throws HibernateException, NamingException {
      this.groupe = this.groupeDao.groupeByCode(this.newUser.getUsrCollaboration(), var1);
      if (this.groupe != null) {
         this.newUser.setGroupe(this.groupe);
         this.newUser.setUsrCollaboration(this.groupe.getGrpCode());
      } else {
         this.newUser.setGroupe((Groupe)null);
         this.newUser.setUsrCollaboration("");
      }

   }

   public void majPegUser(Users var1) throws HibernateException, NamingException {
      if (this.getNewUser().getUsrMail() != null && !this.getNewUser().getUsrMail().isEmpty() && this.getNewUser().getUsrLogin() != null && !this.getNewUser().getUsrLogin().isEmpty() && this.getNewUser().getUsrPw() != null && !this.getNewUser().getUsrPw().isEmpty()) {
         this.userDao = new UserDao(this.utilInitHibernate);
         UsersPeg var2 = this.userDao.logLoginExiste(this.getNewUser().getUsrLogin(), this.getNewUser().getUsrMail(), this.structureLog.getStrraisonsociale());
         if (var2 == null) {
            this.userDao.insertPeg(this.creerPegUser(this.getNewUser()));
         } else {
            var2.setUsradresse(this.getNewUser().getUsrAdresse());
            var2.setUsrbp(this.getNewUser().getUsrBp());
            var2.setUsrnom(this.getNewUser().getUsrNom());
            var2.setUsrprenom(this.getNewUser().getUsrPrenom());
            var2.setUsrpw(this.getNewUser().getUsrPw());
            var2.setUsrcodesecret(this.getNewUser().getUsrCodeSecret());
            var2.setUsrmail(this.getNewUser().getUsrMail());
            var2.setUsrlogin(this.getNewUser().getUsrLogin());
            var2.setUsretat(this.getNewUser().getUsrEtat());
            var2.setUsrsysteme(this.getNewUser().getUsrSysteme());
            var2.setUsrcabinet(this.getNewUser().getUsrCabinet());
            this.userDao.ModUserPeg(var2);
         }
      }

   }

   public UsersPeg creerPegUser(Users var1) {
      UsersPeg var2 = new UsersPeg();
      StructurePeg var3 = new StructurePeg();
      var3.setStrId(this.structureLog.getStrid());
      var2.setStructurePeg(var3);
      var2.setUsradresse(var1.getUsrAdresse());
      var2.setUsrbp(var1.getUsrBp());
      var2.setUsrnom(var1.getUsrNom());
      var2.setUsrprenom(var1.getUsrPrenom());
      var2.setUsrpw(var1.getUsrPw());
      var2.setUsrcodesecret(var1.getUsrCodeSecret());
      var2.setUsrmail(var1.getUsrMail());
      var2.setUsrlogin(var1.getUsrLogin());
      var2.setUsretat(var1.getUsrEtat());
      var2.setUsrsysteme(0);
      var2.setUsrcabinet(this.getNewUser().getUsrCabinet());
      return var2;
   }

   public void supUser() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.getNewUser().getUsrSysteme() <= 1) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            List var3 = this.usersChronoDao.selectListByUser(this.newUser, var1);
            if (var3.size() != 0) {
               for(int var4 = 0; var4 < var3.size(); ++var4) {
                  this.usersChrono = (UsersChrono)var3.get(var4);
                  this.usersChronoDao.delete(this.usersChrono, var1);
               }
            }

            new ArrayList();
            List var15 = this.usersFavorisDao.chargerUsersFavoris(this.newUser, var1);
            if (var15.size() != 0) {
               for(int var5 = 0; var5 < var15.size(); ++var5) {
                  new UsersFavoris();
                  UsersFavoris var6 = (UsersFavoris)var15.get(var5);
                  this.usersFavorisDao.delete(var6, var1);
               }
            }

            var2.commit();
         } catch (HibernateException var12) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         String var14 = this.newUser.getUsrPw();
         String var16 = this.newUser.getUsrLogin();
         boolean var17 = false;
         EspionDao var18 = new EspionDao(this.baseLog, this.utilInitHibernate);
         var17 = var18.verifUser(this.newUser.getUsrid());
         if (!var17) {
            this.userDao.delUsers(this.newUser);
         } else {
            this.newUser.setUsrEtat(0);
            this.newUser.setUsrPw("");
            this.newUser.setUsrCodeSecret("");
            this.newUser = this.userDao.modUser(this.newUser);
         }

         this.userDao = new UserDao(this.utilInitHibernate);
         UsersPeg var7 = this.userDao.trouveUserPegExiste(var16, var14, this.structureLog.getStrid());
         if (var7 != null) {
            this.userDao.delUserspeg(var7.getUsrid());
         }

         this.chargerUtilisateurs();
         if (this.lesStructuresPeg.size() != 0) {
            new Users();

            for(int var9 = 0; var9 < this.lesStructuresPeg.size(); ++var9) {
               this.userDao = new UserDao("structure" + ((StructurePeg)this.lesStructuresPeg.get(var9)).getStrId(), this.utilInitHibernate);
               Users var8 = this.userDao.selectByMailUsers(this.newUser.getUsrMail(), (Session)null);
               if (var8 != null) {
                  var8.setUsrEtat(0);
                  this.userDao.modUser(var8);
               }
            }
         }
      }

   }

   public void mailUser() throws Exception {
      if (this.newUser != null && this.newUser.getUsrMail() != null && !this.newUser.getUsrMail().isEmpty()) {
         this.rePrintPwd("**********", "**********");
      }

   }

   public void regenererPwd() throws Exception {
      if (!this.newUser.getUsrMail().equals("") && this.newUser.getUsrMail() != null && !this.newUser.getUsrNom().equals("") && this.newUser.getUsrNom() != null) {
         UserDao var1 = new UserDao(this.baseLog, this.utilInitHibernate);
         this.newUser.setUsrUserModif(this.usersLog.getUsrid());
         this.newUser.setUsrDateModif(new Date());
         this.calculSDS((Session)null);
         String var2 = "";
         if (this.newUser.getUsrDateNaissance() != null) {
            DateFormat var3 = DateFormat.getDateInstance(3);
            var2 = var3.format(this.newUser.getUsrDateNaissance()).substring(0, 5);
         }

         this.newUser.setUsrAnniversaire(var2);
         RandPass var7 = new RandPass();
         String var4 = var7.calculPwd();
         String var5 = var7.calculPwd();
         MD5Password var6 = new MD5Password();
         this.newUser.setUsrPw(var6.getEncodedPassword(var4));
         this.newUser.setUsrCodeSecret(var6.getEncodedPassword(var5));
         this.newUser.setUsrEtat(1);
         this.newUser = var1.modUser(this.newUser);
         this.majPegUser(this.newUser);
         this.reInitPwd(var4, var5);
         if (this.lesStructuresPeg.size() != 0) {
            this.majUserStructure(this.newUser.getUsrMail());
         }
      }

      this.var_action = 0;
   }

   public String reInitPwd(String var1, String var2) throws Exception {
      String var3 = "<html><head></head><body ><h:form>";
      var3 = var3 + "<table style=\"border:1px dotted green\" align=\"center\" width=\"60%\">";
      var3 = var3 + "<thead><tr><th><h1>Bienvenue sur e-P&eacute;gase!</h1></th></tr></thead>";
      var3 = var3 + "<tbody><tr><td>Bonjour<br/>A votre demande de changement d'acc&egrave;s , vous ";
      var3 = var3 + "trouverez ci-dessous les nouveaux param&ecirc;tres de connexion &agrave; votre compte e-P&eacute;gase:";
      var3 = var3 + "<h2>Rappel:</h2><pstyle=\"background-color:green;color:white;font-weight:bold;width:100%\"><center>Informations sur la soci&eacute;t&eacute;</center></p>";
      var3 = var3 + "Raison sociale : &nbsp; " + this.structureLog.getStrraisonsociale() + "<br/>";
      var3 = var3 + "Adresse:&nbsp; " + this.structureLog.getStradresse() + "<br/>Boite Postale :&nbsp; " + this.structureLog.getStrbp() + "<br/>Ville :&nbsp; " + this.structureLog.getStrville() + " <br/>T&eacute;l&eacute;phone :&nbsp; " + this.structureLog.getStrtel1() + "<br/> ";
      var3 = var3 + "Fax:&nbsp; " + this.structureLog.getStrfax() + "<br/>Pays:&nbsp; " + this.structureLog.getStrnompays() + "<br/>Devise:&nbsp; " + this.structureLog.getStrdevise();
      var3 = var3 + "<br/>Langue:&nbsp; " + this.structureLog.getStrlangue() + "<br/><p style=\"background-color:green;color:white;font-weight:bold;width:100%\"><center>Informations";
      var3 = var3 + " sur le compte</center></p><br/>";
      var3 = var3 + "Pr&eacute;nom :&nbsp; " + this.newUser.getUsrPrenom() + "<br/>";
      var3 = var3 + "Nom :&nbsp; " + this.newUser.getUsrNom() + "<br/>";
      var3 = var3 + "Email :&nbsp; " + this.newUser.getUsrMail() + "<br/>";
      if (this.structureLog.getStrsigle() != null && !this.structureLog.getStrsigle().isEmpty()) {
         var3 = var3 + "Société :&nbsp; " + this.structureLog.getStrsigle() + "<br/>";
      } else {
         var3 = var3 + "Société :&nbsp; " + this.structureLog.getStrraisonsociale() + "<br/>";
      }

      var3 = var3 + "Login :&nbsp; " + this.newUser.getUsrLogin() + "<br/>";
      if (var1 != null && !var1.isEmpty()) {
         var3 = var3 + "Nouveau mot de passe:&nbsp; " + var1 + "<br/>";
      }

      if (var2 != null && !var2.isEmpty()) {
         var3 = var3 + "Nouveau code secret :&nbsp; " + var2 + "<br/>";
      }

      var3 = var3 + "Pour toutes informations sur votre compte, sur les offres ";
      var3 = var3 + "et sur les services e-P&eacute;gase... Contactez notre standard au (+221) 33 820 85 65<br/>";
      var3 = var3 + "Merci d'utiliser e-P&eacute;gase !<br/><br/>L'&eacute;quipe e-P&eacute;gase<br/><br/>";
      var3 = var3 + "<i style=\"color:red;font-size:11px;\">Ce message vous est ";
      var3 = var3 + "envoy&eacute; automatiquement.</i></td></tr><tr><td></td></tr></tbody></table>";
      var3 = var3 + "</h:form></body></html>";
      UtilMail var4 = new UtilMail(this.structureLog);
      var4.mailInscription(var3, this.newUser.getUsrMail(), "CHANGEMENT ACCES/REACTIVATION COMPTE");
      return "inscription";
   }

   public String rePrintPwd(String var1, String var2) throws Exception {
      String var3 = "<html><head></head><body ><h:form>";
      var3 = var3 + "<table style=\"border:1px dotted green\" align=\"center\" width=\"60%\">";
      var3 = var3 + "<thead><tr><th><h1>Bienvenue sur e-P&eacute;gase!</h1></th></tr></thead>";
      var3 = var3 + "<tbody><tr><td>Bonjour<br/>A votre demande de changement d'acc&egrave;s , vous ";
      var3 = var3 + "trouverez ci-dessous les identifiants de connexion &agrave; votre compte e-P&eacute;gase:";
      var3 = var3 + "<h2>Rappel:</h2><pstyle=\"background-color:green;color:white;font-weight:bold;width:100%\"><center>Informations sur la soci&eacute;t&eacute;</center></p>";
      var3 = var3 + "Raison sociale : &nbsp; " + this.structureLog.getStrraisonsociale() + "<br/>";
      var3 = var3 + "Adresse:&nbsp; " + this.structureLog.getStradresse() + "<br/>Boite Postale :&nbsp; " + this.structureLog.getStrbp() + "<br/>Ville :&nbsp; " + this.structureLog.getStrville() + " <br/>T&eacute;l&eacute;phone :&nbsp; " + this.structureLog.getStrtel1() + "<br/> ";
      var3 = var3 + "Fax:&nbsp; " + this.structureLog.getStrfax() + "<br/>Pays:&nbsp; " + this.structureLog.getStrnompays() + "<br/>Devise:&nbsp; " + this.structureLog.getStrdevise();
      var3 = var3 + "<br/>Langue:&nbsp; " + this.structureLog.getStrlangue() + "<br/><p style=\"background-color:green;color:white;font-weight:bold;width:100%\"><center>Informations";
      var3 = var3 + " sur le compte</center></p><br/>";
      var3 = var3 + "Pr&eacute;nom :&nbsp; " + this.newUser.getUsrPrenom() + "<br/>";
      var3 = var3 + "Nom :&nbsp; " + this.newUser.getUsrNom() + "<br/>";
      var3 = var3 + "Email :&nbsp; " + this.newUser.getUsrMail() + "<br/>";
      if (this.structureLog.getStrsigle() != null && !this.structureLog.getStrsigle().isEmpty()) {
         var3 = var3 + "Société :&nbsp; " + this.structureLog.getStrsigle() + "<br/>";
      } else {
         var3 = var3 + "Société :&nbsp; " + this.structureLog.getStrraisonsociale() + "<br/>";
      }

      var3 = var3 + "Login :&nbsp; " + this.newUser.getUsrLogin() + "<br/>";
      if (var1 != null && !var1.isEmpty()) {
         var3 = var3 + "Nouveau mot de passe:&nbsp; " + var1 + "<br/>";
      }

      if (var2 != null && !var2.isEmpty()) {
         var3 = var3 + "Nouveau code secret :&nbsp; " + var2 + "<br/>";
      }

      var3 = var3 + "Pour toutes informations sur votre compte, sur les offres ";
      var3 = var3 + "et sur les services e-P&eacute;gase... Contactez notre standard au (+221) 33 820 85 65<br/>";
      var3 = var3 + "Merci d'utiliser e-P&eacute;gase !<br/><br/>L'&eacute;quipe e-P&eacute;gase<br/><br/>";
      var3 = var3 + "<i style=\"color:red;font-size:11px;\">Ce message vous est ";
      var3 = var3 + "envoy&eacute; automatiquement.</i></td></tr><tr><td></td></tr></tbody></table>";
      var3 = var3 + "</h:form></body></html>";
      UtilMail var4 = new UtilMail(this.structureLog);
      var4.mailInscription(var3, this.newUser.getUsrMail(), "CHANGEMENT ACCES/REACTIVATION COMPTE");
      return "inscription";
   }

   public void verifLoginExiste() throws HibernateException, NamingException {
      if (this.newUser.getUsrLogin() != null && !this.newUser.getUsrLogin().isEmpty()) {
         if (this.userDao.logLoginExiste(this.newUser.getUsrLogin(), this.structureLog.getStrraisonsociale()) != null) {
            this.mail_Mesg = true;
            this.testAffLogin = false;
            this.newUser.setUsrEtat(0);
         } else {
            this.mail_Mesg = false;
            this.testAffLogin = false;
            this.newUser.setUsrEtat(1);
         }
      } else {
         this.mail_Mesg = false;
         this.testAffLogin = false;
         this.newUser.setUsrEtat(0);
      }

   }

   public void ouvrirChangeIdentifiant() {
      if (this.newUser != null) {
         this.md = false;
         this.cs = false;
         this.mail = false;
         this.var_old_mail = this.newUser.getUsrMail();
         this.var_old_pw = this.newUser.getUsrPw();
         this.showModalPanelChangeIdentifiant = true;
      }

   }

   public void comptaLienMd() {
      this.md = true;
   }

   public void comptaLienCs() {
      this.cs = true;
   }

   public void comptaLienMail() {
      this.mail = true;
   }

   public void fermerChangeIdentifiant() {
      this.showModalPanelChangeIdentifiant = false;
   }

   public void valideChangeIdentifiant() throws HibernateException, NamingException, Exception {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      String var1 = "";
      String var2 = "";
      String var3 = "";
      MD5Password var4;
      if (this.md) {
         var1 = this.newUser.getUsrPw();
         var4 = new MD5Password();
         this.newUser.setUsrPw(var4.getEncodedPassword(this.newUser.getUsrPw()));
      }

      if (this.cs) {
         var2 = this.newUser.getUsrCodeSecret();
         var4 = new MD5Password();
         this.newUser.setUsrCodeSecret(var4.getEncodedPassword(this.newUser.getUsrCodeSecret()));
      }

      if (this.mail) {
         var3 = this.newUser.getUsrMail();
      }

      if (var1 != null && !var1.isEmpty() || var2 != null && !var2.isEmpty() || var3 != null && !var3.isEmpty()) {
         this.newUser = this.userDao.modUser(this.newUser);
         this.userDao = new UserDao(this.utilInitHibernate);
         new UsersPeg();
         UsersPeg var5 = this.userDao.trouveUserPegExiste(this.newUser.getUsrLogin(), this.var_old_pw, this.structureLog.getStrid());
         if (var5 != null) {
            var5.setUsrdatemodif(new Date());
            var5.setUsrpw(this.newUser.getUsrPw());
            var5.setUsrcodesecret(this.newUser.getUsrCodeSecret());
            var5.setUsrmail(this.newUser.getUsrMail());
            this.userDao.ModUserPeg(var5);
         }

         this.md = false;
         this.cs = false;
         this.mail = false;
         if (StaticModePegase.getInternet_actif() >= 1) {
            this.reInitPwd(var1, var2);
         }
      }

      if (this.lesStructuresPeg.size() != 0) {
         this.majUserStructure(this.var_old_mail);
      }

      this.showModalPanelChangeIdentifiant = false;
   }

   public void chargerlesUsersCoAdministration() throws HibernateException, NamingException, IOException {
      MenudroitCoAdministrationCtrl var1 = new MenudroitCoAdministrationCtrl();
      var1.setStructureLog(this.structureLog);
      var1.setBaseLog(this.baseLog);
      boolean var2 = false;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty() && this.structureLog.getStrmod1().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty() && this.structureLog.getStrmod2().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty() && this.structureLog.getStrmod3().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty() && this.structureLog.getStrmod4().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty() && this.structureLog.getStrmod5().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty() && this.structureLog.getStrmod6().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty() && this.structureLog.getStrmod7().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty() && this.structureLog.getStrmod8().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty() && this.structureLog.getStrmod9().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty() && this.structureLog.getStrmod10().equals("40300")) {
         var2 = true;
      }

      var1.chargerMenuCoAdministrationXml(this.newUser.getUsrid(), var2);
      this.listLigneMenus = var1.getListLigneMenusUser();
      this.datamodelCoAdministration.setWrappedData(this.listLigneMenus);
      this.ligneMenu = null;
   }

   public void selectionFonction() {
      if (this.datamodelCoAdministration.isRowAvailable()) {
         this.ligneMenu = (ObjetLigneMenu)this.datamodelCoAdministration.getRowData();
      }

   }

   public void ajoutFonction() throws IOException {
      MenudroitCoAdministrationCtrl var1 = new MenudroitCoAdministrationCtrl();
      var1.setStructureLog(this.structureLog);
      var1.setBaseLog(this.baseLog);
      boolean var2 = false;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty() && this.structureLog.getStrmod1().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty() && this.structureLog.getStrmod2().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty() && this.structureLog.getStrmod3().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty() && this.structureLog.getStrmod4().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty() && this.structureLog.getStrmod5().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty() && this.structureLog.getStrmod6().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty() && this.structureLog.getStrmod7().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty() && this.structureLog.getStrmod8().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty() && this.structureLog.getStrmod9().equals("40300")) {
         var2 = true;
      } else if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty() && this.structureLog.getStrmod10().equals("40300")) {
         var2 = true;
      }

      var1.chargerMenuCoAdministrationGlobalXml(var2);
      this.listLigneMenusConfig = var1.getListLigneMenusGlobal();
      this.datamodelCoConfig.setWrappedData(this.listLigneMenusConfig);
      this.showModalPanelFonction = true;
      this.ligneMenu = null;
   }

   public void supprimeFonction() throws IOException {
      if (this.ligneMenu != null) {
         this.listLigneMenus.remove(this.ligneMenu);
         this.datamodelCoAdministration.setWrappedData(this.listLigneMenus);
         this.miseAjourFonctionXml();
      }

   }

   public void selectionCoConfig() {
      if (this.datamodelCoConfig.isRowAvailable()) {
         this.ligneMenu = (ObjetLigneMenu)this.datamodelCoConfig.getRowData();
      }

   }

   public void validerFonction() throws IOException {
      if (this.ligneMenu != null) {
         String var1 = this.ligneMenu.getLibelle_FR();
         boolean var2 = false;
         if (this.listLigneMenus != null && this.listLigneMenus.size() != 0) {
            for(int var3 = 0; var3 < this.listLigneMenus.size(); ++var3) {
               if (((ObjetLigneMenu)this.listLigneMenus.get(var3)).getLibelle_FR().equals(var1)) {
                  var2 = true;
                  break;
               }
            }
         }

         if (!var2) {
            if (this.listLigneMenus == null) {
               this.listLigneMenus = new ArrayList();
            }

            this.listLigneMenus.add(this.ligneMenu);
            this.datamodelCoAdministration.setWrappedData(this.listLigneMenus);
            this.miseAjourFonctionXml();
         }
      }

      this.showModalPanelFonction = false;
   }

   public void miseAjourFonctionXml() throws IOException {
      if (this.listLigneMenus.size() != 0) {
         this.racine = new Element("M00101");
         this.document = new Document(this.racine);
         this.racine.removeContent();

         for(int var1 = 0; var1 < this.listLigneMenus.size(); ++var1) {
            new ObjetLigneMenu();
            ObjetLigneMenu var2 = (ObjetLigneMenu)this.listLigneMenus.get(var1);
            Element var3 = new Element("lignemenu");
            Element var4 = new Element("libelle_FR");
            var3.addContent(var4);
            var4.setText(var2.getLibelle_FR());
            Element var5 = new Element("libelle_UK");
            var3.addContent(var5);
            var5.setText(var2.getLibelle_UK());
            Element var6 = new Element("libelle_SP");
            var3.addContent(var6);
            var6.setText(var2.getLibelle_SP());
            Element var7 = new Element("pagemenu");
            var3.addContent(var7);
            var7.setText(var2.getPagemenu());
            Element var8 = new Element("commande");
            var3.addContent(var8);
            var8.setText(var2.getCommande());
            Element var9 = new Element("type");
            var3.addContent(var9);
            var9.setText(var2.getType());
            Element var10 = new Element("genre");
            var3.addContent(var10);
            var10.setText(var2.getGenre());
            Element var11 = new Element("acc");
            var3.addContent(var11);
            var11.setText("" + var2.isAcc());
            Element var12 = new Element("add");
            var3.addContent(var12);
            var12.setText("" + var2.isAdd());
            Element var13 = new Element("dup");
            var3.addContent(var13);
            var13.setText("" + var2.isDup());
            Element var14 = new Element("maj");
            var3.addContent(var14);
            var14.setText("" + var2.isMaj());
            Element var15 = new Element("sup");
            var3.addContent(var15);
            var15.setText("" + var2.isSup());
            Element var16 = new Element("imp");
            var3.addContent(var16);
            var16.setText("" + var2.isImp());
            Element var17 = new Element("clo");
            var3.addContent(var17);
            var17.setText("" + var2.isClo());
            Element var18 = new Element("trf");
            var3.addContent(var18);
            var18.setText("" + var2.isTrf());
            this.racine.addContent(var3);
         }

         XMLOutputter var19 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var20 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "menu_defaut" + File.separator + "00101-" + this.newUser.getUsrid() + ".xml");
         var19.output(this.document, var20);
         var20.close();
      }

   }

   public void annulerFonction() {
      this.showModalPanelFonction = false;
   }

   public void calculSDS() throws HibernateException, NamingException {
      this.calculSDS((Session)null);
   }

   public void calculSDS(Session var1) throws HibernateException, NamingException {
      this.newUser.setUsrDepartement("");
      this.newUser.setUsrSite("");
      String[] var2;
      String var3;
      String var4;
      String var5;
      ServiceDao var6;
      Service var7;
      DepartementDao var8;
      Departement var9;
      SiteDao var10;
      Site var11;
      if (this.libelleService != null && !this.libelleService.isEmpty()) {
         if (this.libelleService.contains(":")) {
            var2 = this.libelleService.split(":");
            var3 = var2[0];
            var4 = var2[2];
            var5 = var2[4];
            if (var3 != null && !var3.isEmpty()) {
               var6 = new ServiceDao(this.baseLog, this.utilInitHibernate);
               new Service();
               var7 = var6.chargerLeServiceCode(var3, var1);
               if (var7 != null) {
                  this.newUser.setUsrService(var7.getSerCode() + ":" + var7.getSerNomFr());
                  var8 = new DepartementDao(this.baseLog, this.utilInitHibernate);
                  new Departement();
                  var9 = var8.chargerLesDepartementsByCode(var4, var1);
                  if (var9 != null) {
                     this.newUser.setUsrDepartement(var9.getDepCode() + ":" + var9.getDepNomFr());
                     var10 = new SiteDao(this.baseLog, this.utilInitHibernate);
                     new Site();
                     var11 = var10.rechercheSite(var5, var1);
                     if (var11 != null) {
                        this.newUser.setUsrSite(var11.getSitCode() + ":" + var11.getSitNomFr());
                     }
                  }
               }
            }
         }
      } else {
         this.newUser.setUsrService("");
         this.newUser.setUsrDepartement("");
         this.newUser.setUsrSite("");
         this.newUser.setUsrProdService(0);
         this.newUser.setUsrProdServiceAch(0);
         this.newUser.setUsrProdService(0);
         this.newUser.setUsrProdServiceAch(0);
      }

      if (this.libelleServiceSecondaire != null && !this.libelleServiceSecondaire.isEmpty()) {
         var2 = this.libelleServiceSecondaire.split(":");
         var3 = var2[0];
         var4 = var2[2];
         var5 = var2[4];
         if (var3 != null && !var3.isEmpty()) {
            var6 = new ServiceDao(this.baseLog, this.utilInitHibernate);
            new Service();
            var7 = var6.chargerLeServiceCode(var3, var1);
            if (var7 != null) {
               this.newUser.setUsrServiceSecondaire(var7.getSerCode() + ":" + var7.getSerNomFr());
               var8 = new DepartementDao(this.baseLog, this.utilInitHibernate);
               new Departement();
               var9 = var8.chargerLesDepartementsByCode(var4, var1);
               if (var9 != null) {
                  this.newUser.setUsrDepartementSecondaire(var9.getDepCode() + ":" + var9.getDepNomFr());
                  var10 = new SiteDao(this.baseLog, this.utilInitHibernate);
                  new Site();
                  var11 = var10.rechercheSite(var5, var1);
                  if (var11 != null) {
                     this.newUser.setUsrSiteSecondaire(var11.getSitCode() + ":" + var11.getSitNomFr());
                  }
               }
            }
         }
      } else {
         this.newUser.setUsrServiceSecondaire("");
         this.newUser.setUsrDepartementSecondaire("");
         this.newUser.setUsrSiteSecondaire("");
      }

   }

   public void calculAttributFonction() {
      if (this.newUser.getUsrFonction() != null && !this.newUser.getUsrFonction().isEmpty() && (this.newUser.getUsrFonction().equals("Agent Commercial") || this.newUser.getUsrFonction().equals("Assistant Commercial") || this.newUser.getUsrFonction().equals("Assistante Commercial") || this.newUser.getUsrFonction().equals("Chargé de Clientèle") || this.newUser.getUsrFonction().equals("Chargée de Clientèle"))) {
         this.newUser.setUsrVendeur(1);
      }

   }

   public void chargerlesUsersChronosCpt(Session var1) throws HibernateException, NamingException {
      this.usersChronoListCpt.clear();
      this.usersChronoListCpt = this.usersChronoDao.selectListComptaByUser(this.newUser, var1);
      this.datamodelUsersChronoCpt.setWrappedData(this.usersChronoListCpt);
      this.testSelectSerieCpt = false;
      this.visibiliteBtonCpt = true;
   }

   public void selectionLesUsersCpt() {
      if (this.datamodelUsersChronoCpt.isRowAvailable()) {
         this.usersChrono = (UsersChrono)this.datamodelUsersChronoCpt.getRowData();
         String var1 = "";

         for(int var2 = 0; var2 < this.mesChronoComptaItems.size(); ++var2) {
            if (((SelectItem)this.mesChronoComptaItems.get(var2)).getValue().toString().startsWith("" + this.usersChrono.getUsrchrNature() + ":")) {
               String[] var3 = ((SelectItem)this.mesChronoComptaItems.get(var2)).getValue().toString().split(":");
               var1 = var3[1];
               break;
            }
         }

         this.inputChronoCpt = this.usersChrono.getUsrchrNature() + ":" + var1;
         this.visibiliteBtonCpt = true;
      }

   }

   public void ajoutChronoCpt() {
      this.usersChrono = new UsersChrono();
      this.inputChronoCpt = "";
      this.var_aff_val_chronoCpt = false;
      this.showModalPanelCpt = true;
   }

   public void modifChronoCpt() {
      if (this.usersChrono != null) {
         this.var_aff_val_chronoCpt = true;
         this.showModalPanelCpt = true;
      }

   }

   public void supprimerChronoCpt() throws HibernateException, NamingException {
      if (this.usersChrono != null) {
         this.usersChronoDao.delete(this.usersChrono.getUsrchrId());
         this.chargerlesUsersChronosCpt((Session)null);
      }

   }

   public void verifChronoCpt() throws HibernateException, NamingException {
      this.verifChronoCpt((Session)null);
   }

   public void verifChronoCpt(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (this.inputChronoCpt != null && this.inputChronoCpt.contains(":")) {
         new Chrono();
         String[] var4 = this.inputChronoCpt.split(":");
         int var5 = Integer.parseInt(var4[0]);
         if (this.usersChronoListCpt.size() != 0) {
            for(int var6 = 0; var6 < this.usersChronoListCpt.size(); ++var6) {
               if (var5 == ((UsersChrono)this.usersChronoListCpt.get(var6)).getUsrchrNature()) {
                  var2 = true;
                  break;
               }
            }
         }

         if (var2) {
            this.var_aff_val_chronoCpt = false;
         } else {
            this.var_aff_val_chronoCpt = true;
            Chrono var3 = this.chronoDao.chronoByNat(var5, var1);
            if (var3 != null) {
               this.usersChrono.setUsrchrNature(var3.getChrNature());
               this.usersChrono.setUsrchrPrive(var3.getChrPrive());
               this.usersChrono.setUsrchrSerie(var3.getChrSerie());
               this.usersChrono.setUsrchrLib(var3.getLibnature());
            } else {
               this.usersChrono.setUsrchrNature(0);
               this.usersChrono.setUsrchrPrive(0);
               this.usersChrono.setUsrchrSerie("");
               this.usersChrono.setUsrchrLib("");
            }
         }
      }

   }

   public void validerChronoCpt() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.validerChronoCpt(var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void validerChronoCpt(Session var1) throws HibernateException, NamingException {
      if (this.usersChrono.getUsrchrNature() != 0) {
         if (this.usersChrono.getUsrchrId() == 0L) {
            this.usersChrono.setUsers(this.newUser);
            this.usersChrono.setUsrchrDateCreat(new Date());
            this.usersChrono.setUsrchrUserCreat(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.insert(this.usersChrono, var1);
            this.usersChronoListCpt.add(this.usersChrono);
            this.datamodelUsersChronoCpt.setWrappedData(this.usersChronoListCpt);
         } else {
            this.usersChrono.setUsrchrDateModif(new Date());
            this.usersChrono.setUsrchrUserModif(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.modifier(this.usersChrono, var1);
         }

         this.showModalPanelCpt = false;
      }

   }

   public void annuleCpt() {
      this.showModalPanelCpt = false;
   }

   public void ajoutAutoChronoCpt() throws HibernateException, NamingException {
      if (this.mesChronoComptaItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoComptaItems.size(); ++var3) {
               this.inputChronoCpt = ((SelectItem)this.mesChronoComptaItems.get(var3)).getValue().toString();
               this.usersChrono = new UsersChrono();
               this.verifChronoCpt(var1);
               if (this.var_aff_val_chronoCpt) {
                  this.usersChrono.setUsrchrUpdate(0);
                  this.usersChrono.setUsrchrValidation(2);
                  this.usersChrono.setUsrchrDeValidation(1);
                  this.usersChrono.setUsrchrDupplication(1);
                  this.validerChronoCpt(var1);
               }
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void chargerlesUsersChronosOff(Session var1) throws HibernateException, NamingException {
      this.usersChronoListOff.clear();
      this.usersChronoListOff = this.usersChronoDao.selectListOfficeByUser(this.newUser, var1);
      this.datamodelUsersChronoOff.setWrappedData(this.usersChronoListOff);
      this.testSelectSerieOff = false;
      this.visibiliteBtonOff = true;
   }

   public void selectionLesUsersOffice() {
      if (this.datamodelUsersChronoOff.isRowAvailable()) {
         this.usersChrono = (UsersChrono)this.datamodelUsersChronoOff.getRowData();
         String var1 = "";

         for(int var2 = 0; var2 < this.mesChronoOfficeItems.size(); ++var2) {
            if (((SelectItem)this.mesChronoOfficeItems.get(var2)).getValue().toString().startsWith("" + this.usersChrono.getUsrchrNature() + ":")) {
               String[] var3 = ((SelectItem)this.mesChronoOfficeItems.get(var2)).getValue().toString().split(":");
               var1 = var3[1];
               break;
            }
         }

         this.inputChronoOff = this.usersChrono.getUsrchrNature() + ":" + var1;
         this.visibiliteBtonOff = true;
      }

   }

   public void ajoutChronoOff() {
      this.usersChrono = new UsersChrono();
      this.inputChronoOff = "";
      this.var_aff_val_chronoOff = false;
      this.showModalPanelOffice = true;
   }

   public void modifChronoOff() {
      if (this.usersChrono != null) {
         this.var_aff_val_chronoOff = true;
         this.showModalPanelOffice = true;
      }

   }

   public void supprimerChronoOff() throws HibernateException, NamingException {
      if (this.usersChrono != null) {
         this.usersChronoDao.delete(this.usersChrono.getUsrchrId());
         this.chargerlesUsersChronosOff((Session)null);
      }

   }

   public void verifChronoOff() throws HibernateException, NamingException {
      this.verifChronoOff((Session)null);
   }

   public void verifChronoOff(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (this.inputChronoOff != null && this.inputChronoOff.contains(":")) {
         new Chrono();
         String[] var4 = this.inputChronoOff.split(":");
         int var5 = Integer.parseInt(var4[0]);
         if (this.usersChronoListOff.size() != 0) {
            for(int var6 = 0; var6 < this.usersChronoListOff.size(); ++var6) {
               if (var5 == ((UsersChrono)this.usersChronoListOff.get(var6)).getUsrchrNature()) {
                  var2 = true;
                  break;
               }
            }
         }

         if (var2) {
            this.var_aff_val_chronoOff = false;
         } else {
            this.var_aff_val_chronoOff = true;
            Chrono var3 = this.chronoDao.chronoByNat(var5, var1);
            if (var3 != null) {
               this.usersChrono.setUsrchrNature(var3.getChrNature());
               this.usersChrono.setUsrchrPrive(var3.getChrPrive());
               this.usersChrono.setUsrchrSerie(var3.getChrSerie());
               this.usersChrono.setUsrchrLib(var3.getLibnature() + " " + var3.getChrNom());
            } else {
               this.usersChrono.setUsrchrNature(0);
               this.usersChrono.setUsrchrPrive(0);
               this.usersChrono.setUsrchrSerie("");
               this.usersChrono.setUsrchrLib("");
            }
         }
      }

   }

   public void validerChronoOff() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.validerChronoOff(var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void validerChronoOff(Session var1) throws HibernateException, NamingException {
      if (this.usersChrono.getUsrchrNature() != 0) {
         if (this.usersChrono.getUsrchrId() == 0L) {
            this.usersChrono.setUsers(this.newUser);
            this.usersChrono.setUsrchrDateCreat(new Date());
            this.usersChrono.setUsrchrUserCreat(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.insert(this.usersChrono, var1);
            this.usersChronoListOff.add(this.usersChrono);
            this.datamodelUsersChronoOff.setWrappedData(this.usersChronoListOff);
         } else {
            this.usersChrono.setUsrchrDateModif(new Date());
            this.usersChrono.setUsrchrUserModif(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.modifier(this.usersChrono, var1);
         }

         this.showModalPanelOffice = false;
      }

   }

   public void annuleOffice() {
      this.showModalPanelOffice = false;
   }

   public void ajoutAutoChronoOff() throws HibernateException, NamingException {
      if (this.mesChronoOfficeItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoOfficeItems.size(); ++var3) {
               this.inputChronoOff = ((SelectItem)this.mesChronoOfficeItems.get(var3)).getValue().toString();
               this.usersChrono = new UsersChrono();
               this.verifChronoOff(var1);
               if (this.var_aff_val_chronoOff) {
                  this.usersChrono.setUsrchrUpdate(0);
                  this.usersChrono.setUsrchrValidation(2);
                  this.usersChrono.setUsrchrDeValidation(1);
                  this.usersChrono.setUsrchrDupplication(1);
                  this.validerChronoOff(var1);
               }
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void chargerMessageriesUsers(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.listbal.clear();
      this.listbal = this.balDao.selectBalUserLog(this.newUser.getUsrid(), var1);
      this.datamodelBal.setWrappedData(this.listbal);
      this.lienPanel = "";
   }

   public void ajouterBal() throws IOException, JDOMException {
      this.ball = new Bal();
      this.var_memo_pw = "";
      this.boutonBalgrpSup = false;
      this.verifExistMail = false;
      this.lienPanel = "ajouter";
      this.showModalPanelBal = true;
   }

   public void selectionBal() throws IOException, JDOMException {
      if (this.datamodelBal.isRowAvailable()) {
         this.ball = (Bal)this.datamodelBal.getRowData();
         this.var_memo_pw = this.ball.getBalpw();
         this.lienPanel = "ajouter";
         this.boutonBalgrpSup = true;
      }

   }

   public void supprimerBal() throws HibernateException, NamingException {
      if (this.ball != null) {
         this.balDao.delete(this.ball);
         this.listbal.remove(this.ball);
         this.datamodelBal.setWrappedData(this.listbal);
      }

   }

   public void validerCompteMess() throws HibernateException, NamingException {
      if (this.ball.getBalpw() == null || this.ball.getBalpw().isEmpty()) {
         this.ball.setBalpw(this.var_memo_pw);
      }

      if (this.ball.getBalid() == 0L) {
         if (!this.ball.getBalnomcompte().isEmpty() && !this.ball.getBaladressemail().isEmpty()) {
            this.ball.setBaldatecreat(new Date());
            this.ball.setBalusercreat(this.usersLog.getUsrid());
            this.ball.setBalStructure(0L);
            this.ball.setBalGroupe("");
            this.ball.setBalUser(this.newUser.getUsrid());
            this.ball = this.balDao.insert(this.ball);
            this.listbal.add(this.ball);
            this.datamodelBal.setWrappedData(this.listbal);
            this.ball = new Bal();
         } else {
            this.setBalmsg("Renseigner correctement les champs");
         }
      } else {
         this.ball.setBaldatemodif(new Date());
         this.ball.setBalusermodif(this.usersLog.getUsrid());
         this.ball = this.balDao.modif(this.ball);
      }

      this.lienPanel = "";
      this.boutonBalgrpSup = false;
      this.showModalPanelBal = false;
   }

   public void verifExistMail() throws HibernateException, NamingException {
      if (this.ball.getBaladressemail().contains("@")) {
         Bal var1 = this.balDao.logMailExiste(this.ball.getBaladressemail(), (Session)null);
         if (var1 != null) {
            this.verifExistMail = true;
         } else {
            this.verifExistMail = false;
         }
      } else {
         this.verifExistMail = false;
      }

   }

   public void annulerBal() {
      this.showModalPanelBal = false;
   }

   public void chargerlesUsersChronosAch(Session var1) throws HibernateException, NamingException {
      this.usersChronoListAch.clear();
      this.usersChronoListAch = this.usersChronoDao.selectListAchatByUser(this.newUser, var1);
      this.datamodelUsersChronoAch.setWrappedData(this.usersChronoListAch);
      this.testSelectSerieAch = false;
      this.visibiliteBtonAch = true;
   }

   public void selectionLesUsersAchats() {
      if (this.datamodelUsersChronoAch.isRowAvailable()) {
         this.usersChrono = (UsersChrono)this.datamodelUsersChronoAch.getRowData();
         String var1 = "";

         for(int var2 = 0; var2 < this.mesChronoAchatsItems.size(); ++var2) {
            if (((SelectItem)this.mesChronoAchatsItems.get(var2)).getValue().toString().startsWith("" + this.usersChrono.getUsrchrNature() + ":")) {
               String[] var3 = ((SelectItem)this.mesChronoAchatsItems.get(var2)).getValue().toString().split(":");
               var1 = var3[1];
               break;
            }
         }

         this.inputChronoAch = this.usersChrono.getUsrchrNature() + ":" + var1;
         this.visibiliteBtonAch = true;
      }

   }

   public void ajoutChronoAch() {
      this.usersChrono = new UsersChrono();
      this.inputChronoAch = "";
      this.var_aff_val_chronoAch = false;
      this.showModalPanelAchat = true;
   }

   public void modifChronoAch() {
      if (this.usersChrono != null) {
         this.var_aff_val_chronoAch = true;
         this.showModalPanelAchat = true;
      }

   }

   public void supprimerChronoAch() throws HibernateException, NamingException {
      if (this.usersChrono != null) {
         this.usersChronoDao.delete(this.usersChrono.getUsrchrId());
         this.chargerlesUsersChronosAch((Session)null);
      }

   }

   public void affichageOption() {
      if (this.usersChrono.getUsrchrUpdate() == 1) {
         this.usersChrono.setUsrchrValidation(0);
         this.usersChrono.setUsrchrDeValidation(0);
         this.usersChrono.setUsrchrDupplication(0);
      }

   }

   public void verifChronoAch() throws HibernateException, NamingException {
      this.verifChronoAch((Session)null);
   }

   public void verifChronoAch(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (this.inputChronoAch != null && this.inputChronoAch.contains(":")) {
         String[] var3 = this.inputChronoAch.split(":");
         int var4 = Integer.parseInt(var3[0]);
         String var5 = var3[1];
         new Chrono();
         if (this.usersChronoListAch.size() != 0) {
            for(int var7 = 0; var7 < this.usersChronoListAch.size(); ++var7) {
               if (var5.equalsIgnoreCase(((UsersChrono)this.usersChronoListAch.get(var7)).getUsrchrSerie()) && var4 == ((UsersChrono)this.usersChronoListAch.get(var7)).getUsrchrNature()) {
                  var2 = true;
                  break;
               }
            }
         }

         if (var2) {
            this.var_aff_val_chronoAch = false;
         } else {
            this.var_aff_val_chronoAch = true;
            Chrono var6 = this.chronoDao.chronoBySerieNat(var5, var4, var1);
            if (var6 != null) {
               this.usersChrono.setUsrchrNature(var6.getChrNature());
               this.usersChrono.setUsrchrPrive(var6.getChrPrive());
               this.usersChrono.setUsrchrSerie(var6.getChrSerie());
               this.usersChrono.setUsrchrLib(var6.getLibnature() + " " + var6.getChrNom());
            } else {
               this.usersChrono.setUsrchrNature(0);
               this.usersChrono.setUsrchrPrive(0);
               this.usersChrono.setUsrchrSerie("");
               this.usersChrono.setUsrchrLib("");
            }
         }
      }

   }

   public void validerChronoAch() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.validerChronoAch(var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void validerChronoAch(Session var1) throws HibernateException, NamingException {
      if (this.usersChrono.getUsrchrNature() != 0) {
         if (this.usersChrono.getUsrchrId() == 0L) {
            this.usersChrono.setUsers(this.newUser);
            this.usersChrono.setUsrchrDateCreat(new Date());
            this.usersChrono.setUsrchrUserCreat(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.insert(this.usersChrono, var1);
            this.usersChronoListAch.add(this.usersChrono);
            this.datamodelUsersChronoAch.setWrappedData(this.usersChronoListAch);
         } else {
            this.usersChrono.setUsrchrDateModif(new Date());
            this.usersChrono.setUsrchrUserModif(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.modifier(this.usersChrono, var1);
         }

         this.showModalPanelAchat = false;
      }

   }

   public void annuleAchat() {
      this.showModalPanelAchat = false;
   }

   public void ajoutAutoChronoAch() throws HibernateException, NamingException {
      if (this.mesChronoAchatsItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoAchatsItems.size(); ++var3) {
               this.inputChronoAch = ((SelectItem)this.mesChronoAchatsItems.get(var3)).getValue().toString();
               this.usersChrono = new UsersChrono();
               this.verifChronoAch(var1);
               if (this.var_aff_val_chronoAch) {
                  this.usersChrono.setUsrchrUpdate(0);
                  this.usersChrono.setUsrchrValidation(2);
                  this.usersChrono.setUsrchrDeValidation(1);
                  this.usersChrono.setUsrchrDupplication(1);
                  this.validerChronoAch(var1);
               }
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void chargerlesUsersChronosVte(Session var1) throws HibernateException, NamingException {
      this.usersChronoListVte.clear();
      this.usersChronoListVte = this.usersChronoDao.selectListVenteByUser(this.newUser, var1);
      this.datamodelUsersChronoVte.setWrappedData(this.usersChronoListVte);
      this.testSelectSerieVte = false;
      this.visibiliteBtonVte = true;
   }

   public void selectionLesUsersVentes() {
      if (this.datamodelUsersChronoVte.isRowAvailable()) {
         this.usersChrono = (UsersChrono)this.datamodelUsersChronoVte.getRowData();
         String var1 = "";

         for(int var2 = 0; var2 < this.mesChronoVentesItems.size(); ++var2) {
            if (((SelectItem)this.mesChronoVentesItems.get(var2)).getValue().toString().startsWith("" + this.usersChrono.getUsrchrNature() + ":")) {
               String[] var3 = ((SelectItem)this.mesChronoVentesItems.get(var2)).getValue().toString().split(":");
               var1 = var3[1];
               break;
            }
         }

         this.inputChronoVte = this.usersChrono.getUsrchrNature() + ":" + var1;
         this.visibiliteBtonVte = true;
      }

   }

   public void ajoutChronoVte() {
      this.usersChrono = new UsersChrono();
      this.inputChronoVte = "";
      this.var_aff_val_chronoVte = false;
      this.showModalPanelVente = true;
   }

   public void modifChronoVte() {
      if (this.usersChrono != null) {
         this.var_aff_val_chronoVte = true;
         this.showModalPanelVente = true;
      }

   }

   public void supprimerChronoVte() throws HibernateException, NamingException {
      if (this.usersChrono != null) {
         this.usersChronoDao.delete(this.usersChrono.getUsrchrId());
         this.chargerlesUsersChronosVte((Session)null);
      }

   }

   public void verifChronoVte() throws HibernateException, NamingException {
      this.verifChronoVte((Session)null);
   }

   public void verifChronoVte(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (this.inputChronoVte != null && this.inputChronoVte.contains(":")) {
         String[] var3 = this.inputChronoVte.split(":");
         int var4 = Integer.parseInt(var3[0]);
         String var5 = var3[1];
         new Chrono();
         if (this.usersChronoListVte.size() != 0) {
            for(int var7 = 0; var7 < this.usersChronoListVte.size(); ++var7) {
               if (var5.equalsIgnoreCase(((UsersChrono)this.usersChronoListVte.get(var7)).getUsrchrSerie()) && var4 == ((UsersChrono)this.usersChronoListVte.get(var7)).getUsrchrNature()) {
                  var2 = true;
                  break;
               }
            }
         }

         if (var2) {
            this.var_aff_val_chronoVte = false;
         } else {
            this.var_aff_val_chronoVte = true;
            Chrono var6 = this.chronoDao.chronoBySerieNat(var5, var4, var1);
            if (var6 != null) {
               this.usersChrono.setUsrchrNature(var6.getChrNature());
               this.usersChrono.setUsrchrPrive(var6.getChrPrive());
               this.usersChrono.setUsrchrSerie(var6.getChrSerie());
               this.usersChrono.setUsrchrLib(var6.getLibnature() + " " + var6.getChrNom());
            } else {
               this.usersChrono.setUsrchrNature(0);
               this.usersChrono.setUsrchrPrive(0);
               this.usersChrono.setUsrchrSerie("");
               this.usersChrono.setUsrchrLib("");
            }
         }
      }

   }

   public void validerChronoVte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.validerChronoVte(var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void validerChronoVte(Session var1) throws HibernateException, NamingException {
      if (this.usersChrono.getUsrchrNature() != 0) {
         if (this.usersChrono.getUsrchrId() == 0L) {
            this.usersChrono.setUsers(this.newUser);
            this.usersChrono.setUsrchrDateCreat(new Date());
            this.usersChrono.setUsrchrUserCreat(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.insert(this.usersChrono, var1);
            this.usersChronoListVte.add(this.usersChrono);
            this.datamodelUsersChronoVte.setWrappedData(this.usersChronoListVte);
         } else {
            this.usersChrono.setUsrchrDateModif(new Date());
            this.usersChrono.setUsrchrUserModif(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.modifier(this.usersChrono, var1);
         }

         this.showModalPanelVente = false;
      }

   }

   public void annuleVente() {
      this.showModalPanelVente = false;
   }

   public void ajoutAutoChronoVte() throws HibernateException, NamingException {
      if (this.mesChronoVentesItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoVentesItems.size(); ++var3) {
               this.inputChronoVte = ((SelectItem)this.mesChronoVentesItems.get(var3)).getValue().toString();
               this.usersChrono = new UsersChrono();
               this.verifChronoVte(var1);
               if (this.var_aff_val_chronoVte) {
                  this.usersChrono.setUsrchrUpdate(0);
                  this.usersChrono.setUsrchrValidation(2);
                  this.usersChrono.setUsrchrDeValidation(1);
                  this.usersChrono.setUsrchrDupplication(1);
                  this.validerChronoVte(var1);
               }
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void chargerlesUsersChronosCaisse(Session var1) throws HibernateException, NamingException {
      this.usersChronoListCaiss.clear();
      this.usersChronoListCaiss = this.usersChronoDao.selectListCaisseByUser(this.newUser, var1);
      this.datamodelUsersChronoCaiss.setWrappedData(this.usersChronoListCaiss);
      this.testSelectSerieCaiss = false;
      this.visibiliteBtonCaiss = true;
   }

   public void selectionLesUsersCaisses() {
      if (this.datamodelUsersChronoCaiss.isRowAvailable()) {
         this.usersChrono = (UsersChrono)this.datamodelUsersChronoCaiss.getRowData();
         String var1 = "";

         for(int var2 = 0; var2 < this.mesChronoCaisseItems.size(); ++var2) {
            if (((SelectItem)this.mesChronoCaisseItems.get(var2)).getValue().toString() != null && !((SelectItem)this.mesChronoCaisseItems.get(var2)).getValue().toString().isEmpty() && ((SelectItem)this.mesChronoCaisseItems.get(var2)).getValue().toString().startsWith("" + this.usersChrono.getUsrchrNature() + ":")) {
               String[] var3 = ((SelectItem)this.mesChronoCaisseItems.get(var2)).getValue().toString().split(":");
               var1 = var3[1];
               break;
            }
         }

         this.inputChronoCaisse = this.usersChrono.getUsrchrNature() + ":" + var1;
         this.visibiliteBtonCaiss = true;
         this.chargerlesUsersOperationsCaisse();
      }

   }

   public void chargerlesUsersOperationsCaisse() {
      this.userOperationsCaisses.clear();
      if (this.mesOperationsCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.mesOperationsCaisses.size(); ++var1) {
            this.caissesOperations = new CaissesOperations();
            this.caissesOperations = (CaissesOperations)this.mesOperationsCaisses.get(var1);
            this.caissesOperations.setSelect(true);
            this.caissesOperations.setPlafond(0.0D);
            this.userOperationsCaisses.add(this.caissesOperations);
         }

         if (this.usersChrono != null && this.usersChrono.getUsrchrMode() != null && !this.usersChrono.getUsrchrMode().isEmpty()) {
            String var9 = "";
            double var2 = 0.0D;
            if (!this.usersChrono.getUsrchrMode().contains(":")) {
               var9 = this.usersChrono.getUsrchrMode();
               var2 = Double.parseDouble(this.usersChrono.getUsrchrPlafond());
               this.caissesOperations = new CaissesOperations();

               for(int var4 = 0; var4 < this.userOperationsCaisses.size(); ++var4) {
                  this.caissesOperations = (CaissesOperations)this.userOperationsCaisses.get(var4);
                  if (this.caissesOperations.getCaiopeCode().equals(var9)) {
                     this.caissesOperations.setSelect(true);
                     this.caissesOperations.setPlafond(var2);
                  }
               }
            } else {
               String[] var10 = this.usersChrono.getUsrchrMode().split(":");
               String[] var5 = this.usersChrono.getUsrchrPlafond().split(":");
               int var6 = 0;
               if (var10.length == var5.length) {
                  var6 = var10.length;
               } else if (var10.length > var5.length) {
                  var6 = var5.length;
               } else if (var10.length < var5.length) {
                  var6 = var10.length;
               }

               for(int var7 = 0; var7 < var6; ++var7) {
                  var9 = var10[var7];
                  var2 = Double.parseDouble(var5[var7]);
                  this.caissesOperations = new CaissesOperations();

                  for(int var8 = 0; var8 < this.userOperationsCaisses.size(); ++var8) {
                     this.caissesOperations = (CaissesOperations)this.userOperationsCaisses.get(var8);
                     if (this.caissesOperations.getCaiopeCode() != null && !this.caissesOperations.getCaiopeCode().isEmpty() && this.caissesOperations.getCaiopeCode().equals(var9)) {
                        this.caissesOperations.setSelect(true);
                        this.caissesOperations.setPlafond(var2);
                     }
                  }
               }
            }
         }
      }

      this.dataModelOperation.setWrappedData(this.userOperationsCaisses);
   }

   public void ajoutChronoCaisse() {
      this.usersChrono = new UsersChrono();
      this.inputChronoCaisse = "";
      this.var_aff_val_chronoCaisse = false;
      this.showModalPanelCaisse = true;
   }

   public void modifChronoCaisse() {
      if (this.usersChrono != null) {
         this.calculeImpCaisse();
         this.var_aff_val_chronoCaisse = true;
         this.showModalPanelCaisse = true;
      }

   }

   public void calculeImpCaisse() {
      String var1 = "";
      if (this.usersChrono.getUsrchrNature() == 60) {
         var1 = "Caisse";
      } else if (this.usersChrono.getUsrchrNature() == 61) {
         var1 = "Reçu";
      } else if (this.usersChrono.getUsrchrNature() == 62) {
         var1 = "Bon de sortie";
      } else if (this.usersChrono.getUsrchrNature() == 63) {
         var1 = "Bon d'entrée";
      } else if (this.usersChrono.getUsrchrNature() == 64) {
         var1 = "Virement interne";
      } else if (this.usersChrono.getUsrchrNature() == 65) {
         var1 = "Traite domiciliée";
      } else if (this.usersChrono.getUsrchrNature() == 66) {
         var1 = "Traite en portefeuille";
      } else if (this.usersChrono.getUsrchrNature() == 67) {
         var1 = "Traite entreprise";
      } else if (this.usersChrono.getUsrchrNature() == 68) {
         var1 = "Inventaire caisse";
      } else if (this.usersChrono.getUsrchrNature() == 69) {
         var1 = "Prévisionnel";
      }

      if (this.usersChrono.getUsrchrNature() != 60 && this.usersChrono.getUsrchrNature() != 61) {
         this.inputChronoCaisse = this.usersChrono.getUsrchrNature() + ":" + this.usersChrono.getUsrchrSerie() + ":" + var1 + ":" + this.usersChrono.getUsrchrLib();
      } else {
         this.inputChronoCaisse = this.usersChrono.getUsrchrNature() + ":" + this.usersChrono.getUsrchrSerie() + ":" + var1 + ":" + this.usersChrono.getUsrchrLib() + " (" + this.usersChrono.getUsrchrCodeCaisse() + ")";
      }

   }

   public void supprimerChronoCaisse() throws HibernateException, NamingException {
      if (this.usersChrono != null) {
         this.usersChronoDao.delete(this.usersChrono.getUsrchrId());
         this.chargerlesUsersChronosCaisse((Session)null);
      }

   }

   public void verifChronoCaisse() throws HibernateException, NamingException {
      this.verifChronoCaisse((Session)null);
   }

   public void verifChronoCaisse(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      String var3 = "";
      if (this.inputChronoCaisse != null && this.inputChronoCaisse.contains(":")) {
         String[] var4 = this.inputChronoCaisse.split(":");
         int var5 = Integer.parseInt(var4[0]);
         String var6 = var4[1];
         new Chrono();
         if ((var5 == 60 || var5 == 61) && this.inputChronoCaisse.contains("(")) {
            String var11 = this.inputChronoCaisse.replace("(", ":");
            String[] var9 = var11.split(":");
            if (var9.length == 5) {
               var3 = var9[4].replace(")", "");
            } else if (var9.length == 6) {
               var3 = var9[5].replace(")", "");
            } else {
               var3 = "";
            }

            if (this.usersChronoListCaiss.size() != 0 && var3 != null && !var3.isEmpty()) {
               for(int var10 = 0; var10 < this.usersChronoListCaiss.size(); ++var10) {
                  if (var6.equalsIgnoreCase(((UsersChrono)this.usersChronoListCaiss.get(var10)).getUsrchrSerie()) && var5 == ((UsersChrono)this.usersChronoListCaiss.get(var10)).getUsrchrNature() && ((UsersChrono)this.usersChronoListCaiss.get(var10)).getUsrchrCodeCaisse() != null && !((UsersChrono)this.usersChronoListCaiss.get(var10)).getUsrchrCodeCaisse().isEmpty() && ((UsersChrono)this.usersChronoListCaiss.get(var10)).getUsrchrCodeCaisse().equals(var3)) {
                     var2 = true;
                     break;
                  }
               }
            }

            this.chargerlesUsersOperationsCaisse();
         } else if (this.usersChronoListCaiss.size() != 0) {
            for(int var8 = 0; var8 < this.usersChronoListCaiss.size(); ++var8) {
               if (var6.equalsIgnoreCase(((UsersChrono)this.usersChronoListCaiss.get(var8)).getUsrchrSerie()) && var5 == ((UsersChrono)this.usersChronoListCaiss.get(var8)).getUsrchrNature()) {
                  var2 = true;
                  break;
               }
            }
         }

         if (var2) {
            this.var_aff_val_chronoCaisse = false;
         } else {
            this.var_aff_val_chronoCaisse = true;
            Chrono var7;
            if ((var5 == 60 || var5 == 61) && var3 != null && !var3.isEmpty()) {
               var7 = this.chronoDao.chronoBySerieNat(var6, var3, var5, var1);
            } else {
               var7 = this.chronoDao.chronoBySerieNat(var6, var5, var1);
            }

            if (var7 != null) {
               this.usersChrono.setUsrchrNature(var7.getChrNature());
               this.usersChrono.setUsrchrPrive(var7.getChrPrive());
               this.usersChrono.setUsrchrSerie(var7.getChrSerie());
               this.usersChrono.setUsrchrLib(var7.getChrNom());
               this.usersChrono.setUsrchrCodeCaisse(var7.getChrCodeCaisse());
               this.usersChrono.setUsrchrModeCaisse(var7.getChrModeCaisse());
            } else {
               this.usersChrono.setUsrchrNature(0);
               this.usersChrono.setUsrchrPrive(0);
               this.usersChrono.setUsrchrSerie("");
               this.usersChrono.setUsrchrLib("");
               this.usersChrono.setUsrchrCodeCaisse("");
               this.usersChrono.setUsrchrJournal(0);
               this.usersChrono.setUsrchrExecution(0);
               this.usersChrono.setUsrchrModeCaisse(0);
            }
         }
      }

   }

   public void validerChronoCaisse() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.validerChronoCaisse(var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void validerChronoCaisse(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      String var3 = "";
      if (this.userOperationsCaisses.size() != 0) {
         boolean var4 = true;

         for(int var5 = 0; var5 < this.userOperationsCaisses.size(); ++var5) {
            new CaissesOperations();
            CaissesOperations var6 = (CaissesOperations)this.userOperationsCaisses.get(var5);
            if (var6.isSelect()) {
               if (var4) {
                  var4 = false;
                  var2 = var6.getCaiopeCode();
                  var3 = "" + var6.getPlafond();
               } else {
                  var2 = var2 + ":" + var6.getCaiopeCode();
                  var3 = var3 + ":" + var6.getPlafond();
               }
            }
         }
      }

      this.usersChrono.setUsrchrMode(var2);
      this.usersChrono.setUsrchrPlafond(var3);
      if (this.usersChrono.getUsrchrNature() != 0) {
         if (this.usersChrono.getUsrchrId() == 0L) {
            this.usersChrono.setUsers(this.newUser);
            this.usersChrono.setUsrchrDateCreat(new Date());
            this.usersChrono.setUsrchrUserCreat(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.insert(this.usersChrono, var1);
            this.usersChronoListCaiss.add(this.usersChrono);
            this.datamodelUsersChronoCaiss.setWrappedData(this.usersChronoListCaiss);
         } else {
            this.usersChrono.setUsrchrDateModif(new Date());
            this.usersChrono.setUsrchrUserModif(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.modifier(this.usersChrono, var1);
         }

         this.showModalPanelCaisse = false;
      }

   }

   public void annuleCaisse() {
      this.showModalPanelCaisse = false;
   }

   public void allSelect() throws HibernateException, NamingException {
      if (this.usersChrono != null && this.userOperationsCaisses.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = "";
            String var4 = "";
            if (this.userOperationsCaisses.size() != 0) {
               boolean var5 = true;

               for(int var6 = 0; var6 < this.userOperationsCaisses.size(); ++var6) {
                  new CaissesOperations();
                  CaissesOperations var7 = (CaissesOperations)this.userOperationsCaisses.get(var6);
                  if (!var7.isSelect()) {
                     var7.setSelect(true);
                     if (var5) {
                        var5 = false;
                        var3 = var7.getCaiopeCode();
                        var4 = "" + var7.getPlafond();
                     } else {
                        var3 = var3 + ":" + var7.getCaiopeCode();
                        var4 = var4 + ":" + var7.getPlafond();
                     }
                  } else {
                     var7.setSelect(false);
                  }
               }
            }

            this.usersChrono.setUsrchrMode(var3);
            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void ajoutAutoChronoCaisse() throws HibernateException, NamingException {
      if (this.mesChronoCaisseItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoCaisseItems.size(); ++var3) {
               this.inputChronoCaisse = ((SelectItem)this.mesChronoCaisseItems.get(var3)).getValue().toString();
               if (this.inputChronoCaisse != null && !this.inputChronoCaisse.isEmpty() && this.inputChronoCaisse.contains(":")) {
                  String[] var4 = this.inputChronoCaisse.split(":");
                  int var5 = Integer.parseInt(var4[0]);
                  String var6 = "";
                  if (var5 == 60) {
                     var6 = "Caisse";
                  } else if (var5 == 61) {
                     var6 = "Reçu";
                  } else if (var5 == 62) {
                     var6 = "Bon de sortie";
                  } else if (var5 == 63) {
                     var6 = "Bon d'entrée";
                  } else if (var5 == 64) {
                     var6 = "Virement interne";
                  } else if (var5 == 65) {
                     var6 = "Traite domiciliée";
                  } else if (var5 == 66) {
                     var6 = "Traite en portefeuille";
                  } else if (var5 == 67) {
                     var6 = "Traite entreprise";
                  } else if (var5 == 68) {
                     var6 = "Inventaire caisse";
                  } else if (var5 == 69) {
                     var6 = "Prévisionnel";
                  }

                  this.usersChrono = new UsersChrono();
                  this.var_aff_val_chronoCaisse = false;
                  this.verifChronoCaisse(var1);
                  if (this.var_aff_val_chronoCaisse) {
                     this.usersChrono.setUsrchrUpdate(0);
                     this.usersChrono.setUsrchrValidation(2);
                     this.usersChrono.setUsrchrDeValidation(1);
                     this.usersChrono.setUsrchrDupplication(1);
                     this.usersChrono.setUsrchrExecution(0);
                     this.usersChrono.setUsrchrJournal(0);
                     this.validerChronoCaisse(var1);
                  }
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

   }

   public void chargerlesUsersChronosPaye(Session var1) throws HibernateException, NamingException {
      this.usersChronoListPaye.clear();
      this.usersChronoListPaye = this.usersChronoDao.selectListPayeByUser(this.newUser, var1);
      this.datamodelUsersChronoPaye.setWrappedData(this.usersChronoListPaye);
      this.testSelectSeriePaye = false;
      this.visibiliteBtonPaye = true;
   }

   public void selectionLesUsersPaye() {
      if (this.datamodelUsersChronoPaye.isRowAvailable()) {
         this.usersChrono = (UsersChrono)this.datamodelUsersChronoPaye.getRowData();
         String var1 = "";

         for(int var2 = 0; var2 < this.mesChronoPayeItems.size(); ++var2) {
            if (((SelectItem)this.mesChronoPayeItems.get(var2)).getValue().toString().startsWith("" + this.usersChrono.getUsrchrNature() + ":")) {
               String[] var3 = ((SelectItem)this.mesChronoPayeItems.get(var2)).getValue().toString().split(":");
               var1 = var3[1];
               break;
            }
         }

         this.inputChronoPaye = this.usersChrono.getUsrchrNature() + ":" + var1;
         this.visibiliteBtonPaye = true;
      }

   }

   public void ajoutChronoPaye() {
      this.usersChrono = new UsersChrono();
      this.inputChronoPaye = "";
      this.var_aff_val_chronoPaye = false;
      this.showModalPanelPaye = true;
   }

   public void modifChronoPaye() {
      if (this.usersChrono != null) {
         this.var_aff_val_chronoPaye = true;
         this.showModalPanelPaye = true;
      }

   }

   public void supprimerChronoPaye() throws HibernateException, NamingException {
      if (this.usersChrono != null) {
         this.usersChronoDao.delete(this.usersChrono.getUsrchrId());
         this.chargerlesUsersChronosPaye((Session)null);
      }

   }

   public void verifChronoPaye() throws HibernateException, NamingException {
      this.verifChronoPaye((Session)null);
   }

   public void verifChronoPaye(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (this.inputChronoPaye != null && this.inputChronoPaye.contains(":")) {
         String[] var3 = this.inputChronoPaye.split(":");
         boolean var4 = false;
         String var5 = "";
         String var6 = "";
         int var9;
         if (var3[0].equals("81")) {
            var9 = Integer.parseInt(var3[0]);
            var5 = var3[1] + ":" + var3[2];
            var6 = var3[3];
         } else {
            var9 = Integer.parseInt(var3[0]);
            var5 = "";
            var6 = var3[0];
         }

         new Chrono();
         if (this.usersChronoListPaye.size() != 0) {
            for(int var8 = 0; var8 < this.usersChronoListPaye.size(); ++var8) {
               if (var5.equalsIgnoreCase(((UsersChrono)this.usersChronoListPaye.get(var8)).getUsrchrSerie()) && var9 == ((UsersChrono)this.usersChronoListPaye.get(var8)).getUsrchrNature()) {
                  var2 = true;
                  break;
               }
            }
         }

         if (var2) {
            this.var_aff_val_chronoPaye = false;
         } else {
            this.var_aff_val_chronoPaye = true;
            Chrono var7 = this.chronoDao.chronoBySerieNat(var5, var9, var1);
            if (var7 != null) {
               this.usersChrono.setUsrchrNature(var9);
               this.usersChrono.setUsrchrSerie(var5);
               this.usersChrono.setUsrchrLib(var7.getLibnature());
               this.usersChrono.setUsrchrUpdate(0);
               this.usersChrono.setUsrchrValidation(2);
               this.usersChrono.setUsrchrDeValidation(1);
               this.usersChrono.setUsrchrDupplication(1);
            } else {
               this.usersChrono.setUsrchrNature(0);
               this.usersChrono.setUsrchrSerie("");
               this.usersChrono.setUsrchrLib("");
            }
         }
      }

   }

   public void validerChronoPaye() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.validerChronoPaye(var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void validerChronoPaye(Session var1) throws HibernateException, NamingException {
      if (this.usersChrono.getUsrchrNature() != 0) {
         if (this.usersChrono.getUsrchrId() == 0L) {
            this.usersChrono.setUsers(this.newUser);
            this.usersChrono.setUsrchrDateCreat(new Date());
            this.usersChrono.setUsrchrUserCreat(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.insert(this.usersChrono, var1);
            this.usersChronoListPaye.add(this.usersChrono);
            this.datamodelUsersChronoPaye.setWrappedData(this.usersChronoListPaye);
         } else {
            this.usersChrono.setUsrchrDateModif(new Date());
            this.usersChrono.setUsrchrUserModif(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.modifier(this.usersChrono, var1);
         }

         if (this.showModalPanelPaye) {
            this.showModalPanelPaye = false;
         }
      }

   }

   public void annulePaye() {
      this.showModalPanelPaye = false;
   }

   public void ajoutAutoChronoPaye() throws HibernateException, NamingException {
      if (this.mesChronoPayeItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoPayeItems.size(); ++var3) {
               this.inputChronoPaye = ((SelectItem)this.mesChronoPayeItems.get(var3)).getValue().toString();
               this.usersChrono = new UsersChrono();
               this.verifChronoPaye(var1);
               if (this.var_aff_val_chronoPaye) {
                  this.usersChrono.setUsrchrUpdate(0);
                  this.usersChrono.setUsrchrValidation(2);
                  this.usersChrono.setUsrchrDeValidation(1);
                  this.usersChrono.setUsrchrDupplication(1);
                  this.validerChronoPaye(var1);
               }
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void chargerlesUsersChronosMed(Session var1) throws HibernateException, NamingException {
      this.usersChronoListMed.clear();
      this.usersChronoListMed = this.usersChronoDao.selectListMedicalByUser(this.newUser, var1);
      this.datamodelUsersChronoMed.setWrappedData(this.usersChronoListMed);
      this.testSelectSerieMed = false;
      this.visibiliteBtonMed = true;
   }

   public void selectionLesUsersMedical() {
      if (this.datamodelUsersChronoMed.isRowAvailable()) {
         this.usersChrono = (UsersChrono)this.datamodelUsersChronoMed.getRowData();
         String var1 = "";

         for(int var2 = 0; var2 < this.mesChronoMedicalItems.size(); ++var2) {
            if (((SelectItem)this.mesChronoMedicalItems.get(var2)).getValue().toString().startsWith("" + this.usersChrono.getUsrchrNature() + ":")) {
               String[] var3 = ((SelectItem)this.mesChronoMedicalItems.get(var2)).getValue().toString().split(":");
               var1 = var3[1];
               break;
            }
         }

         this.inputChronoMed = this.usersChrono.getUsrchrNature() + ":" + var1;
         this.visibiliteBtonMed = true;
      }

   }

   public void ajoutChronoMed() {
      this.usersChrono = new UsersChrono();
      this.inputChronoMed = "";
      this.var_aff_val_chronoMed = false;
      this.showModalPanelMedical = true;
   }

   public void modifChronoMed() {
      if (this.usersChrono != null) {
         this.var_aff_val_chronoMed = true;
         this.showModalPanelMedical = true;
      }

   }

   public void supprimerChronoMed() throws HibernateException, NamingException {
      if (this.usersChrono != null) {
         this.usersChronoDao.delete(this.usersChrono.getUsrchrId());
         this.chargerlesUsersChronosMed((Session)null);
      }

   }

   public void verifChronoMed() throws HibernateException, NamingException {
      this.verifChronoMed((Session)null);
   }

   public void verifChronoMed(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (this.inputChronoMed != null && this.inputChronoMed.contains(":")) {
         String[] var3 = this.inputChronoMed.split(":");
         int var4 = Integer.parseInt(var3[0]);
         String var5 = var3[1];
         new Chrono();
         if (this.usersChronoListMed.size() != 0) {
            for(int var7 = 0; var7 < this.usersChronoListMed.size(); ++var7) {
               if (var5.equalsIgnoreCase(((UsersChrono)this.usersChronoListMed.get(var7)).getUsrchrSerie()) && var4 == ((UsersChrono)this.usersChronoListMed.get(var7)).getUsrchrNature()) {
                  var2 = true;
                  break;
               }
            }
         }

         if (var2) {
            this.var_aff_val_chronoMed = false;
         } else {
            this.var_aff_val_chronoMed = true;
            Chrono var6 = this.chronoDao.chronoBySerieNat(var5, var4, var1);
            if (var6 != null) {
               this.usersChrono.setUsrchrNature(var6.getChrNature());
               this.usersChrono.setUsrchrPrive(var6.getChrPrive());
               this.usersChrono.setUsrchrSerie(var6.getChrSerie());
               this.usersChrono.setUsrchrLib(var6.getLibnature() + " " + var6.getChrNom());
            } else {
               this.usersChrono.setUsrchrNature(0);
               this.usersChrono.setUsrchrPrive(0);
               this.usersChrono.setUsrchrSerie("");
               this.usersChrono.setUsrchrLib("");
            }
         }
      }

   }

   public void validerChronoMed() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.validerChronoMed(var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void validerChronoMed(Session var1) throws HibernateException, NamingException {
      if (this.usersChrono.getUsrchrNature() != 0) {
         if (this.usersChrono.getUsrchrId() == 0L) {
            this.usersChrono.setUsers(this.newUser);
            this.usersChrono.setUsrchrDateCreat(new Date());
            this.usersChrono.setUsrchrUserCreat(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.insert(this.usersChrono, var1);
            this.usersChronoListMed.add(this.usersChrono);
            this.datamodelUsersChronoMed.setWrappedData(this.usersChronoListMed);
         } else {
            this.usersChrono.setUsrchrDateModif(new Date());
            this.usersChrono.setUsrchrUserModif(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.modifier(this.usersChrono, var1);
         }

         this.showModalPanelMedical = false;
      }

   }

   public void annuleMedical() {
      this.showModalPanelMedical = false;
   }

   public void ajoutAutoChronoMed() throws HibernateException, NamingException {
      if (this.mesChronoMedicalItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoMedicalItems.size(); ++var3) {
               this.inputChronoMed = ((SelectItem)this.mesChronoMedicalItems.get(var3)).getValue().toString();
               this.usersChrono = new UsersChrono();
               this.verifChronoMed(var1);
               if (this.var_aff_val_chronoMed) {
                  this.usersChrono.setUsrchrUpdate(0);
                  this.usersChrono.setUsrchrValidation(2);
                  this.usersChrono.setUsrchrDeValidation(1);
                  this.usersChrono.setUsrchrDupplication(1);
                  this.validerChronoMed(var1);
               }
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void chargerlesUsersChronosPar(Session var1) throws HibernateException, NamingException {
      this.usersChronoListPar.clear();
      this.usersChronoListPar = this.usersChronoDao.selectListParcByUser(this.newUser, var1);
      this.datamodelUsersChronoPar.setWrappedData(this.usersChronoListPar);
      this.testSelectSeriePar = false;
      this.visibiliteBtonPar = true;
   }

   public void selectionLesUsersParc() {
      if (this.datamodelUsersChronoPar.isRowAvailable()) {
         this.usersChrono = (UsersChrono)this.datamodelUsersChronoPar.getRowData();
         String var1 = "";

         for(int var2 = 0; var2 < this.mesChronoParcItems.size(); ++var2) {
            if (((SelectItem)this.mesChronoParcItems.get(var2)).getValue().toString().startsWith("" + this.usersChrono.getUsrchrNature() + ":")) {
               String[] var3 = ((SelectItem)this.mesChronoParcItems.get(var2)).getValue().toString().split(":");
               var1 = var3[1];
               break;
            }
         }

         this.inputChronoPar = this.usersChrono.getUsrchrNature() + ":" + var1;
         this.visibiliteBtonPar = true;
      }

   }

   public void ajoutChronoPar() {
      this.usersChrono = new UsersChrono();
      this.inputChronoPar = "";
      this.var_aff_val_chronoPar = false;
      this.showModalPanelParc = true;
   }

   public void modifChronoPar() {
      if (this.usersChrono != null) {
         this.var_aff_val_chronoPar = true;
         this.showModalPanelParc = true;
      }

   }

   public void supprimerChronoPar() throws HibernateException, NamingException {
      if (this.usersChrono != null) {
         this.usersChronoDao.delete(this.usersChrono.getUsrchrId());
         this.chargerlesUsersChronosPar((Session)null);
      }

   }

   public void verifChronoPar() throws HibernateException, NamingException {
      this.verifChronoPar((Session)null);
   }

   public void verifChronoPar(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (this.inputChronoPar != null && this.inputChronoPar.contains(":")) {
         String[] var3 = this.inputChronoPar.split(":");
         int var4 = Integer.parseInt(var3[0]);
         String var5 = var3[1];
         new Chrono();
         if (this.usersChronoListPar.size() != 0) {
            for(int var7 = 0; var7 < this.usersChronoListPar.size(); ++var7) {
               if (var5.equalsIgnoreCase(((UsersChrono)this.usersChronoListPar.get(var7)).getUsrchrSerie()) && var4 == ((UsersChrono)this.usersChronoListPar.get(var7)).getUsrchrNature()) {
                  var2 = true;
                  break;
               }
            }
         }

         if (var2) {
            this.var_aff_val_chronoPar = false;
         } else {
            this.var_aff_val_chronoPar = true;
            Chrono var6 = this.chronoDao.chronoBySerieNat(var5, var4, var1);
            if (var6 != null) {
               this.usersChrono.setUsrchrNature(var6.getChrNature());
               this.usersChrono.setUsrchrPrive(var6.getChrPrive());
               this.usersChrono.setUsrchrSerie(var6.getChrSerie());
               this.usersChrono.setUsrchrLib(var6.getLibnature() + " " + var6.getChrNom());
            } else {
               this.usersChrono.setUsrchrNature(0);
               this.usersChrono.setUsrchrPrive(0);
               this.usersChrono.setUsrchrSerie("");
               this.usersChrono.setUsrchrLib("");
            }
         }
      }

   }

   public void validerChronoPar() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.validerChronoPar(var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void validerChronoPar(Session var1) throws HibernateException, NamingException {
      if (this.usersChrono.getUsrchrNature() != 0) {
         if (this.usersChrono.getUsrchrId() == 0L) {
            this.usersChrono.setUsers(this.newUser);
            this.usersChrono.setUsrchrDateCreat(new Date());
            this.usersChrono.setUsrchrUserCreat(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.insert(this.usersChrono, var1);
            this.usersChronoListPar.add(this.usersChrono);
            this.datamodelUsersChronoPar.setWrappedData(this.usersChronoListPar);
         } else {
            this.usersChrono.setUsrchrDateModif(new Date());
            this.usersChrono.setUsrchrUserModif(this.usersLog.getUsrid());
            this.usersChrono = this.usersChronoDao.modifier(this.usersChrono, var1);
         }

         this.showModalPanelParc = false;
      }

   }

   public void annuleParc() {
      this.showModalPanelParc = false;
   }

   public void ajoutAutoChronoPar() throws HibernateException, NamingException {
      if (this.mesChronoParcItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoParcItems.size(); ++var3) {
               this.inputChronoPar = ((SelectItem)this.mesChronoParcItems.get(var3)).getValue().toString();
               this.usersChrono = new UsersChrono();
               this.verifChronoPar(var1);
               if (this.var_aff_val_chronoPar) {
                  this.usersChrono.setUsrchrUpdate(0);
                  this.usersChrono.setUsrchrValidation(2);
                  this.usersChrono.setUsrchrDeValidation(1);
                  this.usersChrono.setUsrchrDupplication(1);
                  this.validerChronoPar(var1);
               }
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void chargerLesAppreciations() throws IOException {
      this.lesAppreciations = new LectureAppreciations();
      this.mesAppreciationsItems = this.lesAppreciations.getMesAppreciationItems();
   }

   public void chargerLesCivilites() throws IOException {
      this.lesCivilites = new LectureCivilites(0);
      this.mesCiviliteItems = this.lesCivilites.getMesCivilitesItems();
   }

   public void chargerLesSourcesTiers() throws IOException {
      this.lesSourcesTiers = new LectureSourcesTiers(this.structureLog.getStrid());
      this.mesSourcesTiersItems = this.lesSourcesTiers.getMesSourcesTiersItems();
   }

   public void chargerLesCategoriesTiers() throws IOException {
      this.lesCategoriesTiers = new LectureTypeTiers();
      this.mesCategoriesTiersItems = this.lesCategoriesTiers.getMesTypeTiersItems();
   }

   public void chargerLesPays() throws IOException {
      this.lespays = new LecturePays();
      this.mesPaysItems = this.lespays.getMesPaysItems();
   }

   public void chargerLesResponsables(Session var1) throws HibernateException, NamingException {
      this.lesresponsablesItems.clear();
      new ArrayList();
      List var2 = this.userDao.chargerLesSignataires("Ventes", var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.lesresponsablesItems.add(new SelectItem(((Users)var2.get(var3)).getUsrid(), ((Users)var2.get(var3)).getUsrPatronyme()));
         }
      }

   }

   public void chargerLesFonctions() throws IOException {
      if (this.newUser != null) {
         this.lesFonctions = new LectureFonctions(this.newUser.getUsrCivilite());
      } else {
         this.lesFonctions = new LectureFonctions(this.usersLog.getUsrCivilite());
      }

      this.mesFonctionsItems = this.lesFonctions.getMesfonctionsItems();
   }

   public void chargerLesLangues() throws IOException {
      this.lesLangues = new LectureLangues();
      this.mesLanguesItems = this.lesLangues.getMesLanguesItems();
   }

   public void chargerLesDepots(Session var1) throws IOException, HibernateException, NamingException {
      this.listeDepot = this.depotAchatsDao.selectActifDepot(0, var1);
      this.lesDepotsFavoris.clear();
      this.dataModelDepotHabilites.setWrappedData(this.lesDepotsFavoris);
   }

   public void chargerLesProcess(Session var1) throws IOException, HibernateException, NamingException {
      this.listeProcess = this.processEnteteAchatsDao.selectProcess(var1);
      this.lesProcessFavoris.clear();
      this.dataModelProcessHabilites.setWrappedData(this.lesProcessFavoris);
   }

   public void chargerLesGroupes(Session var1) throws HibernateException, NamingException {
      this.mesGroupesItems = this.groupeDao.selectGroupeItems(var1);
   }

   public void chargerLesServices(Session var1) throws HibernateException, NamingException {
      this.mesServicesItems = this.serviceDao.chargerLesServicesItems(9, true, var1);
   }

   public void chargerLesChronoCpt(Session var1) throws HibernateException, NamingException {
      this.mesChronoComptaItems = this.chronoDao.selectListComptaItem(var1);
   }

   public void chargerLesChronoOff(Session var1) throws HibernateException, NamingException {
      this.mesChronoOfficeItems = this.chronoDao.selectListOfficeItem(var1);
   }

   public void chargerLesChronoAch(Session var1) throws HibernateException, NamingException {
      this.mesChronoAchatsItems = this.chronoDao.selectListFournisseurItem(var1);
   }

   public void chargerLesChronoVte(Session var1) throws HibernateException, NamingException {
      this.mesChronoVentesItems = this.chronoDao.selectListClientItem(var1);
   }

   public void chargerLesChronoCaisse(Session var1) throws HibernateException, NamingException {
      this.mesChronoCaisseItems = this.chronoDao.selectListCaisseItem(var1);
   }

   public void chargerLesOperationsCaisse(Session var1) throws HibernateException, NamingException {
      this.mesOperationsCaisses = this.caissesOperationsDao.selectActifOperation(var1);
   }

   public void chargerLesChronoPaye(Session var1) throws HibernateException, NamingException {
      this.mesChronoPayeItems = this.chronoDao.selectListPayeItem(var1);
   }

   public void chargerLesChronoMedical(Session var1) throws HibernateException, NamingException {
      this.mesChronoMedicalItems = this.chronoDao.selectListMedicalItem(var1);
   }

   public void chargerLesChronoParc(Session var1) throws HibernateException, NamingException {
      this.mesChronoParcItems = this.chronoDao.selectListParcItem(var1);
   }

   public void chargerLesTiers() throws HibernateException, NamingException {
      this.lesTiersItems.clear();
      TiersDao var1 = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.lesTiersItems = var1.chargerLesTiersFC((Session)null);
   }

   public void chargerLesSalaries() throws HibernateException, NamingException {
      this.lesSalariesItems.clear();
      SalariesDao var1 = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.lesSalariesItems = var1.chargerlesSalariesActifItem("*", (Session)null);
   }

   public void imprimerQrJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerQrPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimer() throws JRException, IOException, SQLException, ClassNotFoundException, Exception {
      if (this.newUser != null) {
         UtilPrint var1 = new UtilPrint(this.utilInitHibernate);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.setFormat(this.format);
         var1.setTiersSelectionne((Tiers)null);
         var1.setIdResponsable(this.newUser.getUsrid());
         ArrayList var2 = new ArrayList();
         JRBeanCollectionDataSource var3 = null;
         var1.setRapport("UtilisateursQrCode");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "entete" + File.separator + "sous_rapport" + File.separator);
         var1.setEntete("Génération QR CODE");
         String var4 = var1.calculeSecurityCode("ResetQrCode", 0L);
         this.newUser.setResetQrCode(var4);
         var2.add(this.newUser);
         var3 = new JRBeanCollectionDataSource(var2);
         var1.setjRBeanCollectionDataSource(var3);
         var1.imprimeRapport();
      }

   }

   public void ouvrirPermission() {
      if (this.newUser != null) {
         this.saisiePermission = "";
         this.affichagePermission = false;
         this.showModalPanelPermission = true;
      }

   }

   public void verifPermission() {
      if (this.newUser != null) {
         if (this.saisiePermission != null && !this.saisiePermission.isEmpty() && this.saisiePermission.equals("#PerAnd#")) {
            this.showModalPanelPermission = false;
            this.permission01 = false;
            this.permission02 = false;
            this.permission03 = false;
            this.permission04 = false;
            this.permission05 = false;
            this.permission06 = false;
            this.permission07 = false;
            this.permission08 = false;
            this.permission09 = false;
            this.permission10 = false;
            if (this.newUser.getUsrPermandroid() != null && !this.newUser.getUsrPermandroid().isEmpty()) {
               MD5Password var1 = new MD5Password();
               String var2 = var1.doubleDecryption_Base64_Blowfish(this.newUser.getUsrPermandroid());
               var2 = this.filtreCaracteres(var2);
               String var3 = "";
               String[] var4 = var2.split(",");
               String var5 = var4[0];
               String[] var6 = var5.split(":");
               String var7 = var6[0];
               if (var7.equals("PERM")) {
                  var3 = var6[1];
               } else {
                  var5 = var4[1];
                  var6 = var5.split(":");
                  var7 = var6[0];
                  if (var7.equals("PERM")) {
                     var3 = var6[1];
                  } else {
                     var5 = var4[2];
                     var6 = var5.split(":");
                     var7 = var6[0];
                     if (var7.equals("PERM")) {
                        var3 = var6[1];
                     }
                  }
               }

               if (var3 != null && !var3.isEmpty()) {
                  if (var3.substring(0, 1).equals("1")) {
                     this.permission01 = true;
                  }

                  if (var3.substring(1, 2).equals("1")) {
                     this.permission02 = true;
                  }

                  if (var3.substring(2, 3).equals("1")) {
                     this.permission03 = true;
                  }

                  if (var3.substring(3, 4).equals("1")) {
                     this.permission04 = true;
                  }

                  if (var3.substring(4, 5).equals("1")) {
                     this.permission05 = true;
                  }

                  if (var3.substring(5, 6).equals("1")) {
                     this.permission06 = true;
                  }

                  if (var3.substring(6, 7).equals("1")) {
                     this.permission07 = true;
                  }

                  if (var3.substring(7, 8).equals("1")) {
                     this.permission08 = true;
                  }

                  if (var3.substring(8, 9).equals("1")) {
                     this.permission09 = true;
                  }

                  if (var3.substring(9, 10).equals("1")) {
                     this.permission10 = true;
                  }
               }
            }

            this.affichagePermission = true;
         } else {
            this.affichagePermission = false;
         }
      }

   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz:=,1234567890".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         }
      }

      return var2;
   }

   public void fermerPermission() {
      this.affichagePermission = false;
      this.showModalPanelPermission = false;
   }

   public void validerPermission() throws JSONException, HibernateException, NamingException {
      if (this.newUser != null) {
         String var1 = "";
         JSONObject var2 = new JSONObject();
         var2.put("tag", "%PERMS%");
         var2.put("iduser", new Long(this.newUser.getUsrid()));
         byte var3 = 0;
         byte var4 = 0;
         byte var5 = 0;
         byte var6 = 0;
         byte var7 = 0;
         byte var8 = 0;
         byte var9 = 0;
         byte var10 = 0;
         byte var11 = 0;
         byte var12 = 0;
         if (this.permission01) {
            var3 = 1;
         }

         if (this.permission02) {
            var4 = 1;
         }

         if (this.permission03) {
            var5 = 1;
         }

         if (this.permission04) {
            var6 = 1;
         }

         if (this.permission05) {
            var7 = 1;
         }

         if (this.permission06) {
            var8 = 1;
         }

         if (this.permission07) {
            var9 = 1;
         }

         if (this.permission08) {
            var10 = 1;
         }

         if (this.permission09) {
            var11 = 1;
         }

         if (this.permission10) {
            var12 = 1;
         }

         var2.put("perm", new String("" + var3 + "" + var4 + "" + var5 + "" + var6 + "" + var7 + "" + var8 + "" + var9 + "" + var10 + "" + var11 + "" + var12));
         String var13 = var2.toString();
         MD5Password var14 = new MD5Password();
         var1 = var14.doubleEncryption_Blowfish_Base64(var13);
         this.newUser.setUsrPermandroid(var1);
         this.newUser = this.userDao.modUser(this.newUser);
         this.affichagePermission = false;
         this.showModalPanelPermission = false;
      }

   }

   public boolean isDisablemail() {
      return this.disablemail;
   }

   public void setDisablemail(boolean var1) {
      this.disablemail = var1;
   }

   public boolean isMail_Mesg() {
      return this.mail_Mesg;
   }

   public void setMail_Mesg(boolean var1) {
      this.mail_Mesg = var1;
   }

   public Users getNewUser() {
      return this.newUser;
   }

   public void setNewUser(Users var1) {
      this.newUser = var1;
   }

   public DataModel getDatamodelUserAdm() {
      return this.datamodelUserAdm;
   }

   public void setDatamodelUserAdm(DataModel var1) {
      this.datamodelUserAdm = var1;
   }

   public DataModel getDatamodelUserCoAdm() {
      return this.datamodelUserCoAdm;
   }

   public void setDatamodelUserCoAdm(DataModel var1) {
      this.datamodelUserCoAdm = var1;
   }

   public DataModel getDatamodelUserGu() {
      return this.datamodelUserGu;
   }

   public void setDatamodelUserGu(DataModel var1) {
      this.datamodelUserGu = var1;
   }

   public DataModel getDatamodelUserIn() {
      return this.datamodelUserIn;
   }

   public void setDatamodelUserIn(DataModel var1) {
      this.datamodelUserIn = var1;
   }

   public DataModel getDatamodelUserSt() {
      return this.datamodelUserSt;
   }

   public void setDatamodelUserSt(DataModel var1) {
      this.datamodelUserSt = var1;
   }

   public List getMesGroupesItems() {
      return this.mesGroupesItems;
   }

   public void setMesGroupesItems(List var1) {
      this.mesGroupesItems = var1;
   }

   public List getMesCategoriesTiersItems() {
      return this.mesCategoriesTiersItems;
   }

   public void setMesCategoriesTiersItems(List var1) {
      this.mesCategoriesTiersItems = var1;
   }

   public List getMesFonctionsItems() {
      return this.mesFonctionsItems;
   }

   public void setMesFonctionsItems(List var1) {
      this.mesFonctionsItems = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
   }

   public List getMesSourcesTiersItems() {
      return this.mesSourcesTiersItems;
   }

   public void setMesSourcesTiersItems(List var1) {
      this.mesSourcesTiersItems = var1;
   }

   public List getMesCiviliteItems() {
      return this.mesCiviliteItems;
   }

   public void setMesCiviliteItems(List var1) {
      this.mesCiviliteItems = var1;
   }

   public List getMesLanguesItems() {
      return this.mesLanguesItems;
   }

   public void setMesLanguesItems(List var1) {
      this.mesLanguesItems = var1;
   }

   public boolean isVerif_admin() {
      if (this.newUser.getUsrSysteme() >= 1) {
         this.verif_admin = true;
      } else {
         this.verif_admin = false;
      }

      return this.verif_admin;
   }

   public void setVerif_admin(boolean var1) {
      this.verif_admin = var1;
   }

   public List getMesAppreciationsItems() {
      return this.mesAppreciationsItems;
   }

   public void setMesAppreciationsItems(List var1) {
      this.mesAppreciationsItems = var1;
   }

   public boolean isTestAffLogin() {
      return this.testAffLogin;
   }

   public void setTestAffLogin(boolean var1) {
      this.testAffLogin = var1;
   }

   public boolean isTestAffPwdCS() {
      return this.testAffPwdCS;
   }

   public void setTestAffPwdCS(boolean var1) {
      this.testAffPwdCS = var1;
   }

   public boolean isTestAffGenPwdCs() {
      return this.testAffGenPwdCs;
   }

   public void setTestAffGenPwdCs(boolean var1) {
      this.testAffGenPwdCs = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVar_aff_bouton() {
      return this.var_aff_bouton;
   }

   public void setVar_aff_bouton(boolean var1) {
      this.var_aff_bouton = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public String getVar_departement() {
      return this.var_departement;
   }

   public void setVar_departement(String var1) {
      this.var_departement = var1;
   }

   public String getVar_service() {
      return this.var_service;
   }

   public void setVar_service(String var1) {
      this.var_service = var1;
   }

   public String getVar_site() {
      return this.var_site;
   }

   public void setVar_site(String var1) {
      this.var_site = var1;
   }

   public ListDataModel getDatamodelUsersChronoAch() {
      return this.datamodelUsersChronoAch;
   }

   public void setDatamodelUsersChronoAch(ListDataModel var1) {
      this.datamodelUsersChronoAch = var1;
   }

   public String getDepot() {
      return this.depot;
   }

   public void setDepot(String var1) {
      this.depot = var1;
   }

   public boolean isTestSelectSerieVte() {
      return this.testSelectSerieVte;
   }

   public void setTestSelectSerieVte(boolean var1) {
      this.testSelectSerieVte = var1;
   }

   public boolean isVisibiliteBtonAch() {
      return this.visibiliteBtonAch;
   }

   public void setVisibiliteBtonAch(boolean var1) {
      this.visibiliteBtonAch = var1;
   }

   public ListDataModel getDatamodelUsersChronoVte() {
      return this.datamodelUsersChronoVte;
   }

   public void setDatamodelUsersChronoVte(ListDataModel var1) {
      this.datamodelUsersChronoVte = var1;
   }

   public boolean isTestSelectSerieAch() {
      return this.testSelectSerieAch;
   }

   public void setTestSelectSerieAch(boolean var1) {
      this.testSelectSerieAch = var1;
   }

   public boolean isVisibiliteBtonVte() {
      return this.visibiliteBtonVte;
   }

   public void setVisibiliteBtonVte(boolean var1) {
      this.visibiliteBtonVte = var1;
   }

   public boolean isVar_aff_val_chronoAch() {
      return this.var_aff_val_chronoAch;
   }

   public void setVar_aff_val_chronoAch(boolean var1) {
      this.var_aff_val_chronoAch = var1;
   }

   public List getMesChronoAchatsItems() {
      return this.mesChronoAchatsItems;
   }

   public void setMesChronoAchatsItems(List var1) {
      this.mesChronoAchatsItems = var1;
   }

   public List getMesChronoVentesItems() {
      return this.mesChronoVentesItems;
   }

   public void setMesChronoVentesItems(List var1) {
      this.mesChronoVentesItems = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public String getInputChronoAch() {
      return this.inputChronoAch;
   }

   public void setInputChronoAch(String var1) {
      this.inputChronoAch = var1;
   }

   public String getInputChronoVte() {
      return this.inputChronoVte;
   }

   public void setInputChronoVte(String var1) {
      this.inputChronoVte = var1;
   }

   public boolean isVar_aff_val_chronoVte() {
      return this.var_aff_val_chronoVte;
   }

   public void setVar_aff_val_chronoVte(boolean var1) {
      this.var_aff_val_chronoVte = var1;
   }

   public Bal getBall() {
      return this.ball;
   }

   public void setBall(Bal var1) {
      this.ball = var1;
   }

   public String getBalmsg() {
      return this.balmsg;
   }

   public void setBalmsg(String var1) {
      this.balmsg = var1;
   }

   public boolean isBoutonBalgrpSup() {
      return this.boutonBalgrpSup;
   }

   public void setBoutonBalgrpSup(boolean var1) {
      this.boutonBalgrpSup = var1;
   }

   public ListDataModel getDatamodelBal() {
      return this.datamodelBal;
   }

   public void setDatamodelBal(ListDataModel var1) {
      this.datamodelBal = var1;
   }

   public String getLienPanel() {
      return this.lienPanel;
   }

   public void setLienPanel(String var1) {
      this.lienPanel = var1;
   }

   public boolean isVerifExistMail() {
      return this.verifExistMail;
   }

   public void setVerifExistMail(boolean var1) {
      this.verifExistMail = var1;
   }

   public ListDataModel getDatamodelUsersChronoCaiss() {
      return this.datamodelUsersChronoCaiss;
   }

   public void setDatamodelUsersChronoCaiss(ListDataModel var1) {
      this.datamodelUsersChronoCaiss = var1;
   }

   public String getInputChronoCaisse() {
      return this.inputChronoCaisse;
   }

   public void setInputChronoCaisse(String var1) {
      this.inputChronoCaisse = var1;
   }

   public boolean isTestSelectSerieCaiss() {
      return this.testSelectSerieCaiss;
   }

   public void setTestSelectSerieCaiss(boolean var1) {
      this.testSelectSerieCaiss = var1;
   }

   public boolean isVar_aff_val_chronoCaisse() {
      return this.var_aff_val_chronoCaisse;
   }

   public void setVar_aff_val_chronoCaisse(boolean var1) {
      this.var_aff_val_chronoCaisse = var1;
   }

   public boolean isVisibiliteBtonCaiss() {
      return this.visibiliteBtonCaiss;
   }

   public void setVisibiliteBtonCaiss(boolean var1) {
      this.visibiliteBtonCaiss = var1;
   }

   public List getMesChronoCaisseItems() {
      return this.mesChronoCaisseItems;
   }

   public void setMesChronoCaisseItems(List var1) {
      this.mesChronoCaisseItems = var1;
   }

   public ListDataModel getDatamodelUsersChronoPaye() {
      return this.datamodelUsersChronoPaye;
   }

   public void setDatamodelUsersChronoPaye(ListDataModel var1) {
      this.datamodelUsersChronoPaye = var1;
   }

   public String getInputChronoPaye() {
      return this.inputChronoPaye;
   }

   public void setInputChronoPaye(String var1) {
      this.inputChronoPaye = var1;
   }

   public boolean isTestSelectSeriePaye() {
      return this.testSelectSeriePaye;
   }

   public void setTestSelectSeriePaye(boolean var1) {
      this.testSelectSeriePaye = var1;
   }

   public boolean isVar_aff_val_chronoPaye() {
      return this.var_aff_val_chronoPaye;
   }

   public void setVar_aff_val_chronoPaye(boolean var1) {
      this.var_aff_val_chronoPaye = var1;
   }

   public boolean isVisibiliteBtonPaye() {
      return this.visibiliteBtonPaye;
   }

   public void setVisibiliteBtonPaye(boolean var1) {
      this.visibiliteBtonPaye = var1;
   }

   public List getMesChronoPayeItems() {
      return this.mesChronoPayeItems;
   }

   public void setMesChronoPayeItems(List var1) {
      this.mesChronoPayeItems = var1;
   }

   public ListDataModel getDatamodelUsersChronoOff() {
      return this.datamodelUsersChronoOff;
   }

   public void setDatamodelUsersChronoOff(ListDataModel var1) {
      this.datamodelUsersChronoOff = var1;
   }

   public String getInputChronoOff() {
      return this.inputChronoOff;
   }

   public void setInputChronoOff(String var1) {
      this.inputChronoOff = var1;
   }

   public List getMesChronoOfficeItems() {
      return this.mesChronoOfficeItems;
   }

   public void setMesChronoOfficeItems(List var1) {
      this.mesChronoOfficeItems = var1;
   }

   public boolean isVar_aff_val_chronoOff() {
      return this.var_aff_val_chronoOff;
   }

   public void setVar_aff_val_chronoOff(boolean var1) {
      this.var_aff_val_chronoOff = var1;
   }

   public boolean isVisibiliteBtonOff() {
      return this.visibiliteBtonOff;
   }

   public void setVisibiliteBtonOff(boolean var1) {
      this.visibiliteBtonOff = var1;
   }

   public boolean isVar_affiche_tout() {
      return this.var_affiche_tout;
   }

   public void setVar_affiche_tout(boolean var1) {
      this.var_affiche_tout = var1;
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

   public ListDataModel getDatamodelUsersChronoMed() {
      return this.datamodelUsersChronoMed;
   }

   public void setDatamodelUsersChronoMed(ListDataModel var1) {
      this.datamodelUsersChronoMed = var1;
   }

   public String getInputChronoMed() {
      return this.inputChronoMed;
   }

   public void setInputChronoMed(String var1) {
      this.inputChronoMed = var1;
   }

   public boolean isTestSelectSerieMed() {
      return this.testSelectSerieMed;
   }

   public void setTestSelectSerieMed(boolean var1) {
      this.testSelectSerieMed = var1;
   }

   public boolean isTestSelectSerieOff() {
      return this.testSelectSerieOff;
   }

   public void setTestSelectSerieOff(boolean var1) {
      this.testSelectSerieOff = var1;
   }

   public boolean isVar_aff_val_chronoMed() {
      return this.var_aff_val_chronoMed;
   }

   public void setVar_aff_val_chronoMed(boolean var1) {
      this.var_aff_val_chronoMed = var1;
   }

   public boolean isVisibiliteBtonMed() {
      return this.visibiliteBtonMed;
   }

   public void setVisibiliteBtonMed(boolean var1) {
      this.visibiliteBtonMed = var1;
   }

   public List getMesChronoMedicalItems() {
      return this.mesChronoMedicalItems;
   }

   public void setMesChronoMedicalItems(List var1) {
      this.mesChronoMedicalItems = var1;
   }

   public DataModel getDatamodelCoAdministration() {
      return this.datamodelCoAdministration;
   }

   public void setDatamodelCoAdministration(DataModel var1) {
      this.datamodelCoAdministration = var1;
   }

   public boolean isShowModalPanelFonction() {
      return this.showModalPanelFonction;
   }

   public void setShowModalPanelFonction(boolean var1) {
      this.showModalPanelFonction = var1;
   }

   public boolean isShowModalPanelAchat() {
      return this.showModalPanelAchat;
   }

   public void setShowModalPanelAchat(boolean var1) {
      this.showModalPanelAchat = var1;
   }

   public boolean isShowModalPanelBal() {
      return this.showModalPanelBal;
   }

   public void setShowModalPanelBal(boolean var1) {
      this.showModalPanelBal = var1;
   }

   public boolean isShowModalPanelCaisse() {
      return this.showModalPanelCaisse;
   }

   public void setShowModalPanelCaisse(boolean var1) {
      this.showModalPanelCaisse = var1;
   }

   public boolean isShowModalPanelMedical() {
      return this.showModalPanelMedical;
   }

   public void setShowModalPanelMedical(boolean var1) {
      this.showModalPanelMedical = var1;
   }

   public boolean isShowModalPanelOffice() {
      return this.showModalPanelOffice;
   }

   public void setShowModalPanelOffice(boolean var1) {
      this.showModalPanelOffice = var1;
   }

   public boolean isShowModalPanelPaye() {
      return this.showModalPanelPaye;
   }

   public void setShowModalPanelPaye(boolean var1) {
      this.showModalPanelPaye = var1;
   }

   public boolean isShowModalPanelVente() {
      return this.showModalPanelVente;
   }

   public void setShowModalPanelVente(boolean var1) {
      this.showModalPanelVente = var1;
   }

   public DataModel getDatamodelCoConfig() {
      return this.datamodelCoConfig;
   }

   public void setDatamodelCoConfig(DataModel var1) {
      this.datamodelCoConfig = var1;
   }

   public List getMesCaissesItems() {
      return this.mesCaissesItems;
   }

   public void setMesCaissesItems(List var1) {
      this.mesCaissesItems = var1;
   }

   public List getLesresponsablesItems() {
      return this.lesresponsablesItems;
   }

   public void setLesresponsablesItems(List var1) {
      this.lesresponsablesItems = var1;
   }

   public DataModel getDataModelOperation() {
      return this.dataModelOperation;
   }

   public void setDataModelOperation(DataModel var1) {
      this.dataModelOperation = var1;
   }

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
   }

   public ListDataModel getDatamodelUsersChronoPar() {
      return this.datamodelUsersChronoPar;
   }

   public void setDatamodelUsersChronoPar(ListDataModel var1) {
      this.datamodelUsersChronoPar = var1;
   }

   public String getInputChronoPar() {
      return this.inputChronoPar;
   }

   public void setInputChronoPar(String var1) {
      this.inputChronoPar = var1;
   }

   public boolean isShowModalPanelParc() {
      return this.showModalPanelParc;
   }

   public void setShowModalPanelParc(boolean var1) {
      this.showModalPanelParc = var1;
   }

   public boolean isVar_aff_val_chronoPar() {
      return this.var_aff_val_chronoPar;
   }

   public void setVar_aff_val_chronoPar(boolean var1) {
      this.var_aff_val_chronoPar = var1;
   }

   public boolean isVisibiliteBtonPar() {
      return this.visibiliteBtonPar;
   }

   public void setVisibiliteBtonPar(boolean var1) {
      this.visibiliteBtonPar = var1;
   }

   public List getMesChronoParcItems() {
      return this.mesChronoParcItems;
   }

   public void setMesChronoParcItems(List var1) {
      this.mesChronoParcItems = var1;
   }

   public List getLesActifs() {
      return this.lesActifs;
   }

   public void setLesActifs(List var1) {
      this.lesActifs = var1;
   }

   public int getTypeSelectionne() {
      return this.typeSelectionne;
   }

   public void setTypeSelectionne(int var1) {
      this.typeSelectionne = var1;
   }

   public List getLesAdm() {
      return this.lesAdm;
   }

   public void setLesAdm(List var1) {
      this.lesAdm = var1;
   }

   public List getLesCoAdm() {
      return this.lesCoAdm;
   }

   public void setLesCoAdm(List var1) {
      this.lesCoAdm = var1;
   }

   public List getLesGuest() {
      return this.lesGuest;
   }

   public void setLesGuest(List var1) {
      this.lesGuest = var1;
   }

   public List getLesInactif() {
      return this.lesInactif;
   }

   public void setLesInactif(List var1) {
      this.lesInactif = var1;
   }

   public List getLesTiersItems() {
      return this.lesTiersItems;
   }

   public void setLesTiersItems(List var1) {
      this.lesTiersItems = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getOngletActif() {
      return this.ongletActif;
   }

   public void setOngletActif(String var1) {
      this.ongletActif = var1;
   }

   public List getLesSalariesItems() {
      return this.lesSalariesItems;
   }

   public void setLesSalariesItems(List var1) {
      this.lesSalariesItems = var1;
   }

   public DataModel getDatamodelUserMed() {
      return this.datamodelUserMed;
   }

   public void setDatamodelUserMed(DataModel var1) {
      this.datamodelUserMed = var1;
   }

   public boolean isCs() {
      return this.cs;
   }

   public void setCs(boolean var1) {
      this.cs = var1;
   }

   public boolean isMd() {
      return this.md;
   }

   public void setMd(boolean var1) {
      this.md = var1;
   }

   public boolean isShowModalPanelChangeIdentifiant() {
      return this.showModalPanelChangeIdentifiant;
   }

   public void setShowModalPanelChangeIdentifiant(boolean var1) {
      this.showModalPanelChangeIdentifiant = var1;
   }

   public DataModel getDataModelDepotHabilites() {
      return this.dataModelDepotHabilites;
   }

   public void setDataModelDepotHabilites(DataModel var1) {
      this.dataModelDepotHabilites = var1;
   }

   public DataModel getDataModelProcessHabilites() {
      return this.dataModelProcessHabilites;
   }

   public void setDataModelProcessHabilites(DataModel var1) {
      this.dataModelProcessHabilites = var1;
   }

   public UIDataTable getExtDTableAdm() {
      return this.extDTableAdm;
   }

   public void setExtDTableAdm(UIDataTable var1) {
      this.extDTableAdm = var1;
   }

   public UIDataTable getExtDTableCoAdm() {
      return this.extDTableCoAdm;
   }

   public void setExtDTableCoAdm(UIDataTable var1) {
      this.extDTableCoAdm = var1;
   }

   public UIDataTable getExtDTableGu() {
      return this.extDTableGu;
   }

   public void setExtDTableGu(UIDataTable var1) {
      this.extDTableGu = var1;
   }

   public UIDataTable getExtDTableIn() {
      return this.extDTableIn;
   }

   public void setExtDTableIn(UIDataTable var1) {
      this.extDTableIn = var1;
   }

   public UIDataTable getExtDTableMed() {
      return this.extDTableMed;
   }

   public void setExtDTableMed(UIDataTable var1) {
      this.extDTableMed = var1;
   }

   public UIDataTable getExtDTableSt() {
      return this.extDTableSt;
   }

   public void setExtDTableSt(UIDataTable var1) {
      this.extDTableSt = var1;
   }

   public SimpleSelection getSimpleSelectionAdm() {
      return this.simpleSelectionAdm;
   }

   public void setSimpleSelectionAdm(SimpleSelection var1) {
      this.simpleSelectionAdm = var1;
   }

   public SimpleSelection getSimpleSelectionCoAdm() {
      return this.simpleSelectionCoAdm;
   }

   public void setSimpleSelectionCoAdm(SimpleSelection var1) {
      this.simpleSelectionCoAdm = var1;
   }

   public SimpleSelection getSimpleSelectionGu() {
      return this.simpleSelectionGu;
   }

   public void setSimpleSelectionGu(SimpleSelection var1) {
      this.simpleSelectionGu = var1;
   }

   public SimpleSelection getSimpleSelectionIn() {
      return this.simpleSelectionIn;
   }

   public void setSimpleSelectionIn(SimpleSelection var1) {
      this.simpleSelectionIn = var1;
   }

   public SimpleSelection getSimpleSelectionMed() {
      return this.simpleSelectionMed;
   }

   public void setSimpleSelectionMed(SimpleSelection var1) {
      this.simpleSelectionMed = var1;
   }

   public SimpleSelection getSimpleSelectionSt() {
      return this.simpleSelectionSt;
   }

   public void setSimpleSelectionSt(SimpleSelection var1) {
      this.simpleSelectionSt = var1;
   }

   public String getLibelleService() {
      return this.libelleService;
   }

   public void setLibelleService(String var1) {
      this.libelleService = var1;
   }

   public List getLesStructuresPeg() {
      return this.lesStructuresPeg;
   }

   public void setLesStructuresPeg(List var1) {
      this.lesStructuresPeg = var1;
   }

   public String getLibelleServiceSecondaire() {
      return this.libelleServiceSecondaire;
   }

   public void setLibelleServiceSecondaire(String var1) {
      this.libelleServiceSecondaire = var1;
   }

   public boolean isShowModalPanelPermission() {
      return this.showModalPanelPermission;
   }

   public void setShowModalPanelPermission(boolean var1) {
      this.showModalPanelPermission = var1;
   }

   public boolean isAffichagePermission() {
      return this.affichagePermission;
   }

   public void setAffichagePermission(boolean var1) {
      this.affichagePermission = var1;
   }

   public String getSaisiePermission() {
      return this.saisiePermission;
   }

   public void setSaisiePermission(String var1) {
      this.saisiePermission = var1;
   }

   public boolean isPermission01() {
      return this.permission01;
   }

   public void setPermission01(boolean var1) {
      this.permission01 = var1;
   }

   public boolean isPermission02() {
      return this.permission02;
   }

   public void setPermission02(boolean var1) {
      this.permission02 = var1;
   }

   public boolean isPermission03() {
      return this.permission03;
   }

   public void setPermission03(boolean var1) {
      this.permission03 = var1;
   }

   public boolean isPermission04() {
      return this.permission04;
   }

   public void setPermission04(boolean var1) {
      this.permission04 = var1;
   }

   public boolean isPermission05() {
      return this.permission05;
   }

   public void setPermission05(boolean var1) {
      this.permission05 = var1;
   }

   public boolean isPermission06() {
      return this.permission06;
   }

   public void setPermission06(boolean var1) {
      this.permission06 = var1;
   }

   public boolean isPermission07() {
      return this.permission07;
   }

   public void setPermission07(boolean var1) {
      this.permission07 = var1;
   }

   public boolean isPermission08() {
      return this.permission08;
   }

   public void setPermission08(boolean var1) {
      this.permission08 = var1;
   }

   public boolean isPermission09() {
      return this.permission09;
   }

   public void setPermission09(boolean var1) {
      this.permission09 = var1;
   }

   public boolean isPermission10() {
      return this.permission10;
   }

   public void setPermission10(boolean var1) {
      this.permission10 = var1;
   }

   public boolean isMail() {
      return this.mail;
   }

   public void setMail(boolean var1) {
      this.mail = var1;
   }

   public ListDataModel getDatamodelUsersChronoCpt() {
      return this.datamodelUsersChronoCpt;
   }

   public void setDatamodelUsersChronoCpt(ListDataModel var1) {
      this.datamodelUsersChronoCpt = var1;
   }

   public String getInputChronoCpt() {
      return this.inputChronoCpt;
   }

   public void setInputChronoCpt(String var1) {
      this.inputChronoCpt = var1;
   }

   public boolean isShowModalPanelCpt() {
      return this.showModalPanelCpt;
   }

   public void setShowModalPanelCpt(boolean var1) {
      this.showModalPanelCpt = var1;
   }

   public boolean isTestSelectSerieCpt() {
      return this.testSelectSerieCpt;
   }

   public void setTestSelectSerieCpt(boolean var1) {
      this.testSelectSerieCpt = var1;
   }

   public boolean isTestSelectSeriePar() {
      return this.testSelectSeriePar;
   }

   public void setTestSelectSeriePar(boolean var1) {
      this.testSelectSeriePar = var1;
   }

   public boolean isVar_aff_val_chronoCpt() {
      return this.var_aff_val_chronoCpt;
   }

   public void setVar_aff_val_chronoCpt(boolean var1) {
      this.var_aff_val_chronoCpt = var1;
   }

   public boolean isVisibiliteBtonCpt() {
      return this.visibiliteBtonCpt;
   }

   public void setVisibiliteBtonCpt(boolean var1) {
      this.visibiliteBtonCpt = var1;
   }

   public List getMesChronoComptaItems() {
      return this.mesChronoComptaItems;
   }

   public void setMesChronoComptaItems(List var1) {
      this.mesChronoComptaItems = var1;
   }

   public LectureFonctions getMesFonctions() {
      return this.mesFonctions;
   }

   public void setMesFonctions(LectureFonctions var1) {
      this.mesFonctions = var1;
   }

   public List getMesOperationsCaisses() {
      return this.mesOperationsCaisses;
   }

   public void setMesOperationsCaisses(List var1) {
      this.mesOperationsCaisses = var1;
   }
}
