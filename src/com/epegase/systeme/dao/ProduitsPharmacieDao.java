package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ProduitsPharmacie;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitsPharmacieDao implements Serializable {
   private ProduitsPharmacie produitsPharmacie;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsPharmacieDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsPharmacie insert(ProduitsPharmacie var1) throws HibernateException, NamingException {
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

   public ProduitsPharmacie modif(ProduitsPharmacie var1) throws HibernateException, NamingException {
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

   public void delete(ProduitsPharmacie var1) throws HibernateException, NamingException {
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

   public void delete(ProduitsPharmacie var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public ProduitsPharmacie chargeProdPharmacieByProd(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var4 = true;
      }

      new ProduitsPharmacie();
      new ArrayList();
      Query var7 = var3.createQuery("from ProduitsPharmacie where pro_id=:id").setLong("id", var1).setMaxResults(1);
      List var6 = var7.list();
      ProduitsPharmacie var5;
      if (var6.size() != 0) {
         var5 = (ProduitsPharmacie)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listeProdPharmacieByProd(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var4 = true;
      }

      new ProduitsPharmacie();
      new ArrayList();
      Query var7 = var3.createQuery("from ProduitsPharmacie where pro_id=:id").setLong("id", var1);
      List var6 = var7.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List getProduitsPharmacieMed() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
      List var2 = var1.createQuery("From ProduitsPharmacie").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }
}
