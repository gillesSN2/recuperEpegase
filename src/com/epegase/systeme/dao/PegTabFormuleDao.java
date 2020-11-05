package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PegTabElement;
import com.epegase.systeme.classe.PegTabFormule;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PegTabFormuleDao implements Serializable {
   private PegTabFormule pegTabFormule;
   private UtilInitHibernate utilInitHibernate;

   public PegTabFormuleDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public PegTabFormule insert(PegTabFormule var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
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

   public PegTabFormule insert(PegTabFormule var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public PegTabFormule modif(PegTabFormule var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
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

   public void delete(PegTabFormule var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
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

   public void delete(PegTabFormule var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerMesTabFormule(long var1, int var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getSysteme();
      Query var5 = var4.createQuery("from PegTabFormule as pF where pF.pegTabElement=:idpegElm and pF.tabforCol=:index").setLong("idpegElm", var1).setInteger("index", var3);
      List var6 = var5.list();
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List chargerMesTabFormuleByFKId(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getSysteme();
         var3 = true;
      }

      Query var4 = var2.createQuery("from PegTabFormule pegEl where pegEl.pegTabElement in " + var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerMesTabFormuleElement(PegTabElement var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getSysteme();
         var3 = true;
      }

      Query var4 = var2.createQuery("from PegTabFormule where pegTabElement=:ele").setParameter("ele", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
