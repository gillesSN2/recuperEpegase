package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BienGeranceEntete;
import com.epegase.systeme.classe.Tiers;
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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class BienGeranceEnteteDao implements Serializable {
   private BienGeranceEntete bienGeranceEntete;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BienGeranceEnteteDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BienGeranceEntete insert(BienGeranceEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public BienGeranceEntete insert(BienGeranceEntete var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public BienGeranceEntete modif(BienGeranceEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public BienGeranceEntete modif(BienGeranceEntete var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(BienGeranceEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public void delete(BienGeranceEntete var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List recherche(Session var1, long var2, int var4, String var5, String var6, int var7, String var8, String var9, long var10, int var12, String var13, String var14, String var15) throws HibernateException, NamingException, ParseException {
      boolean var16 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var16 = true;
      }

      UtilDate var17 = new UtilDate();
      new ArrayList();
      Criteria var19 = var1.createCriteria(BienGeranceEntete.class);
      Calendar var20 = Calendar.getInstance();
      var19 = var19.add(Restrictions.eq("biegerentModule", var4));
      Date var21 = null;
      Date var22 = null;
      Date var23 = new Date();
      String var24 = var17.dateToStringFr(var23);
      String var25 = var24.substring(6, 10) + "-" + var24.substring(3, 5) + "-" + var24.substring(0, 2);
      var21 = var17.stringToDateSQLLight(var25);
      var22 = var17.stringToDateSQLLight(var25);
      int var26 = var23.getYear() + 1900;
      String var27;
      if (var9.equalsIgnoreCase("100")) {
         if (var14 != null && var15 != null) {
            var21 = var17.stringToDateSQLLight(var14);
            var22 = var17.stringToDateSQLLight(var15);
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else {
            var27 = "1980-01-01";
            var17.stringToDateSQLLight(var27);
            var19 = var19.add(Restrictions.isNotNull("biegerentDateDebut"));
         }
      } else if (var9.equalsIgnoreCase("0")) {
         var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
      } else if (var9.equalsIgnoreCase("1")) {
         var27 = "" + var20.getTime();
         if (var27.contains("Mon")) {
            var21 = var20.getTime();
         } else if (var27.contains("Tue")) {
            var20.add(7, -1);
            var21 = var20.getTime();
         } else if (var27.contains("Wed")) {
            var20.add(7, -2);
            var21 = var20.getTime();
         } else if (var27.contains("Thu")) {
            var20.add(7, -3);
            var21 = var20.getTime();
         } else if (var27.contains("Fri")) {
            var20.add(7, -4);
            var21 = var20.getTime();
         } else if (var27.contains("Sat")) {
            var20.add(7, -5);
            var21 = var20.getTime();
         } else if (var27.contains("Sun")) {
            var20.add(7, -6);
            var21 = var20.getTime();
         }

         var24 = var17.dateToStringFr(var21);
         var25 = var24.substring(6, 10) + "-" + var24.substring(3, 5) + "-" + var24.substring(0, 2);
         var21 = var17.stringToDateSQLLight(var25);
         var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
      } else {
         String var28;
         int var31;
         if (var9.equalsIgnoreCase("2")) {
            var31 = var20.get(2) + 1;
            var28 = var26 + "-" + var31 + "-01";
            var21 = var17.stringToDateSQLLight(var28);
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("3")) {
            var31 = var20.get(2);
            var20.add(5, -var31);
            if (var31 <= 3) {
               var28 = var26 + "-01-01";
               var21 = var17.stringToDateSQLLight(var28);
            } else if (var31 >= 4 && var31 <= 6) {
               var28 = var26 + "-04-01";
               var21 = var17.stringToDateSQLLight(var28);
            } else if (var31 >= 7 && var31 <= 9) {
               var28 = var26 + "-07-01";
               var21 = var17.stringToDateSQLLight(var28);
            } else if (var31 >= 10) {
               var28 = var26 + "-10-01";
               var21 = var17.stringToDateSQLLight(var28);
            }

            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("4")) {
            var31 = var20.get(2);
            var20.add(5, -var31);
            if (var31 <= 6) {
               var28 = var26 + "-01-01";
               var21 = var17.stringToDateSQLLight(var28);
            } else {
               var28 = var26 + "-07-01";
               var21 = var17.stringToDateSQLLight(var28);
            }

            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("5")) {
            var27 = var26 + "-01-01";
            var21 = var17.stringToDateSQLLight(var27);
            var28 = var26 + "-03-31";
            var22 = var17.stringToDateSQLLight(var28);
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("6")) {
            var27 = var26 + "-04-01";
            var21 = var17.stringToDateSQLLight(var27);
            var28 = var26 + "-06-30";
            var22 = var17.stringToDateSQLLight(var28);
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("7")) {
            var27 = var26 + "-07-01";
            var21 = var17.stringToDateSQLLight(var27);
            var28 = var26 + "-09-30";
            var22 = var17.stringToDateSQLLight(var28);
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("8")) {
            var27 = var26 + "-10-01";
            var21 = var17.stringToDateSQLLight(var27);
            var28 = var26 + "-12-31";
            var22 = var17.stringToDateSQLLight(var28);
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("9")) {
            var27 = var26 + "-01-01";
            var21 = var17.stringToDateSQLLight(var27);
            var28 = var26 + "-06-30";
            var22 = var17.stringToDateSQLLight(var28);
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("10")) {
            var27 = var26 + "-07-01";
            var21 = var17.stringToDateSQLLight(var27);
            var28 = var26 + "-12-31";
            var22 = var17.stringToDateSQLLight(var28);
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("11")) {
            var27 = var26 + "-01-01";
            var21 = var17.stringToDateSQLLight(var27);
            var28 = var26 + "-12-31";
            var22 = var17.stringToDateSQLLight(var28);
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("12")) {
            var27 = "1980-01-01";
            var21 = var17.stringToDateSQLLight(var27);
            var28 = var26 - 1 + "-12-31";
            var22 = var17.stringToDateSQLLight(var28);
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("13")) {
            var27 = var26 - 1 + "-01-01";
            var21 = var17.stringToDateSQL(var27 + " 00:00:00");
            var28 = var26 + "-12-31";
            var22 = var17.stringToDateSQL(var28 + " 23:59:59");
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("14")) {
            var27 = var26 - 1 + "-01-01";
            var21 = var17.stringToDateSQL(var27 + " 00:00:00");
            var28 = var26 - 1 + "-12-31";
            var22 = var17.stringToDateSQL(var28 + " 23:59:59");
            var19 = var19.add(Restrictions.between("biegerentDateDebut", var21, var22));
         } else if (var9.equalsIgnoreCase("20")) {
            var19.setMaxResults(20);
            var19 = var19.addOrder(Order.desc("biegerentId"));
         }
      }

      if (var5 != null && !var5.isEmpty()) {
         var27 = "%" + var5 + "%";
         var19 = var19.add(Restrictions.like("biegerentNum", var27));
      }

      if (var6 != null && !var6.isEmpty()) {
         var27 = "";
         if (var6.startsWith("*")) {
            var27 = "%" + var6.substring(1) + "%";
         } else {
            var27 = var6 + "%";
         }

         var19 = var19.add(Restrictions.like("biegerentNomTiers", var27));
      }

      if (var13 != null && !var13.isEmpty()) {
         var19 = var19.add(Restrictions.eq("biegerentNomResponsable", var13));
      }

      if (var12 == 1) {
         var19 = var19.add(Restrictions.eq("biegerentUserCreat", var10));
      }

      if (!var8.equalsIgnoreCase("100")) {
         if (var8.contains(",")) {
            String[] var32 = var8.split(",");
            int var33 = var32.length;
            String[] var29 = new String[var33];

            for(int var30 = 0; var30 < var33; ++var30) {
               var29[var30] = new String(var32[var30]);
            }

            var19 = var19.add(Restrictions.in("biegerentSerie", var29));
         } else {
            var19 = var19.add(Restrictions.eq("biegerentSerie", var8));
         }
      }

      if (var7 <= 10) {
         var19 = var19.add(Restrictions.eq("biegerentEtat", var7));
      }

      var19 = var19.addOrder(Order.desc("biegerentDateDebut"));
      var19 = var19.addOrder(Order.desc("biegerentNum"));
      List var34 = var19.list();
      if (var16) {
         this.utilInitHibernate.closeSession();
      }

      return var34;
   }

   public BienGeranceEntete pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienGeranceEntete where biegerentId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new BienGeranceEntete();
      BienGeranceEntete var7;
      if (var6.size() != 0) {
         var7 = (BienGeranceEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean verifTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienGeranceEntete where Tiers=:tie").setParameter("tie", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerGeranceByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienGeranceEntete where Tiers=:tie").setParameter("tie", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
