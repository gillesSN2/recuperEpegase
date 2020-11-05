package com.epegase.systeme.dao;

import com.epegase.systeme.classe.EcrituresModeles;
import com.epegase.systeme.classe.EcrituresModelesLignes;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EcrituresModelesLignesDao implements Serializable {
   private String maBase;
   private UtilInitHibernate utilInitHibernate;
   private EcrituresModelesLignes ecrituresModelesLignes;

   public EcrituresModelesLignesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public EcrituresModelesLignes insert(EcrituresModelesLignes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
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

   public EcrituresModelesLignes insert(EcrituresModelesLignes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public EcrituresModelesLignes modif(EcrituresModelesLignes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
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

   public void delete(EcrituresModelesLignes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
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

   public void delete(EcrituresModelesLignes var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectModelesLignes(EcrituresModeles var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var3 = true;
      }

      List var4 = var2.createQuery("from EcrituresModelesLignes where EcrituresModeles=:ecr order by modligCompte asc").setParameter("ecr", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
