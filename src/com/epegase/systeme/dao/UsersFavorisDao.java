package com.epegase.systeme.dao;

import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersFavoris;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsersFavorisDao implements Serializable {
   private UsersFavoris usersFavoris;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public UsersFavorisDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public UsersFavoris insert(UsersFavoris var1) throws HibernateException, NamingException {
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

   public UsersFavoris insert(UsersFavoris var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public UsersFavoris modif(UsersFavoris var1) throws HibernateException, NamingException {
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

   public void delete(UsersFavoris var1) throws HibernateException, NamingException {
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

   public void delete(UsersFavoris var1, Session var2) {
      var2.delete(var1);
   }

   public List selectUsersFlux(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersFavoris where usrfavNature=0 and users=:usr").setParameter("usr", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerUsersFavoris(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersFavoris where users=:usr").setParameter("usr", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectUsersSites(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersFavoris where usrfavNature=1 and users=:usr").setParameter("usr", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerUsersFlux(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersFavoris where usrfavInactif=0 and usrfavNature=0 and users=:usr").setParameter("usr", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerUsersSites(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersFavoris where usrfavInactif=0 and usrfavNature=1 and users=:usr").setParameter("usr", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectUsersProcess(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersFavoris where usrfavNature=4 and users=:usr").setParameter("usr", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectUsersProcess(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersFavoris where usrfavNature=4 and usrfavLogin=:proc").setString("proc", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerUsersDepot(Users var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersFavoris where usrfavInactif=0 and usrfavNature=5 and users=:usr").setParameter("usr", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerStructuresAutorises(StructurePeg var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from UsersFavoris where usrfavInactif=0 and usrfavNature=2 and usrfavStructurePeg=:id").setLong("id", var1.getStrId());
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
