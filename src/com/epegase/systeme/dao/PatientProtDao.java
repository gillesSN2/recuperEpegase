package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PatientProt;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PatientProtDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public PatientProtDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public PatientProt insert(PatientProt var1) throws HibernateException, NamingException {
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

   public PatientProt modif(PatientProt var1) throws HibernateException, NamingException {
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

   public PatientProt modif(PatientProt var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(PatientProt var1) throws HibernateException, NamingException {
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

   public PatientProt getpatientProtMedById(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      PatientProt var4 = (PatientProt)var3.get(PatientProt.class, var1);
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List getListpatientProtMed() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      List var2 = var1.createQuery("From PatientProt").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List chargerLesPatientsProtocles(Patients var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var3 = true;
      }

      List var4 = var2.createQuery("From PatientProt where patient=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesPatientsProtoclesItems(Patients var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var3 = true;
      }

      ArrayList var4 = new ArrayList();
      List var5 = var2.createQuery("From PatientProt where patient=:param").setParameter("param", var1).list();
      if (var5.size() != 0) {
         for(int var6 = 0; var6 < var5.size(); ++var6) {
            var4.add(new SelectItem(((PatientProt)var5.get(var6)).getPatprtCode() + ":" + ((PatientProt)var5.get(var6)).getPatprtLibelle()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
