package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Region;
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

public class RegionDao implements Serializable {
   private Region region;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public RegionDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Region insert(Region var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
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

   public Region insert(Region var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Region modif(Region var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
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

   public void delete(Region var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
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

   public List selectRegion(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      List var3 = var1.createQuery(" from Region order by regCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesRegionList(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from Region where regInactif=0 order by regCode");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesRegionItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      List var3 = var1.createQuery("from Region where regInactif=0 order by regCode").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Region)var4.get(var6)).getRegCode() + ":" + ((Region)var4.get(var6)).getRegNomFr()));
         }
      }

      return var5;
   }

   public Region rechercheRegion(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      List var4 = var2.createQuery("from Region where regCode=:cod and regInactif=0").setString("cod", var1).setMaxResults(1).list();
      this.region = new Region();
      if (var4.size() > 0) {
         this.region = (Region)var4.get(0);
      } else {
         this.region = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.region;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Region where regCode=:cod").setString("cod", var1).setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() != 0) {
         var4 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
