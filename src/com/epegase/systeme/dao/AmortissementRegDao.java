package com.epegase.systeme.dao;

import com.epegase.systeme.classe.AmortissementReg;
import com.epegase.systeme.classe.Amortissements;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AmortissementRegDao implements Serializable {
   private AmortissementReg amortissementReg;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public AmortissementRegDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public AmortissementReg insert(AmortissementReg var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
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

   public AmortissementReg insert(AmortissementReg var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public AmortissementReg modif(AmortissementReg var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
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

   public void delete(AmortissementReg var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
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

   public void delete(AmortissementReg var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerReglement(Amortissements var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
         var3 = true;
      }

      Query var4 = var2.createQuery("FROM AmortissementReg WHERE amortissements=:amt").setParameter("amt", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerReglement(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
         var2 = true;
      }

      Query var3 = var1.createQuery("FROM AmortissementReg WHERE  amortissements.amoTypeSortie=0");
      new ArrayList();
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
