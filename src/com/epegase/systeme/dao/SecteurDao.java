package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Secteur;
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

public class SecteurDao implements Serializable {
   private String maBase;
   private Secteur secteur;
   private UtilInitHibernate utilInitHibernate;

   public SecteurDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Secteur insert(Secteur var1) throws HibernateException, NamingException {
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

   public Secteur modif(Secteur var1) throws HibernateException, NamingException {
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

   public void delete(Secteur var1) throws HibernateException, NamingException {
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

   public String deletSectByRegion(Region var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from Secteur where region.regId =:se");
      var4.setParameter("se", var1.getRegId());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public List selectSec() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      List var2 = var1.createQuery(" from Secteur order by secCode asc").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List logSecteur(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      List var4 = var3.createQuery("from Secteur where reg_id = '" + var1 + "' order by secCode").list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List listSecteurByRegionItem(Region var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      new ArrayList();
      ArrayList var5 = new ArrayList();
      if (var1 != null) {
         Query var6 = var2.createQuery("from Secteur where region=:region  order by secCode");
         var6.setParameter("region", var1);
         List var4 = var6.list();
         if (var4.size() != 0) {
            for(int var7 = 0; var7 < var4.size(); ++var7) {
               new Secteur();
               Secteur var8 = (Secteur)var4.get(var7);
               var5.add(new SelectItem(var8.getSecCode() + ":" + var8.getSecNomFr()));
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listSecteurByRegion(Region var1, Session var2) throws HibernateException, NamingException {
      Object var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
            var4 = true;
         }

         Query var5 = var2.createQuery("from Secteur where region=:region  order by secCode");
         var5.setParameter("region", var1);
         var3 = var5.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var3;
   }

   public List listSecteurByRegion(String var1, Session var2) throws HibernateException, NamingException {
      Object var3 = new ArrayList();
      if (var1 != null) {
         boolean var4 = false;
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
            var4 = true;
         }

         Query var5 = var2.createQuery("from Secteur where region.regCode=:region  order by secCode").setString("region", var1);
         var3 = var5.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var3;
   }

   public List chargerLesSecteurs(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      List var4 = var2.createQuery("from Secteur where secCode=:cod  order by secCode").setString("cod", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List listSecteurByReg(Region var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      Object var4 = new ArrayList();
      if (var1 != null) {
         Query var5 = var2.createQuery("from Secteur where  secInactif =0 and region=:regi order by secCode");
         var5.setParameter("regi", var1);
         var4 = var5.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List chargerLesSecteurs(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var2 = true;
      }

      List var3 = var1.createQuery("from Secteur where secInactif=0  order by secCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public Secteur rechercheSecteur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      List var4 = var2.createQuery("from Secteur where secCode=:cod  order by secCode").setString("cod", var1).list();
      new Secteur();
      Secteur var6;
      if (var4.size() > 0) {
         var6 = (Secteur)var4.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from Secteur where secCode=:cod").setString("cod", var1);
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

   public List existCodeList(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      Query var3 = var2.createQuery("from Secteur ja where ja.secCode=:cod").setString("cod", var1);
      var3.setMaxResults(1);
      List var4 = var3.list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public Secteur chargerSecteurBycode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Secteur where secCode =:cod  order by secCode");
      var4.setParameter("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      Secteur var6 = (Secteur)var5.get(0);
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6 != null ? var6 : null;
   }

   public boolean existCodeByReg(String var1, Region var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Region");
      Query var5 = var4.createQuery("from Secteur where region.regId=:re and secCode=:cod ").setString("cod", var1);
      var5.setParameter("re", var2.getRegId());
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
