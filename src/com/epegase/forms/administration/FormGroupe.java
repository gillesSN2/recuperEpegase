package com.epegase.forms.administration;

import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.GroupeChrono;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.Module;
import com.epegase.systeme.dao.BalDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.GroupeChronoDao;
import com.epegase.systeme.dao.GroupeDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureModeleAutorise;
import com.epegase.systeme.xml.LectureModulesFonctions;
import com.epegase.systeme.xml.LectureModulesOnglets;
import com.epegase.systeme.xml.LectureModulesTiers;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormGroupe implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private String lien;
   private UserDao userDao;
   private GroupeDao groupeDao;
   private Groupe groupe;
   private Module module;
   private String module_commercial;
   private boolean existeCode = true;
   private transient ListDataModel datamodelGroupes;
   private List listeGroupes;
   private transient ListDataModel datamodelModules;
   private List listeModules = new ArrayList();
   private transient ListDataModel datamodelFonctions;
   private List listeFonctions;
   private transient ListDataModel datamodelOnglets;
   private List listeOnglets;
   private boolean afficheGroupe = false;
   private boolean showModalPanelGroupe = false;
   private boolean affMail = false;
   private LectureModulesFonctions lectureModulesFonctions;
   private LectureModulesOnglets lectureModulesOnglets;
   private LectureModulesTiers lectureModulesTiers;
   private Element racine;
   private Document document;
   private ObjetLigneMenu objetLigneMenu = new ObjetLigneMenu();
   private ObjetLigneOnglet objetLigneOnglet;
   private boolean afficheGroupebal = false;
   private Bal bal = new Bal();
   private BalDao balDao;
   private List lesBal = new ArrayList();
   private transient DataModel dataModelBal = new ListDataModel();
   private boolean var_existMail = false;
   private boolean visibleBal = false;
   private boolean var_valide_bal = false;
   private boolean showModalPanelBal = false;
   private boolean var_mod_free = false;
   private boolean var_mod_tiers = false;
   private boolean var_mod_office = false;
   private boolean var_mod_achats = false;
   private boolean var_mod_stock = false;
   private boolean var_mod_ventes = false;
   private boolean var_mod_caisse = false;
   private boolean var_mod_parc = false;
   private boolean var_mod_paye = false;
   private boolean var_mod_compta = false;
   private boolean var_mod_medical = false;
   private boolean var_mod_edu = false;
   private boolean var_mod_mef = false;
   private boolean var_mod_rep = false;
   private boolean showModalPanelPropriete = false;
   private transient DataModel datamodelUsersChronoOff = new ListDataModel();
   private List groupeChronoListOff = new ArrayList();
   private transient DataModel datamodelUsersChronoAch = new ListDataModel();
   private List groupeChronoListAch = new ArrayList();
   private transient DataModel datamodelUsersChronoVte = new ListDataModel();
   private List usersChronoListVte = new ArrayList();
   private transient DataModel datamodelUsersChronoMed = new ListDataModel();
   private List usersChronoListMed = new ArrayList();
   private transient DataModel datamodelUsersChronoPaye = new ListDataModel();
   private List usersChronoListPaye = new ArrayList();
   private transient DataModel datamodelUsersChronoCaiss = new ListDataModel();
   private List usersChronoListCaiss = new ArrayList();
   private transient DataModel datamodelUsersChronoFree = new ListDataModel();
   private List usersChronoListFree = new ArrayList();
   private boolean visibiliteBtonOff = false;
   private boolean visibiliteBtonCaiss = false;
   private boolean visibiliteBtonAch = false;
   private boolean visibiliteBtonVte = false;
   private boolean visibiliteBtonPaye = false;
   private int var_action;
   private Chrono chrono;
   private ChronoDao chronoDao;
   private GroupeChrono groupeChrono;
   private GroupeChronoDao groupeChronoDao;
   private String inputChronoOff;
   private int var_action_chronoOff;
   private boolean var_aff_val_chronoOff = false;
   private boolean showModalPanelOffice = false;
   private boolean testSelectSerieOff = false;
   private boolean showModalPanelAchat = false;
   private boolean testSelectSerieAch = false;
   private String inputChronoAch;
   private int var_action_chronoAch;
   private boolean var_aff_val_chronoAch = false;
   private String depot;
   private String inputChronoVte;
   private int var_action_chronoVte;
   private boolean var_aff_val_chronoVte = false;
   private boolean showModalPanelVente = false;
   private boolean testSelectSerieVte = false;
   private String inputChronoCaisse;
   private int var_action_chronoCaisse;
   private boolean var_aff_val_chronoCaisse = false;
   private boolean showModalPanelCaisse = false;
   private boolean testSelectSerieCaiss = false;
   private String inputChronoPaye;
   private int var_action_chronoPaye;
   private boolean var_aff_val_chronoPaye = false;
   private boolean showModalPanelPaye = false;
   private boolean testSelectSeriePaye = false;
   private String inputChronoMed;
   private int var_action_chronoMed;
   private boolean var_aff_val_chronoMed = false;
   private boolean showModalPanelMedical = false;
   private boolean testSelectSerieMed = false;
   private boolean visibiliteBtonMed = false;
   private List mesChronoPayeItems;
   private List mesChronoCaisseItems;
   private List mesDepotsItems = new ArrayList();
   private List mesChronoAchatsItems;
   private List mesChronoVentesItems;
   private List mesChronoOfficeItems;
   private List mesChronoMedicalItems;
   private List mesChronoEduItems;
   private List mesChronoMefItems;
   private transient DataModel datamodelUser = new ListDataModel();
   private List listUsers = new ArrayList();
   private Users usersEnCours;
   private boolean var_visibleBouton = false;
   private boolean showModalPanelChangeGroupe = false;
   private List mesGroupeChangeItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private List mesEquipesItems = new ArrayList();
   private String nouveauGroupe;
   private String nouveauService;
   private long nouvelleEquipe;
   private int nouveauRecu;
   private int nouveauFactureCaisse;
   private ServiceDao serviceDao;
   private EquipesDao equipesDao;
   private List listCaisses = new ArrayList();
   private CaissesCommercialesDao caissesCommercialesDao;
   private List listCaissesUser = new ArrayList();
   private UsersChronoDao usersChronoDao;
   private LectureModeleAutorise lectureModeleAutorise;
   private boolean showModalPanelModele = false;
   private List listImpPaye = new ArrayList();
   private List listImpPayeUtil = new ArrayList();
   private transient DataModel datamodelModelPaye = new ListDataModel();
   private transient DataModel datamodelModelPayeUtil = new ListDataModel();
   private List listImpCompta = new ArrayList();
   private List listImpComptaUtil = new ArrayList();
   private transient DataModel datamodelModelCompta = new ListDataModel();
   private transient DataModel datamodelModelComptaUtil = new ListDataModel();
   private List listImpAchats = new ArrayList();
   private List listImpAchatsUtil = new ArrayList();
   private transient DataModel datamodelModelAchats = new ListDataModel();
   private transient DataModel datamodelModelAchatsUtil = new ListDataModel();
   private List listImpVentes = new ArrayList();
   private List listImpVentesUtil = new ArrayList();
   private transient DataModel datamodelModelVentes = new ListDataModel();
   private transient DataModel datamodelModelVentesUtil = new ListDataModel();
   private List listImpCaisses = new ArrayList();
   private List listImpCaissesUtil = new ArrayList();
   private transient DataModel datamodelModelCaisses = new ListDataModel();
   private transient DataModel datamodelModelCaissesUtil = new ListDataModel();
   private List listImpParc = new ArrayList();
   private List listImpParcUtil = new ArrayList();
   private transient DataModel datamodelModelParc = new ListDataModel();
   private transient DataModel datamodelModelParcUtil = new ListDataModel();
   private List listImpStocks = new ArrayList();
   private List listImpStocksUtil = new ArrayList();
   private transient DataModel datamodelModelStocks = new ListDataModel();
   private transient DataModel datamodelModelStocksUtil = new ListDataModel();
   private List listImpMedical = new ArrayList();
   private List listImpMedicalUtil = new ArrayList();
   private transient DataModel datamodelModelMedical = new ListDataModel();
   private transient DataModel datamodelModelMedicalUtil = new ListDataModel();
   private List listImpEducation = new ArrayList();
   private List listImpEducationUtil = new ArrayList();
   private transient DataModel datamodelModelEducation = new ListDataModel();
   private transient DataModel datamodelModelEducationUtil = new ListDataModel();
   private List listImpMicrofinance = new ArrayList();
   private List listImpMicrofinanceUtil = new ArrayList();
   private transient DataModel datamodelModelMicrofinance = new ListDataModel();
   private transient DataModel datamodelModelMicrofinanceUtil = new ListDataModel();
   private List listImpOffice = new ArrayList();
   private List listImpOfficeUtil = new ArrayList();
   private transient DataModel datamodelModelOffice = new ListDataModel();
   private transient DataModel datamodelModelOfficeUtil = new ListDataModel();
   private List listImpTiers = new ArrayList();
   private List listImpTiersUtil = new ArrayList();
   private transient DataModel datamodelModelTiers = new ListDataModel();
   private transient DataModel datamodelModelTiersUtil = new ListDataModel();
   private List listImpReporting = new ArrayList();
   private List listImpReportingUtil = new ArrayList();
   private transient DataModel datamodelModelReporting = new ListDataModel();
   private transient DataModel datamodelModelReportingUtil = new ListDataModel();
   private List lesStructuresPeg;

   public void InstancesDaoUtilses() {
      this.groupeDao = new GroupeDao(this.baseLog, this.utilInitHibernate);
      this.groupeChronoDao = new GroupeChronoDao(this.baseLog, this.utilInitHibernate);
      this.balDao = new BalDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesDepots(Session var1) throws IOException, HibernateException, NamingException, ParseException {
      ExercicesAchatsDao var2 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      new ExercicesAchats();
      ExercicesAchats var3 = var2.recupererLastExo(var1);
      if (var3 != null) {
         new ArrayList();
         DepotAchatsDao var5 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         List var4 = var5.selectActifDepot(0, var1);
         if (var4.size() != 0) {
            for(int var6 = 0; var6 < var4.size(); ++var6) {
               this.mesDepotsItems.add(new SelectItem(((DepotAchats)var4.get(var6)).getDpoCode() + ":" + ((DepotAchats)var4.get(var6)).getDpoLibelle()));
            }
         }
      }

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

   public void chargerLesChronoPaye(Session var1) throws HibernateException, NamingException {
      this.mesChronoPayeItems = this.chronoDao.selectListPayeItem(var1);
   }

   public void chargerLesChronoMedical(Session var1) throws HibernateException, NamingException {
      this.mesChronoMedicalItems = this.chronoDao.selectListMedicalItem(var1);
   }

   public void chargerLesChronoEdu(Session var1) throws HibernateException, NamingException {
      this.mesChronoEduItems = this.chronoDao.selectListEduItem(var1);
   }

   public void chargerLesChronoMef(Session var1) throws HibernateException, NamingException {
      this.mesChronoMefItems = this.chronoDao.selectListMefItem(var1);
   }

   public void lesGroupes(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
      this.listeModules = new ArrayList();
      this.datamodelModules = new ListDataModel();
      this.listeFonctions = new ArrayList();
      this.datamodelFonctions = new ListDataModel();
      this.listeOnglets = new ArrayList();
      this.datamodelOnglets = new ListDataModel();
      this.listeGroupes = new ArrayList();
      this.datamodelGroupes = new ListDataModel();
      this.module_commercial = this.localisationModule("8");
      this.listeGroupes = this.groupeDao.selectGroupe(var1);
      this.datamodelGroupes.setWrappedData(this.listeGroupes);
      this.usersEnCours = new Users();
   }

   public void ajouterGroupe() {
      this.groupe = new Groupe();
      this.existeCode = true;
      this.calculeOptions();
      this.showModalPanelGroupe = true;
   }

   public void modifierGroupe() {
      if (this.groupe != null) {
         this.existeCode = false;
         this.calculeOptions();
         this.showModalPanelGroupe = true;
      }

   }

   public void calculeOptions() {
      this.var_mod_free = true;
      this.var_mod_tiers = true;
      this.var_mod_office = true;
      this.var_mod_achats = false;
      this.var_mod_stock = false;
      this.var_mod_ventes = false;
      this.var_mod_caisse = false;
      this.var_mod_parc = false;
      this.var_mod_paye = false;
      this.var_mod_compta = false;
      this.var_mod_medical = false;
      this.var_mod_edu = false;
      this.var_mod_mef = false;
      this.var_mod_rep = false;
      if (this.structureLog.getStrmaitrecabinet() == 1) {
         this.var_mod_achats = true;
         this.var_mod_stock = true;
         this.var_mod_ventes = true;
         this.var_mod_caisse = true;
         this.var_mod_parc = true;
         this.var_mod_paye = true;
         this.var_mod_compta = true;
      } else {
         if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
            this.libModules(this.structureLog.getStrmod1());
         }

         if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
            this.libModules(this.structureLog.getStrmod2());
         }

         if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
            this.libModules(this.structureLog.getStrmod3());
         }

         if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
            this.libModules(this.structureLog.getStrmod4());
         }

         if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
            this.libModules(this.structureLog.getStrmod5());
         }

         if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
            this.libModules(this.structureLog.getStrmod6());
         }

         if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
            this.libModules(this.structureLog.getStrmod7());
         }

         if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
            this.libModules(this.structureLog.getStrmod8());
         }

         if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty()) {
            this.libModules(this.structureLog.getStrmod9());
         }

         if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
            this.libModules(this.structureLog.getStrmod10());
         }
      }

   }

   public void modifierPropriete() {
      if (this.groupe != null) {
         this.existeCode = false;
         this.calculeOptions();
         this.showModalPanelPropriete = true;
      }

   }

   public void supprimerGroupe() throws HibernateException, NamingException {
      if (this.groupe != null) {
         this.groupeDao.deleteGroupe(this.groupe.getGrpCode());
         this.listeGroupes = this.groupeDao.selectGroupe((Session)null);
         this.datamodelGroupes.setWrappedData(this.listeGroupes);
         this.afficheGroupe = false;
      }

   }

   public void annuleGroupe() {
      this.showModalPanelGroupe = false;
      this.afficheGroupe = false;
   }

   public void annulePropriete() {
      this.showModalPanelPropriete = false;
      this.afficheGroupe = false;
   }

   public void verifCodeExist() throws HibernateException, NamingException {
      this.existeCode = this.groupeDao.existCodeGroupe(this.groupe.getGrpCode());
   }

   public void saveGroupe() throws HibernateException, NamingException {
      if (this.groupe.getGrpLibelle() == null || this.groupe.getGrpLibelle().isEmpty()) {
         this.groupe.setGrpLibelle("Groupe : " + this.groupe.getGrpCode());
      }

      if (this.groupe.getGrpModuleFree() == 1) {
         this.groupe.setGrpModuleAch(0);
         this.groupe.setGrpModuleCai(0);
         this.groupe.setGrpModuleCpt(0);
         this.groupe.setGrpModuleEdu(0);
         this.groupe.setGrpModuleGuest(0);
         this.groupe.setGrpModuleMed(0);
         this.groupe.setGrpModuleOff(0);
         this.groupe.setGrpModulePay(0);
         this.groupe.setGrpModulePrc(0);
         this.groupe.setGrpModuleStk(0);
         this.groupe.setGrpModuleTie(0);
         this.groupe.setGrpModuleVte(0);
         this.groupe.setGrpModuleRep(0);
      } else {
         this.groupe.setGrpModuleFree(0);
      }

      if (this.groupe.getGrpId() == 0L) {
         this.groupe = this.groupeDao.insertGroupe(this.groupe);
         this.listeGroupes.add(this.groupe);
         this.datamodelGroupes.setWrappedData(this.listeGroupes);
      } else {
         this.groupe = this.groupeDao.miseAjourGroupe(this.groupe);
      }

      if (this.lesStructuresPeg.size() != 0) {
         this.majGroupeStructure();
      }

      this.showModalPanelGroupe = false;
      this.afficheGroupe = false;
   }

   public void majGroupeStructure() throws HibernateException, NamingException {
      new Groupe();

      for(int var2 = 0; var2 < this.lesStructuresPeg.size(); ++var2) {
         this.groupeDao = new GroupeDao("structure" + ((StructurePeg)this.lesStructuresPeg.get(var2)).getStrId(), this.utilInitHibernate);
         Groupe var1 = this.groupeDao.groupeByCode(this.groupe.getGrpCode(), (Session)null);
         if (var1 == null) {
            var1 = new Groupe();
         }

         var1.setGrpAccesBrouillard(this.groupe.getGrpAccesBrouillard());
         var1.setGrpAccesCorrection(this.groupe.getGrpAccesCorrection());
         var1.setGrpAccesMail(this.groupe.getGrpAccesMail());
         var1.setGrpAchLibelle(this.groupe.getGrpAchLibelle());
         var1.setGrpAchPump(this.groupe.getGrpAchPump());
         var1.setGrpAchats(this.groupe.getGrpAchats());
         var1.setGrpAcheteur(this.groupe.getGrpAcheteur());
         var1.setGrpAffPlancher(this.groupe.getGrpAffPlancher());
         var1.setGrpAffPump(this.groupe.getGrpAffPump());
         var1.setGrpAffPvMarche(this.groupe.getGrpAffPvMarche());
         var1.setGrpCaissier(this.groupe.getGrpCaissier());
         var1.setGrpCaissierDelete(this.groupe.getGrpCaissierDelete());
         var1.setGrpCaissierDepense(this.groupe.getGrpCaissierDepense());
         var1.setGrpCaissierModif(this.groupe.getGrpCaissierModif());
         var1.setGrpCaissierRecette(this.groupe.getGrpCaissierRecette());
         var1.setGrpCaissierService(this.groupe.getGrpCaissierService());
         var1.setGrpCaissierTransfert(this.groupe.getGrpCaissierTransfert());
         var1.setGrpCode(this.groupe.getGrpCode());
         var1.setGrpCommAchats(this.groupe.getGrpCommAchats());
         var1.setGrpCommPourcentage(this.groupe.getGrpCommPourcentage());
         var1.setGrpCommType(this.groupe.getGrpCommType());
         var1.setGrpCommVentes(this.groupe.getGrpCommVentes());
         var1.setGrpCptInterdit(this.groupe.getGrpCptInterdit());
         var1.setGrpCreationSociete(this.groupe.getGrpCreationSociete());
         var1.setGrpDateAch(this.groupe.getGrpDateAch());
         var1.setGrpDateCai(this.groupe.getGrpDateCai());
         var1.setGrpDateLivre(this.groupe.getGrpDateLivre());
         var1.setGrpDateMed(this.groupe.getGrpDateMed());
         var1.setGrpDatePrc(this.groupe.getGrpDatePrc());
         var1.setGrpDateStk(this.groupe.getGrpDateStk());
         var1.setGrpDateVte(this.groupe.getGrpDateVte());
         var1.setGrpDemandeurAchats(this.groupe.getGrpDemandeurAchats());
         var1.setGrpDepotSel(this.groupe.getGrpDepotSel());
         var1.setGrpFactureCaisse(this.groupe.getGrpFactureCaisse());
         var1.setGrpImputCai(this.groupe.getGrpImputCai());
         var1.setGrpJrxInterdit(this.groupe.getGrpJrxInterdit());
         var1.setGrpJrxReserve(this.groupe.getGrpJrxReserve());
         var1.setGrpLibelle(this.groupe.getGrpLibelle());
         var1.setGrpLie(this.groupe.getGrpLie());
         var1.setGrpMail(this.groupe.getGrpMail());
         var1.setGrpMailCopie(this.groupe.getGrpMailCopie());
         var1.setGrpMailParapheur(this.groupe.getGrpMailParapheur());
         var1.setGrpMedical(this.groupe.getGrpMedical());
         var1.setGrpMedicalService(this.groupe.getGrpMedicalService());
         var1.setGrpMf(this.groupe.getGrpMf());
         var1.setGrpModifLiasse(this.groupe.getGrpModifLiasse());
         var1.setGrpModifSerieAch(this.groupe.getGrpModifSerieAch());
         var1.setGrpModifSerieVte(this.groupe.getGrpModifSerieVte());
         var1.setGrpModuleAch(this.groupe.getGrpModuleAch());
         var1.setGrpModuleCai(this.groupe.getGrpModuleCai());
         var1.setGrpModuleCpt(this.groupe.getGrpModuleCpt());
         var1.setGrpModuleEdu(this.groupe.getGrpModuleEdu());
         var1.setGrpModuleFree(this.groupe.getGrpModuleFree());
         var1.setGrpModuleGuest(this.groupe.getGrpModuleGuest());
         var1.setGrpModuleMed(this.groupe.getGrpModuleMed());
         var1.setGrpModuleMef(this.groupe.getGrpModuleMef());
         var1.setGrpModuleOff(this.groupe.getGrpModuleOff());
         var1.setGrpModulePay(this.groupe.getGrpModulePay());
         var1.setGrpModulePrc(this.groupe.getGrpModulePrc());
         var1.setGrpModuleRep(this.groupe.getGrpModuleRep());
         var1.setGrpModuleStk(this.groupe.getGrpModuleStk());
         var1.setGrpModuleTie(this.groupe.getGrpModuleTie());
         var1.setGrpModuleVte(this.groupe.getGrpModuleVte());
         var1.setGrpMontantCai(this.groupe.getGrpMontantCai());
         var1.setGrpParcAlerte(this.groupe.getGrpParcAlerte());
         var1.setGrpPayPointage(this.groupe.getGrpPayPointage());
         var1.setGrpPaye(this.groupe.getGrpPaye());
         var1.setGrpPayeAlerte(this.groupe.getGrpPayeAlerte());
         var1.setGrpPayeBulletin(this.groupe.getGrpPayeBulletin());
         var1.setGrpPayeContrat(this.groupe.getGrpPayeContrat());
         var1.setGrpPayeService(this.groupe.getGrpPayeService());
         var1.setGrpPlanning(this.groupe.getGrpPlanning());
         var1.setGrpPlanningService(this.groupe.getGrpPlanningService());
         var1.setGrpPr(this.groupe.getGrpPr());
         var1.setGrpProdService(this.groupe.getGrpProdService());
         var1.setGrpProdServiceAch(this.groupe.getGrpProdServiceAch());
         var1.setGrpRecus(this.groupe.getGrpRecus());
         var1.setGrpRespAchats(this.groupe.getGrpRespAchats());
         var1.setGrpResponsableVentes(this.groupe.getGrpResponsableVentes());
         var1.setGrpService(this.groupe.getGrpService());
         var1.setGrpSignatureAchats(this.groupe.getGrpSignatureAchats());
         var1.setGrpSignatureCaisse(this.groupe.getGrpSignatureCaisse());
         var1.setGrpSignatureCompta(this.groupe.getGrpSignatureCompta());
         var1.setGrpSignatureEducation(this.groupe.getGrpSignatureEducation());
         var1.setGrpSignatureMedical(this.groupe.getGrpSignatureMedical());
         var1.setGrpSignatureMicroFinance(this.groupe.getGrpSignatureMicroFinance());
         var1.setGrpSignatureOffice(this.groupe.getGrpSignatureOffice());
         var1.setGrpSignatureParc(this.groupe.getGrpSignatureParc());
         var1.setGrpSignaturePaye(this.groupe.getGrpSignaturePaye());
         var1.setGrpSignatureVentes(this.groupe.getGrpSignatureVentes());
         var1.setGrpTiers(this.groupe.getGrpTiers());
         var1.setGrpTiersCai(this.groupe.getGrpTiersCai());
         var1.setGrpVendeur(this.groupe.getGrpVendeur());
         var1.setGrpVentes(this.groupe.getGrpVentes());
         var1.setGrpVerPaAch(this.groupe.getGrpVerPaAch());
         var1.setGrpVerPv(this.groupe.getGrpVerPv());
         var1.setGrpVerRabais(this.groupe.getGrpVerRabais());
         var1.setGrpVerRabaisAch(this.groupe.getGrpVerRabaisAch());
         var1.setGrpVerRemise(this.groupe.getGrpVerRemise());
         var1.setGrpVerRemiseAch(this.groupe.getGrpVerRemiseAch());
         var1.setGrpVteLibelle(this.groupe.getGrpVteLibelle());
         if (var1.getGrpId() == 0L) {
            this.groupeDao.insertGroupe(var1);
         } else {
            this.groupeDao.miseAjourGroupe(var1);
         }
      }

   }

   public void savePropriete() throws HibernateException, NamingException {
      if (this.groupe != null) {
         this.groupe = this.groupeDao.miseAjourGroupe(this.groupe);
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.groupeChrono = new GroupeChrono();
            int var3;
            if (this.groupeChronoListOff.size() != 0) {
               for(var3 = 0; var3 < this.groupeChronoListOff.size(); ++var3) {
                  this.groupeChrono = (GroupeChrono)this.groupeChronoListOff.get(var3);
                  if (this.groupeChrono.getGrpchrId() == 0L) {
                     this.groupeChrono.setGroupe(this.groupe);
                     this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateCreat(new Date());
                     this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
                  } else {
                     this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateModif(new Date());
                     this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
                  }
               }
            }

            if (this.groupeChronoListAch.size() != 0) {
               for(var3 = 0; var3 < this.groupeChronoListAch.size(); ++var3) {
                  this.groupeChrono = (GroupeChrono)this.groupeChronoListAch.get(var3);
                  if (this.groupeChrono.getGrpchrId() == 0L) {
                     this.groupeChrono.setGroupe(this.groupe);
                     this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateCreat(new Date());
                     this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
                  } else {
                     this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateModif(new Date());
                     this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
                  }
               }
            }

            if (this.usersChronoListCaiss.size() != 0) {
               for(var3 = 0; var3 < this.usersChronoListCaiss.size(); ++var3) {
                  this.groupeChrono = (GroupeChrono)this.usersChronoListCaiss.get(var3);
                  if (this.groupeChrono.getGrpchrId() == 0L) {
                     this.groupeChrono.setGroupe(this.groupe);
                     this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateCreat(new Date());
                     this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
                  } else {
                     this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateModif(new Date());
                     this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
                  }
               }
            }

            if (this.usersChronoListFree.size() != 0) {
               for(var3 = 0; var3 < this.usersChronoListFree.size(); ++var3) {
                  this.groupeChrono = (GroupeChrono)this.usersChronoListFree.get(var3);
                  if (this.groupeChrono.getGrpchrId() == 0L) {
                     this.groupeChrono.setGroupe(this.groupe);
                     this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateCreat(new Date());
                     this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
                  } else {
                     this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateModif(new Date());
                     this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
                  }
               }
            }

            if (this.usersChronoListMed.size() != 0) {
               for(var3 = 0; var3 < this.usersChronoListMed.size(); ++var3) {
                  this.groupeChrono = (GroupeChrono)this.usersChronoListMed.get(var3);
                  if (this.groupeChrono.getGrpchrId() == 0L) {
                     this.groupeChrono.setGroupe(this.groupe);
                     this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateCreat(new Date());
                     this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
                  } else {
                     this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateModif(new Date());
                     this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
                  }
               }
            }

            if (this.usersChronoListPaye.size() != 0) {
               for(var3 = 0; var3 < this.usersChronoListPaye.size(); ++var3) {
                  this.groupeChrono = (GroupeChrono)this.usersChronoListPaye.get(var3);
                  if (this.groupeChrono.getGrpchrId() == 0L) {
                     this.groupeChrono.setGroupe(this.groupe);
                     this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateCreat(new Date());
                     this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
                  } else {
                     this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateModif(new Date());
                     this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
                  }
               }
            }

            if (this.usersChronoListVte.size() != 0) {
               for(var3 = 0; var3 < this.usersChronoListVte.size(); ++var3) {
                  this.groupeChrono = (GroupeChrono)this.usersChronoListVte.get(var3);
                  if (this.groupeChrono.getGrpchrId() == 0L) {
                     this.groupeChrono.setGroupe(this.groupe);
                     this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateCreat(new Date());
                     this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
                  } else {
                     this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
                     this.groupeChrono.setGrpchrDateModif(new Date());
                     this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
                  }
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

      if (this.lesStructuresPeg.size() != 0) {
      }

      this.showModalPanelPropriete = false;
      this.afficheGroupe = false;
   }

   public void balGroupes() {
      if (this.groupe != null) {
         this.afficheGroupebal = true;
      }

   }

   public void selectionGroupe() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelGroupes.isRowAvailable()) {
         this.groupe = (Groupe)this.datamodelGroupes.getRowData();
         this.rechercheModuleGroupe();
         if (this.groupe.getGrpModuleFree() == 1) {
            this.selectionModules();
         } else {
            this.localisationModule("8");
            this.lectureFonctions();
            this.lectureOnglets();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
         this.chargerlesGroupesChronosOff(var1);
         this.chargerlesGroupesChronosAch(var1);
         this.chargerlesGroupesChronosVte(var1);
         this.chargerlesGroupesChronosCaisse(var1);
         this.chargerlesGroupesChronosPaye(var1);
         this.chargerlesGroupesChronosMed(var1);
         this.chargerlesGroupesUsers(var1);
         if (this.groupe.getGrpModuleFree() == 1) {
            this.chargerlesGroupesChronosFree(var1);
         }

         this.utilInitHibernate.closeSession();
         this.afficheGroupe = true;
         this.listeFonctions.clear();
         this.datamodelFonctions.setWrappedData(this.listeFonctions);
         this.listeOnglets.clear();
         this.datamodelOnglets.setWrappedData(this.listeOnglets);
      }

   }

   public void selectionModules() throws JDOMException, IOException {
      if (this.datamodelModules.isRowAvailable()) {
         this.module = (Module)this.datamodelModules.getRowData();
         if (this.groupe.getGrpCode() != null && !this.groupe.getGrpCode().isEmpty()) {
            if (this.module.getCode1().equalsIgnoreCase("10500")) {
               this.lecturesModules();
            } else if (this.module.getCode1().equalsIgnoreCase("30000")) {
               this.lectureTiers();
            } else {
               this.lectureFonctions();
            }

            this.lectureOnglets();
         }
      }

   }

   public void lectureFonctions() throws JDOMException, IOException {
      if (this.module != null && this.groupe != null) {
         this.lectureModulesFonctions = new LectureModulesFonctions();
         this.lectureModulesFonctions.setStrId(this.structureLog.getStrid());
         this.lectureModulesFonctions.setStructureLog(this.structureLog);
         this.listeFonctions = this.lectureModulesFonctions.chargerMesFonctionsAll(this.module.getCode1(), this.groupe.getGrpCode());
         this.datamodelFonctions.setWrappedData(this.listeFonctions);
      }

   }

   public void lectureOnglets() throws JDOMException, IOException {
      if (this.module != null && this.groupe != null) {
         this.lectureModulesOnglets = new LectureModulesOnglets();
         this.lectureModulesOnglets.setStrId(this.structureLog.getStrid());
         this.lectureModulesOnglets.setStructureLog(this.structureLog);
         this.listeOnglets = this.lectureModulesOnglets.chargerMesOngletsAll(this.module.getCode1(), this.groupe.getGrpCode());
         this.datamodelOnglets.setWrappedData(this.listeOnglets);
      }

   }

   public void lectureTiers() throws JDOMException, IOException {
      if (this.module_commercial != null && this.groupe != null) {
         this.lectureModulesTiers = new LectureModulesTiers();
         this.lectureModulesTiers.setStrId(this.structureLog.getStrid());
         this.lectureModulesTiers.setStructureLog(this.structureLog);
         this.listeFonctions = this.lectureModulesTiers.chargerMesTiersAll(this.module_commercial, this.groupe.getGrpCode());
         this.datamodelFonctions.setWrappedData(this.listeFonctions);
      }

   }

   public void lecturesModules() throws JDOMException, IOException {
      this.lectureModulesFonctions = new LectureModulesFonctions();
      this.lectureModulesFonctions.setStrId(this.structureLog.getStrid());
      this.lectureModulesFonctions.setStructureLog(this.structureLog);
      this.listeFonctions.clear();
      new ArrayList();
      List var1 = this.lectureModulesFonctions.chargerMesFonctionsAll("10500", this.groupe.getGrpCode());
      int var2;
      if (var1.size() >= 2) {
         for(var2 = 0; var2 < var1.size(); ++var2) {
            this.listeFonctions.add(var1.get(var2));
         }
      } else {
         var1.clear();
         this.lectureModulesTiers = new LectureModulesTiers();
         this.lectureModulesTiers.setStrId(this.structureLog.getStrid());
         this.lectureModulesTiers.setStructureLog(this.structureLog);
         var1 = this.lectureModulesTiers.chargerMesTiersSt(this.module_commercial);
         if (var1.size() != 0) {
            for(var2 = 0; var2 < var1.size(); ++var2) {
               this.listeFonctions.add(var1.get(var2));
            }
         }

         if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
            var1 = this.lectureModulesFonctions.chargerMesFonctionsDefaut(this.structureLog.getStrmod1());
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.listeFonctions.add(var1.get(var2));
               }
            }

            this.chargerleStock(var1, this.structureLog.getStrmod1());
         }

         if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
            var1 = this.lectureModulesFonctions.chargerMesFonctionsDefaut(this.structureLog.getStrmod2());
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.listeFonctions.add(var1.get(var2));
               }
            }

            this.chargerleStock(var1, this.structureLog.getStrmod2());
         }

         if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
            var1 = this.lectureModulesFonctions.chargerMesFonctionsDefaut(this.structureLog.getStrmod3());
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.listeFonctions.add(var1.get(var2));
               }
            }

            this.chargerleStock(var1, this.structureLog.getStrmod3());
         }

         if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
            var1 = this.lectureModulesFonctions.chargerMesFonctionsDefaut(this.structureLog.getStrmod4());
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.listeFonctions.add(var1.get(var2));
               }
            }

            this.chargerleStock(var1, this.structureLog.getStrmod4());
         }

         if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
            var1 = this.lectureModulesFonctions.chargerMesFonctionsDefaut(this.structureLog.getStrmod5());
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.listeFonctions.add(var1.get(var2));
               }
            }

            this.chargerleStock(var1, this.structureLog.getStrmod5());
         }

         if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
            var1 = this.lectureModulesFonctions.chargerMesFonctionsDefaut(this.structureLog.getStrmod6());
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.listeFonctions.add(var1.get(var2));
               }
            }

            this.chargerleStock(var1, this.structureLog.getStrmod6());
         }

         if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
            var1 = this.lectureModulesFonctions.chargerMesFonctionsDefaut(this.structureLog.getStrmod7());
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.listeFonctions.add(var1.get(var2));
               }
            }

            this.chargerleStock(var1, this.structureLog.getStrmod7());
         }

         if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
            var1 = this.lectureModulesFonctions.chargerMesFonctionsDefaut(this.structureLog.getStrmod8());
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.listeFonctions.add(var1.get(var2));
               }
            }

            this.chargerleStock(var1, this.structureLog.getStrmod8());
         }

         if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty()) {
            var1 = this.lectureModulesFonctions.chargerMesFonctionsDefaut(this.structureLog.getStrmod9());
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.listeFonctions.add(var1.get(var2));
               }
            }

            this.chargerleStock(var1, this.structureLog.getStrmod9());
         }

         if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
            var1 = this.lectureModulesFonctions.chargerMesFonctionsDefaut(this.structureLog.getStrmod10());
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.listeFonctions.add(var1.get(var2));
               }
            }

            this.chargerleStock(var1, this.structureLog.getStrmod10());
         }
      }

      this.datamodelFonctions.setWrappedData(this.listeFonctions);
   }

   public void chargerleStock(List var1, String var2) throws JDOMException, IOException {
      if (var2.equals("60000") || var2.equals("60010") || var2.equals("60020")) {
         var1 = this.lectureModulesFonctions.chargerMesFonctionsDefaut("60100");
         if (var1.size() != 0) {
            for(int var3 = 0; var3 < var1.size(); ++var3) {
               this.listeFonctions.add(var1.get(var3));
            }
         }
      }

   }

   public void chargerlesGroupesUsers(Session var1) throws HibernateException, NamingException {
      this.listUsers.clear();
      this.listUsers = this.userDao.selectUserGroupActif(this.groupe, var1);
      this.datamodelUser.setWrappedData(this.listUsers);
   }

   public void chargerlesServices(Session var1) throws HibernateException, NamingException {
      this.mesServicesItems.clear();
      if (this.serviceDao == null) {
         this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      }

      this.mesServicesItems = this.serviceDao.chargerLesServicesItems(9, false, var1);
   }

   public void chargerlesEquipes(Session var1) throws HibernateException, NamingException {
      this.mesEquipesItems.clear();
      if (this.equipesDao == null) {
         this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      }

      this.mesEquipesItems = this.equipesDao.chargerLesEquipesById(var1);
   }

   public void chargerlesCaisses(Session var1) throws HibernateException, NamingException {
      this.listCaisses.clear();
      this.listCaissesUser.clear();
      if (this.caissesCommercialesDao == null) {
         this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      }

      this.listCaisses = this.caissesCommercialesDao.selectActifCaisse(this.usersEnCours.getUsrJrxReserve(), var1);
      if (this.usersChronoDao == null) {
         this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      }

      this.listCaissesUser = this.usersChronoDao.selectListCaisseByUser(this.usersEnCours, var1);
      if (this.listCaissesUser.size() != 0) {
         for(int var2 = 0; var2 < this.listCaissesUser.size(); ++var2) {
            String var3 = ((UsersChrono)this.listCaissesUser.get(var2)).getUsrchrCodeCaisse();
            if (var3 != null && !var3.isEmpty()) {
               new CaissesCommerciales();

               for(int var5 = 0; var5 < this.listCaisses.size(); ++var5) {
                  CaissesCommerciales var4 = (CaissesCommerciales)this.listCaisses.get(var5);
                  if (var4.getCaiCode().equals(var3) && ((UsersChrono)this.listCaissesUser.get(var2)).getUsrchrNature() == 60) {
                     var4.setCaisseSelected(true);
                  } else if (var4.getCaiCode().equals(var3) && ((UsersChrono)this.listCaissesUser.get(var2)).getUsrchrNature() == 61) {
                     var4.setRecuSelected(true);
                  }
               }
            }
         }
      }

      this.datamodelModelCaisses.setWrappedData(this.listCaisses);
   }

   public void modifierModele() {
      if (this.groupe != null) {
         if (this.groupe.getGrpModuleAch() == 1) {
            this.impressionAchats();
         }

         if (this.groupe.getGrpModuleCai() == 1) {
            this.impressionCaisses();
         }

         if (this.groupe.getGrpModuleCpt() == 1) {
            this.impressionCompta();
         }

         if (this.groupe.getGrpModuleEdu() == 1) {
            this.impressionEducation();
         }

         if (this.groupe.getGrpModuleMed() == 1) {
            this.impressionMedical();
         }

         if (this.groupe.getGrpModuleMef() == 1) {
            this.impressionMicrofinance();
         }

         if (this.groupe.getGrpModuleOff() == 1) {
            this.impressionOffice();
         }

         if (this.groupe.getGrpModulePay() == 1) {
            this.impressionPaye();
         }

         if (this.groupe.getGrpModulePrc() == 1) {
            this.impressionParc();
         }

         if (this.groupe.getGrpModuleStk() == 1) {
            this.impressionStocks();
         }

         if (this.groupe.getGrpModuleTie() == 1) {
            this.impressionTiers();
         }

         if (this.groupe.getGrpModuleVte() == 1) {
            this.impressionVentes();
         }

         if (this.groupe.getGrpModuleRep() == 1) {
            this.impressionReporting();
         }
      }

      this.showModalPanelModele = true;
   }

   public void annuleModele() {
      this.showModalPanelModele = false;
   }

   public void impressionAchats() {
      this.listImpAchatsUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "achats" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "achats" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpAchatsUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelAchatsUtil.setWrappedData(this.listImpAchatsUtil);
      this.listImpAchats.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpAchatsUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpAchatsUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpAchatsUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpAchats.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelAchats.setWrappedData(this.listImpAchats);
   }

   public void selectionLigneAchats() {
      if (this.datamodelModelAchats.isRowAvailable()) {
         String var1 = (String)this.datamodelModelAchats.getRowData();
         this.listImpAchats.remove(var1);
         this.listImpAchatsUtil.add(var1);
         this.majConfigModuleAchats();
      }

   }

   public void deSelectionLigneAchats() {
      if (this.datamodelModelAchatsUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelAchatsUtil.getRowData();
         this.listImpAchatsUtil.remove(var1);
         this.listImpAchats.add(var1);
         this.majConfigModuleAchats();
      }

   }

   public void majConfigModuleAchats() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "achats" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpAchatsUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpAchatsUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpAchatsUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var1);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void impressionCaisses() {
      this.listImpCaissesUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "caisses" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "caisses" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpCaissesUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelCaissesUtil.setWrappedData(this.listImpCaissesUtil);
      this.listImpCaisses.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpCaissesUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpCaissesUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpCaissesUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpCaisses.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelCaisses.setWrappedData(this.listImpCaisses);
   }

   public void selectionLigneCaisses() {
      if (this.datamodelModelCaisses.isRowAvailable()) {
         String var1 = (String)this.datamodelModelCaisses.getRowData();
         this.listImpCaisses.remove(var1);
         this.listImpCaissesUtil.add(var1);
         this.majConfigModuleCaisses();
      }

   }

   public void deSelectionLigneCaisses() {
      if (this.datamodelModelCaissesUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelCaissesUtil.getRowData();
         this.listImpCaissesUtil.remove(var1);
         this.listImpCaisses.add(var1);
         this.majConfigModuleCaisses();
      }

   }

   public void majConfigModuleCaisses() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "caisses" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpCaissesUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpCaissesUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpCaissesUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var2);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void impressionCompta() {
      this.listImpComptaUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "compta" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "compta" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpComptaUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelComptaUtil.setWrappedData(this.listImpComptaUtil);
      this.listImpCompta.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpComptaUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpComptaUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpComptaUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpCompta.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelCompta.setWrappedData(this.listImpCompta);
   }

   public void selectionLigneCompta() {
      if (this.datamodelModelCompta.isRowAvailable()) {
         String var1 = (String)this.datamodelModelCompta.getRowData();
         this.listImpCompta.remove(var1);
         this.listImpComptaUtil.add(var1);
         this.majConfigModuleCompta();
      }

   }

   public void deSelectionLigneCompta() {
      if (this.datamodelModelComptaUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelComptaUtil.getRowData();
         this.listImpComptaUtil.remove(var1);
         this.listImpCompta.add(var1);
         this.majConfigModuleCompta();
      }

   }

   public void majConfigModuleCompta() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "compta" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpComptaUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpComptaUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpComptaUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var2);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void impressionEducation() {
      this.listImpEducationUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "education" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "education" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpEducationUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelEducationUtil.setWrappedData(this.listImpEducationUtil);
      this.listImpEducation.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "education"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpEducationUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpEducationUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpEducationUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpEducation.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelEducation.setWrappedData(this.listImpEducation);
   }

   public void selectionLigneEducation() {
      if (this.datamodelModelEducation.isRowAvailable()) {
         String var1 = (String)this.datamodelModelEducation.getRowData();
         this.listImpEducation.remove(var1);
         this.listImpEducationUtil.add(var1);
         this.majConfigModuleEducation();
      }

   }

   public void deSelectionLigneEducation() {
      if (this.datamodelModelEducationUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelEducationUtil.getRowData();
         this.listImpEducationUtil.remove(var1);
         this.listImpEducation.add(var1);
         this.majConfigModuleEducation();
      }

   }

   public void majConfigModuleEducation() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "education" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpEducationUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpEducationUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpEducationUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var1);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void impressionMedical() {
      this.listImpMedicalUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpMedicalUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelMedicalUtil.setWrappedData(this.listImpMedicalUtil);
      this.listImpMedical.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpMedicalUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpMedicalUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpMedicalUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpMedical.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelMedical.setWrappedData(this.listImpMedical);
   }

   public void selectionLigneMedical() {
      if (this.datamodelModelMedical.isRowAvailable()) {
         String var1 = (String)this.datamodelModelMedical.getRowData();
         this.listImpMedical.remove(var1);
         this.listImpMedicalUtil.add(var1);
         this.majConfigModuleMedical();
      }

   }

   public void deSelectionLigneMedical() {
      if (this.datamodelModelMedicalUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelMedicalUtil.getRowData();
         this.listImpMedicalUtil.remove(var1);
         this.listImpMedical.add(var1);
         this.majConfigModuleMedical();
      }

   }

   public void majConfigModuleMedical() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpMedicalUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpMedicalUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpMedicalUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var1);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void impressionMicrofinance() {
      this.listImpMicrofinanceUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "microfinance" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "microfinance" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpMicrofinanceUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelMicrofinanceUtil.setWrappedData(this.listImpMicrofinanceUtil);
      this.listImpMicrofinance.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "microfinance"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpMicrofinanceUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpMicrofinanceUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpMicrofinanceUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpMicrofinance.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelMicrofinance.setWrappedData(this.listImpMicrofinance);
   }

   public void selectionLigneMicrofinance() {
      if (this.datamodelModelMicrofinance.isRowAvailable()) {
         String var1 = (String)this.datamodelModelMicrofinance.getRowData();
         this.listImpMicrofinance.remove(var1);
         this.listImpMicrofinanceUtil.add(var1);
         this.majConfigModuleMicrofinance();
      }

   }

   public void deSelectionLigneMicrofinance() {
      if (this.datamodelModelMicrofinanceUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelMicrofinanceUtil.getRowData();
         this.listImpMicrofinanceUtil.remove(var1);
         this.listImpMicrofinance.add(var1);
         this.majConfigModuleMicrofinance();
      }

   }

   public void majConfigModuleMicrofinance() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "microfinance" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpMicrofinanceUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpMicrofinanceUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpMicrofinanceUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var1);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void impressionOffice() {
      this.listImpOfficeUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpOfficeUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelOfficeUtil.setWrappedData(this.listImpOfficeUtil);
      this.listImpOffice.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "office"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpOfficeUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpOfficeUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpOfficeUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpOffice.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelOffice.setWrappedData(this.listImpOffice);
   }

   public void selectionLigneOffice() {
      if (this.datamodelModelOffice.isRowAvailable()) {
         String var1 = (String)this.datamodelModelOffice.getRowData();
         this.listImpOffice.remove(var1);
         this.listImpOfficeUtil.add(var1);
         this.majConfigModuleOffice();
      }

   }

   public void deSelectionLigneOffice() {
      if (this.datamodelModelOfficeUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelOfficeUtil.getRowData();
         this.listImpOfficeUtil.remove(var1);
         this.listImpOffice.add(var1);
         this.majConfigModuleOffice();
      }

   }

   public void majConfigModuleOffice() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "office" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpOfficeUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpOfficeUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpOfficeUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            var8.output(this.document, new FileOutputStream(var1));
         } catch (IOException var7) {
         }
      }

   }

   public void impressionPaye() {
      this.listImpPayeUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpPayeUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelPayeUtil.setWrappedData(this.listImpPayeUtil);
      this.listImpPaye.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays()), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpPayeUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpPayeUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpPayeUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpPaye.add(((String)var3.get(var4)).toString());
            }
         }
      }

      ArrayList var8 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye"), var8);
      if (var8.size() != 0) {
         for(int var9 = 0; var9 < var8.size(); ++var9) {
            boolean var10 = false;
            if (this.listImpPayeUtil.size() != 0) {
               for(int var7 = 0; var7 < this.listImpPayeUtil.size(); ++var7) {
                  if (((String)var8.get(var9)).toString().equals(((String)this.listImpPayeUtil.get(var7)).toString())) {
                     var10 = true;
                     break;
                  }
               }
            }

            if (!var10) {
               this.listImpPaye.add(((String)var8.get(var9)).toString());
            }
         }

         this.listImpPaye.add("0:Export modèle simple");
         this.listImpPaye.add("1:Export modèle (BIS)");
         this.listImpPaye.add("2:Export modèle AFB120");
         this.listImpPaye.add("3:Export modèle AFB160");
         this.listImpPaye.add("4:Export modèle MicroFinance");
         this.listImpPaye.add("5:Export modèle OrangeMoney");
         this.listImpPaye.add("6:Export modèle (CBAO)");
         this.listImpPaye.add("20:Export DTS CNSS");
         this.listImpPaye.add("21:Export DTS CNAMGS");
         this.listImpPaye.add("colonnes_contrats");
         this.listImpPaye.add("colonnes_salaries");
         this.listImpPaye.add("colonnes_bulletins");
      }

      this.datamodelModelPaye.setWrappedData(this.listImpPaye);
   }

   public void selectionLignePaye() {
      if (this.datamodelModelPaye.isRowAvailable()) {
         String var1 = (String)this.datamodelModelPaye.getRowData();
         this.listImpPaye.remove(var1);
         this.listImpPayeUtil.add(var1);
         this.majConfigModulePaye();
      }

   }

   public void deSelectionLignePaye() {
      if (this.datamodelModelPayeUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelPayeUtil.getRowData();
         this.listImpPayeUtil.remove(var1);
         this.listImpPaye.add(var1);
         this.majConfigModulePaye();
      }

   }

   public void majConfigModulePaye() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpPayeUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpPayeUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpPayeUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var1);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void impressionParc() {
      this.listImpParcUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpParcUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelParcUtil.setWrappedData(this.listImpParcUtil);
      this.listImpParc.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parc"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpParcUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpParcUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpParcUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpParc.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelParc.setWrappedData(this.listImpParc);
   }

   public void selectionLigneParc() {
      if (this.datamodelModelParc.isRowAvailable()) {
         String var1 = (String)this.datamodelModelParc.getRowData();
         this.listImpParc.remove(var1);
         this.listImpParcUtil.add(var1);
         this.majConfigModuleParc();
      }

   }

   public void deSelectionLigneParc() {
      if (this.datamodelModelParcUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelParcUtil.getRowData();
         this.listImpParcUtil.remove(var1);
         this.listImpParc.add(var1);
         this.majConfigModuleParc();
      }

   }

   public void majConfigModuleParc() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpParcUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpParcUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpParcUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var1);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void impressionStocks() {
      this.listImpStocksUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "achats" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "achats" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleStocksAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpStocksUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelStocksUtil.setWrappedData(this.listImpStocksUtil);
      this.listImpStocks.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "achats"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpStocksUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpStocksUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpStocksUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpStocks.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelStocks.setWrappedData(this.listImpStocks);
   }

   public void selectionLigneStocks() {
      if (this.datamodelModelStocks.isRowAvailable()) {
         String var1 = (String)this.datamodelModelStocks.getRowData();
         this.listImpStocks.remove(var1);
         this.listImpStocksUtil.add(var1);
         this.majConfigModuleStocks();
      }

   }

   public void deSelectionLigneStocks() {
      if (this.datamodelModelStocksUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelStocksUtil.getRowData();
         this.listImpStocksUtil.remove(var1);
         this.listImpStocks.add(var1);
         this.majConfigModuleStocks();
      }

   }

   public void majConfigModuleStocks() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "achats" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleStocksAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpStocksUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpStocksUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpStocksUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var1);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void impressionTiers() {
      this.listImpTiersUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "famille_tiers" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "famille_tiers" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpTiersUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelTiersUtil.setWrappedData(this.listImpTiersUtil);
      this.listImpTiers.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "famille_tiers"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpTiersUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpTiersUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpTiersUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpTiers.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelTiers.setWrappedData(this.listImpTiers);
   }

   public void selectionLigneTiers() {
      if (this.datamodelModelTiers.isRowAvailable()) {
         String var1 = (String)this.datamodelModelTiers.getRowData();
         this.listImpTiers.remove(var1);
         this.listImpTiersUtil.add(var1);
         this.majConfigModuleTiers();
      }

   }

   public void deSelectionLigneTiers() {
      if (this.datamodelModelTiersUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelTiersUtil.getRowData();
         this.listImpTiersUtil.remove(var1);
         this.listImpTiers.add(var1);
         this.majConfigModuleTiers();
      }

   }

   public void majConfigModuleTiers() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "famille_tiers" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpTiersUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpTiersUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpTiersUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var1);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void impressionVentes() {
      this.listImpVentesUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpVentesUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelVentesUtil.setWrappedData(this.listImpVentesUtil);
      this.listImpVentes.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpVentesUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpVentesUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpVentesUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpVentes.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelVentes.setWrappedData(this.listImpVentes);
   }

   public void selectionLigneVentes() {
      if (this.datamodelModelVentes.isRowAvailable()) {
         String var1 = (String)this.datamodelModelVentes.getRowData();
         this.listImpVentes.remove(var1);
         this.listImpVentesUtil.add(var1);
         this.majConfigModuleVentes();
      }

   }

   public void deSelectionLigneVentes() {
      if (this.datamodelModelVentesUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelVentesUtil.getRowData();
         this.listImpVentesUtil.remove(var1);
         this.listImpVentes.add(var1);
         this.majConfigModuleVentes();
      }

   }

   public void majConfigModuleVentes() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpVentesUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpVentesUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpVentesUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var1);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void impressionReporting() {
      this.listImpReportingUtil.clear();
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "reporting" + File.separator);
      if (!var1.exists()) {
         var1.mkdir();
      }

      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "reporting" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml");
      if (var2.exists()) {
         this.lectureModeleAutorise = new LectureModeleAutorise(var2.toString());
         this.listImpReportingUtil = this.lectureModeleAutorise.getLesModelesAutorises();
      }

      this.datamodelModelReportingUtil.setWrappedData(this.listImpReportingUtil);
      this.listImpVentes.clear();
      ArrayList var3 = new ArrayList();
      this.listeRepertoire(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "reporting"), var3);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            boolean var5 = false;
            if (this.listImpReportingUtil.size() != 0) {
               for(int var6 = 0; var6 < this.listImpReportingUtil.size(); ++var6) {
                  if (((String)var3.get(var4)).toString().equals(((String)this.listImpReportingUtil.get(var6)).toString())) {
                     var5 = true;
                     break;
                  }
               }
            }

            if (!var5) {
               this.listImpReporting.add(((String)var3.get(var4)).toString());
            }
         }
      }

      this.datamodelModelReporting.setWrappedData(this.listImpReporting);
   }

   public void selectionLigneReporting() {
      if (this.datamodelModelReporting.isRowAvailable()) {
         String var1 = (String)this.datamodelModelReporting.getRowData();
         this.listImpReporting.remove(var1);
         this.listImpReportingUtil.add(var1);
         this.majConfigModuleReporting();
      }

   }

   public void deSelectionLigneReporting() {
      if (this.datamodelModelReportingUtil.isRowAvailable()) {
         String var1 = (String)this.datamodelModelReportingUtil.getRowData();
         this.listImpReportingUtil.remove(var1);
         this.listImpReporting.add(var1);
         this.majConfigModuleVentes();
      }

   }

   public void majConfigModuleReporting() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "reporting" + File.separator + "configuration" + File.separator + this.groupe.getGrpCode() + "_modeleAutorise.xml";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      if (this.listImpVentesUtil.size() != 0) {
         new SAXBuilder();

         try {
            this.racine = new Element("impression");
            this.document = new Document(this.racine);

            for(int var4 = 0; var4 < this.listImpVentesUtil.size(); ++var4) {
               Element var5 = new Element("modeleAutorise");
               this.racine.addContent(var5);
               Element var6 = new Element("modele");
               var6.setText(((String)this.listImpReportingUtil.get(var4)).toString());
               var5.addContent(var6);
            }

            XMLOutputter var8 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var9 = new FileOutputStream(var1);
            var8.output(this.document, var9);
            var9.close();
         } catch (IOException var7) {
         }
      }

   }

   public void listeRepertoire(File var1, List var2) {
      if (var1.isDirectory()) {
         File[] var3 = var1.listFiles();
         if (var3 != null) {
            for(int var4 = 0; var4 < var3.length; ++var4) {
               this.listeRepertoire(var3[var4], var2);
            }
         }
      } else {
         String var6 = var1.getAbsolutePath();
         String var7 = var6.toString();
         if (var7.endsWith(".jasper") || var7.endsWith(".JASPER")) {
            String[] var5 = var7.split("impression");
            var2.add(var5[1]);
         }
      }

   }

   public void selectionConsultationFonction() {
      if (this.listeFonctions.size() != 0) {
         for(int var1 = 0; var1 < this.listeFonctions.size(); ++var1) {
            new ObjetLigneMenu();
            ObjetLigneMenu var2 = (ObjetLigneMenu)this.listeFonctions.get(var1);
            var2.setAcc(true);
            var2.setAdd(false);
            var2.setClo(false);
            var2.setDup(false);
            var2.setImp(true);
            var2.setMaj(false);
            var2.setSup(false);
            var2.setTrf(false);
            this.datamodelFonctions.setWrappedData(this.listeFonctions);
         }
      }

   }

   public void selectionAllFonction() {
      if (this.listeFonctions.size() != 0) {
         for(int var1 = 0; var1 < this.listeFonctions.size(); ++var1) {
            new ObjetLigneMenu();
            ObjetLigneMenu var2 = (ObjetLigneMenu)this.listeFonctions.get(var1);
            var2.setAcc(true);
            var2.setAdd(true);
            var2.setClo(true);
            var2.setDup(true);
            var2.setImp(true);
            var2.setMaj(true);
            var2.setSup(true);
            var2.setTrf(true);
            this.datamodelFonctions.setWrappedData(this.listeFonctions);
         }
      }

   }

   public void selectionNothingFonction() {
      if (this.listeFonctions.size() != 0) {
         for(int var1 = 0; var1 < this.listeFonctions.size(); ++var1) {
            new ObjetLigneMenu();
            ObjetLigneMenu var2 = (ObjetLigneMenu)this.listeFonctions.get(var1);
            var2.setAcc(false);
            var2.setAdd(false);
            var2.setClo(false);
            var2.setDup(false);
            var2.setImp(false);
            var2.setMaj(false);
            var2.setSup(false);
            var2.setTrf(false);
            this.datamodelFonctions.setWrappedData(this.listeFonctions);
         }
      }

   }

   public void validerFonction() throws IOException {
      if (this.module.getCode1().equalsIgnoreCase("30000") && this.module_commercial != null && !this.module_commercial.isEmpty()) {
         this.enregistreTiers();
      } else {
         this.enregistreFonction();
      }

   }

   public void enregistreFonction() throws IOException {
      this.racine = new Element("M" + this.module.getCode1());
      this.document = new Document(this.racine);
      this.racine.removeContent();

      for(int var1 = 0; var1 < this.listeFonctions.size(); ++var1) {
         this.objetLigneMenu = new ObjetLigneMenu();
         this.objetLigneMenu = (ObjetLigneMenu)this.listeFonctions.get(var1);
         Element var2 = new Element("lignemenu");
         Element var3 = new Element("libelle_FR");
         var2.addContent(var3);
         var3.setText(this.objetLigneMenu.getLibelle_FR());
         Element var4 = new Element("libelle_UK");
         var2.addContent(var4);
         var4.setText(this.objetLigneMenu.getLibelle_UK());
         Element var5 = new Element("libelle_SP");
         var2.addContent(var5);
         var5.setText(this.objetLigneMenu.getLibelle_SP());
         Element var6 = new Element("pagemenu");
         var2.addContent(var6);
         var6.setText(this.objetLigneMenu.getPagemenu());
         Element var7 = new Element("commande");
         var2.addContent(var7);
         var7.setText(this.objetLigneMenu.getCommande());
         Element var8 = new Element("type");
         var2.addContent(var8);
         var8.setText(this.objetLigneMenu.getType());
         Element var9 = new Element("genre");
         var2.addContent(var9);
         var9.setText(this.objetLigneMenu.getGenre());
         Element var10 = new Element("acc");
         var2.addContent(var10);
         var10.setText("" + this.objetLigneMenu.isAcc());
         Element var11 = new Element("add");
         var2.addContent(var11);
         var11.setText("" + this.objetLigneMenu.isAdd());
         Element var12 = new Element("dup");
         var2.addContent(var12);
         var12.setText("" + this.objetLigneMenu.isDup());
         Element var13 = new Element("maj");
         var2.addContent(var13);
         var13.setText("" + this.objetLigneMenu.isMaj());
         Element var14 = new Element("sup");
         var2.addContent(var14);
         var14.setText("" + this.objetLigneMenu.isSup());
         Element var15 = new Element("imp");
         var2.addContent(var15);
         var15.setText("" + this.objetLigneMenu.isImp());
         Element var16 = new Element("clo");
         var2.addContent(var16);
         var16.setText("" + this.objetLigneMenu.isClo());
         Element var17 = new Element("trf");
         var2.addContent(var17);
         var17.setText("" + this.objetLigneMenu.isTrf());
         this.racine.addContent(var2);
      }

      XMLOutputter var18 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var19 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "menu_defaut" + File.separator + this.module.getCode1() + "-" + this.groupe.getGrpCode() + ".xml");
      var18.output(this.document, var19);
      var19.close();
   }

   public void enregistreTiers() throws FileNotFoundException, IOException {
      this.racine = new Element("M30000_" + this.module_commercial);
      this.document = new Document(this.racine);
      this.racine.removeContent();

      for(int var1 = 0; var1 < this.listeFonctions.size(); ++var1) {
         this.objetLigneMenu = new ObjetLigneMenu();
         this.objetLigneMenu = (ObjetLigneMenu)this.listeFonctions.get(var1);
         Element var2 = new Element("lignemenu");
         Element var3 = new Element("libelle_FR");
         var2.addContent(var3);
         var3.setText(this.objetLigneMenu.getLibelle_FR());
         Element var4 = new Element("libelle_UK");
         var2.addContent(var4);
         var4.setText(this.objetLigneMenu.getLibelle_UK());
         Element var5 = new Element("libelle_SP");
         var2.addContent(var5);
         var5.setText(this.objetLigneMenu.getLibelle_SP());
         Element var6 = new Element("pagemenu");
         var2.addContent(var6);
         var6.setText(this.objetLigneMenu.getPagemenu());
         Element var7 = new Element("commande");
         var2.addContent(var7);
         var7.setText(this.objetLigneMenu.getCommande());
         Element var8 = new Element("type");
         var2.addContent(var8);
         var8.setText(this.objetLigneMenu.getType());
         Element var9 = new Element("genre");
         var2.addContent(var9);
         var9.setText(this.objetLigneMenu.getGenre());
         Element var10 = new Element("acc");
         var2.addContent(var10);
         var10.setText("" + this.objetLigneMenu.isAcc());
         Element var11 = new Element("add");
         var2.addContent(var11);
         var11.setText("" + this.objetLigneMenu.isAdd());
         Element var12 = new Element("dup");
         var2.addContent(var12);
         var12.setText("" + this.objetLigneMenu.isDup());
         Element var13 = new Element("maj");
         var2.addContent(var13);
         var13.setText("" + this.objetLigneMenu.isMaj());
         Element var14 = new Element("sup");
         var2.addContent(var14);
         var14.setText("" + this.objetLigneMenu.isSup());
         Element var15 = new Element("imp");
         var2.addContent(var15);
         var15.setText("" + this.objetLigneMenu.isImp());
         Element var16 = new Element("clo");
         var2.addContent(var16);
         var16.setText("" + this.objetLigneMenu.isClo());
         Element var17 = new Element("trf");
         var2.addContent(var17);
         var17.setText("" + this.objetLigneMenu.isTrf());
         this.racine.addContent(var2);
      }

      XMLOutputter var18 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var19 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "menu_defaut" + File.separator + "30000_" + this.module_commercial + "-" + this.groupe.getGrpCode() + ".xml");
      var18.output(this.document, var19);
      var19.close();
   }

   public void selectionConsultationOnglet() {
      if (this.listeOnglets.size() != 0) {
         for(int var1 = 0; var1 < this.listeOnglets.size(); ++var1) {
            new ObjetLigneOnglet();
            ObjetLigneOnglet var2 = (ObjetLigneOnglet)this.listeOnglets.get(var1);
            var2.setAcc(true);
            var2.setAdd(false);
            var2.setMaj(false);
            var2.setImp(true);
            var2.setSup(false);
            this.datamodelOnglets.setWrappedData(this.listeOnglets);
         }
      }

   }

   public void selectionAllOnglet() {
      if (this.listeOnglets.size() != 0) {
         for(int var1 = 0; var1 < this.listeOnglets.size(); ++var1) {
            new ObjetLigneOnglet();
            ObjetLigneOnglet var2 = (ObjetLigneOnglet)this.listeOnglets.get(var1);
            var2.setAcc(true);
            var2.setAdd(true);
            var2.setMaj(true);
            var2.setImp(true);
            var2.setSup(true);
            this.datamodelOnglets.setWrappedData(this.listeOnglets);
         }
      }

   }

   public void selectionNothingOngletn() {
      if (this.listeOnglets.size() != 0) {
         for(int var1 = 0; var1 < this.listeOnglets.size(); ++var1) {
            new ObjetLigneOnglet();
            ObjetLigneOnglet var2 = (ObjetLigneOnglet)this.listeOnglets.get(var1);
            var2.setAcc(false);
            var2.setAdd(false);
            var2.setMaj(false);
            var2.setImp(false);
            var2.setSup(false);
            this.datamodelOnglets.setWrappedData(this.listeOnglets);
         }
      }

   }

   public void validerOnglet() throws IOException {
      this.racine = new Element("M" + this.module.getCode1() + "_ONG");
      this.document = new Document(this.racine);
      this.racine.removeContent();

      for(int var1 = 0; var1 < this.listeOnglets.size(); ++var1) {
         this.objetLigneOnglet = new ObjetLigneOnglet();
         this.objetLigneOnglet = (ObjetLigneOnglet)this.listeOnglets.get(var1);
         Element var2 = new Element("lignemenu");
         Element var3 = new Element("libelle");
         var2.addContent(var3);
         var3.setText(this.objetLigneOnglet.getLibelle());
         Element var4 = new Element("code");
         var2.addContent(var4);
         var4.setText(this.objetLigneOnglet.getCode());
         Element var5 = new Element("acc");
         var2.addContent(var5);
         var5.setText("" + this.objetLigneOnglet.isAcc());
         Element var6 = new Element("add");
         var2.addContent(var6);
         var6.setText("" + this.objetLigneOnglet.isAdd());
         Element var7 = new Element("maj");
         var2.addContent(var7);
         var7.setText("" + this.objetLigneOnglet.isMaj());
         Element var8 = new Element("sup");
         var2.addContent(var8);
         var8.setText("" + this.objetLigneOnglet.isSup());
         Element var9 = new Element("imp");
         var2.addContent(var9);
         var9.setText("" + this.objetLigneOnglet.isImp());
         this.racine.addContent(var2);
      }

      XMLOutputter var10 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var11 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "menu_defaut" + File.separator + this.module.getCode1() + "-" + this.groupe.getGrpCode() + "_ONG.xml");
      var10.output(this.document, var11);
      var11.close();
   }

   public void chargerlesBal() throws HibernateException, NamingException {
      this.lesBal.clear();
      this.lesBal = this.balDao.selectBalGrpLog(this.groupe.getGrpCode());
      this.dataModelBal.setWrappedData(this.lesBal);
      this.lien = "mailGroupe";
   }

   public void selectionBal() {
      if (this.dataModelBal.isRowAvailable()) {
         this.bal = (Bal)this.dataModelBal.getRowData();
         this.visibleBal = true;
      }

   }

   public void ajouterBal() {
      this.bal = new Bal();
      this.var_existMail = false;
      this.var_valide_bal = false;
      this.showModalPanelBal = true;
   }

   public void modifierBal() {
      if (this.bal != null) {
         this.var_existMail = false;
         this.var_valide_bal = true;
         this.showModalPanelBal = true;
      }

   }

   public void supprimerBal() throws HibernateException, NamingException {
      if (this.bal != null) {
         this.lesBal.remove(this.bal);
         this.dataModelBal.setWrappedData(this.lesBal);
         this.balDao.delete(this.bal);
         this.visibleBal = false;
      }

   }

   public void annulerBal() {
      this.showModalPanelBal = false;
      this.visibleBal = false;
   }

   public void verifExistMail() throws HibernateException, NamingException {
      if (this.bal.getBaladressemail().contains("@")) {
         Bal var1 = this.balDao.logMailExiste(this.bal.getBaladressemail(), (Session)null);
         if (var1 != null) {
            this.var_existMail = true;
            this.var_valide_bal = false;
         } else {
            this.var_existMail = false;
            this.var_valide_bal = true;
         }
      } else {
         this.var_existMail = false;
         this.var_valide_bal = false;
      }

   }

   public void saveBal() throws HibernateException, NamingException {
      if (this.bal.getBalid() == 0L) {
         this.bal.setBaldatecreat(new Date());
         this.bal.setBalusercreat(this.usersLog.getUsrid());
         this.bal.setBalStructure(0L);
         this.bal.setBalGroupe(this.groupe.getGrpCode());
         this.bal.setBalUser(0L);
         this.bal = this.balDao.insert(this.bal);
         this.lesBal.add(this.bal);
         this.dataModelBal.setWrappedData(this.lesBal);
      } else {
         this.bal.setBaldatemodif(new Date());
         this.bal.setBalusermodif(this.usersLog.getUsrid());
         this.bal = this.balDao.modif(this.bal);
      }

      this.showModalPanelBal = false;
      this.visibleBal = false;
   }

   public void rechercheModule() {
      this.listeModules.clear();
      Module var1 = null;
      var1 = new Module();
      var1.setCode1("10000");
      var1.setLibelle1FR(this.libModules("10000"));
      this.listeModules.add(var1);
      if (this.groupe != null && this.groupe.getGrpModuleFree() == 1) {
         var1 = new Module();
         var1.setCode1("10500");
         var1.setLibelle1FR(this.libModules("10500"));
         this.listeModules.add(var1);
      } else {
         var1 = new Module();
         var1.setCode1("20000");
         var1.setLibelle1FR(this.libModules("20000"));
         this.listeModules.add(var1);
         var1 = new Module();
         var1.setCode1("30000");
         var1.setLibelle1FR(this.libModules("30000"));
         this.listeModules.add(var1);
         if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod1());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod1()));
            this.listeModules.add(var1);
         }

         if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod2());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod2()));
            this.listeModules.add(var1);
         }

         if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod3());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod3()));
            this.listeModules.add(var1);
         }

         if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod4());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod4()));
            this.listeModules.add(var1);
         }

         if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod5());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod5()));
            this.listeModules.add(var1);
         }

         if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod6());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod6()));
            this.listeModules.add(var1);
         }

         if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod7());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod7()));
            this.listeModules.add(var1);
         }

         if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
            var1.setCode1(this.structureLog.getStrmod8());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod8()));
            this.listeModules.add(var1);
         }

         if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod9());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod9()));
            this.listeModules.add(var1);
         }

         if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod10());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod10()));
            this.listeModules.add(var1);
         }
      }

      this.datamodelModules.setWrappedData(this.listeModules);
   }

   public void rechercheModuleGroupe() {
      this.listeModules.clear();
      Module var1 = null;
      var1 = new Module();
      var1.setCode1("10000");
      var1.setLibelle1FR(this.libModules("10000"));
      this.listeModules.add(var1);
      if (this.groupe != null && this.groupe.getGrpModuleFree() == 1) {
         var1 = new Module();
         var1.setCode1("10500");
         var1.setLibelle1FR(this.libModules("10500"));
         this.listeModules.add(var1);
      } else {
         var1 = new Module();
         var1.setCode1("20000");
         var1.setLibelle1FR(this.libModules("20000"));
         if (this.groupe.getGrpModuleOff() != 0) {
            this.listeModules.add(var1);
         }

         var1 = new Module();
         var1.setCode1("30000");
         var1.setLibelle1FR(this.libModules("30000"));
         if (this.groupe.getGrpModuleTie() != 0) {
            this.listeModules.add(var1);
         }

         if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod1());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod1()));
            if (this.filtreModuleGroupe(this.structureLog.getStrmod1())) {
               this.listeModules.add(var1);
            }

            this.ajouterStock(var1.getCode1());
         }

         if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod2());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod2()));
            if (this.filtreModuleGroupe(this.structureLog.getStrmod2())) {
               this.listeModules.add(var1);
            }

            this.ajouterStock(var1.getCode1());
         }

         if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod3());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod3()));
            if (this.filtreModuleGroupe(this.structureLog.getStrmod3())) {
               this.listeModules.add(var1);
            }

            this.ajouterStock(var1.getCode1());
         }

         if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod4());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod4()));
            if (this.filtreModuleGroupe(this.structureLog.getStrmod4())) {
               this.listeModules.add(var1);
            }

            this.ajouterStock(var1.getCode1());
         }

         if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod5());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod5()));
            if (this.filtreModuleGroupe(this.structureLog.getStrmod5())) {
               this.listeModules.add(var1);
            }

            this.ajouterStock(var1.getCode1());
         }

         if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod6());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod6()));
            if (this.filtreModuleGroupe(this.structureLog.getStrmod6())) {
               this.listeModules.add(var1);
            }

            this.ajouterStock(var1.getCode1());
         }

         if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod7());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod7()));
            if (this.filtreModuleGroupe(this.structureLog.getStrmod7())) {
               this.listeModules.add(var1);
            }

            this.ajouterStock(var1.getCode1());
         }

         if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
            var1.setCode1(this.structureLog.getStrmod8());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod8()));
            if (this.filtreModuleGroupe(this.structureLog.getStrmod8())) {
               this.listeModules.add(var1);
            }

            this.ajouterStock(var1.getCode1());
         }

         if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod9());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod9()));
            if (this.filtreModuleGroupe(this.structureLog.getStrmod9())) {
               this.listeModules.add(var1);
            }

            this.ajouterStock(var1.getCode1());
         }

         if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
            var1 = new Module();
            var1.setCode1(this.structureLog.getStrmod10());
            var1.setLibelle1FR(this.libModules(this.structureLog.getStrmod10()));
            if (this.filtreModuleGroupe(this.structureLog.getStrmod10())) {
               this.listeModules.add(var1);
            }

            this.ajouterStock(var1.getCode1());
         }
      }

      this.datamodelModules.setWrappedData(this.listeModules);
   }

   public boolean filtreModuleGroupe(String var1) {
      boolean var2 = false;
      if (var1.startsWith("2") && this.groupe.getGrpModuleOff() != 0) {
         var2 = true;
      } else if (var1.startsWith("3") && this.groupe.getGrpModuleTie() != 0) {
         var2 = true;
      } else if (var1.startsWith("4") && this.groupe.getGrpModuleCpt() != 0) {
         var2 = true;
      } else if (var1.startsWith("5") && this.groupe.getGrpModulePay() != 0) {
         var2 = true;
      } else if (var1.startsWith("6") && this.groupe.getGrpModuleAch() != 0) {
         var2 = true;
      } else if (var1.startsWith("7") && this.groupe.getGrpModulePrc() != 0) {
         var2 = true;
      } else if (var1.startsWith("8") && (this.groupe.getGrpModuleVte() != 0 || this.groupe.getGrpModuleMed() != 0 || this.groupe.getGrpModuleEdu() != 0 || this.groupe.getGrpModuleMef() != 0)) {
         var2 = true;
      } else if (var1.startsWith("90") && this.groupe.getGrpModuleCai() != 0) {
         var2 = true;
      } else if (var1.startsWith("91") && this.groupe.getGrpModuleRep() != 0) {
         var2 = true;
      }

      return var2;
   }

   public void ajouterStock(String var1) {
      if (var1.startsWith("60") && this.groupe.getGrpModuleStk() != 0) {
         Module var2 = new Module();
         var2.setCode1("60100");
         var2.setLibelle1FR(this.libModules(var2.getCode1()));
         this.listeModules.add(var2);
      }

   }

   public String libModules(String var1) {
      String var2 = "";
      if (var1.equalsIgnoreCase("10000")) {
         var2 = "Accueil";
      } else if (var1.equalsIgnoreCase("10500")) {
         var2 = "FREE";
         this.var_mod_free = true;
      } else if (var1.equalsIgnoreCase("20000")) {
         var2 = "Office";
         this.var_mod_office = true;
      } else if (var1.equalsIgnoreCase("30000")) {
         var2 = "Gestion des tiers";
         this.var_mod_tiers = true;
      } else if (var1.equalsIgnoreCase("40100")) {
         var2 = "Comptabilité Libérale";
         this.var_mod_compta = true;
      } else if (var1.equalsIgnoreCase("40200")) {
         var2 = "Comptabilité Société";
         this.var_mod_compta = true;
      } else if (var1.equalsIgnoreCase("40300")) {
         var2 = "Comptabilité Projet";
         this.var_mod_compta = true;
      } else if (!var1.equalsIgnoreCase("50000") && !var1.equalsIgnoreCase("50200") && !var1.equalsIgnoreCase("50300")) {
         if (!var1.equalsIgnoreCase("60000") && !var1.equalsIgnoreCase("60010") && !var1.equalsIgnoreCase("60020")) {
            if (var1.equalsIgnoreCase("60100")) {
               var2 = "Stocks";
               this.var_mod_stock = true;
            } else if (var1.equalsIgnoreCase("70000")) {
               var2 = "Parcs";
               this.var_mod_parc = true;
            } else if (var1.equalsIgnoreCase("80100")) {
               var2 = "Suivi Commercial Standard";
               this.var_mod_ventes = true;
            } else if (var1.equalsIgnoreCase("80200")) {
               var2 = "Suivi Commercial Standard + Comptoir";
               this.var_mod_ventes = true;
            } else if (var1.equalsIgnoreCase("80300")) {
               var2 = "Fondation";
            } else if (var1.equalsIgnoreCase("80400")) {
               var2 = "Gestion Intérim";
               this.var_mod_ventes = true;
            } else if (var1.equalsIgnoreCase("80500")) {
               var2 = "Gestion Cabient";
               this.var_mod_ventes = true;
            } else if (var1.equalsIgnoreCase("80600")) {
               var2 = "Gestion Transit";
               this.var_mod_ventes = true;
            } else if (var1.equalsIgnoreCase("80700")) {
               var2 = "Gestion Micro finance";
               this.var_mod_mef = true;
            } else if (var1.equalsIgnoreCase("80800")) {
               var2 = "Gestion du Change Monétaire";
            } else if (var1.equalsIgnoreCase("80900")) {
               var2 = "Gestion Education";
               this.var_mod_edu = true;
            } else if (var1.equalsIgnoreCase("81000")) {
               var2 = "Gestion des ventes ABN";
               this.var_mod_ventes = true;
            } else if (var1.equalsIgnoreCase("81100")) {
               var2 = "Gestion des Pêcheries";
               this.var_mod_ventes = true;
            } else if (var1.equalsIgnoreCase("81200")) {
               var2 = "Gestion des Temples";
            } else if (var1.equalsIgnoreCase("81300")) {
               var2 = "Gestion des PABX";
            } else if (var1.equalsIgnoreCase("81400")) {
               var2 = "Gestion Forestière";
               this.var_mod_ventes = true;
            } else if (var1.equalsIgnoreCase("81500")) {
               var2 = "Infirmerie";
               this.var_mod_medical = true;
            } else if (var1.equalsIgnoreCase("81510")) {
               var2 = "Cabinet Médical";
               this.var_mod_medical = true;
            } else if (var1.equalsIgnoreCase("81520")) {
               var2 = "Laboratoire";
               this.var_mod_medical = true;
            } else if (var1.equalsIgnoreCase("81530")) {
               var2 = "Pharmacie";
               this.var_mod_medical = true;
            } else if (var1.equalsIgnoreCase("81540")) {
               var2 = "Clinique";
               this.var_mod_medical = true;
            } else if (var1.equalsIgnoreCase("81550")) {
               var2 = "Hopital";
               this.var_mod_medical = true;
            } else if (!var1.equalsIgnoreCase("81600") && !var1.equalsIgnoreCase("81610") && !var1.equalsIgnoreCase("81620") && !var1.equalsIgnoreCase("81630")) {
               if (var1.equalsIgnoreCase("81700")) {
                  var2 = "Gestion Hotellerie";
                  this.var_mod_ventes = true;
               } else if (var1.equalsIgnoreCase("90000")) {
                  var2 = "Caisse";
                  this.var_mod_caisse = true;
               } else if (var1.equalsIgnoreCase("91000")) {
                  var2 = "Reporting";
                  this.var_mod_rep = true;
               }
            } else {
               var2 = "Gestion Immobilière";
               this.var_mod_ventes = true;
            }
         } else {
            var2 = "Achats";
            this.var_mod_achats = true;
            this.var_mod_stock = true;
         }
      } else {
         var2 = "Paye";
         this.var_mod_paye = true;
      }

      return var2;
   }

   public String localisationModule(String var1) {
      String var2 = "00000";
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
         if (((String)var3.get(var4)).startsWith(var1)) {
            var2 = (String)var3.get(var4);
         }
      }

      return var2;
   }

   public void chargerlesGroupesChronosOff(Session var1) throws HibernateException, NamingException {
      this.groupeChronoListOff.clear();
      this.groupeChronoListOff = this.groupeChronoDao.selectListOfficeByGroupe(this.groupe, var1);
      this.datamodelUsersChronoOff.setWrappedData(this.groupeChronoListOff);
      this.testSelectSerieOff = false;
      this.visibiliteBtonOff = true;
   }

   public void selectionLesGroupesOffice() {
      if (this.datamodelUsersChronoOff.isRowAvailable()) {
         this.groupeChrono = (GroupeChrono)this.datamodelUsersChronoOff.getRowData();
         this.visibiliteBtonOff = true;
      }

   }

   public void ajoutChronoOff() {
      this.groupeChrono = new GroupeChrono();
      this.inputChronoOff = "";
      this.var_action_chronoOff = 1;
      this.var_aff_val_chronoOff = false;
      this.showModalPanelOffice = true;
   }

   public void modifChronoOff() {
      if (this.groupeChrono != null) {
         this.var_action_chronoOff = 2;
         this.var_aff_val_chronoOff = true;
         this.showModalPanelOffice = true;
      }

   }

   public void supprimerChronoOff() throws HibernateException, NamingException {
      if (this.groupeChrono != null) {
         this.groupeChronoDao.delete(this.groupeChrono.getGrpchrId());
         this.chargerlesGroupesChronosOff((Session)null);
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
         if (this.groupeChronoListOff.size() != 0) {
            for(int var6 = 0; var6 < this.groupeChronoListOff.size(); ++var6) {
               if (var5 == ((GroupeChrono)this.groupeChronoListOff.get(var6)).getGrpchrNature()) {
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
               this.groupeChrono.setGrpchrNature(var3.getChrNature());
               this.groupeChrono.setGrpchrPrive(var3.getChrPrive());
               this.groupeChrono.setGrpchrSerie(var3.getChrSerie());
               this.groupeChrono.setGrpchrLib(var3.getLibnature() + " " + var3.getChrNom());
            } else {
               this.groupeChrono.setGrpchrNature(0);
               this.groupeChrono.setGrpchrPrive(0);
               this.groupeChrono.setGrpchrSerie("");
               this.groupeChrono.setGrpchrLib("");
            }
         }
      }

   }

   public void validerChronoOff() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
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
      if (this.groupeChrono.getGrpchrNature() != 0) {
         if (this.var_action_chronoOff == 1) {
            this.groupeChrono.setGroupe(this.groupe);
            this.groupeChrono.setGrpchrDateCreat(new Date());
            this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
            this.groupeChronoListOff.add(this.groupeChrono);
            this.datamodelUsersChronoOff.setWrappedData(this.groupeChronoListOff);
         } else if (this.var_action_chronoOff == 2) {
            this.groupeChrono.setGrpchrDateModif(new Date());
            this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
         }

         this.showModalPanelOffice = false;
      }

   }

   public void annuleOffice() {
      this.showModalPanelOffice = false;
   }

   public void ajoutAutoChronoOff() throws HibernateException, NamingException {
      if (this.mesChronoOfficeItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoOfficeItems.size(); ++var3) {
               this.inputChronoOff = ((SelectItem)this.mesChronoOfficeItems.get(var3)).getValue().toString();
               this.groupeChrono = new GroupeChrono();
               this.verifChronoOff(var1);
               if (this.var_aff_val_chronoOff) {
                  this.groupeChrono.setGrpchrUpdate(0);
                  this.groupeChrono.setGrpchrValidation(2);
                  this.groupeChrono.setGrpchrDeValidation(1);
                  this.groupeChrono.setGrpchrDupplication(1);
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

   public void chargerlesGroupesChronosAch(Session var1) throws HibernateException, NamingException {
      this.groupeChronoListAch.clear();
      this.groupeChronoListAch = this.groupeChronoDao.selectListAchatByGroupe(this.groupe, var1);
      this.datamodelUsersChronoAch.setWrappedData(this.groupeChronoListAch);
      this.testSelectSerieAch = false;
      this.visibiliteBtonAch = true;
   }

   public void selectionLesGroupesAchats() {
      if (this.datamodelUsersChronoAch.isRowAvailable()) {
         this.groupeChrono = (GroupeChrono)this.datamodelUsersChronoAch.getRowData();
         this.visibiliteBtonAch = true;
      }

   }

   public void ajoutChronoAch() {
      this.groupeChrono = new GroupeChrono();
      this.inputChronoAch = "";
      this.var_action_chronoAch = 1;
      this.var_aff_val_chronoAch = false;
      this.showModalPanelAchat = true;
   }

   public void modifChronoAch() {
      if (this.groupeChrono != null) {
         this.var_action_chronoAch = 2;
         this.var_aff_val_chronoAch = true;
         this.showModalPanelAchat = true;
      }

   }

   public void supprimerChronoAch() throws HibernateException, NamingException {
      if (this.groupeChrono != null) {
         this.groupeChronoDao.delete(this.groupeChrono.getGrpchrId());
         this.chargerlesGroupesChronosAch((Session)null);
      }

   }

   public void affichageOption() {
      if (this.groupeChrono.getGrpchrUpdate() == 1) {
         this.groupeChrono.setGrpchrValidation(0);
         this.groupeChrono.setGrpchrDeValidation(0);
         this.groupeChrono.setGrpchrDupplication(0);
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
         if (this.groupeChronoListAch.size() != 0) {
            for(int var7 = 0; var7 < this.groupeChronoListAch.size(); ++var7) {
               if (var5.equalsIgnoreCase(((GroupeChrono)this.groupeChronoListAch.get(var7)).getGrpchrSerie()) && var4 == ((GroupeChrono)this.groupeChronoListAch.get(var7)).getGrpchrNature()) {
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
               this.groupeChrono.setGrpchrNature(var6.getChrNature());
               this.groupeChrono.setGrpchrPrive(var6.getChrPrive());
               this.groupeChrono.setGrpchrSerie(var6.getChrSerie());
               this.groupeChrono.setGrpchrLib(var6.getLibnature() + " " + var6.getChrNom());
            } else {
               this.groupeChrono.setGrpchrNature(0);
               this.groupeChrono.setGrpchrPrive(0);
               this.groupeChrono.setGrpchrSerie("");
               this.groupeChrono.setGrpchrLib("");
            }
         }
      }

   }

   public void validerChronoAch() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.verifChronoAch(var1);
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
      if (this.groupeChrono.getGrpchrNature() != 0) {
         if (this.var_action_chronoAch == 1) {
            this.groupeChrono.setGroupe(this.groupe);
            this.groupeChrono.setGrpchrDateCreat(new Date());
            this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
            this.groupeChronoListAch.add(this.groupeChrono);
            this.datamodelUsersChronoAch.setWrappedData(this.groupeChronoListAch);
            this.usersChronoListFree.add(this.groupeChrono);
            this.datamodelUsersChronoFree.setWrappedData(this.usersChronoListFree);
         } else if (this.var_action_chronoAch == 2) {
            this.groupeChrono.setGrpchrDateModif(new Date());
            this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
         }

         this.showModalPanelAchat = false;
      }

   }

   public void annuleAchat() {
      this.showModalPanelAchat = false;
   }

   public void ajoutAutoChronoAch() throws HibernateException, NamingException {
      if (this.mesChronoAchatsItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoAchatsItems.size(); ++var3) {
               this.inputChronoAch = ((SelectItem)this.mesChronoAchatsItems.get(var3)).getValue().toString();
               this.groupeChrono = new GroupeChrono();
               this.verifChronoAch(var1);
               if (this.var_aff_val_chronoAch) {
                  this.groupeChrono.setGrpchrUpdate(0);
                  this.groupeChrono.setGrpchrValidation(2);
                  this.groupeChrono.setGrpchrDeValidation(1);
                  this.groupeChrono.setGrpchrDupplication(1);
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

   public void chargerlesGroupesChronosVte(Session var1) throws HibernateException, NamingException {
      this.usersChronoListVte.clear();
      this.usersChronoListVte = this.groupeChronoDao.selectListVenteByGroupe(this.groupe, var1);
      this.datamodelUsersChronoVte.setWrappedData(this.usersChronoListVte);
      this.testSelectSerieVte = false;
      this.visibiliteBtonVte = true;
   }

   public void selectionLesGroupesVentes() {
      if (this.datamodelUsersChronoVte.isRowAvailable()) {
         this.groupeChrono = (GroupeChrono)this.datamodelUsersChronoVte.getRowData();
         this.visibiliteBtonVte = true;
      }

   }

   public void ajoutChronoVte() {
      this.groupeChrono = new GroupeChrono();
      this.inputChronoVte = "";
      this.var_action_chronoVte = 1;
      this.var_aff_val_chronoVte = false;
      this.showModalPanelVente = true;
   }

   public void modifChronoVte() {
      if (this.groupeChrono != null) {
         this.var_action_chronoVte = 2;
         this.var_aff_val_chronoVte = true;
         this.showModalPanelVente = true;
      }

   }

   public void supprimerChronoVte() throws HibernateException, NamingException {
      if (this.groupeChrono != null) {
         this.groupeChronoDao.delete(this.groupeChrono.getGrpchrId());
         this.chargerlesGroupesChronosVte((Session)null);
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
               if (var5.equalsIgnoreCase(((GroupeChrono)this.usersChronoListVte.get(var7)).getGrpchrSerie()) && var4 == ((GroupeChrono)this.usersChronoListVte.get(var7)).getGrpchrNature()) {
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
               this.groupeChrono.setGrpchrNature(var6.getChrNature());
               this.groupeChrono.setGrpchrPrive(var6.getChrPrive());
               this.groupeChrono.setGrpchrSerie(var6.getChrSerie());
               this.groupeChrono.setGrpchrLib(var6.getLibnature() + " " + var6.getChrNom());
            } else {
               this.groupeChrono.setGrpchrNature(0);
               this.groupeChrono.setGrpchrPrive(0);
               this.groupeChrono.setGrpchrSerie("");
               this.groupeChrono.setGrpchrLib("");
            }
         }
      }

   }

   public void validerChronoVte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
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
      if (this.groupeChrono.getGrpchrNature() != 0) {
         if (this.var_action_chronoVte == 1) {
            this.groupeChrono.setGroupe(this.groupe);
            this.groupeChrono.setGrpchrDateCreat(new Date());
            this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
            this.usersChronoListVte.add(this.groupeChrono);
            this.datamodelUsersChronoVte.setWrappedData(this.usersChronoListVte);
            this.usersChronoListFree.add(this.groupeChrono);
            this.datamodelUsersChronoFree.setWrappedData(this.usersChronoListFree);
         } else if (this.var_action_chronoVte == 2) {
            this.groupeChrono.setGrpchrDateModif(new Date());
            this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
         }

         this.showModalPanelVente = false;
      }

   }

   public void annuleVente() {
      this.showModalPanelVente = false;
   }

   public void ajoutAutoChronoVte() throws HibernateException, NamingException {
      if (this.mesChronoVentesItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoVentesItems.size(); ++var3) {
               this.inputChronoVte = ((SelectItem)this.mesChronoVentesItems.get(var3)).getValue().toString();
               this.groupeChrono = new GroupeChrono();
               this.verifChronoVte(var1);
               if (this.var_aff_val_chronoVte) {
                  this.groupeChrono.setGrpchrUpdate(0);
                  this.groupeChrono.setGrpchrValidation(2);
                  this.groupeChrono.setGrpchrDeValidation(1);
                  this.groupeChrono.setGrpchrDupplication(1);
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

   public void chargerlesGroupesChronosCaisse(Session var1) throws HibernateException, NamingException {
      this.usersChronoListCaiss.clear();
      this.usersChronoListCaiss = this.groupeChronoDao.selectListCaisseByGroupe(this.groupe, var1);
      this.datamodelUsersChronoCaiss.setWrappedData(this.usersChronoListCaiss);
      this.testSelectSerieCaiss = false;
      this.visibiliteBtonCaiss = true;
   }

   public void selectionLesGroupesCaisses() {
      if (this.datamodelUsersChronoCaiss.isRowAvailable()) {
         this.groupeChrono = (GroupeChrono)this.datamodelUsersChronoCaiss.getRowData();
         this.visibiliteBtonCaiss = true;
      }

   }

   public void ajoutChronoCaisse() {
      this.groupeChrono = new GroupeChrono();
      this.inputChronoCaisse = "";
      this.var_action_chronoCaisse = 1;
      this.var_aff_val_chronoCaisse = false;
      this.showModalPanelCaisse = true;
   }

   public void modifChronoCaisse() {
      if (this.groupeChrono != null) {
         this.var_action_chronoCaisse = 2;
         this.var_aff_val_chronoCaisse = true;
         this.showModalPanelCaisse = true;
      }

   }

   public void supprimerChronoCaisse() throws HibernateException, NamingException {
      if (this.groupeChrono != null) {
         this.groupeChronoDao.delete(this.groupeChrono.getGrpchrId());
         this.chargerlesGroupesChronosCaisse((Session)null);
      }

   }

   public void verifChronoCaisse() throws HibernateException, NamingException {
      this.verifChronoCaisse((Session)null);
   }

   public void verifChronoCaisse(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (this.inputChronoCaisse != null && this.inputChronoCaisse.contains(":")) {
         String[] var3 = this.inputChronoCaisse.split(":");
         int var4 = Integer.parseInt(var3[0]);
         String var5 = var3[1];
         new Chrono();
         if (this.usersChronoListCaiss.size() != 0) {
            for(int var7 = 0; var7 < this.usersChronoListCaiss.size(); ++var7) {
               if (var5.equalsIgnoreCase(((GroupeChrono)this.usersChronoListCaiss.get(var7)).getGrpchrSerie()) && var4 == ((GroupeChrono)this.usersChronoListCaiss.get(var7)).getGrpchrNature()) {
                  var2 = true;
                  break;
               }
            }
         }

         if (var2) {
            this.var_aff_val_chronoCaisse = false;
         } else {
            this.var_aff_val_chronoCaisse = true;
            Chrono var6 = this.chronoDao.chronoBySerieNat(var5, var4, var1);
            if (var6 != null) {
               this.groupeChrono.setGrpchrNature(var6.getChrNature());
               this.groupeChrono.setGrpchrPrive(var6.getChrPrive());
               this.groupeChrono.setGrpchrSerie(var6.getChrSerie());
               this.groupeChrono.setGrpchrLib(var6.getLibnature() + " " + var6.getChrNom());
            } else {
               this.groupeChrono.setGrpchrNature(0);
               this.groupeChrono.setGrpchrPrive(0);
               this.groupeChrono.setGrpchrSerie("");
               this.groupeChrono.setGrpchrLib("");
            }
         }
      }

   }

   public void validerChronoCaisse() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
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
      if (this.groupeChrono.getGrpchrNature() != 0) {
         if (this.var_action_chronoCaisse == 1) {
            this.groupeChrono.setGroupe(this.groupe);
            this.groupeChrono.setGrpchrDateCreat(new Date());
            this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
            this.usersChronoListCaiss.add(this.groupeChrono);
            this.datamodelUsersChronoCaiss.setWrappedData(this.usersChronoListCaiss);
            this.usersChronoListFree.add(this.groupeChrono);
            this.datamodelUsersChronoFree.setWrappedData(this.usersChronoListFree);
         } else if (this.var_action_chronoCaisse == 2) {
            this.groupeChrono.setGrpchrDateModif(new Date());
            this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
         }

         this.showModalPanelCaisse = false;
      }

   }

   public void annuleCaisse() {
      this.showModalPanelCaisse = false;
   }

   public void ajoutAutoChronoCaisse() throws HibernateException, NamingException {
      if (this.mesChronoCaisseItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoCaisseItems.size(); ++var3) {
               this.inputChronoCaisse = ((SelectItem)this.mesChronoCaisseItems.get(var3)).getValue().toString();
               this.groupeChrono = new GroupeChrono();
               this.verifChronoCaisse(var1);
               if (this.var_aff_val_chronoCaisse) {
                  this.groupeChrono.setGrpchrUpdate(0);
                  this.groupeChrono.setGrpchrValidation(2);
                  this.groupeChrono.setGrpchrDeValidation(1);
                  this.groupeChrono.setGrpchrDupplication(1);
                  this.validerChronoCaisse(var1);
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

   public void chargerlesGroupesChronosPaye(Session var1) throws HibernateException, NamingException {
      this.usersChronoListPaye.clear();
      this.usersChronoListPaye = this.groupeChronoDao.selectListPayeByGroupe(this.groupe, var1);
      this.datamodelUsersChronoPaye.setWrappedData(this.usersChronoListPaye);
      this.testSelectSeriePaye = false;
      this.visibiliteBtonPaye = true;
   }

   public void selectionLesGroupesPaye() {
      if (this.datamodelUsersChronoPaye.isRowAvailable()) {
         this.groupeChrono = (GroupeChrono)this.datamodelUsersChronoPaye.getRowData();
         this.visibiliteBtonPaye = true;
      }

   }

   public void ajoutChronoPaye() {
      this.groupeChrono = new GroupeChrono();
      this.inputChronoPaye = "";
      this.var_action_chronoPaye = 1;
      this.var_aff_val_chronoPaye = false;
      this.showModalPanelPaye = true;
   }

   public void modifChronoPaye() {
      if (this.groupeChrono != null) {
         this.var_action_chronoPaye = 2;
         this.var_aff_val_chronoPaye = true;
         this.showModalPanelPaye = true;
      }

   }

   public void supprimerChronoPaye() throws HibernateException, NamingException {
      if (this.groupeChrono != null) {
         this.groupeChronoDao.delete(this.groupeChrono.getGrpchrId());
         this.chargerlesGroupesChronosPaye((Session)null);
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
               if (var5.equalsIgnoreCase(((GroupeChrono)this.usersChronoListPaye.get(var8)).getGrpchrSerie()) && var9 == ((GroupeChrono)this.usersChronoListPaye.get(var8)).getGrpchrNature()) {
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
               this.groupeChrono.setGrpchrNature(var9);
               this.groupeChrono.setGrpchrSerie(var5);
               this.groupeChrono.setGrpchrLib(var7.getLibnature());
            } else {
               this.groupeChrono.setGrpchrNature(0);
               this.groupeChrono.setGrpchrSerie("");
               this.groupeChrono.setGrpchrLib("");
            }
         }
      }

   }

   public void validerChronoPaye() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
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
      if (this.groupeChrono.getGrpchrNature() != 0) {
         if (this.var_action_chronoPaye == 1) {
            this.groupeChrono.setGroupe(this.groupe);
            this.groupeChrono.setGrpchrDateCreat(new Date());
            this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
            this.usersChronoListPaye.add(this.groupeChrono);
            this.datamodelUsersChronoPaye.setWrappedData(this.usersChronoListPaye);
            this.usersChronoListFree.add(this.groupeChrono);
            this.datamodelUsersChronoFree.setWrappedData(this.usersChronoListFree);
         } else if (this.var_action_chronoPaye == 2) {
            this.groupeChrono.setGrpchrDateModif(new Date());
            this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
         }

         this.showModalPanelPaye = false;
      }

   }

   public void annulePaye() {
      this.showModalPanelPaye = false;
   }

   public void ajoutAutoChronoPaye() throws HibernateException, NamingException {
      if (this.mesChronoPayeItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoPayeItems.size(); ++var3) {
               this.inputChronoPaye = ((SelectItem)this.mesChronoPayeItems.get(var3)).getValue().toString();
               this.groupeChrono = new GroupeChrono();
               this.verifChronoPaye(var1);
               if (this.var_aff_val_chronoPaye) {
                  this.groupeChrono.setGrpchrUpdate(0);
                  this.groupeChrono.setGrpchrValidation(2);
                  this.groupeChrono.setGrpchrDeValidation(1);
                  this.groupeChrono.setGrpchrDupplication(1);
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

   public void chargerlesGroupesChronosMed(Session var1) throws HibernateException, NamingException {
      this.usersChronoListMed.clear();
      this.usersChronoListMed = this.groupeChronoDao.selectListVenteByGroupe(this.groupe, var1);
      this.datamodelUsersChronoMed.setWrappedData(this.usersChronoListMed);
      this.testSelectSerieMed = false;
      this.visibiliteBtonMed = true;
   }

   public void selectionLesGroupesMedical() {
      if (this.datamodelUsersChronoMed.isRowAvailable()) {
         this.groupeChrono = (GroupeChrono)this.datamodelUsersChronoMed.getRowData();
         this.visibiliteBtonMed = true;
      }

   }

   public void ajoutChronoMed() {
      this.groupeChrono = new GroupeChrono();
      this.inputChronoMed = "";
      this.var_action_chronoMed = 1;
      this.var_aff_val_chronoMed = false;
      this.showModalPanelMedical = true;
   }

   public void modifChronoMed() {
      if (this.groupeChrono != null) {
         this.var_action_chronoMed = 2;
         this.var_aff_val_chronoMed = true;
         this.showModalPanelMedical = true;
      }

   }

   public void supprimerChronoMed() throws HibernateException, NamingException {
      if (this.groupeChrono != null) {
         this.groupeChronoDao.delete(this.groupeChrono.getGrpchrId());
         this.chargerlesGroupesChronosMed((Session)null);
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
               if (var5.equalsIgnoreCase(((GroupeChrono)this.usersChronoListMed.get(var7)).getGrpchrSerie()) && var4 == ((GroupeChrono)this.usersChronoListMed.get(var7)).getGrpchrNature()) {
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
               this.groupeChrono.setGrpchrNature(var6.getChrNature());
               this.groupeChrono.setGrpchrPrive(var6.getChrPrive());
               this.groupeChrono.setGrpchrSerie(var6.getChrSerie());
               this.groupeChrono.setGrpchrLib(var6.getLibnature() + " " + var6.getChrNom());
            } else {
               this.groupeChrono.setGrpchrNature(0);
               this.groupeChrono.setGrpchrPrive(0);
               this.groupeChrono.setGrpchrSerie("");
               this.groupeChrono.setGrpchrLib("");
            }
         }
      }

   }

   public void validerChronoMed() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
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
      if (this.groupeChrono.getGrpchrNature() != 0) {
         if (this.var_action_chronoMed == 1) {
            this.groupeChrono.setGroupe(this.groupe);
            this.groupeChrono.setGrpchrDateCreat(new Date());
            this.groupeChrono.setGrpchrUserCreat(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.insert(this.groupeChrono, var1);
            this.usersChronoListMed.add(this.groupeChrono);
            this.datamodelUsersChronoMed.setWrappedData(this.usersChronoListMed);
            this.usersChronoListFree.add(this.groupeChrono);
            this.datamodelUsersChronoFree.setWrappedData(this.usersChronoListFree);
         } else if (this.var_action_chronoMed == 2) {
            this.groupeChrono.setGrpchrDateModif(new Date());
            this.groupeChrono.setGrpchrUserModif(this.usersLog.getUsrid());
            this.groupeChrono = this.groupeChronoDao.modifier(this.groupeChrono, var1);
         }

         this.showModalPanelMedical = false;
      }

   }

   public void annuleMedical() {
      this.showModalPanelMedical = false;
   }

   public void ajoutAutoChronoMedical() throws HibernateException, NamingException {
      if (this.mesChronoMedicalItems.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.mesChronoMedicalItems.size(); ++var3) {
               this.inputChronoMed = ((SelectItem)this.mesChronoMedicalItems.get(var3)).getValue().toString();
               this.groupeChrono = new GroupeChrono();
               this.verifChronoMed(var1);
               if (this.var_aff_val_chronoMed) {
                  this.groupeChrono.setGrpchrUpdate(0);
                  this.groupeChrono.setGrpchrValidation(2);
                  this.groupeChrono.setGrpchrDeValidation(1);
                  this.groupeChrono.setGrpchrDupplication(1);
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

   public void chargerlesGroupesChronosFree(Session var1) throws HibernateException, NamingException {
      this.usersChronoListFree.clear();
      this.usersChronoListFree = this.groupeChronoDao.selectListByGroupe(this.groupe, var1);
      this.datamodelUsersChronoFree.setWrappedData(this.usersChronoListFree);
   }

   public void selectionLesGroupesFree() {
      if (this.datamodelUsersChronoFree.isRowAvailable()) {
         this.groupeChrono = (GroupeChrono)this.datamodelUsersChronoFree.getRowData();
      }

   }

   public void toutSelectionner() {
      if (this.listUsers.size() != 0) {
         for(int var1 = 0; var1 < this.listUsers.size(); ++var1) {
            new Users();
            Users var2 = (Users)this.listUsers.get(var1);
            var2.setSelectUser(true);
         }

         this.datamodelUser.setWrappedData(this.listUsers);
      }

   }

   public void rienSelectionner() {
      if (this.listUsers.size() != 0) {
         for(int var1 = 0; var1 < this.listUsers.size(); ++var1) {
            new Users();
            Users var2 = (Users)this.listUsers.get(var1);
            var2.setSelectUser(false);
         }

         this.datamodelUser.setWrappedData(this.listUsers);
      }

   }

   public void miseAJourUsers() throws HibernateException, NamingException {
      this.saveGroupe();
      if (this.listUsers.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);

            for(int var3 = 0; var3 < this.listUsers.size(); ++var3) {
               new Users();
               Users var4 = (Users)this.listUsers.get(var3);
               if (var4.isSelectUser()) {
                  var4.setUsrAccesBrouillard(this.groupe.getGrpAccesBrouillard());
                  var4.setUsrAccesCorrection(this.groupe.getGrpAccesCorrection());
                  var4.setUsrAccesMail(this.groupe.getGrpAccesMail());
                  var4.setUsrAchLibelle(this.groupe.getGrpAchLibelle());
                  var4.setUsrAchPump(this.groupe.getGrpAchPump());
                  var4.setUsrAchats(this.groupe.getGrpAchats());
                  var4.setUsrAcheteur(this.groupe.getGrpAcheteur());
                  var4.setUsrAffPlancher(this.groupe.getGrpAffPlancher());
                  var4.setUsrAffPump(this.groupe.getGrpAffPump());
                  var4.setUsrAffPvMarche(this.groupe.getGrpAffPvMarche());
                  var4.setUsrCaissier(this.groupe.getGrpCaissier());
                  var4.setUsrCaissierDelete(this.groupe.getGrpCaissierDelete());
                  var4.setUsrCaissierDepense(this.groupe.getGrpCaissierDepense());
                  var4.setUsrCaissierModif(this.groupe.getGrpCaissierModif());
                  var4.setUsrCaissierRecette(this.groupe.getGrpCaissierRecette());
                  var4.setUsrCaissierService(this.groupe.getGrpCaissierService());
                  var4.setUsrCaissierTransfert(this.groupe.getGrpCaissierTransfert());
                  var4.setUsrCommAchats(this.groupe.getGrpCommAchats());
                  var4.setUsrCommPourcentage(this.groupe.getGrpCommPourcentage());
                  var4.setUsrCommType(this.groupe.getGrpCommType());
                  var4.setUsrCommVentes(this.groupe.getGrpCommVentes());
                  var4.setUsrCptInterdit(this.groupe.getGrpCptInterdit());
                  var4.setUsrCreationSociete(this.groupe.getGrpCreationSociete());
                  var4.setUsrDateAch(this.groupe.getGrpDateAch());
                  var4.setUsrDateCai(this.groupe.getGrpDateCai());
                  var4.setUsrDateLivre(this.groupe.getGrpDateLivre());
                  var4.setUsrDateMed(this.groupe.getGrpDateMed());
                  var4.setUsrDatePrc(this.groupe.getGrpDatePrc());
                  var4.setUsrDateStk(this.groupe.getGrpDateStk());
                  var4.setUsrDateVte(this.groupe.getGrpDateVte());
                  var4.setUsrDemandeurAchats(this.groupe.getGrpDemandeurAchats());
                  var4.setUsrDepotSel(this.groupe.getGrpDepotSel());
                  var4.setUsrFactureCaisse(this.groupe.getGrpFactureCaisse());
                  var4.setUsrImputCai(this.groupe.getGrpImputCai());
                  var4.setUsrJrxInterdit(this.groupe.getGrpJrxInterdit());
                  var4.setUsrJrxReserve(this.groupe.getGrpJrxReserve());
                  var4.setUsrMail(this.groupe.getGrpMail());
                  var4.setUsrMailCopie(this.groupe.getGrpMailCopie());
                  var4.setUsrMailParapheur(this.groupe.getGrpMailParapheur());
                  var4.setUsrMedical(this.groupe.getGrpMedical());
                  var4.setUsrMf(this.groupe.getGrpMf());
                  var4.setUsrModifLiasse(this.groupe.getGrpModifLiasse());
                  var4.setUsrModifSerieAch(this.groupe.getGrpModifSerieAch());
                  var4.setUsrModifSerieVte(this.groupe.getGrpModifSerieVte());
                  var4.setUsrMontantCai(this.groupe.getGrpMontantCai());
                  var4.setUsrParcAlerte(this.groupe.getGrpParcAlerte());
                  var4.setUsrPayPointage(this.groupe.getGrpPayPointage());
                  var4.setUsrPaye(this.groupe.getGrpPaye());
                  var4.setUsrPayeAlerte(this.groupe.getGrpPayeAlerte());
                  var4.setUsrPayeBulletin(this.groupe.getGrpPayeBulletin());
                  var4.setUsrPayeContrat(this.groupe.getGrpPayeContrat());
                  var4.setUsrPayeService(this.groupe.getGrpPayeService());
                  var4.setUsrPlanning(this.groupe.getGrpPlanning());
                  var4.setUsrPlanningService(this.groupe.getGrpPlanningService());
                  var4.setUsrPr(this.groupe.getGrpPr());
                  var4.setUsrProdService(this.groupe.getGrpProdService());
                  var4.setUsrProdServiceAch(this.groupe.getGrpProdServiceAch());
                  var4.setUsrRecus(this.groupe.getGrpRecus());
                  var4.setUsrRespAchats(this.groupe.getGrpRespAchats());
                  var4.setUsrResponsableVentes(this.groupe.getGrpResponsableVentes());
                  var4.setUsrSignatureAchats(this.groupe.getGrpSignatureAchats());
                  var4.setUsrSignatureCaisse(this.groupe.getGrpSignatureCaisse());
                  var4.setUsrSignatureCompta(this.groupe.getGrpSignatureCompta());
                  var4.setUsrSignatureEducation(this.groupe.getGrpSignatureEducation());
                  var4.setUsrSignatureMedical(this.groupe.getGrpSignatureMedical());
                  var4.setUsrSignatureMicroFinance(this.groupe.getGrpSignatureMicroFinance());
                  var4.setUsrSignatureOffice(this.groupe.getGrpSignatureOffice());
                  var4.setUsrSignatureParc(this.groupe.getGrpSignatureParc());
                  var4.setUsrSignaturePaye(this.groupe.getGrpSignaturePaye());
                  var4.setUsrSignatureVentes(this.groupe.getGrpSignatureVentes());
                  var4.setUsrTiers(this.groupe.getGrpTiers());
                  var4.setUsrTiersCai(this.groupe.getGrpTiersCai());
                  var4.setUsrVendeur(this.groupe.getGrpVendeur());
                  var4.setUsrProdService(this.groupe.getGrpProdService());
                  var4.setUsrVentes(this.groupe.getGrpVentes());
                  var4.setUsrVerPaAch(this.groupe.getGrpVerPaAch());
                  var4.setUsrVerPv(this.groupe.getGrpVerPv());
                  var4.setUsrVerRabais(this.groupe.getGrpVerRabais());
                  var4.setUsrVerRabaisAch(this.groupe.getGrpVerRabaisAch());
                  var4.setUsrVerRemise(this.groupe.getGrpVerRemise());
                  var4.setUsrVerRemiseAch(this.groupe.getGrpVerRemiseAch());
                  var4.setUsrVteLibelle(this.groupe.getGrpVteLibelle());
                  var4 = this.userDao.modUser(var4, var1);
                  new ArrayList();
                  List var5 = this.usersChronoDao.selectListByUser(var4, var1);
                  if (var5.size() != 0) {
                     for(int var6 = 0; var6 < var5.size(); ++var6) {
                        new UsersChrono();
                        UsersChrono var7 = (UsersChrono)var5.get(var6);
                        this.usersChronoDao.delete(var7, var1);
                     }
                  }

                  new ArrayList();
                  List var15 = this.groupeChronoDao.selectListByGroupe(this.groupe, var1);
                  if (var15.size() != 0) {
                     for(int var16 = 0; var16 < var15.size(); ++var16) {
                        new GroupeChrono();
                        GroupeChrono var8 = (GroupeChrono)var15.get(var16);
                        UsersChrono var9 = new UsersChrono();
                        var9.setUsers(var4);
                        var9.setUsrchrDateCreat(new Date());
                        var9.setUsrchrDateModif((Date)null);
                        var9.setUsrchrDeValidation(var8.getGrpchrDeValidation());
                        var9.setUsrchrDupplication(var8.getGrpchrDupplication());
                        var9.setUsrchrLib(var8.getGrpchrLib());
                        var9.setUsrchrNature(var8.getGrpchrNature());
                        var9.setUsrchrPrive(var8.getGrpchrPrive());
                        var9.setUsrchrSerie(var8.getGrpchrSerie());
                        var9.setUsrchrUpdate(var8.getGrpchrUpdate());
                        var9.setUsrchrUserCreat(this.usersLog.getUsrid());
                        var9.setUsrchrUserModif(0L);
                        var9.setUsrchrValidation(var8.getGrpchrValidation());
                        this.usersChronoDao.insert(var9, var1);
                     }
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var13) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var13;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelPropriete = false;
   }

   public void selectionImputationGroupe() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.datamodelGroupes.isRowAvailable()) {
         this.groupe = (Groupe)this.datamodelGroupes.getRowData();
         this.rechercheModuleGroupe();
         if (this.groupe.getGrpModuleFree() == 1) {
            this.selectionModules();
         } else {
            this.localisationModule("8");
            this.lectureFonctions();
            this.lectureOnglets();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
         this.chargerlesGroupesUsers(var1);
         this.chargerlesServices(var1);
         this.chargerlesEquipes(var1);
         this.utilInitHibernate.closeSession();
         this.afficheGroupe = true;
         this.listeFonctions.clear();
         this.datamodelFonctions.setWrappedData(this.listeFonctions);
         this.listeOnglets.clear();
         this.datamodelOnglets.setWrappedData(this.listeOnglets);
         this.usersEnCours = new Users();
      }

   }

   public void selectionImputationUser() throws HibernateException, NamingException {
      if (this.datamodelUser.isRowAvailable()) {
         this.usersEnCours = (Users)this.datamodelUser.getRowData();
         this.chargerlesCaisses((Session)null);
         this.var_visibleBouton = true;
      }

   }

   public void changerGroupe() {
      if (this.usersEnCours != null) {
         this.nouveauGroupe = "";
         this.mesGroupeChangeItems.clear();
         if (this.listeGroupes.size() != 0) {
            for(int var1 = 0; var1 < this.listeGroupes.size(); ++var1) {
               if (!this.usersEnCours.getUsrCollaboration().equals(((Groupe)this.listeGroupes.get(var1)).getGrpCode())) {
                  this.mesGroupeChangeItems.add(new SelectItem(((Groupe)this.listeGroupes.get(var1)).getGrpCode() + ":" + ((Groupe)this.listeGroupes.get(var1)).getGrpLibelle()));
               }
            }
         }

         this.nouveauService = this.usersEnCours.getUsrService();
         this.nouvelleEquipe = this.usersEnCours.getUsrIdEquipe();
         this.nouveauRecu = this.usersEnCours.getUsrRecus();
         this.nouveauFactureCaisse = this.usersEnCours.getUsrFactureCaisse();
         this.showModalPanelChangeGroupe = true;
      }

   }

   public void annulerChangerGroupe() {
      this.var_visibleBouton = false;
      this.showModalPanelChangeGroupe = false;
   }

   public void validerChangeGroupe() throws HibernateException, NamingException {
      if (this.usersEnCours != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "GroupeChrono");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            long var3 = this.usersEnCours.getGroupe().getGrpId();
            String var5 = this.usersEnCours.getUsrCollaboration();
            long var6 = 0L;
            String var8 = this.usersEnCours.getUsrService();
            if (var8 != null && !var8.isEmpty() && var8.contains(":")) {
               String[] var9 = var8.split(":");
               Service var10 = this.serviceDao.chargerLeServiceCode(var9[0], var1);
               if (var10 != null) {
                  var6 = var10.getSerId();
               }
            }

            long var30 = this.usersEnCours.getUsrIdEquipe();
            String var11 = this.usersEnCours.getUsrNomEquipe();
            boolean var12 = false;
            Groupe var13 = new Groupe();
            if (this.nouveauGroupe != null && !this.nouveauGroupe.isEmpty() && this.nouveauGroupe.contains(":")) {
               String[] var14 = this.nouveauGroupe.split(":");
               var13 = this.groupeDao.groupeByCode(var14[0], var1);
               if (var13 != null) {
                  var12 = true;
               }
            }

            Service var31 = new Service();
            if (this.nouveauService != null && !this.nouveauService.isEmpty() && this.nouveauService.contains(":")) {
               String[] var15 = this.nouveauService.split(":");
               var31 = this.serviceDao.chargerLeServiceCode(var15[0], var1);
               if (var31 != null) {
                  var12 = true;
               }
            }

            Equipes var32 = new Equipes();
            if (this.nouvelleEquipe != 0L) {
               var32 = this.equipesDao.rechercheEquipes(this.nouvelleEquipe, var1);
               if (var32 != null) {
                  var12 = true;
               }
            }

            var12 = true;
            if (var12) {
               this.usersEnCours = this.userDao.selectByIdUsers(this.usersEnCours.getUsrid(), var1);
               if (this.usersEnCours != null) {
                  if (var13 != null && var13.getGrpId() != 0L) {
                     this.usersEnCours.setGroupe(var13);
                     this.usersEnCours.setUsrCollaboration(var13.getGrpCode());
                     this.usersEnCours.setUsrAccesBrouillard(var13.getGrpAccesBrouillard());
                     this.usersEnCours.setUsrAccesCorrection(var13.getGrpAccesCorrection());
                     this.usersEnCours.setUsrAccesMail(var13.getGrpAccesMail());
                     this.usersEnCours.setUsrAchLibelle(var13.getGrpAchLibelle());
                     this.usersEnCours.setUsrAchPump(var13.getGrpAchPump());
                     this.usersEnCours.setUsrAchats(var13.getGrpAchats());
                     this.usersEnCours.setUsrAcheteur(var13.getGrpAcheteur());
                     this.usersEnCours.setUsrAffPlancher(var13.getGrpAffPlancher());
                     this.usersEnCours.setUsrAffPump(var13.getGrpAffPump());
                     this.usersEnCours.setUsrAffPvMarche(var13.getGrpAffPvMarche());
                     this.usersEnCours.setUsrCaissier(var13.getGrpCaissier());
                     this.usersEnCours.setUsrCaissierDelete(var13.getGrpCaissierDelete());
                     this.usersEnCours.setUsrCaissierDepense(var13.getGrpCaissierDepense());
                     this.usersEnCours.setUsrCaissierModif(var13.getGrpCaissierModif());
                     this.usersEnCours.setUsrCaissierRecette(var13.getGrpCaissierRecette());
                     this.usersEnCours.setUsrCaissierService(var13.getGrpCaissierService());
                     this.usersEnCours.setUsrCaissierTransfert(var13.getGrpCaissierTransfert());
                     this.usersEnCours.setUsrCommAchats(var13.getGrpCommAchats());
                     this.usersEnCours.setUsrCommPourcentage(var13.getGrpCommPourcentage());
                     this.usersEnCours.setUsrCommType(var13.getGrpCommType());
                     this.usersEnCours.setUsrCommVentes(var13.getGrpCommVentes());
                     this.usersEnCours.setUsrCptInterdit(var13.getGrpCptInterdit());
                     this.usersEnCours.setUsrCreationSociete(var13.getGrpCreationSociete());
                     this.usersEnCours.setUsrDateAch(var13.getGrpDateAch());
                     this.usersEnCours.setUsrDateCai(var13.getGrpDateCai());
                     this.usersEnCours.setUsrDateLivre(var13.getGrpDateLivre());
                     this.usersEnCours.setUsrDateMed(var13.getGrpDateMed());
                     this.usersEnCours.setUsrDatePrc(var13.getGrpDatePrc());
                     this.usersEnCours.setUsrDateStk(var13.getGrpDateStk());
                     this.usersEnCours.setUsrDateVte(var13.getGrpDateVte());
                     this.usersEnCours.setUsrDemandeurAchats(var13.getGrpDemandeurAchats());
                     this.usersEnCours.setUsrDepotSel(var13.getGrpDepotSel());
                     this.usersEnCours.setUsrFactureCaisse(var13.getGrpFactureCaisse());
                     this.usersEnCours.setUsrImputCai(var13.getGrpImputCai());
                     this.usersEnCours.setUsrJrxInterdit(var13.getGrpJrxInterdit());
                     this.usersEnCours.setUsrJrxReserve(var13.getGrpJrxReserve());
                     this.usersEnCours.setUsrMail(var13.getGrpMail());
                     this.usersEnCours.setUsrMailCopie(var13.getGrpMailCopie());
                     this.usersEnCours.setUsrMailParapheur(var13.getGrpMailParapheur());
                     this.usersEnCours.setUsrMedical(var13.getGrpMedical());
                     this.usersEnCours.setUsrMf(var13.getGrpMf());
                     this.usersEnCours.setUsrModifSerieAch(var13.getGrpModifLiasse());
                     this.usersEnCours.setUsrModifSerieAch(var13.getGrpModifSerieAch());
                     this.usersEnCours.setUsrModifSerieVte(var13.getGrpModifSerieVte());
                     this.usersEnCours.setUsrPlanningService(var13.getGrpPlanningService());
                     this.usersEnCours.setUsrParcAlerte(var13.getGrpParcAlerte());
                     this.usersEnCours.setUsrPayPointage(var13.getGrpPayPointage());
                     this.usersEnCours.setUsrPayeBulletin(var13.getGrpPayeBulletin());
                     this.usersEnCours.setUsrPayeContrat(var13.getGrpPayeContrat());
                     this.usersEnCours.setUsrPayeService(var13.getGrpPayeService());
                     this.usersEnCours.setUsrPlanning(var13.getGrpPlanning());
                     this.usersEnCours.setUsrPr(var13.getGrpPr());
                     this.usersEnCours.setUsrRecus(var13.getGrpRecus());
                     this.usersEnCours.setUsrRespAchats(var13.getGrpRespAchats());
                     this.usersEnCours.setUsrResponsableVentes(var13.getGrpResponsableVentes());
                     this.usersEnCours.setUsrSignatureAchats(var13.getGrpSignatureAchats());
                     this.usersEnCours.setUsrSignatureCaisse(var13.getGrpSignatureCaisse());
                     this.usersEnCours.setUsrSignatureCompta(var13.getGrpSignatureCompta());
                     this.usersEnCours.setUsrSignatureEducation(var13.getGrpSignatureEducation());
                     this.usersEnCours.setUsrSignatureMedical(var13.getGrpSignatureMedical());
                     this.usersEnCours.setUsrSignatureMicroFinance(var13.getGrpSignatureMicroFinance());
                     this.usersEnCours.setUsrSignatureOffice(var13.getGrpSignatureOffice());
                     this.usersEnCours.setUsrSignatureParc(var13.getGrpSignatureParc());
                     this.usersEnCours.setUsrSignaturePaye(var13.getGrpSignaturePaye());
                     this.usersEnCours.setUsrSignatureVentes(var13.getGrpSignatureVentes());
                     this.usersEnCours.setUsrTiers(var13.getGrpTiers());
                     this.usersEnCours.setUsrTiersCai(var13.getGrpTiersCai());
                     this.usersEnCours.setUsrVendeur(var13.getGrpVendeur());
                     this.usersEnCours.setUsrVentes(var13.getGrpVentes());
                     this.usersEnCours.setUsrVerPaAch(var13.getGrpVerPaAch());
                     this.usersEnCours.setUsrVerPv(var13.getGrpVerPv());
                     this.usersEnCours.setUsrVerRabais(var13.getGrpVerRabais());
                     this.usersEnCours.setUsrVerRabaisAch(var13.getGrpVerRabaisAch());
                     this.usersEnCours.setUsrVerRemise(var13.getGrpVerRemise());
                     this.usersEnCours.setUsrVerPaAch(var13.getGrpVerRemiseAch());
                     this.usersEnCours.setUsrVteLibelle(var13.getGrpVteLibelle());
                     new ArrayList();
                     List var16 = this.usersChronoDao.selectListToutByUser(this.usersEnCours, var1);
                     if (var16.size() != 0) {
                        for(int var17 = 0; var17 < var16.size(); ++var17) {
                           this.usersChronoDao.delete((UsersChrono)var16.get(var17), var1);
                        }
                     }

                     new ArrayList();
                     List var34 = this.groupeChronoDao.selectListToutByGroupe(var13, var1);
                     if (var34.size() != 0) {
                        new UsersChrono();

                        for(int var19 = 0; var19 < var34.size(); ++var19) {
                           this.groupeChrono = (GroupeChrono)var34.get(var19);
                           UsersChrono var18 = new UsersChrono();
                           var18.setUsers(this.usersEnCours);
                           var18.setUsrchrDateCreat(new Date());
                           var18.setUsrchrDeValidation(this.groupeChrono.getGrpchrDeValidation());
                           var18.setUsrchrDupplication(this.groupeChrono.getGrpchrDupplication());
                           var18.setUsrchrNature(this.groupeChrono.getGrpchrNature());
                           var18.setUsrchrPrive(this.groupeChrono.getGrpchrPrive());
                           var18.setUsrchrUpdate(this.groupeChrono.getGrpchrUpdate());
                           var18.setUsrchrValidation(this.groupeChrono.getGrpchrValidation());
                           var18.setUsrchrLib(this.groupeChrono.getGrpchrLib());
                           var18.setUsrchrSerie(this.groupeChrono.getGrpchrSerie());
                           var18.setUsrchrUserCreat(this.usersLog.getUsrid());
                           this.usersChronoDao.insert(var18);
                        }
                     }
                  }

                  if (var31 != null && var31.getSerId() != 0L) {
                     this.usersEnCours.setUsrService(var31.getSerCode() + ":" + var31.getSerNomFr());
                     this.usersEnCours.setUsrProdServiceAch(0);
                     this.usersEnCours.setUsrProdService(0);
                  } else {
                     this.usersEnCours.setUsrService("");
                     this.usersEnCours.setUsrProdServiceAch(1);
                     this.usersEnCours.setUsrProdService(1);
                  }

                  if (var32 != null && var32.getEquId() != 0L) {
                     this.usersEnCours.setUsrIdEquipe(var32.getEquId());
                     this.usersEnCours.setUsrNomEquipe(var32.getEquNomFr());
                  } else {
                     this.usersEnCours.setUsrIdEquipe(0L);
                     this.usersEnCours.setUsrNomEquipe("");
                  }

                  this.usersEnCours.setUsrRecus(this.nouveauRecu);
                  this.usersEnCours.setUsrFactureCaisse(this.nouveauFactureCaisse);
                  this.usersEnCours = this.userDao.modUser(this.usersEnCours, var1);
                  String var33 = "";
                  String var35 = "";
                  String var36 = "";
                  String var37 = "";
                  if (this.listCaisses.size() != 0) {
                     new CaissesCommerciales();

                     for(int var21 = 0; var21 < this.listCaisses.size(); ++var21) {
                        CaissesCommerciales var20 = (CaissesCommerciales)this.listCaisses.get(var21);
                        UsersChrono var22;
                        int var23;
                        if (!var20.isCaisseSelected() && this.listCaissesUser.size() != 0) {
                           new UsersChrono();

                           for(var23 = 0; var23 < this.listCaissesUser.size(); ++var23) {
                              var22 = (UsersChrono)this.listCaissesUser.get(var23);
                              if (var22.getUsrchrCodeCaisse() != null && !var22.getUsrchrCodeCaisse().isEmpty() && var22.getUsrchrCodeCaisse().equals(var20.getCaiCode()) && var22.getUsrchrNature() == 60) {
                                 var33 = var33 + var20.getCaiCode() + ",";
                                 this.usersChronoDao.delete(var22, var1);
                              }
                           }
                        }

                        if (!var20.isRecuSelected() && this.listCaissesUser.size() != 0) {
                           new UsersChrono();

                           for(var23 = 0; var23 < this.listCaissesUser.size(); ++var23) {
                              var22 = (UsersChrono)this.listCaissesUser.get(var23);
                              if (var22.getUsrchrCodeCaisse() != null && !var22.getUsrchrCodeCaisse().isEmpty() && var22.getUsrchrCodeCaisse().equals(var20.getCaiCode()) && var22.getUsrchrNature() == 61) {
                                 var36 = var36 + var20.getCaiCode() + ",";
                                 this.usersChronoDao.delete(var22, var1);
                              }
                           }
                        }

                        if (var20.isCaisseSelected() || var20.isRecuSelected()) {
                           boolean var40 = false;
                           new UsersChrono();

                           UsersChrono var42;
                           for(int var24 = 0; var24 < this.listCaissesUser.size(); ++var24) {
                              var42 = (UsersChrono)this.listCaissesUser.get(var24);
                              if (var42.getUsrchrCodeCaisse() != null && !var42.getUsrchrCodeCaisse().isEmpty() && var42.getUsrchrCodeCaisse().equals(var20.getCaiCode())) {
                                 var40 = true;
                                 break;
                              }
                           }

                           if (!var40) {
                              if (var20.isCaisseSelected()) {
                                 var35 = var35 + var20.getCaiCode() + ",";
                                 var42 = new UsersChrono();
                                 var42.setUsers(this.usersEnCours);
                                 var42.setUsrchrDateCreat(new Date());
                                 this.chrono = this.chronoDao.chronoBySerieNat("", var20.getCaiCode(), 60, var1);
                                 if (this.chrono != null) {
                                    var42.setUsrchrCodeCaisse(this.chrono.getChrCodeCaisse());
                                    var42.setUsrchrLib(this.chrono.getChrNom());
                                    var42.setUsrchrSerie(this.chrono.getChrSerie());
                                 } else {
                                    var42.setUsrchrCodeCaisse(var20.getCaiCode());
                                    var42.setUsrchrLib(var20.getCaiNom());
                                    var42.setUsrchrSerie("");
                                 }

                                 var42.setUsrchrNature(60);
                                 var42.setUsrchrUpdate(0);
                                 var42.setUsrchrValidation(2);
                                 var42.setUsrchrDeValidation(1);
                                 var42.setUsrchrDupplication(1);
                                 var42.setUsrchrExecution(1);
                                 var42.setUsrchrJournal(1);
                                 var42.setUsrchrUserCreat(this.usersLog.getUsrid());
                                 this.usersChronoDao.insert(var42, var1);
                              }

                              if (var20.isRecuSelected()) {
                                 var37 = var37 + var20.getCaiCode() + ",";
                                 var42 = new UsersChrono();
                                 var42.setUsers(this.usersEnCours);
                                 var42.setUsrchrDateCreat(new Date());
                                 this.chrono = this.chronoDao.chronoBySerieNat("", var20.getCaiCode(), 61, var1);
                                 if (this.chrono != null) {
                                    var42.setUsrchrCodeCaisse(this.chrono.getChrCodeCaisse());
                                    var42.setUsrchrLib(this.chrono.getChrNom());
                                    var42.setUsrchrSerie(this.chrono.getChrSerie());
                                 } else {
                                    var42.setUsrchrCodeCaisse(var20.getCaiCode());
                                    var42.setUsrchrLib(var20.getCaiNom());
                                    var42.setUsrchrSerie("");
                                 }

                                 var42.setUsrchrNature(61);
                                 var42.setUsrchrUpdate(0);
                                 var42.setUsrchrValidation(2);
                                 var42.setUsrchrDeValidation(1);
                                 var42.setUsrchrDupplication(1);
                                 var42.setUsrchrUserCreat(this.usersLog.getUsrid());
                                 this.usersChronoDao.insert(var42, var1);
                              }
                           }
                        }
                     }
                  }

                  Espion var38 = new Espion();
                  EspionDao var39 = new EspionDao(this.baseLog, this.utilInitHibernate);
                  var38.setEspdtecreat(new Date());
                  var38.setUsers(this.usersEnCours);
                  var38.setEsptype(3);
                  String var41 = "";
                  if (var3 != var13.getGrpId() && var13.getGrpId() != 0L) {
                     var41 = "Ancien groupe: " + var5 + " - Nouveau groupe: " + var13.getGrpCode();
                  }

                  if (var6 != var31.getSerId()) {
                     if (var41 != null && !var41.isEmpty()) {
                        var41 = var41 + "  Ancien service: " + var8 + " - Nouveau service: " + var31.getSerNomFr();
                     } else {
                        var41 = "Ancien service: " + var8 + " - Nouveau service: " + var31.getSerNomFr();
                     }
                  }

                  if (var30 != var32.getEquId()) {
                     if (var41 != null && !var41.isEmpty()) {
                        var41 = var41 + "  Ancienne équipe: " + var11 + " - Nouvelle équipe: " + var32.getEquNomFr();
                     } else {
                        var41 = "Ancienne équipe: " + var11 + " - Nouvelle équipe: " + var32.getEquNomFr();
                     }
                  }

                  if (var33 != null && !var33.isEmpty()) {
                     if (var41 != null && !var41.isEmpty()) {
                        var41 = var41 + "  Caisse sup.: " + var33;
                     } else {
                        var41 = "Caisse sup.: " + var33;
                     }
                  }

                  if (var35 != null && !var35.isEmpty()) {
                     if (var41 != null && !var41.isEmpty()) {
                        var41 = var41 + "  Caisse ajt.: " + var35;
                     } else {
                        var41 = "Caisse ajt.: " + var35;
                     }
                  }

                  if (var36 != null && !var36.isEmpty()) {
                     if (var41 != null && !var41.isEmpty()) {
                        var41 = var41 + "  Recu sup.: " + var36;
                     } else {
                        var41 = "Recu sup.: " + var36;
                     }
                  }

                  if (var37 != null && !var37.isEmpty()) {
                     if (var41 != null && !var41.isEmpty()) {
                        var41 = var41 + "  Recu ajt.: " + var37;
                     } else {
                        var41 = "Recu ajt.: " + var37;
                     }
                  }

                  var38.setEspaction(var41);
                  var39.mAJEspion(var38, var1);
               }

               this.chargerlesGroupesUsers(var1);
            }

            var2.commit();
         } catch (HibernateException var28) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var28;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelChangeGroupe = false;
   }

   public boolean isExisteCode() {
      return this.existeCode;
   }

   public void setExisteCode(boolean var1) {
      this.existeCode = var1;
   }

   public String getLien() {
      return this.lien;
   }

   public void setLien(String var1) {
      this.lien = var1;
   }

   public ListDataModel getDatamodelGroupes() {
      return this.datamodelGroupes;
   }

   public void setDatamodelGroupes(ListDataModel var1) {
      this.datamodelGroupes = var1;
   }

   public List getListeGroupes() {
      return this.listeGroupes;
   }

   public void setListeGroupes(List var1) {
      this.listeGroupes = var1;
   }

   public ListDataModel getDatamodelModules() {
      return this.datamodelModules;
   }

   public void setDatamodelModules(ListDataModel var1) {
      this.datamodelModules = var1;
   }

   public List getListeModules() {
      return this.listeModules;
   }

   public void setListeModules(List var1) {
      this.listeModules = var1;
   }

   public ListDataModel getDatamodelFonctions() {
      return this.datamodelFonctions;
   }

   public void setDatamodelFonctions(ListDataModel var1) {
      this.datamodelFonctions = var1;
   }

   public ListDataModel getDatamodelOnglets() {
      return this.datamodelOnglets;
   }

   public void setDatamodelOnglets(ListDataModel var1) {
      this.datamodelOnglets = var1;
   }

   public LectureModulesFonctions getLectureModulesFonctions() {
      return this.lectureModulesFonctions;
   }

   public void setLectureModulesFonctions(LectureModulesFonctions var1) {
      this.lectureModulesFonctions = var1;
   }

   public LectureModulesOnglets getLectureModulesOnglets() {
      return this.lectureModulesOnglets;
   }

   public void setLectureModulesOnglets(LectureModulesOnglets var1) {
      this.lectureModulesOnglets = var1;
   }

   public List getListeFonctions() {
      return this.listeFonctions;
   }

   public void setListeFonctions(List var1) {
      this.listeFonctions = var1;
   }

   public List getListeOnglets() {
      return this.listeOnglets;
   }

   public void setListeOnglets(List var1) {
      this.listeOnglets = var1;
   }

   public Module getModule() {
      return this.module;
   }

   public void setModule(Module var1) {
      this.module = var1;
   }

   public LectureModulesTiers getLectureModulesTiers() {
      return this.lectureModulesTiers;
   }

   public void setLectureModulesTiers(LectureModulesTiers var1) {
      this.lectureModulesTiers = var1;
   }

   public boolean isAfficheGroupe() {
      return this.afficheGroupe;
   }

   public void setAfficheGroupe(boolean var1) {
      this.afficheGroupe = var1;
   }

   public Groupe getGroupe() {
      return this.groupe;
   }

   public void setGroupe(Groupe var1) {
      this.groupe = var1;
   }

   public boolean isShowModalPanelGroupe() {
      return this.showModalPanelGroupe;
   }

   public void setShowModalPanelGroupe(boolean var1) {
      this.showModalPanelGroupe = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }

   public String getModule_commercial() {
      return this.module_commercial;
   }

   public void setModule_commercial(String var1) {
      this.module_commercial = var1;
   }

   public Element getRacine() {
      return this.racine;
   }

   public void setRacine(Element var1) {
      this.racine = var1;
   }

   public ObjetLigneMenu getObjetLigneMenu() {
      return this.objetLigneMenu;
   }

   public void setObjetLigneMenu(ObjetLigneMenu var1) {
      this.objetLigneMenu = var1;
   }

   public ObjetLigneOnglet getObjetLigneOnglet() {
      return this.objetLigneOnglet;
   }

   public void setObjetLigneOnglet(ObjetLigneOnglet var1) {
      this.objetLigneOnglet = var1;
   }

   public boolean isAfficheGroupebal() {
      return this.afficheGroupebal;
   }

   public void setAfficheGroupebal(boolean var1) {
      this.afficheGroupebal = var1;
   }

   public Bal getBal() {
      return this.bal;
   }

   public void setBal(Bal var1) {
      this.bal = var1;
   }

   public DataModel getDataModelBal() {
      return this.dataModelBal;
   }

   public void setDataModelBal(DataModel var1) {
      this.dataModelBal = var1;
   }

   public List getLesBal() {
      return this.lesBal;
   }

   public void setLesBal(List var1) {
      this.lesBal = var1;
   }

   public boolean isShowModalPanelBal() {
      return this.showModalPanelBal;
   }

   public void setShowModalPanelBal(boolean var1) {
      this.showModalPanelBal = var1;
   }

   public boolean isVar_existMail() {
      return this.var_existMail;
   }

   public void setVar_existMail(boolean var1) {
      this.var_existMail = var1;
   }

   public boolean isVar_valide_bal() {
      return this.var_valide_bal;
   }

   public void setVar_valide_bal(boolean var1) {
      this.var_valide_bal = var1;
   }

   public boolean isVisibleBal() {
      return this.visibleBal;
   }

   public void setVisibleBal(boolean var1) {
      this.visibleBal = var1;
   }

   public boolean isVar_mod_achats() {
      return this.var_mod_achats;
   }

   public void setVar_mod_achats(boolean var1) {
      this.var_mod_achats = var1;
   }

   public boolean isVar_mod_caisse() {
      return this.var_mod_caisse;
   }

   public void setVar_mod_caisse(boolean var1) {
      this.var_mod_caisse = var1;
   }

   public boolean isVar_mod_compta() {
      return this.var_mod_compta;
   }

   public void setVar_mod_compta(boolean var1) {
      this.var_mod_compta = var1;
   }

   public boolean isVar_mod_medical() {
      return this.var_mod_medical;
   }

   public void setVar_mod_medical(boolean var1) {
      this.var_mod_medical = var1;
   }

   public boolean isVar_mod_office() {
      return this.var_mod_office;
   }

   public void setVar_mod_office(boolean var1) {
      this.var_mod_office = var1;
   }

   public boolean isVar_mod_parc() {
      return this.var_mod_parc;
   }

   public void setVar_mod_parc(boolean var1) {
      this.var_mod_parc = var1;
   }

   public boolean isVar_mod_paye() {
      return this.var_mod_paye;
   }

   public void setVar_mod_paye(boolean var1) {
      this.var_mod_paye = var1;
   }

   public boolean isVar_mod_stock() {
      return this.var_mod_stock;
   }

   public void setVar_mod_stock(boolean var1) {
      this.var_mod_stock = var1;
   }

   public boolean isVar_mod_tiers() {
      return this.var_mod_tiers;
   }

   public void setVar_mod_tiers(boolean var1) {
      this.var_mod_tiers = var1;
   }

   public boolean isVar_mod_ventes() {
      return this.var_mod_ventes;
   }

   public void setVar_mod_ventes(boolean var1) {
      this.var_mod_ventes = var1;
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

   public boolean isVar_mod_free() {
      return this.var_mod_free;
   }

   public void setVar_mod_free(boolean var1) {
      this.var_mod_free = var1;
   }

   public boolean isShowModalPanelPropriete() {
      return this.showModalPanelPropriete;
   }

   public void setShowModalPanelPropriete(boolean var1) {
      this.showModalPanelPropriete = var1;
   }

   public DataModel getDatamodelUsersChronoAch() {
      return this.datamodelUsersChronoAch;
   }

   public void setDatamodelUsersChronoAch(DataModel var1) {
      this.datamodelUsersChronoAch = var1;
   }

   public DataModel getDatamodelUsersChronoMed() {
      return this.datamodelUsersChronoMed;
   }

   public void setDatamodelUsersChronoMed(DataModel var1) {
      this.datamodelUsersChronoMed = var1;
   }

   public DataModel getDatamodelUsersChronoOff() {
      return this.datamodelUsersChronoOff;
   }

   public void setDatamodelUsersChronoOff(DataModel var1) {
      this.datamodelUsersChronoOff = var1;
   }

   public DataModel getDatamodelUsersChronoPaye() {
      return this.datamodelUsersChronoPaye;
   }

   public void setDatamodelUsersChronoPaye(DataModel var1) {
      this.datamodelUsersChronoPaye = var1;
   }

   public DataModel getDatamodelUsersChronoVte() {
      return this.datamodelUsersChronoVte;
   }

   public void setDatamodelUsersChronoVte(DataModel var1) {
      this.datamodelUsersChronoVte = var1;
   }

   public DataModel getDatamodelUsersChronoCaiss() {
      return this.datamodelUsersChronoCaiss;
   }

   public void setDatamodelUsersChronoCaiss(DataModel var1) {
      this.datamodelUsersChronoCaiss = var1;
   }

   public boolean isVisibiliteBtonAch() {
      return this.visibiliteBtonAch;
   }

   public void setVisibiliteBtonAch(boolean var1) {
      this.visibiliteBtonAch = var1;
   }

   public boolean isVisibiliteBtonCaiss() {
      return this.visibiliteBtonCaiss;
   }

   public void setVisibiliteBtonCaiss(boolean var1) {
      this.visibiliteBtonCaiss = var1;
   }

   public boolean isVisibiliteBtonOff() {
      return this.visibiliteBtonOff;
   }

   public void setVisibiliteBtonOff(boolean var1) {
      this.visibiliteBtonOff = var1;
   }

   public boolean isVisibiliteBtonPaye() {
      return this.visibiliteBtonPaye;
   }

   public void setVisibiliteBtonPaye(boolean var1) {
      this.visibiliteBtonPaye = var1;
   }

   public boolean isVisibiliteBtonVte() {
      return this.visibiliteBtonVte;
   }

   public void setVisibiliteBtonVte(boolean var1) {
      this.visibiliteBtonVte = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public GroupeChrono getGroupeChrono() {
      return this.groupeChrono;
   }

   public void setGroupeChrono(GroupeChrono var1) {
      this.groupeChrono = var1;
   }

   public String getInputChronoOff() {
      return this.inputChronoOff;
   }

   public void setInputChronoOff(String var1) {
      this.inputChronoOff = var1;
   }

   public boolean isShowModalPanelOffice() {
      return this.showModalPanelOffice;
   }

   public void setShowModalPanelOffice(boolean var1) {
      this.showModalPanelOffice = var1;
   }

   public int getVar_action_chronoOff() {
      return this.var_action_chronoOff;
   }

   public void setVar_action_chronoOff(int var1) {
      this.var_action_chronoOff = var1;
   }

   public boolean isVar_aff_val_chronoOff() {
      return this.var_aff_val_chronoOff;
   }

   public void setVar_aff_val_chronoOff(boolean var1) {
      this.var_aff_val_chronoOff = var1;
   }

   public String getDepot() {
      return this.depot;
   }

   public void setDepot(String var1) {
      this.depot = var1;
   }

   public String getInputChronoAch() {
      return this.inputChronoAch;
   }

   public void setInputChronoAch(String var1) {
      this.inputChronoAch = var1;
   }

   public String getInputChronoCaisse() {
      return this.inputChronoCaisse;
   }

   public void setInputChronoCaisse(String var1) {
      this.inputChronoCaisse = var1;
   }

   public String getInputChronoMed() {
      return this.inputChronoMed;
   }

   public void setInputChronoMed(String var1) {
      this.inputChronoMed = var1;
   }

   public String getInputChronoPaye() {
      return this.inputChronoPaye;
   }

   public void setInputChronoPaye(String var1) {
      this.inputChronoPaye = var1;
   }

   public String getInputChronoVte() {
      return this.inputChronoVte;
   }

   public void setInputChronoVte(String var1) {
      this.inputChronoVte = var1;
   }

   public boolean isShowModalPanelAchat() {
      return this.showModalPanelAchat;
   }

   public void setShowModalPanelAchat(boolean var1) {
      this.showModalPanelAchat = var1;
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

   public boolean isTestSelectSerieAch() {
      return this.testSelectSerieAch;
   }

   public void setTestSelectSerieAch(boolean var1) {
      this.testSelectSerieAch = var1;
   }

   public boolean isTestSelectSerieCaiss() {
      return this.testSelectSerieCaiss;
   }

   public void setTestSelectSerieCaiss(boolean var1) {
      this.testSelectSerieCaiss = var1;
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

   public boolean isTestSelectSeriePaye() {
      return this.testSelectSeriePaye;
   }

   public void setTestSelectSeriePaye(boolean var1) {
      this.testSelectSeriePaye = var1;
   }

   public boolean isTestSelectSerieVte() {
      return this.testSelectSerieVte;
   }

   public void setTestSelectSerieVte(boolean var1) {
      this.testSelectSerieVte = var1;
   }

   public int getVar_action_chronoAch() {
      return this.var_action_chronoAch;
   }

   public void setVar_action_chronoAch(int var1) {
      this.var_action_chronoAch = var1;
   }

   public int getVar_action_chronoCaisse() {
      return this.var_action_chronoCaisse;
   }

   public void setVar_action_chronoCaisse(int var1) {
      this.var_action_chronoCaisse = var1;
   }

   public int getVar_action_chronoMed() {
      return this.var_action_chronoMed;
   }

   public void setVar_action_chronoMed(int var1) {
      this.var_action_chronoMed = var1;
   }

   public int getVar_action_chronoPaye() {
      return this.var_action_chronoPaye;
   }

   public void setVar_action_chronoPaye(int var1) {
      this.var_action_chronoPaye = var1;
   }

   public int getVar_action_chronoVte() {
      return this.var_action_chronoVte;
   }

   public void setVar_action_chronoVte(int var1) {
      this.var_action_chronoVte = var1;
   }

   public boolean isVar_aff_val_chronoAch() {
      return this.var_aff_val_chronoAch;
   }

   public void setVar_aff_val_chronoAch(boolean var1) {
      this.var_aff_val_chronoAch = var1;
   }

   public boolean isVar_aff_val_chronoCaisse() {
      return this.var_aff_val_chronoCaisse;
   }

   public void setVar_aff_val_chronoCaisse(boolean var1) {
      this.var_aff_val_chronoCaisse = var1;
   }

   public boolean isVar_aff_val_chronoMed() {
      return this.var_aff_val_chronoMed;
   }

   public void setVar_aff_val_chronoMed(boolean var1) {
      this.var_aff_val_chronoMed = var1;
   }

   public boolean isVar_aff_val_chronoPaye() {
      return this.var_aff_val_chronoPaye;
   }

   public void setVar_aff_val_chronoPaye(boolean var1) {
      this.var_aff_val_chronoPaye = var1;
   }

   public boolean isVar_aff_val_chronoVte() {
      return this.var_aff_val_chronoVte;
   }

   public void setVar_aff_val_chronoVte(boolean var1) {
      this.var_aff_val_chronoVte = var1;
   }

   public boolean isVisibiliteBtonMed() {
      return this.visibiliteBtonMed;
   }

   public void setVisibiliteBtonMed(boolean var1) {
      this.visibiliteBtonMed = var1;
   }

   public List getMesChronoAchatsItems() {
      return this.mesChronoAchatsItems;
   }

   public void setMesChronoAchatsItems(List var1) {
      this.mesChronoAchatsItems = var1;
   }

   public List getMesChronoCaisseItems() {
      return this.mesChronoCaisseItems;
   }

   public void setMesChronoCaisseItems(List var1) {
      this.mesChronoCaisseItems = var1;
   }

   public List getMesChronoMedicalItems() {
      return this.mesChronoMedicalItems;
   }

   public void setMesChronoMedicalItems(List var1) {
      this.mesChronoMedicalItems = var1;
   }

   public List getMesChronoOfficeItems() {
      return this.mesChronoOfficeItems;
   }

   public void setMesChronoOfficeItems(List var1) {
      this.mesChronoOfficeItems = var1;
   }

   public List getMesChronoPayeItems() {
      return this.mesChronoPayeItems;
   }

   public void setMesChronoPayeItems(List var1) {
      this.mesChronoPayeItems = var1;
   }

   public List getMesChronoVentesItems() {
      return this.mesChronoVentesItems;
   }

   public void setMesChronoVentesItems(List var1) {
      this.mesChronoVentesItems = var1;
   }

   public List getMesDepotsItems() {
      return this.mesDepotsItems;
   }

   public void setMesDepotsItems(List var1) {
      this.mesDepotsItems = var1;
   }

   public DataModel getDatamodelUser() {
      return this.datamodelUser;
   }

   public void setDatamodelUser(DataModel var1) {
      this.datamodelUser = var1;
   }

   public DataModel getDatamodelUsersChronoFree() {
      return this.datamodelUsersChronoFree;
   }

   public void setDatamodelUsersChronoFree(DataModel var1) {
      this.datamodelUsersChronoFree = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isVar_mod_edu() {
      return this.var_mod_edu;
   }

   public void setVar_mod_edu(boolean var1) {
      this.var_mod_edu = var1;
   }

   public boolean isVar_mod_mef() {
      return this.var_mod_mef;
   }

   public void setVar_mod_mef(boolean var1) {
      this.var_mod_mef = var1;
   }

   public List getMesChronoEduItems() {
      return this.mesChronoEduItems;
   }

   public void setMesChronoEduItems(List var1) {
      this.mesChronoEduItems = var1;
   }

   public List getMesChronoMefItems() {
      return this.mesChronoMefItems;
   }

   public void setMesChronoMefItems(List var1) {
      this.mesChronoMefItems = var1;
   }

   public boolean isShowModalPanelModele() {
      return this.showModalPanelModele;
   }

   public void setShowModalPanelModele(boolean var1) {
      this.showModalPanelModele = var1;
   }

   public DataModel getDatamodelModelPaye() {
      return this.datamodelModelPaye;
   }

   public void setDatamodelModelPaye(DataModel var1) {
      this.datamodelModelPaye = var1;
   }

   public DataModel getDatamodelModelPayeUtil() {
      return this.datamodelModelPayeUtil;
   }

   public void setDatamodelModelPayeUtil(DataModel var1) {
      this.datamodelModelPayeUtil = var1;
   }

   public DataModel getDatamodelModelAchats() {
      return this.datamodelModelAchats;
   }

   public void setDatamodelModelAchats(DataModel var1) {
      this.datamodelModelAchats = var1;
   }

   public DataModel getDatamodelModelAchatsUtil() {
      return this.datamodelModelAchatsUtil;
   }

   public void setDatamodelModelAchatsUtil(DataModel var1) {
      this.datamodelModelAchatsUtil = var1;
   }

   public DataModel getDatamodelModelCaisses() {
      return this.datamodelModelCaisses;
   }

   public void setDatamodelModelCaisses(DataModel var1) {
      this.datamodelModelCaisses = var1;
   }

   public DataModel getDatamodelModelCaissesUtil() {
      return this.datamodelModelCaissesUtil;
   }

   public void setDatamodelModelCaissesUtil(DataModel var1) {
      this.datamodelModelCaissesUtil = var1;
   }

   public DataModel getDatamodelModelCompta() {
      return this.datamodelModelCompta;
   }

   public void setDatamodelModelCompta(DataModel var1) {
      this.datamodelModelCompta = var1;
   }

   public DataModel getDatamodelModelComptaUtil() {
      return this.datamodelModelComptaUtil;
   }

   public void setDatamodelModelComptaUtil(DataModel var1) {
      this.datamodelModelComptaUtil = var1;
   }

   public DataModel getDatamodelModelEducation() {
      return this.datamodelModelEducation;
   }

   public void setDatamodelModelEducation(DataModel var1) {
      this.datamodelModelEducation = var1;
   }

   public DataModel getDatamodelModelEducationUtil() {
      return this.datamodelModelEducationUtil;
   }

   public void setDatamodelModelEducationUtil(DataModel var1) {
      this.datamodelModelEducationUtil = var1;
   }

   public DataModel getDatamodelModelMedical() {
      return this.datamodelModelMedical;
   }

   public void setDatamodelModelMedical(DataModel var1) {
      this.datamodelModelMedical = var1;
   }

   public DataModel getDatamodelModelMedicalUtil() {
      return this.datamodelModelMedicalUtil;
   }

   public void setDatamodelModelMedicalUtil(DataModel var1) {
      this.datamodelModelMedicalUtil = var1;
   }

   public DataModel getDatamodelModelMicrofinance() {
      return this.datamodelModelMicrofinance;
   }

   public void setDatamodelModelMicrofinance(DataModel var1) {
      this.datamodelModelMicrofinance = var1;
   }

   public DataModel getDatamodelModelMicrofinanceUtil() {
      return this.datamodelModelMicrofinanceUtil;
   }

   public void setDatamodelModelMicrofinanceUtil(DataModel var1) {
      this.datamodelModelMicrofinanceUtil = var1;
   }

   public DataModel getDatamodelModelParc() {
      return this.datamodelModelParc;
   }

   public void setDatamodelModelParc(DataModel var1) {
      this.datamodelModelParc = var1;
   }

   public DataModel getDatamodelModelParcUtil() {
      return this.datamodelModelParcUtil;
   }

   public void setDatamodelModelParcUtil(DataModel var1) {
      this.datamodelModelParcUtil = var1;
   }

   public DataModel getDatamodelModelStocks() {
      return this.datamodelModelStocks;
   }

   public void setDatamodelModelStocks(DataModel var1) {
      this.datamodelModelStocks = var1;
   }

   public DataModel getDatamodelModelStocksUtil() {
      return this.datamodelModelStocksUtil;
   }

   public void setDatamodelModelStocksUtil(DataModel var1) {
      this.datamodelModelStocksUtil = var1;
   }

   public DataModel getDatamodelModelVentes() {
      return this.datamodelModelVentes;
   }

   public void setDatamodelModelVentes(DataModel var1) {
      this.datamodelModelVentes = var1;
   }

   public DataModel getDatamodelModelVentesUtil() {
      return this.datamodelModelVentesUtil;
   }

   public void setDatamodelModelVentesUtil(DataModel var1) {
      this.datamodelModelVentesUtil = var1;
   }

   public DataModel getDatamodelModelOffice() {
      return this.datamodelModelOffice;
   }

   public void setDatamodelModelOffice(DataModel var1) {
      this.datamodelModelOffice = var1;
   }

   public DataModel getDatamodelModelOfficeUtil() {
      return this.datamodelModelOfficeUtil;
   }

   public void setDatamodelModelOfficeUtil(DataModel var1) {
      this.datamodelModelOfficeUtil = var1;
   }

   public boolean isVar_visibleBouton() {
      return this.var_visibleBouton;
   }

   public void setVar_visibleBouton(boolean var1) {
      this.var_visibleBouton = var1;
   }

   public boolean isShowModalPanelChangeGroupe() {
      return this.showModalPanelChangeGroupe;
   }

   public void setShowModalPanelChangeGroupe(boolean var1) {
      this.showModalPanelChangeGroupe = var1;
   }

   public String getNouveauGroupe() {
      return this.nouveauGroupe;
   }

   public void setNouveauGroupe(String var1) {
      this.nouveauGroupe = var1;
   }

   public Users getUsersEnCours() {
      return this.usersEnCours;
   }

   public void setUsersEnCours(Users var1) {
      this.usersEnCours = var1;
   }

   public List getMesEquipesItems() {
      return this.mesEquipesItems;
   }

   public void setMesEquipesItems(List var1) {
      this.mesEquipesItems = var1;
   }

   public List getMesGroupeChangeItems() {
      return this.mesGroupeChangeItems;
   }

   public void setMesGroupeChangeItems(List var1) {
      this.mesGroupeChangeItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public String getNouveauService() {
      return this.nouveauService;
   }

   public void setNouveauService(String var1) {
      this.nouveauService = var1;
   }

   public long getNouvelleEquipe() {
      return this.nouvelleEquipe;
   }

   public void setNouvelleEquipe(long var1) {
      this.nouvelleEquipe = var1;
   }

   public int getNouveauRecu() {
      return this.nouveauRecu;
   }

   public void setNouveauRecu(int var1) {
      this.nouveauRecu = var1;
   }

   public int getNouveauFactureCaisse() {
      return this.nouveauFactureCaisse;
   }

   public void setNouveauFactureCaisse(int var1) {
      this.nouveauFactureCaisse = var1;
   }

   public List getLesStructuresPeg() {
      return this.lesStructuresPeg;
   }

   public void setLesStructuresPeg(List var1) {
      this.lesStructuresPeg = var1;
   }

   public boolean isVar_mod_rep() {
      return this.var_mod_rep;
   }

   public void setVar_mod_rep(boolean var1) {
      this.var_mod_rep = var1;
   }

   public DataModel getDatamodelModelReporting() {
      return this.datamodelModelReporting;
   }

   public void setDatamodelModelReporting(DataModel var1) {
      this.datamodelModelReporting = var1;
   }

   public DataModel getDatamodelModelReportingUtil() {
      return this.datamodelModelReportingUtil;
   }

   public void setDatamodelModelReportingUtil(DataModel var1) {
      this.datamodelModelReportingUtil = var1;
   }

   public DataModel getDatamodelModelTiers() {
      return this.datamodelModelTiers;
   }

   public void setDatamodelModelTiers(DataModel var1) {
      this.datamodelModelTiers = var1;
   }

   public DataModel getDatamodelModelTiersUtil() {
      return this.datamodelModelTiersUtil;
   }

   public void setDatamodelModelTiersUtil(DataModel var1) {
      this.datamodelModelTiersUtil = var1;
   }
}
