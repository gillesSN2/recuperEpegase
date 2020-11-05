package com.epegase.systeme.dao;

import com.epegase.systeme.classe.AppelCharge;
import com.epegase.systeme.classe.Bien;
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

public class AppelChargeDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public AppelChargeDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public AppelCharge insert(AppelCharge var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public AppelCharge modif(AppelCharge var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public AppelCharge modif(AppelCharge var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(AppelCharge var1, Session var2) {
      var2.delete(var1);
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from AppelCharge where appchaId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public List chargerFactures(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from AppelCharge where appchaDate>=:deb and appchaDate<=:fin order by appchaNum").setDate("deb", var1).setDate("fin", var2);
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      Query var3 = var1.createQuery("from AppelCharge order by appchaId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            AppelCharge var7 = (AppelCharge)var6.get(0);
            var4 = 1L + var7.getAppchaId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public AppelCharge enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from AppelCharge where exerciceventes.exevteId=:id and appchaSerie =:ser and year(facDate)=" + var7 + " order by appchaDate desc").setParameter("id", var1).setParameter("ser", var3);
      AppelCharge var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (AppelCharge)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public AppelCharge enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from AppelCharge where exerciceventes.exevteId=:id and appchaSerie =:ser and year(facDate)=" + var7 + " and month(facDate)=" + var8 + " order by appchaDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      AppelCharge var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (AppelCharge)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, String var5, int var6, String var7, String var8, String var9, String var10, long var11, int var13, String var14, String var15, String var16, String var17, String var18, String var19) throws HibernateException, NamingException, ParseException {
      boolean var20 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var20 = true;
      }

      UtilDate var21 = new UtilDate();
      new ArrayList();
      Criteria var23 = var1.createCriteria(AppelCharge.class);
      Calendar var24 = Calendar.getInstance();
      Date var25 = null;
      Date var26 = null;
      Date var27 = new Date();
      String var28 = var21.dateToStringFr(var27);
      String var29 = var28.substring(6, 10) + "-" + var28.substring(3, 5) + "-" + var28.substring(0, 2);
      var25 = var21.stringToDateSQL(var29 + " 00:00:00");
      var26 = var21.stringToDateSQL(var29 + " 23:59:59");
      int var30 = var27.getYear() + 1900;
      String var31;
      String var32;
      if (var9.equalsIgnoreCase("100")) {
         if (var18 != null && var19 != null) {
            var25 = var21.stringToDateSQL(var18 + " 00:00:00");
            var26 = var21.stringToDateSQL(var19 + " 23:59:59");
            var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
         } else {
            var31 = "1980-01-01";
            var21.stringToDateSQL(var31 + " 00:00:00");
            var23 = var23.add(Restrictions.isNotNull("appchaDate"));
         }
      } else {
         if (!var9.equalsIgnoreCase("12") && !var9.equalsIgnoreCase("13") && !var9.equalsIgnoreCase("14")) {
            var23 = var23.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var9.equalsIgnoreCase("0")) {
            var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
         } else if (var9.equalsIgnoreCase("1")) {
            var31 = "" + var24.getTime();
            if (var31.contains("Mon")) {
               var25 = var24.getTime();
            } else if (var31.contains("Tue")) {
               var24.add(7, -1);
               var25 = var24.getTime();
            } else if (var31.contains("Wed")) {
               var24.add(7, -2);
               var25 = var24.getTime();
            } else if (var31.contains("Thu")) {
               var24.add(7, -3);
               var25 = var24.getTime();
            } else if (var31.contains("Fri")) {
               var24.add(7, -4);
               var25 = var24.getTime();
            } else if (var31.contains("Sat")) {
               var24.add(7, -5);
               var25 = var24.getTime();
            } else if (var31.contains("Sun")) {
               var24.add(7, -6);
               var25 = var24.getTime();
            }

            var28 = var21.dateToStringFr(var25);
            var29 = var28.substring(6, 10) + "-" + var28.substring(3, 5) + "-" + var28.substring(0, 2);
            var25 = var21.stringToDateSQL(var29 + " 00:00:00");
            var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
         } else {
            int var35;
            if (var9.equalsIgnoreCase("2")) {
               var35 = var24.get(2) + 1;
               var32 = var30 + "-" + var35 + "-01";
               var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("3")) {
               var35 = var24.get(2);
               var24.add(5, -var35);
               if (var35 <= 3) {
                  var32 = var30 + "-01-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               } else if (var35 >= 4 && var35 <= 6) {
                  var32 = var30 + "-04-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               } else if (var35 >= 7 && var35 <= 9) {
                  var32 = var30 + "-07-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               } else if (var35 >= 10) {
                  var32 = var30 + "-10-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               }

               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("4")) {
               var35 = var24.get(2);
               var24.add(5, -var35);
               if (var35 <= 6) {
                  var32 = var30 + "-01-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               } else {
                  var32 = var30 + "-07-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               }

               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("5")) {
               var31 = var30 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-03-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("6")) {
               var31 = var30 + "-04-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-06-30";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("7")) {
               var31 = var30 + "-07-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-09-30";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("8")) {
               var31 = var30 + "-10-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("9")) {
               var31 = var30 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-06-30";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("10")) {
               var31 = var30 + "-07-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("11")) {
               var31 = var30 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("12")) {
               var31 = "1980-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 - 1 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("13")) {
               var31 = var30 - 1 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("14")) {
               var31 = var30 - 1 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 - 1 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("appchaDate", var25, var26));
            } else if (var9.equalsIgnoreCase("20")) {
               var23.setMaxResults(20);
               var23 = var23.addOrder(Order.desc("appchaId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var31 = "%" + var4 + "%";
         var23 = var23.add(Restrictions.like("appchaNum", var31));
      }

      if (var5 != null && !var5.isEmpty()) {
         var23 = var23.add(Restrictions.like("appchaImmeuble", var5));
      }

      if (var14 != null && !var14.isEmpty()) {
         var23 = var23.add(Restrictions.eq("appchaNomContact", var14));
      }

      if (var15 != null && !var15.isEmpty()) {
         var23 = var23.add(Restrictions.eq("appchaNomResponsable", var15));
      }

      if (var16 != null && !var16.isEmpty()) {
         var23 = var23.add(Restrictions.eq("appchaNomCommercial", var16));
      }

      if (var13 == 1) {
         var23 = var23.add(Restrictions.eq("appchaIdCreateur", var11));
      }

      String[] var36;
      if (!var7.equalsIgnoreCase("100")) {
         if (var7.contains(",")) {
            var36 = var7.split(",");
            int var38 = var36.length;
            String[] var33 = new String[var38];

            for(int var34 = 0; var34 < var38; ++var34) {
               var33[var34] = new String(var36[var34]);
            }

            var23 = var23.add(Restrictions.in("appchaSerie", var33));
         } else {
            var23 = var23.add(Restrictions.eq("appchaSerie", var7));
         }
      }

      if (!var8.equalsIgnoreCase("100")) {
         var23 = var23.add(Restrictions.eq("appchaCat", var8));
      }

      if (var6 <= 10) {
         var23 = var23.add(Restrictions.eq("appchaEtat", var6));
         var23 = var23.add(Restrictions.ne("appchaBien", "AN"));
         var23 = var23.add(Restrictions.ne("appchaBien", "F.HONO."));
         var23 = var23.add(Restrictions.ne("appchaMode", 2));
      } else if (var6 == 11) {
         var23 = var23.add(Restrictions.isNotNull("appchaDateRelance"));
      } else if (var6 == 12) {
         var23 = var23.add(Restrictions.eq("appchaTotHt", 0.0D));
      } else if (var6 == 13) {
         var23 = var23.add(Restrictions.eq("appchaSolde", 0));
      } else if (var6 == 14) {
         var23 = var23.add(Restrictions.eq("appchaSolde", 1));
      } else if (var6 == 15) {
         var23 = var23.add(Restrictions.eq("appchaExoTva", 1));
      } else if (var6 == 16) {
         var23 = var23.add(Restrictions.and(Restrictions.eq("appchaExoTva", 1), Restrictions.isNull("appchaDateVisa")));
      } else if (var6 == 17) {
         var23 = var23.add(Restrictions.isNotNull("appchaDateTransfert"));
      } else if (var6 == 18) {
         var23 = var23.add(Restrictions.isNull("appchaDateTransfert"));
      } else if (var6 == 20) {
         var23 = var23.add(Restrictions.eq("appchaBien", "AN"));
      } else if (var6 == 21) {
         var23 = var23.add(Restrictions.eq("appchaBien", "F.HONO."));
      } else if (var6 == 22) {
         var23 = var23.add(Restrictions.eq("appchaMode", 2));
      }

      if (var10 != null && !var10.isEmpty() && !var10.equalsIgnoreCase("100") && var10.contains(":")) {
         var23 = var23.add(Restrictions.eq("appchaService", var10));
      }

      if (!var17.equalsIgnoreCase("100")) {
         var36 = var17.split(":");
         var32 = var36[0];
         var23 = var23.add(Restrictions.eq("appchaActivite", var32));
      }

      var23 = var23.addOrder(Order.desc("appchaDate"));
      var23 = var23.addOrder(Order.desc("appchaNum"));
      List var37 = var23.list();
      if (var20) {
         this.utilInitHibernate.closeSession();
      }

      return var37;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from AppelCharge where appchaService='" + var1 + "' and (facDateEcheReg='" + var5 + "' or appchaTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from AppelCharge where appchaDateEcheReg='" + var5 + "' or appchaTypeReg=4").list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheDejaPayer(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      List var6 = var3.createQuery("from AppelCharge where appchaTotReglement<>0 and appchaDate>=:d1 and appchaDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from AppelCharge where appchaDate>=:deb and appchaDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public AppelCharge pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from AppelCharge where appchaId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new AppelCharge();
      AppelCharge var7;
      if (var6.size() != 0) {
         var7 = (AppelCharge)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public AppelCharge pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from AppelCharge where appchaNum =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new AppelCharge();
      AppelCharge var6;
      if (var5.size() != 0) {
         var6 = (AppelCharge)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public AppelCharge pourContrat(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from AppelCharge where appchaContrat =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new AppelCharge();
      AppelCharge var6;
      if (var5.size() != 0) {
         var6 = (AppelCharge)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public AppelCharge pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from AppelCharge where appchaNum=:num and appchaSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new AppelCharge();
      AppelCharge var7;
      if (var6.size() != 0) {
         var7 = (AppelCharge)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public AppelCharge pourParapheur(long var1, long var3, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var7 = true;
      }

      Query var8 = var6.createQuery("from AppelCharge where bien=:bien and appchaIdTiers=:tie and appchaPeriode=:per").setLong("bien", var1).setLong("tie", var3).setString("per", var5).setMaxResults(1);
      List var9 = var8.list();
      new AppelCharge();
      AppelCharge var10;
      if (var9.size() != 0) {
         var10 = (AppelCharge)var9.get(0);
      } else {
         var10 = null;
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public AppelCharge pourParapheur(long var1, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var6 = true;
      }

      Query var7 = var5.createQuery("from AppelCharge where bien=:bien and appchaBien=:typ and appchaPeriode=:per").setLong("bien", var1).setString("typ", var3).setString("per", var4).setMaxResults(1);
      List var8 = var7.list();
      new AppelCharge();
      AppelCharge var9;
      if (var8.size() != 0) {
         var9 = (AppelCharge)var8.get(0);
      } else {
         var9 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List rechercheFactureATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from AppelCharge where (appchaEtat=0 or appchaEtat=1 or appchaEtat=4) and appchaDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from AppelCharge where (appchaEtat=0 or appchaEtat=1 or appchaEtat=4) and appchaDateTransfert is NULL and appchaDateDebut>=:dte1 and appchaDateDebut<=:dte2 and appchaNum>=:p1 and appchaNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from AppelCharge where (appchaEtat=0 or appchaEtat=1 or appchaEtat=4) and appchaDateTransfert is NULL and appchaDateDebut>=:dte1 and appchaDateDebut<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from AppelCharge where (appchaEtat=1 or appchaEtat=4) and appchaDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from AppelCharge where (appchaEtat=1 or appchaEtat=4) and appchaDateTransfert is NULL and appchaDateDebut>=:dte1 and appchaDateDebut<=:dte2 and appchaNum>=:p1 and appchaNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from AppelCharge where (appchaEtat=1 or appchaEtat=4) and appchaDateTransfert is NULL and appchaDateDebut>=:dte1 and appchaDateDebut<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheFactureDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from AppelCharge where (facEtat=0 or appchaEtat=1 or appchaEtat=4) and (facDateTransfert<>'' and appchaDateTransfert is not null) and (facDate>=:dte1 and appchaDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from AppelCharge where " + var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
      Query var4 = var3.createQuery("from AppelCharge where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from AppelCharge where appchaIdTiers=:tie").setLong("tie", var1.getTieid()).setMaxResults(1);
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

   public List rechercheNonSoldeTiers(long var1, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var6 = true;
      }

      List var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         var7 = var4.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaSolde=0 and appchaEtat>=1 and appchaSerie=:ser order by appchaDate desc").setLong("tie", var1).setString("ser", var3).list();
      } else {
         var7 = var4.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaSolde=0 and appchaEtat>=1 order by appchaDate desc").setLong("tie", var1).list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheNonSoldeTiersMode(long var1, long var3, int var5, String var6, Date var7, Session var8) throws HibernateException, NamingException {
      new ArrayList();
      boolean var10 = false;
      if (var8 == null) {
         var8 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var10 = true;
      }

      List var11 = null;
      if (var3 == 0L) {
         if (var5 == 99) {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).list();
         } else if (var5 == 1) {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaMode=1 order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).list();
         } else if (var5 == 2) {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaMode=2 order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).list();
         } else {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaMode=0 order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).list();
         }
      } else if (var5 == 99) {
         if (var6 != null && !var6.isEmpty()) {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaSolde=0 and appchaEtat>=1) or (appchaDateDebut=:deb)) and appchaSerie=:ser and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setString("ser", var6).setDate("deb", var7).list();
         } else {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaSolde=0 and appchaEtat>=1) or (appchaDateDebut=:deb)) and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setDate("deb", var7).list();
         }
      } else if (var5 == 1) {
         if (var6 != null && !var6.isEmpty()) {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaSolde=0 and appchaEtat>=1) or (appchaDateDebut=:deb)) and appchaSerie=:ser and appchaMode=1 and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setString("ser", var6).setDate("deb", var7).list();
         } else {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaSolde=0 and appchaEtat>=1) or (appchaDateDebut=:deb)) and appchaMode=1 order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setDate("deb", var7).list();
         }
      } else if (var5 == 2) {
         if (var6 != null && !var6.isEmpty()) {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaSolde=0 and appchaEtat>=1) or (appchaDateDebut=:deb)) and appchaSerie=:ser and appchaMode=2 and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setString("ser", var6).setDate("deb", var7).list();
         } else {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaSolde=0 and appchaEtat>=1) or (appchaDateDebut=:deb)) and appchaMode=2 and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setDate("deb", var7).list();
         }
      } else if (var6 != null && !var6.isEmpty()) {
         var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaSolde=0 and appchaEtat>=1) or (appchaDateDebut=:deb)) and appchaSerie=:ser and appchaMode=0 and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setString("ser", var6).setDate("deb", var7).list();
      } else {
         var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaSolde=0 and appchaEtat>=1) or (appchaDateDebut=:deb)) and appchaMode=0 and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setDate("deb", var7).list();
      }

      if (var10) {
         this.utilInitHibernate.closeSession();
      }

      return var11;
   }

   public List rechercheNonSoldeTiersMode(long var1, long var3, int var5, Date var6, Date var7, Session var8) throws HibernateException, NamingException {
      new ArrayList();
      boolean var10 = false;
      if (var8 == null) {
         var8 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var10 = true;
      }

      List var11 = null;
      if (var3 == 0L) {
         if (var5 == 99) {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaDateDebut>=:deb and appchaDateDebut<=:fin) or (appchaDate>=:deb and appchaDate<=:fin)) order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setDate("deb", var6).setDate("fin", var7).list();
         } else if (var5 == 1) {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaMode=1 and ((appchaDateDebut>=:deb and appchaDateDebut<=:fin) or (appchaDate>=:deb and appchaDate<=:fin)) order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setDate("deb", var6).setDate("fin", var7).list();
         } else if (var5 == 2) {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaMode=2 and ((appchaDateDebut>=:deb and appchaDateDebut<=:fin) or (appchaDate>=:deb and appchaDate<=:fin)) order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setDate("deb", var6).setDate("fin", var7).list();
         } else {
            var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaMode=0 and ((appchaDateDebut>=:deb and appchaDateDebut<=:fin) or (appchaDate>=:deb and appchaDate<=:fin)) order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setDate("deb", var6).setDate("fin", var7).list();
         }
      } else if (var5 == 99) {
         var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaDateDebut>=:deb and appchaDateDebut<=:fin) or (appchaDate>=:deb and appchaDate<=:fin)) and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setDate("deb", var6).setDate("fin", var7).list();
      } else if (var5 == 1) {
         var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaDateDebut>=:deb and appchaDateDebut<=:fin) or (appchaDate>=:deb and appchaDate<=:fin)) and appchaMode=1 order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setDate("deb", var6).setDate("fin", var7).list();
      } else if (var5 == 2) {
         var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaDateDebut>=:deb and appchaDateDebut<=:fin) or (appchaDate>=:deb and appchaDate<=:fin)) and appchaMode=2 and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setDate("deb", var6).setDate("fin", var7).list();
      } else {
         var11 = var8.createQuery("from AppelCharge where appchaIdTiers=:tie and ((appchaDateDebut>=:deb and appchaDateDebut<=:fin) or (appchaDate>=:deb and appchaDate<=:fin)) and appchaMode=0 and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).setDate("deb", var6).setDate("fin", var7).list();
      }

      if (var10) {
         this.utilInitHibernate.closeSession();
      }

      return var11;
   }

   public List rechercheNonSoldeTiersMode(long var1, long var3, int var5, Session var6) throws HibernateException, NamingException {
      new ArrayList();
      boolean var8 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var8 = true;
      }

      List var9 = null;
      if (var3 == 0L) {
         if (var5 == 99) {
            var9 = var6.createQuery("from AppelCharge where appchaIdTiers=:tie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).list();
         } else if (var5 == 1) {
            var9 = var6.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaMode=1 order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).list();
         } else if (var5 == 2) {
            var9 = var6.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaMode=2 order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).list();
         } else {
            var9 = var6.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaMode=0 order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).list();
         }
      } else if (var5 == 99) {
         var9 = var6.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).list();
      } else if (var5 == 1) {
         var9 = var6.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaSerie=:ser and appchaMode=1 and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).list();
      } else if (var5 == 2) {
         var9 = var6.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaSerie=:ser and appchaMode=2 and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).list();
      } else {
         var9 = var6.createQuery("from AppelCharge where appchaIdTiers=:tie and appchaSerie=:ser and appchaMode=0 and appchaIdImmeuble=:bie order by appchaIdTiers asc, appchaDate desc").setLong("tie", var1).setLong("bie", var3).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      List var5 = var2.createQuery("from AppelCharge where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List verifByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      List var5 = var2.createQuery("from AppelCharge where tiers=:tie").setParameter("tie", var1).setMaxResults(1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCommissions(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      List var6 = var3.createQuery("from AppelCharge where appchaSolde=1 and appchaDate>=:d1 and appchaDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFacturePeriode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      List var6 = var3.createQuery("from AppelCharge where appchaDate>=:d1 and appchaDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureCampagne(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var6 = true;
      }

      List var7 = var4.createQuery("from AppelCharge where appchaDate>=:d1 and appchaSource like '" + var3 + "%'").setString("d1", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerAppelByBien(Bien var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      Query var6 = var4.createQuery("from AppelCharge where bien=:bi and (appchaDate>=:dteDeb and appchaDate<=:dteFin or appchaSolde=0)").setParameter("bi", var1).setDate("dteDeb", var2).setDate("dteFin", var3);
      new ArrayList();
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
