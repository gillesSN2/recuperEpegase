package com.epegase.systeme.dao;

import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LaboratoireReglement;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LaboratoireReglementDao implements Serializable {
   private LaboratoireReglement laboratoireReglement;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public LaboratoireReglementDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public LaboratoireReglement insert(LaboratoireReglement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
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

   public LaboratoireReglement insert(LaboratoireReglement var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public LaboratoireReglement modif(LaboratoireReglement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
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

   public LaboratoireReglement modif(LaboratoireReglement var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(LaboratoireReglement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
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

   public void delete(LaboratoireReglement var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteAllLigne(LaboratoireEntete var1, Session var2) {
      var2.createQuery("delete from LaboratoireReglement where laboratoireEntete=:id").setParameter("id", var1).executeUpdate();
   }

   public List selectReglementByEnt(LaboratoireEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From LaboratoireReglement where LaboratoireEntete=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectReglementByBonEncaissement(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From LaboratoireReglement where labregIdBonEncaissement=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectReglementByRecu(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From LaboratoireReglement where labregNumRecu=:num").setString("num", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectReglementByIdRecu(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From LaboratoireReglement where labregIdRecu=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectReglementByRecu(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From LaboratoireReglement where LaboratoireEntete.labId=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public LaboratoireReglement selectReglement(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "LaboratoireEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From LaboratoireReglement where labregId=:param").setLong("param", var1).setMaxResults(1).list();
      this.laboratoireReglement = new LaboratoireReglement();
      if (var5.size() != 0) {
         this.laboratoireReglement = (LaboratoireReglement)var5.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.laboratoireReglement;
   }
}
