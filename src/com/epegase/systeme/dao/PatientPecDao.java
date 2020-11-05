package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PatientPec;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PatientPecDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public PatientPecDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public PatientPec insert(PatientPec var1) throws HibernateException, NamingException {
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

   public PatientPec insert(PatientPec var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public PatientPec modif(PatientPec var1) throws HibernateException, NamingException {
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

   public PatientPec modif(PatientPec var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(PatientPec var1) throws HibernateException, NamingException {
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

   public void delete(PatientPec var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public PatientPec getpatientPecMedById(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      PatientPec var4 = (PatientPec)var3.get(PatientPec.class, var1);
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List getListPatientPecMed() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      List var2 = var1.createQuery("From PatientPec").list();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List chargerLesPatientsPec(Patients var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var4 = true;
      }

      List var5 = null;
      if (var2 == 0) {
         var5 = var3.createQuery("From PatientPec where patient=:param and tiers.tieconventiongele = false order by patpecId DESC").setParameter("param", var1).list();
      } else if (var2 == 1) {
         var5 = var3.createQuery("From PatientPec where patient=:param and tiers.tieconventiongele = true order by patpecId DESC").setParameter("param", var1).list();
      } else {
         var5 = var3.createQuery("From PatientPec where patient=:param order by patpecId DESC").setParameter("param", var1).list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesPatientsPec(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var2 = true;
      }

      List var3 = var1.createQuery("From PatientPec order by patpecId DESC").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesPatientsPecActive(Patients var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var3 = true;
      }

      List var4 = var2.createQuery("From PatientPec where patient=:param and tiers.tieconventiongele = false and tiers.tielettregarantie = false order by patpecId DESC").setParameter("param", var1).list();
      ArrayList var5 = new ArrayList();
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((PatientPec)var4.get(var6)).getTiers().getTieid(), ((PatientPec)var4.get(var6)).getTiers().getTieraisonsocialenom()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesPatientsTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var3 = true;
      }

      List var4 = var2.createQuery("From PatientPec where tiers=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesPatientsTiersNull(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var2 = true;
      }

      List var3 = var1.createQuery("From PatientPec where tiers is null").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public PatientPec trouverPatientsPec(Patients var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var5 = true;
      }

      new PatientPec();
      PatientPec var6;
      List var7;
      if (var2 != 0L) {
         var7 = var4.createQuery("From PatientPec where patient=:param and tie_id=:trs").setParameter("param", var1).setLong("trs", var2).list();
         if (var7.size() != 0) {
            var6 = (PatientPec)var7.get(0);
         } else {
            var6 = null;
         }
      } else {
         var6 = null;
         var7 = var4.createQuery("From PatientPec where patient=:param order by patpecId").setParameter("param", var1).list();
         if (var7.size() != 0) {
            for(int var8 = 0; var8 < var7.size(); ++var8) {
               if (((PatientPec)var7.get(var8)).getPatpecInactif() == 0) {
                  var6 = (PatientPec)var7.get(var8);
                  break;
               }
            }
         } else {
            var6 = null;
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public PatientPec trouverPatientsPec(Patients var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var4 = true;
      }

      PatientPec var5 = null;
      List var6 = var3.createQuery("From PatientPec where patient=:param").setParameter("param", var1).list();
      if (var6.size() != 0) {
         for(int var7 = 0; var7 < var6.size(); ++var7) {
            var5 = new PatientPec();
            if (((PatientPec)var6.get(var7)).getTiers().getTieraisonsocialenom().contains(var2)) {
               var5 = (PatientPec)var6.get(var7);
               break;
            }
         }
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public PatientPec trouverPatientsPec(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var5 = true;
      }

      new PatientPec();
      List var7 = null;
      if (var3 == 0) {
         var7 = var4.createQuery("From PatientPec where patpecId=:trs and tiers.tieconventiongele = false").setLong("trs", var1).setMaxResults(1).list();
      } else if (var3 == 1) {
         var7 = var4.createQuery("From PatientPec where patpecId=:trs  and tiers.tieconventiongele = true").setLong("trs", var1).setMaxResults(1).list();
      } else {
         var7 = var4.createQuery("From PatientPec where patpecId=:trs").setLong("trs", var1).setMaxResults(1).list();
      }

      PatientPec var6;
      if (var7.size() != 0) {
         var6 = (PatientPec)var7.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List getListPatientPecMedByPatDate(Patients var1, Date var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      List var4 = var3.createQuery("From PatientPec where patient=:param and patpecDateDebut <=:param1  and patpecDateFin >=:param2 ").setParameter("param", var1).setParameter("param1", var2).setParameter("param2", var2).list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List chargerListPatients(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var3 = true;
      }

      new ArrayList();
      List var4 = var2.createQuery(var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
