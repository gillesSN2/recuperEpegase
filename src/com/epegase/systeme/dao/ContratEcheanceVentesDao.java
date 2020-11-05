package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ContratEcheanceVentes;
import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContratEcheanceVentesDao implements Serializable {
   private ContratEcheanceVentes contratEcheanceVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ContratEcheanceVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ContratEcheanceVentes insertLigne(ContratEcheanceVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
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

   public ContratEcheanceVentes insertLigne(ContratEcheanceVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ContratEcheanceVentes modifLigne(ContratEcheanceVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
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

   public ContratEcheanceVentes modifLigne(ContratEcheanceVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteAllLigne(ContratEnteteVentes var1, Session var2) {
      var2.createQuery("delete from ContratEcheanceVentes where contratEnteteVentes=:id").setLong("id", var1.getCrtId()).executeUpdate();
      return "";
   }

   public String deleteOneLigne(ContratEcheanceVentes var1, Session var2) {
      Query var3 = var2.createQuery("delete from ContratEcheanceVentes where crtechId =" + var1.getCrtechId());
      var3.executeUpdate();
      return "";
   }

   public List chargerLesLignes(ContratEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var3 = true;
      }

      List var4 = var2.createQuery("from ContratEcheanceVentes where contratEnteteVentes=:idfk order by crtechId").setLong("idfk", var1.getCrtId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesContrats(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var3 = true;
      }

      List var4 = var2.createQuery("from ContratEcheanceVentes where contratEnteteVentes.crtNum in (" + var1 + ") order by crtechId").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ContratEcheanceVentes chargerLaLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var4 = true;
      }

      this.contratEcheanceVentes = new ContratEcheanceVentes();
      List var5 = var3.createQuery("from ContratEcheanceVentes where crtechId=:idfk").setLong("idfk", var1).list();
      if (var5.size() != 0) {
         this.contratEcheanceVentes = (ContratEcheanceVentes)var5.get(0);
      } else {
         this.contratEcheanceVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.contratEcheanceVentes;
   }

   public List rechercheContratRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ContratEcheanceVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
