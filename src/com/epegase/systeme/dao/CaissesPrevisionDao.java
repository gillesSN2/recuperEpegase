package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CaissesPrevision;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CaissesPrevisionDao implements Serializable {
   private CaissesPrevision caissesPrevision;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CaissesPrevisionDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public CaissesPrevision insert(CaissesPrevision var1) throws HibernateException, NamingException {
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

   public CaissesPrevision insert(CaissesPrevision var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CaissesPrevision modif(CaissesPrevision var1) throws HibernateException, NamingException {
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

   public CaissesPrevision modif(CaissesPrevision var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public CaissesPrevision delete(CaissesPrevision var1) throws HibernateException, NamingException {
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

      return var1;
   }

   public CaissesPrevision delete(CaissesPrevision var1, Session var2) {
      var2.delete(var1);
      return var1;
   }

   public List listePrevision(int var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var5 = true;
      }

      Query var6 = null;
      if (var2 != null && var3 != null) {
         if (var1 == 100) {
            var6 = var4.createQuery(" from CaissesPrevision where caipreDateDebut>=:dDeb and caipreDateDebut<:dFin").setDate("dDeb", var2).setDate("dFin", var3);
         } else {
            var6 = var4.createQuery(" from CaissesPrevision where caipreDateDebut>=:dDeb and caipreDateDebut<:dFin and caipreEtat=:et").setDate("dDeb", var2).setDate("dFin", var3).setInteger("et", var1);
         }
      } else if (var1 == 100) {
         var6 = var4.createQuery(" from CaissesPrevision");
      } else {
         var6 = var4.createQuery(" from CaissesPrevision where caipreEtat=:et").setInteger("et", var1);
      }

      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public CaissesPrevision caisseControle(int var1, long var2, String var4, String var5, Date var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var8 = true;
      }

      String var9 = "";
      if (var2 != 0L) {
         var9 = var9 + " and  caipreIdEquipe = " + var2;
      }

      String var10;
      String[] var11;
      if (var4 != null && !var4.isEmpty()) {
         var10 = "";
         if (var4.contains(":")) {
            var11 = var4.split(":");
            var10 = var11[0];
         } else {
            var10 = var4;
         }

         var9 = var9 + " and  caipreDepot = '" + var10 + "'";
      }

      if (var5 != null && !var5.isEmpty()) {
         var10 = "";
         if (var5.contains(":")) {
            var11 = var5.split(":");
            var10 = var11[0];
         } else {
            var10 = var5;
         }

         var9 = var9 + " and  caipreCaisse = '" + var10 + "'";
      }

      Query var13 = var7.createQuery(" from CaissesPrevision where caipreType=:et and caipreDateDebut=:date " + var9).setInteger("et", var1).setDate("date", var6);
      this.caissesPrevision = new CaissesPrevision();
      List var12 = var13.list();
      if (var12.size() != 0) {
         this.caissesPrevision = (CaissesPrevision)var12.get(0);
      } else {
         this.caissesPrevision = null;
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return this.caissesPrevision;
   }
}
