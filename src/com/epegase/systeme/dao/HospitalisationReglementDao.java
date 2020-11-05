package com.epegase.systeme.dao;

import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.HospitalisationReglement;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HospitalisationReglementDao implements Serializable {
   private HospitalisationReglement hospitalisationReglement;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public HospitalisationReglementDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public HospitalisationReglement insert(HospitalisationReglement var1) throws HibernateException, NamingException {
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

   public HospitalisationReglement insert(HospitalisationReglement var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public HospitalisationReglement modif(HospitalisationReglement var1) throws HibernateException, NamingException {
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

   public HospitalisationReglement modif(HospitalisationReglement var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(HospitalisationReglement var1) throws HibernateException, NamingException {
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

   public void delete(HospitalisationReglement var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteAllLigne(HospitalisationEntete var1, Session var2) {
      var2.createQuery("delete from HospitalisationReglement where HospitalisationEntete=:id").setParameter("id", var1).executeUpdate();
   }

   public List selectReglementByEnt(HospitalisationEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From HospitalisationReglement where HospitalisationEntete=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectReglementByHospit(HospitalisationEntete var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var5 = true;
      }

      List var6 = var4.createQuery("From HospitalisationReglement where HospitalisationEntete=:param and hosprtIdSejour=:id").setParameter("param", var1).setLong("id", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectReglementByBonEncaissement(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From HospitalisationReglement where hosregIdBonEncaissement=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectReglementByRecu(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From HospitalisationReglement where hosregNumRecu=:num").setString("num", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectReglementByRecu(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From HospitalisationReglement where HospitalisationEntete.hosId=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectReglementByIdRecu(long var1, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var6 = true;
      }

      List var7 = var5.createQuery("From HospitalisationReglement where hosregIdRecu=:id and HospitalisationEntete.hosId=:idHos").setLong("id", var1).setLong("idHos", var3).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public HospitalisationReglement selectReglement(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From HospitalisationReglement where hosregIdCaution=:param").setLong("param", var1).setMaxResults(1).list();
      this.hospitalisationReglement = new HospitalisationReglement();
      if (var5.size() != 0) {
         this.hospitalisationReglement = (HospitalisationReglement)var5.get(0);
      } else {
         this.hospitalisationReglement = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.hospitalisationReglement;
   }
}
