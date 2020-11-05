package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsMcles;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitsMclesDao implements Serializable {
   private ProduitsMcles produitsMcles;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsMclesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsMcles insert(ProduitsMcles var1) throws HibernateException, NamingException {
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

   public ProduitsMcles modif(ProduitsMcles var1) throws HibernateException, NamingException {
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

   public ProduitsMcles delete(ProduitsMcles var1) throws HibernateException, NamingException {
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

      return var1;
   }

   public void delete(ProduitsMcles var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectProdMotClefByprod(Produits var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsMcles where pro_id=:id");
      var4.setParameter("id", var1.getProId());
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesProduitsMcles() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
      List var2 = var1.createQuery("from ProduitsMcles").list();
      if (var2 != null) {
         this.utilInitHibernate.closeSession();
         return var2;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List verifProduits(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var4 = true;
      }

      String var5 = var1.substring(1);
      String var6 = "";
      if (var2 != null && !var2.isEmpty() && !var2.equals("9")) {
         if (var2.equals("0")) {
            var6 = " and produits.proMode=0";
         } else if (var2.equals("1")) {
            var6 = " and produits.proMode=1";
         } else if (var2.equals("2")) {
            var6 = " and produits.proMode=2";
         } else if (var2.equals("3")) {
            var6 = " and produits.proMode=3";
         } else if (var2.equals("4")) {
            var6 = " and produits.proMode=4";
         } else if (var2.equals("5")) {
            var6 = " and produits.proMode=5";
         }
      }

      Query var7 = var3.createQuery("from ProduitsMcles where promclMot LIKE '%" + var5 + var6 + "' order by promclMot desc");
      List var8 = var7.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List verifProduitsActes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      String var4 = var1.substring(1);
      Query var5 = var2.createQuery("from ProduitsMcles where promclMot LIKE '%" + var4 + "' and proVteNat = '1104' order by promclMot desc");
      List var6 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesProduitsMcles(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsMcles where promclMot LIKE '" + var1 + "%' order by promclMot desc");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List verifProduitsMedicamment(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      String var4 = var1.substring(1);
      Query var5 = var2.createQuery("from ProduitsMcles where promclMot LIKE '%" + var4 + "' and proVteNat = '1105' order by promclMot desc");
      List var6 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List verifProduitsLaboratoire(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsVtes");
         var3 = true;
      }

      String var4 = var1.substring(1);
      Query var5 = var2.createQuery("from ProduitsMcles where promclMot LIKE '%" + var4 + "' and proVteNat = '1106' order by promclMot desc");
      List var6 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
