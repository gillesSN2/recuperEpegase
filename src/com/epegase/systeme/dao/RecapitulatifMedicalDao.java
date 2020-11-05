package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.RecapitulatifMedical;
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

public class RecapitulatifMedicalDao implements Serializable {
   private RecapitulatifMedical recapitulatifMedical;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public RecapitulatifMedicalDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public RecapitulatifMedical insert(RecapitulatifMedical var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public RecapitulatifMedical modif(RecapitulatifMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
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

   public RecapitulatifMedical modif(RecapitulatifMedical var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from RecapitulatifMedical where facrecId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from RecapitulatifMedical order by facrecId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            RecapitulatifMedical var7 = (RecapitulatifMedical)var6.get(0);
            var4 = 1L + var7.getFacrecId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public int selectLastNumRecap(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from RecapitulatifMedical order by facrecNum desc");
      int var4 = 1;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var5 = var3.list();
         if (var5.size() > 0) {
            RecapitulatifMedical var6 = (RecapitulatifMedical)var5.get(0);
            var4 = (int)(1L + var6.getFacrecId());
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public RecapitulatifMedical enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from RecapitulatifMedical where exerciceventes.exevteId=:id and facrecSerie =:ser and year(facrecDate)=" + var7 + " order by facrecDate desc").setParameter("id", var1).setParameter("ser", var3);
      RecapitulatifMedical var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (RecapitulatifMedical)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public RecapitulatifMedical enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from RecapitulatifMedical where exerciceventes.exevteId=:id and facrecSerie =:ser and year(facrecDate)=" + var7 + " and month(facrecDate)=" + var8 + " order by facrecDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      RecapitulatifMedical var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (RecapitulatifMedical)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, String var5, int var6, int var7, String var8, String var9, String var10, long var11, int var13, String var14, String var15, String var16) throws HibernateException, NamingException, ParseException {
      boolean var17 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var17 = true;
      }

      UtilDate var18 = new UtilDate();
      new ArrayList();
      Criteria var20 = var1.createCriteria(RecapitulatifMedical.class);
      Calendar var21 = Calendar.getInstance();
      Date var22 = null;
      Date var23 = null;
      Date var24 = new Date();
      String var25 = var18.dateToStringFr(var24);
      String var26 = var25.substring(6, 10) + "-" + var25.substring(3, 5) + "-" + var25.substring(0, 2);
      var22 = var18.stringToDateSQL(var26 + " 00:00:00");
      var23 = var18.stringToDateSQL(var26 + " 23:59:59");
      int var27 = var24.getYear() + 1900;
      String var28;
      if (var9.equalsIgnoreCase("100")) {
         if (var15 != null && var16 != null) {
            var22 = var18.stringToDateSQL(var15 + " 00:00:00");
            var23 = var18.stringToDateSQL(var16 + " 23:59:59");
            var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
         } else {
            var28 = "1980-01-01";
            var18.stringToDateSQL(var28 + " 00:00:00");
            var20 = var20.add(Restrictions.isNotNull("facrecDate"));
         }
      } else {
         if (!var9.equalsIgnoreCase("12") && !var9.equalsIgnoreCase("13") && !var9.equalsIgnoreCase("14")) {
            var20 = var20.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var9.equalsIgnoreCase("0")) {
            var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
         } else if (var9.equalsIgnoreCase("1")) {
            var28 = "" + var21.getTime();
            if (var28.contains("Mon")) {
               var22 = var21.getTime();
            } else if (var28.contains("Tue")) {
               var21.add(7, -1);
               var22 = var21.getTime();
            } else if (var28.contains("Wed")) {
               var21.add(7, -2);
               var22 = var21.getTime();
            } else if (var28.contains("Thu")) {
               var21.add(7, -3);
               var22 = var21.getTime();
            } else if (var28.contains("Fri")) {
               var21.add(7, -4);
               var22 = var21.getTime();
            } else if (var28.contains("Sat")) {
               var21.add(7, -5);
               var22 = var21.getTime();
            } else if (var28.contains("Sun")) {
               var21.add(7, -6);
               var22 = var21.getTime();
            }

            var25 = var18.dateToStringFr(var22);
            var26 = var25.substring(6, 10) + "-" + var25.substring(3, 5) + "-" + var25.substring(0, 2);
            var22 = var18.stringToDateSQL(var26 + " 00:00:00");
            var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
         } else {
            String var29;
            int var32;
            if (var9.equalsIgnoreCase("2")) {
               var32 = var21.get(2) + 1;
               var29 = var27 + "-" + var32 + "-01";
               var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("3")) {
               var32 = var21.get(2);
               var21.add(5, -var32);
               if (var32 <= 3) {
                  var29 = var27 + "-01-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               } else if (var32 >= 4 && var32 <= 6) {
                  var29 = var27 + "-04-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               } else if (var32 >= 7 && var32 <= 9) {
                  var29 = var27 + "-07-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               } else if (var32 >= 10) {
                  var29 = var27 + "-10-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               }

               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("4")) {
               var32 = var21.get(2);
               var21.add(5, -var32);
               if (var32 <= 6) {
                  var29 = var27 + "-01-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               } else {
                  var29 = var27 + "-07-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               }

               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("5")) {
               var28 = var27 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-03-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("6")) {
               var28 = var27 + "-04-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-06-30";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("7")) {
               var28 = var27 + "-07-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-09-30";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("8")) {
               var28 = var27 + "-10-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("9")) {
               var28 = var27 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-06-30";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("10")) {
               var28 = var27 + "-07-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("11")) {
               var28 = var27 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("12")) {
               var28 = "1980-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 - 1 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("13")) {
               var28 = var27 - 1 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("14")) {
               var28 = var27 - 1 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 - 1 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facrecDate", var22, var23));
            } else if (var9.equalsIgnoreCase("20")) {
               var20.setMaxResults(20);
               var20 = var20.addOrder(Order.desc("facrecId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var28 = "%" + var4 + "%";
         var20 = var20.add(Restrictions.like("facrecNum", var28));
      }

      if (var5 != null && !var5.isEmpty()) {
         var20 = var20.add(Restrictions.eq("facrecNomTiers", var5));
      }

      String[] var33;
      if (var5 != null && !var5.isEmpty() && var5.contains(":")) {
         var33 = var5.split(":");
         long var35 = Long.parseLong(var33[0]);
         var20 = var20.add(Restrictions.eq("tiers.tieid", var35));
      }

      if (var6 != 0 && var6 != 99) {
         var20 = var20.add(Restrictions.eq("facrecFondCnamgs", var6));
      }

      if (var14 != null && !var14.isEmpty()) {
         var20 = var20.add(Restrictions.eq("facrecNomCommercial", var14));
      }

      if (var13 == 1 || var13 == 2) {
         var20 = var20.add(Restrictions.eq("facrecIdCreateur", var11));
      }

      if (!var8.equalsIgnoreCase("100")) {
         if (var8.contains(",")) {
            var33 = var8.split(",");
            int var36 = var33.length;
            String[] var30 = new String[var36];

            for(int var31 = 0; var31 < var36; ++var31) {
               var30[var31] = new String(var33[var31]);
            }

            var20 = var20.add(Restrictions.in("facrecSerie", var30));
         } else {
            var20 = var20.add(Restrictions.eq("facrecSerie", var8));
         }
      }

      if (var7 <= 10 && var7 != 1) {
         var20 = var20.add(Restrictions.eq("facrecEtat", var7));
      } else if (var7 == 1) {
         var20 = var20.add(Restrictions.eq("facrecEtat", 1));
      } else if (var7 == 11) {
         var20 = var20.add(Restrictions.isNotNull("facrecDateRelance"));
      } else if (var7 == 12) {
         var20 = var20.add(Restrictions.eq("facrecTotHt", 0.0D));
      } else if (var7 == 13) {
         var20 = var20.add(Restrictions.eq("facrecSolde", 0));
      } else if (var7 == 14) {
         var20 = var20.add(Restrictions.eq("facrecSolde", 1));
      } else if (var7 == 15) {
         var20 = var20.add(Restrictions.eq("facrecExoTva", 1));
      } else if (var7 == 16) {
         var20 = var20.add(Restrictions.and(Restrictions.eq("facrecExoTva", 1), Restrictions.isNull("facrecDateVisa")));
      } else if (var7 == 17) {
         var20 = var20.add(Restrictions.isNotNull("facrecDateTransfert"));
      } else if (var7 == 18) {
         var20 = var20.add(Restrictions.isNull("facrecDateTransfert"));
      }

      if (var10 != null && !var10.isEmpty() && !var10.equalsIgnoreCase("100") && var10.contains(":")) {
         var20 = var20.add(Restrictions.eq("facrecService", var10));
      }

      var20 = var20.addOrder(Order.desc("facrecDate"));
      var20 = var20.addOrder(Order.desc("facrecNum"));
      List var34 = var20.list();
      if (var17) {
         this.utilInitHibernate.closeSession();
      }

      return var34;
   }
}
