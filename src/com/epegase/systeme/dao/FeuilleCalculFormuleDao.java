package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.classe.FeuilleCalculFormule;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FeuilleCalculFormuleDao implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String mabase;

   public FeuilleCalculFormuleDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FeuilleCalculFormule insert(FeuilleCalculFormule var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
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

   public FeuilleCalculFormule insert(FeuilleCalculFormule var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FeuilleCalculFormule modif(FeuilleCalculFormule var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
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

   public FeuilleCalculFormule modif(FeuilleCalculFormule var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(FeuilleCalculFormule var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
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

   public void delete(FeuilleCalculFormule var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerRubriqueFeuille(FeuilleCalculRubrique var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery(" from FeuilleCalculFormule where feuilleCalculRubrique=:rub order by feurub_id").setParameter("rub", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public FeuilleCalculFormule chargerRubriqueFeuille(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var4 = true;
      }

      new FeuilleCalculFormule();
      new ArrayList();
      Query var7 = var3.createQuery(" from FeuilleCalculFormule where feuilleCalculRubrique.feurubCode=:rub and feuilleCalcul.feuCode=:feu").setString("rub", var1).setString("feu", var2).setMaxResults(1);
      List var6 = var7.list();
      FeuilleCalculFormule var5;
      if (var6.size() != 0) {
         var5 = (FeuilleCalculFormule)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public FeuilleCalculFormule chargerRubriqueFeuille(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      new FeuilleCalculFormule();
      new ArrayList();
      Query var8 = var4.createQuery(" from FeuilleCalculFormule where feuilleCalculRubrique.feurubCode=:rub and feuilleCalcul.feuCode=:feu and feurubforColonne=:col").setString("rub", var1).setString("feu", var2).setString("col", var3).setMaxResults(1);
      List var7 = var8.list();
      FeuilleCalculFormule var6;
      if (var7.size() != 0) {
         var6 = (FeuilleCalculFormule)var7.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerFeuille(FeuilleCalcul var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery(" from FeuilleCalculFormule where feuilleCalcul=:feu order by feurub_id, feurubfor_id").setParameter("feu", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerFeuille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery(" from FeuilleCalculFormule where feuilleCalcul.feuCode=:feu order by feurub_id").setString("feu", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
