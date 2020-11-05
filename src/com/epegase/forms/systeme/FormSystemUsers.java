package com.epegase.forms.systeme;

import com.epegase.systeme.classe.CabinetPeg;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersPeg;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormSystemUsers implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private int etat = 1;
   private int mode = 9;
   private String labase;
   private String chemin;
   private boolean testBouton = false;
   private boolean testBoutonModif = false;
   private boolean testBoutonSuppUser;
   private UsersPeg usersPeg = new UsersPeg();
   private Users users = new Users();
   private UserDao userDao;
   private List lesUsers = new ArrayList();
   private transient DataModel dataModelLesUsersPeg = new ListDataModel();
   private StructurePeg structurePeg;
   private StructureDao structureDao;
   private transient DataModel dataModelLesSocites = new ListDataModel();
   private boolean var_showBarProg = false;
   private String var_info;
   private int var_currentValue;

   public FormSystemUsers() throws IOException {
   }

   public void instancesDaoUtilisees() {
   }

   public void chargerLesUsers() throws HibernateException, NamingException {
      String var1 = " where usrid> 0";
      if (this.etat != 9) {
         var1 = var1 + " and   usretat=" + this.etat;
      }

      if (this.mode != 9) {
         var1 = var1 + " and  usrsysteme=" + this.mode;
      }

      this.usersPeg = new UsersPeg();
      this.lesUsers.clear();
      this.userDao = new UserDao(this.utilInitHibernate);
      this.lesUsers = this.userDao.selectUserPeg(var1);
      this.dataModelLesUsersPeg.setWrappedData(this.lesUsers);
   }

   public void selectionUser() {
      if (this.dataModelLesUsersPeg.isRowAvailable()) {
         this.usersPeg = (UsersPeg)this.dataModelLesUsersPeg.getRowData();
      }

   }

   public void supprimerAgent() throws HibernateException, NamingException {
      if (this.usersPeg != null) {
         this.userDao.delUserspeg(this.usersPeg.getUsrid());
         this.lesUsers.remove(this.usersPeg);
         this.dataModelLesUsersPeg.setWrappedData(this.lesUsers);
         this.usersPeg = new UsersPeg();
      }

   }

   public void activeInformations() throws HibernateException, NamingException {
      if (this.usersPeg != null) {
         if (this.usersPeg.getUsrconnexion() == 0) {
            this.usersPeg.setUsrconnexion(1);
         } else {
            this.usersPeg.setUsrconnexion(0);
         }

         this.usersPeg = this.userDao.ModUserPeg(this.usersPeg);
      }

   }

   public void recupererLesUsers() throws HibernateException, NamingException {
      this.var_showBarProg = true;
      this.var_info = "Chargement des structures...";
      this.var_currentValue = 0;
      if (this.lesUsers.size() == 0) {
         this.chargerLesUsers();
      }

      UtilNombre var1 = new UtilNombre();
      new CabinetPeg();
      new ArrayList();
      Object var4 = new ArrayList();
      this.structureDao = new StructureDao(this.utilInitHibernate);
      String var5 = "where cabinetPeg is null or (cabinetPeg is not null and strmaitrecabinet <> 0)";
      List var3 = this.structureDao.selectStructurePeg(var5);
      if (var3.size() != 0 && this.lesUsers.size() != 0) {
         for(int var6 = 0; var6 < var3.size(); ++var6) {
            this.structurePeg = (StructurePeg)var3.get(var6);
            CabinetPeg var2 = this.structurePeg.getCabinetPeg();
            this.var_info = "Structure : " + this.structurePeg.getStrraisonsociale();
            if (var6 != 0) {
               double var7 = (double)var3.size();
               double var9 = var1.myRound(var7 / (double)var6, 4);
               double var11 = var1.myRound(100.0D / var9, 2);
               this.var_currentValue = (int)var11;
            }

            ((List)var4).clear();
            Session var13 = this.utilInitHibernate.getOpenSession("structure" + this.structurePeg.getStrId(), "");
            this.userDao = new UserDao("structure" + this.structurePeg.getStrId(), this.utilInitHibernate);
            var4 = this.userDao.selectAllUser(var13);
            this.utilInitHibernate.closeSession();
            if (((List)var4).size() != 0) {
               new Users();
               UsersPeg var14 = new UsersPeg();

               for(int var10 = 0; var10 < ((List)var4).size(); ++var10) {
                  Users var8 = (Users)((List)var4).get(var10);
                  boolean var15 = false;
                  if (var8.getUsrMail() != null && !var8.getUsrMail().isEmpty()) {
                     for(int var12 = 0; var12 < this.lesUsers.size(); ++var12) {
                        var14 = (UsersPeg)this.lesUsers.get(var12);
                        if (var14.getUsrmail() != null && !var14.getUsrmail().isEmpty() && var14.getUsrmail().equalsIgnoreCase(var8.getUsrMail()) && var14.getStructurePeg().getStrId() == this.structurePeg.getStrId()) {
                           var15 = true;
                           break;
                        }
                     }

                     this.userDao = new UserDao(this.utilInitHibernate);
                     if (!var15) {
                        this.usersPeg = new UsersPeg();
                        this.usersPeg.setStructurePeg(this.structurePeg);
                        this.usersPeg.setCabinetPeg(var2);
                        this.usersPeg.setUsradresse(var8.getUsrAdresse());
                        this.usersPeg.setUsrbp(var8.getUsrBp());
                        this.usersPeg.setUsrcodesecret(var8.getUsrCodeSecret());
                        this.usersPeg.setUsrcollaboration(var8.getUsrCollaboration());
                        this.usersPeg.setUsrdatecreat(var8.getUsrDateCreat());
                        this.usersPeg.setUsrdatemodif(var8.getUsrDateModif());
                        this.usersPeg.setUsretat(var8.getUsrEtat());
                        this.usersPeg.setUsrfonction(var8.getUsrFonction());
                        this.usersPeg.setUsrlangue(var8.getUsrLangue());
                        this.usersPeg.setUsrlogin(var8.getUsrLogin());
                        this.usersPeg.setUsrmail(var8.getUsrMail());
                        this.usersPeg.setUsrnom(var8.getUsrNom());
                        this.usersPeg.setUsrnompays(var8.getUsrNomPays());
                        this.usersPeg.setUsrprenom(var8.getUsrPrenom());
                        this.usersPeg.setUsrpw(var8.getUsrPw());
                        this.usersPeg.setUsrsysteme(var8.getUsrSysteme());
                        this.usersPeg.setUsrtelbureau(var8.getUsrTelBureau());
                        this.usersPeg.setUsrteldomicile(var8.getUsrTelDomicile());
                        this.usersPeg.setUsrville(var8.getUsrVille());
                        this.usersPeg = this.userDao.insertPeg(this.usersPeg);
                        this.lesUsers.add(this.usersPeg);
                     } else {
                        var14.setUsradresse(var8.getUsrAdresse());
                        var14.setUsrbp(var8.getUsrBp());
                        var14.setUsrcollaboration(var8.getUsrCollaboration());
                        var14.setUsrdatecreat(var8.getUsrDateCreat());
                        var14.setUsrdatemodif(var8.getUsrDateModif());
                        var14.setUsretat(var8.getUsrEtat());
                        var14.setUsrfonction(var8.getUsrFonction());
                        var14.setUsrlangue(var8.getUsrLangue());
                        var14.setUsrnom(var8.getUsrNom());
                        var14.setUsrnompays(var8.getUsrNomPays());
                        var14.setUsrprenom(var8.getUsrPrenom());
                        var14.setUsrtelbureau(var8.getUsrTelBureau());
                        var14.setUsrteldomicile(var8.getUsrTelDomicile());
                        var14.setUsrville(var8.getUsrVille());
                        var14 = this.userDao.ModUserPeg(var14);
                     }
                  }
               }
            }
         }
      }

      this.chargerLesUsers();
      this.var_showBarProg = false;
   }

   public StructurePeg getStructurePeg() {
      return this.structurePeg;
   }

   public void setStructurePeg(StructurePeg var1) {
      this.structurePeg = var1;
   }

   public DataModel getDataModelLesSocites() {
      return this.dataModelLesSocites;
   }

   public void setDataModelLesSocites(DataModel var1) {
      this.dataModelLesSocites = var1;
   }

   public int getEtat() {
      return this.etat;
   }

   public void setEtat(int var1) {
      this.etat = var1;
   }

   public int getMode() {
      return this.mode;
   }

   public void setMode(int var1) {
      this.mode = var1;
   }

   public DataModel getDataModelLesUsersPeg() {
      return this.dataModelLesUsersPeg;
   }

   public void setDataModelLesUsersPeg(DataModel var1) {
      this.dataModelLesUsersPeg = var1;
   }

   public String getLabase() {
      return this.labase;
   }

   public void setLabase(String var1) {
      this.labase = var1;
   }

   public boolean isTestBouton() {
      return this.testBouton;
   }

   public void setTestBouton(boolean var1) {
      this.testBouton = var1;
   }

   public boolean isTestBoutonModif() {
      return this.testBoutonModif;
   }

   public void setTestBoutonModif(boolean var1) {
      this.testBoutonModif = var1;
   }

   public boolean isTestBoutonSuppUser() {
      return this.testBoutonSuppUser;
   }

   public void setTestBoutonSuppUser(boolean var1) {
      this.testBoutonSuppUser = var1;
   }

   public String getChemin() {
      return this.chemin;
   }

   public void setChemin(String var1) {
      this.chemin = var1;
   }

   public UsersPeg getUsersPeg() {
      return this.usersPeg;
   }

   public void setUsersPeg(UsersPeg var1) {
      this.usersPeg = var1;
   }

   public List getLesUsers() {
      return this.lesUsers;
   }

   public void setLesUsers(List var1) {
      this.lesUsers = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public String getVar_info() {
      return this.var_info;
   }

   public void setVar_info(String var1) {
      this.var_info = var1;
   }

   public boolean isVar_showBarProg() {
      return this.var_showBarProg;
   }

   public void setVar_showBarProg(boolean var1) {
      this.var_showBarProg = var1;
   }
}
