package com.epegase.systeme.dao;

import com.epegase.systeme.classe.VirementInterne;
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

public class VirementInterneDao implements Serializable {
   private VirementInterne virementInterne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public VirementInterneDao() {
   }

   public VirementInterneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public VirementInterne insert(VirementInterne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "VirementInterne");
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

   public VirementInterne insert(VirementInterne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public VirementInterne modif(VirementInterne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "VirementInterne");
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

   public VirementInterne modif(VirementInterne var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(VirementInterne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "VirementInterne");
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

   public void delete(VirementInterne var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectFind(int var1, int var2, String var3, List var4, String var5, String var6, String var7, int var8, long var9, int var11, List var12, List var13, Session var14) throws HibernateException, NamingException, ParseException {
      boolean var15 = false;
      if (var14 == null) {
         var14 = this.utilInitHibernate.getOpenSession(this.mabase, "VirementInterne");
         var15 = true;
      }

      new ArrayList();
      UtilDate var17 = new UtilDate();
      Date var18 = var17.stringToDateSQL(var6 + " 00:00:00");
      Date var19 = var17.stringToDateSQL(var7 + " 23:59:59");
      Criteria var20 = var14.createCriteria(VirementInterne.class);
      if (var1 == 10) {
         var20 = var20.add(Restrictions.ne("virDate", new Date()));
      } else {
         var20 = var20.add(Restrictions.between("virDate", var18, var19));
      }

      if (var2 != 100) {
         var20 = var20.add(Restrictions.eq("virNature", var2));
      }

      if (!var3.equalsIgnoreCase("100")) {
         var20 = var20.add(Restrictions.eq("virService", var3));
      }

      if (var1 == 0) {
         String var21 = var17.dateToStringSQLLight(new Date());
         var18 = var17.stringToDateSQL(var21 + " 00:00:00");
         var19 = var17.stringToDateSQL(var21 + " 23:59:59");
         var20 = var20.add(Restrictions.or(Restrictions.eq("virEtat", 0), Restrictions.eq("virEtat", 6)));
         var20 = var20.add(Restrictions.between("virDate", var18, var19));
      } else if (var1 == 1) {
         var20 = var20.add(Restrictions.eq("virEtat", var1));
      } else if (var1 == 2) {
         var20 = var20.add(Restrictions.eq("virEtat", var1));
      } else if (var1 == 4) {
         var20 = var20.add(Restrictions.eq("virEtat", var1));
      } else if (var1 == 6) {
         var20 = var20.add(Restrictions.eq("virEtat", var1));
      } else if (var1 == 7) {
         var20 = var20.add(Restrictions.eq("virEtat", var1));
      } else if (var1 == 10) {
         var20 = var20.add(Restrictions.or(Restrictions.eq("virEtat", 0), Restrictions.eq("virEtat", 6)));
      } else {
         var20 = var20.add(Restrictions.eq("virEtat", var1));
      }

      if (var5 != null && !var5.isEmpty() && !var5.equalsIgnoreCase("100")) {
         var20 = var20.add(Restrictions.eq("virCodeCaiss", var5));
      } else if (var4.size() != 0 && var8 != 2) {
         var20 = var20.add(Restrictions.or(Restrictions.in("virCodeCaiss", var4), Restrictions.isNull("virCodeCaiss")));
      }

      if (var8 != 0) {
         if (var8 == 1) {
            var20 = var20.add(Restrictions.eq("virUserCreat", var9));
         } else if (var8 == 2 && var13.size() != 0) {
            var20 = var20.add(Restrictions.in("virGrp", var13));
         }
      }

      if (var11 != 0 && var11 == 1 && var12.size() != 0) {
         var20 = var20.add(Restrictions.not(Restrictions.in("virCodeCaiss", var12)));
      }

      List var16 = var20.list();
      if (var15) {
         this.utilInitHibernate.closeSession();
      }

      return var16;
   }

   public VirementInterne selectById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "VirementInterne");
         var4 = true;
      }

      VirementInterne var5 = new VirementInterne();
      Query var6 = var3.createQuery("from VirementInterne where  virId=:ident").setLong("ident", var1).setMaxResults(1);
      List var7 = var6.list();
      if (var7.size() > 0) {
         var5 = (VirementInterne)var7.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheBon(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "VirementInterne");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from VirementInterne  where virDate between '" + var1 + "' and '" + var2 + "' order by virDate desc");
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
