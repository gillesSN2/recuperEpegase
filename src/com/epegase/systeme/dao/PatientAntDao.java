package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PatientAnt;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PatientAntDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public PatientAntDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public PatientAnt insert(PatientAnt var1) throws HibernateException, NamingException {
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

   public PatientAnt modif(PatientAnt var1) throws HibernateException, NamingException {
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

   public PatientAnt modif(PatientAnt var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(PatientAnt var1) throws HibernateException, NamingException {
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

   public PatientAnt getpatientAntecedentMedById(long var1) throws NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      PatientAnt var4 = (PatientAnt)var3.get(PatientAnt.class, var1);
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List getListpatientAntecedentMed() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      List var2 = var1.createQuery("From PatientAnt").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List chargerLesPatientsAntecedents(Patients var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var3 = true;
      }

      List var4 = var2.createQuery("From PatientAnt where patient=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
