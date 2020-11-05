package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PlanAnalytiqueRepartition;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanAnalytiqueRepartitionDao implements Serializable {
   private PlanAnalytiqueRepartition planAnalytiqueRepartition;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public PlanAnalytiqueRepartitionDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public PlanAnalytiqueRepartition insert(PlanAnalytiqueRepartition var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansAnalytiques");
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

   public PlanAnalytiqueRepartition insert(PlanAnalytiqueRepartition var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public PlanAnalytiqueRepartition modif(PlanAnalytiqueRepartition var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void deletelesRepartitions(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansAnalytiques");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            new PlanAnalytiqueRepartition();
            PlanAnalytiqueRepartition var5 = (PlanAnalytiqueRepartition)var1.get(var4);
            var2.delete(var5);
         }

         var3.commit();
      } catch (HibernateException var9) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public void deletelesRepartitions(PlansAnalytiques var1, Session var2) {
      var2.createQuery("delete from PlanAnalytiqueRepartition where PlansAnalytiques=:id").setLong("id", var1.getAnaId()).executeUpdate();
   }

   public void delete(PlanAnalytiqueRepartition var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansAnalytiques");
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

   public void delete(PlanAnalytiqueRepartition var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerLesRepartitions(PlansAnalytiques var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansAnalytiques");
         var3 = true;
      }

      Query var4 = var2.createQuery("FROM PlanAnalytiqueRepartition WHERE PlansAnalytiques=:ana order by cleOrdre asc").setParameter("ana", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesRepartitions(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansAnalytiques");
         var3 = true;
      }

      Query var4 = var2.createQuery("FROM PlanAnalytiqueRepartition WHERE PlansAnalytiques.anaCode=:cod order by cleOrdre asc").setString("cod", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
