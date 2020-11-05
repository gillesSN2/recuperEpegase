package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitsFournisseurDao implements Serializable {
   private ProduitsFournisseur produitsFournisseur;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsFournisseurDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsFournisseur insert(ProduitsFournisseur var1) throws HibernateException, NamingException {
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

   public ProduitsFournisseur insert(ProduitsFournisseur var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ProduitsFournisseur modif(ProduitsFournisseur var1) throws HibernateException, NamingException {
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

   public ProduitsFournisseur modif(ProduitsFournisseur var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(ProduitsFournisseur var1) throws HibernateException, NamingException {
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

   public void delete(ProduitsFournisseur var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectAllProduitsFour() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
      List var2 = var1.createQuery("from ProduitsFournisseur ").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List selectAllProduitsFour(String var1, Session var2) throws HibernateException, NamingException {
      List var3 = null;
      if (var1 != null && !var1.isEmpty()) {
         var3 = var2.createQuery("from ProduitsFournisseur where profouRef like '" + var1 + "%'").list();
      } else {
         var3 = var2.createQuery("from ProduitsFournisseur").list();
      }

      return var3;
   }

   public List selectProdFourByprod(Produits var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsFournisseur where produits=:produits").setParameter("produits", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public String selectProdReference(Produits var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsFournisseur where produits=:produits").setParameter("produits", var1);
      String var5 = null;
      List var6 = var4.list();
      if (var6.size() != 0) {
         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.produitsFournisseur = new ProduitsFournisseur();
            if (this.produitsFournisseur.getProfouRef() != null && !this.produitsFournisseur.getProfouRef().isEmpty()) {
               var5 = this.produitsFournisseur.getProfouRef();
               break;
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ProduitsFournisseur selectProdPa(Produits var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsFournisseur where produits=:produits").setParameter("produits", var1);
      List var5 = var4.list();
      if (var5.size() != 0) {
         for(int var6 = 0; var6 < var5.size(); ++var6) {
            this.produitsFournisseur = (ProduitsFournisseur)var5.get(var6);
            if (this.produitsFournisseur.getProfouPa() != 0.0D) {
               break;
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.produitsFournisseur;
   }

   public List selectProdFourByprod(Produits var1, Tiers var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ProduitsFournisseur where produits=:produits and tiers=:tiers").setParameter("produits", var1).setParameter("tiers", var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ProduitsFournisseur selectProdFourByprodFic(Produits var1, Tiers var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ProduitsFournisseur where produits=:produits and tiers=:tiers").setParameter("produits", var1).setParameter("tiers", var2).setMaxResults(1);
      new ProduitsFournisseur();
      List var7 = var5.list();
      ProduitsFournisseur var6;
      if (var7.size() > 0) {
         var6 = (ProduitsFournisseur)var7.get(0);
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectProdCatalogue(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsFournisseur where tiers=:tiers").setParameter("tiers", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public boolean verifTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProduitsFournisseur where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
