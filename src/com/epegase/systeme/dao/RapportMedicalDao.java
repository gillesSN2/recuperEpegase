package com.epegase.systeme.dao;

import com.epegase.systeme.classe.RapportMedical;
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
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class RapportMedicalDao implements Serializable {
   private RapportMedical rapportMedical;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public RapportMedicalDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public RapportMedical insert(RapportMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "RapportMedical");
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

   public RapportMedical insert(RapportMedical var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public RapportMedical modif(RapportMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "RapportMedical");
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

   public RapportMedical modif(RapportMedical var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(RapportMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "RapportMedical");
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

   public void delete(RapportMedical var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List recherche(Session var1, long var2, int var4, String var5, String var6, String var7, String var8) throws HibernateException, NamingException, ParseException {
      boolean var9 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "RapportMedical");
         var9 = true;
      }

      UtilDate var10 = new UtilDate();
      new ArrayList();
      Criteria var12 = var1.createCriteria(RapportMedical.class);
      Calendar var13 = Calendar.getInstance();
      Date var14 = null;
      Date var15 = null;
      Date var16 = new Date();
      String var17 = var10.dateToStringFr(var16);
      String var18 = var17.substring(6, 10) + "-" + var17.substring(3, 5) + "-" + var17.substring(0, 2);
      var14 = var10.stringToDateSQL(var18 + " 00:00:00");
      var15 = var10.stringToDateSQL(var18 + " 23:59:59");
      int var19 = var16.getYear() + 1900;
      String var20;
      if (var5.equalsIgnoreCase("100")) {
         if (var7 != null && var8 != null) {
            var14 = var10.stringToDateSQL(var7 + " 00:00:00");
            var15 = var10.stringToDateSQL(var8 + " 23:59:59");
            var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
         } else {
            var20 = "1980-01-01";
            var10.stringToDateSQL(var20 + " 00:00:00");
            var12 = var12.add(Restrictions.isNotNull("rapmedDate"));
         }
      } else {
         if (!var5.equalsIgnoreCase("12") && !var5.equalsIgnoreCase("13") && !var5.equalsIgnoreCase("14")) {
            var12 = var12.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var5.equalsIgnoreCase("0")) {
            var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
         } else if (var5.equalsIgnoreCase("1")) {
            var20 = "" + var13.getTime();
            if (var20.contains("Mon")) {
               var14 = var13.getTime();
            } else if (var20.contains("Tue")) {
               var13.add(7, -1);
               var14 = var13.getTime();
            } else if (var20.contains("Wed")) {
               var13.add(7, -2);
               var14 = var13.getTime();
            } else if (var20.contains("Thu")) {
               var13.add(7, -3);
               var14 = var13.getTime();
            } else if (var20.contains("Fri")) {
               var13.add(7, -4);
               var14 = var13.getTime();
            } else if (var20.contains("Sat")) {
               var13.add(7, -5);
               var14 = var13.getTime();
            } else if (var20.contains("Sun")) {
               var13.add(7, -6);
               var14 = var13.getTime();
            }

            var17 = var10.dateToStringFr(var14);
            var18 = var17.substring(6, 10) + "-" + var17.substring(3, 5) + "-" + var17.substring(0, 2);
            var14 = var10.stringToDateSQL(var18 + " 00:00:00");
            var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
         } else {
            String var21;
            int var22;
            if (var5.equalsIgnoreCase("2")) {
               var22 = var13.get(2) + 1;
               var21 = var19 + "-" + var22 + "-01";
               var14 = var10.stringToDateSQL(var21 + " 00:00:00");
               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("3")) {
               var22 = var13.get(2);
               var13.add(5, -var22);
               if (var22 <= 3) {
                  var21 = var19 + "-01-01";
                  var14 = var10.stringToDateSQL(var21 + " 00:00:00");
               } else if (var22 >= 4 && var22 <= 6) {
                  var21 = var19 + "-04-01";
                  var14 = var10.stringToDateSQL(var21 + " 00:00:00");
               } else if (var22 >= 7 && var22 <= 9) {
                  var21 = var19 + "-07-01";
                  var14 = var10.stringToDateSQL(var21 + " 00:00:00");
               } else if (var22 >= 10) {
                  var21 = var19 + "-10-01";
                  var14 = var10.stringToDateSQL(var21 + " 00:00:00");
               }

               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("4")) {
               var22 = var13.get(2);
               var13.add(5, -var22);
               if (var22 <= 6) {
                  var21 = var19 + "-01-01";
                  var14 = var10.stringToDateSQL(var21 + " 00:00:00");
               } else {
                  var21 = var19 + "-07-01";
                  var14 = var10.stringToDateSQL(var21 + " 00:00:00");
               }

               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("5")) {
               var20 = var19 + "-01-01";
               var14 = var10.stringToDateSQL(var20 + " 00:00:00");
               var21 = var19 + "-03-31";
               var15 = var10.stringToDateSQL(var21 + " 23:59:59");
               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("6")) {
               var20 = var19 + "-04-01";
               var14 = var10.stringToDateSQL(var20 + " 00:00:00");
               var21 = var19 + "-06-30";
               var15 = var10.stringToDateSQL(var21 + " 23:59:59");
               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("7")) {
               var20 = var19 + "-07-01";
               var14 = var10.stringToDateSQL(var20 + " 00:00:00");
               var21 = var19 + "-09-30";
               var15 = var10.stringToDateSQL(var21 + " 23:59:59");
               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("8")) {
               var20 = var19 + "-10-01";
               var14 = var10.stringToDateSQL(var20 + " 00:00:00");
               var21 = var19 + "-12-31";
               var15 = var10.stringToDateSQL(var21 + " 23:59:59");
               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("9")) {
               var20 = var19 + "-01-01";
               var14 = var10.stringToDateSQL(var20 + " 00:00:00");
               var21 = var19 + "-06-30";
               var15 = var10.stringToDateSQL(var21 + " 23:59:59");
               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("10")) {
               var20 = var19 + "-07-01";
               var14 = var10.stringToDateSQL(var20 + " 00:00:00");
               var21 = var19 + "-12-31";
               var15 = var10.stringToDateSQL(var21 + " 23:59:59");
               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("11")) {
               var20 = var19 + "-01-01";
               var14 = var10.stringToDateSQL(var20 + " 00:00:00");
               var21 = var19 + "-12-31";
               var15 = var10.stringToDateSQL(var21 + " 23:59:59");
               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("12")) {
               var20 = "1980-01-01";
               var14 = var10.stringToDateSQL(var20 + " 00:00:00");
               var21 = var19 - 1 + "-12-31";
               var15 = var10.stringToDateSQL(var21 + " 23:59:59");
               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("13")) {
               var20 = var19 - 1 + "-01-01";
               var14 = var10.stringToDateSQL(var20 + " 00:00:00");
               var21 = var19 + "-12-31";
               var15 = var10.stringToDateSQL(var21 + " 23:59:59");
               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            } else if (var5.equalsIgnoreCase("14")) {
               var20 = var19 - 1 + "-01-01";
               var14 = var10.stringToDateSQL(var20 + " 00:00:00");
               var21 = var19 - 1 + "-12-31";
               var15 = var10.stringToDateSQL(var21 + " 23:59:59");
               var12 = var12.add(Restrictions.between("rapmedDate", var14, var15));
            }
         }
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12.add(Restrictions.eq("rapmedNomCommercial", var6));
      }

      if (var4 <= 10) {
         var12 = var12.add(Restrictions.eq("rapmedEtat", var4));
      }

      var12 = var12.addOrder(Order.desc("rapmedNum"));
      List var23 = var12.list();
      if (var9) {
         this.utilInitHibernate.closeSession();
      }

      return var23;
   }

   public List chargerLesMvtsDate(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "RapportMedical");
         var4 = true;
      }

      List var5 = null;
      var5 = var3.createQuery("from RapportMedical where rapmedDate between '" + var1 + "' and '" + var2 + "'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesMvtsInfirmerieDate(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "RapportMedical");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from RapportMedical where rapmedDate between '" + var2 + "' and '" + var3 + "' and rapmedService='" + var1 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
