package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ProductionAtelier;
import com.epegase.systeme.classe.ProductionLigne;
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

public class ProductionAtelierDao implements Serializable {
   private ProductionAtelier ProductionAtelier;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ProductionAtelierDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ProductionAtelier insert(ProductionAtelier var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
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

   public ProductionAtelier insert(ProductionAtelier var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ProductionAtelier modif(ProductionAtelier var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
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

   public void delete(ProductionAtelier var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
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

   public String deletSerByDep(ProductionLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from ProductionAtelier where productionLigne.ligId =:de");
      var4.setParameter("de", var1.getLigId());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public List selectProductionAtelier(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var2 = true;
      }

      List var3 = var1.createQuery(" from ProductionAtelier order by ateCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectProductionAtelierByExcludeIds(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery(" from ProductionAtelier where ateId not in " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesProductionAtelier(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var2 = true;
      }

      List var3 = var1.createQuery("from ProductionAtelier where ateInactif=0 order by ateCode ASC").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesProductionAtelierItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from ProductionAtelier where ateInactif=0 order by ateCode ASC").list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var1 == 0) {
         var6.add(new SelectItem("100", "Tous Ateliers"));
      }

      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((ProductionAtelier)var5.get(var7)).getAteCode() + ":" + ((ProductionAtelier)var5.get(var7)).getAteNomFr()));
         }
      }

      return var6;
   }

   public ProductionAtelier rechercheProductionAtelier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from ProductionAtelier where ateCode=:cod order by ateCode").setString("cod", var1).list();
      ProductionAtelier var6 = new ProductionAtelier();
      if (var4.size() > 0) {
         var6 = (ProductionAtelier)var4.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List logProductionAtelier(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
      List var4 = var3.createQuery("from ProductionAtelier where productionLigne.ligId = " + var1).list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List logProductionAtelier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from ProductionAtelier where productionLigne.ligCode = '" + var1 + "' order by ateCode").list();
      ArrayList var5 = new ArrayList();
      if (var4.size() != 0) {
         this.ProductionAtelier = new ProductionAtelier();

         for(int var6 = 0; var6 < var4.size(); ++var6) {
            this.ProductionAtelier = (ProductionAtelier)var4.get(var6);
            var5.add(new SelectItem(this.ProductionAtelier.getAteCode() + ":" + this.ProductionAtelier.getAteNomFr()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listProductionAtelierByLigne(ProductionLigne var1, Session var2) {
      Object var3 = new ArrayList();
      if (var1 != null) {
         Query var4 = var2.createQuery("from ProductionAtelier where  ateInactif=0 and productionLigne=:lig order by ateCode");
         var4.setParameter("lig", var1);
         var3 = var4.list();
      }

      return (List)var3;
   }

   public List listProductionAtelierByLigne(String var1, Session var2) {
      Object var3 = new ArrayList();
      if (var1 != null) {
         Query var4 = var2.createQuery("from ProductionAtelier where productionLigne.ligCode=:lig order by ateCode");
         var4.setParameter("lig", var1);
         var3 = var4.list();
      }

      return (List)var3;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from ProductionAtelier where ateCode=:cod").setString("cod", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List existCodeList(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProductionAtelier where ateCode=:cod").setString("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ProductionAtelier chargerLeProductionAtelierCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ProductionAtelier where ateCode=:code order by ateCode").setParameter("code", var1);
      var4.setMaxResults(1);
      new ArrayList();
      List var5 = var4.list();
      ProductionAtelier var6 = null;
      if (var5.size() != 0) {
         var6 = (ProductionAtelier)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesProductionAtelier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      if (var1.equals("*")) {
         var5 = "from ProductionAtelier where ateInactif=0 order by ateCode asc";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var6 = var1.substring(1);
         var5 = "from ProductionAtelier where ateInactif=0 and (ateCode LIKE '%" + var6 + "%) or (ateNomFr LIKE '%" + var6 + "%) order by ateCode asc";
      } else {
         var5 = "from ProductionAtelier where ateInactif=0 and (ateCode LIKE '" + var1 + "%) or (ateNomFr LIKE '%" + var1 + "%)' order by ateCode asc";
      }

      Query var7 = var2.createQuery(var5);
      List var4 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
