package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ProduitsLaboratoire;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitsLaboratoireDao implements Serializable {
   private String mabase;
   private ProduitsLaboratoire produitsLaboratoire;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsLaboratoireDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsLaboratoire insert(ProduitsLaboratoire var1) throws HibernateException, NamingException {
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

   public ProduitsLaboratoire modif(ProduitsLaboratoire var1) throws HibernateException, NamingException {
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

   public void delete(ProduitsLaboratoire var1) throws HibernateException, NamingException {
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

   public void delete(ProduitsLaboratoire var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public ProduitsLaboratoire chargeProdLaboratoireByProd(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var4 = true;
      }

      new ProduitsLaboratoire();
      new ArrayList();
      Query var7 = var3.createQuery("from ProduitsLaboratoire where pro_id=:id").setLong("id", var1).setMaxResults(1);
      List var6 = var7.list();
      ProduitsLaboratoire var5;
      if (var6.size() != 0) {
         var5 = (ProduitsLaboratoire)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listProdLaboratoireByProd(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var4 = true;
      }

      new ProduitsLaboratoire();
      new ArrayList();
      Query var7 = var3.createQuery("from ProduitsLaboratoire where pro_id=:id").setLong("id", var1);
      List var6 = var7.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List listProdLaboratoire(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
         var2 = true;
      }

      new ProduitsLaboratoire();
      new ArrayList();
      Query var5 = var1.createQuery("from ProduitsLaboratoire");
      List var4 = var5.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List getProduitsLaboratoireMed() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
      List var2 = var1.createQuery("From ProduitsLaboratoire").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List getProduitsLaboratoireExamen() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ProduitsMedic");
      List var2 = var1.createQuery("From ProduitsLaboratoire where prolabType<>0").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }
}
