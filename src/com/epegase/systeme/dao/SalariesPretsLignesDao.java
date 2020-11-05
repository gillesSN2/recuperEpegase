package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesPrets;
import com.epegase.systeme.classe.SalariesPretsLignes;
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

public class SalariesPretsLignesDao implements Serializable {
   private SalariesPrets salariesPrets;
   private SalariesPretsLignes salariesPretsLignes;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesPretsLignesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesPretsLignes insert(SalariesPretsLignes var1) throws HibernateException, NamingException {
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

   public SalariesPretsLignes insert(SalariesPretsLignes var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public void insertAllLigne(List var1, Session var2) {
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            this.salariesPretsLignes = (SalariesPretsLignes)var1.get(var3);
            var2.save(this.salariesPretsLignes);
         }
      }

   }

   public SalariesPretsLignes modif(SalariesPretsLignes var1) throws HibernateException, NamingException {
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

   public SalariesPretsLignes modif(SalariesPretsLignes var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(SalariesPretsLignes var1) throws HibernateException, NamingException {
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

   public void deleteAllLigne(List var1, Session var2) throws HibernateException, NamingException {
      if (var1.size() != 0) {
         new SalariesPretsLignes();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            SalariesPretsLignes var3 = (SalariesPretsLignes)var1.get(var4);
            var3 = this.pourParapheur(var3.getSalpreligId(), var2);
            if (var3 != null) {
               var2.delete(var3);
            }
         }
      }

   }

   public List chargerlesPretsLignes(SalariesPrets var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesPretsLignes where SalariesPrets=:prt order by salpreligDateTheo asc").setParameter("prt", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesPretsLignes(String var1, Salaries var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from SalariesPretsLignes where SalariesPrets.salpreNum=:num and Salaries=:sal order by salpreligDateTheo asc").setString("num", var1).setParameter("sal", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesPretsLignesValide(SalariesPrets var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesPretsLignes where SalariesPrets=:prt and SalariesPrets.salpreEtat=1 order by salpreligDateTheo asc").setParameter("prt", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesPretsLignesBySalariesPeriode(Salaries var1, Date var2, Date var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var4 == 9) {
         var8 = var5.createQuery("from SalariesPretsLignes where Salaries=:sal and salpreligDateTheo>=:deb and salpreligDateTheo<=:fin order by salpreligDateTheo asc").setParameter("sal", var1).setDate("deb", var2).setDate("fin", var3);
      } else {
         var8 = var5.createQuery("from SalariesPretsLignes where Salariesle=:sal and SalariesPrets.salpreType=:typ and salpreligDateTheo>=:deb and salpreligDateTheo<=:fin order by salpreligDateTheo asc").setParameter("sal", var1).setInteger("typ", var4).setDate("deb", var2).setDate("fin", var3);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesPretsLignesBySalariesValidePeriode(Salaries var1, Date var2, Date var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var4 == 9) {
         var8 = var5.createQuery("from SalariesPretsLignes where Salaries=:sal and salpreligDateTheo>=:deb and salpreligDateTheo<=:fin and SalariesPrets.salpreEtat=1 order by salpreligDateTheo asc").setParameter("sal", var1).setDate("deb", var2).setDate("fin", var3);
      } else {
         var8 = var5.createQuery("from SalariesPretsLignes where Salariesle=:sal and SalariesPrets.salpreType=:typ and salpreligDateTheo>=:deb and salpreligDateTheo<=:fin and SalariesPrets.salpreEtat=1 order by salpreligDateTheo asc").setParameter("sal", var1).setInteger("typ", var4).setDate("deb", var2).setDate("fin", var3);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesPretsLignesValidePeriode(Date var1, Date var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var3 == 9) {
         var7 = var4.createQuery("from SalariesPretsLignes where salpreligDateTheo>=:deb and salpreligDateTheo<=:fin and SalariesPrets.salpreEtat=1 order by salpreligDateTheo asc").setDate("deb", var1).setDate("fin", var2);
      } else {
         var7 = var4.createQuery("from SalariesPretsLignes where SalariesPrets.salpreType=:typ and salpreligDateTheo>=:deb and salpreligDateTheo<=:fin and SalariesPrets.salpreEtat=1 order by salpreligDateTheo asc").setInteger("typ", var3).setDate("deb", var1).setDate("fin", var2);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public SalariesPretsLignes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from SalariesPretsLignes where salpreligId=:id").setParameter("id", var1);
      List var5 = var6.list();
      this.salariesPretsLignes = new SalariesPretsLignes();
      if (var5.size() != 0) {
         this.salariesPretsLignes = (SalariesPretsLignes)var5.get(0);
      } else {
         this.salariesPretsLignes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.salariesPretsLignes;
   }
}
