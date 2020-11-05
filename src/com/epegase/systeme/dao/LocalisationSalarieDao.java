package com.epegase.systeme.dao;

import com.epegase.systeme.classe.LocalisationSalarie;
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

public class LocalisationSalarieDao implements Serializable {
   private LocalisationSalarie localisationSalarie;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public LocalisationSalarieDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public LocalisationSalarie insert(LocalisationSalarie var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationSalarie");
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

   public LocalisationSalarie insert(LocalisationSalarie var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public LocalisationSalarie modif(LocalisationSalarie var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationSalarie");
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

   public void delete(LocalisationSalarie var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationSalarie");
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

   public void delete(LocalisationSalarie var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectLocalisationSalarie(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationSalarie");
         var2 = true;
      }

      List var3 = var1.createQuery("from LocalisationSalarie order by locsalNomFr asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesLocalisationSalarie(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationSalarie");
         var2 = true;
      }

      List var3 = var1.createQuery("from LocalisationSalarie where locsalInactif=0 order by locsalNomFr asc").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((LocalisationSalarie)var4.get(var6)).getLocsalNomFr()));
         }
      }

      return var5;
   }

   public LocalisationSalarie chargeLieu(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationSalarie");
         var3 = true;
      }

      Query var4 = var2.createQuery("from LocalisationSalarie ja where ja.locsalNomFr=:cod").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      if (var5.size() > 0) {
         this.localisationSalarie = (LocalisationSalarie)var5.get(0);
      } else {
         this.localisationSalarie = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.localisationSalarie;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "LocalisationSalarie");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from LocalisationSalarie ja where ja.locsalNomFr=:cod").setString("cod", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
