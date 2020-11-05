package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.RevueCompte;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RevueCompteDao implements Serializable {
   private RevueCompte revueCompte;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public RevueCompteDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public RevueCompte insert(RevueCompte var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RevueCompte");
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

   public RevueCompte insert(RevueCompte var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public RevueCompte modif(RevueCompte var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RevueCompte");
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

   public RevueCompte modif(RevueCompte var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(RevueCompte var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RevueCompte");
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

   public void delete(RevueCompte var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerRevue(ExercicesComptable var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RevueCompte");
         var3 = true;
      }

      Query var4 = var2.createQuery("from RevueCompte where exercicesComptable.execpt_id=" + var1.getExecpt_id());
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public RevueCompte chargerRevue(ExercicesComptable var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "RevueCompte");
         var4 = true;
      }

      Query var5 = var3.createQuery("from RevueCompte where exercicesComptable.execpt_id=" + var1.getExecpt_id() + " and revcptCompte='" + var2 + "'").setMaxResults(1);
      this.revueCompte = new RevueCompte();
      List var6 = var5.list();
      if (var6.size() != 0) {
         this.revueCompte = (RevueCompte)var6.get(0);
      } else {
         this.revueCompte = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.revueCompte;
   }
}
