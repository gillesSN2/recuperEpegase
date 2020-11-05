package com.epegase.systeme.dao;

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

public class SiteDao implements Serializable {
   private Site site;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SiteDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Site insert(Site var1) throws HibernateException, NamingException {
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

   public Site insert(Site var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Site modif(Site var1) throws HibernateException, NamingException {
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

   public void delete(Site var1) throws HibernateException, NamingException {
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

   public List selectSite(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var2 = true;
      }

      List var3 = var1.createQuery(" from Site where sitIdClient = 0 order by sitCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesSitesList(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from Site where sitInactif=0 order by sitCode");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesSitesListByClient(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from Site where sitIdClient=:id and sitInactif=0 order by sitCode").setLong("id", var1);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesSitesListByClient(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from Site where sitIdClient in " + var1 + " and sitInactif=0 order by sitCode");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesSitesItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var2 = true;
      }

      List var3 = var1.createQuery("from Site where sitInactif=0 order by sitCode").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((Site)var4.get(var6)).getSitCode() + ":" + ((Site)var4.get(var6)).getSitNomFr()));
         }
      }

      return var5;
   }

   public Site rechercheSite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from Site where sitCode=:cod and sitInactif=0").setString("cod", var1).setMaxResults(1).list();
      this.site = new Site();
      if (var4.size() > 0) {
         this.site = (Site)var4.get(0);
      } else {
         this.site = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.site;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Site where sitCode=:cod").setString("cod", var1).setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() != 0) {
         var4 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesSitesItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from Site where sitInactif=0 order by sitCode ASC").list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var1 == 0) {
         var6.add(new SelectItem("100", "Tous Sites"));
      }

      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((Site)var5.get(var7)).getSitCode() + ":" + ((Site)var5.get(var7)).getSitNomFr()));
         }
      }

      return var6;
   }
}
