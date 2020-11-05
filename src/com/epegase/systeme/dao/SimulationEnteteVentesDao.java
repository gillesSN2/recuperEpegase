package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.SimulationEnteteVentes;
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

public class SimulationEnteteVentesDao implements Serializable {
   private SimulationEnteteVentes simulationEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public SimulationEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public SimulationEnteteVentes insert(SimulationEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SimulationEnteteVentes modif(SimulationEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public SimulationEnteteVentes modif(SimulationEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SimulEnteteLight");
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

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from SimulationEnteteVentes where simcrtId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "SimulEnteteLight");
         var2 = true;
      }

      Query var3 = var1.createQuery("from SimulationEnteteVentes order by simcrtId desc").setMaxResults(1);
      long var4 = 1L;
      if (var3.list() != null) {
         List var6 = var3.list();
         if (var6.size() > 0) {
            SimulationEnteteVentes var7 = (SimulationEnteteVentes)var6.get(0);
            var4 = 1L + var7.getSimcrtId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public SimulationEnteteVentes selectByNum(Session var1, String var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "SimulEnteteLight");
         var3 = true;
      }

      SimulationEnteteVentes var4 = new SimulationEnteteVentes();
      Query var5 = var1.createQuery("from SimulationEnteteVentes where simcrtNum =:numero");
      var5.setParameter("numero", var2);
      var5.setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = (SimulationEnteteVentes)var6.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public SimulationEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "SimulEnteteLight");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from SimulationEnteteVentes where exerciceventes.exevteId=:id and simcrtSerie =:ser and year(simcrtDate)=" + var7 + " order by simcrtDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      SimulationEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (SimulationEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public SimulationEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "SimulEnteteLight");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from SimulationEnteteVentes where exerciceventes.exevteId=:id and simcrtSerie =:ser and year(simcrtDate)=" + var7 + " and month(simcrtDate)=" + var8 + " order by simcrtDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      SimulationEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (SimulationEnteteVentes)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, long var5, String var7, int var8, String var9, String var10, String var11, long var12, long var14, int var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23) throws HibernateException, NamingException, ParseException {
      boolean var24 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "SimulEnteteLight");
         var24 = true;
      }

      UtilDate var25 = new UtilDate();
      new ArrayList();
      Criteria var27 = var1.createCriteria(SimulationEnteteVentes.class);
      Calendar var28 = Calendar.getInstance();
      Date var29 = null;
      Date var30 = null;
      Date var31 = new Date();
      String var32 = var25.dateToStringFr(var31);
      String var33 = var32.substring(6, 10) + "-" + var32.substring(3, 5) + "-" + var32.substring(0, 2);
      var29 = var25.stringToDateSQL(var33 + " 00:00:00");
      var30 = var25.stringToDateSQL(var33 + " 23:59:59");
      int var34 = var31.getYear() + 1900;
      String var35;
      String var36;
      if (var11.equalsIgnoreCase("100")) {
         if (var19 != null && var20 != null) {
            var29 = var25.stringToDateSQL(var19 + " 00:00:00");
            var30 = var25.stringToDateSQL(var20 + " 23:59:59");
            System.out.println("d1 " + var29 + " d2 " + var30);
            var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
         } else {
            var35 = "1980-01-01";
            var25.stringToDateSQL(var35 + " 00:00:00");
            var27 = var27.add(Restrictions.isNotNull("simcrtDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var27 = var27.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var11.equalsIgnoreCase("0")) {
            var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
         } else if (var11.equalsIgnoreCase("1")) {
            var35 = "" + var28.getTime();
            if (var35.contains("Mon")) {
               var29 = var28.getTime();
            } else if (var35.contains("Tue")) {
               var28.add(7, -1);
               var29 = var28.getTime();
            } else if (var35.contains("Wed")) {
               var28.add(7, -2);
               var29 = var28.getTime();
            } else if (var35.contains("Thu")) {
               var28.add(7, -3);
               var29 = var28.getTime();
            } else if (var35.contains("Fri")) {
               var28.add(7, -4);
               var29 = var28.getTime();
            } else if (var35.contains("Sat")) {
               var28.add(7, -5);
               var29 = var28.getTime();
            } else if (var35.contains("Sun")) {
               var28.add(7, -6);
               var29 = var28.getTime();
            }

            var32 = var25.dateToStringFr(var29);
            var33 = var32.substring(6, 10) + "-" + var32.substring(3, 5) + "-" + var32.substring(0, 2);
            var29 = var25.stringToDateSQL(var33 + " 00:00:00");
            var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
         } else {
            int var37;
            if (var11.equalsIgnoreCase("2")) {
               var37 = var28.get(2) + 1;
               var36 = var34 + "-" + var37 + "-01";
               var29 = var25.stringToDateSQL(var36 + " 00:00:00");
               var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
            } else if (var11.equalsIgnoreCase("3")) {
               var37 = var28.get(2);
               var28.add(5, -var37);
               if (var37 <= 3) {
                  var36 = var34 + "-01-01";
                  var29 = var25.stringToDateSQL(var36 + " 00:00:00");
               } else if (var37 >= 4 && var37 <= 6) {
                  var36 = var34 + "-04-01";
                  var29 = var25.stringToDateSQL(var36 + " 00:00:00");
               } else if (var37 >= 7 && var37 <= 9) {
                  var36 = var34 + "-07-01";
                  var29 = var25.stringToDateSQL(var36 + " 00:00:00");
               } else if (var37 >= 10) {
                  var36 = var34 + "-10-01";
                  var29 = var25.stringToDateSQL(var36 + " 00:00:00");
               }

               var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
            } else if (var11.equalsIgnoreCase("4")) {
               var37 = var28.get(2);
               var28.add(5, -var37);
               if (var37 <= 6) {
                  var36 = var34 + "-01-01";
                  var29 = var25.stringToDateSQL(var36 + " 00:00:00");
               } else {
                  var36 = var34 + "-07-01";
                  var29 = var25.stringToDateSQL(var36 + " 00:00:00");
               }

               var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
            } else if (var11.equalsIgnoreCase("5")) {
               var35 = var34 + "-01-01";
               var29 = var25.stringToDateSQL(var35 + " 00:00:00");
               var36 = var34 + "-03-31";
               var30 = var25.stringToDateSQL(var36 + " 23:59:59");
               var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
            } else if (var11.equalsIgnoreCase("6")) {
               var35 = var34 + "-04-01";
               var29 = var25.stringToDateSQL(var35 + " 00:00:00");
               var36 = var34 + "-06-30";
               var30 = var25.stringToDateSQL(var36 + " 23:59:59");
               var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
            } else if (var11.equalsIgnoreCase("7")) {
               var35 = var34 + "-07-01";
               var29 = var25.stringToDateSQL(var35 + " 00:00:00");
               var36 = var34 + "-09-30";
               var30 = var25.stringToDateSQL(var36 + " 23:59:59");
               var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
            } else if (var11.equalsIgnoreCase("8")) {
               var35 = var34 + "-10-01";
               var29 = var25.stringToDateSQL(var35 + " 00:00:00");
               var36 = var34 + "-12-31";
               var30 = var25.stringToDateSQL(var36 + " 23:59:59");
               var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
            } else if (var11.equalsIgnoreCase("9")) {
               var35 = var34 + "-01-01";
               var29 = var25.stringToDateSQL(var35 + " 00:00:00");
               var36 = var34 + "-06-30";
               var30 = var25.stringToDateSQL(var36 + " 23:59:59");
               var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
            } else if (var11.equalsIgnoreCase("10")) {
               var35 = var34 + "-07-01";
               var29 = var25.stringToDateSQL(var35 + " 00:00:00");
               var36 = var34 + "-12-31";
               var30 = var25.stringToDateSQL(var36 + " 23:59:59");
               var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
            } else if (var11.equalsIgnoreCase("11")) {
               var35 = var34 + "-01-01";
               var29 = var25.stringToDateSQL(var35 + " 00:00:00");
               var36 = var34 + "-12-31";
               var30 = var25.stringToDateSQL(var36 + " 23:59:59");
               var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
            } else if (var11.equalsIgnoreCase("12")) {
               var35 = "1980-01-01";
               var29 = var25.stringToDateSQL(var35 + " 00:00:00");
               var36 = var34 - 1 + "-12-31";
               var30 = var25.stringToDateSQL(var36 + " 23:59:59");
               var27 = var27.add(Restrictions.between("simcrtDate", var29, var30));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var35 = "%" + var4 + "%";
         var27 = var27.add(Restrictions.like("simcrtNum", var35));
      }

      if (var5 != 0L) {
         var27 = var27.add(Restrictions.eq("tiers.tieid", var5));
      } else if (var7 != null && !var7.isEmpty()) {
         var35 = "%" + var7 + "%";
         var27 = var27.add(Restrictions.like("simcrtNomTiers", var35));
      }

      if (var17 != null && !var17.isEmpty()) {
         var27 = var27.add(Restrictions.eq("simcrtNomContact", var17));
      }

      if (var12 != 0L) {
         var27 = var27.add(Restrictions.eq("simcrtIdResponsable", var12));
      }

      if (var16 == 1 || var16 == 2) {
         var27 = var27.add(Restrictions.eq("simcrtIdCreateur", var14));
      }

      if (!var9.equalsIgnoreCase("100")) {
         var27 = var27.add(Restrictions.eq("simcrtSerie", var9));
      }

      if (!var10.equalsIgnoreCase("100")) {
         var27 = var27.add(Restrictions.eq("simcrtCat", var10));
      }

      if (var8 <= 10) {
         var27 = var27.add(Restrictions.eq("simcrtEtat", var8));
      } else if (var8 == 11) {
         var27 = var27.add(Restrictions.isNotNull("simcrtDateRelance"));
      } else if (var8 == 12) {
         var27 = var27.add(Restrictions.eq("simcrtTotHt", 0));
      } else if (var8 == 15) {
         var27 = var27.add(Restrictions.eq("simcrtExoTva", 1));
      }

      String[] var38;
      if (!var18.equalsIgnoreCase("100")) {
         var38 = var18.split(":");
         var36 = var38[0];
         var27 = var27.add(Restrictions.eq("simcrtActivite", var36));
      }

      if (var21 != null && !var21.isEmpty() && var21.contains(":")) {
         var38 = var21.split(":");
         var36 = var38[0];
         var27 = var27.add(Restrictions.eq("simcrtRegion", var36));
      }

      if (var22 != null && !var22.isEmpty() && var22.contains(":")) {
         var38 = var22.split(":");
         var36 = var38[0];
         var27 = var27.add(Restrictions.eq("simcrtSecteur", var36));
      }

      if (var23 != null && !var23.isEmpty() && var23.contains(":")) {
         var38 = var23.split(":");
         var36 = var38[0];
         var27 = var27.add(Restrictions.eq("simcrtPdv", var36));
      }

      var27 = var27.addOrder(Order.desc("simcrtNum"));
      List var39 = var27.list();
      if (var24) {
         this.utilInitHibernate.closeSession();
      }

      return var39;
   }

   public SimulationEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SimulEnteteLight");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SimulationEnteteVentes where simcrtId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new SimulationEnteteVentes();
      SimulationEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (SimulationEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public SimulationEnteteVentes pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SimulEnteteLight");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SimulationEnteteVentes where simcrtNum=:num and simcrtSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new SimulationEnteteVentes();
      SimulationEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (SimulationEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SimulEnteteLight");
      Query var4 = var3.createQuery("from SimulationEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }
}
