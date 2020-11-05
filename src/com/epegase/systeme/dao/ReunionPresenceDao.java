package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ReunionEntete;
import com.epegase.systeme.classe.ReunionPresence;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReunionPresenceDao implements Serializable {
   private ReunionPresence reunionPresence;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ReunionPresenceDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ReunionPresence insert(ReunionPresence var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
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

   public ReunionPresence insert(ReunionPresence var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ReunionPresence modif(ReunionPresence var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
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

   public ReunionPresence maj(ReunionPresence var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public void updateListe(List var1, ReunionEntete var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         new ReunionPresence();
         ReunionPresence var5 = (ReunionPresence)var1.get(var4);
         if (var5.isReupreSansStatut()) {
            if (var5.getReupreId() != 0L) {
               var3.delete(var5);
            }
         } else if (var5.getReupreId() == 0L) {
            var5.setReunionEntete(var2);
            var5.setReupreNum(var2.getReuNum());
            var3.save(var5);
         } else {
            var3.update(var5);
         }
      }

   }

   public ReunionPresence modif(ReunionPresence var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(ReunionPresence var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
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

   public void deleteListe(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            new ReunionPresence();
            ReunionPresence var5 = (ReunionPresence)var1.get(var4);
            if (var5.getReupreId() != 0L) {
               var2.delete(var5);
            }
         }

         var3.commit();
      } catch (HibernateException var9) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void delete(ReunionPresence var1, Session var2) {
      var2.delete(var1);
   }

   public List selectReunionPresence(ReunionEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ReunionPresence where reunionEntete=:id").setParameter("id", var1).list();
      new ArrayList();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectReunion(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
         var4 = true;
      }

      Date var5 = new Date();
      List var6 = var3.createQuery("from ReunionPresence where reupreIdUser=:id and reunionEntete.reuEtat=0 and reunionEntete.reuDate=:dtj").setLong("id", var1).setDate("dtj", var5).list();
      new ArrayList();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ReunionPresence trouveReunion(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReunionEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from ReunionPresence where reupreId=:id").setLong("id", var1).setMaxResults(1).list();
      new ArrayList();
      this.reunionPresence = new ReunionPresence();
      if (var5.size() != 0) {
         this.reunionPresence = (ReunionPresence)var5.get(0);
      } else {
         this.reunionPresence = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.reunionPresence;
   }
}
