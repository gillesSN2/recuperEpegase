package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesTaches;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SalariesTachesDao implements Serializable {
   private SalariesTaches salariesTaches;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesTachesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesTaches insert(SalariesTaches var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
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

   public SalariesTaches modif(SalariesTaches var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
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

   public void delete(SalariesTaches var1, Session var2) {
      var2.delete(var1);
   }

   public SalariesTaches deletetache(SalariesTaches var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
      Transaction var3 = var2.beginTransaction();
      var2.createQuery("delete from SalariesTaches where saltacId=:id").setLong("id", var1.getSaltacId()).executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return var1;
   }

   public List selectUsersTaches(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
         var3 = true;
      }

      List var4 = var2.createQuery("from SalariesTaches where salaries=:id").setLong("id", var1.getSalId()).list();
      new ArrayList();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public SalariesTaches selectUsersTaches(String var1, Salaries var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesTaches where salaries=:id and saltacCode=:cod").setLong("id", var2.getSalId()).setString("cod", var1).setMaxResults(1);
      new ArrayList();
      List var6 = var5.list();
      if (var6.size() != 0) {
         this.salariesTaches = (SalariesTaches)var6.get(0);
      } else {
         this.salariesTaches = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.salariesTaches;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from SalariesTaches where saltacCode=:cod ").setString("cod", var1).setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
