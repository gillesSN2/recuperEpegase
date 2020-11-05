package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.TiersTechnique;
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

public class TiersTechniqueDao implements Serializable {
   private TiersTechnique tiersTechnique;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public TiersTechniqueDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public TiersTechnique insert(TiersTechnique var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
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

   public TiersTechnique insert(TiersTechnique var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public TiersTechnique modif(TiersTechnique var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
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

   public TiersTechnique modif(TiersTechnique var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(TiersTechnique var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
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

   public void delete(TiersTechnique var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List listTechnique(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var2 = true;
      }

      List var3 = var1.createQuery("from TiersTechnique").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List listTechniqueItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var2 = true;
      }

      ArrayList var3 = new ArrayList();
      new ArrayList();
      List var5 = var1.createQuery("from TiersTechnique group by tiers.tieraisonsocialenom").list();
      List var4 = var5;
      if (var5.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var3.add(new SelectItem(((TiersTechnique)var4.get(var6)).getTiers().getTieid(), ((TiersTechnique)var4.get(var6)).getTiers().getTieraisonsocialenom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List listTechniqueByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Object var4 = new ArrayList();
      if (var1 != null) {
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
            var3 = true;
         }

         Query var5 = var2.createQuery("from TiersTechnique where tiers=:tiers");
         var5.setParameter("tiers", var1);
         var4 = var5.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var4;
   }

   public List listTechniqueByTiers(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      Object var5 = new ArrayList();
      if (var1 != 0L) {
         if (var3 == null) {
            var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
            var4 = true;
         }

         Query var6 = var3.createQuery("from TiersTechnique where tiers.tieid=:tiers").setLong("tiers", var1);
         var5 = var6.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var5;
   }
}
