package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.TiersAdherent;
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

public class TiersAdherentDao implements Serializable {
   private TiersAdherent tiersAdherent;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public TiersAdherentDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public TiersAdherent insert(TiersAdherent var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "TiersAdherent");
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

   public TiersAdherent insert(TiersAdherent var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public TiersAdherent modif(TiersAdherent var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "TiersAdherent");
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

   public TiersAdherent modif(TiersAdherent var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(TiersAdherent var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "TiersAdherent");
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

   public void delete(TiersAdherent var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List listAdherent(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "TiersAdherent");
         var2 = true;
      }

      List var3 = var1.createQuery("from TiersAdherent").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List listAdherentItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "TiersAdherent");
         var2 = true;
      }

      ArrayList var3 = new ArrayList();
      new ArrayList();
      List var5 = var1.createQuery("from TiersAdherent group by tiers.tieadhraisonsocialenom").list();
      List var4 = var5;
      if (var5.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var3.add(new SelectItem(((TiersAdherent)var4.get(var6)).getTiers().getTieid(), ((TiersAdherent)var4.get(var6)).getTiers().getTieraisonsocialenom()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List listAdherentByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      Object var4 = new ArrayList();
      if (var1 != null) {
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "TiersAdherent");
            var3 = true;
         }

         Query var5 = var2.createQuery("from TiersAdherent where tiers=:tiers");
         var5.setParameter("tiers", var1);
         var4 = var5.list();
         if (var3) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var4;
   }

   public List listAdherentByTiersItems(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      ArrayList var4 = new ArrayList();
      new ArrayList();
      if (var1 != null) {
         if (var2 == null) {
            var2 = this.utilInitHibernate.getOpenSession(this.maBase, "TiersAdherent");
            var3 = true;
         }

         Query var6 = var2.createQuery("from TiersAdherent where tiers=:tiers order by tieadhRaisonSociale").setParameter("tiers", var1);
         List var5 = var6.list();
         if (var5.size() != 0) {
            for(int var7 = 0; var7 < var5.size(); ++var7) {
               var4.add(new SelectItem(((TiersAdherent)var5.get(var7)).getTieadhRaisonSociale()));
            }
         }

         if (var3) {
            this.utilInitHibernate.closeSession();
         }
      }

      return var4;
   }

   public List listAdherentByTiers(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      Object var5 = new ArrayList();
      if (var1 != 0L) {
         if (var3 == null) {
            var3 = this.utilInitHibernate.getOpenSession(this.maBase, "TiersAdherent");
            var4 = true;
         }

         Query var6 = var3.createQuery("from TiersAdherent where tiers.tieid=:tiers order by tieadhRaisonSociale").setLong("tiers", var1);
         var5 = var6.list();
         if (var4) {
            this.utilInitHibernate.closeSession();
         }
      }

      return (List)var5;
   }

   public long listAdherentByTiersEmployeur(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      long var6 = 0L;
      new ArrayList();
      if (var1 != 0L) {
         if (var4 == null) {
            var4 = this.utilInitHibernate.getOpenSession(this.maBase, "TiersAdherent");
            var5 = true;
         }

         this.tiersAdherent = new TiersAdherent();
         Query var9 = var4.createQuery("from TiersAdherent where tiers.tieid=:tiers and tieadhRaisonSociale=:emp  order by tieadhRaisonSociale").setLong("tiers", var1).setString("emp", var3);
         List var8 = var9.list();
         if (var8.size() != 0) {
            this.tiersAdherent = (TiersAdherent)var8.get(0);
            var6 = this.tiersAdherent.getTieadhId();
         }

         if (var5) {
            this.utilInitHibernate.closeSession();
         }
      }

      return var6;
   }
}
