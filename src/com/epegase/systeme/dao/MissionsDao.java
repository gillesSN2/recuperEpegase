package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Missions;
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

public class MissionsDao implements Serializable {
   private Missions missions;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public MissionsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Missions insert(Missions var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
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

   public Missions modif(Missions var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
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

   public Missions modif(Missions var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(Missions var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
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

   public void delete(Missions var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List rechercheMissions(int var1, String var2, int var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
         var7 = true;
      }

      new ArrayList();
      Criteria var9 = var6.createCriteria(Missions.class);
      if (var2 != null && !var2.isEmpty()) {
         String var10 = "%" + var2 + "%";
         var9 = var9.add(Restrictions.like("misNum", var10));
      }

      if (var1 != 100) {
         if (var1 == 90) {
            var9 = var9.add(Restrictions.or(Restrictions.eq("misEtat", 0), Restrictions.eq("misEtat", 1)));
         } else {
            var9 = var9.add(Restrictions.eq("misEtat", var1));
         }
      }

      if (var3 != 100) {
         var9 = var9.add(Restrictions.eq("misNature", var3));
      }

      String var11;
      String[] var12;
      if (var4.contains(":")) {
         var12 = var4.split(":");
         var11 = var12[0];
         var9 = var9.add(Restrictions.eq("misService", var11));
      }

      if (var5.contains(":")) {
         var12 = var5.split(":");
         var11 = var12[0];
         var9 = var9.add(Restrictions.eq("misActivite", var11));
      }

      List var8 = var9.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheMissions(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
         var4 = true;
      }

      new ArrayList();
      Query var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         var6 = var3.createQuery("from Missions where (misEtat=1 or misEtat=2 or misEtat=3 or misEtat=4) and misBudget=:bud and misActivite=:act").setString("bud", var1).setString("act", var2);
      } else {
         var6 = var3.createQuery("from Missions where (misEtat=1 or misEtat=2 or misEtat=3 or misEtat=4) and misBudget=:bud").setString("bud", var1);
      }

      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
