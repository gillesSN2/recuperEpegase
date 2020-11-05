package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.InventaireEntete;
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

public class InventaireEnteteDao implements Serializable {
   private InventaireEntete inventaireEntete;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public InventaireEnteteDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public InventaireEntete insert(InventaireEntete var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public InventaireEntete modif(InventaireEntete var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from InventaireEntete where invId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from InventaireEntete order by invId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            InventaireEntete var7 = (InventaireEntete)var6.get(0);
            var4 = 1L + var7.getInvId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public InventaireEntete enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from InventaireEntete where exercicesAchats.exeachId=:id and invSerie =:ser and year(invDate)=" + var7 + " order by invDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      InventaireEntete var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (InventaireEntete)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public InventaireEntete enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from InventaireEntete where exercicesAchats.exeachId=:id and invSerie =:ser and year(invDate)=" + var7 + " and month(invDate)=" + var8 + " order by invDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      InventaireEntete var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (InventaireEntete)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, List var5, int var6, String var7, String var8, String var9, long var10, int var12, String var13, String var14, String var15, String var16) throws HibernateException, NamingException, ParseException {
      boolean var17 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
         var17 = true;
      }

      UtilDate var18 = new UtilDate();
      new ArrayList();
      Criteria var20 = var1.createCriteria(InventaireEntete.class);
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
      String var29;
      if (var8.equalsIgnoreCase("100")) {
         if (var15 != null && var16 != null) {
            var22 = var18.stringToDateSQL(var15 + " 00:00:00");
            var23 = var18.stringToDateSQL(var16 + " 23:59:59");
            var20 = var20.add(Restrictions.between("invDate", var22, var23));
         } else {
            var20 = var20.add(Restrictions.isNotNull("invDate"));
         }
      } else {
         if (!var8.equalsIgnoreCase("12") && !var8.equalsIgnoreCase("13") && !var8.equalsIgnoreCase("14")) {
            var20 = var20.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var8.equalsIgnoreCase("0")) {
            var22 = var18.stringToDateSQL(var26 + " 00:00:00");
            var23 = var18.stringToDateSQL(var26 + " 23:59:59");
            var20 = var20.add(Restrictions.between("invDate", var22, var23));
         } else if (var8.equalsIgnoreCase("1")) {
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
            var20 = var20.add(Restrictions.between("invDate", var22, var23));
         } else {
            int var32;
            if (var8.equalsIgnoreCase("2")) {
               var32 = var21.get(2) + 1;
               var29 = var27 + "-" + var32 + "-01";
               var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               var20 = var20.add(Restrictions.between("invDate", var22, var23));
            } else {
               String var30;
               if (var8.equalsIgnoreCase("3")) {
                  var32 = var21.get(2);
                  var21.add(5, -var32);
                  if (var32 <= 3) {
                     var29 = var27 + "-01-01";
                     var22 = var18.stringToDateSQL(var29 + " 00:00:00");
                     var30 = var27 + "-03-31";
                     var23 = var18.stringToDateSQL(var30 + " 23:59:59");
                  } else if (var32 >= 4 && var32 <= 6) {
                     var29 = var27 + "-04-01";
                     var22 = var18.stringToDateSQL(var29 + " 00:00:00");
                     var30 = var27 + "-06-30";
                     var23 = var18.stringToDateSQL(var30 + " 23:59:59");
                  } else if (var32 >= 7 && var32 <= 9) {
                     var29 = var27 + "-07-01";
                     var22 = var18.stringToDateSQL(var29 + " 00:00:00");
                     var30 = var27 + "-09-30";
                     var23 = var18.stringToDateSQL(var30 + " 23:59:59");
                  } else if (var32 >= 10) {
                     var29 = var27 + "-10-01";
                     var22 = var18.stringToDateSQL(var29 + " 00:00:00");
                     var30 = var27 + "-12-31";
                     var23 = var18.stringToDateSQL(var30 + " 23:59:59");
                  }

                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("4")) {
                  var32 = var21.get(2);
                  var21.add(5, -var32);
                  if (var32 <= 6) {
                     var29 = var27 + "-01-01";
                     var22 = var18.stringToDateSQL(var29 + " 00:00:00");
                     var30 = var27 + "-06-30";
                     var23 = var18.stringToDateSQL(var30 + " 23:59:59");
                  } else {
                     var29 = var27 + "-07-01";
                     var22 = var18.stringToDateSQL(var29 + " 00:00:00");
                     var30 = var27 + "-12-31";
                     var23 = var18.stringToDateSQL(var30 + " 23:59:59");
                  }

                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("5")) {
                  var28 = var27 + "-01-01";
                  var22 = var18.stringToDateSQL(var28 + " 00:00:00");
                  var29 = var27 + "-03-31";
                  var23 = var18.stringToDateSQL(var29 + " 23:59:59");
                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("6")) {
                  var28 = var27 + "-04-01";
                  var22 = var18.stringToDateSQL(var28 + " 00:00:00");
                  var29 = var27 + "-06-30";
                  var23 = var18.stringToDateSQL(var29 + " 23:59:59");
                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("7")) {
                  var28 = var27 + "-07-01";
                  var22 = var18.stringToDateSQL(var28 + " 00:00:00");
                  var29 = var27 + "-09-30";
                  var23 = var18.stringToDateSQL(var29 + " 23:59:59");
                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("8")) {
                  var28 = var27 + "-10-01";
                  var22 = var18.stringToDateSQL(var28 + " 00:00:00");
                  var29 = var27 + "-12-31";
                  var23 = var18.stringToDateSQL(var29 + " 23:59:59");
                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("9")) {
                  var28 = var27 + "-01-01";
                  var22 = var18.stringToDateSQL(var28 + " 00:00:00");
                  var29 = var27 + "-06-30";
                  var23 = var18.stringToDateSQL(var29 + " 23:59:59");
                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("10")) {
                  var28 = var27 + "-07-01";
                  var22 = var18.stringToDateSQL(var28 + " 00:00:00");
                  var29 = var27 + "-12-31";
                  var23 = var18.stringToDateSQL(var29 + " 23:59:59");
                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("11")) {
                  var28 = var27 + "-01-01";
                  var22 = var18.stringToDateSQL(var28 + " 00:00:00");
                  var29 = var27 + "-12-31";
                  var23 = var18.stringToDateSQL(var29 + " 23:59:59");
                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("12")) {
                  var28 = "1980-01-01";
                  var22 = var18.stringToDateSQL(var28 + " 00:00:00");
                  var29 = var27 - 1 + "-12-31";
                  var23 = var18.stringToDateSQL(var29 + " 23:59:59");
                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("13")) {
                  var28 = var27 - 1 + "-01-01";
                  var22 = var18.stringToDateSQL(var28 + " 00:00:00");
                  var29 = var27 + "-12-31";
                  var23 = var18.stringToDateSQL(var29 + " 23:59:59");
                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("14")) {
                  var28 = var27 - 1 + "-01-01";
                  var22 = var18.stringToDateSQL(var28 + " 00:00:00");
                  var29 = var27 - 1 + "-12-31";
                  var23 = var18.stringToDateSQL(var29 + " 23:59:59");
                  var20 = var20.add(Restrictions.between("invDate", var22, var23));
               } else if (var8.equalsIgnoreCase("20")) {
                  var20.setMaxResults(20);
                  var20 = var20.addOrder(Order.desc("invId"));
               }
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var28 = "%" + var4 + "%";
         var20 = var20.add(Restrictions.like("invNum", var28));
      }

      if (var5.size() != 0) {
         var20 = var20.add(Restrictions.in("invDepot", var5));
      }

      if (var13 != null && !var13.isEmpty()) {
         var20 = var20.add(Restrictions.eq("invNomResponsable", var13));
      }

      if (var12 == 1) {
         var20 = var20.add(Restrictions.eq("invIdCreateur", var10));
      }

      String[] var34;
      if (!var7.equalsIgnoreCase("100")) {
         if (var7.contains(",")) {
            var34 = var7.split(",");
            int var36 = var34.length;
            String[] var33 = new String[var36];

            for(int var31 = 0; var31 < var36; ++var31) {
               var33[var31] = new String(var34[var31]);
            }

            var20 = var20.add(Restrictions.in("invSerie", var33));
         } else {
            var20 = var20.add(Restrictions.eq("invSerie", var7));
         }
      }

      if (var6 <= 10) {
         var20 = var20.add(Restrictions.eq("invEtat", var6));
      }

      if (var9 != null && !var9.isEmpty() && !var9.equalsIgnoreCase("100") && var9.contains(":")) {
         var20 = var20.add(Restrictions.eq("invService", var9));
      }

      if (!var14.equalsIgnoreCase("100")) {
         var34 = var14.split(":");
         var29 = var34[0];
         var20 = var20.add(Restrictions.eq("invActivite", var29));
      }

      var20 = var20.addOrder(Order.desc("invDate"));
      var20 = var20.addOrder(Order.desc("invNum"));
      List var35 = var20.list();
      if (var17) {
         this.utilInitHibernate.closeSession();
      }

      return var35;
   }

   public InventaireEntete pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from InventaireEntete where invId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new InventaireEntete();
      InventaireEntete var7;
      if (var6.size() != 0) {
         var7 = (InventaireEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public InventaireEntete pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var3.createQuery("from InventaireEntete where invNum=:num and invSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      } else {
         var5 = var3.createQuery("from InventaireEntete where invNum=:num").setString("num", var1).setMaxResults(1);
      }

      List var6 = var5.list();
      new InventaireEntete();
      InventaireEntete var7;
      if (var6.size() != 0) {
         var7 = (InventaireEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
      Query var4 = var3.createQuery("from InventaireEntete where usr_id =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List rechercheInventaireByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from InventaireEntete where invDate>=:deb and invDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
