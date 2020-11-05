package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PatientLettreGarantie;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PatientLettreGarantieDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public PatientLettreGarantieDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public PatientLettreGarantie insert(PatientLettreGarantie var1) throws HibernateException, NamingException {
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

   public PatientLettreGarantie insert(PatientLettreGarantie var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public PatientLettreGarantie modif(PatientLettreGarantie var1) throws HibernateException, NamingException {
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

   public PatientLettreGarantie modif(PatientLettreGarantie var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(PatientLettreGarantie var1) throws HibernateException, NamingException {
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

   public void delete(PatientLettreGarantie var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerLesLettresByPatients(Patients var1, int var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var5 = true;
      }

      String var6 = "";
      if (var3 == 9) {
         if (var2 == 9) {
            var6 = "From PatientLettreGarantie where patient=:pat and patlgaType!=:typ";
         } else {
            var6 = "From PatientLettreGarantie where patient=:pat and patlgaEtat= " + var2 + " and patlgaType!=:typ";
         }
      } else if (var2 == 9) {
         var6 = "From PatientLettreGarantie where patient=:pat and patlgaType=:typ";
      } else {
         var6 = "From PatientLettreGarantie where patient=:pat and patlgaEtat= " + var2 + " and patlgaType=:typ";
      }

      List var7 = var4.createQuery(var6).setParameter("pat", var1).setInteger("typ", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesLettresByTiers(Tiers var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var4 = true;
      }

      List var5 = var3.createQuery("From PatientLettreGarantie where tiers=:param and patlgaType=:typ").setParameter("param", var1).setInteger("typ", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public PatientLettreGarantie trouverLettreGarantie(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var4 = true;
      }

      new PatientLettreGarantie();
      List var6 = var3.createQuery("From PatientLettreGarantie where patlgaId=:trs").setLong("trs", var1).setMaxResults(1).list();
      PatientLettreGarantie var5;
      if (var6.size() != 0) {
         var5 = (PatientLettreGarantie)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public PatientLettreGarantie trouverLettreGarantie(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var4 = true;
      }

      new PatientLettreGarantie();
      List var6 = var3.createQuery("From PatientLettreGarantie where patlgaNum=:trs and patlgaType=:typ").setString("trs", var1).setInteger("typ", var2).setMaxResults(1).list();
      PatientLettreGarantie var5;
      if (var6.size() != 0) {
         var5 = (PatientLettreGarantie)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
