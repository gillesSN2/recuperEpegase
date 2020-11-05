package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.ManifestEntete;
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

public class ManifestEnteteDao implements Serializable {
   private ManifestEntete manifestEntete;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ManifestEnteteDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ManifestEntete insert(ManifestEntete var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ManifestEntete modif(ManifestEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
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

   public ManifestEntete modif(ManifestEntete var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(ManifestEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
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

   public void delete(ManifestEntete var1, Session var2) {
      var2.delete(var1);
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ManifestEntete order by vtemanId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            ManifestEntete var7 = (ManifestEntete)var6.get(0);
            var4 = 1L + var7.getVtemanId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ManifestEntete enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from ManifestEntete where exerciceventes.exevteId=:id and vtemanSerie =:ser and year(vtemanDateDep)=" + var7 + " order by vtemanDateDep desc").setParameter("id", var1).setParameter("ser", var3);
      ManifestEntete var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (ManifestEntete)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public ManifestEntete enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from ManifestEntete where exerciceventes.exevteId=:id and vtemanSerie =:ser and year(vtemanDateDep)=" + var7 + " and month(vtemanDateDep)=" + var8 + " order by vtemanDateDep desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      ManifestEntete var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (ManifestEntete)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, int var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, String var15) throws HibernateException, NamingException, ParseException {
      boolean var16 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var16 = true;
      }

      UtilDate var17 = new UtilDate();
      new ArrayList();
      Criteria var19 = var1.createCriteria(ManifestEntete.class);
      Calendar var20 = Calendar.getInstance();
      Date var21 = null;
      Date var22 = null;
      Date var23 = new Date();
      String var24 = var17.dateToStringFr(var23);
      String var25 = var24.substring(6, 10) + "-" + var24.substring(3, 5) + "-" + var24.substring(0, 2);
      var21 = var17.stringToDateSQLLight(var25);
      var22 = var17.stringToDateSQLLight(var25);
      int var26 = var23.getYear() + 1900;
      String var27;
      String var28;
      if (var7.equalsIgnoreCase("100")) {
         if (var11 != null && var12 != null) {
            var21 = var17.stringToDateSQLLight(var11);
            var22 = var17.stringToDateSQLLight(var12);
            var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
         } else {
            var27 = "1980-01-01";
            var17.stringToDateSQLLight(var27);
            var19 = var19.add(Restrictions.isNotNull("vtemanDateDep"));
         }
      } else {
         if (!var7.equalsIgnoreCase("12") && !var7.equalsIgnoreCase("13") && !var7.equalsIgnoreCase("14")) {
            var19 = var19.add(Restrictions.eq("exercicesParc.exeprcId", var2));
         }

         if (var7.equalsIgnoreCase("0")) {
            var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
         } else if (var7.equalsIgnoreCase("1")) {
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
            var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
         } else {
            int var31;
            if (var7.equalsIgnoreCase("2")) {
               var31 = var20.get(2) + 1;
               var28 = var26 + "-" + var31 + "-01";
               var21 = var17.stringToDateSQLLight(var28);
               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("3")) {
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

               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("4")) {
               var31 = var20.get(2);
               var20.add(5, -var31);
               if (var31 <= 6) {
                  var28 = var26 + "-01-01";
                  var21 = var17.stringToDateSQLLight(var28);
               } else {
                  var28 = var26 + "-07-01";
                  var21 = var17.stringToDateSQLLight(var28);
               }

               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("5")) {
               var27 = var26 + "-01-01";
               var21 = var17.stringToDateSQLLight(var27);
               var28 = var26 + "-03-31";
               var22 = var17.stringToDateSQLLight(var28);
               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("6")) {
               var27 = var26 + "-04-01";
               var21 = var17.stringToDateSQLLight(var27);
               var28 = var26 + "-06-30";
               var22 = var17.stringToDateSQLLight(var28);
               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("7")) {
               var27 = var26 + "-07-01";
               var21 = var17.stringToDateSQLLight(var27);
               var28 = var26 + "-09-30";
               var22 = var17.stringToDateSQLLight(var28);
               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("8")) {
               var27 = var26 + "-10-01";
               var21 = var17.stringToDateSQLLight(var27);
               var28 = var26 + "-12-31";
               var22 = var17.stringToDateSQLLight(var28);
               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("9")) {
               var27 = var26 + "-01-01";
               var21 = var17.stringToDateSQLLight(var27);
               var28 = var26 + "-06-30";
               var22 = var17.stringToDateSQLLight(var28);
               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("10")) {
               var27 = var26 + "-07-01";
               var21 = var17.stringToDateSQLLight(var27);
               var28 = var26 + "-12-31";
               var22 = var17.stringToDateSQLLight(var28);
               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("11")) {
               var27 = var26 + "-01-01";
               var21 = var17.stringToDateSQLLight(var27);
               var28 = var26 + "-12-31";
               var22 = var17.stringToDateSQLLight(var28);
               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("12")) {
               var27 = "1980-01-01";
               var21 = var17.stringToDateSQLLight(var27);
               var28 = var26 - 1 + "-12-31";
               var22 = var17.stringToDateSQLLight(var28);
               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("13")) {
               var27 = var26 - 1 + "-01-01";
               var21 = var17.stringToDateSQLLight(var27);
               var28 = var26 + "-12-31";
               var22 = var17.stringToDateSQLLight(var28);
               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("14")) {
               var27 = var26 - 1 + "-01-01";
               var21 = var17.stringToDateSQLLight(var27);
               var28 = var26 - 1 + "-12-31";
               var22 = var17.stringToDateSQLLight(var28);
               var19 = var19.add(Restrictions.between("vtemanDateDep", var21, var22));
            } else if (var7.equalsIgnoreCase("20")) {
               var19.setMaxResults(20);
               var19 = var19.addOrder(Order.desc("vtemanId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var27 = "%" + var4 + "%";
         var19 = var19.add(Restrictions.like("vtemanNum", var27));
      }

      if (var8 != null && !var8.isEmpty()) {
         var19 = var19.add(Restrictions.eq("vtemanNomResponsable", var8));
      }

      if (var9 != null && !var9.isEmpty()) {
         var19 = var19.add(Restrictions.eq("vtemanNomCommercial", var9));
      }

      String[] var32;
      if (!var6.equalsIgnoreCase("100")) {
         if (var6.contains(",")) {
            var32 = var6.split(",");
            int var34 = var32.length;
            String[] var29 = new String[var34];

            for(int var30 = 0; var30 < var34; ++var30) {
               var29[var30] = new String(var32[var30]);
            }

            var19 = var19.add(Restrictions.or(Restrictions.in("vtemanSerie", var29), Restrictions.isNull("vtemanSerie")));
         } else {
            var19 = var19.add(Restrictions.eq("vtemanSerie", var6));
         }
      }

      if (var5 <= 10) {
         var19 = var19.add(Restrictions.eq("vtemanEtat", var5));
      } else if (var5 == 11) {
         var19 = var19.add(Restrictions.or(Restrictions.eq("vtemanEtat", 0), Restrictions.eq("vtemanEtat", 1)));
      }

      if (!var10.equalsIgnoreCase("100")) {
         var32 = var10.split(":");
         var28 = var32[0];
         var19 = var19.add(Restrictions.eq("vtemanActivite", var28));
      }

      if (var13 != null && !var13.isEmpty()) {
         var19 = var19.add(Restrictions.eq("vtemanSite", var13));
      }

      if (var14 != null && !var14.isEmpty()) {
         var19 = var19.add(Restrictions.eq("vtemanDepartement", var14));
      }

      if (var15 != null && !var15.isEmpty()) {
         var19 = var19.add(Restrictions.eq("vtemanService", var15));
      }

      var19 = var19.addOrder(Order.desc("vtemanDateDep"));
      var19 = var19.addOrder(Order.desc("vtemanNum"));
      List var33 = var19.list();
      if (var16) {
         this.utilInitHibernate.closeSession();
      }

      return var33;
   }

   public List rechercheFactureByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from ManifestEntete where vtemanDateDep>=:deb and vtemanDateDep<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ManifestEntete pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ManifestEntete where vtemanId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new ManifestEntete();
      ManifestEntete var7;
      if (var6.size() != 0) {
         var7 = (ManifestEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ManifestEntete pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ManifestEntete where vtemanNum=:num and vtemanSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new ManifestEntete();
      ManifestEntete var7;
      if (var6.size() != 0) {
         var7 = (ManifestEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ManifestEntete pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ManifestEntete where vtemanNum=:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new ManifestEntete();
      ManifestEntete var6;
      if (var5.size() != 0) {
         var6 = (ManifestEntete)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheManifestRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ManifestEntete where " + var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheManifestPeriode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ManifestEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from ManifestEntete where vtemanDateDep>=:d1 and vtemanDateDep<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
