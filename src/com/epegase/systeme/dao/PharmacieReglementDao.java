package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieReglement;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PharmacieReglementDao implements Serializable {
   private PharmacieReglement pharmacieReglement;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public PharmacieReglementDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public PharmacieReglement insert(PharmacieReglement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
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

   public PharmacieReglement insert(PharmacieReglement var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public PharmacieReglement modif(PharmacieReglement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
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

   public PharmacieReglement modif(PharmacieReglement var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(PharmacieReglement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
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

   public void delete(PharmacieReglement var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteAllLigne(PharmacieEntete var1, Session var2) {
      var2.createQuery("delete from PharmacieReglement where pharmacieEntete=:id").setParameter("id", var1).executeUpdate();
   }

   public List selectReglementByEnt(PharmacieEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From PharmacieReglement where PharmacieEntete=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectReglementByBonEncaissement(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From PharmacieReglement where pharegIdBonEncaissement=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectReglementByRecu(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From PharmacieReglement where pharegNumRecu=:num").setString("num", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectReglementByRecu(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From PharmacieReglement where pharmacieEntete.phaId=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectReglementByIdRecu(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From PharmacieReglement where pharegIdRecu=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public PharmacieReglement selectReglement(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PharmacieEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From PharmacieReglement where pharegId=:param").setLong("param", var1).setMaxResults(1).list();
      this.pharmacieReglement = new PharmacieReglement();
      if (var5.size() != 0) {
         this.pharmacieReglement = (PharmacieReglement)var5.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.pharmacieReglement;
   }
}
