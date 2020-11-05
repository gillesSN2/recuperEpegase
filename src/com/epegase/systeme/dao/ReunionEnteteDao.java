package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ReunionEntete;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ReunionEnteteDao implements Serializable {
   private ReunionEntete reunionEntete;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ReunionEnteteDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ReunionEntete insert(ReunionEntete var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ReunionEntete modif(ReunionEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
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

   public ReunionEntete modif(ReunionEntete var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(ReunionEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
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

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ReunionEntete order by reuId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            ReunionEntete var7 = (ReunionEntete)var6.get(0);
            var4 = 1L + var7.getReuId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ReunionEntete enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from ReunionEntete where year(reuDate)=" + var7 + " order by reuDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      ReunionEntete var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (ReunionEntete)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public ReunionEntete enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from ReunionEntete where year(reuDate)=" + var7 + " and month(reuDate)=" + var8 + " order by reuDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      ReunionEntete var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (ReunionEntete)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, int var2, String var3, int var4, int var5, String var6, long var7, int var9, String var10, String var11, String var12, String var13, String var14) throws HibernateException, NamingException, ParseException {
      boolean var15 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
         var15 = true;
      }

      UtilDate var16 = new UtilDate();
      new ArrayList();
      Criteria var18 = var1.createCriteria(ReunionEntete.class);
      Calendar var19 = Calendar.getInstance();
      Date var20 = null;
      Date var21 = null;
      Date var22 = new Date();
      String var23 = var16.dateToStringFr(var22);
      String var24 = var23.substring(6, 10) + "-" + var23.substring(3, 5) + "-" + var23.substring(0, 2);
      var16.stringToDateSQL(var24 + " 00:00:00");
      var16.stringToDateSQL(var24 + " 23:59:59");
      int var25 = var22.getYear() + 1900;
      if (var12 != null && var13 != null) {
         var20 = var16.stringToDateSQL(var12 + " 00:00:00");
         var21 = var16.stringToDateSQL(var13 + " 23:59:59");
         var18 = var18.add(Restrictions.between("reuDate", var20, var21));
      } else {
         var18 = var18.add(Restrictions.isNotNull("reuDate"));
      }

      var18 = var18.add(Restrictions.eq("reuNature", var2));
      String var26;
      if (var3 != null && !var3.isEmpty()) {
         var26 = "%" + var3 + "%";
         var18 = var18.add(Restrictions.like("reuNum", var26));
      }

      if (var10 != null && !var10.isEmpty()) {
         var18 = var18.add(Restrictions.eq("reuNomResponsable", var10));
      }

      if (var14 != null && !var14.isEmpty()) {
         var26 = var14 + "%";
         var18 = var18.add(Restrictions.like("reuNomTiers", var26));
      }

      if (var9 == 1) {
         var18 = var18.add(Restrictions.eq("reuIdCreateur", var7));
      }

      if (var4 <= 10) {
         var18 = var18.add(Restrictions.eq("reuEtat", var4));
      }

      if (var5 != 100) {
         var18 = var18.add(Restrictions.eq("reuType", var5));
      }

      if (var6 != null && !var6.isEmpty() && !var6.equalsIgnoreCase("100") && var6.contains(":")) {
         var18 = var18.add(Restrictions.eq("reuService", var6));
      }

      if (!var11.equalsIgnoreCase("100")) {
         String[] var28 = var11.split(":");
         String var27 = var28[0];
         var18 = var18.add(Restrictions.eq("reuActivite", var27));
      }

      List var29 = var18.list();
      if (var15) {
         this.utilInitHibernate.closeSession();
      }

      return var29;
   }

   public ReunionEntete pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ReunionEntete where reuId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new ReunionEntete();
      ReunionEntete var7;
      if (var6.size() != 0) {
         var7 = (ReunionEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ReunionEntete pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ReunionEntete where reuNum =:num").setParameter("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new ReunionEntete();
      ReunionEntete var6;
      if (var5.size() != 0) {
         var6 = (ReunionEntete)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
