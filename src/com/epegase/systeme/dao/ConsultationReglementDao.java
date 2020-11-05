package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConsultationReglement;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConsultationReglementDao implements Serializable {
   private ConsultationReglement consultationReglement;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ConsultationReglementDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ConsultationReglement insert(ConsultationReglement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public ConsultationReglement insert(ConsultationReglement var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ConsultationReglement modif(ConsultationReglement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public ConsultationReglement modif(ConsultationReglement var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(ConsultationReglement var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public void delete(ConsultationReglement var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteAllLigne(ConsultationEnteteGene var1, Session var2) {
      var2.createQuery("delete from ConsultationReglement where ConsultationEnteteGene=:id").setParameter("id", var1).executeUpdate();
   }

   public List selectReglementByEnt(ConsultationEnteteGene var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From ConsultationReglement where ConsultationEnteteGene=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectReglementByBonEncaissement(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From ConsultationReglement where csgregIdBonEncaissement=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectReglementByRecu(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From ConsultationReglement where csgregNumRecu=:num").setString("num", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectReglementByRecu(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From ConsultationReglement where ConsultationEnteteGene.csgId=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectReglementByIdRecu(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From ConsultationReglement where csgregIdRecu=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ConsultationReglement selectReglement(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From ConsultationReglement where csgregId=:param").setLong("param", var1).setMaxResults(1).list();
      this.consultationReglement = new ConsultationReglement();
      if (var5.size() != 0) {
         this.consultationReglement = (ConsultationReglement)var5.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.consultationReglement;
   }
}
