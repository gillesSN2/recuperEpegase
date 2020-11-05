package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FilieresEducation;
import com.epegase.systeme.classe.FilieresMatieres;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.FilieresEducationDao;
import com.epegase.systeme.dao.FilieresMatieresDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormFilieres implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private FilieresEducation filieres = new FilieresEducation();
   private FilieresEducationDao filieresEducationDao;
   private List lesFilieres = new ArrayList();
   private transient DataModel dataModelFilieres = new ListDataModel();
   private boolean visibiliteBton = false;
   private boolean inactif = false;
   private int convertionInactif;
   private boolean showModalPanel;
   private ExercicesVentes exovteSelect;
   private boolean doublon = false;
   private FilieresMatieres filieresMatieres;
   private FilieresMatieresDao filieresMatieresDao;
   private List lesMatieres = new ArrayList();
   private transient DataModel dataModelMatieres = new ListDataModel();
   private boolean visibiliteBtonMatiere = false;
   private boolean showModalPanelMatiere = false;
   private List mesProfesseursItems = new ArrayList();
   private SalariesDao salariesDao;
   private long professeur;

   public FormFilieres() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.filieresEducationDao = new FilieresEducationDao(this.baseLog, this.utilInitHibernate);
      this.filieresMatieresDao = new FilieresMatieresDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesFilieres(Session var1) throws HibernateException, NamingException {
      this.lesFilieres = this.filieresEducationDao.selectFilieres(var1);
      this.dataModelFilieres.setWrappedData(this.lesFilieres);
      this.mesProfesseursItems.clear();
      this.mesProfesseursItems = this.salariesDao.chargerlesSalariesActifItem("*", var1);
   }

   public void reactiverFilieres() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FilieresEducation");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.filieres.setFilDateModif(new Date());
         this.filieres.setFilUserModif(this.usersLog.getUsrid());
         this.filieres.setFilEtat(0);
         this.filieres = this.filieresEducationDao.modif(this.filieres, var1);
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

   public void removeFilieres() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FilieresEducation");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.filieres.setFilDateModif(new Date());
         this.filieres.setFilUserModif(this.usersLog.getUsrid());
         this.filieres.setFilEtat(2);
         this.filieres = this.filieresEducationDao.modif(this.filieres, var1);
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

   public void ajouterFiliere() {
      this.filieres = new FilieresEducation();
      this.inactif = false;
      this.doublon = false;
      this.filieres.setFilType(100);
      this.filieres.setFilMode(100);
      this.showModalPanel = true;
      this.visibiliteBtonMatiere = false;
      this.lesMatieres.clear();
      this.dataModelMatieres.setWrappedData(this.lesMatieres);
   }

   public void modifierFiliere() {
      if (this.filieres != null) {
         this.doublon = true;
         this.showModalPanel = true;
      }

   }

   public void annuleSaisie() {
      this.showModalPanel = false;
      this.visibiliteBton = false;
   }

   public void selectionFiliere() throws HibernateException, NamingException {
      if (this.dataModelFilieres.isRowAvailable()) {
         this.filieres = (FilieresEducation)this.dataModelFilieres.getRowData();
         int var1 = this.filieres.getFilEtat();
         if (var1 == 2) {
            this.visibiliteBton = false;
         } else {
            this.visibiliteBton = true;
         }

         this.visibiliteBtonMatiere = false;
         this.lesMatieres.clear();
         this.lesMatieres = this.filieresMatieresDao.chargerMatiereByFiliere(this.filieres, (Session)null);
         this.dataModelMatieres.setWrappedData(this.lesMatieres);
      }

   }

   public void doublonCode() throws HibernateException, NamingException {
      if (this.filieres.getFilCode() != null && !this.filieres.getFilCode().isEmpty()) {
         this.doublon = false;
      } else {
         boolean var1 = this.filieresEducationDao.existeCode(this.filieres.getFilCode(), (Session)null);
         if (var1) {
            this.doublon = true;
         } else {
            this.doublon = false;
         }
      }

   }

   public void saveFilieres() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FilieresEducation");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.filieres.setFilCode(this.filieres.getFilCode().toUpperCase());
         this.filieres.setFilLibelle(this.filieres.getFilLibelle().toUpperCase());
         if (this.filieres.getFilId() == 0L) {
            this.filieres.setFilDateCreat(new Date());
            this.filieres.setFilUserCreat(this.usersLog.getUsrid());
            this.filieres.setFilEtat(this.getConvertionInactif());
            this.filieres = this.filieresEducationDao.insert(this.filieres, var1);
            this.lesFilieres.add(this.filieres);
            this.dataModelFilieres.setWrappedData(this.lesFilieres);
         } else {
            this.filieres.setFilDateModif(new Date());
            this.filieres.setFilUserModif(this.usersLog.getUsrid());
            this.filieres = this.filieresEducationDao.modif(this.filieres, var1);
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

      this.showModalPanel = false;
   }

   public void supprimerFiliere() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FilieresEducation");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.filieresEducationDao.delete(this.filieres, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanel = false;
      this.visibiliteBton = false;
   }

   public void selectionMatiere() {
      if (this.dataModelMatieres.isRowAvailable()) {
         this.filieresMatieres = (FilieresMatieres)this.dataModelMatieres.getRowData();
         this.visibiliteBtonMatiere = true;
      }

   }

   public void ajouterMatiere() {
      if (this.filieres != null) {
         this.filieresMatieres = new FilieresMatieres();
         this.filieresMatieres.setFilmatMode(this.filieres.getFilMode());
         this.visibiliteBtonMatiere = false;
         this.showModalPanelMatiere = true;
      }

   }

   public void modifierMatiere() {
      if (this.filieresMatieres != null) {
         this.showModalPanelMatiere = true;
      }

   }

   public void supprimerMatiere() throws HibernateException, NamingException {
      if (this.filieresMatieres != null) {
         this.filieresMatieresDao.delete(this.filieresMatieres);
         this.lesMatieres.remove(this.filieresMatieres);
         this.dataModelMatieres.setWrappedData(this.lesMatieres);
         this.visibiliteBtonMatiere = false;
      }

   }

   public void annulerMatiere() {
      this.showModalPanelMatiere = false;
   }

   public void validerMatiere() throws HibernateException, NamingException {
      if (this.professeur != 0L) {
         new Salaries();
         Salaries var1 = this.salariesDao.pourParapheur(this.professeur, (Session)null);
         if (var1 != null) {
            this.filieresMatieres.setFilmatIdProfesseur(var1.getSalId());
            this.filieresMatieres.setFilmatNomProfesseur(var1.getPatronyme());
         } else {
            this.filieresMatieres.setFilmatIdProfesseur(0L);
            this.filieresMatieres.setFilmatNomProfesseur("");
         }
      } else {
         this.filieresMatieres.setFilmatIdProfesseur(0L);
         this.filieresMatieres.setFilmatNomProfesseur("");
      }

      if (this.filieresMatieres.getFilmatId() == 0L) {
         this.filieresMatieres.setFilieresEducation(this.filieres);
         this.filieresMatieres.setFilmatMode(this.filieres.getFilMode());
         this.filieresMatieres.setFilmatDateCreat(new Date());
         this.filieresMatieres.setFilmatUserCreat(this.usersLog.getUsrid());
         this.filieresMatieres = this.filieresMatieresDao.insert(this.filieresMatieres);
         this.lesMatieres.add(this.filieresMatieres);
         this.dataModelMatieres.setWrappedData(this.lesMatieres);
      } else {
         this.filieresMatieres.setFilmatDateModif(new Date());
         this.filieresMatieres.setFilmatUserModif(this.usersLog.getUsrid());
         this.filieresMatieres = this.filieresMatieresDao.modif(this.filieresMatieres);
      }

      this.showModalPanelMatiere = false;
   }

   public boolean isDoublon() {
      return this.doublon;
   }

   public void setDoublon(boolean var1) {
      this.doublon = var1;
   }

   public int getConvertionInactif() {
      if (!this.inactif) {
         this.convertionInactif = 0;
      } else {
         this.convertionInactif = 1;
      }

      return this.convertionInactif;
   }

   public void setConvertionInactif(int var1) {
      this.convertionInactif = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public ExercicesVentes getExovteSelect() {
      return this.exovteSelect;
   }

   public void setExovteSelect(ExercicesVentes var1) {
      this.exovteSelect = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelFilieres() {
      return this.dataModelFilieres;
   }

   public void setDataModelFilieres(DataModel var1) {
      this.dataModelFilieres = var1;
   }

   public FilieresEducation getFilieres() {
      return this.filieres;
   }

   public void setFilieres(FilieresEducation var1) {
      this.filieres = var1;
   }

   public List getLesFilieres() {
      return this.lesFilieres;
   }

   public void setLesFilieres(List var1) {
      this.lesFilieres = var1;
   }

   public DataModel getDataModelMatieres() {
      return this.dataModelMatieres;
   }

   public void setDataModelMatieres(DataModel var1) {
      this.dataModelMatieres = var1;
   }

   public boolean isVisibiliteBtonMatiere() {
      return this.visibiliteBtonMatiere;
   }

   public void setVisibiliteBtonMatiere(boolean var1) {
      this.visibiliteBtonMatiere = var1;
   }

   public boolean isShowModalPanelMatiere() {
      return this.showModalPanelMatiere;
   }

   public void setShowModalPanelMatiere(boolean var1) {
      this.showModalPanelMatiere = var1;
   }

   public long getProfesseur() {
      return this.professeur;
   }

   public void setProfesseur(long var1) {
      this.professeur = var1;
   }

   public FilieresMatieres getFilieresMatieres() {
      return this.filieresMatieres;
   }

   public void setFilieresMatieres(FilieresMatieres var1) {
      this.filieresMatieres = var1;
   }

   public List getMesProfesseursItems() {
      return this.mesProfesseursItems;
   }

   public void setMesProfesseursItems(List var1) {
      this.mesProfesseursItems = var1;
   }
}
