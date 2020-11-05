package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ReacheminementEnteteAchats;
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

public class ReacheminementEnteteAchatsDao implements Serializable {
   private ReacheminementEnteteAchats reacheminementEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ReacheminementEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ReacheminementEnteteAchats insert(ReacheminementEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ReacheminementEnteteAchats modif(ReacheminementEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
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

   public ReacheminementEnteteAchats modif(ReacheminementEnteteAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from ReacheminementEnteteAchats where reaId =:Id");
      var4.setParameter("Id", var1);
      var4.executeUpdate();
      return "";
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ReacheminementEnteteAchats order by reaId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            ReacheminementEnteteAchats var7 = (ReacheminementEnteteAchats)var6.get(0);
            var4 = 1L + var7.getReaId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ReacheminementEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from ReacheminementEnteteAchats where exercicesAchats.exeachId=:id and reaSerie =:ser and year(reaDate)=" + var7 + " order by reaDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      ReacheminementEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (ReacheminementEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public ReacheminementEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from ReacheminementEnteteAchats where exercicesAchats.exeachId=:id and reaSerie =:ser and year(reaDate)=" + var7 + " and month(reaDate)=" + var8 + " order by reaDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      ReacheminementEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (ReacheminementEnteteAchats)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, long var5, String var7, int var8, String var9, String var10, String var11, long var12, int var14, String var15, String var16, String var17, String var18) throws HibernateException, NamingException, ParseException {
      boolean var19 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var19 = true;
      }

      UtilDate var20 = new UtilDate();
      new ArrayList();
      Criteria var22 = var1.createCriteria(ReacheminementEnteteAchats.class);
      Calendar var23 = Calendar.getInstance();
      Date var24 = null;
      Date var25 = null;
      Date var26 = new Date();
      String var27 = var20.dateToStringFr(var26);
      String var28 = var27.substring(6, 10) + "-" + var27.substring(3, 5) + "-" + var27.substring(0, 2);
      var24 = var20.stringToDateSQL(var28 + " 00:00:00");
      var25 = var20.stringToDateSQL(var28 + " 23:59:59");
      int var29 = var26.getYear() + 1900;
      String var30;
      if (var11.equalsIgnoreCase("100")) {
         if (var17 != null && var18 != null) {
            var24 = var20.stringToDateSQL(var17 + " 00:00:00");
            var25 = var20.stringToDateSQL(var18 + " 23:59:59");
            var22 = var22.add(Restrictions.between("reaDate", var24, var25));
         } else {
            var30 = "1980-01-01";
            var20.stringToDateSQL(var30 + " 00:00:00");
            var22 = var22.add(Restrictions.isNotNull("reaDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var22 = var22.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var11.equalsIgnoreCase("0")) {
            var22 = var22.add(Restrictions.between("reaDate", var24, var25));
         } else if (var11.equalsIgnoreCase("1")) {
            var30 = "" + var23.getTime();
            if (var30.contains("Mon")) {
               var24 = var23.getTime();
            } else if (var30.contains("Tue")) {
               var23.add(7, -1);
               var24 = var23.getTime();
            } else if (var30.contains("Wed")) {
               var23.add(7, -2);
               var24 = var23.getTime();
            } else if (var30.contains("Thu")) {
               var23.add(7, -3);
               var24 = var23.getTime();
            } else if (var30.contains("Fri")) {
               var23.add(7, -4);
               var24 = var23.getTime();
            } else if (var30.contains("Sat")) {
               var23.add(7, -5);
               var24 = var23.getTime();
            } else if (var30.contains("Sun")) {
               var23.add(7, -6);
               var24 = var23.getTime();
            }

            var27 = var20.dateToStringFr(var24);
            var28 = var27.substring(6, 10) + "-" + var27.substring(3, 5) + "-" + var27.substring(0, 2);
            var24 = var20.stringToDateSQL(var28 + " 00:00:00");
            var22 = var22.add(Restrictions.between("reaDate", var24, var25));
         } else {
            String var31;
            int var34;
            if (var11.equalsIgnoreCase("2")) {
               var34 = var23.get(2) + 1;
               var31 = var29 + "-" + var34 + "-01";
               var24 = var20.stringToDateSQL(var31 + " 00:00:00");
               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("3")) {
               var34 = var23.get(2);
               var23.add(5, -var34);
               if (var34 <= 3) {
                  var31 = var29 + "-01-01";
                  var24 = var20.stringToDateSQL(var31 + " 00:00:00");
               } else if (var34 >= 4 && var34 <= 6) {
                  var31 = var29 + "-04-01";
                  var24 = var20.stringToDateSQL(var31 + " 00:00:00");
               } else if (var34 >= 7 && var34 <= 9) {
                  var31 = var29 + "-07-01";
                  var24 = var20.stringToDateSQL(var31 + " 00:00:00");
               } else if (var34 >= 10) {
                  var31 = var29 + "-10-01";
                  var24 = var20.stringToDateSQL(var31 + " 00:00:00");
               }

               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("4")) {
               var34 = var23.get(2);
               var23.add(5, -var34);
               if (var34 <= 6) {
                  var31 = var29 + "-01-01";
                  var24 = var20.stringToDateSQL(var31 + " 00:00:00");
               } else {
                  var31 = var29 + "-07-01";
                  var24 = var20.stringToDateSQL(var31 + " 00:00:00");
               }

               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("5")) {
               var30 = var29 + "-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-03-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("6")) {
               var30 = var29 + "-04-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-06-30";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("7")) {
               var30 = var29 + "-07-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-09-30";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("8")) {
               var30 = var29 + "-10-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("9")) {
               var30 = var29 + "-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-06-30";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("10")) {
               var30 = var29 + "-07-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("11")) {
               var30 = var29 + "-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("12")) {
               var30 = "1980-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 - 1 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("13")) {
               var30 = var29 - 1 + "-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("14")) {
               var30 = var29 - 1 + "-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 - 1 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("reaDate", var24, var25));
            } else if (var11.equalsIgnoreCase("20")) {
               var22.setMaxResults(20);
               var22 = var22.addOrder(Order.desc("reaId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var30 = "%" + var4 + "%";
         var22 = var22.add(Restrictions.like("reaNum", var30));
      }

      if (var5 != 0L) {
         var22 = var22.add(Restrictions.eq("tiers.tieid", var5));
      } else if (var7 != null && !var7.isEmpty()) {
         var30 = "%" + var7 + "%";
         var22 = var22.add(Restrictions.or(Restrictions.like("reaNomTiers", var30), Restrictions.like("reaDiversNom", var30)));
      }

      if (var15 != null && !var15.isEmpty()) {
         var22 = var22.add(Restrictions.eq("reaNomResponsable", var15));
      }

      if (var14 == 1) {
         var22 = var22.add(Restrictions.eq("reaIdCreateur", var12));
      }

      if (!var9.equalsIgnoreCase("100")) {
         if (var9.contains(",")) {
            String[] var35 = var9.split(",");
            int var37 = var35.length;
            String[] var32 = new String[var37];

            for(int var33 = 0; var33 < var37; ++var33) {
               var32[var33] = new String(var35[var33]);
            }

            var22 = var22.add(Restrictions.in("reaSerie", var32));
         } else {
            var22 = var22.add(Restrictions.eq("reaSerie", var9));
         }
      }

      if (!var10.equalsIgnoreCase("100")) {
         var22 = var22.add(Restrictions.eq("reaCat", var10));
      }

      if (var8 <= 10) {
         var22 = var22.add(Restrictions.eq("reaEtat", var8));
      } else if (var8 == 11) {
         var22 = var22.add(Restrictions.eq("reaSolde", 0));
      } else if (var8 == 12) {
         var22 = var22.add(Restrictions.eq("reaSolde", 1));
      }

      if (var16 != null && !var16.isEmpty()) {
         var30 = "%" + var16 + "%";
         var22 = var22.add(Restrictions.like("reaAnal4", var30));
      }

      var22 = var22.addOrder(Order.desc("reaDate"));
      var22 = var22.addOrder(Order.desc("reaNum"));
      List var36 = var22.list();
      if (var19) {
         this.utilInitHibernate.closeSession();
      }

      return var36;
   }

   public ReacheminementEnteteAchats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ReacheminementEnteteAchats where reaId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new ReacheminementEnteteAchats();
      ReacheminementEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (ReacheminementEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ReacheminementEnteteAchats pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ReacheminementEnteteAchats where reaNum=:num and reaSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new ReacheminementEnteteAchats();
      ReacheminementEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (ReacheminementEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheByDossier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ReacheminementEnteteAchats where reaAnal4 =:num").setString("num", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ReacheminementEnteteAchats pourParapheurByDossier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ReacheminementEnteteAchats where reaAnal4 =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new ReacheminementEnteteAchats();
      ReacheminementEnteteAchats var6;
      if (var5.size() != 0) {
         var6 = (ReacheminementEnteteAchats)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
      Query var4 = var3.createQuery("from ReacheminementEnteteAchats where usr_id =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public boolean verifTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ReacheminementEnteteAchats where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from ReacheminementEnteteAchats where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheReacheminementRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ReacheminementEnteteAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheReacheminementByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from ReacheminementEnteteAchats where recDate>=:deb and recDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
