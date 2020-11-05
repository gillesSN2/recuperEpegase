package com.epegase.systeme.formbakingbeans;

import com.epegase.forms.administration.FormExercicesPaye;
import com.epegase.forms.commun.FormDocumentsOfficiels;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.paye.FormBilanSocial;
import com.epegase.forms.paye.FormCalculBulletin;
import com.epegase.forms.paye.FormConges;
import com.epegase.forms.paye.FormCvAnalyse;
import com.epegase.forms.paye.FormFicheSalarie;
import com.epegase.forms.paye.FormImpressionPaye;
import com.epegase.forms.paye.FormMissions;
import com.epegase.forms.paye.FormPointage;
import com.epegase.forms.paye.FormPreparation;
import com.epegase.forms.paye.FormPrets;
import com.epegase.forms.paye.FormTransfertBulletin;
import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinMois;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.CentreImpot;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesElements;
import com.epegase.systeme.classe.SalariesGrh;
import com.epegase.systeme.classe.SalariesHistorique;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.BulletinMoisDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.CentreImpotDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.FeuilleCalculDao;
import com.epegase.systeme.dao.FeuilleCalculRubriqueDao;
import com.epegase.systeme.dao.LocalisationSalarieDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesElementsDao;
import com.epegase.systeme.dao.SalariesHistoriqueDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.menu.MenudroitPayeCtrl;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureBanque;
import com.epegase.systeme.xml.LectureCentresImpots;
import com.epegase.systeme.xml.LectureCentresSecuriteSociale;
import com.epegase.systeme.xml.LectureCivilites;
import com.epegase.systeme.xml.LectureClassementsAgents;
import com.epegase.systeme.xml.LectureCodesEmplois;
import com.epegase.systeme.xml.LectureConfigListeEntete;
import com.epegase.systeme.xml.LectureConfigListeLigne;
import com.epegase.systeme.xml.LectureConventions;
import com.epegase.systeme.xml.LectureLangues;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureNiveauxEmplois;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LireLesoptionsPaye;
import com.epegase.systeme.xml.ObjetBanque;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionConfigListe;
import com.epegase.systeme.xml.OptionPaye;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;
import org.xml.sax.SAXException;

