package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CessionEntete;
import com.epegase.systeme.classe.ExercicesAchats;
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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CessionEnteteDao implements Serializable {
   private CessionEntete cessionEntete;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CessionEnteteDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CessionEntete insert(CessionEntete var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CessionEntete modif(CessionEntete var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from CessionEntete where cesId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from CessionEntete order by cesId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            CessionEntete var7 = (CessionEntete)var6.get(0);
            var4 = 1L + var7.getCesId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public CessionEntete enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from CessionEntete where exercicesAchats.exeachId=:id and cesSerie =:ser and year(cesDate)=" + var7 + " order by cesDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      CessionEntete var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (CessionEntete)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public CessionEntete enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from CessionEntete where exercicesAchats.exeachId=:id and cesSerie =:ser and year(cesDate)=" + var7 + " and month(cesDate)=" + var8 + " order by cesDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      CessionEntete var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (CessionEntete)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, List var5, int var6, String var7, String var8, String var9, long var10, int var12, String var13, String var14, String var15, String var16, String var17) throws HibernateException, NamingException, ParseException {
      boolean var18 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var18 = true;
      }

      UtilDate var19 = new UtilDate();
      new ArrayList();
      Criteria var21 = var1.createCriteria(CessionEntete.class);
      Calendar var22 = Calendar.getInstance();
      Date var23 = null;
      Date var24 = null;
      Date var25 = new Date();
      String var26 = var19.dateToStringFr(var25);
      String var27 = var26.substring(6, 10) + "-" + var26.substring(3, 5) + "-" + var26.substring(0, 2);
      var23 = var19.stringToDateSQL(var27 + " 00:00:00");
      var24 = var19.stringToDateSQL(var27 + " 23:59:59");
      int var28 = var25.getYear() + 1900;
      String var29;
      String var30;
      if (var8.equalsIgnoreCase("100")) {
         if (var15 != null && var16 != null) {
            var23 = var19.stringToDateSQL(var15 + " 00:00:00");
            var24 = var19.stringToDateSQL(var16 + " 23:59:59");
            var21 = var21.add(Restrictions.between("cesDate", var23, var24));
         } else {
            var21 = var21.add(Restrictions.isNotNull("cesDate"));
         }
      } else {
         if (!var8.equalsIgnoreCase("12") && !var8.equalsIgnoreCase("13") && !var8.equalsIgnoreCase("14")) {
            var21 = var21.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var8.equalsIgnoreCase("0")) {
            var23 = var19.stringToDateSQL(var27 + " 00:00:00");
            var24 = var19.stringToDateSQL(var27 + " 23:59:59");
            var21 = var21.add(Restrictions.between("cesDate", var23, var24));
         } else if (var8.equalsIgnoreCase("1")) {
            var29 = "" + var22.getTime();
            if (var29.contains("Mon")) {
               var23 = var22.getTime();
            } else if (var29.contains("Tue")) {
               var22.add(7, -1);
               var23 = var22.getTime();
            } else if (var29.contains("Wed")) {
               var22.add(7, -2);
               var23 = var22.getTime();
            } else if (var29.contains("Thu")) {
               var22.add(7, -3);
               var23 = var22.getTime();
            } else if (var29.contains("Fri")) {
               var22.add(7, -4);
               var23 = var22.getTime();
            } else if (var29.contains("Sat")) {
               var22.add(7, -5);
               var23 = var22.getTime();
            } else if (var29.contains("Sun")) {
               var22.add(7, -6);
               var23 = var22.getTime();
            }

            var26 = var19.dateToStringFr(var23);
            var27 = var26.substring(6, 10) + "-" + var26.substring(3, 5) + "-" + var26.substring(0, 2);
            var23 = var19.stringToDateSQL(var27 + " 00:00:00");
            var21 = var21.add(Restrictions.between("cesDate", var23, var24));
         } else {
            int var33;
            if (var8.equalsIgnoreCase("2")) {
               var33 = var22.get(2) + 1;
               var30 = var28 + "-" + var33 + "-01";
               var23 = var19.stringToDateSQL(var30 + " 00:00:00");
               var21 = var21.add(Restrictions.between("cesDate", var23, var24));
            } else {
               String var31;
               if (var8.equalsIgnoreCase("3")) {
                  var33 = var22.get(2);
                  var22.add(5, -var33);
                  if (var33 <= 3) {
                     var30 = var28 + "-01-01";
                     var23 = var19.stringToDateSQL(var30 + " 00:00:00");
                     var31 = var28 + "-03-31";
                     var24 = var19.stringToDateSQL(var31 + " 23:59:59");
                  } else if (var33 >= 4 && var33 <= 6) {
                     var30 = var28 + "-04-01";
                     var23 = var19.stringToDateSQL(var30 + " 00:00:00");
                     var31 = var28 + "-06-30";
                     var24 = var19.stringToDateSQL(var31 + " 23:59:59");
                  } else if (var33 >= 7 && var33 <= 9) {
                     var30 = var28 + "-07-01";
                     var23 = var19.stringToDateSQL(var30 + " 00:00:00");
                     var31 = var28 + "-09-30";
                     var24 = var19.stringToDateSQL(var31 + " 23:59:59");
                  } else if (var33 >= 10) {
                     var30 = var28 + "-10-01";
                     var23 = var19.stringToDateSQL(var30 + " 00:00:00");
                     var31 = var28 + "-12-31";
                     var24 = var19.stringToDateSQL(var31 + " 23:59:59");
                  }

                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("4")) {
                  var33 = var22.get(2);
                  var22.add(5, -var33);
                  if (var33 <= 6) {
                     var30 = var28 + "-01-01";
                     var23 = var19.stringToDateSQL(var30 + " 00:00:00");
                     var31 = var28 + "-06-30";
                     var24 = var19.stringToDateSQL(var31 + " 23:59:59");
                  } else {
                     var30 = var28 + "-07-01";
                     var23 = var19.stringToDateSQL(var30 + " 00:00:00");
                     var31 = var28 + "-12-31";
                     var24 = var19.stringToDateSQL(var31 + " 23:59:59");
                  }

                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("5")) {
                  var29 = var28 + "-01-01";
                  var23 = var19.stringToDateSQL(var29 + " 00:00:00");
                  var30 = var28 + "-03-31";
                  var24 = var19.stringToDateSQL(var30 + " 23:59:59");
                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("6")) {
                  var29 = var28 + "-04-01";
                  var23 = var19.stringToDateSQL(var29 + " 00:00:00");
                  var30 = var28 + "-06-30";
                  var24 = var19.stringToDateSQL(var30 + " 23:59:59");
                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("7")) {
                  var29 = var28 + "-07-01";
                  var23 = var19.stringToDateSQL(var29 + " 00:00:00");
                  var30 = var28 + "-09-30";
                  var24 = var19.stringToDateSQL(var30 + " 23:59:59");
                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("8")) {
                  var29 = var28 + "-10-01";
                  var23 = var19.stringToDateSQL(var29 + " 00:00:00");
                  var30 = var28 + "-12-31";
                  var24 = var19.stringToDateSQL(var30 + " 23:59:59");
                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("9")) {
                  var29 = var28 + "-01-01";
                  var23 = var19.stringToDateSQL(var29 + " 00:00:00");
                  var30 = var28 + "-06-30";
                  var24 = var19.stringToDateSQL(var30 + " 23:59:59");
                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("10")) {
                  var29 = var28 + "-07-01";
                  var23 = var19.stringToDateSQL(var29 + " 00:00:00");
                  var30 = var28 + "-12-31";
                  var24 = var19.stringToDateSQL(var30 + " 23:59:59");
                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("11")) {
                  var29 = var28 + "-01-01";
                  var23 = var19.stringToDateSQL(var29 + " 00:00:00");
                  var30 = var28 + "-12-31";
                  var24 = var19.stringToDateSQL(var30 + " 23:59:59");
                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("12")) {
                  var29 = "1980-01-01";
                  var23 = var19.stringToDateSQL(var29 + " 00:00:00");
                  var30 = var28 - 1 + "-12-31";
                  var24 = var19.stringToDateSQL(var30 + " 23:59:59");
                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("13")) {
                  var29 = var28 - 1 + "-01-01";
                  var23 = var19.stringToDateSQL(var29 + " 00:00:00");
                  var30 = var28 + "-12-31";
                  var24 = var19.stringToDateSQL(var30 + " 23:59:59");
                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("14")) {
                  var29 = var28 - 1 + "-01-01";
                  var23 = var19.stringToDateSQL(var29 + " 00:00:00");
                  var30 = var28 - 1 + "-12-31";
                  var24 = var19.stringToDateSQL(var30 + " 23:59:59");
                  var21 = var21.add(Restrictions.between("cesDate", var23, var24));
               } else if (var8.equalsIgnoreCase("20")) {
                  var21.setMaxResults(20);
                  var21 = var21.addOrder(Order.desc("cesId"));
               }
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var29 = "%" + var4 + "%";
         var21 = var21.add(Restrictions.like("cesNum", var29));
      }

      if (var5.size() != 0) {
         var21 = var21.add(Restrictions.or(Restrictions.in("cesDepotOrigine", var5), Restrictions.in("cesDepotDestination", var5)));
      }

      if (var13 != null && !var13.isEmpty()) {
         var21 = var21.add(Restrictions.eq("cesNomResponsable", var13));
      }

      if (var12 == 1) {
         var21 = var21.add(Restrictions.eq("cesIdCreateur", var10));
      }

      String[] var35;
      if (!var7.equalsIgnoreCase("100")) {
         if (var7.contains(",")) {
            var35 = var7.split(",");
            int var37 = var35.length;
            String[] var34 = new String[var37];

            for(int var32 = 0; var32 < var37; ++var32) {
               var34[var32] = new String(var35[var32]);
            }

            var21 = var21.add(Restrictions.in("cesSerie", var34));
         } else {
            var21 = var21.add(Restrictions.eq("cesSerie", var7));
         }
      }

      if (var6 <= 10) {
         var21 = var21.add(Restrictions.eq("cesEtat", var6));
      }

      if (var9 != null && !var9.isEmpty() && !var9.equalsIgnoreCase("100") && var9.contains(":")) {
         var21 = var21.add(Restrictions.eq("cesService", var9));
      }

      if (!var14.equalsIgnoreCase("100")) {
         var35 = var14.split(":");
         var30 = var35[0];
         var21 = var21.add(Restrictions.eq("cesActivite", var30));
      }

      if (var17 != null && !var17.isEmpty()) {
         var29 = "%" + var17 + "%";
         var21 = var21.add(Restrictions.like("cesObject", var29));
      }

      var21 = var21.addOrder(Order.desc("cesDate"));
      var21 = var21.addOrder(Order.desc("cesNum"));
      List var36 = var21.list();
      if (var18) {
         this.utilInitHibernate.closeSession();
      }

      return var36;
   }

   public CessionEntete pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CessionEntete where cesId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new CessionEntete();
      CessionEntete var7;
      if (var6.size() != 0) {
         var7 = (CessionEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public CessionEntete pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CessionEntete where cesNum=:num and cesSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new CessionEntete();
      CessionEntete var7;
      if (var6.size() != 0) {
         var7 = (CessionEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
      Query var4 = var3.createQuery("from CessionEntete where usr_id =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List rechercheCessionRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CessionEntete where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCessionsByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from CessionEntete where cesDate>=:deb and cesDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
