package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ExercicesCaisseDao implements Serializable {
   private ExercicesCaisse exerciceCaisse;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ExercicesCaisseDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ExercicesCaisse insert(ExercicesCaisse var1) throws HibernateException, NamingException {
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

   public ExercicesCaisse insert(ExercicesCaisse var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ExercicesCaisse modif(ExercicesCaisse var1) throws HibernateException, NamingException {
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

   public ExercicesCaisse modif(ExercicesCaisse var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public List selectExercicesCaisse(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from ExercicesCaisse").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public ExercicesCaisse recupererLastExo(Session var1) throws NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      new ArrayList();
      new ExercicesCaisse();
      Query var5 = var1.createQuery("from ExercicesCaisse order by execaiId desc");
      var5.setMaxResults(1);
      List var3 = var5.list();
      ExercicesCaisse var4;
      if (var3.size() > 0) {
         var4 = (ExercicesCaisse)var3.get(0);
      } else {
         var4 = new ExercicesCaisse();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ExercicesCaisse recupererLExoSelect(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      new ArrayList();
      new ExercicesCaisse();
      List var5;
      ExercicesCaisse var6;
      Query var7;
      if (var1 != 0L) {
         var7 = var3.createQuery("from ExercicesCaisse where execaiId=:exo").setLong("exo", var1).setMaxResults(1);
         var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ExercicesCaisse)var5.get(0);
         } else {
            var6 = new ExercicesCaisse();
         }
      } else {
         var7 = var3.createQuery("from ExercicesCaisse order by execaiId desc").setMaxResults(1);
         var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ExercicesCaisse)var5.get(0);
         } else {
            var6 = new ExercicesCaisse();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
