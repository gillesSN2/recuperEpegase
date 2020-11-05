package com.epegase.forms.administration;

import com.epegase.systeme.classe.Metiers;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.MetiersDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.IOException;
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
import org.jdom.JDOMException;

public class FormActivitesSocietes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String lien;
   private boolean codelibVide = false;
   private int var_type = 0;
   private String entete = "Les des métiers des personnes physiques";
   private String pageIndex;
   private List metiersList = new ArrayList();
   private transient DataModel datamodelActivites;
   private Metiers metiers;
   private MetiersDao metiersDao;
   private boolean showmodelPanel = false;
   private boolean var_affiche_bouton = false;
   private boolean var_inactif = false;
   private String memoAncienLibelle;
   private boolean afficheAjDefaut = false;

   public void InstancesDaoUtilses() {
      this.metiersDao = new MetiersDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesMetiers() throws HibernateException, NamingException {
      this.setLien(this.lien);
      this.datamodelActivites = new ListDataModel();
      this.metiersList = new ArrayList();
      this.metiersList = this.metiersDao.selectMetiers(this.var_type, (Session)null);
      this.datamodelActivites.setWrappedData(this.metiersList);
      boolean var1 = false;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Metiers");
      Object var3 = var2.createQuery("SELECT COUNT(*) FROM Metiers").uniqueResult();
      int var4 = Integer.parseInt(var3.toString());
      if (var4 > 0) {
         this.afficheAjDefaut = false;
      } else {
         this.afficheAjDefaut = true;
      }

      this.utilInitHibernate.closeSession();
   }

   public void chargerMetiers() throws HibernateException, NamingException {
      this.var_type = 0;
      this.entete = "Les des métiers des personnes physiques";
      this.lesMetiers();
   }

   public void chargerActivites() throws HibernateException, NamingException {
      this.var_type = 1;
      this.entete = "Les des activités des sociétés";
      this.lesMetiers();
   }

   public void selectionActivite() {
      if (this.datamodelActivites.isRowAvailable()) {
         this.metiers = (Metiers)this.datamodelActivites.getRowData();
         this.memoAncienLibelle = this.metiers.getMetNomFr();
         if (this.metiers.getMetInactif() == 1) {
            this.var_inactif = true;
         } else {
            this.var_inactif = false;
         }

         this.var_affiche_bouton = true;
      }

   }

   public void defaultAdd() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.metiersDao.ajoutParDefaut(this.structureLog.getStrzonefiscale(), this.structureLog, this.usersLog);
      this.lesMetiers();
      this.afficheAjDefaut = false;
   }

   public void ajouterActivites() {
      this.metiers = new Metiers();
      this.var_inactif = false;
      this.codelibVide = false;
      this.showmodelPanel = true;
   }

   public void modifierActivites() {
      if (this.metiers != null) {
         this.codelibVide = true;
         this.showmodelPanel = true;
      }

   }

   public void supprimerActivites() throws HibernateException, NamingException {
      if (this.metiers != null) {
         this.metiersList.remove(this.metiers);
         this.datamodelActivites.setWrappedData(this.metiersList);
         this.metiersDao.delete(this.metiers);
         this.var_affiche_bouton = false;
      }

   }

   public void reactiverActivites() throws HibernateException, NamingException {
      if (this.metiers != null) {
         this.metiers.setMetInactif(0);
         this.metiers = this.metiersDao.modif(this.metiers);
      }

   }

   public void annulerActivites() {
      this.var_affiche_bouton = false;
      this.showmodelPanel = false;
   }

   public void saveActivites() throws HibernateException, NamingException {
      if (this.var_inactif) {
         this.metiers.setMetInactif(1);
      } else {
         this.metiers.setMetInactif(0);
      }

      this.metiers.setMetType(this.var_type);
      if (this.metiers.getMetId() == 0L) {
         this.metiers.setMetUserCreat(this.usersLog.getUsrid());
         this.metiers.setMetDateCreat(new Date());
         this.metiers = this.metiersDao.insert(this.metiers);
         this.metiersList.add(this.metiers);
         this.datamodelActivites.setWrappedData(this.metiersList);
      } else {
         this.metiers.setMetUserModif(this.usersLog.getUsrid());
         this.metiers.setMetDateModif(new Date());
         this.metiers = this.metiersDao.modif(this.metiers);
         if (!this.metiers.getMetNomFr().equals(this.memoAncienLibelle)) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               new ArrayList();
               TiersDao var4 = new TiersDao(this.baseLog, this.utilInitHibernate);
               String var5 = "from Tiers where tieactivite1='" + this.memoAncienLibelle + "'";
               List var3 = var4.listeTiers(var5, var1);
               if (var3.size() != 0) {
                  new Tiers();

                  for(int var7 = 0; var7 < var3.size(); ++var7) {
                     Tiers var6 = (Tiers)var3.get(var7);
                     var6.setTieactivite1(this.metiers.getMetNomFr());
                     var4.modif(var6, var1);
                  }
               }

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

      this.showmodelPanel = false;
      this.var_affiche_bouton = false;
   }

   public void verifielesSaisieLibelleAct() {
      if (this.getMetiers().getMetNomFr().equals("")) {
         this.codelibVide = false;
      } else {
         this.codelibVide = true;
      }

   }

   public boolean isCodelibVide() {
      return this.codelibVide;
   }

   public void setCodelibVide(boolean var1) {
      this.codelibVide = var1;
   }

   public String getLien() {
      return this.lien;
   }

   public void setLien(String var1) {
      this.lien = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public DataModel getDatamodelActivites() {
      return this.datamodelActivites;
   }

   public void setDatamodelActivites(DataModel var1) {
      this.datamodelActivites = var1;
   }

   public boolean isShowmodelPanel() {
      return this.showmodelPanel;
   }

   public void setShowmodelPanel(boolean var1) {
      this.showmodelPanel = var1;
   }

   public boolean isVar_inactif() {
      return this.var_inactif;
   }

   public void setVar_inactif(boolean var1) {
      this.var_inactif = var1;
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

   public Metiers getMetiers() {
      return this.metiers;
   }

   public void setMetiers(Metiers var1) {
      this.metiers = var1;
   }

   public List getMetiersList() {
      return this.metiersList;
   }

   public void setMetiersList(List var1) {
      this.metiersList = var1;
   }

   public String getEntete() {
      return this.entete;
   }

   public void setEntete(String var1) {
      this.entete = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isAfficheAjDefaut() {
      return this.afficheAjDefaut;
   }

   public void setAfficheAjDefaut(boolean var1) {
      this.afficheAjDefaut = var1;
   }
}
