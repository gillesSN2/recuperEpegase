package com.epegase.systeme.dao;

import com.epegase.systeme.classe.AmortissementInv;
import com.epegase.systeme.classe.Amortissements;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AmortissementInvDao implements Serializable {
   private AmortissementInv amortissementInv;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public AmortissementInvDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public AmortissementInv insert(AmortissementInv var1) throws HibernateException, NamingException {
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

   public AmortissementInv insert(AmortissementInv var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public AmortissementInv modif(AmortissementInv var1) throws HibernateException, NamingException {
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

   public void delete(AmortissementInv var1) throws HibernateException, NamingException {
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

   public void delete(AmortissementInv var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerInventaire(Amortissements var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
         var3 = true;
      }

      Query var4 = var2.createQuery("FROM AmortissementInv WHERE amortissements=:amt").setParameter("amt", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerInventaire(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Amortissements");
         var5 = true;
      }

      Query var6 = var4.createQuery("FROM AmortissementInv WHERE amortissements.amoId in (" + var1 + ") and  amoinvDateCreat>=:debut and amoinvDateCreat<=:fin").setString("debut", var2).setString("fin", var3);
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
