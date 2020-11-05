package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsGrp;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitsGrpDao implements Serializable {
   private ProduitsGrp produitsGrp;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsGrpDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsGrp insert(ProduitsGrp var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

   public ProduitsGrp modif(ProduitsGrp var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

   public ProduitsGrp modif(ProduitsGrp var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public String delete(ProduitsGrp var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

      return "";
   }

   public String delete(ProduitsGrp var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
      return "";
   }

   public List selectAllProduitsGrp() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
      List var2 = var1.createQuery("from ProduitsGrp ").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List selectProdGrpByprod(Produits var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsGrp where produits=:produits");
      var4.setParameter("produits", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectProdGrpByCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsGrp where progrpCode=:code");
      var4.setParameter("code", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
