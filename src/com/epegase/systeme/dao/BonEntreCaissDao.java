package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BonEntreCaiss;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class BonEntreCaissDao implements Serializable {
   private BonEntreCaiss bonEntreCaiss;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BonEntreCaissDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BonEntreCaiss insert(BonEntreCaiss var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEntreeCaiss");
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

   public BonEntreCaiss insert(BonEntreCaiss var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BonEntreCaiss modif(BonEntreCaiss var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEntreeCaiss");
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

   public BonEntreCaiss modif(BonEntreCaiss var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(BonEntreCaiss var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEntreeCaiss");
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

   public void delete(BonEntreCaiss var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectFind(int var1, int var2, String var3, List var4, String var5, String var6, String var7, int var8, long var9, String var11, int var12, List var13, List var14, Session var15) throws HibernateException, NamingException, ParseException {
      boolean var16 = false;
      if (var15 == null) {
         var15 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEntreeCaiss");
         var16 = true;
      }

      new ArrayList();
      UtilDate var18 = new UtilDate();
      Date var19 = var18.stringToDateSQL(var6 + " 00:00:00");
      Date var20 = var18.stringToDateSQL(var7 + " 23:59:59");
      Criteria var21 = var15.createCriteria(BonEntreCaiss.class);
      var21 = var21.add(Restrictions.between("entrDate", var19, var20));
      if (var2 != 100) {
         var21 = var21.add(Restrictions.eq("entrNature", var2));
      }

      if (!var3.equalsIgnoreCase("100")) {
         var21 = var21.add(Restrictions.eq("entrService", var3));
      }

      if (var5 != null && !var5.isEmpty() && !var5.equalsIgnoreCase("100")) {
         var21 = var21.add(Restrictions.eq("entrCodeCaiss", var5));
      } else if (var4.size() != 0 && var8 != 2) {
         var21 = var21.add(Restrictions.or(Restrictions.in("entrCodeCaiss", var4), Restrictions.isNull("entrCodeCaiss")));
      }

      if (var8 != 0) {
         if (var8 == 1) {
            var21 = var21.add(Restrictions.eq("entrUserCreat", var9));
         } else if (var8 == 2 && var14.size() != 0) {
            var21 = var21.add(Restrictions.in("entrGrp", var14));
         }
      }

      if (var12 != 0 && var12 == 1 && var13.size() != 0) {
         var21 = var21.add(Restrictions.not(Restrictions.in("entrCodeCaiss", var13)));
      }

      String var22;
      if (var11 != null && !var11.isEmpty()) {
         var22 = "%" + var11 + "%";
         var21 = var21.add(Restrictions.like("entrNomTiers", var22));
      }

      if (var1 == 0) {
         var22 = var18.dateToStringSQLLight(new Date());
         var19 = var18.stringToDateSQL(var22 + " 00:00:00");
         var20 = var18.stringToDateSQL(var22 + " 23:59:59");
         var21 = var21.add(Restrictions.or(Restrictions.eq("entrEtat", 0), Restrictions.eq("entrEtat", 6)));
         var21 = var21.add(Restrictions.between("entrDate", var19, var20));
      } else if (var1 == 1) {
         var21 = var21.add(Restrictions.eq("entrEtat", var1));
      } else if (var1 == 2) {
         var21 = var21.add(Restrictions.eq("entrEtat", var1));
      } else if (var1 == 4) {
         var21 = var21.add(Restrictions.eq("entrEtat", var1));
      } else if (var1 == 6) {
         var21 = var21.add(Restrictions.eq("entrEtat", var1));
      } else if (var1 == 7) {
         var21 = var21.add(Restrictions.eq("entrEtat", var1));
      } else if (var1 == 10) {
         var21 = var21.add(Restrictions.or(Restrictions.eq("entrEtat", 0), Restrictions.eq("entrEtat", 6)));
      } else {
         var21 = var21.add(Restrictions.eq("entrEtat", var1));
      }

      List var17 = var21.list();
      if (var16) {
         this.utilInitHibernate.closeSession();
      }

      return var17;
   }

   public BonEntreCaiss selectById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEntreeCaiss");
         var4 = true;
      }

      BonEntreCaiss var5 = new BonEntreCaiss();
      Query var6 = var3.createQuery("from BonEntreCaiss where entrId=:ident").setLong("ident", var1).setMaxResults(1);
      List var7 = var6.list();
      if (var7.size() > 0) {
         var5 = (BonEntreCaiss)var7.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheBon(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEntreeCaiss");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BonEntreCaiss  where entrDate between '" + var1 + "' and '" + var2 + "' order by entrDate desc");
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
