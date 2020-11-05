package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsHistoRef;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProduitsHistoRefDao implements Serializable {
   private ProduitsHistoRef produitsHistoRef;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProduitsHistoRefDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ProduitsHistoRef insert(ProduitsHistoRef var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

   public ProduitsHistoRef insert(ProduitsHistoRef var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ProduitsHistoRef modif(ProduitsHistoRef var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

   public String delete(ProduitsHistoRef var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
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

      return "";
   }

   public void delete(ProduitsHistoRef var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectAllProduitsHistoRef() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
      List var2 = var1.createQuery("from ProduitsHistoRef ").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List selectProdHistoRefByprod(Produits var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProduitsAchs");
      Query var3 = var2.createQuery("from ProduitsHistoRef where pro_id=:id");
      var3.setParameter("id", var1.getProId());
      List var4 = var3.list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List selectProdHistoRefByprod(Produits var1, Session var2) {
      Query var3 = var2.createQuery("from ProduitsHistoRef where pro_id=:id");
      var3.setParameter("id", var1.getProId());
      List var4 = var3.list();
      return var4;
   }

   public ProduitsHistoRef selectProdHistoRefByprod(Produits var1, String var2, Session var3) {
      Query var4 = var3.createQuery("from ProduitsHistoRef where pro_id=:id and prohrfReference=:reference").setParameter("id", var1.getProId()).setString("reference", var2);
      List var5 = var4.list();
      if (var5.size() != 0) {
         this.produitsHistoRef = (ProduitsHistoRef)var5.get(0);
      } else {
         this.produitsHistoRef = null;
      }

      return this.produitsHistoRef;
   }

   public List selectProdHistoRefByprod(String var1, Session var2) {
      Query var3 = var2.createQuery("from ProduitsHistoRef where prohrfReference like '" + var1 + "%'");
      List var4 = var3.list();
      return var4;
   }
}
