package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CertificationDocument;
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

public class CertificationDocumentDao implements Serializable {
   private CertificationDocument certificationDocument;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CertificationDocumentDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CertificationDocument insert(CertificationDocument var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CertificationDocument");
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

   public List recherche(Session var1, int var2, String var3, String var4, String var5) throws HibernateException, NamingException, ParseException {
      boolean var6 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CertificationDocument");
         var6 = true;
      }

      UtilDate var7 = new UtilDate();
      new ArrayList();
      Criteria var9 = var1.createCriteria(CertificationDocument.class);
      Calendar var10 = Calendar.getInstance();
      Date var11 = null;
      Date var12 = null;
      Date var13 = new Date();
      String var14 = var7.dateToStringFr(var13);
      String var15 = var14.substring(6, 10) + "-" + var14.substring(3, 5) + "-" + var14.substring(0, 2);
      var11 = var7.stringToDateSQL(var15 + " 00:00:00");
      var12 = var7.stringToDateSQL(var15 + " 23:59:59");
      int var16 = var13.getYear() + 1900;
      if (var2 == 0) {
         var9 = var9.add(Restrictions.le("cerTypeTiers", 10));
      } else if (var2 == 1) {
         var9 = var9.add(Restrictions.eq("cerTypeTiers", 99));
      } else if (var2 == 2) {
         var9 = var9.add(Restrictions.eq("cerTypeTiers", 90));
      }

      String var17;
      if (var3.equalsIgnoreCase("100")) {
         if (var4 != null && var5 != null) {
            var11 = var7.stringToDateSQL(var4 + " 00:00:00");
            var12 = var7.stringToDateSQL(var5 + " 23:59:59");
            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         } else {
            var17 = "1980-01-01";
            var7.stringToDateSQL(var17 + " 00:00:00");
            var9 = var9.add(Restrictions.isNotNull("cerDateCreat"));
         }
      } else if (var3.equalsIgnoreCase("0")) {
         var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
      } else if (var3.equalsIgnoreCase("1")) {
         var17 = "" + var10.getTime();
         if (var17.contains("Mon")) {
            var11 = var10.getTime();
         } else if (var17.contains("Tue")) {
            var10.add(7, -1);
            var11 = var10.getTime();
         } else if (var17.contains("Wed")) {
            var10.add(7, -2);
            var11 = var10.getTime();
         } else if (var17.contains("Thu")) {
            var10.add(7, -3);
            var11 = var10.getTime();
         } else if (var17.contains("Fri")) {
            var10.add(7, -4);
            var11 = var10.getTime();
         } else if (var17.contains("Sat")) {
            var10.add(7, -5);
            var11 = var10.getTime();
         } else if (var17.contains("Sun")) {
            var10.add(7, -6);
            var11 = var10.getTime();
         }

         var14 = var7.dateToStringFr(var11);
         var15 = var14.substring(6, 10) + "-" + var14.substring(3, 5) + "-" + var14.substring(0, 2);
         var11 = var7.stringToDateSQL(var15 + " 00:00:00");
         var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
      } else {
         String var18;
         int var19;
         if (var3.equalsIgnoreCase("2")) {
            var19 = var10.get(2) + 1;
            var18 = var16 + "-" + var19 + "-01";
            var11 = var7.stringToDateSQL(var18 + " 00:00:00");
            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         } else if (var3.equalsIgnoreCase("3")) {
            var19 = var10.get(2);
            var10.add(5, -var19);
            if (var19 <= 3) {
               var18 = var16 + "-01-01";
               var11 = var7.stringToDateSQL(var18 + " 00:00:00");
            } else if (var19 >= 4 && var19 <= 6) {
               var18 = var16 + "-04-01";
               var11 = var7.stringToDateSQL(var18 + " 00:00:00");
            } else if (var19 >= 7 && var19 <= 9) {
               var18 = var16 + "-07-01";
               var11 = var7.stringToDateSQL(var18 + " 00:00:00");
            } else if (var19 >= 10) {
               var18 = var16 + "-10-01";
               var11 = var7.stringToDateSQL(var18 + " 00:00:00");
            }

            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         } else if (var3.equalsIgnoreCase("4")) {
            var19 = var10.get(2);
            var10.add(5, -var19);
            if (var19 <= 6) {
               var18 = var16 + "-01-01";
               var11 = var7.stringToDateSQL(var18 + " 00:00:00");
            } else {
               var18 = var16 + "-07-01";
               var11 = var7.stringToDateSQL(var18 + " 00:00:00");
            }

            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         } else if (var3.equalsIgnoreCase("5")) {
            var17 = var16 + "-01-01";
            var11 = var7.stringToDateSQL(var17 + " 00:00:00");
            var18 = var16 + "-03-31";
            var12 = var7.stringToDateSQL(var18 + " 23:59:59");
            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         } else if (var3.equalsIgnoreCase("6")) {
            var17 = var16 + "-04-01";
            var11 = var7.stringToDateSQL(var17 + " 00:00:00");
            var18 = var16 + "-06-30";
            var12 = var7.stringToDateSQL(var18 + " 23:59:59");
            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         } else if (var3.equalsIgnoreCase("7")) {
            var17 = var16 + "-07-01";
            var11 = var7.stringToDateSQL(var17 + " 00:00:00");
            var18 = var16 + "-09-30";
            var12 = var7.stringToDateSQL(var18 + " 23:59:59");
            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         } else if (var3.equalsIgnoreCase("8")) {
            var17 = var16 + "-10-01";
            var11 = var7.stringToDateSQL(var17 + " 00:00:00");
            var18 = var16 + "-12-31";
            var12 = var7.stringToDateSQL(var18 + " 23:59:59");
            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         } else if (var3.equalsIgnoreCase("9")) {
            var17 = var16 + "-01-01";
            var11 = var7.stringToDateSQL(var17 + " 00:00:00");
            var18 = var16 + "-06-30";
            var12 = var7.stringToDateSQL(var18 + " 23:59:59");
            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         } else if (var3.equalsIgnoreCase("10")) {
            var17 = var16 + "-07-01";
            var11 = var7.stringToDateSQL(var17 + " 00:00:00");
            var18 = var16 + "-12-31";
            var12 = var7.stringToDateSQL(var18 + " 23:59:59");
            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         } else if (var3.equalsIgnoreCase("11")) {
            var17 = var16 + "-01-01";
            var11 = var7.stringToDateSQL(var17 + " 00:00:00");
            var18 = var16 + "-12-31";
            var12 = var7.stringToDateSQL(var18 + " 23:59:59");
            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         } else if (var3.equalsIgnoreCase("12")) {
            var17 = "1980-01-01";
            var11 = var7.stringToDateSQL(var17 + " 00:00:00");
            var18 = var16 - 1 + "-12-31";
            var12 = var7.stringToDateSQL(var18 + " 23:59:59");
            var9 = var9.add(Restrictions.between("cerDateCreat", var11, var12));
         }
      }

      var9 = var9.addOrder(Order.desc("cerDateCreat"));
      List var20 = var9.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var20;
   }

   public CertificationDocument pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CertificationDocument");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CertificationDocument where cerId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new CertificationDocument();
      CertificationDocument var7;
      if (var6.size() != 0) {
         var7 = (CertificationDocument)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheCertificationDocumentRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CertificationDocument");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CertificationDocument where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public int calculeNbCertificationDocument(Session var1) throws HibernateException, NamingException {
      int var2 = 0;
      boolean var3 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CertificationDocument");
         var3 = true;
      }

      new ArrayList();
      List var5 = var1.createQuery("from CertificationDocument").list();
      List var4 = var5;
      if (var5.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var2 += ((CertificationDocument)var4.get(var6)).getCerQte();
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var2;
   }
}
