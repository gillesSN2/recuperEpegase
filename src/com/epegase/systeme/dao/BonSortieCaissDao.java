package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BonSortieCaiss;
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

public class BonSortieCaissDao implements Serializable {
   private BonSortieCaiss bonSortieCaiss;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BonSortieCaissDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BonSortieCaiss insert(BonSortieCaiss var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonSortieCaiss");
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

   public BonSortieCaiss insert(BonSortieCaiss var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BonSortieCaiss modif(BonSortieCaiss var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonSortieCaiss");
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

   public BonSortieCaiss modif(BonSortieCaiss var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(BonSortieCaiss var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonSortieCaiss");
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

   public void delete(BonSortieCaiss var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectFind(int var1, int var2, String var3, List var4, String var5, String var6, String var7, int var8, long var9, String var11, int var12, List var13, List var14, Session var15) throws HibernateException, NamingException, ParseException {
      boolean var16 = false;
      if (var15 == null) {
         var15 = this.utilInitHibernate.getOpenSession(this.mabase, "BonSortieCaiss");
         var16 = true;
      }

      new ArrayList();
      UtilDate var18 = new UtilDate();
      Date var19 = var18.stringToDateSQL(var6 + " 00:00:00");
      Date var20 = var18.stringToDateSQL(var7 + " 23:59:59");
      Criteria var21 = var15.createCriteria(BonSortieCaiss.class);
      if (var1 == 10) {
         var21 = var21.add(Restrictions.ne("sortDate", new Date()));
      } else {
         var21 = var21.add(Restrictions.between("sortDate", var19, var20));
      }

      String var22;
      if (var1 == 0) {
         var22 = var18.dateToStringSQLLight(new Date());
         var19 = var18.stringToDateSQL(var22 + " 00:00:00");
         var20 = var18.stringToDateSQL(var22 + " 23:59:59");
         var21 = var21.add(Restrictions.or(Restrictions.eq("sortEtat", 0), Restrictions.eq("sortEtat", 6)));
         var21 = var21.add(Restrictions.between("sortDate", var19, var20));
      } else if (var1 == 1) {
         var21 = var21.add(Restrictions.eq("sortEtat", var1));
      } else if (var1 == 2) {
         var21 = var21.add(Restrictions.eq("sortEtat", var1));
      } else if (var1 == 4) {
         var21 = var21.add(Restrictions.eq("sortEtat", var1));
      } else if (var1 == 6) {
         var21 = var21.add(Restrictions.eq("sortEtat", var1));
      } else if (var1 == 7) {
         var21 = var21.add(Restrictions.eq("sortEtat", var1));
      } else if (var1 == 10) {
         var21 = var21.add(Restrictions.or(Restrictions.eq("sortEtat", 0), Restrictions.eq("sortEtat", 6)));
      } else {
         var21 = var21.add(Restrictions.eq("sortEtat", var1));
      }

      if (var2 != 100) {
         var21 = var21.add(Restrictions.eq("sortNature", var2));
      }

      if (!var3.equalsIgnoreCase("100")) {
         var21 = var21.add(Restrictions.eq("sortService", var3));
      }

      if (var5 != null && !var5.isEmpty() && !var5.equalsIgnoreCase("100")) {
         var21 = var21.add(Restrictions.eq("sortCodeCaiss", var5));
      } else if (var4.size() != 0 && var8 != 2) {
         var21 = var21.add(Restrictions.or(Restrictions.in("sortCodeCaiss", var4), Restrictions.isNull("sortCodeCaiss")));
      }

      if (var8 != 0) {
         if (var8 == 1) {
            var21 = var21.add(Restrictions.eq("sortUserCreat", var9));
         } else if (var8 == 2 && var14.size() != 0) {
            var21 = var21.add(Restrictions.in("sortGrp", var14));
         }
      }

      if (var12 != 0 && var12 == 1 && var13.size() != 0) {
         var21 = var21.add(Restrictions.not(Restrictions.in("sortCodeCaiss", var13)));
      }

      if (var11 != null && !var11.isEmpty()) {
         var22 = "%" + var11 + "%";
         var21 = var21.add(Restrictions.like("sortNomTiers", var22));
      }

      List var17 = var21.list();
      if (var16) {
         this.utilInitHibernate.closeSession();
      }

      return var17;
   }

   public BonSortieCaiss selectById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonSortieCaiss");
         var4 = true;
      }

      new BonSortieCaiss();
      Query var6 = var3.createQuery("from BonSortieCaiss where sortId=:ident").setLong("ident", var1).setMaxResults(1);
      List var7 = var6.list();
      BonSortieCaiss var5;
      if (var7.size() > 0) {
         var5 = (BonSortieCaiss)var7.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheBon(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonSortieCaiss");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from BonSortieCaiss  where sortDate between '" + var1 + "' and '" + var2 + "' order by sortDate desc");
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
