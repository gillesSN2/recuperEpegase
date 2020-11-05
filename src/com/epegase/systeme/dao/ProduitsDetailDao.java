package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ProduitsDetail;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitsDetailDao implements Serializable {
   private String mabase;
   private ProduitsDetail produitsDetail;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsDetailDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsDetail insert(ProduitsDetail var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
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

   public ProduitsDetail modif(ProduitsDetail var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
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

   public void delete(ProduitsDetail var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
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

   public void delete(ProduitsDetail var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void ordonnnerAscendant(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         String var9 = "update ProduitsDetail pb set pb.prodetOrdre=:ordPrec where pb.prodetId=:idTab";
         var7.createQuery(var9).setInteger("ordPrec", var2).setLong("idTab", var3).executeUpdate();
         String var11 = "update ProduitsDetail pb set pb.prodetOrdre=:ord1 where pb.prodetId=:idTab";
         var7.createQuery(var11).setInteger("ord1", var1).setLong("idTab", var5).executeUpdate();
         var8.commit();
      } catch (HibernateException var16) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void ordonnnerDescendant(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         String var9 = "update ProduitsDetail pb set pb.prodetOrdre=:ordSuiv where pb.prodetId=:idTab";
         var7.createQuery(var9).setInteger("ordSuiv", var2).setLong("idTab", var3).executeUpdate();
         String var11 = "update ProduitsDetail pb set pb.prodetOrdre=:ord1 where pb.prodetId=:idTab";
         var7.createQuery(var11).setInteger("ord1", var1).setLong("idTab", var5).executeUpdate();
         var8.commit();
      } catch (HibernateException var16) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public List chargeProdDetailByProd(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ProduitsDetail where prodetCode=:code order by prodetOrdre").setString("code", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargeProdDetailByLab(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ProduitsDetail where prolab_id=:id order by prodetOrdre").setLong("id", var1);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public long chargeDernier(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from ProduitsDetail order by prodetId desc").setMaxResults(1);
      long var5 = 0L;
      List var3 = var4.list();
      if (var3.size() != 0) {
         var5 = ((ProduitsDetail)var3.get(0)).getProdetId();
      }

      ++var5;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
