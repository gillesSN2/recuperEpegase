package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Service;
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

public class ServiceDao implements Serializable {
   private Service service;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ServiceDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Service insert(Service var1) throws HibernateException, NamingException {
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

   public Service insert(Service var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Service modif(Service var1) throws HibernateException, NamingException {
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

   public void delete(Service var1) throws HibernateException, NamingException {
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

   public String deletSerByDep(Departement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from Service where departement.depId =:de");
      var4.setParameter("de", var1.getDepId());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public List selectService(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var2 = true;
      }

      List var3 = var1.createQuery(" from Service order by serCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectServiceByExcludeIds(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery(" from Service where serId not in " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesServices(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var2 = true;
      }

      List var3 = var1.createQuery("from Service where serInactif=0 order by serCode ASC").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesServicesItems(int var1, boolean var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var4 = true;
      }

      List var5 = null;
      if (!var2) {
         var5 = var3.createQuery("from Service where serInactif=0 group by serCode order by serCode ASC").list();
      } else {
         var5 = var3.createQuery("from Service where serInactif=0 order by serCode ASC").list();
      }

      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var1 == 0) {
         var7.add(new SelectItem("100", "Tous Services"));
      } else if (var1 == 1) {
         var7.add(new SelectItem("100", "Tous Services"));
         var7.add(new SelectItem("-100", "Sans Service"));
      }

      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            if (var2) {
               var7.add(new SelectItem(((Service)var6.get(var8)).getSerCode() + ":" + ((Service)var6.get(var8)).getSerNomFr() + ":" + ((Service)var6.get(var8)).getDepartement().getDepCode() + ":" + ((Service)var6.get(var8)).getDepartement().getDepNomFr() + ":" + ((Service)var6.get(var8)).getSite().getSitCode() + ":" + ((Service)var6.get(var8)).getSite().getSitNomFr()));
            } else {
               var7.add(new SelectItem(((Service)var6.get(var8)).getSerCode() + ":" + ((Service)var6.get(var8)).getSerNomFr()));
            }
         }
      }

      return var7;
   }

   public Service rechercheService(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      List var4 = var2.createQuery("from Service where serCode=:cod order by serCode").setString("cod", var1).list();
      Service var6 = new Service();
      if (var4.size() > 0) {
         var6 = (Service)var4.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List logService(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
      List var4 = var3.createQuery("from Service where dep_id = " + var1).list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List listServiceByDep(Departement var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      Object var4 = new ArrayList();
      if (var1 != null) {
         Query var5 = var2.createQuery("from Service where serInactif=0 and departement=:departement order by serCode").setParameter("departement", var1);
         var4 = var5.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List listServiceByDepartement(Departement var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      ArrayList var4 = new ArrayList();
      Object var5 = new ArrayList();
      if (var1 != null) {
         Query var6 = var2.createQuery("from Service where serInactif=0 and departement=:departement order by serCode").setParameter("departement", var1);
         var5 = var6.list();
      }

      if (((List)var5).size() != 0) {
         for(int var7 = 0; var7 < ((List)var5).size(); ++var7) {
            var4.add(new SelectItem(((Service)((List)var5).get(var7)).getSerCode() + ":" + ((Service)((List)var5).get(var7)).getSerNomFr()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List listServiceByDep(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      Object var4 = new ArrayList();
      if (var1 != null) {
         Query var5 = var2.createQuery("from Service where departement.depCode=:departement order by serCode").setString("departement", var1);
         var4 = var5.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Service ja where ja.serCode=:cod").setString("cod", var1);
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

      Query var4 = var2.createQuery("from Service ja where ja.serCode=:cod").setString("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Service chargerLeServiceCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Service where serCode=:code order by serCode").setParameter("code", var1);
      var4.setMaxResults(1);
      new ArrayList();
      List var5 = var4.list();
      Service var6 = null;
      if (var5.size() != 0) {
         var6 = (Service)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesServices(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      if (var1.equals("*")) {
         var5 = "from Service where serInactif=0 order by serCode asc";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var6 = var1.substring(1);
         var5 = "from Service where serInactif=0 and (serCode LIKE '%" + var6 + "%) or (serNomFr LIKE '%" + var6 + "%) order by serCode asc";
      } else {
         var5 = "from Service where serInactif=0 and (serCode LIKE '" + var1 + "%) or (serNomFr LIKE '%" + var1 + "%)' order by serCode asc";
      }

      Query var7 = var2.createQuery(var5);
      List var4 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public Service chargerLeServiceCode(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Site");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Service where serId=:code order by serCode").setLong("code", var1);
      var5.setMaxResults(1);
      new ArrayList();
      List var6 = var5.list();
      Service var7 = null;
      if (var6.size() != 0) {
         var7 = (Service)var6.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