public class FormBakingBeanPaye implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private FormRecherche formRecherche;
   private MenudroitPayeCtrl menudroitPayeCtrl;
   private ObjetLigneMenu menupaye;
   private ObjetLigneMenu menupayeMemo = new ObjetLigneMenu();
   private LectureModulesOnglets lesOnglets;
   private int nature;
   private OptionPaye optionPaye;
   private ExercicesPaye exoselectionne = new ExercicesPaye();
   private ExercicesPaye lastExoPaye = new ExercicesPaye();
   private long leIdExo;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private Chrono chrono;
   private ChronoDao chronoDao;
   private String messageAlerte;
   private List lesChronosUsers;
   private FormExercicesPaye formExercicesPaye;
   private FormFicheSalarie formFicheSalarie;
   private FormCalculBulletin formCalculBulletin;
   private FormTransfertBulletin formTransfertBulletin;
   private FormImpressionPaye formImpressionPaye;
   private FormMissions formMissions;
   private FormPointage formPointage;
   private FormBilanSocial formBilanSocial;
   private FormPrets formPrets;
   private FormConges formConges;
   private FormPreparation formPreparation;
   private FormCvAnalyse formCvAnalyse;
   private List mesNatureAgentsItems;
   private List mesNatureConsultantItems;
   private List mesCentresImpotsItems;
   private List mesCentresSecuritesItems;
   private List mesClassementsItems;
   private List mesNiveauxEmploisItems;
   private List mesCodesEmploisItems;
   private List mesConventionsItems;
   private List mesGrillesItems;
   private List mesCiviliteItems;
   private List lesCivilites;
   private List mesPaysItems;
   private List lesPays;
   private List mesNationnalitesItems;
   private List mesLanguesItems;
   private List documentImpressionItems;
   private List listeImpressionItems;
   private List mesSitesItems;
   private List mesServiceItems;
   private List mesActivitesItems;
   private List mesLocalisationItems;
   private List mesBudgetsItems;
   private List mesProjetsItems;
   private List mesParcsItems;
   private List mesFeuillesItems;
   private List mesClesItems;
   private List lesFeuillesCalculs;
   private List mesRubriquesItems;
   private List mesNatureRubriqueItems;
   private List mesBanqueItems;
   private List mesBanqueAgentsItems;
   private List lesBulletins = new ArrayList();
   private transient DataModel dataModelBulletins = new ListDataModel();
   private boolean showModalPanelBulletin = false;
   private transient DataModel dataModelListeBulletins;
   private boolean showModalPanelListeRubrique = false;
   private List listeRubriques = new ArrayList();
   private transient DataModel dataModelListeRubriques = new ListDataModel();
   private BulletinSalaire bulletinSalaire;
   private BulletinLigne bulletinLigne;
   private List lesBulletinsLigne = new ArrayList();
   private transient DataModel dataModelBulletinsLigne = new ListDataModel();
   private BulletinLigneDao bulletinLigneDao;
   private boolean var_affiche_bouton = false;
   private boolean var_correction = false;
   private BulletinMois bulletinMois;
   private BulletinMoisDao bulletinMoisDao;
   private boolean showModalPanelPrintBulletin = false;
   private String nomModeleDocument;
   private List bulletinImpressionItems;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String format;
   private boolean simulation = false;
   private int chargePatronales;
   private List mesBuletinsSalarieItems = new ArrayList();
   private String periodeBulletin;
   private String salarieBulletin;
   private boolean accesPrets;
   private boolean accesContrats;
   private boolean accesConges;
   private boolean accesAbsences;
   private boolean accesMissions;
   private boolean accesBulletins;
   private boolean accesProjet;
   private boolean accesInterim;
   private FileCtrl fileCtrl;
   private ArrayList listFiles;
   private UploadItem item;
   private int uploadsAvailable = 1;
   private String numRecup;
   private String quelTransfert;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private List mesTiersItems = new ArrayList();
   private FormDocumentsOfficiels formDocumentsOfficiels;
   private LectureModeleAutorise lectureModeleAutorise;
   private List lesModelesAutorises;
   private String configListeEntete;
   private String configListeLigne;

   public FormBakingBeanPaye() throws IOException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.bulletinLigneDao = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererExercices(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      ExercicesPayeDao var2 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      this.leIdExo = this.exoselectionne.getExepayId();
      this.lastExoPaye = var2.recupererLastExo(var1);
   }

   public void recupererLeIdExo() throws HibernateException, NamingException {
      this.recupererLeIdExo((Session)null);
   }

   public ExercicesPaye recupererLeIdExo(Session var1) throws NamingException {
      ExercicesPayeDao var2 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      if (this.leIdExo != 0L) {
         this.exoselectionne = var2.recupererLExoSelect(this.leIdExo, var1);
      } else {
         this.exoselectionne = var2.recupererLastExo(var1);
      }

      this.leIdExo = this.exoselectionne.getExepayId();
      return this.exoselectionne;
   }

   public List getLesExercicePaye(Session var1) throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.formExercicesPaye = new FormExercicesPaye();
      this.formExercicesPaye.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesPaye.setBaseLog(this.baseLog);
      this.formExercicesPaye.setStructureLog(this.structureLog);
      this.formExercicesPaye.setUsersLog(this.usersLog);
      this.formExercicesPaye.InstancesDaoUtilses();
      return this.formExercicesPaye.recupererLesexercices(var1);
   }

   public void menuGauchePaye() throws JDOMException, IOException {
      if (this.menudroitPayeCtrl == null) {
         this.menudroitPayeCtrl = new MenudroitPayeCtrl();
         this.menudroitPayeCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         if (this.optionPaye != null) {
            this.menudroitPayeCtrl.chargerMenuGauchePayeXml(this.usersLog.getUsrCollaboration(), this.structureLog, this.optionPaye);
         }
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("50000", this.usersLog.getUsrCollaboration());
   }

   public void menuGauchePayeRoster() throws JDOMException, IOException {
      if (this.menudroitPayeCtrl == null) {
         this.menudroitPayeCtrl = new MenudroitPayeCtrl();
         this.menudroitPayeCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         if (this.optionPaye != null) {
            this.menudroitPayeCtrl.chargerMenuGauchePayeRosterXml(this.usersLog.getUsrCollaboration(), this.structureLog, this.optionPaye);
         }
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("50300", this.usersLog.getUsrCollaboration());
   }

   public void menuGauchePayeTemps() throws JDOMException, IOException {
      if (this.menudroitPayeCtrl == null) {
         this.menudroitPayeCtrl = new MenudroitPayeCtrl();
         this.menudroitPayeCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         if (this.optionPaye != null) {
            this.menudroitPayeCtrl.chargerMenuGauchePayeTempsXml(this.usersLog.getUsrCollaboration(), this.structureLog, this.optionPaye);
         }
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("50200", this.usersLog.getUsrCollaboration());
   }

   public void menuGauchePayeGuest() throws JDOMException, IOException {
      if (this.menudroitPayeCtrl == null) {
         this.menudroitPayeCtrl = new MenudroitPayeCtrl();
         this.menudroitPayeCtrl.setStrId(this.structureLog.getStrid());
         if (this.usersLog.getUsrCollaboration() == null || this.usersLog.getUsrCollaboration().isEmpty()) {
            this.usersLog.setUsrCollaboration("ADM");
         }

         this.menudroitPayeCtrl.chargerMenuGauchePayeGuestXml(this.structureLog);
      }

      this.lesOnglets = new LectureModulesOnglets();
      this.lesOnglets.setStrId(this.structureLog.getStrid());
      this.lesOnglets.setStructureLog(this.structureLog);
      this.lesOnglets.chargerMesOnglets("50100", this.usersLog.getUsrCollaboration());
   }

   public void razMemoire() {
      this.formBilanSocial = null;
      this.formCalculBulletin = null;
      this.formConges = null;
      this.formFicheSalarie = null;
      this.formImpressionPaye = null;
      this.formMissions = null;
      this.formPointage = null;
      this.formPreparation = null;
      this.formPrets = null;
      this.formTransfertBulletin = null;
   }

   public void gestionPaye() throws JDOMException, IOException, NamingException, HibernateException, ParseException {
      this.accesProjet = false;
      this.accesInterim = false;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         if (this.structureLog.getStrmod1().equals("40300")) {
            this.accesProjet = true;
         } else if (this.structureLog.getStrmod1().equals("80400")) {
            this.accesInterim = true;
         }
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         if (this.structureLog.getStrmod2().equals("40300")) {
            this.accesProjet = true;
         } else if (this.structureLog.getStrmod2().equals("80400")) {
            this.accesInterim = true;
         }
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         if (this.structureLog.getStrmod3().equals("40300")) {
            this.accesProjet = true;
         } else if (this.structureLog.getStrmod3().equals("80400")) {
            this.accesInterim = true;
         }
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         if (this.structureLog.getStrmod4().equals("40300")) {
            this.accesProjet = true;
         } else if (this.structureLog.getStrmod4().equals("80400")) {
            this.accesInterim = true;
         }
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         if (this.structureLog.getStrmod5().equals("40300")) {
            this.accesProjet = true;
         } else if (this.structureLog.getStrmod5().equals("80400")) {
            this.accesInterim = true;
         }
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         if (this.structureLog.getStrmod6().equals("40300")) {
            this.accesProjet = true;
         } else if (this.structureLog.getStrmod6().equals("80400")) {
            this.accesInterim = true;
         }
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         if (this.structureLog.getStrmod7().equals("40300")) {
            this.accesProjet = true;
         } else if (this.structureLog.getStrmod7().equals("80400")) {
            this.accesInterim = true;
         }
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         if (this.structureLog.getStrmod8().equals("40300")) {
            this.accesProjet = true;
         } else if (this.structureLog.getStrmod8().equals("80400")) {
            this.accesInterim = true;
         }
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty()) {
         if (this.structureLog.getStrmod9().equals("40300")) {
            this.accesProjet = true;
         } else if (this.structureLog.getStrmod9().equals("80400")) {
            this.accesInterim = true;
         }
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         if (this.structureLog.getStrmod10().equals("40300")) {
            this.accesProjet = true;
         } else if (this.structureLog.getStrmod10().equals("80400")) {
            this.accesInterim = true;
         }
      }

      this.menupaye = new ObjetLigneMenu();
      if (this.menudroitPayeCtrl.getDataModelMenudroitPayeXmlList().isRowAvailable()) {
         this.menupaye = (ObjetLigneMenu)this.menudroitPayeCtrl.getDataModelMenudroitPayeXmlList().getRowData();
         if (this.menupaye.getLibelle_FR() != null && !this.menupaye.getLibelle_FR().isEmpty()) {
            this.menupayeMemo = this.menupaye;
            this.aiguillagePaye();
         }
      }

      if (this.accesInterim) {
         this.mesTiersItems.clear();
         TiersDao var1 = new TiersDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var2 = var1.chargerLesTiers("3", (Session)null);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               if (((Tiers)var2.get(var3)).getTiemodecom() != 0) {
                  this.mesTiersItems.add(new SelectItem(((Tiers)var2.get(var3)).getTieid(), ((Tiers)var2.get(var3)).getTieid() + ":" + ((Tiers)var2.get(var3)).getTieraisonsocialenom()));
               }
            }
         }
      }

   }

   public void gestionPayeFree(ObjetLigneMenu var1) throws JDOMException, IOException, HibernateException, NamingException, SAXException, ParseException {
      this.menupaye = var1;
      this.menupayeMemo = this.menupaye;
      if (this.lesOnglets.getMesOnglets().size() == 0) {
         this.menuGauchePaye();
      }

      this.aiguillagePaye();
   }

   public void aiguillagePaye() throws JDOMException, IOException, NamingException, HibernateException, ParseException {
      if (this.lastExoPaye.getExepayId() != this.exoselectionne.getExepayId()) {
         this.menupaye.setAdd(false);
         this.menupaye.setMaj(false);
         this.menupaye.setSup(false);
         this.menupaye.setDup(false);
         this.menupaye.setClo(false);
         this.menupaye.setTrf(false);
         this.menupaye.setImp(true);
      } else {
         this.menupaye.setAdd(this.menupayeMemo.isAdd());
         this.menupaye.setMaj(this.menupayeMemo.isMaj());
         this.menupaye.setSup(this.menupayeMemo.isSup());
         this.menupaye.setDup(this.menupayeMemo.isDup());
         this.menupaye.setClo(this.menupayeMemo.isClo());
         this.menupaye.setTrf(this.menupayeMemo.isTrf());
         this.menupaye.setImp(this.menupayeMemo.isImp());
      }

      this.razMemoire();
      Session var1;
      String var2;
      if (this.menupaye.getCommande().equalsIgnoreCase("50000:01")) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
         this.nature = 82;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesContrats = true;
            } else {
               this.accesContrats = false;
            }
         } else {
            this.accesContrats = false;
         }

         this.nature = 87;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesPrets = true;
            } else {
               this.accesPrets = false;
            }
         } else {
            this.accesPrets = false;
         }

         this.nature = 88;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesConges = true;
            } else {
               this.accesConges = false;
            }
         } else {
            this.accesConges = false;
         }

         this.nature = 89;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesAbsences = true;
            } else {
               this.accesAbsences = false;
            }
         } else {
            this.accesAbsences = false;
         }

         this.nature = 90;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesBulletins = true;
            } else {
               this.accesBulletins = false;
            }
         } else {
            this.accesBulletins = false;
         }

         this.nature = 91;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesMissions = true;
            } else {
               this.accesMissions = false;
            }
         } else {
            this.accesMissions = false;
         }

         this.nature = 81;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/FicheSalarieInit.jsp";
               this.menuFicheSalarie(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:02")) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
         this.nature = 82;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesContrats = true;
            } else {
               this.accesContrats = false;
            }
         } else {
            this.accesContrats = false;
         }

         this.nature = 87;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesPrets = true;
            } else {
               this.accesPrets = false;
            }
         } else {
            this.accesPrets = false;
         }

         this.nature = 89;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesAbsences = true;
            } else {
               this.accesAbsences = false;
            }
         } else {
            this.accesAbsences = false;
         }

         this.nature = 81;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/PreparationInit.jsp";
               this.menuPreparation(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:17")) {
         this.nature = 81;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/QuinzaineInit.jsp";
               this.menuQuinzaine(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:03")) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
         this.nature = 82;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesContrats = true;
            } else {
               this.accesContrats = false;
            }
         } else {
            this.accesContrats = false;
         }

         this.nature = 88;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesConges = true;
            } else {
               this.accesConges = false;
            }
         } else {
            this.accesConges = false;
         }

         this.nature = 89;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesAbsences = true;
            } else {
               this.accesAbsences = false;
            }
         } else {
            this.accesAbsences = false;
         }

         this.nature = 91;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesMissions = true;
            } else {
               this.accesMissions = false;
            }
         } else {
            this.accesMissions = false;
         }

         this.accesBulletins = false;
         this.nature = 81;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/RosterInit.jsp";
               this.menuRoster(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:04")) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
         this.nature = 82;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.accesContrats = true;
            } else {
               this.accesContrats = false;
            }
         } else {
            this.accesContrats = false;
         }

         this.nature = 81;
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/ImputationInit.jsp";
               this.menuFicheImputation(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:05")) {
         this.nature = 81;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/GenerationInit.jsp";
               this.menuGeneration(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:08")) {
         this.nature = 81;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/SimulationInit.jsp";
               this.menuSimulation(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:10")) {
         this.nature = 93;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/RessourcesHumainesInit.jsp";
               this.menuRessourcesHumaines(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:11")) {
         this.nature = 87;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/PretsInit.jsp";
               this.menuPrets(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:12")) {
         this.nature = 91;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/MissionsInit.jsp";
               this.menuMissions(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:13")) {
         this.nature = 88;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/CongesPayesInit.jsp";
               this.menuCongesPayes(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:16")) {
         this.nature = 89;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/AbsencesInit.jsp";
               this.menuAbsences(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:14")) {
         this.nature = 82;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/ContratsInit.jsp";
               this.menuContrats(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:15")) {
         this.nature = 92;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SalarieTache");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/PointageInit.jsp";
               this.menuPointage(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:20")) {
         this.nature = 94;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SalarieTache");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/TempsInit.jsp";
               this.menuTemps(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:21")) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SalarieTache");
         this.affichePage = "/paye/TachePaye.jsp";
         this.menuTache(var1);
         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:22")) {
         this.nature = 99;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "AnalyseCv");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/AnalyseCvInit.jsp";
               this.menuAnalyseCv(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:90")) {
         this.affichePage = "/paye/ImpressionPaye.jsp";
         this.nature = 81;
         this.menuImpressionPaye();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:91")) {
         this.affichePage = "/paye/ImpressionTemps.jsp";
         this.nature = 81;
         this.menuImpressionTemps();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:93")) {
         this.affichePage = "/paye/ImpressionBilanSocial.jsp";
         this.nature = 10;
         this.menuBilanSocial();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:95")) {
         this.nature = 93;
         this.affichePage = "/paye/ImportationPaye.jsp";
         this.importationEcritures();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:97")) {
         this.affichePage = "/commun/documentsOfficiels.jsp";
         this.nature = 80;
         this.menuDocuentsOfficiels();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:98")) {
         this.nature = 81;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, this.nature, var1);
         if (this.usersChrono != null) {
            var2 = "" + (this.exoselectionne.getExepayDateFin().getYear() + 1900);
            this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), this.nature, var2, var1);
            if (this.chrono != null) {
               this.affichePage = "/paye/TransfertBulletin.jsp";
               this.menuTransfert(var1);
            } else {
               this.affichePage = "/paye/ErreurAcces.jsp";
               this.messageAlerte = "Vous avez le droit d'accéder à cette fonction, mais la période du chrono n'existe pas.....";
            }
         } else {
            this.affichePage = "/paye/ErreurAcces.jsp";
            this.messageAlerte = "Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....";
         }

         this.utilInitHibernate.closeSession();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50100:01")) {
         this.mesBulletins();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50100:02")) {
         this.mesContrats();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50100:03")) {
         this.mesPretsInternes();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50100:04")) {
         this.mesPretsExternes();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50100:05")) {
         this.mesPretsManuels();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50100:06")) {
         this.monEpargne();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50100:07")) {
         this.mesAbsences();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50100:08")) {
         this.mesCongesPayes();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50100:10")) {
         this.monPointage();
      } else if (this.menupaye.getCommande().equalsIgnoreCase("50000:99") || this.menupaye.getCommande().equalsIgnoreCase("50100:99")) {
         this.affichePage = "/paye/SelectionExercicesPaye.jsp";
         this.menuSelectionExercicesPaye();
      }

   }

   public void menuFicheSalarie(Session var1) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.formFicheSalarie = new FormFicheSalarie();
      this.formFicheSalarie.setutilInitHibernate(this.utilInitHibernate);
      this.formFicheSalarie.setBaseLog(this.baseLog);
      this.formFicheSalarie.setStructureLog(this.structureLog);
      this.formFicheSalarie.setUsersLog(this.usersLog);
      this.formFicheSalarie.InstancesDaoUtilses();
      this.formFicheSalarie.setNature(this.nature);
      this.formFicheSalarie.setExercicesPaye(this.exoselectionne);
      this.formFicheSalarie.setLastExoPaye(this.lastExoPaye);
      this.formFicheSalarie.setOptionPaye(this.optionPaye);
      this.formFicheSalarie.setVar_option_parc(this.recupererOptionsParc());
      this.formFicheSalarie.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFicheSalarie.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formFicheSalarie.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formFicheSalarie.setMesClassementsItems(this.mesClassementsItems);
      this.formFicheSalarie.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formFicheSalarie.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formFicheSalarie.setMesConventionsItems(this.mesConventionsItems);
      this.formFicheSalarie.setMesGrillesItems(this.mesGrillesItems);
      this.formFicheSalarie.setMesServiceItems(this.mesServiceItems);
      this.formFicheSalarie.setMesSitesItems(this.mesSitesItems);
      this.formFicheSalarie.setMesTiersItems(this.mesTiersItems);
      this.formFicheSalarie.accesResteintUser();
      this.formFicheSalarie.accesResteintGroupe();
      this.recupererItemsSalarie(var1);
      this.formFicheSalarie.setMesNatureAgentItems(this.mesNatureAgentsItems);
      this.formFicheSalarie.setDocumentImpressionItems(this.documentImpressionItems);
      this.formFicheSalarie.setListeImpressionItems(this.listeImpressionItems);
      this.formFicheSalarie.setMesCiviliteItems(this.mesCiviliteItems);
      this.formFicheSalarie.setLesCivilites(this.lesCivilites);
      this.formFicheSalarie.setMesPaysItems(this.mesPaysItems);
      this.formFicheSalarie.setMesNationnalitesItems(this.mesNationnalitesItems);
      this.formFicheSalarie.setLesPays(this.lesPays);
      this.formFicheSalarie.setMesLanguesItems(this.mesLanguesItems);
      this.formFicheSalarie.setMesActiviteItems(this.mesActivitesItems);
      this.formFicheSalarie.setMesLocalisationItems(this.mesLocalisationItems);
      this.formFicheSalarie.setMesClesItems(this.mesClesItems);
      this.formFicheSalarie.setMesBudgetItems(this.mesBudgetsItems);
      this.formFicheSalarie.setMesProjetItems(this.mesProjetsItems);
      this.formFicheSalarie.setMesParcItems(this.mesParcsItems);
      this.formFicheSalarie.setMesFeuillesItems(this.mesFeuillesItems);
      this.formFicheSalarie.setAccesContrats(this.accesContrats);
      this.formFicheSalarie.setAccesPrets(this.accesPrets);
      this.formFicheSalarie.setAccesConges(this.accesConges);
      this.formFicheSalarie.setAccesAbsences(this.accesAbsences);
      this.formFicheSalarie.setAccesMissions(this.accesMissions);
      this.formFicheSalarie.setAccesBulletins(this.accesBulletins);
      this.formFicheSalarie.setAccesInterim(this.accesInterim);
      this.formFicheSalarie.setUrlExplorateur(this.urlExplorateur);
      this.formFicheSalarie.setDecoupageActivite(this.decoupageActivite);
      this.formFicheSalarie.setLaColonne1Items(this.laColonne1Items);
      this.formFicheSalarie.setLaColonne2Items(this.laColonne2Items);
      this.formFicheSalarie.setLaColonne3Items(this.laColonne3Items);
      this.formFicheSalarie.initialisation(var1);
      this.formFicheSalarie.setFormRecherche(this.formRecherche);
      if (this.optionPaye.getChargementListe() != null && !this.optionPaye.getChargementListe().isEmpty() && this.optionPaye.getChargementListe().equals("1") && this.mesNatureAgentsItems.size() != 0) {
         this.formFicheSalarie.setVar_nature_rec(((SelectItem)this.mesNatureAgentsItems.get(0)).getValue().toString());
         this.formFicheSalarie.rechercherSalarie(var1);
      }

      this.formFicheSalarie.setFormBakingBeanPaye(this);
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

   }

   public void menuRoster(Session var1) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.formFicheSalarie = new FormFicheSalarie();
      this.formFicheSalarie.setutilInitHibernate(this.utilInitHibernate);
      this.formFicheSalarie.setBaseLog(this.baseLog);
      this.formFicheSalarie.setStructureLog(this.structureLog);
      this.formFicheSalarie.setUsersLog(this.usersLog);
      this.formFicheSalarie.InstancesDaoUtilses();
      this.formFicheSalarie.setNature(this.nature);
      this.formFicheSalarie.setExercicesPaye(this.exoselectionne);
      this.formFicheSalarie.setLastExoPaye(this.lastExoPaye);
      this.formFicheSalarie.setOptionPaye(this.optionPaye);
      this.formFicheSalarie.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFicheSalarie.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formFicheSalarie.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formFicheSalarie.setMesClassementsItems(this.mesClassementsItems);
      this.formFicheSalarie.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formFicheSalarie.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formFicheSalarie.setMesConventionsItems(this.mesConventionsItems);
      this.formFicheSalarie.setMesGrillesItems(this.mesGrillesItems);
      this.formFicheSalarie.setMesServiceItems(this.mesServiceItems);
      this.formFicheSalarie.setMesSitesItems(this.mesSitesItems);
      this.formFicheSalarie.setMesTiersItems(this.mesTiersItems);
      this.formFicheSalarie.accesResteintUser();
      this.formFicheSalarie.accesResteintGroupe();
      this.recupererItemsSalarie(var1);
      this.formFicheSalarie.setMesNatureAgentItems(this.mesNatureConsultantItems);
      this.formFicheSalarie.setDocumentImpressionItems(this.documentImpressionItems);
      this.formFicheSalarie.setListeImpressionItems(this.listeImpressionItems);
      this.formFicheSalarie.setMesCiviliteItems(this.mesCiviliteItems);
      this.formFicheSalarie.setLesCivilites(this.lesCivilites);
      this.formFicheSalarie.setMesPaysItems(this.mesPaysItems);
      this.formFicheSalarie.setMesNationnalitesItems(this.mesNationnalitesItems);
      this.formFicheSalarie.setLesPays(this.lesPays);
      this.formFicheSalarie.setMesLanguesItems(this.mesLanguesItems);
      this.formFicheSalarie.setMesActiviteItems(this.mesActivitesItems);
      this.formFicheSalarie.setMesLocalisationItems(this.mesLocalisationItems);
      this.formFicheSalarie.setMesClesItems(this.mesClesItems);
      this.formFicheSalarie.setMesBudgetItems(this.mesBudgetsItems);
      this.formFicheSalarie.setMesProjetItems(this.mesProjetsItems);
      this.formFicheSalarie.setMesParcItems(this.mesParcsItems);
      this.formFicheSalarie.setMesFeuillesItems(this.mesFeuillesItems);
      this.formFicheSalarie.setAccesContrats(this.accesContrats);
      this.formFicheSalarie.setAccesPrets(false);
      this.formFicheSalarie.setAccesConges(false);
      this.formFicheSalarie.setAccesAbsences(this.accesAbsences);
      this.formFicheSalarie.setAccesMissions(this.accesMissions);
      this.formFicheSalarie.setAccesBulletins(false);
      this.formFicheSalarie.setUrlExplorateur(this.urlExplorateur);
      this.formFicheSalarie.setDecoupageActivite(this.decoupageActivite);
      this.formFicheSalarie.setLaColonne1Items(this.laColonne1Items);
      this.formFicheSalarie.setLaColonne2Items(this.laColonne2Items);
      this.formFicheSalarie.setLaColonne3Items(this.laColonne3Items);
      this.formFicheSalarie.initialisationRoster(var1);
      this.formFicheSalarie.setFormRecherche(this.formRecherche);
      if (this.optionPaye.getChargementListe() != null && !this.optionPaye.getChargementListe().isEmpty() && this.optionPaye.getChargementListe().equals("1") && this.mesNatureConsultantItems.size() != 0) {
         this.formFicheSalarie.setVar_nature_rec(((SelectItem)this.mesNatureConsultantItems.get(0)).getValue().toString());
         this.formFicheSalarie.rechercherSalarie(var1);
      }

      this.formFicheSalarie.setFormBakingBeanPaye(this);
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

   }

   public void menuFicheImputation(Session var1) throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.formFicheSalarie = new FormFicheSalarie();
      this.formFicheSalarie.setutilInitHibernate(this.utilInitHibernate);
      this.formFicheSalarie.setBaseLog(this.baseLog);
      this.formFicheSalarie.setStructureLog(this.structureLog);
      this.formFicheSalarie.setUsersLog(this.usersLog);
      this.formFicheSalarie.InstancesDaoUtilses();
      this.formFicheSalarie.setNature(this.nature);
      this.formFicheSalarie.setExercicesPaye(this.exoselectionne);
      this.formFicheSalarie.setLastExoPaye(this.lastExoPaye);
      this.formFicheSalarie.setOptionPaye(this.optionPaye);
      this.formFicheSalarie.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFicheSalarie.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formFicheSalarie.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formFicheSalarie.setMesClassementsItems(this.mesClassementsItems);
      this.formFicheSalarie.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formFicheSalarie.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formFicheSalarie.setMesConventionsItems(this.mesConventionsItems);
      this.formFicheSalarie.setMesGrillesItems(this.mesGrillesItems);
      this.formFicheSalarie.setMesServiceItems(this.mesServiceItems);
      this.formFicheSalarie.setMesSitesItems(this.mesSitesItems);
      this.formFicheSalarie.setMesTiersItems(this.mesTiersItems);
      this.formFicheSalarie.accesResteintUser();
      this.formFicheSalarie.accesResteintGroupe();
      this.formFicheSalarie.initialisationImputation(var1);
      this.recupererItemsSalarie(var1);
      this.formFicheSalarie.setMesNatureAgentItems(this.mesNatureAgentsItems);
      this.formFicheSalarie.setDocumentImpressionItems(this.documentImpressionItems);
      this.formFicheSalarie.setListeImpressionItems(this.listeImpressionItems);
      this.formFicheSalarie.setMesCiviliteItems(this.mesCiviliteItems);
      this.formFicheSalarie.setLesCivilites(this.lesCivilites);
      this.formFicheSalarie.setMesPaysItems(this.mesPaysItems);
      this.formFicheSalarie.setMesNationnalitesItems(this.mesNationnalitesItems);
      this.formFicheSalarie.setLesPays(this.lesPays);
      this.formFicheSalarie.setMesLanguesItems(this.mesLanguesItems);
      this.formFicheSalarie.setMesActiviteItems(this.mesActivitesItems);
      this.formFicheSalarie.setMesLocalisationItems(this.mesLocalisationItems);
      this.formFicheSalarie.setMesClesItems(this.mesClesItems);
      this.formFicheSalarie.setMesBudgetItems(this.mesBudgetsItems);
      this.formFicheSalarie.setMesProjetItems(this.mesProjetsItems);
      this.formFicheSalarie.setMesParcItems(this.mesParcsItems);
      this.formFicheSalarie.setMesFeuillesItems(this.mesFeuillesItems);
      this.formFicheSalarie.setAccesContrats(this.accesContrats);
      this.formFicheSalarie.setAccesPrets(this.accesPrets);
      this.formFicheSalarie.setAccesConges(this.accesConges);
      this.formFicheSalarie.setAccesAbsences(this.accesAbsences);
      this.formFicheSalarie.setAccesMissions(this.accesMissions);
      this.formFicheSalarie.setAccesBulletins(this.accesBulletins);
      this.formFicheSalarie.setAccesInterim(this.accesInterim);
      this.formFicheSalarie.setUrlExplorateur(this.urlExplorateur);
      this.formFicheSalarie.setDecoupageActivite(this.decoupageActivite);
      this.formFicheSalarie.setLaColonne1Items(this.laColonne1Items);
      this.formFicheSalarie.setLaColonne2Items(this.laColonne2Items);
      this.formFicheSalarie.setLaColonne3Items(this.laColonne3Items);
      this.formFicheSalarie.setFormRecherche(this.formRecherche);
      if (this.optionPaye.getChargementListe() != null && !this.optionPaye.getChargementListe().isEmpty() && this.optionPaye.getChargementListe().equals("1")) {
         this.formFicheSalarie.rechercherSalarie(var1);
      }

      this.formFicheSalarie.setFormBakingBeanPaye(this);
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

   }

   public void menuPreparation(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formPreparation = new FormPreparation();
      this.formPreparation.setutilInitHibernate(this.utilInitHibernate);
      this.formPreparation.setBaseLog(this.baseLog);
      this.formPreparation.setStructureLog(this.structureLog);
      this.formPreparation.setUsersLog(this.usersLog);
      this.formPreparation.InstancesDaoUtilses();
      this.formPreparation.setNature(this.nature);
      this.formPreparation.setExercicesPaye(this.exoselectionne);
      this.formPreparation.setLastExoPaye(this.lastExoPaye);
      this.formPreparation.setOptionPaye(this.optionPaye);
      this.formPreparation.setVar_option_parc(this.recupererOptionsParc());
      this.formPreparation.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formPreparation.accesResteintUser();
      this.formPreparation.accesResteintGroupe();
      this.formPreparation.setMesServiceItems(this.mesServiceItems);
      this.formPreparation.setMesClientsItems(this.mesTiersItems);
      this.formPreparation.setMesProjetItems(this.mesProjetsItems);
      this.recupererItemsSalarie(var1);
      this.formPreparation.setMesNatureAgentsItems(this.mesNatureAgentsItems);
      this.formPreparation.setAccesInterim(this.accesInterim);
      this.formPreparation.setDocumentImpressionItems(this.documentImpressionItems);
      this.formPreparation.setListeImpressionItems(this.listeImpressionItems);
      this.formPreparation.setMesActivitesItems(this.mesActivitesItems);
      this.formPreparation.setMesLocalisationItems(this.mesLocalisationItems);
      this.formPreparation.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formPreparation.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formPreparation.setMesClassementsItems(this.mesClassementsItems);
      this.formPreparation.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formPreparation.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formPreparation.setMesConventionsItems(this.mesConventionsItems);
      this.formPreparation.setMesClesItems(this.mesClesItems);
      this.formPreparation.setLesFeuilles(this.lesFeuillesCalculs);
      this.formPreparation.setMesParcItems(this.mesParcsItems);
      this.formPreparation.setMesFeuillesItems(this.mesFeuillesItems);
      this.formPreparation.setAccesContrats(this.accesContrats);
      this.formPreparation.setAccesPrets(this.accesPrets);
      this.formPreparation.setAccesAbsences(this.accesAbsences);
      this.formPreparation.calculPeriodes(var1);
      this.formPreparation.calculJours(var1);
      this.formPreparation.initialisation(var1);
      this.formPreparation.setDecoupageActivite(this.decoupageActivite);
      this.formPreparation.setFormBakingBeanPaye(this);
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

   }

   public void menuQuinzaine(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formPreparation = new FormPreparation();
      this.formPreparation.setutilInitHibernate(this.utilInitHibernate);
      this.formPreparation.setBaseLog(this.baseLog);
      this.formPreparation.setStructureLog(this.structureLog);
      this.formPreparation.setUsersLog(this.usersLog);
      this.formPreparation.InstancesDaoUtilses();
      this.formPreparation.setNature(this.nature);
      this.formPreparation.setExercicesPaye(this.exoselectionne);
      this.formPreparation.setLastExoPaye(this.lastExoPaye);
      this.formPreparation.setOptionPaye(this.optionPaye);
      this.formPreparation.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formPreparation.accesResteintUser();
      this.formPreparation.accesResteintGroupe();
      this.formPreparation.setMesServiceItems(this.mesServiceItems);
      this.formPreparation.setMesClientsItems(this.mesTiersItems);
      this.formPreparation.setMesProjetItems(this.mesProjetsItems);
      this.recupererItemsSalarie(var1);
      this.formPreparation.setMesNatureAgentsItems(this.mesNatureAgentsItems);
      this.formPreparation.setAccesInterim(this.accesInterim);
      this.formPreparation.setDocumentImpressionItems(this.documentImpressionItems);
      this.formPreparation.setListeImpressionItems(this.listeImpressionItems);
      this.formPreparation.setMesActivitesItems(this.mesActivitesItems);
      this.formPreparation.setMesLocalisationItems(this.mesLocalisationItems);
      this.formPreparation.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formPreparation.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formPreparation.setMesClassementsItems(this.mesClassementsItems);
      this.formPreparation.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formPreparation.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formPreparation.setMesConventionsItems(this.mesConventionsItems);
      this.formPreparation.setMesClesItems(this.mesClesItems);
      this.formPreparation.setLesFeuilles(this.lesFeuillesCalculs);
      this.formPreparation.setMesFeuillesItems(this.mesFeuillesItems);
      this.formPreparation.calculPeriodes(var1);
      this.formPreparation.calculJours(var1);
      this.formPreparation.initialisation(var1);
      this.formPreparation.setFormBakingBeanPaye(this);
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

   }

   public void menuGeneration(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formCalculBulletin = new FormCalculBulletin();
      this.formCalculBulletin.setutilInitHibernate(this.utilInitHibernate);
      this.formCalculBulletin.setBaseLog(this.baseLog);
      this.formCalculBulletin.setStructureLog(this.structureLog);
      this.formCalculBulletin.setUsersLog(this.usersLog);
      this.formCalculBulletin.InstancesDaoUtilses();
      this.formCalculBulletin.setNature(this.nature);
      this.formCalculBulletin.setExercicesPaye(this.exoselectionne);
      this.formCalculBulletin.setLastExoPaye(this.lastExoPaye);
      this.formCalculBulletin.setOptionPaye(this.optionPaye);
      this.formCalculBulletin.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCalculBulletin.accesResteintUser();
      this.formCalculBulletin.accesResteintGroupe();
      this.formCalculBulletin.setMesServiceItems(this.mesServiceItems);
      this.formCalculBulletin.setMesClientsItems(this.mesTiersItems);
      this.formCalculBulletin.setMesProjetItems(this.mesProjetsItems);
      this.recupererItemsSalarie(var1);
      this.formCalculBulletin.setMesNatureAgentsItems(this.mesNatureAgentsItems);
      this.formCalculBulletin.setAccesInterim(this.accesInterim);
      this.formCalculBulletin.setDocumentImpressionItems(this.documentImpressionItems);
      this.formCalculBulletin.setMesActivitesItems(this.mesActivitesItems);
      this.recupererBanques(var1);
      this.formCalculBulletin.setMesBanqueItems(this.mesBanqueItems);
      this.formCalculBulletin.setMesLocalisationItems(this.mesLocalisationItems);
      this.formCalculBulletin.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formCalculBulletin.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formCalculBulletin.setMesClassementsItems(this.mesClassementsItems);
      this.formCalculBulletin.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formCalculBulletin.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formCalculBulletin.setMesConventionsItems(this.mesConventionsItems);
      this.formCalculBulletin.setMesClesItems(this.mesClesItems);
      this.formCalculBulletin.setLesFeuilles(this.lesFeuillesCalculs);
      this.formCalculBulletin.setMesFeuillesItems(this.mesFeuillesItems);
      this.formCalculBulletin.setListeImpressionItems(this.listeImpressionItems);
      this.formCalculBulletin.calculPeriodes(var1);
      this.formCalculBulletin.calculJours(var1);
      this.formCalculBulletin.initialisation(var1);
      this.formCalculBulletin.setFormBakingBeanPaye(this);
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.showModalPanelPrintBulletin = false;
   }

   public void menuSimulation(Session var1) throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.formCalculBulletin = new FormCalculBulletin();
      this.formCalculBulletin.setutilInitHibernate(this.utilInitHibernate);
      this.formCalculBulletin.setBaseLog(this.baseLog);
      this.formCalculBulletin.setStructureLog(this.structureLog);
      this.formCalculBulletin.setUsersLog(this.usersLog);
      this.formCalculBulletin.InstancesDaoUtilses();
      this.formCalculBulletin.setNature(this.nature);
      this.formCalculBulletin.setExercicesPaye(this.exoselectionne);
      this.formCalculBulletin.setLastExoPaye(this.lastExoPaye);
      this.formCalculBulletin.setOptionPaye(this.optionPaye);
      this.formCalculBulletin.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCalculBulletin.accesResteintUser();
      this.formCalculBulletin.accesResteintGroupe();
      this.recupererItemsSalarie(var1);
      this.formCalculBulletin.setMesNatureAgentsItems(this.mesNatureAgentsItems);
      this.formCalculBulletin.setDocumentImpressionItems(this.documentImpressionItems);
      this.formCalculBulletin.setListeImpressionItems(this.listeImpressionItems);
      this.formCalculBulletin.setMesActivitesItems(this.mesActivitesItems);
      this.formCalculBulletin.setMesClientsItems(this.mesTiersItems);
      this.formCalculBulletin.setMesLocalisationItems(this.mesLocalisationItems);
      this.formCalculBulletin.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formCalculBulletin.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formCalculBulletin.setMesClassementsItems(this.mesClassementsItems);
      this.formCalculBulletin.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formCalculBulletin.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formCalculBulletin.setMesConventionsItems(this.mesConventionsItems);
      this.formCalculBulletin.setMesClesItems(this.mesClesItems);
      this.formCalculBulletin.setMesNatureAgentsItems(this.mesNatureAgentsItems);
      this.formCalculBulletin.setMesFeuillesItems(this.mesFeuillesItems);
      this.formCalculBulletin.setMesParcItems(this.mesParcsItems);
      this.formCalculBulletin.initialisation(var1);
      this.formCalculBulletin.simulation();
      this.formCalculBulletin.setFormBakingBeanPaye(this);
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.formCalculBulletin.setFormRecherche(this.formRecherche);
   }

   public void menuRessourcesHumaines(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.formFicheSalarie = new FormFicheSalarie();
      this.formFicheSalarie.setutilInitHibernate(this.utilInitHibernate);
      this.formFicheSalarie.setBaseLog(this.baseLog);
      this.formFicheSalarie.setStructureLog(this.structureLog);
      this.formFicheSalarie.setUsersLog(this.usersLog);
      this.formFicheSalarie.InstancesDaoUtilses();
      this.formFicheSalarie.setNature(this.nature);
      this.formFicheSalarie.setExercicesPaye(this.exoselectionne);
      this.formFicheSalarie.setLastExoPaye(this.lastExoPaye);
      this.formFicheSalarie.setOptionPaye(this.optionPaye);
      this.formFicheSalarie.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFicheSalarie.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formFicheSalarie.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formFicheSalarie.setMesClassementsItems(this.mesClassementsItems);
      this.formFicheSalarie.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formFicheSalarie.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formFicheSalarie.setMesConventionsItems(this.mesConventionsItems);
      this.formFicheSalarie.setMesGrillesItems(this.mesGrillesItems);
      this.formFicheSalarie.setMesServiceItems(this.mesServiceItems);
      this.formFicheSalarie.setMesSitesItems(this.mesSitesItems);
      this.formFicheSalarie.setMesTiersItems(this.mesTiersItems);
      this.formFicheSalarie.accesResteintUser();
      this.formFicheSalarie.accesResteintGroupe();
      this.formFicheSalarie.initialisationRh(var1);
      this.formFicheSalarie.recupererElementRh(var1);
      this.recupererItemsSalarie(var1);
      this.formFicheSalarie.setMesNatureAgentItems(this.mesNatureAgentsItems);
      this.formFicheSalarie.setDocumentImpressionItems(this.documentImpressionItems);
      this.formFicheSalarie.setListeImpressionItems(this.listeImpressionItems);
      this.formFicheSalarie.setMesCiviliteItems(this.mesCiviliteItems);
      this.formFicheSalarie.setMesLocalisationItems(this.mesLocalisationItems);
      this.formFicheSalarie.setLesCivilites(this.lesCivilites);
      this.formFicheSalarie.setMesPaysItems(this.mesPaysItems);
      this.formFicheSalarie.setMesNationnalitesItems(this.mesNationnalitesItems);
      this.formFicheSalarie.setLesPays(this.lesPays);
      this.formFicheSalarie.setMesLanguesItems(this.mesLanguesItems);
      this.formFicheSalarie.setMesActiviteItems(this.mesActivitesItems);
      this.formFicheSalarie.setMesClesItems(this.mesClesItems);
      this.formFicheSalarie.setMesBudgetItems(this.mesBudgetsItems);
      this.formFicheSalarie.setMesProjetItems(this.mesProjetsItems);
      this.formFicheSalarie.setMesParcItems(this.mesParcsItems);
      this.formFicheSalarie.setMesFeuillesItems(this.mesFeuillesItems);
      this.formFicheSalarie.setFormRecherche(this.formRecherche);
      this.formFicheSalarie.setUrlExplorateur(this.urlExplorateur);
      this.formFicheSalarie.setFormBakingBeanPaye(this);
   }

   public void menuPrets(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.formPrets = new FormPrets();
      this.formPrets.setutilInitHibernate(this.utilInitHibernate);
      this.formPrets.setBaseLog(this.baseLog);
      this.formPrets.setStructureLog(this.structureLog);
      this.formPrets.setUsersLog(this.usersLog);
      this.formPrets.InstancesDaoUtilses();
      this.formPrets.setNature(this.nature);
      this.formPrets.setExercicesPaye(this.exoselectionne);
      this.formPrets.setLastExoPaye(this.lastExoPaye);
      this.formPrets.setOptionPaye(this.optionPaye);
      this.formPrets.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formPrets.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formPrets.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formPrets.setMesClassementsItems(this.mesClassementsItems);
      this.formPrets.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formPrets.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formPrets.setMesConventionsItems(this.mesConventionsItems);
      this.formPrets.setMesGrillesItems(this.mesGrillesItems);
      this.formPrets.setMesServiceItems(this.mesServiceItems);
      this.formPrets.setMesTiersItems(this.mesTiersItems);
      this.formPrets.accesResteintUser();
      this.formPrets.accesResteintGroupe();
      this.formPrets.initialisationPret(var1);
      this.formPrets.recupererPrets();
      this.recupererItemsSalarie(var1);
      this.formPrets.setMesNatureAgentItems(this.mesNatureAgentsItems);
      this.formPrets.setDocumentImpressionItems(this.documentImpressionItems);
      this.formPrets.setListeImpressionItems(this.listeImpressionItems);
      this.formPrets.setMesCiviliteItems(this.mesCiviliteItems);
      this.formPrets.setLesCivilites(this.lesCivilites);
      this.formPrets.setMesPaysItems(this.mesPaysItems);
      this.formPrets.setMesNationnalitesItems(this.mesNationnalitesItems);
      this.formPrets.setLesPays(this.lesPays);
      this.formPrets.setMesLanguesItems(this.mesLanguesItems);
      this.formPrets.setMesActiviteItems(this.mesActivitesItems);
      this.formPrets.setMesClesItems(this.mesClesItems);
      this.formPrets.setMesBudgetItems(this.mesBudgetsItems);
      this.formPrets.setMesProjetItems(this.mesProjetsItems);
      this.formPrets.setMesParcItems(this.mesParcsItems);
      this.formPrets.setMesFeuillesItems(this.mesFeuillesItems);
      this.formPrets.setAccesInterim(this.accesInterim);
      this.formPrets.setFormRecherche(this.formRecherche);
   }

   public void menuMissions(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.formMissions = new FormMissions();
      this.formMissions.setutilInitHibernate(this.utilInitHibernate);
      this.formMissions.setBaseLog(this.baseLog);
      this.formMissions.setStructureLog(this.structureLog);
      this.formMissions.setUsersLog(this.usersLog);
      this.formMissions.InstancesDaoUtilses();
      this.formMissions.setNature(this.nature);
      this.formMissions.setExercicesPaye(this.exoselectionne);
      this.formMissions.setLastExoPaye(this.lastExoPaye);
      this.formMissions.setOptionPaye(this.optionPaye);
      this.formMissions.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formMissions.setMesServiceItems(this.mesServiceItems);
      this.formMissions.accesResteintUser();
      this.formMissions.accesResteintGroupe();
      this.formMissions.initialisation(var1);
      this.recupererItemsSalarie(var1);
      this.formMissions.setDocumentImpressionItems(this.documentImpressionItems);
      this.formMissions.setListeImpressionItems(this.listeImpressionItems);
      this.formMissions.setMesPaysItems(this.mesPaysItems);
      this.formMissions.setMesNationnalitesItems(this.mesNationnalitesItems);
      this.formMissions.setLesPays(this.lesPays);
      this.formMissions.setMesLanguesItems(this.mesLanguesItems);
      this.formMissions.setMesActiviteItems(this.mesActivitesItems);
      this.formMissions.setMesBudgetItems(this.mesBudgetsItems);
      this.formMissions.setMesProjetItems(this.mesProjetsItems);
      this.formMissions.setFormRecherche(this.formRecherche);
      this.formMissions.recupererLesResponsablesItem(var1);
      if (this.optionPaye.getChargementListe() != null && !this.optionPaye.getChargementListe().isEmpty() && this.optionPaye.getChargementListe().equals("1")) {
         this.formMissions.rechercherMissions(var1);
      }

   }

   public void menuCongesPayes(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.formConges = new FormConges();
      this.formConges.setutilInitHibernate(this.utilInitHibernate);
      this.formConges.setBaseLog(this.baseLog);
      this.formConges.setStructureLog(this.structureLog);
      this.formConges.setUsersLog(this.usersLog);
      this.formConges.InstancesDaoUtilses();
      this.formConges.setNature(this.nature);
      this.formConges.setExercicesPaye(this.exoselectionne);
      this.formConges.setLastExoPaye(this.lastExoPaye);
      this.formConges.setOptionPaye(this.optionPaye);
      this.formConges.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formConges.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formConges.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formConges.setMesClassementsItems(this.mesClassementsItems);
      this.formConges.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formConges.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formConges.setMesConventionsItems(this.mesConventionsItems);
      this.formConges.setMesGrillesItems(this.mesGrillesItems);
      this.formConges.setMesServiceItems(this.mesServiceItems);
      this.formConges.accesResteintUser();
      this.formConges.accesResteintGroupe();
      this.formConges.initialisationCp(var1);
      this.formConges.recupererCp();
      this.recupererItemsSalarie(var1);
      this.formConges.setMesNatureAgentItems(this.mesNatureAgentsItems);
      this.formConges.setDocumentImpressionItems(this.documentImpressionItems);
      this.formConges.setListeImpressionItems(this.listeImpressionItems);
      this.formConges.setMesCiviliteItems(this.mesCiviliteItems);
      this.formConges.setLesCivilites(this.lesCivilites);
      this.formConges.setMesPaysItems(this.mesPaysItems);
      this.formConges.setMesNationnalitesItems(this.mesNationnalitesItems);
      this.formConges.setLesPays(this.lesPays);
      this.formConges.setMesLanguesItems(this.mesLanguesItems);
      this.formConges.setMesActiviteItems(this.mesActivitesItems);
      this.formConges.setMesClesItems(this.mesClesItems);
      this.formConges.setMesBudgetItems(this.mesBudgetsItems);
      this.formConges.setMesProjetItems(this.mesProjetsItems);
      this.formConges.setMesParcItems(this.mesParcsItems);
      this.formConges.setMesFeuillesItems(this.mesFeuillesItems);
      this.formConges.setFormRecherche(this.formRecherche);
   }

   public void menuAbsences(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.formConges = new FormConges();
      this.formConges.setutilInitHibernate(this.utilInitHibernate);
      this.formConges.setBaseLog(this.baseLog);
      this.formConges.setStructureLog(this.structureLog);
      this.formConges.setUsersLog(this.usersLog);
      this.formConges.InstancesDaoUtilses();
      this.formConges.setNature(this.nature);
      this.formConges.setExercicesPaye(this.exoselectionne);
      this.formConges.setLastExoPaye(this.lastExoPaye);
      this.formConges.setOptionPaye(this.optionPaye);
      this.formConges.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formConges.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formConges.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formConges.setMesClassementsItems(this.mesClassementsItems);
      this.formConges.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formConges.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formConges.setMesConventionsItems(this.mesConventionsItems);
      this.formConges.setMesGrillesItems(this.mesGrillesItems);
      this.formConges.setMesServiceItems(this.mesServiceItems);
      this.formConges.accesResteintUser();
      this.formConges.accesResteintGroupe();
      this.formConges.initialisationAbs(var1);
      this.formConges.recupererAbs();
      this.recupererItemsSalarie(var1);
      this.formConges.setMesNatureAgentItems(this.mesNatureAgentsItems);
      this.formConges.setDocumentImpressionItems(this.documentImpressionItems);
      this.formConges.setListeImpressionItems(this.listeImpressionItems);
      this.formConges.setMesCiviliteItems(this.mesCiviliteItems);
      this.formConges.setLesCivilites(this.lesCivilites);
      this.formConges.setMesPaysItems(this.mesPaysItems);
      this.formConges.setMesNationnalitesItems(this.mesNationnalitesItems);
      this.formConges.setLesPays(this.lesPays);
      this.formConges.setMesLanguesItems(this.mesLanguesItems);
      this.formConges.setMesActiviteItems(this.mesActivitesItems);
      this.formConges.setMesClesItems(this.mesClesItems);
      this.formConges.setMesBudgetItems(this.mesBudgetsItems);
      this.formConges.setMesProjetItems(this.mesProjetsItems);
      this.formConges.setMesParcItems(this.mesParcsItems);
      this.formConges.setMesFeuillesItems(this.mesFeuillesItems);
      this.formConges.setFormRecherche(this.formRecherche);
   }

   public void menuContrats(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.formFicheSalarie = new FormFicheSalarie();
      this.formFicheSalarie.setutilInitHibernate(this.utilInitHibernate);
      this.formFicheSalarie.setBaseLog(this.baseLog);
      this.formFicheSalarie.setStructureLog(this.structureLog);
      this.formFicheSalarie.setUsersLog(this.usersLog);
      this.formFicheSalarie.InstancesDaoUtilses();
      this.formFicheSalarie.setNature(this.nature);
      this.formFicheSalarie.setExercicesPaye(this.exoselectionne);
      this.formFicheSalarie.setLastExoPaye(this.lastExoPaye);
      this.formFicheSalarie.setOptionPaye(this.optionPaye);
      this.formFicheSalarie.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFicheSalarie.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formFicheSalarie.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formFicheSalarie.setMesClassementsItems(this.mesClassementsItems);
      this.formFicheSalarie.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formFicheSalarie.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formFicheSalarie.setMesConventionsItems(this.mesConventionsItems);
      this.formFicheSalarie.setMesGrillesItems(this.mesGrillesItems);
      this.formFicheSalarie.setMesServiceItems(this.mesServiceItems);
      this.formFicheSalarie.setMesTiersItems(this.mesTiersItems);
      this.formFicheSalarie.accesResteintUser();
      this.formFicheSalarie.accesResteintGroupe();
      this.formFicheSalarie.initialisationContrat(var1);
      this.formFicheSalarie.recupererContrat();
      this.recupererItemsSalarie(var1);
      this.formFicheSalarie.setMesNatureAgentItems(this.mesNatureAgentsItems);
      this.formFicheSalarie.setDocumentImpressionItems(this.documentImpressionItems);
      this.formFicheSalarie.setListeImpressionItems(this.listeImpressionItems);
      this.formFicheSalarie.setMesCiviliteItems(this.mesCiviliteItems);
      this.formFicheSalarie.setLesCivilites(this.lesCivilites);
      this.formFicheSalarie.setMesPaysItems(this.mesPaysItems);
      this.formFicheSalarie.setMesNationnalitesItems(this.mesNationnalitesItems);
      this.formFicheSalarie.setLesPays(this.lesPays);
      this.formFicheSalarie.setMesLanguesItems(this.mesLanguesItems);
      this.formFicheSalarie.setMesActiviteItems(this.mesActivitesItems);
      this.formFicheSalarie.setMesLocalisationItems(this.mesLocalisationItems);
      this.formFicheSalarie.setMesClesItems(this.mesClesItems);
      this.formFicheSalarie.setMesBudgetItems(this.mesBudgetsItems);
      this.formFicheSalarie.setMesProjetItems(this.mesProjetsItems);
      this.formFicheSalarie.setMesParcItems(this.mesParcsItems);
      this.formFicheSalarie.setMesFeuillesItems(this.mesFeuillesItems);
      this.formFicheSalarie.setAccesInterim(this.accesInterim);
      this.formFicheSalarie.setFormRecherche(this.formRecherche);
      this.formFicheSalarie.setUrlExplorateur(this.urlExplorateur);
      this.formFicheSalarie.setDecoupageActivite(this.decoupageActivite);
      this.formFicheSalarie.setLaColonne1Items(this.laColonne1Items);
      this.formFicheSalarie.setLaColonne2Items(this.laColonne2Items);
      this.formFicheSalarie.setLaColonne3Items(this.laColonne3Items);
      this.formFicheSalarie.setFormBakingBeanPaye(this);
   }

   public void menuPointage(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.formPointage = new FormPointage();
      this.formPointage.setutilInitHibernate(this.utilInitHibernate);
      this.formPointage.setBaseLog(this.baseLog);
      this.formPointage.setStructureLog(this.structureLog);
      this.formPointage.setUsersLog(this.usersLog);
      this.formPointage.InstancesDaoUtilses();
      this.formPointage.setNature(this.nature);
      this.formPointage.setExercicesPaye(this.exoselectionne);
      this.formPointage.setLastExoPaye(this.lastExoPaye);
      this.formPointage.setOptionPaye(this.optionPaye);
      this.formPointage.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formPointage.setMesServiceItems(this.mesServiceItems);
      this.formPointage.accesResteintUser();
      this.formPointage.accesResteintGroupe();
      this.formPointage.initialisationPointage(var1);
      this.recupererItemsSalarie(var1);
      this.formPointage.setDocumentImpressionItems(this.documentImpressionItems);
      this.formPointage.setListeImpressionItems(this.listeImpressionItems);
      this.formPointage.setMesActiviteItems(this.mesActivitesItems);
      this.formPointage.setMesBudgetItems(this.mesBudgetsItems);
      this.formPointage.setMesProjetItems(this.mesProjetsItems);
      this.formPointage.setFormRecherche(this.formRecherche);
      this.formPointage.recupererLesAgentsItem(var1);
      this.formPointage.calculPeriode(var1);
   }

   public void menuTemps(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.formPointage = new FormPointage();
      this.formPointage.setutilInitHibernate(this.utilInitHibernate);
      this.formPointage.setBaseLog(this.baseLog);
      this.formPointage.setStructureLog(this.structureLog);
      this.formPointage.setUsersLog(this.usersLog);
      this.formPointage.InstancesDaoUtilses();
      this.formPointage.setNature(this.nature);
      this.formPointage.setExercicesPaye(this.exoselectionne);
      this.formPointage.setLastExoPaye(this.lastExoPaye);
      this.formPointage.setOptionPaye(this.optionPaye);
      this.formPointage.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formPointage.setMesServiceItems(this.mesServiceItems);
      this.formPointage.accesResteintUser();
      this.formPointage.accesResteintGroupe();
      this.formPointage.initialisationTemps(var1);
      this.recupererItemsSalarie(var1);
      this.formPointage.setDocumentImpressionItems(this.documentImpressionItems);
      this.formPointage.setListeImpressionItems(this.listeImpressionItems);
      this.formPointage.setMesActiviteItems(this.mesActivitesItems);
      this.formPointage.setMesBudgetItems(this.mesBudgetsItems);
      this.formPointage.setMesProjetItems(this.mesProjetsItems);
      this.formPointage.setFormRecherche(this.formRecherche);
      this.formPointage.recupererLesAgentsItem(var1);
      this.formPointage.calculPeriode(var1);
   }

   public void menuTache(Session var1) throws HibernateException, NamingException, IOException, JDOMException, ParseException {
      this.formFicheSalarie = new FormFicheSalarie();
      this.formFicheSalarie.setutilInitHibernate(this.utilInitHibernate);
      this.formFicheSalarie.setBaseLog(this.baseLog);
      this.formFicheSalarie.setStructureLog(this.structureLog);
      this.formFicheSalarie.setUsersLog(this.usersLog);
      this.formFicheSalarie.InstancesDaoUtilses();
      this.formFicheSalarie.setNature(this.nature);
      this.formFicheSalarie.setExercicesPaye(this.exoselectionne);
      this.formFicheSalarie.setLastExoPaye(this.lastExoPaye);
      this.formFicheSalarie.setOptionPaye(this.optionPaye);
      this.formFicheSalarie.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formFicheSalarie.setMesCentresImpotsItems(this.mesCentresImpotsItems);
      this.formFicheSalarie.setMesCentresSecuritesItems(this.mesCentresSecuritesItems);
      this.formFicheSalarie.setMesClassementsItems(this.mesClassementsItems);
      this.formFicheSalarie.setMesNiveauxEmploisItems(this.mesNiveauxEmploisItems);
      this.formFicheSalarie.setMesCodesEmploisItems(this.mesCodesEmploisItems);
      this.formFicheSalarie.setMesConventionsItems(this.mesConventionsItems);
      this.formFicheSalarie.setMesGrillesItems(this.mesGrillesItems);
      this.formFicheSalarie.setMesServiceItems(this.mesServiceItems);
      this.formFicheSalarie.setMesTiersItems(this.mesTiersItems);
      this.formFicheSalarie.accesResteintUser();
      this.formFicheSalarie.accesResteintGroupe();
      this.recupererItemsSalarie(var1);
      this.formFicheSalarie.setMesNatureAgentItems(this.mesNatureAgentsItems);
      this.formFicheSalarie.setDocumentImpressionItems(this.documentImpressionItems);
      this.formFicheSalarie.setListeImpressionItems(this.listeImpressionItems);
      this.formFicheSalarie.setMesCiviliteItems(this.mesCiviliteItems);
      this.formFicheSalarie.setLesCivilites(this.lesCivilites);
      this.formFicheSalarie.setMesPaysItems(this.mesPaysItems);
      this.formFicheSalarie.setMesNationnalitesItems(this.mesNationnalitesItems);
      this.formFicheSalarie.setLesPays(this.lesPays);
      this.formFicheSalarie.setMesLanguesItems(this.mesLanguesItems);
      this.formFicheSalarie.setMesActiviteItems(this.mesActivitesItems);
      this.formFicheSalarie.setMesLocalisationItems(this.mesLocalisationItems);
      this.formFicheSalarie.setMesClesItems(this.mesClesItems);
      this.formFicheSalarie.setMesBudgetItems(this.mesBudgetsItems);
      this.formFicheSalarie.setMesProjetItems(this.mesProjetsItems);
      this.formFicheSalarie.setMesParcItems(this.mesParcsItems);
      this.formFicheSalarie.setMesFeuillesItems(this.mesFeuillesItems);
      this.formFicheSalarie.setAccesContrats(this.accesContrats);
      this.formFicheSalarie.setAccesPrets(this.accesPrets);
      this.formFicheSalarie.setAccesConges(this.accesConges);
      this.formFicheSalarie.setAccesAbsences(this.accesAbsences);
      this.formFicheSalarie.setAccesMissions(this.accesMissions);
      this.formFicheSalarie.setAccesBulletins(this.accesBulletins);
      this.formFicheSalarie.setAccesInterim(this.accesInterim);
      this.formFicheSalarie.setUrlExplorateur(this.urlExplorateur);
      this.formFicheSalarie.setDecoupageActivite(this.decoupageActivite);
      this.formFicheSalarie.setLaColonne1Items(this.laColonne1Items);
      this.formFicheSalarie.setLaColonne2Items(this.laColonne2Items);
      this.formFicheSalarie.setLaColonne3Items(this.laColonne3Items);
      this.formFicheSalarie.intialisationTache(var1);
      if (this.optionPaye.getChargementListe() != null && !this.optionPaye.getChargementListe().isEmpty() && this.optionPaye.getChargementListe().equals("1") && this.mesNatureAgentsItems.size() != 0) {
         this.formFicheSalarie.setVar_nature_rec(((SelectItem)this.mesNatureAgentsItems.get(0)).getValue().toString());
         this.formFicheSalarie.rechercherSalarie(var1);
      }

      this.formFicheSalarie.setFormBakingBeanPaye(this);
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

   }

   public void menuImpressionPaye() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      this.formImpressionPaye = new FormImpressionPaye();
      this.formImpressionPaye.setUtilInitHibernate(this.utilInitHibernate);
      this.formImpressionPaye.setBaseLog(this.baseLog);
      this.formImpressionPaye.setStructureLog(this.structureLog);
      this.formImpressionPaye.setUsersLog(this.usersLog);
      this.formImpressionPaye.InstancesDaoUtilses();
      this.formImpressionPaye.setExoSelectionne(this.exoselectionne);
      this.formImpressionPaye.setOptionPaye(this.optionPaye);
      this.recupererLesItemsImpression(var1);
      this.formImpressionPaye.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionPaye.setMesNatureAgentItems(this.mesNatureAgentsItems);
      this.formImpressionPaye.chargerLesRepImpPaye(var1);
      this.formImpressionPaye.chargerPeriodes();
      this.formImpressionPaye.calculeAnalytique();
      this.formImpressionPaye.setMesFeuillesItems(this.mesFeuillesItems);
      this.formImpressionPaye.setMesPaysItems(this.mesPaysItems);
      this.formImpressionPaye.setMesNationnalitesItems(this.mesNationnalitesItems);
      this.formImpressionPaye.setMesLanguesItems(this.mesLanguesItems);
      this.formImpressionPaye.setMesClesItems(this.mesClesItems);
      this.formImpressionPaye.setMesNatureRubriqueItems(this.mesNatureRubriqueItems);
      this.formImpressionPaye.setMesBanqueItems(this.mesBanqueItems);
      this.formImpressionPaye.setMesBanqueAgentsItems(this.mesBanqueAgentsItems);
      this.formImpressionPaye.setMesLocalisationItems(this.mesLocalisationItems);
      this.formImpressionPaye.setDecoupageActivite(this.decoupageActivite);
      this.formImpressionPaye.setLaColonne1Items(this.laColonne1Items);
      this.formImpressionPaye.setLaColonne2Items(this.laColonne2Items);
      this.formImpressionPaye.setLaColonne3Items(this.laColonne3Items);
      this.formImpressionPaye.setUrlExplorateur(this.urlExplorateur);
      this.formImpressionPaye.initImpression();
      this.formImpressionPaye.recupererThesaurus();
      this.utilInitHibernate.closeSession();
   }

   public void menuImpressionTemps() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SalarieTache");
      this.formImpressionPaye = new FormImpressionPaye();
      this.formImpressionPaye.setUtilInitHibernate(this.utilInitHibernate);
      this.formImpressionPaye.setBaseLog(this.baseLog);
      this.formImpressionPaye.setStructureLog(this.structureLog);
      this.formImpressionPaye.setUsersLog(this.usersLog);
      this.formImpressionPaye.InstancesDaoUtilses();
      this.formImpressionPaye.setExoSelectionne(this.exoselectionne);
      this.formImpressionPaye.setOptionPaye(this.optionPaye);
      this.recupererNatureAgent(var1);
      this.formImpressionPaye.setLesModelesAutorises(this.lesModelesAutorises);
      this.formImpressionPaye.setMesNatureAgentItems(this.mesNatureAgentsItems);
      this.formImpressionPaye.chargerLesRepImpTemps(var1);
      this.formImpressionPaye.chargerElementsTemps(var1);
      this.formImpressionPaye.chargerPeriodes();
      this.formImpressionPaye.setUrlExplorateur(this.urlExplorateur);
      this.formImpressionPaye.initImpression();
      this.utilInitHibernate.closeSession();
   }

   public void menuBilanSocial() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BsoTabNom");
      this.formBilanSocial = new FormBilanSocial();
      this.formBilanSocial.setutilInitHibernate(this.utilInitHibernate);
      this.formBilanSocial.setBaseLog(this.baseLog);
      this.formBilanSocial.setStructureLog(this.structureLog);
      this.formBilanSocial.setUsersLog(this.usersLog);
      this.formBilanSocial.setSelectedExo(this.exoselectionne);
      this.formBilanSocial.setLastExo(this.lastExoPaye);
      this.formBilanSocial.setNature(this.nature);
      this.formBilanSocial.InstancesDaoUtilses();
      this.formBilanSocial.setOptionPaye(this.optionPaye);
      this.formBilanSocial.chargerMesTabNom(this.nature, var1);
      this.utilInitHibernate.closeSession();
   }

   public void menuDocuentsOfficiels() throws IOException, HibernateException, NamingException {
      this.formDocumentsOfficiels.ouvrirDocument();
   }

   public void menuTransfert(Session var1) throws IOException, JDOMException, HibernateException, NamingException {
      this.formTransfertBulletin = new FormTransfertBulletin();
      this.formTransfertBulletin.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertBulletin.setBaseLog(this.baseLog);
      this.formTransfertBulletin.setStructureLog(this.structureLog);
      this.formTransfertBulletin.setUsersLog(this.usersLog);
      this.formTransfertBulletin.InstancesDaoUtilses();
      this.formTransfertBulletin.setNature(this.nature);
      this.formTransfertBulletin.setExercicesPaye(this.exoselectionne);
      this.formTransfertBulletin.setLastExoPaye(this.lastExoPaye);
      this.formTransfertBulletin.setOptionPaye(this.optionPaye);
      this.formTransfertBulletin.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.recupererFeuilles(var1);
      this.formTransfertBulletin.setLesFeuilles(this.lesFeuillesCalculs);
      this.formTransfertBulletin.calculPeriodes(var1);
      this.formTransfertBulletin.initialisation(var1);
   }

   public void menuAnalyseCv(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.formCvAnalyse = new FormCvAnalyse();
      this.formCvAnalyse.setutilInitHibernate(this.utilInitHibernate);
      this.formCvAnalyse.setBaseLog(this.baseLog);
      this.formCvAnalyse.setStructureLog(this.structureLog);
      this.formCvAnalyse.setUsersLog(this.usersLog);
      this.formCvAnalyse.InstancesDaoUtilses();
      this.formCvAnalyse.setNature(this.nature);
      this.formCvAnalyse.setExercicesPaye(this.exoselectionne);
      this.formCvAnalyse.setLastExoPaye(this.lastExoPaye);
      this.formCvAnalyse.setOptionPaye(this.optionPaye);
      this.formCvAnalyse.setMesOnglets(this.lesOnglets.getMesOnglets());
      this.formCvAnalyse.accesResteintUser();
      this.formCvAnalyse.accesResteintGroupe();
      this.recupererItemsSalarie(var1);
      this.formCvAnalyse.setDocumentImpressionItems(this.documentImpressionItems);
      this.formCvAnalyse.setListeImpressionItems(this.listeImpressionItems);
      this.formCvAnalyse.setFormRecherche(this.formRecherche);
   }

   public void menuSelectionExercicesPaye() throws IOException, JDOMException, NamingException, ParseException {
      this.formExercicesPaye = new FormExercicesPaye();
      this.formExercicesPaye.setutilInitHibernate(this.utilInitHibernate);
      this.formExercicesPaye.setBaseLog(this.baseLog);
      this.formExercicesPaye.setStructureLog(this.structureLog);
      this.formExercicesPaye.setUsersLog(this.usersLog);
      this.formExercicesPaye.InstancesDaoUtilses();
      this.leIdExo = this.exoselectionne.getExepayId();
      this.formExercicesPaye.setLesexercicesPaye(this.formExercicesPaye.recupererLesexercices((Session)null));
   }

   public void importationEcritures() throws IOException, HibernateException, NamingException {
      this.formTransfertBulletin = new FormTransfertBulletin();
      this.formTransfertBulletin.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertBulletin.setBaseLog(this.baseLog);
      this.formTransfertBulletin.setStructureLog(this.structureLog);
      this.formTransfertBulletin.setUsersLog(this.usersLog);
      this.formTransfertBulletin.InstancesDaoUtilses();
      this.formTransfertBulletin.setNature(this.nature);
      this.formTransfertBulletin.setExercicesPaye(this.exoselectionne);
      this.formTransfertBulletin.setFormRecherche(this.formRecherche);
      this.formTransfertBulletin.initImportation();
      this.listFiles = new ArrayList();
      this.uploadsAvailable = 1;
   }

   public void mesContrats() throws IOException, HibernateException, NamingException {
      if (this.usersLog.getUsrIdSalarieGuest() != 0L) {
         this.formFicheSalarie = new FormFicheSalarie();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.formFicheSalarie.setutilInitHibernate(this.utilInitHibernate);
         this.formFicheSalarie.setBaseLog(this.baseLog);
         this.formFicheSalarie.setStructureLog(this.structureLog);
         this.formFicheSalarie.setUsersLog(this.usersLog);
         this.formFicheSalarie.InstancesDaoUtilses();
         this.formFicheSalarie.setNature(this.nature);
         this.formFicheSalarie.setExercicesPaye(this.exoselectionne);
         this.formFicheSalarie.setLastExoPaye(this.lastExoPaye);
         this.formFicheSalarie.setOptionPaye(this.optionPaye);
         this.formFicheSalarie.setMesOnglets(this.lesOnglets.getMesOnglets());
         this.formFicheSalarie.historiqueContrats(this.usersLog.getUsrIdSalarieGuest(), var1);
         this.utilInitHibernate.closeSession();
         this.affichePage = "/paye/MesContrats.jsp";
      }

   }

   public void mesBulletins() throws IOException, HibernateException, NamingException {
      if (this.usersLog.getUsrIdSalarieGuest() != 0L) {
         this.formCalculBulletin = new FormCalculBulletin();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.formCalculBulletin.setutilInitHibernate(this.utilInitHibernate);
         this.formCalculBulletin.setBaseLog(this.baseLog);
         this.formCalculBulletin.setStructureLog(this.structureLog);
         this.formCalculBulletin.setUsersLog(this.usersLog);
         this.formCalculBulletin.InstancesDaoUtilses();
         this.formCalculBulletin.setNature(this.nature);
         this.formCalculBulletin.setExercicesPaye(this.exoselectionne);
         this.formCalculBulletin.setLastExoPaye(this.lastExoPaye);
         this.formCalculBulletin.setOptionPaye(this.optionPaye);
         this.formCalculBulletin.setMesOnglets(this.lesOnglets.getMesOnglets());
         this.formCalculBulletin.setFormBakingBeanPaye(this);
         this.formCalculBulletin.historiqueBulletin(this.usersLog.getUsrIdSalarieGuest(), var1);
         this.utilInitHibernate.closeSession();
         this.affichePage = "/paye/MesBulletins.jsp";
      }

   }

   public void mesPretsInternes() throws IOException, HibernateException, NamingException {
      if (this.usersLog.getUsrIdSalarieGuest() != 0L) {
         this.formPrets = new FormPrets();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.formPrets.setutilInitHibernate(this.utilInitHibernate);
         this.formPrets.setBaseLog(this.baseLog);
         this.formPrets.setStructureLog(this.structureLog);
         this.formPrets.setUsersLog(this.usersLog);
         this.formPrets.InstancesDaoUtilses();
         this.formPrets.setNature(this.nature);
         this.formPrets.setExercicesPaye(this.exoselectionne);
         this.formPrets.setLastExoPaye(this.lastExoPaye);
         this.formPrets.setOptionPaye(this.optionPaye);
         this.formPrets.setMesOnglets(this.lesOnglets.getMesOnglets());
         this.formPrets.historiquePretInterne(this.usersLog.getUsrIdSalarieGuest(), var1);
         this.utilInitHibernate.closeSession();
         this.affichePage = "/paye/MesPretInterne.jsp";
      }

   }

   public void mesPretsExternes() throws IOException, HibernateException, NamingException {
      if (this.usersLog.getUsrIdSalarieGuest() != 0L) {
         this.formPrets = new FormPrets();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.formPrets.setutilInitHibernate(this.utilInitHibernate);
         this.formPrets.setBaseLog(this.baseLog);
         this.formPrets.setStructureLog(this.structureLog);
         this.formPrets.setUsersLog(this.usersLog);
         this.formPrets.InstancesDaoUtilses();
         this.formPrets.setNature(this.nature);
         this.formPrets.setExercicesPaye(this.exoselectionne);
         this.formPrets.setLastExoPaye(this.lastExoPaye);
         this.formPrets.setOptionPaye(this.optionPaye);
         this.formPrets.setMesOnglets(this.lesOnglets.getMesOnglets());
         this.formPrets.historiquePretExterne(this.usersLog.getUsrIdSalarieGuest(), var1);
         this.utilInitHibernate.closeSession();
         this.affichePage = "/paye/MesPretExterne.jsp";
      }

   }

   public void mesPretsManuels() throws IOException, HibernateException, NamingException {
      if (this.usersLog.getUsrIdSalarieGuest() != 0L) {
         this.formPrets = new FormPrets();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.formPrets.setutilInitHibernate(this.utilInitHibernate);
         this.formPrets.setBaseLog(this.baseLog);
         this.formPrets.setStructureLog(this.structureLog);
         this.formPrets.setUsersLog(this.usersLog);
         this.formPrets.InstancesDaoUtilses();
         this.formPrets.setNature(this.nature);
         this.formPrets.setExercicesPaye(this.exoselectionne);
         this.formPrets.setLastExoPaye(this.lastExoPaye);
         this.formPrets.setOptionPaye(this.optionPaye);
         this.formPrets.setMesOnglets(this.lesOnglets.getMesOnglets());
         this.formPrets.historiquePretManuel(this.usersLog.getUsrIdSalarieGuest(), var1);
         this.utilInitHibernate.closeSession();
         this.affichePage = "/paye/MesPretManuel.jsp";
      }

   }

   public void monEpargne() throws IOException, HibernateException, NamingException {
      if (this.usersLog.getUsrIdSalarieGuest() != 0L) {
         this.formPrets = new FormPrets();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.formPrets.setutilInitHibernate(this.utilInitHibernate);
         this.formPrets.setBaseLog(this.baseLog);
         this.formPrets.setStructureLog(this.structureLog);
         this.formPrets.setUsersLog(this.usersLog);
         this.formPrets.InstancesDaoUtilses();
         this.formPrets.setNature(this.nature);
         this.formPrets.setExercicesPaye(this.exoselectionne);
         this.formPrets.setLastExoPaye(this.lastExoPaye);
         this.formPrets.setOptionPaye(this.optionPaye);
         this.formPrets.setMesOnglets(this.lesOnglets.getMesOnglets());
         this.formPrets.historiqueEpargne(this.usersLog.getUsrIdSalarieGuest(), var1);
         this.utilInitHibernate.closeSession();
         this.affichePage = "/paye/MonEpargne.jsp";
      }

   }

   public void mesAbsences() throws IOException, HibernateException, NamingException {
      if (this.usersLog.getUsrIdSalarieGuest() != 0L) {
         this.formConges = new FormConges();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.formConges.setutilInitHibernate(this.utilInitHibernate);
         this.formConges.setBaseLog(this.baseLog);
         this.formConges.setStructureLog(this.structureLog);
         this.formConges.setUsersLog(this.usersLog);
         this.formConges.InstancesDaoUtilses();
         this.formConges.setNature(this.nature);
         this.formConges.setExercicesPaye(this.exoselectionne);
         this.formConges.setLastExoPaye(this.lastExoPaye);
         this.formConges.setOptionPaye(this.optionPaye);
         this.formConges.setMesOnglets(this.lesOnglets.getMesOnglets());
         this.formConges.historiqueAbsences(this.usersLog.getUsrIdSalarieGuest(), var1);
         this.utilInitHibernate.closeSession();
         this.affichePage = "/paye/MesAbsences.jsp";
      }

   }

   public void mesCongesPayes() throws IOException, HibernateException, NamingException {
      if (this.usersLog.getUsrIdSalarieGuest() != 0L) {
         this.formConges = new FormConges();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.formConges.setutilInitHibernate(this.utilInitHibernate);
         this.formConges.setBaseLog(this.baseLog);
         this.formConges.setStructureLog(this.structureLog);
         this.formConges.setUsersLog(this.usersLog);
         this.formConges.InstancesDaoUtilses();
         this.formConges.setNature(this.nature);
         this.formConges.setExercicesPaye(this.exoselectionne);
         this.formConges.setLastExoPaye(this.lastExoPaye);
         this.formConges.setOptionPaye(this.optionPaye);
         this.formConges.setMesOnglets(this.lesOnglets.getMesOnglets());
         this.formConges.historiqueCp(this.usersLog.getUsrIdSalarieGuest(), var1);
         this.utilInitHibernate.closeSession();
         this.affichePage = "/paye/MesCongesPayes.jsp";
      }

   }

   public void monPointage() throws IOException, HibernateException, NamingException, JDOMException {
      if (this.usersLog.getUsrIdSalarieGuest() != 0L) {
         this.formPointage = new FormPointage();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.formPointage.setutilInitHibernate(this.utilInitHibernate);
         this.formPointage.setBaseLog(this.baseLog);
         this.formPointage.setStructureLog(this.structureLog);
         this.formPointage.setUsersLog(this.usersLog);
         this.formPointage.InstancesDaoUtilses();
         this.formPointage.setNature(this.nature);
         this.formPointage.setExercicesPaye(this.exoselectionne);
         this.formPointage.setLastExoPaye(this.lastExoPaye);
         this.formPointage.setOptionPaye(this.optionPaye);
         this.formPointage.setMesOnglets(this.lesOnglets.getMesOnglets());
         this.formPointage.setMesServiceItems(this.mesServiceItems);
         this.formPointage.accesResteintUser();
         this.formPointage.accesResteintGroupe();
         this.formPointage.initialisationPointage(var1);
         this.recupererItemsSalarie(var1);
         this.formPointage.setDocumentImpressionItems(this.documentImpressionItems);
         this.formPointage.setListeImpressionItems(this.listeImpressionItems);
         this.formPointage.setMesActiviteItems(this.mesActivitesItems);
         this.formPointage.setMesBudgetItems(this.mesBudgetsItems);
         this.formPointage.setMesProjetItems(this.mesProjetsItems);
         this.formPointage.setFormRecherche(this.formRecherche);
         this.formPointage.pointageIndividuel(this.usersLog.getUsrIdSalarieGuest(), var1);
         this.formPointage.calculPeriode(var1);
         this.utilInitHibernate.closeSession();
         this.affichePage = "/paye/PointageInit.jsp";
      }

   }

   public void recupererTousLesItems(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererOptionPaye();
      this.recupererModelesAutorises();
      this.recupererCentresImpots(var1);
      this.recupererClassements();
      this.recupererNiveauxEmplois();
      this.recupererConventionsCollectives();
      this.recupererGrilles();
      this.recupererServices(var1);
      this.recupererLesSiteItem(var1);
      this.recupererProjetItem(var1);
   }

   public void recupererLesItemsImpression(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererLesSiteItem(var1);
      this.recupererNatureAgent(var1);
      this.recupererPays();
      this.recupererLangue();
      this.recupererActiviteItem(var1);
      this.recupererLocalisationItem(var1);
      this.recupererClesItems(var1);
      this.recupererBudgetItem(var1);
      this.recupererParcItem(var1);
      this.recupererFeuilles(var1);
      this.recupererRubriques(var1);
      this.recupererNatureRubrique(var1);
      this.recupererBanques(var1);
   }

   public void recupererItemsSalarie(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.recupererNatureAgent(var1);
      this.recupererModeleDocument();
      this.recupererModeleListe();
      this.recupererCivilite();
      this.recupererPays();
      this.recupererLangue();
      this.recupererActiviteItem(var1);
      this.recupererLocalisationItem(var1);
      this.recupererClesItems(var1);
      this.recupererBudgetItem(var1);
      this.recupererParcItem(var1);
      this.recupererFeuilles(var1);
      this.recupererCentresImpots(var1);
      this.recupererConventionsCollectives();
      this.recupererClassements();
      this.recupererNiveauxEmplois();
      this.recupererConfigListeEntete();
      this.recupererConfigListeLigne();
   }

   public void recupererOptionPaye() throws IOException {
      this.optionPaye = new OptionPaye();
      LireLesoptionsPaye var1 = new LireLesoptionsPaye();
      var1.setStrId(this.structureLog.getStrid());
      this.optionPaye = var1.lancer();
   }

   public void recupererModelesAutorises() {
      this.lesModelesAutorises = new ArrayList();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + this.usersLog.getGroupe().getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.lesModelesAutorises = this.lectureModeleAutorise.getLesModelesAutorises();
      }

   }

   public boolean recupererOptionsParc() throws HibernateException, NamingException {
      boolean var1 = this.rechercheModule(70000);
      return var1;
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

   public void recupererCentresImpots(Session var1) throws IOException, HibernateException, NamingException {
      this.mesCentresImpotsItems = new ArrayList();
      LectureCentresImpots var2 = new LectureCentresImpots();
      var2.setStructureLog(this.structureLog);
      var2.recuperePaye();
      this.mesCentresImpotsItems = var2.getMesCentresImpotsItems();
      this.mesCentresSecuritesItems = new ArrayList();
      LectureCentresSecuriteSociale var3 = new LectureCentresSecuriteSociale();
      var3.setStructureLog(this.structureLog);
      var3.recuperePaye();
      if (this.structureLog.getStrNumSecuMultiple() == 1) {
         new ArrayList();
         List var4 = var3.getMesCentresImpots();
         new ArrayList();
         CentreImpotDao var6 = new CentreImpotDao(this.baseLog, this.utilInitHibernate);
         List var5 = var6.chargerCentreSecuriteSociale(var1);
         if (var5.size() != 0 && var4.size() != 0) {
            new CentreImpot();
            new ObjetCompte();

            for(int var9 = 0; var9 < var5.size(); ++var9) {
               CentreImpot var7 = (CentreImpot)var5.get(var9);

               for(int var10 = 0; var10 < var4.size(); ++var10) {
                  ObjetCompte var8 = (ObjetCompte)var4.get(var10);
                  if (var8.getCode() != null && !var8.getCode().isEmpty() && var7.getCenimpCode().equals(var8.getCode())) {
                     var8.setCentreId(var7.getCenimpId());
                     var8.setCentreAdresse(var7.getCenimpAdresse());
                     var8.setCentreBP(var7.getCenimpBP());
                     var8.setCentreFax(var7.getCenimpFax());
                     var8.setCentreMail(var7.getCenimpMail());
                     var8.setCentreNomResponsable(var7.getCenimpNomResponsable());
                     var8.setCentreNumeroImmatriculation(var7.getCenimpNumeroImmatriculation());
                     var8.setCentreTel1(var7.getCenimpTel1());
                     var8.setCentreTel2(var7.getCenimpTel2());
                     this.mesCentresSecuritesItems.add(new SelectItem(var7.getCenimpNumeroImmatriculation(), var7.getCenimpNom() + ":" + var7.getCenimpNumeroImmatriculation()));
                     break;
                  }
               }
            }
         }
      } else {
         this.mesCentresSecuritesItems = var2.getMesCentresImpotsItems();
      }

   }

   public void recupererClassements() throws IOException {
      this.mesClassementsItems = new ArrayList();
      LectureClassementsAgents var1 = new LectureClassementsAgents();
      var1.setStructureLog(this.structureLog);
      var1.recuperePaye();
      this.mesClassementsItems = var1.getMesClassementsItems();
   }

   public void recupererNiveauxEmplois() throws IOException {
      this.mesNiveauxEmploisItems = new ArrayList();
      LectureNiveauxEmplois var1 = new LectureNiveauxEmplois();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.recuperePaye();
      this.mesNiveauxEmploisItems = var1.getMesNiveauxEmploisItems();
      LectureCodesEmplois var2 = new LectureCodesEmplois();
      var2.setStrId(this.structureLog.getStrid());
      var2.setStructureLog(this.structureLog);
      var2.recuperePaye();
      this.mesCodesEmploisItems = var2.getMesCodesEmploisItems();
   }

   public void recupererConventionsCollectives() throws IOException {
      this.mesConventionsItems = new ArrayList();
      LectureConventions var1 = new LectureConventions();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.recuperePaye();
      this.mesConventionsItems = var1.getMesConventionsItems();
   }

   public void recupererGrilles() throws IOException {
      this.mesGrillesItems = new ArrayList();
   }

   public void recupererServices(Session var1) throws HibernateException, NamingException {
      this.mesServiceItems = new ArrayList();
      if (this.typeVente != 804) {
         ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
         this.mesServiceItems = var2.chargerLesServicesItems(1, false, var1);
      }

   }

   public void recupererNatureAgent(Session var1) throws IOException, HibernateException, NamingException {
      this.mesNatureAgentsItems = new ArrayList();
      this.mesNatureConsultantItems = new ArrayList();
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      List var2 = this.usersChronoDao.selectListByUserNat(this.usersLog, 81, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            String[] var4 = ((UsersChrono)var2.get(var3)).getUsrchrSerie().split(":");
            this.mesNatureAgentsItems.add(new SelectItem(var4[0], ((UsersChrono)var2.get(var3)).getUsrchrSerie()));
            if (var4[0].equals("15")) {
               this.mesNatureConsultantItems.add(new SelectItem(var4[0], ((UsersChrono)var2.get(var3)).getUsrchrSerie()));
            }
         }
      }

   }

   public void recupererLesSiteItem(Session var1) throws HibernateException, NamingException {
      this.mesSitesItems = new ArrayList();
      SiteDao var2 = new SiteDao(this.baseLog, this.utilInitHibernate);
      this.mesSitesItems = var2.chargerLesSitesItems(var1);
   }

   public void recupererRubriques(Session var1) throws HibernateException, NamingException {
      this.mesRubriquesItems = new ArrayList();
      PlanPayeDao var2 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
      this.mesRubriquesItems = var2.chargerPlanPayeItems(this.leIdExo, var1);
   }

   public void recupererNatureRubrique(Session var1) throws HibernateException, NamingException {
      this.mesNatureRubriqueItems = new ArrayList();
      this.mesNatureRubriqueItems.add(new SelectItem(10, "10:Elements de base"));
      this.mesNatureRubriqueItems.add(new SelectItem(11, "11:Heures Supplémentaires"));
      this.mesNatureRubriqueItems.add(new SelectItem(20, "20:Primes imposables"));
      this.mesNatureRubriqueItems.add(new SelectItem(30, "30:Retenues imposables"));
      this.mesNatureRubriqueItems.add(new SelectItem(40, "40:Congés payés"));
      this.mesNatureRubriqueItems.add(new SelectItem(41, "41:Licenciements"));
      this.mesNatureRubriqueItems.add(new SelectItem(42, "42:Primes fin d'année"));
      this.mesNatureRubriqueItems.add(new SelectItem(50, "50:Avantages en nature"));
      this.mesNatureRubriqueItems.add(new SelectItem(59, "59:Total brut"));
      this.mesNatureRubriqueItems.add(new SelectItem(60, "60:Impôts charges sociales"));
      this.mesNatureRubriqueItems.add(new SelectItem(61, "61:Impôts charges fiscales"));
      this.mesNatureRubriqueItems.add(new SelectItem(62, "62:Impôts autres charges"));
      this.mesNatureRubriqueItems.add(new SelectItem(69, "69:Total brut après impôt"));
      this.mesNatureRubriqueItems.add(new SelectItem(70, "70:Indemnités non imposables"));
      this.mesNatureRubriqueItems.add(new SelectItem(80, "80:Retenues non imposables"));
      this.mesNatureRubriqueItems.add(new SelectItem(88, "88:Apponints du mois"));
      this.mesNatureRubriqueItems.add(new SelectItem(89, "89:Total net à payer"));
      this.mesNatureRubriqueItems.add(new SelectItem(90, "90:Charges patronales"));
   }

   public void recupererBanques(Session var1) throws HibernateException, NamingException {
      this.mesBanqueItems = new ArrayList();
      ContactDao var2 = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.mesBanqueItems = var2.chargerLesContactsBqItems(var1);
      this.mesBanqueAgentsItems = new ArrayList();
      SalariesElementsDao var3 = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var4 = var3.chargerlesElementsByBanque(var1);
      LectureBanque var5 = new LectureBanque();
      var5.setStrId(this.structureLog.getStrid());
      var5.setStructureLog(this.structureLog);
      var5.recupereBanque();
      List var6 = var5.getLesBanques();
      if (var6.size() != 0 && var4.size() != 0) {
         for(int var7 = 0; var7 < var4.size(); ++var7) {
            String var8 = ((String)var4.get(var7)).toUpperCase();
            String var9 = "???";

            for(int var10 = 0; var10 < var6.size(); ++var10) {
               if (((ObjetBanque)var6.get(var10)).getCode().equalsIgnoreCase(var8)) {
                  var9 = ((ObjetBanque)var6.get(var10)).getLibelle();
                  break;
               }
            }

            this.mesBanqueAgentsItems.add(new SelectItem(var8 + ":" + var9));
         }
      }

   }

   public void recupererModeleDocument() {
      String var1 = "";
      if (this.nature == 81) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator;
      } else if (this.nature == 82) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "contrat" + File.separator;
      } else if (this.nature == 87) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "pret" + File.separator;
      } else if (this.nature == 91) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "mission" + File.separator;
      } else if (this.nature == 92) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "pointage" + File.separator;
      } else if (this.nature == 94) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "temps" + File.separator;
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
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.documentImpressionItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public void recupererModeleListe() {
      String var1 = "";
      if (this.nature == 81) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator;
      } else if (this.nature == 82) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "contrat" + File.separator;
      } else if (this.nature == 87) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "pret" + File.separator;
      } else if (this.nature == 91) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "mission" + File.separator;
      } else if (this.nature == 92) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "pointage" + File.separator;
      } else if (this.nature == 94) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "temps" + File.separator;
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
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.listeImpressionItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public void recupererBulletinModele(FeuilleCalcul var1) {
      String var2 = "";
      var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "bulletin" + File.separator;
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      this.bulletinImpressionItems = new ArrayList();
      String[] var4 = var3.list();
      if (var4 != null) {
         if (var1 != null && var1.getFeuModele() != null && !var1.getFeuModele().isEmpty()) {
            if (var1.getFeuModele() != null && !var1.getFeuModele().isEmpty()) {
               this.bulletinImpressionItems.add(new SelectItem(var1.getFeuModele()));
            }

            if (var1.getFeuModeleMat() != null && !var1.getFeuModeleMat().isEmpty()) {
               this.bulletinImpressionItems.add(new SelectItem(var1.getFeuModeleMat()));
            }
         } else {
            var4 = this.triAlphabetique(var4, var4.length);

            for(int var5 = 0; var5 < var4.length; ++var5) {
               if (var4[var5].endsWith("jasper")) {
                  String var6 = var4[var5];
                  if (this.verificationAutorisation(var6)) {
                     String var7 = var4[var5].substring(0, var4[var5].indexOf("."));
                     this.bulletinImpressionItems.add(new SelectItem(var7));
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

   public void recupererCivilite() throws IOException {
      this.mesCiviliteItems = new ArrayList();
      this.lesCivilites = new ArrayList();
      LectureCivilites var1 = new LectureCivilites(0);
      this.mesCiviliteItems = var1.getMesCivilitesItems();
      this.lesCivilites = var1.getMesCivilites();
   }

   public void recupererPays() throws IOException {
      this.mesPaysItems = new ArrayList();
      this.mesNationnalitesItems = new ArrayList();
      this.lesPays = new ArrayList();
      LecturePays var1 = new LecturePays();
      this.mesPaysItems = var1.getMesPaysItems();
      this.mesNationnalitesItems = var1.getMesNationnalitesItems();
      this.lesPays = var1.getMespays();
   }

   public void recupererLangue() throws IOException {
      this.mesLanguesItems = new ArrayList();
      LectureLangues var1 = new LectureLangues();
      this.mesLanguesItems = var1.getMesLanguesItems();
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

         int var3;
         if (this.laColonne1Items.size() != 0) {
            for(var3 = 0; var3 < this.laColonne1Items.size(); ++var3) {
               this.mesActivitesItems.add(this.laColonne1Items.get(var3));
            }
         }

         if (this.laColonne2Items.size() != 0) {
            for(var3 = 0; var3 < this.laColonne2Items.size(); ++var3) {
               this.mesActivitesItems.add(this.laColonne2Items.get(var3));
            }
         }

         if (this.laColonne3Items.size() != 0) {
            for(var3 = 0; var3 < this.laColonne3Items.size(); ++var3) {
               this.mesActivitesItems.add(this.laColonne3Items.get(var3));
            }
         }
      } else {
         this.mesActivitesItems = var2.chargerLesActivites(var1);
      }

   }

   public void recupererLocalisationItem(Session var1) throws HibernateException, NamingException {
      this.mesLocalisationItems = new ArrayList();
      LocalisationSalarieDao var2 = new LocalisationSalarieDao(this.baseLog, this.utilInitHibernate);
      this.mesLocalisationItems = var2.chargerLesLocalisationSalarie(var1);
   }

   public void recupererClesItems(Session var1) throws HibernateException, NamingException {
      this.mesClesItems = new ArrayList();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.mesClesItems = var2.chargerLesAnalytiques("9", var1);
   }

   public void recupererBudgetItem(Session var1) throws HibernateException, NamingException {
      this.mesBudgetsItems = new ArrayList();
      BudgetDao var2 = new BudgetDao(this.baseLog, this.utilInitHibernate);
      this.mesBudgetsItems = var2.selectAllBudget(this.exoselectionne.getExepayId(), var1);
   }

   public void recupererProjetItem(Session var1) throws HibernateException, NamingException {
      this.mesProjetsItems = new ArrayList();
      ProjetsDao var2 = new ProjetsDao(this.baseLog, this.utilInitHibernate);
      this.mesProjetsItems = var2.chargerLesProjets(0, var1);
   }

   public void recupererParcItem(Session var1) throws HibernateException, NamingException {
      this.mesParcsItems = new ArrayList();
      ParcDao var2 = new ParcDao(this.baseLog, this.utilInitHibernate);
      this.mesParcsItems = var2.chargerLesParcsVoituresCamions(var1);
   }

   public void recupererFeuilles(Session var1) throws HibernateException, NamingException {
      this.mesFeuillesItems = new ArrayList();
      this.lesFeuillesCalculs = new ArrayList();
      new FeuilleCalcul();
      FeuilleCalculDao var3 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
      this.lesFeuillesCalculs = var3.chargerFeuillesUser(this.optionPaye.getTriModeTravail(), this.exoselectionne.getExepayId(), this.usersLog.getUsrFeuilleInterdite(), var1);
      if (this.lesFeuillesCalculs.size() != 0) {
         for(int var4 = 0; var4 < this.lesFeuillesCalculs.size(); ++var4) {
            this.mesFeuillesItems.add(new SelectItem(((FeuilleCalcul)this.lesFeuillesCalculs.get(var4)).getFeuCode(), ((FeuilleCalcul)this.lesFeuillesCalculs.get(var4)).getFeuCode() + ":" + ((FeuilleCalcul)this.lesFeuillesCalculs.get(var4)).getFeuLibelleFr()));
         }
      }

      if (!this.optionPaye.getModeTravail().equals("0")) {
         FeuilleCalcul var2;
         SalariesContratsDao var5;
         int var6;
         List var7;
         if (this.optionPaye.getModeTravail().equals("1")) {
            this.lesFeuillesCalculs = new ArrayList();
            new ArrayList();
            var5 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
            var7 = var5.chargerlesContratsByActivites(this.optionPaye.getTriModeTravail(), var1);
            if (var7.size() != 0) {
               for(var6 = 0; var6 < var7.size(); ++var6) {
                  var2 = new FeuilleCalcul();
                  if (((SalariesContrats)var7.get(var6)).getSalconActivite() != null && !((SalariesContrats)var7.get(var6)).getSalconActivite().isEmpty()) {
                     var2.setFeuCode(((SalariesContrats)var7.get(var6)).getSalconActivite());
                     var2.setFeuLibelleFr(((SalariesContrats)var7.get(var6)).getSalconLibActivite());
                  } else {
                     var2.setFeuCode("");
                     var2.setFeuLibelleFr("SANS ACTIVITE");
                  }

                  var2.setFeuilleOrigine(1);
                  this.lesFeuillesCalculs.add(var2);
               }
            }
         } else if (this.optionPaye.getModeTravail().equals("2")) {
            this.lesFeuillesCalculs = new ArrayList();
            new ArrayList();
            var5 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
            var7 = var5.chargerlesContratsByServices(this.optionPaye.getTriModeTravail(), var1);
            if (var7.size() != 0) {
               for(var6 = 0; var6 < var7.size(); ++var6) {
                  var2 = new FeuilleCalcul();
                  if (((SalariesContrats)var7.get(var6)).getSalconService() != null && !((SalariesContrats)var7.get(var6)).getSalconService().isEmpty()) {
                     var2.setFeuCode(((SalariesContrats)var7.get(var6)).getSalconService());
                     var2.setFeuLibelleFr(((SalariesContrats)var7.get(var6)).getSalconLibService());
                  } else {
                     var2.setFeuCode("");
                     var2.setFeuLibelleFr("SANS SERVICE");
                  }

                  var2.setFeuilleOrigine(2);
                  this.lesFeuillesCalculs.add(var2);
               }
            }
         } else if (this.optionPaye.getModeTravail().equals("3")) {
            this.lesFeuillesCalculs = new ArrayList();
            new ArrayList();
            var5 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
            var7 = var5.chargerlesContratsByProjets(this.optionPaye.getTriModeTravail(), var1);
            if (var7.size() != 0) {
               for(var6 = 0; var6 < var7.size(); ++var6) {
                  var2 = new FeuilleCalcul();
                  if (((SalariesContrats)var7.get(var6)).getSalconProjet() != null && !((SalariesContrats)var7.get(var6)).getSalconProjet().isEmpty()) {
                     var2.setFeuCode(((SalariesContrats)var7.get(var6)).getSalconProjet());
                     var2.setFeuLibelleFr(((SalariesContrats)var7.get(var6)).getSalconLibProjet());
                  } else {
                     var2.setFeuCode("");
                     var2.setFeuLibelleFr("SANS PROJET");
                  }

                  var2.setFeuilleOrigine(3);
                  this.lesFeuillesCalculs.add(var2);
               }
            }
         } else if (this.optionPaye.getModeTravail().equals("4")) {
            this.lesFeuillesCalculs = new ArrayList();
            new ArrayList();
            TiersDao var8 = new TiersDao(this.baseLog, this.utilInitHibernate);
            var7 = var8.chargerLesTiersPaye(this.optionPaye.getTriModeTravail(), "3", var1);
            if (var7.size() != 0) {
               for(var6 = 0; var6 < var7.size(); ++var6) {
                  var2 = new FeuilleCalcul();
                  if (((Tiers)var7.get(var6)).getTieraisonsocialenom() != null && !((Tiers)var7.get(var6)).getTieraisonsocialenom().isEmpty() && ((Tiers)var7.get(var6)).getTiemodecom() != 0) {
                     var2.setFeuCode("" + ((Tiers)var7.get(var6)).getTieid());
                     var2.setFeuLibelleFr(((Tiers)var7.get(var6)).getTieraisonsocialenom());
                     var2.setFeuilleOrigine(4);
                     this.lesFeuillesCalculs.add(var2);
                  }
               }
            }
         }
      }

   }

   public int calculNbEnfants(Salaries var1, List var2) {
      int var3 = 0;
      if (this.optionPaye.getNbEnfantsFiscaux().equals("0")) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            if (((SalariesGrh)var2.get(var4)).getSalgrhType() == 15 && ((SalariesGrh)var2.get(var4)).getSalgrhFiscal() == 0) {
               ++var3;
            }
         }
      } else {
         var3 = var1.getSalNbEnfant();
      }

      return var3;
   }

   public float calculNbPartsFiscales(Salaries var1, List var2) {
      int var3 = 0;
      if (this.optionPaye.getNbEnfantsFiscaux().equals("0")) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            if (((SalariesGrh)var2.get(var4)).getSalgrhType() == 15 && ((SalariesGrh)var2.get(var4)).getSalgrhFiscal() == 0) {
               ++var3;
            }
         }
      } else {
         var3 = var1.getSalNbEnfant();
      }

      float var6 = 0.0F;
      if (!this.structureLog.getStrcodepays().equals("0041")) {
         if (this.structureLog.getStrcodepays().equals("0050")) {
            if ((var1.getSalSitFamille() == 0 || var1.getSalSitFamille() == 4 || var1.getSalSitFamille() == 5) && var3 == 0) {
               var6 = 1.0F;
            } else if (var1.getSalSitFamille() >= 1 && var1.getSalSitFamille() <= 4 && var3 == 0) {
               var6 = 2.0F;
            } else if ((var1.getSalSitFamille() == 0 || var1.getSalSitFamille() == 4) && var3 != 0) {
               var6 = 1.5F + 0.5F * (float)var3;
            } else if ((var1.getSalSitFamille() >= 1 && var1.getSalSitFamille() <= 4 || var1.getSalSitFamille() == 5) && var3 != 0) {
               var6 = 2.0F + 0.5F * (float)var3;
            }

            if ((double)var6 >= 7.0D) {
               var6 = 6.5F;
            }
         } else if (this.structureLog.getStrcodepays().equals("0056")) {
            if (var3 == 0) {
               if (var1.getSalSitFamille() >= 1 && var1.getSalSitFamille() <= 4) {
                  var6 = 2.0F;
               } else {
                  var6 = 1.0F;
               }
            } else if ((var1.getSalSitFamille() < 1 || var1.getSalSitFamille() > 4) && var1.getSalSitFamille() != 5) {
               var6 = 1.5F + 0.5F * (float)var3;
            } else {
               var6 = 2.0F + 0.5F * (float)var3;
            }

            if ((double)var6 >= 5.5D) {
               var6 = 5.0F;
            }
         } else if (this.structureLog.getStrcodepays().equals("0077")) {
            if (var1.getSalSitFamille() != 1 && var1.getSalSitFamille() != 3 && var1.getSalSitFamille() != 4) {
               if (var3 == 0) {
                  var6 = 1.0F;
               } else {
                  var6 = 1.5F + 0.5F * (float)var3;
               }
            } else if (var1.getSalGenre() == 0) {
               if (var3 == 0) {
                  var6 = 1.0F;
               } else {
                  var6 = 1.5F + 0.5F * (float)var3;
               }
            } else {
               var6 = 2.0F + 0.5F * (float)var3;
            }

            if ((double)var6 >= 5.5D) {
               var6 = 5.0F;
            }
         } else if (this.structureLog.getStrcodepays().equals("0088")) {
            if (var3 == 0) {
               if (var1.getSalSitFamille() >= 1 && var1.getSalSitFamille() <= 4) {
                  var6 = 1.5F;
               } else {
                  var6 = 1.0F;
               }
            } else if ((var1.getSalSitFamille() < 1 || var1.getSalSitFamille() > 4) && var1.getSalSitFamille() != 5) {
               var6 = 1.0F + 0.5F * (float)var3;
            } else {
               var6 = 1.5F + 0.5F * (float)var3;
            }

            if ((double)var6 >= 5.5D) {
               var6 = 5.0F;
            }
         } else if (!this.structureLog.getStrcodepays().equals("0089") && !this.structureLog.getStrcodepays().equals("0090") && !this.structureLog.getStrcodepays().equals("0138") && this.structureLog.getStrcodepays().equals("0202")) {
            if (var3 == 0) {
               if (var1.getSalSitFamille() >= 1 && var1.getSalSitFamille() <= 4) {
                  var6 = 1.5F;
               } else {
                  var6 = 1.0F;
               }
            } else if ((var1.getSalSitFamille() < 1 || var1.getSalSitFamille() > 4) && var1.getSalSitFamille() != 5) {
               var6 = 1.0F + 0.5F * (float)var3;
            } else {
               var6 = 1.5F + 0.5F * (float)var3;
            }

            if (var2.size() != 0) {
               for(int var5 = 0; var5 < var2.size(); ++var5) {
                  if (((SalariesGrh)var2.get(var5)).getSalgrhType() == 16 && ((SalariesGrh)var2.get(var5)).getSalgrhTravail() == 1) {
                     var6 += 0.5F;
                     break;
                  }
               }
            }

            if ((double)var6 >= 5.5D) {
               var6 = 5.0F;
            }
         }
      }

      if (var6 == 0.0F) {
         var6 = 1.0F;
      }

      return var6;
   }

   public float calculNbPartsFiscales(SalariesElements var1, List var2) {
      int var3 = 0;
      if (this.optionPaye.getNbEnfantsFiscaux().equals("0")) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            if (((SalariesGrh)var2.get(var4)).getSalgrhType() == 15 && ((SalariesGrh)var2.get(var4)).getSalgrhFiscal() == 0) {
               ++var3;
            }
         }
      } else {
         var3 = var1.getSaleleNbEnfant();
      }

      float var6 = 0.0F;
      if (!this.structureLog.getStrcodepays().equals("0041")) {
         if (this.structureLog.getStrcodepays().equals("0050")) {
            if ((var1.getSaleleSitFamille() == 0 || var1.getSaleleSitFamille() == 4 || var1.getSaleleSitFamille() == 5) && var3 == 0) {
               var6 = 1.0F;
            } else if (var1.getSaleleSitFamille() >= 1 && var1.getSaleleSitFamille() <= 4 && var3 == 0) {
               var6 = 2.0F;
            } else if ((var1.getSaleleSitFamille() == 0 || var1.getSaleleSitFamille() == 4) && var3 != 0) {
               var6 = 1.5F + 0.5F * (float)var3;
            } else if ((var1.getSaleleSitFamille() >= 1 && var1.getSaleleSitFamille() <= 4 || var1.getSaleleSitFamille() == 5) && var3 != 0) {
               var6 = 2.0F + 0.5F * (float)var3;
            }

            if ((double)var6 >= 7.0D) {
               var6 = 6.5F;
            }
         } else if (this.structureLog.getStrcodepays().equals("0056")) {
            if (var3 == 0) {
               if (var1.getSaleleSitFamille() >= 1 && var1.getSaleleSitFamille() <= 4) {
                  var6 = 2.0F;
               } else {
                  var6 = 1.0F;
               }
            } else if ((var1.getSaleleSitFamille() < 1 || var1.getSaleleSitFamille() > 4) && var1.getSaleleSitFamille() != 5) {
               var6 = 1.5F + 0.5F * (float)var3;
            } else {
               var6 = 2.0F + 0.5F * (float)var3;
            }

            if ((double)var6 >= 5.5D) {
               var6 = 5.0F;
            }
         } else if (this.structureLog.getStrcodepays().equals("0077")) {
            if (var1.getSaleleSitFamille() != 1 && var1.getSaleleSitFamille() != 3 && var1.getSaleleSitFamille() != 4) {
               if (var3 == 0) {
                  var6 = 1.0F;
               } else {
                  var6 = 1.5F + 0.5F * (float)var3;
               }
            } else if (var1.getSaleleSitFamille() == 0) {
               if (var3 == 0) {
                  var6 = 1.0F;
               } else {
                  var6 = 1.5F + 0.5F * (float)var3;
               }
            } else {
               var6 = 2.0F + 0.5F * (float)var3;
            }

            if ((double)var6 >= 5.5D) {
               var6 = 5.0F;
            }
         } else if (this.structureLog.getStrcodepays().equals("0088")) {
            if (var3 == 0) {
               if (var1.getSaleleSitFamille() >= 1 && var1.getSaleleSitFamille() <= 4) {
                  var6 = 1.5F;
               } else {
                  var6 = 1.0F;
               }
            } else if ((var1.getSaleleSitFamille() < 1 || var1.getSaleleSitFamille() > 4) && var1.getSaleleSitFamille() != 5) {
               var6 = 1.0F + 0.5F * (float)var3;
            } else {
               var6 = 1.5F + 0.5F * (float)var3;
            }

            if ((double)var6 >= 5.5D) {
               var6 = 5.0F;
            }
         } else if (!this.structureLog.getStrcodepays().equals("0138") && this.structureLog.getStrcodepays().equals("0202")) {
            if (var3 == 0) {
               if (var1.getSaleleSitFamille() >= 1 && var1.getSaleleSitFamille() <= 4) {
                  var6 = 1.5F;
               } else {
                  var6 = 1.0F;
               }
            } else if ((var1.getSaleleSitFamille() < 1 || var1.getSaleleSitFamille() > 4) && var1.getSaleleSitFamille() != 5) {
               var6 = 1.0F + 0.5F * (float)var3;
            } else {
               var6 = 1.5F + 0.5F * (float)var3;
            }

            if (var2.size() != 0) {
               for(int var5 = 0; var5 < var2.size(); ++var5) {
                  if (((SalariesGrh)var2.get(var5)).getSalgrhType() == 16 && ((SalariesGrh)var2.get(var5)).getSalgrhTravail() == 1) {
                     var6 += 0.5F;
                     break;
                  }
               }
            }

            if ((double)var6 >= 5.5D) {
               var6 = 5.0F;
            }
         }
      }

      if (var6 == 0.0F) {
         var6 = 1.0F;
      }

      return var6;
   }

   public int calculNbFemme(Salaries var1, List var2) {
      int var3 = 0;
      if (var1.getSalGenre() == 1 && var1.getSalSitFamille() >= 1 && var1.getSalSitFamille() <= 4) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            if (((SalariesGrh)var2.get(var4)).getSalgrhType() == 16) {
               ++var3;
            }
         }
      }

      return var3;
   }

   public float calculNbtrimf(Salaries var1, List var2) {
      float var3 = 1.0F;
      if (var1.getSalSitFamille() >= 1 && var1.getSalSitFamille() <= 4) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            if (((SalariesGrh)var2.get(var4)).getSalgrhType() == 16 && ((SalariesGrh)var2.get(var4)).getSalgrhTravail() == 1) {
               ++var3;
            }
         }
      }

      return var3;
   }

   public void listener(UploadEvent var1) throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
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

   public void importationFichier() throws NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      try {
         ArrayList var1 = new ArrayList();
         if (this.listFiles.size() != 0) {
            for(int var2 = 0; var2 < this.listFiles.size(); ++var2) {
               this.fileCtrl = (FileCtrl)this.listFiles.get(var2);
               String var3 = ((FileCtrl)this.listFiles.get(var2)).getName();
               File var4 = new File(this.fileCtrl.getChemin());
               if (var4.exists()) {
                  FileReader var5 = new FileReader(var4);
                  BufferedReader var6 = new BufferedReader(var5);
                  boolean var7 = false;
                  if (!var3.toString().endsWith("xls") && !var3.toString().endsWith("xlsx") && !var3.toString().endsWith("XLS") && !var3.toString().endsWith("XLSX")) {
                     for(String var8 = var6.readLine(); var8 != null; var8 = var6.readLine()) {
                        if (var8.contains("#MECG")) {
                           var7 = true;
                        }

                        if (var8.contains("\"")) {
                           char[] var9 = var8.toCharArray();
                           String var10 = "";

                           for(int var11 = 0; var11 < var9.length; ++var11) {
                              if (var9[var11] != '"') {
                                 var10 = var10 + var9[var11];
                              }
                           }

                           var8 = var10;
                        }

                        if (var7 && var8.contains(",")) {
                           var8.replace(",", ".");
                        }

                        if (var8.contains("'")) {
                           var8.replace("'", "`");
                        }

                        var1.add(var8);
                     }
                  } else {
                     var1.add(var3.toString() + ":" + var4);
                  }

                  var6.close();
                  var5.close();
               }
            }
         }

         if (var1.size() != 0) {
            this.preparationTransfertImport(var1);
         }
      } catch (IOException var12) {
         var12.printStackTrace();
      }

   }

   public void importFtp() {
   }

   public void preparationTransfertImport(List var1) throws IOException, NamingException, HibernateException, ParseException, groovyjarjarcommonscli.ParseException {
      this.formTransfertBulletin = new FormTransfertBulletin();
      this.formTransfertBulletin.setutilInitHibernate(this.utilInitHibernate);
      this.formTransfertBulletin.setBaseLog(this.baseLog);
      this.formTransfertBulletin.setStructureLog(this.structureLog);
      this.formTransfertBulletin.setUsersLog(this.usersLog);
      this.formTransfertBulletin.InstancesDaoUtilses();
      this.formTransfertBulletin.setOptionPaye(this.optionPaye);
      this.formTransfertBulletin.setExercicesPaye(this.exoselectionne);
      this.formTransfertBulletin.transfertImport(var1);
      this.formTransfertBulletin.setFormRecherche(this.formRecherche);
      this.affichePage = "/paye/TransfertBulletinInit.jsp";
      this.setQuelTransfert("importExterne");
   }

   public List chargerBulletins(BulletinSalaireDao var1, Salaries var2, Session var3) throws HibernateException, NamingException {
      this.lesBulletins.clear();
      this.lesBulletins = var1.chargerlesBulletinsbySalarieExercice(var2, this.exoselectionne, var3);
      this.dataModelBulletins.setWrappedData(this.lesBulletins);
      this.var_affiche_bouton = false;
      return this.lesBulletins;
   }

   public List chargerSimulation(BulletinSalaireDao var1, Salaries var2, Session var3) throws HibernateException, NamingException {
      Object var4 = new ArrayList();
      new BulletinSalaire();
      BulletinSalaire var5 = var1.rechercheBulletinSalariePeriode(var2.getSalMatricule(), "SIMUL", var3);
      if (var5 != null) {
         var4 = this.bulletinLigneDao.chargerleslignesBulletinSimulation(var5, var3);
      }

      return (List)var4;
   }

   public void selectionBulletin() throws HibernateException {
      if (this.dataModelBulletins.isRowAvailable()) {
         this.bulletinSalaire = (BulletinSalaire)this.dataModelBulletins.getRowData();
         this.var_affiche_bouton = true;
      }

   }

   public void recalculNbJourCP() throws HibernateException, NamingException {
      if (this.bulletinSalaire != null) {
         BulletinSalaireDao var1 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         this.bulletinSalaire = var1.modif(this.bulletinSalaire);
      }

   }

   public void recalculBaseCP() throws HibernateException, NamingException {
      if (this.bulletinSalaire != null) {
         BulletinSalaireDao var1 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         this.bulletinSalaire = var1.modif(this.bulletinSalaire);
      }

   }

   public void consulterBulletin() throws HibernateException, NamingException {
      if (this.bulletinSalaire != null) {
         this.consulterBulletin(this.bulletinSalaire);
      }

   }

   public void consulterBulletinPret() throws HibernateException, NamingException {
      if (this.formPrets != null) {
         String var1 = this.formPrets.matPeriode();
         String[] var2 = var1.split(":");
         String var3 = var2[0] + ":" + var2[1];
         String var4 = var2[2];
         new Salaries();
         SalariesDao var6 = new SalariesDao(this.baseLog, this.utilInitHibernate);
         Salaries var5 = var6.chargerlesSalaries(var4, (Session)null);
         if (var5 != null) {
            this.accesBulletins = false;
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, 90, (Session)null);
            if (this.usersChrono != null) {
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 90, "" + this.exoselectionne.getExepayId(), (Session)null);
               if (this.chrono != null) {
                  if (var5.getSalProtege() == 0) {
                     this.accesBulletins = true;
                  } else if (this.usersLog.getUsrPaye() == 0) {
                     this.accesBulletins = true;
                  }
               } else {
                  this.accesBulletins = false;
               }
            }

            if (this.accesBulletins) {
               BulletinSalaireDao var7 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
               this.bulletinSalaire = var7.rechercheBulletinSalariePeriode(var4, var3, (Session)null);
               if (this.bulletinSalaire != null) {
                  this.consulterBulletin(this.bulletinSalaire);
               }
            } else {
               this.formRecherche.setMessageTexte("Vous n'avez pas accès à cette focntion pour ce salarié...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else {
            this.formRecherche.setMessageTexte("Ce salarié est inaccessible...");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      }

   }

   public void consulterBulletinConges() throws HibernateException, NamingException {
      if (this.formConges != null) {
         String var1 = this.formConges.matPeriodeConges();
         String[] var2 = var1.split(":");
         String var3 = var2[0] + ":" + var2[1];
         String var4 = var2[2];
         new Salaries();
         SalariesDao var6 = new SalariesDao(this.baseLog, this.utilInitHibernate);
         Salaries var5 = var6.chargerlesSalaries(var4, (Session)null);
         if (var5 != null) {
            this.accesBulletins = false;
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, 90, (Session)null);
            if (this.usersChrono != null) {
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 90, "" + this.exoselectionne.getExepayId(), (Session)null);
               if (this.chrono != null) {
                  if (var5.getSalProtege() == 0) {
                     this.accesBulletins = true;
                  } else if (this.usersLog.getUsrPaye() == 0) {
                     this.accesBulletins = true;
                  }
               } else {
                  this.accesBulletins = false;
               }
            }

            if (this.accesBulletins) {
               BulletinSalaireDao var7 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
               this.bulletinSalaire = var7.rechercheBulletinSalariePeriode(var4, var3, (Session)null);
               if (this.bulletinSalaire != null) {
                  this.consulterBulletin(this.bulletinSalaire);
               }
            } else {
               this.formRecherche.setMessageTexte("Vous n'avez pas accès à cette focntion pour ce salarié...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else {
            this.formRecherche.setMessageTexte("Ce salarié est inaccessible...");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      }

   }

   public void consulterBulletinAbsences() throws HibernateException, NamingException {
      if (this.formConges != null) {
         String var1 = this.formConges.matPeriodeAbsences();
         String[] var2 = var1.split(":");
         String var3 = var2[0] + ":" + var2[1];
         String var4 = var2[2];
         new Salaries();
         SalariesDao var6 = new SalariesDao(this.baseLog, this.utilInitHibernate);
         Salaries var5 = var6.chargerlesSalaries(var4, (Session)null);
         if (var5 != null) {
            this.accesBulletins = false;
            this.usersChrono = this.usersChronoDao.chronoByUserNat(this.usersLog, 90, (Session)null);
            if (this.usersChrono != null) {
               this.chrono = this.chronoDao.chronoBySerieNat(this.usersChrono.getUsrchrSerie(), 90, "" + this.exoselectionne.getExepayId(), (Session)null);
               if (this.chrono != null) {
                  if (var5.getSalProtege() == 0) {
                     this.accesBulletins = true;
                  } else if (this.usersLog.getUsrPaye() == 0) {
                     this.accesBulletins = true;
                  }
               } else {
                  this.accesBulletins = false;
               }
            }

            if (this.accesBulletins) {
               BulletinSalaireDao var7 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
               this.bulletinSalaire = var7.rechercheBulletinSalariePeriode(var4, var3, (Session)null);
               if (this.bulletinSalaire != null) {
                  this.consulterBulletin(this.bulletinSalaire);
               }
            } else {
               this.formRecherche.setMessageTexte("Vous n'avez pas accès à cette focntion pour ce salarié...");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else {
            this.formRecherche.setMessageTexte("Ce salarié est inaccessible...");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      }

   }

   public void consulterBulletin(BulletinSalaire var1) throws HibernateException, NamingException {
      if (var1 != null) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.bulletinSalaire = var1;
         this.lesBulletinsLigne.clear();
         this.lesBulletinsLigne = this.bulletinLigneDao.chargerleslignesBulletin(this.bulletinSalaire, var2);
         this.dataModelBulletinsLigne.setWrappedData(this.lesBulletinsLigne);
         new FeuilleCalcul();
         FeuilleCalculDao var4 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
         FeuilleCalcul var3 = var4.chercherCode(this.bulletinSalaire.getBulsalFeuille(), this.exoselectionne.getExepayId(), var2);
         if (var3 != null) {
            this.nomModeleDocument = var3.getFeuModele();
         }

         this.recupererBulletinModele(var3);
         this.bulletinMoisDao = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
         this.bulletinMois = this.bulletinMoisDao.recupererBulletinMois(this.bulletinSalaire.getBulsalPeriode(), var2);
         this.var_correction = false;
         this.showModalPanelBulletin = true;
         this.showModalPanelPrintBulletin = false;
         this.utilInitHibernate.closeSession();
      }

   }

   public void fermerConsulterBulletin() {
      this.showModalPanelBulletin = false;
      this.showModalPanelPrintBulletin = false;
   }

   public void historiqueRubrique() throws HibernateException, NamingException {
      if (this.bulletinSalaire != null) {
         this.historiqueRubrique(this.bulletinSalaire);
      }

   }

   public void historiqueRubrique(BulletinSalaire var1) throws HibernateException, NamingException {
      if (var1 != null) {
         this.bulletinSalaire = var1;
         this.listeRubriques.clear();
         new ArrayList();
         List var2 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries((Date)this.exoselectionne.getExepayDateDebut(), (Date)this.exoselectionne.getExepayDateFin(), this.bulletinSalaire.getSalaries(), (Session)null);
         if (var2.size() != 0) {
            this.bulletinLigne = new BulletinLigne();
            this.bulletinLigne.setBulligRubrique("1");
            this.bulletinLigne.setBulligLibelle("Situation de famille");
            this.bulletinLigne.setBulligNature(0);
            this.bulletinLigne.setBulligSens(0);
            this.listeRubriques.add(this.bulletinLigne);
            this.bulletinLigne = new BulletinLigne();
            this.bulletinLigne.setBulligRubrique("2");
            this.bulletinLigne.setBulligLibelle("Nb de parts fiscales");
            this.bulletinLigne.setBulligNature(0);
            this.bulletinLigne.setBulligSens(0);
            this.listeRubriques.add(this.bulletinLigne);
            this.bulletinLigne = new BulletinLigne();
            this.bulletinLigne.setBulligRubrique("3");
            this.bulletinLigne.setBulligLibelle("Nb d'enfants");
            this.bulletinLigne.setBulligNature(0);
            this.bulletinLigne.setBulligSens(0);
            this.listeRubriques.add(this.bulletinLigne);
            if (this.structureLog.getStrcodepays().equals("0202")) {
               this.bulletinLigne = new BulletinLigne();
               this.bulletinLigne.setBulligRubrique("4");
               this.bulletinLigne.setBulligLibelle("Nb de parts TRIMF");
               this.bulletinLigne.setBulligNature(0);
               this.bulletinLigne.setBulligSens(0);
               this.listeRubriques.add(this.bulletinLigne);
            }

            for(int var3 = 0; var3 < var2.size(); ++var3) {
               String var4 = ((BulletinLigne)var2.get(var3)).getBulligRubrique();
               String var5 = "";
               if (((BulletinLigne)var2.get(var3)).getBulligLibelle().contains(" #")) {
                  String[] var6 = ((BulletinLigne)var2.get(var3)).getBulligLibelle().split(" #");
                  var5 = var6[0];
               } else {
                  var5 = ((BulletinLigne)var2.get(var3)).getBulligLibelle();
               }

               if (this.listeRubriques.size() == 0) {
                  this.bulletinLigne = new BulletinLigne();
                  this.bulletinLigne.setBulligRubrique(((BulletinLigne)var2.get(var3)).getBulligRubrique());
                  this.bulletinLigne.setBulligLibelle(((BulletinLigne)var2.get(var3)).getBulligLibelle());
                  this.bulletinLigne.setBulligNature(((BulletinLigne)var2.get(var3)).getBulligNature());
                  this.bulletinLigne.setBulligSens(((BulletinLigne)var2.get(var3)).getBulligSens());
                  this.listeRubriques.add(this.bulletinLigne);
               } else {
                  boolean var11 = false;

                  for(int var7 = 0; var7 < this.listeRubriques.size(); ++var7) {
                     if (((BulletinLigne)this.listeRubriques.get(var7)).getBulligRubrique().equals(var4)) {
                        if (!var4.equals("600200") && !var4.equals("600300")) {
                           var11 = true;
                           break;
                        }

                        if (((BulletinLigne)this.listeRubriques.get(var7)).getBulligLibelle().contains(" #")) {
                           String[] var8 = ((BulletinLigne)this.listeRubriques.get(var7)).getBulligLibelle().split(" #");
                           if (var8[0].equals(var5)) {
                              var11 = true;
                              break;
                           }
                        } else if (((BulletinLigne)this.listeRubriques.get(var7)).getBulligLibelle().equals(var5)) {
                           var11 = true;
                           break;
                        }
                     }
                  }

                  if (!var11) {
                     this.bulletinLigne = new BulletinLigne();
                     this.bulletinLigne.setBulligRubrique(((BulletinLigne)var2.get(var3)).getBulligRubrique());
                     this.bulletinLigne.setBulligLibelle(((BulletinLigne)var2.get(var3)).getBulligLibelle());
                     this.bulletinLigne.setBulligNature(((BulletinLigne)var2.get(var3)).getBulligNature());
                     this.bulletinLigne.setBulligSens(((BulletinLigne)var2.get(var3)).getBulligSens());
                     this.listeRubriques.add(this.bulletinLigne);
                  }
               }
            }

            if (this.listeRubriques.size() != 0) {
               new BulletinLigne();

               for(int var10 = 0; var10 < this.listeRubriques.size(); ++var10) {
                  this.bulletinLigne = (BulletinLigne)this.listeRubriques.get(var10);

                  for(int var12 = 0; var12 < var2.size(); ++var12) {
                     BulletinLigne var9 = (BulletinLigne)var2.get(var12);
                     if (this.bulletinLigne.getBulligRubrique().equals("1")) {
                        if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 1) {
                           this.bulletinLigne.setVsitFam01(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 2) {
                           this.bulletinLigne.setVsitFam02(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 3) {
                           this.bulletinLigne.setVsitFam03(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 4) {
                           this.bulletinLigne.setVsitFam04(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 5) {
                           this.bulletinLigne.setVsitFam05(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 6) {
                           this.bulletinLigne.setVsitFam06(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 7) {
                           this.bulletinLigne.setVsitFam07(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 8) {
                           this.bulletinLigne.setVsitFam08(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 9) {
                           this.bulletinLigne.setVsitFam09(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 10) {
                           this.bulletinLigne.setVsitFam10(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 11) {
                           this.bulletinLigne.setVsitFam11(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 12) {
                           this.bulletinLigne.setVsitFam12(var9.getBulletinSalaire().getBulsalSitFamille() + 1);
                        }
                     } else if (this.bulletinLigne.getBulligRubrique().equals("2")) {
                        if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 1) {
                           this.bulletinLigne.setVnbParts01(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 2) {
                           this.bulletinLigne.setVnbParts02(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 3) {
                           this.bulletinLigne.setVnbParts03(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 4) {
                           this.bulletinLigne.setVnbParts04(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 5) {
                           this.bulletinLigne.setVnbParts05(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 6) {
                           this.bulletinLigne.setVnbParts06(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 7) {
                           this.bulletinLigne.setVnbParts07(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 8) {
                           this.bulletinLigne.setVnbParts08(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 9) {
                           this.bulletinLigne.setVnbParts09(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 10) {
                           this.bulletinLigne.setVnbParts10(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 11) {
                           this.bulletinLigne.setVnbParts11(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 12) {
                           this.bulletinLigne.setVnbParts12(var9.getBulletinSalaire().getBulsalNbPartFiscal());
                        }
                     } else if (this.bulletinLigne.getBulligRubrique().equals("3")) {
                        if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 1) {
                           this.bulletinLigne.setVnbEnfants01(var9.getBulletinSalaire().getBulsalNbEnfant());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 2) {
                           this.bulletinLigne.setVnbEnfants02(var9.getBulletinSalaire().getBulsalNbEnfant());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 3) {
                           this.bulletinLigne.setVnbEnfants03(var9.getBulletinSalaire().getBulsalNbEnfant());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 4) {
                           this.bulletinLigne.setVnbEnfants04(var9.getBulletinSalaire().getBulsalNbEnfant());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 5) {
                           this.bulletinLigne.setVnbEnfants05(var9.getBulletinSalaire().getBulsalNbEnfant());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 6) {
                           this.bulletinLigne.setVnbEnfants06(var9.getBulletinSalaire().getBulsalNbEnfant());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 7) {
                           this.bulletinLigne.setVnbEnfants07(var9.getBulletinSalaire().getBulsalNbEnfant());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 8) {
                           this.bulletinLigne.setVnbEnfants08(var9.getBulletinSalaire().getBulsalNbEnfant());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 9) {
                           this.bulletinLigne.setVnbEnfants09(var9.getBulletinSalaire().getBulsalNbEnfant());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 10) {
                           this.bulletinLigne.setVnbEnfants10(var9.getBulletinSalaire().getBulsalNbEnfant());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 11) {
                           this.bulletinLigne.setVnbEnfants11(var9.getBulletinSalaire().getBulsalNbEnfant());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 12) {
                           this.bulletinLigne.setVnbEnfants12(var9.getBulletinSalaire().getBulsalNbEnfant());
                        }
                     } else if (this.bulletinLigne.getBulligRubrique().equals("4")) {
                        if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 1) {
                           this.bulletinLigne.setVnbTrimf01(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 2) {
                           this.bulletinLigne.setVnbTrimf02(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 3) {
                           this.bulletinLigne.setVnbTrimf03(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 4) {
                           this.bulletinLigne.setVnbTrimf04(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 5) {
                           this.bulletinLigne.setVnbTrimf05(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 6) {
                           this.bulletinLigne.setVnbTrimf06(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 7) {
                           this.bulletinLigne.setVnbTrimf07(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 8) {
                           this.bulletinLigne.setVnbTrimf08(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 9) {
                           this.bulletinLigne.setVnbTrimf09(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 10) {
                           this.bulletinLigne.setVnbTrimf10(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 11) {
                           this.bulletinLigne.setVnbTrimf11(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 12) {
                           this.bulletinLigne.setVnbTrimf12(var9.getBulletinSalaire().getBulsalNbPartTrimf());
                        }
                     } else if (this.bulletinLigne.getBulligRubrique().equals(var9.getBulligRubrique())) {
                        if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 1) {
                           this.bulletinLigne.setV01(this.bulletinLigne.getV01() + var9.getBulligValColE());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 2) {
                           this.bulletinLigne.setV02(this.bulletinLigne.getV02() + var9.getBulligValColE());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 3) {
                           this.bulletinLigne.setV03(this.bulletinLigne.getV03() + var9.getBulligValColE());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 4) {
                           this.bulletinLigne.setV04(this.bulletinLigne.getV04() + var9.getBulligValColE());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 5) {
                           this.bulletinLigne.setV05(this.bulletinLigne.getV05() + var9.getBulligValColE());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 6) {
                           this.bulletinLigne.setV06(this.bulletinLigne.getV06() + var9.getBulligValColE());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 7) {
                           this.bulletinLigne.setV07(this.bulletinLigne.getV07() + var9.getBulligValColE());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 8) {
                           this.bulletinLigne.setV08(this.bulletinLigne.getV08() + var9.getBulligValColE());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 9) {
                           this.bulletinLigne.setV09(this.bulletinLigne.getV09() + var9.getBulligValColE());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 10) {
                           this.bulletinLigne.setV10(this.bulletinLigne.getV10() + var9.getBulligValColE());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 11) {
                           this.bulletinLigne.setV11(this.bulletinLigne.getV11() + var9.getBulligValColE());
                        } else if (var9.getBulletinSalaire().getBulsalDateFin().getMonth() + 1 == 12) {
                           this.bulletinLigne.setV12(this.bulletinLigne.getV12() + var9.getBulligValColE());
                        }
                     }
                  }
               }
            }
         }

         this.dataModelListeRubriques.setWrappedData(this.listeRubriques);
         this.showModalPanelListeRubrique = true;
      }

   }

   public void fermerlisteRubrique() {
      this.showModalPanelListeRubrique = false;
   }

   public void actualiseCompteursConges() throws HibernateException, NamingException, ParseException {
      if (this.lesBulletins.size() != 0) {
         SalariesHistoriqueDao var1 = new SalariesHistoriqueDao(this.baseLog, this.utilInitHibernate);
         BulletinSalaireDao var2 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            float var5 = 0.0F;
            new ArrayList();
            List var6 = var1.chargerlesHistoriquesBySalaries(((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), "", this.exoselectionne, var3);
            if (var6.size() != 0) {
               for(int var7 = 0; var7 < var6.size(); ++var7) {
                  if (((SalariesHistorique)var6.get(var7)).getSalhisCode() != null && !((SalariesHistorique)var6.get(var7)).getSalhisCode().isEmpty() && ((SalariesHistorique)var6.get(var7)).getSalhisCode().equals("NBJS")) {
                     var5 = (float)((SalariesHistorique)var6.get(var7)).getSalhisValeurColE();
                  }
               }
            }

            float var48 = 0.0F;
            if (this.lesBulletins.size() != 0) {
               new BulletinSalaire();

               for(int var9 = 0; var9 < this.lesBulletins.size(); ++var9) {
                  BulletinSalaire var8 = (BulletinSalaire)this.lesBulletins.get(var9);
                  if (var9 == 0) {
                     var8.setBulsalNbDispo(var5 + var8.getBulsalNbCpAcquis() - var8.getBulsalNbCpPris());
                     var48 = var8.getBulsalNbDispo();
                     if (var48 < 0.0F) {
                        var8.setBulsalNbDispo(0.0F);
                        var48 = var8.getBulsalNbDispo();
                     }

                     var2.modif(var8, var3);
                  } else {
                     var8.setBulsalNbDispo(var48 + var8.getBulsalNbCpAcquis() - var8.getBulsalNbCpPris());
                     var48 = var8.getBulsalNbDispo();
                     if (var48 < 0.0F) {
                        var8.setBulsalNbDispo(0.0F);
                        var48 = var8.getBulsalNbDispo();
                     }

                     var2.modif(var8, var3);
                  }
               }
            }

            var4.commit();
         } catch (HibernateException var44) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var44;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.lesBulletins = var2.chargerlesBulletinsbySalarieExercice(((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), this.exoselectionne, (Session)null);
         UtilDate var46 = new UtilDate();
         UtilNombre var47 = new UtilNombre();
         double var49 = 0.0D;
         double var50 = 0.0D;
         double var11 = 0.0D;
         Date var13 = null;
         boolean var14 = false;
         boolean var15 = false;
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var16 = null;

         try {
            var16 = var3.beginTransaction();
            new PlanPaye();
            PlanPayeDao var18 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
            PlanPaye var17 = var18.chercherCode("208000", this.exoselectionne.getExepayId(), var3);
            if (var17 != null && var17.getPlpCalculBase() != null && !var17.getPlpCalculBase().isEmpty()) {
               var15 = true;
            }

            new ArrayList();
            List var19 = var1.chargerlesHistoriquesBySalaries(((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), "", this.exoselectionne, var3);
            if (var19.size() != 0) {
               for(int var20 = 0; var20 < var19.size(); ++var20) {
                  if ((long)(((SalariesHistorique)var19.get(var20)).getSalhisDate().getYear() + 1900) == this.exoselectionne.getExepayId() && ((SalariesHistorique)var19.get(var20)).getSalhisCode() != null && !((SalariesHistorique)var19.get(var20)).getSalhisCode().isEmpty()) {
                     if (((SalariesHistorique)var19.get(var20)).getSalhisCode().equals("BRUT")) {
                        var11 += ((SalariesHistorique)var19.get(var20)).getSalhisValeurColE();
                        var13 = var46.dateMoisPrecedent(((SalariesHistorique)var19.get(var20)).getSalhisDate());
                     } else if (((SalariesHistorique)var19.get(var20)).getSalhisCode().equals("PRDCP")) {
                        var11 -= ((SalariesHistorique)var19.get(var20)).getSalhisValeurColE();
                     }
                  }
               }
            }

            int var21;
            List var22;
            List var23;
            int var24;
            int var32;
            BulletinSalaire var51;
            double var52;
            double var54;
            double var57;
            float var59;
            BulletinLigne var60;
            float var61;
            if (this.lesBulletins.size() != 0 && !var15) {
               new BulletinSalaire();

               for(var21 = 0; var21 < this.lesBulletins.size(); ++var21) {
                  var51 = (BulletinSalaire)this.lesBulletins.get(var21);
                  new ArrayList();
                  var22 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208000", this.exoselectionne.getExepayDateDebut(), var51.getBulsalDateDebut(), ((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), var3);
                  if (var22.size() != 0) {
                     if (var13 != null && var13.compareTo(((BulletinLigne)var22.get(var22.size() - 1)).getBulletinSalaire().getBulsalDateDebut()) < 0) {
                        var13 = ((BulletinLigne)var22.get(var22.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
                        var11 = 0.0D;
                        if (this.optionPaye.getBaseconges().equals("2")) {
                           var50 = ((BulletinLigne)var22.get(var22.size() - 1)).getBulligValColE();
                           new ArrayList();
                           var23 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208100", ((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), var3);
                           if (var23.size() != 0) {
                              for(var24 = 0; var24 < var23.size(); ++var24) {
                                 if (((BulletinLigne)var23.get(var24)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var22.get(var22.size() - 1)).getBulletinSalaire().getBulsalId()) {
                                    var50 += ((BulletinLigne)var23.get(var24)).getBulligValColE();
                                 }
                              }
                           }
                        }
                     } else {
                        var13 = ((BulletinLigne)var22.get(var22.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
                        var11 = 0.0D;
                        if (this.optionPaye.getBaseconges().equals("2")) {
                           var50 = ((BulletinLigne)var22.get(var22.size() - 1)).getBulligValColE();
                           new ArrayList();
                           var23 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208100", ((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), var3);
                           if (var23.size() != 0) {
                              for(var24 = 0; var24 < var23.size(); ++var24) {
                                 if (((BulletinLigne)var23.get(var24)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var22.get(var22.size() - 1)).getBulletinSalaire().getBulsalId()) {
                                    var50 += ((BulletinLigne)var23.get(var24)).getBulligValColE();
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (var13 == null) {
                     var13 = var46.stringToDateSQLLight("2000-01-01");
                  } else if (!var14) {
                     var13 = var46.dateMoisSuivant(var13);
                     var14 = true;
                  }

                  var52 = 0.0D;
                  new ArrayList();
                  List var53 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("299999", var13, var51.getBulsalDateDebut(), ((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), var3);
                  if (var53.size() != 0) {
                     for(int var55 = 0; var55 < var53.size(); ++var55) {
                        var52 += ((BulletinLigne)var53.get(var55)).getBulligValColE();
                     }
                  }

                  var54 = 0.0D;
                  var57 = 0.0D;
                  var59 = 0.0F;
                  this.lesBulletinsLigne = this.bulletinLigneDao.chargerleslignesBulletin(var51, var3);
                  new BulletinLigne();

                  for(var32 = 0; var32 < this.lesBulletinsLigne.size(); ++var32) {
                     var60 = (BulletinLigne)this.lesBulletinsLigne.get(var32);
                     if (var60.getBulligRubrique().equals("208000")) {
                        var54 = var60.getBulligValColD();
                        var57 = var60.getBulligValColE();
                     }

                     if (var60.getBulligRubrique().equals("100000")) {
                        var59 = (float)(30.0D - var60.getBulligValColD());
                     } else if (var60.getBulligRubrique().equals("100050")) {
                        var59 = (float)((double)var59 + var60.getBulligValColD());
                     }
                  }

                  var49 = var11 + var52 + var50;
                  if (var51.getBulsalCP() != 0.0D) {
                     if (var51.getBulsalBrut() <= 0.0D) {
                        var49 = 0.0D;
                     } else {
                        var49 = var51.getBulsalBrut();
                     }
                  }

                  var51 = var2.pourParapheur(var51.getBulsalId(), var3);
                  if (var51 != null) {
                     var51.setBulsalBrut(var49);
                     var51.setBulsalNbCpPris((float)var54);
                     if (var54 < 30.0D) {
                        if (var51.getSalaries().getSalNbJourTr() != 0.0F) {
                           var61 = (var51.getSalaries().getSalNbJourTr() - var59) / 30.0F;
                           var51.setBulsalNbCpAcquis((float)((double)(var51.getSalaries().getSalNbJourCp() / (var51.getSalaries().getSalNbJourTr() / var61)) * (30.0D - var54)));
                        } else {
                           var51.setBulsalNbCpAcquis(var51.getSalaries().getSalNbJourCp());
                        }
                     } else {
                        var51.setBulsalNbCpAcquis(0.0F);
                     }

                     var51.setBulsalCP(var57);
                     var2.modif(var51, var3);
                  }
               }
            } else if (this.lesBulletins.size() != 0 && var15) {
               new BulletinSalaire();

               for(var21 = 0; var21 < this.lesBulletins.size(); ++var21) {
                  var51 = (BulletinSalaire)this.lesBulletins.get(var21);
                  new ArrayList();
                  var22 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208000", this.exoselectionne.getExepayDateDebut(), var51.getBulsalDateDebut(), ((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), var3);
                  if (var22.size() != 0) {
                     if (var13 != null && var13.compareTo(((BulletinLigne)var22.get(var22.size() - 1)).getBulletinSalaire().getBulsalDateDebut()) < 0) {
                        var13 = ((BulletinLigne)var22.get(var22.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
                        var11 = 0.0D;
                        if (this.optionPaye.getBaseconges().equals("2")) {
                           var50 = ((BulletinLigne)var22.get(var22.size() - 1)).getBulligValColE();
                           new ArrayList();
                           var23 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208100", ((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), var3);
                           if (var23.size() != 0) {
                              for(var24 = 0; var24 < var23.size(); ++var24) {
                                 if (((BulletinLigne)var23.get(var24)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var22.get(var22.size() - 1)).getBulletinSalaire().getBulsalId()) {
                                    var50 += ((BulletinLigne)var23.get(var24)).getBulligValColE();
                                 }
                              }
                           }
                        }
                     } else {
                        var13 = ((BulletinLigne)var22.get(var22.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
                        var11 = 0.0D;
                        if (this.optionPaye.getBaseconges().equals("2")) {
                           var50 = ((BulletinLigne)var22.get(var22.size() - 1)).getBulligValColE();
                           new ArrayList();
                           var23 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208100", ((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), var3);
                           if (var23.size() != 0) {
                              for(var24 = 0; var24 < var23.size(); ++var24) {
                                 if (((BulletinLigne)var23.get(var24)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var22.get(var22.size() - 1)).getBulletinSalaire().getBulsalId()) {
                                    var50 += ((BulletinLigne)var23.get(var24)).getBulligValColE();
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (var13 == null) {
                     var13 = var46.stringToDateSQLLight("2000-01-01");
                  } else if (!var14) {
                     var13 = var46.dateMoisSuivant(var13);
                     var14 = true;
                  }

                  var52 = var50 + var11;
                  String var25 = var17.getPlpCalculBase();
                  if (var25 != null && !var25.isEmpty()) {
                     String[] var26;
                     String var27;
                     if (!var25.contains("#")) {
                        var26 = var25.split(":");
                        var27 = "'" + var26[0] + "'";
                        float var56 = Float.parseFloat(var26[2]);
                        this.lesBulletinsLigne = this.bulletinLigneDao.chargerleslignesLikeRubriquesSalaries(var27, var13, var51.getBulsalDateDebut(), ((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), var3);
                        if (this.lesBulletinsLigne.size() != 0) {
                           for(int var58 = 0; var58 < this.lesBulletinsLigne.size(); ++var58) {
                              if (var56 == 100.0F) {
                                 var52 += var47.myRoundDevise(((BulletinLigne)this.lesBulletinsLigne.get(var58)).getBulligValColE(), this.structureLog.getStrdevise());
                              } else if (var56 == -100.0F) {
                                 var52 -= var47.myRoundDevise(((BulletinLigne)this.lesBulletinsLigne.get(var58)).getBulligValColE(), this.structureLog.getStrdevise());
                              } else {
                                 var52 += var47.myRoundDevise(((BulletinLigne)this.lesBulletinsLigne.get(var58)).getBulligValColE() * (double)var56 / 100.0D, this.structureLog.getStrdevise());
                              }
                           }
                        }
                     } else {
                        var26 = var25.split("#");
                        var27 = "";
                        int var28 = 0;

                        label1257:
                        while(true) {
                           String[] var29;
                           String var30;
                           if (var28 >= var26.length) {
                              this.lesBulletinsLigne = this.bulletinLigneDao.chargerleslignesLikeRubriquesSalaries(var27, var13, var51.getBulsalDateDebut(), ((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), var3);
                              if (this.lesBulletinsLigne.size() == 0) {
                                 break;
                              }

                              var28 = 0;

                              while(true) {
                                 if (var28 >= var26.length) {
                                    break label1257;
                                 }

                                 var29 = var26[var28].split(":");
                                 var30 = var29[0];
                                 float var31 = Float.parseFloat(var29[2]);

                                 for(var32 = 0; var32 < this.lesBulletinsLigne.size(); ++var32) {
                                    if (((BulletinLigne)this.lesBulletinsLigne.get(var32)).getBulligRubrique().equals(var30)) {
                                       if (var31 == 100.0F) {
                                          var52 += var47.myRoundDevise(((BulletinLigne)this.lesBulletinsLigne.get(var32)).getBulligValColE(), this.structureLog.getStrdevise());
                                       } else if (var31 == -100.0F) {
                                          var52 -= var47.myRoundDevise(((BulletinLigne)this.lesBulletinsLigne.get(var32)).getBulligValColE(), this.structureLog.getStrdevise());
                                       } else {
                                          var52 += var47.myRoundDevise(((BulletinLigne)this.lesBulletinsLigne.get(var32)).getBulligValColE() * (double)var31 / 100.0D, this.structureLog.getStrdevise());
                                       }
                                    }
                                 }

                                 ++var28;
                              }
                           }

                           var29 = var26[var28].split(":");
                           var30 = var29[0];
                           if (var27 != null && !var27.isEmpty()) {
                              var27 = var27 + ",'" + var30 + "'";
                           } else {
                              var27 = "'" + var30 + "'";
                           }

                           ++var28;
                        }
                     }
                  }

                  var54 = 0.0D;
                  var57 = 0.0D;
                  var59 = 0.0F;
                  this.lesBulletinsLigne = this.bulletinLigneDao.chargerleslignesBulletin(var51, var3);
                  new BulletinLigne();

                  for(var32 = 0; var32 < this.lesBulletinsLigne.size(); ++var32) {
                     var60 = (BulletinLigne)this.lesBulletinsLigne.get(var32);
                     if (var60.getBulligRubrique().equals("208000")) {
                        var54 = var60.getBulligValColD();
                        var57 = var60.getBulligValColE();
                     }

                     if (var60.getBulligRubrique().equals("100000")) {
                        var59 = (float)(30.0D - var60.getBulligValColD());
                     } else if (var60.getBulligRubrique().equals("100050")) {
                        var59 = (float)((double)var59 + var60.getBulligValColD());
                     }
                  }

                  if (var51.getBulsalCP() != 0.0D) {
                     var51.setBulsalBrut(var51.getBulsalBrut());
                     if (var51.getBulsalBrut() <= 0.0D) {
                        var52 = 0.0D;
                     } else {
                        var52 = var51.getBulsalBrut();
                     }
                  }

                  var51 = var2.pourParapheur(var51.getBulsalId(), var3);
                  if (var51 != null) {
                     var51.setBulsalBrut(var52);
                     var51.setBulsalNbCpPris((float)var54);
                     if (var54 < 30.0D) {
                        if (var51.getSalaries().getSalNbJourTr() != 0.0F) {
                           var61 = (var51.getSalaries().getSalNbJourTr() - var59) / 30.0F;
                           var51.setBulsalNbCpAcquis((float)((double)(var51.getSalaries().getSalNbJourCp() / (var51.getSalaries().getSalNbJourTr() / var61)) * (30.0D - var54)));
                        } else {
                           var51.setBulsalNbCpAcquis(var51.getSalaries().getSalNbJourCp());
                        }
                     } else {
                        var51.setBulsalNbCpAcquis(0.0F);
                     }

                     var51.setBulsalCP(var57);
                     var2.modif(var51, var3);
                  }
               }
            }

            var16.commit();
         } catch (HibernateException var42) {
            if (var16 != null) {
               var16.rollback();
            }

            throw var42;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.lesBulletins = var2.chargerlesBulletinsbySalarieExercice(((BulletinSalaire)this.lesBulletins.get(0)).getSalaries(), this.exoselectionne, (Session)null);
         this.dataModelBulletins.setWrappedData(this.lesBulletins);
      }

   }

   public void modificationBulletin() throws HibernateException, NamingException, ParseException {
      if (this.lesBulletinsLigne.size() != 0 && this.bulletinSalaire != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         new ExercicesPaye();
         ExercicesPayeDao var3 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
         ExercicesPaye var2 = var3.recupererLastExo(var1);
         if (var2 != null) {
            new ArrayList();
            FeuilleCalculRubriqueDao var5 = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
            new FeuilleCalcul();
            FeuilleCalculDao var7 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
            FeuilleCalcul var6 = var7.chercherCode(this.bulletinSalaire.getBulsalFeuille(), this.bulletinSalaire.getExercicesPaye().getExepayId(), var1);
            if (var6 != null) {
               new SalariesElements();
               SalariesElementsDao var9 = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
               SalariesElements var8 = var9.chargerlesVariablesPeriode(this.bulletinSalaire.getSalaries(), this.bulletinSalaire.getBulsalPeriode(), this.bulletinSalaire.getBulsalContrat(), var1);
               if (var8 != null) {
                  List var4 = var5.chargerRubriqueFeuille(var6, var1);
                  if (var4.size() != 0) {
                     new FeuilleCalculRubrique();
                     int var11 = 0;

                     while(true) {
                        if (var11 >= var4.size()) {
                           this.var_correction = true;
                           break;
                        }

                        FeuilleCalculRubrique var10 = (FeuilleCalculRubrique)var4.get(var11);
                        boolean var12 = false;

                        for(int var13 = 0; var13 < this.lesBulletinsLigne.size(); ++var13) {
                           this.bulletinLigne = (BulletinLigne)this.lesBulletinsLigne.get(var13);
                           if (this.bulletinLigne.getBulligRubrique().equals(var10.getFeurubCode())) {
                              var12 = true;
                              break;
                           }
                        }

                        if (!var12) {
                           this.bulletinLigne = new BulletinLigne();
                           this.bulletinLigne.setExercicesPaye(var2);
                           this.bulletinLigne.setSalaries(this.bulletinSalaire.getSalaries());
                           this.bulletinLigne.setBulletinSalaire(this.bulletinSalaire);
                           this.bulletinLigne.setBulligAffColA(var10.isFeurubColA());
                           this.bulletinLigne.setBulligAffColB(var10.isFeurubColB());
                           this.bulletinLigne.setBulligAffColC(var10.isFeurubColC());
                           this.bulletinLigne.setBulligAffColD(var10.isFeurubColD());
                           this.bulletinLigne.setBulligAffColE(var10.isFeurubColE());
                           this.bulletinLigne.setBulligLibelle(var10.getPlanPaye().getPlpLibelleFR());
                           this.bulletinLigne.setBulligNature(var10.getPlanPaye().getPlpNature());
                           this.bulletinLigne.setBulligRubrique(var10.getFeurubCode());
                           this.bulletinLigne.setBulligSens(var10.getPlanPaye().getPlpSens());
                           this.bulletinLigne.setBulligValColA(0.0D);
                           this.bulletinLigne.setBulligValColB(0.0D);
                           this.bulletinLigne.setBulligValColC(0.0D);
                           this.bulletinLigne.setBulligValColD(0.0D);
                           this.bulletinLigne.setBulligValColE(0.0D);
                           this.lesBulletinsLigne.add(this.bulletinLigne);
                        } else {
                           this.bulletinLigne.setBulligAffColA(var10.isFeurubColA());
                           this.bulletinLigne.setBulligAffColB(var10.isFeurubColB());
                           this.bulletinLigne.setBulligAffColC(var10.isFeurubColC());
                           this.bulletinLigne.setBulligAffColD(var10.isFeurubColD());
                           this.bulletinLigne.setBulligAffColE(var10.isFeurubColE());
                        }

                        ++var11;
                     }
                  }
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void validationModificationBulletin() throws HibernateException, NamingException, ParseException {
      if (this.lesBulletinsLigne.size() != 0 && this.var_correction) {
         new UtilNombre();
         BulletinSalaireDao var2 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         new SalariesElements();
         SalariesElementsDao var4 = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var6 = null;

         try {
            var6 = var5.beginTransaction();
            SalariesElements var3 = var4.chargerlesVariablesPeriode(this.bulletinSalaire.getSalaries(), this.bulletinSalaire.getBulsalPeriode(), this.bulletinSalaire.getBulsalContrat(), var5);
            if (var3 != null) {
               double var7 = 0.0D;
               double var9 = 0.0D;
               double var11 = 0.0D;
               new BulletinLigne();
               int var14 = 0;

               while(true) {
                  if (var14 >= this.lesBulletinsLigne.size()) {
                     for(var14 = 0; var14 < this.lesBulletinsLigne.size(); ++var14) {
                        this.bulletinLigne = (BulletinLigne)this.lesBulletinsLigne.get(var14);
                        if (this.bulletinLigne.getBulligNature() == 59) {
                           this.bulletinLigne.setBulligValColE(var7);
                        } else if (this.bulletinLigne.getBulligNature() == 69) {
                           this.bulletinLigne.setBulligValColE(var9);
                        } else if (this.bulletinLigne.getBulligNature() == 89) {
                           this.bulletinLigne.setBulligValColE(var11);
                        }
                     }

                     for(var14 = 0; var14 < this.lesBulletinsLigne.size(); ++var14) {
                        this.bulletinLigne = (BulletinLigne)this.lesBulletinsLigne.get(var14);
                        if (this.bulletinLigne.getBulligValColE() != 0.0D) {
                           if (this.bulletinLigne.getBulligId() == 0L) {
                              this.bulletinLigne = this.bulletinLigneDao.insert(this.bulletinLigne, var5);
                           } else {
                              this.bulletinLigne = this.bulletinLigneDao.modif(this.bulletinLigne, var5);
                           }
                        } else if (this.bulletinLigne.getBulligId() != 0L) {
                           this.bulletinLigneDao.delete(this.bulletinLigne, var5);
                        }
                     }

                     this.bulletinSalaire.setBulsalManuel(1);
                     this.formCalculBulletin.setMontantAtteindre(0.0D);
                     this.formCalculBulletin.setSalariesElements(var3);
                     this.formCalculBulletin.setSalaries(this.bulletinSalaire.getSalaries());
                     this.formCalculBulletin.setExercicesPaye(this.bulletinSalaire.getExercicesPaye());
                     this.formCalculBulletin.setBulletinSalaire(this.bulletinSalaire);
                     this.formCalculBulletin.setLesBulletinsLigne(this.lesBulletinsLigne);
                     this.bulletinSalaire = this.formCalculBulletin.calculEnteteBulletin(var5);
                     this.bulletinSalaire = var2.modif(this.bulletinSalaire, var5);
                     break;
                  }

                  BulletinLigne var13 = (BulletinLigne)this.lesBulletinsLigne.get(var14);
                  if (var13.getBulligNature() == 10 || var13.getBulligNature() == 20 || var13.getBulligNature() == 30 || var13.getBulligNature() == 40 || var13.getBulligNature() == 41 || var13.getBulligNature() == 42) {
                     var7 += var13.getBulligValColE();
                  }

                  if (var13.getBulligNature() == 10 || var13.getBulligNature() == 20 || var13.getBulligNature() == 30 || var13.getBulligNature() == 40 || var13.getBulligNature() == 41 || var13.getBulligNature() == 42 || var13.getBulligNature() == 60 || var13.getBulligNature() == 61 || var13.getBulligNature() == 62) {
                     var9 += var13.getBulligValColE();
                  }

                  if (var13.getBulligNature() == 10 || var13.getBulligNature() == 20 || var13.getBulligNature() == 30 || var13.getBulligNature() == 40 || var13.getBulligNature() == 41 || var13.getBulligNature() == 42 || var13.getBulligNature() == 60 || var13.getBulligNature() == 61 || var13.getBulligNature() == 62 || var13.getBulligNature() == 70 || var13.getBulligNature() == 80 || var13.getBulligNature() == 88) {
                     var11 += var13.getBulligValColE();
                  }

                  ++var14;
               }
            }

            var6.commit();
         } catch (HibernateException var18) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var18;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.lesBulletinsLigne.clear();
         this.lesBulletinsLigne = this.bulletinLigneDao.chargerleslignesBulletin(this.bulletinSalaire, (Session)null);
         this.dataModelBulletinsLigne.setWrappedData(this.lesBulletinsLigne);
         this.var_correction = false;
      }

   }

   public void selectionLigneBulletin() throws HibernateException {
      if (this.dataModelBulletinsLigne.isRowAvailable()) {
         this.bulletinLigne = (BulletinLigne)this.dataModelBulletinsLigne.getRowData();
      }

   }

   public void modificationLigne() throws HibernateException, NamingException {
      if (this.bulletinLigne != null) {
         this.bulletinLigne = this.bulletinLigneDao.modif(this.bulletinLigne);
      }

   }

   public void selectionBulletinImpression() throws HibernateException, NamingException {
      this.formCalculBulletin.selectionLigneGeneree();
      this.bulletinSalaire = this.formCalculBulletin.getBulletinSalaire();
      if (this.bulletinSalaire != null) {
         this.impressionBulletin();
      }

   }

   public void impressionBulletin() throws HibernateException, NamingException {
      if (this.bulletinSalaire != null) {
         if (this.utilPrint == null) {
            this.utilPrint = new UtilPrint(this.utilInitHibernate);
         }

         this.simulation = false;
         this.chargePatronales = 0;
         new FeuilleCalcul();
         FeuilleCalculDao var2 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
         FeuilleCalcul var1 = var2.chercherCode(this.bulletinSalaire.getBulsalFeuille(), this.exoselectionne.getExepayId(), (Session)null);
         if (var1 != null) {
            this.nomModeleDocument = var1.getFeuModele();
         }

         this.recupererBulletinModele(var1);
         this.showModalPanelPrintBulletin = true;
      }

   }

   public void imprimerPreparation() throws HibernateException, NamingException {
      this.salarieBulletin = "";
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      if (this.usersLog.getUsrIdSalarieGuest() != 0L && this.exoselectionne.getExepayId() != 0L) {
         SalariesDao var1 = new SalariesDao(this.baseLog, this.utilInitHibernate);
         new Salaries();
         Salaries var2 = var1.chercherIdSalaries(this.usersLog.getUsrIdSalarieGuest(), (Session)null);
         if (var2 != null) {
            this.salarieBulletin = var2.getSalMatricule();
            this.mesBuletinsSalarieItems.clear();
            BulletinSalaireDao var3 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var4 = var3.chargerLesBulletinsByMatricule((Salaries)var2, this.exoselectionne.getExepayDateDebut(), this.exoselectionne.getExepayDateFin(), (Session)null);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  this.mesBuletinsSalarieItems.add(new SelectItem(((BulletinSalaire)var4.get(var5)).getBulsalPeriode(), ((BulletinSalaire)var4.get(var5)).getBulsalPeriode()));
               }

               new FeuilleCalcul();
               FeuilleCalculDao var6 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
               FeuilleCalcul var7 = var6.chercherCode(var2.getSalFeuille(), this.exoselectionne.getExepayId(), (Session)null);
               if (var7 != null) {
                  this.nomModeleDocument = var7.getFeuModele();
                  this.recupererBulletinModele(var7);
                  this.showModalPanelPrintBulletin = true;
               }
            }
         }
      }

   }

   public void impressionSimulation() throws HibernateException, NamingException {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.chargePatronales = 0;
      new ArrayList();
      List var1 = this.formCalculBulletin.getLesBulletinsLigne();
      if (var1.size() != 0) {
         this.simulation = true;
         this.lesBulletinsLigne.clear();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.bulletinLigne = (BulletinLigne)var1.get(var2);
            if (this.bulletinLigne.getBulligValColE() != 0.0D) {
               this.lesBulletinsLigne.add(this.bulletinLigne);
            }
         }

         new FeuilleCalcul();
         FeuilleCalculDao var3 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
         FeuilleCalcul var4 = var3.chercherCode(this.formCalculBulletin.getSalaries().getSalFeuille(), this.exoselectionne.getExepayId(), (Session)null);
         if (var4 != null) {
            this.nomModeleDocument = var4.getFeuModele();
            this.showModalPanelPrintBulletin = true;
         }
      }

   }

   public void closeImpression() {
      this.showModalPanelPrintBulletin = false;
   }

   public void imprimerBulletinPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimerBulletin();
   }

   public void imprimerBulletinJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerBulletin();
   }

   public void imprimerBulletinPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerBulletin();
   }

   public void imprimerBulletinODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimerBulletin();
   }

   public void imprimerBulletinXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimerBulletin();
   }

   public void imprimerBulletinDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimerBulletin();
   }

   public void imprimerBulletinHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimerBulletin();
   }

   public void imprimerBulletinXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimerBulletin();
   }

   public void imprimerBulletinMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && this.impDestinataire != null && !this.impDestinataire.isEmpty()) {
         this.format = "MAIL";
         this.imprimerBulletin();
      }

   }

   public void envoieBulletinMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         this.utilPrint.chargerLesBalEmtteursSalaries(this.baseLog, this.structureLog, this.usersLog, this.bulletinSalaire.getSalaries());
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public void imprimerBulletin() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
         if (this.utilPrint == null) {
            this.utilPrint = new UtilPrint(this.utilInitHibernate);
         }

         this.utilPrint.setRapport(this.nomModeleDocument);
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "bulletin" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setPatientsSelectionne((Patients)null);
         this.utilPrint.setEntete("Impression bulletin");
         if (this.simulation) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               this.formCalculBulletin.enregistrementSimulation(var1);
               var2.commit();
            } catch (HibernateException var17) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var17;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.bulletinSalaire = this.formCalculBulletin.getBulletinSalaire();
         } else if (this.nomModeleDocument.equals("XXXXXX")) {
            new FeuilleCalcul();
            FeuilleCalculDao var23 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
            FeuilleCalcul var21 = var23.chercherCode(this.bulletinSalaire.getBulsalFeuille(), this.exoselectionne.getExepayId(), (Session)null);
            if (var21 != null) {
               this.nomModeleDocument = var21.getFeuModele();
            }
         }

         this.utilPrint.setNomMapping("Salarie");
         String var22 = "pay_bulletin_ligne.`bulsal_id` =" + this.bulletinSalaire.getBulsalId() + " and pay_bulletin_ligne.`bullig_nature` <> 99";
         this.utilPrint.setRequete(var22);
         this.utilPrint.setBulletinSelectionne(this.bulletinSalaire);
         this.utilPrint.setNature(this.nature);
         ArrayList var24 = new ArrayList();
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var24);
         this.utilPrint.setjRBeanCollectionDataSource(var3);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
         if (this.formCalculBulletin != null) {
            this.formCalculBulletin.majDateImpression();
         }

         if (this.simulation) {
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var5 = null;

            try {
               var5 = var4.beginTransaction();
               if (this.bulletinSalaire != null) {
                  BulletinSalaireDao var6 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
                  if (this.lesBulletinsLigne.size() != 0) {
                     for(int var7 = 0; var7 < this.lesBulletinsLigne.size(); ++var7) {
                        this.bulletinLigne = (BulletinLigne)this.lesBulletinsLigne.get(var7);
                        this.bulletinLigneDao.delete(this.bulletinLigne, var4);
                     }
                  }

                  var6.delete(this.bulletinSalaire, var4);
               }

               var5.commit();
            } catch (HibernateException var19) {
               if (var5 != null) {
                  var5.rollback();
               }

               throw var19;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

   }

   public void imprimerMonBulletinJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerMonBulletin();
   }

   public void imprimerMonBulletinPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerMonBulletin();
   }

   public void imprimerMonBulletin() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty() && this.salarieBulletin != null && !this.salarieBulletin.isEmpty()) {
         if (this.utilPrint == null) {
            this.utilPrint = new UtilPrint(this.utilInitHibernate);
         }

         this.utilPrint.setRapport(this.nomModeleDocument);
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "bulletin" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setDestinataire("");
         this.utilPrint.setDestinataireCC("");
         this.utilPrint.setDestinataireCCI("");
         this.utilPrint.setEmetteur("");
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setPatientsSelectionne((Patients)null);
         this.utilPrint.setEntete("Impression bulletin");
         BulletinSalaireDao var1 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         this.bulletinSalaire = var1.rechercheBulletinSalariePeriode(this.salarieBulletin, this.periodeBulletin, (Session)null);
         if (this.bulletinSalaire != null) {
            if (this.nomModeleDocument.equals("XXXXXX")) {
               new FeuilleCalcul();
               FeuilleCalculDao var3 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
               FeuilleCalcul var2 = var3.chercherCode(this.bulletinSalaire.getBulsalFeuille(), this.exoselectionne.getExepayId(), (Session)null);
               if (var2 != null) {
                  this.nomModeleDocument = var2.getFeuModele();
               }
            }

            this.utilPrint.setNomMapping("Salarie");
            String var5 = "pay_bulletin_ligne.`bulsal_id` =" + this.bulletinSalaire.getBulsalId() + " and pay_bulletin_ligne.`bullig_nature` <> 99";
            this.utilPrint.setRequete(var5);
            this.utilPrint.setBulletinSelectionne(this.bulletinSalaire);
            this.utilPrint.setNature(this.nature);
            ArrayList var6 = new ArrayList();
            JRBeanCollectionDataSource var4 = new JRBeanCollectionDataSource(var6);
            this.utilPrint.setjRBeanCollectionDataSource(var4);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      }

   }

   public MenudroitPayeCtrl getMenudroitPayeCtrl() {
      return this.menudroitPayeCtrl;
   }

   public void setMenudroitPayeCtrl(MenudroitPayeCtrl var1) {
      this.menudroitPayeCtrl = var1;
   }

   public FormExercicesPaye getFormExercicesPaye() {
      return this.formExercicesPaye;
   }

   public void setFormExercicesPaye(FormExercicesPaye var1) {
      this.formExercicesPaye = var1;
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

   public ExercicesPaye getExoselectionne() {
      return this.exoselectionne;
   }

   public void setExoselectionne(ExercicesPaye var1) {
      this.exoselectionne = var1;
   }

   public ObjetLigneMenu getMenupaye() {
      return this.menupaye;
   }

   public void setMenupaye(ObjetLigneMenu var1) {
      this.menupaye = var1;
   }

   public FormFicheSalarie getFormFicheSalarie() {
      return this.formFicheSalarie;
   }

   public void setFormFicheSalarie(FormFicheSalarie var1) {
      this.formFicheSalarie = var1;
   }

   public ExercicesPaye getLastExoPaye() {
      return this.lastExoPaye;
   }

   public void setLastExoPaye(ExercicesPaye var1) {
      this.lastExoPaye = var1;
   }

   public long getLeIdExo() {
      return this.leIdExo;
   }

   public void setLeIdExo(long var1) {
      this.leIdExo = var1;
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

   public FormCalculBulletin getFormCalculBulletin() {
      return this.formCalculBulletin;
   }

   public void setFormCalculBulletin(FormCalculBulletin var1) {
      this.formCalculBulletin = var1;
   }

   public FormTransfertBulletin getFormTransfertBulletin() {
      return this.formTransfertBulletin;
   }

   public void setFormTransfertBulletin(FormTransfertBulletin var1) {
      this.formTransfertBulletin = var1;
   }

   public BulletinLigne getBulletinLigne() {
      return this.bulletinLigne;
   }

   public void setBulletinLigne(BulletinLigne var1) {
      this.bulletinLigne = var1;
   }

   public DataModel getDataModelBulletins() {
      return this.dataModelBulletins;
   }

   public void setDataModelBulletins(DataModel var1) {
      this.dataModelBulletins = var1;
   }

   public DataModel getDataModelBulletinsLigne() {
      return this.dataModelBulletinsLigne;
   }

   public void setDataModelBulletinsLigne(DataModel var1) {
      this.dataModelBulletinsLigne = var1;
   }

   public DataModel getDataModelListeBulletins() {
      return this.dataModelListeBulletins;
   }

   public void setDataModelListeBulletins(DataModel var1) {
      this.dataModelListeBulletins = var1;
   }

   public DataModel getDataModelListeRubriques() {
      return this.dataModelListeRubriques;
   }

   public void setDataModelListeRubriques(DataModel var1) {
      this.dataModelListeRubriques = var1;
   }

   public boolean isShowModalPanelBulletin() {
      return this.showModalPanelBulletin;
   }

   public void setShowModalPanelBulletin(boolean var1) {
      this.showModalPanelBulletin = var1;
   }

   public boolean isShowModalPanelListeRubrique() {
      return this.showModalPanelListeRubrique;
   }

   public void setShowModalPanelListeRubrique(boolean var1) {
      this.showModalPanelListeRubrique = var1;
   }

   public BulletinSalaire getBulletinSalaire() {
      return this.bulletinSalaire;
   }

   public void setBulletinSalaire(BulletinSalaire var1) {
      this.bulletinSalaire = var1;
   }

   public boolean isShowModalPanelPrintBulletin() {
      return this.showModalPanelPrintBulletin;
   }

   public void setShowModalPanelPrintBulletin(boolean var1) {
      this.showModalPanelPrintBulletin = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public List getBulletinImpressionItems() {
      return this.bulletinImpressionItems;
   }

   public void setBulletinImpressionItems(List var1) {
      this.bulletinImpressionItems = var1;
   }

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
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

   public FormImpressionPaye getFormImpressionPaye() {
      return this.formImpressionPaye;
   }

   public void setFormImpressionPaye(FormImpressionPaye var1) {
      this.formImpressionPaye = var1;
   }

   public boolean isVar_correction() {
      return this.var_correction;
   }

   public void setVar_correction(boolean var1) {
      this.var_correction = var1;
   }

   public BulletinMois getBulletinMois() {
      return this.bulletinMois;
   }

   public void setBulletinMois(BulletinMois var1) {
      this.bulletinMois = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public FormMissions getFormMissions() {
      return this.formMissions;
   }

   public void setFormMissions(FormMissions var1) {
      this.formMissions = var1;
   }

   public boolean isAccesProjet() {
      return this.accesProjet;
   }

   public void setAccesProjet(boolean var1) {
      this.accesProjet = var1;
   }

   public FormPointage getFormPointage() {
      return this.formPointage;
   }

   public void setFormPointage(FormPointage var1) {
      this.formPointage = var1;
   }

   public int getChargePatronales() {
      return this.chargePatronales;
   }

   public void setChargePatronales(int var1) {
      this.chargePatronales = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public List getMesTiersItems() {
      return this.mesTiersItems;
   }

   public void setMesTiersItems(List var1) {
      this.mesTiersItems = var1;
   }

   public List getMesBudgetsItems() {
      return this.mesBudgetsItems;
   }

   public void setMesBudgetsItems(List var1) {
      this.mesBudgetsItems = var1;
   }

   public FormBilanSocial getFormBilanSocial() {
      return this.formBilanSocial;
   }

   public void setFormBilanSocial(FormBilanSocial var1) {
      this.formBilanSocial = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public FormDocumentsOfficiels getFormDocumentsOfficiels() {
      return this.formDocumentsOfficiels;
   }

   public void setFormDocumentsOfficiels(FormDocumentsOfficiels var1) {
      this.formDocumentsOfficiels = var1;
   }

   public FormPrets getFormPrets() {
      return this.formPrets;
   }

   public void setFormPrets(FormPrets var1) {
      this.formPrets = var1;
   }

   public FormConges getFormConges() {
      return this.formConges;
   }

   public void setFormConges(FormConges var1) {
      this.formConges = var1;
   }

   public int getUploadsAvailable() {
      return this.uploadsAvailable;
   }

   public void setUploadsAvailable(int var1) {
      this.uploadsAvailable = var1;
   }

   public FileCtrl getFileCtrl() {
      return this.fileCtrl;
   }

   public void setFileCtrl(FileCtrl var1) {
      this.fileCtrl = var1;
   }

   public ArrayList getListFiles() {
      return this.listFiles;
   }

   public void setListFiles(ArrayList var1) {
      this.listFiles = var1;
   }

   public String getQuelTransfert() {
      return this.quelTransfert;
   }

   public void setQuelTransfert(String var1) {
      this.quelTransfert = var1;
   }

   public FormPreparation getFormPreparation() {
      return this.formPreparation;
   }

   public void setFormPreparation(FormPreparation var1) {
      this.formPreparation = var1;
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

   public List getMesBuletinsSalarieItems() {
      return this.mesBuletinsSalarieItems;
   }

   public void setMesBuletinsSalarieItems(List var1) {
      this.mesBuletinsSalarieItems = var1;
   }

   public String getPeriodeBulletin() {
      return this.periodeBulletin;
   }

   public void setPeriodeBulletin(String var1) {
      this.periodeBulletin = var1;
   }

   public FormCvAnalyse getFormCvAnalyse() {
      return this.formCvAnalyse;
   }

   public void setFormCvAnalyse(FormCvAnalyse var1) {
      this.formCvAnalyse = var1;
   }
}
