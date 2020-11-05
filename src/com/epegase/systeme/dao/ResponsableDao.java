package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ResponsableDao implements Serializable {
   private Responsable responsable;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ResponsableDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Responsable insert(Responsable var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Responsable insert(Responsable var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
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

   public Responsable modif(Responsable var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
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

   public Responsable modif(Responsable var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(Responsable var1, Session var2) {
      var2.delete(var1);
   }

   public String deletResponsable(Responsable var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from Responsable where rpbid =:Id").setParameter("Id", var1.getRpbid());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public List selectResponsable(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Responsable").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectResponsableUnique(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      List var3 = var1.createQuery("from Responsable where rpbuserid <> 0 group by rpbuserid order by rpbuserid").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesResponsables(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Responsable where tiers=:tiers").setParameter("tiers", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Responsable pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Responsable where rpbid=:id").setLong("id", var1);
      List var6 = var5.list();
      this.responsable = new Responsable();
      if (var6.size() != 0) {
         this.responsable = (Responsable)var6.get(0);
      } else {
         this.responsable = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.responsable;
   }

   public List chargerLesResponsablesDocument(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Responsable where tiers=:tiers and rpbdefaut=1 order by rpbnom").setParameter("tiers", var1);
      List var5 = var4.list();
      if (var5.size() == 0) {
         var4 = var2.createQuery("from Responsable where tiers=:tiers order by rpbnom").setParameter("tiers", var1);
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesResponsables(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var5 = true;
      }

      Query var6 = var4.createQuery("from Responsable where rpbuserid=:id and tiers.tieid in " + var3 + " group by tiers.tieid").setLong("id", var1);
      List var7 = var6.list();
      ArrayList var8 = new ArrayList();
      if (var7.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            var8.add(((Responsable)var7.get(var9)).getTiers());
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesResponsables(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Responsable where rpbuserid=:id group by tiers.tieid").setLong("id", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List listeConseillers(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      new ArrayList();
      List var4 = var2.createQuery(var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List listeConseillersByTiers(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      new ArrayList();
      ArrayList var5 = new ArrayList();
      List var4 = var2.createQuery(var1 + " group by tiers.tieid").list();
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(((Responsable)var4.get(var6)).getTiers());
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
