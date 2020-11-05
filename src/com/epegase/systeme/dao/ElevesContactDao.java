package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ElevesContact;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ElevesContactDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ElevesContactDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ElevesContact insert(ElevesContact var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public ElevesContact modif(ElevesContact var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public void delete(ElevesContact var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public ElevesContact getElevesContactMedById(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
      ElevesContact var4 = (ElevesContact)var3.get(ElevesContact.class, var1);
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List getListElevesContactMed() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
      List var2 = var1.createQuery("From ElevesContact").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List chargerLesElevesContact(Eleves var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var3 = true;
      }

      List var4 = var2.createQuery("From ElevesContact where eleves=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesContactsEmail(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var4 = true;
      }

      List var5 = var3.createQuery("from ElevesContact where eleId='" + var1 + "' and eleconMail like '%@%'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectElevesEmail(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var2 = true;
      }

      List var3 = var1.createQuery("from ElevesContact where eleconMail like '%@%' ").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public ElevesContact selectElevesEmail(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var3 = true;
      }

      List var4 = var2.createQuery("from ElevesContact where eleconMail ='" + var1 + "'").list();
      ElevesContact var5 = new ElevesContact();
      if (var4.size() > 0) {
         var5 = (ElevesContact)var4.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
