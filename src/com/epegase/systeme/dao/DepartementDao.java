package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Departement;
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

public class DepartementDao implements Serializable {
   private Departement departement;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public DepartementDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Departement insert(Departement var1) throws HibernateException, NamingException {
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

   public Departement insert(Departement var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Departement modif(Departement var1) throws HibernateException, NamingException {
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

   public void delete(Departement var1) throws HibernateException, NamingException {
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

   public List selectDepartement(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var2 = true;
      }

      List var3 = var1.createQuery(" from Departement where order by depCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public Departement rechercheDepartement(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from Departement where depCode=:cod order by depCode").setString("cod", var1).setMaxResults(1).list();
      this.departement = new Departement();
      if (var4.size() > 0) {
         this.departement = (Departement)var4.get(0);
      } else {
         this.departement = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.departement;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Departement where depCode=:cod").setString("cod", var1).setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List logDepartement(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
      List var4 = var3.createQuery("from Departement where sit_id = '" + var1 + "' order by depCode").list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public Departement chargerLesDepartementsByCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from Departement where depCode=:cod order by depCode").setString("cod", var1).list();
      Departement var6 = new Departement();
      if (var4.size() > 0) {
         var6 = (Departement)var4.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List listDepartementBySit(Site var1, Session var2) throws HibernateException, NamingException {
      Object var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
            var4 = true;
         }

         Query var5 = var2.createQuery("from Departement where site=:site order by depCode");
         var5.setParameter("site", var1);
         var3 = var5.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var3;
   }

   public List listDepartementBySite(Site var1, Session var2) throws HibernateException, NamingException {
      ArrayList var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
            var4 = true;
         }

         List var5 = var2.createQuery("from Departement where site=:site order by depCode").setParameter("site", var1).list();
         List var6 = var5;
         if (var5.size() != 0) {
            for(int var7 = 0; var7 < var6.size(); ++var7) {
               var3.add(new SelectItem(((Departement)var6.get(var7)).getDepCode() + ":" + ((Departement)var6.get(var7)).getDepNomFr()));
            }
         }

         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return var3;
   }

   public List listDepartementBySit(String var1, Session var2) throws HibernateException, NamingException {
      Object var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
            var4 = true;
         }

         Query var5 = var2.createQuery("from Departement where site.sitCode=:site order by depCode").setString("site", var1);
         var3 = var5.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var3;
   }

   public List listDepartementBySitCle(Site var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      Object var4 = new ArrayList();
      if (var1 != null) {
         Query var5 = var2.createQuery("from Departement where depInactif =0 and site=:site order by depCode");
         var5.setParameter("site", var1);
         var4 = var5.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public String deletDepBySite(Site var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from Departement where site.sitId =:se");
      var4.setParameter("se", var1.getSitId());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public boolean existCodeBySite(String var1, Site var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
      Query var5 = var4.createQuery("from Departement where site.sitId =:se and depCode=:cod").setString("cod", var1);
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

   public List chargerLesDepartementsItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from Departement where depInactif=0 order by depCode ASC").list();
      List var5 = var4;
      ArrayList var6 = new ArrayList();
      if (var1 == 0) {
         var6.add(new SelectItem("100", "Tous Départements"));
      }

      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((Departement)var5.get(var7)).getDepCode() + ":" + ((Departement)var5.get(var7)).getDepNomFr()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
