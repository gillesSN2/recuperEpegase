package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PegEvolution;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PegEvolutionDao implements Serializable {
   private UtilInitHibernate utilInitHibernate;

   public PegEvolutionDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public PegEvolution insert(PegEvolution var1) throws HibernateException, NamingException {
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

   public PegEvolution modif(PegEvolution var1) throws HibernateException, NamingException {
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

   public void delete(PegEvolution var1) throws HibernateException, NamingException {
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

   public List rechecheGlobale(String var1, String var2, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getSysteme();
      Query var5 = null;
      String var6 = "";
      if (var3 != null && !var3.isEmpty()) {
         var6 = " and pegevoModule='" + var3 + "' or pegevoObjet like '%" + var3 + "%' or pegevoDetail like '%" + var3 + "%'";
      }

      var5 = var4.createQuery("from PegEvolution where pegevoDate between '" + var1 + "' and '" + var2 + "'" + var6 + " order by pegevoDate desc");
      new ArrayList();
      List var7 = var5.list();
      this.utilInitHibernate.closeSession();
      return var7;
   }

   public List rechecheGlobale() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getSysteme();
      Query var2 = null;
      var2 = var1.createQuery("from PegEvolution order by pegevoDate desc");
      new ArrayList();
      List var3 = var2.list();
      this.utilInitHibernate.closeSession();
      return var3;
   }
}
