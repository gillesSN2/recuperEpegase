package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.SommierEnteteAchats;
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

public class SommierEnteteAchatsDao implements Serializable {
   private SommierEnteteAchats sommierEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public SommierEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public SommierEnteteAchats insert(SommierEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SommierEntete");
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

   public SommierEnteteAchats insert(SommierEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SommierEnteteAchats modif(SommierEnteteAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(SommierEnteteAchats var1, Session var2) {
      var2.delete(var1);
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from SommierEnteteAchats where somId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "SommierEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from SommierEnteteAchats order by somId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            SommierEnteteAchats var7 = (SommierEnteteAchats)var6.get(0);
            var4 = 1L + var7.getSomId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public SommierEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "SommierEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from SommierEnteteAchats where exercicesAchats.exeachId=:id and year(somDate)=" + var7 + " order by somDate desc");
      var8.setParameter("id", var1);
      SommierEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (SommierEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public SommierEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "SommierEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from SommierEnteteAchats where exercicesAchats.exeachId=:id and year(somDate)=" + var7 + " and month(somDate)=" + var8 + " order by somDate desc");
      var9.setParameter("id", var1);
      SommierEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (SommierEnteteAchats)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, String var5, long var6, int var8, String var9, String var10, String var11) throws HibernateException, NamingException, ParseException {
      boolean var12 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "SommierEntete");
         var12 = true;
      }

      UtilDate var13 = new UtilDate();
      new ArrayList();
      Criteria var15 = var1.createCriteria(SommierEnteteAchats.class);
      Calendar var16 = Calendar.getInstance();
      Date var17 = null;
      Date var18 = null;
      Date var19 = new Date();
      String var20 = var13.dateToStringFr(var19);
      String var21 = var20.substring(6, 10) + "-" + var20.substring(3, 5) + "-" + var20.substring(0, 2);
      var17 = var13.stringToDateSQL(var21 + " 00:00:00");
      var18 = var13.stringToDateSQL(var21 + " 23:59:59");
      int var22 = var19.getYear() + 1900;
      String var23;
      if (var5.equalsIgnoreCase("100")) {
         if (var10 != null && var11 != null) {
            var17 = var13.stringToDateSQL(var10 + " 00:00:00");
            var18 = var13.stringToDateSQL(var11 + " 23:59:59");
            var15 = var15.add(Restrictions.between("somDate", var17, var18));
         } else {
            var23 = "1980-01-01";
            var13.stringToDateSQL(var23 + " 00:00:00");
            var15 = var15.add(Restrictions.isNotNull("somDate"));
         }
      } else {
         if (!var5.equalsIgnoreCase("12") && !var5.equalsIgnoreCase("13") && !var5.equalsIgnoreCase("14")) {
            var15 = var15.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var5.equalsIgnoreCase("0")) {
            var15 = var15.add(Restrictions.between("somDate", var17, var18));
         } else if (var5.equalsIgnoreCase("1")) {
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

            var20 = var13.dateToStringFr(var17);
            var21 = var20.substring(6, 10) + "-" + var20.substring(3, 5) + "-" + var20.substring(0, 2);
            var17 = var13.stringToDateSQL(var21 + " 00:00:00");
            var15 = var15.add(Restrictions.between("somDate", var17, var18));
         } else {
            String var24;
            int var25;
            if (var5.equalsIgnoreCase("2")) {
               var25 = var16.get(2) + 1;
               var24 = var22 + "-" + var25 + "-01";
               var17 = var13.stringToDateSQL(var24 + " 00:00:00");
               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("3")) {
               var25 = var16.get(2);
               var16.add(5, -var25);
               if (var25 <= 3) {
                  var24 = var22 + "-01-01";
                  var17 = var13.stringToDateSQL(var24 + " 00:00:00");
               } else if (var25 >= 4 && var25 <= 6) {
                  var24 = var22 + "-04-01";
                  var17 = var13.stringToDateSQL(var24 + " 00:00:00");
               } else if (var25 >= 7 && var25 <= 9) {
                  var24 = var22 + "-07-01";
                  var17 = var13.stringToDateSQL(var24 + " 00:00:00");
               } else if (var25 >= 10) {
                  var24 = var22 + "-10-01";
                  var17 = var13.stringToDateSQL(var24 + " 00:00:00");
               }

               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("4")) {
               var25 = var16.get(2);
               var16.add(5, -var25);
               if (var25 <= 6) {
                  var24 = var22 + "-01-01";
                  var17 = var13.stringToDateSQL(var24 + " 00:00:00");
               } else {
                  var24 = var22 + "-07-01";
                  var17 = var13.stringToDateSQL(var24 + " 00:00:00");
               }

               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("5")) {
               var23 = var22 + "-01-01";
               var17 = var13.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-03-31";
               var18 = var13.stringToDateSQL(var24 + " 23:59:59");
               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("6")) {
               var23 = var22 + "-04-01";
               var17 = var13.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-06-30";
               var18 = var13.stringToDateSQL(var24 + " 23:59:59");
               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("7")) {
               var23 = var22 + "-07-01";
               var17 = var13.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-09-30";
               var18 = var13.stringToDateSQL(var24 + " 23:59:59");
               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("8")) {
               var23 = var22 + "-10-01";
               var17 = var13.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-12-31";
               var18 = var13.stringToDateSQL(var24 + " 23:59:59");
               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("9")) {
               var23 = var22 + "-01-01";
               var17 = var13.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-06-30";
               var18 = var13.stringToDateSQL(var24 + " 23:59:59");
               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("10")) {
               var23 = var22 + "-07-01";
               var17 = var13.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-12-31";
               var18 = var13.stringToDateSQL(var24 + " 23:59:59");
               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("11")) {
               var23 = var22 + "-01-01";
               var17 = var13.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-12-31";
               var18 = var13.stringToDateSQL(var24 + " 23:59:59");
               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("12")) {
               var23 = "1980-01-01";
               var17 = var13.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 - 1 + "-12-31";
               var18 = var13.stringToDateSQL(var24 + " 23:59:59");
               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("13")) {
               var23 = var22 - 1 + "-01-01";
               var17 = var13.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 + "-12-31";
               var18 = var13.stringToDateSQL(var24 + " 23:59:59");
               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("14")) {
               var23 = var22 - 1 + "-01-01";
               var17 = var13.stringToDateSQL(var23 + " 00:00:00");
               var24 = var22 - 1 + "-12-31";
               var18 = var13.stringToDateSQL(var24 + " 23:59:59");
               var15 = var15.add(Restrictions.between("somDate", var17, var18));
            } else if (var5.equalsIgnoreCase("20")) {
               var15.setMaxResults(20);
               var15 = var15.addOrder(Order.desc("somId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var23 = "%" + var4 + "%";
         var15 = var15.add(Restrictions.like("somNum", var23));
      }

      if (var9 != null && !var9.isEmpty()) {
         var15 = var15.add(Restrictions.eq("somDossierTransit", var9));
      }

      if (var8 == 1) {
         var15 = var15.add(Restrictions.eq("somIdCreateur", var6));
      }

      var15 = var15.addOrder(Order.desc("somNum"));
      List var26 = var15.list();
      if (var12) {
         this.utilInitHibernate.closeSession();
      }

      return var26;
   }

   public SommierEnteteAchats pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SommierEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from SommierEnteteAchats where somNum =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      SommierEnteteAchats var6 = null;
      if (var5.size() != 0) {
         var6 = (SommierEnteteAchats)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public SommierEnteteAchats rechercheByDossier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SommierEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from SommierEnteteAchats where somDossierTransit =:dos").setString("dos", var1).setMaxResults(1);
      List var5 = var4.list();
      SommierEnteteAchats var6 = null;
      if (var5.size() != 0) {
         var6 = (SommierEnteteAchats)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public SommierEnteteAchats rechercheBySommierReception(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SommierEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SommierEnteteAchats where somNum=:som and somReception=:rec").setString("som", var1).setString("rec", var2).setMaxResults(1);
      List var6 = var5.list();
      SommierEnteteAchats var7 = null;
      if (var6.size() != 0) {
         var7 = (SommierEnteteAchats)var6.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List listBySommierReception(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SommierEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SommierEnteteAchats where somNum=:som and somReception=:rec").setString("som", var1).setString("rec", var2);
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List listBySommierActif(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SommierEntete");
         var3 = true;
      }

      Query var4 = null;
      if (var1 != null && !var1.isEmpty()) {
         if (var1.equals("*")) {
            var4 = var2.createQuery("from SommierEnteteAchats where somEtat=0");
         } else {
            var4 = var2.createQuery("from SommierEnteteAchats where somNum like '" + var1 + "%' and somEtat=0");
         }
      } else {
         var4 = var2.createQuery("from SommierEnteteAchats where somEtat=0");
      }

      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheSommierByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SommierEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from SommierEnteteAchats where somDate>=:deb and somDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
