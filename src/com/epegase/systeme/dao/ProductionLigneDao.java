package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ProductionLigne;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductionLigneDao implements Serializable {
   private ProductionLigne productionLigne;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProductionLigneDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ProductionLigne insert(ProductionLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
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

   public ProductionLigne insert(ProductionLigne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ProductionLigne modif(ProductionLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
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

   public void delete(ProductionLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
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

   public List selectProductionLigne(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var2 = true;
      }

      List var3 = var1.createQuery(" from ProductionLigne where order by ligCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public ProductionLigne rechercheProductionLigne(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from ProductionLigne where ligCode=:cod order by ligCode").setString("cod", var1).setMaxResults(1).list();
      this.productionLigne = new ProductionLigne();
      if (var4.size() > 0) {
         this.productionLigne = (ProductionLigne)var4.get(0);
      } else {
         this.productionLigne = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.productionLigne;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from ProductionLigne where ligCode=:cod").setString("cod", var1).setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List logProductionLigne(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
      List var4 = var3.createQuery("from ProductionLigne where site.sitId = '" + var1 + "' order by ligCode").list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List logProductionLigne(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from ProductionLigne where site.sitCode = '" + var1 + "' order by ligCode").list();
      ArrayList var5 = new ArrayList();
      if (var4.size() != 0) {
         this.productionLigne = new ProductionLigne();

         for(int var6 = 0; var6 < var4.size(); ++var6) {
            this.productionLigne = (ProductionLigne)var4.get(var6);
            var5.add(new SelectItem(this.productionLigne.getLigCode() + ":" + this.productionLigne.getLigNomFr()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ProductionLigne chargerLesProductionLignesByCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from ProductionLigne where ligCode=:cod order by ligCode").setString("cod", var1).list();
      this.productionLigne = new ProductionLigne();
      if (var4.size() > 0) {
         this.productionLigne = (ProductionLigne)var4.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.productionLigne;
   }

   public List listProductionLigneBySit(Site var1, Session var2) throws HibernateException, NamingException {
      Object var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
            var4 = true;
         }

         Query var5 = var2.createQuery("from ProductionLigne where site=:site order by ligCode");
         var5.setParameter("site", var1);
         var3 = var5.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var3;
   }

   public List listProductionLigneBySit(String var1, Session var2) throws HibernateException, NamingException {
      Object var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
            var4 = true;
         }

         Query var5 = var2.createQuery("from ProductionLigne where site.sitCode=:site order by ligCode");
         var5.setParameter("site", var1);
         var3 = var5.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var3;
   }

   public List listProductionLigneBySitCle(Site var1, Session var2) {
      Object var3 = new ArrayList();
      if (var1 != null) {
         Query var4 = var2.createQuery("from ProductionLigne where ligInactif =0 and site=:site order by ligCode");
         var4.setParameter("site", var1);
         var3 = var4.list();
      }

      return (List)var3;
   }

   public String deletProductionLigneBySite(Site var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from ProductionLigne where site.sitId =:se");
      var4.setParameter("se", var1.getSitId());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public boolean existCodeBySite(String var1, Site var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
      Query var5 = var4.createQuery("from ProductionLigne where site.sitId =:se and ligCode=:cod").setString("cod", var1);
      var5.setParameter("se", var2.getSitId());
      var5.setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.utilInitHibernate.closeSession();
      return var3;
   }
}
