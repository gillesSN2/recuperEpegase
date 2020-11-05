package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BienBudgetEntete;
import com.epegase.systeme.classe.BienBudgetLigne;
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

public class BienBudgetLigneDao implements Serializable {
   private BienBudgetLigne bienBudgetLigne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BienBudgetLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BienBudgetLigne insert(BienBudgetLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.save(var1);
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

   public BienBudgetLigne insert(BienBudgetLigne var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public BienBudgetLigne modif(BienBudgetLigne var1) throws HibernateException, NamingException {
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

   public BienBudgetLigne modif(BienBudgetLigne var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(BienBudgetLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public void delete(BienBudgetLigne var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerBudget(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      Query var3 = var1.createQuery("from BienBudgetLigne order by biebudligNum");
      new ArrayList();
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerBudgetPeriode(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      Query var3 = var1.createQuery("from BienBudgetLigne group by biebudligAnnee");
      new ArrayList();
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerBudgetActifs(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      Query var3 = var1.createQuery("from BienBudgetLigne where biebudligEtat=1 order by biebudligNum");
      new ArrayList();
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerBudgetByBien(BienBudgetEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienBudgetLigne where BienBudgetEntete=:bient  order by biebudligCode").setParameter("bient", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerBudgetByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienBudgetLigne where Tiers=:ti  order by biebudligNum").setParameter("ti", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List recherche(Session var1, String var2, String var3, int var4, String var5, int var6, long var7, int var9, String var10, String var11, String var12) throws HibernateException, NamingException, ParseException {
      boolean var13 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var13 = true;
      }

      UtilDate var14 = new UtilDate();
      new ArrayList();
      Criteria var16 = var1.createCriteria(BienBudgetLigne.class);
      Calendar var17 = Calendar.getInstance();
      Date var18 = null;
      Date var19 = null;
      Date var20 = new Date();
      String var21 = var14.dateToStringFr(var20);
      String var22 = var21.substring(6, 10) + "-" + var21.substring(3, 5) + "-" + var21.substring(0, 2);
      var14.stringToDateSQLLight(var22);
      var14.stringToDateSQLLight(var22);
      int var23 = var20.getYear() + 1900;
      String var24;
      if (var6 == 0) {
         if (var11 != null && var12 != null) {
            var18 = var14.stringToDateSQLLight(var11);
            var19 = var14.stringToDateSQLLight(var12);
            var16 = var16.add(Restrictions.between("biebudligDate", var18, var19));
         } else {
            var24 = "1980-01-01";
            var14.stringToDateSQLLight(var24);
            var16 = var16.add(Restrictions.isNotNull("biebudligDate"));
         }
      } else {
         var16 = var16.add(Restrictions.eq("biebudligAnnee", var6));
      }

      if (var2 != null && !var2.isEmpty()) {
         var24 = "%" + var2 + "%";
         var16 = var16.add(Restrictions.like("biebudligNum", var24));
      }

      if (var3 != null && !var3.isEmpty()) {
         var24 = "";
         if (var3.startsWith("*")) {
            var24 = "%" + var3.substring(1) + "%";
         } else {
            var24 = var3 + "%";
         }

         var16 = var16.add(Restrictions.like("biebudligNomTiers", var24));
      }

      if (var10 != null && !var10.isEmpty()) {
         var16 = var16.add(Restrictions.eq("biebudligNomResponsable", var10));
      }

      if (var9 == 1) {
         var16 = var16.add(Restrictions.eq("biebudligUserCreat", var7));
      }

      if (!var5.equalsIgnoreCase("100")) {
         if (var5.contains(",")) {
            String[] var28 = var5.split(",");
            int var25 = var28.length;
            String[] var26 = new String[var25];

            for(int var27 = 0; var27 < var25; ++var27) {
               var26[var27] = new String(var28[var27]);
            }

            var16 = var16.add(Restrictions.in("biebudligSerie", var26));
         } else {
            var16 = var16.add(Restrictions.eq("biebudligSerie", var5));
         }
      }

      if (var4 <= 10) {
         var16 = var16.add(Restrictions.eq("biebudligEtat", var4));
      }

      var16 = var16.addOrder(Order.desc("biebudligDate"));
      var16 = var16.addOrder(Order.desc("biebudligNum"));
      List var29 = var16.list();
      if (var13) {
         this.utilInitHibernate.closeSession();
      }

      return var29;
   }

   public BienBudgetLigne pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienBudgetLigne where biebudligId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new BienBudgetLigne();
      BienBudgetLigne var7;
      if (var6.size() != 0) {
         var7 = (BienBudgetLigne)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean verifTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienBudgetLigne where Tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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
}
