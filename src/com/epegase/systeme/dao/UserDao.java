package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersPeg;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao implements Serializable {
   private Users users;
   private UsersPeg usersPeg;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public UserDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public UserDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Users insert(Users var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.save(var1);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public Users insert(Users var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Users modUser(Users var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.update(var1);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public Users modUser(Users var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delUsers(Users var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.delete(var1);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public UsersPeg insertPeg(UsersPeg var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.save(var1);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public UsersPeg insertPeg(UsersPeg var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public UsersPeg ModUserPeg(UsersPeg var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.update(var1);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public void delUserspeg(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSysteme();
      Transaction var4 = var3.beginTransaction();
      var4.begin();
      Query var5 = var3.createQuery("delete from  UsersPeg u where u.usrid =:id");
      var5.setParameter("id", var1);
      var5.executeUpdate();
      var4.commit();
      this.utilInitHibernate.closeSession();
   }

   public void delUserspegByIdStr(StructurePeg var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from  UsersPeg u where u.structurePeg =:strparam");
      var4.setParameter("strparam", var1);
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
   }

   public List selectUserPeg(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      List var3 = var2.createQuery("from UsersPeg " + var1).list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List selectUser(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Users where usrSysteme<>3").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectAllUser(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Users").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectAgentsEquipe(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      List var5 = var3.createQuery("from Users where (usrIdEquipe=0 or usrIdEquipe=" + var1 + ") and usrSysteme<=3 and usrEtat=1").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectUserActif(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Users where usrSysteme<=3 and usrEtat=1  order by usrPatronyme").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectUserSevice(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Object var4 = new ArrayList();
      if (var1 != null && !var1.equals("")) {
         var4 = var2.createQuery("from Users where usrSysteme<=3 and usrEtat=1 and usrService='" + var1 + "' order by usrPatronyme").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List selectUserBrouillards(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      new ArrayList();
      List var3 = var1.createQuery("from Users where usrEtat=1 and (usrAccesBrouillard=1 or usrAccesBrouillard=2)").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectUserGroup(Groupe var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Users where groupe=:param").setParameter("param", var1);
      List var5 = var4.list();
      var2.flush();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectUserGroupActif(Groupe var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Users where groupe=:param and usrSysteme<=2 and usrEtat=1").setParameter("param", var1);
      List var5 = var4.list();
      var2.flush();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listeUsers(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Object var4 = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         var4 = var2.createQuery(var1).list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public UsersPeg selectUserPeg(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSysteme();
      List var4 = var3.createQuery("from UsersPeg where usr_id=" + var1).list();
      this.utilInitHibernate.closeSession();
      if (var4.size() > 0) {
         UsersPeg var5 = (UsersPeg)var4.get(0);
         return var5;
      } else {
         return null;
      }
   }

   public UsersPeg selectUserPegStr(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSysteme();
      List var4 = var3.createQuery("from UsersPeg where str_id=" + var1).list();
      this.utilInitHibernate.closeSession();
      if (var4.size() > 0) {
         UsersPeg var5 = (UsersPeg)var4.get(0);
         return var5;
      } else {
         return null;
      }
   }

   public List selectLesUserPegStr(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSysteme();
      List var4 = null;
      if (var1 != 0L) {
         var4 = var3.createQuery("from UsersPeg where str_id=" + var1).list();
      } else {
         var4 = var3.createQuery("from UsersPeg where usretat=1").list();
      }

      new ArrayList();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List selectLesUserPegStr(long var1, int var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getSysteme();
         var6 = true;
      }

      List var7 = var5.createQuery("from UsersPeg where str_id=:isd and usretat=:usetat and usrsysteme<=:usSystem").setLong("isd", var1).setInteger("usetat", var3).setInteger("usSystem", var4).list();
      new ArrayList();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectUsersAnniv(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Date var3 = new Date();
      DateFormat var4 = DateFormat.getDateInstance(3);
      String var5 = var4.format(var3).substring(0, 5);
      List var6 = var1.createQuery("from Users where usrAnniversaire=:dt").setParameter("dt", var5).list();
      new ArrayList();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectUserExiste(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      List var5 = var4.createQuery("from Users where " + var1 + "=" + var2).list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public Users logUser(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      List var4 = var2.createQuery("from Users where usr_mail = '" + var1 + "'").list();
      var2.disconnect();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4.size() > 0 ? (Users)var4.get(0) : null;
   }

   public Users loginUser(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      List var3 = var2.createQuery("from Users where usr_login = '" + var1 + "'").list();
      var2.disconnect();
      this.utilInitHibernate.closeSession();
      return var3.size() > 0 ? (Users)var3.get(0) : null;
   }

   public UsersPeg logLoginExiste(String var1, String var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getSysteme();
      Query var4 = var3.createQuery("from UsersPeg where usrlogin =:login and structurePeg.strraisonsociale =:soc").setString("login", var1).setString("soc", var2).setMaxResults(1);
      new ArrayList();
      List var5 = var4.list();
      new UsersPeg();
      UsersPeg var6;
      if (var5.size() != 0) {
         var6 = (UsersPeg)var5.get(0);
      } else {
         var6 = null;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public UsersPeg logLoginExiste(String var1, StructurePeg var2, Session var3) throws HibernateException, NamingException {
      Query var4 = var3.createQuery("from UsersPeg where usrmail=:mail and structurePeg =:strparam").setString("mail", var1).setParameter("strparam", var2).setMaxResults(1);
      new ArrayList();
      List var5 = var4.list();
      new UsersPeg();
      UsersPeg var6;
      if (var5.size() != 0) {
         var6 = (UsersPeg)var5.get(0);
      } else {
         var6 = null;
      }

      return var6;
   }

   public UsersPeg logLoginExiste(String var1, String var2, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getSysteme();
      Query var5 = var4.createQuery("from UsersPeg where usrlogin=:login and usrmail=:mail and structurePeg.strraisonsociale =:soc").setString("login", var1).setString("mail", var2).setString("soc", var3).setMaxResults(1);
      new ArrayList();
      List var6 = var5.list();
      new UsersPeg();
      UsersPeg var7;
      if (var6.size() != 0) {
         var7 = (UsersPeg)var6.get(0);
      } else {
         var7 = null;
      }

      this.utilInitHibernate.closeSession();
      return var7;
   }

   public UsersPeg trouveUserPegExiste(String var1, String var2, long var3) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getSysteme();
      Query var6 = var5.createQuery("from UsersPeg where usrlogin=:login and usrpw=:password and structurePeg.strId =:soc").setString("login", var1).setString("password", var2).setLong("soc", var3).setMaxResults(1);
      new ArrayList();
      List var7 = var6.list();
      new UsersPeg();
      UsersPeg var8;
      if (var7.size() != 0) {
         var8 = (UsersPeg)var7.get(0);
      } else {
         var8 = null;
      }

      this.utilInitHibernate.closeSession();
      return var8;
   }

   public Users verifExistUserCodeGroupe(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      Query var3 = var2.createQuery("from Users u where u.usrCollaboration =:cdgrp");
      var3.setParameter("cdgrp", var1);
      List var4 = var3.list();
      this.utilInitHibernate.closeSession();
      return var4.size() > 0 ? (Users)var4.get(0) : null;
   }

   public Users selectByIdUsers(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Users where usr_id =:id").setLong("id", var1);
      new Users();
      List var7 = var5.list();
      Users var6;
      if (var7.size() != 0) {
         var6 = (Users)var7.get(0);
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Users selectByMailUsers(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Users where usrMail =:log").setString("log", var1);
      new Users();
      List var6 = var4.list();
      Users var5;
      if (var6.size() != 0) {
         var5 = (Users)var6.get(0);
      } else {
         var5 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Users selectByMailUsersActif(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Users where usrMail =:log and usrEtat=1").setString("log", var1);
      new Users();
      List var6 = var4.list();
      Users var5;
      if (var6.size() != 0) {
         var5 = (Users)var6.get(0);
      } else {
         var5 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Users selectUserD(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      List var5 = null;
      if (var1 != 0L) {
         var5 = var3.createQuery("from Users where usr_id=" + var1).list();
      }

      new Users();
      Users var6;
      if (var5 != null && var5.size() > 0) {
         var6 = (Users)var5.get(0);
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery(var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesCaissiers(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=1 and usrCaissier>=1");
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesUsers(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=:et order by usrPatronyme").setInteger("et", 1);
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesUsersByServices(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1 != null && !var1.isEmpty() && !var1.equals("100")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and (usrService=:serv or usrService is null or usrService='' or usrServiceSecondaire=:serv) order by usrPatronyme").setInteger("et", 1).setString("serv", var1);
      } else {
         var4 = var2.createQuery("from Users where usrEtat=:et order by usrPatronyme").setInteger("et", 1);
      }

      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesCommerciaux(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=:et and usrVendeur=1 order by usrPatronyme").setInteger("et", 1);
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMedecins(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=:et and (usrFonction='Sécrétaire Médical' or usrFonction='Biologiste' or usrFonction='Professeur' or usrFonction='Médecin Chef' or usrFonction='Médecin' or usrFonction='Infirmier Chef' or usrFonction='Infirmière Chef' or usrFonction='Infirmier' or usrFonction='Infirmière' or usrFonction='Professeur Vacataire' or usrFonction='Médecin Chef Vacataire' or usrFonction='Médecin Vacataire' or usrFonction='Infirmier Chef Vacataire' or usrFonction='Infirmière Chef Vacataire' or usrFonction='Infirmier Vacataire' or usrFonction='Infirmière Vacataire') order by usrPatronyme").setInteger("et", 1);
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLivreur(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=:et and (usrFonction='Livreur' or usrFonction='Livreuse') order by usrPatronyme").setInteger("et", 1);
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesCommerciauxItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=:et and usrVendeur=1 order by usrPatronyme").setInteger("et", 1);
      List var4 = var3.list();
      ArrayList var5 = new ArrayList();
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Users)var4.get(var6)).getUsrid(), ((Users)var4.get(var6)).getUsrNom() + " " + ((Users)var4.get(var6)).getUsrPrenom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesComptablesItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=:et and usrVendeur=1 order by usrPatronyme").setInteger("et", 1);
      List var4 = var3.list();
      ArrayList var5 = new ArrayList();
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Users)var4.get(var6)).getUsrid(), ((Users)var4.get(var6)).getUsrNom() + " " + ((Users)var4.get(var6)).getUsrPrenom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerTousLesActifsItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=:et order by usrPatronyme").setInteger("et", 1);
      List var4 = var3.list();
      ArrayList var5 = new ArrayList();
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Users)var4.get(var6)).getUsrid(), ((Users)var4.get(var6)).getUsrNom() + " " + ((Users)var4.get(var6)).getUsrPrenom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesSignataires(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = null;
      if (var1.equals("Office")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and usrSignatureOffice=1").setInteger("et", 1);
      } else if (var1.equals("Compta")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and usrSignatureCompta=1").setInteger("et", 1);
      } else if (var1.equals("Paye")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and usrSignaturePaye=1").setInteger("et", 1);
      } else if (var1.equals("Achats")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and usrSignatureAchats=1").setInteger("et", 1);
      } else if (var1.equals("Ventes")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and usrSignatureVentes=1").setInteger("et", 1);
      } else if (var1.equals("Parc")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and usrSignatureParc=1").setInteger("et", 1);
      } else if (var1.equals("Caisse")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and usrSignatureCaisse=1").setInteger("et", 1);
      } else if (var1.equals("Medical")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and usrSignatureMedical=1").setInteger("et", 1);
      } else if (var1.equals("MicroFinance")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and usrSignatureMicroFinance=1").setInteger("et", 1);
      } else if (var1.equals("Education")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and usrSignatureEducation=1").setInteger("et", 1);
      } else if (var1.equals("TOUS")) {
         var4 = var2.createQuery("from Users where usrEtat=:et and (usrSignatureOffice=1 or usrSignatureCompta=1 or usrSignaturePaye=1 or usrSignatureAchats=1 or usrSignatureVentes=1 or usrSignatureParc=1 or usrSignatureCaisse=1 or usrSignatureMedical=1 or usrSignatureMicroFinance=1 or usrSignatureEducation=1)").setInteger("et", 1);
      }

      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesNonSignataires(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=:et and usrSignatureCompta=0 and usrSignaturePaye=0 and usrSignatureAchats=0 and usrSignatureVentes=0 and usrSignatureParc=0 and usrSignatureCaisse=0").setInteger("et", 1);
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesUsersItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=:et order by usrPatronyme").setInteger("et", 1);
      new ArrayList();
      List var4 = var3.list();
      ArrayList var5 = new ArrayList();
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Users)var4.get(var6)).getUsrid(), ((Users)var4.get(var6)).getUsrNom() + " " + ((Users)var4.get(var6)).getUsrPrenom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesDemandeursItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=:et and usrDemandeurAchats=1 order by usrPatronyme").setInteger("et", 1);
      new ArrayList();
      List var4 = var3.list();
      ArrayList var5 = new ArrayList();
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Users)var4.get(var6)).getUsrid(), ((Users)var4.get(var6)).getUsrNom() + " " + ((Users)var4.get(var6)).getUsrPrenom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesUsersIndisponibles(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Users where usrEtat=:et and usrDateDebutIndisponibilite is not null and usrDateFinIndisponibilite is not null and usrDateDebutIndisponibilite<>'' and usrDateFinIndisponibilite<>'' order by usrDateFinIndisponibilite desc").setInteger("et", 1);
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public Users selectLeUserPatronyme(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Users where usrPatronyme='" + var1 + "' order by usrPatronyme desc");
      var4.setMaxResults(1);
      List var5 = var4.list();
      Users var6 = null;
      if (var5.size() > 0) {
         var6 = (Users)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Users selectLeUserId(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Users where usrid='" + var1 + "' order by usrPatronyme desc");
      var5.setMaxResults(1);
      List var6 = var5.list();
      Users var7 = null;
      if (var6.size() > 0) {
         var7 = (Users)var6.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Users selectLeUserIdByAgent(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Users where usrIdSalarieGuest='" + var1 + "' order by usrPatronyme desc");
      var5.setMaxResults(1);
      List var6 = var5.list();
      Users var7 = null;
      if (var6.size() > 0) {
         var7 = (Users)var6.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Users selectLeUserCaissier(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      Query var3 = var2.createQuery("from Users where usrPatronyme='" + var1 + "' and usrCaissier=1 order by usrid desc");
      var3.setMaxResults(1);
      List var4 = var3.list();
      this.utilInitHibernate.closeSession();
      if (var4.size() > 0) {
         Users var5 = (Users)var4.get(0);
         return var5;
      } else {
         return null;
      }
   }

   public Users selectLeUser(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Users where " + var1 + " order by usrid desc");
      var4.setMaxResults(1);
      Users var5 = null;
      List var6 = var4.list();
      if (var6.size() > 0) {
         var5 = (Users)var6.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List verifResponsable(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      String var5 = "";
      String var6 = "";
      if (var2.equals("Office")) {
         var6 = " usrSignatureOffice=1";
      } else if (var2.equals("Compta")) {
         var6 = " usrSignatureCompta=1";
      } else if (var2.equals("Paye")) {
         var6 = " usrSignaturePaye=1";
      } else if (var2.equals("Achats")) {
         var6 = " usrSignatureAchats=1";
      } else if (var2.equals("Ventes")) {
         var6 = " usrSignatureVentes=1";
      } else if (var2.equals("Parc")) {
         var6 = " usrSignatureParc=1";
      } else if (var2.equals("Caisse")) {
         var6 = " usrSignatureCaisse=1";
      } else if (var2.equals("Medical")) {
         var6 = " usrSignatureMedical=1";
      } else if (var2.equals("MicroFinance")) {
         var6 = " usrSignatureMicroFinance=1";
      } else if (var2.equals("Education")) {
         var6 = " usrSignatureEducation=1";
      } else {
         var6 = " usrid>=1";
      }

      if (var1.equals("*")) {
         var5 = "from Users where " + var6 + "order by usrPatronyme";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var7 = var1.substring(1);
         var5 = "from Users where usrPatronyme LIKE '%" + var7 + "%' and " + var6 + " order by usrPatronyme";
      } else {
         var5 = "from Users where usrPatronyme LIKE '" + var1 + "%' and " + var6 + " order by usrPatronyme";
      }

      Query var9 = var3.createQuery(var5);
      List var8 = var9.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List verifCommercial(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      String var4 = "";
      if (var1.equals("*")) {
         var4 = "from Users where usrVendeur=1 order by usrPatronyme";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var5 = var1.substring(1);
         var4 = "from Users where usrPatronyme LIKE '%" + var5 + "%' and usrVendeur=1 order by usrPatronyme";
      } else {
         var4 = "from Users where usrPatronyme LIKE '" + var1 + "%' and usrVendeur=1 order by usrPatronyme";
      }

      Query var7 = var2.createQuery(var4);
      List var6 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerUserActif(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      String var4 = "";
      if (var1.equals("*")) {
         var4 = "from Users order by usrPatronyme";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var5 = var1.substring(1);
         var4 = "from Users where usrPatronyme LIKE '%" + var5 + "%' order by usrPatronyme";
      } else {
         var4 = "from Users where usrPatronyme LIKE '" + var1 + "%' order by usrPatronyme";
      }

      Query var7 = var2.createQuery(var4);
      List var6 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
