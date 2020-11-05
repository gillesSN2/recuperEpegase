package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ProcessEnteteAchats;
import com.epegase.systeme.classe.ProcessLigneAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProcessLigneAchatsDao implements Serializable {
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ProcessLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ProcessLigneAchats insert(ProcessLigneAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
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

   public ProcessLigneAchats insert(ProcessLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ProcessLigneAchats modif(ProcessLigneAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
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

   public ProcessLigneAchats modif(ProcessLigneAchats var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(ProcessLigneAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
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

   public void delete(ProcessLigneAchats var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerDetailProcess(ProcessEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
         var3 = true;
      }

      List var4 = var2.createQuery("from ProcessLigneAchats where processEnteteAchats=:ent").setParameter("ent", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ProcessLigneAchats chercherLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ProcessAchats");
         var4 = true;
      }

      List var5 = var3.createQuery("from ProcessLigneAchats where procesligId=:id").setLong("id", var1).setMaxResults(1).list();
      new ProcessLigneAchats();
      ProcessLigneAchats var6;
      if (var5.size() != 0) {
         var6 = (ProcessLigneAchats)var5.get(0);
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
