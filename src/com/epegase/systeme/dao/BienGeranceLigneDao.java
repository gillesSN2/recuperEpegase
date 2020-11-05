package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienGeranceEntete;
import com.epegase.systeme.classe.BienGeranceLigne;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BienGeranceLigneDao implements Serializable {
   private BienGeranceLigne bienGeranceLigne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BienGeranceLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BienGeranceLigne insert(BienGeranceLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public BienGeranceLigne insert(BienGeranceLigne var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public BienGeranceLigne maj(BienGeranceLigne var1, Session var2) throws HibernateException, NamingException {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public BienGeranceLigne modif(BienGeranceLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public BienGeranceLigne modif(BienGeranceLigne var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(BienGeranceLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public void delete(BienGeranceLigne var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerDetail(BienGeranceEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      List var4 = var2.createQuery("from BienGeranceLigne where BienGeranceEntete=:idfk").setParameter("idfk", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public BienGeranceLigne chargerDetail(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      List var4 = var2.createQuery("from BienGeranceLigne where Bien.bieNum='" + var1 + "' order by biegerligId").setMaxResults(1).list();
      this.bienGeranceLigne = new BienGeranceLigne();
      if (var4.size() != 0) {
         this.bienGeranceLigne = (BienGeranceLigne)var4.get(0);
      } else {
         this.bienGeranceLigne = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.bienGeranceLigne;
   }

   public List chargerDetail(Bien var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      List var4 = var2.createQuery("from BienGeranceLigne where Bien=:bi order by biegerligId").setParameter("bi", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public BienGeranceLigne pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienGeranceLigne where biegerligId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new BienGeranceLigne();
      BienGeranceLigne var7;
      if (var6.size() != 0) {
         var7 = (BienGeranceLigne)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
