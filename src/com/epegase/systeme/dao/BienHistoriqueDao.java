package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienHistorique;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BienHistoriqueDao implements Serializable {
   private BienHistorique bienHistorique;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BienHistoriqueDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BienHistorique insert(BienHistorique var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public BienHistorique insert(BienHistorique var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public BienHistorique modif(BienHistorique var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public BienHistorique modif(BienHistorique var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(BienHistorique var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public void delete(BienHistorique var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerHistoriqueByBien(Bien var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienHistorique where Bien=:bi order by biehisDateVente").setParameter("bi", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public BienHistorique pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienHistorique where biehisId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new BienHistorique();
      BienHistorique var7;
      if (var6.size() != 0) {
         var7 = (BienHistorique)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
