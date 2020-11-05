package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CaissesInventaire;
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

public class CaissesInventaireDao implements Serializable {
   private CaissesInventaire caissesInventaire;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;
   private List lesjoursItems = new ArrayList();

   public CaissesInventaireDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public CaissesInventaire insert(CaissesInventaire var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
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

   public CaissesInventaire insert(CaissesInventaire var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CaissesInventaire modif(CaissesInventaire var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
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

   public CaissesInventaire modif(CaissesInventaire var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(CaissesInventaire var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
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

   public void delete(CaissesInventaire var1, Session var2) {
      var2.delete(var1);
   }

   public List selectFind(int var1, String var2, String var3, String var4, int var5, long var6, Session var8) throws HibernateException, NamingException, ParseException {
      boolean var9 = false;
      if (var8 == null) {
         var8 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var9 = true;
      }

      new ArrayList();
      UtilDate var11 = new UtilDate();
      Date var12 = var11.stringToDateSQL(var3 + " 00:00:00");
      Date var13 = var11.stringToDateSQL(var4 + " 23:59:59");
      Criteria var14 = var8.createCriteria(CaissesInventaire.class);
      var14 = var14.add(Restrictions.between("caiinvDate", var12, var13));
      if (var2 != null && !var2.isEmpty() && !var2.equals("100")) {
         var14 = var14.add(Restrictions.eq("caiinvCodeCaisse", var2));
      }

      if (var1 == 0) {
         var14 = var14.add(Restrictions.eq("caiinvEtat", var1));
         if (var5 == 1) {
            var14 = var14.add(Restrictions.eq("caiinvUserIdCaisse", var6));
         }
      } else if (var1 == 1) {
         var14 = var14.add(Restrictions.eq("caiinvEtat", var1));
         if (var5 == 1) {
            var14 = var14.add(Restrictions.eq("caiinvUserIdCaisse", var6));
         }
      } else if (var1 == 2) {
         var14 = var14.add(Restrictions.eq("caiinvEtat", var1));
         if (var5 == 1) {
            var14 = var14.add(Restrictions.eq("caiinvUserIdCaisse", var6));
         }
      } else if (var1 == 3) {
         var14 = var14.add(Restrictions.eq("caiinvEtat", var1));
         if (var5 == 1) {
            var14 = var14.add(Restrictions.eq("caiinvUserIdCaisse", var6));
         }
      } else if (var1 == 4) {
         var14 = var14.add(Restrictions.eq("caiinvEtat", var1));
         if (var5 == 1) {
            var14 = var14.add(Restrictions.eq("caiinvUserIdCaisse", var6));
         }
      }

      List var10 = var14.list();
      if (var9) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public CaissesInventaire selectById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var4 = true;
      }

      new CaissesInventaire();
      Query var6 = var3.createQuery("from CaissesInventaire where caiinvId=:ident").setLong("ident", var1);
      var6.setMaxResults(1);
      List var7 = var6.list();
      CaissesInventaire var5;
      if (var7.size() > 0) {
         var5 = (CaissesInventaire)var7.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
