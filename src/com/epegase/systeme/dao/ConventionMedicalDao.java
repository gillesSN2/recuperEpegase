package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ConventionMedical;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConventionMedicalDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ConventionMedicalDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ConventionMedical insert(ConventionMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Tiers");
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

   public ConventionMedical modif(ConventionMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Tiers");
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

   public void delete(ConventionMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Tiers");
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

   public List chargeConvention(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Tiers");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ConventionMedical where tiers=:trs order by cvnLettre").setParameter("trs", var1);
      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List chargeConvention(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Tiers");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ConventionMedical where cvnProduit=:prd order by cvnLettre").setString("prd", var1);
      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public ConventionMedical trouveConvention(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Tiers");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ConventionMedical where tie_id=:trs").setLong("trs", var1).setMaxResults(1);
      new ArrayList();
      new ConventionMedical();
      ConventionMedical var7;
      if (var5.list() != null) {
         List var6 = var5.list();
         if (var6.size() != 0) {
            var7 = (ConventionMedical)var6.get(0);
         } else {
            var7 = null;
         }
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ConventionMedical trouveConvention(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Tiers");
         var5 = true;
      }

      Query var6 = var4.createQuery("from ConventionMedical where tie_id=:trs and cvnProduit=:prd").setLong("trs", var1).setString("prd", var3).setMaxResults(1);
      new ArrayList();
      new ConventionMedical();
      ConventionMedical var8;
      if (var6.list() != null) {
         List var7 = var6.list();
         if (var7.size() != 0) {
            var8 = (ConventionMedical)var7.get(0);
         } else {
            var8 = null;
         }
      } else {
         var8 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }
}
