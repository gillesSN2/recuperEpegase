package com.epegase.systeme.dao;

import com.epegase.systeme.classe.TraiteEntete;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class TraiteEnteteDao implements Serializable {
   private TraiteEntete traiteEntete;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public TraiteEnteteDao() {
   }

   public TraiteEnteteDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public TraiteEntete insert(TraiteEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Traites");
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

   public TraiteEntete insert(TraiteEntete var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public TraiteEntete modif(TraiteEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Traites");
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

   public TraiteEntete modif(TraiteEntete var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(TraiteEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Traites");
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

   public List selectFind(int var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Traites");
         var5 = true;
      }

      new ArrayList();
      new UtilDate();
      Criteria var8 = var4.createCriteria(TraiteEntete.class);
      var8 = var8.add(Restrictions.eq("trtNature", var2));
      if (!var3.equalsIgnoreCase("100")) {
         var8 = var8.add(Restrictions.eq("trtService", var3));
      }

      if (var1 == 0) {
         var8 = var8.add(Restrictions.eq("trtEtat", var1));
      } else if (var1 == 1) {
         var8 = var8.add(Restrictions.eq("trtEtat", var1));
      } else if (var1 == 2) {
         var8 = var8.add(Restrictions.eq("trtEtat", var1));
      } else if (var1 == 3) {
         var8 = var8.add(Restrictions.eq("trtEtat", var1));
      } else if (var1 == 4) {
         var8 = var8.add(Restrictions.eq("trtEtat", var1));
      }

      List var6 = var8.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public TraiteEntete selectById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Traites");
         var4 = true;
      }

      TraiteEntete var5 = new TraiteEntete();
      Query var6 = var3.createQuery("from TraiteEntete where trtId=:ident").setLong("ident", var1).setMaxResults(1);
      List var7 = var6.list();
      if (var7.size() > 0) {
         var5 = (TraiteEntete)var7.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
