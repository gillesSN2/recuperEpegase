package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PatientContact;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PatientContactDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public PatientContactDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public PatientContact insert(PatientContact var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
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

   public PatientContact modif(PatientContact var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
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

   public PatientContact modif(PatientContact var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(PatientContact var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
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

   public PatientContact getpatientContactMedById(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      PatientContact var4 = (PatientContact)var3.get(PatientContact.class, var1);
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List getListpatientContactMed() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      List var2 = var1.createQuery("From PatientContact").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List chargerLesPatientsContact(Patients var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var3 = true;
      }

      List var4 = var2.createQuery("From PatientContact where patient=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesContactsEmail(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var4 = true;
      }

      List var5 = var3.createQuery("from PatientContact where patId='" + var1 + "' and patconMail like '%@%'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectPatientsEmail(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var2 = true;
      }

      List var3 = var1.createQuery("from PatientContact where patconMail like '%@%' ").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public PatientContact selectPatientsEmail(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var3 = true;
      }

      List var4 = var2.createQuery("from PatientContact where patconMail ='" + var1 + "'").list();
      PatientContact var5 = new PatientContact();
      if (var4.size() > 0) {
         var5 = (PatientContact)var4.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
