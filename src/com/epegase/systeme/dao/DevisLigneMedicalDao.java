package com.epegase.systeme.dao;

import com.epegase.systeme.classe.DevisEnteteMedical;
import com.epegase.systeme.classe.DevisLigneMedical;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DevisLigneMedicalDao implements Serializable {
   private DevisLigneMedical devisLigneMedical;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public DevisLigneMedicalDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public DevisLigneMedical insert(DevisLigneMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEnteteMedical");
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

   public DevisLigneMedical insert(DevisLigneMedical var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public DevisLigneMedical modif(DevisLigneMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEnteteMedical");
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

   public DevisLigneMedical modif(DevisLigneMedical var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(DevisLigneMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEnteteMedical");
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

   public void delete(DevisLigneMedical var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteAllLigne(DevisEnteteMedical var1, Session var2) {
      var2.createQuery("delete from DevisLigneMedical where devisEnteteMedical=:id").setParameter("id", var1).executeUpdate();
   }

   public List selectConsActesByConsEnt(DevisEnteteMedical var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEnteteMedical");
         var3 = true;
      }

      List var4 = var2.createQuery("From DevisLigneMedical where devisEnteteMedical=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectConsActesByConsEnt(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEnteteMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("From DevisLigneMedical where devisEnteteMedical.dvsId=:param").setLong("param", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public DevisLigneMedical selectConsActes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEnteteMedical");
         var4 = true;
      }

      List var5 = var3.createQuery("From DevisLigneMedical where dvsligId=:param").setLong("param", var1).setMaxResults(1).list();
      this.devisLigneMedical = new DevisLigneMedical();
      if (var5.size() != 0) {
         this.devisLigneMedical = (DevisLigneMedical)var5.get(0);
      } else {
         this.devisLigneMedical = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.devisLigneMedical;
   }

   public List selectConsActesByConsEnt(DevisEnteteMedical var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEnteteMedical");
         var4 = true;
      }

      new ArrayList();
      List var5;
      if (var2 == 100) {
         var5 = var3.createQuery("From DevisLigneMedical where devisEnteteMedical=:param").setParameter("param", var1).list();
      } else if (var2 == 11) {
         var5 = var3.createQuery("From DevisLigneMedical where devisEnteteMedical=:param and (dvsligEtat=0 or dvsligEtat=1)").setParameter("param", var1).list();
      } else {
         var5 = var3.createQuery("From DevisLigneMedical where devisEnteteMedical=:param and dvsligEtat=:et").setParameter("param", var1).setInteger("et", var2).list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesLignesActes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEnteteMedical");
         var3 = true;
      }

      List var4 = var2.createQuery("from DevisLigneMedical where devisEnteteMedical.dvsNum in (" + var1 + ") order by dvsligLibelle").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvtsPatients(Patients var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEnteteMedical");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from DevisLigneMedical where devisEnteteMedical.Patients.patId=" + var1.getPatId() + " and devisEnteteMedical.dvsDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerDevisByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEnteteMedical");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from DevisLigneMedical where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
