package com.epegase.forms.administration;

import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
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

public class FormChantiersForet implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private PlansAnalytiques plansAnalytiques = new PlansAnalytiques();
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private List lesChantiers = new ArrayList();
   private transient DataModel dataModelChantier = new ListDataModel();
   private boolean visibiliteBton = false;
   private boolean inactif = false;
   private boolean showModalPanel;
   private boolean doublon = false;

   public FormChantiersForet() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesChantiers(Session var1) throws HibernateException, NamingException {
      this.lesChantiers = this.plansAnalytiquesDao.chargerLesPlansAnalytiques("7", var1);
      this.dataModelChantier.setWrappedData(this.lesChantiers);
   }

   public void ajouterChantier() {
      this.plansAnalytiques = new PlansAnalytiques();
      this.inactif = false;
      this.setDoublon(false);
      this.showModalPanel = true;
   }

   public void modifierChantier() {
      if (this.plansAnalytiques != null) {
         this.setDoublon(true);
         this.showModalPanel = true;
      }

   }

   public void annule() {
      this.showModalPanel = false;
   }

   public void selectionChantier() {
      this.annule();
      if (this.dataModelChantier.isRowAvailable()) {
         this.plansAnalytiques = (PlansAnalytiques)this.dataModelChantier.getRowData();
         int var1 = this.plansAnalytiques.getAnaInactif();
         if (var1 == 2) {
            this.visibiliteBton = false;
         } else {
            this.visibiliteBton = true;
         }
      }

   }

   public void doublonCode() throws HibernateException, NamingException {
      if (this.plansAnalytiques != null && this.plansAnalytiques.getAnaId() != 0L) {
         this.doublon = true;
      } else {
         PlansAnalytiques var1 = this.plansAnalytiquesDao.devalideAnal("7", this.plansAnalytiques.getAnaCode(), (Session)null);
         if (var1 == null) {
            this.doublon = true;
         } else {
            this.doublon = false;
         }
      }

   }

   public void saveChantier() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.plansAnalytiques.getAnaId() == 0L) {
            this.plansAnalytiques.setAnaNature("7");
            this.plansAnalytiques.setAnaDateCreat(new Date());
            this.plansAnalytiques.setAnaUserCreat(this.usersLog.getUsrid());
            if (this.inactif) {
               this.plansAnalytiques.setAnaInactif(1);
            } else {
               this.plansAnalytiques.setAnaInactif(0);
            }

            this.plansAnalytiques = this.plansAnalytiquesDao.insert(this.plansAnalytiques, var1);
            this.lesChantiers.add(this.plansAnalytiques);
            this.dataModelChantier.setWrappedData(this.lesChantiers);
         } else {
            this.plansAnalytiques.setAnaDateModif(new Date());
            this.plansAnalytiques.setAnaUserModif(this.usersLog.getUsrid());
            this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var1);
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

      this.visibiliteBton = false;
   }

   public void supprimerChantier() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.plansAnalytiquesDao.delete(this.plansAnalytiques, var1);
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

   public boolean isDoublon() {
      return this.doublon;
   }

   public void setDoublon(boolean var1) {
      this.doublon = var1;
   }

   public DataModel getDataModelChantier() {
      return this.dataModelChantier;
   }

   public void setDataModelChantier(DataModel var1) {
      this.dataModelChantier = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public List getLesChantiers() {
      return this.lesChantiers;
   }

   public void setLesChantiers(List var1) {
      this.lesChantiers = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public PlansAnalytiques getPlansAnalytiques() {
      return this.plansAnalytiques;
   }

   public void setPlansAnalytiques(PlansAnalytiques var1) {
      this.plansAnalytiques = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }
}
