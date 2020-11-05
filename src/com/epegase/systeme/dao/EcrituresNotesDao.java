package com.epegase.systeme.dao;

import com.epegase.systeme.classe.EcrituresNotes;
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

public class EcrituresNotesDao implements Serializable {
   private EcrituresNotes ecrituresNotes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public EcrituresNotesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public EcrituresNotes insert(EcrituresNotes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresNotes");
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

   public EcrituresNotes insert(EcrituresNotes var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public EcrituresNotes modif(EcrituresNotes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresNotes");
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

   public EcrituresNotes modif(EcrituresNotes var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(EcrituresNotes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresNotes");
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

   public void delete(EcrituresNotes var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerNotes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresNotes");
         var2 = true;
      }

      Query var3 = var1.createQuery("from EcrituresNotes");
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerNotes(int var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresNotes");
         var4 = true;
      }

      Query var5 = null;
      if (var1 == 9) {
         if (var2 == 9) {
            var5 = var3.createQuery("from EcrituresNotes");
         } else {
            var5 = var3.createQuery("from EcrituresNotes where ecrnotType=" + var2);
         }
      } else if (var2 == 9) {
         var5 = var3.createQuery("from EcrituresNotes where ecrnotEtat=" + var1);
      } else {
         var5 = var3.createQuery("from EcrituresNotes where ecrnotEtat=" + var1 + " and ecrnotType=" + var2);
      }

      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List recherche(Session var1, String var2, int var3, int var4, int var5, String var6, String var7, String var8) throws HibernateException, NamingException, ParseException {
      boolean var9 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "EcrituresNotes");
         var9 = true;
      }

      new ArrayList();
      UtilDate var11 = new UtilDate();
      Criteria var12 = var1.createCriteria(EcrituresNotes.class);
      Calendar var13 = Calendar.getInstance();
      Date var14 = null;
      Date var15 = null;
      Date var16 = new Date();
      String var17 = var11.dateToStringFr(var16);
      String var18 = var17.substring(6, 10) + "-" + var17.substring(3, 5) + "-" + var17.substring(0, 2);
      var14 = var11.stringToDateSQLLight(var18);
      var15 = var11.stringToDateSQLLight(var18);
      int var19 = var16.getYear() + 1900;
      String var20;
      if (var6.equalsIgnoreCase("100")) {
         if (var7 != null && var8 != null) {
            var14 = var11.stringToDateSQL(var7);
            var15 = var11.stringToDateSQL(var8);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else {
            var20 = "1980-01-01";
            var11.stringToDateSQLLight(var20);
            var12 = var12.add(Restrictions.isNotNull("ecrnotDate"));
         }
      } else if (var6.equalsIgnoreCase("0")) {
         var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
      } else if (var6.equalsIgnoreCase("1")) {
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

         var17 = var11.dateToStringFr(var14);
         var18 = var17.substring(6, 10) + "-" + var17.substring(3, 5) + "-" + var17.substring(0, 2);
         var14 = var11.stringToDateSQLLight(var18);
         var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
      } else {
         String var21;
         int var22;
         if (var6.equalsIgnoreCase("2")) {
            var22 = var13.get(2) + 1;
            var21 = var19 + "-" + var22 + "-01";
            var14 = var11.stringToDateSQLLight(var21);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("3")) {
            var22 = var13.get(2);
            var13.add(5, -var22);
            if (var22 <= 3) {
               var21 = var19 + "-01-01";
               var14 = var11.stringToDateSQLLight(var21);
            } else if (var22 >= 4 && var22 <= 6) {
               var21 = var19 + "-04-01";
               var14 = var11.stringToDateSQLLight(var21);
            } else if (var22 >= 7 && var22 <= 9) {
               var21 = var19 + "-07-01";
               var14 = var11.stringToDateSQLLight(var21);
            } else if (var22 >= 10) {
               var21 = var19 + "-10-01";
               var14 = var11.stringToDateSQLLight(var21);
            }

            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("4")) {
            var22 = var13.get(2);
            var13.add(5, -var22);
            if (var22 <= 6) {
               var21 = var19 + "-01-01";
               var14 = var11.stringToDateSQLLight(var21);
            } else {
               var21 = var19 + "-07-01";
               var14 = var11.stringToDateSQLLight(var21);
            }

            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("5")) {
            var20 = var19 + "-01-01";
            var14 = var11.stringToDateSQLLight(var20);
            var21 = var19 + "-03-31";
            var15 = var11.stringToDateSQLLight(var21);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("6")) {
            var20 = var19 + "-04-01";
            var14 = var11.stringToDateSQLLight(var20);
            var21 = var19 + "-06-30";
            var15 = var11.stringToDateSQLLight(var21);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("7")) {
            var20 = var19 + "-07-01";
            var14 = var11.stringToDateSQLLight(var20);
            var21 = var19 + "-09-30";
            var15 = var11.stringToDateSQLLight(var21);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("8")) {
            var20 = var19 + "-10-01";
            var14 = var11.stringToDateSQLLight(var20);
            var21 = var19 + "-12-31";
            var15 = var11.stringToDateSQLLight(var21);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("9")) {
            var20 = var19 + "-01-01";
            var14 = var11.stringToDateSQLLight(var20);
            var21 = var19 + "-06-30";
            var15 = var11.stringToDateSQLLight(var21);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("10")) {
            var20 = var19 + "-07-01";
            var14 = var11.stringToDateSQLLight(var20);
            var21 = var19 + "-12-31";
            var15 = var11.stringToDateSQLLight(var21);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("11")) {
            var20 = var19 + "-01-01";
            var14 = var11.stringToDateSQLLight(var20);
            var21 = var19 + "-12-31";
            var15 = var11.stringToDateSQLLight(var21);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("12")) {
            var20 = "1980-01-01";
            var14 = var11.stringToDateSQLLight(var20);
            var21 = var19 - 1 + "-12-31";
            var15 = var11.stringToDateSQLLight(var21);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("13")) {
            var20 = var19 - 1 + "-01-01";
            var14 = var11.stringToDateSQLLight(var20);
            var21 = var19 + "-12-31";
            var15 = var11.stringToDateSQLLight(var21);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("14")) {
            var20 = var19 - 1 + "-01-01";
            var14 = var11.stringToDateSQLLight(var20);
            var21 = var19 - 1 + "-12-31";
            var15 = var11.stringToDateSQLLight(var21);
            var12 = var12.add(Restrictions.between("ecrnotDate", var14, var15));
         } else if (var6.equalsIgnoreCase("20")) {
            var12.setMaxResults(20);
            var12 = var12.addOrder(Order.desc("ecrnotId"));
         }
      }

      if (var2 != null && !var2.isEmpty()) {
         var20 = "%" + var2 + "%";
         var12 = var12.add(Restrictions.like("ecrnotNum", var20));
      }

      if (var3 <= 10) {
         var12 = var12.add(Restrictions.eq("ecrnotEtat", var3));
      }

      if (var4 <= 10) {
         var12 = var12.add(Restrictions.eq("ecrnotType", var4));
      }

      if (var5 <= 10) {
         var12 = var12.add(Restrictions.eq("ecrnotCategorie", var5));
      }

      var12 = var12.addOrder(Order.desc("ecrnotDate"));
      var12 = var12.addOrder(Order.desc("ecrnotNum"));
      List var10 = var12.list();
      if (var9) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }
}
