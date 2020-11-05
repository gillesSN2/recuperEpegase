package com.epegase.forms.administration;

import com.epegase.systeme.classe.PlanningAvicultureAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.PlanningAvicultureAchatsDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormPlanningAvicultureAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private UserDao userDao;
   private List planningEnteteList = new ArrayList();
   private List planningLigneList = new ArrayList();
   private transient DataModel datamodelPlanningEntete = new ListDataModel();
   private transient DataModel datamodelPlanningLigne = new ListDataModel();
   private PlanningAvicultureAchats planningAvicultureAchats;
   private PlanningAvicultureAchatsDao planningAvicultureAchatsDao;
   private boolean showModalPanelPlanning = false;
   private boolean showModalPanelDetail = false;
   private boolean var_affiche_bouton = false;
   private String var_nom_feuille;
   private String var_code_feuille;
   private int var_nb_jour;
   private boolean var_mode_feuille = false;
   private boolean var_mode_detail = false;
   private String formuleEnCours;
   private List mesActionsItems;
   private List mesTraitementsItems;
   private List mesVaccinsItems;

   public FormPlanningAvicultureAchats() {
      this.planningEnteteList = new ArrayList();
      this.planningLigneList = new ArrayList();
      this.mesActionsItems = new ArrayList();
      this.mesTraitementsItems = new ArrayList();
      this.mesVaccinsItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.planningAvicultureAchatsDao = new PlanningAvicultureAchatsDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerPlanning(Session var1) throws HibernateException, NamingException {
      this.planningEnteteList = this.planningAvicultureAchatsDao.chargerPlanningEntete(var1);
      this.datamodelPlanningEntete.setWrappedData(this.planningEnteteList);
      ProduitsAchsDao var2 = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.mesActionsItems = var2.chargerLesProduits(1, var1);
      this.mesTraitementsItems = var2.chargerLesProduits(2, var1);
      this.mesVaccinsItems = var2.chargerLesProduits(3, var1);
   }

   public void selectionPlanning() throws HibernateException, NamingException {
      if (this.datamodelPlanningEntete.isRowAvailable()) {
         this.planningAvicultureAchats = (PlanningAvicultureAchats)this.datamodelPlanningEntete.getRowData();
         this.var_code_feuille = this.planningAvicultureAchats.getPpaCode();
         this.var_nom_feuille = this.planningAvicultureAchats.getPpaFeuille();
         this.var_nb_jour = this.planningAvicultureAchats.getPpaNbJour();
         this.planningLigneList.clear();
         this.planningLigneList = this.planningAvicultureAchatsDao.chargerPlanningLignes(this.var_nom_feuille, (Session)null);
         this.datamodelPlanningLigne.setWrappedData(this.planningLigneList);
         this.var_affiche_bouton = true;
      }

   }

   public void ajouterPlanning() {
      this.planningAvicultureAchats = new PlanningAvicultureAchats();
      this.var_nom_feuille = "";
      this.var_code_feuille = "";
      this.var_nb_jour = 0;
      this.var_mode_feuille = false;
      this.planningLigneList.clear();
      this.datamodelPlanningLigne.setWrappedData(this.planningLigneList);
      this.showModalPanelPlanning = true;
   }

   public void modifierPlanning() {
      if (this.planningAvicultureAchats != null) {
         this.var_mode_feuille = true;
         this.showModalPanelPlanning = true;
      }

   }

   public void supprimerPlanning() throws HibernateException, NamingException {
      if (this.planningAvicultureAchats != null && this.planningLigneList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanningAvicultureAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new PlanningAvicultureAchats();

            for(int var4 = 0; var4 < this.planningLigneList.size(); ++var4) {
               PlanningAvicultureAchats var3 = (PlanningAvicultureAchats)this.planningLigneList.get(var4);
               this.planningAvicultureAchatsDao.delete(var3, var1);
            }

            var2.commit();
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
            this.planningEnteteList.remove(this.planningAvicultureAchats);
            this.datamodelPlanningEntete.setWrappedData(this.planningEnteteList);
            this.planningLigneList.clear();
            this.datamodelPlanningLigne.setWrappedData(this.planningLigneList);
            this.var_affiche_bouton = false;
         }
      }

   }

   public void annulerPlanning() {
      this.var_affiche_bouton = false;
      this.showModalPanelPlanning = false;
   }

   public void savePlanning() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanningAvicultureAchats");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.planningLigneList.size() != 0) {
            int var3;
            for(var3 = 0; var3 < this.planningLigneList.size(); ++var3) {
               this.planningAvicultureAchats = new PlanningAvicultureAchats();
               this.planningAvicultureAchats = (PlanningAvicultureAchats)this.planningLigneList.get(var3);
               if (this.planningAvicultureAchats.getPpaId() != 0L) {
                  this.planningAvicultureAchatsDao.delete(this.planningAvicultureAchats, var1);
               }
            }

            for(var3 = 0; var3 < this.planningLigneList.size(); ++var3) {
               this.planningAvicultureAchats = new PlanningAvicultureAchats();
               this.planningAvicultureAchats = (PlanningAvicultureAchats)this.planningLigneList.get(var3);
               this.planningAvicultureAchats.setPpaUserCreat(this.usersLog.getUsrid());
               this.planningAvicultureAchats.setPpaDateCreat(new Date());
               this.planningAvicultureAchats.setPpaCode(this.var_code_feuille);
               this.planningAvicultureAchats.setPpaFeuille(this.var_nom_feuille);
               this.planningAvicultureAchats.setPpaNbJour(this.var_nb_jour);
               this.planningAvicultureAchats.setPpaOrdre(var3);
               this.planningAvicultureAchats = this.planningAvicultureAchatsDao.insert(this.planningAvicultureAchats, var1);
            }

            if (!this.var_mode_feuille) {
               this.planningEnteteList.add(this.planningAvicultureAchats);
            }

            this.datamodelPlanningEntete.setWrappedData(this.planningEnteteList);
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

      this.showModalPanelPlanning = false;
      this.var_affiche_bouton = false;
   }

   public void calculeNbSemaine() {
      if (this.var_nb_jour != 0) {
         this.planningLigneList.clear();

         for(int var1 = 0; var1 < this.var_nb_jour; ++var1) {
            this.planningAvicultureAchats = new PlanningAvicultureAchats();
            this.planningAvicultureAchats.setPpaJour(var1 + 1);
            this.planningLigneList.add(this.planningAvicultureAchats);
         }

         this.datamodelPlanningLigne.setWrappedData(this.planningLigneList);
      }

   }

   public void selectionDetail() {
      if (this.datamodelPlanningLigne.isRowAvailable()) {
         this.planningAvicultureAchats = (PlanningAvicultureAchats)this.datamodelPlanningLigne.getRowData();
      }

   }

   public void ajouterDetail() {
      this.planningAvicultureAchats = new PlanningAvicultureAchats();
      this.var_mode_detail = false;
      this.showModalPanelDetail = true;
   }

   public void modifierDetail() {
      if (this.planningAvicultureAchats != null) {
         this.var_mode_detail = true;
         this.showModalPanelDetail = true;
      }

   }

   public void supprimerDetail() throws HibernateException, NamingException {
      if (this.planningAvicultureAchats != null) {
         this.planningLigneList.remove(this.planningAvicultureAchats);
         this.datamodelPlanningLigne.setWrappedData(this.planningLigneList);
      }

   }

   public void saveDetail() {
      if (!this.var_mode_detail) {
         this.planningAvicultureAchats.setPpaOrdre(this.planningLigneList.size());
         this.planningLigneList.add(this.planningAvicultureAchats);
      }

      this.datamodelPlanningLigne.setWrappedData(this.planningLigneList);
      this.showModalPanelDetail = false;
   }

   public int clauleNumlLigne() {
      int var1 = 0;
      if (this.planningLigneList.size() != 0) {
         for(int var2 = 0; var2 < this.planningLigneList.size(); ++var2) {
            if (this.planningAvicultureAchats.getPpaId() == ((PlanningAvicultureAchats)this.planningLigneList.get(var2)).getPpaId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void annulerDetail() {
      this.showModalPanelDetail = false;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public boolean isShowModalPanelDetail() {
      return this.showModalPanelDetail;
   }

   public void setShowModalPanelDetail(boolean var1) {
      this.showModalPanelDetail = var1;
   }

   public boolean isShowModalPanelPlanning() {
      return this.showModalPanelPlanning;
   }

   public void setShowModalPanelPlanning(boolean var1) {
      this.showModalPanelPlanning = var1;
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

   public DataModel getDatamodelPlanningEntete() {
      return this.datamodelPlanningEntete;
   }

   public void setDatamodelPlanningEntete(DataModel var1) {
      this.datamodelPlanningEntete = var1;
   }

   public DataModel getDatamodelPlanningLigne() {
      return this.datamodelPlanningLigne;
   }

   public void setDatamodelPlanningLigne(DataModel var1) {
      this.datamodelPlanningLigne = var1;
   }

   public PlanningAvicultureAchats getPlanningAvicultureAchats() {
      return this.planningAvicultureAchats;
   }

   public void setPlanningAvicultureAchats(PlanningAvicultureAchats var1) {
      this.planningAvicultureAchats = var1;
   }

   public String getVar_nom_feuille() {
      return this.var_nom_feuille;
   }

   public void setVar_nom_feuille(String var1) {
      this.var_nom_feuille = var1;
   }

   public List getPlanningLigneList() {
      return this.planningLigneList;
   }

   public void setPlanningLigneList(List var1) {
      this.planningLigneList = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getPlanningEnteteList() {
      return this.planningEnteteList;
   }

   public void setPlanningEnteteList(List var1) {
      this.planningEnteteList = var1;
   }

   public String getVar_code_feuille() {
      return this.var_code_feuille;
   }

   public void setVar_code_feuille(String var1) {
      this.var_code_feuille = var1;
   }

   public int getVar_nb_jour() {
      return this.var_nb_jour;
   }

   public void setVar_nb_jour(int var1) {
      this.var_nb_jour = var1;
   }

   public boolean isVar_mode_feuille() {
      return this.var_mode_feuille;
   }

   public void setVar_mode_feuille(boolean var1) {
      this.var_mode_feuille = var1;
   }

   public List getMesActionsItems() {
      return this.mesActionsItems;
   }

   public void setMesActionsItems(List var1) {
      this.mesActionsItems = var1;
   }

   public List getMesTraitementsItems() {
      return this.mesTraitementsItems;
   }

   public void setMesTraitementsItems(List var1) {
      this.mesTraitementsItems = var1;
   }

   public List getMesVaccinsItems() {
      return this.mesVaccinsItems;
   }

   public void setMesVaccinsItems(List var1) {
      this.mesVaccinsItems = var1;
   }
}
