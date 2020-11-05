package com.epegase.forms.administration;

import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.UtilInitHibernate;
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

public class FormEquipes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private String lien;
   private boolean codelibVide = false;
   private boolean existeCode = true;
   private List equipesList = new ArrayList();
   private transient DataModel datamodelEquipes;
   private Equipes equipes;
   private EquipesDao equipesDao;
   private boolean showmodelPanel = false;
   private boolean var_affiche_bouton = false;
   private boolean var_inactif = false;
   private List mesResponsable = new ArrayList();
   private UserDao userDao;
   private List lesAgents = new ArrayList();
   private transient DataModel dataModelAgents = new ListDataModel();
   private List mesDepotsItems = new ArrayList();
   private List mesDepotsOrigineItems = new ArrayList();
   private List mesCaissesItems = new ArrayList();

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesEquipes(Session var1) throws HibernateException, NamingException, ParseException {
      this.setLien(this.lien);
      this.datamodelEquipes = new ListDataModel();
      this.equipesList = new ArrayList();
      this.equipesList = this.equipesDao.selectEquipes(var1);
      this.datamodelEquipes.setWrappedData(this.equipesList);
      this.mesResponsable.clear();
      new ArrayList();
      List var2 = this.userDao.chargerLesSignataires("TOUS", var1);
      if (var2.size() != 0) {
         this.mesResponsable.add(new SelectItem(0, ""));

         for(int var3 = 0; var3 < var2.size(); ++var3) {
            new Users();
            Users var4 = (Users)var2.get(var3);
            this.mesResponsable.add(new SelectItem(var4.getUsrid(), var4.getUsrNom() + ":" + var4.getUsrPrenom()));
         }
      }

      this.mesDepotsItems.clear();
      this.mesDepotsOrigineItems.clear();
      new ExercicesAchats();
      ExercicesAchatsDao var11 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
      ExercicesAchats var10 = var11.recupererLastExo(var1);
      if (var10 != null) {
         DepotAchatsDao var5 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var6 = var5.selectActifDepot(23, var1);
         if (var6.size() != 0) {
            for(int var7 = 0; var7 < var6.size(); ++var7) {
               String var8 = ((DepotAchats)var6.get(var7)).getDpoCode() + ":" + ((DepotAchats)var6.get(var7)).getDpoLibelle();
               this.mesDepotsItems.add(new SelectItem(var8));
            }
         }

         new ArrayList();
         List var14 = var5.selectActifDepot(33, var1);
         if (var14.size() != 0) {
            for(int var16 = 0; var16 < var14.size(); ++var16) {
               String var9 = ((DepotAchats)var14.get(var16)).getDpoCode() + ":" + ((DepotAchats)var14.get(var16)).getDpoLibelle();
               this.mesDepotsOrigineItems.add(new SelectItem(var9));
            }
         }
      }

      new ExercicesVentes();
      ExercicesVentesDao var13 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var12 = var13.recupererLastExo(var1);
      if (var12 != null) {
         CaissesCommercialesDao var15 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
         this.mesCaissesItems = var15.selectActifCaisseItems(var1);
      }

   }

   public void selectionEquipe() throws HibernateException, NamingException {
      if (this.datamodelEquipes.isRowAvailable()) {
         this.equipes = (Equipes)this.datamodelEquipes.getRowData();
         if (this.equipes.getEquInactif() == 1) {
            this.var_inactif = true;
         } else {
            this.var_inactif = false;
         }

         this.var_affiche_bouton = true;
         this.lesAgents = this.userDao.selectAgentsEquipe(this.equipes.getEquId(), (Session)null);
         if (this.lesAgents.size() != 0) {
            new Users();

            Users var1;
            for(int var2 = 0; var2 < this.lesAgents.size(); ++var2) {
               var1 = (Users)this.lesAgents.get(var2);
               var1.setSelectUser(false);
            }

            if (this.equipes.getEquIdAgent() != null && !this.equipes.getEquIdAgent().isEmpty()) {
               int var4;
               if (!this.equipes.getEquIdAgent().contains(":")) {
                  long var8 = Long.parseLong(this.equipes.getEquIdAgent());

                  for(var4 = 0; var4 < this.lesAgents.size(); ++var4) {
                     var1 = (Users)this.lesAgents.get(var4);
                     if (var1.getUsrid() == var8) {
                        var1.setSelectUser(true);
                     }
                  }
               } else {
                  String[] var7 = this.equipes.getEquIdAgent().split(":");

                  for(int var3 = 0; var3 < this.lesAgents.size(); ++var3) {
                     var1 = (Users)this.lesAgents.get(var3);

                     for(var4 = 0; var4 < var7.length; ++var4) {
                        long var5 = Long.parseLong(var7[var4]);
                        if (var1.getUsrid() == var5) {
                           var1.setSelectUser(true);
                           break;
                        }
                     }
                  }
               }
            }
         }

         this.dataModelAgents.setWrappedData(this.lesAgents);
      }

   }

   public void ajouterEquipes() throws HibernateException, NamingException {
      this.equipes = new Equipes();
      this.var_inactif = false;
      this.codelibVide = false;
      this.existeCode = true;
      this.showmodelPanel = true;
      this.lesAgents = this.userDao.selectAgentsEquipe(this.equipes.getEquId(), (Session)null);
      if (this.lesAgents.size() != 0) {
         new Users();

         for(int var2 = 0; var2 < this.lesAgents.size(); ++var2) {
            Users var1 = (Users)this.lesAgents.get(var2);
            var1.setSelectUser(false);
         }
      }

      this.dataModelAgents.setWrappedData(this.lesAgents);
   }

   public void modifierEquipes() {
      if (this.equipes != null) {
         this.codelibVide = true;
         this.existeCode = false;
         this.showmodelPanel = true;
      }

   }

   public void supprimerEquipes() throws HibernateException, NamingException {
      if (this.equipes != null) {
         this.lesAgents = this.userDao.selectAgentsEquipe(this.equipes.getEquId(), (Session)null);
         if (this.lesAgents.size() != 0) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Equipes");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               new Users();

               for(int var4 = 0; var4 < this.lesAgents.size(); ++var4) {
                  Users var3 = (Users)this.lesAgents.get(var4);
                  if (var3.getUsrIdEquipe() != 0L) {
                     var3.setUsrIdEquipe(0L);
                     var3.setUsrNomEquipe("");
                     var3.setUsrResponsableVentes(0L);
                     this.userDao.modUser(var3, var1);
                  }
               }

               var2.commit();
            } catch (HibernateException var8) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var8;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }

         this.equipesList.remove(this.equipes);
         this.datamodelEquipes.setWrappedData(this.equipesList);
         this.equipesDao.delete(this.equipes);
      }

   }

   public void annulerEquipes() {
      this.var_affiche_bouton = false;
      this.showmodelPanel = false;
   }

   public void saveEquipes() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Equipes");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.equipes.getEquIdResponsable() != 0L) {
            new Users();
            Users var3 = this.userDao.selectByIdUsers(this.equipes.getEquIdResponsable(), var1);
            if (var3 != null) {
               this.equipes.setEquNomResponsable(var3.getUsrPatronyme());
            } else {
               this.equipes.setEquNomResponsable("");
            }
         } else {
            this.equipes.setEquNomResponsable("");
         }

         if (this.var_inactif) {
            this.equipes.setEquInactif(1);
         } else {
            this.equipes.setEquInactif(0);
         }

         String var13 = "";
         String var4 = "";
         if (this.lesAgents.size() != 0) {
            boolean var5 = true;
            new Users();

            for(int var7 = 0; var7 < this.lesAgents.size(); ++var7) {
               Users var6 = (Users)this.lesAgents.get(var7);
               if (var6.isSelectUser()) {
                  if (var5) {
                     var5 = false;
                     var13 = "" + var6.getUsrid();
                     var4 = var6.getUsrPatronyme();
                  } else {
                     var13 = var13 + ":" + var6.getUsrid();
                     var4 = var4 + ":" + var6.getUsrPatronyme();
                  }
               }
            }
         }

         this.equipes.setEquIdAgent(var13);
         this.equipes.setEquNomAgent(var4);
         if (this.equipes.getEquId() == 0L) {
            this.equipes.setEquUserCreat(this.usersLog.getUsrid());
            this.equipes.setEquDateCreat(new Date());
            this.equipes = this.equipesDao.insert(this.equipes, var1);
            this.equipesList.add(this.equipes);
            this.datamodelEquipes.setWrappedData(this.equipesList);
         } else {
            this.equipes.setEquUserModif(this.usersLog.getUsrid());
            this.equipes.setEquDateModif(new Date());
            this.equipes = this.equipesDao.modif(this.equipes, var1);
         }

         if (this.lesAgents.size() != 0) {
            new Users();

            for(int var15 = 0; var15 < this.lesAgents.size(); ++var15) {
               Users var14;
               if (((Users)this.lesAgents.get(var15)).isSelectUser()) {
                  var14 = this.userDao.selectByIdUsers(((Users)this.lesAgents.get(var15)).getUsrid(), var1);
                  if (var14 != null) {
                     var14.setUsrIdEquipe(this.equipes.getEquId());
                     var14.setUsrNomEquipe(this.equipes.getEquNomFr());
                     var14.setUsrResponsableVentes(this.equipes.getEquIdResponsable());
                     this.userDao.modUser(var14, var1);
                  }
               } else {
                  var14 = this.userDao.selectByIdUsers(((Users)this.lesAgents.get(var15)).getUsrid(), var1);
                  if (var14 != null) {
                     var14.setUsrIdEquipe(0L);
                     var14.setUsrNomEquipe("");
                     var14.setUsrResponsableVentes(0L);
                     this.userDao.modUser(var14, var1);
                  }
               }
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

      this.showmodelPanel = false;
      this.var_affiche_bouton = false;
   }

   public void verifielesSaisieCode() throws HibernateException, NamingException {
      this.existeCode = this.equipesDao.existCode(this.getEquipes().getEquCode(), (Session)null);
      if (!this.getEquipes().getEquCode().equals("") && !this.getEquipes().getEquNomFr().equals("")) {
         this.codelibVide = true;
      } else {
         this.codelibVide = false;
      }

   }

   public void verifielesSaisieLibelleAct() {
      if (this.getEquipes().getEquNomFr().equals("")) {
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

   public List getEquipesList() {
      return this.equipesList;
   }

   public void setEquipesList(List var1) {
      this.equipesList = var1;
   }

   public Equipes getEquipes() {
      return this.equipes;
   }

   public void setEquipes(Equipes var1) {
      this.equipes = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public DataModel getDatamodelEquipes() {
      return this.datamodelEquipes;
   }

   public void setDatamodelEquipes(DataModel var1) {
      this.datamodelEquipes = var1;
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

   public List getMesResponsable() {
      return this.mesResponsable;
   }

   public void setMesResponsable(List var1) {
      this.mesResponsable = var1;
   }

   public DataModel getDataModelAgents() {
      return this.dataModelAgents;
   }

   public void setDataModelAgents(DataModel var1) {
      this.dataModelAgents = var1;
   }

   public List getMesCaissesItems() {
      return this.mesCaissesItems;
   }

   public void setMesCaissesItems(List var1) {
      this.mesCaissesItems = var1;
   }

   public List getMesDepotsItems() {
      return this.mesDepotsItems;
   }

   public void setMesDepotsItems(List var1) {
      this.mesDepotsItems = var1;
   }

   public List getMesDepotsOrigineItems() {
      return this.mesDepotsOrigineItems;
   }

   public void setMesDepotsOrigineItems(List var1) {
      this.mesDepotsOrigineItems = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
