package com.epegase.forms.systeme;

import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersPeg;
import com.epegase.systeme.dao.GroupeDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.MD5Password;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.ObjetPays;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.component.UISelectOne;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class FormSystemSociete implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private int etat = 1;
   private int mode = 9;
   private String pays;
   private UISelectOne selectOneMenu;
   private LecturePays lespays = new LecturePays();
   private String labase;
   private String chemin;
   private boolean testBouton = false;
   private boolean testBoutonModif = false;
   private boolean testBoutonSuppUser;
   private boolean showModalPanelUser = false;
   private boolean showModalPanelSociete = false;
   private StructurePeg structurePeg;
   private StructureDao structureDao;
   private List lesSocietes = new ArrayList();
   private transient DataModel dataModelLesSocites = new ListDataModel();
   private int taillelistSociete;
   private boolean showModalPanelInfoClients = false;
   private String texteInformations;
   private UsersPeg usersPeg = new UsersPeg();
   private Users users = new Users();
   private UserDao userDao;
   private List lesUserspeg = new ArrayList();
   private transient DataModel dataModelLesUsersPeg = new ListDataModel();
   private String baseData = "";

   public FormSystemSociete() throws IOException, SAXException, JDOMException {
   }

   public void instancesDaoUtilisees() {
   }

   public void chargerLesSocietes() throws HibernateException, NamingException {
      String var1 = " where strId> 0";
      if (this.etat != 9) {
         var1 = var1 + " and  stretat=" + this.etat;
      }

      if (this.mode != 9) {
         var1 = var1 + " and  strmode=" + this.mode;
      }

      if (!this.pays.equals("0")) {
         var1 = var1 + " and  strnompays=" + "'" + this.pays + "'";
      }

      this.structureDao = new StructureDao(this.utilInitHibernate);
      this.lesSocietes.clear();
      this.lesSocietes = this.structureDao.selectStructurePeg(var1);
      this.taillelistSociete = this.lesSocietes.size();
      this.dataModelLesSocites.setWrappedData(this.lesSocietes);
   }

   public void toutSelectionner() {
      for(int var1 = 0; var1 < this.lesSocietes.size(); ++var1) {
         this.structurePeg = (StructurePeg)this.lesSocietes.get(var1);
         this.structurePeg.setSelectStructure(true);
      }

   }

   public void rienSelectionner() {
      for(int var1 = 0; var1 < this.lesSocietes.size(); ++var1) {
         this.structurePeg = (StructurePeg)this.lesSocietes.get(var1);
         this.structurePeg.setSelectStructure(false);
      }

   }

   public Boolean structureExsite() throws HibernateException, NamingException {
      boolean var1 = false;
      String var2 = "structure" + this.getStructurePeg().getStrId();
      Session var3 = this.utilInitHibernate.getSysteme();
      SQLQuery var4 = var3.createSQLQuery("SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME='" + var2 + "'");
      List var5 = var4.list();
      this.utilInitHibernate.closeSession();
      if (var5.size() > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void recupererlesUsers() throws HibernateException, NamingException {
      if (this.dataModelLesSocites.isRowAvailable()) {
         this.structurePeg = (StructurePeg)this.dataModelLesSocites.getRowData();
         long var1 = this.structurePeg.getStrId();
         this.lesUserspeg.clear();
         this.userDao = new UserDao(this.utilInitHibernate);
         this.lesUserspeg = this.userDao.selectLesUserPegStr(var1);
         this.dataModelLesUsersPeg.setWrappedData(this.lesUserspeg);
         this.labase = "structure" + this.structurePeg.getStrId();
         this.testBoutonModif = true;
         if (this.structurePeg.getStretat() == 0) {
            this.testBouton = true;
         } else {
            this.testBouton = false;
         }
      } else {
         this.testBoutonModif = false;
      }

   }

   public void recupererUser() {
      if (this.dataModelLesUsersPeg.isRowAvailable()) {
         this.usersPeg = new UsersPeg();
         this.usersPeg = (UsersPeg)this.dataModelLesUsersPeg.getRowData();
         this.testBoutonSuppUser = true;
      } else {
         this.testBoutonSuppUser = false;
      }

   }

   public void ajouterUser() {
      this.usersPeg = new UsersPeg();
      this.showModalPanelUser = true;
   }

   public void modifierUser() {
      if (this.usersPeg != null) {
         this.showModalPanelUser = true;
      }

   }

   public void fermerUser() {
      this.showModalPanelUser = false;
   }

   public void supprimerUser() throws HibernateException, NamingException {
      if (this.usersPeg != null) {
         this.userDao.delUserspeg(this.usersPeg.getUsrid());
         this.lesUserspeg.clear();
         this.userDao = new UserDao(this.utilInitHibernate);
         this.lesUserspeg = this.userDao.selectLesUserPegStr(this.structurePeg.getStrId());
         if (this.structureExsite()) {
            new Users();
            this.userDao = new UserDao(this.labase, this.utilInitHibernate);
            Users var1 = this.userDao.loginUser(this.usersPeg.getUsrlogin());
            if (var1 != null) {
               var1.setUsrEtat(0);
               this.userDao.modUser(var1);
            }
         }

         this.dataModelLesUsersPeg.setWrappedData(this.lesUserspeg);
         this.testBoutonSuppUser = false;
      }

   }

   public void saveUser() throws HibernateException, NamingException {
      if (this.structurePeg != null) {
         MD5Password var1 = new MD5Password();
         this.userDao = new UserDao(this.utilInitHibernate);
         if (this.usersPeg.getUsrid() == 0L) {
            this.usersPeg.setStructurePeg(this.structurePeg);
            this.usersPeg.setUsrdatecreat(new Date());
            if (this.usersPeg.getUsrpw() != null && !this.usersPeg.getUsrpw().isEmpty()) {
               this.usersPeg.setUsrpw(var1.getEncodedPassword(this.usersPeg.getUsrpw()));
            }

            if (this.usersPeg.getUsrcodesecret() != null && !this.usersPeg.getUsrcodesecret().isEmpty()) {
               this.usersPeg.setUsrcodesecret(var1.getEncodedPassword(this.usersPeg.getUsrcodesecret()));
            }

            this.usersPeg.setUsrdatemodif((Date)null);
            this.usersPeg.setUsretat(1);
            this.userDao.insertPeg(this.usersPeg);
         } else {
            this.usersPeg.setUsrdatemodif(new Date());
            this.userDao.ModUserPeg(this.usersPeg);
         }

         if (this.structureExsite()) {
            new Users();
            this.userDao = new UserDao(this.labase, this.utilInitHibernate);
            Users var2 = this.userDao.loginUser(this.usersPeg.getUsrlogin());
            if (var2 == null) {
               new Groupe();
               GroupeDao var4 = new GroupeDao(this.labase, this.utilInitHibernate);
               Groupe var3 = var4.groupeByCode("ADM", (Session)null);
               if (var3 != null) {
                  var2 = new Users();
                  var2.setGroupe(var3);
                  var2.setUsrCollaboration(var3.getGrpCode());
                  var2.setUsrCodeSecret(this.usersPeg.getUsrcodesecret());
                  var2.setUsrDateCreat(this.usersPeg.getUsrdatecreat());
                  var2.setUsrLogin(this.usersPeg.getUsrlogin());
                  var2.setUsrMail(this.usersPeg.getUsrmail());
                  var2.setUsrNom(this.usersPeg.getUsrnom());
                  var2.setUsrPrenom(this.usersPeg.getUsrprenom());
                  var2.setUsrPw(this.usersPeg.getUsrpw());
                  var2.setUsrConnexion(this.usersPeg.getUsrconnexion());
                  var2.setUsrEtat(this.usersPeg.getUsretat());
                  var2.setUsrSysteme(this.usersPeg.getUsrsysteme());
                  var2.setUsrDateCreat(this.usersPeg.getUsrdatecreat());
                  var2.setUsrDateModif(this.usersPeg.getUsrdatemodif());
                  if (var2.getUsrPrenom() != null && !var2.getUsrPrenom().isEmpty()) {
                     var2.setUsrPatronyme(var2.getUsrNom() + " " + var2.getUsrPrenom());
                  } else {
                     var2.setUsrPatronyme(var2.getUsrNom());
                  }

                  this.userDao.insert(var2);
               }
            } else {
               var2.setUsrCodeSecret(this.usersPeg.getUsrcodesecret());
               var2.setUsrDateCreat(this.usersPeg.getUsrdatecreat());
               var2.setUsrLogin(this.usersPeg.getUsrlogin());
               var2.setUsrMail(this.usersPeg.getUsrmail());
               var2.setUsrNom(this.usersPeg.getUsrnom());
               var2.setUsrPrenom(this.usersPeg.getUsrprenom());
               var2.setUsrPw(this.usersPeg.getUsrpw());
               var2.setUsrConnexion(this.usersPeg.getUsrconnexion());
               var2.setUsrEtat(this.usersPeg.getUsretat());
               var2.setUsrSysteme(this.usersPeg.getUsrsysteme());
               var2.setUsrDateCreat(this.usersPeg.getUsrdatecreat());
               var2.setUsrDateModif(this.usersPeg.getUsrdatemodif());
               if (var2.getUsrPrenom() != null && !var2.getUsrPrenom().isEmpty()) {
                  var2.setUsrPatronyme(var2.getUsrNom() + " " + var2.getUsrPrenom());
               } else {
                  var2.setUsrPatronyme(var2.getUsrNom());
               }

               this.userDao.modUser(var2);
            }
         }

         this.recupererlesUsers();
      }

      this.showModalPanelUser = false;
   }

   public void deleteStructureSel() throws HibernateException, NamingException {
      if (this.structurePeg.getStretat() == 0) {
         this.structureDao = new StructureDao(this.labase, this.utilInitHibernate);
         this.userDao.delUserspegByIdStr(this.structurePeg);
         this.dataModelLesUsersPeg = new ListDataModel();
         if (this.structureExsite()) {
            this.structureDao.delStructurepegByIdStr(this.structurePeg.getStrId());
            this.chemin = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase;
            File var1 = new File(this.chemin);
            var1.delete();
            this.structureDao.dropDataBase(this.labase);
         }

         this.chargerLesSocietes();
         this.testBouton = false;
         this.testBoutonModif = false;
      }

   }

   public void selectionElement() {
      List var1 = this.lespays.getMespays();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         ObjetPays var3 = (ObjetPays)var2.next();
         if (this.getSelectOneMenu().getValue().toString().equals(var3.getNom_FR().toString())) {
            this.structurePeg.setStrdevise(var3.getDevise());
            break;
         }
      }

   }

   public void modifStructureSel() throws HibernateException, NamingException {
      this.structureDao = new StructureDao(this.labase, this.utilInitHibernate);
      new Structure();
      Structure var1 = this.structureDao.logStructureId(this.structurePeg.getStrId(), (Session)null);
      if (var1 != null) {
         var1.setStrraisonsociale(this.structurePeg.getStrraisonsociale());
         var1.setStrsigle(this.structurePeg.getStrsigle());
         var1.setStrformejuridique(this.structurePeg.getStrformejuridique());
         var1.setStrtypeentreprise(this.structurePeg.getStrtypeentreprise());
         var1.setStrnompays(this.structurePeg.getStrnompays());
         var1.setStrlangue(this.structurePeg.getStrlangue());
         var1.setStrdevise(this.structurePeg.getStrdevise());
         var1.setStrformatdevise(this.structurePeg.getStrformatdevise());
         var1.setStrzonecommerciale(this.structurePeg.getStrzonecommerciale());
         var1.setStrzonefiscale(this.structurePeg.getStrzonefiscale());
         var1.setStradresse(this.structurePeg.getStradresse());
         var1.setStrville(this.structurePeg.getStrville());
         var1.setStrrue(this.structurePeg.getStrrue());
         var1.setStrlot(this.structurePeg.getStrlot());
         var1.setStrporte(this.structurePeg.getStrporte());
         var1.setStrbatiment(this.structurePeg.getStrbatiment());
         var1.setStretage(this.structurePeg.getStretage());
         var1.setStrquartier(this.structurePeg.getStrquartier());
         var1.setStrcommune(this.structurePeg.getStrcommune());
         var1.setStrzone(this.structurePeg.getStrzone());
         var1.setStrdepartement(this.structurePeg.getStrdepartement());
         var1.setStrbp(this.structurePeg.getStrbp());
         var1.setStrcedex(this.structurePeg.getStrcedex());
         var1.setStrtel1(this.structurePeg.getStrtel1());
         var1.setStrtel2(this.structurePeg.getStrtel2());
         var1.setStrtel3(this.structurePeg.getStrtel3());
         var1.setStrfax(this.structurePeg.getStrfax());
         var1.setStrtelex(this.structurePeg.getStrtelex());
         var1.setStrnum1(this.structurePeg.getStrnum1());
         var1.setStrnum2(this.structurePeg.getStrnum2());
         var1.setStrnum3(this.structurePeg.getStrnum3());
         var1.setStrnum4(this.structurePeg.getStrnum4());
         var1.setStrnum5(this.structurePeg.getStrnum5());
         var1.setStrnum6(this.structurePeg.getStrnum6());
         var1.setStrnum7(this.structurePeg.getStrnum7());
         var1.setStrnum8(this.structurePeg.getStrnum8());
         var1.setStrnum9(this.structurePeg.getStrnum9());
         var1.setStrnum10(this.structurePeg.getStrnum10());
         var1.setStrnum11(this.structurePeg.getStrnum11());
         var1.setStrnum12(this.structurePeg.getStrnum12());
         var1.setStrnum13(this.structurePeg.getStrnum13());
         var1.setStrnum14(this.structurePeg.getStrnum14());
         var1.setStrnum15(this.structurePeg.getStrnum15());
         var1.setStrnum16(this.structurePeg.getStrnum16());
         var1.setStrnum17(this.structurePeg.getStrnum17());
         var1.setStrnum18(this.structurePeg.getStrnum18());
         var1.setStrnum19(this.structurePeg.getStrnum19());
         var1.setStrnum20(this.structurePeg.getStrnum20());
         var1.setStrmod1(this.structurePeg.getStrmod1());
         var1.setStrmod2(this.structurePeg.getStrmod2());
         var1.setStrmod3(this.structurePeg.getStrmod3());
         var1.setStrmod4(this.structurePeg.getStrmod4());
         var1.setStrmod5(this.structurePeg.getStrmod5());
         var1.setStrmod6(this.structurePeg.getStrmod6());
         var1.setStrmod7(this.structurePeg.getStrmod7());
         var1.setStrmod8(this.structurePeg.getStrmod8());
         var1.setStrmod9(this.structurePeg.getStrmod9());
         var1.setStrmod10(this.structurePeg.getStrmod10());
         var1.setStretat(this.structurePeg.getStretat());
         var1.setStrmode(this.structurePeg.getStrmode());
         var1.setStrmaitrecabinet(this.structurePeg.getStrmaitrecabinet());
         this.structureDao.modStructure(var1);
         this.structureDao.updatCrPeg(this.structurePeg);
         if (this.lesUserspeg.size() != 0) {
            for(int var2 = 0; var2 < this.lesUserspeg.size(); ++var2) {
               this.usersPeg = (UsersPeg)this.lesUserspeg.get(var2);
               this.usersPeg.setUsretat(this.structurePeg.getStretat());
               this.usersPeg = this.userDao.ModUserPeg(this.usersPeg);
            }
         }
      }

   }

   public void initInformationsclients() {
      this.texteInformations = "";
      this.showModalPanelInfoClients = true;
   }

   public void fermerInformationsclients() {
      this.showModalPanelInfoClients = false;
   }

   public void informerLesClients() throws Exception {
      new StructurePeg();
      new UsersPeg();
      this.userDao = new UserDao(this.utilInitHibernate);
      Session var3 = this.utilInitHibernate.getSysteme();

      for(int var4 = 0; var4 < this.lesSocietes.size(); ++var4) {
         StructurePeg var1 = (StructurePeg)this.lesSocietes.get(var4);
         if (var1.isSelectStructure() && var1.getStrId() <= 1000000000L) {
            this.lesUserspeg.clear();
            String var5 = "";
            this.lesUserspeg = this.userDao.selectLesUserPegStr(var1.getStrId(), 1, 3, var3);

            for(int var6 = 0; var6 < this.lesUserspeg.size(); ++var6) {
               UsersPeg var2 = (UsersPeg)this.lesUserspeg.get(var6);
               if (var2.getUsrconnexion() == 0 && var2.getUsretat() == 1 && var2.getUsrmail() != null && !var2.getUsrmail().isEmpty()) {
                  if (var5 != null && !var5.isEmpty()) {
                     var5 = var5 + "," + var2.getUsrmail();
                  } else {
                     var5 = var2.getUsrmail();
                  }
               }
            }

            if (var5 != null && !var5.isEmpty()) {
               this.envoiInformations(var5, var1, var3);
            }
         }
      }

      this.utilInitHibernate.closeSession();
      this.showModalPanelInfoClients = false;
   }

   public String envoiInformations(String var1, StructurePeg var2, Session var3) throws Exception {
      String var4 = "<html><head></head><body ><h:form>";
      var4 = var4 + "<table style=\"border:1px dotted green\" align=\"center\" width=\"60%\">";
      var4 = var4 + "<thead><tr><th><h1>Les NEWS d`e-P&eacute;gase!</h1></th></tr></thead>";
      var4 = var4 + "<tbody><tr><td><br/>";
      var4 = var4 + this.texteInformations;
      var4 = var4 + "<br/><p style=\"background-color:green;color:white;font-weight:bold;width:100%\"><center>-------------------------</center></p><br/>";
      var4 = var4 + "Vous avez re&ccedil;u ce mail car votre structure : " + var2.getStrraisonsociale() + " est enregistr&eacute;e dans notre base en tant qu`utilisateur d`e-P&eacute;gase.<br/><br/>";
      var4 = var4 + "Pour toutes informations sur votre compte, sur les offres ";
      var4 = var4 + "ou sur les services e-P&eacute;gase... Contactez nous sur infos@e-pegase.biz ou sur epegase.biz@gmail.com.<br/><br/>";
      var4 = var4 + "Merci d'utiliser e-P&eacute;gase !<br/><br/>L'&eacute;quipe e-P&eacute;gase<br/><br/>";
      var4 = var4 + "<i style=\"color:red;font-size:11px;\">Ce message vous est ";
      var4 = var4 + "envoy&eacute; automatiquement.</i></td></tr></tbody></table>";
      var4 = var4 + "</h:form></body></html>";
      UtilMail var5 = new UtilMail(this.structureLog);
      var5.mailNews(var4, var1, "NEWS E-PEGASE");
      return "inscription";
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

   public String getPays() {
      return this.pays;
   }

   public void setPays(String var1) {
      this.pays = var1;
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

   public UISelectOne getSelectOneMenu() {
      return this.selectOneMenu;
   }

   public void setSelectOneMenu(UISelectOne var1) {
      this.selectOneMenu = var1;
   }

   public LecturePays getLespays() {
      return this.lespays;
   }

   public void setLespays(LecturePays var1) {
      this.lespays = var1;
   }

   public String getChemin() {
      return this.chemin;
   }

   public void setChemin(String var1) {
      this.chemin = var1;
   }

   public List getLesSocietes() {
      return this.lesSocietes;
   }

   public void setLesSocietes(List var1) {
      this.lesSocietes = var1;
   }

   public UsersPeg getUsersPeg() {
      return this.usersPeg;
   }

   public void setUsersPeg(UsersPeg var1) {
      this.usersPeg = var1;
   }

   public int getTaillelistSociete() {
      return this.taillelistSociete;
   }

   public void setTaillelistSociete(int var1) {
      this.taillelistSociete = var1;
   }

   public String getBaseData() {
      return this.baseData;
   }

   public void setBaseData(String var1) {
      this.baseData = var1;
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public Users getUsersLog() {
      return this.usersLog;
   }

   public void setUsersLog(Users var1) {
      this.usersLog = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isShowModalPanelInfoClients() {
      return this.showModalPanelInfoClients;
   }

   public void setShowModalPanelInfoClients(boolean var1) {
      this.showModalPanelInfoClients = var1;
   }

   public String getTexteInformations() {
      return this.texteInformations;
   }

   public void setTexteInformations(String var1) {
      this.texteInformations = var1;
   }

   public boolean isShowModalPanelSociete() {
      return this.showModalPanelSociete;
   }

   public void setShowModalPanelSociete(boolean var1) {
      this.showModalPanelSociete = var1;
   }

   public boolean isShowModalPanelUser() {
      return this.showModalPanelUser;
   }

   public void setShowModalPanelUser(boolean var1) {
      this.showModalPanelUser = var1;
   }
}
