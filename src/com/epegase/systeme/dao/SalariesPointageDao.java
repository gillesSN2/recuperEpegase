package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesPointage;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SalariesPointageDao implements Serializable {
   private SalariesPointage salariesPointage;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesPointageDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesPointage insert(SalariesPointage var1) throws HibernateException, NamingException {
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

   public SalariesPointage insert(SalariesPointage var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SalariesPointage modif(SalariesPointage var1) throws HibernateException, NamingException {
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

   public SalariesPointage modif(SalariesPointage var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(SalariesPointage var1) throws HibernateException, NamingException {
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

   public void delete(SalariesPointage var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerlesPointages(Salaries var1, String var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var3 != 100) {
         var7 = var4.createQuery("from SalariesPointage where Salaries=:salarie and salpoiPeriode=:per and salpoiEtat=:ett order by salpoiDate asc").setParameter("salarie", var1).setString("per", var2).setInteger("ett", var3);
      } else {
         var7 = var4.createQuery("from SalariesPointage where Salaries=:salarie and salpoiPeriode=:per order by salpoiDate asc").setParameter("salarie", var1).setString("per", var2);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesPointages(String var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery("from SalariesPointage where salpoiMission=:mis and salpoiDate>=:d1 and salpoiDate<=:d2 order by salpoiDate asc").setString("mis", var1).setDate("d1", var2).setDate("d2", var3);
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public SalariesPointage pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesPointage where salpoiId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      SalariesPointage var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesPointage)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public SalariesPointage pointageJourBySalarie(Salaries var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesPointage where Salaries=:salarie and salpoiDate=:jour").setParameter("salarie", var1).setDate("jour", var2).setMaxResults(1);
      List var6 = var5.list();
      SalariesPointage var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesPointage)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesPointagesRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesPointage where " + var1 + " order by salpoiDate asc");
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
