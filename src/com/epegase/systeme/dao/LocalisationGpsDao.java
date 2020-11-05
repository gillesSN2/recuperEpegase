package com.epegase.systeme.dao;

import com.epegase.systeme.classe.LocalisationGps;
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

public class LocalisationGpsDao implements Serializable {
   private LocalisationGps parcConsommation;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public LocalisationGpsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public LocalisationGps insert(LocalisationGps var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationParc");
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

   public LocalisationGps insert(LocalisationGps var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public LocalisationGps modif(LocalisationGps var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationParc");
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

   public LocalisationGps modif(LocalisationGps var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public String delete(LocalisationGps var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationParc");
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

      return null;
   }

   public List rechercheLocalisationGps(long var1, String var3, String var4, String var5, String var6, String var7, String var8, String var9, Session var10) throws HibernateException, NamingException, ParseException {
      boolean var11 = false;
      if (var10 == null) {
         var10 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationParc");
         var11 = true;
      }

      new ArrayList();
      ArrayList var13 = new ArrayList();
      Criteria var14 = var10.createCriteria(LocalisationGps.class);
      UtilDate var15 = new UtilDate();
      Calendar var16 = Calendar.getInstance();
      Date var17 = null;
      Date var18 = null;
      Date var19 = new Date();
      String var20 = var15.dateToStringFr(var19);
      String var21 = var20.substring(6, 10) + "-" + var20.substring(3, 5) + "-" + var20.substring(0, 2);
      var17 = var15.stringToDateSQL(var21 + " 00:00:00");
      var18 = var15.stringToDateSQL(var21 + " 23:59:59");
      int var22 = var19.getYear() + 1900;
      String var23;
      int var27;
      if (var3.equalsIgnoreCase("100")) {
         if (var4 != null && var5 != null) {
            var17 = var15.stringToDateSQL(var4 + " 00:00:00");
            var18 = var15.stringToDateSQL(var5 + " 23:59:59");
            System.out.println("d1 " + var17 + " d2 " + var18);
            var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
         } else {
            var23 = "1980-01-01";
            var15.stringToDateSQL(var23 + " 00:00:00");
            var14 = var14.add(Restrictions.isNotNull("locgpsDate"));
         }
      } else {
         if (!var3.equalsIgnoreCase("12") && !var3.equalsIgnoreCase("13") && !var3.equalsIgnoreCase("14")) {
            var14 = var14.add(Restrictions.eq("exercicesParc.exeprcId", var1));
         }

         if (var3.equalsIgnoreCase("0")) {
            var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
         } else if (var3.equalsIgnoreCase("1")) {
            var23 = "" + var16.getTime();
            if (var23.contains("Mon")) {
               var17 = var16.getTime();
            } else if (var23.contains("Tue")) {
               var16.add(7, -1);
               var17 = var16.getTime();
            } else if (var23.contains("Wed")) {
               var16.add(7, -2);
               var17 = var16.getTime();
            } else if (var23.contains("Thu")) {
               var16.add(7, -3);
               var17 = var16.getTime();
            } else if (var23.contains("Fri")) {
               var16.add(7, -4);
               var17 = var16.getTime();
            } else if (var23.contains("Sat")) {
               var16.add(7, -5);
               var17 = var16.getTime();
            } else if (var23.contains("Sun")) {
               var16.add(7, -6);
               var17 = var16.getTime();
            }

            var20 = var15.dateToStringFr(var17);
            var21 = var20.substring(6, 10) + "-" + var20.substring(3, 5) + "-" + var20.substring(0, 2);
            var17 = var15.stringToDateSQL(var21 + " 00:00:00");
            var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
         } else {
            String var24;
            if (var3.equalsIgnoreCase("2")) {
               var27 = var16.get(2) + 1;
               var24 = var22 + "-" + var27 + "-01";
               var17 = var15.stringToDateSQL(var24 + " 00:00:00");
               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("3")) {
               var27 = var16.get(2);
               var16.add(5, -var27);
               if (var27 <= 3) {
                  var24 = var22 + "-01-01";
                  var17 = var15.stringToDateSQL(var24 + " 00:00:00");
               } else if (var27 >= 4 && var27 <= 6) {
                  var24 = var22 + "-04-01";
                  var17 = var15.stringToDateSQL(var24 + " 00:00:00");
               } else if (var27 >= 7 && var27 <= 9) {
                  var24 = var22 + "-07-01";
                  var17 = var15.stringToDateSQL(var24 + " 00:00:00");
               } else if (var27 >= 10) {
                  var24 = var22 + "-10-01";
                  var17 = var15.stringToDateSQL(var24 + " 00:00:00");
               }

               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("4")) {
               var27 = var16.get(2);
               var16.add(5, -var27);
               if (var27 <= 6) {
                  var24 = var22 + "-01-01";
                  var17 = var15.stringToDateSQL(var24 + " 00:00:00");
               } else {
                  var24 = var22 + "-07-01";
                  var17 = var15.stringToDateSQL(var24 + " 00:00:00");
               }

               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("5")) {
               var23 = var22 + "-01-01";
               var17 = var15.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-03-31";
               var18 = var15.stringToDateSQL(var24 + " 23:59:59");
               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("6")) {
               var23 = var22 + "-04-01";
               var17 = var15.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-06-30";
               var18 = var15.stringToDateSQL(var24 + " 23:59:59");
               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("7")) {
               var23 = var22 + "-07-01";
               var17 = var15.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-09-30";
               var18 = var15.stringToDateSQL(var24 + " 23:59:59");
               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("8")) {
               var23 = var22 + "-10-01";
               var17 = var15.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-12-31";
               var18 = var15.stringToDateSQL(var24 + " 23:59:59");
               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("9")) {
               var23 = var22 + "-01-01";
               var17 = var15.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-06-30";
               var18 = var15.stringToDateSQL(var24 + " 23:59:59");
               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("10")) {
               var23 = var22 + "-07-01";
               var17 = var15.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-12-31";
               var18 = var15.stringToDateSQL(var24 + " 23:59:59");
               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("11")) {
               var23 = var22 + "-01-01";
               var17 = var15.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-12-31";
               var18 = var15.stringToDateSQL(var24 + " 23:59:59");
               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("12")) {
               var23 = "1980-01-01";
               var17 = var15.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 - 1 + "-12-31";
               var18 = var15.stringToDateSQL(var24 + " 23:59:59");
               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("13")) {
               var23 = var22 - 1 + "-01-01";
               var17 = var15.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-12-31";
               var18 = var15.stringToDateSQL(var24 + " 23:59:59");
               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("14")) {
               var23 = var22 - 1 + "-01-01";
               var17 = var15.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 - 1 + "-12-31";
               var18 = var15.stringToDateSQL(var24 + " 23:59:59");
               var14 = var14.add(Restrictions.between("locgpsDate", var17, var18));
            } else if (var3.equalsIgnoreCase("20")) {
               var14.setMaxResults(20);
               var14 = var14.addOrder(Order.desc("locgpsId"));
            }
         }
      }

      if (var6 != null && !var6.isEmpty()) {
         var14 = var14.add(Restrictions.eq("locgpsBalise", var6));
      }

      List var12 = var14.list();
      if (var12.size() != 0) {
         if (var7 != null && !var7.isEmpty() || var8 != null && !var8.isEmpty() || var9 != null && !var9.isEmpty()) {
            for(var27 = 0; var27 < var12.size(); ++var27) {
               boolean var28 = false;
               boolean var25 = false;
               boolean var26 = false;
               if (var7 != null && !var7.isEmpty()) {
                  if (((LocalisationGps)var12.get(var27)).getParc().getPrcImmatriculation() != null && !((LocalisationGps)var12.get(var27)).getParc().getPrcImmatriculation().isEmpty() && ((LocalisationGps)var12.get(var27)).getParc().getPrcImmatriculation().equals(var7)) {
                     var28 = true;
                  }
               } else {
                  var28 = true;
               }

               if (var8 != null && !var8.isEmpty()) {
                  if (((LocalisationGps)var12.get(var27)).getParc().getPrcFamille() != null && !((LocalisationGps)var12.get(var27)).getParc().getPrcFamille().isEmpty() && ((LocalisationGps)var12.get(var27)).getParc().getPrcFamille().equals(var8)) {
                     var25 = true;
                  }
               } else {
                  var25 = true;
               }

               if (var9 != null && !var9.isEmpty()) {
                  if (((LocalisationGps)var12.get(var27)).getParc().getPrcService() != null && !((LocalisationGps)var12.get(var27)).getParc().getPrcService().isEmpty() && ((LocalisationGps)var12.get(var27)).getParc().getPrcService().equals(var9)) {
                     var26 = true;
                  }
               } else {
                  var26 = true;
               }

               if (var28 && var25 && var26) {
                  var13.add(var12.get(var27));
               }
            }
         } else {
            for(var27 = 0; var27 < var12.size(); ++var27) {
               var13.add(var12.get(var27));
            }
         }
      }

      if (var11) {
         this.utilInitHibernate.closeSession();
      }

      return var13;
   }

   public LocalisationGps rechercheLocalisation(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationParc");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.parcConsommation = new LocalisationGps();
      var6 = var3.createQuery("from LocalisationGps where locgpsId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.parcConsommation = (LocalisationGps)var6.get(0);
      } else {
         this.parcConsommation = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.parcConsommation;
   }

   public LocalisationGps rechercheLocalisation(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationParc");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      this.parcConsommation = new LocalisationGps();
      var5 = var2.createQuery("from LocalisationGps where locgpsBalise=" + var1).setMaxResults(1).list();
      if (var5.size() != 0) {
         this.parcConsommation = (LocalisationGps)var5.get(0);
      } else {
         this.parcConsommation = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.parcConsommation;
   }

   public boolean rechercheLocalisation(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationParc");
         var4 = true;
      }

      boolean var5 = false;
      new ArrayList();
      List var7 = var3.createQuery("from LocalisationGps where locgpsDate='" + var1 + "' and locgpsBalise=:bal").setString("bal", var2).setMaxResults(1).list();
      if (var7.size() != 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheLocalisation(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationParc");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from LocalisationGps where locgpsDate>=:date1 and locgpsDate<=:date2").setDate("date1", var1).setDate("date2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
