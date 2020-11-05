package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.PegTicket;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PegTicketDao implements Serializable {
   private Activites activites;
   private UtilInitHibernate utilInitHibernate;

   public PegTicketDao(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public PegTicket insert(PegTicket var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSystemeEPegase();
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

   public PegTicket modif(PegTicket var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSystemeEPegase();
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

   public PegTicket reponse(PegTicket var1) throws HibernateException, NamingException {
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

   public void delete(PegTicket var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getSystemeEPegase();
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

   public List rechercheTicketByStructure(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getSystemeEPegase();
         var5 = true;
      }

      List var6 = null;
      if (var3 == 100) {
         var6 = var4.createQuery("from PegTicket where pegticIdStructure=:str order by pegticDate asc").setLong("str", var1).list();
      } else {
         var6 = var4.createQuery("from PegTicket where pegticIdStructure=:str and pegticEtat=:et order by pegticDate asc").setLong("str", var1).setInteger("et", var3).list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheTicketPep(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getSysteme();
         var3 = true;
      }

      List var4 = null;
      if (var1 == 100) {
         var4 = var2.createQuery("from PegTicket where order by pegticDate asc").list();
      } else {
         var4 = var2.createQuery("from PegTicket where pegticEtat=:et order by pegticDate asc").setInteger("et", var1).list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
