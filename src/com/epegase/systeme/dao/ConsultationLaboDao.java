package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConsultationLabo;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConsultationLaboDao implements Serializable {
   private ConsultationLabo consultationLabo;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ConsultationLaboDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ConsultationLabo insert(ConsultationLabo var1) throws HibernateException, NamingException {
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

   public ConsultationLabo modif(ConsultationLabo var1) throws HibernateException, NamingException {
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

   public void delete(ConsultationLabo var1) throws HibernateException, NamingException {
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

   public void delete(ConsultationLabo var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteConsulLaboByConsultEnt(ConsultationEnteteGene var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      String var4 = "delete from ConsultationLabo where ConsultationEnteteGene=:param";
      Query var5 = var2.createQuery(var4);
      var5.setParameter("param", var1);
      int var6 = var5.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
   }

   public void deleteConsulLaboByConsultEnt(ConsultationEnteteGene var1, Session var2) throws HibernateException, NamingException {
      String var3 = "delete from ConsultationLabo where ConsultationEnteteGene=:param";
      Query var4 = var2.createQuery(var3);
      var4.setParameter("param", var1);
      int var5 = var4.executeUpdate();
   }

   public List selectConsLaboByConsEnt(ConsultationEnteteGene var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From ConsultationLabo where ConsultationEnteteGene=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesProduits(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ConsultationLabo where ConsultationEnteteGene.csgNum in (" + var1 + ") order by csllabProduit").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvtsDate(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      List var5 = null;
      var5 = var3.createQuery("from ConsultationLabo where ConsultationEnteteGene.csgDate between '" + var1 + "' and '" + var2 + "'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesMvtsInfirmerieDate(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from ConsultationLabo where ConsultationEnteteGene.csgDate between '" + var2 + "' and '" + var3 + "' and ConsultationEnteteGene.csgService='" + var1 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerConsultationByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from ConsultationLabo where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
