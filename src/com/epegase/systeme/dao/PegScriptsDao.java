package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PegScripts;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PegScriptsDao implements Serializable {
   private PegScripts scripts;
   private UtilInitHibernate utilInitHibernate;

   public PegScriptsDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public PegScripts insert(PegScripts var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
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

   public PegScripts insert(PegScripts var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public PegScripts modif(PegScripts var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
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

   public void delete(PegScripts var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSysteme();
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

   public void delete(PegScripts var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectScripts() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getSysteme();
      List var2 = var1.createQuery("from PegScripts order by scrLibelle asc").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List chargerLesScripts(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getSysteme();
         var2 = true;
      }

      List var3 = var1.createQuery("from PegScripts where scrInactif=0").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((PegScripts)var4.get(var6)).getScrLibelle()));
         }
      }

      return var5;
   }

   public PegScripts rechercheScripts(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getSysteme();
         var4 = true;
      }

      Query var5 = var3.createQuery("from PegScripts where scrId=:id").setLong("id", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      new PegScripts();
      PegScripts var7;
      if (var6.size() > 0) {
         var7 = (PegScripts)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
