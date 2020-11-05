package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CabinetPeg;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CabinetDao implements Serializable {
   private UtilInitHibernate utilInitHibernate;

   public CabinetDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public CabinetPeg insertPeg(CabinetPeg var1) throws HibernateException, NamingException {
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

   public CabinetPeg modifPeg(CabinetPeg var1) throws HibernateException, NamingException {
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

   public CabinetPeg deletePeg(CabinetPeg var1) throws HibernateException, NamingException {
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

   public List chargerCabinet(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
      List var3 = var2.createQuery("from CabinetPeg " + var1).list();
      new ArrayList();
      this.utilInitHibernate.closeSession();
      return var3;
   }
}
