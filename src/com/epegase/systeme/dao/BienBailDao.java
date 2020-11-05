package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienBail;
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

public class BienBailDao implements Serializable {
   private BienBail bienBail;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BienBailDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BienBail insert(BienBail var1) throws HibernateException, NamingException {
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

   public BienBail insert(BienBail var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public BienBail modif(BienBail var1) throws HibernateException, NamingException {
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

   public BienBail modif(BienBail var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(BienBail var1) throws HibernateException, NamingException {
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

   public void delete(BienBail var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerBaux(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      Query var3 = var1.createQuery("from BienBail order by biebaiNum");
      new ArrayList();
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerBauxPeriode(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      Query var3 = var1.createQuery("from BienBail group by biebaiAnnee");
      new ArrayList();
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerBauxActifs(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      Query var3 = var1.createQuery("from BienBail where biebaiEtat=1 order by biebaiNum");
      new ArrayList();
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerBauxAvecFactures(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      Query var3 = var1.createQuery("from BienBail where biebaiDateFinFacture is null group by Bien.bieNum");
      new ArrayList();
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerBauxByBien(Bien var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienBail where Bien=:bi order by biebaiNum").setParameter("bi", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerBauxByLocataire(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienBail where Tiers=:ti  order by biebaiNum").setParameter("ti", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerBauxByProprietaire(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienBail where biebaiProprietaire=:ti order by biebaiNum").setLong("ti", var1);
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List recherche(Session var1, String var2, String var3, int var4, String var5, int var6, long var7, int var9, String var10, String var11, String var12, Date var13) throws HibernateException, NamingException, ParseException {
      boolean var14 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var14 = true;
      }

      UtilDate var15 = new UtilDate();
      new ArrayList();
      Criteria var17 = var1.createCriteria(BienBail.class);
      Calendar var18 = Calendar.getInstance();
      Date var19 = null;
      Date var20 = null;
      Date var21 = new Date();
      String var22 = var15.dateToStringFr(var21);
      String var23 = var22.substring(6, 10) + "-" + var22.substring(3, 5) + "-" + var22.substring(0, 2);
      var15.stringToDateSQLLight(var23);
      var15.stringToDateSQLLight(var23);
      int var24 = var21.getYear() + 1900;
      String var25;
      if (var6 == 0) {
         if (var11 != null && var12 != null) {
            var19 = var15.stringToDateSQLLight(var11);
            var20 = var15.stringToDateSQLLight(var12);
            var17 = var17.add(Restrictions.between("biebaiDate", var19, var20));
         } else {
            var25 = "1980-01-01";
            var15.stringToDateSQLLight(var25);
            var17 = var17.add(Restrictions.isNotNull("biebaiDate"));
         }
      } else {
         var17 = var17.add(Restrictions.eq("biebaiAnnee", var6));
      }

      if (var2 != null && !var2.isEmpty()) {
         var25 = "%" + var2 + "%";
         var17 = var17.add(Restrictions.like("biebaiNum", var25));
      }

      if (var3 != null && !var3.isEmpty()) {
         var25 = "";
         if (var3.startsWith("*")) {
            var25 = "%" + var3.substring(1) + "%";
         } else {
            var25 = var3 + "%";
         }

         var17 = var17.add(Restrictions.like("biebaiNomTiers", var25));
      }

      if (var10 != null && !var10.isEmpty()) {
         var17 = var17.add(Restrictions.eq("biebaiNomResponsable", var10));
      }

      if (var9 == 1) {
         var17 = var17.add(Restrictions.eq("biebaiUserCreat", var7));
      }

      if (!var5.equalsIgnoreCase("100")) {
         if (var5.contains(",")) {
            String[] var29 = var5.split(",");
            int var26 = var29.length;
            String[] var27 = new String[var26];

            for(int var28 = 0; var28 < var26; ++var28) {
               var27[var28] = new String(var29[var28]);
            }

            var17 = var17.add(Restrictions.in("biebaiSerie", var27));
         } else {
            var17 = var17.add(Restrictions.eq("biebaiSerie", var5));
         }
      }

      if (var4 <= 4) {
         var17 = var17.add(Restrictions.eq("biebaiEtat", var4));
         var17 = var17.add(Restrictions.isNull("biebaiDateFinFacture"));
      } else if (var4 == 5) {
         var17 = var17.add(Restrictions.eq("biebaiDateFin", var13));
      } else if (var4 == 6) {
         var17 = var17.add(Restrictions.isNotNull("biebaiDateFinFacture"));
      }

      var17 = var17.addOrder(Order.desc("biebaiDate"));
      var17 = var17.addOrder(Order.desc("biebaiNum"));
      List var30 = var17.list();
      if (var14) {
         this.utilInitHibernate.closeSession();
      }

      return var30;
   }

   public BienBail pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienBail where biebaiId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new BienBail();
      BienBail var7;
      if (var6.size() != 0) {
         var7 = (BienBail)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public BienBail pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienBail where biebaiNum =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new BienBail();
      BienBail var6;
      if (var5.size() != 0) {
         var6 = (BienBail)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienBail where Tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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
