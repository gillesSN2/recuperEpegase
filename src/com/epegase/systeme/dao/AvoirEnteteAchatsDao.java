package com.epegase.systeme.dao;

import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.ExercicesAchats;
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

public class AvoirEnteteAchatsDao implements Serializable {
   private AvoirEnteteAchats avoirEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public AvoirEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public AvoirEnteteAchats insert(AvoirEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public AvoirEnteteAchats modif(AvoirEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
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

   public AvoirEnteteAchats modif(AvoirEnteteAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from AvoirEnteteAchats where avfId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from AvoirEnteteAchats order by avfId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            AvoirEnteteAchats var7 = (AvoirEnteteAchats)var6.get(0);
            var4 = 1L + var7.getAvfId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public AvoirEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from AvoirEnteteAchats where exercicesAchats.exeachId=:id and avfSerie =:ser and year(avfDate)=" + var7 + " order by avfDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      AvoirEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (AvoirEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public AvoirEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from AvoirEnteteAchats where exercicesAchats.exeachId=:id and avfSerie =:ser and year(avfDate)=" + var7 + " and month(avfDate)=" + var8 + " order by avfDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      AvoirEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (AvoirEnteteAchats)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, String var5, int var6, String var7, String var8, String var9, String var10, long var11, int var13, String var14, String var15, String var16, String var17, String var18, String var19, String var20) throws HibernateException, NamingException, ParseException {
      boolean var21 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var21 = true;
      }

      UtilDate var22 = new UtilDate();
      new ArrayList();
      Criteria var24 = var1.createCriteria(AvoirEnteteAchats.class);
      Calendar var25 = Calendar.getInstance();
      Date var26 = null;
      Date var27 = null;
      Date var28 = new Date();
      String var29 = var22.dateToStringFr(var28);
      String var30 = var29.substring(6, 10) + "-" + var29.substring(3, 5) + "-" + var29.substring(0, 2);
      var26 = var22.stringToDateSQL(var30 + " 00:00:00");
      var27 = var22.stringToDateSQL(var30 + " 23:59:59");
      int var31 = var28.getYear() + 1900;
      String var32;
      String var33;
      if (var9.equalsIgnoreCase("100")) {
         if (var19 != null && var20 != null) {
            var26 = var22.stringToDateSQL(var19 + " 00:00:00");
            var27 = var22.stringToDateSQL(var20 + " 23:59:59");
            var24 = var24.add(Restrictions.between("avfDate", var26, var27));
         } else {
            var32 = "1980-01-01";
            var22.stringToDateSQL(var32 + " 00:00:00");
            var24 = var24.add(Restrictions.isNotNull("avfDate"));
         }
      } else {
         if (!var9.equalsIgnoreCase("12") && !var9.equalsIgnoreCase("13") && !var9.equalsIgnoreCase("14")) {
            var24 = var24.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var9.equalsIgnoreCase("0")) {
            var24 = var24.add(Restrictions.between("avfDate", var26, var27));
         } else if (var9.equalsIgnoreCase("1")) {
            var32 = "" + var25.getTime();
            if (var32.contains("Mon")) {
               var26 = var25.getTime();
            } else if (var32.contains("Tue")) {
               var25.add(7, -1);
               var26 = var25.getTime();
            } else if (var32.contains("Wed")) {
               var25.add(7, -2);
               var26 = var25.getTime();
            } else if (var32.contains("Thu")) {
               var25.add(7, -3);
               var26 = var25.getTime();
            } else if (var32.contains("Fri")) {
               var25.add(7, -4);
               var26 = var25.getTime();
            } else if (var32.contains("Sat")) {
               var25.add(7, -5);
               var26 = var25.getTime();
            } else if (var32.contains("Sun")) {
               var25.add(7, -6);
               var26 = var25.getTime();
            }

            var29 = var22.dateToStringFr(var26);
            var30 = var29.substring(6, 10) + "-" + var29.substring(3, 5) + "-" + var29.substring(0, 2);
            var26 = var22.stringToDateSQL(var30 + " 00:00:00");
            var24 = var24.add(Restrictions.between("avfDate", var26, var27));
         } else {
            int var36;
            if (var9.equalsIgnoreCase("2")) {
               var36 = var25.get(2) + 1;
               var33 = var31 + "-" + var36 + "-01";
               var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("3")) {
               var36 = var25.get(2);
               var25.add(5, -var36);
               if (var36 <= 3) {
                  var33 = var31 + "-01-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               } else if (var36 >= 4 && var36 <= 6) {
                  var33 = var31 + "-04-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               } else if (var36 >= 7 && var36 <= 9) {
                  var33 = var31 + "-07-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               } else if (var36 >= 10) {
                  var33 = var31 + "-10-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               }

               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("4")) {
               var36 = var25.get(2);
               var25.add(5, -var36);
               if (var36 <= 6) {
                  var33 = var31 + "-01-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               } else {
                  var33 = var31 + "-07-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               }

               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("5")) {
               var32 = var31 + "-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-03-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("6")) {
               var32 = var31 + "-04-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-06-30";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("7")) {
               var32 = var31 + "-07-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-09-30";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("8")) {
               var32 = var31 + "-10-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("9")) {
               var32 = var31 + "-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-06-30";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("10")) {
               var32 = var31 + "-07-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("11")) {
               var32 = var31 + "-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("12")) {
               var32 = "1980-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 - 1 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("13")) {
               var32 = var31 - 1 + "-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("14")) {
               var32 = var31 - 1 + "-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 - 1 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("avfDate", var26, var27));
            } else if (var9.equalsIgnoreCase("20")) {
               var24.setMaxResults(20);
               var24 = var24.addOrder(Order.desc("avfId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var32 = "%" + var4 + "%";
         var24 = var24.add(Restrictions.like("avfNum", var32));
      }

      if (var5 != null && !var5.isEmpty()) {
         var32 = "";
         if (var5.startsWith("*")) {
            var32 = "%" + var5.substring(1) + "%";
         } else {
            var32 = var5 + "%";
         }

         var24 = var24.add(Restrictions.or(Restrictions.like("avfNomTiers", var32), Restrictions.like("avfDiversNom", var32)));
      }

      if (var15 != null && !var15.isEmpty()) {
         var24 = var24.add(Restrictions.eq("avfNomResponsable", var15));
      }

      if (var13 == 1) {
         var24 = var24.add(Restrictions.eq("avfIdCreateur", var11));
      }

      String[] var37;
      if (!var7.equalsIgnoreCase("100")) {
         if (var7.contains(",")) {
            var37 = var7.split(",");
            int var38 = var37.length;
            String[] var34 = new String[var38];

            for(int var35 = 0; var35 < var38; ++var35) {
               var34[var35] = new String(var37[var35]);
            }

            var24 = var24.add(Restrictions.in("avfSerie", var34));
         } else {
            var24 = var24.add(Restrictions.eq("avfSerie", var7));
         }
      }

      if (!var8.equalsIgnoreCase("100")) {
         var24 = var24.add(Restrictions.eq("avfCat", var8));
      }

      if (var6 <= 10) {
         var24 = var24.add(Restrictions.eq("avfEtat", var6));
      } else if (var6 == 11) {
         var24 = var24.add(Restrictions.isNotNull("avfDateRelance"));
      } else if (var6 == 12) {
         var24 = var24.add(Restrictions.eq("avfTotHt", 0.0D));
      } else if (var6 == 13) {
         var24 = var24.add(Restrictions.eq("avfSolde", 0));
      } else if (var6 == 14) {
         var24 = var24.add(Restrictions.eq("avfSolde", 1));
      } else if (var6 == 15) {
         var24 = var24.add(Restrictions.eq("avfExoTva", 1));
      } else if (var6 == 17) {
         var24 = var24.add(Restrictions.isNotNull("avfDateTransfert"));
      } else if (var6 == 18) {
         var24 = var24.add(Restrictions.isNull("avfDateTransfert"));
      }

      if (var10 != null && !var10.isEmpty() && !var10.equalsIgnoreCase("100") && var10.contains(":")) {
         var24 = var24.add(Restrictions.eq("avfService", var10));
      }

      if (!var16.equalsIgnoreCase("100")) {
         var37 = var16.split(":");
         var33 = var37[0];
         var24 = var24.add(Restrictions.eq("avfActivite", var33));
      }

      if (!var14.equalsIgnoreCase("100")) {
         var37 = var14.split(":");
         var33 = var37[0];
         var24 = var24.add(Restrictions.eq("avfBudget", var33));
      }

      if (var17 != null && !var17.isEmpty()) {
         var32 = "%" + var17 + "%";
         var24 = var24.add(Restrictions.or(Restrictions.like("avfAffaire", var32), Restrictions.like("avfAnal4", var32)));
      }

      if (var18 != null && !var18.isEmpty()) {
         var32 = "%" + var18 + "%";
         var24 = var24.add(Restrictions.like("avfAnal4", var32));
      }

      var24 = var24.addOrder(Order.desc("avfDate"));
      var24 = var24.addOrder(Order.desc("avfNum"));
      List var39 = var24.list();
      if (var21) {
         this.utilInitHibernate.closeSession();
      }

      return var39;
   }

   public AvoirEnteteAchats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from AvoirEnteteAchats where avfId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new AvoirEnteteAchats();
      AvoirEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (AvoirEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public AvoirEnteteAchats pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from AvoirEnteteAchats where avfNum=:num and avfSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new AvoirEnteteAchats();
      AvoirEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (AvoirEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheAvoirATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from AvoirEnteteAchats where (avfEtat=0 or avfEtat=1 or avfEtat=4) and avfDateTransfert is NULL ").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from AvoirEnteteAchats where (avfEtat=0 or avfEtat=1 or avfEtat=4) and avfDateTransfert is NULL and avfDate>=:dte1 and avfDate<=:dte2 and avfNum>=:p1 and avfNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from AvoirEnteteAchats where (avfEtat=0 or avfEtat=1 or avfEtat=4) and avfDateTransfert is NULL and avfDate>=:dte1 and avfDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from AvoirEnteteAchats where (avfEtat=1 or avfEtat=4) and avfDateTransfert is NULL ").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from AvoirEnteteAchats where (avfEtat=1 or avfEtat=4) and avfDateTransfert is NULL and avfDate>=:dte1 and avfDate<=:dte2 and avfNum>=:p1 and avfNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from AvoirEnteteAchats where (avfEtat=1 or avfEtat=4) and avfDateTransfert is NULL and avfDate>=:dte1 and avfDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheAvoirDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from AvoirEnteteAchats where (avfEtat=0 or avfEtat=1 or avfEtat=4) and (avfDateTransfert <> '' and avfDateTransfert is not NULL) and (avfDate>=:dte1 and avfDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
      Query var4 = var3.createQuery("from AvoirEnteteAchats where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from AvoirEnteteAchats where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from AvoirEnteteAchats where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheAvoirRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from AvoirEnteteAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheAvoirByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from AvoirEnteteAchats where avfDate>=:deb and avfDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheAvoirCampagne(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from AvoirEnteteAchats where avfSource like '" + var1 + "%'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
