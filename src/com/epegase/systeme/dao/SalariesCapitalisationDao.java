package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesCapitalisation;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SalariesCapitalisationDao implements Serializable {
   private SalariesCapitalisation salariesCapitalisation;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesCapitalisationDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesCapitalisation insert(SalariesCapitalisation var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
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

   public SalariesCapitalisation insert(SalariesCapitalisation var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SalariesCapitalisation modif(SalariesCapitalisation var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
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

   public SalariesCapitalisation modif(SalariesCapitalisation var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(SalariesCapitalisation var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
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

   public void delete(SalariesCapitalisation var1, Session var2) {
      var2.delete(var1);
   }

   public SalariesCapitalisation chargerleCapital(Salaries var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var3.createQuery("from SalariesCapitalisation where Salaries=:salarie and ((salcapContrat is null or salcapContrat = '') or (salcapContrat is not null and salcapContrat=:crt))").setParameter("salarie", var1).setString("crt", var2).setMaxResults(1);
      } else {
         var5 = var3.createQuery("from SalariesCapitalisation where Salaries=:salarie").setParameter("salarie", var1).setMaxResults(1);
      }

      List var6 = var5.list();
      SalariesCapitalisation var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesCapitalisation)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesMvts(Salaries var1, SalariesCapitalisation var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      String var5 = "bulligRubrique='" + var2.getSalcapRubVersement() + "'";
      if (var2.getSalcapRubSpontanee() != null && !var2.getSalcapRubSpontanee().isEmpty()) {
         var5 = var5 + " or bulligRubrique='" + var2.getSalcapRubSpontanee() + "'";
      }

      if (var2.getSalcapRubRetrait() != null && !var2.getSalcapRubRetrait().isEmpty()) {
         var5 = var5 + " or bulligRubrique='" + var2.getSalcapRubRetrait() + "'";
      }

      Query var6 = var3.createQuery("from BulletinLigne where Salaries=:salarie and (" + var5 + ")").setParameter("salarie", var1);
      new ArrayList();
      List var7 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public SalariesCapitalisation pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesCapitalisation where salcapId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      SalariesCapitalisation var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesCapitalisation)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
