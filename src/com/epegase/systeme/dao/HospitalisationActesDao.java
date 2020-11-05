package com.epegase.systeme.dao;

import com.epegase.systeme.classe.HospitalisationActes;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HospitalisationActesDao implements Serializable {
   private HospitalisationActes hospitalisationActes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public HospitalisationActesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public HospitalisationActes insert(HospitalisationActes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
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

   public HospitalisationActes insert(HospitalisationActes var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public HospitalisationActes modif(HospitalisationActes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
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

   public HospitalisationActes modif(HospitalisationActes var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(HospitalisationActes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
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

   public void delete(HospitalisationActes var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteAllLigne(HospitalisationEntete var1, Session var2) {
      var2.createQuery("delete from HospitalisationActes where HospitalisationEntete=:id").setParameter("id", var1).executeUpdate();
   }

   public List selectActesByEnt(HospitalisationEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From HospitalisationActes where HospitalisationEntete=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectActesByEnt(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From HospitalisationActes where HospitalisationEntete.hosId=:param").setLong("param", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectActesByHospitSejour(HospitalisationEntete var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var5 = true;
      }

      List var6 = var4.createQuery("From HospitalisationActes where HospitalisationEntete=:param and hosactIdSejour=:id").setParameter("param", var1).setLong("id", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public HospitalisationActes selectHospitActes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From HospitalisationActes where hosactId=:param").setLong("param", var1).setMaxResults(1).list();
      this.hospitalisationActes = new HospitalisationActes();
      if (var5.size() != 0) {
         this.hospitalisationActes = (HospitalisationActes)var5.get(0);
      } else {
         this.hospitalisationActes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.hospitalisationActes;
   }

   public List chargerLesLignesActes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from HospitalisationActes where HospitalisationEntete.hosNum in (" + var1 + ") order by hosactLibelle").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerActesByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from HospitalisationActes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
