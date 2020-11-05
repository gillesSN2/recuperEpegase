package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ExercicesPayeDao implements Serializable {
   private ExercicesPaye exercicesPaye;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ExercicesPayeDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ExercicesPaye insert(ExercicesPaye var1) throws HibernateException, NamingException {
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

   public ExercicesPaye insert(ExercicesPaye var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ExercicesPaye modif(ExercicesPaye var1) throws HibernateException, NamingException {
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

   public ExercicesPaye modif(ExercicesPaye var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public List selectExercicesPaye(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from ExercicesPaye").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public ExercicesPaye recupererLastExo(Session var1) throws NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      new ArrayList();
      new ExercicesPaye();
      Query var5 = var1.createQuery("from ExercicesPaye order by exepayId desc");
      var5.setMaxResults(1);
      List var3 = var5.list();
      ExercicesPaye var4;
      if (var3.size() > 0) {
         var4 = (ExercicesPaye)var3.get(0);
      } else {
         var4 = new ExercicesPaye();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ExercicesPaye recupererLExoSelect(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      new ArrayList();
      new ExercicesPaye();
      List var5;
      ExercicesPaye var6;
      Query var7;
      if (var1 != 0L) {
         var7 = var3.createQuery("from ExercicesPaye where exepayId=:exo").setLong("exo", var1).setMaxResults(1);
         var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ExercicesPaye)var5.get(0);
         } else {
            var6 = new ExercicesPaye();
         }
      } else {
         var7 = var3.createQuery("from ExercicesPaye order by exepayId desc").setMaxResults(1);
         var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ExercicesPaye)var5.get(0);
         } else {
            var6 = new ExercicesPaye();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
