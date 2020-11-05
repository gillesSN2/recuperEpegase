package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.ForetInventaire;
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

public class ForetInventaireDao implements Serializable {
   private ForetInventaire foretInventaire;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ForetInventaireDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ForetInventaire insert(ForetInventaire var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ForetInventaire modif(ForetInventaire var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
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

   public ForetInventaire modif(ForetInventaire var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(ForetInventaire var1, Session var2) {
      var2.delete(var1);
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ForetInventaire order by forinvId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            ForetInventaire var7 = (ForetInventaire)var6.get(0);
            var4 = 1L + var7.getForinvId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ForetInventaire enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from ForetInventaire where exerciceventes.exevteId=:id and forinvSerie =:ser and year(forinvDate)=" + var7 + " order by forinvDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      ForetInventaire var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (ForetInventaire)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public ForetInventaire enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from ForetInventaire where exerciceventes.exevteId=:id and forinvSerie =:ser and year(forinvDate)=" + var7 + " and month(forinvDate)=" + var8 + " order by forinvDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      ForetInventaire var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (ForetInventaire)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, int var5, String var6, long var7, int var9, String var10, String var11, String var12, String var13, String var14) throws HibernateException, NamingException, ParseException {
      boolean var15 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var15 = true;
      }

      UtilDate var16 = new UtilDate();
      new ArrayList();
      Criteria var18 = var1.createCriteria(ForetInventaire.class);
      Calendar var19 = Calendar.getInstance();
      Date var20 = null;
      Date var21 = null;
      Date var22 = new Date();
      String var23 = var16.dateToStringFr(var22);
      String var24 = var23.substring(6, 10) + "-" + var23.substring(3, 5) + "-" + var23.substring(0, 2);
      var20 = var16.stringToDateSQL(var24 + " 00:00:00");
      var21 = var16.stringToDateSQL(var24 + " 23:59:59");
      int var25 = var22.getYear() + 1900;
      if (var6 == null || var6.isEmpty()) {
         var6 = "100";
      }

      String var26;
      if (var6.equalsIgnoreCase("100")) {
         if (var13 != null && var14 != null) {
            var20 = var16.stringToDateSQL(var13 + " 00:00:00");
            var21 = var16.stringToDateSQL(var14 + " 23:59:59");
            var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
         } else {
            var26 = "1980-01-01";
            var16.stringToDateSQL(var26 + " 00:00:00");
            var18 = var18.add(Restrictions.isNotNull("forinvDate"));
         }
      } else {
         if (!var6.equalsIgnoreCase("12") && !var6.equalsIgnoreCase("13") && !var6.equalsIgnoreCase("14")) {
            var18 = var18.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var6.equalsIgnoreCase("0")) {
            var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
         } else if (var6.equalsIgnoreCase("1")) {
            var26 = "" + var19.getTime();
            if (var26.contains("Mon")) {
               var20 = var19.getTime();
            } else if (var26.contains("Tue")) {
               var19.add(7, -1);
               var20 = var19.getTime();
            } else if (var26.contains("Wed")) {
               var19.add(7, -2);
               var20 = var19.getTime();
            } else if (var26.contains("Thu")) {
               var19.add(7, -3);
               var20 = var19.getTime();
            } else if (var26.contains("Fri")) {
               var19.add(7, -4);
               var20 = var19.getTime();
            } else if (var26.contains("Sat")) {
               var19.add(7, -5);
               var20 = var19.getTime();
            } else if (var26.contains("Sun")) {
               var19.add(7, -6);
               var20 = var19.getTime();
            }

            var23 = var16.dateToStringFr(var20);
            var24 = var23.substring(6, 10) + "-" + var23.substring(3, 5) + "-" + var23.substring(0, 2);
            var20 = var16.stringToDateSQL(var24 + " 00:00:00");
            var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
         } else {
            String var27;
            int var28;
            if (var6.equalsIgnoreCase("2")) {
               var28 = var19.get(2) + 1;
               var27 = var25 + "-" + var28 + "-01";
               var20 = var16.stringToDateSQL(var27 + " 00:00:00");
               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("3")) {
               var28 = var19.get(2);
               var19.add(5, -var28);
               if (var28 <= 3) {
                  var27 = var25 + "-01-01";
                  var20 = var16.stringToDateSQL(var27 + " 00:00:00");
               } else if (var28 >= 4 && var28 <= 6) {
                  var27 = var25 + "-04-01";
                  var20 = var16.stringToDateSQL(var27 + " 00:00:00");
               } else if (var28 >= 7 && var28 <= 9) {
                  var27 = var25 + "-07-01";
                  var20 = var16.stringToDateSQL(var27 + " 00:00:00");
               } else if (var28 >= 10) {
                  var27 = var25 + "-10-01";
                  var20 = var16.stringToDateSQL(var27 + " 00:00:00");
               }

               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("4")) {
               var28 = var19.get(2);
               var19.add(5, -var28);
               if (var28 <= 6) {
                  var27 = var25 + "-01-01";
                  var20 = var16.stringToDateSQL(var27 + " 00:00:00");
               } else {
                  var27 = var25 + "-07-01";
                  var20 = var16.stringToDateSQL(var27 + " 00:00:00");
               }

               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("5")) {
               var26 = var25 + "-01-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-03-31";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("6")) {
               var26 = var25 + "-04-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-06-30";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("7")) {
               var26 = var25 + "-07-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-09-30";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("8")) {
               var26 = var25 + "-10-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("9")) {
               var26 = var25 + "-01-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-06-30";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("10")) {
               var26 = var25 + "-07-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("11")) {
               var26 = var25 + "-01-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("12")) {
               var26 = "1980-01-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 - 1 + "-12-31";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("13")) {
               var26 = var25 - 1 + "-01-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            } else if (var6.equalsIgnoreCase("14")) {
               var26 = var25 - 1 + "-01-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 - 1 + "-12-31";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("forinvDate", var20, var21));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var26 = "%" + var4 + "%";
         var18 = var18.add(Restrictions.like("forinvNum", var26));
      }

      if (var12 != null && !var12.isEmpty() && !var12.equals("100")) {
         var18 = var18.add(Restrictions.eq("forinvChantier", var12));
      }

      if (var10 != null && !var10.isEmpty()) {
         var18 = var18.add(Restrictions.eq("forinvNomResponsable", var10));
      }

      if (var11 != null && !var11.isEmpty()) {
         var18 = var18.add(Restrictions.eq("forinvNomCommercial", var11));
      }

      if (var9 == 1 || var9 == 2) {
         var18 = var18.add(Restrictions.eq("forinvIdCreateur", var7));
      }

      if (var5 <= 10) {
         var18 = var18.add(Restrictions.eq("forinvEtat", var5));
      }

      var18 = var18.addOrder(Order.desc("forinvNum"));
      List var29 = var18.list();
      if (var15) {
         this.utilInitHibernate.closeSession();
      }

      return var29;
   }

   public ForetInventaire pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ForetInventaire where forinvId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new ForetInventaire();
      ForetInventaire var7;
      if (var6.size() != 0) {
         var7 = (ForetInventaire)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ForetInventaire pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ForetInventaire where forinvNum=:num and forinvSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new ForetInventaire();
      ForetInventaire var7;
      if (var6.size() != 0) {
         var7 = (ForetInventaire)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheCampagneRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ForetInventaire where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCampagneActive(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var2 = true;
      }

      new ArrayList();
      List var4 = null;
      var4 = var1.createQuery("from ForetInventaire where forinvEtat=1").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
