package com.epegase.systeme.dao;

import com.epegase.systeme.classe.EcrituresModeles;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EcrituresModelesDao implements Serializable {
   private String maBase;
   private UtilInitHibernate utilInitHibernate;
   private EcrituresModeles ecrituresModeles;

   public EcrituresModelesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public EcrituresModeles insert(EcrituresModeles var1) throws HibernateException, NamingException {
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

   public EcrituresModeles insert(EcrituresModeles var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public EcrituresModeles modif(EcrituresModeles var1) throws HibernateException, NamingException {
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

   public EcrituresModeles modif(EcrituresModeles var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(EcrituresModeles var1) throws HibernateException, NamingException {
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

   public void delete(EcrituresModeles var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectModeles(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var2 = true;
      }

      List var3 = var1.createQuery("from EcrituresModeles order by modCode asc").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectModelesByNature(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var3 = true;
      }

      List var4 = var2.createQuery("from EcrituresModeles where modType=:typ order by modCode asc").setInteger("typ", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectModelesByJournal(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var3 = true;
      }

      List var4 = var2.createQuery("from EcrituresModeles where modJournal=:jr order by modCode asc").setString("jr", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public EcrituresModeles chargerModele(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var3 = true;
      }

      List var4 = var2.createQuery("from EcrituresModeles where modCode=:cod").setString("cod", var1).list();
      this.ecrituresModeles = new EcrituresModeles();
      if (var4.size() != 0) {
         this.ecrituresModeles = (EcrituresModeles)var4.get(0);
      } else {
         this.ecrituresModeles = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.ecrituresModeles;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Ecritures");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from EcrituresModeles where modCode=:cod").setString("cod", var1).setMaxResults(1);
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
