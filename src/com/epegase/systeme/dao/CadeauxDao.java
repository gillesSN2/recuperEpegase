package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Cadeaux;
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

public class CadeauxDao implements Serializable {
   private Cadeaux cadeaux;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CadeauxDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Cadeaux insert(Cadeaux var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Cadeaux modif(Cadeaux var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Cadeaux");
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

   public Cadeaux modif(Cadeaux var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(Cadeaux var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Cadeaux");
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

   public void delete(Cadeaux var1, Session var2) {
      var2.delete(var1);
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Cadeaux");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Cadeaux order by cadId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            Cadeaux var7 = (Cadeaux)var6.get(0);
            var4 = 1L + var7.getCadId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List recherche(Session var1, int var2, String var3, long var4, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, ParseException {
      boolean var12 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Cadeaux");
         var12 = true;
      }

      UtilDate var13 = new UtilDate();
      new ArrayList();
      Criteria var15 = var1.createCriteria(Cadeaux.class);
      Calendar var16 = Calendar.getInstance();
      Date var17 = null;
      Date var18 = null;
      Date var19 = new Date();
      String var20 = var13.dateToStringFr(var19);
      String var21 = var20.substring(6, 10) + "-" + var20.substring(3, 5) + "-" + var20.substring(0, 2);
      var17 = var13.stringToDateSQL(var21 + " 00:00:00");
      var18 = var13.stringToDateSQL(var21 + " 23:59:59");
      int var22 = var19.getYear() + 1900;
      if (var3 == null || var3.isEmpty()) {
         var3 = "100";
      }

      String var23;
      if (var3.equalsIgnoreCase("100")) {
         if (var10 != null && var11 != null) {
            var17 = var13.stringToDateSQL(var10 + " 00:00:00");
            var18 = var13.stringToDateSQL(var11 + " 23:59:59");
            var15 = var15.add(Restrictions.between("camDate", var17, var18));
         } else {
            var23 = "1980-01-01";
            var13.stringToDateSQL(var23 + " 00:00:00");
            var15 = var15.add(Restrictions.isNotNull("cadDate"));
         }
      } else if (var3.equalsIgnoreCase("0")) {
         var15 = var15.add(Restrictions.between("cadDate", var17, var18));
      } else if (var3.equalsIgnoreCase("1")) {
         var23 = "" + var16.getTime();
         if (var23.contains("Mon")) {
            var17 = var16.getTime();
         } else if (var23.contains("Tue")) {
            var16.add(7, -1);
            var17 = var16.getTime();
         } else if (var23.contains("Wed")) {
            var16.add(7, -2);
            var17 = var16.getTime();
         } else if (var23.contains("Thu")) {
            var16.add(7, -3);
            var17 = var16.getTime();
         } else if (var23.contains("Fri")) {
            var16.add(7, -4);
            var17 = var16.getTime();
         } else if (var23.contains("Sat")) {
            var16.add(7, -5);
            var17 = var16.getTime();
         } else if (var23.contains("Sun")) {
            var16.add(7, -6);
            var17 = var16.getTime();
         }

         var20 = var13.dateToStringFr(var17);
         var21 = var20.substring(6, 10) + "-" + var20.substring(3, 5) + "-" + var20.substring(0, 2);
         var17 = var13.stringToDateSQL(var21 + " 00:00:00");
         var15 = var15.add(Restrictions.between("cadDate", var17, var18));
      } else {
         String var24;
         int var25;
         if (var3.equalsIgnoreCase("2")) {
            var25 = var16.get(2) + 1;
            var24 = var22 + "-" + var25 + "-01";
            var17 = var13.stringToDateSQL(var24 + " 00:00:00");
            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("3")) {
            var25 = var16.get(2);
            var16.add(5, -var25);
            if (var25 <= 3) {
               var24 = var22 + "-01-01";
               var17 = var13.stringToDateSQL(var24 + " 00:00:00");
            } else if (var25 >= 4 && var25 <= 6) {
               var24 = var22 + "-04-01";
               var17 = var13.stringToDateSQL(var24 + " 00:00:00");
            } else if (var25 >= 7 && var25 <= 9) {
               var24 = var22 + "-07-01";
               var17 = var13.stringToDateSQL(var24 + " 00:00:00");
            } else if (var25 >= 10) {
               var24 = var22 + "-10-01";
               var17 = var13.stringToDateSQL(var24 + " 00:00:00");
            }

            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("4")) {
            var25 = var16.get(2);
            var16.add(5, -var25);
            if (var25 <= 6) {
               var24 = var22 + "-01-01";
               var17 = var13.stringToDateSQL(var24 + " 00:00:00");
            } else {
               var24 = var22 + "-07-01";
               var17 = var13.stringToDateSQL(var24 + " 00:00:00");
            }

            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("5")) {
            var23 = var22 + "-01-01";
            var17 = var13.stringToDateSQL(var23 + " 00:00:00");
            var24 = var22 + "-03-31";
            var18 = var13.stringToDateSQL(var24 + " 23:59:59");
            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("6")) {
            var23 = var22 + "-04-01";
            var17 = var13.stringToDateSQL(var23 + " 00:00:00");
            var24 = var22 + "-06-30";
            var18 = var13.stringToDateSQL(var24 + " 23:59:59");
            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("7")) {
            var23 = var22 + "-07-01";
            var17 = var13.stringToDateSQL(var23 + " 00:00:00");
            var24 = var22 + "-09-30";
            var18 = var13.stringToDateSQL(var24 + " 23:59:59");
            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("8")) {
            var23 = var22 + "-10-01";
            var17 = var13.stringToDateSQL(var23 + " 00:00:00");
            var24 = var22 + "-12-31";
            var18 = var13.stringToDateSQL(var24 + " 23:59:59");
            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("9")) {
            var23 = var22 + "-01-01";
            var17 = var13.stringToDateSQL(var23 + " 00:00:00");
            var24 = var22 + "-06-30";
            var18 = var13.stringToDateSQL(var24 + " 23:59:59");
            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("10")) {
            var23 = var22 + "-07-01";
            var17 = var13.stringToDateSQL(var23 + " 00:00:00");
            var24 = var22 + "-12-31";
            var18 = var13.stringToDateSQL(var24 + " 23:59:59");
            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("11")) {
            var23 = var22 + "-01-01";
            var17 = var13.stringToDateSQL(var23 + " 00:00:00");
            var24 = var22 + "-12-31";
            var18 = var13.stringToDateSQL(var24 + " 23:59:59");
            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("12")) {
            var23 = "1980-01-01";
            var17 = var13.stringToDateSQL(var23 + " 00:00:00");
            var24 = var22 - 1 + "-12-31";
            var18 = var13.stringToDateSQL(var24 + " 23:59:59");
            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("13")) {
            var23 = var22 - 1 + "-01-01";
            var17 = var13.stringToDateSQL(var23 + " 00:00:00");
            var24 = var22 + "-12-31";
            var18 = var13.stringToDateSQL(var24 + " 23:59:59");
            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         } else if (var3.equalsIgnoreCase("14")) {
            var23 = var22 - 1 + "-01-01";
            var17 = var13.stringToDateSQL(var23 + " 00:00:00");
            var24 = var22 - 1 + "-12-31";
            var18 = var13.stringToDateSQL(var24 + " 23:59:59");
            var15 = var15.add(Restrictions.between("cadDate", var17, var18));
         }
      }

      if (var7 != null && !var7.isEmpty()) {
         var23 = "%" + var7 + "%";
         var15 = var15.add(Restrictions.like("cadNomCommercial", var23));
      }

      if (var6 != null && !var6.isEmpty()) {
         var23 = "%" + var6 + "%";
         var15 = var15.add(Restrictions.like("cadNomTiers", var23));
      }

      if (var8 != null && !var8.isEmpty()) {
         var23 = "%" + var8 + "%";
         var15 = var15.add(Restrictions.like("cadNomContact", var23));
      }

      if (var9 != null && !var9.isEmpty()) {
         var23 = "%" + var9 + "%";
         var15 = var15.add(Restrictions.or(Restrictions.eq("cadCode", var9), Restrictions.like("cadLibelle", var23)));
      }

      var15 = var15.addOrder(Order.desc("cadDate"));
      List var26 = var15.list();
      if (var12) {
         this.utilInitHibernate.closeSession();
      }

      return var26;
   }

   public Cadeaux pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Cadeaux");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Cadeaux where cadId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new Cadeaux();
      Cadeaux var7;
      if (var6.size() != 0) {
         var7 = (Cadeaux)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheCadeauxRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Cadeaux");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from Cadeaux where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByContact(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Cadeaux");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from Cadeaux where cadIdContact=" + var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheByTiers(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Cadeaux");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from Cadeaux where cadIdTiers=" + var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, Session var5) {
      List var6 = null;
      String var7 = "";
      if (var2 != null && !var2.isEmpty()) {
         var7 = var7 + " cadDepot='" + var2 + "' and ";
      }

      if (var1 != null && !var1.isEmpty()) {
         if (var1.startsWith("(")) {
            var6 = var5.createQuery("select cadEtat,cadId,cadNomTiers,cadDate,cadDepot,cadCode,cadFamille,cadLibelle,cadQte,cadQteUtil,cadPump,cadPoidsBrut from Cadeaux where " + var7 + " cadCode in " + var1 + " and cadDate>='" + var3 + "' and cadDate<='" + var4 + "'").list();
         } else {
            var6 = var5.createQuery("select cadEtat,cadId,cadNomTiers,cadDate,cadDepot,cadCode,cadFamille,cadLibelle,cadQte,cadQteUtil,cadPump,cadPoidsBrut from Cadeaux where " + var7 + " cadCode='" + var1 + "' and cadDate>='" + var3 + "' and cadDate<='" + var4 + "'").list();
         }
      } else {
         var6 = var5.createQuery("select cadEtat,cadId,cadNomTiers,cadDate,cadDepot,cadCode,cadFamille,cadLibelle,cadQte,cadQteUtil,cadPump,cadPoidsBrut from Cadeaux where " + var7 + " cadDate>='" + var3 + "' and cadDate<='" + var4 + "'").list();
      }

      return var6;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from Cadeaux where cadCode='" + var1 + "'").list();
      return var3;
   }
}
