package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class ExercicesParcsDao implements Serializable {
   private ExercicesParc exerciceParc;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ExercicesParcsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ExercicesParc insert(ExercicesParc var1) {
      return var1;
   }

   public ExercicesParc insert(ExercicesParc var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ExercicesParc modifierExercicesParcs(ExercicesParc var1) {
      return var1;
   }

   public ExercicesParc modifierExercicesParcs(ExercicesParc var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public List selectExercicesParcs(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from ExercicesParc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public ExercicesParc recupererLastExo(Session var1) throws NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var2 = true;
      }

      new ArrayList();
      new ExercicesParc();
      Query var5 = var1.createQuery("from ExercicesParc order by exeprcId desc");
      var5.setMaxResults(1);
      List var3 = var5.list();
      ExercicesParc var4;
      if (var3.size() > 0) {
         var4 = (ExercicesParc)var3.get(0);
      } else {
         var4 = new ExercicesParc();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ExercicesParc recupererLExoSelect(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "");
         var4 = true;
      }

      new ArrayList();
      new ExercicesParc();
      List var5;
      ExercicesParc var6;
      Query var7;
      if (var1 != 0L) {
         var7 = var3.createQuery("from ExercicesParc where exeprcId=:exo").setLong("exo", var1).setMaxResults(1);
         var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ExercicesParc)var5.get(0);
         } else {
            var6 = new ExercicesParc();
         }
      } else {
         var7 = var3.createQuery("from ExercicesParc order by exeprcId desc").setMaxResults(1);
         var5 = var7.list();
         if (var5.size() != 0) {
            var6 = (ExercicesParc)var5.get(0);
         } else {
            var6 = new ExercicesParc();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
