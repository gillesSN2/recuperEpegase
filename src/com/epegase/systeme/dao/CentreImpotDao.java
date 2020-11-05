package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CentreImpot;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CentreImpotDao implements Serializable {
   private CentreImpot centreImpot;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CentreImpotDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CentreImpot insert(CentreImpot var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CentreImpot modif(CentreImpot var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(CentreImpot var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CentreImpot");
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

   public CentreImpot rechercheEntreImpotByCode(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CentreImpot");
         var4 = true;
      }

      List var5 = var3.createQuery("from CentreImpot where cenimpCode=:cod and cenimpType=:typ").setString("cod", var1).setInteger("typ", var2).list();
      if (var5.size() != 0) {
         this.centreImpot = (CentreImpot)var5.get(0);
      } else {
         this.centreImpot = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.centreImpot;
   }

   public List chargerCentreImpot(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CentreImpot");
         var2 = true;
      }

      List var3 = var1.createQuery("from CentreImpot where cenimpType=0").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerCentreSecuriteSociale(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CentreImpot");
         var2 = true;
      }

      List var3 = var1.createQuery("from CentreImpot where cenimpType=1").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }
}
