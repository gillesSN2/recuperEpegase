package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ProduitsFrais;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitsFraisDao implements Serializable {
   private String mabase;
   private ProduitsFrais produitsFrais;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsFraisDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsFrais insert(ProduitsFrais var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsAchs");
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

   public ProduitsFrais insert(ProduitsFrais var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ProduitsFrais modif(ProduitsFrais var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsAchs");
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

   public ProduitsFrais modif(ProduitsFrais var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(ProduitsFrais var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsAchs");
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

   public void delete(ProduitsFrais var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargeDetailSimulationPrd(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsAchs");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ProduitsFrais where profrsIdPro=:prod and profrsType=0 order by profrsOrdre").setLong("prod", var1);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargeDetailSimulationCot(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsAchs");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ProduitsFrais where profrsIdCot=:cot and profrsType=1 order by profrsOrdre").setLong("cot", var1);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargeDetailSimulationCotTiers(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsAchs");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ProduitsFrais where profrsIdCot=:cot and profrsType=3 order by profrsOrdre").setLong("cot", var1);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargeDetailSimulationCmd(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsAchs");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ProduitsFrais where profrsIdCmd=:cmd and profrsType=2 order by profrsOrdre").setLong("cmd", var1);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public String rechercheDernier(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsAchs");
         var2 = true;
      }

      String var3 = "";
      new ArrayList();
      Query var5 = var1.createQuery("from ProduitsFrais order by profrsId desc").setMaxResults(1);
      List var4 = var5.list();
      if (var4.size() != 0) {
         var3 = "" + (((ProduitsFrais)var4.get(0)).getProfrsId() + 1L);
      } else {
         var3 = "1";
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public ProduitsFrais recherParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsAchs");
         var4 = true;
      }

      String var5 = "";
      new ArrayList();
      Query var7 = var3.createQuery("from ProduitsFrais where profrsId=:id").setLong("id", var1).setMaxResults(1);
      List var6 = var7.list();
      this.produitsFrais = new ProduitsFrais();
      if (var6.size() != 0) {
         this.produitsFrais = (ProduitsFrais)var6.get(0);
      } else {
         this.produitsFrais = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.produitsFrais;
   }
}
