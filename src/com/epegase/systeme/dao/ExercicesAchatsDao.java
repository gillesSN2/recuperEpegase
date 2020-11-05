package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ExercicesAchatsDao implements Serializable {
   private ExercicesAchats exerciceAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ExercicesAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ExercicesAchats insert(ExercicesAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
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

   public ExercicesAchats insert(ExercicesAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ExercicesAchats modif(ExercicesAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "");
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

   public ExercicesAchats modif(ExercicesAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public List selectExercicesAchats(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from ExercicesAchats").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public ExercicesAchats recupererLastExo(Session var1) throws NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      new ArrayList();
      new ExercicesAchats();
      Query var5 = var1.createQuery("from ExercicesAchats order by exeachId desc");
      var5.setMaxResults(1);
      List var3 = var5.list();
      ExercicesAchats var4;
      if (var3.size() > 0) {
         var4 = (ExercicesAchats)var3.get(0);
      } else {
         var4 = new ExercicesAchats();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ExercicesAchats recupererLExoSelect(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      new ArrayList();
      new ExercicesAchats();
      List var5;
      ExercicesAchats var6;
      Query var7;
      if (var1 != 0L) {
         var7 = var3.createQuery("from ExercicesAchats where exeachId=:exo").setLong("exo", var1).setMaxResults(1);
         var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ExercicesAchats)var5.get(0);
         } else {
            var6 = new ExercicesAchats();
         }
      } else {
         var7 = var3.createQuery("from ExercicesAchats order by exeachId desc").setMaxResults(1);
         var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ExercicesAchats)var5.get(0);
         } else {
            var6 = new ExercicesAchats();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
