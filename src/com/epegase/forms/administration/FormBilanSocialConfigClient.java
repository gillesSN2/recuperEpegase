package com.epegase.forms.administration;

import com.epegase.systeme.classe.BsoTabElement;
import com.epegase.systeme.classe.BsoTabFormule;
import com.epegase.systeme.classe.BsoTabNom;
import com.epegase.systeme.classe.PegTabElement;
import com.epegase.systeme.classe.PegTabNom;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EtatFinancier;
import com.epegase.systeme.dao.BsoTabElementDao;
import com.epegase.systeme.dao.BsoTabFormuleDao;
import com.epegase.systeme.dao.BsoTabNomDao;
import com.epegase.systeme.dao.PegTabElementDao;
import com.epegase.systeme.dao.PegTabFormuleDao;
import com.epegase.systeme.dao.PegTabNomDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormBilanSocialConfigClient implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private int nature;
   private long IdZoneFiscale;
   private int nombredecolonne;
   private String tabliszone;
   private int tabforcol;
   private transient DataModel datamodeltabNom = new ListDataModel();
   private transient DataModel datamodeltabElement = new ListDataModel();
   private transient DataModel datamodeltabFormule = new ListDataModel();
   private List lesCptTabNom = new ArrayList();
   private List lesNomsCol = new ArrayList();
   private transient DataModel dataModelLesNomsCol = new ListDataModel();
   private List lesPegTabElements = new ArrayList();
   private BsoTabElement cptTabElement = new BsoTabElement();
   private BsoTabFormule cptTabFormule = new BsoTabFormule();
   private BsoTabNom cptTabNom = new BsoTabNom();
   private List lesPegTabFormules = new ArrayList();
   private BsoTabNomDao bsoTabNomDao;
   private BsoTabElementDao bsoTabElementDao;
   private BsoTabFormuleDao bsoTabFormuleDao;
   private EtatFinancier etatFinancier = new EtatFinancier();
   private boolean testAffTabNomSave = false;
   private boolean testAffTabNomSuppModif = false;
   private boolean testAffTabElementSave = false;
   private boolean testAffTabElementuppModif = false;
   private boolean testAffTabFormuleSave = false;
   private boolean testAffTabFormuleSuppModif = false;
   private boolean testImprimer = false;
   private String lesIdCptTabnom;
   private String lesIdCptTabElement;
   private String lesIdCptTabFormule;
   private PegTabNomDao pegTabNomDao;
   private PegTabElementDao pegTabElementDao;
   private PegTabFormuleDao pegTabFormuleDao;
   private String lesIdPegNom;
   private String lesIdPegElement;
   private boolean masqueAnalytique = false;
   private List lesFormulesMemo = new ArrayList();
   private String filtre;
   private String requete;
   private String nomCellule;
   private int natureCellule;
   private boolean afficheCellule = false;
   private boolean decoupageanalytique;

   public void InstancesDaoUtilses() {
      this.bsoTabElementDao = new BsoTabElementDao(this.baseLog, this.utilInitHibernate);
      this.bsoTabFormuleDao = new BsoTabFormuleDao(this.baseLog, this.utilInitHibernate);
      this.bsoTabNomDao = new BsoTabNomDao(this.baseLog, this.utilInitHibernate);
      this.pegTabNomDao = new PegTabNomDao(this.utilInitHibernate);
      this.pegTabElementDao = new PegTabElementDao(this.utilInitHibernate);
      this.pegTabFormuleDao = new PegTabFormuleDao(this.utilInitHibernate);
   }

   public List chargerMesTabNom(Session var1) throws HibernateException, NamingException {
      this.lesCptTabNom = new ArrayList();
      this.datamodeltabNom = new ListDataModel();
      this.lesCptTabNom = this.bsoTabNomDao.chargerMesTabNomConf(this.nature, this.structureLog.getStrbilansocial(), var1);
      this.datamodeltabNom.setWrappedData(this.lesCptTabNom);
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageanalytique = true;
      } else {
         this.decoupageanalytique = false;
      }

      return this.lesCptTabNom;
   }

   public void genererDefautConfig() throws HibernateException, NamingException {
      this.genererDefaultEtat();
      this.chargerMesTabNom((Session)null);
   }

   public void genererDefaultEtat() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BsoTabNom");
      this.recuperLesIdTabNom(var1);
      this.recuperLesIdTabElement(var1);
      this.recuperLesIdTabFormule(var1);
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.bsoTabFormuleDao.deleteCpttabFormule(this.lesIdCptTabFormule, var1);
         this.bsoTabElementDao.deleteCpttabElement(this.lesIdCptTabElement, var1);
         this.bsoTabNomDao.deletePegtabNom(this.lesIdCptTabnom, var1);
         var2.commit();
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      var1 = this.utilInitHibernate.getSysteme();
      new ArrayList();
      List var3 = this.recupererLespegTabNom(var1);
      new ArrayList();
      List var4 = this.recupererLespegTabElement(var1);
      new ArrayList();
      List var5 = this.recupererLespegTabFormule(var1);
      this.utilInitHibernate.closeSession();
      var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BsoTabNom");
      this.saveLespegTabNom(var3, var1);
      this.saveLespegTabElement(var4, this.lesCptTabNom, var1);
      this.saveLespegTabFormule(var5, this.lesPegTabElements, var1);
      this.utilInitHibernate.closeSession();
   }

   public void saveLespegTabNom(List var1, Session var2) throws HibernateException, NamingException {
      this.lesCptTabNom = this.bsoTabNomDao.savePegtabNom(var1, var2);
   }

   public void saveLespegTabElement(List var1, List var2, Session var3) throws HibernateException, NamingException {
      this.lesPegTabElements = this.bsoTabElementDao.savePegtabElement(var1, var2, var3);
   }

   public void saveLespegTabFormule(List var1, List var2, Session var3) throws HibernateException, NamingException {
      this.bsoTabFormuleDao.savePegtabFormule(var1, var2, var3);
   }

   public List recuperMesTabElment() throws HibernateException, NamingException {
      new ArrayList();
      List var1 = this.bsoTabElementDao.chargerMesTabElement();
      return var1;
   }

   public String recuperLesIdTabNom(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.bsoTabNomDao.chargerMesTabNomConf(10, this.structureLog.getStrbilansocial(), var1);
      this.lesIdCptTabnom = "0000";

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         new BsoTabNom();
         BsoTabNom var4 = (BsoTabNom)var2.get(var3);
         this.lesIdCptTabnom = this.lesIdCptTabnom + "," + var4.getTablis_id();
      }

      this.lesIdCptTabnom = "(" + this.lesIdCptTabnom + ")";
      return this.lesIdCptTabnom;
   }

   public String recuperLesIdTabElement(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.bsoTabElementDao.chargerMesTabElement(this.lesIdCptTabnom, var1);
      this.lesIdCptTabElement = "0000";

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         new BsoTabElement();
         BsoTabElement var4 = (BsoTabElement)var2.get(var3);
         this.lesIdCptTabElement = this.lesIdCptTabElement + "," + var4.getTabele_id();
      }

      this.lesIdCptTabElement = "(" + this.lesIdCptTabElement + ")";
      return this.lesIdCptTabElement;
   }

   public String recuperLesIdTabFormule(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.bsoTabFormuleDao.chargerMesTabFormule(this.lesIdCptTabElement, var1);
      this.lesIdCptTabFormule = "0000";

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         new BsoTabFormule();
         BsoTabFormule var4 = (BsoTabFormule)var2.get(var3);
         this.lesIdCptTabFormule = this.lesIdCptTabFormule + "," + var4.getTabfor_id();
      }

      this.lesIdCptTabFormule = "(" + this.lesIdCptTabFormule + ")";
      return this.lesIdCptTabFormule;
   }

   public List recupererLespegTabNom(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.pegTabNomDao.chargerMesTabNomEF(this.getTabliszone(), var1);
      this.lesIdPegNom = "0000";

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         new PegTabNom();
         PegTabNom var4 = (PegTabNom)var2.get(var3);
         this.lesIdPegNom = this.lesIdPegNom + "," + var4.getTablis_id();
      }

      this.lesIdPegNom = "(" + this.lesIdPegNom + ")";
      return var2;
   }

   public List recupererLespegTabElement(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.pegTabElementDao.chargerMesTabElementByFKId(this.lesIdPegNom, var1);
      this.lesIdPegElement = "0000";

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         new PegTabElement();
         PegTabElement var4 = (PegTabElement)var2.get(var3);
         this.lesIdPegElement = this.lesIdPegElement + "," + var4.getTabele_id();
      }

      this.lesIdPegElement = "(" + this.lesIdPegElement + ")";
      return var2;
   }

   public List recupererLespegTabFormule(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.pegTabFormuleDao.chargerMesTabFormuleByFKId(this.lesIdPegElement, var1);
      return var2;
   }

   public void ajouterTableau() {
      this.cptTabNom = new BsoTabNom();
      this.masqueAnalytique = true;
   }

   public void saveTableau() throws HibernateException, NamingException {
      if (this.cptTabNom.isVar_tab_inactif()) {
         this.cptTabNom.setTablisInactif(1);
      } else {
         this.cptTabNom.setTablisInactif(0);
      }

      if (this.cptTabNom.getTablis_id() == 0L) {
         this.cptTabNom = this.bsoTabNomDao.insertTableau(this.cptTabNom, this.getTabliszone());
         this.lesCptTabNom.add(this.cptTabNom);
         this.datamodeltabNom.setWrappedData(this.lesCptTabNom);
      } else {
         this.cptTabNom = this.bsoTabNomDao.modifTableau(this.cptTabNom);
      }

      if (this.cptTabNom.getTablisAnalytique() != null && !this.cptTabNom.getTablisAnalytique().isEmpty()) {
         this.masqueAnalytique = true;
      } else {
         this.masqueAnalytique = false;
      }

   }

   public void deleteTableau() throws HibernateException, NamingException {
      this.bsoTabNomDao.deletePegtabNom(this.cptTabNom);
      this.chargerMesTabNomTB();
      this.chargerLesNomsCol();
   }

   public void saveColonne() throws HibernateException, NamingException {
      this.etatFinancier = this.bsoTabNomDao.updateCpttabNomCol(this.tabforcol, this.etatFinancier, this.cptTabNom);
   }

   public void ajouterElement() {
      this.cptTabElement = new BsoTabElement();
   }

   public void saveElemnent() throws HibernateException, NamingException {
      if (this.cptTabElement.getTabele_id() == 0L) {
         int var1 = this.lesPegTabElements.size() + 1;
         this.cptTabElement.setTabeleNum(var1);
         this.cptTabElement = this.bsoTabElementDao.insertElement(this.cptTabElement, this.cptTabNom);
         this.lesPegTabElements.add(this.cptTabElement);
         this.datamodeltabElement.setWrappedData(this.lesPegTabElements);
      } else {
         this.cptTabElement = this.bsoTabElementDao.modifElement(this.cptTabElement);
      }

   }

   public void deleteElemnent() throws HibernateException, NamingException {
      this.bsoTabElementDao.deleteElement(this.cptTabElement);
      this.chargerMesTabElement();
      this.setTestAffTabElementuppModif(false);
      this.setTestAffTabFormuleSave(false);
      this.setTestAffTabFormuleSuppModif(false);
   }

   public void ajouterFormule() {
      this.cptTabFormule = new BsoTabFormule();
      if (this.tabforcol == 1) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn01());
      } else if (this.tabforcol == 2) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn02());
      } else if (this.tabforcol == 3) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn03());
      } else if (this.tabforcol == 4) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn04());
      } else if (this.tabforcol == 5) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn05());
      } else if (this.tabforcol == 6) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn06());
      } else if (this.tabforcol == 7) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn07());
      } else if (this.tabforcol == 8) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn08());
      } else if (this.tabforcol == 9) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn09());
      } else if (this.tabforcol == 10) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn10());
      } else if (this.tabforcol == 11) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn11());
      } else if (this.tabforcol == 12) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn12());
      } else if (this.tabforcol == 13) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn13());
      } else if (this.tabforcol == 14) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn14());
      } else if (this.tabforcol == 15) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn15());
      } else if (this.tabforcol == 16) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn16());
      } else if (this.tabforcol == 17) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn17());
      } else if (this.tabforcol == 18) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn18());
      } else if (this.tabforcol == 19) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn19());
      } else if (this.tabforcol == 20) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn20());
      }

   }

   public void saveFormule() throws HibernateException, NamingException {
      this.cptTabFormule.setTabforSite("");
      this.cptTabFormule.setTabforDepartement("");
      this.cptTabFormule.setTabforService("");
      this.cptTabFormule.setTabforRegion("");
      this.cptTabFormule.setTabforSecteur("");
      this.cptTabFormule.setTabforPdv("");
      this.cptTabFormule.setTabforActivite("");
      this.cptTabFormule.setTabforDossier("");
      this.cptTabFormule.setTabforParc("");
      if (this.cptTabFormule.getTabforAnalytique() != null && !this.cptTabFormule.getTabforAnalytique().isEmpty()) {
         if (this.cptTabFormule.getTabforAnalytique().contains(":")) {
            String[] var1 = this.cptTabFormule.getTabforAnalytique().split(":");

            for(int var2 = 0; var2 < var1.length; ++var2) {
               this.calculeAxe(var1[var2]);
            }
         } else {
            this.calculeAxe(this.cptTabFormule.getTabforAnalytique());
         }
      }

      if (this.cptTabFormule.getTabfor_id() == 0L) {
         this.cptTabFormule = this.bsoTabFormuleDao.insertFormule(this.cptTabFormule, this.cptTabElement, this.tabliszone, this.tabforcol, (BsoTabNom)null);
         this.lesPegTabFormules.add(this.cptTabFormule);
         this.datamodeltabFormule.setWrappedData(this.lesPegTabFormules);
      } else {
         this.cptTabFormule = this.bsoTabFormuleDao.modifFormule(this.cptTabFormule);
      }

   }

   public void calculeAxe(String var1) {
      if (var1.startsWith("SIT")) {
         this.cptTabFormule.setTabforSite(var1);
      } else if (var1.startsWith("DEP")) {
         this.cptTabFormule.setTabforDepartement(var1);
      } else if (var1.startsWith("SER")) {
         this.cptTabFormule.setTabforService(var1);
      } else if (var1.startsWith("REG")) {
         this.cptTabFormule.setTabforRegion(var1);
      } else if (var1.startsWith("SEC")) {
         this.cptTabFormule.setTabforSecteur(var1);
      } else if (var1.startsWith("PDV")) {
         this.cptTabFormule.setTabforPdv(var1);
      } else if (var1.startsWith("ACT")) {
         this.cptTabFormule.setTabforActivite(var1);
      } else if (var1.startsWith("DOS")) {
         this.cptTabFormule.setTabforDossier(var1);
      } else if (var1.startsWith("PRC")) {
         this.cptTabFormule.setTabforParc(var1);
      }

   }

   public void deleteFormule() throws HibernateException, NamingException {
      this.bsoTabFormuleDao.deleteFormule(this.cptTabFormule);
      this.chargerMesTabFormule();
      this.setTestAffTabFormuleSuppModif(false);
   }

   public void copierFormule() {
      this.lesFormulesMemo = new ArrayList();
      if (this.lesPegTabFormules.size() != 0) {
         for(int var1 = 0; var1 < this.lesPegTabFormules.size(); ++var1) {
            new BsoTabFormule();
            BsoTabFormule var2 = (BsoTabFormule)this.lesPegTabFormules.get(var1);
            this.lesFormulesMemo.add(var2);
         }
      }

   }

   public void collerFormule() throws HibernateException, NamingException {
      if (this.lesFormulesMemo.size() != 0) {
         for(int var1 = 0; var1 < this.lesFormulesMemo.size(); ++var1) {
            new BsoTabFormule();
            BsoTabFormule var2 = (BsoTabFormule)this.lesFormulesMemo.get(var1);
            this.bsoTabFormuleDao.insertFormule(var2, this.cptTabElement, this.tabliszone, this.tabforcol, this.cptTabNom);
         }

         this.chargerMesTabFormule();
      }

   }

   public void chargerMesTabNomEF(Session var1) throws HibernateException, NamingException {
      if (this.lesCptTabNom.size() > 0) {
         this.lesCptTabNom.clear();
      }

      this.lesCptTabNom = this.bsoTabNomDao.chargerMesTabNomConf(10, this.structureLog.getStrbilansocial(), var1);
      if (this.lesCptTabNom.size() > 0) {
         this.datamodeltabNom = new ListDataModel();
         this.datamodeltabNom.setWrappedData(this.lesCptTabNom);
      }

   }

   public void chargerMesTabNomEF() throws HibernateException, NamingException {
      if (this.lesCptTabNom.size() > 0) {
         this.lesCptTabNom.clear();
      }

      this.lesCptTabNom = this.bsoTabNomDao.chargerMesTabNomConf(10, this.structureLog.getStrbilansocial(), (Session)null);
      if (this.lesCptTabNom.size() > 0) {
         this.datamodeltabNom = new ListDataModel();
         this.datamodeltabNom.setWrappedData(this.lesCptTabNom);
      }

   }

   public void chargerMesTabNomTB() throws HibernateException, NamingException {
      if (this.lesCptTabNom.size() > 0) {
         this.lesCptTabNom.clear();
      }

      this.lesCptTabNom = this.bsoTabNomDao.chargerMesTabNomConf(11, this.structureLog.getStrbilansocial(), (Session)null);
      if (this.lesCptTabNom.size() > 0) {
         this.datamodeltabNom = new ListDataModel();
         this.datamodeltabNom.setWrappedData(this.lesCptTabNom);
      }

      this.setTestAffTabNomSuppModif(false);
      this.setTestAffTabElementSave(false);
      this.setTestAffTabElementuppModif(false);
      this.setTestAffTabFormuleSave(false);
      this.setTestAffTabFormuleSuppModif(false);
   }

   public void chargerMesTabElement() throws HibernateException, NamingException {
      if (this.lesPegTabElements.size() > 0) {
         this.lesPegTabElements.clear();
      }

      this.lesPegTabElements = this.bsoTabElementDao.chargerMesTabElement(this.getCptTabNom().getTablis_id(), (Session)null);
      if (this.lesPegTabElements.size() > 0) {
         this.datamodeltabElement = new ListDataModel();
         this.datamodeltabElement.setWrappedData(this.lesPegTabElements);
      }

      this.setTestAffTabElementSave(false);
      this.setTestAffTabElementuppModif(false);
      this.setTestAffTabFormuleSave(false);
      this.setTestAffTabFormuleSuppModif(false);
   }

   public void chargerMesTabFormule() throws HibernateException, NamingException {
      if (this.lesPegTabFormules.size() > 0) {
         this.lesPegTabFormules.clear();
      }

      if (this.etatFinancier == null) {
         this.setTabforcol(1);
      }

      this.lesPegTabFormules = this.bsoTabFormuleDao.chargerMesTabFormule(this.cptTabElement.getTabele_id(), this.getTabforcol());
      if (this.lesPegTabFormules.size() > 0) {
         this.datamodeltabFormule = new ListDataModel();
         this.datamodeltabFormule.setWrappedData(this.lesPegTabFormules);
      }

      this.setTestAffTabFormuleSuppModif(false);
   }

   public void selectionTableau() throws HibernateException, NamingException {
      if (this.datamodeltabNom.isRowAvailable()) {
         this.cptTabNom = (BsoTabNom)this.datamodeltabNom.getRowData();
         if (this.cptTabNom.getTablisAnalytique() != null && !this.cptTabNom.getTablisAnalytique().isEmpty()) {
            this.masqueAnalytique = true;
         } else {
            this.masqueAnalytique = false;
         }

         this.setNombredecolonne(this.cptTabNom.getTablisNbCol());
         if (this.lesPegTabFormules.size() > 0) {
            this.lesPegTabFormules.clear();
         }

         this.setTabliszone(this.cptTabNom.getTablisZone());
         this.chargerMesTabElement();
         this.chargerLesNomsCol();
         this.setTestAffTabNomSuppModif(true);
         this.setTestAffTabElementSave(true);
         this.setTestImprimer(true);
         this.filtre = this.cptTabNom.getTablisCode() + " : " + this.cptTabNom.getTablisLibFR();
         this.requete = "tablis_code='" + this.cptTabNom.getTablisCode() + "'";
      }

   }

   public void selectionColonne() throws HibernateException, NamingException {
      if (this.dataModelLesNomsCol.isRowAvailable()) {
         this.etatFinancier = (EtatFinancier)this.dataModelLesNomsCol.getRowData();
         this.tabforcol = this.dataModelLesNomsCol.getRowIndex() + 1;
         this.setTestAffTabFormuleSave(true);
         this.chargerMesTabFormule();
         this.gestionCellule();
      }

   }

   public void selectionElement() throws HibernateException, NamingException {
      if (this.datamodeltabElement.isRowAvailable()) {
         this.cptTabElement = (BsoTabElement)this.datamodeltabElement.getRowData();
         this.chargerMesTabFormule();
         this.setTestAffTabElementuppModif(true);
         this.gestionCellule();
      }

   }

   public void selectionFormule() {
      if (this.datamodeltabFormule.isRowAvailable()) {
         this.cptTabFormule = (BsoTabFormule)this.datamodeltabFormule.getRowData();
         this.setTestAffTabFormuleSuppModif(true);
      }

   }

   public void gestionCellule() {
      if (this.tabforcol != 0 && this.cptTabElement != null) {
         this.nomCellule = this.cptTabElement.getTabeleReference() + "/" + this.tabforcol;
         if (this.tabforcol == 1) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel01();
         } else if (this.tabforcol == 2) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel02();
         } else if (this.tabforcol == 3) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel03();
         } else if (this.tabforcol == 4) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel04();
         } else if (this.tabforcol == 5) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel05();
         } else if (this.tabforcol == 6) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel06();
         } else if (this.tabforcol == 7) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel07();
         } else if (this.tabforcol == 8) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel08();
         } else if (this.tabforcol == 9) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel09();
         } else if (this.tabforcol == 10) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel10();
         } else if (this.tabforcol == 11) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel11();
         } else if (this.tabforcol == 12) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel12();
         } else if (this.tabforcol == 13) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel13();
         } else if (this.tabforcol == 14) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel14();
         } else if (this.tabforcol == 15) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel15();
         } else if (this.tabforcol == 16) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel16();
         } else if (this.tabforcol == 17) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel17();
         } else if (this.tabforcol == 18) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel18();
         } else if (this.tabforcol == 19) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel19();
         } else if (this.tabforcol == 20) {
            this.natureCellule = this.cptTabElement.getTabeleFormatCel20();
         }

         this.afficheCellule = true;
      } else {
         this.nomCellule = "";
         this.afficheCellule = false;
      }

   }

   public void majElement() throws HibernateException, NamingException {
      if (this.lesPegTabFormules.size() != 0) {
         if (this.tabforcol == 1) {
            this.cptTabElement.setTabeleFormatCel01(this.natureCellule);
         } else if (this.tabforcol == 2) {
            this.cptTabElement.setTabeleFormatCel02(this.natureCellule);
         } else if (this.tabforcol == 3) {
            this.cptTabElement.setTabeleFormatCel03(this.natureCellule);
         } else if (this.tabforcol == 4) {
            this.cptTabElement.setTabeleFormatCel04(this.natureCellule);
         } else if (this.tabforcol == 5) {
            this.cptTabElement.setTabeleFormatCel05(this.natureCellule);
         } else if (this.tabforcol == 6) {
            this.cptTabElement.setTabeleFormatCel06(this.natureCellule);
         } else if (this.tabforcol == 7) {
            this.cptTabElement.setTabeleFormatCel07(this.natureCellule);
         } else if (this.tabforcol == 8) {
            this.cptTabElement.setTabeleFormatCel08(this.natureCellule);
         } else if (this.tabforcol == 9) {
            this.cptTabElement.setTabeleFormatCel09(this.natureCellule);
         } else if (this.tabforcol == 10) {
            this.cptTabElement.setTabeleFormatCel10(this.natureCellule);
         } else if (this.tabforcol == 11) {
            this.cptTabElement.setTabeleFormatCel11(this.natureCellule);
         } else if (this.tabforcol == 12) {
            this.cptTabElement.setTabeleFormatCel12(this.natureCellule);
         } else if (this.tabforcol == 13) {
            this.cptTabElement.setTabeleFormatCel13(this.natureCellule);
         } else if (this.tabforcol == 14) {
            this.cptTabElement.setTabeleFormatCel14(this.natureCellule);
         } else if (this.tabforcol == 15) {
            this.cptTabElement.setTabeleFormatCel15(this.natureCellule);
         } else if (this.tabforcol == 16) {
            this.cptTabElement.setTabeleFormatCel16(this.natureCellule);
         } else if (this.tabforcol == 17) {
            this.cptTabElement.setTabeleFormatCel17(this.natureCellule);
         } else if (this.tabforcol == 18) {
            this.cptTabElement.setTabeleFormatCel18(this.natureCellule);
         } else if (this.tabforcol == 19) {
            this.cptTabElement.setTabeleFormatCel19(this.natureCellule);
         } else if (this.tabforcol == 20) {
            this.cptTabElement.setTabeleFormatCel20(this.natureCellule);
         }

         this.cptTabElement = this.bsoTabElementDao.modifElement(this.cptTabElement);
         if (this.natureCellule >= 10 && this.natureCellule <= 14) {
            this.modeSaisie(this.tabforcol);
         }
      }

   }

   public void modeSaisie(int var1) throws HibernateException, NamingException {
      if (this.lesPegTabFormules.size() != 0) {
         for(int var2 = 0; var2 < this.lesPegTabFormules.size(); ++var2) {
            this.cptTabFormule = (BsoTabFormule)this.lesPegTabFormules.get(var2);
            this.bsoTabFormuleDao.deleteFormule(this.cptTabFormule);
         }

         this.lesPegTabFormules.clear();
      }

      this.cptTabFormule.setTabforSite("");
      this.cptTabFormule.setTabforDepartement("");
      this.cptTabFormule.setTabforService("");
      this.cptTabFormule.setTabforRegion("");
      this.cptTabFormule.setTabforSecteur("");
      this.cptTabFormule.setTabforPdv("");
      this.cptTabFormule.setTabforActivite("");
      this.cptTabFormule.setTabforDossier("");
      this.cptTabFormule.setTabforParc("");
      if (this.natureCellule != 10 && this.natureCellule != 11 && this.natureCellule != 12) {
         if (this.natureCellule == 13) {
            this.cptTabFormule.setTabforSolde(7);
         } else if (this.natureCellule == 14) {
            this.cptTabFormule.setTabforSolde(8);
         }
      } else {
         this.cptTabFormule.setTabforSolde(6);
      }

      if (this.tabforcol == 1) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn01());
      } else if (this.tabforcol == 2) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn02());
      } else if (this.tabforcol == 3) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn03());
      } else if (this.tabforcol == 4) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn04());
      } else if (this.tabforcol == 5) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn05());
      } else if (this.tabforcol == 6) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn06());
      } else if (this.tabforcol == 7) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn07());
      } else if (this.tabforcol == 8) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn08());
      } else if (this.tabforcol == 9) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn09());
      } else if (this.tabforcol == 10) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn10());
      } else if (this.tabforcol == 11) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn11());
      } else if (this.tabforcol == 12) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn12());
      } else if (this.tabforcol == 13) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn13());
      } else if (this.tabforcol == 14) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn14());
      } else if (this.tabforcol == 15) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn15());
      } else if (this.tabforcol == 16) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn16());
      } else if (this.tabforcol == 17) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn17());
      } else if (this.tabforcol == 18) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn18());
      } else if (this.tabforcol == 19) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn19());
      } else if (this.tabforcol == 20) {
         this.cptTabFormule.setTabforPeriode(this.cptTabNom.getTablisAnn20());
      }

      this.cptTabFormule = this.bsoTabFormuleDao.insertFormule(this.cptTabFormule, this.cptTabElement, this.tabliszone, this.tabforcol, (BsoTabNom)null);
      this.lesPegTabFormules.add(this.cptTabFormule);
      this.datamodeltabFormule.setWrappedData(this.lesPegTabFormules);
   }

   public void chargerLesNomsCol() throws HibernateException, NamingException {
      EtatFinancier var1 = new EtatFinancier();
      this.lesNomsCol.clear();
      int var2 = this.cptTabNom.getTablisNbCol();
      if (var2 >= 1) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn01());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn01()));
         var1.setNomCol(this.cptTabNom.getTablisNom01());
         var1.setNumCol("N° 1");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol01());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 2) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn02());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn02()));
         var1.setNomCol(this.cptTabNom.getTablisNom02());
         var1.setNumCol("N° 2");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol02());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 3) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn03());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn03()));
         var1.setNomCol(this.cptTabNom.getTablisNom03());
         var1.setNumCol("N° 3");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol03());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 4) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn04());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn04()));
         var1.setNomCol(this.cptTabNom.getTablisNom04());
         var1.setNumCol("N° 4");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol04());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 5) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn05());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn05()));
         var1.setNomCol(this.cptTabNom.getTablisNom05());
         var1.setNumCol("N° 5");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol05());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 6) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn06());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn06()));
         var1.setNomCol(this.cptTabNom.getTablisNom06());
         var1.setNumCol("N° 6");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol06());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 7) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn07());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn07()));
         var1.setNomCol(this.cptTabNom.getTablisNom07());
         var1.setNumCol("N° 7");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol07());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 8) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn08());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn08()));
         var1.setNomCol(this.cptTabNom.getTablisNom08());
         var1.setNumCol("N° 8");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol08());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 9) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn09());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn09()));
         var1.setNomCol(this.cptTabNom.getTablisNom09());
         var1.setNumCol("N° 9");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol09());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 10) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn10());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn10()));
         var1.setNomCol(this.cptTabNom.getTablisNom10());
         var1.setNumCol("N° 10");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol10());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 11) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn11());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn11()));
         var1.setNomCol(this.cptTabNom.getTablisNom11());
         var1.setNumCol("N° 11");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol11());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 12) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn12());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn12()));
         var1.setNomCol(this.cptTabNom.getTablisNom12());
         var1.setNumCol("N° 12");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol12());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 13) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn13());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn13()));
         var1.setNomCol(this.cptTabNom.getTablisNom13());
         var1.setNumCol("N° 13");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol13());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 14) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn14());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn14()));
         var1.setNomCol(this.cptTabNom.getTablisNom14());
         var1.setNumCol("N° 14");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol14());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 15) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn15());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn15()));
         var1.setNomCol(this.cptTabNom.getTablisNom15());
         var1.setNumCol("N° 15");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol15());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 16) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn16());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn16()));
         var1.setNomCol(this.cptTabNom.getTablisNom16());
         var1.setNumCol("N° 16");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol16());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 17) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn17());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn17()));
         var1.setNomCol(this.cptTabNom.getTablisNom17());
         var1.setNumCol("N° 17");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol17());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 18) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn18());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn18()));
         var1.setNomCol(this.cptTabNom.getTablisNom18());
         var1.setNumCol("N° 18");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol18());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 19) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn19());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn19()));
         var1.setNomCol(this.cptTabNom.getTablisNom19());
         var1.setNumCol("N° 19");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol19());
         this.lesNomsCol.add(var1);
      }

      if (var2 >= 20) {
         var1 = new EtatFinancier();
         var1.setPeriodeCol(this.cptTabNom.getTablisAnn20());
         var1.setLibPeriodeCol(this.etatFinancier.calculLibPeriode(this.cptTabNom.getTablisAnn20()));
         var1.setNomCol(this.cptTabNom.getTablisNom20());
         var1.setNumCol("N° 20");
         var1.setTypeCol(this.cptTabNom.getTablisTypeCol20());
         this.lesNomsCol.add(var1);
      }

      if (var1.getLibPeriodeCol().length() > 0) {
         this.setTestAffTabFormuleSave(true);
      } else {
         this.setTestAffTabFormuleSave(false);
      }

      this.dataModelLesNomsCol = new ListDataModel();
      this.dataModelLesNomsCol.setWrappedData(this.lesNomsCol);
      this.chargerMesTabFormule();
   }

   public void AffecterSupp() {
      this.cptTabFormule.setTabforFormule(">");
   }

   public void AffecterSuppOrEq() {
      this.cptTabFormule.setTabforFormule(">=");
   }

   public void AffecterInf() {
      this.cptTabFormule.setTabforFormule("<");
   }

   public void AffecterEq() {
      this.cptTabFormule.setTabforFormule("=");
   }

   public void AffecterInfOrEq() {
      this.cptTabFormule.setTabforFormule("<=");
   }

   public void AffecterDiff() {
      this.cptTabFormule.setTabforFormule("<>");
   }

   public void AffecterPlus() {
      this.cptTabFormule.setTabforFormule("+");
   }

   public void AffecterMoins() {
      this.cptTabFormule.setTabforFormule("-");
   }

   public void AffecterMulti() {
      this.cptTabFormule.setTabforFormule("*");
   }

   public void AffecterDiv() {
      this.cptTabFormule.setTabforFormule("/");
   }

   public void AffecterCel() {
      this.cptTabFormule.setTabforFormule("CEL()");
   }

   public void AffecterSomv() {
      this.cptTabFormule.setTabforFormule("SOMV()");
   }

   public void AffecterSomh() {
      this.cptTabFormule.setTabforFormule("SOMH()");
   }

   public void AffecterDifh() {
      this.cptTabFormule.setTabforFormule("DIFH()");
   }

   public void AffecterVal() {
      this.cptTabFormule.setTabforFormule("VAL()");
   }

   public void AffecterColP() {
      this.cptTabFormule.setTabforFormule("COL>0");
   }

   public void AffecterColN() {
      this.cptTabFormule.setTabforFormule("COL<0");
   }

   public void AffecterSTOT() {
      this.cptTabFormule.setTabforFormule("STOT()");
   }

   public void AffecterTTAB() {
      this.cptTabFormule.setTabforFormule("TTAB()");
   }

   public void AffecterSit() {
      this.cptTabFormule.setTabforAnalytique("SIT()");
   }

   public void AffecterDep() {
      this.cptTabFormule.setTabforAnalytique("DEP()");
   }

   public void AffecterServ() {
      this.cptTabFormule.setTabforAnalytique("SER()");
   }

   public void AffecterReg() {
      this.cptTabFormule.setTabforAnalytique("REG()");
   }

   public void AffecterSec() {
      this.cptTabFormule.setTabforAnalytique("SEC()");
   }

   public void AffecterPdv() {
      this.cptTabFormule.setTabforAnalytique("PDV()");
   }

   public void AffecterPrc() {
      this.cptTabFormule.setTabforAnalytique("PRC()");
   }

   public void AffecterDos() {
      this.cptTabFormule.setTabforAnalytique("DOS()");
   }

   public void AffecterAgt() {
      this.cptTabFormule.setTabforAnalytique("AGT()");
   }

   public void AffecterAct() {
      this.cptTabFormule.setTabforAnalytique("ACT()");
   }

   public void AffecterAc1() {
      this.cptTabFormule.setTabforAnalytique("AC1()");
   }

   public void AffecterAc2() {
      this.cptTabFormule.setTabforAnalytique("AC2()");
   }

   public void AffecterAc3() {
      this.cptTabFormule.setTabforAnalytique("AC3()");
   }

   public void AffecterAcx() {
      this.cptTabFormule.setTabforAnalytique("ACX()");
   }

   public void AffecterTie() {
      this.cptTabFormule.setTabforAnalytique("TIE()");
   }

   public void AffecterSi() {
      this.cptTabFormule.setTabforFormule("SI");
   }

   public void AffecterNon() {
      this.cptTabFormule.setTabforFormule("NON");
   }

   public void AffecterFin() {
      this.cptTabFormule.setTabforFormule("FIN");
   }

   public void AffecterBud() {
      this.cptTabFormule.setTabforFormule("BUDGET()");
   }

   public void AffecterCpt() {
      this.cptTabFormule.setTabforFormule("COMPTE()");
   }

   public void AffecterAmach() {
      this.cptTabFormule.setTabforFormule("AMACH()");
   }

   public void AffecterAmdot() {
      this.cptTabFormule.setTabforFormule("AMDOT()");
   }

   public void AffecterAmant() {
      this.cptTabFormule.setTabforFormule("AMANT()");
   }

   public void AffecterAmres() {
      this.cptTabFormule.setTabforFormule("AMRES()");
   }

   public void AffecterAmces() {
      this.cptTabFormule.setTabforFormule("AMCES()");
   }

   public void AffecterAr() {
      this.cptTabFormule.setTabforFormule("ARR()");
   }

   public void AffecterAb() {
      this.cptTabFormule.setTabforFormule("ABS()");
   }

   public void AffecterInv() {
      this.cptTabFormule.setTabforFormule("INV()");
   }

   public void AffecterEcom() {
      this.cptTabFormule.setTabforFormule("&");
   }

   public void AffecterBo() {
      this.cptTabFormule.setTabforFormule("|");
   }

   public void AffecterMod() {
      this.cptTabFormule.setTabforFormule("MOD()");
   }

   public void AffecterSOMH() {
      this.cptTabFormule.setTabforFormule("SOMH()");
   }

   public void AffecterSOMV() {
      this.cptTabFormule.setTabforFormule("SOMV()");
   }

   public void AffecterCaBlv() {
      this.cptTabFormule.setTabforFormule("CABLV()");
   }

   public void AffecterCaBrt() {
      this.cptTabFormule.setTabforFormule("CABRT()");
   }

   public void AffecterCaBst() {
      this.cptTabFormule.setTabforFormule("CABST()");
   }

   public void AffecterCaBen() {
      this.cptTabFormule.setTabforFormule("CABEN()");
   }

   public void AffecterCaFac() {
      this.cptTabFormule.setTabforFormule("CAFAC()");
   }

   public void AffecterCaNdb() {
      this.cptTabFormule.setTabforFormule("CANDB()");
   }

   public void AffecterCaAvr() {
      this.cptTabFormule.setTabforFormule("CAAVR()");
   }

   public void AffecterCaAch() {
      this.cptTabFormule.setTabforFormule("CAACH()");
   }

   public void AffecterCaPrd() {
      this.cptTabFormule.setTabforFormule("CAPRD()");
   }

   public void AffecterVlBlv() {
      this.cptTabFormule.setTabforFormule("VLBLV()");
   }

   public void AffecterVlBrt() {
      this.cptTabFormule.setTabforFormule("VLBRT()");
   }

   public void AffecterVlBst() {
      this.cptTabFormule.setTabforFormule("VLBST()");
   }

   public void AffecterVlBen() {
      this.cptTabFormule.setTabforFormule("VLBEN()");
   }

   public void AffecterVlFac() {
      this.cptTabFormule.setTabforFormule("VLFAC()");
   }

   public void AffecterVlNdb() {
      this.cptTabFormule.setTabforFormule("VLNDB()");
   }

   public void AffecterVlAvr() {
      this.cptTabFormule.setTabforFormule("VLAVR()");
   }

   public void AffecterVlAch() {
      this.cptTabFormule.setTabforFormule("VLACH()");
   }

   public void AffecterVlPrd() {
      this.cptTabFormule.setTabforFormule("VLPRD()");
   }

   public void AffecterQtBlv() {
      this.cptTabFormule.setTabforFormule("QTBLV()");
   }

   public void AffecterQtBrt() {
      this.cptTabFormule.setTabforFormule("QTBRT()");
   }

   public void AffecterQtBst() {
      this.cptTabFormule.setTabforFormule("QTBST()");
   }

   public void AffecterQtBen() {
      this.cptTabFormule.setTabforFormule("QTBEN()");
   }

   public void AffecterQtFac() {
      this.cptTabFormule.setTabforFormule("QTFAC()");
   }

   public void AffecterQtNdb() {
      this.cptTabFormule.setTabforFormule("QTNDB()");
   }

   public void AffecterQtAvr() {
      this.cptTabFormule.setTabforFormule("QTAVR()");
   }

   public void AffecterQtAch() {
      this.cptTabFormule.setTabforFormule("QTACH()");
   }

   public void AffecterQtPrd() {
      this.cptTabFormule.setTabforFormule("QTPRD()");
   }

   public void ImputSit() {
      this.cptTabNom.setTablisAnalytique("SIT()");
   }

   public void ImputDep() {
      this.cptTabNom.setTablisAnalytique("DEP()");
   }

   public void ImputServ() {
      this.cptTabNom.setTablisAnalytique("SER()");
   }

   public void ImputReg() {
      this.cptTabNom.setTablisAnalytique("REG()");
   }

   public void ImputSec() {
      this.cptTabNom.setTablisAnalytique("SEC()");
   }

   public void ImputPdv() {
      this.cptTabNom.setTablisAnalytique("PDV()");
   }

   public void ImputPrc() {
      this.cptTabNom.setTablisAnalytique("PRC()");
   }

   public void ImputDos() {
      this.cptTabNom.setTablisAnalytique("DOS()");
   }

   public void ImputAgt() {
      this.cptTabNom.setTablisAnalytique("AGT()");
   }

   public void ImputAct() {
      this.cptTabNom.setTablisAnalytique("ACT()");
   }

   public void ImputAc1() {
      this.cptTabNom.setTablisAnalytique("AC1()");
   }

   public void ImputAc2() {
      this.cptTabNom.setTablisAnalytique("AC2()");
   }

   public void ImputAc3() {
      this.cptTabNom.setTablisAnalytique("AC3()");
   }

   public void ImputAcx() {
      this.cptTabNom.setTablisAnalytique("ACX()");
   }

   public void ordonnnerAscendant() throws HibernateException, NamingException {
      if (this.datamodeltabElement.isRowAvailable()) {
         this.cptTabElement = (BsoTabElement)this.datamodeltabElement.getRowData();
         int var1 = this.cptTabElement.getTabeleNum();
         long var2 = this.cptTabElement.getTabele_id();
         new BsoTabElement();
         int var5 = this.clauleNumlLigne() - 1;
         BsoTabElement var4 = (BsoTabElement)this.lesPegTabElements.get(var5);
         long var6 = var4.getTabele_id();
         int var8 = var4.getTabeleNum();
         this.bsoTabElementDao.ordonnnerAscendant(var1, var8, var2, var6);
         this.chargerMesTabElement();
      }

   }

   public void ordonnnerDescendant() throws HibernateException, NamingException {
      if (this.datamodeltabElement.isRowAvailable()) {
         this.cptTabElement = (BsoTabElement)this.datamodeltabElement.getRowData();
         int var1 = this.cptTabElement.getTabeleNum();
         long var2 = this.cptTabElement.getTabele_id();
         new BsoTabElement();
         int var5 = this.clauleNumlLigne() + 1;
         BsoTabElement var4 = (BsoTabElement)this.lesPegTabElements.get(var5);
         long var6 = var4.getTabele_id();
         int var8 = var4.getTabeleNum();
         this.bsoTabElementDao.ordonnnerDescendant(var1, var8, var2, var6);
         this.chargerMesTabElement();
      }

   }

   public int clauleNumlLigne() {
      int var1 = 0;
      if (this.lesPegTabElements.size() != 0) {
         for(int var2 = 0; var2 < this.lesPegTabElements.size(); ++var2) {
            if (this.cptTabElement.getTabele_id() == ((BsoTabElement)this.lesPegTabElements.get(var2)).getTabele_id()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public DataModel getDatamodeltabNom() {
      return this.datamodeltabNom;
   }

   public void setDatamodeltabNom(DataModel var1) {
      this.datamodeltabNom = var1;
   }

   public BsoTabElement getCptTabElement() {
      return this.cptTabElement;
   }

   public void setCptTabElement(BsoTabElement var1) {
      this.cptTabElement = var1;
   }

   public DataModel getDatamodeltabElement() {
      return this.datamodeltabElement;
   }

   public void setDatamodeltabElement(DataModel var1) {
      this.datamodeltabElement = var1;
   }

   public BsoTabFormule getCptTabFormule() {
      return this.cptTabFormule;
   }

   public void setCptTabFormule(BsoTabFormule var1) {
      this.cptTabFormule = var1;
   }

   public BsoTabNom getCptTabNom() {
      return this.cptTabNom;
   }

   public void setCptTabNom(BsoTabNom var1) {
      this.cptTabNom = var1;
   }

   public long getIdZoneFiscale() {
      return this.IdZoneFiscale;
   }

   public void setIdZoneFiscale(long var1) {
      this.IdZoneFiscale = var1;
   }

   public int getNombredecolonne() {
      return this.nombredecolonne;
   }

   public void setNombredecolonne(int var1) {
      this.nombredecolonne = var1;
   }

   public DataModel getDataModelLesNomsCol() {
      return this.dataModelLesNomsCol;
   }

   public void setDataModelLesNomsCol(DataModel var1) {
      this.dataModelLesNomsCol = var1;
   }

   public EtatFinancier getEtatFinancier() {
      return this.etatFinancier;
   }

   public void setEtatFinancier(EtatFinancier var1) {
      this.etatFinancier = var1;
   }

   public int getTabforcol() {
      return this.tabforcol;
   }

   public void setTabforcol(int var1) {
      this.tabforcol = var1;
   }

   public String getTabliszone() {
      return this.tabliszone;
   }

   public void setTabliszone(String var1) {
      this.tabliszone = var1;
   }

   public DataModel getDatamodeltabFormule() {
      return this.datamodeltabFormule;
   }

   public void setDatamodeltabFormule(DataModel var1) {
      this.datamodeltabFormule = var1;
   }

   public boolean isTestAffTabElementSave() {
      return this.testAffTabElementSave;
   }

   public void setTestAffTabElementSave(boolean var1) {
      this.testAffTabElementSave = var1;
   }

   public boolean isTestAffTabElementuppModif() {
      return this.testAffTabElementuppModif;
   }

   public void setTestAffTabElementuppModif(boolean var1) {
      this.testAffTabElementuppModif = var1;
   }

   public boolean isTestAffTabFormuleSave() {
      return this.testAffTabFormuleSave;
   }

   public void setTestAffTabFormuleSave(boolean var1) {
      this.testAffTabFormuleSave = var1;
   }

   public boolean isTestAffTabFormuleSuppModif() {
      return this.testAffTabFormuleSuppModif;
   }

   public void setTestAffTabFormuleSuppModif(boolean var1) {
      this.testAffTabFormuleSuppModif = var1;
   }

   public boolean isTestAffTabNomSave() {
      return this.testAffTabNomSave;
   }

   public void setTestAffTabNomSave(boolean var1) {
      this.testAffTabNomSave = var1;
   }

   public boolean isTestAffTabNomSuppModif() {
      return this.testAffTabNomSuppModif;
   }

   public void setTestAffTabNomSuppModif(boolean var1) {
      this.testAffTabNomSuppModif = var1;
   }

   public boolean isTestImprimer() {
      return this.testImprimer;
   }

   public void setTestImprimer(boolean var1) {
      this.testImprimer = var1;
   }

   public String getLesIdCptTabElement() {
      return this.lesIdCptTabElement;
   }

   public void setLesIdCptTabElement(String var1) {
      this.lesIdCptTabElement = var1;
   }

   public String getLesIdCptTabFormule() {
      return this.lesIdCptTabFormule;
   }

   public void setLesIdCptTabFormule(String var1) {
      this.lesIdCptTabFormule = var1;
   }

   public String getLesIdCptTabnom() {
      return this.lesIdCptTabnom;
   }

   public void setLesIdCptTabnom(String var1) {
      this.lesIdCptTabnom = var1;
   }

   public String getLesIdPegElement() {
      return this.lesIdPegElement;
   }

   public void setLesIdPegElement(String var1) {
      this.lesIdPegElement = var1;
   }

   public String getLesIdPegNom() {
      return this.lesIdPegNom;
   }

   public void setLesIdPegNom(String var1) {
      this.lesIdPegNom = var1;
   }

   public boolean isMasqueAnalytique() {
      return this.masqueAnalytique;
   }

   public void setMasqueAnalytique(boolean var1) {
      this.masqueAnalytique = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
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

   public String getFiltre() {
      return this.filtre;
   }

   public void setFiltre(String var1) {
      this.filtre = var1;
   }

   public String getRequete() {
      return this.requete;
   }

   public void setRequete(String var1) {
      this.requete = var1;
   }

   public boolean isAfficheCellule() {
      return this.afficheCellule;
   }

   public void setAfficheCellule(boolean var1) {
      this.afficheCellule = var1;
   }

   public int getNatureCellule() {
      return this.natureCellule;
   }

   public void setNatureCellule(int var1) {
      this.natureCellule = var1;
   }

   public String getNomCellule() {
      return this.nomCellule;
   }

   public void setNomCellule(String var1) {
      this.nomCellule = var1;
   }

   public boolean isDecoupageanalytique() {
      return this.decoupageanalytique;
   }

   public void setDecoupageanalytique(boolean var1) {
      this.decoupageanalytique = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
