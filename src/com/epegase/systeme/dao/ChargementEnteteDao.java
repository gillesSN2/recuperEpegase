package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ChargementEntete;
import com.epegase.systeme.classe.ExercicesVentes;
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

public class ChargementEnteteDao implements Serializable {
   private ChargementEntete chargementEntete;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ChargementEnteteDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ChargementEntete insert(ChargementEntete var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ChargementEntete modif(ChargementEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
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

   public ChargementEntete modif(ChargementEntete var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from ChargementEntete where chamobId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public void delete(ChargementEntete var1, Session var2) {
      var2.delete(var1);
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ChargementEntete order by chamobId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            ChargementEntete var7 = (ChargementEntete)var6.get(0);
            var4 = 1L + var7.getChamobId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ChargementEntete enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from ChargementEntete where exerciceventes.exevteId=:id and chamobSerie =:ser and year(chamobDate)=" + var7 + " order by chamobDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      ChargementEntete var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (ChargementEntete)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public ChargementEntete enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from ChargementEntete where exerciceventes.exevteId=:id and chamobSerie =:ser and year(chamobDate)=" + var7 + " and month(chamobDate)=" + var8 + " order by chamobDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      ChargementEntete var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (ChargementEntete)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, int var5, String var6, String var7, String var8, String var9, long var10, int var12, String var13, String var14, String var15, String var16, String var17, String var18) throws HibernateException, NamingException, ParseException {
      boolean var19 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var19 = true;
      }

      UtilDate var20 = new UtilDate();
      new ArrayList();
      Criteria var22 = var1.createCriteria(ChargementEntete.class);
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
      String var31;
      if (var8.equalsIgnoreCase("100")) {
         if (var17 != null && var18 != null) {
            var24 = var20.stringToDateSQL(var17 + " 00:00:00");
            var25 = var20.stringToDateSQL(var18 + " 23:59:59");
            var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
         } else {
            var30 = "1980-01-01";
            var20.stringToDateSQL(var30 + " 00:00:00");
            var22 = var22.add(Restrictions.isNotNull("chamobDate"));
         }
      } else {
         if (!var8.equalsIgnoreCase("12") && !var8.equalsIgnoreCase("13") && !var8.equalsIgnoreCase("14")) {
            var22 = var22.add(Restrictions.eq("exercicesVentes.exevteId", var2));
         }

         if (var8.equalsIgnoreCase("0")) {
            var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
         } else if (var8.equalsIgnoreCase("1")) {
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
            var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
         } else {
            int var34;
            if (var8.equalsIgnoreCase("2")) {
               var34 = var23.get(2) + 1;
               var31 = var29 + "-" + var34 + "-01";
               var24 = var20.stringToDateSQL(var31 + " 00:00:00");
               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("3")) {
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

               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("4")) {
               var34 = var23.get(2);
               var23.add(5, -var34);
               if (var34 <= 6) {
                  var31 = var29 + "-01-01";
                  var24 = var20.stringToDateSQL(var31 + " 00:00:00");
               } else {
                  var31 = var29 + "-07-01";
                  var24 = var20.stringToDateSQL(var31 + " 00:00:00");
               }

               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("5")) {
               var30 = var29 + "-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-03-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("6")) {
               var30 = var29 + "-04-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-06-30";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("7")) {
               var30 = var29 + "-07-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-09-30";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("8")) {
               var30 = var29 + "-10-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("9")) {
               var30 = var29 + "-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-06-30";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("10")) {
               var30 = var29 + "-07-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("11")) {
               var30 = var29 + "-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("12")) {
               var30 = "1980-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 - 1 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("13")) {
               var30 = var29 - 1 + "-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("14")) {
               var30 = var29 - 1 + "-01-01";
               var24 = var20.stringToDateSQL(var30 + " 00:00:00");
               var31 = var29 - 1 + "-12-31";
               var25 = var20.stringToDateSQL(var31 + " 23:59:59");
               var22 = var22.add(Restrictions.between("chamobDate", var24, var25));
            } else if (var8.equalsIgnoreCase("20")) {
               var22.setMaxResults(20);
               var22 = var22.addOrder(Order.desc("chamobId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var30 = "%" + var4 + "%";
         var22 = var22.add(Restrictions.like("chamobNum", var30));
      }

      if (var13 != null && !var13.isEmpty()) {
         var22 = var22.add(Restrictions.eq("chamobNomResponsable", var13));
      }

      if (var14 != null && !var14.isEmpty()) {
         var22 = var22.add(Restrictions.eq("chamobNomCommercial", var14));
      }

      if (var12 == 1 || var12 == 2) {
         var22 = var22.add(Restrictions.eq("chamobIdCreateur", var10));
      }

      String[] var35;
      if (!var6.equalsIgnoreCase("100")) {
         if (var6.contains(",")) {
            var35 = var6.split(",");
            int var37 = var35.length;
            String[] var32 = new String[var37];

            for(int var33 = 0; var33 < var37; ++var33) {
               var32[var33] = new String(var35[var33]);
            }

            var22 = var22.add(Restrictions.in("chamobSerie", var32));
         } else {
            var22 = var22.add(Restrictions.eq("chamobSerie", var6));
         }
      }

      if (!var7.equalsIgnoreCase("100")) {
         var22 = var22.add(Restrictions.eq("chamobCat", var7));
      }

      if (var5 <= 10) {
         var22 = var22.add(Restrictions.eq("chamobEtat", var5));
      } else if (var5 == 11) {
         var22 = var22.add(Restrictions.isNotNull("chamobDateRelance"));
      } else if (var5 == 12) {
         var22 = var22.add(Restrictions.eq("chamobTotHt", 0.0D));
      } else if (var5 == 13) {
         var22 = var22.add(Restrictions.eq("chamobSolde", 0));
      } else if (var5 == 14) {
         var22 = var22.add(Restrictions.eq("chamobSolde", 1));
      } else if (var5 == 15) {
         var22 = var22.add(Restrictions.eq("chamobExoTva", 1));
      } else if (var5 == 21) {
         var22 = var22.add(Restrictions.eq("chamobNiveau", 0));
      } else if (var5 == 22) {
         var22 = var22.add(Restrictions.eq("chamobNiveau", 1));
      } else if (var5 == 23) {
         var22 = var22.add(Restrictions.eq("chamobNiveau", 2));
      }

      if (var9 != null && !var9.isEmpty() && !var9.equalsIgnoreCase("100") && var9.contains(":")) {
         var22 = var22.add(Restrictions.eq("chamobService", var9));
      }

      if (!var15.equalsIgnoreCase("100")) {
         var35 = var15.split(":");
         var31 = var35[0];
         var22 = var22.add(Restrictions.eq("chamobActivite", var31));
      }

      if (var16 != null && !var16.isEmpty()) {
         var30 = "%" + var16 + "%";
         var22 = var22.add(Restrictions.like("chamobContener", var30));
      }

      var22 = var22.addOrder(Order.desc("chamobNum"));
      List var36 = var22.list();
      if (var19) {
         this.utilInitHibernate.closeSession();
      }

      return var36;
   }

   public ChargementEntete pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var4 = true;
      }

      ChargementEntete var5 = null;
      Query var6 = var3.createQuery("from ChargementEntete where chamobId =:num").setLong("num", var1).setMaxResults(1);
      List var7 = var6.list();
      if (var7.size() != 0) {
         var5 = (ChargementEntete)var7.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ChargementEntete pourChargement(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var4 = true;
      }

      String var5 = "";
      if (var1.contains(":")) {
         String[] var6 = var1.split(":");
         var5 = var6[1];
      } else {
         var5 = var1;
      }

      ChargementEntete var9 = null;
      Query var7 = var3.createQuery("from ChargementEntete where chamobNum=:num and chamobSerie=:ser").setString("num", var5).setString("ser", var2).setMaxResults(1);
      List var8 = var7.list();
      if (var8.size() != 0) {
         var9 = (ChargementEntete)var8.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
      Query var4 = var3.createQuery("from ChargementEntete where usr_id =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List rechercheLivraisonRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ChargementEntete where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheChargementByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from ChargementEntete where chamobDate>=:deb and chamobDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
