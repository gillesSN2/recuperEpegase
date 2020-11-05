package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersObjectifs;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsersObjectifsDao implements Serializable {
   private UsersObjectifs usersObjectifs;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public UsersObjectifsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public UsersObjectifs insert(UsersObjectifs var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Objectifs");
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

   public UsersObjectifs insert(UsersObjectifs var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public UsersObjectifs maj(UsersObjectifs var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public UsersObjectifs modif(UsersObjectifs var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Objectifs");
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

   public UsersObjectifs modif(UsersObjectifs var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(UsersObjectifs var1) throws HibernateException, NamingException {
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

   public void delete(UsersObjectifs var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerUsersObjectifs(Users var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Objectifs");
         var4 = true;
      }

      Query var5 = var3.createQuery("from UsersObjectifs where users=:usr and usrobjAnnee=:an").setParameter("usr", var1).setString("an", var2);
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public UsersObjectifs chargerUsersObjectifs(Users var1, String var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Objectifs");
         var5 = true;
      }

      Query var6 = var4.createQuery("from UsersObjectifs where users=:usr and usrobjAnnee=:an and usrobjNature=:nat").setParameter("usr", var1).setString("an", var2).setInteger("nat", var3).setMaxResults(1);
      new ArrayList();
      this.usersObjectifs = null;
      List var7 = var6.list();
      if (var7.size() != 0) {
         this.usersObjectifs = (UsersObjectifs)var7.get(0);
      } else {
         this.usersObjectifs = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.usersObjectifs;
   }
}
