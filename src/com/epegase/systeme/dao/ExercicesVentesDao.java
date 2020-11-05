package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ExercicesVentesDao implements Serializable {
   private ExercicesVentes exerciceVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ExercicesVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ExercicesVentes insert(ExercicesVentes var1) throws HibernateException, NamingException {
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

   public ExercicesVentes insert(ExercicesVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ExercicesVentes modif(ExercicesVentes var1) throws HibernateException, NamingException {
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

   public ExercicesVentes modif(ExercicesVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public List selectExercicesVentes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from ExercicesVentes").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public ExercicesVentes recupererLastExo(Session var1) throws NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      new ArrayList();
      new ExercicesVentes();
      Query var5 = var1.createQuery("from ExercicesVentes order by exevteId desc");
      var5.setMaxResults(1);
      List var3 = var5.list();
      ExercicesVentes var4;
      if (var3.size() > 0) {
         var4 = (ExercicesVentes)var3.get(0);
      } else {
         var4 = new ExercicesVentes();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ExercicesVentes recupererLExoSelect(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      new ArrayList();
      new ExercicesVentes();
      List var5;
      ExercicesVentes var6;
      Query var7;
      if (var1 != 0L) {
         var7 = var3.createQuery("from ExercicesVentes where exevteId=:exo").setLong("exo", var1).setMaxResults(1);
         var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ExercicesVentes)var5.get(0);
         } else {
            var6 = new ExercicesVentes();
         }
      } else {
         var7 = var3.createQuery("from ExercicesVentes order by exevteId desc").setMaxResults(1);
         var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ExercicesVentes)var5.get(0);
         } else {
            var6 = new ExercicesVentes();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
