package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PegDouanesPosition;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PegDouanesPositionDao implements Serializable {
   private UtilInitHibernate utilInitHibernate;

   public PegDouanesPositionDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public PegDouanesPosition insert(PegDouanesPosition var1) throws HibernateException, NamingException {
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

   public PegDouanesPosition modif(PegDouanesPosition var1) throws HibernateException, NamingException {
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

   public void delete(PegDouanesPosition var1) throws HibernateException, NamingException {
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

   public List rechecheGlobale() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getSysteme();
      Query var2 = null;
      var2 = var1.createQuery("from PegDouanesPosition order by douposCode desc");
      new ArrayList();
      List var3 = var2.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }
}
