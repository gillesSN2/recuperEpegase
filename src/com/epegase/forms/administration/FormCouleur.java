package com.epegase.forms.administration;

import com.epegase.systeme.classe.Couleur;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CouleurDao;
import com.epegase.systeme.util.StaticModePegase;
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

public class FormCouleur implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private Couleur couleur = new Couleur();
   private CouleurDao couleurDao;
   private List couleurList = new ArrayList();
   private transient DataModel datamodel = new ListDataModel();
   private String valImp = "false";
   private boolean inactif;
   private int convertionInactif;
   private boolean visibiliteBton;
   private boolean showModalPanel;

   public FormCouleur() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.couleurDao = new CouleurDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesCouleurs(Session var1) throws HibernateException, NamingException {
      this.couleurList = this.couleurDao.selectCouleur(var1);
      if (this.couleurList.size() > 0) {
         this.datamodel = new ListDataModel();
         this.datamodel.setWrappedData(this.couleurList);
      }

   }

   public void reactiverCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Couleur");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.couleur.setCouDateModif(new Date());
         this.couleur.setCouUserModif(this.usersLog.getUsrid());
         this.couleur.setCouInactif(0);
         this.couleur = this.couleurDao.modif(this.couleur, var1);
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

   public void removeCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Couleur");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.couleur.setCouDateModif(new Date());
         this.couleur.setCouUserModif(this.usersLog.getUsrid());
         this.couleur.setCouInactif(2);
         this.couleur = this.couleurDao.modif(this.couleur, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.setVisibiliteBton(false);
   }

   public void annule() {
      this.setShowModalPanel(false);
      this.setValImp("false");
   }

   public void selectionCouleur() {
      this.annule();
      if (this.datamodel.isRowAvailable()) {
         this.couleur = (Couleur)this.datamodel.getRowData();
         int var1 = this.couleur.getCouInactif();
         if (var1 == 2) {
            this.setVisibiliteBton(false);
         } else {
            this.setVisibiliteBton(true);
         }
      }

   }

   public void saveCouleur() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Couleur");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.couleur.getCouId() == 0L) {
            this.couleur.setCouDateCreation(new Date());
            this.couleur.setCouUserCreation(this.usersLog.getUsrid());
            this.couleur.setCouInactif(this.getConvertionInactif());
            this.couleur = this.couleurDao.insert(this.couleur, var1);
            this.couleurList.add(this.couleur);
            this.datamodel.setWrappedData(this.couleurList);
         } else {
            this.couleur.setCouDateModif(new Date());
            this.couleur.setCouUserModif(this.usersLog.getUsrid());
            this.couleur.setCouInactif(this.getConvertionInactif());
            this.couleur = this.couleurDao.modif(this.couleur, var1);
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

      this.setVisibiliteBton(false);
      this.setShowModalPanel(false);
      this.setValImp("false");
   }

   public void supprimerFormulesAchats() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Couleur");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.couleurDao.delete(this.couleur, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.lesCouleurs((Session)null);
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void visibleAjt() {
      this.couleur = new Couleur();
      this.inactif = false;
      this.setShowModalPanel(true);
   }

   public void visibleMod() {
      this.setShowModalPanel(true);
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

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public String getValImp() {
      return this.valImp;
   }

   public void setValImp(String var1) {
      this.valImp = var1;
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

   public Couleur getCouleur() {
      return this.couleur;
   }

   public void setCouleur(Couleur var1) {
      this.couleur = var1;
   }

   public List getCouleurList() {
      return this.couleurList;
   }

   public void setCouleurList(List var1) {
      this.couleurList = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
